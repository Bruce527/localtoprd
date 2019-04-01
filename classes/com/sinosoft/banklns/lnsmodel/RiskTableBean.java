// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RiskTableBean.java

package com.sinosoft.banklns.lnsmodel;


public class RiskTableBean
{

	private String riskname;
	private String amntmult;
	private String payintv;
	private String insuyear;
	private String payendyear;
	private String prem;
	private String serialNo;
	private String polno;
	private String listEditFlag;

	public String getListEditFlag()
	{
		return listEditFlag;
	}

	public void setListEditFlag(String listEditFlag)
	{
		this.listEditFlag = listEditFlag;
	}

	public RiskTableBean()
	{
		riskname = "";
		amntmult = "";
		payintv = "";
		insuyear = "";
		payendyear = "";
		prem = "";
		serialNo = "";
		polno = "";
	}

	public RiskTableBean(String riskname, String amntmult, String payintv, String insuyear, String payendyear, String prem, String serialNo, 
			String polno, String listEditFlag)
	{
		this.riskname = "";
		this.amntmult = "";
		this.payintv = "";
		this.insuyear = "";
		this.payendyear = "";
		this.prem = "";
		this.serialNo = "";
		this.polno = "";
		this.riskname = riskname;
		this.amntmult = amntmult;
		this.payintv = payintv;
		this.insuyear = insuyear;
		this.payendyear = payendyear;
		this.prem = prem;
		this.serialNo = serialNo;
		this.polno = polno;
		this.listEditFlag = listEditFlag;
	}

	public String getAmntmult()
	{
		return amntmult;
	}

	public void setAmntmult(String amntmult)
	{
		this.amntmult = amntmult;
	}

	public String getInsuyear()
	{
		return insuyear;
	}

	public void setInsuyear(String insuyear)
	{
		this.insuyear = insuyear;
	}

	public String getPayendyear()
	{
		return payendyear;
	}

	public void setPayendyear(String payendyear)
	{
		this.payendyear = payendyear;
	}

	public String getPayintv()
	{
		return payintv;
	}

	public void setPayintv(String payintv)
	{
		this.payintv = payintv;
	}

	public String getPolno()
	{
		return polno;
	}

	public void setPolno(String polno)
	{
		this.polno = polno;
	}

	public String getPrem()
	{
		return prem;
	}

	public void setPrem(String prem)
	{
		this.prem = prem;
	}

	public String getRiskname()
	{
		return riskname;
	}

	public void setRiskname(String riskname)
	{
		this.riskname = riskname;
	}

	public String getSerialNo()
	{
		return serialNo;
	}

	public void setSerialNo(String serialNo)
	{
		this.serialNo = serialNo;
	}
}
