// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XmlTable.java

package com.sinosoft.map.utility;

import com.sinosoft.map.style.pdf.TableHeadStyle;
import java.util.LinkedList;
import java.util.List;

public class XmlTable
{

	private List headers;
	private TableHeadStyle tableHeadStyle;

	public XmlTable()
	{
		headers = new LinkedList();
		tableHeadStyle = new TableHeadStyle();
	}

	public XmlTable(List headers, TableHeadStyle tableHeadStyle)
	{
		this.headers = headers;
		this.tableHeadStyle = tableHeadStyle;
	}

	public List getHeaders()
	{
		return headers;
	}

	public void setHeaders(List headers)
	{
		this.headers = headers;
	}

	public TableHeadStyle getTableHeadStyle()
	{
		return tableHeadStyle;
	}

	public void setTableHeadStyle(TableHeadStyle tableHeadStyle)
	{
		this.tableHeadStyle = tableHeadStyle;
	}
}
