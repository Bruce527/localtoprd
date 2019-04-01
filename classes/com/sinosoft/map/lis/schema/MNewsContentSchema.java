// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MNewsContentSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MNewsContentDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MNewsContentSchema
	implements Schema, Cloneable
{

	private String contentID;
	private String newsID;
	private String content;
	private int contOrder;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 9;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MNewsContentSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ContentID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MNewsContentSchema cloned = (MNewsContentSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getContentID()
	{
		return contentID;
	}

	public void setContentID(String aContentID)
	{
		contentID = aContentID;
	}

	public String getNewsID()
	{
		return newsID;
	}

	public void setNewsID(String aNewsID)
	{
		newsID = aNewsID;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String aContent)
	{
		content = aContent;
	}

	public int getContOrder()
	{
		return contOrder;
	}

	public void setContOrder(int aContOrder)
	{
		contOrder = aContOrder;
	}

	public void setContOrder(String aContOrder)
	{
		if (aContOrder != null && !aContOrder.equals(""))
		{
			Integer tInteger = new Integer(aContOrder);
			int i = tInteger.intValue();
			contOrder = i;
		}
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

	public void setSchema(MNewsContentSchema aMNewsContentSchema)
	{
		contentID = aMNewsContentSchema.getContentID();
		newsID = aMNewsContentSchema.getNewsID();
		content = aMNewsContentSchema.getContent();
		contOrder = aMNewsContentSchema.getContOrder();
		operator = aMNewsContentSchema.getOperator();
		makeDate = fDate.getDate(aMNewsContentSchema.getMakeDate());
		makeTime = aMNewsContentSchema.getMakeTime();
		modifyDate = fDate.getDate(aMNewsContentSchema.getModifyDate());
		modifyTime = aMNewsContentSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ContentID") == null)
				contentID = null;
			else
				contentID = rs.getString("ContentID").trim();
			if (rs.getString("NewsID") == null)
				newsID = null;
			else
				newsID = rs.getString("NewsID").trim();
			if (rs.getString("Content") == null)
				content = null;
			else
				content = rs.getString("Content").trim();
			contOrder = rs.getInt("ContOrder");
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
			System.out.println("数据库中的MNewsContent表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MNewsContentSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MNewsContentSchema getSchema()
	{
		MNewsContentSchema aMNewsContentSchema = new MNewsContentSchema();
		aMNewsContentSchema.setSchema(this);
		return aMNewsContentSchema;
	}

	public MNewsContentDB getDB()
	{
		MNewsContentDB aDBOper = new MNewsContentDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(contentID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(newsID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(content));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(contOrder));
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
			contentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			newsID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			content = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			contOrder = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|")))).intValue();
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MNewsContentSchema";
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
		if (FCode.equalsIgnoreCase("contentID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contentID));
		if (FCode.equalsIgnoreCase("newsID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(newsID));
		if (FCode.equalsIgnoreCase("content"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(content));
		if (FCode.equalsIgnoreCase("contOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contOrder));
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
			strFieldValue = StrTool.GBKToUnicode(contentID);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(newsID);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(content);
			break;

		case 3: // '\003'
			strFieldValue = String.valueOf(contOrder);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 8: // '\b'
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
		if (FCode.equalsIgnoreCase("contentID"))
			if (FValue != null && !FValue.equals(""))
				contentID = FValue.trim();
			else
				contentID = null;
		if (FCode.equalsIgnoreCase("newsID"))
			if (FValue != null && !FValue.equals(""))
				newsID = FValue.trim();
			else
				newsID = null;
		if (FCode.equalsIgnoreCase("content"))
			if (FValue != null && !FValue.equals(""))
				content = FValue.trim();
			else
				content = null;
		if (FCode.equalsIgnoreCase("contOrder") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			contOrder = i;
		}
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
		MNewsContentSchema other = (MNewsContentSchema)otherObject;
		if (contentID == null && other.getContentID() != null)
			return false;
		if (contentID != null && !contentID.equals(other.getContentID()))
			return false;
		if (newsID == null && other.getNewsID() != null)
			return false;
		if (newsID != null && !newsID.equals(other.getNewsID()))
			return false;
		if (content == null && other.getContent() != null)
			return false;
		if (content != null && !content.equals(other.getContent()))
			return false;
		if (contOrder != other.getContOrder())
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
		return 9;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("contentID"))
			return 0;
		if (strFieldName.equals("newsID"))
			return 1;
		if (strFieldName.equals("content"))
			return 2;
		if (strFieldName.equals("contOrder"))
			return 3;
		if (strFieldName.equals("operator"))
			return 4;
		if (strFieldName.equals("makeDate"))
			return 5;
		if (strFieldName.equals("makeTime"))
			return 6;
		if (strFieldName.equals("modifyDate"))
			return 7;
		return !strFieldName.equals("modifyTime") ? -1 : 8;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "contentID";
			break;

		case 1: // '\001'
			strFieldName = "newsID";
			break;

		case 2: // '\002'
			strFieldName = "content";
			break;

		case 3: // '\003'
			strFieldName = "contOrder";
			break;

		case 4: // '\004'
			strFieldName = "operator";
			break;

		case 5: // '\005'
			strFieldName = "makeDate";
			break;

		case 6: // '\006'
			strFieldName = "makeTime";
			break;

		case 7: // '\007'
			strFieldName = "modifyDate";
			break;

		case 8: // '\b'
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
		if (strFieldName.equals("contentID"))
			return 0;
		if (strFieldName.equals("newsID"))
			return 0;
		if (strFieldName.equals("content"))
			return 0;
		if (strFieldName.equals("contOrder"))
			return 3;
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
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
