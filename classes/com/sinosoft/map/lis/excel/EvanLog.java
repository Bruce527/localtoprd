// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EvanLog.java

package com.sinosoft.map.lis.excel;

import java.io.*;
import java.util.Date;

public class EvanLog
{

	private static EvanLog logger = new EvanLog();
	private static String filePath = "e:\\tmp\\log.txt";

	private EvanLog()
	{
	}

	public static EvanLog getLoger()
	{
		return logger;
	}

	public void log(String message)
	{
		message = (new StringBuilder("[")).append(new Date()).append("] ").append(message).append("\n").toString();
		try
		{
			OutputStream out = new FileOutputStream(filePath, true);
			out.write(message.getBytes());
			out.flush();
			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	protected void finalize()
		throws Throwable
	{
	}

}
