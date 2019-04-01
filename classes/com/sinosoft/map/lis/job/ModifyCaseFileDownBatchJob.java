// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ModifyCaseFileDownBatchJob.java

package com.sinosoft.map.lis.job;

import com.sinosoft.map.lis.batch.ModifyCaseFileDown;
import java.io.PrintStream;
import org.quartz.*;

public class ModifyCaseFileDownBatchJob
	implements Job
{

	public ModifyCaseFileDownBatchJob()
	{
	}

	public synchronized void execute(JobExecutionContext context)
		throws JobExecutionException
	{
		System.out.println("=====ModifyCaseFileDownbatch===start=====");
		ModifyCaseFileDown tModifyCaseFileDown = new ModifyCaseFileDown();
		tModifyCaseFileDown.newBatch();
		System.out.println("=====ModifyCaseFileDownbatch===end=====");
	}
}
