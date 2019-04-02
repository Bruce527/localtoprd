// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPUWQuestionSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPUWQuestionDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPUWQuestionSchema
	implements Schema, Cloneable
{

	private String contNo;
	private String uRL;
	public static final int FIELDNUM = 2;
	private static String PK[];
	public CErrors mErrors;

	public LNPUWQuestionSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ContNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPUWQuestionSchema cloned = (LNPUWQuestionSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String aContNo)
	{
		contNo = aContNo;
	}

	public String getURL()
	{
		return uRL;
	}

	public void setURL(String aURL)
	{
		uRL = aURL;
	}

	public void setSchema(LNPUWQuestionSchema aLNPUWQuestionSchema)
	{
		contNo = aLNPUWQuestionSchema.getContNo();
		uRL = aLNPUWQuestionSchema.getURL();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ContNo") == null)
				contNo = null;
			else
				contNo = rs.getString("ContNo").trim();
			if (rs.getString("URL") == null)
				uRL = null;
			else
				uRL = rs.getString("URL").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPUWQuestion????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPUWQuestionSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPUWQuestionSchema getSchema()
	{
		LNPUWQuestionSchema aLNPUWQuestionSchema = new LNPUWQuestionSchema();
		aLNPUWQuestionSchema.setSchema(this);
		return aLNPUWQuestionSchema;
	}

	public LNPUWQuestionDB getDB()
	{
		LNPUWQuestionDB aDBOper = new LNPUWQuestionDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(contNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uRL));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPUWQuestionSchema";
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
		if (FCode.equalsIgnoreCase("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equalsIgnoreCase("uRL"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uRL));
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
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(uRL);
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
		if (FCode.equalsIgnoreCase("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equalsIgnoreCase("uRL"))
			if (FValue != null && !FValue.equals(""))
				uRL = FValue.trim();
			else
				uRL = null;
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
		LNPUWQuestionSchema other = (LNPUWQuestionSchema)otherObject;
		if (contNo == null && other.getContNo() != null)
			return false;
		if (contNo != null && !contNo.equals(other.getContNo()))
			return false;
		if (uRL == null && other.getURL() != null)
			return false;
		return uRL == null || uRL.equals(other.getURL());
	}

	public int getFieldCount()
	{
		return 2;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("contNo"))
			return 0;
		return !strFieldName.equals("uRL") ? -1 : 1;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "contNo";
			break;

		case 1: // '\001'
			strFieldName = "uRL";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("contNo"))
			return 0;
		return !strFieldName.equals("uRL") ? -1 : 0;
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
