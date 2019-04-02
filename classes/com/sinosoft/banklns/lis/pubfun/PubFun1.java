// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PubFun1.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.lis.db.LNPCalModeDB;
import com.sinosoft.banklns.lis.db.LNPMaxNoDB;
import com.sinosoft.banklns.lis.schema.LNPMaxNoSchema;
import com.sinosoft.banklns.lis.vschema.LNPMaxNoSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

// Referenced classes of package com.sinosoft.banklns.lis.pubfun:
//			PubFun, Calculator

public class PubFun1
{

	public PubFun1()
	{
	}

	public static void main(String args[])
	{
		PubFun1 tPF1 = new PubFun1();
		String tUpGroup = "0000000003";
	}

	public static synchronized String CreateMaxNo(String cNoType, int cNoLength)
	{
		String cNoLimit;
		Connection conn;
		boolean flag;
		LNPMaxNoDB tDB;
		LNPMaxNoSet tSet;
		int tMaxNo;
		String tReturn = "";
		cNoLimit = "SN";
		conn = DBConnPool.getConnection();
		flag = true;
		try
		{
			flag = conn.getAutoCommit();
		}
		catch (Exception de)
		{
			de.printStackTrace();
		}
		if (conn == null)
		{
			System.out.println("CreateMaxNo : fail to get db connection");
			return tReturn;
		}
		cNoType = cNoType.toUpperCase();
		if (cNoType.trim().length() <= 0 || cNoLength <= 0)
			return tReturn;
		cNoType = cNoType.toUpperCase();
		tDB = new LNPMaxNoDB(conn);
		LNPMaxNoSchema tSch = new LNPMaxNoSchema();
		tSet = new LNPMaxNoSet();
		tMaxNo = 0;
		tReturn = cNoLimit.trim();
		tSch.setNoType(cNoType);
		tSch.setNoLimit(cNoLimit);
		tDB.setSchema(tSch);
		conn.setAutoCommit(false);
		tSet = tDB.query();
		if (tSet.size() > 0)
			break MISSING_BLOCK_LABEL_252;
		tMaxNo = 1;
		tDB.setNoType(cNoType);
		tDB.setNoLimit(cNoLimit);
		tDB.setMaxNo(tMaxNo);
		tDB.insert();
		if (!tDB.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_242;
		conn.rollback();
		System.out.println(tDB.mErrors.getFirstError());
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		return "";
		conn.commit();
		break MISSING_BLOCK_LABEL_422;
		tMaxNo = tSet.get(1).getMaxNo();
		tMaxNo++;
		tDB.setNoType(cNoType);
		tDB.setNoLimit(cNoLimit);
		tDB.setMaxNo(tMaxNo);
		tDB.update();
		if (!tDB.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_338;
		conn.rollback();
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		return "";
		try
		{
			conn.commit();
			break MISSING_BLOCK_LABEL_422;
		}
		catch (Exception Ex)
		{
			try
			{
				conn.rollback();
			}
			catch (Exception exception) { }
		}
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		break MISSING_BLOCK_LABEL_448;
		Exception exception1;
		exception1;
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		throw exception1;
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		String tStr = "";
		tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", cNoLength);
		String tReturn = tStr.trim();
		return tReturn;
	}

	public static String CreateMaxNo(String cNoType, String cNoLimit)
	{
		int serialLen;
		String tReturn;
		Connection conn;
		boolean flag;
		LNPMaxNoDB tDB;
		LNPMaxNoSet tSet;
		int tMaxNo;
		serialLen = 7;
		tReturn = "";
		conn = DBConnPool.getConnection();
		flag = true;
		try
		{
			flag = conn.getAutoCommit();
		}
		catch (Exception de)
		{
			de.printStackTrace();
		}
		if (conn == null)
		{
			System.out.println("CreateMaxNo : fail to get db connection");
			return tReturn;
		}
		cNoType = cNoType.toUpperCase();
		if (cNoType.trim().length() <= 0)
			return tReturn;
		if (cNoLimit.trim().toUpperCase().equals("SN"))
			if (cNoType.equals("COMMISIONSN") || cNoType.equals("AGENTCODE") || cNoType.equals("GRPNO") || cNoType.equals("CUSTOMERNO") || cNoType.equals("SUGDATAITEMCODE") || cNoType.equals("SUGITEMCODE") || cNoType.equals("SUGMODELCODE") || cNoType.equals("SUGCODE") || cNoType.equals("PERSUGCODE"))
			{
				serialLen = 10;
			} else
			{
				System.out.println("错误的NoLimit");
				return tReturn;
			}
		cNoType = cNoType.toUpperCase();
		tDB = new LNPMaxNoDB(conn);
		LNPMaxNoSchema tSch = new LNPMaxNoSchema();
		tSet = new LNPMaxNoSet();
		tMaxNo = 0;
		tReturn = cNoLimit.trim();
		if (cNoType.equals("PROPOSALNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("11").toString();
		if (cNoType.equals("GRPPROPOSALNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("12").toString();
		if (cNoType.equals("CONTPROPOSALNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("13").toString();
		if (cNoType.equals("POLNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("21").toString();
		if (cNoType.equals("GRPPOLNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("22").toString();
		if (cNoType.equals("CONTNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("23").toString();
		if (cNoType.equals("PAYNOTICENO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("31").toString();
		if (cNoType.equals("PAYNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("32").toString();
		if (cNoType.equals("GETNOTICENO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("36").toString();
		if (cNoType.equals("GETNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("37").toString();
		if (cNoType.equals("EDORAPPNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("41").toString();
		if (cNoType.equals("EDORNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("42").toString();
		if (cNoType.equals("EDORGRPNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("43").toString();
		if (cNoType.equals("RPTNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("50").toString();
		if (cNoType.equals("RGTNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("51").toString();
		if (cNoType.equals("CLMNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("52").toString();
		if (cNoType.equals("DECLINENO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("53").toString();
		if (cNoType.equals("SUBRPTNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("54").toString();
		if (cNoType.equals("CASENO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("55").toString();
		if (cNoType.equals("PROTOCOLNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("71").toString();
		if (cNoType.equals("PRTNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("80").toString();
		if (cNoType.equals("PRTSEQNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("81").toString();
		if (cNoType.equals("PRTSEQ2NO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("82").toString();
		if (cNoType.equals("TAKEBACKNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("61").toString();
		if (cNoType.equals("BATCHNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("62").toString();
		if (cNoType.equals("WAGENO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("90").toString();
		if (cNoType.equals("SERIALNO"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("98").toString();
		if (tReturn.length() == 10)
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append("99").toString();
		cNoLimit = tReturn;
		tSch.setNoType(cNoType);
		tSch.setNoLimit(cNoLimit);
		tDB.setSchema(tSch);
		tSet = tDB.query();
		if (tSet.size() > 0)
			break MISSING_BLOCK_LABEL_1202;
		tMaxNo = 1;
		tDB.setNoType(cNoType);
		tDB.setNoLimit(cNoLimit);
		tDB.setMaxNo(tMaxNo);
		tDB.insert();
		if (!tDB.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_1192;
		conn.rollback();
		System.out.println(tDB.mErrors.getFirstError());
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		return "";
		conn.commit();
		break MISSING_BLOCK_LABEL_1379;
		tMaxNo = tSet.get(1).getMaxNo();
		tMaxNo++;
		tDB.setNoType(cNoType);
		tDB.setNoLimit(cNoLimit);
		tDB.setMaxNo(tMaxNo);
		tDB.update();
		if (!tDB.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_1288;
		conn.rollback();
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		return "";
		try
		{
			conn.commit();
			break MISSING_BLOCK_LABEL_1379;
		}
		catch (Exception Ex)
		{
			try
			{
				conn.rollback();
				conn.close();
			}
			catch (Exception exception) { }
		}
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		break MISSING_BLOCK_LABEL_1405;
		Exception exception1;
		exception1;
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		throw exception1;
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		String len = Integer.toString(tMaxNo);
		if (len.length() < 10)
			len = PubFun.LCh(len, "0", 10);
		String tStr = "";
		tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", serialLen);
		if (cNoType.equals("CUSNO"))
		{
			System.out.println((new StringBuilder("len=")).append(len).toString());
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append(len).toString();
			System.out.println((new StringBuilder("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq=")).append(tReturn).toString());
		} else
		if (tReturn.equals("SN"))
			tReturn = tStr.trim();
		else
			tReturn = (new StringBuilder(String.valueOf(tReturn.trim()))).append(tStr.trim()).toString();
		return tReturn;
	}

	public static String CreateMaxNo(String cNoType, String cNoLimit, int cNoLength)
	{
		Connection conn;
		boolean flag;
		LNPMaxNoDB tDB;
		LNPMaxNoSet tSet;
		int tMaxNo;
		long tMaxLenNo;
		String tReturn = "";
		conn = DBConnPool.getConnection();
		flag = true;
		try
		{
			flag = conn.getAutoCommit();
		}
		catch (Exception de)
		{
			de.printStackTrace();
		}
		if (conn == null)
		{
			System.out.println("CreateMaxNo : fail to get db connection");
			return tReturn;
		}
		cNoType = cNoType.toUpperCase();
		if (cNoType.trim().length() <= 0 || cNoLength <= 0)
			return tReturn;
		cNoType = cNoType.toUpperCase();
		tDB = new LNPMaxNoDB(conn);
		LNPMaxNoSchema tSch = new LNPMaxNoSchema();
		tSet = new LNPMaxNoSet();
		tMaxNo = 0;
		tMaxLenNo = getMaxLenNo(cNoLength);
		tReturn = cNoLimit.trim();
		tSch.setNoType(cNoType);
		tSch.setNoLimit(cNoLimit);
		tDB.setSchema(tSch);
		tSet = tDB.query();
		if (tSet.size() > 0)
			break MISSING_BLOCK_LABEL_247;
		tMaxNo = 1;
		tDB.setNoType(cNoType);
		tDB.setNoLimit(cNoLimit);
		tDB.setMaxNo(tMaxNo);
		tDB.insert();
		if (!tDB.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_237;
		conn.rollback();
		System.out.println(tDB.mErrors.getFirstError());
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		return "";
		conn.commit();
		break MISSING_BLOCK_LABEL_429;
		tMaxNo = tSet.get(1).getMaxNo();
		if ((long)(++tMaxNo) == tMaxLenNo)
			tMaxNo = 1;
		tDB.setMaxNo(tMaxNo);
		tDB.setNoType(cNoType);
		tDB.setNoLimit(cNoLimit);
		tDB.update();
		if (!tDB.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_345;
		conn.rollback();
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		return "";
		try
		{
			conn.commit();
			break MISSING_BLOCK_LABEL_429;
		}
		catch (Exception Ex)
		{
			try
			{
				conn.rollback();
			}
			catch (Exception exception) { }
		}
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		break MISSING_BLOCK_LABEL_455;
		Exception exception1;
		exception1;
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		throw exception1;
		try
		{
			conn.setAutoCommit(flag);
			conn.close();
		}
		catch (Exception wew)
		{
			wew.printStackTrace();
		}
		String tStr = "";
		tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", cNoLength);
		String tReturn = tStr.trim();
		return tReturn;
	}

	public static String getSQL(String strSql, Calculator calculator)
		throws Exception
	{
		LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
		String strSQL = strSql.replace('\'', '@');
		strSQL = (new StringBuilder("select ''")).append(strSQL).append("'' from dual").toString();
		tLNPCalModeDB.setCalCode("XXX");
		tLNPCalModeDB.setRiskCode("0");
		tLNPCalModeDB.setType("F");
		tLNPCalModeDB.setCalSQL(strSQL);
		if (!tLNPCalModeDB.update())
			throw new Exception("设置计算公式时出错");
		calculator.setCalCode("XXX");
		if (strSQL.equals(""))
			throw new Exception("解析SQL语句时出错");
		else
			return strSQL.replace('@', '\'');
	}

	public static String[] calFLDate(String tDate)
	{
		String MonDate[] = new String[2];
		String asql = (new StringBuilder("select startdate,enddate from LAStatSegment where stattype='5' and startdate<='")).append(tDate).append("' and enddate>='").append(tDate).append("'").toString();
		ExeSQL aExeSQL = new ExeSQL();
		SSRS aSSRS = new SSRS();
		aSSRS = aExeSQL.execSQL(asql);
		MonDate[0] = aSSRS.GetText(1, 1);
		MonDate[1] = aSSRS.GetText(1, 2);
		return MonDate;
	}

	public static String getString(String key, ResourceBundle Bundle)
	{
		String value = null;
		try
		{
			value = getResourceBundle(Bundle).getString(key);
		}
		catch (MissingResourceException e)
		{
			System.out.println((new StringBuilder("java.util.MissingResourceException: Couldn't find value for: ")).append(key).toString());
		}
		if (value == null)
			value = (new StringBuilder("Could not find resource: ")).append(key).append("  ").toString();
		return value;
	}

	private static ResourceBundle getResourceBundle(ResourceBundle bundle)
	{
		if (bundle == null)
			bundle = ResourceBundle.getBundle("resources.suggest");
		return bundle;
	}

	public static long getMaxLenNo(int len)
	{
		String no = "1";
		for (int i = 0; i < len; i++)
			no = (new StringBuilder(String.valueOf(no))).append("0").toString();

		long MaxLenNo = Long.parseLong(no);
		return MaxLenNo - 1L;
	}
}
