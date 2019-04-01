// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankLNPAddressBean.java

package com.sinosoft.banklns.lis.bean;

import com.sinosoft.banklns.lis.schema.LNPAddressSchema;

// Referenced classes of package com.sinosoft.banklns.lis.bean:
//			BankBeanBasic

public class BankLNPAddressBean extends BankBeanBasic
{

	private LNPAddressSchema schema;

	public BankLNPAddressBean()
	{
		schema = new LNPAddressSchema();
	}

	public LNPAddressSchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPAddressSchema schema)
	{
		this.schema = schema;
	}
}
