// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   JdbcUrl.java

package com.sinosoft.banklns.utility;

import com.sinosoft.map.common.WebApplication;
import java.io.PrintStream;
import java.util.Map;

public class JdbcUrl
{

	private String DBType;
	private String IP;
	private String Port;
	private String DBName;
	private String ServerName;
	private String UserName;
	private String PassWord;

	public JdbcUrl()
	{
		Map dbinfo = WebApplication.getInstance().get_jdbcurl();
		DBType = (String)dbinfo.get("dbType");
		DBName = (String)dbinfo.get("dbName");
		IP = (String)dbinfo.get("dbIP");
		Port = (String)dbinfo.get("dbPort");
		UserName = (String)dbinfo.get("dbUserName");
		PassWord = (String)dbinfo.get("dbPassword");
	}

	public String getDBType()
	{
		return DBType;
	}

	public String getIP()
	{
		return IP;
	}

	public String getPort()
	{
		return Port;
	}

	public String getDBName()
	{
		return DBName;
	}

	public String getServerName()
	{
		return ServerName;
	}

	public String getUserName()
	{
		return UserName;
	}

	public String getPassWord()
	{
		return PassWord;
	}

	public void setDBType(String aDBType)
	{
		DBType = aDBType;
	}

	public void setIP(String aIP)
	{
		IP = aIP;
	}

	public void setPort(String aPort)
	{
		Port = aPort;
	}

	public void setDBName(String aDBName)
	{
		DBName = aDBName;
	}

	public void setServerName(String aServerName)
	{
		ServerName = aServerName;
	}

	public void setUser(String aUserName)
	{
		UserName = aUserName;
	}

	public void setPassWord(String aPassWord)
	{
		PassWord = aPassWord;
	}

	public String getJdbcUrl()
	{
		StringBuffer sUrl = new StringBuffer(256);
		if (DBType.trim().toUpperCase().equals("ORACLE"))
		{
			sUrl.append("jdbc:oracle:thin:@");
			sUrl.append(IP);
			sUrl.append(":");
			sUrl.append(Port);
			sUrl.append(":");
			sUrl.append(DBName);
		}
		if (DBType.trim().toUpperCase().equals("INFORMIX"))
		{
			sUrl.append("jdbc:informix-sqli://");
			sUrl.append(IP);
			sUrl.append(":");
			sUrl.append(Port);
			sUrl.append(DBName);
			sUrl.append(":");
			sUrl.append("informixserver=");
			sUrl.append(ServerName);
			sUrl.append(";");
			sUrl.append("user=");
			sUrl.append(UserName);
			sUrl.append(";");
			sUrl.append("password=");
			sUrl.append(PassWord);
			sUrl.append(";");
		}
		if (DBType.trim().toUpperCase().equals("SQLSERVER"))
		{
			sUrl.append("jdbc:inetdae:");
			sUrl.append(IP);
			sUrl.append(":");
			sUrl.append(Port);
			sUrl.append("?sql7=true&database=");
			sUrl.append(DBName);
			sUrl.append("&charset=gbk");
		}
		if (DBType.trim().toUpperCase().equals("SQLSERVER2012"))
			sUrl = sUrl.append("jdbc:sqlserver://").append(IP).append("\\SQLEXPRESS").append(":").append(Port).append(";databasename=").append(DBName);
		if (DBType.trim().toUpperCase().equals("WEBLOGICPOOL"))
		{
			sUrl.append("jdbc:weblogic:pool:");
			sUrl.append(DBName);
		}
		if (DBType.trim().toUpperCase().equals("DB2"))
		{
			sUrl.append("jdbc:db2://");
			sUrl.append(IP);
			sUrl.append(":");
			sUrl.append(Port);
			sUrl.append("/");
			sUrl.append(DBName);
		}
		System.out.println((new StringBuilder("数据库url:")).append(sUrl.toString()).toString());
		return sUrl.toString();
	}
}
