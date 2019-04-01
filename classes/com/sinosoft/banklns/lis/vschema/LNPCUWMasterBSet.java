// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCUWMasterBSet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPCUWMasterBSchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPCUWMasterBSet extends SchemaSet
{

	public LNPCUWMasterBSet()
	{
	}

	public boolean add(LNPCUWMasterBSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPCUWMasterBSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPCUWMasterBSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPCUWMasterBSchema get(int index)
	{
		LNPCUWMasterBSchema tSchema = (LNPCUWMasterBSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPCUWMasterBSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPCUWMasterBSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		String strReturn = "";
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPCUWMasterBSchema aSchema = get(i);
			strReturn = (new StringBuilder(String.valueOf(strReturn))).append(aSchema.encode()).toString();
			if (i != n)
				strReturn = (new StringBuilder(String.valueOf(strReturn))).append("^").toString();
		}

		return strReturn;
	}

	public boolean decode(String str)
	{
		int nBeginPos = 0;
		int nEndPos = str.indexOf('^');
		clear();
		for (; nEndPos != -1; nEndPos = str.indexOf('^', nEndPos + 1))
		{
			LNPCUWMasterBSchema aSchema = new LNPCUWMasterBSchema();
			if (!aSchema.decode(str.substring(nBeginPos, nEndPos)))
			{
				mErrors.copyAllErrors(aSchema.mErrors);
				return false;
			}
			add(aSchema);
			nBeginPos = nEndPos + 1;
		}

		LNPCUWMasterBSchema tSchema = new LNPCUWMasterBSchema();
		if (!tSchema.decode(str.substring(nBeginPos)))
		{
			mErrors.copyAllErrors(tSchema.mErrors);
			return false;
		} else
		{
			add(tSchema);
			return true;
		}
	}
}
