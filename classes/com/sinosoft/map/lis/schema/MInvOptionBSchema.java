// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvOptionBSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MInvOptionBDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MInvOptionBSchema
	implements Schema, Cloneable
{

	private String edorNo;
	private String edorType;
	private String edorCase;
	private String operator2;
	private Date makeDate2;
	private String makeTime2;
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
	public static final int FIELDNUM = 22;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MInvOptionBSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "EdorNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MInvOptionBSchema cloned = (MInvOptionBSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getEdorNo()
	{
		return edorNo;
	}

	public void setEdorNo(String aEdorNo)
	{
		edorNo = aEdorNo;
	}

	public String getEdorType()
	{
		return edorType;
	}

	public void setEdorType(String aEdorType)
	{
		edorType = aEdorType;
	}

	public String getEdorCase()
	{
		return edorCase;
	}

	public void setEdorCase(String aEdorCase)
	{
		edorCase = aEdorCase;
	}

	public String getOperator2()
	{
		return operator2;
	}

	public void setOperator2(String aOperator2)
	{
		operator2 = aOperator2;
	}

	public String getMakeDate2()
	{
		if (makeDate2 != null)
			return fDate.getString(makeDate2);
		else
			return null;
	}

	public void setMakeDate2(Date aMakeDate2)
	{
		makeDate2 = aMakeDate2;
	}

	public void setMakeDate2(String aMakeDate2)
	{
		if (aMakeDate2 != null && !aMakeDate2.equals(""))
			makeDate2 = fDate.getDate(aMakeDate2);
		else
			makeDate2 = null;
	}

	public String getMakeTime2()
	{
		return makeTime2;
	}

	public void setMakeTime2(String aMakeTime2)
	{
		makeTime2 = aMakeTime2;
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

	public void setSchema(MInvOptionBSchema aMInvOptionBSchema)
	{
		edorNo = aMInvOptionBSchema.getEdorNo();
		edorType = aMInvOptionBSchema.getEdorType();
		edorCase = aMInvOptionBSchema.getEdorCase();
		operator2 = aMInvOptionBSchema.getOperator2();
		makeDate2 = fDate.getDate(aMInvOptionBSchema.getMakeDate2());
		makeTime2 = aMInvOptionBSchema.getMakeTime2();
		optionID = aMInvOptionBSchema.getOptionID();
		questionID = aMInvOptionBSchema.getQuestionID();
		option = aMInvOptionBSchema.getOption();
		optionOrder = aMInvOptionBSchema.getOptionOrder();
		state = aMInvOptionBSchema.getState();
		vF01 = aMInvOptionBSchema.getVF01();
		nF01 = aMInvOptionBSchema.getNF01();
		iF01 = aMInvOptionBSchema.getIF01();
		dF02 = aMInvOptionBSchema.getDF02();
		date01 = fDate.getDate(aMInvOptionBSchema.getDate01());
		modifyOperator = aMInvOptionBSchema.getModifyOperator();
		operator = aMInvOptionBSchema.getOperator();
		makeDate = fDate.getDate(aMInvOptionBSchema.getMakeDate());
		makeTime = aMInvOptionBSchema.getMakeTime();
		modifyDate = fDate.getDate(aMInvOptionBSchema.getModifyDate());
		modifyTime = aMInvOptionBSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("EdorNo") == null)
				edorNo = null;
			else
				edorNo = rs.getString("EdorNo").trim();
			if (rs.getString("EdorType") == null)
				edorType = null;
			else
				edorType = rs.getString("EdorType").trim();
			if (rs.getString("EdorCase") == null)
				edorCase = null;
			else
				edorCase = rs.getString("EdorCase").trim();
			if (rs.getString("Operator2") == null)
				operator2 = null;
			else
				operator2 = rs.getString("Operator2").trim();
			makeDate2 = rs.getDate("MakeDate2");
			if (rs.getString("MakeTime2") == null)
				makeTime2 = null;
			else
				makeTime2 = rs.getString("MakeTime2").trim();
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
			System.out.println("数据库中的MInvOptionB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MInvOptionBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MInvOptionBSchema getSchema()
	{
		MInvOptionBSchema aMInvOptionBSchema = new MInvOptionBSchema();
		aMInvOptionBSchema.setSchema(this);
		return aMInvOptionBSchema;
	}

	public MInvOptionBDB getDB()
	{
		MInvOptionBDB aDBOper = new MInvOptionBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(edorNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(edorType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(edorCase));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate2)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime2));
		strReturn.append("|");
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
			edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			makeDate2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
			makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			optionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			option = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			optionOrder = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).intValue();
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MInvOptionBSchema";
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
		if (FCode.equalsIgnoreCase("edorNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorNo));
		if (FCode.equalsIgnoreCase("edorType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorType));
		if (FCode.equalsIgnoreCase("edorCase"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorCase));
		if (FCode.equalsIgnoreCase("operator2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator2));
		if (FCode.equalsIgnoreCase("makeDate2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
		if (FCode.equalsIgnoreCase("makeTime2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime2));
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
			strFieldValue = StrTool.GBKToUnicode(edorNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(edorType);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(edorCase);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(operator2);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(makeTime2);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(optionID);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(questionID);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(option);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(optionOrder);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(vF01);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(nF01);
			break;

		case 13: // '\r'
			strFieldValue = String.valueOf(iF01);
			break;

		case 14: // '\016'
			strFieldValue = String.valueOf(dF02);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 21: // '\025'
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
		if (FCode.equalsIgnoreCase("edorNo"))
			if (FValue != null && !FValue.equals(""))
				edorNo = FValue.trim();
			else
				edorNo = null;
		if (FCode.equalsIgnoreCase("edorType"))
			if (FValue != null && !FValue.equals(""))
				edorType = FValue.trim();
			else
				edorType = null;
		if (FCode.equalsIgnoreCase("edorCase"))
			if (FValue != null && !FValue.equals(""))
				edorCase = FValue.trim();
			else
				edorCase = null;
		if (FCode.equalsIgnoreCase("operator2"))
			if (FValue != null && !FValue.equals(""))
				operator2 = FValue.trim();
			else
				operator2 = null;
		if (FCode.equalsIgnoreCase("makeDate2"))
			if (FValue != null && !FValue.equals(""))
				makeDate2 = fDate.getDate(FValue);
			else
				makeDate2 = null;
		if (FCode.equalsIgnoreCase("makeTime2"))
			if (FValue != null && !FValue.equals(""))
				makeTime2 = FValue.trim();
			else
				makeTime2 = null;
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
		MInvOptionBSchema other = (MInvOptionBSchema)otherObject;
		if (edorNo == null && other.getEdorNo() != null)
			return false;
		if (edorNo != null && !edorNo.equals(other.getEdorNo()))
			return false;
		if (edorType == null && other.getEdorType() != null)
			return false;
		if (edorType != null && !edorType.equals(other.getEdorType()))
			return false;
		if (edorCase == null && other.getEdorCase() != null)
			return false;
		if (edorCase != null && !edorCase.equals(other.getEdorCase()))
			return false;
		if (operator2 == null && other.getOperator2() != null)
			return false;
		if (operator2 != null && !operator2.equals(other.getOperator2()))
			return false;
		if (makeDate2 == null && other.getMakeDate2() != null)
			return false;
		if (makeDate2 != null && !fDate.getString(makeDate2).equals(other.getMakeDate2()))
			return false;
		if (makeTime2 == null && other.getMakeTime2() != null)
			return false;
		if (makeTime2 != null && !makeTime2.equals(other.getMakeTime2()))
			return false;
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
		return 22;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("edorNo"))
			return 0;
		if (strFieldName.equals("edorType"))
			return 1;
		if (strFieldName.equals("edorCase"))
			return 2;
		if (strFieldName.equals("operator2"))
			return 3;
		if (strFieldName.equals("makeDate2"))
			return 4;
		if (strFieldName.equals("makeTime2"))
			return 5;
		if (strFieldName.equals("optionID"))
			return 6;
		if (strFieldName.equals("questionID"))
			return 7;
		if (strFieldName.equals("option"))
			return 8;
		if (strFieldName.equals("optionOrder"))
			return 9;
		if (strFieldName.equals("state"))
			return 10;
		if (strFieldName.equals("vF01"))
			return 11;
		if (strFieldName.equals("nF01"))
			return 12;
		if (strFieldName.equals("iF01"))
			return 13;
		if (strFieldName.equals("dF02"))
			return 14;
		if (strFieldName.equals("date01"))
			return 15;
		if (strFieldName.equals("modifyOperator"))
			return 16;
		if (strFieldName.equals("operator"))
			return 17;
		if (strFieldName.equals("makeDate"))
			return 18;
		if (strFieldName.equals("makeTime"))
			return 19;
		if (strFieldName.equals("modifyDate"))
			return 20;
		return !strFieldName.equals("modifyTime") ? -1 : 21;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "edorNo";
			break;

		case 1: // '\001'
			strFieldName = "edorType";
			break;

		case 2: // '\002'
			strFieldName = "edorCase";
			break;

		case 3: // '\003'
			strFieldName = "operator2";
			break;

		case 4: // '\004'
			strFieldName = "makeDate2";
			break;

		case 5: // '\005'
			strFieldName = "makeTime2";
			break;

		case 6: // '\006'
			strFieldName = "optionID";
			break;

		case 7: // '\007'
			strFieldName = "questionID";
			break;

		case 8: // '\b'
			strFieldName = "option";
			break;

		case 9: // '\t'
			strFieldName = "optionOrder";
			break;

		case 10: // '\n'
			strFieldName = "state";
			break;

		case 11: // '\013'
			strFieldName = "vF01";
			break;

		case 12: // '\f'
			strFieldName = "nF01";
			break;

		case 13: // '\r'
			strFieldName = "iF01";
			break;

		case 14: // '\016'
			strFieldName = "dF02";
			break;

		case 15: // '\017'
			strFieldName = "date01";
			break;

		case 16: // '\020'
			strFieldName = "modifyOperator";
			break;

		case 17: // '\021'
			strFieldName = "operator";
			break;

		case 18: // '\022'
			strFieldName = "makeDate";
			break;

		case 19: // '\023'
			strFieldName = "makeTime";
			break;

		case 20: // '\024'
			strFieldName = "modifyDate";
			break;

		case 21: // '\025'
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
		if (strFieldName.equals("edorNo"))
			return 0;
		if (strFieldName.equals("edorType"))
			return 0;
		if (strFieldName.equals("edorCase"))
			return 0;
		if (strFieldName.equals("operator2"))
			return 0;
		if (strFieldName.equals("makeDate2"))
			return 1;
		if (strFieldName.equals("makeTime2"))
			return 0;
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
			nFieldType = 3;
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
			nFieldType = 3;
			break;

		case 14: // '\016'
			nFieldType = 4;
			break;

		case 15: // '\017'
			nFieldType = 1;
			break;

		case 16: // '\020'
			nFieldType = 0;
			break;

		case 17: // '\021'
			nFieldType = 0;
			break;

		case 18: // '\022'
			nFieldType = 1;
			break;

		case 19: // '\023'
			nFieldType = 0;
			break;

		case 20: // '\024'
			nFieldType = 1;
			break;

		case 21: // '\025'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
