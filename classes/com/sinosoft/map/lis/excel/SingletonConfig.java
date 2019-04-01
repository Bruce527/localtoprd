// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SingletonConfig.java

package com.sinosoft.map.lis.excel;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.File;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.lis.excel:
//			Config2

class SingletonConfig
{

	private SingletonConfig config;
	private String templetPath;
	private String workPath;

	private SingletonConfig()
	{
		templetPath = getTempletPath();
	}

	public static String getTempletPath()
	{
		String tmp = get("templetPath");
		if (tmp == null)
		{
			System.out.println("路径配置在文件中");
			tmp = Config2.getTempletPath();
		}
		return tmp.replace('/', File.separatorChar);
	}

	public static String getWorkPath()
	{
		String tmp = get("reportPath");
		if (tmp == null)
		{
			System.out.println("路径配置在文件中");
			tmp = Config2.getWorkPath();
		}
		return tmp.replace('/', File.separatorChar);
	}

	public static String get(String sysvar)
	{
		String valuestr = "";
		ExeSQL aExeSQL = new ExeSQL();
		SSRS aSSRS = new SSRS();
		String strSQL = (new StringBuilder("select sysvarvalue from ldsysvar where sysvar = '")).append(sysvar).append("hahahaha'").toString();
		aSSRS = aExeSQL.execSQL(strSQL);
		if (aSSRS.MaxRow > 0 && !aSSRS.GetText(1, 1).equals(""))
		{
			System.out.println("路径配置在数据库中");
			valuestr = aSSRS.GetText(1, 1);
			return valuestr;
		} else
		{
			return null;
		}
	}
}
