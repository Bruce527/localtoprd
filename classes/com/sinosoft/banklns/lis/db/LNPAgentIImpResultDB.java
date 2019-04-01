// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentIImpResultDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPAgentIImpResultSchema;
import com.sinosoft.banklns.lis.vschema.LNPAgentIImpResultSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPAgentIImpResultDB extends LNPAgentIImpResultSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPAgentIImpResultDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPAgentIImpResult");
		mflag = true;
	}

	public LNPAgentIImpResultDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPAgentIImpResult");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPAgentIImpResultSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentIImpResultDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPAgentIImpResultSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentIImpResultDB";
			tError.functionName = "getCount";
			tError.errorMessage = "����ʧ��!";
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
			pstmt = con.prepareStatement("DELETE FROM LNPAgentIImpResult WHERE  ResultId = ? AND Grouporder = ?");
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
			tError.moduleName = "LNPAgentIImpResultDB";
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
			pstmt = con.prepareStatement("UPDATE LNPAgentIImpResult SET  ResultId = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , ImpartId = ? , Grouporder = ? , QID01 = ? , A01 = ? , QID02 = ? , A02 = ? , QID03 = ? , A03 = ? , QID04 = ? , A04 = ? , QID05 = ? , A05 = ? , QID06 = ? , A06 = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ? AND Grouporder = ?");
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
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(21, 91);
			else
				pstmt.setDate(21, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(23, 91);
			else
				pstmt.setDate(23, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getModifyTime());
			if (getResultId() == null || getResultId().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getResultId());
			if (getGrouporder() == null || getGrouporder().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getGrouporder());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentIImpResultDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPAgentIImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(21, 91);
			else
				pstmt.setDate(21, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(23, 91);
			else
				pstmt.setDate(23, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentIImpResultDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPAgentIImpResult WHERE  ResultId = ? AND Grouporder = ?", 1003, 1007);
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
			break MISSING_BLOCK_LABEL_236;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_236;
		CError tError = new CError();
		tError.moduleName = "LNPAgentIImpResultDB";
		tError.functionName = "getInfo";
		tError.errorMessage = "ȡ��ʧ��!";
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
				tError.moduleName = "LNPAgentIImpResultDB";
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

	public LNPAgentIImpResultSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentIImpResultSet aLNPAgentIImpResultSet = new LNPAgentIImpResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPAgentIImpResult");
			LNPAgentIImpResultSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPAgentIImpResultSchema s1;
			for (; rs.next(); aLNPAgentIImpResultSet.add(s1))
			{
				i++;
				s1 = new LNPAgentIImpResultSchema();
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
			tError.moduleName = "LNPAgentIImpResultDB";
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
		return aLNPAgentIImpResultSet;
	}

	public LNPAgentIImpResultSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentIImpResultSet aLNPAgentIImpResultSet = new LNPAgentIImpResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPAgentIImpResultSchema s1;
			for (; rs.next(); aLNPAgentIImpResultSet.add(s1))
			{
				i++;
				s1 = new LNPAgentIImpResultSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPAgentIImpResultDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�������ֶ�����Ϣ!";
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
			tError.moduleName = "LNPAgentIImpResultDB";
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
		return aLNPAgentIImpResultSet;
	}

	public LNPAgentIImpResultSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentIImpResultSet aLNPAgentIImpResultSet = new LNPAgentIImpResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPAgentIImpResult");
			LNPAgentIImpResultSchema aSchema = getSchema();
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
				LNPAgentIImpResultSchema s1 = new LNPAgentIImpResultSchema();
				s1.setSchema(rs, i);
				aLNPAgentIImpResultSet.add(s1);
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
			tError.moduleName = "LNPAgentIImpResultDB";
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
		return aLNPAgentIImpResultSet;
	}

	public LNPAgentIImpResultSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentIImpResultSet aLNPAgentIImpResultSet = new LNPAgentIImpResultSet();
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
				LNPAgentIImpResultSchema s1 = new LNPAgentIImpResultSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPAgentIImpResultDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�������ֶ�����Ϣ!";
					mErrors.addOneError(tError);
				}
				aLNPAgentIImpResultSet.add(s1);
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
			tError.moduleName = "LNPAgentIImpResultDB";
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
		return aLNPAgentIImpResultSet;
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
				SQLString sqlObj = new SQLString("LNPAgentIImpResult");
				LNPAgentIImpResultSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPAgentIImpResult ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPAgentIImpResultDB";
				tError.functionName = "update";
				tError.errorMessage = "��������ʧ��!";
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
				tError.moduleName = "LNPAgentIImpResultDB";
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
			tError.moduleName = "LNPAgentIImpResultDB";
			tError.functionName = "prepareData";
			tError.errorMessage = "���ݼ��ǿգ�������׼�����ݼ�֮��û�йرգ�";
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
			tError.moduleName = "LNPAgentIImpResultDB";
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
			tError.moduleName = "LNPAgentIImpResultDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = "���ݼ�Ϊ�գ�����׼�����ݼ���";
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
			tError.moduleName = "LNPAgentIImpResultDB";
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

	public LNPAgentIImpResultSet getData()
	{
		int tCount = 0;
		LNPAgentIImpResultSet tLNPAgentIImpResultSet = new LNPAgentIImpResultSet();
		LNPAgentIImpResultSchema tLNPAgentIImpResultSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentIImpResultDB";
			tError.functionName = "getData";
			tError.errorMessage = "���ݼ�Ϊ�գ�����׼�����ݼ���";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPAgentIImpResultSchema = new LNPAgentIImpResultSchema();
			tLNPAgentIImpResultSchema.setSchema(mResultSet, 1);
			tLNPAgentIImpResultSet.add(tLNPAgentIImpResultSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPAgentIImpResultSchema = new LNPAgentIImpResultSchema();
					tLNPAgentIImpResultSchema.setSchema(mResultSet, 1);
					tLNPAgentIImpResultSet.add(tLNPAgentIImpResultSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentIImpResultDB";
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
		return tLNPAgentIImpResultSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPAgentIImpResultDB";
				tError.functionName = "closeData";
				tError.errorMessage = "���ݼ��Ѿ��ر��ˣ�";
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
			tError.moduleName = "LNPAgentIImpResultDB";
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
				tError.moduleName = "LNPAgentIImpResultDB";
				tError.functionName = "closeData";
				tError.errorMessage = "����Ѿ��ر��ˣ�";
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
			tError.moduleName = "LNPAgentIImpResultDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}