// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CEConectionEDU.java

package com.sinosoft.banklns.utility;

import com.filenet.api.collection.ObjectStoreSet;
import com.filenet.api.collection.RepositoryRowSet;
import com.filenet.api.collection.StringList;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.Properties;
import com.filenet.api.query.RepositoryRow;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.UserContext;
import com.sinosoft.banklns.lis.db.LNPContDB;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.vdb.LNPContDBSet;
import com.sinosoft.banklns.lis.vschema.LNPContSet;
import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

// Referenced classes of package com.sinosoft.banklns.utility:
//			ExeSQL, SSRS

public class CEConectionEDU
{
	private static class CEConfiguration
	{

		private static final String URI = "URI";
		private static final String DOMAINNAME = "DOMAINNAME";
		private static final String USERNAME = "USERNAME";
		private static final String PWD = "PWD";
		private static final String OBJECT_STORE_NM = "OS_NM";
		private static final String XMLFILEPATH = "WEB-INF/config/dbconn/dbconnection.xml";
		private static String CEUri;
		private static String DomainName;
		private static String User;
		private static String Password;
		private static String OsName;
		private static String dbURL = "";
		private static String dbUsername = "";
		private static String dbPassword = "";
		private static String dbPort = "";
		private static String dbIP = "";
		private static String dbName = "";

		private static void initCEConfig()
		{
			Connection dbConn = null;
			try
			{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~·final prama");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				dbConn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
				ExeSQL execSQL = new ExeSQL(dbConn);
				String sql = "select SysVarType,SysVarValue from LNPSysVar where sysvar like 'CE_ARGS%'";
				SSRS ssrs = execSQL.execSQL(sql);
				for (int i = 1; i <= ssrs.MaxRow; i++)
					if ("URI".equalsIgnoreCase(ssrs.GetText(i, 1)))
						CEUri = ssrs.GetText(i, 2);
					else
					if ("DOMAINNAME".equalsIgnoreCase(ssrs.GetText(i, 1)))
						DomainName = ssrs.GetText(i, 2);
					else
					if ("USERNAME".equalsIgnoreCase(ssrs.GetText(i, 1)))
						User = ssrs.GetText(i, 2);
					else
					if ("PWD".equalsIgnoreCase(ssrs.GetText(i, 1)))
						Password = ssrs.GetText(i, 2);
					else
					if ("OS_NM".equalsIgnoreCase(ssrs.GetText(i, 1)))
						OsName = ssrs.GetText(i, 2);

				break MISSING_BLOCK_LABEL_270;
			}
			catch (Exception e)
			{
				System.out.println("erro is because of:initCEConfig CEconnectionEDU");
				e.printStackTrace();
			}
			if (dbConn != null)
				try
				{
					dbConn.close();
				}
				catch (SQLException e)
				{
					dbConn = null;
					e.printStackTrace();
				}
			break MISSING_BLOCK_LABEL_292;
			Exception exception;
			exception;
			if (dbConn != null)
				try
				{
					dbConn.close();
				}
				catch (SQLException e)
				{
					dbConn = null;
					e.printStackTrace();
				}
			throw exception;
			if (dbConn != null)
				try
				{
					dbConn.close();
				}
				catch (SQLException e)
				{
					dbConn = null;
					e.printStackTrace();
				}
		}

		private static void initDBConfig()
		{
			try
			{
				File xmlFile = new File("WEB-INF/config/dbconn/dbconnection.xml");
				SAXReader saxReader = new SAXReader();
				Document doc = saxReader.read(xmlFile);
				Element root = doc.getRootElement();
				for (Iterator iter = root.elementIterator("database"); iter.hasNext();)
				{
					Element foo = (Element)iter.next();
					if ("bak".equals(foo.elementText("Useto")))
					{
						dbUsername = foo.elementText("UserName");
						dbPassword = foo.elementText("PassWord");
						dbName = foo.elementText("DBName");
						dbPort = foo.elementText("Port");
						dbIP = foo.elementText("IP");
						dbURL = (new StringBuilder("jdbc:sqlserver://")).append(dbIP).append("\\SQLEXPRESS:").append(dbPort).append(";databasename=").append(dbName).toString();
						break;
					}
				}

			}
			catch (Exception e)
			{
				System.out.println("erro is because of:initDBConfig CEconnectionEDU");
				e.printStackTrace();
			}
		}

