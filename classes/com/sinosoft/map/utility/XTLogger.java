// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XTLogger.java

package com.sinosoft.map.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class XTLogger
{

	public XTLogger()
	{
	}

	public static Logger getLogger(String className)
	{
		return Logger.getLogger(className);
	}

	public static Logger getLogger(Class className)
	{
		return Logger.getLogger(className);
	}

	public static void main(String args[])
	{
		XTLogger XTLogger1 = new XTLogger();
		Logger log = getLogger(com/sinosoft/map/utility/XTLogger);
		log.info(".......");
		log.info(".......");
	}

	static 
	{
		DOMConfigurator.configure(com/sinosoft/map/utility/XTLogger.getResource("../../../AutoPayLog4j.xml"));
	}
}
