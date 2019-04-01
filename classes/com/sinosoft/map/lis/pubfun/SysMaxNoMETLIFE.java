// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysMaxNoMETLIFE.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.VData;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			SysMaxNo, PubFun, PubFun1

public class SysMaxNoMETLIFE
	implements SysMaxNo
{

	public SysMaxNoMETLIFE()
	{
	}

	public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
	{
		return CreateMaxNo(cNoType, cNoLimit);
	}

	public synchronized String CreateMaxNo(String cNoType, String cNoLimit)
	{
		int serialLen;
		String tReturn;
		String tYear;
		String nextSeq;
		if (cNoType == null || cNoType.trim().length() <= 0 || cNoLimit == null)
		{
			System.out.println("NoType长度错误或者NoLimit为空");
			return null;
		}
		serialLen = 9;
		tReturn = "";
		String nNolimit = cNoLimit;
		tYear = PubFun.getCurrentDate().substring(0, 4);
		cNoType = cNoType.toUpperCase();
		System.out.println((new StringBuilder("-----------cNoType:")).append(cNoType).append("  cNoLimit:").append(cNoLimit).toString());
		if (cNoType.equals("ORDERNO"))
		{
			serialLen = 14;
			tReturn = "22";
		} else
		if (cNoType.equals("POLNO"))
		{
			serialLen = 14;
			tReturn = "33";
		} else
		if (cNoType.equals("CUSTOMERNO"))
		{
			serialLen = 16;
			tReturn = "55";
		} else
		if ("TRADENO".equals(cNoType))
		{
			serialLen = 14;
			tReturn = "66";
		} else
		if ("BNFNo".equals(cNoType))
		{
			serialLen = 15;
			tReturn = "77";
		} else
		if ("APPSERIALNO".equals(cNoType))
		{
			serialLen = 14;
			tReturn = "44";
		}
		nextSeq = null;
		ExeSQL tExeSQL;
		StringBuffer queryStrBuf;
		tExeSQL = new ExeSQL();
		StringBuffer seqSQL = new StringBuffer();
		seqSQL.append("select sequence_name from user_sequences where sequence_name='");
		seqSQL.append("SEQ_");
		seqSQL.append(cNoType);
		seqSQL.append("_");
		seqSQL.append(cNoLimit);
		seqSQL.append("'");
		String exist = tExeSQL.getOneValue(seqSQL.toString());
		queryStrBuf = new StringBuffer(128);
		queryStrBuf.append("select SEQ_");
		queryStrBuf.append(cNoType);
		queryStrBuf.append("_");
		queryStrBuf.append(cNoLimit);
		queryStrBuf.append(".nextval from dual");
		if (exist == null || "".equals(exist))
			break MISSING_BLOCK_LABEL_376;
		nextSeq = tExeSQL.getOneValue(queryStrBuf.toString());
		if (nextSeq != null && !"".equals(nextSeq))
			break MISSING_BLOCK_LABEL_505;
		System.out.println("查询数据库序列时出错！");
		return null;
		StringBuffer createStrBuf = new StringBuffer(128);
		createStrBuf.append("create sequence SEQ_");
		createStrBuf.append(cNoType);
		createStrBuf.append("_");
		createStrBuf.append(cNoLimit);
		createStrBuf.append(" minvalue 1 maxvalue 999999999999 start with 1 increment by 1 nocache");
		boolean createFlag = tExeSQL.execUpdateSQL(createStrBuf.toString());
		if (!createFlag)
			break MISSING_BLOCK_LABEL_480;
		nextSeq = tExeSQL.getOneValue(queryStrBuf.toString());
		if (nextSeq != null && !"".equals(nextSeq))
			break MISSING_BLOCK_LABEL_505;
		System.out.println("查询数据库序列时出错！");
		return null;
		System.out.println("数据库创建序列对象出错！");
		return null;
		Exception ex;
		ex;
		System.out.println("数据库创建序列或查询序列对象过程中发生异常！");
		ex.printStackTrace();
		String tStr = new String(nextSeq);
		tStr = PubFun.LCh(tStr, "0", serialLen);
		if (cNoLimit.equals("SN"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append(tYear).append(tStr.trim()).toString();
		return tReturn;
	}

	public String GetAccountId(String tStr)
	{
		String tMod = "109876532";
		String tStr1 = "";
		String tStr2 = "";
		String tReturn = "";
		tStr1 = PubFun.LCh(tStr, "0", 9);
		double j = 0.0D;
		int k = 0;
		for (int i = 1; i <= 9; i++)
			j += (double)Integer.parseInt(tStr1.substring(i - 1, i)) * Math.pow(2D, i - 1);

		k = (int)Math.floor(j) % 9;
		k++;
		tStr2 = (new StringBuilder(String.valueOf(tStr1.trim()))).append(tMod.substring(k - 1, k)).toString();
		tReturn = tStr2;
		return tReturn;
	}

	public String CreateMaxNo(String cNoType, int cNoLength)
	{
		String cNoLimit;
		String nextSeq;
		if (cNoType == null || cNoType.trim().length() <= 0 || cNoLength <= 0)
		{
			System.out.println("NoType长度错误或NoLength错误");
			return null;
		}
		cNoType = cNoType.toUpperCase();
		String tReturn = "";
		cNoLimit = "SN";
		nextSeq = null;
		ExeSQL tExeSQL;
		StringBuffer queryStrBuf;
		tExeSQL = new ExeSQL();
		StringBuffer seqSQL = new StringBuffer();
		seqSQL.append("select sequence_name from user_sequences where sequence_name='");
		seqSQL.append("SEQ_");
		seqSQL.append(cNoType);
		seqSQL.append("_");
		seqSQL.append(cNoLimit);
		seqSQL.append("'");
		String exist = tExeSQL.getOneValue(seqSQL.toString());
		queryStrBuf = new StringBuffer(128);
		queryStrBuf.append("select SEQ_");
		queryStrBuf.append(cNoType);
		queryStrBuf.append("_");
		queryStrBuf.append(cNoLimit);
		queryStrBuf.append(".nextval from dual");
		if (exist == null || "".equals(exist))
			break MISSING_BLOCK_LABEL_223;
		nextSeq = tExeSQL.getOneValue(queryStrBuf.toString());
		if (nextSeq != null && !"".equals(nextSeq))
			break MISSING_BLOCK_LABEL_353;
		System.out.println("查询数据库序列时出错！");
		return null;
		StringBuffer createStrBuf = new StringBuffer(128);
		createStrBuf.append("create sequence SEQ_");
		createStrBuf.append(cNoType);
		createStrBuf.append("_");
		createStrBuf.append(cNoLimit);
		createStrBuf.append(" minvalue 1 maxvalue 999999999999 start with 1 increment by 1 nocache");
		boolean createFlag = tExeSQL.execUpdateSQL(createStrBuf.toString());
		if (!createFlag)
			break MISSING_BLOCK_LABEL_328;
		nextSeq = tExeSQL.getOneValue(queryStrBuf.toString());
		if (nextSeq != null && !"".equals(nextSeq))
			break MISSING_BLOCK_LABEL_353;
		System.out.println("查询数据库序列时出错！");
		return null;
		System.out.println("数据库创建序列对象出错！");
		return null;
		Exception ex;
		ex;
		System.out.println("数据库创建序列或查询序列对象过程中发生异常！");
		ex.printStackTrace();
		String tStr = new String(nextSeq);
		tStr = PubFun.LCh(tStr, "0", cNoLength);
		String tReturn = tStr.trim();
		return tReturn;
	}

	public static void main(String args[])
	{
		String strLimit = PubFun.getNoLimit("860401");
		String strRiskAssessNo = PubFun1.CreateMaxNo("ORDERNO", "SN");
		System.out.println((new StringBuilder("=============RiskAssessNo:")).append(strRiskAssessNo).append("==============").toString());
	}
}
