// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BqCalBase.java

package com.sinosoft.map.lis.pubfun;


public class BqCalBase
{

	private double Prem;
	private double SumPrem;
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
	private String Sex;
	private String Job;
	private String GDuty;
	private int Count;
	private double AddRate;
	private String PolNo;
	private String GrpPolNo;
	private String ContNo;
	private String GrpContNo;
	private String AppntNo;
	private String InsuredNo;
	private int Interval;
	private int LimitDay;
	private int PolValiFlag;
	private double LoanMoney;
	private double TrayMoney;
	private String Operator;
	private String EdorAcceptNo;
	private String EdorNo;
	private String EdorType;
	private String EdorValiDate;
	private double GetMoney;
	private String GetStartDate;
	private String CValiDate;
	private double GetBalance;
	private String RiskCode;
	private double FloatRate;
	private int InsuYear;
	private String InsuYearFlag;
	private String StandByFlag1;
	private String DownPolYears;
	private String UpPolYears;
	private double LastPrem;
	private String ZTPoint;
	private String PayToDate;
	private String EndDate;
	private String EdorAppDate;
	private double NewPrem;
	private String CalType;
	private int RemainYear;
	private String StartDate;
	private String AAYears;
	private double SumDangerAmnt;
	private double SumInvaliAmnt;
	private String GetDutyCode;
	private String GetDutyKind;
	private int GetCount;
	private double SumGet;
	private double CashValue;
	private double AvailableAmnt;
	private double FinalBonus;
	private int IntvMonth;
	private String DutyCode;
	private double Amnt;
	private double VPU;
	private double SumAmntBonus;
	private double TotalPrem;
	private int PayTimes;
	private String NSMonths;
	private String BonusRate;
	private String ForceDVFlag;
	private String CashFlag;
	private String HesitateFlag;
	private double ContSumLoan;
	private int InsuYearT1;
	private int InsuYearT2;
	private String MainPolNo;
	private String ManageCom;
	private String EdorTypeCal;
	private String BnfType;
	private String CalMode;
	private String PlanCode;

	public BqCalBase()
	{
	}

	public void setEdorAppDate(String tEdorAppDate)
	{
		EdorAppDate = tEdorAppDate;
	}

	public String getEdorAppDate()
	{
		return EdorAppDate;
	}

	public void setDownPolYears(String tDownPolYears)
	{
		DownPolYears = tDownPolYears;
	}

	public String getDownPolYears()
	{
		return DownPolYears;
	}

	public void setUpPolYears(String tUpPolYears)
	{
		UpPolYears = tUpPolYears;
	}

	public String getUpPolYears()
	{
		return UpPolYears;
	}

	public void setZTPoint(String tZTPoint)
	{
		ZTPoint = tZTPoint;
	}

	public String getZTPoint()
	{
		return ZTPoint;
	}

	public void setPayToDate(String tPayToDate)
	{
		PayToDate = tPayToDate;
	}

	public String getPayToDate()
	{
		return PayToDate;
	}

	public void setEndDate(String tEndDate)
	{
		EndDate = tEndDate;
	}

	public String getEndDate()
	{
		return EndDate;
	}

	public void setInsuYear(int tInsuYear)
	{
		InsuYear = tInsuYear;
	}

	public String getInsuYear()
	{
		return String.valueOf(InsuYear);
	}

	public void setInsuYearFlag(String tInsuYearFlag)
	{
		InsuYearFlag = tInsuYearFlag;
	}

	public String getInsuYearFlag()
	{
		return InsuYearFlag;
	}

	public void setInterval(int tInterval)
	{
		Interval = tInterval;
	}

	public String getInterval()
	{
		return String.valueOf(Interval);
	}

	public void setLimitDay(int tLimitDay)
	{
		LimitDay = tLimitDay;
	}

	public String getLimitDay()
	{
		return String.valueOf(LimitDay);
	}

	public void setPolValiFlag(int tPolValiFlag)
	{
		PolValiFlag = tPolValiFlag;
	}

	public String getPolValiFlag()
	{
		return String.valueOf(PolValiFlag);
	}

	public String getLoanMoney()
	{
		return String.valueOf(LoanMoney);
	}

	public void setLoanMoney(double tLoanMoney)
	{
		LoanMoney = tLoanMoney;
	}

	public String getContSumLoan()
	{
		return String.valueOf(ContSumLoan);
	}

