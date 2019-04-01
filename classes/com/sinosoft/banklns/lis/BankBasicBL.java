// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankBasicBL.java

package com.sinosoft.banklns.lis;

import java.io.PrintStream;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public abstract class BankBasicBL
{

	private long waitTimeMillis;
	private long waitMaxTimes;

	public BankBasicBL()
	{
		waitTimeMillis = 300L;
		waitMaxTimes = 10L;
	}

	protected void waitPolicyCommited(HttpSession session, String ContNo)
		throws Exception
	{
		long startTime = System.currentTimeMillis();
		long endTime;
		while (isCurPolicyLock(session, ContNo)) 
		{
			endTime = System.currentTimeMillis();
			if ((endTime - startTime) / waitTimeMillis <= waitMaxTimes)
			{
				Thread.sleep(waitTimeMillis);
				continue;
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~because of limit maxWati times");
			turnCurrPolicyLockFlag(session, ContNo, "unlock");
			break;
		}
		endTime = System.currentTimeMillis();
		System.out.println((new StringBuilder("~~~~~~~~~>startmillis:")).append(startTime).append(" |endmillis: ").append(endTime).append(" |~~~~~~~~~wait ").append((endTime - startTime) / waitTimeMillis).append(" timeS  ,total time ").append(calHMS((endTime - startTime) / 1000L)).toString());
		System.out.println();
	}

	protected void turnCurrPolicyLockFlag(HttpSession session, String contno, String lockState)
		throws RuntimeException
	{
		if (session == null)
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute(contno, (new StringBuilder(String.valueOf(contno))).append(lockState).toString());
		System.out.println((new StringBuilder("turn------------current ")).append(contno).append(" policy lock state:").append(session.getAttribute(contno)).toString());
	}

	protected boolean isCurPolicyLock(HttpSession session, String contno)
		throws RuntimeException
	{
		boolean flag = true;
		if (session == null)
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String locked = (String)session.getAttribute(contno);
		System.out.println((new StringBuilder("is------------current ")).append(contno).append(" policy lock state:").append(session.getAttribute(contno)).toString());
		if (turnNullToString(locked).equals("") || turnNullToString(locked).indexOf("unlock") > -1)
			flag = false;
		return flag;
	}

	private String turnNullToString(Object object)
	{
		String rst = "";
		try
		{
			rst = object != null ? (new StringBuilder()).append(object).toString() : "";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rst.trim();
	}

	private String calHMS(long timeInSeconds)
	{
		long hours = timeInSeconds / 3600L;
		timeInSeconds -= hours * 3600L;
		long minutes = timeInSeconds / 60L;
		timeInSeconds -= minutes * 60L;
		long seconds = timeInSeconds;
		return (new StringBuilder(String.valueOf(hours))).append(" hour(s) ").append(minutes).append(" minute(s) ").append(seconds).append(" second(s)").toString();
	}
}
