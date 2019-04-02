// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskAmountDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPRiskAmountSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskAmountSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPRiskAmountDB extends LNPRiskAmountSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;

	public LNPRiskAmountDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		con = tConnection;
		db = new DBOper(con, "LNPRiskAmount");
		mflag = true;
	}

	public LNPRiskAmountDB()
	{
		mflag = false;
		mErrors = new CErrors();
		con = null;
		db = new DBOper("LNPRiskAmount");
		mflag = false;
	}

	public boolean insert()
	{
		LNPRiskAmountSchema tSchema = getSchema();
		if (!db.insert(tSchema))
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAmountDB";
			tError.functionName = "insert";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}

	public boolean update()
	{
		LNPRiskAmountSchema tSchema = getSchema();
		if (!db.update(tSchema))
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAmountDB";
			tError.functionName = "update";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}

	public boolean deleteSQL()
	{
		LNPRiskAmountSchema tSchema = getSchema();
		if (!db.deleteSQL(tSchema))
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAmountDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}

	public boolean delete()
	{
		LNPRiskAmountSchema tSchema = getSchema();
		if (!db.delete(tSchema))
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAmountDB";
			tError.functionName = "delete";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}

	public int getCount()
	{
		LNPRiskAmountSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAmountDB";
			tError.functionName = "getCount";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return -1;
		} else
		{
			return tCount;
		}
	}

	public boolean getInfo()
	{
		Statement stmt;
		ResultSet rs;
		stmt = null;
		rs = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		int i;
		stmt = con.createStatement(1003, 1007);
		SQLString sqlObj = new SQLString("LNPRiskAmount");
		LNPRiskAmountSchema aSchema = getSchema();
		sqlObj.setSQL(6, aSchema);
		String sql = sqlObj.getSQL();
		rs = stmt.executeQuery(sql);
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_182;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_182;
		CError tError = new CError();
		tError.moduleName = "LNPRiskAmountDB";
		tError.functionName = "getInfo";
		tError.errorMessage = "取数失败!";
		mErrors.addOneError(tError);
		try
		{
			rs.close();
		}
		catch (Exception exception6) { }
		try
		{
			stmt.close();
		}
		catch (Exception exception7) { }
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception8) { }
		return false;
label0:
		{
			try
			{
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
				if (i != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPRiskAmountDB";
				tError.functionName = "getInfo";
				tError.errorMessage = "未找到相关数据!";
				mErrors.addOneError(tError);
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception9) { }
			}
			catch (Exception e)
			{
				CError tError = new CError();
				tError.moduleName = "LNPRiskAmountDB";
				tError.functionName = "getInfo";
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

	public LNPRiskAmountSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskAmountSet aLNPRiskAmountSet = new LNPRiskAmountSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPRiskAmount");
			LNPRiskAmountSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPRiskAmountSchema s1;
			for (; rs.next(); aLNPRiskAmountSet.add(s1))
			{
				i++;
				s1 = new LNPRiskAmountSchema();
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
			tError.moduleName = "LNPRiskAmountDB";
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
		return aLNPRiskAmountSet;
	}

	public LNPRiskAmountSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskAmountSet aLNPRiskAmountSet = new LNPRiskAmountSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPRiskAmountSchema s1;
			for (; rs.next(); aLNPRiskAmountSet.add(s1))
			{
				i++;
				s1 = new LNPRiskAmountSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPRiskAmountDB";
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
			tError.moduleName = "LNPRiskAmountDB";
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
		return aLNPRiskAmountSet;
	}

	public LNPRiskAmountSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskAmountSet aLNPRiskAmountSet = new LNPRiskAmountSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPRiskAmount");
			LNPRiskAmountSchema aSchema = getSchema();
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
				LNPRiskAmountSchema s1 = new LNPRiskAmountSchema();
				s1.setSchema(rs, i);
				aLNPRiskAmountSet.add(s1);
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
			tError.moduleName = "LNPRiskAmountDB";
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
		return aLNPRiskAmountSet;
	}

	public LNPRiskAmountSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskAmountSet aLNPRiskAmountSet = new LNPRiskAmountSet();
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
				LNPRiskAmountSchema s1 = new LNPRiskAmountSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPRiskAmountDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPRiskAmountSet.add(s1);
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
			tError.moduleName = "LNPRiskAmountDB";
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
		return aLNPRiskAmountSet;
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
				SQLString sqlObj = new SQLString("LNPRiskAmount");
				LNPRiskAmountSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPRiskAmount ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPRiskAmountDB";
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
				tError.moduleName = "LNPRiskAmountDB";
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
}
