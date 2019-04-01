// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPUWMasterSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPUWMasterDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPUWMasterSchema
	implements Schema, Cloneable
{

	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private String polNo;
	private String proposalNo;
	private int uWNo;
	private String insuredNo;
	private String insuredName;
	private String appntNo;
	private String appntName;
	private String planCode;
	private String planName;
	private String riderName;
	private String riderCode;
	private String uWDid;
	private String faceAmount;
	private String term;
	private String healthDeb;
	private String healthFe;
	private String healthFed;
	private String occupationFactor;
	private String occupationFe;
	private String occupationFed;
	private String exclusions;
	private String declinedCode;
	private String declinedReason;
	private String passFlag;
	private String uWIdea;
	private String uWGrade;
	private String appGrade;
	private String postponeDay;
	private Date postponeDate;
	private String autoUWFlag;
	private String state;
	private String manageCom;
	private String upReportContent;
	private String operator;
	private String healthFlag;
	private String quesFlag;
	private String specFlag;
	private String addPremFlag;
	private String addPremReason;
	private String reportFlag;
	private String printFlag;
	private String printFlag2;
	private String changePolFlag;
	private String changePolReason;
	private String specReason;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String sugPassFlag;
	private String sugUWIdea;
	public static final int FIELDNUM = 54;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPUWMasterSchema()
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
		LNPUWMasterSchema cloned = (LNPUWMasterSchema)super.clone();
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

	public String getPlanCode()
	{
		return planCode;
	}

	public void setPlanCode(String aPlanCode)
	{
		planCode = aPlanCode;
	}

	public String getPlanName()
	{
		return planName;
	}

	public void setPlanName(String aPlanName)
	{
		planName = aPlanName;
	}

	public String getRiderName()
	{
		return riderName;
	}

	public void setRiderName(String aRiderName)
	{
		riderName = aRiderName;
	}

	public String getRiderCode()
	{
		return riderCode;
	}

	public void setRiderCode(String aRiderCode)
	{
		riderCode = aRiderCode;
	}

	public String getUWDid()
	{
		return uWDid;
	}

	public void setUWDid(String aUWDid)
	{
		uWDid = aUWDid;
	}

	public String getFaceAmount()
	{
		return faceAmount;
	}

	public void setFaceAmount(String aFaceAmount)
	{
		faceAmount = aFaceAmount;
	}

	public String getTerm()
	{
		return term;
	}

	public void setTerm(String aTerm)
	{
		term = aTerm;
	}

	public String getHealthDeb()
	{
		return healthDeb;
	}

	public void setHealthDeb(String aHealthDeb)
	{
		healthDeb = aHealthDeb;
	}

	public String getHealthFe()
	{
		return healthFe;
	}

	public void setHealthFe(String aHealthFe)
	{
		healthFe = aHealthFe;
	}

	public String getHealthFed()
	{
		return healthFed;
	}

	public void setHealthFed(String aHealthFed)
	{
		healthFed = aHealthFed;
	}

	public String getOccupationFactor()
	{
		return occupationFactor;
	}

	public void setOccupationFactor(String aOccupationFactor)
	{
		occupationFactor = aOccupationFactor;
	}

	public String getOccupationFe()
	{
		return occupationFe;
	}

	public void setOccupationFe(String aOccupationFe)
	{
		occupationFe = aOccupationFe;
	}

	public String getOccupationFed()
	{
		return occupationFed;
	}

	public void setOccupationFed(String aOccupationFed)
	{
		occupationFed = aOccupationFed;
	}

	public String getExclusions()
	{
		return exclusions;
	}

	public void setExclusions(String aExclusions)
	{
		exclusions = aExclusions;
	}

	public String getDeclinedCode()
	{
		return declinedCode;
	}

	public void setDeclinedCode(String aDeclinedCode)
	{
		declinedCode = aDeclinedCode;
	}

	public String getDeclinedReason()
	{
		return declinedReason;
	}

	public void setDeclinedReason(String aDeclinedReason)
	{
		declinedReason = aDeclinedReason;
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

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getUpReportContent()
	{
		return upReportContent;
	}

	public void setUpReportContent(String aUpReportContent)
	{
		upReportContent = aUpReportContent;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
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

	public String getPrintFlag()
	{
		return printFlag;
	}

	public void setPrintFlag(String aPrintFlag)
	{
		printFlag = aPrintFlag;
	}

	public String getPrintFlag2()
	{
		return printFlag2;
	}

	public void setPrintFlag2(String aPrintFlag2)
	{
		printFlag2 = aPrintFlag2;
	}

	public String getChangePolFlag()
	{
		return changePolFlag;
	}

	public void setChangePolFlag(String aChangePolFlag)
	{
		changePolFlag = aChangePolFlag;
	}

	public String getChangePolReason()
	{
		return changePolReason;
	}

	public void setChangePolReason(String aChangePolReason)
	{
		changePolReason = aChangePolReason;
	}

	public String getSpecReason()
	{
		return specReason;
	}

	public void setSpecReason(String aSpecReason)
	{
		specReason = aSpecReason;
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

	public String getSugPassFlag()
	{
		return sugPassFlag;
	}

	public void setSugPassFlag(String aSugPassFlag)
	{
		sugPassFlag = aSugPassFlag;
	}

	public String getSugUWIdea()
	{
		return sugUWIdea;
	}

	public void setSugUWIdea(String aSugUWIdea)
	{
		sugUWIdea = aSugUWIdea;
	}

	public void setSchema(LNPUWMasterSchema aLNPUWMasterSchema)
	{
		grpContNo = aLNPUWMasterSchema.getGrpContNo();
		contNo = aLNPUWMasterSchema.getContNo();
		proposalContNo = aLNPUWMasterSchema.getProposalContNo();
		polNo = aLNPUWMasterSchema.getPolNo();
		proposalNo = aLNPUWMasterSchema.getProposalNo();
		uWNo = aLNPUWMasterSchema.getUWNo();
		insuredNo = aLNPUWMasterSchema.getInsuredNo();
		insuredName = aLNPUWMasterSchema.getInsuredName();
		appntNo = aLNPUWMasterSchema.getAppntNo();
		appntName = aLNPUWMasterSchema.getAppntName();
		planCode = aLNPUWMasterSchema.getPlanCode();
		planName = aLNPUWMasterSchema.getPlanName();
		riderName = aLNPUWMasterSchema.getRiderName();
		riderCode = aLNPUWMasterSchema.getRiderCode();
		uWDid = aLNPUWMasterSchema.getUWDid();
		faceAmount = aLNPUWMasterSchema.getFaceAmount();
		term = aLNPUWMasterSchema.getTerm();
		healthDeb = aLNPUWMasterSchema.getHealthDeb();
		healthFe = aLNPUWMasterSchema.getHealthFe();
		healthFed = aLNPUWMasterSchema.getHealthFed();
		occupationFactor = aLNPUWMasterSchema.getOccupationFactor();
		occupationFe = aLNPUWMasterSchema.getOccupationFe();
		occupationFed = aLNPUWMasterSchema.getOccupationFed();
		exclusions = aLNPUWMasterSchema.getExclusions();
		declinedCode = aLNPUWMasterSchema.getDeclinedCode();
		declinedReason = aLNPUWMasterSchema.getDeclinedReason();
		passFlag = aLNPUWMasterSchema.getPassFlag();
		uWIdea = aLNPUWMasterSchema.getUWIdea();
		uWGrade = aLNPUWMasterSchema.getUWGrade();
		appGrade = aLNPUWMasterSchema.getAppGrade();
		postponeDay = aLNPUWMasterSchema.getPostponeDay();
		postponeDate = fDate.getDate(aLNPUWMasterSchema.getPostponeDate());
		autoUWFlag = aLNPUWMasterSchema.getAutoUWFlag();
		state = aLNPUWMasterSchema.getState();
		manageCom = aLNPUWMasterSchema.getManageCom();
		upReportContent = aLNPUWMasterSchema.getUpReportContent();
		operator = aLNPUWMasterSchema.getOperator();
		healthFlag = aLNPUWMasterSchema.getHealthFlag();
		quesFlag = aLNPUWMasterSchema.getQuesFlag();
		specFlag = aLNPUWMasterSchema.getSpecFlag();
		addPremFlag = aLNPUWMasterSchema.getAddPremFlag();
		addPremReason = aLNPUWMasterSchema.getAddPremReason();
		reportFlag = aLNPUWMasterSchema.getReportFlag();
		printFlag = aLNPUWMasterSchema.getPrintFlag();
		printFlag2 = aLNPUWMasterSchema.getPrintFlag2();
		changePolFlag = aLNPUWMasterSchema.getChangePolFlag();
		changePolReason = aLNPUWMasterSchema.getChangePolReason();
		specReason = aLNPUWMasterSchema.getSpecReason();
		makeDate = fDate.getDate(aLNPUWMasterSchema.getMakeDate());
		makeTime = aLNPUWMasterSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPUWMasterSchema.getModifyDate());
		modifyTime = aLNPUWMasterSchema.getModifyTime();
		sugPassFlag = aLNPUWMasterSchema.getSugPassFlag();
		sugUWIdea = aLNPUWMasterSchema.getSugUWIdea();
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
			if (rs.getString("PolNo") == null)
				polNo = null;
			else
				polNo = rs.getString("PolNo").trim();
			if (rs.getString("ProposalNo") == null)
				proposalNo = null;
			else
				proposalNo = rs.getString("ProposalNo").trim();
			uWNo = rs.getInt("UWNo");
			if (rs.getString("InsuredNo") == null)
				insuredNo = null;
			else
				insuredNo = rs.getString("InsuredNo").trim();
			if (rs.getString("InsuredName") == null)
				insuredName = null;
			else
				insuredName = rs.getString("InsuredName").trim();
			if (rs.getString("AppntNo") == null)
				appntNo = null;
			else
				appntNo = rs.getString("AppntNo").trim();
			if (rs.getString("AppntName") == null)
				appntName = null;
			else
				appntName = rs.getString("AppntName").trim();
			if (rs.getString("PlanCode") == null)
				planCode = null;
			else
				planCode = rs.getString("PlanCode").trim();
			if (rs.getString("PlanName") == null)
				planName = null;
			else
				planName = rs.getString("PlanName").trim();
			if (rs.getString("RiderName") == null)
				riderName = null;
			else
				riderName = rs.getString("RiderName").trim();
			if (rs.getString("RiderCode") == null)
				riderCode = null;
			else
				riderCode = rs.getString("RiderCode").trim();
			if (rs.getString("UWDid") == null)
				uWDid = null;
			else
				uWDid = rs.getString("UWDid").trim();
			if (rs.getString("FaceAmount") == null)
				faceAmount = null;
			else
				faceAmount = rs.getString("FaceAmount").trim();
			if (rs.getString("Term") == null)
				term = null;
			else
				term = rs.getString("Term").trim();
			if (rs.getString("HealthDeb") == null)
				healthDeb = null;
			else
				healthDeb = rs.getString("HealthDeb").trim();
			if (rs.getString("HealthFe") == null)
				healthFe = null;
			else
				healthFe = rs.getString("HealthFe").trim();
			if (rs.getString("HealthFed") == null)
				healthFed = null;
			else
				healthFed = rs.getString("HealthFed").trim();
			if (rs.getString("OccupationFactor") == null)
				occupationFactor = null;
			else
				occupationFactor = rs.getString("OccupationFactor").trim();
			if (rs.getString("OccupationFe") == null)
				occupationFe = null;
			else
				occupationFe = rs.getString("OccupationFe").trim();
			if (rs.getString("OccupationFed") == null)
				occupationFed = null;
			else
				occupationFed = rs.getString("OccupationFed").trim();
			if (rs.getString("Exclusions") == null)
				exclusions = null;
			else
				exclusions = rs.getString("Exclusions").trim();
			if (rs.getString("DeclinedCode") == null)
				declinedCode = null;
			else
				declinedCode = rs.getString("DeclinedCode").trim();
			if (rs.getString("DeclinedReason") == null)
				declinedReason = null;
			else
				declinedReason = rs.getString("DeclinedReason").trim();
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
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("UpReportContent") == null)
				upReportContent = null;
			else
				upReportContent = rs.getString("UpReportContent").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
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
			if (rs.getString("PrintFlag") == null)
				printFlag = null;
			else
				printFlag = rs.getString("PrintFlag").trim();
			if (rs.getString("PrintFlag2") == null)
				printFlag2 = null;
			else
				printFlag2 = rs.getString("PrintFlag2").trim();
			if (rs.getString("ChangePolFlag") == null)
				changePolFlag = null;
			else
				changePolFlag = rs.getString("ChangePolFlag").trim();
			if (rs.getString("ChangePolReason") == null)
				changePolReason = null;
			else
				changePolReason = rs.getString("ChangePolReason").trim();
			if (rs.getString("SpecReason") == null)
				specReason = null;
			else
				specReason = rs.getString("SpecReason").trim();
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
			if (rs.getString("SugPassFlag") == null)
				sugPassFlag = null;
			else
				sugPassFlag = rs.getString("SugPassFlag").trim();
			if (rs.getString("SugUWIdea") == null)
				sugUWIdea = null;
			else
				sugUWIdea = rs.getString("SugUWIdea").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPUWMaster���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPUWMasterSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPUWMasterSchema getSchema()
	{
		LNPUWMasterSchema aLNPUWMasterSchema = new LNPUWMasterSchema();
		aLNPUWMasterSchema.setSchema(this);
		return aLNPUWMasterSchema;
	}

	public LNPUWMasterDB getDB()
	{
		LNPUWMasterDB aDBOper = new LNPUWMasterDB();
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
		strReturn.append(StrTool.cTrim(polNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proposalNo));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(uWNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(planCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(planName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riderName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riderCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWDid));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(faceAmount));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(term));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(healthDeb));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(healthFe));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(healthFed));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(occupationFactor));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(occupationFe));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(occupationFed));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(exclusions));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(declinedCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(declinedReason));
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
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(upReportContent));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
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
		strReturn.append(StrTool.cTrim(printFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(printFlag2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(changePolFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(changePolReason));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(specReason));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sugPassFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sugUWIdea));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			proposalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			uWNo = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).intValue();
			insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			insuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			planCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			planName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			riderName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			riderCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			uWDid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			faceAmount = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			term = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			healthDeb = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			healthFe = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			healthFed = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			occupationFactor = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			occupationFe = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			occupationFed = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			exclusions = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			declinedCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			declinedReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			passFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			uWIdea = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			uWGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			appGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			postponeDay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			postponeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|"));
			autoUWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			upReportContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			healthFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			quesFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			addPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			addPremReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			reportFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			printFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			printFlag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			changePolFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			changePolReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			specReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			sugPassFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
			sugUWIdea = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPUWMasterSchema";
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
		if (FCode.equalsIgnoreCase("polNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polNo));
		if (FCode.equalsIgnoreCase("proposalNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalNo));
		if (FCode.equalsIgnoreCase("uWNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWNo));
		if (FCode.equalsIgnoreCase("insuredNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredNo));
		if (FCode.equalsIgnoreCase("insuredName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredName));
		if (FCode.equalsIgnoreCase("appntNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntNo));
		if (FCode.equalsIgnoreCase("appntName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntName));
		if (FCode.equalsIgnoreCase("planCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(planCode));
		if (FCode.equalsIgnoreCase("planName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(planName));
		if (FCode.equalsIgnoreCase("riderName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riderName));
		if (FCode.equalsIgnoreCase("riderCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riderCode));
		if (FCode.equalsIgnoreCase("uWDid"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWDid));
		if (FCode.equalsIgnoreCase("faceAmount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(faceAmount));
		if (FCode.equalsIgnoreCase("term"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(term));
		if (FCode.equalsIgnoreCase("healthDeb"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(healthDeb));
		if (FCode.equalsIgnoreCase("healthFe"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(healthFe));
		if (FCode.equalsIgnoreCase("healthFed"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(healthFed));
		if (FCode.equalsIgnoreCase("occupationFactor"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationFactor));
		if (FCode.equalsIgnoreCase("occupationFe"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationFe));
		if (FCode.equalsIgnoreCase("occupationFed"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationFed));
		if (FCode.equalsIgnoreCase("exclusions"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(exclusions));
		if (FCode.equalsIgnoreCase("declinedCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(declinedCode));
		if (FCode.equalsIgnoreCase("declinedReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(declinedReason));
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
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("upReportContent"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(upReportContent));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
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
		if (FCode.equalsIgnoreCase("printFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(printFlag));
		if (FCode.equalsIgnoreCase("printFlag2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(printFlag2));
		if (FCode.equalsIgnoreCase("changePolFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(changePolFlag));
		if (FCode.equalsIgnoreCase("changePolReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(changePolReason));
		if (FCode.equalsIgnoreCase("specReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(specReason));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
		if (FCode.equalsIgnoreCase("sugPassFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sugPassFlag));
		if (FCode.equalsIgnoreCase("sugUWIdea"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sugUWIdea));
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
			strFieldValue = StrTool.GBKToUnicode(polNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(proposalNo);
			break;

		case 5: // '\005'
			strFieldValue = String.valueOf(uWNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(insuredNo);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(insuredName);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(appntNo);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(appntName);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(planCode);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(planName);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(riderName);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(riderCode);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(uWDid);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(faceAmount);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(term);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(healthDeb);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(healthFe);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(healthFed);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(occupationFactor);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(occupationFe);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(occupationFed);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(exclusions);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(declinedCode);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(declinedReason);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(passFlag);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(uWIdea);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(uWGrade);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(appGrade);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(postponeDay);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPostponeDate()));
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(autoUWFlag);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(upReportContent);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(healthFlag);
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(quesFlag);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(specFlag);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(addPremFlag);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(addPremReason);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(reportFlag);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(printFlag);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(printFlag2);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(changePolFlag);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(changePolReason);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(specReason);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(sugPassFlag);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(sugUWIdea);
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
		if (FCode.equalsIgnoreCase("uWNo") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			uWNo = i;
		}
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
		if (FCode.equalsIgnoreCase("planCode"))
			if (FValue != null && !FValue.equals(""))
				planCode = FValue.trim();
			else
				planCode = null;
		if (FCode.equalsIgnoreCase("planName"))
			if (FValue != null && !FValue.equals(""))
				planName = FValue.trim();
			else
				planName = null;
		if (FCode.equalsIgnoreCase("riderName"))
			if (FValue != null && !FValue.equals(""))
				riderName = FValue.trim();
			else
				riderName = null;
		if (FCode.equalsIgnoreCase("riderCode"))
			if (FValue != null && !FValue.equals(""))
				riderCode = FValue.trim();
			else
				riderCode = null;
		if (FCode.equalsIgnoreCase("uWDid"))
			if (FValue != null && !FValue.equals(""))
				uWDid = FValue.trim();
			else
				uWDid = null;
		if (FCode.equalsIgnoreCase("faceAmount"))
			if (FValue != null && !FValue.equals(""))
				faceAmount = FValue.trim();
			else
				faceAmount = null;
		if (FCode.equalsIgnoreCase("term"))
			if (FValue != null && !FValue.equals(""))
				term = FValue.trim();
			else
				term = null;
		if (FCode.equalsIgnoreCase("healthDeb"))
			if (FValue != null && !FValue.equals(""))
				healthDeb = FValue.trim();
			else
				healthDeb = null;
		if (FCode.equalsIgnoreCase("healthFe"))
			if (FValue != null && !FValue.equals(""))
				healthFe = FValue.trim();
			else
				healthFe = null;
		if (FCode.equalsIgnoreCase("healthFed"))
			if (FValue != null && !FValue.equals(""))
				healthFed = FValue.trim();
			else
				healthFed = null;
		if (FCode.equalsIgnoreCase("occupationFactor"))
			if (FValue != null && !FValue.equals(""))
				occupationFactor = FValue.trim();
			else
				occupationFactor = null;
		if (FCode.equalsIgnoreCase("occupationFe"))
			if (FValue != null && !FValue.equals(""))
				occupationFe = FValue.trim();
			else
				occupationFe = null;
		if (FCode.equalsIgnoreCase("occupationFed"))
			if (FValue != null && !FValue.equals(""))
				occupationFed = FValue.trim();
			else
				occupationFed = null;
		if (FCode.equalsIgnoreCase("exclusions"))
			if (FValue != null && !FValue.equals(""))
				exclusions = FValue.trim();
			else
				exclusions = null;
		if (FCode.equalsIgnoreCase("declinedCode"))
			if (FValue != null && !FValue.equals(""))
				declinedCode = FValue.trim();
			else
				declinedCode = null;
		if (FCode.equalsIgnoreCase("declinedReason"))
			if (FValue != null && !FValue.equals(""))
				declinedReason = FValue.trim();
			else
				declinedReason = null;
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
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("upReportContent"))
			if (FValue != null && !FValue.equals(""))
				upReportContent = FValue.trim();
			else
				upReportContent = null;
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
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
		if (FCode.equalsIgnoreCase("printFlag"))
			if (FValue != null && !FValue.equals(""))
				printFlag = FValue.trim();
			else
				printFlag = null;
		if (FCode.equalsIgnoreCase("printFlag2"))
			if (FValue != null && !FValue.equals(""))
				printFlag2 = FValue.trim();
			else
				printFlag2 = null;
		if (FCode.equalsIgnoreCase("changePolFlag"))
			if (FValue != null && !FValue.equals(""))
				changePolFlag = FValue.trim();
			else
				changePolFlag = null;
		if (FCode.equalsIgnoreCase("changePolReason"))
			if (FValue != null && !FValue.equals(""))
				changePolReason = FValue.trim();
			else
				changePolReason = null;
		if (FCode.equalsIgnoreCase("specReason"))
			if (FValue != null && !FValue.equals(""))
				specReason = FValue.trim();
			else
				specReason = null;
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
		if (FCode.equalsIgnoreCase("sugPassFlag"))
			if (FValue != null && !FValue.equals(""))
				sugPassFlag = FValue.trim();
			else
				sugPassFlag = null;
		if (FCode.equalsIgnoreCase("sugUWIdea"))
			if (FValue != null && !FValue.equals(""))
				sugUWIdea = FValue.trim();
			else
				sugUWIdea = null;
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
		LNPUWMasterSchema other = (LNPUWMasterSchema)otherObject;
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
		if (polNo == null && other.getPolNo() != null)
			return false;
		if (polNo != null && !polNo.equals(other.getPolNo()))
			return false;
		if (proposalNo == null && other.getProposalNo() != null)
			return false;
		if (proposalNo != null && !proposalNo.equals(other.getProposalNo()))
			return false;
		if (uWNo != other.getUWNo())
			return false;
		if (insuredNo == null && other.getInsuredNo() != null)
			return false;
		if (insuredNo != null && !insuredNo.equals(other.getInsuredNo()))
			return false;
		if (insuredName == null && other.getInsuredName() != null)
			return false;
		if (insuredName != null && !insuredName.equals(other.getInsuredName()))
			return false;
		if (appntNo == null && other.getAppntNo() != null)
			return false;
		if (appntNo != null && !appntNo.equals(other.getAppntNo()))
			return false;
		if (appntName == null && other.getAppntName() != null)
			return false;
		if (appntName != null && !appntName.equals(other.getAppntName()))
			return false;
		if (planCode == null && other.getPlanCode() != null)
			return false;
		if (planCode != null && !planCode.equals(other.getPlanCode()))
			return false;
		if (planName == null && other.getPlanName() != null)
			return false;
		if (planName != null && !planName.equals(other.getPlanName()))
			return false;
		if (riderName == null && other.getRiderName() != null)
			return false;
		if (riderName != null && !riderName.equals(other.getRiderName()))
			return false;
		if (riderCode == null && other.getRiderCode() != null)
			return false;
		if (riderCode != null && !riderCode.equals(other.getRiderCode()))
			return false;
		if (uWDid == null && other.getUWDid() != null)
			return false;
		if (uWDid != null && !uWDid.equals(other.getUWDid()))
			return false;
		if (faceAmount == null && other.getFaceAmount() != null)
			return false;
		if (faceAmount != null && !faceAmount.equals(other.getFaceAmount()))
			return false;
		if (term == null && other.getTerm() != null)
			return false;
		if (term != null && !term.equals(other.getTerm()))
			return false;
		if (healthDeb == null && other.getHealthDeb() != null)
			return false;
		if (healthDeb != null && !healthDeb.equals(other.getHealthDeb()))
			return false;
		if (healthFe == null && other.getHealthFe() != null)
			return false;
		if (healthFe != null && !healthFe.equals(other.getHealthFe()))
			return false;
		if (healthFed == null && other.getHealthFed() != null)
			return false;
		if (healthFed != null && !healthFed.equals(other.getHealthFed()))
			return false;
		if (occupationFactor == null && other.getOccupationFactor() != null)
			return false;
		if (occupationFactor != null && !occupationFactor.equals(other.getOccupationFactor()))
			return false;
		if (occupationFe == null && other.getOccupationFe() != null)
			return false;
		if (occupationFe != null && !occupationFe.equals(other.getOccupationFe()))
			return false;
		if (occupationFed == null && other.getOccupationFed() != null)
			return false;
		if (occupationFed != null && !occupationFed.equals(other.getOccupationFed()))
			return false;
		if (exclusions == null && other.getExclusions() != null)
			return false;
		if (exclusions != null && !exclusions.equals(other.getExclusions()))
			return false;
		if (declinedCode == null && other.getDeclinedCode() != null)
			return false;
		if (declinedCode != null && !declinedCode.equals(other.getDeclinedCode()))
			return false;
		if (declinedReason == null && other.getDeclinedReason() != null)
			return false;
		if (declinedReason != null && !declinedReason.equals(other.getDeclinedReason()))
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
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (upReportContent == null && other.getUpReportContent() != null)
			return false;
		if (upReportContent != null && !upReportContent.equals(other.getUpReportContent()))
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
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
		if (printFlag == null && other.getPrintFlag() != null)
			return false;
		if (printFlag != null && !printFlag.equals(other.getPrintFlag()))
			return false;
		if (printFlag2 == null && other.getPrintFlag2() != null)
			return false;
		if (printFlag2 != null && !printFlag2.equals(other.getPrintFlag2()))
			return false;
		if (changePolFlag == null && other.getChangePolFlag() != null)
			return false;
		if (changePolFlag != null && !changePolFlag.equals(other.getChangePolFlag()))
			return false;
		if (changePolReason == null && other.getChangePolReason() != null)
			return false;
		if (changePolReason != null && !changePolReason.equals(other.getChangePolReason()))
			return false;
		if (specReason == null && other.getSpecReason() != null)
			return false;
		if (specReason != null && !specReason.equals(other.getSpecReason()))
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
		if (modifyTime != null && !modifyTime.equals(other.getModifyTime()))
			return false;
		if (sugPassFlag == null && other.getSugPassFlag() != null)
			return false;
		if (sugPassFlag != null && !sugPassFlag.equals(other.getSugPassFlag()))
			return false;
		if (sugUWIdea == null && other.getSugUWIdea() != null)
			return false;
		return sugUWIdea == null || sugUWIdea.equals(other.getSugUWIdea());
	}

	public int getFieldCount()
	{
		return 54;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 1;
		if (strFieldName.equals("proposalContNo"))
			return 2;
		if (strFieldName.equals("polNo"))
			return 3;
		if (strFieldName.equals("proposalNo"))
			return 4;
		if (strFieldName.equals("uWNo"))
			return 5;
		if (strFieldName.equals("insuredNo"))
			return 6;
		if (strFieldName.equals("insuredName"))
			return 7;
		if (strFieldName.equals("appntNo"))
			return 8;
		if (strFieldName.equals("appntName"))
			return 9;
		if (strFieldName.equals("planCode"))
			return 10;
		if (strFieldName.equals("planName"))
			return 11;
		if (strFieldName.equals("riderName"))
			return 12;
		if (strFieldName.equals("riderCode"))
			return 13;
		if (strFieldName.equals("uWDid"))
			return 14;
		if (strFieldName.equals("faceAmount"))
			return 15;
		if (strFieldName.equals("term"))
			return 16;
		if (strFieldName.equals("healthDeb"))
			return 17;
		if (strFieldName.equals("healthFe"))
			return 18;
		if (strFieldName.equals("healthFed"))
			return 19;
		if (strFieldName.equals("occupationFactor"))
			return 20;
		if (strFieldName.equals("occupationFe"))
			return 21;
		if (strFieldName.equals("occupationFed"))
			return 22;
		if (strFieldName.equals("exclusions"))
			return 23;
		if (strFieldName.equals("declinedCode"))
			return 24;
		if (strFieldName.equals("declinedReason"))
			return 25;
		if (strFieldName.equals("passFlag"))
			return 26;
		if (strFieldName.equals("uWIdea"))
			return 27;
		if (strFieldName.equals("uWGrade"))
			return 28;
		if (strFieldName.equals("appGrade"))
			return 29;
		if (strFieldName.equals("postponeDay"))
			return 30;
		if (strFieldName.equals("postponeDate"))
			return 31;
		if (strFieldName.equals("autoUWFlag"))
			return 32;
		if (strFieldName.equals("state"))
			return 33;
		if (strFieldName.equals("manageCom"))
			return 34;
		if (strFieldName.equals("upReportContent"))
			return 35;
		if (strFieldName.equals("operator"))
			return 36;
		if (strFieldName.equals("healthFlag"))
			return 37;
		if (strFieldName.equals("quesFlag"))
			return 38;
		if (strFieldName.equals("specFlag"))
			return 39;
		if (strFieldName.equals("addPremFlag"))
			return 40;
		if (strFieldName.equals("addPremReason"))
			return 41;
		if (strFieldName.equals("reportFlag"))
			return 42;
		if (strFieldName.equals("printFlag"))
			return 43;
		if (strFieldName.equals("printFlag2"))
			return 44;
		if (strFieldName.equals("changePolFlag"))
			return 45;
		if (strFieldName.equals("changePolReason"))
			return 46;
		if (strFieldName.equals("specReason"))
			return 47;
		if (strFieldName.equals("makeDate"))
			return 48;
		if (strFieldName.equals("makeTime"))
			return 49;
		if (strFieldName.equals("modifyDate"))
			return 50;
		if (strFieldName.equals("modifyTime"))
			return 51;
		if (strFieldName.equals("sugPassFlag"))
			return 52;
		return !strFieldName.equals("sugUWIdea") ? -1 : 53;
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
			strFieldName = "polNo";
			break;

		case 4: // '\004'
			strFieldName = "proposalNo";
			break;

		case 5: // '\005'
			strFieldName = "uWNo";
			break;

		case 6: // '\006'
			strFieldName = "insuredNo";
			break;

		case 7: // '\007'
			strFieldName = "insuredName";
			break;

		case 8: // '\b'
			strFieldName = "appntNo";
			break;

		case 9: // '\t'
			strFieldName = "appntName";
			break;

		case 10: // '\n'
			strFieldName = "planCode";
			break;

		case 11: // '\013'
			strFieldName = "planName";
			break;

		case 12: // '\f'
			strFieldName = "riderName";
			break;

		case 13: // '\r'
			strFieldName = "riderCode";
			break;

		case 14: // '\016'
			strFieldName = "uWDid";
			break;

		case 15: // '\017'
			strFieldName = "faceAmount";
			break;

		case 16: // '\020'
			strFieldName = "term";
			break;

		case 17: // '\021'
			strFieldName = "healthDeb";
			break;

		case 18: // '\022'
			strFieldName = "healthFe";
			break;

		case 19: // '\023'
			strFieldName = "healthFed";
			break;

		case 20: // '\024'
			strFieldName = "occupationFactor";
			break;

		case 21: // '\025'
			strFieldName = "occupationFe";
			break;

		case 22: // '\026'
			strFieldName = "occupationFed";
			break;

		case 23: // '\027'
			strFieldName = "exclusions";
			break;

		case 24: // '\030'
			strFieldName = "declinedCode";
			break;

		case 25: // '\031'
			strFieldName = "declinedReason";
			break;

		case 26: // '\032'
			strFieldName = "passFlag";
			break;

		case 27: // '\033'
			strFieldName = "uWIdea";
			break;

		case 28: // '\034'
			strFieldName = "uWGrade";
			break;

		case 29: // '\035'
			strFieldName = "appGrade";
			break;

		case 30: // '\036'
			strFieldName = "postponeDay";
			break;

		case 31: // '\037'
			strFieldName = "postponeDate";
			break;

		case 32: // ' '
			strFieldName = "autoUWFlag";
			break;

		case 33: // '!'
			strFieldName = "state";
			break;

		case 34: // '"'
			strFieldName = "manageCom";
			break;

		case 35: // '#'
			strFieldName = "upReportContent";
			break;

		case 36: // '$'
			strFieldName = "operator";
			break;

		case 37: // '%'
			strFieldName = "healthFlag";
			break;

		case 38: // '&'
			strFieldName = "quesFlag";
			break;

		case 39: // '\''
			strFieldName = "specFlag";
			break;

		case 40: // '('
			strFieldName = "addPremFlag";
			break;

		case 41: // ')'
			strFieldName = "addPremReason";
			break;

		case 42: // '*'
			strFieldName = "reportFlag";
			break;

		case 43: // '+'
			strFieldName = "printFlag";
			break;

		case 44: // ','
			strFieldName = "printFlag2";
			break;

		case 45: // '-'
			strFieldName = "changePolFlag";
			break;

		case 46: // '.'
			strFieldName = "changePolReason";
			break;

		case 47: // '/'
			strFieldName = "specReason";
			break;

		case 48: // '0'
			strFieldName = "makeDate";
			break;

		case 49: // '1'
			strFieldName = "makeTime";
			break;

		case 50: // '2'
			strFieldName = "modifyDate";
			break;

		case 51: // '3'
			strFieldName = "modifyTime";
			break;

		case 52: // '4'
			strFieldName = "sugPassFlag";
			break;

		case 53: // '5'
			strFieldName = "sugUWIdea";
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
		if (strFieldName.equals("polNo"))
			return 0;
		if (strFieldName.equals("proposalNo"))
			return 0;
		if (strFieldName.equals("uWNo"))
			return 3;
		if (strFieldName.equals("insuredNo"))
			return 0;
		if (strFieldName.equals("insuredName"))
			return 0;
		if (strFieldName.equals("appntNo"))
			return 0;
		if (strFieldName.equals("appntName"))
			return 0;
		if (strFieldName.equals("planCode"))
			return 0;
		if (strFieldName.equals("planName"))
			return 0;
		if (strFieldName.equals("riderName"))
			return 0;
		if (strFieldName.equals("riderCode"))
			return 0;
		if (strFieldName.equals("uWDid"))
			return 0;
		if (strFieldName.equals("faceAmount"))
			return 0;
		if (strFieldName.equals("term"))
			return 0;
		if (strFieldName.equals("healthDeb"))
			return 0;
		if (strFieldName.equals("healthFe"))
			return 0;
		if (strFieldName.equals("healthFed"))
			return 0;
		if (strFieldName.equals("occupationFactor"))
			return 0;
		if (strFieldName.equals("occupationFe"))
			return 0;
		if (strFieldName.equals("occupationFed"))
			return 0;
		if (strFieldName.equals("exclusions"))
			return 0;
		if (strFieldName.equals("declinedCode"))
			return 0;
		if (strFieldName.equals("declinedReason"))
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
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("upReportContent"))
			return 0;
		if (strFieldName.equals("operator"))
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
		if (strFieldName.equals("printFlag"))
			return 0;
		if (strFieldName.equals("printFlag2"))
			return 0;
		if (strFieldName.equals("changePolFlag"))
			return 0;
		if (strFieldName.equals("changePolReason"))
			return 0;
		if (strFieldName.equals("specReason"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		if (strFieldName.equals("modifyTime"))
			return 0;
		if (strFieldName.equals("sugPassFlag"))
			return 0;
		return !strFieldName.equals("sugUWIdea") ? -1 : 0;
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
			nFieldType = 0;
			break;

		case 34: // '"'
			nFieldType = 0;
			break;

		case 35: // '#'
			nFieldType = 0;
			break;

		case 36: // '$'
			nFieldType = 0;
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
			nFieldType = 1;
			break;

		case 49: // '1'
			nFieldType = 0;
			break;

		case 50: // '2'
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
