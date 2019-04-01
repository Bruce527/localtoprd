// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysMaxNoPicch.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.Random;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			SysMaxNo, PubFun, SysMaxNoZhongYing

public class SysMaxNoPicch
	implements SysMaxNo
{

	public SysMaxNoPicch()
	{
	}

	public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
	{
		return CreateMaxNo(cNoType, cNoLimit);
	}

	public String CreateMaxNo(String cNoType, int cNoLength)
	{
		Connection conn;
		String cNoLimit;
		int tMaxNo;
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
		tMaxNo = 0;
		tReturn = cNoLimit;
		String result;
		conn.setAutoCommit(false);
		String strSQL = (new StringBuilder("select MaxNo from LDMaxNo where notype='")).append(cNoType).append("' and nolimit='").append(cNoLimit).append("' for update").toString();
		if ("ORACLE".equals("ORACLE"))
			strSQL = (new StringBuilder(String.valueOf(strSQL))).append(" nowait").toString();
		ExeSQL exeSQL = new ExeSQL(conn);
		result = null;
		result = exeSQL.getOneValue(strSQL);
		if (result != null && !exeSQL.mErrors.needDealError())
			break MISSING_BLOCK_LABEL_198;
		System.out.println("CreateMaxNo 资源忙，请稍后!");
		conn.rollback();
		conn.close();
		return null;
label0:
		{
			String strSQL;
			ExeSQL exeSQL;
			try
			{
				if (!result.equals(""))
					break MISSING_BLOCK_LABEL_289;
				strSQL = (new StringBuilder("insert into ldmaxno(notype, nolimit, maxno) values('")).append(cNoType).append("', '").append(cNoLimit).append("', 1)").toString();
				exeSQL = new ExeSQL(conn);
				if (exeSQL.execUpdateSQL(strSQL))
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
		break MISSING_BLOCK_LABEL_373;
		strSQL = (new StringBuilder("update ldmaxno set maxno = maxno + 1 where notype = '")).append(cNoType).append("' and nolimit = '").append(cNoLimit).append("'").toString();
		exeSQL = new ExeSQL(conn);
		if (exeSQL.execUpdateSQL(strSQL))
			break MISSING_BLOCK_LABEL_364;
		System.out.println("CreateMaxNo 更新失败，请重试!");
		conn.rollback();
		conn.close();
		return null;
		tMaxNo = Integer.parseInt(result) + 1;
		conn.commit();
		conn.close();
		break MISSING_BLOCK_LABEL_413;
		String tStr = String.valueOf(tMaxNo);
		tStr = PubFun.LCh(tStr, "0", cNoLength);
		String tReturn = tStr.trim();
		return tReturn;
	}

	public String CreateMaxNo(String cNoType, String cInput)
	{
		if (cNoType == null || cNoType.trim().length() <= 0)
		{
			System.out.println("NoType长度错误");
			return null;
		}
		String tReturn = null;
		cNoType = cNoType.toUpperCase();
		String tDate = PubFun.getCurrentDate();
		String tDateCode = (new StringBuilder(String.valueOf(tDate.substring(2, 4)))).append(tDate.substring(5, 7)).append(tDate.substring(8, 10)).toString();
		if (cNoType.equals("FamilyNo"))
			tReturn = (new StringBuilder("F")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("CUSTOMERNO"))
			tReturn = CreateMaxNo(cNoType, 9);
		else
		if (cNoType.equals("PROPOSALCONTNO"))
			tReturn = (new StringBuilder("13")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("PROGRPCONTNO"))
			tReturn = (new StringBuilder("14")).append(CreateMaxNo(cNoType, 8)).toString();
		else
		if (cNoType.equals("POLNO"))
			tReturn = (new StringBuilder("21")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("GRPPOLNO"))
			tReturn = (new StringBuilder("22")).append(CreateMaxNo(cNoType, 8)).toString();
		else
		if (cNoType.equals("CONTNO"))
		{
			if (cInput == null || cInput.length() != 9)
			{
				System.out.println("请输入9位客户号!");
				return null;
			}
			tReturn = (new StringBuilder(String.valueOf(cInput))).append(CreateMaxNo(cNoType, 2)).toString();
		} else
		if (cNoType.equals("GRPPERSONCONTNO"))
			tReturn = (new StringBuilder("23")).append(CreateMaxNo(cNoType, 8)).toString();
		else
		if (cNoType.equals("PRINTNO"))
			tReturn = (new StringBuilder("16")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("GRPNO"))
			tReturn = CreateMaxNo(cNoType, 8);
		else
		if (cNoType.equals("GRPINSUREDNO"))
		{
			if (cInput == null || cInput.length() != 9)
			{
				System.out.println("请输入9位客户号!");
				return null;
			}
			tReturn = (new StringBuilder(String.valueOf(cInput))).append(CreateMaxNo(cNoType, 2)).toString();
		} else
		if (cNoType.equals("GRPCONTNO"))
		{
			if (cInput == null || cInput.length() != 8)
			{
				System.out.println("请输入8位客户号!");
				return null;
			}
			tReturn = (new StringBuilder(String.valueOf(cInput))).append(CreateMaxNo(cNoType, 2)).toString();
		} else
		if (cNoType.equals("GRPQUERYNO"))
		{
			if (cInput == null || cInput.length() != 8)
			{
				System.out.println("请输入8位客户号!");
				return null;
			}
			tReturn = (new StringBuilder("R")).append(cInput).append(CreateMaxNo(cNoType, 3)).toString();
		} else
		if (cNoType.equals("PROPOSALNO"))
			tReturn = (new StringBuilder("11")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("GRPPROPOSALNO"))
			tReturn = (new StringBuilder("12")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("GRPCOMFIRMPRTNO"))
			tReturn = (new StringBuilder("18")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("GRPQUERYPRTNO"))
			tReturn = (new StringBuilder("19")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("BARCODENO"))
		{
			if (cInput == null)
			{
				System.out.println("请输入9位客户号!");
				return null;
			}
			Random random = new Random();
			tReturn = (new StringBuilder(String.valueOf(cInput))).append(Math.abs(random.nextInt()) % 100).toString();
		} else
		if (cNoType.equals("NOTICENO"))
		{
			cInput = getClaimLimit(cInput);
			tReturn = (new StringBuilder("T")).append(cInput).append(tDateCode).append(CreateMaxNo((new StringBuilder(String.valueOf(cNoType))).append(tDateCode).toString(), 6)).toString();
		} else
		if (cNoType.equals("COSULTNO"))
		{
			cInput = getClaimLimit(cInput);
			tReturn = (new StringBuilder("Z")).append(cInput).append(tDateCode).append(CreateMaxNo((new StringBuilder(String.valueOf(cNoType))).append(tDateCode).toString(), 6)).toString();
		} else
		if (cNoType.equals("CNNO"))
		{
			cInput = getClaimLimit(cInput);
			tReturn = (new StringBuilder("H")).append(cInput).append(tDateCode).append(CreateMaxNo((new StringBuilder(String.valueOf(cNoType))).append(tDateCode).toString(), 6)).toString();
		} else
		if (cNoType.equals("CASENO"))
		{
			cInput = getClaimLimit(cInput);
			tReturn = (new StringBuilder("C")).append(cInput).append(tDateCode).append(CreateMaxNo((new StringBuilder(String.valueOf(cNoType))).append(tDateCode).toString(), 6)).toString();
		} else
		if (cNoType.equals("APPEALNO"))
		{
			cInput = getClaimLimit(cInput);
			tReturn = (new StringBuilder("S")).append(cInput).append(tDateCode).append(CreateMaxNo((new StringBuilder(String.valueOf(cNoType))).append(tDateCode).toString(), 6)).toString();
		} else
		if (cNoType.equals("LLERRORNO"))
		{
			cInput = getClaimLimit(cInput);
			tReturn = (new StringBuilder("R")).append(cInput).append(tDateCode).append(CreateMaxNo((new StringBuilder(String.valueOf(cNoType))).append(tDateCode).toString(), 6)).toString();
		} else
		if (cNoType.equals("RGTNO"))
		{
			cInput = getClaimLimit(cInput);
			tReturn = (new StringBuilder("P")).append(cInput).append(tDateCode).append(CreateMaxNo((new StringBuilder(String.valueOf(cNoType))).append(tDateCode).toString(), 6)).toString();
		} else
		if (cNoType.equals("SUBRPTNO"))
		{
			cInput = getClaimLimit(cInput);
			tReturn = (new StringBuilder("A")).append(cInput).append(tDateCode).append(CreateMaxNo((new StringBuilder(String.valueOf(cNoType))).append(tDateCode).toString(), 6)).toString();
		} else
		if (cNoType.equals("PAYNOTICENO"))
			tReturn = (new StringBuilder("31")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("PAYNO"))
			tReturn = (new StringBuilder("32")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("GETNOTICENO"))
			tReturn = (new StringBuilder("36")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("GETNO"))
			tReturn = (new StringBuilder("37")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("EDORAPPNO"))
			tReturn = (new StringBuilder("41")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("EDORNO"))
			tReturn = (new StringBuilder("42")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("EDORGRPAPPNO"))
			tReturn = (new StringBuilder("43")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("EDORGRPNO"))
			tReturn = (new StringBuilder("44")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("PROTOCOLNO"))
			tReturn = (new StringBuilder("71")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("PRTNO"))
			tReturn = (new StringBuilder("80")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("PRTSEQNO"))
			tReturn = (new StringBuilder("81")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("PRTSEQ2NO"))
			tReturn = (new StringBuilder("82")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("TAKEBACKNO"))
			tReturn = (new StringBuilder("61")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("BATCHNO"))
			tReturn = (new StringBuilder("62")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("VOUCHERIDNO"))
			tReturn = (new StringBuilder("63")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("WAGENO"))
			tReturn = (new StringBuilder("90")).append(CreateMaxNo(cNoType, 9)).toString();
		else
		if (cNoType.equals("SERIALNO"))
		{
			tReturn = (new StringBuilder("98")).append(CreateMaxNo(cNoType, 9)).toString();
		} else
		{
			SysMaxNoZhongYing zhongying = new SysMaxNoZhongYing();
			tReturn = zhongying.CreateMaxNo(cNoType, cInput);
		}
		return tReturn;
	}

	private String getClaimLimit(String MngComCode)
	{
		return MngComCode.substring(2, 6);
	}

	public static void main(String args[])
	{
		SysMaxNoPicch tSysMaxNoPicch = new SysMaxNoPicch();
		System.out.println((new StringBuilder("CASERELANO")).append(tSysMaxNoPicch.CreateMaxNo("CASERELANO", "8600")).toString());
	}
}
