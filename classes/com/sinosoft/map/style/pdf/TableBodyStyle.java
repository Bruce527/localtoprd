// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TableBodyStyle.java

package com.sinosoft.map.style.pdf;


// Referenced classes of package com.sinosoft.map.style.pdf:
//			FontStyle

public class TableBodyStyle extends FontStyle
{

	private int align;
	private int border;
	private int R;
	private int G;
	private int B;
	private int bodyType;
	private boolean isPdfpTable;
	private boolean hasHead;
	private float pad;
	private float widths[];

	public TableBodyStyle()
	{
		border = 15;
		R = 255;
		G = 255;
		B = 255;
		bodyType = 0;
		isPdfpTable = false;
		hasHead = true;
	}

	public void setBorder(int border)
	{
		this.border = border;
	}

	public int getBorder()
	{
		return border;
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

	public void setBodyType(int bodytype)
	{
		bodyType = bodytype;
	}

	public int getBodyType()
	{
		return bodyType;
	}

	public void setUsePdfPTable(boolean pdfpTable)
	{
		isPdfpTable = pdfpTable;
	}

	public boolean isUsePdfPTable()
	{
		return isPdfpTable;
	}

	public boolean isHasHead()
	{
		return hasHead;
	}

	public void setHasHead(boolean hasHead)
	{
		this.hasHead = hasHead;
	}

	public float[] getWidths()
	{
		return widths;
	}

	public void setWidths(float widths[])
	{
		this.widths = widths;
	}

	public float getPad()
	{
		return pad;
	}

	public void setPad(float pad)
	{
		this.pad = pad;
	}
}
