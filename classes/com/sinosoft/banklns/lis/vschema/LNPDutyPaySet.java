// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyPaySet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPDutyPaySchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPDutyPaySet extends SchemaSet
{

	public LNPDutyPaySet()
	{
	}

	public boolean add(LNPDutyPaySchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPDutyPaySet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPDutyPaySchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPDutyPaySchema get(int index)
	{
		LNPDutyPaySchema tSchema = (LNPDutyPaySchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPDutyPaySchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPDutyPaySet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPDutyPaySchema aSchema = get(i);
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
			LNPDutyPaySchema aSchema = new LNPDutyPaySchema();
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
		LNPDutyPaySchema tSchema = new LNPDutyPaySchema();
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
