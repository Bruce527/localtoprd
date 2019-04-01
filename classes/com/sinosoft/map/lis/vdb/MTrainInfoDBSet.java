// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MTrainInfoDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MTrainInfoSchema;
import com.sinosoft.map.lis.vschema.MTrainInfoSet;
import com.sinosoft.map.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MTrainInfoDBSet extends MTrainInfoSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MTrainInfoDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MTrainInfo");
		mflag = true;
	}

	public MTrainInfoDBSet()
	{
		mflag = false;
		db = new DBOper("MTrainInfo");
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
			tError.moduleName = "MTrainInfoDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MTrainInfo WHERE  ID = ?");
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
			tError.moduleName = "MTrainInfoDBSet";
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
			pstmt = con.prepareStatement("UPDATE MTrainInfo SET  ID = ? , AgentCode = ? , AgentName = ? , AgentGrade = ? , AgentGroup = ? , ManageCom = ? , BranchType = ? , CourseID = ? , TrainStart = ? , TrainEnd = ? , TrainAdd = ? , Hours = ? , Teacher = ? , PassFlag = ? , Score = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ID = ?");
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
				if (get(i).getAgentName() == null || get(i).getAgentName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAgentName());
				if (get(i).getAgentGrade() == null || get(i).getAgentGrade().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAgentGrade());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAgentGroup());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getBranchType());
				if (get(i).getCourseID() == null || get(i).getCourseID().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCourseID());
				if (get(i).getTrainAdd() == null || get(i).getTrainAdd().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getTrainAdd());
				if (get(i).getHours() == null || get(i).getHours().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getHours());
				if (get(i).getTeacher() == null || get(i).getTeacher().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getTeacher());
				if (get(i).getPassFlag() == null || get(i).getPassFlag().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getPassFlag());
				if (get(i).getScore() == null || get(i).getScore().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getScore());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOperator());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getMakeTime());
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getModifyTime());
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
			tError.moduleName = "MTrainInfoDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MTrainInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getAgentName() == null || get(i).getAgentName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAgentName());
				if (get(i).getAgentGrade() == null || get(i).getAgentGrade().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAgentGrade());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAgentGroup());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getBranchType());
				if (get(i).getCourseID() == null || get(i).getCourseID().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCourseID());
				if (get(i).getTrainAdd() == null || get(i).getTrainAdd().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getTrainAdd());
				if (get(i).getHours() == null || get(i).getHours().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getHours());
				if (get(i).getTeacher() == null || get(i).getTeacher().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getTeacher());
				if (get(i).getPassFlag() == null || get(i).getPassFlag().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getPassFlag());
				if (get(i).getScore() == null || get(i).getScore().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getScore());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOperator());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getMakeTime());
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
			tError.moduleName = "MTrainInfoDBSet";
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
