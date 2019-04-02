// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RiskInfoImpl.java

package com.sinosoft.banklns.lnsmodel.riskinfo;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import java.io.PrintStream;

public class RiskInfoImpl
{

	public RiskInfoImpl()
	{
	}

	private String getHost()
	{
		String sHost = "";
		LNPStaticMsgUrlSet LNPStaticMsgUrlSet = (new LNPStaticMsgUrlDB()).executeQuery("select * from LNPStaticMsgUrl where assurancecode='riskinfo'");
		if (LNPStaticMsgUrlSet != null)
		{
			for (int m = 1; m <= LNPStaticMsgUrlSet.size(); m++)
			{
				LNPStaticMsgUrlSchema staticMsgSchema = LNPStaticMsgUrlSet.get(m);
				sHost = staticMsgSchema.getMsgUrl();
			}

		}
		return sHost;
	}

	public String getDocument(String riskName)
	{
		String result = null;
		if (riskName.equals("0"))
			result = "0=����ѡ��������";
		else
			result = "0=��ѡ���ĵ�����";
		String sHost = getHost();
		LNPStaticMsgUrlSet LNPStaticMsgUrlSet = (new LNPStaticMsgUrlDB()).executeQuery((new StringBuilder("select * from LNPStaticMsgUrl where assurancecode='")).append(riskName).append("' order by flag").toString());
		if (LNPStaticMsgUrlSet != null)
		{
			for (int m = 1; m <= LNPStaticMsgUrlSet.size(); m++)
			{
				if (!result.equals(""))
					result = (new StringBuilder(String.valueOf(result))).append("&").toString();
				LNPStaticMsgUrlSchema staticMsgSchema = LNPStaticMsgUrlSet.get(m);
				String sURL = staticMsgSchema.getMsgUrl();
				if (!sHost.equals(""))
					sURL = sURL.replace("..", sHost);
				if (staticMsgSchema.getFlag().equals("1"))
					result = (new StringBuilder(String.valueOf(result))).append(sURL).append("=����").toString();
				else
				if (staticMsgSchema.getFlag().equals("2"))
					result = (new StringBuilder(String.valueOf(result))).append(sURL).append("=����").toString();
				else
				if (staticMsgSchema.getFlag().equals("3"))
					result = (new StringBuilder(String.valueOf(result))).append(sURL).append("=����").toString();
			}

		}
		return result;
	}

	public String getAllRiskType(String channel)
	{
		String result = "every=��������";
		String sql = (new StringBuilder("Select * From lnpcode where codetype='RiskType' and code in (select distinct riskprop from lnpriskapp where  riskcode in (select riskcode from lnpriskcomctrl where salechnl='")).append(channel).append("'))").append(" order by code").toString();
		LNPCodeSet ldCodeSet = (new LNPCodeDB()).executeQuery(sql);
		if (ldCodeSet != null)
		{
			for (int i = 1; i <= ldCodeSet.size(); i++)
			{
				LNPCodeSchema ldcodeSchema = ldCodeSet.get(i);
				if (!result.equals(""))
					result = (new StringBuilder(String.valueOf(result))).append("&").toString();
				result = (new StringBuilder(String.valueOf(result))).append(ldcodeSchema.getCode()).append("=").append(ldcodeSchema.getCodeName()).toString();
			}

			String lmRiskAppSet = getAllSubRisk(channel);
			if (lmRiskAppSet != null && !lmRiskAppSet.equals("0=��ѡ������"))
				result = (new StringBuilder(String.valueOf(result))).append("&addition=������").toString();
			return result;
		} else
		{
			System.out.println("��ѯ��������,���ݻ�ȡʧ��");
			return null;
		}
	}

	public String getAllSubRisk(String channel)
	{
		String sql = (new StringBuilder("select *  from lmrisk where riskcode in (  select riskcode  from lmriskapp where  riskcode in (select riskcode from lmriskcomctrl where salechnl='")).append(channel).append("')").append(" and subriskflag='S')").append(" order by riskcode").toString();
		System.out.println(sql);
		LNPRiskSet setLMRisk = (new LNPRiskDB()).executeQuery(sql);
		if (setLMRisk != null)
		{
			String result = "0=��ѡ������";
			for (int i = 1; i <= setLMRisk.size(); i++)
			{
				LNPRiskSchema lmRiskSchema = setLMRisk.get(i);
				if (!result.equals(""))
					result = (new StringBuilder(String.valueOf(result))).append("&").toString();
				result = (new StringBuilder(String.valueOf(result))).append(lmRiskSchema.getRiskCode()).append("=[").append(lmRiskSchema.getRiskCode()).append("]").append(lmRiskSchema.getRiskShortName()).toString();
			}

			return result;
		} else
		{
			System.out.println("��ѯ���и�����,���ݻ�ȡʧ��");
			return null;
		}
	}

