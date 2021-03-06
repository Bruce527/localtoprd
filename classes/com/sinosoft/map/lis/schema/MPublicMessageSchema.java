// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MPublicMessageSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MPublicMessageDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MPublicMessageSchema
	implements Schema, Cloneable
{

	private String iD;
	private String manageCom;
	private String receiveBranch;
	private String branchType;
	private String message;
	private String type;
	private String author;
	private String state;
	private Date startDate;
	private Date endDate;
	private String startTime;
	private String endTime;
	private String vF01;
	private String nF01;
	private int iF01;
	private double dF02;
	private Date date01;
	private String operator;
	private String modifyOperator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String checkState;
	private String checkOperator;
	private String checkReason;
	private Date checkDate;
	private String checkTime;
	public static final int FIELDNUM = 28;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MPublicMessageSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MPublicMessageSchema cloned = (MPublicMessageSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getID()
	{
		return iD;
	}

	public void setID(String aID)
	{
		iD = aID;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getReceiveBranch()
	{
		return receiveBranch;
	}

	public void setReceiveBranch(String aReceiveBranch)
	{
		receiveBranch = aReceiveBranch;
	}

	public String getBranchType()
	{
		return branchType;
	}

	public void setBranchType(String aBranchType)
	{
		branchType = aBranchType;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String aMessage)
	{
		message = aMessage;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String aAuthor)
	{
		author = aAuthor;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getStartDate()
	{
		if (startDate != null)
			return fDate.getString(startDate);
		else
			return null;
	}

	public void setStartDate(Date aStartDate)
	{
		startDate = aStartDate;
	}

	public void setStartDate(String aStartDate)
	{
		if (aStartDate != null && !aStartDate.equals(""))
			startDate = fDate.getDate(aStartDate);
		else
			startDate = null;
	}

	public String getEndDate()
	{
		if (endDate != null)
			return fDate.getString(endDate);
		else
			return null;
	}

	public void setEndDate(Date aEndDate)
	{
		endDate = aEndDate;
	}

	public void setEndDate(String aEndDate)
	{
		if (aEndDate != null && !aEndDate.equals(""))
			endDate = fDate.getDate(aEndDate);
		else
			endDate = null;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String aStartTime)
	{
		startTime = aStartTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String aEndTime)
	{
		endTime = aEndTime;
	}

	public String getVF01()
	{
		return vF01;
	}

	public void setVF01(String aVF01)
	{
		vF01 = aVF01;
	}

	public String getNF01()
	{
		return nF01;
	}

	public void setNF01(String aNF01)
	{
		nF01 = aNF01;
	}

	public int getIF01()
	{
		return iF01;
	}

	public void setIF01(int aIF01)
	{
		iF01 = aIF01;
	}

	public void setIF01(String aIF01)
	{
		if (aIF01 != null && !aIF01.equals(""))
		{
			Integer tInteger = new Integer(aIF01);
			int i = tInteger.intValue();
			iF01 = i;
		}
	}

	public double getDF02()
	{
		return dF02;
	}

	public void setDF02(double aDF02)
	{
		dF02 = aDF02;
	}

	public void setDF02(String aDF02)
	{
		if (aDF02 != null && !aDF02.equals(""))
		{
			Double tDouble = new Double(aDF02);
			double d = tDouble.doubleValue();
			dF02 = d;
		}
	}

	public String getDate01()
	{
		if (date01 != null)
			return fDate.getString(date01);
		else
			return null;
	}

	public void setDate01(Date aDate01)
	{
		date01 = aDate01;
	}

	public void setDate01(String aDate01)
	{
		if (aDate01 != null && !aDate01.equals(""))
			date01 = fDate.getDate(aDate01);
		else
			date01 = null;
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

	public String getCheckState()
	{
		return checkState;
	}

	public void setCheckState(String aCheckState)
	{
		checkState = aCheckState;
	}

	public String getCheckOperator()
	{
		return checkOperator;
	}

	public void setCheckOperator(String aCheckOperator)
	{
		checkOperator = aCheckOperator;
	}

	public String getCheckReason()
	{
		return checkReason;
	}

	public void setCheckReason(String aCheckReason)
	{
		checkReason = aCheckReason;
	}

	public String getCheckDate()
	{
		if (checkDate != null)
			return fDate.getString(checkDate);
		else
			return null;
	}

	public void setCheckDate(Date aCheckDate)
	{
		checkDate = aCheckDate;
	}

	public void setCheckDate(String aCheckDate)
	{
		if (aCheckDate != null && !aCheckDate.equals(""))
			checkDate = fDate.getDate(aCheckDate);
		else
			checkDate = null;
	}

	public String getCheckTime()
	{
		return checkTime;
	}

	public void setCheckTime(String aCheckTime)
	{
		checkTime = aCheckTime;
	}

	public void setSchema(MPublicMessageSchema aMPublicMessageSchema)
	{
		iD = aMPublicMessageSchema.getID();
		manageCom = aMPublicMessageSchema.getManageCom();
		receiveBranch = aMPublicMessageSchema.getReceiveBranch();
		branchType = aMPublicMessageSchema.getBranchType();
		message = aMPublicMessageSchema.getMessage();
		type = aMPublicMessageSchema.getType();
		author = aMPublicMessageSchema.getAuthor();
		state = aMPublicMessageSchema.getState();
		startDate = fDate.getDate(aMPublicMessageSchema.getStartDate());
		endDate = fDate.getDate(aMPublicMessageSchema.getEndDate());
		startTime = aMPublicMessageSchema.getStartTime();
		endTime = aMPublicMessageSchema.getEndTime();
		vF01 = aMPublicMessageSchema.getVF01();
		nF01 = aMPublicMessageSchema.getNF01();
		iF01 = aMPublicMessageSchema.getIF01();
		dF02 = aMPublicMessageSchema.getDF02();
		date01 = fDate.getDate(aMPublicMessageSchema.getDate01());
		operator = aMPublicMessageSchema.getOperator();
		modifyOperator = aMPublicMessageSchema.getModifyOperator();
		makeDate = fDate.getDate(aMPublicMessageSchema.getMakeDate());
		makeTime = aMPublicMessageSchema.getMakeTime();
		modifyDate = fDate.getDate(aMPublicMessageSchema.getModifyDate());
		modifyTime = aMPublicMessageSchema.getModifyTime();
		checkState = aMPublicMessageSchema.getCheckState();
		checkOperator = aMPublicMessageSchema.getCheckOperator();
		checkReason = aMPublicMessageSchema.getCheckReason();
		checkDate = fDate.getDate(aMPublicMessageSchema.getCheckDate());
		checkTime = aMPublicMessageSchema.getCheckTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ID") == null)
				iD = null;
			else
				iD = rs.getString("ID").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("ReceiveBranch") == null)
				receiveBranch = null;
			else
				receiveBranch = rs.getString("ReceiveBranch").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			if (rs.getString("Message") == null)
				message = null;
			else
				message = rs.getString("Message").trim();
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
			if (rs.getString("Author") == null)
				author = null;
			else
				author = rs.getString("Author").trim();
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			startDate = rs.getDate("StartDate");
			endDate = rs.getDate("EndDate");
			if (rs.getString("StartTime") == null)
				startTime = null;
			else
				startTime = rs.getString("StartTime").trim();
			if (rs.getString("EndTime") == null)
				endTime = null;
			else
				endTime = rs.getString("EndTime").trim();
			if (rs.getString("VF01") == null)
				vF01 = null;
			else
				vF01 = rs.getString("VF01").trim();
			if (rs.getString("NF01") == null)
				nF01 = null;
			else
				nF01 = rs.getString("NF01").trim();
			iF01 = rs.getInt("IF01");
			dF02 = rs.getDouble("DF02");
			date01 = rs.getDate("Date01");
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
			if (rs.getString("CheckState") == null)
				checkState = null;
			else
				checkState = rs.getString("CheckState").trim();
			if (rs.getString("CheckOperator") == null)
				checkOperator = null;
			else
				checkOperator = rs.getString("CheckOperator").trim();
			if (rs.getString("CheckReason") == null)
				checkReason = null;
			else
				checkReason = rs.getString("CheckReason").trim();
			checkDate = rs.getDate("CheckDate");
			if (rs.getString("CheckTime") == null)
				checkTime = null;
			else
				checkTime = rs.getString("CheckTime").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MPublicMessage表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MPublicMessageSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MPublicMessageSchema getSchema()
	{
		MPublicMessageSchema aMPublicMessageSchema = new MPublicMessageSchema();
		aMPublicMessageSchema.setSchema(this);
		return aMPublicMessageSchema;
	}

	public MPublicMessageDB getDB()
	{
		MPublicMessageDB aDBOper = new MPublicMessageDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(iD));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(receiveBranch));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(message));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(type));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(author));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(endDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(startTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(endTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vF01));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nF01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iF01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(dF02));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(date01)));
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
		strReturn.append(StrTool.cTrim(checkState));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkOperator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkReason));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(checkDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkTime));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			receiveBranch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			message = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			author = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			startTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			endTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			checkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
			checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MPublicMessageSchema";
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
		if (FCode.equalsIgnoreCase("iD"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iD));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("receiveBranch"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(receiveBranch));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("message"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(message));
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
		if (FCode.equalsIgnoreCase("author"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(author));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("endDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
		if (FCode.equalsIgnoreCase("startTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(startTime));
		if (FCode.equalsIgnoreCase("endTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(endTime));
		if (FCode.equalsIgnoreCase("vF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vF01));
		if (FCode.equalsIgnoreCase("nF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF01));
		if (FCode.equalsIgnoreCase("iF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iF01));
		if (FCode.equalsIgnoreCase("dF02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dF02));
		if (FCode.equalsIgnoreCase("date01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
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
		if (FCode.equalsIgnoreCase("checkState"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkState));
		if (FCode.equalsIgnoreCase("checkOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkOperator));
		if (FCode.equalsIgnoreCase("checkReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkReason));
		if (FCode.equalsIgnoreCase("checkDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
		if (FCode.equalsIgnoreCase("checkTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkTime));
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
			strFieldValue = StrTool.GBKToUnicode(iD);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(receiveBranch);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(message);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(author);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(startTime);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(endTime);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(vF01);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(nF01);
			break;

		case 14: // '\016'
			strFieldValue = String.valueOf(iF01);
			break;

		case 15: // '\017'
			strFieldValue = String.valueOf(dF02);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(checkState);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(checkOperator);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(checkReason);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(checkTime);
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
		if (FCode.equalsIgnoreCase("iD"))
			if (FValue != null && !FValue.equals(""))
				iD = FValue.trim();
			else
				iD = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("receiveBranch"))
			if (FValue != null && !FValue.equals(""))
				receiveBranch = FValue.trim();
			else
				receiveBranch = null;
		if (FCode.equalsIgnoreCase("branchType"))
			if (FValue != null && !FValue.equals(""))
				branchType = FValue.trim();
			else
				branchType = null;
		if (FCode.equalsIgnoreCase("message"))
			if (FValue != null && !FValue.equals(""))
				message = FValue.trim();
			else
				message = null;
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
		if (FCode.equalsIgnoreCase("author"))
			if (FValue != null && !FValue.equals(""))
				author = FValue.trim();
			else
				author = null;
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("startDate"))
			if (FValue != null && !FValue.equals(""))
				startDate = fDate.getDate(FValue);
			else
				startDate = null;
		if (FCode.equalsIgnoreCase("endDate"))
			if (FValue != null && !FValue.equals(""))
				endDate = fDate.getDate(FValue);
			else
				endDate = null;
		if (FCode.equalsIgnoreCase("startTime"))
			if (FValue != null && !FValue.equals(""))
				startTime = FValue.trim();
			else
				startTime = null;
		if (FCode.equalsIgnoreCase("endTime"))
			if (FValue != null && !FValue.equals(""))
				endTime = FValue.trim();
			else
				endTime = null;
		if (FCode.equalsIgnoreCase("vF01"))
			if (FValue != null && !FValue.equals(""))
				vF01 = FValue.trim();
			else
				vF01 = null;
		if (FCode.equalsIgnoreCase("nF01"))
			if (FValue != null && !FValue.equals(""))
				nF01 = FValue.trim();
			else
				nF01 = null;
		if (FCode.equalsIgnoreCase("iF01") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iF01 = i;
		}
		if (FCode.equalsIgnoreCase("dF02") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			dF02 = d;
		}
		if (FCode.equalsIgnoreCase("date01"))
			if (FValue != null && !FValue.equals(""))
				date01 = fDate.getDate(FValue);
			else
				date01 = null;
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
		if (FCode.equalsIgnoreCase("checkState"))
			if (FValue != null && !FValue.equals(""))
				checkState = FValue.trim();
			else
				checkState = null;
		if (FCode.equalsIgnoreCase("checkOperator"))
			if (FValue != null && !FValue.equals(""))
				checkOperator = FValue.trim();
			else
				checkOperator = null;
		if (FCode.equalsIgnoreCase("checkReason"))
			if (FValue != null && !FValue.equals(""))
				checkReason = FValue.trim();
			else
				checkReason = null;
		if (FCode.equalsIgnoreCase("checkDate"))
			if (FValue != null && !FValue.equals(""))
				checkDate = fDate.getDate(FValue);
			else
				checkDate = null;
		if (FCode.equalsIgnoreCase("checkTime"))
			if (FValue != null && !FValue.equals(""))
				checkTime = FValue.trim();
			else
				checkTime = null;
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
		MPublicMessageSchema other = (MPublicMessageSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (receiveBranch == null && other.getReceiveBranch() != null)
			return false;
		if (receiveBranch != null && !receiveBranch.equals(other.getReceiveBranch()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (message == null && other.getMessage() != null)
			return false;
		if (message != null && !message.equals(other.getMessage()))
			return false;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
			return false;
		if (author == null && other.getAuthor() != null)
			return false;
		if (author != null && !author.equals(other.getAuthor()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (endDate == null && other.getEndDate() != null)
			return false;
		if (endDate != null && !fDate.getString(endDate).equals(other.getEndDate()))
			return false;
		if (startTime == null && other.getStartTime() != null)
			return false;
		if (startTime != null && !startTime.equals(other.getStartTime()))
			return false;
		if (endTime == null && other.getEndTime() != null)
			return false;
		if (endTime != null && !endTime.equals(other.getEndTime()))
			return false;
		if (vF01 == null && other.getVF01() != null)
			return false;
		if (vF01 != null && !vF01.equals(other.getVF01()))
			return false;
		if (nF01 == null && other.getNF01() != null)
			return false;
		if (nF01 != null && !nF01.equals(other.getNF01()))
			return false;
		if (iF01 != other.getIF01())
			return false;
		if (Double.doubleToLongBits(dF02) != Double.doubleToLongBits(other.getDF02()))
			return false;
		if (date01 == null && other.getDate01() != null)
			return false;
		if (date01 != null && !fDate.getString(date01).equals(other.getDate01()))
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
		if (checkState == null && other.getCheckState() != null)
			return false;
		if (checkState != null && !checkState.equals(other.getCheckState()))
			return false;
		if (checkOperator == null && other.getCheckOperator() != null)
			return false;
		if (checkOperator != null && !checkOperator.equals(other.getCheckOperator()))
			return false;
		if (checkReason == null && other.getCheckReason() != null)
			return false;
		if (checkReason != null && !checkReason.equals(other.getCheckReason()))
			return false;
		if (checkDate == null && other.getCheckDate() != null)
			return false;
		if (checkDate != null && !fDate.getString(checkDate).equals(other.getCheckDate()))
			return false;
		if (checkTime == null && other.getCheckTime() != null)
			return false;
		return checkTime == null || checkTime.equals(other.getCheckTime());
	}

	public int getFieldCount()
	{
		return 28;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 1;
		if (strFieldName.equals("receiveBranch"))
			return 2;
		if (strFieldName.equals("branchType"))
			return 3;
		if (strFieldName.equals("message"))
			return 4;
		if (strFieldName.equals("type"))
			return 5;
		if (strFieldName.equals("author"))
			return 6;
		if (strFieldName.equals("state"))
			return 7;
		if (strFieldName.equals("startDate"))
			return 8;
		if (strFieldName.equals("endDate"))
			return 9;
		if (strFieldName.equals("startTime"))
			return 10;
		if (strFieldName.equals("endTime"))
			return 11;
		if (strFieldName.equals("vF01"))
			return 12;
		if (strFieldName.equals("nF01"))
			return 13;
		if (strFieldName.equals("iF01"))
			return 14;
		if (strFieldName.equals("dF02"))
			return 15;
		if (strFieldName.equals("date01"))
			return 16;
		if (strFieldName.equals("operator"))
			return 17;
		if (strFieldName.equals("modifyOperator"))
			return 18;
		if (strFieldName.equals("makeDate"))
			return 19;
		if (strFieldName.equals("makeTime"))
			return 20;
		if (strFieldName.equals("modifyDate"))
			return 21;
		if (strFieldName.equals("modifyTime"))
			return 22;
		if (strFieldName.equals("checkState"))
			return 23;
		if (strFieldName.equals("checkOperator"))
			return 24;
		if (strFieldName.equals("checkReason"))
			return 25;
		if (strFieldName.equals("checkDate"))
			return 26;
		return !strFieldName.equals("checkTime") ? -1 : 27;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "iD";
			break;

		case 1: // '\001'
			strFieldName = "manageCom";
			break;

		case 2: // '\002'
			strFieldName = "receiveBranch";
			break;

		case 3: // '\003'
			strFieldName = "branchType";
			break;

		case 4: // '\004'
			strFieldName = "message";
			break;

		case 5: // '\005'
			strFieldName = "type";
			break;

		case 6: // '\006'
			strFieldName = "author";
			break;

		case 7: // '\007'
			strFieldName = "state";
			break;

		case 8: // '\b'
			strFieldName = "startDate";
			break;

		case 9: // '\t'
			strFieldName = "endDate";
			break;

		case 10: // '\n'
			strFieldName = "startTime";
			break;

		case 11: // '\013'
			strFieldName = "endTime";
			break;

		case 12: // '\f'
			strFieldName = "vF01";
			break;

		case 13: // '\r'
			strFieldName = "nF01";
			break;

		case 14: // '\016'
			strFieldName = "iF01";
			break;

		case 15: // '\017'
			strFieldName = "dF02";
			break;

		case 16: // '\020'
			strFieldName = "date01";
			break;

		case 17: // '\021'
			strFieldName = "operator";
			break;

		case 18: // '\022'
			strFieldName = "modifyOperator";
			break;

		case 19: // '\023'
			strFieldName = "makeDate";
			break;

		case 20: // '\024'
			strFieldName = "makeTime";
			break;

		case 21: // '\025'
			strFieldName = "modifyDate";
			break;

		case 22: // '\026'
			strFieldName = "modifyTime";
			break;

		case 23: // '\027'
			strFieldName = "checkState";
			break;

		case 24: // '\030'
			strFieldName = "checkOperator";
			break;

		case 25: // '\031'
			strFieldName = "checkReason";
			break;

		case 26: // '\032'
			strFieldName = "checkDate";
			break;

		case 27: // '\033'
			strFieldName = "checkTime";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("receiveBranch"))
			return 0;
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("message"))
			return 0;
		if (strFieldName.equals("type"))
			return 0;
		if (strFieldName.equals("author"))
			return 0;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("endDate"))
			return 1;
		if (strFieldName.equals("startTime"))
			return 0;
		if (strFieldName.equals("endTime"))
			return 0;
		if (strFieldName.equals("vF01"))
			return 0;
		if (strFieldName.equals("nF01"))
			return 0;
		if (strFieldName.equals("iF01"))
			return 3;
		if (strFieldName.equals("dF02"))
			return 4;
		if (strFieldName.equals("date01"))
			return 1;
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
		if (strFieldName.equals("checkState"))
			return 0;
		if (strFieldName.equals("checkOperator"))
			return 0;
		if (strFieldName.equals("checkReason"))
			return 0;
		if (strFieldName.equals("checkDate"))
			return 1;
		return !strFieldName.equals("checkTime") ? -1 : 0;
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
			nFieldType = 1;
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
			nFieldType = 3;
			break;

		case 15: // '\017'
			nFieldType = 4;
			break;

		case 16: // '\020'
			nFieldType = 1;
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
			nFieldType = 1;
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
			nFieldType = 1;
			break;

		case 27: // '\033'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
