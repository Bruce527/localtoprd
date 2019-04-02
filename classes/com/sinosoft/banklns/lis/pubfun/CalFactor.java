// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CalFactor.java

package com.sinosoft.banklns.lis.pubfun;


public class CalFactor
{

	private String data1;
	private String data2;

	public CalFactor()
	{
	}

	public static void main(String args[])
	{
		CalFactor schema1 = new CalFactor();
	}

	public String getV(String FCode)
	{
		String strReturn = "";
		if (FCode.equals("保额"))
			strReturn = data1;
		if (FCode.equals("年龄"))
			strReturn = data2;
		return strReturn;
	}

	public boolean setV(String FCode, String FValue)
	{
		if (FCode.equals(""))
			return false;
		if (FCode.equals("保额"))
			if (FValue != null && !FValue.equals(""))
				data1 = FValue.trim();
			else
				data1 = null;
		if (FCode.equals("年龄"))
			if (FValue != null && !FValue.equals(""))
				data1 = FValue.trim();
			else
				data1 = null;
		return true;
	}
}