		static 
		{
			CEUri = "";
			DomainName = "";
			User = "";
			Password = "";
			OsName = "";
			initDBConfig();
			initCEConfig();
			System.out.println(" init SUCCESS");
			System.out.println((new StringBuilder(String.valueOf(CEUri))).append("--").append(DomainName).append("--").append(User).append("--").append(Password).append("--").append(OsName).toString());
		}









		private CEConfiguration()
		{
		}
	}


	private static Connection dbConn;
	private static com.filenet.api.core.Connection conn;
	private static Domain domain;
	private static ObjectStore os;
	private ObjectStoreSet OStoreSet;

	public CEConectionEDU()
	{
		try
		{
			if (dbConn == null || dbConn.isClosed())
			{
				System.out.println((new StringBuilder("~~~~~~~~~~~~~~~~~dburl:")).append(CEConfiguration.dbURL).append("~~dbNM:").append(CEConfiguration.dbUsername).append("~~~~~~~~dbPWD:").append(CEConfiguration.dbPassword).toString());
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				dbConn = DriverManager.getConnection(CEConfiguration.dbURL, CEConfiguration.dbUsername, CEConfiguration.dbPassword);
			}
		}
		catch (Exception e)
		{
			System.out.println("erro is because of:constracotr CEconnectionEDU");
			e.printStackTrace();
		}
	}

	public static com.filenet.api.core.Connection getCEConnEDU()
	{
		conn = com.filenet.api.core.Factory.Connection.getConnection(CEConfiguration.CEUri);
		javax.security.auth.Subject subject = UserContext.createSubject(conn, CEConfiguration.User, CEConfiguration.Password, "FileNetP8WSI");
		UserContext uc = UserContext.get();
		uc.pushSubject(subject);
		return conn;
	}

	public static Domain getDomainEDU(com.filenet.api.core.Connection conn)
	{
		domain = com.filenet.api.core.Factory.Domain.fetchInstance(conn, CEConfiguration.DomainName, null);
		return domain;
	}

	public static ObjectStore getDefObjectStoreEDU()
	{
		try
		{
			getDomainEDU(getCEConnEDU());
			os = com.filenet.api.core.Factory.ObjectStore.fetchInstance(domain, CEConfiguration.OsName, null);
		}
		catch (Exception e)
		{
			System.out.println((new StringBuilder("~~~errMSG:")).append(e.getLocalizedMessage()).toString());
			e.printStackTrace();
		}
		return os;
	}

	public ObjectStore getObjectStoreEDUByOSNm(String OSName)
	{
		ObjectStore store = null;
		getObjectStroeSet();
		for (Iterator iterator = OStoreSet.iterator(); iterator.hasNext();)
		{
			store = (ObjectStore)iterator.next();
			if (store != null && store.get_Name().equals(OSName))
				return store;
		}

		return null;
	}

	public ObjectStoreSet getObjectStroeSet()
	{
		OStoreSet = domain.get_ObjectStores();
		return OStoreSet;
	}

