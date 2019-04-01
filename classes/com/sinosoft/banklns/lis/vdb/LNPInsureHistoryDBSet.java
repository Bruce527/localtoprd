// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsureHistoryDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPInsureHistorySchema;
import com.sinosoft.banklns.lis.vschema.LNPInsureHistorySet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPInsureHistoryDBSet extends LNPInsureHistorySet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPInsureHistoryDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPInsureHistory");
		mflag = true;
	}

	public LNPInsureHistoryDBSet()
	{
		mflag = false;
		db = new DBOper("LNPInsureHistory");
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
			tError.moduleName = "LNPInsureHistoryDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPInsureHistory WHERE  ContNo = ? AND PolOrder = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContNo());
				if (get(i).getPolOrder() == null || get(i).getPolOrder().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getPolOrder());
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
			tError.moduleName = "LNPInsureHistoryDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPInsureHistory SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , PolOrder = ? , ComName = ? , SumInsuredDeath = ? , SumInsuredDisease = ? , PolicyState = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? WHERE  ContNo = ? AND PolOrder = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getProposalContNo());
				if (get(i).getPrtNo() == null || get(i).getPrtNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPrtNo());
				if (get(i).getPolOrder() == null || get(i).getPolOrder().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPolOrder());
				if (get(i).getComName() == null || get(i).getComName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getComName());
				pstmt.setDouble(7, get(i).getSumInsuredDeath());
				pstmt.setDouble(8, get(i).getSumInsuredDisease());
				if (get(i).getPolicyState() == null || get(i).getPolicyState().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getPolicyState());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getState());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getModifyTime());
				if (get(i).getP2() == null || get(i).getP2().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getP2());
				pstmt.setDouble(17, get(i).getP4());
				pstmt.setDouble(18, get(i).getP3());
				if (get(i).getP1() == null || get(i).getP1().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getP1());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getContNo());
				if (get(i).getPolOrder() == null || get(i).getPolOrder().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getPolOrder());
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
			tError.moduleName = "LNPInsureHistoryDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPInsureHistory VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getProposalContNo());
				if (get(i).getPrtNo() == null || get(i).getPrtNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPrtNo());
				if (get(i).getPolOrder() == null || get(i).getPolOrder().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPolOrder());
				if (get(i).getComName() == null || get(i).getComName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getComName());
				pstmt.setDouble(7, get(i).getSumInsuredDeath());
				pstmt.setDouble(8, get(i).getSumInsuredDisease());
				if (get(i).getPolicyState() == null || get(i).getPolicyState().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getPolicyState());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getState());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getModifyTime());
				if (get(i).getP2() == null || get(i).getP2().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getP2());
				pstmt.setDouble(17, get(i).getP4());
				pstmt.setDouble(18, get(i).getP3());
				if (get(i).getP1() == null || get(i).getP1().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getP1());
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
			tError.moduleName = "LNPInsureHistoryDBSet";
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
