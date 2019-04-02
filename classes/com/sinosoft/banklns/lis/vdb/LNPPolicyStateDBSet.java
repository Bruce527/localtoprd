// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPolicyStateDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPPolicyStateSchema;
import com.sinosoft.banklns.lis.vschema.LNPPolicyStateSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;

public class LNPPolicyStateDBSet extends LNPPolicyStateSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;

	public LNPPolicyStateDBSet(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		con = tConnection;
		db = new DBOper(con, "LNPPolicyState");
		mflag = true;
	}

	public LNPPolicyStateDBSet()
	{
		mflag = false;
		mErrors = new CErrors();
		db = new DBOper("LNPPolicyState");
		con = db.getConnection();
	}

	public boolean insert()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPPolicyStateSchema aSchema = new LNPPolicyStateSchema();
			aSchema.setSchema(get(i));
			if (!db.insert(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPPolicyStateDBSet";
				tError.functionName = "insert";
				tError.errorMessage = "???????!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}

	public boolean update()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPPolicyStateSchema aSchema = new LNPPolicyStateSchema();
			aSchema.setSchema(get(i));
			if (!db.update(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPPolicyStateDBSet";
				tError.functionName = "update";
				tError.errorMessage = "???????!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}

	public boolean deleteSQL()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPPolicyStateSchema aSchema = new LNPPolicyStateSchema();
			aSchema.setSchema(get(i));
			if (!db.deleteSQL(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPPolicyStateDBSet";
				tError.functionName = "deleteSQL";
				tError.errorMessage = "???????!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}

	public boolean delete()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPPolicyStateSchema aSchema = new LNPPolicyStateSchema();
			aSchema.setSchema(get(i));
			if (!db.delete(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPPolicyStateDBSet";
				tError.functionName = "delete";
				tError.errorMessage = "???????!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}
}
