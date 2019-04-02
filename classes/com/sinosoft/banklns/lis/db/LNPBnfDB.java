// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPBnfDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPBnfDB extends LNPBnfSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;

	public LNPBnfDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		con = tConnection;
		db = new DBOper(con, "LNPBnf");
		mflag = true;
	}

	public LNPBnfDB()
	{
		mflag = false;
		mErrors = new CErrors();
		con = null;
		db = new DBOper("LNPBnf");
		mflag = false;
	}

	public boolean insert()
	{
		LNPBnfSchema tSchema = getSchema();
		if (!db.insert(tSchema))
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBnfDB";
			tError.functionName = "insert";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}

	public boolean update()
	{
		LNPBnfSchema tSchema = getSchema();
		if (!db.update(tSchema))
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBnfDB";
			tError.functionName = "update";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}

	public boolean deleteSQL()
	{
		LNPBnfSchema tSchema = getSchema();
		if (!db.deleteSQL(tSchema))
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBnfDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}

	public boolean delete()
	{
		LNPBnfSchema tSchema = getSchema();
		if (!db.delete(tSchema))
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBnfDB";
			tError.functionName = "delete";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}

	public int getCount()
	{
		LNPBnfSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBnfDB";
			tError.functionName = "getCount";
			tError.errorMessage = "����ʧ��!";
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
		SQLString sqlObj = new SQLString("LNPBnf");
		LNPBnfSchema aSchema = getSchema();
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
		tError.moduleName = "LNPBnfDB";
		tError.functionName = "getInfo";
		tError.errorMessage = "ȡ��ʧ��!";
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
				tError.moduleName = "LNPBnfDB";
				tError.functionName = "getInfo";
				tError.errorMessage = "δ�ҵ�������!";
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
				tError.moduleName = "LNPBnfDB";
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

	public LNPBnfSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPBnfSet aLNPBnfSet = new LNPBnfSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPBnf");
			LNPBnfSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPBnfSchema s1;
			for (; rs.next(); aLNPBnfSet.add(s1))
			{
				i++;
				s1 = new LNPBnfSchema();
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
			tError.moduleName = "LNPBnfDB";
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
		return aLNPBnfSet;
	}

	public LNPBnfSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPBnfSet aLNPBnfSet = new LNPBnfSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPBnfSchema s1;
			for (; rs.next(); aLNPBnfSet.add(s1))
			{
				i++;
				s1 = new LNPBnfSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPBnfDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�����ֶ�����Ϣ!";
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
			tError.moduleName = "LNPBnfDB";
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
		return aLNPBnfSet;
	}

	public LNPBnfSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPBnfSet aLNPBnfSet = new LNPBnfSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPBnf");
			LNPBnfSchema aSchema = getSchema();
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
				LNPBnfSchema s1 = new LNPBnfSchema();
				s1.setSchema(rs, i);
				aLNPBnfSet.add(s1);
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
			tError.moduleName = "LNPBnfDB";
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
		return aLNPBnfSet;
	}

	public LNPBnfSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPBnfSet aLNPBnfSet = new LNPBnfSet();
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
				LNPBnfSchema s1 = new LNPBnfSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPBnfDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�����ֶ�����Ϣ!";
					mErrors.addOneError(tError);
				}
				aLNPBnfSet.add(s1);
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
			tError.moduleName = "LNPBnfDB";
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
		return aLNPBnfSet;
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
				SQLString sqlObj = new SQLString("LNPBnf");
				LNPBnfSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPBnf ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPBnfDB";
				tError.functionName = "update";
				tError.errorMessage = "�������ʧ��?!";
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
				tError.moduleName = "LNPBnfDB";
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
