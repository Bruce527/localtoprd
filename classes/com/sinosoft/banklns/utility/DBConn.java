// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBConn.java

package com.sinosoft.banklns.utility;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// Referenced classes of package com.sinosoft.banklns.utility:
//			JdbcUrl, JdbcUrlBackUp

public class DBConn
	implements Connection
{

	private JdbcUrl JUrl;
	private Connection con;
	private boolean bNotInUse;
	private boolean bIsPool;
	private Date m_lastestAccess;
	private CharArrayWriter m_buf;
	private PrintWriter m_pw;

	public boolean createConnection()
	{
		int dbType;
		dbType = 0;
		if (JUrl.getDBType().equalsIgnoreCase("WEBLOGICPOOL"))
		{
			dbType = 10;
			bIsPool = true;
			if (getWeblogicPoolConnection())
				return true;
			JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
			JUrl.setDBName(tJdbcUrlBackUp.getDBName());
			JUrl.setDBType(tJdbcUrlBackUp.getDBType());
			JUrl.setIP(tJdbcUrlBackUp.getIP());
			JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
			JUrl.setPort(tJdbcUrlBackUp.getPort());
			JUrl.setServerName(tJdbcUrlBackUp.getServerName());
			JUrl.setUser(tJdbcUrlBackUp.getUserName());
		} else
		if (JUrl.getDBType().equalsIgnoreCase("COMMONSDBCP"))
		{
			bIsPool = true;
			if (getApachecommonDBCP())
				return true;
			JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
			JUrl.setDBName(tJdbcUrlBackUp.getDBName());
			JUrl.setDBType(tJdbcUrlBackUp.getDBType());
			JUrl.setIP(tJdbcUrlBackUp.getIP());
			JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
			JUrl.setPort(tJdbcUrlBackUp.getPort());
			JUrl.setServerName(tJdbcUrlBackUp.getServerName());
			JUrl.setUser(tJdbcUrlBackUp.getUserName());
		} else
		if (JUrl.getDBType().equalsIgnoreCase("WEBSPHERE"))
		{
			bIsPool = true;
			if (getWebSpherePoolConnection())
				return true;
			JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
			JUrl.setDBName(tJdbcUrlBackUp.getDBName());
			JUrl.setDBType(tJdbcUrlBackUp.getDBType());
			JUrl.setIP(tJdbcUrlBackUp.getIP());
			JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
			JUrl.setPort(tJdbcUrlBackUp.getPort());
			JUrl.setServerName(tJdbcUrlBackUp.getServerName());
			JUrl.setUser(tJdbcUrlBackUp.getUserName());
		} else
		if (JUrl.getDBType().equalsIgnoreCase("JBOSS"))
		{
			bIsPool = true;
			if (getJBOSSPoolConnection())
				return true;
			System.out.println("/banklns--------------------jboos conPool is failedÔºåcon get from jdbcurlbak-------------------------------");
			JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
			JUrl.setDBName(tJdbcUrlBackUp.getDBName());
			JUrl.setDBType(tJdbcUrlBackUp.getDBType());
			JUrl.setIP(tJdbcUrlBackUp.getIP());
			JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
			JUrl.setPort(tJdbcUrlBackUp.getPort());
			JUrl.setServerName(tJdbcUrlBackUp.getServerName());
			JUrl.setUser(tJdbcUrlBackUp.getUserName());
		}
		if (con == null)
			break MISSING_BLOCK_LABEL_599;
		if (con.isClosed())
			break MISSING_BLOCK_LABEL_594;
		Statement stmt = con.createStatement();
		stmt.execute("select * from msysvar where vartype='onerow'");
		stmt.close();
		return true;
		SQLException e;
		e;
		e.printStackTrace();
		System.out.println("DBConn : recreate DBConn");
		try
		{
			con.close();
			break MISSING_BLOCK_LABEL_580;
		}
		catch (Exception ex)
		{
			e.printStackTrace();
		}
		con.close();
		break MISSING_BLOCK_LABEL_589;
		Exception exception;
		exception;
		con.close();
		throw exception;
		con.close();
		con = null;
		con = null;
		if (JUrl.getDBType().equalsIgnoreCase("ORACLE"))
			dbType = 1;
		else
		if (JUrl.getDBType().equalsIgnoreCase("INFORMIX"))
			dbType = 2;
		else
		if (JUrl.getDBType().equalsIgnoreCase("SQLSERVER"))
			dbType = 3;
		else
		if (JUrl.getDBType().equalsIgnoreCase("DB2"))
			dbType = 4;
		else
		if (JUrl.getDBType().equalsIgnoreCase("SYBASE"))
			dbType = 5;
		else
		if (JUrl.getDBType().equalsIgnoreCase("SQLSERVER2012"))
			dbType = 6;
		dbType;
		JVM INSTR tableswitch 1 6: default 810
	//	               1 756
	//	               2 765
	//	               3 774
	//	               4 783
	//	               5 792
	//	               6 801;
		   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
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
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		break; /* Loop/switch isn't completed */
_L6:
		Class.forName("com.sybase.jdbc2.jdbc.SybDriver");
		break; /* Loop/switch isn't completed */
_L7:
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		break; /* Loop/switch isn't completed */
_L1:
		System.out.println("ÁõÆÂâçÊöÇ‰∏çÊîØÊåÅÊ≠§ÁßçÁ±ªÂûãÁöÑÊï∞ÊçÆÂ∫ì!");
		return false;
		e;
		return false;
		try
		{
			System.out.println("Á®ãÂ∫è‰∏≠ÂàõÂª∫ËøûÊé•„?Ç„?Ç„?Ç„?Ç„?Ç„?Ç„?Ç„?Ç„?Ç„??");
			switch (dbType)
			{
			case 1: // '\001'
				Properties props = new Properties();
				props.setProperty("user", JUrl.getUserName());
				props.setProperty("password", JUrl.getPassWord());
				props.setProperty("defaultRowPrefetch", "50");
				props.setProperty("defaultExecuteBatch", "50");
				con = DriverManager.getConnection(JUrl.getJdbcUrl(), props);
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
				break;

			case 5: // '\005'
				con = DriverManager.getConnection(JUrl.getJdbcUrl(), JUrl.getUserName(), JUrl.getPassWord());
				break;

			case 6: // '\006'
				con = DriverManager.getConnection(JUrl.getJdbcUrl(), JUrl.getUserName(), JUrl.getPassWord());
				break;
			}
		}
		// Misplaced declaration of an exception variable
		catch (Properties props)
		{
			System.out.println("ÂàõÂª∫ËøûÊé•Â§±Ë¥•...");
			return false;
		}
		return true;
	}

	private boolean getJBOSSPoolConnection()
	{
		Context tContext = new InitialContext();
		DataSource tDataSource = (DataSource)tContext.lookup((new StringBuilder("jdbc/")).append(JUrl.getDBName()).toString());
		if (tDataSource == null)
			break MISSING_BLOCK_LABEL_83;
		con = tDataSource.getConnection();
		if (con == null)
			break MISSING_BLOCK_LABEL_72;
		System.out.println("/banklns--- new Connection from JBOSS Pool ...");
		return true;
		try
		{
			System.out.println("new Connection error ...");
		}
		catch (Throwable e)
		{
			System.out.println("look for jndi name error ...");
			return false;
		}
		return false;
		System.out.println("new DataSource error ...");
		return false;
	}

	private boolean getWeblogicPoolConnection()
	{
		try
		{
			Driver myDriver = (Driver)Class.forName("weblogic.jdbc.pool.Driver").newInstance();
			con = myDriver.connect(JUrl.getJdbcUrl(), null);
			Statement stmt = con.createStatement(1005, 1008);
			stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
			stmt.close();
		}
		catch (Exception ex)
		{
			System.out.println("$$$$$$$$WebLogicPool Connect Failed$$$$$");
			return false;
		}
		return true;
	}

	private boolean getApachecommonDBCP()
	{
		Context tContext = new InitialContext();
		tContext = (Context)tContext.lookup("java:comp/env");
		Object obj = tContext.lookup(JUrl.getDBName());
		DataSource tDataSource = (DataSource)obj;
		if (tDataSource == null)
			break MISSING_BLOCK_LABEL_65;
		con = tDataSource.getConnection();
		return con != null;
		try
		{
			System.out.println("a error occured when geting datasource");
		}
		catch (Throwable e)
		{
			System.out.println("failure when connect apache commons dbcp ");
			e.printStackTrace();
			return false;
		}
		return false;
	}

	private boolean getWebSpherePoolConnection()
	{
		Context tContext = new InitialContext();
		DataSource tDataSource = (DataSource)tContext.lookup((new StringBuilder("java:comp/env/")).append(JUrl.getDBName()).toString());
		if (tDataSource == null)
			break MISSING_BLOCK_LABEL_115;
		con = tDataSource.getConnection();
		Statement stmt = con.createStatement(1005, 1008);
		stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
		stmt.close();
		if (con == null)
			break MISSING_BLOCK_LABEL_104;
		System.out.println("Connect succeed from websphere!");
		return true;
		try
		{
			System.out.println("new Connection error ...");
		}
		catch (Throwable e)
		{
			System.out.println("look for jndi name error ...");
			e.printStackTrace();
			return false;
		}
		return false;
		System.out.println("new DataSource error ...");
		return false;
	}

	protected DBConn()
	{
		con = null;
		bIsPool = false;
		m_lastestAccess = null;
		m_buf = new CharArrayWriter();
		m_pw = new PrintWriter(m_buf, true);
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
		(new Throwable()).printStackTrace(m_pw);
		bNotInUse = false;
		setLastestAccess();
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
		if (bIsPool)
		{
			con.close();
		} else
		{
			m_buf.reset();
			bNotInUse = true;
		}
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
		return con.createStatement(resultSetType, resultSetConcurrency);
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
	{
		return con.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
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
	{
		return con.getHoldability();
		Exception ex;
		ex;
		ex.printStackTrace();
		return 0;
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
	{
		return con.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public PreparedStatement prepareStatement(String sql)
		throws SQLException
	{
		return con.prepareStatement(sql);
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
	{
		return con.prepareStatement(sql, autoGeneratedKeys);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public PreparedStatement prepareStatement(String sql, int columnIndexes[])
	{
		return con.prepareStatement(sql, columnIndexes);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
		throws SQLException
	{
		return con.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
	{
		return con.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public PreparedStatement prepareStatement(String sql, String columnNames[])
	{
		return con.prepareStatement(sql, columnNames);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public void releaseSavepoint(Savepoint savepoint)
	{
		try
		{
			con.releaseSavepoint(savepoint);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void rollback()
		throws SQLException
	{
		con.rollback();
	}

	public void rollback(Savepoint savepoint)
	{
		try
		{
			con.rollback(savepoint);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void setAutoCommit(boolean autoCommit)
		throws SQLException
	{
		if (con.getAutoCommit())
			con.setAutoCommit(autoCommit);
	}

	public void setCatalog(String catalog)
		throws SQLException
	{
		con.setCatalog(catalog);
	}

	public void setHoldability(int holdability)
	{
		try
		{
			con.setHoldability(holdability);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void setReadOnly(boolean readOnly)
		throws SQLException
	{
		con.setReadOnly(readOnly);
	}

	public Savepoint setSavepoint()
	{
		return con.setSavepoint();
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public Savepoint setSavepoint(String name)
	{
		return con.setSavepoint(name);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
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
			os.write(m_buf.toString().getBytes());
	}

	protected void setLastestAccess()
	{
		m_lastestAccess = new Date();
	}

	protected Date getLastestAccess()
	{
		return m_lastestAccess;
	}

	protected void innerClose()
	{
		System.out.println("DBConn.innerClose");
		if (isInUse())
			return;
		m_lastestAccess = null;
		try
		{
			con.rollback();
			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			con = null;
		}
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
