// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ForSpcCalImpl.java

package com.sinosoft.banklns.lnsmodel.util;

import java.util.HashSet;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.util:
//			ForSpcCalIntf

public class ForSpcCalImpl
	implements ForSpcCalIntf
{

	public ForSpcCalImpl()
	{
	}

	public String handlerPTVForCBRA(String mainRiskCode, int payIntv)
	{
		HashSet hs = new HashSet();
		hs.add("ULES");
		hs.add("ULDX");
		if (hs.contains(mainRiskCode))
			return "12";
		else
			return (new StringBuilder(String.valueOf(payIntv))).toString();
	}

	public String handlerPTVForTLR(String mainRiskCode, int payIntv)
	{
		HashSet hs = new HashSet();
		hs.add("ULES");
		hs.add("ULDX");
		if (hs.contains(mainRiskCode))
			return "12";
		else
			return (new StringBuilder(String.valueOf(payIntv))).toString();
	}

	public String handlerPYForADR(String mainRiskCode, int payEndYear)
	{
		HashSet hs = new HashSet();
		hs.add("NWA");
		if (hs.contains(mainRiskCode))
			return (new StringBuilder(String.valueOf(payEndYear))).toString();
		else
			return null;
	}

	public String handlerPYFForADR(String mainRiskCode, String payEndYearFlag)
	{
		HashSet hs = new HashSet();
		hs.add("NWA");
		if (hs.contains(mainRiskCode))
			return payEndYearFlag;
		else
			return null;
	}
}
