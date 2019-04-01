// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExcelUtil.java

package com.sinosoft.map.lis.excel;

import java.io.File;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.lis.excel:
//			ExcelInfo, Config, ZipInfo, EvanLog

class ExcelUtil
{

	ExcelUtil()
	{
	}

	public static ExcelInfo prepare(String name, long usefulLifeSecs)
	{
		ExcelInfo result = new ExcelInfo();
		StringBuffer sb = new StringBuffer();
		File file = new File(Config.getWorkPath());
		String workPath = file.getAbsolutePath();
		if (!file.exists())
			file.mkdirs();
		sb.append(workPath);
		sb.append(File.separator);
		sb.append(name);
		File file2 = new File(sb.toString());
		if (file2.exists())
		{
			long modifyTime = file2.lastModified();
			long now = System.currentTimeMillis();
			long diff = now - modifyTime;
			if (diff < usefulLifeSecs * 1000L)
			{
				result.excelExists = true;
				result.modifyTime = modifyTime;
			} else
			{
				result.excelExists = false;
			}
		} else
		{
			result.excelExists = false;
		}
		result.excelPath = sb.toString();
		if (result.excelExists)
			System.out.println((new StringBuilder("找到有效的Excel文件----")).append(name).toString());
		else
			System.out.println((new StringBuilder("没找到有效的Excel文件----")).append(name).toString());
		return result;
	}

	public static ExcelInfo prepare1(String name, long usefulLifeSecs, String filepath)
	{
		System.out.println("enter into prepare1");
		ExcelInfo result = new ExcelInfo();
		StringBuffer sb = new StringBuffer();
		File file = new File(filepath);
		String workPath = file.getAbsolutePath();
		if (!file.exists())
			file.mkdirs();
		sb.append(workPath);
		sb.append(File.separator);
		sb.append(name);
		File file2 = new File(sb.toString());
		if (file2.exists())
		{
			long modifyTime = file2.lastModified();
			long now = System.currentTimeMillis();
			long diff = now - modifyTime;
			if (diff < usefulLifeSecs * 1000L)
			{
				result.excelExists = true;
				result.modifyTime = modifyTime;
			} else
			{
				result.excelExists = false;
			}
		} else
		{
			result.excelExists = false;
		}
		result.excelPath = sb.toString();
		if (result.excelExists)
			System.out.println((new StringBuilder("找到有效的Excel文件----")).append(name).toString());
		else
			System.out.println((new StringBuilder("没找到有效的Excel文件----")).append(name).toString());
		return result;
	}

	public static ZipInfo prepare1(String name, long usefulLifeSecs)
	{
		ZipInfo result = new ZipInfo();
		StringBuffer sb = new StringBuffer();
		File file = new File(Config.getWorkPath());
		String workPath = file.getAbsolutePath();
		if (!file.exists())
			file.mkdirs();
		sb.append(workPath);
		sb.append(File.separator);
		sb.append(name);
		File file2 = new File(sb.toString());
		if (file2.exists())
		{
			long modifyTime = file2.lastModified();
			long now = System.currentTimeMillis();
			long diff = now - modifyTime;
			if (diff < usefulLifeSecs * 1000L)
			{
				result.zipExists = true;
				result.modifyTime = modifyTime;
			} else
			{
				result.zipExists = false;
			}
		} else
		{
			result.zipExists = false;
		}
		result.zipName = name;
		result.zipPath = sb.toString();
		if (result.zipExists)
			System.out.println((new StringBuilder("找到有效的zip文件----")).append(name).toString());
		else
			System.out.println((new StringBuilder("没找到有效的zip文件----")).append(name).toString());
		return result;
	}

	public static String getTempletPath(String templetName)
	{
		StringBuffer path = new StringBuffer();
		File file = new File(Config.getTempletPath());
		path.append(file.getAbsolutePath());
		path.append(File.separator);
		path.append(templetName);
		return path.toString();
	}

	public static String getExcelPath(String fileName)
	{
		StringBuffer path = new StringBuffer();
		File file = new File(Config.getWorkPath());
		path.append(file.getAbsolutePath());
		path.append(File.separator);
		path.append(fileName);
		return path.toString();
	}

	public static void removeStartWithExcept(String startOfFileName, String exceptedFileName, long beforeSecs)
	{
		if (startOfFileName != null)
			startOfFileName = startOfFileName.trim();
		if (exceptedFileName != null)
			exceptedFileName = exceptedFileName.trim();
		File file = new File(Config.getWorkPath());
		if (file.isDirectory())
		{
			File files[] = file.listFiles();
			EvanLog logger = EvanLog.getLoger();
			logger.log("ExcelUtil------for start");
			for (int i = 0; i < files.length; i++)
				if (files[i].getName().trim().startsWith(startOfFileName) && (exceptedFileName == null || !exceptedFileName.equals(files[i].getName().trim())) && beforeSecs * 1000L <= System.currentTimeMillis() - files[i].lastModified())
				{
					boolean deleted = files[i].delete();
					if (deleted)
						System.out.println((new StringBuilder(String.valueOf(files[i].getName()))).append(" 被删除").toString());
					else
						System.out.println((new StringBuilder(String.valueOf(files[i].getName()))).append(" 无法删除").toString());
				}

			logger.log("ExcelUtil------for end");
		}
	}

	public static boolean remove(String fileName)
	{
		boolean flag = false;
		String path = Config.getWorkPath();
		path = (new StringBuilder(String.valueOf(path))).append(File.separator).append(fileName).toString();
		File f = new File(path);
		if (f.exists())
		{
			flag = f.delete();
			if (!flag)
				System.out.println((new StringBuilder("无法删除 ")).append(fileName).toString());
			else
				System.out.println((new StringBuilder("删除 ")).append(fileName).toString());
		}
		return flag;
	}

	public static boolean remove(String fileName, String filepath)
	{
		boolean flag = false;
		String path = filepath;
		path = (new StringBuilder(String.valueOf(path))).append(File.separator).append(fileName).toString();
		File f = new File(path);
		if (f.exists())
		{
			flag = f.delete();
			if (!flag)
				System.out.println((new StringBuilder("无法删除 ")).append(fileName).toString());
			else
				System.out.println((new StringBuilder("删除 ")).append(fileName).toString());
		}
		return flag;
	}
}
