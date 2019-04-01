// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentInfoDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPAgentInfoDBSet extends LNPAgentInfoSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPAgentInfoDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPAgentInfo");
		mflag = true;
	}

	public LNPAgentInfoDBSet()
	{
		mflag = false;
		db = new DBOper("LNPAgentInfo");
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
			tError.moduleName = "LNPAgentInfoDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPAgentInfo WHERE  ContNo = ? AND AgentOrder = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContNo());
				if (get(i).getAgentOrder() == null || get(i).getAgentOrder().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentOrder());
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
			tError.moduleName = "LNPAgentInfoDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPAgentInfo SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , AgentOrder = ? , AgentName = ? , AgentCode = ? , BranchName = ? , BranchAttr = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? , PolPrintType = ?  WHERE  ContNo = ? AND AgentOrder = ?");
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
				if (get(i).getAgentOrder() == null || get(i).getAgentOrder().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAgentOrder());
				if (get(i).getAgentName() == null || get(i).getAgentName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAgentName());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getAgentCode());
				if (get(i).getBranchName() == null || get(i).getBranchName().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getBranchName());
				if (get(i).getBranchAttr() == null || get(i).getBranchAttr().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getBranchAttr());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(11, null);
				else
					pstmt.setDate(11, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getModifyTime());
				if (get(i).getP2() == null || get(i).getP2().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getP2());
				if (get(i).getP4() == null || get(i).getP4().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getP4());
				if (get(i).getP3() == null || get(i).getP3().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getP3());
				if (get(i).getP1() == null || get(i).getP1().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getP1());
				if (get(i).getPolPrintType() == null || get(i).getPolPrintType().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getPolPrintType());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getContNo());
				if (get(i).getAgentOrder() == null || get(i).getAgentOrder().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getAgentOrder());
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
			tError.moduleName = "LNPAgentInfoDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPAgentInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getAgentOrder() == null || get(i).getAgentOrder().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAgentOrder());
				if (get(i).getAgentName() == null || get(i).getAgentName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAgentName());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getAgentCode());
				if (get(i).getBranchName() == null || get(i).getBranchName().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getBranchName());
				if (get(i).getBranchAttr() == null || get(i).getBranchAttr().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getBranchAttr());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(11, null);
				else
					pstmt.setDate(11, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getModifyTime());
				if (get(i).getP2() == null || get(i).getP2().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getP2());
				if (get(i).getP4() == null || get(i).getP4().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getP4());
				if (get(i).getP3() == null || get(i).getP3().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getP3());
				if (get(i).getP1() == null || get(i).getP1().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getP1());
				if (get(i).getPolPrintType() == null || get(i).getPolPrintType().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getPolPrintType());
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
			tError.moduleName = "LNPAgentInfoDBSet";
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
