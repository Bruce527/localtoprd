// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLinkSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MLinkDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MLinkSchema
	implements Schema, Cloneable
{

	private String iD;
	private String agentCode;
	private String refURL;
	private String target;
	private String name;
	private int linkOrder;
	private String state;
	private String type;
	private String icon;
	private String manageCom;
	private String branchType;
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
	private String description;
	public static final int FIELDNUM = 23;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MLinkSchema()
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
		MLinkSchema cloned = (MLinkSchema)super.clone();
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

	public String getRefURL()
	{
		return refURL;
	}

	public void setRefURL(String aRefURL)
	{
		refURL = aRefURL;
	}

	public String getTarget()
	{
		return target;
	}

	public void setTarget(String aTarget)
	{
		target = aTarget;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String aName)
	{
		name = aName;
	}

	public int getLinkOrder()
	{
		return linkOrder;
	}

	public void setLinkOrder(int aLinkOrder)
	{
		linkOrder = aLinkOrder;
	}

	public void setLinkOrder(String aLinkOrder)
	{
		if (aLinkOrder != null && !aLinkOrder.equals(""))
		{
			Integer tInteger = new Integer(aLinkOrder);
			int i = tInteger.intValue();
			linkOrder = i;
		}
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String aIcon)
	{
		icon = aIcon;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String aDescription)
	{
		description = aDescription;
	}

	public void setSchema(MLinkSchema aMLinkSchema)
	{
		iD = aMLinkSchema.getID();
		agentCode = aMLinkSchema.getAgentCode();
		refURL = aMLinkSchema.getRefURL();
		target = aMLinkSchema.getTarget();
		name = aMLinkSchema.getName();
		linkOrder = aMLinkSchema.getLinkOrder();
		state = aMLinkSchema.getState();
		type = aMLinkSchema.getType();
		icon = aMLinkSchema.getIcon();
		manageCom = aMLinkSchema.getManageCom();
		branchType = aMLinkSchema.getBranchType();
		vF01 = aMLinkSchema.getVF01();
		nF01 = aMLinkSchema.getNF01();
		iF01 = aMLinkSchema.getIF01();
		dF02 = aMLinkSchema.getDF02();
		date01 = fDate.getDate(aMLinkSchema.getDate01());
		modifyOperator = aMLinkSchema.getModifyOperator();
		operator = aMLinkSchema.getOperator();
		makeDate = fDate.getDate(aMLinkSchema.getMakeDate());
		makeTime = aMLinkSchema.getMakeTime();
		modifyDate = fDate.getDate(aMLinkSchema.getModifyDate());
		modifyTime = aMLinkSchema.getModifyTime();
		description = aMLinkSchema.getDescription();
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
			if (rs.getString("RefURL") == null)
				refURL = null;
			else
				refURL = rs.getString("RefURL").trim();
			if (rs.getString("Target") == null)
				target = null;
			else
				target = rs.getString("Target").trim();
			if (rs.getString("Name") == null)
				name = null;
			else
				name = rs.getString("Name").trim();
			linkOrder = rs.getInt("LinkOrder");
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
			if (rs.getString("Icon") == null)
				icon = null;
			else
				icon = rs.getString("Icon").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
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
			if (rs.getString("Description") == null)
				description = null;
			else
				description = rs.getString("Description").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("���ݿ��е�MLink���ֶθ�����Schema�е��ֶθ�����һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "MLinkSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MLinkSchema getSchema()
	{
		MLinkSchema aMLinkSchema = new MLinkSchema();
		aMLinkSchema.setSchema(this);
		return aMLinkSchema;
	}

	public MLinkDB getDB()
	{
		MLinkDB aDBOper = new MLinkDB();
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
		strReturn.append(StrTool.cTrim(refURL));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(target));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(name));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(linkOrder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(type));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(icon));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
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
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(description));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			refURL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			target = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			linkOrder = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).intValue();
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			icon = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MLinkSchema";
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
		if (FCode.equalsIgnoreCase("refURL"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(refURL));
		if (FCode.equalsIgnoreCase("target"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(target));
		if (FCode.equalsIgnoreCase("name"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(name));
		if (FCode.equalsIgnoreCase("linkOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(linkOrder));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
		if (FCode.equalsIgnoreCase("icon"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(icon));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
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
		if (FCode.equalsIgnoreCase("description"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(description));
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
			strFieldValue = StrTool.GBKToUnicode(refURL);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(target);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(name);
			break;

		case 5: // '\005'
			strFieldValue = String.valueOf(linkOrder);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(icon);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(vF01);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(nF01);
			break;

		case 13: // '\r'
			strFieldValue = String.valueOf(iF01);
			break;

		case 14: // '\016'
			strFieldValue = String.valueOf(dF02);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(description);
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
		if (FCode.equalsIgnoreCase("refURL"))
			if (FValue != null && !FValue.equals(""))
				refURL = FValue.trim();
			else
				refURL = null;
		if (FCode.equalsIgnoreCase("target"))
			if (FValue != null && !FValue.equals(""))
				target = FValue.trim();
			else
				target = null;
		if (FCode.equalsIgnoreCase("name"))
			if (FValue != null && !FValue.equals(""))
				name = FValue.trim();
			else
				name = null;
		if (FCode.equalsIgnoreCase("linkOrder") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			linkOrder = i;
		}
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
		if (FCode.equalsIgnoreCase("icon"))
			if (FValue != null && !FValue.equals(""))
				icon = FValue.trim();
			else
				icon = null;
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
		if (FCode.equalsIgnoreCase("description"))
			if (FValue != null && !FValue.equals(""))
				description = FValue.trim();
			else
				description = null;
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
		MLinkSchema other = (MLinkSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (refURL == null && other.getRefURL() != null)
			return false;
		if (refURL != null && !refURL.equals(other.getRefURL()))
			return false;
		if (target == null && other.getTarget() != null)
			return false;
		if (target != null && !target.equals(other.getTarget()))
			return false;
		if (name == null && other.getName() != null)
			return false;
		if (name != null && !name.equals(other.getName()))
			return false;
		if (linkOrder != other.getLinkOrder())
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
			return false;
		if (icon == null && other.getIcon() != null)
			return false;
		if (icon != null && !icon.equals(other.getIcon()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
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
		if (modifyTime != null && !modifyTime.equals(other.getModifyTime()))
			return false;
		if (description == null && other.getDescription() != null)
			return false;
		return description == null || description.equals(other.getDescription());
	}

	public int getFieldCount()
	{
		return 23;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 1;
		if (strFieldName.equals("refURL"))
			return 2;
		if (strFieldName.equals("target"))
			return 3;
		if (strFieldName.equals("name"))
			return 4;
		if (strFieldName.equals("linkOrder"))
			return 5;
		if (strFieldName.equals("state"))
			return 6;
		if (strFieldName.equals("type"))
			return 7;
		if (strFieldName.equals("icon"))
			return 8;
		if (strFieldName.equals("manageCom"))
			return 9;
		if (strFieldName.equals("branchType"))
			return 10;
		if (strFieldName.equals("vF01"))
			return 11;
		if (strFieldName.equals("nF01"))
			return 12;
		if (strFieldName.equals("iF01"))
			return 13;
		if (strFieldName.equals("dF02"))
			return 14;
		if (strFieldName.equals("date01"))
			return 15;
		if (strFieldName.equals("modifyOperator"))
			return 16;
		if (strFieldName.equals("operator"))
			return 17;
		if (strFieldName.equals("makeDate"))
			return 18;
		if (strFieldName.equals("makeTime"))
			return 19;
		if (strFieldName.equals("modifyDate"))
			return 20;
		if (strFieldName.equals("modifyTime"))
			return 21;
		return !strFieldName.equals("description") ? -1 : 22;
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
			strFieldName = "refURL";
			break;

		case 3: // '\003'
			strFieldName = "target";
			break;

		case 4: // '\004'
			strFieldName = "name";
			break;

		case 5: // '\005'
			strFieldName = "linkOrder";
			break;

		case 6: // '\006'
			strFieldName = "state";
			break;

		case 7: // '\007'
			strFieldName = "type";
			break;

		case 8: // '\b'
			strFieldName = "icon";
			break;

		case 9: // '\t'
			strFieldName = "manageCom";
			break;

		case 10: // '\n'
			strFieldName = "branchType";
			break;

		case 11: // '\013'
			strFieldName = "vF01";
			break;

		case 12: // '\f'
			strFieldName = "nF01";
			break;

		case 13: // '\r'
			strFieldName = "iF01";
			break;

		case 14: // '\016'
			strFieldName = "dF02";
			break;

		case 15: // '\017'
			strFieldName = "date01";
			break;

		case 16: // '\020'
			strFieldName = "modifyOperator";
			break;

		case 17: // '\021'
			strFieldName = "operator";
			break;

		case 18: // '\022'
			strFieldName = "makeDate";
			break;

		case 19: // '\023'
			strFieldName = "makeTime";
			break;

		case 20: // '\024'
			strFieldName = "modifyDate";
			break;

		case 21: // '\025'
			strFieldName = "modifyTime";
			break;

		case 22: // '\026'
			strFieldName = "description";
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
		if (strFieldName.equals("refURL"))
			return 0;
		if (strFieldName.equals("target"))
			return 0;
		if (strFieldName.equals("name"))
			return 0;
		if (strFieldName.equals("linkOrder"))
			return 3;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("type"))
			return 0;
		if (strFieldName.equals("icon"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("branchType"))
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
		if (strFieldName.equals("modifyTime"))
			return 0;
		return !strFieldName.equals("description") ? -1 : 0;
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
			nFieldType = 3;
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
			nFieldType = 4;
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
			nFieldType = 1;
			break;

		case 19: // '\023'
			nFieldType = 0;
			break;

		case 20: // '\024'
			nFieldType = 1;
			break;

		case 21: // '\025'
			nFieldType = 0;
			break;

		case 22: // '\026'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
