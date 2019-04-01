// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TestOper.java

package com.sinosoft.banklns;

import com.sinosoft.banklns.lis.bean.BankLNPBnfBean;
import com.sinosoft.banklns.lis.pubfun.MMap;
import com.sinosoft.banklns.lis.pubfun.PubFun;
import com.sinosoft.banklns.utility.DBConnPool;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Set;

public class TestOper
{

	private BankLNPBnfBean bean;

	public TestOper()
	{
		bean = new BankLNPBnfBean();
	}

	public static void main(String args[])
	{
		TestOper t = new TestOper();
		System.out.println(PubFun.calInterval("2012-09-29", "2012-10-29", "D"));
	}

	public String calHMS(long timeInSeconds)
	{
		long hours = timeInSeconds / 3600L;
		timeInSeconds -= hours * 3600L;
		long minutes = timeInSeconds / 60L;
		timeInSeconds -= minutes * 60L;
		long seconds = timeInSeconds;
		return (new StringBuilder(String.valueOf(hours))).append(" hour(s) ").append(minutes).append(" minute(s) ").append(seconds).append(" second(s)").toString();
	}

	public void formatKinds()
	{
		DecimalFormat formatDouble = new DecimalFormat("#.00");
		double number = 100000000D;
		String rst = formatDouble.format(number);
		String number1 = "100000000.00";
	}

	public void DBconnT()
	{
		for (int i = 0; i < 300; i++)
			try
			{
				com.sinosoft.banklns.utility.DBConn con = DBConnPool.getConnection();
				System.out.println((new StringBuilder("cur idx:")).append(i + 1).append("----------start:").append(PubFun.getCurrentTime()).toString());
				Thread.sleep(500L);
				System.out.println((new StringBuilder("----------end:")).append(PubFun.getCurrentTime()).toString());
				ExeSQL execSQL = new ExeSQL(con);
				SSRS ssrs = execSQL.execSQL("select * from lnpcont");
				System.out.println(ssrs.getMaxRow());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

	}

	public String fomartDate(String date)
	{
		if (date != null)
			return date.replaceAll("^(\\d+)-(\\d+)-(\\d+).*$", "$1$2$3");
		else
			return null;
	}

	public void init()
	{
		MMap map = new MMap();
		bean = new BankLNPBnfBean();
		add(bean, map);
		add1(bean, map);
		bean = (BankLNPBnfBean)map.get("bean");
		bean.setGender("nan");
		System.out.println((new StringBuilder(String.valueOf(bean.getIdType()))).append("------").append(bean.getRelationToInsured()).append("----------").append(bean.getGender()).toString());
	}

	public MMap add(BankLNPBnfBean bean, MMap map)
	{
		bean.setIdType("shenfenzheng");
		System.out.println((new StringBuilder(String.valueOf(bean.getIdType()))).append("------").append(bean.getRelationToInsured()).append("----------").append(bean.getGender()).toString());
		map.put("bean", bean);
		return map;
	}

	public MMap add1(BankLNPBnfBean bean, MMap map)
	{
		bean.setRelationToInsured("songsss");
		System.out.println((new StringBuilder(String.valueOf(bean.getIdType()))).append("------").append(bean.getRelationToInsured()).append("----------").append(bean.getGender()).toString());
		map.put("bean", bean);
		return map;
	}

	public void init1()
	{
		MMap amap = new MMap();
		BankLNPBnfBean bean1 = new BankLNPBnfBean();
		BankLNPBnfBean bean2 = new BankLNPBnfBean();
		add2(bean1, amap);
		add3(bean2, amap);
		for (int i = 0; i < amap.keySet().size(); i++)
		{
			Object key = amap.getKeyByOrder(String.valueOf(i + 1));
			System.out.println(amap.get(key).toString());
		}

	}

	public void add2(BankLNPBnfBean bean, MMap map)
	{
		bean.setIdType("1111");
		map.put(bean, "update");
	}

	public void add3(BankLNPBnfBean bean, MMap map)
	{
		bean.setIdType("2222");
		map.put(bean, "update");
	}

	public void init2()
	{
		String txt = "ABC^12312^|ABC^12312^|ABC^12312^";
		String args[] = txt.split("\\|");
		System.out.println(args[0].split("\\^")[2]);
	}

	public void sendFile()
	{
	}
}
