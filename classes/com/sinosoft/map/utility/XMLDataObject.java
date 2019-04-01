// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLDataObject.java

package com.sinosoft.map.utility;

import org.jdom.Element;

// Referenced classes of package com.sinosoft.map.utility:
//			XMLDataFormater

public abstract class XMLDataObject
{

	public static final int TYPE_TAG = 0;
	public static final int TYPE_LIST = 1;
	public static final int TYPE_MINE = 2;
	public static final int TYPE_BLOB = 3;
	protected String _ID;
	private XMLDataFormater m_xdf;

	public XMLDataObject()
	{
		m_xdf = null;
	}

	public final void setDataObjectID(String strID)
	{
		if (strID.equals("null"))
			strID = "";
		_ID = strID;
	}

	public final String getDataObjectID()
	{
		if (_ID == null)
			return null;
		else
			return _ID;
	}

	public final void setDataFormater(XMLDataFormater xdf)
	{
		m_xdf = xdf;
	}

	public final XMLDataFormater getDataFormater()
	{
		return m_xdf;
	}

	public abstract boolean addDataTo(Element element);

	public abstract int getDataObjectType();
}
