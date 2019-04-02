// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentIImpOptionSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPAgentIImpOptionDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPAgentIImpOptionSchema
	implements Schema, Cloneable
{

	private String impartId;
	private String questionId;
	private String optionId;
	private String optionOrder;
	private String optionContent;
	private String operator;
	private String manageCom;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 11;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPAgentIImpOptionSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "OptionId";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPAgentIImpOptionSchema cloned = (LNPAgentIImpOptionSchema)super.clone();
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

	public String getQuestionId()
	{
		return questionId;
	}

	public void setQuestionId(String aQuestionId)
	{
		questionId = aQuestionId;
	}

	public String getOptionId()
	{
		return optionId;
	}

	public void setOptionId(String aOptionId)
	{
		optionId = aOptionId;
	}

	public String getOptionOrder()
	{
		return optionOrder;
	}

	public void setOptionOrder(String aOptionOrder)
	{
		optionOrder = aOptionOrder;
	}

	public String getOptionContent()
	{
		return optionContent;
	}

	public void setOptionContent(String aOptionContent)
	{
		optionContent = aOptionContent;
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

	public void setSchema(LNPAgentIImpOptionSchema aLNPAgentIImpOptionSchema)
	{
		impartId = aLNPAgentIImpOptionSchema.getImpartId();
		questionId = aLNPAgentIImpOptionSchema.getQuestionId();
		optionId = aLNPAgentIImpOptionSchema.getOptionId();
		optionOrder = aLNPAgentIImpOptionSchema.getOptionOrder();
		optionContent = aLNPAgentIImpOptionSchema.getOptionContent();
		operator = aLNPAgentIImpOptionSchema.getOperator();
		manageCom = aLNPAgentIImpOptionSchema.getManageCom();
		makeDate = fDate.getDate(aLNPAgentIImpOptionSchema.getMakeDate());
		makeTime = aLNPAgentIImpOptionSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPAgentIImpOptionSchema.getModifyDate());
		modifyTime = aLNPAgentIImpOptionSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ImpartId") == null)
				impartId = null;
			else
				impartId = rs.getString("ImpartId").trim();
			if (rs.getString("QuestionId") == null)
				questionId = null;
			else
				questionId = rs.getString("QuestionId").trim();
			if (rs.getString("OptionId") == null)
				optionId = null;
			else
				optionId = rs.getString("OptionId").trim();
			if (rs.getString("OptionOrder") == null)
				optionOrder = null;
			else
				optionOrder = rs.getString("OptionOrder").trim();
			if (rs.getString("OptionContent") == null)
				optionContent = null;
			else
				optionContent = rs.getString("OptionContent").trim();
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
			System.out.println("数据库中的LNPAgentIImpOption表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPAgentIImpOptionSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPAgentIImpOptionSchema getSchema()
	{
		LNPAgentIImpOptionSchema aLNPAgentIImpOptionSchema = new LNPAgentIImpOptionSchema();
		aLNPAgentIImpOptionSchema.setSchema(this);
		return aLNPAgentIImpOptionSchema;
	}

	public LNPAgentIImpOptionDB getDB()
	{
		LNPAgentIImpOptionDB aDBOper = new LNPAgentIImpOptionDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(impartId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(questionId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(optionId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(optionOrder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(optionContent));
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
			questionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			optionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			optionOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			optionContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentIImpOptionSchema";
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
		if (FCode.equalsIgnoreCase("questionId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionId));
		if (FCode.equalsIgnoreCase("optionId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(optionId));
		if (FCode.equalsIgnoreCase("optionOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(optionOrder));
		if (FCode.equalsIgnoreCase("optionContent"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(optionContent));
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
			strFieldValue = StrTool.GBKToUnicode(questionId);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(optionId);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(optionOrder);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(optionContent);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 10: // '\n'
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
		if (FCode.equalsIgnoreCase("questionId"))
			if (FValue != null && !FValue.equals(""))
				questionId = FValue.trim();
			else
				questionId = null;
		if (FCode.equalsIgnoreCase("optionId"))
			if (FValue != null && !FValue.equals(""))
				optionId = FValue.trim();
			else
				optionId = null;
		if (FCode.equalsIgnoreCase("optionOrder"))
			if (FValue != null && !FValue.equals(""))
				optionOrder = FValue.trim();
			else
				optionOrder = null;
		if (FCode.equalsIgnoreCase("optionContent"))
			if (FValue != null && !FValue.equals(""))
				optionContent = FValue.trim();
			else
				optionContent = null;
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
		LNPAgentIImpOptionSchema other = (LNPAgentIImpOptionSchema)otherObject;
		if (impartId == null && other.getImpartId() != null)
			return false;
		if (impartId != null && !impartId.equals(other.getImpartId()))
			return false;
		if (questionId == null && other.getQuestionId() != null)
			return false;
		if (questionId != null && !questionId.equals(other.getQuestionId()))
			return false;
		if (optionId == null && other.getOptionId() != null)
			return false;
		if (optionId != null && !optionId.equals(other.getOptionId()))
			return false;
		if (optionOrder == null && other.getOptionOrder() != null)
			return false;
		if (optionOrder != null && !optionOrder.equals(other.getOptionOrder()))
			return false;
		if (optionContent == null && other.getOptionContent() != null)
			return false;
		if (optionContent != null && !optionContent.equals(other.getOptionContent()))
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
		return 11;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("impartId"))
			return 0;
		if (strFieldName.equals("questionId"))
			return 1;
		if (strFieldName.equals("optionId"))
			return 2;
		if (strFieldName.equals("optionOrder"))
			return 3;
		if (strFieldName.equals("optionContent"))
			return 4;
		if (strFieldName.equals("operator"))
			return 5;
		if (strFieldName.equals("manageCom"))
			return 6;
		if (strFieldName.equals("makeDate"))
			return 7;
		if (strFieldName.equals("makeTime"))
			return 8;
		if (strFieldName.equals("modifyDate"))
			return 9;
		return !strFieldName.equals("modifyTime") ? -1 : 10;
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
			strFieldName = "questionId";
			break;

		case 2: // '\002'
			strFieldName = "optionId";
			break;

		case 3: // '\003'
			strFieldName = "optionOrder";
			break;

		case 4: // '\004'
			strFieldName = "optionContent";
			break;

		case 5: // '\005'
			strFieldName = "operator";
			break;

		case 6: // '\006'
			strFieldName = "manageCom";
			break;

		case 7: // '\007'
			strFieldName = "makeDate";
			break;

		case 8: // '\b'
			strFieldName = "makeTime";
			break;

		case 9: // '\t'
			strFieldName = "modifyDate";
			break;

		case 10: // '\n'
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
		if (strFieldName.equals("questionId"))
			return 0;
		if (strFieldName.equals("optionId"))
			return 0;
		if (strFieldName.equals("optionOrder"))
			return 0;
		if (strFieldName.equals("optionContent"))
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
