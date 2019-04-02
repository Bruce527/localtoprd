// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ResultRiskTableBean.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPPolDB;
import com.sinosoft.banklns.lis.db.LNPUWQuestionDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.LNPPolSet;
import com.sinosoft.banklns.lis.vschema.LNPUWQuestionSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			RiskTableBean, RiskPolImpl, RiskImpl, PolicyMainInfo, 
//			StateOperatorDeal, InsuredPersonInfo

public class ResultRiskTableBean
{

	private List List;
	private String id;
	private String idcon;
	private String result;

	public ResultRiskTableBean()
	{
		id = "";
		idcon = "";
		result = "";
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public List getList()
	{
		String ContNo = getIdcon();
		String InsuredNo = getId();
		List resultList = getRiskPolForOneInsure(ContNo, InsuredNo);
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
		String editflag = "";
		if (getEditFlag != null)
			if (getEditFlag.booleanValue())
				editflag = "inline-block";
			else
				editflag = "none";
		List = new ArrayList();
		if (resultList != null && resultList.size() > 0 && getEditFlag != null)
		{
			for (int i = 0; i < resultList.size(); i++)
			{
				String temp[] = (String[])resultList.get(i);
				List.add(new RiskTableBean(temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[0], editflag));
			}

		}
		return List;
	}

	public String ModifyRisk()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
		Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String currentpol = (String)requestMap.get("ModifyRiskpolno");
		RiskPolImpl instanceRiskPolImpl = new RiskPolImpl();
		String polno = instanceRiskPolImpl.transportPolNo(currentpol, tempGI);
		LNPPolSchema teLNPPolSchema = instanceRiskPolImpl.getPolInfo(polno);
		RiskImpl instanceRiskImpl = new RiskImpl();
		String riskElementUrl = instanceRiskImpl.getURLForRisk(teLNPPolSchema.getRiskCode(), "S");
		String riskRulesUrl = instanceRiskImpl.getURLForRisk(teLNPPolSchema.getRiskCode(), "3");
		if (riskElementUrl == null)
			riskElementUrl = "";
		if (riskRulesUrl == null)
			riskRulesUrl = "";
		result = (new StringBuilder(String.valueOf(riskElementUrl))).append("&").append(riskRulesUrl).append("&").append(polno).append("&").append(teLNPPolSchema.getRiskCode()).append("&").append(teLNPPolSchema.getMasterPolNo()).toString();
		return result;
	}

