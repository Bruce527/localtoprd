// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MCodeList.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.common.WebVisitor;
import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.lis.db.MCodeDB;
import com.sinosoft.map.lis.db.MComDB;
import com.sinosoft.map.lis.schema.MCodeSchema;
import com.sinosoft.map.lis.schema.MComSchema;
import com.sinosoft.map.lis.vschema.MCodeSet;
import com.sinosoft.map.lis.vschema.MComSet;
import com.sinosoft.map.user.UserModel;
import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

public class MCodeList
{

	private String provienceID;
	private String riskCode;
	private String comCode;
	private List codeTypeMap;
	private List riskTypeMap;
	private List riskPropMap;
	private List bonusFlagMap;
	private List bonusModeMap;
	private List subRiskFlagMap;
	private List insuredFlagMap;
	private List shareFlagMap;
	private List bnfFlagMap;
	private List impartFlagMap;
	private List choDutyFlagMap;
	private List cPayFlagMap;
	private List getFlagMap;
	private List edorFlagMap;
	private List rnewFlagMap;
	private List uwFlagMap;
	private List rinsFlagMap;
	private List insuAccFlagMap;
	private List payModeMap;
	private List riskPeriodMap;
	private List userStateMap;
	private List superFlagMap;
	private List orgMap;
	private List insuMonitorMap;
	private List comNatureMap;
	private List productClass;
	private List popedom;
	private List orderMap;
	private List insureMoneyMap;
	private List payFrequencyMap;
	private List getTypeMap;
	private List polTermMap;
	private List userStateMapR;
	private List policyStateMap;
	private List calTypeMap;
	private List persionTypelist;
	private List persionTypeMap;
	private List customerTypeMap;
	private List sexMap;
	private List deGreeMap;
	private List idTypeMap;
	private List changeCodeMap;
	private List payPeriodList;
	private List amntLimitList;
	private List idTypeList;
	private List questionForPwdList;
	private List provinceList;
	private List cityList;
	private List accProvinceList;
	private List accCityList;
	private List knowSiteList;
	private List workTypeList;
	private List occupationTypeList2;
	private List workTypeInsuredList;
	private List occupationInsuredTypeList;
	private List payModeList;
	private List wageTimeList;
	private List agentPccTypeList;
	private List agentPccQueryTypeList;
	private List projectType;
	private List maintainProjectType;
	private List branchAttrList;
	private List yesnoList;
	private List agentgroupList;
	private String oldWorkType;
	private String currentWorkType;
	private String oldInsuredWorkType;
	private String currentInsuredWorkType;
	private String currentProvince;
	private String oldProvince;
	private String phoneAreaCode;
	List bankComCodeList;
	List comCodeList;
	private List payPeriodList2;
	private List amntLimitList2;
	private List polTermList;
	private List polTermList2;
	private List payIntvList2;
	private List payIntvList;
	private List getModeList2;
	private List getModeList;
	private List yesOrNoList;
	private List relationList;
	private List relationListAll;
	private List occupationTypeList;
	private List marriageList;
	private List idTypeAppList;
	private List idTypeList2;
	private List insuredIdTypeList;
	private List comProvinceList;
	private List comCityList;

	public MCodeList()
	{
		provienceID = "";
		codeTypeMap = new ArrayList();
		riskTypeMap = new ArrayList();
		riskPropMap = new ArrayList();
		bonusFlagMap = new ArrayList();
		bonusModeMap = new ArrayList();
		subRiskFlagMap = new ArrayList();
		insuredFlagMap = new ArrayList();
		shareFlagMap = new ArrayList();
		bnfFlagMap = new ArrayList();
		impartFlagMap = new ArrayList();
		choDutyFlagMap = new ArrayList();
		cPayFlagMap = new ArrayList();
		getFlagMap = new ArrayList();
		edorFlagMap = new ArrayList();
		rnewFlagMap = new ArrayList();
		uwFlagMap = new ArrayList();
		rinsFlagMap = new ArrayList();
		insuAccFlagMap = new ArrayList();
		payModeMap = new ArrayList();
		riskPeriodMap = new ArrayList();
		userStateMap = new ArrayList();
		superFlagMap = new ArrayList();
		orgMap = new ArrayList();
		insuMonitorMap = new ArrayList();
		comNatureMap = new ArrayList();
		productClass = new ArrayList();
		popedom = new ArrayList();
		orderMap = new ArrayList();
		insureMoneyMap = new ArrayList();
		payFrequencyMap = new ArrayList();
		getTypeMap = new ArrayList();
		polTermMap = new ArrayList();
		userStateMapR = new ArrayList();
		policyStateMap = new ArrayList();
		calTypeMap = new ArrayList();
		persionTypelist = new ArrayList();
		persionTypeMap = new ArrayList();
		customerTypeMap = new ArrayList();
		sexMap = new ArrayList();
		deGreeMap = new ArrayList();
		idTypeMap = new ArrayList();
		changeCodeMap = new ArrayList();
		payPeriodList = new ArrayList();
		amntLimitList = new ArrayList();
		idTypeList = new ArrayList();
		questionForPwdList = new ArrayList();
		provinceList = new ArrayList();
		cityList = new ArrayList();
		accProvinceList = new ArrayList();
		accCityList = new ArrayList();
		knowSiteList = new ArrayList();
		workTypeList = new ArrayList();
		occupationTypeList2 = new ArrayList();
		workTypeInsuredList = new ArrayList();
		occupationInsuredTypeList = new ArrayList();
		payModeList = new ArrayList();
		wageTimeList = new ArrayList();
		agentPccTypeList = new ArrayList();
		agentPccQueryTypeList = new ArrayList();
		projectType = new ArrayList();
		maintainProjectType = new ArrayList();
		branchAttrList = new ArrayList();
		yesnoList = new ArrayList();
		agentgroupList = new ArrayList();
		bankComCodeList = null;
		comCodeList = null;
		payPeriodList2 = new ArrayList();
		amntLimitList2 = new ArrayList();
		polTermList = new ArrayList();
		polTermList2 = new ArrayList();
		payIntvList2 = new ArrayList();
		payIntvList = new ArrayList();
		getModeList2 = new ArrayList();
		getModeList = new ArrayList();
		yesOrNoList = new ArrayList();
		relationList = new ArrayList();
		relationListAll = new ArrayList();
		occupationTypeList = new ArrayList();
		marriageList = new ArrayList();
		idTypeAppList = new ArrayList();
		idTypeList2 = new ArrayList();
		insuredIdTypeList = new ArrayList();
		comProvinceList = new ArrayList();
		comCityList = new ArrayList();
	}

