// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TransferData.java

package com.sinosoft.banklns.utility;

import java.io.PrintStream;
import java.util.Vector;

public class TransferData
{

	private Vector nameVData;
	private Vector valueVData;

	public TransferData()
	{
		nameVData = new Vector();
		valueVData = new Vector();
	}

	public static void main(String args[])
	{
		TransferData transferData1 = new TransferData();
		System.out.println(transferData1.size());
		transferData1.setNameAndValue("int", 200);
		Integer value = (Integer)transferData1.getValueByName("int");
		System.out.println((new StringBuilder("value:")).append(value).toString());
		System.out.println(transferData1.size());
		TransferData test1 = transferData1;
		Integer value2 = (Integer)transferData1.getValueByIndex(1);
		System.out.println((new StringBuilder("value2:")).append(value2).toString());
	}

	public void setNameAndValue(Object name, Object value)
	{
		int index = getIndexByName(name);
		if (index >= 0)
		{
			valueVData.remove(index);
			valueVData.insertElementAt(value, index);
		} else
		{
			nameVData.add(name);
			valueVData.add(value);
		}
	}

	public void setNameAndValue(Object name, float value)
	{
		setNameAndValue(name, new Float(value));
	}

	public void setNameAndValue(Object name, double value)
	{
		setNameAndValue(name, new Double(value));
	}

	public void setNameAndValue(Object name, int value)
	{
		setNameAndValue(name, new Integer(value));
	}

	public Object getValueByName(Object name)
	{
		int index = getIndexByName(name);
		if (index < 0)
			return null;
		else
			return valueVData.get(index);
	}

	public Object getNameByIndex(int index)
	{
		if (index == 0)
			return null;
		if (index <= nameVData.size())
			return nameVData.get(index - 1);
		else
			return null;
	}

	public Object getValueByIndex(int index)
	{
		if (index == 0)
			return null;
		if (index <= valueVData.size())
			return valueVData.get(index - 1);
		else
			return null;
	}

	public int size()
	{
		return valueVData.size();
	}

	public boolean removeValueByIndex(int index)
	{
		if (nameVData.size() < index || index == 0)
		{
			System.out.println("�Ƴ������Խ��?");
			return false;
		} else
		{
			nameVData.remove(index);
			valueVData.remove(index);
			return true;
		}
	}

	public boolean removeValueByName(String name)
	{
		int index = getIndexByName(name);
		if (index < 0)
		{
			return false;
		} else
		{
			nameVData.remove(index);
			valueVData.remove(index);
			return true;
		}
	}

	private int getIndexByName(Object name)
	{
		for (int i = 0; i < nameVData.size(); i++)
			if (nameVData.elementAt(i).equals(name))
				return i;

		return -1;
	}
}