	public void deleteRisk()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String polno = (String)requestMap.get("deleteRiskpolno");
		IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
		String polsetarray[] = polno.split("~");
		RiskPolImpl instanceRiskPolImpl = new RiskPolImpl();
		try
		{
			ExeSQL reExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = (new StringBuilder("select contno from lnppol where polno = '")).append(polno).append("'").toString();
			tSSRS = reExeSQL.execSQL(sql);
			instanceRiskPolImpl.deletRisk(polsetarray, tempGI);
			if (polno != null && !polno.equals("") && tSSRS != null)
			{
				String contno = tSSRS.GetText(1, 1);
				if (contno != null && !contno.equals(""))
				{
					sql = (new StringBuilder("update lnppol set standprem=0,prem=0,sumprem=0 where contno ='")).append(contno).append("'").toString();
					reExeSQL.execUpdateSQL(sql);
				}
				sql = (new StringBuilder("select count(1) from lnppol where contno = '")).append(contno).append("';").toString();
				tSSRS = reExeSQL.execSQL(sql);
				if (tSSRS != null && "0".equals(tSSRS.GetText(1, 1)))
				{
					PolicyMainInfo tPolicyMainInfo = new PolicyMainInfo();
					LNPContSchema contSch = tPolicyMainInfo.getContByContNo(contno);
					StateOperatorDeal operatorDeal = new StateOperatorDeal();
					List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "delete", "04");
					contSch.setState((String)stateList.get(0));
					contSch.setEditstate((String)stateList.get(1));
					if ("2".equals(contSch.getUWFlag()))
						contSch.setUWFlag("1");
					String date = PubFun.getCurrentDate();
					String time = PubFun.getCurrentTime();
					contSch.setModifyDate(date);
					contSch.setModifyTime(time);
					contSch.setPrem(0.0D);
					contSch.setSumPrem(0.0D);
					PubSubmit ps = new PubSubmit();
					MMap map = new MMap();
					map.put(contSch, "UPDATE");
					VData vd = new VData();
					vd.add(map);
					if (ps.submitData(vd, ""))
						afterupdateRisk(contno);
				} else
				{
					PolicyMainInfo tPolicyMainInfo = new PolicyMainInfo();
					LNPContSchema contSch = tPolicyMainInfo.getContByContNo(contno);
					StateOperatorDeal operatorDeal = new StateOperatorDeal();
					List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "04");
					contSch.setState((String)stateList.get(0));
					contSch.setEditstate((String)stateList.get(1));
					if ("2".equals(contSch.getUWFlag()))
						contSch.setUWFlag("1");
					String date = PubFun.getCurrentDate();
					String time = PubFun.getCurrentTime();
					contSch.setModifyDate(date);
					contSch.setModifyTime(time);
					contSch.setPrem(0.0D);
					contSch.setSumPrem(0.0D);
					PubSubmit ps = new PubSubmit();
					MMap map = new MMap();
					map.put(contSch, "UPDATE");
					VData vd = new VData();
					vd.add(map);
					if (ps.submitData(vd, ""))
						afterupdateRisk(contno);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getId()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		id = (String)fc.getExternalContext().getRequestParameterMap().get("InsuredNo");
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getIdcon()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		idcon = (String)fc.getExternalContext().getRequestParameterMap().get("ContNo");
		return idcon;
	}

	public void setIdcon(String idcon)
	{
		this.idcon = idcon;
	}

