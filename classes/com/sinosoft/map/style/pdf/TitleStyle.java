// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TitleStyle.java

package com.sinosoft.map.style.pdf;


// Referenced classes of package com.sinosoft.map.style.pdf:
//			FontStyle

public class TitleStyle extends FontStyle
{

	private float size;
	private float px;
	private float py;
	private int align;
	public static final int ALIGN_CENTER = 1;
	public static final int ALIGN_LEFT = 0;
	public static final int ALIGN_RIGHT = 2;

	public TitleStyle()
	{
		size = -1F;
		px = 0.0F;
		py = 0.0F;
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

	public void setPx(float px)
	{
		this.px = px;
	}

	public void setPy(float py)
	{
		this.py = py;
	}

	public float getPx()
	{
		return px;
	}

	public float getPy()
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
