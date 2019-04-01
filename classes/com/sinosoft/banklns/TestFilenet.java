// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TestFilenet.java

package com.sinosoft.banklns;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class TestFilenet
{

	public TestFilenet()
	{
	}

	public static void main(String args[])
	{
		try
		{
			String uri = "http://10.164.253.51:8081/wsi/FNCEWS40MTOM/";
			String user = "P8services";
			String password = "Hello01";
			String osName = "IWS";
			LoginContext lc = new LoginContext(osName);
			lc.login();
			javax.security.auth.Subject subject = lc.getSubject();
		}
		catch (LoginException e)
		{
			e.printStackTrace();
		}
	}
}
