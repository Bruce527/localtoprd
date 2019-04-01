// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLibraryStructDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MLibraryStructSchema;
import com.sinosoft.map.lis.vschema.MLibraryStructSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MLibraryStructDBSet extends MLibraryStructSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MLibraryStructDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MLibraryStruct");
		mflag = true;
	}

	public MLibraryStructDBSet()
	{
		mflag = false;
		db = new DBOper("MLibraryStruct");
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
			tError.moduleName = "MLibraryStructDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MLibraryStruct WHERE  NodeID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNodeID() == null || get(i).getNodeID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNodeID());
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
			tError.moduleName = "MLibraryStructDBSet";
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
			pstmt = con.prepareStatement("UPDATE MLibraryStruct SET  NodeID = ? , Name = ? , ParentID = ? , Discription = ? , ManageCom = ? , BranchType = ? , Position = ? , Operation = ? , DirFlag = ? , FileFlag = ? , ChildDirNum = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  NodeID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNodeID() == null || get(i).getNodeID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNodeID());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getName());
				if (get(i).getParentID() == null || get(i).getParentID().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getParentID());
				if (get(i).getDiscription() == null || get(i).getDiscription().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getDiscription());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBranchType());
				pstmt.setInt(7, get(i).getPosition());
				if (get(i).getOperation() == null || get(i).getOperation().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getOperation());
				if (get(i).getDirFlag() == null || get(i).getDirFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getDirFlag());
				if (get(i).getFileFlag() == null || get(i).getFileFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getFileFlag());
				pstmt.setInt(11, get(i).getChildDirNum());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getNF01());
				pstmt.setInt(19, get(i).getIF01());
				pstmt.setDouble(20, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(21, null);
				else
					pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(26, null);
				else
					pstmt.setDate(26, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getModifyTime());
				if (get(i).getNodeID() == null || get(i).getNodeID().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getNodeID());
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
			tError.moduleName = "MLibraryStructDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MLibraryStruct VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNodeID() == null || get(i).getNodeID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNodeID());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getName());
				if (get(i).getParentID() == null || get(i).getParentID().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getParentID());
				if (get(i).getDiscription() == null || get(i).getDiscription().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getDiscription());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBranchType());
				pstmt.setInt(7, get(i).getPosition());
				if (get(i).getOperation() == null || get(i).getOperation().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getOperation());
				if (get(i).getDirFlag() == null || get(i).getDirFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getDirFlag());
				if (get(i).getFileFlag() == null || get(i).getFileFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getFileFlag());
				pstmt.setInt(11, get(i).getChildDirNum());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getNF01());
				pstmt.setInt(19, get(i).getIF01());
				pstmt.setDouble(20, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(21, null);
				else
					pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(26, null);
				else
					pstmt.setDate(26, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getModifyTime());
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
			tError.moduleName = "MLibraryStructDBSet";
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
