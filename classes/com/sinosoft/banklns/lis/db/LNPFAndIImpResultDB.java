// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPFAndIImpResultDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPFAndIImpResultSchema;
import com.sinosoft.banklns.lis.vschema.LNPFAndIImpResultSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPFAndIImpResultDB extends LNPFAndIImpResultSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPFAndIImpResultDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPFAndIImpResult");
		mflag = true;
	}

	public LNPFAndIImpResultDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPFAndIImpResult");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPFAndIImpResultSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPFAndIImpResultSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "getCount";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return -1;
		} else
		{
			return tCount;
		}
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("DELETE FROM LNPFAndIImpResult WHERE  ResultId = ? AND Grouporder = ?");
			if (getResultId() == null || getResultId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getResultId());
			if (getGrouporder() == null || getGrouporder().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getGrouporder());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("UPDATE LNPFAndIImpResult SET  ResultId = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , ImpartId = ? , Grouporder = ? , QID01 = ? , A01 = ? , QID02 = ? , A02 = ? , QID03 = ? , A03 = ? , QID04 = ? , A04 = ? , QID05 = ? , A05 = ? , QID06 = ? , A06 = ? , QID07 = ? , A07 = ? , QID08 = ? , A08 = ? , QID09 = ? , A09 = ? , QID10 = ? , A10 = ? , QID11 = ? , A11 = ? , QID12 = ? , A12 = ? , QID13 = ? , A13 = ? , QID14 = ? , A14 = ? , QID15 = ? , A15 = ? , QID16 = ? , A16 = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ? AND Grouporder = ?");
			if (getResultId() == null || getResultId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getResultId());
			if (getGrpContNo() == null || getGrpContNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getGrpContNo());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getContNo());
			if (getProposalContNo() == null || getProposalContNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getProposalContNo());
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getImpartId());
			if (getGrouporder() == null || getGrouporder().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getGrouporder());
			if (getQID01() == null || getQID01().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getQID01());
			if (getA01() == null || getA01().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getA01());
			if (getQID02() == null || getQID02().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getQID02());
			if (getA02() == null || getA02().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getA02());
			if (getQID03() == null || getQID03().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getQID03());
			if (getA03() == null || getA03().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getA03());
			if (getQID04() == null || getQID04().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getQID04());
			if (getA04() == null || getA04().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getA04());
			if (getQID05() == null || getQID05().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getQID05());
			if (getA05() == null || getA05().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getA05());
			if (getQID06() == null || getQID06().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getQID06());
			if (getA06() == null || getA06().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getA06());
			if (getQID07() == null || getQID07().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getQID07());
			if (getA07() == null || getA07().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getA07());
			if (getQID08() == null || getQID08().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getQID08());
			if (getA08() == null || getA08().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getA08());
			if (getQID09() == null || getQID09().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getQID09());
			if (getA09() == null || getA09().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getA09());
			if (getQID10() == null || getQID10().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getQID10());
			if (getA10() == null || getA10().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getA10());
			if (getQID11() == null || getQID11().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getQID11());
			if (getA11() == null || getA11().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getA11());
			if (getQID12() == null || getQID12().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getQID12());
			if (getA12() == null || getA12().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getA12());
			if (getQID13() == null || getQID13().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getQID13());
			if (getA13() == null || getA13().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getA13());
			if (getQID14() == null || getQID14().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getQID14());
			if (getA14() == null || getA14().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getA14());
			if (getQID15() == null || getQID15().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getQID15());
			if (getA15() == null || getA15().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getA15());
			if (getQID16() == null || getQID16().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getQID16());
			if (getA16() == null || getA16().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getA16());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(41, 91);
			else
				pstmt.setDate(41, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(43, 91);
			else
				pstmt.setDate(43, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getModifyTime());
			if (getResultId() == null || getResultId().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getResultId());
			if (getGrouporder() == null || getGrouporder().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getGrouporder());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("INSERT INTO LNPFAndIImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getResultId() == null || getResultId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getResultId());
			if (getGrpContNo() == null || getGrpContNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getGrpContNo());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getContNo());
			if (getProposalContNo() == null || getProposalContNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getProposalContNo());
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getImpartId());
			if (getGrouporder() == null || getGrouporder().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getGrouporder());
			if (getQID01() == null || getQID01().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getQID01());
			if (getA01() == null || getA01().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getA01());
			if (getQID02() == null || getQID02().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getQID02());
			if (getA02() == null || getA02().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getA02());
			if (getQID03() == null || getQID03().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getQID03());
			if (getA03() == null || getA03().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getA03());
			if (getQID04() == null || getQID04().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getQID04());
			if (getA04() == null || getA04().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getA04());
			if (getQID05() == null || getQID05().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getQID05());
			if (getA05() == null || getA05().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getA05());
			if (getQID06() == null || getQID06().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getQID06());
			if (getA06() == null || getA06().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getA06());
			if (getQID07() == null || getQID07().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getQID07());
			if (getA07() == null || getA07().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getA07());
			if (getQID08() == null || getQID08().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getQID08());
			if (getA08() == null || getA08().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getA08());
			if (getQID09() == null || getQID09().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getQID09());
			if (getA09() == null || getA09().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getA09());
			if (getQID10() == null || getQID10().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getQID10());
			if (getA10() == null || getA10().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getA10());
			if (getQID11() == null || getQID11().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getQID11());
			if (getA11() == null || getA11().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getA11());
			if (getQID12() == null || getQID12().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getQID12());
			if (getA12() == null || getA12().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getA12());
			if (getQID13() == null || getQID13().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getQID13());
			if (getA13() == null || getA13().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getA13());
			if (getQID14() == null || getQID14().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getQID14());
			if (getA14() == null || getA14().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getA14());
			if (getQID15() == null || getQID15().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getQID15());
			if (getA15() == null || getA15().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getA15());
			if (getQID16() == null || getQID16().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getQID16());
			if (getA16() == null || getA16().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getA16());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(41, 91);
			else
				pstmt.setDate(41, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(43, 91);
			else
				pstmt.setDate(43, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean getInfo()
	{
		PreparedStatement pstmt;
		ResultSet rs;
		pstmt = null;
		rs = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		int i;
		pstmt = con.prepareStatement("SELECT * FROM LNPFAndIImpResult WHERE  ResultId = ? AND Grouporder = ?", 1003, 1007);
		if (getResultId() == null || getResultId().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getResultId());
		if (getGrouporder() == null || getGrouporder().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getGrouporder());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_237;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_237;
		CError tError = new CError();
		tError.moduleName = "LNPFAndIImpResultDB";
		tError.functionName = "getInfo";
		tError.errorMessage = "取数失败!";
		mErrors.addOneError(tError);
		try
		{
			rs.close();
		}
		catch (Exception exception4) { }
		try
		{
			pstmt.close();
		}
		catch (Exception exception5) { }
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception6) { }
		return false;
label0:
		{
			try
			{
				try
				{
					rs.close();
				}
				catch (Exception exception1) { }
				try
				{
					pstmt.close();
				}
				catch (Exception exception2) { }
				if (i != 0)
					break label0;
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception3) { }
			}
			catch (Exception e)
			{
				CError tError = new CError();
				tError.moduleName = "LNPFAndIImpResultDB";
				tError.functionName = "getInfo";
				tError.errorMessage = e.toString();
				mErrors.addOneError(tError);
				try
				{
					rs.close();
				}
				catch (Exception exception7) { }
				try
				{
					pstmt.close();
				}
				catch (Exception exception8) { }
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception9) { }
				return false;
			}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public LNPFAndIImpResultSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPFAndIImpResultSet aLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPFAndIImpResult");
			LNPFAndIImpResultSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPFAndIImpResultSchema s1;
			for (; rs.next(); aLNPFAndIImpResultSet.add(s1))
			{
				i++;
				s1 = new LNPFAndIImpResultSchema();
				s1.setSchema(rs, i);
			}

			try
			{
				rs.close();
			}
			catch (Exception exception4) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception5) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception3) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aLNPFAndIImpResultSet;
	}

	public LNPFAndIImpResultSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPFAndIImpResultSet aLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPFAndIImpResultSchema s1;
			for (; rs.next(); aLNPFAndIImpResultSet.add(s1))
			{
				i++;
				s1 = new LNPFAndIImpResultSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPFAndIImpResultDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
			}

			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception3) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception4) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception5) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aLNPFAndIImpResultSet;
	}

	public LNPFAndIImpResultSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPFAndIImpResultSet aLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPFAndIImpResult");
			LNPFAndIImpResultSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) 
			{
				if (++i < nStart)
					continue;
				if (i >= nStart + nCount)
					break;
				LNPFAndIImpResultSchema s1 = new LNPFAndIImpResultSchema();
				s1.setSchema(rs, i);
				aLNPFAndIImpResultSet.add(s1);
			}
			try
			{
				rs.close();
			}
			catch (Exception exception4) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception5) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception3) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aLNPFAndIImpResultSet;
	}

	public LNPFAndIImpResultSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPFAndIImpResultSet aLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			while (rs.next()) 
			{
				if (++i < nStart)
					continue;
				if (i >= nStart + nCount)
					break;
				LNPFAndIImpResultSchema s1 = new LNPFAndIImpResultSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPFAndIImpResultDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPFAndIImpResultSet.add(s1);
			}
			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception3) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception4) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception5) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aLNPFAndIImpResultSet;
	}

	public boolean update(String strWherePart)
	{
label0:
		{
			Statement stmt = null;
			if (!mflag)
				con = DBConnPool.getConnection();
			try
			{
				stmt = con.createStatement(1003, 1007);
				SQLString sqlObj = new SQLString("LNPFAndIImpResult");
				LNPFAndIImpResultSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPFAndIImpResult ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPFAndIImpResultDB";
				tError.functionName = "update";
				tError.errorMessage = "更新数据失败!";
				mErrors.addOneError(tError);
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception3) { }
			}
			catch (Exception e)
			{
				CError tError = new CError();
				tError.moduleName = "LNPFAndIImpResultDB";
				tError.functionName = "update";
				tError.errorMessage = e.toString();
				mErrors.addOneError(tError);
				try
				{
					stmt.close();
				}
				catch (Exception exception1) { }
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception2) { }
				return false;
			}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean prepareData(String strSQL)
	{
		if (mResultSet != null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "prepareData";
			tError.errorMessage = "数据集非空，程序在准备数据集之后，没有关闭！";
			mErrors.addOneError(tError);
			return false;
		}
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			mStatement = con.createStatement(1003, 1007);
			mResultSet = mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "prepareData";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				mResultSet.close();
			}
			catch (Exception exception1) { }
			try
			{
				mStatement.close();
			}
			catch (Exception exception2) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception3) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean hasMoreData()
	{
		boolean flag = true;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return false;
		}
		try
		{
			flag = mResultSet.next();
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				mResultSet.close();
				mResultSet = null;
			}
			catch (Exception exception) { }
			try
			{
				mStatement.close();
				mStatement = null;
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		return flag;
	}

	public LNPFAndIImpResultSet getData()
	{
		int tCount = 0;
		LNPFAndIImpResultSet tLNPFAndIImpResultSet = new LNPFAndIImpResultSet();
		LNPFAndIImpResultSchema tLNPFAndIImpResultSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPFAndIImpResultSchema = new LNPFAndIImpResultSchema();
			tLNPFAndIImpResultSchema.setSchema(mResultSet, 1);
			tLNPFAndIImpResultSet.add(tLNPFAndIImpResultSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPFAndIImpResultSchema = new LNPFAndIImpResultSchema();
					tLNPFAndIImpResultSchema.setSchema(mResultSet, 1);
					tLNPFAndIImpResultSet.add(tLNPFAndIImpResultSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "getData";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				mResultSet.close();
				mResultSet = null;
			}
			catch (Exception exception) { }
			try
			{
				mStatement.close();
				mStatement = null;
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return null;
		}
		return tLNPFAndIImpResultSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPFAndIImpResultDB";
				tError.functionName = "closeData";
				tError.errorMessage = "数据集已经关闭了！";
				mErrors.addOneError(tError);
				flag = false;
			} else
			{
				mResultSet.close();
				mResultSet = null;
			}
		}
		catch (Exception ex2)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex2.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		try
		{
			if (mStatement == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPFAndIImpResultDB";
				tError.functionName = "closeData";
				tError.errorMessage = "语句已经关闭了！";
				mErrors.addOneError(tError);
				flag = false;
			} else
			{
				mStatement.close();
				mStatement = null;
			}
		}
		catch (Exception ex3)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpResultDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
