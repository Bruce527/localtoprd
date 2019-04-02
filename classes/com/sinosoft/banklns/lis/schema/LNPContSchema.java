// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPContSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPContDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPContSchema
	implements Schema, Cloneable
{

	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private String prtNo;
	private String mainPolNo;
	private String contType;
	private String familyType;
	private String familyID;
	private String polType;
	private String sugNo;
	private String cardFlag;
	private String manageCom;
	private String executeCom;
	private String agentCom;
	private String agentCode;
	private String agentGroup;
	private String agentCode1;
	private String agentGroup1;
	private String agentType;
	private String saleChnl;
	private String handler;
	private String password;
	private String appntNo;
	private String appntId;
	private String appntName;
	private String appntSex;
	private Date appntBirthday;
	private String appntIDType;
	private String appntIDNo;
	private String insuredNo;
	private String insuredId;
	private String insuredName;
	private String insuredSex;
	private Date insuredBirthday;
	private String insuredIDType;
	private String insuredIDNo;
	private int payIntv;
	private String payMode;
	private String payLocation;
	private String disputedFlag;
	private String outPayFlag;
	private String getPolMode;
	private String signCom;
	private Date signDate;
	private String signTime;
	private String consignNo;
	private String bankCode;
	private String bankAccNo;
	private String accName;
	private int printCount;
	private int lostTimes;
	private String lang;
	private String currency;
	private String remark;
	private int peoples;
	private double mult;
	private double prem;
	private double amnt;
	private double sumPrem;
	private double dif;
	private Date paytoDate;
	private Date firstPayDate;
	private Date cValiDate;
	private Date pSignDate;
	private Date pValiDate;
	private String inputOperator;
	private Date inputDate;
	private String inputTime;
	private String approveFlag;
	private String approveCode;
	private Date approveDate;
	private String approveTime;
	private String uWFlag;
	private String uWOperator;
	private Date uWDate;
	private String uWTime;
	private String appFlag;
	private Date polApplyDate;
	private Date getPolDate;
	private String getPolTime;
	private Date customGetPolDate;
	private String state;
	private String saleChnlDetail;
	private String proposalType;
	private String editstate;
	private Date cInValiDate;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 91;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPContSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ContNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPContSchema cloned = (LNPContSchema)super.clone();
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

	public String getPrtNo()
	{
		return prtNo;
	}

	public void setPrtNo(String aPrtNo)
	{
		prtNo = aPrtNo;
	}

	public String getMainPolNo()
	{
		return mainPolNo;
	}

	public void setMainPolNo(String aMainPolNo)
	{
		mainPolNo = aMainPolNo;
	}

	public String getContType()
	{
		return contType;
	}

	public void setContType(String aContType)
	{
		contType = aContType;
	}

	public String getFamilyType()
	{
		return familyType;
	}

	public void setFamilyType(String aFamilyType)
	{
		familyType = aFamilyType;
	}

	public String getFamilyID()
	{
		return familyID;
	}

	public void setFamilyID(String aFamilyID)
	{
		familyID = aFamilyID;
	}

	public String getPolType()
	{
		return polType;
	}

	public void setPolType(String aPolType)
	{
		polType = aPolType;
	}

	public String getSugNo()
	{
		return sugNo;
	}

	public void setSugNo(String aSugNo)
	{
		sugNo = aSugNo;
	}

	public String getCardFlag()
	{
		return cardFlag;
	}

	public void setCardFlag(String aCardFlag)
	{
		cardFlag = aCardFlag;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getExecuteCom()
	{
		return executeCom;
	}

	public void setExecuteCom(String aExecuteCom)
	{
		executeCom = aExecuteCom;
	}

	public String getAgentCom()
	{
		return agentCom;
	}

	public void setAgentCom(String aAgentCom)
	{
		agentCom = aAgentCom;
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

	public String getAgentCode1()
	{
		return agentCode1;
	}

	public void setAgentCode1(String aAgentCode1)
	{
		agentCode1 = aAgentCode1;
	}

	public String getAgentGroup1()
	{
		return agentGroup1;
	}

	public void setAgentGroup1(String aAgentGroup1)
	{
		agentGroup1 = aAgentGroup1;
	}

	public String getAgentType()
	{
		return agentType;
	}

	public void setAgentType(String aAgentType)
	{
		agentType = aAgentType;
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String aPassword)
	{
		password = aPassword;
	}

	public String getAppntNo()
	{
		return appntNo;
	}

	public void setAppntNo(String aAppntNo)
	{
		appntNo = aAppntNo;
	}

	public String getAppntId()
	{
		return appntId;
	}

	public void setAppntId(String aAppntId)
	{
		appntId = aAppntId;
	}

	public String getAppntName()
	{
		return appntName;
	}

	public void setAppntName(String aAppntName)
	{
		appntName = aAppntName;
	}

	public String getAppntSex()
	{
		return appntSex;
	}

	public void setAppntSex(String aAppntSex)
	{
		appntSex = aAppntSex;
	}

	public String getAppntBirthday()
	{
		if (appntBirthday != null)
			return fDate.getString(appntBirthday);
		else
			return null;
	}

	public void setAppntBirthday(Date aAppntBirthday)
	{
		appntBirthday = aAppntBirthday;
	}

	public void setAppntBirthday(String aAppntBirthday)
	{
		if (aAppntBirthday != null && !aAppntBirthday.equals(""))
			appntBirthday = fDate.getDate(aAppntBirthday);
		else
			appntBirthday = null;
	}

	public String getAppntIDType()
	{
		return appntIDType;
	}

	public void setAppntIDType(String aAppntIDType)
	{
		appntIDType = aAppntIDType;
	}

	public String getAppntIDNo()
	{
		return appntIDNo;
	}

	public void setAppntIDNo(String aAppntIDNo)
	{
		appntIDNo = aAppntIDNo;
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

	public String getInsuredIDType()
	{
		return insuredIDType;
	}

	public void setInsuredIDType(String aInsuredIDType)
	{
		insuredIDType = aInsuredIDType;
	}

	public String getInsuredIDNo()
	{
		return insuredIDNo;
	}

	public void setInsuredIDNo(String aInsuredIDNo)
	{
		insuredIDNo = aInsuredIDNo;
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

	public String getDisputedFlag()
	{
		return disputedFlag;
	}

	public void setDisputedFlag(String aDisputedFlag)
	{
		disputedFlag = aDisputedFlag;
	}

	public String getOutPayFlag()
	{
		return outPayFlag;
	}

	public void setOutPayFlag(String aOutPayFlag)
	{
		outPayFlag = aOutPayFlag;
	}

	public String getGetPolMode()
	{
		return getPolMode;
	}

	public void setGetPolMode(String aGetPolMode)
	{
		getPolMode = aGetPolMode;
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

	public String getConsignNo()
	{
		return consignNo;
	}

	public void setConsignNo(String aConsignNo)
	{
		consignNo = aConsignNo;
	}

	public String getBankCode()
	{
		return bankCode;
	}

	public void setBankCode(String aBankCode)
	{
		bankCode = aBankCode;
	}

	public String getBankAccNo()
	{
		return bankAccNo;
	}

	public void setBankAccNo(String aBankAccNo)
	{
		bankAccNo = aBankAccNo;
	}

	public String getAccName()
	{
		return accName;
	}

	public void setAccName(String aAccName)
	{
		accName = aAccName;
	}

	public int getPrintCount()
	{
		return printCount;
	}

	public void setPrintCount(int aPrintCount)
	{
		printCount = aPrintCount;
	}

	public void setPrintCount(String aPrintCount)
	{
		if (aPrintCount != null && !aPrintCount.equals(""))
		{
			Integer tInteger = new Integer(aPrintCount);
			int i = tInteger.intValue();
			printCount = i;
		}
	}

	public int getLostTimes()
	{
		return lostTimes;
	}

	public void setLostTimes(int aLostTimes)
	{
		lostTimes = aLostTimes;
	}

	public void setLostTimes(String aLostTimes)
	{
		if (aLostTimes != null && !aLostTimes.equals(""))
		{
			Integer tInteger = new Integer(aLostTimes);
			int i = tInteger.intValue();
			lostTimes = i;
		}
	}

	public String getLang()
	{
		return lang;
	}

	public void setLang(String aLang)
	{
		lang = aLang;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String aCurrency)
	{
		currency = aCurrency;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String aRemark)
	{
		remark = aRemark;
	}

	public int getPeoples()
	{
		return peoples;
	}

	public void setPeoples(int aPeoples)
	{
		peoples = aPeoples;
	}

	public void setPeoples(String aPeoples)
	{
		if (aPeoples != null && !aPeoples.equals(""))
		{
			Integer tInteger = new Integer(aPeoples);
			int i = tInteger.intValue();
			peoples = i;
		}
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

	public double getDif()
	{
		return dif;
	}

	public void setDif(double aDif)
	{
		dif = aDif;
	}

	public void setDif(String aDif)
	{
		if (aDif != null && !aDif.equals(""))
		{
			Double tDouble = new Double(aDif);
			double d = tDouble.doubleValue();
			dif = d;
		}
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

	public String getPSignDate()
	{
		if (pSignDate != null)
			return fDate.getString(pSignDate);
		else
			return null;
	}

	public void setPSignDate(Date aPSignDate)
	{
		pSignDate = aPSignDate;
	}

	public void setPSignDate(String aPSignDate)
	{
		if (aPSignDate != null && !aPSignDate.equals(""))
			pSignDate = fDate.getDate(aPSignDate);
		else
			pSignDate = null;
	}

	public String getPValiDate()
	{
		if (pValiDate != null)
			return fDate.getString(pValiDate);
		else
			return null;
	}

	public void setPValiDate(Date aPValiDate)
	{
		pValiDate = aPValiDate;
	}

	public void setPValiDate(String aPValiDate)
	{
		if (aPValiDate != null && !aPValiDate.equals(""))
			pValiDate = fDate.getDate(aPValiDate);
		else
			pValiDate = null;
	}

	public String getInputOperator()
	{
		return inputOperator;
	}

	public void setInputOperator(String aInputOperator)
	{
		inputOperator = aInputOperator;
	}

	public String getInputDate()
	{
		if (inputDate != null)
			return fDate.getString(inputDate);
		else
			return null;
	}

	public void setInputDate(Date aInputDate)
	{
		inputDate = aInputDate;
	}

	public void setInputDate(String aInputDate)
	{
		if (aInputDate != null && !aInputDate.equals(""))
			inputDate = fDate.getDate(aInputDate);
		else
			inputDate = null;
	}

	public String getInputTime()
	{
		return inputTime;
	}

	public void setInputTime(String aInputTime)
	{
		inputTime = aInputTime;
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

	public String getUWOperator()
	{
		return uWOperator;
	}

	public void setUWOperator(String aUWOperator)
	{
		uWOperator = aUWOperator;
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

	public String getAppFlag()
	{
		return appFlag;
	}

	public void setAppFlag(String aAppFlag)
	{
		appFlag = aAppFlag;
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

	public String getGetPolDate()
	{
		if (getPolDate != null)
			return fDate.getString(getPolDate);
		else
			return null;
	}

	public void setGetPolDate(Date aGetPolDate)
	{
		getPolDate = aGetPolDate;
	}

	public void setGetPolDate(String aGetPolDate)
	{
		if (aGetPolDate != null && !aGetPolDate.equals(""))
			getPolDate = fDate.getDate(aGetPolDate);
		else
			getPolDate = null;
	}

	public String getGetPolTime()
	{
		return getPolTime;
	}

	public void setGetPolTime(String aGetPolTime)
	{
		getPolTime = aGetPolTime;
	}

	public String getCustomGetPolDate()
	{
		if (customGetPolDate != null)
			return fDate.getString(customGetPolDate);
		else
			return null;
	}

	public void setCustomGetPolDate(Date aCustomGetPolDate)
	{
		customGetPolDate = aCustomGetPolDate;
	}

	public void setCustomGetPolDate(String aCustomGetPolDate)
	{
		if (aCustomGetPolDate != null && !aCustomGetPolDate.equals(""))
			customGetPolDate = fDate.getDate(aCustomGetPolDate);
		else
			customGetPolDate = null;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getSaleChnlDetail()
	{
		return saleChnlDetail;
	}

	public void setSaleChnlDetail(String aSaleChnlDetail)
	{
		saleChnlDetail = aSaleChnlDetail;
	}

	public String getProposalType()
	{
		return proposalType;
	}

	public void setProposalType(String aProposalType)
	{
		proposalType = aProposalType;
	}

	public String getEditstate()
	{
		return editstate;
	}

	public void setEditstate(String aEditstate)
	{
		editstate = aEditstate;
	}

	public String getCInValiDate()
	{
		if (cInValiDate != null)
			return fDate.getString(cInValiDate);
		else
			return null;
	}

	public void setCInValiDate(Date aCInValiDate)
	{
		cInValiDate = aCInValiDate;
	}

	public void setCInValiDate(String aCInValiDate)
	{
		if (aCInValiDate != null && !aCInValiDate.equals(""))
			cInValiDate = fDate.getDate(aCInValiDate);
		else
			cInValiDate = null;
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

	public void setSchema(LNPContSchema aLNPContSchema)
	{
		grpContNo = aLNPContSchema.getGrpContNo();
		contNo = aLNPContSchema.getContNo();
		proposalContNo = aLNPContSchema.getProposalContNo();
		prtNo = aLNPContSchema.getPrtNo();
		mainPolNo = aLNPContSchema.getMainPolNo();
		contType = aLNPContSchema.getContType();
		familyType = aLNPContSchema.getFamilyType();
		familyID = aLNPContSchema.getFamilyID();
		polType = aLNPContSchema.getPolType();
		sugNo = aLNPContSchema.getSugNo();
		cardFlag = aLNPContSchema.getCardFlag();
		manageCom = aLNPContSchema.getManageCom();
		executeCom = aLNPContSchema.getExecuteCom();
		agentCom = aLNPContSchema.getAgentCom();
		agentCode = aLNPContSchema.getAgentCode();
		agentGroup = aLNPContSchema.getAgentGroup();
		agentCode1 = aLNPContSchema.getAgentCode1();
		agentGroup1 = aLNPContSchema.getAgentGroup1();
		agentType = aLNPContSchema.getAgentType();
		saleChnl = aLNPContSchema.getSaleChnl();
		handler = aLNPContSchema.getHandler();
		password = aLNPContSchema.getPassword();
		appntNo = aLNPContSchema.getAppntNo();
		appntId = aLNPContSchema.getAppntId();
		appntName = aLNPContSchema.getAppntName();
		appntSex = aLNPContSchema.getAppntSex();
		appntBirthday = fDate.getDate(aLNPContSchema.getAppntBirthday());
		appntIDType = aLNPContSchema.getAppntIDType();
		appntIDNo = aLNPContSchema.getAppntIDNo();
		insuredNo = aLNPContSchema.getInsuredNo();
		insuredId = aLNPContSchema.getInsuredId();
		insuredName = aLNPContSchema.getInsuredName();
		insuredSex = aLNPContSchema.getInsuredSex();
		insuredBirthday = fDate.getDate(aLNPContSchema.getInsuredBirthday());
		insuredIDType = aLNPContSchema.getInsuredIDType();
		insuredIDNo = aLNPContSchema.getInsuredIDNo();
		payIntv = aLNPContSchema.getPayIntv();
		payMode = aLNPContSchema.getPayMode();
		payLocation = aLNPContSchema.getPayLocation();
		disputedFlag = aLNPContSchema.getDisputedFlag();
		outPayFlag = aLNPContSchema.getOutPayFlag();
		getPolMode = aLNPContSchema.getGetPolMode();
		signCom = aLNPContSchema.getSignCom();
		signDate = fDate.getDate(aLNPContSchema.getSignDate());
		signTime = aLNPContSchema.getSignTime();
		consignNo = aLNPContSchema.getConsignNo();
		bankCode = aLNPContSchema.getBankCode();
		bankAccNo = aLNPContSchema.getBankAccNo();
		accName = aLNPContSchema.getAccName();
		printCount = aLNPContSchema.getPrintCount();
		lostTimes = aLNPContSchema.getLostTimes();
		lang = aLNPContSchema.getLang();
		currency = aLNPContSchema.getCurrency();
		remark = aLNPContSchema.getRemark();
		peoples = aLNPContSchema.getPeoples();
		mult = aLNPContSchema.getMult();
		prem = aLNPContSchema.getPrem();
		amnt = aLNPContSchema.getAmnt();
		sumPrem = aLNPContSchema.getSumPrem();
		dif = aLNPContSchema.getDif();
		paytoDate = fDate.getDate(aLNPContSchema.getPaytoDate());
		firstPayDate = fDate.getDate(aLNPContSchema.getFirstPayDate());
		cValiDate = fDate.getDate(aLNPContSchema.getCValiDate());
		pSignDate = fDate.getDate(aLNPContSchema.getPSignDate());
		pValiDate = fDate.getDate(aLNPContSchema.getPValiDate());
		inputOperator = aLNPContSchema.getInputOperator();
		inputDate = fDate.getDate(aLNPContSchema.getInputDate());
		inputTime = aLNPContSchema.getInputTime();
		approveFlag = aLNPContSchema.getApproveFlag();
		approveCode = aLNPContSchema.getApproveCode();
		approveDate = fDate.getDate(aLNPContSchema.getApproveDate());
		approveTime = aLNPContSchema.getApproveTime();
		uWFlag = aLNPContSchema.getUWFlag();
		uWOperator = aLNPContSchema.getUWOperator();
		uWDate = fDate.getDate(aLNPContSchema.getUWDate());
		uWTime = aLNPContSchema.getUWTime();
		appFlag = aLNPContSchema.getAppFlag();
		polApplyDate = fDate.getDate(aLNPContSchema.getPolApplyDate());
		getPolDate = fDate.getDate(aLNPContSchema.getGetPolDate());
		getPolTime = aLNPContSchema.getGetPolTime();
		customGetPolDate = fDate.getDate(aLNPContSchema.getCustomGetPolDate());
		state = aLNPContSchema.getState();
		saleChnlDetail = aLNPContSchema.getSaleChnlDetail();
		proposalType = aLNPContSchema.getProposalType();
		editstate = aLNPContSchema.getEditstate();
		cInValiDate = fDate.getDate(aLNPContSchema.getCInValiDate());
		operator = aLNPContSchema.getOperator();
		makeDate = fDate.getDate(aLNPContSchema.getMakeDate());
		makeTime = aLNPContSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPContSchema.getModifyDate());
		modifyTime = aLNPContSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("GrpContNo") == null)
				grpContNo = null;
			else
				grpContNo = rs.getString("GrpContNo").trim();
			if (rs.getString("ContNo") == null)
				contNo = null;
			else
				contNo = rs.getString("ContNo").trim();
			if (rs.getString("ProposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("ProposalContNo").trim();
			if (rs.getString("PrtNo") == null)
				prtNo = null;
			else
				prtNo = rs.getString("PrtNo").trim();
			if (rs.getString("MainPolNo") == null)
				mainPolNo = null;
			else
				mainPolNo = rs.getString("MainPolNo").trim();
			if (rs.getString("ContType") == null)
				contType = null;
			else
				contType = rs.getString("ContType").trim();
			if (rs.getString("FamilyType") == null)
				familyType = null;
			else
				familyType = rs.getString("FamilyType").trim();
			if (rs.getString("FamilyID") == null)
				familyID = null;
			else
				familyID = rs.getString("FamilyID").trim();
			if (rs.getString("PolType") == null)
				polType = null;
			else
				polType = rs.getString("PolType").trim();
			if (rs.getString("SugNo") == null)
				sugNo = null;
			else
				sugNo = rs.getString("SugNo").trim();
			if (rs.getString("CardFlag") == null)
				cardFlag = null;
			else
				cardFlag = rs.getString("CardFlag").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("ExecuteCom") == null)
				executeCom = null;
			else
				executeCom = rs.getString("ExecuteCom").trim();
			if (rs.getString("AgentCom") == null)
				agentCom = null;
			else
				agentCom = rs.getString("AgentCom").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("AgentGroup") == null)
				agentGroup = null;
			else
				agentGroup = rs.getString("AgentGroup").trim();
			if (rs.getString("AgentCode1") == null)
				agentCode1 = null;
			else
				agentCode1 = rs.getString("AgentCode1").trim();
			if (rs.getString("AgentGroup1") == null)
				agentGroup1 = null;
			else
				agentGroup1 = rs.getString("AgentGroup1").trim();
			if (rs.getString("AgentType") == null)
				agentType = null;
			else
				agentType = rs.getString("AgentType").trim();
			if (rs.getString("SaleChnl") == null)
				saleChnl = null;
			else
				saleChnl = rs.getString("SaleChnl").trim();
			if (rs.getString("Handler") == null)
				handler = null;
			else
				handler = rs.getString("Handler").trim();
			if (rs.getString("Password") == null)
				password = null;
			else
				password = rs.getString("Password").trim();
			if (rs.getString("AppntNo") == null)
				appntNo = null;
			else
				appntNo = rs.getString("AppntNo").trim();
			if (rs.getString("AppntId") == null)
				appntId = null;
			else
				appntId = rs.getString("AppntId").trim();
			if (rs.getString("AppntName") == null)
				appntName = null;
			else
				appntName = rs.getString("AppntName").trim();
			if (rs.getString("AppntSex") == null)
				appntSex = null;
			else
				appntSex = rs.getString("AppntSex").trim();
			appntBirthday = rs.getDate("AppntBirthday");
			if (rs.getString("AppntIDType") == null)
				appntIDType = null;
			else
				appntIDType = rs.getString("AppntIDType").trim();
			if (rs.getString("AppntIDNo") == null)
				appntIDNo = null;
			else
				appntIDNo = rs.getString("AppntIDNo").trim();
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
			if (rs.getString("InsuredIDType") == null)
				insuredIDType = null;
			else
				insuredIDType = rs.getString("InsuredIDType").trim();
			if (rs.getString("InsuredIDNo") == null)
				insuredIDNo = null;
			else
				insuredIDNo = rs.getString("InsuredIDNo").trim();
			payIntv = rs.getInt("PayIntv");
			if (rs.getString("PayMode") == null)
				payMode = null;
			else
				payMode = rs.getString("PayMode").trim();
			if (rs.getString("PayLocation") == null)
				payLocation = null;
			else
				payLocation = rs.getString("PayLocation").trim();
			if (rs.getString("DisputedFlag") == null)
				disputedFlag = null;
			else
				disputedFlag = rs.getString("DisputedFlag").trim();
			if (rs.getString("OutPayFlag") == null)
				outPayFlag = null;
			else
				outPayFlag = rs.getString("OutPayFlag").trim();
			if (rs.getString("GetPolMode") == null)
				getPolMode = null;
			else
				getPolMode = rs.getString("GetPolMode").trim();
			if (rs.getString("SignCom") == null)
				signCom = null;
			else
				signCom = rs.getString("SignCom").trim();
			signDate = rs.getDate("SignDate");
			if (rs.getString("SignTime") == null)
				signTime = null;
			else
				signTime = rs.getString("SignTime").trim();
			if (rs.getString("ConsignNo") == null)
				consignNo = null;
			else
				consignNo = rs.getString("ConsignNo").trim();
			if (rs.getString("BankCode") == null)
				bankCode = null;
			else
				bankCode = rs.getString("BankCode").trim();
			if (rs.getString("BankAccNo") == null)
				bankAccNo = null;
			else
				bankAccNo = rs.getString("BankAccNo").trim();
			if (rs.getString("AccName") == null)
				accName = null;
			else
				accName = rs.getString("AccName").trim();
			printCount = rs.getInt("PrintCount");
			lostTimes = rs.getInt("LostTimes");
			if (rs.getString("Lang") == null)
				lang = null;
			else
				lang = rs.getString("Lang").trim();
			if (rs.getString("Currency") == null)
				currency = null;
			else
				currency = rs.getString("Currency").trim();
			if (rs.getString("Remark") == null)
				remark = null;
			else
				remark = rs.getString("Remark").trim();
			peoples = rs.getInt("Peoples");
			mult = rs.getDouble("Mult");
			prem = rs.getDouble("Prem");
			amnt = rs.getDouble("Amnt");
			sumPrem = rs.getDouble("SumPrem");
			dif = rs.getDouble("Dif");
			paytoDate = rs.getDate("PaytoDate");
			firstPayDate = rs.getDate("FirstPayDate");
			cValiDate = rs.getDate("CValiDate");
			pSignDate = rs.getDate("PSignDate");
			pValiDate = rs.getDate("PValiDate");
			if (rs.getString("InputOperator") == null)
				inputOperator = null;
			else
				inputOperator = rs.getString("InputOperator").trim();
			inputDate = rs.getDate("InputDate");
			if (rs.getString("InputTime") == null)
				inputTime = null;
			else
				inputTime = rs.getString("InputTime").trim();
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
			if (rs.getString("UWOperator") == null)
				uWOperator = null;
			else
				uWOperator = rs.getString("UWOperator").trim();
			uWDate = rs.getDate("UWDate");
			if (rs.getString("UWTime") == null)
				uWTime = null;
			else
				uWTime = rs.getString("UWTime").trim();
			if (rs.getString("AppFlag") == null)
				appFlag = null;
			else
				appFlag = rs.getString("AppFlag").trim();
			polApplyDate = rs.getDate("PolApplyDate");
			getPolDate = rs.getDate("GetPolDate");
			if (rs.getString("GetPolTime") == null)
				getPolTime = null;
			else
				getPolTime = rs.getString("GetPolTime").trim();
			customGetPolDate = rs.getDate("CustomGetPolDate");
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			if (rs.getString("SaleChnlDetail") == null)
				saleChnlDetail = null;
			else
				saleChnlDetail = rs.getString("SaleChnlDetail").trim();
			if (rs.getString("ProposalType") == null)
				proposalType = null;
			else
				proposalType = rs.getString("ProposalType").trim();
			if (rs.getString("Editstate") == null)
				editstate = null;
			else
				editstate = rs.getString("Editstate").trim();
			cInValiDate = rs.getDate("CInValiDate");
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
			System.out.println("数据库中的LNPCont表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPContSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPContSchema getSchema()
	{
		LNPContSchema aLNPContSchema = new LNPContSchema();
		aLNPContSchema.setSchema(this);
		return aLNPContSchema;
	}

	public LNPContDB getDB()
	{
		LNPContDB aDBOper = new LNPContDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(grpContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proposalContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(prtNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mainPolNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(familyType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(familyID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(polType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sugNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(cardFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(executeCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGroup));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGroup1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(saleChnl));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(handler));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(password));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntSex));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(appntBirthday)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntIDType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntIDNo));
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
		strReturn.append(StrTool.cTrim(insuredIDType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredIDNo));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(payIntv));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payLocation));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(disputedFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(outPayFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getPolMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(signCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(signDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(signTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(consignNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bankCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bankAccNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(accName));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(printCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lostTimes));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(lang));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(currency));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remark));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(peoples));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(mult));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(prem));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(amnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sumPrem));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(dif));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(paytoDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(firstPayDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(cValiDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(pSignDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(pValiDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(inputOperator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(inputDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(inputTime));
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
		strReturn.append(StrTool.cTrim(uWOperator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(uWDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(polApplyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(getPolDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getPolTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(customGetPolDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(saleChnlDetail));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proposalType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(editstate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(cInValiDate)));
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
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			mainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			contType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			familyType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			familyID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			polType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			sugNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			cardFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			executeCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			agentCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			agentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			agentGroup1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			agentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			handler = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			appntSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			appntBirthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
			appntIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			appntIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			insuredSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			insuredBirthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|"));
			insuredIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			insuredIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
			payIntv = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 37, "|")))).intValue();
			payMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			payLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			disputedFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			outPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			getPolMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			signCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			signDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|"));
			signTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			consignNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			printCount = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 50, "|")))).intValue();
			lostTimes = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|")))).intValue();
			lang = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			currency = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
			remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
			peoples = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 55, "|")))).intValue();
			mult = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|")))).doubleValue();
			prem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|")))).doubleValue();
			amnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|")))).doubleValue();
			sumPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|")))).doubleValue();
			dif = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|")))).doubleValue();
			paytoDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 61, "|"));
			firstPayDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, "|"));
			cValiDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, "|"));
			pSignDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, "|"));
			pValiDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 65, "|"));
			inputOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 66, "|");
			inputDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 67, "|"));
			inputTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 68, "|");
			approveFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 69, "|");
			approveCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 70, "|");
			approveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 71, "|"));
			approveTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 72, "|");
			uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 73, "|");
			uWOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 74, "|");
			uWDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 75, "|"));
			uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76, "|");
			appFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, "|");
			polApplyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, "|"));
			getPolDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, "|"));
			getPolTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, "|");
			customGetPolDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, "|"));
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82, "|");
			saleChnlDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, "|");
			proposalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, "|");
			editstate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, "|");
			cInValiDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, "|"));
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPContSchema";
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
		if (FCode.equalsIgnoreCase("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equalsIgnoreCase("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equalsIgnoreCase("prtNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prtNo));
		if (FCode.equalsIgnoreCase("mainPolNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mainPolNo));
		if (FCode.equalsIgnoreCase("contType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contType));
		if (FCode.equalsIgnoreCase("familyType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(familyType));
		if (FCode.equalsIgnoreCase("familyID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(familyID));
		if (FCode.equalsIgnoreCase("polType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polType));
		if (FCode.equalsIgnoreCase("sugNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sugNo));
		if (FCode.equalsIgnoreCase("cardFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(cardFlag));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("executeCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(executeCom));
		if (FCode.equalsIgnoreCase("agentCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCom));
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("agentGroup"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup));
		if (FCode.equalsIgnoreCase("agentCode1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode1));
		if (FCode.equalsIgnoreCase("agentGroup1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup1));
		if (FCode.equalsIgnoreCase("agentType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentType));
		if (FCode.equalsIgnoreCase("saleChnl"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnl));
		if (FCode.equalsIgnoreCase("handler"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(handler));
		if (FCode.equalsIgnoreCase("password"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(password));
		if (FCode.equalsIgnoreCase("appntNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntNo));
		if (FCode.equalsIgnoreCase("appntId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntId));
		if (FCode.equalsIgnoreCase("appntName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntName));
		if (FCode.equalsIgnoreCase("appntSex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntSex));
		if (FCode.equalsIgnoreCase("appntBirthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getAppntBirthday()));
		if (FCode.equalsIgnoreCase("appntIDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntIDType));
		if (FCode.equalsIgnoreCase("appntIDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntIDNo));
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
		if (FCode.equalsIgnoreCase("insuredIDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredIDType));
		if (FCode.equalsIgnoreCase("insuredIDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredIDNo));
		if (FCode.equalsIgnoreCase("payIntv"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payIntv));
		if (FCode.equalsIgnoreCase("payMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payMode));
		if (FCode.equalsIgnoreCase("payLocation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payLocation));
		if (FCode.equalsIgnoreCase("disputedFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(disputedFlag));
		if (FCode.equalsIgnoreCase("outPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(outPayFlag));
		if (FCode.equalsIgnoreCase("getPolMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPolMode));
		if (FCode.equalsIgnoreCase("signCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signCom));
		if (FCode.equalsIgnoreCase("signDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
		if (FCode.equalsIgnoreCase("signTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signTime));
		if (FCode.equalsIgnoreCase("consignNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(consignNo));
		if (FCode.equalsIgnoreCase("bankCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankCode));
		if (FCode.equalsIgnoreCase("bankAccNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankAccNo));
		if (FCode.equalsIgnoreCase("accName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(accName));
		if (FCode.equalsIgnoreCase("printCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(printCount));
		if (FCode.equalsIgnoreCase("lostTimes"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lostTimes));
		if (FCode.equalsIgnoreCase("lang"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lang));
		if (FCode.equalsIgnoreCase("currency"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currency));
		if (FCode.equalsIgnoreCase("remark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark));
		if (FCode.equalsIgnoreCase("peoples"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(peoples));
		if (FCode.equalsIgnoreCase("mult"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mult));
		if (FCode.equalsIgnoreCase("prem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prem));
		if (FCode.equalsIgnoreCase("amnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(amnt));
		if (FCode.equalsIgnoreCase("sumPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sumPrem));
		if (FCode.equalsIgnoreCase("dif"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dif));
		if (FCode.equalsIgnoreCase("paytoDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPaytoDate()));
		if (FCode.equalsIgnoreCase("firstPayDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getFirstPayDate()));
		if (FCode.equalsIgnoreCase("cValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getCValiDate()));
		if (FCode.equalsIgnoreCase("pSignDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPSignDate()));
		if (FCode.equalsIgnoreCase("pValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPValiDate()));
		if (FCode.equalsIgnoreCase("inputOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(inputOperator));
		if (FCode.equalsIgnoreCase("inputDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getInputDate()));
		if (FCode.equalsIgnoreCase("inputTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(inputTime));
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
		if (FCode.equalsIgnoreCase("uWOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWOperator));
		if (FCode.equalsIgnoreCase("uWDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
		if (FCode.equalsIgnoreCase("uWTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWTime));
		if (FCode.equalsIgnoreCase("appFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appFlag));
		if (FCode.equalsIgnoreCase("polApplyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPolApplyDate()));
		if (FCode.equalsIgnoreCase("getPolDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getGetPolDate()));
		if (FCode.equalsIgnoreCase("getPolTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPolTime));
		if (FCode.equalsIgnoreCase("customGetPolDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getCustomGetPolDate()));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("saleChnlDetail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnlDetail));
		if (FCode.equalsIgnoreCase("proposalType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalType));
		if (FCode.equalsIgnoreCase("editstate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(editstate));
		if (FCode.equalsIgnoreCase("cInValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getCInValiDate()));
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
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(prtNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(mainPolNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(contType);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(familyType);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(familyID);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(polType);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(sugNo);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(cardFlag);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(executeCom);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(agentCom);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(agentGroup);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(agentCode1);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(agentGroup1);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(agentType);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(saleChnl);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(handler);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(password);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(appntNo);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(appntId);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(appntName);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(appntSex);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getAppntBirthday()));
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(appntIDType);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(appntIDNo);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(insuredNo);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(insuredId);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(insuredName);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(insuredSex);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getInsuredBirthday()));
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(insuredIDType);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(insuredIDNo);
			break;

		case 36: // '$'
			strFieldValue = String.valueOf(payIntv);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(payMode);
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(payLocation);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(disputedFlag);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(outPayFlag);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(getPolMode);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(signCom);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(signTime);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(consignNo);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(bankCode);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(bankAccNo);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(accName);
			break;

		case 49: // '1'
			strFieldValue = String.valueOf(printCount);
			break;

		case 50: // '2'
			strFieldValue = String.valueOf(lostTimes);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(lang);
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(currency);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(remark);
			break;

		case 54: // '6'
			strFieldValue = String.valueOf(peoples);
			break;

		case 55: // '7'
			strFieldValue = String.valueOf(mult);
			break;

		case 56: // '8'
			strFieldValue = String.valueOf(prem);
			break;

		case 57: // '9'
			strFieldValue = String.valueOf(amnt);
			break;

		case 58: // ':'
			strFieldValue = String.valueOf(sumPrem);
			break;

		case 59: // ';'
			strFieldValue = String.valueOf(dif);
			break;

		case 60: // '<'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPaytoDate()));
			break;

		case 61: // '='
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getFirstPayDate()));
			break;

		case 62: // '>'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCValiDate()));
			break;

		case 63: // '?'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPSignDate()));
			break;

		case 64: // '@'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPValiDate()));
			break;

		case 65: // 'A'
			strFieldValue = StrTool.GBKToUnicode(inputOperator);
			break;

		case 66: // 'B'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getInputDate()));
			break;

		case 67: // 'C'
			strFieldValue = StrTool.GBKToUnicode(inputTime);
			break;

		case 68: // 'D'
			strFieldValue = StrTool.GBKToUnicode(approveFlag);
			break;

		case 69: // 'E'
			strFieldValue = StrTool.GBKToUnicode(approveCode);
			break;

		case 70: // 'F'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getApproveDate()));
			break;

		case 71: // 'G'
			strFieldValue = StrTool.GBKToUnicode(approveTime);
			break;

		case 72: // 'H'
			strFieldValue = StrTool.GBKToUnicode(uWFlag);
			break;

		case 73: // 'I'
			strFieldValue = StrTool.GBKToUnicode(uWOperator);
			break;

		case 74: // 'J'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
			break;

		case 75: // 'K'
			strFieldValue = StrTool.GBKToUnicode(uWTime);
			break;

		case 76: // 'L'
			strFieldValue = StrTool.GBKToUnicode(appFlag);
			break;

		case 77: // 'M'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPolApplyDate()));
			break;

		case 78: // 'N'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getGetPolDate()));
			break;

		case 79: // 'O'
			strFieldValue = StrTool.GBKToUnicode(getPolTime);
			break;

		case 80: // 'P'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCustomGetPolDate()));
			break;

		case 81: // 'Q'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 82: // 'R'
			strFieldValue = StrTool.GBKToUnicode(saleChnlDetail);
			break;

		case 83: // 'S'
			strFieldValue = StrTool.GBKToUnicode(proposalType);
			break;

		case 84: // 'T'
			strFieldValue = StrTool.GBKToUnicode(editstate);
			break;

		case 85: // 'U'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCInValiDate()));
			break;

		case 86: // 'V'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 87: // 'W'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 88: // 'X'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 89: // 'Y'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 90: // 'Z'
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
		if (FCode.equalsIgnoreCase("prtNo"))
			if (FValue != null && !FValue.equals(""))
				prtNo = FValue.trim();
			else
				prtNo = null;
		if (FCode.equalsIgnoreCase("mainPolNo"))
			if (FValue != null && !FValue.equals(""))
				mainPolNo = FValue.trim();
			else
				mainPolNo = null;
		if (FCode.equalsIgnoreCase("contType"))
			if (FValue != null && !FValue.equals(""))
				contType = FValue.trim();
			else
				contType = null;
		if (FCode.equalsIgnoreCase("familyType"))
			if (FValue != null && !FValue.equals(""))
				familyType = FValue.trim();
			else
				familyType = null;
		if (FCode.equalsIgnoreCase("familyID"))
			if (FValue != null && !FValue.equals(""))
				familyID = FValue.trim();
			else
				familyID = null;
		if (FCode.equalsIgnoreCase("polType"))
			if (FValue != null && !FValue.equals(""))
				polType = FValue.trim();
			else
				polType = null;
		if (FCode.equalsIgnoreCase("sugNo"))
			if (FValue != null && !FValue.equals(""))
				sugNo = FValue.trim();
			else
				sugNo = null;
		if (FCode.equalsIgnoreCase("cardFlag"))
			if (FValue != null && !FValue.equals(""))
				cardFlag = FValue.trim();
			else
				cardFlag = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("executeCom"))
			if (FValue != null && !FValue.equals(""))
				executeCom = FValue.trim();
			else
				executeCom = null;
		if (FCode.equalsIgnoreCase("agentCom"))
			if (FValue != null && !FValue.equals(""))
				agentCom = FValue.trim();
			else
				agentCom = null;
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
		if (FCode.equalsIgnoreCase("agentCode1"))
			if (FValue != null && !FValue.equals(""))
				agentCode1 = FValue.trim();
			else
				agentCode1 = null;
		if (FCode.equalsIgnoreCase("agentGroup1"))
			if (FValue != null && !FValue.equals(""))
				agentGroup1 = FValue.trim();
			else
				agentGroup1 = null;
		if (FCode.equalsIgnoreCase("agentType"))
			if (FValue != null && !FValue.equals(""))
				agentType = FValue.trim();
			else
				agentType = null;
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
		if (FCode.equalsIgnoreCase("password"))
			if (FValue != null && !FValue.equals(""))
				password = FValue.trim();
			else
				password = null;
		if (FCode.equalsIgnoreCase("appntNo"))
			if (FValue != null && !FValue.equals(""))
				appntNo = FValue.trim();
			else
				appntNo = null;
		if (FCode.equalsIgnoreCase("appntId"))
			if (FValue != null && !FValue.equals(""))
				appntId = FValue.trim();
			else
				appntId = null;
		if (FCode.equalsIgnoreCase("appntName"))
			if (FValue != null && !FValue.equals(""))
				appntName = FValue.trim();
			else
				appntName = null;
		if (FCode.equalsIgnoreCase("appntSex"))
			if (FValue != null && !FValue.equals(""))
				appntSex = FValue.trim();
			else
				appntSex = null;
		if (FCode.equalsIgnoreCase("appntBirthday"))
			if (FValue != null && !FValue.equals(""))
				appntBirthday = fDate.getDate(FValue);
			else
				appntBirthday = null;
		if (FCode.equalsIgnoreCase("appntIDType"))
			if (FValue != null && !FValue.equals(""))
				appntIDType = FValue.trim();
			else
				appntIDType = null;
		if (FCode.equalsIgnoreCase("appntIDNo"))
			if (FValue != null && !FValue.equals(""))
				appntIDNo = FValue.trim();
			else
				appntIDNo = null;
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
		if (FCode.equalsIgnoreCase("insuredIDType"))
			if (FValue != null && !FValue.equals(""))
				insuredIDType = FValue.trim();
			else
				insuredIDType = null;
		if (FCode.equalsIgnoreCase("insuredIDNo"))
			if (FValue != null && !FValue.equals(""))
				insuredIDNo = FValue.trim();
			else
				insuredIDNo = null;
		if (FCode.equalsIgnoreCase("payIntv") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payIntv = i;
		}
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
		if (FCode.equalsIgnoreCase("disputedFlag"))
			if (FValue != null && !FValue.equals(""))
				disputedFlag = FValue.trim();
			else
				disputedFlag = null;
		if (FCode.equalsIgnoreCase("outPayFlag"))
			if (FValue != null && !FValue.equals(""))
				outPayFlag = FValue.trim();
			else
				outPayFlag = null;
		if (FCode.equalsIgnoreCase("getPolMode"))
			if (FValue != null && !FValue.equals(""))
				getPolMode = FValue.trim();
			else
				getPolMode = null;
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
		if (FCode.equalsIgnoreCase("consignNo"))
			if (FValue != null && !FValue.equals(""))
				consignNo = FValue.trim();
			else
				consignNo = null;
		if (FCode.equalsIgnoreCase("bankCode"))
			if (FValue != null && !FValue.equals(""))
				bankCode = FValue.trim();
			else
				bankCode = null;
		if (FCode.equalsIgnoreCase("bankAccNo"))
			if (FValue != null && !FValue.equals(""))
				bankAccNo = FValue.trim();
			else
				bankAccNo = null;
		if (FCode.equalsIgnoreCase("accName"))
			if (FValue != null && !FValue.equals(""))
				accName = FValue.trim();
			else
				accName = null;
		if (FCode.equalsIgnoreCase("printCount") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			printCount = i;
		}
		if (FCode.equalsIgnoreCase("lostTimes") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			lostTimes = i;
		}
		if (FCode.equalsIgnoreCase("lang"))
			if (FValue != null && !FValue.equals(""))
				lang = FValue.trim();
			else
				lang = null;
		if (FCode.equalsIgnoreCase("currency"))
			if (FValue != null && !FValue.equals(""))
				currency = FValue.trim();
			else
				currency = null;
		if (FCode.equalsIgnoreCase("remark"))
			if (FValue != null && !FValue.equals(""))
				remark = FValue.trim();
			else
				remark = null;
		if (FCode.equalsIgnoreCase("peoples") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			peoples = i;
		}
		if (FCode.equalsIgnoreCase("mult") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mult = d;
		}
		if (FCode.equalsIgnoreCase("prem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			prem = d;
		}
		if (FCode.equalsIgnoreCase("amnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			amnt = d;
		}
		if (FCode.equalsIgnoreCase("sumPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sumPrem = d;
		}
		if (FCode.equalsIgnoreCase("dif") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			dif = d;
		}
		if (FCode.equalsIgnoreCase("paytoDate"))
			if (FValue != null && !FValue.equals(""))
				paytoDate = fDate.getDate(FValue);
			else
				paytoDate = null;
		if (FCode.equalsIgnoreCase("firstPayDate"))
			if (FValue != null && !FValue.equals(""))
				firstPayDate = fDate.getDate(FValue);
			else
				firstPayDate = null;
		if (FCode.equalsIgnoreCase("cValiDate"))
			if (FValue != null && !FValue.equals(""))
				cValiDate = fDate.getDate(FValue);
			else
				cValiDate = null;
		if (FCode.equalsIgnoreCase("pSignDate"))
			if (FValue != null && !FValue.equals(""))
				pSignDate = fDate.getDate(FValue);
			else
				pSignDate = null;
		if (FCode.equalsIgnoreCase("pValiDate"))
			if (FValue != null && !FValue.equals(""))
				pValiDate = fDate.getDate(FValue);
			else
				pValiDate = null;
		if (FCode.equalsIgnoreCase("inputOperator"))
			if (FValue != null && !FValue.equals(""))
				inputOperator = FValue.trim();
			else
				inputOperator = null;
		if (FCode.equalsIgnoreCase("inputDate"))
			if (FValue != null && !FValue.equals(""))
				inputDate = fDate.getDate(FValue);
			else
				inputDate = null;
		if (FCode.equalsIgnoreCase("inputTime"))
			if (FValue != null && !FValue.equals(""))
				inputTime = FValue.trim();
			else
				inputTime = null;
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
		if (FCode.equalsIgnoreCase("uWOperator"))
			if (FValue != null && !FValue.equals(""))
				uWOperator = FValue.trim();
			else
				uWOperator = null;
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
		if (FCode.equalsIgnoreCase("appFlag"))
			if (FValue != null && !FValue.equals(""))
				appFlag = FValue.trim();
			else
				appFlag = null;
		if (FCode.equalsIgnoreCase("polApplyDate"))
			if (FValue != null && !FValue.equals(""))
				polApplyDate = fDate.getDate(FValue);
			else
				polApplyDate = null;
		if (FCode.equalsIgnoreCase("getPolDate"))
			if (FValue != null && !FValue.equals(""))
				getPolDate = fDate.getDate(FValue);
			else
				getPolDate = null;
		if (FCode.equalsIgnoreCase("getPolTime"))
			if (FValue != null && !FValue.equals(""))
				getPolTime = FValue.trim();
			else
				getPolTime = null;
		if (FCode.equalsIgnoreCase("customGetPolDate"))
			if (FValue != null && !FValue.equals(""))
				customGetPolDate = fDate.getDate(FValue);
			else
				customGetPolDate = null;
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("saleChnlDetail"))
			if (FValue != null && !FValue.equals(""))
				saleChnlDetail = FValue.trim();
			else
				saleChnlDetail = null;
		if (FCode.equalsIgnoreCase("proposalType"))
			if (FValue != null && !FValue.equals(""))
				proposalType = FValue.trim();
			else
				proposalType = null;
		if (FCode.equalsIgnoreCase("editstate"))
			if (FValue != null && !FValue.equals(""))
				editstate = FValue.trim();
			else
				editstate = null;
		if (FCode.equalsIgnoreCase("cInValiDate"))
			if (FValue != null && !FValue.equals(""))
				cInValiDate = fDate.getDate(FValue);
			else
				cInValiDate = null;
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
		LNPContSchema other = (LNPContSchema)otherObject;
		if (grpContNo == null && other.getGrpContNo() != null)
			return false;
		if (grpContNo != null && !grpContNo.equals(other.getGrpContNo()))
			return false;
		if (contNo == null && other.getContNo() != null)
			return false;
		if (contNo != null && !contNo.equals(other.getContNo()))
			return false;
		if (proposalContNo == null && other.getProposalContNo() != null)
			return false;
		if (proposalContNo != null && !proposalContNo.equals(other.getProposalContNo()))
			return false;
		if (prtNo == null && other.getPrtNo() != null)
			return false;
		if (prtNo != null && !prtNo.equals(other.getPrtNo()))
			return false;
		if (mainPolNo == null && other.getMainPolNo() != null)
			return false;
		if (mainPolNo != null && !mainPolNo.equals(other.getMainPolNo()))
			return false;
		if (contType == null && other.getContType() != null)
			return false;
		if (contType != null && !contType.equals(other.getContType()))
			return false;
		if (familyType == null && other.getFamilyType() != null)
			return false;
		if (familyType != null && !familyType.equals(other.getFamilyType()))
			return false;
		if (familyID == null && other.getFamilyID() != null)
			return false;
		if (familyID != null && !familyID.equals(other.getFamilyID()))
			return false;
		if (polType == null && other.getPolType() != null)
			return false;
		if (polType != null && !polType.equals(other.getPolType()))
			return false;
		if (sugNo == null && other.getSugNo() != null)
			return false;
		if (sugNo != null && !sugNo.equals(other.getSugNo()))
			return false;
		if (cardFlag == null && other.getCardFlag() != null)
			return false;
		if (cardFlag != null && !cardFlag.equals(other.getCardFlag()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (executeCom == null && other.getExecuteCom() != null)
			return false;
		if (executeCom != null && !executeCom.equals(other.getExecuteCom()))
			return false;
		if (agentCom == null && other.getAgentCom() != null)
			return false;
		if (agentCom != null && !agentCom.equals(other.getAgentCom()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (agentGroup == null && other.getAgentGroup() != null)
			return false;
		if (agentGroup != null && !agentGroup.equals(other.getAgentGroup()))
			return false;
		if (agentCode1 == null && other.getAgentCode1() != null)
			return false;
		if (agentCode1 != null && !agentCode1.equals(other.getAgentCode1()))
			return false;
		if (agentGroup1 == null && other.getAgentGroup1() != null)
			return false;
		if (agentGroup1 != null && !agentGroup1.equals(other.getAgentGroup1()))
			return false;
		if (agentType == null && other.getAgentType() != null)
			return false;
		if (agentType != null && !agentType.equals(other.getAgentType()))
			return false;
		if (saleChnl == null && other.getSaleChnl() != null)
			return false;
		if (saleChnl != null && !saleChnl.equals(other.getSaleChnl()))
			return false;
		if (handler == null && other.getHandler() != null)
			return false;
		if (handler != null && !handler.equals(other.getHandler()))
			return false;
		if (password == null && other.getPassword() != null)
			return false;
		if (password != null && !password.equals(other.getPassword()))
			return false;
		if (appntNo == null && other.getAppntNo() != null)
			return false;
		if (appntNo != null && !appntNo.equals(other.getAppntNo()))
			return false;
		if (appntId == null && other.getAppntId() != null)
			return false;
		if (appntId != null && !appntId.equals(other.getAppntId()))
			return false;
		if (appntName == null && other.getAppntName() != null)
			return false;
		if (appntName != null && !appntName.equals(other.getAppntName()))
			return false;
		if (appntSex == null && other.getAppntSex() != null)
			return false;
		if (appntSex != null && !appntSex.equals(other.getAppntSex()))
			return false;
		if (appntBirthday == null && other.getAppntBirthday() != null)
			return false;
		if (appntBirthday != null && !fDate.getString(appntBirthday).equals(other.getAppntBirthday()))
			return false;
		if (appntIDType == null && other.getAppntIDType() != null)
			return false;
		if (appntIDType != null && !appntIDType.equals(other.getAppntIDType()))
			return false;
		if (appntIDNo == null && other.getAppntIDNo() != null)
			return false;
		if (appntIDNo != null && !appntIDNo.equals(other.getAppntIDNo()))
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
		if (insuredIDType == null && other.getInsuredIDType() != null)
			return false;
		if (insuredIDType != null && !insuredIDType.equals(other.getInsuredIDType()))
			return false;
		if (insuredIDNo == null && other.getInsuredIDNo() != null)
			return false;
		if (insuredIDNo != null && !insuredIDNo.equals(other.getInsuredIDNo()))
			return false;
		if (payIntv != other.getPayIntv())
			return false;
		if (payMode == null && other.getPayMode() != null)
			return false;
		if (payMode != null && !payMode.equals(other.getPayMode()))
			return false;
		if (payLocation == null && other.getPayLocation() != null)
			return false;
		if (payLocation != null && !payLocation.equals(other.getPayLocation()))
			return false;
		if (disputedFlag == null && other.getDisputedFlag() != null)
			return false;
		if (disputedFlag != null && !disputedFlag.equals(other.getDisputedFlag()))
			return false;
		if (outPayFlag == null && other.getOutPayFlag() != null)
			return false;
		if (outPayFlag != null && !outPayFlag.equals(other.getOutPayFlag()))
			return false;
		if (getPolMode == null && other.getGetPolMode() != null)
			return false;
		if (getPolMode != null && !getPolMode.equals(other.getGetPolMode()))
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
		if (consignNo == null && other.getConsignNo() != null)
			return false;
		if (consignNo != null && !consignNo.equals(other.getConsignNo()))
			return false;
		if (bankCode == null && other.getBankCode() != null)
			return false;
		if (bankCode != null && !bankCode.equals(other.getBankCode()))
			return false;
		if (bankAccNo == null && other.getBankAccNo() != null)
			return false;
		if (bankAccNo != null && !bankAccNo.equals(other.getBankAccNo()))
			return false;
		if (accName == null && other.getAccName() != null)
			return false;
		if (accName != null && !accName.equals(other.getAccName()))
			return false;
		if (printCount != other.getPrintCount())
			return false;
		if (lostTimes != other.getLostTimes())
			return false;
		if (lang == null && other.getLang() != null)
			return false;
		if (lang != null && !lang.equals(other.getLang()))
			return false;
		if (currency == null && other.getCurrency() != null)
			return false;
		if (currency != null && !currency.equals(other.getCurrency()))
			return false;
		if (remark == null && other.getRemark() != null)
			return false;
		if (remark != null && !remark.equals(other.getRemark()))
			return false;
		if (peoples != other.getPeoples())
			return false;
		if (Double.doubleToLongBits(mult) != Double.doubleToLongBits(other.getMult()))
			return false;
		if (Double.doubleToLongBits(prem) != Double.doubleToLongBits(other.getPrem()))
			return false;
		if (Double.doubleToLongBits(amnt) != Double.doubleToLongBits(other.getAmnt()))
			return false;
		if (Double.doubleToLongBits(sumPrem) != Double.doubleToLongBits(other.getSumPrem()))
			return false;
		if (Double.doubleToLongBits(dif) != Double.doubleToLongBits(other.getDif()))
			return false;
		if (paytoDate == null && other.getPaytoDate() != null)
			return false;
		if (paytoDate != null && !fDate.getString(paytoDate).equals(other.getPaytoDate()))
			return false;
		if (firstPayDate == null && other.getFirstPayDate() != null)
			return false;
		if (firstPayDate != null && !fDate.getString(firstPayDate).equals(other.getFirstPayDate()))
			return false;
		if (cValiDate == null && other.getCValiDate() != null)
			return false;
		if (cValiDate != null && !fDate.getString(cValiDate).equals(other.getCValiDate()))
			return false;
		if (pSignDate == null && other.getPSignDate() != null)
			return false;
		if (pSignDate != null && !fDate.getString(pSignDate).equals(other.getPSignDate()))
			return false;
		if (pValiDate == null && other.getPValiDate() != null)
			return false;
		if (pValiDate != null && !fDate.getString(pValiDate).equals(other.getPValiDate()))
			return false;
		if (inputOperator == null && other.getInputOperator() != null)
			return false;
		if (inputOperator != null && !inputOperator.equals(other.getInputOperator()))
			return false;
		if (inputDate == null && other.getInputDate() != null)
			return false;
		if (inputDate != null && !fDate.getString(inputDate).equals(other.getInputDate()))
			return false;
		if (inputTime == null && other.getInputTime() != null)
			return false;
		if (inputTime != null && !inputTime.equals(other.getInputTime()))
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
		if (uWOperator == null && other.getUWOperator() != null)
			return false;
		if (uWOperator != null && !uWOperator.equals(other.getUWOperator()))
			return false;
		if (uWDate == null && other.getUWDate() != null)
			return false;
		if (uWDate != null && !fDate.getString(uWDate).equals(other.getUWDate()))
			return false;
		if (uWTime == null && other.getUWTime() != null)
			return false;
		if (uWTime != null && !uWTime.equals(other.getUWTime()))
			return false;
		if (appFlag == null && other.getAppFlag() != null)
			return false;
		if (appFlag != null && !appFlag.equals(other.getAppFlag()))
			return false;
		if (polApplyDate == null && other.getPolApplyDate() != null)
			return false;
		if (polApplyDate != null && !fDate.getString(polApplyDate).equals(other.getPolApplyDate()))
			return false;
		if (getPolDate == null && other.getGetPolDate() != null)
			return false;
		if (getPolDate != null && !fDate.getString(getPolDate).equals(other.getGetPolDate()))
			return false;
		if (getPolTime == null && other.getGetPolTime() != null)
			return false;
		if (getPolTime != null && !getPolTime.equals(other.getGetPolTime()))
			return false;
		if (customGetPolDate == null && other.getCustomGetPolDate() != null)
			return false;
		if (customGetPolDate != null && !fDate.getString(customGetPolDate).equals(other.getCustomGetPolDate()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (saleChnlDetail == null && other.getSaleChnlDetail() != null)
			return false;
		if (saleChnlDetail != null && !saleChnlDetail.equals(other.getSaleChnlDetail()))
			return false;
		if (proposalType == null && other.getProposalType() != null)
			return false;
		if (proposalType != null && !proposalType.equals(other.getProposalType()))
			return false;
		if (editstate == null && other.getEditstate() != null)
			return false;
		if (editstate != null && !editstate.equals(other.getEditstate()))
			return false;
		if (cInValiDate == null && other.getCInValiDate() != null)
			return false;
		if (cInValiDate != null && !fDate.getString(cInValiDate).equals(other.getCInValiDate()))
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
		return 91;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 1;
		if (strFieldName.equals("proposalContNo"))
			return 2;
		if (strFieldName.equals("prtNo"))
			return 3;
		if (strFieldName.equals("mainPolNo"))
			return 4;
		if (strFieldName.equals("contType"))
			return 5;
		if (strFieldName.equals("familyType"))
			return 6;
		if (strFieldName.equals("familyID"))
			return 7;
		if (strFieldName.equals("polType"))
			return 8;
		if (strFieldName.equals("sugNo"))
			return 9;
		if (strFieldName.equals("cardFlag"))
			return 10;
		if (strFieldName.equals("manageCom"))
			return 11;
		if (strFieldName.equals("executeCom"))
			return 12;
		if (strFieldName.equals("agentCom"))
			return 13;
		if (strFieldName.equals("agentCode"))
			return 14;
		if (strFieldName.equals("agentGroup"))
			return 15;
		if (strFieldName.equals("agentCode1"))
			return 16;
		if (strFieldName.equals("agentGroup1"))
			return 17;
		if (strFieldName.equals("agentType"))
			return 18;
		if (strFieldName.equals("saleChnl"))
			return 19;
		if (strFieldName.equals("handler"))
			return 20;
		if (strFieldName.equals("password"))
			return 21;
		if (strFieldName.equals("appntNo"))
			return 22;
		if (strFieldName.equals("appntId"))
			return 23;
		if (strFieldName.equals("appntName"))
			return 24;
		if (strFieldName.equals("appntSex"))
			return 25;
		if (strFieldName.equals("appntBirthday"))
			return 26;
		if (strFieldName.equals("appntIDType"))
			return 27;
		if (strFieldName.equals("appntIDNo"))
			return 28;
		if (strFieldName.equals("insuredNo"))
			return 29;
		if (strFieldName.equals("insuredId"))
			return 30;
		if (strFieldName.equals("insuredName"))
			return 31;
		if (strFieldName.equals("insuredSex"))
			return 32;
		if (strFieldName.equals("insuredBirthday"))
			return 33;
		if (strFieldName.equals("insuredIDType"))
			return 34;
		if (strFieldName.equals("insuredIDNo"))
			return 35;
		if (strFieldName.equals("payIntv"))
			return 36;
		if (strFieldName.equals("payMode"))
			return 37;
		if (strFieldName.equals("payLocation"))
			return 38;
		if (strFieldName.equals("disputedFlag"))
			return 39;
		if (strFieldName.equals("outPayFlag"))
			return 40;
		if (strFieldName.equals("getPolMode"))
			return 41;
		if (strFieldName.equals("signCom"))
			return 42;
		if (strFieldName.equals("signDate"))
			return 43;
		if (strFieldName.equals("signTime"))
			return 44;
		if (strFieldName.equals("consignNo"))
			return 45;
		if (strFieldName.equals("bankCode"))
			return 46;
		if (strFieldName.equals("bankAccNo"))
			return 47;
		if (strFieldName.equals("accName"))
			return 48;
		if (strFieldName.equals("printCount"))
			return 49;
		if (strFieldName.equals("lostTimes"))
			return 50;
		if (strFieldName.equals("lang"))
			return 51;
		if (strFieldName.equals("currency"))
			return 52;
		if (strFieldName.equals("remark"))
			return 53;
		if (strFieldName.equals("peoples"))
			return 54;
		if (strFieldName.equals("mult"))
			return 55;
		if (strFieldName.equals("prem"))
			return 56;
		if (strFieldName.equals("amnt"))
			return 57;
		if (strFieldName.equals("sumPrem"))
			return 58;
		if (strFieldName.equals("dif"))
			return 59;
		if (strFieldName.equals("paytoDate"))
			return 60;
		if (strFieldName.equals("firstPayDate"))
			return 61;
		if (strFieldName.equals("cValiDate"))
			return 62;
		if (strFieldName.equals("pSignDate"))
			return 63;
		if (strFieldName.equals("pValiDate"))
			return 64;
		if (strFieldName.equals("inputOperator"))
			return 65;
		if (strFieldName.equals("inputDate"))
			return 66;
		if (strFieldName.equals("inputTime"))
			return 67;
		if (strFieldName.equals("approveFlag"))
			return 68;
		if (strFieldName.equals("approveCode"))
			return 69;
		if (strFieldName.equals("approveDate"))
			return 70;
		if (strFieldName.equals("approveTime"))
			return 71;
		if (strFieldName.equals("uWFlag"))
			return 72;
		if (strFieldName.equals("uWOperator"))
			return 73;
		if (strFieldName.equals("uWDate"))
			return 74;
		if (strFieldName.equals("uWTime"))
			return 75;
		if (strFieldName.equals("appFlag"))
			return 76;
		if (strFieldName.equals("polApplyDate"))
			return 77;
		if (strFieldName.equals("getPolDate"))
			return 78;
		if (strFieldName.equals("getPolTime"))
			return 79;
		if (strFieldName.equals("customGetPolDate"))
			return 80;
		if (strFieldName.equals("state"))
			return 81;
		if (strFieldName.equals("saleChnlDetail"))
			return 82;
		if (strFieldName.equals("proposalType"))
			return 83;
		if (strFieldName.equals("editstate"))
			return 84;
		if (strFieldName.equals("cInValiDate"))
			return 85;
		if (strFieldName.equals("operator"))
			return 86;
		if (strFieldName.equals("makeDate"))
			return 87;
		if (strFieldName.equals("makeTime"))
			return 88;
		if (strFieldName.equals("modifyDate"))
			return 89;
		return !strFieldName.equals("modifyTime") ? -1 : 90;
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
			strFieldName = "contNo";
			break;

		case 2: // '\002'
			strFieldName = "proposalContNo";
			break;

		case 3: // '\003'
			strFieldName = "prtNo";
			break;

		case 4: // '\004'
			strFieldName = "mainPolNo";
			break;

		case 5: // '\005'
			strFieldName = "contType";
			break;

		case 6: // '\006'
			strFieldName = "familyType";
			break;

		case 7: // '\007'
			strFieldName = "familyID";
			break;

		case 8: // '\b'
			strFieldName = "polType";
			break;

		case 9: // '\t'
			strFieldName = "sugNo";
			break;

		case 10: // '\n'
			strFieldName = "cardFlag";
			break;

		case 11: // '\013'
			strFieldName = "manageCom";
			break;

		case 12: // '\f'
			strFieldName = "executeCom";
			break;

		case 13: // '\r'
			strFieldName = "agentCom";
			break;

		case 14: // '\016'
			strFieldName = "agentCode";
			break;

		case 15: // '\017'
			strFieldName = "agentGroup";
			break;

		case 16: // '\020'
			strFieldName = "agentCode1";
			break;

		case 17: // '\021'
			strFieldName = "agentGroup1";
			break;

		case 18: // '\022'
			strFieldName = "agentType";
			break;

		case 19: // '\023'
			strFieldName = "saleChnl";
			break;

		case 20: // '\024'
			strFieldName = "handler";
			break;

		case 21: // '\025'
			strFieldName = "password";
			break;

		case 22: // '\026'
			strFieldName = "appntNo";
			break;

		case 23: // '\027'
			strFieldName = "appntId";
			break;

		case 24: // '\030'
			strFieldName = "appntName";
			break;

		case 25: // '\031'
			strFieldName = "appntSex";
			break;

		case 26: // '\032'
			strFieldName = "appntBirthday";
			break;

		case 27: // '\033'
			strFieldName = "appntIDType";
			break;

		case 28: // '\034'
			strFieldName = "appntIDNo";
			break;

		case 29: // '\035'
			strFieldName = "insuredNo";
			break;

		case 30: // '\036'
			strFieldName = "insuredId";
			break;

		case 31: // '\037'
			strFieldName = "insuredName";
			break;

		case 32: // ' '
			strFieldName = "insuredSex";
			break;

		case 33: // '!'
			strFieldName = "insuredBirthday";
			break;

		case 34: // '"'
			strFieldName = "insuredIDType";
			break;

		case 35: // '#'
			strFieldName = "insuredIDNo";
			break;

		case 36: // '$'
			strFieldName = "payIntv";
			break;

		case 37: // '%'
			strFieldName = "payMode";
			break;

		case 38: // '&'
			strFieldName = "payLocation";
			break;

		case 39: // '\''
			strFieldName = "disputedFlag";
			break;

		case 40: // '('
			strFieldName = "outPayFlag";
			break;

		case 41: // ')'
			strFieldName = "getPolMode";
			break;

		case 42: // '*'
			strFieldName = "signCom";
			break;

		case 43: // '+'
			strFieldName = "signDate";
			break;

		case 44: // ','
			strFieldName = "signTime";
			break;

		case 45: // '-'
			strFieldName = "consignNo";
			break;

		case 46: // '.'
			strFieldName = "bankCode";
			break;

		case 47: // '/'
			strFieldName = "bankAccNo";
			break;

		case 48: // '0'
			strFieldName = "accName";
			break;

		case 49: // '1'
			strFieldName = "printCount";
			break;

		case 50: // '2'
			strFieldName = "lostTimes";
			break;

		case 51: // '3'
			strFieldName = "lang";
			break;

		case 52: // '4'
			strFieldName = "currency";
			break;

		case 53: // '5'
			strFieldName = "remark";
			break;

		case 54: // '6'
			strFieldName = "peoples";
			break;

		case 55: // '7'
			strFieldName = "mult";
			break;

		case 56: // '8'
			strFieldName = "prem";
			break;

		case 57: // '9'
			strFieldName = "amnt";
			break;

		case 58: // ':'
			strFieldName = "sumPrem";
			break;

		case 59: // ';'
			strFieldName = "dif";
			break;

		case 60: // '<'
			strFieldName = "paytoDate";
			break;

		case 61: // '='
			strFieldName = "firstPayDate";
			break;

		case 62: // '>'
			strFieldName = "cValiDate";
			break;

		case 63: // '?'
			strFieldName = "pSignDate";
			break;

		case 64: // '@'
			strFieldName = "pValiDate";
			break;

		case 65: // 'A'
			strFieldName = "inputOperator";
			break;

		case 66: // 'B'
			strFieldName = "inputDate";
			break;

		case 67: // 'C'
			strFieldName = "inputTime";
			break;

		case 68: // 'D'
			strFieldName = "approveFlag";
			break;

		case 69: // 'E'
			strFieldName = "approveCode";
			break;

		case 70: // 'F'
			strFieldName = "approveDate";
			break;

		case 71: // 'G'
			strFieldName = "approveTime";
			break;

		case 72: // 'H'
			strFieldName = "uWFlag";
			break;

		case 73: // 'I'
			strFieldName = "uWOperator";
			break;

		case 74: // 'J'
			strFieldName = "uWDate";
			break;

		case 75: // 'K'
			strFieldName = "uWTime";
			break;

		case 76: // 'L'
			strFieldName = "appFlag";
			break;

		case 77: // 'M'
			strFieldName = "polApplyDate";
			break;

		case 78: // 'N'
			strFieldName = "getPolDate";
			break;

		case 79: // 'O'
			strFieldName = "getPolTime";
			break;

		case 80: // 'P'
			strFieldName = "customGetPolDate";
			break;

		case 81: // 'Q'
			strFieldName = "state";
			break;

		case 82: // 'R'
			strFieldName = "saleChnlDetail";
			break;

		case 83: // 'S'
			strFieldName = "proposalType";
			break;

		case 84: // 'T'
			strFieldName = "editstate";
			break;

		case 85: // 'U'
			strFieldName = "cInValiDate";
			break;

		case 86: // 'V'
			strFieldName = "operator";
			break;

		case 87: // 'W'
			strFieldName = "makeDate";
			break;

		case 88: // 'X'
			strFieldName = "makeTime";
			break;

		case 89: // 'Y'
			strFieldName = "modifyDate";
			break;

		case 90: // 'Z'
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
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("proposalContNo"))
			return 0;
		if (strFieldName.equals("prtNo"))
			return 0;
		if (strFieldName.equals("mainPolNo"))
			return 0;
		if (strFieldName.equals("contType"))
			return 0;
		if (strFieldName.equals("familyType"))
			return 0;
		if (strFieldName.equals("familyID"))
			return 0;
		if (strFieldName.equals("polType"))
			return 0;
		if (strFieldName.equals("sugNo"))
			return 0;
		if (strFieldName.equals("cardFlag"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("executeCom"))
			return 0;
		if (strFieldName.equals("agentCom"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("agentGroup"))
			return 0;
		if (strFieldName.equals("agentCode1"))
			return 0;
		if (strFieldName.equals("agentGroup1"))
			return 0;
		if (strFieldName.equals("agentType"))
			return 0;
		if (strFieldName.equals("saleChnl"))
			return 0;
		if (strFieldName.equals("handler"))
			return 0;
		if (strFieldName.equals("password"))
			return 0;
		if (strFieldName.equals("appntNo"))
			return 0;
		if (strFieldName.equals("appntId"))
			return 0;
		if (strFieldName.equals("appntName"))
			return 0;
		if (strFieldName.equals("appntSex"))
			return 0;
		if (strFieldName.equals("appntBirthday"))
			return 1;
		if (strFieldName.equals("appntIDType"))
			return 0;
		if (strFieldName.equals("appntIDNo"))
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
		if (strFieldName.equals("insuredIDType"))
			return 0;
		if (strFieldName.equals("insuredIDNo"))
			return 0;
		if (strFieldName.equals("payIntv"))
			return 3;
		if (strFieldName.equals("payMode"))
			return 0;
		if (strFieldName.equals("payLocation"))
			return 0;
		if (strFieldName.equals("disputedFlag"))
			return 0;
		if (strFieldName.equals("outPayFlag"))
			return 0;
		if (strFieldName.equals("getPolMode"))
			return 0;
		if (strFieldName.equals("signCom"))
			return 0;
		if (strFieldName.equals("signDate"))
			return 1;
		if (strFieldName.equals("signTime"))
			return 0;
		if (strFieldName.equals("consignNo"))
			return 0;
		if (strFieldName.equals("bankCode"))
			return 0;
		if (strFieldName.equals("bankAccNo"))
			return 0;
		if (strFieldName.equals("accName"))
			return 0;
		if (strFieldName.equals("printCount"))
			return 3;
		if (strFieldName.equals("lostTimes"))
			return 3;
		if (strFieldName.equals("lang"))
			return 0;
		if (strFieldName.equals("currency"))
			return 0;
		if (strFieldName.equals("remark"))
			return 0;
		if (strFieldName.equals("peoples"))
			return 3;
		if (strFieldName.equals("mult"))
			return 4;
		if (strFieldName.equals("prem"))
			return 4;
		if (strFieldName.equals("amnt"))
			return 4;
		if (strFieldName.equals("sumPrem"))
			return 4;
		if (strFieldName.equals("dif"))
			return 4;
		if (strFieldName.equals("paytoDate"))
			return 1;
		if (strFieldName.equals("firstPayDate"))
			return 1;
		if (strFieldName.equals("cValiDate"))
			return 1;
		if (strFieldName.equals("pSignDate"))
			return 1;
		if (strFieldName.equals("pValiDate"))
			return 1;
		if (strFieldName.equals("inputOperator"))
			return 0;
		if (strFieldName.equals("inputDate"))
			return 1;
		if (strFieldName.equals("inputTime"))
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
		if (strFieldName.equals("uWOperator"))
			return 0;
		if (strFieldName.equals("uWDate"))
			return 1;
		if (strFieldName.equals("uWTime"))
			return 0;
		if (strFieldName.equals("appFlag"))
			return 0;
		if (strFieldName.equals("polApplyDate"))
			return 1;
		if (strFieldName.equals("getPolDate"))
			return 1;
		if (strFieldName.equals("getPolTime"))
			return 0;
		if (strFieldName.equals("customGetPolDate"))
			return 1;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("saleChnlDetail"))
			return 0;
		if (strFieldName.equals("proposalType"))
			return 0;
		if (strFieldName.equals("editstate"))
			return 0;
		if (strFieldName.equals("cInValiDate"))
			return 1;
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
			nFieldType = 1;
			break;

		case 27: // '\033'
			nFieldType = 0;
			break;

		case 28: // '\034'
			nFieldType = 0;
			break;

		case 29: // '\035'
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 36: // '$'
			nFieldType = 3;
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
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 49: // '1'
			nFieldType = 3;
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
			nFieldType = 3;
			break;

		case 55: // '7'
			nFieldType = 4;
			break;

		case 56: // '8'
			nFieldType = 4;
			break;

		case 57: // '9'
			nFieldType = 4;
			break;

		case 58: // ':'
			nFieldType = 4;
			break;

		case 59: // ';'
			nFieldType = 4;
			break;

		case 60: // '<'
			nFieldType = 1;
			break;

		case 61: // '='
			nFieldType = 1;
			break;

		case 62: // '>'
			nFieldType = 1;
			break;

		case 63: // '?'
			nFieldType = 1;
			break;

		case 64: // '@'
			nFieldType = 1;
			break;

		case 65: // 'A'
			nFieldType = 0;
			break;

		case 66: // 'B'
			nFieldType = 1;
			break;

		case 67: // 'C'
			nFieldType = 0;
			break;

		case 68: // 'D'
			nFieldType = 0;
			break;

		case 69: // 'E'
			nFieldType = 0;
			break;

		case 70: // 'F'
			nFieldType = 1;
			break;

		case 71: // 'G'
			nFieldType = 0;
			break;

		case 72: // 'H'
			nFieldType = 0;
			break;

		case 73: // 'I'
			nFieldType = 0;
			break;

		case 74: // 'J'
			nFieldType = 1;
			break;

		case 75: // 'K'
			nFieldType = 0;
			break;

		case 76: // 'L'
			nFieldType = 0;
			break;

		case 77: // 'M'
			nFieldType = 1;
			break;

		case 78: // 'N'
			nFieldType = 1;
			break;

		case 79: // 'O'
			nFieldType = 0;
			break;

		case 80: // 'P'
			nFieldType = 1;
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
			nFieldType = 1;
			break;

		case 86: // 'V'
			nFieldType = 0;
			break;

		case 87: // 'W'
			nFieldType = 1;
			break;

		case 88: // 'X'
			nFieldType = 0;
			break;

		case 89: // 'Y'
			nFieldType = 1;
			break;

		case 90: // 'Z'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
