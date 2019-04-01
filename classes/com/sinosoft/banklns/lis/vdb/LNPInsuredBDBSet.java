// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsuredBDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPInsuredBSchema;
import com.sinosoft.banklns.lis.vschema.LNPInsuredBSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;

public class LNPInsuredBDBSet extends LNPInsuredBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;

	public LNPInsuredBDBSet(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		con = tConnection;
		db = new DBOper(con, "LNPInsuredB");
		mflag = true;
	}

	public LNPInsuredBDBSet()
	{
		mflag = false;
		mErrors = new CErrors();
		db = new DBOper("LNPInsuredB");
		con = db.getConnection();
	}

	public boolean insert()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPInsuredBSchema aSchema = new LNPInsuredBSchema();
			aSchema.setSchema(get(i));
			if (!db.insert(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPInsuredBDBSet";
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
			LNPInsuredBSchema aSchema = new LNPInsuredBSchema();
			aSchema.setSchema(get(i));
			if (!db.update(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPInsuredBDBSet";
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
			LNPInsuredBSchema aSchema = new LNPInsuredBSchema();
			aSchema.setSchema(get(i));
			if (!db.deleteSQL(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPInsuredBDBSet";
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
			LNPInsuredBSchema aSchema = new LNPInsuredBSchema();
			aSchema.setSchema(get(i));
			if (!db.delete(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPInsuredBDBSet";
				tError.functionName = "delete";
				tError.errorMessage = "����ʧ��!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}
}
