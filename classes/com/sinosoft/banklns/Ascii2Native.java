// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Ascii2Native.java

package com.sinosoft.banklns;

import java.io.*;

public class Ascii2Native
{

	private static String PREFIX = "\\u";

	public Ascii2Native()
	{
	}

	public static String native2Ascii(String str)
	{
		char chars[] = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chars.length; i++)
			sb.append(char2Ascii(chars[i]));

		return sb.toString();
	}

	private static String char2Ascii(char c)
	{
		if (c > '\377')
		{
			StringBuffer sb = new StringBuffer();
			sb.append(PREFIX);
			int code = c >> 8;
			String tmp = Integer.toHexString(code);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			code = c & 0xff;
			tmp = Integer.toHexString(code);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			return sb.toString();
		} else
		{
			return Character.toString(c);
		}
	}

	public static String ascii2Native(String str)
	{
		StringBuffer sb = new StringBuffer();
		int begin = 0;
		for (int index = str.indexOf(PREFIX); index != -1; index = str.indexOf(PREFIX, begin))
		{
			sb.append(str.substring(begin, index));
			sb.append(ascii2Char(str.substring(index, index + 6)));
			begin = index + 6;
		}

		sb.append(str.substring(begin));
		return sb.toString();
	}

	private static char ascii2Char(String str)
	{
		if (str.length() != 6)
			throw new IllegalArgumentException("Ascii string of a native character must be 6 character.");
		if (!PREFIX.equals(str.substring(0, 2)))
		{
			throw new IllegalArgumentException("Ascii string of a native character must start with \"\\u\".");
		} else
		{
			String tmp = str.substring(2, 4);
			int code = Integer.parseInt(tmp, 16) << 8;
			tmp = str.substring(4, 6);
			code += Integer.parseInt(tmp, 16);
			return (char)code;
		}
	}

	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			do
			{
				String str = br.readLine();
				System.out.println(ascii2Native(str));
				System.out.println(native2Ascii(str));
			} while (true);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
