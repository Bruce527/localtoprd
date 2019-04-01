// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvQuestionSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MInvQuestionDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MInvQuestionSchema
	implements Schema, Cloneable
{

	private String questionID;
	private String topicID;
	private String question;
	private String depiction;
	private String questionType;
	private int questionOrder;
	private String parentID;
	private String state;
	private String childFlag;
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
	public static final int FIELDNUM = 20;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MInvQuestionSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "QuestionID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MInvQuestionSchema cloned = (MInvQuestionSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getQuestionID()
	{
		return questionID;
	}

	public void setQuestionID(String aQuestionID)
	{
		questionID = aQuestionID;
	}

	public String getTopicID()
	{
		return topicID;
	}

	public void setTopicID(String aTopicID)
	{
		topicID = aTopicID;
	}

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String aQuestion)
	{
		question = aQuestion;
	}

	public String getDepiction()
	{
		return depiction;
	}

	public void setDepiction(String aDepiction)
	{
		depiction = aDepiction;
	}

	public String getQuestionType()
	{
		return questionType;
	}

	public void setQuestionType(String aQuestionType)
	{
		questionType = aQuestionType;
	}

	public int getQuestionOrder()
	{
		return questionOrder;
	}

	public void setQuestionOrder(int aQuestionOrder)
	{
		questionOrder = aQuestionOrder;
	}

	public void setQuestionOrder(String aQuestionOrder)
	{
		if (aQuestionOrder != null && !aQuestionOrder.equals(""))
		{
			Integer tInteger = new Integer(aQuestionOrder);
			int i = tInteger.intValue();
			questionOrder = i;
		}
	}

	public String getParentID()
	{
		return parentID;
	}

	public void setParentID(String aParentID)
	{
		parentID = aParentID;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getChildFlag()
	{
		return childFlag;
	}

	public void setChildFlag(String aChildFlag)
	{
		childFlag = aChildFlag;
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

	public void setSchema(MInvQuestionSchema aMInvQuestionSchema)
	{
		questionID = aMInvQuestionSchema.getQuestionID();
		topicID = aMInvQuestionSchema.getTopicID();
		question = aMInvQuestionSchema.getQuestion();
		depiction = aMInvQuestionSchema.getDepiction();
		questionType = aMInvQuestionSchema.getQuestionType();
		questionOrder = aMInvQuestionSchema.getQuestionOrder();
		parentID = aMInvQuestionSchema.getParentID();
		state = aMInvQuestionSchema.getState();
		childFlag = aMInvQuestionSchema.getChildFlag();
		vF01 = aMInvQuestionSchema.getVF01();
		nF01 = aMInvQuestionSchema.getNF01();
		iF01 = aMInvQuestionSchema.getIF01();
		dF02 = aMInvQuestionSchema.getDF02();
		date01 = fDate.getDate(aMInvQuestionSchema.getDate01());
		modifyOperator = aMInvQuestionSchema.getModifyOperator();
		operator = aMInvQuestionSchema.getOperator();
		makeDate = fDate.getDate(aMInvQuestionSchema.getMakeDate());
		makeTime = aMInvQuestionSchema.getMakeTime();
		modifyDate = fDate.getDate(aMInvQuestionSchema.getModifyDate());
		modifyTime = aMInvQuestionSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("QuestionID") == null)
				questionID = null;
			else
				questionID = rs.getString("QuestionID").trim();
			if (rs.getString("TopicID") == null)
				topicID = null;
			else
				topicID = rs.getString("TopicID").trim();
			if (rs.getString("Question") == null)
				question = null;
			else
				question = rs.getString("Question").trim();
			if (rs.getString("Depiction") == null)
				depiction = null;
			else
				depiction = rs.getString("Depiction").trim();
			if (rs.getString("QuestionType") == null)
				questionType = null;
			else
				questionType = rs.getString("QuestionType").trim();
			questionOrder = rs.getInt("QuestionOrder");
			if (rs.getString("ParentID") == null)
				parentID = null;
			else
				parentID = rs.getString("ParentID").trim();
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			if (rs.getString("ChildFlag") == null)
				childFlag = null;
			else
				childFlag = rs.getString("ChildFlag").trim();
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
			System.out.println("数据库中的MInvQuestion表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MInvQuestionSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MInvQuestionSchema getSchema()
	{
		MInvQuestionSchema aMInvQuestionSchema = new MInvQuestionSchema();
		aMInvQuestionSchema.setSchema(this);
		return aMInvQuestionSchema;
	}

	public MInvQuestionDB getDB()
	{
		MInvQuestionDB aDBOper = new MInvQuestionDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(questionID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(topicID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(question));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(depiction));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(questionType));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(questionOrder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(parentID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(childFlag));
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
			questionID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			topicID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			question = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			depiction = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			questionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			questionOrder = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).intValue();
			parentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			childFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MInvQuestionSchema";
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
		if (FCode.equalsIgnoreCase("questionID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionID));
		if (FCode.equalsIgnoreCase("topicID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(topicID));
		if (FCode.equalsIgnoreCase("question"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(question));
		if (FCode.equalsIgnoreCase("depiction"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(depiction));
		if (FCode.equalsIgnoreCase("questionType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionType));
		if (FCode.equalsIgnoreCase("questionOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionOrder));
		if (FCode.equalsIgnoreCase("parentID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(parentID));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("childFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(childFlag));
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
			strFieldValue = StrTool.GBKToUnicode(questionID);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(topicID);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(question);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(depiction);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(questionType);
			break;

		case 5: // '\005'
			strFieldValue = String.valueOf(questionOrder);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(parentID);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(childFlag);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(vF01);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(nF01);
			break;

		case 11: // '\013'
			strFieldValue = String.valueOf(iF01);
			break;

		case 12: // '\f'
			strFieldValue = String.valueOf(dF02);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 19: // '\023'
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
		if (FCode.equalsIgnoreCase("questionID"))
			if (FValue != null && !FValue.equals(""))
				questionID = FValue.trim();
			else
				questionID = null;
		if (FCode.equalsIgnoreCase("topicID"))
			if (FValue != null && !FValue.equals(""))
				topicID = FValue.trim();
			else
				topicID = null;
		if (FCode.equalsIgnoreCase("question"))
			if (FValue != null && !FValue.equals(""))
				question = FValue.trim();
			else
				question = null;
		if (FCode.equalsIgnoreCase("depiction"))
			if (FValue != null && !FValue.equals(""))
				depiction = FValue.trim();
			else
				depiction = null;
		if (FCode.equalsIgnoreCase("questionType"))
			if (FValue != null && !FValue.equals(""))
				questionType = FValue.trim();
			else
				questionType = null;
		if (FCode.equalsIgnoreCase("questionOrder") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			questionOrder = i;
		}
		if (FCode.equalsIgnoreCase("parentID"))
			if (FValue != null && !FValue.equals(""))
				parentID = FValue.trim();
			else
				parentID = null;
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("childFlag"))
			if (FValue != null && !FValue.equals(""))
				childFlag = FValue.trim();
			else
				childFlag = null;
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
		MInvQuestionSchema other = (MInvQuestionSchema)otherObject;
		if (questionID == null && other.getQuestionID() != null)
			return false;
		if (questionID != null && !questionID.equals(other.getQuestionID()))
			return false;
		if (topicID == null && other.getTopicID() != null)
			return false;
		if (topicID != null && !topicID.equals(other.getTopicID()))
			return false;
		if (question == null && other.getQuestion() != null)
			return false;
		if (question != null && !question.equals(other.getQuestion()))
			return false;
		if (depiction == null && other.getDepiction() != null)
			return false;
		if (depiction != null && !depiction.equals(other.getDepiction()))
			return false;
		if (questionType == null && other.getQuestionType() != null)
			return false;
		if (questionType != null && !questionType.equals(other.getQuestionType()))
			return false;
		if (questionOrder != other.getQuestionOrder())
			return false;
		if (parentID == null && other.getParentID() != null)
			return false;
		if (parentID != null && !parentID.equals(other.getParentID()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (childFlag == null && other.getChildFlag() != null)
			return false;
		if (childFlag != null && !childFlag.equals(other.getChildFlag()))
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
		return 20;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("questionID"))
			return 0;
		if (strFieldName.equals("topicID"))
			return 1;
		if (strFieldName.equals("question"))
			return 2;
		if (strFieldName.equals("depiction"))
			return 3;
		if (strFieldName.equals("questionType"))
			return 4;
		if (strFieldName.equals("questionOrder"))
			return 5;
		if (strFieldName.equals("parentID"))
			return 6;
		if (strFieldName.equals("state"))
			return 7;
		if (strFieldName.equals("childFlag"))
			return 8;
		if (strFieldName.equals("vF01"))
			return 9;
		if (strFieldName.equals("nF01"))
			return 10;
		if (strFieldName.equals("iF01"))
			return 11;
		if (strFieldName.equals("dF02"))
			return 12;
		if (strFieldName.equals("date01"))
			return 13;
		if (strFieldName.equals("modifyOperator"))
			return 14;
		if (strFieldName.equals("operator"))
			return 15;
		if (strFieldName.equals("makeDate"))
			return 16;
		if (strFieldName.equals("makeTime"))
			return 17;
		if (strFieldName.equals("modifyDate"))
			return 18;
		return !strFieldName.equals("modifyTime") ? -1 : 19;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "questionID";
			break;

		case 1: // '\001'
			strFieldName = "topicID";
			break;

		case 2: // '\002'
			strFieldName = "question";
			break;

		case 3: // '\003'
			strFieldName = "depiction";
			break;

		case 4: // '\004'
			strFieldName = "questionType";
			break;

		case 5: // '\005'
			strFieldName = "questionOrder";
			break;

		case 6: // '\006'
			strFieldName = "parentID";
			break;

		case 7: // '\007'
			strFieldName = "state";
			break;

		case 8: // '\b'
			strFieldName = "childFlag";
			break;

		case 9: // '\t'
			strFieldName = "vF01";
			break;

		case 10: // '\n'
			strFieldName = "nF01";
			break;

		case 11: // '\013'
			strFieldName = "iF01";
			break;

		case 12: // '\f'
			strFieldName = "dF02";
			break;

		case 13: // '\r'
			strFieldName = "date01";
			break;

		case 14: // '\016'
			strFieldName = "modifyOperator";
			break;

		case 15: // '\017'
			strFieldName = "operator";
			break;

		case 16: // '\020'
			strFieldName = "makeDate";
			break;

		case 17: // '\021'
			strFieldName = "makeTime";
			break;

		case 18: // '\022'
			strFieldName = "modifyDate";
			break;

		case 19: // '\023'
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
		if (strFieldName.equals("questionID"))
			return 0;
		if (strFieldName.equals("topicID"))
			return 0;
		if (strFieldName.equals("question"))
			return 0;
		if (strFieldName.equals("depiction"))
			return 0;
		if (strFieldName.equals("questionType"))
			return 0;
		if (strFieldName.equals("questionOrder"))
			return 3;
		if (strFieldName.equals("parentID"))
			return 0;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("childFlag"))
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
			nFieldType = 3;
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

		case 10: // '\n'
			nFieldType = 0;
			break;

		case 11: // '\013'
			nFieldType = 3;
			break;

		case 12: // '\f'
			nFieldType = 4;
			break;

		case 13: // '\r'
			nFieldType = 1;
			break;

		case 14: // '\016'
			nFieldType = 0;
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

		case 18: // '\022'
			nFieldType = 1;
			break;

		case 19: // '\023'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
