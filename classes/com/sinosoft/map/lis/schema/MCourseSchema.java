// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MCourseSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MCourseDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MCourseSchema
	implements Schema, Cloneable
{

	private String iD;
	private String courseID;
	private String courseName;
	private String manageCom;
	private String branchType;
	private String hour;
	private String developBranch;
	private String developer;
	private Date developeDate;
	private String noTi;
	private String operator;
	private String modifyOperator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String course1;
	private String course2;
	private String course3;
	private Date course4;
	public static final int FIELDNUM = 20;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MCourseSchema()
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
		MCourseSchema cloned = (MCourseSchema)super.clone();
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

	public String getCourseID()
	{
		return courseID;
	}

	public void setCourseID(String aCourseID)
	{
		courseID = aCourseID;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String aCourseName)
	{
		courseName = aCourseName;
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

	public String getHour()
	{
		return hour;
	}

	public void setHour(String aHour)
	{
		hour = aHour;
	}

	public String getDevelopBranch()
	{
		return developBranch;
	}

	public void setDevelopBranch(String aDevelopBranch)
	{
		developBranch = aDevelopBranch;
	}

	public String getDeveloper()
	{
		return developer;
	}

	public void setDeveloper(String aDeveloper)
	{
		developer = aDeveloper;
	}

	public String getDevelopeDate()
	{
		if (developeDate != null)
			return fDate.getString(developeDate);
		else
			return null;
	}

	public void setDevelopeDate(Date aDevelopeDate)
	{
		developeDate = aDevelopeDate;
	}

	public void setDevelopeDate(String aDevelopeDate)
	{
		if (aDevelopeDate != null && !aDevelopeDate.equals(""))
			developeDate = fDate.getDate(aDevelopeDate);
		else
			developeDate = null;
	}

	public String getNoTi()
	{
		return noTi;
	}

	public void setNoTi(String aNoTi)
	{
		noTi = aNoTi;
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

	public String getCourse1()
	{
		return course1;
	}

	public void setCourse1(String aCourse1)
	{
		course1 = aCourse1;
	}

	public String getCourse2()
	{
		return course2;
	}

	public void setCourse2(String aCourse2)
	{
		course2 = aCourse2;
	}

	public String getCourse3()
	{
		return course3;
	}

	public void setCourse3(String aCourse3)
	{
		course3 = aCourse3;
	}

	public String getCourse4()
	{
		if (course4 != null)
			return fDate.getString(course4);
		else
			return null;
	}

	public void setCourse4(Date aCourse4)
	{
		course4 = aCourse4;
	}

	public void setCourse4(String aCourse4)
	{
		if (aCourse4 != null && !aCourse4.equals(""))
			course4 = fDate.getDate(aCourse4);
		else
			course4 = null;
	}

	public void setSchema(MCourseSchema aMCourseSchema)
	{
		iD = aMCourseSchema.getID();
		courseID = aMCourseSchema.getCourseID();
		courseName = aMCourseSchema.getCourseName();
		manageCom = aMCourseSchema.getManageCom();
		branchType = aMCourseSchema.getBranchType();
		hour = aMCourseSchema.getHour();
		developBranch = aMCourseSchema.getDevelopBranch();
		developer = aMCourseSchema.getDeveloper();
		developeDate = fDate.getDate(aMCourseSchema.getDevelopeDate());
		noTi = aMCourseSchema.getNoTi();
		operator = aMCourseSchema.getOperator();
		modifyOperator = aMCourseSchema.getModifyOperator();
		makeDate = fDate.getDate(aMCourseSchema.getMakeDate());
		makeTime = aMCourseSchema.getMakeTime();
		modifyDate = fDate.getDate(aMCourseSchema.getModifyDate());
		modifyTime = aMCourseSchema.getModifyTime();
		course1 = aMCourseSchema.getCourse1();
		course2 = aMCourseSchema.getCourse2();
		course3 = aMCourseSchema.getCourse3();
		course4 = fDate.getDate(aMCourseSchema.getCourse4());
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ID") == null)
				iD = null;
			else
				iD = rs.getString("ID").trim();
			if (rs.getString("CourseID") == null)
				courseID = null;
			else
				courseID = rs.getString("CourseID").trim();
			if (rs.getString("CourseName") == null)
				courseName = null;
			else
				courseName = rs.getString("CourseName").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			if (rs.getString("Hour") == null)
				hour = null;
			else
				hour = rs.getString("Hour").trim();
			if (rs.getString("DevelopBranch") == null)
				developBranch = null;
			else
				developBranch = rs.getString("DevelopBranch").trim();
			if (rs.getString("Developer") == null)
				developer = null;
			else
				developer = rs.getString("Developer").trim();
			developeDate = rs.getDate("DevelopeDate");
			if (rs.getString("NoTi") == null)
				noTi = null;
			else
				noTi = rs.getString("NoTi").trim();
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
			if (rs.getString("course1") == null)
				course1 = null;
			else
				course1 = rs.getString("course1").trim();
			if (rs.getString("course2") == null)
				course2 = null;
			else
				course2 = rs.getString("course2").trim();
			if (rs.getString("course3") == null)
				course3 = null;
			else
				course3 = rs.getString("course3").trim();
			course4 = rs.getDate("course4");
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MCourse表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MCourseSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MCourseSchema getSchema()
	{
		MCourseSchema aMCourseSchema = new MCourseSchema();
		aMCourseSchema.setSchema(this);
		return aMCourseSchema;
	}

	public MCourseDB getDB()
	{
		MCourseDB aDBOper = new MCourseDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(iD));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(courseID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(courseName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(hour));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(developBranch));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(developer));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(developeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(noTi));
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
		strReturn.append(StrTool.cTrim(course1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(course2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(course3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(course4)));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			courseID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			courseName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			hour = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			developBranch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			developer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			developeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			noTi = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			course1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			course2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			course3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			course4 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MCourseSchema";
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
		if (FCode.equalsIgnoreCase("courseID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(courseID));
		if (FCode.equalsIgnoreCase("courseName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(courseName));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("hour"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(hour));
		if (FCode.equalsIgnoreCase("developBranch"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(developBranch));
		if (FCode.equalsIgnoreCase("developer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(developer));
		if (FCode.equalsIgnoreCase("developeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDevelopeDate()));
		if (FCode.equalsIgnoreCase("noTi"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(noTi));
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
		if (FCode.equalsIgnoreCase("course1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(course1));
		if (FCode.equalsIgnoreCase("course2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(course2));
		if (FCode.equalsIgnoreCase("course3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(course3));
		if (FCode.equalsIgnoreCase("course4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getCourse4()));
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
			strFieldValue = StrTool.GBKToUnicode(courseID);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(courseName);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(hour);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(developBranch);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(developer);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDevelopeDate()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(noTi);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(course1);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(course2);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(course3);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCourse4()));
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
		if (FCode.equalsIgnoreCase("courseID"))
			if (FValue != null && !FValue.equals(""))
				courseID = FValue.trim();
			else
				courseID = null;
		if (FCode.equalsIgnoreCase("courseName"))
			if (FValue != null && !FValue.equals(""))
				courseName = FValue.trim();
			else
				courseName = null;
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
		if (FCode.equalsIgnoreCase("hour"))
			if (FValue != null && !FValue.equals(""))
				hour = FValue.trim();
			else
				hour = null;
		if (FCode.equalsIgnoreCase("developBranch"))
			if (FValue != null && !FValue.equals(""))
				developBranch = FValue.trim();
			else
				developBranch = null;
		if (FCode.equalsIgnoreCase("developer"))
			if (FValue != null && !FValue.equals(""))
				developer = FValue.trim();
			else
				developer = null;
		if (FCode.equalsIgnoreCase("developeDate"))
			if (FValue != null && !FValue.equals(""))
				developeDate = fDate.getDate(FValue);
			else
				developeDate = null;
		if (FCode.equalsIgnoreCase("noTi"))
			if (FValue != null && !FValue.equals(""))
				noTi = FValue.trim();
			else
				noTi = null;
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
		if (FCode.equalsIgnoreCase("course1"))
			if (FValue != null && !FValue.equals(""))
				course1 = FValue.trim();
			else
				course1 = null;
		if (FCode.equalsIgnoreCase("course2"))
			if (FValue != null && !FValue.equals(""))
				course2 = FValue.trim();
			else
				course2 = null;
		if (FCode.equalsIgnoreCase("course3"))
			if (FValue != null && !FValue.equals(""))
				course3 = FValue.trim();
			else
				course3 = null;
		if (FCode.equalsIgnoreCase("course4"))
			if (FValue != null && !FValue.equals(""))
				course4 = fDate.getDate(FValue);
			else
				course4 = null;
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
		MCourseSchema other = (MCourseSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (courseID == null && other.getCourseID() != null)
			return false;
		if (courseID != null && !courseID.equals(other.getCourseID()))
			return false;
		if (courseName == null && other.getCourseName() != null)
			return false;
		if (courseName != null && !courseName.equals(other.getCourseName()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (hour == null && other.getHour() != null)
			return false;
		if (hour != null && !hour.equals(other.getHour()))
			return false;
		if (developBranch == null && other.getDevelopBranch() != null)
			return false;
		if (developBranch != null && !developBranch.equals(other.getDevelopBranch()))
			return false;
		if (developer == null && other.getDeveloper() != null)
			return false;
		if (developer != null && !developer.equals(other.getDeveloper()))
			return false;
		if (developeDate == null && other.getDevelopeDate() != null)
			return false;
		if (developeDate != null && !fDate.getString(developeDate).equals(other.getDevelopeDate()))
			return false;
		if (noTi == null && other.getNoTi() != null)
			return false;
		if (noTi != null && !noTi.equals(other.getNoTi()))
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
		if (course1 == null && other.getCourse1() != null)
			return false;
		if (course1 != null && !course1.equals(other.getCourse1()))
			return false;
		if (course2 == null && other.getCourse2() != null)
			return false;
		if (course2 != null && !course2.equals(other.getCourse2()))
			return false;
		if (course3 == null && other.getCourse3() != null)
			return false;
		if (course3 != null && !course3.equals(other.getCourse3()))
			return false;
		if (course4 == null && other.getCourse4() != null)
			return false;
		return course4 == null || fDate.getString(course4).equals(other.getCourse4());
	}

	public int getFieldCount()
	{
		return 20;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("courseID"))
			return 1;
		if (strFieldName.equals("courseName"))
			return 2;
		if (strFieldName.equals("manageCom"))
			return 3;
		if (strFieldName.equals("branchType"))
			return 4;
		if (strFieldName.equals("hour"))
			return 5;
		if (strFieldName.equals("developBranch"))
			return 6;
		if (strFieldName.equals("developer"))
			return 7;
		if (strFieldName.equals("developeDate"))
			return 8;
		if (strFieldName.equals("noTi"))
			return 9;
		if (strFieldName.equals("operator"))
			return 10;
		if (strFieldName.equals("modifyOperator"))
			return 11;
		if (strFieldName.equals("makeDate"))
			return 12;
		if (strFieldName.equals("makeTime"))
			return 13;
		if (strFieldName.equals("modifyDate"))
			return 14;
		if (strFieldName.equals("modifyTime"))
			return 15;
		if (strFieldName.equals("course1"))
			return 16;
		if (strFieldName.equals("course2"))
			return 17;
		if (strFieldName.equals("course3"))
			return 18;
		return !strFieldName.equals("course4") ? -1 : 19;
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
			strFieldName = "courseID";
			break;

		case 2: // '\002'
			strFieldName = "courseName";
			break;

		case 3: // '\003'
			strFieldName = "manageCom";
			break;

		case 4: // '\004'
			strFieldName = "branchType";
			break;

		case 5: // '\005'
			strFieldName = "hour";
			break;

		case 6: // '\006'
			strFieldName = "developBranch";
			break;

		case 7: // '\007'
			strFieldName = "developer";
			break;

		case 8: // '\b'
			strFieldName = "developeDate";
			break;

		case 9: // '\t'
			strFieldName = "noTi";
			break;

		case 10: // '\n'
			strFieldName = "operator";
			break;

		case 11: // '\013'
			strFieldName = "modifyOperator";
			break;

		case 12: // '\f'
			strFieldName = "makeDate";
			break;

		case 13: // '\r'
			strFieldName = "makeTime";
			break;

		case 14: // '\016'
			strFieldName = "modifyDate";
			break;

		case 15: // '\017'
			strFieldName = "modifyTime";
			break;

		case 16: // '\020'
			strFieldName = "course1";
			break;

		case 17: // '\021'
			strFieldName = "course2";
			break;

		case 18: // '\022'
			strFieldName = "course3";
			break;

		case 19: // '\023'
			strFieldName = "course4";
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
		if (strFieldName.equals("courseID"))
			return 0;
		if (strFieldName.equals("courseName"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("hour"))
			return 0;
		if (strFieldName.equals("developBranch"))
			return 0;
		if (strFieldName.equals("developer"))
			return 0;
		if (strFieldName.equals("developeDate"))
			return 1;
		if (strFieldName.equals("noTi"))
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
		if (strFieldName.equals("course1"))
			return 0;
		if (strFieldName.equals("course2"))
			return 0;
		if (strFieldName.equals("course3"))
			return 0;
		return !strFieldName.equals("course4") ? -1 : 1;
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
			nFieldType = 0;
			break;

		case 10: // '\n'
			nFieldType = 0;
			break;

		case 11: // '\013'
			nFieldType = 0;
			break;

		case 12: // '\f'
			nFieldType = 1;
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
			nFieldType = 1;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
