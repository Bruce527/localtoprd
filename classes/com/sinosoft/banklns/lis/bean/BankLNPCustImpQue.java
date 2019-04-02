// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankLNPCustImpQue.java

package com.sinosoft.banklns.lis.bean;

import com.sinosoft.banklns.lis.schema.LNPCustImpQueSchema;

// Referenced classes of package com.sinosoft.banklns.lis.bean:
//			BankBeanBasic

public class BankLNPCustImpQue extends BankBeanBasic
{

	private LNPCustImpQueSchema appntQues;
	private LNPCustImpQueSchema insurQues;
	private String appntanswer;
	private String insuranswer;
	private String isAppntAllSelected;
	private String isInsurAllSelected;

	public BankLNPCustImpQue()
	{
		appntQues = new LNPCustImpQueSchema();
		insurQues = new LNPCustImpQueSchema();
		appntanswer = "1";
		insuranswer = "2";
	}

	public String getAppntanswer()
	{
		return appntanswer;
	}

	public void setAppntanswer(String appntanswer)
	{
		this.appntanswer = appntanswer;
	}

	public String getInsuranswer()
	{
		return insuranswer;
	}

	public void setInsuranswer(String insuranswer)
	{
		this.insuranswer = insuranswer;
	}

	public String getIsAppntAllSelected()
	{
		return isAppntAllSelected;
	}

	public void setIsAppntAllSelected(String isAppntAllSelected)
	{
		this.isAppntAllSelected = isAppntAllSelected;
	}

	public String getIsInsurAllSelected()
	{
		return isInsurAllSelected;
	}

	public void setIsInsurAllSelected(String isInsurAllSelected)
	{
		this.isInsurAllSelected = isInsurAllSelected;
	}

	public LNPCustImpQueSchema getAppntQues()
	{
		return appntQues;
	}

	public void setAppntQues(LNPCustImpQueSchema appntQues)
	{
		this.appntQues = appntQues;
	}

	public LNPCustImpQueSchema getInsurQues()
	{
		return insurQues;
	}

	public void setInsurQues(LNPCustImpQueSchema insurQues)
	{
		this.insurQues = insurQues;
	}
}
