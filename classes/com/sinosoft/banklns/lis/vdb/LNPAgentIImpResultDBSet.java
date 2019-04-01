// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentIImpResultDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPAgentIImpResultSchema;
import com.sinosoft.banklns.lis.vschema.LNPAgentIImpResultSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPAgentIImpResultDBSet extends LNPAgentIImpResultSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPAgentIImpResultDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPAgentIImpResult");
		mflag = true;
	}

	public LNPAgentIImpResultDBSet()
	{
		mflag = false;
		db = new DBOper("LNPAgentIImpResult");
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
			tError.moduleName = "LNPAgentIImpResultDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPAgentIImpResult WHERE  ResultId = ? AND Grouporder = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getResultId() == null || get(i).getResultId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getResultId());
				if (get(i).getGrouporder() == null || get(i).getGrouporder().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getGrouporder());
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
			tError.moduleName = "LNPAgentIImpResultDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPAgentIImpResult SET  ResultId = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , ImpartId = ? , Grouporder = ? , QID01 = ? , A01 = ? , QID02 = ? , A02 = ? , QID03 = ? , A03 = ? , QID04 = ? , A04 = ? , QID05 = ? , A05 = ? , QID06 = ? , A06 = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ? AND Grouporder = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getResultId() == null || get(i).getResultId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getResultId());
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getProposalContNo());
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getImpartId());
				if (get(i).getGrouporder() == null || get(i).getGrouporder().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getGrouporder());
				if (get(i).getQID01() == null || get(i).getQID01().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getQID01());
				if (get(i).getA01() == null || get(i).getA01().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getA01());
				if (get(i).getQID02() == null || get(i).getQID02().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getQID02());
				if (get(i).getA02() == null || get(i).getA02().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getA02());
				if (get(i).getQID03() == null || get(i).getQID03().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getQID03());
				if (get(i).getA03() == null || get(i).getA03().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getA03());
				if (get(i).getQID04() == null || get(i).getQID04().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getQID04());
				if (get(i).getA04() == null || get(i).getA04().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getA04());
				if (get(i).getQID05() == null || get(i).getQID05().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getQID05());
				if (get(i).getA05() == null || get(i).getA05().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getA05());
				if (get(i).getQID06() == null || get(i).getQID06().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getQID06());
				if (get(i).getA06() == null || get(i).getA06().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getA06());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(21, null);
				else
					pstmt.setDate(21, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(23, null);
				else
					pstmt.setDate(23, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getModifyTime());
				if (get(i).getResultId() == null || get(i).getResultId().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getResultId());
				if (get(i).getGrouporder() == null || get(i).getGrouporder().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getGrouporder());
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
			tError.moduleName = "LNPAgentIImpResultDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPAgentIImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getResultId() == null || get(i).getResultId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getResultId());
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getProposalContNo());
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getImpartId());
				if (get(i).getGrouporder() == null || get(i).getGrouporder().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getGrouporder());
				if (get(i).getQID01() == null || get(i).getQID01().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getQID01());
				if (get(i).getA01() == null || get(i).getA01().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getA01());
				if (get(i).getQID02() == null || get(i).getQID02().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getQID02());
				if (get(i).getA02() == null || get(i).getA02().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getA02());
				if (get(i).getQID03() == null || get(i).getQID03().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getQID03());
				if (get(i).getA03() == null || get(i).getA03().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getA03());
				if (get(i).getQID04() == null || get(i).getQID04().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getQID04());
				if (get(i).getA04() == null || get(i).getA04().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getA04());
				if (get(i).getQID05() == null || get(i).getQID05().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getQID05());
				if (get(i).getA05() == null || get(i).getA05().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getA05());
				if (get(i).getQID06() == null || get(i).getQID06().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getQID06());
				if (get(i).getA06() == null || get(i).getA06().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getA06());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(21, null);
				else
					pstmt.setDate(21, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(23, null);
				else
					pstmt.setDate(23, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getModifyTime());
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
			tError.moduleName = "LNPAgentIImpResultDBSet";
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
