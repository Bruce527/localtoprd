// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPBnfBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPBnfBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPBnfBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
	private String contNo;
	private String polNo;
	private String insuredNo;
	private String insuredId;
	private String benefitType;
	private int bnfOrder;
	private String bnfGrade;
	private double benefitRate;
	private String benefitOrder;
	private String bnfNo;
	private String bnfId;
	private String appellation;
	private String bnfName;
	private String bnfSex;
	private Date bnfBirthday;
	private int bnfAge;
	private String relationToInsured;
	private String addressNo;
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
	private String bnfFlag;
	private String operator;
	private String manageCom;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 53;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPBnfBSchema()
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

	public String getcontNo()
	{
		if (contNo != null)
			contNo.equals("");
		return contNo;
	}

	public void setcontNo(String acontNo)
	{
		contNo = acontNo;
	}

	public String getpolNo()
	{
		if (polNo != null)
			polNo.equals("");
		return polNo;
	}

	public void setpolNo(String apolNo)
	{
		polNo = apolNo;
	}

	public String getinsuredNo()
	{
		if (insuredNo != null)
			insuredNo.equals("");
		return insuredNo;
	}

	public void setinsuredNo(String ainsuredNo)
	{
		insuredNo = ainsuredNo;
	}

	public String getinsuredId()
	{
		if (insuredId != null)
			insuredId.equals("");
		return insuredId;
	}

	public void setinsuredId(String ainsuredId)
	{
		insuredId = ainsuredId;
	}

	public String getbenefitType()
	{
		if (benefitType != null)
			benefitType.equals("");
		return benefitType;
	}

	public void setbenefitType(String abenefitType)
	{
		benefitType = abenefitType;
	}

	public int getbnfOrder()
	{
		return bnfOrder;
	}

	public void setbnfOrder(int abnfOrder)
	{
		bnfOrder = abnfOrder;
	}

	public void setbnfOrder(String abnfOrder)
	{
		if (abnfOrder != null && !abnfOrder.equals(""))
		{
			Integer tInteger = new Integer(abnfOrder);
			int i = tInteger.intValue();
			bnfOrder = i;
		}
	}

	public String getbnfGrade()
	{
		if (bnfGrade != null)
			bnfGrade.equals("");
		return bnfGrade;
	}

	public void setbnfGrade(String abnfGrade)
	{
		bnfGrade = abnfGrade;
	}

	public double getbenefitRate()
	{
		return benefitRate;
	}

	public void setbenefitRate(double abenefitRate)
	{
		benefitRate = abenefitRate;
	}

	public void setbenefitRate(String abenefitRate)
	{
		if (abenefitRate != null && !abenefitRate.equals(""))
		{
			Double tDouble = new Double(abenefitRate);
			double d = tDouble.doubleValue();
			benefitRate = d;
		}
	}

	public String getbenefitOrder()
	{
		if (benefitOrder != null)
			benefitOrder.equals("");
		return benefitOrder;
	}

	public void setbenefitOrder(String abenefitOrder)
	{
		benefitOrder = abenefitOrder;
	}

	public String getbnfNo()
	{
		if (bnfNo != null)
			bnfNo.equals("");
		return bnfNo;
	}

	public void setbnfNo(String abnfNo)
	{
		bnfNo = abnfNo;
	}

	public String getbnfId()
	{
		if (bnfId != null)
			bnfId.equals("");
		return bnfId;
	}

	public void setbnfId(String abnfId)
	{
		bnfId = abnfId;
	}

	public String getappellation()
	{
		if (appellation != null)
			appellation.equals("");
		return appellation;
	}

	public void setappellation(String aappellation)
	{
		appellation = aappellation;
	}

	public String getbnfName()
	{
		if (bnfName != null)
			bnfName.equals("");
		return bnfName;
	}

	public void setbnfName(String abnfName)
	{
		bnfName = abnfName;
	}

	public String getbnfSex()
	{
		if (bnfSex != null)
			bnfSex.equals("");
		return bnfSex;
	}

	public void setbnfSex(String abnfSex)
	{
		bnfSex = abnfSex;
	}

	public String getbnfBirthday()
	{
		if (bnfBirthday != null)
			return fDate.getString(bnfBirthday);
		else
			return null;
	}

	public void setbnfBirthday(Date abnfBirthday)
	{
		bnfBirthday = abnfBirthday;
	}

	public void setbnfBirthday(String abnfBirthday)
	{
		if (abnfBirthday != null && !abnfBirthday.equals(""))
			bnfBirthday = fDate.getDate(abnfBirthday);
		else
			bnfBirthday = null;
	}

	public int getbnfAge()
	{
		return bnfAge;
	}

	public void setbnfAge(int abnfAge)
	{
		bnfAge = abnfAge;
	}

	public void setbnfAge(String abnfAge)
	{
		if (abnfAge != null && !abnfAge.equals(""))
		{
			Integer tInteger = new Integer(abnfAge);
			int i = tInteger.intValue();
			bnfAge = i;
		}
	}

	public String getrelationToInsured()
	{
		if (relationToInsured != null)
			relationToInsured.equals("");
		return relationToInsured;
	}

	public void setrelationToInsured(String arelationToInsured)
	{
		relationToInsured = arelationToInsured;
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

	public String getiDType()
	{
		if (iDType != null)
			iDType.equals("");
		return iDType;
	}

	public void setiDType(String aiDType)
	{
		iDType = aiDType;
	}

	public String getiDNo()
	{
		if (iDNo != null)
			iDNo.equals("");
		return iDNo;
	}

	public void setiDNo(String aiDNo)
	{
		iDNo = aiDNo;
	}

	public String getiDValidity()
	{
		if (iDValidity != null)
			return fDate.getString(iDValidity);
		else
			return null;
	}

	public void setiDValidity(Date aiDValidity)
	{
		iDValidity = aiDValidity;
	}

	public void setiDValidity(String aiDValidity)
	{
		if (aiDValidity != null && !aiDValidity.equals(""))
			iDValidity = fDate.getDate(aiDValidity);
		else
			iDValidity = null;
	}

	public String getiDPerpetual()
	{
		if (iDPerpetual != null)
			iDPerpetual.equals("");
		return iDPerpetual;
	}

	public void setiDPerpetual(String aiDPerpetual)
	{
		iDPerpetual = aiDPerpetual;
	}

	public String getnativePlace()
	{
		if (nativePlace != null)
			nativePlace.equals("");
		return nativePlace;
	}

	public void setnativePlace(String anativePlace)
	{
		nativePlace = anativePlace;
	}

	public String getnationality()
	{
		if (nationality != null)
			nationality.equals("");
		return nationality;
	}

	public void setnationality(String anationality)
	{
		nationality = anationality;
	}

	public String getrgtAddress()
	{
		if (rgtAddress != null)
			rgtAddress.equals("");
		return rgtAddress;
	}

	public void setrgtAddress(String argtAddress)
	{
		rgtAddress = argtAddress;
	}

	public String getmarriage()
	{
		if (marriage != null)
			marriage.equals("");
		return marriage;
	}

	public void setmarriage(String amarriage)
	{
		marriage = amarriage;
	}

	public String getmarriageDate()
	{
		if (marriageDate != null)
			return fDate.getString(marriageDate);
		else
			return null;
	}

	public void setmarriageDate(Date amarriageDate)
	{
		marriageDate = amarriageDate;
	}

	public void setmarriageDate(String amarriageDate)
	{
		if (amarriageDate != null && !amarriageDate.equals(""))
			marriageDate = fDate.getDate(amarriageDate);
		else
			marriageDate = null;
	}

	public String gethealth()
	{
		if (health != null)
			health.equals("");
		return health;
	}

	public void sethealth(String ahealth)
	{
		health = ahealth;
	}

	public double getstature()
	{
		return stature;
	}

	public void setstature(double astature)
	{
		stature = astature;
	}

	public void setstature(String astature)
	{
		if (astature != null && !astature.equals(""))
		{
			Double tDouble = new Double(astature);
			double d = tDouble.doubleValue();
			stature = d;
		}
	}

	public double getavoirdupois()
	{
		return avoirdupois;
	}

	public void setavoirdupois(double aavoirdupois)
	{
		avoirdupois = aavoirdupois;
	}

	public void setavoirdupois(String aavoirdupois)
	{
		if (aavoirdupois != null && !aavoirdupois.equals(""))
		{
			Double tDouble = new Double(aavoirdupois);
			double d = tDouble.doubleValue();
			avoirdupois = d;
		}
	}

	public String getdegree()
	{
		if (degree != null)
			degree.equals("");
		return degree;
	}

	public void setdegree(String adegree)
	{
		degree = adegree;
	}

	public String getcreditGrade()
	{
		if (creditGrade != null)
			creditGrade.equals("");
		return creditGrade;
	}

	public void setcreditGrade(String acreditGrade)
	{
		creditGrade = acreditGrade;
	}

	public String getbankCode()
	{
		if (bankCode != null)
			bankCode.equals("");
		return bankCode;
	}

	public void setbankCode(String abankCode)
	{
		bankCode = abankCode;
	}

	public String getbankAccNo()
	{
		if (bankAccNo != null)
			bankAccNo.equals("");
		return bankAccNo;
	}

	public void setbankAccNo(String abankAccNo)
	{
		bankAccNo = abankAccNo;
	}

	public String getaccName()
	{
		if (accName != null)
			accName.equals("");
		return accName;
	}

	public void setaccName(String aaccName)
	{
		accName = aaccName;
	}

	public String getjoinCompanyDate()
	{
		if (joinCompanyDate != null)
			return fDate.getString(joinCompanyDate);
		else
			return null;
	}

	public void setjoinCompanyDate(Date ajoinCompanyDate)
	{
		joinCompanyDate = ajoinCompanyDate;
	}

	public void setjoinCompanyDate(String ajoinCompanyDate)
	{
		if (ajoinCompanyDate != null && !ajoinCompanyDate.equals(""))
			joinCompanyDate = fDate.getDate(ajoinCompanyDate);
		else
			joinCompanyDate = null;
	}

	public String getstartWorkDate()
	{
		if (startWorkDate != null)
			return fDate.getString(startWorkDate);
		else
			return null;
	}

	public void setstartWorkDate(Date astartWorkDate)
	{
		startWorkDate = astartWorkDate;
	}

	public void setstartWorkDate(String astartWorkDate)
	{
		if (astartWorkDate != null && !astartWorkDate.equals(""))
			startWorkDate = fDate.getDate(astartWorkDate);
		else
			startWorkDate = null;
	}

	public String getposition()
	{
		if (position != null)
			position.equals("");
		return position;
	}

	public void setposition(String aposition)
	{
		position = aposition;
	}

	public double getsalary()
	{
		return salary;
	}

	public void setsalary(double asalary)
	{
		salary = asalary;
	}

	public void setsalary(String asalary)
	{
		if (asalary != null && !asalary.equals(""))
		{
			Double tDouble = new Double(asalary);
			double d = tDouble.doubleValue();
			salary = d;
		}
	}

	public String getoccupationType()
	{
		if (occupationType != null)
			occupationType.equals("");
		return occupationType;
	}

	public void setoccupationType(String aoccupationType)
	{
		occupationType = aoccupationType;
	}

	public String getoccupationCode()
	{
		if (occupationCode != null)
			occupationCode.equals("");
		return occupationCode;
	}

	public void setoccupationCode(String aoccupationCode)
	{
		occupationCode = aoccupationCode;
	}

	public String getworkType()
	{
		if (workType != null)
			workType.equals("");
		return workType;
	}

	public void setworkType(String aworkType)
	{
		workType = aworkType;
	}

	public String getpluralityType()
	{
		if (pluralityType != null)
			pluralityType.equals("");
		return pluralityType;
	}

	public void setpluralityType(String apluralityType)
	{
		pluralityType = apluralityType;
	}

	public String getsmokeFlag()
	{
		if (smokeFlag != null)
			smokeFlag.equals("");
		return smokeFlag;
	}

	public void setsmokeFlag(String asmokeFlag)
	{
		smokeFlag = asmokeFlag;
	}

	public String getbnfFlag()
	{
		if (bnfFlag != null)
			bnfFlag.equals("");
		return bnfFlag;
	}

	public void setbnfFlag(String abnfFlag)
	{
		bnfFlag = abnfFlag;
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

	public String getmanageCom()
	{
		if (manageCom != null)
			manageCom.equals("");
		return manageCom;
	}

	public void setmanageCom(String amanageCom)
	{
		manageCom = amanageCom;
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

	public void setSchema(LNPBnfBSchema aLNPBnfBSchema)
	{
		EdorNo = aLNPBnfBSchema.getEdorNo();
		serialNo = aLNPBnfBSchema.getserialNo();
		contNo = aLNPBnfBSchema.getcontNo();
		polNo = aLNPBnfBSchema.getpolNo();
		insuredNo = aLNPBnfBSchema.getinsuredNo();
		insuredId = aLNPBnfBSchema.getinsuredId();
		benefitType = aLNPBnfBSchema.getbenefitType();
		bnfOrder = aLNPBnfBSchema.getbnfOrder();
		bnfGrade = aLNPBnfBSchema.getbnfGrade();
		benefitRate = aLNPBnfBSchema.getbenefitRate();
		benefitOrder = aLNPBnfBSchema.getbenefitOrder();
		bnfNo = aLNPBnfBSchema.getbnfNo();
		bnfId = aLNPBnfBSchema.getbnfId();
		appellation = aLNPBnfBSchema.getappellation();
		bnfName = aLNPBnfBSchema.getbnfName();
		bnfSex = aLNPBnfBSchema.getbnfSex();
		bnfBirthday = fDate.getDate(aLNPBnfBSchema.getbnfBirthday());
		bnfAge = aLNPBnfBSchema.getbnfAge();
		relationToInsured = aLNPBnfBSchema.getrelationToInsured();
		addressNo = aLNPBnfBSchema.getaddressNo();
		iDType = aLNPBnfBSchema.getiDType();
		iDNo = aLNPBnfBSchema.getiDNo();
		iDValidity = fDate.getDate(aLNPBnfBSchema.getiDValidity());
		iDPerpetual = aLNPBnfBSchema.getiDPerpetual();
		nativePlace = aLNPBnfBSchema.getnativePlace();
		nationality = aLNPBnfBSchema.getnationality();
		rgtAddress = aLNPBnfBSchema.getrgtAddress();
		marriage = aLNPBnfBSchema.getmarriage();
		marriageDate = fDate.getDate(aLNPBnfBSchema.getmarriageDate());
		health = aLNPBnfBSchema.gethealth();
		stature = aLNPBnfBSchema.getstature();
		avoirdupois = aLNPBnfBSchema.getavoirdupois();
		degree = aLNPBnfBSchema.getdegree();
		creditGrade = aLNPBnfBSchema.getcreditGrade();
		bankCode = aLNPBnfBSchema.getbankCode();
		bankAccNo = aLNPBnfBSchema.getbankAccNo();
		accName = aLNPBnfBSchema.getaccName();
		joinCompanyDate = fDate.getDate(aLNPBnfBSchema.getjoinCompanyDate());
		startWorkDate = fDate.getDate(aLNPBnfBSchema.getstartWorkDate());
		position = aLNPBnfBSchema.getposition();
		salary = aLNPBnfBSchema.getsalary();
		occupationType = aLNPBnfBSchema.getoccupationType();
		occupationCode = aLNPBnfBSchema.getoccupationCode();
		workType = aLNPBnfBSchema.getworkType();
		pluralityType = aLNPBnfBSchema.getpluralityType();
		smokeFlag = aLNPBnfBSchema.getsmokeFlag();
		bnfFlag = aLNPBnfBSchema.getbnfFlag();
		operator = aLNPBnfBSchema.getoperator();
		manageCom = aLNPBnfBSchema.getmanageCom();
		makeDate = fDate.getDate(aLNPBnfBSchema.getmakeDate());
		makeTime = aLNPBnfBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPBnfBSchema.getmodifyDate());
		modifyTime = aLNPBnfBSchema.getmodifyTime();
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
			if (rs.getString("contNo") == null)
				contNo = null;
			else
				contNo = rs.getString("contNo").trim();
			if (rs.getString("polNo") == null)
				polNo = null;
			else
				polNo = rs.getString("polNo").trim();
			if (rs.getString("insuredNo") == null)
				insuredNo = null;
			else
				insuredNo = rs.getString("insuredNo").trim();
			if (rs.getString("insuredId") == null)
				insuredId = null;
			else
				insuredId = rs.getString("insuredId").trim();
			if (rs.getString("benefitType") == null)
				benefitType = null;
			else
				benefitType = rs.getString("benefitType").trim();
			bnfOrder = rs.getInt("bnfOrder");
			if (rs.getString("bnfGrade") == null)
				bnfGrade = null;
			else
				bnfGrade = rs.getString("bnfGrade").trim();
			benefitRate = rs.getDouble("benefitRate");
			if (rs.getString("benefitOrder") == null)
				benefitOrder = null;
			else
				benefitOrder = rs.getString("benefitOrder").trim();
			if (rs.getString("bnfNo") == null)
				bnfNo = null;
			else
				bnfNo = rs.getString("bnfNo").trim();
			if (rs.getString("bnfId") == null)
				bnfId = null;
			else
				bnfId = rs.getString("bnfId").trim();
			if (rs.getString("appellation") == null)
				appellation = null;
			else
				appellation = rs.getString("appellation").trim();
			if (rs.getString("bnfName") == null)
				bnfName = null;
			else
				bnfName = rs.getString("bnfName").trim();
			if (rs.getString("bnfSex") == null)
				bnfSex = null;
			else
				bnfSex = rs.getString("bnfSex").trim();
			bnfBirthday = rs.getDate("bnfBirthday");
			bnfAge = rs.getInt("bnfAge");
			if (rs.getString("relationToInsured") == null)
				relationToInsured = null;
			else
				relationToInsured = rs.getString("relationToInsured").trim();
			if (rs.getString("addressNo") == null)
				addressNo = null;
			else
				addressNo = rs.getString("addressNo").trim();
			if (rs.getString("iDType") == null)
				iDType = null;
			else
				iDType = rs.getString("iDType").trim();
			if (rs.getString("iDNo") == null)
				iDNo = null;
			else
				iDNo = rs.getString("iDNo").trim();
			iDValidity = rs.getDate("iDValidity");
			if (rs.getString("iDPerpetual") == null)
				iDPerpetual = null;
			else
				iDPerpetual = rs.getString("iDPerpetual").trim();
			if (rs.getString("nativePlace") == null)
				nativePlace = null;
			else
				nativePlace = rs.getString("nativePlace").trim();
			if (rs.getString("nationality") == null)
				nationality = null;
			else
				nationality = rs.getString("nationality").trim();
			if (rs.getString("rgtAddress") == null)
				rgtAddress = null;
			else
				rgtAddress = rs.getString("rgtAddress").trim();
			if (rs.getString("marriage") == null)
				marriage = null;
			else
				marriage = rs.getString("marriage").trim();
			marriageDate = rs.getDate("marriageDate");
			if (rs.getString("health") == null)
				health = null;
			else
				health = rs.getString("health").trim();
			stature = rs.getDouble("stature");
			avoirdupois = rs.getDouble("avoirdupois");
			if (rs.getString("degree") == null)
				degree = null;
			else
				degree = rs.getString("degree").trim();
			if (rs.getString("creditGrade") == null)
				creditGrade = null;
			else
				creditGrade = rs.getString("creditGrade").trim();
			if (rs.getString("bankCode") == null)
				bankCode = null;
			else
				bankCode = rs.getString("bankCode").trim();
			if (rs.getString("bankAccNo") == null)
				bankAccNo = null;
			else
				bankAccNo = rs.getString("bankAccNo").trim();
			if (rs.getString("accName") == null)
				accName = null;
			else
				accName = rs.getString("accName").trim();
			joinCompanyDate = rs.getDate("joinCompanyDate");
			startWorkDate = rs.getDate("startWorkDate");
			if (rs.getString("position") == null)
				position = null;
			else
				position = rs.getString("position").trim();
			salary = rs.getDouble("salary");
			if (rs.getString("occupationType") == null)
				occupationType = null;
			else
				occupationType = rs.getString("occupationType").trim();
			if (rs.getString("occupationCode") == null)
				occupationCode = null;
			else
				occupationCode = rs.getString("occupationCode").trim();
			if (rs.getString("workType") == null)
				workType = null;
			else
				workType = rs.getString("workType").trim();
			if (rs.getString("pluralityType") == null)
				pluralityType = null;
			else
				pluralityType = rs.getString("pluralityType").trim();
			if (rs.getString("smokeFlag") == null)
				smokeFlag = null;
			else
				smokeFlag = rs.getString("smokeFlag").trim();
			if (rs.getString("bnfFlag") == null)
				bnfFlag = null;
			else
				bnfFlag = rs.getString("bnfFlag").trim();
			if (rs.getString("operator") == null)
				operator = null;
			else
				operator = rs.getString("operator").trim();
			if (rs.getString("manageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("manageCom").trim();
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
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPBnfBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPBnfBSchema getSchema()
	{
		LNPBnfBSchema aLNPBnfBSchema = new LNPBnfBSchema();
		aLNPBnfBSchema.setSchema(this);
		return aLNPBnfBSchema;
	}

	public LNPBnfBDB getDB()
	{
		LNPBnfBDB aDBOper = new LNPBnfBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(polNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(benefitType))).append("|").append(ChgData.chgData(bnfOrder)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bnfGrade))).append("|").append(ChgData.chgData(benefitRate)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(benefitOrder))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bnfNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bnfId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appellation))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bnfName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bnfSex))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(bnfBirthday)))).append("|").append(ChgData.chgData(bnfAge)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(relationToInsured))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(addressNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iDType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iDNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(iDValidity)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iDPerpetual))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(nativePlace))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(nationality))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(rgtAddress))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(marriage))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(marriageDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(health))).append("|").append(ChgData.chgData(stature)).append("|").append(ChgData.chgData(avoirdupois)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(degree))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(creditGrade))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bankCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bankAccNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(accName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(joinCompanyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(startWorkDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(position))).append("|").append(ChgData.chgData(salary)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(occupationType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(occupationCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(workType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(pluralityType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(smokeFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bnfFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(manageCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			polNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			benefitType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			bnfOrder = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).intValue();
			bnfGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			benefitRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).doubleValue();
			benefitOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			bnfNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			bnfId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			bnfName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			bnfSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			bnfBirthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			bnfAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|")))).intValue();
			relationToInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			iDValidity = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
			iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			marriageDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
			health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			stature = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|")))).doubleValue();
			avoirdupois = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|")))).doubleValue();
			degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
			accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			joinCompanyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|"));
			startWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|"));
			position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			salary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 41, "|")))).doubleValue();
			occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPBnfBSchema";
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
		if (FCode.equals("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equals("polNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polNo));
		if (FCode.equals("insuredNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredNo));
		if (FCode.equals("insuredId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredId));
		if (FCode.equals("benefitType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(benefitType));
		if (FCode.equals("bnfOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfOrder));
		if (FCode.equals("bnfGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfGrade));
		if (FCode.equals("benefitRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(benefitRate));
		if (FCode.equals("benefitOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(benefitOrder));
		if (FCode.equals("bnfNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfNo));
		if (FCode.equals("bnfId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfId));
		if (FCode.equals("appellation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appellation));
		if (FCode.equals("bnfName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfName));
		if (FCode.equals("bnfSex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfSex));
		if (FCode.equals("bnfBirthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getbnfBirthday()));
		if (FCode.equals("bnfAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfAge));
		if (FCode.equals("relationToInsured"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relationToInsured));
		if (FCode.equals("addressNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addressNo));
		if (FCode.equals("iDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDType));
		if (FCode.equals("iDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDNo));
		if (FCode.equals("iDValidity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
		if (FCode.equals("iDPerpetual"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDPerpetual));
		if (FCode.equals("nativePlace"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nativePlace));
		if (FCode.equals("nationality"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nationality));
		if (FCode.equals("rgtAddress"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rgtAddress));
		if (FCode.equals("marriage"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(marriage));
		if (FCode.equals("marriageDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
		if (FCode.equals("health"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(health));
		if (FCode.equals("stature"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(stature));
		if (FCode.equals("avoirdupois"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(avoirdupois));
		if (FCode.equals("degree"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(degree));
		if (FCode.equals("creditGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(creditGrade));
		if (FCode.equals("bankCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankCode));
		if (FCode.equals("bankAccNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bankAccNo));
		if (FCode.equals("accName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(accName));
		if (FCode.equals("joinCompanyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
		if (FCode.equals("startWorkDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
		if (FCode.equals("position"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(position));
		if (FCode.equals("salary"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(salary));
		if (FCode.equals("occupationType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationType));
		if (FCode.equals("occupationCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(occupationCode));
		if (FCode.equals("workType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(workType));
		if (FCode.equals("pluralityType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pluralityType));
		if (FCode.equals("smokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(smokeFlag));
		if (FCode.equals("bnfFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfFlag));
		if (FCode.equals("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equals("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equals("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
		if (FCode.equals("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equals("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
		if (FCode.equals("modifyTime"))
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
			strFieldValue = StrTool.GBKToUnicode(EdorNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(serialNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(polNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(insuredNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(insuredId);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(benefitType);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(bnfOrder);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(bnfGrade);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(benefitRate);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(benefitOrder);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(bnfNo);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(bnfId);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(appellation);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(bnfName);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(bnfSex);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getbnfBirthday()));
			break;

		case 17: // '\021'
			strFieldValue = String.valueOf(bnfAge);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(relationToInsured);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(addressNo);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(iDType);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(iDNo);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(iDPerpetual);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(nativePlace);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(nationality);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(rgtAddress);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(marriage);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(health);
			break;

		case 30: // '\036'
			strFieldValue = String.valueOf(stature);
			break;

		case 31: // '\037'
			strFieldValue = String.valueOf(avoirdupois);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(degree);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(creditGrade);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(bankCode);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(bankAccNo);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(accName);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(position);
			break;

		case 40: // '('
			strFieldValue = String.valueOf(salary);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(occupationType);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(occupationCode);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(workType);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(pluralityType);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(smokeFlag);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(bnfFlag);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
			break;

		case 52: // '4'
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
		if (FCode.equals("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equals("polNo"))
			if (FValue != null && !FValue.equals(""))
				polNo = FValue.trim();
			else
				polNo = null;
		if (FCode.equals("insuredNo"))
			if (FValue != null && !FValue.equals(""))
				insuredNo = FValue.trim();
			else
				insuredNo = null;
		if (FCode.equals("insuredId"))
			if (FValue != null && !FValue.equals(""))
				insuredId = FValue.trim();
			else
				insuredId = null;
		if (FCode.equals("benefitType"))
			if (FValue != null && !FValue.equals(""))
				benefitType = FValue.trim();
			else
				benefitType = null;
		if (FCode.equals("bnfOrder") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			bnfOrder = i;
		}
		if (FCode.equals("bnfGrade"))
			if (FValue != null && !FValue.equals(""))
				bnfGrade = FValue.trim();
			else
				bnfGrade = null;
		if (FCode.equals("benefitRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			benefitRate = d;
		}
		if (FCode.equals("benefitOrder"))
			if (FValue != null && !FValue.equals(""))
				benefitOrder = FValue.trim();
			else
				benefitOrder = null;
		if (FCode.equals("bnfNo"))
			if (FValue != null && !FValue.equals(""))
				bnfNo = FValue.trim();
			else
				bnfNo = null;
		if (FCode.equals("bnfId"))
			if (FValue != null && !FValue.equals(""))
				bnfId = FValue.trim();
			else
				bnfId = null;
		if (FCode.equals("appellation"))
			if (FValue != null && !FValue.equals(""))
				appellation = FValue.trim();
			else
				appellation = null;
		if (FCode.equals("bnfName"))
			if (FValue != null && !FValue.equals(""))
				bnfName = FValue.trim();
			else
				bnfName = null;
		if (FCode.equals("bnfSex"))
			if (FValue != null && !FValue.equals(""))
				bnfSex = FValue.trim();
			else
				bnfSex = null;
		if (FCode.equals("bnfBirthday"))
			if (FValue != null && !FValue.equals(""))
				bnfBirthday = fDate.getDate(FValue);
			else
				bnfBirthday = null;
		if (FCode.equals("bnfAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			bnfAge = i;
		}
		if (FCode.equals("relationToInsured"))
			if (FValue != null && !FValue.equals(""))
				relationToInsured = FValue.trim();
			else
				relationToInsured = null;
		if (FCode.equals("addressNo"))
			if (FValue != null && !FValue.equals(""))
				addressNo = FValue.trim();
			else
				addressNo = null;
		if (FCode.equals("iDType"))
			if (FValue != null && !FValue.equals(""))
				iDType = FValue.trim();
			else
				iDType = null;
		if (FCode.equals("iDNo"))
			if (FValue != null && !FValue.equals(""))
				iDNo = FValue.trim();
			else
				iDNo = null;
		if (FCode.equals("iDValidity"))
			if (FValue != null && !FValue.equals(""))
				iDValidity = fDate.getDate(FValue);
			else
				iDValidity = null;
		if (FCode.equals("iDPerpetual"))
			if (FValue != null && !FValue.equals(""))
				iDPerpetual = FValue.trim();
			else
				iDPerpetual = null;
		if (FCode.equals("nativePlace"))
			if (FValue != null && !FValue.equals(""))
				nativePlace = FValue.trim();
			else
				nativePlace = null;
		if (FCode.equals("nationality"))
			if (FValue != null && !FValue.equals(""))
				nationality = FValue.trim();
			else
				nationality = null;
		if (FCode.equals("rgtAddress"))
			if (FValue != null && !FValue.equals(""))
				rgtAddress = FValue.trim();
			else
				rgtAddress = null;
		if (FCode.equals("marriage"))
			if (FValue != null && !FValue.equals(""))
				marriage = FValue.trim();
			else
				marriage = null;
		if (FCode.equals("marriageDate"))
			if (FValue != null && !FValue.equals(""))
				marriageDate = fDate.getDate(FValue);
			else
				marriageDate = null;
		if (FCode.equals("health"))
			if (FValue != null && !FValue.equals(""))
				health = FValue.trim();
			else
				health = null;
		if (FCode.equals("stature") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			stature = d;
		}
		if (FCode.equals("avoirdupois") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			avoirdupois = d;
		}
		if (FCode.equals("degree"))
			if (FValue != null && !FValue.equals(""))
				degree = FValue.trim();
			else
				degree = null;
		if (FCode.equals("creditGrade"))
			if (FValue != null && !FValue.equals(""))
				creditGrade = FValue.trim();
			else
				creditGrade = null;
		if (FCode.equals("bankCode"))
			if (FValue != null && !FValue.equals(""))
				bankCode = FValue.trim();
			else
				bankCode = null;
		if (FCode.equals("bankAccNo"))
			if (FValue != null && !FValue.equals(""))
				bankAccNo = FValue.trim();
			else
				bankAccNo = null;
		if (FCode.equals("accName"))
			if (FValue != null && !FValue.equals(""))
				accName = FValue.trim();
			else
				accName = null;
		if (FCode.equals("joinCompanyDate"))
			if (FValue != null && !FValue.equals(""))
				joinCompanyDate = fDate.getDate(FValue);
			else
				joinCompanyDate = null;
		if (FCode.equals("startWorkDate"))
			if (FValue != null && !FValue.equals(""))
				startWorkDate = fDate.getDate(FValue);
			else
				startWorkDate = null;
		if (FCode.equals("position"))
			if (FValue != null && !FValue.equals(""))
				position = FValue.trim();
			else
				position = null;
		if (FCode.equals("salary") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			salary = d;
		}
		if (FCode.equals("occupationType"))
			if (FValue != null && !FValue.equals(""))
				occupationType = FValue.trim();
			else
				occupationType = null;
		if (FCode.equals("occupationCode"))
			if (FValue != null && !FValue.equals(""))
				occupationCode = FValue.trim();
			else
				occupationCode = null;
		if (FCode.equals("workType"))
			if (FValue != null && !FValue.equals(""))
				workType = FValue.trim();
			else
				workType = null;
		if (FCode.equals("pluralityType"))
			if (FValue != null && !FValue.equals(""))
				pluralityType = FValue.trim();
			else
				pluralityType = null;
		if (FCode.equals("smokeFlag"))
			if (FValue != null && !FValue.equals(""))
				smokeFlag = FValue.trim();
			else
				smokeFlag = null;
		if (FCode.equals("bnfFlag"))
			if (FValue != null && !FValue.equals(""))
				bnfFlag = FValue.trim();
			else
				bnfFlag = null;
		if (FCode.equals("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equals("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
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
		LNPBnfBSchema other = (LNPBnfBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && contNo.equals(other.getcontNo()) && polNo.equals(other.getpolNo()) && insuredNo.equals(other.getinsuredNo()) && insuredId.equals(other.getinsuredId()) && benefitType.equals(other.getbenefitType()) && bnfOrder == other.getbnfOrder() && bnfGrade.equals(other.getbnfGrade()) && benefitRate == other.getbenefitRate() && benefitOrder.equals(other.getbenefitOrder()) && bnfNo.equals(other.getbnfNo()) && bnfId.equals(other.getbnfId()) && appellation.equals(other.getappellation()) && bnfName.equals(other.getbnfName()) && bnfSex.equals(other.getbnfSex()) && fDate.getString(bnfBirthday).equals(other.getbnfBirthday()) && bnfAge == other.getbnfAge() && relationToInsured.equals(other.getrelationToInsured()) && addressNo.equals(other.getaddressNo()) && iDType.equals(other.getiDType()) && iDNo.equals(other.getiDNo()) && fDate.getString(iDValidity).equals(other.getiDValidity()) && iDPerpetual.equals(other.getiDPerpetual()) && nativePlace.equals(other.getnativePlace()) && nationality.equals(other.getnationality()) && rgtAddress.equals(other.getrgtAddress()) && marriage.equals(other.getmarriage()) && fDate.getString(marriageDate).equals(other.getmarriageDate()) && health.equals(other.gethealth()) && stature == other.getstature() && avoirdupois == other.getavoirdupois() && degree.equals(other.getdegree()) && creditGrade.equals(other.getcreditGrade()) && bankCode.equals(other.getbankCode()) && bankAccNo.equals(other.getbankAccNo()) && accName.equals(other.getaccName()) && fDate.getString(joinCompanyDate).equals(other.getjoinCompanyDate()) && fDate.getString(startWorkDate).equals(other.getstartWorkDate()) && position.equals(other.getposition()) && salary == other.getsalary() && occupationType.equals(other.getoccupationType()) && occupationCode.equals(other.getoccupationCode()) && workType.equals(other.getworkType()) && pluralityType.equals(other.getpluralityType()) && smokeFlag.equals(other.getsmokeFlag()) && bnfFlag.equals(other.getbnfFlag()) && operator.equals(other.getoperator()) && manageCom.equals(other.getmanageCom()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime());
	}

	public int getFieldCount()
	{
		return 53;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("contNo"))
			return 2;
		if (strFieldName.equals("polNo"))
			return 3;
		if (strFieldName.equals("insuredNo"))
			return 4;
		if (strFieldName.equals("insuredId"))
			return 5;
		if (strFieldName.equals("benefitType"))
			return 6;
		if (strFieldName.equals("bnfOrder"))
			return 7;
		if (strFieldName.equals("bnfGrade"))
			return 8;
		if (strFieldName.equals("benefitRate"))
			return 9;
		if (strFieldName.equals("benefitOrder"))
			return 10;
		if (strFieldName.equals("bnfNo"))
			return 11;
		if (strFieldName.equals("bnfId"))
			return 12;
		if (strFieldName.equals("appellation"))
			return 13;
		if (strFieldName.equals("bnfName"))
			return 14;
		if (strFieldName.equals("bnfSex"))
			return 15;
		if (strFieldName.equals("bnfBirthday"))
			return 16;
		if (strFieldName.equals("bnfAge"))
			return 17;
		if (strFieldName.equals("relationToInsured"))
			return 18;
		if (strFieldName.equals("addressNo"))
			return 19;
		if (strFieldName.equals("iDType"))
			return 20;
		if (strFieldName.equals("iDNo"))
			return 21;
		if (strFieldName.equals("iDValidity"))
			return 22;
		if (strFieldName.equals("iDPerpetual"))
			return 23;
		if (strFieldName.equals("nativePlace"))
			return 24;
		if (strFieldName.equals("nationality"))
			return 25;
		if (strFieldName.equals("rgtAddress"))
			return 26;
		if (strFieldName.equals("marriage"))
			return 27;
		if (strFieldName.equals("marriageDate"))
			return 28;
		if (strFieldName.equals("health"))
			return 29;
		if (strFieldName.equals("stature"))
			return 30;
		if (strFieldName.equals("avoirdupois"))
			return 31;
		if (strFieldName.equals("degree"))
			return 32;
		if (strFieldName.equals("creditGrade"))
			return 33;
		if (strFieldName.equals("bankCode"))
			return 34;
		if (strFieldName.equals("bankAccNo"))
			return 35;
		if (strFieldName.equals("accName"))
			return 36;
		if (strFieldName.equals("joinCompanyDate"))
			return 37;
		if (strFieldName.equals("startWorkDate"))
			return 38;
		if (strFieldName.equals("position"))
			return 39;
		if (strFieldName.equals("salary"))
			return 40;
		if (strFieldName.equals("occupationType"))
			return 41;
		if (strFieldName.equals("occupationCode"))
			return 42;
		if (strFieldName.equals("workType"))
			return 43;
		if (strFieldName.equals("pluralityType"))
			return 44;
		if (strFieldName.equals("smokeFlag"))
			return 45;
		if (strFieldName.equals("bnfFlag"))
			return 46;
		if (strFieldName.equals("operator"))
			return 47;
		if (strFieldName.equals("manageCom"))
			return 48;
		if (strFieldName.equals("makeDate"))
			return 49;
		if (strFieldName.equals("makeTime"))
			return 50;
		if (strFieldName.equals("modifyDate"))
			return 51;
		return !strFieldName.equals("modifyTime") ? -1 : 52;
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
			strFieldName = "contNo";
			break;

		case 3: // '\003'
			strFieldName = "polNo";
			break;

		case 4: // '\004'
			strFieldName = "insuredNo";
			break;

		case 5: // '\005'
			strFieldName = "insuredId";
			break;

		case 6: // '\006'
			strFieldName = "benefitType";
			break;

		case 7: // '\007'
			strFieldName = "bnfOrder";
			break;

		case 8: // '\b'
			strFieldName = "bnfGrade";
			break;

		case 9: // '\t'
			strFieldName = "benefitRate";
			break;

		case 10: // '\n'
			strFieldName = "benefitOrder";
			break;

		case 11: // '\013'
			strFieldName = "bnfNo";
			break;

		case 12: // '\f'
			strFieldName = "bnfId";
			break;

		case 13: // '\r'
			strFieldName = "appellation";
			break;

		case 14: // '\016'
			strFieldName = "bnfName";
			break;

		case 15: // '\017'
			strFieldName = "bnfSex";
			break;

		case 16: // '\020'
			strFieldName = "bnfBirthday";
			break;

		case 17: // '\021'
			strFieldName = "bnfAge";
			break;

		case 18: // '\022'
			strFieldName = "relationToInsured";
			break;

		case 19: // '\023'
			strFieldName = "addressNo";
			break;

		case 20: // '\024'
			strFieldName = "iDType";
			break;

		case 21: // '\025'
			strFieldName = "iDNo";
			break;

		case 22: // '\026'
			strFieldName = "iDValidity";
			break;

		case 23: // '\027'
			strFieldName = "iDPerpetual";
			break;

		case 24: // '\030'
			strFieldName = "nativePlace";
			break;

		case 25: // '\031'
			strFieldName = "nationality";
			break;

		case 26: // '\032'
			strFieldName = "rgtAddress";
			break;

		case 27: // '\033'
			strFieldName = "marriage";
			break;

		case 28: // '\034'
			strFieldName = "marriageDate";
			break;

		case 29: // '\035'
			strFieldName = "health";
			break;

		case 30: // '\036'
			strFieldName = "stature";
			break;

		case 31: // '\037'
			strFieldName = "avoirdupois";
			break;

		case 32: // ' '
			strFieldName = "degree";
			break;

		case 33: // '!'
			strFieldName = "creditGrade";
			break;

		case 34: // '"'
			strFieldName = "bankCode";
			break;

		case 35: // '#'
			strFieldName = "bankAccNo";
			break;

		case 36: // '$'
			strFieldName = "accName";
			break;

		case 37: // '%'
			strFieldName = "joinCompanyDate";
			break;

		case 38: // '&'
			strFieldName = "startWorkDate";
			break;

		case 39: // '\''
			strFieldName = "position";
			break;

		case 40: // '('
			strFieldName = "salary";
			break;

		case 41: // ')'
			strFieldName = "occupationType";
			break;

		case 42: // '*'
			strFieldName = "occupationCode";
			break;

		case 43: // '+'
			strFieldName = "workType";
			break;

		case 44: // ','
			strFieldName = "pluralityType";
			break;

		case 45: // '-'
			strFieldName = "smokeFlag";
			break;

		case 46: // '.'
			strFieldName = "bnfFlag";
			break;

		case 47: // '/'
			strFieldName = "operator";
			break;

		case 48: // '0'
			strFieldName = "manageCom";
			break;

		case 49: // '1'
			strFieldName = "makeDate";
			break;

		case 50: // '2'
			strFieldName = "makeTime";
			break;

		case 51: // '3'
			strFieldName = "modifyDate";
			break;

		case 52: // '4'
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
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("polNo"))
			return 0;
		if (strFieldName.equals("insuredNo"))
			return 0;
		if (strFieldName.equals("insuredId"))
			return 0;
		if (strFieldName.equals("benefitType"))
			return 0;
		if (strFieldName.equals("bnfOrder"))
			return 3;
		if (strFieldName.equals("bnfGrade"))
			return 0;
		if (strFieldName.equals("benefitRate"))
			return 4;
		if (strFieldName.equals("benefitOrder"))
			return 0;
		if (strFieldName.equals("bnfNo"))
			return 0;
		if (strFieldName.equals("bnfId"))
			return 0;
		if (strFieldName.equals("appellation"))
			return 0;
		if (strFieldName.equals("bnfName"))
			return 0;
		if (strFieldName.equals("bnfSex"))
			return 0;
		if (strFieldName.equals("bnfBirthday"))
			return 1;
		if (strFieldName.equals("bnfAge"))
			return 3;
		if (strFieldName.equals("relationToInsured"))
			return 0;
		if (strFieldName.equals("addressNo"))
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
		if (strFieldName.equals("bnfFlag"))
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
			nFieldType = 3;
			break;

		case 8: // '\b'
			nFieldType = 0;
			break;

		case 9: // '\t'
			nFieldType = 4;
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
			nFieldType = 1;
			break;

		case 17: // '\021'
			nFieldType = 3;
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
			nFieldType = 1;
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
			nFieldType = 4;
			break;

		case 31: // '\037'
			nFieldType = 4;
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
			nFieldType = 1;
			break;

		case 38: // '&'
			nFieldType = 1;
			break;

		case 39: // '\''
			nFieldType = 0;
			break;

		case 40: // '('
			nFieldType = 4;
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
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
