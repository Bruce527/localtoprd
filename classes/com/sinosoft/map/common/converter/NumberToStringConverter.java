// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   NumberToStringConverter.java

package com.sinosoft.map.common.converter;

import java.io.PrintStream;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class NumberToStringConverter
	implements Converter
{

	public NumberToStringConverter()
	{
	}

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
	{
		System.out.println((new StringBuilder("arg2=")).append(arg2).toString());
		return arg2;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
	{
		System.out.println((new StringBuilder("arg1.getId()=")).append(arg1.getId()).toString());
		System.out.println((new StringBuilder("arg2.toString()=")).append(arg2.toString()).toString());
		String str = arg2.toString();
		if (str != null && str.indexOf(".") > -1)
		{
			System.out.println((new StringBuilder("AAAAAAAAAAAAAaaa=")).append(str.substring(0, str.indexOf("."))).toString());
			if ("0".equals(str.substring(str.indexOf("."))) || "00".equals(str.substring(str.indexOf("."))))
				return str.substring(0, str.indexOf("."));
		}
		return arg2.toString();
	}
}
