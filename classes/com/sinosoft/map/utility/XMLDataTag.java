// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLDataTag.java

package com.sinosoft.map.utility;

import org.jdom.Element;

// Referenced classes of package com.sinosoft.map.utility:
//			XMLDataObject

public class XMLDataTag extends XMLDataObject
{

	private String _Value;

	public XMLDataTag(String strName, String strValue)
	{
		setDataObjectID(strName);
		_Value = strValue;
	}

	public XMLDataTag(String strName, int iValue)
	{
		setDataObjectID(strName);
		_Value = String.valueOf(iValue);
	}

	public void setName(String strName)
	{
		setDataObjectID(strName);
	}

	public void setValue(String strValue)
	{
		_Value = strValue;
	}

	public void setValue(int iValue)
	{
		_Value = String.valueOf(iValue);
	}

	public int getDataObjectType()
	{
		return 0;
	}

	public boolean addDataTo(Element element)
	{
		element.addContent((new Element(_ID)).addContent(_Value));
		return true;
	}
}
