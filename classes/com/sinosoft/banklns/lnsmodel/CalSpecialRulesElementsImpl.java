// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CalSpecialRulesElementsImpl.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPInvestRiskDataDB;
import com.sinosoft.banklns.lis.db.LNPPolDB;
import com.sinosoft.banklns.lis.schema.LNPInvestRiskDataSchema;
import com.sinosoft.banklns.lis.vschema.LNPInvestRiskDataSet;

public class CalSpecialRulesElementsImpl
{

	public CalSpecialRulesElementsImpl()
	{
	}

	public double getIRAmnt(String polNo)
	{
		LNPPolDB reLNPPolDB = new LNPPolDB();
		reLNPPolDB.setPolNo(polNo);
		double result = 0.0D;
		if (reLNPPolDB.getInfo())
		{
			result = reLNPPolDB.getPrem();
			LNPInvestRiskDataDB ewLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
			String singNo = reLNPPolDB.getStandbyFlag3();
			if (singNo != null && singNo.length() > 0)
			{
				ewLNPInvestRiskDataDB.setSignno(singNo);
				ewLNPInvestRiskDataDB.setType("0");
				LNPInvestRiskDataSet reLNPInvestRiskDataSet = ewLNPInvestRiskDataDB.query();
				for (int i = 1; reLNPInvestRiskDataSet != null && i <= reLNPInvestRiskDataSet.size(); i++)
				{
					LNPInvestRiskDataSchema reLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
					double value = reLNPInvestRiskDataSchema.getValue();
					double degree = reLNPInvestRiskDataSchema.getDegree();
					result += value * degree;
				}

			}
		}
		return result;
	}

	public static void main(String args1[])
	{
	}
}
