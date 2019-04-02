// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskParamSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskParamDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskParamSchema
	implements Schema, Cloneable
{

	private String type;
	private String riskCode;
	private String param;
	private String expression;
	private String remark;
	public static final int FIELDNUM = 5;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskParamSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[3];
		pk[0] = "Type";
		pk[1] = "RiskCode";
		pk[2] = "Param";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskParamSchema cloned = (LNPRiskParamSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String aRiskCode)
	{
		riskCode = aRiskCode;
	}

	public String getParam()
	{
		return param;
	}

	public void setParam(String aParam)
	{
		param = aParam;
	}

	public String getExpression()
	{
		return expression;
	}

	public void setExpression(String aExpression)
	{
		expression = aExpression;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String aRemark)
	{
		remark = aRemark;
	}

	public void setSchema(LNPRiskParamSchema aLNPRiskParamSchema)
	{
		type = aLNPRiskParamSchema.getType();
		riskCode = aLNPRiskParamSchema.getRiskCode();
		param = aLNPRiskParamSchema.getParam();
		expression = aLNPRiskParamSchema.getExpression();
		remark = aLNPRiskParamSchema.getRemark();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			if (rs.getString("Param") == null)
				param = null;
			else
				param = rs.getString("Param").trim();
			if (rs.getString("Expression") == null)
				expression = null;
			else
				expression = rs.getString("Expression").trim();
			if (rs.getString("Remark") == null)
				remark = null;
			else
				remark = rs.getString("Remark").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPRiskParam????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskParamSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskParamSchema getSchema()
	{
		LNPRiskParamSchema aLNPRiskParamSchema = new LNPRiskParamSchema();
		aLNPRiskParamSchema.setSchema(this);
		return aLNPRiskParamSchema;
	}

	public LNPRiskParamDB getDB()
	{
		LNPRiskParamDB aDBOper = new LNPRiskParamDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(type));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(param));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(expression));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remark));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			param = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			expression = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskParamSchema";
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
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
		if (FCode.equalsIgnoreCase("riskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCode));
		if (FCode.equalsIgnoreCase("param"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(param));
		if (FCode.equalsIgnoreCase("expression"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(expression));
		if (FCode.equalsIgnoreCase("remark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark));
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
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(riskCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(param);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(expression);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(remark);
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
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
		if (FCode.equalsIgnoreCase("riskCode"))
			if (FValue != null && !FValue.equals(""))
				riskCode = FValue.trim();
			else
				riskCode = null;
		if (FCode.equalsIgnoreCase("param"))
			if (FValue != null && !FValue.equals(""))
				param = FValue.trim();
			else
				param = null;
		if (FCode.equalsIgnoreCase("expression"))
			if (FValue != null && !FValue.equals(""))
				expression = FValue.trim();
			else
				expression = null;
		if (FCode.equalsIgnoreCase("remark"))
			if (FValue != null && !FValue.equals(""))
				remark = FValue.trim();
			else
				remark = null;
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
		LNPRiskParamSchema other = (LNPRiskParamSchema)otherObject;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
			return false;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (param == null && other.getParam() != null)
			return false;
		if (param != null && !param.equals(other.getParam()))
			return false;
		if (expression == null && other.getExpression() != null)
			return false;
		if (expression != null && !expression.equals(other.getExpression()))
			return false;
		if (remark == null && other.getRemark() != null)
			return false;
		return remark == null || remark.equals(other.getRemark());
	}

	public int getFieldCount()
	{
		return 5;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("type"))
			return 0;
		if (strFieldName.equals("riskCode"))
			return 1;
		if (strFieldName.equals("param"))
			return 2;
		if (strFieldName.equals("expression"))
			return 3;
		return !strFieldName.equals("remark") ? -1 : 4;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "type";
			break;

		case 1: // '\001'
			strFieldName = "riskCode";
			break;

		case 2: // '\002'
			strFieldName = "param";
			break;

		case 3: // '\003'
			strFieldName = "expression";
			break;

		case 4: // '\004'
			strFieldName = "remark";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("type"))
			return 0;
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("param"))
			return 0;
		if (strFieldName.equals("expression"))
			return 0;
		return !strFieldName.equals("remark") ? -1 : 0;
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