	public List getBranchAttrList()
	{
		List list = new ArrayList();
		if (list != null && list.size() > 0)
			return list;
		WebVisitor tWebVisitor = new WebVisitor();
		tWebVisitor = ECPubFun.getWebVisitor();
		UserModel user = tWebVisitor.getUser();
		StringBuffer tSql = new StringBuffer();
		tSql.append("select a.branchattr ,a.name from (select dbo.reversemapping('BRANCH',branchattr) branchattr,name from labranchgroup where 1=1 ");
		tSql.append((new StringBuilder(" and BranchManager = '")).append(user.getUserCode()).append("'").toString());
		tSql.append((new StringBuilder(" and ManageCom like '")).append(user.getManageCom()).append("%' ").toString());
		tSql.append(" and EndFlag = 'N' ");
		tSql.append(" union select dbo.reversemapping('BRANCH',branchattr) branchattr,name from labranchgroupb where 1=1 ");
		tSql.append((new StringBuilder(" and BranchManager = '")).append(user.getUserCode()).append("'").toString());
		tSql.append((new StringBuilder(" and ManageCom like '")).append(user.getManageCom()).append("%' ").toString());
		tSql.append(" and EndFlag = 'N'  ) a group by a.branchattr,a.name order by a.branchattr ");
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(tSql.toString());
		if (tSSRS != null && tSSRS.getMaxRow() >= 0)
		{
			for (int iLoop = 1; iLoop <= tSSRS.MaxRow; iLoop++)
				list.add(new SelectItem((new StringBuilder(String.valueOf(tSSRS.GetText(iLoop, 1)))).append("--").append(tSSRS.GetText(iLoop, 2)).toString(), tSSRS.GetText(iLoop, 1)));

		}
		return list;
	}

	public List createCodeItem(String codeType, String flag)
	{
		List list = new ArrayList();
		MCodeDB dao = new MCodeDB();
		MCodeSet set = new MCodeSet();
		dao.setCodeType(codeType);
		set = dao.query();
		if (flag.equals("L"))
		{
			if (set != null && set.size() > 0)
			{
				for (int iLoop = 1; iLoop <= set.size(); iLoop++)
				{
					MCodeSchema schema = new MCodeSchema();
					schema = set.get(iLoop);
					list.add(new SelectItem((new StringBuilder(String.valueOf(schema.getCode()))).append("--").append(schema.getCodeName()).toString(), schema.getCode()));
				}

			}
		} else
		if (flag.equals("R") && set != null && set.size() > 0)
		{
			for (int iLoop = 1; iLoop <= set.size(); iLoop++)
			{
				MCodeSchema schema = new MCodeSchema();
				schema = set.get(iLoop);
				list.add(new SelectItem(schema.getCode(), (new StringBuilder(String.valueOf(schema.getCode()))).append("--").append(schema.getCodeName()).toString()));
			}

		}
		return list;
	}

	public void setIdTypeList(List idTypeList)
	{
		this.idTypeList = idTypeList;
	}

	public List getIdTypeList()
	{
		if (idTypeList != null && idTypeList.size() > 0)
		{
			return idTypeList;
		} else
		{
			idTypeList = createCodeItem("idtype", "L");
			return idTypeList;
		}
	}

	public List getWorkTypeList()
	{
		if (workTypeList != null)
			workTypeList.clear();
		String mainRisk = getRiskCode();
		ExeSQL tExeSQL = new ExeSQL();
		String workSQL = (new StringBuilder("select paramvalue,paramname from lepriskparam where paramcode='AppntWorkType' and riskcode='")).append(mainRisk).append("'").toString();
		String orderBy = " order by length(paramname)";
		workSQL = (new StringBuilder(String.valueOf(workSQL))).append(orderBy).toString();
		SSRS tSRS = tExeSQL.execSQL(workSQL);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			workTypeList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return workTypeList;
	}

	public void setWorkTypeList(List workTypeList)
	{
		this.workTypeList = workTypeList;
	}

	public List getOccupationTypeList2()
	{
		if (currentWorkType == null || "".equals(currentWorkType))
			return occupationTypeList2;
		if (oldWorkType != null && !"".equals(oldWorkType) && oldWorkType.equals(currentWorkType))
			return occupationTypeList2;
		occupationTypeList2.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String occupSQL = (new StringBuilder("select occupationCode,occupationName from ledOccupation where workType='")).append(currentWorkType).append("'").toString();
		String orderBy = "  order by length(occupationName)";
		occupSQL = (new StringBuilder(String.valueOf(occupSQL))).append(orderBy).toString();
		SSRS tSSRS = tExeSQL.execSQL(occupSQL);
		for (int i = 1; i <= tSSRS.MaxRow; i++)
			occupationTypeList2.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		setOldWorkType(currentWorkType);
		return occupationTypeList2;
	}

	public void setOccupationTypeList2(List OccupationTypeList2)
	{
		occupationTypeList2 = OccupationTypeList2;
	}

	public List getWorkTypeInsuredList()
	{
		if (workTypeInsuredList != null && workTypeInsuredList.size() > 0)
			return workTypeInsuredList;
		ExeSQL tExeSQL = new ExeSQL();
		String workSQL = "select distinct worktype,workname from LEDOccupation where worktype in('35','39')";
		String orderBy = " order by length(workname)";
		workSQL = (new StringBuilder(String.valueOf(workSQL))).append(orderBy).toString();
		SSRS tSRS = tExeSQL.execSQL(workSQL);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			workTypeInsuredList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return workTypeInsuredList;
	}

	public void setWorkTypeInsuredList(List workTypeInsuredList)
	{
		this.workTypeInsuredList = workTypeInsuredList;
	}

	public List getOccupationInsuredTypeList()
	{
		if (occupationInsuredTypeList != null && occupationInsuredTypeList.size() > 0)
			return occupationInsuredTypeList;
		occupationInsuredTypeList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String mainRisk = getRiskCode();
		String occupSQL = (new StringBuilder("select paramvalue,paramname from lepriskparam where paramcode='InsureWorkType' and riskcode='")).append(mainRisk).append("'").toString();
		String orderBy = "  order by length(paramname)";
		occupSQL = (new StringBuilder(String.valueOf(occupSQL))).append(orderBy).toString();
		SSRS tSSRS = tExeSQL.execSQL(occupSQL);
		for (int i = 1; i <= tSSRS.MaxRow; i++)
			occupationInsuredTypeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return occupationInsuredTypeList;
	}

	public void setOccupationInsuredTypeList(List occupationInsuredTypeList)
	{
		this.occupationInsuredTypeList = occupationInsuredTypeList;
	}

