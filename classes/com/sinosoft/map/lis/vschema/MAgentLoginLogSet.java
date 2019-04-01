// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MAgentLoginLogSet.java

package com.sinosoft.map.lis.vschema;

import com.sinosoft.map.lis.schema.MAgentLoginLogSchema;
import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.SchemaSet;

public class MAgentLoginLogSet extends SchemaSet
{

	public MAgentLoginLogSet()
	{
	}

	public boolean add(MAgentLoginLogSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(MAgentLoginLogSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(MAgentLoginLogSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public MAgentLoginLogSchema get(int index)
	{
		MAgentLoginLogSchema tSchema = (MAgentLoginLogSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, MAgentLoginLogSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(MAgentLoginLogSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			MAgentLoginLogSchema aSchema = get(i);
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
			MAgentLoginLogSchema aSchema = new MAgentLoginLogSchema();
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
		MAgentLoginLogSchema tSchema = new MAgentLoginLogSchema();
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
