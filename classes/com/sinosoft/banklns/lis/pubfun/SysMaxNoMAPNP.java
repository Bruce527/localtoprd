// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysMaxNoMAPNP.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package com.sinosoft.banklns.lis.pubfun:
//			SysMaxNo, PubFun

public class SysMaxNoMAPNP
	implements SysMaxNo
{

	public SysMaxNoMAPNP()
	{
	}

	public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
	{
		return CreateMaxNo(cNoType, cNoLimit);
	}

	public String CreateMaxNo(String cNoType, String cNoLimit)
	{
		int serialLen;
		Connection conn;
		int tMaxNo;
		if (cNoType == null || cNoType.trim().length() <= 0 || cNoLimit == null)
		{
			System.out.println("NoType长度错误或者NoLimit为空");
			return null;
		}
		serialLen = 20;
		String tReturn = null;
		cNoType = cNoType.toUpperCase();
		tReturn = cNoLimit.trim();
		conn = null;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch (ClassNotFoundException e1)
		{
			e1.printStackTrace();
			return null;
		}
		if (conn == null)
			try
			{
				conn = DriverManager.getConnection("jdbc:sqlserver://10.164.4.48\\SQLEXPRESS:1433;databasename=MDES", "edifierg", "edifierg");
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
				CError.buildErr(this, "数据库连接失败");
				return null;
			}
		if (conn == null)
		{
			System.out.println("CreateMaxNo : fail to get db connection");
			return tReturn;
		}
		tMaxNo = 0;
		String result;
		conn.setAutoCommit(false);
		StringBuffer tSBql = new StringBuffer(128);
		tSBql.append("select MaxNo from LNPMaxNo where notype='");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit='");
		tSBql.append(cNoLimit);
		tSBql.append("' ");
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(tSBql.toString());
		if (!exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_238;
		System.out.println("查询LNPMaxNo出错，请稍后!");
		conn.rollback();
		conn.close();
		return null;
label0:
		{
			StringBuffer tSBql;
			ExeSQL exeSQL;
			try
			{
				if (result != null && !result.equals(""))
					break MISSING_BLOCK_LABEL_357;
				tSBql = new StringBuffer(128);
				tSBql.append("insert into lnpmaxno(notype, nolimit, maxno) values('");
				tSBql.append(cNoType);
				tSBql.append("', '");
				tSBql.append(cNoLimit);
				tSBql.append("', 1)");
				exeSQL = new ExeSQL(conn);
				if (exeSQL.execUpdateSQL(tSBql.toString()))
					break label0;
				System.out.println("CreateMaxNo 插入失败，请重试!");
				conn.rollback();
				conn.close();
			}
			catch (Exception Ex)
			{
				try
				{
					conn.rollback();
					conn.close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					return null;
				}
				return null;
			}
			return null;
		}
		tMaxNo = 1;
		break MISSING_BLOCK_LABEL_464;
		tSBql = new StringBuffer(128);
		tSBql.append("update lnpmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_455;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = Integer.parseInt(result) + 1;
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_508;
		String tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", serialLen);
		String tReturn = tStr;
		return tReturn;
	}

	public String CreateMaxNo1(Connection conn, String cNoType, String cNoLimit)
	{
		int serialLen;
		int tMaxNo;
		if (cNoType == null || cNoType.trim().length() <= 0 || cNoLimit == null)
		{
			System.out.println("NoType长度错误或者NoLimit为空");
			return null;
		}
		serialLen = 20;
		String tReturn = null;
		cNoType = cNoType.toUpperCase();
		tReturn = cNoLimit.trim();
		tMaxNo = 0;
		String result;
		StringBuffer tSBql = new StringBuffer(128);
		tSBql.append("select MaxNo from LNPMaxNo where notype='");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit='");
		tSBql.append(cNoLimit);
		tSBql.append("' ");
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(tSBql.toString());
		if (!exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_145;
		System.out.println("查询LNPMaxNo出错，请稍后!");
		return null;
		if (result != null && !result.equals(""))
			break MISSING_BLOCK_LABEL_249;
		StringBuffer tSBql = new StringBuffer(128);
		tSBql.append("insert into lnpmaxno(notype, nolimit, maxno) values('");
		tSBql.append(cNoType);
		tSBql.append("', '");
		tSBql.append(cNoLimit);
		tSBql.append("', 1)");
		ExeSQL exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_243;
		System.out.println("CreateMaxNo 插入失败，请重试!");
		return null;
		tMaxNo = 1;
		break MISSING_BLOCK_LABEL_363;
		StringBuffer tSBql = new StringBuffer(128);
		tSBql.append("update lnpmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		ExeSQL exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_332;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		return null;
		try
		{
			tMaxNo = Integer.parseInt(result) + 1;
		}
		catch (Exception Ex)
		{
			try
			{
				conn.rollback();
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
				return null;
			}
			return null;
		}
		String tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", serialLen);
		String tReturn = tStr;
		return tReturn;
	}

	public String CreateMaxNo(String cNoType, int cNoLength)
	{
		Connection conn;
		String cNoLimit;
		int tMaxNo;
		StringBuffer tSBql = null;
		if (cNoType == null || cNoType.trim().length() <= 0 || cNoLength <= 0)
		{
			System.out.println("NoType长度错误或NoLength错误");
			return null;
		}
		cNoType = cNoType.toUpperCase();
		conn = DBConnPool.getConnection();
		if (conn == null)
		{
			System.out.println("CreateMaxNo : fail to get db connection");
			return null;
		}
		String tReturn = "";
		cNoLimit = "SN";
		if (cNoType.equals("COMMISIONSN") || cNoType.equals("GRPNO") || cNoType.equals("CUSTOMERNO") || cNoType.equals("SUGDATAITEMCODE") || cNoType.equals("SUGITEMCODE") || cNoType.equals("SUGMODELCODE") || cNoType.equals("SUGCODE"))
		{
			tSBql = new StringBuffer(128);
			tSBql.append("该类型流水号，请采用CreateMaxNo('");
			tSBql.append(cNoType);
			tSBql.append("','SN')方式生成");
			System.out.println(tSBql.toString());
			return null;
		}
		tMaxNo = 0;
		tReturn = cNoLimit;
		String result;
		conn.setAutoCommit(false);
		StringBuffer tSBql = new StringBuffer(128);
		tSBql.append("select MaxNo from LDMaxNo where notype='");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit='");
		tSBql.append(cNoLimit);
		tSBql.append("' for update");
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(tSBql.toString());
		if (result != null && !exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_294;
		System.out.println("CreateMaxNo 资源忙，请稍后!");
		conn.rollback();
		conn.close();
		return null;
label0:
		{
			StringBuffer tSBql;
			ExeSQL exeSQL;
			try
			{
				if (!result.equals(""))
					break MISSING_BLOCK_LABEL_402;
				tSBql = new StringBuffer(128);
				tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
				tSBql.append(cNoType);
				tSBql.append("', '");
				tSBql.append(cNoLimit);
				tSBql.append("', 1)");
				exeSQL = new ExeSQL(conn);
				if (exeSQL.execUpdateSQL(tSBql.toString()))
					break label0;
				System.out.println("CreateMaxNo 插入失败，请重试!");
				conn.rollback();
				conn.close();
			}
			catch (Exception Ex)
			{
				try
				{
					conn.rollback();
					conn.close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					return null;
				}
				return null;
			}
			return null;
		}
		tMaxNo = 1;
		break MISSING_BLOCK_LABEL_503;
		tSBql = new StringBuffer(128);
		tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_494;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = Integer.parseInt(result) + 1;
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_547;
		String tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", cNoLength);
		String tReturn = tStr.trim();
		return tReturn;
	}

	public static void main(String args[])
	{
		SysMaxNoMAPNP sysMaxNoHuaXia1 = new SysMaxNoMAPNP();
		System.out.println(sysMaxNoHuaXia1.CreateMaxNo("CONTNO", "86"));
		System.out.println(sysMaxNoHuaXia1.CreateMaxNo("CUSTOMERNO", "SN"));
		System.out.println(sysMaxNoHuaXia1.CreateMaxNo("GRPNO", "SN"));
		System.out.println(sysMaxNoHuaXia1.CreateMaxNo("TESTNO", 10));
		System.out.println(sysMaxNoHuaXia1.CreateMaxNo("SPNO_TJ", "SYS_PRT"));
	}
}