	public List getQuestionForPwdList()
	{
		if (questionForPwdList != null && questionForPwdList.size() > 0)
			return questionForPwdList;
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename from ledcode where codetype='questionforpwd' ";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			questionForPwdList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return questionForPwdList;
	}

	public void setQuestionForPwdList(List questionForPwdList)
	{
		this.questionForPwdList = questionForPwdList;
	}

	public void setBankComCodeList(List bankComCodeList)
	{
		this.bankComCodeList = bankComCodeList;
	}

	public List getBankComCodeList()
	{
		if (bankComCodeList == null)
			bankComCodeList = new ArrayList();
		bankComCodeList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String comN = getComCode();
		if (comN == null || "".equals(comN))
			return bankComCodeList;
		String bankSQL = (new StringBuilder("select a.bankCode, a.bankName from ledbank a where a.bankAppType='B' and exists (select 1 from ledbankcomrela rela where rela.comCode='")).append(comN).append("' and ").append(" rela.bankAppType='B' and a.bankCode=rela.bankCode) order by length(a.bankName)").toString();
		SSRS tSSRS = tExeSQL.execSQL(bankSQL);
		for (int i = 1; i <= tSSRS.MaxRow; i++)
			bankComCodeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return bankComCodeList;
	}

	public void setPayModeList(List payModeList)
	{
		this.payModeList = payModeList;
	}

	public List getPayModeList()
	{
		if (payModeList != null && payModeList.size() > 0)
			return payModeList;
		payModeList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename from ledcode where codetype='paymode' and code<>'4' order by code";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			payModeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return payModeList;
	}

	public void setProjectType(List projectType)
	{
		this.projectType = projectType;
	}

	public List getProjectType()
	{
		if (projectType != null && projectType.size() > 0)
			return projectType;
		projectType.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename  from mcode where codetype='projectType'  order by code";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			projectType.add(new SelectItem(tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));

		return projectType;
	}

	public void setWageTimeList(List wageTimeList)
	{
		this.wageTimeList = wageTimeList;
	}

	public List getWageTimeList()
	{
		if (wageTimeList != null && wageTimeList.size() > 0)
			return wageTimeList;
		wageTimeList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename  from mcode where codetype='wagetimetype'  order by code";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			wageTimeList.add(new SelectItem((new StringBuilder(String.valueOf(tSSRS.GetText(i, 1)))).append("--").append(tSSRS.GetText(i, 2)).toString(), tSSRS.GetText(i, 2)));

		return wageTimeList;
	}

	public List getAgentPccTypeList()
	{
		if (agentPccTypeList == null)
			agentPccTypeList = new ArrayList();
		agentPccTypeList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename  from mcode where codetype='agentpcctype'  order by code";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			agentPccTypeList.add(new SelectItem((new StringBuilder(String.valueOf(tSSRS.GetText(i, 1)))).append("--").append(tSSRS.GetText(i, 2)).toString(), tSSRS.GetText(i, 2)));

		return agentPccTypeList;
	}

	public void setAgentPccTypeList(List agentPccTypeList)
	{
		this.agentPccTypeList = agentPccTypeList;
	}

	public List getAgentPccQueryTypeList()
	{
		if (agentPccQueryTypeList == null)
			agentPccQueryTypeList = new ArrayList();
		agentPccQueryTypeList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename  from mcode where codetype='agentpccquerytype'  order by code";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			agentPccQueryTypeList.add(new SelectItem((new StringBuilder(String.valueOf(tSSRS.GetText(i, 1)))).append("--").append(tSSRS.GetText(i, 2)).toString(), tSSRS.GetText(i, 2)));

		return agentPccQueryTypeList;
	}

	public void setAgentPccQueryTypeList(List agentPccQueryTypeList)
	{
		this.agentPccQueryTypeList = agentPccQueryTypeList;
	}

	public void setComCodeList(List comCodeList)
	{
		this.comCodeList = comCodeList;
	}

	public List getComCodeList()
	{
		if (comCodeList != null && comCodeList.size() > 0)
			return comCodeList;
		if (comCodeList == null)
			comCodeList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		String comSQL = "select comCode, name from mcom where 1=1 order by comCode";
		SSRS tSSRS = tExeSQL.execSQL(comSQL);
		for (int i = 1; i <= tSSRS.MaxRow; i++)
			comCodeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return comCodeList;
	}

	public void setKnowSiteList(List knowSiteList)
	{
		this.knowSiteList = knowSiteList;
	}

	public List getKnowSiteList()
	{
		if (knowSiteList != null && knowSiteList.size() > 0)
			return knowSiteList;
		if (knowSiteList == null)
			knowSiteList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		String siteSQL = "select code, codename from ledcode where codetype='KnowSite' order by code";
		SSRS tSSRS = tExeSQL.execSQL(siteSQL);
		for (int i = 1; i <= tSSRS.MaxRow; i++)
			knowSiteList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return knowSiteList;
	}

	public List getProvinceList()
	{
		if (provinceList != null && provinceList.size() > 0)
			return provinceList;
		provinceList = new ArrayList();
		MCodeDB codeDAO = new MCodeDB();
		MCodeSet codeSet = new MCodeSet();
		codeDAO.setCodeType("provience");
		codeDAO.setOtherSign("N");
		codeSet = codeDAO.query();
		if (codeSet != null && codeSet.size() > 0)
		{
			for (int iLoop = 1; iLoop <= codeSet.size(); iLoop++)
			{
				MCodeSchema codeSchema = codeSet.get(iLoop);
				provinceList.add(new SelectItem(codeSchema.getCode(), (new StringBuilder(String.valueOf(codeSchema.getCode()))).append("--").append(codeSchema.getCodeName()).toString()));
			}

		}
		return provinceList;
	}

	public void setProvinceList(List provinceList)
	{
		this.provinceList = provinceList;
	}

	public List getAccProvinceList()
	{
		if (accProvinceList != null && accProvinceList.size() > 0)
			return accProvinceList;
		accProvinceList = new ArrayList();
		MCodeDB codeDAO = new MCodeDB();
		MCodeSet codeSet = new MCodeSet();
		codeDAO.setCodeType("provience");
		codeDAO.setOtherSign("N");
		codeSet = codeDAO.query();
		if (codeSet.size() > 0)
		{
			for (int iLoop = 1; iLoop <= codeSet.size(); iLoop++)
			{
				MCodeSchema codeSchema = codeSet.get(iLoop);
				accProvinceList.add(new SelectItem(codeSchema.getCode(), codeSchema.getCodeName()));
			}

		}
		return accProvinceList;
	}

	public void setAccProvinceList(List accProvinceList)
	{
		this.accProvinceList = accProvinceList;
	}

	public String getCurrentProvince()
	{
		return currentProvince;
	}

