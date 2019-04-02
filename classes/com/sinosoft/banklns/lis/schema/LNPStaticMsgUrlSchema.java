// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPStaticMsgUrlSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPStaticMsgUrlDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPStaticMsgUrlSchema
	implements Schema, Cloneable
{

	private int staMsgID;
	private String assuranceCode;
	private String msgUrl;
	private String flag;
	private String remarks;
	private String operator;
	private Date makeDate;
	private Date makeTime;
	private Date modifyDate;
	private Date modifyTime;
	public static final int FIELDNUM = 10;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPStaticMsgUrlSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "StaMsgID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPStaticMsgUrlSchema cloned = (LNPStaticMsgUrlSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public int getStaMsgID()
	{
		return staMsgID;
	}

	public void setStaMsgID(int aStaMsgID)
	{
		staMsgID = aStaMsgID;
	}

	public void setStaMsgID(String aStaMsgID)
	{
		if (aStaMsgID != null && !aStaMsgID.equals(""))
		{
			Integer tInteger = new Integer(aStaMsgID);
			int i = tInteger.intValue();
			staMsgID = i;
		}
	}

	public String getAssuranceCode()
	{
		return assuranceCode;
	}

	public void setAssuranceCode(String aAssuranceCode)
	{
		assuranceCode = aAssuranceCode;
	}

	public String getMsgUrl()
	{
		return msgUrl;
	}

	public void setMsgUrl(String aMsgUrl)
	{
		msgUrl = aMsgUrl;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String aFlag)
	{
		flag = aFlag;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String aRemarks)
	{
		remarks = aRemarks;
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
		if (makeTime != null)
			return fDate.getString(makeTime);
		else
			return null;
	}

	public void setMakeTime(Date aMakeTime)
	{
		makeTime = aMakeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		if (aMakeTime != null && !aMakeTime.equals(""))
			makeTime = fDate.getDate(aMakeTime);
		else
			makeTime = null;
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
		if (modifyTime != null)
			return fDate.getString(modifyTime);
		else
			return null;
	}

	public void setModifyTime(Date aModifyTime)
	{
		modifyTime = aModifyTime;
	}

	public void setModifyTime(String aModifyTime)
	{
		if (aModifyTime != null && !aModifyTime.equals(""))
			modifyTime = fDate.getDate(aModifyTime);
		else
			modifyTime = null;
	}

	public void setSchema(LNPStaticMsgUrlSchema aLNPStaticMsgUrlSchema)
	{
		staMsgID = aLNPStaticMsgUrlSchema.getStaMsgID();
		assuranceCode = aLNPStaticMsgUrlSchema.getAssuranceCode();
		msgUrl = aLNPStaticMsgUrlSchema.getMsgUrl();
		flag = aLNPStaticMsgUrlSchema.getFlag();
		remarks = aLNPStaticMsgUrlSchema.getRemarks();
		operator = aLNPStaticMsgUrlSchema.getOperator();
		makeDate = fDate.getDate(aLNPStaticMsgUrlSchema.getMakeDate());
		makeTime = fDate.getDate(aLNPStaticMsgUrlSchema.getMakeTime());
		modifyDate = fDate.getDate(aLNPStaticMsgUrlSchema.getModifyDate());
		modifyTime = fDate.getDate(aLNPStaticMsgUrlSchema.getModifyTime());
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			staMsgID = rs.getInt("StaMsgID");
			if (rs.getString("AssuranceCode") == null)
				assuranceCode = null;
			else
				assuranceCode = rs.getString("AssuranceCode").trim();
			if (rs.getString("MsgUrl") == null)
				msgUrl = null;
			else
				msgUrl = rs.getString("MsgUrl").trim();
			if (rs.getString("flag") == null)
				flag = null;
			else
				flag = rs.getString("flag").trim();
			if (rs.getString("Remarks") == null)
				remarks = null;
			else
				remarks = rs.getString("Remarks").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			makeDate = rs.getDate("MakeDate");
			makeTime = rs.getDate("MakeTime");
			modifyDate = rs.getDate("ModifyDate");
			modifyTime = rs.getDate("ModifyTime");
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPStaticMsgUrl????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPStaticMsgUrlSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPStaticMsgUrlSchema getSchema()
	{
		LNPStaticMsgUrlSchema aLNPStaticMsgUrlSchema = new LNPStaticMsgUrlSchema();
		aLNPStaticMsgUrlSchema.setSchema(this);
		return aLNPStaticMsgUrlSchema;
	}

	public LNPStaticMsgUrlDB getDB()
	{
		LNPStaticMsgUrlDB aDBOper = new LNPStaticMsgUrlDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(ChgData.chgData(staMsgID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(assuranceCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(msgUrl));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(flag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remarks));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeTime)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyTime)));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			staMsgID = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 1, "|")))).intValue();
			assuranceCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			msgUrl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			flag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
			makeTime = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			modifyTime = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPStaticMsgUrlSchema";
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
		if (FCode.equalsIgnoreCase("staMsgID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(staMsgID));
		if (FCode.equalsIgnoreCase("assuranceCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(assuranceCode));
		if (FCode.equalsIgnoreCase("msgUrl"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(msgUrl));
		if (FCode.equalsIgnoreCase("flag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(flag));
		if (FCode.equalsIgnoreCase("remarks"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remarks));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeTime()));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyTime()));
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
			strFieldValue = String.valueOf(staMsgID);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(assuranceCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(msgUrl);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(flag);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(remarks);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeTime()));
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyTime()));
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
		if (FCode.equalsIgnoreCase("staMsgID") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			staMsgID = i;
		}
		if (FCode.equalsIgnoreCase("assuranceCode"))
			if (FValue != null && !FValue.equals(""))
				assuranceCode = FValue.trim();
			else
				assuranceCode = null;
		if (FCode.equalsIgnoreCase("msgUrl"))
			if (FValue != null && !FValue.equals(""))
				msgUrl = FValue.trim();
			else
				msgUrl = null;
		if (FCode.equalsIgnoreCase("flag"))
			if (FValue != null && !FValue.equals(""))
				flag = FValue.trim();
			else
				flag = null;
		if (FCode.equalsIgnoreCase("remarks"))
			if (FValue != null && !FValue.equals(""))
				remarks = FValue.trim();
			else
				remarks = null;
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
				makeTime = fDate.getDate(FValue);
			else
				makeTime = null;
		if (FCode.equalsIgnoreCase("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equalsIgnoreCase("modifyTime"))
			if (FValue != null && !FValue.equals(""))
				modifyTime = fDate.getDate(FValue);
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
		LNPStaticMsgUrlSchema other = (LNPStaticMsgUrlSchema)otherObject;
		if (staMsgID != other.getStaMsgID())
			return false;
		if (assuranceCode == null && other.getAssuranceCode() != null)
			return false;
		if (assuranceCode != null && !assuranceCode.equals(other.getAssuranceCode()))
			return false;
		if (msgUrl == null && other.getMsgUrl() != null)
			return false;
		if (msgUrl != null && !msgUrl.equals(other.getMsgUrl()))
			return false;
		if (flag == null && other.getFlag() != null)
			return false;
		if (flag != null && !flag.equals(other.getFlag()))
			return false;
		if (remarks == null && other.getRemarks() != null)
			return false;
		if (remarks != null && !remarks.equals(other.getRemarks()))
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
		if (makeTime != null && !fDate.getString(makeTime).equals(other.getMakeTime()))
			return false;
		if (modifyDate == null && other.getModifyDate() != null)
			return false;
		if (modifyDate != null && !fDate.getString(modifyDate).equals(other.getModifyDate()))
			return false;
		if (modifyTime == null && other.getModifyTime() != null)
			return false;
		return modifyTime == null || fDate.getString(modifyTime).equals(other.getModifyTime());
	}

	public int getFieldCount()
	{
		return 10;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("staMsgID"))
			return 0;
		if (strFieldName.equals("assuranceCode"))
			return 1;
		if (strFieldName.equals("msgUrl"))
			return 2;
		if (strFieldName.equals("flag"))
			return 3;
		if (strFieldName.equals("remarks"))
			return 4;
		if (strFieldName.equals("operator"))
			return 5;
		if (strFieldName.equals("makeDate"))
			return 6;
		if (strFieldName.equals("makeTime"))
			return 7;
		if (strFieldName.equals("modifyDate"))
			return 8;
		return !strFieldName.equals("modifyTime") ? -1 : 9;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "staMsgID";
			break;

		case 1: // '\001'
			strFieldName = "assuranceCode";
			break;

		case 2: // '\002'
			strFieldName = "msgUrl";
			break;

		case 3: // '\003'
			strFieldName = "flag";
			break;

		case 4: // '\004'
			strFieldName = "remarks";
			break;

		case 5: // '\005'
			strFieldName = "operator";
			break;

		case 6: // '\006'
			strFieldName = "makeDate";
			break;

		case 7: // '\007'
			strFieldName = "makeTime";
			break;

		case 8: // '\b'
			strFieldName = "modifyDate";
			break;

		case 9: // '\t'
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
		if (strFieldName.equals("staMsgID"))
			return 3;
		if (strFieldName.equals("assuranceCode"))
			return 0;
		if (strFieldName.equals("msgUrl"))
			return 0;
		if (strFieldName.equals("flag"))
			return 0;
		if (strFieldName.equals("remarks"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 1;
		if (strFieldName.equals("modifyDate"))
			return 1;
		return !strFieldName.equals("modifyTime") ? -1 : 1;
	}

	public int getFieldType(int nFieldIndex)
	{
		int nFieldType = -1;
		switch (nFieldIndex)
		{
		case 0: // '\0'
			nFieldType = 3;
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
			nFieldType = 1;
			break;

		case 7: // '\007'
			nFieldType = 1;
			break;

		case 8: // '\b'
			nFieldType = 1;
			break;

		case 9: // '\t'
			nFieldType = 1;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
