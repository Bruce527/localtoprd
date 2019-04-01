// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserModel.java

package com.sinosoft.map.user;

import java.io.Serializable;

public class UserModel
	implements Serializable
{

	private String userType;
	private String userCode;
	private String password;
	private String manageCom;
	private String branchType;
	private String branchAttr;
	private String userState;
	private String lastLoginDate;
	private String lastLoginTime;
	private String loginDate;
	private String loginTime;
	private String calDate;
	private String calWeek;
	private String ecGrade;
	private String name;
	private String agentGrade;
	private String menus[];
	private boolean popupFlag;
	private boolean isLogin;
	private String pwdLastSetDate;
	private String showUserCode;
	private String showBranchattr;

	public UserModel()
	{
		popupFlag = true;
	}

	public String getPwdLastSetDate()
	{
		return pwdLastSetDate;
	}

	public void setPwdLastSetDate(String pwdLastSetDate)
	{
		this.pwdLastSetDate = pwdLastSetDate;
	}

	public String getCalWeek()
	{
		return calWeek;
	}

	public void setCalWeek(String calWeek)
	{
		this.calWeek = calWeek;
	}

	public String getBranchAttr()
	{
		return branchAttr;
	}

	public void setBranchAttr(String branchAttr)
	{
		this.branchAttr = branchAttr;
	}

	public String getUserType()
	{
		return userType;
	}

	public String getLoginTime()
	{
		return loginTime;
	}

	public void setLoginTime(String loginTime)
	{
		this.loginTime = loginTime;
	}

	public String getLastLoginTime()
	{
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
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

	public String getLastLoginDate()
	{
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate)
	{
		this.lastLoginDate = lastLoginDate;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAgentGrade()
	{
		return agentGrade;
	}

	public void setAgentGrade(String agentGrade)
	{
		this.agentGrade = agentGrade;
	}

	public String getLoginDate()
	{
		return loginDate;
	}

	public void setLoginDate(String loginDate)
	{
		this.loginDate = loginDate;
	}

	public String getCalDate()
	{
		return calDate;
	}

	public void setCalDate(String calDate)
	{
		this.calDate = calDate;
	}

	public String getEcGrade()
	{
		return ecGrade;
	}

	public void setEcGrade(String ecGrade)
	{
		this.ecGrade = ecGrade;
	}

	public String[] getMenus()
	{
		return menus;
	}

	public void setMenus(String menus[])
	{
		this.menus = menus;
	}

	public boolean isPopupFlag()
	{
		return popupFlag;
	}

	public void setPopupFlag(boolean popupFlag)
	{
		this.popupFlag = popupFlag;
	}

	public String getShowUserCode()
	{
		return showUserCode;
	}

	public void setShowUserCode(String showUserCode)
	{
		this.showUserCode = showUserCode;
	}

	public String getShowBranchattr()
	{
		return showBranchattr;
	}

	public void setShowBranchattr(String showBranchattr)
	{
		this.showBranchattr = showBranchattr;
	}
}
