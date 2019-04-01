// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBSQL.java

package com.sinosoft.banklns.utility;

import java.sql.*;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CErrors, DBConnPool, CError, StrTool, 
//			JdbcUrl

public class DBSQL
{

	private String mTable;
	public CErrors mErrors;

	public DBSQL()
	{
		mTable = null;
		mErrors = new CErrors();
	}

	public void setTable(String aTable)
	{
		mTable = aTable;
	}

	public boolean dealData(String aSQL[], String aSQLTYPE)
	{
		Connection conn;
		String tCrtSQL = null;
		String tSelSQL = null;
		conn = null;
		Statement stmt = null;
		conn = DBConnPool.getConnection();
		if (conn != null)
			break MISSING_BLOCK_LABEL_62;
		CError tError = new CError();
		tError.moduleName = "DBSQL";
		tError.functionName = "isExist";
		tError.errorMessage = "��ݿ�l��ʧ��!";
		mErrors.addOneError(tError);
		return false;
		try
		{
			Statement stmt = conn.createStatement();
			if (!isExist())
			{
				String tCrtSQL = transferSQL(aSQL[0]);
				int i = stmt.executeUpdate(StrTool.GBKToUnicode(tCrtSQL));
			}
			if (aSQLTYPE.trim().equals("00"))
			{
				String tSelSQL = (new StringBuilder("delete")).append(aSQL[1].substring(aSQL[1].lastIndexOf("*") + 1)).toString();
				int j = stmt.executeUpdate(StrTool.GBKToUnicode(tSelSQL));
			}
			stmt.close();
			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			CError tError = new CError();
			tError.moduleName = "ExeSQL";
			tError.functionName = "execUpdateSQL";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	private String transferSQL(String aSQL)
	{
		String tSQL = aSQL.toUpperCase();
		JdbcUrl ju = new JdbcUrl();
		String DBType = ju.getDBType();
		if (DBType.trim().equals("MYSQL"))
		{
			tSQL = StrTool.replace(tSQL, "VARCHAR2", "VARCHAR");
			tSQL = StrTool.replace(tSQL, "NUMBER", "NUMERIC");
			tSQL = StrTool.replace(tSQL, "INTEGER", "INT");
			tSQL = StrTool.replace(tSQL, "BOOLEAN", "TINGINT(1)");
		}
		return tSQL;
	}

	private boolean isExist()
	{
		boolean flag = false;
		Connection conn = null;
		conn = DBConnPool.getConnection();
		if (conn == null)
		{
			CError tError = new CError();
			tError.moduleName = "DBSQL";
			tError.functionName = "isExist";
			tError.errorMessage = "��ݿ�l��ʧ��!";
			mErrors.addOneError(tError);
		}
		try
		{
			DatabaseMetaData dbmd = conn.getMetaData();
			for (ResultSet mrs = dbmd.getTables(null, null, mTable, new String[] {
	"TABLE"
}); mrs.next();)
				flag = true;

			conn.close();
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "DBSQL";
			tError.functionName = "isExist";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				conn.rollback();
				conn.close();
			}
			catch (Exception exception) { }
		}
		return flag;
	}

	public boolean createSQL()
	{
		String tCont = "";
		Connection conn = null;
		conn = DBConnPool.getConnection();
		if (conn == null)
		{
			CError tError = new CError();
			tError.moduleName = "LDCodeBLS";
			tError.functionName = "saveData";
			tError.errorMessage = "��ݿ�l��ʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
		try
		{
			Statement stat = conn.createStatement(1003, 1007);
			ResultSet rs = stat.executeQuery((new StringBuilder("select * from ")).append(mTable).toString());
			ResultSetMetaData meta = rs.getMetaData();
			String tColName = null;
			String tColType = null;
			String tColNull = "";
			String tPriKey = "";
			for (int i = 1; i <= meta.getColumnCount(); i++)
			{
				tColName = meta.getColumnName(i);
				int dataType = meta.getColumnType(i);
				if (dataType == 2)
				{
					if (meta.getPrecision(i) == 38 && meta.getScale(i) == 0)
						tColType = "INTEGER";
					else
					if (meta.getPrecision(i) == 126 && meta.getScale(i) == -127)
						tColType = "FLOAT";
					else
						tColType = (new StringBuilder(String.valueOf(meta.getColumnTypeName(i)))).append("(").append(meta.getPrecision(i)).append(",").append(meta.getScale(i)).append(")").toString();
				} else
				if (dataType == 93 || dataType == 91)
					tColType = meta.getColumnTypeName(i);
				else
					tColType = (new StringBuilder(String.valueOf(meta.getColumnTypeName(i)))).append("(").append(meta.getColumnDisplaySize(i)).append(")").toString();
				if (meta.isNullable(i) == 0)
					tColNull = "not null";
				else
					tColNull = "";
				tCont = (new StringBuilder(String.valueOf(tCont))).append(" ").append(tColName).append(" ").append(tColType).append(" ").append(tColNull).append(",").toString();
			}

			rs.close();
			stat.close();
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet pkrs = dbmd.getPrimaryKeys(null, null, mTable.toUpperCase());
			String tPriCont = null;
			int i = 0;
			while (pkrs.next()) 
				if (++i == 1)
				{
					tPriKey = (new StringBuilder(" constraint ")).append(pkrs.getObject(6).toString()).append(" primary key (").toString();
					tPriCont = pkrs.getObject(4).toString();
				} else
				{
					tPriCont = (new StringBuilder(String.valueOf(tPriCont))).append(", ").append(pkrs.getObject(4).toString()).toString();
				}
			tPriKey = (new StringBuilder(String.valueOf(tPriKey))).append(tPriCont).append(")").toString();
			conn.close();
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LDCodeBLS";
			tError.functionName = "submitData";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				conn.rollback();
				conn.close();
			}
			catch (Exception exception) { }
			return false;
		}
		return true;
	}

	public static void main(String args[])
	{
		DBSQL DBSQL1 = new DBSQL();
	}
}
