// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CaseFileDownlLogDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.CaseFileDownlLogSchema;
import com.sinosoft.map.lis.vschema.CaseFileDownlLogSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class CaseFileDownlLogDB extends CaseFileDownlLogSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public CaseFileDownlLogDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "CaseFileDownlLog");
		mflag = true;
	}

	public CaseFileDownlLogDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("CaseFileDownlLog");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		CaseFileDownlLogSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "CaseFileDownlLogDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		CaseFileDownlLogSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "CaseFileDownlLogDB";
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
			pstmt = con.prepareStatement("DELETE FROM CaseFileDownlLog WHERE  Id = ?");
			if (getId() == null || getId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "CaseFileDownlLogDB";
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
			pstmt = con.prepareStatement("UPDATE CaseFileDownlLog SET  Id = ? , FileDate = ? , FDownDate = ? , FDownTime = ? , Flag = ? , ModifyDate = ? , ModityTime = ? , LastOperator = ? , BY1 = ? , BY2 = ? , BY3 = ? , BY4 = ? WHERE  Id = ?");
			if (getId() == null || getId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getId());
			if (getFileDate() == null || getFileDate().equals("null"))
				pstmt.setNull(2, 91);
			else
				pstmt.setDate(2, Date.valueOf(getFileDate()));
			if (getFDownDate() == null || getFDownDate().equals("null"))
				pstmt.setNull(3, 91);
			else
				pstmt.setDate(3, Date.valueOf(getFDownDate()));
			if (getFDownTime() == null || getFDownTime().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getFDownTime());
			if (getFlag() == null || getFlag().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getFlag());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getModifyDate()));
			if (getModityTime() == null || getModityTime().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getModityTime());
			if (getLastOperator() == null || getLastOperator().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getLastOperator());
			if (getBY1() == null || getBY1().equals("null"))
				pstmt.setNull(9, 91);
			else
				pstmt.setDate(9, Date.valueOf(getBY1()));
			if (getBY2() == null || getBY2().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getBY2()));
			if (getBY3() == null || getBY3().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getBY3());
			if (getBY4() == null || getBY4().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getBY4());
			if (getId() == null || getId().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "CaseFileDownlLogDB";
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
			pstmt = con.prepareStatement("INSERT INTO CaseFileDownlLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getId() == null || getId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getId());
			if (getFileDate() == null || getFileDate().equals("null"))
				pstmt.setNull(2, 91);
			else
				pstmt.setDate(2, Date.valueOf(getFileDate()));
			if (getFDownDate() == null || getFDownDate().equals("null"))
				pstmt.setNull(3, 91);
			else
				pstmt.setDate(3, Date.valueOf(getFDownDate()));
			if (getFDownTime() == null || getFDownTime().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getFDownTime());
			if (getFlag() == null || getFlag().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getFlag());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getModifyDate()));
			if (getModityTime() == null || getModityTime().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getModityTime());
			if (getLastOperator() == null || getLastOperator().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getLastOperator());
			if (getBY1() == null || getBY1().equals("null"))
				pstmt.setNull(9, 91);
			else
				pstmt.setDate(9, Date.valueOf(getBY1()));
			if (getBY2() == null || getBY2().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getBY2()));
			if (getBY3() == null || getBY3().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getBY3());
			if (getBY4() == null || getBY4().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getBY4());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "CaseFileDownlLogDB";
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
		pstmt = con.prepareStatement("SELECT * FROM CaseFileDownlLog WHERE  Id = ?", 1003, 1007);
		if (getId() == null || getId().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getId());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "CaseFileDownlLogDB";
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
				tError.moduleName = "CaseFileDownlLogDB";
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

	public CaseFileDownlLogSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		CaseFileDownlLogSet aCaseFileDownlLogSet = new CaseFileDownlLogSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("CaseFileDownlLog");
			CaseFileDownlLogSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			CaseFileDownlLogSchema s1;
			for (; rs.next(); aCaseFileDownlLogSet.add(s1))
			{
				i++;
				s1 = new CaseFileDownlLogSchema();
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
			tError.moduleName = "CaseFileDownlLogDB";
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
		return aCaseFileDownlLogSet;
	}

	public CaseFileDownlLogSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		CaseFileDownlLogSet aCaseFileDownlLogSet = new CaseFileDownlLogSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			CaseFileDownlLogSchema s1;
			for (; rs.next(); aCaseFileDownlLogSet.add(s1))
			{
				i++;
				s1 = new CaseFileDownlLogSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "CaseFileDownlLogDB";
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
			tError.moduleName = "CaseFileDownlLogDB";
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
		return aCaseFileDownlLogSet;
	}

	public CaseFileDownlLogSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		CaseFileDownlLogSet aCaseFileDownlLogSet = new CaseFileDownlLogSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("CaseFileDownlLog");
			CaseFileDownlLogSchema aSchema = getSchema();
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
				CaseFileDownlLogSchema s1 = new CaseFileDownlLogSchema();
				s1.setSchema(rs, i);
				aCaseFileDownlLogSet.add(s1);
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
			tError.moduleName = "CaseFileDownlLogDB";
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
		return aCaseFileDownlLogSet;
	}

	public CaseFileDownlLogSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		CaseFileDownlLogSet aCaseFileDownlLogSet = new CaseFileDownlLogSet();
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
				CaseFileDownlLogSchema s1 = new CaseFileDownlLogSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "CaseFileDownlLogDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aCaseFileDownlLogSet.add(s1);
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
			tError.moduleName = "CaseFileDownlLogDB";
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
		return aCaseFileDownlLogSet;
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
				SQLString sqlObj = new SQLString("CaseFileDownlLog");
				CaseFileDownlLogSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update CaseFileDownlLog ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "CaseFileDownlLogDB";
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
				tError.moduleName = "CaseFileDownlLogDB";
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
			tError.moduleName = "CaseFileDownlLogDB";
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
			tError.moduleName = "CaseFileDownlLogDB";
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
			tError.moduleName = "CaseFileDownlLogDB";
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
			tError.moduleName = "CaseFileDownlLogDB";
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

	public CaseFileDownlLogSet getData()
	{
		int tCount = 0;
		CaseFileDownlLogSet tCaseFileDownlLogSet = new CaseFileDownlLogSet();
		CaseFileDownlLogSchema tCaseFileDownlLogSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "CaseFileDownlLogDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
			tCaseFileDownlLogSchema.setSchema(mResultSet, 1);
			tCaseFileDownlLogSet.add(tCaseFileDownlLogSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
					tCaseFileDownlLogSchema.setSchema(mResultSet, 1);
					tCaseFileDownlLogSet.add(tCaseFileDownlLogSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "CaseFileDownlLogDB";
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
		return tCaseFileDownlLogSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "CaseFileDownlLogDB";
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
			tError.moduleName = "CaseFileDownlLogDB";
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
				tError.moduleName = "CaseFileDownlLogDB";
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
			tError.moduleName = "CaseFileDownlLogDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
