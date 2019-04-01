// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LogInfo.java

package com.sinosoft.map.common.logs;


public class LogInfo
{

	private String usercode;
	private String operateStr;
	private String operateDate;
	private String operateTime;

	public LogInfo()
	{
		usercode = "";
	}

	public String getUsercode()
	{
		return usercode;
	}

	public void setUsercode(String usercode)
	{
		this.usercode = usercode;
	}

	public String getOperateStr()
	{
		return operateStr;
	}

	public void setOperateStr(String operateStr)
	{
		this.operateStr = operateStr;
	}

	public String getOperateDate()
	{
		return operateDate;
	}

	public void setOperateDate(String operateDate)
	{
		this.operateDate = operateDate;
	}

	public String getOperateTime()
	{
		return operateTime;
	}

	public void setOperateTime(String operateTime)
	{
		this.operateTime = operateTime;
	}
}
