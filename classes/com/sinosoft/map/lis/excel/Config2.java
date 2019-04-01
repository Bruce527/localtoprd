// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Config2.java

package com.sinosoft.map.lis.excel;

import java.io.*;
import java.util.Properties;

// Referenced classes of package com.sinosoft.map.lis.excel:
//			EvanLog

class Config2
{

	Config2()
	{
	}

	public static String getTempletPath()
	{
		return get("TEMPLET_PATH");
	}

	public static String getWorkPath()
	{
		return get("WORK_PATH");
	}

	public static String get(String name)
	{
		String value;
		File file;
		Properties p;
		FileInputStream in;
		File f = new File("s");
		int i = f.getAbsolutePath().lastIndexOf(File.separator);
		System.out.println((new StringBuilder("当前路径：")).append(f.getAbsolutePath().substring(0, i)).toString());
		f = null;
		value = null;
		file = new File("report.properties");
		if (!file.exists())
			System.out.println((new StringBuilder("在当前目录下找不到")).append(file.getName()).append("文件").toString());
		p = new Properties();
		in = null;
		in = new FileInputStream(file);
		p.load(in);
		value = p.getProperty(name);
		break MISSING_BLOCK_LABEL_230;
		FileNotFoundException e;
		e;
		e.printStackTrace();
		if (in != null)
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		break MISSING_BLOCK_LABEL_250;
		e;
		e.printStackTrace();
		if (in != null)
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		break MISSING_BLOCK_LABEL_250;
		Exception exception;
		exception;
		if (in != null)
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		throw exception;
		if (in != null)
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		return value;
	}

	public static void main(String args[])
	{
		File f = new File("sfd");
		int i = f.getAbsolutePath().lastIndexOf(File.separator);
		System.out.println((new StringBuilder("当前路径：")).append(f.getAbsolutePath().substring(0, i)).toString());
		File file = new File(f.getAbsolutePath().substring(0, i));
		File files[] = file.listFiles();
		System.out.println(files.length);
		EvanLog logger = EvanLog.getLoger();
		logger.log("Config2------for start");
		for (int i2 = 0; i2 < files.length; i2++)
			System.out.println(files[i2].getName());

		logger.log("Config2------for end");
	}
}
