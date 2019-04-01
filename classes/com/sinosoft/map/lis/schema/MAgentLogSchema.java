// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MAgentLogSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MAgentLogDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MAgentLogSchema
	implements Schema, Cloneable
{

	private String iD;
	private String agentCode;
	private String userType;
	private String traceType;
	private String menuID;
	private String menuName;
	private String operation;
	private String discription;
	private String cientIP;
	private Date makeDate;
	private String makeTime;
	public static final int FIELDNUM = 11;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MAgentLogSchema()
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
		MAgentLogSchema cloned = (MAgentLogSchema)super.clone();
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

	public String getUserType()
	{
		return userType;
	}

	public void setUserType(String aUserType)
	{
		userType = aUserType;
	}

	public String getTraceType()
	{
		return traceType;
	}

	public void setTraceType(String aTraceType)
	{
		traceType = aTraceType;
	}

	public String getMenuID()
	{
		return menuID;
	}

	public void setMenuID(String aMenuID)
	{
		menuID = aMenuID;
	}

	public String getMenuName()
	{
		return menuName;
	}

	public void setMenuName(String aMenuName)
	{
		menuName = aMenuName;
	}

	public String getOperation()
	{
		return operation;
	}

	public void setOperation(String aOperation)
	{
		operation = aOperation;
	}

	public String getDiscription()
	{
		return discription;
	}

	public void setDiscription(String aDiscription)
	{
		discription = aDiscription;
	}

	public String getCientIP()
	{
		return cientIP;
	}

	public void setCientIP(String aCientIP)
	{
		cientIP = aCientIP;
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

	public void setSchema(MAgentLogSchema aMAgentLogSchema)
	{
		iD = aMAgentLogSchema.getID();
		agentCode = aMAgentLogSchema.getAgentCode();
		userType = aMAgentLogSchema.getUserType();
		traceType = aMAgentLogSchema.getTraceType();
		menuID = aMAgentLogSchema.getMenuID();
		menuName = aMAgentLogSchema.getMenuName();
		operation = aMAgentLogSchema.getOperation();
		discription = aMAgentLogSchema.getDiscription();
		cientIP = aMAgentLogSchema.getCientIP();
		makeDate = fDate.getDate(aMAgentLogSchema.getMakeDate());
		makeTime = aMAgentLogSchema.getMakeTime();
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
			if (rs.getString("UserType") == null)
				userType = null;
			else
				userType = rs.getString("UserType").trim();
			if (rs.getString("TraceType") == null)
				traceType = null;
			else
				traceType = rs.getString("TraceType").trim();
			if (rs.getString("MenuID") == null)
				menuID = null;
			else
				menuID = rs.getString("MenuID").trim();
			if (rs.getString("MenuName") == null)
				menuName = null;
			else
				menuName = rs.getString("MenuName").trim();
			if (rs.getString("Operation") == null)
				operation = null;
			else
				operation = rs.getString("Operation").trim();
			if (rs.getString("Discription") == null)
				discription = null;
			else
				discription = rs.getString("Discription").trim();
			if (rs.getString("CientIP") == null)
				cientIP = null;
			else
				cientIP = rs.getString("CientIP").trim();
			makeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("MakeTime").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MAgentLog表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MAgentLogSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MAgentLogSchema getSchema()
	{
		MAgentLogSchema aMAgentLogSchema = new MAgentLogSchema();
		aMAgentLogSchema.setSchema(this);
		return aMAgentLogSchema;
	}

	public MAgentLogDB getDB()
	{
		MAgentLogDB aDBOper = new MAgentLogDB();
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
		strReturn.append(StrTool.cTrim(userType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(traceType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(menuID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(menuName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operation));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(discription));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(cientIP));
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
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			userType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			traceType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			menuID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			menuName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			operation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			discription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			cientIP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MAgentLogSchema";
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
		if (FCode.equalsIgnoreCase("userType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(userType));
		if (FCode.equalsIgnoreCase("traceType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(traceType));
		if (FCode.equalsIgnoreCase("menuID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(menuID));
		if (FCode.equalsIgnoreCase("menuName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(menuName));
		if (FCode.equalsIgnoreCase("operation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operation));
		if (FCode.equalsIgnoreCase("discription"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(discription));
		if (FCode.equalsIgnoreCase("cientIP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(cientIP));
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
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(userType);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(traceType);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(menuID);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(menuName);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(operation);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(discription);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(cientIP);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 10: // '\n'
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
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equalsIgnoreCase("userType"))
			if (FValue != null && !FValue.equals(""))
				userType = FValue.trim();
			else
				userType = null;
		if (FCode.equalsIgnoreCase("traceType"))
			if (FValue != null && !FValue.equals(""))
				traceType = FValue.trim();
			else
				traceType = null;
		if (FCode.equalsIgnoreCase("menuID"))
			if (FValue != null && !FValue.equals(""))
				menuID = FValue.trim();
			else
				menuID = null;
		if (FCode.equalsIgnoreCase("menuName"))
			if (FValue != null && !FValue.equals(""))
				menuName = FValue.trim();
			else
				menuName = null;
		if (FCode.equalsIgnoreCase("operation"))
			if (FValue != null && !FValue.equals(""))
				operation = FValue.trim();
			else
				operation = null;
		if (FCode.equalsIgnoreCase("discription"))
			if (FValue != null && !FValue.equals(""))
				discription = FValue.trim();
			else
				discription = null;
		if (FCode.equalsIgnoreCase("cientIP"))
			if (FValue != null && !FValue.equals(""))
				cientIP = FValue.trim();
			else
				cientIP = null;
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
		MAgentLogSchema other = (MAgentLogSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (userType == null && other.getUserType() != null)
			return false;
		if (userType != null && !userType.equals(other.getUserType()))
			return false;
		if (traceType == null && other.getTraceType() != null)
			return false;
		if (traceType != null && !traceType.equals(other.getTraceType()))
			return false;
		if (menuID == null && other.getMenuID() != null)
			return false;
		if (menuID != null && !menuID.equals(other.getMenuID()))
			return false;
		if (menuName == null && other.getMenuName() != null)
			return false;
		if (menuName != null && !menuName.equals(other.getMenuName()))
			return false;
		if (operation == null && other.getOperation() != null)
			return false;
		if (operation != null && !operation.equals(other.getOperation()))
			return false;
		if (discription == null && other.getDiscription() != null)
			return false;
		if (discription != null && !discription.equals(other.getDiscription()))
			return false;
		if (cientIP == null && other.getCientIP() != null)
			return false;
		if (cientIP != null && !cientIP.equals(other.getCientIP()))
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
		return 11;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 1;
		if (strFieldName.equals("userType"))
			return 2;
		if (strFieldName.equals("traceType"))
			return 3;
		if (strFieldName.equals("menuID"))
			return 4;
		if (strFieldName.equals("menuName"))
			return 5;
		if (strFieldName.equals("operation"))
			return 6;
		if (strFieldName.equals("discription"))
			return 7;
		if (strFieldName.equals("cientIP"))
			return 8;
		if (strFieldName.equals("makeDate"))
			return 9;
		return !strFieldName.equals("makeTime") ? -1 : 10;
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
			strFieldName = "userType";
			break;

		case 3: // '\003'
			strFieldName = "traceType";
			break;

		case 4: // '\004'
			strFieldName = "menuID";
			break;

		case 5: // '\005'
			strFieldName = "menuName";
			break;

		case 6: // '\006'
			strFieldName = "operation";
			break;

		case 7: // '\007'
			strFieldName = "discription";
			break;

		case 8: // '\b'
			strFieldName = "cientIP";
			break;

		case 9: // '\t'
			strFieldName = "makeDate";
			break;

		case 10: // '\n'
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
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("userType"))
			return 0;
		if (strFieldName.equals("traceType"))
			return 0;
		if (strFieldName.equals("menuID"))
			return 0;
		if (strFieldName.equals("menuName"))
			return 0;
		if (strFieldName.equals("operation"))
			return 0;
		if (strFieldName.equals("discription"))
			return 0;
		if (strFieldName.equals("cientIP"))
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
			nFieldType = 1;
			break;

		case 10: // '\n'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
