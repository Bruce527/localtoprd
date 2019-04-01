// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsuredSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPInsuredDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPInsuredSchema
	implements Schema, Cloneable
{

	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private String insuredNo;
	private String insuredId;
	private String prtNo;
	private String appntNo;
	private String appntId;
	private String manageCom;
	private String signCity;
	private String executeCom;
	private String familyID;
	private String relationToMainInsured;
	private String relationToAppnt;
	private String addressNo;
	private String sequenceNo;
	private String name;
	private String appellation;
	private String sex;
	private Date birthday;
	private int appAge;
	private String appAgeType;
	private String iDType;
	private String iDNo;
	private Date iDValidity;
	private String iDPerpetual;
	private String nativePlace;
	private String nationality;
	private String rgtAddress;
	private String marriage;
	private Date marriageDate;
	private String health;
	private double stature;
	private double avoirdupois;
	private String degree;
	private String creditGrade;
	private String bankCode;
	private String bankAccNo;
	private String accName;
	private Date joinCompanyDate;
	private Date startWorkDate;
	private String position;
	private double salary;
	private String occupationType;
	private String occupationCode;
	private String partOccupationType;
	private String partOccupationCode;
	private String workType;
	private String pluralityType;
	private String smokeFlag;
	private String contPlanCode;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private int insuredPeoples;
	public static final int FIELDNUM = 57;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPInsuredSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "ContNo";
		pk[1] = "InsuredId";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPInsuredSchema cloned = (LNPInsuredSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getGrpContNo()
	{
		return grpContNo;
	}

	public void setGrpContNo(String aGrpContNo)
	{
		grpContNo = aGrpContNo;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String aContNo)
	{
		contNo = aContNo;
	}

	public String getProposalContNo()
	{
		return proposalContNo;
	}

	public void setProposalContNo(String aProposalContNo)
	{
		proposalContNo = aProposalContNo;
	}

	public String getInsuredNo()
	{
		return insuredNo;
	}

	public void setInsuredNo(String aInsuredNo)
	{
		insuredNo = aInsuredNo;
	}

	public String getInsuredId()
	{
		return insuredId;
	}

	public void setInsuredId(String aInsuredId)
	{
		insuredId = aInsuredId;
	}

	public String getPrtNo()
	{
		return prtNo;
	}

	public void setPrtNo(String aPrtNo)
	{
		prtNo = aPrtNo;
	}

	public String getAppntNo()
	{
		return appntNo;
	}

	public void setAppntNo(String aAppntNo)
	{
		appntNo = aAppntNo;
	}

	public String getAppntId()
	{
		return appntId;
	}

	public void setAppntId(String aAppntId)
	{
		appntId = aAppntId;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getSignCity()
	{
		return signCity;
	}

	public void setSignCity(String aSignCity)
	{
		signCity = aSignCity;
	}

	public String getExecuteCom()
	{
		return executeCom;
	}

	public void setExecuteCom(String aExecuteCom)
	{
		executeCom = aExecuteCom;
	}

	public String getFamilyID()
	{
		return familyID;
	}

	public void setFamilyID(String aFamilyID)
	{
		familyID = aFamilyID;
	}

	public String getRelationToMainInsured()
	{
		return relationToMainInsured;
	}

	public void setRelationToMainInsured(String aRelationToMainInsured)
	{
		relationToMainInsured = aRelationToMainInsured;
	}

	public String getRelationToAppnt()
	{
		return relationToAppnt;
	}

	public void setRelationToAppnt(String aRelationToAppnt)
	{
		relationToAppnt = aRelationToAppnt;
	}

	public String getAddressNo()
	{
		return addressNo;
	}

	public void setAddressNo(String aAddressNo)
	{
		addressNo = aAddressNo;
	}

	public String getSequenceNo()
	{
		return sequenceNo;
	}

	public void setSequenceNo(String aSequenceNo)
	{
		sequenceNo = aSequenceNo;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String aName)
	{
		name = aName;
	}

	public String getAppellation()
	{
		return appellation;
	}

	public void setAppellation(String aAppellation)
	{
		appellation = aAppellation;
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

	public int getAppAge()
	{
		return appAge;
	}

	public void setAppAge(int aAppAge)
	{
		appAge = aAppAge;
	}

	public void setAppAge(String aAppAge)
	{
		if (aAppAge != null && !aAppAge.equals(""))
		{
			Integer tInteger = new Integer(aAppAge);
			int i = tInteger.intValue();
			appAge = i;
		}
	}

	public String getAppAgeType()
	{
		return appAgeType;
	}

	public void setAppAgeType(String aAppAgeType)
	{
		appAgeType = aAppAgeType;
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

	public String getIDValidity()
	{
		if (iDValidity != null)
			return fDate.getString(iDValidity);
		else
			return null;
	}

	public void setIDValidity(Date aIDValidity)
	{
		iDValidity = aIDValidity;
	}

	public void setIDValidity(String aIDValidity)
	{
		if (aIDValidity != null && !aIDValidity.equals(""))
			iDValidity = fDate.getDate(aIDValidity);
		else
			iDValidity = null;
	}

	public String getIDPerpetual()
	{
		return iDPerpetual;
	}

	public void setIDPerpetual(String aIDPerpetual)
	{
		iDPerpetual = aIDPerpetual;
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

	public String getRgtAddress()
	{
		return rgtAddress;
	}

	public void setRgtAddress(String aRgtAddress)
	{
		rgtAddress = aRgtAddress;
	}

	public String getMarriage()
	{
		return marriage;
	}

	public void setMarriage(String aMarriage)
	{
		marriage = aMarriage;
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

	public String getHealth()
	{
		return health;
	}

	public void setHealth(String aHealth)
	{
		health = aHealth;
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

	public String getDegree()
	{
		return degree;
	}

	public void setDegree(String aDegree)
	{
		degree = aDegree;
	}

	public String getCreditGrade()
	{
		return creditGrade;
	}

	public void setCreditGrade(String aCreditGrade)
	{
		creditGrade = aCreditGrade;
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

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String aPosition)
	{
		position = aPosition;
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

	public String getOccupationType()
	{
		return occupationType;
	}

	public void setOccupationType(String aOccupationType)
	{
		occupationType = aOccupationType;
	}

	public String getOccupationCode()
	{
		return occupationCode;
	}

	public void setOccupationCode(String aOccupationCode)
	{
		occupationCode = aOccupationCode;
	}

	public String getPartOccupationType()
	{
		return partOccupationType;
	}

	public void setPartOccupationType(String aPartOccupationType)
	{
		partOccupationType = aPartOccupationType;
	}

	public String getPartOccupationCode()
	{
		return partOccupationCode;
	}

	public void setPartOccupationCode(String aPartOccupationCode)
	{
		partOccupationCode = aPartOccupationCode;
	}

	public String getWorkType()
	{
		return workType;
	}

	public void setWorkType(String aWorkType)
	{
		workType = aWorkType;
	}

	public String getPluralityType()
	{
		return pluralityType;
	}

	public void setPluralityType(String aPluralityType)
	{
		pluralityType = aPluralityType;
	}

	public String getSmokeFlag()
	{
		return smokeFlag;
	}

	public void setSmokeFlag(String aSmokeFlag)
	{
		smokeFlag = aSmokeFlag;
	}

	public String getContPlanCode()
	{
		return contPlanCode;
	}

	public void setContPlanCode(String aContPlanCode)
	{
		contPlanCode = aContPlanCode;
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

	public int getInsuredPeoples()
	{
		return insuredPeoples;
	}

	public void setInsuredPeoples(int aInsuredPeoples)
	{
		insuredPeoples = aInsuredPeoples;
	}

	public void setInsuredPeoples(String aInsuredPeoples)
	{
		if (aInsuredPeoples != null && !aInsuredPeoples.equals(""))
		{
			Integer tInteger = new Integer(aInsuredPeoples);
			int i = tInteger.intValue();
			insuredPeoples = i;
		}
	}

	public void setSchema(LNPInsuredSchema aLNPInsuredSchema)
	{
		grpContNo = aLNPInsuredSchema.getGrpContNo();
		contNo = aLNPInsuredSchema.getContNo();
		proposalContNo = aLNPInsuredSchema.getProposalContNo();
		insuredNo = aLNPInsuredSchema.getInsuredNo();
		insuredId = aLNPInsuredSchema.getInsuredId();
		prtNo = aLNPInsuredSchema.getPrtNo();
		appntNo = aLNPInsuredSchema.getAppntNo();
		appntId = aLNPInsuredSchema.getAppntId();
		manageCom = aLNPInsuredSchema.getManageCom();
		signCity = aLNPInsuredSchema.getSignCity();
		executeCom = aLNPInsuredSchema.getExecuteCom();
		familyID = aLNPInsuredSchema.getFamilyID();
		relationToMainInsured = aLNPInsuredSchema.getRelationToMainInsured();
		relationToAppnt = aLNPInsuredSchema.getRelationToAppnt();
		addressNo = aLNPInsuredSchema.getAddressNo();
		sequenceNo = aLNPInsuredSchema.getSequenceNo();
		name = aLNPInsuredSchema.getName();
		appellation = aLNPInsuredSchema.getAppellation();
		sex = aLNPInsuredSchema.getSex();
		birthday = fDate.getDate(aLNPInsuredSchema.getBirthday());
		appAge = aLNPInsuredSchema.getAppAge();
		appAgeType = aLNPInsuredSchema.getAppAgeType();
		iDType = aLNPInsuredSchema.getIDType();
		iDNo = aLNPInsuredSchema.getIDNo();
		iDValidity = fDate.getDate(aLNPInsuredSchema.getIDValidity());
		iDPerpetual = aLNPInsuredSchema.getIDPerpetual();
		nativePlace = aLNPInsuredSchema.getNativePlace();
		nationality = aLNPInsuredSchema.getNationality();
		rgtAddress = aLNPInsuredSchema.getRgtAddress();
		marriage = aLNPInsuredSchema.getMarriage();
		marriageDate = fDate.getDate(aLNPInsuredSchema.getMarriageDate());
		health = aLNPInsuredSchema.getHealth();
		stature = aLNPInsuredSchema.getStature();
		avoirdupois = aLNPInsuredSchema.getAvoirdupois();
		degree = aLNPInsuredSchema.getDegree();
		creditGrade = aLNPInsuredSchema.getCreditGrade();
		bankCode = aLNPInsuredSchema.getBankCode();
		bankAccNo = aLNPInsuredSchema.getBankAccNo();
		accName = aLNPInsuredSchema.getAccName();
		joinCompanyDate = fDate.getDate(aLNPInsuredSchema.getJoinCompanyDate());
		startWorkDate = fDate.getDate(aLNPInsuredSchema.getStartWorkDate());
		position = aLNPInsuredSchema.getPosition();
		salary = aLNPInsuredSchema.getSalary();
		occupationType = aLNPInsuredSchema.getOccupationType();
		occupationCode = aLNPInsuredSchema.getOccupationCode();
		partOccupationType = aLNPInsuredSchema.getPartOccupationType();
		partOccupationCode = aLNPInsuredSchema.getPartOccupationCode();
		workType = aLNPInsuredSchema.getWorkType();
		pluralityType = aLNPInsuredSchema.getPluralityType();
		smokeFlag = aLNPInsuredSchema.getSmokeFlag();
		contPlanCode = aLNPInsuredSchema.getContPlanCode();
		operator = aLNPInsuredSchema.getOperator();
		makeDate = fDate.getDate(aLNPInsuredSchema.getMakeDate());
		makeTime = aLNPInsuredSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPInsuredSchema.getModifyDate());
		modifyTime = aLNPInsuredSchema.getModifyTime();
		insuredPeoples = aLNPInsuredSchema.getInsuredPeoples();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("GrpContNo") == null)
				grpContNo = null;
			else
				grpContNo = rs.getString("GrpContNo").trim();
			if (rs.getString("ContNo") == null)
				contNo = null;
			else
				contNo = rs.getString("ContNo").trim();
			if (rs.getString("ProposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("ProposalContNo").trim();
			if (rs.getString("InsuredNo") == null)
				insuredNo = null;
			else
				insuredNo = rs.getString("InsuredNo").trim();
			if (rs.getString("InsuredId") == null)
				insuredId = null;
			else
				insuredId = rs.getString("InsuredId").trim();
			if (rs.getString("PrtNo") == null)
				prtNo = null;
			else
				prtNo = rs.getString("PrtNo").trim();
			if (rs.getString("AppntNo") == null)
				appntNo = null;
			else
				appntNo = rs.getString("AppntNo").trim();
			if (rs.getString("AppntId") == null)
				appntId = null;
			else
				appntId = rs.getString("AppntId").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("SignCity") == null)
				signCity = null;
			else
				signCity = rs.getString("SignCity").trim();
			if (rs.getString("ExecuteCom") == null)
				executeCom = null;
			else
				executeCom = rs.getString("ExecuteCom").trim();
			if (rs.getString("FamilyID") == null)
				familyID = null;
			else
				familyID = rs.getString("FamilyID").trim();
			if (rs.getString("RelationToMainInsured") == null)
				relationToMainInsured = null;
			else
				relationToMainInsured = rs.getString("RelationToMainInsured").trim();
			if (rs.getString("RelationToAppnt") == null)
				relationToAppnt = null;
			else
				relationToAppnt = rs.getString("RelationToAppnt").trim();
			if (rs.getString("AddressNo") == null)
				addressNo = null;
			else
				addressNo = rs.getString("AddressNo").trim();
			if (rs.getString("SequenceNo") == null)
				sequenceNo = null;
			else
				sequenceNo = rs.getString("SequenceNo").trim();
			if (rs.getString("Name") == null)
				name = null;
			else
				name = rs.getString("Name").trim();
			if (rs.getString("Appellation") == null)
				appellation = null;
			else
				appellation = rs.getString("Appellation").trim();
			if (rs.getString("Sex") == null)
				sex = null;
			else
				sex = rs.getString("Sex").trim();
			birthday = rs.getDate("Birthday");
			appAge = rs.getInt("AppAge");
			if (rs.getString("AppAgeType") == null)
				appAgeType = null;
			else
				appAgeType = rs.getString("AppAgeType").trim();
			if (rs.getString("IDType") == null)
				iDType = null;
			else
				iDType = rs.getString("IDType").trim();
			if (rs.getString("IDNo") == null)
				iDNo = null;
			else
				iDNo = rs.getString("IDNo").trim();
			iDValidity = rs.getDate("IDValidity");
			if (rs.getString("IDPerpetual") == null)
				iDPerpetual = null;
			else
				iDPerpetual = rs.getString("IDPerpetual").trim();
			if (rs.getString("NativePlace") == null)
				nativePlace = null;
			else
				nativePlace = rs.getString("NativePlace").trim();
			if (rs.getString("Nationality") == null)
				nationality = null;
			else
				nationality = rs.getString("Nationality").trim();
			if (rs.getString("RgtAddress") == null)
				rgtAddress = null;
			else
				rgtAddress = rs.getString("RgtAddress").trim();
			if (rs.getString("Marriage") == null)
				marriage = null;
			else
				marriage = rs.getString("Marriage").trim();
			marriageDate = rs.getDate("MarriageDate");
			if (rs.getString("Health") == null)
				health = null;
			else
				health = rs.getString("Health").trim();
			stature = rs.getDouble("Stature");
			avoirdupois = rs.getDouble("Avoirdupois");
			if (rs.getString("Degree") == null)
				degree = null;
			else
				degree = rs.getString("Degree").trim();
			if (rs.getString("CreditGrade") == null)
				creditGrade = null;
			else
				creditGrade = rs.getString("CreditGrade").trim();
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
			joinCompanyDate = rs.getDate("JoinCompanyDate");
			startWorkDate = rs.getDate("StartWorkDate");
			if (rs.getString("Position") == null)
				position = null;
			else
				position = rs.getString("Position").trim();
			salary = rs.getDouble("Salary");
			if (rs.getString("OccupationType") == null)
				occupationType = null;
			else
				occupationType = rs.getString("OccupationType").trim();
			if (rs.getString("OccupationCode") == null)
				occupationCode = null;
			else
				occupationCode = rs.getString("OccupationCode").trim();
			if (rs.getString("PartOccupationType") == null)
				partOccupationType = null;
			else
				partOccupationType = rs.getString("PartOccupationType").trim();
			if (rs.getString("PartOccupationCode") == null)
				partOccupationCode = null;
			else
				partOccupationCode = rs.getString("PartOccupationCode").trim();
			if (rs.getString("WorkType") == null)
				workType = null;
			else
				workType = rs.getString("WorkType").trim();
			if (rs.getString("PluralityType") == null)
				pluralityType = null;
			else
				pluralityType = rs.getString("PluralityType").trim();
			if (rs.getString("SmokeFlag") == null)
				smokeFlag = null;
			else
				smokeFlag = rs.getString("SmokeFlag").trim();
			if (rs.getString("ContPlanCode") == null)
				contPlanCode = null;
			else
				contPlanCode = rs.getString("ContPlanCode").trim();
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
			insuredPeoples = rs.getInt("InsuredPeoples");
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPInsured���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPInsuredSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPInsuredSchema getSchema()
	{
		LNPInsuredSchema aLNPInsuredSchema = new LNPInsuredSchema();
		aLNPInsuredSchema.setSchema(this);
		return aLNPInsuredSchema;
	}

	public LNPInsuredDB getDB()
	{
		LNPInsuredDB aDBOper = new LNPInsuredDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(grpContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proposalContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuredId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(prtNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(signCity));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(executeCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(familyID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relationToMainInsured));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relationToAppnt));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(addressNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sequenceNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(name));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appellation));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sex));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(birthday)));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(appAge));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appAgeType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(iDValidity)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDPerpetual));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nativePlace));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nationality));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rgtAddress));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(marriage));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(marriageDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(health));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(stature));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(avoirdupois));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(degree));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(creditGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bankCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bankAccNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(accName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(joinCompanyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startWorkDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(position));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(salary));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(occupationType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(occupationCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(partOccupationType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(partOccupationCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(workType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(pluralityType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(smokeFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contPlanCode));
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
		strReturn.append(ChgData.chgData(insuredPeoples));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			signCity = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			executeCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			familyID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			relationToMainInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			relationToAppnt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			sequenceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			birthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
			appAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|")))).intValue();
			appAgeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			iDValidity = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
			iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			marriageDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|"));
			health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			stature = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|")))).doubleValue();
			avoirdupois = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|")))).doubleValue();
			degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
			bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			joinCompanyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|"));
			startWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|"));
			position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			salary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 43, "|")))).doubleValue();
			occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			partOccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			partOccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			contPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
			insuredPeoples = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|")))).intValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredSchema";
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
		if (FCode.equalsIgnoreCase("grpContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpContNo));
		if (FCode.equalsIgnoreCase("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equalsIgnoreCase("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equalsIgnoreCase("insuredNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredNo));
		if (FCode.equalsIgnoreCase("insuredId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredId));
		if (FCode.equalsIgnoreCase("prtNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prtNo));
		if (FCode.equalsIgnoreCase("appntNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntNo));
		if (FCode.equalsIgnoreCase("appntId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntId));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("signCity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signCity));
		if (FCode.equalsIgnoreCase("executeCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(executeCom));
		if (FCode.equalsIgnoreCase("familyID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(familyID));
		if (FCode.equalsIgnoreCase("relationToMainInsured"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relationToMainInsured));
		if (FCode.equalsIgnoreCase("relationToAppnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relationToAppnt));
		if (FCode.equalsIgnoreCase("addressNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addressNo));
		if (FCode.equalsIgnoreCase("sequenceNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sequenceNo));
		if (FCode.equalsIgnoreCase("name"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(name));
		if (FCode.equalsIgnoreCase("appellation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appellation));
		if (FCode.equalsIgnoreCase("sex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sex));
		if (FCode.equalsIgnoreCase("birthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
		if (FCode.equalsIgnoreCase("appAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appAge));
		if (FCode.equalsIgnoreCase("appAgeType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appAgeType));
		if (FCode.equalsIgnoreCase("iDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDType));
		if (FCode.equalsIgnoreCase("iDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDNo));
		if (FCode.equalsIgnoreCase("iDValidity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
		if (FCode.equalsIgnoreCase("iDPerpetual"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDPerpetual));
		if (FCode.equalsIgnoreCase("nativePlace"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nativePlace));
		if (FCode.equalsIgnoreCase("nationality"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nationality));
		if (FCode.equalsIgnoreCase("rgtAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rgtAddress));
		if (FCode.equalsIgnoreCase("marriage"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(marriage));
		if (FCode.equalsIgnoreCase("marriageDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
		if (FCode.equalsIgnoreCase("health"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(health));
		if (FCode.equalsIgnoreCase("stature"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(stature));
		if (FCode.equalsIgnoreCase("avoirdupois"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(avoirdupois));
		if (FCode.equalsIgnoreCase("degree"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(degree));
		if (FCode.equalsIgnoreCase("creditGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(creditGrade));
		if (FCode.equalsIgnoreCase("bankCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankCode));
		if (FCode.equalsIgnoreCase("bankAccNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankAccNo));
		if (FCode.equalsIgnoreCase("accName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(accName));
		if (FCode.equalsIgnoreCase("joinCompanyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
		if (FCode.equalsIgnoreCase("startWorkDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
		if (FCode.equalsIgnoreCase("position"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(position));
		if (FCode.equalsIgnoreCase("salary"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(salary));
		if (FCode.equalsIgnoreCase("occupationType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationType));
		if (FCode.equalsIgnoreCase("occupationCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationCode));
		if (FCode.equalsIgnoreCase("partOccupationType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(partOccupationType));
		if (FCode.equalsIgnoreCase("partOccupationCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(partOccupationCode));
		if (FCode.equalsIgnoreCase("workType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(workType));
		if (FCode.equalsIgnoreCase("pluralityType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pluralityType));
		if (FCode.equalsIgnoreCase("smokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(smokeFlag));
		if (FCode.equalsIgnoreCase("contPlanCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contPlanCode));
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
		if (FCode.equalsIgnoreCase("insuredPeoples"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredPeoples));
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
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(insuredNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(insuredId);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(prtNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(appntNo);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(appntId);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(signCity);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(executeCom);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(familyID);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(relationToMainInsured);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(relationToAppnt);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(addressNo);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(sequenceNo);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(name);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(appellation);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(sex);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
			break;

		case 20: // '\024'
			strFieldValue = String.valueOf(appAge);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(appAgeType);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(iDType);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(iDNo);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(iDPerpetual);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(nativePlace);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(nationality);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(rgtAddress);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(marriage);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(health);
			break;

		case 32: // ' '
			strFieldValue = String.valueOf(stature);
			break;

		case 33: // '!'
			strFieldValue = String.valueOf(avoirdupois);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(degree);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(creditGrade);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(bankCode);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(bankAccNo);
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(accName);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(position);
			break;

		case 42: // '*'
			strFieldValue = String.valueOf(salary);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(occupationType);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(occupationCode);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(partOccupationType);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(partOccupationCode);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(workType);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(pluralityType);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(smokeFlag);
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(contPlanCode);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 54: // '6'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 55: // '7'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 56: // '8'
			strFieldValue = String.valueOf(insuredPeoples);
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
		if (FCode.equalsIgnoreCase("grpContNo"))
			if (FValue != null && !FValue.equals(""))
				grpContNo = FValue.trim();
			else
				grpContNo = null;
		if (FCode.equalsIgnoreCase("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equalsIgnoreCase("proposalContNo"))
			if (FValue != null && !FValue.equals(""))
				proposalContNo = FValue.trim();
			else
				proposalContNo = null;
		if (FCode.equalsIgnoreCase("insuredNo"))
			if (FValue != null && !FValue.equals(""))
				insuredNo = FValue.trim();
			else
				insuredNo = null;
		if (FCode.equalsIgnoreCase("insuredId"))
			if (FValue != null && !FValue.equals(""))
				insuredId = FValue.trim();
			else
				insuredId = null;
		if (FCode.equalsIgnoreCase("prtNo"))
			if (FValue != null && !FValue.equals(""))
				prtNo = FValue.trim();
			else
				prtNo = null;
		if (FCode.equalsIgnoreCase("appntNo"))
			if (FValue != null && !FValue.equals(""))
				appntNo = FValue.trim();
			else
				appntNo = null;
		if (FCode.equalsIgnoreCase("appntId"))
			if (FValue != null && !FValue.equals(""))
				appntId = FValue.trim();
			else
				appntId = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("signCity"))
			if (FValue != null && !FValue.equals(""))
				signCity = FValue.trim();
			else
				signCity = null;
		if (FCode.equalsIgnoreCase("executeCom"))
			if (FValue != null && !FValue.equals(""))
				executeCom = FValue.trim();
			else
				executeCom = null;
		if (FCode.equalsIgnoreCase("familyID"))
			if (FValue != null && !FValue.equals(""))
				familyID = FValue.trim();
			else
				familyID = null;
		if (FCode.equalsIgnoreCase("relationToMainInsured"))
			if (FValue != null && !FValue.equals(""))
				relationToMainInsured = FValue.trim();
			else
				relationToMainInsured = null;
		if (FCode.equalsIgnoreCase("relationToAppnt"))
			if (FValue != null && !FValue.equals(""))
				relationToAppnt = FValue.trim();
			else
				relationToAppnt = null;
		if (FCode.equalsIgnoreCase("addressNo"))
			if (FValue != null && !FValue.equals(""))
				addressNo = FValue.trim();
			else
				addressNo = null;
		if (FCode.equalsIgnoreCase("sequenceNo"))
			if (FValue != null && !FValue.equals(""))
				sequenceNo = FValue.trim();
			else
				sequenceNo = null;
		if (FCode.equalsIgnoreCase("name"))
			if (FValue != null && !FValue.equals(""))
				name = FValue.trim();
			else
				name = null;
		if (FCode.equalsIgnoreCase("appellation"))
			if (FValue != null && !FValue.equals(""))
				appellation = FValue.trim();
			else
				appellation = null;
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
		if (FCode.equalsIgnoreCase("appAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			appAge = i;
		}
		if (FCode.equalsIgnoreCase("appAgeType"))
			if (FValue != null && !FValue.equals(""))
				appAgeType = FValue.trim();
			else
				appAgeType = null;
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
		if (FCode.equalsIgnoreCase("iDValidity"))
			if (FValue != null && !FValue.equals(""))
				iDValidity = fDate.getDate(FValue);
			else
				iDValidity = null;
		if (FCode.equalsIgnoreCase("iDPerpetual"))
			if (FValue != null && !FValue.equals(""))
				iDPerpetual = FValue.trim();
			else
				iDPerpetual = null;
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
		if (FCode.equalsIgnoreCase("rgtAddress"))
			if (FValue != null && !FValue.equals(""))
				rgtAddress = FValue.trim();
			else
				rgtAddress = null;
		if (FCode.equalsIgnoreCase("marriage"))
			if (FValue != null && !FValue.equals(""))
				marriage = FValue.trim();
			else
				marriage = null;
		if (FCode.equalsIgnoreCase("marriageDate"))
			if (FValue != null && !FValue.equals(""))
				marriageDate = fDate.getDate(FValue);
			else
				marriageDate = null;
		if (FCode.equalsIgnoreCase("health"))
			if (FValue != null && !FValue.equals(""))
				health = FValue.trim();
			else
				health = null;
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
		if (FCode.equalsIgnoreCase("degree"))
			if (FValue != null && !FValue.equals(""))
				degree = FValue.trim();
			else
				degree = null;
		if (FCode.equalsIgnoreCase("creditGrade"))
			if (FValue != null && !FValue.equals(""))
				creditGrade = FValue.trim();
			else
				creditGrade = null;
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
		if (FCode.equalsIgnoreCase("joinCompanyDate"))
			if (FValue != null && !FValue.equals(""))
				joinCompanyDate = fDate.getDate(FValue);
			else
				joinCompanyDate = null;
		if (FCode.equalsIgnoreCase("startWorkDate"))
			if (FValue != null && !FValue.equals(""))
				startWorkDate = fDate.getDate(FValue);
			else
				startWorkDate = null;
		if (FCode.equalsIgnoreCase("position"))
			if (FValue != null && !FValue.equals(""))
				position = FValue.trim();
			else
				position = null;
		if (FCode.equalsIgnoreCase("salary") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			salary = d;
		}
		if (FCode.equalsIgnoreCase("occupationType"))
			if (FValue != null && !FValue.equals(""))
				occupationType = FValue.trim();
			else
				occupationType = null;
		if (FCode.equalsIgnoreCase("occupationCode"))
			if (FValue != null && !FValue.equals(""))
				occupationCode = FValue.trim();
			else
				occupationCode = null;
		if (FCode.equalsIgnoreCase("partOccupationType"))
			if (FValue != null && !FValue.equals(""))
				partOccupationType = FValue.trim();
			else
				partOccupationType = null;
		if (FCode.equalsIgnoreCase("partOccupationCode"))
			if (FValue != null && !FValue.equals(""))
				partOccupationCode = FValue.trim();
			else
				partOccupationCode = null;
		if (FCode.equalsIgnoreCase("workType"))
			if (FValue != null && !FValue.equals(""))
				workType = FValue.trim();
			else
				workType = null;
		if (FCode.equalsIgnoreCase("pluralityType"))
			if (FValue != null && !FValue.equals(""))
				pluralityType = FValue.trim();
			else
				pluralityType = null;
		if (FCode.equalsIgnoreCase("smokeFlag"))
			if (FValue != null && !FValue.equals(""))
				smokeFlag = FValue.trim();
			else
				smokeFlag = null;
		if (FCode.equalsIgnoreCase("contPlanCode"))
			if (FValue != null && !FValue.equals(""))
				contPlanCode = FValue.trim();
			else
				contPlanCode = null;
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
		if (FCode.equalsIgnoreCase("insuredPeoples") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			insuredPeoples = i;
		}
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
		LNPInsuredSchema other = (LNPInsuredSchema)otherObject;
		if (grpContNo == null && other.getGrpContNo() != null)
			return false;
		if (grpContNo != null && !grpContNo.equals(other.getGrpContNo()))
			return false;
		if (contNo == null && other.getContNo() != null)
			return false;
		if (contNo != null && !contNo.equals(other.getContNo()))
			return false;
		if (proposalContNo == null && other.getProposalContNo() != null)
			return false;
		if (proposalContNo != null && !proposalContNo.equals(other.getProposalContNo()))
			return false;
		if (insuredNo == null && other.getInsuredNo() != null)
			return false;
		if (insuredNo != null && !insuredNo.equals(other.getInsuredNo()))
			return false;
		if (insuredId == null && other.getInsuredId() != null)
			return false;
		if (insuredId != null && !insuredId.equals(other.getInsuredId()))
			return false;
		if (prtNo == null && other.getPrtNo() != null)
			return false;
		if (prtNo != null && !prtNo.equals(other.getPrtNo()))
			return false;
		if (appntNo == null && other.getAppntNo() != null)
			return false;
		if (appntNo != null && !appntNo.equals(other.getAppntNo()))
			return false;
		if (appntId == null && other.getAppntId() != null)
			return false;
		if (appntId != null && !appntId.equals(other.getAppntId()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (signCity == null && other.getSignCity() != null)
			return false;
		if (signCity != null && !signCity.equals(other.getSignCity()))
			return false;
		if (executeCom == null && other.getExecuteCom() != null)
			return false;
		if (executeCom != null && !executeCom.equals(other.getExecuteCom()))
			return false;
		if (familyID == null && other.getFamilyID() != null)
			return false;
		if (familyID != null && !familyID.equals(other.getFamilyID()))
			return false;
		if (relationToMainInsured == null && other.getRelationToMainInsured() != null)
			return false;
		if (relationToMainInsured != null && !relationToMainInsured.equals(other.getRelationToMainInsured()))
			return false;
		if (relationToAppnt == null && other.getRelationToAppnt() != null)
			return false;
		if (relationToAppnt != null && !relationToAppnt.equals(other.getRelationToAppnt()))
			return false;
		if (addressNo == null && other.getAddressNo() != null)
			return false;
		if (addressNo != null && !addressNo.equals(other.getAddressNo()))
			return false;
		if (sequenceNo == null && other.getSequenceNo() != null)
			return false;
		if (sequenceNo != null && !sequenceNo.equals(other.getSequenceNo()))
			return false;
		if (name == null && other.getName() != null)
			return false;
		if (name != null && !name.equals(other.getName()))
			return false;
		if (appellation == null && other.getAppellation() != null)
			return false;
		if (appellation != null && !appellation.equals(other.getAppellation()))
			return false;
		if (sex == null && other.getSex() != null)
			return false;
		if (sex != null && !sex.equals(other.getSex()))
			return false;
		if (birthday == null && other.getBirthday() != null)
			return false;
		if (birthday != null && !fDate.getString(birthday).equals(other.getBirthday()))
			return false;
		if (appAge != other.getAppAge())
			return false;
		if (appAgeType == null && other.getAppAgeType() != null)
			return false;
		if (appAgeType != null && !appAgeType.equals(other.getAppAgeType()))
			return false;
		if (iDType == null && other.getIDType() != null)
			return false;
		if (iDType != null && !iDType.equals(other.getIDType()))
			return false;
		if (iDNo == null && other.getIDNo() != null)
			return false;
		if (iDNo != null && !iDNo.equals(other.getIDNo()))
			return false;
		if (iDValidity == null && other.getIDValidity() != null)
			return false;
		if (iDValidity != null && !fDate.getString(iDValidity).equals(other.getIDValidity()))
			return false;
		if (iDPerpetual == null && other.getIDPerpetual() != null)
			return false;
		if (iDPerpetual != null && !iDPerpetual.equals(other.getIDPerpetual()))
			return false;
		if (nativePlace == null && other.getNativePlace() != null)
			return false;
		if (nativePlace != null && !nativePlace.equals(other.getNativePlace()))
			return false;
		if (nationality == null && other.getNationality() != null)
			return false;
		if (nationality != null && !nationality.equals(other.getNationality()))
			return false;
		if (rgtAddress == null && other.getRgtAddress() != null)
			return false;
		if (rgtAddress != null && !rgtAddress.equals(other.getRgtAddress()))
			return false;
		if (marriage == null && other.getMarriage() != null)
			return false;
		if (marriage != null && !marriage.equals(other.getMarriage()))
			return false;
		if (marriageDate == null && other.getMarriageDate() != null)
			return false;
		if (marriageDate != null && !fDate.getString(marriageDate).equals(other.getMarriageDate()))
			return false;
		if (health == null && other.getHealth() != null)
			return false;
		if (health != null && !health.equals(other.getHealth()))
			return false;
		if (Double.doubleToLongBits(stature) != Double.doubleToLongBits(other.getStature()))
			return false;
		if (Double.doubleToLongBits(avoirdupois) != Double.doubleToLongBits(other.getAvoirdupois()))
			return false;
		if (degree == null && other.getDegree() != null)
			return false;
		if (degree != null && !degree.equals(other.getDegree()))
			return false;
		if (creditGrade == null && other.getCreditGrade() != null)
			return false;
		if (creditGrade != null && !creditGrade.equals(other.getCreditGrade()))
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
		if (joinCompanyDate == null && other.getJoinCompanyDate() != null)
			return false;
		if (joinCompanyDate != null && !fDate.getString(joinCompanyDate).equals(other.getJoinCompanyDate()))
			return false;
		if (startWorkDate == null && other.getStartWorkDate() != null)
			return false;
		if (startWorkDate != null && !fDate.getString(startWorkDate).equals(other.getStartWorkDate()))
			return false;
		if (position == null && other.getPosition() != null)
			return false;
		if (position != null && !position.equals(other.getPosition()))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.getSalary()))
			return false;
		if (occupationType == null && other.getOccupationType() != null)
			return false;
		if (occupationType != null && !occupationType.equals(other.getOccupationType()))
			return false;
		if (occupationCode == null && other.getOccupationCode() != null)
			return false;
		if (occupationCode != null && !occupationCode.equals(other.getOccupationCode()))
			return false;
		if (partOccupationType == null && other.getPartOccupationType() != null)
			return false;
		if (partOccupationType != null && !partOccupationType.equals(other.getPartOccupationType()))
			return false;
		if (partOccupationCode == null && other.getPartOccupationCode() != null)
			return false;
		if (partOccupationCode != null && !partOccupationCode.equals(other.getPartOccupationCode()))
			return false;
		if (workType == null && other.getWorkType() != null)
			return false;
		if (workType != null && !workType.equals(other.getWorkType()))
			return false;
		if (pluralityType == null && other.getPluralityType() != null)
			return false;
		if (pluralityType != null && !pluralityType.equals(other.getPluralityType()))
			return false;
		if (smokeFlag == null && other.getSmokeFlag() != null)
			return false;
		if (smokeFlag != null && !smokeFlag.equals(other.getSmokeFlag()))
			return false;
		if (contPlanCode == null && other.getContPlanCode() != null)
			return false;
		if (contPlanCode != null && !contPlanCode.equals(other.getContPlanCode()))
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
		return insuredPeoples == other.getInsuredPeoples();
	}

	public int getFieldCount()
	{
		return 57;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 1;
		if (strFieldName.equals("proposalContNo"))
			return 2;
		if (strFieldName.equals("insuredNo"))
			return 3;
		if (strFieldName.equals("insuredId"))
			return 4;
		if (strFieldName.equals("prtNo"))
			return 5;
		if (strFieldName.equals("appntNo"))
			return 6;
		if (strFieldName.equals("appntId"))
			return 7;
		if (strFieldName.equals("manageCom"))
			return 8;
		if (strFieldName.equals("signCity"))
			return 9;
		if (strFieldName.equals("executeCom"))
			return 10;
		if (strFieldName.equals("familyID"))
			return 11;
		if (strFieldName.equals("relationToMainInsured"))
			return 12;
		if (strFieldName.equals("relationToAppnt"))
			return 13;
		if (strFieldName.equals("addressNo"))
			return 14;
		if (strFieldName.equals("sequenceNo"))
			return 15;
		if (strFieldName.equals("name"))
			return 16;
		if (strFieldName.equals("appellation"))
			return 17;
		if (strFieldName.equals("sex"))
			return 18;
		if (strFieldName.equals("birthday"))
			return 19;
		if (strFieldName.equals("appAge"))
			return 20;
		if (strFieldName.equals("appAgeType"))
			return 21;
		if (strFieldName.equals("iDType"))
			return 22;
		if (strFieldName.equals("iDNo"))
			return 23;
		if (strFieldName.equals("iDValidity"))
			return 24;
		if (strFieldName.equals("iDPerpetual"))
			return 25;
		if (strFieldName.equals("nativePlace"))
			return 26;
		if (strFieldName.equals("nationality"))
			return 27;
		if (strFieldName.equals("rgtAddress"))
			return 28;
		if (strFieldName.equals("marriage"))
			return 29;
		if (strFieldName.equals("marriageDate"))
			return 30;
		if (strFieldName.equals("health"))
			return 31;
		if (strFieldName.equals("stature"))
			return 32;
		if (strFieldName.equals("avoirdupois"))
			return 33;
		if (strFieldName.equals("degree"))
			return 34;
		if (strFieldName.equals("creditGrade"))
			return 35;
		if (strFieldName.equals("bankCode"))
			return 36;
		if (strFieldName.equals("bankAccNo"))
			return 37;
		if (strFieldName.equals("accName"))
			return 38;
		if (strFieldName.equals("joinCompanyDate"))
			return 39;
		if (strFieldName.equals("startWorkDate"))
			return 40;
		if (strFieldName.equals("position"))
			return 41;
		if (strFieldName.equals("salary"))
			return 42;
		if (strFieldName.equals("occupationType"))
			return 43;
		if (strFieldName.equals("occupationCode"))
			return 44;
		if (strFieldName.equals("partOccupationType"))
			return 45;
		if (strFieldName.equals("partOccupationCode"))
			return 46;
		if (strFieldName.equals("workType"))
			return 47;
		if (strFieldName.equals("pluralityType"))
			return 48;
		if (strFieldName.equals("smokeFlag"))
			return 49;
		if (strFieldName.equals("contPlanCode"))
			return 50;
		if (strFieldName.equals("operator"))
			return 51;
		if (strFieldName.equals("makeDate"))
			return 52;
		if (strFieldName.equals("makeTime"))
			return 53;
		if (strFieldName.equals("modifyDate"))
			return 54;
		if (strFieldName.equals("modifyTime"))
			return 55;
		return !strFieldName.equals("insuredPeoples") ? -1 : 56;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "grpContNo";
			break;

		case 1: // '\001'
			strFieldName = "contNo";
			break;

		case 2: // '\002'
			strFieldName = "proposalContNo";
			break;

		case 3: // '\003'
			strFieldName = "insuredNo";
			break;

		case 4: // '\004'
			strFieldName = "insuredId";
			break;

		case 5: // '\005'
			strFieldName = "prtNo";
			break;

		case 6: // '\006'
			strFieldName = "appntNo";
			break;

		case 7: // '\007'
			strFieldName = "appntId";
			break;

		case 8: // '\b'
			strFieldName = "manageCom";
			break;

		case 9: // '\t'
			strFieldName = "signCity";
			break;

		case 10: // '\n'
			strFieldName = "executeCom";
			break;

		case 11: // '\013'
			strFieldName = "familyID";
			break;

		case 12: // '\f'
			strFieldName = "relationToMainInsured";
			break;

		case 13: // '\r'
			strFieldName = "relationToAppnt";
			break;

		case 14: // '\016'
			strFieldName = "addressNo";
			break;

		case 15: // '\017'
			strFieldName = "sequenceNo";
			break;

		case 16: // '\020'
			strFieldName = "name";
			break;

		case 17: // '\021'
			strFieldName = "appellation";
			break;

		case 18: // '\022'
			strFieldName = "sex";
			break;

		case 19: // '\023'
			strFieldName = "birthday";
			break;

		case 20: // '\024'
			strFieldName = "appAge";
			break;

		case 21: // '\025'
			strFieldName = "appAgeType";
			break;

		case 22: // '\026'
			strFieldName = "iDType";
			break;

		case 23: // '\027'
			strFieldName = "iDNo";
			break;

		case 24: // '\030'
			strFieldName = "iDValidity";
			break;

		case 25: // '\031'
			strFieldName = "iDPerpetual";
			break;

		case 26: // '\032'
			strFieldName = "nativePlace";
			break;

		case 27: // '\033'
			strFieldName = "nationality";
			break;

		case 28: // '\034'
			strFieldName = "rgtAddress";
			break;

		case 29: // '\035'
			strFieldName = "marriage";
			break;

		case 30: // '\036'
			strFieldName = "marriageDate";
			break;

		case 31: // '\037'
			strFieldName = "health";
			break;

		case 32: // ' '
			strFieldName = "stature";
			break;

		case 33: // '!'
			strFieldName = "avoirdupois";
			break;

		case 34: // '"'
			strFieldName = "degree";
			break;

		case 35: // '#'
			strFieldName = "creditGrade";
			break;

		case 36: // '$'
			strFieldName = "bankCode";
			break;

		case 37: // '%'
			strFieldName = "bankAccNo";
			break;

		case 38: // '&'
			strFieldName = "accName";
			break;

		case 39: // '\''
			strFieldName = "joinCompanyDate";
			break;

		case 40: // '('
			strFieldName = "startWorkDate";
			break;

		case 41: // ')'
			strFieldName = "position";
			break;

		case 42: // '*'
			strFieldName = "salary";
			break;

		case 43: // '+'
			strFieldName = "occupationType";
			break;

		case 44: // ','
			strFieldName = "occupationCode";
			break;

		case 45: // '-'
			strFieldName = "partOccupationType";
			break;

		case 46: // '.'
			strFieldName = "partOccupationCode";
			break;

		case 47: // '/'
			strFieldName = "workType";
			break;

		case 48: // '0'
			strFieldName = "pluralityType";
			break;

		case 49: // '1'
			strFieldName = "smokeFlag";
			break;

		case 50: // '2'
			strFieldName = "contPlanCode";
			break;

		case 51: // '3'
			strFieldName = "operator";
			break;

		case 52: // '4'
			strFieldName = "makeDate";
			break;

		case 53: // '5'
			strFieldName = "makeTime";
			break;

		case 54: // '6'
			strFieldName = "modifyDate";
			break;

		case 55: // '7'
			strFieldName = "modifyTime";
			break;

		case 56: // '8'
			strFieldName = "insuredPeoples";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("proposalContNo"))
			return 0;
		if (strFieldName.equals("insuredNo"))
			return 0;
		if (strFieldName.equals("insuredId"))
			return 0;
		if (strFieldName.equals("prtNo"))
			return 0;
		if (strFieldName.equals("appntNo"))
			return 0;
		if (strFieldName.equals("appntId"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("signCity"))
			return 0;
		if (strFieldName.equals("executeCom"))
			return 0;
		if (strFieldName.equals("familyID"))
			return 0;
		if (strFieldName.equals("relationToMainInsured"))
			return 0;
		if (strFieldName.equals("relationToAppnt"))
			return 0;
		if (strFieldName.equals("addressNo"))
			return 0;
		if (strFieldName.equals("sequenceNo"))
			return 0;
		if (strFieldName.equals("name"))
			return 0;
		if (strFieldName.equals("appellation"))
			return 0;
		if (strFieldName.equals("sex"))
			return 0;
		if (strFieldName.equals("birthday"))
			return 1;
		if (strFieldName.equals("appAge"))
			return 3;
		if (strFieldName.equals("appAgeType"))
			return 0;
		if (strFieldName.equals("iDType"))
			return 0;
		if (strFieldName.equals("iDNo"))
			return 0;
		if (strFieldName.equals("iDValidity"))
			return 1;
		if (strFieldName.equals("iDPerpetual"))
			return 0;
		if (strFieldName.equals("nativePlace"))
			return 0;
		if (strFieldName.equals("nationality"))
			return 0;
		if (strFieldName.equals("rgtAddress"))
			return 0;
		if (strFieldName.equals("marriage"))
			return 0;
		if (strFieldName.equals("marriageDate"))
			return 1;
		if (strFieldName.equals("health"))
			return 0;
		if (strFieldName.equals("stature"))
			return 4;
		if (strFieldName.equals("avoirdupois"))
			return 4;
		if (strFieldName.equals("degree"))
			return 0;
		if (strFieldName.equals("creditGrade"))
			return 0;
		if (strFieldName.equals("bankCode"))
			return 0;
		if (strFieldName.equals("bankAccNo"))
			return 0;
		if (strFieldName.equals("accName"))
			return 0;
		if (strFieldName.equals("joinCompanyDate"))
			return 1;
		if (strFieldName.equals("startWorkDate"))
			return 1;
		if (strFieldName.equals("position"))
			return 0;
		if (strFieldName.equals("salary"))
			return 4;
		if (strFieldName.equals("occupationType"))
			return 0;
		if (strFieldName.equals("occupationCode"))
			return 0;
		if (strFieldName.equals("partOccupationType"))
			return 0;
		if (strFieldName.equals("partOccupationCode"))
			return 0;
		if (strFieldName.equals("workType"))
			return 0;
		if (strFieldName.equals("pluralityType"))
			return 0;
		if (strFieldName.equals("smokeFlag"))
			return 0;
		if (strFieldName.equals("contPlanCode"))
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
		return !strFieldName.equals("insuredPeoples") ? -1 : 3;
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
			nFieldType = 1;
			break;

		case 20: // '\024'
			nFieldType = 3;
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
			nFieldType = 1;
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
			nFieldType = 0;
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
			nFieldType = 4;
			break;

		case 33: // '!'
			nFieldType = 4;
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
			nFieldType = 0;
			break;

		case 38: // '&'
			nFieldType = 0;
			break;

		case 39: // '\''
			nFieldType = 1;
			break;

		case 40: // '('
			nFieldType = 1;
			break;

		case 41: // ')'
			nFieldType = 0;
			break;

		case 42: // '*'
			nFieldType = 4;
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
			nFieldType = 0;
			break;

		case 47: // '/'
			nFieldType = 0;
			break;

		case 48: // '0'
			nFieldType = 0;
			break;

		case 49: // '1'
			nFieldType = 0;
			break;

		case 50: // '2'
			nFieldType = 0;
			break;

		case 51: // '3'
			nFieldType = 0;
			break;

		case 52: // '4'
			nFieldType = 1;
			break;

		case 53: // '5'
			nFieldType = 0;
			break;

		case 54: // '6'
			nFieldType = 1;
			break;

		case 55: // '7'
			nFieldType = 0;
			break;

		case 56: // '8'
			nFieldType = 3;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
