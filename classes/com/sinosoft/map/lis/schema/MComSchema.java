// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MComSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MComDB;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MComSchema
	implements Schema, Cloneable
{

	private String comCode;
	private String outComCode;
	private String name;
	private String shortName;
	private String address;
	private String zipCode;
	private String phone;
	private String fax;
	private String eMail;
	private String webAddress;
	private String satrapName;
	private String insuMonitorCode;
	private String insureID;
	private String signID;
	private String country;
	private String province;
	private String city;
	private String comNature;
	private String validCode;
	private String sign;
	public static final int FIELDNUM = 20;
	private static String PK[];
	public CErrors mErrors;

	public MComSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ComCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MComSchema cloned = (MComSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getComCode()
	{
		return comCode;
	}

	public void setComCode(String aComCode)
	{
		comCode = aComCode;
	}

	public String getOutComCode()
	{
		return outComCode;
	}

	public void setOutComCode(String aOutComCode)
	{
		outComCode = aOutComCode;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String aName)
	{
		name = aName;
	}

	public String getShortName()
	{
		return shortName;
	}

	public void setShortName(String aShortName)
	{
		shortName = aShortName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String aAddress)
	{
		address = aAddress;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String aZipCode)
	{
		zipCode = aZipCode;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String aPhone)
	{
		phone = aPhone;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String aFax)
	{
		fax = aFax;
	}

	public String getEMail()
	{
		return eMail;
	}

	public void setEMail(String aEMail)
	{
		eMail = aEMail;
	}

	public String getWebAddress()
	{
		return webAddress;
	}

	public void setWebAddress(String aWebAddress)
	{
		webAddress = aWebAddress;
	}

	public String getSatrapName()
	{
		return satrapName;
	}

	public void setSatrapName(String aSatrapName)
	{
		satrapName = aSatrapName;
	}

	public String getInsuMonitorCode()
	{
		return insuMonitorCode;
	}

	public void setInsuMonitorCode(String aInsuMonitorCode)
	{
		insuMonitorCode = aInsuMonitorCode;
	}

	public String getInsureID()
	{
		return insureID;
	}

	public void setInsureID(String aInsureID)
	{
		insureID = aInsureID;
	}

	public String getSignID()
	{
		return signID;
	}

	public void setSignID(String aSignID)
	{
		signID = aSignID;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String aCountry)
	{
		country = aCountry;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String aProvince)
	{
		province = aProvince;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String aCity)
	{
		city = aCity;
	}

	public String getComNature()
	{
		return comNature;
	}

	public void setComNature(String aComNature)
	{
		comNature = aComNature;
	}

	public String getValidCode()
	{
		return validCode;
	}

	public void setValidCode(String aValidCode)
	{
		validCode = aValidCode;
	}

	public String getSign()
	{
		return sign;
	}

	public void setSign(String aSign)
	{
		sign = aSign;
	}

	public void setSchema(MComSchema aMComSchema)
	{
		comCode = aMComSchema.getComCode();
		outComCode = aMComSchema.getOutComCode();
		name = aMComSchema.getName();
		shortName = aMComSchema.getShortName();
		address = aMComSchema.getAddress();
		zipCode = aMComSchema.getZipCode();
		phone = aMComSchema.getPhone();
		fax = aMComSchema.getFax();
		eMail = aMComSchema.getEMail();
		webAddress = aMComSchema.getWebAddress();
		satrapName = aMComSchema.getSatrapName();
		insuMonitorCode = aMComSchema.getInsuMonitorCode();
		insureID = aMComSchema.getInsureID();
		signID = aMComSchema.getSignID();
		country = aMComSchema.getCountry();
		province = aMComSchema.getProvince();
		city = aMComSchema.getCity();
		comNature = aMComSchema.getComNature();
		validCode = aMComSchema.getValidCode();
		sign = aMComSchema.getSign();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ComCode") == null)
				comCode = null;
			else
				comCode = rs.getString("ComCode").trim();
			if (rs.getString("OutComCode") == null)
				outComCode = null;
			else
				outComCode = rs.getString("OutComCode").trim();
			if (rs.getString("Name") == null)
				name = null;
			else
				name = rs.getString("Name").trim();
			if (rs.getString("ShortName") == null)
				shortName = null;
			else
				shortName = rs.getString("ShortName").trim();
			if (rs.getString("Address") == null)
				address = null;
			else
				address = rs.getString("Address").trim();
			if (rs.getString("ZipCode") == null)
				zipCode = null;
			else
				zipCode = rs.getString("ZipCode").trim();
			if (rs.getString("Phone") == null)
				phone = null;
			else
				phone = rs.getString("Phone").trim();
			if (rs.getString("Fax") == null)
				fax = null;
			else
				fax = rs.getString("Fax").trim();
			if (rs.getString("EMail") == null)
				eMail = null;
			else
				eMail = rs.getString("EMail").trim();
			if (rs.getString("WebAddress") == null)
				webAddress = null;
			else
				webAddress = rs.getString("WebAddress").trim();
			if (rs.getString("SatrapName") == null)
				satrapName = null;
			else
				satrapName = rs.getString("SatrapName").trim();
			if (rs.getString("InsuMonitorCode") == null)
				insuMonitorCode = null;
			else
				insuMonitorCode = rs.getString("InsuMonitorCode").trim();
			if (rs.getString("InsureID") == null)
				insureID = null;
			else
				insureID = rs.getString("InsureID").trim();
			if (rs.getString("SignID") == null)
				signID = null;
			else
				signID = rs.getString("SignID").trim();
			if (rs.getString("Country") == null)
				country = null;
			else
				country = rs.getString("Country").trim();
			if (rs.getString("Province") == null)
				province = null;
			else
				province = rs.getString("Province").trim();
			if (rs.getString("City") == null)
				city = null;
			else
				city = rs.getString("City").trim();
			if (rs.getString("ComNature") == null)
				comNature = null;
			else
				comNature = rs.getString("ComNature").trim();
			if (rs.getString("ValidCode") == null)
				validCode = null;
			else
				validCode = rs.getString("ValidCode").trim();
			if (rs.getString("Sign") == null)
				sign = null;
			else
				sign = rs.getString("Sign").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MCom表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MComSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MComSchema getSchema()
	{
		MComSchema aMComSchema = new MComSchema();
		aMComSchema.setSchema(this);
		return aMComSchema;
	}

	public MComDB getDB()
	{
		MComDB aDBOper = new MComDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(comCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(outComCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(name));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(shortName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(address));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(zipCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(phone));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fax));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(eMail));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(webAddress));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(satrapName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuMonitorCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insureID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(signID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(country));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(province));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(city));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(comNature));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(validCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sign));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			comCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			outComCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			shortName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			address = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			zipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			fax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			webAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			satrapName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			insuMonitorCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			insureID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			signID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			country = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			province = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			city = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			comNature = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			validCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			sign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MComSchema";
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
		if (FCode.equalsIgnoreCase("comCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comCode));
		if (FCode.equalsIgnoreCase("outComCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(outComCode));
		if (FCode.equalsIgnoreCase("name"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(name));
		if (FCode.equalsIgnoreCase("shortName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(shortName));
		if (FCode.equalsIgnoreCase("address"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(address));
		if (FCode.equalsIgnoreCase("zipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(zipCode));
		if (FCode.equalsIgnoreCase("phone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(phone));
		if (FCode.equalsIgnoreCase("fax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fax));
		if (FCode.equalsIgnoreCase("eMail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(eMail));
		if (FCode.equalsIgnoreCase("webAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(webAddress));
		if (FCode.equalsIgnoreCase("satrapName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(satrapName));
		if (FCode.equalsIgnoreCase("insuMonitorCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuMonitorCode));
		if (FCode.equalsIgnoreCase("insureID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insureID));
		if (FCode.equalsIgnoreCase("signID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signID));
		if (FCode.equalsIgnoreCase("country"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(country));
		if (FCode.equalsIgnoreCase("province"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(province));
		if (FCode.equalsIgnoreCase("city"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(city));
		if (FCode.equalsIgnoreCase("comNature"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comNature));
		if (FCode.equalsIgnoreCase("validCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(validCode));
		if (FCode.equalsIgnoreCase("sign"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sign));
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
			strFieldValue = StrTool.GBKToUnicode(comCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(outComCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(name);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(shortName);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(address);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(zipCode);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(phone);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(fax);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(eMail);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(webAddress);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(satrapName);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(insuMonitorCode);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(insureID);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(signID);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(country);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(province);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(city);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(comNature);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(validCode);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(sign);
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
		if (FCode.equalsIgnoreCase("comCode"))
			if (FValue != null && !FValue.equals(""))
				comCode = FValue.trim();
			else
				comCode = null;
		if (FCode.equalsIgnoreCase("outComCode"))
			if (FValue != null && !FValue.equals(""))
				outComCode = FValue.trim();
			else
				outComCode = null;
		if (FCode.equalsIgnoreCase("name"))
			if (FValue != null && !FValue.equals(""))
				name = FValue.trim();
			else
				name = null;
		if (FCode.equalsIgnoreCase("shortName"))
			if (FValue != null && !FValue.equals(""))
				shortName = FValue.trim();
			else
				shortName = null;
		if (FCode.equalsIgnoreCase("address"))
			if (FValue != null && !FValue.equals(""))
				address = FValue.trim();
			else
				address = null;
		if (FCode.equalsIgnoreCase("zipCode"))
			if (FValue != null && !FValue.equals(""))
				zipCode = FValue.trim();
			else
				zipCode = null;
		if (FCode.equalsIgnoreCase("phone"))
			if (FValue != null && !FValue.equals(""))
				phone = FValue.trim();
			else
				phone = null;
		if (FCode.equalsIgnoreCase("fax"))
			if (FValue != null && !FValue.equals(""))
				fax = FValue.trim();
			else
				fax = null;
		if (FCode.equalsIgnoreCase("eMail"))
			if (FValue != null && !FValue.equals(""))
				eMail = FValue.trim();
			else
				eMail = null;
		if (FCode.equalsIgnoreCase("webAddress"))
			if (FValue != null && !FValue.equals(""))
				webAddress = FValue.trim();
			else
				webAddress = null;
		if (FCode.equalsIgnoreCase("satrapName"))
			if (FValue != null && !FValue.equals(""))
				satrapName = FValue.trim();
			else
				satrapName = null;
		if (FCode.equalsIgnoreCase("insuMonitorCode"))
			if (FValue != null && !FValue.equals(""))
				insuMonitorCode = FValue.trim();
			else
				insuMonitorCode = null;
		if (FCode.equalsIgnoreCase("insureID"))
			if (FValue != null && !FValue.equals(""))
				insureID = FValue.trim();
			else
				insureID = null;
		if (FCode.equalsIgnoreCase("signID"))
			if (FValue != null && !FValue.equals(""))
				signID = FValue.trim();
			else
				signID = null;
		if (FCode.equalsIgnoreCase("country"))
			if (FValue != null && !FValue.equals(""))
				country = FValue.trim();
			else
				country = null;
		if (FCode.equalsIgnoreCase("province"))
			if (FValue != null && !FValue.equals(""))
				province = FValue.trim();
			else
				province = null;
		if (FCode.equalsIgnoreCase("city"))
			if (FValue != null && !FValue.equals(""))
				city = FValue.trim();
			else
				city = null;
		if (FCode.equalsIgnoreCase("comNature"))
			if (FValue != null && !FValue.equals(""))
				comNature = FValue.trim();
			else
				comNature = null;
		if (FCode.equalsIgnoreCase("validCode"))
			if (FValue != null && !FValue.equals(""))
				validCode = FValue.trim();
			else
				validCode = null;
		if (FCode.equalsIgnoreCase("sign"))
			if (FValue != null && !FValue.equals(""))
				sign = FValue.trim();
			else
				sign = null;
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
		MComSchema other = (MComSchema)otherObject;
		if (comCode == null && other.getComCode() != null)
			return false;
		if (comCode != null && !comCode.equals(other.getComCode()))
			return false;
		if (outComCode == null && other.getOutComCode() != null)
			return false;
		if (outComCode != null && !outComCode.equals(other.getOutComCode()))
			return false;
		if (name == null && other.getName() != null)
			return false;
		if (name != null && !name.equals(other.getName()))
			return false;
		if (shortName == null && other.getShortName() != null)
			return false;
		if (shortName != null && !shortName.equals(other.getShortName()))
			return false;
		if (address == null && other.getAddress() != null)
			return false;
		if (address != null && !address.equals(other.getAddress()))
			return false;
		if (zipCode == null && other.getZipCode() != null)
			return false;
		if (zipCode != null && !zipCode.equals(other.getZipCode()))
			return false;
		if (phone == null && other.getPhone() != null)
			return false;
		if (phone != null && !phone.equals(other.getPhone()))
			return false;
		if (fax == null && other.getFax() != null)
			return false;
		if (fax != null && !fax.equals(other.getFax()))
			return false;
		if (eMail == null && other.getEMail() != null)
			return false;
		if (eMail != null && !eMail.equals(other.getEMail()))
			return false;
		if (webAddress == null && other.getWebAddress() != null)
			return false;
		if (webAddress != null && !webAddress.equals(other.getWebAddress()))
			return false;
		if (satrapName == null && other.getSatrapName() != null)
			return false;
		if (satrapName != null && !satrapName.equals(other.getSatrapName()))
			return false;
		if (insuMonitorCode == null && other.getInsuMonitorCode() != null)
			return false;
		if (insuMonitorCode != null && !insuMonitorCode.equals(other.getInsuMonitorCode()))
			return false;
		if (insureID == null && other.getInsureID() != null)
			return false;
		if (insureID != null && !insureID.equals(other.getInsureID()))
			return false;
		if (signID == null && other.getSignID() != null)
			return false;
		if (signID != null && !signID.equals(other.getSignID()))
			return false;
		if (country == null && other.getCountry() != null)
			return false;
		if (country != null && !country.equals(other.getCountry()))
			return false;
		if (province == null && other.getProvince() != null)
			return false;
		if (province != null && !province.equals(other.getProvince()))
			return false;
		if (city == null && other.getCity() != null)
			return false;
		if (city != null && !city.equals(other.getCity()))
			return false;
		if (comNature == null && other.getComNature() != null)
			return false;
		if (comNature != null && !comNature.equals(other.getComNature()))
			return false;
		if (validCode == null && other.getValidCode() != null)
			return false;
		if (validCode != null && !validCode.equals(other.getValidCode()))
			return false;
		if (sign == null && other.getSign() != null)
			return false;
		return sign == null || sign.equals(other.getSign());
	}

	public int getFieldCount()
	{
		return 20;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("comCode"))
			return 0;
		if (strFieldName.equals("outComCode"))
			return 1;
		if (strFieldName.equals("name"))
			return 2;
		if (strFieldName.equals("shortName"))
			return 3;
		if (strFieldName.equals("address"))
			return 4;
		if (strFieldName.equals("zipCode"))
			return 5;
		if (strFieldName.equals("phone"))
			return 6;
		if (strFieldName.equals("fax"))
			return 7;
		if (strFieldName.equals("eMail"))
			return 8;
		if (strFieldName.equals("webAddress"))
			return 9;
		if (strFieldName.equals("satrapName"))
			return 10;
		if (strFieldName.equals("insuMonitorCode"))
			return 11;
		if (strFieldName.equals("insureID"))
			return 12;
		if (strFieldName.equals("signID"))
			return 13;
		if (strFieldName.equals("country"))
			return 14;
		if (strFieldName.equals("province"))
			return 15;
		if (strFieldName.equals("city"))
			return 16;
		if (strFieldName.equals("comNature"))
			return 17;
		if (strFieldName.equals("validCode"))
			return 18;
		return !strFieldName.equals("sign") ? -1 : 19;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "comCode";
			break;

		case 1: // '\001'
			strFieldName = "outComCode";
			break;

		case 2: // '\002'
			strFieldName = "name";
			break;

		case 3: // '\003'
			strFieldName = "shortName";
			break;

		case 4: // '\004'
			strFieldName = "address";
			break;

		case 5: // '\005'
			strFieldName = "zipCode";
			break;

		case 6: // '\006'
			strFieldName = "phone";
			break;

		case 7: // '\007'
			strFieldName = "fax";
			break;

		case 8: // '\b'
			strFieldName = "eMail";
			break;

		case 9: // '\t'
			strFieldName = "webAddress";
			break;

		case 10: // '\n'
			strFieldName = "satrapName";
			break;

		case 11: // '\013'
			strFieldName = "insuMonitorCode";
			break;

		case 12: // '\f'
			strFieldName = "insureID";
			break;

		case 13: // '\r'
			strFieldName = "signID";
			break;

		case 14: // '\016'
			strFieldName = "country";
			break;

		case 15: // '\017'
			strFieldName = "province";
			break;

		case 16: // '\020'
			strFieldName = "city";
			break;

		case 17: // '\021'
			strFieldName = "comNature";
			break;

		case 18: // '\022'
			strFieldName = "validCode";
			break;

		case 19: // '\023'
			strFieldName = "sign";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("comCode"))
			return 0;
		if (strFieldName.equals("outComCode"))
			return 0;
		if (strFieldName.equals("name"))
			return 0;
		if (strFieldName.equals("shortName"))
			return 0;
		if (strFieldName.equals("address"))
			return 0;
		if (strFieldName.equals("zipCode"))
			return 0;
		if (strFieldName.equals("phone"))
			return 0;
		if (strFieldName.equals("fax"))
			return 0;
		if (strFieldName.equals("eMail"))
			return 0;
		if (strFieldName.equals("webAddress"))
			return 0;
		if (strFieldName.equals("satrapName"))
			return 0;
		if (strFieldName.equals("insuMonitorCode"))
			return 0;
		if (strFieldName.equals("insureID"))
			return 0;
		if (strFieldName.equals("signID"))
			return 0;
		if (strFieldName.equals("country"))
			return 0;
		if (strFieldName.equals("province"))
			return 0;
		if (strFieldName.equals("city"))
			return 0;
		if (strFieldName.equals("comNature"))
			return 0;
		if (strFieldName.equals("validCode"))
			return 0;
		return !strFieldName.equals("sign") ? -1 : 0;
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

		case 11: // '\013'
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 17: // '\021'
			nFieldType = 0;
			break;

		case 18: // '\022'
			nFieldType = 0;
			break;

		case 19: // '\023'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
