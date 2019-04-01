// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ReportHelper.java

package com.sinosoft.map.lis.excel;

import java.io.OutputStream;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.lis.excel:
//			ExcelUtil, ExcelInfo, SimpleWorkbook, DownloadUtil

public class ReportHelper
{

	private SimpleWorkbook workbook;
	private ExcelInfo result;
	private String templetPath;

	public ReportHelper(String templetFileName, String reportFileName, long usefullLifeSec, String rvFNStartWith, long invalidationSec)
	{
		workbook = null;
		result = null;
		result = ExcelUtil.prepare(reportFileName, usefullLifeSec);
		result.excelName = reportFileName;
		templetPath = ExcelUtil.getTempletPath(templetFileName);
		System.out.println((new StringBuilder("templetPath:")).append(templetPath).toString());
		ExcelUtil.removeStartWithExcept(rvFNStartWith, result.excelPath, invalidationSec);
	}

	public ReportHelper(String templetFileName, String reportFileName, long usefullLifeSec, String rvFNStartWith, long invalidationSec, 
			String str)
	{
		workbook = null;
		result = null;
		System.out.println("enter into ReportHelper");
		result = ExcelUtil.prepare1(reportFileName, usefullLifeSec, str);
		result.excelName = reportFileName;
		templetPath = ExcelUtil.getTempletPath(templetFileName);
		System.out.println((new StringBuilder("templetPath:")).append(templetPath).toString());
		ExcelUtil.removeStartWithExcept(rvFNStartWith, result.excelPath, invalidationSec);
	}

	public ReportHelper(String templetFileName, String reportFileName, long usefullLifeSec, String rvFNStartWith)
	{
		this(templetFileName, reportFileName, usefullLifeSec, rvFNStartWith, usefullLifeSec * 2L);
	}

	public ExcelInfo getInfo()
	{
		return result;
	}

	public SimpleWorkbook createWorkbook()
	{
		try
		{
			workbook = new SimpleWorkbook(result.excelPath, templetPath);
			System.out.println((new StringBuilder("workbook created: ")).append(workbook).toString());
			System.out.println((new StringBuilder("excelPath: ")).append(result.excelPath).toString());
			System.out.println((new StringBuilder("templetPath: ")).append(templetPath).toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return workbook;
	}

	public static boolean remove(String reportName)
	{
		return ExcelUtil.remove(reportName);
	}

	public static boolean remove(String reportName, String reportpath)
	{
		return ExcelUtil.remove(reportName, reportpath);
	}

	public static String getReportPath(String fileName)
	{
		return ExcelUtil.getExcelPath(fileName);
	}

	public static void download(OutputStream out, String filePath)
	{
		DownloadUtil.writeTo(out, filePath);
	}
}
