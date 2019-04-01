// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MHonorCheckDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MHonorCheckSchema;
import com.sinosoft.map.lis.vschema.MHonorCheckSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MHonorCheckDBSet extends MHonorCheckSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MHonorCheckDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MHonorCheck");
		mflag = true;
	}

	public MHonorCheckDBSet()
	{
		mflag = false;
		db = new DBOper("MHonorCheck");
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
			tError.moduleName = "MHonorCheckDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MHonorCheck WHERE  CheckID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCheckID() == null || get(i).getCheckID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCheckID());
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
			tError.moduleName = "MHonorCheckDBSet";
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
			pstmt = con.prepareStatement("UPDATE MHonorCheck SET  CheckID = ? , DataType = ? , StatYear = ? , ManageCom = ? , BranchType = ? , StatBatch = ? , StartDate = ? , EndDate = ? , CheckState = ? , InputState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CheckID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCheckID() == null || get(i).getCheckID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCheckID());
				if (get(i).getDataType() == null || get(i).getDataType().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getDataType());
				if (get(i).getStatYear() == null || get(i).getStatYear().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getStatYear());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBranchType());
				if (get(i).getStatBatch() == null || get(i).getStatBatch().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getStatBatch());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getEndDate()));
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCheckState());
				if (get(i).getInputState() == null || get(i).getInputState().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getInputState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCheckTime());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(19, null);
				else
					pstmt.setDate(19, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getModifyTime());
				if (get(i).getCheckID() == null || get(i).getCheckID().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getCheckID());
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
			tError.moduleName = "MHonorCheckDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MHonorCheck VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCheckID() == null || get(i).getCheckID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCheckID());
				if (get(i).getDataType() == null || get(i).getDataType().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getDataType());
				if (get(i).getStatYear() == null || get(i).getStatYear().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getStatYear());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBranchType());
				if (get(i).getStatBatch() == null || get(i).getStatBatch().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getStatBatch());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getEndDate()));
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCheckState());
				if (get(i).getInputState() == null || get(i).getInputState().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getInputState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCheckTime());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(19, null);
				else
					pstmt.setDate(19, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getModifyTime());
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
			tError.moduleName = "MHonorCheckDBSet";
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
