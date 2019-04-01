// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   IndivSelect.java

package com.sinosoft.map.style.content;


public class IndivSelect
{

	private String CompanyInfo;
	private String GrpContNo;
	private int ColorR;
	private int ColorG;
	private int ColorB;
	private int Border;

	public IndivSelect()
	{
		CompanyInfo = "";
		GrpContNo = "";
		ColorR = 0;
		ColorG = 0;
		ColorB = 0;
		Border = 0;
	}

	public void setColorR(int r)
	{
		ColorR = r;
	}

	public void setColorG(int g)
	{
		ColorG = g;
	}

	public void setColorB(int b)
	{
		ColorB = b;
	}

	public int getColorR()
	{
		return ColorR;
	}

	public int getColorG()
	{
		return ColorG;
	}

	public int getColorB()
	{
		return ColorB;
	}

	public void setBorder(int border)
	{
		Border = border;
	}

	public int getBorder()
	{
		return Border;
	}

	public void setGrpContNo(String grpContNo)
	{
		GrpContNo = grpContNo;
	}

	public String getGrpContNo()
	{
		return GrpContNo;
	}

	public void setCompanyInfo(String info)
	{
		CompanyInfo = info;
	}

	public String getCompanyInfo()
	{
		return CompanyInfo;
	}
}
