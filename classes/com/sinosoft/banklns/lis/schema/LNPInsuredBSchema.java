// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsuredBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPInsuredBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPInsuredBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
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
	private String appAgetype;
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
	public static final int FIELDNUM = 59;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPInsuredBSchema()
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

	public String getgrpContNo()
	{
		if (grpContNo != null)
			grpContNo.equals("");
		return grpContNo;
	}

	public void setgrpContNo(String agrpContNo)
	{
		grpContNo = agrpContNo;
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

	public String getproposalContNo()
	{
		if (proposalContNo != null)
			proposalContNo.equals("");
		return proposalContNo;
	}

	public void setproposalContNo(String aproposalContNo)
	{
		proposalContNo = aproposalContNo;
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

	public String getprtNo()
	{
		if (prtNo != null)
			prtNo.equals("");
		return prtNo;
	}

	public void setprtNo(String aprtNo)
	{
		prtNo = aprtNo;
	}

	public String getappntNo()
	{
		if (appntNo != null)
			appntNo.equals("");
		return appntNo;
	}

	public void setappntNo(String aappntNo)
	{
		appntNo = aappntNo;
	}

	public String getappntId()
	{
		if (appntId != null)
			appntId.equals("");
		return appntId;
	}

	public void setappntId(String aappntId)
	{
		appntId = aappntId;
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

	public String getsignCity()
	{
		if (signCity != null)
			signCity.equals("");
		return signCity;
	}

	public void setsignCity(String asignCity)
	{
		signCity = asignCity;
	}

	public String getexecuteCom()
	{
		if (executeCom != null)
			executeCom.equals("");
		return executeCom;
	}

	public void setexecuteCom(String aexecuteCom)
	{
		executeCom = aexecuteCom;
	}

	public String getfamilyID()
	{
		if (familyID != null)
			familyID.equals("");
		return familyID;
	}

	public void setfamilyID(String afamilyID)
	{
		familyID = afamilyID;
	}

	public String getrelationToMainInsured()
	{
		if (relationToMainInsured != null)
			relationToMainInsured.equals("");
		return relationToMainInsured;
	}

	public void setrelationToMainInsured(String arelationToMainInsured)
	{
		relationToMainInsured = arelationToMainInsured;
	}

	public String getrelationToAppnt()
	{
		if (relationToAppnt != null)
			relationToAppnt.equals("");
		return relationToAppnt;
	}

	public void setrelationToAppnt(String arelationToAppnt)
	{
		relationToAppnt = arelationToAppnt;
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

	public String getsequenceNo()
	{
		if (sequenceNo != null)
			sequenceNo.equals("");
		return sequenceNo;
	}

	public void setsequenceNo(String asequenceNo)
	{
		sequenceNo = asequenceNo;
	}

	public String getname()
	{
		if (name != null)
			name.equals("");
		return name;
	}

	public void setname(String aname)
	{
		name = aname;
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

	public String getsex()
	{
		if (sex != null)
			sex.equals("");
		return sex;
	}

	public void setsex(String asex)
	{
		sex = asex;
	}

	public String getbirthday()
	{
		if (birthday != null)
			return fDate.getString(birthday);
		else
			return null;
	}

	public void setbirthday(Date abirthday)
	{
		birthday = abirthday;
	}

	public void setbirthday(String abirthday)
	{
		if (abirthday != null && !abirthday.equals(""))
			birthday = fDate.getDate(abirthday);
		else
			birthday = null;
	}

	public int getappAge()
	{
		return appAge;
	}

	public void setappAge(int aappAge)
	{
		appAge = aappAge;
	}

	public void setappAge(String aappAge)
	{
		if (aappAge != null && !aappAge.equals(""))
		{
			Integer tInteger = new Integer(aappAge);
			int i = tInteger.intValue();
			appAge = i;
		}
	}

	public String getappAgetype()
	{
		if (appAgetype != null)
			appAgetype.equals("");
		return appAgetype;
	}

	public void setappAgetype(String aappAgetype)
	{
		appAgetype = aappAgetype;
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

	public String getpartOccupationType()
	{
		if (partOccupationType != null)
			partOccupationType.equals("");
		return partOccupationType;
	}

	public void setpartOccupationType(String apartOccupationType)
	{
		partOccupationType = apartOccupationType;
	}

	public String getpartOccupationCode()
	{
		if (partOccupationCode != null)
			partOccupationCode.equals("");
		return partOccupationCode;
	}

	public void setpartOccupationCode(String apartOccupationCode)
	{
		partOccupationCode = apartOccupationCode;
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

	public String getcontPlanCode()
	{
		if (contPlanCode != null)
			contPlanCode.equals("");
		return contPlanCode;
	}

	public void setcontPlanCode(String acontPlanCode)
	{
		contPlanCode = acontPlanCode;
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

	public int getinsuredPeoples()
	{
		return insuredPeoples;
	}

	public void setinsuredPeoples(int ainsuredPeoples)
	{
		insuredPeoples = ainsuredPeoples;
	}

	public void setinsuredPeoples(String ainsuredPeoples)
	{
		if (ainsuredPeoples != null && !ainsuredPeoples.equals(""))
		{
			Integer tInteger = new Integer(ainsuredPeoples);
			int i = tInteger.intValue();
			insuredPeoples = i;
		}
	}

	public void setSchema(LNPInsuredBSchema aLNPInsuredBSchema)
	{
		EdorNo = aLNPInsuredBSchema.getEdorNo();
		serialNo = aLNPInsuredBSchema.getserialNo();
		grpContNo = aLNPInsuredBSchema.getgrpContNo();
		contNo = aLNPInsuredBSchema.getcontNo();
		proposalContNo = aLNPInsuredBSchema.getproposalContNo();
		insuredNo = aLNPInsuredBSchema.getinsuredNo();
		insuredId = aLNPInsuredBSchema.getinsuredId();
		prtNo = aLNPInsuredBSchema.getprtNo();
		appntNo = aLNPInsuredBSchema.getappntNo();
		appntId = aLNPInsuredBSchema.getappntId();
		manageCom = aLNPInsuredBSchema.getmanageCom();
		signCity = aLNPInsuredBSchema.getsignCity();
		executeCom = aLNPInsuredBSchema.getexecuteCom();
		familyID = aLNPInsuredBSchema.getfamilyID();
		relationToMainInsured = aLNPInsuredBSchema.getrelationToMainInsured();
		relationToAppnt = aLNPInsuredBSchema.getrelationToAppnt();
		addressNo = aLNPInsuredBSchema.getaddressNo();
		sequenceNo = aLNPInsuredBSchema.getsequenceNo();
		name = aLNPInsuredBSchema.getname();
		appellation = aLNPInsuredBSchema.getappellation();
		sex = aLNPInsuredBSchema.getsex();
		birthday = fDate.getDate(aLNPInsuredBSchema.getbirthday());
		appAge = aLNPInsuredBSchema.getappAge();
		appAgetype = aLNPInsuredBSchema.getappAgetype();
		iDType = aLNPInsuredBSchema.getiDType();
		iDNo = aLNPInsuredBSchema.getiDNo();
		iDValidity = fDate.getDate(aLNPInsuredBSchema.getiDValidity());
		iDPerpetual = aLNPInsuredBSchema.getiDPerpetual();
		nativePlace = aLNPInsuredBSchema.getnativePlace();
		nationality = aLNPInsuredBSchema.getnationality();
		rgtAddress = aLNPInsuredBSchema.getrgtAddress();
		marriage = aLNPInsuredBSchema.getmarriage();
		marriageDate = fDate.getDate(aLNPInsuredBSchema.getmarriageDate());
		health = aLNPInsuredBSchema.gethealth();
		stature = aLNPInsuredBSchema.getstature();
		avoirdupois = aLNPInsuredBSchema.getavoirdupois();
		degree = aLNPInsuredBSchema.getdegree();
		creditGrade = aLNPInsuredBSchema.getcreditGrade();
		bankCode = aLNPInsuredBSchema.getbankCode();
		bankAccNo = aLNPInsuredBSchema.getbankAccNo();
		accName = aLNPInsuredBSchema.getaccName();
		joinCompanyDate = fDate.getDate(aLNPInsuredBSchema.getjoinCompanyDate());
		startWorkDate = fDate.getDate(aLNPInsuredBSchema.getstartWorkDate());
		position = aLNPInsuredBSchema.getposition();
		salary = aLNPInsuredBSchema.getsalary();
		occupationType = aLNPInsuredBSchema.getoccupationType();
		occupationCode = aLNPInsuredBSchema.getoccupationCode();
		partOccupationType = aLNPInsuredBSchema.getpartOccupationType();
		partOccupationCode = aLNPInsuredBSchema.getpartOccupationCode();
		workType = aLNPInsuredBSchema.getworkType();
		pluralityType = aLNPInsuredBSchema.getpluralityType();
		smokeFlag = aLNPInsuredBSchema.getsmokeFlag();
		contPlanCode = aLNPInsuredBSchema.getcontPlanCode();
		operator = aLNPInsuredBSchema.getoperator();
		makeDate = fDate.getDate(aLNPInsuredBSchema.getmakeDate());
		makeTime = aLNPInsuredBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPInsuredBSchema.getmodifyDate());
		modifyTime = aLNPInsuredBSchema.getmodifyTime();
		insuredPeoples = aLNPInsuredBSchema.getinsuredPeoples();
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
			if (rs.getString("grpContNo") == null)
				grpContNo = null;
			else
				grpContNo = rs.getString("grpContNo").trim();
			if (rs.getString("contNo") == null)
				contNo = null;
			else
				contNo = rs.getString("contNo").trim();
			if (rs.getString("proposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("proposalContNo").trim();
			if (rs.getString("insuredNo") == null)
				insuredNo = null;
			else
				insuredNo = rs.getString("insuredNo").trim();
			if (rs.getString("insuredId") == null)
				insuredId = null;
			else
				insuredId = rs.getString("insuredId").trim();
			if (rs.getString("prtNo") == null)
				prtNo = null;
			else
				prtNo = rs.getString("prtNo").trim();
			if (rs.getString("appntNo") == null)
				appntNo = null;
			else
				appntNo = rs.getString("appntNo").trim();
			if (rs.getString("appntId") == null)
				appntId = null;
			else
				appntId = rs.getString("appntId").trim();
			if (rs.getString("manageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("manageCom").trim();
			if (rs.getString("signCity") == null)
				signCity = null;
			else
				signCity = rs.getString("signCity").trim();
			if (rs.getString("executeCom") == null)
				executeCom = null;
			else
				executeCom = rs.getString("executeCom").trim();
			if (rs.getString("familyID") == null)
				familyID = null;
			else
				familyID = rs.getString("familyID").trim();
			if (rs.getString("relationToMainInsured") == null)
				relationToMainInsured = null;
			else
				relationToMainInsured = rs.getString("relationToMainInsured").trim();
			if (rs.getString("relationToAppnt") == null)
				relationToAppnt = null;
			else
				relationToAppnt = rs.getString("relationToAppnt").trim();
			if (rs.getString("addressNo") == null)
				addressNo = null;
			else
				addressNo = rs.getString("addressNo").trim();
			if (rs.getString("sequenceNo") == null)
				sequenceNo = null;
			else
				sequenceNo = rs.getString("sequenceNo").trim();
			if (rs.getString("name") == null)
				name = null;
			else
				name = rs.getString("name").trim();
			if (rs.getString("appellation") == null)
				appellation = null;
			else
				appellation = rs.getString("appellation").trim();
			if (rs.getString("sex") == null)
				sex = null;
			else
				sex = rs.getString("sex").trim();
			birthday = rs.getDate("birthday");
			appAge = rs.getInt("appAge");
			if (rs.getString("appAgetype") == null)
				appAgetype = null;
			else
				appAgetype = rs.getString("appAgetype").trim();
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
			if (rs.getString("partOccupationType") == null)
				partOccupationType = null;
			else
				partOccupationType = rs.getString("partOccupationType").trim();
			if (rs.getString("partOccupationCode") == null)
				partOccupationCode = null;
			else
				partOccupationCode = rs.getString("partOccupationCode").trim();
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
			if (rs.getString("contPlanCode") == null)
				contPlanCode = null;
			else
				contPlanCode = rs.getString("contPlanCode").trim();
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
			insuredPeoples = rs.getInt("insuredPeoples");
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPInsuredBSchema getSchema()
	{
		LNPInsuredBSchema aLNPInsuredBSchema = new LNPInsuredBSchema();
		aLNPInsuredBSchema.setSchema(this);
		return aLNPInsuredBSchema;
	}

	public LNPInsuredBDB getDB()
	{
		LNPInsuredBDB aDBOper = new LNPInsuredBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proposalContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(insuredId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(prtNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(manageCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(signCity))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(executeCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(familyID))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(relationToMainInsured))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(relationToAppnt))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(addressNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(sequenceNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(name))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appellation))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(sex))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(birthday)))).append("|").append(ChgData.chgData(appAge)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appAgetype))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iDType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iDNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(iDValidity)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iDPerpetual))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(nativePlace))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(nationality))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(rgtAddress))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(marriage))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(marriageDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(health))).append("|").append(ChgData.chgData(stature)).append("|").append(ChgData.chgData(avoirdupois)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(degree))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(creditGrade))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bankCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bankAccNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(accName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(joinCompanyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(startWorkDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(position))).append("|").append(ChgData.chgData(salary)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(occupationType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(occupationCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(partOccupationType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(partOccupationCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(workType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(pluralityType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(smokeFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contPlanCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).append("|").append(ChgData.chgData(insuredPeoples)).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			insuredNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			insuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			appntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			appntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			signCity = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			executeCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			familyID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			relationToMainInsured = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			relationToAppnt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			sequenceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			birthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
			appAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|")))).intValue();
			appAgetype = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			iDValidity = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
			iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			marriageDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|"));
			health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			stature = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|")))).doubleValue();
			avoirdupois = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|")))).doubleValue();
			degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			joinCompanyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|"));
			startWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|"));
			position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			salary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|")))).doubleValue();
			occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			partOccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			partOccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			contPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, "|");
			insuredPeoples = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|")))).intValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredBSchema";
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
		if (FCode.equals("grpContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpContNo));
		if (FCode.equals("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equals("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equals("insuredNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredNo));
		if (FCode.equals("insuredId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuredId));
		if (FCode.equals("prtNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prtNo));
		if (FCode.equals("appntNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntNo));
		if (FCode.equals("appntId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntId));
		if (FCode.equals("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equals("signCity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signCity));
		if (FCode.equals("executeCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(executeCom));
		if (FCode.equals("familyID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(familyID));
		if (FCode.equals("relationToMainInsured"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relationToMainInsured));
		if (FCode.equals("relationToAppnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relationToAppnt));
		if (FCode.equals("addressNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addressNo));
		if (FCode.equals("sequenceNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sequenceNo));
		if (FCode.equals("name"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(name));
		if (FCode.equals("appellation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appellation));
		if (FCode.equals("sex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sex));
		if (FCode.equals("birthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getbirthday()));
		if (FCode.equals("appAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appAge));
		if (FCode.equals("appAgetype"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appAgetype));
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
		if (FCode.equals("partOccupationType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(partOccupationType));
		if (FCode.equals("partOccupationCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(partOccupationCode));
		if (FCode.equals("workType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(workType));
		if (FCode.equals("pluralityType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pluralityType));
		if (FCode.equals("smokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(smokeFlag));
		if (FCode.equals("contPlanCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contPlanCode));
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
		if (FCode.equals("insuredPeoples"))
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
			strFieldValue = StrTool.GBKToUnicode(EdorNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(serialNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(insuredNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(insuredId);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(prtNo);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(appntNo);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(appntId);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(signCity);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(executeCom);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(familyID);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(relationToMainInsured);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(relationToAppnt);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(addressNo);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(sequenceNo);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(name);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(appellation);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(sex);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getbirthday()));
			break;

		case 22: // '\026'
			strFieldValue = String.valueOf(appAge);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(appAgetype);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(iDType);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(iDNo);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(iDPerpetual);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(nativePlace);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(nationality);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(rgtAddress);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(marriage);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(health);
			break;

		case 34: // '"'
			strFieldValue = String.valueOf(stature);
			break;

		case 35: // '#'
			strFieldValue = String.valueOf(avoirdupois);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(degree);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(creditGrade);
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(bankCode);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(bankAccNo);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(accName);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(position);
			break;

		case 44: // ','
			strFieldValue = String.valueOf(salary);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(occupationType);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(occupationCode);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(partOccupationType);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(partOccupationCode);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(workType);
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(pluralityType);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(smokeFlag);
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(contPlanCode);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 54: // '6'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 55: // '7'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 56: // '8'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
			break;

		case 57: // '9'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 58: // ':'
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
		if (FCode.equals("grpContNo"))
			if (FValue != null && !FValue.equals(""))
				grpContNo = FValue.trim();
			else
				grpContNo = null;
		if (FCode.equals("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equals("proposalContNo"))
			if (FValue != null && !FValue.equals(""))
				proposalContNo = FValue.trim();
			else
				proposalContNo = null;
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
		if (FCode.equals("prtNo"))
			if (FValue != null && !FValue.equals(""))
				prtNo = FValue.trim();
			else
				prtNo = null;
		if (FCode.equals("appntNo"))
			if (FValue != null && !FValue.equals(""))
				appntNo = FValue.trim();
			else
				appntNo = null;
		if (FCode.equals("appntId"))
			if (FValue != null && !FValue.equals(""))
				appntId = FValue.trim();
			else
				appntId = null;
		if (FCode.equals("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equals("signCity"))
			if (FValue != null && !FValue.equals(""))
				signCity = FValue.trim();
			else
				signCity = null;
		if (FCode.equals("executeCom"))
			if (FValue != null && !FValue.equals(""))
				executeCom = FValue.trim();
			else
				executeCom = null;
		if (FCode.equals("familyID"))
			if (FValue != null && !FValue.equals(""))
				familyID = FValue.trim();
			else
				familyID = null;
		if (FCode.equals("relationToMainInsured"))
			if (FValue != null && !FValue.equals(""))
				relationToMainInsured = FValue.trim();
			else
				relationToMainInsured = null;
		if (FCode.equals("relationToAppnt"))
			if (FValue != null && !FValue.equals(""))
				relationToAppnt = FValue.trim();
			else
				relationToAppnt = null;
		if (FCode.equals("addressNo"))
			if (FValue != null && !FValue.equals(""))
				addressNo = FValue.trim();
			else
				addressNo = null;
		if (FCode.equals("sequenceNo"))
			if (FValue != null && !FValue.equals(""))
				sequenceNo = FValue.trim();
			else
				sequenceNo = null;
		if (FCode.equals("name"))
			if (FValue != null && !FValue.equals(""))
				name = FValue.trim();
			else
				name = null;
		if (FCode.equals("appellation"))
			if (FValue != null && !FValue.equals(""))
				appellation = FValue.trim();
			else
				appellation = null;
		if (FCode.equals("sex"))
			if (FValue != null && !FValue.equals(""))
				sex = FValue.trim();
			else
				sex = null;
		if (FCode.equals("birthday"))
			if (FValue != null && !FValue.equals(""))
				birthday = fDate.getDate(FValue);
			else
				birthday = null;
		if (FCode.equals("appAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			appAge = i;
		}
		if (FCode.equals("appAgetype"))
			if (FValue != null && !FValue.equals(""))
				appAgetype = FValue.trim();
			else
				appAgetype = null;
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
		if (FCode.equals("partOccupationType"))
			if (FValue != null && !FValue.equals(""))
				partOccupationType = FValue.trim();
			else
				partOccupationType = null;
		if (FCode.equals("partOccupationCode"))
			if (FValue != null && !FValue.equals(""))
				partOccupationCode = FValue.trim();
			else
				partOccupationCode = null;
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
		if (FCode.equals("contPlanCode"))
			if (FValue != null && !FValue.equals(""))
				contPlanCode = FValue.trim();
			else
				contPlanCode = null;
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
		if (FCode.equals("insuredPeoples") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			insuredPeoples = i;
		}
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
		LNPInsuredBSchema other = (LNPInsuredBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && grpContNo.equals(other.getgrpContNo()) && contNo.equals(other.getcontNo()) && proposalContNo.equals(other.getproposalContNo()) && insuredNo.equals(other.getinsuredNo()) && insuredId.equals(other.getinsuredId()) && prtNo.equals(other.getprtNo()) && appntNo.equals(other.getappntNo()) && appntId.equals(other.getappntId()) && manageCom.equals(other.getmanageCom()) && signCity.equals(other.getsignCity()) && executeCom.equals(other.getexecuteCom()) && familyID.equals(other.getfamilyID()) && relationToMainInsured.equals(other.getrelationToMainInsured()) && relationToAppnt.equals(other.getrelationToAppnt()) && addressNo.equals(other.getaddressNo()) && sequenceNo.equals(other.getsequenceNo()) && name.equals(other.getname()) && appellation.equals(other.getappellation()) && sex.equals(other.getsex()) && fDate.getString(birthday).equals(other.getbirthday()) && appAge == other.getappAge() && appAgetype.equals(other.getappAgetype()) && iDType.equals(other.getiDType()) && iDNo.equals(other.getiDNo()) && fDate.getString(iDValidity).equals(other.getiDValidity()) && iDPerpetual.equals(other.getiDPerpetual()) && nativePlace.equals(other.getnativePlace()) && nationality.equals(other.getnationality()) && rgtAddress.equals(other.getrgtAddress()) && marriage.equals(other.getmarriage()) && fDate.getString(marriageDate).equals(other.getmarriageDate()) && health.equals(other.gethealth()) && stature == other.getstature() && avoirdupois == other.getavoirdupois() && degree.equals(other.getdegree()) && creditGrade.equals(other.getcreditGrade()) && bankCode.equals(other.getbankCode()) && bankAccNo.equals(other.getbankAccNo()) && accName.equals(other.getaccName()) && fDate.getString(joinCompanyDate).equals(other.getjoinCompanyDate()) && fDate.getString(startWorkDate).equals(other.getstartWorkDate()) && position.equals(other.getposition()) && salary == other.getsalary() && occupationType.equals(other.getoccupationType()) && occupationCode.equals(other.getoccupationCode()) && partOccupationType.equals(other.getpartOccupationType()) && partOccupationCode.equals(other.getpartOccupationCode()) && workType.equals(other.getworkType()) && pluralityType.equals(other.getpluralityType()) && smokeFlag.equals(other.getsmokeFlag()) && contPlanCode.equals(other.getcontPlanCode()) && operator.equals(other.getoperator()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime()) && insuredPeoples == other.getinsuredPeoples();
	}

	public int getFieldCount()
	{
		return 59;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("grpContNo"))
			return 2;
		if (strFieldName.equals("contNo"))
			return 3;
		if (strFieldName.equals("proposalContNo"))
			return 4;
		if (strFieldName.equals("insuredNo"))
			return 5;
		if (strFieldName.equals("insuredId"))
			return 6;
		if (strFieldName.equals("prtNo"))
			return 7;
		if (strFieldName.equals("appntNo"))
			return 8;
		if (strFieldName.equals("appntId"))
			return 9;
		if (strFieldName.equals("manageCom"))
			return 10;
		if (strFieldName.equals("signCity"))
			return 11;
		if (strFieldName.equals("executeCom"))
			return 12;
		if (strFieldName.equals("familyID"))
			return 13;
		if (strFieldName.equals("relationToMainInsured"))
			return 14;
		if (strFieldName.equals("relationToAppnt"))
			return 15;
		if (strFieldName.equals("addressNo"))
			return 16;
		if (strFieldName.equals("sequenceNo"))
			return 17;
		if (strFieldName.equals("name"))
			return 18;
		if (strFieldName.equals("appellation"))
			return 19;
		if (strFieldName.equals("sex"))
			return 20;
		if (strFieldName.equals("birthday"))
			return 21;
		if (strFieldName.equals("appAge"))
			return 22;
		if (strFieldName.equals("appAgetype"))
			return 23;
		if (strFieldName.equals("iDType"))
			return 24;
		if (strFieldName.equals("iDNo"))
			return 25;
		if (strFieldName.equals("iDValidity"))
			return 26;
		if (strFieldName.equals("iDPerpetual"))
			return 27;
		if (strFieldName.equals("nativePlace"))
			return 28;
		if (strFieldName.equals("nationality"))
			return 29;
		if (strFieldName.equals("rgtAddress"))
			return 30;
		if (strFieldName.equals("marriage"))
			return 31;
		if (strFieldName.equals("marriageDate"))
			return 32;
		if (strFieldName.equals("health"))
			return 33;
		if (strFieldName.equals("stature"))
			return 34;
		if (strFieldName.equals("avoirdupois"))
			return 35;
		if (strFieldName.equals("degree"))
			return 36;
		if (strFieldName.equals("creditGrade"))
			return 37;
		if (strFieldName.equals("bankCode"))
			return 38;
		if (strFieldName.equals("bankAccNo"))
			return 39;
		if (strFieldName.equals("accName"))
			return 40;
		if (strFieldName.equals("joinCompanyDate"))
			return 41;
		if (strFieldName.equals("startWorkDate"))
			return 42;
		if (strFieldName.equals("position"))
			return 43;
		if (strFieldName.equals("salary"))
			return 44;
		if (strFieldName.equals("occupationType"))
			return 45;
		if (strFieldName.equals("occupationCode"))
			return 46;
		if (strFieldName.equals("partOccupationType"))
			return 47;
		if (strFieldName.equals("partOccupationCode"))
			return 48;
		if (strFieldName.equals("workType"))
			return 49;
		if (strFieldName.equals("pluralityType"))
			return 50;
		if (strFieldName.equals("smokeFlag"))
			return 51;
		if (strFieldName.equals("contPlanCode"))
			return 52;
		if (strFieldName.equals("operator"))
			return 53;
		if (strFieldName.equals("makeDate"))
			return 54;
		if (strFieldName.equals("makeTime"))
			return 55;
		if (strFieldName.equals("modifyDate"))
			return 56;
		if (strFieldName.equals("modifyTime"))
			return 57;
		return !strFieldName.equals("insuredPeoples") ? -1 : 58;
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
			strFieldName = "grpContNo";
			break;

		case 3: // '\003'
			strFieldName = "contNo";
			break;

		case 4: // '\004'
			strFieldName = "proposalContNo";
			break;

		case 5: // '\005'
			strFieldName = "insuredNo";
			break;

		case 6: // '\006'
			strFieldName = "insuredId";
			break;

		case 7: // '\007'
			strFieldName = "prtNo";
			break;

		case 8: // '\b'
			strFieldName = "appntNo";
			break;

		case 9: // '\t'
			strFieldName = "appntId";
			break;

		case 10: // '\n'
			strFieldName = "manageCom";
			break;

		case 11: // '\013'
			strFieldName = "signCity";
			break;

		case 12: // '\f'
			strFieldName = "executeCom";
			break;

		case 13: // '\r'
			strFieldName = "familyID";
			break;

		case 14: // '\016'
			strFieldName = "relationToMainInsured";
			break;

		case 15: // '\017'
			strFieldName = "relationToAppnt";
			break;

		case 16: // '\020'
			strFieldName = "addressNo";
			break;

		case 17: // '\021'
			strFieldName = "sequenceNo";
			break;

		case 18: // '\022'
			strFieldName = "name";
			break;

		case 19: // '\023'
			strFieldName = "appellation";
			break;

		case 20: // '\024'
			strFieldName = "sex";
			break;

		case 21: // '\025'
			strFieldName = "birthday";
			break;

		case 22: // '\026'
			strFieldName = "appAge";
			break;

		case 23: // '\027'
			strFieldName = "appAgetype";
			break;

		case 24: // '\030'
			strFieldName = "iDType";
			break;

		case 25: // '\031'
			strFieldName = "iDNo";
			break;

		case 26: // '\032'
			strFieldName = "iDValidity";
			break;

		case 27: // '\033'
			strFieldName = "iDPerpetual";
			break;

		case 28: // '\034'
			strFieldName = "nativePlace";
			break;

		case 29: // '\035'
			strFieldName = "nationality";
			break;

		case 30: // '\036'
			strFieldName = "rgtAddress";
			break;

		case 31: // '\037'
			strFieldName = "marriage";
			break;

		case 32: // ' '
			strFieldName = "marriageDate";
			break;

		case 33: // '!'
			strFieldName = "health";
			break;

		case 34: // '"'
			strFieldName = "stature";
			break;

		case 35: // '#'
			strFieldName = "avoirdupois";
			break;

		case 36: // '$'
			strFieldName = "degree";
			break;

		case 37: // '%'
			strFieldName = "creditGrade";
			break;

		case 38: // '&'
			strFieldName = "bankCode";
			break;

		case 39: // '\''
			strFieldName = "bankAccNo";
			break;

		case 40: // '('
			strFieldName = "accName";
			break;

		case 41: // ')'
			strFieldName = "joinCompanyDate";
			break;

		case 42: // '*'
			strFieldName = "startWorkDate";
			break;

		case 43: // '+'
			strFieldName = "position";
			break;

		case 44: // ','
			strFieldName = "salary";
			break;

		case 45: // '-'
			strFieldName = "occupationType";
			break;

		case 46: // '.'
			strFieldName = "occupationCode";
			break;

		case 47: // '/'
			strFieldName = "partOccupationType";
			break;

		case 48: // '0'
			strFieldName = "partOccupationCode";
			break;

		case 49: // '1'
			strFieldName = "workType";
			break;

		case 50: // '2'
			strFieldName = "pluralityType";
			break;

		case 51: // '3'
			strFieldName = "smokeFlag";
			break;

		case 52: // '4'
			strFieldName = "contPlanCode";
			break;

		case 53: // '5'
			strFieldName = "operator";
			break;

		case 54: // '6'
			strFieldName = "makeDate";
			break;

		case 55: // '7'
			strFieldName = "makeTime";
			break;

		case 56: // '8'
			strFieldName = "modifyDate";
			break;

		case 57: // '9'
			strFieldName = "modifyTime";
			break;

		case 58: // ':'
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
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 0;
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
		if (strFieldName.equals("appAgetype"))
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
			nFieldType = 0;
			break;

		case 20: // '\024'
			nFieldType = 0;
			break;

		case 21: // '\025'
			nFieldType = 1;
			break;

		case 22: // '\026'
			nFieldType = 3;
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
			nFieldType = 0;
			break;

		case 34: // '"'
			nFieldType = 4;
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
			nFieldType = 1;
			break;

		case 42: // '*'
			nFieldType = 1;
			break;

		case 43: // '+'
			nFieldType = 0;
			break;

		case 44: // ','
			nFieldType = 4;
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
			nFieldType = 1;
			break;

		case 57: // '9'
			nFieldType = 0;
			break;

		case 58: // ':'
			nFieldType = 3;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
