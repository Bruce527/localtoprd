// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMap.java

package com.sinosoft.banklns.lis.pubfun;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Set;

public class MMap
{

	private HashMap mapV;
	private HashMap mapO;

	public MMap()
	{
		mapV = null;
		mapO = null;
		mapV = new HashMap();
		mapO = new HashMap();
	}

	public void put(Object key, Object value)
	{
		if (key == null || value == null)
		{
			return;
		} else
		{
			mapV.put(key, value);
			mapO.put(String.valueOf(mapV.size()), key);
			return;
		}
	}

	public Set keySet()
	{
		return mapV.keySet();
	}

	public Object get(Object key)
	{
		return mapV.get(key);
	}

	public HashMap getOrder()
	{
		return mapO;
	}

	public Object getKeyByOrder(String order)
	{
		return mapO.get(order);
	}

	public void add(MMap srcMap)
	{
		if (srcMap == null)
			return;
		for (int i = 0; i < srcMap.keySet().size(); i++)
		{
			Object key = srcMap.getKeyByOrder(String.valueOf(i + 1));
			put(key, srcMap.get(key));
		}

	}

	public static void main(String args[])
	{
		MMap amap = new MMap();
		amap.put("key1", "value1");
		amap.put("key2", "value2");
		MMap bmap = new MMap();
		bmap.put("keyb1", "valueb1");
		bmap.put("keyb2", "valueb2");
		amap.add(bmap);
		for (int i = 0; i < amap.keySet().size(); i++)
		{
			Object key = amap.getKeyByOrder(String.valueOf(i + 1));
			System.out.println(amap.get(key).toString());
		}

	}
}
