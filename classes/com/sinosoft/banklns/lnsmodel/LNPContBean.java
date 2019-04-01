// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPContBean.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.util.HashMap;
import java.util.Map;

public class LNPContBean
{

	private LNPContSchema schema;
	private String prem;
	private String showState;
	private String netcode;
	private String riskList;
	private String signCom;
	private String display;
	private static Map MapSignCom = new HashMap();

	public LNPContBean()
	{
		display = "none";
	}

	public String getRiskList()
	{
		return riskList;
	}

	public String getDisplay()
	{
		return display;
	}

	public void setDisplay(String display)
	{
		this.display = display;
	}

	public static Map getMapSignCom()
	{
		return MapSignCom;
	}

	public static void setMapSignCom(Map mapSignCom)
	{
		MapSignCom = mapSignCom;
	}

	public void setRiskList(String riskList)
	{
		this.riskList = riskList;
	}

	public String getShowState()
	{
		return showState;
	}

	public void setShowState(String showState)
	{
		this.showState = showState;
	}

	public LNPContSchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPContSchema schema)
	{
		this.schema = schema;
	}

	public String getPrem()
	{
		return (new StringBuilder()).append(schema.getSumPrem()).toString();
	}

	public void setPrem(String prem)
	{
		this.prem = prem;
	}

	public String getNetcode()
	{
		return netcode;
	}

	public void setNetcode(String netcode)
	{
		this.netcode = netcode;
	}

	public String getSignCom()
	{
		return getMappingSignCom(schema.getSignCom());
	}

	public void setSignCom(String signCom)
	{
		this.signCom = signCom;
	}

	private String getMappingSignCom(String ComCode)
	{
		String tCode = ComCode;
		try
		{
			if (tCode != null && !"".equals(tCode))
				if (MapSignCom.containsKey(ComCode))
				{
					tCode = (String)MapSignCom.get(ComCode);
				} else
				{
					initMapSignManage();
					tCode = (String)MapSignCom.get(ComCode);
				}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return tCode;
	}

	private static void initMapSignManage()
	{
		MapSignCom.clear();
		String sql = "select code,codename from lnpcode where codetype='lnpManageCom'";
		ExeSQL execSQL = new ExeSQL();
		SSRS ssrs = execSQL.execSQL(sql);
		for (int i = 1; i <= ssrs.MaxRow; i++)
			MapSignCom.put(ssrs.GetText(i, 1), ssrs.GetText(i, 2));

	}

	static 
	{
		initMapSignManage();
	}
}
