// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBSemaphore.java

package com.sinosoft.map.utility;


public class DBSemaphore
{

	private static volatile boolean m_bInUse = false;
	private static String m_szObject = "DBSemaphore";

	public DBSemaphore()
	{
	}

	protected static synchronized boolean setInUseFlag(boolean bNewValue)
	{
		if (bNewValue)
		{
			if (m_bInUse)
			{
				return false;
			} else
			{
				m_bInUse = true;
				return true;
			}
		} else
		{
			m_bInUse = false;
			return true;
		}
	}

	protected static void Lock()
		throws Exception
	{
		Lock(10);
	}

	protected static void Lock(int nSeconds)
		throws Exception
	{
		if (nSeconds <= 0)
		{
			for (; !setInUseFlag(true); Thread.sleep(100L));
		} else
		{
			for (; !setInUseFlag(true) && nSeconds-- > 0; Thread.sleep(100L));
			if (nSeconds == 0)
				throw new Exception("Lock time out");
		}
	}

	protected static void UnLock()
	{
		setInUseFlag(false);
	}

}
