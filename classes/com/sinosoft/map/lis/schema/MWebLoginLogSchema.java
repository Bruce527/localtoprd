// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MWebLoginLogSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MWebLoginLogDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MWebLoginLogSchema
	implements Schema, Cloneable
{

	private String iD;
	private String sessionId;
	private String userCode;
	private String userType;
	private String clientName;
	private String clientType;
	private String clientIP;
	private Date loginDate;
	private String loginTime;
	private Date logoutDate;
	private String logoutTime;
	public static final int FIELDNUM = 11;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MWebLoginLogSchema()
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
		MWebLoginLogSchema cloned = (MWebLoginLogSchema)super.clone();
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

	public String getSessionId()
	{
		return sessionId;
	}

	public void setSessionId(String aSessionId)
	{
		sessionId = aSessionId;
	}

	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String aUserCode)
	{
		userCode = aUserCode;
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

	public void setSchema(MWebLoginLogSchema aMWebLoginLogSchema)
	{
		iD = aMWebLoginLogSchema.getID();
		sessionId = aMWebLoginLogSchema.getSessionId();
		userCode = aMWebLoginLogSchema.getUserCode();
		userType = aMWebLoginLogSchema.getUserType();
		clientName = aMWebLoginLogSchema.getClientName();
		clientType = aMWebLoginLogSchema.getClientType();
		clientIP = aMWebLoginLogSchema.getClientIP();
		loginDate = fDate.getDate(aMWebLoginLogSchema.getLoginDate());
		loginTime = aMWebLoginLogSchema.getLoginTime();
		logoutDate = fDate.getDate(aMWebLoginLogSchema.getLogoutDate());
		logoutTime = aMWebLoginLogSchema.getLogoutTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ID") == null)
				iD = null;
			else
				iD = rs.getString("ID").trim();
			if (rs.getString("SessionId") == null)
				sessionId = null;
			else
				sessionId = rs.getString("SessionId").trim();
			if (rs.getString("UserCode") == null)
				userCode = null;
			else
				userCode = rs.getString("UserCode").trim();
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
			System.out.println("���ݿ��е�MWebLoginLog���ֶθ�����Schema�е��ֶθ�����һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "MWebLoginLogSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MWebLoginLogSchema getSchema()
	{
		MWebLoginLogSchema aMWebLoginLogSchema = new MWebLoginLogSchema();
		aMWebLoginLogSchema.setSchema(this);
		return aMWebLoginLogSchema;
	}

	public MWebLoginLogDB getDB()
	{
		MWebLoginLogDB aDBOper = new MWebLoginLogDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(iD));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sessionId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(userCode));
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
			sessionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			userCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			userType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			clientName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			clientType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			clientIP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			loginDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			loginTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			logoutDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			logoutTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MWebLoginLogSchema";
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
		if (FCode.equalsIgnoreCase("sessionId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sessionId));
		if (FCode.equalsIgnoreCase("userCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(userCode));
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
			strFieldValue = StrTool.GBKToUnicode(sessionId);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(userCode);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(userType);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(clientName);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(clientType);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(clientIP);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLoginDate()));
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(loginTime);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getLogoutDate()));
			break;

		case 10: // '\n'
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
		if (FCode.equalsIgnoreCase("sessionId"))
			if (FValue != null && !FValue.equals(""))
				sessionId = FValue.trim();
			else
				sessionId = null;
		if (FCode.equalsIgnoreCase("userCode"))
			if (FValue != null && !FValue.equals(""))
				userCode = FValue.trim();
			else
				userCode = null;
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
		MWebLoginLogSchema other = (MWebLoginLogSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (sessionId == null && other.getSessionId() != null)
			return false;
		if (sessionId != null && !sessionId.equals(other.getSessionId()))
			return false;
		if (userCode == null && other.getUserCode() != null)
			return false;
		if (userCode != null && !userCode.equals(other.getUserCode()))
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
		return 11;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("sessionId"))
			return 1;
		if (strFieldName.equals("userCode"))
			return 2;
		if (strFieldName.equals("userType"))
			return 3;
		if (strFieldName.equals("clientName"))
			return 4;
		if (strFieldName.equals("clientType"))
			return 5;
		if (strFieldName.equals("clientIP"))
			return 6;
		if (strFieldName.equals("loginDate"))
			return 7;
		if (strFieldName.equals("loginTime"))
			return 8;
		if (strFieldName.equals("logoutDate"))
			return 9;
		return !strFieldName.equals("logoutTime") ? -1 : 10;
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
			strFieldName = "sessionId";
			break;

		case 2: // '\002'
			strFieldName = "userCode";
			break;

		case 3: // '\003'
			strFieldName = "userType";
			break;

		case 4: // '\004'
			strFieldName = "clientName";
			break;

		case 5: // '\005'
			strFieldName = "clientType";
			break;

		case 6: // '\006'
			strFieldName = "clientIP";
			break;

		case 7: // '\007'
			strFieldName = "loginDate";
			break;

		case 8: // '\b'
			strFieldName = "loginTime";
			break;

		case 9: // '\t'
			strFieldName = "logoutDate";
			break;

		case 10: // '\n'
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
		if (strFieldName.equals("sessionId"))
			return 0;
		if (strFieldName.equals("userCode"))
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
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 1;
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