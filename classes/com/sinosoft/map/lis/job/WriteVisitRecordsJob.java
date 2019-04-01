// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WriteVisitRecordsJob.java

package com.sinosoft.map.lis.job;

import com.sinosoft.map.common.logs.ErrorsLog;
import com.sinosoft.map.common.logs.VisitorLog;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.quartz.*;

public class WriteVisitRecordsJob
	implements Job
{

	public WriteVisitRecordsJob()
	{
	}

	public void execute(JobExecutionContext context)
		throws JobExecutionException
	{
		List webOperateInfoList = (List)((ArrayList)VisitorLog.webOperateInfoList).clone();
		VisitorLog.webOperateInfoList.clear();
		if (webOperateInfoList.size() > 0)
		{
			System.out.println("开始写操作日志---------");
			VisitorLog.logClick(webOperateInfoList);
		}
		List tempErrorMessages = (List)((ArrayList)ErrorsLog.errorMessages).clone();
		ErrorsLog.errorMessages.clear();
		if (tempErrorMessages != null && tempErrorMessages.size() > 0)
		{
			System.out.println("开始写异常日志---------");
			ErrorsLog.errorLogs(tempErrorMessages);
		}
	}
}
