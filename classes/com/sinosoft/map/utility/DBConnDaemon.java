// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBConnDaemon.java

package com.sinosoft.map.utility;

import java.util.Date;

// Referenced classes of package com.sinosoft.map.utility:
//			CErrors, DBSemaphore, DBConnPool, DBConn

public class DBConnDaemon extends Thread
{

	public CErrors mErrors;

	public DBConnDaemon()
	{
		mErrors = new CErrors();
	}

	public void run()
	{
		int nStep = 0;
		do
		{
			do
				try
				{
					do
					{
						Thread.sleep(30000L);
						nStep = 0;
						DBSemaphore.Lock();
						nStep = 1;
						daemonFunc();
						DBSemaphore.UnLock();
						nStep = 2;
					} while (true);
				}
				catch (Exception ex) { }
			while (nStep != 1);
			DBSemaphore.UnLock();
		} while (true);
	}

	private void daemonFunc()
		throws Exception
	{
		DBConn dbConns[] = DBConnPool.getDBConns();
		if (dbConns == null)
			return;
		int nIndex = 0;
		long lCurTime = (new Date()).getTime();
		for (nIndex = 0; nIndex < dbConns.length; nIndex++)
		{
			Date lastestAccess = dbConns[nIndex].getLastestAccess();
			if (lastestAccess != null)
			{
				long lLastestAccess = lastestAccess.getTime();
				if (dbConns[nIndex].isInUse())
				{
					if (lCurTime - lLastestAccess > 0x927c0L)
						dbConns[nIndex].close();
				} else
				if (lCurTime - lLastestAccess > 0x1b7740L)
					dbConns[nIndex].innerClose();
			}
		}

	}
}
