// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPolBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPPolBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPPolBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
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
	public static final int FIELDNUM = 121;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPPolBSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "EdorNo";
		pk[1] = "serialNo";
		PK = pk;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getEdorNo()
	{
		if (EdorNo != null)
			EdorNo.equals("");
		return EdorNo;
	}

	public void setEdorNo(String aEdorNo)
	{
		EdorNo = aEdorNo;
	}

	public String getserialNo()
	{
		if (serialNo != null)
			serialNo.equals("");
		return serialNo;
	}

	public void setserialNo(String aserialNo)
	{
		serialNo = aserialNo;
	}

	public String getgrpContNo()
	{
		if (grpContNo != null)
			grpContNo.equals("");
		return grpContNo;
	}

	public void setgrpContNo(String agrpContNo)
	{
		grpContNo = agrpContNo;
	}

	public String getgrpPolNo()
	{
		if (grpPolNo != null)
			grpPolNo.equals("");
		return grpPolNo;
	}

	public void setgrpPolNo(String agrpPolNo)
	{
		grpPolNo = agrpPolNo;
	}

	public String getcontNo()
	{
		if (contNo != null)
			contNo.equals("");
		return contNo;
	}

	public void setcontNo(String acontNo)
	{
		contNo = acontNo;
	}

	public String getproposalContNo()
	{
		if (proposalContNo != null)
			proposalContNo.equals("");
		return proposalContNo;
	}

	public void setproposalContNo(String aproposalContNo)
	{
		proposalContNo = aproposalContNo;
	}

	public String getpolNo()
	{
		if (polNo != null)
			polNo.equals("");
		return polNo;
	}

	public void setpolNo(String apolNo)
	{
		polNo = apolNo;
	}

	public String getproposalNo()
	{
		if (proposalNo != null)
			proposalNo.equals("");
		return proposalNo;
	}

	public void setproposalNo(String aproposalNo)
	{
		proposalNo = aproposalNo;
	}

	public String getprtNo()
	{
		if (prtNo != null)
			prtNo.equals("");
		return prtNo;
	}

	public void setprtNo(String aprtNo)
	{
		prtNo = aprtNo;
	}

	public String getcontType()
	{
		if (contType != null)
			contType.equals("");
		return contType;
	}

	public void setcontType(String acontType)
	{
		contType = acontType;
	}

	public String getpolTypeFlag()
	{
		if (polTypeFlag != null)
			polTypeFlag.equals("");
		return polTypeFlag;
	}

	public void setpolTypeFlag(String apolTypeFlag)
	{
		polTypeFlag = apolTypeFlag;
	}

	public String getmainPolNo()
	{
		if (mainPolNo != null)
			mainPolNo.equals("");
		return mainPolNo;
	}

	public void setmainPolNo(String amainPolNo)
	{
		mainPolNo = amainPolNo;
	}

	public String getmasterPolNo()
	{
		if (masterPolNo != null)
			masterPolNo.equals("");
		return masterPolNo;
	}

	public void setmasterPolNo(String amasterPolNo)
	{
		masterPolNo = amasterPolNo;
	}

	public String getkindCode()
	{
		if (kindCode != null)
			kindCode.equals("");
		return kindCode;
	}

	public void setkindCode(String akindCode)
	{
		kindCode = akindCode;
	}

	public String getriskCode()
	{
		if (riskCode != null)
			riskCode.equals("");
		return riskCode;
	}

	public void setriskCode(String ariskCode)
	{
		riskCode = ariskCode;
	}

	public String getriskVersion()
	{
		if (riskVersion != null)
			riskVersion.equals("");
		return riskVersion;
	}

	public void setriskVersion(String ariskVersion)
	{
		riskVersion = ariskVersion;
	}

	public String getmanageCom()
	{
		if (manageCom != null)
			manageCom.equals("");
		return manageCom;
	}

	public void setmanageCom(String amanageCom)
	{
		manageCom = amanageCom;
	}

	public String getagentCom()
	{
		if (agentCom != null)
			agentCom.equals("");
		return agentCom;
	}

	public void setagentCom(String aagentCom)
	{
		agentCom = aagentCom;
	}

	public String getagentType()
	{
		if (agentType != null)
			agentType.equals("");
		return agentType;
	}

	public void setagentType(String aagentType)
	{
		agentType = aagentType;
	}

	public String getagentCode()
	{
		if (agentCode != null)
			agentCode.equals("");
		return agentCode;
	}

	public void setagentCode(String aagentCode)
	{
		agentCode = aagentCode;
	}

	public String getagentGroup()
	{
		if (agentGroup != null)
			agentGroup.equals("");
		return agentGroup;
	}

	public void setagentGroup(String aagentGroup)
	{
		agentGroup = aagentGroup;
	}

	public String getagentGroup1()
	{
		if (agentGroup1 != null)
			agentGroup1.equals("");
		return agentGroup1;
	}

	public void setagentGroup1(String aagentGroup1)
	{
		agentGroup1 = aagentGroup1;
	}

	public String getagentCode1()
	{
		if (agentCode1 != null)
			agentCode1.equals("");
		return agentCode1;
	}

	public void setagentCode1(String aagentCode1)
	{
		agentCode1 = aagentCode1;
	}

	public String getsaleChnl()
	{
		if (saleChnl != null)
			saleChnl.equals("");
		return saleChnl;
	}

	public void setsaleChnl(String asaleChnl)
	{
		saleChnl = asaleChnl;
	}

	public String gethandler()
	{
		if (handler != null)
			handler.equals("");
		return handler;
	}

	public void sethandler(String ahandler)
	{
		handler = ahandler;
	}

	public String getinsuredNo()
	{
		if (insuredNo != null)
			insuredNo.equals("");
		return insuredNo;
	}

	public void setinsuredNo(String ainsuredNo)
	{
		insuredNo = ainsuredNo;
	}

	public String getinsuredId()
	{
		if (insuredId != null)
			insuredId.equals("");
		return insuredId;
	}

	public void setinsuredId(String ainsuredId)
	{
		insuredId = ainsuredId;
	}

	public String getinsuredName()
	{
		if (insuredName != null)
			insuredName.equals("");
		return insuredName;
	}

	public void setinsuredName(String ainsuredName)
	{
		insuredName = ainsuredName;
	}

	public String getinsuredSex()
	{
		if (insuredSex != null)
			insuredSex.equals("");
		return insuredSex;
	}

	public void setinsuredSex(String ainsuredSex)
	{
		insuredSex = ainsuredSex;
	}

	public String getinsuredBirthday()
	{
		if (insuredBirthday != null)
			return fDate.getString(insuredBirthday);
		else
			return null;
	}

	public void setinsuredBirthday(Date ainsuredBirthday)
	{
		insuredBirthday = ainsuredBirthday;
	}

	public void setinsuredBirthday(String ainsuredBirthday)
	{
		if (ainsuredBirthday != null && !ainsuredBirthday.equals(""))
			insuredBirthday = fDate.getDate(ainsuredBirthday);
		else
			insuredBirthday = null;
	}

	public int getinsuredAppAge()
	{
		return insuredAppAge;
	}

	public void setinsuredAppAge(int ainsuredAppAge)
	{
		insuredAppAge = ainsuredAppAge;
	}

	public void setinsuredAppAge(String ainsuredAppAge)
	{
		if (ainsuredAppAge != null && !ainsuredAppAge.equals(""))
		{
			Integer tInteger = new Integer(ainsuredAppAge);
			int i = tInteger.intValue();
			insuredAppAge = i;
		}
	}

	public int getinsuredPeoples()
	{
		return insuredPeoples;
	}

	public void setinsuredPeoples(int ainsuredPeoples)
	{
		insuredPeoples = ainsuredPeoples;
	}

	public void setinsuredPeoples(String ainsuredPeoples)
	{
		if (ainsuredPeoples != null && !ainsuredPeoples.equals(""))
		{
			Integer tInteger = new Integer(ainsuredPeoples);
			int i = tInteger.intValue();
			insuredPeoples = i;
		}
	}

	public String getoccupationType()
	{
		if (occupationType != null)
			occupationType.equals("");
		return occupationType;
	}

	public void setoccupationType(String aoccupationType)
	{
		occupationType = aoccupationType;
	}

	public String getappntNo()
	{
		if (appntNo != null)
			appntNo.equals("");
		return appntNo;
	}

	public void setappntNo(String aappntNo)
	{
		appntNo = aappntNo;
	}

	public String getappntName()
	{
		if (appntName != null)
			appntName.equals("");
		return appntName;
	}

	public void setappntName(String aappntName)
	{
		appntName = aappntName;
	}

	public String getcValiDate()
	{
		if (cValiDate != null)
			return fDate.getString(cValiDate);
		else
			return null;
	}

	public void setcValiDate(Date acValiDate)
	{
		cValiDate = acValiDate;
	}

	public void setcValiDate(String acValiDate)
	{
		if (acValiDate != null && !acValiDate.equals(""))
			cValiDate = fDate.getDate(acValiDate);
		else
			cValiDate = null;
	}

	public String getsignCom()
	{
		if (signCom != null)
			signCom.equals("");
		return signCom;
	}

	public void setsignCom(String asignCom)
	{
		signCom = asignCom;
	}

	public String getsignDate()
	{
		if (signDate != null)
			return fDate.getString(signDate);
		else
			return null;
	}

	public void setsignDate(Date asignDate)
	{
		signDate = asignDate;
	}

	public void setsignDate(String asignDate)
	{
		if (asignDate != null && !asignDate.equals(""))
			signDate = fDate.getDate(asignDate);
		else
			signDate = null;
	}

	public String getsignTime()
	{
		if (signTime != null)
			signTime.equals("");
		return signTime;
	}

	public void setsignTime(String asignTime)
	{
		signTime = asignTime;
	}

	public String getfirstPayDate()
	{
		if (firstPayDate != null)
			return fDate.getString(firstPayDate);
		else
			return null;
	}

	public void setfirstPayDate(Date afirstPayDate)
	{
		firstPayDate = afirstPayDate;
	}

	public void setfirstPayDate(String afirstPayDate)
	{
		if (afirstPayDate != null && !afirstPayDate.equals(""))
			firstPayDate = fDate.getDate(afirstPayDate);
		else
			firstPayDate = null;
	}

	public String getpayEndDate()
	{
		if (payEndDate != null)
			return fDate.getString(payEndDate);
		else
			return null;
	}

	public void setpayEndDate(Date apayEndDate)
	{
		payEndDate = apayEndDate;
	}

	public void setpayEndDate(String apayEndDate)
	{
		if (apayEndDate != null && !apayEndDate.equals(""))
			payEndDate = fDate.getDate(apayEndDate);
		else
			payEndDate = null;
	}

	public String getpaytoDate()
	{
		if (paytoDate != null)
			return fDate.getString(paytoDate);
		else
			return null;
	}

	public void setpaytoDate(Date apaytoDate)
	{
		paytoDate = apaytoDate;
	}

	public void setpaytoDate(String apaytoDate)
	{
		if (apaytoDate != null && !apaytoDate.equals(""))
			paytoDate = fDate.getDate(apaytoDate);
		else
			paytoDate = null;
	}

	public String getgetStartDate()
	{
		if (getStartDate != null)
			return fDate.getString(getStartDate);
		else
			return null;
	}

	public void setgetStartDate(Date agetStartDate)
	{
		getStartDate = agetStartDate;
	}

	public void setgetStartDate(String agetStartDate)
	{
		if (agetStartDate != null && !agetStartDate.equals(""))
			getStartDate = fDate.getDate(agetStartDate);
		else
			getStartDate = null;
	}

	public String getendDate()
	{
		if (endDate != null)
			return fDate.getString(endDate);
		else
			return null;
	}

	public void setendDate(Date aendDate)
	{
		endDate = aendDate;
	}

	public void setendDate(String aendDate)
	{
		if (aendDate != null && !aendDate.equals(""))
			endDate = fDate.getDate(aendDate);
		else
			endDate = null;
	}

	public String getacciEndDate()
	{
		if (acciEndDate != null)
			return fDate.getString(acciEndDate);
		else
			return null;
	}

	public void setacciEndDate(Date aacciEndDate)
	{
		acciEndDate = aacciEndDate;
	}

	public void setacciEndDate(String aacciEndDate)
	{
		if (aacciEndDate != null && !aacciEndDate.equals(""))
			acciEndDate = fDate.getDate(aacciEndDate);
		else
			acciEndDate = null;
	}

	public String getgetYearFlag()
	{
		if (getYearFlag != null)
			getYearFlag.equals("");
		return getYearFlag;
	}

	public void setgetYearFlag(String agetYearFlag)
	{
		getYearFlag = agetYearFlag;
	}

	public int getgetYear()
	{
		return getYear;
	}

	public void setgetYear(int agetYear)
	{
		getYear = agetYear;
	}

	public void setgetYear(String agetYear)
	{
		if (agetYear != null && !agetYear.equals(""))
		{
			Integer tInteger = new Integer(agetYear);
			int i = tInteger.intValue();
			getYear = i;
		}
	}

	public String getpayEndYearFlag()
	{
		if (payEndYearFlag != null)
			payEndYearFlag.equals("");
		return payEndYearFlag;
	}

	public void setpayEndYearFlag(String apayEndYearFlag)
	{
		payEndYearFlag = apayEndYearFlag;
	}

	public int getpayEndYear()
	{
		return payEndYear;
	}

	public void setpayEndYear(int apayEndYear)
	{
		payEndYear = apayEndYear;
	}

	public void setpayEndYear(String apayEndYear)
	{
		if (apayEndYear != null && !apayEndYear.equals(""))
		{
			Integer tInteger = new Integer(apayEndYear);
			int i = tInteger.intValue();
			payEndYear = i;
		}
	}

	public String getinsuYearFlag()
	{
		if (insuYearFlag != null)
			insuYearFlag.equals("");
		return insuYearFlag;
	}

	public void setinsuYearFlag(String ainsuYearFlag)
	{
		insuYearFlag = ainsuYearFlag;
	}

	public int getinsuYear()
	{
		return insuYear;
	}

	public void setinsuYear(int ainsuYear)
	{
		insuYear = ainsuYear;
	}

	public void setinsuYear(String ainsuYear)
	{
		if (ainsuYear != null && !ainsuYear.equals(""))
		{
			Integer tInteger = new Integer(ainsuYear);
			int i = tInteger.intValue();
			insuYear = i;
		}
	}

	public String getacciYearFlag()
	{
		if (acciYearFlag != null)
			acciYearFlag.equals("");
		return acciYearFlag;
	}

	public void setacciYearFlag(String aacciYearFlag)
	{
		acciYearFlag = aacciYearFlag;
	}

	public int getacciYear()
	{
		return acciYear;
	}

	public void setacciYear(int aacciYear)
	{
		acciYear = aacciYear;
	}

	public void setacciYear(String aacciYear)
	{
		if (aacciYear != null && !aacciYear.equals(""))
		{
			Integer tInteger = new Integer(aacciYear);
			int i = tInteger.intValue();
			acciYear = i;
		}
	}

	public String getgetStartType()
	{
		if (getStartType != null)
			getStartType.equals("");
		return getStartType;
	}

	public void setgetStartType(String agetStartType)
	{
		getStartType = agetStartType;
	}

	public String getspecifyValiDate()
	{
		if (specifyValiDate != null)
			specifyValiDate.equals("");
		return specifyValiDate;
	}

	public void setspecifyValiDate(String aspecifyValiDate)
	{
		specifyValiDate = aspecifyValiDate;
	}

	public String getpayMode()
	{
		if (payMode != null)
			payMode.equals("");
		return payMode;
	}

	public void setpayMode(String apayMode)
	{
		payMode = apayMode;
	}

	public String getpayLocation()
	{
		if (payLocation != null)
			payLocation.equals("");
		return payLocation;
	}

	public void setpayLocation(String apayLocation)
	{
		payLocation = apayLocation;
	}

	public int getpayIntv()
	{
		return payIntv;
	}

	public void setpayIntv(int apayIntv)
	{
		payIntv = apayIntv;
	}

	public void setpayIntv(String apayIntv)
	{
		if (apayIntv != null && !apayIntv.equals(""))
		{
			Integer tInteger = new Integer(apayIntv);
			int i = tInteger.intValue();
			payIntv = i;
		}
	}

	public int getpayYears()
	{
		return payYears;
	}

	public void setpayYears(int apayYears)
	{
		payYears = apayYears;
	}

	public void setpayYears(String apayYears)
	{
		if (apayYears != null && !apayYears.equals(""))
		{
			Integer tInteger = new Integer(apayYears);
			int i = tInteger.intValue();
			payYears = i;
		}
	}

	public int getyears()
	{
		return years;
	}

	public void setyears(int ayears)
	{
		years = ayears;
	}

	public void setyears(String ayears)
	{
		if (ayears != null && !ayears.equals(""))
		{
			Integer tInteger = new Integer(ayears);
			int i = tInteger.intValue();
			years = i;
		}
	}

	public double getmanageFeeRate()
	{
		return manageFeeRate;
	}

	public void setmanageFeeRate(double amanageFeeRate)
	{
		manageFeeRate = amanageFeeRate;
	}

	public void setmanageFeeRate(String amanageFeeRate)
	{
		if (amanageFeeRate != null && !amanageFeeRate.equals(""))
		{
			Double tDouble = new Double(amanageFeeRate);
			double d = tDouble.doubleValue();
			manageFeeRate = d;
		}
	}

	public double getfloatRate()
	{
		return floatRate;
	}

	public void setfloatRate(double afloatRate)
	{
		floatRate = afloatRate;
	}

	public void setfloatRate(String afloatRate)
	{
		if (afloatRate != null && !afloatRate.equals(""))
		{
			Double tDouble = new Double(afloatRate);
			double d = tDouble.doubleValue();
			floatRate = d;
		}
	}

	public double getpremRate()
	{
		return premRate;
	}

	public void setpremRate(double apremRate)
	{
		premRate = apremRate;
	}

	public void setpremRate(String apremRate)
	{
		if (apremRate != null && !apremRate.equals(""))
		{
			Double tDouble = new Double(apremRate);
			double d = tDouble.doubleValue();
			premRate = d;
		}
	}

	public String getpremToAmnt()
	{
		if (premToAmnt != null)
			premToAmnt.equals("");
		return premToAmnt;
	}

	public void setpremToAmnt(String apremToAmnt)
	{
		premToAmnt = apremToAmnt;
	}

	public double getmult()
	{
		return mult;
	}

	public void setmult(double amult)
	{
		mult = amult;
	}

	public void setmult(String amult)
	{
		if (amult != null && !amult.equals(""))
		{
			Double tDouble = new Double(amult);
			double d = tDouble.doubleValue();
			mult = d;
		}
	}

	public double getstandPrem()
	{
		return standPrem;
	}

	public void setstandPrem(double astandPrem)
	{
		standPrem = astandPrem;
	}

	public void setstandPrem(String astandPrem)
	{
		if (astandPrem != null && !astandPrem.equals(""))
		{
			Double tDouble = new Double(astandPrem);
			double d = tDouble.doubleValue();
			standPrem = d;
		}
	}

	public double getprem()
	{
		return prem;
	}

	public void setprem(double aprem)
	{
		prem = aprem;
	}

	public void setprem(String aprem)
	{
		if (aprem != null && !aprem.equals(""))
		{
			Double tDouble = new Double(aprem);
			double d = tDouble.doubleValue();
			prem = d;
		}
	}

	public double getsumPrem()
	{
		return sumPrem;
	}

	public void setsumPrem(double asumPrem)
	{
		sumPrem = asumPrem;
	}

	public void setsumPrem(String asumPrem)
	{
		if (asumPrem != null && !asumPrem.equals(""))
		{
			Double tDouble = new Double(asumPrem);
			double d = tDouble.doubleValue();
			sumPrem = d;
		}
	}

	public double getamnt()
	{
		return amnt;
	}

	public void setamnt(double aamnt)
	{
		amnt = aamnt;
	}

	public void setamnt(String aamnt)
	{
		if (aamnt != null && !aamnt.equals(""))
		{
			Double tDouble = new Double(aamnt);
			double d = tDouble.doubleValue();
			amnt = d;
		}
	}

	public double getriskAmnt()
	{
		return riskAmnt;
	}

	public void setriskAmnt(double ariskAmnt)
	{
		riskAmnt = ariskAmnt;
	}

	public void setriskAmnt(String ariskAmnt)
	{
		if (ariskAmnt != null && !ariskAmnt.equals(""))
		{
			Double tDouble = new Double(ariskAmnt);
			double d = tDouble.doubleValue();
			riskAmnt = d;
		}
	}

	public double getleavingMoney()
	{
		return leavingMoney;
	}

	public void setleavingMoney(double aleavingMoney)
	{
		leavingMoney = aleavingMoney;
	}

	public void setleavingMoney(String aleavingMoney)
	{
		if (aleavingMoney != null && !aleavingMoney.equals(""))
		{
			Double tDouble = new Double(aleavingMoney);
			double d = tDouble.doubleValue();
			leavingMoney = d;
		}
	}

	public int getendorseTimes()
	{
		return endorseTimes;
	}

	public void setendorseTimes(int aendorseTimes)
	{
		endorseTimes = aendorseTimes;
	}

	public void setendorseTimes(String aendorseTimes)
	{
		if (aendorseTimes != null && !aendorseTimes.equals(""))
		{
			Integer tInteger = new Integer(aendorseTimes);
			int i = tInteger.intValue();
			endorseTimes = i;
		}
	}

	public int getclaimTimes()
	{
		return claimTimes;
	}

	public void setclaimTimes(int aclaimTimes)
	{
		claimTimes = aclaimTimes;
	}

	public void setclaimTimes(String aclaimTimes)
	{
		if (aclaimTimes != null && !aclaimTimes.equals(""))
		{
			Integer tInteger = new Integer(aclaimTimes);
			int i = tInteger.intValue();
			claimTimes = i;
		}
	}

	public int getliveTimes()
	{
		return liveTimes;
	}

	public void setliveTimes(int aliveTimes)
	{
		liveTimes = aliveTimes;
	}

	public void setliveTimes(String aliveTimes)
	{
		if (aliveTimes != null && !aliveTimes.equals(""))
		{
			Integer tInteger = new Integer(aliveTimes);
			int i = tInteger.intValue();
			liveTimes = i;
		}
	}

	public int getrenewCount()
	{
		return renewCount;
	}

	public void setrenewCount(int arenewCount)
	{
		renewCount = arenewCount;
	}

	public void setrenewCount(String arenewCount)
	{
		if (arenewCount != null && !arenewCount.equals(""))
		{
			Integer tInteger = new Integer(arenewCount);
			int i = tInteger.intValue();
			renewCount = i;
		}
	}

	public String getlastGetDate()
	{
		if (lastGetDate != null)
			return fDate.getString(lastGetDate);
		else
			return null;
	}

	public void setlastGetDate(Date alastGetDate)
	{
		lastGetDate = alastGetDate;
	}

	public void setlastGetDate(String alastGetDate)
	{
		if (alastGetDate != null && !alastGetDate.equals(""))
			lastGetDate = fDate.getDate(alastGetDate);
		else
			lastGetDate = null;
	}

	public String getlastLoanDate()
	{
		if (lastLoanDate != null)
			return fDate.getString(lastLoanDate);
		else
			return null;
	}

	public void setlastLoanDate(Date alastLoanDate)
	{
		lastLoanDate = alastLoanDate;
	}

	public void setlastLoanDate(String alastLoanDate)
	{
		if (alastLoanDate != null && !alastLoanDate.equals(""))
			lastLoanDate = fDate.getDate(alastLoanDate);
		else
			lastLoanDate = null;
	}

	public String getlastRegetDate()
	{
		if (lastRegetDate != null)
			return fDate.getString(lastRegetDate);
		else
			return null;
	}

	public void setlastRegetDate(Date alastRegetDate)
	{
		lastRegetDate = alastRegetDate;
	}

	public void setlastRegetDate(String alastRegetDate)
	{
		if (alastRegetDate != null && !alastRegetDate.equals(""))
			lastRegetDate = fDate.getDate(alastRegetDate);
		else
			lastRegetDate = null;
	}

	public String getlastEdorDate()
	{
		if (lastEdorDate != null)
			return fDate.getString(lastEdorDate);
		else
			return null;
	}

	public void setlastEdorDate(Date alastEdorDate)
	{
		lastEdorDate = alastEdorDate;
	}

	public void setlastEdorDate(String alastEdorDate)
	{
		if (alastEdorDate != null && !alastEdorDate.equals(""))
			lastEdorDate = fDate.getDate(alastEdorDate);
		else
			lastEdorDate = null;
	}

	public String getlastRevDate()
	{
		if (lastRevDate != null)
			return fDate.getString(lastRevDate);
		else
			return null;
	}

	public void setlastRevDate(Date alastRevDate)
	{
		lastRevDate = alastRevDate;
	}

	public void setlastRevDate(String alastRevDate)
	{
		if (alastRevDate != null && !alastRevDate.equals(""))
			lastRevDate = fDate.getDate(alastRevDate);
		else
			lastRevDate = null;
	}

	public String getrnewFlag()
	{
		if (rnewFlag != null)
			rnewFlag.equals("");
		return rnewFlag;
	}

	public void setrnewFlag(String arnewFlag)
	{
		rnewFlag = arnewFlag;
	}

	public String getstopFlag()
	{
		if (stopFlag != null)
			stopFlag.equals("");
		return stopFlag;
	}

	public void setstopFlag(String astopFlag)
	{
		stopFlag = astopFlag;
	}

	public String getexpiryFlag()
	{
		if (expiryFlag != null)
			expiryFlag.equals("");
		return expiryFlag;
	}

	public void setexpiryFlag(String aexpiryFlag)
	{
		expiryFlag = aexpiryFlag;
	}

	public String getautoPayFlag()
	{
		if (autoPayFlag != null)
			autoPayFlag.equals("");
		return autoPayFlag;
	}

	public void setautoPayFlag(String aautoPayFlag)
	{
		autoPayFlag = aautoPayFlag;
	}

	public String getinterestDifFlag()
	{
		if (interestDifFlag != null)
			interestDifFlag.equals("");
		return interestDifFlag;
	}

	public void setinterestDifFlag(String ainterestDifFlag)
	{
		interestDifFlag = ainterestDifFlag;
	}

	public String getsubFlag()
	{
		if (subFlag != null)
			subFlag.equals("");
		return subFlag;
	}

	public void setsubFlag(String asubFlag)
	{
		subFlag = asubFlag;
	}

	public String getbnfFlag()
	{
		if (bnfFlag != null)
			bnfFlag.equals("");
		return bnfFlag;
	}

	public void setbnfFlag(String abnfFlag)
	{
		bnfFlag = abnfFlag;
	}

	public String gethealthCheckFlag()
	{
		if (healthCheckFlag != null)
			healthCheckFlag.equals("");
		return healthCheckFlag;
	}

	public void sethealthCheckFlag(String ahealthCheckFlag)
	{
		healthCheckFlag = ahealthCheckFlag;
	}

	public String getimpartFlag()
	{
		if (impartFlag != null)
			impartFlag.equals("");
		return impartFlag;
	}

	public void setimpartFlag(String aimpartFlag)
	{
		impartFlag = aimpartFlag;
	}

	public String getreinsureFlag()
	{
		if (reinsureFlag != null)
			reinsureFlag.equals("");
		return reinsureFlag;
	}

	public void setreinsureFlag(String areinsureFlag)
	{
		reinsureFlag = areinsureFlag;
	}

	public String getagentPayFlag()
	{
		if (agentPayFlag != null)
			agentPayFlag.equals("");
		return agentPayFlag;
	}

	public void setagentPayFlag(String aagentPayFlag)
	{
		agentPayFlag = aagentPayFlag;
	}

	public String getagentGetFlag()
	{
		if (agentGetFlag != null)
			agentGetFlag.equals("");
		return agentGetFlag;
	}

	public void setagentGetFlag(String aagentGetFlag)
	{
		agentGetFlag = aagentGetFlag;
	}

	public String getliveGetMode()
	{
		if (liveGetMode != null)
			liveGetMode.equals("");
		return liveGetMode;
	}

	public void setliveGetMode(String aliveGetMode)
	{
		liveGetMode = aliveGetMode;
	}

	public String getdeadGetMode()
	{
		if (deadGetMode != null)
			deadGetMode.equals("");
		return deadGetMode;
	}

	public void setdeadGetMode(String adeadGetMode)
	{
		deadGetMode = adeadGetMode;
	}

	public String getbonusGetMode()
	{
		if (bonusGetMode != null)
			bonusGetMode.equals("");
		return bonusGetMode;
	}

	public void setbonusGetMode(String abonusGetMode)
	{
		bonusGetMode = abonusGetMode;
	}

	public String getdeadAmntType()
	{
		if (deadAmntType != null)
			deadAmntType.equals("");
		return deadAmntType;
	}

	public void setdeadAmntType(String adeadAmntType)
	{
		deadAmntType = adeadAmntType;
	}

	public double gettopUpPrem()
	{
		return topUpPrem;
	}

	public void settopUpPrem(double atopUpPrem)
	{
		topUpPrem = atopUpPrem;
	}

	public void settopUpPrem(String atopUpPrem)
	{
		if (atopUpPrem != null && !atopUpPrem.equals(""))
		{
			Double tDouble = new Double(atopUpPrem);
			double d = tDouble.doubleValue();
			topUpPrem = d;
		}
	}

	public String getbonusMan()
	{
		if (bonusMan != null)
			bonusMan.equals("");
		return bonusMan;
	}

	public void setbonusMan(String abonusMan)
	{
		bonusMan = abonusMan;
	}

	public String getdeadFlag()
	{
		if (deadFlag != null)
			deadFlag.equals("");
		return deadFlag;
	}

	public void setdeadFlag(String adeadFlag)
	{
		deadFlag = adeadFlag;
	}

	public String getsmokeFlag()
	{
		if (smokeFlag != null)
			smokeFlag.equals("");
		return smokeFlag;
	}

	public void setsmokeFlag(String asmokeFlag)
	{
		smokeFlag = asmokeFlag;
	}

	public String getremark()
	{
		if (remark != null)
			remark.equals("");
		return remark;
	}

	public void setremark(String aremark)
	{
		remark = aremark;
	}

	public String getapproveFlag()
	{
		if (approveFlag != null)
			approveFlag.equals("");
		return approveFlag;
	}

	public void setapproveFlag(String aapproveFlag)
	{
		approveFlag = aapproveFlag;
	}

	public String getapproveCode()
	{
		if (approveCode != null)
			approveCode.equals("");
		return approveCode;
	}

	public void setapproveCode(String aapproveCode)
	{
		approveCode = aapproveCode;
	}

	public String getapproveDate()
	{
		if (approveDate != null)
			return fDate.getString(approveDate);
		else
			return null;
	}

	public void setapproveDate(Date aapproveDate)
	{
		approveDate = aapproveDate;
	}

	public void setapproveDate(String aapproveDate)
	{
		if (aapproveDate != null && !aapproveDate.equals(""))
			approveDate = fDate.getDate(aapproveDate);
		else
			approveDate = null;
	}

	public String getapproveTime()
	{
		if (approveTime != null)
			approveTime.equals("");
		return approveTime;
	}

	public void setapproveTime(String aapproveTime)
	{
		approveTime = aapproveTime;
	}

	public String getuWFlag()
	{
		if (uWFlag != null)
			uWFlag.equals("");
		return uWFlag;
	}

	public void setuWFlag(String auWFlag)
	{
		uWFlag = auWFlag;
	}

	public String getuWCode()
	{
		if (uWCode != null)
			uWCode.equals("");
		return uWCode;
	}

	public void setuWCode(String auWCode)
	{
		uWCode = auWCode;
	}

	public String getuWDate()
	{
		if (uWDate != null)
			return fDate.getString(uWDate);
		else
			return null;
	}

	public void setuWDate(Date auWDate)
	{
		uWDate = auWDate;
	}

	public void setuWDate(String auWDate)
	{
		if (auWDate != null && !auWDate.equals(""))
			uWDate = fDate.getDate(auWDate);
		else
			uWDate = null;
	}

	public String getuWTime()
	{
		if (uWTime != null)
			uWTime.equals("");
		return uWTime;
	}

	public void setuWTime(String auWTime)
	{
		uWTime = auWTime;
	}

	public String getpolApplyDate()
	{
		if (polApplyDate != null)
			return fDate.getString(polApplyDate);
		else
			return null;
	}

	public void setpolApplyDate(Date apolApplyDate)
	{
		polApplyDate = apolApplyDate;
	}

	public void setpolApplyDate(String apolApplyDate)
	{
		if (apolApplyDate != null && !apolApplyDate.equals(""))
			polApplyDate = fDate.getDate(apolApplyDate);
		else
			polApplyDate = null;
	}

	public String getappFlag()
	{
		if (appFlag != null)
			appFlag.equals("");
		return appFlag;
	}

	public void setappFlag(String aappFlag)
	{
		appFlag = aappFlag;
	}

	public String getsaleChnlDetail()
	{
		if (saleChnlDetail != null)
			saleChnlDetail.equals("");
		return saleChnlDetail;
	}

	public void setsaleChnlDetail(String asaleChnlDetail)
	{
		saleChnlDetail = asaleChnlDetail;
	}

	public String getpolState()
	{
		if (polState != null)
			polState.equals("");
		return polState;
	}

	public void setpolState(String apolState)
	{
		polState = apolState;
	}

	public String getstandbyFlag1()
	{
		if (standbyFlag1 != null)
			standbyFlag1.equals("");
		return standbyFlag1;
	}

	public void setstandbyFlag1(String astandbyFlag1)
	{
		standbyFlag1 = astandbyFlag1;
	}

	public String getstandbyFlag2()
	{
		if (standbyFlag2 != null)
			standbyFlag2.equals("");
		return standbyFlag2;
	}

	public void setstandbyFlag2(String astandbyFlag2)
	{
		standbyFlag2 = astandbyFlag2;
	}

	public String getstandbyFlag3()
	{
		if (standbyFlag3 != null)
			standbyFlag3.equals("");
		return standbyFlag3;
	}

	public void setstandbyFlag3(String astandbyFlag3)
	{
		standbyFlag3 = astandbyFlag3;
	}

	public String getoperator()
	{
		if (operator != null)
			operator.equals("");
		return operator;
	}

	public void setoperator(String aoperator)
	{
		operator = aoperator;
	}

	public String getmakeDate()
	{
		if (makeDate != null)
			return fDate.getString(makeDate);
		else
			return null;
	}

	public void setmakeDate(Date amakeDate)
	{
		makeDate = amakeDate;
	}

	public void setmakeDate(String amakeDate)
	{
		if (amakeDate != null && !amakeDate.equals(""))
			makeDate = fDate.getDate(amakeDate);
		else
			makeDate = null;
	}

	public String getmakeTime()
	{
		if (makeTime != null)
			makeTime.equals("");
		return makeTime;
	}

	public void setmakeTime(String amakeTime)
	{
		makeTime = amakeTime;
	}

	public String getmodifyDate()
	{
		if (modifyDate != null)
			return fDate.getString(modifyDate);
		else
			return null;
	}

	public void setmodifyDate(Date amodifyDate)
	{
		modifyDate = amodifyDate;
	}

	public void setmodifyDate(String amodifyDate)
	{
		if (amodifyDate != null && !amodifyDate.equals(""))
			modifyDate = fDate.getDate(amodifyDate);
		else
			modifyDate = null;
	}

	public String getmodifyTime()
	{
		if (modifyTime != null)
			modifyTime.equals("");
		return modifyTime;
	}

	public void setmodifyTime(String amodifyTime)
	{
		modifyTime = amodifyTime;
	}

	public void setSchema(LNPPolBSchema aLNPPolBSchema)
	{
		EdorNo = aLNPPolBSchema.getEdorNo();
		serialNo = aLNPPolBSchema.getserialNo();
		grpContNo = aLNPPolBSchema.getgrpContNo();
		grpPolNo = aLNPPolBSchema.getgrpPolNo();
		contNo = aLNPPolBSchema.getcontNo();
		proposalContNo = aLNPPolBSchema.getproposalContNo();
		polNo = aLNPPolBSchema.getpolNo();
		proposalNo = aLNPPolBSchema.getproposalNo();
		prtNo = aLNPPolBSchema.getprtNo();
		contType = aLNPPolBSchema.getcontType();
		polTypeFlag = aLNPPolBSchema.getpolTypeFlag();
		mainPolNo = aLNPPolBSchema.getmainPolNo();
		masterPolNo = aLNPPolBSchema.getmasterPolNo();
		kindCode = aLNPPolBSchema.getkindCode();
		riskCode = aLNPPolBSchema.getriskCode();
		riskVersion = aLNPPolBSchema.getriskVersion();
		manageCom = aLNPPolBSchema.getmanageCom();
		agentCom = aLNPPolBSchema.getagentCom();
		agentType = aLNPPolBSchema.getagentType();
		agentCode = aLNPPolBSchema.getagentCode();
		agentGroup = aLNPPolBSchema.getagentGroup();
		agentGroup1 = aLNPPolBSchema.getagentGroup1();
		agentCode1 = aLNPPolBSchema.getagentCode1();
		saleChnl = aLNPPolBSchema.getsaleChnl();
		handler = aLNPPolBSchema.gethandler();
		insuredNo = aLNPPolBSchema.getinsuredNo();
		insuredId = aLNPPolBSchema.getinsuredId();
		insuredName = aLNPPolBSchema.getinsuredName();
		insuredSex = aLNPPolBSchema.getinsuredSex();
		insuredBirthday = fDate.getDate(aLNPPolBSchema.getinsuredBirthday());
		insuredAppAge = aLNPPolBSchema.getinsuredAppAge();
		insuredPeoples = aLNPPolBSchema.getinsuredPeoples();
		occupationType = aLNPPolBSchema.getoccupationType();
		appntNo = aLNPPolBSchema.getappntNo();
		appntName = aLNPPolBSchema.getappntName();
		cValiDate = fDate.getDate(aLNPPolBSchema.getcValiDate());
		signCom = aLNPPolBSchema.getsignCom();
		signDate = fDate.getDate(aLNPPolBSchema.getsignDate());
		signTime = aLNPPolBSchema.getsignTime();
		firstPayDate = fDate.getDate(aLNPPolBSchema.getfirstPayDate());
		payEndDate = fDate.getDate(aLNPPolBSchema.getpayEndDate());
		paytoDate = fDate.getDate(aLNPPolBSchema.getpaytoDate());
		getStartDate = fDate.getDate(aLNPPolBSchema.getgetStartDate());
		endDate = fDate.getDate(aLNPPolBSchema.getendDate());
		acciEndDate = fDate.getDate(aLNPPolBSchema.getacciEndDate());
		getYearFlag = aLNPPolBSchema.getgetYearFlag();
		getYear = aLNPPolBSchema.getgetYear();
		payEndYearFlag = aLNPPolBSchema.getpayEndYearFlag();
		payEndYear = aLNPPolBSchema.getpayEndYear();
		insuYearFlag = aLNPPolBSchema.getinsuYearFlag();
		insuYear = aLNPPolBSchema.getinsuYear();
		acciYearFlag = aLNPPolBSchema.getacciYearFlag();
		acciYear = aLNPPolBSchema.getacciYear();
		getStartType = aLNPPolBSchema.getgetStartType();
		specifyValiDate = aLNPPolBSchema.getspecifyValiDate();
		payMode = aLNPPolBSchema.getpayMode();
		payLocation = aLNPPolBSchema.getpayLocation();
		payIntv = aLNPPolBSchema.getpayIntv();
		payYears = aLNPPolBSchema.getpayYears();
		years = aLNPPolBSchema.getyears();
		manageFeeRate = aLNPPolBSchema.getmanageFeeRate();
		floatRate = aLNPPolBSchema.getfloatRate();
		premRate = aLNPPolBSchema.getpremRate();
		premToAmnt = aLNPPolBSchema.getpremToAmnt();
		mult = aLNPPolBSchema.getmult();
		standPrem = aLNPPolBSchema.getstandPrem();
		prem = aLNPPolBSchema.getprem();
		sumPrem = aLNPPolBSchema.getsumPrem();
		amnt = aLNPPolBSchema.getamnt();
		riskAmnt = aLNPPolBSchema.getriskAmnt();
		leavingMoney = aLNPPolBSchema.getleavingMoney();
		endorseTimes = aLNPPolBSchema.getendorseTimes();
		claimTimes = aLNPPolBSchema.getclaimTimes();
		liveTimes = aLNPPolBSchema.getliveTimes();
		renewCount = aLNPPolBSchema.getrenewCount();
		lastGetDate = fDate.getDate(aLNPPolBSchema.getlastGetDate());
		lastLoanDate = fDate.getDate(aLNPPolBSchema.getlastLoanDate());
		lastRegetDate = fDate.getDate(aLNPPolBSchema.getlastRegetDate());
		lastEdorDate = fDate.getDate(aLNPPolBSchema.getlastEdorDate());
		lastRevDate = fDate.getDate(aLNPPolBSchema.getlastRevDate());
		rnewFlag = aLNPPolBSchema.getrnewFlag();
		stopFlag = aLNPPolBSchema.getstopFlag();
		expiryFlag = aLNPPolBSchema.getexpiryFlag();
		autoPayFlag = aLNPPolBSchema.getautoPayFlag();
		interestDifFlag = aLNPPolBSchema.getinterestDifFlag();
		subFlag = aLNPPolBSchema.getsubFlag();
		bnfFlag = aLNPPolBSchema.getbnfFlag();
		healthCheckFlag = aLNPPolBSchema.gethealthCheckFlag();
		impartFlag = aLNPPolBSchema.getimpartFlag();
		reinsureFlag = aLNPPolBSchema.getreinsureFlag();
		agentPayFlag = aLNPPolBSchema.getagentPayFlag();
		agentGetFlag = aLNPPolBSchema.getagentGetFlag();
		liveGetMode = aLNPPolBSchema.getliveGetMode();
		deadGetMode = aLNPPolBSchema.getdeadGetMode();
		bonusGetMode = aLNPPolBSchema.getbonusGetMode();
		deadAmntType = aLNPPolBSchema.getdeadAmntType();
		topUpPrem = aLNPPolBSchema.gettopUpPrem();
		bonusMan = aLNPPolBSchema.getbonusMan();
		deadFlag = aLNPPolBSchema.getdeadFlag();
		smokeFlag = aLNPPolBSchema.getsmokeFlag();
		remark = aLNPPolBSchema.getremark();
		approveFlag = aLNPPolBSchema.getapproveFlag();
		approveCode = aLNPPolBSchema.getapproveCode();
		approveDate = fDate.getDate(aLNPPolBSchema.getapproveDate());
		approveTime = aLNPPolBSchema.getapproveTime();
		uWFlag = aLNPPolBSchema.getuWFlag();
		uWCode = aLNPPolBSchema.getuWCode();
		uWDate = fDate.getDate(aLNPPolBSchema.getuWDate());
		uWTime = aLNPPolBSchema.getuWTime();
		polApplyDate = fDate.getDate(aLNPPolBSchema.getpolApplyDate());
		appFlag = aLNPPolBSchema.getappFlag();
		saleChnlDetail = aLNPPolBSchema.getsaleChnlDetail();
		polState = aLNPPolBSchema.getpolState();
		standbyFlag1 = aLNPPolBSchema.getstandbyFlag1();
		standbyFlag2 = aLNPPolBSchema.getstandbyFlag2();
		standbyFlag3 = aLNPPolBSchema.getstandbyFlag3();
		operator = aLNPPolBSchema.getoperator();
		makeDate = fDate.getDate(aLNPPolBSchema.getmakeDate());
		makeTime = aLNPPolBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPPolBSchema.getmodifyDate());
		modifyTime = aLNPPolBSchema.getmodifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("EdorNo") == null)
				EdorNo = null;
			else
				EdorNo = rs.getString("EdorNo").trim();
			if (rs.getString("serialNo") == null)
				serialNo = null;
			else
				serialNo = rs.getString("serialNo").trim();
			if (rs.getString("grpContNo") == null)
				grpContNo = null;
			else
				grpContNo = rs.getString("grpContNo").trim();
			if (rs.getString("grpPolNo") == null)
				grpPolNo = null;
			else
				grpPolNo = rs.getString("grpPolNo").trim();
			if (rs.getString("contNo") == null)
				contNo = null;
			else
				contNo = rs.getString("contNo").trim();
			if (rs.getString("proposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("proposalContNo").trim();
			if (rs.getString("polNo") == null)
				polNo = null;
			else
				polNo = rs.getString("polNo").trim();
			if (rs.getString("proposalNo") == null)
				proposalNo = null;
			else
				proposalNo = rs.getString("proposalNo").trim();
			if (rs.getString("prtNo") == null)
				prtNo = null;
			else
				prtNo = rs.getString("prtNo").trim();
			if (rs.getString("contType") == null)
				contType = null;
			else
				contType = rs.getString("contType").trim();
			if (rs.getString("polTypeFlag") == null)
				polTypeFlag = null;
			else
				polTypeFlag = rs.getString("polTypeFlag").trim();
			if (rs.getString("mainPolNo") == null)
				mainPolNo = null;
			else
				mainPolNo = rs.getString("mainPolNo").trim();
			if (rs.getString("masterPolNo") == null)
				masterPolNo = null;
			else
				masterPolNo = rs.getString("masterPolNo").trim();
			if (rs.getString("kindCode") == null)
				kindCode = null;
			else
				kindCode = rs.getString("kindCode").trim();
			if (rs.getString("riskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("riskCode").trim();
			if (rs.getString("riskVersion") == null)
				riskVersion = null;
			else
				riskVersion = rs.getString("riskVersion").trim();
			if (rs.getString("manageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("manageCom").trim();
			if (rs.getString("agentCom") == null)
				agentCom = null;
			else
				agentCom = rs.getString("agentCom").trim();
			if (rs.getString("agentType") == null)
				agentType = null;
			else
				agentType = rs.getString("agentType").trim();
			if (rs.getString("agentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("agentCode").trim();
			if (rs.getString("agentGroup") == null)
				agentGroup = null;
			else
				agentGroup = rs.getString("agentGroup").trim();
			if (rs.getString("agentGroup1") == null)
				agentGroup1 = null;
			else
				agentGroup1 = rs.getString("agentGroup1").trim();
			if (rs.getString("agentCode1") == null)
				agentCode1 = null;
			else
				agentCode1 = rs.getString("agentCode1").trim();
			if (rs.getString("saleChnl") == null)
				saleChnl = null;
			else
				saleChnl = rs.getString("saleChnl").trim();
			if (rs.getString("handler") == null)
				handler = null;
			else
				handler = rs.getString("handler").trim();
			if (rs.getString("insuredNo") == null)
				insuredNo = null;
			else
				insuredNo = rs.getString("insuredNo").trim();
			if (rs.getString("insuredId") == null)
				insuredId = null;
			else
				insuredId = rs.getString("insuredId").trim();
			if (rs.getString("insuredName") == null)
				insuredName = null;
			else
				insuredName = rs.getString("insuredName").trim();
			if (rs.getString("insuredSex") == null)
				insuredSex = null;
			else
				insuredSex = rs.getString("insuredSex").trim();
			insuredBirthday = rs.getDate("insuredBirthday");
			insuredAppAge = rs.getInt("insuredAppAge");
			insuredPeoples = rs.getInt("insuredPeoples");
			if (rs.getString("occupationType") == null)
				occupationType = null;
			else
				occupationType = rs.getString("occupationType").trim();
			if (rs.getString("appntNo") == null)
				appntNo = null;
			else
				appntNo = rs.getString("appntNo").trim();
			if (rs.getString("appntName") == null)
				appntName = null;
			else
				appntName = rs.getString("appntName").trim();
			cValiDate = rs.getDate("cValiDate");
			if (rs.getString("signCom") == null)
				signCom = null;
			else
				signCom = rs.getString("signCom").trim();
			signDate = rs.getDate("signDate");
			if (rs.getString("signTime") == null)
				signTime = null;
			else
				signTime = rs.getString("signTime").trim();
			firstPayDate = rs.getDate("firstPayDate");
			payEndDate = rs.getDate("payEndDate");
			paytoDate = rs.getDate("paytoDate");
			getStartDate = rs.getDate("getStartDate");
			endDate = rs.getDate("endDate");
			acciEndDate = rs.getDate("acciEndDate");
			if (rs.getString("getYearFlag") == null)
				getYearFlag = null;
			else
				getYearFlag = rs.getString("getYearFlag").trim();
			getYear = rs.getInt("getYear");
			if (rs.getString("payEndYearFlag") == null)
				payEndYearFlag = null;
			else
				payEndYearFlag = rs.getString("payEndYearFlag").trim();
			payEndYear = rs.getInt("payEndYear");
			if (rs.getString("insuYearFlag") == null)
				insuYearFlag = null;
			else
				insuYearFlag = rs.getString("insuYearFlag").trim();
			insuYear = rs.getInt("insuYear");
			if (rs.getString("acciYearFlag") == null)
				acciYearFlag = null;
			else
				acciYearFlag = rs.getString("acciYearFlag").trim();
			acciYear = rs.getInt("acciYear");
			if (rs.getString("getStartType") == null)
				getStartType = null;
			else
				getStartType = rs.getString("getStartType").trim();
			if (rs.getString("specifyValiDate") == null)
				specifyValiDate = null;
			else
				specifyValiDate = rs.getString("specifyValiDate").trim();
			if (rs.getString("payMode") == null)
				payMode = null;
			else
				payMode = rs.getString("payMode").trim();
			if (rs.getString("payLocation") == null)
				payLocation = null;
			else
				payLocation = rs.getString("payLocation").trim();
			payIntv = rs.getInt("payIntv");
			payYears = rs.getInt("payYears");
			years = rs.getInt("years");
			manageFeeRate = rs.getDouble("manageFeeRate");
			floatRate = rs.getDouble("floatRate");
			premRate = rs.getDouble("premRate");
			if (rs.getString("premToAmnt") == null)
				premToAmnt = null;
			else
				premToAmnt = rs.getString("premToAmnt").trim();
			mult = rs.getDouble("mult");
			standPrem = rs.getDouble("standPrem");
			prem = rs.getDouble("prem");
			sumPrem = rs.getDouble("sumPrem");
			amnt = rs.getDouble("amnt");
			riskAmnt = rs.getDouble("riskAmnt");
			leavingMoney = rs.getDouble("leavingMoney");
			endorseTimes = rs.getInt("endorseTimes");
			claimTimes = rs.getInt("claimTimes");
			liveTimes = rs.getInt("liveTimes");
			renewCount = rs.getInt("renewCount");
			lastGetDate = rs.getDate("lastGetDate");
			lastLoanDate = rs.getDate("lastLoanDate");
			lastRegetDate = rs.getDate("lastRegetDate");
			lastEdorDate = rs.getDate("lastEdorDate");
			lastRevDate = rs.getDate("lastRevDate");
			if (rs.getString("rnewFlag") == null)
				rnewFlag = null;
			else
				rnewFlag = rs.getString("rnewFlag").trim();
			if (rs.getString("stopFlag") == null)
				stopFlag = null;
			else
				stopFlag = rs.getString("stopFlag").trim();
			if (rs.getString("expiryFlag") == null)
				expiryFlag = null;
			else
				expiryFlag = rs.getString("expiryFlag").trim();
			if (rs.getString("autoPayFlag") == null)
				autoPayFlag = null;
			else
				autoPayFlag = rs.getString("autoPayFlag").trim();
			if (rs.getString("interestDifFlag") == null)
				interestDifFlag = null;
			else
				interestDifFlag = rs.getString("interestDifFlag").trim();
			if (rs.getString("subFlag") == null)
				subFlag = null;
			else
				subFlag = rs.getString("subFlag").trim();
			if (rs.getString("bnfFlag") == null)
				bnfFlag = null;
			else
				bnfFlag = rs.getString("bnfFlag").trim();
			if (rs.getString("healthCheckFlag") == null)
				healthCheckFlag = null;
			else
				healthCheckFlag = rs.getString("healthCheckFlag").trim();
			if (rs.getString("impartFlag") == null)
				impartFlag = null;
			else
				impartFlag = rs.getString("impartFlag").trim();
			if (rs.getString("reinsureFlag") == null)
				reinsureFlag = null;
			else
				reinsureFlag = rs.getString("reinsureFlag").trim();
			if (rs.getString("agentPayFlag") == null)
				agentPayFlag = null;
			else
				agentPayFlag = rs.getString("agentPayFlag").trim();
			if (rs.getString("agentGetFlag") == null)
				agentGetFlag = null;
			else
				agentGetFlag = rs.getString("agentGetFlag").trim();
			if (rs.getString("liveGetMode") == null)
				liveGetMode = null;
			else
				liveGetMode = rs.getString("liveGetMode").trim();
			if (rs.getString("deadGetMode") == null)
				deadGetMode = null;
			else
				deadGetMode = rs.getString("deadGetMode").trim();
			if (rs.getString("bonusGetMode") == null)
				bonusGetMode = null;
			else
				bonusGetMode = rs.getString("bonusGetMode").trim();
			if (rs.getString("deadAmntType") == null)
				deadAmntType = null;
			else
				deadAmntType = rs.getString("deadAmntType").trim();
			topUpPrem = rs.getDouble("topUpPrem");
			if (rs.getString("bonusMan") == null)
				bonusMan = null;
			else
				bonusMan = rs.getString("bonusMan").trim();
			if (rs.getString("deadFlag") == null)
				deadFlag = null;
			else
				deadFlag = rs.getString("deadFlag").trim();
			if (rs.getString("smokeFlag") == null)
				smokeFlag = null;
			else
				smokeFlag = rs.getString("smokeFlag").trim();
			if (rs.getString("remark") == null)
				remark = null;
			else
				remark = rs.getString("remark").trim();
			if (rs.getString("approveFlag") == null)
				approveFlag = null;
			else
				approveFlag = rs.getString("approveFlag").trim();
			if (rs.getString("approveCode") == null)
				approveCode = null;
			else
				approveCode = rs.getString("approveCode").trim();
			approveDate = rs.getDate("approveDate");
			if (rs.getString("approveTime") == null)
				approveTime = null;
			else
				approveTime = rs.getString("approveTime").trim();
			if (rs.getString("uWFlag") == null)
				uWFlag = null;
			else
				uWFlag = rs.getString("uWFlag").trim();
			if (rs.getString("uWCode") == null)
				uWCode = null;
			else
				uWCode = rs.getString("uWCode").trim();
			uWDate = rs.getDate("uWDate");
			if (rs.getString("uWTime") == null)
				uWTime = null;
			else
				uWTime = rs.getString("uWTime").trim();
			polApplyDate = rs.getDate("polApplyDate");
			if (rs.getString("appFlag") == null)
				appFlag = null;
			else
				appFlag = rs.getString("appFlag").trim();
			if (rs.getString("saleChnlDetail") == null)
				saleChnlDetail = null;
			else
				saleChnlDetail = rs.getString("saleChnlDetail").trim();
			if (rs.getString("polState") == null)
				polState = null;
			else
				polState = rs.getString("polState").trim();
			if (rs.getString("standbyFlag1") == null)
				standbyFlag1 = null;
			else
				standbyFlag1 = rs.getString("standbyFlag1").trim();
			if (rs.getString("standbyFlag2") == null)
				standbyFlag2 = null;
			else
				standbyFlag2 = rs.getString("standbyFlag2").trim();
			if (rs.getString("standbyFlag3") == null)
				standbyFlag3 = null;
			else
				standbyFlag3 = rs.getString("standbyFlag3").trim();
			if (rs.getString("operator") == null)
				operator = null;
			else
				operator = rs.getString("operator").trim();
			makeDate = rs.getDate("makeDate");
			if (rs.getString("makeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("makeTime").trim();
			modifyDate = rs.getDate("modifyDate");
			if (rs.getString("modifyTime") == null)
				modifyTime = null;
			else
				modifyTime = rs.getString("modifyTime").trim();
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPolBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPPolBSchema getSchema()
	{
		LNPPolBSchema aLNPPolBSchema = new LNPPolBSchema();
		aLNPPolBSchema.setSchema(this);
		return aLNPPolBSchema;
	}

	public LNPPolBDB getDB()
	{
		LNPPolBDB aDBOper = new LNPPolBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpPolNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proposalContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(polNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proposalNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(prtNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(polTypeFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(mainPolNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(masterPolNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(kindCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(riskCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(riskVersion))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(manageCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentGroup))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentGroup1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentCode1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(saleChnl))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(handler))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredSex))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(insuredBirthday)))).append("|").append(ChgData.chgData(insuredAppAge)).append("|").append(ChgData.chgData(insuredPeoples)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(occupationType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(cValiDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(signCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(signDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(signTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(firstPayDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(payEndDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(paytoDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(getStartDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(endDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(acciEndDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(getYearFlag))).append("|").append(ChgData.chgData(getYear)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(payEndYearFlag))).append("|").append(ChgData.chgData(payEndYear)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuYearFlag))).append("|").append(ChgData.chgData(insuYear)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(acciYearFlag))).append("|").append(ChgData.chgData(acciYear)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(getStartType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(specifyValiDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(payMode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(payLocation))).append("|").append(ChgData.chgData(payIntv)).append("|").append(ChgData.chgData(payYears)).append("|").append(ChgData.chgData(years)).append("|").append(ChgData.chgData(manageFeeRate)).append("|").append(ChgData.chgData(floatRate)).append("|").append(ChgData.chgData(premRate)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(premToAmnt))).append("|").append(ChgData.chgData(mult)).append("|").append(ChgData.chgData(standPrem)).append("|").append(ChgData.chgData(prem)).append("|").append(ChgData.chgData(sumPrem)).append("|").append(ChgData.chgData(amnt)).append("|").append(ChgData.chgData(riskAmnt)).append("|").append(ChgData.chgData(leavingMoney)).append("|").append(ChgData.chgData(endorseTimes)).append("|").append(ChgData.chgData(claimTimes)).append("|").append(ChgData.chgData(liveTimes)).append("|").append(ChgData.chgData(renewCount)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(lastGetDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(lastLoanDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(lastRegetDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(lastEdorDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(lastRevDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(rnewFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(stopFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(expiryFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(autoPayFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(interestDifFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(subFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bnfFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(healthCheckFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(impartFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(reinsureFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentPayFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentGetFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(liveGetMode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(deadGetMode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bonusGetMode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(deadAmntType))).append("|").append(ChgData.chgData(topUpPrem)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bonusMan))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(deadFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(smokeFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(remark))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(approveFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(approveCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(approveDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(approveTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(uWDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(polApplyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(saleChnlDetail))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(polState))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(standbyFlag1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(standbyFlag2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(standbyFlag3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			grpPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			proposalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			contType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			polTypeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			mainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			masterPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			kindCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			riskVersion = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			agentCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			agentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			agentGroup1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			agentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			handler = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			insuredSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			insuredBirthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
			insuredAppAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|")))).intValue();
			insuredPeoples = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|")))).intValue();
			occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			cValiDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
			signCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			signDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|"));
			signTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			firstPayDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|"));
			payEndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|"));
			paytoDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|"));
			getStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|"));
			acciEndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|"));
			getYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			getYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 47, "|")))).intValue();
			payEndYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			payEndYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|")))).intValue();
			insuYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			insuYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|")))).intValue();
			acciYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			acciYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 53, "|")))).intValue();
			getStartType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
			specifyValiDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
			payMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
			payLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|");
			payIntv = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|")))).intValue();
			payYears = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|")))).intValue();
			years = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|")))).intValue();
			manageFeeRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|")))).doubleValue();
			floatRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|")))).doubleValue();
			premRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|")))).doubleValue();
			premToAmnt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, "|");
			mult = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 65, "|")))).doubleValue();
			standPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 66, "|")))).doubleValue();
			prem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 67, "|")))).doubleValue();
			sumPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 68, "|")))).doubleValue();
			amnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 69, "|")))).doubleValue();
			riskAmnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 70, "|")))).doubleValue();
			leavingMoney = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 71, "|")))).doubleValue();
			endorseTimes = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 72, "|")))).intValue();
			claimTimes = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 73, "|")))).intValue();
			liveTimes = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 74, "|")))).intValue();
			renewCount = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 75, "|")))).intValue();
			lastGetDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76, "|"));
			lastLoanDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, "|"));
			lastRegetDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, "|"));
			lastEdorDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, "|"));
			lastRevDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, "|"));
			rnewFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, "|");
			stopFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82, "|");
			expiryFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, "|");
			autoPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, "|");
			interestDifFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, "|");
			subFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, "|");
			bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, "|");
			healthCheckFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, "|");
			impartFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, "|");
			reinsureFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, "|");
			agentPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, "|");
			agentGetFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 92, "|");
			liveGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 93, "|");
			deadGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 94, "|");
			bonusGetMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 95, "|");
			deadAmntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 96, "|");
			topUpPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 97, "|")))).doubleValue();
			bonusMan = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 98, "|");
			deadFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 99, "|");
			smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 100, "|");
			remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 101, "|");
			approveFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 102, "|");
			approveCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 103, "|");
			approveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 104, "|"));
			approveTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 105, "|");
			uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 106, "|");
			uWCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 107, "|");
			uWDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 108, "|"));
			uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 109, "|");
			polApplyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 110, "|"));
			appFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 111, "|");
			saleChnlDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 112, "|");
			polState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 113, "|");
			standbyFlag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 114, "|");
			standbyFlag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 115, "|");
			standbyFlag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 116, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 117, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 118, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 119, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 120, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 121, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPolBSchema";
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
		if (FCode.equals("EdorNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(EdorNo));
		if (FCode.equals("serialNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(serialNo));
		if (FCode.equals("grpContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpContNo));
		if (FCode.equals("grpPolNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpPolNo));
		if (FCode.equals("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equals("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equals("polNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polNo));
		if (FCode.equals("proposalNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalNo));
		if (FCode.equals("prtNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prtNo));
		if (FCode.equals("contType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contType));
		if (FCode.equals("polTypeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polTypeFlag));
		if (FCode.equals("mainPolNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mainPolNo));
		if (FCode.equals("masterPolNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(masterPolNo));
		if (FCode.equals("kindCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(kindCode));
		if (FCode.equals("riskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCode));
		if (FCode.equals("riskVersion"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskVersion));
		if (FCode.equals("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equals("agentCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCom));
		if (FCode.equals("agentType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentType));
		if (FCode.equals("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equals("agentGroup"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup));
		if (FCode.equals("agentGroup1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup1));
		if (FCode.equals("agentCode1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode1));
		if (FCode.equals("saleChnl"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnl));
		if (FCode.equals("handler"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(handler));
		if (FCode.equals("insuredNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredNo));
		if (FCode.equals("insuredId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredId));
		if (FCode.equals("insuredName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredName));
		if (FCode.equals("insuredSex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredSex));
		if (FCode.equals("insuredBirthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getinsuredBirthday()));
		if (FCode.equals("insuredAppAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredAppAge));
		if (FCode.equals("insuredPeoples"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredPeoples));
		if (FCode.equals("occupationType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationType));
		if (FCode.equals("appntNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntNo));
		if (FCode.equals("appntName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntName));
		if (FCode.equals("cValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getcValiDate()));
		if (FCode.equals("signCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signCom));
		if (FCode.equals("signDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getsignDate()));
		if (FCode.equals("signTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signTime));
		if (FCode.equals("firstPayDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getfirstPayDate()));
		if (FCode.equals("payEndDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getpayEndDate()));
		if (FCode.equals("paytoDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getpaytoDate()));
		if (FCode.equals("getStartDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getgetStartDate()));
		if (FCode.equals("endDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getendDate()));
		if (FCode.equals("acciEndDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getacciEndDate()));
		if (FCode.equals("getYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getYearFlag));
		if (FCode.equals("getYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getYear));
		if (FCode.equals("payEndYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndYearFlag));
		if (FCode.equals("payEndYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndYear));
		if (FCode.equals("insuYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuYearFlag));
		if (FCode.equals("insuYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuYear));
		if (FCode.equals("acciYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(acciYearFlag));
		if (FCode.equals("acciYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(acciYear));
		if (FCode.equals("getStartType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartType));
		if (FCode.equals("specifyValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(specifyValiDate));
		if (FCode.equals("payMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payMode));
		if (FCode.equals("payLocation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payLocation));
		if (FCode.equals("payIntv"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payIntv));
		if (FCode.equals("payYears"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payYears));
		if (FCode.equals("years"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(years));
		if (FCode.equals("manageFeeRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageFeeRate));
		if (FCode.equals("floatRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(floatRate));
		if (FCode.equals("premRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(premRate));
		if (FCode.equals("premToAmnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(premToAmnt));
		if (FCode.equals("mult"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mult));
		if (FCode.equals("standPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(standPrem));
		if (FCode.equals("prem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prem));
		if (FCode.equals("sumPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sumPrem));
		if (FCode.equals("amnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(amnt));
		if (FCode.equals("riskAmnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskAmnt));
		if (FCode.equals("leavingMoney"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(leavingMoney));
		if (FCode.equals("endorseTimes"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(endorseTimes));
		if (FCode.equals("claimTimes"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(claimTimes));
		if (FCode.equals("liveTimes"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(liveTimes));
		if (FCode.equals("renewCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(renewCount));
		if (FCode.equals("lastGetDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getlastGetDate()));
		if (FCode.equals("lastLoanDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getlastLoanDate()));
		if (FCode.equals("lastRegetDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getlastRegetDate()));
		if (FCode.equals("lastEdorDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getlastEdorDate()));
		if (FCode.equals("lastRevDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getlastRevDate()));
		if (FCode.equals("rnewFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rnewFlag));
		if (FCode.equals("stopFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(stopFlag));
		if (FCode.equals("expiryFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(expiryFlag));
		if (FCode.equals("autoPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(autoPayFlag));
		if (FCode.equals("interestDifFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(interestDifFlag));
		if (FCode.equals("subFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(subFlag));
		if (FCode.equals("bnfFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfFlag));
		if (FCode.equals("healthCheckFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(healthCheckFlag));
		if (FCode.equals("impartFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartFlag));
		if (FCode.equals("reinsureFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(reinsureFlag));
		if (FCode.equals("agentPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentPayFlag));
		if (FCode.equals("agentGetFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGetFlag));
		if (FCode.equals("liveGetMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(liveGetMode));
		if (FCode.equals("deadGetMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(deadGetMode));
		if (FCode.equals("bonusGetMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusGetMode));
		if (FCode.equals("deadAmntType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(deadAmntType));
		if (FCode.equals("topUpPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(topUpPrem));
		if (FCode.equals("bonusMan"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusMan));
		if (FCode.equals("deadFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(deadFlag));
		if (FCode.equals("smokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(smokeFlag));
		if (FCode.equals("remark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark));
		if (FCode.equals("approveFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(approveFlag));
		if (FCode.equals("approveCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(approveCode));
		if (FCode.equals("approveDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getapproveDate()));
		if (FCode.equals("approveTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(approveTime));
		if (FCode.equals("uWFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWFlag));
		if (FCode.equals("uWCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWCode));
		if (FCode.equals("uWDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
		if (FCode.equals("uWTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWTime));
		if (FCode.equals("polApplyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getpolApplyDate()));
		if (FCode.equals("appFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appFlag));
		if (FCode.equals("saleChnlDetail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnlDetail));
		if (FCode.equals("polState"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polState));
		if (FCode.equals("standbyFlag1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(standbyFlag1));
		if (FCode.equals("standbyFlag2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(standbyFlag2));
		if (FCode.equals("standbyFlag3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(standbyFlag3));
		if (FCode.equals("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equals("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
		if (FCode.equals("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equals("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
		if (FCode.equals("modifyTime"))
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
			strFieldValue = StrTool.GBKToUnicode(EdorNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(serialNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(grpPolNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(polNo);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(proposalNo);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(prtNo);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(contType);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(polTypeFlag);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(mainPolNo);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(masterPolNo);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(kindCode);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(riskCode);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(riskVersion);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(agentCom);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(agentType);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(agentGroup);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(agentGroup1);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(agentCode1);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(saleChnl);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(handler);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(insuredNo);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(insuredId);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(insuredName);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(insuredSex);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getinsuredBirthday()));
			break;

		case 30: // '\036'
			strFieldValue = String.valueOf(insuredAppAge);
			break;

		case 31: // '\037'
			strFieldValue = String.valueOf(insuredPeoples);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(occupationType);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(appntNo);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(appntName);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getcValiDate()));
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(signCom);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getsignDate()));
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(signTime);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getfirstPayDate()));
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpayEndDate()));
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpaytoDate()));
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getgetStartDate()));
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getendDate()));
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getacciEndDate()));
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(getYearFlag);
			break;

		case 46: // '.'
			strFieldValue = String.valueOf(getYear);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(payEndYearFlag);
			break;

		case 48: // '0'
			strFieldValue = String.valueOf(payEndYear);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(insuYearFlag);
			break;

		case 50: // '2'
			strFieldValue = String.valueOf(insuYear);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(acciYearFlag);
			break;

		case 52: // '4'
			strFieldValue = String.valueOf(acciYear);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(getStartType);
			break;

		case 54: // '6'
			strFieldValue = StrTool.GBKToUnicode(specifyValiDate);
			break;

		case 55: // '7'
			strFieldValue = StrTool.GBKToUnicode(payMode);
			break;

		case 56: // '8'
			strFieldValue = StrTool.GBKToUnicode(payLocation);
			break;

		case 57: // '9'
			strFieldValue = String.valueOf(payIntv);
			break;

		case 58: // ':'
			strFieldValue = String.valueOf(payYears);
			break;

		case 59: // ';'
			strFieldValue = String.valueOf(years);
			break;

		case 60: // '<'
			strFieldValue = String.valueOf(manageFeeRate);
			break;

		case 61: // '='
			strFieldValue = String.valueOf(floatRate);
			break;

		case 62: // '>'
			strFieldValue = String.valueOf(premRate);
			break;

		case 63: // '?'
			strFieldValue = StrTool.GBKToUnicode(premToAmnt);
			break;

		case 64: // '@'
			strFieldValue = String.valueOf(mult);
			break;

		case 65: // 'A'
			strFieldValue = String.valueOf(standPrem);
			break;

		case 66: // 'B'
			strFieldValue = String.valueOf(prem);
			break;

		case 67: // 'C'
			strFieldValue = String.valueOf(sumPrem);
			break;

		case 68: // 'D'
			strFieldValue = String.valueOf(amnt);
			break;

		case 69: // 'E'
			strFieldValue = String.valueOf(riskAmnt);
			break;

		case 70: // 'F'
			strFieldValue = String.valueOf(leavingMoney);
			break;

		case 71: // 'G'
			strFieldValue = String.valueOf(endorseTimes);
			break;

		case 72: // 'H'
			strFieldValue = String.valueOf(claimTimes);
			break;

		case 73: // 'I'
			strFieldValue = String.valueOf(liveTimes);
			break;

		case 74: // 'J'
			strFieldValue = String.valueOf(renewCount);
			break;

		case 75: // 'K'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastGetDate()));
			break;

		case 76: // 'L'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastLoanDate()));
			break;

		case 77: // 'M'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastRegetDate()));
			break;

		case 78: // 'N'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastEdorDate()));
			break;

		case 79: // 'O'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getlastRevDate()));
			break;

		case 80: // 'P'
			strFieldValue = StrTool.GBKToUnicode(rnewFlag);
			break;

		case 81: // 'Q'
			strFieldValue = StrTool.GBKToUnicode(stopFlag);
			break;

		case 82: // 'R'
			strFieldValue = StrTool.GBKToUnicode(expiryFlag);
			break;

		case 83: // 'S'
			strFieldValue = StrTool.GBKToUnicode(autoPayFlag);
			break;

		case 84: // 'T'
			strFieldValue = StrTool.GBKToUnicode(interestDifFlag);
			break;

		case 85: // 'U'
			strFieldValue = StrTool.GBKToUnicode(subFlag);
			break;

		case 86: // 'V'
			strFieldValue = StrTool.GBKToUnicode(bnfFlag);
			break;

		case 87: // 'W'
			strFieldValue = StrTool.GBKToUnicode(healthCheckFlag);
			break;

		case 88: // 'X'
			strFieldValue = StrTool.GBKToUnicode(impartFlag);
			break;

		case 89: // 'Y'
			strFieldValue = StrTool.GBKToUnicode(reinsureFlag);
			break;

		case 90: // 'Z'
			strFieldValue = StrTool.GBKToUnicode(agentPayFlag);
			break;

		case 91: // '['
			strFieldValue = StrTool.GBKToUnicode(agentGetFlag);
			break;

		case 92: // '\\'
			strFieldValue = StrTool.GBKToUnicode(liveGetMode);
			break;

		case 93: // ']'
			strFieldValue = StrTool.GBKToUnicode(deadGetMode);
			break;

		case 94: // '^'
			strFieldValue = StrTool.GBKToUnicode(bonusGetMode);
			break;

		case 95: // '_'
			strFieldValue = StrTool.GBKToUnicode(deadAmntType);
			break;

		case 96: // '`'
			strFieldValue = String.valueOf(topUpPrem);
			break;

		case 97: // 'a'
			strFieldValue = StrTool.GBKToUnicode(bonusMan);
			break;

		case 98: // 'b'
			strFieldValue = StrTool.GBKToUnicode(deadFlag);
			break;

		case 99: // 'c'
			strFieldValue = StrTool.GBKToUnicode(smokeFlag);
			break;

		case 100: // 'd'
			strFieldValue = StrTool.GBKToUnicode(remark);
			break;

		case 101: // 'e'
			strFieldValue = StrTool.GBKToUnicode(approveFlag);
			break;

		case 102: // 'f'
			strFieldValue = StrTool.GBKToUnicode(approveCode);
			break;

		case 103: // 'g'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getapproveDate()));
			break;

		case 104: // 'h'
			strFieldValue = StrTool.GBKToUnicode(approveTime);
			break;

		case 105: // 'i'
			strFieldValue = StrTool.GBKToUnicode(uWFlag);
			break;

		case 106: // 'j'
			strFieldValue = StrTool.GBKToUnicode(uWCode);
			break;

		case 107: // 'k'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
			break;

		case 108: // 'l'
			strFieldValue = StrTool.GBKToUnicode(uWTime);
			break;

		case 109: // 'm'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpolApplyDate()));
			break;

		case 110: // 'n'
			strFieldValue = StrTool.GBKToUnicode(appFlag);
			break;

		case 111: // 'o'
			strFieldValue = StrTool.GBKToUnicode(saleChnlDetail);
			break;

		case 112: // 'p'
			strFieldValue = StrTool.GBKToUnicode(polState);
			break;

		case 113: // 'q'
			strFieldValue = StrTool.GBKToUnicode(standbyFlag1);
			break;

		case 114: // 'r'
			strFieldValue = StrTool.GBKToUnicode(standbyFlag2);
			break;

		case 115: // 's'
			strFieldValue = StrTool.GBKToUnicode(standbyFlag3);
			break;

		case 116: // 't'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 117: // 'u'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 118: // 'v'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 119: // 'w'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
			break;

		case 120: // 'x'
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
		if (FCode.equals("EdorNo"))
			if (FValue != null && !FValue.equals(""))
				EdorNo = FValue.trim();
			else
				EdorNo = null;
		if (FCode.equals("serialNo"))
			if (FValue != null && !FValue.equals(""))
				serialNo = FValue.trim();
			else
				serialNo = null;
		if (FCode.equals("grpContNo"))
			if (FValue != null && !FValue.equals(""))
				grpContNo = FValue.trim();
			else
				grpContNo = null;
		if (FCode.equals("grpPolNo"))
			if (FValue != null && !FValue.equals(""))
				grpPolNo = FValue.trim();
			else
				grpPolNo = null;
		if (FCode.equals("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equals("proposalContNo"))
			if (FValue != null && !FValue.equals(""))
				proposalContNo = FValue.trim();
			else
				proposalContNo = null;
		if (FCode.equals("polNo"))
			if (FValue != null && !FValue.equals(""))
				polNo = FValue.trim();
			else
				polNo = null;
		if (FCode.equals("proposalNo"))
			if (FValue != null && !FValue.equals(""))
				proposalNo = FValue.trim();
			else
				proposalNo = null;
		if (FCode.equals("prtNo"))
			if (FValue != null && !FValue.equals(""))
				prtNo = FValue.trim();
			else
				prtNo = null;
		if (FCode.equals("contType"))
			if (FValue != null && !FValue.equals(""))
				contType = FValue.trim();
			else
				contType = null;
		if (FCode.equals("polTypeFlag"))
			if (FValue != null && !FValue.equals(""))
				polTypeFlag = FValue.trim();
			else
				polTypeFlag = null;
		if (FCode.equals("mainPolNo"))
			if (FValue != null && !FValue.equals(""))
				mainPolNo = FValue.trim();
			else
				mainPolNo = null;
		if (FCode.equals("masterPolNo"))
			if (FValue != null && !FValue.equals(""))
				masterPolNo = FValue.trim();
			else
				masterPolNo = null;
		if (FCode.equals("kindCode"))
			if (FValue != null && !FValue.equals(""))
				kindCode = FValue.trim();
			else
				kindCode = null;
		if (FCode.equals("riskCode"))
			if (FValue != null && !FValue.equals(""))
				riskCode = FValue.trim();
			else
				riskCode = null;
		if (FCode.equals("riskVersion"))
			if (FValue != null && !FValue.equals(""))
				riskVersion = FValue.trim();
			else
				riskVersion = null;
		if (FCode.equals("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equals("agentCom"))
			if (FValue != null && !FValue.equals(""))
				agentCom = FValue.trim();
			else
				agentCom = null;
		if (FCode.equals("agentType"))
			if (FValue != null && !FValue.equals(""))
				agentType = FValue.trim();
			else
				agentType = null;
		if (FCode.equals("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equals("agentGroup"))
			if (FValue != null && !FValue.equals(""))
				agentGroup = FValue.trim();
			else
				agentGroup = null;
		if (FCode.equals("agentGroup1"))
			if (FValue != null && !FValue.equals(""))
				agentGroup1 = FValue.trim();
			else
				agentGroup1 = null;
		if (FCode.equals("agentCode1"))
			if (FValue != null && !FValue.equals(""))
				agentCode1 = FValue.trim();
			else
				agentCode1 = null;
		if (FCode.equals("saleChnl"))
			if (FValue != null && !FValue.equals(""))
				saleChnl = FValue.trim();
			else
				saleChnl = null;
		if (FCode.equals("handler"))
			if (FValue != null && !FValue.equals(""))
				handler = FValue.trim();
			else
				handler = null;
		if (FCode.equals("insuredNo"))
			if (FValue != null && !FValue.equals(""))
				insuredNo = FValue.trim();
			else
				insuredNo = null;
		if (FCode.equals("insuredId"))
			if (FValue != null && !FValue.equals(""))
				insuredId = FValue.trim();
			else
				insuredId = null;
		if (FCode.equals("insuredName"))
			if (FValue != null && !FValue.equals(""))
				insuredName = FValue.trim();
			else
				insuredName = null;
		if (FCode.equals("insuredSex"))
			if (FValue != null && !FValue.equals(""))
				insuredSex = FValue.trim();
			else
				insuredSex = null;
		if (FCode.equals("insuredBirthday"))
			if (FValue != null && !FValue.equals(""))
				insuredBirthday = fDate.getDate(FValue);
			else
				insuredBirthday = null;
		if (FCode.equals("insuredAppAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			insuredAppAge = i;
		}
		if (FCode.equals("insuredPeoples") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			insuredPeoples = i;
		}
		if (FCode.equals("occupationType"))
			if (FValue != null && !FValue.equals(""))
				occupationType = FValue.trim();
			else
				occupationType = null;
		if (FCode.equals("appntNo"))
			if (FValue != null && !FValue.equals(""))
				appntNo = FValue.trim();
			else
				appntNo = null;
		if (FCode.equals("appntName"))
			if (FValue != null && !FValue.equals(""))
				appntName = FValue.trim();
			else
				appntName = null;
		if (FCode.equals("cValiDate"))
			if (FValue != null && !FValue.equals(""))
				cValiDate = fDate.getDate(FValue);
			else
				cValiDate = null;
		if (FCode.equals("signCom"))
			if (FValue != null && !FValue.equals(""))
				signCom = FValue.trim();
			else
				signCom = null;
		if (FCode.equals("signDate"))
			if (FValue != null && !FValue.equals(""))
				signDate = fDate.getDate(FValue);
			else
				signDate = null;
		if (FCode.equals("signTime"))
			if (FValue != null && !FValue.equals(""))
				signTime = FValue.trim();
			else
				signTime = null;
		if (FCode.equals("firstPayDate"))
			if (FValue != null && !FValue.equals(""))
				firstPayDate = fDate.getDate(FValue);
			else
				firstPayDate = null;
		if (FCode.equals("payEndDate"))
			if (FValue != null && !FValue.equals(""))
				payEndDate = fDate.getDate(FValue);
			else
				payEndDate = null;
		if (FCode.equals("paytoDate"))
			if (FValue != null && !FValue.equals(""))
				paytoDate = fDate.getDate(FValue);
			else
				paytoDate = null;
		if (FCode.equals("getStartDate"))
			if (FValue != null && !FValue.equals(""))
				getStartDate = fDate.getDate(FValue);
			else
				getStartDate = null;
		if (FCode.equals("endDate"))
			if (FValue != null && !FValue.equals(""))
				endDate = fDate.getDate(FValue);
			else
				endDate = null;
		if (FCode.equals("acciEndDate"))
			if (FValue != null && !FValue.equals(""))
				acciEndDate = fDate.getDate(FValue);
			else
				acciEndDate = null;
		if (FCode.equals("getYearFlag"))
			if (FValue != null && !FValue.equals(""))
				getYearFlag = FValue.trim();
			else
				getYearFlag = null;
		if (FCode.equals("getYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			getYear = i;
		}
		if (FCode.equals("payEndYearFlag"))
			if (FValue != null && !FValue.equals(""))
				payEndYearFlag = FValue.trim();
			else
				payEndYearFlag = null;
		if (FCode.equals("payEndYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payEndYear = i;
		}
		if (FCode.equals("insuYearFlag"))
			if (FValue != null && !FValue.equals(""))
				insuYearFlag = FValue.trim();
			else
				insuYearFlag = null;
		if (FCode.equals("insuYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			insuYear = i;
		}
		if (FCode.equals("acciYearFlag"))
			if (FValue != null && !FValue.equals(""))
				acciYearFlag = FValue.trim();
			else
				acciYearFlag = null;
		if (FCode.equals("acciYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			acciYear = i;
		}
		if (FCode.equals("getStartType"))
			if (FValue != null && !FValue.equals(""))
				getStartType = FValue.trim();
			else
				getStartType = null;
		if (FCode.equals("specifyValiDate"))
			if (FValue != null && !FValue.equals(""))
				specifyValiDate = FValue.trim();
			else
				specifyValiDate = null;
		if (FCode.equals("payMode"))
			if (FValue != null && !FValue.equals(""))
				payMode = FValue.trim();
			else
				payMode = null;
		if (FCode.equals("payLocation"))
			if (FValue != null && !FValue.equals(""))
				payLocation = FValue.trim();
			else
				payLocation = null;
		if (FCode.equals("payIntv") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payIntv = i;
		}
		if (FCode.equals("payYears") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payYears = i;
		}
		if (FCode.equals("years") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			years = i;
		}
		if (FCode.equals("manageFeeRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			manageFeeRate = d;
		}
		if (FCode.equals("floatRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			floatRate = d;
		}
		if (FCode.equals("premRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			premRate = d;
		}
		if (FCode.equals("premToAmnt"))
			if (FValue != null && !FValue.equals(""))
				premToAmnt = FValue.trim();
			else
				premToAmnt = null;
		if (FCode.equals("mult") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mult = d;
		}
		if (FCode.equals("standPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			standPrem = d;
		}
		if (FCode.equals("prem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			prem = d;
		}
		if (FCode.equals("sumPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sumPrem = d;
		}
		if (FCode.equals("amnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			amnt = d;
		}
		if (FCode.equals("riskAmnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			riskAmnt = d;
		}
		if (FCode.equals("leavingMoney") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			leavingMoney = d;
		}
		if (FCode.equals("endorseTimes") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			endorseTimes = i;
		}
		if (FCode.equals("claimTimes") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			claimTimes = i;
		}
		if (FCode.equals("liveTimes") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			liveTimes = i;
		}
		if (FCode.equals("renewCount") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			renewCount = i;
		}
		if (FCode.equals("lastGetDate"))
			if (FValue != null && !FValue.equals(""))
				lastGetDate = fDate.getDate(FValue);
			else
				lastGetDate = null;
		if (FCode.equals("lastLoanDate"))
			if (FValue != null && !FValue.equals(""))
				lastLoanDate = fDate.getDate(FValue);
			else
				lastLoanDate = null;
		if (FCode.equals("lastRegetDate"))
			if (FValue != null && !FValue.equals(""))
				lastRegetDate = fDate.getDate(FValue);
			else
				lastRegetDate = null;
		if (FCode.equals("lastEdorDate"))
			if (FValue != null && !FValue.equals(""))
				lastEdorDate = fDate.getDate(FValue);
			else
				lastEdorDate = null;
		if (FCode.equals("lastRevDate"))
			if (FValue != null && !FValue.equals(""))
				lastRevDate = fDate.getDate(FValue);
			else
				lastRevDate = null;
		if (FCode.equals("rnewFlag"))
			if (FValue != null && !FValue.equals(""))
				rnewFlag = FValue.trim();
			else
				rnewFlag = null;
		if (FCode.equals("stopFlag"))
			if (FValue != null && !FValue.equals(""))
				stopFlag = FValue.trim();
			else
				stopFlag = null;
		if (FCode.equals("expiryFlag"))
			if (FValue != null && !FValue.equals(""))
				expiryFlag = FValue.trim();
			else
				expiryFlag = null;
		if (FCode.equals("autoPayFlag"))
			if (FValue != null && !FValue.equals(""))
				autoPayFlag = FValue.trim();
			else
				autoPayFlag = null;
		if (FCode.equals("interestDifFlag"))
			if (FValue != null && !FValue.equals(""))
				interestDifFlag = FValue.trim();
			else
				interestDifFlag = null;
		if (FCode.equals("subFlag"))
			if (FValue != null && !FValue.equals(""))
				subFlag = FValue.trim();
			else
				subFlag = null;
		if (FCode.equals("bnfFlag"))
			if (FValue != null && !FValue.equals(""))
				bnfFlag = FValue.trim();
			else
				bnfFlag = null;
		if (FCode.equals("healthCheckFlag"))
			if (FValue != null && !FValue.equals(""))
				healthCheckFlag = FValue.trim();
			else
				healthCheckFlag = null;
		if (FCode.equals("impartFlag"))
			if (FValue != null && !FValue.equals(""))
				impartFlag = FValue.trim();
			else
				impartFlag = null;
		if (FCode.equals("reinsureFlag"))
			if (FValue != null && !FValue.equals(""))
				reinsureFlag = FValue.trim();
			else
				reinsureFlag = null;
		if (FCode.equals("agentPayFlag"))
			if (FValue != null && !FValue.equals(""))
				agentPayFlag = FValue.trim();
			else
				agentPayFlag = null;
		if (FCode.equals("agentGetFlag"))
			if (FValue != null && !FValue.equals(""))
				agentGetFlag = FValue.trim();
			else
				agentGetFlag = null;
		if (FCode.equals("liveGetMode"))
			if (FValue != null && !FValue.equals(""))
				liveGetMode = FValue.trim();
			else
				liveGetMode = null;
		if (FCode.equals("deadGetMode"))
			if (FValue != null && !FValue.equals(""))
				deadGetMode = FValue.trim();
			else
				deadGetMode = null;
		if (FCode.equals("bonusGetMode"))
			if (FValue != null && !FValue.equals(""))
				bonusGetMode = FValue.trim();
			else
				bonusGetMode = null;
		if (FCode.equals("deadAmntType"))
			if (FValue != null && !FValue.equals(""))
				deadAmntType = FValue.trim();
			else
				deadAmntType = null;
		if (FCode.equals("topUpPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			topUpPrem = d;
		}
		if (FCode.equals("bonusMan"))
			if (FValue != null && !FValue.equals(""))
				bonusMan = FValue.trim();
			else
				bonusMan = null;
		if (FCode.equals("deadFlag"))
			if (FValue != null && !FValue.equals(""))
				deadFlag = FValue.trim();
			else
				deadFlag = null;
		if (FCode.equals("smokeFlag"))
			if (FValue != null && !FValue.equals(""))
				smokeFlag = FValue.trim();
			else
				smokeFlag = null;
		if (FCode.equals("remark"))
			if (FValue != null && !FValue.equals(""))
				remark = FValue.trim();
			else
				remark = null;
		if (FCode.equals("approveFlag"))
			if (FValue != null && !FValue.equals(""))
				approveFlag = FValue.trim();
			else
				approveFlag = null;
		if (FCode.equals("approveCode"))
			if (FValue != null && !FValue.equals(""))
				approveCode = FValue.trim();
			else
				approveCode = null;
		if (FCode.equals("approveDate"))
			if (FValue != null && !FValue.equals(""))
				approveDate = fDate.getDate(FValue);
			else
				approveDate = null;
		if (FCode.equals("approveTime"))
			if (FValue != null && !FValue.equals(""))
				approveTime = FValue.trim();
			else
				approveTime = null;
		if (FCode.equals("uWFlag"))
			if (FValue != null && !FValue.equals(""))
				uWFlag = FValue.trim();
			else
				uWFlag = null;
		if (FCode.equals("uWCode"))
			if (FValue != null && !FValue.equals(""))
				uWCode = FValue.trim();
			else
				uWCode = null;
		if (FCode.equals("uWDate"))
			if (FValue != null && !FValue.equals(""))
				uWDate = fDate.getDate(FValue);
			else
				uWDate = null;
		if (FCode.equals("uWTime"))
			if (FValue != null && !FValue.equals(""))
				uWTime = FValue.trim();
			else
				uWTime = null;
		if (FCode.equals("polApplyDate"))
			if (FValue != null && !FValue.equals(""))
				polApplyDate = fDate.getDate(FValue);
			else
				polApplyDate = null;
		if (FCode.equals("appFlag"))
			if (FValue != null && !FValue.equals(""))
				appFlag = FValue.trim();
			else
				appFlag = null;
		if (FCode.equals("saleChnlDetail"))
			if (FValue != null && !FValue.equals(""))
				saleChnlDetail = FValue.trim();
			else
				saleChnlDetail = null;
		if (FCode.equals("polState"))
			if (FValue != null && !FValue.equals(""))
				polState = FValue.trim();
			else
				polState = null;
		if (FCode.equals("standbyFlag1"))
			if (FValue != null && !FValue.equals(""))
				standbyFlag1 = FValue.trim();
			else
				standbyFlag1 = null;
		if (FCode.equals("standbyFlag2"))
			if (FValue != null && !FValue.equals(""))
				standbyFlag2 = FValue.trim();
			else
				standbyFlag2 = null;
		if (FCode.equals("standbyFlag3"))
			if (FValue != null && !FValue.equals(""))
				standbyFlag3 = FValue.trim();
			else
				standbyFlag3 = null;
		if (FCode.equals("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equals("makeDate"))
			if (FValue != null && !FValue.equals(""))
				makeDate = fDate.getDate(FValue);
			else
				makeDate = null;
		if (FCode.equals("makeTime"))
			if (FValue != null && !FValue.equals(""))
				makeTime = FValue.trim();
			else
				makeTime = null;
		if (FCode.equals("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equals("modifyTime"))
			if (FValue != null && !FValue.equals(""))
				modifyTime = FValue.trim();
			else
				modifyTime = null;
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		LNPPolBSchema other = (LNPPolBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && grpContNo.equals(other.getgrpContNo()) && grpPolNo.equals(other.getgrpPolNo()) && contNo.equals(other.getcontNo()) && proposalContNo.equals(other.getproposalContNo()) && polNo.equals(other.getpolNo()) && proposalNo.equals(other.getproposalNo()) && prtNo.equals(other.getprtNo()) && contType.equals(other.getcontType()) && polTypeFlag.equals(other.getpolTypeFlag()) && mainPolNo.equals(other.getmainPolNo()) && masterPolNo.equals(other.getmasterPolNo()) && kindCode.equals(other.getkindCode()) && riskCode.equals(other.getriskCode()) && riskVersion.equals(other.getriskVersion()) && manageCom.equals(other.getmanageCom()) && agentCom.equals(other.getagentCom()) && agentType.equals(other.getagentType()) && agentCode.equals(other.getagentCode()) && agentGroup.equals(other.getagentGroup()) && agentGroup1.equals(other.getagentGroup1()) && agentCode1.equals(other.getagentCode1()) && saleChnl.equals(other.getsaleChnl()) && handler.equals(other.gethandler()) && insuredNo.equals(other.getinsuredNo()) && insuredId.equals(other.getinsuredId()) && insuredName.equals(other.getinsuredName()) && insuredSex.equals(other.getinsuredSex()) && fDate.getString(insuredBirthday).equals(other.getinsuredBirthday()) && insuredAppAge == other.getinsuredAppAge() && insuredPeoples == other.getinsuredPeoples() && occupationType.equals(other.getoccupationType()) && appntNo.equals(other.getappntNo()) && appntName.equals(other.getappntName()) && fDate.getString(cValiDate).equals(other.getcValiDate()) && signCom.equals(other.getsignCom()) && fDate.getString(signDate).equals(other.getsignDate()) && signTime.equals(other.getsignTime()) && fDate.getString(firstPayDate).equals(other.getfirstPayDate()) && fDate.getString(payEndDate).equals(other.getpayEndDate()) && fDate.getString(paytoDate).equals(other.getpaytoDate()) && fDate.getString(getStartDate).equals(other.getgetStartDate()) && fDate.getString(endDate).equals(other.getendDate()) && fDate.getString(acciEndDate).equals(other.getacciEndDate()) && getYearFlag.equals(other.getgetYearFlag()) && getYear == other.getgetYear() && payEndYearFlag.equals(other.getpayEndYearFlag()) && payEndYear == other.getpayEndYear() && insuYearFlag.equals(other.getinsuYearFlag()) && insuYear == other.getinsuYear() && acciYearFlag.equals(other.getacciYearFlag()) && acciYear == other.getacciYear() && getStartType.equals(other.getgetStartType()) && specifyValiDate.equals(other.getspecifyValiDate()) && payMode.equals(other.getpayMode()) && payLocation.equals(other.getpayLocation()) && payIntv == other.getpayIntv() && payYears == other.getpayYears() && years == other.getyears() && manageFeeRate == other.getmanageFeeRate() && floatRate == other.getfloatRate() && premRate == other.getpremRate() && premToAmnt.equals(other.getpremToAmnt()) && mult == other.getmult() && standPrem == other.getstandPrem() && prem == other.getprem() && sumPrem == other.getsumPrem() && amnt == other.getamnt() && riskAmnt == other.getriskAmnt() && leavingMoney == other.getleavingMoney() && endorseTimes == other.getendorseTimes() && claimTimes == other.getclaimTimes() && liveTimes == other.getliveTimes() && renewCount == other.getrenewCount() && fDate.getString(lastGetDate).equals(other.getlastGetDate()) && fDate.getString(lastLoanDate).equals(other.getlastLoanDate()) && fDate.getString(lastRegetDate).equals(other.getlastRegetDate()) && fDate.getString(lastEdorDate).equals(other.getlastEdorDate()) && fDate.getString(lastRevDate).equals(other.getlastRevDate()) && rnewFlag.equals(other.getrnewFlag()) && stopFlag.equals(other.getstopFlag()) && expiryFlag.equals(other.getexpiryFlag()) && autoPayFlag.equals(other.getautoPayFlag()) && interestDifFlag.equals(other.getinterestDifFlag()) && subFlag.equals(other.getsubFlag()) && bnfFlag.equals(other.getbnfFlag()) && healthCheckFlag.equals(other.gethealthCheckFlag()) && impartFlag.equals(other.getimpartFlag()) && reinsureFlag.equals(other.getreinsureFlag()) && agentPayFlag.equals(other.getagentPayFlag()) && agentGetFlag.equals(other.getagentGetFlag()) && liveGetMode.equals(other.getliveGetMode()) && deadGetMode.equals(other.getdeadGetMode()) && bonusGetMode.equals(other.getbonusGetMode()) && deadAmntType.equals(other.getdeadAmntType()) && topUpPrem == other.gettopUpPrem() && bonusMan.equals(other.getbonusMan()) && deadFlag.equals(other.getdeadFlag()) && smokeFlag.equals(other.getsmokeFlag()) && remark.equals(other.getremark()) && approveFlag.equals(other.getapproveFlag()) && approveCode.equals(other.getapproveCode()) && fDate.getString(approveDate).equals(other.getapproveDate()) && approveTime.equals(other.getapproveTime()) && uWFlag.equals(other.getuWFlag()) && uWCode.equals(other.getuWCode()) && fDate.getString(uWDate).equals(other.getuWDate()) && uWTime.equals(other.getuWTime()) && fDate.getString(polApplyDate).equals(other.getpolApplyDate()) && appFlag.equals(other.getappFlag()) && saleChnlDetail.equals(other.getsaleChnlDetail()) && polState.equals(other.getpolState()) && standbyFlag1.equals(other.getstandbyFlag1()) && standbyFlag2.equals(other.getstandbyFlag2()) && standbyFlag3.equals(other.getstandbyFlag3()) && operator.equals(other.getoperator()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime());
	}

	public int getFieldCount()
	{
		return 121;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("grpContNo"))
			return 2;
		if (strFieldName.equals("grpPolNo"))
			return 3;
		if (strFieldName.equals("contNo"))
			return 4;
		if (strFieldName.equals("proposalContNo"))
			return 5;
		if (strFieldName.equals("polNo"))
			return 6;
		if (strFieldName.equals("proposalNo"))
			return 7;
		if (strFieldName.equals("prtNo"))
			return 8;
		if (strFieldName.equals("contType"))
			return 9;
		if (strFieldName.equals("polTypeFlag"))
			return 10;
		if (strFieldName.equals("mainPolNo"))
			return 11;
		if (strFieldName.equals("masterPolNo"))
			return 12;
		if (strFieldName.equals("kindCode"))
			return 13;
		if (strFieldName.equals("riskCode"))
			return 14;
		if (strFieldName.equals("riskVersion"))
			return 15;
		if (strFieldName.equals("manageCom"))
			return 16;
		if (strFieldName.equals("agentCom"))
			return 17;
		if (strFieldName.equals("agentType"))
			return 18;
		if (strFieldName.equals("agentCode"))
			return 19;
		if (strFieldName.equals("agentGroup"))
			return 20;
		if (strFieldName.equals("agentGroup1"))
			return 21;
		if (strFieldName.equals("agentCode1"))
			return 22;
		if (strFieldName.equals("saleChnl"))
			return 23;
		if (strFieldName.equals("handler"))
			return 24;
		if (strFieldName.equals("insuredNo"))
			return 25;
		if (strFieldName.equals("insuredId"))
			return 26;
		if (strFieldName.equals("insuredName"))
			return 27;
		if (strFieldName.equals("insuredSex"))
			return 28;
		if (strFieldName.equals("insuredBirthday"))
			return 29;
		if (strFieldName.equals("insuredAppAge"))
			return 30;
		if (strFieldName.equals("insuredPeoples"))
			return 31;
		if (strFieldName.equals("occupationType"))
			return 32;
		if (strFieldName.equals("appntNo"))
			return 33;
		if (strFieldName.equals("appntName"))
			return 34;
		if (strFieldName.equals("cValiDate"))
			return 35;
		if (strFieldName.equals("signCom"))
			return 36;
		if (strFieldName.equals("signDate"))
			return 37;
		if (strFieldName.equals("signTime"))
			return 38;
		if (strFieldName.equals("firstPayDate"))
			return 39;
		if (strFieldName.equals("payEndDate"))
			return 40;
		if (strFieldName.equals("paytoDate"))
			return 41;
		if (strFieldName.equals("getStartDate"))
			return 42;
		if (strFieldName.equals("endDate"))
			return 43;
		if (strFieldName.equals("acciEndDate"))
			return 44;
		if (strFieldName.equals("getYearFlag"))
			return 45;
		if (strFieldName.equals("getYear"))
			return 46;
		if (strFieldName.equals("payEndYearFlag"))
			return 47;
		if (strFieldName.equals("payEndYear"))
			return 48;
		if (strFieldName.equals("insuYearFlag"))
			return 49;
		if (strFieldName.equals("insuYear"))
			return 50;
		if (strFieldName.equals("acciYearFlag"))
			return 51;
		if (strFieldName.equals("acciYear"))
			return 52;
		if (strFieldName.equals("getStartType"))
			return 53;
		if (strFieldName.equals("specifyValiDate"))
			return 54;
		if (strFieldName.equals("payMode"))
			return 55;
		if (strFieldName.equals("payLocation"))
			return 56;
		if (strFieldName.equals("payIntv"))
			return 57;
		if (strFieldName.equals("payYears"))
			return 58;
		if (strFieldName.equals("years"))
			return 59;
		if (strFieldName.equals("manageFeeRate"))
			return 60;
		if (strFieldName.equals("floatRate"))
			return 61;
		if (strFieldName.equals("premRate"))
			return 62;
		if (strFieldName.equals("premToAmnt"))
			return 63;
		if (strFieldName.equals("mult"))
			return 64;
		if (strFieldName.equals("standPrem"))
			return 65;
		if (strFieldName.equals("prem"))
			return 66;
		if (strFieldName.equals("sumPrem"))
			return 67;
		if (strFieldName.equals("amnt"))
			return 68;
		if (strFieldName.equals("riskAmnt"))
			return 69;
		if (strFieldName.equals("leavingMoney"))
			return 70;
		if (strFieldName.equals("endorseTimes"))
			return 71;
		if (strFieldName.equals("claimTimes"))
			return 72;
		if (strFieldName.equals("liveTimes"))
			return 73;
		if (strFieldName.equals("renewCount"))
			return 74;
		if (strFieldName.equals("lastGetDate"))
			return 75;
		if (strFieldName.equals("lastLoanDate"))
			return 76;
		if (strFieldName.equals("lastRegetDate"))
			return 77;
		if (strFieldName.equals("lastEdorDate"))
			return 78;
		if (strFieldName.equals("lastRevDate"))
			return 79;
		if (strFieldName.equals("rnewFlag"))
			return 80;
		if (strFieldName.equals("stopFlag"))
			return 81;
		if (strFieldName.equals("expiryFlag"))
			return 82;
		if (strFieldName.equals("autoPayFlag"))
			return 83;
		if (strFieldName.equals("interestDifFlag"))
			return 84;
		if (strFieldName.equals("subFlag"))
			return 85;
		if (strFieldName.equals("bnfFlag"))
			return 86;
		if (strFieldName.equals("healthCheckFlag"))
			return 87;
		if (strFieldName.equals("impartFlag"))
			return 88;
		if (strFieldName.equals("reinsureFlag"))
			return 89;
		if (strFieldName.equals("agentPayFlag"))
			return 90;
		if (strFieldName.equals("agentGetFlag"))
			return 91;
		if (strFieldName.equals("liveGetMode"))
			return 92;
		if (strFieldName.equals("deadGetMode"))
			return 93;
		if (strFieldName.equals("bonusGetMode"))
			return 94;
		if (strFieldName.equals("deadAmntType"))
			return 95;
		if (strFieldName.equals("topUpPrem"))
			return 96;
		if (strFieldName.equals("bonusMan"))
			return 97;
		if (strFieldName.equals("deadFlag"))
			return 98;
		if (strFieldName.equals("smokeFlag"))
			return 99;
		if (strFieldName.equals("remark"))
			return 100;
		if (strFieldName.equals("approveFlag"))
			return 101;
		if (strFieldName.equals("approveCode"))
			return 102;
		if (strFieldName.equals("approveDate"))
			return 103;
		if (strFieldName.equals("approveTime"))
			return 104;
		if (strFieldName.equals("uWFlag"))
			return 105;
		if (strFieldName.equals("uWCode"))
			return 106;
		if (strFieldName.equals("uWDate"))
			return 107;
		if (strFieldName.equals("uWTime"))
			return 108;
		if (strFieldName.equals("polApplyDate"))
			return 109;
		if (strFieldName.equals("appFlag"))
			return 110;
		if (strFieldName.equals("saleChnlDetail"))
			return 111;
		if (strFieldName.equals("polState"))
			return 112;
		if (strFieldName.equals("standbyFlag1"))
			return 113;
		if (strFieldName.equals("standbyFlag2"))
			return 114;
		if (strFieldName.equals("standbyFlag3"))
			return 115;
		if (strFieldName.equals("operator"))
			return 116;
		if (strFieldName.equals("makeDate"))
			return 117;
		if (strFieldName.equals("makeTime"))
			return 118;
		if (strFieldName.equals("modifyDate"))
			return 119;
		return !strFieldName.equals("modifyTime") ? -1 : 120;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "EdorNo";
			break;

		case 1: // '\001'
			strFieldName = "serialNo";
			break;

		case 2: // '\002'
			strFieldName = "grpContNo";
			break;

		case 3: // '\003'
			strFieldName = "grpPolNo";
			break;

		case 4: // '\004'
			strFieldName = "contNo";
			break;

		case 5: // '\005'
			strFieldName = "proposalContNo";
			break;

		case 6: // '\006'
			strFieldName = "polNo";
			break;

		case 7: // '\007'
			strFieldName = "proposalNo";
			break;

		case 8: // '\b'
			strFieldName = "prtNo";
			break;

		case 9: // '\t'
			strFieldName = "contType";
			break;

		case 10: // '\n'
			strFieldName = "polTypeFlag";
			break;

		case 11: // '\013'
			strFieldName = "mainPolNo";
			break;

		case 12: // '\f'
			strFieldName = "masterPolNo";
			break;

		case 13: // '\r'
			strFieldName = "kindCode";
			break;

		case 14: // '\016'
			strFieldName = "riskCode";
			break;

		case 15: // '\017'
			strFieldName = "riskVersion";
			break;

		case 16: // '\020'
			strFieldName = "manageCom";
			break;

		case 17: // '\021'
			strFieldName = "agentCom";
			break;

		case 18: // '\022'
			strFieldName = "agentType";
			break;

		case 19: // '\023'
			strFieldName = "agentCode";
			break;

		case 20: // '\024'
			strFieldName = "agentGroup";
			break;

		case 21: // '\025'
			strFieldName = "agentGroup1";
			break;

		case 22: // '\026'
			strFieldName = "agentCode1";
			break;

		case 23: // '\027'
			strFieldName = "saleChnl";
			break;

		case 24: // '\030'
			strFieldName = "handler";
			break;

		case 25: // '\031'
			strFieldName = "insuredNo";
			break;

		case 26: // '\032'
			strFieldName = "insuredId";
			break;

		case 27: // '\033'
			strFieldName = "insuredName";
			break;

		case 28: // '\034'
			strFieldName = "insuredSex";
			break;

		case 29: // '\035'
			strFieldName = "insuredBirthday";
			break;

		case 30: // '\036'
			strFieldName = "insuredAppAge";
			break;

		case 31: // '\037'
			strFieldName = "insuredPeoples";
			break;

		case 32: // ' '
			strFieldName = "occupationType";
			break;

		case 33: // '!'
			strFieldName = "appntNo";
			break;

		case 34: // '"'
			strFieldName = "appntName";
			break;

		case 35: // '#'
			strFieldName = "cValiDate";
			break;

		case 36: // '$'
			strFieldName = "signCom";
			break;

		case 37: // '%'
			strFieldName = "signDate";
			break;

		case 38: // '&'
			strFieldName = "signTime";
			break;

		case 39: // '\''
			strFieldName = "firstPayDate";
			break;

		case 40: // '('
			strFieldName = "payEndDate";
			break;

		case 41: // ')'
			strFieldName = "paytoDate";
			break;

		case 42: // '*'
			strFieldName = "getStartDate";
			break;

		case 43: // '+'
			strFieldName = "endDate";
			break;

		case 44: // ','
			strFieldName = "acciEndDate";
			break;

		case 45: // '-'
			strFieldName = "getYearFlag";
			break;

		case 46: // '.'
			strFieldName = "getYear";
			break;

		case 47: // '/'
			strFieldName = "payEndYearFlag";
			break;

		case 48: // '0'
			strFieldName = "payEndYear";
			break;

		case 49: // '1'
			strFieldName = "insuYearFlag";
			break;

		case 50: // '2'
			strFieldName = "insuYear";
			break;

		case 51: // '3'
			strFieldName = "acciYearFlag";
			break;

		case 52: // '4'
			strFieldName = "acciYear";
			break;

		case 53: // '5'
			strFieldName = "getStartType";
			break;

		case 54: // '6'
			strFieldName = "specifyValiDate";
			break;

		case 55: // '7'
			strFieldName = "payMode";
			break;

		case 56: // '8'
			strFieldName = "payLocation";
			break;

		case 57: // '9'
			strFieldName = "payIntv";
			break;

		case 58: // ':'
			strFieldName = "payYears";
			break;

		case 59: // ';'
			strFieldName = "years";
			break;

		case 60: // '<'
			strFieldName = "manageFeeRate";
			break;

		case 61: // '='
			strFieldName = "floatRate";
			break;

		case 62: // '>'
			strFieldName = "premRate";
			break;

		case 63: // '?'
			strFieldName = "premToAmnt";
			break;

		case 64: // '@'
			strFieldName = "mult";
			break;

		case 65: // 'A'
			strFieldName = "standPrem";
			break;

		case 66: // 'B'
			strFieldName = "prem";
			break;

		case 67: // 'C'
			strFieldName = "sumPrem";
			break;

		case 68: // 'D'
			strFieldName = "amnt";
			break;

		case 69: // 'E'
			strFieldName = "riskAmnt";
			break;

		case 70: // 'F'
			strFieldName = "leavingMoney";
			break;

		case 71: // 'G'
			strFieldName = "endorseTimes";
			break;

		case 72: // 'H'
			strFieldName = "claimTimes";
			break;

		case 73: // 'I'
			strFieldName = "liveTimes";
			break;

		case 74: // 'J'
			strFieldName = "renewCount";
			break;

		case 75: // 'K'
			strFieldName = "lastGetDate";
			break;

		case 76: // 'L'
			strFieldName = "lastLoanDate";
			break;

		case 77: // 'M'
			strFieldName = "lastRegetDate";
			break;

		case 78: // 'N'
			strFieldName = "lastEdorDate";
			break;

		case 79: // 'O'
			strFieldName = "lastRevDate";
			break;

		case 80: // 'P'
			strFieldName = "rnewFlag";
			break;

		case 81: // 'Q'
			strFieldName = "stopFlag";
			break;

		case 82: // 'R'
			strFieldName = "expiryFlag";
			break;

		case 83: // 'S'
			strFieldName = "autoPayFlag";
			break;

		case 84: // 'T'
			strFieldName = "interestDifFlag";
			break;

		case 85: // 'U'
			strFieldName = "subFlag";
			break;

		case 86: // 'V'
			strFieldName = "bnfFlag";
			break;

		case 87: // 'W'
			strFieldName = "healthCheckFlag";
			break;

		case 88: // 'X'
			strFieldName = "impartFlag";
			break;

		case 89: // 'Y'
			strFieldName = "reinsureFlag";
			break;

		case 90: // 'Z'
			strFieldName = "agentPayFlag";
			break;

		case 91: // '['
			strFieldName = "agentGetFlag";
			break;

		case 92: // '\\'
			strFieldName = "liveGetMode";
			break;

		case 93: // ']'
			strFieldName = "deadGetMode";
			break;

		case 94: // '^'
			strFieldName = "bonusGetMode";
			break;

		case 95: // '_'
			strFieldName = "deadAmntType";
			break;

		case 96: // '`'
			strFieldName = "topUpPrem";
			break;

		case 97: // 'a'
			strFieldName = "bonusMan";
			break;

		case 98: // 'b'
			strFieldName = "deadFlag";
			break;

		case 99: // 'c'
			strFieldName = "smokeFlag";
			break;

		case 100: // 'd'
			strFieldName = "remark";
			break;

		case 101: // 'e'
			strFieldName = "approveFlag";
			break;

		case 102: // 'f'
			strFieldName = "approveCode";
			break;

		case 103: // 'g'
			strFieldName = "approveDate";
			break;

		case 104: // 'h'
			strFieldName = "approveTime";
			break;

		case 105: // 'i'
			strFieldName = "uWFlag";
			break;

		case 106: // 'j'
			strFieldName = "uWCode";
			break;

		case 107: // 'k'
			strFieldName = "uWDate";
			break;

		case 108: // 'l'
			strFieldName = "uWTime";
			break;

		case 109: // 'm'
			strFieldName = "polApplyDate";
			break;

		case 110: // 'n'
			strFieldName = "appFlag";
			break;

		case 111: // 'o'
			strFieldName = "saleChnlDetail";
			break;

		case 112: // 'p'
			strFieldName = "polState";
			break;

		case 113: // 'q'
			strFieldName = "standbyFlag1";
			break;

		case 114: // 'r'
			strFieldName = "standbyFlag2";
			break;

		case 115: // 's'
			strFieldName = "standbyFlag3";
			break;

		case 116: // 't'
			strFieldName = "operator";
			break;

		case 117: // 'u'
			strFieldName = "makeDate";
			break;

		case 118: // 'v'
			strFieldName = "makeTime";
			break;

		case 119: // 'w'
			strFieldName = "modifyDate";
			break;

		case 120: // 'x'
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
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 0;
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
			nFieldType = 0;
			break;

		case 28: // '\034'
			nFieldType = 0;
			break;

		case 29: // '\035'
			nFieldType = 1;
			break;

		case 30: // '\036'
			nFieldType = 3;
			break;

		case 31: // '\037'
			nFieldType = 3;
			break;

		case 32: // ' '
			nFieldType = 0;
			break;

		case 33: // '!'
			nFieldType = 0;
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
			nFieldType = 0;
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
			nFieldType = 1;
			break;

		case 44: // ','
			nFieldType = 1;
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
			nFieldType = 3;
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
			nFieldType = 3;
			break;

		case 58: // ':'
			nFieldType = 3;
			break;

		case 59: // ';'
			nFieldType = 3;
			break;

		case 60: // '<'
			nFieldType = 4;
			break;

		case 61: // '='
			nFieldType = 4;
			break;

		case 62: // '>'
			nFieldType = 4;
			break;

		case 63: // '?'
			nFieldType = 0;
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
			nFieldType = 4;
			break;

		case 70: // 'F'
			nFieldType = 4;
			break;

		case 71: // 'G'
			nFieldType = 3;
			break;

		case 72: // 'H'
			nFieldType = 3;
			break;

		case 73: // 'I'
			nFieldType = 3;
			break;

		case 74: // 'J'
			nFieldType = 3;
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
			nFieldType = 1;
			break;

		case 79: // 'O'
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 95: // '_'
			nFieldType = 0;
			break;

		case 96: // '`'
			nFieldType = 4;
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
			nFieldType = 0;
			break;

		case 102: // 'f'
			nFieldType = 0;
			break;

		case 103: // 'g'
			nFieldType = 1;
			break;

		case 104: // 'h'
			nFieldType = 0;
			break;

		case 105: // 'i'
			nFieldType = 0;
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
			nFieldType = 1;
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
			nFieldType = 0;
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

		case 119: // 'w'
			nFieldType = 1;
			break;

		case 120: // 'x'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
