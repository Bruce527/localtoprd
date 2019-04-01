// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FNAStrTool.java

package com.sinosoft.banklns.utility;


// Referenced classes of package com.sinosoft.banklns.utility:
//			StrTool

public class FNAStrTool extends StrTool
{

	public FNAStrTool()
	{
	}

	public static String toHTMLFormat(String strInValue)
	{
		String strOutValue = "";
		for (int i = 0; i < strInValue.length(); i++)
		{
			char c = strInValue.charAt(i);
			switch (c)
			{
			case 10: // '\n'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("<BR>").toString();
				break;

			case 32: // ' '
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("&nbsp;").toString();
				break;

			default:
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append(c).toString();
				break;

			case 13: // '\r'
				break;
			}
		}

		return strOutValue;
	}
}
