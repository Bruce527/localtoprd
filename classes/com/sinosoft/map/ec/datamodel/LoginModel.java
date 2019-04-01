// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LoginModel.java

package com.sinosoft.map.ec.datamodel;

import java.io.Serializable;

public class LoginModel
	implements Serializable
{

	private String userType;
	private String userCode;
	private String password;
	private String manageCom;
	private String branchType;
	private String userState;
	private boolean verifyResult;
	private boolean isLogin;

	public LoginModel()
	{
	}

	public String getUserType()
	{
		return userType;
	}

	public void setUserType(String userType)
	{
		this.userType = userType;
	}

	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String manageCom)
	{
		this.manageCom = manageCom;
	}

	public String getUserState()
	{
		return userState;
	}

	public void setUserState(String userState)
	{
		this.userState = userState;
	}

	public boolean isLogin()
	{
		return isLogin;
	}

	public void setLogin(boolean isLogin)
	{
		this.isLogin = isLogin;
	}

	public String getBranchType()
	{
		return branchType;
	}

	public void setBranchType(String branchType)
	{
		this.branchType = branchType;
	}

	public boolean isVerifyResult()
	{
		return verifyResult;
	}

	public void setVerifyResult(boolean verifyResult)
	{
		this.verifyResult = verifyResult;
	}
}
