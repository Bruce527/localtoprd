// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAddressBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPAddressBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPAddressBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
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
	public static final int FIELDNUM = 34;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPAddressBSchema()
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

	public String getcustomerId()
	{
		if (customerId != null)
			customerId.equals("");
		return customerId;
	}

	public void setcustomerId(String acustomerId)
	{
		customerId = acustomerId;
	}

	public String getcustomerNo()
	{
		if (customerNo != null)
			customerNo.equals("");
		return customerNo;
	}

	public void setcustomerNo(String acustomerNo)
	{
		customerNo = acustomerNo;
	}

	public String getaddressNo()
	{
		if (addressNo != null)
			addressNo.equals("");
		return addressNo;
	}

	public void setaddressNo(String aaddressNo)
	{
		addressNo = aaddressNo;
	}

	public String getpostalAddress()
	{
		if (postalAddress != null)
			postalAddress.equals("");
		return postalAddress;
	}

	public void setpostalAddress(String apostalAddress)
	{
		postalAddress = apostalAddress;
	}

	public String getzipCode()
	{
		if (zipCode != null)
			zipCode.equals("");
		return zipCode;
	}

	public void setzipCode(String azipCode)
	{
		zipCode = azipCode;
	}

	public String getphone()
	{
		if (phone != null)
			phone.equals("");
		return phone;
	}

	public void setphone(String aphone)
	{
		phone = aphone;
	}

	public String getfax()
	{
		if (fax != null)
			fax.equals("");
		return fax;
	}

	public void setfax(String afax)
	{
		fax = afax;
	}

	public String getduchy()
	{
		if (duchy != null)
			duchy.equals("");
		return duchy;
	}

	public void setduchy(String aduchy)
	{
		duchy = aduchy;
	}

	public String gethomeAddress()
	{
		if (homeAddress != null)
			homeAddress.equals("");
		return homeAddress;
	}

	public void sethomeAddress(String ahomeAddress)
	{
		homeAddress = ahomeAddress;
	}

	public String gethomeZipCode()
	{
		if (homeZipCode != null)
			homeZipCode.equals("");
		return homeZipCode;
	}

	public void sethomeZipCode(String ahomeZipCode)
	{
		homeZipCode = ahomeZipCode;
	}

	public String gethomePhone()
	{
		if (homePhone != null)
			homePhone.equals("");
		return homePhone;
	}

	public void sethomePhone(String ahomePhone)
	{
		homePhone = ahomePhone;
	}

	public String gethomeFax()
	{
		if (homeFax != null)
			homeFax.equals("");
		return homeFax;
	}

	public void sethomeFax(String ahomeFax)
	{
		homeFax = ahomeFax;
	}

	public String getcompanyAddress()
	{
		if (companyAddress != null)
			companyAddress.equals("");
		return companyAddress;
	}

	public void setcompanyAddress(String acompanyAddress)
	{
		companyAddress = acompanyAddress;
	}

	public String getcompanyZipCode()
	{
		if (companyZipCode != null)
			companyZipCode.equals("");
		return companyZipCode;
	}

	public void setcompanyZipCode(String acompanyZipCode)
	{
		companyZipCode = acompanyZipCode;
	}

	public String getcompanyPhone()
	{
		if (companyPhone != null)
			companyPhone.equals("");
		return companyPhone;
	}

	public void setcompanyPhone(String acompanyPhone)
	{
		companyPhone = acompanyPhone;
	}

	public String getcompanyFax()
	{
		if (companyFax != null)
			companyFax.equals("");
		return companyFax;
	}

	public void setcompanyFax(String acompanyFax)
	{
		companyFax = acompanyFax;
	}

	public String getcompanyMail()
	{
		if (companyMail != null)
			companyMail.equals("");
		return companyMail;
	}

	public void setcompanyMail(String acompanyMail)
	{
		companyMail = acompanyMail;
	}

	public String getmobile()
	{
		if (mobile != null)
			mobile.equals("");
		return mobile;
	}

	public void setmobile(String amobile)
	{
		mobile = amobile;
	}

	public String getmobileChs()
	{
		if (mobileChs != null)
			mobileChs.equals("");
		return mobileChs;
	}

	public void setmobileChs(String amobileChs)
	{
		mobileChs = amobileChs;
	}

	public String geteMail()
	{
		if (eMail != null)
			eMail.equals("");
		return eMail;
	}

	public void seteMail(String aeMail)
	{
		eMail = aeMail;
	}

	public String getbP()
	{
		if (bP != null)
			bP.equals("");
		return bP;
	}

	public void setbP(String abP)
	{
		bP = abP;
	}

	public String getmobile2()
	{
		if (mobile2 != null)
			mobile2.equals("");
		return mobile2;
	}

	public void setmobile2(String amobile2)
	{
		mobile2 = amobile2;
	}

	public String getmobileChs2()
	{
		if (mobileChs2 != null)
			mobileChs2.equals("");
		return mobileChs2;
	}

	public void setmobileChs2(String amobileChs2)
	{
		mobileChs2 = amobileChs2;
	}

	public String geteMail2()
	{
		if (eMail2 != null)
			eMail2.equals("");
		return eMail2;
	}

	public void seteMail2(String aeMail2)
	{
		eMail2 = aeMail2;
	}

	public String getbP2()
	{
		if (bP2 != null)
			bP2.equals("");
		return bP2;
	}

	public void setbP2(String abP2)
	{
		bP2 = abP2;
	}

	public String getoperator()
	{
		if (operator != null)
			operator.equals("");
		return operator;
	}

	public void setoperator(String aoperator)
	{
		operator = aoperator;
	}

	public String getmakeDate()
	{
		if (makeDate != null)
			return fDate.getString(makeDate);
		else
			return null;
	}

	public void setmakeDate(Date amakeDate)
	{
		makeDate = amakeDate;
	}

	public void setmakeDate(String amakeDate)
	{
		if (amakeDate != null && !amakeDate.equals(""))
			makeDate = fDate.getDate(amakeDate);
		else
			makeDate = null;
	}

	public String getmakeTime()
	{
		if (makeTime != null)
			makeTime.equals("");
		return makeTime;
	}

	public void setmakeTime(String amakeTime)
	{
		makeTime = amakeTime;
	}

	public String getmodifyDate()
	{
		if (modifyDate != null)
			return fDate.getString(modifyDate);
		else
			return null;
	}

	public void setmodifyDate(Date amodifyDate)
	{
		modifyDate = amodifyDate;
	}

	public void setmodifyDate(String amodifyDate)
	{
		if (amodifyDate != null && !amodifyDate.equals(""))
			modifyDate = fDate.getDate(amodifyDate);
		else
			modifyDate = null;
	}

	public String getmodifyTime()
	{
		if (modifyTime != null)
			modifyTime.equals("");
		return modifyTime;
	}

	public void setmodifyTime(String amodifyTime)
	{
		modifyTime = amodifyTime;
	}

	public String getgrpName()
	{
		if (grpName != null)
			grpName.equals("");
		return grpName;
	}

	public void setgrpName(String agrpName)
	{
		grpName = agrpName;
	}

	public String getotherDuchy()
	{
		if (otherDuchy != null)
			otherDuchy.equals("");
		return otherDuchy;
	}

	public void setotherDuchy(String aotherDuchy)
	{
		otherDuchy = aotherDuchy;
	}

	public void setSchema(LNPAddressBSchema aLNPAddressBSchema)
	{
		EdorNo = aLNPAddressBSchema.getEdorNo();
		serialNo = aLNPAddressBSchema.getserialNo();
		customerId = aLNPAddressBSchema.getcustomerId();
		customerNo = aLNPAddressBSchema.getcustomerNo();
		addressNo = aLNPAddressBSchema.getaddressNo();
		postalAddress = aLNPAddressBSchema.getpostalAddress();
		zipCode = aLNPAddressBSchema.getzipCode();
		phone = aLNPAddressBSchema.getphone();
		fax = aLNPAddressBSchema.getfax();
		duchy = aLNPAddressBSchema.getduchy();
		homeAddress = aLNPAddressBSchema.gethomeAddress();
		homeZipCode = aLNPAddressBSchema.gethomeZipCode();
		homePhone = aLNPAddressBSchema.gethomePhone();
		homeFax = aLNPAddressBSchema.gethomeFax();
		companyAddress = aLNPAddressBSchema.getcompanyAddress();
		companyZipCode = aLNPAddressBSchema.getcompanyZipCode();
		companyPhone = aLNPAddressBSchema.getcompanyPhone();
		companyFax = aLNPAddressBSchema.getcompanyFax();
		companyMail = aLNPAddressBSchema.getcompanyMail();
		mobile = aLNPAddressBSchema.getmobile();
		mobileChs = aLNPAddressBSchema.getmobileChs();
		eMail = aLNPAddressBSchema.geteMail();
		bP = aLNPAddressBSchema.getbP();
		mobile2 = aLNPAddressBSchema.getmobile2();
		mobileChs2 = aLNPAddressBSchema.getmobileChs2();
		eMail2 = aLNPAddressBSchema.geteMail2();
		bP2 = aLNPAddressBSchema.getbP2();
		operator = aLNPAddressBSchema.getoperator();
		makeDate = fDate.getDate(aLNPAddressBSchema.getmakeDate());
		makeTime = aLNPAddressBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPAddressBSchema.getmodifyDate());
		modifyTime = aLNPAddressBSchema.getmodifyTime();
		grpName = aLNPAddressBSchema.getgrpName();
		otherDuchy = aLNPAddressBSchema.getotherDuchy();
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
			if (rs.getString("customerId") == null)
				customerId = null;
			else
				customerId = rs.getString("customerId").trim();
			if (rs.getString("customerNo") == null)
				customerNo = null;
			else
				customerNo = rs.getString("customerNo").trim();
			if (rs.getString("addressNo") == null)
				addressNo = null;
			else
				addressNo = rs.getString("addressNo").trim();
			if (rs.getString("postalAddress") == null)
				postalAddress = null;
			else
				postalAddress = rs.getString("postalAddress").trim();
			if (rs.getString("zipCode") == null)
				zipCode = null;
			else
				zipCode = rs.getString("zipCode").trim();
			if (rs.getString("phone") == null)
				phone = null;
			else
				phone = rs.getString("phone").trim();
			if (rs.getString("fax") == null)
				fax = null;
			else
				fax = rs.getString("fax").trim();
			if (rs.getString("duchy") == null)
				duchy = null;
			else
				duchy = rs.getString("duchy").trim();
			if (rs.getString("homeAddress") == null)
				homeAddress = null;
			else
				homeAddress = rs.getString("homeAddress").trim();
			if (rs.getString("homeZipCode") == null)
				homeZipCode = null;
			else
				homeZipCode = rs.getString("homeZipCode").trim();
			if (rs.getString("homePhone") == null)
				homePhone = null;
			else
				homePhone = rs.getString("homePhone").trim();
			if (rs.getString("homeFax") == null)
				homeFax = null;
			else
				homeFax = rs.getString("homeFax").trim();
			if (rs.getString("companyAddress") == null)
				companyAddress = null;
			else
				companyAddress = rs.getString("companyAddress").trim();
			if (rs.getString("companyZipCode") == null)
				companyZipCode = null;
			else
				companyZipCode = rs.getString("companyZipCode").trim();
			if (rs.getString("companyPhone") == null)
				companyPhone = null;
			else
				companyPhone = rs.getString("companyPhone").trim();
			if (rs.getString("companyFax") == null)
				companyFax = null;
			else
				companyFax = rs.getString("companyFax").trim();
			if (rs.getString("companyMail") == null)
				companyMail = null;
			else
				companyMail = rs.getString("companyMail").trim();
			if (rs.getString("mobile") == null)
				mobile = null;
			else
				mobile = rs.getString("mobile").trim();
			if (rs.getString("mobileChs") == null)
				mobileChs = null;
			else
				mobileChs = rs.getString("mobileChs").trim();
			if (rs.getString("eMail") == null)
				eMail = null;
			else
				eMail = rs.getString("eMail").trim();
			if (rs.getString("bP") == null)
				bP = null;
			else
				bP = rs.getString("bP").trim();
			if (rs.getString("mobile2") == null)
				mobile2 = null;
			else
				mobile2 = rs.getString("mobile2").trim();
			if (rs.getString("mobileChs2") == null)
				mobileChs2 = null;
			else
				mobileChs2 = rs.getString("mobileChs2").trim();
			if (rs.getString("eMail2") == null)
				eMail2 = null;
			else
				eMail2 = rs.getString("eMail2").trim();
			if (rs.getString("bP2") == null)
				bP2 = null;
			else
				bP2 = rs.getString("bP2").trim();
			if (rs.getString("operator") == null)
				operator = null;
			else
				operator = rs.getString("operator").trim();
			makeDate = rs.getDate("makeDate");
			if (rs.getString("makeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("makeTime").trim();
			modifyDate = rs.getDate("modifyDate");
			if (rs.getString("modifyTime") == null)
				modifyTime = null;
			else
				modifyTime = rs.getString("modifyTime").trim();
			if (rs.getString("grpName") == null)
				grpName = null;
			else
				grpName = rs.getString("grpName").trim();
			if (rs.getString("otherDuchy") == null)
				otherDuchy = null;
			else
				otherDuchy = rs.getString("otherDuchy").trim();
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAddressBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPAddressBSchema getSchema()
	{
		LNPAddressBSchema aLNPAddressBSchema = new LNPAddressBSchema();
		aLNPAddressBSchema.setSchema(this);
		return aLNPAddressBSchema;
	}

	public LNPAddressBDB getDB()
	{
		LNPAddressBDB aDBOper = new LNPAddressBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(customerId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(customerNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(addressNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(postalAddress))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(zipCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(phone))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fax))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(duchy))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(homeAddress))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(homeZipCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(homePhone))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(homeFax))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(companyAddress))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(companyZipCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(companyPhone))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(companyFax))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(companyMail))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(mobile))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(mobileChs))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(eMail))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bP))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(mobile2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(mobileChs2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(eMail2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bP2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(otherDuchy))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			postalAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			zipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			fax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			duchy = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			homeAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			homeZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			homePhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			homeFax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			companyAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			companyZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			companyPhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			companyFax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			companyMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			mobile = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			mobileChs = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			bP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			mobile2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			mobileChs2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			eMail2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			bP2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			otherDuchy = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAddressBSchema";
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
		if (FCode.equals("customerId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerId));
		if (FCode.equals("customerNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerNo));
		if (FCode.equals("addressNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addressNo));
		if (FCode.equals("postalAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(postalAddress));
		if (FCode.equals("zipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(zipCode));
		if (FCode.equals("phone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(phone));
		if (FCode.equals("fax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fax));
		if (FCode.equals("duchy"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(duchy));
		if (FCode.equals("homeAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homeAddress));
		if (FCode.equals("homeZipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homeZipCode));
		if (FCode.equals("homePhone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homePhone));
		if (FCode.equals("homeFax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homeFax));
		if (FCode.equals("companyAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyAddress));
		if (FCode.equals("companyZipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyZipCode));
		if (FCode.equals("companyPhone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyPhone));
		if (FCode.equals("companyFax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyFax));
		if (FCode.equals("companyMail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(companyMail));
		if (FCode.equals("mobile"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mobile));
		if (FCode.equals("mobileChs"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mobileChs));
		if (FCode.equals("eMail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(eMail));
		if (FCode.equals("bP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bP));
		if (FCode.equals("mobile2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mobile2));
		if (FCode.equals("mobileChs2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mobileChs2));
		if (FCode.equals("eMail2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(eMail2));
		if (FCode.equals("bP2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bP2));
		if (FCode.equals("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equals("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
		if (FCode.equals("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equals("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
		if (FCode.equals("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
		if (FCode.equals("grpName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpName));
		if (FCode.equals("otherDuchy"))
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
			strFieldValue = StrTool.GBKToUnicode(EdorNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(serialNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(customerId);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(customerNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(addressNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(postalAddress);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(zipCode);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(phone);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(fax);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(duchy);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(homeAddress);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(homeZipCode);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(homePhone);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(homeFax);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(companyAddress);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(companyZipCode);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(companyPhone);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(companyFax);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(companyMail);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(mobile);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(mobileChs);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(eMail);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(bP);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(mobile2);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(mobileChs2);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(eMail2);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(bP2);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(grpName);
			break;

		case 33: // '!'
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
		if (FCode.equals("customerId"))
			if (FValue != null && !FValue.equals(""))
				customerId = FValue.trim();
			else
				customerId = null;
		if (FCode.equals("customerNo"))
			if (FValue != null && !FValue.equals(""))
				customerNo = FValue.trim();
			else
				customerNo = null;
		if (FCode.equals("addressNo"))
			if (FValue != null && !FValue.equals(""))
				addressNo = FValue.trim();
			else
				addressNo = null;
		if (FCode.equals("postalAddress"))
			if (FValue != null && !FValue.equals(""))
				postalAddress = FValue.trim();
			else
				postalAddress = null;
		if (FCode.equals("zipCode"))
			if (FValue != null && !FValue.equals(""))
				zipCode = FValue.trim();
			else
				zipCode = null;
		if (FCode.equals("phone"))
			if (FValue != null && !FValue.equals(""))
				phone = FValue.trim();
			else
				phone = null;
		if (FCode.equals("fax"))
			if (FValue != null && !FValue.equals(""))
				fax = FValue.trim();
			else
				fax = null;
		if (FCode.equals("duchy"))
			if (FValue != null && !FValue.equals(""))
				duchy = FValue.trim();
			else
				duchy = null;
		if (FCode.equals("homeAddress"))
			if (FValue != null && !FValue.equals(""))
				homeAddress = FValue.trim();
			else
				homeAddress = null;
		if (FCode.equals("homeZipCode"))
			if (FValue != null && !FValue.equals(""))
				homeZipCode = FValue.trim();
			else
				homeZipCode = null;
		if (FCode.equals("homePhone"))
			if (FValue != null && !FValue.equals(""))
				homePhone = FValue.trim();
			else
				homePhone = null;
		if (FCode.equals("homeFax"))
			if (FValue != null && !FValue.equals(""))
				homeFax = FValue.trim();
			else
				homeFax = null;
		if (FCode.equals("companyAddress"))
			if (FValue != null && !FValue.equals(""))
				companyAddress = FValue.trim();
			else
				companyAddress = null;
		if (FCode.equals("companyZipCode"))
			if (FValue != null && !FValue.equals(""))
				companyZipCode = FValue.trim();
			else
				companyZipCode = null;
		if (FCode.equals("companyPhone"))
			if (FValue != null && !FValue.equals(""))
				companyPhone = FValue.trim();
			else
				companyPhone = null;
		if (FCode.equals("companyFax"))
			if (FValue != null && !FValue.equals(""))
				companyFax = FValue.trim();
			else
				companyFax = null;
		if (FCode.equals("companyMail"))
			if (FValue != null && !FValue.equals(""))
				companyMail = FValue.trim();
			else
				companyMail = null;
		if (FCode.equals("mobile"))
			if (FValue != null && !FValue.equals(""))
				mobile = FValue.trim();
			else
				mobile = null;
		if (FCode.equals("mobileChs"))
			if (FValue != null && !FValue.equals(""))
				mobileChs = FValue.trim();
			else
				mobileChs = null;
		if (FCode.equals("eMail"))
			if (FValue != null && !FValue.equals(""))
				eMail = FValue.trim();
			else
				eMail = null;
		if (FCode.equals("bP"))
			if (FValue != null && !FValue.equals(""))
				bP = FValue.trim();
			else
				bP = null;
		if (FCode.equals("mobile2"))
			if (FValue != null && !FValue.equals(""))
				mobile2 = FValue.trim();
			else
				mobile2 = null;
		if (FCode.equals("mobileChs2"))
			if (FValue != null && !FValue.equals(""))
				mobileChs2 = FValue.trim();
			else
				mobileChs2 = null;
		if (FCode.equals("eMail2"))
			if (FValue != null && !FValue.equals(""))
				eMail2 = FValue.trim();
			else
				eMail2 = null;
		if (FCode.equals("bP2"))
			if (FValue != null && !FValue.equals(""))
				bP2 = FValue.trim();
			else
				bP2 = null;
		if (FCode.equals("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equals("makeDate"))
			if (FValue != null && !FValue.equals(""))
				makeDate = fDate.getDate(FValue);
			else
				makeDate = null;
		if (FCode.equals("makeTime"))
			if (FValue != null && !FValue.equals(""))
				makeTime = FValue.trim();
			else
				makeTime = null;
		if (FCode.equals("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equals("modifyTime"))
			if (FValue != null && !FValue.equals(""))
				modifyTime = FValue.trim();
			else
				modifyTime = null;
		if (FCode.equals("grpName"))
			if (FValue != null && !FValue.equals(""))
				grpName = FValue.trim();
			else
				grpName = null;
		if (FCode.equals("otherDuchy"))
			if (FValue != null && !FValue.equals(""))
				otherDuchy = FValue.trim();
			else
				otherDuchy = null;
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
		LNPAddressBSchema other = (LNPAddressBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && customerId.equals(other.getcustomerId()) && customerNo.equals(other.getcustomerNo()) && addressNo.equals(other.getaddressNo()) && postalAddress.equals(other.getpostalAddress()) && zipCode.equals(other.getzipCode()) && phone.equals(other.getphone()) && fax.equals(other.getfax()) && duchy.equals(other.getduchy()) && homeAddress.equals(other.gethomeAddress()) && homeZipCode.equals(other.gethomeZipCode()) && homePhone.equals(other.gethomePhone()) && homeFax.equals(other.gethomeFax()) && companyAddress.equals(other.getcompanyAddress()) && companyZipCode.equals(other.getcompanyZipCode()) && companyPhone.equals(other.getcompanyPhone()) && companyFax.equals(other.getcompanyFax()) && companyMail.equals(other.getcompanyMail()) && mobile.equals(other.getmobile()) && mobileChs.equals(other.getmobileChs()) && eMail.equals(other.geteMail()) && bP.equals(other.getbP()) && mobile2.equals(other.getmobile2()) && mobileChs2.equals(other.getmobileChs2()) && eMail2.equals(other.geteMail2()) && bP2.equals(other.getbP2()) && operator.equals(other.getoperator()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime()) && grpName.equals(other.getgrpName()) && otherDuchy.equals(other.getotherDuchy());
	}

	public int getFieldCount()
	{
		return 34;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("customerId"))
			return 2;
		if (strFieldName.equals("customerNo"))
			return 3;
		if (strFieldName.equals("addressNo"))
			return 4;
		if (strFieldName.equals("postalAddress"))
			return 5;
		if (strFieldName.equals("zipCode"))
			return 6;
		if (strFieldName.equals("phone"))
			return 7;
		if (strFieldName.equals("fax"))
			return 8;
		if (strFieldName.equals("duchy"))
			return 9;
		if (strFieldName.equals("homeAddress"))
			return 10;
		if (strFieldName.equals("homeZipCode"))
			return 11;
		if (strFieldName.equals("homePhone"))
			return 12;
		if (strFieldName.equals("homeFax"))
			return 13;
		if (strFieldName.equals("companyAddress"))
			return 14;
		if (strFieldName.equals("companyZipCode"))
			return 15;
		if (strFieldName.equals("companyPhone"))
			return 16;
		if (strFieldName.equals("companyFax"))
			return 17;
		if (strFieldName.equals("companyMail"))
			return 18;
		if (strFieldName.equals("mobile"))
			return 19;
		if (strFieldName.equals("mobileChs"))
			return 20;
		if (strFieldName.equals("eMail"))
			return 21;
		if (strFieldName.equals("bP"))
			return 22;
		if (strFieldName.equals("mobile2"))
			return 23;
		if (strFieldName.equals("mobileChs2"))
			return 24;
		if (strFieldName.equals("eMail2"))
			return 25;
		if (strFieldName.equals("bP2"))
			return 26;
		if (strFieldName.equals("operator"))
			return 27;
		if (strFieldName.equals("makeDate"))
			return 28;
		if (strFieldName.equals("makeTime"))
			return 29;
		if (strFieldName.equals("modifyDate"))
			return 30;
		if (strFieldName.equals("modifyTime"))
			return 31;
		if (strFieldName.equals("grpName"))
			return 32;
		return !strFieldName.equals("otherDuchy") ? -1 : 33;
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
			strFieldName = "customerId";
			break;

		case 3: // '\003'
			strFieldName = "customerNo";
			break;

		case 4: // '\004'
			strFieldName = "addressNo";
			break;

		case 5: // '\005'
			strFieldName = "postalAddress";
			break;

		case 6: // '\006'
			strFieldName = "zipCode";
			break;

		case 7: // '\007'
			strFieldName = "phone";
			break;

		case 8: // '\b'
			strFieldName = "fax";
			break;

		case 9: // '\t'
			strFieldName = "duchy";
			break;

		case 10: // '\n'
			strFieldName = "homeAddress";
			break;

		case 11: // '\013'
			strFieldName = "homeZipCode";
			break;

		case 12: // '\f'
			strFieldName = "homePhone";
			break;

		case 13: // '\r'
			strFieldName = "homeFax";
			break;

		case 14: // '\016'
			strFieldName = "companyAddress";
			break;

		case 15: // '\017'
			strFieldName = "companyZipCode";
			break;

		case 16: // '\020'
			strFieldName = "companyPhone";
			break;

		case 17: // '\021'
			strFieldName = "companyFax";
			break;

		case 18: // '\022'
			strFieldName = "companyMail";
			break;

		case 19: // '\023'
			strFieldName = "mobile";
			break;

		case 20: // '\024'
			strFieldName = "mobileChs";
			break;

		case 21: // '\025'
			strFieldName = "eMail";
			break;

		case 22: // '\026'
			strFieldName = "bP";
			break;

		case 23: // '\027'
			strFieldName = "mobile2";
			break;

		case 24: // '\030'
			strFieldName = "mobileChs2";
			break;

		case 25: // '\031'
			strFieldName = "eMail2";
			break;

		case 26: // '\032'
			strFieldName = "bP2";
			break;

		case 27: // '\033'
			strFieldName = "operator";
			break;

		case 28: // '\034'
			strFieldName = "makeDate";
			break;

		case 29: // '\035'
			strFieldName = "makeTime";
			break;

		case 30: // '\036'
			strFieldName = "modifyDate";
			break;

		case 31: // '\037'
			strFieldName = "modifyTime";
			break;

		case 32: // ' '
			strFieldName = "grpName";
			break;

		case 33: // '!'
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
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 0;
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
			nFieldType = 0;
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
			nFieldType = 1;
			break;

		case 31: // '\037'
			nFieldType = 0;
			break;

		case 32: // ' '
			nFieldType = 0;
			break;

		case 33: // '!'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
