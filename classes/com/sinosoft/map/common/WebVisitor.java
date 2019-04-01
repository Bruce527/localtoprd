// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WebVisitor.java

package com.sinosoft.map.common;

import com.sinosoft.map.common.config.BaseConfig;
import com.sinosoft.map.user.UserModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class WebVisitor extends BaseConfig
{

	private UserModel _user;
	private boolean _login;
	private boolean _hidden;
	private String _ip;
	private String _firstTime;
	private long _lastVisitTime;
	private boolean halfLogin;
	private String operateStr;
	private String operateDate;
	private String operateTime;

	public String getOperateTime()
	{
		return operateTime;
	}

	public void setOperateTime(String operateTime)
	{
		this.operateTime = operateTime;
	}

	public String getOperateDate()
	{
		return operateDate;
	}

	public void setOperateDate(String operateDate)
	{
		this.operateDate = operateDate;
	}

	public String getOperateStr()
	{
		return operateStr;
	}

	public void setOperateStr(String operateStr)
	{
		this.operateStr = operateStr;
	}

	public boolean isHalfLogin()
	{
		return halfLogin;
	}

	public void setHalfLogin(boolean halfLogin)
	{
		this.halfLogin = halfLogin;
	}

	public WebVisitor()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest hsr = (HttpServletRequest)ec.getRequest();
		_ip = hsr.getRemoteAddr();
		_lastVisitTime = System.currentTimeMillis();
		Date nowTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		_firstTime = sdf.format(nowTime);
	}

	public String getVisitorKey()
	{
		return _ip;
	}

	public void setUser(UserModel user)
	{
		_user = user;
	}

	public UserModel getUser()
	{
		if (_user == null)
			_user = new UserModel();
		return _user;
	}

	public void setLogin(boolean login)
	{
		_login = login;
	}

	public boolean isLogin()
	{
		return _login;
	}

	public void setHidden(boolean hidden)
	{
		_hidden = hidden;
	}

	public boolean isHidden()
	{
		return _hidden;
	}

	public String getIp()
	{
		return _ip;
	}

	public void setIp(String ip)
	{
		_ip = ip;
	}

	public String getFirstTime()
	{
		return _firstTime;
	}

	public void setLastVisitTime(long lastVisitTime)
	{
		_lastVisitTime = lastVisitTime;
	}

	public long getLastVisitTime()
	{
		return _lastVisitTime;
	}
}
