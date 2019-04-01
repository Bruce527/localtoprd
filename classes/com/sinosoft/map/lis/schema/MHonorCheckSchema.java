// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MHonorCheckSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MHonorCheckDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MHonorCheckSchema
	implements Schema, Cloneable
{

	private String checkID;
	private String dataType;
	private String statYear;
	private String manageCom;
	private String branchType;
	private String statBatch;
	private Date startDate;
	private Date endDate;
	private String checkState;
	private String inputState;
	private String checkOperator;
	private String checkReason;
	private Date checkDate;
	private String checkTime;
	private String modifyOperator;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 20;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MHonorCheckSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "CheckID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MHonorCheckSchema cloned = (MHonorCheckSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getCheckID()
	{
		return checkID;
	}

	public void setCheckID(String aCheckID)
	{
		checkID = aCheckID;
	}

	public String getDataType()
	{
		return dataType;
	}

	public void setDataType(String aDataType)
	{
		dataType = aDataType;
	}

	public String getStatYear()
	{
		return statYear;
	}

	public void setStatYear(String aStatYear)
	{
		statYear = aStatYear;
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

	public String getStatBatch()
	{
		return statBatch;
	}

	public void setStatBatch(String aStatBatch)
	{
		statBatch = aStatBatch;
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

	public String getCheckState()
	{
		return checkState;
	}

	public void setCheckState(String aCheckState)
	{
		checkState = aCheckState;
	}

	public String getInputState()
	{
		return inputState;
	}

	public void setInputState(String aInputState)
	{
		inputState = aInputState;
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

	public void setSchema(MHonorCheckSchema aMHonorCheckSchema)
	{
		checkID = aMHonorCheckSchema.getCheckID();
		dataType = aMHonorCheckSchema.getDataType();
		statYear = aMHonorCheckSchema.getStatYear();
		manageCom = aMHonorCheckSchema.getManageCom();
		branchType = aMHonorCheckSchema.getBranchType();
		statBatch = aMHonorCheckSchema.getStatBatch();
		startDate = fDate.getDate(aMHonorCheckSchema.getStartDate());
		endDate = fDate.getDate(aMHonorCheckSchema.getEndDate());
		checkState = aMHonorCheckSchema.getCheckState();
		inputState = aMHonorCheckSchema.getInputState();
		checkOperator = aMHonorCheckSchema.getCheckOperator();
		checkReason = aMHonorCheckSchema.getCheckReason();
		checkDate = fDate.getDate(aMHonorCheckSchema.getCheckDate());
		checkTime = aMHonorCheckSchema.getCheckTime();
		modifyOperator = aMHonorCheckSchema.getModifyOperator();
		operator = aMHonorCheckSchema.getOperator();
		makeDate = fDate.getDate(aMHonorCheckSchema.getMakeDate());
		makeTime = aMHonorCheckSchema.getMakeTime();
		modifyDate = fDate.getDate(aMHonorCheckSchema.getModifyDate());
		modifyTime = aMHonorCheckSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("CheckID") == null)
				checkID = null;
			else
				checkID = rs.getString("CheckID").trim();
			if (rs.getString("DataType") == null)
				dataType = null;
			else
				dataType = rs.getString("DataType").trim();
			if (rs.getString("StatYear") == null)
				statYear = null;
			else
				statYear = rs.getString("StatYear").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			if (rs.getString("StatBatch") == null)
				statBatch = null;
			else
				statBatch = rs.getString("StatBatch").trim();
			startDate = rs.getDate("StartDate");
			endDate = rs.getDate("EndDate");
			if (rs.getString("CheckState") == null)
				checkState = null;
			else
				checkState = rs.getString("CheckState").trim();
			if (rs.getString("InputState") == null)
				inputState = null;
			else
				inputState = rs.getString("InputState").trim();
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
			System.out.println("数据库中的MHonorCheck表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MHonorCheckSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MHonorCheckSchema getSchema()
	{
		MHonorCheckSchema aMHonorCheckSchema = new MHonorCheckSchema();
		aMHonorCheckSchema.setSchema(this);
		return aMHonorCheckSchema;
	}

	public MHonorCheckDB getDB()
	{
		MHonorCheckDB aDBOper = new MHonorCheckDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(checkID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(dataType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(statYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(statBatch));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(endDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkState));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(inputState));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkOperator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkReason));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(checkDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkTime));
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
			checkID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			dataType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			statYear = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			statBatch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			inputState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			checkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
			checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MHonorCheckSchema";
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
		if (FCode.equalsIgnoreCase("checkID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkID));
		if (FCode.equalsIgnoreCase("dataType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dataType));
		if (FCode.equalsIgnoreCase("statYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(statYear));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("statBatch"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(statBatch));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("endDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
		if (FCode.equalsIgnoreCase("checkState"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkState));
		if (FCode.equalsIgnoreCase("inputState"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(inputState));
		if (FCode.equalsIgnoreCase("checkOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkOperator));
		if (FCode.equalsIgnoreCase("checkReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkReason));
		if (FCode.equalsIgnoreCase("checkDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
		if (FCode.equalsIgnoreCase("checkTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkTime));
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
			strFieldValue = StrTool.GBKToUnicode(checkID);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(dataType);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(statYear);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(statBatch);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(checkState);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(inputState);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(checkOperator);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(checkReason);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(checkTime);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
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
		if (FCode.equalsIgnoreCase("checkID"))
			if (FValue != null && !FValue.equals(""))
				checkID = FValue.trim();
			else
				checkID = null;
		if (FCode.equalsIgnoreCase("dataType"))
			if (FValue != null && !FValue.equals(""))
				dataType = FValue.trim();
			else
				dataType = null;
		if (FCode.equalsIgnoreCase("statYear"))
			if (FValue != null && !FValue.equals(""))
				statYear = FValue.trim();
			else
				statYear = null;
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
		if (FCode.equalsIgnoreCase("statBatch"))
			if (FValue != null && !FValue.equals(""))
				statBatch = FValue.trim();
			else
				statBatch = null;
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
		if (FCode.equalsIgnoreCase("checkState"))
			if (FValue != null && !FValue.equals(""))
				checkState = FValue.trim();
			else
				checkState = null;
		if (FCode.equalsIgnoreCase("inputState"))
			if (FValue != null && !FValue.equals(""))
				inputState = FValue.trim();
			else
				inputState = null;
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
		MHonorCheckSchema other = (MHonorCheckSchema)otherObject;
		if (checkID == null && other.getCheckID() != null)
			return false;
		if (checkID != null && !checkID.equals(other.getCheckID()))
			return false;
		if (dataType == null && other.getDataType() != null)
			return false;
		if (dataType != null && !dataType.equals(other.getDataType()))
			return false;
		if (statYear == null && other.getStatYear() != null)
			return false;
		if (statYear != null && !statYear.equals(other.getStatYear()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (statBatch == null && other.getStatBatch() != null)
			return false;
		if (statBatch != null && !statBatch.equals(other.getStatBatch()))
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (endDate == null && other.getEndDate() != null)
			return false;
		if (endDate != null && !fDate.getString(endDate).equals(other.getEndDate()))
			return false;
		if (checkState == null && other.getCheckState() != null)
			return false;
		if (checkState != null && !checkState.equals(other.getCheckState()))
			return false;
		if (inputState == null && other.getInputState() != null)
			return false;
		if (inputState != null && !inputState.equals(other.getInputState()))
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
		return 20;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("checkID"))
			return 0;
		if (strFieldName.equals("dataType"))
			return 1;
		if (strFieldName.equals("statYear"))
			return 2;
		if (strFieldName.equals("manageCom"))
			return 3;
		if (strFieldName.equals("branchType"))
			return 4;
		if (strFieldName.equals("statBatch"))
			return 5;
		if (strFieldName.equals("startDate"))
			return 6;
		if (strFieldName.equals("endDate"))
			return 7;
		if (strFieldName.equals("checkState"))
			return 8;
		if (strFieldName.equals("inputState"))
			return 9;
		if (strFieldName.equals("checkOperator"))
			return 10;
		if (strFieldName.equals("checkReason"))
			return 11;
		if (strFieldName.equals("checkDate"))
			return 12;
		if (strFieldName.equals("checkTime"))
			return 13;
		if (strFieldName.equals("modifyOperator"))
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
			strFieldName = "checkID";
			break;

		case 1: // '\001'
			strFieldName = "dataType";
			break;

		case 2: // '\002'
			strFieldName = "statYear";
			break;

		case 3: // '\003'
			strFieldName = "manageCom";
			break;

		case 4: // '\004'
			strFieldName = "branchType";
			break;

		case 5: // '\005'
			strFieldName = "statBatch";
			break;

		case 6: // '\006'
			strFieldName = "startDate";
			break;

		case 7: // '\007'
			strFieldName = "endDate";
			break;

		case 8: // '\b'
			strFieldName = "checkState";
			break;

		case 9: // '\t'
			strFieldName = "inputState";
			break;

		case 10: // '\n'
			strFieldName = "checkOperator";
			break;

		case 11: // '\013'
			strFieldName = "checkReason";
			break;

		case 12: // '\f'
			strFieldName = "checkDate";
			break;

		case 13: // '\r'
			strFieldName = "checkTime";
			break;

		case 14: // '\016'
			strFieldName = "modifyOperator";
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
		if (strFieldName.equals("checkID"))
			return 0;
		if (strFieldName.equals("dataType"))
			return 0;
		if (strFieldName.equals("statYear"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("statBatch"))
			return 0;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("endDate"))
			return 1;
		if (strFieldName.equals("checkState"))
			return 0;
		if (strFieldName.equals("inputState"))
			return 0;
		if (strFieldName.equals("checkOperator"))
			return 0;
		if (strFieldName.equals("checkReason"))
			return 0;
		if (strFieldName.equals("checkDate"))
			return 1;
		if (strFieldName.equals("checkTime"))
			return 0;
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
			nFieldType = 1;
			break;

		case 7: // '\007'
			nFieldType = 1;
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
			nFieldType = 1;
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
