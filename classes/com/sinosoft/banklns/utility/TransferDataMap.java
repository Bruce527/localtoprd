// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TransferDataMap.java

package com.sinosoft.banklns.utility;

import java.io.PrintStream;
import java.util.*;

public class TransferDataMap extends TreeMap
{

	public TransferDataMap()
	{
	}

	public void setNameAndValue(Object name, Object value)
	{
		put(name, value);
	}

	public Object getValueByName(Object name)
	{
		if (name == null)
			return null;
		else
			return get(name);
	}

	public Object getNameByIndex(int index)
	{
		Set set = keySet();
		Iterator iterator = set.iterator();
		for (int i = 0; iterator.hasNext(); i++)
		{
			if (i == index)
				return iterator.next();
			iterator.next();
		}

		return null;
	}

	public Object getValueByIndex(int index)
	{
		Collection collection = values();
		Iterator iterator = collection.iterator();
		for (int i = 0; iterator.hasNext(); i++)
		{
			if (i == index)
				return iterator.next();
			iterator.next();
		}

		return null;
	}

	public int size()
	{
		return super.size();
	}

	public boolean removeValueByIndex(int index)
	{
		Object objectKey = getNameByIndex(index);
		Object check = remove(objectKey);
		if (check == null)
		{
			System.out.println("�Ƴ������Խ��?");
			return false;
		} else
		{
			return true;
		}
	}

	public boolean removeValueByName(Object name)
	{
		Object check = remove(name);
		if (check == null)
		{
			System.out.println("�Ƴ������Խ��?");
			return false;
		} else
		{
			return true;
		}
	}
}
