// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   VData.java

package com.sinosoft.map.utility;

import java.util.Vector;

public class VData extends Vector
{

	private static final long serialVersionUID = 1L;

	public VData()
	{
	}

	public String encode()
	{
		String strReturn = "";
		return strReturn;
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
		iMax = size();
		try
		{
			for (i = cStartPos; i < iMax; i++)
			{
				if (get(i) == null)
					continue;
				tStr1 = get(i).getClass().getName().toUpperCase();
				tStr2 = cObjectName.toUpperCase();
				if (!tStr1.equals(tStr2) && !getLastWord(tStr1, ".").equals(tStr2))
					continue;
				tReturn = get(i);
				break;
			}

		}
		catch (Exception ex)
		{
			tReturn = null;
		}
		return tReturn;
	}

	public Object getObjectByObjectName(String cObjectName, int cStartPos, int cPos)
	{
		int i = 0;
		int j = 0;
		int iMax = 0;
		String tStr1 = "";
		String tStr2 = "";
		Object tReturn = null;
		if (cStartPos < 0)
			cStartPos = 0;
		iMax = size();
		try
		{
			for (i = cStartPos; i < iMax; i++)
			{
				if (get(i) == null)
					continue;
				tStr1 = get(i).getClass().getName().toUpperCase();
				tStr2 = cObjectName.toUpperCase();
				if (!tStr1.equals(tStr2) && !getLastWord(tStr1, ".").equals(tStr2) || ++j < cPos)
					continue;
				tReturn = get(i);
				break;
			}

		}
		catch (Exception ex)
		{
			tReturn = null;
		}
		return tReturn;
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

	public Object getObject(int cIndex)
	{
		Object tReturn = null;
		if (cIndex < 0)
			cIndex = 0;
		try
		{
			tReturn = get(cIndex);
		}
		catch (Exception ex)
		{
			tReturn = null;
		}
		return tReturn;
	}
}
