// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMapv2AdminLoginLogSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MMapv2AdminLoginLogDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MMapv2AdminLoginLogSchema
	implements Schema, Cloneable
{

	private String iD;
	private String agentCode;
	private String userType;
	private String clientName;
	private String clientType;
	private String clientIP;
	private Date loginDate;
	private String loginTime;
	private Date logoutDate;
	private String logoutTime;
	public static final int FIELDNUM = 10;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MMapv2AdminLoginLogSchema()
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
		MMapv2AdminLoginLogSchema cloned = (MMapv2AdminLoginLogSchema)super.clone();
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

	public String getClientName()
	{
		return clientName;
	}

	public void setClientName(String aClientName)
	{
		clientName = aClientName;
	}

	public String getClientType()
	{
		return clientType;
	}

	public void setClientType(String aClientType)
	{
		clientType = aClientType;
	}

	public String getClientIP()
	{
		return clientIP;
	}

	public void setClientIP(String aClientIP)
	{
		clientIP = aClientIP;
	}

	public String getLoginDate()
	{
		if (loginDate != null)
			return fDate.getString(loginDate);
		else
			return null;
	}

	public void setLoginDate(Date aLoginDate)
	{
		loginDate = aLoginDate;
	}

	public void setLoginDate(String aLoginDate)
	{
		if (aLoginDate != null && !aLoginDate.equals(""))
			loginDate = fDate.getDate(aLoginDate);
		else
			loginDate = null;
	}

	public String getLoginTime()
	{
		return loginTime;
	}

	public void setLoginTime(String aLoginTime)
	{
		loginTime = aLoginTime;
	}

	public String getLogoutDate()
	{
		if (logoutDate != null)
			return fDate.getString(logoutDate);
		else
			return null;
	}

	public void setLogoutDate(Date aLogoutDate)
	{
		logoutDate = aLogoutDate;
	}

	public void setLogoutDate(String aLogoutDate)
	{
		if (aLogoutDate != null && !aLogoutDate.equals(""))
			logoutDate = fDate.getDate(aLogoutDate);
		else
			logoutDate = null;
	}

	public String getLogoutTime()
	{
		return logoutTime;
	}

	public void setLogoutTime(String aLogoutTime)
	{
		logoutTime = aLogoutTime;
	}

	public void setSchema(MMapv2AdminLoginLogSchema aMMapv2AdminLoginLogSchema)
	{
		iD = aMMapv2AdminLoginLogSchema.getID();
		agentCode = aMMapv2AdminLoginLogSchema.getAgentCode();
		userType = aMMapv2AdminLoginLogSchema.getUserType();
		clientName = aMMapv2AdminLoginLogSchema.getClientName();
		clientType = aMMapv2AdminLoginLogSchema.getClientType();
		clientIP = aMMapv2AdminLoginLogSchema.getClientIP();
		loginDate = fDate.getDate(aMMapv2AdminLoginLogSchema.getLoginDate());
		loginTime = aMMapv2AdminLoginLogSchema.getLoginTime();
		logoutDate = fDate.getDate(aMMapv2AdminLoginLogSchema.getLogoutDate());
		logoutTime = aMMapv2AdminLoginLogSchema.getLogoutTime();
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
			if (rs.getString("ClientName") == null)
				clientName = null;
			else
				clientName = rs.getString("ClientName").trim();
			if (rs.getString("ClientType") == null)
				clientType = null;
			else
				clientType = rs.getString("ClientType").trim();
			if (rs.getString("ClientIP") == null)
				clientIP = null;
			else
				clientIP = rs.getString("ClientIP").trim();
			loginDate = rs.getDate("LoginDate");
			if (rs.getString("LoginTime") == null)
				loginTime = null;
			else
				loginTime = rs.getString("LoginTime").trim();
			logoutDate = rs.getDate("LogoutDate");
			if (rs.getString("LogoutTime") == null)
				logoutTime = null;
			else
				logoutTime = rs.getString("LogoutTime").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MMapv2AdminLoginLog表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MMapv2AdminLoginLogSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MMapv2AdminLoginLogSchema getSchema()
	{
		MMapv2AdminLoginLogSchema aMMapv2AdminLoginLogSchema = new MMapv2AdminLoginLogSchema();
		aMMapv2AdminLoginLogSchema.setSchema(this);
		return aMMapv2AdminLoginLogSchema;
	}

	public MMapv2AdminLoginLogDB getDB()
	{
		MMapv2AdminLoginLogDB aDBOper = new MMapv2AdminLoginLogDB();
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
		strReturn.append(StrTool.cTrim(clientName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(clientType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(clientIP));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(loginDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(loginTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(logoutDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(logoutTime));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			userType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			clientName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			clientType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			clientIP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			loginDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
			loginTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			logoutDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			logoutTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MMapv2AdminLoginLogSchema";
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
		if (FCode.equalsIgnoreCase("clientName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clientName));
		if (FCode.equalsIgnoreCase("clientType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clientType));
		if (FCode.equalsIgnoreCase("clientIP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clientIP));
		if (FCode.equalsIgnoreCase("loginDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getLoginDate()));
		if (FCode.equalsIgnoreCase("loginTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(loginTime));
		if (FCode.equalsIgnoreCase("logoutDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getLogoutDate()));
		if (FCode.equalsIgnoreCase("logoutTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(logoutTime));
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
			strFieldValue = StrTool.GBKToUnicode(clientName);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(clientType);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(clientIP);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLoginDate()));
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(loginTime);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLogoutDate()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(logoutTime);
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
		if (FCode.equalsIgnoreCase("clientName"))
			if (FValue != null && !FValue.equals(""))
				clientName = FValue.trim();
			else
				clientName = null;
		if (FCode.equalsIgnoreCase("clientType"))
			if (FValue != null && !FValue.equals(""))
				clientType = FValue.trim();
			else
				clientType = null;
		if (FCode.equalsIgnoreCase("clientIP"))
			if (FValue != null && !FValue.equals(""))
				clientIP = FValue.trim();
			else
				clientIP = null;
		if (FCode.equalsIgnoreCase("loginDate"))
			if (FValue != null && !FValue.equals(""))
				loginDate = fDate.getDate(FValue);
			else
				loginDate = null;
		if (FCode.equalsIgnoreCase("loginTime"))
			if (FValue != null && !FValue.equals(""))
				loginTime = FValue.trim();
			else
				loginTime = null;
		if (FCode.equalsIgnoreCase("logoutDate"))
			if (FValue != null && !FValue.equals(""))
				logoutDate = fDate.getDate(FValue);
			else
				logoutDate = null;
		if (FCode.equalsIgnoreCase("logoutTime"))
			if (FValue != null && !FValue.equals(""))
				logoutTime = FValue.trim();
			else
				logoutTime = null;
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
		MMapv2AdminLoginLogSchema other = (MMapv2AdminLoginLogSchema)otherObject;
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
		if (clientName == null && other.getClientName() != null)
			return false;
		if (clientName != null && !clientName.equals(other.getClientName()))
			return false;
		if (clientType == null && other.getClientType() != null)
			return false;
		if (clientType != null && !clientType.equals(other.getClientType()))
			return false;
		if (clientIP == null && other.getClientIP() != null)
			return false;
		if (clientIP != null && !clientIP.equals(other.getClientIP()))
			return false;
		if (loginDate == null && other.getLoginDate() != null)
			return false;
		if (loginDate != null && !fDate.getString(loginDate).equals(other.getLoginDate()))
			return false;
		if (loginTime == null && other.getLoginTime() != null)
			return false;
		if (loginTime != null && !loginTime.equals(other.getLoginTime()))
			return false;
		if (logoutDate == null && other.getLogoutDate() != null)
			return false;
		if (logoutDate != null && !fDate.getString(logoutDate).equals(other.getLogoutDate()))
			return false;
		if (logoutTime == null && other.getLogoutTime() != null)
			return false;
		return logoutTime == null || logoutTime.equals(other.getLogoutTime());
	}

	public int getFieldCount()
	{
		return 10;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 1;
		if (strFieldName.equals("userType"))
			return 2;
		if (strFieldName.equals("clientName"))
			return 3;
		if (strFieldName.equals("clientType"))
			return 4;
		if (strFieldName.equals("clientIP"))
			return 5;
		if (strFieldName.equals("loginDate"))
			return 6;
		if (strFieldName.equals("loginTime"))
			return 7;
		if (strFieldName.equals("logoutDate"))
			return 8;
		return !strFieldName.equals("logoutTime") ? -1 : 9;
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
			strFieldName = "clientName";
			break;

		case 4: // '\004'
			strFieldName = "clientType";
			break;

		case 5: // '\005'
			strFieldName = "clientIP";
			break;

		case 6: // '\006'
			strFieldName = "loginDate";
			break;

		case 7: // '\007'
			strFieldName = "loginTime";
			break;

		case 8: // '\b'
			strFieldName = "logoutDate";
			break;

		case 9: // '\t'
			strFieldName = "logoutTime";
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
		if (strFieldName.equals("clientName"))
			return 0;
		if (strFieldName.equals("clientType"))
			return 0;
		if (strFieldName.equals("clientIP"))
			return 0;
		if (strFieldName.equals("loginDate"))
			return 1;
		if (strFieldName.equals("loginTime"))
			return 0;
		if (strFieldName.equals("logoutDate"))
			return 1;
		return !strFieldName.equals("logoutTime") ? -1 : 0;
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
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 1;
			break;

		case 9: // '\t'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
