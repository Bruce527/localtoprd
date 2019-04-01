// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMap.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.Schema;
import com.sinosoft.map.utility.SchemaSet;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MMap
{

	private HashMap mapV;
	private HashMap mapO;
	private int mRepeatCount;

	public MMap()
	{
		mapV = null;
		mapO = null;
		mRepeatCount = 0;
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

	public void put(Object key, Object value, boolean DiskFlag)
	{
		if (key == null || value == null)
			return;
		if (mapV.put(key, value) == null)
			mapO.put(String.valueOf(mapV.size()), key);
	}

	private SchemaSet cloneSchemSet(SchemaSet cOldSchemaSet)
	{
		String schemaSetName = cOldSchemaSet.getClass().getName();
		SchemaSet newSchemaSet;
		Class schemaSetClass = Class.forName(schemaSetName);
		newSchemaSet = (SchemaSet)schemaSetClass.newInstance();
		newSchemaSet.add(cOldSchemaSet);
		return newSchemaSet;
		ClassNotFoundException ex;
		ex;
		System.out.println((new StringBuilder("没有找到类")).append(schemaSetName).toString());
		ex.printStackTrace();
		return cOldSchemaSet;
		ex;
		System.out.println("无法Clone Schema");
		ex.printStackTrace();
		return cOldSchemaSet;
		ex;
		System.out.println("无法Clone Schema");
		ex.printStackTrace();
		return cOldSchemaSet;
	}

	private Schema cloneSchema(Schema cOldSchema)
	{
		String methodName;
		Class paramType[];
		Method method;
		methodName = "getSchema";
		paramType = new Class[0];
		method = null;
		Object args[];
		method = cOldSchema.getClass().getMethod(methodName, paramType);
		args = new Object[0];
		return (Schema)method.invoke(cOldSchema, args);
		NoSuchMethodException ex;
		ex;
		System.out.println("没有找到getSchema方法");
		ex.printStackTrace();
		return cOldSchema;
		ex;
		System.out.println("无法Clone Schema");
		ex.printStackTrace();
		return cOldSchema;
		ex;
		System.out.println("无法Clone Schema");
		ex.printStackTrace();
		return cOldSchema;
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

	public Object getObjectByObjectName(String cObjectName, int cStartPos)
	{
		int i = 0;
		int iMax = 0;
		String tStr1 = "";
		String tStr2 = "";
		Object tReturn = null;
		if (cStartPos < 0)
			cStartPos = 0;
		iMax = keySet().size();
		try
		{
			for (i = cStartPos; i < iMax; i++)
			{
				if (getOrder().get(String.valueOf(i + 1)) == null)
					continue;
				tStr1 = getOrder().get(String.valueOf(i + 1)).getClass().getName().toUpperCase();
				tStr2 = cObjectName.toUpperCase();
				if (!tStr1.equals(tStr2) && !getLastWord(tStr1, ".").equals(tStr2))
					continue;
				tReturn = getOrder().get(String.valueOf(i + 1));
				break;
			}

		}
		catch (Exception ex)
		{
			tReturn = null;
		}
		return tReturn;
	}

	public Object[] getAllObjectByObjectName(String cObjectName, int cStartPos)
	{
		int i = 0;
		int iMax = 0;
		String tStr1 = "";
		String tStr2 = "";
		ArrayList tReturn = new ArrayList();
		if (cStartPos < 0)
			cStartPos = 0;
		iMax = keySet().size();
		try
		{
			for (i = cStartPos; i < iMax; i++)
				if (getOrder().get(String.valueOf(i + 1)) != null)
				{
					tStr1 = getOrder().get(String.valueOf(i + 1)).getClass().getName().toUpperCase();
					tStr2 = cObjectName.toUpperCase();
					if (tStr1.equals(tStr2) || getLastWord(tStr1, ".").equals(tStr2))
						tReturn.add(getOrder().get(String.valueOf(i + 1)));
				}

		}
		catch (Exception ex)
		{
			tReturn = null;
		}
		return tReturn.toArray();
	}

	public void add(MMap srcMap, boolean DiskFlag)
	{
		if (srcMap == null)
			return;
		for (int i = 0; i < srcMap.keySet().size(); i++)
		{
			Object key = srcMap.getKeyByOrder(String.valueOf(i + 1));
			put(key, srcMap.get(key), DiskFlag);
		}

	}

	public String getLastWord(String cStr, String splitStr)
	{
		int tIndex = -1;
		int tIndexOld = -1;
		String tReturn = cStr;
		try
		{
			do
			{
				tIndex = tReturn.indexOf(splitStr, tIndex + 1);
				if (tIndex <= 0)
					break;
				tIndexOld = tIndex;
			} while (true);
			if (tIndexOld > 0)
				tReturn = cStr.substring(tIndexOld + 1, cStr.length());
			else
				tReturn = cStr;
		}
		catch (Exception ex)
		{
			tReturn = "";
		}
		return tReturn;
	}

	public int size()
	{
		return keySet().size();
	}

	public static void main(String args1[])
	{
	}
}
