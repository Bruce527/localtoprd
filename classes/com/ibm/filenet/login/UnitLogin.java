// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UnitLogin.java

package com.ibm.filenet.login;

import com.filenet.api.core.*;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.exception.ExceptionCode;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.Subject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

// Referenced classes of package com.ibm.filenet.login:
//			CEConfigOptions, DomainProvider, UserContextUtils

public class UnitLogin
{

	private static Logger logger = Logger.getLogger(com/ibm/filenet/login/UnitLogin);
	private Subject subject;
	private static String ceUrl = CEConfigOptions.getCeUrl();
	private static String domainName = CEConfigOptions.getDomainName();
	private static String defaultOsNames[] = CEConfigOptions.getObjectStores();
	private Map objectStores;

	public UnitLogin()
	{
		subject = null;
	}

	public Subject login(String userName, String passWord)
	{
		return login(userName, passWord, new String[0]);
	}

	public Subject login(String userName, String passWord, String osName)
	{
		return login(userName, passWord, new String[] {
			osName
		});
	}

	public Subject login(String userName, String passWord, String osNames[])
	{
		logout();
		try
		{
			DomainProvider dp = DomainProvider.getInstance();
			Connection connection = getConnection(userName, passWord);
			objectStores = new HashMap();
			if (osNames == null || osNames.length == 0)
				osNames = defaultOsNames;
			for (int i = 0; i < osNames.length; i++)
			{
				String osName = osNames[i];
				if (StringUtils.isNotEmpty(osName))
				{
					ObjectStore os;
					try
					{
						os = dp.fetchObjectStore(connection, domainName, osName);
					}
					catch (EngineRuntimeException e)
					{
						if (e.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND)
							throw new RuntimeException((new StringBuilder("ObjectStore \"")).append(osName).append("\" not found").toString(), e);
						else
							throw e;
					}
					objectStores.put(osName, os);
				}
			}

			logger.info("----Login Success!");
		}
		catch (Throwable e)
		{
			throw new RuntimeException((new StringBuilder("----Login Fail!")).append(e.getLocalizedMessage()).toString(), e);
		}
		return subject;
	}

	private Connection getConnection(String userName, String passWord)
	{
		Connection connection = null;
		try
		{
			if (subject == null)
			{
				String url = ceUrl;
				logger.info((new StringBuilder("----Login to CE: ")).append(url).toString());
				connection = com.filenet.api.core.Factory.Connection.getConnection(url);
				subject = UserContextUtils.authenticate(connection, userName, passWord, null);
			}
			UserContextUtils.pushSubject(subject);
		}
		catch (EngineRuntimeException erex)
		{
			erex.printStackTrace();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return connection;
	}

	public static void logout()
	{
		UserContextUtils.popSubject();
	}

	public Map getObjectStores()
	{
		return objectStores;
	}

	public ObjectStore getObjectStore(String osName)
	{
		return (ObjectStore)objectStores.get(osName);
	}

}
