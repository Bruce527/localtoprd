// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBConnPool.java

package com.sinosoft.map.utility;

import java.io.OutputStream;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.utility:
//			DBConn, JdbcUrl, DBSemaphore

public class DBConnPool
{

	private static DBConn dbConns[];
	private static final int nConnCount = 60;

	private DBConnPool()
	{
	}

	public static DBConn getConnection()
	{
		int nIndex;
		JdbcUrl JUrl = new JdbcUrl();
		if (JUrl.getDBType().toUpperCase().equals("WEBLOGICPOOL") || JUrl.getDBType().toUpperCase().equals("COMMONSDBCP") || JUrl.getDBType().toUpperCase().equals("WEBSPHERE") || JUrl.getDBType().toUpperCase().equals("JBOSS"))
		{
			DBConn tDBConn = new DBConn();
			if (tDBConn.createConnection())
				return tDBConn;
			else
				return null;
		}
		try
		{
			DBSemaphore.Lock();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		nIndex = 0;
		  goto _L1
_L3:
		DBConn dbConn;
		dbConn = dbConns[nIndex];
		if (dbConn.isInUse())
			continue; /* Loop/switch isn't completed */
		if (!dbConn.createConnection())
		{
			DBSemaphore.UnLock();
			return null;
		}
		if (nIndex >= 1)
			System.out.println((new StringBuilder("DBConnPool : get connection, index is ")).append(String.valueOf(nIndex)).toString());
		dbConn.setAutoCommit(true);
		dbConn.setInUse();
		DBSemaphore.UnLock();
		return dbConn;
		Exception ex;
		ex;
		ex.printStackTrace();
		DBSemaphore.UnLock();
		return null;
		nIndex++;
_L1:
		if (nIndex < 60) goto _L3; else goto _L2
_L2:
		System.out.println("DBConnPool : All connections are in use");
		DBSemaphore.UnLock();
		return null;
	}

	public static void dumpConnInfo(OutputStream os)
	{
		if (dbConns == null)
		{
			os.write("all connections are free".getBytes());
			return;
		}
		try
		{
			for (int nIndex = 0; nIndex < 60; nIndex++)
			{
				DBConn dbConn = dbConns[nIndex];
				os.write((new StringBuilder(String.valueOf(String.valueOf(nIndex)))).append("------------------------------------\r\n\r").toString().getBytes());
				if (dbConn != null && dbConn.isInUse())
					dbConn.dumpConnInfo(os);
			}

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return;
	}

	protected static DBConn[] getDBConns()
	{
		return dbConns;
	}

	static 
	{
		dbConns = new DBConn[60];
		for (int nIndex = 0; nIndex < 60; nIndex++)
			dbConns[nIndex] = new DBConn();

	}
}
