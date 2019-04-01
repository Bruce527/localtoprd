// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CaseFileDownlLogSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.CaseFileDownlLogDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CaseFileDownlLogSchema
	implements Schema, Cloneable
{

	private String id;
	private Date fileDate;
	private Date fDownDate;
	private String fDownTime;
	private String flag;
	private Date modifyDate;
	private String modityTime;
	private String lastOperator;
	private Date bY1;
	private Date bY2;
	private String bY3;
	private String bY4;
	public static final int FIELDNUM = 12;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public CaseFileDownlLogSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "Id";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		CaseFileDownlLogSchema cloned = (CaseFileDownlLogSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String aId)
	{
		id = aId;
	}

	public String getFileDate()
	{
		if (fileDate != null)
			return fDate.getString(fileDate);
		else
			return null;
	}

	public void setFileDate(Date aFileDate)
	{
		fileDate = aFileDate;
	}

	public void setFileDate(String aFileDate)
	{
		if (aFileDate != null && !aFileDate.equals(""))
			fileDate = fDate.getDate(aFileDate);
		else
			fileDate = null;
	}

	public String getFDownDate()
	{
		if (fDownDate != null)
			return fDate.getString(fDownDate);
		else
			return null;
	}

	public void setFDownDate(Date aFDownDate)
	{
		fDownDate = aFDownDate;
	}

	public void setFDownDate(String aFDownDate)
	{
		if (aFDownDate != null && !aFDownDate.equals(""))
			fDownDate = fDate.getDate(aFDownDate);
		else
			fDownDate = null;
	}

	public String getFDownTime()
	{
		return fDownTime;
	}

	public void setFDownTime(String aFDownTime)
	{
		fDownTime = aFDownTime;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String aFlag)
	{
		flag = aFlag;
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

	public String getModityTime()
	{
		return modityTime;
	}

	public void setModityTime(String aModityTime)
	{
		modityTime = aModityTime;
	}

	public String getLastOperator()
	{
		return lastOperator;
	}

	public void setLastOperator(String aLastOperator)
	{
		lastOperator = aLastOperator;
	}

	public String getBY1()
	{
		if (bY1 != null)
			return fDate.getString(bY1);
		else
			return null;
	}

	public void setBY1(Date aBY1)
	{
		bY1 = aBY1;
	}

	public void setBY1(String aBY1)
	{
		if (aBY1 != null && !aBY1.equals(""))
			bY1 = fDate.getDate(aBY1);
		else
			bY1 = null;
	}

	public String getBY2()
	{
		if (bY2 != null)
			return fDate.getString(bY2);
		else
			return null;
	}

	public void setBY2(Date aBY2)
	{
		bY2 = aBY2;
	}

	public void setBY2(String aBY2)
	{
		if (aBY2 != null && !aBY2.equals(""))
			bY2 = fDate.getDate(aBY2);
		else
			bY2 = null;
	}

	public String getBY3()
	{
		return bY3;
	}

	public void setBY3(String aBY3)
	{
		bY3 = aBY3;
	}

	public String getBY4()
	{
		return bY4;
	}

	public void setBY4(String aBY4)
	{
		bY4 = aBY4;
	}

	public void setSchema(CaseFileDownlLogSchema aCaseFileDownlLogSchema)
	{
		id = aCaseFileDownlLogSchema.getId();
		fileDate = fDate.getDate(aCaseFileDownlLogSchema.getFileDate());
		fDownDate = fDate.getDate(aCaseFileDownlLogSchema.getFDownDate());
		fDownTime = aCaseFileDownlLogSchema.getFDownTime();
		flag = aCaseFileDownlLogSchema.getFlag();
		modifyDate = fDate.getDate(aCaseFileDownlLogSchema.getModifyDate());
		modityTime = aCaseFileDownlLogSchema.getModityTime();
		lastOperator = aCaseFileDownlLogSchema.getLastOperator();
		bY1 = fDate.getDate(aCaseFileDownlLogSchema.getBY1());
		bY2 = fDate.getDate(aCaseFileDownlLogSchema.getBY2());
		bY3 = aCaseFileDownlLogSchema.getBY3();
		bY4 = aCaseFileDownlLogSchema.getBY4();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("Id") == null)
				id = null;
			else
				id = rs.getString("Id").trim();
			fileDate = rs.getDate("FileDate");
			fDownDate = rs.getDate("FDownDate");
			if (rs.getString("FDownTime") == null)
				fDownTime = null;
			else
				fDownTime = rs.getString("FDownTime").trim();
			if (rs.getString("Flag") == null)
				flag = null;
			else
				flag = rs.getString("Flag").trim();
			modifyDate = rs.getDate("ModifyDate");
			if (rs.getString("ModityTime") == null)
				modityTime = null;
			else
				modityTime = rs.getString("ModityTime").trim();
			if (rs.getString("LastOperator") == null)
				lastOperator = null;
			else
				lastOperator = rs.getString("LastOperator").trim();
			bY1 = rs.getDate("BY1");
			bY2 = rs.getDate("BY2");
			if (rs.getString("BY3") == null)
				bY3 = null;
			else
				bY3 = rs.getString("BY3").trim();
			if (rs.getString("BY4") == null)
				bY4 = null;
			else
				bY4 = rs.getString("BY4").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的CaseFileDownlLog表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "CaseFileDownlLogSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public CaseFileDownlLogSchema getSchema()
	{
		CaseFileDownlLogSchema aCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
		aCaseFileDownlLogSchema.setSchema(this);
		return aCaseFileDownlLogSchema;
	}

	public CaseFileDownlLogDB getDB()
	{
		CaseFileDownlLogDB aDBOper = new CaseFileDownlLogDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(id));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(fileDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(fDownDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDownTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(flag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modityTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(lastOperator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(bY1)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(bY2)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bY3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bY4));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			id = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			fileDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|"));
			fDownDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|"));
			fDownTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			flag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
			modityTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			lastOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			bY1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			bY2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			bY3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			bY4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "CaseFileDownlLogSchema";
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
		if (FCode.equalsIgnoreCase("id"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(id));
		if (FCode.equalsIgnoreCase("fileDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getFileDate()));
		if (FCode.equalsIgnoreCase("fDownDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getFDownDate()));
		if (FCode.equalsIgnoreCase("fDownTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fDownTime));
		if (FCode.equalsIgnoreCase("flag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(flag));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modityTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modityTime));
		if (FCode.equalsIgnoreCase("lastOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lastOperator));
		if (FCode.equalsIgnoreCase("bY1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getBY1()));
		if (FCode.equalsIgnoreCase("bY2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getBY2()));
		if (FCode.equalsIgnoreCase("bY3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bY3));
		if (FCode.equalsIgnoreCase("bY4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bY4));
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
			strFieldValue = StrTool.GBKToUnicode(id);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getFileDate()));
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getFDownDate()));
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(fDownTime);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(flag);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(modityTime);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(lastOperator);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBY1()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBY2()));
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(bY3);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(bY4);
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
		if (FCode.equalsIgnoreCase("id"))
			if (FValue != null && !FValue.equals(""))
				id = FValue.trim();
			else
				id = null;
		if (FCode.equalsIgnoreCase("fileDate"))
			if (FValue != null && !FValue.equals(""))
				fileDate = fDate.getDate(FValue);
			else
				fileDate = null;
		if (FCode.equalsIgnoreCase("fDownDate"))
			if (FValue != null && !FValue.equals(""))
				fDownDate = fDate.getDate(FValue);
			else
				fDownDate = null;
		if (FCode.equalsIgnoreCase("fDownTime"))
			if (FValue != null && !FValue.equals(""))
				fDownTime = FValue.trim();
			else
				fDownTime = null;
		if (FCode.equalsIgnoreCase("flag"))
			if (FValue != null && !FValue.equals(""))
				flag = FValue.trim();
			else
				flag = null;
		if (FCode.equalsIgnoreCase("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equalsIgnoreCase("modityTime"))
			if (FValue != null && !FValue.equals(""))
				modityTime = FValue.trim();
			else
				modityTime = null;
		if (FCode.equalsIgnoreCase("lastOperator"))
			if (FValue != null && !FValue.equals(""))
				lastOperator = FValue.trim();
			else
				lastOperator = null;
		if (FCode.equalsIgnoreCase("bY1"))
			if (FValue != null && !FValue.equals(""))
				bY1 = fDate.getDate(FValue);
			else
				bY1 = null;
		if (FCode.equalsIgnoreCase("bY2"))
			if (FValue != null && !FValue.equals(""))
				bY2 = fDate.getDate(FValue);
			else
				bY2 = null;
		if (FCode.equalsIgnoreCase("bY3"))
			if (FValue != null && !FValue.equals(""))
				bY3 = FValue.trim();
			else
				bY3 = null;
		if (FCode.equalsIgnoreCase("bY4"))
			if (FValue != null && !FValue.equals(""))
				bY4 = FValue.trim();
			else
				bY4 = null;
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
		CaseFileDownlLogSchema other = (CaseFileDownlLogSchema)otherObject;
		if (id == null && other.getId() != null)
			return false;
		if (id != null && !id.equals(other.getId()))
			return false;
		if (fileDate == null && other.getFileDate() != null)
			return false;
		if (fileDate != null && !fDate.getString(fileDate).equals(other.getFileDate()))
			return false;
		if (fDownDate == null && other.getFDownDate() != null)
			return false;
		if (fDownDate != null && !fDate.getString(fDownDate).equals(other.getFDownDate()))
			return false;
		if (fDownTime == null && other.getFDownTime() != null)
			return false;
		if (fDownTime != null && !fDownTime.equals(other.getFDownTime()))
			return false;
		if (flag == null && other.getFlag() != null)
			return false;
		if (flag != null && !flag.equals(other.getFlag()))
			return false;
		if (modifyDate == null && other.getModifyDate() != null)
			return false;
		if (modifyDate != null && !fDate.getString(modifyDate).equals(other.getModifyDate()))
			return false;
		if (modityTime == null && other.getModityTime() != null)
			return false;
		if (modityTime != null && !modityTime.equals(other.getModityTime()))
			return false;
		if (lastOperator == null && other.getLastOperator() != null)
			return false;
		if (lastOperator != null && !lastOperator.equals(other.getLastOperator()))
			return false;
		if (bY1 == null && other.getBY1() != null)
			return false;
		if (bY1 != null && !fDate.getString(bY1).equals(other.getBY1()))
			return false;
		if (bY2 == null && other.getBY2() != null)
			return false;
		if (bY2 != null && !fDate.getString(bY2).equals(other.getBY2()))
			return false;
		if (bY3 == null && other.getBY3() != null)
			return false;
		if (bY3 != null && !bY3.equals(other.getBY3()))
			return false;
		if (bY4 == null && other.getBY4() != null)
			return false;
		return bY4 == null || bY4.equals(other.getBY4());
	}

	public int getFieldCount()
	{
		return 12;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("id"))
			return 0;
		if (strFieldName.equals("fileDate"))
			return 1;
		if (strFieldName.equals("fDownDate"))
			return 2;
		if (strFieldName.equals("fDownTime"))
			return 3;
		if (strFieldName.equals("flag"))
			return 4;
		if (strFieldName.equals("modifyDate"))
			return 5;
		if (strFieldName.equals("modityTime"))
			return 6;
		if (strFieldName.equals("lastOperator"))
			return 7;
		if (strFieldName.equals("bY1"))
			return 8;
		if (strFieldName.equals("bY2"))
			return 9;
		if (strFieldName.equals("bY3"))
			return 10;
		return !strFieldName.equals("bY4") ? -1 : 11;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "id";
			break;

		case 1: // '\001'
			strFieldName = "fileDate";
			break;

		case 2: // '\002'
			strFieldName = "fDownDate";
			break;

		case 3: // '\003'
			strFieldName = "fDownTime";
			break;

		case 4: // '\004'
			strFieldName = "flag";
			break;

		case 5: // '\005'
			strFieldName = "modifyDate";
			break;

		case 6: // '\006'
			strFieldName = "modityTime";
			break;

		case 7: // '\007'
			strFieldName = "lastOperator";
			break;

		case 8: // '\b'
			strFieldName = "bY1";
			break;

		case 9: // '\t'
			strFieldName = "bY2";
			break;

		case 10: // '\n'
			strFieldName = "bY3";
			break;

		case 11: // '\013'
			strFieldName = "bY4";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("id"))
			return 0;
		if (strFieldName.equals("fileDate"))
			return 1;
		if (strFieldName.equals("fDownDate"))
			return 1;
		if (strFieldName.equals("fDownTime"))
			return 0;
		if (strFieldName.equals("flag"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		if (strFieldName.equals("modityTime"))
			return 0;
		if (strFieldName.equals("lastOperator"))
			return 0;
		if (strFieldName.equals("bY1"))
			return 1;
		if (strFieldName.equals("bY2"))
			return 1;
		if (strFieldName.equals("bY3"))
			return 0;
		return !strFieldName.equals("bY4") ? -1 : 0;
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
			nFieldType = 1;
			break;

		case 2: // '\002'
			nFieldType = 1;
			break;

		case 3: // '\003'
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 1;
			break;

		case 9: // '\t'
			nFieldType = 1;
			break;

		case 10: // '\n'
			nFieldType = 0;
			break;

		case 11: // '\013'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
