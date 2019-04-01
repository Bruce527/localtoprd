// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TestDataSource.java

package com.sinosoft.map.user;

import com.sinosoft.map.utility.*;
import java.io.PrintStream;

public class TestDataSource
{

	public TestDataSource()
	{
		System.out.println("Start------------------------DataSource TestClass------------------------");
		com.sinosoft.map.utility.DBConn con = DBConnPool.getConnection();
		ExeSQL execSQL = new ExeSQL(con);
		String sql = "select varvalue from msysvar where vartype='loginbranchtype'";
		SSRS ssrs = execSQL.execSQL(sql);
		for (int i = 1; i < ssrs.MaxRow; i++)
			System.out.println(ssrs.GetText(i, 1));

		System.out.println("End------------------------DataSource TestClass------------------------");
	}

	public static void main(String args[])
	{
		new TestDataSource();
	}
}
