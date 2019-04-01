// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CalFactorSchema.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.StrTool;
import java.io.PrintStream;

public class CalFactorSchema
	implements Cloneable
{

	private String Name;
	private String Sex;
	private String Birthday;
	private String IDNo;
	private String IDType;
	private String OccupationType;
	private String GetKind;
	private String Prem;
	private String TopUpPrem;
	private String DeadAmntType;
	private String Get;
	private String PayMode;
	private double FloatRate;
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
	private String Job;
	private int AppntAgeType;
	private int AppntAge;
	private String GDuty;
	private int Count;
	private int RnewFlag;
	private double AddRate;
	private String ContNo;
	private String GrpPolNo;
	private double Amnt;
	private double RiskAmnt;
	private String GrpContNo;
	private String PolNo;
	private String RiskCode;
	private String PayLocation;
	private String GetStartType;
	private String LiveGetMode;
	private String RelFlag;
	private String SubRiskFlag;
	private String StandbyFlag2;
	private String StandbyFlag3;
	private String StandbyFlag1;
	private String BonusGetMode;
	private String AppntNo;
	private int PayYears;
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
	private String AppAg2Type;
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
	private String AppAge2Type;
	private String RiskChannel;
	private String LifeFlag;
	private String RelationToAppnt;
	private String AppntNativePlace;
	private String InsuredNativePlace;

	public CalFactorSchema()
	{
	}

	public Object clone()
	{
		Object o = null;
		try
		{
			o = (CalFactorSchema)super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			System.out.println(e.toString());
		}
		return o;
	}

	public String getTopUpPrem()
	{
		return TopUpPrem;
	}

	public void setTopUpPrem(String topUpPrem)
	{
		TopUpPrem = topUpPrem;
	}

	public String getDeadAmntType()
	{
		return DeadAmntType;
	}

	public void setDeadAmntType(String deadAmntType)
	{
		DeadAmntType = deadAmntType;
	}

	public int getAppAgeType()
	{
		return AppAgeType;
	}

	public void setAppAgeType(int appAgeType)
	{
		AppAgeType = appAgeType;
	}

	public int getAppntAgeType()
	{
		return AppntAgeType;
	}

	public void setAppntAgeType(int appntAgeType)
	{
		AppntAgeType = appntAgeType;
	}

	public String getAppAg2Type()
	{
		return AppAg2Type;
	}

	public void setAppAg2Type(String appAg2Type)
	{
		AppAg2Type = appAg2Type;
	}

	public String getAppAge2Type()
	{
		return AppAge2Type;
	}

	public void setAppAge2Type(String appAge2Type)
	{
		AppAge2Type = appAge2Type;
	}

	public void setLiveGetMode(String tLiveGetMode)
	{
		LiveGetMode = tLiveGetMode;
	}

	public String getLiveGetMode()
	{
		return LiveGetMode;
	}

	public void setMainPolNo(String tMainPolNo)
	{
		MainPolNo = tMainPolNo;
	}

	public String getMainPolNo()
	{
		return MainPolNo;
	}

	public void setGetStartType(String tGetStartType)
	{
		GetStartType = tGetStartType;
	}

	public String getGetStartType()
	{
		return GetStartType;
	}

	public void setPayLocation(String tPayLocation)
	{
		PayLocation = tPayLocation;
	}

	public String getPayLocation()
	{
		return PayLocation;
	}

	public void setName(String tName)
	{
		Name = tName;
	}

	public String getName()
	{
		return Name;
	}

	public void setSex(String tSex)
	{
		Sex = tSex;
	}

	public String getSex()
	{
		return Sex;
	}

	public void setInsuredNo(String tInsuredNo)
	{
		InsuredNo = tInsuredNo;
	}

	public String getInsuredNo()
	{
		return InsuredNo;
	}

	public void setAppntNo(String tAppntNo)
	{
		AppntNo = tAppntNo;
	}

	public String getAppntNo()
	{
		return AppntNo;
	}

	public void setBirthday(String tBirthday)
	{
		Birthday = tBirthday;
	}

	public String getBirthday()
	{
		return Birthday;
	}

	public void setIDNo(String tIDNo)
	{
		IDNo = tIDNo;
	}

	public String getIDNo()
	{
		return IDNo;
	}

	public void setIDType(String tIDType)
	{
		IDType = tIDType;
	}

	public String getIDType()
	{
		return IDType;
	}

	public void setBonusGetMode(String getMode)
	{
		BonusGetMode = getMode;
	}

	public String getBonusGetMode()
	{
		return BonusGetMode;
	}

	public void setOccupationType(String tOccupationType)
	{
		OccupationType = tOccupationType;
	}

	public String getOccupationType()
	{
		return OccupationType;
	}

	public void setCValiDate(String tCValiDate)
	{
		CValiDate = tCValiDate;
	}

	public String getCValiDate()
	{
		return CValiDate;
	}

	public void setGetKind(String tGetKind)
	{
		GetKind = tGetKind;
	}

	public String getGetKind()
	{
		return GetKind;
	}

	public void setPrem(String tPrem)
	{
		Prem = tPrem;
	}

	public String getPrem()
	{
		return Prem;
	}

	public void setGet(String tGet)
	{
		Get = tGet;
	}

	public String getGet()
	{
		return Get;
	}

	public void setPayMode(String tPayMode)
	{
		PayMode = tPayMode;
	}

	public String getPayMode()
	{
		return PayMode;
	}

	public void setFloatRate(double tFloatRate)
	{
		FloatRate = tFloatRate;
	}

	public void setFloatRate(String aFloatRate)
	{
		if (aFloatRate != null && !aFloatRate.equals(""))
		{
			Double tDouble = new Double(aFloatRate);
			double d = tDouble.doubleValue();
			FloatRate = d;
		}
	}

	public double getFloatRate()
	{
		return FloatRate;
	}

	public void setAmnt(double tAmnt)
	{
		Amnt = tAmnt;
	}

	public String getAmnt()
	{
		return String.valueOf(Amnt);
	}

	public void setRiskAmnt(double tAmnt)
	{
		RiskAmnt = tAmnt;
	}

	public String getRiskAmnt()
	{
		return String.valueOf(RiskAmnt);
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

	public void setPayYears(int tPayYears)
	{
		PayYears = tPayYears;
	}

	public String getPayYears()
	{
		return String.valueOf(PayYears);
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

	public void setContNo(String tContNo)
	{
		ContNo = tContNo;
	}

	public String getContNo()
	{
		return ContNo;
	}

	public void setGrpPolNo(String tGrpPolNo)
	{
		GrpPolNo = tGrpPolNo;
	}

	public String getGrpPolNo()
	{
		return GrpPolNo;
	}

	public void setGrpContNo(String tGrpContNo)
	{
		GrpContNo = tGrpContNo;
	}

	public String getPolNo()
	{
		return PolNo;
	}

	public void setPolNo(String tPolNo)
	{
		PolNo = tPolNo;
	}

	public String getGrpContNo()
	{
		return GrpContNo;
	}

	public void setRiskCode(String tRiskCode)
	{
		RiskCode = tRiskCode;
	}

	public String getRiskCode()
	{
		return RiskCode;
	}

	public void setRelFlag(String tRelFlag)
	{
		RelFlag = tRelFlag;
	}

	public String getRelFlag()
	{
		return RelFlag;
	}

	public void setSubRiskFlag(String tSubRiskFlag)
	{
		SubRiskFlag = tSubRiskFlag;
	}

	public String getSubRiskFlag()
	{
		return SubRiskFlag;
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

	public boolean setV(String FCode, String FValue)
	{
		if (StrTool.cTrim(FCode).equals(""))
			return false;
		if (FCode.equals("Name"))
			if (FValue != null && !FValue.equals(""))
				Name = FValue.trim();
			else
				Name = null;
		if (FCode.equals("Sex"))
			if (FValue != null && !FValue.equals(""))
				Sex = FValue.trim();
			else
				Sex = null;
		if (FCode.equals("Birthday"))
			if (FValue != null && !FValue.equals(""))
				Birthday = FValue.trim();
			else
				Birthday = null;
		if (FCode.equals("IDNo"))
			if (FValue != null && !FValue.equals(""))
				IDNo = FValue.trim();
			else
				IDNo = null;
		if (FCode.equals("IDType"))
			if (FValue != null && !FValue.equals(""))
				IDType = FValue.trim();
			else
				IDType = null;
		if (FCode.equals("OccupationType"))
			if (FValue != null && !FValue.equals(""))
				OccupationType = FValue.trim();
			else
				OccupationType = null;
		if (FCode.equals("CValiDate"))
			if (FValue != null && !FValue.equals(""))
				CValiDate = FValue.trim();
			else
				CValiDate = null;
		if (FCode.equals("GetKind"))
			if (FValue != null && !FValue.equals(""))
				GetKind = FValue.trim();
			else
				GetKind = null;
		if (FCode.equals("Prem"))
			if (FValue != null && !FValue.equals(""))
				Prem = FValue.trim();
			else
				Prem = null;
		if (FCode.equals("Get"))
			if (FValue != null && !FValue.equals(""))
				Get = FValue.trim();
			else
				Get = null;
		if (FCode.equals("PayMode"))
			if (FValue != null && !FValue.equals(""))
				PayMode = FValue.trim();
			else
				PayMode = null;
		if (FCode.equals("FloatRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			FloatRate = d;
		}
		if (FCode.equals("Mult") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			Mult = d;
		}
		if (FCode.equals("PayIntv") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			PayIntv = i;
		}
		if (FCode.equals("GetIntv") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			GetIntv = i;
		}
		if (FCode.equals("PayEndYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			PayEndYear = i;
		}
		if (FCode.equals("PayEndYearFlag"))
			if (FValue != null && !FValue.equals(""))
				PayEndYearFlag = FValue.trim();
			else
				PayEndYearFlag = null;
		if (FCode.equals("GetYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			GetYear = i;
		}
		if (FCode.equals("GetYearFlag"))
			if (FValue != null && !FValue.equals(""))
				GetYearFlag = FValue.trim();
			else
				GetYearFlag = null;
		if (FCode.equals("GetDutyKind"))
			if (FValue != null && !FValue.equals(""))
				GetDutyKind = FValue.trim();
			else
				GetDutyKind = null;
		if (FCode.equals("StartDateCalRef"))
			if (FValue != null && !FValue.equals(""))
				StartDateCalRef = FValue.trim();
			else
				StartDateCalRef = null;
		if (FCode.equals("Years") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			Years = i;
		}
		if (FCode.equals("InsuYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			InsuYear = i;
		}
		if (FCode.equals("InsuYearFlag"))
			if (FValue != null && !FValue.equals(""))
				InsuYearFlag = FValue.trim();
			else
				InsuYearFlag = null;
		if (FCode.equals("AppAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			AppAge = i;
		}
		if (FCode.equals("Job"))
			if (FValue != null && !FValue.equals(""))
				Job = FValue.trim();
			else
				Job = null;
		if (FCode.equals("GDuty"))
			if (FValue != null && !FValue.equals(""))
				GDuty = FValue.trim();
			else
				GDuty = null;
		if (FCode.equals("Count") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			Count = i;
		}
		if (FCode.equals("RnewFlag") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			RnewFlag = i;
		}
		if (FCode.equals("AddRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			AddRate = d;
		}
		if (FCode.equals("ContNo"))
			if (FValue != null && !FValue.equals(""))
				ContNo = FValue.trim();
			else
				ContNo = null;
		if (FCode.equals("GrpContNo"))
			if (FValue != null && !FValue.equals(""))
				GrpContNo = FValue.trim();
			else
				GrpContNo = null;
		if (FCode.equals("GrpPolNo"))
			if (FValue != null && !FValue.equals(""))
				GrpPolNo = FValue.trim();
			else
				GrpPolNo = null;
		if (FCode.equals("PolNo"))
			if (FValue != null && !FValue.equals(""))
				PolNo = FValue.trim();
			else
				PolNo = null;
		if (FCode.equals("Amnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			Amnt = d;
		}
		if (FCode.equals("RiskCode"))
			if (FValue != null && !FValue.equals(""))
				RiskCode = FValue.trim();
			else
				RiskCode = null;
		if (FCode.equals("PayLocation"))
			if (FValue != null && !FValue.equals(""))
				PayLocation = FValue.trim();
			else
				PayLocation = null;
		if (FCode.equals("GetStartType"))
			if (FValue != null && !FValue.equals(""))
				GetStartType = FValue.trim();
			else
				GetStartType = null;
		if (FCode.equals("LiveGetMode"))
			if (FValue != null && !FValue.equals(""))
				LiveGetMode = FValue.trim();
			else
				LiveGetMode = null;
		if (FCode.equals("RelFlag"))
			if (FValue != null && !FValue.equals(""))
				RelFlag = FValue.trim();
			else
				RelFlag = null;
		if (FCode.equals("SubRiskFlag"))
			if (FValue != null && !FValue.equals(""))
				SubRiskFlag = FValue.trim();
			else
				SubRiskFlag = null;
		if (FCode.equals("MainPolNo"))
			if (FValue != null && !FValue.equals(""))
				MainPolNo = FValue.trim();
			else
				MainPolNo = null;
		if (FCode.equals("InsuredNo"))
			if (FValue != null && !FValue.equals(""))
				InsuredNo = FValue.trim();
			else
				InsuredNo = null;
		if (FCode.equals("AppntNo"))
			if (FValue != null && !FValue.equals(""))
				AppntNo = FValue.trim();
			else
				AppntNo = null;
		if (FCode.equals("StandbyFlag1"))
			if (FValue != null && !FValue.equals(""))
				StandbyFlag1 = FValue.trim();
			else
				StandbyFlag1 = null;
		if (FCode.equals("StandbyFlag2"))
			if (FValue != null && !FValue.equals(""))
				StandbyFlag2 = FValue.trim();
			else
				StandbyFlag2 = null;
		if (FCode.equals("StandbyFlag3"))
			if (FValue != null && !FValue.equals(""))
				StandbyFlag3 = FValue.trim();
			else
				StandbyFlag3 = null;
		return true;
	}

	public String getAppAg2()
	{
		return AppAg2;
	}

	public void setAppAg2(String appAg2)
	{
		AppAg2 = appAg2;
	}

	public String getAppAge2()
	{
		return AppAge2;
	}

	public void setAppAge2(String appAge2)
	{
		AppAge2 = appAge2;
	}

	public String getAppntJob()
	{
		return AppntJob;
	}

	public void setAppntJob(String appntJob)
	{
		AppntJob = appntJob;
	}

	public String getAppntNativePlace()
	{
		return AppntNativePlace;
	}

	public void setAppntNativePlace(String appntNativePlace)
	{
		AppntNativePlace = appntNativePlace;
	}

	public String getASumDangerAmnt()
	{
		return ASumDangerAmnt;
	}

	public void setASumDangerAmnt(String sumDangerAmnt)
	{
		ASumDangerAmnt = sumDangerAmnt;
	}

	public String getCalType()
	{
		return CalType;
	}

	public void setCalType(String calType)
	{
		CalType = calType;
	}

	public String getCustomerNo()
	{
		return CustomerNo;
	}

	public void setCustomerNo(String customerNo)
	{
		CustomerNo = customerNo;
	}

	public String getDSumDangerAmnt()
	{
		return DSumDangerAmnt;
	}

	public void setDSumDangerAmnt(String sumDangerAmnt)
	{
		DSumDangerAmnt = sumDangerAmnt;
	}

	public String getDutyCode()
	{
		return DutyCode;
	}

	public void setDutyCode(String dutyCode)
	{
		DutyCode = dutyCode;
	}

	public String getEdorNo()
	{
		return EdorNo;
	}

	public void setEdorNo(String edorNo)
	{
		EdorNo = edorNo;
	}

	public double getFirstScore()
	{
		return FirstScore;
	}

	public void setFirstScore(double firstScore)
	{
		FirstScore = firstScore;
	}

	public double getGetLimit()
	{
		return GetLimit;
	}

	public void setGetLimit(double getLimit)
	{
		GetLimit = getLimit;
	}

	public double getGetRate()
	{
		return GetRate;
	}

	public void setGetRate(double getRate)
	{
		GetRate = getRate;
	}

	public double getHusbandScore()
	{
		return HusbandScore;
	}

	public void setHusbandScore(double husbandScore)
	{
		HusbandScore = husbandScore;
	}

	public String getInsuredNativePlace()
	{
		return InsuredNativePlace;
	}

	public void setInsuredNativePlace(String insuredNativePlace)
	{
		InsuredNativePlace = insuredNativePlace;
	}

	public String getLifeFlag()
	{
		return LifeFlag;
	}

	public void setLifeFlag(String lifeFlag)
	{
		LifeFlag = lifeFlag;
	}

	public String getLSumDangerAmnt()
	{
		return LSumDangerAmnt;
	}

	public void setLSumDangerAmnt(String sumDangerAmnt)
	{
		LSumDangerAmnt = sumDangerAmnt;
	}

	public String getMainRiskGet()
	{
		return MainRiskGet;
	}

	public void setMainRiskGet(String mainRiskGet)
	{
		MainRiskGet = mainRiskGet;
	}

	public String getMAmnt()
	{
		return MAmnt;
	}

	public void setMAmnt(String amnt)
	{
		MAmnt = amnt;
	}

	public String getManageCom()
	{
		return ManageCom;
	}

	public void setManageCom(String manageCom)
	{
		ManageCom = manageCom;
	}

	public String getMSumDangerAmnt()
	{
		return MSumDangerAmnt;
	}

	public void setMSumDangerAmnt(String sumDangerAmnt)
	{
		MSumDangerAmnt = sumDangerAmnt;
	}

	public String getOccupation()
	{
		return Occupation;
	}

	public void setOccupation(String occupation)
	{
		Occupation = occupation;
	}

	public double getPeakLine()
	{
		return PeakLine;
	}

	public void setPeakLine(double peakLine)
	{
		PeakLine = peakLine;
	}

	public String getRelationToAppnt()
	{
		return RelationToAppnt;
	}

	public void setRelationToAppnt(String relationToAppnt)
	{
		RelationToAppnt = relationToAppnt;
	}

	public String getRiskChannel()
	{
		return RiskChannel;
	}

	public void setRiskChannel(String riskChannel)
	{
		RiskChannel = riskChannel;
	}

	public String getRiskSort()
	{
		return RiskSort;
	}

	public void setRiskSort(String riskSort)
	{
		RiskSort = riskSort;
	}

	public String getSecondInsuredNo()
	{
		return SecondInsuredNo;
	}

	public void setSecondInsuredNo(String secondInsuredNo)
	{
		SecondInsuredNo = secondInsuredNo;
	}

	public double getSecondScore()
	{
		return SecondScore;
	}

	public void setSecondScore(double secondScore)
	{
		SecondScore = secondScore;
	}

	public String getSSFlag()
	{
		return SSFlag;
	}

	public void setSSFlag(String flag)
	{
		SSFlag = flag;
	}

	public String getSSumDangerAmnt()
	{
		return SSumDangerAmnt;
	}

	public void setSSumDangerAmnt(String sumDangerAmnt)
	{
		SSumDangerAmnt = sumDangerAmnt;
	}

	public double getSuppRiskScore()
	{
		return SuppRiskScore;
	}

	public void setSuppRiskScore(double suppRiskScore)
	{
		SuppRiskScore = suppRiskScore;
	}

	public String getVPU()
	{
		return VPU;
	}

	public void setVPU(String vpu)
	{
		VPU = vpu;
	}

	public double getWifeScore()
	{
		return WifeScore;
	}

	public void setWifeScore(double wifeScore)
	{
		WifeScore = wifeScore;
	}

	public int getAppntAge()
	{
		return AppntAge;
	}

	public void setAppntAge(int appntAge)
	{
		AppntAge = appntAge;
	}
}
