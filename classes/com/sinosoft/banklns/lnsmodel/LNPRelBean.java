// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRelBean.java

package com.sinosoft.banklns.lnsmodel;


public class LNPRelBean
{

	private String contno;
	private boolean readflag;
	private String display;

	public LNPRelBean()
	{
	}

	public String getContno()
	{
		return contno;
	}

	public void setContno(String contno)
	{
		this.contno = contno;
	}

	public boolean isReadflag()
	{
		return readflag;
	}

	public void setReadflag(boolean readflag)
	{
		this.readflag = readflag;
	}

	public String getDisplay()
	{
		return display;
	}

	public void setDisplay(String display)
	{
		this.display = display;
	}
}
