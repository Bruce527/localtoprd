// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RiskCheck.java

package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.db.LNPRiskAppDB;
import java.io.PrintStream;

public class RiskCheck
{

	public RiskCheck()
	{
	}

	public static boolean checkRiskType(String riskCode, String checTypeCode)
	{
		LNPRiskAppDB LNPRiskAppDB = new LNPRiskAppDB();
		LNPRiskAppDB.setRiskCode(riskCode);
		String riskType = "";
		if (LNPRiskAppDB.getInfo())
			riskType = LNPRiskAppDB.getRiskType().trim();
		else
			System.out.println((new StringBuilder(" LMRiskApp������")).append(riskCode).append("����").toString());
		return riskType.equalsIgnoreCase(checTypeCode.trim());
	}
}
