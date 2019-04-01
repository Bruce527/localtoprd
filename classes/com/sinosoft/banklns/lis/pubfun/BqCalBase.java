// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BqCalBase.java

package com.sinosoft.banklns.lis.pubfun;


public class BqCalBase
{

	private double Prem;
	private double Get;
	private double Mult;
	private int PayIntv;
	private int GetIntv;
	private String GetStartFlag;
	private String PayEndYearFlag;
	private int PayEndYear;
	private int GetStartYear;
	private int GetStartAge;
	private int GetAppYear;
	private int GetYear;
	private int GetAge;
	private int GetTimes;
	private int Years;
	private int AppAge;
	private int AppAgeType;
	private String Sex;
	private String Job;
	private String GDuty;
	private int Count;
	private double AddRate;
	private String PolNo;
	private String GrpPolNo;
	private int Interval;
	private String EdorNo;
	private String EdorType;
	private String EdorValiDate;
	private double GetMoney;
	private String GetStartDate;
	private String CValiDate;
	private double GetBalance;
	private String RiskCode;

	public BqCalBase()
	{
	}

	public void setInterval(int tInterval)
	{
		Interval = tInterval;
	}

	public String getInterval()
	{
		return String.valueOf(Interval);
	}

	public void setPrem(double tPrem)
	{
		Prem = tPrem;
	}

	public String getPrem()
	{
		return String.valueOf(Prem);
	}

	public void setGet(double tGet)
	{
		Get = tGet;
	}

	public String getGet()
	{
		return String.valueOf(Get);
	}

	public void setMult(double tMult)
	{
		Mult = tMult;
	}

	public String getMult()
	{
		return String.valueOf(Mult);
	}

	public void setAddRate(double tAddRate)
	{
		AddRate = tAddRate;
	}

	public String getAddRate()
	{
		return String.valueOf(AddRate);
	}

	public void setPayIntv(int tPayIntv)
	{
		PayIntv = tPayIntv;
	}

	public String getPayIntv()
	{
		return String.valueOf(PayIntv);
	}

	public void setGetIntv(int tGetIntv)
	{
		GetIntv = tGetIntv;
	}

	public String getGetIntv()
	{
		return String.valueOf(GetIntv);
	}

	public void setPayEndYear(int tPayEndYear)
	{
		PayEndYear = tPayEndYear;
	}

	public String getPayEndYear()
	{
		return String.valueOf(PayEndYear);
	}

	public void setGetYear(int tGetYear)
	{
		GetYear = tGetYear;
	}

	public String getGetYear()
	{
		return String.valueOf(GetYear);
	}

	public void setGetAppYear(int tGetAppYear)
	{
		GetAppYear = tGetAppYear;
	}

	public String getGetAppYear()
	{
		return String.valueOf(GetAppYear);
	}

	public void setGetAge(int tGetAge)
	{
		GetAge = tGetAge;
	}

	public String getGetAge()
	{
		return String.valueOf(GetAge);
	}

	public void setGetStartYear(int tGetStartYear)
	{
		GetStartYear = tGetStartYear;
	}

	public String getGetStartYear()
	{
		return String.valueOf(GetStartYear);
	}

	public void setGetStartAge(int tGetStartAge)
	{
		GetStartAge = tGetStartAge;
	}

	public String getGetStartAge()
	{
		return String.valueOf(GetStartAge);
	}

	public void setGetTimes(int tGetTimes)
	{
		GetTimes = tGetTimes;
	}

	public String getGetTimes()
	{
		return String.valueOf(GetTimes);
	}

	public void setYears(int tYears)
	{
		Years = tYears;
	}

	public String getYears()
	{
		return String.valueOf(Years);
	}

	public void setAppAge(int tAppAge)
	{
		AppAge = tAppAge;
	}

	public String getAppAge()
	{
		return String.valueOf(AppAge);
	}

	public void setCount(int tCount)
	{
		Count = tCount;
	}

	public String getCount()
	{
		return String.valueOf(Count);
	}

	public void setSex(String tSex)
	{
		Sex = tSex;
	}

	public String getSex()
	{
		return Sex;
	}

	public void setJob(String tJob)
	{
		Job = tJob;
	}

	public String getJob()
	{
		return Job;
	}

	public void setGDuty(String tGDuty)
	{
		GDuty = tGDuty;
	}

	public String getGDuty()
	{
		return GDuty;
	}

	public void setPolNo(String tPolNo)
	{
		PolNo = tPolNo;
	}

	public String getPolNo()
	{
		return PolNo;
	}

	public void setGrpPolNo(String tGrpPolNo)
	{
		GrpPolNo = tGrpPolNo;
	}

	public String getGrpPolNo()
	{
		return GrpPolNo;
	}

	public void setEdorNo(String tEdorNo)
	{
		EdorNo = tEdorNo;
	}

	public String getEdorNo()
	{
		return EdorNo;
	}

	public void setEdorType(String tEdorType)
	{
		EdorType = tEdorType;
	}

	public String getEdorType()
	{
		return EdorType;
	}

	public void setGetMoney(double tGetMoney)
	{
		GetMoney = tGetMoney;
	}

	public String getGetMoney()
	{
		return String.valueOf(GetMoney);
	}

	public void setCValiDate(String tCValiDate)
	{
		CValiDate = tCValiDate;
	}

	public String getCValiDate()
	{
		return CValiDate;
	}

	public void setEdorValiDate(String tEdorValiDate)
	{
		EdorValiDate = tEdorValiDate;
	}

	public String getEdorValiDate()
	{
		return EdorValiDate;
	}

	public void setGetStartDate(String tGetStartDate)
	{
		GetStartDate = tGetStartDate;
	}

	public String getGetStartDate()
	{
		return GetStartDate;
	}

	public void setGetBalance(double tGetBalance)
	{
		GetBalance = tGetBalance;
	}

	public String getGetBalance()
	{
		return String.valueOf(GetBalance);
	}

	public void setRiskCode(String tRiskCode)
	{
		RiskCode = tRiskCode;
	}

	public String getRiskCode()
	{
		return RiskCode;
	}

	public void setPayEndYearFlag(String tPayEndYearFlag)
	{
		PayEndYearFlag = tPayEndYearFlag;
	}

	public String getPayEndYearFlag()
	{
		return PayEndYearFlag;
	}

	public void setGetStartFlag(String tGetStartFlag)
	{
		GetStartFlag = tGetStartFlag;
	}

	public String getGetStartFlag()
	{
		return GetStartFlag;
	}

	public int getAppAgeType()
	{
		return AppAgeType;
	}

	public void setAppAgeType(int appAgeType)
	{
		AppAgeType = appAgeType;
	}
}
