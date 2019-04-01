// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MSysVarDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MSysVarSchema;
import com.sinosoft.map.lis.vschema.MSysVarSet;
import com.sinosoft.map.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MSysVarDBSet extends MSysVarSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MSysVarDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MSysVar");
		mflag = true;
	}

	public MSysVarDBSet()
	{
		mflag = false;
		db = new DBOper("MSysVar");
		con = db.getConnection();
	}

	public boolean deleteSQL()
	{
		if (db.deleteSQL(this))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MSysVarDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "²Ù×÷Ê§°Ü!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("DELETE FROM MSysVar WHERE  VarType = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getVarType() == null || get(i).getVarType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getVarType());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MSysVarDBSet";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("UPDATE MSysVar SET  VarType = ? , VarValue = ? WHERE  VarType = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getVarType() == null || get(i).getVarType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getVarType());
				if (get(i).getVarValue() == null || get(i).getVarValue().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getVarValue());
				if (get(i).getVarType() == null || get(i).getVarType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getVarType());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MSysVarDBSet";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("INSERT INTO MSysVar VALUES( ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getVarType() == null || get(i).getVarType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getVarType());
				if (get(i).getVarValue() == null || get(i).getVarValue().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getVarValue());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MSysVarDBSet";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}
}