	public void setCurrentProvince(String currentProvince)
	{
		this.currentProvince = currentProvince;
	}

	public String getOldProvince()
	{
		return oldProvince;
	}

	public void setOldProvince(String oldProvince)
	{
		this.oldProvince = oldProvince;
	}

	public void changeCity(ValueChangeEvent event)
	{
		System.out.println((new StringBuilder("选择的新城市值是:")).append(event.getNewValue().toString()).toString());
		String city = event.getNewValue().toString();
		String areaCodeSQL = (new StringBuilder("select codealias from ledcode where codetype='city' and code='")).append(city).append("'").toString();
		ExeSQL tExeSQL = new ExeSQL();
		String areaCode = tExeSQL.getOneValue(areaCodeSQL);
		System.out.println((new StringBuilder("====areaCode====")).append(areaCode).toString());
		setPhoneAreaCode(areaCode);
	}

	public void changeProvince(ValueChangeEvent event)
	{
		System.out.println((new StringBuilder("选择的新值是:")).append(event.getNewValue().toString()).toString());
		setCurrentProvince(event.getNewValue().toString());
	}

	public void changeAppntWorkType(ValueChangeEvent event)
	{
		System.out.println((new StringBuilder("选择的新职业类别是:")).append(event.getNewValue().toString()).toString());
		setCurrentWorkType(event.getNewValue().toString());
	}

	public void changeInsuredWorkType(ValueChangeEvent event)
	{
		System.out.println((new StringBuilder("选择的新职业类别是:")).append(event.getNewValue().toString()).toString());
		setCurrentInsuredWorkType(event.getNewValue().toString());
	}

	public void change()
	{
		System.out.println("Chang了吗？");
	}

	public List getCityList()
	{
		if (oldProvince != null && !"".equals(oldProvince) && oldProvince.equals(currentProvince))
			return cityList;
		cityList = new ArrayList();
		if (currentProvince != null && !"".equals(currentProvince))
		{
			MCodeDB codeDAO = new MCodeDB();
			MCodeSet codeSet = new MCodeSet();
			codeDAO.setCodeType("city");
			codeDAO.setOtherSign("N");
			codeDAO.setComCode(currentProvince);
			codeSet = codeDAO.query();
			if (codeSet != null && codeSet.size() > 0)
			{
				for (int iLoop = 1; iLoop <= codeSet.size(); iLoop++)
				{
					MCodeSchema codeSchema = codeSet.get(iLoop);
					cityList.add(new SelectItem(codeSchema.getCode(), (new StringBuilder(String.valueOf(codeSchema.getCode()))).append("--").append(codeSchema.getCodeName()).toString()));
				}

			}
		}
		return cityList;
	}

	public void setCityList(List cityList)
	{
		this.cityList = cityList;
	}

