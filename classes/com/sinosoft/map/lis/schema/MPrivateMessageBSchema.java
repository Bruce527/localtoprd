// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MPrivateMessageBSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MPrivateMessageBDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MPrivateMessageBSchema
	implements Schema, Cloneable
{

	private String iD;
	private String agentCode;
	private String manageCom;
	private String branchType;
	private String message;
	private String messageType;
	private String keyData;
	private String keyData2;
	private String keyData3;
	private String keyData4;
	private String uRL;
	private String type;
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
	private Date makeDate;
	private String makeTime;
	private String edorNo;
	private String edorType;
	private String edorCase;
	private String operator2;
	private Date makeDate2;
	private String makeTime2;
	public static final int FIELDNUM = 31;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MPrivateMessageBSchema()
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
		MPrivateMessageBSchema cloned = (MPrivateMessageBSchema)super.clone();
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

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
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

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String aMessage)
	{
		message = aMessage;
	}

	public String getMessageType()
	{
		return messageType;
	}

	public void setMessageType(String aMessageType)
	{
		messageType = aMessageType;
	}

	public String getKeyData()
	{
		return keyData;
	}

	public void setKeyData(String aKeyData)
	{
		keyData = aKeyData;
	}

	public String getKeyData2()
	{
		return keyData2;
	}

	public void setKeyData2(String aKeyData2)
	{
		keyData2 = aKeyData2;
	}

	public String getKeyData3()
	{
		return keyData3;
	}

	public void setKeyData3(String aKeyData3)
	{
		keyData3 = aKeyData3;
	}

	public String getKeyData4()
	{
		return keyData4;
	}

	public void setKeyData4(String aKeyData4)
	{
		keyData4 = aKeyData4;
	}

	public String getURL()
	{
		return uRL;
	}

	public void setURL(String aURL)
	{
		uRL = aURL;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
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

	public void setSchema(MPrivateMessageBSchema aMPrivateMessageBSchema)
	{
		iD = aMPrivateMessageBSchema.getID();
		agentCode = aMPrivateMessageBSchema.getAgentCode();
		manageCom = aMPrivateMessageBSchema.getManageCom();
		branchType = aMPrivateMessageBSchema.getBranchType();
		message = aMPrivateMessageBSchema.getMessage();
		messageType = aMPrivateMessageBSchema.getMessageType();
		keyData = aMPrivateMessageBSchema.getKeyData();
		keyData2 = aMPrivateMessageBSchema.getKeyData2();
		keyData3 = aMPrivateMessageBSchema.getKeyData3();
		keyData4 = aMPrivateMessageBSchema.getKeyData4();
		uRL = aMPrivateMessageBSchema.getURL();
		type = aMPrivateMessageBSchema.getType();
		state = aMPrivateMessageBSchema.getState();
		startDate = fDate.getDate(aMPrivateMessageBSchema.getStartDate());
		endDate = fDate.getDate(aMPrivateMessageBSchema.getEndDate());
		startTime = aMPrivateMessageBSchema.getStartTime();
		endTime = aMPrivateMessageBSchema.getEndTime();
		vF01 = aMPrivateMessageBSchema.getVF01();
		nF01 = aMPrivateMessageBSchema.getNF01();
		iF01 = aMPrivateMessageBSchema.getIF01();
		dF02 = aMPrivateMessageBSchema.getDF02();
		date01 = fDate.getDate(aMPrivateMessageBSchema.getDate01());
		operator = aMPrivateMessageBSchema.getOperator();
		makeDate = fDate.getDate(aMPrivateMessageBSchema.getMakeDate());
		makeTime = aMPrivateMessageBSchema.getMakeTime();
		edorNo = aMPrivateMessageBSchema.getEdorNo();
		edorType = aMPrivateMessageBSchema.getEdorType();
		edorCase = aMPrivateMessageBSchema.getEdorCase();
		operator2 = aMPrivateMessageBSchema.getOperator2();
		makeDate2 = fDate.getDate(aMPrivateMessageBSchema.getMakeDate2());
		makeTime2 = aMPrivateMessageBSchema.getMakeTime2();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ID") == null)
				iD = null;
			else
				iD = rs.getString("ID").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			if (rs.getString("Message") == null)
				message = null;
			else
				message = rs.getString("Message").trim();
			if (rs.getString("MessageType") == null)
				messageType = null;
			else
				messageType = rs.getString("MessageType").trim();
			if (rs.getString("KeyData") == null)
				keyData = null;
			else
				keyData = rs.getString("KeyData").trim();
			if (rs.getString("KeyData2") == null)
				keyData2 = null;
			else
				keyData2 = rs.getString("KeyData2").trim();
			if (rs.getString("KeyData3") == null)
				keyData3 = null;
			else
				keyData3 = rs.getString("KeyData3").trim();
			if (rs.getString("KeyData4") == null)
				keyData4 = null;
			else
				keyData4 = rs.getString("KeyData4").trim();
			if (rs.getString("URL") == null)
				uRL = null;
			else
				uRL = rs.getString("URL").trim();
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
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
			makeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("MakeTime").trim();
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
			System.out.println("数据库中的MPrivateMessageB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MPrivateMessageBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MPrivateMessageBSchema getSchema()
	{
		MPrivateMessageBSchema aMPrivateMessageBSchema = new MPrivateMessageBSchema();
		aMPrivateMessageBSchema.setSchema(this);
		return aMPrivateMessageBSchema;
	}

	public MPrivateMessageBDB getDB()
	{
		MPrivateMessageBDB aDBOper = new MPrivateMessageBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(iD));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(message));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(messageType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(keyData));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(keyData2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(keyData3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(keyData4));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uRL));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(type));
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
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
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
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			message = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			messageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			keyData = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			keyData2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			keyData3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			keyData4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			uRL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			startTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			endTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			makeDate2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
			makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MPrivateMessageBSchema";
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
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("message"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(message));
		if (FCode.equalsIgnoreCase("messageType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(messageType));
		if (FCode.equalsIgnoreCase("keyData"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(keyData));
		if (FCode.equalsIgnoreCase("keyData2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(keyData2));
		if (FCode.equalsIgnoreCase("keyData3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(keyData3));
		if (FCode.equalsIgnoreCase("keyData4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(keyData4));
		if (FCode.equalsIgnoreCase("uRL"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uRL));
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
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
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
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
			strFieldValue = StrTool.GBKToUnicode(iD);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(message);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(messageType);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(keyData);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(keyData2);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(keyData3);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(keyData4);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(uRL);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(startTime);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(endTime);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(vF01);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(nF01);
			break;

		case 19: // '\023'
			strFieldValue = String.valueOf(iF01);
			break;

		case 20: // '\024'
			strFieldValue = String.valueOf(dF02);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(edorNo);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(edorType);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(edorCase);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(operator2);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
			break;

		case 30: // '\036'
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
		if (FCode.equalsIgnoreCase("iD"))
			if (FValue != null && !FValue.equals(""))
				iD = FValue.trim();
			else
				iD = null;
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
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
		if (FCode.equalsIgnoreCase("message"))
			if (FValue != null && !FValue.equals(""))
				message = FValue.trim();
			else
				message = null;
		if (FCode.equalsIgnoreCase("messageType"))
			if (FValue != null && !FValue.equals(""))
				messageType = FValue.trim();
			else
				messageType = null;
		if (FCode.equalsIgnoreCase("keyData"))
			if (FValue != null && !FValue.equals(""))
				keyData = FValue.trim();
			else
				keyData = null;
		if (FCode.equalsIgnoreCase("keyData2"))
			if (FValue != null && !FValue.equals(""))
				keyData2 = FValue.trim();
			else
				keyData2 = null;
		if (FCode.equalsIgnoreCase("keyData3"))
			if (FValue != null && !FValue.equals(""))
				keyData3 = FValue.trim();
			else
				keyData3 = null;
		if (FCode.equalsIgnoreCase("keyData4"))
			if (FValue != null && !FValue.equals(""))
				keyData4 = FValue.trim();
			else
				keyData4 = null;
		if (FCode.equalsIgnoreCase("uRL"))
			if (FValue != null && !FValue.equals(""))
				uRL = FValue.trim();
			else
				uRL = null;
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
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
		MPrivateMessageBSchema other = (MPrivateMessageBSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (message == null && other.getMessage() != null)
			return false;
		if (message != null && !message.equals(other.getMessage()))
			return false;
		if (messageType == null && other.getMessageType() != null)
			return false;
		if (messageType != null && !messageType.equals(other.getMessageType()))
			return false;
		if (keyData == null && other.getKeyData() != null)
			return false;
		if (keyData != null && !keyData.equals(other.getKeyData()))
			return false;
		if (keyData2 == null && other.getKeyData2() != null)
			return false;
		if (keyData2 != null && !keyData2.equals(other.getKeyData2()))
			return false;
		if (keyData3 == null && other.getKeyData3() != null)
			return false;
		if (keyData3 != null && !keyData3.equals(other.getKeyData3()))
			return false;
		if (keyData4 == null && other.getKeyData4() != null)
			return false;
		if (keyData4 != null && !keyData4.equals(other.getKeyData4()))
			return false;
		if (uRL == null && other.getURL() != null)
			return false;
		if (uRL != null && !uRL.equals(other.getURL()))
			return false;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
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
		if (makeDate == null && other.getMakeDate() != null)
			return false;
		if (makeDate != null && !fDate.getString(makeDate).equals(other.getMakeDate()))
			return false;
		if (makeTime == null && other.getMakeTime() != null)
			return false;
		if (makeTime != null && !makeTime.equals(other.getMakeTime()))
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
		return 31;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 1;
		if (strFieldName.equals("manageCom"))
			return 2;
		if (strFieldName.equals("branchType"))
			return 3;
		if (strFieldName.equals("message"))
			return 4;
		if (strFieldName.equals("messageType"))
			return 5;
		if (strFieldName.equals("keyData"))
			return 6;
		if (strFieldName.equals("keyData2"))
			return 7;
		if (strFieldName.equals("keyData3"))
			return 8;
		if (strFieldName.equals("keyData4"))
			return 9;
		if (strFieldName.equals("uRL"))
			return 10;
		if (strFieldName.equals("type"))
			return 11;
		if (strFieldName.equals("state"))
			return 12;
		if (strFieldName.equals("startDate"))
			return 13;
		if (strFieldName.equals("endDate"))
			return 14;
		if (strFieldName.equals("startTime"))
			return 15;
		if (strFieldName.equals("endTime"))
			return 16;
		if (strFieldName.equals("vF01"))
			return 17;
		if (strFieldName.equals("nF01"))
			return 18;
		if (strFieldName.equals("iF01"))
			return 19;
		if (strFieldName.equals("dF02"))
			return 20;
		if (strFieldName.equals("date01"))
			return 21;
		if (strFieldName.equals("operator"))
			return 22;
		if (strFieldName.equals("makeDate"))
			return 23;
		if (strFieldName.equals("makeTime"))
			return 24;
		if (strFieldName.equals("edorNo"))
			return 25;
		if (strFieldName.equals("edorType"))
			return 26;
		if (strFieldName.equals("edorCase"))
			return 27;
		if (strFieldName.equals("operator2"))
			return 28;
		if (strFieldName.equals("makeDate2"))
			return 29;
		return !strFieldName.equals("makeTime2") ? -1 : 30;
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
			strFieldName = "agentCode";
			break;

		case 2: // '\002'
			strFieldName = "manageCom";
			break;

		case 3: // '\003'
			strFieldName = "branchType";
			break;

		case 4: // '\004'
			strFieldName = "message";
			break;

		case 5: // '\005'
			strFieldName = "messageType";
			break;

		case 6: // '\006'
			strFieldName = "keyData";
			break;

		case 7: // '\007'
			strFieldName = "keyData2";
			break;

		case 8: // '\b'
			strFieldName = "keyData3";
			break;

		case 9: // '\t'
			strFieldName = "keyData4";
			break;

		case 10: // '\n'
			strFieldName = "uRL";
			break;

		case 11: // '\013'
			strFieldName = "type";
			break;

		case 12: // '\f'
			strFieldName = "state";
			break;

		case 13: // '\r'
			strFieldName = "startDate";
			break;

		case 14: // '\016'
			strFieldName = "endDate";
			break;

		case 15: // '\017'
			strFieldName = "startTime";
			break;

		case 16: // '\020'
			strFieldName = "endTime";
			break;

		case 17: // '\021'
			strFieldName = "vF01";
			break;

		case 18: // '\022'
			strFieldName = "nF01";
			break;

		case 19: // '\023'
			strFieldName = "iF01";
			break;

		case 20: // '\024'
			strFieldName = "dF02";
			break;

		case 21: // '\025'
			strFieldName = "date01";
			break;

		case 22: // '\026'
			strFieldName = "operator";
			break;

		case 23: // '\027'
			strFieldName = "makeDate";
			break;

		case 24: // '\030'
			strFieldName = "makeTime";
			break;

		case 25: // '\031'
			strFieldName = "edorNo";
			break;

		case 26: // '\032'
			strFieldName = "edorType";
			break;

		case 27: // '\033'
			strFieldName = "edorCase";
			break;

		case 28: // '\034'
			strFieldName = "operator2";
			break;

		case 29: // '\035'
			strFieldName = "makeDate2";
			break;

		case 30: // '\036'
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
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("message"))
			return 0;
		if (strFieldName.equals("messageType"))
			return 0;
		if (strFieldName.equals("keyData"))
			return 0;
		if (strFieldName.equals("keyData2"))
			return 0;
		if (strFieldName.equals("keyData3"))
			return 0;
		if (strFieldName.equals("keyData4"))
			return 0;
		if (strFieldName.equals("uRL"))
			return 0;
		if (strFieldName.equals("type"))
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
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
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
			nFieldType = 1;
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
			nFieldType = 3;
			break;

		case 20: // '\024'
			nFieldType = 4;
			break;

		case 21: // '\025'
			nFieldType = 1;
			break;

		case 22: // '\026'
			nFieldType = 0;
			break;

		case 23: // '\027'
			nFieldType = 1;
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
			nFieldType = 1;
			break;

		case 30: // '\036'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
