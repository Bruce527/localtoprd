// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DateConvert.java

package com.sinosoft.banklns.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConvert
{

	public DateConvert()
	{
	}

	public static Date utilDateToSql(java.util.Date utilDate)
	{
		return new Date(utilDate.getTime());
	}

	public static java.util.Date sqlDateToUtil(Date sqlDate)
	{
		return sqlDate;
	}

	public static String dateToStr(java.util.Date utilDate)
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		String returnDate = df.format(utilDate);
		return returnDate;
	}

	public static String StrToStr(String utilDate)
	{
		if (utilDate != null)
			utilDate = utilDate.substring(0, 10);
		String returnDate = utilDate;
		return returnDate;
	}

	public static java.util.Date strToDate(String dateStr)
	{
		java.util.Date date = null;
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try
		{
			date = df.parse(dateStr);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			throw new RuntimeException((new StringBuilder("�ַ�")).append(dateStr).append("����Ϊ���ڴ���").toString(), e);
		}
		return date;
	}
}
