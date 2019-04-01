// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPBonusInfoDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema;
import com.sinosoft.banklns.lis.vschema.LNPBonusInfoSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPBonusInfoDBSet extends LNPBonusInfoSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPBonusInfoDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPBonusInfo");
		mflag = true;
	}

	public LNPBonusInfoDBSet()
	{
		mflag = false;
		db = new DBOper("LNPBonusInfo");
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
			tError.moduleName = "LNPBonusInfoDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPBonusInfo WHERE  ContNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContNo());
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
			tError.moduleName = "LNPBonusInfoDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPBonusInfo SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , BonusType = ? , BonusWay = ? , AutoRepaid = ? , cutPayAll = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? WHERE  ContNo = ?");
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
				if (get(i).getBonusType() == null || get(i).getBonusType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBonusType());
				if (get(i).getBonusWay() == null || get(i).getBonusWay().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBonusWay());
				if (get(i).getAutoRepaid() == null || get(i).getAutoRepaid().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getAutoRepaid());
				if (get(i).getCutPayAll() == null || get(i).getCutPayAll().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCutPayAll());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getModifyTime());
				if (get(i).getP2() == null || get(i).getP2().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getP2());
				if (get(i).getP4() == null || get(i).getP4().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getP4());
				if (get(i).getP3() == null || get(i).getP3().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getP3());
				if (get(i).getP1() == null || get(i).getP1().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getP1());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getContNo());
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
			tError.moduleName = "LNPBonusInfoDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPBonusInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getBonusType() == null || get(i).getBonusType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBonusType());
				if (get(i).getBonusWay() == null || get(i).getBonusWay().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBonusWay());
				if (get(i).getAutoRepaid() == null || get(i).getAutoRepaid().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getAutoRepaid());
				if (get(i).getCutPayAll() == null || get(i).getCutPayAll().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCutPayAll());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getModifyTime());
				if (get(i).getP2() == null || get(i).getP2().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getP2());
				if (get(i).getP4() == null || get(i).getP4().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getP4());
				if (get(i).getP3() == null || get(i).getP3().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getP3());
				if (get(i).getP1() == null || get(i).getP1().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getP1());
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
			tError.moduleName = "LNPBonusInfoDBSet";
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