	public void setContSumLoan(double tContSumLoan)
	{
		ContSumLoan = tContSumLoan;
	}

	public String getTrayMoney()
	{
		return String.valueOf(TrayMoney);
	}

	public void setTrayMoney(double tTrayMoney)
	{
		TrayMoney = tTrayMoney;
	}

	public String getOperator()
	{
		return String.valueOf(Operator);
	}

	public void setOperator(String tOperator)
	{
		Operator = tOperator;
	}

	public void setPrem(double tPrem)
	{
		Prem = tPrem;
	}

	public String getPrem()
	{
		return String.valueOf(Prem);
	}

	public void setSumPrem(double tSumPrem)
	{
		SumPrem = tSumPrem;
	}

	public String getSumPrem()
	{
		return String.valueOf(SumPrem);
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

	public void setContNo(String tContNo)
	{
		ContNo = tContNo;
	}

	public String getContNo()
	{
		return ContNo;
	}

	public void setGrpContNo(String tGrpContNo)
	{
		GrpContNo = tGrpContNo;
	}

	public String getGrpContNo()
	{
		return GrpContNo;
	}

	public void setAppntNo(String tAppntNo)
	{
		AppntNo = tAppntNo;
	}

	public String getAppntNo()
	{
		return AppntNo;
	}

	public void setInsuredNo(String tInsuredNo)
	{
		InsuredNo = tInsuredNo;
	}

	public String getInsuredNo()
	{
		return InsuredNo;
	}

	public void setEdorAcceptNo(String tEdorAcceptNo)
	{
		EdorAcceptNo = tEdorAcceptNo;
	}

	public String getEdorAcceptNo()
	{
		return EdorAcceptNo;
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

	public void setFloatRate(double tFloatRate)
	{
		FloatRate = tFloatRate;
	}

	public String getFloatRate()
	{
		return String.valueOf(FloatRate);
	}

	public void setStandByFlag1(String tStandByFlag1)
	{
		StandByFlag1 = tStandByFlag1;
	}

	public String getStandByFlag1()
	{
		return StandByFlag1;
	}

	public void setNewPrem(double tNewPrem)
	{
		NewPrem = tNewPrem;
	}

	public String getNewPrem()
	{
		return String.valueOf(NewPrem);
	}

	public void setCalType(String tCalType)
	{
		CalType = tCalType;
	}

	public String getCalType()
	{
		return CalType;
	}

	public void setRemainYear(int tRemainYear)
	{
		RemainYear = tRemainYear;
	}

	public String getRemainYear()
	{
		return String.valueOf(RemainYear);
	}

	public void setStartDate(String tStartDate)
	{
		StartDate = tStartDate;
	}

	public String getStartDate()
	{
		return StartDate;
	}

	public void setAAYears(String tAAYears)
	{
		AAYears = tAAYears;
	}

	public String getAAYears()
	{
		return AAYears;
	}

	public void setSumDangerAmnt(double tSumDangerAmnt)
	{
		SumDangerAmnt = tSumDangerAmnt;
	}

	public String getSumDangerAmnt()
	{
		return String.valueOf(SumDangerAmnt);
	}

	public void setSumInvaliAmnt(double tSumInvaliAmnt)
	{
		SumInvaliAmnt = tSumInvaliAmnt;
	}

	public String getSumInvaliAmnt()
	{
		return String.valueOf(SumInvaliAmnt);
	}

	public void setGetDutyCode(String tGetDutyCode)
	{
		GetDutyCode = tGetDutyCode;
	}

	public String getGetDutyCode()
	{
		return GetDutyCode;
	}

	public void setGetCount(int tGetCount)
	{
		GetCount = tGetCount;
	}

	public String getGetCount()
	{
		return String.valueOf(GetCount);
	}

	public void setSumGet(double tSumGet)
	{
		SumGet = tSumGet;
	}

	public String getSumGet()
	{
		return String.valueOf(SumGet);
	}

	public void setCashValue(double tCashValue)
	{
		CashValue = tCashValue;
	}

	public String getCashValue()
	{
		return String.valueOf(CashValue);
	}

	public void setAvailableAmnt(double tAvailableAmnt)
	{
		AvailableAmnt = tAvailableAmnt;
	}

	public String getAvailableAmnt()
	{
		return String.valueOf(AvailableAmnt);
	}

	public void setFinalBonus(double tFinalBonus)
	{
		FinalBonus = tFinalBonus;
	}

	public String getFinalBonus()
	{
		return String.valueOf(FinalBonus);
	}

	public void setDutyCode(String tDutyCode)
	{
		DutyCode = tDutyCode;
	}

	public String getDutyCode()
	{
		return DutyCode;
	}

	public void setAmnt(double tAmnt)
	{
		Amnt = tAmnt;
	}

	public String getAmnt()
	{
		return String.valueOf(Amnt);
	}

	public void setVPU(double tVPU)
	{
		VPU = tVPU;
	}

	public String getVPU()
	{
		return String.valueOf(VPU);
	}

	public void setSumAmntBonus(double tSumAmntBonus)
	{
		SumAmntBonus = tSumAmntBonus;
	}

	public String getSumAmntBonus()
	{
		return String.valueOf(SumAmntBonus);
	}

	public void setTotalPrem(double tTotalPrem)
	{
		TotalPrem = tTotalPrem;
	}

	public String getTotalPrem()
	{
		return String.valueOf(TotalPrem);
	}

	public void setGetDutyKind(String tGetDutyKind)
	{
		GetDutyKind = tGetDutyKind;
	}

	public String getGetDutyKind()
	{
		return GetDutyKind;
	}

	public void setPayTimes(int tPayTimes)
	{
		PayTimes = tPayTimes;
	}

	public String getPayTimes()
	{
		return String.valueOf(PayTimes);
	}

	public void setNSMonths(int aNSMonths)
	{
		NSMonths = String.valueOf(aNSMonths);
	}

	public String getNSMonths()
	{
		return NSMonths;
	}

	public void setBonusRate(double aBonusRate)
	{
		BonusRate = String.valueOf(aBonusRate);
	}

	public String getBonusRate()
	{
		return BonusRate;
	}

	public void setForceDVFlag(String aForceDVFlag)
	{
		ForceDVFlag = aForceDVFlag;
	}

	public String getForceDVFlag()
	{
		return ForceDVFlag;
	}

	public void setCashFlag(String tCashFlag)
	{
		CashFlag = tCashFlag;
	}

	public String getCashFlag()
	{
		return CashFlag;
	}

	public void setHesitateFlag(String aHesitateFlag)
	{
		HesitateFlag = aHesitateFlag;
	}

	public String getHesitateFlag()
	{
		return HesitateFlag;
	}

	public void setIntvMonth(int aIntvMonth)
	{
		IntvMonth = aIntvMonth;
	}

	public String getIntvMonth()
	{
		return String.valueOf(IntvMonth);
	}

	public void setInsuYearT1(int aInsuYearT1)
	{
		InsuYearT1 = aInsuYearT1;
	}

	public String getInsuYearT1()
	{
		return String.valueOf(InsuYearT1);
	}

	public void setInsuYearT2(int aInsuYearT2)
	{
		InsuYearT2 = aInsuYearT2;
	}

	public String getInsuYearT2()
	{
		return String.valueOf(InsuYearT2);
	}

	public void setLastPrem(double aLastPrem)
	{
		LastPrem = aLastPrem;
	}

	public String getLastPrem()
	{
		return String.valueOf(LastPrem);
	}

	public void setMainPolNo(String tMainPolNo)
	{
		MainPolNo = tMainPolNo;
	}

	public String getMainPolNo()
	{
		return MainPolNo;
	}

	public void setManageCom(String tManageCom)
	{
		ManageCom = tManageCom;
	}

	public String getManageCom()
	{
		return String.valueOf(ManageCom);
	}

	public void setEdorTypeCal(String tEdorTypeCal)
	{
		EdorTypeCal = tEdorTypeCal;
	}

	public String getEdorTypeCal()
	{
		return String.valueOf(EdorTypeCal);
	}

	public void setBnfType(String tBnfType)
	{
		BnfType = tBnfType;
	}

	public String getBnfType()
	{
		return String.valueOf(BnfType);
	}

	public void setCalMode(String tCalMode)
	{
		CalMode = tCalMode;
	}

	public String getCalMode()
	{
		return String.valueOf(CalMode);
	}

	public void setPlanCode(String tPlanCode)
	{
		PlanCode = tPlanCode;
	}

	public String getPlanCode()
	{
		return String.valueOf(PlanCode);
	}
}
