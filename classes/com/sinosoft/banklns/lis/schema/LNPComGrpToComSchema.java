// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPComGrpToComSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPComGrpToComDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPComGrpToComSchema
	implements Schema, Cloneable
{

	private String comGrpCode;
	private String comCode;
	private String comCodeType;
	public static final int FIELDNUM = 3;
	private static String PK[];
	public CErrors mErrors;

	public LNPComGrpToComSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "ComGrpCode";
		pk[1] = "ComCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPComGrpToComSchema cloned = (LNPComGrpToComSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getComGrpCode()
	{
		return comGrpCode;
	}

	public void setComGrpCode(String aComGrpCode)
	{
		comGrpCode = aComGrpCode;
	}

	public String getComCode()
	{
		return comCode;
	}

	public void setComCode(String aComCode)
	{
		comCode = aComCode;
	}

	public String getComCodeType()
	{
		return comCodeType;
	}

	public void setComCodeType(String aComCodeType)
	{
		comCodeType = aComCodeType;
	}

	public void setSchema(LNPComGrpToComSchema aLNPComGrpToComSchema)
	{
		comGrpCode = aLNPComGrpToComSchema.getComGrpCode();
		comCode = aLNPComGrpToComSchema.getComCode();
		comCodeType = aLNPComGrpToComSchema.getComCodeType();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ComGrpCode") == null)
				comGrpCode = null;
			else
				comGrpCode = rs.getString("ComGrpCode").trim();
			if (rs.getString("ComCode") == null)
				comCode = null;
			else
				comCode = rs.getString("ComCode").trim();
			if (rs.getString("ComCodeType") == null)
				comCodeType = null;
			else
				comCodeType = rs.getString("ComCodeType").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPComGrpToCom表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPComGrpToComSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPComGrpToComSchema getSchema()
	{
		LNPComGrpToComSchema aLNPComGrpToComSchema = new LNPComGrpToComSchema();
		aLNPComGrpToComSchema.setSchema(this);
		return aLNPComGrpToComSchema;
	}

	public LNPComGrpToComDB getDB()
	{
		LNPComGrpToComDB aDBOper = new LNPComGrpToComDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(comGrpCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(comCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(comCodeType));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			comGrpCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			comCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			comCodeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPComGrpToComSchema";
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
		if (FCode.equalsIgnoreCase("comGrpCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comGrpCode));
		if (FCode.equalsIgnoreCase("comCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comCode));
		if (FCode.equalsIgnoreCase("comCodeType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comCodeType));
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
			strFieldValue = StrTool.GBKToUnicode(comGrpCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(comCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(comCodeType);
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
		if (FCode.equalsIgnoreCase("comGrpCode"))
			if (FValue != null && !FValue.equals(""))
				comGrpCode = FValue.trim();
			else
				comGrpCode = null;
		if (FCode.equalsIgnoreCase("comCode"))
			if (FValue != null && !FValue.equals(""))
				comCode = FValue.trim();
			else
				comCode = null;
		if (FCode.equalsIgnoreCase("comCodeType"))
			if (FValue != null && !FValue.equals(""))
				comCodeType = FValue.trim();
			else
				comCodeType = null;
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
		LNPComGrpToComSchema other = (LNPComGrpToComSchema)otherObject;
		if (comGrpCode == null && other.getComGrpCode() != null)
			return false;
		if (comGrpCode != null && !comGrpCode.equals(other.getComGrpCode()))
			return false;
		if (comCode == null && other.getComCode() != null)
			return false;
		if (comCode != null && !comCode.equals(other.getComCode()))
			return false;
		if (comCodeType == null && other.getComCodeType() != null)
			return false;
		return comCodeType == null || comCodeType.equals(other.getComCodeType());
	}

	public int getFieldCount()
	{
		return 3;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("comGrpCode"))
			return 0;
		if (strFieldName.equals("comCode"))
			return 1;
		return !strFieldName.equals("comCodeType") ? -1 : 2;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "comGrpCode";
			break;

		case 1: // '\001'
			strFieldName = "comCode";
			break;

		case 2: // '\002'
			strFieldName = "comCodeType";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("comGrpCode"))
			return 0;
		if (strFieldName.equals("comCode"))
			return 0;
		return !strFieldName.equals("comCodeType") ? -1 : 0;
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
