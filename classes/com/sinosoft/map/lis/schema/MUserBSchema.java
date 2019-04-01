// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MUserBSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MUserBDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MUserBSchema
	implements Schema, Cloneable
{

	private String userCode;
	private String userName;
	private String manageCom;
	private String branchType;
	private String password;
	private Date pwdModifyDate;
	private String userDescription;
	private String userState;
	private String superPopedomFlag;
	private Date validStartDate;
	private Date validEndDate;
	private String stuffNo;
	private String officePhone;
	private String phone;
	private String eMail;
	private String operator;
	private String modifyOperator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String edorNo;
	private String edorType;
	private String edorCase;
	private String operator2;
	private Date makeDate2;
	private String makeTime2;
	public static final int FIELDNUM = 27;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MUserBSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "EdorNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MUserBSchema cloned = (MUserBSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String aUserCode)
	{
		userCode = aUserCode;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String aUserName)
	{
		userName = aUserName;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getBranchType()
	{
		return branchType;
	}

	public void setBranchType(String aBranchType)
	{
		branchType = aBranchType;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String aPassword)
	{
		password = aPassword;
	}

	public String getPwdModifyDate()
	{
		if (pwdModifyDate != null)
			return fDate.getString(pwdModifyDate);
		else
			return null;
	}

	public void setPwdModifyDate(Date aPwdModifyDate)
	{
		pwdModifyDate = aPwdModifyDate;
	}

	public void setPwdModifyDate(String aPwdModifyDate)
	{
		if (aPwdModifyDate != null && !aPwdModifyDate.equals(""))
			pwdModifyDate = fDate.getDate(aPwdModifyDate);
		else
			pwdModifyDate = null;
	}

	public String getUserDescription()
	{
		return userDescription;
	}

	public void setUserDescription(String aUserDescription)
	{
		userDescription = aUserDescription;
	}

	public String getUserState()
	{
		return userState;
	}

	public void setUserState(String aUserState)
	{
		userState = aUserState;
	}

	public String getSuperPopedomFlag()
	{
		return superPopedomFlag;
	}

	public void setSuperPopedomFlag(String aSuperPopedomFlag)
	{
		superPopedomFlag = aSuperPopedomFlag;
	}

	public String getValidStartDate()
	{
		if (validStartDate != null)
			return fDate.getString(validStartDate);
		else
			return null;
	}

	public void setValidStartDate(Date aValidStartDate)
	{
		validStartDate = aValidStartDate;
	}

	public void setValidStartDate(String aValidStartDate)
	{
		if (aValidStartDate != null && !aValidStartDate.equals(""))
			validStartDate = fDate.getDate(aValidStartDate);
		else
			validStartDate = null;
	}

	public String getValidEndDate()
	{
		if (validEndDate != null)
			return fDate.getString(validEndDate);
		else
			return null;
	}

	public void setValidEndDate(Date aValidEndDate)
	{
		validEndDate = aValidEndDate;
	}

	public void setValidEndDate(String aValidEndDate)
	{
		if (aValidEndDate != null && !aValidEndDate.equals(""))
			validEndDate = fDate.getDate(aValidEndDate);
		else
			validEndDate = null;
	}

	public String getStuffNo()
	{
		return stuffNo;
	}

	public void setStuffNo(String aStuffNo)
	{
		stuffNo = aStuffNo;
	}

	public String getOfficePhone()
	{
		return officePhone;
	}

	public void setOfficePhone(String aOfficePhone)
	{
		officePhone = aOfficePhone;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String aPhone)
	{
		phone = aPhone;
	}

	public String getEMail()
	{
		return eMail;
	}

	public void setEMail(String aEMail)
	{
		eMail = aEMail;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public String getModifyOperator()
	{
		return modifyOperator;
	}

	public void setModifyOperator(String aModifyOperator)
	{
		modifyOperator = aModifyOperator;
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

	public String getEdorNo()
	{
		return edorNo;
	}

	public void setEdorNo(String aEdorNo)
	{
		edorNo = aEdorNo;
	}

	public String getEdorType()
	{
		return edorType;
	}

	public void setEdorType(String aEdorType)
	{
		edorType = aEdorType;
	}

	public String getEdorCase()
	{
		return edorCase;
	}

	public void setEdorCase(String aEdorCase)
	{
		edorCase = aEdorCase;
	}

	public String getOperator2()
	{
		return operator2;
	}

	public void setOperator2(String aOperator2)
	{
		operator2 = aOperator2;
	}

	public String getMakeDate2()
	{
		if (makeDate2 != null)
			return fDate.getString(makeDate2);
		else
			return null;
	}

	public void setMakeDate2(Date aMakeDate2)
	{
		makeDate2 = aMakeDate2;
	}

	public void setMakeDate2(String aMakeDate2)
	{
		if (aMakeDate2 != null && !aMakeDate2.equals(""))
			makeDate2 = fDate.getDate(aMakeDate2);
		else
			makeDate2 = null;
	}

	public String getMakeTime2()
	{
		return makeTime2;
	}

	public void setMakeTime2(String aMakeTime2)
	{
		makeTime2 = aMakeTime2;
	}

	public void setSchema(MUserBSchema aMUserBSchema)
	{
		userCode = aMUserBSchema.getUserCode();
		userName = aMUserBSchema.getUserName();
		manageCom = aMUserBSchema.getManageCom();
		branchType = aMUserBSchema.getBranchType();
		password = aMUserBSchema.getPassword();
		pwdModifyDate = fDate.getDate(aMUserBSchema.getPwdModifyDate());
		userDescription = aMUserBSchema.getUserDescription();
		userState = aMUserBSchema.getUserState();
		superPopedomFlag = aMUserBSchema.getSuperPopedomFlag();
		validStartDate = fDate.getDate(aMUserBSchema.getValidStartDate());
		validEndDate = fDate.getDate(aMUserBSchema.getValidEndDate());
		stuffNo = aMUserBSchema.getStuffNo();
		officePhone = aMUserBSchema.getOfficePhone();
		phone = aMUserBSchema.getPhone();
		eMail = aMUserBSchema.getEMail();
		operator = aMUserBSchema.getOperator();
		modifyOperator = aMUserBSchema.getModifyOperator();
		makeDate = fDate.getDate(aMUserBSchema.getMakeDate());
		makeTime = aMUserBSchema.getMakeTime();
		modifyDate = fDate.getDate(aMUserBSchema.getModifyDate());
		modifyTime = aMUserBSchema.getModifyTime();
		edorNo = aMUserBSchema.getEdorNo();
		edorType = aMUserBSchema.getEdorType();
		edorCase = aMUserBSchema.getEdorCase();
		operator2 = aMUserBSchema.getOperator2();
		makeDate2 = fDate.getDate(aMUserBSchema.getMakeDate2());
		makeTime2 = aMUserBSchema.getMakeTime2();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("UserCode") == null)
				userCode = null;
			else
				userCode = rs.getString("UserCode").trim();
			if (rs.getString("UserName") == null)
				userName = null;
			else
				userName = rs.getString("UserName").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			if (rs.getString("Password") == null)
				password = null;
			else
				password = rs.getString("Password").trim();
			pwdModifyDate = rs.getDate("PwdModifyDate");
			if (rs.getString("UserDescription") == null)
				userDescription = null;
			else
				userDescription = rs.getString("UserDescription").trim();
			if (rs.getString("UserState") == null)
				userState = null;
			else
				userState = rs.getString("UserState").trim();
			if (rs.getString("SuperPopedomFlag") == null)
				superPopedomFlag = null;
			else
				superPopedomFlag = rs.getString("SuperPopedomFlag").trim();
			validStartDate = rs.getDate("ValidStartDate");
			validEndDate = rs.getDate("ValidEndDate");
			if (rs.getString("StuffNo") == null)
				stuffNo = null;
			else
				stuffNo = rs.getString("StuffNo").trim();
			if (rs.getString("OfficePhone") == null)
				officePhone = null;
			else
				officePhone = rs.getString("OfficePhone").trim();
			if (rs.getString("Phone") == null)
				phone = null;
			else
				phone = rs.getString("Phone").trim();
			if (rs.getString("EMail") == null)
				eMail = null;
			else
				eMail = rs.getString("EMail").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			if (rs.getString("ModifyOperator") == null)
				modifyOperator = null;
			else
				modifyOperator = rs.getString("ModifyOperator").trim();
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
			if (rs.getString("EdorNo") == null)
				edorNo = null;
			else
				edorNo = rs.getString("EdorNo").trim();
			if (rs.getString("EdorType") == null)
				edorType = null;
			else
				edorType = rs.getString("EdorType").trim();
			if (rs.getString("EdorCase") == null)
				edorCase = null;
			else
				edorCase = rs.getString("EdorCase").trim();
			if (rs.getString("Operator2") == null)
				operator2 = null;
			else
				operator2 = rs.getString("Operator2").trim();
			makeDate2 = rs.getDate("MakeDate2");
			if (rs.getString("MakeTime2") == null)
				makeTime2 = null;
			else
				makeTime2 = rs.getString("MakeTime2").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MUserB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MUserBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MUserBSchema getSchema()
	{
		MUserBSchema aMUserBSchema = new MUserBSchema();
		aMUserBSchema.setSchema(this);
		return aMUserBSchema;
	}

	public MUserBDB getDB()
	{
		MUserBDB aDBOper = new MUserBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(userCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(userName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(password));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(pwdModifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(userDescription));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(userState));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(superPopedomFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(validStartDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(validEndDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(stuffNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(officePhone));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(phone));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(eMail));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyOperator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(edorNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(edorType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(edorCase));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate2)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime2));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			userCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			userName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			pwdModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
			userDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			userState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			superPopedomFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			validStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			validEndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
			stuffNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			officePhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			makeDate2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
			makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MUserBSchema";
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
		if (FCode.equalsIgnoreCase("userCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(userCode));
		if (FCode.equalsIgnoreCase("userName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(userName));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("password"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(password));
		if (FCode.equalsIgnoreCase("pwdModifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPwdModifyDate()));
		if (FCode.equalsIgnoreCase("userDescription"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(userDescription));
		if (FCode.equalsIgnoreCase("userState"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(userState));
		if (FCode.equalsIgnoreCase("superPopedomFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(superPopedomFlag));
		if (FCode.equalsIgnoreCase("validStartDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getValidStartDate()));
		if (FCode.equalsIgnoreCase("validEndDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getValidEndDate()));
		if (FCode.equalsIgnoreCase("stuffNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(stuffNo));
		if (FCode.equalsIgnoreCase("officePhone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(officePhone));
		if (FCode.equalsIgnoreCase("phone"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(phone));
		if (FCode.equalsIgnoreCase("eMail"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(eMail));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("modifyOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyOperator));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
		if (FCode.equalsIgnoreCase("edorNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorNo));
		if (FCode.equalsIgnoreCase("edorType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorType));
		if (FCode.equalsIgnoreCase("edorCase"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorCase));
		if (FCode.equalsIgnoreCase("operator2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator2));
		if (FCode.equalsIgnoreCase("makeDate2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
		if (FCode.equalsIgnoreCase("makeTime2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime2));
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
			strFieldValue = StrTool.GBKToUnicode(userCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(userName);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(password);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPwdModifyDate()));
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(userDescription);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(userState);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(superPopedomFlag);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getValidStartDate()));
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getValidEndDate()));
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(stuffNo);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(officePhone);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(phone);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(eMail);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(edorNo);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(edorType);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(edorCase);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(operator2);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(makeTime2);
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
		if (FCode.equalsIgnoreCase("userCode"))
			if (FValue != null && !FValue.equals(""))
				userCode = FValue.trim();
			else
				userCode = null;
		if (FCode.equalsIgnoreCase("userName"))
			if (FValue != null && !FValue.equals(""))
				userName = FValue.trim();
			else
				userName = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("branchType"))
			if (FValue != null && !FValue.equals(""))
				branchType = FValue.trim();
			else
				branchType = null;
		if (FCode.equalsIgnoreCase("password"))
			if (FValue != null && !FValue.equals(""))
				password = FValue.trim();
			else
				password = null;
		if (FCode.equalsIgnoreCase("pwdModifyDate"))
			if (FValue != null && !FValue.equals(""))
				pwdModifyDate = fDate.getDate(FValue);
			else
				pwdModifyDate = null;
		if (FCode.equalsIgnoreCase("userDescription"))
			if (FValue != null && !FValue.equals(""))
				userDescription = FValue.trim();
			else
				userDescription = null;
		if (FCode.equalsIgnoreCase("userState"))
			if (FValue != null && !FValue.equals(""))
				userState = FValue.trim();
			else
				userState = null;
		if (FCode.equalsIgnoreCase("superPopedomFlag"))
			if (FValue != null && !FValue.equals(""))
				superPopedomFlag = FValue.trim();
			else
				superPopedomFlag = null;
		if (FCode.equalsIgnoreCase("validStartDate"))
			if (FValue != null && !FValue.equals(""))
				validStartDate = fDate.getDate(FValue);
			else
				validStartDate = null;
		if (FCode.equalsIgnoreCase("validEndDate"))
			if (FValue != null && !FValue.equals(""))
				validEndDate = fDate.getDate(FValue);
			else
				validEndDate = null;
		if (FCode.equalsIgnoreCase("stuffNo"))
			if (FValue != null && !FValue.equals(""))
				stuffNo = FValue.trim();
			else
				stuffNo = null;
		if (FCode.equalsIgnoreCase("officePhone"))
			if (FValue != null && !FValue.equals(""))
				officePhone = FValue.trim();
			else
				officePhone = null;
		if (FCode.equalsIgnoreCase("phone"))
			if (FValue != null && !FValue.equals(""))
				phone = FValue.trim();
			else
				phone = null;
		if (FCode.equalsIgnoreCase("eMail"))
			if (FValue != null && !FValue.equals(""))
				eMail = FValue.trim();
			else
				eMail = null;
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equalsIgnoreCase("modifyOperator"))
			if (FValue != null && !FValue.equals(""))
				modifyOperator = FValue.trim();
			else
				modifyOperator = null;
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
		if (FCode.equalsIgnoreCase("edorNo"))
			if (FValue != null && !FValue.equals(""))
				edorNo = FValue.trim();
			else
				edorNo = null;
		if (FCode.equalsIgnoreCase("edorType"))
			if (FValue != null && !FValue.equals(""))
				edorType = FValue.trim();
			else
				edorType = null;
		if (FCode.equalsIgnoreCase("edorCase"))
			if (FValue != null && !FValue.equals(""))
				edorCase = FValue.trim();
			else
				edorCase = null;
		if (FCode.equalsIgnoreCase("operator2"))
			if (FValue != null && !FValue.equals(""))
				operator2 = FValue.trim();
			else
				operator2 = null;
		if (FCode.equalsIgnoreCase("makeDate2"))
			if (FValue != null && !FValue.equals(""))
				makeDate2 = fDate.getDate(FValue);
			else
				makeDate2 = null;
		if (FCode.equalsIgnoreCase("makeTime2"))
			if (FValue != null && !FValue.equals(""))
				makeTime2 = FValue.trim();
			else
				makeTime2 = null;
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
		MUserBSchema other = (MUserBSchema)otherObject;
		if (userCode == null && other.getUserCode() != null)
			return false;
		if (userCode != null && !userCode.equals(other.getUserCode()))
			return false;
		if (userName == null && other.getUserName() != null)
			return false;
		if (userName != null && !userName.equals(other.getUserName()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (password == null && other.getPassword() != null)
			return false;
		if (password != null && !password.equals(other.getPassword()))
			return false;
		if (pwdModifyDate == null && other.getPwdModifyDate() != null)
			return false;
		if (pwdModifyDate != null && !fDate.getString(pwdModifyDate).equals(other.getPwdModifyDate()))
			return false;
		if (userDescription == null && other.getUserDescription() != null)
			return false;
		if (userDescription != null && !userDescription.equals(other.getUserDescription()))
			return false;
		if (userState == null && other.getUserState() != null)
			return false;
		if (userState != null && !userState.equals(other.getUserState()))
			return false;
		if (superPopedomFlag == null && other.getSuperPopedomFlag() != null)
			return false;
		if (superPopedomFlag != null && !superPopedomFlag.equals(other.getSuperPopedomFlag()))
			return false;
		if (validStartDate == null && other.getValidStartDate() != null)
			return false;
		if (validStartDate != null && !fDate.getString(validStartDate).equals(other.getValidStartDate()))
			return false;
		if (validEndDate == null && other.getValidEndDate() != null)
			return false;
		if (validEndDate != null && !fDate.getString(validEndDate).equals(other.getValidEndDate()))
			return false;
		if (stuffNo == null && other.getStuffNo() != null)
			return false;
		if (stuffNo != null && !stuffNo.equals(other.getStuffNo()))
			return false;
		if (officePhone == null && other.getOfficePhone() != null)
			return false;
		if (officePhone != null && !officePhone.equals(other.getOfficePhone()))
			return false;
		if (phone == null && other.getPhone() != null)
			return false;
		if (phone != null && !phone.equals(other.getPhone()))
			return false;
		if (eMail == null && other.getEMail() != null)
			return false;
		if (eMail != null && !eMail.equals(other.getEMail()))
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (modifyOperator == null && other.getModifyOperator() != null)
			return false;
		if (modifyOperator != null && !modifyOperator.equals(other.getModifyOperator()))
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
		if (edorNo == null && other.getEdorNo() != null)
			return false;
		if (edorNo != null && !edorNo.equals(other.getEdorNo()))
			return false;
		if (edorType == null && other.getEdorType() != null)
			return false;
		if (edorType != null && !edorType.equals(other.getEdorType()))
			return false;
		if (edorCase == null && other.getEdorCase() != null)
			return false;
		if (edorCase != null && !edorCase.equals(other.getEdorCase()))
			return false;
		if (operator2 == null && other.getOperator2() != null)
			return false;
		if (operator2 != null && !operator2.equals(other.getOperator2()))
			return false;
		if (makeDate2 == null && other.getMakeDate2() != null)
			return false;
		if (makeDate2 != null && !fDate.getString(makeDate2).equals(other.getMakeDate2()))
			return false;
		if (makeTime2 == null && other.getMakeTime2() != null)
			return false;
		return makeTime2 == null || makeTime2.equals(other.getMakeTime2());
	}

	public int getFieldCount()
	{
		return 27;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("userCode"))
			return 0;
		if (strFieldName.equals("userName"))
			return 1;
		if (strFieldName.equals("manageCom"))
			return 2;
		if (strFieldName.equals("branchType"))
			return 3;
		if (strFieldName.equals("password"))
			return 4;
		if (strFieldName.equals("pwdModifyDate"))
			return 5;
		if (strFieldName.equals("userDescription"))
			return 6;
		if (strFieldName.equals("userState"))
			return 7;
		if (strFieldName.equals("superPopedomFlag"))
			return 8;
		if (strFieldName.equals("validStartDate"))
			return 9;
		if (strFieldName.equals("validEndDate"))
			return 10;
		if (strFieldName.equals("stuffNo"))
			return 11;
		if (strFieldName.equals("officePhone"))
			return 12;
		if (strFieldName.equals("phone"))
			return 13;
		if (strFieldName.equals("eMail"))
			return 14;
		if (strFieldName.equals("operator"))
			return 15;
		if (strFieldName.equals("modifyOperator"))
			return 16;
		if (strFieldName.equals("makeDate"))
			return 17;
		if (strFieldName.equals("makeTime"))
			return 18;
		if (strFieldName.equals("modifyDate"))
			return 19;
		if (strFieldName.equals("modifyTime"))
			return 20;
		if (strFieldName.equals("edorNo"))
			return 21;
		if (strFieldName.equals("edorType"))
			return 22;
		if (strFieldName.equals("edorCase"))
			return 23;
		if (strFieldName.equals("operator2"))
			return 24;
		if (strFieldName.equals("makeDate2"))
			return 25;
		return !strFieldName.equals("makeTime2") ? -1 : 26;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "userCode";
			break;

		case 1: // '\001'
			strFieldName = "userName";
			break;

		case 2: // '\002'
			strFieldName = "manageCom";
			break;

		case 3: // '\003'
			strFieldName = "branchType";
			break;

		case 4: // '\004'
			strFieldName = "password";
			break;

		case 5: // '\005'
			strFieldName = "pwdModifyDate";
			break;

		case 6: // '\006'
			strFieldName = "userDescription";
			break;

		case 7: // '\007'
			strFieldName = "userState";
			break;

		case 8: // '\b'
			strFieldName = "superPopedomFlag";
			break;

		case 9: // '\t'
			strFieldName = "validStartDate";
			break;

		case 10: // '\n'
			strFieldName = "validEndDate";
			break;

		case 11: // '\013'
			strFieldName = "stuffNo";
			break;

		case 12: // '\f'
			strFieldName = "officePhone";
			break;

		case 13: // '\r'
			strFieldName = "phone";
			break;

		case 14: // '\016'
			strFieldName = "eMail";
			break;

		case 15: // '\017'
			strFieldName = "operator";
			break;

		case 16: // '\020'
			strFieldName = "modifyOperator";
			break;

		case 17: // '\021'
			strFieldName = "makeDate";
			break;

		case 18: // '\022'
			strFieldName = "makeTime";
			break;

		case 19: // '\023'
			strFieldName = "modifyDate";
			break;

		case 20: // '\024'
			strFieldName = "modifyTime";
			break;

		case 21: // '\025'
			strFieldName = "edorNo";
			break;

		case 22: // '\026'
			strFieldName = "edorType";
			break;

		case 23: // '\027'
			strFieldName = "edorCase";
			break;

		case 24: // '\030'
			strFieldName = "operator2";
			break;

		case 25: // '\031'
			strFieldName = "makeDate2";
			break;

		case 26: // '\032'
			strFieldName = "makeTime2";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("userCode"))
			return 0;
		if (strFieldName.equals("userName"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("password"))
			return 0;
		if (strFieldName.equals("pwdModifyDate"))
			return 1;
		if (strFieldName.equals("userDescription"))
			return 0;
		if (strFieldName.equals("userState"))
			return 0;
		if (strFieldName.equals("superPopedomFlag"))
			return 0;
		if (strFieldName.equals("validStartDate"))
			return 1;
		if (strFieldName.equals("validEndDate"))
			return 1;
		if (strFieldName.equals("stuffNo"))
			return 0;
		if (strFieldName.equals("officePhone"))
			return 0;
		if (strFieldName.equals("phone"))
			return 0;
		if (strFieldName.equals("eMail"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("modifyOperator"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		if (strFieldName.equals("modifyTime"))
			return 0;
		if (strFieldName.equals("edorNo"))
			return 0;
		if (strFieldName.equals("edorType"))
			return 0;
		if (strFieldName.equals("edorCase"))
			return 0;
		if (strFieldName.equals("operator2"))
			return 0;
		if (strFieldName.equals("makeDate2"))
			return 1;
		return !strFieldName.equals("makeTime2") ? -1 : 0;
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
			nFieldType = 1;
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
			nFieldType = 1;
			break;

		case 10: // '\n'
			nFieldType = 1;
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
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
