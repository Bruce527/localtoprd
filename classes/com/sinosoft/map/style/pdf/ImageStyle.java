// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ImageStyle.java

package com.sinosoft.map.style.pdf;


public class ImageStyle
{

	public static final int ALIGN_CENTER = 1;
	public static final int ALIGN_LEFT = 0;
	public static final int ALIGN_RIGHT = 2;
	public static final int ALIGN_TOP = 4;
	public static final int ALIGN_BOTTOM = 6;
	private String type;
	private int align;
	private float size;
	private float px;
	private float py;
	private boolean absolute;
	private boolean isAlone;

	public ImageStyle()
	{
		type = "";
		align = 0;
		absolute = true;
		isAlone = true;
	}

	public void setImageType(String type)
	{
		this.type = type;
	}

	public String getImageType()
	{
		return type;
	}

	public void setAlign(int align)
	{
		this.align = align;
	}

	public int getAlign()
	{
		return align;
	}

	public void setPx(float px)
	{
		this.px = px;
		absolute = true;
	}

	public void setPy(float py)
	{
		this.py = py;
		absolute = true;
	}

	public float getPx()
	{
		return px;
	}

	public float getPy()
	{
		return py;
	}

	public void setScalePercent(float size)
	{
		this.size = size;
	}

	public float getScalePercent()
	{
		return size;
	}

	public boolean getAbsolute()
	{
		return absolute;
	}

	public boolean isAlone()
	{
		return isAlone;
	}

	public void setAlone(boolean isAlone)
	{
		this.isAlone = isAlone;
	}

	public void setAbsolute(boolean absolute)
	{
		this.absolute = absolute;
	}
}
