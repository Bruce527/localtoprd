// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPBnfBean.java

package com.sinosoft.banklns.lnsmodel.entity;

import com.sinosoft.banklns.lis.schema.LNPBnfSchema;

public class LNPBnfBean
{

	private LNPBnfSchema schema;
	private String gender;
	private String idType;
	private String relationToInsured;
	private String benefitRate;
	private String listEditFlag;

	public LNPBnfBean()
	{
	}

	public LNPBnfSchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPBnfSchema schema)
	{
		this.schema = schema;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getIdType()
	{
		return idType;
	}

	public void setIdType(String idType)
	{
		this.idType = idType;
	}

	public String getRelationToInsured()
	{
		return relationToInsured;
	}

	public void setRelationToInsured(String relationToInsured)
	{
		this.relationToInsured = relationToInsured;
	}

	public String getBenefitRate()
	{
		return benefitRate;
	}

	public void setBenefitRate(String benefitRate)
	{
		this.benefitRate = benefitRate;
	}

	public String getListEditFlag()
	{
		return listEditFlag;
	}

	public void setListEditFlag(String listEditFlag)
	{
		this.listEditFlag = listEditFlag;
	}
}
