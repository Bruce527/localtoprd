// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RiskError.java

package com.sinosoft.banklns.lnsmodel.util;

import com.sinosoft.banklns.lis.db.LNPRiskDB;
import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
import java.util.*;

public class RiskError
{

	private LNPRiskSchema riskInfo;
	private Set set;

	public RiskError()
	{
		riskInfo = null;
		set = new HashSet();
	}

	public Set getRiskError()
	{
		return set;
	}

	public void setRiskInfo(String riskCode)
	{
		LNPRiskDB reLMRiskDB = new LNPRiskDB();
		reLMRiskDB.setRiskCode(riskCode);
		if (reLMRiskDB.getInfo())
			riskInfo = reLMRiskDB.getSchema();
	}

	public void setRiskInfo(LNPRiskSchema inLNPRiskSchema)
	{
		riskInfo = inLNPRiskSchema;
	}

	public void addError(String strError)
	{
		if (strError != null && strError.length() > 0)
			set.add(strError);
	}

	public void addError(Collection errorCollection)
	{
		if (errorCollection != null && errorCollection.size() > 0)
		{
			for (Iterator iterator = errorCollection.iterator(); iterator.hasNext();)
			{
				Object errorObj = iterator.next();
				if (errorObj != null && errorObj.toString().length() > 0)
					set.add(errorObj.toString());
			}

		}
	}

	public LNPRiskSchema getRiskInfo()
	{
		return riskInfo;
	}
}
