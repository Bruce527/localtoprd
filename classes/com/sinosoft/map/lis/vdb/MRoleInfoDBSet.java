// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MRoleInfoDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MRoleInfoSchema;
import com.sinosoft.map.lis.vschema.MRoleInfoSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MRoleInfoDBSet extends MRoleInfoSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MRoleInfoDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MRoleInfo");
		mflag = true;
	}

	public MRoleInfoDBSet()
	{
		mflag = false;
		db = new DBOper("MRoleInfo");
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
			tError.moduleName = "MRoleInfoDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MRoleInfo WHERE  ID = ?");
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
			tError.moduleName = "MRoleInfoDBSet";
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
			pstmt = con.prepareStatement("UPDATE MRoleInfo SET  ID = ? , RoleCode = ? , Name = ? , Parent = ? , Describe = ? , RoleState = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc3 = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getRoleCode() == null || get(i).getRoleCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRoleCode());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getName());
				if (get(i).getParent() == null || get(i).getParent().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getParent());
				if (get(i).getDescribe() == null || get(i).getDescribe().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getDescribe());
				if (get(i).getRoleState() == null || get(i).getRoleState().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getRoleState());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyTime());
				pstmt.setInt(12, get(i).getInt1());
				pstmt.setInt(13, get(i).getInt2());
				if (get(i).getVarc1() == null || get(i).getVarc1().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getVarc1());
				if (get(i).getVarc2() == null || get(i).getVarc2().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getVarc2());
				if (get(i).getVarc3() == null || get(i).getVarc3().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getVarc3());
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getID());
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
			tError.moduleName = "MRoleInfoDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MRoleInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getRoleCode() == null || get(i).getRoleCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRoleCode());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getName());
				if (get(i).getParent() == null || get(i).getParent().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getParent());
				if (get(i).getDescribe() == null || get(i).getDescribe().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getDescribe());
				if (get(i).getRoleState() == null || get(i).getRoleState().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getRoleState());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyTime());
				pstmt.setInt(12, get(i).getInt1());
				pstmt.setInt(13, get(i).getInt2());
				if (get(i).getVarc1() == null || get(i).getVarc1().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getVarc1());
				if (get(i).getVarc2() == null || get(i).getVarc2().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getVarc2());
				if (get(i).getVarc3() == null || get(i).getVarc3().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getVarc3());
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
			tError.moduleName = "MRoleInfoDBSet";
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
