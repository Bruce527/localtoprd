// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPSuggestToInsuranceBean.java

package com.sinosoft.banklns.lnsmodel.entity;


public class LNPSuggestToInsuranceBean
{

	private String makeDate;
	private String manageCom;
	private String insuredName;
	private String insuredBirthday;
	private String insuredAge;
	private String insuredIDNo;
	private String prem;
	private String riskCode;
	private String sugNo;
	private String sugInsuredNo;
	private String sugAppntNo;

	public LNPSuggestToInsuranceBean()
	{
	}

	public String getInsuredName()
	{
		return insuredName;
	}

	public void setInsuredName(String insuredName)
	{
		this.insuredName = insuredName;
	}

	public String getInsuredIDNo()
	{
		return insuredIDNo;
	}

	public void setInsuredIDNo(String insuredIDNo)
	{
		this.insuredIDNo = insuredIDNo;
	}

	public String getInsuredBirthday()
	{
		return insuredBirthday;
	}

	public void setInsuredBirthday(String insuredBirthday)
	{
		this.insuredBirthday = insuredBirthday;
	}

	public String getInsuredAge()
	{
		return insuredAge;
	}

	public void setInsuredAge(String insuredAge)
	{
		this.insuredAge = insuredAge;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String riskCode)
	{
		this.riskCode = riskCode;
	}

	public String getMakeDate()
	{
		return makeDate;
	}

	public void setMakeDate(String makeDate)
	{
		this.makeDate = makeDate;
	}

	public String getSugNo()
	{
		return sugNo;
	}

	public void setSugNo(String sugNo)
	{
		this.sugNo = sugNo;
	}

	public String getSugInsuredNo()
	{
		return sugInsuredNo;
	}

	public void setSugInsuredNo(String sugInsuredNo)
	{
		this.sugInsuredNo = sugInsuredNo;
	}

	public String getSugAppntNo()
	{
		return sugAppntNo;
	}

	public void setSugAppntNo(String sugAppntNo)
	{
		this.sugAppntNo = sugAppntNo;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String manageCom)
	{
		this.manageCom = manageCom;
	}

	public String getPrem()
	{
		return prem;
	}

	public void setPrem(String prem)
	{
		this.prem = prem;
	}
}
