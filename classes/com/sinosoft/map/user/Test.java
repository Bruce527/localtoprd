// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Test.java

package com.sinosoft.map.user;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test extends Thread
{

	String domain[][];
	int speed[];
	int i;
	Thread thread[];
	List test;

	public Test()
	{
		i = 1;
		test = new ArrayList();
	}

	public void run()
	{
		getDomain(i);
	}

	public void getDomain(int i)
	{
		String addrs = domain[i - 1][1];
		if (addrs == null || addrs == "")
		{
			System.out.println("syntax Error!");
		} else
		{
			String line = null;
			try
			{
				Process pro = Runtime.getRuntime().exec((new StringBuilder("ping ")).append(addrs).append(" -l 1000 -n 4").toString());
				BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
				while ((line = buf.readLine()) != null) 
				{
					int position = 0;
					if ((position = line.indexOf("Average")) >= 0)
					{
						int time = line.lastIndexOf("ms");
						String value = line.substring(position + 10, line.lastIndexOf("ms"));
						int tspeed = 1000 / Integer.parseInt(value);
						speed[i - 1] = tspeed;
					}
				}
			}
			catch (Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	}

	public void query()
	{
		String strSQL = "select sysvartype,sysvarvalue from ldsysvar where sysvar='domainname' order by sysvartype";
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs = exeSQL.execSQL(strSQL);
		if (ssrs.getMaxRow() > 0)
		{
			for (int i = 1; i <= ssrs.MaxRow; i++)
			{
				for (int j = 1; j <= ssrs.MaxCol; j++)
					domain[i - 1][j - 1] = ssrs.GetText(i, j);

			}

		}
	}

	public void getThread()
	{
		for (int i = 0; i < domain.length; i++)
		{
			thread[i] = new Thread();
			thread[i].start();
		}

	}
}
