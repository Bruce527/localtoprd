// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WriteLogoutRecordsJob.java

package com.sinosoft.map.lis.job;

import com.sinosoft.map.lis.pubfun.PubFun;
import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.PrintStream;
import org.quartz.*;

public class WriteLogoutRecordsJob
	implements Job
{

	public WriteLogoutRecordsJob()
	{
	}

	public void execute(JobExecutionContext context)
		throws JobExecutionException
	{
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs1 = new SSRS();
		SSRS ssrs2 = new SSRS();
		String webStrSql = "select id from mwebloginlog where logoutdate is null ";
		String adminStrSql = "select id from madminloginlog where logoutdate is null ";
		ssrs1 = exeSQL.execSQL(webStrSql);
		ssrs2 = exeSQL.execSQL(adminStrSql);
		if (ssrs1 != null && ssrs1.MaxRow != 0 || ssrs2 != null && ssrs2.MaxRow != 0)
		{
			System.out.println("�?始写非正常�??出用户�??出信�?---------");
			if (ssrs1 != null && ssrs1.MaxRow != 0)
			{
				for (int i = 1; i <= ssrs1.MaxRow; i++)
				{
					String id = ssrs1.GetText(i, 1);
					String sql = (new StringBuilder("update mwebloginlog set logoutdate ='")).append(PubFun.getCurrentDate()).append("' and logouttime ='").append(PubFun.getCurrentTime()).append("' where id='").append(id).append("' ").toString();
					exeSQL.execUpdateSQL(sql);
				}

			}
			if (ssrs2 != null && ssrs2.MaxRow != 0)
			{
				for (int i = 1; i <= ssrs2.MaxRow; i++)
				{
					String id = ssrs1.GetText(i, 1);
					String sql = (new StringBuilder("update madminloginlog set logoutdate ='")).append(PubFun.getCurrentDate()).append("' and logouttime ='").append(PubFun.getCurrentTime()).append("' where id='").append(id).append("' ").toString();
					exeSQL.execUpdateSQL(sql);
				}

			}
		}
	}
}
