// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MSysVarSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MSysVarDB;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MSysVarSchema
	implements Schema, Cloneable
{

	private String varType;
	private String varValue;
	public static final int FIELDNUM = 2;
	private static String PK[];
	public CErrors mErrors;

	public MSysVarSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "VarType";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MSysVarSchema cloned = (MSysVarSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getVarType()
	{
		return varType;
	}

	public void setVarType(String aVarType)
	{
		varType = aVarType;
	}

	public String getVarValue()
	{
		return varValue;
	}

	public void setVarValue(String aVarValue)
	{
		varValue = aVarValue;
	}

	public void setSchema(MSysVarSchema aMSysVarSchema)
	{
		varType = aMSysVarSchema.getVarType();
		varValue = aMSysVarSchema.getVarValue();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("VarType") == null)
				varType = null;
			else
				varType = rs.getString("VarType").trim();
			if (rs.getString("VarValue") == null)
				varValue = null;
			else
				varValue = rs.getString("VarValue").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MSysVar表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MSysVarSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MSysVarSchema getSchema()
	{
		MSysVarSchema aMSysVarSchema = new MSysVarSchema();
		aMSysVarSchema.setSchema(this);
		return aMSysVarSchema;
	}

	public MSysVarDB getDB()
	{
		MSysVarDB aDBOper = new MSysVarDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(varType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varValue));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			varType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			varValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MSysVarSchema";
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
		if (FCode.equalsIgnoreCase("varType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varType));
		if (FCode.equalsIgnoreCase("varValue"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varValue));
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
			strFieldValue = StrTool.GBKToUnicode(varType);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(varValue);
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
		if (FCode.equalsIgnoreCase("varType"))
			if (FValue != null && !FValue.equals(""))
				varType = FValue.trim();
			else
				varType = null;
		if (FCode.equalsIgnoreCase("varValue"))
			if (FValue != null && !FValue.equals(""))
				varValue = FValue.trim();
			else
				varValue = null;
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
		MSysVarSchema other = (MSysVarSchema)otherObject;
		if (varType == null && other.getVarType() != null)
			return false;
		if (varType != null && !varType.equals(other.getVarType()))
			return false;
		if (varValue == null && other.getVarValue() != null)
			return false;
		return varValue == null || varValue.equals(other.getVarValue());
	}

	public int getFieldCount()
	{
		return 2;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("varType"))
			return 0;
		return !strFieldName.equals("varValue") ? -1 : 1;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "varType";
			break;

		case 1: // '\001'
			strFieldName = "varValue";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("varType"))
			return 0;
		return !strFieldName.equals("varValue") ? -1 : 0;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
