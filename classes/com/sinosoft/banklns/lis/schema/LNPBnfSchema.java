// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPBnfSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPBnfDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPBnfSchema
	implements Schema
{

	private String ContNo;
	private String PolNo;
	private String InsuredNo;
	private String InsuredId;
	private String BenefitType;
	private int BnfOrder;
	private String BnfGrade;
	private double BenefitRate;
	private String BenefitOrder;
	private String BnfNo;
	private String BnfId;
	private String Appellation;
	private String BnfName;
	private String BnfSex;
	private String BnfBirthday;
	private int BnfAge;
	private String RelationToInsured;
	private String AddressNo;
	private String IDType;
	private String IDNo;
	private String IDValidity;
	private String IDPerpetual;
	private String NativePlace;
	private String Nationality;
	private String RgtAddress;
	private String Marriage;
	private String MarriageDate;
	private String Health;
	private double Stature;
	private double Avoirdupois;
	private String Degree;
	private String CreditGrade;
	private String BankCode;
	private String BankAccNo;
	private String AccName;
	private String JoinCompanyDate;
	private String StartWorkDate;
	private String Position;
	private double Salary;
	private String OccupationType;
	private String OccupationCode;
	private String WorkType;
	private String PluralityType;
	private String SmokeFlag;
	private String BnfFlag;
	private String Operator;
	private String ManageCom;
	private String MakeDate;
	private String MakeTime;
	private String ModifyDate;
	private String ModifyTime;
	private String newbnfname;
	private String newbnfbirthday;
	public static final int FIELDNUM = 53;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPBnfSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[5];
		pk[0] = "ContNo";
		pk[1] = "InsuredId";
		pk[2] = "BenefitType";
		pk[3] = "BnfOrder";
		pk[4] = "BnfId";
		PK = pk;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getContNo()
	{
		if (ContNo != null)
			ContNo.equals("");
		return ContNo;
	}

	public void setContNo(String aContNo)
	{
		ContNo = aContNo;
	}

	public String getPolNo()
	{
		if (PolNo != null)
			PolNo.equals("");
		return PolNo;
	}

	public void setPolNo(String aPolNo)
	{
		PolNo = aPolNo;
	}

	public String getInsuredNo()
	{
		if (InsuredNo != null)
			InsuredNo.equals("");
		return InsuredNo;
	}

	public void setInsuredNo(String aInsuredNo)
	{
		InsuredNo = aInsuredNo;
	}

	public String getInsuredId()
	{
		if (InsuredId != null)
			InsuredId.equals("");
		return InsuredId;
	}

	public void setInsuredId(String aInsuredId)
	{
		InsuredId = aInsuredId;
	}

	public String getBenefitType()
	{
		if (BenefitType != null)
			BenefitType.equals("");
		return BenefitType;
	}

	public void setBenefitType(String aBenefitType)
	{
		BenefitType = aBenefitType;
	}

	public int getBnfOrder()
	{
		return BnfOrder;
	}

	public void setBnfOrder(int aBnfOrder)
	{
		BnfOrder = aBnfOrder;
	}

	public void setBnfOrder(String aBnfOrder)
	{
		if (aBnfOrder != null && !aBnfOrder.equals(""))
		{
			Integer tInteger = new Integer(aBnfOrder);
			int i = tInteger.intValue();
			BnfOrder = i;
		}
	}

	public String getBnfGrade()
	{
		if (BnfGrade != null)
			BnfGrade.equals("");
		return BnfGrade;
	}

	public void setBnfGrade(String aBnfGrade)
	{
		BnfGrade = aBnfGrade;
	}

	public double getBenefitRate()
	{
		return BenefitRate;
	}

	public void setBenefitRate(double aBenefitRate)
	{
		BenefitRate = aBenefitRate;
	}

	public void setBenefitRate(String aBenefitRate)
	{
		if (aBenefitRate != null && !aBenefitRate.equals(""))
		{
			Double tDouble = new Double(aBenefitRate);
			double d = tDouble.doubleValue();
			BenefitRate = d;
		}
	}

	public String getBenefitOrder()
	{
		if (BenefitOrder != null)
			BenefitOrder.equals("");
		return BenefitOrder;
	}

	public void setBenefitOrder(String aBenefitOrder)
	{
		BenefitOrder = aBenefitOrder;
	}

	public String getBnfNo()
	{
		if (BnfNo != null)
			BnfNo.equals("");
		return BnfNo;
	}

	public void setBnfNo(String aBnfNo)
	{
		BnfNo = aBnfNo;
	}

	public String getBnfId()
	{
		if (BnfId != null)
			BnfId.equals("");
		return BnfId;
	}

	public void setBnfId(String aBnfId)
	{
		BnfId = aBnfId;
	}

	public String getAppellation()
	{
		if (Appellation != null)
			Appellation.equals("");
		return Appellation;
	}

	public void setAppellation(String aAppellation)
	{
		Appellation = aAppellation;
	}

	public String getBnfName()
	{
		if (BnfName != null)
			BnfName.equals("");
		return BnfName;
	}

	public void setBnfName(String aBnfName)
	{
		BnfName = aBnfName;
	}

	public String getBnfSex()
	{
		if (BnfSex != null)
			BnfSex.equals("");
		return BnfSex;
	}

	public void setBnfSex(String aBnfSex)
	{
		BnfSex = aBnfSex;
	}

	public String getBnfBirthday()
	{
		if (BnfBirthday != null)
			BnfBirthday.equals("");
		return BnfBirthday;
	}

	public void setBnfBirthday(String aBnfBirthday)
	{
		BnfBirthday = aBnfBirthday;
	}

	public int getBnfAge()
	{
		return BnfAge;
	}

	public void setBnfAge(int aBnfAge)
	{
		BnfAge = aBnfAge;
	}

	public void setBnfAge(String aBnfAge)
	{
		if (aBnfAge != null && !aBnfAge.equals(""))
		{
			Integer tInteger = new Integer(aBnfAge);
			int i = tInteger.intValue();
			BnfAge = i;
		}
	}

	public String getRelationToInsured()
	{
		if (RelationToInsured != null)
			RelationToInsured.equals("");
		return RelationToInsured;
	}

	public void setRelationToInsured(String aRelationToInsured)
	{
		RelationToInsured = aRelationToInsured;
	}

	public String getAddressNo()
	{
		if (AddressNo != null)
			AddressNo.equals("");
		return AddressNo;
	}

	public void setAddressNo(String aAddressNo)
	{
		AddressNo = aAddressNo;
	}

	public String getIDType()
	{
		if (IDType != null)
			IDType.equals("");
		return IDType;
	}

	public void setIDType(String aIDType)
	{
		IDType = aIDType;
	}

	public String getIDNo()
	{
		if (IDNo != null)
			IDNo.equals("");
		return IDNo;
	}

	public void setIDNo(String aIDNo)
	{
		IDNo = aIDNo;
	}

	public String getIDValidity()
	{
		if (IDValidity != null)
			IDValidity.equals("");
		return IDValidity;
	}

	public void setIDValidity(String aIDValidity)
	{
		IDValidity = aIDValidity;
	}

	public String getIDPerpetual()
	{
		if (IDPerpetual != null)
			IDPerpetual.equals("");
		return IDPerpetual;
	}

	public void setIDPerpetual(String aIDPerpetual)
	{
		IDPerpetual = aIDPerpetual;
	}

	public String getNativePlace()
	{
		if (NativePlace != null)
			NativePlace.equals("");
		return NativePlace;
	}

	public void setNativePlace(String aNativePlace)
	{
		NativePlace = aNativePlace;
	}

	public String getNationality()
	{
		if (Nationality != null)
			Nationality.equals("");
		return Nationality;
	}

	public void setNationality(String aNationality)
	{
		Nationality = aNationality;
	}

	public String getRgtAddress()
	{
		if (RgtAddress != null)
			RgtAddress.equals("");
		return RgtAddress;
	}

	public void setRgtAddress(String aRgtAddress)
	{
		RgtAddress = aRgtAddress;
	}

	public String getMarriage()
	{
		if (Marriage != null)
			Marriage.equals("");
		return Marriage;
	}

	public void setMarriage(String aMarriage)
	{
		Marriage = aMarriage;
	}

	public String getMarriageDate()
	{
		if (MarriageDate != null)
			MarriageDate.equals("");
		return MarriageDate;
	}

	public void setMarriageDate(String aMarriageDate)
	{
		MarriageDate = aMarriageDate;
	}

	public String getHealth()
	{
		if (Health != null)
			Health.equals("");
		return Health;
	}

	public void setHealth(String aHealth)
	{
		Health = aHealth;
	}

	public double getStature()
	{
		return Stature;
	}

	public void setStature(double aStature)
	{
		Stature = aStature;
	}

	public void setStature(String aStature)
	{
		if (aStature != null && !aStature.equals(""))
		{
			Double tDouble = new Double(aStature);
			double d = tDouble.doubleValue();
			Stature = d;
		}
	}

	public double getAvoirdupois()
	{
		return Avoirdupois;
	}

	public void setAvoirdupois(double aAvoirdupois)
	{
		Avoirdupois = aAvoirdupois;
	}

	public void setAvoirdupois(String aAvoirdupois)
	{
		if (aAvoirdupois != null && !aAvoirdupois.equals(""))
		{
			Double tDouble = new Double(aAvoirdupois);
			double d = tDouble.doubleValue();
			Avoirdupois = d;
		}
	}

	public String getDegree()
	{
		if (Degree != null)
			Degree.equals("");
		return Degree;
	}

	public void setDegree(String aDegree)
	{
		Degree = aDegree;
	}

	public String getCreditGrade()
	{
		if (CreditGrade != null)
			CreditGrade.equals("");
		return CreditGrade;
	}

	public void setCreditGrade(String aCreditGrade)
	{
		CreditGrade = aCreditGrade;
	}

	public String getBankCode()
	{
		if (BankCode != null)
			BankCode.equals("");
		return BankCode;
	}

	public void setBankCode(String aBankCode)
	{
		BankCode = aBankCode;
	}

	public String getBankAccNo()
	{
		if (BankAccNo != null)
			BankAccNo.equals("");
		return BankAccNo;
	}

	public void setBankAccNo(String aBankAccNo)
	{
		BankAccNo = aBankAccNo;
	}

	public String getAccName()
	{
		if (AccName != null)
			AccName.equals("");
		return AccName;
	}

	public void setAccName(String aAccName)
	{
		AccName = aAccName;
	}

	public String getJoinCompanyDate()
	{
		if (JoinCompanyDate != null)
			JoinCompanyDate.equals("");
		return JoinCompanyDate;
	}

	public void setJoinCompanyDate(String aJoinCompanyDate)
	{
		JoinCompanyDate = aJoinCompanyDate;
	}

	public String getStartWorkDate()
	{
		if (StartWorkDate != null)
			StartWorkDate.equals("");
		return StartWorkDate;
	}

	public void setStartWorkDate(String aStartWorkDate)
	{
		StartWorkDate = aStartWorkDate;
	}

	public String getPosition()
	{
		if (Position != null)
			Position.equals("");
		return Position;
	}

	public void setPosition(String aPosition)
	{
		Position = aPosition;
	}

	public double getSalary()
	{
		return Salary;
	}

	public void setSalary(double aSalary)
	{
		Salary = aSalary;
	}

	public void setSalary(String aSalary)
	{
		if (aSalary != null && !aSalary.equals(""))
		{
			Double tDouble = new Double(aSalary);
			double d = tDouble.doubleValue();
			Salary = d;
		}
	}

	public String getOccupationType()
	{
		if (OccupationType != null)
			OccupationType.equals("");
		return OccupationType;
	}

	public void setOccupationType(String aOccupationType)
	{
		OccupationType = aOccupationType;
	}

	public String getOccupationCode()
	{
		if (OccupationCode != null)
			OccupationCode.equals("");
		return OccupationCode;
	}

	public void setOccupationCode(String aOccupationCode)
	{
		OccupationCode = aOccupationCode;
	}

	public String getWorkType()
	{
		if (WorkType != null)
			WorkType.equals("");
		return WorkType;
	}

	public void setWorkType(String aWorkType)
	{
		WorkType = aWorkType;
	}

	public String getPluralityType()
	{
		if (PluralityType != null)
			PluralityType.equals("");
		return PluralityType;
	}

	public void setPluralityType(String aPluralityType)
	{
		PluralityType = aPluralityType;
	}

	public String getSmokeFlag()
	{
		if (SmokeFlag != null)
			SmokeFlag.equals("");
		return SmokeFlag;
	}

	public void setSmokeFlag(String aSmokeFlag)
	{
		SmokeFlag = aSmokeFlag;
	}

	public String getBnfFlag()
	{
		if (BnfFlag != null)
			BnfFlag.equals("");
		return BnfFlag;
	}

	public void setBnfFlag(String aBnfFlag)
	{
		BnfFlag = aBnfFlag;
	}

	public String getOperator()
	{
		if (Operator != null)
			Operator.equals("");
		return Operator;
	}

	public void setOperator(String aOperator)
	{
		Operator = aOperator;
	}

	public String getManageCom()
	{
		if (ManageCom != null)
			ManageCom.equals("");
		return ManageCom;
	}

	public void setManageCom(String aManageCom)
	{
		ManageCom = aManageCom;
	}

	public String getMakeDate()
	{
		if (MakeDate != null)
			MakeDate.equals("");
		return MakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		MakeDate = aMakeDate;
	}

	public String getMakeTime()
	{
		if (MakeTime != null)
			MakeTime.equals("");
		return MakeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		MakeTime = aMakeTime;
	}

	public String getModifyDate()
	{
		if (ModifyDate != null)
			ModifyDate.equals("");
		return ModifyDate;
	}

	public void setModifyDate(String aModifyDate)
	{
		ModifyDate = aModifyDate;
	}

	public String getModifyTime()
	{
		if (ModifyTime != null)
			ModifyTime.equals("");
		return ModifyTime;
	}

	public void setModifyTime(String aModifyTime)
	{
		ModifyTime = aModifyTime;
	}

	public String getnewbnfname()
	{
		if (newbnfname != null)
			newbnfname.equals("");
		return newbnfname;
	}

	public void setnewbnfname(String anewbnfname)
	{
		newbnfname = anewbnfname;
	}

	public String getnewbnfbirthday()
	{
		if (newbnfbirthday != null)
			newbnfbirthday.equals("");
		return newbnfbirthday;
	}

	public void setnewbnfbirthday(String anewbnfbirthday)
	{
		newbnfbirthday = anewbnfbirthday;
	}

	public void setSchema(LNPBnfSchema aLNPBnfSchema)
	{
		ContNo = aLNPBnfSchema.getContNo();
		PolNo = aLNPBnfSchema.getPolNo();
		InsuredNo = aLNPBnfSchema.getInsuredNo();
		InsuredId = aLNPBnfSchema.getInsuredId();
		BenefitType = aLNPBnfSchema.getBenefitType();
		BnfOrder = aLNPBnfSchema.getBnfOrder();
		BnfGrade = aLNPBnfSchema.getBnfGrade();
		BenefitRate = aLNPBnfSchema.getBenefitRate();
		BenefitOrder = aLNPBnfSchema.getBenefitOrder();
		BnfNo = aLNPBnfSchema.getBnfNo();
		BnfId = aLNPBnfSchema.getBnfId();
		Appellation = aLNPBnfSchema.getAppellation();
		BnfName = aLNPBnfSchema.getBnfName();
		BnfSex = aLNPBnfSchema.getBnfSex();
		BnfBirthday = aLNPBnfSchema.getBnfBirthday();
		BnfAge = aLNPBnfSchema.getBnfAge();
		RelationToInsured = aLNPBnfSchema.getRelationToInsured();
		AddressNo = aLNPBnfSchema.getAddressNo();
		IDType = aLNPBnfSchema.getIDType();
		IDNo = aLNPBnfSchema.getIDNo();
		IDValidity = aLNPBnfSchema.getIDValidity();
		IDPerpetual = aLNPBnfSchema.getIDPerpetual();
		NativePlace = aLNPBnfSchema.getNativePlace();
		Nationality = aLNPBnfSchema.getNationality();
		RgtAddress = aLNPBnfSchema.getRgtAddress();
		Marriage = aLNPBnfSchema.getMarriage();
		MarriageDate = aLNPBnfSchema.getMarriageDate();
		Health = aLNPBnfSchema.getHealth();
		Stature = aLNPBnfSchema.getStature();
		Avoirdupois = aLNPBnfSchema.getAvoirdupois();
		Degree = aLNPBnfSchema.getDegree();
		CreditGrade = aLNPBnfSchema.getCreditGrade();
		BankCode = aLNPBnfSchema.getBankCode();
		BankAccNo = aLNPBnfSchema.getBankAccNo();
		AccName = aLNPBnfSchema.getAccName();
		JoinCompanyDate = aLNPBnfSchema.getJoinCompanyDate();
		StartWorkDate = aLNPBnfSchema.getStartWorkDate();
		Position = aLNPBnfSchema.getPosition();
		Salary = aLNPBnfSchema.getSalary();
		OccupationType = aLNPBnfSchema.getOccupationType();
		OccupationCode = aLNPBnfSchema.getOccupationCode();
		WorkType = aLNPBnfSchema.getWorkType();
		PluralityType = aLNPBnfSchema.getPluralityType();
		SmokeFlag = aLNPBnfSchema.getSmokeFlag();
		BnfFlag = aLNPBnfSchema.getBnfFlag();
		Operator = aLNPBnfSchema.getOperator();
		ManageCom = aLNPBnfSchema.getManageCom();
		MakeDate = aLNPBnfSchema.getMakeDate();
		MakeTime = aLNPBnfSchema.getMakeTime();
		ModifyDate = aLNPBnfSchema.getModifyDate();
		ModifyTime = aLNPBnfSchema.getModifyTime();
		newbnfname = aLNPBnfSchema.getnewbnfname();
		newbnfbirthday = aLNPBnfSchema.getnewbnfbirthday();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ContNo") == null)
				ContNo = null;
			else
				ContNo = rs.getString("ContNo").trim();
			if (rs.getString("PolNo") == null)
				PolNo = null;
			else
				PolNo = rs.getString("PolNo").trim();
			if (rs.getString("InsuredNo") == null)
				InsuredNo = null;
			else
				InsuredNo = rs.getString("InsuredNo").trim();
			if (rs.getString("InsuredId") == null)
				InsuredId = null;
			else
				InsuredId = rs.getString("InsuredId").trim();
			if (rs.getString("BenefitType") == null)
				BenefitType = null;
			else
				BenefitType = rs.getString("BenefitType").trim();
			BnfOrder = rs.getInt("BnfOrder");
			if (rs.getString("BnfGrade") == null)
				BnfGrade = null;
			else
				BnfGrade = rs.getString("BnfGrade").trim();
			BenefitRate = rs.getDouble("BenefitRate");
			if (rs.getString("BenefitOrder") == null)
				BenefitOrder = null;
			else
				BenefitOrder = rs.getString("BenefitOrder").trim();
			if (rs.getString("BnfNo") == null)
				BnfNo = null;
			else
				BnfNo = rs.getString("BnfNo").trim();
			if (rs.getString("BnfId") == null)
				BnfId = null;
			else
				BnfId = rs.getString("BnfId").trim();
			if (rs.getString("Appellation") == null)
				Appellation = null;
			else
				Appellation = rs.getString("Appellation").trim();
			if (rs.getString("BnfName") == null)
				BnfName = null;
			else
				BnfName = rs.getString("BnfName").trim();
			if (rs.getString("BnfSex") == null)
				BnfSex = null;
			else
				BnfSex = rs.getString("BnfSex").trim();
			if (rs.getString("BnfBirthday") == null)
				BnfBirthday = null;
			else
				BnfBirthday = rs.getString("BnfBirthday").trim();
			BnfAge = rs.getInt("BnfAge");
			if (rs.getString("RelationToInsured") == null)
				RelationToInsured = null;
			else
				RelationToInsured = rs.getString("RelationToInsured").trim();
			if (rs.getString("AddressNo") == null)
				AddressNo = null;
			else
				AddressNo = rs.getString("AddressNo").trim();
			if (rs.getString("IDType") == null)
				IDType = null;
			else
				IDType = rs.getString("IDType").trim();
			if (rs.getString("IDNo") == null)
				IDNo = null;
			else
				IDNo = rs.getString("IDNo").trim();
			if (rs.getString("IDValidity") == null)
				IDValidity = null;
			else
				IDValidity = rs.getString("IDValidity").trim();
			if (rs.getString("IDPerpetual") == null)
				IDPerpetual = null;
			else
				IDPerpetual = rs.getString("IDPerpetual").trim();
			if (rs.getString("NativePlace") == null)
				NativePlace = null;
			else
				NativePlace = rs.getString("NativePlace").trim();
			if (rs.getString("Nationality") == null)
				Nationality = null;
			else
				Nationality = rs.getString("Nationality").trim();
			if (rs.getString("RgtAddress") == null)
				RgtAddress = null;
			else
				RgtAddress = rs.getString("RgtAddress").trim();
			if (rs.getString("Marriage") == null)
				Marriage = null;
			else
				Marriage = rs.getString("Marriage").trim();
			if (rs.getString("MarriageDate") == null)
				MarriageDate = null;
			else
				MarriageDate = rs.getString("MarriageDate").trim();
			if (rs.getString("Health") == null)
				Health = null;
			else
				Health = rs.getString("Health").trim();
			Stature = rs.getDouble("Stature");
			Avoirdupois = rs.getDouble("Avoirdupois");
			if (rs.getString("Degree") == null)
				Degree = null;
			else
				Degree = rs.getString("Degree").trim();
			if (rs.getString("CreditGrade") == null)
				CreditGrade = null;
			else
				CreditGrade = rs.getString("CreditGrade").trim();
			if (rs.getString("BankCode") == null)
				BankCode = null;
			else
				BankCode = rs.getString("BankCode").trim();
			if (rs.getString("BankAccNo") == null)
				BankAccNo = null;
			else
				BankAccNo = rs.getString("BankAccNo").trim();
			if (rs.getString("AccName") == null)
				AccName = null;
			else
				AccName = rs.getString("AccName").trim();
			if (rs.getString("JoinCompanyDate") == null)
				JoinCompanyDate = null;
			else
				JoinCompanyDate = rs.getString("JoinCompanyDate").trim();
			if (rs.getString("StartWorkDate") == null)
				StartWorkDate = null;
			else
				StartWorkDate = rs.getString("StartWorkDate").trim();
			if (rs.getString("Position") == null)
				Position = null;
			else
				Position = rs.getString("Position").trim();
			Salary = rs.getDouble("Salary");
			if (rs.getString("OccupationType") == null)
				OccupationType = null;
			else
				OccupationType = rs.getString("OccupationType").trim();
			if (rs.getString("OccupationCode") == null)
				OccupationCode = null;
			else
				OccupationCode = rs.getString("OccupationCode").trim();
			if (rs.getString("WorkType") == null)
				WorkType = null;
			else
				WorkType = rs.getString("WorkType").trim();
			if (rs.getString("PluralityType") == null)
				PluralityType = null;
			else
				PluralityType = rs.getString("PluralityType").trim();
			if (rs.getString("SmokeFlag") == null)
				SmokeFlag = null;
			else
				SmokeFlag = rs.getString("SmokeFlag").trim();
			if (rs.getString("BnfFlag") == null)
				BnfFlag = null;
			else
				BnfFlag = rs.getString("BnfFlag").trim();
			if (rs.getString("Operator") == null)
				Operator = null;
			else
				Operator = rs.getString("Operator").trim();
			if (rs.getString("ManageCom") == null)
				ManageCom = null;
			else
				ManageCom = rs.getString("ManageCom").trim();
			if (rs.getString("MakeDate") == null)
				MakeDate = null;
			else
				MakeDate = rs.getString("MakeDate").trim();
			if (rs.getString("MakeTime") == null)
				MakeTime = null;
			else
				MakeTime = rs.getString("MakeTime").trim();
			if (rs.getString("ModifyDate") == null)
				ModifyDate = null;
			else
				ModifyDate = rs.getString("ModifyDate").trim();
			if (rs.getString("ModifyTime") == null)
				ModifyTime = null;
			else
				ModifyTime = rs.getString("ModifyTime").trim();
			if (rs.getString("newbnfname") == null)
				newbnfname = null;
			else
				newbnfname = rs.getString("newbnfname").trim();
			if (rs.getString("newbnfbirthday") == null)
				newbnfbirthday = null;
			else
				newbnfbirthday = rs.getString("newbnfbirthday").trim();
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPBnfSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPBnfSchema getSchema()
	{
		LNPBnfSchema aLNPBnfSchema = new LNPBnfSchema();
		aLNPBnfSchema.setSchema(this);
		return aLNPBnfSchema;
	}

	public LNPBnfDB getDB()
	{
		LNPBnfDB aDBOper = new LNPBnfDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(ContNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(PolNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(InsuredNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(InsuredId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BenefitType))).append("|").append(ChgData.chgData(BnfOrder)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BnfGrade))).append("|").append(ChgData.chgData(BenefitRate)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BenefitOrder))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BnfNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BnfId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Appellation))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BnfName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BnfSex))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BnfBirthday))).append("|").append(ChgData.chgData(BnfAge)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(RelationToInsured))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(AddressNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(IDType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(IDNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(IDValidity))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(IDPerpetual))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(NativePlace))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Nationality))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(RgtAddress))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Marriage))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MarriageDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Health))).append("|").append(ChgData.chgData(Stature)).append("|").append(ChgData.chgData(Avoirdupois)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Degree))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(CreditGrade))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BankCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BankAccNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(AccName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(JoinCompanyDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(StartWorkDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Position))).append("|").append(ChgData.chgData(Salary)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(OccupationType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(OccupationCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(WorkType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(PluralityType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(SmokeFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BnfFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ManageCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MakeDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MakeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ModifyDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ModifyTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(newbnfname))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(newbnfbirthday))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			PolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			InsuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			InsuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			BenefitType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			BnfOrder = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).intValue();
			BnfGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			BenefitRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).doubleValue();
			BenefitOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			BnfNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			BnfId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			Appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			BnfName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			BnfSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			BnfBirthday = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			BnfAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|")))).intValue();
			RelationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			AddressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			IDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			IDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			IDValidity = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			IDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			NativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			Nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			RgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			Marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			MarriageDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			Health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			Stature = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|")))).doubleValue();
			Avoirdupois = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|")))).doubleValue();
			Degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			CreditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			BankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			BankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			AccName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			JoinCompanyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
			StartWorkDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			Position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			Salary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|")))).doubleValue();
			OccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			OccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			WorkType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			PluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			SmokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			BnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			MakeDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			ModifyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			newbnfname = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			newbnfbirthday = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPBnfSchema";
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
		if (FCode.equals("ContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ContNo));
		if (FCode.equals("PolNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(PolNo));
		if (FCode.equals("InsuredNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuredNo));
		if (FCode.equals("InsuredId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuredId));
		if (FCode.equals("BenefitType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BenefitType));
		if (FCode.equals("BnfOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfOrder));
		if (FCode.equals("BnfGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfGrade));
		if (FCode.equals("BenefitRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BenefitRate));
		if (FCode.equals("BenefitOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BenefitOrder));
		if (FCode.equals("BnfNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfNo));
		if (FCode.equals("BnfId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfId));
		if (FCode.equals("Appellation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Appellation));
		if (FCode.equals("BnfName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfName));
		if (FCode.equals("BnfSex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfSex));
		if (FCode.equals("BnfBirthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfBirthday));
		if (FCode.equals("BnfAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfAge));
		if (FCode.equals("RelationToInsured"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(RelationToInsured));
		if (FCode.equals("AddressNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(AddressNo));
		if (FCode.equals("IDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDType));
		if (FCode.equals("IDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDNo));
		if (FCode.equals("IDValidity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDValidity));
		if (FCode.equals("IDPerpetual"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDPerpetual));
		if (FCode.equals("NativePlace"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(NativePlace));
		if (FCode.equals("Nationality"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Nationality));
		if (FCode.equals("RgtAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(RgtAddress));
		if (FCode.equals("Marriage"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Marriage));
		if (FCode.equals("MarriageDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MarriageDate));
		if (FCode.equals("Health"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Health));
		if (FCode.equals("Stature"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Stature));
		if (FCode.equals("Avoirdupois"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Avoirdupois));
		if (FCode.equals("Degree"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Degree));
		if (FCode.equals("CreditGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(CreditGrade));
		if (FCode.equals("BankCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BankCode));
		if (FCode.equals("BankAccNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BankAccNo));
		if (FCode.equals("AccName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(AccName));
		if (FCode.equals("JoinCompanyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(JoinCompanyDate));
		if (FCode.equals("StartWorkDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(StartWorkDate));
		if (FCode.equals("Position"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Position));
		if (FCode.equals("Salary"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Salary));
		if (FCode.equals("OccupationType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(OccupationType));
		if (FCode.equals("OccupationCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(OccupationCode));
		if (FCode.equals("WorkType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(WorkType));
		if (FCode.equals("PluralityType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(PluralityType));
		if (FCode.equals("SmokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(SmokeFlag));
		if (FCode.equals("BnfFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfFlag));
		if (FCode.equals("Operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		if (FCode.equals("ManageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		if (FCode.equals("MakeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeDate));
		if (FCode.equals("MakeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		if (FCode.equals("ModifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyDate));
		if (FCode.equals("ModifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime));
		if (FCode.equals("newbnfname"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(newbnfname));
		if (FCode.equals("newbnfbirthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(newbnfbirthday));
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
			strFieldValue = StrTool.GBKToUnicode(ContNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(PolNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(InsuredNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(InsuredId);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(BenefitType);
			break;

		case 5: // '\005'
			strFieldValue = String.valueOf(BnfOrder);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(BnfGrade);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(BenefitRate);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(BenefitOrder);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(BnfNo);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(BnfId);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(Appellation);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(BnfName);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(BnfSex);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(BnfBirthday);
			break;

		case 15: // '\017'
			strFieldValue = String.valueOf(BnfAge);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(RelationToInsured);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(AddressNo);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(IDType);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(IDNo);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(IDValidity);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(IDPerpetual);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(NativePlace);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(Nationality);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(RgtAddress);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(Marriage);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(MarriageDate);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(Health);
			break;

		case 28: // '\034'
			strFieldValue = String.valueOf(Stature);
			break;

		case 29: // '\035'
			strFieldValue = String.valueOf(Avoirdupois);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(Degree);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(CreditGrade);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(BankCode);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(BankAccNo);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(AccName);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(JoinCompanyDate);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(StartWorkDate);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(Position);
			break;

		case 38: // '&'
			strFieldValue = String.valueOf(Salary);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(OccupationType);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(OccupationCode);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(WorkType);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(PluralityType);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(SmokeFlag);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(BnfFlag);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(Operator);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(ManageCom);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(MakeDate);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(MakeTime);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(ModifyDate);
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(ModifyTime);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(newbnfname);
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(newbnfbirthday);
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
		if (FCode.equals("ContNo"))
			if (FValue != null && !FValue.equals(""))
				ContNo = FValue.trim();
			else
				ContNo = null;
		if (FCode.equals("PolNo"))
			if (FValue != null && !FValue.equals(""))
				PolNo = FValue.trim();
			else
				PolNo = null;
		if (FCode.equals("InsuredNo"))
			if (FValue != null && !FValue.equals(""))
				InsuredNo = FValue.trim();
			else
				InsuredNo = null;
		if (FCode.equals("InsuredId"))
			if (FValue != null && !FValue.equals(""))
				InsuredId = FValue.trim();
			else
				InsuredId = null;
		if (FCode.equals("BenefitType"))
			if (FValue != null && !FValue.equals(""))
				BenefitType = FValue.trim();
			else
				BenefitType = null;
		if (FCode.equals("BnfOrder") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			BnfOrder = i;
		}
		if (FCode.equals("BnfGrade"))
			if (FValue != null && !FValue.equals(""))
				BnfGrade = FValue.trim();
			else
				BnfGrade = null;
		if (FCode.equals("BenefitRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			BenefitRate = d;
		}
		if (FCode.equals("BenefitOrder"))
			if (FValue != null && !FValue.equals(""))
				BenefitOrder = FValue.trim();
			else
				BenefitOrder = null;
		if (FCode.equals("BnfNo"))
			if (FValue != null && !FValue.equals(""))
				BnfNo = FValue.trim();
			else
				BnfNo = null;
		if (FCode.equals("BnfId"))
			if (FValue != null && !FValue.equals(""))
				BnfId = FValue.trim();
			else
				BnfId = null;
		if (FCode.equals("Appellation"))
			if (FValue != null && !FValue.equals(""))
				Appellation = FValue.trim();
			else
				Appellation = null;
		if (FCode.equals("BnfName"))
			if (FValue != null && !FValue.equals(""))
				BnfName = FValue.trim();
			else
				BnfName = null;
		if (FCode.equals("BnfSex"))
			if (FValue != null && !FValue.equals(""))
				BnfSex = FValue.trim();
			else
				BnfSex = null;
		if (FCode.equals("BnfBirthday"))
			if (FValue != null && !FValue.equals(""))
				BnfBirthday = FValue.trim();
			else
				BnfBirthday = null;
		if (FCode.equals("BnfAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			BnfAge = i;
		}
		if (FCode.equals("RelationToInsured"))
			if (FValue != null && !FValue.equals(""))
				RelationToInsured = FValue.trim();
			else
				RelationToInsured = null;
		if (FCode.equals("AddressNo"))
			if (FValue != null && !FValue.equals(""))
				AddressNo = FValue.trim();
			else
				AddressNo = null;
		if (FCode.equals("IDType"))
			if (FValue != null && !FValue.equals(""))
				IDType = FValue.trim();
			else
				IDType = null;
		if (FCode.equals("IDNo"))
			if (FValue != null && !FValue.equals(""))
				IDNo = FValue.trim();
			else
				IDNo = null;
		if (FCode.equals("IDValidity"))
			if (FValue != null && !FValue.equals(""))
				IDValidity = FValue.trim();
			else
				IDValidity = null;
		if (FCode.equals("IDPerpetual"))
			if (FValue != null && !FValue.equals(""))
				IDPerpetual = FValue.trim();
			else
				IDPerpetual = null;
		if (FCode.equals("NativePlace"))
			if (FValue != null && !FValue.equals(""))
				NativePlace = FValue.trim();
			else
				NativePlace = null;
		if (FCode.equals("Nationality"))
			if (FValue != null && !FValue.equals(""))
				Nationality = FValue.trim();
			else
				Nationality = null;
		if (FCode.equals("RgtAddress"))
			if (FValue != null && !FValue.equals(""))
				RgtAddress = FValue.trim();
			else
				RgtAddress = null;
		if (FCode.equals("Marriage"))
			if (FValue != null && !FValue.equals(""))
				Marriage = FValue.trim();
			else
				Marriage = null;
		if (FCode.equals("MarriageDate"))
			if (FValue != null && !FValue.equals(""))
				MarriageDate = FValue.trim();
			else
				MarriageDate = null;
		if (FCode.equals("Health"))
			if (FValue != null && !FValue.equals(""))
				Health = FValue.trim();
			else
				Health = null;
		if (FCode.equals("Stature") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			Stature = d;
		}
		if (FCode.equals("Avoirdupois") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			Avoirdupois = d;
		}
		if (FCode.equals("Degree"))
			if (FValue != null && !FValue.equals(""))
				Degree = FValue.trim();
			else
				Degree = null;
		if (FCode.equals("CreditGrade"))
			if (FValue != null && !FValue.equals(""))
				CreditGrade = FValue.trim();
			else
				CreditGrade = null;
		if (FCode.equals("BankCode"))
			if (FValue != null && !FValue.equals(""))
				BankCode = FValue.trim();
			else
				BankCode = null;
		if (FCode.equals("BankAccNo"))
			if (FValue != null && !FValue.equals(""))
				BankAccNo = FValue.trim();
			else
				BankAccNo = null;
		if (FCode.equals("AccName"))
			if (FValue != null && !FValue.equals(""))
				AccName = FValue.trim();
			else
				AccName = null;
		if (FCode.equals("JoinCompanyDate"))
			if (FValue != null && !FValue.equals(""))
				JoinCompanyDate = FValue.trim();
			else
				JoinCompanyDate = null;
		if (FCode.equals("StartWorkDate"))
			if (FValue != null && !FValue.equals(""))
				StartWorkDate = FValue.trim();
			else
				StartWorkDate = null;
		if (FCode.equals("Position"))
			if (FValue != null && !FValue.equals(""))
				Position = FValue.trim();
			else
				Position = null;
		if (FCode.equals("Salary") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			Salary = d;
		}
		if (FCode.equals("OccupationType"))
			if (FValue != null && !FValue.equals(""))
				OccupationType = FValue.trim();
			else
				OccupationType = null;
		if (FCode.equals("OccupationCode"))
			if (FValue != null && !FValue.equals(""))
				OccupationCode = FValue.trim();
			else
				OccupationCode = null;
		if (FCode.equals("WorkType"))
			if (FValue != null && !FValue.equals(""))
				WorkType = FValue.trim();
			else
				WorkType = null;
		if (FCode.equals("PluralityType"))
			if (FValue != null && !FValue.equals(""))
				PluralityType = FValue.trim();
			else
				PluralityType = null;
		if (FCode.equals("SmokeFlag"))
			if (FValue != null && !FValue.equals(""))
				SmokeFlag = FValue.trim();
			else
				SmokeFlag = null;
		if (FCode.equals("BnfFlag"))
			if (FValue != null && !FValue.equals(""))
				BnfFlag = FValue.trim();
			else
				BnfFlag = null;
		if (FCode.equals("Operator"))
			if (FValue != null && !FValue.equals(""))
				Operator = FValue.trim();
			else
				Operator = null;
		if (FCode.equals("ManageCom"))
			if (FValue != null && !FValue.equals(""))
				ManageCom = FValue.trim();
			else
				ManageCom = null;
		if (FCode.equals("MakeDate"))
			if (FValue != null && !FValue.equals(""))
				MakeDate = FValue.trim();
			else
				MakeDate = null;
		if (FCode.equals("MakeTime"))
			if (FValue != null && !FValue.equals(""))
				MakeTime = FValue.trim();
			else
				MakeTime = null;
		if (FCode.equals("ModifyDate"))
			if (FValue != null && !FValue.equals(""))
				ModifyDate = FValue.trim();
			else
				ModifyDate = null;
		if (FCode.equals("ModifyTime"))
			if (FValue != null && !FValue.equals(""))
				ModifyTime = FValue.trim();
			else
				ModifyTime = null;
		if (FCode.equals("newbnfname"))
			if (FValue != null && !FValue.equals(""))
				newbnfname = FValue.trim();
			else
				newbnfname = null;
		if (FCode.equals("newbnfbirthday"))
			if (FValue != null && !FValue.equals(""))
				newbnfbirthday = FValue.trim();
			else
				newbnfbirthday = null;
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
		LNPBnfSchema other = (LNPBnfSchema)otherObject;
		return ContNo.equals(other.getContNo()) && PolNo.equals(other.getPolNo()) && InsuredNo.equals(other.getInsuredNo()) && InsuredId.equals(other.getInsuredId()) && BenefitType.equals(other.getBenefitType()) && BnfOrder == other.getBnfOrder() && BnfGrade.equals(other.getBnfGrade()) && BenefitRate == other.getBenefitRate() && BenefitOrder.equals(other.getBenefitOrder()) && BnfNo.equals(other.getBnfNo()) && BnfId.equals(other.getBnfId()) && Appellation.equals(other.getAppellation()) && BnfName.equals(other.getBnfName()) && BnfSex.equals(other.getBnfSex()) && BnfBirthday.equals(other.getBnfBirthday()) && BnfAge == other.getBnfAge() && RelationToInsured.equals(other.getRelationToInsured()) && AddressNo.equals(other.getAddressNo()) && IDType.equals(other.getIDType()) && IDNo.equals(other.getIDNo()) && IDValidity.equals(other.getIDValidity()) && IDPerpetual.equals(other.getIDPerpetual()) && NativePlace.equals(other.getNativePlace()) && Nationality.equals(other.getNationality()) && RgtAddress.equals(other.getRgtAddress()) && Marriage.equals(other.getMarriage()) && MarriageDate.equals(other.getMarriageDate()) && Health.equals(other.getHealth()) && Stature == other.getStature() && Avoirdupois == other.getAvoirdupois() && Degree.equals(other.getDegree()) && CreditGrade.equals(other.getCreditGrade()) && BankCode.equals(other.getBankCode()) && BankAccNo.equals(other.getBankAccNo()) && AccName.equals(other.getAccName()) && JoinCompanyDate.equals(other.getJoinCompanyDate()) && StartWorkDate.equals(other.getStartWorkDate()) && Position.equals(other.getPosition()) && Salary == other.getSalary() && OccupationType.equals(other.getOccupationType()) && OccupationCode.equals(other.getOccupationCode()) && WorkType.equals(other.getWorkType()) && PluralityType.equals(other.getPluralityType()) && SmokeFlag.equals(other.getSmokeFlag()) && BnfFlag.equals(other.getBnfFlag()) && Operator.equals(other.getOperator()) && ManageCom.equals(other.getManageCom()) && MakeDate.equals(other.getMakeDate()) && MakeTime.equals(other.getMakeTime()) && ModifyDate.equals(other.getModifyDate()) && ModifyTime.equals(other.getModifyTime()) && newbnfname.equals(other.getnewbnfname()) && newbnfbirthday.equals(other.getnewbnfbirthday());
	}

	public int getFieldCount()
	{
		return 53;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("PolNo"))
			return 1;
		if (strFieldName.equals("InsuredNo"))
			return 2;
		if (strFieldName.equals("InsuredId"))
			return 3;
		if (strFieldName.equals("BenefitType"))
			return 4;
		if (strFieldName.equals("BnfOrder"))
			return 5;
		if (strFieldName.equals("BnfGrade"))
			return 6;
		if (strFieldName.equals("BenefitRate"))
			return 7;
		if (strFieldName.equals("BenefitOrder"))
			return 8;
		if (strFieldName.equals("BnfNo"))
			return 9;
		if (strFieldName.equals("BnfId"))
			return 10;
		if (strFieldName.equals("Appellation"))
			return 11;
		if (strFieldName.equals("BnfName"))
			return 12;
		if (strFieldName.equals("BnfSex"))
			return 13;
		if (strFieldName.equals("BnfBirthday"))
			return 14;
		if (strFieldName.equals("BnfAge"))
			return 15;
		if (strFieldName.equals("RelationToInsured"))
			return 16;
		if (strFieldName.equals("AddressNo"))
			return 17;
		if (strFieldName.equals("IDType"))
			return 18;
		if (strFieldName.equals("IDNo"))
			return 19;
		if (strFieldName.equals("IDValidity"))
			return 20;
		if (strFieldName.equals("IDPerpetual"))
			return 21;
		if (strFieldName.equals("NativePlace"))
			return 22;
		if (strFieldName.equals("Nationality"))
			return 23;
		if (strFieldName.equals("RgtAddress"))
			return 24;
		if (strFieldName.equals("Marriage"))
			return 25;
		if (strFieldName.equals("MarriageDate"))
			return 26;
		if (strFieldName.equals("Health"))
			return 27;
		if (strFieldName.equals("Stature"))
			return 28;
		if (strFieldName.equals("Avoirdupois"))
			return 29;
		if (strFieldName.equals("Degree"))
			return 30;
		if (strFieldName.equals("CreditGrade"))
			return 31;
		if (strFieldName.equals("BankCode"))
			return 32;
		if (strFieldName.equals("BankAccNo"))
			return 33;
		if (strFieldName.equals("AccName"))
			return 34;
		if (strFieldName.equals("JoinCompanyDate"))
			return 35;
		if (strFieldName.equals("StartWorkDate"))
			return 36;
		if (strFieldName.equals("Position"))
			return 37;
		if (strFieldName.equals("Salary"))
			return 38;
		if (strFieldName.equals("OccupationType"))
			return 39;
		if (strFieldName.equals("OccupationCode"))
			return 40;
		if (strFieldName.equals("WorkType"))
			return 41;
		if (strFieldName.equals("PluralityType"))
			return 42;
		if (strFieldName.equals("SmokeFlag"))
			return 43;
		if (strFieldName.equals("BnfFlag"))
			return 44;
		if (strFieldName.equals("Operator"))
			return 45;
		if (strFieldName.equals("ManageCom"))
			return 46;
		if (strFieldName.equals("MakeDate"))
			return 47;
		if (strFieldName.equals("MakeTime"))
			return 48;
		if (strFieldName.equals("ModifyDate"))
			return 49;
		if (strFieldName.equals("ModifyTime"))
			return 50;
		if (strFieldName.equals("newbnfname"))
			return 51;
		return !strFieldName.equals("newbnfbirthday") ? -1 : 52;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "ContNo";
			break;

		case 1: // '\001'
			strFieldName = "PolNo";
			break;

		case 2: // '\002'
			strFieldName = "InsuredNo";
			break;

		case 3: // '\003'
			strFieldName = "InsuredId";
			break;

		case 4: // '\004'
			strFieldName = "BenefitType";
			break;

		case 5: // '\005'
			strFieldName = "BnfOrder";
			break;

		case 6: // '\006'
			strFieldName = "BnfGrade";
			break;

		case 7: // '\007'
			strFieldName = "BenefitRate";
			break;

		case 8: // '\b'
			strFieldName = "BenefitOrder";
			break;

		case 9: // '\t'
			strFieldName = "BnfNo";
			break;

		case 10: // '\n'
			strFieldName = "BnfId";
			break;

		case 11: // '\013'
			strFieldName = "Appellation";
			break;

		case 12: // '\f'
			strFieldName = "BnfName";
			break;

		case 13: // '\r'
			strFieldName = "BnfSex";
			break;

		case 14: // '\016'
			strFieldName = "BnfBirthday";
			break;

		case 15: // '\017'
			strFieldName = "BnfAge";
			break;

		case 16: // '\020'
			strFieldName = "RelationToInsured";
			break;

		case 17: // '\021'
			strFieldName = "AddressNo";
			break;

		case 18: // '\022'
			strFieldName = "IDType";
			break;

		case 19: // '\023'
			strFieldName = "IDNo";
			break;

		case 20: // '\024'
			strFieldName = "IDValidity";
			break;

		case 21: // '\025'
			strFieldName = "IDPerpetual";
			break;

		case 22: // '\026'
			strFieldName = "NativePlace";
			break;

		case 23: // '\027'
			strFieldName = "Nationality";
			break;

		case 24: // '\030'
			strFieldName = "RgtAddress";
			break;

		case 25: // '\031'
			strFieldName = "Marriage";
			break;

		case 26: // '\032'
			strFieldName = "MarriageDate";
			break;

		case 27: // '\033'
			strFieldName = "Health";
			break;

		case 28: // '\034'
			strFieldName = "Stature";
			break;

		case 29: // '\035'
			strFieldName = "Avoirdupois";
			break;

		case 30: // '\036'
			strFieldName = "Degree";
			break;

		case 31: // '\037'
			strFieldName = "CreditGrade";
			break;

		case 32: // ' '
			strFieldName = "BankCode";
			break;

		case 33: // '!'
			strFieldName = "BankAccNo";
			break;

		case 34: // '"'
			strFieldName = "AccName";
			break;

		case 35: // '#'
			strFieldName = "JoinCompanyDate";
			break;

		case 36: // '$'
			strFieldName = "StartWorkDate";
			break;

		case 37: // '%'
			strFieldName = "Position";
			break;

		case 38: // '&'
			strFieldName = "Salary";
			break;

		case 39: // '\''
			strFieldName = "OccupationType";
			break;

		case 40: // '('
			strFieldName = "OccupationCode";
			break;

		case 41: // ')'
			strFieldName = "WorkType";
			break;

		case 42: // '*'
			strFieldName = "PluralityType";
			break;

		case 43: // '+'
			strFieldName = "SmokeFlag";
			break;

		case 44: // ','
			strFieldName = "BnfFlag";
			break;

		case 45: // '-'
			strFieldName = "Operator";
			break;

		case 46: // '.'
			strFieldName = "ManageCom";
			break;

		case 47: // '/'
			strFieldName = "MakeDate";
			break;

		case 48: // '0'
			strFieldName = "MakeTime";
			break;

		case 49: // '1'
			strFieldName = "ModifyDate";
			break;

		case 50: // '2'
			strFieldName = "ModifyTime";
			break;

		case 51: // '3'
			strFieldName = "newbnfname";
			break;

		case 52: // '4'
			strFieldName = "newbnfbirthday";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("PolNo"))
			return 0;
		if (strFieldName.equals("InsuredNo"))
			return 0;
		if (strFieldName.equals("InsuredId"))
			return 0;
		if (strFieldName.equals("BenefitType"))
			return 0;
		if (strFieldName.equals("BnfOrder"))
			return 3;
		if (strFieldName.equals("BnfGrade"))
			return 0;
		if (strFieldName.equals("BenefitRate"))
			return 4;
		if (strFieldName.equals("BenefitOrder"))
			return 0;
		if (strFieldName.equals("BnfNo"))
			return 0;
		if (strFieldName.equals("BnfId"))
			return 0;
		if (strFieldName.equals("Appellation"))
			return 0;
		if (strFieldName.equals("BnfName"))
			return 0;
		if (strFieldName.equals("BnfSex"))
			return 0;
		if (strFieldName.equals("BnfBirthday"))
			return 0;
		if (strFieldName.equals("BnfAge"))
			return 3;
		if (strFieldName.equals("RelationToInsured"))
			return 0;
		if (strFieldName.equals("AddressNo"))
			return 0;
		if (strFieldName.equals("IDType"))
			return 0;
		if (strFieldName.equals("IDNo"))
			return 0;
		if (strFieldName.equals("IDValidity"))
			return 0;
		if (strFieldName.equals("IDPerpetual"))
			return 0;
		if (strFieldName.equals("NativePlace"))
			return 0;
		if (strFieldName.equals("Nationality"))
			return 0;
		if (strFieldName.equals("RgtAddress"))
			return 0;
		if (strFieldName.equals("Marriage"))
			return 0;
		if (strFieldName.equals("MarriageDate"))
			return 0;
		if (strFieldName.equals("Health"))
			return 0;
		if (strFieldName.equals("Stature"))
			return 4;
		if (strFieldName.equals("Avoirdupois"))
			return 4;
		if (strFieldName.equals("Degree"))
			return 0;
		if (strFieldName.equals("CreditGrade"))
			return 0;
		if (strFieldName.equals("BankCode"))
			return 0;
		if (strFieldName.equals("BankAccNo"))
			return 0;
		if (strFieldName.equals("AccName"))
			return 0;
		if (strFieldName.equals("JoinCompanyDate"))
			return 0;
		if (strFieldName.equals("StartWorkDate"))
			return 0;
		if (strFieldName.equals("Position"))
			return 0;
		if (strFieldName.equals("Salary"))
			return 4;
		if (strFieldName.equals("OccupationType"))
			return 0;
		if (strFieldName.equals("OccupationCode"))
			return 0;
		if (strFieldName.equals("WorkType"))
			return 0;
		if (strFieldName.equals("PluralityType"))
			return 0;
		if (strFieldName.equals("SmokeFlag"))
			return 0;
		if (strFieldName.equals("BnfFlag"))
			return 0;
		if (strFieldName.equals("Operator"))
			return 0;
		if (strFieldName.equals("ManageCom"))
			return 0;
		if (strFieldName.equals("MakeDate"))
			return 0;
		if (strFieldName.equals("MakeTime"))
			return 0;
		if (strFieldName.equals("ModifyDate"))
			return 0;
		if (strFieldName.equals("ModifyTime"))
			return 0;
		if (strFieldName.equals("newbnfname"))
			return 0;
		return !strFieldName.equals("newbnfbirthday") ? -1 : 0;
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
			nFieldType = 3;
			break;

		case 6: // '\006'
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 4;
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
			nFieldType = 3;
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
			nFieldType = 4;
			break;

		case 29: // '\035'
			nFieldType = 4;
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
			nFieldType = 4;
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
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
