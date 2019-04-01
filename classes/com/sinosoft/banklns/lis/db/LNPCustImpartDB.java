// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCustImpartDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPCustImpartSchema;
import com.sinosoft.banklns.lis.vschema.LNPCustImpartSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPCustImpartDB extends LNPCustImpartSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPCustImpartDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPCustImpart");
		mflag = true;
	}

	public LNPCustImpartDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPCustImpart");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPCustImpartSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCustImpartDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPCustImpartSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCustImpartDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCustImpart WHERE  ImpartId = ?");
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getImpartId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCustImpartDB";
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
			pstmt = con.prepareStatement("UPDATE LNPCustImpart SET  ImpartId = ? , ProposalType = ? , ImpartName = ? , ImpartVer = ? , ImpartContent = ? , QuestionSum = ? , Operator = ? , ManageCom = ? , MakeTime = ? , MakeDate = ? , ModifyDate = ? , ModifyTime = ? , p1 = ? , p2 = ? , p3 = ? , p4 = ? WHERE  ImpartId = ?");
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getImpartId());
			if (getProposalType() == null || getProposalType().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getProposalType());
			if (getImpartName() == null || getImpartName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getImpartName());
			if (getImpartVer() == null || getImpartVer().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getImpartVer());
			if (getImpartContent() == null || getImpartContent().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getImpartContent());
			pstmt.setInt(6, getQuestionSum());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getManageCom());
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getMakeTime());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getMakeDate()));
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(11, 91);
			else
				pstmt.setDate(11, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getModifyTime());
			if (getP1() == null || getP1().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getP1());
			if (getP2() == null || getP2().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getP2());
			if (getP3() == null || getP3().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getP3());
			if (getP4() == null || getP4().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getP4());
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getImpartId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCustImpartDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCustImpart VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getImpartId());
			if (getProposalType() == null || getProposalType().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getProposalType());
			if (getImpartName() == null || getImpartName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getImpartName());
			if (getImpartVer() == null || getImpartVer().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getImpartVer());
			if (getImpartContent() == null || getImpartContent().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getImpartContent());
			pstmt.setInt(6, getQuestionSum());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getManageCom());
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getMakeTime());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getMakeDate()));
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(11, 91);
			else
				pstmt.setDate(11, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getModifyTime());
			if (getP1() == null || getP1().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getP1());
			if (getP2() == null || getP2().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getP2());
			if (getP3() == null || getP3().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getP3());
			if (getP4() == null || getP4().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getP4());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCustImpartDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPCustImpart WHERE  ImpartId = ?", 1003, 1007);
		if (getImpartId() == null || getImpartId().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getImpartId());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "LNPCustImpartDB";
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
				tError.moduleName = "LNPCustImpartDB";
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

	public LNPCustImpartSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCustImpartSet aLNPCustImpartSet = new LNPCustImpartSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPCustImpart");
			LNPCustImpartSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPCustImpartSchema s1;
			for (; rs.next(); aLNPCustImpartSet.add(s1))
			{
				i++;
				s1 = new LNPCustImpartSchema();
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
			tError.moduleName = "LNPCustImpartDB";
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
		return aLNPCustImpartSet;
	}

	public LNPCustImpartSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCustImpartSet aLNPCustImpartSet = new LNPCustImpartSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPCustImpartSchema s1;
			for (; rs.next(); aLNPCustImpartSet.add(s1))
			{
				i++;
				s1 = new LNPCustImpartSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPCustImpartDB";
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
			tError.moduleName = "LNPCustImpartDB";
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
		return aLNPCustImpartSet;
	}

	public LNPCustImpartSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCustImpartSet aLNPCustImpartSet = new LNPCustImpartSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPCustImpart");
			LNPCustImpartSchema aSchema = getSchema();
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
				LNPCustImpartSchema s1 = new LNPCustImpartSchema();
				s1.setSchema(rs, i);
				aLNPCustImpartSet.add(s1);
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
			tError.moduleName = "LNPCustImpartDB";
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
		return aLNPCustImpartSet;
	}

	public LNPCustImpartSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCustImpartSet aLNPCustImpartSet = new LNPCustImpartSet();
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
				LNPCustImpartSchema s1 = new LNPCustImpartSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPCustImpartDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPCustImpartSet.add(s1);
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
			tError.moduleName = "LNPCustImpartDB";
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
		return aLNPCustImpartSet;
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
				SQLString sqlObj = new SQLString("LNPCustImpart");
				LNPCustImpartSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPCustImpart ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPCustImpartDB";
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
				tError.moduleName = "LNPCustImpartDB";
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
			tError.moduleName = "LNPCustImpartDB";
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
			tError.moduleName = "LNPCustImpartDB";
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
			tError.moduleName = "LNPCustImpartDB";
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
			tError.moduleName = "LNPCustImpartDB";
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

	public LNPCustImpartSet getData()
	{
		int tCount = 0;
		LNPCustImpartSet tLNPCustImpartSet = new LNPCustImpartSet();
		LNPCustImpartSchema tLNPCustImpartSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCustImpartDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPCustImpartSchema = new LNPCustImpartSchema();
			tLNPCustImpartSchema.setSchema(mResultSet, 1);
			tLNPCustImpartSet.add(tLNPCustImpartSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPCustImpartSchema = new LNPCustImpartSchema();
					tLNPCustImpartSchema.setSchema(mResultSet, 1);
					tLNPCustImpartSet.add(tLNPCustImpartSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCustImpartDB";
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
		return tLNPCustImpartSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPCustImpartDB";
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
			tError.moduleName = "LNPCustImpartDB";
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
				tError.moduleName = "LNPCustImpartDB";
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
			tError.moduleName = "LNPCustImpartDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
