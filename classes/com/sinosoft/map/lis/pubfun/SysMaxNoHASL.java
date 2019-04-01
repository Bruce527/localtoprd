// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysMaxNoHASL.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.math.BigInteger;
import java.sql.Connection;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			SysMaxNo, PubFun, PubFun1

public class SysMaxNoHASL
	implements SysMaxNo
{

	public SysMaxNoHASL()
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
		String nNolimit;
		String tYear;
		Connection conn;
		int tMaxNo;
		if (cNoType == null || cNoType.trim().length() <= 0 || cNoLimit == null)
		{
			System.out.println("NoType长度错误或者NoLimit为空");
			return null;
		}
		serialLen = 9;
		tReturn = null;
		nNolimit = cNoLimit;
		tYear = PubFun.getCurrentDate().substring(0, 4);
		cNoType = cNoType.toUpperCase();
		System.out.println((new StringBuilder("-----------cNoType:")).append(cNoType).append("  cNoLimit:").append(cNoLimit).toString());
		if (cNoLimit.trim().toUpperCase().equals("SN"))
			if (cNoType.equals("COMMISIONSN") || cNoType.equals("CUSTOMERNO") || cNoType.equals("MEETINGNO") || cNoType.equals("PRECUSTOMERNO") || cNoType.equals("RISKCURNO") || cNoType.equals("SUGDATAITEMCODE") || cNoType.equals("SUGITEMCODE") || cNoType.equals("RELATIONCODE") || cNoType.equals("SUGMODELCODE") || cNoType.equals("PROJECTCODE") || cNoType.equals("SUGCODE") || cNoType.equals("ACCNO"))
				serialLen = 9;
			else
			if (cNoType.equals("GRPNO"))
				serialLen = 8;
			else
			if (cNoType.equals("ACCIDETAIL"))
				serialLen = 5;
			else
			if (cNoType.equals("BANKPROCODE"))
				serialLen = 2;
			else
			if (cNoType.equals("SHORTBANKCODE"))
			{
				serialLen = 2;
			} else
			{
				System.out.println("错误的NoLimit");
				return null;
			}
		if (cNoType.equals("GRPCONTNO"))
			serialLen = 7;
		if (cNoType.equals("PLANBIDPROTOCOLNO"))
			serialLen = 3;
		if (cNoType.equals("PLANBIDPROTOCOLNO4"))
			serialLen = 4;
		if (cNoType.equals("PROJECTMANAGE"))
			serialLen = 3;
		if (cNoType.equals("PROMANAGEAGENTCODE"))
			serialLen = 10;
		if (cNoType.equals("NEWGRPCONTNO"))
			serialLen = 5;
		else
		if (cNoType.equals("CREATEBANK"))
			serialLen = 4;
		else
		if (cNoType.equals("BANKCITYCODE"))
			serialLen = 2;
		else
		if (cNoType.equals("ERRORPIECESSERIALNO"))
			serialLen = 10;
		else
		if (cNoType.equals("GRPBRANCHGROUP"))
			serialLen = 2;
		else
		if (cNoType.equals("CtrlLevel"))
			serialLen = 10;
		else
		if (cNoType.equals("BCtrl"))
			serialLen = 10;
		else
		if (cNoType.equals("BCtrlLevel"))
			serialLen = 10;
		if (cNoType.equals("AIRPOLNO"))
			serialLen = 7;
		if (cNoType.equals("ATCODE") || cNoType.equals("MANAGECOM"))
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
		if (cNoType.equals("NEWGRPCONTNO"))
			tReturn = "99";
		else
		if (cNoType.equals("ERRORPIECESSERIALNO"))
			tReturn = "91";
		else
		if (cNoType.equals("PAYNOTICENO"))
			tReturn = "31";
		else
		if (cNoType.equals("PAYNO"))
			tReturn = "32";
		else
		if (cNoType.equals("TEMPFEENO"))
			tReturn = "33";
		else
		if (cNoType.equals("ORITEMPFEENO"))
			tReturn = "34";
		else
		if (cNoType.equals("GETNOTICENO"))
			tReturn = "36";
		else
		if (cNoType.equals("GETNO"))
			tReturn = "37";
		else
		if (cNoType.equals("CLIENTID"))
			tReturn = "17";
		else
		if (cNoType.equals("SERVICENO"))
			tReturn = "15";
		else
		if (cNoType.equals("EDORACCEPTNO"))
			tReturn = "46";
		else
		if ("NEWEDORNO".equals(cNoType))
			serialLen = 5;
		else
		if ("MANO".equals(cNoType))
			serialLen = 5;
		else
		if (cNoType.equals("TRIALNO"))
			tReturn = "66";
		else
		if (cNoType.equals("EDORNO"))
			tReturn = "42";
		else
		if (cNoType.equals("EDORGRPNO"))
			tReturn = "46";
		else
		if (cNoType.equals("EDORECLOGNO"))
			tReturn = "26";
		else
		if (cNoType.equals("RPTNO"))
			serialLen = 5;
		else
		if (cNoType.equals("RGTNO"))
			serialLen = 5;
		else
		if (cNoType.equals("RPTONLYNO"))
			serialLen = 5;
		else
		if (cNoType.equals("CLMNO"))
			serialLen = 5;
		else
		if (cNoType.equals("DECLINENO"))
			tReturn = "57";
		else
		if (cNoType.equals("PROTOCOLNO"))
			tReturn = "72";
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
		if (cNoType.equals("CONTPRTSEQ"))
		{
			tReturn = "83";
			serialLen = 6;
		} else
		if (cNoType.equals("TAKEBACKNO"))
			tReturn = "65";
		else
		if (cNoType.equals("BATCHNO"))
			tReturn = "64";
		else
		if (cNoType.equals("VOUCHERIDNO"))
			tReturn = "68";
		else
		if (cNoType.equals("WAGENO"))
			tReturn = "90";
		else
		if (cNoType.equals("BALANCEALLNO"))
			tReturn = "85";
		else
		if (cNoType.equalsIgnoreCase("CouNo"))
			tReturn = "75";
		else
		if (cNoType.equals("PRICINGNO"))
			tReturn = "95";
		else
		if (cNoType.equals("PRICINGLOGNO"))
			tReturn = "45";
		else
		if (cNoType.equals("REBALANCENO"))
			tReturn = "39";
		else
		if (cNoType.equals("REBALANCELOGNO"))
			tReturn = "30";
		else
		if (cNoType.equals("REBALANCELISTNO"))
			tReturn = "74";
		else
		if (cNoType.equals("FUNDSWITCHNO"))
			tReturn = "55";
		else
		if (cNoType.equals("COU"))
			tReturn = "35";
		else
		if (cNoType.equals("ROLLBACKNO"))
			tReturn = "50";
		else
		if (cNoType.equals("MATURITYNO"))
			tReturn = "56";
		else
		if (cNoType.equals("SERIALNO"))
		{
			tReturn = "98";
			serialLen = 10;
		} else
		if (cNoType.equals("CIRCERRORSEQ"))
			tReturn = "44";
		else
		if (cNoType.equals("BANKCODE"))
		{
			tReturn = "8";
			serialLen = 6;
		} else
		if (cNoType.equals("MOVENO"))
		{
			tReturn = "16";
			serialLen = 10;
		} else
		if (cNoType.equals("RISKASSESS"))
			serialLen = 5;
		else
		if (cNoType.equals("LLGRANTNO"))
			tReturn = "25";
		conn = DBConnPool.getConnection();
		if (conn == null)
		{
			System.out.println("CreateMaxNo : fail to get db connection");
			return tReturn;
		}
		tMaxNo = 0;
		if (!cNoLimit.trim().toUpperCase().equals("SN") && !cNoLimit.trim().toUpperCase().equals("SYS_PRT"))
			if (cNoType.equals("GRPCONTNO"))
				cNoLimit = "5";
			else
			if (cNoType.equals("RPTNO") || cNoType.equals("RGTNO") || cNoType.equals("RPTONLYNO") || cNoType.equals("CLMNO"))
			{
				String subYear = tYear.substring(2, 4);
				String subCom = cNoLimit.substring(2);
				cNoLimit = (new StringBuilder(String.valueOf(subYear))).append(subCom).toString();
			} else
			if (!cNoType.equals("CREATEBANK") && !cNoType.equals("BANKCITYCODE"))
				if (cNoType.equals("NEWGRPCONTNO"))
				{
					String year = cNoLimit.substring(8, 10);
					String tcom = cNoLimit.substring(2, 6);
					cNoLimit = (new StringBuilder(String.valueOf(year.trim()))).append(tcom.trim()).toString();
				} else
				if (cNoType.equals("GRPBRANCHGROUP"))
					cNoLimit = tReturn;
				else
				if ("NEWEDORNO".equals(cNoType))
				{
					String year = cNoLimit.substring(8, 10);
					String com = cNoLimit.substring(2, 6);
					cNoLimit = (new StringBuilder(String.valueOf(year.trim()))).append(com.trim()).toString();
				} else
				if ("MANO".equals(cNoType))
				{
					String year = cNoLimit.substring(8, 10);
					String com = cNoLimit.substring(2, 6);
					cNoLimit = (new StringBuilder(String.valueOf(year.trim()))).append(com.trim()).toString();
				} else
				if ("RISKASSESS".equals(cNoType))
				{
					cNoLimit = PubFun.LCh(cNoLimit, "0", 10);
					String year = cNoLimit.substring(8, 10);
					String com = cNoLimit.substring(2, 6);
					cNoLimit = (new StringBuilder(String.valueOf(com.trim()))).append(year.trim()).toString();
				} else
				{
					cNoLimit = (new StringBuilder(String.valueOf(tYear))).append(tReturn).toString();
				}
		String result;
		conn.setAutoCommit(false);
		StringBuffer tSBql = new StringBuffer(256);
		tSBql.append("select MaxNo from LDMaxNo where notype='");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit='");
		tSBql.append(cNoLimit);
		tSBql.append("' for update");
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(tSBql.toString());
		if (!exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_1992;
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
					break MISSING_BLOCK_LABEL_2116;
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
		break MISSING_BLOCK_LABEL_2227;
		tSBql = new StringBuffer(256);
		tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_2218;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = Integer.parseInt(result) + 1;
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_2271;
		String tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", serialLen);
		String tCheck = "0";
		if (tReturn.equals("SN"))
			tReturn = (new StringBuilder(String.valueOf(tStr.trim()))).append("0").toString();
		else
		if (cNoType.equals("RPTNO") || cNoType.equals("RGTNO") || cNoType.equals("RPTONLYNO") || cNoType.equals("CLMNO"))
			tReturn = (new StringBuilder("C")).append(cNoLimit).append(tStr).toString();
		else
		if (cNoType != null && cNoType.toUpperCase().equals("GRPCONTNO"))
			tReturn = (new StringBuilder("5")).append(tStr.trim()).toString();
		else
		if (cNoType != null && cNoType.toUpperCase().equals("NEWGRPCONTNO"))
		{
			String NYear = PubFun.getCurrentDate().substring(2, 4);
			String comcode = (String)nNolimit.subSequence(2, 6);
			tReturn = (new StringBuilder("P")).append(NYear.trim()).append(comcode.trim()).append(tStr.trim()).toString();
		} else
		if (cNoType != null && cNoType.toUpperCase().equals("ERRORPIECESSERIALNO"))
			tReturn = (new StringBuilder(String.valueOf(cNoLimit.trim()))).append(tStr.trim()).append(tReturn.trim()).toString();
		else
		if (cNoType.equals("BANKCODE"))
			tReturn = (new StringBuilder(String.valueOf(tYear))).append(tStr.trim()).toString();
		else
		if (cNoType.equals("GRPBRANCHGROUP"))
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append(tStr.trim()).toString();
		else
		if ("NEWEDORNO".equals(cNoType))
		{
			String head = "S";
			tReturn = (new StringBuilder(String.valueOf(head.trim()))).append(cNoLimit.trim()).append(tStr.trim()).toString();
		} else
		if ("MANO".equals(cNoType))
		{
			String head = "M";
			tReturn = (new StringBuilder(String.valueOf(head.trim()))).append(cNoLimit.trim()).append(tStr.trim()).toString();
		} else
		if ("RISKASSESS".equals(cNoType))
		{
			String head = "R";
			tReturn = (new StringBuilder(String.valueOf(head.trim()))).append(cNoLimit.trim()).append(tStr.trim()).toString();
		} else
		{
			tReturn = (new StringBuilder(String.valueOf(tYear))).append(tStr.trim()).append(tCheck).append(tReturn).toString();
		}
		if ("ACCIDETAIL".equals(cNoType))
			tReturn = (new StringBuilder("ZZN")).append(tStr.trim()).toString();
		if ("CREATEBANK".equals(cNoType))
			tReturn = (new StringBuilder(String.valueOf(cNoLimit))).append(tStr.trim()).toString();
		if ("BANKPROCODE".equals(cNoType))
			tReturn = tStr.trim().substring(0, 2);
		if ("BANKCITYCODE".equals(cNoType))
			tReturn = tStr.trim().substring(0, 2);
		if ("SHORTBANKCODE".equals(cNoType))
			tReturn = tStr.trim().substring(0, 2);
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
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(tSBql.toString());
		if (result != null && !exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_203;
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
					break MISSING_BLOCK_LABEL_329;
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
		break MISSING_BLOCK_LABEL_453;
		tSBql = new StringBuffer(256);
		tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_429;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = (new BigInteger(result)).add(new BigInteger("1"));
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_493;
		String tStr = tMaxNo.toString();
		tStr = PubFun.LCh(tStr, "0", cNoLength);
		String tReturn = tStr.trim();
		return tReturn;
	}

	public static void main(String args[])
	{
		String strLimit = PubFun.getNoLimit("860401");
		String strRiskAssessNo = PubFun1.CreateMaxNo("RISKASSESS", strLimit);
		System.out.println((new StringBuilder("=============RiskAssessNo:")).append(strRiskAssessNo).append("==============").toString());
	}
}
