// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCustImpResultBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPCustImpResultBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPCustImpResultBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
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
	public static final int FIELDNUM = 20;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPCustImpResultBSchema()
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

	public String getresultId()
	{
		if (resultId != null)
			resultId.equals("");
		return resultId;
	}

	public void setresultId(String aresultId)
	{
		resultId = aresultId;
	}

	public String getimpartId()
	{
		if (impartId != null)
			impartId.equals("");
		return impartId;
	}

	public void setimpartId(String aimpartId)
	{
		impartId = aimpartId;
	}

	public String getquestionId()
	{
		if (questionId != null)
			questionId.equals("");
		return questionId;
	}

	public void setquestionId(String aquestionId)
	{
		questionId = aquestionId;
	}

	public String getquestionType()
	{
		if (questionType != null)
			questionType.equals("");
		return questionType;
	}

	public void setquestionType(String aquestionType)
	{
		questionType = aquestionType;
	}

	public String getqueInnerOrder()
	{
		if (queInnerOrder != null)
			queInnerOrder.equals("");
		return queInnerOrder;
	}

	public void setqueInnerOrder(String aqueInnerOrder)
	{
		queInnerOrder = aqueInnerOrder;
	}

	public String getgrpContNo()
	{
		if (grpContNo != null)
			grpContNo.equals("");
		return grpContNo;
	}

	public void setgrpContNo(String agrpContNo)
	{
		grpContNo = agrpContNo;
	}

	public String getcontNo()
	{
		if (contNo != null)
			contNo.equals("");
		return contNo;
	}

	public void setcontNo(String acontNo)
	{
		contNo = acontNo;
	}

	public String getproposalContNo()
	{
		if (proposalContNo != null)
			proposalContNo.equals("");
		return proposalContNo;
	}

	public void setproposalContNo(String aproposalContNo)
	{
		proposalContNo = aproposalContNo;
	}

	public String getcustomerNo()
	{
		if (customerNo != null)
			customerNo.equals("");
		return customerNo;
	}

	public void setcustomerNo(String acustomerNo)
	{
		customerNo = acustomerNo;
	}

	public String getcustomerId()
	{
		if (customerId != null)
			customerId.equals("");
		return customerId;
	}

	public void setcustomerId(String acustomerId)
	{
		customerId = acustomerId;
	}

	public String getoptionId()
	{
		if (optionId != null)
			optionId.equals("");
		return optionId;
	}

	public void setoptionId(String aoptionId)
	{
		optionId = aoptionId;
	}

	public String getanswer()
	{
		if (answer != null)
			answer.equals("");
		return answer;
	}

	public void setanswer(String aanswer)
	{
		answer = aanswer;
	}

	public String getoperator()
	{
		if (operator != null)
			operator.equals("");
		return operator;
	}

	public void setoperator(String aoperator)
	{
		operator = aoperator;
	}

	public String getmanageCom()
	{
		if (manageCom != null)
			manageCom.equals("");
		return manageCom;
	}

	public void setmanageCom(String amanageCom)
	{
		manageCom = amanageCom;
	}

	public String getmakeDate()
	{
		if (makeDate != null)
			return fDate.getString(makeDate);
		else
			return null;
	}

	public void setmakeDate(Date amakeDate)
	{
		makeDate = amakeDate;
	}

	public void setmakeDate(String amakeDate)
	{
		if (amakeDate != null && !amakeDate.equals(""))
			makeDate = fDate.getDate(amakeDate);
		else
			makeDate = null;
	}

	public String getmakeTime()
	{
		if (makeTime != null)
			makeTime.equals("");
		return makeTime;
	}

	public void setmakeTime(String amakeTime)
	{
		makeTime = amakeTime;
	}

	public String getmodifyDate()
	{
		if (modifyDate != null)
			return fDate.getString(modifyDate);
		else
			return null;
	}

	public void setmodifyDate(Date amodifyDate)
	{
		modifyDate = amodifyDate;
	}

	public void setmodifyDate(String amodifyDate)
	{
		if (amodifyDate != null && !amodifyDate.equals(""))
			modifyDate = fDate.getDate(amodifyDate);
		else
			modifyDate = null;
	}

	public String getmodifyTime()
	{
		if (modifyTime != null)
			modifyTime.equals("");
		return modifyTime;
	}

	public void setmodifyTime(String amodifyTime)
	{
		modifyTime = amodifyTime;
	}

	public void setSchema(LNPCustImpResultBSchema aLNPCustImpResultBSchema)
	{
		EdorNo = aLNPCustImpResultBSchema.getEdorNo();
		serialNo = aLNPCustImpResultBSchema.getserialNo();
		resultId = aLNPCustImpResultBSchema.getresultId();
		impartId = aLNPCustImpResultBSchema.getimpartId();
		questionId = aLNPCustImpResultBSchema.getquestionId();
		questionType = aLNPCustImpResultBSchema.getquestionType();
		queInnerOrder = aLNPCustImpResultBSchema.getqueInnerOrder();
		grpContNo = aLNPCustImpResultBSchema.getgrpContNo();
		contNo = aLNPCustImpResultBSchema.getcontNo();
		proposalContNo = aLNPCustImpResultBSchema.getproposalContNo();
		customerNo = aLNPCustImpResultBSchema.getcustomerNo();
		customerId = aLNPCustImpResultBSchema.getcustomerId();
		optionId = aLNPCustImpResultBSchema.getoptionId();
		answer = aLNPCustImpResultBSchema.getanswer();
		operator = aLNPCustImpResultBSchema.getoperator();
		manageCom = aLNPCustImpResultBSchema.getmanageCom();
		makeDate = fDate.getDate(aLNPCustImpResultBSchema.getmakeDate());
		makeTime = aLNPCustImpResultBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPCustImpResultBSchema.getmodifyDate());
		modifyTime = aLNPCustImpResultBSchema.getmodifyTime();
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
			if (rs.getString("resultId") == null)
				resultId = null;
			else
				resultId = rs.getString("resultId").trim();
			if (rs.getString("impartId") == null)
				impartId = null;
			else
				impartId = rs.getString("impartId").trim();
			if (rs.getString("questionId") == null)
				questionId = null;
			else
				questionId = rs.getString("questionId").trim();
			if (rs.getString("questionType") == null)
				questionType = null;
			else
				questionType = rs.getString("questionType").trim();
			if (rs.getString("queInnerOrder") == null)
				queInnerOrder = null;
			else
				queInnerOrder = rs.getString("queInnerOrder").trim();
			if (rs.getString("grpContNo") == null)
				grpContNo = null;
			else
				grpContNo = rs.getString("grpContNo").trim();
			if (rs.getString("contNo") == null)
				contNo = null;
			else
				contNo = rs.getString("contNo").trim();
			if (rs.getString("proposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("proposalContNo").trim();
			if (rs.getString("customerNo") == null)
				customerNo = null;
			else
				customerNo = rs.getString("customerNo").trim();
			if (rs.getString("customerId") == null)
				customerId = null;
			else
				customerId = rs.getString("customerId").trim();
			if (rs.getString("optionId") == null)
				optionId = null;
			else
				optionId = rs.getString("optionId").trim();
			if (rs.getString("answer") == null)
				answer = null;
			else
				answer = rs.getString("answer").trim();
			if (rs.getString("operator") == null)
				operator = null;
			else
				operator = rs.getString("operator").trim();
			if (rs.getString("manageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("manageCom").trim();
			makeDate = rs.getDate("makeDate");
			if (rs.getString("makeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("makeTime").trim();
			modifyDate = rs.getDate("modifyDate");
			if (rs.getString("modifyTime") == null)
				modifyTime = null;
			else
				modifyTime = rs.getString("modifyTime").trim();
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCustImpResultBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPCustImpResultBSchema getSchema()
	{
		LNPCustImpResultBSchema aLNPCustImpResultBSchema = new LNPCustImpResultBSchema();
		aLNPCustImpResultBSchema.setSchema(this);
		return aLNPCustImpResultBSchema;
	}

	public LNPCustImpResultBDB getDB()
	{
		LNPCustImpResultBDB aDBOper = new LNPCustImpResultBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(resultId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(impartId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(questionId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(questionType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(queInnerOrder))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proposalContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(customerNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(customerId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(optionId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(answer))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(manageCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			resultId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			questionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			questionType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			queInnerOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			optionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			answer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCustImpResultBSchema";
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
		if (FCode.equals("resultId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(resultId));
		if (FCode.equals("impartId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartId));
		if (FCode.equals("questionId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionId));
		if (FCode.equals("questionType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionType));
		if (FCode.equals("queInnerOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(queInnerOrder));
		if (FCode.equals("grpContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpContNo));
		if (FCode.equals("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equals("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equals("customerNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerNo));
		if (FCode.equals("customerId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerId));
		if (FCode.equals("optionId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(optionId));
		if (FCode.equals("answer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(answer));
		if (FCode.equals("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equals("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equals("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
		if (FCode.equals("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equals("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
		if (FCode.equals("modifyTime"))
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
			strFieldValue = StrTool.GBKToUnicode(EdorNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(serialNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(resultId);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(impartId);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(questionId);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(questionType);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(queInnerOrder);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(customerNo);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(customerId);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(optionId);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(answer);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
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
		if (FCode.equals("resultId"))
			if (FValue != null && !FValue.equals(""))
				resultId = FValue.trim();
			else
				resultId = null;
		if (FCode.equals("impartId"))
			if (FValue != null && !FValue.equals(""))
				impartId = FValue.trim();
			else
				impartId = null;
		if (FCode.equals("questionId"))
			if (FValue != null && !FValue.equals(""))
				questionId = FValue.trim();
			else
				questionId = null;
		if (FCode.equals("questionType"))
			if (FValue != null && !FValue.equals(""))
				questionType = FValue.trim();
			else
				questionType = null;
		if (FCode.equals("queInnerOrder"))
			if (FValue != null && !FValue.equals(""))
				queInnerOrder = FValue.trim();
			else
				queInnerOrder = null;
		if (FCode.equals("grpContNo"))
			if (FValue != null && !FValue.equals(""))
				grpContNo = FValue.trim();
			else
				grpContNo = null;
		if (FCode.equals("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equals("proposalContNo"))
			if (FValue != null && !FValue.equals(""))
				proposalContNo = FValue.trim();
			else
				proposalContNo = null;
		if (FCode.equals("customerNo"))
			if (FValue != null && !FValue.equals(""))
				customerNo = FValue.trim();
			else
				customerNo = null;
		if (FCode.equals("customerId"))
			if (FValue != null && !FValue.equals(""))
				customerId = FValue.trim();
			else
				customerId = null;
		if (FCode.equals("optionId"))
			if (FValue != null && !FValue.equals(""))
				optionId = FValue.trim();
			else
				optionId = null;
		if (FCode.equals("answer"))
			if (FValue != null && !FValue.equals(""))
				answer = FValue.trim();
			else
				answer = null;
		if (FCode.equals("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equals("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equals("makeDate"))
			if (FValue != null && !FValue.equals(""))
				makeDate = fDate.getDate(FValue);
			else
				makeDate = null;
		if (FCode.equals("makeTime"))
			if (FValue != null && !FValue.equals(""))
				makeTime = FValue.trim();
			else
				makeTime = null;
		if (FCode.equals("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equals("modifyTime"))
			if (FValue != null && !FValue.equals(""))
				modifyTime = FValue.trim();
			else
				modifyTime = null;
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
		LNPCustImpResultBSchema other = (LNPCustImpResultBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && resultId.equals(other.getresultId()) && impartId.equals(other.getimpartId()) && questionId.equals(other.getquestionId()) && questionType.equals(other.getquestionType()) && queInnerOrder.equals(other.getqueInnerOrder()) && grpContNo.equals(other.getgrpContNo()) && contNo.equals(other.getcontNo()) && proposalContNo.equals(other.getproposalContNo()) && customerNo.equals(other.getcustomerNo()) && customerId.equals(other.getcustomerId()) && optionId.equals(other.getoptionId()) && answer.equals(other.getanswer()) && operator.equals(other.getoperator()) && manageCom.equals(other.getmanageCom()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime());
	}

	public int getFieldCount()
	{
		return 20;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("resultId"))
			return 2;
		if (strFieldName.equals("impartId"))
			return 3;
		if (strFieldName.equals("questionId"))
			return 4;
		if (strFieldName.equals("questionType"))
			return 5;
		if (strFieldName.equals("queInnerOrder"))
			return 6;
		if (strFieldName.equals("grpContNo"))
			return 7;
		if (strFieldName.equals("contNo"))
			return 8;
		if (strFieldName.equals("proposalContNo"))
			return 9;
		if (strFieldName.equals("customerNo"))
			return 10;
		if (strFieldName.equals("customerId"))
			return 11;
		if (strFieldName.equals("optionId"))
			return 12;
		if (strFieldName.equals("answer"))
			return 13;
		if (strFieldName.equals("operator"))
			return 14;
		if (strFieldName.equals("manageCom"))
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
			strFieldName = "EdorNo";
			break;

		case 1: // '\001'
			strFieldName = "serialNo";
			break;

		case 2: // '\002'
			strFieldName = "resultId";
			break;

		case 3: // '\003'
			strFieldName = "impartId";
			break;

		case 4: // '\004'
			strFieldName = "questionId";
			break;

		case 5: // '\005'
			strFieldName = "questionType";
			break;

		case 6: // '\006'
			strFieldName = "queInnerOrder";
			break;

		case 7: // '\007'
			strFieldName = "grpContNo";
			break;

		case 8: // '\b'
			strFieldName = "contNo";
			break;

		case 9: // '\t'
			strFieldName = "proposalContNo";
			break;

		case 10: // '\n'
			strFieldName = "customerNo";
			break;

		case 11: // '\013'
			strFieldName = "customerId";
			break;

		case 12: // '\f'
			strFieldName = "optionId";
			break;

		case 13: // '\r'
			strFieldName = "answer";
			break;

		case 14: // '\016'
			strFieldName = "operator";
			break;

		case 15: // '\017'
			strFieldName = "manageCom";
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
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 0;
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
