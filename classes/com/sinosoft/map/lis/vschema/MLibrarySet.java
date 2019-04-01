// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLibrarySet.java

package com.sinosoft.map.lis.vschema;

import com.sinosoft.map.lis.schema.MLibrarySchema;
import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.SchemaSet;

public class MLibrarySet extends SchemaSet
{

	public MLibrarySet()
	{
	}

	public boolean add(MLibrarySchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(MLibrarySet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(MLibrarySchema aSchema)
	{
		return super.remove(aSchema);
	}

	public MLibrarySchema get(int index)
	{
		MLibrarySchema tSchema = (MLibrarySchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, MLibrarySchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(MLibrarySet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			MLibrarySchema aSchema = get(i);
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
			MLibrarySchema aSchema = new MLibrarySchema();
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
		MLibrarySchema tSchema = new MLibrarySchema();
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
