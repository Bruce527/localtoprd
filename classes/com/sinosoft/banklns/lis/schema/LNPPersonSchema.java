// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPersonSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPPersonDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPPersonSchema
	implements Schema, Cloneable
{

	private String customerId;
	private String agentCode;
	private String customerNo;
	private String appellation;
	private String name;
	private String sex;
	private Date birthday;
	private int age;
	private String ageType;
	private String appntType;
	private String iDType;
	private String iDNo;
	private Date iDValidity;
	private String iDPerpetual;
	private String password;
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
	private String othIDType;
	private String othIDNo;
	private String iCNo;
	private String grpNo;
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
	private Date deathDate;
	private String smokeFlag;
	private String blacklistFlag;
	private String proterty;
	private String remark;
	private String state;
	private String vIPValue;
	private String operator;
	private String manageCom;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String grpName;
	public static final int FIELDNUM = 56;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPPersonSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "CustomerId";
		pk[1] = "AgentCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPPersonSchema cloned = (LNPPersonSchema)super.clone();
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

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
	}

	public String getCustomerNo()
	{
		return customerNo;
	}

	public void setCustomerNo(String aCustomerNo)
	{
		customerNo = aCustomerNo;
	}

	public String getAppellation()
	{
		return appellation;
	}

	public void setAppellation(String aAppellation)
	{
		appellation = aAppellation;
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

	public int getAge()
	{
		return age;
	}

	public void setAge(int aAge)
	{
		age = aAge;
	}

	public void setAge(String aAge)
	{
		if (aAge != null && !aAge.equals(""))
		{
			Integer tInteger = new Integer(aAge);
			int i = tInteger.intValue();
			age = i;
		}
	}

	public String getAgeType()
	{
		return ageType;
	}

	public void setAgeType(String aAgeType)
	{
		ageType = aAgeType;
	}

	public String getAppntType()
	{
		return appntType;
	}

	public void setAppntType(String aAppntType)
	{
		appntType = aAppntType;
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String aPassword)
	{
		password = aPassword;
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

	public String getOthIDType()
	{
		return othIDType;
	}

	public void setOthIDType(String aOthIDType)
	{
		othIDType = aOthIDType;
	}

	public String getOthIDNo()
	{
		return othIDNo;
	}

	public void setOthIDNo(String aOthIDNo)
	{
		othIDNo = aOthIDNo;
	}

	public String getICNo()
	{
		return iCNo;
	}

	public void setICNo(String aICNo)
	{
		iCNo = aICNo;
	}

	public String getGrpNo()
	{
		return grpNo;
	}

	public void setGrpNo(String aGrpNo)
	{
		grpNo = aGrpNo;
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

	public String getSmokeFlag()
	{
		return smokeFlag;
	}

	public void setSmokeFlag(String aSmokeFlag)
	{
		smokeFlag = aSmokeFlag;
	}

	public String getBlacklistFlag()
	{
		return blacklistFlag;
	}

	public void setBlacklistFlag(String aBlacklistFlag)
	{
		blacklistFlag = aBlacklistFlag;
	}

	public String getProterty()
	{
		return proterty;
	}

	public void setProterty(String aProterty)
	{
		proterty = aProterty;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String aRemark)
	{
		remark = aRemark;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getVIPValue()
	{
		return vIPValue;
	}

	public void setVIPValue(String aVIPValue)
	{
		vIPValue = aVIPValue;
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

	public String getGrpName()
	{
		return grpName;
	}

	public void setGrpName(String aGrpName)
	{
		grpName = aGrpName;
	}

	public void setSchema(LNPPersonSchema aLNPPersonSchema)
	{
		customerId = aLNPPersonSchema.getCustomerId();
		agentCode = aLNPPersonSchema.getAgentCode();
		customerNo = aLNPPersonSchema.getCustomerNo();
		appellation = aLNPPersonSchema.getAppellation();
		name = aLNPPersonSchema.getName();
		sex = aLNPPersonSchema.getSex();
		birthday = fDate.getDate(aLNPPersonSchema.getBirthday());
		age = aLNPPersonSchema.getAge();
		ageType = aLNPPersonSchema.getAgeType();
		appntType = aLNPPersonSchema.getAppntType();
		iDType = aLNPPersonSchema.getIDType();
		iDNo = aLNPPersonSchema.getIDNo();
		iDValidity = fDate.getDate(aLNPPersonSchema.getIDValidity());
		iDPerpetual = aLNPPersonSchema.getIDPerpetual();
		password = aLNPPersonSchema.getPassword();
		nativePlace = aLNPPersonSchema.getNativePlace();
		nationality = aLNPPersonSchema.getNationality();
		rgtAddress = aLNPPersonSchema.getRgtAddress();
		marriage = aLNPPersonSchema.getMarriage();
		marriageDate = fDate.getDate(aLNPPersonSchema.getMarriageDate());
		health = aLNPPersonSchema.getHealth();
		stature = aLNPPersonSchema.getStature();
		avoirdupois = aLNPPersonSchema.getAvoirdupois();
		degree = aLNPPersonSchema.getDegree();
		creditGrade = aLNPPersonSchema.getCreditGrade();
		bankCode = aLNPPersonSchema.getBankCode();
		bankAccNo = aLNPPersonSchema.getBankAccNo();
		accName = aLNPPersonSchema.getAccName();
		othIDType = aLNPPersonSchema.getOthIDType();
		othIDNo = aLNPPersonSchema.getOthIDNo();
		iCNo = aLNPPersonSchema.getICNo();
		grpNo = aLNPPersonSchema.getGrpNo();
		joinCompanyDate = fDate.getDate(aLNPPersonSchema.getJoinCompanyDate());
		startWorkDate = fDate.getDate(aLNPPersonSchema.getStartWorkDate());
		position = aLNPPersonSchema.getPosition();
		salary = aLNPPersonSchema.getSalary();
		occupationType = aLNPPersonSchema.getOccupationType();
		occupationCode = aLNPPersonSchema.getOccupationCode();
		partOccupationType = aLNPPersonSchema.getPartOccupationType();
		partOccupationCode = aLNPPersonSchema.getPartOccupationCode();
		workType = aLNPPersonSchema.getWorkType();
		pluralityType = aLNPPersonSchema.getPluralityType();
		deathDate = fDate.getDate(aLNPPersonSchema.getDeathDate());
		smokeFlag = aLNPPersonSchema.getSmokeFlag();
		blacklistFlag = aLNPPersonSchema.getBlacklistFlag();
		proterty = aLNPPersonSchema.getProterty();
		remark = aLNPPersonSchema.getRemark();
		state = aLNPPersonSchema.getState();
		vIPValue = aLNPPersonSchema.getVIPValue();
		operator = aLNPPersonSchema.getOperator();
		manageCom = aLNPPersonSchema.getManageCom();
		makeDate = fDate.getDate(aLNPPersonSchema.getMakeDate());
		makeTime = aLNPPersonSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPPersonSchema.getModifyDate());
		modifyTime = aLNPPersonSchema.getModifyTime();
		grpName = aLNPPersonSchema.getGrpName();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("CustomerId") == null)
				customerId = null;
			else
				customerId = rs.getString("CustomerId").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("CustomerNo") == null)
				customerNo = null;
			else
				customerNo = rs.getString("CustomerNo").trim();
			if (rs.getString("Appellation") == null)
				appellation = null;
			else
				appellation = rs.getString("Appellation").trim();
			if (rs.getString("Name") == null)
				name = null;
			else
				name = rs.getString("Name").trim();
			if (rs.getString("Sex") == null)
				sex = null;
			else
				sex = rs.getString("Sex").trim();
			birthday = rs.getDate("Birthday");
			age = rs.getInt("Age");
			if (rs.getString("AgeType") == null)
				ageType = null;
			else
				ageType = rs.getString("AgeType").trim();
			if (rs.getString("AppntType") == null)
				appntType = null;
			else
				appntType = rs.getString("AppntType").trim();
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
			if (rs.getString("Password") == null)
				password = null;
			else
				password = rs.getString("Password").trim();
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
			if (rs.getString("OthIDType") == null)
				othIDType = null;
			else
				othIDType = rs.getString("OthIDType").trim();
			if (rs.getString("OthIDNo") == null)
				othIDNo = null;
			else
				othIDNo = rs.getString("OthIDNo").trim();
			if (rs.getString("ICNo") == null)
				iCNo = null;
			else
				iCNo = rs.getString("ICNo").trim();
			if (rs.getString("GrpNo") == null)
				grpNo = null;
			else
				grpNo = rs.getString("GrpNo").trim();
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
			deathDate = rs.getDate("DeathDate");
			if (rs.getString("SmokeFlag") == null)
				smokeFlag = null;
			else
				smokeFlag = rs.getString("SmokeFlag").trim();
			if (rs.getString("BlacklistFlag") == null)
				blacklistFlag = null;
			else
				blacklistFlag = rs.getString("BlacklistFlag").trim();
			if (rs.getString("Proterty") == null)
				proterty = null;
			else
				proterty = rs.getString("Proterty").trim();
			if (rs.getString("Remark") == null)
				remark = null;
			else
				remark = rs.getString("Remark").trim();
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			if (rs.getString("VIPValue") == null)
				vIPValue = null;
			else
				vIPValue = rs.getString("VIPValue").trim();
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
			if (rs.getString("GrpName") == null)
				grpName = null;
			else
				grpName = rs.getString("GrpName").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPPerson���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPPersonSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPPersonSchema getSchema()
	{
		LNPPersonSchema aLNPPersonSchema = new LNPPersonSchema();
		aLNPPersonSchema.setSchema(this);
		return aLNPPersonSchema;
	}

	public LNPPersonDB getDB()
	{
		LNPPersonDB aDBOper = new LNPPersonDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(customerId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(customerNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appellation));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(name));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sex));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(birthday)));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(age));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ageType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(appntType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(iDValidity)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iDPerpetual));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(password));
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
		strReturn.append(StrTool.cTrim(othIDType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(othIDNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(iCNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpNo));
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
		strReturn.append(StrTool.cTrim(fDate.getString(deathDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(smokeFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(blacklistFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proterty));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remark));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vIPValue));
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
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpName));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			birthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
			age = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).intValue();
			ageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			appntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			iDValidity = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
			iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			marriageDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
			health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			stature = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 22, "|")))).doubleValue();
			avoirdupois = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|")))).doubleValue();
			degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			othIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			othIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			iCNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			grpNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			joinCompanyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|"));
			startWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|"));
			position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			salary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|")))).doubleValue();
			occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			partOccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			partOccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			deathDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|"));
			smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			blacklistFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			proterty = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			vIPValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
			grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPersonSchema";
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
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("customerNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerNo));
		if (FCode.equalsIgnoreCase("appellation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appellation));
		if (FCode.equalsIgnoreCase("name"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(name));
		if (FCode.equalsIgnoreCase("sex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sex));
		if (FCode.equalsIgnoreCase("birthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
		if (FCode.equalsIgnoreCase("age"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(age));
		if (FCode.equalsIgnoreCase("ageType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ageType));
		if (FCode.equalsIgnoreCase("appntType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntType));
		if (FCode.equalsIgnoreCase("iDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDType));
		if (FCode.equalsIgnoreCase("iDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDNo));
		if (FCode.equalsIgnoreCase("iDValidity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
		if (FCode.equalsIgnoreCase("iDPerpetual"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDPerpetual));
		if (FCode.equalsIgnoreCase("password"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(password));
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
		if (FCode.equalsIgnoreCase("othIDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(othIDType));
		if (FCode.equalsIgnoreCase("othIDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(othIDNo));
		if (FCode.equalsIgnoreCase("iCNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iCNo));
		if (FCode.equalsIgnoreCase("grpNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpNo));
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
		if (FCode.equalsIgnoreCase("deathDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDeathDate()));
		if (FCode.equalsIgnoreCase("smokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(smokeFlag));
		if (FCode.equalsIgnoreCase("blacklistFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(blacklistFlag));
		if (FCode.equalsIgnoreCase("proterty"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proterty));
		if (FCode.equalsIgnoreCase("remark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("vIPValue"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vIPValue));
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
		if (FCode.equalsIgnoreCase("grpName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpName));
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
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(customerNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(appellation);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(name);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(sex);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBirthday()));
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(age);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(ageType);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(appntType);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(iDType);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(iDNo);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getIDValidity()));
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(iDPerpetual);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(password);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(nativePlace);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(nationality);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(rgtAddress);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(marriage);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMarriageDate()));
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(health);
			break;

		case 21: // '\025'
			strFieldValue = String.valueOf(stature);
			break;

		case 22: // '\026'
			strFieldValue = String.valueOf(avoirdupois);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(degree);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(creditGrade);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(bankCode);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(bankAccNo);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(accName);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(othIDType);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(othIDNo);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(iCNo);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(grpNo);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getJoinCompanyDate()));
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartWorkDate()));
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(position);
			break;

		case 35: // '#'
			strFieldValue = String.valueOf(salary);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(occupationType);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(occupationCode);
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(partOccupationType);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(partOccupationCode);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(workType);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(pluralityType);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDeathDate()));
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(smokeFlag);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(blacklistFlag);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(proterty);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(remark);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(vIPValue);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 54: // '6'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 55: // '7'
			strFieldValue = StrTool.GBKToUnicode(grpName);
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
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equalsIgnoreCase("customerNo"))
			if (FValue != null && !FValue.equals(""))
				customerNo = FValue.trim();
			else
				customerNo = null;
		if (FCode.equalsIgnoreCase("appellation"))
			if (FValue != null && !FValue.equals(""))
				appellation = FValue.trim();
			else
				appellation = null;
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
		if (FCode.equalsIgnoreCase("age") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			age = i;
		}
		if (FCode.equalsIgnoreCase("ageType"))
			if (FValue != null && !FValue.equals(""))
				ageType = FValue.trim();
			else
				ageType = null;
		if (FCode.equalsIgnoreCase("appntType"))
			if (FValue != null && !FValue.equals(""))
				appntType = FValue.trim();
			else
				appntType = null;
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
		if (FCode.equalsIgnoreCase("password"))
			if (FValue != null && !FValue.equals(""))
				password = FValue.trim();
			else
				password = null;
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
		if (FCode.equalsIgnoreCase("othIDType"))
			if (FValue != null && !FValue.equals(""))
				othIDType = FValue.trim();
			else
				othIDType = null;
		if (FCode.equalsIgnoreCase("othIDNo"))
			if (FValue != null && !FValue.equals(""))
				othIDNo = FValue.trim();
			else
				othIDNo = null;
		if (FCode.equalsIgnoreCase("iCNo"))
			if (FValue != null && !FValue.equals(""))
				iCNo = FValue.trim();
			else
				iCNo = null;
		if (FCode.equalsIgnoreCase("grpNo"))
			if (FValue != null && !FValue.equals(""))
				grpNo = FValue.trim();
			else
				grpNo = null;
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
		if (FCode.equalsIgnoreCase("deathDate"))
			if (FValue != null && !FValue.equals(""))
				deathDate = fDate.getDate(FValue);
			else
				deathDate = null;
		if (FCode.equalsIgnoreCase("smokeFlag"))
			if (FValue != null && !FValue.equals(""))
				smokeFlag = FValue.trim();
			else
				smokeFlag = null;
		if (FCode.equalsIgnoreCase("blacklistFlag"))
			if (FValue != null && !FValue.equals(""))
				blacklistFlag = FValue.trim();
			else
				blacklistFlag = null;
		if (FCode.equalsIgnoreCase("proterty"))
			if (FValue != null && !FValue.equals(""))
				proterty = FValue.trim();
			else
				proterty = null;
		if (FCode.equalsIgnoreCase("remark"))
			if (FValue != null && !FValue.equals(""))
				remark = FValue.trim();
			else
				remark = null;
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("vIPValue"))
			if (FValue != null && !FValue.equals(""))
				vIPValue = FValue.trim();
			else
				vIPValue = null;
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
		if (FCode.equalsIgnoreCase("grpName"))
			if (FValue != null && !FValue.equals(""))
				grpName = FValue.trim();
			else
				grpName = null;
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
		LNPPersonSchema other = (LNPPersonSchema)otherObject;
		if (customerId == null && other.getCustomerId() != null)
			return false;
		if (customerId != null && !customerId.equals(other.getCustomerId()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (customerNo == null && other.getCustomerNo() != null)
			return false;
		if (customerNo != null && !customerNo.equals(other.getCustomerNo()))
			return false;
		if (appellation == null && other.getAppellation() != null)
			return false;
		if (appellation != null && !appellation.equals(other.getAppellation()))
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
		if (age != other.getAge())
			return false;
		if (ageType == null && other.getAgeType() != null)
			return false;
		if (ageType != null && !ageType.equals(other.getAgeType()))
			return false;
		if (appntType == null && other.getAppntType() != null)
			return false;
		if (appntType != null && !appntType.equals(other.getAppntType()))
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
		if (password == null && other.getPassword() != null)
			return false;
		if (password != null && !password.equals(other.getPassword()))
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
		if (othIDType == null && other.getOthIDType() != null)
			return false;
		if (othIDType != null && !othIDType.equals(other.getOthIDType()))
			return false;
		if (othIDNo == null && other.getOthIDNo() != null)
			return false;
		if (othIDNo != null && !othIDNo.equals(other.getOthIDNo()))
			return false;
		if (iCNo == null && other.getICNo() != null)
			return false;
		if (iCNo != null && !iCNo.equals(other.getICNo()))
			return false;
		if (grpNo == null && other.getGrpNo() != null)
			return false;
		if (grpNo != null && !grpNo.equals(other.getGrpNo()))
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
		if (deathDate == null && other.getDeathDate() != null)
			return false;
		if (deathDate != null && !fDate.getString(deathDate).equals(other.getDeathDate()))
			return false;
		if (smokeFlag == null && other.getSmokeFlag() != null)
			return false;
		if (smokeFlag != null && !smokeFlag.equals(other.getSmokeFlag()))
			return false;
		if (blacklistFlag == null && other.getBlacklistFlag() != null)
			return false;
		if (blacklistFlag != null && !blacklistFlag.equals(other.getBlacklistFlag()))
			return false;
		if (proterty == null && other.getProterty() != null)
			return false;
		if (proterty != null && !proterty.equals(other.getProterty()))
			return false;
		if (remark == null && other.getRemark() != null)
			return false;
		if (remark != null && !remark.equals(other.getRemark()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (vIPValue == null && other.getVIPValue() != null)
			return false;
		if (vIPValue != null && !vIPValue.equals(other.getVIPValue()))
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
		if (modifyTime != null && !modifyTime.equals(other.getModifyTime()))
			return false;
		if (grpName == null && other.getGrpName() != null)
			return false;
		return grpName == null || grpName.equals(other.getGrpName());
	}

	public int getFieldCount()
	{
		return 56;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("customerId"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 1;
		if (strFieldName.equals("customerNo"))
			return 2;
		if (strFieldName.equals("appellation"))
			return 3;
		if (strFieldName.equals("name"))
			return 4;
		if (strFieldName.equals("sex"))
			return 5;
		if (strFieldName.equals("birthday"))
			return 6;
		if (strFieldName.equals("age"))
			return 7;
		if (strFieldName.equals("ageType"))
			return 8;
		if (strFieldName.equals("appntType"))
			return 9;
		if (strFieldName.equals("iDType"))
			return 10;
		if (strFieldName.equals("iDNo"))
			return 11;
		if (strFieldName.equals("iDValidity"))
			return 12;
		if (strFieldName.equals("iDPerpetual"))
			return 13;
		if (strFieldName.equals("password"))
			return 14;
		if (strFieldName.equals("nativePlace"))
			return 15;
		if (strFieldName.equals("nationality"))
			return 16;
		if (strFieldName.equals("rgtAddress"))
			return 17;
		if (strFieldName.equals("marriage"))
			return 18;
		if (strFieldName.equals("marriageDate"))
			return 19;
		if (strFieldName.equals("health"))
			return 20;
		if (strFieldName.equals("stature"))
			return 21;
		if (strFieldName.equals("avoirdupois"))
			return 22;
		if (strFieldName.equals("degree"))
			return 23;
		if (strFieldName.equals("creditGrade"))
			return 24;
		if (strFieldName.equals("bankCode"))
			return 25;
		if (strFieldName.equals("bankAccNo"))
			return 26;
		if (strFieldName.equals("accName"))
			return 27;
		if (strFieldName.equals("othIDType"))
			return 28;
		if (strFieldName.equals("othIDNo"))
			return 29;
		if (strFieldName.equals("iCNo"))
			return 30;
		if (strFieldName.equals("grpNo"))
			return 31;
		if (strFieldName.equals("joinCompanyDate"))
			return 32;
		if (strFieldName.equals("startWorkDate"))
			return 33;
		if (strFieldName.equals("position"))
			return 34;
		if (strFieldName.equals("salary"))
			return 35;
		if (strFieldName.equals("occupationType"))
			return 36;
		if (strFieldName.equals("occupationCode"))
			return 37;
		if (strFieldName.equals("partOccupationType"))
			return 38;
		if (strFieldName.equals("partOccupationCode"))
			return 39;
		if (strFieldName.equals("workType"))
			return 40;
		if (strFieldName.equals("pluralityType"))
			return 41;
		if (strFieldName.equals("deathDate"))
			return 42;
		if (strFieldName.equals("smokeFlag"))
			return 43;
		if (strFieldName.equals("blacklistFlag"))
			return 44;
		if (strFieldName.equals("proterty"))
			return 45;
		if (strFieldName.equals("remark"))
			return 46;
		if (strFieldName.equals("state"))
			return 47;
		if (strFieldName.equals("vIPValue"))
			return 48;
		if (strFieldName.equals("operator"))
			return 49;
		if (strFieldName.equals("manageCom"))
			return 50;
		if (strFieldName.equals("makeDate"))
			return 51;
		if (strFieldName.equals("makeTime"))
			return 52;
		if (strFieldName.equals("modifyDate"))
			return 53;
		if (strFieldName.equals("modifyTime"))
			return 54;
		return !strFieldName.equals("grpName") ? -1 : 55;
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
			strFieldName = "agentCode";
			break;

		case 2: // '\002'
			strFieldName = "customerNo";
			break;

		case 3: // '\003'
			strFieldName = "appellation";
			break;

		case 4: // '\004'
			strFieldName = "name";
			break;

		case 5: // '\005'
			strFieldName = "sex";
			break;

		case 6: // '\006'
			strFieldName = "birthday";
			break;

		case 7: // '\007'
			strFieldName = "age";
			break;

		case 8: // '\b'
			strFieldName = "ageType";
			break;

		case 9: // '\t'
			strFieldName = "appntType";
			break;

		case 10: // '\n'
			strFieldName = "iDType";
			break;

		case 11: // '\013'
			strFieldName = "iDNo";
			break;

		case 12: // '\f'
			strFieldName = "iDValidity";
			break;

		case 13: // '\r'
			strFieldName = "iDPerpetual";
			break;

		case 14: // '\016'
			strFieldName = "password";
			break;

		case 15: // '\017'
			strFieldName = "nativePlace";
			break;

		case 16: // '\020'
			strFieldName = "nationality";
			break;

		case 17: // '\021'
			strFieldName = "rgtAddress";
			break;

		case 18: // '\022'
			strFieldName = "marriage";
			break;

		case 19: // '\023'
			strFieldName = "marriageDate";
			break;

		case 20: // '\024'
			strFieldName = "health";
			break;

		case 21: // '\025'
			strFieldName = "stature";
			break;

		case 22: // '\026'
			strFieldName = "avoirdupois";
			break;

		case 23: // '\027'
			strFieldName = "degree";
			break;

		case 24: // '\030'
			strFieldName = "creditGrade";
			break;

		case 25: // '\031'
			strFieldName = "bankCode";
			break;

		case 26: // '\032'
			strFieldName = "bankAccNo";
			break;

		case 27: // '\033'
			strFieldName = "accName";
			break;

		case 28: // '\034'
			strFieldName = "othIDType";
			break;

		case 29: // '\035'
			strFieldName = "othIDNo";
			break;

		case 30: // '\036'
			strFieldName = "iCNo";
			break;

		case 31: // '\037'
			strFieldName = "grpNo";
			break;

		case 32: // ' '
			strFieldName = "joinCompanyDate";
			break;

		case 33: // '!'
			strFieldName = "startWorkDate";
			break;

		case 34: // '"'
			strFieldName = "position";
			break;

		case 35: // '#'
			strFieldName = "salary";
			break;

		case 36: // '$'
			strFieldName = "occupationType";
			break;

		case 37: // '%'
			strFieldName = "occupationCode";
			break;

		case 38: // '&'
			strFieldName = "partOccupationType";
			break;

		case 39: // '\''
			strFieldName = "partOccupationCode";
			break;

		case 40: // '('
			strFieldName = "workType";
			break;

		case 41: // ')'
			strFieldName = "pluralityType";
			break;

		case 42: // '*'
			strFieldName = "deathDate";
			break;

		case 43: // '+'
			strFieldName = "smokeFlag";
			break;

		case 44: // ','
			strFieldName = "blacklistFlag";
			break;

		case 45: // '-'
			strFieldName = "proterty";
			break;

		case 46: // '.'
			strFieldName = "remark";
			break;

		case 47: // '/'
			strFieldName = "state";
			break;

		case 48: // '0'
			strFieldName = "vIPValue";
			break;

		case 49: // '1'
			strFieldName = "operator";
			break;

		case 50: // '2'
			strFieldName = "manageCom";
			break;

		case 51: // '3'
			strFieldName = "makeDate";
			break;

		case 52: // '4'
			strFieldName = "makeTime";
			break;

		case 53: // '5'
			strFieldName = "modifyDate";
			break;

		case 54: // '6'
			strFieldName = "modifyTime";
			break;

		case 55: // '7'
			strFieldName = "grpName";
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
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("customerNo"))
			return 0;
		if (strFieldName.equals("appellation"))
			return 0;
		if (strFieldName.equals("name"))
			return 0;
		if (strFieldName.equals("sex"))
			return 0;
		if (strFieldName.equals("birthday"))
			return 1;
		if (strFieldName.equals("age"))
			return 3;
		if (strFieldName.equals("ageType"))
			return 0;
		if (strFieldName.equals("appntType"))
			return 0;
		if (strFieldName.equals("iDType"))
			return 0;
		if (strFieldName.equals("iDNo"))
			return 0;
		if (strFieldName.equals("iDValidity"))
			return 1;
		if (strFieldName.equals("iDPerpetual"))
			return 0;
		if (strFieldName.equals("password"))
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
		if (strFieldName.equals("othIDType"))
			return 0;
		if (strFieldName.equals("othIDNo"))
			return 0;
		if (strFieldName.equals("iCNo"))
			return 0;
		if (strFieldName.equals("grpNo"))
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
		if (strFieldName.equals("deathDate"))
			return 1;
		if (strFieldName.equals("smokeFlag"))
			return 0;
		if (strFieldName.equals("blacklistFlag"))
			return 0;
		if (strFieldName.equals("proterty"))
			return 0;
		if (strFieldName.equals("remark"))
			return 0;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("vIPValue"))
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
		if (strFieldName.equals("modifyTime"))
			return 0;
		return !strFieldName.equals("grpName") ? -1 : 0;
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
			nFieldType = 1;
			break;

		case 7: // '\007'
			nFieldType = 3;
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
			nFieldType = 0;
			break;

		case 19: // '\023'
			nFieldType = 1;
			break;

		case 20: // '\024'
			nFieldType = 0;
			break;

		case 21: // '\025'
			nFieldType = 4;
			break;

		case 22: // '\026'
			nFieldType = 4;
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
			nFieldType = 0;
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
			nFieldType = 1;
			break;

		case 33: // '!'
			nFieldType = 1;
			break;

		case 34: // '"'
			nFieldType = 0;
			break;

		case 35: // '#'
			nFieldType = 4;
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
			nFieldType = 0;
			break;

		case 40: // '('
			nFieldType = 0;
			break;

		case 41: // ')'
			nFieldType = 0;
			break;

		case 42: // '*'
			nFieldType = 1;
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
			nFieldType = 1;
			break;

		case 52: // '4'
			nFieldType = 0;
			break;

		case 53: // '5'
			nFieldType = 1;
			break;

		case 54: // '6'
			nFieldType = 0;
			break;

		case 55: // '7'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
