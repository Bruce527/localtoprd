// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BaseConfig.java

package com.sinosoft.map.common.config;


// Referenced classes of package com.sinosoft.map.common.config:
//			AbstractConfig

public class BaseConfig extends AbstractConfig
{

	public BaseConfig()
	{
	}

	public String getBundle()
	{
		return "com.sinosoft.map.international.resource.programresource";
	}

	public String getStringByID(String sid, Object params[])
	{
		return getBundleString(getBundle(), sid, params);
	}

	public String getDatabase()
	{
		return null;
	}
}
