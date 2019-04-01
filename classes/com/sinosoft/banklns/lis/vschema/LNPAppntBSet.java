// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAppntBSet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPAppntBSchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPAppntBSet extends SchemaSet
{

	public LNPAppntBSet()
	{
	}

	public boolean add(LNPAppntBSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPAppntBSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPAppntBSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPAppntBSchema get(int index)
	{
		LNPAppntBSchema tSchema = (LNPAppntBSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPAppntBSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPAppntBSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		String strReturn = "";
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPAppntBSchema aSchema = get(i);
			strReturn = (new StringBuilder(String.valueOf(strReturn))).append(aSchema.encode()).toString();
			if (i != n)
				strReturn = (new StringBuilder(String.valueOf(strReturn))).append("^").toString();
		}

		return strReturn;
	}

	public boolean decode(String str)
	{
		int nBeginPos = 0;
		int nEndPos = str.indexOf('^');
		clear();
		for (; nEndPos != -1; nEndPos = str.indexOf('^', nEndPos + 1))
		{
			LNPAppntBSchema aSchema = new LNPAppntBSchema();
			if (!aSchema.decode(str.substring(nBeginPos, nEndPos)))
			{
				mErrors.copyAllErrors(aSchema.mErrors);
				return false;
			}
			add(aSchema);
			nBeginPos = nEndPos + 1;
		}

		LNPAppntBSchema tSchema = new LNPAppntBSchema();
		if (!tSchema.decode(str.substring(nBeginPos)))
		{
			mErrors.copyAllErrors(tSchema.mErrors);
			return false;
		} else
		{
			add(tSchema);
			return true;
		}
	}
}
