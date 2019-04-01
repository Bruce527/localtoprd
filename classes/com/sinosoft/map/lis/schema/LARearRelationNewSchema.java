// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LARearRelationNewSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.LARearRelationNewDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LARearRelationNewSchema
	implements Schema, Cloneable
{

	private String manageCom;
	private String agentCode;
	private String agentGrade;
	private String agentGroup;
	private String sMAgentCode;
	private String aMAgentCode;
	private String rAgentCode;
	private String agentTitle;
	private String rAgentGrade;
	private String rAgentTitle;
	private String rAgentGroup;
	private String rBranchAttr;
	private String type;
	private int deep;
	private Date startDate;
	private Date breakDate;
	private Date pBreakDate;
	private String breakType;
	private String state;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String operator;
	public static final int FIELDNUM = 24;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LARearRelationNewSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[5];
		pk[0] = "AgentCode";
		pk[1] = "RAgentCode";
		pk[2] = "Type";
		pk[3] = "Deep";
		pk[4] = "State";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LARearRelationNewSchema cloned = (LARearRelationNewSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
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

	public String getSMAgentCode()
	{
		return sMAgentCode;
	}

	public void setSMAgentCode(String aSMAgentCode)
	{
		sMAgentCode = aSMAgentCode;
	}

	public String getAMAgentCode()
	{
		return aMAgentCode;
	}

	public void setAMAgentCode(String aAMAgentCode)
	{
		aMAgentCode = aAMAgentCode;
	}

	public String getRAgentCode()
	{
		return rAgentCode;
	}

	public void setRAgentCode(String aRAgentCode)
	{
		rAgentCode = aRAgentCode;
	}

	public String getAgentTitle()
	{
		return agentTitle;
	}

	public void setAgentTitle(String aAgentTitle)
	{
		agentTitle = aAgentTitle;
	}

	public String getRAgentGrade()
	{
		return rAgentGrade;
	}

	public void setRAgentGrade(String aRAgentGrade)
	{
		rAgentGrade = aRAgentGrade;
	}

	public String getRAgentTitle()
	{
		return rAgentTitle;
	}

	public void setRAgentTitle(String aRAgentTitle)
	{
		rAgentTitle = aRAgentTitle;
	}

	public String getRAgentGroup()
	{
		return rAgentGroup;
	}

	public void setRAgentGroup(String aRAgentGroup)
	{
		rAgentGroup = aRAgentGroup;
	}

	public String getRBranchAttr()
	{
		return rBranchAttr;
	}

	public void setRBranchAttr(String aRBranchAttr)
	{
		rBranchAttr = aRBranchAttr;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
	}

	public int getDeep()
	{
		return deep;
	}

	public void setDeep(int aDeep)
	{
		deep = aDeep;
	}

	public void setDeep(String aDeep)
	{
		if (aDeep != null && !aDeep.equals(""))
		{
			Integer tInteger = new Integer(aDeep);
			int i = tInteger.intValue();
			deep = i;
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

	public String getBreakDate()
	{
		if (breakDate != null)
			return fDate.getString(breakDate);
		else
			return null;
	}

	public void setBreakDate(Date aBreakDate)
	{
		breakDate = aBreakDate;
	}

	public void setBreakDate(String aBreakDate)
	{
		if (aBreakDate != null && !aBreakDate.equals(""))
			breakDate = fDate.getDate(aBreakDate);
		else
			breakDate = null;
	}

	public String getPBreakDate()
	{
		if (pBreakDate != null)
			return fDate.getString(pBreakDate);
		else
			return null;
	}

	public void setPBreakDate(Date aPBreakDate)
	{
		pBreakDate = aPBreakDate;
	}

	public void setPBreakDate(String aPBreakDate)
	{
		if (aPBreakDate != null && !aPBreakDate.equals(""))
			pBreakDate = fDate.getDate(aPBreakDate);
		else
			pBreakDate = null;
	}

	public String getBreakType()
	{
		return breakType;
	}

	public void setBreakType(String aBreakType)
	{
		breakType = aBreakType;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
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

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public void setSchema(LARearRelationNewSchema aLARearRelationNewSchema)
	{
		manageCom = aLARearRelationNewSchema.getManageCom();
		agentCode = aLARearRelationNewSchema.getAgentCode();
		agentGrade = aLARearRelationNewSchema.getAgentGrade();
		agentGroup = aLARearRelationNewSchema.getAgentGroup();
		sMAgentCode = aLARearRelationNewSchema.getSMAgentCode();
		aMAgentCode = aLARearRelationNewSchema.getAMAgentCode();
		rAgentCode = aLARearRelationNewSchema.getRAgentCode();
		agentTitle = aLARearRelationNewSchema.getAgentTitle();
		rAgentGrade = aLARearRelationNewSchema.getRAgentGrade();
		rAgentTitle = aLARearRelationNewSchema.getRAgentTitle();
		rAgentGroup = aLARearRelationNewSchema.getRAgentGroup();
		rBranchAttr = aLARearRelationNewSchema.getRBranchAttr();
		type = aLARearRelationNewSchema.getType();
		deep = aLARearRelationNewSchema.getDeep();
		startDate = fDate.getDate(aLARearRelationNewSchema.getStartDate());
		breakDate = fDate.getDate(aLARearRelationNewSchema.getBreakDate());
		pBreakDate = fDate.getDate(aLARearRelationNewSchema.getPBreakDate());
		breakType = aLARearRelationNewSchema.getBreakType();
		state = aLARearRelationNewSchema.getState();
		makeDate = fDate.getDate(aLARearRelationNewSchema.getMakeDate());
		makeTime = aLARearRelationNewSchema.getMakeTime();
		modifyDate = fDate.getDate(aLARearRelationNewSchema.getModifyDate());
		modifyTime = aLARearRelationNewSchema.getModifyTime();
		operator = aLARearRelationNewSchema.getOperator();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("AgentGrade") == null)
				agentGrade = null;
			else
				agentGrade = rs.getString("AgentGrade").trim();
			if (rs.getString("AgentGroup") == null)
				agentGroup = null;
			else
				agentGroup = rs.getString("AgentGroup").trim();
			if (rs.getString("SMAgentCode") == null)
				sMAgentCode = null;
			else
				sMAgentCode = rs.getString("SMAgentCode").trim();
			if (rs.getString("AMAgentCode") == null)
				aMAgentCode = null;
			else
				aMAgentCode = rs.getString("AMAgentCode").trim();
			if (rs.getString("RAgentCode") == null)
				rAgentCode = null;
			else
				rAgentCode = rs.getString("RAgentCode").trim();
			if (rs.getString("AgentTitle") == null)
				agentTitle = null;
			else
				agentTitle = rs.getString("AgentTitle").trim();
			if (rs.getString("RAgentGrade") == null)
				rAgentGrade = null;
			else
				rAgentGrade = rs.getString("RAgentGrade").trim();
			if (rs.getString("RAgentTitle") == null)
				rAgentTitle = null;
			else
				rAgentTitle = rs.getString("RAgentTitle").trim();
			if (rs.getString("RAgentGroup") == null)
				rAgentGroup = null;
			else
				rAgentGroup = rs.getString("RAgentGroup").trim();
			if (rs.getString("RBranchAttr") == null)
				rBranchAttr = null;
			else
				rBranchAttr = rs.getString("RBranchAttr").trim();
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
			deep = rs.getInt("Deep");
			startDate = rs.getDate("StartDate");
			breakDate = rs.getDate("BreakDate");
			pBreakDate = rs.getDate("PBreakDate");
			if (rs.getString("BreakType") == null)
				breakType = null;
			else
				breakType = rs.getString("BreakType").trim();
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
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
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LARearRelationNew表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LARearRelationNewSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LARearRelationNewSchema getSchema()
	{
		LARearRelationNewSchema aLARearRelationNewSchema = new LARearRelationNewSchema();
		aLARearRelationNewSchema.setSchema(this);
		return aLARearRelationNewSchema;
	}

	public LARearRelationNewDB getDB()
	{
		LARearRelationNewDB aDBOper = new LARearRelationNewDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGroup));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sMAgentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(aMAgentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rAgentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentTitle));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rAgentGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rAgentTitle));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rAgentGroup));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rBranchAttr));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(type));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(deep));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(breakDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(pBreakDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(breakType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			sMAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			aMAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			rAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			agentTitle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			rAgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			rAgentTitle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			rAgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			rBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			deep = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|")))).intValue();
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			breakDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
			pBreakDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|"));
			breakType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LARearRelationNewSchema";
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
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("agentGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGrade));
		if (FCode.equalsIgnoreCase("agentGroup"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup));
		if (FCode.equalsIgnoreCase("sMAgentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMAgentCode));
		if (FCode.equalsIgnoreCase("aMAgentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMAgentCode));
		if (FCode.equalsIgnoreCase("rAgentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rAgentCode));
		if (FCode.equalsIgnoreCase("agentTitle"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentTitle));
		if (FCode.equalsIgnoreCase("rAgentGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rAgentGrade));
		if (FCode.equalsIgnoreCase("rAgentTitle"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rAgentTitle));
		if (FCode.equalsIgnoreCase("rAgentGroup"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rAgentGroup));
		if (FCode.equalsIgnoreCase("rBranchAttr"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rBranchAttr));
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
		if (FCode.equalsIgnoreCase("deep"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(deep));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("breakDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getBreakDate()));
		if (FCode.equalsIgnoreCase("pBreakDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getPBreakDate()));
		if (FCode.equalsIgnoreCase("breakType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(breakType));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
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
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(agentGrade);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(agentGroup);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(sMAgentCode);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(aMAgentCode);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(rAgentCode);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(agentTitle);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(rAgentGrade);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(rAgentTitle);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(rAgentGroup);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(rBranchAttr);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 13: // '\r'
			strFieldValue = String.valueOf(deep);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBreakDate()));
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getPBreakDate()));
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(breakType);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(state);
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
			strFieldValue = StrTool.GBKToUnicode(operator);
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
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
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
		if (FCode.equalsIgnoreCase("sMAgentCode"))
			if (FValue != null && !FValue.equals(""))
				sMAgentCode = FValue.trim();
			else
				sMAgentCode = null;
		if (FCode.equalsIgnoreCase("aMAgentCode"))
			if (FValue != null && !FValue.equals(""))
				aMAgentCode = FValue.trim();
			else
				aMAgentCode = null;
		if (FCode.equalsIgnoreCase("rAgentCode"))
			if (FValue != null && !FValue.equals(""))
				rAgentCode = FValue.trim();
			else
				rAgentCode = null;
		if (FCode.equalsIgnoreCase("agentTitle"))
			if (FValue != null && !FValue.equals(""))
				agentTitle = FValue.trim();
			else
				agentTitle = null;
		if (FCode.equalsIgnoreCase("rAgentGrade"))
			if (FValue != null && !FValue.equals(""))
				rAgentGrade = FValue.trim();
			else
				rAgentGrade = null;
		if (FCode.equalsIgnoreCase("rAgentTitle"))
			if (FValue != null && !FValue.equals(""))
				rAgentTitle = FValue.trim();
			else
				rAgentTitle = null;
		if (FCode.equalsIgnoreCase("rAgentGroup"))
			if (FValue != null && !FValue.equals(""))
				rAgentGroup = FValue.trim();
			else
				rAgentGroup = null;
		if (FCode.equalsIgnoreCase("rBranchAttr"))
			if (FValue != null && !FValue.equals(""))
				rBranchAttr = FValue.trim();
			else
				rBranchAttr = null;
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
		if (FCode.equalsIgnoreCase("deep") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			deep = i;
		}
		if (FCode.equalsIgnoreCase("startDate"))
			if (FValue != null && !FValue.equals(""))
				startDate = fDate.getDate(FValue);
			else
				startDate = null;
		if (FCode.equalsIgnoreCase("breakDate"))
			if (FValue != null && !FValue.equals(""))
				breakDate = fDate.getDate(FValue);
			else
				breakDate = null;
		if (FCode.equalsIgnoreCase("pBreakDate"))
			if (FValue != null && !FValue.equals(""))
				pBreakDate = fDate.getDate(FValue);
			else
				pBreakDate = null;
		if (FCode.equalsIgnoreCase("breakType"))
			if (FValue != null && !FValue.equals(""))
				breakType = FValue.trim();
			else
				breakType = null;
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
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
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
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
		LARearRelationNewSchema other = (LARearRelationNewSchema)otherObject;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (agentGrade == null && other.getAgentGrade() != null)
			return false;
		if (agentGrade != null && !agentGrade.equals(other.getAgentGrade()))
			return false;
		if (agentGroup == null && other.getAgentGroup() != null)
			return false;
		if (agentGroup != null && !agentGroup.equals(other.getAgentGroup()))
			return false;
		if (sMAgentCode == null && other.getSMAgentCode() != null)
			return false;
		if (sMAgentCode != null && !sMAgentCode.equals(other.getSMAgentCode()))
			return false;
		if (aMAgentCode == null && other.getAMAgentCode() != null)
			return false;
		if (aMAgentCode != null && !aMAgentCode.equals(other.getAMAgentCode()))
			return false;
		if (rAgentCode == null && other.getRAgentCode() != null)
			return false;
		if (rAgentCode != null && !rAgentCode.equals(other.getRAgentCode()))
			return false;
		if (agentTitle == null && other.getAgentTitle() != null)
			return false;
		if (agentTitle != null && !agentTitle.equals(other.getAgentTitle()))
			return false;
		if (rAgentGrade == null && other.getRAgentGrade() != null)
			return false;
		if (rAgentGrade != null && !rAgentGrade.equals(other.getRAgentGrade()))
			return false;
		if (rAgentTitle == null && other.getRAgentTitle() != null)
			return false;
		if (rAgentTitle != null && !rAgentTitle.equals(other.getRAgentTitle()))
			return false;
		if (rAgentGroup == null && other.getRAgentGroup() != null)
			return false;
		if (rAgentGroup != null && !rAgentGroup.equals(other.getRAgentGroup()))
			return false;
		if (rBranchAttr == null && other.getRBranchAttr() != null)
			return false;
		if (rBranchAttr != null && !rBranchAttr.equals(other.getRBranchAttr()))
			return false;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
			return false;
		if (deep != other.getDeep())
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (breakDate == null && other.getBreakDate() != null)
			return false;
		if (breakDate != null && !fDate.getString(breakDate).equals(other.getBreakDate()))
			return false;
		if (pBreakDate == null && other.getPBreakDate() != null)
			return false;
		if (pBreakDate != null && !fDate.getString(pBreakDate).equals(other.getPBreakDate()))
			return false;
		if (breakType == null && other.getBreakType() != null)
			return false;
		if (breakType != null && !breakType.equals(other.getBreakType()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
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
		if (operator == null && other.getOperator() != null)
			return false;
		return operator == null || operator.equals(other.getOperator());
	}

	public int getFieldCount()
	{
		return 24;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 1;
		if (strFieldName.equals("agentGrade"))
			return 2;
		if (strFieldName.equals("agentGroup"))
			return 3;
		if (strFieldName.equals("sMAgentCode"))
			return 4;
		if (strFieldName.equals("aMAgentCode"))
			return 5;
		if (strFieldName.equals("rAgentCode"))
			return 6;
		if (strFieldName.equals("agentTitle"))
			return 7;
		if (strFieldName.equals("rAgentGrade"))
			return 8;
		if (strFieldName.equals("rAgentTitle"))
			return 9;
		if (strFieldName.equals("rAgentGroup"))
			return 10;
		if (strFieldName.equals("rBranchAttr"))
			return 11;
		if (strFieldName.equals("type"))
			return 12;
		if (strFieldName.equals("deep"))
			return 13;
		if (strFieldName.equals("startDate"))
			return 14;
		if (strFieldName.equals("breakDate"))
			return 15;
		if (strFieldName.equals("pBreakDate"))
			return 16;
		if (strFieldName.equals("breakType"))
			return 17;
		if (strFieldName.equals("state"))
			return 18;
		if (strFieldName.equals("makeDate"))
			return 19;
		if (strFieldName.equals("makeTime"))
			return 20;
		if (strFieldName.equals("modifyDate"))
			return 21;
		if (strFieldName.equals("modifyTime"))
			return 22;
		return !strFieldName.equals("operator") ? -1 : 23;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "manageCom";
			break;

		case 1: // '\001'
			strFieldName = "agentCode";
			break;

		case 2: // '\002'
			strFieldName = "agentGrade";
			break;

		case 3: // '\003'
			strFieldName = "agentGroup";
			break;

		case 4: // '\004'
			strFieldName = "sMAgentCode";
			break;

		case 5: // '\005'
			strFieldName = "aMAgentCode";
			break;

		case 6: // '\006'
			strFieldName = "rAgentCode";
			break;

		case 7: // '\007'
			strFieldName = "agentTitle";
			break;

		case 8: // '\b'
			strFieldName = "rAgentGrade";
			break;

		case 9: // '\t'
			strFieldName = "rAgentTitle";
			break;

		case 10: // '\n'
			strFieldName = "rAgentGroup";
			break;

		case 11: // '\013'
			strFieldName = "rBranchAttr";
			break;

		case 12: // '\f'
			strFieldName = "type";
			break;

		case 13: // '\r'
			strFieldName = "deep";
			break;

		case 14: // '\016'
			strFieldName = "startDate";
			break;

		case 15: // '\017'
			strFieldName = "breakDate";
			break;

		case 16: // '\020'
			strFieldName = "pBreakDate";
			break;

		case 17: // '\021'
			strFieldName = "breakType";
			break;

		case 18: // '\022'
			strFieldName = "state";
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
			strFieldName = "operator";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("agentGrade"))
			return 0;
		if (strFieldName.equals("agentGroup"))
			return 0;
		if (strFieldName.equals("sMAgentCode"))
			return 0;
		if (strFieldName.equals("aMAgentCode"))
			return 0;
		if (strFieldName.equals("rAgentCode"))
			return 0;
		if (strFieldName.equals("agentTitle"))
			return 0;
		if (strFieldName.equals("rAgentGrade"))
			return 0;
		if (strFieldName.equals("rAgentTitle"))
			return 0;
		if (strFieldName.equals("rAgentGroup"))
			return 0;
		if (strFieldName.equals("rBranchAttr"))
			return 0;
		if (strFieldName.equals("type"))
			return 0;
		if (strFieldName.equals("deep"))
			return 3;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("breakDate"))
			return 1;
		if (strFieldName.equals("pBreakDate"))
			return 1;
		if (strFieldName.equals("breakType"))
			return 0;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		if (strFieldName.equals("modifyTime"))
			return 0;
		return !strFieldName.equals("operator") ? -1 : 0;
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
			nFieldType = 3;
			break;

		case 14: // '\016'
			nFieldType = 1;
			break;

		case 15: // '\017'
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
