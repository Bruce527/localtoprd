// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankStateOperateDealIface.java

package com.sinosoft.banklns.lnsmodel;

import java.util.List;

public interface BankStateOperateDealIface
{

	public abstract boolean checkOperate(String s, String s1, int i);

	public abstract boolean checkEditOperate(String s, String s1, String s2, String s3, String s4);

	public abstract List infoOprate(String s, String s1, String s2, String s3);

	public abstract boolean checkEditOperate(String s, String s1, String s2, String s3);

	public abstract boolean checkButtonOperate(String s, String s1, int i, String s2, String s3);

	public abstract String updateEditStateDone(String s, int i);

	public abstract String updateEditStateUNDone(String s, int i);
}
