// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPFinanceAndInsureBean.java

package com.sinosoft.banklns.lnsmodel.entity;

import com.sinosoft.banklns.lis.schema.LNPInsureHistorySchema;

public class LNPFinanceAndInsureBean
{

	private LNPInsureHistorySchema schema;
	private String sumInsuredDeath;
	private String sumInsuredDisease;
	private String policyState;
	private String listShowTag;

	public LNPFinanceAndInsureBean()
	{
		schema = null;
		sumInsuredDeath = null;
		sumInsuredDisease = null;
		policyState = null;
		listShowTag = null;
	}

	public LNPInsureHistorySchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPInsureHistorySchema schema)
	{
		this.schema = schema;
	}

	public String getSumInsuredDeath()
	{
		return sumInsuredDeath;
	}

	public void setSumInsuredDeath(String sumInsuredDeath)
	{
		this.sumInsuredDeath = sumInsuredDeath;
	}

	public String getSumInsuredDisease()
	{
		return sumInsuredDisease;
	}

	public void setSumInsuredDisease(String sumInsuredDisease)
	{
		this.sumInsuredDisease = sumInsuredDisease;
	}

	public String getPolicyState()
	{
		return policyState;
	}

	public void setPolicyState(String policyState)
	{
		this.policyState = policyState;
	}

	public String getListShowTag()
	{
		return listShowTag;
	}

	public void setListShowTag(String listShowTag)
	{
		this.listShowTag = listShowTag;
	}
}
