// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TableBodyStyle.java

package com.sinosoft.map.style.rtf;


// Referenced classes of package com.sinosoft.map.style.rtf:
//			FontStyle

public class TableBodyStyle extends FontStyle
{

	private int align;
	private int R;
	private int G;
	private int B;

	public TableBodyStyle()
	{
		R = 255;
		G = 255;
		B = 255;
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
