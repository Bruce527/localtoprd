// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Config.java

package com.sinosoft.map.lis.excel;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.File;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.lis.excel:
//			Config2

class Config
{

	Config()
	{
	}

	public static String getTempletPath()
	{
		String tmp = get("templetPath");
		if (tmp == null)
		{
			System.out.println("·���������ļ���");
			tmp = Config2.getTempletPath();
		}
		return tmp.replace('/', File.separatorChar);
	}

	public static String getWorkPath()
	{
		String tmp = get("reportPath");
		if (tmp == null)
		{
			System.out.println("·���������ļ���");
			tmp = Config2.getWorkPath();
		}
		return tmp.replace('/', File.separatorChar);
	}

	public static String get(String sysvar)
	{
		String valuestr = "";
		ExeSQL aExeSQL = new ExeSQL();
		SSRS aSSRS = new SSRS();
		String strSQL = (new StringBuilder("select varvalue from msysvar where vartype = '")).append(sysvar).append("'").toString();
		aSSRS = aExeSQL.execSQL(strSQL);
		if (aSSRS.MaxRow > 0 && !aSSRS.GetText(1, 1).equals(""))
		{
			System.out.println("·�����������ݿ���");
			valuestr = aSSRS.GetText(1, 1);
			return valuestr;
		} else
		{
			return null;
		}
	}

	public static void main(String args[])
	{
		String tmp = "e:/tmp/org/com";
		String tmp2 = tmp.replace('/', File.separatorChar);
		System.out.println(tmp);
		System.out.println(tmp2);
	}
}
