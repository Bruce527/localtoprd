// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DateToStringConverter.java

package com.sinosoft.map.common.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class DateToStringConverter
	implements Converter
{

	public DateToStringConverter()
	{
	}

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
	{
		return arg2;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
	{
		return arg2.toString();
	}
}
