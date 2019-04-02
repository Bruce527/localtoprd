// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankValidateDealSubRewImpl.java

package com.sinosoft.banklns.lnsmodel;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			BankValidateDealIface

public class BankValidateDealSubRewImpl
	implements BankValidateDealIface
{

	private List errors;

	public BankValidateDealSubRewImpl()
	{
		errors = new ArrayList();
	}

	public boolean validateByContNo(String contNo)
	{
		if (errors != null)
			errors.clear();
		boolean flag = false;
		return flag;
	}

	public List getErroList()
	{
		return errors;
	}

	public String showErrors()
	{
		return showFormate1();
	}

	private String showFormate1()
	{
		String temp = null;
		for (int i = 1; errors != null && i <= errors.size(); i++)
			if (i <= 1)
				temp = (new StringBuilder(String.valueOf(temp))).append("校验未通过项如下:\n").append(i).append("、").append((String)errors.get(i)).append("\n").toString();
			else
				temp = (new StringBuilder(String.valueOf(temp))).append(i).append("、").append((String)errors.get(i)).append("\n").toString();

		return temp;
	}
}
