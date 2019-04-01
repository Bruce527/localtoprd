// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankLNPPersonBean.java

package com.sinosoft.banklns.lis.bean;

import com.sinosoft.banklns.lis.schema.LNPPersonSchema;

// Referenced classes of package com.sinosoft.banklns.lis.bean:
//			BankBeanBasic

public class BankLNPPersonBean extends BankBeanBasic
{

	private LNPPersonSchema schema;

	public BankLNPPersonBean()
	{
		schema = new LNPPersonSchema();
	}

	public LNPPersonSchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPPersonSchema schema)
	{
		this.schema = schema;
	}
}
