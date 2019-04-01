// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCalModeDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPCalModeSchema;
import com.sinosoft.banklns.lis.vschema.LNPCalModeSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPCalModeDBSet extends LNPCalModeSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPCalModeDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPCalMode");
		mflag = true;
	}

	public LNPCalModeDBSet()
	{
		mflag = false;
		db = new DBOper("LNPCalMode");
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
			tError.moduleName = "LNPCalModeDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCalMode WHERE  CalCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCalCode());
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
			tError.moduleName = "LNPCalModeDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPCalMode SET  CalCode = ? , RiskCode = ? , Type = ? , CalSQL = ? , Remark = ? WHERE  CalCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCalCode());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getType());
				if (get(i).getCalSQL() == null || get(i).getCalSQL().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getCalSQL());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRemark());
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getCalCode());
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
			tError.moduleName = "LNPCalModeDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCalMode VALUES( ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCalCode());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getType());
				if (get(i).getCalSQL() == null || get(i).getCalSQL().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getCalSQL());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRemark());
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
			tError.moduleName = "LNPCalModeDBSet";
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
