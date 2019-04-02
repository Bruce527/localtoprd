// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Calculator.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.CError;
import com.sinosoft.banklns.utility.CErrors;

public class Calculator
{

	public CErrors mErrors;
	public String PolNo;
	private String CalCode;

	public Calculator()
	{
		mErrors = new CErrors();
		CalCode = "";
	}

	public void setCalCode(String tCalCode)
	{
		CalCode = tCalCode;
	}

	private boolean checkCalculate()
	{
		if (CalCode == null || CalCode.equals(""))
		{
			CError tError = new CError();
			tError.moduleName = "Calculator";
			tError.functionName = "checkCalculate";
			tError.errorMessage = "计算时必须有计算编码。";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}
}
