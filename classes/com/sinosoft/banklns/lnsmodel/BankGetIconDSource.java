// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankGetIconDSource.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.utility.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BankGetIconDSource
{

	private static Map dSourceMap;

	private BankGetIconDSource()
	{
	}

	private static Map initDsource(String sysVar)
	{
		Map tDSourceMap = new HashMap();
		try
		{
			ExeSQL execSQL = new ExeSQL();
			String sql = (new StringBuilder("select SysVar, SysVarType,SysVarValue from LNPSysVar where SysVar like '")).append(sysVar).append("'").toString();
			SSRS ssrs = execSQL.execSQL(sql);
			for (int i = 1; i <= ssrs.MaxRow; i++)
			{
				String key = (new StringBuilder(String.valueOf(ssrs.GetText(i, 1)))).append(ssrs.GetText(i, 2)).toString();
				String val = ssrs.GetText(i, 3);
				tDSourceMap.put(key, val);
			}

		}
		catch (Exception exception) { }
		return tDSourceMap;
	}

	public static Connection getConn(Map keyList)
	{
		Connection conn = null;
		if (keyList != null)
			try
			{
				JdbcUrl jdbcUrl = new JdbcUrl();
				jdbcUrl.setDBType((String)dSourceMap.get(keyList.get("dbtype")));
				jdbcUrl.setDBName((String)dSourceMap.get(keyList.get("dbname")));
				jdbcUrl.setPort((String)dSourceMap.get(keyList.get("dbport")));
				jdbcUrl.setUser((String)dSourceMap.get(keyList.get("dbuser")));
				jdbcUrl.setPassWord((String)dSourceMap.get(keyList.get("dbpwd")));
				jdbcUrl.setIP((String)dSourceMap.get(keyList.get("dbip")));
				Class.forName((String)dSourceMap.get(keyList.get("dbdriver")));
				conn = DriverManager.getConnection(jdbcUrl.getJdbcUrl(), jdbcUrl.getUserName(), jdbcUrl.getPassWord());
			}
			catch (Exception e)
			{
				try
				{
					if (conn != null && !conn.isClosed())
						conn.close();
				}
				catch (SQLException ex)
				{
					ex.printStackTrace();
				}
			}
		return conn;
	}

	static 
	{
		dSourceMap = new HashMap();
		dSourceMap.clear();
		dSourceMap = initDsource("icon_%");
	}
}
