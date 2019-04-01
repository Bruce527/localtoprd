// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ErrorsLog.java

package com.sinosoft.map.common.logs;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ErrorsLog
{

	public static boolean isTrack = true;
	public static boolean isDebug = true;
	public static String debugOpt = "console";
	public static List errorMessages = new ArrayList();

	public ErrorsLog()
	{
	}

	public static synchronized void log(String message)
	{
		if (!isTrack)
		{
			return;
		} else
		{
			errorMessages.add(message);
			return;
		}
	}

	public static void debug(String message)
	{
		if (!isDebug)
			return;
		if (debugOpt.equals("console"))
			System.out.println((new StringBuilder("debug:")).append(message).toString());
		else
		if (debugOpt.equals("file"))
			log((new StringBuilder("debug:")).append(message).toString());
	}

	public static synchronized void errorLogs(List errorMessages)
	{
		try
		{
			File logPath = new File(getErrorsLogPath());
			if (!logPath.exists())
				logPath.mkdirs();
			Date theDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fileName = (new StringBuilder("log")).append(sdf.format(theDate)).append(".txt").toString();
			sdf.applyPattern("HH:mm:ss");
			String nowTime = sdf.format(theDate);
			File logFile = new File(logPath, fileName);
			FileWriter fw = null;
			fw = new FileWriter(logFile, true);
			String message;
			for (Iterator errorIT = errorMessages.iterator(); errorIT.hasNext(); fw.write((new StringBuilder(String.valueOf(message))).append("\r\n").toString()))
			{
				message = (String)errorIT.next();
				fw.write((new StringBuilder("Log:[")).append(nowTime).append("]").toString());
			}

			fw.flush();
			fw.close();
		}
		catch (IOException ioe)
		{
			System.out.println("Errorslog:创建错误日志文件失败");
		}
	}

	private static String getErrorsLogPath()
	{
		String sql = "select varvalue from msysvar where vartype='logsPath' ";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		String path = tSSRS.GetText(1, 1);
		path = (new StringBuilder(String.valueOf(path))).append(File.separator).append("web").append(File.separator).append("errorslog").toString();
		return path;
	}

}
