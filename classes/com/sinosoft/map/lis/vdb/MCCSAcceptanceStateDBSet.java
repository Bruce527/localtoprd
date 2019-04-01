// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MCCSAcceptanceStateDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MCCSAcceptanceStateSchema;
import com.sinosoft.map.lis.vschema.MCCSAcceptanceStateSet;
import com.sinosoft.map.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MCCSAcceptanceStateDBSet extends MCCSAcceptanceStateSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MCCSAcceptanceStateDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MCCSAcceptanceState");
		mflag = true;
	}

	public MCCSAcceptanceStateDBSet()
	{
		mflag = false;
		db = new DBOper("MCCSAcceptanceState");
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
			tError.moduleName = "MCCSAcceptanceStateDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MCCSAcceptanceState WHERE  ServiceNo = ? AND AgentCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getServiceNo() == null || get(i).getServiceNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getServiceNo());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
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
			tError.moduleName = "MCCSAcceptanceStateDBSet";
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
			pstmt = con.prepareStatement("UPDATE MCCSAcceptanceState SET  ServiceNo = ? , AgentCode = ? , Status = ? , BY1 = ? , BY2 = ? , BY3 = ? WHERE  ServiceNo = ? AND AgentCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getServiceNo() == null || get(i).getServiceNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getServiceNo());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
				if (get(i).getStatus() == null || get(i).getStatus().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getStatus());
				if (get(i).getBY1() == null || get(i).getBY1().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBY1());
				if (get(i).getBY2() == null || get(i).getBY2().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBY2());
				if (get(i).getBY3() == null || get(i).getBY3().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBY3());
				if (get(i).getServiceNo() == null || get(i).getServiceNo().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getServiceNo());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAgentCode());
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
			tError.moduleName = "MCCSAcceptanceStateDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MCCSAcceptanceState VALUES( ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getServiceNo() == null || get(i).getServiceNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getServiceNo());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
				if (get(i).getStatus() == null || get(i).getStatus().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getStatus());
				if (get(i).getBY1() == null || get(i).getBY1().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBY1());
				if (get(i).getBY2() == null || get(i).getBY2().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBY2());
				if (get(i).getBY3() == null || get(i).getBY3().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBY3());
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
			tError.moduleName = "MCCSAcceptanceStateDBSet";
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
