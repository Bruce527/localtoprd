// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CDB2Blob.java

package com.sinosoft.map.utility;

import java.io.*;
import java.sql.*;
import org.jdom.Document;

public class CDB2Blob
{

	private StringBuffer mSBql;

	public CDB2Blob()
	{
		mSBql = new StringBuffer(256);
	}

	public boolean UpdateBlob(Document pInXmlDoc, String pTabName, String pUpdateField, String pGrpPolNo, Connection pConn)
	{
		PreparedStatement preparedStatement = null;
		Statement stmt = null;
		if (pConn == null)
		{
			System.out.println("CDB2Blob没有传入连接！");
			return false;
		}
		try
		{
			stmt = pConn.createStatement();
			String szSQL = (new StringBuilder("SELECT ")).append(pUpdateField).append(" FROM ").append(pTabName).append(" WHERE MainPolNo = '").append(pGrpPolNo).append("' FOR UPDATE").toString();
			System.out.println((new StringBuilder("UpdateBlob :")).append(szSQL).toString());
			preparedStatement = pConn.prepareStatement(szSQL);
			preparedStatement.executeQuery();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.out.print(ex.toString());
			try
			{
				if (stmt != null)
					stmt.close();
			}
			catch (Exception exception) { }
			return false;
		}
		return true;
	}

	public boolean UpdateBlob(InputStream pInStream, String pTabName, String pUpdateField, String pWhereSQL, Connection pConn)
	{
		Statement stmt;
		ResultSet rs;
		stmt = null;
		rs = null;
		if (pConn == null)
		{
			System.out.println("COracleBlob没有传入连接！");
			return false;
		}
		stmt = pConn.createStatement(1003, 1008);
		mSBql.append("SELECT ");
		mSBql.append(pUpdateField);
		mSBql.append(" FROM ");
		mSBql.append(pTabName);
		mSBql.append(" WHERE 1=1 ");
		mSBql.append(pWhereSQL);
		rs = stmt.executeQuery(mSBql.toString());
		if (rs.next())
			break MISSING_BLOCK_LABEL_164;
		System.out.println((new StringBuilder("COracleBlob该查询条件没有查询到记录！SQL为：")).append(mSBql.toString()).toString());
		rs.close();
		stmt.close();
		return false;
		try
		{
			rs.close();
			mSBql = new StringBuffer(256);
			mSBql.append("UPDATE ");
			mSBql.append(pTabName);
			mSBql.append(" Set ");
			mSBql.append(pUpdateField);
			mSBql.append(" =? WHERE 1=1 ");
			mSBql.append(pWhereSQL);
			PreparedStatement ps = pConn.prepareStatement(mSBql.toString());
			ps.setBinaryStream(1, pInStream, pInStream.available());
			ps.execute();
			ps.close();
			stmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			try
			{
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}
			catch (Exception exception) { }
			return false;
		}
		return true;
	}

	public boolean DeleteBlobRecord(String pDeleteSQL, Connection pConn)
	{
		Statement stmt = null;
		if (pConn == null)
		{
			System.out.println("CDB2Blob没有传入连接！");
			return false;
		}
		try
		{
			stmt = pConn.createStatement();
			String sDeleteSQL = pDeleteSQL.replaceFirst("DELETE", "SELECT MAINPOLNO");
			ResultSet rs = stmt.executeQuery(sDeleteSQL);
			if (rs.next())
				stmt.executeUpdate(pDeleteSQL);
			stmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			try
			{
				if (stmt != null)
					stmt.close();
			}
			catch (Exception exception) { }
			return false;
		}
		return true;
	}

	public boolean InsertBlankBlobRecord(InputStream pis, String pInsertSQL, Connection pConn)
	{
		Statement stmt = null;
		if (pConn == null)
		{
			System.out.println("CDB2Blob没有传入连接！");
			return false;
		}
		try
		{
			System.out.println((new StringBuilder("DB2数据库Blob插入操作sql：")).append(pInsertSQL).toString());
			PreparedStatement ps = pConn.prepareStatement(pInsertSQL);
			ps.setBinaryStream(1, pis, pis.available());
			ps.execute();
			ps.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			try
			{
				stmt.close();
			}
			catch (Exception exception) { }
			return false;
		}
		return true;
	}

	public boolean SelectBlob(OutputStream pOutStream, String pTabName, String pSelectField, String s, Connection connection)
	{
		return false;
	}

	public Blob SelectBlob(String pTabName, String pSelectField, String pWhereSQL, Connection pConn)
	{
		Statement stmt;
		ResultSet rs;
		stmt = null;
		rs = null;
		Blob tOutData = null;
		if (pConn == null)
		{
			System.out.println("CDB2Blob没有传入连接！");
			return null;
		}
		stmt = pConn.createStatement();
		mSBql.append("SELECT ");
		mSBql.append(pSelectField);
		mSBql.append(" FROM ");
		mSBql.append(pTabName);
		mSBql.append(" WHERE 1=1 ");
		mSBql.append(pWhereSQL);
		rs = stmt.executeQuery(mSBql.toString());
		if (rs.next())
			break MISSING_BLOCK_LABEL_160;
		System.out.println((new StringBuilder("找不到打印数据,SQL为：")).append(mSBql.toString()).toString());
		rs.close();
		stmt.close();
		return null;
		Blob tOutData;
		try
		{
			tOutData = rs.getBlob(1);
			rs.close();
			stmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			try
			{
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}
			catch (Exception exception) { }
			return null;
		}
		return tOutData;
	}
}
