// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAccountSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPAccountDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPAccountSchema
	implements Schema, Cloneable
{

	private String customerId;
	private String customerNo;
	private String accKind;
	private String bankCode;
	private String bankAccNo;
	private String accName;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 11;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPAccountSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[3];
		pk[0] = "CustomerNo";
		pk[1] = "BankCode";
		pk[2] = "BankAccNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPAccountSchema cloned = (LNPAccountSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String aCustomerId)
	{
		customerId = aCustomerId;
	}

	public String getCustomerNo()
	{
		return customerNo;
	}

	public void setCustomerNo(String aCustomerNo)
	{
		customerNo = aCustomerNo;
	}

	public String getAccKind()
	{
		return accKind;
	}

	public void setAccKind(String aAccKind)
	{
		accKind = aAccKind;
	}

	public String getBankCode()
	{
		return bankCode;
	}

	public void setBankCode(String aBankCode)
	{
		bankCode = aBankCode;
	}

	public String getBankAccNo()
	{
		return bankAccNo;
	}

	public void setBankAccNo(String aBankAccNo)
	{
		bankAccNo = aBankAccNo;
	}

	public String getAccName()
	{
		return accName;
	}

	public void setAccName(String aAccName)
	{
		accName = aAccName;
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

	public void setSchema(LNPAccountSchema aLNPAccountSchema)
	{
		customerId = aLNPAccountSchema.getCustomerId();
		customerNo = aLNPAccountSchema.getCustomerNo();
		accKind = aLNPAccountSchema.getAccKind();
		bankCode = aLNPAccountSchema.getBankCode();
		bankAccNo = aLNPAccountSchema.getBankAccNo();
		accName = aLNPAccountSchema.getAccName();
		operator = aLNPAccountSchema.getOperator();
		makeDate = fDate.getDate(aLNPAccountSchema.getMakeDate());
		makeTime = aLNPAccountSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPAccountSchema.getModifyDate());
		modifyTime = aLNPAccountSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("CustomerId") == null)
				customerId = null;
			else
				customerId = rs.getString("CustomerId").trim();
			if (rs.getString("CustomerNo") == null)
				customerNo = null;
			else
				customerNo = rs.getString("CustomerNo").trim();
			if (rs.getString("AccKind") == null)
				accKind = null;
			else
				accKind = rs.getString("AccKind").trim();
			if (rs.getString("BankCode") == null)
				bankCode = null;
			else
				bankCode = rs.getString("BankCode").trim();
			if (rs.getString("BankAccNo") == null)
				bankAccNo = null;
			else
				bankAccNo = rs.getString("BankAccNo").trim();
			if (rs.getString("AccName") == null)
				accName = null;
			else
				accName = rs.getString("AccName").trim();
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
			System.out.println("数据库中的LNPAccount表字段个数和Schema中的字段个数不一致，或�?�执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPAccountSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPAccountSchema getSchema()
	{
		LNPAccountSchema aLNPAccountSchema = new LNPAccountSchema();
		aLNPAccountSchema.setSchema(this);
		return aLNPAccountSchema;
	}

	public LNPAccountDB getDB()
	{
		LNPAccountDB aDBOper = new LNPAccountDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(customerId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(customerNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(accKind));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bankCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bankAccNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(accName));
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
			customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			accKind = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAccountSchema";
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
		if (FCode.equalsIgnoreCase("customerId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerId));
		if (FCode.equalsIgnoreCase("customerNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerNo));
		if (FCode.equalsIgnoreCase("accKind"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(accKind));
		if (FCode.equalsIgnoreCase("bankCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankCode));
		if (FCode.equalsIgnoreCase("bankAccNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankAccNo));
		if (FCode.equalsIgnoreCase("accName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(accName));
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
			strFieldValue = StrTool.GBKToUnicode(customerId);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(customerNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(accKind);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(bankCode);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(bankAccNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(accName);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(operator);
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
		if (FCode.equalsIgnoreCase("customerId"))
			if (FValue != null && !FValue.equals(""))
				customerId = FValue.trim();
			else
				customerId = null;
		if (FCode.equalsIgnoreCase("customerNo"))
			if (FValue != null && !FValue.equals(""))
				customerNo = FValue.trim();
			else
				customerNo = null;
		if (FCode.equalsIgnoreCase("accKind"))
			if (FValue != null && !FValue.equals(""))
				accKind = FValue.trim();
			else
				accKind = null;
		if (FCode.equalsIgnoreCase("bankCode"))
			if (FValue != null && !FValue.equals(""))
				bankCode = FValue.trim();
			else
				bankCode = null;
		if (FCode.equalsIgnoreCase("bankAccNo"))
			if (FValue != null && !FValue.equals(""))
				bankAccNo = FValue.trim();
			else
				bankAccNo = null;
		if (FCode.equalsIgnoreCase("accName"))
			if (FValue != null && !FValue.equals(""))
				accName = FValue.trim();
			else
				accName = null;
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
		LNPAccountSchema other = (LNPAccountSchema)otherObject;
		if (customerId == null && other.getCustomerId() != null)
			return false;
		if (customerId != null && !customerId.equals(other.getCustomerId()))
			return false;
		if (customerNo == null && other.getCustomerNo() != null)
			return false;
		if (customerNo != null && !customerNo.equals(other.getCustomerNo()))
			return false;
		if (accKind == null && other.getAccKind() != null)
			return false;
		if (accKind != null && !accKind.equals(other.getAccKind()))
			return false;
		if (bankCode == null && other.getBankCode() != null)
			return false;
		if (bankCode != null && !bankCode.equals(other.getBankCode()))
			return false;
		if (bankAccNo == null && other.getBankAccNo() != null)
			return false;
		if (bankAccNo != null && !bankAccNo.equals(other.getBankAccNo()))
			return false;
		if (accName == null && other.getAccName() != null)
			return false;
		if (accName != null && !accName.equals(other.getAccName()))
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
		return 11;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("customerId"))
			return 0;
		if (strFieldName.equals("customerNo"))
			return 1;
		if (strFieldName.equals("accKind"))
			return 2;
		if (strFieldName.equals("bankCode"))
			return 3;
		if (strFieldName.equals("bankAccNo"))
			return 4;
		if (strFieldName.equals("accName"))
			return 5;
		if (strFieldName.equals("operator"))
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
			strFieldName = "customerId";
			break;

		case 1: // '\001'
			strFieldName = "customerNo";
			break;

		case 2: // '\002'
			strFieldName = "accKind";
			break;

		case 3: // '\003'
			strFieldName = "bankCode";
			break;

		case 4: // '\004'
			strFieldName = "bankAccNo";
			break;

		case 5: // '\005'
			strFieldName = "accName";
			break;

		case 6: // '\006'
			strFieldName = "operator";
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
		if (strFieldName.equals("customerId"))
			return 0;
		if (strFieldName.equals("customerNo"))
			return 0;
		if (strFieldName.equals("accKind"))
			return 0;
		if (strFieldName.equals("bankCode"))
			return 0;
		if (strFieldName.equals("bankAccNo"))
			return 0;
		if (strFieldName.equals("accName"))
			return 0;
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
