// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PropertiesToolFun.java

package com.sinosoft.banklns.utility;

import java.io.IOException;
import java.util.Properties;

public class PropertiesToolFun
{

	public PropertiesToolFun()
	{
	}

	public static Properties getInitPropertiesData(Class name, String perDoc)
	{
		Properties properties = new Properties();
		java.io.InputStream in = name.getResourceAsStream(perDoc);
		try
		{
			properties.load(in);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return properties;
	}
}
