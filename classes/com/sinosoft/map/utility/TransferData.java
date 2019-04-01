// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TransferData.java

package com.sinosoft.map.utility;

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

	public void setNameAndValue(Object name, Object value)
	{
		nameVData.add(name);
		valueVData.add(value);
	}

	public void setNameAndValue(Object name, float value)
	{
		nameVData.add(name);
		valueVData.add(new Float(value));
	}

	public void setNameAndValue(Object name, double value)
	{
		nameVData.add(name);
		valueVData.add(new Double(value));
	}

	public void setNameAndValue(Object name, int value)
	{
		nameVData.add(name);
		valueVData.add(new Integer(value));
	}

	public Object getValueByName(Object name)
	{
		for (int i = 0; i < nameVData.size(); i++)
			if (nameVData.elementAt(i).equals(name))
				return valueVData.get(i);

		return null;
	}

	public int findIndexByName(Object name)
	{
		for (int i = 0; i < nameVData.size(); i++)
			if (nameVData.elementAt(i).equals(name))
				return i;

		return -1;
	}

	public boolean removeByName(Object name)
	{
		for (int i = 0; i < nameVData.size(); i++)
			if (nameVData.elementAt(i).equals(name))
			{
				valueVData.remove(i);
				nameVData.remove(i);
			}

		return true;
	}

	public Vector getValueNames()
	{
		return nameVData;
	}

	public static void main(String args1[])
	{
	}
}
