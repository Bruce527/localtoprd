// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsuredRelatedSet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPInsuredRelatedSchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPInsuredRelatedSet extends SchemaSet
{

	public LNPInsuredRelatedSet()
	{
	}

	public boolean add(LNPInsuredRelatedSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPInsuredRelatedSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPInsuredRelatedSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPInsuredRelatedSchema get(int index)
	{
		LNPInsuredRelatedSchema tSchema = (LNPInsuredRelatedSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPInsuredRelatedSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPInsuredRelatedSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPInsuredRelatedSchema aSchema = get(i);
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
			LNPInsuredRelatedSchema aSchema = new LNPInsuredRelatedSchema();
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
		LNPInsuredRelatedSchema tSchema = new LNPInsuredRelatedSchema();
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
