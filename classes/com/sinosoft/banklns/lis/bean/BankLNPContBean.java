// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankLNPContBean.java

package com.sinosoft.banklns.lis.bean;

import com.sinosoft.banklns.lis.schema.LNPContSchema;

// Referenced classes of package com.sinosoft.banklns.lis.bean:
//			BankBeanBasic

public class BankLNPContBean extends BankBeanBasic
{

	private LNPContSchema schema;

	public BankLNPContBean()
	{
		schema = new LNPContSchema();
	}

	public LNPContSchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPContSchema schema)
	{
		this.schema = schema;
	}
}
