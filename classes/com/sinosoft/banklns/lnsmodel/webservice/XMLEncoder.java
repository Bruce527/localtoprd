// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLEncoder.java

package com.sinosoft.banklns.lnsmodel.webservice;

import java.io.CharArrayReader;
import java.io.PrintStream;

public class XMLEncoder
{

	public static final int ENCODE_QUOT = 1;
	public static int ENCODE_128 = 2;
	private String Version;

	public XMLEncoder()
	{
	}

	public String getVersion()
	{
		return Version;
	}

	public static String toDecode(String toConvert)
	{
		String aux = null;
		String aux2 = null;
		if (toConvert != null)
		{
			toConvert = toConvert.trim();
			StringBuffer buffer = new StringBuffer();
			try
			{
				do
				{
					if (toConvert.length() <= 0)
						break;
					aux = toConvert.substring(0, 1);
					if (toConvert.length() > 1)
						aux2 = toConvert.substring(1, 2);
					if (!"%u".equals((new StringBuilder(String.valueOf(aux))).append(aux2).toString()) || toConvert.length() < 6)
					{
						buffer.append(toConvert.substring(toConvert.indexOf(aux), 1));
						toConvert = toConvert.substring(toConvert.indexOf(aux) + 1, toConvert.length());
					} else
					{
						int ind = toConvert.indexOf("%");
						int ind2 = toConvert.indexOf("u", ind);
						if (ind2 < 1)
							buffer.append(toConvert.substring(0, ind2 + 1));
						else
							try
							{
								ind2 = ind2 == 1 ? ind + 6 : ind + 3;
								String carac = toConvert.substring(ind + 1, ind2).replace('u', ' ').trim();
								carac = carac.equals("3000") ? "0020" : carac;
								if (carac.trim().length() < 4)
									throw new NumberFormatException();
								char c = (char)Integer.parseInt(carac, 16);
								toConvert = toConvert.substring(ind2, toConvert.length());
								buffer.append(c);
								ind = toConvert.indexOf("%");
								if (ind > 0)
								{
									buffer.append(toConvert.substring(0, ind));
									toConvert = toConvert.substring(ind, toConvert.length());
									ind = toConvert.indexOf("%");
								}
							}
							catch (NumberFormatException e)
							{
								buffer.append(toConvert.substring(toConvert.indexOf(aux), 1));
								toConvert = toConvert.substring(toConvert.indexOf(aux) + 1, toConvert.length());
							}
					}
				} while (true);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return buffer.toString().trim();
		} else
		{
			return null;
		}
	}

	public static String toUnicode(String toConvert)
	{
		if (toConvert != null)
		{
			StringBuffer buffer = new StringBuffer();
			try
			{
				CharArrayReader in = new CharArrayReader(toConvert.toCharArray());
				int ch;
				while ((ch = in.read()) > -1) 
				{
					String hex = Integer.toHexString(ch);
					if (hex.length() == 4)
					{
						hex = hex.equals("3000") ? "0020" : hex;
						buffer.append((new StringBuilder("%u")).append(hex).toString());
					} else
					{
						buffer.append((char)ch);
					}
				}
				in.close();
			}
			catch (Exception e)
			{
				System.out.println((new StringBuilder("TMAEncoder - TMAEncoder.toUnicode - Error: ")).append(e.getMessage()).toString());
			}
			String converted = buffer.toString();
			return converted;
		} else
		{
			return null;
		}
	}

	public static String XMLencode(String raw, int flags)
	{
		int len = raw.length();
		StringBuffer cooked = new StringBuffer(raw.length());
		for (int i = 0; i < len; i++)
		{
			char c = raw.charAt(i);
			switch (c)
			{
			case 60: // '<'
				cooked.append("&lt;");
				break;

			case 62: // '>'
				cooked.append("&gt;");
				break;

			case 38: // '&'
				cooked.append("&amp;");
				break;

			case 39: // '\''
				cooked.append("&apos;");
				break;

			case 34: // '"'
				if ((flags & 1) != 0)
					cooked.append("&quot;");
				else
					cooked.append('"');
				break;

			default:
				if (c >= '\200' && (flags & ENCODE_128) != 0)
					cooked.append((new StringBuilder("&#")).append(c).append(";").toString());
				else
					cooked.append(c);
				break;
			}
		}

		return cooked.toString();
	}

	public static String XMLDecode(String raw, int flags)
	{
		int len = raw.length();
		StringBuffer cooked = new StringBuffer(raw.length());
		for (int i = 0; i < len; i++)
		{
			char c = raw.charAt(i);
			switch (c)
			{
			case 60: // '<'
				cooked.append("&lt;");
				break;

			case 62: // '>'
				cooked.append("&gt;");
				break;

			case 38: // '&'
				cooked.append("&amp;");
				break;

			case 39: // '\''
				cooked.append("&apos;");
				break;

			case 34: // '"'
				if ((flags & 1) != 0)
					cooked.append("&quot;");
				else
					cooked.append('"');
				break;

			default:
				if (c >= '\200' && (flags & ENCODE_128) != 0)
					cooked.append((new StringBuilder("&#")).append(c).append(";").toString());
				else
					cooked.append(c);
				break;
			}
		}

		return cooked.toString();
	}

}
