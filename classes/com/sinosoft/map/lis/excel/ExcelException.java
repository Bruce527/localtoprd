// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExcelException.java

package com.sinosoft.map.lis.excel;


class ExcelException extends Exception
{

	private static final long serialVersionUID = 0xfa3b106abe8bfd97L;

	public ExcelException(Exception e)
	{
		super(e.getMessage());
	}

	public ExcelException(String message)
	{
		super(message);
	}
}
