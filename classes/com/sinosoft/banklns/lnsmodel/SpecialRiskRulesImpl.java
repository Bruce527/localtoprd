// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SpecialRiskRulesImpl.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
import java.util.ArrayList;
import java.util.List;

public class SpecialRiskRulesImpl
{

	public SpecialRiskRulesImpl()
	{
	}

	public List checkApp(String appage, String age, String degree, String value)
	{
		List result = new ArrayList();
		String msg = "";
		if (age == null || age.equals("") || degree == null || degree.equals("") || value == null || value.equals(""))
		{
			msg = "����д����Ͷ�ʱ��շѡ�����Ͷ�ʿ�ʼ���䡢����Ͷ���������?";
			result.add(msg);
		} else
		{
			int iappage = Integer.parseInt(appage);
			int iage = Integer.parseInt(age);
			int idegree = Integer.parseInt(degree);
			int ivalue = Integer.parseInt(value);
			if (iage < iappage)
			{
				msg = "����Ͷ�ʿ�ʼ������СΪͶ���˵�ǰ���䣡";
				result.add(msg);
			}
			if (ivalue < 2000)
			{
				msg = "����Ͷ�ʱ��շ�ÿ������2000Ԫ��";
				result.add(msg);
			}
			if (ivalue % 1000 != 0)
			{
				msg = "����Ͷ�ʱ��շ���1000Ϊ��λ��ӣ�?";
				result.add(msg);
			}
		}
		return result;
	}

	public List checkGet(String appage, String age, String degree, String value)
	{
		List result = new ArrayList();
		String msg = "";
		if (age == null || age.equals("") || degree == null || degree.equals("") || value == null || value.equals(""))
		{
			msg = "����д������ȡ��������ȡ��ʼ���䡢������ȡ������";
			result.add(msg);
		} else
		{
			int tappage = Integer.parseInt(appage);
			int tage = Integer.parseInt(age);
			int tdegree = Integer.parseInt(degree);
			int tvalue = Integer.parseInt(value);
			if (tage < tappage)
			{
				msg = "������ȡ��ʼ������СΪͶ���˵�ǰ���䣡";
				result.add(msg);
			}
		}
		return result;
	}

	public List checkAccount(String appage, String age, String protagonist, String exponent, String balance, String solidity, String prevent, 
			String AccountStr)
	{
		List result = new ArrayList();
		String msg = "";
		if (age == null || age.equals("") || protagonist.equals("0") && exponent.equals("0") && balance.equals("0") && solidity.equals("0") && prevent.equals("0"))
		{
			msg = "����д�ʻ�����ĸ���?";
			result.add(msg);
		} else
		{
			int aappage = Integer.parseInt(appage);
			int aage = Integer.parseInt(age);
			int aprotagonist = Integer.parseInt(protagonist);
			int aexponent = Integer.parseInt(exponent);
			int abalance = Integer.parseInt(balance);
			int asolidity = Integer.parseInt(solidity);
			int aprevent = Integer.parseInt(prevent);
			int a = aprotagonist + aexponent + abalance + asolidity + aprevent;
			if (AccountStr != null && AccountStr.length() > 0)
			{
				String temp[] = AccountStr.split("\\$");
				for (int k = 0; k < temp.length; k++)
				{
					String acc[] = temp[k].split("@");
					String accAge = acc[0];
					if (!age.equals(accAge))
						continue;
					msg = "�����˴������Ѿ�������ʻ����벻Ҫ�ظ����䣡��?";
					result.add(msg);
					break;
				}

			} else
			if (aage != aappage)
			{
				msg = "�ʻ������һ�������д��";
				result.add(msg);
			}
			if (aage < aappage)
			{
				msg = "�ʻ�����������СΪͶ���˵�ǰ���䣡";
				result.add(msg);
			}
			if (a != 100)
			{
				msg = "�������ʻ��ĺ�ӦΪ100%��";
				result.add(msg);
			}
		}
		return result;
	}

	public List checkRules(PolElementSchema inPolElementSchema)
	{
		return null;
	}
}
