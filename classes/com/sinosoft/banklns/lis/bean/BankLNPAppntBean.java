// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankLNPAppntBean.java

package com.sinosoft.banklns.lis.bean;

import com.sinosoft.banklns.lis.schema.LNPAppntSchema;

// Referenced classes of package com.sinosoft.banklns.lis.bean:
//			BankBeanBasic

public class BankLNPAppntBean extends BankBeanBasic
{

	private LNPAppntSchema schema;

	public BankLNPAppntBean()
	{
		schema = new LNPAppntSchema();
	}

	public LNPAppntSchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPAppntSchema schema)
	{
		this.schema = schema;
	}
}
