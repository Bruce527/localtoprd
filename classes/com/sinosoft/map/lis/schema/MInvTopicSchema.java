// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvTopicSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MInvTopicDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MInvTopicSchema
	implements Schema, Cloneable
{

	private String topicID;
	private String topic;
	private String manageCom;
	private String branchType;
	private String depiction;
	private String author;
	private int population;
	private Date startDate;
	private Date endDate;
	private String invType;
	private String state;
	private String invState;
	private String checkState;
	private String checkOperator;
	private String checkReason;
	private Date checkDate;
	private String checkTime;
	private String vF01;
	private String nF01;
	private int iF01;
	private double dF02;
	private Date date01;
	private String modifyOperator;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 28;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MInvTopicSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "TopicID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MInvTopicSchema cloned = (MInvTopicSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getTopicID()
	{
		return topicID;
	}

	public void setTopicID(String aTopicID)
	{
		topicID = aTopicID;
	}

	public String getTopic()
	{
		return topic;
	}

	public void setTopic(String aTopic)
	{
		topic = aTopic;
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

	public String getDepiction()
	{
		return depiction;
	}

	public void setDepiction(String aDepiction)
	{
		depiction = aDepiction;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String aAuthor)
	{
		author = aAuthor;
	}

	public int getPopulation()
	{
		return population;
	}

	public void setPopulation(int aPopulation)
	{
		population = aPopulation;
	}

	public void setPopulation(String aPopulation)
	{
		if (aPopulation != null && !aPopulation.equals(""))
		{
			Integer tInteger = new Integer(aPopulation);
			int i = tInteger.intValue();
			population = i;
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

	public String getInvType()
	{
		return invType;
	}

	public void setInvType(String aInvType)
	{
		invType = aInvType;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getInvState()
	{
		return invState;
	}

	public void setInvState(String aInvState)
	{
		invState = aInvState;
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

	public String getModifyOperator()
	{
		return modifyOperator;
	}

	public void setModifyOperator(String aModifyOperator)
	{
		modifyOperator = aModifyOperator;
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

	public void setSchema(MInvTopicSchema aMInvTopicSchema)
	{
		topicID = aMInvTopicSchema.getTopicID();
		topic = aMInvTopicSchema.getTopic();
		manageCom = aMInvTopicSchema.getManageCom();
		branchType = aMInvTopicSchema.getBranchType();
		depiction = aMInvTopicSchema.getDepiction();
		author = aMInvTopicSchema.getAuthor();
		population = aMInvTopicSchema.getPopulation();
		startDate = fDate.getDate(aMInvTopicSchema.getStartDate());
		endDate = fDate.getDate(aMInvTopicSchema.getEndDate());
		invType = aMInvTopicSchema.getInvType();
		state = aMInvTopicSchema.getState();
		invState = aMInvTopicSchema.getInvState();
		checkState = aMInvTopicSchema.getCheckState();
		checkOperator = aMInvTopicSchema.getCheckOperator();
		checkReason = aMInvTopicSchema.getCheckReason();
		checkDate = fDate.getDate(aMInvTopicSchema.getCheckDate());
		checkTime = aMInvTopicSchema.getCheckTime();
		vF01 = aMInvTopicSchema.getVF01();
		nF01 = aMInvTopicSchema.getNF01();
		iF01 = aMInvTopicSchema.getIF01();
		dF02 = aMInvTopicSchema.getDF02();
		date01 = fDate.getDate(aMInvTopicSchema.getDate01());
		modifyOperator = aMInvTopicSchema.getModifyOperator();
		operator = aMInvTopicSchema.getOperator();
		makeDate = fDate.getDate(aMInvTopicSchema.getMakeDate());
		makeTime = aMInvTopicSchema.getMakeTime();
		modifyDate = fDate.getDate(aMInvTopicSchema.getModifyDate());
		modifyTime = aMInvTopicSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("TopicID") == null)
				topicID = null;
			else
				topicID = rs.getString("TopicID").trim();
			if (rs.getString("Topic") == null)
				topic = null;
			else
				topic = rs.getString("Topic").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			if (rs.getString("Depiction") == null)
				depiction = null;
			else
				depiction = rs.getString("Depiction").trim();
			if (rs.getString("Author") == null)
				author = null;
			else
				author = rs.getString("Author").trim();
			population = rs.getInt("Population");
			startDate = rs.getDate("StartDate");
			endDate = rs.getDate("EndDate");
			if (rs.getString("InvType") == null)
				invType = null;
			else
				invType = rs.getString("InvType").trim();
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			if (rs.getString("InvState") == null)
				invState = null;
			else
				invState = rs.getString("InvState").trim();
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
			if (rs.getString("ModifyOperator") == null)
				modifyOperator = null;
			else
				modifyOperator = rs.getString("ModifyOperator").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
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
			System.out.println("数据库中的MInvTopic表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MInvTopicSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MInvTopicSchema getSchema()
	{
		MInvTopicSchema aMInvTopicSchema = new MInvTopicSchema();
		aMInvTopicSchema.setSchema(this);
		return aMInvTopicSchema;
	}

	public MInvTopicDB getDB()
	{
		MInvTopicDB aDBOper = new MInvTopicDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(topicID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(topic));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(depiction));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(author));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(population));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(endDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(invType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(invState));
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
		strReturn.append(StrTool.cTrim(modifyOperator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
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
			topicID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			topic = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			depiction = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			author = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			population = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).intValue();
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			invType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			invState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			checkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
			checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MInvTopicSchema";
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
		if (FCode.equalsIgnoreCase("topicID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(topicID));
		if (FCode.equalsIgnoreCase("topic"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(topic));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("depiction"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(depiction));
		if (FCode.equalsIgnoreCase("author"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(author));
		if (FCode.equalsIgnoreCase("population"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(population));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("endDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
		if (FCode.equalsIgnoreCase("invType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(invType));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("invState"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(invState));
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
		if (FCode.equalsIgnoreCase("modifyOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyOperator));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
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
			strFieldValue = StrTool.GBKToUnicode(topicID);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(topic);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(depiction);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(author);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(population);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(invType);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(invState);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(checkState);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(checkOperator);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(checkReason);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(checkTime);
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
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 27: // '\033'
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
		if (FCode.equalsIgnoreCase("topicID"))
			if (FValue != null && !FValue.equals(""))
				topicID = FValue.trim();
			else
				topicID = null;
		if (FCode.equalsIgnoreCase("topic"))
			if (FValue != null && !FValue.equals(""))
				topic = FValue.trim();
			else
				topic = null;
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
		if (FCode.equalsIgnoreCase("depiction"))
			if (FValue != null && !FValue.equals(""))
				depiction = FValue.trim();
			else
				depiction = null;
		if (FCode.equalsIgnoreCase("author"))
			if (FValue != null && !FValue.equals(""))
				author = FValue.trim();
			else
				author = null;
		if (FCode.equalsIgnoreCase("population") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			population = i;
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
		if (FCode.equalsIgnoreCase("invType"))
			if (FValue != null && !FValue.equals(""))
				invType = FValue.trim();
			else
				invType = null;
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("invState"))
			if (FValue != null && !FValue.equals(""))
				invState = FValue.trim();
			else
				invState = null;
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
		if (FCode.equalsIgnoreCase("modifyOperator"))
			if (FValue != null && !FValue.equals(""))
				modifyOperator = FValue.trim();
			else
				modifyOperator = null;
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
		MInvTopicSchema other = (MInvTopicSchema)otherObject;
		if (topicID == null && other.getTopicID() != null)
			return false;
		if (topicID != null && !topicID.equals(other.getTopicID()))
			return false;
		if (topic == null && other.getTopic() != null)
			return false;
		if (topic != null && !topic.equals(other.getTopic()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (depiction == null && other.getDepiction() != null)
			return false;
		if (depiction != null && !depiction.equals(other.getDepiction()))
			return false;
		if (author == null && other.getAuthor() != null)
			return false;
		if (author != null && !author.equals(other.getAuthor()))
			return false;
		if (population != other.getPopulation())
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (endDate == null && other.getEndDate() != null)
			return false;
		if (endDate != null && !fDate.getString(endDate).equals(other.getEndDate()))
			return false;
		if (invType == null && other.getInvType() != null)
			return false;
		if (invType != null && !invType.equals(other.getInvType()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (invState == null && other.getInvState() != null)
			return false;
		if (invState != null && !invState.equals(other.getInvState()))
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
		if (checkTime != null && !checkTime.equals(other.getCheckTime()))
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
		if (modifyOperator == null && other.getModifyOperator() != null)
			return false;
		if (modifyOperator != null && !modifyOperator.equals(other.getModifyOperator()))
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
		return 28;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("topicID"))
			return 0;
		if (strFieldName.equals("topic"))
			return 1;
		if (strFieldName.equals("manageCom"))
			return 2;
		if (strFieldName.equals("branchType"))
			return 3;
		if (strFieldName.equals("depiction"))
			return 4;
		if (strFieldName.equals("author"))
			return 5;
		if (strFieldName.equals("population"))
			return 6;
		if (strFieldName.equals("startDate"))
			return 7;
		if (strFieldName.equals("endDate"))
			return 8;
		if (strFieldName.equals("invType"))
			return 9;
		if (strFieldName.equals("state"))
			return 10;
		if (strFieldName.equals("invState"))
			return 11;
		if (strFieldName.equals("checkState"))
			return 12;
		if (strFieldName.equals("checkOperator"))
			return 13;
		if (strFieldName.equals("checkReason"))
			return 14;
		if (strFieldName.equals("checkDate"))
			return 15;
		if (strFieldName.equals("checkTime"))
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
		if (strFieldName.equals("modifyOperator"))
			return 22;
		if (strFieldName.equals("operator"))
			return 23;
		if (strFieldName.equals("makeDate"))
			return 24;
		if (strFieldName.equals("makeTime"))
			return 25;
		if (strFieldName.equals("modifyDate"))
			return 26;
		return !strFieldName.equals("modifyTime") ? -1 : 27;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "topicID";
			break;

		case 1: // '\001'
			strFieldName = "topic";
			break;

		case 2: // '\002'
			strFieldName = "manageCom";
			break;

		case 3: // '\003'
			strFieldName = "branchType";
			break;

		case 4: // '\004'
			strFieldName = "depiction";
			break;

		case 5: // '\005'
			strFieldName = "author";
			break;

		case 6: // '\006'
			strFieldName = "population";
			break;

		case 7: // '\007'
			strFieldName = "startDate";
			break;

		case 8: // '\b'
			strFieldName = "endDate";
			break;

		case 9: // '\t'
			strFieldName = "invType";
			break;

		case 10: // '\n'
			strFieldName = "state";
			break;

		case 11: // '\013'
			strFieldName = "invState";
			break;

		case 12: // '\f'
			strFieldName = "checkState";
			break;

		case 13: // '\r'
			strFieldName = "checkOperator";
			break;

		case 14: // '\016'
			strFieldName = "checkReason";
			break;

		case 15: // '\017'
			strFieldName = "checkDate";
			break;

		case 16: // '\020'
			strFieldName = "checkTime";
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
			strFieldName = "modifyOperator";
			break;

		case 23: // '\027'
			strFieldName = "operator";
			break;

		case 24: // '\030'
			strFieldName = "makeDate";
			break;

		case 25: // '\031'
			strFieldName = "makeTime";
			break;

		case 26: // '\032'
			strFieldName = "modifyDate";
			break;

		case 27: // '\033'
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
		if (strFieldName.equals("topicID"))
			return 0;
		if (strFieldName.equals("topic"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("depiction"))
			return 0;
		if (strFieldName.equals("author"))
			return 0;
		if (strFieldName.equals("population"))
			return 3;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("endDate"))
			return 1;
		if (strFieldName.equals("invType"))
			return 0;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("invState"))
			return 0;
		if (strFieldName.equals("checkState"))
			return 0;
		if (strFieldName.equals("checkOperator"))
			return 0;
		if (strFieldName.equals("checkReason"))
			return 0;
		if (strFieldName.equals("checkDate"))
			return 1;
		if (strFieldName.equals("checkTime"))
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
		if (strFieldName.equals("modifyOperator"))
			return 0;
		if (strFieldName.equals("operator"))
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
			nFieldType = 3;
			break;

		case 7: // '\007'
			nFieldType = 1;
			break;

		case 8: // '\b'
			nFieldType = 1;
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
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 24: // '\030'
			nFieldType = 1;
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
