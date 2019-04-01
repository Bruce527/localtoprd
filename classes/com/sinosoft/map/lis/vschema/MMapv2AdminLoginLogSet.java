// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMapv2AdminLoginLogSet.java

package com.sinosoft.map.lis.vschema;

import com.sinosoft.map.lis.schema.MMapv2AdminLoginLogSchema;
import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.SchemaSet;

public class MMapv2AdminLoginLogSet extends SchemaSet
{

	public MMapv2AdminLoginLogSet()
	{
	}

	public boolean add(MMapv2AdminLoginLogSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(MMapv2AdminLoginLogSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(MMapv2AdminLoginLogSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public MMapv2AdminLoginLogSchema get(int index)
	{
		MMapv2AdminLoginLogSchema tSchema = (MMapv2AdminLoginLogSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, MMapv2AdminLoginLogSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(MMapv2AdminLoginLogSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			MMapv2AdminLoginLogSchema aSchema = get(i);
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
			MMapv2AdminLoginLogSchema aSchema = new MMapv2AdminLoginLogSchema();
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
		MMapv2AdminLoginLogSchema tSchema = new MMapv2AdminLoginLogSchema();
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
