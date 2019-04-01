// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SpecialProductFun.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Map;

public class SpecialProductFun
{

	public static final int PERIOD_106 = 106;
	public static Map ProductRiskMap = new Hashtable();

	public SpecialProductFun()
	{
	}

	private static void initProductRisk()
	{
		try
		{
			ProductRiskMap.clear();
			ExeSQL execSQL = new ExeSQL();
			String sql = "select code,codename from LNPCode where CodeType='BankSpecialRiskCode'";
			SSRS ssrs = execSQL.execSQL(sql);
			if (ssrs.MaxRow > 0)
			{
				for (int i = 1; i <= ssrs.MaxRow; i++)
				{
					ProductRiskMap.put(ssrs.GetText(i, 1), Integer.valueOf(Integer.parseInt(ssrs.GetText(i, 2))));
					System.out.println((new StringBuilder("i+riskcode==================")).append(ssrs.GetText(i, 1)).append("-----------").append(Integer.parseInt(ssrs.GetText(i, 2))).toString());
				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int getRiskPro(String RiskCode)
	{
		if (RiskCode == null || !ProductRiskMap.containsKey(RiskCode.toUpperCase()))
			break MISSING_BLOCK_LABEL_90;
		System.out.println((new StringBuilder("~~~~~~~~current riskcode:")).append(RiskCode).append(" will return period:").append(ProductRiskMap.get(RiskCode.toUpperCase())).append("/A").toString());
		return ((Integer)ProductRiskMap.get(RiskCode.toUpperCase())).intValue();
		Exception e;
		e;
		e.printStackTrace();
		System.out.println((new StringBuilder("~~~~~~~~current riskcode:")).append(RiskCode).append("  will return period:106/A").toString());
		return 106;
	}

	public static void main(String args[])
	{
		String RiskCode = "LA09BA";
		getRiskPro(RiskCode);
	}

	static 
	{
		initProductRisk();
	}
}
