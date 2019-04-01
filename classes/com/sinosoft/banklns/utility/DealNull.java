// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DealNull.java

package com.sinosoft.banklns.utility;

import java.io.PrintStream;

public class DealNull
{

	public DealNull()
	{
	}

	public static String nullToSpace(String strValue)
	{
		String returnValue;
		if (strValue == null)
			returnValue = "";
		else
			returnValue = strValue;
		return returnValue;
	}

	public static void main(String args[])
	{
		String aaa = null;
		String ccc = "1234567";
		DealNull tDealNull = new DealNull();
		System.out.println((new StringBuilder("aaa = ")).append(aaa).toString());
		System.out.println((new StringBuilder("ccc = ")).append(ccc).toString());
		System.out.println((new StringBuilder("new aaa")).append(nullToSpace(aaa)).toString());
		System.out.println((new StringBuilder("new ccc")).append(nullToSpace(ccc)).toString());
	}
}
