// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TitleStyle.java

package com.sinosoft.map.style.rtf;


// Referenced classes of package com.sinosoft.map.style.rtf:
//			FontStyle

public class TitleStyle extends FontStyle
{

	private float size;
	private int px;
	private int py;
	private int align;
	public static final int ALIGN_CENTER = 1;
	public static final int ALIGN_LEFT = 0;
	public static final int ALIGN_RIGHT = 2;

	public TitleStyle()
	{
		size = -1F;
		px = 0;
		py = 0;
		align = 0;
	}

	public void setSize(float size)
	{
		this.size = size;
	}

	public float getSize()
	{
		return size;
	}

	public void setPx(int px)
	{
		this.px = px;
	}

	public void setPy(int py)
	{
		this.py = py;
	}

	public int getPx()
	{
		return px;
	}

	public int getPy()
	{
		return py;
	}

	public void setAlign(int align)
	{
		this.align = align;
	}

	public int getAlign()
	{
		return align;
	}
}
