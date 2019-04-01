// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CBlob.java

package com.sinosoft.map.utility;

import java.io.InputStream;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package com.sinosoft.map.utility:
//			CDB2Blob, COracleBlob

public class CBlob
{

	public CBlob()
	{
	}

	public static boolean BlobInsert(InputStream pIns, String pStr[], Connection pConn)
	{
		StringBuffer mSBql = new StringBuffer(256);
		if ("ORACLE".compareTo("DB2") == 0)
		{
			mSBql.append(pStr[0].substring(0, pStr[0].indexOf("empty_blob()")));
			mSBql.append("?");
			mSBql.append(pStr[0].substring(pStr[0].indexOf("empty_blob()") + 12, pStr[0].length()));
			CDB2Blob tCDB2Blob = new CDB2Blob();
			if (!tCDB2Blob.InsertBlankBlobRecord(pIns, mSBql.toString(), pConn))
				return false;
		} else
		{
			COracleBlob tCOracleBlob = new COracleBlob();
			if (!tCOracleBlob.InsertBlankBlobRecord(pStr[0], pConn))
				return false;
			if (!tCOracleBlob.UpdateBlob(pIns, pStr[1], pStr[2], pStr[3], pConn))
				return false;
		}
		return true;
	}

	public static boolean BlobUpdate(InputStream pIns, String pStr[], Connection pConn)
	{
		if ("ORACLE".compareTo("DB2") == 0)
		{
			CDB2Blob tCDB2Blob = new CDB2Blob();
			if (!tCDB2Blob.UpdateBlob(pIns, pStr[1], pStr[2], pStr[3], pConn))
				return false;
		} else
		{
			COracleBlob tCOracleBlob = new COracleBlob();
			if (!tCOracleBlob.UpdateBlob(pIns, pStr[1], pStr[2], pStr[3], pConn))
				return false;
		}
		return true;
	}

	public static Blob SelectBlob(String cTabName, String cSelectField, String cWhereSQL, Connection cConn)
	{
		StringBuffer mSBql;
		Statement tStatement;
		ResultSet tResultSet;
		mSBql = new StringBuffer(256);
		tStatement = null;
		tResultSet = null;
		Blob tBlob = null;
		if (cConn == null)
		{
			System.out.println("CBlob没有传入连接！");
			return null;
		}
		tStatement = cConn.createStatement();
		mSBql.append("SELECT ");
		mSBql.append(cSelectField);
		mSBql.append(" FROM ");
		mSBql.append(cTabName);
		mSBql.append(" WHERE 1=1 ");
		mSBql.append(cWhereSQL);
		tResultSet = tStatement.executeQuery(mSBql.toString());
		if (tResultSet.next())
			break MISSING_BLOCK_LABEL_154;
		System.out.println((new StringBuilder("找不到打印数据,SQL为：")).append(mSBql.toString()).toString());
		tResultSet.close();
		tStatement.close();
		return null;
		Blob tBlob;
		try
		{
			tBlob = tResultSet.getBlob(1);
			tResultSet.close();
			tStatement.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			try
			{
				if (tResultSet != null)
					tResultSet.close();
				if (tStatement != null)
					tStatement.close();
			}
			catch (Exception exception) { }
			return null;
		}
		return tBlob;
	}

	public static void BlobDelete()
	{
		"ORACLE".compareTo("DB2");
	}

	public static void main(String args1[])
	{
	}
}
