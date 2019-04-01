// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskAppSet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPRiskAppSchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPRiskAppSet extends SchemaSet
{

	public LNPRiskAppSet()
	{
	}

	public boolean add(LNPRiskAppSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPRiskAppSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPRiskAppSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPRiskAppSchema get(int index)
	{
		LNPRiskAppSchema tSchema = (LNPRiskAppSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPRiskAppSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPRiskAppSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPRiskAppSchema aSchema = get(i);
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
			LNPRiskAppSchema aSchema = new LNPRiskAppSchema();
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
		LNPRiskAppSchema tSchema = new LNPRiskAppSchema();
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
