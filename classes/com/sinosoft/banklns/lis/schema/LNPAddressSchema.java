// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAddressSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPAddressDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPAddressSchema
	implements Schema, Cloneable
{

	private String customerId;
	private String customerNo;
	private String addressNo;
	private String postalAddress;
	private String zipCode;
	private String phone;
	private String fax;
	private String duchy;
	private String homeAddress;
	private String homeZipCode;
	private String homePhone;
	private String homeFax;
	private String companyAddress;
	private String companyZipCode;
	private String companyPhone;
	private String companyFax;
	private String companyMail;
	private String mobile;
	private String mobileChs;
	private String eMail;
	private String bP;
	private String mobile2;
	private String mobileChs2;
	private String eMail2;
	private String bP2;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String grpName;
	private String otherDuchy;
	public static final int FIELDNUM = 32;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPAddressSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "CustomerId";
		pk[1] = "AddressNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPAddressSchema cloned = (LNPAddressSchema)super.clone();
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

	public String getAddressNo()
	{
		return addressNo;
	}

	public void setAddressNo(String aAddressNo)
	{
		addressNo = aAddressNo;
	}

	public String getPostalAddress()
	{
		return postalAddress;
	}

	public void setPostalAddress(String aPostalAddress)
	{
		postalAddress = aPostalAddress;
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

	public String getDuchy()
	{
		return duchy;
	}

	public void setDuchy(String aDuchy)
	{
		duchy = aDuchy;
	}

	public String getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(String aHomeAddress)
	{
		homeAddress = aHomeAddress;
	}

	public String getHomeZipCode()
	{
		return homeZipCode;
	}

	public void setHomeZipCode(String aHomeZipCode)
	{
		homeZipCode = aHomeZipCode;
	}

	public String getHomePhone()
	{
		return homePhone;
	}

	public void setHomePhone(String aHomePhone)
	{
		homePhone = aHomePhone;
	}

	public String getHomeFax()
	{
		return homeFax;
	}

	public void setHomeFax(String aHomeFax)
	{
		homeFax = aHomeFax;
	}

	public String getCompanyAddress()
	{
		return companyAddress;
	}

	public void setCompanyAddress(String aCompanyAddress)
	{
		companyAddress = aCompanyAddress;
	}

	public String getCompanyZipCode()
	{
		return companyZipCode;
	}

	public void setCompanyZipCode(String aCompanyZipCode)
	{
		companyZipCode = aCompanyZipCode;
	}

	public String getCompanyPhone()
	{
		return companyPhone;
	}

	public void setCompanyPhone(String aCompanyPhone)
	{
		companyPhone = aCompanyPhone;
	}

	public String getCompanyFax()
	{
		return companyFax;
	}

	public void setCompanyFax(String aCompanyFax)
	{
		companyFax = aCompanyFax;
	}

	public String getCompanyMail()
	{
		return companyMail;
	}

	public void setCompanyMail(String aCompanyMail)
	{
		companyMail = aCompanyMail;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String aMobile)
	{
		mobile = aMobile;
	}

	public String getMobileChs()
	{
		return mobileChs;
	}

	public void setMobileChs(String aMobileChs)
	{
		mobileChs = aMobileChs;
	}

	public String getEMail()
	{
		return eMail;
	}

	public void setEMail(String aEMail)
	{
		eMail = aEMail;
	}

	public String getBP()
	{
		return bP;
	}

	public void setBP(String aBP)
	{
		bP = aBP;
	}

	public String getMobile2()
	{
		return mobile2;
	}

	public void setMobile2(String aMobile2)
	{
		mobile2 = aMobile2;
	}

	public String getMobileChs2()
	{
		return mobileChs2;
	}

	public void setMobileChs2(String aMobileChs2)
	{
		mobileChs2 = aMobileChs2;
	}

	public String getEMail2()
	{
		return eMail2;
	}

	public void setEMail2(String aEMail2)
	{
		eMail2 = aEMail2;
	}

	public String getBP2()
	{
		return bP2;
	}

	public void setBP2(String aBP2)
	{
		bP2 = aBP2;
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

	public String getGrpName()
	{
		return grpName;
	}

	public void setGrpName(String aGrpName)
	{
		grpName = aGrpName;
	}

	public String getOtherDuchy()
	{
		return otherDuchy;
	}

	public void setOtherDuchy(String aOtherDuchy)
	{
		otherDuchy = aOtherDuchy;
	}

	public void setSchema(LNPAddressSchema aLNPAddressSchema)
	{
		customerId = aLNPAddressSchema.getCustomerId();
		customerNo = aLNPAddressSchema.getCustomerNo();
		addressNo = aLNPAddressSchema.getAddressNo();
		postalAddress = aLNPAddressSchema.getPostalAddress();
		zipCode = aLNPAddressSchema.getZipCode();
		phone = aLNPAddressSchema.getPhone();
		fax = aLNPAddressSchema.getFax();
		duchy = aLNPAddressSchema.getDuchy();
		homeAddress = aLNPAddressSchema.getHomeAddress();
		homeZipCode = aLNPAddressSchema.getHomeZipCode();
		homePhone = aLNPAddressSchema.getHomePhone();
		homeFax = aLNPAddressSchema.getHomeFax();
		companyAddress = aLNPAddressSchema.getCompanyAddress();
		companyZipCode = aLNPAddressSchema.getCompanyZipCode();
		companyPhone = aLNPAddressSchema.getCompanyPhone();
		companyFax = aLNPAddressSchema.getCompanyFax();
		companyMail = aLNPAddressSchema.getCompanyMail();
		mobile = aLNPAddressSchema.getMobile();
		mobileChs = aLNPAddressSchema.getMobileChs();
		eMail = aLNPAddressSchema.getEMail();
		bP = aLNPAddressSchema.getBP();
		mobile2 = aLNPAddressSchema.getMobile2();
		mobileChs2 = aLNPAddressSchema.getMobileChs2();
		eMail2 = aLNPAddressSchema.getEMail2();
		bP2 = aLNPAddressSchema.getBP2();
		operator = aLNPAddressSchema.getOperator();
		makeDate = fDate.getDate(aLNPAddressSchema.getMakeDate());
		makeTime = aLNPAddressSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPAddressSchema.getModifyDate());
		modifyTime = aLNPAddressSchema.getModifyTime();
		grpName = aLNPAddressSchema.getGrpName();
		otherDuchy = aLNPAddressSchema.getOtherDuchy();
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
			if (rs.getString("AddressNo") == null)
				addressNo = null;
			else
				addressNo = rs.getString("AddressNo").trim();
			if (rs.getString("PostalAddress") == null)
				postalAddress = null;
			else
				postalAddress = rs.getString("PostalAddress").trim();
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
			if (rs.getString("duchy") == null)
				duchy = null;
			else
				duchy = rs.getString("duchy").trim();
			if (rs.getString("HomeAddress") == null)
				homeAddress = null;
			else
				homeAddress = rs.getString("HomeAddress").trim();
			if (rs.getString("HomeZipCode") == null)
				homeZipCode = null;
			else
				homeZipCode = rs.getString("HomeZipCode").trim();
			if (rs.getString("HomePhone") == null)
				homePhone = null;
			else
				homePhone = rs.getString("HomePhone").trim();
			if (rs.getString("HomeFax") == null)
				homeFax = null;
			else
				homeFax = rs.getString("HomeFax").trim();
			if (rs.getString("CompanyAddress") == null)
				companyAddress = null;
			else
				companyAddress = rs.getString("CompanyAddress").trim();
			if (rs.getString("CompanyZipCode") == null)
				companyZipCode = null;
			else
				companyZipCode = rs.getString("CompanyZipCode").trim();
			if (rs.getString("CompanyPhone") == null)
				companyPhone = null;
			else
				companyPhone = rs.getString("CompanyPhone").trim();
			if (rs.getString("CompanyFax") == null)
				companyFax = null;
			else
				companyFax = rs.getString("CompanyFax").trim();
			if (rs.getString("CompanyMail") == null)
				companyMail = null;
			else
				companyMail = rs.getString("CompanyMail").trim();
			if (rs.getString("Mobile") == null)
				mobile = null;
			else
				mobile = rs.getString("Mobile").trim();
			if (rs.getString("MobileChs") == null)
				mobileChs = null;
			else
				mobileChs = rs.getString("MobileChs").trim();
			if (rs.getString("EMail") == null)
				eMail = null;
			else
				eMail = rs.getString("EMail").trim();
			if (rs.getString("BP") == null)
				bP = null;
			else
				bP = rs.getString("BP").trim();
			if (rs.getString("Mobile2") == null)
				mobile2 = null;
			else
				mobile2 = rs.getString("Mobile2").trim();
			if (rs.getString("MobileChs2") == null)
				mobileChs2 = null;
			else
				mobileChs2 = rs.getString("MobileChs2").trim();
			if (rs.getString("EMail2") == null)
				eMail2 = null;
			else
				eMail2 = rs.getString("EMail2").trim();
			if (rs.getString("BP2") == null)
				bP2 = null;
			else
				bP2 = rs.getString("BP2").trim();
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
			if (rs.getString("GrpName") == null)
				grpName = null;
			else
				grpName = rs.getString("GrpName").trim();
			if (rs.getString("OtherDuchy") == null)
				otherDuchy = null;
			else
				otherDuchy = rs.getString("OtherDuchy").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPAddress表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPAddressSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPAddressSchema getSchema()
	{
		LNPAddressSchema aLNPAddressSchema = new LNPAddressSchema();
		aLNPAddressSchema.setSchema(this);
		return aLNPAddressSchema;
	}

	public LNPAddressDB getDB()
	{
		LNPAddressDB aDBOper = new LNPAddressDB();
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
		strReturn.append(StrTool.cTrim(addressNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(postalAddress));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(zipCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(phone));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fax));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(duchy));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(homeAddress));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(homeZipCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(homePhone));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(homeFax));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(companyAddress));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(companyZipCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(companyPhone));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(companyFax));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(companyMail));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mobile));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mobileChs));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(eMail));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bP));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mobile2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mobileChs2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(eMail2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bP2));
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
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(otherDuchy));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			postalAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			zipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			fax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			duchy = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			homeAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			homeZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			homePhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			homeFax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			companyAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			companyZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			companyPhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			companyFax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			companyMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			mobile = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			mobileChs = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			bP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			mobile2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			mobileChs2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			eMail2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			bP2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			otherDuchy = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAddressSchema";
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
		if (FCode.equalsIgnoreCase("addressNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addressNo));
		if (FCode.equalsIgnoreCase("postalAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(postalAddress));
		if (FCode.equalsIgnoreCase("zipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(zipCode));
		if (FCode.equalsIgnoreCase("phone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(phone));
		if (FCode.equalsIgnoreCase("fax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fax));
		if (FCode.equalsIgnoreCase("duchy"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(duchy));
		if (FCode.equalsIgnoreCase("homeAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homeAddress));
		if (FCode.equalsIgnoreCase("homeZipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homeZipCode));
		if (FCode.equalsIgnoreCase("homePhone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homePhone));
		if (FCode.equalsIgnoreCase("homeFax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homeFax));
		if (FCode.equalsIgnoreCase("companyAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyAddress));
		if (FCode.equalsIgnoreCase("companyZipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyZipCode));
		if (FCode.equalsIgnoreCase("companyPhone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyPhone));
		if (FCode.equalsIgnoreCase("companyFax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyFax));
		if (FCode.equalsIgnoreCase("companyMail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyMail));
		if (FCode.equalsIgnoreCase("mobile"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mobile));
		if (FCode.equalsIgnoreCase("mobileChs"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mobileChs));
		if (FCode.equalsIgnoreCase("eMail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(eMail));
		if (FCode.equalsIgnoreCase("bP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bP));
		if (FCode.equalsIgnoreCase("mobile2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mobile2));
		if (FCode.equalsIgnoreCase("mobileChs2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mobileChs2));
		if (FCode.equalsIgnoreCase("eMail2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(eMail2));
		if (FCode.equalsIgnoreCase("bP2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bP2));
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
		if (FCode.equalsIgnoreCase("grpName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpName));
		if (FCode.equalsIgnoreCase("otherDuchy"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(otherDuchy));
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
			strFieldValue = StrTool.GBKToUnicode(addressNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(postalAddress);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(zipCode);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(phone);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(fax);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(duchy);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(homeAddress);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(homeZipCode);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(homePhone);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(homeFax);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(companyAddress);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(companyZipCode);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(companyPhone);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(companyFax);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(companyMail);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(mobile);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(mobileChs);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(eMail);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(bP);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(mobile2);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(mobileChs2);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(eMail2);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(bP2);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(grpName);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(otherDuchy);
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
		if (FCode.equalsIgnoreCase("addressNo"))
			if (FValue != null && !FValue.equals(""))
				addressNo = FValue.trim();
			else
				addressNo = null;
		if (FCode.equalsIgnoreCase("postalAddress"))
			if (FValue != null && !FValue.equals(""))
				postalAddress = FValue.trim();
			else
				postalAddress = null;
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
		if (FCode.equalsIgnoreCase("duchy"))
			if (FValue != null && !FValue.equals(""))
				duchy = FValue.trim();
			else
				duchy = null;
		if (FCode.equalsIgnoreCase("homeAddress"))
			if (FValue != null && !FValue.equals(""))
				homeAddress = FValue.trim();
			else
				homeAddress = null;
		if (FCode.equalsIgnoreCase("homeZipCode"))
			if (FValue != null && !FValue.equals(""))
				homeZipCode = FValue.trim();
			else
				homeZipCode = null;
		if (FCode.equalsIgnoreCase("homePhone"))
			if (FValue != null && !FValue.equals(""))
				homePhone = FValue.trim();
			else
				homePhone = null;
		if (FCode.equalsIgnoreCase("homeFax"))
			if (FValue != null && !FValue.equals(""))
				homeFax = FValue.trim();
			else
				homeFax = null;
		if (FCode.equalsIgnoreCase("companyAddress"))
			if (FValue != null && !FValue.equals(""))
				companyAddress = FValue.trim();
			else
				companyAddress = null;
		if (FCode.equalsIgnoreCase("companyZipCode"))
			if (FValue != null && !FValue.equals(""))
				companyZipCode = FValue.trim();
			else
				companyZipCode = null;
		if (FCode.equalsIgnoreCase("companyPhone"))
			if (FValue != null && !FValue.equals(""))
				companyPhone = FValue.trim();
			else
				companyPhone = null;
		if (FCode.equalsIgnoreCase("companyFax"))
			if (FValue != null && !FValue.equals(""))
				companyFax = FValue.trim();
			else
				companyFax = null;
		if (FCode.equalsIgnoreCase("companyMail"))
			if (FValue != null && !FValue.equals(""))
				companyMail = FValue.trim();
			else
				companyMail = null;
		if (FCode.equalsIgnoreCase("mobile"))
			if (FValue != null && !FValue.equals(""))
				mobile = FValue.trim();
			else
				mobile = null;
		if (FCode.equalsIgnoreCase("mobileChs"))
			if (FValue != null && !FValue.equals(""))
				mobileChs = FValue.trim();
			else
				mobileChs = null;
		if (FCode.equalsIgnoreCase("eMail"))
			if (FValue != null && !FValue.equals(""))
				eMail = FValue.trim();
			else
				eMail = null;
		if (FCode.equalsIgnoreCase("bP"))
			if (FValue != null && !FValue.equals(""))
				bP = FValue.trim();
			else
				bP = null;
		if (FCode.equalsIgnoreCase("mobile2"))
			if (FValue != null && !FValue.equals(""))
				mobile2 = FValue.trim();
			else
				mobile2 = null;
		if (FCode.equalsIgnoreCase("mobileChs2"))
			if (FValue != null && !FValue.equals(""))
				mobileChs2 = FValue.trim();
			else
				mobileChs2 = null;
		if (FCode.equalsIgnoreCase("eMail2"))
			if (FValue != null && !FValue.equals(""))
				eMail2 = FValue.trim();
			else
				eMail2 = null;
		if (FCode.equalsIgnoreCase("bP2"))
			if (FValue != null && !FValue.equals(""))
				bP2 = FValue.trim();
			else
				bP2 = null;
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
		if (FCode.equalsIgnoreCase("grpName"))
			if (FValue != null && !FValue.equals(""))
				grpName = FValue.trim();
			else
				grpName = null;
		if (FCode.equalsIgnoreCase("otherDuchy"))
			if (FValue != null && !FValue.equals(""))
				otherDuchy = FValue.trim();
			else
				otherDuchy = null;
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
		LNPAddressSchema other = (LNPAddressSchema)otherObject;
		if (customerId == null && other.getCustomerId() != null)
			return false;
		if (customerId != null && !customerId.equals(other.getCustomerId()))
			return false;
		if (customerNo == null && other.getCustomerNo() != null)
			return false;
		if (customerNo != null && !customerNo.equals(other.getCustomerNo()))
			return false;
		if (addressNo == null && other.getAddressNo() != null)
			return false;
		if (addressNo != null && !addressNo.equals(other.getAddressNo()))
			return false;
		if (postalAddress == null && other.getPostalAddress() != null)
			return false;
		if (postalAddress != null && !postalAddress.equals(other.getPostalAddress()))
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
		if (duchy == null && other.getDuchy() != null)
			return false;
		if (duchy != null && !duchy.equals(other.getDuchy()))
			return false;
		if (homeAddress == null && other.getHomeAddress() != null)
			return false;
		if (homeAddress != null && !homeAddress.equals(other.getHomeAddress()))
			return false;
		if (homeZipCode == null && other.getHomeZipCode() != null)
			return false;
		if (homeZipCode != null && !homeZipCode.equals(other.getHomeZipCode()))
			return false;
		if (homePhone == null && other.getHomePhone() != null)
			return false;
		if (homePhone != null && !homePhone.equals(other.getHomePhone()))
			return false;
		if (homeFax == null && other.getHomeFax() != null)
			return false;
		if (homeFax != null && !homeFax.equals(other.getHomeFax()))
			return false;
		if (companyAddress == null && other.getCompanyAddress() != null)
			return false;
		if (companyAddress != null && !companyAddress.equals(other.getCompanyAddress()))
			return false;
		if (companyZipCode == null && other.getCompanyZipCode() != null)
			return false;
		if (companyZipCode != null && !companyZipCode.equals(other.getCompanyZipCode()))
			return false;
		if (companyPhone == null && other.getCompanyPhone() != null)
			return false;
		if (companyPhone != null && !companyPhone.equals(other.getCompanyPhone()))
			return false;
		if (companyFax == null && other.getCompanyFax() != null)
			return false;
		if (companyFax != null && !companyFax.equals(other.getCompanyFax()))
			return false;
		if (companyMail == null && other.getCompanyMail() != null)
			return false;
		if (companyMail != null && !companyMail.equals(other.getCompanyMail()))
			return false;
		if (mobile == null && other.getMobile() != null)
			return false;
		if (mobile != null && !mobile.equals(other.getMobile()))
			return false;
		if (mobileChs == null && other.getMobileChs() != null)
			return false;
		if (mobileChs != null && !mobileChs.equals(other.getMobileChs()))
			return false;
		if (eMail == null && other.getEMail() != null)
			return false;
		if (eMail != null && !eMail.equals(other.getEMail()))
			return false;
		if (bP == null && other.getBP() != null)
			return false;
		if (bP != null && !bP.equals(other.getBP()))
			return false;
		if (mobile2 == null && other.getMobile2() != null)
			return false;
		if (mobile2 != null && !mobile2.equals(other.getMobile2()))
			return false;
		if (mobileChs2 == null && other.getMobileChs2() != null)
			return false;
		if (mobileChs2 != null && !mobileChs2.equals(other.getMobileChs2()))
			return false;
		if (eMail2 == null && other.getEMail2() != null)
			return false;
		if (eMail2 != null && !eMail2.equals(other.getEMail2()))
			return false;
		if (bP2 == null && other.getBP2() != null)
			return false;
		if (bP2 != null && !bP2.equals(other.getBP2()))
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
		if (modifyTime != null && !modifyTime.equals(other.getModifyTime()))
			return false;
		if (grpName == null && other.getGrpName() != null)
			return false;
		if (grpName != null && !grpName.equals(other.getGrpName()))
			return false;
		if (otherDuchy == null && other.getOtherDuchy() != null)
			return false;
		return otherDuchy == null || otherDuchy.equals(other.getOtherDuchy());
	}

	public int getFieldCount()
	{
		return 32;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("customerId"))
			return 0;
		if (strFieldName.equals("customerNo"))
			return 1;
		if (strFieldName.equals("addressNo"))
			return 2;
		if (strFieldName.equals("postalAddress"))
			return 3;
		if (strFieldName.equals("zipCode"))
			return 4;
		if (strFieldName.equals("phone"))
			return 5;
		if (strFieldName.equals("fax"))
			return 6;
		if (strFieldName.equals("duchy"))
			return 7;
		if (strFieldName.equals("homeAddress"))
			return 8;
		if (strFieldName.equals("homeZipCode"))
			return 9;
		if (strFieldName.equals("homePhone"))
			return 10;
		if (strFieldName.equals("homeFax"))
			return 11;
		if (strFieldName.equals("companyAddress"))
			return 12;
		if (strFieldName.equals("companyZipCode"))
			return 13;
		if (strFieldName.equals("companyPhone"))
			return 14;
		if (strFieldName.equals("companyFax"))
			return 15;
		if (strFieldName.equals("companyMail"))
			return 16;
		if (strFieldName.equals("mobile"))
			return 17;
		if (strFieldName.equals("mobileChs"))
			return 18;
		if (strFieldName.equals("eMail"))
			return 19;
		if (strFieldName.equals("bP"))
			return 20;
		if (strFieldName.equals("mobile2"))
			return 21;
		if (strFieldName.equals("mobileChs2"))
			return 22;
		if (strFieldName.equals("eMail2"))
			return 23;
		if (strFieldName.equals("bP2"))
			return 24;
		if (strFieldName.equals("operator"))
			return 25;
		if (strFieldName.equals("makeDate"))
			return 26;
		if (strFieldName.equals("makeTime"))
			return 27;
		if (strFieldName.equals("modifyDate"))
			return 28;
		if (strFieldName.equals("modifyTime"))
			return 29;
		if (strFieldName.equals("grpName"))
			return 30;
		return !strFieldName.equals("otherDuchy") ? -1 : 31;
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
			strFieldName = "addressNo";
			break;

		case 3: // '\003'
			strFieldName = "postalAddress";
			break;

		case 4: // '\004'
			strFieldName = "zipCode";
			break;

		case 5: // '\005'
			strFieldName = "phone";
			break;

		case 6: // '\006'
			strFieldName = "fax";
			break;

		case 7: // '\007'
			strFieldName = "duchy";
			break;

		case 8: // '\b'
			strFieldName = "homeAddress";
			break;

		case 9: // '\t'
			strFieldName = "homeZipCode";
			break;

		case 10: // '\n'
			strFieldName = "homePhone";
			break;

		case 11: // '\013'
			strFieldName = "homeFax";
			break;

		case 12: // '\f'
			strFieldName = "companyAddress";
			break;

		case 13: // '\r'
			strFieldName = "companyZipCode";
			break;

		case 14: // '\016'
			strFieldName = "companyPhone";
			break;

		case 15: // '\017'
			strFieldName = "companyFax";
			break;

		case 16: // '\020'
			strFieldName = "companyMail";
			break;

		case 17: // '\021'
			strFieldName = "mobile";
			break;

		case 18: // '\022'
			strFieldName = "mobileChs";
			break;

		case 19: // '\023'
			strFieldName = "eMail";
			break;

		case 20: // '\024'
			strFieldName = "bP";
			break;

		case 21: // '\025'
			strFieldName = "mobile2";
			break;

		case 22: // '\026'
			strFieldName = "mobileChs2";
			break;

		case 23: // '\027'
			strFieldName = "eMail2";
			break;

		case 24: // '\030'
			strFieldName = "bP2";
			break;

		case 25: // '\031'
			strFieldName = "operator";
			break;

		case 26: // '\032'
			strFieldName = "makeDate";
			break;

		case 27: // '\033'
			strFieldName = "makeTime";
			break;

		case 28: // '\034'
			strFieldName = "modifyDate";
			break;

		case 29: // '\035'
			strFieldName = "modifyTime";
			break;

		case 30: // '\036'
			strFieldName = "grpName";
			break;

		case 31: // '\037'
			strFieldName = "otherDuchy";
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
		if (strFieldName.equals("addressNo"))
			return 0;
		if (strFieldName.equals("postalAddress"))
			return 0;
		if (strFieldName.equals("zipCode"))
			return 0;
		if (strFieldName.equals("phone"))
			return 0;
		if (strFieldName.equals("fax"))
			return 0;
		if (strFieldName.equals("duchy"))
			return 0;
		if (strFieldName.equals("homeAddress"))
			return 0;
		if (strFieldName.equals("homeZipCode"))
			return 0;
		if (strFieldName.equals("homePhone"))
			return 0;
		if (strFieldName.equals("homeFax"))
			return 0;
		if (strFieldName.equals("companyAddress"))
			return 0;
		if (strFieldName.equals("companyZipCode"))
			return 0;
		if (strFieldName.equals("companyPhone"))
			return 0;
		if (strFieldName.equals("companyFax"))
			return 0;
		if (strFieldName.equals("companyMail"))
			return 0;
		if (strFieldName.equals("mobile"))
			return 0;
		if (strFieldName.equals("mobileChs"))
			return 0;
		if (strFieldName.equals("eMail"))
			return 0;
		if (strFieldName.equals("bP"))
			return 0;
		if (strFieldName.equals("mobile2"))
			return 0;
		if (strFieldName.equals("mobileChs2"))
			return 0;
		if (strFieldName.equals("eMail2"))
			return 0;
		if (strFieldName.equals("bP2"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		if (strFieldName.equals("modifyTime"))
			return 0;
		if (strFieldName.equals("grpName"))
			return 0;
		return !strFieldName.equals("otherDuchy") ? -1 : 0;
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

		case 20: // '\024'
			nFieldType = 0;
			break;

		case 21: // '\025'
			nFieldType = 0;
			break;

		case 22: // '\026'
			nFieldType = 0;
			break;

		case 23: // '\027'
			nFieldType = 0;
			break;

		case 24: // '\030'
			nFieldType = 0;
			break;

		case 25: // '\031'
			nFieldType = 0;
			break;

		case 26: // '\032'
			nFieldType = 1;
			break;

		case 27: // '\033'
			nFieldType = 0;
			break;

		case 28: // '\034'
			nFieldType = 1;
			break;

		case 29: // '\035'
			nFieldType = 0;
			break;

		case 30: // '\036'
			nFieldType = 0;
			break;

		case 31: // '\037'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
