// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysMaxNoNCL.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.math.BigInteger;
import java.sql.Connection;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			SysMaxNo, PubFun, PubFun1

public class SysMaxNoNCL
	implements SysMaxNo
{

	public SysMaxNoNCL()
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
		Connection conn;
		int tMaxNo;
		if (cNoType == null || cNoType.trim().length() <= 0 || cNoLimit == null)
		{
			System.out.println("NoType长度错误或者NoLimit为空");
			return null;
		}
		serialLen = 10;
		tReturn = null;
		cNoType = cNoType.toUpperCase();
		if (cNoLimit.trim().toUpperCase().equals("SN"))
			if (cNoType.equals("COMMISIONSN") || cNoType.equals("GRPNO") || cNoType.equals("CUSTOMERNO") || cNoType.equals("SUGDATAITEMCODE") || cNoType.equals("SUGITEMCODE") || cNoType.equals("SUGMODELCODE") || cNoType.equals("SUGCODE") || cNoType.equals("ACCNO") || cNoType.equals("RPTONLYNO"))
			{
				serialLen = 9;
			} else
			{
				System.out.println("错误的NoLimit");
				return null;
			}
		if (cNoType.equals("AIRPOLNO"))
			serialLen = 6;
		if (cNoType.equals("AGENTCODE") || cNoType.equals("MANAGECOM"))
			serialLen = 4;
		tReturn = cNoLimit.trim();
		String tCom = "";
		if (tReturn.length() >= 4)
		{
			tCom = tReturn.substring(2, 4);
			tCom = (new StringBuilder("0")).append(tCom).toString();
			tReturn = tReturn.substring(0, 4);
		}
		if (cNoType.equals("PROPOSALNO"))
			tReturn = (new StringBuilder("11")).append(tCom).toString();
		else
		if (cNoType.equals("GRPPROPOSALNO"))
			tReturn = (new StringBuilder("12")).append(tCom).toString();
		else
		if (cNoType.equals("PROPOSALCONTNO"))
			tReturn = (new StringBuilder("13")).append(tCom).toString();
		else
		if (cNoType.equals("PROGRPCONTNO"))
			tReturn = (new StringBuilder("14")).append(tCom).toString();
		else
		if (cNoType.equals("POLNO"))
			tReturn = (new StringBuilder("21")).append(tCom).toString();
		else
		if (cNoType.equals("GRPPOLNO"))
			tReturn = (new StringBuilder("22")).append(tCom).toString();
		else
		if (cNoType.equals("CONTNO"))
			tReturn = "0";
		else
		if (cNoType.equals("GRPCONTNO"))
			tReturn = (new StringBuilder("24")).append(tCom).toString();
		else
		if (cNoType.equals("PAYNOTICENO"))
		{
			tReturn = tCom.substring(1);
			serialLen = 8;
		} else
		if (cNoType.equals("PAYNO"))
			tReturn = (new StringBuilder("32")).append(tCom).toString();
		else
		if (cNoType.equals("GETNOTICENO"))
			tReturn = (new StringBuilder("36")).append(tCom).toString();
		else
		if (cNoType.equals("GETNO"))
			tReturn = (new StringBuilder("37")).append(tCom).toString();
		else
		if (cNoType.equals("EDORACCEPTNO"))
		{
			String tStr = PubFun.getCurrentDate();
			tReturn = (new StringBuilder("61")).append(tStr.substring(0, 4)).append(tStr.substring(5, 7)).append(tStr.substring(8, 10)).toString();
			serialLen = 6;
		} else
		if (cNoType.equals("EDORAPPNO"))
		{
			String tStr = PubFun.getCurrentDate();
			tReturn = (new StringBuilder("60")).append(tStr.substring(0, 4)).append(tStr.substring(5, 7)).append(tStr.substring(8, 10)).toString();
			serialLen = 6;
		} else
		if (cNoType.equals("EDORNO"))
		{
			String tStr = PubFun.getCurrentDate();
			tReturn = (new StringBuilder("60")).append(tStr.substring(0, 4)).append(tStr.substring(5, 7)).append(tStr.substring(8, 10)).toString();
			serialLen = 6;
		} else
		if (cNoType.equals("EDORGRPAPPNO"))
		{
			String tStr = PubFun.getCurrentDate();
			tReturn = (new StringBuilder("63")).append(tStr.substring(0, 4)).append(tStr.substring(5, 7)).append(tStr.substring(8, 10)).toString();
			serialLen = 6;
		} else
		if (cNoType.equals("EDORGRPNO"))
		{
			String tStr = PubFun.getCurrentDate();
			tReturn = (new StringBuilder("63")).append(tStr.substring(0, 4)).append(tStr.substring(5, 7)).append(tStr.substring(8, 10)).toString();
			serialLen = 6;
		} else
		if (cNoType.equals("RPTNO"))
			tReturn = (new StringBuilder("50")).append(tCom).toString();
		else
		if (cNoType.equals("RGTNO"))
			tReturn = (new StringBuilder("51")).append(tCom).toString();
		else
		if (cNoType.equals("CLMNO"))
			tReturn = (new StringBuilder("52")).append(tCom).toString();
		else
		if (cNoType.equals("DECLINENO"))
			tReturn = (new StringBuilder("53")).append(tCom).toString();
		else
		if (cNoType.equals("SUBRPTNO"))
			tReturn = (new StringBuilder("54")).append(tCom).toString();
		else
		if (cNoType.equals("CASENO"))
			tReturn = (new StringBuilder("55")).append(tCom).toString();
		else
		if (cNoType.equals("PROTOCOLNO"))
			tReturn = (new StringBuilder("71")).append(tCom).toString();
		else
		if (cNoType.equals("PRTNO"))
			tReturn = (new StringBuilder("80")).append(tCom).toString();
		else
		if (cNoType.equals("PRTSEQNO"))
			tReturn = (new StringBuilder("81")).append(tCom).toString();
		else
		if (cNoType.equals("PRTSEQ2NO"))
			tReturn = (new StringBuilder("82")).append(tCom).toString();
		else
		if (cNoType.equals("CONTPRTSEQ"))
		{
			tReturn = (new StringBuilder("83")).append(tCom).toString();
			serialLen = 6;
		} else
		if (cNoType.equals("TAKEBACKNO"))
			tReturn = (new StringBuilder("61")).append(tCom).toString();
		else
		if (cNoType.equals("BATCHNO"))
			tReturn = (new StringBuilder("62")).append(tCom).toString();
		else
		if (cNoType.equals("VOUCHERIDNO"))
			tReturn = (new StringBuilder("63")).append(tCom).toString();
		else
		if (cNoType.equals("WAGENO"))
			tReturn = (new StringBuilder("90")).append(tCom).toString();
		else
		if (cNoType.equals("SERIALNO"))
			tReturn = (new StringBuilder("98")).append(tCom).toString();
		conn = DBConnPool.getConnection();
		if (conn == null)
		{
			System.out.println("CreateMaxNo : fail to get db connection");
			return tReturn;
		}
		tMaxNo = 0;
		cNoLimit = tReturn;
		String result;
		conn.setAutoCommit(false);
		StringBuffer tSBql = new StringBuffer(256);
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
			break MISSING_BLOCK_LABEL_1589;
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
					break MISSING_BLOCK_LABEL_1712;
				tSBql = new StringBuffer(256);
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
		break MISSING_BLOCK_LABEL_1823;
		tSBql = new StringBuffer(256);
		tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_1814;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = Integer.parseInt(result) + 1;
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_1867;
		String tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", serialLen);
		if (tReturn.equals("SN"))
			tReturn = (new StringBuilder(String.valueOf(tStr.trim()))).append("0").toString();
		else
			tReturn = (new StringBuilder(String.valueOf(tReturn.trim()))).append(tStr.trim()).toString();
		return tReturn;
	}

	public String CreateMaxNo(String cNoType, int cNoLength)
	{
		Connection conn;
		String cNoLimit;
		BigInteger tMaxNo;
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
			System.out.println((new StringBuilder("该类型流水号，请采用CreateMaxNo('")).append(cNoType).append("','SN')方式生成").toString());
			return null;
		}
		tMaxNo = new BigInteger("0");
		tReturn = cNoLimit;
		String result;
		conn.setAutoCommit(false);
		StringBuffer tSBql = new StringBuffer(256);
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
			break MISSING_BLOCK_LABEL_314;
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
					break MISSING_BLOCK_LABEL_439;
				tSBql = new StringBuffer(256);
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
		tMaxNo = new BigInteger("1");
		break MISSING_BLOCK_LABEL_563;
		tSBql = new StringBuffer(256);
		tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_539;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = (new BigInteger(result)).add(new BigInteger("1"));
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_603;
		String tStr = tMaxNo.toString();
		tStr = PubFun.LCh(tStr, "0", cNoLength);
		String tReturn = tStr.trim();
		return tReturn;
	}

	public static void main(String args[])
	{
		String tAgentGroup = PubFun1.CreateMaxNo("AgentGroup", 12);
		System.out.println((new StringBuilder("AgentGroup:")).append(tAgentGroup).toString());
	}
}
