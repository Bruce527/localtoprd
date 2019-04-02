// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCalModeSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPCalModeDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPCalModeSchema
	implements Schema, Cloneable
{

	private String calCode;
	private String riskCode;
	private String type;
	private String calSQL;
	private String remark;
	public static final int FIELDNUM = 5;
	private static String PK[];
	public CErrors mErrors;

	public LNPCalModeSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "CalCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPCalModeSchema cloned = (LNPCalModeSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getCalCode()
	{
		return calCode;
	}

	public void setCalCode(String aCalCode)
	{
		calCode = aCalCode;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String aRiskCode)
	{
		riskCode = aRiskCode;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
	}

	public String getCalSQL()
	{
		return calSQL;
	}

	public void setCalSQL(String aCalSQL)
	{
		calSQL = aCalSQL;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String aRemark)
	{
		remark = aRemark;
	}

	public void setSchema(LNPCalModeSchema aLNPCalModeSchema)
	{
		calCode = aLNPCalModeSchema.getCalCode();
		riskCode = aLNPCalModeSchema.getRiskCode();
		type = aLNPCalModeSchema.getType();
		calSQL = aLNPCalModeSchema.getCalSQL();
		remark = aLNPCalModeSchema.getRemark();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("CalCode") == null)
				calCode = null;
			else
				calCode = rs.getString("CalCode").trim();
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
			if (rs.getString("CalSQL") == null)
				calSQL = null;
			else
				calSQL = rs.getString("CalSQL").trim();
			if (rs.getString("Remark") == null)
				remark = null;
			else
				remark = rs.getString("Remark").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPCalMode表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPCalModeSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPCalModeSchema getSchema()
	{
		LNPCalModeSchema aLNPCalModeSchema = new LNPCalModeSchema();
		aLNPCalModeSchema.setSchema(this);
		return aLNPCalModeSchema;
	}

	public LNPCalModeDB getDB()
	{
		LNPCalModeDB aDBOper = new LNPCalModeDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(calCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(type));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(calSQL));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remark));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			calSQL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCalModeSchema";
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
		if (FCode.equalsIgnoreCase("calCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(calCode));
		if (FCode.equalsIgnoreCase("riskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCode));
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
		if (FCode.equalsIgnoreCase("calSQL"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(calSQL));
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
			strFieldValue = StrTool.GBKToUnicode(calCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(riskCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(calSQL);
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
		if (FCode.equalsIgnoreCase("calCode"))
			if (FValue != null && !FValue.equals(""))
				calCode = FValue.trim();
			else
				calCode = null;
		if (FCode.equalsIgnoreCase("riskCode"))
			if (FValue != null && !FValue.equals(""))
				riskCode = FValue.trim();
			else
				riskCode = null;
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
		if (FCode.equalsIgnoreCase("calSQL"))
			if (FValue != null && !FValue.equals(""))
				calSQL = FValue.trim();
			else
				calSQL = null;
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
		LNPCalModeSchema other = (LNPCalModeSchema)otherObject;
		if (calCode == null && other.getCalCode() != null)
			return false;
		if (calCode != null && !calCode.equals(other.getCalCode()))
			return false;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
			return false;
		if (calSQL == null && other.getCalSQL() != null)
			return false;
		if (calSQL != null && !calSQL.equals(other.getCalSQL()))
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
		if (strFieldName.equals("calCode"))
			return 0;
		if (strFieldName.equals("riskCode"))
			return 1;
		if (strFieldName.equals("type"))
			return 2;
		if (strFieldName.equals("calSQL"))
			return 3;
		return !strFieldName.equals("remark") ? -1 : 4;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "calCode";
			break;

		case 1: // '\001'
			strFieldName = "riskCode";
			break;

		case 2: // '\002'
			strFieldName = "type";
			break;

		case 3: // '\003'
			strFieldName = "calSQL";
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
		if (strFieldName.equals("calCode"))
			return 0;
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("type"))
			return 0;
		if (strFieldName.equals("calSQL"))
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
