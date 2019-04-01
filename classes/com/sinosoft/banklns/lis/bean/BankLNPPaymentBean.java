// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankLNPPaymentBean.java

package com.sinosoft.banklns.lis.bean;

import com.sinosoft.banklns.lis.schema.LNPPaymentSchema;

// Referenced classes of package com.sinosoft.banklns.lis.bean:
//			BankBeanBasic

public class BankLNPPaymentBean extends BankBeanBasic
{

	private LNPPaymentSchema schema;

	public BankLNPPaymentBean()
	{
		schema = new LNPPaymentSchema();
	}

	public LNPPaymentSchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPPaymentSchema schema)
	{
		this.schema = schema;
	}
}
