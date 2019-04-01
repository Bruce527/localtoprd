// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MPageCtrlDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MPageCtrlSchema;
import com.sinosoft.map.lis.vschema.MPageCtrlSet;
import com.sinosoft.map.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MPageCtrlDBSet extends MPageCtrlSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MPageCtrlDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MPageCtrl");
		mflag = true;
	}

	public MPageCtrlDBSet()
	{
		mflag = false;
		db = new DBOper("MPageCtrl");
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
			tError.moduleName = "MPageCtrlDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MPageCtrl WHERE  ID = ?");
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
			tError.moduleName = "MPageCtrlDBSet";
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
			pstmt = con.prepareStatement("UPDATE MPageCtrl SET  ID = ? , RoleID = ? , MenuID = ? , ButtonType = ? , ButtonID = ? , ButtonName = ? , ButtonSwitch = ? , ControlFlag = ? , ButtonDescription = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getRoleID() == null || get(i).getRoleID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRoleID());
				if (get(i).getMenuID() == null || get(i).getMenuID().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getMenuID());
				if (get(i).getButtonType() == null || get(i).getButtonType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getButtonType());
				if (get(i).getButtonID() == null || get(i).getButtonID().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getButtonID());
				if (get(i).getButtonName() == null || get(i).getButtonName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getButtonName());
				pstmt.setInt(7, get(i).getButtonSwitch());
				if (get(i).getControlFlag() == null || get(i).getControlFlag().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getControlFlag());
				if (get(i).getButtonDescription() == null || get(i).getButtonDescription().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getButtonDescription());
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getID());
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
			tError.moduleName = "MPageCtrlDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MPageCtrl VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getRoleID() == null || get(i).getRoleID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRoleID());
				if (get(i).getMenuID() == null || get(i).getMenuID().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getMenuID());
				if (get(i).getButtonType() == null || get(i).getButtonType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getButtonType());
				if (get(i).getButtonID() == null || get(i).getButtonID().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getButtonID());
				if (get(i).getButtonName() == null || get(i).getButtonName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getButtonName());
				pstmt.setInt(7, get(i).getButtonSwitch());
				if (get(i).getControlFlag() == null || get(i).getControlFlag().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getControlFlag());
				if (get(i).getButtonDescription() == null || get(i).getButtonDescription().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getButtonDescription());
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
			tError.moduleName = "MPageCtrlDBSet";
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
