// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   StyleSelect.java

package com.sinosoft.map.style.content;


public class StyleSelect
{

	private String YeMei;
	private float MargnLeft;
	private float MargnRight;
	private float MargnTop;
	private float MargnBottom;
	private String FengMian;
	private String YeJiao;
	private String PageSize;
	private String Model;
	private String SugCode;
	private String SugModelCode;
	private String FengDi;

	public StyleSelect()
	{
		YeMei = "";
		MargnLeft = 1.5F;
		MargnRight = 1.5F;
		MargnTop = 1.95F;
		MargnBottom = 0.75F;
		FengMian = "";
		YeJiao = "";
		PageSize = "A4";
		Model = "";
		SugCode = "0000000101";
		SugModelCode = "";
		FengDi = "";
	}

	public void setYeMei(String yeMei)
	{
		YeMei = yeMei;
	}

	public void setYeJiao(String yeJiao)
	{
		YeJiao = yeJiao;
	}

	public void setPageSize(String pageSize)
	{
		PageSize = pageSize;
	}

	public void setModel(String model)
	{
		Model = model;
	}

	public void setMargnLeft(float left)
	{
		MargnLeft = left;
	}

	public void setMargnRight(float right)
	{
		MargnRight = right;
	}

	public void setMargnTop(float top)
	{
		MargnTop = top;
	}

	public void setMargnBottom(float bottom)
	{
		MargnBottom = bottom;
	}

	public void setFengMian(String fengmian)
	{
		FengMian = fengmian;
	}

	public void setFengDi(String fengdi)
	{
		FengDi = fengdi;
	}

	public String getYeMei()
	{
		return YeMei;
	}

	public String getYeJiao()
	{
		return YeJiao;
	}

	public String getPageSize()
	{
		return PageSize;
	}

	public String getModel()
	{
		return Model;
	}

	public float getMargnLeft()
	{
		return MargnLeft;
	}

	public float getMargnRight()
	{
		return MargnRight;
	}

	public float getMargnTop()
	{
		return MargnTop;
	}

	public float getMargnBottom()
	{
		return MargnBottom;
	}

	public void setSugCode(String sugCode)
	{
		SugCode = sugCode;
	}

	public String getSugCode()
	{
		return SugCode;
	}

	public void setSugModelCode(String sugModelCode)
	{
		SugModelCode = sugModelCode;
	}

	public String getSugModelCode()
	{
		return SugModelCode;
	}

	public String getFengMian()
	{
		return FengMian;
	}

	public String getFengDi()
	{
		return FengDi;
	}
}
