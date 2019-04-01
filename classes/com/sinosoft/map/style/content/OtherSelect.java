// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OtherSelect.java

package com.sinosoft.map.style.content;


public class OtherSelect
{

	private String FileName;
	private String FileType;
	private String Greeting;
	private String Operator;
	private String LookWhere;

	public OtherSelect()
	{
		FileName = "";
		FileType = "pdf";
		Greeting = "";
		Operator = "";
		LookWhere = "";
	}

	public void setFileName(String fileName)
	{
		FileName = fileName;
	}

	public void setFileType(String fileType)
	{
		FileType = fileType;
	}

	public void setGreeting(String greeting)
	{
		Greeting = greeting;
	}

	public String getFileType()
	{
		return FileType;
	}

	public String getFileName()
	{
		return FileName;
	}

	public String getGreeting()
	{
		return Greeting;
	}

	public String getOperator()
	{
		return Operator;
	}

	public void setOperator(String operator)
	{
		Operator = operator;
	}

	public String getLookWhere()
	{
		return LookWhere;
	}

	public void setLookWhere(String lookWhere)
	{
		LookWhere = lookWhere;
	}
}
