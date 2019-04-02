// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPFAndIImpQueSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPFAndIImpQueDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPFAndIImpQueSchema
	implements Schema, Cloneable
{

	private String impartId;
	private String questionid;
	private String questionType;
	private String content1;
	private String content2;
	private String queOrder;
	private String innerOrder;
	private String outQueId;
	private String innerQueNum;
	private String parentId;
	private String childQueNum;
	private String operator;
	private String manageCom;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 17;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPFAndIImpQueSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "Questionid";
		pk[1] = "InnerOrder";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPFAndIImpQueSchema cloned = (LNPFAndIImpQueSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getImpartId()
	{
		return impartId;
	}

	public void setImpartId(String aImpartId)
	{
		impartId = aImpartId;
	}

	public String getQuestionid()
	{
		return questionid;
	}

	public void setQuestionid(String aQuestionid)
	{
		questionid = aQuestionid;
	}

	public String getQuestionType()
	{
		return questionType;
	}

	public void setQuestionType(String aQuestionType)
	{
		questionType = aQuestionType;
	}

	public String getContent1()
	{
		return content1;
	}

	public void setContent1(String aContent1)
	{
		content1 = aContent1;
	}

	public String getContent2()
	{
		return content2;
	}

	public void setContent2(String aContent2)
	{
		content2 = aContent2;
	}

	public String getQueOrder()
	{
		return queOrder;
	}

	public void setQueOrder(String aQueOrder)
	{
		queOrder = aQueOrder;
	}

	public String getInnerOrder()
	{
		return innerOrder;
	}

	public void setInnerOrder(String aInnerOrder)
	{
		innerOrder = aInnerOrder;
	}

	public String getOutQueId()
	{
		return outQueId;
	}

	public void setOutQueId(String aOutQueId)
	{
		outQueId = aOutQueId;
	}

	public String getInnerQueNum()
	{
		return innerQueNum;
	}

	public void setInnerQueNum(String aInnerQueNum)
	{
		innerQueNum = aInnerQueNum;
	}

	public String getParentId()
	{
		return parentId;
	}

	public void setParentId(String aParentId)
	{
		parentId = aParentId;
	}

	public String getChildQueNum()
	{
		return childQueNum;
	}

	public void setChildQueNum(String aChildQueNum)
	{
		childQueNum = aChildQueNum;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
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

	public void setSchema(LNPFAndIImpQueSchema aLNPFAndIImpQueSchema)
	{
		impartId = aLNPFAndIImpQueSchema.getImpartId();
		questionid = aLNPFAndIImpQueSchema.getQuestionid();
		questionType = aLNPFAndIImpQueSchema.getQuestionType();
		content1 = aLNPFAndIImpQueSchema.getContent1();
		content2 = aLNPFAndIImpQueSchema.getContent2();
		queOrder = aLNPFAndIImpQueSchema.getQueOrder();
		innerOrder = aLNPFAndIImpQueSchema.getInnerOrder();
		outQueId = aLNPFAndIImpQueSchema.getOutQueId();
		innerQueNum = aLNPFAndIImpQueSchema.getInnerQueNum();
		parentId = aLNPFAndIImpQueSchema.getParentId();
		childQueNum = aLNPFAndIImpQueSchema.getChildQueNum();
		operator = aLNPFAndIImpQueSchema.getOperator();
		manageCom = aLNPFAndIImpQueSchema.getManageCom();
		makeDate = fDate.getDate(aLNPFAndIImpQueSchema.getMakeDate());
		makeTime = aLNPFAndIImpQueSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPFAndIImpQueSchema.getModifyDate());
		modifyTime = aLNPFAndIImpQueSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ImpartId") == null)
				impartId = null;
			else
				impartId = rs.getString("ImpartId").trim();
			if (rs.getString("Questionid") == null)
				questionid = null;
			else
				questionid = rs.getString("Questionid").trim();
			if (rs.getString("QuestionType") == null)
				questionType = null;
			else
				questionType = rs.getString("QuestionType").trim();
			if (rs.getString("Content1") == null)
				content1 = null;
			else
				content1 = rs.getString("Content1").trim();
			if (rs.getString("Content2") == null)
				content2 = null;
			else
				content2 = rs.getString("Content2").trim();
			if (rs.getString("QueOrder") == null)
				queOrder = null;
			else
				queOrder = rs.getString("QueOrder").trim();
			if (rs.getString("InnerOrder") == null)
				innerOrder = null;
			else
				innerOrder = rs.getString("InnerOrder").trim();
			if (rs.getString("OutQueId") == null)
				outQueId = null;
			else
				outQueId = rs.getString("OutQueId").trim();
			if (rs.getString("InnerQueNum") == null)
				innerQueNum = null;
			else
				innerQueNum = rs.getString("InnerQueNum").trim();
			if (rs.getString("ParentId") == null)
				parentId = null;
			else
				parentId = rs.getString("ParentId").trim();
			if (rs.getString("ChildQueNum") == null)
				childQueNum = null;
			else
				childQueNum = rs.getString("ChildQueNum").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
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
			System.out.println("?????§Ö?LNPFAndIImpQue????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpQueSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPFAndIImpQueSchema getSchema()
	{
		LNPFAndIImpQueSchema aLNPFAndIImpQueSchema = new LNPFAndIImpQueSchema();
		aLNPFAndIImpQueSchema.setSchema(this);
		return aLNPFAndIImpQueSchema;
	}

	public LNPFAndIImpQueDB getDB()
	{
		LNPFAndIImpQueDB aDBOper = new LNPFAndIImpQueDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(impartId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(questionid));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(questionType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(content1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(content2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(queOrder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(innerOrder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(outQueId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(innerQueNum));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(parentId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(childQueNum));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
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
			impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			questionid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			questionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			content1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			content2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			queOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			innerOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			outQueId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			innerQueNum = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			parentId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			childQueNum = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpQueSchema";
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
		if (FCode.equalsIgnoreCase("impartId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartId));
		if (FCode.equalsIgnoreCase("questionid"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionid));
		if (FCode.equalsIgnoreCase("questionType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionType));
		if (FCode.equalsIgnoreCase("content1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(content1));
		if (FCode.equalsIgnoreCase("content2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(content2));
		if (FCode.equalsIgnoreCase("queOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(queOrder));
		if (FCode.equalsIgnoreCase("innerOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(innerOrder));
		if (FCode.equalsIgnoreCase("outQueId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(outQueId));
		if (FCode.equalsIgnoreCase("innerQueNum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(innerQueNum));
		if (FCode.equalsIgnoreCase("parentId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(parentId));
		if (FCode.equalsIgnoreCase("childQueNum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(childQueNum));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
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
			strFieldValue = StrTool.GBKToUnicode(impartId);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(questionid);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(questionType);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(content1);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(content2);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(queOrder);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(innerOrder);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(outQueId);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(innerQueNum);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(parentId);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(childQueNum);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 16: // '\020'
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
		if (FCode.equalsIgnoreCase("impartId"))
			if (FValue != null && !FValue.equals(""))
				impartId = FValue.trim();
			else
				impartId = null;
		if (FCode.equalsIgnoreCase("questionid"))
			if (FValue != null && !FValue.equals(""))
				questionid = FValue.trim();
			else
				questionid = null;
		if (FCode.equalsIgnoreCase("questionType"))
			if (FValue != null && !FValue.equals(""))
				questionType = FValue.trim();
			else
				questionType = null;
		if (FCode.equalsIgnoreCase("content1"))
			if (FValue != null && !FValue.equals(""))
				content1 = FValue.trim();
			else
				content1 = null;
		if (FCode.equalsIgnoreCase("content2"))
			if (FValue != null && !FValue.equals(""))
				content2 = FValue.trim();
			else
				content2 = null;
		if (FCode.equalsIgnoreCase("queOrder"))
			if (FValue != null && !FValue.equals(""))
				queOrder = FValue.trim();
			else
				queOrder = null;
		if (FCode.equalsIgnoreCase("innerOrder"))
			if (FValue != null && !FValue.equals(""))
				innerOrder = FValue.trim();
			else
				innerOrder = null;
		if (FCode.equalsIgnoreCase("outQueId"))
			if (FValue != null && !FValue.equals(""))
				outQueId = FValue.trim();
			else
				outQueId = null;
		if (FCode.equalsIgnoreCase("innerQueNum"))
			if (FValue != null && !FValue.equals(""))
				innerQueNum = FValue.trim();
			else
				innerQueNum = null;
		if (FCode.equalsIgnoreCase("parentId"))
			if (FValue != null && !FValue.equals(""))
				parentId = FValue.trim();
			else
				parentId = null;
		if (FCode.equalsIgnoreCase("childQueNum"))
			if (FValue != null && !FValue.equals(""))
				childQueNum = FValue.trim();
			else
				childQueNum = null;
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
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
		LNPFAndIImpQueSchema other = (LNPFAndIImpQueSchema)otherObject;
		if (impartId == null && other.getImpartId() != null)
			return false;
		if (impartId != null && !impartId.equals(other.getImpartId()))
			return false;
		if (questionid == null && other.getQuestionid() != null)
			return false;
		if (questionid != null && !questionid.equals(other.getQuestionid()))
			return false;
		if (questionType == null && other.getQuestionType() != null)
			return false;
		if (questionType != null && !questionType.equals(other.getQuestionType()))
			return false;
		if (content1 == null && other.getContent1() != null)
			return false;
		if (content1 != null && !content1.equals(other.getContent1()))
			return false;
		if (content2 == null && other.getContent2() != null)
			return false;
		if (content2 != null && !content2.equals(other.getContent2()))
			return false;
		if (queOrder == null && other.getQueOrder() != null)
			return false;
		if (queOrder != null && !queOrder.equals(other.getQueOrder()))
			return false;
		if (innerOrder == null && other.getInnerOrder() != null)
			return false;
		if (innerOrder != null && !innerOrder.equals(other.getInnerOrder()))
			return false;
		if (outQueId == null && other.getOutQueId() != null)
			return false;
		if (outQueId != null && !outQueId.equals(other.getOutQueId()))
			return false;
		if (innerQueNum == null && other.getInnerQueNum() != null)
			return false;
		if (innerQueNum != null && !innerQueNum.equals(other.getInnerQueNum()))
			return false;
		if (parentId == null && other.getParentId() != null)
			return false;
		if (parentId != null && !parentId.equals(other.getParentId()))
			return false;
		if (childQueNum == null && other.getChildQueNum() != null)
			return false;
		if (childQueNum != null && !childQueNum.equals(other.getChildQueNum()))
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
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
		return 17;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("impartId"))
			return 0;
		if (strFieldName.equals("questionid"))
			return 1;
		if (strFieldName.equals("questionType"))
			return 2;
		if (strFieldName.equals("content1"))
			return 3;
		if (strFieldName.equals("content2"))
			return 4;
		if (strFieldName.equals("queOrder"))
			return 5;
		if (strFieldName.equals("innerOrder"))
			return 6;
		if (strFieldName.equals("outQueId"))
			return 7;
		if (strFieldName.equals("innerQueNum"))
			return 8;
		if (strFieldName.equals("parentId"))
			return 9;
		if (strFieldName.equals("childQueNum"))
			return 10;
		if (strFieldName.equals("operator"))
			return 11;
		if (strFieldName.equals("manageCom"))
			return 12;
		if (strFieldName.equals("makeDate"))
			return 13;
		if (strFieldName.equals("makeTime"))
			return 14;
		if (strFieldName.equals("modifyDate"))
			return 15;
		return !strFieldName.equals("modifyTime") ? -1 : 16;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "impartId";
			break;

		case 1: // '\001'
			strFieldName = "questionid";
			break;

		case 2: // '\002'
			strFieldName = "questionType";
			break;

		case 3: // '\003'
			strFieldName = "content1";
			break;

		case 4: // '\004'
			strFieldName = "content2";
			break;

		case 5: // '\005'
			strFieldName = "queOrder";
			break;

		case 6: // '\006'
			strFieldName = "innerOrder";
			break;

		case 7: // '\007'
			strFieldName = "outQueId";
			break;

		case 8: // '\b'
			strFieldName = "innerQueNum";
			break;

		case 9: // '\t'
			strFieldName = "parentId";
			break;

		case 10: // '\n'
			strFieldName = "childQueNum";
			break;

		case 11: // '\013'
			strFieldName = "operator";
			break;

		case 12: // '\f'
			strFieldName = "manageCom";
			break;

		case 13: // '\r'
			strFieldName = "makeDate";
			break;

		case 14: // '\016'
			strFieldName = "makeTime";
			break;

		case 15: // '\017'
			strFieldName = "modifyDate";
			break;

		case 16: // '\020'
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
		if (strFieldName.equals("impartId"))
			return 0;
		if (strFieldName.equals("questionid"))
			return 0;
		if (strFieldName.equals("questionType"))
			return 0;
		if (strFieldName.equals("content1"))
			return 0;
		if (strFieldName.equals("content2"))
			return 0;
		if (strFieldName.equals("queOrder"))
			return 0;
		if (strFieldName.equals("innerOrder"))
			return 0;
		if (strFieldName.equals("outQueId"))
			return 0;
		if (strFieldName.equals("innerQueNum"))
			return 0;
		if (strFieldName.equals("parentId"))
			return 0;
		if (strFieldName.equals("childQueNum"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("manageCom"))
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
			nFieldType = 1;
			break;

		case 14: // '\016'
			nFieldType = 0;
			break;

		case 15: // '\017'
			nFieldType = 1;
			break;

		case 16: // '\020'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
