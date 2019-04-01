// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInvestmentAccountInfoDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPInvestmentAccountInfoSchema;
import com.sinosoft.banklns.lis.vschema.LNPInvestmentAccountInfoSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;

public class LNPInvestmentAccountInfoDBSet extends LNPInvestmentAccountInfoSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;

	public LNPInvestmentAccountInfoDBSet(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		con = tConnection;
		db = new DBOper(con, "LNPInvestmentAccountInfo");
		mflag = true;
	}

	public LNPInvestmentAccountInfoDBSet()
	{
		mflag = false;
		mErrors = new CErrors();
		db = new DBOper("LNPInvestmentAccountInfo");
		con = db.getConnection();
	}

	public boolean insert()
	{
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPInvestmentAccountInfoSchema aSchema = new LNPInvestmentAccountInfoSchema();
			aSchema.setSchema(get(i));
			if (!db.insert(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPInvestmentAccountInfoDBSet";
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
			LNPInvestmentAccountInfoSchema aSchema = new LNPInvestmentAccountInfoSchema();
			aSchema.setSchema(get(i));
			if (!db.update(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPInvestmentAccountInfoDBSet";
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
			LNPInvestmentAccountInfoSchema aSchema = new LNPInvestmentAccountInfoSchema();
			aSchema.setSchema(get(i));
			if (!db.deleteSQL(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPInvestmentAccountInfoDBSet";
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
			LNPInvestmentAccountInfoSchema aSchema = new LNPInvestmentAccountInfoSchema();
			aSchema.setSchema(get(i));
			if (!db.delete(aSchema))
			{
				mErrors.copyAllErrors(db.mErrors);
				CError tError = new CError();
				tError.moduleName = "LNPInvestmentAccountInfoDBSet";
				tError.functionName = "delete";
				tError.errorMessage = "²Ù×÷Ê§°Ü!";
				mErrors.addOneError(tError);
				return false;
			}
		}

		return true;
	}
}
