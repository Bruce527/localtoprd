// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyGetRelaSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPDutyGetRelaDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPDutyGetRelaSchema
	implements Schema, Cloneable
{

	private String dutyCode;
	private String getDutyCode;
	private String getDutyName;
	public static final int FIELDNUM = 3;
	private static String PK[];
	public CErrors mErrors;

	public LNPDutyGetRelaSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "DutyCode";
		pk[1] = "GetDutyCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPDutyGetRelaSchema cloned = (LNPDutyGetRelaSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getDutyCode()
	{
		return dutyCode;
	}

	public void setDutyCode(String aDutyCode)
	{
		dutyCode = aDutyCode;
	}

	public String getGetDutyCode()
	{
		return getDutyCode;
	}

	public void setGetDutyCode(String aGetDutyCode)
	{
		getDutyCode = aGetDutyCode;
	}

	public String getGetDutyName()
	{
		return getDutyName;
	}

	public void setGetDutyName(String aGetDutyName)
	{
		getDutyName = aGetDutyName;
	}

	public void setSchema(LNPDutyGetRelaSchema aLNPDutyGetRelaSchema)
	{
		dutyCode = aLNPDutyGetRelaSchema.getDutyCode();
		getDutyCode = aLNPDutyGetRelaSchema.getGetDutyCode();
		getDutyName = aLNPDutyGetRelaSchema.getGetDutyName();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("DutyCode") == null)
				dutyCode = null;
			else
				dutyCode = rs.getString("DutyCode").trim();
			if (rs.getString("GetDutyCode") == null)
				getDutyCode = null;
			else
				getDutyCode = rs.getString("GetDutyCode").trim();
			if (rs.getString("GetDutyName") == null)
				getDutyName = null;
			else
				getDutyName = rs.getString("GetDutyName").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPDutyGetRela表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetRelaSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPDutyGetRelaSchema getSchema()
	{
		LNPDutyGetRelaSchema aLNPDutyGetRelaSchema = new LNPDutyGetRelaSchema();
		aLNPDutyGetRelaSchema.setSchema(this);
		return aLNPDutyGetRelaSchema;
	}

	public LNPDutyGetRelaDB getDB()
	{
		LNPDutyGetRelaDB aDBOper = new LNPDutyGetRelaDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(dutyCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getDutyCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getDutyName));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			dutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			getDutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			getDutyName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetRelaSchema";
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
		if (FCode.equalsIgnoreCase("dutyCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dutyCode));
		if (FCode.equalsIgnoreCase("getDutyCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDutyCode));
		if (FCode.equalsIgnoreCase("getDutyName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDutyName));
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
			strFieldValue = StrTool.GBKToUnicode(dutyCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(getDutyCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(getDutyName);
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
		if (FCode.equalsIgnoreCase("dutyCode"))
			if (FValue != null && !FValue.equals(""))
				dutyCode = FValue.trim();
			else
				dutyCode = null;
		if (FCode.equalsIgnoreCase("getDutyCode"))
			if (FValue != null && !FValue.equals(""))
				getDutyCode = FValue.trim();
			else
				getDutyCode = null;
		if (FCode.equalsIgnoreCase("getDutyName"))
			if (FValue != null && !FValue.equals(""))
				getDutyName = FValue.trim();
			else
				getDutyName = null;
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
		LNPDutyGetRelaSchema other = (LNPDutyGetRelaSchema)otherObject;
		if (dutyCode == null && other.getDutyCode() != null)
			return false;
		if (dutyCode != null && !dutyCode.equals(other.getDutyCode()))
			return false;
		if (getDutyCode == null && other.getGetDutyCode() != null)
			return false;
		if (getDutyCode != null && !getDutyCode.equals(other.getGetDutyCode()))
			return false;
		if (getDutyName == null && other.getGetDutyName() != null)
			return false;
		return getDutyName == null || getDutyName.equals(other.getGetDutyName());
	}

	public int getFieldCount()
	{
		return 3;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("dutyCode"))
			return 0;
		if (strFieldName.equals("getDutyCode"))
			return 1;
		return !strFieldName.equals("getDutyName") ? -1 : 2;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "dutyCode";
			break;

		case 1: // '\001'
			strFieldName = "getDutyCode";
			break;

		case 2: // '\002'
			strFieldName = "getDutyName";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("dutyCode"))
			return 0;
		if (strFieldName.equals("getDutyCode"))
			return 0;
		return !strFieldName.equals("getDutyName") ? -1 : 0;
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
