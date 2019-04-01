// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AccessauthConfig.java

package com.sinosoft.map.common.config;

import com.sinosoft.map.common.WebVisitor;
import com.sinosoft.map.common.logs.ErrorsLog;
import com.sinosoft.map.ec.utility.XmlParser;
import java.io.PrintStream;
import java.util.*;
import org.w3c.dom.*;

// Referenced classes of package com.sinosoft.map.common.config:
//			BaseConfig

public class AccessauthConfig extends BaseConfig
{

	private Map _auths;

	public AccessauthConfig(String authsPath)
	{
		init(authsPath);
	}

	public String toString()
	{
		return "Auth.class";
	}

	public boolean isAllow(String uri, WebVisitor visitor)
	{
		boolean isOk = true;
		if (_auths != null)
		{
			Set keys = _auths.keySet();
			for (Iterator iterator = keys.iterator(); iterator.hasNext();)
			{
				String key = (String)iterator.next();
				System.out.println((new StringBuilder(String.valueOf(uri))).append("--------------------------").append(key).toString());
				if (uri.indexOf(key) != -1)
				{
					if (visitor == null || !visitor.isLogin())
						return false;
					isOk = true;
				}
			}

		}
		return isOk;
	}

	public Map getAuths()
	{
		return _auths;
	}

	private void init(String authsPath)
	{
		try
		{
			_auths = new HashMap();
			Document doc = XmlParser.getDocument(authsPath);
			Element root = doc.getDocumentElement();
			NodeList authorizations = root.getElementsByTagName("auth");
			for (int i = 0; i < authorizations.getLength(); i++)
			{
				Element auth = (Element)authorizations.item(i);
				String uri = auth.getElementsByTagName("uri").item(0).getTextContent().trim();
				List groupsList = new ArrayList();
				Element userGroups = (Element)auth.getElementsByTagName("groups").item(0);
				NodeList groups = userGroups.getElementsByTagName("group");
				for (int n = 0; n < groups.getLength(); n++)
				{
					String group = groups.item(n).getTextContent().trim();
					if (group != null)
						groupsList.add(group);
				}

				_auths.put(uri, groupsList);
			}

		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:Auth:init:")).append(e.getMessage()).toString());
		}
	}

	public void showState()
	{
		Set keys = _auths.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();)
		{
			String key = (String)iterator.next();
			System.out.println((new StringBuilder("--key:")).append(key).toString());
			List groups = (List)_auths.get(key);
			String group;
			for (Iterator iterator1 = groups.iterator(); iterator1.hasNext(); System.out.println((new StringBuilder("group:")).append(group).toString()))
				group = (String)iterator1.next();

		}

	}
}
