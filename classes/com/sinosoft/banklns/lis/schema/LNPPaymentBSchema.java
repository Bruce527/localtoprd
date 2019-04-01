// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPaymentBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPPaymentBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPPaymentBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
	private String ContNo;
	private String AppntID;
	private String InusredID;
	private String PayMent1;
	private String PayMent2;
	private String BankCode;
	private String Account;
	private String Operator;
	private Date MakeDate;
	private String MakeTime;
	private Date ModifyDate;
	private String ModifyTime;
	private String Varc1;
	private String Varc2;
	private String Varc3;
	private String Varc4;
	private Date DateTime1;
	private Date DateTime2;
	public static final int FIELDNUM = 20;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPPaymentBSchema()
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

	public String getAppntID()
	{
		if (AppntID != null)
			AppntID.equals("");
		return AppntID;
	}

	public void setAppntID(String aAppntID)
	{
		AppntID = aAppntID;
	}

	public String getInusredID()
	{
		if (InusredID != null)
			InusredID.equals("");
		return InusredID;
	}

	public void setInusredID(String aInusredID)
	{
		InusredID = aInusredID;
	}

	public String getPayMent1()
	{
		if (PayMent1 != null)
			PayMent1.equals("");
		return PayMent1;
	}

	public void setPayMent1(String aPayMent1)
	{
		PayMent1 = aPayMent1;
	}

	public String getPayMent2()
	{
		if (PayMent2 != null)
			PayMent2.equals("");
		return PayMent2;
	}

	public void setPayMent2(String aPayMent2)
	{
		PayMent2 = aPayMent2;
	}

	public String getBankCode()
	{
		if (BankCode != null)
			BankCode.equals("");
		return BankCode;
	}

	public void setBankCode(String aBankCode)
	{
		BankCode = aBankCode;
	}

	public String getAccount()
	{
		if (Account != null)
			Account.equals("");
		return Account;
	}

	public void setAccount(String aAccount)
	{
		Account = aAccount;
	}

	public String getOperator()
	{
		if (Operator != null)
			Operator.equals("");
		return Operator;
	}

	public void setOperator(String aOperator)
	{
		Operator = aOperator;
	}

	public String getMakeDate()
	{
		if (MakeDate != null)
			return fDate.getString(MakeDate);
		else
			return null;
	}

	public void setMakeDate(Date aMakeDate)
	{
		MakeDate = aMakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals(""))
			MakeDate = fDate.getDate(aMakeDate);
		else
			MakeDate = null;
	}

	public String getMakeTime()
	{
		if (MakeTime != null)
			MakeTime.equals("");
		return MakeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		MakeTime = aMakeTime;
	}

	public String getModifyDate()
	{
		if (ModifyDate != null)
			return fDate.getString(ModifyDate);
		else
			return null;
	}

	public void setModifyDate(Date aModifyDate)
	{
		ModifyDate = aModifyDate;
	}

	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals(""))
			ModifyDate = fDate.getDate(aModifyDate);
		else
			ModifyDate = null;
	}

	public String getModifyTime()
	{
		if (ModifyTime != null)
			ModifyTime.equals("");
		return ModifyTime;
	}

	public void setModifyTime(String aModifyTime)
	{
		ModifyTime = aModifyTime;
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

	public String getDateTime1()
	{
		if (DateTime1 != null)
			return fDate.getString(DateTime1);
		else
			return null;
	}

	public void setDateTime1(Date aDateTime1)
	{
		DateTime1 = aDateTime1;
	}

	public void setDateTime1(String aDateTime1)
	{
		if (aDateTime1 != null && !aDateTime1.equals(""))
			DateTime1 = fDate.getDate(aDateTime1);
		else
			DateTime1 = null;
	}

	public String getDateTime2()
	{
		if (DateTime2 != null)
			return fDate.getString(DateTime2);
		else
			return null;
	}

	public void setDateTime2(Date aDateTime2)
	{
		DateTime2 = aDateTime2;
	}

	public void setDateTime2(String aDateTime2)
	{
		if (aDateTime2 != null && !aDateTime2.equals(""))
			DateTime2 = fDate.getDate(aDateTime2);
		else
			DateTime2 = null;
	}

	public void setSchema(LNPPaymentBSchema aLNPPaymentBSchema)
	{
		EdorNo = aLNPPaymentBSchema.getEdorNo();
		serialNo = aLNPPaymentBSchema.getserialNo();
		ContNo = aLNPPaymentBSchema.getContNo();
		AppntID = aLNPPaymentBSchema.getAppntID();
		InusredID = aLNPPaymentBSchema.getInusredID();
		PayMent1 = aLNPPaymentBSchema.getPayMent1();
		PayMent2 = aLNPPaymentBSchema.getPayMent2();
		BankCode = aLNPPaymentBSchema.getBankCode();
		Account = aLNPPaymentBSchema.getAccount();
		Operator = aLNPPaymentBSchema.getOperator();
		MakeDate = fDate.getDate(aLNPPaymentBSchema.getMakeDate());
		MakeTime = aLNPPaymentBSchema.getMakeTime();
		ModifyDate = fDate.getDate(aLNPPaymentBSchema.getModifyDate());
		ModifyTime = aLNPPaymentBSchema.getModifyTime();
		Varc1 = aLNPPaymentBSchema.getVarc1();
		Varc2 = aLNPPaymentBSchema.getVarc2();
		Varc3 = aLNPPaymentBSchema.getVarc3();
		Varc4 = aLNPPaymentBSchema.getVarc4();
		DateTime1 = fDate.getDate(aLNPPaymentBSchema.getDateTime1());
		DateTime2 = fDate.getDate(aLNPPaymentBSchema.getDateTime2());
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
			if (rs.getString("ContNo") == null)
				ContNo = null;
			else
				ContNo = rs.getString("ContNo").trim();
			if (rs.getString("AppntID") == null)
				AppntID = null;
			else
				AppntID = rs.getString("AppntID").trim();
			if (rs.getString("InusredID") == null)
				InusredID = null;
			else
				InusredID = rs.getString("InusredID").trim();
			if (rs.getString("PayMent1") == null)
				PayMent1 = null;
			else
				PayMent1 = rs.getString("PayMent1").trim();
			if (rs.getString("PayMent2") == null)
				PayMent2 = null;
			else
				PayMent2 = rs.getString("PayMent2").trim();
			if (rs.getString("BankCode") == null)
				BankCode = null;
			else
				BankCode = rs.getString("BankCode").trim();
			if (rs.getString("Account") == null)
				Account = null;
			else
				Account = rs.getString("Account").trim();
			if (rs.getString("Operator") == null)
				Operator = null;
			else
				Operator = rs.getString("Operator").trim();
			MakeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				MakeTime = null;
			else
				MakeTime = rs.getString("MakeTime").trim();
			ModifyDate = rs.getDate("ModifyDate");
			if (rs.getString("ModifyTime") == null)
				ModifyTime = null;
			else
				ModifyTime = rs.getString("ModifyTime").trim();
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
			DateTime1 = rs.getDate("DateTime1");
			DateTime2 = rs.getDate("DateTime2");
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPaymentBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPPaymentBSchema getSchema()
	{
		LNPPaymentBSchema aLNPPaymentBSchema = new LNPPaymentBSchema();
		aLNPPaymentBSchema.setSchema(this);
		return aLNPPaymentBSchema;
	}

	public LNPPaymentBDB getDB()
	{
		LNPPaymentBDB aDBOper = new LNPPaymentBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(AppntID))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(InusredID))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(PayMent1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(PayMent2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BankCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Account))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(MakeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MakeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(ModifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ModifyTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc4))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(DateTime1)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(DateTime2)))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			AppntID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			InusredID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			PayMent1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			PayMent2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			BankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			Account = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			DateTime1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
			DateTime2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPaymentBSchema";
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
		if (FCode.equals("ContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ContNo));
		if (FCode.equals("AppntID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(AppntID));
		if (FCode.equals("InusredID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(InusredID));
		if (FCode.equals("PayMent1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(PayMent1));
		if (FCode.equals("PayMent2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(PayMent2));
		if (FCode.equals("BankCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BankCode));
		if (FCode.equals("Account"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Account));
		if (FCode.equals("Operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		if (FCode.equals("MakeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equals("MakeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		if (FCode.equals("ModifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equals("ModifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime));
		if (FCode.equals("Varc1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc1));
		if (FCode.equals("Varc2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc2));
		if (FCode.equals("Varc3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc3));
		if (FCode.equals("Varc4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc4));
		if (FCode.equals("DateTime1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
		if (FCode.equals("DateTime2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
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
			strFieldValue = StrTool.GBKToUnicode(ContNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(AppntID);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(InusredID);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(PayMent1);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(PayMent2);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(BankCode);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(Account);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(Operator);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(MakeTime);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(ModifyTime);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(Varc1);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(Varc2);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(Varc3);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(Varc4);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
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
		if (FCode.equals("ContNo"))
			if (FValue != null && !FValue.equals(""))
				ContNo = FValue.trim();
			else
				ContNo = null;
		if (FCode.equals("AppntID"))
			if (FValue != null && !FValue.equals(""))
				AppntID = FValue.trim();
			else
				AppntID = null;
		if (FCode.equals("InusredID"))
			if (FValue != null && !FValue.equals(""))
				InusredID = FValue.trim();
			else
				InusredID = null;
		if (FCode.equals("PayMent1"))
			if (FValue != null && !FValue.equals(""))
				PayMent1 = FValue.trim();
			else
				PayMent1 = null;
		if (FCode.equals("PayMent2"))
			if (FValue != null && !FValue.equals(""))
				PayMent2 = FValue.trim();
			else
				PayMent2 = null;
		if (FCode.equals("BankCode"))
			if (FValue != null && !FValue.equals(""))
				BankCode = FValue.trim();
			else
				BankCode = null;
		if (FCode.equals("Account"))
			if (FValue != null && !FValue.equals(""))
				Account = FValue.trim();
			else
				Account = null;
		if (FCode.equals("Operator"))
			if (FValue != null && !FValue.equals(""))
				Operator = FValue.trim();
			else
				Operator = null;
		if (FCode.equals("MakeDate"))
			if (FValue != null && !FValue.equals(""))
				MakeDate = fDate.getDate(FValue);
			else
				MakeDate = null;
		if (FCode.equals("MakeTime"))
			if (FValue != null && !FValue.equals(""))
				MakeTime = FValue.trim();
			else
				MakeTime = null;
		if (FCode.equals("ModifyDate"))
			if (FValue != null && !FValue.equals(""))
				ModifyDate = fDate.getDate(FValue);
			else
				ModifyDate = null;
		if (FCode.equals("ModifyTime"))
			if (FValue != null && !FValue.equals(""))
				ModifyTime = FValue.trim();
			else
				ModifyTime = null;
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
		if (FCode.equals("DateTime1"))
			if (FValue != null && !FValue.equals(""))
				DateTime1 = fDate.getDate(FValue);
			else
				DateTime1 = null;
		if (FCode.equals("DateTime2"))
			if (FValue != null && !FValue.equals(""))
				DateTime2 = fDate.getDate(FValue);
			else
				DateTime2 = null;
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
		LNPPaymentBSchema other = (LNPPaymentBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && ContNo.equals(other.getContNo()) && AppntID.equals(other.getAppntID()) && InusredID.equals(other.getInusredID()) && PayMent1.equals(other.getPayMent1()) && PayMent2.equals(other.getPayMent2()) && BankCode.equals(other.getBankCode()) && Account.equals(other.getAccount()) && Operator.equals(other.getOperator()) && fDate.getString(MakeDate).equals(other.getMakeDate()) && MakeTime.equals(other.getMakeTime()) && fDate.getString(ModifyDate).equals(other.getModifyDate()) && ModifyTime.equals(other.getModifyTime()) && Varc1.equals(other.getVarc1()) && Varc2.equals(other.getVarc2()) && Varc3.equals(other.getVarc3()) && Varc4.equals(other.getVarc4()) && fDate.getString(DateTime1).equals(other.getDateTime1()) && fDate.getString(DateTime2).equals(other.getDateTime2());
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
		if (strFieldName.equals("ContNo"))
			return 2;
		if (strFieldName.equals("AppntID"))
			return 3;
		if (strFieldName.equals("InusredID"))
			return 4;
		if (strFieldName.equals("PayMent1"))
			return 5;
		if (strFieldName.equals("PayMent2"))
			return 6;
		if (strFieldName.equals("BankCode"))
			return 7;
		if (strFieldName.equals("Account"))
			return 8;
		if (strFieldName.equals("Operator"))
			return 9;
		if (strFieldName.equals("MakeDate"))
			return 10;
		if (strFieldName.equals("MakeTime"))
			return 11;
		if (strFieldName.equals("ModifyDate"))
			return 12;
		if (strFieldName.equals("ModifyTime"))
			return 13;
		if (strFieldName.equals("Varc1"))
			return 14;
		if (strFieldName.equals("Varc2"))
			return 15;
		if (strFieldName.equals("Varc3"))
			return 16;
		if (strFieldName.equals("Varc4"))
			return 17;
		if (strFieldName.equals("DateTime1"))
			return 18;
		return !strFieldName.equals("DateTime2") ? -1 : 19;
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
			strFieldName = "ContNo";
			break;

		case 3: // '\003'
			strFieldName = "AppntID";
			break;

		case 4: // '\004'
			strFieldName = "InusredID";
			break;

		case 5: // '\005'
			strFieldName = "PayMent1";
			break;

		case 6: // '\006'
			strFieldName = "PayMent2";
			break;

		case 7: // '\007'
			strFieldName = "BankCode";
			break;

		case 8: // '\b'
			strFieldName = "Account";
			break;

		case 9: // '\t'
			strFieldName = "Operator";
			break;

		case 10: // '\n'
			strFieldName = "MakeDate";
			break;

		case 11: // '\013'
			strFieldName = "MakeTime";
			break;

		case 12: // '\f'
			strFieldName = "ModifyDate";
			break;

		case 13: // '\r'
			strFieldName = "ModifyTime";
			break;

		case 14: // '\016'
			strFieldName = "Varc1";
			break;

		case 15: // '\017'
			strFieldName = "Varc2";
			break;

		case 16: // '\020'
			strFieldName = "Varc3";
			break;

		case 17: // '\021'
			strFieldName = "Varc4";
			break;

		case 18: // '\022'
			strFieldName = "DateTime1";
			break;

		case 19: // '\023'
			strFieldName = "DateTime2";
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
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("AppntID"))
			return 0;
		if (strFieldName.equals("InusredID"))
			return 0;
		if (strFieldName.equals("PayMent1"))
			return 0;
		if (strFieldName.equals("PayMent2"))
			return 0;
		if (strFieldName.equals("BankCode"))
			return 0;
		if (strFieldName.equals("Account"))
			return 0;
		if (strFieldName.equals("Operator"))
			return 0;
		if (strFieldName.equals("MakeDate"))
			return 1;
		if (strFieldName.equals("MakeTime"))
			return 0;
		if (strFieldName.equals("ModifyDate"))
			return 1;
		if (strFieldName.equals("ModifyTime"))
			return 0;
		if (strFieldName.equals("Varc1"))
			return 0;
		if (strFieldName.equals("Varc2"))
			return 0;
		if (strFieldName.equals("Varc3"))
			return 0;
		if (strFieldName.equals("Varc4"))
			return 0;
		if (strFieldName.equals("DateTime1"))
			return 1;
		return !strFieldName.equals("DateTime2") ? -1 : 1;
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
			nFieldType = 1;
			break;

		case 11: // '\013'
			nFieldType = 0;
			break;

		case 12: // '\f'
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 17: // '\021'
			nFieldType = 0;
			break;

		case 18: // '\022'
			nFieldType = 1;
			break;

		case 19: // '\023'
			nFieldType = 1;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
