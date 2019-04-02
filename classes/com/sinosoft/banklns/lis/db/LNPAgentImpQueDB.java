// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentImpQueDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPAgentImpQueSchema;
import com.sinosoft.banklns.lis.vschema.LNPAgentImpQueSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPAgentImpQueDB extends LNPAgentImpQueSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPAgentImpQueDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPAgentImpQue");
		mflag = true;
	}

	public LNPAgentImpQueDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPAgentImpQue");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPAgentImpQueSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentImpQueDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPAgentImpQueSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentImpQueDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPAgentImpQue WHERE  Questionid = ? AND InnerOrder = ?");
			if (getQuestionid() == null || getQuestionid().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getQuestionid());
			if (getInnerOrder() == null || getInnerOrder().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getInnerOrder());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentImpQueDB";
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
			pstmt = con.prepareStatement("UPDATE LNPAgentImpQue SET  ImpartId = ? , Questionid = ? , QuestionType = ? , Content1 = ? , Content2 = ? , QueOrder = ? , InnerOrder = ? , OutQueId = ? , InnerQueNum = ? , ParentId = ? , ChildQueNum = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  Questionid = ? AND InnerOrder = ?");
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getImpartId());
			if (getQuestionid() == null || getQuestionid().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getQuestionid());
			if (getQuestionType() == null || getQuestionType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getQuestionType());
			if (getContent1() == null || getContent1().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getContent1());
			if (getContent2() == null || getContent2().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getContent2());
			if (getQueOrder() == null || getQueOrder().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getQueOrder());
			if (getInnerOrder() == null || getInnerOrder().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getInnerOrder());
			if (getOutQueId() == null || getOutQueId().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getOutQueId());
			if (getInnerQueNum() == null || getInnerQueNum().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getInnerQueNum());
			if (getParentId() == null || getParentId().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getParentId());
			if (getChildQueNum() == null || getChildQueNum().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getChildQueNum());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(14, 91);
			else
				pstmt.setDate(14, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getModifyTime());
			if (getQuestionid() == null || getQuestionid().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getQuestionid());
			if (getInnerOrder() == null || getInnerOrder().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getInnerOrder());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentImpQueDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPAgentImpQue VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getImpartId());
			if (getQuestionid() == null || getQuestionid().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getQuestionid());
			if (getQuestionType() == null || getQuestionType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getQuestionType());
			if (getContent1() == null || getContent1().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getContent1());
			if (getContent2() == null || getContent2().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getContent2());
			if (getQueOrder() == null || getQueOrder().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getQueOrder());
			if (getInnerOrder() == null || getInnerOrder().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getInnerOrder());
			if (getOutQueId() == null || getOutQueId().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getOutQueId());
			if (getInnerQueNum() == null || getInnerQueNum().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getInnerQueNum());
			if (getParentId() == null || getParentId().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getParentId());
			if (getChildQueNum() == null || getChildQueNum().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getChildQueNum());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(14, 91);
			else
				pstmt.setDate(14, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentImpQueDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPAgentImpQue WHERE  Questionid = ? AND InnerOrder = ?", 1003, 1007);
		if (getQuestionid() == null || getQuestionid().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getQuestionid());
		if (getInnerOrder() == null || getInnerOrder().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getInnerOrder());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_234;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_234;
		CError tError = new CError();
		tError.moduleName = "LNPAgentImpQueDB";
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
				tError.moduleName = "LNPAgentImpQueDB";
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

	public LNPAgentImpQueSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentImpQueSet aLNPAgentImpQueSet = new LNPAgentImpQueSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPAgentImpQue");
			LNPAgentImpQueSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPAgentImpQueSchema s1;
			for (; rs.next(); aLNPAgentImpQueSet.add(s1))
			{
				i++;
				s1 = new LNPAgentImpQueSchema();
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
			tError.moduleName = "LNPAgentImpQueDB";
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
		return aLNPAgentImpQueSet;
	}

	public LNPAgentImpQueSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentImpQueSet aLNPAgentImpQueSet = new LNPAgentImpQueSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPAgentImpQueSchema s1;
			for (; rs.next(); aLNPAgentImpQueSet.add(s1))
			{
				i++;
				s1 = new LNPAgentImpQueSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPAgentImpQueDB";
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
			tError.moduleName = "LNPAgentImpQueDB";
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
		return aLNPAgentImpQueSet;
	}

	public LNPAgentImpQueSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentImpQueSet aLNPAgentImpQueSet = new LNPAgentImpQueSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPAgentImpQue");
			LNPAgentImpQueSchema aSchema = getSchema();
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
				LNPAgentImpQueSchema s1 = new LNPAgentImpQueSchema();
				s1.setSchema(rs, i);
				aLNPAgentImpQueSet.add(s1);
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
			tError.moduleName = "LNPAgentImpQueDB";
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
		return aLNPAgentImpQueSet;
	}

	public LNPAgentImpQueSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentImpQueSet aLNPAgentImpQueSet = new LNPAgentImpQueSet();
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
				LNPAgentImpQueSchema s1 = new LNPAgentImpQueSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPAgentImpQueDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPAgentImpQueSet.add(s1);
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
			tError.moduleName = "LNPAgentImpQueDB";
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
		return aLNPAgentImpQueSet;
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
				SQLString sqlObj = new SQLString("LNPAgentImpQue");
				LNPAgentImpQueSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPAgentImpQue ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPAgentImpQueDB";
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
				tError.moduleName = "LNPAgentImpQueDB";
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
			tError.moduleName = "LNPAgentImpQueDB";
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
			tError.moduleName = "LNPAgentImpQueDB";
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
			tError.moduleName = "LNPAgentImpQueDB";
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
			tError.moduleName = "LNPAgentImpQueDB";
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

	public LNPAgentImpQueSet getData()
	{
		int tCount = 0;
		LNPAgentImpQueSet tLNPAgentImpQueSet = new LNPAgentImpQueSet();
		LNPAgentImpQueSchema tLNPAgentImpQueSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentImpQueDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPAgentImpQueSchema = new LNPAgentImpQueSchema();
			tLNPAgentImpQueSchema.setSchema(mResultSet, 1);
			tLNPAgentImpQueSet.add(tLNPAgentImpQueSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPAgentImpQueSchema = new LNPAgentImpQueSchema();
					tLNPAgentImpQueSchema.setSchema(mResultSet, 1);
					tLNPAgentImpQueSet.add(tLNPAgentImpQueSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentImpQueDB";
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
		return tLNPAgentImpQueSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPAgentImpQueDB";
				tError.functionName = "closeData";
				tError.errorMessage = "数据集已经关闭了�?";
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
			tError.moduleName = "LNPAgentImpQueDB";
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
				tError.moduleName = "LNPAgentImpQueDB";
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
			tError.moduleName = "LNPAgentImpQueDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
