// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPIndUWMasterSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPIndUWMasterDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPIndUWMasterSchema
	implements Schema, Cloneable
{

	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private int uWNo;
	private String manageCom;
	private String insuredId;
	private String insuredNo;
	private String insuredName;
	private String flagCaseDcl;
	private String highFaceAmount;
	private String uWMessages;
	private String appntId;
	private String appntNo;
	private String appntName;
	private String passFlag;
	private String uWIdea;
	private String uWGrade;
	private String appGrade;
	private String postponeDay;
	private Date postponeDate;
	private String autoUWFlag;
	private String state;
	private String upReportContent;
	private String healthFlag;
	private String quesFlag;
	private String specFlag;
	private String addPremFlag;
	private String addPremReason;
	private String reportFlag;
	private String specReason;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 35;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPIndUWMasterSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "ContNo";
		pk[1] = "InsuredId";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPIndUWMasterSchema cloned = (LNPIndUWMasterSchema)super.clone();
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

	public int getUWNo()
	{
		return uWNo;
	}

	public void setUWNo(int aUWNo)
	{
		uWNo = aUWNo;
	}

	public void setUWNo(String aUWNo)
	{
		if (aUWNo != null && !aUWNo.equals(""))
		{
			Integer tInteger = new Integer(aUWNo);
			int i = tInteger.intValue();
			uWNo = i;
		}
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getInsuredId()
	{
		return insuredId;
	}

	public void setInsuredId(String aInsuredId)
	{
		insuredId = aInsuredId;
	}

	public String getInsuredNo()
	{
		return insuredNo;
	}

	public void setInsuredNo(String aInsuredNo)
	{
		insuredNo = aInsuredNo;
	}

	public String getInsuredName()
	{
		return insuredName;
	}

	public void setInsuredName(String aInsuredName)
	{
		insuredName = aInsuredName;
	}

	public String getFlagCaseDcl()
	{
		return flagCaseDcl;
	}

	public void setFlagCaseDcl(String aFlagCaseDcl)
	{
		flagCaseDcl = aFlagCaseDcl;
	}

	public String getHighFaceAmount()
	{
		return highFaceAmount;
	}

	public void setHighFaceAmount(String aHighFaceAmount)
	{
		highFaceAmount = aHighFaceAmount;
	}

	public String getUWMessages()
	{
		return uWMessages;
	}

	public void setUWMessages(String aUWMessages)
	{
		uWMessages = aUWMessages;
	}

	public String getAppntId()
	{
		return appntId;
	}

	public void setAppntId(String aAppntId)
	{
		appntId = aAppntId;
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

	public String getPassFlag()
	{
		return passFlag;
	}

	public void setPassFlag(String aPassFlag)
	{
		passFlag = aPassFlag;
	}

	public String getUWIdea()
	{
		return uWIdea;
	}

	public void setUWIdea(String aUWIdea)
	{
		uWIdea = aUWIdea;
	}

	public String getUWGrade()
	{
		return uWGrade;
	}

	public void setUWGrade(String aUWGrade)
	{
		uWGrade = aUWGrade;
	}

	public String getAppGrade()
	{
		return appGrade;
	}

	public void setAppGrade(String aAppGrade)
	{
		appGrade = aAppGrade;
	}

	public String getPostponeDay()
	{
		return postponeDay;
	}

	public void setPostponeDay(String aPostponeDay)
	{
		postponeDay = aPostponeDay;
	}

	public String getPostponeDate()
	{
		if (postponeDate != null)
			return fDate.getString(postponeDate);
		else
			return null;
	}

	public void setPostponeDate(Date aPostponeDate)
	{
		postponeDate = aPostponeDate;
	}

	public void setPostponeDate(String aPostponeDate)
	{
		if (aPostponeDate != null && !aPostponeDate.equals(""))
			postponeDate = fDate.getDate(aPostponeDate);
		else
			postponeDate = null;
	}

	public String getAutoUWFlag()
	{
		return autoUWFlag;
	}

	public void setAutoUWFlag(String aAutoUWFlag)
	{
		autoUWFlag = aAutoUWFlag;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getUpReportContent()
	{
		return upReportContent;
	}

	public void setUpReportContent(String aUpReportContent)
	{
		upReportContent = aUpReportContent;
	}

	public String getHealthFlag()
	{
		return healthFlag;
	}

	public void setHealthFlag(String aHealthFlag)
	{
		healthFlag = aHealthFlag;
	}

	public String getQuesFlag()
	{
		return quesFlag;
	}

	public void setQuesFlag(String aQuesFlag)
	{
		quesFlag = aQuesFlag;
	}

	public String getSpecFlag()
	{
		return specFlag;
	}

	public void setSpecFlag(String aSpecFlag)
	{
		specFlag = aSpecFlag;
	}

	public String getAddPremFlag()
	{
		return addPremFlag;
	}

	public void setAddPremFlag(String aAddPremFlag)
	{
		addPremFlag = aAddPremFlag;
	}

	public String getAddPremReason()
	{
		return addPremReason;
	}

	public void setAddPremReason(String aAddPremReason)
	{
		addPremReason = aAddPremReason;
	}

	public String getReportFlag()
	{
		return reportFlag;
	}

	public void setReportFlag(String aReportFlag)
	{
		reportFlag = aReportFlag;
	}

	public String getSpecReason()
	{
		return specReason;
	}

	public void setSpecReason(String aSpecReason)
	{
		specReason = aSpecReason;
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

	public void setSchema(LNPIndUWMasterSchema aLNPIndUWMasterSchema)
	{
		grpContNo = aLNPIndUWMasterSchema.getGrpContNo();
		contNo = aLNPIndUWMasterSchema.getContNo();
		proposalContNo = aLNPIndUWMasterSchema.getProposalContNo();
		uWNo = aLNPIndUWMasterSchema.getUWNo();
		manageCom = aLNPIndUWMasterSchema.getManageCom();
		insuredId = aLNPIndUWMasterSchema.getInsuredId();
		insuredNo = aLNPIndUWMasterSchema.getInsuredNo();
		insuredName = aLNPIndUWMasterSchema.getInsuredName();
		flagCaseDcl = aLNPIndUWMasterSchema.getFlagCaseDcl();
		highFaceAmount = aLNPIndUWMasterSchema.getHighFaceAmount();
		uWMessages = aLNPIndUWMasterSchema.getUWMessages();
		appntId = aLNPIndUWMasterSchema.getAppntId();
		appntNo = aLNPIndUWMasterSchema.getAppntNo();
		appntName = aLNPIndUWMasterSchema.getAppntName();
		passFlag = aLNPIndUWMasterSchema.getPassFlag();
		uWIdea = aLNPIndUWMasterSchema.getUWIdea();
		uWGrade = aLNPIndUWMasterSchema.getUWGrade();
		appGrade = aLNPIndUWMasterSchema.getAppGrade();
		postponeDay = aLNPIndUWMasterSchema.getPostponeDay();
		postponeDate = fDate.getDate(aLNPIndUWMasterSchema.getPostponeDate());
		autoUWFlag = aLNPIndUWMasterSchema.getAutoUWFlag();
		state = aLNPIndUWMasterSchema.getState();
		upReportContent = aLNPIndUWMasterSchema.getUpReportContent();
		healthFlag = aLNPIndUWMasterSchema.getHealthFlag();
		quesFlag = aLNPIndUWMasterSchema.getQuesFlag();
		specFlag = aLNPIndUWMasterSchema.getSpecFlag();
		addPremFlag = aLNPIndUWMasterSchema.getAddPremFlag();
		addPremReason = aLNPIndUWMasterSchema.getAddPremReason();
		reportFlag = aLNPIndUWMasterSchema.getReportFlag();
		specReason = aLNPIndUWMasterSchema.getSpecReason();
		operator = aLNPIndUWMasterSchema.getOperator();
		makeDate = fDate.getDate(aLNPIndUWMasterSchema.getMakeDate());
		makeTime = aLNPIndUWMasterSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPIndUWMasterSchema.getModifyDate());
		modifyTime = aLNPIndUWMasterSchema.getModifyTime();
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
			uWNo = rs.getInt("UWNo");
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("InsuredId") == null)
				insuredId = null;
			else
				insuredId = rs.getString("InsuredId").trim();
			if (rs.getString("InsuredNo") == null)
				insuredNo = null;
			else
				insuredNo = rs.getString("InsuredNo").trim();
			if (rs.getString("InsuredName") == null)
				insuredName = null;
			else
				insuredName = rs.getString("InsuredName").trim();
			if (rs.getString("FlagCaseDcl") == null)
				flagCaseDcl = null;
			else
				flagCaseDcl = rs.getString("FlagCaseDcl").trim();
			if (rs.getString("HighFaceAmount") == null)
				highFaceAmount = null;
			else
				highFaceAmount = rs.getString("HighFaceAmount").trim();
			if (rs.getString("UWMessages") == null)
				uWMessages = null;
			else
				uWMessages = rs.getString("UWMessages").trim();
			if (rs.getString("AppntId") == null)
				appntId = null;
			else
				appntId = rs.getString("AppntId").trim();
			if (rs.getString("AppntNo") == null)
				appntNo = null;
			else
				appntNo = rs.getString("AppntNo").trim();
			if (rs.getString("AppntName") == null)
				appntName = null;
			else
				appntName = rs.getString("AppntName").trim();
			if (rs.getString("PassFlag") == null)
				passFlag = null;
			else
				passFlag = rs.getString("PassFlag").trim();
			if (rs.getString("UWIdea") == null)
				uWIdea = null;
			else
				uWIdea = rs.getString("UWIdea").trim();
			if (rs.getString("UWGrade") == null)
				uWGrade = null;
			else
				uWGrade = rs.getString("UWGrade").trim();
			if (rs.getString("AppGrade") == null)
				appGrade = null;
			else
				appGrade = rs.getString("AppGrade").trim();
			if (rs.getString("PostponeDay") == null)
				postponeDay = null;
			else
				postponeDay = rs.getString("PostponeDay").trim();
			postponeDate = rs.getDate("PostponeDate");
			if (rs.getString("AutoUWFlag") == null)
				autoUWFlag = null;
			else
				autoUWFlag = rs.getString("AutoUWFlag").trim();
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			if (rs.getString("UpReportContent") == null)
				upReportContent = null;
			else
				upReportContent = rs.getString("UpReportContent").trim();
			if (rs.getString("HealthFlag") == null)
				healthFlag = null;
			else
				healthFlag = rs.getString("HealthFlag").trim();
			if (rs.getString("QuesFlag") == null)
				quesFlag = null;
			else
				quesFlag = rs.getString("QuesFlag").trim();
			if (rs.getString("SpecFlag") == null)
				specFlag = null;
			else
				specFlag = rs.getString("SpecFlag").trim();
			if (rs.getString("AddPremFlag") == null)
				addPremFlag = null;
			else
				addPremFlag = rs.getString("AddPremFlag").trim();
			if (rs.getString("AddPremReason") == null)
				addPremReason = null;
			else
				addPremReason = rs.getString("AddPremReason").trim();
			if (rs.getString("ReportFlag") == null)
				reportFlag = null;
			else
				reportFlag = rs.getString("ReportFlag").trim();
			if (rs.getString("SpecReason") == null)
				specReason = null;
			else
				specReason = rs.getString("SpecReason").trim();
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
			System.out.println("?????§Ö?LNPIndUWMaster????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPIndUWMasterSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPIndUWMasterSchema getSchema()
	{
		LNPIndUWMasterSchema aLNPIndUWMasterSchema = new LNPIndUWMasterSchema();
		aLNPIndUWMasterSchema.setSchema(this);
		return aLNPIndUWMasterSchema;
	}

	public LNPIndUWMasterDB getDB()
	{
		LNPIndUWMasterDB aDBOper = new LNPIndUWMasterDB();
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
		strReturn.append(ChgData.chgData(uWNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(flagCaseDcl));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(highFaceAmount));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWMessages));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(passFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWIdea));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(postponeDay));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(postponeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(autoUWFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(upReportContent));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(healthFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(quesFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(specFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(addPremFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(addPremReason));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(reportFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(specReason));
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
			uWNo = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|")))).intValue();
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			flagCaseDcl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			highFaceAmount = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			uWMessages = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			passFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			uWIdea = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			uWGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			appGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			postponeDay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			postponeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
			autoUWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			upReportContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			healthFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			quesFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			addPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			addPremReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			reportFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			specReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPIndUWMasterSchema";
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
		if (FCode.equalsIgnoreCase("uWNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWNo));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("insuredId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredId));
		if (FCode.equalsIgnoreCase("insuredNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredNo));
		if (FCode.equalsIgnoreCase("insuredName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredName));
		if (FCode.equalsIgnoreCase("flagCaseDcl"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(flagCaseDcl));
		if (FCode.equalsIgnoreCase("highFaceAmount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(highFaceAmount));
		if (FCode.equalsIgnoreCase("uWMessages"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWMessages));
		if (FCode.equalsIgnoreCase("appntId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntId));
		if (FCode.equalsIgnoreCase("appntNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntNo));
		if (FCode.equalsIgnoreCase("appntName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntName));
		if (FCode.equalsIgnoreCase("passFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(passFlag));
		if (FCode.equalsIgnoreCase("uWIdea"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWIdea));
		if (FCode.equalsIgnoreCase("uWGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWGrade));
		if (FCode.equalsIgnoreCase("appGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appGrade));
		if (FCode.equalsIgnoreCase("postponeDay"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(postponeDay));
		if (FCode.equalsIgnoreCase("postponeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPostponeDate()));
		if (FCode.equalsIgnoreCase("autoUWFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(autoUWFlag));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("upReportContent"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(upReportContent));
		if (FCode.equalsIgnoreCase("healthFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(healthFlag));
		if (FCode.equalsIgnoreCase("quesFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(quesFlag));
		if (FCode.equalsIgnoreCase("specFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(specFlag));
		if (FCode.equalsIgnoreCase("addPremFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addPremFlag));
		if (FCode.equalsIgnoreCase("addPremReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addPremReason));
		if (FCode.equalsIgnoreCase("reportFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(reportFlag));
		if (FCode.equalsIgnoreCase("specReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(specReason));
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
			strFieldValue = String.valueOf(uWNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(insuredId);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(insuredNo);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(insuredName);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(flagCaseDcl);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(highFaceAmount);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(uWMessages);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(appntId);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(appntNo);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(appntName);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(passFlag);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(uWIdea);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(uWGrade);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(appGrade);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(postponeDay);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPostponeDate()));
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(autoUWFlag);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(upReportContent);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(healthFlag);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(quesFlag);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(specFlag);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(addPremFlag);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(addPremReason);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(reportFlag);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(specReason);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 34: // '"'
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
		if (FCode.equalsIgnoreCase("uWNo") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			uWNo = i;
		}
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("insuredId"))
			if (FValue != null && !FValue.equals(""))
				insuredId = FValue.trim();
			else
				insuredId = null;
		if (FCode.equalsIgnoreCase("insuredNo"))
			if (FValue != null && !FValue.equals(""))
				insuredNo = FValue.trim();
			else
				insuredNo = null;
		if (FCode.equalsIgnoreCase("insuredName"))
			if (FValue != null && !FValue.equals(""))
				insuredName = FValue.trim();
			else
				insuredName = null;
		if (FCode.equalsIgnoreCase("flagCaseDcl"))
			if (FValue != null && !FValue.equals(""))
				flagCaseDcl = FValue.trim();
			else
				flagCaseDcl = null;
		if (FCode.equalsIgnoreCase("highFaceAmount"))
			if (FValue != null && !FValue.equals(""))
				highFaceAmount = FValue.trim();
			else
				highFaceAmount = null;
		if (FCode.equalsIgnoreCase("uWMessages"))
			if (FValue != null && !FValue.equals(""))
				uWMessages = FValue.trim();
			else
				uWMessages = null;
		if (FCode.equalsIgnoreCase("appntId"))
			if (FValue != null && !FValue.equals(""))
				appntId = FValue.trim();
			else
				appntId = null;
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
		if (FCode.equalsIgnoreCase("passFlag"))
			if (FValue != null && !FValue.equals(""))
				passFlag = FValue.trim();
			else
				passFlag = null;
		if (FCode.equalsIgnoreCase("uWIdea"))
			if (FValue != null && !FValue.equals(""))
				uWIdea = FValue.trim();
			else
				uWIdea = null;
		if (FCode.equalsIgnoreCase("uWGrade"))
			if (FValue != null && !FValue.equals(""))
				uWGrade = FValue.trim();
			else
				uWGrade = null;
		if (FCode.equalsIgnoreCase("appGrade"))
			if (FValue != null && !FValue.equals(""))
				appGrade = FValue.trim();
			else
				appGrade = null;
		if (FCode.equalsIgnoreCase("postponeDay"))
			if (FValue != null && !FValue.equals(""))
				postponeDay = FValue.trim();
			else
				postponeDay = null;
		if (FCode.equalsIgnoreCase("postponeDate"))
			if (FValue != null && !FValue.equals(""))
				postponeDate = fDate.getDate(FValue);
			else
				postponeDate = null;
		if (FCode.equalsIgnoreCase("autoUWFlag"))
			if (FValue != null && !FValue.equals(""))
				autoUWFlag = FValue.trim();
			else
				autoUWFlag = null;
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("upReportContent"))
			if (FValue != null && !FValue.equals(""))
				upReportContent = FValue.trim();
			else
				upReportContent = null;
		if (FCode.equalsIgnoreCase("healthFlag"))
			if (FValue != null && !FValue.equals(""))
				healthFlag = FValue.trim();
			else
				healthFlag = null;
		if (FCode.equalsIgnoreCase("quesFlag"))
			if (FValue != null && !FValue.equals(""))
				quesFlag = FValue.trim();
			else
				quesFlag = null;
		if (FCode.equalsIgnoreCase("specFlag"))
			if (FValue != null && !FValue.equals(""))
				specFlag = FValue.trim();
			else
				specFlag = null;
		if (FCode.equalsIgnoreCase("addPremFlag"))
			if (FValue != null && !FValue.equals(""))
				addPremFlag = FValue.trim();
			else
				addPremFlag = null;
		if (FCode.equalsIgnoreCase("addPremReason"))
			if (FValue != null && !FValue.equals(""))
				addPremReason = FValue.trim();
			else
				addPremReason = null;
		if (FCode.equalsIgnoreCase("reportFlag"))
			if (FValue != null && !FValue.equals(""))
				reportFlag = FValue.trim();
			else
				reportFlag = null;
		if (FCode.equalsIgnoreCase("specReason"))
			if (FValue != null && !FValue.equals(""))
				specReason = FValue.trim();
			else
				specReason = null;
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
		LNPIndUWMasterSchema other = (LNPIndUWMasterSchema)otherObject;
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
		if (uWNo != other.getUWNo())
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (insuredId == null && other.getInsuredId() != null)
			return false;
		if (insuredId != null && !insuredId.equals(other.getInsuredId()))
			return false;
		if (insuredNo == null && other.getInsuredNo() != null)
			return false;
		if (insuredNo != null && !insuredNo.equals(other.getInsuredNo()))
			return false;
		if (insuredName == null && other.getInsuredName() != null)
			return false;
		if (insuredName != null && !insuredName.equals(other.getInsuredName()))
			return false;
		if (flagCaseDcl == null && other.getFlagCaseDcl() != null)
			return false;
		if (flagCaseDcl != null && !flagCaseDcl.equals(other.getFlagCaseDcl()))
			return false;
		if (highFaceAmount == null && other.getHighFaceAmount() != null)
			return false;
		if (highFaceAmount != null && !highFaceAmount.equals(other.getHighFaceAmount()))
			return false;
		if (uWMessages == null && other.getUWMessages() != null)
			return false;
		if (uWMessages != null && !uWMessages.equals(other.getUWMessages()))
			return false;
		if (appntId == null && other.getAppntId() != null)
			return false;
		if (appntId != null && !appntId.equals(other.getAppntId()))
			return false;
		if (appntNo == null && other.getAppntNo() != null)
			return false;
		if (appntNo != null && !appntNo.equals(other.getAppntNo()))
			return false;
		if (appntName == null && other.getAppntName() != null)
			return false;
		if (appntName != null && !appntName.equals(other.getAppntName()))
			return false;
		if (passFlag == null && other.getPassFlag() != null)
			return false;
		if (passFlag != null && !passFlag.equals(other.getPassFlag()))
			return false;
		if (uWIdea == null && other.getUWIdea() != null)
			return false;
		if (uWIdea != null && !uWIdea.equals(other.getUWIdea()))
			return false;
		if (uWGrade == null && other.getUWGrade() != null)
			return false;
		if (uWGrade != null && !uWGrade.equals(other.getUWGrade()))
			return false;
		if (appGrade == null && other.getAppGrade() != null)
			return false;
		if (appGrade != null && !appGrade.equals(other.getAppGrade()))
			return false;
		if (postponeDay == null && other.getPostponeDay() != null)
			return false;
		if (postponeDay != null && !postponeDay.equals(other.getPostponeDay()))
			return false;
		if (postponeDate == null && other.getPostponeDate() != null)
			return false;
		if (postponeDate != null && !fDate.getString(postponeDate).equals(other.getPostponeDate()))
			return false;
		if (autoUWFlag == null && other.getAutoUWFlag() != null)
			return false;
		if (autoUWFlag != null && !autoUWFlag.equals(other.getAutoUWFlag()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (upReportContent == null && other.getUpReportContent() != null)
			return false;
		if (upReportContent != null && !upReportContent.equals(other.getUpReportContent()))
			return false;
		if (healthFlag == null && other.getHealthFlag() != null)
			return false;
		if (healthFlag != null && !healthFlag.equals(other.getHealthFlag()))
			return false;
		if (quesFlag == null && other.getQuesFlag() != null)
			return false;
		if (quesFlag != null && !quesFlag.equals(other.getQuesFlag()))
			return false;
		if (specFlag == null && other.getSpecFlag() != null)
			return false;
		if (specFlag != null && !specFlag.equals(other.getSpecFlag()))
			return false;
		if (addPremFlag == null && other.getAddPremFlag() != null)
			return false;
		if (addPremFlag != null && !addPremFlag.equals(other.getAddPremFlag()))
			return false;
		if (addPremReason == null && other.getAddPremReason() != null)
			return false;
		if (addPremReason != null && !addPremReason.equals(other.getAddPremReason()))
			return false;
		if (reportFlag == null && other.getReportFlag() != null)
			return false;
		if (reportFlag != null && !reportFlag.equals(other.getReportFlag()))
			return false;
		if (specReason == null && other.getSpecReason() != null)
			return false;
		if (specReason != null && !specReason.equals(other.getSpecReason()))
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
		return 35;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 1;
		if (strFieldName.equals("proposalContNo"))
			return 2;
		if (strFieldName.equals("uWNo"))
			return 3;
		if (strFieldName.equals("manageCom"))
			return 4;
		if (strFieldName.equals("insuredId"))
			return 5;
		if (strFieldName.equals("insuredNo"))
			return 6;
		if (strFieldName.equals("insuredName"))
			return 7;
		if (strFieldName.equals("flagCaseDcl"))
			return 8;
		if (strFieldName.equals("highFaceAmount"))
			return 9;
		if (strFieldName.equals("uWMessages"))
			return 10;
		if (strFieldName.equals("appntId"))
			return 11;
		if (strFieldName.equals("appntNo"))
			return 12;
		if (strFieldName.equals("appntName"))
			return 13;
		if (strFieldName.equals("passFlag"))
			return 14;
		if (strFieldName.equals("uWIdea"))
			return 15;
		if (strFieldName.equals("uWGrade"))
			return 16;
		if (strFieldName.equals("appGrade"))
			return 17;
		if (strFieldName.equals("postponeDay"))
			return 18;
		if (strFieldName.equals("postponeDate"))
			return 19;
		if (strFieldName.equals("autoUWFlag"))
			return 20;
		if (strFieldName.equals("state"))
			return 21;
		if (strFieldName.equals("upReportContent"))
			return 22;
		if (strFieldName.equals("healthFlag"))
			return 23;
		if (strFieldName.equals("quesFlag"))
			return 24;
		if (strFieldName.equals("specFlag"))
			return 25;
		if (strFieldName.equals("addPremFlag"))
			return 26;
		if (strFieldName.equals("addPremReason"))
			return 27;
		if (strFieldName.equals("reportFlag"))
			return 28;
		if (strFieldName.equals("specReason"))
			return 29;
		if (strFieldName.equals("operator"))
			return 30;
		if (strFieldName.equals("makeDate"))
			return 31;
		if (strFieldName.equals("makeTime"))
			return 32;
		if (strFieldName.equals("modifyDate"))
			return 33;
		return !strFieldName.equals("modifyTime") ? -1 : 34;
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
			strFieldName = "uWNo";
			break;

		case 4: // '\004'
			strFieldName = "manageCom";
			break;

		case 5: // '\005'
			strFieldName = "insuredId";
			break;

		case 6: // '\006'
			strFieldName = "insuredNo";
			break;

		case 7: // '\007'
			strFieldName = "insuredName";
			break;

		case 8: // '\b'
			strFieldName = "flagCaseDcl";
			break;

		case 9: // '\t'
			strFieldName = "highFaceAmount";
			break;

		case 10: // '\n'
			strFieldName = "uWMessages";
			break;

		case 11: // '\013'
			strFieldName = "appntId";
			break;

		case 12: // '\f'
			strFieldName = "appntNo";
			break;

		case 13: // '\r'
			strFieldName = "appntName";
			break;

		case 14: // '\016'
			strFieldName = "passFlag";
			break;

		case 15: // '\017'
			strFieldName = "uWIdea";
			break;

		case 16: // '\020'
			strFieldName = "uWGrade";
			break;

		case 17: // '\021'
			strFieldName = "appGrade";
			break;

		case 18: // '\022'
			strFieldName = "postponeDay";
			break;

		case 19: // '\023'
			strFieldName = "postponeDate";
			break;

		case 20: // '\024'
			strFieldName = "autoUWFlag";
			break;

		case 21: // '\025'
			strFieldName = "state";
			break;

		case 22: // '\026'
			strFieldName = "upReportContent";
			break;

		case 23: // '\027'
			strFieldName = "healthFlag";
			break;

		case 24: // '\030'
			strFieldName = "quesFlag";
			break;

		case 25: // '\031'
			strFieldName = "specFlag";
			break;

		case 26: // '\032'
			strFieldName = "addPremFlag";
			break;

		case 27: // '\033'
			strFieldName = "addPremReason";
			break;

		case 28: // '\034'
			strFieldName = "reportFlag";
			break;

		case 29: // '\035'
			strFieldName = "specReason";
			break;

		case 30: // '\036'
			strFieldName = "operator";
			break;

		case 31: // '\037'
			strFieldName = "makeDate";
			break;

		case 32: // ' '
			strFieldName = "makeTime";
			break;

		case 33: // '!'
			strFieldName = "modifyDate";
			break;

		case 34: // '"'
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
		if (strFieldName.equals("uWNo"))
			return 3;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("insuredId"))
			return 0;
		if (strFieldName.equals("insuredNo"))
			return 0;
		if (strFieldName.equals("insuredName"))
			return 0;
		if (strFieldName.equals("flagCaseDcl"))
			return 0;
		if (strFieldName.equals("highFaceAmount"))
			return 0;
		if (strFieldName.equals("uWMessages"))
			return 0;
		if (strFieldName.equals("appntId"))
			return 0;
		if (strFieldName.equals("appntNo"))
			return 0;
		if (strFieldName.equals("appntName"))
			return 0;
		if (strFieldName.equals("passFlag"))
			return 0;
		if (strFieldName.equals("uWIdea"))
			return 0;
		if (strFieldName.equals("uWGrade"))
			return 0;
		if (strFieldName.equals("appGrade"))
			return 0;
		if (strFieldName.equals("postponeDay"))
			return 0;
		if (strFieldName.equals("postponeDate"))
			return 1;
		if (strFieldName.equals("autoUWFlag"))
			return 0;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("upReportContent"))
			return 0;
		if (strFieldName.equals("healthFlag"))
			return 0;
		if (strFieldName.equals("quesFlag"))
			return 0;
		if (strFieldName.equals("specFlag"))
			return 0;
		if (strFieldName.equals("addPremFlag"))
			return 0;
		if (strFieldName.equals("addPremReason"))
			return 0;
		if (strFieldName.equals("reportFlag"))
			return 0;
		if (strFieldName.equals("specReason"))
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
			nFieldType = 3;
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
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 30: // '\036'
			nFieldType = 0;
			break;

		case 31: // '\037'
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
