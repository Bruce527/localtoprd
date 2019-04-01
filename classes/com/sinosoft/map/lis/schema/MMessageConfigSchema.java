// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMessageConfigSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MMessageConfigDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MMessageConfigSchema
	implements Schema, Cloneable
{

	private String iD;
	private String manageCom;
	private String branchType;
	private String messageType;
	private String messageName;
	private String messageContent;
	private String messageContent2;
	private String messageContent3;
	private String messageContent4;
	private String messageContent5;
	private String messageContent6;
	private int beforeDays;
	private int statDays;
	private Date startDate;
	private Date endDate;
	private String statCycle;
	private String script;
	private String vF01;
	private String nF01;
	private int iF01;
	private double dF02;
	private Date date01;
	private String operator;
	private Date makeDate;
	private String makeTime;
	public static final int FIELDNUM = 25;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MMessageConfigSchema()
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
		MMessageConfigSchema cloned = (MMessageConfigSchema)super.clone();
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

	public String getBranchType()
	{
		return branchType;
	}

	public void setBranchType(String aBranchType)
	{
		branchType = aBranchType;
	}

	public String getMessageType()
	{
		return messageType;
	}

	public void setMessageType(String aMessageType)
	{
		messageType = aMessageType;
	}

	public String getMessageName()
	{
		return messageName;
	}

	public void setMessageName(String aMessageName)
	{
		messageName = aMessageName;
	}

	public String getMessageContent()
	{
		return messageContent;
	}

	public void setMessageContent(String aMessageContent)
	{
		messageContent = aMessageContent;
	}

	public String getMessageContent2()
	{
		return messageContent2;
	}

	public void setMessageContent2(String aMessageContent2)
	{
		messageContent2 = aMessageContent2;
	}

	public String getMessageContent3()
	{
		return messageContent3;
	}

	public void setMessageContent3(String aMessageContent3)
	{
		messageContent3 = aMessageContent3;
	}

	public String getMessageContent4()
	{
		return messageContent4;
	}

	public void setMessageContent4(String aMessageContent4)
	{
		messageContent4 = aMessageContent4;
	}

	public String getMessageContent5()
	{
		return messageContent5;
	}

	public void setMessageContent5(String aMessageContent5)
	{
		messageContent5 = aMessageContent5;
	}

	public String getMessageContent6()
	{
		return messageContent6;
	}

	public void setMessageContent6(String aMessageContent6)
	{
		messageContent6 = aMessageContent6;
	}

	public int getBeforeDays()
	{
		return beforeDays;
	}

	public void setBeforeDays(int aBeforeDays)
	{
		beforeDays = aBeforeDays;
	}

	public void setBeforeDays(String aBeforeDays)
	{
		if (aBeforeDays != null && !aBeforeDays.equals(""))
		{
			Integer tInteger = new Integer(aBeforeDays);
			int i = tInteger.intValue();
			beforeDays = i;
		}
	}

	public int getStatDays()
	{
		return statDays;
	}

	public void setStatDays(int aStatDays)
	{
		statDays = aStatDays;
	}

	public void setStatDays(String aStatDays)
	{
		if (aStatDays != null && !aStatDays.equals(""))
		{
			Integer tInteger = new Integer(aStatDays);
			int i = tInteger.intValue();
			statDays = i;
		}
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

	public String getStatCycle()
	{
		return statCycle;
	}

	public void setStatCycle(String aStatCycle)
	{
		statCycle = aStatCycle;
	}

	public String getScript()
	{
		return script;
	}

	public void setScript(String aScript)
	{
		script = aScript;
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

	public void setSchema(MMessageConfigSchema aMMessageConfigSchema)
	{
		iD = aMMessageConfigSchema.getID();
		manageCom = aMMessageConfigSchema.getManageCom();
		branchType = aMMessageConfigSchema.getBranchType();
		messageType = aMMessageConfigSchema.getMessageType();
		messageName = aMMessageConfigSchema.getMessageName();
		messageContent = aMMessageConfigSchema.getMessageContent();
		messageContent2 = aMMessageConfigSchema.getMessageContent2();
		messageContent3 = aMMessageConfigSchema.getMessageContent3();
		messageContent4 = aMMessageConfigSchema.getMessageContent4();
		messageContent5 = aMMessageConfigSchema.getMessageContent5();
		messageContent6 = aMMessageConfigSchema.getMessageContent6();
		beforeDays = aMMessageConfigSchema.getBeforeDays();
		statDays = aMMessageConfigSchema.getStatDays();
		startDate = fDate.getDate(aMMessageConfigSchema.getStartDate());
		endDate = fDate.getDate(aMMessageConfigSchema.getEndDate());
		statCycle = aMMessageConfigSchema.getStatCycle();
		script = aMMessageConfigSchema.getScript();
		vF01 = aMMessageConfigSchema.getVF01();
		nF01 = aMMessageConfigSchema.getNF01();
		iF01 = aMMessageConfigSchema.getIF01();
		dF02 = aMMessageConfigSchema.getDF02();
		date01 = fDate.getDate(aMMessageConfigSchema.getDate01());
		operator = aMMessageConfigSchema.getOperator();
		makeDate = fDate.getDate(aMMessageConfigSchema.getMakeDate());
		makeTime = aMMessageConfigSchema.getMakeTime();
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
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			if (rs.getString("MessageType") == null)
				messageType = null;
			else
				messageType = rs.getString("MessageType").trim();
			if (rs.getString("MessageName") == null)
				messageName = null;
			else
				messageName = rs.getString("MessageName").trim();
			if (rs.getString("MessageContent") == null)
				messageContent = null;
			else
				messageContent = rs.getString("MessageContent").trim();
			if (rs.getString("MessageContent2") == null)
				messageContent2 = null;
			else
				messageContent2 = rs.getString("MessageContent2").trim();
			if (rs.getString("MessageContent3") == null)
				messageContent3 = null;
			else
				messageContent3 = rs.getString("MessageContent3").trim();
			if (rs.getString("MessageContent4") == null)
				messageContent4 = null;
			else
				messageContent4 = rs.getString("MessageContent4").trim();
			if (rs.getString("MessageContent5") == null)
				messageContent5 = null;
			else
				messageContent5 = rs.getString("MessageContent5").trim();
			if (rs.getString("MessageContent6") == null)
				messageContent6 = null;
			else
				messageContent6 = rs.getString("MessageContent6").trim();
			beforeDays = rs.getInt("BeforeDays");
			statDays = rs.getInt("StatDays");
			startDate = rs.getDate("StartDate");
			endDate = rs.getDate("EndDate");
			if (rs.getString("StatCycle") == null)
				statCycle = null;
			else
				statCycle = rs.getString("StatCycle").trim();
			if (rs.getString("Script") == null)
				script = null;
			else
				script = rs.getString("Script").trim();
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
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MMessageConfig表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MMessageConfigSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MMessageConfigSchema getSchema()
	{
		MMessageConfigSchema aMMessageConfigSchema = new MMessageConfigSchema();
		aMMessageConfigSchema.setSchema(this);
		return aMMessageConfigSchema;
	}

	public MMessageConfigDB getDB()
	{
		MMessageConfigDB aDBOper = new MMessageConfigDB();
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
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(messageType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(messageName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(messageContent));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(messageContent2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(messageContent3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(messageContent4));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(messageContent5));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(messageContent6));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(beforeDays));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(statDays));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(endDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(statCycle));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(script));
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
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			messageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			messageName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			messageContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			messageContent2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			messageContent3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			messageContent4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			messageContent5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			messageContent6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			beforeDays = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|")))).intValue();
			statDays = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|")))).intValue();
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			statCycle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			script = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MMessageConfigSchema";
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
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("messageType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(messageType));
		if (FCode.equalsIgnoreCase("messageName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(messageName));
		if (FCode.equalsIgnoreCase("messageContent"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(messageContent));
		if (FCode.equalsIgnoreCase("messageContent2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(messageContent2));
		if (FCode.equalsIgnoreCase("messageContent3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(messageContent3));
		if (FCode.equalsIgnoreCase("messageContent4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(messageContent4));
		if (FCode.equalsIgnoreCase("messageContent5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(messageContent5));
		if (FCode.equalsIgnoreCase("messageContent6"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(messageContent6));
		if (FCode.equalsIgnoreCase("beforeDays"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(beforeDays));
		if (FCode.equalsIgnoreCase("statDays"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(statDays));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("endDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
		if (FCode.equalsIgnoreCase("statCycle"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(statCycle));
		if (FCode.equalsIgnoreCase("script"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(script));
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
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(messageType);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(messageName);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(messageContent);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(messageContent2);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(messageContent3);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(messageContent4);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(messageContent5);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(messageContent6);
			break;

		case 11: // '\013'
			strFieldValue = String.valueOf(beforeDays);
			break;

		case 12: // '\f'
			strFieldValue = String.valueOf(statDays);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(statCycle);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(script);
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
		if (FCode.equalsIgnoreCase("branchType"))
			if (FValue != null && !FValue.equals(""))
				branchType = FValue.trim();
			else
				branchType = null;
		if (FCode.equalsIgnoreCase("messageType"))
			if (FValue != null && !FValue.equals(""))
				messageType = FValue.trim();
			else
				messageType = null;
		if (FCode.equalsIgnoreCase("messageName"))
			if (FValue != null && !FValue.equals(""))
				messageName = FValue.trim();
			else
				messageName = null;
		if (FCode.equalsIgnoreCase("messageContent"))
			if (FValue != null && !FValue.equals(""))
				messageContent = FValue.trim();
			else
				messageContent = null;
		if (FCode.equalsIgnoreCase("messageContent2"))
			if (FValue != null && !FValue.equals(""))
				messageContent2 = FValue.trim();
			else
				messageContent2 = null;
		if (FCode.equalsIgnoreCase("messageContent3"))
			if (FValue != null && !FValue.equals(""))
				messageContent3 = FValue.trim();
			else
				messageContent3 = null;
		if (FCode.equalsIgnoreCase("messageContent4"))
			if (FValue != null && !FValue.equals(""))
				messageContent4 = FValue.trim();
			else
				messageContent4 = null;
		if (FCode.equalsIgnoreCase("messageContent5"))
			if (FValue != null && !FValue.equals(""))
				messageContent5 = FValue.trim();
			else
				messageContent5 = null;
		if (FCode.equalsIgnoreCase("messageContent6"))
			if (FValue != null && !FValue.equals(""))
				messageContent6 = FValue.trim();
			else
				messageContent6 = null;
		if (FCode.equalsIgnoreCase("beforeDays") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			beforeDays = i;
		}
		if (FCode.equalsIgnoreCase("statDays") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			statDays = i;
		}
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
		if (FCode.equalsIgnoreCase("statCycle"))
			if (FValue != null && !FValue.equals(""))
				statCycle = FValue.trim();
			else
				statCycle = null;
		if (FCode.equalsIgnoreCase("script"))
			if (FValue != null && !FValue.equals(""))
				script = FValue.trim();
			else
				script = null;
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
		MMessageConfigSchema other = (MMessageConfigSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (messageType == null && other.getMessageType() != null)
			return false;
		if (messageType != null && !messageType.equals(other.getMessageType()))
			return false;
		if (messageName == null && other.getMessageName() != null)
			return false;
		if (messageName != null && !messageName.equals(other.getMessageName()))
			return false;
		if (messageContent == null && other.getMessageContent() != null)
			return false;
		if (messageContent != null && !messageContent.equals(other.getMessageContent()))
			return false;
		if (messageContent2 == null && other.getMessageContent2() != null)
			return false;
		if (messageContent2 != null && !messageContent2.equals(other.getMessageContent2()))
			return false;
		if (messageContent3 == null && other.getMessageContent3() != null)
			return false;
		if (messageContent3 != null && !messageContent3.equals(other.getMessageContent3()))
			return false;
		if (messageContent4 == null && other.getMessageContent4() != null)
			return false;
		if (messageContent4 != null && !messageContent4.equals(other.getMessageContent4()))
			return false;
		if (messageContent5 == null && other.getMessageContent5() != null)
			return false;
		if (messageContent5 != null && !messageContent5.equals(other.getMessageContent5()))
			return false;
		if (messageContent6 == null && other.getMessageContent6() != null)
			return false;
		if (messageContent6 != null && !messageContent6.equals(other.getMessageContent6()))
			return false;
		if (beforeDays != other.getBeforeDays())
			return false;
		if (statDays != other.getStatDays())
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (endDate == null && other.getEndDate() != null)
			return false;
		if (endDate != null && !fDate.getString(endDate).equals(other.getEndDate()))
			return false;
		if (statCycle == null && other.getStatCycle() != null)
			return false;
		if (statCycle != null && !statCycle.equals(other.getStatCycle()))
			return false;
		if (script == null && other.getScript() != null)
			return false;
		if (script != null && !script.equals(other.getScript()))
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
		return makeTime == null || makeTime.equals(other.getMakeTime());
	}

	public int getFieldCount()
	{
		return 25;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 1;
		if (strFieldName.equals("branchType"))
			return 2;
		if (strFieldName.equals("messageType"))
			return 3;
		if (strFieldName.equals("messageName"))
			return 4;
		if (strFieldName.equals("messageContent"))
			return 5;
		if (strFieldName.equals("messageContent2"))
			return 6;
		if (strFieldName.equals("messageContent3"))
			return 7;
		if (strFieldName.equals("messageContent4"))
			return 8;
		if (strFieldName.equals("messageContent5"))
			return 9;
		if (strFieldName.equals("messageContent6"))
			return 10;
		if (strFieldName.equals("beforeDays"))
			return 11;
		if (strFieldName.equals("statDays"))
			return 12;
		if (strFieldName.equals("startDate"))
			return 13;
		if (strFieldName.equals("endDate"))
			return 14;
		if (strFieldName.equals("statCycle"))
			return 15;
		if (strFieldName.equals("script"))
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
		return !strFieldName.equals("makeTime") ? -1 : 24;
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
			strFieldName = "branchType";
			break;

		case 3: // '\003'
			strFieldName = "messageType";
			break;

		case 4: // '\004'
			strFieldName = "messageName";
			break;

		case 5: // '\005'
			strFieldName = "messageContent";
			break;

		case 6: // '\006'
			strFieldName = "messageContent2";
			break;

		case 7: // '\007'
			strFieldName = "messageContent3";
			break;

		case 8: // '\b'
			strFieldName = "messageContent4";
			break;

		case 9: // '\t'
			strFieldName = "messageContent5";
			break;

		case 10: // '\n'
			strFieldName = "messageContent6";
			break;

		case 11: // '\013'
			strFieldName = "beforeDays";
			break;

		case 12: // '\f'
			strFieldName = "statDays";
			break;

		case 13: // '\r'
			strFieldName = "startDate";
			break;

		case 14: // '\016'
			strFieldName = "endDate";
			break;

		case 15: // '\017'
			strFieldName = "statCycle";
			break;

		case 16: // '\020'
			strFieldName = "script";
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
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("messageType"))
			return 0;
		if (strFieldName.equals("messageName"))
			return 0;
		if (strFieldName.equals("messageContent"))
			return 0;
		if (strFieldName.equals("messageContent2"))
			return 0;
		if (strFieldName.equals("messageContent3"))
			return 0;
		if (strFieldName.equals("messageContent4"))
			return 0;
		if (strFieldName.equals("messageContent5"))
			return 0;
		if (strFieldName.equals("messageContent6"))
			return 0;
		if (strFieldName.equals("beforeDays"))
			return 3;
		if (strFieldName.equals("statDays"))
			return 3;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("endDate"))
			return 1;
		if (strFieldName.equals("statCycle"))
			return 0;
		if (strFieldName.equals("script"))
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
		return !strFieldName.equals("makeTime") ? -1 : 0;
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
			nFieldType = 3;
			break;

		case 12: // '\f'
			nFieldType = 3;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
