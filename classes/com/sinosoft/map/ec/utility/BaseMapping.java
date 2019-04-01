// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BaseMapping.java

package com.sinosoft.map.ec.utility;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;

public class BaseMapping
{

	private ExeSQL mExeSQL;

	public BaseMapping()
	{
		mExeSQL = new ExeSQL();
	}

	public String agentMapping(String agentcode)
	{
		String tempAgent = "";
		SSRS mSSRS = new SSRS();
		String agentSQL = (new StringBuilder("select agentcode from magent where oagentcode='")).append(agentcode).append("'").toString();
		mSSRS = mExeSQL.execSQL(agentSQL);
		if (mSSRS == null || mSSRS.getMaxRow() < 1)
		{
			tempAgent = agentcode;
			return tempAgent;
		} else
		{
			tempAgent = mSSRS.GetText(1, 1);
			return tempAgent;
		}
	}

	public String branchMapping(String branch)
	{
		String tempBranch = "";
		SSRS mSSRS = new SSRS();
		String branchSQL = (new StringBuilder("select branchattr from mbranch where obranchattr='")).append(branch).append("'").toString();
		mSSRS = mExeSQL.execSQL(branchSQL);
		if (mSSRS == null || mSSRS.getMaxRow() < 1)
		{
			tempBranch = branch;
			return tempBranch;
		} else
		{
			tempBranch = mSSRS.GetText(1, 1);
			return tempBranch;
		}
	}

	public String resAgentMapping(String agentcode)
	{
		String tempAgent = "";
		SSRS mSSRS = new SSRS();
		String agentSQL = (new StringBuilder("select oagentcode from magent where agentcode='")).append(agentcode).append("'").toString();
		mSSRS = mExeSQL.execSQL(agentSQL);
		if (mSSRS == null || mSSRS.getMaxRow() < 1)
		{
			tempAgent = agentcode;
			return tempAgent;
		} else
		{
			tempAgent = mSSRS.GetText(1, 1);
			return tempAgent;
		}
	}

	public String resBranchMapping(String branch)
	{
		String tempBranch = "";
		SSRS mSSRS = new SSRS();
		String branchSQL = (new StringBuilder("select obranchattr from mbranch where branchattr='")).append(branch).append("'").toString();
		mSSRS = mExeSQL.execSQL(branchSQL);
		if (mSSRS == null || mSSRS.getMaxRow() < 1)
		{
			tempBranch = branch;
			return tempBranch;
		} else
		{
			tempBranch = mSSRS.GetText(1, 1);
			return tempBranch;
		}
	}
}
