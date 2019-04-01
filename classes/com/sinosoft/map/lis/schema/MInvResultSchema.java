// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvResultSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MInvResultDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MInvResultSchema
	implements Schema, Cloneable
{

	private String resultID;
	private String topicID;
	private String questionID;
	private String optionID;
	private String otherAnswer;
	private String agentCode;
	private String manageCom;
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
	public static final int FIELDNUM = 18;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MInvResultSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ResultID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MInvResultSchema cloned = (MInvResultSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getResultID()
	{
		return resultID;
	}

	public void setResultID(String aResultID)
	{
		resultID = aResultID;
	}

	public String getTopicID()
	{
		return topicID;
	}

	public void setTopicID(String aTopicID)
	{
		topicID = aTopicID;
	}

	public String getQuestionID()
	{
		return questionID;
	}

	public void setQuestionID(String aQuestionID)
	{
		questionID = aQuestionID;
	}

	public String getOptionID()
	{
		return optionID;
	}

	public void setOptionID(String aOptionID)
	{
		optionID = aOptionID;
	}

	public String getOtherAnswer()
	{
		return otherAnswer;
	}

	public void setOtherAnswer(String aOtherAnswer)
	{
		otherAnswer = aOtherAnswer;
	}

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
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

	public void setSchema(MInvResultSchema aMInvResultSchema)
	{
		resultID = aMInvResultSchema.getResultID();
		topicID = aMInvResultSchema.getTopicID();
		questionID = aMInvResultSchema.getQuestionID();
		optionID = aMInvResultSchema.getOptionID();
		otherAnswer = aMInvResultSchema.getOtherAnswer();
		agentCode = aMInvResultSchema.getAgentCode();
		manageCom = aMInvResultSchema.getManageCom();
		vF01 = aMInvResultSchema.getVF01();
		nF01 = aMInvResultSchema.getNF01();
		iF01 = aMInvResultSchema.getIF01();
		dF02 = aMInvResultSchema.getDF02();
		date01 = fDate.getDate(aMInvResultSchema.getDate01());
		modifyOperator = aMInvResultSchema.getModifyOperator();
		operator = aMInvResultSchema.getOperator();
		makeDate = fDate.getDate(aMInvResultSchema.getMakeDate());
		makeTime = aMInvResultSchema.getMakeTime();
		modifyDate = fDate.getDate(aMInvResultSchema.getModifyDate());
		modifyTime = aMInvResultSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ResultID") == null)
				resultID = null;
			else
				resultID = rs.getString("ResultID").trim();
			if (rs.getString("TopicID") == null)
				topicID = null;
			else
				topicID = rs.getString("TopicID").trim();
			if (rs.getString("QuestionID") == null)
				questionID = null;
			else
				questionID = rs.getString("QuestionID").trim();
			if (rs.getString("OptionID") == null)
				optionID = null;
			else
				optionID = rs.getString("OptionID").trim();
			if (rs.getString("OtherAnswer") == null)
				otherAnswer = null;
			else
				otherAnswer = rs.getString("OtherAnswer").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
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
			System.out.println("数据库中的MInvResult表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MInvResultSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MInvResultSchema getSchema()
	{
		MInvResultSchema aMInvResultSchema = new MInvResultSchema();
		aMInvResultSchema.setSchema(this);
		return aMInvResultSchema;
	}

	public MInvResultDB getDB()
	{
		MInvResultDB aDBOper = new MInvResultDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(resultID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(topicID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(questionID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(optionID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(otherAnswer));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
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
			resultID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			topicID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			optionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			otherAnswer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultSchema";
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
		if (FCode.equalsIgnoreCase("resultID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(resultID));
		if (FCode.equalsIgnoreCase("topicID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(topicID));
		if (FCode.equalsIgnoreCase("questionID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionID));
		if (FCode.equalsIgnoreCase("optionID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(optionID));
		if (FCode.equalsIgnoreCase("otherAnswer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(otherAnswer));
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
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
			strFieldValue = StrTool.GBKToUnicode(resultID);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(topicID);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(questionID);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(optionID);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(otherAnswer);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(vF01);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(nF01);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(iF01);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(dF02);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 17: // '\021'
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
		if (FCode.equalsIgnoreCase("resultID"))
			if (FValue != null && !FValue.equals(""))
				resultID = FValue.trim();
			else
				resultID = null;
		if (FCode.equalsIgnoreCase("topicID"))
			if (FValue != null && !FValue.equals(""))
				topicID = FValue.trim();
			else
				topicID = null;
		if (FCode.equalsIgnoreCase("questionID"))
			if (FValue != null && !FValue.equals(""))
				questionID = FValue.trim();
			else
				questionID = null;
		if (FCode.equalsIgnoreCase("optionID"))
			if (FValue != null && !FValue.equals(""))
				optionID = FValue.trim();
			else
				optionID = null;
		if (FCode.equalsIgnoreCase("otherAnswer"))
			if (FValue != null && !FValue.equals(""))
				otherAnswer = FValue.trim();
			else
				otherAnswer = null;
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
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
		MInvResultSchema other = (MInvResultSchema)otherObject;
		if (resultID == null && other.getResultID() != null)
			return false;
		if (resultID != null && !resultID.equals(other.getResultID()))
			return false;
		if (topicID == null && other.getTopicID() != null)
			return false;
		if (topicID != null && !topicID.equals(other.getTopicID()))
			return false;
		if (questionID == null && other.getQuestionID() != null)
			return false;
		if (questionID != null && !questionID.equals(other.getQuestionID()))
			return false;
		if (optionID == null && other.getOptionID() != null)
			return false;
		if (optionID != null && !optionID.equals(other.getOptionID()))
			return false;
		if (otherAnswer == null && other.getOtherAnswer() != null)
			return false;
		if (otherAnswer != null && !otherAnswer.equals(other.getOtherAnswer()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
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
		return 18;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("resultID"))
			return 0;
		if (strFieldName.equals("topicID"))
			return 1;
		if (strFieldName.equals("questionID"))
			return 2;
		if (strFieldName.equals("optionID"))
			return 3;
		if (strFieldName.equals("otherAnswer"))
			return 4;
		if (strFieldName.equals("agentCode"))
			return 5;
		if (strFieldName.equals("manageCom"))
			return 6;
		if (strFieldName.equals("vF01"))
			return 7;
		if (strFieldName.equals("nF01"))
			return 8;
		if (strFieldName.equals("iF01"))
			return 9;
		if (strFieldName.equals("dF02"))
			return 10;
		if (strFieldName.equals("date01"))
			return 11;
		if (strFieldName.equals("modifyOperator"))
			return 12;
		if (strFieldName.equals("operator"))
			return 13;
		if (strFieldName.equals("makeDate"))
			return 14;
		if (strFieldName.equals("makeTime"))
			return 15;
		if (strFieldName.equals("modifyDate"))
			return 16;
		return !strFieldName.equals("modifyTime") ? -1 : 17;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "resultID";
			break;

		case 1: // '\001'
			strFieldName = "topicID";
			break;

		case 2: // '\002'
			strFieldName = "questionID";
			break;

		case 3: // '\003'
			strFieldName = "optionID";
			break;

		case 4: // '\004'
			strFieldName = "otherAnswer";
			break;

		case 5: // '\005'
			strFieldName = "agentCode";
			break;

		case 6: // '\006'
			strFieldName = "manageCom";
			break;

		case 7: // '\007'
			strFieldName = "vF01";
			break;

		case 8: // '\b'
			strFieldName = "nF01";
			break;

		case 9: // '\t'
			strFieldName = "iF01";
			break;

		case 10: // '\n'
			strFieldName = "dF02";
			break;

		case 11: // '\013'
			strFieldName = "date01";
			break;

		case 12: // '\f'
			strFieldName = "modifyOperator";
			break;

		case 13: // '\r'
			strFieldName = "operator";
			break;

		case 14: // '\016'
			strFieldName = "makeDate";
			break;

		case 15: // '\017'
			strFieldName = "makeTime";
			break;

		case 16: // '\020'
			strFieldName = "modifyDate";
			break;

		case 17: // '\021'
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
		if (strFieldName.equals("resultID"))
			return 0;
		if (strFieldName.equals("topicID"))
			return 0;
		if (strFieldName.equals("questionID"))
			return 0;
		if (strFieldName.equals("optionID"))
			return 0;
		if (strFieldName.equals("otherAnswer"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("manageCom"))
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
			nFieldType = 0;
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
			nFieldType = 4;
			break;

		case 11: // '\013'
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 16: // '\020'
			nFieldType = 1;
			break;

		case 17: // '\021'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
