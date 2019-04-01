// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysConfig.java

package com.sinosoft.map.utility;

import java.io.PrintStream;

public class SysConfig
{

	public static final String ENDOFLINE = "\n";
	public static String TRUEHOST = "http://10.0.22.129:7001/xreport/jsp/";
	public static String FILEPATH;
	public static String FUNCTIONFILE;
	public static final String HEADOFXML = "<?xml version=\"1.0\" encoding=\"GB2312\"?>";
	public static final String SEPARATORONE = "|";
	public static final String SEPARATORTWO = "^";
	public static final String SEPARATORTREE = ";";
	public static final String SEPARATORITEM = "/";
	public static final String SEPARATORCHECK = "&";
	public static final String SEPARATORERROR = ";";
	public static final String DSTABLE = "DSTable";
	public static final String HEADOFDSTABLE = "<DSTable>";
	public static final String ENDOFDSTABLE = "</DSTable>";
	public static final String DSREPORT = "DSReport";
	public static final String HEADOFDSREPORT = "<DSReport>";
	public static final String ENDOFDSREPORT = "</DSReport>";
	public static final String DSREPORTFLAG = "$";
	public static final String FUNCTION = "Function";
	public static final String HEADOFFUNCTION = "<Function>";
	public static final String ENDOFFUNCTION = "</Function>";
	public static final String FUNCTIONFLAG = "@";
	public static final String VARIABLE = "Var";
	public static final String HEADOFVARIABLE = "<Var>";
	public static final String ENDOFVARIABLE = "</Var>";
	public static final String VARIABLEFLAG = "&";
	public static final String REPORTJOINCHAR = "_";
	public static final String FILESEPARATOR = System.getProperty("file.separator");
	public static final String FUNCREPORT = "report";
	public static final String FUNCPLUGINS = "plugins";
	public static final String SESSIONPOOLSIGN = "SESSIONPOOL";
	public static final String LRSUBJECT = "Subject";
	public static final String LRSTARTCELL = "StartCell";
	public static final String LRCOLUMNVIEWS = "ColumnViews";
	public static final String LRCOLUMNREPLACE = "ColumnReplace";
	public static final String LRSUMCOLUMNS = "SumColumns";
	public static final String LRSUMDEPEND = "SumDepend";
	public static final String LRSTRWHERE = "StrWhere";
	public static final String LRSTRAPPEND = "StrAppend";
	public static final boolean NEEDCONVERT = false;
	public static final String KEYSEPARATOR = ".";
	public static final String SYSTEMDATEPATTERN = "yyyy-MM-dd";
	public static final String DYNAMICDS = "[?สýพÝิด?]";
	public static final String DECIMALPATTERN = "0.00";

	public static String getSystemDatePattern()
	{
		return "yyyy-MM-dd";
	}

	public SysConfig()
	{
	}

	public static void main(String args[])
	{
		SysConfig sysConfig1 = new SysConfig();
	}

	static 
	{
		FILEPATH = "/export/home/bea/wlserver6.1/config/mydomain/applications/xreport_data/";
		FUNCTIONFILE = "/export/home/bea/wlserver6.1/config/mydomain/applications/xreport_data/conf/function.bsh";
		if (System.getProperty("XR.TRUEHOST") != null && !"".equals(System.getProperty("XR.TRUEHOST")))
			TRUEHOST = System.getProperty("XR.TRUEHOST");
		if (System.getProperty("XR.FILEPATH") != null && !"".equals(System.getProperty("XR.FILEPATH")))
		{
			FILEPATH = System.getProperty("XR.FILEPATH");
			FUNCTIONFILE = (new StringBuilder(String.valueOf(FILEPATH))).append("conf/function.bsh").toString();
		}
		System.err.println(FUNCTIONFILE);
	}
}
