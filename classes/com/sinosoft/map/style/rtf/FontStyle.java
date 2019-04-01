// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FontStyle.java

package com.sinosoft.map.style.rtf;

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
	private int family;
	private float size;
	private int style;
	private Color color;
	private String familyName;

	public FontStyle()
	{
		family = -1;
		size = -1F;
		style = -1;
		color = null;
		familyName = "Comic Sans MS";
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
			this.style = getStyleValue(style);
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

	public String getFamilyName()
	{
		return familyName;
	}

	private int getStyleValue(int style)
	{
		switch (style)
		{
		case 1: // '\001'
			return 1;

		case 2: // '\002'
			return 2;
		}
		return 0;
	}
}
