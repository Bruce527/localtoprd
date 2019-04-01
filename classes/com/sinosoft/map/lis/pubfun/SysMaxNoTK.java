// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysMaxNoTK.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.math.BigInteger;
import java.sql.Connection;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			SysMaxNo, PubFun, PubFun1

public class SysMaxNoTK
	implements SysMaxNo
{

	public SysMaxNoTK()
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
		serialLen = 6;
		tReturn = null;
		cNoType = cNoType.toUpperCase();
		System.out.println((new StringBuilder("-----------cNoType:")).append(cNoType).append("  cNoLimit:").append(cNoLimit).toString());
		if (cNoLimit.trim().toUpperCase().equals("SN"))
		{
			System.out.println((new StringBuilder("sssssssssscNOLimit====")).append(cNoLimit).toString());
			System.out.println((new StringBuilder("===========")).append(cNoType).toString());
			if (cNoType.equals("COMMISIONSN") || cNoType.equals("GRPNO") || cNoType.equals("SUGDATAITEMCODE") || cNoType.equals("SUGITEMCODE") || cNoType.equals("SUGMODELCODE") || cNoType.equals("SUGCODE") || cNoType.equals("ACCNO"))
				serialLen = 10;
			else
			if (cNoType.equals("CUSTOMERNO"))
			{
				serialLen = 8;
			} else
			{
				System.out.println("错误的NoLimit");
				return null;
			}
			System.out.println((new StringBuilder("---------serialLen----")).append(serialLen).toString());
		}
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
			serialLen = 6;
		if (cNoType.equals("ATCODE") || cNoType.equals("MANAGECOM"))
			serialLen = 4;
		tReturn = cNoLimit.trim();
		String tCom = "";
		if (tReturn.length() >= 4)
			tCom = tReturn.substring(0, 4);
		if (cNoType.equals("PROPOSALNO"))
			tReturn = (new StringBuilder("26")).append(tCom).toString();
		else
		if (cNoType.equals("GRPPROPOSALNO"))
			tReturn = (new StringBuilder("27")).append(tCom).toString();
		else
		if (cNoType.equals("PROPOSALCONTNO"))
			tReturn = (new StringBuilder("28")).append(tCom).toString();
		else
		if (cNoType.equals("PROGRPCONTNO"))
			tReturn = (new StringBuilder("28")).append(tCom).toString();
		else
		if (cNoType.equals("POLNO"))
			tReturn = (new StringBuilder("26")).append(tCom).toString();
		else
		if (cNoType.equals("GRPPOLNO"))
			tReturn = (new StringBuilder("27")).append(tCom).toString();
		else
		if (cNoType.equals("CONTNO"))
			tReturn = (new StringBuilder("20")).append(tCom).toString();
		else
		if (cNoType.equals("GRPCONTNO"))
			tReturn = (new StringBuilder("28")).append(tCom).toString();
		else
		if (cNoType.equals("PAYNOTICENO"))
		{
			tReturn = (new StringBuilder("97")).append(tCom).toString();
			serialLen = 8;
		} else
		if (cNoType.equals("PAYNO"))
		{
			tReturn = (new StringBuilder("36")).append(tCom).toString();
			serialLen = 8;
		} else
		if (cNoType.equals("TEMPFEENO"))
		{
			tReturn = (new StringBuilder("37")).append(tCom).toString();
			serialLen = 8;
		} else
		if (cNoType.equals("ORITEMPFEENO"))
		{
			tReturn = (new StringBuilder("35")).append(tCom).toString();
			serialLen = 8;
		} else
		if (cNoType.equals("GETNOTICENO"))
		{
			tReturn = (new StringBuilder("96")).append(tCom).toString();
			serialLen = 8;
		} else
		if (cNoType.equals("GETNO"))
		{
			tReturn = (new StringBuilder("39")).append(tCom).toString();
			serialLen = 8;
		} else
		if (cNoType.equals("CLIENTID"))
		{
			tReturn = (new StringBuilder("17")).append(tCom).toString();
			serialLen = 8;
		} else
		if (cNoType.equals("SERVICENO"))
		{
			tReturn = (new StringBuilder("15")).append(tCom).toString();
			serialLen = 8;
		} else
		if (cNoType.equals("EDORACCEPTNO"))
			tReturn = (new StringBuilder("46")).append(tCom).toString();
		else
		if (cNoType.equals("TRIALNO"))
		{
			tReturn = (new StringBuilder("66")).append(tCom).toString();
			System.out.println((new StringBuilder("SysMaxNoTK:TrialNO===========274=========")).append(tReturn).toString());
		} else
		if (cNoType.equals("EDORNO"))
			tReturn = (new StringBuilder("42")).append(tCom).toString();
		else
		if (cNoType.equals("EDORGRPNO"))
			tReturn = (new StringBuilder("46")).append(tCom).toString();
		else
		if (cNoType.equals("RPTNO"))
			tReturn = (new StringBuilder("58")).append(tCom).toString();
		else
		if (cNoType.equals("RGTNO"))
			tReturn = (new StringBuilder("58")).append(tCom).toString();
		else
		if (cNoType.equals("RPTONLYNO"))
			tReturn = (new StringBuilder("58")).append(tCom).toString();
		else
		if (cNoType.equals("CLMNO"))
			tReturn = (new StringBuilder("58")).append(tCom).toString();
		else
		if (cNoType.equals("DECLINENO"))
			tReturn = (new StringBuilder("57")).append(tCom).toString();
		else
		if (cNoType.equals("PROTOCOLNO"))
			tReturn = (new StringBuilder("72")).append(tCom).toString();
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
			tReturn = (new StringBuilder("65")).append(tCom).toString();
		else
		if (cNoType.equals("BATCHNO"))
			tReturn = (new StringBuilder("64")).append(tCom).toString();
		else
		if (cNoType.equals("VOUCHERIDNO"))
			tReturn = (new StringBuilder("68")).append(tCom).toString();
		else
		if (cNoType.equals("WAGENO"))
			tReturn = (new StringBuilder("90")).append(tCom).toString();
		else
		if (cNoType.equals("SERIALNO"))
		{
			tReturn = (new StringBuilder("98")).append(tCom).toString();
			serialLen = 10;
		}
		conn = DBConnPool.getConnection();
		if (conn == null)
		{
			System.out.println("CreateMaxNo : fail to get db connection");
			return tReturn;
		}
		tMaxNo = 0;
		if (cNoType.equals("CUSTOMERNO"))
			cNoLimit = "unique";
		else
			cNoLimit = tReturn;
		String result;
		conn.setAutoCommit(false);
		StringBuffer tSBql = new StringBuffer(256);
		if (cNoType.equals("CUSTOMERNO") || cNoType.equals("CONTNO"))
			tSBql.append("select MaxNo from LDMaxNo1 where notype='");
		else
		if (cNoType.equals("PROPOSALNO"))
			tSBql.append("select MaxNo from LDMaxNo2 where notype='");
		else
			tSBql.append("select MaxNo from LDMaxNo where notype='");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit='");
		tSBql.append(cNoLimit);
		tSBql.append("' for update");
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(tSBql.toString());
		if (!exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_1712;
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
					break MISSING_BLOCK_LABEL_1886;
				tSBql = new StringBuffer(256);
				if (cNoType.equals("CUSTOMERNO") || cNoType.equals("CONTNO"))
					tSBql.append("insert into ldmaxno1(notype, nolimit, maxno) values('");
				else
				if (cNoType.equals("PROPOSALNO"))
					tSBql.append("insert into ldmaxno2(notype, nolimit, maxno) values('");
				else
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
		break MISSING_BLOCK_LABEL_2048;
		tSBql = new StringBuffer(256);
		if (cNoType.equals("CUSTOMERNO") || cNoType.equals("CONTNO"))
			tSBql.append("update ldmaxno1 set maxno = maxno + 1 where notype = '");
		else
		if (cNoType.equals("PROPOSALNO"))
			tSBql.append("update ldmaxno2 set maxno = maxno + 1 where notype = '");
		else
			tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_2039;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = Integer.parseInt(result) + 1;
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_2092;
		String tStr = String.valueOf(tMaxNo);
		System.out.println((new StringBuilder("-----1----tStr:")).append(tStr).toString());
		System.out.println((new StringBuilder("-------seriallent----")).append(serialLen).toString());
		tStr = PubFun.LCh(tStr, "0", serialLen);
		System.out.println((new StringBuilder("-----2----tStr:")).append(tStr).toString());
		if (tReturn.equals("SN"))
			tReturn = tStr.trim();
		else
			tReturn = (new StringBuilder(String.valueOf(tReturn.trim()))).append(tStr.trim()).toString();
		if (cNoType.equals("CUSTOMERNO"))
		{
			tReturn = GetAccountId(tReturn);
			System.out.println((new StringBuilder("----------")).append(tReturn).toString());
		}
		System.out.println((new StringBuilder("------tReturn:")).append(tReturn).toString());
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
		if (cNoType.equals("CUSTOMERNO") || cNoType.equals("CONTNO"))
			tSBql.append("select MaxNo from LDMaxNo1 where notype='");
		else
		if (cNoType.equals("PROPOSALNO"))
			tSBql.append("select MaxNo from LDMaxNo2 where notype='");
		else
			tSBql.append("select MaxNo from LDMaxNo where notype='");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit='");
		tSBql.append(cNoLimit);
		tSBql.append("' for update");
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(tSBql.toString());
		if (result != null && !exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_346;
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
					break MISSING_BLOCK_LABEL_522;
				tSBql = new StringBuffer(256);
				if (cNoType.equals("CUSTOMERNO") || cNoType.equals("CONTNO"))
					tSBql.append("insert into ldmaxno1(notype, nolimit, maxno) values('");
				else
				if (cNoType.equals("PROPOSALNO"))
					tSBql.append("insert into ldmaxno2(notype, nolimit, maxno) values('");
				else
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
		break MISSING_BLOCK_LABEL_697;
		tSBql = new StringBuffer(256);
		if (cNoType.equals("CUSTOMERNO") || cNoType.equals("CONTNO"))
			tSBql.append("update ldmaxno1 set maxno = maxno + 1 where notype = '");
		else
		if (cNoType.equals("PROPOSALNO"))
			tSBql.append("update ldmaxno2 set maxno = maxno + 1 where notype = '");
		else
			tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
		tSBql.append(cNoType);
		tSBql.append("' and nolimit = '");
		tSBql.append(cNoLimit);
		tSBql.append("'");
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(tSBql.toString()))
			break MISSING_BLOCK_LABEL_673;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = (new BigInteger(result)).add(new BigInteger("1"));
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_737;
		String tStr = tMaxNo.toString();
		tStr = PubFun.LCh(tStr, "0", cNoLength);
		String tReturn = tStr.trim();
		return tReturn;
	}

	public static void main(String args[])
	{
		String newGrpContNo = "";
		String limitNo = PubFun.getNoLimit("SN");
		newGrpContNo = PubFun1.CreateMaxNo("CUSTOMERNO", "SN");
		System.out.println(newGrpContNo);
	}
}
