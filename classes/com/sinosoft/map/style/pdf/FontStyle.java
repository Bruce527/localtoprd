// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FontStyle.java

package com.sinosoft.map.style.pdf;

import java.awt.Color;

public class FontStyle
{

	public static final int COURIER = 0;
	public static final int HELVETICA = 1;
	public static final int TIMES_ROMAN = 2;
	public static final int SYMBOL = 3;
	public static final int ZAPFDINGBATS = 4;
	public static final int NORMAL = 0;
	public static final int BOLD = 1;
	public static final int ITALIC = 2;
	public static final int UNDERLINE = 4;
	public static final int STRIKETHRU = 8;
	public static final int BOLDITALIC = 3;
	public static final int UNDEFINED = -1;
	public static final int DEFAULTSIZE = 12;
	public static final int 5B8B4F53 = 0;
	public static final int 4EFF5B8B = 1;
	public static final int 69774F53 = 2;
	public static final int 9ED14F53 = 3;
	public static final int Arial = 4;
	public static final int Arial_BOLD = 5;
	public static final int Arial_ITALIC = 6;
	public static final int Arial_BOLDITALIC = 7;
	public static final int TAHOMA = 8;
	private int family;
	private float size;
	private int style;
	private Color color;
	private int fontName;

	public FontStyle()
	{
		family = -1;
		size = -1F;
		style = -1;
		color = null;
		fontName = 0;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public void setColor(int red, int green, int blue)
	{
		color = new Color(red, green, blue);
	}

	public void setSize(float size)
	{
		this.size = size;
	}

	public void setStyle(int style)
	{
		if (style == -1)
			this.style = 0;
		else
			this.style = style;
	}

	public int getStyle()
	{
		return style;
	}

	public float getSize()
	{
		return size;
	}

	public Color getColor()
	{
		return color;
	}

	public void setFontName(int fontName)
	{
		this.fontName = fontName;
	}

	public int getFontName()
	{
		return fontName;
	}
}
