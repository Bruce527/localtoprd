// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MSysVarSet.java

package com.sinosoft.map.lis.vschema;

import com.sinosoft.map.lis.schema.MSysVarSchema;
import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.SchemaSet;

public class MSysVarSet extends SchemaSet
{

	public MSysVarSet()
	{
	}

	public boolean add(MSysVarSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(MSysVarSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(MSysVarSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public MSysVarSchema get(int index)
	{
		MSysVarSchema tSchema = (MSysVarSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, MSysVarSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(MSysVarSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			MSysVarSchema aSchema = get(i);
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
			MSysVarSchema aSchema = new MSysVarSchema();
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
		MSysVarSchema tSchema = new MSysVarSchema();
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
