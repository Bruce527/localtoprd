// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Pagination.java

package com.ibm.filenet.api.ce.search;

import java.util.List;

public class Pagination
{

	private int currentPageIndex;
	private int pageSize;
	private int totalNum;
	private List docs;
	private boolean isFirst;
	private boolean isLast;
	private int totalPages;
	private int pageCount;

	public Pagination(List docs, int pageSize, int currentPageIndex, int totalNum)
	{
		this.pageSize = pageSize;
		this.currentPageIndex = currentPageIndex;
		isFirst = currentPageIndex == 1;
		isLast = currentPageIndex * pageSize >= totalNum;
		pageCount = docs != null ? docs.size() : 0;
		this.docs = docs;
		totalPages = totalNum / pageSize + (totalNum % pageSize != 0 ? 1 : 0);
		this.totalNum = totalNum;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getCurrentPageIndex()
	{
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex)
	{
		this.currentPageIndex = currentPageIndex;
	}

	public boolean isFirst()
	{
		return isFirst;
	}

	public void setFirst(boolean isFirst)
	{
		this.isFirst = isFirst;
	}

	public boolean isLast()
	{
		return isLast;
	}

	public void setLast(boolean isLast)
	{
		this.isLast = isLast;
	}

	public int getPageCount()
	{
		return pageCount;
	}

	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}

	public List getItems()
	{
		return docs;
	}

	public void setItems(List items)
	{
		docs = items;
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}

	public int getTotalNum()
	{
		return totalNum;
	}

	public void setTotalNum(int totalNum)
	{
		this.totalNum = totalNum;
	}
}
