// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysGlobalVar.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.ExeSQL;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class SysGlobalVar
{

	private static SysGlobalVar instance = null;
	private String currentDate;

	private SysGlobalVar()
	{
		currentDate = null;
		currentDate = getInitCurrentDate();
	}

	public static synchronized SysGlobalVar getInstance()
	{
		if (instance == null)
		{
			System.out.println("...... instance is null ......");
			instance = new SysGlobalVar();
		}
		return instance;
	}

	private String getInitCurrentDate()
	{
		ExeSQL tExeSQL = new ExeSQL();
		String setupCurrentDate = tExeSQL.getOneValue("select sysvarvalue from ldsysvar where sysvar='changepubfundate'");
		System.out.println((new StringBuilder("...... init global var currentdate=")).append(setupCurrentDate).append(" ......").toString());
		String tString = "";
		if (setupCurrentDate.equals(""))
			return tString;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date str = sdf.parse(setupCurrentDate);
			tString = sdf.format(str);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return tString;
	}

	public String getSetupCurrentDate()
	{
		return currentDate;
	}

	public void clearObject()
	{
		if (instance != null)
		{
			instance = null;
			System.out.println("...... clear SysGlobalVar ......");
		}
	}

}
