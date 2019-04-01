// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyPayRelaDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPDutyPayRelaSchema;
import com.sinosoft.banklns.lis.vschema.LNPDutyPayRelaSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPDutyPayRelaDBSet extends LNPDutyPayRelaSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPDutyPayRelaDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPDutyPayRela");
		mflag = true;
	}

	public LNPDutyPayRelaDBSet()
	{
		mflag = false;
		db = new DBOper("LNPDutyPayRela");
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
			tError.moduleName = "LNPDutyPayRelaDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPDutyPayRela WHERE  DutyCode = ? AND PayPlanCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getDutyCode() == null || get(i).getDutyCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getDutyCode());
				if (get(i).getPayPlanCode() == null || get(i).getPayPlanCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getPayPlanCode());
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
			tError.moduleName = "LNPDutyPayRelaDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPDutyPayRela SET  DutyCode = ? , PayPlanCode = ? , PayPlanName = ? WHERE  DutyCode = ? AND PayPlanCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getDutyCode() == null || get(i).getDutyCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getDutyCode());
				if (get(i).getPayPlanCode() == null || get(i).getPayPlanCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getPayPlanCode());
				if (get(i).getPayPlanName() == null || get(i).getPayPlanName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getPayPlanName());
				if (get(i).getDutyCode() == null || get(i).getDutyCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getDutyCode());
				if (get(i).getPayPlanCode() == null || get(i).getPayPlanCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPayPlanCode());
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
			tError.moduleName = "LNPDutyPayRelaDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPDutyPayRela VALUES( ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getDutyCode() == null || get(i).getDutyCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getDutyCode());
				if (get(i).getPayPlanCode() == null || get(i).getPayPlanCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getPayPlanCode());
				if (get(i).getPayPlanName() == null || get(i).getPayPlanName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getPayPlanName());
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
			tError.moduleName = "LNPDutyPayRelaDBSet";
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
