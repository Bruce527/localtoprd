// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBPack.java

package com.sinosoft.map.utility;


// Referenced classes of package com.sinosoft.map.utility:
//			CErrors, DBOper, Schema

public class DBPack
{

	private DBOper db;
	public CErrors mErrors;

	public DBPack()
	{
		db = null;
		mErrors = new CErrors();
	}

	public DBPack(String aSchName)
	{
		db = null;
		mErrors = new CErrors();
		db = new DBOper(aSchName);
	}

	public boolean update(Schema s)
	{
		if (!db.update(s))
		{
			mErrors.copyAllErrors(db.mErrors);
			return false;
		} else
		{
			return true;
		}
	}

	public static void main(String args[])
	{
		DBPack DBPack1 = new DBPack();
	}
}
