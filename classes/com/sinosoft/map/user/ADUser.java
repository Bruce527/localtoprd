// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ADUser.java

package com.sinosoft.map.user;


public class ADUser
{

	private String userCode;
	private String passWord;
	private String pwdLastSetDate;
	private boolean isLogin;
	private String newPassWord;

	public ADUser()
	{
	}

	public String getNewPassWord()
	{
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord)
	{
		this.newPassWord = newPassWord;
	}

	public String getPwdLastSetDate()
	{
		return pwdLastSetDate;
	}

	public void setPwdLastSetDate(String pwdLastSetDate)
	{
		this.pwdLastSetDate = pwdLastSetDate;
	}

	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public boolean isLogin()
	{
		return isLogin;
	}

	public void setLogin(boolean isLogin)
	{
		this.isLogin = isLogin;
	}
}
