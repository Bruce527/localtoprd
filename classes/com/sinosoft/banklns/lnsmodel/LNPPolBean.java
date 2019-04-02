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
				schema.setInsuYearFlag((new StringBuilder("è‡?")).append(schema.getPayLocation()).append("å²?").toString());
			if ("A".equals(schema.getPremToAmnt()) && "106".equals(schema.getPayLocation()))
				schema.setInsuYearFlag("ç»ˆèº«");
			if ("Y".equals(schema.getPremToAmnt()))
				schema.setInsuYearFlag((new StringBuilder("ä¿éšœ")).append(schema.getPayLocation()).append("å¹?").toString());
			if ("A".equals(schema.getAcciYearFlag()))
				schema.setPayEndYearFlag((new StringBuilder("è‡?")).append(schema.getPayMode()).append("å²?").toString());
			if ("Y".equals(schema.getAcciYearFlag()) && "1000".equals(schema.getPayMode()))
				schema.setPayEndYearFlag("è¶¸äº¤");
			if ("Y".equals(schema.getAcciYearFlag()) && !"1000".equals(schema.getPayMode()))
				schema.setPayEndYearFlag((new StringBuilder("ç¼´è´¹")).append(schema.getPayMode()).append("å¹?").toString());
		} else
		if ("N".equals(vRiskType))
		{
			if ("A".equals(schema.getPremToAmnt()) && !schema.getPayLocation().equals(String.valueOf(SpecialProductFun.getRiskPro(schema.getRiskCode()))))
				schema.setInsuYearFlag((new StringBuilder("è‡?")).append(schema.getPayLocation()).append("å²?").toString());
			if ("A".equals(schema.getPremToAmnt()) && schema.getPayLocation().equals(String.valueOf(SpecialProductFun.getRiskPro(schema.getRiskCode()))))
				schema.setInsuYearFlag("ç»ˆèº«");
			if ("Y".equals(schema.getPremToAmnt()))
				schema.setInsuYearFlag((new StringBuilder("ä¿éšœ")).append(schema.getPayLocation()).append("å¹?").toString());
			if ("A".equals(schema.getAcciYearFlag()))
				schema.setPayEndYearFlag((new StringBuilder("è‡?")).append(schema.getPayMode()).append("å²?").toString());
			if ("Y".equals(schema.getAcciYearFlag()) && "1000".equals(schema.getPayMode()))
				schema.setPayEndYearFlag("è¶¸äº¤");
			if ("Y".equals(schema.getAcciYearFlag()) && !"1000".equals(schema.getPayMode()))
				schema.setPayEndYearFlag((new StringBuilder("ç¼´è´¹")).append(schema.getPayMode()).append("å¹?").toString());
		} else
		{
			if ("A".equals(schema.getInsuYearFlag()) && schema.getInsuYear() != SpecialProductFun.getRiskPro(schema.getRiskCode()))
				schema.setInsuYearFlag((new StringBuilder("è‡?")).append(schema.getInsuYear()).append("å²?").toString());
			if ("A".equals(schema.getInsuYearFlag()) && schema.getInsuYear() == SpecialProductFun.getRiskPro(schema.getRiskCode()))
				schema.setInsuYearFlag("ç»ˆèº«");
			if ("Y".equals(schema.getInsuYearFlag()))
				schema.setInsuYearFlag((new StringBuilder("ä¿éšœ")).append(schema.getInsuYear()).append("å¹?").toString());
			if ("A".equals(schema.getPayEndYearFlag()))
				schema.setPayEndYearFlag((new StringBuilder("è‡?")).append(schema.getPayEndYear()).append("å²?").toString());
			if ("Y".equals(schema.getPayEndYearFlag()) && schema.getPayEndYear() == 1000)
				schema.setPayEndYearFlag("è¶¸äº¤");
			if ("Y".equals(schema.getPayEndYearFlag()) && schema.getPayEndYear() != 1000)
				schema.setPayEndYearFlag((new StringBuilder("ç¼´è´¹")).append(schema.getPayEndYear()).append("å¹?").toString());
		}
		if (schema.getPayIntv() == 1)
			schema.setRemark("å¹´äº¤");
		if (schema.getPayIntv() == 2)
			schema.setRemark("åŠå¹´äº?");
		if (schema.getPayIntv() == 3)
			schema.setRemark("å­£äº¤");
		if (schema.getPayIntv() == 4)
			schema.setRemark("æœˆäº¤");
		if (schema.getPayIntv() == 5)
			schema.setRemark("ä¸?æ¬¡æ??");
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
