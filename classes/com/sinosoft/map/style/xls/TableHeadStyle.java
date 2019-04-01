// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TableHeadStyle.java

package com.sinosoft.map.style.xls;


// Referenced classes of package com.sinosoft.map.style.xls:
//			FontStyle

public class TableHeadStyle extends FontStyle
{

	private int c[];
	private int col;

	public TableHeadStyle()
	{
	}

	public void setWidths(int c[])
	{
		this.c = c;
	}

	public int[] getWidths()
	{
		return c;
	}

	public void setCol(int col)
	{
		this.col = col;
	}

	public int getCol()
	{
		return col;
	}
}
