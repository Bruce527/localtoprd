// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   NewsDataModelSchema.java

package com.sinosoft.map.news;

import com.sinosoft.map.lis.schema.MNewsSchema;

public class NewsDataModelSchema extends MNewsSchema
{

	private String newSign;
	private String hotSign;
	private String newPic;
	private String hotPic;
	private String newsTypeSign;
	private String newsTopSign;
	private String newsShortTitle;

	public NewsDataModelSchema()
	{
		newSign = "";
		hotSign = "";
		newPic = "";
		hotPic = "";
		newsTypeSign = "";
		newsTopSign = "";
		newsShortTitle = "";
	}

	public String getNewsShortTitle()
	{
		return newsShortTitle;
	}

	public void setNewsShortTitle(String newsShortTitle)
	{
		this.newsShortTitle = newsShortTitle;
	}

	public String getNewsTypeSign()
	{
		return newsTypeSign;
	}

	public void setNewsTypeSign(String newsTypeSign)
	{
		this.newsTypeSign = newsTypeSign;
	}

	public String getNewPic()
	{
		return newPic;
	}

	public void setNewPic(String newPic)
	{
		this.newPic = newPic;
	}

	public String getNewSign()
	{
		return newSign;
	}

	public void setNewSign(String newSign)
	{
		this.newSign = newSign;
	}

	public String getHotSign()
	{
		return hotSign;
	}

	public void setHotSign(String hotSign)
	{
		this.hotSign = hotSign;
	}

	public String getHotPic()
	{
		return hotPic;
	}

	public void setHotPic(String hotPic)
	{
		this.hotPic = hotPic;
	}

	public String getNewsTopSign()
	{
		return newsTopSign;
	}

	public void setNewsTopSign(String newsTopSign)
	{
		this.newsTopSign = newsTopSign;
	}
}
