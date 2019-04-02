// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCodeList.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.lis.db.LNPCodeDB;
import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public class LNPCodeList
{

	private List relationFamilyList;
	private List familyRelaItems;
	private List idTypeList;
	private List countryOrAreaList;
	private List degreesList;
	private List marriageList;
	private List customeTypeList;
	private List yearTypeList;
	private List montheList;
	private List dayList;
	private List sugNameList;
	private List sugPrintList;
	private List sugIntervalList;
	private List cityList;
	private List cityList0;
	private List sexList;
	private List burialType;
	private List schoolType;
	private List loanNameList;
	private List hospitalStageList;
	private List hosRoomStageList;
	private List incomeDataList;
	private List investDataList;
	private List insuranceList;
	private List feeNameList;
	private List tfeeNameList;
	private List payYearTypeList;
	private List helpTypeName;
	private List insuSexList;
	private List insuredidtypeList;
	private List idPerpetualList;
	private List insuCityList;
	private List countryareacodeList;
	private List contStatusList;
	private List isAgreeList;
	private List bonusAndPayTypeList;
	private List marriagecodeList;
	private List bnfRelationtoinsuredList;
	private List appntRelationtoinsuredList;
	private List lnpStateList;

	public LNPCodeList()
	{
		relationFamilyList = new ArrayList();
		familyRelaItems = new ArrayList();
		idTypeList = new ArrayList();
		countryOrAreaList = new ArrayList();
		degreesList = new ArrayList();
		marriageList = new ArrayList();
		customeTypeList = new ArrayList();
		yearTypeList = new ArrayList();
		montheList = new ArrayList();
		dayList = new ArrayList();
		sugNameList = new ArrayList();
		sugPrintList = new ArrayList();
		sugIntervalList = new ArrayList();
		cityList = new ArrayList();
		cityList0 = new ArrayList();
		sexList = new ArrayList();
		burialType = new ArrayList();
		schoolType = new ArrayList();
		loanNameList = new ArrayList();
		hospitalStageList = new ArrayList();
		hosRoomStageList = new ArrayList();
		incomeDataList = new ArrayList();
		investDataList = new ArrayList();
		insuranceList = new ArrayList();
		feeNameList = new ArrayList();
		tfeeNameList = new ArrayList();
		payYearTypeList = new ArrayList();
		helpTypeName = new ArrayList();
		insuSexList = new ArrayList();
		insuredidtypeList = new ArrayList();
		idPerpetualList = new ArrayList();
		insuCityList = new ArrayList();
		countryareacodeList = new ArrayList();
		contStatusList = new ArrayList();
		isAgreeList = new ArrayList();
		bonusAndPayTypeList = new ArrayList();
		marriagecodeList = new ArrayList();
		bnfRelationtoinsuredList = new ArrayList();
		appntRelationtoinsuredList = new ArrayList();
		lnpStateList = new ArrayList();
	}

	public List getLnpStateList()
	{
		if (lnpStateList != null)
			lnpStateList.clear();
		lnpStateList = getNormalList("lnpState");
		return lnpStateList;
	}

	public void setLnpStateList(List lnpStateList)
	{
		this.lnpStateList = lnpStateList;
	}

	public List getIsAgreeList()
	{
		if (isAgreeList != null)
			isAgreeList.clear();
		isAgreeList = getNormalList("isAgree");
		return isAgreeList;
	}

	public void setIsAgreeList(List isAgreeList)
	{
		this.isAgreeList = isAgreeList;
	}

	public List getInsuCityList()
	{
		if (insuCityList != null)
			insuCityList.clear();
		insuCityList = getNormalList("insuCityType");
		return insuCityList;
	}

	public List getAppntRelationtoinsuredList()
	{
		if (appntRelationtoinsuredList != null)
			appntRelationtoinsuredList.clear();
		appntRelationtoinsuredList = getNormalList("appntrelationtoinsured");
		return appntRelationtoinsuredList;
	}

	public void setAppntRelationtoinsuredList(List appntRelationtoinsuredList)
	{
		this.appntRelationtoinsuredList = appntRelationtoinsuredList;
	}

	public void setInsuCityList(List insuCityList)
	{
		this.insuCityList = insuCityList;
	}

	public List getBonusAndPayTypeList()
	{
		if (bonusAndPayTypeList != null)
			bonusAndPayTypeList.clear();
		bonusAndPayTypeList = getNormalList("bonusAndPayType");
		return bonusAndPayTypeList;
	}

	public void setBonusAndPayTypeList(List bonusAndPayTypeList)
	{
		this.bonusAndPayTypeList = bonusAndPayTypeList;
	}

	public List getIdPerpetualList()
	{
		if (idPerpetualList != null)
			idPerpetualList.clear();
		idPerpetualList = getNormalList("idPerpetualType");
		return idPerpetualList;
	}

	public void setIdPerpetualList(List idPerpetualList)
	{
		this.idPerpetualList = idPerpetualList;
	}

	public List getBnfRelationtoinsuredList()
	{
		if (bnfRelationtoinsuredList != null)
			bnfRelationtoinsuredList.clear();
		bnfRelationtoinsuredList = getNormalList("bnfrelationtoinsured");
		return bnfRelationtoinsuredList;
	}

	public void setBnfRelationtoinsuredList(List bnfRelationtoinsuredList)
	{
		this.bnfRelationtoinsuredList = bnfRelationtoinsuredList;
	}

	public List getInsuSexList()
	{
		if (insuSexList != null)
			insuSexList.clear();
		insuSexList = getNormalList("sex");
		return insuSexList;
	}

	public void setInsuSexList(List insuSexList)
	{
		this.insuSexList = insuSexList;
	}

	public List getContStatusList()
	{
		if (contStatusList != null)
			contStatusList.clear();
		contStatusList = getNormalList("contStatus");
		return contStatusList;
	}

	public void setContStatusList(List contStatusList)
	{
		this.contStatusList = contStatusList;
	}

	private List getNormalList(String typename)
	{
		List reList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select code,codename from lnpcode where codetype='")).append(typename).append("' order by code").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return reList;
	}

	public List getCountryareacodeList()
	{
		if (countryareacodeList != null)
			countryareacodeList.clear();
		insuredidtypeList = new ArrayList();
		countryareacodeList = getNormalList("countryareacode");
		return countryareacodeList;
	}

	public void setCountryareacodeList(List countryareacodeList)
	{
		this.countryareacodeList = countryareacodeList;
	}

	public List getInsuredidtypeList()
	{
		if (insuredidtypeList != null)
			insuredidtypeList.clear();
		insuredidtypeList = new ArrayList();
		insuredidtypeList = getNormalList("insuredidtype");
		return insuredidtypeList;
	}

	public void setInsuredidtypeList(List insuredidtypeList)
	{
		this.insuredidtypeList = insuredidtypeList;
	}

	public List getMarriagecodeList()
	{
		if (marriagecodeList != null)
			marriagecodeList.clear();
		marriagecodeList = new ArrayList();
		marriagecodeList = getNormalList("marriagecode");
		return marriagecodeList;
	}

	public void setMarriagecodeList(List marriagecodeList)
	{
		this.marriagecodeList = marriagecodeList;
	}

	public void change()
	{
		System.out.println("data Changed");
	}

	public List getLoanNameList()
	{
		loanNameList = new ArrayList();
		loanNameList.add(new SelectItem(new String("汽车贷款"), "汽车贷款"));
		loanNameList.add(new SelectItem(new String("信用贷款"), "信用贷款"));
		loanNameList.add(new SelectItem(new String("个人借贷"), "个人借贷"));
		loanNameList.add(new SelectItem(new String("其他自定义"), "其他自定义"));
		return loanNameList;
	}

	public void setLoanNameList(List LoanNameList)
	{
		loanNameList = LoanNameList;
	}

	public List getSchoolType()
	{
		schoolType = new ArrayList();
		schoolType.add(new SelectItem(new String("c0"), "公立"));
		schoolType.add(new SelectItem(new String("c1"), "私立"));
		schoolType.add(new SelectItem(new String("c2"), "境外"));
		return schoolType;
	}

	public void setSchoolType(List schoolType)
	{
		this.schoolType = schoolType;
	}

	public List getBurialType()
	{
		burialType = new ArrayList();
		burialType.add(new SelectItem(new String("f0"), ""));
		burialType.add(new SelectItem(new String("f1"), "1级"));
		burialType.add(new SelectItem(new String("f2"), "2级"));
		burialType.add(new SelectItem(new String("f3"), "3级"));
		return burialType;
	}

	public void setBurialType(List burialType)
	{
		this.burialType = burialType;
	}

	public List getSexList()
	{
		sexList = new ArrayList();
		sexList.add(new SelectItem(new String("0"), "男"));
		sexList.add(new SelectItem(new String("1"), "女"));
		return sexList;
	}

	public void setSexList(List sexList)
	{
		this.sexList = sexList;
	}

	public List getIdTypeList()
	{
		if (idTypeList.size() <= 0)
		{
			idTypeList = new ArrayList();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = "select code,codename from ldcode where codetype='idtype' ";
			tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				idTypeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		}
		return idTypeList;
	}

	public void setIdTypeList(List idTypeList)
	{
		this.idTypeList = idTypeList;
	}

	public List getCountryOrAreaList()
	{
		if (countryOrAreaList.size() <= 0)
		{
			countryOrAreaList = new ArrayList();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = "select code,codename from ldcode where codetype='countryareacode' ";
			tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				countryOrAreaList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		}
		return countryOrAreaList;
	}

	public void setCountryOrAreaList(List countryOrAreaList)
	{
		this.countryOrAreaList = countryOrAreaList;
	}

	public List getMarriageList()
	{
		if (marriageList.size() <= 0)
		{
			marriageList = new ArrayList();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = "select code,codename from ldcode where codetype='wedlock' ";
			tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				marriageList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		}
		return marriageList;
	}

	public void setMarriageList(List marriageList)
	{
		this.marriageList = marriageList;
	}

	public List getCustomeTypeList()
	{
		if (customeTypeList.size() <= 0)
		{
			customeTypeList = new ArrayList();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = "select code,codename from ldcode where codetype='customeType-old' ";
			tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				customeTypeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		}
		return customeTypeList;
	}

	public void setCustomeTypeList(List customeTypeList)
	{
		this.customeTypeList = customeTypeList;
	}

	public List getDegreesList()
	{
		if (degreesList.size() <= 0)
		{
			degreesList = new ArrayList();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = "select code,codename from ldcode where codetype='degree' ";
			tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				degreesList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		}
		return degreesList;
	}

	public void setDegreesList(List degreesList)
	{
		this.degreesList = degreesList;
	}

	public List getYearTypeList()
	{
		if (yearTypeList.size() <= 0)
		{
			yearTypeList = new ArrayList();
			for (int i = 1900; i <= 2020; i++)
				yearTypeList.add(new SelectItem(String.valueOf(i), String.valueOf(i)));

		}
		return yearTypeList;
	}

	public void setYearTypeList(List yearTypeList)
	{
		this.yearTypeList = yearTypeList;
	}

	public List getMontheList()
	{
		if (montheList.size() <= 0)
		{
			montheList = new ArrayList();
			for (int j = 1; j <= 12; j++)
				if (j >= 10)
					montheList.add(new SelectItem(String.valueOf(j), String.valueOf(j)));
				else
					montheList.add(new SelectItem((new StringBuilder("0")).append(j).toString(), (new StringBuilder("0")).append(j).toString()));

		}
		return montheList;
	}

	public void setMontheList(List montheList)
	{
		this.montheList = montheList;
	}

	public List getDayList()
	{
		if (dayList.size() <= 0)
		{
			dayList = new ArrayList();
			for (int j = 1; j <= 31; j++)
				if (j >= 10)
					dayList.add(new SelectItem(String.valueOf(j), String.valueOf(j)));
				else
					dayList.add(new SelectItem((new StringBuilder("0")).append(j).toString(), (new StringBuilder("0")).append(j).toString()));

		}
		return dayList;
	}

	public void setDayList(List dayList)
	{
		this.dayList = dayList;
	}

	public List getSugNameList()
	{
		sugNameList = new ArrayList();
		LNPCodeDB reLNPCodeDB = new LNPCodeDB();
		reLNPCodeDB.setCodeType("suggestname");
		LNPCodeSet reLNPCodeSet = reLNPCodeDB.query();
		for (int i = 1; reLNPCodeSet != null && i <= reLNPCodeSet.size(); i++)
		{
			LNPCodeSchema tempLNPCodeSchema = reLNPCodeSet.get(i);
			sugNameList.add(new SelectItem(tempLNPCodeSchema.getCodeAlias()));
		}

		return sugNameList;
	}

	public void setSugNameList(List sugNameList)
	{
		this.sugNameList = sugNameList;
	}

	public List getSugPrintList()
	{
		sugPrintList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename from ldcode where codetype='CoverPic' ";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			sugPrintList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return sugPrintList;
	}

	public void setSugPrintList(List sugPrintList)
	{
		this.sugPrintList = sugPrintList;
	}

	public List getSugIntervalList()
	{
		sugIntervalList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select code,codename from ldcode where codetype='printIntv' Order By codealias";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			sugIntervalList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return sugIntervalList;
	}

	public void setSugIntervalList(List sugIntervalList)
	{
		this.sugIntervalList = sugIntervalList;
	}

	public List getCityList()
	{
		if (cityList.size() <= 0)
		{
			cityList = new ArrayList();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = "select code,codename from ldcode where codetype='province' Order By code";
			tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				cityList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		}
		return cityList;
	}

	public void setCityList(List cityList)
	{
		this.cityList = cityList;
	}

	public List getCityList0()
	{
		if (cityList0.size() <= 0)
		{
			cityList0 = new ArrayList();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = "select code,codename from ldcode where codetype='province' Order By code";
			tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				cityList0.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		}
		return cityList0;
	}

	public void setCityList0(List cityList)
	{
		cityList0 = cityList;
	}

	public List getFamilyRelaItems()
	{
		if (familyRelaItems.size() <= 0)
		{
			familyRelaItems = new ArrayList();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = "select code,codename from ldcode where codetype='relation' Order By code";
			tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				familyRelaItems.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		}
		return familyRelaItems;
	}

	public void setFamilyRelaItems(List familyRelaItems)
	{
		this.familyRelaItems = familyRelaItems;
	}

	public List getFeeNameList()
	{
		feeNameList = new ArrayList();
		feeNameList.add(new SelectItem(new String("旅游费用"), "旅游费用"));
		feeNameList.add(new SelectItem(new String("结婚费用"), "结婚费用"));
		feeNameList.add(new SelectItem(new String("保险费"), "保险费"));
		feeNameList.add(new SelectItem(new String("其他自定义"), "其他自定义"));
		return feeNameList;
	}

	public void setFeeNameList(List feeNameList)
	{
		this.feeNameList = feeNameList;
	}

	public List getHospitalStageList()
	{
		hospitalStageList = new ArrayList();
		hospitalStageList.add(new SelectItem("h0", "三级甲等"));
		hospitalStageList.add(new SelectItem("h1", "三级乙等"));
		hospitalStageList.add(new SelectItem("h2", "二级甲等"));
		hospitalStageList.add(new SelectItem("h3", "二级乙等"));
		return hospitalStageList;
	}

	public void setHospitalStageList(List hospitalStageList)
	{
		this.hospitalStageList = hospitalStageList;
	}

	public List getHosRoomStageList()
	{
		hosRoomStageList = new ArrayList();
		hosRoomStageList.add(new SelectItem("h0", "单人间"));
		hosRoomStageList.add(new SelectItem("h1", "多人间"));
		return hosRoomStageList;
	}

	public void setHosRoomStageList(List hosRoomStageList)
	{
		this.hosRoomStageList = hosRoomStageList;
	}

	public List getRelationFamilyList()
	{
		if (relationFamilyList.size() <= 0)
		{
			relationFamilyList = new ArrayList();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = new SSRS();
			String sql = "select code,codename from ldcode where codetype='relationFamily' Order By comcode";
			tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
				relationFamilyList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		}
		return relationFamilyList;
	}

	public void setRelationFamilyList(List relationFamilyList)
	{
		this.relationFamilyList = relationFamilyList;
	}

	public List getIncomeDataList()
	{
		incomeDataList = new ArrayList();
		incomeDataList.add(new SelectItem(new String("租房收入"), "租房收入"));
		incomeDataList.add(new SelectItem(new String("子女奉养金"), "子女奉养金"));
		incomeDataList.add(new SelectItem(new String("其他自定义"), "其他自定义"));
		return incomeDataList;
	}

	public void setIncomeDataList(List incomeDataList)
	{
		this.incomeDataList = incomeDataList;
	}

	public List getInvestDataList()
	{
		investDataList = new ArrayList();
		investDataList.add(new SelectItem(new String("储蓄"), "储蓄"));
		investDataList.add(new SelectItem(new String("投资性房地产"), "投资性房地产"));
		investDataList.add(new SelectItem(new String("股票"), "股票"));
		investDataList.add(new SelectItem(new String("基金"), "基金"));
		investDataList.add(new SelectItem(new String("其他自定义"), "其他自定义"));
		return investDataList;
	}

	public void setInvestDataList(List investDataList)
	{
		this.investDataList = investDataList;
	}

	public List getInsuranceList()
	{
		insuranceList = new ArrayList();
		insuranceList.add(new SelectItem(new String("0"), "终身"));
		insuranceList.add(new SelectItem(new String("1"), "养老"));
		insuranceList.add(new SelectItem(new String("2"), "定期"));
		return insuranceList;
	}

	public void setInsuranceList(List insuranceList)
	{
		this.insuranceList = insuranceList;
	}

	public List getTfeeNameList()
	{
		tfeeNameList = new ArrayList();
		tfeeNameList.add(new SelectItem(new String("遗产处置"), "遗产处置"));
		tfeeNameList.add(new SelectItem(new String("护理费用"), "护理费用"));
		tfeeNameList.add(new SelectItem(new String("医疗费用"), "医疗费用"));
		tfeeNameList.add(new SelectItem(new String("旅游费用"), "旅游费用"));
		tfeeNameList.add(new SelectItem(new String("其他自定义"), "其他自定义"));
		return tfeeNameList;
	}

	public void setTfeeNameList(List tfeeNameList)
	{
		this.tfeeNameList = tfeeNameList;
	}

	public List getPayYearTypeList()
	{
		payYearTypeList = new ArrayList();
		payYearTypeList.add(new SelectItem(new String("a"), "交费年期 (年)"));
		payYearTypeList.add(new SelectItem(new String("b"), "缴至年龄 (岁)"));
		return payYearTypeList;
	}

	public void setPayYearTypeList(List payYearTypeList)
	{
		this.payYearTypeList = payYearTypeList;
	}

	public List getHelpTypeName()
	{
		helpTypeName = new ArrayList();
		helpTypeName.add(new SelectItem(new String(""), ""));
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = "select distinct helpType from fnahelppara";
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			helpTypeName.add(new SelectItem(new String(tSSRS.GetText(i, 1)), tSSRS.GetText(i, 1)));

		return helpTypeName;
	}

	public void setHelpTypeName(List helpTypeName)
	{
		this.helpTypeName = helpTypeName;
	}
}
