// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ListTable.java

package com.sinosoft.banklns.utility;

import java.util.Vector;

public class ListTable
{

	private Vector myVector;
	private int col;
	private String name;

	public ListTable()
	{
		myVector = new Vector();
	}

	public void add(String temparray[])
	{
		myVector.addElement(temparray);
	}

	public String getValue(int column, int row)
	{
		String temparray[] = new String[column];
		temparray = (String[])myVector.get(row);
		return temparray[column];
	}

	public String[] get(int i)
	{
		return (String[])myVector.get(i);
	}

	public int size()
	{
		return myVector.size();
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public int getCol()
	{
		return col;
	}
}
