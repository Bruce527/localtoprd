// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   NewsClickInfo.java

package com.sinosoft.map.news;


public class NewsClickInfo
{

	private String newsId;
	private int addNum;

	public NewsClickInfo()
	{
		newsId = "";
		addNum = 0;
	}

	public String getNewsId()
	{
		return newsId;
	}

	public void setNewsId(String newsId)
	{
		this.newsId = newsId;
	}

	public int getAddNum()
	{
		return addNum;
	}

	public void setAddNum(int addNum)
	{
		this.addNum = addNum;
	}
}
