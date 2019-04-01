// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PolElementSchema.java

package com.sinosoft.banklns.lnsmodel.util;

import com.sinosoft.banklns.lis.pubfun.FDate;
import java.util.Date;

public class PolElementSchema
	implements Cloneable
{

	private FDate fDate;
	private String GrpContNo;
	private String GrpPolNo;
	private String PrtNo;
	private String ContType;
	private String InsuredNo;
	private String InsuredId;
	private String Name;
	private String Sex;
	private String Birthday;
	private String OccupationCode;
	private String AppAgeType;
	private int AppAge;
	private String RelationToAppnt;
	private String InsuredNativePlace;
	private String InsuredNo2;
	private String AppAge2Type;
	private String AppAge2;
	private String AppntNo;
	private String AppntId;
	private String AppntNativePlace;
	private String AppntOccupationCode;
	private String AppntAgeType;
	private int AppntAge;
	private String AppntSex;
	private String AgentCode;
	private String RiskChannel;
	private String ManageCom;
	private String MainPolNo;
	private String MasterPolNo;
	private String MainPolAmnt;
	private String ContNo;
	private String DutyCode;
	private String RiskCode;
	private String PolNo;
	private double Amnt;
	private double Get;
	private double Mult;
	private double Prem;
	private double StandardPrem;
	private String VPU;
	private int PayEndYear;
	private String PayEndYearFlag;
	private int GetYear;
	private String GetYearFlag;
	private int InsuYear;
	private String InsuYearFlag;
	private int PayIntv;
	private int GetIntv;
	private int Years;
	private int PayYears;
	private String LiveGetMode;
	private String SubRiskFlag;
	private String BonusGetMode;
	private String StandbyFlag1;
	private String StandbyFlag2;
	private String StandbyFlag3;
	private double RiskAmnt;
	private double SumLifeRiskAmnt;
	private double SumAccRiskAmnt;
	private double SumDeaRiskAmnt;
	private double SumDeaDutyRiskAmnt;
	private double SumBodRiskAmnt;
	private Date MakeDate;
	private String MakeTime;
	private String ProposalContNo;
	private String ProposalNo;
	private String BranchType;
	private double TopUpPrem;
	private String DeadAmntType;
	private String PValiDate;

	public PolElementSchema()
	{
		fDate = new FDate();
	}

	public String getPValiDate()
	{
		return PValiDate;
	}

	public void setPValiDate(String valiDate)
	{
		PValiDate = valiDate;
	}

	public String getAppAgeType()
	{
		return AppAgeType;
	}

	public void setAppAgeType(String appAgeType)
	{
		AppAgeType = appAgeType;
	}

	public String getAppAge2Type()
	{
		return AppAge2Type;
	}

	public void setAppAge2Type(String appAge2Type)
	{
		AppAge2Type = appAge2Type;
	}

	public String getAppntAgeType()
	{
		return AppntAgeType;
	}

	public void setAppntAgeType(String appntAgeType)
	{
		AppntAgeType = appntAgeType;
	}

	public double getTopUpPrem()
	{
		return TopUpPrem;
	}

	public void setTopUpPrem(double topUpPrem)
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

	public String getBranchType()
	{
		return BranchType;
	}

	public void setBranchType(String branchType)
	{
		BranchType = branchType;
	}

	public String getInsuredId()
	{
		return InsuredId;
	}

	public void setInsuredId(String insuredId)
	{
		InsuredId = insuredId;
	}

	public String getAppntId()
	{
		return AppntId;
	}

	public void setAppntId(String appntId)
	{
		AppntId = appntId;
	}

	public String getGrpContNo()
	{
		return GrpContNo;
	}

	public void setGrpContNo(String grpContNo)
	{
		GrpContNo = grpContNo;
	}

	public String getGrpPolNo()
	{
		return GrpPolNo;
	}

	public void setGrpPolNo(String grpPolNo)
	{
		GrpPolNo = grpPolNo;
	}

	public String getPrtNo()
	{
		return PrtNo;
	}

	public void setPrtNo(String prtNo)
	{
		PrtNo = prtNo;
	}

	public String getContType()
	{
		return ContType;
	}

	public void setContType(String contType)
	{
		ContType = contType;
	}

	public String getMasterPolNo()
	{
		return MasterPolNo;
	}

	public void setMasterPolNo(String masterPolNo)
	{
		MasterPolNo = masterPolNo;
	}

	public String getProposalContNo()
	{
		return ProposalContNo;
	}

	public void setProposalContNo(String proposalContNo)
	{
		ProposalContNo = proposalContNo;
	}

	public String getProposalNo()
	{
		return ProposalNo;
	}

	public void setProposalNo(String proposalNo)
	{
		ProposalNo = proposalNo;
	}

	public String getMakeDate()
	{
		if (MakeDate != null)
			return fDate.getString(MakeDate);
		else
			return null;
	}

	public void setMakeDate(Date aMakeDate)
	{
		MakeDate = aMakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals(""))
			MakeDate = fDate.getDate(aMakeDate);
		else
			MakeDate = null;
	}

	public String getMakeTime()
	{
		return MakeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		MakeTime = aMakeTime;
	}

	public double getAmnt()
	{
		return Amnt;
	}

	public void setAmnt(double amnt)
	{
		Amnt = amnt;
	}

	public int getAppAge()
	{
		return AppAge;
	}

	public void setAppAge(int appAge)
	{
		AppAge = appAge;
	}

	public String getAppAge2()
	{
		return AppAge2;
	}

	public void setAppAge2(String appAge2)
	{
		AppAge2 = appAge2;
	}

	public int getAppntAge()
	{
		return AppntAge;
	}

	public void setAppntAge(int appntAge)
	{
		AppntAge = appntAge;
	}

	public String getAppntNativePlace()
	{
		return AppntNativePlace;
	}

	public void setAppntNativePlace(String appntNativePlace)
	{
		AppntNativePlace = appntNativePlace;
	}

	public String getAppntNo()
	{
		return AppntNo;
	}

	public void setAppntNo(String appntNo)
	{
		AppntNo = appntNo;
	}

	public String getAppntOccupationCode()
	{
		return AppntOccupationCode;
	}

	public void setAppntOccupationCode(String appntOccupationCode)
	{
		AppntOccupationCode = appntOccupationCode;
	}

	public String getBirthday()
	{
		return Birthday;
	}

	public void setBirthday(String birthday)
	{
		Birthday = birthday;
	}

	public String getBonusGetMode()
	{
		return BonusGetMode;
	}

	public void setBonusGetMode(String bonusGetMode)
	{
		BonusGetMode = bonusGetMode;
	}

	public String getContNo()
	{
		return ContNo;
	}

	public void setContNo(String contNo)
	{
		ContNo = contNo;
	}

	public String getDutyCode()
	{
		return DutyCode;
	}

	public void setDutyCode(String dutyCode)
	{
		DutyCode = dutyCode;
	}

	public double getGet()
	{
		return Get;
	}

	public void setGet(double get)
	{
		Get = get;
	}

	public int getGetIntv()
	{
		return GetIntv;
	}

	public void setGetIntv(int getIntv)
	{
		GetIntv = getIntv;
	}

	public int getGetYear()
	{
		return GetYear;
	}

	public void setGetYear(int getYear)
	{
		GetYear = getYear;
	}

	public String getGetYearFlag()
	{
		return GetYearFlag;
	}

	public void setGetYearFlag(String getYearFlag)
	{
		GetYearFlag = getYearFlag;
	}

	public String getInsuredNativePlace()
	{
		return InsuredNativePlace;
	}

	public void setInsuredNativePlace(String insuredNativePlace)
	{
		InsuredNativePlace = insuredNativePlace;
	}

	public String getInsuredNo()
	{
		return InsuredNo;
	}

	public void setInsuredNo(String insuredNo)
	{
		InsuredNo = insuredNo;
	}

	public String getInsuredNo2()
	{
		return InsuredNo2;
	}

	public void setInsuredNo2(String insuredNo2)
	{
		InsuredNo2 = insuredNo2;
	}

	public int getInsuYear()
	{
		return InsuYear;
	}

	public void setInsuYear(int insuYear)
	{
		InsuYear = insuYear;
	}

	public String getInsuYearFlag()
	{
		return InsuYearFlag;
	}

	public void setInsuYearFlag(String insuYearFlag)
	{
		InsuYearFlag = insuYearFlag;
	}

	public String getLiveGetMode()
	{
		return LiveGetMode;
	}

	public void setLiveGetMode(String liveGetMode)
	{
		LiveGetMode = liveGetMode;
	}

	public String getMainPolAmnt()
	{
		return MainPolAmnt;
	}

	public void setMainPolAmnt(String mainPolAmnt)
	{
		MainPolAmnt = mainPolAmnt;
	}

	public String getMainPolNo()
	{
		return MainPolNo;
	}

	public void setMainPolNo(String mainPolNo)
	{
		MainPolNo = mainPolNo;
	}

	public String getManageCom()
	{
		return ManageCom;
	}

	public void setManageCom(String manageCom)
	{
		ManageCom = manageCom;
	}

	public double getMult()
	{
		return Mult;
	}

	public void setMult(double mult)
	{
		Mult = mult;
	}

	public String getName()
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	public String getOccupationCode()
	{
		return OccupationCode;
	}

	public void setOccupationCode(String occupationCode)
	{
		OccupationCode = occupationCode;
	}

	public int getPayEndYear()
	{
		return PayEndYear;
	}

	public void setPayEndYear(int payEndYear)
	{
		PayEndYear = payEndYear;
	}

	public String getPayEndYearFlag()
	{
		return PayEndYearFlag;
	}

	public void setPayEndYearFlag(String payEndYearFlag)
	{
		PayEndYearFlag = payEndYearFlag;
	}

	public int getPayIntv()
	{
		return PayIntv;
	}

	public void setPayIntv(int payIntv)
	{
		PayIntv = payIntv;
	}

	public int getPayYears()
	{
		return PayYears;
	}

	public void setPayYears(int payYears)
	{
		PayYears = payYears;
	}

	public String getPolNo()
	{
		return PolNo;
	}

	public void setPolNo(String polNo)
	{
		PolNo = polNo;
	}

	public double getPrem()
	{
		return Prem;
	}

	public void setPrem(double prem)
	{
		Prem = prem;
	}

	public String getRelationToAppnt()
	{
		return RelationToAppnt;
	}

	public void setRelationToAppnt(String relationToAppnt)
	{
		RelationToAppnt = relationToAppnt;
	}

	public double getRiskAmnt()
	{
		return RiskAmnt;
	}

	public void setRiskAmnt(double riskAmnt)
	{
		RiskAmnt = riskAmnt;
	}

	public String getRiskChannel()
	{
		return RiskChannel;
	}

	public void setRiskChannel(String riskChannel)
	{
		RiskChannel = riskChannel;
	}

	public String getRiskCode()
	{
		return RiskCode;
	}

	public void setRiskCode(String riskCode)
	{
		RiskCode = riskCode;
	}

	public String getSex()
	{
		return Sex;
	}

	public void setSex(String sex)
	{
		Sex = sex;
	}

	public String getStandbyFlag1()
	{
		return StandbyFlag1;
	}

	public void setStandbyFlag1(String standbyFlag1)
	{
		StandbyFlag1 = standbyFlag1;
	}

	public String getStandbyFlag2()
	{
		return StandbyFlag2;
	}

	public void setStandbyFlag2(String standbyFlag2)
	{
		StandbyFlag2 = standbyFlag2;
	}

	public String getStandbyFlag3()
	{
		return StandbyFlag3;
	}

	public void setStandbyFlag3(String standbyFlag3)
	{
		StandbyFlag3 = standbyFlag3;
	}

	public String getSubRiskFlag()
	{
		return SubRiskFlag;
	}

	public void setSubRiskFlag(String subRiskFlag)
	{
		SubRiskFlag = subRiskFlag;
	}

	public double getSumAccRiskAmnt()
	{
		return SumAccRiskAmnt;
	}

	public void setSumAccRiskAmnt(double sumAccRiskAmnt)
	{
		SumAccRiskAmnt = sumAccRiskAmnt;
	}

	public double getSumBodRiskAmnt()
	{
		return SumBodRiskAmnt;
	}

	public void setSumBodRiskAmnt(double sumBodRiskAmnt)
	{
		SumBodRiskAmnt = sumBodRiskAmnt;
	}

	public double getSumDeaRiskAmnt()
	{
		return SumDeaRiskAmnt;
	}

	public void setSumDeaRiskAmnt(double sumDeaRiskAmnt)
	{
		SumDeaRiskAmnt = sumDeaRiskAmnt;
	}

	public double getSumLifeRiskAmnt()
	{
		return SumLifeRiskAmnt;
	}

	public void setSumLifeRiskAmnt(double sumLifeRiskAmnt)
	{
		SumLifeRiskAmnt = sumLifeRiskAmnt;
	}

	public String getVPU()
	{
		return VPU;
	}

	public void setVPU(String vpu)
	{
		VPU = vpu;
	}

	public int getYears()
	{
		return Years;
	}

	public void setYears(int years)
	{
		Years = years;
	}

	public String getAgentCode()
	{
		return AgentCode;
	}

	public void setAgentCode(String agentCode)
	{
		AgentCode = agentCode;
	}

	public Object clone()
	{
		PolElementSchema cloned = null;
		try
		{
			cloned = (PolElementSchema)super.clone();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cloned;
	}

	public String getAppntSex()
	{
		return AppntSex;
	}

	public void setAppntSex(String appntSex)
	{
		AppntSex = appntSex;
	}

	public double getStandardPrem()
	{
		return StandardPrem;
	}

	public void setStandardPrem(double standardPrem)
	{
		StandardPrem = standardPrem;
	}

	public double getSumDeaDutyRiskAmnt()
	{
		return SumDeaDutyRiskAmnt;
	}

	public void setSumDeaDutyRiskAmnt(double sumDeaDutyRiskAmnt)
	{
		SumDeaDutyRiskAmnt = sumDeaDutyRiskAmnt;
	}
}
