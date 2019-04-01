// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FooterStyle.java

package com.sinosoft.map.style.pdf;


// Referenced classes of package com.sinosoft.map.style.pdf:
//			FontStyle

public class FooterStyle extends FontStyle
{

	public static final int CONTENT_NONE = 0;
	public static final int CONTENT_TEXT = 1;
	public static final int CONTENT_IMAGE = 2;
	private int align;
	private boolean numbered;
	private boolean restartNum;
	private int contentType;
	private int border;

	public FooterStyle()
	{
		align = 1;
		numbered = false;
		restartNum = true;
		contentType = 1;
		border = 0;
	}

	public void setAlign(int align)
	{
		this.align = align;
	}

	public int getAlign()
	{
		return align;
	}

	public void setNumbered(boolean numbered)
	{
		this.numbered = numbered;
	}

	public boolean getBumbered()
	{
		return numbered;
	}

	public void setBorder(int border)
	{
		this.border = border;
	}

	public int getBorder()
	{
		return border;
	}

	public void setRestart(boolean restartFlag)
	{
		restartNum = restartFlag;
	}

	public boolean isContinue()
	{
		return !restartNum;
	}

	public void setContentType(int type)
	{
		contentType = type;
	}

	public int getContentType()
	{
		return contentType;
	}
}
