// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskScreenValidateSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskScreenValidateDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskScreenValidateSchema
	implements Schema, Cloneable
{

	private String controlId;
	private String riskCode;
	private String controlCode;
	private String controlValue;
	private String functionType;
	private String relaDivCode;
	private String relaDivShow;
	private String relaControlCode;
	private String relaControlType;
	private String relaValueSql;
	private String calCode;
	private String noti;
	public static final int FIELDNUM = 12;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskScreenValidateSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ControlId";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskScreenValidateSchema cloned = (LNPRiskScreenValidateSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getControlId()
	{
		return controlId;
	}

	public void setControlId(String aControlId)
	{
		controlId = aControlId;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String aRiskCode)
	{
		riskCode = aRiskCode;
	}

	public String getControlCode()
	{
		return controlCode;
	}

	public void setControlCode(String aControlCode)
	{
		controlCode = aControlCode;
	}

	public String getControlValue()
	{
		return controlValue;
	}

	public void setControlValue(String aControlValue)
	{
		controlValue = aControlValue;
	}

	public String getFunctionType()
	{
		return functionType;
	}

	public void setFunctionType(String aFunctionType)
	{
		functionType = aFunctionType;
	}

	public String getRelaDivCode()
	{
		return relaDivCode;
	}

	public void setRelaDivCode(String aRelaDivCode)
	{
		relaDivCode = aRelaDivCode;
	}

	public String getRelaDivShow()
	{
		return relaDivShow;
	}

	public void setRelaDivShow(String aRelaDivShow)
	{
		relaDivShow = aRelaDivShow;
	}

	public String getRelaControlCode()
	{
		return relaControlCode;
	}

	public void setRelaControlCode(String aRelaControlCode)
	{
		relaControlCode = aRelaControlCode;
	}

	public String getRelaControlType()
	{
		return relaControlType;
	}

	public void setRelaControlType(String aRelaControlType)
	{
		relaControlType = aRelaControlType;
	}

	public String getRelaValueSql()
	{
		return relaValueSql;
	}

	public void setRelaValueSql(String aRelaValueSql)
	{
		relaValueSql = aRelaValueSql;
	}

	public String getCalCode()
	{
		return calCode;
	}

	public void setCalCode(String aCalCode)
	{
		calCode = aCalCode;
	}

	public String getNoti()
	{
		return noti;
	}

	public void setNoti(String aNoti)
	{
		noti = aNoti;
	}

	public void setSchema(LNPRiskScreenValidateSchema aLNPRiskScreenValidateSchema)
	{
		controlId = aLNPRiskScreenValidateSchema.getControlId();
		riskCode = aLNPRiskScreenValidateSchema.getRiskCode();
		controlCode = aLNPRiskScreenValidateSchema.getControlCode();
		controlValue = aLNPRiskScreenValidateSchema.getControlValue();
		functionType = aLNPRiskScreenValidateSchema.getFunctionType();
		relaDivCode = aLNPRiskScreenValidateSchema.getRelaDivCode();
		relaDivShow = aLNPRiskScreenValidateSchema.getRelaDivShow();
		relaControlCode = aLNPRiskScreenValidateSchema.getRelaControlCode();
		relaControlType = aLNPRiskScreenValidateSchema.getRelaControlType();
		relaValueSql = aLNPRiskScreenValidateSchema.getRelaValueSql();
		calCode = aLNPRiskScreenValidateSchema.getCalCode();
		noti = aLNPRiskScreenValidateSchema.getNoti();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ControlId") == null)
				controlId = null;
			else
				controlId = rs.getString("ControlId").trim();
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			if (rs.getString("ControlCode") == null)
				controlCode = null;
			else
				controlCode = rs.getString("ControlCode").trim();
			if (rs.getString("ControlValue") == null)
				controlValue = null;
			else
				controlValue = rs.getString("ControlValue").trim();
			if (rs.getString("FunctionType") == null)
				functionType = null;
			else
				functionType = rs.getString("FunctionType").trim();
			if (rs.getString("RelaDivCode") == null)
				relaDivCode = null;
			else
				relaDivCode = rs.getString("RelaDivCode").trim();
			if (rs.getString("RelaDivShow") == null)
				relaDivShow = null;
			else
				relaDivShow = rs.getString("RelaDivShow").trim();
			if (rs.getString("RelaControlCode") == null)
				relaControlCode = null;
			else
				relaControlCode = rs.getString("RelaControlCode").trim();
			if (rs.getString("RelaControlType") == null)
				relaControlType = null;
			else
				relaControlType = rs.getString("RelaControlType").trim();
			if (rs.getString("RelaValueSql") == null)
				relaValueSql = null;
			else
				relaValueSql = rs.getString("RelaValueSql").trim();
			if (rs.getString("CalCode") == null)
				calCode = null;
			else
				calCode = rs.getString("CalCode").trim();
			if (rs.getString("Noti") == null)
				noti = null;
			else
				noti = rs.getString("Noti").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPRiskScreenValidate���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenValidateSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskScreenValidateSchema getSchema()
	{
		LNPRiskScreenValidateSchema aLNPRiskScreenValidateSchema = new LNPRiskScreenValidateSchema();
		aLNPRiskScreenValidateSchema.setSchema(this);
		return aLNPRiskScreenValidateSchema;
	}

	public LNPRiskScreenValidateDB getDB()
	{
		LNPRiskScreenValidateDB aDBOper = new LNPRiskScreenValidateDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(controlId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(controlCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(controlValue));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(functionType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relaDivCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relaDivShow));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relaControlCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relaControlType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relaValueSql));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(calCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(noti));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			controlId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			controlCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			controlValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			functionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			relaDivCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			relaDivShow = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			relaControlCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			relaControlType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			relaValueSql = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			noti = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenValidateSchema";
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
		if (FCode.equalsIgnoreCase("controlId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(controlId));
		if (FCode.equalsIgnoreCase("riskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCode));
		if (FCode.equalsIgnoreCase("controlCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(controlCode));
		if (FCode.equalsIgnoreCase("controlValue"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(controlValue));
		if (FCode.equalsIgnoreCase("functionType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(functionType));
		if (FCode.equalsIgnoreCase("relaDivCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relaDivCode));
		if (FCode.equalsIgnoreCase("relaDivShow"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relaDivShow));
		if (FCode.equalsIgnoreCase("relaControlCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relaControlCode));
		if (FCode.equalsIgnoreCase("relaControlType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relaControlType));
		if (FCode.equalsIgnoreCase("relaValueSql"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relaValueSql));
		if (FCode.equalsIgnoreCase("calCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(calCode));
		if (FCode.equalsIgnoreCase("noti"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(noti));
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
			strFieldValue = StrTool.GBKToUnicode(controlId);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(riskCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(controlCode);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(controlValue);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(functionType);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(relaDivCode);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(relaDivShow);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(relaControlCode);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(relaControlType);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(relaValueSql);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(calCode);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(noti);
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
		if (FCode.equalsIgnoreCase("controlId"))
			if (FValue != null && !FValue.equals(""))
				controlId = FValue.trim();
			else
				controlId = null;
		if (FCode.equalsIgnoreCase("riskCode"))
			if (FValue != null && !FValue.equals(""))
				riskCode = FValue.trim();
			else
				riskCode = null;
		if (FCode.equalsIgnoreCase("controlCode"))
			if (FValue != null && !FValue.equals(""))
				controlCode = FValue.trim();
			else
				controlCode = null;
		if (FCode.equalsIgnoreCase("controlValue"))
			if (FValue != null && !FValue.equals(""))
				controlValue = FValue.trim();
			else
				controlValue = null;
		if (FCode.equalsIgnoreCase("functionType"))
			if (FValue != null && !FValue.equals(""))
				functionType = FValue.trim();
			else
				functionType = null;
		if (FCode.equalsIgnoreCase("relaDivCode"))
			if (FValue != null && !FValue.equals(""))
				relaDivCode = FValue.trim();
			else
				relaDivCode = null;
		if (FCode.equalsIgnoreCase("relaDivShow"))
			if (FValue != null && !FValue.equals(""))
				relaDivShow = FValue.trim();
			else
				relaDivShow = null;
		if (FCode.equalsIgnoreCase("relaControlCode"))
			if (FValue != null && !FValue.equals(""))
				relaControlCode = FValue.trim();
			else
				relaControlCode = null;
		if (FCode.equalsIgnoreCase("relaControlType"))
			if (FValue != null && !FValue.equals(""))
				relaControlType = FValue.trim();
			else
				relaControlType = null;
		if (FCode.equalsIgnoreCase("relaValueSql"))
			if (FValue != null && !FValue.equals(""))
				relaValueSql = FValue.trim();
			else
				relaValueSql = null;
		if (FCode.equalsIgnoreCase("calCode"))
			if (FValue != null && !FValue.equals(""))
				calCode = FValue.trim();
			else
				calCode = null;
		if (FCode.equalsIgnoreCase("noti"))
			if (FValue != null && !FValue.equals(""))
				noti = FValue.trim();
			else
				noti = null;
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
		LNPRiskScreenValidateSchema other = (LNPRiskScreenValidateSchema)otherObject;
		if (controlId == null && other.getControlId() != null)
			return false;
		if (controlId != null && !controlId.equals(other.getControlId()))
			return false;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (controlCode == null && other.getControlCode() != null)
			return false;
		if (controlCode != null && !controlCode.equals(other.getControlCode()))
			return false;
		if (controlValue == null && other.getControlValue() != null)
			return false;
		if (controlValue != null && !controlValue.equals(other.getControlValue()))
			return false;
		if (functionType == null && other.getFunctionType() != null)
			return false;
		if (functionType != null && !functionType.equals(other.getFunctionType()))
			return false;
		if (relaDivCode == null && other.getRelaDivCode() != null)
			return false;
		if (relaDivCode != null && !relaDivCode.equals(other.getRelaDivCode()))
			return false;
		if (relaDivShow == null && other.getRelaDivShow() != null)
			return false;
		if (relaDivShow != null && !relaDivShow.equals(other.getRelaDivShow()))
			return false;
		if (relaControlCode == null && other.getRelaControlCode() != null)
			return false;
		if (relaControlCode != null && !relaControlCode.equals(other.getRelaControlCode()))
			return false;
		if (relaControlType == null && other.getRelaControlType() != null)
			return false;
		if (relaControlType != null && !relaControlType.equals(other.getRelaControlType()))
			return false;
		if (relaValueSql == null && other.getRelaValueSql() != null)
			return false;
		if (relaValueSql != null && !relaValueSql.equals(other.getRelaValueSql()))
			return false;
		if (calCode == null && other.getCalCode() != null)
			return false;
		if (calCode != null && !calCode.equals(other.getCalCode()))
			return false;
		if (noti == null && other.getNoti() != null)
			return false;
		return noti == null || noti.equals(other.getNoti());
	}

	public int getFieldCount()
	{
		return 12;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("controlId"))
			return 0;
		if (strFieldName.equals("riskCode"))
			return 1;
		if (strFieldName.equals("controlCode"))
			return 2;
		if (strFieldName.equals("controlValue"))
			return 3;
		if (strFieldName.equals("functionType"))
			return 4;
		if (strFieldName.equals("relaDivCode"))
			return 5;
		if (strFieldName.equals("relaDivShow"))
			return 6;
		if (strFieldName.equals("relaControlCode"))
			return 7;
		if (strFieldName.equals("relaControlType"))
			return 8;
		if (strFieldName.equals("relaValueSql"))
			return 9;
		if (strFieldName.equals("calCode"))
			return 10;
		return !strFieldName.equals("noti") ? -1 : 11;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "controlId";
			break;

		case 1: // '\001'
			strFieldName = "riskCode";
			break;

		case 2: // '\002'
			strFieldName = "controlCode";
			break;

		case 3: // '\003'
			strFieldName = "controlValue";
			break;

		case 4: // '\004'
			strFieldName = "functionType";
			break;

		case 5: // '\005'
			strFieldName = "relaDivCode";
			break;

		case 6: // '\006'
			strFieldName = "relaDivShow";
			break;

		case 7: // '\007'
			strFieldName = "relaControlCode";
			break;

		case 8: // '\b'
			strFieldName = "relaControlType";
			break;

		case 9: // '\t'
			strFieldName = "relaValueSql";
			break;

		case 10: // '\n'
			strFieldName = "calCode";
			break;

		case 11: // '\013'
			strFieldName = "noti";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("controlId"))
			return 0;
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("controlCode"))
			return 0;
		if (strFieldName.equals("controlValue"))
			return 0;
		if (strFieldName.equals("functionType"))
			return 0;
		if (strFieldName.equals("relaDivCode"))
			return 0;
		if (strFieldName.equals("relaDivShow"))
			return 0;
		if (strFieldName.equals("relaControlCode"))
			return 0;
		if (strFieldName.equals("relaControlType"))
			return 0;
		if (strFieldName.equals("relaValueSql"))
			return 0;
		if (strFieldName.equals("calCode"))
			return 0;
		return !strFieldName.equals("noti") ? -1 : 0;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
