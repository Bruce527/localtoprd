// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvTopicBDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MInvTopicBSchema;
import com.sinosoft.map.lis.vschema.MInvTopicBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MInvTopicBDBSet extends MInvTopicBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MInvTopicBDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MInvTopicB");
		mflag = true;
	}

	public MInvTopicBDBSet()
	{
		mflag = false;
		db = new DBOper("MInvTopicB");
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
			tError.moduleName = "MInvTopicBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MInvTopicB WHERE  EdorNo = ?");
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
			tError.moduleName = "MInvTopicBDBSet";
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
			pstmt = con.prepareStatement("UPDATE MInvTopicB SET  TopicID = ? , Topic = ? , ManageCom = ? , BranchType = ? , Depiction = ? , Author = ? , Population = ? , StartDate = ? , EndDate = ? , InvType = ? , State = ? , InvState = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getTopicID() == null || get(i).getTopicID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getTopicID());
				if (get(i).getTopic() == null || get(i).getTopic().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getTopic());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBranchType());
				if (get(i).getDepiction() == null || get(i).getDepiction().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getDepiction());
				if (get(i).getAuthor() == null || get(i).getAuthor().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAuthor());
				pstmt.setInt(7, get(i).getPopulation());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getEndDate()));
				if (get(i).getInvType() == null || get(i).getInvType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getInvType());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getState());
				if (get(i).getInvState() == null || get(i).getInvState().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getInvState());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getNF01());
				pstmt.setInt(20, get(i).getIF01());
				pstmt.setDouble(21, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(25, null);
				else
					pstmt.setDate(25, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getModifyTime());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(33, null);
				else
					pstmt.setDate(33, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getMakeTime2());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getEdorNo());
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
			tError.moduleName = "MInvTopicBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MInvTopicB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getTopicID() == null || get(i).getTopicID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getTopicID());
				if (get(i).getTopic() == null || get(i).getTopic().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getTopic());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBranchType());
				if (get(i).getDepiction() == null || get(i).getDepiction().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getDepiction());
				if (get(i).getAuthor() == null || get(i).getAuthor().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAuthor());
				pstmt.setInt(7, get(i).getPopulation());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getEndDate()));
				if (get(i).getInvType() == null || get(i).getInvType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getInvType());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getState());
				if (get(i).getInvState() == null || get(i).getInvState().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getInvState());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getNF01());
				pstmt.setInt(20, get(i).getIF01());
				pstmt.setDouble(21, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(25, null);
				else
					pstmt.setDate(25, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getModifyTime());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(33, null);
				else
					pstmt.setDate(33, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getMakeTime2());
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
			tError.moduleName = "MInvTopicBDBSet";
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
