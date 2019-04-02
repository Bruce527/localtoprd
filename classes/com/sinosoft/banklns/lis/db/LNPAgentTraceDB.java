// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentTraceDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPAgentTraceSchema;
import com.sinosoft.banklns.lis.vschema.LNPAgentTraceSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPAgentTraceDB extends LNPAgentTraceSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPAgentTraceDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPAgentTrace");
		mflag = true;
	}

	public LNPAgentTraceDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPAgentTrace");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPAgentTraceSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentTraceDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPAgentTraceSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentTraceDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPAgentTrace WHERE  ID = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentTraceDB";
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
			pstmt = con.prepareStatement("UPDATE LNPAgentTrace SET  ID = ? , Contno = ? , Operator = ? , OperatorDate = ? , OperatorTime = ? , OperatorType = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc5 = ? , Varc3 = ? , Varc4 = ? , Varc6 = ? , Date1 = ? , Date2 = ? WHERE  ID = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getContno() == null || getContno().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getContno());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getOperator());
			if (getOperatorDate() == null || getOperatorDate().equals("null"))
				pstmt.setNull(4, 91);
			else
				pstmt.setDate(4, Date.valueOf(getOperatorDate()));
			if (getOperatorTime() == null || getOperatorTime().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getOperatorTime());
			if (getOperatorType() == null || getOperatorType().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getOperatorType());
			pstmt.setInt(7, getInt1());
			pstmt.setInt(8, getInt2());
			if (getVarc1() == null || getVarc1().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getVarc1());
			if (getVarc2() == null || getVarc2().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getVarc2());
			if (getVarc5() == null || getVarc5().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getVarc5());
			if (getVarc3() == null || getVarc3().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getVarc3());
			if (getVarc4() == null || getVarc4().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getVarc4());
			if (getVarc6() == null || getVarc6().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getVarc6());
			if (getDate1() == null || getDate1().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getDate1()));
			if (getDate2() == null || getDate2().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getDate2()));
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentTraceDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPAgentTrace VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getContno() == null || getContno().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getContno());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getOperator());
			if (getOperatorDate() == null || getOperatorDate().equals("null"))
				pstmt.setNull(4, 91);
			else
				pstmt.setDate(4, Date.valueOf(getOperatorDate()));
			if (getOperatorTime() == null || getOperatorTime().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getOperatorTime());
			if (getOperatorType() == null || getOperatorType().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getOperatorType());
			pstmt.setInt(7, getInt1());
			pstmt.setInt(8, getInt2());
			if (getVarc1() == null || getVarc1().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getVarc1());
			if (getVarc2() == null || getVarc2().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getVarc2());
			if (getVarc5() == null || getVarc5().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getVarc5());
			if (getVarc3() == null || getVarc3().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getVarc3());
			if (getVarc4() == null || getVarc4().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getVarc4());
			if (getVarc6() == null || getVarc6().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getVarc6());
			if (getDate1() == null || getDate1().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getDate1()));
			if (getDate2() == null || getDate2().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getDate2()));
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAgentTraceDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPAgentTrace WHERE  ID = ?", 1003, 1007);
		if (getID() == null || getID().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getID());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "LNPAgentTraceDB";
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
				tError.moduleName = "LNPAgentTraceDB";
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

	public LNPAgentTraceSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentTraceSet aLNPAgentTraceSet = new LNPAgentTraceSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPAgentTrace");
			LNPAgentTraceSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPAgentTraceSchema s1;
			for (; rs.next(); aLNPAgentTraceSet.add(s1))
			{
				i++;
				s1 = new LNPAgentTraceSchema();
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
			tError.moduleName = "LNPAgentTraceDB";
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
		return aLNPAgentTraceSet;
	}

	public LNPAgentTraceSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentTraceSet aLNPAgentTraceSet = new LNPAgentTraceSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPAgentTraceSchema s1;
			for (; rs.next(); aLNPAgentTraceSet.add(s1))
			{
				i++;
				s1 = new LNPAgentTraceSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPAgentTraceDB";
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
			tError.moduleName = "LNPAgentTraceDB";
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
		return aLNPAgentTraceSet;
	}

	public LNPAgentTraceSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentTraceSet aLNPAgentTraceSet = new LNPAgentTraceSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPAgentTrace");
			LNPAgentTraceSchema aSchema = getSchema();
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
				LNPAgentTraceSchema s1 = new LNPAgentTraceSchema();
				s1.setSchema(rs, i);
				aLNPAgentTraceSet.add(s1);
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
			tError.moduleName = "LNPAgentTraceDB";
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
		return aLNPAgentTraceSet;
	}

	public LNPAgentTraceSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAgentTraceSet aLNPAgentTraceSet = new LNPAgentTraceSet();
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
				LNPAgentTraceSchema s1 = new LNPAgentTraceSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPAgentTraceDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPAgentTraceSet.add(s1);
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
			tError.moduleName = "LNPAgentTraceDB";
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
		return aLNPAgentTraceSet;
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
				SQLString sqlObj = new SQLString("LNPAgentTrace");
				LNPAgentTraceSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPAgentTrace ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPAgentTraceDB";
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
				tError.moduleName = "LNPAgentTraceDB";
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
			tError.moduleName = "LNPAgentTraceDB";
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
			tError.moduleName = "LNPAgentTraceDB";
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
			tError.moduleName = "LNPAgentTraceDB";
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
			tError.moduleName = "LNPAgentTraceDB";
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

	public LNPAgentTraceSet getData()
	{
		int tCount = 0;
		LNPAgentTraceSet tLNPAgentTraceSet = new LNPAgentTraceSet();
		LNPAgentTraceSchema tLNPAgentTraceSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentTraceDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPAgentTraceSchema = new LNPAgentTraceSchema();
			tLNPAgentTraceSchema.setSchema(mResultSet, 1);
			tLNPAgentTraceSet.add(tLNPAgentTraceSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPAgentTraceSchema = new LNPAgentTraceSchema();
					tLNPAgentTraceSchema.setSchema(mResultSet, 1);
					tLNPAgentTraceSet.add(tLNPAgentTraceSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentTraceDB";
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
		return tLNPAgentTraceSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPAgentTraceDB";
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
			tError.moduleName = "LNPAgentTraceDB";
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
				tError.moduleName = "LNPAgentTraceDB";
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
			tError.moduleName = "LNPAgentTraceDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
