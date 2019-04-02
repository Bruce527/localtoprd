// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPMaxNoSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPMaxNoDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPMaxNoSchema
	implements Schema, Cloneable
{

	private String noType;
	private String noLimit;
	private int maxNo;
	public static final int FIELDNUM = 3;
	private static String PK[];
	public CErrors mErrors;

	public LNPMaxNoSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "NoType";
		pk[1] = "NoLimit";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPMaxNoSchema cloned = (LNPMaxNoSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getNoType()
	{
		return noType;
	}

	public void setNoType(String aNoType)
	{
		noType = aNoType;
	}

	public String getNoLimit()
	{
		return noLimit;
	}

	public void setNoLimit(String aNoLimit)
	{
		noLimit = aNoLimit;
	}

	public int getMaxNo()
	{
		return maxNo;
	}

	public void setMaxNo(int aMaxNo)
	{
		maxNo = aMaxNo;
	}

	public void setMaxNo(String aMaxNo)
	{
		if (aMaxNo != null && !aMaxNo.equals(""))
		{
			Integer tInteger = new Integer(aMaxNo);
			int i = tInteger.intValue();
			maxNo = i;
		}
	}

	public void setSchema(LNPMaxNoSchema aLNPMaxNoSchema)
	{
		noType = aLNPMaxNoSchema.getNoType();
		noLimit = aLNPMaxNoSchema.getNoLimit();
		maxNo = aLNPMaxNoSchema.getMaxNo();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("NoType") == null)
				noType = null;
			else
				noType = rs.getString("NoType").trim();
			if (rs.getString("NoLimit") == null)
				noLimit = null;
			else
				noLimit = rs.getString("NoLimit").trim();
			maxNo = rs.getInt("MaxNo");
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPMaxNo????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPMaxNoSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPMaxNoSchema getSchema()
	{
		LNPMaxNoSchema aLNPMaxNoSchema = new LNPMaxNoSchema();
		aLNPMaxNoSchema.setSchema(this);
		return aLNPMaxNoSchema;
	}

	public LNPMaxNoDB getDB()
	{
		LNPMaxNoDB aDBOper = new LNPMaxNoDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(noType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(noLimit));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(maxNo));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			noType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			noLimit = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			maxNo = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 3, "|")))).intValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPMaxNoSchema";
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
		if (FCode.equalsIgnoreCase("noType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(noType));
		if (FCode.equalsIgnoreCase("noLimit"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(noLimit));
		if (FCode.equalsIgnoreCase("maxNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(maxNo));
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
			strFieldValue = StrTool.GBKToUnicode(noType);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(noLimit);
			break;

		case 2: // '\002'
			strFieldValue = String.valueOf(maxNo);
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
		if (FCode.equalsIgnoreCase("noType"))
			if (FValue != null && !FValue.equals(""))
				noType = FValue.trim();
			else
				noType = null;
		if (FCode.equalsIgnoreCase("noLimit"))
			if (FValue != null && !FValue.equals(""))
				noLimit = FValue.trim();
			else
				noLimit = null;
		if (FCode.equalsIgnoreCase("maxNo") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			maxNo = i;
		}
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
		LNPMaxNoSchema other = (LNPMaxNoSchema)otherObject;
		if (noType == null && other.getNoType() != null)
			return false;
		if (noType != null && !noType.equals(other.getNoType()))
			return false;
		if (noLimit == null && other.getNoLimit() != null)
			return false;
		if (noLimit != null && !noLimit.equals(other.getNoLimit()))
			return false;
		return maxNo == other.getMaxNo();
	}

	public int getFieldCount()
	{
		return 3;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("noType"))
			return 0;
		if (strFieldName.equals("noLimit"))
			return 1;
		return !strFieldName.equals("maxNo") ? -1 : 2;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "noType";
			break;

		case 1: // '\001'
			strFieldName = "noLimit";
			break;

		case 2: // '\002'
			strFieldName = "maxNo";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("noType"))
			return 0;
		if (strFieldName.equals("noLimit"))
			return 0;
		return !strFieldName.equals("maxNo") ? -1 : 3;
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
			nFieldType = 3;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
