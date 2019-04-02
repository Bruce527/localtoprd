// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPolSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPPolDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPPolSchema
	implements Schema, Cloneable
{

	private String grpContNo;
	private String grpPolNo;
	private String contNo;
	private String proposalContNo;
	private String polNo;
	private String proposalNo;
	private String prtNo;
	private String contType;
	private String polTypeFlag;
	private String mainPolNo;
	private String masterPolNo;
	private String kindCode;
	private String riskCode;
	private String riskVersion;
	private String manageCom;
	private String agentCom;
	private String agentType;
	private String agentCode;
	private String agentGroup;
	private String agentGroup1;
	private String agentCode1;
	private String saleChnl;
	private String handler;
	private String insuredNo;
	private String insuredId;
	private String insuredName;
	private String insuredSex;
	private Date insuredBirthday;
	private int insuredAppAge;
	private int insuredPeoples;
	private String occupationType;
	private String appntNo;
	private String appntName;
	private Date cValiDate;
	private String signCom;
	private Date signDate;
	private String signTime;
	private Date firstPayDate;
	private Date payEndDate;
	private Date paytoDate;
	private Date getStartDate;
	private Date endDate;
	private Date acciEndDate;
	private String getYearFlag;
	private int getYear;
	private String payEndYearFlag;
	private int payEndYear;
	private String insuYearFlag;
	private int insuYear;
	private String acciYearFlag;
	private int acciYear;
	private String getStartType;
	private String specifyValiDate;
	private String payMode;
	private String payLocation;
	private int payIntv;
	private int payYears;
	private int years;
	private double manageFeeRate;
	private double floatRate;
	private double premRate;
	private String premToAmnt;
	private double mult;
	private double standPrem;
	private double prem;
	private double sumPrem;
	private double amnt;
	private double riskAmnt;
	private double leavingMoney;
	private int endorseTimes;
	private int claimTimes;
	private int liveTimes;
	private int renewCount;
	private Date lastGetDate;
	private Date lastLoanDate;
	private Date lastRegetDate;
	private Date lastEdorDate;
	private Date lastRevDate;
	private String rnewFlag;
	private String stopFlag;
	private String expiryFlag;
	private String autoPayFlag;
	private String interestDifFlag;
	private String subFlag;
	private String bnfFlag;
	private String healthCheckFlag;
	private String impartFlag;
	private String reinsureFlag;
	private String agentPayFlag;
	private String agentGetFlag;
	private String liveGetMode;
	private String deadGetMode;
	private String bonusGetMode;
	private String deadAmntType;
	private double topUpPrem;
	private String bonusMan;
	private String deadFlag;
	private String smokeFlag;
	private String remark;
	private String approveFlag;
	private String approveCode;
	private Date approveDate;
	private String approveTime;
	private String uWFlag;
	private String uWCode;
	private Date uWDate;
	private String uWTime;
	private Date polApplyDate;
	private String appFlag;
	private String saleChnlDetail;
	private String polState;
	private String standbyFlag1;
	private String standbyFlag2;
	private String standbyFlag3;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 119;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPPolSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "PolNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPPolSchema cloned = (LNPPolSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getGrpContNo()
	{
		return grpContNo;
	}

	public void setGrpContNo(String aGrpContNo)
	{
		grpContNo = aGrpContNo;
	}

	public String getGrpPolNo()
	{
		return grpPolNo;
	}

	public void setGrpPolNo(String aGrpPolNo)
	{
		grpPolNo = aGrpPolNo;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String aContNo)
	{
		contNo = aContNo;
	}

	public String getProposalContNo()
	{
		return proposalContNo;
	}

	public void setProposalContNo(String aProposalContNo)
	{
		proposalContNo = aProposalContNo;
	}

	public String getPolNo()
	{
		return polNo;
	}

	public void setPolNo(String aPolNo)
	{
		polNo = aPolNo;
	}

	public String getProposalNo()
	{
		return proposalNo;
	}

	public void setProposalNo(String aProposalNo)
	{
		proposalNo = aProposalNo;
	}

	public String getPrtNo()
	{
		return prtNo;
	}

	public void setPrtNo(String aPrtNo)
	{
		prtNo = aPrtNo;
	}

	public String getContType()
	{
		return contType;
	}

	public void setContType(String aContType)
	{
		contType = aContType;
	}

	public String getPolTypeFlag()
	{
		return polTypeFlag;
	}

	public void setPolTypeFlag(String aPolTypeFlag)
	{
		polTypeFlag = aPolTypeFlag;
	}

	public String getMainPolNo()
	{
		return mainPolNo;
	}

	public void setMainPolNo(String aMainPolNo)
	{
		mainPolNo = aMainPolNo;
	}

	public String getMasterPolNo()
	{
		return masterPolNo;
	}

	public void setMasterPolNo(String aMasterPolNo)
	{
		masterPolNo = aMasterPolNo;
	}

	public String getKindCode()
	{
		return kindCode;
	}

	public void setKindCode(String aKindCode)
	{
		kindCode = aKindCode;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String aRiskCode)
	{
		riskCode = aRiskCode;
	}

	public String getRiskVersion()
	{
		return riskVersion;
	}

	public void setRiskVersion(String aRiskVersion)
	{
		riskVersion = aRiskVersion;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getAgentCom()
	{
		return agentCom;
	}

	public void setAgentCom(String aAgentCom)
	{
		agentCom = aAgentCom;
	}

	public String getAgentType()
	{
		return agentType;
	}

	public void setAgentType(String aAgentType)
	{
		agentType = aAgentType;
	}

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
	}

	public String getAgentGroup()
	{
		return agentGroup;
	}

	public void setAgentGroup(String aAgentGroup)
	{
		agentGroup = aAgentGroup;
	}

	public String getAgentGroup1()
	{
		return agentGroup1;
	}

	public void setAgentGroup1(String aAgentGroup1)
	{
		agentGroup1 = aAgentGroup1;
	}

	public String getAgentCode1()
	{
		return agentCode1;
	}

	public void setAgentCode1(String aAgentCode1)
	{
		agentCode1 = aAgentCode1;
	}

	public String getSaleChnl()
	{
		return saleChnl;
	}

	public void setSaleChnl(String aSaleChnl)
	{
		saleChnl = aSaleChnl;
	}

	public String getHandler()
	{
		return handler;
	}

	public void setHandler(String aHandler)
	{
		handler = aHandler;
	}

	public String getInsuredNo()
	{
		return insuredNo;
	}

	public void setInsuredNo(String aInsuredNo)
	{
		insuredNo = aInsuredNo;
	}

	public String getInsuredId()
	{
		return insuredId;
	}

	public void setInsuredId(String aInsuredId)
	{
		insuredId = aInsuredId;
	}

	public String getInsuredName()
	{
		return insuredName;
	}

	public void setInsuredName(String aInsuredName)
	{
		insuredName = aInsuredName;
	}

	public String getInsuredSex()
	{
		return insuredSex;
	}

	public void setInsuredSex(String aInsuredSex)
	{
		insuredSex = aInsuredSex;
	}

	public String getInsuredBirthday()
	{
		if (insuredBirthday != null)
			return fDate.getString(insuredBirthday);
		else
			return null;
	}

	public void setInsuredBirthday(Date aInsuredBirthday)
	{
		insuredBirthday = aInsuredBirthday;
	}

	public void setInsuredBirthday(String aInsuredBirthday)
	{
		if (aInsuredBirthday != null && !aInsuredBirthday.equals(""))
			insuredBirthday = fDate.getDate(aInsuredBirthday);
		else
			insuredBirthday = null;
	}

	public int getInsuredAppAge()
	{
		return insuredAppAge;
	}

	public void setInsuredAppAge(int aInsuredAppAge)
	{
		insuredAppAge = aInsuredAppAge;
	}

	public void setInsuredAppAge(String aInsuredAppAge)
	{
		if (aInsuredAppAge != null && !aInsuredAppAge.equals(""))
		{
			Integer tInteger = new Integer(aInsuredAppAge);
			int i = tInteger.intValue();
			insuredAppAge = i;
		}
	}

	public int getInsuredPeoples()
	{
		return insuredPeoples;
	}

	public void setInsuredPeoples(int aInsuredPeoples)
	{
		insuredPeoples = aInsuredPeoples;
	}

	public void setInsuredPeoples(String aInsuredPeoples)
	{
		if (aInsuredPeoples != null && !aInsuredPeoples.equals(""))
		{
			Integer tInteger = new Integer(aInsuredPeoples);
			int i = tInteger.intValue();
			insuredPeoples = i;
		}
	}

	public String getOccupationType()
	{
		return occupationType;
	}

	public void setOccupationType(String aOccupationType)
	{
		occupationType = aOccupationType;
	}

	public String getAppntNo()
	{
		return appntNo;
	}

	public void setAppntNo(String aAppntNo)
	{
		appntNo = aAppntNo;
	}

	public String getAppntName()
	{
		return appntName;
	}

	public void setAppntName(String aAppntName)
	{
		appntName = aAppntName;
	}

	public String getCValiDate()
	{
		if (cValiDate != null)
			return fDate.getString(cValiDate);
		else
			return null;
	}

	public void setCValiDate(Date aCValiDate)
	{
		cValiDate = aCValiDate;
	}

	public void setCValiDate(String aCValiDate)
	{
		if (aCValiDate != null && !aCValiDate.equals(""))
			cValiDate = fDate.getDate(aCValiDate);
		else
			cValiDate = null;
	}

	public String getSignCom()
	{
		return signCom;
	}

	public void setSignCom(String aSignCom)
	{
		signCom = aSignCom;
	}

	public String getSignDate()
	{
		if (signDate != null)
			return fDate.getString(signDate);
		else
			return null;
	}

	public void setSignDate(Date aSignDate)
	{
		signDate = aSignDate;
	}

	public void setSignDate(String aSignDate)
	{
		if (aSignDate != null && !aSignDate.equals(""))
			signDate = fDate.getDate(aSignDate);
		else
			signDate = null;
	}

	public String getSignTime()
	{
		return signTime;
	}

	public void setSignTime(String aSignTime)
	{
		signTime = aSignTime;
	}

	public String getFirstPayDate()
	{
		if (firstPayDate != null)
			return fDate.getString(firstPayDate);
		else
			return null;
	}

	public void setFirstPayDate(Date aFirstPayDate)
	{
		firstPayDate = aFirstPayDate;
	}

	public void setFirstPayDate(String aFirstPayDate)
	{
		if (aFirstPayDate != null && !aFirstPayDate.equals(""))
			firstPayDate = fDate.getDate(aFirstPayDate);
		else
			firstPayDate = null;
	}

	public String getPayEndDate()
	{
		if (payEndDate != null)
			return fDate.getString(payEndDate);
		else
			return null;
	}

	public void setPayEndDate(Date aPayEndDate)
	{
		payEndDate = aPayEndDate;
	}

	public void setPayEndDate(String aPayEndDate)
	{
		if (aPayEndDate != null && !aPayEndDate.equals(""))
			payEndDate = fDate.getDate(aPayEndDate);
		else
			payEndDate = null;
	}

	public String getPaytoDate()
	{
		if (paytoDate != null)
			return fDate.getString(paytoDate);
		else
			return null;
	}

	public void setPaytoDate(Date aPaytoDate)
	{
		paytoDate = aPaytoDate;
	}

	public void setPaytoDate(String aPaytoDate)
	{
		if (aPaytoDate != null && !aPaytoDate.equals(""))
			paytoDate = fDate.getDate(aPaytoDate);
		else
			paytoDate = null;
	}

	public String getGetStartDate()
	{
		if (getStartDate != null)
			return fDate.getString(getStartDate);
		else
			return null;
	}

	public void setGetStartDate(Date aGetStartDate)
	{
		getStartDate = aGetStartDate;
	}

	public void setGetStartDate(String aGetStartDate)
	{
		if (aGetStartDate != null && !aGetStartDate.equals(""))
			getStartDate = fDate.getDate(aGetStartDate);
		else
			getStartDate = null;
	}

	public String getEndDate()
	{
		if (endDate != null)
			return fDate.getString(endDate);
		else
			return null;
	}

	public void setEndDate(Date aEndDate)
	{
		endDate = aEndDate;
	}

	public void setEndDate(String aEndDate)
	{
		if (aEndDate != null && !aEndDate.equals(""))
			endDate = fDate.getDate(aEndDate);
		else
			endDate = null;
	}

	public String getAcciEndDate()
	{
		if (acciEndDate != null)
			return fDate.getString(acciEndDate);
		else
			return null;
	}

	public void setAcciEndDate(Date aAcciEndDate)
	{
		acciEndDate = aAcciEndDate;
	}

	public void setAcciEndDate(String aAcciEndDate)
	{
		if (aAcciEndDate != null && !aAcciEndDate.equals(""))
			acciEndDate = fDate.getDate(aAcciEndDate);
		else
			acciEndDate = null;
	}

	public String getGetYearFlag()
	{
		return getYearFlag;
	}

	public void setGetYearFlag(String aGetYearFlag)
	{
		getYearFlag = aGetYearFlag;
	}

	public int getGetYear()
	{
		return getYear;
	}

	public void setGetYear(int aGetYear)
	{
		getYear = aGetYear;
	}

	public void setGetYear(String aGetYear)
	{
		if (aGetYear != null && !aGetYear.equals(""))
		{
			Integer tInteger = new Integer(aGetYear);
			int i = tInteger.intValue();
			getYear = i;
		}
	}

	public String getPayEndYearFlag()
	{
		return payEndYearFlag;
	}

	public void setPayEndYearFlag(String aPayEndYearFlag)
	{
		payEndYearFlag = aPayEndYearFlag;
	}

	public int getPayEndYear()
	{
		return payEndYear;
	}

	public void setPayEndYear(int aPayEndYear)
	{
		payEndYear = aPayEndYear;
	}

	public void setPayEndYear(String aPayEndYear)
	{
		if (aPayEndYear != null && !aPayEndYear.equals(""))
		{
			Integer tInteger = new Integer(aPayEndYear);
			int i = tInteger.intValue();
			payEndYear = i;
		}
	}

	public String getInsuYearFlag()
	{
		return insuYearFlag;
	}

	public void setInsuYearFlag(String aInsuYearFlag)
	{
		insuYearFlag = aInsuYearFlag;
	}

	public int getInsuYear()
	{
		return insuYear;
	}

	public void setInsuYear(int aInsuYear)
	{
		insuYear = aInsuYear;
	}

	public void setInsuYear(String aInsuYear)
	{
		if (aInsuYear != null && !aInsuYear.equals(""))
		{
			Integer tInteger = new Integer(aInsuYear);
			int i = tInteger.intValue();
			insuYear = i;
		}
	}

	public String getAcciYearFlag()
	{
		return acciYearFlag;
	}

	public void setAcciYearFlag(String aAcciYearFlag)
	{
		acciYearFlag = aAcciYearFlag;
	}

	public int getAcciYear()
	{
		return acciYear;
	}

	public void setAcciYear(int aAcciYear)
	{
		acciYear = aAcciYear;
	}

	public void setAcciYear(String aAcciYear)
	{
		if (aAcciYear != null && !aAcciYear.equals(""))
		{
			Integer tInteger = new Integer(aAcciYear);
			int i = tInteger.intValue();
			acciYear = i;
		}
	}

	public String getGetStartType()
	{
		return getStartType;
	}

	public void setGetStartType(String aGetStartType)
	{
		getStartType = aGetStartType;
	}

	public String getSpecifyValiDate()
	{
		return specifyValiDate;
	}

	public void setSpecifyValiDate(String aSpecifyValiDate)
	{
		specifyValiDate = aSpecifyValiDate;
	}

	public String getPayMode()
	{
		return payMode;
	}

	public void setPayMode(String aPayMode)
	{
		payMode = aPayMode;
	}

	public String getPayLocation()
	{
		return payLocation;
	}

	public void setPayLocation(String aPayLocation)
	{
		payLocation = aPayLocation;
	}

	public int getPayIntv()
	{
		return payIntv;
	}

	public void setPayIntv(int aPayIntv)
	{
		payIntv = aPayIntv;
	}

	public void setPayIntv(String aPayIntv)
	{
		if (aPayIntv != null && !aPayIntv.equals(""))
		{
			Integer tInteger = new Integer(aPayIntv);
			int i = tInteger.intValue();
			payIntv = i;
		}
	}

	public int getPayYears()
	{
		return payYears;
	}

	public void setPayYears(int aPayYears)
	{
		payYears = aPayYears;
	}

	public void setPayYears(String aPayYears)
	{
		if (aPayYears != null && !aPayYears.equals(""))
		{
			Integer tInteger = new Integer(aPayYears);
			int i = tInteger.intValue();
			payYears = i;
		}
	}

	public int getYears()
	{
		return years;
	}

	public void setYears(int aYears)
	{
		years = aYears;
	}

	public void setYears(String aYears)
	{
		if (aYears != null && !aYears.equals(""))
		{
			Integer tInteger = new Integer(aYears);
			int i = tInteger.intValue();
			years = i;
		}
	}

	public double getManageFeeRate()
	{
		return manageFeeRate;
	}

	public void setManageFeeRate(double aManageFeeRate)
	{
		manageFeeRate = aManageFeeRate;
	}

	public void setManageFeeRate(String aManageFeeRate)
	{
		if (aManageFeeRate != null && !aManageFeeRate.equals(""))
		{
			Double tDouble = new Double(aManageFeeRate);
			double d = tDouble.doubleValue();
			manageFeeRate = d;
		}
	}

	public double getFloatRate()
	{
		return floatRate;
	}

	public void setFloatRate(double aFloatRate)
	{
		floatRate = aFloatRate;
	}

	public void setFloatRate(String aFloatRate)
	{
		if (aFloatRate != null && !aFloatRate.equals(""))
		{
			Double tDouble = new Double(aFloatRate);
			double d = tDouble.doubleValue();
			floatRate = d;
		}
	}

	public double getPremRate()
	{
		return premRate;
	}

	public void setPremRate(double aPremRate)
	{
		premRate = aPremRate;
	}

	public void setPremRate(String aPremRate)
	{
		if (aPremRate != null && !aPremRate.equals(""))
		{
			Double tDouble = new Double(aPremRate);
			double d = tDouble.doubleValue();
			premRate = d;
		}
	}

	public String getPremToAmnt()
	{
		return premToAmnt;
	}

	public void setPremToAmnt(String aPremToAmnt)
	{
		premToAmnt = aPremToAmnt;
	}

	public double getMult()
	{
		return mult;
	}

	public void setMult(double aMult)
	{
		mult = aMult;
	}

	public void setMult(String aMult)
	{
		if (aMult != null && !aMult.equals(""))
		{
			Double tDouble = new Double(aMult);
			double d = tDouble.doubleValue();
			mult = d;
		}
	}

	public double getStandPrem()
	{
		return standPrem;
	}

	public void setStandPrem(double aStandPrem)
	{
		standPrem = aStandPrem;
	}

	public void setStandPrem(String aStandPrem)
	{
		if (aStandPrem != null && !aStandPrem.equals(""))
		{
			Double tDouble = new Double(aStandPrem);
			double d = tDouble.doubleValue();
			standPrem = d;
		}
	}

	public double getPrem()
	{
		return prem;
	}

	public void setPrem(double aPrem)
	{
		prem = aPrem;
	}

	public void setPrem(String aPrem)
	{
		if (aPrem != null && !aPrem.equals(""))
		{
			Double tDouble = new Double(aPrem);
			double d = tDouble.doubleValue();
			prem = d;
		}
	}

	public double getSumPrem()
	{
		return sumPrem;
	}

	public void setSumPrem(double aSumPrem)
	{
		sumPrem = aSumPrem;
	}

	public void setSumPrem(String aSumPrem)
	{
		if (aSumPrem != null && !aSumPrem.equals(""))
		{
			Double tDouble = new Double(aSumPrem);
			double d = tDouble.doubleValue();
			sumPrem = d;
		}
	}

	public double getAmnt()
	{
		return amnt;
	}

	public void setAmnt(double aAmnt)
	{
		amnt = aAmnt;
	}

	public void setAmnt(String aAmnt)
	{
		if (aAmnt != null && !aAmnt.equals(""))
		{
			Double tDouble = new Double(aAmnt);
			double d = tDouble.doubleValue();
			amnt = d;
		}
	}

	public double getRiskAmnt()
	{
		return riskAmnt;
	}

	public void setRiskAmnt(double aRiskAmnt)
	{
		riskAmnt = aRiskAmnt;
	}

	public void setRiskAmnt(String aRiskAmnt)
	{
		if (aRiskAmnt != null && !aRiskAmnt.equals(""))
		{
			Double tDouble = new Double(aRiskAmnt);
			double d = tDouble.doubleValue();
			riskAmnt = d;
		}
	}

	public double getLeavingMoney()
	{
		return leavingMoney;
	}

	public void setLeavingMoney(double aLeavingMoney)
	{
		leavingMoney = aLeavingMoney;
	}

	public void setLeavingMoney(String aLeavingMoney)
	{
		if (aLeavingMoney != null && !aLeavingMoney.equals(""))
		{
			Double tDouble = new Double(aLeavingMoney);
			double d = tDouble.doubleValue();
			leavingMoney = d;
		}
	}

	public int getEndorseTimes()
	{
		return endorseTimes;
	}

	public void setEndorseTimes(int aEndorseTimes)
	{
		endorseTimes = aEndorseTimes;
	}

	public void setEndorseTimes(String aEndorseTimes)
	{
		if (aEndorseTimes != null && !aEndorseTimes.equals(""))
		{
			Integer tInteger = new Integer(aEndorseTimes);
			int i = tInteger.intValue();
			endorseTimes = i;
		}
	}

	public int getClaimTimes()
	{
		return claimTimes;
	}

	public void setClaimTimes(int aClaimTimes)
	{
		claimTimes = aClaimTimes;
	}

	public void setClaimTimes(String aClaimTimes)
	{
		if (aClaimTimes != null && !aClaimTimes.equals(""))
		{
			Integer tInteger = new Integer(aClaimTimes);
			int i = tInteger.intValue();
			claimTimes = i;
		}
	}

	public int getLiveTimes()
	{
		return liveTimes;
	}

	public void setLiveTimes(int aLiveTimes)
	{
		liveTimes = aLiveTimes;
	}

	public void setLiveTimes(String aLiveTimes)
	{
		if (aLiveTimes != null && !aLiveTimes.equals(""))
		{
			Integer tInteger = new Integer(aLiveTimes);
			int i = tInteger.intValue();
			liveTimes = i;
		}
	}

	public int getRenewCount()
	{
		return renewCount;
	}

	public void setRenewCount(int aRenewCount)
	{
		renewCount = aRenewCount;
	}

	public void setRenewCount(String aRenewCount)
	{
		if (aRenewCount != null && !aRenewCount.equals(""))
		{
			Integer tInteger = new Integer(aRenewCount);
			int i = tInteger.intValue();
			renewCount = i;
		}
	}

	public String getLastGetDate()
	{
		if (lastGetDate != null)
			return fDate.getString(lastGetDate);
		else
			return null;
	}

	public void setLastGetDate(Date aLastGetDate)
	{
		lastGetDate = aLastGetDate;
	}

	public void setLastGetDate(String aLastGetDate)
	{
		if (aLastGetDate != null && !aLastGetDate.equals(""))
			lastGetDate = fDate.getDate(aLastGetDate);
		else
			lastGetDate = null;
	}

	public String getLastLoanDate()
	{
		if (lastLoanDate != null)
			return fDate.getString(lastLoanDate);
		else
			return null;
	}

	public void setLastLoanDate(Date aLastLoanDate)
	{
		lastLoanDate = aLastLoanDate;
	}

	public void setLastLoanDate(String aLastLoanDate)
	{
		if (aLastLoanDate != null && !aLastLoanDate.equals(""))
			lastLoanDate = fDate.getDate(aLastLoanDate);
		else
			lastLoanDate = null;
	}

	public String getLastRegetDate()
	{
		if (lastRegetDate != null)
			return fDate.getString(lastRegetDate);
		else
			return null;
	}

	public void setLastRegetDate(Date aLastRegetDate)
	{
		lastRegetDate = aLastRegetDate;
	}

	public void setLastRegetDate(String aLastRegetDate)
	{
		if (aLastRegetDate != null && !aLastRegetDate.equals(""))
			lastRegetDate = fDate.getDate(aLastRegetDate);
		else
			lastRegetDate = null;
	}

	public String getLastEdorDate()
	{
		if (lastEdorDate != null)
			return fDate.getString(lastEdorDate);
		else
			return null;
	}

	public void setLastEdorDate(Date aLastEdorDate)
	{
		lastEdorDate = aLastEdorDate;
	}

	public void setLastEdorDate(String aLastEdorDate)
	{
		if (aLastEdorDate != null && !aLastEdorDate.equals(""))
			lastEdorDate = fDate.getDate(aLastEdorDate);
		else
			lastEdorDate = null;
	}

	public String getLastRevDate()
	{
		if (lastRevDate != null)
			return fDate.getString(lastRevDate);
		else
			return null;
	}

	public void setLastRevDate(Date aLastRevDate)
	{
		lastRevDate = aLastRevDate;
	}

	public void setLastRevDate(String aLastRevDate)
	{
		if (aLastRevDate != null && !aLastRevDate.equals(""))
			lastRevDate = fDate.getDate(aLastRevDate);
		else
			lastRevDate = null;
	}

	public String getRnewFlag()
	{
		return rnewFlag;
	}

	public void setRnewFlag(String aRnewFlag)
	{
		rnewFlag = aRnewFlag;
	}

	public String getStopFlag()
	{
		return stopFlag;
	}

	public void setStopFlag(String aStopFlag)
	{
		stopFlag = aStopFlag;
	}

	public String getExpiryFlag()
	{
		return expiryFlag;
	}

	public void setExpiryFlag(String aExpiryFlag)
	{
		expiryFlag = aExpiryFlag;
	}

	public String getAutoPayFlag()
	{
		return autoPayFlag;
	}

	public void setAutoPayFlag(String aAutoPayFlag)
	{
		autoPayFlag = aAutoPayFlag;
	}

	public String getInterestDifFlag()
	{
		return interestDifFlag;
	}

	public void setInterestDifFlag(String aInterestDifFlag)
	{
		interestDifFlag = aInterestDifFlag;
	}

	public String getSubFlag()
	{
		return subFlag;
	}

	public void setSubFlag(String aSubFlag)
	{
		subFlag = aSubFlag;
	}

	public String getBnfFlag()
	{
		return bnfFlag;
	}

	public void setBnfFlag(String aBnfFlag)
	{
		bnfFlag = aBnfFlag;
	}

	public String getHealthCheckFlag()
	{
		return healthCheckFlag;
	}

	public void setHealthCheckFlag(String aHealthCheckFlag)
	{
		healthCheckFlag = aHealthCheckFlag;
	}

	public String getImpartFlag()
	{
		return impartFlag;
	}

	public void setImpartFlag(String aImpartFlag)
	{
		impartFlag = aImpartFlag;
	}

	public String getReinsureFlag()
	{
		return reinsureFlag;
	}

	public void setReinsureFlag(String aReinsureFlag)
	{
		reinsureFlag = aReinsureFlag;
	}

	public String getAgentPayFlag()
	{
		return agentPayFlag;
	}

	public void setAgentPayFlag(String aAgentPayFlag)
	{
		agentPayFlag = aAgentPayFlag;
	}

	public String getAgentGetFlag()
	{
		return agentGetFlag;
	}

	public void setAgentGetFlag(String aAgentGetFlag)
	{
		agentGetFlag = aAgentGetFlag;
	}

	public String getLiveGetMode()
	{
		return liveGetMode;
	}

	public void setLiveGetMode(String aLiveGetMode)
	{
		liveGetMode = aLiveGetMode;
	}

	public String getDeadGetMode()
	{
		return deadGetMode;
	}

	public void setDeadGetMode(String aDeadGetMode)
	{
		deadGetMode = aDeadGetMode;
	}

	public String getBonusGetMode()
	{
		return bonusGetMode;
	}

	public void setBonusGetMode(String aBonusGetMode)
	{
		bonusGetMode = aBonusGetMode;
	}

	public String getDeadAmntType()
	{
		return deadAmntType;
	}

	public void setDeadAmntType(String aDeadAmntType)
	{
		deadAmntType = aDeadAmntType;
	}

	public double getTopUpPrem()
	{
		return topUpPrem;
	}

	public void setTopUpPrem(double aTopUpPrem)
	{
		topUpPrem = aTopUpPrem;
	}

	public void setTopUpPrem(String aTopUpPrem)
	{
		if (aTopUpPrem != null && !aTopUpPrem.equals(""))
		{
			Double tDouble = new Double(aTopUpPrem);
			double d = tDouble.doubleValue();
			topUpPrem = d;
		}
	}

	public String getBonusMan()
	{
		return bonusMan;
	}

	public void setBonusMan(String aBonusMan)
	{
		bonusMan = aBonusMan;
	}

	public String getDeadFlag()
	{
		return deadFlag;
	}

	public void setDeadFlag(String aDeadFlag)
	{
		deadFlag = aDeadFlag;
	}

	public String getSmokeFlag()
	{
		return smokeFlag;
	}

	public void setSmokeFlag(String aSmokeFlag)
	{
		smokeFlag = aSmokeFlag;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String aRemark)
	{
		remark = aRemark;
	}

	public String getApproveFlag()
	{
		return approveFlag;
	}

	public void setApproveFlag(String aApproveFlag)
	{
		approveFlag = aApproveFlag;
	}

	public String getApproveCode()
	{
		return approveCode;
	}

	public void setApproveCode(String aApproveCode)
	{
		approveCode = aApproveCode;
	}

	public String getApproveDate()
	{
		if (approveDate != null)
			return fDate.getString(approveDate);
		else
			return null;
	}

	public void setApproveDate(Date aApproveDate)
	{
		approveDate = aApproveDate;
	}

	public void setApproveDate(String aApproveDate)
	{
		if (aApproveDate != null && !aApproveDate.equals(""))
			approveDate = fDate.getDate(aApproveDate);
		else
			approveDate = null;
	}

	public String getApproveTime()
	{
		return approveTime;
	}

	public void setApproveTime(String aApproveTime)
	{
		approveTime = aApproveTime;
	}

	public String getUWFlag()
	{
		return uWFlag;
	}

	public void setUWFlag(String aUWFlag)
	{
		uWFlag = aUWFlag;
	}

	public String getUWCode()
	{
		return uWCode;
	}

	public void setUWCode(String aUWCode)
	{
		uWCode = aUWCode;
	}

	public String getUWDate()
	{
		if (uWDate != null)
			return fDate.getString(uWDate);
		else
			return null;
	}

	public void setUWDate(Date aUWDate)
	{
		uWDate = aUWDate;
	}

	public void setUWDate(String aUWDate)
	{
		if (aUWDate != null && !aUWDate.equals(""))
			uWDate = fDate.getDate(aUWDate);
		else
			uWDate = null;
	}

	public String getUWTime()
	{
		return uWTime;
	}

	public void setUWTime(String aUWTime)
	{
		uWTime = aUWTime;
	}

	public String getPolApplyDate()
	{
		if (polApplyDate != null)
			return fDate.getString(polApplyDate);
		else
			return null;
	}

	public void setPolApplyDate(Date aPolApplyDate)
	{
		polApplyDate = aPolApplyDate;
	}

	public void setPolApplyDate(String aPolApplyDate)
	{
		if (aPolApplyDate != null && !aPolApplyDate.equals(""))
			polApplyDate = fDate.getDate(aPolApplyDate);
		else
			polApplyDate = null;
	}

	public String getAppFlag()
	{
		return appFlag;
	}

	public void setAppFlag(String aAppFlag)
	{
		appFlag = aAppFlag;
	}

	public String getSaleChnlDetail()
	{
		return saleChnlDetail;
	}

	public void setSaleChnlDetail(String aSaleChnlDetail)
	{
		saleChnlDetail = aSaleChnlDetail;
	}

	public String getPolState()
	{
		return polState;
	}

	public void setPolState(String aPolState)
	{
		polState = aPolState;
	}

	public String getStandbyFlag1()
	{
		return standbyFlag1;
	}

	public void setStandbyFlag1(String aStandbyFlag1)
	{
		standbyFlag1 = aStandbyFlag1;
	}

	public String getStandbyFlag2()
	{
		return standbyFlag2;
	}

	public void setStandbyFlag2(String aStandbyFlag2)
	{
		standbyFlag2 = aStandbyFlag2;
	}

	public String getStandbyFlag3()
	{
		return standbyFlag3;
	}

	public void setStandbyFlag3(String aStandbyFlag3)
	{
		standbyFlag3 = aStandbyFlag3;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public String getMakeDate()
	{
		if (makeDate != null)
			return fDate.getString(makeDate);
		else
			return null;
	}

	public void setMakeDate(Date aMakeDate)
	{
		makeDate = aMakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals(""))
			makeDate = fDate.getDate(aMakeDate);
		else
			makeDate = null;
	}

	public String getMakeTime()
	{
		return makeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		makeTime = aMakeTime;
	}

	public String getModifyDate()
	{
		if (modifyDate != null)
			return fDate.getString(modifyDate);
		else
			return null;
	}

	public void setModifyDate(Date aModifyDate)
	{
		modifyDate = aModifyDate;
	}

	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals(""))
			modifyDate = fDate.getDate(aModifyDate);
		else
			modifyDate = null;
	}

	public String getModifyTime()
	{
		return modifyTime;
	}

	public void setModifyTime(String aModifyTime)
	{
		modifyTime = aModifyTime;
	}

	public void setSchema(LNPPolSchema aLNPPolSchema)
	{
		grpContNo = aLNPPolSchema.getGrpContNo();
		grpPolNo = aLNPPolSchema.getGrpPolNo();
		contNo = aLNPPolSchema.getContNo();
		proposalContNo = aLNPPolSchema.getProposalContNo();
		polNo = aLNPPolSchema.getPolNo();
		proposalNo = aLNPPolSchema.getProposalNo();
		prtNo = aLNPPolSchema.getPrtNo();
		contType = aLNPPolSchema.getContType();
		polTypeFlag = aLNPPolSchema.getPolTypeFlag();
		mainPolNo = aLNPPolSchema.getMainPolNo();
		masterPolNo = aLNPPolSchema.getMasterPolNo();
		kindCode = aLNPPolSchema.getKindCode();
		riskCode = aLNPPolSchema.getRiskCode();
		riskVersion = aLNPPolSchema.getRiskVersion();
		manageCom = aLNPPolSchema.getManageCom();
		agentCom = aLNPPolSchema.getAgentCom();
		agentType = aLNPPolSchema.getAgentType();
		agentCode = aLNPPolSchema.getAgentCode();
		agentGroup = aLNPPolSchema.getAgentGroup();
		agentGroup1 = aLNPPolSchema.getAgentGroup1();
		agentCode1 = aLNPPolSchema.getAgentCode1();
		saleChnl = aLNPPolSchema.getSaleChnl();
		handler = aLNPPolSchema.getHandler();
		insuredNo = aLNPPolSchema.getInsuredNo();
		insuredId = aLNPPolSchema.getInsuredId();
		insuredName = aLNPPolSchema.getInsuredName();
		insuredSex = aLNPPolSchema.getInsuredSex();
		insuredBirthday = fDate.getDate(aLNPPolSchema.getInsuredBirthday());
		insuredAppAge = aLNPPolSchema.getInsuredAppAge();
		insuredPeoples = aLNPPolSchema.getInsuredPeoples();
		occupationType = aLNPPolSchema.getOccupationType();
		appntNo = aLNPPolSchema.getAppntNo();
		appntName = aLNPPolSchema.getAppntName();
		cValiDate = fDate.getDate(aLNPPolSchema.getCValiDate());
		signCom = aLNPPolSchema.getSignCom();
		signDate = fDate.getDate(aLNPPolSchema.getSignDate());
		signTime = aLNPPolSchema.getSignTime();
		firstPayDate = fDate.getDate(aLNPPolSchema.getFirstPayDate());
		payEndDate = fDate.getDate(aLNPPolSchema.getPayEndDate());
		paytoDate = fDate.getDate(aLNPPolSchema.getPaytoDate());
		getStartDate = fDate.getDate(aLNPPolSchema.getGetStartDate());
		endDate = fDate.getDate(aLNPPolSchema.getEndDate());
		acciEndDate = fDate.getDate(aLNPPolSchema.getAcciEndDate());
		getYearFlag = aLNPPolSchema.getGetYearFlag();
		getYear = aLNPPolSchema.getGetYear();
		payEndYearFlag = aLNPPolSchema.getPayEndYearFlag();
		payEndYear = aLNPPolSchema.getPayEndYear();
		insuYearFlag = aLNPPolSchema.getInsuYearFlag();
		insuYear = aLNPPolSchema.getInsuYear();
		acciYearFlag = aLNPPolSchema.getAcciYearFlag();
		acciYear = aLNPPolSchema.getAcciYear();
		getStartType = aLNPPolSchema.getGetStartType();
		specifyValiDate = aLNPPolSchema.getSpecifyValiDate();
		payMode = aLNPPolSchema.getPayMode();
		payLocation = aLNPPolSchema.getPayLocation();
		payIntv = aLNPPolSchema.getPayIntv();
		payYears = aLNPPolSchema.getPayYears();
		years = aLNPPolSchema.getYears();
		manageFeeRate = aLNPPolSchema.getManageFeeRate();
		floatRate = aLNPPolSchema.getFloatRate();
		premRate = aLNPPolSchema.getPremRate();
		premToAmnt = aLNPPolSchema.getPremToAmnt();
		mult = aLNPPolSchema.getMult();
		standPrem = aLNPPolSchema.getStandPrem();
		prem = aLNPPolSchema.getPrem();
		sumPrem = aLNPPolSchema.getSumPrem();
		amnt = aLNPPolSchema.getAmnt();
		riskAmnt = aLNPPolSchema.getRiskAmnt();
		leavingMoney = aLNPPolSchema.getLeavingMoney();
		endorseTimes = aLNPPolSchema.getEndorseTimes();
		claimTimes = aLNPPolSchema.getClaimTimes();
		liveTimes = aLNPPolSchema.getLiveTimes();
		renewCount = aLNPPolSchema.getRenewCount();
		lastGetDate = fDate.getDate(aLNPPolSchema.getLastGetDate());
		lastLoanDate = fDate.getDate(aLNPPolSchema.getLastLoanDate());
		lastRegetDate = fDate.getDate(aLNPPolSchema.getLastRegetDate());
		lastEdorDate = fDate.getDate(aLNPPolSchema.getLastEdorDate());
		lastRevDate = fDate.getDate(aLNPPolSchema.getLastRevDate());
		rnewFlag = aLNPPolSchema.getRnewFlag();
		stopFlag = aLNPPolSchema.getStopFlag();
		expiryFlag = aLNPPolSchema.getExpiryFlag();
		autoPayFlag = aLNPPolSchema.getAutoPayFlag();
		interestDifFlag = aLNPPolSchema.getInterestDifFlag();
		subFlag = aLNPPolSchema.getSubFlag();
		bnfFlag = aLNPPolSchema.getBnfFlag();
		healthCheckFlag = aLNPPolSchema.getHealthCheckFlag();
		impartFlag = aLNPPolSchema.getImpartFlag();
		reinsureFlag = aLNPPolSchema.getReinsureFlag();
		agentPayFlag = aLNPPolSchema.getAgentPayFlag();
		agentGetFlag = aLNPPolSchema.getAgentGetFlag();
		liveGetMode = aLNPPolSchema.getLiveGetMode();
		deadGetMode = aLNPPolSchema.getDeadGetMode();
		bonusGetMode = aLNPPolSchema.getBonusGetMode();
		deadAmntType = aLNPPolSchema.getDeadAmntType();
		topUpPrem = aLNPPolSchema.getTopUpPrem();
		bonusMan = aLNPPolSchema.getBonusMan();
		deadFlag = aLNPPolSchema.getDeadFlag();
		smokeFlag = aLNPPolSchema.getSmokeFlag();
		remark = aLNPPolSchema.getRemark();
		approveFlag = aLNPPolSchema.getApproveFlag();
		approveCode = aLNPPolSchema.getApproveCode();
		approveDate = fDate.getDate(aLNPPolSchema.getApproveDate());
		approveTime = aLNPPolSchema.getApproveTime();
		uWFlag = aLNPPolSchema.getUWFlag();
		uWCode = aLNPPolSchema.getUWCode();
		uWDate = fDate.getDate(aLNPPolSchema.getUWDate());
		uWTime = aLNPPolSchema.getUWTime();
		polApplyDate = fDate.getDate(aLNPPolSchema.getPolApplyDate());
		appFlag = aLNPPolSchema.getAppFlag();
		saleChnlDetail = aLNPPolSchema.getSaleChnlDetail();
		polState = aLNPPolSchema.getPolState();
		standbyFlag1 = aLNPPolSchema.getStandbyFlag1();
		standbyFlag2 = aLNPPolSchema.getStandbyFlag2();
		standbyFlag3 = aLNPPolSchema.getStandbyFlag3();
		operator = aLNPPolSchema.getOperator();
		makeDate = fDate.getDate(aLNPPolSchema.getMakeDate());
		makeTime = aLNPPolSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPPolSchema.getModifyDate());
		modifyTime = aLNPPolSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("GrpContNo") == null)
				grpContNo = null;
			else
				grpContNo = rs.getString("GrpContNo").trim();
			if (rs.getString("GrpPolNo") == null)
				grpPolNo = null;
			else
				grpPolNo = rs.getString("GrpPolNo").trim();
			if (rs.getString("ContNo") == null)
				contNo = null;
			else
				contNo = rs.getString("ContNo").trim();
			if (rs.getString("ProposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("ProposalContNo").trim();
			if (rs.getString("PolNo") == null)
				polNo = null;
			else
				polNo = rs.getString("PolNo").trim();
			if (rs.getString("ProposalNo") == null)
				proposalNo = null;
			else
				proposalNo = rs.getString("ProposalNo").trim();
			if (rs.getString("PrtNo") == null)
				prtNo = null;
			else
				prtNo = rs.getString("PrtNo").trim();
			if (rs.getString("ContType") == null)
				contType = null;
			else
				contType = rs.getString("ContType").trim();
			if (rs.getString("PolTypeFlag") == null)
				polTypeFlag = null;
			else
				polTypeFlag = rs.getString("PolTypeFlag").trim();
			if (rs.getString("MainPolNo") == null)
				mainPolNo = null;
			else
				mainPolNo = rs.getString("MainPolNo").trim();
			if (rs.getString("MasterPolNo") == null)
				masterPolNo = null;
			else
				masterPolNo = rs.getString("MasterPolNo").trim();
			if (rs.getString("KindCode") == null)
				kindCode = null;
			else
				kindCode = rs.getString("KindCode").trim();
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			if (rs.getString("RiskVersion") == null)
				riskVersion = null;
			else
				riskVersion = rs.getString("RiskVersion").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("AgentCom") == null)
				agentCom = null;
			else
				agentCom = rs.getString("AgentCom").trim();
			if (rs.getString("AgentType") == null)
				agentType = null;
			else
				agentType = rs.getString("AgentType").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("AgentGroup") == null)
				agentGroup = null;
			else
				agentGroup = rs.getString("AgentGroup").trim();
			if (rs.getString("AgentGroup1") == null)
				agentGroup1 = null;
			else
				agentGroup1 = rs.getString("AgentGroup1").trim();
			if (rs.getString("AgentCode1") == null)
				agentCode1 = null;
			else
				agentCode1 = rs.getString("AgentCode1").trim();
			if (rs.getString("SaleChnl") == null)
				saleChnl = null;
			else
				saleChnl = rs.getString("SaleChnl").trim();
			if (rs.getString("Handler") == null)
				handler = null;
			else
				handler = rs.getString("Handler").trim();
			if (rs.getString("InsuredNo") == null)
				insuredNo = null;
			else
				insuredNo = rs.getString("InsuredNo").trim();
			if (rs.getString("InsuredId") == null)
				insuredId = null;
			else
				insuredId = rs.getString("InsuredId").trim();
			if (rs.getString("InsuredName") == null)
				insuredName = null;
			else
				insuredName = rs.getString("InsuredName").trim();
			if (rs.getString("InsuredSex") == null)
				insuredSex = null;
			else
				insuredSex = rs.getString("InsuredSex").trim();
			insuredBirthday = rs.getDate("InsuredBirthday");
			insuredAppAge = rs.getInt("InsuredAppAge");
			insuredPeoples = rs.getInt("InsuredPeoples");
			if (rs.getString("OccupationType") == null)
				occupationType = null;
			else
				occupationType = rs.getString("OccupationType").trim();
			if (rs.getString("AppntNo") == null)
				appntNo = null;
			else
				appntNo = rs.getString("AppntNo").trim();
			if (rs.getString("AppntName") == null)
				appntName = null;
			else
				appntName = rs.getString("AppntName").trim();
			cValiDate = rs.getDate("CValiDate");
			if (rs.getString("SignCom") == null)
				signCom = null;
			else
				signCom = rs.getString("SignCom").trim();
			signDate = rs.getDate("SignDate");
			if (rs.getString("SignTime") == null)
				signTime = null;
			else
				signTime = rs.getString("SignTime").trim();
			firstPayDate = rs.getDate("FirstPayDate");
			payEndDate = rs.getDate("PayEndDate");
			paytoDate = rs.getDate("PaytoDate");
			getStartDate = rs.getDate("GetStartDate");
			endDate = rs.getDate("EndDate");
			acciEndDate = rs.getDate("AcciEndDate");
			if (rs.getString("GetYearFlag") == null)
				getYearFlag = null;
			else
				getYearFlag = rs.getString("GetYearFlag").trim();
			getYear = rs.getInt("GetYear");
			if (rs.getString("PayEndYearFlag") == null)
				payEndYearFlag = null;
			else
				payEndYearFlag = rs.getString("PayEndYearFlag").trim();
			payEndYear = rs.getInt("PayEndYear");
			if (rs.getString("InsuYearFlag") == null)
				insuYearFlag = null;
			else
				insuYearFlag = rs.getString("InsuYearFlag").trim();
			insuYear = rs.getInt("InsuYear");
			if (rs.getString("AcciYearFlag") == null)
				acciYearFlag = null;
			else
				acciYearFlag = rs.getString("AcciYearFlag").trim();
			acciYear = rs.getInt("AcciYear");
			if (rs.getString("GetStartType") == null)
				getStartType = null;
			else
				getStartType = rs.getString("GetStartType").trim();
			if (rs.getString("SpecifyValiDate") == null)
				specifyValiDate = null;
			else
				specifyValiDate = rs.getString("SpecifyValiDate").trim();
			if (rs.getString("PayMode") == null)
				payMode = null;
			else
				payMode = rs.getString("PayMode").trim();
			if (rs.getString("PayLocation") == null)
				payLocation = null;
			else
				payLocation = rs.getString("PayLocation").trim();
			payIntv = rs.getInt("PayIntv");
			payYears = rs.getInt("PayYears");
			years = rs.getInt("Years");
			manageFeeRate = rs.getDouble("ManageFeeRate");
			floatRate = rs.getDouble("FloatRate");
			premRate = rs.getDouble("PremRate");
			if (rs.getString("PremToAmnt") == null)
				premToAmnt = null;
			else
				premToAmnt = rs.getString("PremToAmnt").trim();
			mult = rs.getDouble("Mult");
			standPrem = rs.getDouble("StandPrem");
			prem = rs.getDouble("Prem");
			sumPrem = rs.getDouble("SumPrem");
			amnt = rs.getDouble("Amnt");
			riskAmnt = rs.getDouble("RiskAmnt");
			leavingMoney = rs.getDouble("LeavingMoney");
			endorseTimes = rs.getInt("EndorseTimes");
			claimTimes = rs.getInt("ClaimTimes");
			liveTimes = rs.getInt("LiveTimes");
			renewCount = rs.getInt("RenewCount");
			lastGetDate = rs.getDate("LastGetDate");
			lastLoanDate = rs.getDate("LastLoanDate");
			lastRegetDate = rs.getDate("LastRegetDate");
			lastEdorDate = rs.getDate("LastEdorDate");
			lastRevDate = rs.getDate("LastRevDate");
			if (rs.getString("RnewFlag") == null)
				rnewFlag = null;
			else
				rnewFlag = rs.getString("RnewFlag").trim();
			if (rs.getString("StopFlag") == null)
				stopFlag = null;
			else
				stopFlag = rs.getString("StopFlag").trim();
			if (rs.getString("ExpiryFlag") == null)
				expiryFlag = null;
			else
				expiryFlag = rs.getString("ExpiryFlag").trim();
			if (rs.getString("AutoPayFlag") == null)
				autoPayFlag = null;
			else
				autoPayFlag = rs.getString("AutoPayFlag").trim();
			if (rs.getString("InterestDifFlag") == null)
				interestDifFlag = null;
			else
				interestDifFlag = rs.getString("InterestDifFlag").trim();
			if (rs.getString("SubFlag") == null)
				subFlag = null;
			else
				subFlag = rs.getString("SubFlag").trim();
			if (rs.getString("BnfFlag") == null)
				bnfFlag = null;
			else
				bnfFlag = rs.getString("BnfFlag").trim();
			if (rs.getString("HealthCheckFlag") == null)
				healthCheckFlag = null;
			else
				healthCheckFlag = rs.getString("HealthCheckFlag").trim();
			if (rs.getString("ImpartFlag") == null)
				impartFlag = null;
			else
				impartFlag = rs.getString("ImpartFlag").trim();
			if (rs.getString("ReinsureFlag") == null)
				reinsureFlag = null;
			else
				reinsureFlag = rs.getString("ReinsureFlag").trim();
			if (rs.getString("AgentPayFlag") == null)
				agentPayFlag = null;
			else
				agentPayFlag = rs.getString("AgentPayFlag").trim();
			if (rs.getString("AgentGetFlag") == null)
				agentGetFlag = null;
			else
				agentGetFlag = rs.getString("AgentGetFlag").trim();
			if (rs.getString("LiveGetMode") == null)
				liveGetMode = null;
			else
				liveGetMode = rs.getString("LiveGetMode").trim();
			if (rs.getString("DeadGetMode") == null)
				deadGetMode = null;
			else
				deadGetMode = rs.getString("DeadGetMode").trim();
			if (rs.getString("BonusGetMode") == null)
				bonusGetMode = null;
			else
				bonusGetMode = rs.getString("BonusGetMode").trim();
			if (rs.getString("DeadAmntType") == null)
				deadAmntType = null;
			else
				deadAmntType = rs.getString("DeadAmntType").trim();
			topUpPrem = rs.getDouble("TopUpPrem");
			if (rs.getString("BonusMan") == null)
				bonusMan = null;
			else
				bonusMan = rs.getString("BonusMan").trim();
			if (rs.getString("DeadFlag") == null)
				deadFlag = null;
			else
				deadFlag = rs.getString("DeadFlag").trim();
			if (rs.getString("SmokeFlag") == null)
				smokeFlag = null;
			else
				smokeFlag = rs.getString("SmokeFlag").trim();
			if (rs.getString("Remark") == null)
				remark = null;
			else
				remark = rs.getString("Remark").trim();
			if (rs.getString("ApproveFlag") == null)
				approveFlag = null;
			else
				approveFlag = rs.getString("ApproveFlag").trim();
			if (rs.getString("ApproveCode") == null)
				approveCode = null;
			else
				approveCode = rs.getString("ApproveCode").trim();
			approveDate = rs.getDate("ApproveDate");
			if (rs.getString("ApproveTime") == null)
				approveTime = null;
			else
				approveTime = rs.getString("ApproveTime").trim();
			if (rs.getString("UWFlag") == null)
				uWFlag = null;
			else
				uWFlag = rs.getString("UWFlag").trim();
			if (rs.getString("UWCode") == null)
				uWCode = null;
			else
				uWCode = rs.getString("UWCode").trim();
			uWDate = rs.getDate("UWDate");
			if (rs.getString("UWTime") == null)
				uWTime = null;
			else
				uWTime = rs.getString("UWTime").trim();
			polApplyDate = rs.getDate("PolApplyDate");
			if (rs.getString("AppFlag") == null)
				appFlag = null;
			else
				appFlag = rs.getString("AppFlag").trim();
			if (rs.getString("SaleChnlDetail") == null)
				saleChnlDetail = null;
			else
				saleChnlDetail = rs.getString("SaleChnlDetail").trim();
			if (rs.getString("PolState") == null)
				polState = null;
			else
				polState = rs.getString("PolState").trim();
			if (rs.getString("StandbyFlag1") == null)
				standbyFlag1 = null;
			else
				standbyFlag1 = rs.getString("StandbyFlag1").trim();
			if (rs.getString("StandbyFlag2") == null)
				standbyFlag2 = null;
			else
				standbyFlag2 = rs.getString("StandbyFlag2").trim();
			if (rs.getString("StandbyFlag3") == null)
				standbyFlag3 = null;
			else
				standbyFlag3 = rs.getString("StandbyFlag3").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			makeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("MakeTime").trim();
			modifyDate = rs.getDate("ModifyDate");
			if (rs.getString("ModifyTime") == null)
				modifyTime = null;
			else
				modifyTime = rs.getString("ModifyTime").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPPol????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPPolSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPPolSchema getSchema()
	{
		LNPPolSchema aLNPPolSchema = new LNPPolSchema();
		aLNPPolSchema.setSchema(this);
		return aLNPPolSchema;
	}

	public LNPPolDB getDB()
	{
		LNPPolDB aDBOper = new LNPPolDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(grpContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpPolNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proposalContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(polNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proposalNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(prtNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(polTypeFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mainPolNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(masterPolNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(kindCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskVersion));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGroup));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGroup1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(saleChnl));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(handler));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredSex));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(insuredBirthday)));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(insuredAppAge));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(insuredPeoples));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(occupationType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(cValiDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(signCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(signDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(signTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(firstPayDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(payEndDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(paytoDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(getStartDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(endDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(acciEndDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getYearFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(getYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payEndYearFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(payEndYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuYearFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(insuYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(acciYearFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(acciYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getStartType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(specifyValiDate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payLocation));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(payIntv));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(payYears));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(years));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(manageFeeRate));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(floatRate));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(premRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(premToAmnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(mult));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(standPrem));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(prem));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sumPrem));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(amnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(riskAmnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(leavingMoney));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(endorseTimes));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(claimTimes));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(liveTimes));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(renewCount));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(lastGetDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(lastLoanDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(lastRegetDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(lastEdorDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(lastRevDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rnewFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(stopFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(expiryFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(autoPayFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(interestDifFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(subFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bnfFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(healthCheckFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(impartFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(reinsureFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentPayFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGetFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(liveGetMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(deadGetMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bonusGetMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(deadAmntType));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(topUpPrem));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bonusMan));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(deadFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(smokeFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remark));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(approveFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(approveCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(approveDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(approveTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(uWDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(polApplyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(saleChnlDetail));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(polState));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(standbyFlag1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(standbyFlag2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(standbyFlag3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyTime));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			grpPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			proposalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			contType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			polTypeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			mainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			masterPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			kindCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			riskVersion = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			agentCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			agentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			agentGroup1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			agentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			handler = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			insuredSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			insuredBirthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
			insuredAppAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|")))).intValue();
			insuredPeoples = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|")))).intValue();
			occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			cValiDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|"));
			signCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			signDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
			signTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			firstPayDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|"));
			payEndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|"));
			paytoDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|"));
			getStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|"));
			acciEndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|"));
			getYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			getYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|")))).intValue();
			payEndYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			payEndYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 47, "|")))).intValue();
			insuYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			insuYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|")))).intValue();
			acciYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			acciYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|")))).intValue();
			getStartType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			specifyValiDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
			payMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
			payLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
			payIntv = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|")))).intValue();
			payYears = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|")))).intValue();
			years = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|")))).intValue();
			manageFeeRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|")))).doubleValue();
			floatRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|")))).doubleValue();
			premRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|")))).doubleValue();
			premToAmnt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, "|");
			mult = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|")))).doubleValue();
			standPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 64, "|")))).doubleValue();
			prem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 65, "|")))).doubleValue();
			sumPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 66, "|")))).doubleValue();
			amnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 67, "|")))).doubleValue();
			riskAmnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 68, "|")))).doubleValue();
			leavingMoney = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 69, "|")))).doubleValue();
			endorseTimes = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 70, "|")))).intValue();
			claimTimes = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 71, "|")))).intValue();
			liveTimes = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 72, "|")))).intValue();
			renewCount = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 73, "|")))).intValue();
			lastGetDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 74, "|"));
			lastLoanDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 75, "|"));
			lastRegetDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76, "|"));
			lastEdorDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, "|"));
			lastRevDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, "|"));
			rnewFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, "|");
			stopFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, "|");
			expiryFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, "|");
			autoPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82, "|");
			interestDifFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, "|");
			subFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, "|");
			bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, "|");
			healthCheckFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, "|");
			impartFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, "|");
			reinsureFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, "|");
			agentPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, "|");
			agentGetFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, "|");
			liveGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, "|");
			deadGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 92, "|");
			bonusGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 93, "|");
			deadAmntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 94, "|");
			topUpPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 95, "|")))).doubleValue();
			bonusMan = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 96, "|");
			deadFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 97, "|");
			smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 98, "|");
			remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 99, "|");
			approveFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 100, "|");
			approveCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 101, "|");
			approveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 102, "|"));
			approveTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 103, "|");
			uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 104, "|");
			uWCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 105, "|");
			uWDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 106, "|"));
			uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 107, "|");
			polApplyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 108, "|"));
			appFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 109, "|");
			saleChnlDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 110, "|");
			polState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 111, "|");
			standbyFlag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 112, "|");
			standbyFlag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 113, "|");
			standbyFlag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 114, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 115, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 116, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 117, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 118, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 119, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPolSchema";
			tError.functionName = "decode";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public String getV(String FCode)
	{
		String strReturn = "";
		if (FCode.equalsIgnoreCase("grpContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpContNo));
		if (FCode.equalsIgnoreCase("grpPolNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpPolNo));
		if (FCode.equalsIgnoreCase("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equalsIgnoreCase("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equalsIgnoreCase("polNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polNo));
		if (FCode.equalsIgnoreCase("proposalNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalNo));
		if (FCode.equalsIgnoreCase("prtNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prtNo));
		if (FCode.equalsIgnoreCase("contType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contType));
		if (FCode.equalsIgnoreCase("polTypeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polTypeFlag));
		if (FCode.equalsIgnoreCase("mainPolNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mainPolNo));
		if (FCode.equalsIgnoreCase("masterPolNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(masterPolNo));
		if (FCode.equalsIgnoreCase("kindCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(kindCode));
		if (FCode.equalsIgnoreCase("riskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCode));
		if (FCode.equalsIgnoreCase("riskVersion"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskVersion));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("agentCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCom));
		if (FCode.equalsIgnoreCase("agentType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentType));
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("agentGroup"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup));
		if (FCode.equalsIgnoreCase("agentGroup1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup1));
		if (FCode.equalsIgnoreCase("agentCode1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode1));
		if (FCode.equalsIgnoreCase("saleChnl"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnl));
		if (FCode.equalsIgnoreCase("handler"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(handler));
		if (FCode.equalsIgnoreCase("insuredNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredNo));
		if (FCode.equalsIgnoreCase("insuredId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredId));
		if (FCode.equalsIgnoreCase("insuredName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredName));
		if (FCode.equalsIgnoreCase("insuredSex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredSex));
		if (FCode.equalsIgnoreCase("insuredBirthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getInsuredBirthday()));
		if (FCode.equalsIgnoreCase("insuredAppAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredAppAge));
		if (FCode.equalsIgnoreCase("insuredPeoples"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredPeoples));
		if (FCode.equalsIgnoreCase("occupationType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationType));
		if (FCode.equalsIgnoreCase("appntNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntNo));
		if (FCode.equalsIgnoreCase("appntName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntName));
		if (FCode.equalsIgnoreCase("cValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getCValiDate()));
		if (FCode.equalsIgnoreCase("signCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signCom));
		if (FCode.equalsIgnoreCase("signDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
		if (FCode.equalsIgnoreCase("signTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signTime));
		if (FCode.equalsIgnoreCase("firstPayDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getFirstPayDate()));
		if (FCode.equalsIgnoreCase("payEndDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPayEndDate()));
		if (FCode.equalsIgnoreCase("paytoDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPaytoDate()));
		if (FCode.equalsIgnoreCase("getStartDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getGetStartDate()));
		if (FCode.equalsIgnoreCase("endDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
		if (FCode.equalsIgnoreCase("acciEndDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getAcciEndDate()));
		if (FCode.equalsIgnoreCase("getYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getYearFlag));
		if (FCode.equalsIgnoreCase("getYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getYear));
		if (FCode.equalsIgnoreCase("payEndYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndYearFlag));
		if (FCode.equalsIgnoreCase("payEndYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndYear));
		if (FCode.equalsIgnoreCase("insuYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuYearFlag));
		if (FCode.equalsIgnoreCase("insuYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuYear));
		if (FCode.equalsIgnoreCase("acciYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(acciYearFlag));
		if (FCode.equalsIgnoreCase("acciYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(acciYear));
		if (FCode.equalsIgnoreCase("getStartType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartType));
		if (FCode.equalsIgnoreCase("specifyValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(specifyValiDate));
		if (FCode.equalsIgnoreCase("payMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payMode));
		if (FCode.equalsIgnoreCase("payLocation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payLocation));
		if (FCode.equalsIgnoreCase("payIntv"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payIntv));
		if (FCode.equalsIgnoreCase("payYears"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payYears));
		if (FCode.equalsIgnoreCase("years"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(years));
		if (FCode.equalsIgnoreCase("manageFeeRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageFeeRate));
		if (FCode.equalsIgnoreCase("floatRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(floatRate));
		if (FCode.equalsIgnoreCase("premRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(premRate));
		if (FCode.equalsIgnoreCase("premToAmnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(premToAmnt));
		if (FCode.equalsIgnoreCase("mult"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mult));
		if (FCode.equalsIgnoreCase("standPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(standPrem));
		if (FCode.equalsIgnoreCase("prem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prem));
		if (FCode.equalsIgnoreCase("sumPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sumPrem));
		if (FCode.equalsIgnoreCase("amnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(amnt));
		if (FCode.equalsIgnoreCase("riskAmnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskAmnt));
		if (FCode.equalsIgnoreCase("leavingMoney"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(leavingMoney));
		if (FCode.equalsIgnoreCase("endorseTimes"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(endorseTimes));
		if (FCode.equalsIgnoreCase("claimTimes"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(claimTimes));
		if (FCode.equalsIgnoreCase("liveTimes"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(liveTimes));
		if (FCode.equalsIgnoreCase("renewCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(renewCount));
		if (FCode.equalsIgnoreCase("lastGetDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getLastGetDate()));
		if (FCode.equalsIgnoreCase("lastLoanDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getLastLoanDate()));
		if (FCode.equalsIgnoreCase("lastRegetDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getLastRegetDate()));
		if (FCode.equalsIgnoreCase("lastEdorDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getLastEdorDate()));
		if (FCode.equalsIgnoreCase("lastRevDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getLastRevDate()));
		if (FCode.equalsIgnoreCase("rnewFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rnewFlag));
		if (FCode.equalsIgnoreCase("stopFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(stopFlag));
		if (FCode.equalsIgnoreCase("expiryFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(expiryFlag));
		if (FCode.equalsIgnoreCase("autoPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(autoPayFlag));
		if (FCode.equalsIgnoreCase("interestDifFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(interestDifFlag));
		if (FCode.equalsIgnoreCase("subFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(subFlag));
		if (FCode.equalsIgnoreCase("bnfFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfFlag));
		if (FCode.equalsIgnoreCase("healthCheckFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(healthCheckFlag));
		if (FCode.equalsIgnoreCase("impartFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartFlag));
		if (FCode.equalsIgnoreCase("reinsureFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(reinsureFlag));
		if (FCode.equalsIgnoreCase("agentPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentPayFlag));
		if (FCode.equalsIgnoreCase("agentGetFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGetFlag));
		if (FCode.equalsIgnoreCase("liveGetMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(liveGetMode));
		if (FCode.equalsIgnoreCase("deadGetMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(deadGetMode));
		if (FCode.equalsIgnoreCase("bonusGetMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusGetMode));
		if (FCode.equalsIgnoreCase("deadAmntType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(deadAmntType));
		if (FCode.equalsIgnoreCase("topUpPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(topUpPrem));
		if (FCode.equalsIgnoreCase("bonusMan"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusMan));
		if (FCode.equalsIgnoreCase("deadFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(deadFlag));
		if (FCode.equalsIgnoreCase("smokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(smokeFlag));
		if (FCode.equalsIgnoreCase("remark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark));
		if (FCode.equalsIgnoreCase("approveFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(approveFlag));
		if (FCode.equalsIgnoreCase("approveCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(approveCode));
		if (FCode.equalsIgnoreCase("approveDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getApproveDate()));
		if (FCode.equalsIgnoreCase("approveTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(approveTime));
		if (FCode.equalsIgnoreCase("uWFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWFlag));
		if (FCode.equalsIgnoreCase("uWCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWCode));
		if (FCode.equalsIgnoreCase("uWDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
		if (FCode.equalsIgnoreCase("uWTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWTime));
		if (FCode.equalsIgnoreCase("polApplyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPolApplyDate()));
		if (FCode.equalsIgnoreCase("appFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appFlag));
		if (FCode.equalsIgnoreCase("saleChnlDetail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnlDetail));
		if (FCode.equalsIgnoreCase("polState"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polState));
		if (FCode.equalsIgnoreCase("standbyFlag1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(standbyFlag1));
		if (FCode.equalsIgnoreCase("standbyFlag2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(standbyFlag2));
		if (FCode.equalsIgnoreCase("standbyFlag3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(standbyFlag3));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
		if (strReturn.equals(""))
			strReturn = "null";
		return strReturn;
	}

	public String getV(int nFieldIndex)
	{
		String strFieldValue = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(grpPolNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(polNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(proposalNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(prtNo);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(contType);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(polTypeFlag);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(mainPolNo);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(masterPolNo);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(kindCode);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(riskCode);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(riskVersion);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(agentCom);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(agentType);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(agentGroup);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(agentGroup1);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(agentCode1);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(saleChnl);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(handler);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(insuredNo);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(insuredId);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(insuredName);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(insuredSex);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getInsuredBirthday()));
			break;

		case 28: // '\034'
			strFieldValue = String.valueOf(insuredAppAge);
			break;

		case 29: // '\035'
			strFieldValue = String.valueOf(insuredPeoples);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(occupationType);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(appntNo);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(appntName);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCValiDate()));
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(signCom);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(signTime);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getFirstPayDate()));
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPayEndDate()));
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPaytoDate()));
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getGetStartDate()));
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getAcciEndDate()));
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(getYearFlag);
			break;

		case 44: // ','
			strFieldValue = String.valueOf(getYear);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(payEndYearFlag);
			break;

		case 46: // '.'
			strFieldValue = String.valueOf(payEndYear);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(insuYearFlag);
			break;

		case 48: // '0'
			strFieldValue = String.valueOf(insuYear);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(acciYearFlag);
			break;

		case 50: // '2'
			strFieldValue = String.valueOf(acciYear);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(getStartType);
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(specifyValiDate);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(payMode);
			break;

		case 54: // '6'
			strFieldValue = StrTool.GBKToUnicode(payLocation);
			break;

		case 55: // '7'
			strFieldValue = String.valueOf(payIntv);
			break;

		case 56: // '8'
			strFieldValue = String.valueOf(payYears);
			break;

		case 57: // '9'
			strFieldValue = String.valueOf(years);
			break;

		case 58: // ':'
			strFieldValue = String.valueOf(manageFeeRate);
			break;

		case 59: // ';'
			strFieldValue = String.valueOf(floatRate);
			break;

		case 60: // '<'
			strFieldValue = String.valueOf(premRate);
			break;

		case 61: // '='
			strFieldValue = StrTool.GBKToUnicode(premToAmnt);
			break;

		case 62: // '>'
			strFieldValue = String.valueOf(mult);
			break;

		case 63: // '?'
			strFieldValue = String.valueOf(standPrem);
			break;

		case 64: // '@'
			strFieldValue = String.valueOf(prem);
			break;

		case 65: // 'A'
			strFieldValue = String.valueOf(sumPrem);
			break;

		case 66: // 'B'
			strFieldValue = String.valueOf(amnt);
			break;

		case 67: // 'C'
			strFieldValue = String.valueOf(riskAmnt);
			break;

		case 68: // 'D'
			strFieldValue = String.valueOf(leavingMoney);
			break;

		case 69: // 'E'
			strFieldValue = String.valueOf(endorseTimes);
			break;

		case 70: // 'F'
			strFieldValue = String.valueOf(claimTimes);
			break;

		case 71: // 'G'
			strFieldValue = String.valueOf(liveTimes);
			break;

		case 72: // 'H'
			strFieldValue = String.valueOf(renewCount);
			break;

		case 73: // 'I'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastGetDate()));
			break;

		case 74: // 'J'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastLoanDate()));
			break;

		case 75: // 'K'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastRegetDate()));
			break;

		case 76: // 'L'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastEdorDate()));
			break;

		case 77: // 'M'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLastRevDate()));
			break;

		case 78: // 'N'
			strFieldValue = StrTool.GBKToUnicode(rnewFlag);
			break;

		case 79: // 'O'
			strFieldValue = StrTool.GBKToUnicode(stopFlag);
			break;

		case 80: // 'P'
			strFieldValue = StrTool.GBKToUnicode(expiryFlag);
			break;

		case 81: // 'Q'
			strFieldValue = StrTool.GBKToUnicode(autoPayFlag);
			break;

		case 82: // 'R'
			strFieldValue = StrTool.GBKToUnicode(interestDifFlag);
			break;

		case 83: // 'S'
			strFieldValue = StrTool.GBKToUnicode(subFlag);
			break;

		case 84: // 'T'
			strFieldValue = StrTool.GBKToUnicode(bnfFlag);
			break;

		case 85: // 'U'
			strFieldValue = StrTool.GBKToUnicode(healthCheckFlag);
			break;

		case 86: // 'V'
			strFieldValue = StrTool.GBKToUnicode(impartFlag);
			break;

		case 87: // 'W'
			strFieldValue = StrTool.GBKToUnicode(reinsureFlag);
			break;

		case 88: // 'X'
			strFieldValue = StrTool.GBKToUnicode(agentPayFlag);
			break;

		case 89: // 'Y'
			strFieldValue = StrTool.GBKToUnicode(agentGetFlag);
			break;

		case 90: // 'Z'
			strFieldValue = StrTool.GBKToUnicode(liveGetMode);
			break;

		case 91: // '['
			strFieldValue = StrTool.GBKToUnicode(deadGetMode);
			break;

		case 92: // '\\'
			strFieldValue = StrTool.GBKToUnicode(bonusGetMode);
			break;

		case 93: // ']'
			strFieldValue = StrTool.GBKToUnicode(deadAmntType);
			break;

		case 94: // '^'
			strFieldValue = String.valueOf(topUpPrem);
			break;

		case 95: // '_'
			strFieldValue = StrTool.GBKToUnicode(bonusMan);
			break;

		case 96: // '`'
			strFieldValue = StrTool.GBKToUnicode(deadFlag);
			break;

		case 97: // 'a'
			strFieldValue = StrTool.GBKToUnicode(smokeFlag);
			break;

		case 98: // 'b'
			strFieldValue = StrTool.GBKToUnicode(remark);
			break;

		case 99: // 'c'
			strFieldValue = StrTool.GBKToUnicode(approveFlag);
			break;

		case 100: // 'd'
			strFieldValue = StrTool.GBKToUnicode(approveCode);
			break;

		case 101: // 'e'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getApproveDate()));
			break;

		case 102: // 'f'
			strFieldValue = StrTool.GBKToUnicode(approveTime);
			break;

		case 103: // 'g'
			strFieldValue = StrTool.GBKToUnicode(uWFlag);
			break;

		case 104: // 'h'
			strFieldValue = StrTool.GBKToUnicode(uWCode);
			break;

		case 105: // 'i'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
			break;

		case 106: // 'j'
			strFieldValue = StrTool.GBKToUnicode(uWTime);
			break;

		case 107: // 'k'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPolApplyDate()));
			break;

		case 108: // 'l'
			strFieldValue = StrTool.GBKToUnicode(appFlag);
			break;

		case 109: // 'm'
			strFieldValue = StrTool.GBKToUnicode(saleChnlDetail);
			break;

		case 110: // 'n'
			strFieldValue = StrTool.GBKToUnicode(polState);
			break;

		case 111: // 'o'
			strFieldValue = StrTool.GBKToUnicode(standbyFlag1);
			break;

		case 112: // 'p'
			strFieldValue = StrTool.GBKToUnicode(standbyFlag2);
			break;

		case 113: // 'q'
			strFieldValue = StrTool.GBKToUnicode(standbyFlag3);
			break;

		case 114: // 'r'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 115: // 's'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 116: // 't'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 117: // 'u'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 118: // 'v'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		default:
			strFieldValue = "";
			break;
		}
		if (strFieldValue.equals(""))
			strFieldValue = "null";
		return strFieldValue;
	}

	public boolean setV(String FCode, String FValue)
	{
		if (StrTool.cTrim(FCode).equals(""))
			return false;
		if (FCode.equalsIgnoreCase("grpContNo"))
			if (FValue != null && !FValue.equals(""))
				grpContNo = FValue.trim();
			else
				grpContNo = null;
		if (FCode.equalsIgnoreCase("grpPolNo"))
			if (FValue != null && !FValue.equals(""))
				grpPolNo = FValue.trim();
			else
				grpPolNo = null;
		if (FCode.equalsIgnoreCase("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equalsIgnoreCase("proposalContNo"))
			if (FValue != null && !FValue.equals(""))
				proposalContNo = FValue.trim();
			else
				proposalContNo = null;
		if (FCode.equalsIgnoreCase("polNo"))
			if (FValue != null && !FValue.equals(""))
				polNo = FValue.trim();
			else
				polNo = null;
		if (FCode.equalsIgnoreCase("proposalNo"))
			if (FValue != null && !FValue.equals(""))
				proposalNo = FValue.trim();
			else
				proposalNo = null;
		if (FCode.equalsIgnoreCase("prtNo"))
			if (FValue != null && !FValue.equals(""))
				prtNo = FValue.trim();
			else
				prtNo = null;
		if (FCode.equalsIgnoreCase("contType"))
			if (FValue != null && !FValue.equals(""))
				contType = FValue.trim();
			else
				contType = null;
		if (FCode.equalsIgnoreCase("polTypeFlag"))
			if (FValue != null && !FValue.equals(""))
				polTypeFlag = FValue.trim();
			else
				polTypeFlag = null;
		if (FCode.equalsIgnoreCase("mainPolNo"))
			if (FValue != null && !FValue.equals(""))
				mainPolNo = FValue.trim();
			else
				mainPolNo = null;
		if (FCode.equalsIgnoreCase("masterPolNo"))
			if (FValue != null && !FValue.equals(""))
				masterPolNo = FValue.trim();
			else
				masterPolNo = null;
		if (FCode.equalsIgnoreCase("kindCode"))
			if (FValue != null && !FValue.equals(""))
				kindCode = FValue.trim();
			else
				kindCode = null;
		if (FCode.equalsIgnoreCase("riskCode"))
			if (FValue != null && !FValue.equals(""))
				riskCode = FValue.trim();
			else
				riskCode = null;
		if (FCode.equalsIgnoreCase("riskVersion"))
			if (FValue != null && !FValue.equals(""))
				riskVersion = FValue.trim();
			else
				riskVersion = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("agentCom"))
			if (FValue != null && !FValue.equals(""))
				agentCom = FValue.trim();
			else
				agentCom = null;
		if (FCode.equalsIgnoreCase("agentType"))
			if (FValue != null && !FValue.equals(""))
				agentType = FValue.trim();
			else
				agentType = null;
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equalsIgnoreCase("agentGroup"))
			if (FValue != null && !FValue.equals(""))
				agentGroup = FValue.trim();
			else
				agentGroup = null;
		if (FCode.equalsIgnoreCase("agentGroup1"))
			if (FValue != null && !FValue.equals(""))
				agentGroup1 = FValue.trim();
			else
				agentGroup1 = null;
		if (FCode.equalsIgnoreCase("agentCode1"))
			if (FValue != null && !FValue.equals(""))
				agentCode1 = FValue.trim();
			else
				agentCode1 = null;
		if (FCode.equalsIgnoreCase("saleChnl"))
			if (FValue != null && !FValue.equals(""))
				saleChnl = FValue.trim();
			else
				saleChnl = null;
		if (FCode.equalsIgnoreCase("handler"))
			if (FValue != null && !FValue.equals(""))
				handler = FValue.trim();
			else
				handler = null;
		if (FCode.equalsIgnoreCase("insuredNo"))
			if (FValue != null && !FValue.equals(""))
				insuredNo = FValue.trim();
			else
				insuredNo = null;
		if (FCode.equalsIgnoreCase("insuredId"))
			if (FValue != null && !FValue.equals(""))
				insuredId = FValue.trim();
			else
				insuredId = null;
		if (FCode.equalsIgnoreCase("insuredName"))
			if (FValue != null && !FValue.equals(""))
				insuredName = FValue.trim();
			else
				insuredName = null;
		if (FCode.equalsIgnoreCase("insuredSex"))
			if (FValue != null && !FValue.equals(""))
				insuredSex = FValue.trim();
			else
				insuredSex = null;
		if (FCode.equalsIgnoreCase("insuredBirthday"))
			if (FValue != null && !FValue.equals(""))
				insuredBirthday = fDate.getDate(FValue);
			else
				insuredBirthday = null;
		if (FCode.equalsIgnoreCase("insuredAppAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			insuredAppAge = i;
		}
		if (FCode.equalsIgnoreCase("insuredPeoples") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			insuredPeoples = i;
		}
		if (FCode.equalsIgnoreCase("occupationType"))
			if (FValue != null && !FValue.equals(""))
				occupationType = FValue.trim();
			else
				occupationType = null;
		if (FCode.equalsIgnoreCase("appntNo"))
			if (FValue != null && !FValue.equals(""))
				appntNo = FValue.trim();
			else
				appntNo = null;
		if (FCode.equalsIgnoreCase("appntName"))
			if (FValue != null && !FValue.equals(""))
				appntName = FValue.trim();
			else
				appntName = null;
		if (FCode.equalsIgnoreCase("cValiDate"))
			if (FValue != null && !FValue.equals(""))
				cValiDate = fDate.getDate(FValue);
			else
				cValiDate = null;
		if (FCode.equalsIgnoreCase("signCom"))
			if (FValue != null && !FValue.equals(""))
				signCom = FValue.trim();
			else
				signCom = null;
		if (FCode.equalsIgnoreCase("signDate"))
			if (FValue != null && !FValue.equals(""))
				signDate = fDate.getDate(FValue);
			else
				signDate = null;
		if (FCode.equalsIgnoreCase("signTime"))
			if (FValue != null && !FValue.equals(""))
				signTime = FValue.trim();
			else
				signTime = null;
		if (FCode.equalsIgnoreCase("firstPayDate"))
			if (FValue != null && !FValue.equals(""))
				firstPayDate = fDate.getDate(FValue);
			else
				firstPayDate = null;
		if (FCode.equalsIgnoreCase("payEndDate"))
			if (FValue != null && !FValue.equals(""))
				payEndDate = fDate.getDate(FValue);
			else
				payEndDate = null;
		if (FCode.equalsIgnoreCase("paytoDate"))
			if (FValue != null && !FValue.equals(""))
				paytoDate = fDate.getDate(FValue);
			else
				paytoDate = null;
		if (FCode.equalsIgnoreCase("getStartDate"))
			if (FValue != null && !FValue.equals(""))
				getStartDate = fDate.getDate(FValue);
			else
				getStartDate = null;
		if (FCode.equalsIgnoreCase("endDate"))
			if (FValue != null && !FValue.equals(""))
				endDate = fDate.getDate(FValue);
			else
				endDate = null;
		if (FCode.equalsIgnoreCase("acciEndDate"))
			if (FValue != null && !FValue.equals(""))
				acciEndDate = fDate.getDate(FValue);
			else
				acciEndDate = null;
		if (FCode.equalsIgnoreCase("getYearFlag"))
			if (FValue != null && !FValue.equals(""))
				getYearFlag = FValue.trim();
			else
				getYearFlag = null;
		if (FCode.equalsIgnoreCase("getYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			getYear = i;
		}
		if (FCode.equalsIgnoreCase("payEndYearFlag"))
			if (FValue != null && !FValue.equals(""))
				payEndYearFlag = FValue.trim();
			else
				payEndYearFlag = null;
		if (FCode.equalsIgnoreCase("payEndYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payEndYear = i;
		}
		if (FCode.equalsIgnoreCase("insuYearFlag"))
			if (FValue != null && !FValue.equals(""))
				insuYearFlag = FValue.trim();
			else
				insuYearFlag = null;
		if (FCode.equalsIgnoreCase("insuYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			insuYear = i;
		}
		if (FCode.equalsIgnoreCase("acciYearFlag"))
			if (FValue != null && !FValue.equals(""))
				acciYearFlag = FValue.trim();
			else
				acciYearFlag = null;
		if (FCode.equalsIgnoreCase("acciYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			acciYear = i;
		}
		if (FCode.equalsIgnoreCase("getStartType"))
			if (FValue != null && !FValue.equals(""))
				getStartType = FValue.trim();
			else
				getStartType = null;
		if (FCode.equalsIgnoreCase("specifyValiDate"))
			if (FValue != null && !FValue.equals(""))
				specifyValiDate = FValue.trim();
			else
				specifyValiDate = null;
		if (FCode.equalsIgnoreCase("payMode"))
			if (FValue != null && !FValue.equals(""))
				payMode = FValue.trim();
			else
				payMode = null;
		if (FCode.equalsIgnoreCase("payLocation"))
			if (FValue != null && !FValue.equals(""))
				payLocation = FValue.trim();
			else
				payLocation = null;
		if (FCode.equalsIgnoreCase("payIntv") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payIntv = i;
		}
		if (FCode.equalsIgnoreCase("payYears") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payYears = i;
		}
		if (FCode.equalsIgnoreCase("years") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			years = i;
		}
		if (FCode.equalsIgnoreCase("manageFeeRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			manageFeeRate = d;
		}
		if (FCode.equalsIgnoreCase("floatRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			floatRate = d;
		}
		if (FCode.equalsIgnoreCase("premRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			premRate = d;
		}
		if (FCode.equalsIgnoreCase("premToAmnt"))
			if (FValue != null && !FValue.equals(""))
				premToAmnt = FValue.trim();
			else
				premToAmnt = null;
		if (FCode.equalsIgnoreCase("mult") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mult = d;
		}
		if (FCode.equalsIgnoreCase("standPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			standPrem = d;
		}
		if (FCode.equalsIgnoreCase("prem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			prem = d;
		}
		if (FCode.equalsIgnoreCase("sumPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sumPrem = d;
		}
		if (FCode.equalsIgnoreCase("amnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			amnt = d;
		}
		if (FCode.equalsIgnoreCase("riskAmnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			riskAmnt = d;
		}
		if (FCode.equalsIgnoreCase("leavingMoney") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			leavingMoney = d;
		}
		if (FCode.equalsIgnoreCase("endorseTimes") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			endorseTimes = i;
		}
		if (FCode.equalsIgnoreCase("claimTimes") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			claimTimes = i;
		}
		if (FCode.equalsIgnoreCase("liveTimes") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			liveTimes = i;
		}
		if (FCode.equalsIgnoreCase("renewCount") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			renewCount = i;
		}
		if (FCode.equalsIgnoreCase("lastGetDate"))
			if (FValue != null && !FValue.equals(""))
				lastGetDate = fDate.getDate(FValue);
			else
				lastGetDate = null;
		if (FCode.equalsIgnoreCase("lastLoanDate"))
			if (FValue != null && !FValue.equals(""))
				lastLoanDate = fDate.getDate(FValue);
			else
				lastLoanDate = null;
		if (FCode.equalsIgnoreCase("lastRegetDate"))
			if (FValue != null && !FValue.equals(""))
				lastRegetDate = fDate.getDate(FValue);
			else
				lastRegetDate = null;
		if (FCode.equalsIgnoreCase("lastEdorDate"))
			if (FValue != null && !FValue.equals(""))
				lastEdorDate = fDate.getDate(FValue);
			else
				lastEdorDate = null;
		if (FCode.equalsIgnoreCase("lastRevDate"))
			if (FValue != null && !FValue.equals(""))
				lastRevDate = fDate.getDate(FValue);
			else
				lastRevDate = null;
		if (FCode.equalsIgnoreCase("rnewFlag"))
			if (FValue != null && !FValue.equals(""))
				rnewFlag = FValue.trim();
			else
				rnewFlag = null;
		if (FCode.equalsIgnoreCase("stopFlag"))
			if (FValue != null && !FValue.equals(""))
				stopFlag = FValue.trim();
			else
				stopFlag = null;
		if (FCode.equalsIgnoreCase("expiryFlag"))
			if (FValue != null && !FValue.equals(""))
				expiryFlag = FValue.trim();
			else
				expiryFlag = null;
		if (FCode.equalsIgnoreCase("autoPayFlag"))
			if (FValue != null && !FValue.equals(""))
				autoPayFlag = FValue.trim();
			else
				autoPayFlag = null;
		if (FCode.equalsIgnoreCase("interestDifFlag"))
			if (FValue != null && !FValue.equals(""))
				interestDifFlag = FValue.trim();
			else
				interestDifFlag = null;
		if (FCode.equalsIgnoreCase("subFlag"))
			if (FValue != null && !FValue.equals(""))
				subFlag = FValue.trim();
			else
				subFlag = null;
		if (FCode.equalsIgnoreCase("bnfFlag"))
			if (FValue != null && !FValue.equals(""))
				bnfFlag = FValue.trim();
			else
				bnfFlag = null;
		if (FCode.equalsIgnoreCase("healthCheckFlag"))
			if (FValue != null && !FValue.equals(""))
				healthCheckFlag = FValue.trim();
			else
				healthCheckFlag = null;
		if (FCode.equalsIgnoreCase("impartFlag"))
			if (FValue != null && !FValue.equals(""))
				impartFlag = FValue.trim();
			else
				impartFlag = null;
		if (FCode.equalsIgnoreCase("reinsureFlag"))
			if (FValue != null && !FValue.equals(""))
				reinsureFlag = FValue.trim();
			else
				reinsureFlag = null;
		if (FCode.equalsIgnoreCase("agentPayFlag"))
			if (FValue != null && !FValue.equals(""))
				agentPayFlag = FValue.trim();
			else
				agentPayFlag = null;
		if (FCode.equalsIgnoreCase("agentGetFlag"))
			if (FValue != null && !FValue.equals(""))
				agentGetFlag = FValue.trim();
			else
				agentGetFlag = null;
		if (FCode.equalsIgnoreCase("liveGetMode"))
			if (FValue != null && !FValue.equals(""))
				liveGetMode = FValue.trim();
			else
				liveGetMode = null;
		if (FCode.equalsIgnoreCase("deadGetMode"))
			if (FValue != null && !FValue.equals(""))
				deadGetMode = FValue.trim();
			else
				deadGetMode = null;
		if (FCode.equalsIgnoreCase("bonusGetMode"))
			if (FValue != null && !FValue.equals(""))
				bonusGetMode = FValue.trim();
			else
				bonusGetMode = null;
		if (FCode.equalsIgnoreCase("deadAmntType"))
			if (FValue != null && !FValue.equals(""))
				deadAmntType = FValue.trim();
			else
				deadAmntType = null;
		if (FCode.equalsIgnoreCase("topUpPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			topUpPrem = d;
		}
		if (FCode.equalsIgnoreCase("bonusMan"))
			if (FValue != null && !FValue.equals(""))
				bonusMan = FValue.trim();
			else
				bonusMan = null;
		if (FCode.equalsIgnoreCase("deadFlag"))
			if (FValue != null && !FValue.equals(""))
				deadFlag = FValue.trim();
			else
				deadFlag = null;
		if (FCode.equalsIgnoreCase("smokeFlag"))
			if (FValue != null && !FValue.equals(""))
				smokeFlag = FValue.trim();
			else
				smokeFlag = null;
		if (FCode.equalsIgnoreCase("remark"))
			if (FValue != null && !FValue.equals(""))
				remark = FValue.trim();
			else
				remark = null;
		if (FCode.equalsIgnoreCase("approveFlag"))
			if (FValue != null && !FValue.equals(""))
				approveFlag = FValue.trim();
			else
				approveFlag = null;
		if (FCode.equalsIgnoreCase("approveCode"))
			if (FValue != null && !FValue.equals(""))
				approveCode = FValue.trim();
			else
				approveCode = null;
		if (FCode.equalsIgnoreCase("approveDate"))
			if (FValue != null && !FValue.equals(""))
				approveDate = fDate.getDate(FValue);
			else
				approveDate = null;
		if (FCode.equalsIgnoreCase("approveTime"))
			if (FValue != null && !FValue.equals(""))
				approveTime = FValue.trim();
			else
				approveTime = null;
		if (FCode.equalsIgnoreCase("uWFlag"))
			if (FValue != null && !FValue.equals(""))
				uWFlag = FValue.trim();
			else
				uWFlag = null;
		if (FCode.equalsIgnoreCase("uWCode"))
			if (FValue != null && !FValue.equals(""))
				uWCode = FValue.trim();
			else
				uWCode = null;
		if (FCode.equalsIgnoreCase("uWDate"))
			if (FValue != null && !FValue.equals(""))
				uWDate = fDate.getDate(FValue);
			else
				uWDate = null;
		if (FCode.equalsIgnoreCase("uWTime"))
			if (FValue != null && !FValue.equals(""))
				uWTime = FValue.trim();
			else
				uWTime = null;
		if (FCode.equalsIgnoreCase("polApplyDate"))
			if (FValue != null && !FValue.equals(""))
				polApplyDate = fDate.getDate(FValue);
			else
				polApplyDate = null;
		if (FCode.equalsIgnoreCase("appFlag"))
			if (FValue != null && !FValue.equals(""))
				appFlag = FValue.trim();
			else
				appFlag = null;
		if (FCode.equalsIgnoreCase("saleChnlDetail"))
			if (FValue != null && !FValue.equals(""))
				saleChnlDetail = FValue.trim();
			else
				saleChnlDetail = null;
		if (FCode.equalsIgnoreCase("polState"))
			if (FValue != null && !FValue.equals(""))
				polState = FValue.trim();
			else
				polState = null;
		if (FCode.equalsIgnoreCase("standbyFlag1"))
			if (FValue != null && !FValue.equals(""))
				standbyFlag1 = FValue.trim();
			else
				standbyFlag1 = null;
		if (FCode.equalsIgnoreCase("standbyFlag2"))
			if (FValue != null && !FValue.equals(""))
				standbyFlag2 = FValue.trim();
			else
				standbyFlag2 = null;
		if (FCode.equalsIgnoreCase("standbyFlag3"))
			if (FValue != null && !FValue.equals(""))
				standbyFlag3 = FValue.trim();
			else
				standbyFlag3 = null;
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equalsIgnoreCase("makeDate"))
			if (FValue != null && !FValue.equals(""))
				makeDate = fDate.getDate(FValue);
			else
				makeDate = null;
		if (FCode.equalsIgnoreCase("makeTime"))
			if (FValue != null && !FValue.equals(""))
				makeTime = FValue.trim();
			else
				makeTime = null;
		if (FCode.equalsIgnoreCase("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equalsIgnoreCase("modifyTime"))
			if (FValue != null && !FValue.equals(""))
				modifyTime = FValue.trim();
			else
				modifyTime = null;
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		if (this == otherObject)
			return true;
		if (getClass() != otherObject.getClass())
			return false;
		LNPPolSchema other = (LNPPolSchema)otherObject;
		if (grpContNo == null && other.getGrpContNo() != null)
			return false;
		if (grpContNo != null && !grpContNo.equals(other.getGrpContNo()))
			return false;
		if (grpPolNo == null && other.getGrpPolNo() != null)
			return false;
		if (grpPolNo != null && !grpPolNo.equals(other.getGrpPolNo()))
			return false;
		if (contNo == null && other.getContNo() != null)
			return false;
		if (contNo != null && !contNo.equals(other.getContNo()))
			return false;
		if (proposalContNo == null && other.getProposalContNo() != null)
			return false;
		if (proposalContNo != null && !proposalContNo.equals(other.getProposalContNo()))
			return false;
		if (polNo == null && other.getPolNo() != null)
			return false;
		if (polNo != null && !polNo.equals(other.getPolNo()))
			return false;
		if (proposalNo == null && other.getProposalNo() != null)
			return false;
		if (proposalNo != null && !proposalNo.equals(other.getProposalNo()))
			return false;
		if (prtNo == null && other.getPrtNo() != null)
			return false;
		if (prtNo != null && !prtNo.equals(other.getPrtNo()))
			return false;
		if (contType == null && other.getContType() != null)
			return false;
		if (contType != null && !contType.equals(other.getContType()))
			return false;
		if (polTypeFlag == null && other.getPolTypeFlag() != null)
			return false;
		if (polTypeFlag != null && !polTypeFlag.equals(other.getPolTypeFlag()))
			return false;
		if (mainPolNo == null && other.getMainPolNo() != null)
			return false;
		if (mainPolNo != null && !mainPolNo.equals(other.getMainPolNo()))
			return false;
		if (masterPolNo == null && other.getMasterPolNo() != null)
			return false;
		if (masterPolNo != null && !masterPolNo.equals(other.getMasterPolNo()))
			return false;
		if (kindCode == null && other.getKindCode() != null)
			return false;
		if (kindCode != null && !kindCode.equals(other.getKindCode()))
			return false;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (riskVersion == null && other.getRiskVersion() != null)
			return false;
		if (riskVersion != null && !riskVersion.equals(other.getRiskVersion()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (agentCom == null && other.getAgentCom() != null)
			return false;
		if (agentCom != null && !agentCom.equals(other.getAgentCom()))
			return false;
		if (agentType == null && other.getAgentType() != null)
			return false;
		if (agentType != null && !agentType.equals(other.getAgentType()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (agentGroup == null && other.getAgentGroup() != null)
			return false;
		if (agentGroup != null && !agentGroup.equals(other.getAgentGroup()))
			return false;
		if (agentGroup1 == null && other.getAgentGroup1() != null)
			return false;
		if (agentGroup1 != null && !agentGroup1.equals(other.getAgentGroup1()))
			return false;
		if (agentCode1 == null && other.getAgentCode1() != null)
			return false;
		if (agentCode1 != null && !agentCode1.equals(other.getAgentCode1()))
			return false;
		if (saleChnl == null && other.getSaleChnl() != null)
			return false;
		if (saleChnl != null && !saleChnl.equals(other.getSaleChnl()))
			return false;
		if (handler == null && other.getHandler() != null)
			return false;
		if (handler != null && !handler.equals(other.getHandler()))
			return false;
		if (insuredNo == null && other.getInsuredNo() != null)
			return false;
		if (insuredNo != null && !insuredNo.equals(other.getInsuredNo()))
			return false;
		if (insuredId == null && other.getInsuredId() != null)
			return false;
		if (insuredId != null && !insuredId.equals(other.getInsuredId()))
			return false;
		if (insuredName == null && other.getInsuredName() != null)
			return false;
		if (insuredName != null && !insuredName.equals(other.getInsuredName()))
			return false;
		if (insuredSex == null && other.getInsuredSex() != null)
			return false;
		if (insuredSex != null && !insuredSex.equals(other.getInsuredSex()))
			return false;
		if (insuredBirthday == null && other.getInsuredBirthday() != null)
			return false;
		if (insuredBirthday != null && !fDate.getString(insuredBirthday).equals(other.getInsuredBirthday()))
			return false;
		if (insuredAppAge != other.getInsuredAppAge())
			return false;
		if (insuredPeoples != other.getInsuredPeoples())
			return false;
		if (occupationType == null && other.getOccupationType() != null)
			return false;
		if (occupationType != null && !occupationType.equals(other.getOccupationType()))
			return false;
		if (appntNo == null && other.getAppntNo() != null)
			return false;
		if (appntNo != null && !appntNo.equals(other.getAppntNo()))
			return false;
		if (appntName == null && other.getAppntName() != null)
			return false;
		if (appntName != null && !appntName.equals(other.getAppntName()))
			return false;
		if (cValiDate == null && other.getCValiDate() != null)
			return false;
		if (cValiDate != null && !fDate.getString(cValiDate).equals(other.getCValiDate()))
			return false;
		if (signCom == null && other.getSignCom() != null)
			return false;
		if (signCom != null && !signCom.equals(other.getSignCom()))
			return false;
		if (signDate == null && other.getSignDate() != null)
			return false;
		if (signDate != null && !fDate.getString(signDate).equals(other.getSignDate()))
			return false;
		if (signTime == null && other.getSignTime() != null)
			return false;
		if (signTime != null && !signTime.equals(other.getSignTime()))
			return false;
		if (firstPayDate == null && other.getFirstPayDate() != null)
			return false;
		if (firstPayDate != null && !fDate.getString(firstPayDate).equals(other.getFirstPayDate()))
			return false;
		if (payEndDate == null && other.getPayEndDate() != null)
			return false;
		if (payEndDate != null && !fDate.getString(payEndDate).equals(other.getPayEndDate()))
			return false;
		if (paytoDate == null && other.getPaytoDate() != null)
			return false;
		if (paytoDate != null && !fDate.getString(paytoDate).equals(other.getPaytoDate()))
			return false;
		if (getStartDate == null && other.getGetStartDate() != null)
			return false;
		if (getStartDate != null && !fDate.getString(getStartDate).equals(other.getGetStartDate()))
			return false;
		if (endDate == null && other.getEndDate() != null)
			return false;
		if (endDate != null && !fDate.getString(endDate).equals(other.getEndDate()))
			return false;
		if (acciEndDate == null && other.getAcciEndDate() != null)
			return false;
		if (acciEndDate != null && !fDate.getString(acciEndDate).equals(other.getAcciEndDate()))
			return false;
		if (getYearFlag == null && other.getGetYearFlag() != null)
			return false;
		if (getYearFlag != null && !getYearFlag.equals(other.getGetYearFlag()))
			return false;
		if (getYear != other.getGetYear())
			return false;
		if (payEndYearFlag == null && other.getPayEndYearFlag() != null)
			return false;
		if (payEndYearFlag != null && !payEndYearFlag.equals(other.getPayEndYearFlag()))
			return false;
		if (payEndYear != other.getPayEndYear())
			return false;
		if (insuYearFlag == null && other.getInsuYearFlag() != null)
			return false;
		if (insuYearFlag != null && !insuYearFlag.equals(other.getInsuYearFlag()))
			return false;
		if (insuYear != other.getInsuYear())
			return false;
		if (acciYearFlag == null && other.getAcciYearFlag() != null)
			return false;
		if (acciYearFlag != null && !acciYearFlag.equals(other.getAcciYearFlag()))
			return false;
		if (acciYear != other.getAcciYear())
			return false;
		if (getStartType == null && other.getGetStartType() != null)
			return false;
		if (getStartType != null && !getStartType.equals(other.getGetStartType()))
			return false;
		if (specifyValiDate == null && other.getSpecifyValiDate() != null)
			return false;
		if (specifyValiDate != null && !specifyValiDate.equals(other.getSpecifyValiDate()))
			return false;
		if (payMode == null && other.getPayMode() != null)
			return false;
		if (payMode != null && !payMode.equals(other.getPayMode()))
			return false;
		if (payLocation == null && other.getPayLocation() != null)
			return false;
		if (payLocation != null && !payLocation.equals(other.getPayLocation()))
			return false;
		if (payIntv != other.getPayIntv())
			return false;
		if (payYears != other.getPayYears())
			return false;
		if (years != other.getYears())
			return false;
		if (Double.doubleToLongBits(manageFeeRate) != Double.doubleToLongBits(other.getManageFeeRate()))
			return false;
		if (Double.doubleToLongBits(floatRate) != Double.doubleToLongBits(other.getFloatRate()))
			return false;
		if (Double.doubleToLongBits(premRate) != Double.doubleToLongBits(other.getPremRate()))
			return false;
		if (premToAmnt == null && other.getPremToAmnt() != null)
			return false;
		if (premToAmnt != null && !premToAmnt.equals(other.getPremToAmnt()))
			return false;
		if (Double.doubleToLongBits(mult) != Double.doubleToLongBits(other.getMult()))
			return false;
		if (Double.doubleToLongBits(standPrem) != Double.doubleToLongBits(other.getStandPrem()))
			return false;
		if (Double.doubleToLongBits(prem) != Double.doubleToLongBits(other.getPrem()))
			return false;
		if (Double.doubleToLongBits(sumPrem) != Double.doubleToLongBits(other.getSumPrem()))
			return false;
		if (Double.doubleToLongBits(amnt) != Double.doubleToLongBits(other.getAmnt()))
			return false;
		if (Double.doubleToLongBits(riskAmnt) != Double.doubleToLongBits(other.getRiskAmnt()))
			return false;
		if (Double.doubleToLongBits(leavingMoney) != Double.doubleToLongBits(other.getLeavingMoney()))
			return false;
		if (endorseTimes != other.getEndorseTimes())
			return false;
		if (claimTimes != other.getClaimTimes())
			return false;
		if (liveTimes != other.getLiveTimes())
			return false;
		if (renewCount != other.getRenewCount())
			return false;
		if (lastGetDate == null && other.getLastGetDate() != null)
			return false;
		if (lastGetDate != null && !fDate.getString(lastGetDate).equals(other.getLastGetDate()))
			return false;
		if (lastLoanDate == null && other.getLastLoanDate() != null)
			return false;
		if (lastLoanDate != null && !fDate.getString(lastLoanDate).equals(other.getLastLoanDate()))
			return false;
		if (lastRegetDate == null && other.getLastRegetDate() != null)
			return false;
		if (lastRegetDate != null && !fDate.getString(lastRegetDate).equals(other.getLastRegetDate()))
			return false;
		if (lastEdorDate == null && other.getLastEdorDate() != null)
			return false;
		if (lastEdorDate != null && !fDate.getString(lastEdorDate).equals(other.getLastEdorDate()))
			return false;
		if (lastRevDate == null && other.getLastRevDate() != null)
			return false;
		if (lastRevDate != null && !fDate.getString(lastRevDate).equals(other.getLastRevDate()))
			return false;
		if (rnewFlag == null && other.getRnewFlag() != null)
			return false;
		if (rnewFlag != null && !rnewFlag.equals(other.getRnewFlag()))
			return false;
		if (stopFlag == null && other.getStopFlag() != null)
			return false;
		if (stopFlag != null && !stopFlag.equals(other.getStopFlag()))
			return false;
		if (expiryFlag == null && other.getExpiryFlag() != null)
			return false;
		if (expiryFlag != null && !expiryFlag.equals(other.getExpiryFlag()))
			return false;
		if (autoPayFlag == null && other.getAutoPayFlag() != null)
			return false;
		if (autoPayFlag != null && !autoPayFlag.equals(other.getAutoPayFlag()))
			return false;
		if (interestDifFlag == null && other.getInterestDifFlag() != null)
			return false;
		if (interestDifFlag != null && !interestDifFlag.equals(other.getInterestDifFlag()))
			return false;
		if (subFlag == null && other.getSubFlag() != null)
			return false;
		if (subFlag != null && !subFlag.equals(other.getSubFlag()))
			return false;
		if (bnfFlag == null && other.getBnfFlag() != null)
			return false;
		if (bnfFlag != null && !bnfFlag.equals(other.getBnfFlag()))
			return false;
		if (healthCheckFlag == null && other.getHealthCheckFlag() != null)
			return false;
		if (healthCheckFlag != null && !healthCheckFlag.equals(other.getHealthCheckFlag()))
			return false;
		if (impartFlag == null && other.getImpartFlag() != null)
			return false;
		if (impartFlag != null && !impartFlag.equals(other.getImpartFlag()))
			return false;
		if (reinsureFlag == null && other.getReinsureFlag() != null)
			return false;
		if (reinsureFlag != null && !reinsureFlag.equals(other.getReinsureFlag()))
			return false;
		if (agentPayFlag == null && other.getAgentPayFlag() != null)
			return false;
		if (agentPayFlag != null && !agentPayFlag.equals(other.getAgentPayFlag()))
			return false;
		if (agentGetFlag == null && other.getAgentGetFlag() != null)
			return false;
		if (agentGetFlag != null && !agentGetFlag.equals(other.getAgentGetFlag()))
			return false;
		if (liveGetMode == null && other.getLiveGetMode() != null)
			return false;
		if (liveGetMode != null && !liveGetMode.equals(other.getLiveGetMode()))
			return false;
		if (deadGetMode == null && other.getDeadGetMode() != null)
			return false;
		if (deadGetMode != null && !deadGetMode.equals(other.getDeadGetMode()))
			return false;
		if (bonusGetMode == null && other.getBonusGetMode() != null)
			return false;
		if (bonusGetMode != null && !bonusGetMode.equals(other.getBonusGetMode()))
			return false;
		if (deadAmntType == null && other.getDeadAmntType() != null)
			return false;
		if (deadAmntType != null && !deadAmntType.equals(other.getDeadAmntType()))
			return false;
		if (Double.doubleToLongBits(topUpPrem) != Double.doubleToLongBits(other.getTopUpPrem()))
			return false;
		if (bonusMan == null && other.getBonusMan() != null)
			return false;
		if (bonusMan != null && !bonusMan.equals(other.getBonusMan()))
			return false;
		if (deadFlag == null && other.getDeadFlag() != null)
			return false;
		if (deadFlag != null && !deadFlag.equals(other.getDeadFlag()))
			return false;
		if (smokeFlag == null && other.getSmokeFlag() != null)
			return false;
		if (smokeFlag != null && !smokeFlag.equals(other.getSmokeFlag()))
			return false;
		if (remark == null && other.getRemark() != null)
			return false;
		if (remark != null && !remark.equals(other.getRemark()))
			return false;
		if (approveFlag == null && other.getApproveFlag() != null)
			return false;
		if (approveFlag != null && !approveFlag.equals(other.getApproveFlag()))
			return false;
		if (approveCode == null && other.getApproveCode() != null)
			return false;
		if (approveCode != null && !approveCode.equals(other.getApproveCode()))
			return false;
		if (approveDate == null && other.getApproveDate() != null)
			return false;
		if (approveDate != null && !fDate.getString(approveDate).equals(other.getApproveDate()))
			return false;
		if (approveTime == null && other.getApproveTime() != null)
			return false;
		if (approveTime != null && !approveTime.equals(other.getApproveTime()))
			return false;
		if (uWFlag == null && other.getUWFlag() != null)
			return false;
		if (uWFlag != null && !uWFlag.equals(other.getUWFlag()))
			return false;
		if (uWCode == null && other.getUWCode() != null)
			return false;
		if (uWCode != null && !uWCode.equals(other.getUWCode()))
			return false;
		if (uWDate == null && other.getUWDate() != null)
			return false;
		if (uWDate != null && !fDate.getString(uWDate).equals(other.getUWDate()))
			return false;
		if (uWTime == null && other.getUWTime() != null)
			return false;
		if (uWTime != null && !uWTime.equals(other.getUWTime()))
			return false;
		if (polApplyDate == null && other.getPolApplyDate() != null)
			return false;
		if (polApplyDate != null && !fDate.getString(polApplyDate).equals(other.getPolApplyDate()))
			return false;
		if (appFlag == null && other.getAppFlag() != null)
			return false;
		if (appFlag != null && !appFlag.equals(other.getAppFlag()))
			return false;
		if (saleChnlDetail == null && other.getSaleChnlDetail() != null)
			return false;
		if (saleChnlDetail != null && !saleChnlDetail.equals(other.getSaleChnlDetail()))
			return false;
		if (polState == null && other.getPolState() != null)
			return false;
		if (polState != null && !polState.equals(other.getPolState()))
			return false;
		if (standbyFlag1 == null && other.getStandbyFlag1() != null)
			return false;
		if (standbyFlag1 != null && !standbyFlag1.equals(other.getStandbyFlag1()))
			return false;
		if (standbyFlag2 == null && other.getStandbyFlag2() != null)
			return false;
		if (standbyFlag2 != null && !standbyFlag2.equals(other.getStandbyFlag2()))
			return false;
		if (standbyFlag3 == null && other.getStandbyFlag3() != null)
			return false;
		if (standbyFlag3 != null && !standbyFlag3.equals(other.getStandbyFlag3()))
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (makeDate == null && other.getMakeDate() != null)
			return false;
		if (makeDate != null && !fDate.getString(makeDate).equals(other.getMakeDate()))
			return false;
		if (makeTime == null && other.getMakeTime() != null)
			return false;
		if (makeTime != null && !makeTime.equals(other.getMakeTime()))
			return false;
		if (modifyDate == null && other.getModifyDate() != null)
			return false;
		if (modifyDate != null && !fDate.getString(modifyDate).equals(other.getModifyDate()))
			return false;
		if (modifyTime == null && other.getModifyTime() != null)
			return false;
		return modifyTime == null || modifyTime.equals(other.getModifyTime());
	}

	public int getFieldCount()
	{
		return 119;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("grpPolNo"))
			return 1;
		if (strFieldName.equals("contNo"))
			return 2;
		if (strFieldName.equals("proposalContNo"))
			return 3;
		if (strFieldName.equals("polNo"))
			return 4;
		if (strFieldName.equals("proposalNo"))
			return 5;
		if (strFieldName.equals("prtNo"))
			return 6;
		if (strFieldName.equals("contType"))
			return 7;
		if (strFieldName.equals("polTypeFlag"))
			return 8;
		if (strFieldName.equals("mainPolNo"))
			return 9;
		if (strFieldName.equals("masterPolNo"))
			return 10;
		if (strFieldName.equals("kindCode"))
			return 11;
		if (strFieldName.equals("riskCode"))
			return 12;
		if (strFieldName.equals("riskVersion"))
			return 13;
		if (strFieldName.equals("manageCom"))
			return 14;
		if (strFieldName.equals("agentCom"))
			return 15;
		if (strFieldName.equals("agentType"))
			return 16;
		if (strFieldName.equals("agentCode"))
			return 17;
		if (strFieldName.equals("agentGroup"))
			return 18;
		if (strFieldName.equals("agentGroup1"))
			return 19;
		if (strFieldName.equals("agentCode1"))
			return 20;
		if (strFieldName.equals("saleChnl"))
			return 21;
		if (strFieldName.equals("handler"))
			return 22;
		if (strFieldName.equals("insuredNo"))
			return 23;
		if (strFieldName.equals("insuredId"))
			return 24;
		if (strFieldName.equals("insuredName"))
			return 25;
		if (strFieldName.equals("insuredSex"))
			return 26;
		if (strFieldName.equals("insuredBirthday"))
			return 27;
		if (strFieldName.equals("insuredAppAge"))
			return 28;
		if (strFieldName.equals("insuredPeoples"))
			return 29;
		if (strFieldName.equals("occupationType"))
			return 30;
		if (strFieldName.equals("appntNo"))
			return 31;
		if (strFieldName.equals("appntName"))
			return 32;
		if (strFieldName.equals("cValiDate"))
			return 33;
		if (strFieldName.equals("signCom"))
			return 34;
		if (strFieldName.equals("signDate"))
			return 35;
		if (strFieldName.equals("signTime"))
			return 36;
		if (strFieldName.equals("firstPayDate"))
			return 37;
		if (strFieldName.equals("payEndDate"))
			return 38;
		if (strFieldName.equals("paytoDate"))
			return 39;
		if (strFieldName.equals("getStartDate"))
			return 40;
		if (strFieldName.equals("endDate"))
			return 41;
		if (strFieldName.equals("acciEndDate"))
			return 42;
		if (strFieldName.equals("getYearFlag"))
			return 43;
		if (strFieldName.equals("getYear"))
			return 44;
		if (strFieldName.equals("payEndYearFlag"))
			return 45;
		if (strFieldName.equals("payEndYear"))
			return 46;
		if (strFieldName.equals("insuYearFlag"))
			return 47;
		if (strFieldName.equals("insuYear"))
			return 48;
		if (strFieldName.equals("acciYearFlag"))
			return 49;
		if (strFieldName.equals("acciYear"))
			return 50;
		if (strFieldName.equals("getStartType"))
			return 51;
		if (strFieldName.equals("specifyValiDate"))
			return 52;
		if (strFieldName.equals("payMode"))
			return 53;
		if (strFieldName.equals("payLocation"))
			return 54;
		if (strFieldName.equals("payIntv"))
			return 55;
		if (strFieldName.equals("payYears"))
			return 56;
		if (strFieldName.equals("years"))
			return 57;
		if (strFieldName.equals("manageFeeRate"))
			return 58;
		if (strFieldName.equals("floatRate"))
			return 59;
		if (strFieldName.equals("premRate"))
			return 60;
		if (strFieldName.equals("premToAmnt"))
			return 61;
		if (strFieldName.equals("mult"))
			return 62;
		if (strFieldName.equals("standPrem"))
			return 63;
		if (strFieldName.equals("prem"))
			return 64;
		if (strFieldName.equals("sumPrem"))
			return 65;
		if (strFieldName.equals("amnt"))
			return 66;
		if (strFieldName.equals("riskAmnt"))
			return 67;
		if (strFieldName.equals("leavingMoney"))
			return 68;
		if (strFieldName.equals("endorseTimes"))
			return 69;
		if (strFieldName.equals("claimTimes"))
			return 70;
		if (strFieldName.equals("liveTimes"))
			return 71;
		if (strFieldName.equals("renewCount"))
			return 72;
		if (strFieldName.equals("lastGetDate"))
			return 73;
		if (strFieldName.equals("lastLoanDate"))
			return 74;
		if (strFieldName.equals("lastRegetDate"))
			return 75;
		if (strFieldName.equals("lastEdorDate"))
			return 76;
		if (strFieldName.equals("lastRevDate"))
			return 77;
		if (strFieldName.equals("rnewFlag"))
			return 78;
		if (strFieldName.equals("stopFlag"))
			return 79;
		if (strFieldName.equals("expiryFlag"))
			return 80;
		if (strFieldName.equals("autoPayFlag"))
			return 81;
		if (strFieldName.equals("interestDifFlag"))
			return 82;
		if (strFieldName.equals("subFlag"))
			return 83;
		if (strFieldName.equals("bnfFlag"))
			return 84;
		if (strFieldName.equals("healthCheckFlag"))
			return 85;
		if (strFieldName.equals("impartFlag"))
			return 86;
		if (strFieldName.equals("reinsureFlag"))
			return 87;
		if (strFieldName.equals("agentPayFlag"))
			return 88;
		if (strFieldName.equals("agentGetFlag"))
			return 89;
		if (strFieldName.equals("liveGetMode"))
			return 90;
		if (strFieldName.equals("deadGetMode"))
			return 91;
		if (strFieldName.equals("bonusGetMode"))
			return 92;
		if (strFieldName.equals("deadAmntType"))
			return 93;
		if (strFieldName.equals("topUpPrem"))
			return 94;
		if (strFieldName.equals("bonusMan"))
			return 95;
		if (strFieldName.equals("deadFlag"))
			return 96;
		if (strFieldName.equals("smokeFlag"))
			return 97;
		if (strFieldName.equals("remark"))
			return 98;
		if (strFieldName.equals("approveFlag"))
			return 99;
		if (strFieldName.equals("approveCode"))
			return 100;
		if (strFieldName.equals("approveDate"))
			return 101;
		if (strFieldName.equals("approveTime"))
			return 102;
		if (strFieldName.equals("uWFlag"))
			return 103;
		if (strFieldName.equals("uWCode"))
			return 104;
		if (strFieldName.equals("uWDate"))
			return 105;
		if (strFieldName.equals("uWTime"))
			return 106;
		if (strFieldName.equals("polApplyDate"))
			return 107;
		if (strFieldName.equals("appFlag"))
			return 108;
		if (strFieldName.equals("saleChnlDetail"))
			return 109;
		if (strFieldName.equals("polState"))
			return 110;
		if (strFieldName.equals("standbyFlag1"))
			return 111;
		if (strFieldName.equals("standbyFlag2"))
			return 112;
		if (strFieldName.equals("standbyFlag3"))
			return 113;
		if (strFieldName.equals("operator"))
			return 114;
		if (strFieldName.equals("makeDate"))
			return 115;
		if (strFieldName.equals("makeTime"))
			return 116;
		if (strFieldName.equals("modifyDate"))
			return 117;
		return !strFieldName.equals("modifyTime") ? -1 : 118;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "grpContNo";
			break;

		case 1: // '\001'
			strFieldName = "grpPolNo";
			break;

		case 2: // '\002'
			strFieldName = "contNo";
			break;

		case 3: // '\003'
			strFieldName = "proposalContNo";
			break;

		case 4: // '\004'
			strFieldName = "polNo";
			break;

		case 5: // '\005'
			strFieldName = "proposalNo";
			break;

		case 6: // '\006'
			strFieldName = "prtNo";
			break;

		case 7: // '\007'
			strFieldName = "contType";
			break;

		case 8: // '\b'
			strFieldName = "polTypeFlag";
			break;

		case 9: // '\t'
			strFieldName = "mainPolNo";
			break;

		case 10: // '\n'
			strFieldName = "masterPolNo";
			break;

		case 11: // '\013'
			strFieldName = "kindCode";
			break;

		case 12: // '\f'
			strFieldName = "riskCode";
			break;

		case 13: // '\r'
			strFieldName = "riskVersion";
			break;

		case 14: // '\016'
			strFieldName = "manageCom";
			break;

		case 15: // '\017'
			strFieldName = "agentCom";
			break;

		case 16: // '\020'
			strFieldName = "agentType";
			break;

		case 17: // '\021'
			strFieldName = "agentCode";
			break;

		case 18: // '\022'
			strFieldName = "agentGroup";
			break;

		case 19: // '\023'
			strFieldName = "agentGroup1";
			break;

		case 20: // '\024'
			strFieldName = "agentCode1";
			break;

		case 21: // '\025'
			strFieldName = "saleChnl";
			break;

		case 22: // '\026'
			strFieldName = "handler";
			break;

		case 23: // '\027'
			strFieldName = "insuredNo";
			break;

		case 24: // '\030'
			strFieldName = "insuredId";
			break;

		case 25: // '\031'
			strFieldName = "insuredName";
			break;

		case 26: // '\032'
			strFieldName = "insuredSex";
			break;

		case 27: // '\033'
			strFieldName = "insuredBirthday";
			break;

		case 28: // '\034'
			strFieldName = "insuredAppAge";
			break;

		case 29: // '\035'
			strFieldName = "insuredPeoples";
			break;

		case 30: // '\036'
			strFieldName = "occupationType";
			break;

		case 31: // '\037'
			strFieldName = "appntNo";
			break;

		case 32: // ' '
			strFieldName = "appntName";
			break;

		case 33: // '!'
			strFieldName = "cValiDate";
			break;

		case 34: // '"'
			strFieldName = "signCom";
			break;

		case 35: // '#'
			strFieldName = "signDate";
			break;

		case 36: // '$'
			strFieldName = "signTime";
			break;

		case 37: // '%'
			strFieldName = "firstPayDate";
			break;

		case 38: // '&'
			strFieldName = "payEndDate";
			break;

		case 39: // '\''
			strFieldName = "paytoDate";
			break;

		case 40: // '('
			strFieldName = "getStartDate";
			break;

		case 41: // ')'
			strFieldName = "endDate";
			break;

		case 42: // '*'
			strFieldName = "acciEndDate";
			break;

		case 43: // '+'
			strFieldName = "getYearFlag";
			break;

		case 44: // ','
			strFieldName = "getYear";
			break;

		case 45: // '-'
			strFieldName = "payEndYearFlag";
			break;

		case 46: // '.'
			strFieldName = "payEndYear";
			break;

		case 47: // '/'
			strFieldName = "insuYearFlag";
			break;

		case 48: // '0'
			strFieldName = "insuYear";
			break;

		case 49: // '1'
			strFieldName = "acciYearFlag";
			break;

		case 50: // '2'
			strFieldName = "acciYear";
			break;

		case 51: // '3'
			strFieldName = "getStartType";
			break;

		case 52: // '4'
			strFieldName = "specifyValiDate";
			break;

		case 53: // '5'
			strFieldName = "payMode";
			break;

		case 54: // '6'
			strFieldName = "payLocation";
			break;

		case 55: // '7'
			strFieldName = "payIntv";
			break;

		case 56: // '8'
			strFieldName = "payYears";
			break;

		case 57: // '9'
			strFieldName = "years";
			break;

		case 58: // ':'
			strFieldName = "manageFeeRate";
			break;

		case 59: // ';'
			strFieldName = "floatRate";
			break;

		case 60: // '<'
			strFieldName = "premRate";
			break;

		case 61: // '='
			strFieldName = "premToAmnt";
			break;

		case 62: // '>'
			strFieldName = "mult";
			break;

		case 63: // '?'
			strFieldName = "standPrem";
			break;

		case 64: // '@'
			strFieldName = "prem";
			break;

		case 65: // 'A'
			strFieldName = "sumPrem";
			break;

		case 66: // 'B'
			strFieldName = "amnt";
			break;

		case 67: // 'C'
			strFieldName = "riskAmnt";
			break;

		case 68: // 'D'
			strFieldName = "leavingMoney";
			break;

		case 69: // 'E'
			strFieldName = "endorseTimes";
			break;

		case 70: // 'F'
			strFieldName = "claimTimes";
			break;

		case 71: // 'G'
			strFieldName = "liveTimes";
			break;

		case 72: // 'H'
			strFieldName = "renewCount";
			break;

		case 73: // 'I'
			strFieldName = "lastGetDate";
			break;

		case 74: // 'J'
			strFieldName = "lastLoanDate";
			break;

		case 75: // 'K'
			strFieldName = "lastRegetDate";
			break;

		case 76: // 'L'
			strFieldName = "lastEdorDate";
			break;

		case 77: // 'M'
			strFieldName = "lastRevDate";
			break;

		case 78: // 'N'
			strFieldName = "rnewFlag";
			break;

		case 79: // 'O'
			strFieldName = "stopFlag";
			break;

		case 80: // 'P'
			strFieldName = "expiryFlag";
			break;

		case 81: // 'Q'
			strFieldName = "autoPayFlag";
			break;

		case 82: // 'R'
			strFieldName = "interestDifFlag";
			break;

		case 83: // 'S'
			strFieldName = "subFlag";
			break;

		case 84: // 'T'
			strFieldName = "bnfFlag";
			break;

		case 85: // 'U'
			strFieldName = "healthCheckFlag";
			break;

		case 86: // 'V'
			strFieldName = "impartFlag";
			break;

		case 87: // 'W'
			strFieldName = "reinsureFlag";
			break;

		case 88: // 'X'
			strFieldName = "agentPayFlag";
			break;

		case 89: // 'Y'
			strFieldName = "agentGetFlag";
			break;

		case 90: // 'Z'
			strFieldName = "liveGetMode";
			break;

		case 91: // '['
			strFieldName = "deadGetMode";
			break;

		case 92: // '\\'
			strFieldName = "bonusGetMode";
			break;

		case 93: // ']'
			strFieldName = "deadAmntType";
			break;

		case 94: // '^'
			strFieldName = "topUpPrem";
			break;

		case 95: // '_'
			strFieldName = "bonusMan";
			break;

		case 96: // '`'
			strFieldName = "deadFlag";
			break;

		case 97: // 'a'
			strFieldName = "smokeFlag";
			break;

		case 98: // 'b'
			strFieldName = "remark";
			break;

		case 99: // 'c'
			strFieldName = "approveFlag";
			break;

		case 100: // 'd'
			strFieldName = "approveCode";
			break;

		case 101: // 'e'
			strFieldName = "approveDate";
			break;

		case 102: // 'f'
			strFieldName = "approveTime";
			break;

		case 103: // 'g'
			strFieldName = "uWFlag";
			break;

		case 104: // 'h'
			strFieldName = "uWCode";
			break;

		case 105: // 'i'
			strFieldName = "uWDate";
			break;

		case 106: // 'j'
			strFieldName = "uWTime";
			break;

		case 107: // 'k'
			strFieldName = "polApplyDate";
			break;

		case 108: // 'l'
			strFieldName = "appFlag";
			break;

		case 109: // 'm'
			strFieldName = "saleChnlDetail";
			break;

		case 110: // 'n'
			strFieldName = "polState";
			break;

		case 111: // 'o'
			strFieldName = "standbyFlag1";
			break;

		case 112: // 'p'
			strFieldName = "standbyFlag2";
			break;

		case 113: // 'q'
			strFieldName = "standbyFlag3";
			break;

		case 114: // 'r'
			strFieldName = "operator";
			break;

		case 115: // 's'
			strFieldName = "makeDate";
			break;

		case 116: // 't'
			strFieldName = "makeTime";
			break;

		case 117: // 'u'
			strFieldName = "modifyDate";
			break;

		case 118: // 'v'
			strFieldName = "modifyTime";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("grpPolNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("proposalContNo"))
			return 0;
		if (strFieldName.equals("polNo"))
			return 0;
		if (strFieldName.equals("proposalNo"))
			return 0;
		if (strFieldName.equals("prtNo"))
			return 0;
		if (strFieldName.equals("contType"))
			return 0;
		if (strFieldName.equals("polTypeFlag"))
			return 0;
		if (strFieldName.equals("mainPolNo"))
			return 0;
		if (strFieldName.equals("masterPolNo"))
			return 0;
		if (strFieldName.equals("kindCode"))
			return 0;
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVersion"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("agentCom"))
			return 0;
		if (strFieldName.equals("agentType"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("agentGroup"))
			return 0;
		if (strFieldName.equals("agentGroup1"))
			return 0;
		if (strFieldName.equals("agentCode1"))
			return 0;
		if (strFieldName.equals("saleChnl"))
			return 0;
		if (strFieldName.equals("handler"))
			return 0;
		if (strFieldName.equals("insuredNo"))
			return 0;
		if (strFieldName.equals("insuredId"))
			return 0;
		if (strFieldName.equals("insuredName"))
			return 0;
		if (strFieldName.equals("insuredSex"))
			return 0;
		if (strFieldName.equals("insuredBirthday"))
			return 1;
		if (strFieldName.equals("insuredAppAge"))
			return 3;
		if (strFieldName.equals("insuredPeoples"))
			return 3;
		if (strFieldName.equals("occupationType"))
			return 0;
		if (strFieldName.equals("appntNo"))
			return 0;
		if (strFieldName.equals("appntName"))
			return 0;
		if (strFieldName.equals("cValiDate"))
			return 1;
		if (strFieldName.equals("signCom"))
			return 0;
		if (strFieldName.equals("signDate"))
			return 1;
		if (strFieldName.equals("signTime"))
			return 0;
		if (strFieldName.equals("firstPayDate"))
			return 1;
		if (strFieldName.equals("payEndDate"))
			return 1;
		if (strFieldName.equals("paytoDate"))
			return 1;
		if (strFieldName.equals("getStartDate"))
			return 1;
		if (strFieldName.equals("endDate"))
			return 1;
		if (strFieldName.equals("acciEndDate"))
			return 1;
		if (strFieldName.equals("getYearFlag"))
			return 0;
		if (strFieldName.equals("getYear"))
			return 3;
		if (strFieldName.equals("payEndYearFlag"))
			return 0;
		if (strFieldName.equals("payEndYear"))
			return 3;
		if (strFieldName.equals("insuYearFlag"))
			return 0;
		if (strFieldName.equals("insuYear"))
			return 3;
		if (strFieldName.equals("acciYearFlag"))
			return 0;
		if (strFieldName.equals("acciYear"))
			return 3;
		if (strFieldName.equals("getStartType"))
			return 0;
		if (strFieldName.equals("specifyValiDate"))
			return 0;
		if (strFieldName.equals("payMode"))
			return 0;
		if (strFieldName.equals("payLocation"))
			return 0;
		if (strFieldName.equals("payIntv"))
			return 3;
		if (strFieldName.equals("payYears"))
			return 3;
		if (strFieldName.equals("years"))
			return 3;
		if (strFieldName.equals("manageFeeRate"))
			return 4;
		if (strFieldName.equals("floatRate"))
			return 4;
		if (strFieldName.equals("premRate"))
			return 4;
		if (strFieldName.equals("premToAmnt"))
			return 0;
		if (strFieldName.equals("mult"))
			return 4;
		if (strFieldName.equals("standPrem"))
			return 4;
		if (strFieldName.equals("prem"))
			return 4;
		if (strFieldName.equals("sumPrem"))
			return 4;
		if (strFieldName.equals("amnt"))
			return 4;
		if (strFieldName.equals("riskAmnt"))
			return 4;
		if (strFieldName.equals("leavingMoney"))
			return 4;
		if (strFieldName.equals("endorseTimes"))
			return 3;
		if (strFieldName.equals("claimTimes"))
			return 3;
		if (strFieldName.equals("liveTimes"))
			return 3;
		if (strFieldName.equals("renewCount"))
			return 3;
		if (strFieldName.equals("lastGetDate"))
			return 1;
		if (strFieldName.equals("lastLoanDate"))
			return 1;
		if (strFieldName.equals("lastRegetDate"))
			return 1;
		if (strFieldName.equals("lastEdorDate"))
			return 1;
		if (strFieldName.equals("lastRevDate"))
			return 1;
		if (strFieldName.equals("rnewFlag"))
			return 0;
		if (strFieldName.equals("stopFlag"))
			return 0;
		if (strFieldName.equals("expiryFlag"))
			return 0;
		if (strFieldName.equals("autoPayFlag"))
			return 0;
		if (strFieldName.equals("interestDifFlag"))
			return 0;
		if (strFieldName.equals("subFlag"))
			return 0;
		if (strFieldName.equals("bnfFlag"))
			return 0;
		if (strFieldName.equals("healthCheckFlag"))
			return 0;
		if (strFieldName.equals("impartFlag"))
			return 0;
		if (strFieldName.equals("reinsureFlag"))
			return 0;
		if (strFieldName.equals("agentPayFlag"))
			return 0;
		if (strFieldName.equals("agentGetFlag"))
			return 0;
		if (strFieldName.equals("liveGetMode"))
			return 0;
		if (strFieldName.equals("deadGetMode"))
			return 0;
		if (strFieldName.equals("bonusGetMode"))
			return 0;
		if (strFieldName.equals("deadAmntType"))
			return 0;
		if (strFieldName.equals("topUpPrem"))
			return 4;
		if (strFieldName.equals("bonusMan"))
			return 0;
		if (strFieldName.equals("deadFlag"))
			return 0;
		if (strFieldName.equals("smokeFlag"))
			return 0;
		if (strFieldName.equals("remark"))
			return 0;
		if (strFieldName.equals("approveFlag"))
			return 0;
		if (strFieldName.equals("approveCode"))
			return 0;
		if (strFieldName.equals("approveDate"))
			return 1;
		if (strFieldName.equals("approveTime"))
			return 0;
		if (strFieldName.equals("uWFlag"))
			return 0;
		if (strFieldName.equals("uWCode"))
			return 0;
		if (strFieldName.equals("uWDate"))
			return 1;
		if (strFieldName.equals("uWTime"))
			return 0;
		if (strFieldName.equals("polApplyDate"))
			return 1;
		if (strFieldName.equals("appFlag"))
			return 0;
		if (strFieldName.equals("saleChnlDetail"))
			return 0;
		if (strFieldName.equals("polState"))
			return 0;
		if (strFieldName.equals("standbyFlag1"))
			return 0;
		if (strFieldName.equals("standbyFlag2"))
			return 0;
		if (strFieldName.equals("standbyFlag3"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		return !strFieldName.equals("modifyTime") ? -1 : 0;
	}

	public int getFieldType(int nFieldIndex)
	{
		int nFieldType = -1;
		switch (nFieldIndex)
		{
		case 0: // '\0'
			nFieldType = 0;
			break;

		case 1: // '\001'
			nFieldType = 0;
			break;

		case 2: // '\002'
			nFieldType = 0;
			break;

		case 3: // '\003'
			nFieldType = 0;
			break;

		case 4: // '\004'
			nFieldType = 0;
			break;

		case 5: // '\005'
			nFieldType = 0;
			break;

		case 6: // '\006'
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 0;
			break;

		case 9: // '\t'
			nFieldType = 0;
			break;

		case 10: // '\n'
			nFieldType = 0;
			break;

		case 11: // '\013'
			nFieldType = 0;
			break;

		case 12: // '\f'
			nFieldType = 0;
			break;

		case 13: // '\r'
			nFieldType = 0;
			break;

		case 14: // '\016'
			nFieldType = 0;
			break;

		case 15: // '\017'
			nFieldType = 0;
			break;

		case 16: // '\020'
			nFieldType = 0;
			break;

		case 17: // '\021'
			nFieldType = 0;
			break;

		case 18: // '\022'
			nFieldType = 0;
			break;

		case 19: // '\023'
			nFieldType = 0;
			break;

		case 20: // '\024'
			nFieldType = 0;
			break;

		case 21: // '\025'
			nFieldType = 0;
			break;

		case 22: // '\026'
			nFieldType = 0;
			break;

		case 23: // '\027'
			nFieldType = 0;
			break;

		case 24: // '\030'
			nFieldType = 0;
			break;

		case 25: // '\031'
			nFieldType = 0;
			break;

		case 26: // '\032'
			nFieldType = 0;
			break;

		case 27: // '\033'
			nFieldType = 1;
			break;

		case 28: // '\034'
			nFieldType = 3;
			break;

		case 29: // '\035'
			nFieldType = 3;
			break;

		case 30: // '\036'
			nFieldType = 0;
			break;

		case 31: // '\037'
			nFieldType = 0;
			break;

		case 32: // ' '
			nFieldType = 0;
			break;

		case 33: // '!'
			nFieldType = 1;
			break;

		case 34: // '"'
			nFieldType = 0;
			break;

		case 35: // '#'
			nFieldType = 1;
			break;

		case 36: // '$'
			nFieldType = 0;
			break;

		case 37: // '%'
			nFieldType = 1;
			break;

		case 38: // '&'
			nFieldType = 1;
			break;

		case 39: // '\''
			nFieldType = 1;
			break;

		case 40: // '('
			nFieldType = 1;
			break;

		case 41: // ')'
			nFieldType = 1;
			break;

		case 42: // '*'
			nFieldType = 1;
			break;

		case 43: // '+'
			nFieldType = 0;
			break;

		case 44: // ','
			nFieldType = 3;
			break;

		case 45: // '-'
			nFieldType = 0;
			break;

		case 46: // '.'
			nFieldType = 3;
			break;

		case 47: // '/'
			nFieldType = 0;
			break;

		case 48: // '0'
			nFieldType = 3;
			break;

		case 49: // '1'
			nFieldType = 0;
			break;

		case 50: // '2'
			nFieldType = 3;
			break;

		case 51: // '3'
			nFieldType = 0;
			break;

		case 52: // '4'
			nFieldType = 0;
			break;

		case 53: // '5'
			nFieldType = 0;
			break;

		case 54: // '6'
			nFieldType = 0;
			break;

		case 55: // '7'
			nFieldType = 3;
			break;

		case 56: // '8'
			nFieldType = 3;
			break;

		case 57: // '9'
			nFieldType = 3;
			break;

		case 58: // ':'
			nFieldType = 4;
			break;

		case 59: // ';'
			nFieldType = 4;
			break;

		case 60: // '<'
			nFieldType = 4;
			break;

		case 61: // '='
			nFieldType = 0;
			break;

		case 62: // '>'
			nFieldType = 4;
			break;

		case 63: // '?'
			nFieldType = 4;
			break;

		case 64: // '@'
			nFieldType = 4;
			break;

		case 65: // 'A'
			nFieldType = 4;
			break;

		case 66: // 'B'
			nFieldType = 4;
			break;

		case 67: // 'C'
			nFieldType = 4;
			break;

		case 68: // 'D'
			nFieldType = 4;
			break;

		case 69: // 'E'
			nFieldType = 3;
			break;

		case 70: // 'F'
			nFieldType = 3;
			break;

		case 71: // 'G'
			nFieldType = 3;
			break;

		case 72: // 'H'
			nFieldType = 3;
			break;

		case 73: // 'I'
			nFieldType = 1;
			break;

		case 74: // 'J'
			nFieldType = 1;
			break;

		case 75: // 'K'
			nFieldType = 1;
			break;

		case 76: // 'L'
			nFieldType = 1;
			break;

		case 77: // 'M'
			nFieldType = 1;
			break;

		case 78: // 'N'
			nFieldType = 0;
			break;

		case 79: // 'O'
			nFieldType = 0;
			break;

		case 80: // 'P'
			nFieldType = 0;
			break;

		case 81: // 'Q'
			nFieldType = 0;
			break;

		case 82: // 'R'
			nFieldType = 0;
			break;

		case 83: // 'S'
			nFieldType = 0;
			break;

		case 84: // 'T'
			nFieldType = 0;
			break;

		case 85: // 'U'
			nFieldType = 0;
			break;

		case 86: // 'V'
			nFieldType = 0;
			break;

		case 87: // 'W'
			nFieldType = 0;
			break;

		case 88: // 'X'
			nFieldType = 0;
			break;

		case 89: // 'Y'
			nFieldType = 0;
			break;

		case 90: // 'Z'
			nFieldType = 0;
			break;

		case 91: // '['
			nFieldType = 0;
			break;

		case 92: // '\\'
			nFieldType = 0;
			break;

		case 93: // ']'
			nFieldType = 0;
			break;

		case 94: // '^'
			nFieldType = 4;
			break;

		case 95: // '_'
			nFieldType = 0;
			break;

		case 96: // '`'
			nFieldType = 0;
			break;

		case 97: // 'a'
			nFieldType = 0;
			break;

		case 98: // 'b'
			nFieldType = 0;
			break;

		case 99: // 'c'
			nFieldType = 0;
			break;

		case 100: // 'd'
			nFieldType = 0;
			break;

		case 101: // 'e'
			nFieldType = 1;
			break;

		case 102: // 'f'
			nFieldType = 0;
			break;

		case 103: // 'g'
			nFieldType = 0;
			break;

		case 104: // 'h'
			nFieldType = 0;
			break;

		case 105: // 'i'
			nFieldType = 1;
			break;

		case 106: // 'j'
			nFieldType = 0;
			break;

		case 107: // 'k'
			nFieldType = 1;
			break;

		case 108: // 'l'
			nFieldType = 0;
			break;

		case 109: // 'm'
			nFieldType = 0;
			break;

		case 110: // 'n'
			nFieldType = 0;
			break;

		case 111: // 'o'
			nFieldType = 0;
			break;

		case 112: // 'p'
			nFieldType = 0;
			break;

		case 113: // 'q'
			nFieldType = 0;
			break;

		case 114: // 'r'
			nFieldType = 0;
			break;

		case 115: // 's'
			nFieldType = 1;
			break;

		case 116: // 't'
			nFieldType = 0;
			break;

		case 117: // 'u'
			nFieldType = 1;
			break;

		case 118: // 'v'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
