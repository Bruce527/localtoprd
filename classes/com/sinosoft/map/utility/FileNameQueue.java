// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FileNameQueue.java

package com.sinosoft.map.utility;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameQueue
{

	public static final String LINE = "/";
	public static final String LINE2 = "-";
	public static final String PATTERN = "yyMMddHHmm";
	public static final String XML = ".xml";
	public static final String PRE = "Pre";
	public static final String XML_PRE = ".xmlPre";
	private static int nHead = 0;

	public FileNameQueue()
	{
	}

	public static synchronized String getFileName(String filepath, String templateOp)
	{
		StringBuffer sb = new StringBuffer(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
		String dateStr = sdf.format(new Date());
		String fileName = null;
		do
		{
			if (nHead != 0x7fffffff)
				nHead++;
			else
				nHead = 0;
			sb.setLength(0);
			sb.append(templateOp);
			sb.append(dateStr);
			sb.append("-");
			sb.append(nHead);
			fileName = sb.toString();
		} while (!canUseName(filepath, fileName));
		return fileName;
	}

	public static synchronized boolean canUseName(String filepath, String fileName)
	{
		StringBuffer sb = new StringBuffer(0);
		sb.setLength(0);
		sb.append(filepath);
		sb.append("/");
		sb.append(fileName);
		sb.append(".xml");
		String fullFileName = sb.toString();
		sb.append("Pre");
		String fullFileNamePre = sb.toString();
		sb.setLength(0);
		File f = new File(fullFileName);
		File fPre = new File(fullFileNamePre);
		return !f.exists() && !fPre.exists();
	}

	public static synchronized boolean rename(String filepath, String fileName)
	{
		boolean b = false;
		StringBuffer sb = new StringBuffer(0);
		sb.setLength(0);
		sb.append(filepath);
		sb.append("/");
		sb.append(fileName);
		sb.append(".xml");
		String fullFileName = sb.toString();
		sb.append("Pre");
		String fullFileNamePre = sb.toString();
		sb.setLength(0);
		File f = new File(fullFileName);
		File fPre = new File(fullFileNamePre);
		if (fPre.exists())
			b = fPre.renameTo(f);
		return b;
	}

	public static void main(String args[])
	{
		System.out.println(rename("C:\\nclprint", "Contract-001-2005-08-29-14-06-1"));
	}

}
