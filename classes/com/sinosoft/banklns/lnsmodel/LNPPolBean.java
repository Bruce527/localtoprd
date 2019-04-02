// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPolBean.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.schema.LNPPolSchema;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			SpecialProductFun

public class LNPPolBean
{

	private LNPPolSchema schema;
	private String amntMoney;
	private String premMoney;
	private String riskName;
	private static DecimalFormat formatMoney = new DecimalFormat("#,##0.00");
	private static Map mappRiskNames = new HashMap();

	public LNPPolBean()
	{
		schema = new LNPPolSchema();
	}

	private String turnNullToString(Object object)
	{
		String rst = "";
		try
		{
			rst = object != null ? (new StringBuilder()).append(object).toString() : "";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rst.trim();
	}

	private static void mappRiskNames()
	{
		mappRiskNames.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select riskcode,RiskName from mdes_dicode";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			mappRiskNames.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	private String getRiskName(String riskCode)
	{
		System.out.println((new StringBuilder("--------")).append(riskCode).toString());
		if (!turnNullToString(riskCode).equals("") && !mappRiskNames.containsKey(riskCode))
			mappRiskNames();
		return (String)mappRiskNames.get(riskCode);
		Exception exception;
		exception;
		return "";
	}

	public void setSchema(LNPPolSchema schema, String vRiskType)
	{
		if ("Z".equals(vRiskType))
		{
			if ("A".equals(schema.getPremToAmnt()) && !"106".equals(schema.getPayLocation()))
				schema.setInsuYearFlag((new StringBuilder("至")).append(schema.getPayLocation()).append("岁").toString());
			if ("A".equals(schema.getPremToAmnt()) && "106".equals(schema.getPayLocation()))
				schema.setInsuYearFlag("终身");
			if ("Y".equals(schema.getPremToAmnt()))
				schema.setInsuYearFlag((new StringBuilder("保障")).append(schema.getPayLocation()).append("年").toString());
			if ("A".equals(schema.getAcciYearFlag()))
				schema.setPayEndYearFlag((new StringBuilder("至")).append(schema.getPayMode()).append("岁").toString());
			if ("Y".equals(schema.getAcciYearFlag()) && "1000".equals(schema.getPayMode()))
				schema.setPayEndYearFlag("趸交");
			if ("Y".equals(schema.getAcciYearFlag()) && !"1000".equals(schema.getPayMode()))
				schema.setPayEndYearFlag((new StringBuilder("缴费")).append(schema.getPayMode()).append("年").toString());
		} else
		if ("N".equals(vRiskType))
		{
			if ("A".equals(schema.getPremToAmnt()) && !schema.getPayLocation().equals(String.valueOf(SpecialProductFun.getRiskPro(schema.getRiskCode()))))
				schema.setInsuYearFlag((new StringBuilder("至")).append(schema.getPayLocation()).append("岁").toString());
			if ("A".equals(schema.getPremToAmnt()) && schema.getPayLocation().equals(String.valueOf(SpecialProductFun.getRiskPro(schema.getRiskCode()))))
				schema.setInsuYearFlag("终身");
			if ("Y".equals(schema.getPremToAmnt()))
				schema.setInsuYearFlag((new StringBuilder("保障")).append(schema.getPayLocation()).append("年").toString());
			if ("A".equals(schema.getAcciYearFlag()))
				schema.setPayEndYearFlag((new StringBuilder("至")).append(schema.getPayMode()).append("岁").toString());
			if ("Y".equals(schema.getAcciYearFlag()) && "1000".equals(schema.getPayMode()))
				schema.setPayEndYearFlag("趸交");
			if ("Y".equals(schema.getAcciYearFlag()) && !"1000".equals(schema.getPayMode()))
				schema.setPayEndYearFlag((new StringBuilder("缴费")).append(schema.getPayMode()).append("年").toString());
		} else
		{
			if ("A".equals(schema.getInsuYearFlag()) && schema.getInsuYear() != SpecialProductFun.getRiskPro(schema.getRiskCode()))
				schema.setInsuYearFlag((new StringBuilder("至")).append(schema.getInsuYear()).append("岁").toString());
			if ("A".equals(schema.getInsuYearFlag()) && schema.getInsuYear() == SpecialProductFun.getRiskPro(schema.getRiskCode()))
				schema.setInsuYearFlag("终身");
			if ("Y".equals(schema.getInsuYearFlag()))
				schema.setInsuYearFlag((new StringBuilder("保障")).append(schema.getInsuYear()).append("年").toString());
			if ("A".equals(schema.getPayEndYearFlag()))
				schema.setPayEndYearFlag((new StringBuilder("至")).append(schema.getPayEndYear()).append("岁").toString());
			if ("Y".equals(schema.getPayEndYearFlag()) && schema.getPayEndYear() == 1000)
				schema.setPayEndYearFlag("趸交");
			if ("Y".equals(schema.getPayEndYearFlag()) && schema.getPayEndYear() != 1000)
				schema.setPayEndYearFlag((new StringBuilder("缴费")).append(schema.getPayEndYear()).append("年").toString());
		}
		if (schema.getPayIntv() == 1)
			schema.setRemark("年交");
		if (schema.getPayIntv() == 2)
			schema.setRemark("半年交");
		if (schema.getPayIntv() == 3)
			schema.setRemark("季交");
		if (schema.getPayIntv() == 4)
			schema.setRemark("月交");
		if (schema.getPayIntv() == 5)
			schema.setRemark("一次性");
		this.schema = schema;
	}

	public String getAmntMoney()
	{
		return formatMoney.format(schema.getAmnt());
	}

	public void setAmntMoney(String amntMoney)
	{
		this.amntMoney = amntMoney;
	}

	public String getPremMoney()
	{
		return formatMoney.format(schema.getPrem());
	}

	public void setPremMoney(String premMoney)
	{
		this.premMoney = premMoney;
	}

	public LNPPolSchema getSchema()
	{
		return schema;
	}

	public String getRiskName()
	{
		return getRiskName(schema.getRiskCode());
	}

	static 
	{
		mappRiskNames();
	}
}
