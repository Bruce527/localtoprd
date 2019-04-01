// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MailAuthenticator.java

package com.sinosoft.map.ec.utility;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator
{

	private String id;
	private String password;

	public MailAuthenticator(String id, String password)
	{
		this.id = id;
		this.password = password;
	}

	public PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(id, password);
	}
}
