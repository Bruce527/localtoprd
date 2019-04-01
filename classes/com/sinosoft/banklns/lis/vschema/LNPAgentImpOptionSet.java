// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentImpOptionSet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPAgentImpOptionSchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPAgentImpOptionSet extends SchemaSet
{

	public LNPAgentImpOptionSet()
	{
	}

	public boolean add(LNPAgentImpOptionSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPAgentImpOptionSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPAgentImpOptionSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPAgentImpOptionSchema get(int index)
	{
		LNPAgentImpOptionSchema tSchema = (LNPAgentImpOptionSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPAgentImpOptionSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPAgentImpOptionSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPAgentImpOptionSchema aSchema = get(i);
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
			LNPAgentImpOptionSchema aSchema = new LNPAgentImpOptionSchema();
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
		LNPAgentImpOptionSchema tSchema = new LNPAgentImpOptionSchema();
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
