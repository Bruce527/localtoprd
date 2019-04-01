// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ECDBConnPool.java

package com.sinosoft.map.utility;

import java.io.OutputStream;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.utility:
//			ECDBConn, ECJdbcUrl, DBSemaphore

public class ECDBConnPool
{

	private static ECDBConn ECDBConns[];
	private static final int nConnCount = 600;

	private ECDBConnPool()
	{
	}

	public static ECDBConn getECConnection()
	{
		int nIndex;
		ECJdbcUrl JUrl = new ECJdbcUrl();
		if (JUrl.getDBType().toUpperCase().equals("WEBLOGICPOOL") || JUrl.getDBType().toUpperCase().equals("COMMONSDBCP") || JUrl.getDBType().toUpperCase().equals("WEBSPHERE"))
		{
			ECDBConn tECDBConn = new ECDBConn();
			if (tECDBConn.createECConnection())
				return tECDBConn;
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
		ECDBConn ECDBConn;
		ECDBConn = ECDBConns[nIndex];
		if (ECDBConn.isInUse())
			continue; /* Loop/switch isn't completed */
		if (!ECDBConn.createECConnection())
		{
			DBSemaphore.UnLock();
			return null;
		}
		if (nIndex >= 1)
			System.out.println((new StringBuilder("ECDBConnPool : get connection, index is ")).append(String.valueOf(nIndex)).toString());
		ECDBConn.setAutoCommit(true);
		ECDBConn.setInUse();
		DBSemaphore.UnLock();
		return ECDBConn;
		Exception ex;
		ex;
		ex.printStackTrace();
		DBSemaphore.UnLock();
		return null;
		nIndex++;
_L1:
		if (nIndex < 600) goto _L3; else goto _L2
_L2:
		System.out.println("ECDBConnPool : All connections are in use");
		DBSemaphore.UnLock();
		return null;
	}

	public static void dumpConnInfo(OutputStream os)
	{
		if (ECDBConns == null)
		{
			os.write("all connections are free".getBytes());
			return;
		}
		try
		{
			for (int nIndex = 0; nIndex < 600; nIndex++)
			{
				ECDBConn ECDBConn = ECDBConns[nIndex];
				os.write((new StringBuilder(String.valueOf(String.valueOf(nIndex)))).append("------------------------------------\r\n\r").toString().getBytes());
				if (ECDBConn != null && ECDBConn.isInUse())
					ECDBConn.dumpConnInfo(os);
			}

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return;
	}

	protected static ECDBConn[] getECDBConns()
	{
		return ECDBConns;
	}

	static 
	{
		ECDBConns = new ECDBConn[600];
		for (int nIndex = 0; nIndex < 600; nIndex++)
			ECDBConns[nIndex] = new ECDBConn();

	}
}
