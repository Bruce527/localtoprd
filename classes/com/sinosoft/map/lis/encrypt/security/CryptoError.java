// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CryptoError.java

package com.sinosoft.map.lis.encrypt.security;


public class CryptoError extends Error
{

	private static final long serialVersionUID = 1L;

	private CryptoError()
	{
		super("I thought this error was impossible to create!");
	}

	CryptoError(String reason)
	{
		super(reason);
	}
}
