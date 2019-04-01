// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysMaxNoMap.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.math.BigInteger;
import java.sql.SQLException;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			PubFun

public class SysMaxNoMap
{

	private String noType;
	private int noLength;
	private int step;
	private String maxNos[];
	private int index;
	private int tryTimes;

	public SysMaxNoMap(String noType, int noLength)
	{
		this(noType, noLength, 10);
	}

	public SysMaxNoMap(String noType, int noLength, int step)
	{
		maxNos = null;
		index = 0;
		tryTimes = 0;
		if (noType == null || noType.trim().equals(""))
			throw new RuntimeException((new StringBuilder("MaxNoFactory的构造器只接受有意义的noType,目前传入的参数noType=")).append(noType).toString());
		if (step <= 0)
			throw new RuntimeException((new StringBuilder("MaxNoFactory的构造器只接受step大于0的参数,目前传入的参数step=")).append(step).toString());
		if (noLength < 10)
		{
			throw new RuntimeException((new StringBuilder("MaxNoFactory的构造器只接受noLength大于10的参数,目前传入的参数noLength=")).append(noLength).toString());
		} else
		{
			this.noType = noType.toUpperCase();
			this.noLength = noLength;
			this.step = step;
			maxNos = new String[step];
			initMaxNos();
			return;
		}
	}

	private void initMaxNos()
	{
		if (maxNos == null)
			maxNos = new String[step];
		for (int i = 0; i < step; i++)
			maxNos[i] = "-1";

		index = 0;
	}

	public String next()
	{
		String result;
		DBConn conn;
		result = null;
		if (index < step && !maxNos[index].equals("-1"))
		{
			System.out.println("从缓存中读取最大值");
			return PubFun.LCh(nextData(), "0", noLength);
		}
		conn = DBConnPool.getConnection();
		try
		{
			result = next(conn);
			break MISSING_BLOCK_LABEL_106;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		break MISSING_BLOCK_LABEL_120;
		Exception exception;
		exception;
		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		throw exception;
		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public String next(DBConn conn)
	{
		StringBuffer maxStr = new StringBuffer();
		for (int i = 0; i < noLength; i++)
			maxStr.append("9");

		String tmp = nextInt(conn);
		if (tmp.equals(""))
			return "";
		if ((new BigInteger(tmp)).compareTo(new BigInteger(maxStr.toString())) > 0)
			throw new RuntimeException((new StringBuilder("从数据库中读出的MaxNo=")).append(tmp).append("大于传入的参数noLength=").append(noLength).append("指定的范围").toString());
		else
			return PubFun.LCh(tmp, "0", noLength);
	}

	private String nextInt(DBConn conn)
	{
		String cNoLimit = "SN";
		if (index < step && !maxNos[index].equals("-1"))
			return nextData();
		initMaxNos();
		try
		{
			conn.setAutoCommit(false);
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		String result = queryDB(conn, cNoLimit);
		if (result == null)
		{
			System.out.println("CreateMaxNo 查询失败!");
			return "";
		}
		if (result.trim().equals(""))
		{
			if (insertDB(conn, cNoLimit))
			{
				try
				{
					conn.commit();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
					return "";
				}
				comData("0");
				return nextData();
			}
			System.out.println("CreateMaxNo 插入失败，请重试!");
			try
			{
				conn.rollback();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return "";
		}
		if (updateDB(conn, cNoLimit, result))
		{
			try
			{
				conn.commit();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				return "";
			}
			tryTimes = 0;
			comData(result);
			return nextData();
		}
		tryTimes++;
		if (tryTimes > 5)
		{
			tryTimes = 0;
			System.out.println("5尝试修改mmaxno表均失败，不再尝试");
			try
			{
				conn.rollback();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return "";
		} else
		{
			System.out.println((new StringBuilder("第")).append(tryTimes).append("尝试修改mmaxno表失败").toString());
			return nextInt(conn);
		}
	}

	private String queryDB(DBConn conn, String cNoLimit)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("select maxno from mmaxno where notype='");
		sql.append(noType);
		sql.append("' and nolimit='");
		sql.append(cNoLimit);
		sql.append("'");
		ExeSQL exeSQL = new ExeSQL(conn);
		String result = exeSQL.getOneValue(sql.toString());
		sql = null;
		if (exeSQL.mErrors.needDealError())
		{
			System.out.println("CreateMaxNo 查询失败!");
			return null;
		}
		if (result == null || result.trim().equals(""))
			return "";
		else
			return result;
	}

	private boolean updateDB(DBConn conn, String cNoLimit, String result)
	{
		StringBuffer tSBql = new StringBuffer(128);
		tSBql.append("update mmaxno set maxno = maxno + ");
		tSBql.append(step);
		tSBql.append(" where notype = '");
		tSBql.append(noType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("' and maxno=");
		tSBql.append(result);
		ExeSQL exeSQL = new ExeSQL(conn);
		if (!exeSQL.execUpdateSQL(tSBql.toString()))
			return false;
		try
		{
			conn.commit();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		for (int i = 0; i < step; i++)
			maxNos[i] = (new BigInteger(result)).add(new BigInteger(String.valueOf(i))).toString();

		return true;
	}

	private boolean insertDB(DBConn conn, String cNoLimit)
	{
		StringBuffer tSBql = new StringBuffer(128);
		tSBql.append("insert into mmaxno(notype, nolimit, maxno) values('");
		tSBql.append(noType);
		tSBql.append("', '");
		tSBql.append(cNoLimit);
		tSBql.append("', ");
		tSBql.append(step);
		tSBql.append(")");
		ExeSQL exeSQL = new ExeSQL(conn);
		return exeSQL.execUpdateSQL(tSBql.toString());
	}

	private String nextData()
	{
		return maxNos[index++];
	}

	private void comData(String result)
	{
		index = 0;
		for (int i = 0; i < step; i++)
			maxNos[i] = (new BigInteger(result)).add(new BigInteger(String.valueOf(i + 1))).toString();

	}

	public static void main(String args1[])
		throws SQLException
	{
	}
}
