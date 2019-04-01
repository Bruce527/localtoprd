// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCustImpResultSet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPCustImpResultSet extends SchemaSet
{

	public LNPCustImpResultSet()
	{
	}

	public boolean add(LNPCustImpResultSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPCustImpResultSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPCustImpResultSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPCustImpResultSchema get(int index)
	{
		LNPCustImpResultSchema tSchema = (LNPCustImpResultSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPCustImpResultSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPCustImpResultSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPCustImpResultSchema aSchema = get(i);
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
			LNPCustImpResultSchema aSchema = new LNPCustImpResultSchema();
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
		LNPCustImpResultSchema tSchema = new LNPCustImpResultSchema();
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
