// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCodeSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPCodeDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPCodeSchema
	implements Schema, Cloneable
{

	private String codeType;
	private String code;
	private String codeName;
	private String codeAlias;
	private String comCode;
	private String otherSign;
	public static final int FIELDNUM = 6;
	private static String PK[];
	public CErrors mErrors;

	public LNPCodeSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "CodeType";
		pk[1] = "Code";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPCodeSchema cloned = (LNPCodeSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getCodeType()
	{
		return codeType;
	}

	public void setCodeType(String aCodeType)
	{
		codeType = aCodeType;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String aCode)
	{
		code = aCode;
	}

	public String getCodeName()
	{
		return codeName;
	}

	public void setCodeName(String aCodeName)
	{
		codeName = aCodeName;
	}

	public String getCodeAlias()
	{
		return codeAlias;
	}

	public void setCodeAlias(String aCodeAlias)
	{
		codeAlias = aCodeAlias;
	}

	public String getComCode()
	{
		return comCode;
	}

	public void setComCode(String aComCode)
	{
		comCode = aComCode;
	}

	public String getOtherSign()
	{
		return otherSign;
	}

	public void setOtherSign(String aOtherSign)
	{
		otherSign = aOtherSign;
	}

	public void setSchema(LNPCodeSchema aLNPCodeSchema)
	{
		codeType = aLNPCodeSchema.getCodeType();
		code = aLNPCodeSchema.getCode();
		codeName = aLNPCodeSchema.getCodeName();
		codeAlias = aLNPCodeSchema.getCodeAlias();
		comCode = aLNPCodeSchema.getComCode();
		otherSign = aLNPCodeSchema.getOtherSign();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("CodeType") == null)
				codeType = null;
			else
				codeType = rs.getString("CodeType").trim();
			if (rs.getString("Code") == null)
				code = null;
			else
				code = rs.getString("Code").trim();
			if (rs.getString("CodeName") == null)
				codeName = null;
			else
				codeName = rs.getString("CodeName").trim();
			if (rs.getString("CodeAlias") == null)
				codeAlias = null;
			else
				codeAlias = rs.getString("CodeAlias").trim();
			if (rs.getString("ComCode") == null)
				comCode = null;
			else
				comCode = rs.getString("ComCode").trim();
			if (rs.getString("OtherSign") == null)
				otherSign = null;
			else
				otherSign = rs.getString("OtherSign").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPCode表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPCodeSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPCodeSchema getSchema()
	{
		LNPCodeSchema aLNPCodeSchema = new LNPCodeSchema();
		aLNPCodeSchema.setSchema(this);
		return aLNPCodeSchema;
	}

	public LNPCodeDB getDB()
	{
		LNPCodeDB aDBOper = new LNPCodeDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(codeType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(code));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(codeName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(codeAlias));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(comCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(otherSign));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			codeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			codeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			codeAlias = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			comCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			otherSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCodeSchema";
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
		if (FCode.equalsIgnoreCase("codeType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(codeType));
		if (FCode.equalsIgnoreCase("code"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(code));
		if (FCode.equalsIgnoreCase("codeName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(codeName));
		if (FCode.equalsIgnoreCase("codeAlias"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(codeAlias));
		if (FCode.equalsIgnoreCase("comCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comCode));
		if (FCode.equalsIgnoreCase("otherSign"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(otherSign));
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
			strFieldValue = StrTool.GBKToUnicode(codeType);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(code);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(codeName);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(codeAlias);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(comCode);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(otherSign);
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
		if (FCode.equalsIgnoreCase("codeType"))
			if (FValue != null && !FValue.equals(""))
				codeType = FValue.trim();
			else
				codeType = null;
		if (FCode.equalsIgnoreCase("code"))
			if (FValue != null && !FValue.equals(""))
				code = FValue.trim();
			else
				code = null;
		if (FCode.equalsIgnoreCase("codeName"))
			if (FValue != null && !FValue.equals(""))
				codeName = FValue.trim();
			else
				codeName = null;
		if (FCode.equalsIgnoreCase("codeAlias"))
			if (FValue != null && !FValue.equals(""))
				codeAlias = FValue.trim();
			else
				codeAlias = null;
		if (FCode.equalsIgnoreCase("comCode"))
			if (FValue != null && !FValue.equals(""))
				comCode = FValue.trim();
			else
				comCode = null;
		if (FCode.equalsIgnoreCase("otherSign"))
			if (FValue != null && !FValue.equals(""))
				otherSign = FValue.trim();
			else
				otherSign = null;
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
		LNPCodeSchema other = (LNPCodeSchema)otherObject;
		if (codeType == null && other.getCodeType() != null)
			return false;
		if (codeType != null && !codeType.equals(other.getCodeType()))
			return false;
		if (code == null && other.getCode() != null)
			return false;
		if (code != null && !code.equals(other.getCode()))
			return false;
		if (codeName == null && other.getCodeName() != null)
			return false;
		if (codeName != null && !codeName.equals(other.getCodeName()))
			return false;
		if (codeAlias == null && other.getCodeAlias() != null)
			return false;
		if (codeAlias != null && !codeAlias.equals(other.getCodeAlias()))
			return false;
		if (comCode == null && other.getComCode() != null)
			return false;
		if (comCode != null && !comCode.equals(other.getComCode()))
			return false;
		if (otherSign == null && other.getOtherSign() != null)
			return false;
		return otherSign == null || otherSign.equals(other.getOtherSign());
	}

	public int getFieldCount()
	{
		return 6;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("codeType"))
			return 0;
		if (strFieldName.equals("code"))
			return 1;
		if (strFieldName.equals("codeName"))
			return 2;
		if (strFieldName.equals("codeAlias"))
			return 3;
		if (strFieldName.equals("comCode"))
			return 4;
		return !strFieldName.equals("otherSign") ? -1 : 5;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "codeType";
			break;

		case 1: // '\001'
			strFieldName = "code";
			break;

		case 2: // '\002'
			strFieldName = "codeName";
			break;

		case 3: // '\003'
			strFieldName = "codeAlias";
			break;

		case 4: // '\004'
			strFieldName = "comCode";
			break;

		case 5: // '\005'
			strFieldName = "otherSign";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("codeType"))
			return 0;
		if (strFieldName.equals("code"))
			return 0;
		if (strFieldName.equals("codeName"))
			return 0;
		if (strFieldName.equals("codeAlias"))
			return 0;
		if (strFieldName.equals("comCode"))
			return 0;
		return !strFieldName.equals("otherSign") ? -1 : 0;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
