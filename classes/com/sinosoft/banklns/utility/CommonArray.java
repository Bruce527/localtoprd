// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonArray.java

package com.sinosoft.banklns.utility;

import org.apache.log4j.Logger;

public final class CommonArray
{

	private static final Logger logger = Logger.getLogger(com/sinosoft/banklns/utility/CommonArray);

	public CommonArray()
	{
	}

	public static float[] stringToFloat(String strArray[])
	{
		float ftArray[] = new float[strArray.length];
		try
		{
			for (int i = 0; i < strArray.length; i++)
				ftArray[i] = Float.parseFloat(strArray[i]);

		}
		catch (Exception e)
		{
			logger.error("changetofloat(String[])", e);
			if (logger.isDebugEnabled())
				logger.debug("changetofloat(String[]) - end");
			return null;
		}
		if (logger.isDebugEnabled())
			logger.debug("changetofloat(String[]) - end");
		return ftArray;
	}

	public static int[] stringToInt(String strArray[])
	{
		int intArray[] = new int[strArray.length];
		try
		{
			for (int i = 0; i < strArray.length; i++)
				intArray[i] = Integer.parseInt(strArray[i]);

		}
		catch (Exception e)
		{
			logger.error("changetoInt(String[])", e);
			if (logger.isDebugEnabled())
				logger.debug("changetoInt(String[]) - end");
			return null;
		}
		if (logger.isDebugEnabled())
			logger.debug("changetoInt(String[]) - end");
		return intArray;
	}

}
