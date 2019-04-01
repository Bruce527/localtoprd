// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLibraryRateSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MLibraryRateDB;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MLibraryRateSchema
	implements Schema, Cloneable
{

	private String fileID;
	private double downloadRate;
	public static final int FIELDNUM = 2;
	private static String PK[];
	public CErrors mErrors;

	public MLibraryRateSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "FileID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MLibraryRateSchema cloned = (MLibraryRateSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getFileID()
	{
		return fileID;
	}

	public void setFileID(String aFileID)
	{
		fileID = aFileID;
	}

	public double getDownloadRate()
	{
		return downloadRate;
	}

	public void setDownloadRate(double aDownloadRate)
	{
		downloadRate = aDownloadRate;
	}

	public void setDownloadRate(String aDownloadRate)
	{
		if (aDownloadRate != null && !aDownloadRate.equals(""))
		{
			Double tDouble = new Double(aDownloadRate);
			double d = tDouble.doubleValue();
			downloadRate = d;
		}
	}

	public void setSchema(MLibraryRateSchema aMLibraryRateSchema)
	{
		fileID = aMLibraryRateSchema.getFileID();
		downloadRate = aMLibraryRateSchema.getDownloadRate();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("FileID") == null)
				fileID = null;
			else
				fileID = rs.getString("FileID").trim();
			downloadRate = rs.getDouble("DownloadRate");
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MLibraryRate表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MLibraryRateSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MLibraryRateSchema getSchema()
	{
		MLibraryRateSchema aMLibraryRateSchema = new MLibraryRateSchema();
		aMLibraryRateSchema.setSchema(this);
		return aMLibraryRateSchema;
	}

	public MLibraryRateDB getDB()
	{
		MLibraryRateDB aDBOper = new MLibraryRateDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(fileID));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(downloadRate));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			fileID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			downloadRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 2, "|")))).doubleValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MLibraryRateSchema";
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
		if (FCode.equalsIgnoreCase("fileID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fileID));
		if (FCode.equalsIgnoreCase("downloadRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(downloadRate));
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
			strFieldValue = StrTool.GBKToUnicode(fileID);
			break;

		case 1: // '\001'
			strFieldValue = String.valueOf(downloadRate);
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
		if (FCode.equalsIgnoreCase("fileID"))
			if (FValue != null && !FValue.equals(""))
				fileID = FValue.trim();
			else
				fileID = null;
		if (FCode.equalsIgnoreCase("downloadRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			downloadRate = d;
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
		MLibraryRateSchema other = (MLibraryRateSchema)otherObject;
		if (fileID == null && other.getFileID() != null)
			return false;
		if (fileID != null && !fileID.equals(other.getFileID()))
			return false;
		return Double.doubleToLongBits(downloadRate) == Double.doubleToLongBits(other.getDownloadRate());
	}

	public int getFieldCount()
	{
		return 2;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("fileID"))
			return 0;
		return !strFieldName.equals("downloadRate") ? -1 : 1;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "fileID";
			break;

		case 1: // '\001'
			strFieldName = "downloadRate";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("fileID"))
			return 0;
		return !strFieldName.equals("downloadRate") ? -1 : 4;
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
