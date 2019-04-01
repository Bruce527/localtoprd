// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPOperationRecordBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPOperationRecordBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPOperationRecordBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
	private String ID;
	private String ContNo;
	private String OperatorCode;
	private String OperatorName;
	private String OperatorType;
	private String OperationDate;
	private String OperationTime;
	private String Operation;
	private int Int1;
	private int Int2;
	private String Varc1;
	private String Varc2;
	private String Varc3;
	private String Varc4;
	private Date Date1;
	private Date Date2;
	public static final int FIELDNUM = 18;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPOperationRecordBSchema()
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

	public String getID()
	{
		if (ID != null)
			ID.equals("");
		return ID;
	}

	public void setID(String aID)
	{
		ID = aID;
	}

	public String getContNo()
	{
		if (ContNo != null)
			ContNo.equals("");
		return ContNo;
	}

	public void setContNo(String aContNo)
	{
		ContNo = aContNo;
	}

	public String getOperatorCode()
	{
		if (OperatorCode != null)
			OperatorCode.equals("");
		return OperatorCode;
	}

	public void setOperatorCode(String aOperatorCode)
	{
		OperatorCode = aOperatorCode;
	}

	public String getOperatorName()
	{
		if (OperatorName != null)
			OperatorName.equals("");
		return OperatorName;
	}

	public void setOperatorName(String aOperatorName)
	{
		OperatorName = aOperatorName;
	}

	public String getOperatorType()
	{
		if (OperatorType != null)
			OperatorType.equals("");
		return OperatorType;
	}

	public void setOperatorType(String aOperatorType)
	{
		OperatorType = aOperatorType;
	}

	public String getOperationDate()
	{
		if (OperationDate != null)
			OperationDate.equals("");
		return OperationDate;
	}

	public void setOperationDate(String aOperationDate)
	{
		OperationDate = aOperationDate;
	}

	public String getOperationTime()
	{
		if (OperationTime != null)
			OperationTime.equals("");
		return OperationTime;
	}

	public void setOperationTime(String aOperationTime)
	{
		OperationTime = aOperationTime;
	}

	public String getOperation()
	{
		if (Operation != null)
			Operation.equals("");
		return Operation;
	}

	public void setOperation(String aOperation)
	{
		Operation = aOperation;
	}

	public int getInt1()
	{
		return Int1;
	}

	public void setInt1(int aInt1)
	{
		Int1 = aInt1;
	}

	public void setInt1(String aInt1)
	{
		if (aInt1 != null && !aInt1.equals(""))
		{
			Integer tInteger = new Integer(aInt1);
			int i = tInteger.intValue();
			Int1 = i;
		}
	}

	public int getInt2()
	{
		return Int2;
	}

	public void setInt2(int aInt2)
	{
		Int2 = aInt2;
	}

	public void setInt2(String aInt2)
	{
		if (aInt2 != null && !aInt2.equals(""))
		{
			Integer tInteger = new Integer(aInt2);
			int i = tInteger.intValue();
			Int2 = i;
		}
	}

	public String getVarc1()
	{
		if (Varc1 != null)
			Varc1.equals("");
		return Varc1;
	}

	public void setVarc1(String aVarc1)
	{
		Varc1 = aVarc1;
	}

	public String getVarc2()
	{
		if (Varc2 != null)
			Varc2.equals("");
		return Varc2;
	}

	public void setVarc2(String aVarc2)
	{
		Varc2 = aVarc2;
	}

	public String getVarc3()
	{
		if (Varc3 != null)
			Varc3.equals("");
		return Varc3;
	}

	public void setVarc3(String aVarc3)
	{
		Varc3 = aVarc3;
	}

	public String getVarc4()
	{
		if (Varc4 != null)
			Varc4.equals("");
		return Varc4;
	}

	public void setVarc4(String aVarc4)
	{
		Varc4 = aVarc4;
	}

	public String getDate1()
	{
		if (Date1 != null)
			return fDate.getString(Date1);
		else
			return null;
	}

	public void setDate1(Date aDate1)
	{
		Date1 = aDate1;
	}

	public void setDate1(String aDate1)
	{
		if (aDate1 != null && !aDate1.equals(""))
			Date1 = fDate.getDate(aDate1);
		else
			Date1 = null;
	}

	public String getDate2()
	{
		if (Date2 != null)
			return fDate.getString(Date2);
		else
			return null;
	}

	public void setDate2(Date aDate2)
	{
		Date2 = aDate2;
	}

	public void setDate2(String aDate2)
	{
		if (aDate2 != null && !aDate2.equals(""))
			Date2 = fDate.getDate(aDate2);
		else
			Date2 = null;
	}

	public void setSchema(LNPOperationRecordBSchema aLNPOperationRecordBSchema)
	{
		EdorNo = aLNPOperationRecordBSchema.getEdorNo();
		serialNo = aLNPOperationRecordBSchema.getserialNo();
		ID = aLNPOperationRecordBSchema.getID();
		ContNo = aLNPOperationRecordBSchema.getContNo();
		OperatorCode = aLNPOperationRecordBSchema.getOperatorCode();
		OperatorName = aLNPOperationRecordBSchema.getOperatorName();
		OperatorType = aLNPOperationRecordBSchema.getOperatorType();
		OperationDate = aLNPOperationRecordBSchema.getOperationDate();
		OperationTime = aLNPOperationRecordBSchema.getOperationTime();
		Operation = aLNPOperationRecordBSchema.getOperation();
		Int1 = aLNPOperationRecordBSchema.getInt1();
		Int2 = aLNPOperationRecordBSchema.getInt2();
		Varc1 = aLNPOperationRecordBSchema.getVarc1();
		Varc2 = aLNPOperationRecordBSchema.getVarc2();
		Varc3 = aLNPOperationRecordBSchema.getVarc3();
		Varc4 = aLNPOperationRecordBSchema.getVarc4();
		Date1 = fDate.getDate(aLNPOperationRecordBSchema.getDate1());
		Date2 = fDate.getDate(aLNPOperationRecordBSchema.getDate2());
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
			if (rs.getString("ID") == null)
				ID = null;
			else
				ID = rs.getString("ID").trim();
			if (rs.getString("ContNo") == null)
				ContNo = null;
			else
				ContNo = rs.getString("ContNo").trim();
			if (rs.getString("OperatorCode") == null)
				OperatorCode = null;
			else
				OperatorCode = rs.getString("OperatorCode").trim();
			if (rs.getString("OperatorName") == null)
				OperatorName = null;
			else
				OperatorName = rs.getString("OperatorName").trim();
			if (rs.getString("OperatorType") == null)
				OperatorType = null;
			else
				OperatorType = rs.getString("OperatorType").trim();
			if (rs.getString("OperationDate") == null)
				OperationDate = null;
			else
				OperationDate = rs.getString("OperationDate").trim();
			if (rs.getString("OperationTime") == null)
				OperationTime = null;
			else
				OperationTime = rs.getString("OperationTime").trim();
			if (rs.getString("Operation") == null)
				Operation = null;
			else
				Operation = rs.getString("Operation").trim();
			Int1 = rs.getInt("Int1");
			Int2 = rs.getInt("Int2");
			if (rs.getString("Varc1") == null)
				Varc1 = null;
			else
				Varc1 = rs.getString("Varc1").trim();
			if (rs.getString("Varc2") == null)
				Varc2 = null;
			else
				Varc2 = rs.getString("Varc2").trim();
			if (rs.getString("Varc3") == null)
				Varc3 = null;
			else
				Varc3 = rs.getString("Varc3").trim();
			if (rs.getString("Varc4") == null)
				Varc4 = null;
			else
				Varc4 = rs.getString("Varc4").trim();
			Date1 = rs.getDate("Date1");
			Date2 = rs.getDate("Date2");
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPOperationRecordBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPOperationRecordBSchema getSchema()
	{
		LNPOperationRecordBSchema aLNPOperationRecordBSchema = new LNPOperationRecordBSchema();
		aLNPOperationRecordBSchema.setSchema(this);
		return aLNPOperationRecordBSchema;
	}

	public LNPOperationRecordBDB getDB()
	{
		LNPOperationRecordBDB aDBOper = new LNPOperationRecordBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ID))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(OperatorCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(OperatorName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(OperatorType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(OperationDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(OperationTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Operation))).append("|").append(ChgData.chgData(Int1)).append("|").append(ChgData.chgData(Int2)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc4))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(Date1)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(Date2)))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			OperatorCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			OperatorName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			OperatorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			OperationDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			OperationTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			Operation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			Int1 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).intValue();
			Int2 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|")))).intValue();
			Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			Date1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			Date2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPOperationRecordBSchema";
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
		if (FCode.equals("ID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ID));
		if (FCode.equals("ContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ContNo));
		if (FCode.equals("OperatorCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(OperatorCode));
		if (FCode.equals("OperatorName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(OperatorName));
		if (FCode.equals("OperatorType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(OperatorType));
		if (FCode.equals("OperationDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(OperationDate));
		if (FCode.equals("OperationTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(OperationTime));
		if (FCode.equals("Operation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operation));
		if (FCode.equals("Int1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Int1));
		if (FCode.equals("Int2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Int2));
		if (FCode.equals("Varc1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc1));
		if (FCode.equals("Varc2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc2));
		if (FCode.equals("Varc3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc3));
		if (FCode.equals("Varc4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc4));
		if (FCode.equals("Date1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDate1()));
		if (FCode.equals("Date2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDate2()));
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
			strFieldValue = StrTool.GBKToUnicode(ID);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(ContNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(OperatorCode);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(OperatorName);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(OperatorType);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(OperationDate);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(OperationTime);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(Operation);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(Int1);
			break;

		case 11: // '\013'
			strFieldValue = String.valueOf(Int2);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(Varc1);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(Varc2);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(Varc3);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(Varc4);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate1()));
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate2()));
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
		if (FCode.equals("ID"))
			if (FValue != null && !FValue.equals(""))
				ID = FValue.trim();
			else
				ID = null;
		if (FCode.equals("ContNo"))
			if (FValue != null && !FValue.equals(""))
				ContNo = FValue.trim();
			else
				ContNo = null;
		if (FCode.equals("OperatorCode"))
			if (FValue != null && !FValue.equals(""))
				OperatorCode = FValue.trim();
			else
				OperatorCode = null;
		if (FCode.equals("OperatorName"))
			if (FValue != null && !FValue.equals(""))
				OperatorName = FValue.trim();
			else
				OperatorName = null;
		if (FCode.equals("OperatorType"))
			if (FValue != null && !FValue.equals(""))
				OperatorType = FValue.trim();
			else
				OperatorType = null;
		if (FCode.equals("OperationDate"))
			if (FValue != null && !FValue.equals(""))
				OperationDate = FValue.trim();
			else
				OperationDate = null;
		if (FCode.equals("OperationTime"))
			if (FValue != null && !FValue.equals(""))
				OperationTime = FValue.trim();
			else
				OperationTime = null;
		if (FCode.equals("Operation"))
			if (FValue != null && !FValue.equals(""))
				Operation = FValue.trim();
			else
				Operation = null;
		if (FCode.equals("Int1") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			Int1 = i;
		}
		if (FCode.equals("Int2") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			Int2 = i;
		}
		if (FCode.equals("Varc1"))
			if (FValue != null && !FValue.equals(""))
				Varc1 = FValue.trim();
			else
				Varc1 = null;
		if (FCode.equals("Varc2"))
			if (FValue != null && !FValue.equals(""))
				Varc2 = FValue.trim();
			else
				Varc2 = null;
		if (FCode.equals("Varc3"))
			if (FValue != null && !FValue.equals(""))
				Varc3 = FValue.trim();
			else
				Varc3 = null;
		if (FCode.equals("Varc4"))
			if (FValue != null && !FValue.equals(""))
				Varc4 = FValue.trim();
			else
				Varc4 = null;
		if (FCode.equals("Date1"))
			if (FValue != null && !FValue.equals(""))
				Date1 = fDate.getDate(FValue);
			else
				Date1 = null;
		if (FCode.equals("Date2"))
			if (FValue != null && !FValue.equals(""))
				Date2 = fDate.getDate(FValue);
			else
				Date2 = null;
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
		LNPOperationRecordBSchema other = (LNPOperationRecordBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && ID.equals(other.getID()) && ContNo.equals(other.getContNo()) && OperatorCode.equals(other.getOperatorCode()) && OperatorName.equals(other.getOperatorName()) && OperatorType.equals(other.getOperatorType()) && OperationDate.equals(other.getOperationDate()) && OperationTime.equals(other.getOperationTime()) && Operation.equals(other.getOperation()) && Int1 == other.getInt1() && Int2 == other.getInt2() && Varc1.equals(other.getVarc1()) && Varc2.equals(other.getVarc2()) && Varc3.equals(other.getVarc3()) && Varc4.equals(other.getVarc4()) && fDate.getString(Date1).equals(other.getDate1()) && fDate.getString(Date2).equals(other.getDate2());
	}

	public int getFieldCount()
	{
		return 18;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("ID"))
			return 2;
		if (strFieldName.equals("ContNo"))
			return 3;
		if (strFieldName.equals("OperatorCode"))
			return 4;
		if (strFieldName.equals("OperatorName"))
			return 5;
		if (strFieldName.equals("OperatorType"))
			return 6;
		if (strFieldName.equals("OperationDate"))
			return 7;
		if (strFieldName.equals("OperationTime"))
			return 8;
		if (strFieldName.equals("Operation"))
			return 9;
		if (strFieldName.equals("Int1"))
			return 10;
		if (strFieldName.equals("Int2"))
			return 11;
		if (strFieldName.equals("Varc1"))
			return 12;
		if (strFieldName.equals("Varc2"))
			return 13;
		if (strFieldName.equals("Varc3"))
			return 14;
		if (strFieldName.equals("Varc4"))
			return 15;
		if (strFieldName.equals("Date1"))
			return 16;
		return !strFieldName.equals("Date2") ? -1 : 17;
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
			strFieldName = "ID";
			break;

		case 3: // '\003'
			strFieldName = "ContNo";
			break;

		case 4: // '\004'
			strFieldName = "OperatorCode";
			break;

		case 5: // '\005'
			strFieldName = "OperatorName";
			break;

		case 6: // '\006'
			strFieldName = "OperatorType";
			break;

		case 7: // '\007'
			strFieldName = "OperationDate";
			break;

		case 8: // '\b'
			strFieldName = "OperationTime";
			break;

		case 9: // '\t'
			strFieldName = "Operation";
			break;

		case 10: // '\n'
			strFieldName = "Int1";
			break;

		case 11: // '\013'
			strFieldName = "Int2";
			break;

		case 12: // '\f'
			strFieldName = "Varc1";
			break;

		case 13: // '\r'
			strFieldName = "Varc2";
			break;

		case 14: // '\016'
			strFieldName = "Varc3";
			break;

		case 15: // '\017'
			strFieldName = "Varc4";
			break;

		case 16: // '\020'
			strFieldName = "Date1";
			break;

		case 17: // '\021'
			strFieldName = "Date2";
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
		if (strFieldName.equals("ID"))
			return 0;
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("OperatorCode"))
			return 0;
		if (strFieldName.equals("OperatorName"))
			return 0;
		if (strFieldName.equals("OperatorType"))
			return 0;
		if (strFieldName.equals("OperationDate"))
			return 0;
		if (strFieldName.equals("OperationTime"))
			return 0;
		if (strFieldName.equals("Operation"))
			return 0;
		if (strFieldName.equals("Int1"))
			return 3;
		if (strFieldName.equals("Int2"))
			return 3;
		if (strFieldName.equals("Varc1"))
			return 0;
		if (strFieldName.equals("Varc2"))
			return 0;
		if (strFieldName.equals("Varc3"))
			return 0;
		if (strFieldName.equals("Varc4"))
			return 0;
		if (strFieldName.equals("Date1"))
			return 1;
		return !strFieldName.equals("Date2") ? -1 : 1;
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
			nFieldType = 3;
			break;

		case 11: // '\013'
			nFieldType = 3;
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
			nFieldType = 1;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
