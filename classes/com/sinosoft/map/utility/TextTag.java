// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TextTag.java

package com.sinosoft.map.utility;

import java.util.Vector;

public class TextTag
{

	private Vector myVector;

	public TextTag()
	{
		myVector = new Vector();
	}

	public Vector add(String name, String value)
	{
		if (value != null)
		{
			String temparray[] = {
				name, value
			};
			myVector.addElement(temparray);
			return myVector;
		} else
		{
			String temparray[] = {
				name, ""
			};
			myVector.addElement(temparray);
			return myVector;
		}
	}

	public Vector add(String name, int value)
	{
		Integer ivalue = new Integer(value);
		String svalue = ivalue.toString();
		String temparray[] = {
			name, svalue
		};
		myVector.addElement(temparray);
		return myVector;
	}

	public Vector add(String name, long value)
	{
		Long ivalue = new Long(value);
		String svalue = ivalue.toString();
		String temparray[] = {
			name, svalue
		};
		myVector.addElement(temparray);
		return myVector;
	}

	public Vector add(String name, float value)
	{
		Float fvalue = new Float(value);
		String svalue = fvalue.toString();
		String temparray[] = {
			name, svalue
		};
		myVector.addElement(temparray);
		return myVector;
	}

	public Vector add(String name, double value)
	{
		Double fvalue = new Double(value);
		String svalue = fvalue.toString();
		String temparray[] = {
			name, svalue
		};
		myVector.addElement(temparray);
		return myVector;
	}

	public Object get(int i)
	{
		return myVector.get(i);
	}

	public int size()
	{
		return myVector.size();
	}
}
