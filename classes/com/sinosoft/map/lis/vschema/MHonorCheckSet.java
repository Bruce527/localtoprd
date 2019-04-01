// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MHonorCheckSet.java

package com.sinosoft.map.lis.vschema;

import com.sinosoft.map.lis.schema.MHonorCheckSchema;
import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.SchemaSet;

public class MHonorCheckSet extends SchemaSet
{

	public MHonorCheckSet()
	{
	}

	public boolean add(MHonorCheckSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(MHonorCheckSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(MHonorCheckSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public MHonorCheckSchema get(int index)
	{
		MHonorCheckSchema tSchema = (MHonorCheckSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, MHonorCheckSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(MHonorCheckSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			MHonorCheckSchema aSchema = get(i);
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
			MHonorCheckSchema aSchema = new MHonorCheckSchema();
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
		MHonorCheckSchema tSchema = new MHonorCheckSchema();
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
