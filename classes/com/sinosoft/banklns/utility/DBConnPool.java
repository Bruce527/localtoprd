// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBConnPool.java

package com.sinosoft.banklns.utility;

import java.io.OutputStream;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.banklns.utility:
//			DBConn, JdbcUrl, DBSemaphore

public class DBConnPool
{

	private static DBConn dbConns[];
	private static final int nConnCount = 50;

	private DBConnPool()
	{
	}

	public static DBConn getConnection()
	{
		int curfreeIndex;
		DBConn dbConn;
		curfreeIndex = 0;
		dbConn = null;
		DBConn dbconn;
		JdbcUrl JUrl = new JdbcUrl();
		if (!JUrl.getDBType().toUpperCase().equals("WEBLOGICPOOL") && !JUrl.getDBType().toUpperCase().equals("COMMONSDBCP") && !JUrl.getDBType().toUpperCase().equals("WEBSPHERE") && !JUrl.getDBType().toUpperCase().equals("JBOSS"))
			break MISSING_BLOCK_LABEL_375;
		DBConn tDBConn = new DBConn();
		if (!tDBConn.createConnection())
			break MISSING_BLOCK_LABEL_233;
		dbconn = tDBConn;
		try
		{
			if (curfreeIndex > 15)
			{
				System.out.println((new StringBuilder("只试用本地开发，UAT上还是用连接池------------current con idx is ")).append(curfreeIndex).toString());
				System.out.println("get in close connections  what if it is free");
				for (int i = 0; i < curfreeIndex; i++)
					if (dbConns[i].isInnerClose() || dbConns[i].isClosed() || !dbConns[i].isInUse() || curfreeIndex > 20)
					{
						dbConns[i].close();
						System.out.println((new StringBuilder("--------------------->current idx: ")).append(i).append(" con is not use").toString());
					}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dbconn;
		try
		{
			if (curfreeIndex > 15)
			{
				System.out.println((new StringBuilder("只试用本地开发，UAT上还是用连接池------------current con idx is ")).append(curfreeIndex).toString());
				System.out.println("get in close connections  what if it is free");
				for (int i = 0; i < curfreeIndex; i++)
					if (dbConns[i].isInnerClose() || dbConns[i].isClosed() || !dbConns[i].isInUse() || curfreeIndex > 20)
					{
						dbConns[i].close();
						System.out.println((new StringBuilder("--------------------->current idx: ")).append(i).append(" con is not use").toString());
					}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
		try
		{
			DBSemaphore.Lock();
			break MISSING_BLOCK_LABEL_528;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		try
		{
			if (curfreeIndex > 15)
			{
				System.out.println((new StringBuilder("只试用本地开发，UAT上还是用连接池------------current con idx is ")).append(curfreeIndex).toString());
				System.out.println("get in close connections  what if it is free");
				for (int i = 0; i < curfreeIndex; i++)
					if (dbConns[i].isInnerClose() || dbConns[i].isClosed() || !dbConns[i].isInUse() || curfreeIndex > 20)
					{
						dbConns[i].close();
						System.out.println((new StringBuilder("--------------------->current idx: ")).append(i).append(" con is not use").toString());
					}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
		int nIndex = 0;
		  goto _L1
_L5:
		dbConn = dbConns[nIndex];
		if (dbConn.isInUse())
		{
			if (dbConn.isInnerClose() || dbConn.isClosed())
			{
				dbConn.close();
				System.out.println((new StringBuilder("--------------------->current ")).append(nIndex).append(" idx con isClosed").toString());
			}
			continue; /* Loop/switch isn't completed */
		}
		if (dbConn.createConnection()) goto _L3; else goto _L2
_L2:
		DBSemaphore.UnLock();
		try
		{
			if (curfreeIndex > 15)
			{
				System.out.println((new StringBuilder("只试用本地开发，UAT上还是用连接池------------current con idx is ")).append(curfreeIndex).toString());
				System.out.println("get in close connections  what if it is free");
				for (int i = 0; i < curfreeIndex; i++)
					if (dbConns[i].isInnerClose() || dbConns[i].isClosed() || !dbConns[i].isInUse() || curfreeIndex > 20)
					{
						dbConns[i].close();
						System.out.println((new StringBuilder("--------------------->current idx: ")).append(i).append(" con is not use").toString());
					}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
_L3:
		if (nIndex >= 1)
		{
			System.out.println((new StringBuilder("--------------------->MDES DBConnPool :  get connection, current min free index is ")).append(String.valueOf(nIndex)).toString());
			curfreeIndex = nIndex;
		}
		dbConn.setAutoCommit(true);
		dbConn.setInUse();
		DBSemaphore.UnLock();
		dbconn = dbConn;
		try
		{
			if (curfreeIndex > 15)
			{
				System.out.println((new StringBuilder("只试用本地开发，UAT上还是用连接池------------current con idx is ")).append(curfreeIndex).toString());
				System.out.println("get in close connections  what if it is free");
				for (int i = 0; i < curfreeIndex; i++)
					if (dbConns[i].isInnerClose() || dbConns[i].isClosed() || !dbConns[i].isInUse() || curfreeIndex > 20)
					{
						dbConns[i].close();
						System.out.println((new StringBuilder("--------------------->current idx: ")).append(i).append(" con is not use").toString());
					}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dbconn;
		Exception ex;
		ex;
		ex.printStackTrace();
		DBSemaphore.UnLock();
		try
		{
			if (curfreeIndex > 15)
			{
				System.out.println((new StringBuilder("只试用本地开发，UAT上还是用连接池------------current con idx is ")).append(curfreeIndex).toString());
				System.out.println("get in close connections  what if it is free");
				for (int i = 0; i < curfreeIndex; i++)
					if (dbConns[i].isInnerClose() || dbConns[i].isClosed() || !dbConns[i].isInUse() || curfreeIndex > 20)
					{
						dbConns[i].close();
						System.out.println((new StringBuilder("--------------------->current idx: ")).append(i).append(" con is not use").toString());
					}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
		nIndex++;
_L1:
		if (nIndex < 50) goto _L5; else goto _L4
_L4:
		System.out.println("--------------------->MDES DBConnPool : All connections are in use");
		DBSemaphore.UnLock();
		try
		{
			if (curfreeIndex > 15)
			{
				System.out.println((new StringBuilder("只试用本地开发，UAT上还是用连接池------------current con idx is ")).append(curfreeIndex).toString());
				System.out.println("get in close connections  what if it is free");
				for (int i = 0; i < curfreeIndex; i++)
					if (dbConns[i].isInnerClose() || dbConns[i].isClosed() || !dbConns[i].isInUse() || curfreeIndex > 20)
					{
						dbConns[i].close();
						System.out.println((new StringBuilder("--------------------->current idx: ")).append(i).append(" con is not use").toString());
					}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
		Exception e;
		e;
		e.printStackTrace();
		try
		{
			if (curfreeIndex > 15)
			{
				System.out.println((new StringBuilder("只试用本地开发，UAT上还是用连接池------------current con idx is ")).append(curfreeIndex).toString());
				System.out.println("get in close connections  what if it is free");
				for (int i = 0; i < curfreeIndex; i++)
					if (dbConns[i].isInnerClose() || dbConns[i].isClosed() || !dbConns[i].isInUse() || curfreeIndex > 20)
					{
						dbConns[i].close();
						System.out.println((new StringBuilder("--------------------->current idx: ")).append(i).append(" con is not use").toString());
					}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		break MISSING_BLOCK_LABEL_1543;
		Exception exception;
		exception;
		try
		{
			if (curfreeIndex > 15)
			{
				System.out.println((new StringBuilder("只试用本地开发，UAT上还是用连接池------------current con idx is ")).append(curfreeIndex).toString());
				System.out.println("get in close connections  what if it is free");
				for (int i = 0; i < curfreeIndex; i++)
					if (dbConns[i].isInnerClose() || dbConns[i].isClosed() || !dbConns[i].isInUse() || curfreeIndex > 20)
					{
						dbConns[i].close();
						System.out.println((new StringBuilder("--------------------->current idx: ")).append(i).append(" con is not use").toString());
					}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		throw exception;
		return dbConn;
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
			for (int nIndex = 0; nIndex < 50; nIndex++)
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
		dbConns = new DBConn[50];
		for (int nIndex = 0; nIndex < 50; nIndex++)
			dbConns[nIndex] = new DBConn();

	}
}
