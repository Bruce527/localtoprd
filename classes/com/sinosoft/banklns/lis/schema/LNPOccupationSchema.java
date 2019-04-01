// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPOccupationSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPOccupationDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPOccupationSchema
	implements Schema, Cloneable
{

	private String occupationCode;
	private String occupationName;
	private String workType;
	private String workName;
	private String lifeRate;
	private String hiRate;
	private String paRate;
	private String wpRate;
	private String backRate1;
	private String backRate2;
	private String relaCode;
	public static final int FIELDNUM = 11;
	private static String PK[];
	public CErrors mErrors;

	public LNPOccupationSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "OccupationCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPOccupationSchema cloned = (LNPOccupationSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getOccupationCode()
	{
		return occupationCode;
	}

	public void setOccupationCode(String aOccupationCode)
	{
		occupationCode = aOccupationCode;
	}

	public String getOccupationName()
	{
		return occupationName;
	}

	public void setOccupationName(String aOccupationName)
	{
		occupationName = aOccupationName;
	}

	public String getWorkType()
	{
		return workType;
	}

	public void setWorkType(String aWorkType)
	{
		workType = aWorkType;
	}

	public String getWorkName()
	{
		return workName;
	}

	public void setWorkName(String aWorkName)
	{
		workName = aWorkName;
	}

	public String getLifeRate()
	{
		return lifeRate;
	}

	public void setLifeRate(String aLifeRate)
	{
		lifeRate = aLifeRate;
	}

	public String getHiRate()
	{
		return hiRate;
	}

	public void setHiRate(String aHiRate)
	{
		hiRate = aHiRate;
	}

	public String getPaRate()
	{
		return paRate;
	}

	public void setPaRate(String aPaRate)
	{
		paRate = aPaRate;
	}

	public String getWpRate()
	{
		return wpRate;
	}

	public void setWpRate(String aWpRate)
	{
		wpRate = aWpRate;
	}

	public String getBackRate1()
	{
		return backRate1;
	}

	public void setBackRate1(String aBackRate1)
	{
		backRate1 = aBackRate1;
	}

	public String getBackRate2()
	{
		return backRate2;
	}

	public void setBackRate2(String aBackRate2)
	{
		backRate2 = aBackRate2;
	}

	public String getRelaCode()
	{
		return relaCode;
	}

	public void setRelaCode(String aRelaCode)
	{
		relaCode = aRelaCode;
	}

	public void setSchema(LNPOccupationSchema aLNPOccupationSchema)
	{
		occupationCode = aLNPOccupationSchema.getOccupationCode();
		occupationName = aLNPOccupationSchema.getOccupationName();
		workType = aLNPOccupationSchema.getWorkType();
		workName = aLNPOccupationSchema.getWorkName();
		lifeRate = aLNPOccupationSchema.getLifeRate();
		hiRate = aLNPOccupationSchema.getHiRate();
		paRate = aLNPOccupationSchema.getPaRate();
		wpRate = aLNPOccupationSchema.getWpRate();
		backRate1 = aLNPOccupationSchema.getBackRate1();
		backRate2 = aLNPOccupationSchema.getBackRate2();
		relaCode = aLNPOccupationSchema.getRelaCode();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("OccupationCode") == null)
				occupationCode = null;
			else
				occupationCode = rs.getString("OccupationCode").trim();
			if (rs.getString("OccupationName") == null)
				occupationName = null;
			else
				occupationName = rs.getString("OccupationName").trim();
			if (rs.getString("WorkType") == null)
				workType = null;
			else
				workType = rs.getString("WorkType").trim();
			if (rs.getString("WorkName") == null)
				workName = null;
			else
				workName = rs.getString("WorkName").trim();
			if (rs.getString("LifeRate") == null)
				lifeRate = null;
			else
				lifeRate = rs.getString("LifeRate").trim();
			if (rs.getString("HiRate") == null)
				hiRate = null;
			else
				hiRate = rs.getString("HiRate").trim();
			if (rs.getString("PaRate") == null)
				paRate = null;
			else
				paRate = rs.getString("PaRate").trim();
			if (rs.getString("WpRate") == null)
				wpRate = null;
			else
				wpRate = rs.getString("WpRate").trim();
			if (rs.getString("BackRate1") == null)
				backRate1 = null;
			else
				backRate1 = rs.getString("BackRate1").trim();
			if (rs.getString("BackRate2") == null)
				backRate2 = null;
			else
				backRate2 = rs.getString("BackRate2").trim();
			if (rs.getString("RelaCode") == null)
				relaCode = null;
			else
				relaCode = rs.getString("RelaCode").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPOccupation���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPOccupationSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPOccupationSchema getSchema()
	{
		LNPOccupationSchema aLNPOccupationSchema = new LNPOccupationSchema();
		aLNPOccupationSchema.setSchema(this);
		return aLNPOccupationSchema;
	}

	public LNPOccupationDB getDB()
	{
		LNPOccupationDB aDBOper = new LNPOccupationDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(occupationCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(occupationName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(workType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(workName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(lifeRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(hiRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(paRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(wpRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(backRate1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(backRate2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relaCode));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			occupationName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			workName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			lifeRate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			hiRate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			paRate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			wpRate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			backRate1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			backRate2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			relaCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPOccupationSchema";
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
		if (FCode.equalsIgnoreCase("occupationCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationCode));
		if (FCode.equalsIgnoreCase("occupationName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationName));
		if (FCode.equalsIgnoreCase("workType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(workType));
		if (FCode.equalsIgnoreCase("workName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(workName));
		if (FCode.equalsIgnoreCase("lifeRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lifeRate));
		if (FCode.equalsIgnoreCase("hiRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(hiRate));
		if (FCode.equalsIgnoreCase("paRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(paRate));
		if (FCode.equalsIgnoreCase("wpRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(wpRate));
		if (FCode.equalsIgnoreCase("backRate1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(backRate1));
		if (FCode.equalsIgnoreCase("backRate2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(backRate2));
		if (FCode.equalsIgnoreCase("relaCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relaCode));
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
			strFieldValue = StrTool.GBKToUnicode(occupationCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(occupationName);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(workType);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(workName);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(lifeRate);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(hiRate);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(paRate);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(wpRate);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(backRate1);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(backRate2);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(relaCode);
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
		if (FCode.equalsIgnoreCase("occupationCode"))
			if (FValue != null && !FValue.equals(""))
				occupationCode = FValue.trim();
			else
				occupationCode = null;
		if (FCode.equalsIgnoreCase("occupationName"))
			if (FValue != null && !FValue.equals(""))
				occupationName = FValue.trim();
			else
				occupationName = null;
		if (FCode.equalsIgnoreCase("workType"))
			if (FValue != null && !FValue.equals(""))
				workType = FValue.trim();
			else
				workType = null;
		if (FCode.equalsIgnoreCase("workName"))
			if (FValue != null && !FValue.equals(""))
				workName = FValue.trim();
			else
				workName = null;
		if (FCode.equalsIgnoreCase("lifeRate"))
			if (FValue != null && !FValue.equals(""))
				lifeRate = FValue.trim();
			else
				lifeRate = null;
		if (FCode.equalsIgnoreCase("hiRate"))
			if (FValue != null && !FValue.equals(""))
				hiRate = FValue.trim();
			else
				hiRate = null;
		if (FCode.equalsIgnoreCase("paRate"))
			if (FValue != null && !FValue.equals(""))
				paRate = FValue.trim();
			else
				paRate = null;
		if (FCode.equalsIgnoreCase("wpRate"))
			if (FValue != null && !FValue.equals(""))
				wpRate = FValue.trim();
			else
				wpRate = null;
		if (FCode.equalsIgnoreCase("backRate1"))
			if (FValue != null && !FValue.equals(""))
				backRate1 = FValue.trim();
			else
				backRate1 = null;
		if (FCode.equalsIgnoreCase("backRate2"))
			if (FValue != null && !FValue.equals(""))
				backRate2 = FValue.trim();
			else
				backRate2 = null;
		if (FCode.equalsIgnoreCase("relaCode"))
			if (FValue != null && !FValue.equals(""))
				relaCode = FValue.trim();
			else
				relaCode = null;
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
		LNPOccupationSchema other = (LNPOccupationSchema)otherObject;
		if (occupationCode == null && other.getOccupationCode() != null)
			return false;
		if (occupationCode != null && !occupationCode.equals(other.getOccupationCode()))
			return false;
		if (occupationName == null && other.getOccupationName() != null)
			return false;
		if (occupationName != null && !occupationName.equals(other.getOccupationName()))
			return false;
		if (workType == null && other.getWorkType() != null)
			return false;
		if (workType != null && !workType.equals(other.getWorkType()))
			return false;
		if (workName == null && other.getWorkName() != null)
			return false;
		if (workName != null && !workName.equals(other.getWorkName()))
			return false;
		if (lifeRate == null && other.getLifeRate() != null)
			return false;
		if (lifeRate != null && !lifeRate.equals(other.getLifeRate()))
			return false;
		if (hiRate == null && other.getHiRate() != null)
			return false;
		if (hiRate != null && !hiRate.equals(other.getHiRate()))
			return false;
		if (paRate == null && other.getPaRate() != null)
			return false;
		if (paRate != null && !paRate.equals(other.getPaRate()))
			return false;
		if (wpRate == null && other.getWpRate() != null)
			return false;
		if (wpRate != null && !wpRate.equals(other.getWpRate()))
			return false;
		if (backRate1 == null && other.getBackRate1() != null)
			return false;
		if (backRate1 != null && !backRate1.equals(other.getBackRate1()))
			return false;
		if (backRate2 == null && other.getBackRate2() != null)
			return false;
		if (backRate2 != null && !backRate2.equals(other.getBackRate2()))
			return false;
		if (relaCode == null && other.getRelaCode() != null)
			return false;
		return relaCode == null || relaCode.equals(other.getRelaCode());
	}

	public int getFieldCount()
	{
		return 11;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("occupationCode"))
			return 0;
		if (strFieldName.equals("occupationName"))
			return 1;
		if (strFieldName.equals("workType"))
			return 2;
		if (strFieldName.equals("workName"))
			return 3;
		if (strFieldName.equals("lifeRate"))
			return 4;
		if (strFieldName.equals("hiRate"))
			return 5;
		if (strFieldName.equals("paRate"))
			return 6;
		if (strFieldName.equals("wpRate"))
			return 7;
		if (strFieldName.equals("backRate1"))
			return 8;
		if (strFieldName.equals("backRate2"))
			return 9;
		return !strFieldName.equals("relaCode") ? -1 : 10;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "occupationCode";
			break;

		case 1: // '\001'
			strFieldName = "occupationName";
			break;

		case 2: // '\002'
			strFieldName = "workType";
			break;

		case 3: // '\003'
			strFieldName = "workName";
			break;

		case 4: // '\004'
			strFieldName = "lifeRate";
			break;

		case 5: // '\005'
			strFieldName = "hiRate";
			break;

		case 6: // '\006'
			strFieldName = "paRate";
			break;

		case 7: // '\007'
			strFieldName = "wpRate";
			break;

		case 8: // '\b'
			strFieldName = "backRate1";
			break;

		case 9: // '\t'
			strFieldName = "backRate2";
			break;

		case 10: // '\n'
			strFieldName = "relaCode";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("occupationCode"))
			return 0;
		if (strFieldName.equals("occupationName"))
			return 0;
		if (strFieldName.equals("workType"))
			return 0;
		if (strFieldName.equals("workName"))
			return 0;
		if (strFieldName.equals("lifeRate"))
			return 0;
		if (strFieldName.equals("hiRate"))
			return 0;
		if (strFieldName.equals("paRate"))
			return 0;
		if (strFieldName.equals("wpRate"))
			return 0;
		if (strFieldName.equals("backRate1"))
			return 0;
		if (strFieldName.equals("backRate2"))
			return 0;
		return !strFieldName.equals("relaCode") ? -1 : 0;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
