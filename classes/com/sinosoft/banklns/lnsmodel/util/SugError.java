// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SugError.java

package com.sinosoft.banklns.lnsmodel.util;

import com.sinosoft.banklns.lis.schema.*;
import java.util.*;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.util:
//			InsuError, RiskError

public class SugError
{

	private LNPContSchema sugInfo;
	private List insuErrorList;

	public SugError()
	{
		sugInfo = null;
		insuErrorList = new ArrayList();
	}

	public boolean hasError()
	{
		boolean flag = false;
		if (insuErrorList != null && insuErrorList.size() > 0)
			flag = true;
		return flag;
	}

	public List getInsuErrorList()
	{
		return insuErrorList;
	}

	public void addInsuError(InsuError insuError)
	{
		List errorList = insuError.getRiskErrorList();
		LNPInsuredSchema tempLNPInsuredSchema = insuError.getInsuInfo();
		if (insuError != null && errorList != null && errorList.size() > 0)
		{
			String insuno = tempLNPInsuredSchema.getInsuredNo();
			for (int i = 0; insuErrorList != null && i < insuErrorList.size(); i++)
				if (((InsuError)insuErrorList.get(i)).getInsuInfo().equals(insuno))
					break;

			insuErrorList.add(insuError);
		}
	}

	public LNPContSchema getSugInfo()
	{
		return sugInfo;
	}

	public void setSugInfo(LNPContSchema sugInfo)
	{
		this.sugInfo = sugInfo;
	}

	public String makeErrorHTML()
	{
		StringBuffer sb = new StringBuffer();
		if (hasError())
		{
			for (int i = 0; i < insuErrorList.size(); i++)
			{
				InsuError reInsuError = null;
				reInsuError = (InsuError)insuErrorList.get(i);
				LNPInsuredSchema tempLNPInsuredSchema = reInsuError.getInsuInfo();
				sb.append((new StringBuilder("<table width='100%' border='0' cellpadding='0' cellspacing='2' bgcolor='#FFFFFF'><tr><td width='100' align='center' valign='middle' bgcolor='#F4FFF4' style='font-family:Courier New;font-size:12px;color:#00CC99;'><strong>")).append(tempLNPInsuredSchema.getName()).append("</strong></td><td align='left' valign='top' bgcolor='#FFFFFF'>").toString());
				List riskErrorList = reInsuError.getRiskErrorList();
				for (int j = 0; riskErrorList != null && riskErrorList.size() > j; j++)
				{
					RiskError reRiskError = (RiskError)riskErrorList.get(j);
					LNPRiskSchema reLNPRiskSchema = reRiskError.getRiskInfo();
					sb.append("<table width='100%' border='0' cellspacing='2' cellpadding='0'>");
					sb.append("<tr>");
					String riskName = reLNPRiskSchema.getRiskName();
					String riskCode = reLNPRiskSchema.getRiskCode();
					sb.append((new StringBuilder("<td width='150' align='center' valign='middle' bgcolor='#F4FFF4' style='color: #3399FF;\tfont-size: 12px;font-weight: normal;'>[")).append(riskCode).append("] ").append(riskName).append("</td>").toString());
					sb.append("<td bgcolor='#F4FFF4' class='hei'><table width='100%' border='0' cellspacing='2' cellpadding='0'>");
					Set set = reRiskError.getRiskError();
					String error;
					for (Iterator iterator = set.iterator(); iterator.hasNext(); sb.append((new StringBuilder("<tr><td bgcolor='#F4FFF4' style='color: #4F4F4F ;font-size: 12px; font-weight: normal; font-family: Courier New;'>")).append(error).append("</td></tr>").toString()))
						error = iterator.next().toString();

					sb.append("</table></td>");
					sb.append("</tr>");
					sb.append("</table>");
				}

				sb.append("</td></tr></table>");
			}

		}
		return sb.toString();
	}

	public String makeErrorStr()
	{
		StringBuffer sb = new StringBuffer();
		if (hasError())
		{
			for (int i = 0; i < insuErrorList.size(); i++)
			{
				InsuError reInsuError = null;
				reInsuError = (InsuError)insuErrorList.get(i);
				LNPInsuredSchema tempLNPInsuredSchema = reInsuError.getInsuInfo();
				sb.append((new StringBuilder("Lname")).append(tempLNPInsuredSchema.getName()).append("@pnc").toString());
				List riskErrorList = reInsuError.getRiskErrorList();
				for (int j = 0; riskErrorList != null && riskErrorList.size() > j; j++)
				{
					RiskError reRiskError = (RiskError)riskErrorList.get(j);
					LNPRiskSchema reLNPRiskSchema = reRiskError.getRiskInfo();
					String riskName = reLNPRiskSchema.getRiskName();
					String riskCode = reLNPRiskSchema.getRiskCode();
					if (j > 0)
						sb.append("pname");
					sb.append((new StringBuilder("[")).append(riskCode).append("] ").append(riskName).append("@n").toString());
					Set set = reRiskError.getRiskError();
					String error;
					for (Iterator iterator = set.iterator(); iterator.hasNext(); sb.append((new StringBuilder(String.valueOf(error))).append("<br>").toString()))
						error = iterator.next().toString();

				}

			}

		}
		return sb.toString();
	}
}
