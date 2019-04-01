// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPOperationRecordBDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPOperationRecordBSchema;
import com.sinosoft.banklns.lis.vschema.LNPOperationRecordBSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;

public class LNPOperationRecordBDBSet extends LNPOperationRecordBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;

	public LNPOperationRecordBDBSet(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		con = tConnection;
		db = new DBOper(con, "LNPOperationRecordB");
		mflag = true;
	}

	public LNPOperationRecordBDBSet()
	{
		mflag = false;
		mErrors = new CErrors();
		db = new DBOper("LNPOperationRecordB");
		con = db.getConnection();
	}

	public boolean insert()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPOperationRecordBSchema aSchema = new LNPOperationRecordBSchema();
			aSchema.setSchema(get(i));
			if (!db.insert(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPOperationRecordBDBSet";
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
			LNPOperationRecordBSchema aSchema = new LNPOperationRecordBSchema();
			aSchema.setSchema(get(i));
			if (!db.update(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPOperationRecordBDBSet";
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
			LNPOperationRecordBSchema aSchema = new LNPOperationRecordBSchema();
			aSchema.setSchema(get(i));
			if (!db.deleteSQL(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPOperationRecordBDBSet";
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
			LNPOperationRecordBSchema aSchema = new LNPOperationRecordBSchema();
			aSchema.setSchema(get(i));
			if (!db.delete(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPOperationRecordBDBSet";
				tError.functionName = "delete";
				tError.errorMessage = "²Ù×÷Ê§°Ü!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}
}
