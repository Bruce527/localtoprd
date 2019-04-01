// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FDate.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.CError;
import com.sinosoft.banklns.utility.CErrors;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FDate
	implements Cloneable, Serializable
{

	private static final long serialVersionUID = 1L;
	public CErrors mErrors;
	private final String pattern = "yyyy-MM-dd";
	private final String pattern1 = "yyyyMMdd";
	private SimpleDateFormat df;
	private SimpleDateFormat df1;

	public FDate()
	{
		mErrors = new CErrors();
		df = new SimpleDateFormat("yyyy-MM-dd");
		df1 = new SimpleDateFormat("yyyyMMdd");
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		FDate cloned = (FDate)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public Date getDate(String dateString)
	{
		Date tDate = null;
		try
		{
			if (dateString.indexOf("-") != -1)
				tDate = df.parse(dateString);
			else
				tDate = df1.parse(dateString);
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "FDate";
			tError.functionName = "getDate";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
		}
		return tDate;
	}

	public String getString(Date mDate)
	{
		String tString = null;
		if (mDate != null)
			tString = df.format(mDate);
		return tString;
	}

	public static void main(String args1[])
	{
	}
}
