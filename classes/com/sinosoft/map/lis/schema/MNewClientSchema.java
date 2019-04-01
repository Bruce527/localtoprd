// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MNewClientSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MNewClientDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MNewClientSchema
	implements Schema, Cloneable
{

	private String customerNo;
	private String customerNo2;
	private String clientName;
	private String gender;
	private Date birthday;
	private String eMail;
	private String grpZipCode;
	private String grpAddress;
	private String grpNo;
	private String bP;
	private String grpAddressCode;
	private String phone2;
	private String grpName;
	private String grpPhone;
	private String phone;
	private String mobile;
	private String occupationCode;
	private String position;
	private String workType;
	private String occupationType;
	private String homeAddress;
	private String homeAddressCode;
	private String rgtAddress;
	private String postalAddress;
	private String zipCode;
	private String homeZipCode;
	private String sequenceNo;
	private double stature;
	private double avoirdupois;
	private String smokeFlag;
	private Date deathDate;
	private String marriage;
	private String credentType;
	private String credentNO;
	private String othIDNo;
	private String othIDType;
	private String iCNo;
	private double salary;
	private double yearSalary;
	private String nativePlace;
	private String nationality;
	private Date marriageDate;
	private String degree;
	private String polNo;
	private String relationToInsured;
	private String pluralityType;
	private Date startWorkDate;
	private String health;
	private String password;
	private Date joinCompanyDate;
	private String appntGrade;
	private String creditGrade;
	private String clientType;
	private String state;
	private String agentcode;
	private Date signDate;
	private String addrChoise;
	private String customeProperty;
	private String birthdayFlag;
	private String appellation;
	private String iDDNo;
	private Date validityDate;
	private String countryOrArea;
	private Date specialDate;
	private String deleteFlag;
	private String interest;
	private String customeType;
	private String introducer;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 73;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MNewClientSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "CustomerNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MNewClientSchema cloned = (MNewClientSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getCustomerNo()
	{
		return customerNo;
	}

	public void setCustomerNo(String aCustomerNo)
	{
		customerNo = aCustomerNo;
	}

	public String getCustomerNo2()
	{
		return customerNo2;
	}

	public void setCustomerNo2(String aCustomerNo2)
	{
		customerNo2 = aCustomerNo2;
	}

	public String getClientName()
	{
		return clientName;
	}

	public void setClientName(String aClientName)
	{
		clientName = aClientName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String aGender)
	{
		gender = aGender;
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

	public String getEMail()
	{
		return eMail;
	}

	public void setEMail(String aEMail)
	{
		eMail = aEMail;
	}

	public String getGrpZipCode()
	{
		return grpZipCode;
	}

	public void setGrpZipCode(String aGrpZipCode)
	{
		grpZipCode = aGrpZipCode;
	}

	public String getGrpAddress()
	{
		return grpAddress;
	}

	public void setGrpAddress(String aGrpAddress)
	{
		grpAddress = aGrpAddress;
	}

	public String getGrpNo()
	{
		return grpNo;
	}

	public void setGrpNo(String aGrpNo)
	{
		grpNo = aGrpNo;
	}

	public String getBP()
	{
		return bP;
	}

	public void setBP(String aBP)
	{
		bP = aBP;
	}

	public String getGrpAddressCode()
	{
		return grpAddressCode;
	}

	public void setGrpAddressCode(String aGrpAddressCode)
	{
		grpAddressCode = aGrpAddressCode;
	}

	public String getPhone2()
	{
		return phone2;
	}

	public void setPhone2(String aPhone2)
	{
		phone2 = aPhone2;
	}

	public String getGrpName()
	{
		return grpName;
	}

	public void setGrpName(String aGrpName)
	{
		grpName = aGrpName;
	}

	public String getGrpPhone()
	{
		return grpPhone;
	}

	public void setGrpPhone(String aGrpPhone)
	{
		grpPhone = aGrpPhone;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String aPhone)
	{
		phone = aPhone;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String aMobile)
	{
		mobile = aMobile;
	}

	public String getOccupationCode()
	{
		return occupationCode;
	}

	public void setOccupationCode(String aOccupationCode)
	{
		occupationCode = aOccupationCode;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String aPosition)
	{
		position = aPosition;
	}

	public String getWorkType()
	{
		return workType;
	}

	public void setWorkType(String aWorkType)
	{
		workType = aWorkType;
	}

	public String getOccupationType()
	{
		return occupationType;
	}

	public void setOccupationType(String aOccupationType)
	{
		occupationType = aOccupationType;
	}

	public String getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(String aHomeAddress)
	{
		homeAddress = aHomeAddress;
	}

	public String getHomeAddressCode()
	{
		return homeAddressCode;
	}

	public void setHomeAddressCode(String aHomeAddressCode)
	{
		homeAddressCode = aHomeAddressCode;
	}

	public String getRgtAddress()
	{
		return rgtAddress;
	}

	public void setRgtAddress(String aRgtAddress)
	{
		rgtAddress = aRgtAddress;
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

	public String getHomeZipCode()
	{
		return homeZipCode;
	}

	public void setHomeZipCode(String aHomeZipCode)
	{
		homeZipCode = aHomeZipCode;
	}

	public String getSequenceNo()
	{
		return sequenceNo;
	}

	public void setSequenceNo(String aSequenceNo)
	{
		sequenceNo = aSequenceNo;
	}

	public double getStature()
	{
		return stature;
	}

	public void setStature(double aStature)
	{
		stature = aStature;
	}

	public void setStature(String aStature)
	{
		if (aStature != null && !aStature.equals(""))
		{
			Double tDouble = new Double(aStature);
			double d = tDouble.doubleValue();
			stature = d;
		}
	}

	public double getAvoirdupois()
	{
		return avoirdupois;
	}

	public void setAvoirdupois(double aAvoirdupois)
	{
		avoirdupois = aAvoirdupois;
	}

	public void setAvoirdupois(String aAvoirdupois)
	{
		if (aAvoirdupois != null && !aAvoirdupois.equals(""))
		{
			Double tDouble = new Double(aAvoirdupois);
			double d = tDouble.doubleValue();
			avoirdupois = d;
		}
	}

	public String getSmokeFlag()
	{
		return smokeFlag;
	}

	public void setSmokeFlag(String aSmokeFlag)
	{
		smokeFlag = aSmokeFlag;
	}

	public String getDeathDate()
	{
		if (deathDate != null)
			return fDate.getString(deathDate);
		else
			return null;
	}

	public void setDeathDate(Date aDeathDate)
	{
		deathDate = aDeathDate;
	}

	public void setDeathDate(String aDeathDate)
	{
		if (aDeathDate != null && !aDeathDate.equals(""))
			deathDate = fDate.getDate(aDeathDate);
		else
			deathDate = null;
	}

	public String getMarriage()
	{
		return marriage;
	}

	public void setMarriage(String aMarriage)
	{
		marriage = aMarriage;
	}

	public String getCredentType()
	{
		return credentType;
	}

	public void setCredentType(String aCredentType)
	{
		credentType = aCredentType;
	}

	public String getCredentNO()
	{
		return credentNO;
	}

	public void setCredentNO(String aCredentNO)
	{
		credentNO = aCredentNO;
	}

	public String getOthIDNo()
	{
		return othIDNo;
	}

	public void setOthIDNo(String aOthIDNo)
	{
		othIDNo = aOthIDNo;
	}

	public String getOthIDType()
	{
		return othIDType;
	}

	public void setOthIDType(String aOthIDType)
	{
		othIDType = aOthIDType;
	}

	public String getICNo()
	{
		return iCNo;
	}

	public void setICNo(String aICNo)
	{
		iCNo = aICNo;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double aSalary)
	{
		salary = aSalary;
	}

	public void setSalary(String aSalary)
	{
		if (aSalary != null && !aSalary.equals(""))
		{
			Double tDouble = new Double(aSalary);
			double d = tDouble.doubleValue();
			salary = d;
		}
	}

	public double getYearSalary()
	{
		return yearSalary;
	}

	public void setYearSalary(double aYearSalary)
	{
		yearSalary = aYearSalary;
	}

	public void setYearSalary(String aYearSalary)
	{
		if (aYearSalary != null && !aYearSalary.equals(""))
		{
			Double tDouble = new Double(aYearSalary);
			double d = tDouble.doubleValue();
			yearSalary = d;
		}
	}

	public String getNativePlace()
	{
		return nativePlace;
	}

	public void setNativePlace(String aNativePlace)
	{
		nativePlace = aNativePlace;
	}

	public String getNationality()
	{
		return nationality;
	}

	public void setNationality(String aNationality)
	{
		nationality = aNationality;
	}

	public String getMarriageDate()
	{
		if (marriageDate != null)
			return fDate.getString(marriageDate);
		else
			return null;
	}

	public void setMarriageDate(Date aMarriageDate)
	{
		marriageDate = aMarriageDate;
	}

	public void setMarriageDate(String aMarriageDate)
	{
		if (aMarriageDate != null && !aMarriageDate.equals(""))
			marriageDate = fDate.getDate(aMarriageDate);
		else
			marriageDate = null;
	}

	public String getDegree()
	{
		return degree;
	}

	public void setDegree(String aDegree)
	{
		degree = aDegree;
	}

	public String getPolNo()
	{
		return polNo;
	}

	public void setPolNo(String aPolNo)
	{
		polNo = aPolNo;
	}

	public String getRelationToInsured()
	{
		return relationToInsured;
	}

	public void setRelationToInsured(String aRelationToInsured)
	{
		relationToInsured = aRelationToInsured;
	}

	public String getPluralityType()
	{
		return pluralityType;
	}

	public void setPluralityType(String aPluralityType)
	{
		pluralityType = aPluralityType;
	}

	public String getStartWorkDate()
	{
		if (startWorkDate != null)
			return fDate.getString(startWorkDate);
		else
			return null;
	}

	public void setStartWorkDate(Date aStartWorkDate)
	{
		startWorkDate = aStartWorkDate;
	}

	public void setStartWorkDate(String aStartWorkDate)
	{
		if (aStartWorkDate != null && !aStartWorkDate.equals(""))
			startWorkDate = fDate.getDate(aStartWorkDate);
		else
			startWorkDate = null;
	}

	public String getHealth()
	{
		return health;
	}

	public void setHealth(String aHealth)
	{
		health = aHealth;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String aPassword)
	{
		password = aPassword;
	}

	public String getJoinCompanyDate()
	{
		if (joinCompanyDate != null)
			return fDate.getString(joinCompanyDate);
		else
			return null;
	}

	public void setJoinCompanyDate(Date aJoinCompanyDate)
	{
		joinCompanyDate = aJoinCompanyDate;
	}

	public void setJoinCompanyDate(String aJoinCompanyDate)
	{
		if (aJoinCompanyDate != null && !aJoinCompanyDate.equals(""))
			joinCompanyDate = fDate.getDate(aJoinCompanyDate);
		else
			joinCompanyDate = null;
	}

	public String getAppntGrade()
	{
		return appntGrade;
	}

	public void setAppntGrade(String aAppntGrade)
	{
		appntGrade = aAppntGrade;
	}

	public String getCreditGrade()
	{
		return creditGrade;
	}

	public void setCreditGrade(String aCreditGrade)
	{
		creditGrade = aCreditGrade;
	}

	public String getClientType()
	{
		return clientType;
	}

	public void setClientType(String aClientType)
	{
		clientType = aClientType;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getAgentcode()
	{
		return agentcode;
	}

	public void setAgentcode(String aAgentcode)
	{
		agentcode = aAgentcode;
	}

	public String getSignDate()
	{
		if (signDate != null)
			return fDate.getString(signDate);
		else
			return null;
	}

	public void setSignDate(Date aSignDate)
	{
		signDate = aSignDate;
	}

	public void setSignDate(String aSignDate)
	{
		if (aSignDate != null && !aSignDate.equals(""))
			signDate = fDate.getDate(aSignDate);
		else
			signDate = null;
	}

	public String getAddrChoise()
	{
		return addrChoise;
	}

	public void setAddrChoise(String aAddrChoise)
	{
		addrChoise = aAddrChoise;
	}

	public String getCustomeProperty()
	{
		return customeProperty;
	}

	public void setCustomeProperty(String aCustomeProperty)
	{
		customeProperty = aCustomeProperty;
	}

	public String getBirthdayFlag()
	{
		return birthdayFlag;
	}

	public void setBirthdayFlag(String aBirthdayFlag)
	{
		birthdayFlag = aBirthdayFlag;
	}

	public String getAppellation()
	{
		return appellation;
	}

	public void setAppellation(String aAppellation)
	{
		appellation = aAppellation;
	}

	public String getIDDNo()
	{
		return iDDNo;
	}

	public void setIDDNo(String aIDDNo)
	{
		iDDNo = aIDDNo;
	}

	public String getValidityDate()
	{
		if (validityDate != null)
			return fDate.getString(validityDate);
		else
			return null;
	}

	public void setValidityDate(Date aValidityDate)
	{
		validityDate = aValidityDate;
	}

	public void setValidityDate(String aValidityDate)
	{
		if (aValidityDate != null && !aValidityDate.equals(""))
			validityDate = fDate.getDate(aValidityDate);
		else
			validityDate = null;
	}

	public String getCountryOrArea()
	{
		return countryOrArea;
	}

	public void setCountryOrArea(String aCountryOrArea)
	{
		countryOrArea = aCountryOrArea;
	}

	public String getSpecialDate()
	{
		if (specialDate != null)
			return fDate.getString(specialDate);
		else
			return null;
	}

	public void setSpecialDate(Date aSpecialDate)
	{
		specialDate = aSpecialDate;
	}

	public void setSpecialDate(String aSpecialDate)
	{
		if (aSpecialDate != null && !aSpecialDate.equals(""))
			specialDate = fDate.getDate(aSpecialDate);
		else
			specialDate = null;
	}

	public String getDeleteFlag()
	{
		return deleteFlag;
	}

	public void setDeleteFlag(String aDeleteFlag)
	{
		deleteFlag = aDeleteFlag;
	}

	public String getInterest()
	{
		return interest;
	}

	public void setInterest(String aInterest)
	{
		interest = aInterest;
	}

	public String getCustomeType()
	{
		return customeType;
	}

	public void setCustomeType(String aCustomeType)
	{
		customeType = aCustomeType;
	}

	public String getIntroducer()
	{
		return introducer;
	}

	public void setIntroducer(String aIntroducer)
	{
		introducer = aIntroducer;
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

	public void setSchema(MNewClientSchema aMNewClientSchema)
	{
		customerNo = aMNewClientSchema.getCustomerNo();
		customerNo2 = aMNewClientSchema.getCustomerNo2();
		clientName = aMNewClientSchema.getClientName();
		gender = aMNewClientSchema.getGender();
		birthday = fDate.getDate(aMNewClientSchema.getBirthday());
		eMail = aMNewClientSchema.getEMail();
		grpZipCode = aMNewClientSchema.getGrpZipCode();
		grpAddress = aMNewClientSchema.getGrpAddress();
		grpNo = aMNewClientSchema.getGrpNo();
		bP = aMNewClientSchema.getBP();
		grpAddressCode = aMNewClientSchema.getGrpAddressCode();
		phone2 = aMNewClientSchema.getPhone2();
		grpName = aMNewClientSchema.getGrpName();
		grpPhone = aMNewClientSchema.getGrpPhone();
		phone = aMNewClientSchema.getPhone();
		mobile = aMNewClientSchema.getMobile();
		occupationCode = aMNewClientSchema.getOccupationCode();
		position = aMNewClientSchema.getPosition();
		workType = aMNewClientSchema.getWorkType();
		occupationType = aMNewClientSchema.getOccupationType();
		homeAddress = aMNewClientSchema.getHomeAddress();
		homeAddressCode = aMNewClientSchema.getHomeAddressCode();
		rgtAddress = aMNewClientSchema.getRgtAddress();
		postalAddress = aMNewClientSchema.getPostalAddress();
		zipCode = aMNewClientSchema.getZipCode();
		homeZipCode = aMNewClientSchema.getHomeZipCode();
		sequenceNo = aMNewClientSchema.getSequenceNo();
		stature = aMNewClientSchema.getStature();
		avoirdupois = aMNewClientSchema.getAvoirdupois();
		smokeFlag = aMNewClientSchema.getSmokeFlag();
		deathDate = fDate.getDate(aMNewClientSchema.getDeathDate());
		marriage = aMNewClientSchema.getMarriage();
		credentType = aMNewClientSchema.getCredentType();
		credentNO = aMNewClientSchema.getCredentNO();
		othIDNo = aMNewClientSchema.getOthIDNo();
		othIDType = aMNewClientSchema.getOthIDType();
		iCNo = aMNewClientSchema.getICNo();
		salary = aMNewClientSchema.getSalary();
		yearSalary = aMNewClientSchema.getYearSalary();
		nativePlace = aMNewClientSchema.getNativePlace();
		nationality = aMNewClientSchema.getNationality();
		marriageDate = fDate.getDate(aMNewClientSchema.getMarriageDate());
		degree = aMNewClientSchema.getDegree();
		polNo = aMNewClientSchema.getPolNo();
		relationToInsured = aMNewClientSchema.getRelationToInsured();
		pluralityType = aMNewClientSchema.getPluralityType();
		startWorkDate = fDate.getDate(aMNewClientSchema.getStartWorkDate());
		health = aMNewClientSchema.getHealth();
		password = aMNewClientSchema.getPassword();
		joinCompanyDate = fDate.getDate(aMNewClientSchema.getJoinCompanyDate());
		appntGrade = aMNewClientSchema.getAppntGrade();
		creditGrade = aMNewClientSchema.getCreditGrade();
		clientType = aMNewClientSchema.getClientType();
		state = aMNewClientSchema.getState();
		agentcode = aMNewClientSchema.getAgentcode();
		signDate = fDate.getDate(aMNewClientSchema.getSignDate());
		addrChoise = aMNewClientSchema.getAddrChoise();
		customeProperty = aMNewClientSchema.getCustomeProperty();
		birthdayFlag = aMNewClientSchema.getBirthdayFlag();
		appellation = aMNewClientSchema.getAppellation();
		iDDNo = aMNewClientSchema.getIDDNo();
		validityDate = fDate.getDate(aMNewClientSchema.getValidityDate());
		countryOrArea = aMNewClientSchema.getCountryOrArea();
		specialDate = fDate.getDate(aMNewClientSchema.getSpecialDate());
		deleteFlag = aMNewClientSchema.getDeleteFlag();
		interest = aMNewClientSchema.getInterest();
		customeType = aMNewClientSchema.getCustomeType();
		introducer = aMNewClientSchema.getIntroducer();
		operator = aMNewClientSchema.getOperator();
		makeDate = fDate.getDate(aMNewClientSchema.getMakeDate());
		makeTime = aMNewClientSchema.getMakeTime();
		modifyDate = fDate.getDate(aMNewClientSchema.getModifyDate());
		modifyTime = aMNewClientSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("CustomerNo") == null)
				customerNo = null;
			else
				customerNo = rs.getString("CustomerNo").trim();
			if (rs.getString("CustomerNo2") == null)
				customerNo2 = null;
			else
				customerNo2 = rs.getString("CustomerNo2").trim();
			if (rs.getString("ClientName") == null)
				clientName = null;
			else
				clientName = rs.getString("ClientName").trim();
			if (rs.getString("Gender") == null)
				gender = null;
			else
				gender = rs.getString("Gender").trim();
			birthday = rs.getDate("Birthday");
			if (rs.getString("EMail") == null)
				eMail = null;
			else
				eMail = rs.getString("EMail").trim();
			if (rs.getString("GrpZipCode") == null)
				grpZipCode = null;
			else
				grpZipCode = rs.getString("GrpZipCode").trim();
			if (rs.getString("GrpAddress") == null)
				grpAddress = null;
			else
				grpAddress = rs.getString("GrpAddress").trim();
			if (rs.getString("GrpNo") == null)
				grpNo = null;
			else
				grpNo = rs.getString("GrpNo").trim();
			if (rs.getString("BP") == null)
				bP = null;
			else
				bP = rs.getString("BP").trim();
			if (rs.getString("GrpAddressCode") == null)
				grpAddressCode = null;
			else
				grpAddressCode = rs.getString("GrpAddressCode").trim();
			if (rs.getString("Phone2") == null)
				phone2 = null;
			else
				phone2 = rs.getString("Phone2").trim();
			if (rs.getString("GrpName") == null)
				grpName = null;
			else
				grpName = rs.getString("GrpName").trim();
			if (rs.getString("GrpPhone") == null)
				grpPhone = null;
			else
				grpPhone = rs.getString("GrpPhone").trim();
			if (rs.getString("Phone") == null)
				phone = null;
			else
				phone = rs.getString("Phone").trim();
			if (rs.getString("Mobile") == null)
				mobile = null;
			else
				mobile = rs.getString("Mobile").trim();
			if (rs.getString("OccupationCode") == null)
				occupationCode = null;
			else
				occupationCode = rs.getString("OccupationCode").trim();
			if (rs.getString("Position") == null)
				position = null;
			else
				position = rs.getString("Position").trim();
			if (rs.getString("WorkType") == null)
				workType = null;
			else
				workType = rs.getString("WorkType").trim();
			if (rs.getString("OccupationType") == null)
				occupationType = null;
			else
				occupationType = rs.getString("OccupationType").trim();
			if (rs.getString("HomeAddress") == null)
				homeAddress = null;
			else
				homeAddress = rs.getString("HomeAddress").trim();
			if (rs.getString("HomeAddressCode") == null)
				homeAddressCode = null;
			else
				homeAddressCode = rs.getString("HomeAddressCode").trim();
			if (rs.getString("RgtAddress") == null)
				rgtAddress = null;
			else
				rgtAddress = rs.getString("RgtAddress").trim();
			if (rs.getString("PostalAddress") == null)
				postalAddress = null;
			else
				postalAddress = rs.getString("PostalAddress").trim();
			if (rs.getString("ZipCode") == null)
				zipCode = null;
			else
				zipCode = rs.getString("ZipCode").trim();
			if (rs.getString("HomeZipCode") == null)
				homeZipCode = null;
			else
				homeZipCode = rs.getString("HomeZipCode").trim();
			if (rs.getString("SequenceNo") == null)
				sequenceNo = null;
			else
				sequenceNo = rs.getString("SequenceNo").trim();
			stature = rs.getDouble("Stature");
			avoirdupois = rs.getDouble("Avoirdupois");
			if (rs.getString("SmokeFlag") == null)
				smokeFlag = null;
			else
				smokeFlag = rs.getString("SmokeFlag").trim();
			deathDate = rs.getDate("DeathDate");
			if (rs.getString("Marriage") == null)
				marriage = null;
			else
				marriage = rs.getString("Marriage").trim();
			if (rs.getString("CredentType") == null)
				credentType = null;
			else
				credentType = rs.getString("CredentType").trim();
			if (rs.getString("CredentNO") == null)
				credentNO = null;
			else
				credentNO = rs.getString("CredentNO").trim();
			if (rs.getString("OthIDNo") == null)
				othIDNo = null;
			else
				othIDNo = rs.getString("OthIDNo").trim();
			if (rs.getString("OthIDType") == null)
				othIDType = null;
			else
				othIDType = rs.getString("OthIDType").trim();
			if (rs.getString("ICNo") == null)
				iCNo = null;
			else
				iCNo = rs.getString("ICNo").trim();
			salary = rs.getDouble("Salary");
			yearSalary = rs.getDouble("YearSalary");
			if (rs.getString("NativePlace") == null)
				nativePlace = null;
			else
				nativePlace = rs.getString("NativePlace").trim();
			if (rs.getString("Nationality") == null)
				nationality = null;
			else
				nationality = rs.getString("Nationality").trim();
			marriageDate = rs.getDate("MarriageDate");
			if (rs.getString("Degree") == null)
				degree = null;
			else
				degree = rs.getString("Degree").trim();
			if (rs.getString("PolNo") == null)
				polNo = null;
			else
				polNo = rs.getString("PolNo").trim();
			if (rs.getString("RelationToInsured") == null)
				relationToInsured = null;
			else
				relationToInsured = rs.getString("RelationToInsured").trim();
			if (rs.getString("PluralityType") == null)
				pluralityType = null;
			else
				pluralityType = rs.getString("PluralityType").trim();
			startWorkDate = rs.getDate("StartWorkDate");
			if (rs.getString("Health") == null)
				health = null;
			else
				health = rs.getString("Health").trim();
			if (rs.getString("Password") == null)
				password = null;
			else
				password = rs.getString("Password").trim();
			joinCompanyDate = rs.getDate("JoinCompanyDate");
			if (rs.getString("AppntGrade") == null)
				appntGrade = null;
			else
				appntGrade = rs.getString("AppntGrade").trim();
			if (rs.getString("CreditGrade") == null)
				creditGrade = null;
			else
				creditGrade = rs.getString("CreditGrade").trim();
			if (rs.getString("ClientType") == null)
				clientType = null;
			else
				clientType = rs.getString("ClientType").trim();
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			if (rs.getString("Agentcode") == null)
				agentcode = null;
			else
				agentcode = rs.getString("Agentcode").trim();
			signDate = rs.getDate("SignDate");
			if (rs.getString("AddrChoise") == null)
				addrChoise = null;
			else
				addrChoise = rs.getString("AddrChoise").trim();
			if (rs.getString("CustomeProperty") == null)
				customeProperty = null;
			else
				customeProperty = rs.getString("CustomeProperty").trim();
			if (rs.getString("BirthdayFlag") == null)
				birthdayFlag = null;
			else
				birthdayFlag = rs.getString("BirthdayFlag").trim();
			if (rs.getString("Appellation") == null)
				appellation = null;
			else
				appellation = rs.getString("Appellation").trim();
			if (rs.getString("IDDNo") == null)
				iDDNo = null;
			else
				iDDNo = rs.getString("IDDNo").trim();
			validityDate = rs.getDate("ValidityDate");
			if (rs.getString("CountryOrArea") == null)
				countryOrArea = null;
			else
				countryOrArea = rs.getString("CountryOrArea").trim();
			specialDate = rs.getDate("SpecialDate");
			if (rs.getString("DeleteFlag") == null)
				deleteFlag = null;
			else
				deleteFlag = rs.getString("DeleteFlag").trim();
			if (rs.getString("Interest") == null)
				interest = null;
			else
				interest = rs.getString("Interest").trim();
			if (rs.getString("CustomeType") == null)
				customeType = null;
			else
				customeType = rs.getString("CustomeType").trim();
			if (rs.getString("Introducer") == null)
				introducer = null;
			else
				introducer = rs.getString("Introducer").trim();
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
			System.out.println("数据库中的MNewClient表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MNewClientSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MNewClientSchema getSchema()
	{
		MNewClientSchema aMNewClientSchema = new MNewClientSchema();
		aMNewClientSchema.setSchema(this);
		return aMNewClientSchema;
	}

	public MNewClientDB getDB()
	{
		MNewClientDB aDBOper = new MNewClientDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(customerNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(customerNo2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(clientName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(gender));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(birthday)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(eMail));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpZipCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpAddress));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bP));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpAddressCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(phone2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpPhone));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(phone));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mobile));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(occupationCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(position));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(workType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(occupationType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(homeAddress));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(homeAddressCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rgtAddress));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(postalAddress));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(zipCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(homeZipCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sequenceNo));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(stature));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(avoirdupois));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(smokeFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(deathDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(marriage));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(credentType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(credentNO));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(othIDNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(othIDType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iCNo));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(salary));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(yearSalary));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nativePlace));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nationality));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(marriageDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(degree));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(polNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relationToInsured));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(pluralityType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startWorkDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(health));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(password));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(joinCompanyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(creditGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(clientType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentcode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(signDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(addrChoise));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(customeProperty));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(birthdayFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appellation));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDDNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(validityDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(countryOrArea));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(specialDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(deleteFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(interest));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(customeType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(introducer));
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
			customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			customerNo2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			clientName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			gender = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			birthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
			eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			grpZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			grpAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			grpNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			bP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			grpAddressCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			phone2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			grpPhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			mobile = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			homeAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			homeAddressCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			postalAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			zipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			homeZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			sequenceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			stature = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 28, "|")))).doubleValue();
			avoirdupois = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|")))).doubleValue();
			smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			deathDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|"));
			marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			credentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			credentNO = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			othIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			othIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
			iCNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			salary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|")))).doubleValue();
			yearSalary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|")))).doubleValue();
			nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			marriageDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|"));
			degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			relationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			startWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|"));
			health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			joinCompanyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|"));
			appntGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			clientType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
			agentcode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
			signDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|"));
			addrChoise = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|");
			customeProperty = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, "|");
			birthdayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 59, "|");
			appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 60, "|");
			iDDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 61, "|");
			validityDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, "|"));
			countryOrArea = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, "|");
			specialDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, "|"));
			deleteFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 65, "|");
			interest = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 66, "|");
			customeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 67, "|");
			introducer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 68, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 69, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 70, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 71, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 72, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 73, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MNewClientSchema";
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
		if (FCode.equalsIgnoreCase("customerNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerNo));
		if (FCode.equalsIgnoreCase("customerNo2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerNo2));
		if (FCode.equalsIgnoreCase("clientName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clientName));
		if (FCode.equalsIgnoreCase("gender"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(gender));
		if (FCode.equalsIgnoreCase("birthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
		if (FCode.equalsIgnoreCase("eMail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(eMail));
		if (FCode.equalsIgnoreCase("grpZipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpZipCode));
		if (FCode.equalsIgnoreCase("grpAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpAddress));
		if (FCode.equalsIgnoreCase("grpNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpNo));
		if (FCode.equalsIgnoreCase("bP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bP));
		if (FCode.equalsIgnoreCase("grpAddressCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpAddressCode));
		if (FCode.equalsIgnoreCase("phone2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(phone2));
		if (FCode.equalsIgnoreCase("grpName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpName));
		if (FCode.equalsIgnoreCase("grpPhone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpPhone));
		if (FCode.equalsIgnoreCase("phone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(phone));
		if (FCode.equalsIgnoreCase("mobile"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mobile));
		if (FCode.equalsIgnoreCase("occupationCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationCode));
		if (FCode.equalsIgnoreCase("position"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(position));
		if (FCode.equalsIgnoreCase("workType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(workType));
		if (FCode.equalsIgnoreCase("occupationType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationType));
		if (FCode.equalsIgnoreCase("homeAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homeAddress));
		if (FCode.equalsIgnoreCase("homeAddressCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homeAddressCode));
		if (FCode.equalsIgnoreCase("rgtAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rgtAddress));
		if (FCode.equalsIgnoreCase("postalAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(postalAddress));
		if (FCode.equalsIgnoreCase("zipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(zipCode));
		if (FCode.equalsIgnoreCase("homeZipCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(homeZipCode));
		if (FCode.equalsIgnoreCase("sequenceNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sequenceNo));
		if (FCode.equalsIgnoreCase("stature"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(stature));
		if (FCode.equalsIgnoreCase("avoirdupois"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(avoirdupois));
		if (FCode.equalsIgnoreCase("smokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(smokeFlag));
		if (FCode.equalsIgnoreCase("deathDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDeathDate()));
		if (FCode.equalsIgnoreCase("marriage"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(marriage));
		if (FCode.equalsIgnoreCase("credentType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(credentType));
		if (FCode.equalsIgnoreCase("credentNO"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(credentNO));
		if (FCode.equalsIgnoreCase("othIDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(othIDNo));
		if (FCode.equalsIgnoreCase("othIDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(othIDType));
		if (FCode.equalsIgnoreCase("iCNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iCNo));
		if (FCode.equalsIgnoreCase("salary"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(salary));
		if (FCode.equalsIgnoreCase("yearSalary"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(yearSalary));
		if (FCode.equalsIgnoreCase("nativePlace"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nativePlace));
		if (FCode.equalsIgnoreCase("nationality"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nationality));
		if (FCode.equalsIgnoreCase("marriageDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
		if (FCode.equalsIgnoreCase("degree"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(degree));
		if (FCode.equalsIgnoreCase("polNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polNo));
		if (FCode.equalsIgnoreCase("relationToInsured"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relationToInsured));
		if (FCode.equalsIgnoreCase("pluralityType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pluralityType));
		if (FCode.equalsIgnoreCase("startWorkDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
		if (FCode.equalsIgnoreCase("health"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(health));
		if (FCode.equalsIgnoreCase("password"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(password));
		if (FCode.equalsIgnoreCase("joinCompanyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
		if (FCode.equalsIgnoreCase("appntGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntGrade));
		if (FCode.equalsIgnoreCase("creditGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(creditGrade));
		if (FCode.equalsIgnoreCase("clientType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clientType));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("agentcode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentcode));
		if (FCode.equalsIgnoreCase("signDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
		if (FCode.equalsIgnoreCase("addrChoise"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addrChoise));
		if (FCode.equalsIgnoreCase("customeProperty"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customeProperty));
		if (FCode.equalsIgnoreCase("birthdayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(birthdayFlag));
		if (FCode.equalsIgnoreCase("appellation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appellation));
		if (FCode.equalsIgnoreCase("iDDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDDNo));
		if (FCode.equalsIgnoreCase("validityDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getValidityDate()));
		if (FCode.equalsIgnoreCase("countryOrArea"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(countryOrArea));
		if (FCode.equalsIgnoreCase("specialDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getSpecialDate()));
		if (FCode.equalsIgnoreCase("deleteFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(deleteFlag));
		if (FCode.equalsIgnoreCase("interest"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(interest));
		if (FCode.equalsIgnoreCase("customeType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customeType));
		if (FCode.equalsIgnoreCase("introducer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(introducer));
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
			strFieldValue = StrTool.GBKToUnicode(customerNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(customerNo2);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(clientName);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(gender);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(eMail);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(grpZipCode);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(grpAddress);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(grpNo);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(bP);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(grpAddressCode);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(phone2);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(grpName);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(grpPhone);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(phone);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(mobile);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(occupationCode);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(position);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(workType);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(occupationType);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(homeAddress);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(homeAddressCode);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(rgtAddress);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(postalAddress);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(zipCode);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(homeZipCode);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(sequenceNo);
			break;

		case 27: // '\033'
			strFieldValue = String.valueOf(stature);
			break;

		case 28: // '\034'
			strFieldValue = String.valueOf(avoirdupois);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(smokeFlag);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDeathDate()));
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(marriage);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(credentType);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(credentNO);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(othIDNo);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(othIDType);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(iCNo);
			break;

		case 37: // '%'
			strFieldValue = String.valueOf(salary);
			break;

		case 38: // '&'
			strFieldValue = String.valueOf(yearSalary);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(nativePlace);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(nationality);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(degree);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(polNo);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(relationToInsured);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(pluralityType);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(health);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(password);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(appntGrade);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(creditGrade);
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(clientType);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 54: // '6'
			strFieldValue = StrTool.GBKToUnicode(agentcode);
			break;

		case 55: // '7'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getSignDate()));
			break;

		case 56: // '8'
			strFieldValue = StrTool.GBKToUnicode(addrChoise);
			break;

		case 57: // '9'
			strFieldValue = StrTool.GBKToUnicode(customeProperty);
			break;

		case 58: // ':'
			strFieldValue = StrTool.GBKToUnicode(birthdayFlag);
			break;

		case 59: // ';'
			strFieldValue = StrTool.GBKToUnicode(appellation);
			break;

		case 60: // '<'
			strFieldValue = StrTool.GBKToUnicode(iDDNo);
			break;

		case 61: // '='
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getValidityDate()));
			break;

		case 62: // '>'
			strFieldValue = StrTool.GBKToUnicode(countryOrArea);
			break;

		case 63: // '?'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getSpecialDate()));
			break;

		case 64: // '@'
			strFieldValue = StrTool.GBKToUnicode(deleteFlag);
			break;

		case 65: // 'A'
			strFieldValue = StrTool.GBKToUnicode(interest);
			break;

		case 66: // 'B'
			strFieldValue = StrTool.GBKToUnicode(customeType);
			break;

		case 67: // 'C'
			strFieldValue = StrTool.GBKToUnicode(introducer);
			break;

		case 68: // 'D'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 69: // 'E'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 70: // 'F'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 71: // 'G'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 72: // 'H'
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
		if (FCode.equalsIgnoreCase("customerNo"))
			if (FValue != null && !FValue.equals(""))
				customerNo = FValue.trim();
			else
				customerNo = null;
		if (FCode.equalsIgnoreCase("customerNo2"))
			if (FValue != null && !FValue.equals(""))
				customerNo2 = FValue.trim();
			else
				customerNo2 = null;
		if (FCode.equalsIgnoreCase("clientName"))
			if (FValue != null && !FValue.equals(""))
				clientName = FValue.trim();
			else
				clientName = null;
		if (FCode.equalsIgnoreCase("gender"))
			if (FValue != null && !FValue.equals(""))
				gender = FValue.trim();
			else
				gender = null;
		if (FCode.equalsIgnoreCase("birthday"))
			if (FValue != null && !FValue.equals(""))
				birthday = fDate.getDate(FValue);
			else
				birthday = null;
		if (FCode.equalsIgnoreCase("eMail"))
			if (FValue != null && !FValue.equals(""))
				eMail = FValue.trim();
			else
				eMail = null;
		if (FCode.equalsIgnoreCase("grpZipCode"))
			if (FValue != null && !FValue.equals(""))
				grpZipCode = FValue.trim();
			else
				grpZipCode = null;
		if (FCode.equalsIgnoreCase("grpAddress"))
			if (FValue != null && !FValue.equals(""))
				grpAddress = FValue.trim();
			else
				grpAddress = null;
		if (FCode.equalsIgnoreCase("grpNo"))
			if (FValue != null && !FValue.equals(""))
				grpNo = FValue.trim();
			else
				grpNo = null;
		if (FCode.equalsIgnoreCase("bP"))
			if (FValue != null && !FValue.equals(""))
				bP = FValue.trim();
			else
				bP = null;
		if (FCode.equalsIgnoreCase("grpAddressCode"))
			if (FValue != null && !FValue.equals(""))
				grpAddressCode = FValue.trim();
			else
				grpAddressCode = null;
		if (FCode.equalsIgnoreCase("phone2"))
			if (FValue != null && !FValue.equals(""))
				phone2 = FValue.trim();
			else
				phone2 = null;
		if (FCode.equalsIgnoreCase("grpName"))
			if (FValue != null && !FValue.equals(""))
				grpName = FValue.trim();
			else
				grpName = null;
		if (FCode.equalsIgnoreCase("grpPhone"))
			if (FValue != null && !FValue.equals(""))
				grpPhone = FValue.trim();
			else
				grpPhone = null;
		if (FCode.equalsIgnoreCase("phone"))
			if (FValue != null && !FValue.equals(""))
				phone = FValue.trim();
			else
				phone = null;
		if (FCode.equalsIgnoreCase("mobile"))
			if (FValue != null && !FValue.equals(""))
				mobile = FValue.trim();
			else
				mobile = null;
		if (FCode.equalsIgnoreCase("occupationCode"))
			if (FValue != null && !FValue.equals(""))
				occupationCode = FValue.trim();
			else
				occupationCode = null;
		if (FCode.equalsIgnoreCase("position"))
			if (FValue != null && !FValue.equals(""))
				position = FValue.trim();
			else
				position = null;
		if (FCode.equalsIgnoreCase("workType"))
			if (FValue != null && !FValue.equals(""))
				workType = FValue.trim();
			else
				workType = null;
		if (FCode.equalsIgnoreCase("occupationType"))
			if (FValue != null && !FValue.equals(""))
				occupationType = FValue.trim();
			else
				occupationType = null;
		if (FCode.equalsIgnoreCase("homeAddress"))
			if (FValue != null && !FValue.equals(""))
				homeAddress = FValue.trim();
			else
				homeAddress = null;
		if (FCode.equalsIgnoreCase("homeAddressCode"))
			if (FValue != null && !FValue.equals(""))
				homeAddressCode = FValue.trim();
			else
				homeAddressCode = null;
		if (FCode.equalsIgnoreCase("rgtAddress"))
			if (FValue != null && !FValue.equals(""))
				rgtAddress = FValue.trim();
			else
				rgtAddress = null;
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
		if (FCode.equalsIgnoreCase("homeZipCode"))
			if (FValue != null && !FValue.equals(""))
				homeZipCode = FValue.trim();
			else
				homeZipCode = null;
		if (FCode.equalsIgnoreCase("sequenceNo"))
			if (FValue != null && !FValue.equals(""))
				sequenceNo = FValue.trim();
			else
				sequenceNo = null;
		if (FCode.equalsIgnoreCase("stature") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			stature = d;
		}
		if (FCode.equalsIgnoreCase("avoirdupois") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			avoirdupois = d;
		}
		if (FCode.equalsIgnoreCase("smokeFlag"))
			if (FValue != null && !FValue.equals(""))
				smokeFlag = FValue.trim();
			else
				smokeFlag = null;
		if (FCode.equalsIgnoreCase("deathDate"))
			if (FValue != null && !FValue.equals(""))
				deathDate = fDate.getDate(FValue);
			else
				deathDate = null;
		if (FCode.equalsIgnoreCase("marriage"))
			if (FValue != null && !FValue.equals(""))
				marriage = FValue.trim();
			else
				marriage = null;
		if (FCode.equalsIgnoreCase("credentType"))
			if (FValue != null && !FValue.equals(""))
				credentType = FValue.trim();
			else
				credentType = null;
		if (FCode.equalsIgnoreCase("credentNO"))
			if (FValue != null && !FValue.equals(""))
				credentNO = FValue.trim();
			else
				credentNO = null;
		if (FCode.equalsIgnoreCase("othIDNo"))
			if (FValue != null && !FValue.equals(""))
				othIDNo = FValue.trim();
			else
				othIDNo = null;
		if (FCode.equalsIgnoreCase("othIDType"))
			if (FValue != null && !FValue.equals(""))
				othIDType = FValue.trim();
			else
				othIDType = null;
		if (FCode.equalsIgnoreCase("iCNo"))
			if (FValue != null && !FValue.equals(""))
				iCNo = FValue.trim();
			else
				iCNo = null;
		if (FCode.equalsIgnoreCase("salary") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			salary = d;
		}
		if (FCode.equalsIgnoreCase("yearSalary") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			yearSalary = d;
		}
		if (FCode.equalsIgnoreCase("nativePlace"))
			if (FValue != null && !FValue.equals(""))
				nativePlace = FValue.trim();
			else
				nativePlace = null;
		if (FCode.equalsIgnoreCase("nationality"))
			if (FValue != null && !FValue.equals(""))
				nationality = FValue.trim();
			else
				nationality = null;
		if (FCode.equalsIgnoreCase("marriageDate"))
			if (FValue != null && !FValue.equals(""))
				marriageDate = fDate.getDate(FValue);
			else
				marriageDate = null;
		if (FCode.equalsIgnoreCase("degree"))
			if (FValue != null && !FValue.equals(""))
				degree = FValue.trim();
			else
				degree = null;
		if (FCode.equalsIgnoreCase("polNo"))
			if (FValue != null && !FValue.equals(""))
				polNo = FValue.trim();
			else
				polNo = null;
		if (FCode.equalsIgnoreCase("relationToInsured"))
			if (FValue != null && !FValue.equals(""))
				relationToInsured = FValue.trim();
			else
				relationToInsured = null;
		if (FCode.equalsIgnoreCase("pluralityType"))
			if (FValue != null && !FValue.equals(""))
				pluralityType = FValue.trim();
			else
				pluralityType = null;
		if (FCode.equalsIgnoreCase("startWorkDate"))
			if (FValue != null && !FValue.equals(""))
				startWorkDate = fDate.getDate(FValue);
			else
				startWorkDate = null;
		if (FCode.equalsIgnoreCase("health"))
			if (FValue != null && !FValue.equals(""))
				health = FValue.trim();
			else
				health = null;
		if (FCode.equalsIgnoreCase("password"))
			if (FValue != null && !FValue.equals(""))
				password = FValue.trim();
			else
				password = null;
		if (FCode.equalsIgnoreCase("joinCompanyDate"))
			if (FValue != null && !FValue.equals(""))
				joinCompanyDate = fDate.getDate(FValue);
			else
				joinCompanyDate = null;
		if (FCode.equalsIgnoreCase("appntGrade"))
			if (FValue != null && !FValue.equals(""))
				appntGrade = FValue.trim();
			else
				appntGrade = null;
		if (FCode.equalsIgnoreCase("creditGrade"))
			if (FValue != null && !FValue.equals(""))
				creditGrade = FValue.trim();
			else
				creditGrade = null;
		if (FCode.equalsIgnoreCase("clientType"))
			if (FValue != null && !FValue.equals(""))
				clientType = FValue.trim();
			else
				clientType = null;
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("agentcode"))
			if (FValue != null && !FValue.equals(""))
				agentcode = FValue.trim();
			else
				agentcode = null;
		if (FCode.equalsIgnoreCase("signDate"))
			if (FValue != null && !FValue.equals(""))
				signDate = fDate.getDate(FValue);
			else
				signDate = null;
		if (FCode.equalsIgnoreCase("addrChoise"))
			if (FValue != null && !FValue.equals(""))
				addrChoise = FValue.trim();
			else
				addrChoise = null;
		if (FCode.equalsIgnoreCase("customeProperty"))
			if (FValue != null && !FValue.equals(""))
				customeProperty = FValue.trim();
			else
				customeProperty = null;
		if (FCode.equalsIgnoreCase("birthdayFlag"))
			if (FValue != null && !FValue.equals(""))
				birthdayFlag = FValue.trim();
			else
				birthdayFlag = null;
		if (FCode.equalsIgnoreCase("appellation"))
			if (FValue != null && !FValue.equals(""))
				appellation = FValue.trim();
			else
				appellation = null;
		if (FCode.equalsIgnoreCase("iDDNo"))
			if (FValue != null && !FValue.equals(""))
				iDDNo = FValue.trim();
			else
				iDDNo = null;
		if (FCode.equalsIgnoreCase("validityDate"))
			if (FValue != null && !FValue.equals(""))
				validityDate = fDate.getDate(FValue);
			else
				validityDate = null;
		if (FCode.equalsIgnoreCase("countryOrArea"))
			if (FValue != null && !FValue.equals(""))
				countryOrArea = FValue.trim();
			else
				countryOrArea = null;
		if (FCode.equalsIgnoreCase("specialDate"))
			if (FValue != null && !FValue.equals(""))
				specialDate = fDate.getDate(FValue);
			else
				specialDate = null;
		if (FCode.equalsIgnoreCase("deleteFlag"))
			if (FValue != null && !FValue.equals(""))
				deleteFlag = FValue.trim();
			else
				deleteFlag = null;
		if (FCode.equalsIgnoreCase("interest"))
			if (FValue != null && !FValue.equals(""))
				interest = FValue.trim();
			else
				interest = null;
		if (FCode.equalsIgnoreCase("customeType"))
			if (FValue != null && !FValue.equals(""))
				customeType = FValue.trim();
			else
				customeType = null;
		if (FCode.equalsIgnoreCase("introducer"))
			if (FValue != null && !FValue.equals(""))
				introducer = FValue.trim();
			else
				introducer = null;
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
		MNewClientSchema other = (MNewClientSchema)otherObject;
		if (customerNo == null && other.getCustomerNo() != null)
			return false;
		if (customerNo != null && !customerNo.equals(other.getCustomerNo()))
			return false;
		if (customerNo2 == null && other.getCustomerNo2() != null)
			return false;
		if (customerNo2 != null && !customerNo2.equals(other.getCustomerNo2()))
			return false;
		if (clientName == null && other.getClientName() != null)
			return false;
		if (clientName != null && !clientName.equals(other.getClientName()))
			return false;
		if (gender == null && other.getGender() != null)
			return false;
		if (gender != null && !gender.equals(other.getGender()))
			return false;
		if (birthday == null && other.getBirthday() != null)
			return false;
		if (birthday != null && !fDate.getString(birthday).equals(other.getBirthday()))
			return false;
		if (eMail == null && other.getEMail() != null)
			return false;
		if (eMail != null && !eMail.equals(other.getEMail()))
			return false;
		if (grpZipCode == null && other.getGrpZipCode() != null)
			return false;
		if (grpZipCode != null && !grpZipCode.equals(other.getGrpZipCode()))
			return false;
		if (grpAddress == null && other.getGrpAddress() != null)
			return false;
		if (grpAddress != null && !grpAddress.equals(other.getGrpAddress()))
			return false;
		if (grpNo == null && other.getGrpNo() != null)
			return false;
		if (grpNo != null && !grpNo.equals(other.getGrpNo()))
			return false;
		if (bP == null && other.getBP() != null)
			return false;
		if (bP != null && !bP.equals(other.getBP()))
			return false;
		if (grpAddressCode == null && other.getGrpAddressCode() != null)
			return false;
		if (grpAddressCode != null && !grpAddressCode.equals(other.getGrpAddressCode()))
			return false;
		if (phone2 == null && other.getPhone2() != null)
			return false;
		if (phone2 != null && !phone2.equals(other.getPhone2()))
			return false;
		if (grpName == null && other.getGrpName() != null)
			return false;
		if (grpName != null && !grpName.equals(other.getGrpName()))
			return false;
		if (grpPhone == null && other.getGrpPhone() != null)
			return false;
		if (grpPhone != null && !grpPhone.equals(other.getGrpPhone()))
			return false;
		if (phone == null && other.getPhone() != null)
			return false;
		if (phone != null && !phone.equals(other.getPhone()))
			return false;
		if (mobile == null && other.getMobile() != null)
			return false;
		if (mobile != null && !mobile.equals(other.getMobile()))
			return false;
		if (occupationCode == null && other.getOccupationCode() != null)
			return false;
		if (occupationCode != null && !occupationCode.equals(other.getOccupationCode()))
			return false;
		if (position == null && other.getPosition() != null)
			return false;
		if (position != null && !position.equals(other.getPosition()))
			return false;
		if (workType == null && other.getWorkType() != null)
			return false;
		if (workType != null && !workType.equals(other.getWorkType()))
			return false;
		if (occupationType == null && other.getOccupationType() != null)
			return false;
		if (occupationType != null && !occupationType.equals(other.getOccupationType()))
			return false;
		if (homeAddress == null && other.getHomeAddress() != null)
			return false;
		if (homeAddress != null && !homeAddress.equals(other.getHomeAddress()))
			return false;
		if (homeAddressCode == null && other.getHomeAddressCode() != null)
			return false;
		if (homeAddressCode != null && !homeAddressCode.equals(other.getHomeAddressCode()))
			return false;
		if (rgtAddress == null && other.getRgtAddress() != null)
			return false;
		if (rgtAddress != null && !rgtAddress.equals(other.getRgtAddress()))
			return false;
		if (postalAddress == null && other.getPostalAddress() != null)
			return false;
		if (postalAddress != null && !postalAddress.equals(other.getPostalAddress()))
			return false;
		if (zipCode == null && other.getZipCode() != null)
			return false;
		if (zipCode != null && !zipCode.equals(other.getZipCode()))
			return false;
		if (homeZipCode == null && other.getHomeZipCode() != null)
			return false;
		if (homeZipCode != null && !homeZipCode.equals(other.getHomeZipCode()))
			return false;
		if (sequenceNo == null && other.getSequenceNo() != null)
			return false;
		if (sequenceNo != null && !sequenceNo.equals(other.getSequenceNo()))
			return false;
		if (Double.doubleToLongBits(stature) != Double.doubleToLongBits(other.getStature()))
			return false;
		if (Double.doubleToLongBits(avoirdupois) != Double.doubleToLongBits(other.getAvoirdupois()))
			return false;
		if (smokeFlag == null && other.getSmokeFlag() != null)
			return false;
		if (smokeFlag != null && !smokeFlag.equals(other.getSmokeFlag()))
			return false;
		if (deathDate == null && other.getDeathDate() != null)
			return false;
		if (deathDate != null && !fDate.getString(deathDate).equals(other.getDeathDate()))
			return false;
		if (marriage == null && other.getMarriage() != null)
			return false;
		if (marriage != null && !marriage.equals(other.getMarriage()))
			return false;
		if (credentType == null && other.getCredentType() != null)
			return false;
		if (credentType != null && !credentType.equals(other.getCredentType()))
			return false;
		if (credentNO == null && other.getCredentNO() != null)
			return false;
		if (credentNO != null && !credentNO.equals(other.getCredentNO()))
			return false;
		if (othIDNo == null && other.getOthIDNo() != null)
			return false;
		if (othIDNo != null && !othIDNo.equals(other.getOthIDNo()))
			return false;
		if (othIDType == null && other.getOthIDType() != null)
			return false;
		if (othIDType != null && !othIDType.equals(other.getOthIDType()))
			return false;
		if (iCNo == null && other.getICNo() != null)
			return false;
		if (iCNo != null && !iCNo.equals(other.getICNo()))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.getSalary()))
			return false;
		if (Double.doubleToLongBits(yearSalary) != Double.doubleToLongBits(other.getYearSalary()))
			return false;
		if (nativePlace == null && other.getNativePlace() != null)
			return false;
		if (nativePlace != null && !nativePlace.equals(other.getNativePlace()))
			return false;
		if (nationality == null && other.getNationality() != null)
			return false;
		if (nationality != null && !nationality.equals(other.getNationality()))
			return false;
		if (marriageDate == null && other.getMarriageDate() != null)
			return false;
		if (marriageDate != null && !fDate.getString(marriageDate).equals(other.getMarriageDate()))
			return false;
		if (degree == null && other.getDegree() != null)
			return false;
		if (degree != null && !degree.equals(other.getDegree()))
			return false;
		if (polNo == null && other.getPolNo() != null)
			return false;
		if (polNo != null && !polNo.equals(other.getPolNo()))
			return false;
		if (relationToInsured == null && other.getRelationToInsured() != null)
			return false;
		if (relationToInsured != null && !relationToInsured.equals(other.getRelationToInsured()))
			return false;
		if (pluralityType == null && other.getPluralityType() != null)
			return false;
		if (pluralityType != null && !pluralityType.equals(other.getPluralityType()))
			return false;
		if (startWorkDate == null && other.getStartWorkDate() != null)
			return false;
		if (startWorkDate != null && !fDate.getString(startWorkDate).equals(other.getStartWorkDate()))
			return false;
		if (health == null && other.getHealth() != null)
			return false;
		if (health != null && !health.equals(other.getHealth()))
			return false;
		if (password == null && other.getPassword() != null)
			return false;
		if (password != null && !password.equals(other.getPassword()))
			return false;
		if (joinCompanyDate == null && other.getJoinCompanyDate() != null)
			return false;
		if (joinCompanyDate != null && !fDate.getString(joinCompanyDate).equals(other.getJoinCompanyDate()))
			return false;
		if (appntGrade == null && other.getAppntGrade() != null)
			return false;
		if (appntGrade != null && !appntGrade.equals(other.getAppntGrade()))
			return false;
		if (creditGrade == null && other.getCreditGrade() != null)
			return false;
		if (creditGrade != null && !creditGrade.equals(other.getCreditGrade()))
			return false;
		if (clientType == null && other.getClientType() != null)
			return false;
		if (clientType != null && !clientType.equals(other.getClientType()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (agentcode == null && other.getAgentcode() != null)
			return false;
		if (agentcode != null && !agentcode.equals(other.getAgentcode()))
			return false;
		if (signDate == null && other.getSignDate() != null)
			return false;
		if (signDate != null && !fDate.getString(signDate).equals(other.getSignDate()))
			return false;
		if (addrChoise == null && other.getAddrChoise() != null)
			return false;
		if (addrChoise != null && !addrChoise.equals(other.getAddrChoise()))
			return false;
		if (customeProperty == null && other.getCustomeProperty() != null)
			return false;
		if (customeProperty != null && !customeProperty.equals(other.getCustomeProperty()))
			return false;
		if (birthdayFlag == null && other.getBirthdayFlag() != null)
			return false;
		if (birthdayFlag != null && !birthdayFlag.equals(other.getBirthdayFlag()))
			return false;
		if (appellation == null && other.getAppellation() != null)
			return false;
		if (appellation != null && !appellation.equals(other.getAppellation()))
			return false;
		if (iDDNo == null && other.getIDDNo() != null)
			return false;
		if (iDDNo != null && !iDDNo.equals(other.getIDDNo()))
			return false;
		if (validityDate == null && other.getValidityDate() != null)
			return false;
		if (validityDate != null && !fDate.getString(validityDate).equals(other.getValidityDate()))
			return false;
		if (countryOrArea == null && other.getCountryOrArea() != null)
			return false;
		if (countryOrArea != null && !countryOrArea.equals(other.getCountryOrArea()))
			return false;
		if (specialDate == null && other.getSpecialDate() != null)
			return false;
		if (specialDate != null && !fDate.getString(specialDate).equals(other.getSpecialDate()))
			return false;
		if (deleteFlag == null && other.getDeleteFlag() != null)
			return false;
		if (deleteFlag != null && !deleteFlag.equals(other.getDeleteFlag()))
			return false;
		if (interest == null && other.getInterest() != null)
			return false;
		if (interest != null && !interest.equals(other.getInterest()))
			return false;
		if (customeType == null && other.getCustomeType() != null)
			return false;
		if (customeType != null && !customeType.equals(other.getCustomeType()))
			return false;
		if (introducer == null && other.getIntroducer() != null)
			return false;
		if (introducer != null && !introducer.equals(other.getIntroducer()))
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
		return 73;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("customerNo"))
			return 0;
		if (strFieldName.equals("customerNo2"))
			return 1;
		if (strFieldName.equals("clientName"))
			return 2;
		if (strFieldName.equals("gender"))
			return 3;
		if (strFieldName.equals("birthday"))
			return 4;
		if (strFieldName.equals("eMail"))
			return 5;
		if (strFieldName.equals("grpZipCode"))
			return 6;
		if (strFieldName.equals("grpAddress"))
			return 7;
		if (strFieldName.equals("grpNo"))
			return 8;
		if (strFieldName.equals("bP"))
			return 9;
		if (strFieldName.equals("grpAddressCode"))
			return 10;
		if (strFieldName.equals("phone2"))
			return 11;
		if (strFieldName.equals("grpName"))
			return 12;
		if (strFieldName.equals("grpPhone"))
			return 13;
		if (strFieldName.equals("phone"))
			return 14;
		if (strFieldName.equals("mobile"))
			return 15;
		if (strFieldName.equals("occupationCode"))
			return 16;
		if (strFieldName.equals("position"))
			return 17;
		if (strFieldName.equals("workType"))
			return 18;
		if (strFieldName.equals("occupationType"))
			return 19;
		if (strFieldName.equals("homeAddress"))
			return 20;
		if (strFieldName.equals("homeAddressCode"))
			return 21;
		if (strFieldName.equals("rgtAddress"))
			return 22;
		if (strFieldName.equals("postalAddress"))
			return 23;
		if (strFieldName.equals("zipCode"))
			return 24;
		if (strFieldName.equals("homeZipCode"))
			return 25;
		if (strFieldName.equals("sequenceNo"))
			return 26;
		if (strFieldName.equals("stature"))
			return 27;
		if (strFieldName.equals("avoirdupois"))
			return 28;
		if (strFieldName.equals("smokeFlag"))
			return 29;
		if (strFieldName.equals("deathDate"))
			return 30;
		if (strFieldName.equals("marriage"))
			return 31;
		if (strFieldName.equals("credentType"))
			return 32;
		if (strFieldName.equals("credentNO"))
			return 33;
		if (strFieldName.equals("othIDNo"))
			return 34;
		if (strFieldName.equals("othIDType"))
			return 35;
		if (strFieldName.equals("iCNo"))
			return 36;
		if (strFieldName.equals("salary"))
			return 37;
		if (strFieldName.equals("yearSalary"))
			return 38;
		if (strFieldName.equals("nativePlace"))
			return 39;
		if (strFieldName.equals("nationality"))
			return 40;
		if (strFieldName.equals("marriageDate"))
			return 41;
		if (strFieldName.equals("degree"))
			return 42;
		if (strFieldName.equals("polNo"))
			return 43;
		if (strFieldName.equals("relationToInsured"))
			return 44;
		if (strFieldName.equals("pluralityType"))
			return 45;
		if (strFieldName.equals("startWorkDate"))
			return 46;
		if (strFieldName.equals("health"))
			return 47;
		if (strFieldName.equals("password"))
			return 48;
		if (strFieldName.equals("joinCompanyDate"))
			return 49;
		if (strFieldName.equals("appntGrade"))
			return 50;
		if (strFieldName.equals("creditGrade"))
			return 51;
		if (strFieldName.equals("clientType"))
			return 52;
		if (strFieldName.equals("state"))
			return 53;
		if (strFieldName.equals("agentcode"))
			return 54;
		if (strFieldName.equals("signDate"))
			return 55;
		if (strFieldName.equals("addrChoise"))
			return 56;
		if (strFieldName.equals("customeProperty"))
			return 57;
		if (strFieldName.equals("birthdayFlag"))
			return 58;
		if (strFieldName.equals("appellation"))
			return 59;
		if (strFieldName.equals("iDDNo"))
			return 60;
		if (strFieldName.equals("validityDate"))
			return 61;
		if (strFieldName.equals("countryOrArea"))
			return 62;
		if (strFieldName.equals("specialDate"))
			return 63;
		if (strFieldName.equals("deleteFlag"))
			return 64;
		if (strFieldName.equals("interest"))
			return 65;
		if (strFieldName.equals("customeType"))
			return 66;
		if (strFieldName.equals("introducer"))
			return 67;
		if (strFieldName.equals("operator"))
			return 68;
		if (strFieldName.equals("makeDate"))
			return 69;
		if (strFieldName.equals("makeTime"))
			return 70;
		if (strFieldName.equals("modifyDate"))
			return 71;
		return !strFieldName.equals("modifyTime") ? -1 : 72;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "customerNo";
			break;

		case 1: // '\001'
			strFieldName = "customerNo2";
			break;

		case 2: // '\002'
			strFieldName = "clientName";
			break;

		case 3: // '\003'
			strFieldName = "gender";
			break;

		case 4: // '\004'
			strFieldName = "birthday";
			break;

		case 5: // '\005'
			strFieldName = "eMail";
			break;

		case 6: // '\006'
			strFieldName = "grpZipCode";
			break;

		case 7: // '\007'
			strFieldName = "grpAddress";
			break;

		case 8: // '\b'
			strFieldName = "grpNo";
			break;

		case 9: // '\t'
			strFieldName = "bP";
			break;

		case 10: // '\n'
			strFieldName = "grpAddressCode";
			break;

		case 11: // '\013'
			strFieldName = "phone2";
			break;

		case 12: // '\f'
			strFieldName = "grpName";
			break;

		case 13: // '\r'
			strFieldName = "grpPhone";
			break;

		case 14: // '\016'
			strFieldName = "phone";
			break;

		case 15: // '\017'
			strFieldName = "mobile";
			break;

		case 16: // '\020'
			strFieldName = "occupationCode";
			break;

		case 17: // '\021'
			strFieldName = "position";
			break;

		case 18: // '\022'
			strFieldName = "workType";
			break;

		case 19: // '\023'
			strFieldName = "occupationType";
			break;

		case 20: // '\024'
			strFieldName = "homeAddress";
			break;

		case 21: // '\025'
			strFieldName = "homeAddressCode";
			break;

		case 22: // '\026'
			strFieldName = "rgtAddress";
			break;

		case 23: // '\027'
			strFieldName = "postalAddress";
			break;

		case 24: // '\030'
			strFieldName = "zipCode";
			break;

		case 25: // '\031'
			strFieldName = "homeZipCode";
			break;

		case 26: // '\032'
			strFieldName = "sequenceNo";
			break;

		case 27: // '\033'
			strFieldName = "stature";
			break;

		case 28: // '\034'
			strFieldName = "avoirdupois";
			break;

		case 29: // '\035'
			strFieldName = "smokeFlag";
			break;

		case 30: // '\036'
			strFieldName = "deathDate";
			break;

		case 31: // '\037'
			strFieldName = "marriage";
			break;

		case 32: // ' '
			strFieldName = "credentType";
			break;

		case 33: // '!'
			strFieldName = "credentNO";
			break;

		case 34: // '"'
			strFieldName = "othIDNo";
			break;

		case 35: // '#'
			strFieldName = "othIDType";
			break;

		case 36: // '$'
			strFieldName = "iCNo";
			break;

		case 37: // '%'
			strFieldName = "salary";
			break;

		case 38: // '&'
			strFieldName = "yearSalary";
			break;

		case 39: // '\''
			strFieldName = "nativePlace";
			break;

		case 40: // '('
			strFieldName = "nationality";
			break;

		case 41: // ')'
			strFieldName = "marriageDate";
			break;

		case 42: // '*'
			strFieldName = "degree";
			break;

		case 43: // '+'
			strFieldName = "polNo";
			break;

		case 44: // ','
			strFieldName = "relationToInsured";
			break;

		case 45: // '-'
			strFieldName = "pluralityType";
			break;

		case 46: // '.'
			strFieldName = "startWorkDate";
			break;

		case 47: // '/'
			strFieldName = "health";
			break;

		case 48: // '0'
			strFieldName = "password";
			break;

		case 49: // '1'
			strFieldName = "joinCompanyDate";
			break;

		case 50: // '2'
			strFieldName = "appntGrade";
			break;

		case 51: // '3'
			strFieldName = "creditGrade";
			break;

		case 52: // '4'
			strFieldName = "clientType";
			break;

		case 53: // '5'
			strFieldName = "state";
			break;

		case 54: // '6'
			strFieldName = "agentcode";
			break;

		case 55: // '7'
			strFieldName = "signDate";
			break;

		case 56: // '8'
			strFieldName = "addrChoise";
			break;

		case 57: // '9'
			strFieldName = "customeProperty";
			break;

		case 58: // ':'
			strFieldName = "birthdayFlag";
			break;

		case 59: // ';'
			strFieldName = "appellation";
			break;

		case 60: // '<'
			strFieldName = "iDDNo";
			break;

		case 61: // '='
			strFieldName = "validityDate";
			break;

		case 62: // '>'
			strFieldName = "countryOrArea";
			break;

		case 63: // '?'
			strFieldName = "specialDate";
			break;

		case 64: // '@'
			strFieldName = "deleteFlag";
			break;

		case 65: // 'A'
			strFieldName = "interest";
			break;

		case 66: // 'B'
			strFieldName = "customeType";
			break;

		case 67: // 'C'
			strFieldName = "introducer";
			break;

		case 68: // 'D'
			strFieldName = "operator";
			break;

		case 69: // 'E'
			strFieldName = "makeDate";
			break;

		case 70: // 'F'
			strFieldName = "makeTime";
			break;

		case 71: // 'G'
			strFieldName = "modifyDate";
			break;

		case 72: // 'H'
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
		if (strFieldName.equals("customerNo"))
			return 0;
		if (strFieldName.equals("customerNo2"))
			return 0;
		if (strFieldName.equals("clientName"))
			return 0;
		if (strFieldName.equals("gender"))
			return 0;
		if (strFieldName.equals("birthday"))
			return 1;
		if (strFieldName.equals("eMail"))
			return 0;
		if (strFieldName.equals("grpZipCode"))
			return 0;
		if (strFieldName.equals("grpAddress"))
			return 0;
		if (strFieldName.equals("grpNo"))
			return 0;
		if (strFieldName.equals("bP"))
			return 0;
		if (strFieldName.equals("grpAddressCode"))
			return 0;
		if (strFieldName.equals("phone2"))
			return 0;
		if (strFieldName.equals("grpName"))
			return 0;
		if (strFieldName.equals("grpPhone"))
			return 0;
		if (strFieldName.equals("phone"))
			return 0;
		if (strFieldName.equals("mobile"))
			return 0;
		if (strFieldName.equals("occupationCode"))
			return 0;
		if (strFieldName.equals("position"))
			return 0;
		if (strFieldName.equals("workType"))
			return 0;
		if (strFieldName.equals("occupationType"))
			return 0;
		if (strFieldName.equals("homeAddress"))
			return 0;
		if (strFieldName.equals("homeAddressCode"))
			return 0;
		if (strFieldName.equals("rgtAddress"))
			return 0;
		if (strFieldName.equals("postalAddress"))
			return 0;
		if (strFieldName.equals("zipCode"))
			return 0;
		if (strFieldName.equals("homeZipCode"))
			return 0;
		if (strFieldName.equals("sequenceNo"))
			return 0;
		if (strFieldName.equals("stature"))
			return 4;
		if (strFieldName.equals("avoirdupois"))
			return 4;
		if (strFieldName.equals("smokeFlag"))
			return 0;
		if (strFieldName.equals("deathDate"))
			return 1;
		if (strFieldName.equals("marriage"))
			return 0;
		if (strFieldName.equals("credentType"))
			return 0;
		if (strFieldName.equals("credentNO"))
			return 0;
		if (strFieldName.equals("othIDNo"))
			return 0;
		if (strFieldName.equals("othIDType"))
			return 0;
		if (strFieldName.equals("iCNo"))
			return 0;
		if (strFieldName.equals("salary"))
			return 4;
		if (strFieldName.equals("yearSalary"))
			return 4;
		if (strFieldName.equals("nativePlace"))
			return 0;
		if (strFieldName.equals("nationality"))
			return 0;
		if (strFieldName.equals("marriageDate"))
			return 1;
		if (strFieldName.equals("degree"))
			return 0;
		if (strFieldName.equals("polNo"))
			return 0;
		if (strFieldName.equals("relationToInsured"))
			return 0;
		if (strFieldName.equals("pluralityType"))
			return 0;
		if (strFieldName.equals("startWorkDate"))
			return 1;
		if (strFieldName.equals("health"))
			return 0;
		if (strFieldName.equals("password"))
			return 0;
		if (strFieldName.equals("joinCompanyDate"))
			return 1;
		if (strFieldName.equals("appntGrade"))
			return 0;
		if (strFieldName.equals("creditGrade"))
			return 0;
		if (strFieldName.equals("clientType"))
			return 0;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("agentcode"))
			return 0;
		if (strFieldName.equals("signDate"))
			return 1;
		if (strFieldName.equals("addrChoise"))
			return 0;
		if (strFieldName.equals("customeProperty"))
			return 0;
		if (strFieldName.equals("birthdayFlag"))
			return 0;
		if (strFieldName.equals("appellation"))
			return 0;
		if (strFieldName.equals("iDDNo"))
			return 0;
		if (strFieldName.equals("validityDate"))
			return 1;
		if (strFieldName.equals("countryOrArea"))
			return 0;
		if (strFieldName.equals("specialDate"))
			return 1;
		if (strFieldName.equals("deleteFlag"))
			return 0;
		if (strFieldName.equals("interest"))
			return 0;
		if (strFieldName.equals("customeType"))
			return 0;
		if (strFieldName.equals("introducer"))
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
			nFieldType = 1;
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
			nFieldType = 4;
			break;

		case 28: // '\034'
			nFieldType = 4;
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

		case 34: // '"'
			nFieldType = 0;
			break;

		case 35: // '#'
			nFieldType = 0;
			break;

		case 36: // '$'
			nFieldType = 0;
			break;

		case 37: // '%'
			nFieldType = 4;
			break;

		case 38: // '&'
			nFieldType = 4;
			break;

		case 39: // '\''
			nFieldType = 0;
			break;

		case 40: // '('
			nFieldType = 0;
			break;

		case 41: // ')'
			nFieldType = 1;
			break;

		case 42: // '*'
			nFieldType = 0;
			break;

		case 43: // '+'
			nFieldType = 0;
			break;

		case 44: // ','
			nFieldType = 0;
			break;

		case 45: // '-'
			nFieldType = 0;
			break;

		case 46: // '.'
			nFieldType = 1;
			break;

		case 47: // '/'
			nFieldType = 0;
			break;

		case 48: // '0'
			nFieldType = 0;
			break;

		case 49: // '1'
			nFieldType = 1;
			break;

		case 50: // '2'
			nFieldType = 0;
			break;

		case 51: // '3'
			nFieldType = 0;
			break;

		case 52: // '4'
			nFieldType = 0;
			break;

		case 53: // '5'
			nFieldType = 0;
			break;

		case 54: // '6'
			nFieldType = 0;
			break;

		case 55: // '7'
			nFieldType = 1;
			break;

		case 56: // '8'
			nFieldType = 0;
			break;

		case 57: // '9'
			nFieldType = 0;
			break;

		case 58: // ':'
			nFieldType = 0;
			break;

		case 59: // ';'
			nFieldType = 0;
			break;

		case 60: // '<'
			nFieldType = 0;
			break;

		case 61: // '='
			nFieldType = 1;
			break;

		case 62: // '>'
			nFieldType = 0;
			break;

		case 63: // '?'
			nFieldType = 1;
			break;

		case 64: // '@'
			nFieldType = 0;
			break;

		case 65: // 'A'
			nFieldType = 0;
			break;

		case 66: // 'B'
			nFieldType = 0;
			break;

		case 67: // 'C'
			nFieldType = 0;
			break;

		case 68: // 'D'
			nFieldType = 0;
			break;

		case 69: // 'E'
			nFieldType = 1;
			break;

		case 70: // 'F'
			nFieldType = 0;
			break;

		case 71: // 'G'
			nFieldType = 1;
			break;

		case 72: // 'H'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
