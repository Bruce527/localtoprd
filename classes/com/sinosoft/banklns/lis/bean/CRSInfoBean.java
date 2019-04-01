// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CRSInfoBean.java

package com.sinosoft.banklns.lis.bean;

import com.sinosoft.banklns.lis.schema.CRSInfoSchema;

// Referenced classes of package com.sinosoft.banklns.lis.bean:
//			BankBeanBasic

public class CRSInfoBean extends BankBeanBasic
{

	private CRSInfoSchema schema;

	public CRSInfoBean()
	{
		schema = new CRSInfoSchema();
	}

	public CRSInfoSchema getSchema()
	{
		return schema;
	}

	public void setSchema(CRSInfoSchema schema)
	{
		this.schema = schema;
	}
}
