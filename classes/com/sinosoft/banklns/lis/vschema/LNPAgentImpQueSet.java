// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentImpQueSet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPAgentImpQueSchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPAgentImpQueSet extends SchemaSet
{

	public LNPAgentImpQueSet()
	{
	}

	public boolean add(LNPAgentImpQueSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPAgentImpQueSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPAgentImpQueSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPAgentImpQueSchema get(int index)
	{
		LNPAgentImpQueSchema tSchema = (LNPAgentImpQueSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPAgentImpQueSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPAgentImpQueSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPAgentImpQueSchema aSchema = get(i);
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
			LNPAgentImpQueSchema aSchema = new LNPAgentImpQueSchema();
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
		LNPAgentImpQueSchema tSchema = new LNPAgentImpQueSchema();
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
