// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FontStyle.java

package com.sinosoft.map.style.xls;


public class FontStyle
{

	private String fontName;
	private int fontSize;

	public void setFontName(String name)
	{
		fontName = name;
	}

	public String getFontName()
	{
		return fontName;
	}

	public void setFontSize(int size)
	{
		fontSize = size;
	}

	public int getFontSize()
	{
		return fontSize;
	}

	public FontStyle()
	{
		fontName = "ËÎÌו";
		fontSize = 300;
	}
}
