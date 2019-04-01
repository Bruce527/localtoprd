// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ForSpcCalIntf.java

package com.sinosoft.banklns.lnsmodel.util;


public interface ForSpcCalIntf
{

	public abstract String handlerPTVForCBRA(String s, int i);

	public abstract String handlerPYForADR(String s, int i);

	public abstract String handlerPYFForADR(String s, String s1);

	public abstract String handlerPTVForTLR(String s, int i);
}
