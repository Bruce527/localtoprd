// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLibraryDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MLibrarySchema;
import com.sinosoft.map.lis.vschema.MLibrarySet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MLibraryDBSet extends MLibrarySet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MLibraryDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MLibrary");
		mflag = true;
	}

	public MLibraryDBSet()
	{
		mflag = false;
		db = new DBOper("MLibrary");
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
			tError.moduleName = "MLibraryDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MLibrary WHERE  FileID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getFileID() == null || get(i).getFileID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getFileID());
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
			tError.moduleName = "MLibraryDBSet";
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
			pstmt = con.prepareStatement("UPDATE MLibrary SET  FileID = ? , Name = ? , DisplayName = ? , FileDescription = ? , ManageCom = ? , BranchType = ? , NodeID = ? , FileType = ? , FilePath = ? , DocumentType = ? , StartDisplayDate = ? , EndDisplayDate = ? , MinDisplayGrade = ? , StartDisplayTime = ? , EndDisplayTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , State = ? WHERE  FileID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getFileID() == null || get(i).getFileID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getFileID());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getName());
				if (get(i).getDisplayName() == null || get(i).getDisplayName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getDisplayName());
				if (get(i).getFileDescription() == null || get(i).getFileDescription().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getFileDescription());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBranchType());
				if (get(i).getNodeID() == null || get(i).getNodeID().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getNodeID());
				if (get(i).getFileType() == null || get(i).getFileType().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getFileType());
				if (get(i).getFilePath() == null || get(i).getFilePath().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getFilePath());
				if (get(i).getDocumentType() == null || get(i).getDocumentType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getDocumentType());
				if (get(i).getStartDisplayDate() == null || get(i).getStartDisplayDate().equals("null"))
					pstmt.setDate(11, null);
				else
					pstmt.setDate(11, Date.valueOf(get(i).getStartDisplayDate()));
				if (get(i).getEndDisplayDate() == null || get(i).getEndDisplayDate().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getEndDisplayDate()));
				if (get(i).getMinDisplayGrade() == null || get(i).getMinDisplayGrade().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getMinDisplayGrade());
				if (get(i).getStartDisplayTime() == null || get(i).getStartDisplayTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getStartDisplayTime());
				if (get(i).getEndDisplayTime() == null || get(i).getEndDisplayTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getEndDisplayTime());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(19, null);
				else
					pstmt.setDate(19, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getNF01());
				pstmt.setInt(23, get(i).getIF01());
				pstmt.setDouble(24, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(25, null);
				else
					pstmt.setDate(25, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(28, null);
				else
					pstmt.setDate(28, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(30, null);
				else
					pstmt.setDate(30, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getModifyTime());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getState());
				if (get(i).getFileID() == null || get(i).getFileID().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getFileID());
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
			tError.moduleName = "MLibraryDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MLibrary VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getFileID() == null || get(i).getFileID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getFileID());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getName());
				if (get(i).getDisplayName() == null || get(i).getDisplayName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getDisplayName());
				if (get(i).getFileDescription() == null || get(i).getFileDescription().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getFileDescription());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBranchType());
				if (get(i).getNodeID() == null || get(i).getNodeID().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getNodeID());
				if (get(i).getFileType() == null || get(i).getFileType().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getFileType());
				if (get(i).getFilePath() == null || get(i).getFilePath().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getFilePath());
				if (get(i).getDocumentType() == null || get(i).getDocumentType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getDocumentType());
				if (get(i).getStartDisplayDate() == null || get(i).getStartDisplayDate().equals("null"))
					pstmt.setDate(11, null);
				else
					pstmt.setDate(11, Date.valueOf(get(i).getStartDisplayDate()));
				if (get(i).getEndDisplayDate() == null || get(i).getEndDisplayDate().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getEndDisplayDate()));
				if (get(i).getMinDisplayGrade() == null || get(i).getMinDisplayGrade().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getMinDisplayGrade());
				if (get(i).getStartDisplayTime() == null || get(i).getStartDisplayTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getStartDisplayTime());
				if (get(i).getEndDisplayTime() == null || get(i).getEndDisplayTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getEndDisplayTime());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(19, null);
				else
					pstmt.setDate(19, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getNF01());
				pstmt.setInt(23, get(i).getIF01());
				pstmt.setDouble(24, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(25, null);
				else
					pstmt.setDate(25, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(28, null);
				else
					pstmt.setDate(28, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(30, null);
				else
					pstmt.setDate(30, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getModifyTime());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getState());
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
			tError.moduleName = "MLibraryDBSet";
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
