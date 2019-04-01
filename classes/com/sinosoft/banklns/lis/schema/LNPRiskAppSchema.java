// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskAppSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskAppDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPRiskAppSchema
	implements Schema, Cloneable
{

	private String riskCode;
	private String riskVer;
	private String riskName;
	private String kindCode;
	private String riskType;
	private String riskType1;
	private String riskType2;
	private String riskProp;
	private String riskPeriod;
	private String riskTypeDetail;
	private String riskFlag;
	private String polType;
	private String investFlag;
	private String bonusFlag;
	private String bonusMode;
	private String listFlag;
	private String subRiskFlag;
	private int calDigital;
	private String calChoMode;
	private int riskAmntMult;
	private String insuPeriodFlag;
	private int maxEndPeriod;
	private int ageLmt;
	private int signDateCalMode;
	private String protocolFlag;
	private String getChgFlag;
	private String protocolPayFlag;
	private String ensuPlanFlag;
	private String ensuPlanAdjFlag;
	private Date startDate;
	private Date endDate;
	private int minAppntAge;
	private int maxAppntAge;
	private int maxInsuredAge;
	private int minInsuredAge;
	private double appInterest;
	private double appPremRate;
	private String insuredFlag;
	private String shareFlag;
	private String bnfFlag;
	private String tempPayFlag;
	private String inpPayPlan;
	private String impartFlag;
	private String insuExpeFlag;
	private String loanFalg;
	private String mortagageFlag;
	private String iDifReturnFlag;
	private String cutAmntStopPay;
	private double rinsRate;
	private String saleFlag;
	private String fileAppFlag;
	private String mngCom;
	private String autoPayFlag;
	private String needPrintHospital;
	private String needPrintGet;
	private String riskType3;
	private String riskType4;
	private String riskType5;
	private String notPrintPol;
	private String needGetPolDate;
	private String needReReadBank;
	private String specFlag;
	private String interestDifFlag;
	public static final int FIELDNUM = 63;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPRiskAppSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "RiskCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskAppSchema cloned = (LNPRiskAppSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String aRiskCode)
	{
		riskCode = aRiskCode;
	}

	public String getRiskVer()
	{
		return riskVer;
	}

	public void setRiskVer(String aRiskVer)
	{
		riskVer = aRiskVer;
	}

	public String getRiskName()
	{
		return riskName;
	}

	public void setRiskName(String aRiskName)
	{
		riskName = aRiskName;
	}

	public String getKindCode()
	{
		return kindCode;
	}

	public void setKindCode(String aKindCode)
	{
		kindCode = aKindCode;
	}

	public String getRiskType()
	{
		return riskType;
	}

	public void setRiskType(String aRiskType)
	{
		riskType = aRiskType;
	}

	public String getRiskType1()
	{
		return riskType1;
	}

	public void setRiskType1(String aRiskType1)
	{
		riskType1 = aRiskType1;
	}

	public String getRiskType2()
	{
		return riskType2;
	}

	public void setRiskType2(String aRiskType2)
	{
		riskType2 = aRiskType2;
	}

	public String getRiskProp()
	{
		return riskProp;
	}

	public void setRiskProp(String aRiskProp)
	{
		riskProp = aRiskProp;
	}

	public String getRiskPeriod()
	{
		return riskPeriod;
	}

	public void setRiskPeriod(String aRiskPeriod)
	{
		riskPeriod = aRiskPeriod;
	}

	public String getRiskTypeDetail()
	{
		return riskTypeDetail;
	}

	public void setRiskTypeDetail(String aRiskTypeDetail)
	{
		riskTypeDetail = aRiskTypeDetail;
	}

	public String getRiskFlag()
	{
		return riskFlag;
	}

	public void setRiskFlag(String aRiskFlag)
	{
		riskFlag = aRiskFlag;
	}

	public String getPolType()
	{
		return polType;
	}

	public void setPolType(String aPolType)
	{
		polType = aPolType;
	}

	public String getInvestFlag()
	{
		return investFlag;
	}

	public void setInvestFlag(String aInvestFlag)
	{
		investFlag = aInvestFlag;
	}

	public String getBonusFlag()
	{
		return bonusFlag;
	}

	public void setBonusFlag(String aBonusFlag)
	{
		bonusFlag = aBonusFlag;
	}

	public String getBonusMode()
	{
		return bonusMode;
	}

	public void setBonusMode(String aBonusMode)
	{
		bonusMode = aBonusMode;
	}

	public String getListFlag()
	{
		return listFlag;
	}

	public void setListFlag(String aListFlag)
	{
		listFlag = aListFlag;
	}

	public String getSubRiskFlag()
	{
		return subRiskFlag;
	}

	public void setSubRiskFlag(String aSubRiskFlag)
	{
		subRiskFlag = aSubRiskFlag;
	}

	public int getCalDigital()
	{
		return calDigital;
	}

	public void setCalDigital(int aCalDigital)
	{
		calDigital = aCalDigital;
	}

	public void setCalDigital(String aCalDigital)
	{
		if (aCalDigital != null && !aCalDigital.equals(""))
		{
			Integer tInteger = new Integer(aCalDigital);
			int i = tInteger.intValue();
			calDigital = i;
		}
	}

	public String getCalChoMode()
	{
		return calChoMode;
	}

	public void setCalChoMode(String aCalChoMode)
	{
		calChoMode = aCalChoMode;
	}

	public int getRiskAmntMult()
	{
		return riskAmntMult;
	}

	public void setRiskAmntMult(int aRiskAmntMult)
	{
		riskAmntMult = aRiskAmntMult;
	}

	public void setRiskAmntMult(String aRiskAmntMult)
	{
		if (aRiskAmntMult != null && !aRiskAmntMult.equals(""))
		{
			Integer tInteger = new Integer(aRiskAmntMult);
			int i = tInteger.intValue();
			riskAmntMult = i;
		}
	}

	public String getInsuPeriodFlag()
	{
		return insuPeriodFlag;
	}

	public void setInsuPeriodFlag(String aInsuPeriodFlag)
	{
		insuPeriodFlag = aInsuPeriodFlag;
	}

	public int getMaxEndPeriod()
	{
		return maxEndPeriod;
	}

	public void setMaxEndPeriod(int aMaxEndPeriod)
	{
		maxEndPeriod = aMaxEndPeriod;
	}

	public void setMaxEndPeriod(String aMaxEndPeriod)
	{
		if (aMaxEndPeriod != null && !aMaxEndPeriod.equals(""))
		{
			Integer tInteger = new Integer(aMaxEndPeriod);
			int i = tInteger.intValue();
			maxEndPeriod = i;
		}
	}

	public int getAgeLmt()
	{
		return ageLmt;
	}

	public void setAgeLmt(int aAgeLmt)
	{
		ageLmt = aAgeLmt;
	}

	public void setAgeLmt(String aAgeLmt)
	{
		if (aAgeLmt != null && !aAgeLmt.equals(""))
		{
			Integer tInteger = new Integer(aAgeLmt);
			int i = tInteger.intValue();
			ageLmt = i;
		}
	}

	public int getSignDateCalMode()
	{
		return signDateCalMode;
	}

	public void setSignDateCalMode(int aSignDateCalMode)
	{
		signDateCalMode = aSignDateCalMode;
	}

	public void setSignDateCalMode(String aSignDateCalMode)
	{
		if (aSignDateCalMode != null && !aSignDateCalMode.equals(""))
		{
			Integer tInteger = new Integer(aSignDateCalMode);
			int i = tInteger.intValue();
			signDateCalMode = i;
		}
	}

	public String getProtocolFlag()
	{
		return protocolFlag;
	}

	public void setProtocolFlag(String aProtocolFlag)
	{
		protocolFlag = aProtocolFlag;
	}

	public String getGetChgFlag()
	{
		return getChgFlag;
	}

	public void setGetChgFlag(String aGetChgFlag)
	{
		getChgFlag = aGetChgFlag;
	}

	public String getProtocolPayFlag()
	{
		return protocolPayFlag;
	}

	public void setProtocolPayFlag(String aProtocolPayFlag)
	{
		protocolPayFlag = aProtocolPayFlag;
	}

	public String getEnsuPlanFlag()
	{
		return ensuPlanFlag;
	}

	public void setEnsuPlanFlag(String aEnsuPlanFlag)
	{
		ensuPlanFlag = aEnsuPlanFlag;
	}

	public String getEnsuPlanAdjFlag()
	{
		return ensuPlanAdjFlag;
	}

	public void setEnsuPlanAdjFlag(String aEnsuPlanAdjFlag)
	{
		ensuPlanAdjFlag = aEnsuPlanAdjFlag;
	}

	public String getStartDate()
	{
		if (startDate != null)
			return fDate.getString(startDate);
		else
			return null;
	}

	public void setStartDate(Date aStartDate)
	{
		startDate = aStartDate;
	}

	public void setStartDate(String aStartDate)
	{
		if (aStartDate != null && !aStartDate.equals(""))
			startDate = fDate.getDate(aStartDate);
		else
			startDate = null;
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

	public int getMinAppntAge()
	{
		return minAppntAge;
	}

	public void setMinAppntAge(int aMinAppntAge)
	{
		minAppntAge = aMinAppntAge;
	}

	public void setMinAppntAge(String aMinAppntAge)
	{
		if (aMinAppntAge != null && !aMinAppntAge.equals(""))
		{
			Integer tInteger = new Integer(aMinAppntAge);
			int i = tInteger.intValue();
			minAppntAge = i;
		}
	}

	public int getMaxAppntAge()
	{
		return maxAppntAge;
	}

	public void setMaxAppntAge(int aMaxAppntAge)
	{
		maxAppntAge = aMaxAppntAge;
	}

	public void setMaxAppntAge(String aMaxAppntAge)
	{
		if (aMaxAppntAge != null && !aMaxAppntAge.equals(""))
		{
			Integer tInteger = new Integer(aMaxAppntAge);
			int i = tInteger.intValue();
			maxAppntAge = i;
		}
	}

	public int getMaxInsuredAge()
	{
		return maxInsuredAge;
	}

	public void setMaxInsuredAge(int aMaxInsuredAge)
	{
		maxInsuredAge = aMaxInsuredAge;
	}

	public void setMaxInsuredAge(String aMaxInsuredAge)
	{
		if (aMaxInsuredAge != null && !aMaxInsuredAge.equals(""))
		{
			Integer tInteger = new Integer(aMaxInsuredAge);
			int i = tInteger.intValue();
			maxInsuredAge = i;
		}
	}

	public int getMinInsuredAge()
	{
		return minInsuredAge;
	}

	public void setMinInsuredAge(int aMinInsuredAge)
	{
		minInsuredAge = aMinInsuredAge;
	}

	public void setMinInsuredAge(String aMinInsuredAge)
	{
		if (aMinInsuredAge != null && !aMinInsuredAge.equals(""))
		{
			Integer tInteger = new Integer(aMinInsuredAge);
			int i = tInteger.intValue();
			minInsuredAge = i;
		}
	}

	public double getAppInterest()
	{
		return appInterest;
	}

	public void setAppInterest(double aAppInterest)
	{
		appInterest = aAppInterest;
	}

	public void setAppInterest(String aAppInterest)
	{
		if (aAppInterest != null && !aAppInterest.equals(""))
		{
			Double tDouble = new Double(aAppInterest);
			double d = tDouble.doubleValue();
			appInterest = d;
		}
	}

	public double getAppPremRate()
	{
		return appPremRate;
	}

	public void setAppPremRate(double aAppPremRate)
	{
		appPremRate = aAppPremRate;
	}

	public void setAppPremRate(String aAppPremRate)
	{
		if (aAppPremRate != null && !aAppPremRate.equals(""))
		{
			Double tDouble = new Double(aAppPremRate);
			double d = tDouble.doubleValue();
			appPremRate = d;
		}
	}

	public String getInsuredFlag()
	{
		return insuredFlag;
	}

	public void setInsuredFlag(String aInsuredFlag)
	{
		insuredFlag = aInsuredFlag;
	}

	public String getShareFlag()
	{
		return shareFlag;
	}

	public void setShareFlag(String aShareFlag)
	{
		shareFlag = aShareFlag;
	}

	public String getBnfFlag()
	{
		return bnfFlag;
	}

	public void setBnfFlag(String aBnfFlag)
	{
		bnfFlag = aBnfFlag;
	}

	public String getTempPayFlag()
	{
		return tempPayFlag;
	}

	public void setTempPayFlag(String aTempPayFlag)
	{
		tempPayFlag = aTempPayFlag;
	}

	public String getInpPayPlan()
	{
		return inpPayPlan;
	}

	public void setInpPayPlan(String aInpPayPlan)
	{
		inpPayPlan = aInpPayPlan;
	}

	public String getImpartFlag()
	{
		return impartFlag;
	}

	public void setImpartFlag(String aImpartFlag)
	{
		impartFlag = aImpartFlag;
	}

	public String getInsuExpeFlag()
	{
		return insuExpeFlag;
	}

	public void setInsuExpeFlag(String aInsuExpeFlag)
	{
		insuExpeFlag = aInsuExpeFlag;
	}

	public String getLoanFalg()
	{
		return loanFalg;
	}

	public void setLoanFalg(String aLoanFalg)
	{
		loanFalg = aLoanFalg;
	}

	public String getMortagageFlag()
	{
		return mortagageFlag;
	}

	public void setMortagageFlag(String aMortagageFlag)
	{
		mortagageFlag = aMortagageFlag;
	}

	public String getIDifReturnFlag()
	{
		return iDifReturnFlag;
	}

	public void setIDifReturnFlag(String aIDifReturnFlag)
	{
		iDifReturnFlag = aIDifReturnFlag;
	}

	public String getCutAmntStopPay()
	{
		return cutAmntStopPay;
	}

	public void setCutAmntStopPay(String aCutAmntStopPay)
	{
		cutAmntStopPay = aCutAmntStopPay;
	}

	public double getRinsRate()
	{
		return rinsRate;
	}

	public void setRinsRate(double aRinsRate)
	{
		rinsRate = aRinsRate;
	}

	public void setRinsRate(String aRinsRate)
	{
		if (aRinsRate != null && !aRinsRate.equals(""))
		{
			Double tDouble = new Double(aRinsRate);
			double d = tDouble.doubleValue();
			rinsRate = d;
		}
	}

	public String getSaleFlag()
	{
		return saleFlag;
	}

	public void setSaleFlag(String aSaleFlag)
	{
		saleFlag = aSaleFlag;
	}

	public String getFileAppFlag()
	{
		return fileAppFlag;
	}

	public void setFileAppFlag(String aFileAppFlag)
	{
		fileAppFlag = aFileAppFlag;
	}

	public String getMngCom()
	{
		return mngCom;
	}

	public void setMngCom(String aMngCom)
	{
		mngCom = aMngCom;
	}

	public String getAutoPayFlag()
	{
		return autoPayFlag;
	}

	public void setAutoPayFlag(String aAutoPayFlag)
	{
		autoPayFlag = aAutoPayFlag;
	}

	public String getNeedPrintHospital()
	{
		return needPrintHospital;
	}

	public void setNeedPrintHospital(String aNeedPrintHospital)
	{
		needPrintHospital = aNeedPrintHospital;
	}

	public String getNeedPrintGet()
	{
		return needPrintGet;
	}

	public void setNeedPrintGet(String aNeedPrintGet)
	{
		needPrintGet = aNeedPrintGet;
	}

	public String getRiskType3()
	{
		return riskType3;
	}

	public void setRiskType3(String aRiskType3)
	{
		riskType3 = aRiskType3;
	}

	public String getRiskType4()
	{
		return riskType4;
	}

	public void setRiskType4(String aRiskType4)
	{
		riskType4 = aRiskType4;
	}

	public String getRiskType5()
	{
		return riskType5;
	}

	public void setRiskType5(String aRiskType5)
	{
		riskType5 = aRiskType5;
	}

	public String getNotPrintPol()
	{
		return notPrintPol;
	}

	public void setNotPrintPol(String aNotPrintPol)
	{
		notPrintPol = aNotPrintPol;
	}

	public String getNeedGetPolDate()
	{
		return needGetPolDate;
	}

	public void setNeedGetPolDate(String aNeedGetPolDate)
	{
		needGetPolDate = aNeedGetPolDate;
	}

	public String getNeedReReadBank()
	{
		return needReReadBank;
	}

	public void setNeedReReadBank(String aNeedReReadBank)
	{
		needReReadBank = aNeedReReadBank;
	}

	public String getSpecFlag()
	{
		return specFlag;
	}

	public void setSpecFlag(String aSpecFlag)
	{
		specFlag = aSpecFlag;
	}

	public String getInterestDifFlag()
	{
		return interestDifFlag;
	}

	public void setInterestDifFlag(String aInterestDifFlag)
	{
		interestDifFlag = aInterestDifFlag;
	}

	public void setSchema(LNPRiskAppSchema aLNPRiskAppSchema)
	{
		riskCode = aLNPRiskAppSchema.getRiskCode();
		riskVer = aLNPRiskAppSchema.getRiskVer();
		riskName = aLNPRiskAppSchema.getRiskName();
		kindCode = aLNPRiskAppSchema.getKindCode();
		riskType = aLNPRiskAppSchema.getRiskType();
		riskType1 = aLNPRiskAppSchema.getRiskType1();
		riskType2 = aLNPRiskAppSchema.getRiskType2();
		riskProp = aLNPRiskAppSchema.getRiskProp();
		riskPeriod = aLNPRiskAppSchema.getRiskPeriod();
		riskTypeDetail = aLNPRiskAppSchema.getRiskTypeDetail();
		riskFlag = aLNPRiskAppSchema.getRiskFlag();
		polType = aLNPRiskAppSchema.getPolType();
		investFlag = aLNPRiskAppSchema.getInvestFlag();
		bonusFlag = aLNPRiskAppSchema.getBonusFlag();
		bonusMode = aLNPRiskAppSchema.getBonusMode();
		listFlag = aLNPRiskAppSchema.getListFlag();
		subRiskFlag = aLNPRiskAppSchema.getSubRiskFlag();
		calDigital = aLNPRiskAppSchema.getCalDigital();
		calChoMode = aLNPRiskAppSchema.getCalChoMode();
		riskAmntMult = aLNPRiskAppSchema.getRiskAmntMult();
		insuPeriodFlag = aLNPRiskAppSchema.getInsuPeriodFlag();
		maxEndPeriod = aLNPRiskAppSchema.getMaxEndPeriod();
		ageLmt = aLNPRiskAppSchema.getAgeLmt();
		signDateCalMode = aLNPRiskAppSchema.getSignDateCalMode();
		protocolFlag = aLNPRiskAppSchema.getProtocolFlag();
		getChgFlag = aLNPRiskAppSchema.getGetChgFlag();
		protocolPayFlag = aLNPRiskAppSchema.getProtocolPayFlag();
		ensuPlanFlag = aLNPRiskAppSchema.getEnsuPlanFlag();
		ensuPlanAdjFlag = aLNPRiskAppSchema.getEnsuPlanAdjFlag();
		startDate = fDate.getDate(aLNPRiskAppSchema.getStartDate());
		endDate = fDate.getDate(aLNPRiskAppSchema.getEndDate());
		minAppntAge = aLNPRiskAppSchema.getMinAppntAge();
		maxAppntAge = aLNPRiskAppSchema.getMaxAppntAge();
		maxInsuredAge = aLNPRiskAppSchema.getMaxInsuredAge();
		minInsuredAge = aLNPRiskAppSchema.getMinInsuredAge();
		appInterest = aLNPRiskAppSchema.getAppInterest();
		appPremRate = aLNPRiskAppSchema.getAppPremRate();
		insuredFlag = aLNPRiskAppSchema.getInsuredFlag();
		shareFlag = aLNPRiskAppSchema.getShareFlag();
		bnfFlag = aLNPRiskAppSchema.getBnfFlag();
		tempPayFlag = aLNPRiskAppSchema.getTempPayFlag();
		inpPayPlan = aLNPRiskAppSchema.getInpPayPlan();
		impartFlag = aLNPRiskAppSchema.getImpartFlag();
		insuExpeFlag = aLNPRiskAppSchema.getInsuExpeFlag();
		loanFalg = aLNPRiskAppSchema.getLoanFalg();
		mortagageFlag = aLNPRiskAppSchema.getMortagageFlag();
		iDifReturnFlag = aLNPRiskAppSchema.getIDifReturnFlag();
		cutAmntStopPay = aLNPRiskAppSchema.getCutAmntStopPay();
		rinsRate = aLNPRiskAppSchema.getRinsRate();
		saleFlag = aLNPRiskAppSchema.getSaleFlag();
		fileAppFlag = aLNPRiskAppSchema.getFileAppFlag();
		mngCom = aLNPRiskAppSchema.getMngCom();
		autoPayFlag = aLNPRiskAppSchema.getAutoPayFlag();
		needPrintHospital = aLNPRiskAppSchema.getNeedPrintHospital();
		needPrintGet = aLNPRiskAppSchema.getNeedPrintGet();
		riskType3 = aLNPRiskAppSchema.getRiskType3();
		riskType4 = aLNPRiskAppSchema.getRiskType4();
		riskType5 = aLNPRiskAppSchema.getRiskType5();
		notPrintPol = aLNPRiskAppSchema.getNotPrintPol();
		needGetPolDate = aLNPRiskAppSchema.getNeedGetPolDate();
		needReReadBank = aLNPRiskAppSchema.getNeedReReadBank();
		specFlag = aLNPRiskAppSchema.getSpecFlag();
		interestDifFlag = aLNPRiskAppSchema.getInterestDifFlag();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			if (rs.getString("RiskVer") == null)
				riskVer = null;
			else
				riskVer = rs.getString("RiskVer").trim();
			if (rs.getString("RiskName") == null)
				riskName = null;
			else
				riskName = rs.getString("RiskName").trim();
			if (rs.getString("KindCode") == null)
				kindCode = null;
			else
				kindCode = rs.getString("KindCode").trim();
			if (rs.getString("RiskType") == null)
				riskType = null;
			else
				riskType = rs.getString("RiskType").trim();
			if (rs.getString("RiskType1") == null)
				riskType1 = null;
			else
				riskType1 = rs.getString("RiskType1").trim();
			if (rs.getString("RiskType2") == null)
				riskType2 = null;
			else
				riskType2 = rs.getString("RiskType2").trim();
			if (rs.getString("RiskProp") == null)
				riskProp = null;
			else
				riskProp = rs.getString("RiskProp").trim();
			if (rs.getString("RiskPeriod") == null)
				riskPeriod = null;
			else
				riskPeriod = rs.getString("RiskPeriod").trim();
			if (rs.getString("RiskTypeDetail") == null)
				riskTypeDetail = null;
			else
				riskTypeDetail = rs.getString("RiskTypeDetail").trim();
			if (rs.getString("RiskFlag") == null)
				riskFlag = null;
			else
				riskFlag = rs.getString("RiskFlag").trim();
			if (rs.getString("PolType") == null)
				polType = null;
			else
				polType = rs.getString("PolType").trim();
			if (rs.getString("InvestFlag") == null)
				investFlag = null;
			else
				investFlag = rs.getString("InvestFlag").trim();
			if (rs.getString("BonusFlag") == null)
				bonusFlag = null;
			else
				bonusFlag = rs.getString("BonusFlag").trim();
			if (rs.getString("BonusMode") == null)
				bonusMode = null;
			else
				bonusMode = rs.getString("BonusMode").trim();
			if (rs.getString("ListFlag") == null)
				listFlag = null;
			else
				listFlag = rs.getString("ListFlag").trim();
			if (rs.getString("SubRiskFlag") == null)
				subRiskFlag = null;
			else
				subRiskFlag = rs.getString("SubRiskFlag").trim();
			calDigital = rs.getInt("CalDigital");
			if (rs.getString("CalChoMode") == null)
				calChoMode = null;
			else
				calChoMode = rs.getString("CalChoMode").trim();
			riskAmntMult = rs.getInt("RiskAmntMult");
			if (rs.getString("InsuPeriodFlag") == null)
				insuPeriodFlag = null;
			else
				insuPeriodFlag = rs.getString("InsuPeriodFlag").trim();
			maxEndPeriod = rs.getInt("MaxEndPeriod");
			ageLmt = rs.getInt("AgeLmt");
			signDateCalMode = rs.getInt("SignDateCalMode");
			if (rs.getString("ProtocolFlag") == null)
				protocolFlag = null;
			else
				protocolFlag = rs.getString("ProtocolFlag").trim();
			if (rs.getString("GetChgFlag") == null)
				getChgFlag = null;
			else
				getChgFlag = rs.getString("GetChgFlag").trim();
			if (rs.getString("ProtocolPayFlag") == null)
				protocolPayFlag = null;
			else
				protocolPayFlag = rs.getString("ProtocolPayFlag").trim();
			if (rs.getString("EnsuPlanFlag") == null)
				ensuPlanFlag = null;
			else
				ensuPlanFlag = rs.getString("EnsuPlanFlag").trim();
			if (rs.getString("EnsuPlanAdjFlag") == null)
				ensuPlanAdjFlag = null;
			else
				ensuPlanAdjFlag = rs.getString("EnsuPlanAdjFlag").trim();
			startDate = rs.getDate("StartDate");
			endDate = rs.getDate("EndDate");
			minAppntAge = rs.getInt("MinAppntAge");
			maxAppntAge = rs.getInt("MaxAppntAge");
			maxInsuredAge = rs.getInt("MaxInsuredAge");
			minInsuredAge = rs.getInt("MinInsuredAge");
			appInterest = rs.getDouble("AppInterest");
			appPremRate = rs.getDouble("AppPremRate");
			if (rs.getString("InsuredFlag") == null)
				insuredFlag = null;
			else
				insuredFlag = rs.getString("InsuredFlag").trim();
			if (rs.getString("ShareFlag") == null)
				shareFlag = null;
			else
				shareFlag = rs.getString("ShareFlag").trim();
			if (rs.getString("BnfFlag") == null)
				bnfFlag = null;
			else
				bnfFlag = rs.getString("BnfFlag").trim();
			if (rs.getString("TempPayFlag") == null)
				tempPayFlag = null;
			else
				tempPayFlag = rs.getString("TempPayFlag").trim();
			if (rs.getString("InpPayPlan") == null)
				inpPayPlan = null;
			else
				inpPayPlan = rs.getString("InpPayPlan").trim();
			if (rs.getString("ImpartFlag") == null)
				impartFlag = null;
			else
				impartFlag = rs.getString("ImpartFlag").trim();
			if (rs.getString("InsuExpeFlag") == null)
				insuExpeFlag = null;
			else
				insuExpeFlag = rs.getString("InsuExpeFlag").trim();
			if (rs.getString("LoanFalg") == null)
				loanFalg = null;
			else
				loanFalg = rs.getString("LoanFalg").trim();
			if (rs.getString("MortagageFlag") == null)
				mortagageFlag = null;
			else
				mortagageFlag = rs.getString("MortagageFlag").trim();
			if (rs.getString("IDifReturnFlag") == null)
				iDifReturnFlag = null;
			else
				iDifReturnFlag = rs.getString("IDifReturnFlag").trim();
			if (rs.getString("CutAmntStopPay") == null)
				cutAmntStopPay = null;
			else
				cutAmntStopPay = rs.getString("CutAmntStopPay").trim();
			rinsRate = rs.getDouble("RinsRate");
			if (rs.getString("SaleFlag") == null)
				saleFlag = null;
			else
				saleFlag = rs.getString("SaleFlag").trim();
			if (rs.getString("FileAppFlag") == null)
				fileAppFlag = null;
			else
				fileAppFlag = rs.getString("FileAppFlag").trim();
			if (rs.getString("MngCom") == null)
				mngCom = null;
			else
				mngCom = rs.getString("MngCom").trim();
			if (rs.getString("AutoPayFlag") == null)
				autoPayFlag = null;
			else
				autoPayFlag = rs.getString("AutoPayFlag").trim();
			if (rs.getString("NeedPrintHospital") == null)
				needPrintHospital = null;
			else
				needPrintHospital = rs.getString("NeedPrintHospital").trim();
			if (rs.getString("NeedPrintGet") == null)
				needPrintGet = null;
			else
				needPrintGet = rs.getString("NeedPrintGet").trim();
			if (rs.getString("RiskType3") == null)
				riskType3 = null;
			else
				riskType3 = rs.getString("RiskType3").trim();
			if (rs.getString("RiskType4") == null)
				riskType4 = null;
			else
				riskType4 = rs.getString("RiskType4").trim();
			if (rs.getString("RiskType5") == null)
				riskType5 = null;
			else
				riskType5 = rs.getString("RiskType5").trim();
			if (rs.getString("NotPrintPol") == null)
				notPrintPol = null;
			else
				notPrintPol = rs.getString("NotPrintPol").trim();
			if (rs.getString("NeedGetPolDate") == null)
				needGetPolDate = null;
			else
				needGetPolDate = rs.getString("NeedGetPolDate").trim();
			if (rs.getString("NeedReReadBank") == null)
				needReReadBank = null;
			else
				needReReadBank = rs.getString("NeedReReadBank").trim();
			if (rs.getString("SpecFlag") == null)
				specFlag = null;
			else
				specFlag = rs.getString("SpecFlag").trim();
			if (rs.getString("InterestDifFlag") == null)
				interestDifFlag = null;
			else
				interestDifFlag = rs.getString("InterestDifFlag").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPRiskApp���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskAppSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskAppSchema getSchema()
	{
		LNPRiskAppSchema aLNPRiskAppSchema = new LNPRiskAppSchema();
		aLNPRiskAppSchema.setSchema(this);
		return aLNPRiskAppSchema;
	}

	public LNPRiskAppDB getDB()
	{
		LNPRiskAppDB aDBOper = new LNPRiskAppDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskVer));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(kindCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskType1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskType2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskProp));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskPeriod));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskTypeDetail));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(polType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(investFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bonusFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bonusMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(listFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(subRiskFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(calDigital));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(calChoMode));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(riskAmntMult));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuPeriodFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(maxEndPeriod));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(ageLmt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(signDateCalMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(protocolFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getChgFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(protocolPayFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ensuPlanFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ensuPlanAdjFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(endDate)));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(minAppntAge));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(maxAppntAge));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(maxInsuredAge));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(minInsuredAge));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(appInterest));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(appPremRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(shareFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bnfFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(tempPayFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(inpPayPlan));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(impartFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuExpeFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(loanFalg));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mortagageFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDifReturnFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(cutAmntStopPay));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(rinsRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(saleFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fileAppFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mngCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(autoPayFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(needPrintHospital));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(needPrintGet));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskType3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskType4));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskType5));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(notPrintPol));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(needGetPolDate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(needReReadBank));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(specFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(interestDifFlag));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			riskName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			kindCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			riskType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			riskType1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			riskType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			riskProp = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			riskPeriod = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			riskTypeDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			riskFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			polType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			investFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			bonusFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			bonusMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			listFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			subRiskFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			calDigital = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|")))).intValue();
			calChoMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			riskAmntMult = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|")))).intValue();
			insuPeriodFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			maxEndPeriod = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 22, "|")))).intValue();
			ageLmt = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|")))).intValue();
			signDateCalMode = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|")))).intValue();
			protocolFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			getChgFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			protocolPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			ensuPlanFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			ensuPlanAdjFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|"));
			minAppntAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|")))).intValue();
			maxAppntAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|")))).intValue();
			maxInsuredAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|")))).intValue();
			minInsuredAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|")))).intValue();
			appInterest = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|")))).doubleValue();
			appPremRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 37, "|")))).doubleValue();
			insuredFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			shareFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			tempPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			inpPayPlan = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			impartFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			insuExpeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			loanFalg = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			mortagageFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			iDifReturnFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			cutAmntStopPay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			rinsRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|")))).doubleValue();
			saleFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			fileAppFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			mngCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			autoPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
			needPrintHospital = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
			needPrintGet = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
			riskType3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
			riskType4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|");
			riskType5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, "|");
			notPrintPol = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 59, "|");
			needGetPolDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 60, "|");
			needReReadBank = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 61, "|");
			specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, "|");
			interestDifFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskAppSchema";
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
		if (FCode.equalsIgnoreCase("riskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCode));
		if (FCode.equalsIgnoreCase("riskVer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskVer));
		if (FCode.equalsIgnoreCase("riskName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskName));
		if (FCode.equalsIgnoreCase("kindCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(kindCode));
		if (FCode.equalsIgnoreCase("riskType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskType));
		if (FCode.equalsIgnoreCase("riskType1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskType1));
		if (FCode.equalsIgnoreCase("riskType2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskType2));
		if (FCode.equalsIgnoreCase("riskProp"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskProp));
		if (FCode.equalsIgnoreCase("riskPeriod"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskPeriod));
		if (FCode.equalsIgnoreCase("riskTypeDetail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskTypeDetail));
		if (FCode.equalsIgnoreCase("riskFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskFlag));
		if (FCode.equalsIgnoreCase("polType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polType));
		if (FCode.equalsIgnoreCase("investFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(investFlag));
		if (FCode.equalsIgnoreCase("bonusFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusFlag));
		if (FCode.equalsIgnoreCase("bonusMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusMode));
		if (FCode.equalsIgnoreCase("listFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(listFlag));
		if (FCode.equalsIgnoreCase("subRiskFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(subRiskFlag));
		if (FCode.equalsIgnoreCase("calDigital"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(calDigital));
		if (FCode.equalsIgnoreCase("calChoMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(calChoMode));
		if (FCode.equalsIgnoreCase("riskAmntMult"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskAmntMult));
		if (FCode.equalsIgnoreCase("insuPeriodFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuPeriodFlag));
		if (FCode.equalsIgnoreCase("maxEndPeriod"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(maxEndPeriod));
		if (FCode.equalsIgnoreCase("ageLmt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ageLmt));
		if (FCode.equalsIgnoreCase("signDateCalMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signDateCalMode));
		if (FCode.equalsIgnoreCase("protocolFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(protocolFlag));
		if (FCode.equalsIgnoreCase("getChgFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getChgFlag));
		if (FCode.equalsIgnoreCase("protocolPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(protocolPayFlag));
		if (FCode.equalsIgnoreCase("ensuPlanFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ensuPlanFlag));
		if (FCode.equalsIgnoreCase("ensuPlanAdjFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ensuPlanAdjFlag));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("endDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
		if (FCode.equalsIgnoreCase("minAppntAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(minAppntAge));
		if (FCode.equalsIgnoreCase("maxAppntAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(maxAppntAge));
		if (FCode.equalsIgnoreCase("maxInsuredAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(maxInsuredAge));
		if (FCode.equalsIgnoreCase("minInsuredAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(minInsuredAge));
		if (FCode.equalsIgnoreCase("appInterest"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appInterest));
		if (FCode.equalsIgnoreCase("appPremRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appPremRate));
		if (FCode.equalsIgnoreCase("insuredFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredFlag));
		if (FCode.equalsIgnoreCase("shareFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(shareFlag));
		if (FCode.equalsIgnoreCase("bnfFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfFlag));
		if (FCode.equalsIgnoreCase("tempPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(tempPayFlag));
		if (FCode.equalsIgnoreCase("inpPayPlan"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(inpPayPlan));
		if (FCode.equalsIgnoreCase("impartFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartFlag));
		if (FCode.equalsIgnoreCase("insuExpeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuExpeFlag));
		if (FCode.equalsIgnoreCase("loanFalg"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(loanFalg));
		if (FCode.equalsIgnoreCase("mortagageFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mortagageFlag));
		if (FCode.equalsIgnoreCase("iDifReturnFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDifReturnFlag));
		if (FCode.equalsIgnoreCase("cutAmntStopPay"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(cutAmntStopPay));
		if (FCode.equalsIgnoreCase("rinsRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rinsRate));
		if (FCode.equalsIgnoreCase("saleFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleFlag));
		if (FCode.equalsIgnoreCase("fileAppFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fileAppFlag));
		if (FCode.equalsIgnoreCase("mngCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mngCom));
		if (FCode.equalsIgnoreCase("autoPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(autoPayFlag));
		if (FCode.equalsIgnoreCase("needPrintHospital"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(needPrintHospital));
		if (FCode.equalsIgnoreCase("needPrintGet"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(needPrintGet));
		if (FCode.equalsIgnoreCase("riskType3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskType3));
		if (FCode.equalsIgnoreCase("riskType4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskType4));
		if (FCode.equalsIgnoreCase("riskType5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskType5));
		if (FCode.equalsIgnoreCase("notPrintPol"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(notPrintPol));
		if (FCode.equalsIgnoreCase("needGetPolDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(needGetPolDate));
		if (FCode.equalsIgnoreCase("needReReadBank"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(needReReadBank));
		if (FCode.equalsIgnoreCase("specFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(specFlag));
		if (FCode.equalsIgnoreCase("interestDifFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(interestDifFlag));
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
			strFieldValue = StrTool.GBKToUnicode(riskCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(riskVer);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(riskName);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(kindCode);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(riskType);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(riskType1);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(riskType2);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(riskProp);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(riskPeriod);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(riskTypeDetail);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(riskFlag);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(polType);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(investFlag);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(bonusFlag);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(bonusMode);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(listFlag);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(subRiskFlag);
			break;

		case 17: // '\021'
			strFieldValue = String.valueOf(calDigital);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(calChoMode);
			break;

		case 19: // '\023'
			strFieldValue = String.valueOf(riskAmntMult);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(insuPeriodFlag);
			break;

		case 21: // '\025'
			strFieldValue = String.valueOf(maxEndPeriod);
			break;

		case 22: // '\026'
			strFieldValue = String.valueOf(ageLmt);
			break;

		case 23: // '\027'
			strFieldValue = String.valueOf(signDateCalMode);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(protocolFlag);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(getChgFlag);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(protocolPayFlag);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(ensuPlanFlag);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(ensuPlanAdjFlag);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
			break;

		case 31: // '\037'
			strFieldValue = String.valueOf(minAppntAge);
			break;

		case 32: // ' '
			strFieldValue = String.valueOf(maxAppntAge);
			break;

		case 33: // '!'
			strFieldValue = String.valueOf(maxInsuredAge);
			break;

		case 34: // '"'
			strFieldValue = String.valueOf(minInsuredAge);
			break;

		case 35: // '#'
			strFieldValue = String.valueOf(appInterest);
			break;

		case 36: // '$'
			strFieldValue = String.valueOf(appPremRate);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(insuredFlag);
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(shareFlag);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(bnfFlag);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(tempPayFlag);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(inpPayPlan);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(impartFlag);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(insuExpeFlag);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(loanFalg);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(mortagageFlag);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(iDifReturnFlag);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(cutAmntStopPay);
			break;

		case 48: // '0'
			strFieldValue = String.valueOf(rinsRate);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(saleFlag);
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(fileAppFlag);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(mngCom);
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(autoPayFlag);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(needPrintHospital);
			break;

		case 54: // '6'
			strFieldValue = StrTool.GBKToUnicode(needPrintGet);
			break;

		case 55: // '7'
			strFieldValue = StrTool.GBKToUnicode(riskType3);
			break;

		case 56: // '8'
			strFieldValue = StrTool.GBKToUnicode(riskType4);
			break;

		case 57: // '9'
			strFieldValue = StrTool.GBKToUnicode(riskType5);
			break;

		case 58: // ':'
			strFieldValue = StrTool.GBKToUnicode(notPrintPol);
			break;

		case 59: // ';'
			strFieldValue = StrTool.GBKToUnicode(needGetPolDate);
			break;

		case 60: // '<'
			strFieldValue = StrTool.GBKToUnicode(needReReadBank);
			break;

		case 61: // '='
			strFieldValue = StrTool.GBKToUnicode(specFlag);
			break;

		case 62: // '>'
			strFieldValue = StrTool.GBKToUnicode(interestDifFlag);
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
		if (FCode.equalsIgnoreCase("riskCode"))
			if (FValue != null && !FValue.equals(""))
				riskCode = FValue.trim();
			else
				riskCode = null;
		if (FCode.equalsIgnoreCase("riskVer"))
			if (FValue != null && !FValue.equals(""))
				riskVer = FValue.trim();
			else
				riskVer = null;
		if (FCode.equalsIgnoreCase("riskName"))
			if (FValue != null && !FValue.equals(""))
				riskName = FValue.trim();
			else
				riskName = null;
		if (FCode.equalsIgnoreCase("kindCode"))
			if (FValue != null && !FValue.equals(""))
				kindCode = FValue.trim();
			else
				kindCode = null;
		if (FCode.equalsIgnoreCase("riskType"))
			if (FValue != null && !FValue.equals(""))
				riskType = FValue.trim();
			else
				riskType = null;
		if (FCode.equalsIgnoreCase("riskType1"))
			if (FValue != null && !FValue.equals(""))
				riskType1 = FValue.trim();
			else
				riskType1 = null;
		if (FCode.equalsIgnoreCase("riskType2"))
			if (FValue != null && !FValue.equals(""))
				riskType2 = FValue.trim();
			else
				riskType2 = null;
		if (FCode.equalsIgnoreCase("riskProp"))
			if (FValue != null && !FValue.equals(""))
				riskProp = FValue.trim();
			else
				riskProp = null;
		if (FCode.equalsIgnoreCase("riskPeriod"))
			if (FValue != null && !FValue.equals(""))
				riskPeriod = FValue.trim();
			else
				riskPeriod = null;
		if (FCode.equalsIgnoreCase("riskTypeDetail"))
			if (FValue != null && !FValue.equals(""))
				riskTypeDetail = FValue.trim();
			else
				riskTypeDetail = null;
		if (FCode.equalsIgnoreCase("riskFlag"))
			if (FValue != null && !FValue.equals(""))
				riskFlag = FValue.trim();
			else
				riskFlag = null;
		if (FCode.equalsIgnoreCase("polType"))
			if (FValue != null && !FValue.equals(""))
				polType = FValue.trim();
			else
				polType = null;
		if (FCode.equalsIgnoreCase("investFlag"))
			if (FValue != null && !FValue.equals(""))
				investFlag = FValue.trim();
			else
				investFlag = null;
		if (FCode.equalsIgnoreCase("bonusFlag"))
			if (FValue != null && !FValue.equals(""))
				bonusFlag = FValue.trim();
			else
				bonusFlag = null;
		if (FCode.equalsIgnoreCase("bonusMode"))
			if (FValue != null && !FValue.equals(""))
				bonusMode = FValue.trim();
			else
				bonusMode = null;
		if (FCode.equalsIgnoreCase("listFlag"))
			if (FValue != null && !FValue.equals(""))
				listFlag = FValue.trim();
			else
				listFlag = null;
		if (FCode.equalsIgnoreCase("subRiskFlag"))
			if (FValue != null && !FValue.equals(""))
				subRiskFlag = FValue.trim();
			else
				subRiskFlag = null;
		if (FCode.equalsIgnoreCase("calDigital") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			calDigital = i;
		}
		if (FCode.equalsIgnoreCase("calChoMode"))
			if (FValue != null && !FValue.equals(""))
				calChoMode = FValue.trim();
			else
				calChoMode = null;
		if (FCode.equalsIgnoreCase("riskAmntMult") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			riskAmntMult = i;
		}
		if (FCode.equalsIgnoreCase("insuPeriodFlag"))
			if (FValue != null && !FValue.equals(""))
				insuPeriodFlag = FValue.trim();
			else
				insuPeriodFlag = null;
		if (FCode.equalsIgnoreCase("maxEndPeriod") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			maxEndPeriod = i;
		}
		if (FCode.equalsIgnoreCase("ageLmt") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			ageLmt = i;
		}
		if (FCode.equalsIgnoreCase("signDateCalMode") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			signDateCalMode = i;
		}
		if (FCode.equalsIgnoreCase("protocolFlag"))
			if (FValue != null && !FValue.equals(""))
				protocolFlag = FValue.trim();
			else
				protocolFlag = null;
		if (FCode.equalsIgnoreCase("getChgFlag"))
			if (FValue != null && !FValue.equals(""))
				getChgFlag = FValue.trim();
			else
				getChgFlag = null;
		if (FCode.equalsIgnoreCase("protocolPayFlag"))
			if (FValue != null && !FValue.equals(""))
				protocolPayFlag = FValue.trim();
			else
				protocolPayFlag = null;
		if (FCode.equalsIgnoreCase("ensuPlanFlag"))
			if (FValue != null && !FValue.equals(""))
				ensuPlanFlag = FValue.trim();
			else
				ensuPlanFlag = null;
		if (FCode.equalsIgnoreCase("ensuPlanAdjFlag"))
			if (FValue != null && !FValue.equals(""))
				ensuPlanAdjFlag = FValue.trim();
			else
				ensuPlanAdjFlag = null;
		if (FCode.equalsIgnoreCase("startDate"))
			if (FValue != null && !FValue.equals(""))
				startDate = fDate.getDate(FValue);
			else
				startDate = null;
		if (FCode.equalsIgnoreCase("endDate"))
			if (FValue != null && !FValue.equals(""))
				endDate = fDate.getDate(FValue);
			else
				endDate = null;
		if (FCode.equalsIgnoreCase("minAppntAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			minAppntAge = i;
		}
		if (FCode.equalsIgnoreCase("maxAppntAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			maxAppntAge = i;
		}
		if (FCode.equalsIgnoreCase("maxInsuredAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			maxInsuredAge = i;
		}
		if (FCode.equalsIgnoreCase("minInsuredAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			minInsuredAge = i;
		}
		if (FCode.equalsIgnoreCase("appInterest") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			appInterest = d;
		}
		if (FCode.equalsIgnoreCase("appPremRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			appPremRate = d;
		}
		if (FCode.equalsIgnoreCase("insuredFlag"))
			if (FValue != null && !FValue.equals(""))
				insuredFlag = FValue.trim();
			else
				insuredFlag = null;
		if (FCode.equalsIgnoreCase("shareFlag"))
			if (FValue != null && !FValue.equals(""))
				shareFlag = FValue.trim();
			else
				shareFlag = null;
		if (FCode.equalsIgnoreCase("bnfFlag"))
			if (FValue != null && !FValue.equals(""))
				bnfFlag = FValue.trim();
			else
				bnfFlag = null;
		if (FCode.equalsIgnoreCase("tempPayFlag"))
			if (FValue != null && !FValue.equals(""))
				tempPayFlag = FValue.trim();
			else
				tempPayFlag = null;
		if (FCode.equalsIgnoreCase("inpPayPlan"))
			if (FValue != null && !FValue.equals(""))
				inpPayPlan = FValue.trim();
			else
				inpPayPlan = null;
		if (FCode.equalsIgnoreCase("impartFlag"))
			if (FValue != null && !FValue.equals(""))
				impartFlag = FValue.trim();
			else
				impartFlag = null;
		if (FCode.equalsIgnoreCase("insuExpeFlag"))
			if (FValue != null && !FValue.equals(""))
				insuExpeFlag = FValue.trim();
			else
				insuExpeFlag = null;
		if (FCode.equalsIgnoreCase("loanFalg"))
			if (FValue != null && !FValue.equals(""))
				loanFalg = FValue.trim();
			else
				loanFalg = null;
		if (FCode.equalsIgnoreCase("mortagageFlag"))
			if (FValue != null && !FValue.equals(""))
				mortagageFlag = FValue.trim();
			else
				mortagageFlag = null;
		if (FCode.equalsIgnoreCase("iDifReturnFlag"))
			if (FValue != null && !FValue.equals(""))
				iDifReturnFlag = FValue.trim();
			else
				iDifReturnFlag = null;
		if (FCode.equalsIgnoreCase("cutAmntStopPay"))
			if (FValue != null && !FValue.equals(""))
				cutAmntStopPay = FValue.trim();
			else
				cutAmntStopPay = null;
		if (FCode.equalsIgnoreCase("rinsRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			rinsRate = d;
		}
		if (FCode.equalsIgnoreCase("saleFlag"))
			if (FValue != null && !FValue.equals(""))
				saleFlag = FValue.trim();
			else
				saleFlag = null;
		if (FCode.equalsIgnoreCase("fileAppFlag"))
			if (FValue != null && !FValue.equals(""))
				fileAppFlag = FValue.trim();
			else
				fileAppFlag = null;
		if (FCode.equalsIgnoreCase("mngCom"))
			if (FValue != null && !FValue.equals(""))
				mngCom = FValue.trim();
			else
				mngCom = null;
		if (FCode.equalsIgnoreCase("autoPayFlag"))
			if (FValue != null && !FValue.equals(""))
				autoPayFlag = FValue.trim();
			else
				autoPayFlag = null;
		if (FCode.equalsIgnoreCase("needPrintHospital"))
			if (FValue != null && !FValue.equals(""))
				needPrintHospital = FValue.trim();
			else
				needPrintHospital = null;
		if (FCode.equalsIgnoreCase("needPrintGet"))
			if (FValue != null && !FValue.equals(""))
				needPrintGet = FValue.trim();
			else
				needPrintGet = null;
		if (FCode.equalsIgnoreCase("riskType3"))
			if (FValue != null && !FValue.equals(""))
				riskType3 = FValue.trim();
			else
				riskType3 = null;
		if (FCode.equalsIgnoreCase("riskType4"))
			if (FValue != null && !FValue.equals(""))
				riskType4 = FValue.trim();
			else
				riskType4 = null;
		if (FCode.equalsIgnoreCase("riskType5"))
			if (FValue != null && !FValue.equals(""))
				riskType5 = FValue.trim();
			else
				riskType5 = null;
		if (FCode.equalsIgnoreCase("notPrintPol"))
			if (FValue != null && !FValue.equals(""))
				notPrintPol = FValue.trim();
			else
				notPrintPol = null;
		if (FCode.equalsIgnoreCase("needGetPolDate"))
			if (FValue != null && !FValue.equals(""))
				needGetPolDate = FValue.trim();
			else
				needGetPolDate = null;
		if (FCode.equalsIgnoreCase("needReReadBank"))
			if (FValue != null && !FValue.equals(""))
				needReReadBank = FValue.trim();
			else
				needReReadBank = null;
		if (FCode.equalsIgnoreCase("specFlag"))
			if (FValue != null && !FValue.equals(""))
				specFlag = FValue.trim();
			else
				specFlag = null;
		if (FCode.equalsIgnoreCase("interestDifFlag"))
			if (FValue != null && !FValue.equals(""))
				interestDifFlag = FValue.trim();
			else
				interestDifFlag = null;
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
		LNPRiskAppSchema other = (LNPRiskAppSchema)otherObject;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (riskVer == null && other.getRiskVer() != null)
			return false;
		if (riskVer != null && !riskVer.equals(other.getRiskVer()))
			return false;
		if (riskName == null && other.getRiskName() != null)
			return false;
		if (riskName != null && !riskName.equals(other.getRiskName()))
			return false;
		if (kindCode == null && other.getKindCode() != null)
			return false;
		if (kindCode != null && !kindCode.equals(other.getKindCode()))
			return false;
		if (riskType == null && other.getRiskType() != null)
			return false;
		if (riskType != null && !riskType.equals(other.getRiskType()))
			return false;
		if (riskType1 == null && other.getRiskType1() != null)
			return false;
		if (riskType1 != null && !riskType1.equals(other.getRiskType1()))
			return false;
		if (riskType2 == null && other.getRiskType2() != null)
			return false;
		if (riskType2 != null && !riskType2.equals(other.getRiskType2()))
			return false;
		if (riskProp == null && other.getRiskProp() != null)
			return false;
		if (riskProp != null && !riskProp.equals(other.getRiskProp()))
			return false;
		if (riskPeriod == null && other.getRiskPeriod() != null)
			return false;
		if (riskPeriod != null && !riskPeriod.equals(other.getRiskPeriod()))
			return false;
		if (riskTypeDetail == null && other.getRiskTypeDetail() != null)
			return false;
		if (riskTypeDetail != null && !riskTypeDetail.equals(other.getRiskTypeDetail()))
			return false;
		if (riskFlag == null && other.getRiskFlag() != null)
			return false;
		if (riskFlag != null && !riskFlag.equals(other.getRiskFlag()))
			return false;
		if (polType == null && other.getPolType() != null)
			return false;
		if (polType != null && !polType.equals(other.getPolType()))
			return false;
		if (investFlag == null && other.getInvestFlag() != null)
			return false;
		if (investFlag != null && !investFlag.equals(other.getInvestFlag()))
			return false;
		if (bonusFlag == null && other.getBonusFlag() != null)
			return false;
		if (bonusFlag != null && !bonusFlag.equals(other.getBonusFlag()))
			return false;
		if (bonusMode == null && other.getBonusMode() != null)
			return false;
		if (bonusMode != null && !bonusMode.equals(other.getBonusMode()))
			return false;
		if (listFlag == null && other.getListFlag() != null)
			return false;
		if (listFlag != null && !listFlag.equals(other.getListFlag()))
			return false;
		if (subRiskFlag == null && other.getSubRiskFlag() != null)
			return false;
		if (subRiskFlag != null && !subRiskFlag.equals(other.getSubRiskFlag()))
			return false;
		if (calDigital != other.getCalDigital())
			return false;
		if (calChoMode == null && other.getCalChoMode() != null)
			return false;
		if (calChoMode != null && !calChoMode.equals(other.getCalChoMode()))
			return false;
		if (riskAmntMult != other.getRiskAmntMult())
			return false;
		if (insuPeriodFlag == null && other.getInsuPeriodFlag() != null)
			return false;
		if (insuPeriodFlag != null && !insuPeriodFlag.equals(other.getInsuPeriodFlag()))
			return false;
		if (maxEndPeriod != other.getMaxEndPeriod())
			return false;
		if (ageLmt != other.getAgeLmt())
			return false;
		if (signDateCalMode != other.getSignDateCalMode())
			return false;
		if (protocolFlag == null && other.getProtocolFlag() != null)
			return false;
		if (protocolFlag != null && !protocolFlag.equals(other.getProtocolFlag()))
			return false;
		if (getChgFlag == null && other.getGetChgFlag() != null)
			return false;
		if (getChgFlag != null && !getChgFlag.equals(other.getGetChgFlag()))
			return false;
		if (protocolPayFlag == null && other.getProtocolPayFlag() != null)
			return false;
		if (protocolPayFlag != null && !protocolPayFlag.equals(other.getProtocolPayFlag()))
			return false;
		if (ensuPlanFlag == null && other.getEnsuPlanFlag() != null)
			return false;
		if (ensuPlanFlag != null && !ensuPlanFlag.equals(other.getEnsuPlanFlag()))
			return false;
		if (ensuPlanAdjFlag == null && other.getEnsuPlanAdjFlag() != null)
			return false;
		if (ensuPlanAdjFlag != null && !ensuPlanAdjFlag.equals(other.getEnsuPlanAdjFlag()))
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (endDate == null && other.getEndDate() != null)
			return false;
		if (endDate != null && !fDate.getString(endDate).equals(other.getEndDate()))
			return false;
		if (minAppntAge != other.getMinAppntAge())
			return false;
		if (maxAppntAge != other.getMaxAppntAge())
			return false;
		if (maxInsuredAge != other.getMaxInsuredAge())
			return false;
		if (minInsuredAge != other.getMinInsuredAge())
			return false;
		if (Double.doubleToLongBits(appInterest) != Double.doubleToLongBits(other.getAppInterest()))
			return false;
		if (Double.doubleToLongBits(appPremRate) != Double.doubleToLongBits(other.getAppPremRate()))
			return false;
		if (insuredFlag == null && other.getInsuredFlag() != null)
			return false;
		if (insuredFlag != null && !insuredFlag.equals(other.getInsuredFlag()))
			return false;
		if (shareFlag == null && other.getShareFlag() != null)
			return false;
		if (shareFlag != null && !shareFlag.equals(other.getShareFlag()))
			return false;
		if (bnfFlag == null && other.getBnfFlag() != null)
			return false;
		if (bnfFlag != null && !bnfFlag.equals(other.getBnfFlag()))
			return false;
		if (tempPayFlag == null && other.getTempPayFlag() != null)
			return false;
		if (tempPayFlag != null && !tempPayFlag.equals(other.getTempPayFlag()))
			return false;
		if (inpPayPlan == null && other.getInpPayPlan() != null)
			return false;
		if (inpPayPlan != null && !inpPayPlan.equals(other.getInpPayPlan()))
			return false;
		if (impartFlag == null && other.getImpartFlag() != null)
			return false;
		if (impartFlag != null && !impartFlag.equals(other.getImpartFlag()))
			return false;
		if (insuExpeFlag == null && other.getInsuExpeFlag() != null)
			return false;
		if (insuExpeFlag != null && !insuExpeFlag.equals(other.getInsuExpeFlag()))
			return false;
		if (loanFalg == null && other.getLoanFalg() != null)
			return false;
		if (loanFalg != null && !loanFalg.equals(other.getLoanFalg()))
			return false;
		if (mortagageFlag == null && other.getMortagageFlag() != null)
			return false;
		if (mortagageFlag != null && !mortagageFlag.equals(other.getMortagageFlag()))
			return false;
		if (iDifReturnFlag == null && other.getIDifReturnFlag() != null)
			return false;
		if (iDifReturnFlag != null && !iDifReturnFlag.equals(other.getIDifReturnFlag()))
			return false;
		if (cutAmntStopPay == null && other.getCutAmntStopPay() != null)
			return false;
		if (cutAmntStopPay != null && !cutAmntStopPay.equals(other.getCutAmntStopPay()))
			return false;
		if (Double.doubleToLongBits(rinsRate) != Double.doubleToLongBits(other.getRinsRate()))
			return false;
		if (saleFlag == null && other.getSaleFlag() != null)
			return false;
		if (saleFlag != null && !saleFlag.equals(other.getSaleFlag()))
			return false;
		if (fileAppFlag == null && other.getFileAppFlag() != null)
			return false;
		if (fileAppFlag != null && !fileAppFlag.equals(other.getFileAppFlag()))
			return false;
		if (mngCom == null && other.getMngCom() != null)
			return false;
		if (mngCom != null && !mngCom.equals(other.getMngCom()))
			return false;
		if (autoPayFlag == null && other.getAutoPayFlag() != null)
			return false;
		if (autoPayFlag != null && !autoPayFlag.equals(other.getAutoPayFlag()))
			return false;
		if (needPrintHospital == null && other.getNeedPrintHospital() != null)
			return false;
		if (needPrintHospital != null && !needPrintHospital.equals(other.getNeedPrintHospital()))
			return false;
		if (needPrintGet == null && other.getNeedPrintGet() != null)
			return false;
		if (needPrintGet != null && !needPrintGet.equals(other.getNeedPrintGet()))
			return false;
		if (riskType3 == null && other.getRiskType3() != null)
			return false;
		if (riskType3 != null && !riskType3.equals(other.getRiskType3()))
			return false;
		if (riskType4 == null && other.getRiskType4() != null)
			return false;
		if (riskType4 != null && !riskType4.equals(other.getRiskType4()))
			return false;
		if (riskType5 == null && other.getRiskType5() != null)
			return false;
		if (riskType5 != null && !riskType5.equals(other.getRiskType5()))
			return false;
		if (notPrintPol == null && other.getNotPrintPol() != null)
			return false;
		if (notPrintPol != null && !notPrintPol.equals(other.getNotPrintPol()))
			return false;
		if (needGetPolDate == null && other.getNeedGetPolDate() != null)
			return false;
		if (needGetPolDate != null && !needGetPolDate.equals(other.getNeedGetPolDate()))
			return false;
		if (needReReadBank == null && other.getNeedReReadBank() != null)
			return false;
		if (needReReadBank != null && !needReReadBank.equals(other.getNeedReReadBank()))
			return false;
		if (specFlag == null && other.getSpecFlag() != null)
			return false;
		if (specFlag != null && !specFlag.equals(other.getSpecFlag()))
			return false;
		if (interestDifFlag == null && other.getInterestDifFlag() != null)
			return false;
		return interestDifFlag == null || interestDifFlag.equals(other.getInterestDifFlag());
	}

	public int getFieldCount()
	{
		return 63;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVer"))
			return 1;
		if (strFieldName.equals("riskName"))
			return 2;
		if (strFieldName.equals("kindCode"))
			return 3;
		if (strFieldName.equals("riskType"))
			return 4;
		if (strFieldName.equals("riskType1"))
			return 5;
		if (strFieldName.equals("riskType2"))
			return 6;
		if (strFieldName.equals("riskProp"))
			return 7;
		if (strFieldName.equals("riskPeriod"))
			return 8;
		if (strFieldName.equals("riskTypeDetail"))
			return 9;
		if (strFieldName.equals("riskFlag"))
			return 10;
		if (strFieldName.equals("polType"))
			return 11;
		if (strFieldName.equals("investFlag"))
			return 12;
		if (strFieldName.equals("bonusFlag"))
			return 13;
		if (strFieldName.equals("bonusMode"))
			return 14;
		if (strFieldName.equals("listFlag"))
			return 15;
		if (strFieldName.equals("subRiskFlag"))
			return 16;
		if (strFieldName.equals("calDigital"))
			return 17;
		if (strFieldName.equals("calChoMode"))
			return 18;
		if (strFieldName.equals("riskAmntMult"))
			return 19;
		if (strFieldName.equals("insuPeriodFlag"))
			return 20;
		if (strFieldName.equals("maxEndPeriod"))
			return 21;
		if (strFieldName.equals("ageLmt"))
			return 22;
		if (strFieldName.equals("signDateCalMode"))
			return 23;
		if (strFieldName.equals("protocolFlag"))
			return 24;
		if (strFieldName.equals("getChgFlag"))
			return 25;
		if (strFieldName.equals("protocolPayFlag"))
			return 26;
		if (strFieldName.equals("ensuPlanFlag"))
			return 27;
		if (strFieldName.equals("ensuPlanAdjFlag"))
			return 28;
		if (strFieldName.equals("startDate"))
			return 29;
		if (strFieldName.equals("endDate"))
			return 30;
		if (strFieldName.equals("minAppntAge"))
			return 31;
		if (strFieldName.equals("maxAppntAge"))
			return 32;
		if (strFieldName.equals("maxInsuredAge"))
			return 33;
		if (strFieldName.equals("minInsuredAge"))
			return 34;
		if (strFieldName.equals("appInterest"))
			return 35;
		if (strFieldName.equals("appPremRate"))
			return 36;
		if (strFieldName.equals("insuredFlag"))
			return 37;
		if (strFieldName.equals("shareFlag"))
			return 38;
		if (strFieldName.equals("bnfFlag"))
			return 39;
		if (strFieldName.equals("tempPayFlag"))
			return 40;
		if (strFieldName.equals("inpPayPlan"))
			return 41;
		if (strFieldName.equals("impartFlag"))
			return 42;
		if (strFieldName.equals("insuExpeFlag"))
			return 43;
		if (strFieldName.equals("loanFalg"))
			return 44;
		if (strFieldName.equals("mortagageFlag"))
			return 45;
		if (strFieldName.equals("iDifReturnFlag"))
			return 46;
		if (strFieldName.equals("cutAmntStopPay"))
			return 47;
		if (strFieldName.equals("rinsRate"))
			return 48;
		if (strFieldName.equals("saleFlag"))
			return 49;
		if (strFieldName.equals("fileAppFlag"))
			return 50;
		if (strFieldName.equals("mngCom"))
			return 51;
		if (strFieldName.equals("autoPayFlag"))
			return 52;
		if (strFieldName.equals("needPrintHospital"))
			return 53;
		if (strFieldName.equals("needPrintGet"))
			return 54;
		if (strFieldName.equals("riskType3"))
			return 55;
		if (strFieldName.equals("riskType4"))
			return 56;
		if (strFieldName.equals("riskType5"))
			return 57;
		if (strFieldName.equals("notPrintPol"))
			return 58;
		if (strFieldName.equals("needGetPolDate"))
			return 59;
		if (strFieldName.equals("needReReadBank"))
			return 60;
		if (strFieldName.equals("specFlag"))
			return 61;
		return !strFieldName.equals("interestDifFlag") ? -1 : 62;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "riskCode";
			break;

		case 1: // '\001'
			strFieldName = "riskVer";
			break;

		case 2: // '\002'
			strFieldName = "riskName";
			break;

		case 3: // '\003'
			strFieldName = "kindCode";
			break;

		case 4: // '\004'
			strFieldName = "riskType";
			break;

		case 5: // '\005'
			strFieldName = "riskType1";
			break;

		case 6: // '\006'
			strFieldName = "riskType2";
			break;

		case 7: // '\007'
			strFieldName = "riskProp";
			break;

		case 8: // '\b'
			strFieldName = "riskPeriod";
			break;

		case 9: // '\t'
			strFieldName = "riskTypeDetail";
			break;

		case 10: // '\n'
			strFieldName = "riskFlag";
			break;

		case 11: // '\013'
			strFieldName = "polType";
			break;

		case 12: // '\f'
			strFieldName = "investFlag";
			break;

		case 13: // '\r'
			strFieldName = "bonusFlag";
			break;

		case 14: // '\016'
			strFieldName = "bonusMode";
			break;

		case 15: // '\017'
			strFieldName = "listFlag";
			break;

		case 16: // '\020'
			strFieldName = "subRiskFlag";
			break;

		case 17: // '\021'
			strFieldName = "calDigital";
			break;

		case 18: // '\022'
			strFieldName = "calChoMode";
			break;

		case 19: // '\023'
			strFieldName = "riskAmntMult";
			break;

		case 20: // '\024'
			strFieldName = "insuPeriodFlag";
			break;

		case 21: // '\025'
			strFieldName = "maxEndPeriod";
			break;

		case 22: // '\026'
			strFieldName = "ageLmt";
			break;

		case 23: // '\027'
			strFieldName = "signDateCalMode";
			break;

		case 24: // '\030'
			strFieldName = "protocolFlag";
			break;

		case 25: // '\031'
			strFieldName = "getChgFlag";
			break;

		case 26: // '\032'
			strFieldName = "protocolPayFlag";
			break;

		case 27: // '\033'
			strFieldName = "ensuPlanFlag";
			break;

		case 28: // '\034'
			strFieldName = "ensuPlanAdjFlag";
			break;

		case 29: // '\035'
			strFieldName = "startDate";
			break;

		case 30: // '\036'
			strFieldName = "endDate";
			break;

		case 31: // '\037'
			strFieldName = "minAppntAge";
			break;

		case 32: // ' '
			strFieldName = "maxAppntAge";
			break;

		case 33: // '!'
			strFieldName = "maxInsuredAge";
			break;

		case 34: // '"'
			strFieldName = "minInsuredAge";
			break;

		case 35: // '#'
			strFieldName = "appInterest";
			break;

		case 36: // '$'
			strFieldName = "appPremRate";
			break;

		case 37: // '%'
			strFieldName = "insuredFlag";
			break;

		case 38: // '&'
			strFieldName = "shareFlag";
			break;

		case 39: // '\''
			strFieldName = "bnfFlag";
			break;

		case 40: // '('
			strFieldName = "tempPayFlag";
			break;

		case 41: // ')'
			strFieldName = "inpPayPlan";
			break;

		case 42: // '*'
			strFieldName = "impartFlag";
			break;

		case 43: // '+'
			strFieldName = "insuExpeFlag";
			break;

		case 44: // ','
			strFieldName = "loanFalg";
			break;

		case 45: // '-'
			strFieldName = "mortagageFlag";
			break;

		case 46: // '.'
			strFieldName = "iDifReturnFlag";
			break;

		case 47: // '/'
			strFieldName = "cutAmntStopPay";
			break;

		case 48: // '0'
			strFieldName = "rinsRate";
			break;

		case 49: // '1'
			strFieldName = "saleFlag";
			break;

		case 50: // '2'
			strFieldName = "fileAppFlag";
			break;

		case 51: // '3'
			strFieldName = "mngCom";
			break;

		case 52: // '4'
			strFieldName = "autoPayFlag";
			break;

		case 53: // '5'
			strFieldName = "needPrintHospital";
			break;

		case 54: // '6'
			strFieldName = "needPrintGet";
			break;

		case 55: // '7'
			strFieldName = "riskType3";
			break;

		case 56: // '8'
			strFieldName = "riskType4";
			break;

		case 57: // '9'
			strFieldName = "riskType5";
			break;

		case 58: // ':'
			strFieldName = "notPrintPol";
			break;

		case 59: // ';'
			strFieldName = "needGetPolDate";
			break;

		case 60: // '<'
			strFieldName = "needReReadBank";
			break;

		case 61: // '='
			strFieldName = "specFlag";
			break;

		case 62: // '>'
			strFieldName = "interestDifFlag";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVer"))
			return 0;
		if (strFieldName.equals("riskName"))
			return 0;
		if (strFieldName.equals("kindCode"))
			return 0;
		if (strFieldName.equals("riskType"))
			return 0;
		if (strFieldName.equals("riskType1"))
			return 0;
		if (strFieldName.equals("riskType2"))
			return 0;
		if (strFieldName.equals("riskProp"))
			return 0;
		if (strFieldName.equals("riskPeriod"))
			return 0;
		if (strFieldName.equals("riskTypeDetail"))
			return 0;
		if (strFieldName.equals("riskFlag"))
			return 0;
		if (strFieldName.equals("polType"))
			return 0;
		if (strFieldName.equals("investFlag"))
			return 0;
		if (strFieldName.equals("bonusFlag"))
			return 0;
		if (strFieldName.equals("bonusMode"))
			return 0;
		if (strFieldName.equals("listFlag"))
			return 0;
		if (strFieldName.equals("subRiskFlag"))
			return 0;
		if (strFieldName.equals("calDigital"))
			return 3;
		if (strFieldName.equals("calChoMode"))
			return 0;
		if (strFieldName.equals("riskAmntMult"))
			return 3;
		if (strFieldName.equals("insuPeriodFlag"))
			return 0;
		if (strFieldName.equals("maxEndPeriod"))
			return 3;
		if (strFieldName.equals("ageLmt"))
			return 3;
		if (strFieldName.equals("signDateCalMode"))
			return 3;
		if (strFieldName.equals("protocolFlag"))
			return 0;
		if (strFieldName.equals("getChgFlag"))
			return 0;
		if (strFieldName.equals("protocolPayFlag"))
			return 0;
		if (strFieldName.equals("ensuPlanFlag"))
			return 0;
		if (strFieldName.equals("ensuPlanAdjFlag"))
			return 0;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("endDate"))
			return 1;
		if (strFieldName.equals("minAppntAge"))
			return 3;
		if (strFieldName.equals("maxAppntAge"))
			return 3;
		if (strFieldName.equals("maxInsuredAge"))
			return 3;
		if (strFieldName.equals("minInsuredAge"))
			return 3;
		if (strFieldName.equals("appInterest"))
			return 4;
		if (strFieldName.equals("appPremRate"))
			return 4;
		if (strFieldName.equals("insuredFlag"))
			return 0;
		if (strFieldName.equals("shareFlag"))
			return 0;
		if (strFieldName.equals("bnfFlag"))
			return 0;
		if (strFieldName.equals("tempPayFlag"))
			return 0;
		if (strFieldName.equals("inpPayPlan"))
			return 0;
		if (strFieldName.equals("impartFlag"))
			return 0;
		if (strFieldName.equals("insuExpeFlag"))
			return 0;
		if (strFieldName.equals("loanFalg"))
			return 0;
		if (strFieldName.equals("mortagageFlag"))
			return 0;
		if (strFieldName.equals("iDifReturnFlag"))
			return 0;
		if (strFieldName.equals("cutAmntStopPay"))
			return 0;
		if (strFieldName.equals("rinsRate"))
			return 4;
		if (strFieldName.equals("saleFlag"))
			return 0;
		if (strFieldName.equals("fileAppFlag"))
			return 0;
		if (strFieldName.equals("mngCom"))
			return 0;
		if (strFieldName.equals("autoPayFlag"))
			return 0;
		if (strFieldName.equals("needPrintHospital"))
			return 0;
		if (strFieldName.equals("needPrintGet"))
			return 0;
		if (strFieldName.equals("riskType3"))
			return 0;
		if (strFieldName.equals("riskType4"))
			return 0;
		if (strFieldName.equals("riskType5"))
			return 0;
		if (strFieldName.equals("notPrintPol"))
			return 0;
		if (strFieldName.equals("needGetPolDate"))
			return 0;
		if (strFieldName.equals("needReReadBank"))
			return 0;
		if (strFieldName.equals("specFlag"))
			return 0;
		return !strFieldName.equals("interestDifFlag") ? -1 : 0;
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
			nFieldType = 3;
			break;

		case 18: // '\022'
			nFieldType = 0;
			break;

		case 19: // '\023'
			nFieldType = 3;
			break;

		case 20: // '\024'
			nFieldType = 0;
			break;

		case 21: // '\025'
			nFieldType = 3;
			break;

		case 22: // '\026'
			nFieldType = 3;
			break;

		case 23: // '\027'
			nFieldType = 3;
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
			nFieldType = 0;
			break;

		case 28: // '\034'
			nFieldType = 0;
			break;

		case 29: // '\035'
			nFieldType = 1;
			break;

		case 30: // '\036'
			nFieldType = 1;
			break;

		case 31: // '\037'
			nFieldType = 3;
			break;

		case 32: // ' '
			nFieldType = 3;
			break;

		case 33: // '!'
			nFieldType = 3;
			break;

		case 34: // '"'
			nFieldType = 3;
			break;

		case 35: // '#'
			nFieldType = 4;
			break;

		case 36: // '$'
			nFieldType = 4;
			break;

		case 37: // '%'
			nFieldType = 0;
			break;

		case 38: // '&'
			nFieldType = 0;
			break;

		case 39: // '\''
			nFieldType = 0;
			break;

		case 40: // '('
			nFieldType = 0;
			break;

		case 41: // ')'
			nFieldType = 0;
			break;

		case 42: // '*'
			nFieldType = 0;
			break;

		case 43: // '+'
			nFieldType = 0;
			break;

		case 44: // ','
			nFieldType = 0;
			break;

		case 45: // '-'
			nFieldType = 0;
			break;

		case 46: // '.'
			nFieldType = 0;
			break;

		case 47: // '/'
			nFieldType = 0;
			break;

		case 48: // '0'
			nFieldType = 4;
			break;

		case 49: // '1'
			nFieldType = 0;
			break;

		case 50: // '2'
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 56: // '8'
			nFieldType = 0;
			break;

		case 57: // '9'
			nFieldType = 0;
			break;

		case 58: // ':'
			nFieldType = 0;
			break;

		case 59: // ';'
			nFieldType = 0;
			break;

		case 60: // '<'
			nFieldType = 0;
			break;

		case 61: // '='
			nFieldType = 0;
			break;

		case 62: // '>'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
