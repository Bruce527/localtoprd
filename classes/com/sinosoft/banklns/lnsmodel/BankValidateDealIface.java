// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankValidateDealIface.java

package com.sinosoft.banklns.lnsmodel;

import java.util.List;

public interface BankValidateDealIface
{

	public abstract boolean validateByContNo(String s);

	public abstract List getErroList();

	public abstract String showErrors();
}
