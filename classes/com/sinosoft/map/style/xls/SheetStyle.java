// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SheetStyle.java

package com.sinosoft.map.style.xls;


// Referenced classes of package com.sinosoft.map.style.xls:
//			FontStyle

public class SheetStyle extends FontStyle
{

	private String sheetName;
	private int sheetNo;

	public SheetStyle()
	{
		sheetName = "";
		sheetNo = 0;
	}

	public void setSheetName(String name)
	{
		sheetName = name;
	}

	public String getSheetName()
	{
		return sheetName;
	}

	public void setSheetNo(int no)
	{
		sheetNo = no;
	}

	public int getSheetNo()
	{
		return sheetNo;
	}
}
