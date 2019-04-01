// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MUserDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MUserSchema;
import com.sinosoft.map.lis.vschema.MUserSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MUserDBSet extends MUserSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MUserDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MUser");
		mflag = true;
	}

	public MUserDBSet()
	{
		mflag = false;
		db = new DBOper("MUser");
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
			tError.moduleName = "MUserDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MUser WHERE  UserCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getUserCode() == null || get(i).getUserCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getUserCode());
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
			tError.moduleName = "MUserDBSet";
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
			pstmt = con.prepareStatement("UPDATE MUser SET  UserCode = ? , UserName = ? , ManageCom = ? , BranchType = ? , Password = ? , PwdModifyDate = ? , UserDescription = ? , UserState = ? , SuperPopedomFlag = ? , ValidStartDate = ? , ValidEndDate = ? , StuffNo = ? , OfficePhone = ? , Phone = ? , EMail = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  UserCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getUserCode() == null || get(i).getUserCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getUserCode());
				if (get(i).getUserName() == null || get(i).getUserName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getUserName());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBranchType());
				if (get(i).getPassword() == null || get(i).getPassword().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPassword());
				if (get(i).getPwdModifyDate() == null || get(i).getPwdModifyDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getPwdModifyDate()));
				if (get(i).getUserDescription() == null || get(i).getUserDescription().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getUserDescription());
				if (get(i).getUserState() == null || get(i).getUserState().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getUserState());
				if (get(i).getSuperPopedomFlag() == null || get(i).getSuperPopedomFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getSuperPopedomFlag());
				if (get(i).getValidStartDate() == null || get(i).getValidStartDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getValidStartDate()));
				if (get(i).getValidEndDate() == null || get(i).getValidEndDate().equals("null"))
					pstmt.setDate(11, null);
				else
					pstmt.setDate(11, Date.valueOf(get(i).getValidEndDate()));
				if (get(i).getStuffNo() == null || get(i).getStuffNo().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getStuffNo());
				if (get(i).getOfficePhone() == null || get(i).getOfficePhone().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getOfficePhone());
				if (get(i).getPhone() == null || get(i).getPhone().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getPhone());
				if (get(i).getEMail() == null || get(i).getEMail().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getEMail());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOperator());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getModifyOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getModifyTime());
				if (get(i).getUserCode() == null || get(i).getUserCode().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getUserCode());
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
			tError.moduleName = "MUserDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MUser VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getUserCode() == null || get(i).getUserCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getUserCode());
				if (get(i).getUserName() == null || get(i).getUserName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getUserName());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBranchType());
				if (get(i).getPassword() == null || get(i).getPassword().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPassword());
				if (get(i).getPwdModifyDate() == null || get(i).getPwdModifyDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getPwdModifyDate()));
				if (get(i).getUserDescription() == null || get(i).getUserDescription().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getUserDescription());
				if (get(i).getUserState() == null || get(i).getUserState().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getUserState());
				if (get(i).getSuperPopedomFlag() == null || get(i).getSuperPopedomFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getSuperPopedomFlag());
				if (get(i).getValidStartDate() == null || get(i).getValidStartDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getValidStartDate()));
				if (get(i).getValidEndDate() == null || get(i).getValidEndDate().equals("null"))
					pstmt.setDate(11, null);
				else
					pstmt.setDate(11, Date.valueOf(get(i).getValidEndDate()));
				if (get(i).getStuffNo() == null || get(i).getStuffNo().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getStuffNo());
				if (get(i).getOfficePhone() == null || get(i).getOfficePhone().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getOfficePhone());
				if (get(i).getPhone() == null || get(i).getPhone().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getPhone());
				if (get(i).getEMail() == null || get(i).getEMail().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getEMail());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOperator());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getModifyOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getModifyTime());
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
			tError.moduleName = "MUserDBSet";
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
