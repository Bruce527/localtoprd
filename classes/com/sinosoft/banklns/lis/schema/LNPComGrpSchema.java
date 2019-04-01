// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPComGrpSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPComGrpDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPComGrpSchema
	implements Schema, Cloneable
{

	private String comGrpCode;
	private String comGrpName;
	private String comGrpDescription;
	private String comSign;
	private String comGrpType;
	private String operator;
	private Date makeDate;
	private String makeTime;
	public static final int FIELDNUM = 8;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPComGrpSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ComGrpCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPComGrpSchema cloned = (LNPComGrpSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
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

	public String getComGrpName()
	{
		return comGrpName;
	}

	public void setComGrpName(String aComGrpName)
	{
		comGrpName = aComGrpName;
	}

	public String getComGrpDescription()
	{
		return comGrpDescription;
	}

	public void setComGrpDescription(String aComGrpDescription)
	{
		comGrpDescription = aComGrpDescription;
	}

	public String getComSign()
	{
		return comSign;
	}

	public void setComSign(String aComSign)
	{
		comSign = aComSign;
	}

	public String getComGrpType()
	{
		return comGrpType;
	}

	public void setComGrpType(String aComGrpType)
	{
		comGrpType = aComGrpType;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public String getMakeDate()
	{
		if (makeDate != null)
			return fDate.getString(makeDate);
		else
			return null;
	}

	public void setMakeDate(Date aMakeDate)
	{
		makeDate = aMakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals(""))
			makeDate = fDate.getDate(aMakeDate);
		else
			makeDate = null;
	}

	public String getMakeTime()
	{
		return makeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		makeTime = aMakeTime;
	}

	public void setSchema(LNPComGrpSchema aLNPComGrpSchema)
	{
		comGrpCode = aLNPComGrpSchema.getComGrpCode();
		comGrpName = aLNPComGrpSchema.getComGrpName();
		comGrpDescription = aLNPComGrpSchema.getComGrpDescription();
		comSign = aLNPComGrpSchema.getComSign();
		comGrpType = aLNPComGrpSchema.getComGrpType();
		operator = aLNPComGrpSchema.getOperator();
		makeDate = fDate.getDate(aLNPComGrpSchema.getMakeDate());
		makeTime = aLNPComGrpSchema.getMakeTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ComGrpCode") == null)
				comGrpCode = null;
			else
				comGrpCode = rs.getString("ComGrpCode").trim();
			if (rs.getString("ComGrpName") == null)
				comGrpName = null;
			else
				comGrpName = rs.getString("ComGrpName").trim();
			if (rs.getString("ComGrpDescription") == null)
				comGrpDescription = null;
			else
				comGrpDescription = rs.getString("ComGrpDescription").trim();
			if (rs.getString("ComSign") == null)
				comSign = null;
			else
				comSign = rs.getString("ComSign").trim();
			if (rs.getString("ComGrpType") == null)
				comGrpType = null;
			else
				comGrpType = rs.getString("ComGrpType").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			makeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("MakeTime").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPComGrp表字段个数和Schema中的字段个数不一致，或�?�执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPComGrpSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPComGrpSchema getSchema()
	{
		LNPComGrpSchema aLNPComGrpSchema = new LNPComGrpSchema();
		aLNPComGrpSchema.setSchema(this);
		return aLNPComGrpSchema;
	}

	public LNPComGrpDB getDB()
	{
		LNPComGrpDB aDBOper = new LNPComGrpDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(comGrpCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(comGrpName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(comGrpDescription));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(comSign));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(comGrpType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			comGrpCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			comGrpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			comGrpDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			comSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			comGrpType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPComGrpSchema";
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
		if (FCode.equalsIgnoreCase("comGrpName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comGrpName));
		if (FCode.equalsIgnoreCase("comGrpDescription"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comGrpDescription));
		if (FCode.equalsIgnoreCase("comSign"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comSign));
		if (FCode.equalsIgnoreCase("comGrpType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comGrpType));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
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
			strFieldValue = StrTool.GBKToUnicode(comGrpName);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(comGrpDescription);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(comSign);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(comGrpType);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
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
		if (FCode.equalsIgnoreCase("comGrpName"))
			if (FValue != null && !FValue.equals(""))
				comGrpName = FValue.trim();
			else
				comGrpName = null;
		if (FCode.equalsIgnoreCase("comGrpDescription"))
			if (FValue != null && !FValue.equals(""))
				comGrpDescription = FValue.trim();
			else
				comGrpDescription = null;
		if (FCode.equalsIgnoreCase("comSign"))
			if (FValue != null && !FValue.equals(""))
				comSign = FValue.trim();
			else
				comSign = null;
		if (FCode.equalsIgnoreCase("comGrpType"))
			if (FValue != null && !FValue.equals(""))
				comGrpType = FValue.trim();
			else
				comGrpType = null;
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equalsIgnoreCase("makeDate"))
			if (FValue != null && !FValue.equals(""))
				makeDate = fDate.getDate(FValue);
			else
				makeDate = null;
		if (FCode.equalsIgnoreCase("makeTime"))
			if (FValue != null && !FValue.equals(""))
				makeTime = FValue.trim();
			else
				makeTime = null;
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
		LNPComGrpSchema other = (LNPComGrpSchema)otherObject;
		if (comGrpCode == null && other.getComGrpCode() != null)
			return false;
		if (comGrpCode != null && !comGrpCode.equals(other.getComGrpCode()))
			return false;
		if (comGrpName == null && other.getComGrpName() != null)
			return false;
		if (comGrpName != null && !comGrpName.equals(other.getComGrpName()))
			return false;
		if (comGrpDescription == null && other.getComGrpDescription() != null)
			return false;
		if (comGrpDescription != null && !comGrpDescription.equals(other.getComGrpDescription()))
			return false;
		if (comSign == null && other.getComSign() != null)
			return false;
		if (comSign != null && !comSign.equals(other.getComSign()))
			return false;
		if (comGrpType == null && other.getComGrpType() != null)
			return false;
		if (comGrpType != null && !comGrpType.equals(other.getComGrpType()))
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (makeDate == null && other.getMakeDate() != null)
			return false;
		if (makeDate != null && !fDate.getString(makeDate).equals(other.getMakeDate()))
			return false;
		if (makeTime == null && other.getMakeTime() != null)
			return false;
		return makeTime == null || makeTime.equals(other.getMakeTime());
	}

	public int getFieldCount()
	{
		return 8;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("comGrpCode"))
			return 0;
		if (strFieldName.equals("comGrpName"))
			return 1;
		if (strFieldName.equals("comGrpDescription"))
			return 2;
		if (strFieldName.equals("comSign"))
			return 3;
		if (strFieldName.equals("comGrpType"))
			return 4;
		if (strFieldName.equals("operator"))
			return 5;
		if (strFieldName.equals("makeDate"))
			return 6;
		return !strFieldName.equals("makeTime") ? -1 : 7;
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
			strFieldName = "comGrpName";
			break;

		case 2: // '\002'
			strFieldName = "comGrpDescription";
			break;

		case 3: // '\003'
			strFieldName = "comSign";
			break;

		case 4: // '\004'
			strFieldName = "comGrpType";
			break;

		case 5: // '\005'
			strFieldName = "operator";
			break;

		case 6: // '\006'
			strFieldName = "makeDate";
			break;

		case 7: // '\007'
			strFieldName = "makeTime";
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
		if (strFieldName.equals("comGrpName"))
			return 0;
		if (strFieldName.equals("comGrpDescription"))
			return 0;
		if (strFieldName.equals("comSign"))
			return 0;
		if (strFieldName.equals("comGrpType"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		return !strFieldName.equals("makeTime") ? -1 : 0;
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

		case 5: // '\005'
			nFieldType = 0;
			break;

		case 6: // '\006'
			nFieldType = 1;
			break;

		case 7: // '\007'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
