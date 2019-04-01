// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MCodeSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MCodeDB;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MCodeSchema
	implements Schema, Cloneable
{

	private String codeType;
	private String code;
	private String codeName;
	private String codeAlias;
	private String comCode;
	private String otherSign;
	private int codeOrder;
	public static final int FIELDNUM = 7;
	private static String PK[];
	public CErrors mErrors;

	public MCodeSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[0];
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MCodeSchema cloned = (MCodeSchema)super.clone();
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

	public int getCodeOrder()
	{
		return codeOrder;
	}

	public void setCodeOrder(int aCodeOrder)
	{
		codeOrder = aCodeOrder;
	}

	public void setCodeOrder(String aCodeOrder)
	{
		if (aCodeOrder != null && !aCodeOrder.equals(""))
		{
			Integer tInteger = new Integer(aCodeOrder);
			int i = tInteger.intValue();
			codeOrder = i;
		}
	}

	public void setSchema(MCodeSchema aMCodeSchema)
	{
		codeType = aMCodeSchema.getCodeType();
		code = aMCodeSchema.getCode();
		codeName = aMCodeSchema.getCodeName();
		codeAlias = aMCodeSchema.getCodeAlias();
		comCode = aMCodeSchema.getComCode();
		otherSign = aMCodeSchema.getOtherSign();
		codeOrder = aMCodeSchema.getCodeOrder();
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
			codeOrder = rs.getInt("CodeOrder");
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MCode表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MCodeSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MCodeSchema getSchema()
	{
		MCodeSchema aMCodeSchema = new MCodeSchema();
		aMCodeSchema.setSchema(this);
		return aMCodeSchema;
	}

	public MCodeDB getDB()
	{
		MCodeDB aDBOper = new MCodeDB();
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
		strReturn.append("|");
		strReturn.append(ChgData.chgData(codeOrder));
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
			codeOrder = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).intValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MCodeSchema";
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
		if (FCode.equalsIgnoreCase("codeOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(codeOrder));
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

		case 6: // '\006'
			strFieldValue = String.valueOf(codeOrder);
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
		if (FCode.equalsIgnoreCase("codeOrder") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			codeOrder = i;
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
		MCodeSchema other = (MCodeSchema)otherObject;
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
		if (otherSign != null && !otherSign.equals(other.getOtherSign()))
			return false;
		return codeOrder == other.getCodeOrder();
	}

	public int getFieldCount()
	{
		return 7;
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
		if (strFieldName.equals("otherSign"))
			return 5;
		return !strFieldName.equals("codeOrder") ? -1 : 6;
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

		case 6: // '\006'
			strFieldName = "codeOrder";
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
		if (strFieldName.equals("otherSign"))
			return 0;
		return !strFieldName.equals("codeOrder") ? -1 : 3;
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
			nFieldType = 3;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
