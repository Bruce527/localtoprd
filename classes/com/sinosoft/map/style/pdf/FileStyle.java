// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FileStyle.java

package com.sinosoft.map.style.pdf;

import com.lowagie.text.Rectangle;

public class FileStyle
{

	private float margin_left;
	private float margin_right;
	private float margin_top;
	private float margin_bottom;
	private float ratio;
	private float points;
	private Rectangle rect;
	private String password;
	private boolean havePassword;
	private boolean isAllowCopy;
	private boolean isAllowPrint;
	private boolean headerOrFooterInFirst;

	public FileStyle()
	{
		margin_left = 1.95F;
		margin_right = 1.95F;
		margin_top = 1.95F;
		margin_bottom = 0.75F;
		ratio = 2.54F;
		points = 72F;
		password = null;
		havePassword = false;
		isAllowCopy = false;
		isAllowPrint = true;
		headerOrFooterInFirst = false;
	}

	public void setMarginLeft(float ml)
	{
		margin_left = ml;
	}

	public void setMarginRight(float mr)
	{
		margin_right = mr;
	}

	public void setMarginTop(float mt)
	{
		margin_top = mt;
	}

	public void setMarginBottom(float mb)
	{
		margin_bottom = mb;
	}

	public float getMarginLeft()
	{
		return (margin_left * points) / ratio;
	}

	public float getMarginRight()
	{
		return (margin_right * points) / ratio;
	}

	public float getMarginTop()
	{
		return (margin_top * points) / ratio;
	}

	public float getMarginBottom()
	{
		return (margin_bottom * points) / ratio;
	}

	public void setPageSize(Rectangle rect)
	{
		this.rect = rect;
	}

	public Rectangle getPageSize()
	{
		return rect;
	}

	public void setPassword(String password)
	{
		this.password = password;
		havePassword = true;
	}

	public boolean isHavaPassword()
	{
		return havePassword;
	}

	public String getPassword()
	{
		return password;
	}

	public void setAllowPrint(boolean allowPrint)
	{
		isAllowPrint = allowPrint;
	}

	public boolean isAllowPrint()
	{
		return isAllowPrint;
	}

	public void setAllowCopy(boolean allowCopy)
	{
		isAllowCopy = allowCopy;
	}

	public boolean isAllowCopy()
	{
		return isAllowCopy;
	}

	public void setHeaderOrFooterInFirstPage(boolean inFirst)
	{
		headerOrFooterInFirst = inFirst;
	}

	public boolean isHeaderOrFooterInFirstPage()
	{
		return headerOrFooterInFirst;
	}
}
