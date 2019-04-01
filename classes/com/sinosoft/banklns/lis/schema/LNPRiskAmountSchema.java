// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskAmountSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskAmountDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPRiskAmountSchema
	implements Schema
{

	private String contno;
	private String ftype;
	private double famnt;
	private String var1;
	private String var2;
	private String var3;
	private String var4;
	private Date makedate;
	private String maketime;
	private Date modifydate;
	private String modifytime;
	public static final int FIELDNUM = 11;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPRiskAmountSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "contno";
		pk[1] = "ftype";
		PK = pk;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getcontno()
	{
		if (contno != null)
			contno.equals("");
		return contno;
	}

	public void setcontno(String acontno)
	{
		contno = acontno;
	}

	public String getftype()
	{
		if (ftype != null)
			ftype.equals("");
		return ftype;
	}

	public void setftype(String aftype)
	{
		ftype = aftype;
	}

	public double getfamnt()
	{
		return famnt;
	}

	public void setfamnt(double afamnt)
	{
		famnt = afamnt;
	}

	public void setfamnt(String afamnt)
	{
		if (afamnt != null && !afamnt.equals(""))
		{
			Double tDouble = new Double(afamnt);
			double d = tDouble.doubleValue();
			famnt = d;
		}
	}

	public String getvar1()
	{
		if (var1 != null)
			var1.equals("");
		return var1;
	}

	public void setvar1(String avar1)
	{
		var1 = avar1;
	}

	public String getvar2()
	{
		if (var2 != null)
			var2.equals("");
		return var2;
	}

	public void setvar2(String avar2)
	{
		var2 = avar2;
	}

	public String getvar3()
	{
		if (var3 != null)
			var3.equals("");
		return var3;
	}

	public void setvar3(String avar3)
	{
		var3 = avar3;
	}

	public String getvar4()
	{
		if (var4 != null)
			var4.equals("");
		return var4;
	}

	public void setvar4(String avar4)
	{
		var4 = avar4;
	}

	public String getmakedate()
	{
		if (makedate != null)
			return fDate.getString(makedate);
		else
			return null;
	}

	public void setmakedate(Date amakedate)
	{
		makedate = amakedate;
	}

	public void setmakedate(String amakedate)
	{
		if (amakedate != null && !amakedate.equals(""))
			makedate = fDate.getDate(amakedate);
		else
			makedate = null;
	}

	public String getmaketime()
	{
		if (maketime != null)
			maketime.equals("");
		return maketime;
	}

	public void setmaketime(String amaketime)
	{
		maketime = amaketime;
	}

	public String getmodifydate()
	{
		if (modifydate != null)
			return fDate.getString(modifydate);
		else
			return null;
	}

	public void setmodifydate(Date amodifydate)
	{
		modifydate = amodifydate;
	}

	public void setmodifydate(String amodifydate)
	{
		if (amodifydate != null && !amodifydate.equals(""))
			modifydate = fDate.getDate(amodifydate);
		else
			modifydate = null;
	}

	public String getmodifytime()
	{
		if (modifytime != null)
			modifytime.equals("");
		return modifytime;
	}

	public void setmodifytime(String amodifytime)
	{
		modifytime = amodifytime;
	}

	public void setSchema(LNPRiskAmountSchema aLNPRiskAmountSchema)
	{
		contno = aLNPRiskAmountSchema.getcontno();
		ftype = aLNPRiskAmountSchema.getftype();
		famnt = aLNPRiskAmountSchema.getfamnt();
		var1 = aLNPRiskAmountSchema.getvar1();
		var2 = aLNPRiskAmountSchema.getvar2();
		var3 = aLNPRiskAmountSchema.getvar3();
		var4 = aLNPRiskAmountSchema.getvar4();
		makedate = fDate.getDate(aLNPRiskAmountSchema.getmakedate());
		maketime = aLNPRiskAmountSchema.getmaketime();
		modifydate = fDate.getDate(aLNPRiskAmountSchema.getmodifydate());
		modifytime = aLNPRiskAmountSchema.getmodifytime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("contno") == null)
				contno = null;
			else
				contno = rs.getString("contno").trim();
			if (rs.getString("ftype") == null)
				ftype = null;
			else
				ftype = rs.getString("ftype").trim();
			famnt = rs.getDouble("famnt");
			if (rs.getString("var1") == null)
				var1 = null;
			else
				var1 = rs.getString("var1").trim();
			if (rs.getString("var2") == null)
				var2 = null;
			else
				var2 = rs.getString("var2").trim();
			if (rs.getString("var3") == null)
				var3 = null;
			else
				var3 = rs.getString("var3").trim();
			if (rs.getString("var4") == null)
				var4 = null;
			else
				var4 = rs.getString("var4").trim();
			makedate = rs.getDate("makedate");
			if (rs.getString("maketime") == null)
				maketime = null;
			else
				maketime = rs.getString("maketime").trim();
			modifydate = rs.getDate("modifydate");
			if (rs.getString("modifytime") == null)
				modifytime = null;
			else
				modifytime = rs.getString("modifytime").trim();
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskAmountSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskAmountSchema getSchema()
	{
		LNPRiskAmountSchema aLNPRiskAmountSchema = new LNPRiskAmountSchema();
		aLNPRiskAmountSchema.setSchema(this);
		return aLNPRiskAmountSchema;
	}

	public LNPRiskAmountDB getDB()
	{
		LNPRiskAmountDB aDBOper = new LNPRiskAmountDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(contno))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ftype))).append("|").append(ChgData.chgData(famnt)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(var1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(var2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(var3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(var4))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makedate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(maketime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifydate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifytime))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			contno = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			ftype = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			famnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 3, "|")))).doubleValue();
			var1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			var2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			var3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			var4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			makedate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			maketime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			modifydate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			modifytime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskAmountSchema";
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
		if (FCode.equals("contno"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contno));
		if (FCode.equals("ftype"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ftype));
		if (FCode.equals("famnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(famnt));
		if (FCode.equals("var1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(var1));
		if (FCode.equals("var2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(var2));
		if (FCode.equals("var3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(var3));
		if (FCode.equals("var4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(var4));
		if (FCode.equals("makedate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmakedate()));
		if (FCode.equals("maketime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(maketime));
		if (FCode.equals("modifydate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifydate()));
		if (FCode.equals("modifytime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifytime));
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
			strFieldValue = StrTool.GBKToUnicode(contno);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(ftype);
			break;

		case 2: // '\002'
			strFieldValue = String.valueOf(famnt);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(var1);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(var2);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(var3);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(var4);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakedate()));
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(maketime);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifydate()));
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(modifytime);
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
		if (FCode.equals("contno"))
			if (FValue != null && !FValue.equals(""))
				contno = FValue.trim();
			else
				contno = null;
		if (FCode.equals("ftype"))
			if (FValue != null && !FValue.equals(""))
				ftype = FValue.trim();
			else
				ftype = null;
		if (FCode.equals("famnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			famnt = d;
		}
		if (FCode.equals("var1"))
			if (FValue != null && !FValue.equals(""))
				var1 = FValue.trim();
			else
				var1 = null;
		if (FCode.equals("var2"))
			if (FValue != null && !FValue.equals(""))
				var2 = FValue.trim();
			else
				var2 = null;
		if (FCode.equals("var3"))
			if (FValue != null && !FValue.equals(""))
				var3 = FValue.trim();
			else
				var3 = null;
		if (FCode.equals("var4"))
			if (FValue != null && !FValue.equals(""))
				var4 = FValue.trim();
			else
				var4 = null;
		if (FCode.equals("makedate"))
			if (FValue != null && !FValue.equals(""))
				makedate = fDate.getDate(FValue);
			else
				makedate = null;
		if (FCode.equals("maketime"))
			if (FValue != null && !FValue.equals(""))
				maketime = FValue.trim();
			else
				maketime = null;
		if (FCode.equals("modifydate"))
			if (FValue != null && !FValue.equals(""))
				modifydate = fDate.getDate(FValue);
			else
				modifydate = null;
		if (FCode.equals("modifytime"))
			if (FValue != null && !FValue.equals(""))
				modifytime = FValue.trim();
			else
				modifytime = null;
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
		LNPRiskAmountSchema other = (LNPRiskAmountSchema)otherObject;
		return contno.equals(other.getcontno()) && ftype.equals(other.getftype()) && famnt == other.getfamnt() && var1.equals(other.getvar1()) && var2.equals(other.getvar2()) && var3.equals(other.getvar3()) && var4.equals(other.getvar4()) && fDate.getString(makedate).equals(other.getmakedate()) && maketime.equals(other.getmaketime()) && fDate.getString(modifydate).equals(other.getmodifydate()) && modifytime.equals(other.getmodifytime());
	}

	public int getFieldCount()
	{
		return 11;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("contno"))
			return 0;
		if (strFieldName.equals("ftype"))
			return 1;
		if (strFieldName.equals("famnt"))
			return 2;
		if (strFieldName.equals("var1"))
			return 3;
		if (strFieldName.equals("var2"))
			return 4;
		if (strFieldName.equals("var3"))
			return 5;
		if (strFieldName.equals("var4"))
			return 6;
		if (strFieldName.equals("makedate"))
			return 7;
		if (strFieldName.equals("maketime"))
			return 8;
		if (strFieldName.equals("modifydate"))
			return 9;
		return !strFieldName.equals("modifytime") ? -1 : 10;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "contno";
			break;

		case 1: // '\001'
			strFieldName = "ftype";
			break;

		case 2: // '\002'
			strFieldName = "famnt";
			break;

		case 3: // '\003'
			strFieldName = "var1";
			break;

		case 4: // '\004'
			strFieldName = "var2";
			break;

		case 5: // '\005'
			strFieldName = "var3";
			break;

		case 6: // '\006'
			strFieldName = "var4";
			break;

		case 7: // '\007'
			strFieldName = "makedate";
			break;

		case 8: // '\b'
			strFieldName = "maketime";
			break;

		case 9: // '\t'
			strFieldName = "modifydate";
			break;

		case 10: // '\n'
			strFieldName = "modifytime";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("contno"))
			return 0;
		if (strFieldName.equals("ftype"))
			return 0;
		if (strFieldName.equals("famnt"))
			return 4;
		if (strFieldName.equals("var1"))
			return 0;
		if (strFieldName.equals("var2"))
			return 0;
		if (strFieldName.equals("var3"))
			return 0;
		if (strFieldName.equals("var4"))
			return 0;
		if (strFieldName.equals("makedate"))
			return 1;
		if (strFieldName.equals("maketime"))
			return 0;
		if (strFieldName.equals("modifydate"))
			return 1;
		return !strFieldName.equals("modifytime") ? -1 : 0;
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
			nFieldType = 4;
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
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 1;
			break;

		case 8: // '\b'
			nFieldType = 0;
			break;

		case 9: // '\t'
			nFieldType = 1;
			break;

		case 10: // '\n'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
