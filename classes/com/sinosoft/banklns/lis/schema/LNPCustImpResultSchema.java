// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCustImpResultSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPCustImpResultSchema
	implements Schema, Cloneable
{

	private String resultId;
	private String impartId;
	private String questionId;
	private String questionType;
	private String queInnerOrder;
	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private String customerNo;
	private String customerId;
	private String optionId;
	private String answer;
	private String operator;
	private String manageCom;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 18;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPCustImpResultSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ResultId";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPCustImpResultSchema cloned = (LNPCustImpResultSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getResultId()
	{
		return resultId;
	}

	public void setResultId(String aResultId)
	{
		resultId = aResultId;
	}

	public String getImpartId()
	{
		return impartId;
	}

	public void setImpartId(String aImpartId)
	{
		impartId = aImpartId;
	}

	public String getQuestionId()
	{
		return questionId;
	}

	public void setQuestionId(String aQuestionId)
	{
		questionId = aQuestionId;
	}

	public String getQuestionType()
	{
		return questionType;
	}

	public void setQuestionType(String aQuestionType)
	{
		questionType = aQuestionType;
	}

	public String getQueInnerOrder()
	{
		return queInnerOrder;
	}

	public void setQueInnerOrder(String aQueInnerOrder)
	{
		queInnerOrder = aQueInnerOrder;
	}

	public String getGrpContNo()
	{
		return grpContNo;
	}

	public void setGrpContNo(String aGrpContNo)
	{
		grpContNo = aGrpContNo;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String aContNo)
	{
		contNo = aContNo;
	}

	public String getProposalContNo()
	{
		return proposalContNo;
	}

	public void setProposalContNo(String aProposalContNo)
	{
		proposalContNo = aProposalContNo;
	}

	public String getCustomerNo()
	{
		return customerNo;
	}

	public void setCustomerNo(String aCustomerNo)
	{
		customerNo = aCustomerNo;
	}

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String aCustomerId)
	{
		customerId = aCustomerId;
	}

	public String getOptionId()
	{
		return optionId;
	}

	public void setOptionId(String aOptionId)
	{
		optionId = aOptionId;
	}

	public String getAnswer()
	{
		return answer;
	}

	public void setAnswer(String aAnswer)
	{
		answer = aAnswer;
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

	public void setSchema(LNPCustImpResultSchema aLNPCustImpResultSchema)
	{
		resultId = aLNPCustImpResultSchema.getResultId();
		impartId = aLNPCustImpResultSchema.getImpartId();
		questionId = aLNPCustImpResultSchema.getQuestionId();
		questionType = aLNPCustImpResultSchema.getQuestionType();
		queInnerOrder = aLNPCustImpResultSchema.getQueInnerOrder();
		grpContNo = aLNPCustImpResultSchema.getGrpContNo();
		contNo = aLNPCustImpResultSchema.getContNo();
		proposalContNo = aLNPCustImpResultSchema.getProposalContNo();
		customerNo = aLNPCustImpResultSchema.getCustomerNo();
		customerId = aLNPCustImpResultSchema.getCustomerId();
		optionId = aLNPCustImpResultSchema.getOptionId();
		answer = aLNPCustImpResultSchema.getAnswer();
		operator = aLNPCustImpResultSchema.getOperator();
		manageCom = aLNPCustImpResultSchema.getManageCom();
		makeDate = fDate.getDate(aLNPCustImpResultSchema.getMakeDate());
		makeTime = aLNPCustImpResultSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPCustImpResultSchema.getModifyDate());
		modifyTime = aLNPCustImpResultSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ResultId") == null)
				resultId = null;
			else
				resultId = rs.getString("ResultId").trim();
			if (rs.getString("ImpartId") == null)
				impartId = null;
			else
				impartId = rs.getString("ImpartId").trim();
			if (rs.getString("QuestionId") == null)
				questionId = null;
			else
				questionId = rs.getString("QuestionId").trim();
			if (rs.getString("QuestionType") == null)
				questionType = null;
			else
				questionType = rs.getString("QuestionType").trim();
			if (rs.getString("QueInnerOrder") == null)
				queInnerOrder = null;
			else
				queInnerOrder = rs.getString("QueInnerOrder").trim();
			if (rs.getString("GrpContNo") == null)
				grpContNo = null;
			else
				grpContNo = rs.getString("GrpContNo").trim();
			if (rs.getString("ContNo") == null)
				contNo = null;
			else
				contNo = rs.getString("ContNo").trim();
			if (rs.getString("ProposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("ProposalContNo").trim();
			if (rs.getString("CustomerNo") == null)
				customerNo = null;
			else
				customerNo = rs.getString("CustomerNo").trim();
			if (rs.getString("CustomerId") == null)
				customerId = null;
			else
				customerId = rs.getString("CustomerId").trim();
			if (rs.getString("OptionId") == null)
				optionId = null;
			else
				optionId = rs.getString("OptionId").trim();
			if (rs.getString("Answer") == null)
				answer = null;
			else
				answer = rs.getString("Answer").trim();
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
			System.out.println("数据库中的LNPCustImpResult表字段个数和Schema中的字段个数不一致，或�?�执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPCustImpResultSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPCustImpResultSchema getSchema()
	{
		LNPCustImpResultSchema aLNPCustImpResultSchema = new LNPCustImpResultSchema();
		aLNPCustImpResultSchema.setSchema(this);
		return aLNPCustImpResultSchema;
	}

	public LNPCustImpResultDB getDB()
	{
		LNPCustImpResultDB aDBOper = new LNPCustImpResultDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(resultId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(impartId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(questionId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(questionType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(queInnerOrder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proposalContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(customerNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(customerId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(optionId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(answer));
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
			resultId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			questionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			questionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			queInnerOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			optionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			answer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCustImpResultSchema";
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
		if (FCode.equalsIgnoreCase("resultId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(resultId));
		if (FCode.equalsIgnoreCase("impartId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartId));
		if (FCode.equalsIgnoreCase("questionId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionId));
		if (FCode.equalsIgnoreCase("questionType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionType));
		if (FCode.equalsIgnoreCase("queInnerOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(queInnerOrder));
		if (FCode.equalsIgnoreCase("grpContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpContNo));
		if (FCode.equalsIgnoreCase("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equalsIgnoreCase("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equalsIgnoreCase("customerNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerNo));
		if (FCode.equalsIgnoreCase("customerId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerId));
		if (FCode.equalsIgnoreCase("optionId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(optionId));
		if (FCode.equalsIgnoreCase("answer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(answer));
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
			strFieldValue = StrTool.GBKToUnicode(resultId);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(impartId);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(questionId);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(questionType);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(queInnerOrder);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(customerNo);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(customerId);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(optionId);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(answer);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
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
		if (FCode.equalsIgnoreCase("resultId"))
			if (FValue != null && !FValue.equals(""))
				resultId = FValue.trim();
			else
				resultId = null;
		if (FCode.equalsIgnoreCase("impartId"))
			if (FValue != null && !FValue.equals(""))
				impartId = FValue.trim();
			else
				impartId = null;
		if (FCode.equalsIgnoreCase("questionId"))
			if (FValue != null && !FValue.equals(""))
				questionId = FValue.trim();
			else
				questionId = null;
		if (FCode.equalsIgnoreCase("questionType"))
			if (FValue != null && !FValue.equals(""))
				questionType = FValue.trim();
			else
				questionType = null;
		if (FCode.equalsIgnoreCase("queInnerOrder"))
			if (FValue != null && !FValue.equals(""))
				queInnerOrder = FValue.trim();
			else
				queInnerOrder = null;
		if (FCode.equalsIgnoreCase("grpContNo"))
			if (FValue != null && !FValue.equals(""))
				grpContNo = FValue.trim();
			else
				grpContNo = null;
		if (FCode.equalsIgnoreCase("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equalsIgnoreCase("proposalContNo"))
			if (FValue != null && !FValue.equals(""))
				proposalContNo = FValue.trim();
			else
				proposalContNo = null;
		if (FCode.equalsIgnoreCase("customerNo"))
			if (FValue != null && !FValue.equals(""))
				customerNo = FValue.trim();
			else
				customerNo = null;
		if (FCode.equalsIgnoreCase("customerId"))
			if (FValue != null && !FValue.equals(""))
				customerId = FValue.trim();
			else
				customerId = null;
		if (FCode.equalsIgnoreCase("optionId"))
			if (FValue != null && !FValue.equals(""))
				optionId = FValue.trim();
			else
				optionId = null;
		if (FCode.equalsIgnoreCase("answer"))
			if (FValue != null && !FValue.equals(""))
				answer = FValue.trim();
			else
				answer = null;
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
		LNPCustImpResultSchema other = (LNPCustImpResultSchema)otherObject;
		if (resultId == null && other.getResultId() != null)
			return false;
		if (resultId != null && !resultId.equals(other.getResultId()))
			return false;
		if (impartId == null && other.getImpartId() != null)
			return false;
		if (impartId != null && !impartId.equals(other.getImpartId()))
			return false;
		if (questionId == null && other.getQuestionId() != null)
			return false;
		if (questionId != null && !questionId.equals(other.getQuestionId()))
			return false;
		if (questionType == null && other.getQuestionType() != null)
			return false;
		if (questionType != null && !questionType.equals(other.getQuestionType()))
			return false;
		if (queInnerOrder == null && other.getQueInnerOrder() != null)
			return false;
		if (queInnerOrder != null && !queInnerOrder.equals(other.getQueInnerOrder()))
			return false;
		if (grpContNo == null && other.getGrpContNo() != null)
			return false;
		if (grpContNo != null && !grpContNo.equals(other.getGrpContNo()))
			return false;
		if (contNo == null && other.getContNo() != null)
			return false;
		if (contNo != null && !contNo.equals(other.getContNo()))
			return false;
		if (proposalContNo == null && other.getProposalContNo() != null)
			return false;
		if (proposalContNo != null && !proposalContNo.equals(other.getProposalContNo()))
			return false;
		if (customerNo == null && other.getCustomerNo() != null)
			return false;
		if (customerNo != null && !customerNo.equals(other.getCustomerNo()))
			return false;
		if (customerId == null && other.getCustomerId() != null)
			return false;
		if (customerId != null && !customerId.equals(other.getCustomerId()))
			return false;
		if (optionId == null && other.getOptionId() != null)
			return false;
		if (optionId != null && !optionId.equals(other.getOptionId()))
			return false;
		if (answer == null && other.getAnswer() != null)
			return false;
		if (answer != null && !answer.equals(other.getAnswer()))
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
		return 18;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("resultId"))
			return 0;
		if (strFieldName.equals("impartId"))
			return 1;
		if (strFieldName.equals("questionId"))
			return 2;
		if (strFieldName.equals("questionType"))
			return 3;
		if (strFieldName.equals("queInnerOrder"))
			return 4;
		if (strFieldName.equals("grpContNo"))
			return 5;
		if (strFieldName.equals("contNo"))
			return 6;
		if (strFieldName.equals("proposalContNo"))
			return 7;
		if (strFieldName.equals("customerNo"))
			return 8;
		if (strFieldName.equals("customerId"))
			return 9;
		if (strFieldName.equals("optionId"))
			return 10;
		if (strFieldName.equals("answer"))
			return 11;
		if (strFieldName.equals("operator"))
			return 12;
		if (strFieldName.equals("manageCom"))
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
			strFieldName = "resultId";
			break;

		case 1: // '\001'
			strFieldName = "impartId";
			break;

		case 2: // '\002'
			strFieldName = "questionId";
			break;

		case 3: // '\003'
			strFieldName = "questionType";
			break;

		case 4: // '\004'
			strFieldName = "queInnerOrder";
			break;

		case 5: // '\005'
			strFieldName = "grpContNo";
			break;

		case 6: // '\006'
			strFieldName = "contNo";
			break;

		case 7: // '\007'
			strFieldName = "proposalContNo";
			break;

		case 8: // '\b'
			strFieldName = "customerNo";
			break;

		case 9: // '\t'
			strFieldName = "customerId";
			break;

		case 10: // '\n'
			strFieldName = "optionId";
			break;

		case 11: // '\013'
			strFieldName = "answer";
			break;

		case 12: // '\f'
			strFieldName = "operator";
			break;

		case 13: // '\r'
			strFieldName = "manageCom";
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
		if (strFieldName.equals("resultId"))
			return 0;
		if (strFieldName.equals("impartId"))
			return 0;
		if (strFieldName.equals("questionId"))
			return 0;
		if (strFieldName.equals("questionType"))
			return 0;
		if (strFieldName.equals("queInnerOrder"))
			return 0;
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("proposalContNo"))
			return 0;
		if (strFieldName.equals("customerNo"))
			return 0;
		if (strFieldName.equals("customerId"))
			return 0;
		if (strFieldName.equals("optionId"))
			return 0;
		if (strFieldName.equals("answer"))
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