	public List getRiskPolForOneInsure(String contNo, String insuredId)
	{
		RiskPolImpl riskPolImpl = new RiskPolImpl();
		RiskImpl riskImpl = new RiskImpl();
		DecimalFormat formatMoneyInt = new DecimalFormat("#,###");
		DecimalFormat formatMoney = new DecimalFormat("#,##0.00");
		CodeQueryImpl codeQueryImpl = new CodeQueryImpl();
		LNPInsuredSchema reLNPInsuredSchema = new LNPInsuredSchema();
		InsuredPersonInfo tInsuredPersonInfo = new InsuredPersonInfo();
		reLNPInsuredSchema = tInsuredPersonInfo.getOneInsuredPersonInfo(contNo, insuredId);
		String sql = (new StringBuilder("select * from lnppol where polno=masterpolno and contNo='")).append(contNo).append("' and insuredid='").append(insuredId).append("'  order by MakeDate , MakeTime ASC").toString();
		LNPPolDB reLNPPolDB = new LNPPolDB();
		LNPPolSet teLNPPolSet = reLNPPolDB.executeQuery(sql);
		List list = new ArrayList();
		if (teLNPPolSet != null && teLNPPolSet.size() > 0)
		{
			for (int i = 1; i <= teLNPPolSet.size(); i++)
			{
				LNPPolSchema tempLNPPolSchema = teLNPPolSet.get(i);
				List listGroup = riskPolImpl.getPolList(tempLNPPolSchema.getPolNo(), i);
				List noList = (List)listGroup.get(0);
				List polList = (List)listGroup.get(1);
				for (int j = 0; j < polList.size(); j++)
				{
					String polinfo[] = new String[8];
					String serialNo = noList.get(j).toString();
					tempLNPPolSchema = (LNPPolSchema)polList.get(j);
					polinfo[0] = tempLNPPolSchema.getPolNo();
					LNPRiskSchema tempLNPRiskSchema = riskImpl.getRiskInfo(tempLNPPolSchema.getRiskCode());
					if (tempLNPRiskSchema != null)
					{
						polinfo[1] = (new StringBuilder("??")).append(tempLNPRiskSchema.getRiskCode()).append("??").append(tempLNPRiskSchema.getRiskShortName()).toString();
						if ("CIR(B)".equalsIgnoreCase(tempLNPRiskSchema.getRiskCode()))
							polinfo[1] = (new StringBuilder("??CIR10")).append(tempLNPPolSchema.getStandbyFlag3()).append("??").append(tempLNPRiskSchema.getRiskShortName()).toString();
					} else
					{
						polinfo[1] = "";
					}
					double amnt = tempLNPPolSchema.getAmnt();
					double mult = tempLNPPolSchema.getMult();
					if (mult > 0.0D)
					{
						polinfo[2] = (new StringBuilder(String.valueOf(getFormatString(mult)))).append("??").toString();
					} else
					{
						String amntStr = (new StringBuilder(String.valueOf(formatMoneyInt.format(Math.floor(amnt))))).append("?").toString();
						polinfo[2] = amntStr;
					}
					int payintv = tempLNPPolSchema.getPayIntv();
					polinfo[3] = codeQueryImpl.getTextByCodeAndType("PayIntV", (new StringBuilder(String.valueOf(payintv))).toString());
					int insuyear = tempLNPPolSchema.getInsuYear();
					String insuYearFlag = tempLNPPolSchema.getInsuYearFlag();
					String insuStr = "";
					if (insuyear > 104)
						insuStr = "????";
					else
					if ("A".equals(insuYearFlag) && insuyear <= 104)
						insuStr = (new StringBuilder("??")).append(insuyear).append("????").toString();
					else
						insuStr = (new StringBuilder(String.valueOf(insuyear))).append("??").toString();
					polinfo[4] = insuStr;
					String PayEndYearStr = "";
					int PayEndYear = tempLNPPolSchema.getPayEndYear();
					String PayEndYearFlag = tempLNPPolSchema.getPayEndYearFlag();
					if ("A".equals(PayEndYearFlag))
						PayEndYearStr = (new StringBuilder("??")).append(PayEndYear).append("????").toString();
					else
					if (PayEndYear == 1000)
					{
						PayEndYear = 1;
						PayEndYearStr = (new StringBuilder(String.valueOf(PayEndYear))).append("??").toString();
					} else
					{
						PayEndYearStr = (new StringBuilder(String.valueOf(PayEndYear))).append("??").toString();
					}
					polinfo[5] = PayEndYearStr;
					double prem = tempLNPPolSchema.getSumPrem();
					polinfo[6] = (new StringBuilder(String.valueOf(formatMoney.format(prem)))).append("?").toString();
					polinfo[7] = serialNo;
					list.add(polinfo);
				}

			}

		}
		return list;
	}

	private boolean afterupdateRisk(String contno)
	{
		System.out.println("-----?งา??? ????????????? ???????????????? ----");
		boolean flag = false;
		try
		{
			PubSubmit ps = new PubSubmit();
			MMap mmap = new MMap();
			LNPUWQuestionDB queDB = new LNPUWQuestionDB();
			String sql = (new StringBuilder("select * from LNPUWQuestion where contno='")).append(contno).append("'").toString();
			LNPUWQuestionSet queSet = queDB.executeQuery(sql);
			if (queSet != null && queSet.size() > 0)
				mmap.put(queSet, "DELETE");
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema tLNPContSchema = mainInfo.getContByContNo(contno);
			if ("2".equals(tLNPContSchema.getUWFlag()))
				tLNPContSchema.setUWFlag("1");
			tLNPContSchema.setApproveFlag("0");
			mmap.put(tLNPContSchema, "UPDATE");
			VData vd = new VData();
			vd.add(mmap);
			if (!ps.submitData(vd, ""))
				flag = false;
			else
				flag = true;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	private String getFormatString(double inputStr)
	{
		DecimalFormat myformat = new DecimalFormat("#0.00");
		DecimalFormat myformatcheck = new DecimalFormat("#0");
		String reuslt = "";
		if ((double)(int)inputStr != inputStr)
			reuslt = myformat.format(inputStr);
		else
			reuslt = myformatcheck.format(inputStr);
		return reuslt;
	}
}
