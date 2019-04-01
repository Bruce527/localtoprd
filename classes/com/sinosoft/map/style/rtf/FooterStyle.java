// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FooterStyle.java

package com.sinosoft.map.style.rtf;


// Referenced classes of package com.sinosoft.map.style.rtf:
//			FontStyle

public class FooterStyle extends FontStyle
{

	private int align;
	private boolean numbered;
	private int border;

	public FooterStyle()
	{
		align = 1;
		numbered = false;
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
}
