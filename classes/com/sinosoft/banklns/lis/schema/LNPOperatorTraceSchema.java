// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPOperatorTraceSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPOperatorTraceDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPOperatorTraceSchema
	implements Schema, Cloneable
{

	private String iD;
	private String contno;
	private String operator;
	private Date operatorDate;
	private String operatorTime;
	private String operatorType;
	private int int1;
	private int int2;
	private String varc1;
	private String varc2;
	private String varc5;
	private String varc3;
	private String varc4;
	private String varc6;
	private Date date1;
	private Date date2;
	public static final int FIELDNUM = 16;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPOperatorTraceSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPOperatorTraceSchema cloned = (LNPOperatorTraceSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getID()
	{
		return iD;
	}

	public void setID(String aID)
	{
		iD = aID;
	}

	public String getContno()
	{
		return contno;
	}

	public void setContno(String aContno)
	{
		contno = aContno;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public String getOperatorDate()
	{
		if (operatorDate != null)
			return fDate.getString(operatorDate);
		else
			return null;
	}

	public void setOperatorDate(Date aOperatorDate)
	{
		operatorDate = aOperatorDate;
	}

	public void setOperatorDate(String aOperatorDate)
	{
		if (aOperatorDate != null && !aOperatorDate.equals(""))
			operatorDate = fDate.getDate(aOperatorDate);
		else
			operatorDate = null;
	}

	public String getOperatorTime()
	{
		return operatorTime;
	}

	public void setOperatorTime(String aOperatorTime)
	{
		operatorTime = aOperatorTime;
	}

	public String getOperatorType()
	{
		return operatorType;
	}

	public void setOperatorType(String aOperatorType)
	{
		operatorType = aOperatorType;
	}

	public int getInt1()
	{
		return int1;
	}

	public void setInt1(int aInt1)
	{
		int1 = aInt1;
	}

	public void setInt1(String aInt1)
	{
		if (aInt1 != null && !aInt1.equals(""))
		{
			Integer tInteger = new Integer(aInt1);
			int i = tInteger.intValue();
			int1 = i;
		}
	}

	public int getInt2()
	{
		return int2;
	}

	public void setInt2(int aInt2)
	{
		int2 = aInt2;
	}

	public void setInt2(String aInt2)
	{
		if (aInt2 != null && !aInt2.equals(""))
		{
			Integer tInteger = new Integer(aInt2);
			int i = tInteger.intValue();
			int2 = i;
		}
	}

	public String getVarc1()
	{
		return varc1;
	}

	public void setVarc1(String aVarc1)
	{
		varc1 = aVarc1;
	}

	public String getVarc2()
	{
		return varc2;
	}

	public void setVarc2(String aVarc2)
	{
		varc2 = aVarc2;
	}

	public String getVarc5()
	{
		return varc5;
	}

	public void setVarc5(String aVarc5)
	{
		varc5 = aVarc5;
	}

	public String getVarc3()
	{
		return varc3;
	}

	public void setVarc3(String aVarc3)
	{
		varc3 = aVarc3;
	}

	public String getVarc4()
	{
		return varc4;
	}

	public void setVarc4(String aVarc4)
	{
		varc4 = aVarc4;
	}

	public String getVarc6()
	{
		return varc6;
	}

	public void setVarc6(String aVarc6)
	{
		varc6 = aVarc6;
	}

	public String getDate1()
	{
		if (date1 != null)
			return fDate.getString(date1);
		else
			return null;
	}

	public void setDate1(Date aDate1)
	{
		date1 = aDate1;
	}

	public void setDate1(String aDate1)
	{
		if (aDate1 != null && !aDate1.equals(""))
			date1 = fDate.getDate(aDate1);
		else
			date1 = null;
	}

	public String getDate2()
	{
		if (date2 != null)
			return fDate.getString(date2);
		else
			return null;
	}

	public void setDate2(Date aDate2)
	{
		date2 = aDate2;
	}

	public void setDate2(String aDate2)
	{
		if (aDate2 != null && !aDate2.equals(""))
			date2 = fDate.getDate(aDate2);
		else
			date2 = null;
	}

	public void setSchema(LNPOperatorTraceSchema aLNPOperatorTraceSchema)
	{
		iD = aLNPOperatorTraceSchema.getID();
		contno = aLNPOperatorTraceSchema.getContno();
		operator = aLNPOperatorTraceSchema.getOperator();
		operatorDate = fDate.getDate(aLNPOperatorTraceSchema.getOperatorDate());
		operatorTime = aLNPOperatorTraceSchema.getOperatorTime();
		operatorType = aLNPOperatorTraceSchema.getOperatorType();
		int1 = aLNPOperatorTraceSchema.getInt1();
		int2 = aLNPOperatorTraceSchema.getInt2();
		varc1 = aLNPOperatorTraceSchema.getVarc1();
		varc2 = aLNPOperatorTraceSchema.getVarc2();
		varc5 = aLNPOperatorTraceSchema.getVarc5();
		varc3 = aLNPOperatorTraceSchema.getVarc3();
		varc4 = aLNPOperatorTraceSchema.getVarc4();
		varc6 = aLNPOperatorTraceSchema.getVarc6();
		date1 = fDate.getDate(aLNPOperatorTraceSchema.getDate1());
		date2 = fDate.getDate(aLNPOperatorTraceSchema.getDate2());
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ID") == null)
				iD = null;
			else
				iD = rs.getString("ID").trim();
			if (rs.getString("Contno") == null)
				contno = null;
			else
				contno = rs.getString("Contno").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			operatorDate = rs.getDate("OperatorDate");
			if (rs.getString("OperatorTime") == null)
				operatorTime = null;
			else
				operatorTime = rs.getString("OperatorTime").trim();
			if (rs.getString("OperatorType") == null)
				operatorType = null;
			else
				operatorType = rs.getString("OperatorType").trim();
			int1 = rs.getInt("Int1");
			int2 = rs.getInt("Int2");
			if (rs.getString("Varc1") == null)
				varc1 = null;
			else
				varc1 = rs.getString("Varc1").trim();
			if (rs.getString("Varc2") == null)
				varc2 = null;
			else
				varc2 = rs.getString("Varc2").trim();
			if (rs.getString("Varc5") == null)
				varc5 = null;
			else
				varc5 = rs.getString("Varc5").trim();
			if (rs.getString("Varc3") == null)
				varc3 = null;
			else
				varc3 = rs.getString("Varc3").trim();
			if (rs.getString("Varc4") == null)
				varc4 = null;
			else
				varc4 = rs.getString("Varc4").trim();
			if (rs.getString("Varc6") == null)
				varc6 = null;
			else
				varc6 = rs.getString("Varc6").trim();
			date1 = rs.getDate("Date1");
			date2 = rs.getDate("Date2");
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPOperatorTrace????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPOperatorTraceSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPOperatorTraceSchema getSchema()
	{
		LNPOperatorTraceSchema aLNPOperatorTraceSchema = new LNPOperatorTraceSchema();
		aLNPOperatorTraceSchema.setSchema(this);
		return aLNPOperatorTraceSchema;
	}

	public LNPOperatorTraceDB getDB()
	{
		LNPOperatorTraceDB aDBOper = new LNPOperatorTraceDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(iD));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contno));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(operatorDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operatorTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operatorType));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(int1));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(int2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc5));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc4));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc6));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(date1)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(date2)));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			contno = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			operatorDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|"));
			operatorTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			operatorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			int1 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).intValue();
			int2 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).intValue();
			varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			varc5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			varc6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			date1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			date2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPOperatorTraceSchema";
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
		if (FCode.equalsIgnoreCase("iD"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iD));
		if (FCode.equalsIgnoreCase("contno"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contno));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("operatorDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getOperatorDate()));
		if (FCode.equalsIgnoreCase("operatorTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operatorTime));
		if (FCode.equalsIgnoreCase("operatorType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operatorType));
		if (FCode.equalsIgnoreCase("int1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(int1));
		if (FCode.equalsIgnoreCase("int2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(int2));
		if (FCode.equalsIgnoreCase("varc1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc1));
		if (FCode.equalsIgnoreCase("varc2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc2));
		if (FCode.equalsIgnoreCase("varc5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc5));
		if (FCode.equalsIgnoreCase("varc3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc3));
		if (FCode.equalsIgnoreCase("varc4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc4));
		if (FCode.equalsIgnoreCase("varc6"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc6));
		if (FCode.equalsIgnoreCase("date1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDate1()));
		if (FCode.equalsIgnoreCase("date2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDate2()));
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
			strFieldValue = StrTool.GBKToUnicode(iD);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(contno);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getOperatorDate()));
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(operatorTime);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(operatorType);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(int1);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(int2);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(varc1);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(varc2);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(varc5);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(varc3);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(varc4);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(varc6);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate1()));
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate2()));
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
		if (FCode.equalsIgnoreCase("iD"))
			if (FValue != null && !FValue.equals(""))
				iD = FValue.trim();
			else
				iD = null;
		if (FCode.equalsIgnoreCase("contno"))
			if (FValue != null && !FValue.equals(""))
				contno = FValue.trim();
			else
				contno = null;
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equalsIgnoreCase("operatorDate"))
			if (FValue != null && !FValue.equals(""))
				operatorDate = fDate.getDate(FValue);
			else
				operatorDate = null;
		if (FCode.equalsIgnoreCase("operatorTime"))
			if (FValue != null && !FValue.equals(""))
				operatorTime = FValue.trim();
			else
				operatorTime = null;
		if (FCode.equalsIgnoreCase("operatorType"))
			if (FValue != null && !FValue.equals(""))
				operatorType = FValue.trim();
			else
				operatorType = null;
		if (FCode.equalsIgnoreCase("int1") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			int1 = i;
		}
		if (FCode.equalsIgnoreCase("int2") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			int2 = i;
		}
		if (FCode.equalsIgnoreCase("varc1"))
			if (FValue != null && !FValue.equals(""))
				varc1 = FValue.trim();
			else
				varc1 = null;
		if (FCode.equalsIgnoreCase("varc2"))
			if (FValue != null && !FValue.equals(""))
				varc2 = FValue.trim();
			else
				varc2 = null;
		if (FCode.equalsIgnoreCase("varc5"))
			if (FValue != null && !FValue.equals(""))
				varc5 = FValue.trim();
			else
				varc5 = null;
		if (FCode.equalsIgnoreCase("varc3"))
			if (FValue != null && !FValue.equals(""))
				varc3 = FValue.trim();
			else
				varc3 = null;
		if (FCode.equalsIgnoreCase("varc4"))
			if (FValue != null && !FValue.equals(""))
				varc4 = FValue.trim();
			else
				varc4 = null;
		if (FCode.equalsIgnoreCase("varc6"))
			if (FValue != null && !FValue.equals(""))
				varc6 = FValue.trim();
			else
				varc6 = null;
		if (FCode.equalsIgnoreCase("date1"))
			if (FValue != null && !FValue.equals(""))
				date1 = fDate.getDate(FValue);
			else
				date1 = null;
		if (FCode.equalsIgnoreCase("date2"))
			if (FValue != null && !FValue.equals(""))
				date2 = fDate.getDate(FValue);
			else
				date2 = null;
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
		LNPOperatorTraceSchema other = (LNPOperatorTraceSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (contno == null && other.getContno() != null)
			return false;
		if (contno != null && !contno.equals(other.getContno()))
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (operatorDate == null && other.getOperatorDate() != null)
			return false;
		if (operatorDate != null && !fDate.getString(operatorDate).equals(other.getOperatorDate()))
			return false;
		if (operatorTime == null && other.getOperatorTime() != null)
			return false;
		if (operatorTime != null && !operatorTime.equals(other.getOperatorTime()))
			return false;
		if (operatorType == null && other.getOperatorType() != null)
			return false;
		if (operatorType != null && !operatorType.equals(other.getOperatorType()))
			return false;
		if (int1 != other.getInt1())
			return false;
		if (int2 != other.getInt2())
			return false;
		if (varc1 == null && other.getVarc1() != null)
			return false;
		if (varc1 != null && !varc1.equals(other.getVarc1()))
			return false;
		if (varc2 == null && other.getVarc2() != null)
			return false;
		if (varc2 != null && !varc2.equals(other.getVarc2()))
			return false;
		if (varc5 == null && other.getVarc5() != null)
			return false;
		if (varc5 != null && !varc5.equals(other.getVarc5()))
			return false;
		if (varc3 == null && other.getVarc3() != null)
			return false;
		if (varc3 != null && !varc3.equals(other.getVarc3()))
			return false;
		if (varc4 == null && other.getVarc4() != null)
			return false;
		if (varc4 != null && !varc4.equals(other.getVarc4()))
			return false;
		if (varc6 == null && other.getVarc6() != null)
			return false;
		if (varc6 != null && !varc6.equals(other.getVarc6()))
			return false;
		if (date1 == null && other.getDate1() != null)
			return false;
		if (date1 != null && !fDate.getString(date1).equals(other.getDate1()))
			return false;
		if (date2 == null && other.getDate2() != null)
			return false;
		return date2 == null || fDate.getString(date2).equals(other.getDate2());
	}

	public int getFieldCount()
	{
		return 16;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("contno"))
			return 1;
		if (strFieldName.equals("operator"))
			return 2;
		if (strFieldName.equals("operatorDate"))
			return 3;
		if (strFieldName.equals("operatorTime"))
			return 4;
		if (strFieldName.equals("operatorType"))
			return 5;
		if (strFieldName.equals("int1"))
			return 6;
		if (strFieldName.equals("int2"))
			return 7;
		if (strFieldName.equals("varc1"))
			return 8;
		if (strFieldName.equals("varc2"))
			return 9;
		if (strFieldName.equals("varc5"))
			return 10;
		if (strFieldName.equals("varc3"))
			return 11;
		if (strFieldName.equals("varc4"))
			return 12;
		if (strFieldName.equals("varc6"))
			return 13;
		if (strFieldName.equals("date1"))
			return 14;
		return !strFieldName.equals("date2") ? -1 : 15;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "iD";
			break;

		case 1: // '\001'
			strFieldName = "contno";
			break;

		case 2: // '\002'
			strFieldName = "operator";
			break;

		case 3: // '\003'
			strFieldName = "operatorDate";
			break;

		case 4: // '\004'
			strFieldName = "operatorTime";
			break;

		case 5: // '\005'
			strFieldName = "operatorType";
			break;

		case 6: // '\006'
			strFieldName = "int1";
			break;

		case 7: // '\007'
			strFieldName = "int2";
			break;

		case 8: // '\b'
			strFieldName = "varc1";
			break;

		case 9: // '\t'
			strFieldName = "varc2";
			break;

		case 10: // '\n'
			strFieldName = "varc5";
			break;

		case 11: // '\013'
			strFieldName = "varc3";
			break;

		case 12: // '\f'
			strFieldName = "varc4";
			break;

		case 13: // '\r'
			strFieldName = "varc6";
			break;

		case 14: // '\016'
			strFieldName = "date1";
			break;

		case 15: // '\017'
			strFieldName = "date2";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("contno"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("operatorDate"))
			return 1;
		if (strFieldName.equals("operatorTime"))
			return 0;
		if (strFieldName.equals("operatorType"))
			return 0;
		if (strFieldName.equals("int1"))
			return 3;
		if (strFieldName.equals("int2"))
			return 3;
		if (strFieldName.equals("varc1"))
			return 0;
		if (strFieldName.equals("varc2"))
			return 0;
		if (strFieldName.equals("varc5"))
			return 0;
		if (strFieldName.equals("varc3"))
			return 0;
		if (strFieldName.equals("varc4"))
			return 0;
		if (strFieldName.equals("varc6"))
			return 0;
		if (strFieldName.equals("date1"))
			return 1;
		return !strFieldName.equals("date2") ? -1 : 1;
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
			nFieldType = 1;
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

		case 7: // '\007'
			nFieldType = 3;
			break;

		case 8: // '\b'
			nFieldType = 0;
			break;

		case 9: // '\t'
			nFieldType = 0;
			break;

		case 10: // '\n'
			nFieldType = 0;
			break;

		case 11: // '\013'
			nFieldType = 0;
			break;

		case 12: // '\f'
			nFieldType = 0;
			break;

		case 13: // '\r'
			nFieldType = 0;
			break;

		case 14: // '\016'
			nFieldType = 1;
			break;

		case 15: // '\017'
			nFieldType = 1;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
