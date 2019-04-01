// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPersonBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPPersonBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPPersonBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
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
	public static final int FIELDNUM = 58;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPPersonBSchema()
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

	public String getagentCode()
	{
		if (agentCode != null)
			agentCode.equals("");
		return agentCode;
	}

	public void setagentCode(String aagentCode)
	{
		agentCode = aagentCode;
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

	public int getage()
	{
		return age;
	}

	public void setage(int aage)
	{
		age = aage;
	}

	public void setage(String aage)
	{
		if (aage != null && !aage.equals(""))
		{
			Integer tInteger = new Integer(aage);
			int i = tInteger.intValue();
			age = i;
		}
	}

	public String getageType()
	{
		if (ageType != null)
			ageType.equals("");
		return ageType;
	}

	public void setageType(String aageType)
	{
		ageType = aageType;
	}

	public String getappntType()
	{
		if (appntType != null)
			appntType.equals("");
		return appntType;
	}

	public void setappntType(String aappntType)
	{
		appntType = aappntType;
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

	public String getpassword()
	{
		if (password != null)
			password.equals("");
		return password;
	}

	public void setpassword(String apassword)
	{
		password = apassword;
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

	public String getothIDType()
	{
		if (othIDType != null)
			othIDType.equals("");
		return othIDType;
	}

	public void setothIDType(String aothIDType)
	{
		othIDType = aothIDType;
	}

	public String getothIDNo()
	{
		if (othIDNo != null)
			othIDNo.equals("");
		return othIDNo;
	}

	public void setothIDNo(String aothIDNo)
	{
		othIDNo = aothIDNo;
	}

	public String getiCNo()
	{
		if (iCNo != null)
			iCNo.equals("");
		return iCNo;
	}

	public void setiCNo(String aiCNo)
	{
		iCNo = aiCNo;
	}

	public String getgrpNo()
	{
		if (grpNo != null)
			grpNo.equals("");
		return grpNo;
	}

	public void setgrpNo(String agrpNo)
	{
		grpNo = agrpNo;
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

	public String getdeathDate()
	{
		if (deathDate != null)
			return fDate.getString(deathDate);
		else
			return null;
	}

	public void setdeathDate(Date adeathDate)
	{
		deathDate = adeathDate;
	}

	public void setdeathDate(String adeathDate)
	{
		if (adeathDate != null && !adeathDate.equals(""))
			deathDate = fDate.getDate(adeathDate);
		else
			deathDate = null;
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

	public String getblacklistFlag()
	{
		if (blacklistFlag != null)
			blacklistFlag.equals("");
		return blacklistFlag;
	}

	public void setblacklistFlag(String ablacklistFlag)
	{
		blacklistFlag = ablacklistFlag;
	}

	public String getproterty()
	{
		if (proterty != null)
			proterty.equals("");
		return proterty;
	}

	public void setproterty(String aproterty)
	{
		proterty = aproterty;
	}

	public String getremark()
	{
		if (remark != null)
			remark.equals("");
		return remark;
	}

	public void setremark(String aremark)
	{
		remark = aremark;
	}

	public String getstate()
	{
		if (state != null)
			state.equals("");
		return state;
	}

	public void setstate(String astate)
	{
		state = astate;
	}

	public String getvIPValue()
	{
		if (vIPValue != null)
			vIPValue.equals("");
		return vIPValue;
	}

	public void setvIPValue(String avIPValue)
	{
		vIPValue = avIPValue;
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

	public void setSchema(LNPPersonBSchema aLNPPersonBSchema)
	{
		EdorNo = aLNPPersonBSchema.getEdorNo();
		serialNo = aLNPPersonBSchema.getserialNo();
		customerId = aLNPPersonBSchema.getcustomerId();
		agentCode = aLNPPersonBSchema.getagentCode();
		customerNo = aLNPPersonBSchema.getcustomerNo();
		appellation = aLNPPersonBSchema.getappellation();
		name = aLNPPersonBSchema.getname();
		sex = aLNPPersonBSchema.getsex();
		birthday = fDate.getDate(aLNPPersonBSchema.getbirthday());
		age = aLNPPersonBSchema.getage();
		ageType = aLNPPersonBSchema.getageType();
		appntType = aLNPPersonBSchema.getappntType();
		iDType = aLNPPersonBSchema.getiDType();
		iDNo = aLNPPersonBSchema.getiDNo();
		iDValidity = fDate.getDate(aLNPPersonBSchema.getiDValidity());
		iDPerpetual = aLNPPersonBSchema.getiDPerpetual();
		password = aLNPPersonBSchema.getpassword();
		nativePlace = aLNPPersonBSchema.getnativePlace();
		nationality = aLNPPersonBSchema.getnationality();
		rgtAddress = aLNPPersonBSchema.getrgtAddress();
		marriage = aLNPPersonBSchema.getmarriage();
		marriageDate = fDate.getDate(aLNPPersonBSchema.getmarriageDate());
		health = aLNPPersonBSchema.gethealth();
		stature = aLNPPersonBSchema.getstature();
		avoirdupois = aLNPPersonBSchema.getavoirdupois();
		degree = aLNPPersonBSchema.getdegree();
		creditGrade = aLNPPersonBSchema.getcreditGrade();
		bankCode = aLNPPersonBSchema.getbankCode();
		bankAccNo = aLNPPersonBSchema.getbankAccNo();
		accName = aLNPPersonBSchema.getaccName();
		othIDType = aLNPPersonBSchema.getothIDType();
		othIDNo = aLNPPersonBSchema.getothIDNo();
		iCNo = aLNPPersonBSchema.getiCNo();
		grpNo = aLNPPersonBSchema.getgrpNo();
		joinCompanyDate = fDate.getDate(aLNPPersonBSchema.getjoinCompanyDate());
		startWorkDate = fDate.getDate(aLNPPersonBSchema.getstartWorkDate());
		position = aLNPPersonBSchema.getposition();
		salary = aLNPPersonBSchema.getsalary();
		occupationType = aLNPPersonBSchema.getoccupationType();
		occupationCode = aLNPPersonBSchema.getoccupationCode();
		partOccupationType = aLNPPersonBSchema.getpartOccupationType();
		partOccupationCode = aLNPPersonBSchema.getpartOccupationCode();
		workType = aLNPPersonBSchema.getworkType();
		pluralityType = aLNPPersonBSchema.getpluralityType();
		deathDate = fDate.getDate(aLNPPersonBSchema.getdeathDate());
		smokeFlag = aLNPPersonBSchema.getsmokeFlag();
		blacklistFlag = aLNPPersonBSchema.getblacklistFlag();
		proterty = aLNPPersonBSchema.getproterty();
		remark = aLNPPersonBSchema.getremark();
		state = aLNPPersonBSchema.getstate();
		vIPValue = aLNPPersonBSchema.getvIPValue();
		operator = aLNPPersonBSchema.getoperator();
		manageCom = aLNPPersonBSchema.getmanageCom();
		makeDate = fDate.getDate(aLNPPersonBSchema.getmakeDate());
		makeTime = aLNPPersonBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPPersonBSchema.getmodifyDate());
		modifyTime = aLNPPersonBSchema.getmodifyTime();
		grpName = aLNPPersonBSchema.getgrpName();
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
			if (rs.getString("agentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("agentCode").trim();
			if (rs.getString("customerNo") == null)
				customerNo = null;
			else
				customerNo = rs.getString("customerNo").trim();
			if (rs.getString("appellation") == null)
				appellation = null;
			else
				appellation = rs.getString("appellation").trim();
			if (rs.getString("name") == null)
				name = null;
			else
				name = rs.getString("name").trim();
			if (rs.getString("sex") == null)
				sex = null;
			else
				sex = rs.getString("sex").trim();
			birthday = rs.getDate("birthday");
			age = rs.getInt("age");
			if (rs.getString("ageType") == null)
				ageType = null;
			else
				ageType = rs.getString("ageType").trim();
			if (rs.getString("appntType") == null)
				appntType = null;
			else
				appntType = rs.getString("appntType").trim();
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
			if (rs.getString("password") == null)
				password = null;
			else
				password = rs.getString("password").trim();
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
			if (rs.getString("othIDType") == null)
				othIDType = null;
			else
				othIDType = rs.getString("othIDType").trim();
			if (rs.getString("othIDNo") == null)
				othIDNo = null;
			else
				othIDNo = rs.getString("othIDNo").trim();
			if (rs.getString("iCNo") == null)
				iCNo = null;
			else
				iCNo = rs.getString("iCNo").trim();
			if (rs.getString("grpNo") == null)
				grpNo = null;
			else
				grpNo = rs.getString("grpNo").trim();
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
			deathDate = rs.getDate("deathDate");
			if (rs.getString("smokeFlag") == null)
				smokeFlag = null;
			else
				smokeFlag = rs.getString("smokeFlag").trim();
			if (rs.getString("blacklistFlag") == null)
				blacklistFlag = null;
			else
				blacklistFlag = rs.getString("blacklistFlag").trim();
			if (rs.getString("proterty") == null)
				proterty = null;
			else
				proterty = rs.getString("proterty").trim();
			if (rs.getString("remark") == null)
				remark = null;
			else
				remark = rs.getString("remark").trim();
			if (rs.getString("state") == null)
				state = null;
			else
				state = rs.getString("state").trim();
			if (rs.getString("vIPValue") == null)
				vIPValue = null;
			else
				vIPValue = rs.getString("vIPValue").trim();
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
			if (rs.getString("grpName") == null)
				grpName = null;
			else
				grpName = rs.getString("grpName").trim();
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPersonBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPPersonBSchema getSchema()
	{
		LNPPersonBSchema aLNPPersonBSchema = new LNPPersonBSchema();
		aLNPPersonBSchema.setSchema(this);
		return aLNPPersonBSchema;
	}

	public LNPPersonBDB getDB()
	{
		LNPPersonBDB aDBOper = new LNPPersonBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(customerId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(customerNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appellation))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(name))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(sex))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(birthday)))).append("|").append(ChgData.chgData(age)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ageType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(appntType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iDType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iDNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(iDValidity)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iDPerpetual))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(password))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(nativePlace))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(nationality))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(rgtAddress))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(marriage))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(marriageDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(health))).append("|").append(ChgData.chgData(stature)).append("|").append(ChgData.chgData(avoirdupois)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(degree))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(creditGrade))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bankCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bankAccNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(accName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(othIDType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(othIDNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(iCNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(joinCompanyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(startWorkDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(position))).append("|").append(ChgData.chgData(salary)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(occupationType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(occupationCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(partOccupationType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(partOccupationCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(workType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(pluralityType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(deathDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(smokeFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(blacklistFlag))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proterty))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(remark))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(state))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(vIPValue))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(manageCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpName))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			appellation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			birthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			age = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).intValue();
			ageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			appntType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			iDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			iDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			iDValidity = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			iDPerpetual = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			nativePlace = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			rgtAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			marriageDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
			health = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			stature = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|")))).doubleValue();
			avoirdupois = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 25, "|")))).doubleValue();
			degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			creditGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			othIDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			othIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			iCNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			grpNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			joinCompanyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|"));
			startWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|"));
			position = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			salary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|")))).doubleValue();
			occupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			partOccupationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			partOccupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			pluralityType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			deathDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|"));
			smokeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
			blacklistFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|");
			proterty = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|");
			vIPValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, "|");
			grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPersonBSchema";
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
		if (FCode.equals("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equals("customerNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(customerNo));
		if (FCode.equals("appellation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appellation));
		if (FCode.equals("name"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(name));
		if (FCode.equals("sex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sex));
		if (FCode.equals("birthday"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getbirthday()));
		if (FCode.equals("age"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(age));
		if (FCode.equals("ageType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ageType));
		if (FCode.equals("appntType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(appntType));
		if (FCode.equals("iDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDType));
		if (FCode.equals("iDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDNo));
		if (FCode.equals("iDValidity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
		if (FCode.equals("iDPerpetual"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iDPerpetual));
		if (FCode.equals("password"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(password));
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
		if (FCode.equals("othIDType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(othIDType));
		if (FCode.equals("othIDNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(othIDNo));
		if (FCode.equals("iCNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iCNo));
		if (FCode.equals("grpNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpNo));
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
		if (FCode.equals("deathDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getdeathDate()));
		if (FCode.equals("smokeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(smokeFlag));
		if (FCode.equals("blacklistFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(blacklistFlag));
		if (FCode.equals("proterty"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proterty));
		if (FCode.equals("remark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark));
		if (FCode.equals("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equals("vIPValue"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vIPValue));
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
		if (FCode.equals("grpName"))
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
			strFieldValue = StrTool.GBKToUnicode(EdorNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(serialNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(customerId);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(customerNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(appellation);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(name);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(sex);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getbirthday()));
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(age);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(ageType);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(appntType);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(iDType);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(iDNo);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getiDValidity()));
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(iDPerpetual);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(password);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(nativePlace);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(nationality);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(rgtAddress);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(marriage);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmarriageDate()));
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(health);
			break;

		case 23: // '\027'
			strFieldValue = String.valueOf(stature);
			break;

		case 24: // '\030'
			strFieldValue = String.valueOf(avoirdupois);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(degree);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(creditGrade);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(bankCode);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(bankAccNo);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(accName);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(othIDType);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(othIDNo);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(iCNo);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(grpNo);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getjoinCompanyDate()));
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getstartWorkDate()));
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
			strFieldValue = StrTool.GBKToUnicode(partOccupationType);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(partOccupationCode);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(workType);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(pluralityType);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getdeathDate()));
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(smokeFlag);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(blacklistFlag);
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(proterty);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(remark);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(vIPValue);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 53: // '5'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 54: // '6'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 55: // '7'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
			break;

		case 56: // '8'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 57: // '9'
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
		if (FCode.equals("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equals("customerNo"))
			if (FValue != null && !FValue.equals(""))
				customerNo = FValue.trim();
			else
				customerNo = null;
		if (FCode.equals("appellation"))
			if (FValue != null && !FValue.equals(""))
				appellation = FValue.trim();
			else
				appellation = null;
		if (FCode.equals("name"))
			if (FValue != null && !FValue.equals(""))
				name = FValue.trim();
			else
				name = null;
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
		if (FCode.equals("age") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			age = i;
		}
		if (FCode.equals("ageType"))
			if (FValue != null && !FValue.equals(""))
				ageType = FValue.trim();
			else
				ageType = null;
		if (FCode.equals("appntType"))
			if (FValue != null && !FValue.equals(""))
				appntType = FValue.trim();
			else
				appntType = null;
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
		if (FCode.equals("password"))
			if (FValue != null && !FValue.equals(""))
				password = FValue.trim();
			else
				password = null;
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
		if (FCode.equals("othIDType"))
			if (FValue != null && !FValue.equals(""))
				othIDType = FValue.trim();
			else
				othIDType = null;
		if (FCode.equals("othIDNo"))
			if (FValue != null && !FValue.equals(""))
				othIDNo = FValue.trim();
			else
				othIDNo = null;
		if (FCode.equals("iCNo"))
			if (FValue != null && !FValue.equals(""))
				iCNo = FValue.trim();
			else
				iCNo = null;
		if (FCode.equals("grpNo"))
			if (FValue != null && !FValue.equals(""))
				grpNo = FValue.trim();
			else
				grpNo = null;
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
		if (FCode.equals("deathDate"))
			if (FValue != null && !FValue.equals(""))
				deathDate = fDate.getDate(FValue);
			else
				deathDate = null;
		if (FCode.equals("smokeFlag"))
			if (FValue != null && !FValue.equals(""))
				smokeFlag = FValue.trim();
			else
				smokeFlag = null;
		if (FCode.equals("blacklistFlag"))
			if (FValue != null && !FValue.equals(""))
				blacklistFlag = FValue.trim();
			else
				blacklistFlag = null;
		if (FCode.equals("proterty"))
			if (FValue != null && !FValue.equals(""))
				proterty = FValue.trim();
			else
				proterty = null;
		if (FCode.equals("remark"))
			if (FValue != null && !FValue.equals(""))
				remark = FValue.trim();
			else
				remark = null;
		if (FCode.equals("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equals("vIPValue"))
			if (FValue != null && !FValue.equals(""))
				vIPValue = FValue.trim();
			else
				vIPValue = null;
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
		if (FCode.equals("grpName"))
			if (FValue != null && !FValue.equals(""))
				grpName = FValue.trim();
			else
				grpName = null;
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
		LNPPersonBSchema other = (LNPPersonBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && customerId.equals(other.getcustomerId()) && agentCode.equals(other.getagentCode()) && customerNo.equals(other.getcustomerNo()) && appellation.equals(other.getappellation()) && name.equals(other.getname()) && sex.equals(other.getsex()) && fDate.getString(birthday).equals(other.getbirthday()) && age == other.getage() && ageType.equals(other.getageType()) && appntType.equals(other.getappntType()) && iDType.equals(other.getiDType()) && iDNo.equals(other.getiDNo()) && fDate.getString(iDValidity).equals(other.getiDValidity()) && iDPerpetual.equals(other.getiDPerpetual()) && password.equals(other.getpassword()) && nativePlace.equals(other.getnativePlace()) && nationality.equals(other.getnationality()) && rgtAddress.equals(other.getrgtAddress()) && marriage.equals(other.getmarriage()) && fDate.getString(marriageDate).equals(other.getmarriageDate()) && health.equals(other.gethealth()) && stature == other.getstature() && avoirdupois == other.getavoirdupois() && degree.equals(other.getdegree()) && creditGrade.equals(other.getcreditGrade()) && bankCode.equals(other.getbankCode()) && bankAccNo.equals(other.getbankAccNo()) && accName.equals(other.getaccName()) && othIDType.equals(other.getothIDType()) && othIDNo.equals(other.getothIDNo()) && iCNo.equals(other.getiCNo()) && grpNo.equals(other.getgrpNo()) && fDate.getString(joinCompanyDate).equals(other.getjoinCompanyDate()) && fDate.getString(startWorkDate).equals(other.getstartWorkDate()) && position.equals(other.getposition()) && salary == other.getsalary() && occupationType.equals(other.getoccupationType()) && occupationCode.equals(other.getoccupationCode()) && partOccupationType.equals(other.getpartOccupationType()) && partOccupationCode.equals(other.getpartOccupationCode()) && workType.equals(other.getworkType()) && pluralityType.equals(other.getpluralityType()) && fDate.getString(deathDate).equals(other.getdeathDate()) && smokeFlag.equals(other.getsmokeFlag()) && blacklistFlag.equals(other.getblacklistFlag()) && proterty.equals(other.getproterty()) && remark.equals(other.getremark()) && state.equals(other.getstate()) && vIPValue.equals(other.getvIPValue()) && operator.equals(other.getoperator()) && manageCom.equals(other.getmanageCom()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime()) && grpName.equals(other.getgrpName());
	}

	public int getFieldCount()
	{
		return 58;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("customerId"))
			return 2;
		if (strFieldName.equals("agentCode"))
			return 3;
		if (strFieldName.equals("customerNo"))
			return 4;
		if (strFieldName.equals("appellation"))
			return 5;
		if (strFieldName.equals("name"))
			return 6;
		if (strFieldName.equals("sex"))
			return 7;
		if (strFieldName.equals("birthday"))
			return 8;
		if (strFieldName.equals("age"))
			return 9;
		if (strFieldName.equals("ageType"))
			return 10;
		if (strFieldName.equals("appntType"))
			return 11;
		if (strFieldName.equals("iDType"))
			return 12;
		if (strFieldName.equals("iDNo"))
			return 13;
		if (strFieldName.equals("iDValidity"))
			return 14;
		if (strFieldName.equals("iDPerpetual"))
			return 15;
		if (strFieldName.equals("password"))
			return 16;
		if (strFieldName.equals("nativePlace"))
			return 17;
		if (strFieldName.equals("nationality"))
			return 18;
		if (strFieldName.equals("rgtAddress"))
			return 19;
		if (strFieldName.equals("marriage"))
			return 20;
		if (strFieldName.equals("marriageDate"))
			return 21;
		if (strFieldName.equals("health"))
			return 22;
		if (strFieldName.equals("stature"))
			return 23;
		if (strFieldName.equals("avoirdupois"))
			return 24;
		if (strFieldName.equals("degree"))
			return 25;
		if (strFieldName.equals("creditGrade"))
			return 26;
		if (strFieldName.equals("bankCode"))
			return 27;
		if (strFieldName.equals("bankAccNo"))
			return 28;
		if (strFieldName.equals("accName"))
			return 29;
		if (strFieldName.equals("othIDType"))
			return 30;
		if (strFieldName.equals("othIDNo"))
			return 31;
		if (strFieldName.equals("iCNo"))
			return 32;
		if (strFieldName.equals("grpNo"))
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
		if (strFieldName.equals("partOccupationType"))
			return 40;
		if (strFieldName.equals("partOccupationCode"))
			return 41;
		if (strFieldName.equals("workType"))
			return 42;
		if (strFieldName.equals("pluralityType"))
			return 43;
		if (strFieldName.equals("deathDate"))
			return 44;
		if (strFieldName.equals("smokeFlag"))
			return 45;
		if (strFieldName.equals("blacklistFlag"))
			return 46;
		if (strFieldName.equals("proterty"))
			return 47;
		if (strFieldName.equals("remark"))
			return 48;
		if (strFieldName.equals("state"))
			return 49;
		if (strFieldName.equals("vIPValue"))
			return 50;
		if (strFieldName.equals("operator"))
			return 51;
		if (strFieldName.equals("manageCom"))
			return 52;
		if (strFieldName.equals("makeDate"))
			return 53;
		if (strFieldName.equals("makeTime"))
			return 54;
		if (strFieldName.equals("modifyDate"))
			return 55;
		if (strFieldName.equals("modifyTime"))
			return 56;
		return !strFieldName.equals("grpName") ? -1 : 57;
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
			strFieldName = "agentCode";
			break;

		case 4: // '\004'
			strFieldName = "customerNo";
			break;

		case 5: // '\005'
			strFieldName = "appellation";
			break;

		case 6: // '\006'
			strFieldName = "name";
			break;

		case 7: // '\007'
			strFieldName = "sex";
			break;

		case 8: // '\b'
			strFieldName = "birthday";
			break;

		case 9: // '\t'
			strFieldName = "age";
			break;

		case 10: // '\n'
			strFieldName = "ageType";
			break;

		case 11: // '\013'
			strFieldName = "appntType";
			break;

		case 12: // '\f'
			strFieldName = "iDType";
			break;

		case 13: // '\r'
			strFieldName = "iDNo";
			break;

		case 14: // '\016'
			strFieldName = "iDValidity";
			break;

		case 15: // '\017'
			strFieldName = "iDPerpetual";
			break;

		case 16: // '\020'
			strFieldName = "password";
			break;

		case 17: // '\021'
			strFieldName = "nativePlace";
			break;

		case 18: // '\022'
			strFieldName = "nationality";
			break;

		case 19: // '\023'
			strFieldName = "rgtAddress";
			break;

		case 20: // '\024'
			strFieldName = "marriage";
			break;

		case 21: // '\025'
			strFieldName = "marriageDate";
			break;

		case 22: // '\026'
			strFieldName = "health";
			break;

		case 23: // '\027'
			strFieldName = "stature";
			break;

		case 24: // '\030'
			strFieldName = "avoirdupois";
			break;

		case 25: // '\031'
			strFieldName = "degree";
			break;

		case 26: // '\032'
			strFieldName = "creditGrade";
			break;

		case 27: // '\033'
			strFieldName = "bankCode";
			break;

		case 28: // '\034'
			strFieldName = "bankAccNo";
			break;

		case 29: // '\035'
			strFieldName = "accName";
			break;

		case 30: // '\036'
			strFieldName = "othIDType";
			break;

		case 31: // '\037'
			strFieldName = "othIDNo";
			break;

		case 32: // ' '
			strFieldName = "iCNo";
			break;

		case 33: // '!'
			strFieldName = "grpNo";
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
			strFieldName = "partOccupationType";
			break;

		case 41: // ')'
			strFieldName = "partOccupationCode";
			break;

		case 42: // '*'
			strFieldName = "workType";
			break;

		case 43: // '+'
			strFieldName = "pluralityType";
			break;

		case 44: // ','
			strFieldName = "deathDate";
			break;

		case 45: // '-'
			strFieldName = "smokeFlag";
			break;

		case 46: // '.'
			strFieldName = "blacklistFlag";
			break;

		case 47: // '/'
			strFieldName = "proterty";
			break;

		case 48: // '0'
			strFieldName = "remark";
			break;

		case 49: // '1'
			strFieldName = "state";
			break;

		case 50: // '2'
			strFieldName = "vIPValue";
			break;

		case 51: // '3'
			strFieldName = "operator";
			break;

		case 52: // '4'
			strFieldName = "manageCom";
			break;

		case 53: // '5'
			strFieldName = "makeDate";
			break;

		case 54: // '6'
			strFieldName = "makeTime";
			break;

		case 55: // '7'
			strFieldName = "modifyDate";
			break;

		case 56: // '8'
			strFieldName = "modifyTime";
			break;

		case 57: // '9'
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
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 0;
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
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 1;
			break;

		case 9: // '\t'
			nFieldType = 3;
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
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 23: // '\027'
			nFieldType = 4;
			break;

		case 24: // '\030'
			nFieldType = 4;
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
			nFieldType = 1;
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
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
