// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCUWMasterBDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPCUWMasterBSchema;
import com.sinosoft.banklns.lis.vschema.LNPCUWMasterBSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;

public class LNPCUWMasterBDBSet extends LNPCUWMasterBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;

	public LNPCUWMasterBDBSet(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		con = tConnection;
		db = new DBOper(con, "LNPCUWMasterB");
		mflag = true;
	}

	public LNPCUWMasterBDBSet()
	{
		mflag = false;
		mErrors = new CErrors();
		db = new DBOper("LNPCUWMasterB");
		con = db.getConnection();
	}

	public boolean insert()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPCUWMasterBSchema aSchema = new LNPCUWMasterBSchema();
			aSchema.setSchema(get(i));
			if (!db.insert(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPCUWMasterBDBSet";
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
			LNPCUWMasterBSchema aSchema = new LNPCUWMasterBSchema();
			aSchema.setSchema(get(i));
			if (!db.update(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPCUWMasterBDBSet";
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
			LNPCUWMasterBSchema aSchema = new LNPCUWMasterBSchema();
			aSchema.setSchema(get(i));
			if (!db.deleteSQL(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPCUWMasterBDBSet";
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
			LNPCUWMasterBSchema aSchema = new LNPCUWMasterBSchema();
			aSchema.setSchema(get(i));
			if (!db.delete(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPCUWMasterBDBSet";
				tError.functionName = "delete";
				tError.errorMessage = "²Ù×÷Ê§°Ü!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}
}
