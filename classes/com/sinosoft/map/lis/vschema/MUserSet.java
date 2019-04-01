// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MUserSet.java

package com.sinosoft.map.lis.vschema;

import com.sinosoft.map.lis.schema.MUserSchema;
import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.SchemaSet;

public class MUserSet extends SchemaSet
{

	public MUserSet()
	{
	}

	public boolean add(MUserSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(MUserSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(MUserSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public MUserSchema get(int index)
	{
		MUserSchema tSchema = (MUserSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, MUserSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(MUserSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			MUserSchema aSchema = get(i);
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
			MUserSchema aSchema = new MUserSchema();
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
		MUserSchema tSchema = new MUserSchema();
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
