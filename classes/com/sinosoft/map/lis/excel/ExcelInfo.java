// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExcelInfo.java

package com.sinosoft.map.lis.excel;


public class ExcelInfo
{

	String excelPath;
	boolean excelExists;
	long modifyTime;
	String excelName;

	ExcelInfo()
	{
		excelPath = null;
		excelExists = false;
		modifyTime = 0L;
		excelName = null;
	}

	public String getReportName()
	{
		return excelName;
	}

	public String getReportPath()
	{
		return excelPath;
	}

	public boolean exists()
	{
		return excelExists;
	}

	public long getModifyTime()
	{
		return modifyTime;
	}

	public void setReportName(String name)
	{
		excelName = name;
	}
}
