// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OracleDBConn.java

package com.sinosoft.banklns.utility;

import java.io.*;
import java.sql.*;
import java.util.Map;
import java.util.Properties;

// Referenced classes of package com.sinosoft.banklns.utility:
//			JdbcUrl, CError, CErrors

public class OracleDBConn
	implements Connection
{
	class FilterPrintStream extends PrintStream
	{

		final OracleDBConn this$0;

		public FilterPrintStream()
		{
			this$0 = OracleDBConn.this;
			super(bos);
		}
	}


	private JdbcUrl JUrl;
	private Connection con;
	private boolean bNotInUse;
	private ByteArrayOutputStream bos;
	public CErrors mErrors;

	public boolean createConnection()
	{
		int dbType = 0;
		if (con == null)
			break MISSING_BLOCK_LABEL_76;
		if (con.isClosed())
			break MISSING_BLOCK_LABEL_71;
		Statement stmt = con.createStatement();
		stmt.execute("SELECT * FROM DUAL");
		stmt.close();
		return true;
		Exception e;
		e;
		System.out.println("DBConn : recreate DBConn");
		con.close();
		con = null;
		con = null;
		if (JUrl.getDBType().toUpperCase().equals("ORACLE"))
			dbType = 1;
		if (JUrl.getDBType().toUpperCase().equals("INFORMIX"))
			dbType = 2;
		if (JUrl.getDBType().toUpperCase().equals("SQLSERVER"))
			dbType = 3;
		if (JUrl.getDBType().toUpperCase().equals("MYSQL"))
			dbType = 4;
		if (JUrl.getDBType().toUpperCase().equals("ACCESS"))
			dbType = 5;
		dbType;
		JVM INSTR tableswitch 1 5: default 257
	//	               1 212
	//	               2 221
	//	               3 230
	//	               4 239
	//	               5 248;
		   goto _L1 _L2 _L3 _L4 _L5 _L6
_L2:
		Class.forName("oracle.jdbc.driver.OracleDriver");
		break; /* Loop/switch isn't completed */
_L3:
		Class.forName("com.informix.jdbc.IfxDriver");
		break; /* Loop/switch isn't completed */
_L4:
		Class.forName("com.inet.tds.TdsDriver");
		break; /* Loop/switch isn't completed */
_L5:
		Class.forName("org.gjt.mm.mysql.Driver");
		break; /* Loop/switch isn't completed */
_L6:
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		break; /* Loop/switch isn't completed */
_L1:
		CError tError = new CError();
		tError.moduleName = "DBConn";
		tError.functionName = "createConnection";
		tError.errorMessage = "目前暂不支持此种类型的数据库!";
		mErrors.addOneError(tError);
		return false;
		tError;
		CError tError = new CError();
		tError.moduleName = "DBConn";
		tError.functionName = "createConnection";
		tError.errorMessage = tError.toString();
		mErrors.addOneError(tError);
		return false;
		try
		{
			switch (dbType)
			{
			case 1: // '\001'
				con = DriverManager.getConnection(JUrl.getJdbcUrl(), JUrl.getUserName(), JUrl.getPassWord());
				Statement stmt = con.createStatement(1005, 1008);
				stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
				stmt.close();
				break;

			case 2: // '\002'
				con = DriverManager.getConnection(JUrl.getJdbcUrl());
				break;

			case 3: // '\003'
				con = DriverManager.getConnection(JUrl.getJdbcUrl(), JUrl.getUserName(), JUrl.getPassWord());
				break;

			case 4: // '\004'
				con = DriverManager.getConnection(JUrl.getJdbcUrl(), JUrl.getUserName(), JUrl.getPassWord());
				// fall through

			case 5: // '\005'
				con = DriverManager.getConnection(JUrl.getJdbcUrl(), JUrl.getUserName(), JUrl.getPassWord());
				break;
			}
		}
		// Misplaced declaration of an exception variable
		catch (Statement stmt)
		{
			CError tError = new CError();
			tError.moduleName = "DBConn";
			tError.functionName = "createConnection";
			tError.errorMessage = (new StringBuilder("Connect failed!  error code =")).append(stmt.getErrorCode()).toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	protected OracleDBConn()
	{
		con = null;
		bos = new ByteArrayOutputStream();
		mErrors = new CErrors();
		JUrl = new JdbcUrl();
		bNotInUse = true;
	}

	protected boolean isInnerClose()
	{
		if (con == null)
			return true;
		return con.isClosed();
		SQLException ex;
		ex;
		return true;
	}

	protected void setInUse()
	{
		PrintStream err = System.err;
		System.setErr(new FilterPrintStream());
		Thread.currentThread();
		Thread.dumpStack();
		System.setErr(err);
		bNotInUse = false;
	}

	protected boolean isInUse()
	{
		return !bNotInUse;
	}

	public void clearWarnings()
		throws SQLException
	{
		con.clearWarnings();
	}

	public void close()
		throws SQLException
	{
		System.out.println("DBConn : user release connection!");
		bos.reset();
		bNotInUse = true;
	}

	public void commit()
		throws SQLException
	{
		con.commit();
	}

	public Statement createStatement()
		throws SQLException
	{
		return con.createStatement();
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency)
		throws SQLException
	{
		return con.createStatement();
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
		throws SQLException
	{
		return con.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	public boolean getAutoCommit()
		throws SQLException
	{
		return con.getAutoCommit();
	}

	public String getCatalog()
		throws SQLException
	{
		return con.getCatalog();
	}

	public int getHoldability()
		throws SQLException
	{
		return con.getHoldability();
	}

	public DatabaseMetaData getMetaData()
		throws SQLException
	{
		return con.getMetaData();
	}

	public int getTransactionIsolation()
		throws SQLException
	{
		return con.getTransactionIsolation();
	}

	public Map getTypeMap()
		throws SQLException
	{
		return con.getTypeMap();
	}

	public SQLWarning getWarnings()
		throws SQLException
	{
		return con.getWarnings();
	}

	public boolean isClosed()
		throws SQLException
	{
		if (bNotInUse)
			return true;
		else
			return con.isClosed();
	}

	public boolean isReadOnly()
		throws SQLException
	{
		return con.isReadOnly();
	}

	public String nativeSQL(String sql)
		throws SQLException
	{
		return con.nativeSQL(sql);
	}

	public CallableStatement prepareCall(String sql)
		throws SQLException
	{
		return con.prepareCall(sql);
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
		throws SQLException
	{
		return con.prepareCall(sql, resultSetType, resultSetConcurrency);
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
		throws SQLException
	{
		return con.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	public PreparedStatement prepareStatement(String sql)
		throws SQLException
	{
		return con.prepareStatement(sql);
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
		throws SQLException
	{
		return con.prepareStatement(sql, autoGeneratedKeys);
	}

	public PreparedStatement prepareStatement(String sql, int columnIndexes[])
		throws SQLException
	{
		return con.prepareStatement(sql, columnIndexes);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
		throws SQLException
	{
		return con.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
		throws SQLException
	{
		return con.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	public PreparedStatement prepareStatement(String sql, String columnNames[])
		throws SQLException
	{
		return con.prepareStatement(sql, columnNames);
	}

	public void releaseSavepoint(Savepoint savepoint)
		throws SQLException
	{
		con.releaseSavepoint(savepoint);
	}

	public void rollback()
		throws SQLException
	{
		con.rollback();
	}

	public void rollback(Savepoint savepoint)
		throws SQLException
	{
		con.rollback(savepoint);
	}

	public void setAutoCommit(boolean autoCommit)
		throws SQLException
	{
		con.setAutoCommit(autoCommit);
	}

	public void setCatalog(String catalog)
		throws SQLException
	{
		con.setCatalog(catalog);
	}

	public void setHoldability(int holdability)
		throws SQLException
	{
		con.setHoldability(holdability);
	}

	public void setReadOnly(boolean readOnly)
		throws SQLException
	{
		con.setReadOnly(readOnly);
	}

	public Savepoint setSavepoint()
		throws SQLException
	{
		return con.setSavepoint();
	}

	public Savepoint setSavepoint(String name)
		throws SQLException
	{
		return con.setSavepoint(name);
	}

	public void setTransactionIsolation(int level)
		throws SQLException
	{
		con.setTransactionIsolation(level);
	}

	public void setTypeMap(Map map)
		throws SQLException
	{
		con.setTypeMap(map);
	}

	protected void dumpConnInfo(OutputStream os)
		throws Exception
	{
		if (!isClosed())
			os.write(bos.toByteArray());
	}

	public Array createArrayOf(String arg0, Object arg1[])
		throws SQLException
	{
		return null;
	}

	public Blob createBlob()
		throws SQLException
	{
		return null;
	}

	public Clob createClob()
		throws SQLException
	{
		return null;
	}

	public Struct createStruct(String arg0, Object arg1[])
		throws SQLException
	{
		return null;
	}

	public Properties getClientInfo()
		throws SQLException
	{
		return null;
	}

	public String getClientInfo(String arg0)
		throws SQLException
	{
		return null;
	}

	public boolean isValid(int arg0)
		throws SQLException
	{
		return false;
	}

	public boolean isWrapperFor(Class arg0)
		throws SQLException
	{
		return false;
	}

	public Object unwrap(Class arg0)
		throws SQLException
	{
		return null;
	}

}