	public String getAllRiskKind(String channel)
	{
		String sql = (new StringBuilder("select *  from lmrisk where riskcode in (  select riskcode  from lmriskapp where  riskcode in (select riskcode from lmriskcomctrl where salechnl='")).append(channel).append("'))").append(" order by riskcode").toString();
		System.out.println(sql);
		LNPRiskSet setLMRisk = (new LNPRiskDB()).executeQuery(sql);
		if (setLMRisk != null)
		{
			String result = "0=��ѡ������";
			for (int i = 1; i <= setLMRisk.size(); i++)
			{
				LNPRiskSchema lmRiskSchema = setLMRisk.get(i);
				if (!result.equals(""))
					result = (new StringBuilder(String.valueOf(result))).append("&").toString();
				result = (new StringBuilder(String.valueOf(result))).append(lmRiskSchema.getRiskCode()).append("=[").append(lmRiskSchema.getRiskCode()).append("]").append(lmRiskSchema.getRiskShortName()).toString();
			}

			return result;
		} else
		{
			System.out.println("��ѯ��������,���ݻ�ȡʧ��");
			return null;
		}
	}

	public String getChosenRiskKind(String riskType, String channel)
	{
		String sql = (new StringBuilder("select *  from lmrisk where riskcode in (  select riskcode  from lmriskapp where  riskcode in (select riskcode from lmriskcomctrl where salechnl='")).append(channel).append("')").append(" and riskprop='").append(riskType).append("')").append(" order by riskcode").toString();
		System.out.println(sql);
		LNPRiskSet setLMRisk = (new LNPRiskDB()).executeQuery(sql);
		if (setLMRisk != null)
		{
			String result = "0=��ѡ������";
			for (int i = 1; i <= setLMRisk.size(); i++)
			{
				LNPRiskSchema lmRiskSchema = setLMRisk.get(i);
				if (!result.equals(""))
					result = (new StringBuilder(String.valueOf(result))).append("&").toString();
				result = (new StringBuilder(String.valueOf(result))).append(lmRiskSchema.getRiskCode()).append("=[").append(lmRiskSchema.getRiskCode()).append("]").append(lmRiskSchema.getRiskShortName()).toString();
			}

			return result;
		} else
		{
			System.out.println((new StringBuilder("��ѯ��������")).append(riskType).append(",���ݻ�ȡʧ��").toString());
			return null;
		}
	}

	public String getDocument(String riskName, String documentType)
	{
		String sHost = getHost();
		LNPStaticMsgUrlSet LNPStaticMsgUrlSet = (new LNPStaticMsgUrlDB()).executeQuery((new StringBuilder("select * from LNPStaticMsgUrl where assurancecode='")).append(riskName).append("' and flag='").append(documentType).append("'").toString());
		if (LNPStaticMsgUrlSet != null)
		{
			String result = "";
			for (int m = 1; m <= LNPStaticMsgUrlSet.size(); m++)
			{
				LNPStaticMsgUrlSchema staticMsgSchema = LNPStaticMsgUrlSet.get(m);
				if (!result.equals(""))
					result = (new StringBuilder(String.valueOf(result))).append("&").toString();
				String sURL = staticMsgSchema.getMsgUrl();
				if (!sHost.equals(""))
					sURL = sURL.replace("..", sHost);
				if (staticMsgSchema.getFlag().equals("1"))
					result = (new StringBuilder(String.valueOf(result))).append(sURL).append("=����").toString();
				else
				if (staticMsgSchema.getFlag().equals("2"))
					result = (new StringBuilder(String.valueOf(result))).append(sURL).append("=����").toString();
				else
				if (staticMsgSchema.getFlag().equals("3"))
					result = (new StringBuilder(String.valueOf(result))).append(sURL).append("=����").toString();
			}

			return result;
		} else
		{
			System.out.println((new StringBuilder("�鲻�������ֺ�:")).append(riskName).append("���ĵ�����").append(documentType).append("��Ӧ���ĵ���Ϣ").toString());
			return null;
		}
	}

	public static void main(String args1[])
	{
	}
}
