// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   IGlobalInput.java

package com.sinosoft.banklns.lis.pubfun;


public class IGlobalInput
{

	public String Operator;
	public String ManageCom;
	public String ComCode;
	public String Lang;
	public String BranchType;
	public String OperType;
	public int PwdErrCount;
	public long LastLogoTime;
	public boolean logoflag;
	public boolean LNPEntry;
	public boolean LNPAudit;
	public boolean LNPQuery;
	public boolean LNPCancel;
	public String LNPRole;
	public String chanlesign;
	public String riskSaleGroup;

	public IGlobalInput()
	{
		logoflag = false;
		LNPEntry = false;
		LNPAudit = false;
		LNPQuery = false;
		LNPCancel = false;
		LNPRole = "";
	}

	public static void main(String args[])
	{
		IGlobalInput globalInput1 = new IGlobalInput();
	}

	public void setSchema(IGlobalInput cGlobalInput)
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
		BranchType = cGlobalInput.BranchType;
		OperType = cGlobalInput.OperType;
		LNPEntry = cGlobalInput.LNPEntry;
		LNPAudit = cGlobalInput.LNPAudit;
		LNPQuery = cGlobalInput.LNPQuery;
		LNPRole = cGlobalInput.LNPRole;
		LNPCancel = cGlobalInput.LNPCancel;
	}
}
