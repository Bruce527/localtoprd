// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EAIPropertiesFromDB.java

package com.sinosoft.banklns.lnsmodel.util;

import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

public class EAIPropertiesFromDB
{

	public static String XMLSavePath;
	public static String ESBEnvelope_ns;
	public static String ProcessMessage_ns;
	public static String Default_ns;
	public static String SoapAddress;
	public static String SoapAction;

	public EAIPropertiesFromDB()
	{
	}

	static 
	{
		Connection conn;
		XMLSavePath = null;
		ESBEnvelope_ns = null;
		ProcessMessage_ns = null;
		Default_ns = null;
		SoapAddress = null;
		SoapAction = null;
		conn = null;
		ExeSQL tExeSQL = null;
		SSRS tSSRS = null;
		String sql = null;
		try
		{
			conn = DBConnPool.getConnection();
			ExeSQL tExeSQL = new ExeSQL(conn);
			String sql = "select sysvarvalue from lnpsysvar where sysvar='tranfolder'";
			SSRS tSSRS = tExeSQL.execSQL(sql);
			XMLSavePath = tSSRS.GetText(1, 1);
			sql = "select sysvarvalue from lnpsysvar where sysvar='ESBEnvelope_ns'";
			tSSRS = tExeSQL.execSQL(sql);
			ESBEnvelope_ns = tSSRS.GetText(1, 1);
			sql = "select sysvarvalue from lnpsysvar where sysvar='ProcessMessage_ns'";
			tSSRS = tExeSQL.execSQL(sql);
			ProcessMessage_ns = tSSRS.GetText(1, 1);
			sql = "select sysvarvalue from lnpsysvar where sysvar='Default_ns'";
			tSSRS = tExeSQL.execSQL(sql);
			Default_ns = tSSRS.GetText(1, 1);
			sql = "select sysvarvalue from lnpsysvar where sysvar='SoapAddress'";
			tSSRS = tExeSQL.execSQL(sql);
			SoapAddress = tSSRS.GetText(1, 1);
			SoapAddress = "http://eai-a-sit.metlifechina.local/esbwebentry/ESBWebEntry.asmx";
			System.out.println(SoapAddress);
			sql = "select sysvarvalue from lnpsysvar where sysvar='SoapAction'";
			tSSRS = tExeSQL.execSQL(sql);
			SoapAction = tSSRS.GetText(1, 1);
			break MISSING_BLOCK_LABEL_256;
		}
		catch (Exception e)
		{
			System.out.println((new StringBuilder("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``EAIPropertiesFromDB erro:")).append(e.getLocalizedMessage()).toString());
		}
		try
		{
			if (!conn.isClosed())
				conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		break MISSING_BLOCK_LABEL_281;
		Exception exception;
		exception;
		try
		{
			if (!conn.isClosed())
				conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		throw exception;
		try
		{
			if (!conn.isClosed())
				conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
