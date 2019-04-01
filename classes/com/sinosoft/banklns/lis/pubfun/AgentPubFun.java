// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AgentPubFun.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.ExeSQL;

public class AgentPubFun
{

	public AgentPubFun()
	{
	}

	public static void main(String args1[])
	{
	}

	public static String switchSalChnl(String cSalChnl)
	{
		String tBranchType = "";
		cSalChnl = cSalChnl.trim();
		if (cSalChnl.equals("01"))
			tBranchType = "2";
		else
		if (cSalChnl.equals("02"))
			tBranchType = "1";
		else
		if (cSalChnl.equals("03") || cSalChnl.equals("04") || cSalChnl.equals("05") || cSalChnl.equals("06"))
			tBranchType = "3";
		return tBranchType;
	}

	public static String getAgentSeries(String cAgentGrade)
	{
		if (cAgentGrade == null || cAgentGrade.equals(""))
			return null;
		String tAgentSeries = "";
		String tSQL = (new StringBuilder("select Trim(code2) from ldcodeRela where relaType = 'gradeserieslevel' and code1 = '")).append(cAgentGrade).append("' ").toString();
		ExeSQL tExeSQL = new ExeSQL();
		tAgentSeries = tExeSQL.getOneValue(tSQL);
		if (tExeSQL.mErrors.needDealError())
			return null;
		else
			return tAgentSeries;
	}
}
