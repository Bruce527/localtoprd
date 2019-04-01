// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TurnTabController.java

package com.sinosoft.banklns;

import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.PrintStream;

public class TurnTabController
{

	private String _FToO;
	private String _fromView;
	private String _outCome;
	private String _suc_target;
	private String _err_target;
	private String _lastID;

	public TurnTabController()
	{
	}

	public String turnTabAction()
	{
		System.out.println((new StringBuilder("------------>|request_suc:")).append(_suc_target).append(" | failed:").append(_err_target).append(" | fromTabId:").append(_fromView).append(" | toTabId:").append(_outCome).toString());
		save();
		return _suc_target;
		Exception e;
		e;
		e.printStackTrace();
		return _err_target;
	}

	public void save()
	{
		ExeSQL exeSql = new ExeSQL();
		String sql = (new StringBuilder("update lnpcont set handler='")).append(_fromView).append("',remark='").append(_outCome).append("',bankaccno='").append(_suc_target).append("',accname='").append(_err_target).append("' where ContNo='098766213213'").toString();
		exeSql.execUpdateSQL(sql);
	}

	public void query()
	{
		ExeSQL exeSql = new ExeSQL();
		String sql = "select handler,remark,bankaccno,accname from lnpcont where ContNo='098766213213'";
		SSRS ssrs = exeSql.execSQL(sql);
		for (int i = 1; i <= ssrs.MaxRow; i++)
			_lastID = ssrs.GetText(i, 2);

	}

	public String get_suc_target()
	{
		return _suc_target;
	}

	public void set_suc_target(String sucTarget)
	{
		_suc_target = sucTarget;
	}

	public String get_err_target()
	{
		return _err_target;
	}

	public void set_err_target(String errTarget)
	{
		_err_target = errTarget;
	}

	public String get_fromView()
	{
		return _fromView;
	}

	public void set_fromView(String fromView)
	{
		_fromView = fromView;
	}

	public String get_outCome()
	{
		return _outCome;
	}

	public void set_outCome(String outCome)
	{
		_outCome = outCome;
	}

	public String get_FToO()
	{
		return _FToO;
	}

	public void set_FToO(String fToO)
	{
		_FToO = fToO;
	}

	public String get_lastID()
	{
		query();
		return _lastID;
	}

	public void set_lastID(String lastID)
	{
		_lastID = lastID;
	}

	public static void main(String args1[])
	{
	}
}
