// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPFAndIImpResultDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPFAndIImpResultSchema;
import com.sinosoft.banklns.lis.vschema.LNPFAndIImpResultSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPFAndIImpResultDBSet extends LNPFAndIImpResultSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPFAndIImpResultDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPFAndIImpResult");
		mflag = true;
	}

	public LNPFAndIImpResultDBSet()
	{
		mflag = false;
		db = new DBOper("LNPFAndIImpResult");
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
			tError.moduleName = "LNPFAndIImpResultDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPFAndIImpResult WHERE  ResultId = ? AND Grouporder = ?");
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
			tError.moduleName = "LNPFAndIImpResultDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPFAndIImpResult SET  ResultId = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , ImpartId = ? , Grouporder = ? , QID01 = ? , A01 = ? , QID02 = ? , A02 = ? , QID03 = ? , A03 = ? , QID04 = ? , A04 = ? , QID05 = ? , A05 = ? , QID06 = ? , A06 = ? , QID07 = ? , A07 = ? , QID08 = ? , A08 = ? , QID09 = ? , A09 = ? , QID10 = ? , A10 = ? , QID11 = ? , A11 = ? , QID12 = ? , A12 = ? , QID13 = ? , A13 = ? , QID14 = ? , A14 = ? , QID15 = ? , A15 = ? , QID16 = ? , A16 = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ? AND Grouporder = ?");
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
				if (get(i).getQID07() == null || get(i).getQID07().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getQID07());
				if (get(i).getA07() == null || get(i).getA07().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getA07());
				if (get(i).getQID08() == null || get(i).getQID08().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getQID08());
				if (get(i).getA08() == null || get(i).getA08().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getA08());
				if (get(i).getQID09() == null || get(i).getQID09().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getQID09());
				if (get(i).getA09() == null || get(i).getA09().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getA09());
				if (get(i).getQID10() == null || get(i).getQID10().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getQID10());
				if (get(i).getA10() == null || get(i).getA10().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getA10());
				if (get(i).getQID11() == null || get(i).getQID11().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getQID11());
				if (get(i).getA11() == null || get(i).getA11().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getA11());
				if (get(i).getQID12() == null || get(i).getQID12().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getQID12());
				if (get(i).getA12() == null || get(i).getA12().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getA12());
				if (get(i).getQID13() == null || get(i).getQID13().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getQID13());
				if (get(i).getA13() == null || get(i).getA13().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getA13());
				if (get(i).getQID14() == null || get(i).getQID14().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getQID14());
				if (get(i).getA14() == null || get(i).getA14().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getA14());
				if (get(i).getQID15() == null || get(i).getQID15().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getQID15());
				if (get(i).getA15() == null || get(i).getA15().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getA15());
				if (get(i).getQID16() == null || get(i).getQID16().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getQID16());
				if (get(i).getA16() == null || get(i).getA16().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getA16());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(41, null);
				else
					pstmt.setDate(41, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(43, null);
				else
					pstmt.setDate(43, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getModifyTime());
				if (get(i).getResultId() == null || get(i).getResultId().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getResultId());
				if (get(i).getGrouporder() == null || get(i).getGrouporder().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getGrouporder());
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
			tError.moduleName = "LNPFAndIImpResultDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPFAndIImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getQID07() == null || get(i).getQID07().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getQID07());
				if (get(i).getA07() == null || get(i).getA07().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getA07());
				if (get(i).getQID08() == null || get(i).getQID08().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getQID08());
				if (get(i).getA08() == null || get(i).getA08().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getA08());
				if (get(i).getQID09() == null || get(i).getQID09().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getQID09());
				if (get(i).getA09() == null || get(i).getA09().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getA09());
				if (get(i).getQID10() == null || get(i).getQID10().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getQID10());
				if (get(i).getA10() == null || get(i).getA10().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getA10());
				if (get(i).getQID11() == null || get(i).getQID11().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getQID11());
				if (get(i).getA11() == null || get(i).getA11().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getA11());
				if (get(i).getQID12() == null || get(i).getQID12().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getQID12());
				if (get(i).getA12() == null || get(i).getA12().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getA12());
				if (get(i).getQID13() == null || get(i).getQID13().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getQID13());
				if (get(i).getA13() == null || get(i).getA13().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getA13());
				if (get(i).getQID14() == null || get(i).getQID14().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getQID14());
				if (get(i).getA14() == null || get(i).getA14().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getA14());
				if (get(i).getQID15() == null || get(i).getQID15().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getQID15());
				if (get(i).getA15() == null || get(i).getA15().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getA15());
				if (get(i).getQID16() == null || get(i).getQID16().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getQID16());
				if (get(i).getA16() == null || get(i).getA16().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getA16());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(41, null);
				else
					pstmt.setDate(41, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(43, null);
				else
					pstmt.setDate(43, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getModifyTime());
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
			tError.moduleName = "LNPFAndIImpResultDBSet";
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
