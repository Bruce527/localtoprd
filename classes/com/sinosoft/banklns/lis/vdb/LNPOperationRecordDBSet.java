// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPOperationRecordDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPOperationRecordSchema;
import com.sinosoft.banklns.lis.vschema.LNPOperationRecordSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;

public class LNPOperationRecordDBSet extends LNPOperationRecordSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;

	public LNPOperationRecordDBSet(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		con = tConnection;
		db = new DBOper(con, "LNPOperationRecord");
		mflag = true;
	}

	public LNPOperationRecordDBSet()
	{
		mflag = false;
		mErrors = new CErrors();
		db = new DBOper("LNPOperationRecord");
		con = db.getConnection();
	}

	public boolean insert()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPOperationRecordSchema aSchema = new LNPOperationRecordSchema();
			aSchema.setSchema(get(i));
			if (!db.insert(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPOperationRecordDBSet";
				tError.functionName = "insert";
				tError.errorMessage = "����ʧ��!";
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
			LNPOperationRecordSchema aSchema = new LNPOperationRecordSchema();
			aSchema.setSchema(get(i));
			if (!db.update(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPOperationRecordDBSet";
				tError.functionName = "update";
				tError.errorMessage = "����ʧ��!";
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
			LNPOperationRecordSchema aSchema = new LNPOperationRecordSchema();
			aSchema.setSchema(get(i));
			if (!db.deleteSQL(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPOperationRecordDBSet";
				tError.functionName = "deleteSQL";
				tError.errorMessage = "����ʧ��!";
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
			LNPOperationRecordSchema aSchema = new LNPOperationRecordSchema();
			aSchema.setSchema(get(i));
			if (!db.delete(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPOperationRecordDBSet";
				tError.functionName = "delete";
				tError.errorMessage = "����ʧ��!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}
}
