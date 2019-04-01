// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskDutySchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskDutyDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskDutySchema
	implements Schema, Cloneable
{

	private String riskCode;
	private String riskVer;
	private String dutyCode;
	private String choFlag;
	private String specFlag;
	public static final int FIELDNUM = 5;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskDutySchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "RiskCode";
		pk[1] = "DutyCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskDutySchema cloned = (LNPRiskDutySchema)super.clone();
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

	public String getDutyCode()
	{
		return dutyCode;
	}

	public void setDutyCode(String aDutyCode)
	{
		dutyCode = aDutyCode;
	}

	public String getChoFlag()
	{
		return choFlag;
	}

	public void setChoFlag(String aChoFlag)
	{
		choFlag = aChoFlag;
	}

	public String getSpecFlag()
	{
		return specFlag;
	}

	public void setSpecFlag(String aSpecFlag)
	{
		specFlag = aSpecFlag;
	}

	public void setSchema(LNPRiskDutySchema aLNPRiskDutySchema)
	{
		riskCode = aLNPRiskDutySchema.getRiskCode();
		riskVer = aLNPRiskDutySchema.getRiskVer();
		dutyCode = aLNPRiskDutySchema.getDutyCode();
		choFlag = aLNPRiskDutySchema.getChoFlag();
		specFlag = aLNPRiskDutySchema.getSpecFlag();
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
			if (rs.getString("DutyCode") == null)
				dutyCode = null;
			else
				dutyCode = rs.getString("DutyCode").trim();
			if (rs.getString("ChoFlag") == null)
				choFlag = null;
			else
				choFlag = rs.getString("ChoFlag").trim();
			if (rs.getString("SpecFlag") == null)
				specFlag = null;
			else
				specFlag = rs.getString("SpecFlag").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPRiskDuty���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskDutySchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskDutySchema getSchema()
	{
		LNPRiskDutySchema aLNPRiskDutySchema = new LNPRiskDutySchema();
		aLNPRiskDutySchema.setSchema(this);
		return aLNPRiskDutySchema;
	}

	public LNPRiskDutyDB getDB()
	{
		LNPRiskDutyDB aDBOper = new LNPRiskDutyDB();
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
		strReturn.append(StrTool.cTrim(dutyCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(choFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(specFlag));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			dutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			choFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			specFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskDutySchema";
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
		if (FCode.equalsIgnoreCase("dutyCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dutyCode));
		if (FCode.equalsIgnoreCase("choFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(choFlag));
		if (FCode.equalsIgnoreCase("specFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(specFlag));
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
			strFieldValue = StrTool.GBKToUnicode(dutyCode);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(choFlag);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(specFlag);
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
		if (FCode.equalsIgnoreCase("dutyCode"))
			if (FValue != null && !FValue.equals(""))
				dutyCode = FValue.trim();
			else
				dutyCode = null;
		if (FCode.equalsIgnoreCase("choFlag"))
			if (FValue != null && !FValue.equals(""))
				choFlag = FValue.trim();
			else
				choFlag = null;
		if (FCode.equalsIgnoreCase("specFlag"))
			if (FValue != null && !FValue.equals(""))
				specFlag = FValue.trim();
			else
				specFlag = null;
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
		LNPRiskDutySchema other = (LNPRiskDutySchema)otherObject;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (riskVer == null && other.getRiskVer() != null)
			return false;
		if (riskVer != null && !riskVer.equals(other.getRiskVer()))
			return false;
		if (dutyCode == null && other.getDutyCode() != null)
			return false;
		if (dutyCode != null && !dutyCode.equals(other.getDutyCode()))
			return false;
		if (choFlag == null && other.getChoFlag() != null)
			return false;
		if (choFlag != null && !choFlag.equals(other.getChoFlag()))
			return false;
		if (specFlag == null && other.getSpecFlag() != null)
			return false;
		return specFlag == null || specFlag.equals(other.getSpecFlag());
	}

	public int getFieldCount()
	{
		return 5;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVer"))
			return 1;
		if (strFieldName.equals("dutyCode"))
			return 2;
		if (strFieldName.equals("choFlag"))
			return 3;
		return !strFieldName.equals("specFlag") ? -1 : 4;
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
			strFieldName = "dutyCode";
			break;

		case 3: // '\003'
			strFieldName = "choFlag";
			break;

		case 4: // '\004'
			strFieldName = "specFlag";
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
		if (strFieldName.equals("dutyCode"))
			return 0;
		if (strFieldName.equals("choFlag"))
			return 0;
		return !strFieldName.equals("specFlag") ? -1 : 0;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
