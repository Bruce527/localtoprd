// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPSysVarDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPSysVarSchema;
import com.sinosoft.banklns.lis.vschema.LNPSysVarSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPSysVarDBSet extends LNPSysVarSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPSysVarDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPSysVar");
		mflag = true;
	}

	public LNPSysVarDBSet()
	{
		mflag = false;
		db = new DBOper("LNPSysVar");
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
			tError.moduleName = "LNPSysVarDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
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
			pstmt = con.prepareStatement("DELETE FROM LNPSysVar WHERE  SysVar = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getSysVar() == null || get(i).getSysVar().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getSysVar());
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
			tError.moduleName = "LNPSysVarDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPSysVar SET  SysVar = ? , SysVarType = ? , SysVarValue = ? WHERE  SysVar = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getSysVar() == null || get(i).getSysVar().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getSysVar());
				if (get(i).getSysVarType() == null || get(i).getSysVarType().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getSysVarType());
				if (get(i).getSysVarValue() == null || get(i).getSysVarValue().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getSysVarValue());
				if (get(i).getSysVar() == null || get(i).getSysVar().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getSysVar());
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
			tError.moduleName = "LNPSysVarDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPSysVar VALUES( ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getSysVar() == null || get(i).getSysVar().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getSysVar());
				if (get(i).getSysVarType() == null || get(i).getSysVarType().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getSysVarType());
				if (get(i).getSysVarValue() == null || get(i).getSysVarValue().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getSysVarValue());
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
			tError.moduleName = "LNPSysVarDBSet";
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
