// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CheckBase.java

package com.sinosoft.banklns.lis.pubfun;


public class CheckBase
{

	private double Prem;
	private double Mult;
	private int PayIntv;
	private int GetIntv;
	private int PayEndYear;
	private String PayEndYearFlag;
	private int GetYear;
	private String GetYearFlag;
	private String GetDutyKind;
	private String StartDateCalRef;
	private int Years;
	private int InsuYear;
	private String InsuYearFlag;
	private int AppAge;
	private int AppAgeType;
	private String Sex;
	private String OccupationType;
	private String GDuty;
	private String MainPolNo;
	private int Count;
	private int RnewFlag;
	private double AddRate;
	private String PolNo;
	private double Amnt;
	private double FloatRate;
	private String RiskCode;
	private String StandbyFlag1;
	private String StandbyFlag2;
	private String StandbyFlag3;
	private String GrpPolNo;
	private String EdorNo;
	private double GetLimit;
	private double GetRate;
	private String ContNo;
	private String LiveGetMode;
	private String CValiDate;
	private String DutyCode;
	private String BonusGetMode;

	public String getBonusGetMode()
	{
		return BonusGetMode;
	}

	public void setBonusGetMode(String bonusGetMode)
	{
		BonusGetMode = bonusGetMode;
	}

	public int getAppAgeType()
	{
		return AppAgeType;
	}

	public void setAppAgeType(int appAgeType)
	{
		AppAgeType = appAgeType;
	}

	public String getDutyCode()
	{
		return DutyCode;
	}

	public void setDutyCode(String dutyCode)
	{
		DutyCode = dutyCode;
	}

	public CheckBase()
	{
	}

	public void setPrem(double tPrem)
	{
		Prem = tPrem;
	}

	public String getCValiDate()
	{
		return String.valueOf(CValiDate);
	}

	public void setCValiDate(String CValiDate)
	{
		CValiDate = CValiDate;
	}

	public String getPrem()
	{
		return String.valueOf(Prem);
	}

	public void setContNo(String tContNo)
	{
		ContNo = tContNo;
	}

	public String getContNo()
	{
		return ContNo;
	}

	public void setLiveGetMode(String LiveGetMode)
	{
		LiveGetMode = LiveGetMode;
	}

	public String getLiveGetMode()
	{
		return LiveGetMode;
	}

	public void setAmnt(double tAmnt)
	{
		Amnt = tAmnt;
	}

	public String getAmnt()
	{
		return String.valueOf(Amnt);
	}

	public void setMult(double tMult)
	{
		Mult = tMult;
	}

	public String getMult()
	{
		return String.valueOf(Mult);
	}

	public void setFloatRate(double tFloatRate)
	{
		FloatRate = tFloatRate;
	}

	public String getFloatRate()
	{
		return String.valueOf(FloatRate);
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

	public void setYears(int tYears)
	{
		Years = tYears;
	}

	public String getYears()
	{
		return String.valueOf(Years);
	}

	public void setInsuYear(int tInsuYear)
	{
		InsuYear = tInsuYear;
	}

	public String getInsuYear()
	{
		return String.valueOf(InsuYear);
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

	public void setRnewFlag(int tRnewFlag)
	{
		RnewFlag = tRnewFlag;
	}

	public String getRnewFlag()
	{
		return String.valueOf(RnewFlag);
	}

	public void setSex(String tSex)
	{
		Sex = tSex;
	}

	public String getSex()
	{
		return Sex;
	}

	public void setInsuYearFlag(String tInsuYearFlag)
	{
		InsuYearFlag = tInsuYearFlag;
	}

	public String getInsuYearFlag()
	{
		return InsuYearFlag;
	}

	public void setPayEndYearFlag(String tPayEndYearFlag)
	{
		PayEndYearFlag = tPayEndYearFlag;
	}

	public String getPayEndYearFlag()
	{
		return PayEndYearFlag;
	}

	public void setGetYearFlag(String tGetYearFlag)
	{
		GetYearFlag = tGetYearFlag;
	}

	public String getGetYearFlag()
	{
		return GetYearFlag;
	}

	public void setGetDutyKind(String tGetDutyKind)
	{
		GetDutyKind = tGetDutyKind;
	}

	public String getGetDutyKind()
	{
		return GetDutyKind;
	}

	public void setStartDateCalRef(String tStartDateCalRef)
	{
		StartDateCalRef = tStartDateCalRef;
	}

	public String getStartDateCalRef()
	{
		return StartDateCalRef;
	}

	public void setOccupationType(String tOccupationType)
	{
		OccupationType = tOccupationType;
	}

	public String getOccupationType()
	{
		return OccupationType;
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

	public void setRiskCode(String tRiskCode)
	{
		RiskCode = tRiskCode;
	}

	public String getRiskCode()
	{
		return RiskCode;
	}

	public void setStandbyFlag1(String tStandbyFlag1)
	{
		StandbyFlag1 = tStandbyFlag1;
	}

	public String getStandbyFlag1()
	{
		return StandbyFlag1;
	}

	public void setStandbyFlag2(String tStandbyFlag2)
	{
		StandbyFlag2 = tStandbyFlag2;
	}

	public String getStandbyFlag2()
	{
		return StandbyFlag2;
	}

	public void setStandbyFlag3(String tStandbyFlag3)
	{
		StandbyFlag3 = tStandbyFlag3;
	}

	public String getStandbyFlag3()
	{
		return StandbyFlag3;
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

	public void setGetLimit(double tGetLimit)
	{
		GetLimit = tGetLimit;
	}

	public String getGetLimit()
	{
		return String.valueOf(GetLimit);
	}

	public void setGetRate(double tGetRate)
	{
		GetRate = tGetRate;
	}

	public String getGetRate()
	{
		return String.valueOf(GetRate);
	}

	public String getMainPolNo()
	{
		return MainPolNo;
	}

	public void setMainPolNo(String mainPolNo)
	{
		MainPolNo = mainPolNo;
	}
}
