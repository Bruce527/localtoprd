// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCUWMasterBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPCUWMasterBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPCUWMasterBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
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
	public static final int FIELDNUM = 31;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPCUWMasterBSchema()
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

	public int getuWNo()
	{
		return uWNo;
	}

	public void setuWNo(int auWNo)
	{
		uWNo = auWNo;
	}

	public void setuWNo(String auWNo)
	{
		if (auWNo != null && !auWNo.equals(""))
		{
			Integer tInteger = new Integer(auWNo);
			int i = tInteger.intValue();
			uWNo = i;
		}
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

	public String getuWerName()
	{
		if (uWerName != null)
			uWerName.equals("");
		return uWerName;
	}

	public void setuWerName(String auWerName)
	{
		uWerName = auWerName;
	}

	public String getcheckStatus()
	{
		if (checkStatus != null)
			checkStatus.equals("");
		return checkStatus;
	}

	public void setcheckStatus(String acheckStatus)
	{
		checkStatus = acheckStatus;
	}

	public String getappIsCompleted()
	{
		if (appIsCompleted != null)
			appIsCompleted.equals("");
		return appIsCompleted;
	}

	public void setappIsCompleted(String aappIsCompleted)
	{
		appIsCompleted = aappIsCompleted;
	}

	public String getappIsSubmitted()
	{
		if (appIsSubmitted != null)
			appIsSubmitted.equals("");
		return appIsSubmitted;
	}

	public void setappIsSubmitted(String aappIsSubmitted)
	{
		appIsSubmitted = aappIsSubmitted;
	}

	public String getappDecision()
	{
		if (appDecision != null)
			appDecision.equals("");
		return appDecision;
	}

	public void setappDecision(String aappDecision)
	{
		appDecision = aappDecision;
	}

	public String getautoUWFlag()
	{
		if (autoUWFlag != null)
			autoUWFlag.equals("");
		return autoUWFlag;
	}

	public void setautoUWFlag(String aautoUWFlag)
	{
		autoUWFlag = aautoUWFlag;
	}

	public String getuWMessages()
	{
		if (uWMessages != null)
			uWMessages.equals("");
		return uWMessages;
	}

	public void setuWMessages(String auWMessages)
	{
		uWMessages = auWMessages;
	}

	public String getuWGrade()
	{
		if (uWGrade != null)
			uWGrade.equals("");
		return uWGrade;
	}

	public void setuWGrade(String auWGrade)
	{
		uWGrade = auWGrade;
	}

	public String getappGrade()
	{
		if (appGrade != null)
			appGrade.equals("");
		return appGrade;
	}

	public void setappGrade(String aappGrade)
	{
		appGrade = aappGrade;
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

	public String getupReportContent()
	{
		if (upReportContent != null)
			upReportContent.equals("");
		return upReportContent;
	}

	public void setupReportContent(String aupReportContent)
	{
		upReportContent = aupReportContent;
	}

	public String gethealthFlag()
	{
		if (healthFlag != null)
			healthFlag.equals("");
		return healthFlag;
	}

	public void sethealthFlag(String ahealthFlag)
	{
		healthFlag = ahealthFlag;
	}

	public String getquesFlag()
	{
		if (quesFlag != null)
			quesFlag.equals("");
		return quesFlag;
	}

	public void setquesFlag(String aquesFlag)
	{
		quesFlag = aquesFlag;
	}

	public String getspecFlag()
	{
		if (specFlag != null)
			specFlag.equals("");
		return specFlag;
	}

	public void setspecFlag(String aspecFlag)
	{
		specFlag = aspecFlag;
	}

	public String getaddPremFlag()
	{
		if (addPremFlag != null)
			addPremFlag.equals("");
		return addPremFlag;
	}

	public void setaddPremFlag(String aaddPremFlag)
	{
		addPremFlag = aaddPremFlag;
	}

	public String getaddPremReason()
	{
		if (addPremReason != null)
			addPremReason.equals("");
		return addPremReason;
	}

	public void setaddPremReason(String aaddPremReason)
	{
		addPremReason = aaddPremReason;
	}

	public String getspecReason()
	{
		if (specReason != null)
			specReason.equals("");
		return specReason;
	}

	public void setspecReason(String aspecReason)
	{
		specReason = aspecReason;
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

	public void setSchema(LNPCUWMasterBSchema aLNPCUWMasterBSchema)
	{
		EdorNo = aLNPCUWMasterBSchema.getEdorNo();
		serialNo = aLNPCUWMasterBSchema.getserialNo();
		grpContNo = aLNPCUWMasterBSchema.getgrpContNo();
		contNo = aLNPCUWMasterBSchema.getcontNo();
		proposalContNo = aLNPCUWMasterBSchema.getproposalContNo();
		uWNo = aLNPCUWMasterBSchema.getuWNo();
		manageCom = aLNPCUWMasterBSchema.getmanageCom();
		uWDate = fDate.getDate(aLNPCUWMasterBSchema.getuWDate());
		uWTime = aLNPCUWMasterBSchema.getuWTime();
		uWerName = aLNPCUWMasterBSchema.getuWerName();
		checkStatus = aLNPCUWMasterBSchema.getcheckStatus();
		appIsCompleted = aLNPCUWMasterBSchema.getappIsCompleted();
		appIsSubmitted = aLNPCUWMasterBSchema.getappIsSubmitted();
		appDecision = aLNPCUWMasterBSchema.getappDecision();
		autoUWFlag = aLNPCUWMasterBSchema.getautoUWFlag();
		uWMessages = aLNPCUWMasterBSchema.getuWMessages();
		uWGrade = aLNPCUWMasterBSchema.getuWGrade();
		appGrade = aLNPCUWMasterBSchema.getappGrade();
		state = aLNPCUWMasterBSchema.getstate();
		upReportContent = aLNPCUWMasterBSchema.getupReportContent();
		healthFlag = aLNPCUWMasterBSchema.gethealthFlag();
		quesFlag = aLNPCUWMasterBSchema.getquesFlag();
		specFlag = aLNPCUWMasterBSchema.getspecFlag();
		addPremFlag = aLNPCUWMasterBSchema.getaddPremFlag();
		addPremReason = aLNPCUWMasterBSchema.getaddPremReason();
		specReason = aLNPCUWMasterBSchema.getspecReason();
		operator = aLNPCUWMasterBSchema.getoperator();
		makeDate = fDate.getDate(aLNPCUWMasterBSchema.getmakeDate());
		makeTime = aLNPCUWMasterBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPCUWMasterBSchema.getmodifyDate());
		modifyTime = aLNPCUWMasterBSchema.getmodifyTime();
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
			uWNo = rs.getInt("uWNo");
			if (rs.getString("manageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("manageCom").trim();
			uWDate = rs.getDate("uWDate");
			if (rs.getString("uWTime") == null)
				uWTime = null;
			else
				uWTime = rs.getString("uWTime").trim();
			if (rs.getString("uWerName") == null)
				uWerName = null;
			else
				uWerName = rs.getString("uWerName").trim();
			if (rs.getString("checkStatus") == null)
				checkStatus = null;
			else
				checkStatus = rs.getString("checkStatus").trim();
			if (rs.getString("appIsCompleted") == null)
				appIsCompleted = null;
			else
				appIsCompleted = rs.getString("appIsCompleted").trim();
			if (rs.getString("appIsSubmitted") == null)
				appIsSubmitted = null;
			else
				appIsSubmitted = rs.getString("appIsSubmitted").trim();
			if (rs.getString("appDecision") == null)
				appDecision = null;
			else
				appDecision = rs.getString("appDecision").trim();
			if (rs.getString("autoUWFlag") == null)
				autoUWFlag = null;
			else
				autoUWFlag = rs.getString("autoUWFlag").trim();
			if (rs.getString("uWMessages") == null)
				uWMessages = null;
			else
				uWMessages = rs.getString("uWMessages").trim();
			if (rs.getString("uWGrade") == null)
				uWGrade = null;
			else
				uWGrade = rs.getString("uWGrade").trim();
			if (rs.getString("appGrade") == null)
				appGrade = null;
			else
				appGrade = rs.getString("appGrade").trim();
			if (rs.getString("state") == null)
				state = null;
			else
				state = rs.getString("state").trim();
			if (rs.getString("upReportContent") == null)
				upReportContent = null;
			else
				upReportContent = rs.getString("upReportContent").trim();
			if (rs.getString("healthFlag") == null)
				healthFlag = null;
			else
				healthFlag = rs.getString("healthFlag").trim();
			if (rs.getString("quesFlag") == null)
				quesFlag = null;
			else
				quesFlag = rs.getString("quesFlag").trim();
			if (rs.getString("specFlag") == null)
				specFlag = null;
			else
				specFlag = rs.getString("specFlag").trim();
			if (rs.getString("addPremFlag") == null)
				addPremFlag = null;
			else
				addPremFlag = rs.getString("addPremFlag").trim();
			if (rs.getString("addPremReason") == null)
				addPremReason = null;
			else
				addPremReason = rs.getString("addPremReason").trim();
			if (rs.getString("specReason") == null)
				specReason = null;
			else
				specReason = rs.getString("specReason").trim();
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
			tError.moduleName = "LNPCUWMasterBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPCUWMasterBSchema getSchema()
	{
		LNPCUWMasterBSchema aLNPCUWMasterBSchema = new LNPCUWMasterBSchema();
		aLNPCUWMasterBSchema.setSchema(this);
		return aLNPCUWMasterBSchema;
	}

	public LNPCUWMasterBDB getDB()
	{
		LNPCUWMasterBDB aDBOper = new LNPCUWMasterBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proposalContNo))).append("|").append(ChgData.chgData(uWNo)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(manageCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(uWDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWerName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(checkStatus))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appIsCompleted))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appIsSubmitted))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appDecision))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(autoUWFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWMessages))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(uWGrade))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appGrade))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(state))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(upReportContent))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(healthFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(quesFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(specFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(addPremFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(addPremReason))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(specReason))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).toString();
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
			uWNo = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).intValue();
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			uWDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			uWTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			uWerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			checkStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			appIsCompleted = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			appIsSubmitted = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			appDecision = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			autoUWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			uWMessages = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			uWGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			appGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			upReportContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			healthFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			quesFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			addPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			addPremReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			specReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCUWMasterBSchema";
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
		if (FCode.equals("uWNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWNo));
		if (FCode.equals("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equals("uWDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
		if (FCode.equals("uWTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWTime));
		if (FCode.equals("uWerName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWerName));
		if (FCode.equals("checkStatus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkStatus));
		if (FCode.equals("appIsCompleted"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appIsCompleted));
		if (FCode.equals("appIsSubmitted"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appIsSubmitted));
		if (FCode.equals("appDecision"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appDecision));
		if (FCode.equals("autoUWFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(autoUWFlag));
		if (FCode.equals("uWMessages"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWMessages));
		if (FCode.equals("uWGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWGrade));
		if (FCode.equals("appGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appGrade));
		if (FCode.equals("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equals("upReportContent"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(upReportContent));
		if (FCode.equals("healthFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(healthFlag));
		if (FCode.equals("quesFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(quesFlag));
		if (FCode.equals("specFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(specFlag));
		if (FCode.equals("addPremFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addPremFlag));
		if (FCode.equals("addPremReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addPremReason));
		if (FCode.equals("specReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(specReason));
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
			strFieldValue = String.valueOf(uWNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getuWDate()));
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(uWTime);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(uWerName);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(checkStatus);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(appIsCompleted);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(appIsSubmitted);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(appDecision);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(autoUWFlag);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(uWMessages);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(uWGrade);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(appGrade);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(upReportContent);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(healthFlag);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(quesFlag);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(specFlag);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(addPremFlag);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(addPremReason);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(specReason);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
			break;

		case 30: // '\036'
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
		if (FCode.equals("uWNo") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			uWNo = i;
		}
		if (FCode.equals("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
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
		if (FCode.equals("uWerName"))
			if (FValue != null && !FValue.equals(""))
				uWerName = FValue.trim();
			else
				uWerName = null;
		if (FCode.equals("checkStatus"))
			if (FValue != null && !FValue.equals(""))
				checkStatus = FValue.trim();
			else
				checkStatus = null;
		if (FCode.equals("appIsCompleted"))
			if (FValue != null && !FValue.equals(""))
				appIsCompleted = FValue.trim();
			else
				appIsCompleted = null;
		if (FCode.equals("appIsSubmitted"))
			if (FValue != null && !FValue.equals(""))
				appIsSubmitted = FValue.trim();
			else
				appIsSubmitted = null;
		if (FCode.equals("appDecision"))
			if (FValue != null && !FValue.equals(""))
				appDecision = FValue.trim();
			else
				appDecision = null;
		if (FCode.equals("autoUWFlag"))
			if (FValue != null && !FValue.equals(""))
				autoUWFlag = FValue.trim();
			else
				autoUWFlag = null;
		if (FCode.equals("uWMessages"))
			if (FValue != null && !FValue.equals(""))
				uWMessages = FValue.trim();
			else
				uWMessages = null;
		if (FCode.equals("uWGrade"))
			if (FValue != null && !FValue.equals(""))
				uWGrade = FValue.trim();
			else
				uWGrade = null;
		if (FCode.equals("appGrade"))
			if (FValue != null && !FValue.equals(""))
				appGrade = FValue.trim();
			else
				appGrade = null;
		if (FCode.equals("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equals("upReportContent"))
			if (FValue != null && !FValue.equals(""))
				upReportContent = FValue.trim();
			else
				upReportContent = null;
		if (FCode.equals("healthFlag"))
			if (FValue != null && !FValue.equals(""))
				healthFlag = FValue.trim();
			else
				healthFlag = null;
		if (FCode.equals("quesFlag"))
			if (FValue != null && !FValue.equals(""))
				quesFlag = FValue.trim();
			else
				quesFlag = null;
		if (FCode.equals("specFlag"))
			if (FValue != null && !FValue.equals(""))
				specFlag = FValue.trim();
			else
				specFlag = null;
		if (FCode.equals("addPremFlag"))
			if (FValue != null && !FValue.equals(""))
				addPremFlag = FValue.trim();
			else
				addPremFlag = null;
		if (FCode.equals("addPremReason"))
			if (FValue != null && !FValue.equals(""))
				addPremReason = FValue.trim();
			else
				addPremReason = null;
		if (FCode.equals("specReason"))
			if (FValue != null && !FValue.equals(""))
				specReason = FValue.trim();
			else
				specReason = null;
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
		LNPCUWMasterBSchema other = (LNPCUWMasterBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && grpContNo.equals(other.getgrpContNo()) && contNo.equals(other.getcontNo()) && proposalContNo.equals(other.getproposalContNo()) && uWNo == other.getuWNo() && manageCom.equals(other.getmanageCom()) && fDate.getString(uWDate).equals(other.getuWDate()) && uWTime.equals(other.getuWTime()) && uWerName.equals(other.getuWerName()) && checkStatus.equals(other.getcheckStatus()) && appIsCompleted.equals(other.getappIsCompleted()) && appIsSubmitted.equals(other.getappIsSubmitted()) && appDecision.equals(other.getappDecision()) && autoUWFlag.equals(other.getautoUWFlag()) && uWMessages.equals(other.getuWMessages()) && uWGrade.equals(other.getuWGrade()) && appGrade.equals(other.getappGrade()) && state.equals(other.getstate()) && upReportContent.equals(other.getupReportContent()) && healthFlag.equals(other.gethealthFlag()) && quesFlag.equals(other.getquesFlag()) && specFlag.equals(other.getspecFlag()) && addPremFlag.equals(other.getaddPremFlag()) && addPremReason.equals(other.getaddPremReason()) && specReason.equals(other.getspecReason()) && operator.equals(other.getoperator()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime());
	}

	public int getFieldCount()
	{
		return 31;
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
		if (strFieldName.equals("uWNo"))
			return 5;
		if (strFieldName.equals("manageCom"))
			return 6;
		if (strFieldName.equals("uWDate"))
			return 7;
		if (strFieldName.equals("uWTime"))
			return 8;
		if (strFieldName.equals("uWerName"))
			return 9;
		if (strFieldName.equals("checkStatus"))
			return 10;
		if (strFieldName.equals("appIsCompleted"))
			return 11;
		if (strFieldName.equals("appIsSubmitted"))
			return 12;
		if (strFieldName.equals("appDecision"))
			return 13;
		if (strFieldName.equals("autoUWFlag"))
			return 14;
		if (strFieldName.equals("uWMessages"))
			return 15;
		if (strFieldName.equals("uWGrade"))
			return 16;
		if (strFieldName.equals("appGrade"))
			return 17;
		if (strFieldName.equals("state"))
			return 18;
		if (strFieldName.equals("upReportContent"))
			return 19;
		if (strFieldName.equals("healthFlag"))
			return 20;
		if (strFieldName.equals("quesFlag"))
			return 21;
		if (strFieldName.equals("specFlag"))
			return 22;
		if (strFieldName.equals("addPremFlag"))
			return 23;
		if (strFieldName.equals("addPremReason"))
			return 24;
		if (strFieldName.equals("specReason"))
			return 25;
		if (strFieldName.equals("operator"))
			return 26;
		if (strFieldName.equals("makeDate"))
			return 27;
		if (strFieldName.equals("makeTime"))
			return 28;
		if (strFieldName.equals("modifyDate"))
			return 29;
		return !strFieldName.equals("modifyTime") ? -1 : 30;
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
			strFieldName = "uWNo";
			break;

		case 6: // '\006'
			strFieldName = "manageCom";
			break;

		case 7: // '\007'
			strFieldName = "uWDate";
			break;

		case 8: // '\b'
			strFieldName = "uWTime";
			break;

		case 9: // '\t'
			strFieldName = "uWerName";
			break;

		case 10: // '\n'
			strFieldName = "checkStatus";
			break;

		case 11: // '\013'
			strFieldName = "appIsCompleted";
			break;

		case 12: // '\f'
			strFieldName = "appIsSubmitted";
			break;

		case 13: // '\r'
			strFieldName = "appDecision";
			break;

		case 14: // '\016'
			strFieldName = "autoUWFlag";
			break;

		case 15: // '\017'
			strFieldName = "uWMessages";
			break;

		case 16: // '\020'
			strFieldName = "uWGrade";
			break;

		case 17: // '\021'
			strFieldName = "appGrade";
			break;

		case 18: // '\022'
			strFieldName = "state";
			break;

		case 19: // '\023'
			strFieldName = "upReportContent";
			break;

		case 20: // '\024'
			strFieldName = "healthFlag";
			break;

		case 21: // '\025'
			strFieldName = "quesFlag";
			break;

		case 22: // '\026'
			strFieldName = "specFlag";
			break;

		case 23: // '\027'
			strFieldName = "addPremFlag";
			break;

		case 24: // '\030'
			strFieldName = "addPremReason";
			break;

		case 25: // '\031'
			strFieldName = "specReason";
			break;

		case 26: // '\032'
			strFieldName = "operator";
			break;

		case 27: // '\033'
			strFieldName = "makeDate";
			break;

		case 28: // '\034'
			strFieldName = "makeTime";
			break;

		case 29: // '\035'
			strFieldName = "modifyDate";
			break;

		case 30: // '\036'
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
			nFieldType = 0;
			break;

		case 4: // '\004'
			nFieldType = 0;
			break;

		case 5: // '\005'
			nFieldType = 3;
			break;

		case 6: // '\006'
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 29: // '\035'
			nFieldType = 1;
			break;

		case 30: // '\036'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
