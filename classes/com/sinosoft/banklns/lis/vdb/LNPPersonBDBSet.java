// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPersonBDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPPersonBSchema;
import com.sinosoft.banklns.lis.vschema.LNPPersonBSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;

public class LNPPersonBDBSet extends LNPPersonBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;

	public LNPPersonBDBSet(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		con = tConnection;
		db = new DBOper(con, "LNPPersonB");
		mflag = true;
	}

	public LNPPersonBDBSet()
	{
		mflag = false;
		mErrors = new CErrors();
		db = new DBOper("LNPPersonB");
		con = db.getConnection();
	}

	public boolean insert()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPPersonBSchema aSchema = new LNPPersonBSchema();
			aSchema.setSchema(get(i));
			if (!db.insert(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPPersonBDBSet";
				tError.functionName = "insert";
				tError.errorMessage = "²Ù×÷Ê§°Ü!";
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
			LNPPersonBSchema aSchema = new LNPPersonBSchema();
			aSchema.setSchema(get(i));
			if (!db.update(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPPersonBDBSet";
				tError.functionName = "update";
				tError.errorMessage = "²Ù×÷Ê§°Ü!";
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
			LNPPersonBSchema aSchema = new LNPPersonBSchema();
			aSchema.setSchema(get(i));
			if (!db.deleteSQL(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPPersonBDBSet";
				tError.functionName = "deleteSQL";
				tError.errorMessage = "²Ù×÷Ê§°Ü!";
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
			LNPPersonBSchema aSchema = new LNPPersonBSchema();
			aSchema.setSchema(get(i));
			if (!db.delete(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPPersonBDBSet";
				tError.functionName = "delete";
				tError.errorMessage = "²Ù×÷Ê§°Ü!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}
}
