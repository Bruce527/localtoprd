// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPContBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPContBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPContBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
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
	public static final int FIELDNUM = 93;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPContBSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[3];
		pk[0] = "EdorNo";
		pk[1] = "serialNo";
		pk[2] = "contNo";
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

	public String getfamilyType()
	{
		if (familyType != null)
			familyType.equals("");
		return familyType;
	}

	public void setfamilyType(String afamilyType)
	{
		familyType = afamilyType;
	}

	public String getfamilyID()
	{
		if (familyID != null)
			familyID.equals("");
		return familyID;
	}

	public void setfamilyID(String afamilyID)
	{
		familyID = afamilyID;
	}

	public String getpolType()
	{
		if (polType != null)
			polType.equals("");
		return polType;
	}

	public void setpolType(String apolType)
	{
		polType = apolType;
	}

	public String getsugNo()
	{
		if (sugNo != null)
			sugNo.equals("");
		return sugNo;
	}

	public void setsugNo(String asugNo)
	{
		sugNo = asugNo;
	}

	public String getcardFlag()
	{
		if (cardFlag != null)
			cardFlag.equals("");
		return cardFlag;
	}

	public void setcardFlag(String acardFlag)
	{
		cardFlag = acardFlag;
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

	public String getexecuteCom()
	{
		if (executeCom != null)
			executeCom.equals("");
		return executeCom;
	}

	public void setexecuteCom(String aexecuteCom)
	{
		executeCom = aexecuteCom;
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

	public String getpassword()
	{
		if (password != null)
			password.equals("");
		return password;
	}

	public void setpassword(String apassword)
	{
		password = apassword;
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

	public String getappntId()
	{
		if (appntId != null)
			appntId.equals("");
		return appntId;
	}

	public void setappntId(String aappntId)
	{
		appntId = aappntId;
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

	public String getappntSex()
	{
		if (appntSex != null)
			appntSex.equals("");
		return appntSex;
	}

	public void setappntSex(String aappntSex)
	{
		appntSex = aappntSex;
	}

	public String getappntBirthday()
	{
		if (appntBirthday != null)
			return fDate.getString(appntBirthday);
		else
			return null;
	}

	public void setappntBirthday(Date aappntBirthday)
	{
		appntBirthday = aappntBirthday;
	}

	public void setappntBirthday(String aappntBirthday)
	{
		if (aappntBirthday != null && !aappntBirthday.equals(""))
			appntBirthday = fDate.getDate(aappntBirthday);
		else
			appntBirthday = null;
	}

	public String getappntIDType()
	{
		if (appntIDType != null)
			appntIDType.equals("");
		return appntIDType;
	}

	public void setappntIDType(String aappntIDType)
	{
		appntIDType = aappntIDType;
	}

	public String getappntIDNo()
	{
		if (appntIDNo != null)
			appntIDNo.equals("");
		return appntIDNo;
	}

	public void setappntIDNo(String aappntIDNo)
	{
		appntIDNo = aappntIDNo;
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

	public String getinsuredIDType()
	{
		if (insuredIDType != null)
			insuredIDType.equals("");
		return insuredIDType;
	}

	public void setinsuredIDType(String ainsuredIDType)
	{
		insuredIDType = ainsuredIDType;
	}

	public String getinsuredIDNo()
	{
		if (insuredIDNo != null)
			insuredIDNo.equals("");
		return insuredIDNo;
	}

	public void setinsuredIDNo(String ainsuredIDNo)
	{
		insuredIDNo = ainsuredIDNo;
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

	public String getdisputedFlag()
	{
		if (disputedFlag != null)
			disputedFlag.equals("");
		return disputedFlag;
	}

	public void setdisputedFlag(String adisputedFlag)
	{
		disputedFlag = adisputedFlag;
	}

	public String getoutPayFlag()
	{
		if (outPayFlag != null)
			outPayFlag.equals("");
		return outPayFlag;
	}

	public void setoutPayFlag(String aoutPayFlag)
	{
		outPayFlag = aoutPayFlag;
	}

	public String getgetPolMode()
	{
		if (getPolMode != null)
			getPolMode.equals("");
		return getPolMode;
	}

	public void setgetPolMode(String agetPolMode)
	{
		getPolMode = agetPolMode;
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

	public String getconsignNo()
	{
		if (consignNo != null)
			consignNo.equals("");
		return consignNo;
	}

	public void setconsignNo(String aconsignNo)
	{
		consignNo = aconsignNo;
	}

	public String getbankCode()
	{
		if (bankCode != null)
			bankCode.equals("");
		return bankCode;
	}

	public void setbankCode(String abankCode)
	{
		bankCode = abankCode;
	}

	public String getbankAccNo()
	{
		if (bankAccNo != null)
			bankAccNo.equals("");
		return bankAccNo;
	}

	public void setbankAccNo(String abankAccNo)
	{
		bankAccNo = abankAccNo;
	}

	public String getaccName()
	{
		if (accName != null)
			accName.equals("");
		return accName;
	}

	public void setaccName(String aaccName)
	{
		accName = aaccName;
	}

	public int getprintCount()
	{
		return printCount;
	}

	public void setprintCount(int aprintCount)
	{
		printCount = aprintCount;
	}

	public void setprintCount(String aprintCount)
	{
		if (aprintCount != null && !aprintCount.equals(""))
		{
			Integer tInteger = new Integer(aprintCount);
			int i = tInteger.intValue();
			printCount = i;
		}
	}

	public int getlostTimes()
	{
		return lostTimes;
	}

	public void setlostTimes(int alostTimes)
	{
		lostTimes = alostTimes;
	}

	public void setlostTimes(String alostTimes)
	{
		if (alostTimes != null && !alostTimes.equals(""))
		{
			Integer tInteger = new Integer(alostTimes);
			int i = tInteger.intValue();
			lostTimes = i;
		}
	}

	public String getlang()
	{
		if (lang != null)
			lang.equals("");
		return lang;
	}

	public void setlang(String alang)
	{
		lang = alang;
	}

	public String getcurrency()
	{
		if (currency != null)
			currency.equals("");
		return currency;
	}

	public void setcurrency(String acurrency)
	{
		currency = acurrency;
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

	public int getpeoples()
	{
		return peoples;
	}

	public void setpeoples(int apeoples)
	{
		peoples = apeoples;
	}

	public void setpeoples(String apeoples)
	{
		if (apeoples != null && !apeoples.equals(""))
		{
			Integer tInteger = new Integer(apeoples);
			int i = tInteger.intValue();
			peoples = i;
		}
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

	public double getdif()
	{
		return dif;
	}

	public void setdif(double adif)
	{
		dif = adif;
	}

	public void setdif(String adif)
	{
		if (adif != null && !adif.equals(""))
		{
			Double tDouble = new Double(adif);
			double d = tDouble.doubleValue();
			dif = d;
		}
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

	public String getpSignDate()
	{
		if (pSignDate != null)
			return fDate.getString(pSignDate);
		else
			return null;
	}

	public void setpSignDate(Date apSignDate)
	{
		pSignDate = apSignDate;
	}

	public void setpSignDate(String apSignDate)
	{
		if (apSignDate != null && !apSignDate.equals(""))
			pSignDate = fDate.getDate(apSignDate);
		else
			pSignDate = null;
	}

	public String getpValiDate()
	{
		if (pValiDate != null)
			return fDate.getString(pValiDate);
		else
			return null;
	}

	public void setpValiDate(Date apValiDate)
	{
		pValiDate = apValiDate;
	}

	public void setpValiDate(String apValiDate)
	{
		if (apValiDate != null && !apValiDate.equals(""))
			pValiDate = fDate.getDate(apValiDate);
		else
			pValiDate = null;
	}

	public String getinputOperator()
	{
		if (inputOperator != null)
			inputOperator.equals("");
		return inputOperator;
	}

	public void setinputOperator(String ainputOperator)
	{
		inputOperator = ainputOperator;
	}

	public String getinputDate()
	{
		if (inputDate != null)
			return fDate.getString(inputDate);
		else
			return null;
	}

	public void setinputDate(Date ainputDate)
	{
		inputDate = ainputDate;
	}

	public void setinputDate(String ainputDate)
	{
		if (ainputDate != null && !ainputDate.equals(""))
			inputDate = fDate.getDate(ainputDate);
		else
			inputDate = null;
	}

	public String getinputTime()
	{
		if (inputTime != null)
			inputTime.equals("");
		return inputTime;
	}

	public void setinputTime(String ainputTime)
	{
		inputTime = ainputTime;
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

	public String getuWOperator()
	{
		if (uWOperator != null)
			uWOperator.equals("");
		return uWOperator;
	}

	public void setuWOperator(String auWOperator)
	{
		uWOperator = auWOperator;
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

	public String getgetPolDate()
	{
		if (getPolDate != null)
			return fDate.getString(getPolDate);
		else
			return null;
	}

	public void setgetPolDate(Date agetPolDate)
	{
		getPolDate = agetPolDate;
	}

	public void setgetPolDate(String agetPolDate)
	{
		if (agetPolDate != null && !agetPolDate.equals(""))
			getPolDate = fDate.getDate(agetPolDate);
		else
			getPolDate = null;
	}

	public String getgetPolTime()
	{
		if (getPolTime != null)
			getPolTime.equals("");
		return getPolTime;
	}

	public void setgetPolTime(String agetPolTime)
	{
		getPolTime = agetPolTime;
	}

	public String getcustomGetPolDate()
	{
		if (customGetPolDate != null)
			return fDate.getString(customGetPolDate);
		else
			return null;
	}

	public void setcustomGetPolDate(Date acustomGetPolDate)
	{
		customGetPolDate = acustomGetPolDate;
	}

	public void setcustomGetPolDate(String acustomGetPolDate)
	{
		if (acustomGetPolDate != null && !acustomGetPolDate.equals(""))
			customGetPolDate = fDate.getDate(acustomGetPolDate);
		else
			customGetPolDate = null;
	}

	public String getstate()
	{
		if (state != null)
			state.equals("");
		return state;
	}

	public void setstate(String astate)
	{
		state = astate;
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

	public String getproposalType()
	{
		if (proposalType != null)
			proposalType.equals("");
		return proposalType;
	}

	public void setproposalType(String aproposalType)
	{
		proposalType = aproposalType;
	}

	public String geteditstate()
	{
		if (editstate != null)
			editstate.equals("");
		return editstate;
	}

	public void seteditstate(String aeditstate)
	{
		editstate = aeditstate;
	}

	public String getcInValiDate()
	{
		if (cInValiDate != null)
			return fDate.getString(cInValiDate);
		else
			return null;
	}

	public void setcInValiDate(Date acInValiDate)
	{
		cInValiDate = acInValiDate;
	}

	public void setcInValiDate(String acInValiDate)
	{
		if (acInValiDate != null && !acInValiDate.equals(""))
			cInValiDate = fDate.getDate(acInValiDate);
		else
			cInValiDate = null;
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

	public void setSchema(LNPContBSchema aLNPContBSchema)
	{
		EdorNo = aLNPContBSchema.getEdorNo();
		serialNo = aLNPContBSchema.getserialNo();
		grpContNo = aLNPContBSchema.getgrpContNo();
		contNo = aLNPContBSchema.getcontNo();
		proposalContNo = aLNPContBSchema.getproposalContNo();
		prtNo = aLNPContBSchema.getprtNo();
		mainPolNo = aLNPContBSchema.getmainPolNo();
		contType = aLNPContBSchema.getcontType();
		familyType = aLNPContBSchema.getfamilyType();
		familyID = aLNPContBSchema.getfamilyID();
		polType = aLNPContBSchema.getpolType();
		sugNo = aLNPContBSchema.getsugNo();
		cardFlag = aLNPContBSchema.getcardFlag();
		manageCom = aLNPContBSchema.getmanageCom();
		executeCom = aLNPContBSchema.getexecuteCom();
		agentCom = aLNPContBSchema.getagentCom();
		agentCode = aLNPContBSchema.getagentCode();
		agentGroup = aLNPContBSchema.getagentGroup();
		agentCode1 = aLNPContBSchema.getagentCode1();
		agentGroup1 = aLNPContBSchema.getagentGroup1();
		agentType = aLNPContBSchema.getagentType();
		saleChnl = aLNPContBSchema.getsaleChnl();
		handler = aLNPContBSchema.gethandler();
		password = aLNPContBSchema.getpassword();
		appntNo = aLNPContBSchema.getappntNo();
		appntId = aLNPContBSchema.getappntId();
		appntName = aLNPContBSchema.getappntName();
		appntSex = aLNPContBSchema.getappntSex();
		appntBirthday = fDate.getDate(aLNPContBSchema.getappntBirthday());
		appntIDType = aLNPContBSchema.getappntIDType();
		appntIDNo = aLNPContBSchema.getappntIDNo();
		insuredNo = aLNPContBSchema.getinsuredNo();
		insuredId = aLNPContBSchema.getinsuredId();
		insuredName = aLNPContBSchema.getinsuredName();
		insuredSex = aLNPContBSchema.getinsuredSex();
		insuredBirthday = fDate.getDate(aLNPContBSchema.getinsuredBirthday());
		insuredIDType = aLNPContBSchema.getinsuredIDType();
		insuredIDNo = aLNPContBSchema.getinsuredIDNo();
		payIntv = aLNPContBSchema.getpayIntv();
		payMode = aLNPContBSchema.getpayMode();
		payLocation = aLNPContBSchema.getpayLocation();
		disputedFlag = aLNPContBSchema.getdisputedFlag();
		outPayFlag = aLNPContBSchema.getoutPayFlag();
		getPolMode = aLNPContBSchema.getgetPolMode();
		signCom = aLNPContBSchema.getsignCom();
		signDate = fDate.getDate(aLNPContBSchema.getsignDate());
		signTime = aLNPContBSchema.getsignTime();
		consignNo = aLNPContBSchema.getconsignNo();
		bankCode = aLNPContBSchema.getbankCode();
		bankAccNo = aLNPContBSchema.getbankAccNo();
		accName = aLNPContBSchema.getaccName();
		printCount = aLNPContBSchema.getprintCount();
		lostTimes = aLNPContBSchema.getlostTimes();
		lang = aLNPContBSchema.getlang();
		currency = aLNPContBSchema.getcurrency();
		remark = aLNPContBSchema.getremark();
		peoples = aLNPContBSchema.getpeoples();
		mult = aLNPContBSchema.getmult();
		prem = aLNPContBSchema.getprem();
		amnt = aLNPContBSchema.getamnt();
		sumPrem = aLNPContBSchema.getsumPrem();
		dif = aLNPContBSchema.getdif();
		paytoDate = fDate.getDate(aLNPContBSchema.getpaytoDate());
		firstPayDate = fDate.getDate(aLNPContBSchema.getfirstPayDate());
		cValiDate = fDate.getDate(aLNPContBSchema.getcValiDate());
		pSignDate = fDate.getDate(aLNPContBSchema.getpSignDate());
		pValiDate = fDate.getDate(aLNPContBSchema.getpValiDate());
		inputOperator = aLNPContBSchema.getinputOperator();
		inputDate = fDate.getDate(aLNPContBSchema.getinputDate());
		inputTime = aLNPContBSchema.getinputTime();
		approveFlag = aLNPContBSchema.getapproveFlag();
		approveCode = aLNPContBSchema.getapproveCode();
		approveDate = fDate.getDate(aLNPContBSchema.getapproveDate());
		approveTime = aLNPContBSchema.getapproveTime();
		uWFlag = aLNPContBSchema.getuWFlag();
		uWOperator = aLNPContBSchema.getuWOperator();
		uWDate = fDate.getDate(aLNPContBSchema.getuWDate());
		uWTime = aLNPContBSchema.getuWTime();
		appFlag = aLNPContBSchema.getappFlag();
		polApplyDate = fDate.getDate(aLNPContBSchema.getpolApplyDate());
		getPolDate = fDate.getDate(aLNPContBSchema.getgetPolDate());
		getPolTime = aLNPContBSchema.getgetPolTime();
		customGetPolDate = fDate.getDate(aLNPContBSchema.getcustomGetPolDate());
		state = aLNPContBSchema.getstate();
		saleChnlDetail = aLNPContBSchema.getsaleChnlDetail();
		proposalType = aLNPContBSchema.getproposalType();
		editstate = aLNPContBSchema.geteditstate();
		cInValiDate = fDate.getDate(aLNPContBSchema.getcInValiDate());
		operator = aLNPContBSchema.getoperator();
		makeDate = fDate.getDate(aLNPContBSchema.getmakeDate());
		makeTime = aLNPContBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPContBSchema.getmodifyDate());
		modifyTime = aLNPContBSchema.getmodifyTime();
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
			if (rs.getString("contNo") == null)
				contNo = null;
			else
				contNo = rs.getString("contNo").trim();
			if (rs.getString("proposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("proposalContNo").trim();
			if (rs.getString("prtNo") == null)
				prtNo = null;
			else
				prtNo = rs.getString("prtNo").trim();
			if (rs.getString("mainPolNo") == null)
				mainPolNo = null;
			else
				mainPolNo = rs.getString("mainPolNo").trim();
			if (rs.getString("contType") == null)
				contType = null;
			else
				contType = rs.getString("contType").trim();
			if (rs.getString("familyType") == null)
				familyType = null;
			else
				familyType = rs.getString("familyType").trim();
			if (rs.getString("familyID") == null)
				familyID = null;
			else
				familyID = rs.getString("familyID").trim();
			if (rs.getString("polType") == null)
				polType = null;
			else
				polType = rs.getString("polType").trim();
			if (rs.getString("sugNo") == null)
				sugNo = null;
			else
				sugNo = rs.getString("sugNo").trim();
			if (rs.getString("cardFlag") == null)
				cardFlag = null;
			else
				cardFlag = rs.getString("cardFlag").trim();
			if (rs.getString("manageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("manageCom").trim();
			if (rs.getString("executeCom") == null)
				executeCom = null;
			else
				executeCom = rs.getString("executeCom").trim();
			if (rs.getString("agentCom") == null)
				agentCom = null;
			else
				agentCom = rs.getString("agentCom").trim();
			if (rs.getString("agentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("agentCode").trim();
			if (rs.getString("agentGroup") == null)
				agentGroup = null;
			else
				agentGroup = rs.getString("agentGroup").trim();
			if (rs.getString("agentCode1") == null)
				agentCode1 = null;
			else
				agentCode1 = rs.getString("agentCode1").trim();
			if (rs.getString("agentGroup1") == null)
				agentGroup1 = null;
			else
				agentGroup1 = rs.getString("agentGroup1").trim();
			if (rs.getString("agentType") == null)
				agentType = null;
			else
				agentType = rs.getString("agentType").trim();
			if (rs.getString("saleChnl") == null)
				saleChnl = null;
			else
				saleChnl = rs.getString("saleChnl").trim();
			if (rs.getString("handler") == null)
				handler = null;
			else
				handler = rs.getString("handler").trim();
			if (rs.getString("password") == null)
				password = null;
			else
				password = rs.getString("password").trim();
			if (rs.getString("appntNo") == null)
				appntNo = null;
			else
				appntNo = rs.getString("appntNo").trim();
			if (rs.getString("appntId") == null)
				appntId = null;
			else
				appntId = rs.getString("appntId").trim();
			if (rs.getString("appntName") == null)
				appntName = null;
			else
				appntName = rs.getString("appntName").trim();
			if (rs.getString("appntSex") == null)
				appntSex = null;
			else
				appntSex = rs.getString("appntSex").trim();
			appntBirthday = rs.getDate("appntBirthday");
			if (rs.getString("appntIDType") == null)
				appntIDType = null;
			else
				appntIDType = rs.getString("appntIDType").trim();
			if (rs.getString("appntIDNo") == null)
				appntIDNo = null;
			else
				appntIDNo = rs.getString("appntIDNo").trim();
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
			if (rs.getString("insuredIDType") == null)
				insuredIDType = null;
			else
				insuredIDType = rs.getString("insuredIDType").trim();
			if (rs.getString("insuredIDNo") == null)
				insuredIDNo = null;
			else
				insuredIDNo = rs.getString("insuredIDNo").trim();
			payIntv = rs.getInt("payIntv");
			if (rs.getString("payMode") == null)
				payMode = null;
			else
				payMode = rs.getString("payMode").trim();
			if (rs.getString("payLocation") == null)
				payLocation = null;
			else
				payLocation = rs.getString("payLocation").trim();
			if (rs.getString("disputedFlag") == null)
				disputedFlag = null;
			else
				disputedFlag = rs.getString("disputedFlag").trim();
			if (rs.getString("outPayFlag") == null)
				outPayFlag = null;
			else
				outPayFlag = rs.getString("outPayFlag").trim();
			if (rs.getString("getPolMode") == null)
				getPolMode = null;
			else
				getPolMode = rs.getString("getPolMode").trim();
			if (rs.getString("signCom") == null)
				signCom = null;
			else
				signCom = rs.getString("signCom").trim();
			signDate = rs.getDate("signDate");
			if (rs.getString("signTime") == null)
				signTime = null;
			else
				signTime = rs.getString("signTime").trim();
			if (rs.getString("consignNo") == null)
				consignNo = null;
			else
				consignNo = rs.getString("consignNo").trim();
			if (rs.getString("bankCode") == null)
				bankCode = null;
			else
				bankCode = rs.getString("bankCode").trim();
			if (rs.getString("bankAccNo") == null)
				bankAccNo = null;
			else
				bankAccNo = rs.getString("bankAccNo").trim();
			if (rs.getString("accName") == null)
				accName = null;
			else
				accName = rs.getString("accName").trim();
			printCount = rs.getInt("printCount");
			lostTimes = rs.getInt("lostTimes");
			if (rs.getString("lang") == null)
				lang = null;
			else
				lang = rs.getString("lang").trim();
			if (rs.getString("currency") == null)
				currency = null;
			else
				currency = rs.getString("currency").trim();
			if (rs.getString("remark") == null)
				remark = null;
			else
				remark = rs.getString("remark").trim();
			peoples = rs.getInt("peoples");
			mult = rs.getDouble("mult");
			prem = rs.getDouble("prem");
			amnt = rs.getDouble("amnt");
			sumPrem = rs.getDouble("sumPrem");
			dif = rs.getDouble("dif");
			paytoDate = rs.getDate("paytoDate");
			firstPayDate = rs.getDate("firstPayDate");
			cValiDate = rs.getDate("cValiDate");
			pSignDate = rs.getDate("pSignDate");
			pValiDate = rs.getDate("pValiDate");
			if (rs.getString("inputOperator") == null)
				inputOperator = null;
			else
				inputOperator = rs.getString("inputOperator").trim();
			inputDate = rs.getDate("inputDate");
			if (rs.getString("inputTime") == null)
				inputTime = null;
			else
				inputTime = rs.getString("inputTime").trim();
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
			if (rs.getString("uWOperator") == null)
				uWOperator = null;
			else
				uWOperator = rs.getString("uWOperator").trim();
			uWDate = rs.getDate("uWDate");
			if (rs.getString("uWTime") == null)
				uWTime = null;
			else
				uWTime = rs.getString("uWTime").trim();
			if (rs.getString("appFlag") == null)
				appFlag = null;
			else
				appFlag = rs.getString("appFlag").trim();
			polApplyDate = rs.getDate("polApplyDate");
			getPolDate = rs.getDate("getPolDate");
			if (rs.getString("getPolTime") == null)
				getPolTime = null;
			else
				getPolTime = rs.getString("getPolTime").trim();
			customGetPolDate = rs.getDate("customGetPolDate");
			if (rs.getString("state") == null)
				state = null;
			else
				state = rs.getString("state").trim();
			if (rs.getString("saleChnlDetail") == null)
				saleChnlDetail = null;
			else
				saleChnlDetail = rs.getString("saleChnlDetail").trim();
			if (rs.getString("proposalType") == null)
				proposalType = null;
			else
				proposalType = rs.getString("proposalType").trim();
			if (rs.getString("editstate") == null)
				editstate = null;
			else
				editstate = rs.getString("editstate").trim();
			cInValiDate = rs.getDate("cInValiDate");
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
			tError.moduleName = "LNPContBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPContBSchema getSchema()
	{
		LNPContBSchema aLNPContBSchema = new LNPContBSchema();
		aLNPContBSchema.setSchema(this);
		return aLNPContBSchema;
	}

	public LNPContBDB getDB()
	{
		LNPContBDB aDBOper = new LNPContBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proposalContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(prtNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(mainPolNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(familyType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(familyID))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(polType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(sugNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(cardFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(manageCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(executeCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentGroup))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentCode1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentGroup1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(saleChnl))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(handler))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(password))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntSex))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(appntBirthday)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntIDType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntIDNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredSex))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(insuredBirthday)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredIDType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredIDNo))).append("|").append(ChgData.chgData(payIntv)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(payMode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(payLocation))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(disputedFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(outPayFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(getPolMode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(signCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(signDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(signTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(consignNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bankCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bankAccNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(accName))).append("|").append(ChgData.chgData(printCount)).append("|").append(ChgData.chgData(lostTimes)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(lang))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(currency))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(remark))).append("|").append(ChgData.chgData(peoples)).append("|").append(ChgData.chgData(mult)).append("|").append(ChgData.chgData(prem)).append("|").append(ChgData.chgData(amnt)).append("|").append(ChgData.chgData(sumPrem)).append("|").append(ChgData.chgData(dif)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(paytoDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(firstPayDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(cValiDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(pSignDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(pValiDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(inputOperator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(inputDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(inputTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(approveFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(approveCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(approveDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(approveTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWOperator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(uWDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(polApplyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(getPolDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(getPolTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(customGetPolDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(state))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(saleChnlDetail))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proposalType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(editstate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(cInValiDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			mainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			contType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			familyType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			familyID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			polType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			sugNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			cardFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			executeCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			agentCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			agentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			agentGroup1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			agentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			handler = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			appntSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			appntBirthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
			appntIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			appntIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			insuredSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			insuredBirthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
			insuredIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			insuredIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			payIntv = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|")))).intValue();
			payMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			payLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			disputedFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			outPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			getPolMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			signCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			signDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|"));
			signTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			consignNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			printCount = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 52, "|")))).intValue();
			lostTimes = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 53, "|")))).intValue();
			lang = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
			currency = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
			remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
			peoples = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|")))).intValue();
			mult = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|")))).doubleValue();
			prem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|")))).doubleValue();
			amnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|")))).doubleValue();
			sumPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|")))).doubleValue();
			dif = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|")))).doubleValue();
			paytoDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, "|"));
			firstPayDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, "|"));
			cValiDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 65, "|"));
			pSignDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 66, "|"));
			pValiDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 67, "|"));
			inputOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 68, "|");
			inputDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 69, "|"));
			inputTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 70, "|");
			approveFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 71, "|");
			approveCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 72, "|");
			approveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 73, "|"));
			approveTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 74, "|");
			uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 75, "|");
			uWOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76, "|");
			uWDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, "|"));
			uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, "|");
			appFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, "|");
			polApplyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, "|"));
			getPolDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, "|"));
			getPolTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82, "|");
			customGetPolDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, "|"));
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, "|");
			saleChnlDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, "|");
			proposalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, "|");
			editstate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, "|");
			cInValiDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, "|"));
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 92, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 93, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPContBSchema";
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
		if (FCode.equals("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equals("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equals("prtNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prtNo));
		if (FCode.equals("mainPolNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mainPolNo));
		if (FCode.equals("contType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contType));
		if (FCode.equals("familyType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(familyType));
		if (FCode.equals("familyID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(familyID));
		if (FCode.equals("polType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polType));
		if (FCode.equals("sugNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sugNo));
		if (FCode.equals("cardFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(cardFlag));
		if (FCode.equals("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equals("executeCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(executeCom));
		if (FCode.equals("agentCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCom));
		if (FCode.equals("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equals("agentGroup"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup));
		if (FCode.equals("agentCode1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode1));
		if (FCode.equals("agentGroup1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup1));
		if (FCode.equals("agentType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentType));
		if (FCode.equals("saleChnl"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnl));
		if (FCode.equals("handler"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(handler));
		if (FCode.equals("password"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(password));
		if (FCode.equals("appntNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntNo));
		if (FCode.equals("appntId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntId));
		if (FCode.equals("appntName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntName));
		if (FCode.equals("appntSex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntSex));
		if (FCode.equals("appntBirthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getappntBirthday()));
		if (FCode.equals("appntIDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntIDType));
		if (FCode.equals("appntIDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntIDNo));
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
		if (FCode.equals("insuredIDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredIDType));
		if (FCode.equals("insuredIDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredIDNo));
		if (FCode.equals("payIntv"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payIntv));
		if (FCode.equals("payMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payMode));
		if (FCode.equals("payLocation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payLocation));
		if (FCode.equals("disputedFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(disputedFlag));
		if (FCode.equals("outPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(outPayFlag));
		if (FCode.equals("getPolMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPolMode));
		if (FCode.equals("signCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signCom));
		if (FCode.equals("signDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getsignDate()));
		if (FCode.equals("signTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signTime));
		if (FCode.equals("consignNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(consignNo));
		if (FCode.equals("bankCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankCode));
		if (FCode.equals("bankAccNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankAccNo));
		if (FCode.equals("accName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(accName));
		if (FCode.equals("printCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(printCount));
		if (FCode.equals("lostTimes"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lostTimes));
		if (FCode.equals("lang"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lang));
		if (FCode.equals("currency"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currency));
		if (FCode.equals("remark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark));
		if (FCode.equals("peoples"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(peoples));
		if (FCode.equals("mult"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mult));
		if (FCode.equals("prem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prem));
		if (FCode.equals("amnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(amnt));
		if (FCode.equals("sumPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sumPrem));
		if (FCode.equals("dif"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dif));
		if (FCode.equals("paytoDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getpaytoDate()));
		if (FCode.equals("firstPayDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getfirstPayDate()));
		if (FCode.equals("cValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getcValiDate()));
		if (FCode.equals("pSignDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getpSignDate()));
		if (FCode.equals("pValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getpValiDate()));
		if (FCode.equals("inputOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(inputOperator));
		if (FCode.equals("inputDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getinputDate()));
		if (FCode.equals("inputTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(inputTime));
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
		if (FCode.equals("uWOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWOperator));
		if (FCode.equals("uWDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
		if (FCode.equals("uWTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWTime));
		if (FCode.equals("appFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appFlag));
		if (FCode.equals("polApplyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getpolApplyDate()));
		if (FCode.equals("getPolDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getgetPolDate()));
		if (FCode.equals("getPolTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPolTime));
		if (FCode.equals("customGetPolDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getcustomGetPolDate()));
		if (FCode.equals("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equals("saleChnlDetail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnlDetail));
		if (FCode.equals("proposalType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalType));
		if (FCode.equals("editstate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(editstate));
		if (FCode.equals("cInValiDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getcInValiDate()));
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
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(prtNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(mainPolNo);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(contType);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(familyType);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(familyID);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(polType);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(sugNo);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(cardFlag);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(executeCom);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(agentCom);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(agentGroup);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(agentCode1);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(agentGroup1);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(agentType);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(saleChnl);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(handler);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(password);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(appntNo);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(appntId);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(appntName);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(appntSex);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getappntBirthday()));
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(appntIDType);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(appntIDNo);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(insuredNo);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(insuredId);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(insuredName);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(insuredSex);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getinsuredBirthday()));
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(insuredIDType);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(insuredIDNo);
			break;

		case 38: // '&'
			strFieldValue = String.valueOf(payIntv);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(payMode);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(payLocation);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(disputedFlag);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(outPayFlag);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(getPolMode);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(signCom);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getsignDate()));
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(signTime);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(consignNo);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(bankCode);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(bankAccNo);
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(accName);
			break;

		case 51: // '3'
			strFieldValue = String.valueOf(printCount);
			break;

		case 52: // '4'
			strFieldValue = String.valueOf(lostTimes);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(lang);
			break;

		case 54: // '6'
			strFieldValue = StrTool.GBKToUnicode(currency);
			break;

		case 55: // '7'
			strFieldValue = StrTool.GBKToUnicode(remark);
			break;

		case 56: // '8'
			strFieldValue = String.valueOf(peoples);
			break;

		case 57: // '9'
			strFieldValue = String.valueOf(mult);
			break;

		case 58: // ':'
			strFieldValue = String.valueOf(prem);
			break;

		case 59: // ';'
			strFieldValue = String.valueOf(amnt);
			break;

		case 60: // '<'
			strFieldValue = String.valueOf(sumPrem);
			break;

		case 61: // '='
			strFieldValue = String.valueOf(dif);
			break;

		case 62: // '>'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpaytoDate()));
			break;

		case 63: // '?'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getfirstPayDate()));
			break;

		case 64: // '@'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getcValiDate()));
			break;

		case 65: // 'A'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpSignDate()));
			break;

		case 66: // 'B'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpValiDate()));
			break;

		case 67: // 'C'
			strFieldValue = StrTool.GBKToUnicode(inputOperator);
			break;

		case 68: // 'D'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getinputDate()));
			break;

		case 69: // 'E'
			strFieldValue = StrTool.GBKToUnicode(inputTime);
			break;

		case 70: // 'F'
			strFieldValue = StrTool.GBKToUnicode(approveFlag);
			break;

		case 71: // 'G'
			strFieldValue = StrTool.GBKToUnicode(approveCode);
			break;

		case 72: // 'H'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getapproveDate()));
			break;

		case 73: // 'I'
			strFieldValue = StrTool.GBKToUnicode(approveTime);
			break;

		case 74: // 'J'
			strFieldValue = StrTool.GBKToUnicode(uWFlag);
			break;

		case 75: // 'K'
			strFieldValue = StrTool.GBKToUnicode(uWOperator);
			break;

		case 76: // 'L'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
			break;

		case 77: // 'M'
			strFieldValue = StrTool.GBKToUnicode(uWTime);
			break;

		case 78: // 'N'
			strFieldValue = StrTool.GBKToUnicode(appFlag);
			break;

		case 79: // 'O'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getpolApplyDate()));
			break;

		case 80: // 'P'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getgetPolDate()));
			break;

		case 81: // 'Q'
			strFieldValue = StrTool.GBKToUnicode(getPolTime);
			break;

		case 82: // 'R'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getcustomGetPolDate()));
			break;

		case 83: // 'S'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 84: // 'T'
			strFieldValue = StrTool.GBKToUnicode(saleChnlDetail);
			break;

		case 85: // 'U'
			strFieldValue = StrTool.GBKToUnicode(proposalType);
			break;

		case 86: // 'V'
			strFieldValue = StrTool.GBKToUnicode(editstate);
			break;

		case 87: // 'W'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getcInValiDate()));
			break;

		case 88: // 'X'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 89: // 'Y'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 90: // 'Z'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 91: // '['
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
			break;

		case 92: // '\\'
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
		if (FCode.equals("prtNo"))
			if (FValue != null && !FValue.equals(""))
				prtNo = FValue.trim();
			else
				prtNo = null;
		if (FCode.equals("mainPolNo"))
			if (FValue != null && !FValue.equals(""))
				mainPolNo = FValue.trim();
			else
				mainPolNo = null;
		if (FCode.equals("contType"))
			if (FValue != null && !FValue.equals(""))
				contType = FValue.trim();
			else
				contType = null;
		if (FCode.equals("familyType"))
			if (FValue != null && !FValue.equals(""))
				familyType = FValue.trim();
			else
				familyType = null;
		if (FCode.equals("familyID"))
			if (FValue != null && !FValue.equals(""))
				familyID = FValue.trim();
			else
				familyID = null;
		if (FCode.equals("polType"))
			if (FValue != null && !FValue.equals(""))
				polType = FValue.trim();
			else
				polType = null;
		if (FCode.equals("sugNo"))
			if (FValue != null && !FValue.equals(""))
				sugNo = FValue.trim();
			else
				sugNo = null;
		if (FCode.equals("cardFlag"))
			if (FValue != null && !FValue.equals(""))
				cardFlag = FValue.trim();
			else
				cardFlag = null;
		if (FCode.equals("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equals("executeCom"))
			if (FValue != null && !FValue.equals(""))
				executeCom = FValue.trim();
			else
				executeCom = null;
		if (FCode.equals("agentCom"))
			if (FValue != null && !FValue.equals(""))
				agentCom = FValue.trim();
			else
				agentCom = null;
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
		if (FCode.equals("agentCode1"))
			if (FValue != null && !FValue.equals(""))
				agentCode1 = FValue.trim();
			else
				agentCode1 = null;
		if (FCode.equals("agentGroup1"))
			if (FValue != null && !FValue.equals(""))
				agentGroup1 = FValue.trim();
			else
				agentGroup1 = null;
		if (FCode.equals("agentType"))
			if (FValue != null && !FValue.equals(""))
				agentType = FValue.trim();
			else
				agentType = null;
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
		if (FCode.equals("password"))
			if (FValue != null && !FValue.equals(""))
				password = FValue.trim();
			else
				password = null;
		if (FCode.equals("appntNo"))
			if (FValue != null && !FValue.equals(""))
				appntNo = FValue.trim();
			else
				appntNo = null;
		if (FCode.equals("appntId"))
			if (FValue != null && !FValue.equals(""))
				appntId = FValue.trim();
			else
				appntId = null;
		if (FCode.equals("appntName"))
			if (FValue != null && !FValue.equals(""))
				appntName = FValue.trim();
			else
				appntName = null;
		if (FCode.equals("appntSex"))
			if (FValue != null && !FValue.equals(""))
				appntSex = FValue.trim();
			else
				appntSex = null;
		if (FCode.equals("appntBirthday"))
			if (FValue != null && !FValue.equals(""))
				appntBirthday = fDate.getDate(FValue);
			else
				appntBirthday = null;
		if (FCode.equals("appntIDType"))
			if (FValue != null && !FValue.equals(""))
				appntIDType = FValue.trim();
			else
				appntIDType = null;
		if (FCode.equals("appntIDNo"))
			if (FValue != null && !FValue.equals(""))
				appntIDNo = FValue.trim();
			else
				appntIDNo = null;
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
		if (FCode.equals("insuredIDType"))
			if (FValue != null && !FValue.equals(""))
				insuredIDType = FValue.trim();
			else
				insuredIDType = null;
		if (FCode.equals("insuredIDNo"))
			if (FValue != null && !FValue.equals(""))
				insuredIDNo = FValue.trim();
			else
				insuredIDNo = null;
		if (FCode.equals("payIntv") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payIntv = i;
		}
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
		if (FCode.equals("disputedFlag"))
			if (FValue != null && !FValue.equals(""))
				disputedFlag = FValue.trim();
			else
				disputedFlag = null;
		if (FCode.equals("outPayFlag"))
			if (FValue != null && !FValue.equals(""))
				outPayFlag = FValue.trim();
			else
				outPayFlag = null;
		if (FCode.equals("getPolMode"))
			if (FValue != null && !FValue.equals(""))
				getPolMode = FValue.trim();
			else
				getPolMode = null;
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
		if (FCode.equals("consignNo"))
			if (FValue != null && !FValue.equals(""))
				consignNo = FValue.trim();
			else
				consignNo = null;
		if (FCode.equals("bankCode"))
			if (FValue != null && !FValue.equals(""))
				bankCode = FValue.trim();
			else
				bankCode = null;
		if (FCode.equals("bankAccNo"))
			if (FValue != null && !FValue.equals(""))
				bankAccNo = FValue.trim();
			else
				bankAccNo = null;
		if (FCode.equals("accName"))
			if (FValue != null && !FValue.equals(""))
				accName = FValue.trim();
			else
				accName = null;
		if (FCode.equals("printCount") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			printCount = i;
		}
		if (FCode.equals("lostTimes") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			lostTimes = i;
		}
		if (FCode.equals("lang"))
			if (FValue != null && !FValue.equals(""))
				lang = FValue.trim();
			else
				lang = null;
		if (FCode.equals("currency"))
			if (FValue != null && !FValue.equals(""))
				currency = FValue.trim();
			else
				currency = null;
		if (FCode.equals("remark"))
			if (FValue != null && !FValue.equals(""))
				remark = FValue.trim();
			else
				remark = null;
		if (FCode.equals("peoples") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			peoples = i;
		}
		if (FCode.equals("mult") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mult = d;
		}
		if (FCode.equals("prem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			prem = d;
		}
		if (FCode.equals("amnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			amnt = d;
		}
		if (FCode.equals("sumPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sumPrem = d;
		}
		if (FCode.equals("dif") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			dif = d;
		}
		if (FCode.equals("paytoDate"))
			if (FValue != null && !FValue.equals(""))
				paytoDate = fDate.getDate(FValue);
			else
				paytoDate = null;
		if (FCode.equals("firstPayDate"))
			if (FValue != null && !FValue.equals(""))
				firstPayDate = fDate.getDate(FValue);
			else
				firstPayDate = null;
		if (FCode.equals("cValiDate"))
			if (FValue != null && !FValue.equals(""))
				cValiDate = fDate.getDate(FValue);
			else
				cValiDate = null;
		if (FCode.equals("pSignDate"))
			if (FValue != null && !FValue.equals(""))
				pSignDate = fDate.getDate(FValue);
			else
				pSignDate = null;
		if (FCode.equals("pValiDate"))
			if (FValue != null && !FValue.equals(""))
				pValiDate = fDate.getDate(FValue);
			else
				pValiDate = null;
		if (FCode.equals("inputOperator"))
			if (FValue != null && !FValue.equals(""))
				inputOperator = FValue.trim();
			else
				inputOperator = null;
		if (FCode.equals("inputDate"))
			if (FValue != null && !FValue.equals(""))
				inputDate = fDate.getDate(FValue);
			else
				inputDate = null;
		if (FCode.equals("inputTime"))
			if (FValue != null && !FValue.equals(""))
				inputTime = FValue.trim();
			else
				inputTime = null;
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
		if (FCode.equals("uWOperator"))
			if (FValue != null && !FValue.equals(""))
				uWOperator = FValue.trim();
			else
				uWOperator = null;
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
		if (FCode.equals("appFlag"))
			if (FValue != null && !FValue.equals(""))
				appFlag = FValue.trim();
			else
				appFlag = null;
		if (FCode.equals("polApplyDate"))
			if (FValue != null && !FValue.equals(""))
				polApplyDate = fDate.getDate(FValue);
			else
				polApplyDate = null;
		if (FCode.equals("getPolDate"))
			if (FValue != null && !FValue.equals(""))
				getPolDate = fDate.getDate(FValue);
			else
				getPolDate = null;
		if (FCode.equals("getPolTime"))
			if (FValue != null && !FValue.equals(""))
				getPolTime = FValue.trim();
			else
				getPolTime = null;
		if (FCode.equals("customGetPolDate"))
			if (FValue != null && !FValue.equals(""))
				customGetPolDate = fDate.getDate(FValue);
			else
				customGetPolDate = null;
		if (FCode.equals("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equals("saleChnlDetail"))
			if (FValue != null && !FValue.equals(""))
				saleChnlDetail = FValue.trim();
			else
				saleChnlDetail = null;
		if (FCode.equals("proposalType"))
			if (FValue != null && !FValue.equals(""))
				proposalType = FValue.trim();
			else
				proposalType = null;
		if (FCode.equals("editstate"))
			if (FValue != null && !FValue.equals(""))
				editstate = FValue.trim();
			else
				editstate = null;
		if (FCode.equals("cInValiDate"))
			if (FValue != null && !FValue.equals(""))
				cInValiDate = fDate.getDate(FValue);
			else
				cInValiDate = null;
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
		LNPContBSchema other = (LNPContBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && grpContNo.equals(other.getgrpContNo()) && contNo.equals(other.getcontNo()) && proposalContNo.equals(other.getproposalContNo()) && prtNo.equals(other.getprtNo()) && mainPolNo.equals(other.getmainPolNo()) && contType.equals(other.getcontType()) && familyType.equals(other.getfamilyType()) && familyID.equals(other.getfamilyID()) && polType.equals(other.getpolType()) && sugNo.equals(other.getsugNo()) && cardFlag.equals(other.getcardFlag()) && manageCom.equals(other.getmanageCom()) && executeCom.equals(other.getexecuteCom()) && agentCom.equals(other.getagentCom()) && agentCode.equals(other.getagentCode()) && agentGroup.equals(other.getagentGroup()) && agentCode1.equals(other.getagentCode1()) && agentGroup1.equals(other.getagentGroup1()) && agentType.equals(other.getagentType()) && saleChnl.equals(other.getsaleChnl()) && handler.equals(other.gethandler()) && password.equals(other.getpassword()) && appntNo.equals(other.getappntNo()) && appntId.equals(other.getappntId()) && appntName.equals(other.getappntName()) && appntSex.equals(other.getappntSex()) && fDate.getString(appntBirthday).equals(other.getappntBirthday()) && appntIDType.equals(other.getappntIDType()) && appntIDNo.equals(other.getappntIDNo()) && insuredNo.equals(other.getinsuredNo()) && insuredId.equals(other.getinsuredId()) && insuredName.equals(other.getinsuredName()) && insuredSex.equals(other.getinsuredSex()) && fDate.getString(insuredBirthday).equals(other.getinsuredBirthday()) && insuredIDType.equals(other.getinsuredIDType()) && insuredIDNo.equals(other.getinsuredIDNo()) && payIntv == other.getpayIntv() && payMode.equals(other.getpayMode()) && payLocation.equals(other.getpayLocation()) && disputedFlag.equals(other.getdisputedFlag()) && outPayFlag.equals(other.getoutPayFlag()) && getPolMode.equals(other.getgetPolMode()) && signCom.equals(other.getsignCom()) && fDate.getString(signDate).equals(other.getsignDate()) && signTime.equals(other.getsignTime()) && consignNo.equals(other.getconsignNo()) && bankCode.equals(other.getbankCode()) && bankAccNo.equals(other.getbankAccNo()) && accName.equals(other.getaccName()) && printCount == other.getprintCount() && lostTimes == other.getlostTimes() && lang.equals(other.getlang()) && currency.equals(other.getcurrency()) && remark.equals(other.getremark()) && peoples == other.getpeoples() && mult == other.getmult() && prem == other.getprem() && amnt == other.getamnt() && sumPrem == other.getsumPrem() && dif == other.getdif() && fDate.getString(paytoDate).equals(other.getpaytoDate()) && fDate.getString(firstPayDate).equals(other.getfirstPayDate()) && fDate.getString(cValiDate).equals(other.getcValiDate()) && fDate.getString(pSignDate).equals(other.getpSignDate()) && fDate.getString(pValiDate).equals(other.getpValiDate()) && inputOperator.equals(other.getinputOperator()) && fDate.getString(inputDate).equals(other.getinputDate()) && inputTime.equals(other.getinputTime()) && approveFlag.equals(other.getapproveFlag()) && approveCode.equals(other.getapproveCode()) && fDate.getString(approveDate).equals(other.getapproveDate()) && approveTime.equals(other.getapproveTime()) && uWFlag.equals(other.getuWFlag()) && uWOperator.equals(other.getuWOperator()) && fDate.getString(uWDate).equals(other.getuWDate()) && uWTime.equals(other.getuWTime()) && appFlag.equals(other.getappFlag()) && fDate.getString(polApplyDate).equals(other.getpolApplyDate()) && fDate.getString(getPolDate).equals(other.getgetPolDate()) && getPolTime.equals(other.getgetPolTime()) && fDate.getString(customGetPolDate).equals(other.getcustomGetPolDate()) && state.equals(other.getstate()) && saleChnlDetail.equals(other.getsaleChnlDetail()) && proposalType.equals(other.getproposalType()) && editstate.equals(other.geteditstate()) && fDate.getString(cInValiDate).equals(other.getcInValiDate()) && operator.equals(other.getoperator()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime());
	}

	public int getFieldCount()
	{
		return 93;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("grpContNo"))
			return 2;
		if (strFieldName.equals("contNo"))
			return 3;
		if (strFieldName.equals("proposalContNo"))
			return 4;
		if (strFieldName.equals("prtNo"))
			return 5;
		if (strFieldName.equals("mainPolNo"))
			return 6;
		if (strFieldName.equals("contType"))
			return 7;
		if (strFieldName.equals("familyType"))
			return 8;
		if (strFieldName.equals("familyID"))
			return 9;
		if (strFieldName.equals("polType"))
			return 10;
		if (strFieldName.equals("sugNo"))
			return 11;
		if (strFieldName.equals("cardFlag"))
			return 12;
		if (strFieldName.equals("manageCom"))
			return 13;
		if (strFieldName.equals("executeCom"))
			return 14;
		if (strFieldName.equals("agentCom"))
			return 15;
		if (strFieldName.equals("agentCode"))
			return 16;
		if (strFieldName.equals("agentGroup"))
			return 17;
		if (strFieldName.equals("agentCode1"))
			return 18;
		if (strFieldName.equals("agentGroup1"))
			return 19;
		if (strFieldName.equals("agentType"))
			return 20;
		if (strFieldName.equals("saleChnl"))
			return 21;
		if (strFieldName.equals("handler"))
			return 22;
		if (strFieldName.equals("password"))
			return 23;
		if (strFieldName.equals("appntNo"))
			return 24;
		if (strFieldName.equals("appntId"))
			return 25;
		if (strFieldName.equals("appntName"))
			return 26;
		if (strFieldName.equals("appntSex"))
			return 27;
		if (strFieldName.equals("appntBirthday"))
			return 28;
		if (strFieldName.equals("appntIDType"))
			return 29;
		if (strFieldName.equals("appntIDNo"))
			return 30;
		if (strFieldName.equals("insuredNo"))
			return 31;
		if (strFieldName.equals("insuredId"))
			return 32;
		if (strFieldName.equals("insuredName"))
			return 33;
		if (strFieldName.equals("insuredSex"))
			return 34;
		if (strFieldName.equals("insuredBirthday"))
			return 35;
		if (strFieldName.equals("insuredIDType"))
			return 36;
		if (strFieldName.equals("insuredIDNo"))
			return 37;
		if (strFieldName.equals("payIntv"))
			return 38;
		if (strFieldName.equals("payMode"))
			return 39;
		if (strFieldName.equals("payLocation"))
			return 40;
		if (strFieldName.equals("disputedFlag"))
			return 41;
		if (strFieldName.equals("outPayFlag"))
			return 42;
		if (strFieldName.equals("getPolMode"))
			return 43;
		if (strFieldName.equals("signCom"))
			return 44;
		if (strFieldName.equals("signDate"))
			return 45;
		if (strFieldName.equals("signTime"))
			return 46;
		if (strFieldName.equals("consignNo"))
			return 47;
		if (strFieldName.equals("bankCode"))
			return 48;
		if (strFieldName.equals("bankAccNo"))
			return 49;
		if (strFieldName.equals("accName"))
			return 50;
		if (strFieldName.equals("printCount"))
			return 51;
		if (strFieldName.equals("lostTimes"))
			return 52;
		if (strFieldName.equals("lang"))
			return 53;
		if (strFieldName.equals("currency"))
			return 54;
		if (strFieldName.equals("remark"))
			return 55;
		if (strFieldName.equals("peoples"))
			return 56;
		if (strFieldName.equals("mult"))
			return 57;
		if (strFieldName.equals("prem"))
			return 58;
		if (strFieldName.equals("amnt"))
			return 59;
		if (strFieldName.equals("sumPrem"))
			return 60;
		if (strFieldName.equals("dif"))
			return 61;
		if (strFieldName.equals("paytoDate"))
			return 62;
		if (strFieldName.equals("firstPayDate"))
			return 63;
		if (strFieldName.equals("cValiDate"))
			return 64;
		if (strFieldName.equals("pSignDate"))
			return 65;
		if (strFieldName.equals("pValiDate"))
			return 66;
		if (strFieldName.equals("inputOperator"))
			return 67;
		if (strFieldName.equals("inputDate"))
			return 68;
		if (strFieldName.equals("inputTime"))
			return 69;
		if (strFieldName.equals("approveFlag"))
			return 70;
		if (strFieldName.equals("approveCode"))
			return 71;
		if (strFieldName.equals("approveDate"))
			return 72;
		if (strFieldName.equals("approveTime"))
			return 73;
		if (strFieldName.equals("uWFlag"))
			return 74;
		if (strFieldName.equals("uWOperator"))
			return 75;
		if (strFieldName.equals("uWDate"))
			return 76;
		if (strFieldName.equals("uWTime"))
			return 77;
		if (strFieldName.equals("appFlag"))
			return 78;
		if (strFieldName.equals("polApplyDate"))
			return 79;
		if (strFieldName.equals("getPolDate"))
			return 80;
		if (strFieldName.equals("getPolTime"))
			return 81;
		if (strFieldName.equals("customGetPolDate"))
			return 82;
		if (strFieldName.equals("state"))
			return 83;
		if (strFieldName.equals("saleChnlDetail"))
			return 84;
		if (strFieldName.equals("proposalType"))
			return 85;
		if (strFieldName.equals("editstate"))
			return 86;
		if (strFieldName.equals("cInValiDate"))
			return 87;
		if (strFieldName.equals("operator"))
			return 88;
		if (strFieldName.equals("makeDate"))
			return 89;
		if (strFieldName.equals("makeTime"))
			return 90;
		if (strFieldName.equals("modifyDate"))
			return 91;
		return !strFieldName.equals("modifyTime") ? -1 : 92;
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
			strFieldName = "contNo";
			break;

		case 4: // '\004'
			strFieldName = "proposalContNo";
			break;

		case 5: // '\005'
			strFieldName = "prtNo";
			break;

		case 6: // '\006'
			strFieldName = "mainPolNo";
			break;

		case 7: // '\007'
			strFieldName = "contType";
			break;

		case 8: // '\b'
			strFieldName = "familyType";
			break;

		case 9: // '\t'
			strFieldName = "familyID";
			break;

		case 10: // '\n'
			strFieldName = "polType";
			break;

		case 11: // '\013'
			strFieldName = "sugNo";
			break;

		case 12: // '\f'
			strFieldName = "cardFlag";
			break;

		case 13: // '\r'
			strFieldName = "manageCom";
			break;

		case 14: // '\016'
			strFieldName = "executeCom";
			break;

		case 15: // '\017'
			strFieldName = "agentCom";
			break;

		case 16: // '\020'
			strFieldName = "agentCode";
			break;

		case 17: // '\021'
			strFieldName = "agentGroup";
			break;

		case 18: // '\022'
			strFieldName = "agentCode1";
			break;

		case 19: // '\023'
			strFieldName = "agentGroup1";
			break;

		case 20: // '\024'
			strFieldName = "agentType";
			break;

		case 21: // '\025'
			strFieldName = "saleChnl";
			break;

		case 22: // '\026'
			strFieldName = "handler";
			break;

		case 23: // '\027'
			strFieldName = "password";
			break;

		case 24: // '\030'
			strFieldName = "appntNo";
			break;

		case 25: // '\031'
			strFieldName = "appntId";
			break;

		case 26: // '\032'
			strFieldName = "appntName";
			break;

		case 27: // '\033'
			strFieldName = "appntSex";
			break;

		case 28: // '\034'
			strFieldName = "appntBirthday";
			break;

		case 29: // '\035'
			strFieldName = "appntIDType";
			break;

		case 30: // '\036'
			strFieldName = "appntIDNo";
			break;

		case 31: // '\037'
			strFieldName = "insuredNo";
			break;

		case 32: // ' '
			strFieldName = "insuredId";
			break;

		case 33: // '!'
			strFieldName = "insuredName";
			break;

		case 34: // '"'
			strFieldName = "insuredSex";
			break;

		case 35: // '#'
			strFieldName = "insuredBirthday";
			break;

		case 36: // '$'
			strFieldName = "insuredIDType";
			break;

		case 37: // '%'
			strFieldName = "insuredIDNo";
			break;

		case 38: // '&'
			strFieldName = "payIntv";
			break;

		case 39: // '\''
			strFieldName = "payMode";
			break;

		case 40: // '('
			strFieldName = "payLocation";
			break;

		case 41: // ')'
			strFieldName = "disputedFlag";
			break;

		case 42: // '*'
			strFieldName = "outPayFlag";
			break;

		case 43: // '+'
			strFieldName = "getPolMode";
			break;

		case 44: // ','
			strFieldName = "signCom";
			break;

		case 45: // '-'
			strFieldName = "signDate";
			break;

		case 46: // '.'
			strFieldName = "signTime";
			break;

		case 47: // '/'
			strFieldName = "consignNo";
			break;

		case 48: // '0'
			strFieldName = "bankCode";
			break;

		case 49: // '1'
			strFieldName = "bankAccNo";
			break;

		case 50: // '2'
			strFieldName = "accName";
			break;

		case 51: // '3'
			strFieldName = "printCount";
			break;

		case 52: // '4'
			strFieldName = "lostTimes";
			break;

		case 53: // '5'
			strFieldName = "lang";
			break;

		case 54: // '6'
			strFieldName = "currency";
			break;

		case 55: // '7'
			strFieldName = "remark";
			break;

		case 56: // '8'
			strFieldName = "peoples";
			break;

		case 57: // '9'
			strFieldName = "mult";
			break;

		case 58: // ':'
			strFieldName = "prem";
			break;

		case 59: // ';'
			strFieldName = "amnt";
			break;

		case 60: // '<'
			strFieldName = "sumPrem";
			break;

		case 61: // '='
			strFieldName = "dif";
			break;

		case 62: // '>'
			strFieldName = "paytoDate";
			break;

		case 63: // '?'
			strFieldName = "firstPayDate";
			break;

		case 64: // '@'
			strFieldName = "cValiDate";
			break;

		case 65: // 'A'
			strFieldName = "pSignDate";
			break;

		case 66: // 'B'
			strFieldName = "pValiDate";
			break;

		case 67: // 'C'
			strFieldName = "inputOperator";
			break;

		case 68: // 'D'
			strFieldName = "inputDate";
			break;

		case 69: // 'E'
			strFieldName = "inputTime";
			break;

		case 70: // 'F'
			strFieldName = "approveFlag";
			break;

		case 71: // 'G'
			strFieldName = "approveCode";
			break;

		case 72: // 'H'
			strFieldName = "approveDate";
			break;

		case 73: // 'I'
			strFieldName = "approveTime";
			break;

		case 74: // 'J'
			strFieldName = "uWFlag";
			break;

		case 75: // 'K'
			strFieldName = "uWOperator";
			break;

		case 76: // 'L'
			strFieldName = "uWDate";
			break;

		case 77: // 'M'
			strFieldName = "uWTime";
			break;

		case 78: // 'N'
			strFieldName = "appFlag";
			break;

		case 79: // 'O'
			strFieldName = "polApplyDate";
			break;

		case 80: // 'P'
			strFieldName = "getPolDate";
			break;

		case 81: // 'Q'
			strFieldName = "getPolTime";
			break;

		case 82: // 'R'
			strFieldName = "customGetPolDate";
			break;

		case 83: // 'S'
			strFieldName = "state";
			break;

		case 84: // 'T'
			strFieldName = "saleChnlDetail";
			break;

		case 85: // 'U'
			strFieldName = "proposalType";
			break;

		case 86: // 'V'
			strFieldName = "editstate";
			break;

		case 87: // 'W'
			strFieldName = "cInValiDate";
			break;

		case 88: // 'X'
			strFieldName = "operator";
			break;

		case 89: // 'Y'
			strFieldName = "makeDate";
			break;

		case 90: // 'Z'
			strFieldName = "makeTime";
			break;

		case 91: // '['
			strFieldName = "modifyDate";
			break;

		case 92: // '\\'
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
			nFieldType = 0;
			break;

		case 27: // '\033'
			nFieldType = 0;
			break;

		case 28: // '\034'
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 38: // '&'
			nFieldType = 3;
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
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 50: // '2'
			nFieldType = 0;
			break;

		case 51: // '3'
			nFieldType = 3;
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
			nFieldType = 3;
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
			nFieldType = 4;
			break;

		case 61: // '='
			nFieldType = 4;
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
			nFieldType = 1;
			break;

		case 66: // 'B'
			nFieldType = 1;
			break;

		case 67: // 'C'
			nFieldType = 0;
			break;

		case 68: // 'D'
			nFieldType = 1;
			break;

		case 69: // 'E'
			nFieldType = 0;
			break;

		case 70: // 'F'
			nFieldType = 0;
			break;

		case 71: // 'G'
			nFieldType = 0;
			break;

		case 72: // 'H'
			nFieldType = 1;
			break;

		case 73: // 'I'
			nFieldType = 0;
			break;

		case 74: // 'J'
			nFieldType = 0;
			break;

		case 75: // 'K'
			nFieldType = 0;
			break;

		case 76: // 'L'
			nFieldType = 1;
			break;

		case 77: // 'M'
			nFieldType = 0;
			break;

		case 78: // 'N'
			nFieldType = 0;
			break;

		case 79: // 'O'
			nFieldType = 1;
			break;

		case 80: // 'P'
			nFieldType = 1;
			break;

		case 81: // 'Q'
			nFieldType = 0;
			break;

		case 82: // 'R'
			nFieldType = 1;
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

		case 91: // '['
			nFieldType = 1;
			break;

		case 92: // '\\'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
