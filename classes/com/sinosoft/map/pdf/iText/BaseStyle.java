// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BaseStyle.java

package com.sinosoft.map.pdf.iText;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.sinosoft.map.utility.StaticConst;
import java.awt.Color;

public class BaseStyle
{

	static BaseFont bfChinese = StaticConst.getInstance().getFont("·ÂËÎ").getBaseFont();

	public BaseStyle()
	{
	}

	public static Font getH1()
	{
		return new Font(bfChinese, 20F, 0, Color.BLACK);
	}

	public static Font getH2()
	{
		return new Font(bfChinese, 15F, 0, Color.BLACK);
	}

	public static Font getH3()
	{
		return new Font(bfChinese, 10F, 0, Color.BLACK);
	}

	public static Font getTitle()
	{
		return new Font(bfChinese, 10F, 0, Color.BLACK);
	}

	public static Font getContext()
	{
		return new Font(bfChinese, 10F, 0, Color.BLACK);
	}

	public static Font getContext(String fontName)
	{
		BaseFont font = getBaseFont(fontName);
		return new Font(font, 10F, 0, Color.BLACK);
	}

	public static BaseFont getBaseFont(String font)
	{
		bfChinese = StaticConst.getInstance().getFont(font).getBaseFont();
		return bfChinese;
	}

}
