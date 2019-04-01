// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBOper.java

package com.sinosoft.banklns.utility;

import java.sql.*;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CErrors, DBConnPool, CError, SQLString, 
//			SchemaSet, Schema

public class DBOper
{

	private Connection con;
	private String tableName;
	private boolean cflag;
	public CErrors mErrors;

	public DBOper(Connection tConnection, String t)
	{
		cflag = false;
		mErrors = new CErrors();
		con = tConnection;
		tableName = t;
	}

	public DBOper(String t)
	{
		cflag = false;
		mErrors = new CErrors();
		tableName = t;
		con = null;
		cflag = true;
	}

	public Connection getConnection()
	{
		return DBConnPool.getConnection();
	}

	public boolean insert(Schema s)
	{
		Statement stmt = null;
		if (cflag)
			con = DBConnPool.getConnection();
		if (con == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "insert";
			tError.errorMessage = "Connection��bʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
		boolean flag;
		try
		{
			stmt = con.createStatement();
			SQLString sqlObj = new SQLString(tableName);
			sqlObj.setSQL(1, s);
			String sql = sqlObj.getSQL();
			int operCount = stmt.executeUpdate(sql);
			if (operCount > 0)
			{
				flag = true;
			} else
			{
				CError tError = new CError();
				tError.moduleName = "DBOper";
				tError.functionName = "insert";
				tError.errorMessage = "ʵ�ʲ������ݼ�¼��Ϊ�������?";
				mErrors.addOneError(tError);
				flag = false;
			}
			stmt.close();
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "insert";
			tError.errorMessage = e.getMessage();
			mErrors.addOneError(tError);
			try
			{
				stmt.close();
			}
			catch (Exception exception1) { }
			if (cflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return flag;
	}

	public boolean insert(SchemaSet s)
	{
		Statement stmt = null;
		if (cflag)
			con = DBConnPool.getConnection();
		if (con == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "insert";
			tError.errorMessage = "Connection��bʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
		boolean flag;
		try
		{
			int n = s.size();
			Schema aSchema = null;
			String sql = null;
			SQLString sqlObj = null;
			stmt = con.createStatement();
			for (int i = 1; i <= n; i++)
			{
				aSchema = (Schema)s.getObj(i);
				sqlObj = new SQLString(tableName);
				sqlObj.setSQL(1, aSchema);
				sql = sqlObj.getSQL();
				stmt.addBatch(sql);
			}

			try
			{
				int operCount[] = stmt.executeBatch();
				flag = true;
			}
			catch (Exception e)
			{
				flag = false;
			}
			stmt.close();
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "insert";
			tError.errorMessage = e.getMessage();
			mErrors.addOneError(tError);
			try
			{
				stmt.close();
			}
			catch (Exception exception1) { }
			if (cflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return flag;
	}

	public boolean update(Schema s)
	{
		Statement stmt = null;
		if (cflag)
			con = DBConnPool.getConnection();
		if (con == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "update";
			tError.errorMessage = "Connection��bʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
		boolean flag;
		try
		{
			stmt = con.createStatement();
			SQLString sqlObj = new SQLString(tableName);
			sqlObj.setSQL(2, s);
			String sql = sqlObj.getSQL();
			int operCount = stmt.executeUpdate(sql);
			if (operCount > 0)
			{
				flag = true;
			} else
			{
				CError tError = new CError();
				tError.moduleName = "DBOper";
				tError.functionName = "update";
				tError.errorMessage = "ʵ�ʲ������ݼ�¼��Ϊ�������?";
				mErrors.addOneError(tError);
				flag = false;
			}
			stmt.close();
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "update";
			tError.errorMessage = e.getMessage();
			mErrors.addOneError(tError);
			try
			{
				stmt.close();
			}
			catch (Exception exception1) { }
			if (cflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return flag;
	}

	public boolean update(SchemaSet s)
	{
		Statement stmt = null;
		if (cflag)
			con = DBConnPool.getConnection();
		if (con == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "update";
			tError.errorMessage = "Connection��bʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
		boolean flag;
		try
		{
			int n = s.size();
			Schema aSchema = null;
			String sql = null;
			SQLString sqlObj = null;
			stmt = con.createStatement();
			for (int i = 1; i <= n; i++)
			{
				aSchema = (Schema)s.getObj(i);
				sqlObj = new SQLString(tableName);
				sqlObj.setSQL(2, aSchema);
				sql = sqlObj.getSQL();
				stmt.addBatch(sql);
			}

			try
			{
				int operCount[] = stmt.executeBatch();
				flag = true;
			}
			catch (Exception e)
			{
				flag = false;
			}
			stmt.close();
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "update";
			tError.errorMessage = e.getMessage();
			mErrors.addOneError(tError);
			try
			{
				stmt.close();
			}
			catch (Exception exception1) { }
			if (cflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return flag;
	}

	public boolean deleteSQL(Schema s)
	{
		Statement stmt;
		stmt = null;
		if (cflag)
			con = DBConnPool.getConnection();
		if (con == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "Connection��bʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
		SQLString sqlObj;
		stmt = con.createStatement();
		sqlObj = new SQLString(tableName);
		sqlObj.setSQL(3, s);
		if (sqlObj.getWherePart().compareTo("") != 0)
			break MISSING_BLOCK_LABEL_180;
		CError tError = new CError();
		tError.moduleName = "DBOper";
		tError.functionName = "delete";
		tError.errorMessage = "ɾ�����Ϊ��?";
		mErrors.addOneError(tError);
		try
		{
			stmt.close();
		}
		catch (Exception exception1) { }
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception2) { }
		return false;
		boolean flag;
		try
		{
			String sql = sqlObj.getSQL();
			int operCount = stmt.executeUpdate(sql);
			flag = true;
			stmt.close();
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "deleteSQL";
			tError.errorMessage = e.getMessage();
			mErrors.addOneError(tError);
			try
			{
				stmt.close();
			}
			catch (Exception exception3) { }
			if (cflag)
				try
				{
					con.close();
				}
				catch (Exception exception4) { }
			return false;
		}
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return flag;
	}

	public boolean deleteSQL(SchemaSet s)
	{
		Statement stmt;
		stmt = null;
		if (cflag)
			con = DBConnPool.getConnection();
		if (con == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "Connection��bʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
		int n;
		SQLString sqlObj;
		int i;
		n = s.size();
		Schema aSchema = null;
		String sql = null;
		sqlObj = null;
		stmt = con.createStatement();
		i = 1;
		  goto _L1
_L5:
		Schema aSchema = (Schema)s.getObj(i);
		sqlObj = new SQLString(tableName);
		sqlObj.setSQL(3, aSchema);
		if (sqlObj.getWherePart().compareTo("") != 0) goto _L3; else goto _L2
_L2:
		CError tError = new CError();
		tError.moduleName = "DBOper";
		tError.functionName = "delete";
		tError.errorMessage = "ɾ�����Ϊ��?";
		mErrors.addOneError(tError);
		try
		{
			stmt.close();
		}
		catch (Exception exception3) { }
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception4) { }
		return false;
_L3:
		String sql = sqlObj.getSQL();
		stmt.addBatch(sql);
		i++;
_L1:
		if (i <= n) goto _L5; else goto _L4
_L4:
		boolean flag;
		try
		{
			int operCount[] = stmt.executeBatch();
			flag = true;
		}
		catch (Exception e)
		{
			flag = false;
		}
		stmt.close();
		break MISSING_BLOCK_LABEL_342;
		Exception e;
		e;
		CError tError = new CError();
		tError.moduleName = "DBOper";
		tError.functionName = "deleteSQL";
		tError.errorMessage = e.getMessage();
		mErrors.addOneError(tError);
		try
		{
			stmt.close();
		}
		catch (Exception exception1) { }
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception2) { }
		return false;
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return flag;
	}

	public boolean delete(Schema s)
	{
		Statement stmt = null;
		if (cflag)
			con = DBConnPool.getConnection();
		if (con == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "delete";
			tError.errorMessage = "Connection��bʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
		boolean flag;
		try
		{
			stmt = con.createStatement();
			SQLString sqlObj = new SQLString(tableName);
			sqlObj.setSQL(4, s);
			String sql = sqlObj.getSQL();
			int operCount = stmt.executeUpdate(sql);
			flag = true;
			stmt.close();
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "delete";
			tError.errorMessage = e.getMessage();
			mErrors.addOneError(tError);
			try
			{
				stmt.close();
			}
			catch (Exception exception1) { }
			if (cflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return flag;
	}

	public boolean delete(SchemaSet s)
	{
		Statement stmt = null;
		if (cflag)
			con = DBConnPool.getConnection();
		if (con == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "delete";
			tError.errorMessage = "Connection��bʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
		boolean flag;
		try
		{
			int n = s.size();
			Schema aSchema = null;
			String sql = null;
			SQLString sqlObj = null;
			stmt = con.createStatement();
			for (int i = 1; i <= n; i++)
			{
				aSchema = (Schema)s.getObj(i);
				sqlObj = new SQLString(tableName);
				sqlObj.setSQL(4, aSchema);
				sql = sqlObj.getSQL();
				stmt.addBatch(sql);
			}

			try
			{
				int operCount[] = stmt.executeBatch();
				flag = true;
			}
			catch (Exception e)
			{
				flag = false;
			}
			stmt.close();
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "delete";
			tError.errorMessage = e.getMessage();
			mErrors.addOneError(tError);
			try
			{
				stmt.close();
			}
			catch (Exception exception1) { }
			if (cflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return flag;
	}

	public int getCount(Schema s)
	{
		Statement stmt = null;
		ResultSet rs = null;
		if (cflag)
			con = DBConnPool.getConnection();
		if (con == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "getCount";
			tError.errorMessage = "Connection��bʧ��!";
			mErrors.addOneError(tError);
			return -1;
		}
		int RSCount;
		try
		{
			stmt = con.createStatement();
			SQLString sqlObj = new SQLString(tableName);
			sqlObj.setSQL(7, s);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			rs.next();
			RSCount = rs.getInt(1);
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "DBOper";
			tError.functionName = "getCount";
			tError.errorMessage = e.getMessage();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
				stmt.close();
			}
			catch (Exception exception1) { }
			if (cflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return -1;
		}
		if (cflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return RSCount;
	}

	public static void main(String args1[])
	{
	}
}
