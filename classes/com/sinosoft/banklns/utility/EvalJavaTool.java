// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EvalJavaTool.java

package com.sinosoft.banklns.utility;

import bsh.Interpreter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Pattern;

public class EvalJavaTool
{

	public EvalJavaTool()
	{
	}

	public String executeByExpress(String expression, Hashtable reHashtable)
	{
		String result = null;
		try
		{
			Interpreter interpreter = new Interpreter();
			if (reHashtable != null)
			{
				for (Enumeration enumeration = reHashtable.keys(); enumeration.hasMoreElements();)
				{
					String key = enumeration.nextElement().toString();
					Object obj = reHashtable.get(key);
					if (obj != null && Pattern.matches("[0-9.]*", obj.toString()))
					{
						if (obj.toString().indexOf(".") != -1)
							interpreter.set(key, Double.parseDouble(obj.toString()));
						else
							interpreter.set(key, Integer.parseInt(obj.toString()));
					} else
					{
						interpreter.set(key, obj);
					}
				}

			}
			Object obj = interpreter.eval(expression);
			if (obj != null)
				result = obj.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
