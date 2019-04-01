// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MRoleMenuMapBDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MRoleMenuMapBSchema;
import com.sinosoft.map.lis.vschema.MRoleMenuMapBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MRoleMenuMapBDBSet extends MRoleMenuMapBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MRoleMenuMapBDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MRoleMenuMapB");
		mflag = true;
	}

	public MRoleMenuMapBDBSet()
	{
		mflag = false;
		db = new DBOper("MRoleMenuMapB");
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
			tError.moduleName = "MRoleMenuMapBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MRoleMenuMapB WHERE  EdorNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getEdorNo());
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
			tError.moduleName = "MRoleMenuMapBDBSet";
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
			pstmt = con.prepareStatement("UPDATE MRoleMenuMapB SET  ID = ? , RoleID = ? , MenuID = ? , Type = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
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
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getType());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getModifyTime());
				pstmt.setInt(10, get(i).getInt1());
				pstmt.setInt(11, get(i).getInt2());
				if (get(i).getVarc1() == null || get(i).getVarc1().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getVarc1());
				if (get(i).getVarc2() == null || get(i).getVarc2().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVarc2());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getMakeTime2());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getEdorNo());
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
			tError.moduleName = "MRoleMenuMapBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MRoleMenuMapB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getType());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getModifyTime());
				pstmt.setInt(10, get(i).getInt1());
				pstmt.setInt(11, get(i).getInt2());
				if (get(i).getVarc1() == null || get(i).getVarc1().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getVarc1());
				if (get(i).getVarc2() == null || get(i).getVarc2().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVarc2());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getMakeTime2());
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
			tError.moduleName = "MRoleMenuMapBDBSet";
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
