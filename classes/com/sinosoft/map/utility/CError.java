// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CError.java

package com.sinosoft.map.utility;

import com.sinosoft.map.lis.pubfun.PubFun;
import java.io.PrintStream;
import java.lang.reflect.Field;

// Referenced classes of package com.sinosoft.map.utility:
//			CErrors

public class CError
{

	public static final String TYPE_NONEERR = "0";
	public static final String TYPE_FORBID = "1";
	public static final String TYPE_ALLOW = "2";
	public static final String TYPE_NEEDSELECT = "3";
	public static final String TYPE_UNKNOW = "4";
	public static final String SYSTEM = "10";
	public static final String COMMUNICATION = "11";
	public static final String SAFETY = "12";
	public static final String BL_RISK = "2101";
	public static final String BL_FINANCE = "2102";
	public static final String BL_TB = "2103";
	public static final String BL_BQ = "2104";
	public static final String BL_CASE = "2105";
	public static final String BL_LIVEGET = "2106";
	public static final String BL_AGENT = "2107";
	public static final String BL_BANK = "2108";
	public static final String BL_UNKNOW = "2109";
	public static final String DB_OPERATE = "22";
	public static final String UNKNOW = "23";
	public static final String TYPE_NONE = "0";
	public static final String WS_SERVER_CALL = "02010001";
	public static final String WS_TRANS_SOAP = "02010002";
	public String errorType;
	public String errorNo;
	public String moduleName;
	public String functionName;
	public String errorMessage;

	public CError()
	{
		errorType = "1";
		errorNo = "23";
	}

	public CError(String errString)
	{
		errorType = "1";
		errorNo = "23";
		errorMessage = errString;
	}

	public CError(String errString, String cModuleName, String cFunctionName)
	{
		errorType = "1";
		errorNo = "23";
		errorMessage = errString;
		moduleName = cModuleName;
		functionName = cFunctionName;
	}

	public static void buildErr(Object o, String errMessage)
	{
		buildErr(o, "", errMessage, "1", "23");
	}

	public static void buildErr(Object o, String errMessage, String errType, String errNo)
	{
		buildErr(o, "", errMessage.trim(), errType, errNo);
	}

	public static void buildErr(Object o, String functionName, String errMessage, String errType, String errNo)
	{
		try
		{
			CError tError = new CError();
			tError.moduleName = PubFun.getClassFileName(o);
			tError.functionName = functionName;
			tError.errorMessage = errMessage.trim();
			tError.errorType = errType;
			tError.errorNo = errNo;
			Class c = o.getClass();
			Field f = c.getField("mErrors");
			((CErrors)f.get(o)).addOneError(tError);
			System.out.print("在（");
			System.out.print(tError.moduleName);
			System.out.print("）中抛出如下错误：");
			System.out.println(errMessage);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void buildErr(Object o, String errMessage, CErrors e)
	{
		buildErr(o, "", errMessage.trim(), e, "1", "23");
	}

	public static void buildErr(Object o, String errMessage, CErrors e, String errType, String errNo)
	{
		buildErr(o, "", errMessage, e, errType, errNo);
	}

	public static void buildErr(Object o, String functionName, String errMessage, CErrors e, String errType, String errNo)
	{
		try
		{
			buildErr(o, functionName, errMessage, errType, errNo);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void main(String args[])
	{
	}
}
