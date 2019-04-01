// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ZipInfo.java

package com.sinosoft.map.lis.excel;


public class ZipInfo
{

	String zipPath;
	boolean zipExists;
	long modifyTime;
	String zipName;

	ZipInfo()
	{
		zipPath = null;
		zipExists = false;
		modifyTime = 0L;
		zipName = null;
	}

	public String getReportName()
	{
		return zipName;
	}

	public String getReportPath()
	{
		return zipPath;
	}

	public boolean exists()
	{
		return zipExists;
	}

	public long getModifyTime()
	{
		return modifyTime;
	}
}
