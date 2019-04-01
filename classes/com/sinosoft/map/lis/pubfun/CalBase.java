// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CalBase.java

package com.sinosoft.map.lis.pubfun;

import java.util.Date;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			FDate

public class CalBase
{

	private double Prem;
	private double Get;
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
	private String Sex;
	private String Job;
	private String GDuty;
	private int Count;
	private int RnewFlag;
	private double AddRate;
	private String ContNo;
	private String PolNo;
	private double Amnt;
	private double FloatRate;
	private String RiskCode;
	private String StandbyFlag1;
	private String StandbyFlag2;
	private String StandbyFlag3;
	private String GrpContNo;
	private String GrpPolNo;
	private String EdorNo;
	private String CalType;
	private double GetLimit;
	private double GetRate;
	private String SSFlag;
	private double PeakLine;
	private String CValiDate;
	private double SuppRiskScore;
	private double FirstScore;
	private double SecondScore;
	private String DutyCode;
	private String VPU;
	private String SecondInsuredNo;
	private String InsuredNo;
	private String MainPolNo;
	private String AppAg2;
	private double HusbandScore;
	private double WifeScore;
	private String LSumDangerAmnt;
	private String DSumDangerAmnt;
	private String ASumDangerAmnt;
	private String MSumDangerAmnt;
	private String SSumDangerAmnt;
	private String ManageCom;
	private String AppntJob;
	private String MainRiskGet;
	private String RiskSort;
	private String CustomerNo;
	private String Occupation;
	private String MAmnt;
	private String AppAge2;
	private String ContPlanCode;
	private String GetStartType;
	private String PolTypeFlag;
	private double ManageFee;
	private String PayTerm;
	private Date Birthday;
	private Date strBirthday;
	private String PolTerm;
	private String IniAmnt;
	private String GiveIntv;
	private String DrawYear;
	private String CalSql;

	public CalBase()
	{
	}

	public void setPolTypeFlag(String tPolTypeFlag)
	{
		PolTypeFlag = tPolTypeFlag;
	}

	public String getPolTypeFlag()
	{
		return String.valueOf(PolTypeFlag);
	}

	public void setAppAge2(String tAppAge2)
	{
		AppAge2 = tAppAge2;
	}

	public String getAppAge2()
	{
		return String.valueOf(AppAge2);
	}

	public void setGetStartType(String tGetStartType)
	{
		GetStartType = tGetStartType;
	}

	public String getGetStartType()
	{
		return String.valueOf(GetStartType);
	}

	public void setContPlanCode(String tContPlanCode)
	{
		ContPlanCode = tContPlanCode;
	}

	public String getContPlanCode()
	{
		return String.valueOf(ContPlanCode);
	}

	public void setContNo(String tContNo)
	{
		ContNo = tContNo;
	}

	public void setLSumDangerAmnt(String tLSumDangerAmnt)
	{
		LSumDangerAmnt = tLSumDangerAmnt;
	}

	public String getLSumDangerAmnt()
	{
		return String.valueOf(LSumDangerAmnt);
	}

	public void setSSumDangerAmnt(String tLSumDangerAmnt)
	{
		LSumDangerAmnt = tLSumDangerAmnt;
	}

	public String getSSumDangerAmnt()
	{
		return String.valueOf(LSumDangerAmnt);
	}

	public void setMAmnt(String tMAmnt)
	{
		MAmnt = tMAmnt;
	}

	public String getMAmnt()
	{
		return String.valueOf(MAmnt);
	}

	public void setDSumDangerAmnt(String tDSumDangerAmnt)
	{
		DSumDangerAmnt = tDSumDangerAmnt;
	}

	public String getDSumDangerAmnt()
	{
		return String.valueOf(DSumDangerAmnt);
	}

	public void setASumDangerAmnt(String tASumDangerAmnt)
	{
		ASumDangerAmnt = tASumDangerAmnt;
	}

	public String getASumDangerAmnt()
	{
		return String.valueOf(ASumDangerAmnt);
	}

	public void setMSumDangerAmnt(String tMSumDangerAmnt)
	{
		MSumDangerAmnt = tMSumDangerAmnt;
	}

	public String getMSumDangerAmnt()
	{
		return String.valueOf(MSumDangerAmnt);
	}

	public void setManageCom(String tManageCom)
	{
		ManageCom = tManageCom;
	}

	public String getManageCom()
	{
		return String.valueOf(ManageCom);
	}

	public void setAppntJob(String tAppntJob)
	{
		AppntJob = tAppntJob;
	}

	public String getAppntJob()
	{
		return String.valueOf(AppntJob);
	}

	public void setMainRiskGet(String tMainRiskGet)
	{
		MainRiskGet = tMainRiskGet;
	}

	public String getMainRiskGet()
	{
		return String.valueOf(MainRiskGet);
	}

	public void setRiskSort(String tRiskSort)
	{
		RiskSort = tRiskSort;
	}

	public String getRiskSort()
	{
		return String.valueOf(RiskSort);
	}

