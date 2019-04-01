// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysMaxNoHuaXia.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.Connection;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			SysMaxNo, PubFun, PubFun1

public class SysMaxNoHuaXia
	implements SysMaxNo
{

	public SysMaxNoHuaXia()
	{
	}

	public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
	{
		return CreateMaxNo(cNoType, cNoLimit);
	}

	public String CreateMaxNo(String cNoType, String cNoLimit)
	{
		int serialLen;
		String tReturn;
		String tYear;
		String prtBatch;
		Connection conn;
		int tMaxNo;
		if (cNoType == null || cNoType.trim().length() <= 0 || cNoLimit == null)
		{
			System.out.println("NoType长度错误或者NoLimit为空");
			return null;
		}
		serialLen = 9;
		if (cNoType != null && cNoType.trim().toUpperCase().equals("GRPCONTNO"))
			serialLen = 7;
		tReturn = null;
		tYear = PubFun.getCurrentDate().substring(0, 4);
		cNoType = cNoType.toUpperCase();
		prtBatch = "01";
		if (cNoLimit.trim().toUpperCase().equals("SN"))
		{
			if (cNoType.equals("COMMISIONSN") || cNoType.equals("CUSTOMERNO") || cNoType.equals("SUGDATAITEMCODE") || cNoType.equals("SUGITEMCODE") || cNoType.equals("SUGMODELCODE") || cNoType.equals("SUGCODE"))
				serialLen = 9;
			else
			if (cNoType.equals("GRPNO"))
			{
				serialLen = 8;
			} else
			{
				System.out.println("错误的NoLimit");
				return null;
			}
		} else
		if (cNoLimit.trim().toUpperCase().equals("SYS_PRT"))
			serialLen = 8;
		if (cNoType.equals("AIRPOLNO"))
			serialLen = 7;
		if (cNoType.equals("AGENTCODE") || cNoType.equals("MANAGECOM"))
			serialLen = 4;
		tReturn = cNoLimit.trim();
		if (cNoType.equals("PROPOSALNO"))
			tReturn = "11";
		else
		if (cNoType.equals("GRPPROPOSALNO"))
			tReturn = "12";
		else
		if (cNoType.equals("PROPOSALCONTNO"))
			tReturn = "13";
		else
		if (cNoType.equals("PROGRPCONTNO"))
			tReturn = "14";
		else
		if (cNoType.equals("POLNO"))
			tReturn = "21";
		else
		if (cNoType.equals("GRPPOLNO"))
			tReturn = "22";
		else
		if (cNoType.equals("CONTNO"))
			tReturn = "88";
		else
		if (cNoType.equals("GRPCONTNO"))
			tReturn = "99";
		else
		if (cNoType.equals("PAYNOTICENO"))
			tReturn = "31";
		else
		if (cNoType.equals("PAYNO"))
			tReturn = "32";
		else
		if (cNoType.equals("GETNOTICENO"))
			tReturn = "36";
		else
		if (cNoType.equals("GETNO"))
			tReturn = "37";
		else
		if (cNoType.equals("EDORAPPNO"))
			tReturn = "41";
		else
		if (cNoType.equals("EDORNO"))
			tReturn = "42";
		else
		if (cNoType.equals("EDORGRPAPPNO"))
			tReturn = "43";
		else
		if (cNoType.equals("EDORGRPNO"))
			tReturn = "44";
		else
		if (cNoType.equals("RPTNO"))
			tReturn = "50";
		else
		if (cNoType.equals("RGTNO"))
			tReturn = "51";
		else
		if (cNoType.equals("CLMNO"))
			tReturn = "52";
		else
		if (cNoType.equals("DECLINENO"))
			tReturn = "53";
		else
		if (cNoType.equals("SUBRPTNO"))
			tReturn = "54";
		else
		if (cNoType.equals("CASENO"))
			tReturn = "55";
		else
		if (cNoType.equals("PROTOCOLNO"))
			tReturn = "71";
		else
		if (cNoType.equals("PRTNO"))
			tReturn = "80";
		else
		if (cNoType.equals("PRTSEQNO"))
			tReturn = "81";
		else
		if (cNoType.equals("PRTSEQ2NO"))
			tReturn = "82";
		else
		if (cNoType.equals("TAKEBACKNO"))
			tReturn = "61";
		else
		if (cNoType.equals("BATCHNO"))
			tReturn = "62";
		else
		if (cNoType.equals("VOUCHERIDNO"))
			tReturn = "63";
		else
		if (cNoType.equals("WAGENO"))
			tReturn = "90";
		else
		if (cNoType.equals("SERIALNO"))
			tReturn = "98";
		else
		if (cNoType.equals("SPNO_TJ"))
			tReturn = "1101";
		else
		if (cNoType.equals("SPNO_TJCB"))
			tReturn = "1102";
		else
		if (cNoType.equals("SPNO_MJ"))
			tReturn = "1103";
		else
		if (cNoType.equals("SPNO_MJCB"))
			tReturn = "1104";
		else
		if (cNoType.equals("SPNO_HB"))
			tReturn = "1105";
		else
		if (cNoType.equals("SPNO_HBCB"))
			tReturn = "1106";
		else
		if (cNoType.equals("SPNO_KHWTJ"))
			tReturn = "1107";
		else
		if (cNoType.equals("SPNO_KHWTJCB"))
			tReturn = "1108";
		else
		if (cNoType.equals("SPNO_YWYWTJ"))
			tReturn = "1109";
		else
		if (cNoType.equals("SPNO_YWYWTJCB"))
			tReturn = "1110";
		else
		if (cNoType.equals("SPNO_SQJF"))
			tReturn = "1111";
		else
		if (cNoType.equals("SPNO_JFCB"))
			tReturn = "1112";
		else
		if (cNoType.equals("SPNO_XJTB"))
			tReturn = "1113";
		else
		if (cNoType.equals("SPNO_YQTB"))
			tReturn = "1114";
		else
		if (cNoType.equals("SPNO_CXSQ"))
			tReturn = "1115";
		else
		if (cNoType.equals("SPNO_XQYTF"))
			tReturn = "1116";
		if (tReturn.length() == 10)
			tReturn = "00";
		conn = DBConnPool.getConnection();
		if (conn == null)
		{
			System.out.println("CreateMaxNo : fail to get db connection");
			return tReturn;
		}
		tMaxNo = 0;
		if (!cNoLimit.trim().toUpperCase().equals("SN") && !cNoLimit.trim().toUpperCase().equals("SYS_PRT"))
			cNoLimit = (new StringBuilder(String.valueOf(tYear))).append(tReturn).toString();
		String result;
		conn.setAutoCommit(false);
		StringBuffer tSBql = new StringBuffer(128);
		tSBql.append("select MaxNo from LDMaxNo where notype='");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit='");
		tSBql.append(cNoLimit);
		tSBql.append("' for update");
		if ("ORACLE".compareTo("ORACLE") == 0)
			tSBql.append(" nowait");
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(tSBql.toString());
		if (!exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_1228;
		System.out.println("查询LDMaxNo出错，请稍后!");
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
					break MISSING_BLOCK_LABEL_1352;
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
		break MISSING_BLOCK_LABEL_1463;
		tSBql = new StringBuffer(128);
		tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_1454;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = Integer.parseInt(result) + 1;
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_1507;
		String tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", serialLen);
		String tCheck = "0";
		if (cNoLimit.equals("SN"))
			tReturn = (new StringBuilder(String.valueOf(tStr.trim()))).append("0").toString();
		else
		if (cNoLimit.equals("SYS_PRT"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append(prtBatch).append(tStr.trim()).toString();
		else
		if (cNoType != null && cNoType.toUpperCase().equals("GRPCONTNO"))
			tReturn = (new StringBuilder("5")).append(tStr.trim()).toString();
		else
			tReturn = (new StringBuilder(String.valueOf(tYear))).append(tStr.trim()).append(tCheck).append(tReturn).toString();
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
		if ("ORACLE".compareTo("ORACLE") == 0)
			tSBql.append(" nowait");
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(tSBql.toString());
		if (result != null && !exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_323;
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
					break MISSING_BLOCK_LABEL_436;
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
		break MISSING_BLOCK_LABEL_541;
		tSBql = new StringBuffer(128);
		tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_532;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = Integer.parseInt(result) + 1;
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_585;
		String tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", cNoLength);
		String tReturn = tStr.trim();
		return tReturn;
	}

	public static void main(String args[])
	{
		SysMaxNoHuaXia sysMaxNoHuaXia1 = new SysMaxNoHuaXia();
		String tLimit = PubFun.getNoLimit("86");
		String prtSeqNo = PubFun1.CreateMaxNo("PRTNO", tLimit);
		System.out.println((new StringBuilder("\n\n\n prtSeqNo = ")).append(prtSeqNo).append("\n\n\n").toString());
	}
}
