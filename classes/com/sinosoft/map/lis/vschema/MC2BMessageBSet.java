// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MC2BMessageBSet.java

package com.sinosoft.map.lis.vschema;

import com.sinosoft.map.lis.schema.MC2BMessageBSchema;
import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.SchemaSet;

public class MC2BMessageBSet extends SchemaSet
{

	public MC2BMessageBSet()
	{
	}

	public boolean add(MC2BMessageBSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(MC2BMessageBSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(MC2BMessageBSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public MC2BMessageBSchema get(int index)
	{
		MC2BMessageBSchema tSchema = (MC2BMessageBSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, MC2BMessageBSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(MC2BMessageBSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			MC2BMessageBSchema aSchema = get(i);
			strReturn.append(aSchema.encode());
			if (i != n)
				strReturn.append("^");
		}

		return strReturn.toString();
	}

	public boolean decode(String str)
	{
		int nBeginPos = 0;
		int nEndPos = str.indexOf('^');
		clear();
		while (nEndPos != -1) 
		{
			MC2BMessageBSchema aSchema = new MC2BMessageBSchema();
			if (aSchema.decode(str.substring(nBeginPos, nEndPos)))
			{
				add(aSchema);
				nBeginPos = nEndPos + 1;
				nEndPos = str.indexOf('^', nEndPos + 1);
			} else
			{
				mErrors.copyAllErrors(aSchema.mErrors);
				return false;
			}
		}
		MC2BMessageBSchema tSchema = new MC2BMessageBSchema();
		if (tSchema.decode(str.substring(nBeginPos)))
		{
			add(tSchema);
			return true;
		} else
		{
			mErrors.copyAllErrors(tSchema.mErrors);
			return false;
		}
	}
}
