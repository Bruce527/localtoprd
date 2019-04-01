// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Header.java

package com.sinosoft.map.utility;


public class Header
{

	private String name;
	private int col;
	private int row;
	private int order;
	private int wsorder;
	private int excit;
	private int parentIndex;
	private String codeName;

	public Header()
	{
		excit = 0;
		parentIndex = -1;
	}

	public String getCodeName()
	{
		return codeName;
	}

	public void setCodeName(String codeName)
	{
		this.codeName = codeName;
	}

	public int getCol()
	{
		return col;
	}

	public void setCol(int col)
	{
		this.col = col;
	}

	public int isExcit()
	{
		return excit;
	}

	public void setExcit(int excit)
	{
		this.excit = excit;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getOrder()
	{
		return order;
	}

	public void setOrder(int order)
	{
		this.order = order;
	}

	public int getParentIndex()
	{
		return parentIndex;
	}

	public void setParentIndex(int parentIndex)
	{
		this.parentIndex = parentIndex;
	}

	public int getRow()
	{
		return row;
	}

	public void setRow(int row)
	{
		this.row = row;
	}

	public int getExcit()
	{
		return excit;
	}

	public int getWsorder()
	{
		return wsorder;
	}

	public void setWsorder(int wsorder)
	{
		this.wsorder = wsorder;
	}
}
