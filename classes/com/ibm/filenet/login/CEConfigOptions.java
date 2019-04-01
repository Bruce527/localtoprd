// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CEConfigOptions.java

package com.ibm.filenet.login;

import java.util.ResourceBundle;
import org.apache.commons.lang.StringUtils;

public class CEConfigOptions
{

	private static final ResourceBundle CONFIG_BUNDLE = ResourceBundle.getBundle("conf/p8");

	public CEConfigOptions()
	{
	}

	public static String val(String key)
	{
		return CONFIG_BUNDLE.getString(key);
	}

	public static String getCeUrl()
	{
		return val("ce.connectionURL");
	}

	public static String getDomainName()
	{
		return val("ce.domainName");
	}

	public static String[] getObjectStores()
	{
		String str = val("ce.objectStoreNames");
		if (StringUtils.isNotEmpty(str))
			return str.split(",");
		else
			return new String[0];
	}

	public static int getSearchMaxPageSize()
	{
		int pageSize = Integer.valueOf(val("ce.searchcount")).intValue();
		if (pageSize > 1000)
			pageSize = 1000;
		return pageSize;
	}

}
