// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankLNPCodeList.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.PrintStream;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class BankLNPCodeList
{

	private List relationItems;
	private List yesOrNoItems;
	private List genderItems;
	private List idTypeItems;
	private List idTypeItemPolicyholder;
	private List idVailityTypeItems;
	private List isExistsBnfItems;
	private List bnfRelationItems;
	private List paymentTypeItems;
	private List transTypeItems;
	private List banksignlist;
	private List bankinvestmentlist;
	private List bankpayintvlist;
	private List bankchooselist;
	private List bankbonuslist;
	private List bankoverduelist;
	private List bankannuitylist;
	private List bankannuityreceivelist;
	private List salechannellist;
	private List areaCodeList;

	public BankLNPCodeList()
	{
		relationItems = new ArrayList();
		yesOrNoItems = new ArrayList();
		genderItems = new ArrayList();
		idTypeItems = new ArrayList();
		idTypeItemPolicyholder = new ArrayList();
		idVailityTypeItems = new ArrayList();
		isExistsBnfItems = new ArrayList();
		bnfRelationItems = new ArrayList();
		paymentTypeItems = new ArrayList();
		transTypeItems = new ArrayList();
		banksignlist = new ArrayList();
		bankinvestmentlist = new ArrayList();
		bankpayintvlist = new ArrayList();
		bankchooselist = new ArrayList();
		bankbonuslist = new ArrayList();
		bankoverduelist = new ArrayList();
		bankannuitylist = new ArrayList();
		bankannuityreceivelist = new ArrayList();
		salechannellist = new ArrayList();
		areaCodeList = new ArrayList();
	}

	public static void main1(String args[])
	{
		BankLNPCodeList t = new BankLNPCodeList();
		t.getBanksignlist();
		t.getBankoverduelist();
	}

	public List getRelationItems()
	{
		try
		{
			if (relationItems.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankRelationship' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					relationItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return relationItems;
	}

	public List getYesOrNoItems()
	{
		try
		{
			if (yesOrNoItems.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankIsOrNo' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					yesOrNoItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return yesOrNoItems;
	}

	public List getGenderItems()
	{
		try
		{
			if (genderItems.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankPolicySex' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					genderItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return genderItems;
	}

	public List getIdTypeItems()
	{
		try
		{
			if (idTypeItems.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankCertType' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					idTypeItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return idTypeItems;
	}

	public List getIdVailityTypeItems()
	{
		try
		{
			if (idVailityTypeItems.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankCertificatesType' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					idVailityTypeItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return idVailityTypeItems;
	}

	public List getIsExistsBnfItems()
	{
		try
		{
			if (isExistsBnfItems.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankDeathBenefit' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					isExistsBnfItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return isExistsBnfItems;
	}

	public List getBnfRelationItems()
	{
		try
		{
			if (bnfRelationItems.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankBenefitAndInsured' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bnfRelationItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bnfRelationItems;
	}

	public List getPaymentTypeItems()
	{
		try
		{
			if (paymentTypeItems.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankRenewal' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					paymentTypeItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return paymentTypeItems;
	}

	public List getTransTypeItems()
	{
		try
		{
			if (transTypeItems.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankDeliveryType' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					transTypeItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return transTypeItems;
	}

	public List getBanksignlist()
	{
		try
		{
			if (banksignlist.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankSigned' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					banksignlist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return banksignlist;
	}

	public List getBankinvestmentlist()
	{
		try
		{
			if (bankinvestmentlist.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankInvestment' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankinvestmentlist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bankinvestmentlist;
	}

	public List getBankpayintvlist()
	{
		try
		{
			if (bankpayintvlist.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankFrequency' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankpayintvlist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bankpayintvlist;
	}

	public List getBankchooselist()
	{
		try
		{
			if (bankchooselist.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankNextChoose' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankchooselist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bankchooselist;
	}

	public List getBankbonuslist()
	{
		try
		{
			if (bankbonuslist.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankBonusPayMent' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankbonuslist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
			System.out.println("hahaha---getBankbonuslist");
			reconfigRisk();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bankbonuslist;
	}

	public List getBankoverduelist()
	{
		try
		{
			if (bankoverduelist.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankOverDue' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankoverduelist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bankoverduelist;
	}

	public List getBankannuitylist()
	{
		try
		{
			if (bankannuitylist.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankAnnuity' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankannuitylist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("hahaha---getBankannuitylist");
		reconfigRisk();
		return bankannuitylist;
	}

	public List getBankannuityreceivelist()
	{
		try
		{
			if (bankannuityreceivelist.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankAnnuityReceive' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankannuityreceivelist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("hahaha---getBankannuityreceivelist");
		reconfigRisk();
		return bankannuityreceivelist;
	}

	public List getAreaCodeList()
	{
		if (areaCodeList != null)
			areaCodeList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='areaCode' order by othersign";
		System.out.println((new StringBuilder("sql-->")).append(sql).toString());
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			areaCodeList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return areaCodeList;
	}

	public void setAreaCodeList(List areaCodeList)
	{
		this.areaCodeList = areaCodeList;
	}

	public List getSalechannellist()
	{
		try
		{
			if (salechannellist.size() <= 0)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "select code,codename from lnpcode where codetype='BankSalechannel' order by othersign";
				System.out.println((new StringBuilder("sql-->")).append(sql).toString());
				SSRS tSRS = tExeSQL.execSQL(sql);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					salechannellist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return salechannellist;
	}

	public void setSalechannellist(List salechannellist)
	{
		this.salechannellist = salechannellist;
	}

	public synchronized void reconfigRisk()
	{
		String L_BankBonusMode;
		String L_BankAnnMode;
		String L_BankAnnFreq;
		String L_BankCpnMode;
		ExeSQL tExeSQL;
		String riskcode[] = new String[9];
		for (int i = 0; i < riskcode.length; i++)
			riskcode[i] = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get((new StringBuilder("riskcode")).append(i).toString());

		System.out.println((new StringBuilder("+++++++++++++????????????????????")).append(riskcode).toString());
		if (riskcode[0] == null || "".equals(riskcode[0]))
		{
			riskcode[0] = "Defult";
			System.out.println("???\362????+++++Defult++++++++++++");
		}
		L_BankBonusMode = "";
		L_BankAnnMode = "";
		L_BankAnnFreq = "";
		L_BankCpnMode = "";
		tExeSQL = new ExeSQL();
		String sql = "select top 1 L_BankBonusMode,L_BankAnnMode,L_BankAnnFreq,L_BankCpnMode from [LNPRiskConfig] where";
		for (int i = 0; i < riskcode.length; i++)
			if (!"".equals(riskcode[i]))
				sql = (new StringBuilder(String.valueOf(sql))).append(" L_RiskCode='").append(riskcode[i]).append("' or").toString();

		sql = (new StringBuilder(String.valueOf(sql))).append(" 1<>1").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS.MaxRow > 0)
		{
			L_BankBonusMode = tSRS.GetText(1, 1);
			L_BankAnnMode = tSRS.GetText(1, 2);
			L_BankAnnFreq = tSRS.GetText(1, 3);
			L_BankCpnMode = tSRS.GetText(1, 4);
		} else
		{
			bankannuitylist.clear();
			bankannuityreceivelist.clear();
			bankbonuslist.clear();
			return;
		}
		try
		{
			String ITEM = "";
			if (!"-1".equals(L_BankAnnMode))
				ITEM = L_BankAnnMode;
			if (!"-1".equals(L_BankCpnMode))
				ITEM = L_BankCpnMode;
			bankannuitylist.clear();
			if (!"".equals(ITEM))
			{
				String annmode[] = ITEM.split("-");
				String sql1 = "select code,codename from lnpcode where codetype='BankAnnuity' and (";
				for (int i = 0; i < annmode.length; i++)
					sql1 = (new StringBuilder(String.valueOf(sql1))).append(" code='").append(annmode[i]).append("' or").toString();

				sql1 = (new StringBuilder(String.valueOf(sql1))).append(" 1<>1)order by othersign").toString();
				System.out.println(sql1);
				SSRS tSRS = tExeSQL.execSQL(sql1);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankannuitylist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
			bankannuityreceivelist.clear();
			if (!"-1".equals(L_BankAnnFreq))
			{
				String annmode[] = L_BankAnnFreq.split("-");
				String sql1 = "select code,codename from lnpcode where codetype='BankAnnuityReceive' and (";
				for (int i = 0; i < annmode.length; i++)
					sql1 = (new StringBuilder(String.valueOf(sql1))).append(" code='").append(annmode[i]).append("' or").toString();

				sql1 = (new StringBuilder(String.valueOf(sql1))).append(" 1<>1 )order by othersign").toString();
				System.out.println(sql1);
				SSRS tSRS = tExeSQL.execSQL(sql1);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankannuityreceivelist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
			bankbonuslist.clear();
			if (!"-1".equals(L_BankBonusMode))
			{
				String annmode[] = L_BankBonusMode.split("-");
				String sql1 = "select code,codename from lnpcode where codetype='BankBonusPayMent' and (";
				for (int i = 0; i < annmode.length; i++)
					sql1 = (new StringBuilder(String.valueOf(sql1))).append(" code='").append(annmode[i]).append("' or").toString();

				sql1 = (new StringBuilder(String.valueOf(sql1))).append(" 1<>1 )order by othersign").toString();
				System.out.println(sql1);
				SSRS tSRS = tExeSQL.execSQL(sql1);
				for (int i = 1; i <= tSRS.MaxRow; i++)
					bankbonuslist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

			}
		}
		catch (Exception e)
		{
			System.out.println("???????\361????????????????????, ??????????");
			e.printStackTrace();
		}
		return;
	}

	public static void main(String args[])
	{
		BankLNPCodeList bankLNPCodeList = new BankLNPCodeList();
		bankLNPCodeList.reconfigRisk();
	}
}
