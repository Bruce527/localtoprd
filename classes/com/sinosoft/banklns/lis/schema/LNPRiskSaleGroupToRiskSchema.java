// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskSaleGroupToRiskSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskSaleGroupToRiskDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskSaleGroupToRiskSchema
	implements Schema, Cloneable
{

	private String groupCode;
	private String riskCode;
	public static final int FIELDNUM = 2;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskSaleGroupToRiskSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "GroupCode";
		pk[1] = "RiskCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskSaleGroupToRiskSchema cloned = (LNPRiskSaleGroupToRiskSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getGroupCode()
	{
		return groupCode;
	}

	public void setGroupCode(String aGroupCode)
	{
		groupCode = aGroupCode;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String aRiskCode)
	{
		riskCode = aRiskCode;
	}

	public void setSchema(LNPRiskSaleGroupToRiskSchema aLNPRiskSaleGroupToRiskSchema)
	{
		groupCode = aLNPRiskSaleGroupToRiskSchema.getGroupCode();
		riskCode = aLNPRiskSaleGroupToRiskSchema.getRiskCode();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("GroupCode") == null)
				groupCode = null;
			else
				groupCode = rs.getString("GroupCode").trim();
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPRiskSaleGroupToRisk????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskSaleGroupToRiskSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskSaleGroupToRiskSchema getSchema()
	{
		LNPRiskSaleGroupToRiskSchema aLNPRiskSaleGroupToRiskSchema = new LNPRiskSaleGroupToRiskSchema();
		aLNPRiskSaleGroupToRiskSchema.setSchema(this);
		return aLNPRiskSaleGroupToRiskSchema;
	}

	public LNPRiskSaleGroupToRiskDB getDB()
	{
		LNPRiskSaleGroupToRiskDB aDBOper = new LNPRiskSaleGroupToRiskDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(groupCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCode));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			groupCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskSaleGroupToRiskSchema";
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
		if (FCode.equalsIgnoreCase("groupCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(groupCode));
		if (FCode.equalsIgnoreCase("riskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCode));
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
			strFieldValue = StrTool.GBKToUnicode(groupCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(riskCode);
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
		if (FCode.equalsIgnoreCase("groupCode"))
			if (FValue != null && !FValue.equals(""))
				groupCode = FValue.trim();
			else
				groupCode = null;
		if (FCode.equalsIgnoreCase("riskCode"))
			if (FValue != null && !FValue.equals(""))
				riskCode = FValue.trim();
			else
				riskCode = null;
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
		LNPRiskSaleGroupToRiskSchema other = (LNPRiskSaleGroupToRiskSchema)otherObject;
		if (groupCode == null && other.getGroupCode() != null)
			return false;
		if (groupCode != null && !groupCode.equals(other.getGroupCode()))
			return false;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		return riskCode == null || riskCode.equals(other.getRiskCode());
	}

	public int getFieldCount()
	{
		return 2;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("groupCode"))
			return 0;
		return !strFieldName.equals("riskCode") ? -1 : 1;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "groupCode";
			break;

		case 1: // '\001'
			strFieldName = "riskCode";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("groupCode"))
			return 0;
		return !strFieldName.equals("riskCode") ? -1 : 0;
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
