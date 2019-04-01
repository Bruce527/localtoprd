// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TextStyle.java

package com.sinosoft.map.style.pdf;


// Referenced classes of package com.sinosoft.map.style.pdf:
//			FontStyle

public class TextStyle extends FontStyle
{

	private int align;
	private float leading;
	private boolean isAlone;
	private boolean isStart;
	private boolean isEnd;

	public TextStyle()
	{
		align = 0;
		leading = 0.0F;
		isAlone = true;
		isStart = true;
		isEnd = true;
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

	public boolean isAlone()
	{
		return isAlone;
	}

	public void setAlone(boolean isAlone)
	{
		this.isAlone = isAlone;
	}

	public boolean isEnd()
	{
		return isEnd;
	}

	public void setEnd(boolean isEnd)
	{
		this.isEnd = isEnd;
	}

	public boolean isStart()
	{
		return isStart;
	}

	public void setStart(boolean isStart)
	{
		this.isStart = isStart;
	}
}