	public static RepositoryRowSet ExcVQL(String sql)
	{
		RepositoryRowSet ResultSet = null;
		try
		{
			System.out.println((new StringBuilder("~~~~~~~~~~~~~ExcVQL:")).append(sql).toString());
			SearchSQL searchSQL = new SearchSQL();
			searchSQL.setQueryString(sql);
			getDefObjectStoreEDU();
			SearchScope sqlObject = new SearchScope(os);
			ResultSet = sqlObject.fetchRows(searchSQL, null, null, null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ResultSet;
	}

	public static boolean isExistsImgPieces(RepositoryRowSet ResultSet)
	{
		return ResultSet != null && !ResultSet.isEmpty();
	}

	public void turnMsg()
	{
		try
		{
			long startTime = System.currentTimeMillis();
			System.out.println((new StringBuilder("~~~~~~~~~~~~~~~~~~~~~~~~~start time:")).append(startTime).toString());
			String sql = "SELECT BranchCode,ScanTime,AppNo FROM NBDoc where ScanTime is not null";
			RepositoryRowSet rowSet = ExcVQL(sql);
			long endtime = System.currentTimeMillis();
			System.out.println(calHMS((endtime - startTime) / 1000L));
			LNPContDB db = new LNPContDB(dbConn);
			LNPContDBSet dbSet = new LNPContDBSet(dbConn);
			LNPContSet lnpSet = db.executeQuery("select * from lnpcont where OutPayFlag<>'Y' or OutPayFlag is null");
			Date date = new Date();
			String curDate = (new SimpleDateFormat("yyyyMMdd")).format(date);
			String curTime = (new SimpleDateFormat("HH:mm:ss")).format(date);
			for (int i = 1; i <= lnpSet.size(); i++)
			{
				LNPContSchema tSchema = lnpSet.get(i);
				for (Iterator iterator = rowSet.iterator(); iterator.hasNext();)
				{
					RepositoryRow row = (RepositoryRow)iterator.next();
					String AppNo = (String)row.getProperties().getStringListValue("AppNo").get(0);
					if (tSchema.getContNo() != null && tSchema.getContNo().equals(AppNo))
					{
						lnpSet.get(i).setOutPayFlag("Y");
						lnpSet.get(i).setModifyDate(curDate);
						lnpSet.get(i).setModifyTime(curTime);
						break;
					}
				}

			}

			dbSet.set(lnpSet);
			dbSet.update();
			long endTime = System.currentTimeMillis();
			System.out.println((new StringBuilder("~~~~~~~~~~~~~~~~~~~~~~~~~endTime:")).append(endTime).append(" | totalTime:").append(calHMS((endTime - startTime) / 1000L)).toString());
			break MISSING_BLOCK_LABEL_447;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println((new StringBuilder("~~~~~~~~~~~~~~~~~~~~~turnMSG:")).append(e.getLocalizedMessage()).toString());
		}
		if (dbConn != null)
			try
			{
				dbConn.close();
			}
			catch (SQLException e)
			{
				dbConn = null;
				e.printStackTrace();
			}
		break MISSING_BLOCK_LABEL_475;
		Exception exception;
		exception;
		if (dbConn != null)
			try
			{
				dbConn.close();
			}
			catch (SQLException e)
			{
				dbConn = null;
				e.printStackTrace();
			}
		throw exception;
		if (dbConn != null)
			try
			{
				dbConn.close();
			}
			catch (SQLException e)
			{
				dbConn = null;
				e.printStackTrace();
			}
	}

	private String calHMS(long timeInSeconds)
	{
		long hours = timeInSeconds / 3600L;
		timeInSeconds -= hours * 3600L;
		long minutes = timeInSeconds / 60L;
		timeInSeconds -= minutes * 60L;
		long seconds = timeInSeconds;
		return (new StringBuilder(String.valueOf(hours))).append(" hour(s) ").append(minutes).append(" minute(s) ").append(seconds).append(" second(s)").toString();
	}

	public static void main(String args[])
	{
		String sql = "SELECT TOP 20 * FROM NBDoc where ScanTime is not null";
		RepositoryRowSet rowSet = ExcVQL(sql);
		for (Iterator iterator = rowSet.iterator(); iterator.hasNext();)
		{
			RepositoryRow row = (RepositoryRow)iterator.next();
			Properties props = row.getProperties();
			System.out.println("-----------------------------------///////////////////////////////////////////");
			Object o;
			for (Iterator iterator2 = props.iterator(); iterator2.hasNext(); System.out.println(o))
				o = iterator2.next();

		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Over");
		(new CEConectionEDU()).turnMsg();
	}
}
