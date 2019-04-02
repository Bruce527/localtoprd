// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CheckTabCanBeUse.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			PolicyMainInfo

public class CheckTabCanBeUse
{

	public String errorMsg;

	public CheckTabCanBeUse()
	{
	}

	public List checkAppntTab(String contNo, IGlobalInput tGlobalInput)
	{
		boolean insuredExistFlag = insuredExist(contNo);
		List list = new ArrayList();
		if (!insuredExistFlag)
		{
			list.add("???????\361?????");
			list.add(null);
		}
		return list;
	}

	public List checkBnfTab(String contNo, IGlobalInput tGlobalInput)
	{
		boolean insuredExistFlag = insuredExist(contNo);
		List list = new ArrayList();
		if (!insuredExistFlag)
		{
			list.add("???????\361?????");
			list.add(null);
		}
		return list;
	}

	public List checkDesignRiskTab(String contNo, IGlobalInput tGlobalInput)
	{
		boolean insuredExistFlag = insuredExist(contNo);
		List list = new ArrayList();
		if (!insuredExistFlag)
		{
			list.add("???????\361?????");
			list.add(null);
		}
		boolean appntExistFlag = appntExist(contNo);
		if (!appntExistFlag)
		{
			list.add("?????????????");
			list.add(null);
		}
		return list;
	}

	public List checkBonusTab(String contNo, IGlobalInput tGlobalInput)
	{
		List list = new ArrayList();
		boolean insuredExistFlag = insuredExist(contNo);
		boolean policyInfoExistFlag = policyExist(contNo);
		if (!insuredExistFlag)
		{
			list.add("???????\361?????");
			list.add(null);
		}
		if (insuredExistFlag && !policyInfoExistFlag)
		{
			list.add("???????\361???????");
			list.add(null);
		}
		return list;
	}

	public List checkFAITab(String contNo, IGlobalInput tGlobalInput)
	{
		boolean insuredExistFlag = insuredExist(contNo);
		List list = new ArrayList();
		if (!insuredExistFlag)
		{
			list.add("???????\361?????");
			list.add(null);
		}
		return list;
	}

	public List checkInsuDiscripTab(String contNo, IGlobalInput tGlobalInput)
	{
		boolean insuredExistFlag = insuredExist(contNo);
		boolean policyInfoExistFlag = policyExist(contNo);
		List list = new ArrayList();
		if (!insuredExistFlag)
		{
			list.add("???????\361?????");
			list.add(null);
		}
		if (insuredExistFlag && !policyInfoExistFlag)
		{
			list.add("???????\361???????");
			list.add(null);
		}
		return list;
	}

	public List checkAgentInformTab(String contNo, IGlobalInput tGlobalInput)
	{
		boolean insuredExistFlag = insuredExist(contNo);
		List list = new ArrayList();
		if (!insuredExistFlag)
		{
			list.add("???????\361?????");
			list.add(null);
		}
		return list;
	}

	private boolean insuredExist(String contNo)
	{
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema lnpSch = mainInfo.getContByContNo(contNo);
		return lnpSch.getInsuredId() != null && !lnpSch.getInsuredId().equals("") && lnpSch.getEditstate().substring(1, 2).equals("1");
	}

	private boolean appntExist(String contNo)
	{
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema lnpSch = mainInfo.getContByContNo(contNo);
		return lnpSch.getAppntId() != null && !lnpSch.getAppntId().equals("") && lnpSch.getEditstate().substring(2, 3).equals("1");
	}

	private boolean policyExist(String contNo)
	{
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		String mark = mainInfo.getContByContNo(contNo).getEditstate();
		String flag = mark.substring(3, 4);
		return !flag.equals("0");
	}
}
