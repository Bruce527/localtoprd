// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAppntSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPAppntDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPAppntSchema
	implements Schema, Cloneable
{

	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private String prtNo;
	private String appntNo;
	private String appntId;
	private String relationToInsured;
	private String appntGrade;
	private String appellation;
	private String appntName;
	private String appntSex;
	private Date appntBirthday;
	private int appntAge;
	private String appntAgeType;
	private String appntType;
	private String addressNo;
	private String sequenceNo;
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
	private String workType;
	private String pluralityType;
	private String smokeFlag;
	private String operator;
	private String manageCom;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 49;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPAppntSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ContNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPAppntSchema cloned = (LNPAppntSchema)super.clone();
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

	public String getRelationToInsured()
	{
		return relationToInsured;
	}

	public void setRelationToInsured(String aRelationToInsured)
	{
		relationToInsured = aRelationToInsured;
	}

	public String getAppntGrade()
	{
		return appntGrade;
	}

	public void setAppntGrade(String aAppntGrade)
	{
		appntGrade = aAppntGrade;
	}

	public String getAppellation()
	{
		return appellation;
	}

	public void setAppellation(String aAppellation)
	{
		appellation = aAppellation;
	}

	public String getAppntName()
	{
		return appntName;
	}

	public void setAppntName(String aAppntName)
	{
		appntName = aAppntName;
	}

	public String getAppntSex()
	{
		return appntSex;
	}

	public void setAppntSex(String aAppntSex)
	{
		appntSex = aAppntSex;
	}

	public String getAppntBirthday()
	{
		if (appntBirthday != null)
			return fDate.getString(appntBirthday);
		else
			return null;
	}

	public void setAppntBirthday(Date aAppntBirthday)
	{
		appntBirthday = aAppntBirthday;
	}

	public void setAppntBirthday(String aAppntBirthday)
	{
		if (aAppntBirthday != null && !aAppntBirthday.equals(""))
			appntBirthday = fDate.getDate(aAppntBirthday);
		else
			appntBirthday = null;
	}

	public int getAppntAge()
	{
		return appntAge;
	}

	public void setAppntAge(int aAppntAge)
	{
		appntAge = aAppntAge;
	}

	public void setAppntAge(String aAppntAge)
	{
		if (aAppntAge != null && !aAppntAge.equals(""))
		{
			Integer tInteger = new Integer(aAppntAge);
			int i = tInteger.intValue();
			appntAge = i;
		}
	}

	public String getAppntAgeType()
	{
		return appntAgeType;
	}

	public void setAppntAgeType(String aAppntAgeType)
	{
		appntAgeType = aAppntAgeType;
	}

	public String getAppntType()
	{
		return appntType;
	}

	public void setAppntType(String aAppntType)
	{
		appntType = aAppntType;
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

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
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

	public void setSchema(LNPAppntSchema aLNPAppntSchema)
	{
		grpContNo = aLNPAppntSchema.getGrpContNo();
		contNo = aLNPAppntSchema.getContNo();
		proposalContNo = aLNPAppntSchema.getProposalContNo();
		prtNo = aLNPAppntSchema.getPrtNo();
		appntNo = aLNPAppntSchema.getAppntNo();
		appntId = aLNPAppntSchema.getAppntId();
		relationToInsured = aLNPAppntSchema.getRelationToInsured();
		appntGrade = aLNPAppntSchema.getAppntGrade();
		appellation = aLNPAppntSchema.getAppellation();
		appntName = aLNPAppntSchema.getAppntName();
		appntSex = aLNPAppntSchema.getAppntSex();
		appntBirthday = fDate.getDate(aLNPAppntSchema.getAppntBirthday());
		appntAge = aLNPAppntSchema.getAppntAge();
		appntAgeType = aLNPAppntSchema.getAppntAgeType();
		appntType = aLNPAppntSchema.getAppntType();
		addressNo = aLNPAppntSchema.getAddressNo();
		sequenceNo = aLNPAppntSchema.getSequenceNo();
		iDType = aLNPAppntSchema.getIDType();
		iDNo = aLNPAppntSchema.getIDNo();
		iDValidity = fDate.getDate(aLNPAppntSchema.getIDValidity());
		iDPerpetual = aLNPAppntSchema.getIDPerpetual();
		nativePlace = aLNPAppntSchema.getNativePlace();
		nationality = aLNPAppntSchema.getNationality();
		rgtAddress = aLNPAppntSchema.getRgtAddress();
		marriage = aLNPAppntSchema.getMarriage();
		marriageDate = fDate.getDate(aLNPAppntSchema.getMarriageDate());
		health = aLNPAppntSchema.getHealth();
		stature = aLNPAppntSchema.getStature();
		avoirdupois = aLNPAppntSchema.getAvoirdupois();
		degree = aLNPAppntSchema.getDegree();
		creditGrade = aLNPAppntSchema.getCreditGrade();
		bankCode = aLNPAppntSchema.getBankCode();
		bankAccNo = aLNPAppntSchema.getBankAccNo();
		accName = aLNPAppntSchema.getAccName();
		joinCompanyDate = fDate.getDate(aLNPAppntSchema.getJoinCompanyDate());
		startWorkDate = fDate.getDate(aLNPAppntSchema.getStartWorkDate());
		position = aLNPAppntSchema.getPosition();
		salary = aLNPAppntSchema.getSalary();
		occupationType = aLNPAppntSchema.getOccupationType();
		occupationCode = aLNPAppntSchema.getOccupationCode();
		workType = aLNPAppntSchema.getWorkType();
		pluralityType = aLNPAppntSchema.getPluralityType();
		smokeFlag = aLNPAppntSchema.getSmokeFlag();
		operator = aLNPAppntSchema.getOperator();
		manageCom = aLNPAppntSchema.getManageCom();
		makeDate = fDate.getDate(aLNPAppntSchema.getMakeDate());
		makeTime = aLNPAppntSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPAppntSchema.getModifyDate());
		modifyTime = aLNPAppntSchema.getModifyTime();
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
			if (rs.getString("RelationToInsured") == null)
				relationToInsured = null;
			else
				relationToInsured = rs.getString("RelationToInsured").trim();
			if (rs.getString("AppntGrade") == null)
				appntGrade = null;
			else
				appntGrade = rs.getString("AppntGrade").trim();
			if (rs.getString("Appellation") == null)
				appellation = null;
			else
				appellation = rs.getString("Appellation").trim();
			if (rs.getString("AppntName") == null)
				appntName = null;
			else
				appntName = rs.getString("AppntName").trim();
			if (rs.getString("AppntSex") == null)
				appntSex = null;
			else
				appntSex = rs.getString("AppntSex").trim();
			appntBirthday = rs.getDate("AppntBirthday");
			appntAge = rs.getInt("AppntAge");
			if (rs.getString("AppntAgeType") == null)
				appntAgeType = null;
			else
				appntAgeType = rs.getString("AppntAgeType").trim();
			if (rs.getString("AppntType") == null)
				appntType = null;
			else
				appntType = rs.getString("AppntType").trim();
			if (rs.getString("AddressNo") == null)
				addressNo = null;
			else
				addressNo = rs.getString("AddressNo").trim();
			if (rs.getString("SequenceNo") == null)
				sequenceNo = null;
			else
				sequenceNo = rs.getString("SequenceNo").trim();
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
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
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
			System.out.println("数据库中的LNPAppnt表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPAppntSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPAppntSchema getSchema()
	{
		LNPAppntSchema aLNPAppntSchema = new LNPAppntSchema();
		aLNPAppntSchema.setSchema(this);
		return aLNPAppntSchema;
	}

	public LNPAppntDB getDB()
	{
		LNPAppntDB aDBOper = new LNPAppntDB();
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
		strReturn.append(StrTool.cTrim(prtNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relationToInsured));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appellation));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntSex));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(appntBirthday)));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(appntAge));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntAgeType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(addressNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sequenceNo));
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
		strReturn.append(StrTool.cTrim(workType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(pluralityType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(smokeFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
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
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			relationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			appntGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			appntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			appntSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			appntBirthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
			appntAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|")))).intValue();
			appntAgeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			appntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			sequenceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			iDValidity = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
			iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			marriageDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
			health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			stature = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 28, "|")))).doubleValue();
			avoirdupois = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|")))).doubleValue();
			degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			joinCompanyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|"));
			startWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
			position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			salary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|")))).doubleValue();
			occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAppntSchema";
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
		if (FCode.equalsIgnoreCase("prtNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prtNo));
		if (FCode.equalsIgnoreCase("appntNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntNo));
		if (FCode.equalsIgnoreCase("appntId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntId));
		if (FCode.equalsIgnoreCase("relationToInsured"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relationToInsured));
		if (FCode.equalsIgnoreCase("appntGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntGrade));
		if (FCode.equalsIgnoreCase("appellation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appellation));
		if (FCode.equalsIgnoreCase("appntName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntName));
		if (FCode.equalsIgnoreCase("appntSex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntSex));
		if (FCode.equalsIgnoreCase("appntBirthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getAppntBirthday()));
		if (FCode.equalsIgnoreCase("appntAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntAge));
		if (FCode.equalsIgnoreCase("appntAgeType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntAgeType));
		if (FCode.equalsIgnoreCase("appntType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntType));
		if (FCode.equalsIgnoreCase("addressNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addressNo));
		if (FCode.equalsIgnoreCase("sequenceNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sequenceNo));
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
		if (FCode.equalsIgnoreCase("workType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(workType));
		if (FCode.equalsIgnoreCase("pluralityType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pluralityType));
		if (FCode.equalsIgnoreCase("smokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(smokeFlag));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
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
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(prtNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(appntNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(appntId);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(relationToInsured);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(appntGrade);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(appellation);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(appntName);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(appntSex);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getAppntBirthday()));
			break;

		case 12: // '\f'
			strFieldValue = String.valueOf(appntAge);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(appntAgeType);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(appntType);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(addressNo);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(sequenceNo);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(iDType);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(iDNo);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(iDPerpetual);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(nativePlace);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(nationality);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(rgtAddress);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(marriage);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(health);
			break;

		case 27: // '\033'
			strFieldValue = String.valueOf(stature);
			break;

		case 28: // '\034'
			strFieldValue = String.valueOf(avoirdupois);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(degree);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(creditGrade);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(bankCode);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(bankAccNo);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(accName);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(position);
			break;

		case 37: // '%'
			strFieldValue = String.valueOf(salary);
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(occupationType);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(occupationCode);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(workType);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(pluralityType);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(smokeFlag);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 48: // '0'
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
		if (FCode.equalsIgnoreCase("relationToInsured"))
			if (FValue != null && !FValue.equals(""))
				relationToInsured = FValue.trim();
			else
				relationToInsured = null;
		if (FCode.equalsIgnoreCase("appntGrade"))
			if (FValue != null && !FValue.equals(""))
				appntGrade = FValue.trim();
			else
				appntGrade = null;
		if (FCode.equalsIgnoreCase("appellation"))
			if (FValue != null && !FValue.equals(""))
				appellation = FValue.trim();
			else
				appellation = null;
		if (FCode.equalsIgnoreCase("appntName"))
			if (FValue != null && !FValue.equals(""))
				appntName = FValue.trim();
			else
				appntName = null;
		if (FCode.equalsIgnoreCase("appntSex"))
			if (FValue != null && !FValue.equals(""))
				appntSex = FValue.trim();
			else
				appntSex = null;
		if (FCode.equalsIgnoreCase("appntBirthday"))
			if (FValue != null && !FValue.equals(""))
				appntBirthday = fDate.getDate(FValue);
			else
				appntBirthday = null;
		if (FCode.equalsIgnoreCase("appntAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			appntAge = i;
		}
		if (FCode.equalsIgnoreCase("appntAgeType"))
			if (FValue != null && !FValue.equals(""))
				appntAgeType = FValue.trim();
			else
				appntAgeType = null;
		if (FCode.equalsIgnoreCase("appntType"))
			if (FValue != null && !FValue.equals(""))
				appntType = FValue.trim();
			else
				appntType = null;
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
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
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
		LNPAppntSchema other = (LNPAppntSchema)otherObject;
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
		if (relationToInsured == null && other.getRelationToInsured() != null)
			return false;
		if (relationToInsured != null && !relationToInsured.equals(other.getRelationToInsured()))
			return false;
		if (appntGrade == null && other.getAppntGrade() != null)
			return false;
		if (appntGrade != null && !appntGrade.equals(other.getAppntGrade()))
			return false;
		if (appellation == null && other.getAppellation() != null)
			return false;
		if (appellation != null && !appellation.equals(other.getAppellation()))
			return false;
		if (appntName == null && other.getAppntName() != null)
			return false;
		if (appntName != null && !appntName.equals(other.getAppntName()))
			return false;
		if (appntSex == null && other.getAppntSex() != null)
			return false;
		if (appntSex != null && !appntSex.equals(other.getAppntSex()))
			return false;
		if (appntBirthday == null && other.getAppntBirthday() != null)
			return false;
		if (appntBirthday != null && !fDate.getString(appntBirthday).equals(other.getAppntBirthday()))
			return false;
		if (appntAge != other.getAppntAge())
			return false;
		if (appntAgeType == null && other.getAppntAgeType() != null)
			return false;
		if (appntAgeType != null && !appntAgeType.equals(other.getAppntAgeType()))
			return false;
		if (appntType == null && other.getAppntType() != null)
			return false;
		if (appntType != null && !appntType.equals(other.getAppntType()))
			return false;
		if (addressNo == null && other.getAddressNo() != null)
			return false;
		if (addressNo != null && !addressNo.equals(other.getAddressNo()))
			return false;
		if (sequenceNo == null && other.getSequenceNo() != null)
			return false;
		if (sequenceNo != null && !sequenceNo.equals(other.getSequenceNo()))
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
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
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
		return 49;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 1;
		if (strFieldName.equals("proposalContNo"))
			return 2;
		if (strFieldName.equals("prtNo"))
			return 3;
		if (strFieldName.equals("appntNo"))
			return 4;
		if (strFieldName.equals("appntId"))
			return 5;
		if (strFieldName.equals("relationToInsured"))
			return 6;
		if (strFieldName.equals("appntGrade"))
			return 7;
		if (strFieldName.equals("appellation"))
			return 8;
		if (strFieldName.equals("appntName"))
			return 9;
		if (strFieldName.equals("appntSex"))
			return 10;
		if (strFieldName.equals("appntBirthday"))
			return 11;
		if (strFieldName.equals("appntAge"))
			return 12;
		if (strFieldName.equals("appntAgeType"))
			return 13;
		if (strFieldName.equals("appntType"))
			return 14;
		if (strFieldName.equals("addressNo"))
			return 15;
		if (strFieldName.equals("sequenceNo"))
			return 16;
		if (strFieldName.equals("iDType"))
			return 17;
		if (strFieldName.equals("iDNo"))
			return 18;
		if (strFieldName.equals("iDValidity"))
			return 19;
		if (strFieldName.equals("iDPerpetual"))
			return 20;
		if (strFieldName.equals("nativePlace"))
			return 21;
		if (strFieldName.equals("nationality"))
			return 22;
		if (strFieldName.equals("rgtAddress"))
			return 23;
		if (strFieldName.equals("marriage"))
			return 24;
		if (strFieldName.equals("marriageDate"))
			return 25;
		if (strFieldName.equals("health"))
			return 26;
		if (strFieldName.equals("stature"))
			return 27;
		if (strFieldName.equals("avoirdupois"))
			return 28;
		if (strFieldName.equals("degree"))
			return 29;
		if (strFieldName.equals("creditGrade"))
			return 30;
		if (strFieldName.equals("bankCode"))
			return 31;
		if (strFieldName.equals("bankAccNo"))
			return 32;
		if (strFieldName.equals("accName"))
			return 33;
		if (strFieldName.equals("joinCompanyDate"))
			return 34;
		if (strFieldName.equals("startWorkDate"))
			return 35;
		if (strFieldName.equals("position"))
			return 36;
		if (strFieldName.equals("salary"))
			return 37;
		if (strFieldName.equals("occupationType"))
			return 38;
		if (strFieldName.equals("occupationCode"))
			return 39;
		if (strFieldName.equals("workType"))
			return 40;
		if (strFieldName.equals("pluralityType"))
			return 41;
		if (strFieldName.equals("smokeFlag"))
			return 42;
		if (strFieldName.equals("operator"))
			return 43;
		if (strFieldName.equals("manageCom"))
			return 44;
		if (strFieldName.equals("makeDate"))
			return 45;
		if (strFieldName.equals("makeTime"))
			return 46;
		if (strFieldName.equals("modifyDate"))
			return 47;
		return !strFieldName.equals("modifyTime") ? -1 : 48;
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
			strFieldName = "prtNo";
			break;

		case 4: // '\004'
			strFieldName = "appntNo";
			break;

		case 5: // '\005'
			strFieldName = "appntId";
			break;

		case 6: // '\006'
			strFieldName = "relationToInsured";
			break;

		case 7: // '\007'
			strFieldName = "appntGrade";
			break;

		case 8: // '\b'
			strFieldName = "appellation";
			break;

		case 9: // '\t'
			strFieldName = "appntName";
			break;

		case 10: // '\n'
			strFieldName = "appntSex";
			break;

		case 11: // '\013'
			strFieldName = "appntBirthday";
			break;

		case 12: // '\f'
			strFieldName = "appntAge";
			break;

		case 13: // '\r'
			strFieldName = "appntAgeType";
			break;

		case 14: // '\016'
			strFieldName = "appntType";
			break;

		case 15: // '\017'
			strFieldName = "addressNo";
			break;

		case 16: // '\020'
			strFieldName = "sequenceNo";
			break;

		case 17: // '\021'
			strFieldName = "iDType";
			break;

		case 18: // '\022'
			strFieldName = "iDNo";
			break;

		case 19: // '\023'
			strFieldName = "iDValidity";
			break;

		case 20: // '\024'
			strFieldName = "iDPerpetual";
			break;

		case 21: // '\025'
			strFieldName = "nativePlace";
			break;

		case 22: // '\026'
			strFieldName = "nationality";
			break;

		case 23: // '\027'
			strFieldName = "rgtAddress";
			break;

		case 24: // '\030'
			strFieldName = "marriage";
			break;

		case 25: // '\031'
			strFieldName = "marriageDate";
			break;

		case 26: // '\032'
			strFieldName = "health";
			break;

		case 27: // '\033'
			strFieldName = "stature";
			break;

		case 28: // '\034'
			strFieldName = "avoirdupois";
			break;

		case 29: // '\035'
			strFieldName = "degree";
			break;

		case 30: // '\036'
			strFieldName = "creditGrade";
			break;

		case 31: // '\037'
			strFieldName = "bankCode";
			break;

		case 32: // ' '
			strFieldName = "bankAccNo";
			break;

		case 33: // '!'
			strFieldName = "accName";
			break;

		case 34: // '"'
			strFieldName = "joinCompanyDate";
			break;

		case 35: // '#'
			strFieldName = "startWorkDate";
			break;

		case 36: // '$'
			strFieldName = "position";
			break;

		case 37: // '%'
			strFieldName = "salary";
			break;

		case 38: // '&'
			strFieldName = "occupationType";
			break;

		case 39: // '\''
			strFieldName = "occupationCode";
			break;

		case 40: // '('
			strFieldName = "workType";
			break;

		case 41: // ')'
			strFieldName = "pluralityType";
			break;

		case 42: // '*'
			strFieldName = "smokeFlag";
			break;

		case 43: // '+'
			strFieldName = "operator";
			break;

		case 44: // ','
			strFieldName = "manageCom";
			break;

		case 45: // '-'
			strFieldName = "makeDate";
			break;

		case 46: // '.'
			strFieldName = "makeTime";
			break;

		case 47: // '/'
			strFieldName = "modifyDate";
			break;

		case 48: // '0'
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
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("proposalContNo"))
			return 0;
		if (strFieldName.equals("prtNo"))
			return 0;
		if (strFieldName.equals("appntNo"))
			return 0;
		if (strFieldName.equals("appntId"))
			return 0;
		if (strFieldName.equals("relationToInsured"))
			return 0;
		if (strFieldName.equals("appntGrade"))
			return 0;
		if (strFieldName.equals("appellation"))
			return 0;
		if (strFieldName.equals("appntName"))
			return 0;
		if (strFieldName.equals("appntSex"))
			return 0;
		if (strFieldName.equals("appntBirthday"))
			return 1;
		if (strFieldName.equals("appntAge"))
			return 3;
		if (strFieldName.equals("appntAgeType"))
			return 0;
		if (strFieldName.equals("appntType"))
			return 0;
		if (strFieldName.equals("addressNo"))
			return 0;
		if (strFieldName.equals("sequenceNo"))
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
		if (strFieldName.equals("workType"))
			return 0;
		if (strFieldName.equals("pluralityType"))
			return 0;
		if (strFieldName.equals("smokeFlag"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("manageCom"))
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
			nFieldType = 1;
			break;

		case 35: // '#'
			nFieldType = 1;
			break;

		case 36: // '$'
			nFieldType = 0;
			break;

		case 37: // '%'
			nFieldType = 4;
			break;

		case 38: // '&'
			nFieldType = 0;
			break;

		case 39: // '\''
			nFieldType = 0;
			break;

		case 40: // '('
			nFieldType = 0;
			break;

		case 41: // ')'
			nFieldType = 0;
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
			nFieldType = 1;
			break;

		case 46: // '.'
			nFieldType = 0;
			break;

		case 47: // '/'
			nFieldType = 1;
			break;

		case 48: // '0'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
