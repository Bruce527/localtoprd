// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XmlFun.java

package com.sinosoft.banklns.lis.pubfun;

import java.io.*;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlFun
{

	private static boolean firstLineFlag = true;
	public static int num = 0;

	public XmlFun()
	{
	}

	public static String getYearMonth(String value)
	{
		String tYearMonth = "";
		tYearMonth = value.substring(2, 6);
		return tYearMonth;
	}

	public static String getChinaLen(String value, String len)
	{
		int n = Integer.parseInt(len);
		char arr[] = value.toCharArray();
		int result = 0;
		for (int i = 0; i < n; i++)
			if (arr[i] > '\u01FF')
			{
				System.out.println(arr[i]);
				result++;
			}

		return (new StringBuilder(String.valueOf(result))).toString();
	}

	public static String getChinaLen(String value)
	{
		char arr[] = value.toCharArray();
		int result = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > '\u01FF')
			{
				System.out.println(arr[i]);
				result++;
			}

		return (new StringBuilder(String.valueOf(result))).toString();
	}

	public static int getChinaLength(String value)
	{
		char arr[] = value.toCharArray();
		int result = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > '\u01FF')
				result += 2;
			else
				result++;

		return result;
	}

	public static String getCurrentDate()
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		return df.format(today);
	}

	public static String getCurrentTime()
	{
		String pattern = "HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		return df.format(today);
	}

	public static void setFirstLine()
	{
		firstLineFlag = true;
	}

	public static boolean isFirstLine()
	{
		if (firstLineFlag)
		{
			firstLineFlag = false;
			return true;
		} else
		{
			return false;
		}
	}

	public static void displayDocument(Node d)
	{
		num += 2;
		if (d.hasChildNodes())
		{
			NodeList nl = d.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++)
			{
				Node n = nl.item(i);
				for (int j = 0; j < num; j++)
					System.out.print(" ");

				if (n.getNodeValue() == null)
					System.out.println((new StringBuilder("<")).append(n.getNodeName()).append(">").toString());
				else
					System.out.println(n.getNodeValue());
				displayDocument(n);
				num -= 2;
				if (n.getNodeValue() == null)
				{
					for (int j = 0; j < num; j++)
						System.out.print(" ");

					System.out.println((new StringBuilder("</")).append(n.getNodeName()).append(">").toString());
				}
			}

		}
	}

	public static void displayStream(InputStream in)
	{
		try
		{
			BufferedReader brin = new BufferedReader(new InputStreamReader(in));
			String s = "";
			System.out.println("");
			while ((s = brin.readLine()) != null) 
				System.out.println(s);
			System.out.println("");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void displayBlob(Blob blob)
	{
		try
		{
			InputStream in = blob.getBinaryStream();
			displayStream(in);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		System.out.println(getChinaLength("测试TSR3人200408月应付佣金"));
	}

}
