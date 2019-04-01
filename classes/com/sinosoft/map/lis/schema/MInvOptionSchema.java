// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvOptionSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MInvOptionDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MInvOptionSchema
	implements Schema, Cloneable
{

	private String optionID;
	private String questionID;
	private String option;
	private int optionOrder;
	private String state;
	private String vF01;
	private String nF01;
	private int iF01;
	private double dF02;
	private Date date01;
	private String modifyOperator;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 16;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MInvOptionSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "OptionID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MInvOptionSchema cloned = (MInvOptionSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getOptionID()
	{
		return optionID;
	}

	public void setOptionID(String aOptionID)
	{
		optionID = aOptionID;
	}

	public String getQuestionID()
	{
		return questionID;
	}

	public void setQuestionID(String aQuestionID)
	{
		questionID = aQuestionID;
	}

	public String getOption()
	{
		return option;
	}

	public void setOption(String aOption)
	{
		option = aOption;
	}

	public int getOptionOrder()
	{
		return optionOrder;
	}

	public void setOptionOrder(int aOptionOrder)
	{
		optionOrder = aOptionOrder;
	}

	public void setOptionOrder(String aOptionOrder)
	{
		if (aOptionOrder != null && !aOptionOrder.equals(""))
		{
			Integer tInteger = new Integer(aOptionOrder);
			int i = tInteger.intValue();
			optionOrder = i;
		}
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getVF01()
	{
		return vF01;
	}

	public void setVF01(String aVF01)
	{
		vF01 = aVF01;
	}

	public String getNF01()
	{
		return nF01;
	}

	public void setNF01(String aNF01)
	{
		nF01 = aNF01;
	}

	public int getIF01()
	{
		return iF01;
	}

	public void setIF01(int aIF01)
	{
		iF01 = aIF01;
	}

	public void setIF01(String aIF01)
	{
		if (aIF01 != null && !aIF01.equals(""))
		{
			Integer tInteger = new Integer(aIF01);
			int i = tInteger.intValue();
			iF01 = i;
		}
	}

	public double getDF02()
	{
		return dF02;
	}

	public void setDF02(double aDF02)
	{
		dF02 = aDF02;
	}

	public void setDF02(String aDF02)
	{
		if (aDF02 != null && !aDF02.equals(""))
		{
			Double tDouble = new Double(aDF02);
			double d = tDouble.doubleValue();
			dF02 = d;
		}
	}

	public String getDate01()
	{
		if (date01 != null)
			return fDate.getString(date01);
		else
			return null;
	}

	public void setDate01(Date aDate01)
	{
		date01 = aDate01;
	}

	public void setDate01(String aDate01)
	{
		if (aDate01 != null && !aDate01.equals(""))
			date01 = fDate.getDate(aDate01);
		else
			date01 = null;
	}

	public String getModifyOperator()
	{
		return modifyOperator;
	}

	public void setModifyOperator(String aModifyOperator)
	{
		modifyOperator = aModifyOperator;
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

	public String getModifyDate()
	{
		if (modifyDate != null)
			return fDate.getString(modifyDate);
		else
			return null;
	}

	public void setModifyDate(Date aModifyDate)
	{
		modifyDate = aModifyDate;
	}

	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals(""))
			modifyDate = fDate.getDate(aModifyDate);
		else
			modifyDate = null;
	}

	public String getModifyTime()
	{
		return modifyTime;
	}

	public void setModifyTime(String aModifyTime)
	{
		modifyTime = aModifyTime;
	}

	public void setSchema(MInvOptionSchema aMInvOptionSchema)
	{
		optionID = aMInvOptionSchema.getOptionID();
		questionID = aMInvOptionSchema.getQuestionID();
		option = aMInvOptionSchema.getOption();
		optionOrder = aMInvOptionSchema.getOptionOrder();
		state = aMInvOptionSchema.getState();
		vF01 = aMInvOptionSchema.getVF01();
		nF01 = aMInvOptionSchema.getNF01();
		iF01 = aMInvOptionSchema.getIF01();
		dF02 = aMInvOptionSchema.getDF02();
		date01 = fDate.getDate(aMInvOptionSchema.getDate01());
		modifyOperator = aMInvOptionSchema.getModifyOperator();
		operator = aMInvOptionSchema.getOperator();
		makeDate = fDate.getDate(aMInvOptionSchema.getMakeDate());
		makeTime = aMInvOptionSchema.getMakeTime();
		modifyDate = fDate.getDate(aMInvOptionSchema.getModifyDate());
		modifyTime = aMInvOptionSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("OptionID") == null)
				optionID = null;
			else
				optionID = rs.getString("OptionID").trim();
			if (rs.getString("QuestionID") == null)
				questionID = null;
			else
				questionID = rs.getString("QuestionID").trim();
			if (rs.getString("Option") == null)
				option = null;
			else
				option = rs.getString("Option").trim();
			optionOrder = rs.getInt("OptionOrder");
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			if (rs.getString("VF01") == null)
				vF01 = null;
			else
				vF01 = rs.getString("VF01").trim();
			if (rs.getString("NF01") == null)
				nF01 = null;
			else
				nF01 = rs.getString("NF01").trim();
			iF01 = rs.getInt("IF01");
			dF02 = rs.getDouble("DF02");
			date01 = rs.getDate("Date01");
			if (rs.getString("ModifyOperator") == null)
				modifyOperator = null;
			else
				modifyOperator = rs.getString("ModifyOperator").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			makeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("MakeTime").trim();
			modifyDate = rs.getDate("ModifyDate");
			if (rs.getString("ModifyTime") == null)
				modifyTime = null;
			else
				modifyTime = rs.getString("ModifyTime").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MInvOption表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MInvOptionSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MInvOptionSchema getSchema()
	{
		MInvOptionSchema aMInvOptionSchema = new MInvOptionSchema();
		aMInvOptionSchema.setSchema(this);
		return aMInvOptionSchema;
	}

	public MInvOptionDB getDB()
	{
		MInvOptionDB aDBOper = new MInvOptionDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(optionID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(questionID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(option));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(optionOrder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vF01));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nF01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iF01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(dF02));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(date01)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyOperator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyTime));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			optionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			option = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			optionOrder = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|")))).intValue();
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MInvOptionSchema";
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
		if (FCode.equalsIgnoreCase("optionID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(optionID));
		if (FCode.equalsIgnoreCase("questionID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionID));
		if (FCode.equalsIgnoreCase("option"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(option));
		if (FCode.equalsIgnoreCase("optionOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(optionOrder));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("vF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vF01));
		if (FCode.equalsIgnoreCase("nF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF01));
		if (FCode.equalsIgnoreCase("iF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iF01));
		if (FCode.equalsIgnoreCase("dF02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dF02));
		if (FCode.equalsIgnoreCase("date01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
		if (FCode.equalsIgnoreCase("modifyOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyOperator));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
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
			strFieldValue = StrTool.GBKToUnicode(optionID);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(questionID);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(option);
			break;

		case 3: // '\003'
			strFieldValue = String.valueOf(optionOrder);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(vF01);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(nF01);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(iF01);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(dF02);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
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
		if (FCode.equalsIgnoreCase("optionID"))
			if (FValue != null && !FValue.equals(""))
				optionID = FValue.trim();
			else
				optionID = null;
		if (FCode.equalsIgnoreCase("questionID"))
			if (FValue != null && !FValue.equals(""))
				questionID = FValue.trim();
			else
				questionID = null;
		if (FCode.equalsIgnoreCase("option"))
			if (FValue != null && !FValue.equals(""))
				option = FValue.trim();
			else
				option = null;
		if (FCode.equalsIgnoreCase("optionOrder") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			optionOrder = i;
		}
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("vF01"))
			if (FValue != null && !FValue.equals(""))
				vF01 = FValue.trim();
			else
				vF01 = null;
		if (FCode.equalsIgnoreCase("nF01"))
			if (FValue != null && !FValue.equals(""))
				nF01 = FValue.trim();
			else
				nF01 = null;
		if (FCode.equalsIgnoreCase("iF01") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iF01 = i;
		}
		if (FCode.equalsIgnoreCase("dF02") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			dF02 = d;
		}
		if (FCode.equalsIgnoreCase("date01"))
			if (FValue != null && !FValue.equals(""))
				date01 = fDate.getDate(FValue);
			else
				date01 = null;
		if (FCode.equalsIgnoreCase("modifyOperator"))
			if (FValue != null && !FValue.equals(""))
				modifyOperator = FValue.trim();
			else
				modifyOperator = null;
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
		if (FCode.equalsIgnoreCase("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equalsIgnoreCase("modifyTime"))
			if (FValue != null && !FValue.equals(""))
				modifyTime = FValue.trim();
			else
				modifyTime = null;
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
		MInvOptionSchema other = (MInvOptionSchema)otherObject;
		if (optionID == null && other.getOptionID() != null)
			return false;
		if (optionID != null && !optionID.equals(other.getOptionID()))
			return false;
		if (questionID == null && other.getQuestionID() != null)
			return false;
		if (questionID != null && !questionID.equals(other.getQuestionID()))
			return false;
		if (option == null && other.getOption() != null)
			return false;
		if (option != null && !option.equals(other.getOption()))
			return false;
		if (optionOrder != other.getOptionOrder())
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (vF01 == null && other.getVF01() != null)
			return false;
		if (vF01 != null && !vF01.equals(other.getVF01()))
			return false;
		if (nF01 == null && other.getNF01() != null)
			return false;
		if (nF01 != null && !nF01.equals(other.getNF01()))
			return false;
		if (iF01 != other.getIF01())
			return false;
		if (Double.doubleToLongBits(dF02) != Double.doubleToLongBits(other.getDF02()))
			return false;
		if (date01 == null && other.getDate01() != null)
			return false;
		if (date01 != null && !fDate.getString(date01).equals(other.getDate01()))
			return false;
		if (modifyOperator == null && other.getModifyOperator() != null)
			return false;
		if (modifyOperator != null && !modifyOperator.equals(other.getModifyOperator()))
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
		if (makeTime != null && !makeTime.equals(other.getMakeTime()))
			return false;
		if (modifyDate == null && other.getModifyDate() != null)
			return false;
		if (modifyDate != null && !fDate.getString(modifyDate).equals(other.getModifyDate()))
			return false;
		if (modifyTime == null && other.getModifyTime() != null)
			return false;
		return modifyTime == null || modifyTime.equals(other.getModifyTime());
	}

	public int getFieldCount()
	{
		return 16;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("optionID"))
			return 0;
		if (strFieldName.equals("questionID"))
			return 1;
		if (strFieldName.equals("option"))
			return 2;
		if (strFieldName.equals("optionOrder"))
			return 3;
		if (strFieldName.equals("state"))
			return 4;
		if (strFieldName.equals("vF01"))
			return 5;
		if (strFieldName.equals("nF01"))
			return 6;
		if (strFieldName.equals("iF01"))
			return 7;
		if (strFieldName.equals("dF02"))
			return 8;
		if (strFieldName.equals("date01"))
			return 9;
		if (strFieldName.equals("modifyOperator"))
			return 10;
		if (strFieldName.equals("operator"))
			return 11;
		if (strFieldName.equals("makeDate"))
			return 12;
		if (strFieldName.equals("makeTime"))
			return 13;
		if (strFieldName.equals("modifyDate"))
			return 14;
		return !strFieldName.equals("modifyTime") ? -1 : 15;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "optionID";
			break;

		case 1: // '\001'
			strFieldName = "questionID";
			break;

		case 2: // '\002'
			strFieldName = "option";
			break;

		case 3: // '\003'
			strFieldName = "optionOrder";
			break;

		case 4: // '\004'
			strFieldName = "state";
			break;

		case 5: // '\005'
			strFieldName = "vF01";
			break;

		case 6: // '\006'
			strFieldName = "nF01";
			break;

		case 7: // '\007'
			strFieldName = "iF01";
			break;

		case 8: // '\b'
			strFieldName = "dF02";
			break;

		case 9: // '\t'
			strFieldName = "date01";
			break;

		case 10: // '\n'
			strFieldName = "modifyOperator";
			break;

		case 11: // '\013'
			strFieldName = "operator";
			break;

		case 12: // '\f'
			strFieldName = "makeDate";
			break;

		case 13: // '\r'
			strFieldName = "makeTime";
			break;

		case 14: // '\016'
			strFieldName = "modifyDate";
			break;

		case 15: // '\017'
			strFieldName = "modifyTime";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("optionID"))
			return 0;
		if (strFieldName.equals("questionID"))
			return 0;
		if (strFieldName.equals("option"))
			return 0;
		if (strFieldName.equals("optionOrder"))
			return 3;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("vF01"))
			return 0;
		if (strFieldName.equals("nF01"))
			return 0;
		if (strFieldName.equals("iF01"))
			return 3;
		if (strFieldName.equals("dF02"))
			return 4;
		if (strFieldName.equals("date01"))
			return 1;
		if (strFieldName.equals("modifyOperator"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		return !strFieldName.equals("modifyTime") ? -1 : 0;
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
			nFieldType = 3;
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
			nFieldType = 3;
			break;

		case 8: // '\b'
			nFieldType = 4;
			break;

		case 9: // '\t'
			nFieldType = 1;
			break;

		case 10: // '\n'
			nFieldType = 0;
			break;

		case 11: // '\013'
			nFieldType = 0;
			break;

		case 12: // '\f'
			nFieldType = 1;
			break;

		case 13: // '\r'
			nFieldType = 0;
			break;

		case 14: // '\016'
			nFieldType = 1;
			break;

		case 15: // '\017'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
