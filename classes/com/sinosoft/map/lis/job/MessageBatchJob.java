// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MessageBatchJob.java

package com.sinosoft.map.lis.job;

import com.sinosoft.map.lis.batch.*;
import org.quartz.*;

public class MessageBatchJob
	implements Job
{

	public MessageBatchJob()
	{
	}

	public void execute(JobExecutionContext context)
		throws JobExecutionException
	{
		MonthStatement tMonthStatement = new MonthStatement();
		tMonthStatement.batch();
		PolicyYearCheck tPolicyYearCheck = new PolicyYearCheck();
		tPolicyYearCheck.batch();
		RenewalPayment tRenewalPayment = new RenewalPayment();
		tRenewalPayment.batch();
		WeddingDate tWeddingDate = new WeddingDate();
		tWeddingDate.batch();
		BirthdayQuery tBirthdayQuery = new BirthdayQuery();
		tBirthdayQuery.batch();
		HonorData tHonorData = new HonorData();
		tHonorData.batch();
		Preserve tPreserve = new Preserve();
		tPreserve.batch();
	}

	public static void main(String args[])
	{
		MonthStatement tMonthStatement = new MonthStatement();
		tMonthStatement.batch();
		PolicyYearCheck tPolicyYearCheck = new PolicyYearCheck();
		tPolicyYearCheck.batch();
		RenewalPayment tRenewalPayment = new RenewalPayment();
		tRenewalPayment.batch();
		WeddingDate tWeddingDate = new WeddingDate();
		tWeddingDate.batch();
		BirthdayQuery tBirthdayQuery = new BirthdayQuery();
		tBirthdayQuery.batch();
		HonorData tHonorData = new HonorData();
		tHonorData.batch();
		Preserve tPreserve = new Preserve();
		tPreserve.batch();
	}
}
