// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserContextUtils.java

package com.ibm.filenet.login;

import com.filenet.api.core.Connection;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.exception.ExceptionCode;
import com.filenet.api.util.UserContext;
import javax.security.auth.Subject;

public class UserContextUtils
{

	public UserContextUtils()
	{
	}

	public static Subject authenticate(Connection connection, String userName, String password, String stanzaName)
	{
		Subject subject = UserContext.createSubject(connection, userName, password, stanzaName);
		return subject;
	}

	public static void pushSubject(Subject subject)
	{
		UserContext uc = UserContext.get();
		try
		{
			uc.pushSubject(subject);
		}
		catch (EngineRuntimeException e)
		{
			if (e.getExceptionCode() == ExceptionCode.E_NULL_OR_INVALID_PARAM_VALUE)
				throw new RuntimeException("登录过期", e);
			else
				throw e;
		}
	}

	public static Subject popSubject()
	{
		UserContext uc = UserContext.get();
		return uc.popSubject();
	}
}