	public void setCustomerNo(String tCustomerNo)
	{
		CustomerNo = tCustomerNo;
	}

	public String getCustomerNo()
	{
		return String.valueOf(CustomerNo);
	}

	public void setOccupation(String tOccupation)
	{
		Occupation = tOccupation;
	}

	public String getOccupation()
	{
		return String.valueOf(Occupation);
	}

	public void setGrpContNo(String tGrpContNo)
	{
		GrpContNo = tGrpContNo;
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

	public String getContNo()
	{
		return ContNo;
	}

	public String getGrpContNo()
	{
		return GrpContNo;
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

	public void setCalType(String tCalType)
	{
		CalType = tCalType;
	}

	public String getCalType()
	{
		return CalType;
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

	public void setSSFlag(String tSSFlag)
	{
		SSFlag = tSSFlag;
	}

	public String getSSFlag()
	{
		return SSFlag;
	}

	public void setPeakLine(double tPeakLine)
	{
		PeakLine = tPeakLine;
	}

	public String getPeakLine()
	{
		return String.valueOf(PeakLine);
	}

	public void setCValiDate(String tCValiDate)
	{
		CValiDate = tCValiDate;
	}

	public String getCValiDate()
	{
		return CValiDate;
	}

	public void setSuppRiskScore(double tSuppRiskScore)
	{
		SuppRiskScore = tSuppRiskScore;
	}

	public String getSuppRiskScore()
	{
		return String.valueOf(SuppRiskScore);
	}

	public String getDutyCode()
	{
		return DutyCode;
	}

	public void setDutyCode(String tDutyCode)
	{
		DutyCode = tDutyCode;
	}

	public void setFirstScore(double tFirstScore)
	{
		FirstScore = tFirstScore;
	}

	public String getFirstScore()
	{
		return String.valueOf(FirstScore);
	}

	public void setSecondScore(double tSecondScore)
	{
		SecondScore = tSecondScore;
	}

	public String getSecondScore()
	{
		return String.valueOf(SecondScore);
	}

	public void setVPU(String tVPU)
	{
		VPU = tVPU;
	}

	public void setSecondInsuredNo(String tSecondInsuredNo)
	{
		SecondInsuredNo = tSecondInsuredNo;
	}

	public String getSecondInsuredNo()
	{
		return SecondInsuredNo;
	}

	public void setInsuredNo(String tInsuredNo)
	{
		InsuredNo = tInsuredNo;
	}

	public String getInsuredNo()
	{
		return InsuredNo;
	}

	public String getVPU()
	{
		return VPU;
	}

	public void setMainPolNo(String tMainPolNo)
	{
		MainPolNo = tMainPolNo;
	}

	public String getMainPolNo()
	{
		return MainPolNo;
	}

	public void setAppAg2(String tAppAg2)
	{
		AppAg2 = tAppAg2;
	}

	public String getAppAg2()
	{
		return AppAg2;
	}

	public void setHusbandScore(double tHusbandScore)
	{
		HusbandScore = tHusbandScore;
	}

	public String getHusbandScore()
	{
		return String.valueOf(HusbandScore);
	}

	public void setWifeScore(double tWifeScore)
	{
		WifeScore = tWifeScore;
	}

	public String getWifeScore()
	{
		return String.valueOf(WifeScore);
	}

	public void setManageFee(double tManageFee)
	{
		ManageFee = tManageFee;
	}

	public String getManageFee()
	{
		return String.valueOf(ManageFee);
	}

	public String getPayTerm()
	{
		return PayTerm;
	}

	public void setPayTerm(String payTerm)
	{
		PayTerm = payTerm;
	}

	public Date getBirthday()
	{
		return Birthday;
	}

	public void setBirthday(Date birthday)
	{
		Birthday = birthday;
	}

	public String getPolTerm()
	{
		return PolTerm;
	}

	public void setPolTerm(String polTerm)
	{
		PolTerm = polTerm;
	}

	public String getIniAmnt()
	{
		return IniAmnt;
	}

	public void setIniAmnt(String iniAmnt)
	{
		IniAmnt = iniAmnt;
	}

	public String getGiveIntv()
	{
		return GiveIntv;
	}

	public void setGiveIntv(String giveIntv)
	{
		GiveIntv = giveIntv;
	}

	public String getDrawYear()
	{
		return DrawYear;
	}

	public void setDrawYear(String drawYear)
	{
		DrawYear = drawYear;
	}

	public String getCalSql()
	{
		return CalSql;
	}

	public void setCalSql(String calSql)
	{
		CalSql = calSql;
	}

	public String getStrBirthday()
	{
		FDate fDate = new FDate();
		if (strBirthday != null)
			return fDate.getString(strBirthday);
		else
			return null;
	}

	public void setStrBirthday(String strBirthday)
	{
		FDate fDate = new FDate();
		if (strBirthday != null && !"".equals(strBirthday))
			this.strBirthday = fDate.getDate(strBirthday);
		else
			this.strBirthday = null;
	}

	public void setStrBirthday(Date strBirthday)
	{
		this.strBirthday = strBirthday;
	}
}
