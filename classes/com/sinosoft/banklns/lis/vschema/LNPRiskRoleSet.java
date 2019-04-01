// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskRoleSet.java

package com.sinosoft.banklns.lis.vschema;

import com.sinosoft.banklns.lis.schema.LNPRiskRoleSchema;
import com.sinosoft.banklns.utility.CErrors;
import com.sinosoft.banklns.utility.SchemaSet;

public class LNPRiskRoleSet extends SchemaSet
{

	public LNPRiskRoleSet()
	{
	}

	public boolean add(LNPRiskRoleSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(LNPRiskRoleSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(LNPRiskRoleSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public LNPRiskRoleSchema get(int index)
	{
		LNPRiskRoleSchema tSchema = (LNPRiskRoleSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, LNPRiskRoleSchema aSchema)
	{
		return super.set(index, aSchema);
	}

	public boolean set(LNPRiskRoleSet aSet)
	{
		return super.set(aSet);
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = size();
		for (int i = 1; i <= n; i++)
		{
			LNPRiskRoleSchema aSchema = get(i);
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
			LNPRiskRoleSchema aSchema = new LNPRiskRoleSchema();
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
		LNPRiskRoleSchema tSchema = new LNPRiskRoleSchema();
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
