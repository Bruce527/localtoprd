// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankLNPAgentInfoBean.java

package com.sinosoft.banklns.lis.bean;

import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;

// Referenced classes of package com.sinosoft.banklns.lis.bean:
//			BankBeanBasic

public class BankLNPAgentInfoBean extends BankBeanBasic
{

	private LNPAgentInfoSchema schema;

	public BankLNPAgentInfoBean()
	{
		schema = new LNPAgentInfoSchema();
	}

	public LNPAgentInfoSchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPAgentInfoSchema schema)
	{
		this.schema = schema;
	}
}
