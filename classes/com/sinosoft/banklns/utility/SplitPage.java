// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SplitPage.java

package com.sinosoft.banklns.utility;


public class SplitPage
{

	int CurrentPage;
	int Recordscount;
	int PageCount;

	public SplitPage()
	{
		CurrentPage = 1;
		Recordscount = 0;
		PageCount = 0;
	}

	public String[][] splitpage(String src[][])
	{
		Recordscount = src.length;
		PageCount = (Recordscount - 1) / 10 + 1;
		int start = (CurrentPage - 1) * 10 + 1;
		int end = CurrentPage * 10;
		if (end >= Recordscount)
			end = Recordscount;
		String result[][] = new String[(end - start) + 1][src[0].length];
		for (int i = 0; i < (end - start) + 1; i++)
		{
			for (int j = 0; j < src[0].length; j++)
				result[i][j] = src[(i + start) - 1][j];

		}

		return result;
	}

	public int getCurrentPage()
	{
		return CurrentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		CurrentPage = currentPage;
	}

	public int getPageCount()
	{
		return PageCount;
	}

	public void setPageCount(int pageCount)
	{
		PageCount = pageCount;
	}

	public int getRecordscount()
	{
		return Recordscount;
	}

	public void setRecordscount(int recordscount)
	{
		Recordscount = recordscount;
	}
}
