// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CodeJudge.java

package com.sinosoft.map.utility;


public class CodeJudge
{

	public CodeJudge()
	{
	}

	public static String getCodeType(String strCode)
	{
		if (strCode == null || strCode.equals(""))
			return "00";
		return strCode.substring(0, 2);
		Exception e;
		e;
		return "00";
	}

	public static boolean judgeCodeType(String strCode, String strType)
	{
		if (strCode == null || strCode.equals("") || strType == null || strType.equals(""))
			return false;
		if (getCodeType(strCode).compareTo(strType) == 0)
			return true;
		return false;
		Exception e;
		e;
		return false;
	}

	public static String getCodeType(String strCode, String strStart, String strLength)
	{
		if (strCode == null || strCode.equals(""))
			return "00";
		return strCode.substring(Integer.parseInt(strStart), Integer.parseInt(strStart) + Integer.parseInt(strLength));
		Exception e;
		e;
		return "00";
	}

	public static void main(String args1[])
	{
	}
}
