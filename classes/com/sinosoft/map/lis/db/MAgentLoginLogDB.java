// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MAgentLoginLogDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MAgentLoginLogSchema;
import com.sinosoft.map.lis.vschema.MAgentLoginLogSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MAgentLoginLogDB extends MAgentLoginLogSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MAgentLoginLogDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MAgentLoginLog");
		mflag = true;
	}

	public MAgentLoginLogDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MAgentLoginLog");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MAgentLoginLogSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MAgentLoginLogDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MAgentLoginLogSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MAgentLoginLogDB";
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
			pstmt = con.prepareStatement("DELETE FROM MAgentLoginLog WHERE  ID = ?");
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
			tError.moduleName = "MAgentLoginLogDB";
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
			pstmt = con.prepareStatement("UPDATE MAgentLoginLog SET  ID = ? , AgentCode = ? , UserType = ? , ClientName = ? , ClientType = ? , ClientIP = ? , LoginDate = ? , LoginTime = ? , LogoutDate = ? , LogoutTime = ? WHERE  ID = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getAgentCode());
			if (getUserType() == null || getUserType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getUserType());
			if (getClientName() == null || getClientName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getClientName());
			if (getClientType() == null || getClientType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getClientType());
			if (getClientIP() == null || getClientIP().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getClientIP());
			if (getLoginTime() == null || getLoginTime().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getLoginTime());
			if (getLogoutTime() == null || getLogoutTime().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getLogoutTime());
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MAgentLoginLogDB";
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
			pstmt = con.prepareStatement("INSERT INTO MAgentLoginLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getAgentCode());
			if (getUserType() == null || getUserType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getUserType());
			if (getClientName() == null || getClientName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getClientName());
			if (getClientType() == null || getClientType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getClientType());
			if (getClientIP() == null || getClientIP().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getClientIP());
			if (getLoginTime() == null || getLoginTime().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getLoginTime());
			if (getLogoutTime() == null || getLogoutTime().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getLogoutTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MAgentLoginLogDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MAgentLoginLog WHERE  ID = ?", 1003, 1007);
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
		tError.moduleName = "MAgentLoginLogDB";
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
				tError.moduleName = "MAgentLoginLogDB";
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

	public MAgentLoginLogSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MAgentLoginLogSet aMAgentLoginLogSet = new MAgentLoginLogSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MAgentLoginLog");
			MAgentLoginLogSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MAgentLoginLogSchema s1;
			for (; rs.next(); aMAgentLoginLogSet.add(s1))
			{
				i++;
				s1 = new MAgentLoginLogSchema();
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
			tError.moduleName = "MAgentLoginLogDB";
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
		return aMAgentLoginLogSet;
	}

	public MAgentLoginLogSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MAgentLoginLogSet aMAgentLoginLogSet = new MAgentLoginLogSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MAgentLoginLogSchema s1;
			for (; rs.next(); aMAgentLoginLogSet.add(s1))
			{
				i++;
				s1 = new MAgentLoginLogSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MAgentLoginLogDB";
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
			tError.moduleName = "MAgentLoginLogDB";
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
		return aMAgentLoginLogSet;
	}

	public MAgentLoginLogSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MAgentLoginLogSet aMAgentLoginLogSet = new MAgentLoginLogSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MAgentLoginLog");
			MAgentLoginLogSchema aSchema = getSchema();
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
				MAgentLoginLogSchema s1 = new MAgentLoginLogSchema();
				s1.setSchema(rs, i);
				aMAgentLoginLogSet.add(s1);
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
			tError.moduleName = "MAgentLoginLogDB";
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
		return aMAgentLoginLogSet;
	}

	public MAgentLoginLogSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MAgentLoginLogSet aMAgentLoginLogSet = new MAgentLoginLogSet();
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
				MAgentLoginLogSchema s1 = new MAgentLoginLogSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MAgentLoginLogDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMAgentLoginLogSet.add(s1);
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
			tError.moduleName = "MAgentLoginLogDB";
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
		return aMAgentLoginLogSet;
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
				SQLString sqlObj = new SQLString("MAgentLoginLog");
				MAgentLoginLogSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MAgentLoginLog ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MAgentLoginLogDB";
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
				tError.moduleName = "MAgentLoginLogDB";
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
			tError.moduleName = "MAgentLoginLogDB";
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
			tError.moduleName = "MAgentLoginLogDB";
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
			tError.moduleName = "MAgentLoginLogDB";
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
			tError.moduleName = "MAgentLoginLogDB";
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

	public MAgentLoginLogSet getData()
	{
		int tCount = 0;
		MAgentLoginLogSet tMAgentLoginLogSet = new MAgentLoginLogSet();
		MAgentLoginLogSchema tMAgentLoginLogSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MAgentLoginLogDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMAgentLoginLogSchema = new MAgentLoginLogSchema();
			tMAgentLoginLogSchema.setSchema(mResultSet, 1);
			tMAgentLoginLogSet.add(tMAgentLoginLogSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMAgentLoginLogSchema = new MAgentLoginLogSchema();
					tMAgentLoginLogSchema.setSchema(mResultSet, 1);
					tMAgentLoginLogSet.add(tMAgentLoginLogSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MAgentLoginLogDB";
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
		return tMAgentLoginLogSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MAgentLoginLogDB";
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
			tError.moduleName = "MAgentLoginLogDB";
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
				tError.moduleName = "MAgentLoginLogDB";
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
			tError.moduleName = "MAgentLoginLogDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
