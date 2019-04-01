// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OccupBean.java

package com.sinosoft.banklns.lis.tree;


public class OccupBean
{

	String code;
	String name;
	String type;
	String hiRate;
	String paRate;
	String wpRate;

	public OccupBean()
	{
		code = "";
		name = "";
		type = "";
		hiRate = "";
		paRate = "";
		wpRate = "";
	}

	public String getHiRate()
	{
		return hiRate;
	}

	public void setHiRate(String hiRate)
	{
		this.hiRate = hiRate;
	}

	public String getPaRate()
	{
		return paRate;
	}

	public void setPaRate(String paRate)
	{
		this.paRate = paRate;
	}

	public String getWpRate()
	{
		return wpRate;
	}

	public void setWpRate(String wpRate)
	{
		this.wpRate = wpRate;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getType()
	{
		return type;
	}
}
