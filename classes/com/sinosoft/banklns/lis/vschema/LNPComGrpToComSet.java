// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPComGrpToComSet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPComGrpToComSchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPComGrpToComSet extends SchemaSet
{

	public LNPComGrpToComSet()
	{
	}

	public boolean add(LNPComGrpToComSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPComGrpToComSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPComGrpToComSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPComGrpToComSchema get(int index)
	{
		LNPComGrpToComSchema tSchema = (LNPComGrpToComSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPComGrpToComSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPComGrpToComSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPComGrpToComSchema aSchema = get(i);
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
			LNPComGrpToComSchema aSchema = new LNPComGrpToComSchema();
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
		LNPComGrpToComSchema tSchema = new LNPComGrpToComSchema();
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
