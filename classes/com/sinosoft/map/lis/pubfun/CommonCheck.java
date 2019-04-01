// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonCheck.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.CErrors;
import java.util.Vector;

public class CommonCheck
{

	public CErrors mErrors;

	public CommonCheck()
	{
		mErrors = new CErrors();
	}

	public boolean checknoempty(String name, Object ckobj)
	{
		if (ckobj == null || ckobj.toString().equals(""))
		{
			mErrors.addOneError((new StringBuilder("发生错误: ")).append(name).append(" 不允许空").toString());
			return false;
		} else
		{
			return true;
		}
	}

	public boolean checksingle(String name, Object ckobj, Vector source)
	{
		if (source == null)
			return true;
		for (int i = 0; i < source.size(); i++)
			if (ckobj.equals(source.elementAt(i)))
			{
				mErrors.addOneError((new StringBuilder("发生错误: ")).append(name).append(" 存在重复值").toString());
				return false;
			}

		return true;
	}

	public boolean checkmatch(String name, Object ckobj, Vector source)
	{
		if (source == null)
		{
			mErrors.addOneError((new StringBuilder("发生错误: ")).append(name).append(" 不存在匹配值").toString());
			return false;
		}
		for (int i = 0; i < source.size(); i++)
			if (ckobj.equals(source.elementAt(i)))
				return true;

		mErrors.addOneError((new StringBuilder("发生错误: ")).append(name).append(" 不存在匹配值").toString());
		return false;
	}
}
