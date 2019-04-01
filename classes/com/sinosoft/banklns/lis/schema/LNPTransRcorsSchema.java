// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPTransRcorsSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPTransRcorsDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPTransRcorsSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
	private String ContNo;
	private String Operator;
	private Date MakeDate;
	private String MakeTime;
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	public static final int FIELDNUM = 10;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPTransRcorsSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "EdorNo";
		pk[1] = "serialNo";
		PK = pk;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getEdorNo()
	{
		if (EdorNo != null)
			EdorNo.equals("");
		return EdorNo;
	}

	public void setEdorNo(String aEdorNo)
	{
		EdorNo = aEdorNo;
	}

	public String getserialNo()
	{
		if (serialNo != null)
			serialNo.equals("");
		return serialNo;
	}

	public void setserialNo(String aserialNo)
	{
		serialNo = aserialNo;
	}

	public String getContNo()
	{
		if (ContNo != null)
			ContNo.equals("");
		return ContNo;
	}

	public void setContNo(String aContNo)
	{
		ContNo = aContNo;
	}

	public String getOperator()
	{
		if (Operator != null)
			Operator.equals("");
		return Operator;
	}

	public void setOperator(String aOperator)
	{
		Operator = aOperator;
	}

	public String getMakeDate()
	{
		if (MakeDate != null)
			return fDate.getString(MakeDate);
		else
			return null;
	}

	public void setMakeDate(Date aMakeDate)
	{
		MakeDate = aMakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals(""))
			MakeDate = fDate.getDate(aMakeDate);
		else
			MakeDate = null;
	}

	public String getMakeTime()
	{
		if (MakeTime != null)
			MakeTime.equals("");
		return MakeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		MakeTime = aMakeTime;
	}

	public String getp1()
	{
		if (p1 != null)
			p1.equals("");
		return p1;
	}

	public void setp1(String ap1)
	{
		p1 = ap1;
	}

	public String getp2()
	{
		if (p2 != null)
			p2.equals("");
		return p2;
	}

	public void setp2(String ap2)
	{
		p2 = ap2;
	}

	public String getp3()
	{
		if (p3 != null)
			p3.equals("");
		return p3;
	}

	public void setp3(String ap3)
	{
		p3 = ap3;
	}

	public String getp4()
	{
		if (p4 != null)
			p4.equals("");
		return p4;
	}

	public void setp4(String ap4)
	{
		p4 = ap4;
	}

	public void setSchema(LNPTransRcorsSchema aLNPTransRcorsSchema)
	{
		EdorNo = aLNPTransRcorsSchema.getEdorNo();
		serialNo = aLNPTransRcorsSchema.getserialNo();
		ContNo = aLNPTransRcorsSchema.getContNo();
		Operator = aLNPTransRcorsSchema.getOperator();
		MakeDate = fDate.getDate(aLNPTransRcorsSchema.getMakeDate());
		MakeTime = aLNPTransRcorsSchema.getMakeTime();
		p1 = aLNPTransRcorsSchema.getp1();
		p2 = aLNPTransRcorsSchema.getp2();
		p3 = aLNPTransRcorsSchema.getp3();
		p4 = aLNPTransRcorsSchema.getp4();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("EdorNo") == null)
				EdorNo = null;
			else
				EdorNo = rs.getString("EdorNo").trim();
			if (rs.getString("serialNo") == null)
				serialNo = null;
			else
				serialNo = rs.getString("serialNo").trim();
			if (rs.getString("ContNo") == null)
				ContNo = null;
			else
				ContNo = rs.getString("ContNo").trim();
			if (rs.getString("Operator") == null)
				Operator = null;
			else
				Operator = rs.getString("Operator").trim();
			MakeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				MakeTime = null;
			else
				MakeTime = rs.getString("MakeTime").trim();
			if (rs.getString("p1") == null)
				p1 = null;
			else
				p1 = rs.getString("p1").trim();
			if (rs.getString("p2") == null)
				p2 = null;
			else
				p2 = rs.getString("p2").trim();
			if (rs.getString("p3") == null)
				p3 = null;
			else
				p3 = rs.getString("p3").trim();
			if (rs.getString("p4") == null)
				p4 = null;
			else
				p4 = rs.getString("p4").trim();
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPTransRcorsSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPTransRcorsSchema getSchema()
	{
		LNPTransRcorsSchema aLNPTransRcorsSchema = new LNPTransRcorsSchema();
		aLNPTransRcorsSchema.setSchema(this);
		return aLNPTransRcorsSchema;
	}

	public LNPTransRcorsDB getDB()
	{
		LNPTransRcorsDB aDBOper = new LNPTransRcorsDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(MakeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MakeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p4))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPTransRcorsSchema";
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
		if (FCode.equals("EdorNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(EdorNo));
		if (FCode.equals("serialNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(serialNo));
		if (FCode.equals("ContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ContNo));
		if (FCode.equals("Operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		if (FCode.equals("MakeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equals("MakeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		if (FCode.equals("p1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p1));
		if (FCode.equals("p2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p2));
		if (FCode.equals("p3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p3));
		if (FCode.equals("p4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p4));
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
			strFieldValue = StrTool.GBKToUnicode(EdorNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(serialNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(ContNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(Operator);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(MakeTime);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(p1);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(p2);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(p3);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(p4);
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
		if (FCode.equals("EdorNo"))
			if (FValue != null && !FValue.equals(""))
				EdorNo = FValue.trim();
			else
				EdorNo = null;
		if (FCode.equals("serialNo"))
			if (FValue != null && !FValue.equals(""))
				serialNo = FValue.trim();
			else
				serialNo = null;
		if (FCode.equals("ContNo"))
			if (FValue != null && !FValue.equals(""))
				ContNo = FValue.trim();
			else
				ContNo = null;
		if (FCode.equals("Operator"))
			if (FValue != null && !FValue.equals(""))
				Operator = FValue.trim();
			else
				Operator = null;
		if (FCode.equals("MakeDate"))
			if (FValue != null && !FValue.equals(""))
				MakeDate = fDate.getDate(FValue);
			else
				MakeDate = null;
		if (FCode.equals("MakeTime"))
			if (FValue != null && !FValue.equals(""))
				MakeTime = FValue.trim();
			else
				MakeTime = null;
		if (FCode.equals("p1"))
			if (FValue != null && !FValue.equals(""))
				p1 = FValue.trim();
			else
				p1 = null;
		if (FCode.equals("p2"))
			if (FValue != null && !FValue.equals(""))
				p2 = FValue.trim();
			else
				p2 = null;
		if (FCode.equals("p3"))
			if (FValue != null && !FValue.equals(""))
				p3 = FValue.trim();
			else
				p3 = null;
		if (FCode.equals("p4"))
			if (FValue != null && !FValue.equals(""))
				p4 = FValue.trim();
			else
				p4 = null;
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		LNPTransRcorsSchema other = (LNPTransRcorsSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && ContNo.equals(other.getContNo()) && Operator.equals(other.getOperator()) && fDate.getString(MakeDate).equals(other.getMakeDate()) && MakeTime.equals(other.getMakeTime()) && p1.equals(other.getp1()) && p2.equals(other.getp2()) && p3.equals(other.getp3()) && p4.equals(other.getp4());
	}

	public int getFieldCount()
	{
		return 10;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("ContNo"))
			return 2;
		if (strFieldName.equals("Operator"))
			return 3;
		if (strFieldName.equals("MakeDate"))
			return 4;
		if (strFieldName.equals("MakeTime"))
			return 5;
		if (strFieldName.equals("p1"))
			return 6;
		if (strFieldName.equals("p2"))
			return 7;
		if (strFieldName.equals("p3"))
			return 8;
		return !strFieldName.equals("p4") ? -1 : 9;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "EdorNo";
			break;

		case 1: // '\001'
			strFieldName = "serialNo";
			break;

		case 2: // '\002'
			strFieldName = "ContNo";
			break;

		case 3: // '\003'
			strFieldName = "Operator";
			break;

		case 4: // '\004'
			strFieldName = "MakeDate";
			break;

		case 5: // '\005'
			strFieldName = "MakeTime";
			break;

		case 6: // '\006'
			strFieldName = "p1";
			break;

		case 7: // '\007'
			strFieldName = "p2";
			break;

		case 8: // '\b'
			strFieldName = "p3";
			break;

		case 9: // '\t'
			strFieldName = "p4";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 0;
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("Operator"))
			return 0;
		if (strFieldName.equals("MakeDate"))
			return 1;
		if (strFieldName.equals("MakeTime"))
			return 0;
		if (strFieldName.equals("p1"))
			return 0;
		if (strFieldName.equals("p2"))
			return 0;
		if (strFieldName.equals("p3"))
			return 0;
		return !strFieldName.equals("p4") ? -1 : 0;
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
			nFieldType = 1;
			break;

		case 5: // '\005'
			nFieldType = 0;
			break;

		case 6: // '\006'
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 0;
			break;

		case 9: // '\t'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
