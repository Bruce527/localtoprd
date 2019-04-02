// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCUWMasterSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPCUWMasterDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPCUWMasterSchema
	implements Schema, Cloneable
{

	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private int uWNo;
	private String manageCom;
	private Date uWDate;
	private String uWTime;
	private String uWerName;
	private String checkStatus;
	private String appIsCompleted;
	private String appIsSubmitted;
	private String appDecision;
	private String autoUWFlag;
	private String uWMessages;
	private String uWGrade;
	private String appGrade;
	private String state;
	private String upReportContent;
	private String healthFlag;
	private String quesFlag;
	private String specFlag;
	private String addPremFlag;
	private String addPremReason;
	private String specReason;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 29;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPCUWMasterSchema()
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
		LNPCUWMasterSchema cloned = (LNPCUWMasterSchema)super.clone();
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

	public String getUWerName()
	{
		return uWerName;
	}

	public void setUWerName(String aUWerName)
	{
		uWerName = aUWerName;
	}

	public String getCheckStatus()
	{
		return checkStatus;
	}

	public void setCheckStatus(String aCheckStatus)
	{
		checkStatus = aCheckStatus;
	}

	public String getAppIsCompleted()
	{
		return appIsCompleted;
	}

	public void setAppIsCompleted(String aAppIsCompleted)
	{
		appIsCompleted = aAppIsCompleted;
	}

	public String getAppIsSubmitted()
	{
		return appIsSubmitted;
	}

	public void setAppIsSubmitted(String aAppIsSubmitted)
	{
		appIsSubmitted = aAppIsSubmitted;
	}

	public String getAppDecision()
	{
		return appDecision;
	}

	public void setAppDecision(String aAppDecision)
	{
		appDecision = aAppDecision;
	}

	public String getAutoUWFlag()
	{
		return autoUWFlag;
	}

	public void setAutoUWFlag(String aAutoUWFlag)
	{
		autoUWFlag = aAutoUWFlag;
	}

	public String getUWMessages()
	{
		return uWMessages;
	}

	public void setUWMessages(String aUWMessages)
	{
		uWMessages = aUWMessages;
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

	public void setSchema(LNPCUWMasterSchema aLNPCUWMasterSchema)
	{
		grpContNo = aLNPCUWMasterSchema.getGrpContNo();
		contNo = aLNPCUWMasterSchema.getContNo();
		proposalContNo = aLNPCUWMasterSchema.getProposalContNo();
		uWNo = aLNPCUWMasterSchema.getUWNo();
		manageCom = aLNPCUWMasterSchema.getManageCom();
		uWDate = fDate.getDate(aLNPCUWMasterSchema.getUWDate());
		uWTime = aLNPCUWMasterSchema.getUWTime();
		uWerName = aLNPCUWMasterSchema.getUWerName();
		checkStatus = aLNPCUWMasterSchema.getCheckStatus();
		appIsCompleted = aLNPCUWMasterSchema.getAppIsCompleted();
		appIsSubmitted = aLNPCUWMasterSchema.getAppIsSubmitted();
		appDecision = aLNPCUWMasterSchema.getAppDecision();
		autoUWFlag = aLNPCUWMasterSchema.getAutoUWFlag();
		uWMessages = aLNPCUWMasterSchema.getUWMessages();
		uWGrade = aLNPCUWMasterSchema.getUWGrade();
		appGrade = aLNPCUWMasterSchema.getAppGrade();
		state = aLNPCUWMasterSchema.getState();
		upReportContent = aLNPCUWMasterSchema.getUpReportContent();
		healthFlag = aLNPCUWMasterSchema.getHealthFlag();
		quesFlag = aLNPCUWMasterSchema.getQuesFlag();
		specFlag = aLNPCUWMasterSchema.getSpecFlag();
		addPremFlag = aLNPCUWMasterSchema.getAddPremFlag();
		addPremReason = aLNPCUWMasterSchema.getAddPremReason();
		specReason = aLNPCUWMasterSchema.getSpecReason();
		operator = aLNPCUWMasterSchema.getOperator();
		makeDate = fDate.getDate(aLNPCUWMasterSchema.getMakeDate());
		makeTime = aLNPCUWMasterSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPCUWMasterSchema.getModifyDate());
		modifyTime = aLNPCUWMasterSchema.getModifyTime();
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
			uWDate = rs.getDate("UWDate");
			if (rs.getString("UWTime") == null)
				uWTime = null;
			else
				uWTime = rs.getString("UWTime").trim();
			if (rs.getString("UWerName") == null)
				uWerName = null;
			else
				uWerName = rs.getString("UWerName").trim();
			if (rs.getString("CheckStatus") == null)
				checkStatus = null;
			else
				checkStatus = rs.getString("CheckStatus").trim();
			if (rs.getString("AppIsCompleted") == null)
				appIsCompleted = null;
			else
				appIsCompleted = rs.getString("AppIsCompleted").trim();
			if (rs.getString("AppIsSubmitted") == null)
				appIsSubmitted = null;
			else
				appIsSubmitted = rs.getString("AppIsSubmitted").trim();
			if (rs.getString("AppDecision") == null)
				appDecision = null;
			else
				appDecision = rs.getString("AppDecision").trim();
			if (rs.getString("AutoUWFlag") == null)
				autoUWFlag = null;
			else
				autoUWFlag = rs.getString("AutoUWFlag").trim();
			if (rs.getString("UWMessages") == null)
				uWMessages = null;
			else
				uWMessages = rs.getString("UWMessages").trim();
			if (rs.getString("UWGrade") == null)
				uWGrade = null;
			else
				uWGrade = rs.getString("UWGrade").trim();
			if (rs.getString("AppGrade") == null)
				appGrade = null;
			else
				appGrade = rs.getString("AppGrade").trim();
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
			System.out.println("数据库中的LNPCUWMaster表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPCUWMasterSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPCUWMasterSchema getSchema()
	{
		LNPCUWMasterSchema aLNPCUWMasterSchema = new LNPCUWMasterSchema();
		aLNPCUWMasterSchema.setSchema(this);
		return aLNPCUWMasterSchema;
	}

	public LNPCUWMasterDB getDB()
	{
		LNPCUWMasterDB aDBOper = new LNPCUWMasterDB();
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
		strReturn.append(StrTool.cTrim(fDate.getString(uWDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWerName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkStatus));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appIsCompleted));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appIsSubmitted));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appDecision));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(autoUWFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWMessages));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appGrade));
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
			uWDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
			uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			uWerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			checkStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			appIsCompleted = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			appIsSubmitted = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			appDecision = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			autoUWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			uWMessages = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			uWGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			appGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			upReportContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			healthFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			quesFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			addPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			addPremReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			specReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCUWMasterSchema";
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
		if (FCode.equalsIgnoreCase("uWDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
		if (FCode.equalsIgnoreCase("uWTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWTime));
		if (FCode.equalsIgnoreCase("uWerName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWerName));
		if (FCode.equalsIgnoreCase("checkStatus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkStatus));
		if (FCode.equalsIgnoreCase("appIsCompleted"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appIsCompleted));
		if (FCode.equalsIgnoreCase("appIsSubmitted"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appIsSubmitted));
		if (FCode.equalsIgnoreCase("appDecision"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appDecision));
		if (FCode.equalsIgnoreCase("autoUWFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(autoUWFlag));
		if (FCode.equalsIgnoreCase("uWMessages"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWMessages));
		if (FCode.equalsIgnoreCase("uWGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWGrade));
		if (FCode.equalsIgnoreCase("appGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appGrade));
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
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getUWDate()));
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(uWTime);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(uWerName);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(checkStatus);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(appIsCompleted);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(appIsSubmitted);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(appDecision);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(autoUWFlag);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(uWMessages);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(uWGrade);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(appGrade);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(upReportContent);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(healthFlag);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(quesFlag);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(specFlag);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(addPremFlag);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(addPremReason);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(specReason);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 28: // '\034'
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
		if (FCode.equalsIgnoreCase("uWerName"))
			if (FValue != null && !FValue.equals(""))
				uWerName = FValue.trim();
			else
				uWerName = null;
		if (FCode.equalsIgnoreCase("checkStatus"))
			if (FValue != null && !FValue.equals(""))
				checkStatus = FValue.trim();
			else
				checkStatus = null;
		if (FCode.equalsIgnoreCase("appIsCompleted"))
			if (FValue != null && !FValue.equals(""))
				appIsCompleted = FValue.trim();
			else
				appIsCompleted = null;
		if (FCode.equalsIgnoreCase("appIsSubmitted"))
			if (FValue != null && !FValue.equals(""))
				appIsSubmitted = FValue.trim();
			else
				appIsSubmitted = null;
		if (FCode.equalsIgnoreCase("appDecision"))
			if (FValue != null && !FValue.equals(""))
				appDecision = FValue.trim();
			else
				appDecision = null;
		if (FCode.equalsIgnoreCase("autoUWFlag"))
			if (FValue != null && !FValue.equals(""))
				autoUWFlag = FValue.trim();
			else
				autoUWFlag = null;
		if (FCode.equalsIgnoreCase("uWMessages"))
			if (FValue != null && !FValue.equals(""))
				uWMessages = FValue.trim();
			else
				uWMessages = null;
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
		LNPCUWMasterSchema other = (LNPCUWMasterSchema)otherObject;
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
		if (uWDate == null && other.getUWDate() != null)
			return false;
		if (uWDate != null && !fDate.getString(uWDate).equals(other.getUWDate()))
			return false;
		if (uWTime == null && other.getUWTime() != null)
			return false;
		if (uWTime != null && !uWTime.equals(other.getUWTime()))
			return false;
		if (uWerName == null && other.getUWerName() != null)
			return false;
		if (uWerName != null && !uWerName.equals(other.getUWerName()))
			return false;
		if (checkStatus == null && other.getCheckStatus() != null)
			return false;
		if (checkStatus != null && !checkStatus.equals(other.getCheckStatus()))
			return false;
		if (appIsCompleted == null && other.getAppIsCompleted() != null)
			return false;
		if (appIsCompleted != null && !appIsCompleted.equals(other.getAppIsCompleted()))
			return false;
		if (appIsSubmitted == null && other.getAppIsSubmitted() != null)
			return false;
		if (appIsSubmitted != null && !appIsSubmitted.equals(other.getAppIsSubmitted()))
			return false;
		if (appDecision == null && other.getAppDecision() != null)
			return false;
		if (appDecision != null && !appDecision.equals(other.getAppDecision()))
			return false;
		if (autoUWFlag == null && other.getAutoUWFlag() != null)
			return false;
		if (autoUWFlag != null && !autoUWFlag.equals(other.getAutoUWFlag()))
			return false;
		if (uWMessages == null && other.getUWMessages() != null)
			return false;
		if (uWMessages != null && !uWMessages.equals(other.getUWMessages()))
			return false;
		if (uWGrade == null && other.getUWGrade() != null)
			return false;
		if (uWGrade != null && !uWGrade.equals(other.getUWGrade()))
			return false;
		if (appGrade == null && other.getAppGrade() != null)
			return false;
		if (appGrade != null && !appGrade.equals(other.getAppGrade()))
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
		return 29;
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
		if (strFieldName.equals("uWDate"))
			return 5;
		if (strFieldName.equals("uWTime"))
			return 6;
		if (strFieldName.equals("uWerName"))
			return 7;
		if (strFieldName.equals("checkStatus"))
			return 8;
		if (strFieldName.equals("appIsCompleted"))
			return 9;
		if (strFieldName.equals("appIsSubmitted"))
			return 10;
		if (strFieldName.equals("appDecision"))
			return 11;
		if (strFieldName.equals("autoUWFlag"))
			return 12;
		if (strFieldName.equals("uWMessages"))
			return 13;
		if (strFieldName.equals("uWGrade"))
			return 14;
		if (strFieldName.equals("appGrade"))
			return 15;
		if (strFieldName.equals("state"))
			return 16;
		if (strFieldName.equals("upReportContent"))
			return 17;
		if (strFieldName.equals("healthFlag"))
			return 18;
		if (strFieldName.equals("quesFlag"))
			return 19;
		if (strFieldName.equals("specFlag"))
			return 20;
		if (strFieldName.equals("addPremFlag"))
			return 21;
		if (strFieldName.equals("addPremReason"))
			return 22;
		if (strFieldName.equals("specReason"))
			return 23;
		if (strFieldName.equals("operator"))
			return 24;
		if (strFieldName.equals("makeDate"))
			return 25;
		if (strFieldName.equals("makeTime"))
			return 26;
		if (strFieldName.equals("modifyDate"))
			return 27;
		return !strFieldName.equals("modifyTime") ? -1 : 28;
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
			strFieldName = "uWDate";
			break;

		case 6: // '\006'
			strFieldName = "uWTime";
			break;

		case 7: // '\007'
			strFieldName = "uWerName";
			break;

		case 8: // '\b'
			strFieldName = "checkStatus";
			break;

		case 9: // '\t'
			strFieldName = "appIsCompleted";
			break;

		case 10: // '\n'
			strFieldName = "appIsSubmitted";
			break;

		case 11: // '\013'
			strFieldName = "appDecision";
			break;

		case 12: // '\f'
			strFieldName = "autoUWFlag";
			break;

		case 13: // '\r'
			strFieldName = "uWMessages";
			break;

		case 14: // '\016'
			strFieldName = "uWGrade";
			break;

		case 15: // '\017'
			strFieldName = "appGrade";
			break;

		case 16: // '\020'
			strFieldName = "state";
			break;

		case 17: // '\021'
			strFieldName = "upReportContent";
			break;

		case 18: // '\022'
			strFieldName = "healthFlag";
			break;

		case 19: // '\023'
			strFieldName = "quesFlag";
			break;

		case 20: // '\024'
			strFieldName = "specFlag";
			break;

		case 21: // '\025'
			strFieldName = "addPremFlag";
			break;

		case 22: // '\026'
			strFieldName = "addPremReason";
			break;

		case 23: // '\027'
			strFieldName = "specReason";
			break;

		case 24: // '\030'
			strFieldName = "operator";
			break;

		case 25: // '\031'
			strFieldName = "makeDate";
			break;

		case 26: // '\032'
			strFieldName = "makeTime";
			break;

		case 27: // '\033'
			strFieldName = "modifyDate";
			break;

		case 28: // '\034'
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
		if (strFieldName.equals("uWDate"))
			return 1;
		if (strFieldName.equals("uWTime"))
			return 0;
		if (strFieldName.equals("uWerName"))
			return 0;
		if (strFieldName.equals("checkStatus"))
			return 0;
		if (strFieldName.equals("appIsCompleted"))
			return 0;
		if (strFieldName.equals("appIsSubmitted"))
			return 0;
		if (strFieldName.equals("appDecision"))
			return 0;
		if (strFieldName.equals("autoUWFlag"))
			return 0;
		if (strFieldName.equals("uWMessages"))
			return 0;
		if (strFieldName.equals("uWGrade"))
			return 0;
		if (strFieldName.equals("appGrade"))
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
			nFieldType = 1;
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
			nFieldType = 1;
			break;

		case 26: // '\032'
			nFieldType = 0;
			break;

		case 27: // '\033'
			nFieldType = 1;
			break;

		case 28: // '\034'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
