// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MTrainInfoSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MTrainInfoDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MTrainInfoSchema
	implements Schema, Cloneable
{

	private String iD;
	private String agentCode;
	private String agentName;
	private String agentGrade;
	private String agentGroup;
	private String manageCom;
	private String branchType;
	private String courseID;
	private Date trainStart;
	private Date trainEnd;
	private String trainAdd;
	private String hours;
	private String teacher;
	private String passFlag;
	private String score;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 20;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MTrainInfoSchema()
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
		MTrainInfoSchema cloned = (MTrainInfoSchema)super.clone();
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

	public String getAgentName()
	{
		return agentName;
	}

	public void setAgentName(String aAgentName)
	{
		agentName = aAgentName;
	}

	public String getAgentGrade()
	{
		return agentGrade;
	}

	public void setAgentGrade(String aAgentGrade)
	{
		agentGrade = aAgentGrade;
	}

	public String getAgentGroup()
	{
		return agentGroup;
	}

	public void setAgentGroup(String aAgentGroup)
	{
		agentGroup = aAgentGroup;
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

	public String getCourseID()
	{
		return courseID;
	}

	public void setCourseID(String aCourseID)
	{
		courseID = aCourseID;
	}

	public String getTrainStart()
	{
		if (trainStart != null)
			return fDate.getString(trainStart);
		else
			return null;
	}

	public void setTrainStart(Date aTrainStart)
	{
		trainStart = aTrainStart;
	}

	public void setTrainStart(String aTrainStart)
	{
		if (aTrainStart != null && !aTrainStart.equals(""))
			trainStart = fDate.getDate(aTrainStart);
		else
			trainStart = null;
	}

	public String getTrainEnd()
	{
		if (trainEnd != null)
			return fDate.getString(trainEnd);
		else
			return null;
	}

	public void setTrainEnd(Date aTrainEnd)
	{
		trainEnd = aTrainEnd;
	}

	public void setTrainEnd(String aTrainEnd)
	{
		if (aTrainEnd != null && !aTrainEnd.equals(""))
			trainEnd = fDate.getDate(aTrainEnd);
		else
			trainEnd = null;
	}

	public String getTrainAdd()
	{
		return trainAdd;
	}

	public void setTrainAdd(String aTrainAdd)
	{
		trainAdd = aTrainAdd;
	}

	public String getHours()
	{
		return hours;
	}

	public void setHours(String aHours)
	{
		hours = aHours;
	}

	public String getTeacher()
	{
		return teacher;
	}

	public void setTeacher(String aTeacher)
	{
		teacher = aTeacher;
	}

	public String getPassFlag()
	{
		return passFlag;
	}

	public void setPassFlag(String aPassFlag)
	{
		passFlag = aPassFlag;
	}

	public String getScore()
	{
		return score;
	}

	public void setScore(String aScore)
	{
		score = aScore;
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

	public void setSchema(MTrainInfoSchema aMTrainInfoSchema)
	{
		iD = aMTrainInfoSchema.getID();
		agentCode = aMTrainInfoSchema.getAgentCode();
		agentName = aMTrainInfoSchema.getAgentName();
		agentGrade = aMTrainInfoSchema.getAgentGrade();
		agentGroup = aMTrainInfoSchema.getAgentGroup();
		manageCom = aMTrainInfoSchema.getManageCom();
		branchType = aMTrainInfoSchema.getBranchType();
		courseID = aMTrainInfoSchema.getCourseID();
		trainStart = fDate.getDate(aMTrainInfoSchema.getTrainStart());
		trainEnd = fDate.getDate(aMTrainInfoSchema.getTrainEnd());
		trainAdd = aMTrainInfoSchema.getTrainAdd();
		hours = aMTrainInfoSchema.getHours();
		teacher = aMTrainInfoSchema.getTeacher();
		passFlag = aMTrainInfoSchema.getPassFlag();
		score = aMTrainInfoSchema.getScore();
		operator = aMTrainInfoSchema.getOperator();
		makeDate = fDate.getDate(aMTrainInfoSchema.getMakeDate());
		makeTime = aMTrainInfoSchema.getMakeTime();
		modifyDate = fDate.getDate(aMTrainInfoSchema.getModifyDate());
		modifyTime = aMTrainInfoSchema.getModifyTime();
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
			if (rs.getString("AgentName") == null)
				agentName = null;
			else
				agentName = rs.getString("AgentName").trim();
			if (rs.getString("AgentGrade") == null)
				agentGrade = null;
			else
				agentGrade = rs.getString("AgentGrade").trim();
			if (rs.getString("AgentGroup") == null)
				agentGroup = null;
			else
				agentGroup = rs.getString("AgentGroup").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			if (rs.getString("CourseID") == null)
				courseID = null;
			else
				courseID = rs.getString("CourseID").trim();
			trainStart = rs.getDate("TrainStart");
			trainEnd = rs.getDate("TrainEnd");
			if (rs.getString("TrainAdd") == null)
				trainAdd = null;
			else
				trainAdd = rs.getString("TrainAdd").trim();
			if (rs.getString("Hours") == null)
				hours = null;
			else
				hours = rs.getString("Hours").trim();
			if (rs.getString("Teacher") == null)
				teacher = null;
			else
				teacher = rs.getString("Teacher").trim();
			if (rs.getString("PassFlag") == null)
				passFlag = null;
			else
				passFlag = rs.getString("PassFlag").trim();
			if (rs.getString("Score") == null)
				score = null;
			else
				score = rs.getString("Score").trim();
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
			System.out.println("数据库中的MTrainInfo表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MTrainInfoSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MTrainInfoSchema getSchema()
	{
		MTrainInfoSchema aMTrainInfoSchema = new MTrainInfoSchema();
		aMTrainInfoSchema.setSchema(this);
		return aMTrainInfoSchema;
	}

	public MTrainInfoDB getDB()
	{
		MTrainInfoDB aDBOper = new MTrainInfoDB();
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
		strReturn.append(StrTool.cTrim(agentName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGroup));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(courseID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(trainStart)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(trainEnd)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(trainAdd));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(hours));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(teacher));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(passFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(score));
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
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			agentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			courseID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			trainStart = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			trainEnd = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			trainAdd = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			hours = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			teacher = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			passFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			score = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MTrainInfoSchema";
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
		if (FCode.equalsIgnoreCase("agentName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentName));
		if (FCode.equalsIgnoreCase("agentGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGrade));
		if (FCode.equalsIgnoreCase("agentGroup"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("courseID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(courseID));
		if (FCode.equalsIgnoreCase("trainStart"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getTrainStart()));
		if (FCode.equalsIgnoreCase("trainEnd"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getTrainEnd()));
		if (FCode.equalsIgnoreCase("trainAdd"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(trainAdd));
		if (FCode.equalsIgnoreCase("hours"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(hours));
		if (FCode.equalsIgnoreCase("teacher"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(teacher));
		if (FCode.equalsIgnoreCase("passFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(passFlag));
		if (FCode.equalsIgnoreCase("score"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(score));
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
			strFieldValue = StrTool.GBKToUnicode(iD);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(agentName);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(agentGrade);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(agentGroup);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(courseID);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getTrainStart()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getTrainEnd()));
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(trainAdd);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(hours);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(teacher);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(passFlag);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(score);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 19: // '\023'
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
		if (FCode.equalsIgnoreCase("agentName"))
			if (FValue != null && !FValue.equals(""))
				agentName = FValue.trim();
			else
				agentName = null;
		if (FCode.equalsIgnoreCase("agentGrade"))
			if (FValue != null && !FValue.equals(""))
				agentGrade = FValue.trim();
			else
				agentGrade = null;
		if (FCode.equalsIgnoreCase("agentGroup"))
			if (FValue != null && !FValue.equals(""))
				agentGroup = FValue.trim();
			else
				agentGroup = null;
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
		if (FCode.equalsIgnoreCase("courseID"))
			if (FValue != null && !FValue.equals(""))
				courseID = FValue.trim();
			else
				courseID = null;
		if (FCode.equalsIgnoreCase("trainStart"))
			if (FValue != null && !FValue.equals(""))
				trainStart = fDate.getDate(FValue);
			else
				trainStart = null;
		if (FCode.equalsIgnoreCase("trainEnd"))
			if (FValue != null && !FValue.equals(""))
				trainEnd = fDate.getDate(FValue);
			else
				trainEnd = null;
		if (FCode.equalsIgnoreCase("trainAdd"))
			if (FValue != null && !FValue.equals(""))
				trainAdd = FValue.trim();
			else
				trainAdd = null;
		if (FCode.equalsIgnoreCase("hours"))
			if (FValue != null && !FValue.equals(""))
				hours = FValue.trim();
			else
				hours = null;
		if (FCode.equalsIgnoreCase("teacher"))
			if (FValue != null && !FValue.equals(""))
				teacher = FValue.trim();
			else
				teacher = null;
		if (FCode.equalsIgnoreCase("passFlag"))
			if (FValue != null && !FValue.equals(""))
				passFlag = FValue.trim();
			else
				passFlag = null;
		if (FCode.equalsIgnoreCase("score"))
			if (FValue != null && !FValue.equals(""))
				score = FValue.trim();
			else
				score = null;
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
		MTrainInfoSchema other = (MTrainInfoSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (agentName == null && other.getAgentName() != null)
			return false;
		if (agentName != null && !agentName.equals(other.getAgentName()))
			return false;
		if (agentGrade == null && other.getAgentGrade() != null)
			return false;
		if (agentGrade != null && !agentGrade.equals(other.getAgentGrade()))
			return false;
		if (agentGroup == null && other.getAgentGroup() != null)
			return false;
		if (agentGroup != null && !agentGroup.equals(other.getAgentGroup()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (courseID == null && other.getCourseID() != null)
			return false;
		if (courseID != null && !courseID.equals(other.getCourseID()))
			return false;
		if (trainStart == null && other.getTrainStart() != null)
			return false;
		if (trainStart != null && !fDate.getString(trainStart).equals(other.getTrainStart()))
			return false;
		if (trainEnd == null && other.getTrainEnd() != null)
			return false;
		if (trainEnd != null && !fDate.getString(trainEnd).equals(other.getTrainEnd()))
			return false;
		if (trainAdd == null && other.getTrainAdd() != null)
			return false;
		if (trainAdd != null && !trainAdd.equals(other.getTrainAdd()))
			return false;
		if (hours == null && other.getHours() != null)
			return false;
		if (hours != null && !hours.equals(other.getHours()))
			return false;
		if (teacher == null && other.getTeacher() != null)
			return false;
		if (teacher != null && !teacher.equals(other.getTeacher()))
			return false;
		if (passFlag == null && other.getPassFlag() != null)
			return false;
		if (passFlag != null && !passFlag.equals(other.getPassFlag()))
			return false;
		if (score == null && other.getScore() != null)
			return false;
		if (score != null && !score.equals(other.getScore()))
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
		return 20;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 1;
		if (strFieldName.equals("agentName"))
			return 2;
		if (strFieldName.equals("agentGrade"))
			return 3;
		if (strFieldName.equals("agentGroup"))
			return 4;
		if (strFieldName.equals("manageCom"))
			return 5;
		if (strFieldName.equals("branchType"))
			return 6;
		if (strFieldName.equals("courseID"))
			return 7;
		if (strFieldName.equals("trainStart"))
			return 8;
		if (strFieldName.equals("trainEnd"))
			return 9;
		if (strFieldName.equals("trainAdd"))
			return 10;
		if (strFieldName.equals("hours"))
			return 11;
		if (strFieldName.equals("teacher"))
			return 12;
		if (strFieldName.equals("passFlag"))
			return 13;
		if (strFieldName.equals("score"))
			return 14;
		if (strFieldName.equals("operator"))
			return 15;
		if (strFieldName.equals("makeDate"))
			return 16;
		if (strFieldName.equals("makeTime"))
			return 17;
		if (strFieldName.equals("modifyDate"))
			return 18;
		return !strFieldName.equals("modifyTime") ? -1 : 19;
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
			strFieldName = "agentName";
			break;

		case 3: // '\003'
			strFieldName = "agentGrade";
			break;

		case 4: // '\004'
			strFieldName = "agentGroup";
			break;

		case 5: // '\005'
			strFieldName = "manageCom";
			break;

		case 6: // '\006'
			strFieldName = "branchType";
			break;

		case 7: // '\007'
			strFieldName = "courseID";
			break;

		case 8: // '\b'
			strFieldName = "trainStart";
			break;

		case 9: // '\t'
			strFieldName = "trainEnd";
			break;

		case 10: // '\n'
			strFieldName = "trainAdd";
			break;

		case 11: // '\013'
			strFieldName = "hours";
			break;

		case 12: // '\f'
			strFieldName = "teacher";
			break;

		case 13: // '\r'
			strFieldName = "passFlag";
			break;

		case 14: // '\016'
			strFieldName = "score";
			break;

		case 15: // '\017'
			strFieldName = "operator";
			break;

		case 16: // '\020'
			strFieldName = "makeDate";
			break;

		case 17: // '\021'
			strFieldName = "makeTime";
			break;

		case 18: // '\022'
			strFieldName = "modifyDate";
			break;

		case 19: // '\023'
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
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("agentName"))
			return 0;
		if (strFieldName.equals("agentGrade"))
			return 0;
		if (strFieldName.equals("agentGroup"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("courseID"))
			return 0;
		if (strFieldName.equals("trainStart"))
			return 1;
		if (strFieldName.equals("trainEnd"))
			return 1;
		if (strFieldName.equals("trainAdd"))
			return 0;
		if (strFieldName.equals("hours"))
			return 0;
		if (strFieldName.equals("teacher"))
			return 0;
		if (strFieldName.equals("passFlag"))
			return 0;
		if (strFieldName.equals("score"))
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
			nFieldType = 0;
			break;

		case 15: // '\017'
			nFieldType = 0;
			break;

		case 16: // '\020'
			nFieldType = 1;
			break;

		case 17: // '\021'
			nFieldType = 0;
			break;

		case 18: // '\022'
			nFieldType = 1;
			break;

		case 19: // '\023'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
