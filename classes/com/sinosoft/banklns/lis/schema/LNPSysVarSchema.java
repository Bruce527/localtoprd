// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPSysVarSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPSysVarDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPSysVarSchema
	implements Schema, Cloneable
{

	private String sysVar;
	private String sysVarType;
	private String sysVarValue;
	public static final int FIELDNUM = 3;
	private static String PK[];
	public CErrors mErrors;

	public LNPSysVarSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "SysVar";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPSysVarSchema cloned = (LNPSysVarSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getSysVar()
	{
		return sysVar;
	}

	public void setSysVar(String aSysVar)
	{
		sysVar = aSysVar;
	}

	public String getSysVarType()
	{
		return sysVarType;
	}

	public void setSysVarType(String aSysVarType)
	{
		sysVarType = aSysVarType;
	}

	public String getSysVarValue()
	{
		return sysVarValue;
	}

	public void setSysVarValue(String aSysVarValue)
	{
		sysVarValue = aSysVarValue;
	}

	public void setSchema(LNPSysVarSchema aLNPSysVarSchema)
	{
		sysVar = aLNPSysVarSchema.getSysVar();
		sysVarType = aLNPSysVarSchema.getSysVarType();
		sysVarValue = aLNPSysVarSchema.getSysVarValue();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("SysVar") == null)
				sysVar = null;
			else
				sysVar = rs.getString("SysVar").trim();
			if (rs.getString("SysVarType") == null)
				sysVarType = null;
			else
				sysVarType = rs.getString("SysVarType").trim();
			if (rs.getString("SysVarValue") == null)
				sysVarValue = null;
			else
				sysVarValue = rs.getString("SysVarValue").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPSysVar���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPSysVarSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPSysVarSchema getSchema()
	{
		LNPSysVarSchema aLNPSysVarSchema = new LNPSysVarSchema();
		aLNPSysVarSchema.setSchema(this);
		return aLNPSysVarSchema;
	}

	public LNPSysVarDB getDB()
	{
		LNPSysVarDB aDBOper = new LNPSysVarDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(sysVar));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sysVarType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sysVarValue));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			sysVar = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			sysVarType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			sysVarValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPSysVarSchema";
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
		if (FCode.equalsIgnoreCase("sysVar"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sysVar));
		if (FCode.equalsIgnoreCase("sysVarType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sysVarType));
		if (FCode.equalsIgnoreCase("sysVarValue"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sysVarValue));
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
			strFieldValue = StrTool.GBKToUnicode(sysVar);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(sysVarType);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(sysVarValue);
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
		if (FCode.equalsIgnoreCase("sysVar"))
			if (FValue != null && !FValue.equals(""))
				sysVar = FValue.trim();
			else
				sysVar = null;
		if (FCode.equalsIgnoreCase("sysVarType"))
			if (FValue != null && !FValue.equals(""))
				sysVarType = FValue.trim();
			else
				sysVarType = null;
		if (FCode.equalsIgnoreCase("sysVarValue"))
			if (FValue != null && !FValue.equals(""))
				sysVarValue = FValue.trim();
			else
				sysVarValue = null;
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
		LNPSysVarSchema other = (LNPSysVarSchema)otherObject;
		if (sysVar == null && other.getSysVar() != null)
			return false;
		if (sysVar != null && !sysVar.equals(other.getSysVar()))
			return false;
		if (sysVarType == null && other.getSysVarType() != null)
			return false;
		if (sysVarType != null && !sysVarType.equals(other.getSysVarType()))
			return false;
		if (sysVarValue == null && other.getSysVarValue() != null)
			return false;
		return sysVarValue == null || sysVarValue.equals(other.getSysVarValue());
	}

	public int getFieldCount()
	{
		return 3;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("sysVar"))
			return 0;
		if (strFieldName.equals("sysVarType"))
			return 1;
		return !strFieldName.equals("sysVarValue") ? -1 : 2;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "sysVar";
			break;

		case 1: // '\001'
			strFieldName = "sysVarType";
			break;

		case 2: // '\002'
			strFieldName = "sysVarValue";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("sysVar"))
			return 0;
		if (strFieldName.equals("sysVarType"))
			return 0;
		return !strFieldName.equals("sysVarValue") ? -1 : 0;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
