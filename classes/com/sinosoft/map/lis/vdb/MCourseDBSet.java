// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MCourseDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MCourseSchema;
import com.sinosoft.map.lis.vschema.MCourseSet;
import com.sinosoft.map.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MCourseDBSet extends MCourseSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MCourseDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MCourse");
		mflag = true;
	}

	public MCourseDBSet()
	{
		mflag = false;
		db = new DBOper("MCourse");
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
			tError.moduleName = "MCourseDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MCourse WHERE  ID = ?");
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
			tError.moduleName = "MCourseDBSet";
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
			pstmt = con.prepareStatement("UPDATE MCourse SET  ID = ? , CourseID = ? , CourseName = ? , ManageCom = ? , BranchType = ? , Hour = ? , DevelopBranch = ? , Developer = ? , DevelopeDate = ? , NoTi = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , course1 = ? , course2 = ? , course3 = ? , course4 = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getCourseID() == null || get(i).getCourseID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCourseID());
				if (get(i).getCourseName() == null || get(i).getCourseName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCourseName());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBranchType());
				if (get(i).getHour() == null || get(i).getHour().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getHour());
				if (get(i).getDevelopBranch() == null || get(i).getDevelopBranch().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getDevelopBranch());
				if (get(i).getDeveloper() == null || get(i).getDeveloper().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getDeveloper());
				if (get(i).getNoTi() == null || get(i).getNoTi().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getNoTi());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getOperator());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getModifyOperator());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getMakeTime());
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getModifyTime());
				if (get(i).getCourse1() == null || get(i).getCourse1().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCourse1());
				if (get(i).getCourse2() == null || get(i).getCourse2().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getCourse2());
				if (get(i).getCourse3() == null || get(i).getCourse3().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getCourse3());
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getID());
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
			tError.moduleName = "MCourseDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MCourse VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getCourseID() == null || get(i).getCourseID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCourseID());
				if (get(i).getCourseName() == null || get(i).getCourseName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCourseName());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBranchType());
				if (get(i).getHour() == null || get(i).getHour().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getHour());
				if (get(i).getDevelopBranch() == null || get(i).getDevelopBranch().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getDevelopBranch());
				if (get(i).getDeveloper() == null || get(i).getDeveloper().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getDeveloper());
				if (get(i).getNoTi() == null || get(i).getNoTi().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getNoTi());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getOperator());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getModifyOperator());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getMakeTime());
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getModifyTime());
				if (get(i).getCourse1() == null || get(i).getCourse1().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCourse1());
				if (get(i).getCourse2() == null || get(i).getCourse2().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getCourse2());
				if (get(i).getCourse3() == null || get(i).getCourse3().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getCourse3());
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
			tError.moduleName = "MCourseDBSet";
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
