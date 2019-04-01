// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ChgData.java

package com.sinosoft.banklns.utility;


public class ChgData
{

	public ChgData()
	{
	}

	public static String chgData(byte byteValue)
	{
		String strReturn = null;
		if (byteValue == 0)
			strReturn = "0";
		else
			strReturn = String.valueOf(byteValue);
		return strReturn;
	}

	public static String chgData(short shortValue)
	{
		String strReturn = null;
		if (shortValue == 0)
			strReturn = "0";
		else
			strReturn = String.valueOf(shortValue);
		return strReturn;
	}

	public static String chgData(int intValue)
	{
		String strReturn = null;
		if (intValue == 0)
			strReturn = "0";
		else
			strReturn = String.valueOf(intValue);
		return strReturn;
	}

	public static String chgData(long longValue)
	{
		String strReturn = null;
		if (longValue == 0L)
			strReturn = "0";
		else
			strReturn = String.valueOf(longValue);
		return strReturn;
	}

	public static String chgData(float floatValue)
	{
		String strReturn = null;
		if (floatValue == 0.0F)
			strReturn = "0";
		else
			strReturn = String.valueOf(floatValue);
		return strReturn;
	}

	public static String chgData(double doubleValue)
	{
		String strReturn = null;
		if (doubleValue == 0.0D)
			strReturn = "0";
		else
			strReturn = String.valueOf(doubleValue);
		return strReturn;
	}

	public static String chgNumericStr(String strValue)
	{
		if (strValue == null)
			return "0";
		if (strValue.trim() == "" || strValue.length() == 0)
			return "0";
		else
			return strValue;
	}

	public static String getBooleanDescribe(String strValue)
	{
		String strReturn = strValue;
		if (strValue.equals("Y") || strValue.equals("y"))
			strReturn = "��";
		else
		if (strValue.equals("N") || strValue.equals("n"))
			strReturn = "��";
		return strReturn;
	}
}
