// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MAdminLoginLogDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MAdminLoginLogSchema;
import com.sinosoft.map.lis.vschema.MAdminLoginLogSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MAdminLoginLogDBSet extends MAdminLoginLogSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MAdminLoginLogDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MAdminLoginLog");
		mflag = true;
	}

	public MAdminLoginLogDBSet()
	{
		mflag = false;
		db = new DBOper("MAdminLoginLog");
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
			tError.moduleName = "MAdminLoginLogDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MAdminLoginLog WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
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
			tError.moduleName = "MAdminLoginLogDBSet";
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
			pstmt = con.prepareStatement("UPDATE MAdminLoginLog SET  ID = ? , AgentCode = ? , UserType = ? , ClientName = ? , ClientType = ? , ClientIP = ? , LoginDate = ? , LoginTime = ? , LogoutDate = ? , LogoutTime = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
				if (get(i).getUserType() == null || get(i).getUserType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getUserType());
				if (get(i).getClientName() == null || get(i).getClientName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getClientName());
				if (get(i).getClientType() == null || get(i).getClientType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getClientType());
				if (get(i).getClientIP() == null || get(i).getClientIP().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getClientIP());
				if (get(i).getLoginDate() == null || get(i).getLoginDate().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getLoginDate()));
				if (get(i).getLoginTime() == null || get(i).getLoginTime().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getLoginTime());
				if (get(i).getLogoutDate() == null || get(i).getLogoutDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getLogoutDate()));
				if (get(i).getLogoutTime() == null || get(i).getLogoutTime().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getLogoutTime());
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getID());
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
			tError.moduleName = "MAdminLoginLogDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MAdminLoginLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
				if (get(i).getUserType() == null || get(i).getUserType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getUserType());
				if (get(i).getClientName() == null || get(i).getClientName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getClientName());
				if (get(i).getClientType() == null || get(i).getClientType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getClientType());
				if (get(i).getClientIP() == null || get(i).getClientIP().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getClientIP());
				if (get(i).getLoginDate() == null || get(i).getLoginDate().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getLoginDate()));
				if (get(i).getLoginTime() == null || get(i).getLoginTime().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getLoginTime());
				if (get(i).getLogoutDate() == null || get(i).getLogoutDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getLogoutDate()));
				if (get(i).getLogoutTime() == null || get(i).getLogoutTime().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getLogoutTime());
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
			tError.moduleName = "MAdminLoginLogDBSet";
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
