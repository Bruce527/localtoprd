// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GetConfig.java

package com.sinosoft.banklns.utility;

import java.io.PrintStream;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class GetConfig
{

	private static ResourceBundle bundle = null;

	public GetConfig()
	{
	}

	public static void main(String args[])
	{
		System.out.println(getString("remotelistenerservlet.ip"));
		System.out.println(getString("downfile.path"));
	}

	public static ResourceBundle getResourceBundle()
	{
		if (bundle == null)
			bundle = ResourceBundle.getBundle("resources.suggest");
		return bundle;
	}

	public static String getString(String key)
	{
		String value = null;
		try
		{
			value = getResourceBundle().getString(key);
		}
		catch (MissingResourceException e)
		{
			System.out.println((new StringBuilder("java.util.MissingResourceException: Couldn't find value for: ")).append(key).toString());
		}
		if (value == null)
			value = (new StringBuilder("Could not find resource: ")).append(key).append("  ").toString();
		return value;
	}

}
