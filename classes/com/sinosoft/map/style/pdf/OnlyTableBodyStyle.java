// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OnlyTableBodyStyle.java

package com.sinosoft.map.style.pdf;


// Referenced classes of package com.sinosoft.map.style.pdf:
//			TableBodyStyle

public class OnlyTableBodyStyle extends TableBodyStyle
{

	private float width;
	private int col;
	private int pad;
	private int spa;
	private int tablealign;
	private int fontName;

	public OnlyTableBodyStyle()
	{
		width = 100F;
		pad = 10;
		spa = 0;
		tablealign = 1;
		fontName = 0;
	}

	public void setWidth(float width)
	{
		this.width = width;
	}

	public float getWidth()
	{
		return width;
	}

	public void setCol(int col)
	{
		this.col = col;
	}

	public int getCol()
	{
		return col;
	}

	public void setPadding(int pad)
	{
		this.pad = pad;
	}

	public int getPadding()
	{
		return pad;
	}

	public void setSpacing(int spa)
	{
		this.spa = spa;
	}

	public int getSpacing()
	{
		return spa;
	}

	public void setTableAlign(int align)
	{
		tablealign = align;
	}

	public int getTableAlign()
	{
		return tablealign;
	}

	public void setFontName(int fontnmae)
	{
		fontName = fontnmae;
	}

	public int getFontName()
	{
		return fontName;
	}
}
