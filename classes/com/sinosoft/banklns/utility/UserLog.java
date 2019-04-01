// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserLog.java

package com.sinosoft.banklns.utility;

import java.io.*;

// Referenced classes of package com.sinosoft.banklns.utility:
//			ConfigInfo, StrTool

public class UserLog
{

	private static String strUserLogFileName = ConfigInfo.GetValuebyName("userlogpath");
	private static String strSysLogFileName = ConfigInfo.GetValuebyName("syslogpath");

	public UserLog()
	{
		String userLogExtendsion = strUserLogFileName.substring(strUserLogFileName.indexOf("."));
		String strDate = StrTool.getDate();
		String strDateYear = strDate.substring(0, strDate.indexOf("/"));
		strDate = strDate.substring(strDate.indexOf("/") + 1);
		String strDateMonth = strDate.substring(0, strDate.indexOf("/"));
		strDate = strDate.substring(strDate.indexOf("/") + 1);
		String strDateDay = strDate;
		if (strUserLogFileName.indexOf("(") == -1 && strUserLogFileName.indexOf(")") == -1)
			strUserLogFileName = (new StringBuilder(String.valueOf(strUserLogFileName.substring(0, strUserLogFileName.indexOf("."))))).append("(").append(strDateYear).append("_").append(strDateMonth).append("_").append(strDateDay).append(")").append(userLogExtendsion).toString();
		String sysLogExtendsion = strSysLogFileName.substring(strSysLogFileName.indexOf("."));
		strDate = StrTool.getDate();
		strDateYear = strDate.substring(0, strDate.indexOf("/"));
		strDate = strDate.substring(strDate.indexOf("/") + 1);
		strDateMonth = strDate.substring(0, strDate.indexOf("/"));
		strDate = strDate.substring(strDate.indexOf("/") + 1);
		strDateDay = strDate;
		if (strSysLogFileName.indexOf("(") == -1 && strSysLogFileName.indexOf(")") == -1)
			strSysLogFileName = (new StringBuilder(String.valueOf(strSysLogFileName.substring(0, strSysLogFileName.indexOf("."))))).append("(").append(strDateYear).append("_").append(strDateMonth).append("_").append(strDateDay).append(")").append(sysLogExtendsion).toString();
	}

	public UserLog(String AllLogPath)
	{
		strUserLogFileName = AllLogPath;
		strSysLogFileName = AllLogPath;
	}

	public UserLog(String UserLogPath, String SysLogPath)
	{
		strUserLogFileName = UserLogPath;
		strSysLogFileName = SysLogPath;
	}

	public static int generateTempFile(String strFileName, String strValue)
	{
		String strFileValue = strValue;
		try
		{
			RandomAccessFile in = new RandomAccessFile(strFileName, "rw");
			in.write(strFileValue.getBytes());
			in.close();
		}
		catch (IOException exception)
		{
			System.out.print(exception.toString());
			return -1;
		}
		return 0;
	}

	private static int print(String strValue)
	{
		try
		{
			RandomAccessFile in = new RandomAccessFile(strUserLogFileName, "rw");
			in.seek(in.length());
			in.write(strValue.getBytes());
			in.write(13);
			in.write(10);
			in.close();
		}
		catch (IOException exception)
		{
			System.out.print(exception.toString());
			return -1;
		}
		return 0;
	}

	public static int print(int intValue)
	{
		return print((new StringBuilder()).append(intValue).toString());
	}

	public static int print(double doubleValue)
	{
		return print((new StringBuilder()).append(doubleValue).toString());
	}

	public static int print(Object object)
	{
		return print((new StringBuilder()).append(object.toString()).toString());
	}

	public static int println(String strValue)
	{
		String finalstrValue = null;
		finalstrValue = (new StringBuilder("<")).append(StrTool.getDate()).append(" ").append(StrTool.getTime()).append(">").append(strValue).append("\n").toString();
		return print(finalstrValue);
	}

	public static int println(int intValue)
	{
		String finalstrValue = null;
		finalstrValue = (new StringBuilder("<")).append(StrTool.getDate()).append(" ").append(StrTool.getTime()).append(">").append(intValue).append("\n").toString();
		return print(finalstrValue);
	}

	public static int println(double doubleValue)
	{
		String finalstrValue = null;
		finalstrValue = (new StringBuilder("<")).append(StrTool.getDate()).append(" ").append(StrTool.getTime()).append(">").append(doubleValue).append("\n").toString();
		return print(finalstrValue);
	}

	public static int println(Object object)
	{
		String finalstrValue = null;
		finalstrValue = (new StringBuilder("<")).append(StrTool.getDate()).append(" ").append(StrTool.getTime()).append(">").append(object.toString()).append("\n").toString();
		return print(finalstrValue);
	}

	private static int printException(String strValue)
	{
		String strLog = (new StringBuilder("<")).append(StrTool.getDate()).append(" ").append(StrTool.getTime()).append(">").append(strValue).append("\n").toString();
		try
		{
			RandomAccessFile in = new RandomAccessFile(strSysLogFileName, "rw");
			in.seek(in.length());
			in.write(strLog.getBytes());
			in.write(13);
			in.write(10);
			in.close();
		}
		catch (IOException exception)
		{
			System.out.print(exception.toString());
			return -1;
		}
		return 0;
	}

	public static int printException(int intValue)
	{
		return printException((new StringBuilder()).append(intValue).toString());
	}

	public static int printException(double doubleValue)
	{
		return printException((new StringBuilder()).append(doubleValue).toString());
	}

	public static int printException(Object object)
	{
		return printException((new StringBuilder()).append(object.toString()).toString());
	}

	public static int addUserLog(String strLog)
	{
		return println(strLog);
	}

	public static int addSysLog(String strLog)
	{
		return printException(strLog);
	}

	public static String getDefaultPath()
	{
		File defaultPath = new File(".");
		return defaultPath.getAbsolutePath();
	}

	private static int readTest()
	{
		try
		{
			RandomAccessFile in = new RandomAccessFile(strUserLogFileName, "rw");
			for (int tRead = 0; tRead != -1;)
			{
				tRead = in.read();
				System.out.println(tRead);
			}

			in.close();
		}
		catch (IOException exception)
		{
			System.out.print(exception.toString());
			return -1;
		}
		return 0;
	}

	public static void main(String args[])
	{
		System.out.println("Start");
		UserLog testUserLog = new UserLog();
		System.out.println("File save successful");
		System.out.println(getDefaultPath());
	}

}
