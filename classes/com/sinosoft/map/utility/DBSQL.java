// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBSQL.java

package com.sinosoft.map.utility;

import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package com.sinosoft.map.utility:
//			CErrors, DBConnPool, CError

public class DBSQL
{

	private String mTable;
	private String mSQL;
	public CErrors mErrors;

	public DBSQL()
	{
		mTable = null;
		mSQL = null;
		mErrors = new CErrors();
	}

	public String getSQL()
	{
		System.out.println((new StringBuilder("mSQL")).append(mSQL).toString());
		return mSQL;
	}

	public void setTable(String aTable)
	{
		mTable = aTable;
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
			tError.errorMessage = "数据库连接失败!";
			mErrors.addOneError(tError);
			return false;
		}
		try
		{
			System.out.println("Start 查询...");
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
			mSQL = (new StringBuilder("create table ")).append(mTable).append(" ( ").append(tCont).append(tPriKey).append(" ) ").toString();
		}
		catch (Exception ex)
		{
			System.out.println((new StringBuilder(String.valueOf(mTable))).append("表不存在！").toString());
			ex.printStackTrace();
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

	public static void main(String args1[])
	{
	}
}
