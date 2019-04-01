// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MUserLoginLogSet.java

package com.sinosoft.map.lis.vschema;

import com.sinosoft.map.lis.schema.MUserLoginLogSchema;
import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.SchemaSet;

public class MUserLoginLogSet extends SchemaSet
{

	public MUserLoginLogSet()
	{
	}

	public boolean add(MUserLoginLogSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(MUserLoginLogSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(MUserLoginLogSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public MUserLoginLogSchema get(int index)
	{
		MUserLoginLogSchema tSchema = (MUserLoginLogSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, MUserLoginLogSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(MUserLoginLogSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			MUserLoginLogSchema aSchema = get(i);
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
			MUserLoginLogSchema aSchema = new MUserLoginLogSchema();
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
		MUserLoginLogSchema tSchema = new MUserLoginLogSchema();
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
