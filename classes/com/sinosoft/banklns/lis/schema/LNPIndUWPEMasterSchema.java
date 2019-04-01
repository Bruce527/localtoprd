// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPIndUWPEMasterSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPIndUWPEMasterDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPIndUWPEMasterSchema
	implements Schema, Cloneable
{

	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private int uWNo;
	private String manageCom;
	private Date uMDate;
	private String uMTime;
	private String insuredId;
	private String uWPENo;
	private String pEName;
	private String pECode;
	private String pEStatus;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 17;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPIndUWPEMasterSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[3];
		pk[0] = "ContNo";
		pk[1] = "InsuredId";
		pk[2] = "UWPENo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPIndUWPEMasterSchema cloned = (LNPIndUWPEMasterSchema)super.clone();
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

	public String getUMDate()
	{
		if (uMDate != null)
			return fDate.getString(uMDate);
		else
			return null;
	}

	public void setUMDate(Date aUMDate)
	{
		uMDate = aUMDate;
	}

	public void setUMDate(String aUMDate)
	{
		if (aUMDate != null && !aUMDate.equals(""))
			uMDate = fDate.getDate(aUMDate);
		else
			uMDate = null;
	}

	public String getUMTime()
	{
		return uMTime;
	}

	public void setUMTime(String aUMTime)
	{
		uMTime = aUMTime;
	}

	public String getInsuredId()
	{
		return insuredId;
	}

	public void setInsuredId(String aInsuredId)
	{
		insuredId = aInsuredId;
	}

	public String getUWPENo()
	{
		return uWPENo;
	}

	public void setUWPENo(String aUWPENo)
	{
		uWPENo = aUWPENo;
	}

	public String getPEName()
	{
		return pEName;
	}

	public void setPEName(String aPEName)
	{
		pEName = aPEName;
	}

	public String getPECode()
	{
		return pECode;
	}

	public void setPECode(String aPECode)
	{
		pECode = aPECode;
	}

	public String getPEStatus()
	{
		return pEStatus;
	}

	public void setPEStatus(String aPEStatus)
	{
		pEStatus = aPEStatus;
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

	public void setSchema(LNPIndUWPEMasterSchema aLNPIndUWPEMasterSchema)
	{
		grpContNo = aLNPIndUWPEMasterSchema.getGrpContNo();
		contNo = aLNPIndUWPEMasterSchema.getContNo();
		proposalContNo = aLNPIndUWPEMasterSchema.getProposalContNo();
		uWNo = aLNPIndUWPEMasterSchema.getUWNo();
		manageCom = aLNPIndUWPEMasterSchema.getManageCom();
		uMDate = fDate.getDate(aLNPIndUWPEMasterSchema.getUMDate());
		uMTime = aLNPIndUWPEMasterSchema.getUMTime();
		insuredId = aLNPIndUWPEMasterSchema.getInsuredId();
		uWPENo = aLNPIndUWPEMasterSchema.getUWPENo();
		pEName = aLNPIndUWPEMasterSchema.getPEName();
		pECode = aLNPIndUWPEMasterSchema.getPECode();
		pEStatus = aLNPIndUWPEMasterSchema.getPEStatus();
		operator = aLNPIndUWPEMasterSchema.getOperator();
		makeDate = fDate.getDate(aLNPIndUWPEMasterSchema.getMakeDate());
		makeTime = aLNPIndUWPEMasterSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPIndUWPEMasterSchema.getModifyDate());
		modifyTime = aLNPIndUWPEMasterSchema.getModifyTime();
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
			uMDate = rs.getDate("UMDate");
			if (rs.getString("UMTime") == null)
				uMTime = null;
			else
				uMTime = rs.getString("UMTime").trim();
			if (rs.getString("InsuredId") == null)
				insuredId = null;
			else
				insuredId = rs.getString("InsuredId").trim();
			if (rs.getString("UWPENo") == null)
				uWPENo = null;
			else
				uWPENo = rs.getString("UWPENo").trim();
			if (rs.getString("PEName") == null)
				pEName = null;
			else
				pEName = rs.getString("PEName").trim();
			if (rs.getString("PECode") == null)
				pECode = null;
			else
				pECode = rs.getString("PECode").trim();
			if (rs.getString("PEStatus") == null)
				pEStatus = null;
			else
				pEStatus = rs.getString("PEStatus").trim();
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
			System.out.println("��ݿ��е�LNPIndUWPEMaster���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPIndUWPEMasterSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPIndUWPEMasterSchema getSchema()
	{
		LNPIndUWPEMasterSchema aLNPIndUWPEMasterSchema = new LNPIndUWPEMasterSchema();
		aLNPIndUWPEMasterSchema.setSchema(this);
		return aLNPIndUWPEMasterSchema;
	}

	public LNPIndUWPEMasterDB getDB()
	{
		LNPIndUWPEMasterDB aDBOper = new LNPIndUWPEMasterDB();
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
		strReturn.append(StrTool.cTrim(fDate.getString(uMDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uMTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWPENo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(pEName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(pECode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(pEStatus));
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
			uMDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
			uMTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			uWPENo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			pEName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			pECode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			pEStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPIndUWPEMasterSchema";
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
		if (FCode.equalsIgnoreCase("uMDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getUMDate()));
		if (FCode.equalsIgnoreCase("uMTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uMTime));
		if (FCode.equalsIgnoreCase("insuredId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredId));
		if (FCode.equalsIgnoreCase("uWPENo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWPENo));
		if (FCode.equalsIgnoreCase("pEName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pEName));
		if (FCode.equalsIgnoreCase("pECode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pECode));
		if (FCode.equalsIgnoreCase("pEStatus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pEStatus));
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
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getUMDate()));
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(uMTime);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(insuredId);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(uWPENo);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(pEName);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(pECode);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(pEStatus);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 16: // '\020'
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
		if (FCode.equalsIgnoreCase("uMDate"))
			if (FValue != null && !FValue.equals(""))
				uMDate = fDate.getDate(FValue);
			else
				uMDate = null;
		if (FCode.equalsIgnoreCase("uMTime"))
			if (FValue != null && !FValue.equals(""))
				uMTime = FValue.trim();
			else
				uMTime = null;
		if (FCode.equalsIgnoreCase("insuredId"))
			if (FValue != null && !FValue.equals(""))
				insuredId = FValue.trim();
			else
				insuredId = null;
		if (FCode.equalsIgnoreCase("uWPENo"))
			if (FValue != null && !FValue.equals(""))
				uWPENo = FValue.trim();
			else
				uWPENo = null;
		if (FCode.equalsIgnoreCase("pEName"))
			if (FValue != null && !FValue.equals(""))
				pEName = FValue.trim();
			else
				pEName = null;
		if (FCode.equalsIgnoreCase("pECode"))
			if (FValue != null && !FValue.equals(""))
				pECode = FValue.trim();
			else
				pECode = null;
		if (FCode.equalsIgnoreCase("pEStatus"))
			if (FValue != null && !FValue.equals(""))
				pEStatus = FValue.trim();
			else
				pEStatus = null;
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
		LNPIndUWPEMasterSchema other = (LNPIndUWPEMasterSchema)otherObject;
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
		if (uMDate == null && other.getUMDate() != null)
			return false;
		if (uMDate != null && !fDate.getString(uMDate).equals(other.getUMDate()))
			return false;
		if (uMTime == null && other.getUMTime() != null)
			return false;
		if (uMTime != null && !uMTime.equals(other.getUMTime()))
			return false;
		if (insuredId == null && other.getInsuredId() != null)
			return false;
		if (insuredId != null && !insuredId.equals(other.getInsuredId()))
			return false;
		if (uWPENo == null && other.getUWPENo() != null)
			return false;
		if (uWPENo != null && !uWPENo.equals(other.getUWPENo()))
			return false;
		if (pEName == null && other.getPEName() != null)
			return false;
		if (pEName != null && !pEName.equals(other.getPEName()))
			return false;
		if (pECode == null && other.getPECode() != null)
			return false;
		if (pECode != null && !pECode.equals(other.getPECode()))
			return false;
		if (pEStatus == null && other.getPEStatus() != null)
			return false;
		if (pEStatus != null && !pEStatus.equals(other.getPEStatus()))
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
		return 17;
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
		if (strFieldName.equals("uMDate"))
			return 5;
		if (strFieldName.equals("uMTime"))
			return 6;
		if (strFieldName.equals("insuredId"))
			return 7;
		if (strFieldName.equals("uWPENo"))
			return 8;
		if (strFieldName.equals("pEName"))
			return 9;
		if (strFieldName.equals("pECode"))
			return 10;
		if (strFieldName.equals("pEStatus"))
			return 11;
		if (strFieldName.equals("operator"))
			return 12;
		if (strFieldName.equals("makeDate"))
			return 13;
		if (strFieldName.equals("makeTime"))
			return 14;
		if (strFieldName.equals("modifyDate"))
			return 15;
		return !strFieldName.equals("modifyTime") ? -1 : 16;
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
			strFieldName = "uMDate";
			break;

		case 6: // '\006'
			strFieldName = "uMTime";
			break;

		case 7: // '\007'
			strFieldName = "insuredId";
			break;

		case 8: // '\b'
			strFieldName = "uWPENo";
			break;

		case 9: // '\t'
			strFieldName = "pEName";
			break;

		case 10: // '\n'
			strFieldName = "pECode";
			break;

		case 11: // '\013'
			strFieldName = "pEStatus";
			break;

		case 12: // '\f'
			strFieldName = "operator";
			break;

		case 13: // '\r'
			strFieldName = "makeDate";
			break;

		case 14: // '\016'
			strFieldName = "makeTime";
			break;

		case 15: // '\017'
			strFieldName = "modifyDate";
			break;

		case 16: // '\020'
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
		if (strFieldName.equals("uMDate"))
			return 1;
		if (strFieldName.equals("uMTime"))
			return 0;
		if (strFieldName.equals("insuredId"))
			return 0;
		if (strFieldName.equals("uWPENo"))
			return 0;
		if (strFieldName.equals("pEName"))
			return 0;
		if (strFieldName.equals("pECode"))
			return 0;
		if (strFieldName.equals("pEStatus"))
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
			nFieldType = 1;
			break;

		case 14: // '\016'
			nFieldType = 0;
			break;

		case 15: // '\017'
			nFieldType = 1;
			break;

		case 16: // '\020'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
