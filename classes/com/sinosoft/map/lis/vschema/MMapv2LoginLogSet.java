// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMapv2LoginLogSet.java

package com.sinosoft.map.lis.vschema;

import com.sinosoft.map.lis.schema.MMapv2LoginLogSchema;
import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.SchemaSet;

public class MMapv2LoginLogSet extends SchemaSet
{

	public MMapv2LoginLogSet()
	{
	}

	public boolean add(MMapv2LoginLogSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(MMapv2LoginLogSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(MMapv2LoginLogSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public MMapv2LoginLogSchema get(int index)
	{
		MMapv2LoginLogSchema tSchema = (MMapv2LoginLogSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, MMapv2LoginLogSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(MMapv2LoginLogSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			MMapv2LoginLogSchema aSchema = get(i);
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
			MMapv2LoginLogSchema aSchema = new MMapv2LoginLogSchema();
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
		MMapv2LoginLogSchema tSchema = new MMapv2LoginLogSchema();
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
