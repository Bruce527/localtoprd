// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsuredRelatedSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPInsuredRelatedDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPInsuredRelatedSchema
	implements Schema, Cloneable
{

	private String polNo;
	private String customerId;
	private String customerNo;
	private String mainCustomerNo;
	private String relationToInsured;
	private String addressNo;
	private String name;
	private String sex;
	private Date birthday;
	private String iDType;
	private String iDNo;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 16;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPInsuredRelatedSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[3];
		pk[0] = "PolNo";
		pk[1] = "CustomerId";
		pk[2] = "MainCustomerNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPInsuredRelatedSchema cloned = (LNPInsuredRelatedSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getPolNo()
	{
		return polNo;
	}

	public void setPolNo(String aPolNo)
	{
		polNo = aPolNo;
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

	public String getMainCustomerNo()
	{
		return mainCustomerNo;
	}

	public void setMainCustomerNo(String aMainCustomerNo)
	{
		mainCustomerNo = aMainCustomerNo;
	}

	public String getRelationToInsured()
	{
		return relationToInsured;
	}

	public void setRelationToInsured(String aRelationToInsured)
	{
		relationToInsured = aRelationToInsured;
	}

	public String getAddressNo()
	{
		return addressNo;
	}

	public void setAddressNo(String aAddressNo)
	{
		addressNo = aAddressNo;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String aName)
	{
		name = aName;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String aSex)
	{
		sex = aSex;
	}

	public String getBirthday()
	{
		if (birthday != null)
			return fDate.getString(birthday);
		else
			return null;
	}

	public void setBirthday(Date aBirthday)
	{
		birthday = aBirthday;
	}

	public void setBirthday(String aBirthday)
	{
		if (aBirthday != null && !aBirthday.equals(""))
			birthday = fDate.getDate(aBirthday);
		else
			birthday = null;
	}

	public String getIDType()
	{
		return iDType;
	}

	public void setIDType(String aIDType)
	{
		iDType = aIDType;
	}

	public String getIDNo()
	{
		return iDNo;
	}

	public void setIDNo(String aIDNo)
	{
		iDNo = aIDNo;
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

	public void setSchema(LNPInsuredRelatedSchema aLNPInsuredRelatedSchema)
	{
		polNo = aLNPInsuredRelatedSchema.getPolNo();
		customerId = aLNPInsuredRelatedSchema.getCustomerId();
		customerNo = aLNPInsuredRelatedSchema.getCustomerNo();
		mainCustomerNo = aLNPInsuredRelatedSchema.getMainCustomerNo();
		relationToInsured = aLNPInsuredRelatedSchema.getRelationToInsured();
		addressNo = aLNPInsuredRelatedSchema.getAddressNo();
		name = aLNPInsuredRelatedSchema.getName();
		sex = aLNPInsuredRelatedSchema.getSex();
		birthday = fDate.getDate(aLNPInsuredRelatedSchema.getBirthday());
		iDType = aLNPInsuredRelatedSchema.getIDType();
		iDNo = aLNPInsuredRelatedSchema.getIDNo();
		operator = aLNPInsuredRelatedSchema.getOperator();
		makeDate = fDate.getDate(aLNPInsuredRelatedSchema.getMakeDate());
		makeTime = aLNPInsuredRelatedSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPInsuredRelatedSchema.getModifyDate());
		modifyTime = aLNPInsuredRelatedSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("PolNo") == null)
				polNo = null;
			else
				polNo = rs.getString("PolNo").trim();
			if (rs.getString("CustomerId") == null)
				customerId = null;
			else
				customerId = rs.getString("CustomerId").trim();
			if (rs.getString("CustomerNo") == null)
				customerNo = null;
			else
				customerNo = rs.getString("CustomerNo").trim();
			if (rs.getString("MainCustomerNo") == null)
				mainCustomerNo = null;
			else
				mainCustomerNo = rs.getString("MainCustomerNo").trim();
			if (rs.getString("RelationToInsured") == null)
				relationToInsured = null;
			else
				relationToInsured = rs.getString("RelationToInsured").trim();
			if (rs.getString("AddressNo") == null)
				addressNo = null;
			else
				addressNo = rs.getString("AddressNo").trim();
			if (rs.getString("Name") == null)
				name = null;
			else
				name = rs.getString("Name").trim();
			if (rs.getString("Sex") == null)
				sex = null;
			else
				sex = rs.getString("Sex").trim();
			birthday = rs.getDate("Birthday");
			if (rs.getString("IDType") == null)
				iDType = null;
			else
				iDType = rs.getString("IDType").trim();
			if (rs.getString("IDNo") == null)
				iDNo = null;
			else
				iDNo = rs.getString("IDNo").trim();
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
			System.out.println("��ݿ��е�LNPInsuredRelated���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPInsuredRelatedSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPInsuredRelatedSchema getSchema()
	{
		LNPInsuredRelatedSchema aLNPInsuredRelatedSchema = new LNPInsuredRelatedSchema();
		aLNPInsuredRelatedSchema.setSchema(this);
		return aLNPInsuredRelatedSchema;
	}

	public LNPInsuredRelatedDB getDB()
	{
		LNPInsuredRelatedDB aDBOper = new LNPInsuredRelatedDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(polNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(customerId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(customerNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mainCustomerNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relationToInsured));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(addressNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(name));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sex));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(birthday)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDNo));
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
			polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			mainCustomerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			relationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			birthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredRelatedSchema";
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
		if (FCode.equalsIgnoreCase("polNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polNo));
		if (FCode.equalsIgnoreCase("customerId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerId));
		if (FCode.equalsIgnoreCase("customerNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerNo));
		if (FCode.equalsIgnoreCase("mainCustomerNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mainCustomerNo));
		if (FCode.equalsIgnoreCase("relationToInsured"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relationToInsured));
		if (FCode.equalsIgnoreCase("addressNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addressNo));
		if (FCode.equalsIgnoreCase("name"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(name));
		if (FCode.equalsIgnoreCase("sex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sex));
		if (FCode.equalsIgnoreCase("birthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
		if (FCode.equalsIgnoreCase("iDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDType));
		if (FCode.equalsIgnoreCase("iDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDNo));
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
			strFieldValue = StrTool.GBKToUnicode(polNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(customerId);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(customerNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(mainCustomerNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(relationToInsured);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(addressNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(name);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(sex);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(iDType);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(iDNo);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 15: // '\017'
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
		if (FCode.equalsIgnoreCase("polNo"))
			if (FValue != null && !FValue.equals(""))
				polNo = FValue.trim();
			else
				polNo = null;
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
		if (FCode.equalsIgnoreCase("mainCustomerNo"))
			if (FValue != null && !FValue.equals(""))
				mainCustomerNo = FValue.trim();
			else
				mainCustomerNo = null;
		if (FCode.equalsIgnoreCase("relationToInsured"))
			if (FValue != null && !FValue.equals(""))
				relationToInsured = FValue.trim();
			else
				relationToInsured = null;
		if (FCode.equalsIgnoreCase("addressNo"))
			if (FValue != null && !FValue.equals(""))
				addressNo = FValue.trim();
			else
				addressNo = null;
		if (FCode.equalsIgnoreCase("name"))
			if (FValue != null && !FValue.equals(""))
				name = FValue.trim();
			else
				name = null;
		if (FCode.equalsIgnoreCase("sex"))
			if (FValue != null && !FValue.equals(""))
				sex = FValue.trim();
			else
				sex = null;
		if (FCode.equalsIgnoreCase("birthday"))
			if (FValue != null && !FValue.equals(""))
				birthday = fDate.getDate(FValue);
			else
				birthday = null;
		if (FCode.equalsIgnoreCase("iDType"))
			if (FValue != null && !FValue.equals(""))
				iDType = FValue.trim();
			else
				iDType = null;
		if (FCode.equalsIgnoreCase("iDNo"))
			if (FValue != null && !FValue.equals(""))
				iDNo = FValue.trim();
			else
				iDNo = null;
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
		LNPInsuredRelatedSchema other = (LNPInsuredRelatedSchema)otherObject;
		if (polNo == null && other.getPolNo() != null)
			return false;
		if (polNo != null && !polNo.equals(other.getPolNo()))
			return false;
		if (customerId == null && other.getCustomerId() != null)
			return false;
		if (customerId != null && !customerId.equals(other.getCustomerId()))
			return false;
		if (customerNo == null && other.getCustomerNo() != null)
			return false;
		if (customerNo != null && !customerNo.equals(other.getCustomerNo()))
			return false;
		if (mainCustomerNo == null && other.getMainCustomerNo() != null)
			return false;
		if (mainCustomerNo != null && !mainCustomerNo.equals(other.getMainCustomerNo()))
			return false;
		if (relationToInsured == null && other.getRelationToInsured() != null)
			return false;
		if (relationToInsured != null && !relationToInsured.equals(other.getRelationToInsured()))
			return false;
		if (addressNo == null && other.getAddressNo() != null)
			return false;
		if (addressNo != null && !addressNo.equals(other.getAddressNo()))
			return false;
		if (name == null && other.getName() != null)
			return false;
		if (name != null && !name.equals(other.getName()))
			return false;
		if (sex == null && other.getSex() != null)
			return false;
		if (sex != null && !sex.equals(other.getSex()))
			return false;
		if (birthday == null && other.getBirthday() != null)
			return false;
		if (birthday != null && !fDate.getString(birthday).equals(other.getBirthday()))
			return false;
		if (iDType == null && other.getIDType() != null)
			return false;
		if (iDType != null && !iDType.equals(other.getIDType()))
			return false;
		if (iDNo == null && other.getIDNo() != null)
			return false;
		if (iDNo != null && !iDNo.equals(other.getIDNo()))
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
		return 16;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("polNo"))
			return 0;
		if (strFieldName.equals("customerId"))
			return 1;
		if (strFieldName.equals("customerNo"))
			return 2;
		if (strFieldName.equals("mainCustomerNo"))
			return 3;
		if (strFieldName.equals("relationToInsured"))
			return 4;
		if (strFieldName.equals("addressNo"))
			return 5;
		if (strFieldName.equals("name"))
			return 6;
		if (strFieldName.equals("sex"))
			return 7;
		if (strFieldName.equals("birthday"))
			return 8;
		if (strFieldName.equals("iDType"))
			return 9;
		if (strFieldName.equals("iDNo"))
			return 10;
		if (strFieldName.equals("operator"))
			return 11;
		if (strFieldName.equals("makeDate"))
			return 12;
		if (strFieldName.equals("makeTime"))
			return 13;
		if (strFieldName.equals("modifyDate"))
			return 14;
		return !strFieldName.equals("modifyTime") ? -1 : 15;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "polNo";
			break;

		case 1: // '\001'
			strFieldName = "customerId";
			break;

		case 2: // '\002'
			strFieldName = "customerNo";
			break;

		case 3: // '\003'
			strFieldName = "mainCustomerNo";
			break;

		case 4: // '\004'
			strFieldName = "relationToInsured";
			break;

		case 5: // '\005'
			strFieldName = "addressNo";
			break;

		case 6: // '\006'
			strFieldName = "name";
			break;

		case 7: // '\007'
			strFieldName = "sex";
			break;

		case 8: // '\b'
			strFieldName = "birthday";
			break;

		case 9: // '\t'
			strFieldName = "iDType";
			break;

		case 10: // '\n'
			strFieldName = "iDNo";
			break;

		case 11: // '\013'
			strFieldName = "operator";
			break;

		case 12: // '\f'
			strFieldName = "makeDate";
			break;

		case 13: // '\r'
			strFieldName = "makeTime";
			break;

		case 14: // '\016'
			strFieldName = "modifyDate";
			break;

		case 15: // '\017'
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
		if (strFieldName.equals("polNo"))
			return 0;
		if (strFieldName.equals("customerId"))
			return 0;
		if (strFieldName.equals("customerNo"))
			return 0;
		if (strFieldName.equals("mainCustomerNo"))
			return 0;
		if (strFieldName.equals("relationToInsured"))
			return 0;
		if (strFieldName.equals("addressNo"))
			return 0;
		if (strFieldName.equals("name"))
			return 0;
		if (strFieldName.equals("sex"))
			return 0;
		if (strFieldName.equals("birthday"))
			return 1;
		if (strFieldName.equals("iDType"))
			return 0;
		if (strFieldName.equals("iDNo"))
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
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 1;
			break;

		case 9: // '\t'
			nFieldType = 0;
			break;

		case 10: // '\n'
			nFieldType = 0;
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
			nFieldType = 1;
			break;

		case 15: // '\017'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
