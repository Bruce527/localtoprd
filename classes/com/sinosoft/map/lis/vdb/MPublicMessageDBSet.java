// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MPublicMessageDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MPublicMessageSchema;
import com.sinosoft.map.lis.vschema.MPublicMessageSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MPublicMessageDBSet extends MPublicMessageSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MPublicMessageDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MPublicMessage");
		mflag = true;
	}

	public MPublicMessageDBSet()
	{
		mflag = false;
		db = new DBOper("MPublicMessage");
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
			tError.moduleName = "MPublicMessageDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MPublicMessage WHERE  ID = ?");
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
			tError.moduleName = "MPublicMessageDBSet";
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
			pstmt = con.prepareStatement("UPDATE MPublicMessage SET  ID = ? , ManageCom = ? , ReceiveBranch = ? , BranchType = ? , Message = ? , Type = ? , Author = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getReceiveBranch() == null || get(i).getReceiveBranch().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getReceiveBranch());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBranchType());
				if (get(i).getMessage() == null || get(i).getMessage().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMessage());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getType());
				if (get(i).getAuthor() == null || get(i).getAuthor().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getAuthor());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getState());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getEndDate()));
				if (get(i).getStartTime() == null || get(i).getStartTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getStartTime());
				if (get(i).getEndTime() == null || get(i).getEndTime().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getEndTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getNF01());
				pstmt.setInt(15, get(i).getIF01());
				pstmt.setDouble(16, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getOperator());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getModifyOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getModifyTime());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getCheckTime());
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getID());
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
			tError.moduleName = "MPublicMessageDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MPublicMessage VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getReceiveBranch() == null || get(i).getReceiveBranch().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getReceiveBranch());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBranchType());
				if (get(i).getMessage() == null || get(i).getMessage().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMessage());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getType());
				if (get(i).getAuthor() == null || get(i).getAuthor().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getAuthor());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getState());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getEndDate()));
				if (get(i).getStartTime() == null || get(i).getStartTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getStartTime());
				if (get(i).getEndTime() == null || get(i).getEndTime().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getEndTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getNF01());
				pstmt.setInt(15, get(i).getIF01());
				pstmt.setDouble(16, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getOperator());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getModifyOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getModifyTime());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getCheckTime());
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
			tError.moduleName = "MPublicMessageDBSet";
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
