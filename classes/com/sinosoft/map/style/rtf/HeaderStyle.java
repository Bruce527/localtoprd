// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HeaderStyle.java

package com.sinosoft.map.style.rtf;


// Referenced classes of package com.sinosoft.map.style.rtf:
//			FontStyle

public class HeaderStyle extends FontStyle
{

	private int align;
	private float leading;
	private boolean numbered;

	public HeaderStyle()
	{
		align = 1;
		leading = (0.0F / 0.0F);
		numbered = false;
	}

	public void setAlign(int align)
	{
		this.align = align;
	}

	public int getAlign()
	{
		return align;
	}

	public void setLeading(float leading)
	{
		this.leading = leading;
	}

	public float getLeading()
	{
		return leading;
	}

	public void setNumbered(boolean numbered)
	{
		this.numbered = numbered;
	}

	public boolean getBumbered()
	{
		return numbered;
	}
}
