// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FileStyle.java

package com.sinosoft.map.style.xls;

import com.sinosoft.map.utility.VData;

// Referenced classes of package com.sinosoft.map.style.xls:
//			FontStyle

public class FileStyle extends FontStyle
{

	private VData sheetName;
	private String modelPath;
	private int numSheets;

	public void setNumSheets(int num)
	{
		numSheets = num;
	}

	public int getNumSheets()
	{
		return numSheets;
	}

	public void setSheetName(String name)
	{
		sheetName.add(name);
	}

	public String getSheetName(int i)
	{
		return (String)sheetName.get(i);
	}

	public void setModelPath(String path)
	{
		modelPath = path;
	}

	public String getModelPath()
	{
		return modelPath;
	}

	public FileStyle()
	{
		sheetName = new VData();
		modelPath = "";
		numSheets = 0;
	}
}
