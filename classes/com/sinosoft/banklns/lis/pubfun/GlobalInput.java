// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GlobalInput.java

package com.sinosoft.banklns.lis.pubfun;


public class GlobalInput
{

	public String Operator;
	public String ManageCom;
	public String ComCode;
	public String Lang;
	public int PwdErrCount;
	public long LastLogoTime;
	public boolean logoflag;
	public String chanlesign;
	public String riskSaleGroup;

	public GlobalInput()
	{
		logoflag = false;
	}

	public static void main(String args[])
	{
		GlobalInput globalInput1 = new GlobalInput();
	}

	public void setSchema(GlobalInput cGlobalInput)
	{
		Operator = cGlobalInput.Operator;
		ComCode = cGlobalInput.ComCode;
		ManageCom = cGlobalInput.ManageCom;
		Lang = cGlobalInput.Lang;
		PwdErrCount = cGlobalInput.PwdErrCount;
		LastLogoTime = cGlobalInput.LastLogoTime;
		logoflag = cGlobalInput.logoflag;
		chanlesign = cGlobalInput.chanlesign;
		riskSaleGroup = cGlobalInput.riskSaleGroup;
	}
}
