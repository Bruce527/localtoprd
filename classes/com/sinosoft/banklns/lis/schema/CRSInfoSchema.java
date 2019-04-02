// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CRSInfoSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.CRSInfoDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRSInfoSchema
	implements Schema
{

	private String contNo;
	private String customerName;
	private String taxResidentType;
	private String firstName;
	private String lastName;
	private String birthday;
	private String currentAddress_Country;
	private String currentAddress_Province;
	private String currentAddress_City;
	private String currentAddress_Detail;
	private String currentAddress_Country_en;
	private String currentAddress_Province_en;
	private String currentAddress_City_en;
	private String currentAddress_Detail_en;
	private String birthAddress_Country;
	private String birthAddress_Province;
	private String birthAddress_City;
	private String birthAddress_Detail;
	private String birthAddress_Country_en;
	private String birthAddress_Province_en;
	private String birthAddress_City_en;
	private String birthAddress_Detail_en;
	private String taxResidentCountry1;
	private String taxpayerCode1;
	private String taxResidentCountry2;
	private String taxpayerCode2;
	private String taxResidentCountry3;
	private String taxpayerCode3;
	private String noTaxpayercodeReason;
	private String reasonDescription;
	private String sourceType;
	public static final int FIELDNUM = 31;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getTaxResidentType()
	{
		return taxResidentType;
	}

	public void setTaxResidentType(String taxResidentType)
	{
		this.taxResidentType = taxResidentType;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getCurrentAddress_Country()
	{
		return currentAddress_Country;
	}

	public void setCurrentAddress_Country(String currentAddress_Country)
	{
		this.currentAddress_Country = currentAddress_Country;
	}

	public String getCurrentAddress_Province()
	{
		return currentAddress_Province;
	}

	public void setCurrentAddress_Province(String currentAddress_Province)
	{
		this.currentAddress_Province = currentAddress_Province;
	}

	public String getCurrentAddress_City()
	{
		return currentAddress_City;
	}

	public void setCurrentAddress_City(String currentAddress_City)
	{
		this.currentAddress_City = currentAddress_City;
	}

	public String getCurrentAddress_Detail()
	{
		return currentAddress_Detail;
	}

	public void setCurrentAddress_Detail(String currentAddress_Detail)
	{
		this.currentAddress_Detail = currentAddress_Detail;
	}

	public String getCurrentAddress_Province_en()
	{
		return currentAddress_Province_en;
	}

	public void setCurrentAddress_Province_en(String currentAddress_Province_en)
	{
		this.currentAddress_Province_en = currentAddress_Province_en;
	}

	public String getCurrentAddress_City_en()
	{
		return currentAddress_City_en;
	}

	public void setCurrentAddress_City_en(String currentAddress_City_en)
	{
		this.currentAddress_City_en = currentAddress_City_en;
	}

	public String getCurrentAddress_Detail_en()
	{
		return currentAddress_Detail_en;
	}

	public void setCurrentAddress_Detail_en(String currentAddress_Detail_en)
	{
		this.currentAddress_Detail_en = currentAddress_Detail_en;
	}

	public String getBirthAddress_Country()
	{
		return birthAddress_Country;
	}

	public void setBirthAddress_Country(String birthAddress_Country)
	{
		this.birthAddress_Country = birthAddress_Country;
	}

	public String getBirthAddress_Province()
	{
		return birthAddress_Province;
	}

	public void setBirthAddress_Province(String birthAddress_Province)
	{
		this.birthAddress_Province = birthAddress_Province;
	}

	public String getBirthAddress_City()
	{
		return birthAddress_City;
	}

	public void setBirthAddress_City(String birthAddress_City)
	{
		this.birthAddress_City = birthAddress_City;
	}

	public String getBirthAddress_Detail()
	{
		return birthAddress_Detail;
	}

	public void setBirthAddress_Detail(String birthAddress_Detail)
	{
		this.birthAddress_Detail = birthAddress_Detail;
	}

	public String getBirthAddress_Province_en()
	{
		return birthAddress_Province_en;
	}

	public void setBirthAddress_Province_en(String birthAddress_Province_en)
	{
		this.birthAddress_Province_en = birthAddress_Province_en;
	}

	public String getBirthAddress_City_en()
	{
		return birthAddress_City_en;
	}

	public void setBirthAddress_City_en(String birthAddress_City_en)
	{
		this.birthAddress_City_en = birthAddress_City_en;
	}

	public String getBirthAddress_Detail_en()
	{
		return birthAddress_Detail_en;
	}

	public void setBirthAddress_Detail_en(String birthAddress_Detail_en)
	{
		this.birthAddress_Detail_en = birthAddress_Detail_en;
	}

	public String getTaxResidentCountry1()
	{
		return taxResidentCountry1;
	}

	public void setTaxResidentCountry1(String taxResidentCountry1)
	{
		this.taxResidentCountry1 = taxResidentCountry1;
	}

	public String getTaxpayerCode1()
	{
		return taxpayerCode1;
	}

	public void setTaxpayerCode1(String taxpayerCode1)
	{
		this.taxpayerCode1 = taxpayerCode1;
	}

	public String getTaxResidentCountry2()
	{
		return taxResidentCountry2;
	}

	public void setTaxResidentCountry2(String taxResidentCountry2)
	{
		this.taxResidentCountry2 = taxResidentCountry2;
	}

	public String getTaxpayerCode2()
	{
		return taxpayerCode2;
	}

	public void setTaxpayerCode2(String taxpayerCode2)
	{
		this.taxpayerCode2 = taxpayerCode2;
	}

	public String getTaxResidentCountry3()
	{
		return taxResidentCountry3;
	}

	public void setTaxResidentCountry3(String taxResidentCountry3)
	{
		this.taxResidentCountry3 = taxResidentCountry3;
	}

	public String getTaxpayerCode3()
	{
		return taxpayerCode3;
	}

	public void setTaxpayerCode3(String taxpayerCode3)
	{
		this.taxpayerCode3 = taxpayerCode3;
	}

	public String getNoTaxpayercodeReason()
	{
		return noTaxpayercodeReason;
	}

	public void setNoTaxpayercodeReason(String noTaxpayercodeReason)
	{
		this.noTaxpayercodeReason = noTaxpayercodeReason;
	}

	public String getReasonDescription()
	{
		return reasonDescription;
	}

	public void setReasonDescription(String reasonDescription)
	{
		this.reasonDescription = reasonDescription;
	}

	public String getSourceType()
	{
		return sourceType;
	}

	public void setSourceType(String sourceType)
	{
		this.sourceType = sourceType;
	}

	public void setSchema(CRSInfoSchema aCRSInfoSchema)
	{
		birthAddress_City = aCRSInfoSchema.getBirthAddress_City();
		birthAddress_City_en = aCRSInfoSchema.getBirthAddress_City_en();
		birthAddress_Country = aCRSInfoSchema.getBirthAddress_Country();
		birthAddress_Detail = aCRSInfoSchema.getBirthAddress_Detail();
		birthAddress_Detail_en = aCRSInfoSchema.getBirthAddress_Detail_en();
		birthAddress_Province = aCRSInfoSchema.getBirthAddress_Province();
		birthAddress_Province_en = aCRSInfoSchema.getBirthAddress_Province_en();
		birthday = aCRSInfoSchema.getBirthday();
		currentAddress_City = aCRSInfoSchema.getCurrentAddress_City();
		currentAddress_City_en = aCRSInfoSchema.getCurrentAddress_City_en();
		currentAddress_Country = aCRSInfoSchema.getCurrentAddress_Country();
		currentAddress_Detail = aCRSInfoSchema.getCurrentAddress_Detail();
		currentAddress_Detail_en = aCRSInfoSchema.getCurrentAddress_Detail_en();
		currentAddress_Province = aCRSInfoSchema.getCurrentAddress_Province();
		currentAddress_Province_en = aCRSInfoSchema.getCurrentAddress_Province_en();
		customerName = aCRSInfoSchema.getCustomerName();
		firstName = aCRSInfoSchema.getFirstName();
		lastName = aCRSInfoSchema.getLastName();
		noTaxpayercodeReason = aCRSInfoSchema.getNoTaxpayercodeReason();
		sourceType = aCRSInfoSchema.getSourceType();
		taxpayerCode1 = aCRSInfoSchema.getTaxpayerCode1();
		taxpayerCode2 = aCRSInfoSchema.getTaxpayerCode2();
		taxpayerCode3 = aCRSInfoSchema.getTaxpayerCode3();
		taxResidentCountry1 = aCRSInfoSchema.getTaxResidentCountry1();
		taxResidentCountry2 = aCRSInfoSchema.getTaxResidentCountry2();
		taxResidentCountry3 = aCRSInfoSchema.getTaxResidentCountry3();
		taxResidentType = aCRSInfoSchema.getTaxResidentType();
		contNo = aCRSInfoSchema.getContNo();
		currentAddress_Country_en = aCRSInfoSchema.getCurrentAddress_Country_en();
		birthAddress_Country_en = aCRSInfoSchema.getBirthAddress_Country_en();
		reasonDescription = aCRSInfoSchema.getReasonDescription();
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
	}

	public String getBirthAddress_Country_en()
	{
		return birthAddress_Country_en;
	}

	public void setBirthAddress_Country_en(String birthAddress_Country_en)
	{
		this.birthAddress_Country_en = birthAddress_Country_en;
	}

	public String getCurrentAddress_Country_en()
	{
		return currentAddress_Country_en;
	}

	public void setCurrentAddress_Country_en(String currentAddress_Country_en)
	{
		this.currentAddress_Country_en = currentAddress_Country_en;
	}

	public CRSInfoSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "contNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		CRSInfoSchema cloned = (CRSInfoSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ContNo") == null)
				contNo = null;
			else
				contNo = rs.getString("ContNo").trim();
			if (rs.getString("CustomerName") == null)
				customerName = null;
			else
				customerName = rs.getString("CustomerName").trim();
			if (rs.getString("taxResidentType") == null)
				taxResidentType = null;
			else
				taxResidentType = rs.getString("taxResidentType").trim();
			if (rs.getString("firstName") == null)
				firstName = null;
			else
				firstName = rs.getString("firstName").trim();
			if (rs.getString("lastName") == null)
				lastName = null;
			else
				lastName = rs.getString("lastName").trim();
			if (rs.getString("birthday") == null)
				birthday = null;
			else
				birthday = rs.getString("birthday").trim();
			if (rs.getString("currentAddress_Country") == null)
				currentAddress_Country = null;
			else
				currentAddress_Country = rs.getString("currentAddress_Country").trim();
			if (rs.getString("currentAddress_Province") == null)
				currentAddress_Province = null;
			else
				currentAddress_Province = rs.getString("currentAddress_Province").trim();
			if (rs.getString("currentAddress_City") == null)
				currentAddress_City = null;
			else
				currentAddress_City = rs.getString("currentAddress_City").trim();
			if (rs.getString("currentAddress_Detail") == null)
				currentAddress_Detail = null;
			else
				currentAddress_Detail = rs.getString("currentAddress_Detail").trim();
			if (rs.getString("currentAddress_Country_en") == null)
				currentAddress_Country_en = null;
			else
				currentAddress_Country_en = rs.getString("currentAddress_Country_en").trim();
			if (rs.getString("currentAddress_Province_en") == null)
				currentAddress_Province_en = null;
			else
				currentAddress_Province_en = rs.getString("currentAddress_Province_en").trim();
			if (rs.getString("currentAddress_City_en") == null)
				currentAddress_City_en = null;
			else
				currentAddress_City_en = rs.getString("currentAddress_City_en").trim();
			if (rs.getString("currentAddress_Detail_en") == null)
				currentAddress_Detail_en = null;
			else
				currentAddress_Detail_en = rs.getString("currentAddress_Detail_en").trim();
			if (rs.getString("birthAddress_Country") == null)
				birthAddress_Country = null;
			else
				birthAddress_Country = rs.getString("birthAddress_Country").trim();
			if (rs.getString("birthAddress_Province") == null)
				birthAddress_Province = null;
			else
				birthAddress_Province = rs.getString("birthAddress_Province").trim();
			if (rs.getString("birthAddress_City") == null)
				birthAddress_City = null;
			else
				birthAddress_City = rs.getString("birthAddress_City").trim();
			if (rs.getString("birthAddress_Detail") == null)
				birthAddress_Detail = null;
			else
				birthAddress_Detail = rs.getString("birthAddress_Detail").trim();
			if (rs.getString("birthAddress_Country_en") == null)
				birthAddress_Country_en = null;
			else
				birthAddress_Country_en = rs.getString("birthAddress_Country_en").trim();
			if (rs.getString("birthAddress_Province_en") == null)
				birthAddress_Province_en = null;
			else
				birthAddress_Province_en = rs.getString("birthAddress_Province_en").trim();
			if (rs.getString("birthAddress_City_en") == null)
				birthAddress_City_en = null;
			else
				birthAddress_City_en = rs.getString("birthAddress_City_en").trim();
			if (rs.getString("birthAddress_Detail_en") == null)
				birthAddress_Detail_en = null;
			else
				birthAddress_Detail_en = rs.getString("birthAddress_Detail_en").trim();
			if (rs.getString("taxResidentCountry1") == null)
				taxResidentCountry1 = null;
			else
				taxResidentCountry1 = rs.getString("taxResidentCountry1").trim();
			if (rs.getString("taxpayerCode1") == null)
				taxpayerCode1 = null;
			else
				taxpayerCode1 = rs.getString("taxpayerCode1").trim();
			if (rs.getString("taxResidentCountry2") == null)
				taxResidentCountry2 = null;
			else
				taxResidentCountry2 = rs.getString("taxResidentCountry2").trim();
			if (rs.getString("taxpayerCode2") == null)
				taxpayerCode2 = null;
			else
				taxpayerCode2 = rs.getString("taxpayerCode2").trim();
			if (rs.getString("taxResidentCountry3") == null)
				taxResidentCountry3 = null;
			else
				taxResidentCountry3 = rs.getString("taxResidentCountry3").trim();
			if (rs.getString("taxpayerCode3") == null)
				taxpayerCode3 = null;
			else
				taxpayerCode3 = rs.getString("taxpayerCode3").trim();
			if (rs.getString("noTaxpayercodeReason") == null)
				noTaxpayercodeReason = null;
			else
				noTaxpayercodeReason = rs.getString("noTaxpayercodeReason").trim();
			if (rs.getString("reasonDescription") == null)
				reasonDescription = null;
			else
				reasonDescription = rs.getString("reasonDescription").trim();
			if (rs.getString("sourceType") == null)
				sourceType = null;
			else
				sourceType = rs.getString("sourceType").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的CRSInfo表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "CRSInfoSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public CRSInfoSchema getSchema()
	{
		CRSInfoSchema aCRSInfoSchema = new CRSInfoSchema();
		aCRSInfoSchema.setSchema(this);
		return aCRSInfoSchema;
	}

	public CRSInfoDB getDB()
	{
		CRSInfoDB cDBOper = new CRSInfoDB();
		cDBOper.setSchema(this);
		return cDBOper;
	}

	public String getV(String FCode)
	{
		String strReturn = "";
		if (FCode.equalsIgnoreCase("ContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equalsIgnoreCase("CustomerName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerName));
		if (FCode.equalsIgnoreCase("taxResidentType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(taxResidentType));
		if (FCode.equalsIgnoreCase("taxResidentType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(taxResidentType));
		if (FCode.equalsIgnoreCase("lastName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lastName));
		if (FCode.equalsIgnoreCase("birthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthday));
		if (FCode.equalsIgnoreCase("currentAddress_Country"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currentAddress_Country));
		if (FCode.equalsIgnoreCase("currentAddress_Province"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currentAddress_Province));
		if (FCode.equalsIgnoreCase("currentAddress_City"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currentAddress_City));
		if (FCode.equalsIgnoreCase("currentAddress_Detail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currentAddress_Detail));
		if (FCode.equalsIgnoreCase("currentAddress_Country_en"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currentAddress_Country_en));
		if (FCode.equalsIgnoreCase("currentAddress_Province_en"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currentAddress_Province_en));
		if (FCode.equalsIgnoreCase("currentAddress_City_en"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currentAddress_City_en));
		if (FCode.equalsIgnoreCase("currentAddress_Detail_en"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(currentAddress_Detail_en));
		if (FCode.equalsIgnoreCase("birthAddress_Country"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthAddress_Country));
		if (FCode.equalsIgnoreCase("birthAddress_Province"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthAddress_Province));
		if (FCode.equalsIgnoreCase("birthAddress_City"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthAddress_City));
		if (FCode.equalsIgnoreCase("birthAddress_Detail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthAddress_Detail));
		if (FCode.equalsIgnoreCase("birthAddress_Country_en"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthAddress_Country_en));
		if (FCode.equalsIgnoreCase("birthAddress_Province_en"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthAddress_Province_en));
		if (FCode.equalsIgnoreCase("birthAddress_City_en"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthAddress_City_en));
		if (FCode.equalsIgnoreCase("birthAddress_Detail_en"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthAddress_Detail_en));
		if (FCode.equalsIgnoreCase("taxResidentCountry1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(taxResidentCountry1));
		if (FCode.equalsIgnoreCase("taxpayerCode1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(taxpayerCode1));
		if (FCode.equalsIgnoreCase("taxResidentCountry2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(taxResidentCountry2));
		if (FCode.equalsIgnoreCase("taxpayerCode2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(taxpayerCode2));
		if (FCode.equalsIgnoreCase("taxResidentCountry3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(taxResidentCountry3));
		if (FCode.equalsIgnoreCase("taxpayerCode3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(taxpayerCode3));
		if (FCode.equalsIgnoreCase("noTaxpayercodeReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(noTaxpayercodeReason));
		if (FCode.equalsIgnoreCase("reasonDescription"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(reasonDescription));
		if (FCode.equalsIgnoreCase("sourceType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sourceType));
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
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(customerName);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(taxResidentType);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(firstName);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(lastName);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(birthday);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(currentAddress_Country);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(currentAddress_Province);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(currentAddress_City);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(currentAddress_Detail);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(currentAddress_Country_en);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(currentAddress_Province_en);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(currentAddress_City_en);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(currentAddress_Detail_en);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(birthAddress_Country);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(birthAddress_Province);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(birthAddress_City);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(birthAddress_Detail);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(birthAddress_Country_en);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(birthAddress_Province_en);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(birthAddress_City_en);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(birthAddress_Detail_en);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(taxResidentCountry1);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(taxpayerCode1);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(taxResidentCountry2);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(taxpayerCode2);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(taxResidentCountry3);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(taxpayerCode3);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(noTaxpayercodeReason);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(reasonDescription);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(sourceType);
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
		if (FCode.equalsIgnoreCase("ContNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equalsIgnoreCase("CustomerName"))
			if (FValue != null && !FValue.equals(""))
				customerName = FValue.trim();
			else
				customerName = null;
		if (FCode.equalsIgnoreCase("taxResidentType"))
			if (FValue != null && !FValue.equals(""))
				taxResidentType = FValue.trim();
			else
				taxResidentType = null;
		if (FCode.equalsIgnoreCase("firstName"))
			if (FValue != null && !FValue.equals(""))
				firstName = FValue.trim();
			else
				firstName = null;
		if (FCode.equalsIgnoreCase("lastName"))
			if (FValue != null && !FValue.equals(""))
				lastName = FValue.trim();
			else
				lastName = null;
		if (FCode.equalsIgnoreCase("birthday"))
			if (FValue != null && !FValue.equals(""))
				birthday = FValue.trim();
			else
				birthday = null;
		if (FCode.equalsIgnoreCase("currentAddress_Country"))
			if (FValue != null && !FValue.equals(""))
				currentAddress_Country = FValue.trim();
			else
				currentAddress_Country = null;
		if (FCode.equalsIgnoreCase("currentAddress_Province"))
			if (FValue != null && !FValue.equals(""))
				currentAddress_Province = FValue.trim();
			else
				currentAddress_Province = null;
		if (FCode.equalsIgnoreCase("currentAddress_City"))
			if (FValue != null && !FValue.equals(""))
				currentAddress_City = FValue.trim();
			else
				currentAddress_City = null;
		if (FCode.equalsIgnoreCase("currentAddress_Detail"))
			if (FValue != null && !FValue.equals(""))
				currentAddress_Detail = FValue.trim();
			else
				currentAddress_Detail = null;
		if (FCode.equalsIgnoreCase("currentAddress_Country_en"))
			if (FValue != null && !FValue.equals(""))
				currentAddress_Country_en = FValue.trim();
			else
				currentAddress_Country_en = null;
		if (FCode.equalsIgnoreCase("currentAddress_Province_en"))
			if (FValue != null && !FValue.equals(""))
				currentAddress_Province_en = FValue.trim();
			else
				currentAddress_Province_en = null;
		if (FCode.equalsIgnoreCase("currentAddress_City_en"))
			if (FValue != null && !FValue.equals(""))
				currentAddress_Detail_en = FValue.trim();
			else
				currentAddress_Detail_en = null;
		if (FCode.equalsIgnoreCase("birthAddress_Country"))
			if (FValue != null && !FValue.equals(""))
				birthAddress_Country = FValue.trim();
			else
				birthAddress_Country = null;
		if (FCode.equalsIgnoreCase("CustomerName"))
			if (FValue != null && !FValue.equals(""))
				customerName = FValue.trim();
			else
				customerName = null;
		if (FCode.equalsIgnoreCase("birthAddress_Province"))
			if (FValue != null && !FValue.equals(""))
				birthAddress_Province = FValue.trim();
			else
				birthAddress_Province = null;
		if (FCode.equalsIgnoreCase("birthAddress_City"))
			if (FValue != null && !FValue.equals(""))
				birthAddress_City = FValue.trim();
			else
				birthAddress_City = null;
		if (FCode.equalsIgnoreCase("birthAddress_Detail"))
			if (FValue != null && !FValue.equals(""))
				birthAddress_Detail = FValue.trim();
			else
				birthAddress_Detail = null;
		if (FCode.equalsIgnoreCase("birthAddress_Country_en"))
			if (FValue != null && !FValue.equals(""))
				birthAddress_Country_en = FValue.trim();
			else
				birthAddress_Country_en = null;
		if (FCode.equalsIgnoreCase("birthAddress_Province_en"))
			if (FValue != null && !FValue.equals(""))
				birthAddress_Province_en = FValue.trim();
			else
				birthAddress_Province_en = null;
		if (FCode.equalsIgnoreCase("birthAddress_City_en"))
			if (FValue != null && !FValue.equals(""))
				birthAddress_City_en = FValue.trim();
			else
				birthAddress_City_en = null;
		if (FCode.equalsIgnoreCase("birthAddress_Detail_en"))
			if (FValue != null && !FValue.equals(""))
				birthAddress_Detail_en = FValue.trim();
			else
				birthAddress_Detail_en = null;
		if (FCode.equalsIgnoreCase("taxResidentCountry1"))
			if (FValue != null && !FValue.equals(""))
				taxResidentCountry1 = FValue.trim();
			else
				taxResidentCountry1 = null;
		if (FCode.equalsIgnoreCase("taxpayerCode1"))
			if (FValue != null && !FValue.equals(""))
				taxpayerCode1 = FValue.trim();
			else
				taxpayerCode1 = null;
		if (FCode.equalsIgnoreCase("taxResidentCountry2"))
			if (FValue != null && !FValue.equals(""))
				taxResidentCountry2 = FValue.trim();
			else
				taxResidentCountry2 = null;
		if (FCode.equalsIgnoreCase("taxpayerCode2"))
			if (FValue != null && !FValue.equals(""))
				taxpayerCode2 = FValue.trim();
			else
				taxpayerCode2 = null;
		if (FCode.equalsIgnoreCase("taxResidentCountry3"))
			if (FValue != null && !FValue.equals(""))
				taxResidentCountry3 = FValue.trim();
			else
				taxResidentCountry3 = null;
		if (FCode.equalsIgnoreCase("taxpayerCode3"))
			if (FValue != null && !FValue.equals(""))
				taxpayerCode3 = FValue.trim();
			else
				taxpayerCode3 = null;
		if (FCode.equalsIgnoreCase("noTaxpayercodeReason"))
			if (FValue != null && !FValue.equals(""))
				noTaxpayercodeReason = FValue.trim();
			else
				noTaxpayercodeReason = null;
		if (FCode.equalsIgnoreCase("reasonDescription"))
			if (FValue != null && !FValue.equals(""))
				reasonDescription = FValue.trim();
			else
				reasonDescription = null;
		if (FCode.equalsIgnoreCase("sourceType"))
			if (FValue != null && !FValue.equals(""))
				sourceType = FValue.trim();
			else
				sourceType = null;
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
		CRSInfoSchema other = (CRSInfoSchema)otherObject;
		if (contNo == null && other.getContNo() != null)
			return false;
		if (contNo != null && !contNo.equals(other.getContNo()))
			return false;
		if (customerName == null && other.getContNo() != null)
			return false;
		if (customerName != null && !customerName.equals(other.getContNo()))
			return false;
		if (taxResidentType == null && other.getContNo() != null)
			return false;
		if (taxResidentType != null && !taxResidentType.equals(other.getContNo()))
			return false;
		if (firstName == null && other.getContNo() != null)
			return false;
		if (firstName != null && !firstName.equals(other.getContNo()))
			return false;
		if (lastName == null && other.getContNo() != null)
			return false;
		if (lastName != null && !lastName.equals(other.getContNo()))
			return false;
		if (birthday == null && other.getContNo() != null)
			return false;
		if (birthday != null && !birthday.equals(other.getContNo()))
			return false;
		if (currentAddress_Country == null && other.getContNo() != null)
			return false;
		if (currentAddress_Country != null && !currentAddress_Country.equals(other.getContNo()))
			return false;
		if (currentAddress_Province == null && other.getContNo() != null)
			return false;
		if (currentAddress_Province != null && !currentAddress_Province.equals(other.getContNo()))
			return false;
		if (currentAddress_City == null && other.getContNo() != null)
			return false;
		if (currentAddress_City != null && !currentAddress_City.equals(other.getContNo()))
			return false;
		if (currentAddress_Detail == null && other.getContNo() != null)
			return false;
		if (currentAddress_Detail != null && !currentAddress_Detail.equals(other.getContNo()))
			return false;
		if (currentAddress_Country_en == null && other.getContNo() != null)
			return false;
		if (currentAddress_Country_en != null && !currentAddress_Country_en.equals(other.getContNo()))
			return false;
		if (currentAddress_Province_en == null && other.getContNo() != null)
			return false;
		if (currentAddress_Province_en != null && !currentAddress_Province_en.equals(other.getContNo()))
			return false;
		if (currentAddress_City_en == null && other.getContNo() != null)
			return false;
		if (currentAddress_City_en != null && !currentAddress_City_en.equals(other.getContNo()))
			return false;
		if (currentAddress_Detail_en == null && other.getContNo() != null)
			return false;
		if (currentAddress_Detail_en != null && !currentAddress_Detail_en.equals(other.getContNo()))
			return false;
		if (birthAddress_Country == null && other.getContNo() != null)
			return false;
		if (birthAddress_Country != null && !birthAddress_Country.equals(other.getContNo()))
			return false;
		if (birthAddress_Province == null && other.getContNo() != null)
			return false;
		if (birthAddress_Province != null && !birthAddress_Province.equals(other.getContNo()))
			return false;
		if (birthAddress_City == null && other.getContNo() != null)
			return false;
		if (birthAddress_City != null && !birthAddress_City.equals(other.getContNo()))
			return false;
		if (birthAddress_Detail == null && other.getContNo() != null)
			return false;
		if (birthAddress_Detail != null && !birthAddress_Detail.equals(other.getContNo()))
			return false;
		if (birthAddress_Country_en == null && other.getContNo() != null)
			return false;
		if (birthAddress_Country_en != null && !birthAddress_Country_en.equals(other.getContNo()))
			return false;
		if (birthAddress_Province_en == null && other.getContNo() != null)
			return false;
		if (birthAddress_Province_en != null && !birthAddress_Province_en.equals(other.getContNo()))
			return false;
		if (birthAddress_City_en == null && other.getContNo() != null)
			return false;
		if (birthAddress_City_en != null && !birthAddress_City_en.equals(other.getContNo()))
			return false;
		if (birthAddress_Detail_en == null && other.getContNo() != null)
			return false;
		if (birthAddress_Detail_en != null && !birthAddress_Detail_en.equals(other.getContNo()))
			return false;
		if (taxResidentCountry1 == null && other.getContNo() != null)
			return false;
		if (taxResidentCountry1 != null && !taxResidentCountry1.equals(other.getContNo()))
			return false;
		if (taxpayerCode1 == null && other.getContNo() != null)
			return false;
		if (taxpayerCode1 != null && !taxpayerCode1.equals(other.getContNo()))
			return false;
		if (taxResidentCountry2 == null && other.getContNo() != null)
			return false;
		if (taxResidentCountry2 != null && !taxResidentCountry2.equals(other.getContNo()))
			return false;
		if (taxpayerCode2 == null && other.getContNo() != null)
			return false;
		if (taxpayerCode2 != null && !taxpayerCode2.equals(other.getContNo()))
			return false;
		if (taxResidentCountry3 == null && other.getContNo() != null)
			return false;
		if (taxResidentCountry3 != null && !taxResidentCountry3.equals(other.getContNo()))
			return false;
		if (taxpayerCode3 == null && other.getContNo() != null)
			return false;
		if (taxpayerCode3 != null && !taxpayerCode3.equals(other.getContNo()))
			return false;
		if (noTaxpayercodeReason == null && other.getContNo() != null)
			return false;
		if (noTaxpayercodeReason != null && !noTaxpayercodeReason.equals(other.getContNo()))
			return false;
		if (reasonDescription == null && other.getContNo() != null)
			return false;
		if (reasonDescription != null && !reasonDescription.equals(other.getContNo()))
			return false;
		if (sourceType == null && other.getContNo() != null)
			return false;
		return sourceType == null || sourceType.equals(other.getContNo());
	}

	public int getFieldCount()
	{
		return 31;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("CustomerName"))
			return 1;
		if (strFieldName.equals("taxResidentType"))
			return 2;
		if (strFieldName.equals("firstName"))
			return 3;
		if (strFieldName.equals("lastName"))
			return 4;
		if (strFieldName.equals("birthday"))
			return 5;
		if (strFieldName.equals("currentAddress_Country"))
			return 6;
		if (strFieldName.equals("currentAddress_Province"))
			return 7;
		if (strFieldName.equals("currentAddress_City"))
			return 8;
		if (strFieldName.equals("currentAddress_Detail"))
			return 9;
		if (strFieldName.equals("currentAddress_Country_en"))
			return 10;
		if (strFieldName.equals("currentAddress_Province_en"))
			return 11;
		if (strFieldName.equals("currentAddress_City_en"))
			return 12;
		if (strFieldName.equals("currentAddress_Detail_en"))
			return 13;
		if (strFieldName.equals("birthAddress_Country"))
			return 14;
		if (strFieldName.equals("birthAddress_Province"))
			return 15;
		if (strFieldName.equals("birthAddress_City"))
			return 16;
		if (strFieldName.equals("birthAddress_Detail"))
			return 17;
		if (strFieldName.equals("birthAddress_Country_en"))
			return 18;
		if (strFieldName.equals("birthAddress_Province_en"))
			return 19;
		if (strFieldName.equals("birthAddress_City_en"))
			return 20;
		if (strFieldName.equals("birthAddress_Detail_en"))
			return 21;
		if (strFieldName.equals("taxResidentCountry1"))
			return 22;
		if (strFieldName.equals("taxpayerCode1"))
			return 23;
		if (strFieldName.equals("taxResidentCountry2"))
			return 24;
		if (strFieldName.equals("taxpayerCode2"))
			return 25;
		if (strFieldName.equals("taxResidentCountry3"))
			return 26;
		if (strFieldName.equals("taxpayerCode3"))
			return 27;
		if (strFieldName.equals("noTaxpayercodeReason"))
			return 28;
		if (strFieldName.equals("reasonDescription"))
			return 29;
		return !strFieldName.equals("sourceType") ? -1 : 30;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "contNo";
			break;

		case 1: // '\001'
			strFieldName = "customerName";
			break;

		case 2: // '\002'
			strFieldName = "taxResidentType";
			break;

		case 3: // '\003'
			strFieldName = "firstName";
			break;

		case 4: // '\004'
			strFieldName = "lastName";
			break;

		case 5: // '\005'
			strFieldName = "birthday";
			break;

		case 6: // '\006'
			strFieldName = "currentAddress_Country";
			break;

		case 7: // '\007'
			strFieldName = "currentAddress_Province";
			break;

		case 8: // '\b'
			strFieldName = "currentAddress_City";
			break;

		case 9: // '\t'
			strFieldName = "currentAddress_Detail";
			break;

		case 10: // '\n'
			strFieldName = "currentAddress_Country_en";
			break;

		case 11: // '\013'
			strFieldName = "currentAddress_Province_en";
			break;

		case 12: // '\f'
			strFieldName = "currentAddress_City_en";
			break;

		case 13: // '\r'
			strFieldName = "currentAddress_Detail_en";
			break;

		case 14: // '\016'
			strFieldName = "birthAddress_Country";
			break;

		case 15: // '\017'
			strFieldName = "birthAddress_Province";
			break;

		case 16: // '\020'
			strFieldName = "birthAddress_City";
			break;

		case 17: // '\021'
			strFieldName = "birthAddress_Detail";
			break;

		case 18: // '\022'
			strFieldName = "birthAddress_Country_en";
			break;

		case 19: // '\023'
			strFieldName = "birthAddress_Province_en";
			break;

		case 20: // '\024'
			strFieldName = "birthAddress_City_en";
			break;

		case 21: // '\025'
			strFieldName = "birthAddress_Detail_en";
			break;

		case 22: // '\026'
			strFieldName = "taxResidentCountry1";
			break;

		case 23: // '\027'
			strFieldName = "taxpayerCode1";
			break;

		case 24: // '\030'
			strFieldName = "taxResidentCountry2";
			break;

		case 25: // '\031'
			strFieldName = "taxpayerCode2";
			break;

		case 26: // '\032'
			strFieldName = "taxpayerCode3";
			break;

		case 27: // '\033'
			strFieldName = "taxResidentCountry3";
			break;

		case 28: // '\034'
			strFieldName = "noTaxpayercodeReason";
			break;

		case 29: // '\035'
			strFieldName = "reasonDescription";
			break;

		case 30: // '\036'
			strFieldName = "sourceType";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("customerName"))
			return 0;
		if (strFieldName.equals("taxResidentType"))
			return 0;
		if (strFieldName.equals("firstName"))
			return 0;
		if (strFieldName.equals("lastName"))
			return 0;
		if (strFieldName.equals("birthday"))
			return 0;
		if (strFieldName.equals("currentAddress_Country"))
			return 0;
		if (strFieldName.equals("currentAddress_Province"))
			return 0;
		if (strFieldName.equals("currentAddress_City"))
			return 0;
		if (strFieldName.equals("currentAddress_Detail"))
			return 0;
		if (strFieldName.equals("currentAddress_Country_en"))
			return 0;
		if (strFieldName.equals("currentAddress_Province_en"))
			return 0;
		if (strFieldName.equals("currentAddress_City_en"))
			return 0;
		if (strFieldName.equals("currentAddress_Detail_en"))
			return 0;
		if (strFieldName.equals("birthAddress_Country"))
			return 0;
		if (strFieldName.equals("birthAddress_Province"))
			return 0;
		if (strFieldName.equals("birthAddress_City"))
			return 0;
		if (strFieldName.equals("birthAddress_Detail"))
			return 0;
		if (strFieldName.equals("birthAddress_Country_en"))
			return 0;
		if (strFieldName.equals("birthAddress_Province_en"))
			return 0;
		if (strFieldName.equals("birthAddress_City_en"))
			return 0;
		if (strFieldName.equals("birthAddress_Detail_en"))
			return 0;
		if (strFieldName.equals("taxResidentCountry1"))
			return 0;
		if (strFieldName.equals("taxpayerCode1"))
			return 0;
		if (strFieldName.equals("taxResidentCountry2"))
			return 0;
		if (strFieldName.equals("taxpayerCode2"))
			return 0;
		if (strFieldName.equals("taxResidentCountry3"))
			return 0;
		if (strFieldName.equals("taxpayerCode3"))
			return 0;
		if (strFieldName.equals("noTaxpayercodeReason"))
			return 0;
		if (strFieldName.equals("reasonDescription"))
			return 0;
		return !strFieldName.equals("sourceType") ? -1 : 0;
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
			nFieldType = 1;
			break;

		case 12: // '\f'
			nFieldType = 3;
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
			nFieldType = 1;
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
			nFieldType = 1;
			break;

		case 26: // '\032'
			nFieldType = 0;
			break;

		case 27: // '\033'
			nFieldType = 4;
			break;

		case 28: // '\034'
			nFieldType = 4;
			break;

		case 29: // '\035'
			nFieldType = 0;
			break;

		case 30: // '\036'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}

	public Object encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(contNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(customerName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(taxResidentType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(firstName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(lastName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(birthday))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(currentAddress_Country))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(currentAddress_Province))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(currentAddress_City))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(currentAddress_Detail))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(currentAddress_Country_en))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(currentAddress_Province_en))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(currentAddress_City_en))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(currentAddress_Detail_en))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(birthAddress_Country))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(birthAddress_Province))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(birthAddress_City))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(birthAddress_Detail))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(birthAddress_Country_en))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(birthAddress_Province_en))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(birthAddress_City_en))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(birthAddress_Detail_en))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(taxResidentCountry1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(taxpayerCode1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(taxResidentCountry2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(taxpayerCode2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(taxResidentCountry3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(taxpayerCode3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(noTaxpayercodeReason))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(reasonDescription))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(sourceType))).append("|").toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			customerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			taxResidentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			firstName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			lastName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			birthday = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			currentAddress_Country = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			currentAddress_Province = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			currentAddress_City = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			currentAddress_Detail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			currentAddress_Country_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			currentAddress_Province_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			currentAddress_City_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			currentAddress_Detail_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			birthAddress_Country = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			birthAddress_Province = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			birthAddress_City = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			birthAddress_Detail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			birthAddress_Country_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			birthAddress_Province_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			birthAddress_City_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			birthAddress_Detail_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			taxResidentCountry1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			taxpayerCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			taxResidentCountry2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			taxpayerCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			taxResidentCountry3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			taxpayerCode3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			noTaxpayercodeReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			reasonDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			sourceType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LAComSchema";
			tError.functionName = "decode";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public String toString()
	{
		return (new StringBuilder("Schema中的信息CRSInfoSchema [contNo=")).append(contNo).append(", customerName=").append(customerName).append(", taxResidentType=").append(taxResidentType).append(", firstName=").append(firstName).append(", lastName=").append(lastName).append(", birthday=").append(birthday).append(", currentAddress_Country=").append(currentAddress_Country).append(", currentAddress_Province=").append(currentAddress_Province).append(", currentAddress_City=").append(currentAddress_City).append(", currentAddress_Detail=").append(currentAddress_Detail).append(", currentAddress_Country_en=").append(currentAddress_Country_en).append(", currentAddress_Province_en=").append(currentAddress_Province_en).append(", currentAddress_City_en=").append(currentAddress_City_en).append(", currentAddress_Detail_en=").append(currentAddress_Detail_en).append(", birthAddress_Country=").append(birthAddress_Country).append(", birthAddress_Province=").append(birthAddress_Province).append(", birthAddress_City=").append(birthAddress_City).append(", birthAddress_Detail=").append(birthAddress_Detail).append(", birthAddress_Country_en=").append(birthAddress_Country_en).append(", birthAddress_Province_en=").append(birthAddress_Province_en).append(", birthAddress_City_en=").append(birthAddress_City_en).append(", birthAddress_Detail_en=").append(birthAddress_Detail_en).append(", taxResidentCountry1=").append(taxResidentCountry1).append(", taxpayerCode1=").append(taxpayerCode1).append(", taxResidentCountry2=").append(taxResidentCountry2).append(", taxpayerCode2=").append(taxpayerCode2).append(", taxResidentCountry3=").append(taxResidentCountry3).append(", taxpayerCode3=").append(taxpayerCode3).append(", noTaxpayercodeReason=").append(noTaxpayercodeReason).append(", reasonDescription=").append(reasonDescription).append(", sourceType=").append(sourceType).append(", fDate=").append(fDate).append(", mErrors=").append(mErrors).append("]").toString();
	}
}