	public List getAccCityList()
	{
		if (accCityList == null)
			accCityList = new ArrayList();
		accCityList.clear();
		String sql = "select code, codeName from ledcode where codetype='city' and othersign='N' and code in ('110100','210100','210200','440100','440300','500100')";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS.MaxRow > 0)
		{
			for (int iLoop = 1; iLoop <= tSSRS.MaxRow; iLoop++)
				accCityList.add(new SelectItem(tSSRS.GetText(iLoop, 1), tSSRS.GetText(iLoop, 2)));

		}
		return accCityList;
	}

	public void setAccCityList(List accCityList)
	{
		this.accCityList = accCityList;
	}

	public List getRiskTypeMap()
	{
		if (riskTypeMap != null && riskTypeMap.size() > 0)
		{
			return riskTypeMap;
		} else
		{
			riskTypeMap = createCodeItem("riskType", "L");
			return riskTypeMap;
		}
	}

	public List getProductClass()
	{
		if (productClass != null && productClass.size() > 0)
		{
			return productClass;
		} else
		{
			productClass = createCodeItem("productsT", "L");
			return productClass;
		}
	}

	public void setProductClass(List productT)
	{
		productClass = productT;
	}

	public List getPopedom()
	{
		if (popedom != null && popedom.size() > 0)
		{
			return popedom;
		} else
		{
			popedom = createCodeItem("popedom", "L");
			return popedom;
		}
	}

	public void setPopedom(List tPopedom)
	{
		popedom = tPopedom;
	}

	public List getOrderMap()
	{
		if (orderMap != null && orderMap.size() > 0)
		{
			return orderMap;
		} else
		{
			orderMap = createCodeItem("orderState", "L");
			return orderMap;
		}
	}

	public void setOrderMap(List tOrderMap)
	{
		orderMap = tOrderMap;
	}

	public List getRiskPropMap()
	{
		if (riskPropMap != null && riskPropMap.size() > 0)
		{
			return riskPropMap;
		} else
		{
			riskPropMap = createCodeItem("riskProp", "L");
			return riskPropMap;
		}
	}

	public void setRiskPropMap(List riskPropMap)
	{
		this.riskPropMap = riskPropMap;
	}

	public List getBonusFlagMap()
	{
		if (bonusFlagMap != null && bonusFlagMap.size() > 0)
		{
			return bonusFlagMap;
		} else
		{
			bonusFlagMap = createCodeItem("bonusFlag", "L");
			return bonusFlagMap;
		}
	}

	public void setBonusFlagMap(List bonusFlagMap)
	{
		this.bonusFlagMap = bonusFlagMap;
	}

	public List getBonusModeMap()
	{
		if (bonusModeMap != null && bonusModeMap.size() > 0)
		{
			return bonusModeMap;
		} else
		{
			bonusModeMap = createCodeItem("bonusMode", "L");
			return bonusModeMap;
		}
	}

	public void setBonusModeMap(List bonusModeMap)
	{
		this.bonusModeMap = bonusModeMap;
	}

	public List getSubRiskFlagMap()
	{
		if (subRiskFlagMap != null && subRiskFlagMap.size() > 0)
		{
			return subRiskFlagMap;
		} else
		{
			subRiskFlagMap = createCodeItem("subRiskFlag", "L");
			return subRiskFlagMap;
		}
	}

	public void setSubRiskFlagMap(List subRiskFlagMap)
	{
		this.subRiskFlagMap = subRiskFlagMap;
	}

	public List getInsuredFlagMap()
	{
		if (insuredFlagMap != null && insuredFlagMap.size() > 0)
		{
			return insuredFlagMap;
		} else
		{
			insuredFlagMap = createCodeItem("insuredFlag", "L");
			return insuredFlagMap;
		}
	}

	public void setInsuredFlagMap(List insuredFlagMap)
	{
		this.insuredFlagMap = insuredFlagMap;
	}

	public List getShareFlagMap()
	{
		if (shareFlagMap != null && shareFlagMap.size() > 0)
		{
			return shareFlagMap;
		} else
		{
			shareFlagMap = createCodeItem("shareFlag", "L");
			return shareFlagMap;
		}
	}

	public void setShareFlagMap(List shareFlagMap)
	{
		this.shareFlagMap = shareFlagMap;
	}

	public List getBnfFlagMap()
	{
		if (bnfFlagMap != null && bnfFlagMap.size() > 0)
		{
			return bnfFlagMap;
		} else
		{
			bnfFlagMap = createCodeItem("bnfFlag", "L");
			return bnfFlagMap;
		}
	}

	public void setBnfFlagMap(List bnfFlagMap)
	{
		this.bnfFlagMap = bnfFlagMap;
	}

	public List getImpartFlagMap()
	{
		if (impartFlagMap != null && impartFlagMap.size() > 0)
		{
			return impartFlagMap;
		} else
		{
			impartFlagMap = createCodeItem("impartFlag", "L");
			return impartFlagMap;
		}
	}

	public void setImpartFlagMap(List impartFlagMap)
	{
		this.impartFlagMap = impartFlagMap;
	}

	public List getChoDutyFlagMap()
	{
		if (choDutyFlagMap != null && choDutyFlagMap.size() > 0)
		{
			return choDutyFlagMap;
		} else
		{
			choDutyFlagMap = createCodeItem("choDutyFlag", "L");
			return choDutyFlagMap;
		}
	}

	public void setChoDutyFlagMap(List choDutyFlagMap)
	{
		this.choDutyFlagMap = choDutyFlagMap;
	}

	public List getCPayFlagMap()
	{
		if (cPayFlagMap != null && cPayFlagMap.size() > 0)
		{
			return cPayFlagMap;
		} else
		{
			cPayFlagMap = createCodeItem("cPayFlag", "L");
			return cPayFlagMap;
		}
	}

	public void setCPayFlagMap(List payFlagMap)
	{
		cPayFlagMap = payFlagMap;
	}

	public List getGetFlagMap()
	{
		if (getFlagMap != null && getFlagMap.size() > 0)
		{
			return getFlagMap;
		} else
		{
			getFlagMap = createCodeItem("getFlag", "L");
			return getFlagMap;
		}
	}

	public void setGetFlagMap(List getFlagMap)
	{
		this.getFlagMap = getFlagMap;
	}

	public List getEdorFlagMap()
	{
		if (edorFlagMap != null && edorFlagMap.size() > 0)
		{
			return edorFlagMap;
		} else
		{
			edorFlagMap = createCodeItem("edorFlag", "L");
			return edorFlagMap;
		}
	}

	public void setEdorFlagMap(List edorFlagMap)
	{
		this.edorFlagMap = edorFlagMap;
	}

	public List getRnewFlagMap()
	{
		if (rnewFlagMap != null && rnewFlagMap.size() > 0)
		{
			return rnewFlagMap;
		} else
		{
			rnewFlagMap = createCodeItem("rnewFlag", "L");
			return rnewFlagMap;
		}
	}

	public void setRnewFlagMap(List rnewFlagMap)
	{
		this.rnewFlagMap = rnewFlagMap;
	}

	public List getUwFlagMap()
	{
		if (uwFlagMap != null && uwFlagMap.size() > 0)
		{
			return uwFlagMap;
		} else
		{
			uwFlagMap = createCodeItem("UWFlag", "L");
			return uwFlagMap;
		}
	}

	public void setUwFlagMap(List uwFlagMap)
	{
		this.uwFlagMap = uwFlagMap;
	}

	public List getRinsFlagMap()
	{
		if (rinsFlagMap != null && rinsFlagMap.size() > 0)
		{
			return rinsFlagMap;
		} else
		{
			rinsFlagMap = createCodeItem("rinsFlag", "L");
			return rinsFlagMap;
		}
	}

	public void setRinsFlagMap(List rinsFlagMap)
	{
		this.rinsFlagMap = rinsFlagMap;
	}

	public List getInsuAccFlagMap()
	{
		if (insuAccFlagMap != null && insuAccFlagMap.size() > 0)
		{
			return insuAccFlagMap;
		} else
		{
			insuAccFlagMap = createCodeItem("insuAccFlag", "L");
			return insuAccFlagMap;
		}
	}

	public void setInsuAccFlagMap(List insuAccFlagMap)
	{
		this.insuAccFlagMap = insuAccFlagMap;
	}

	public List getPayModeMap()
	{
		if (payModeMap != null && payModeMap.size() > 0)
		{
			return payModeMap;
		} else
		{
			payModeMap = createCodeItem("payMode", "L");
			return payModeMap;
		}
	}

	public void setPayModeMap(List payModeMap)
	{
		this.payModeMap = payModeMap;
	}

	public List getRiskPeriodMap()
	{
		if (riskPeriodMap != null && riskPeriodMap.size() > 0)
		{
			return riskPeriodMap;
		} else
		{
			riskPeriodMap = createCodeItem("riskPeriod", "L");
			return riskPeriodMap;
		}
	}

	public void setRiskPeriodMap(List riskPeriodMap)
	{
		this.riskPeriodMap = riskPeriodMap;
	}

	public List getOrgMap()
	{
		if (orgMap != null && orgMap.size() > 0)
			return orgMap;
		orgMap = new ArrayList();
		MComDB comDAO = new MComDB();
		MComSet comSet = new MComSet();
		comSet = comDAO.executeQuery("select * from mcom order by comcode");
		if (comSet != null && comSet.size() > 0)
		{
			for (int iLoop = 1; iLoop <= comSet.size(); iLoop++)
			{
				MComSchema comSchema = comSet.get(iLoop);
				orgMap.add(new SelectItem((new StringBuilder(String.valueOf(comSchema.getComCode()))).append("--").append(comSchema.getName()).toString(), comSchema.getComCode()));
			}

		}
		return orgMap;
	}

	public List getUserStateMap()
	{
		if (userStateMap != null && userStateMap.size() > 0)
		{
			return userStateMap;
		} else
		{
			userStateMap = createCodeItem("UserState", "L");
			return userStateMap;
		}
	}

	public void setUserStateMap(List userStateMap)
	{
		this.userStateMap = userStateMap;
	}

	public List getSuperFlagMap()
	{
		if (superFlagMap != null && superFlagMap.size() > 0)
		{
			return superFlagMap;
		} else
		{
			superFlagMap = createCodeItem("SuperPopedomFlag", "L");
			return superFlagMap;
		}
	}

	public void setSuperFlagMap(List superFlagMap)
	{
		this.superFlagMap = superFlagMap;
	}

	public List getCodeTypeMap()
	{
		if (codeTypeMap != null && codeTypeMap.size() > 0)
			return codeTypeMap;
		codeTypeMap = new ArrayList();
		MCodeDB codeDAO = new MCodeDB();
		MCodeSet codeSet = new MCodeSet();
		codeDAO.setCodeType("codetype");
		codeDAO.setOtherSign("N");
		codeSet = codeDAO.query();
		if (codeSet != null && codeSet.size() > 0)
		{
			for (int iLoop = 1; iLoop <= codeSet.size(); iLoop++)
			{
				MCodeSchema codeSchema = codeSet.get(iLoop);
				codeTypeMap.add(new SelectItem((new StringBuilder(String.valueOf(codeSchema.getCode()))).append("--").append(codeSchema.getCodeName()).toString(), codeSchema.getCode()));
			}

		}
		return codeTypeMap;
	}

	public void setCodeTypeMap(List codeTypeMap)
	{
		this.codeTypeMap = codeTypeMap;
	}

	public List getInsuMonitorMap()
	{
		if (insuMonitorMap != null && insuMonitorMap.size() > 0)
		{
			return insuMonitorMap;
		} else
		{
			insuMonitorMap = createCodeItem("insuMonitor", "L");
			return insuMonitorMap;
		}
	}

	public void setInsuMonitorMap(List insuMonitorMap)
	{
		this.insuMonitorMap = insuMonitorMap;
	}

	public List getComNatureMap()
	{
		if (comNatureMap != null && comNatureMap.size() > 0)
		{
			return comNatureMap;
		} else
		{
			comNatureMap = createCodeItem("comNature", "L");
			return comNatureMap;
		}
	}

	public void setComNatureMap(List comNatureMap)
	{
		this.comNatureMap = comNatureMap;
	}

	public void setPayPeriodList2(List payPeriodList2)
	{
		this.payPeriodList2 = payPeriodList2;
	}

	public List getPayPeriodList2()
	{
		if (payPeriodList2.size() > 0)
			payPeriodList2.clear();
		String riskN = getRiskCode();
		if (riskN == null || "".equals(riskN))
			return payPeriodList2;
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select b.paramvalue,(case when b.paramvalue='0' then '趸交' else b.paramvalue||'年交' end) from lepriskparam b where b.riskcode='")).append(riskN).append("' and b.paramcode='PayPeriod'").toString();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.MaxRow; i++)
			payPeriodList2.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return payPeriodList2;
	}

	public void setPayPeriodList(List payPeriodList)
	{
		this.payPeriodList = payPeriodList;
	}

	public List getPayPeriodList()
	{
		if (payPeriodList.size() > 0)
			return payPeriodList;
		else
			return getRiskParam("PayPeriod");
	}

	public void setAmntLimitList(List amntLimitList)
	{
		this.amntLimitList = amntLimitList;
	}

	public List getAmntLimitList()
	{
		if (amntLimitList.size() > 0)
			return amntLimitList;
		String sql = "select paramvalue,paramname from lepriskparam where riskcode='RTM209' and paramcode='AmntLimit'";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		DecimalFormat df = new DecimalFormat("0.0");
		try
		{
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				amntLimitList.add(new SelectItem(df.format(Double.parseDouble(tSSRS.GetText(i, 1).trim())), tSSRS.GetText(i, 2)));

		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return amntLimitList;
		}
		return amntLimitList;
	}

	public void setAmntLimitList2(List amntLimitList2)
	{
		this.amntLimitList2 = amntLimitList2;
	}

	public List getAmntLimitList2()
	{
		if (amntLimitList2.size() > 0)
			amntLimitList2.clear();
		String riskN = getRiskCode();
		if (riskN == null || "".equals(riskN))
			return amntLimitList2;
		String sql = (new StringBuilder("select a.code,a.codename from ledcode a where a.codetype='AmntLimit' and exists (select 1 from lepriskparam b where b.riskcode='")).append(riskN).append("' and b.paramcode='AmntLimit' and a.code=b.paramvalue)").toString();
		String orderby = " order by to_number(a.code)";
		sql = (new StringBuilder(String.valueOf(sql))).append(orderby).toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		DecimalFormat df = new DecimalFormat("0.0");
		try
		{
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				amntLimitList2.add(new SelectItem(df.format(Double.parseDouble(tSSRS.GetText(i, 1).trim())), tSSRS.GetText(i, 2)));

		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return amntLimitList2;
		}
		return amntLimitList2;
	}

	public void setPolTermList(List polTermList)
	{
		this.polTermList = polTermList;
	}

	public List getPolTermList()
	{
		if (polTermList.size() > 0)
			return polTermList;
		else
			return getRiskParam("PolTerm");
	}

	public void setPolTermList2(List polTermList2)
	{
		this.polTermList2 = polTermList2;
	}

	public List getPolTermList2()
	{
		if (polTermList2.size() > 0)
			return polTermList2;
		else
			return getRiskParamFromLEDCode("PolTerm");
	}

	public void setPayIntvList2(List payIntvList2)
	{
		this.payIntvList2 = payIntvList2;
	}

	public List getPayIntvList2()
	{
		if (payIntvList2.size() > 0)
			return payIntvList2;
		else
			return getRiskParamFromLEDCode("PayIntv");
	}

	public void setPayIntvList(List payIntvList)
	{
		this.payIntvList = payIntvList;
	}

	public List getPayIntvList()
	{
		if (payIntvList != null && payIntvList.size() > 0)
			return payIntvList;
		payIntvList = new ArrayList();
		String sql = "select code,codename from mcode where codetype='payintv' order by codeorder";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			payIntvList.add(new SelectItem((new StringBuilder(String.valueOf(tSSRS.GetText(i, 1)))).append("--").append(tSSRS.GetText(i, 2)).toString(), tSSRS.GetText(i, 2)));

		return payIntvList;
	}

	public void setGetModeList2(List getModeList2)
	{
		this.getModeList2 = getModeList2;
	}

	public List getGetModeList2()
	{
		if (getModeList2.size() > 0)
			return getModeList2;
		else
			return getRiskParamFromLEDCode("GetMode");
	}

	public void setGetModeList(List getModeList)
	{
		this.getModeList = getModeList;
	}

	public List getGetModeList()
	{
		if (getModeList.size() > 0)
			return getModeList;
		else
			return getRiskParam("GetMode");
	}

	public List getRiskParamFromLEDCode(String paramCode)
	{
		List paramList = new ArrayList();
		String riskN = getRiskCode();
		if (riskN == null || "".equals(riskN))
			return paramList;
		String paramSQL = (new StringBuilder("select a.code,a.codename from ledcode a where a.codetype='")).append(paramCode).append("'").append(" and exists (select 1 from lepriskparam b where b.riskcode='").append(riskN).append("' and b.paramcode='").append(paramCode).append("'").append(" and b.paramvalue=a.code)").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(paramSQL);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			paramList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return paramList;
	}

	public List getRiskParam(String paramCode)
	{
		List paramList = new ArrayList();
		String sql = (new StringBuilder("select paramvalue,paramname from lepriskparam where riskcode='RTM209' and paramcode='")).append(paramCode).append("' ").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			paramList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return paramList;
	}

	public void setYesOrNoList(List yesOrNoList)
	{
		this.yesOrNoList = yesOrNoList;
	}

	public List getYesOrNoList()
	{
		if (yesOrNoList.size() > 0)
			return yesOrNoList;
		else
			return getCodeAndName("yesno");
	}

	public void setRelationList(List relationList)
	{
		this.relationList = relationList;
	}

	public List getRelationList()
	{
		if (relationList.size() > 0)
			return relationList;
		String riskN = getRiskCode();
		if (riskN == null || "".equals(riskN))
		{
			relationList.clear();
			return relationList;
		}
		String sql = (new StringBuilder("select a.code,a.codename From ledcode a where a.codetype='relation' and exists (select 1 from lepriskparam b where b.paramcode='relation' and b.riskCode='")).append(riskN).append("' and b.paramvalue=a.code) order by a.code").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			relationList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return relationList;
	}

	public void setRelationListAll(List relationListAll)
	{
		this.relationListAll = relationListAll;
	}

	public List getRelationListAll()
	{
		if (relationListAll.size() > 0)
		{
			return relationListAll;
		} else
		{
			relationListAll = createCodeItem("relation", "R");
			return relationListAll;
		}
	}

	public void setOccupationTypeList(List occupationTypeList)
	{
		this.occupationTypeList = occupationTypeList;
	}

	public List getOccupationTypeList()
	{
		if (occupationTypeList.size() > 0)
			return occupationTypeList;
		else
			return getCodeAndName("occupationtype");
	}

	public void setMarriageList(List marriageList)
	{
		this.marriageList = marriageList;
	}

	public List getMarriageList()
	{
		if (marriageList.size() > 0)
			return marriageList;
		else
			return getCodeAndName("marriage");
	}

	private List getCodeAndName(String codeType)
	{
		List codeAndNameList = new ArrayList();
		String sql = (new StringBuilder("select code,codename From ledcode where codetype='")).append(codeType).append("' order by code").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			codeAndNameList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return codeAndNameList;
	}

	public void setIdTypeAppList(List idTypeAppList)
	{
		this.idTypeAppList = idTypeAppList;
	}

	public List getIdTypeAppList()
	{
		if (idTypeAppList != null && idTypeAppList.size() > 0)
			return idTypeAppList;
		String sql = "select code,codename From ledcode where codetype='idtype' and code in ('A','B','C','I') order by code";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			idTypeAppList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return idTypeAppList;
	}

	public void setIdTypeList2(List idTypeList2)
	{
		this.idTypeList2 = idTypeList2;
	}

	public List getIdTypeList2()
	{
		if (idTypeList2 != null && idTypeList2.size() > 0)
			return idTypeList2;
		String sql = "select code,codename From ledcode where codetype='idtype' and code in ('A','B','C','M','Q') order by code";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			idTypeList2.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return idTypeList2;
	}

	public void setInsuredIdTypeList(List insuredIdTypeList)
	{
		this.insuredIdTypeList = insuredIdTypeList;
	}

	public List getInsuredIdTypeList()
	{
		if (insuredIdTypeList != null && insuredIdTypeList.size() > 0)
			return insuredIdTypeList;
		String sql = "select code,codename From ledcode where codetype='idtype' and code in ('A','B','Q') order by code";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			insuredIdTypeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return insuredIdTypeList;
	}

	public void setComProvinceList(List comProvinceList)
	{
		this.comProvinceList = comProvinceList;
	}

	public List getComProvinceList()
	{
		if (comProvinceList != null && comProvinceList.size() > 0)
			return comProvinceList;
		String sql = "select distinct Province,(select codename from ledcode where codetype='provience' and code=a.Province) From ledcom a order by Province";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			comProvinceList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return comProvinceList;
	}

	public void setComCityList(List comCityList)
	{
		this.comCityList = comCityList;
	}

	public List getComCityList()
	{
		if (currentProvince == null || "".equals(currentProvince))
		{
			comCityList = new ArrayList();
			return comCityList;
		}
		if (oldProvince != null && !"".equals(oldProvince) && oldProvince.equals(currentProvince))
			return comCityList;
		comCityList = new ArrayList();
		String sql = (new StringBuilder("select distinct City,(select codename from ledcode where codetype='city' and code=a.city) From ledcom a where province = '")).append(currentProvince).append("' order by City").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			comCityList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		setOldProvince(currentProvince);
		return comCityList;
	}

	public void setProvienceID(String provienceID)
	{
		this.provienceID = provienceID;
		setCurrentProvince(this.provienceID);
	}

	public List getInsureMoneyMap()
	{
		if (insureMoneyMap != null && insureMoneyMap.size() > 0)
		{
			return insureMoneyMap;
		} else
		{
			insureMoneyMap = createCodeItem("AmntLimit", "R");
			return insureMoneyMap;
		}
	}

	public void setInsureMoneyMap(List insureMoneyMap)
	{
		this.insureMoneyMap = insureMoneyMap;
	}

	public List getPayFrequencyMap()
	{
		if (payFrequencyMap != null && payFrequencyMap.size() > 0)
		{
			return payFrequencyMap;
		} else
		{
			payFrequencyMap = createCodeItem("PayIntv", "R");
			return payFrequencyMap;
		}
	}

	public void setPayFrequencyMap(List payFrequencyMap)
	{
		this.payFrequencyMap = payFrequencyMap;
	}

	public List getGetTypeMap()
	{
		if (getTypeMap != null && getTypeMap.size() > 0)
		{
			return getTypeMap;
		} else
		{
			getTypeMap = createCodeItem("GetMode", "R");
			return getTypeMap;
		}
	}

	public void setGetTypeMap(List getTypeMap)
	{
		this.getTypeMap = getTypeMap;
	}

	public List getPolTermMap()
	{
		if (polTermMap != null && polTermMap.size() > 0)
		{
			return polTermMap;
		} else
		{
			polTermMap = createCodeItem("PolTerm", "R");
			return polTermMap;
		}
	}

	public void setPolTermMap(List polTermMap)
	{
		this.polTermMap = polTermMap;
	}

	public List getUserStateMapR()
	{
		if (userStateMapR != null && userStateMapR.size() > 0)
		{
			return userStateMapR;
		} else
		{
			userStateMapR = createCodeItem("UserState", "R");
			return userStateMapR;
		}
	}

	public String getOldWorkType()
	{
		return oldWorkType;
	}

	public void setOldWorkType(String oldWorkType)
	{
		this.oldWorkType = oldWorkType;
	}

	public String getCurrentWorkType()
	{
		return currentWorkType;
	}

	public void setCurrentWorkType(String currentWorkType)
	{
		this.currentWorkType = currentWorkType;
	}

	public String getCurrentInsuredWorkType()
	{
		return currentInsuredWorkType;
	}

	public void setCurrentInsuredWorkType(String currentInsuredWorkType)
	{
		this.currentInsuredWorkType = currentInsuredWorkType;
	}

	public String getOldInsuredWorkType()
	{
		return oldInsuredWorkType;
	}

	public void setOldInsuredWorkType(String oldInsuredWorkType)
	{
		this.oldInsuredWorkType = oldInsuredWorkType;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String riskCode)
	{
		this.riskCode = riskCode;
	}

	public String getComCode()
	{
		return comCode;
	}

	public void setComCode(String comCode)
	{
		this.comCode = comCode;
	}

	public String getPhoneAreaCode()
	{
		return phoneAreaCode;
	}

	public void setPhoneAreaCode(String phoneAreaCode)
	{
		this.phoneAreaCode = phoneAreaCode;
	}

	public void setBranchAttrList(List branchAttrList)
	{
		this.branchAttrList = branchAttrList;
	}

	public List getPolicyStateMap()
	{
		if (policyStateMap != null && policyStateMap.size() > 0)
		{
			return policyStateMap;
		} else
		{
			policyStateMap = createCodeItem("polstate", "L");
			return policyStateMap;
		}
	}

	public void setPolicyStateMap(List policyStateMap)
	{
		this.policyStateMap = policyStateMap;
	}

	public List getCalTypeMap()
	{
		if (calTypeMap != null && calTypeMap.size() > 0)
			return calTypeMap;
		calTypeMap.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename  from mcode where codetype='caltype'  order by code";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			calTypeMap.add(new SelectItem(tSSRS.GetText(i, 1), (new StringBuilder(String.valueOf(tSSRS.GetText(i, 1)))).append("--").append(tSSRS.GetText(i, 2)).toString()));

		return calTypeMap;
	}

	public void setCalTypeMap(List calTypeMap)
	{
		this.calTypeMap = calTypeMap;
	}

	public List getPersionTypeMap()
	{
		if (persionTypeMap != null && persionTypeMap.size() > 0)
		{
			return persionTypeMap;
		} else
		{
			persionTypeMap = createCodeItem("persionType", "L");
			return persionTypeMap;
		}
	}

	public void setPersionTypeMap(List persionTypeMap)
	{
		this.persionTypeMap = persionTypeMap;
	}

	public List getPersionTypelist()
	{
		if (persionTypelist != null && persionTypelist.size() > 0)
			return persionTypelist;
		persionTypelist.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename  from mcode where codetype='persionType'  order by code";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			persionTypelist.add(new SelectItem(tSSRS.GetText(i, 1), (new StringBuilder(String.valueOf(tSSRS.GetText(i, 1)))).append("--").append(tSSRS.GetText(i, 2)).toString()));

		return persionTypelist;
	}

	public void setPersionTypelist(List persionTypelist)
	{
		this.persionTypelist = persionTypelist;
	}

	public List getCustomerTypeMap()
	{
		if (customerTypeMap != null && customerTypeMap.size() > 0)
		{
			return customerTypeMap;
		} else
		{
			customerTypeMap = createCodeItem("customerType", "L");
			return customerTypeMap;
		}
	}

	public void setCustomerTypeMap(List customerTypeMap)
	{
		this.customerTypeMap = customerTypeMap;
	}

	public List getSexMap()
	{
		if (sexMap != null && sexMap.size() > 0)
		{
			return sexMap;
		} else
		{
			sexMap = createCodeItem("sex", "L");
			return sexMap;
		}
	}

	public void setSexMap(List sexMap)
	{
		this.sexMap = sexMap;
	}

	public List getDeGreeMap()
	{
		if (deGreeMap != null && deGreeMap.size() > 0)
		{
			return deGreeMap;
		} else
		{
			deGreeMap = createCodeItem("degree", "L");
			return deGreeMap;
		}
	}

	public void setDeGreeMap(List deGreeMap)
	{
		this.deGreeMap = deGreeMap;
	}

	public List getIdTypeMap()
	{
		if (idTypeMap != null && idTypeMap.size() > 0)
		{
			return idTypeMap;
		} else
		{
			idTypeMap = createCodeItem("customeridtype", "L");
			return idTypeMap;
		}
	}

	public void setIdTypeMap(List idTypeMap)
	{
		this.idTypeMap = idTypeMap;
	}

	public List getMaintainProjectType()
	{
		if (maintainProjectType != null && maintainProjectType.size() > 0)
			return maintainProjectType;
		maintainProjectType.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename  from mcode where codetype='maintainProject'  order by codeorder";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			maintainProjectType.add(new SelectItem(tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));

		return maintainProjectType;
	}

	public void setMaintainProjectType(List maintainProjectType)
	{
		this.maintainProjectType = maintainProjectType;
	}

	public List getYesnoList()
	{
		if (yesnoList != null && yesnoList.size() > 0)
			return yesnoList;
		yesnoList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename  from mcode where codetype='yesno'  order by codeorder";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			yesnoList.add(new SelectItem(tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));

		return yesnoList;
	}

	public void setYesnoList(List yesnoList)
	{
		this.yesnoList = yesnoList;
	}

	public List getAgentgroupList()
	{
		if (agentgroupList != null && agentgroupList.size() > 0)
			return agentgroupList;
		agentgroupList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select comcode , shortname from mcom";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			agentgroupList.add(new SelectItem(tSSRS.GetText(i, 1), (new StringBuilder(String.valueOf(tSSRS.GetText(i, 1)))).append("--").append(tSSRS.GetText(i, 2)).toString()));

		return agentgroupList;
	}

	public void setAgentgroupList(List agentgroupList)
	{
		this.agentgroupList = agentgroupList;
	}

	public List getChangeCodeMap()
	{
		if (changeCodeMap != null && changeCodeMap.size() > 0)
		{
			return changeCodeMap;
		} else
		{
			changeCodeMap = createCodeItem("ChangeCode", "L");
			return changeCodeMap;
		}
	}

	public void setChangeCodeMap(List changeCodeMap)
	{
		this.changeCodeMap = changeCodeMap;
	}
}
