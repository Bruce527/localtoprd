// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MNewsClickCountSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MNewsClickCountDB;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MNewsClickCountSchema
	implements Schema, Cloneable
{

	private String newsID;
	private double clickRate;
	public static final int FIELDNUM = 2;
	private static String PK[];
	public CErrors mErrors;

	public MNewsClickCountSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "NewsID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MNewsClickCountSchema cloned = (MNewsClickCountSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getNewsID()
	{
		return newsID;
	}

	public void setNewsID(String aNewsID)
	{
		newsID = aNewsID;
	}

	public double getClickRate()
	{
		return clickRate;
	}

	public void setClickRate(double aClickRate)
	{
		clickRate = aClickRate;
	}

	public void setClickRate(String aClickRate)
	{
		if (aClickRate != null && !aClickRate.equals(""))
		{
			Double tDouble = new Double(aClickRate);
			double d = tDouble.doubleValue();
			clickRate = d;
		}
	}

	public void setSchema(MNewsClickCountSchema aMNewsClickCountSchema)
	{
		newsID = aMNewsClickCountSchema.getNewsID();
		clickRate = aMNewsClickCountSchema.getClickRate();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("NewsID") == null)
				newsID = null;
			else
				newsID = rs.getString("NewsID").trim();
			clickRate = rs.getDouble("ClickRate");
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MNewsClickCount表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MNewsClickCountSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MNewsClickCountSchema getSchema()
	{
		MNewsClickCountSchema aMNewsClickCountSchema = new MNewsClickCountSchema();
		aMNewsClickCountSchema.setSchema(this);
		return aMNewsClickCountSchema;
	}

	public MNewsClickCountDB getDB()
	{
		MNewsClickCountDB aDBOper = new MNewsClickCountDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(newsID));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(clickRate));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			newsID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			clickRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 2, "|")))).doubleValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MNewsClickCountSchema";
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
		if (FCode.equalsIgnoreCase("newsID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(newsID));
		if (FCode.equalsIgnoreCase("clickRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clickRate));
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
			strFieldValue = StrTool.GBKToUnicode(newsID);
			break;

		case 1: // '\001'
			strFieldValue = String.valueOf(clickRate);
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
		if (FCode.equalsIgnoreCase("newsID"))
			if (FValue != null && !FValue.equals(""))
				newsID = FValue.trim();
			else
				newsID = null;
		if (FCode.equalsIgnoreCase("clickRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			clickRate = d;
		}
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
		MNewsClickCountSchema other = (MNewsClickCountSchema)otherObject;
		if (newsID == null && other.getNewsID() != null)
			return false;
		if (newsID != null && !newsID.equals(other.getNewsID()))
			return false;
		return Double.doubleToLongBits(clickRate) == Double.doubleToLongBits(other.getClickRate());
	}

	public int getFieldCount()
	{
		return 2;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("newsID"))
			return 0;
		return !strFieldName.equals("clickRate") ? -1 : 1;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "newsID";
			break;

		case 1: // '\001'
			strFieldName = "clickRate";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("newsID"))
			return 0;
		return !strFieldName.equals("clickRate") ? -1 : 4;
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
			nFieldType = 4;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
