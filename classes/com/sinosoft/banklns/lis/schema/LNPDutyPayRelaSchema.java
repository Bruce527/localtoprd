// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyPayRelaSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPDutyPayRelaDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPDutyPayRelaSchema
	implements Schema, Cloneable
{

	private String dutyCode;
	private String payPlanCode;
	private String payPlanName;
	public static final int FIELDNUM = 3;
	private static String PK[];
	public CErrors mErrors;

	public LNPDutyPayRelaSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "DutyCode";
		pk[1] = "PayPlanCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPDutyPayRelaSchema cloned = (LNPDutyPayRelaSchema)super.clone();
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

	public String getPayPlanCode()
	{
		return payPlanCode;
	}

	public void setPayPlanCode(String aPayPlanCode)
	{
		payPlanCode = aPayPlanCode;
	}

	public String getPayPlanName()
	{
		return payPlanName;
	}

	public void setPayPlanName(String aPayPlanName)
	{
		payPlanName = aPayPlanName;
	}

	public void setSchema(LNPDutyPayRelaSchema aLNPDutyPayRelaSchema)
	{
		dutyCode = aLNPDutyPayRelaSchema.getDutyCode();
		payPlanCode = aLNPDutyPayRelaSchema.getPayPlanCode();
		payPlanName = aLNPDutyPayRelaSchema.getPayPlanName();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("DutyCode") == null)
				dutyCode = null;
			else
				dutyCode = rs.getString("DutyCode").trim();
			if (rs.getString("PayPlanCode") == null)
				payPlanCode = null;
			else
				payPlanCode = rs.getString("PayPlanCode").trim();
			if (rs.getString("PayPlanName") == null)
				payPlanName = null;
			else
				payPlanName = rs.getString("PayPlanName").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPDutyPayRela表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPDutyPayRelaSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPDutyPayRelaSchema getSchema()
	{
		LNPDutyPayRelaSchema aLNPDutyPayRelaSchema = new LNPDutyPayRelaSchema();
		aLNPDutyPayRelaSchema.setSchema(this);
		return aLNPDutyPayRelaSchema;
	}

	public LNPDutyPayRelaDB getDB()
	{
		LNPDutyPayRelaDB aDBOper = new LNPDutyPayRelaDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(dutyCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payPlanCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payPlanName));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			dutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			payPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			payPlanName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPDutyPayRelaSchema";
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
		if (FCode.equalsIgnoreCase("payPlanCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payPlanCode));
		if (FCode.equalsIgnoreCase("payPlanName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payPlanName));
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
			strFieldValue = StrTool.GBKToUnicode(payPlanCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(payPlanName);
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
		if (FCode.equalsIgnoreCase("payPlanCode"))
			if (FValue != null && !FValue.equals(""))
				payPlanCode = FValue.trim();
			else
				payPlanCode = null;
		if (FCode.equalsIgnoreCase("payPlanName"))
			if (FValue != null && !FValue.equals(""))
				payPlanName = FValue.trim();
			else
				payPlanName = null;
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
		LNPDutyPayRelaSchema other = (LNPDutyPayRelaSchema)otherObject;
		if (dutyCode == null && other.getDutyCode() != null)
			return false;
		if (dutyCode != null && !dutyCode.equals(other.getDutyCode()))
			return false;
		if (payPlanCode == null && other.getPayPlanCode() != null)
			return false;
		if (payPlanCode != null && !payPlanCode.equals(other.getPayPlanCode()))
			return false;
		if (payPlanName == null && other.getPayPlanName() != null)
			return false;
		return payPlanName == null || payPlanName.equals(other.getPayPlanName());
	}

	public int getFieldCount()
	{
		return 3;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("dutyCode"))
			return 0;
		if (strFieldName.equals("payPlanCode"))
			return 1;
		return !strFieldName.equals("payPlanName") ? -1 : 2;
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
			strFieldName = "payPlanCode";
			break;

		case 2: // '\002'
			strFieldName = "payPlanName";
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
		if (strFieldName.equals("payPlanCode"))
			return 0;
		return !strFieldName.equals("payPlanName") ? -1 : 0;
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
