// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   COracleBlob.java

package com.sinosoft.map.utility;

import java.io.*;
import java.sql.*;
import oracle.sql.BLOB;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class COracleBlob
{

	private StringBuffer mSBql;

	public COracleBlob()
	{
		mSBql = new StringBuffer(256);
	}

	public boolean UpdateBlob(Document pInXmlDoc, String pTabName, String pUpdateField, String pWhereSQL, Connection pConn)
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
		mSBql.append(" FOR UPDATE");
		rs = stmt.executeQuery(mSBql.toString());
		if (rs.next())
			break MISSING_BLOCK_LABEL_174;
		System.out.println((new StringBuilder("COracleBlob该查询条件没有查询到记录！SQL为：")).append(mSBql.toString()).toString());
		rs.close();
		stmt.close();
		return false;
		try
		{
			Blob blob = rs.getBlob(pUpdateField);
			OutputStream os = ((BLOB)blob).getBinaryOutputStream();
			XMLOutputter outputter = new XMLOutputter();
			Format tFormat = Format.getPrettyFormat();
			tFormat.setEncoding("UTF-8");
			outputter.setFormat(tFormat);
			outputter.output(pInXmlDoc, os);
			os.flush();
			os.close();
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
		mSBql.append(" FOR UPDATE");
		rs = stmt.executeQuery(mSBql.toString());
		if (rs.next())
			break MISSING_BLOCK_LABEL_174;
		System.out.println((new StringBuilder("COracleBlob该查询条件没有查询到记录！SQL为：")).append(mSBql.toString()).toString());
		rs.close();
		stmt.close();
		return false;
		try
		{
			Blob blob = rs.getBlob(pUpdateField);
			OutputStream os = ((BLOB)blob).getBinaryOutputStream();
			InputStream ins = pInStream;
			for (int inData = 0; (inData = ins.read()) != -1;)
				os.write(inData);

			os.flush();
			os.close();
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
			return false;
		}
		return true;
	}

	public boolean DeleteBlobRecord(String pDeleteSQL, Connection pConn)
	{
		Statement stmt = null;
		if (pConn == null)
		{
			System.out.println("COracleBlob没有传入连接！");
			return false;
		}
		try
		{
			stmt = pConn.createStatement(1003, 1008);
			String szSQL = pDeleteSQL;
			stmt.executeUpdate(szSQL);
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

	public boolean InsertBlankBlobRecord(String pInsertSQL, Connection pConn)
	{
		Statement stmt = null;
		if (pConn == null)
		{
			System.out.println("COracleBlob没有传入连接！");
			return false;
		}
		try
		{
			stmt = pConn.createStatement(1003, 1008);
			String szSQL = pInsertSQL;
			stmt.executeUpdate(szSQL);
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
			System.out.println("COracleBlob没有传入连接！");
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
			tOutData = rs.getBlob(pSelectField);
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

	public static void main(String args1[])
	{
	}
}
