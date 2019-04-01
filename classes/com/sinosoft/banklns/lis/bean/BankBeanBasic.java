// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankBeanBasic.java

package com.sinosoft.banklns.lis.bean;


public abstract class BankBeanBasic
{

	private boolean editSchemaFlag;

	public BankBeanBasic()
	{
	}

	public boolean isEditSchemaFlag()
	{
		return editSchemaFlag;
	}

	public void setEditSchemaFlag(boolean editSchemaFlag)
	{
		this.editSchemaFlag = editSchemaFlag;
	}
}
