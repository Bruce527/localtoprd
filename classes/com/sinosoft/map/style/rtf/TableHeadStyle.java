// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TableHeadStyle.java

package com.sinosoft.map.style.rtf;


// Referenced classes of package com.sinosoft.map.style.rtf:
//			FontStyle

public class TableHeadStyle extends FontStyle
{

	private float c[];
	private float width;
	private int col;
	private int border;
	private int pad;
	private int spa;
	private int align;
	private int R;
	private int G;
	private int B;

	public TableHeadStyle()
	{
		border = 1;
		pad = 1;
		spa = 1;
		align = 1;
		R = 255;
		G = 255;
		B = 255;
	}

	public void setWidths(float c[])
	{
		this.c = c;
	}

	public float[] getWidths()
	{
		return c;
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

	public void setBorder(int boder)
	{
		border = border;
	}

	public int getBorder()
	{
		return border;
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

	public void setAlign(int align)
	{
		this.align = align;
	}

	public int getAlign()
	{
		return align;
	}

	public void setR(int R)
	{
		this.R = R;
	}

	public int getR()
	{
		return R;
	}

	public void setG(int G)
	{
		this.G = G;
	}

	public int getG()
	{
		return G;
	}

	public void setB(int B)
	{
		this.B = B;
	}

	public int getB()
	{
		return B;
	}
}
