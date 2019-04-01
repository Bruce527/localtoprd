// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PubFun1.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.math.BigInteger;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			SysMaxNo

public class PubFun1
{

	public PubFun1()
	{
	}

	public static String CreateMaxNo(String cNoType, String cNoLimit)
	{
		SysMaxNo tSysMaxNo;
		System.out.println("sysmaxnotype:METLIFE");
		String className = "com.sinosoft.map.lis.pubfun.SysMaxNoMETLIFE";
		Class cc = Class.forName(className);
		tSysMaxNo = (SysMaxNo)cc.newInstance();
		return tSysMaxNo.CreateMaxNo(cNoType, cNoLimit);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public static String creatVerifyDigit(String originalDigit)
	{
		String finalDigit;
		finalDigit = null;
		String alterDigOdd[] = null;
		String alterDigEven[] = null;
		System.out.println((new StringBuilder("originalDigit")).append(originalDigit).append("originalDigit.length()").append(originalDigit.length()).toString());
		if (!"".equalsIgnoreCase(originalDigit))
		{
			alterDigOdd = new String[originalDigit.length()];
			alterDigEven = new String[originalDigit.length()];
			for (int i = 0; i < originalDigit.length(); i++)
			{
				if (i == 0)
				{
					alterDigOdd[i] = originalDigit.substring(i, i + 1);
					System.out.println((new StringBuilder("alterDigOdd[")).append(i).append("]").append(alterDigOdd[i].toString()).toString());
				}
				if (i == 1)
				{
					alterDigEven[i] = originalDigit.substring(i, i + 1);
					System.out.println((new StringBuilder("alterDigEven[")).append(i).append("]").append(alterDigEven[i].toString()).toString());
				}
				if (i > 1 && i % 2 == 1)
				{
					alterDigEven[i] = originalDigit.substring(i, i + 1);
					System.out.println((new StringBuilder("alterDigEven[")).append(i).append("]").append(alterDigEven[i].toString()).toString());
				}
				if (i > 1 && i % 2 == 0)
				{
					alterDigOdd[i] = originalDigit.substring(i, i + 1);
					System.out.println((new StringBuilder("alterDigOdd[")).append(i).append("]").append(alterDigOdd[i].toString()).toString());
				}
			}

		}
		for (int i = alterDigOdd.length - 1; i >= 0; i--)
			System.out.println((new StringBuilder("alterDigOdd数组的元素[")).append(i).append("]").append(alterDigOdd[i]).toString());

		for (int i = alterDigEven.length - 1; i >= 0; i--)
			System.out.println((new StringBuilder("alterDigEven数组的元素[")).append(i).append("]").append(alterDigEven[i]).toString());

		System.out.println((new StringBuilder("alterDigOdd")).append(alterDigOdd.toString()).append("alterDigOdd.length()").append(alterDigOdd.length).toString());
		System.out.println((new StringBuilder("alterDigEven")).append(alterDigEven.toString()).append("alterDigEven.length()").append(alterDigEven.length).toString());
		if (!"".equals(alterDigOdd))
		{
			for (int i = 0; i < alterDigOdd.length; i++)
				if (alterDigOdd[i] != null && alterDigOdd[i] != "null" && alterDigOdd[i] != "0")
				{
					System.out.println((new StringBuilder("(String)alterDigOdd[i]")).append(alterDigOdd[i]).toString());
					String tempString = null;
					System.out.println((new StringBuilder("alterDigOdd before double[")).append(i).append("]:").append(alterDigOdd[i]).toString());
					tempString = String.valueOf(2 * Integer.parseInt(alterDigOdd[i].toString()));
					System.out.println((new StringBuilder("alterDigOdd after double[")).append(i).append("]:").append(alterDigOdd[i]).toString());
					alterDigOdd[i] = "";
					alterDigOdd[i] = tempString;
					if (!"".equals(alterDigOdd[i]) && alterDigOdd[i].toString().length() > 1)
					{
						int tempInt = 0;
						for (int j = 0; j < alterDigOdd[i].length(); j++)
						{
							String temp = alterDigOdd[i];
							tempInt += Integer.parseInt(String.valueOf(temp.charAt(j)));
						}

						alterDigOdd[i] = "";
						alterDigOdd[i] = String.valueOf(tempInt);
					}
					System.out.println((new StringBuilder("alterDigOdd after Add double")).append(alterDigOdd[i].toString()).toString());
				}

			for (int i = alterDigOdd.length - 1; i >= 0; i--)
				System.out.println((new StringBuilder("alterDigOdd数组的元素 after Add double [")).append(i).append("]").append(alterDigOdd[i]).toString());

			int allDig = 0;
			for (int i = 0; i < alterDigOdd.length; i++)
			{
				if (i == 0)
				{
					allDig += Integer.parseInt(alterDigOdd[i]);
					System.out.println((new StringBuilder("alterDigOdd[")).append(i).append("]").append(alterDigOdd[i].toString()).toString());
				}
				if (i == 1)
				{
					allDig += Integer.parseInt(alterDigEven[i]);
					System.out.println((new StringBuilder("alterDigEven[")).append(i).append("]").append(alterDigEven[i].toString()).toString());
				}
				if (i > 1 && i % 2 == 1)
				{
					allDig += Integer.parseInt(alterDigEven[i]);
					System.out.println((new StringBuilder("alterDigEven[")).append(i).append("]").append(alterDigEven[i].toString()).toString());
				}
				if (i > 1 && i % 2 == 0)
				{
					allDig += Integer.parseInt(alterDigOdd[i]);
					System.out.println((new StringBuilder("alterDigOdd[")).append(i).append("]").append(alterDigOdd[i].toString()).toString());
				}
			}

			System.out.println((new StringBuilder("allDig")).append(String.valueOf(allDig)).toString());
			int lastDig = 0;
			String allDigString = String.valueOf(allDig);
			if (allDig != 0)
				lastDig = Integer.parseInt(allDigString.substring(allDigString.length() - 1, allDigString.length()));
			System.out.println((new StringBuilder("lastDig")).append(String.valueOf(lastDig)).toString());
			int checkDig = 0;
			checkDig = 9 - lastDig;
			finalDigit = (new StringBuilder(String.valueOf(originalDigit))).append(String.valueOf(checkDig)).toString();
			System.out.println((new StringBuilder("finalDigit")).append(finalDigit).toString());
		}
		return finalDigit;
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public static String CreateMaxNo(String cNoType, String cNoLimit, VData tVData)
	{
		SysMaxNo tSysMaxNo;
		System.out.println("sysmaxnotype:METLIFE");
		String className = "com.sinosoft.map.lis.pubfun.SysMaxNoMETLIFE";
		Class cc = Class.forName(className);
		tSysMaxNo = (SysMaxNo)cc.newInstance();
		return tSysMaxNo.CreateMaxNo(cNoType, cNoLimit);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public static String CreateMaxNo(String cNoType, int cNoLength)
	{
		SysMaxNo tSysMaxNo;
		String className = "com.sinosoft.map.lis.pubfun.SysMaxNoMETLIFE";
		Class cc = Class.forName(className);
		tSysMaxNo = (SysMaxNo)cc.newInstance();
		System.out.println(className);
		return tSysMaxNo.CreateMaxNo(cNoType, cNoLength);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
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

	public static String CreateBranchAttr(String tUpAttr, int tLength)
	{
		ExeSQL tExeSql = new ExeSQL();
		String aNewAttr = "";
		String tSQL = (new StringBuilder("select max(branchattr) from labranchgroup where trim(branchattr) like '")).append(tUpAttr.trim()).append("%' and (trim(state) <> '1' or state is null)").append(" and branchtype = '1' and length(trim(branchattr)) = ").append(tLength).toString();
		aNewAttr = tExeSql.getOneValue(tSQL);
		System.out.println((new StringBuilder("---maximum = ")).append(aNewAttr).toString());
		BigInteger tInt = null;
		BigInteger tAdd = null;
		try
		{
			tInt = new BigInteger(aNewAttr.trim());
			tAdd = new BigInteger("1");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return "";
		}
		tInt = tInt.add(tAdd);
		aNewAttr = tInt.toString();
		System.out.println((new StringBuilder("---aNewAttr = ")).append(aNewAttr).toString());
		return aNewAttr;
	}

	public static void main(String args1[])
	{
	}
}
