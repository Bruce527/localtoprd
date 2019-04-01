// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BigTreeMap.java

package com.sinosoft.map.utility;

import com.sinosoft.map.lis.pubfun.Arith;
import java.text.DecimalFormat;
import java.util.*;

// Referenced classes of package com.sinosoft.map.utility:
//			SSRS

public class BigTreeMap extends TreeMap
{

	public BigTreeMap()
	{
	}

	public SSRS doubleArryToSsrs(LinkedList strArryTableName)
	{
		if (strArryTableName == null)
			throw new RuntimeException("不能对没有表名的数据容器，组织表体");
		DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
		DecimalFormat format = new DecimalFormat("###,##0");
		SSRS ssrs = new SSRS(strArryTableName.size());
		int length = 0;
		for (Iterator iterator = strArryTableName.iterator(); iterator.hasNext();)
		{
			Object a = (Object)iterator.next();
			int intMiddlength = ((double[])get(a)).length;
			if (intMiddlength > length)
				length = intMiddlength;
		}

		if (get("LJYJ") != null)
			put("LJYJ", get("JBBF"));
		if (get("TLJYJ") != null)
		{
			String strHeadName[] = {
				"TJBDJBF", "TEWTZ"
			};
			double douAryTLJYJ[] = getNColSum(this, strHeadName);
			put("TLJYJ", douAryTLJYJ);
		}
		if (get("WLJYJ") != null)
		{
			String strHeadName[] = {
				"WJBBF", "WBEWQJBF", "WEWTZ"
			};
			double douAryWLJYJ[] = getNColSum(this, strHeadName);
			put("WLJYJ", douAryWLJYJ);
		}
		for (int i = 0; i < length; i++)
		{
			for (Iterator iterator1 = strArryTableName.iterator(); iterator1.hasNext();)
			{
				Object a = (Object)iterator1.next();
				double douArryaValue[] = (double[])get(a);
				if (i >= douArryaValue.length)
				{
					ssrs.SetText("");
				} else
				{
					if ((a.equals("LJYJ") || a.equals("TLJYJ") || a.equals("WLJYJ")) && i != 0)
						douArryaValue[i] = douArryaValue[i] + douArryaValue[i - 1];
					if (douArryaValue[i] <= 0.0D)
					{
						if (a.equals("BDND") || a.equals("NMYDNL"))
							ssrs.SetText("0");
						else
							ssrs.SetText("--");
					} else
					if (a.equals("BDND") || a.equals("NMYDNL") || a.equals("HG") || a.equals("HN"))
						ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0)));
					else
					if (a.equals("JBBF") || a.equals("LJYJ"))
						ssrs.SetText(decimalFormat.format(Arith.round(douArryaValue[i], 1)));
					else
					if (a.equals("XJHLH") || a.equals("XJHLM") || a.equals("XJHLL") || a.equals("XJJZ") || a.equals("LJSXM") || a.equals("LJSXL") || a.equals("LJSXH"))
						ssrs.SetText(format.format(Math.floor(douArryaValue[i])));
					else
						ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0)));
				}
			}

		}

		return ssrs;
	}

	public SSRS doubleArryToSsrs(LinkedList strArryTableName, boolean flage)
	{
		remove("WLJYJ");
		if (strArryTableName == null)
			throw new RuntimeException("不能对没有表名的数据容器，组织表体");
		DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
		DecimalFormat format = new DecimalFormat("###,##0");
		SSRS ssrs = new SSRS(strArryTableName.size());
		int length = 0;
		for (Iterator iterator = strArryTableName.iterator(); iterator.hasNext();)
		{
			Object a = (Object)iterator.next();
			int intMiddlength = ((double[])get(a)).length;
			if (intMiddlength > length)
				length = intMiddlength;
		}

		if (get("LJYJ") != null)
			put("LJYJ", get("JBBF"));
		if (get("TLJYJ") != null)
		{
			String strHeadName[] = {
				"TJBDJBF", "TEWTZ"
			};
			double douAryTLJYJ[] = getNColSum(this, strHeadName);
			put("TLJYJ", douAryTLJYJ);
		}
		if (get("WLJYJ") != null)
		{
			String strHeadName[] = {
				"WJBBF", "WBEWQJBF", "WEWTZ"
			};
			double douAryWLJYJ[] = getNColSum(this, strHeadName);
			put("WLJYJ", douAryWLJYJ);
		}
		for (int i = 0; i < length; i++)
		{
			for (Iterator iterator1 = strArryTableName.iterator(); iterator1.hasNext();)
			{
				Object a = (Object)iterator1.next();
				double douArryaValue[] = (double[])get(a);
				if (i >= douArryaValue.length)
				{
					ssrs.SetText("");
				} else
				{
					if ((a.equals("LJYJ") || a.equals("TLJYJ") || a.equals("WLJYJ")) && i != 0)
						douArryaValue[i] = douArryaValue[i] + douArryaValue[i - 1];
					if (douArryaValue[i] <= 0.0D)
					{
						if (a.equals("BDND") || a.equals("NMYDNL"))
							ssrs.SetText("0");
						else
							ssrs.SetText("--");
					} else
					if (a.equals("BDND") || a.equals("NMYDNL") || a.equals("HG") || a.equals("HN"))
						ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0)));
					else
					if (a.equals("JBBF") || a.equals("LJYJ"))
						ssrs.SetText(decimalFormat.format(Arith.round(douArryaValue[i], 1)));
					else
					if (a.equals("LJSXH") || a.equals("LJSXM") || a.equals("LJSXL") || a.equals("XJJZ"))
						ssrs.SetText(format.format(Math.floor(douArryaValue[i])));
					else
						ssrs.SetText(format.format(Arith.round(douArryaValue[i], 0)));
				}
			}

		}

		return ssrs;
	}

	private double[] getNColSum(BigTreeMap bigTreeMap, String strHeadName[])
	{
		double douAryReData[] = new double[((double[])bigTreeMap.get("BDND")).length];
		for (int i = 0; i < douAryReData.length; i++)
		{
			for (int j = 0; j < strHeadName.length; j++)
				if (i < ((double[])bigTreeMap.get(strHeadName[j])).length)
					douAryReData[i] += ((double[])bigTreeMap.get(strHeadName[j]))[i];

		}

		return douAryReData;
	}

	public void doubleArryToSum(String headName[])
	{
		int length = 0;
		String as[];
		int k = (as = headName).length;
		for (int j = 0; j < k; j++)
		{
			String a = as[j];
			int intMiddlength = ((double[])get(a)).length;
			if (intMiddlength > length)
				length = intMiddlength;
		}

		for (int i = 0; i < length; i++)
		{
			String as1[];
			int i1 = (as1 = headName).length;
			for (int l = 0; l < i1; l++)
			{
				String a = as1[l];
				double douArryaValue[] = (double[])get(a);
				if (a.equals("BT") && length - 1 != i)
					douArryaValue[i] = 0.0D;
				if (i < douArryaValue.length && i != 0)
					douArryaValue[i] = douArryaValue[i] + douArryaValue[i - 1];
			}

		}

	}
}
