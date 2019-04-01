// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysLog.java

package com.sinosoft.map.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class SysLog
{

	private static String DEFAULT_LOGGER;
	public static Logger logger;
	public static final int OFF = 0x7fffffff;
	public static final int FATAL = 50000;
	public static final int ERROR = 40000;
	public static final int WARN = 30000;
	public static final int INFO = 20000;
	public static final int DEBUG = 10000;
	public static final int ALL = 0x80000000;

	public SysLog()
	{
	}

	private static Priority getPriority(int nPriority)
	{
		Priority priority = null;
		switch (nPriority)
		{
		case 2147483647: 
			priority = Priority.toPriority(0x7fffffff);
			break;

		case 50000: 
			priority = Priority.FATAL;
			break;

		case 40000: 
			priority = Priority.ERROR;
			break;

		case 30000: 
			priority = Priority.WARN;
			break;

		case 20000: 
			priority = Priority.INFO;
			break;

		case 10000: 
			priority = Priority.DEBUG;
			break;

		case -2147483648: 
			priority = Priority.toPriority(0x80000000);
			break;
		}
		return priority;
	}

	public static Logger getLogger(String className)
	{
		return Logger.getLogger(className);
	}

	public static Logger getLogger(Class className)
	{
		return Logger.getLogger(className);
	}

	public static void log(Object obj)
	{
		logger.info(obj);
	}

	public static void log(String strMessage)
	{
		logger.info(strMessage);
	}

	public static void log(int n)
	{
		logger.info(String.valueOf(n));
	}

	public static void log(float f)
	{
		logger.info(String.valueOf(f));
	}

	public static void log(double d)
	{
		logger.info(String.valueOf(d));
	}

	public static void log(int nLevel, Object obj)
	{
		logger.log(getPriority(nLevel), obj);
	}

	public static void log(int nLevel, String strMessage)
	{
		logger.log(getPriority(nLevel), strMessage);
	}

	public static void log(int nLevel, int n)
	{
		logger.log(getPriority(nLevel), String.valueOf(n));
	}

	public static void log(int nLevel, float f)
	{
		logger.log(getPriority(nLevel), String.valueOf(f));
	}

	public static void log(int nLevel, double d)
	{
		logger.log(getPriority(nLevel), String.valueOf(d));
	}

	public static void main(String args[])
	{
		SysLog sysLog = new SysLog();
		Logger log = getLogger(com/sinosoft/map/utility/SysLog);
		log.info(".......");
		log.info("///////");
		log = getLogger("com.sinosoft.map.utility");
		log.info("com.sinosoft.map.utility");
	}

	static 
	{
		DEFAULT_LOGGER = "com.sinosoft.map.utility";
		logger = getLogger(DEFAULT_LOGGER);
	}
}
