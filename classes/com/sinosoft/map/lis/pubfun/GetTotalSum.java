// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GetTotalSum.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;

public class GetTotalSum
{

	public GetTotalSum()
	{
	}

	public String getTotalPay(String serialno)
	{
		ExeSQL exeSql = new ExeSQL();
		SSRS testSSRS = new SSRS();
		String sql = (new StringBuilder("select Totalmoney, Totalnum from lybanklog where SerialNo = ")).append(serialno).toString();
		testSSRS = exeSql.execSQL(sql);
		return testSSRS.GetText(0, 0);
	}

	public String getTotalPic(String serialno)
	{
		ExeSQL exeSql = new ExeSQL();
		SSRS testSSRS = new SSRS();
		String sql = (new StringBuilder("select Totalmoney, Totalnum from lybanklog where SerialNo = ")).append(serialno).toString();
		testSSRS = exeSql.execSQL(sql);
		return testSSRS.GetText(0, 1);
	}
}
