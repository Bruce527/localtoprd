// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   InsuError.java

package com.sinosoft.banklns.lnsmodel.util;

import com.sinosoft.banklns.lis.db.LNPInsuredDB;
import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
import java.util.*;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.util:
//			RiskError

public class InsuError
{

	private LNPInsuredSchema insuInfo;
	private List riskErrorList;

	public InsuError()
	{
		insuInfo = null;
		riskErrorList = new ArrayList();
	}

	public void setInsuInfo(String contNo, String insuredNo)
	{
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(contNo);
		reLNPInsuredDB.setInsuredId(insuredNo);
		if (reLNPInsuredDB.getInfo())
			insuInfo = reLNPInsuredDB.getSchema();
	}

	public void setInsuInfo(LNPInsuredSchema inLNPInsuredSchema)
	{
		insuInfo = inLNPInsuredSchema;
	}

	public void addRiskError(RiskError riskError)
	{
		Set set = riskError.getRiskError();
		if (set != null && set.size() > 0)
			riskErrorList.add(riskError);
	}

	public LNPInsuredSchema getInsuInfo()
	{
		return insuInfo;
	}

	public List getRiskErrorList()
	{
		return riskErrorList;
	}
}
