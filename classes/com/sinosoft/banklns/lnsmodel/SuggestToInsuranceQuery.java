// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SuggestToInsuranceQuery.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPContDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.LNPPolSet;
import com.sinosoft.banklns.lnsmodel.entity.LNPSuggestToInsuranceBean;
import com.sinosoft.banklns.utility.*;
import com.sinosoft.map.lis.pubfun.PubFun;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

public class SuggestToInsuranceQuery
{

	private String message;
	private boolean alertFlag;
	private LNPSuggestToInsuranceBean stiBean;
	private List stiBeanList;
	private String startDate;
	private String endDate;
	private IGlobalInput tempGI;
	private boolean showErrorFlag;
	List comCodeList;
	private String contNo;
	private String checkedContNo;
	private String sugNo;
	private String sugInsuredNo;
	private String sugAppntNo;
	private String sugManageCom;
	private String checkRiskcode;
	private boolean checkRiskFlag;

	public SuggestToInsuranceQuery()
	{
		message = "";
		alertFlag = false;
		stiBean = new LNPSuggestToInsuranceBean();
		stiBeanList = null;
		startDate = null;
		endDate = null;
		tempGI = null;
		showErrorFlag = false;
		comCodeList = new ArrayList();
		contNo = "";
		checkedContNo = "";
		sugNo = "";
		sugInsuredNo = "";
		sugAppntNo = "";
		sugManageCom = "";
		checkRiskcode = "";
		checkRiskFlag = false;
	}

	public String getCheckRiskcode()
	{
		return checkRiskcode;
	}

	public void setCheckRiskcode(String checkRiskcode)
	{
		this.checkRiskcode = checkRiskcode;
	}

	public void initData()
	{
		System.out.println("--- SuggestToInsuranceQuery initData ---");
		if (stiBeanList != null)
			stiBeanList.clear();
		else
			stiBeanList = new ArrayList();
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
		if (tempGI == null)
		{
			message = "??\274????????????????\265?\275??";
			alertFlag = true;
			return;
		}
		if (tempGI.OperType == null || tempGI.OperType.equals(""))
		{
			message = "?????\275???\373?§ß???????????";
			alertFlag = true;
			return;
		} else
		{
			return;
		}
	}

	public void querySuggestInfo()
	{
		System.out.println("--- SuggestToInsuranceQuery querySuggestInfo Start ---");
		alertFlag = false;
		showErrorFlag = false;
		stiBeanList = new ArrayList();
		if (tempGI == null)
		{
			message = "?\365?\274???\373?§ß???????????";
			alertFlag = true;
			return;
		}
		if (!validateQueryInfo())
		{
			alertFlag = true;
			return;
		}
		try
		{
			String sql = "select distinct s.contno,s.insuredno,s.appntno,s.makedate,s.managecom,s.i_name,s.i_birthday,s.i_idno,s.maketime  from ( select top 200 c.contno,c.insuredno,c.appntno,c.makedate,c.maketime,c.managecom,i.name i_name,i.birthday i_birthday,i.idno i_idno   from lscont c ,lsinsured i where  i.contno=c.contno and c.contno is not null  ";
			sql = (new StringBuilder(String.valueOf(sql))).append("and c.managecom like '").append(tempGI.ManageCom).append("%' ").toString();
			if ("1".equals(tempGI.OperType))
				sql = (new StringBuilder(String.valueOf(sql))).append(" and c.operator='").append(tempGI.Operator).append("' ").toString();
			String chanleSign = getOutcode("branchtype", "lnp", tempGI.chanlesign);
			if (chanleSign != null && !"".equals(chanleSign))
				sql = (new StringBuilder(String.valueOf(sql))).append(" and c.salechnl = '").append(chanleSign).append("' ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" order by c.makedate desc,c.maketime desc ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" ) s  ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append("where 1=1 ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(appendSql()).toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" order by s.makedate desc,s.maketime desc").toString();
			System.out.println((new StringBuilder("QuerySuggestInfo SQL_c : ")).append(sql).toString());
			ExeSQL tExeSql = new ExeSQL();
			SSRS ssrs = tExeSql.execSQL(sql);
			if (ssrs != null && ssrs.MaxRow > 0)
			{
				System.out.println((new StringBuilder("QuerySuggestInfo size : ")).append(ssrs.MaxRow).toString());
				if (ssrs.MaxRow >= 200)
					showErrorFlag = true;
				stiBeanList = new ArrayList();
				for (int i = 1; i <= ssrs.MaxRow; i++)
				{
					LNPSuggestToInsuranceBean temp = new LNPSuggestToInsuranceBean();
					String SugNO = "";
					if (ssrs.GetText(i, 1) != null && !"".equals(ssrs.GetText(i, 1)))
						SugNO = ssrs.GetText(i, 1);
					temp.setSugNo(SugNO);
					temp.setRiskCode(getRiskString(SugNO));
					if (ssrs.GetText(i, 2) != null && !"".equals(ssrs.GetText(i, 2)))
						temp.setSugInsuredNo(ssrs.GetText(i, 2));
					if (ssrs.GetText(i, 3) != null && !"".equals(ssrs.GetText(i, 3)))
						temp.setSugAppntNo(ssrs.GetText(i, 3));
					if (ssrs.GetText(i, 4) != null && !"".equals(ssrs.GetText(i, 4)))
						temp.setMakeDate(ssrs.GetText(i, 4).substring(0, 10));
					if (ssrs.GetText(i, 5) != null && !"".equals(ssrs.GetText(i, 5)))
						temp.setManageCom(ssrs.GetText(i, 5));
					if (ssrs.GetText(i, 6) != null && !"".equals(ssrs.GetText(i, 6)))
						temp.setInsuredName(ssrs.GetText(i, 6));
					if (ssrs.GetText(i, 7) != null && !"".equals(ssrs.GetText(i, 7)))
						temp.setInsuredBirthday(ssrs.GetText(i, 7).substring(0, 10));
					if (ssrs.GetText(i, 8) != null && !"".equals(ssrs.GetText(i, 8)))
						temp.setInsuredIDNo(ssrs.GetText(i, 8));
					String sql_p = (new StringBuilder("select sum(p.prem) from lspol p where p.contno='")).append(SugNO).append("' ").toString();
					DecimalFormat formatMoney = new DecimalFormat("#,##0.00");
					ExeSQL tExeSql_p = new ExeSQL();
					SSRS ssrs_p = tExeSql_p.execSQL(sql_p);
					String prem = "";
					if (ssrs_p != null && ssrs_p.MaxRow > 0 && ssrs_p.GetText(1, 1) != null && !"".equals(ssrs_p.GetText(1, 1)) && !"NULL".equals(ssrs_p.GetText(1, 1).toUpperCase()))
					{
						String temoprem = ssrs_p.GetText(1, 1);
						prem = (new StringBuilder(String.valueOf(formatMoney.format(Double.parseDouble(temoprem))))).append(" ?").toString();
					}
					temp.setPrem(prem);
					stiBeanList.add(temp);
				}

			} else
			{
				message = " \373?§Ù?????????";
				alertFlag = true;
				if (stiBeanList != null)
					stiBeanList.clear();
				else
					stiBeanList = new ArrayList();
				return;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("--- SuggestToInsuranceQuery querySuggestInfo End ---");
		return;
	}

	private String appendSql()
	{
		String appSql = "";
		if (stiBean.getInsuredName() != null && !"".equals(stiBean.getInsuredName()))
			appSql = (new StringBuilder(String.valueOf(appSql))).append(" and s.i_name like '%").append(stiBean.getInsuredName()).append("%' ").toString();
		if (stiBean.getInsuredIDNo() != null && !"".equals(stiBean.getInsuredIDNo()))
			appSql = (new StringBuilder(String.valueOf(appSql))).append(" and s.i_idno = '").append(stiBean.getInsuredIDNo()).append("' ").toString();
		if (getStartDate() != null && !"".equals(getStartDate()))
			appSql = (new StringBuilder(String.valueOf(appSql))).append(" and s.makedate >=  '").append(getStartDate()).append("' ").toString();
		if (getEndDate() != null && !"".equals(getEndDate()))
			appSql = (new StringBuilder(String.valueOf(appSql))).append(" and s.makedate <=  '").append(getEndDate()).append("' ").toString();
		return appSql;
	}

	private String getRiskString(String contno)
	{
		ExeSQL tExeSQL = new ExeSQL();
		String riskListString = "";
		String riskSQL1 = (new StringBuilder("select riskcode from lspol a where contno='")).append(contno).append("' and polno=mainpolno").toString();
		String riskSQL2 = (new StringBuilder("select riskcode from lspol b where contno='")).append(contno).append("' ").append("and polno<>mainpolno order by modifydate ,modifytime").toString();
		SSRS tSSRS1 = tExeSQL.execSQL(riskSQL1);
		SSRS tSSRS2 = tExeSQL.execSQL(riskSQL2);
		riskListString = "";
		if (tSSRS1.MaxRow > 0)
		{
			riskListString = tSSRS1.GetText(1, 1);
			if (tSSRS2.MaxRow > 0)
			{
				for (int j = 1; j <= tSSRS2.MaxRow; j++)
					riskListString = (new StringBuilder(String.valueOf(riskListString))).append(",").append(tSSRS2.GetText(j, 1)).toString();

			}
		}
		return riskListString;
	}

	private String getDoubleStr(String value)
	{
		if (value == null)
			return null;
		String result = "";
		int ch = 0;
		ch = value.lastIndexOf(".");
		if (-1 == ch)
		{
			result = value;
		} else
		{
			String dotper = value.substring(0, ch);
			String dotAft = value.substring(ch, value.length());
			dotAft = dotAft.length() <= 3 ? dotAft : dotAft.substring(0, 3);
			result = (new StringBuilder(String.valueOf(dotper))).append(dotAft).toString();
		}
		return result;
	}

	private String getAgeByBirthday(String strBirthday, String strApplyDay)
	{
		String returnAge = "-1";
		String arrBirthday[] = strBirthday.split("-");
		String arrApplyday[] = strApplyDay.split("-");
		int age = Integer.parseInt(arrApplyday[0]) - Integer.parseInt(arrBirthday[0]) - 1;
		if (Integer.parseInt(arrApplyday[1]) > Integer.parseInt(arrBirthday[1]))
			age++;
		else
		if (Integer.parseInt(arrApplyday[1]) >= Integer.parseInt(arrBirthday[1]) && Integer.parseInt(arrApplyday[2]) >= Integer.parseInt(arrBirthday[2]))
			age++;
		if (age >= 0)
			if (age == 0)
				returnAge = (new StringBuilder(String.valueOf(age))).toString();
			else
				returnAge = (new StringBuilder(String.valueOf(age))).toString();
		return returnAge.trim();
	}

	private boolean validateQueryInfo()
	{
		if (stiBean.getInsuredIDNo() != null && !"".equals(stiBean.getInsuredIDNo()) && !ValidateTools.isValidString2(stiBean.getInsuredIDNo()))
		{
			message = " ????????????????????????????§Õ??";
			return false;
		} else
		{
			return true;
		}
	}

	public void initSuggestToInsurance()
	{
		contNo = "";
		alertFlag = false;
		sugNo = getSugNo();
		System.out.println((new StringBuilder("bean sugNo : ")).append(sugNo).toString());
		String magCode = "";
		ExeSQL tExeSql = new ExeSQL();
		String preSql = (new StringBuilder("select distinct managecom from lscont where contno = '")).append(sugNo).append("' ").toString();
		SSRS tSSRSfromCom = tExeSql.execSQL(preSql);
		if (tSSRSfromCom != null && tSSRSfromCom.MaxRow > 0)
			magCode = tSSRSfromCom.GetText(1, 1);
		setSugManageCom(magCode);
	}

	public void doSuggestToInsurance()
	{
		System.out.println("---doSuggestToInsurance Start---");
		alertFlag = false;
		MMap map = new MMap();
		VData vd = new VData();
		PubSubmit ps = new PubSubmit();
		ExeSQL tExeSQL = new ExeSQL();
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
		LNPContSchema lnpContSchema = new LNPContSchema();
		LNPInsuredSchema lnpInsuredSchema = new LNPInsuredSchema();
		LNPPersonSchema lnpInsPersonSchema = new LNPPersonSchema();
		LNPAddressSchema lnpInsAddressSchema = new LNPAddressSchema();
		LNPAppntSchema lnpAppntSchema = new LNPAppntSchema();
		LNPPersonSchema lnpAppPersonSchema = new LNPPersonSchema();
		LNPAddressSchema lnpAppAddressSchema = new LNPAddressSchema();
		LNPPolSet lnpPolSet = new LNPPolSet();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		if (!preDOValidateVar())
			return;
		sugInsuredNo = getSugInsuredNoFromDB(sugNo);
		sugAppntNo = getSugAppntNoFromDB(sugNo);
		if (tempGI == null)
		{
			alertFlag = true;
			message = " ?????????????";
			return;
		}
		System.out.println((new StringBuilder("bean do sugNo : ")).append(sugNo).toString());
		System.out.println((new StringBuilder("bean do sugInsuredNo : ")).append(sugInsuredNo).toString());
		System.out.println((new StringBuilder("bean do sugAppntNo : ")).append(sugAppntNo).toString());
		System.out.println("1. ?§Û?????");
		lnpContSchema.setContNo(contNo);
		lnpContSchema.setProposalContNo(lnpContSchema.getContNo());
		lnpContSchema.setGrpContNo(LNPPubFun.getSysInfo("grpcontno"));
		lnpContSchema.setPrtNo(LNPPubFun.getSysInfo("prtno"));
		lnpContSchema.setSugNo(sugNo);
		lnpContSchema.setContType("1");
		lnpContSchema.setPolType("1");
		lnpContSchema.setCardFlag("0");
		lnpContSchema.setState("01");
		lnpContSchema.setProposalType("1");
		lnpContSchema.setEditstate("1000000000");
		lnpContSchema.setOperator(tempGI.Operator);
		lnpContSchema.setManageCom(getManageCom(contNo));
		lnpContSchema.setSaleChnlDetail(tempGI.chanlesign);
		if ("1".equals(tempGI.OperType))
			lnpContSchema.setLang("0");
		else
			lnpContSchema.setLang("1");
		lnpContSchema.setApproveFlag("0");
		lnpContSchema.setUWFlag("0");
		lnpContSchema.setUWTime("0");
		lnpContSchema.setModifyDate(date);
		lnpContSchema.setModifyTime(time);
		lnpContSchema.setMakeDate(date);
		lnpContSchema.setMakeTime(time);
		lnpContSchema.setPSignDate(date);
		lnpContSchema.setPValiDate(countPValidate(date));
		System.out.println("2.?§Û?????????");
		lnpInsuredSchema.setGrpContNo(lnpContSchema.getGrpContNo());
		lnpInsuredSchema.setContNo(contNo);
		lnpInsuredSchema.setProposalContNo(contNo);
		lnpInsuredSchema.setPrtNo(lnpContSchema.getPrtNo());
		lnpInsuredSchema.setInsuredId(maxNoMap.CreateMaxNo("CustomerNo", ""));
		lnpInsuredSchema.setOperator(tempGI.Operator);
		lnpInsuredSchema.setModifyDate(date);
		lnpInsuredSchema.setModifyTime(time);
		lnpInsuredSchema.setMakeDate(date);
		lnpInsuredSchema.setMakeTime(time);
		String lsInsuredSQL = (new StringBuilder("select name,sex,birthday,occupationtype,occupationcode,nativeplace,relationtoappnt,idtype,idno,marriage,age from lsinsured where contno='")).append(sugNo).append("' ").toString();
		if (sugInsuredNo != null && !"".equals(sugInsuredNo))
			lsInsuredSQL = (new StringBuilder(String.valueOf(lsInsuredSQL))).append(" and insuredno='").append(sugInsuredNo).append("' ").toString();
		SSRS lsInsuredSSRS = tExeSQL.execSQL(lsInsuredSQL);
		if (lsInsuredSSRS != null && lsInsuredSSRS.MaxRow > 0)
		{
			if (lsInsuredSSRS.GetText(1, 1) != null && !"".equals(lsInsuredSSRS.GetText(1, 1)))
				lnpInsuredSchema.setName(lsInsuredSSRS.GetText(1, 1));
			if (lsInsuredSSRS.GetText(1, 2) != null && !"".equals(lsInsuredSSRS.GetText(1, 2)))
				lnpInsuredSchema.setSex(lsInsuredSSRS.GetText(1, 2));
			if (lsInsuredSSRS.GetText(1, 3) != null && !"".equals(lsInsuredSSRS.GetText(1, 3)))
				lnpInsuredSchema.setBirthday(lsInsuredSSRS.GetText(1, 3).substring(0, 10));
			if (lsInsuredSSRS.GetText(1, 4) != null && !"".equals(lsInsuredSSRS.GetText(1, 4)))
				lnpInsuredSchema.setOccupationType(lsInsuredSSRS.GetText(1, 4));
			if (lsInsuredSSRS.GetText(1, 5) != null && !"".equals(lsInsuredSSRS.GetText(1, 5)))
				lnpInsuredSchema.setOccupationCode(lsInsuredSSRS.GetText(1, 5));
			if (lsInsuredSSRS.GetText(1, 6) != null && !"".equals(lsInsuredSSRS.GetText(1, 6)))
			{
				String naticePlace = getOutcode("countryareacode", "ls", lsInsuredSSRS.GetText(1, 6));
				if (naticePlace != null && !"".equals(naticePlace))
					lnpInsuredSchema.setNativePlace(naticePlace);
				else
					lnpInsuredSchema.setNativePlace("0");
			} else
			{
				lnpInsuredSchema.setNativePlace("0");
			}
			if (lsInsuredSSRS.GetText(1, 7) != null && !"".equals(lsInsuredSSRS.GetText(1, 7)))
			{
				String outCode = getOutcode("relation", "ls", lsInsuredSSRS.GetText(1, 7));
				if (outCode != null && !"".equals(outCode))
					lnpInsuredSchema.setRelationToAppnt(outCode);
				else
					lnpInsuredSchema.setRelationToAppnt("H");
			} else
			{
				lnpInsuredSchema.setRelationToAppnt("H");
			}
			if (lsInsuredSSRS.GetText(1, 8) != null && !"".equals(lsInsuredSSRS.GetText(1, 8)))
			{
				String idType = getOutcode("idtype", "ls", lsInsuredSSRS.GetText(1, 8));
				if (idType != null && !"".equals(idType))
					lnpInsuredSchema.setIDType(idType);
			}
			if (lsInsuredSSRS.GetText(1, 9) != null && !"".equals(lsInsuredSSRS.GetText(1, 9)))
				lnpInsuredSchema.setIDNo(lsInsuredSSRS.GetText(1, 9));
			if (lsInsuredSSRS.GetText(1, 10) != null && !"".equals(lsInsuredSSRS.GetText(1, 10)))
			{
				String marr = getOutcode("wedlock", "ls", lsInsuredSSRS.GetText(1, 10));
				if (marr != null && !"".equals(marr))
					lnpInsuredSchema.setMarriage(marr);
			}
			if (lsInsuredSSRS.GetText(1, 11) != null && !"".equals(lsInsuredSSRS.GetText(1, 11)))
			{
				lnpInsuredSchema.setAppAge(lsInsuredSSRS.GetText(1, 11));
				lnpInsuredSchema.setAppAgeType("Y");
			}
		}
		lnpInsPersonSchema.setAgentCode(lnpInsuredSchema.getOperator());
		lnpInsPersonSchema.setCustomerId(lnpInsuredSchema.getInsuredId());
		lnpInsPersonSchema.setName(lnpInsuredSchema.getName() == null ? "" : lnpInsuredSchema.getName());
		lnpInsPersonSchema.setSex(lnpInsuredSchema.getSex() == null ? "" : lnpInsuredSchema.getSex());
		lnpInsPersonSchema.setBirthday(lnpInsuredSchema.getBirthday() == null ? "" : lnpInsuredSchema.getBirthday());
		lnpInsPersonSchema.setAgeType(lnpInsuredSchema.getAppAgeType() == null ? "" : lnpInsuredSchema.getAppAgeType());
		lnpInsPersonSchema.setAge(-1 >= lnpInsuredSchema.getAppAge() ? 0 : lnpInsuredSchema.getAppAge());
		lnpInsPersonSchema.setOccupationCode(lnpInsuredSchema.getOccupationCode() == null ? "" : lnpInsuredSchema.getOccupationCode());
		lnpInsPersonSchema.setOccupationType(lnpInsuredSchema.getOccupationType() == null ? "" : lnpInsuredSchema.getOccupationType());
		lnpInsPersonSchema.setIDType(lnpInsuredSchema.getIDType() == null ? "" : lnpInsuredSchema.getIDType());
		lnpInsPersonSchema.setIDNo(lnpInsuredSchema.getIDNo() == null ? "" : lnpInsuredSchema.getIDNo());
		lnpInsPersonSchema.setOperator(tempGI.Operator);
		lnpInsPersonSchema.setMakeDate(date);
		lnpInsPersonSchema.setMakeTime(time);
		lnpInsPersonSchema.setModifyDate(date);
		lnpInsPersonSchema.setModifyTime(time);
		lnpInsAddressSchema.setCustomerId(lnpInsuredSchema.getInsuredId());
		lnpInsAddressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
		lnpInsAddressSchema.setOperator(tempGI.Operator);
		lnpInsAddressSchema.setMakeDate(date);
		lnpInsAddressSchema.setMakeTime(time);
		lnpInsAddressSchema.setModifyDate(date);
		lnpInsAddressSchema.setModifyTime(time);
		String lsInsAddressSQL = "";
		if (sugInsuredNo != null && !"".equals(sugInsuredNo))
			lsInsAddressSQL = (new StringBuilder("select homecountyaddr,homezipcode,homephone,grpcountyaddr,grpzipcode,grpphone,email,addrchoise from lslatncycustm where customerno='")).append(sugInsuredNo).append("' ").toString();
		SSRS lsInsAddressSSRS = tExeSQL.execSQL(lsInsAddressSQL);
		if (lsInsAddressSSRS != null && lsInsAddressSSRS.MaxRow > 0)
		{
			if (lsInsAddressSSRS.GetText(1, 1) != null && !"".equals(lsInsAddressSSRS.GetText(1, 1)))
				lnpInsAddressSchema.setHomeAddress(lsInsAddressSSRS.GetText(1, 1));
			if (lsInsAddressSSRS.GetText(1, 2) != null && !"".equals(lsInsAddressSSRS.GetText(1, 2)))
				lnpInsAddressSchema.setHomeZipCode(lsInsAddressSSRS.GetText(1, 2));
			if (lsInsAddressSSRS.GetText(1, 3) != null && !"".equals(lsInsAddressSSRS.GetText(1, 3)))
				lnpInsAddressSchema.setHomePhone(lsInsAddressSSRS.GetText(1, 3));
			if (lsInsAddressSSRS.GetText(1, 4) != null && !"".equals(lsInsAddressSSRS.GetText(1, 4)))
				lnpInsAddressSchema.setCompanyAddress(lsInsAddressSSRS.GetText(1, 4));
			if (lsInsAddressSSRS.GetText(1, 5) != null && !"".equals(lsInsAddressSSRS.GetText(1, 5)))
				lnpInsAddressSchema.setCompanyZipCode(lsInsAddressSSRS.GetText(1, 5));
			if (lsInsAddressSSRS.GetText(1, 6) != null && !"".equals(lsInsAddressSSRS.GetText(1, 6)))
				lnpInsAddressSchema.setCompanyPhone(lsInsAddressSSRS.GetText(1, 6));
			if (lsInsAddressSSRS.GetText(1, 7) != null && !"".equals(lsInsAddressSSRS.GetText(1, 7)))
				lnpInsAddressSchema.setCompanyMail(lsInsAddressSSRS.GetText(1, 7));
			if (lsInsAddressSSRS.GetText(1, 8) != null && !"".equals(lsInsAddressSSRS.GetText(1, 8)))
			{
				String addrChoise = lsInsAddressSSRS.GetText(1, 8);
				if ("0".equals(addrChoise))
				{
					lnpInsAddressSchema.setPostalAddress(lnpInsAddressSchema.getHomeAddress() == null ? "" : lnpInsAddressSchema.getHomeAddress());
					lnpInsAddressSchema.setZipCode(lnpInsAddressSchema.getHomeZipCode() == null ? "" : lnpInsAddressSchema.getHomeZipCode());
					lnpInsAddressSchema.setPhone(lnpInsAddressSchema.getHomePhone() == null ? "" : lnpInsAddressSchema.getHomePhone());
				}
				if ("1".equals(addrChoise))
				{
					lnpInsAddressSchema.setPostalAddress(lnpInsAddressSchema.getCompanyAddress() == null ? "" : lnpInsAddressSchema.getCompanyAddress());
					lnpInsAddressSchema.setZipCode(lnpInsAddressSchema.getCompanyZipCode() == null ? "" : lnpInsAddressSchema.getCompanyZipCode());
					lnpInsAddressSchema.setPhone(lnpInsAddressSchema.getCompanyPhone() == null ? "" : lnpInsAddressSchema.getCompanyPhone());
				}
			}
		}
		lnpInsuredSchema.setAddressNo(lnpInsAddressSchema.getAddressNo());
		System.out.println("3.?§Û?????????");
		lnpAppntSchema.setGrpContNo(lnpContSchema.getGrpContNo());
		lnpAppntSchema.setContNo(contNo);
		lnpAppntSchema.setProposalContNo(contNo);
		lnpAppntSchema.setPrtNo(lnpContSchema.getPrtNo());
		lnpAppntSchema.setAppntId(maxNoMap.CreateMaxNo("CustomerNo", ""));
		lnpAppntSchema.setOperator(tempGI.Operator);
		lnpAppntSchema.setModifyDate(date);
		lnpAppntSchema.setModifyTime(time);
		lnpAppntSchema.setMakeDate(date);
		lnpAppntSchema.setMakeTime(time);
		String lsAppntSQL = (new StringBuilder("select appntname,appntsex,appntbirthday,occupationtype,occupationcode,nativeplace,idtype,idno,marriage,appntage  from lsappnt where contno='")).append(sugNo).append("' ").toString();
		if (sugAppntNo != null && !"".equals(sugAppntNo))
			lsAppntSQL = (new StringBuilder(String.valueOf(lsAppntSQL))).append(" and appntno='").append(sugAppntNo).append("' ").toString();
		SSRS lsAppntSSRS = tExeSQL.execSQL(lsAppntSQL);
		if (lsAppntSSRS != null && lsAppntSSRS.MaxRow > 0)
		{
			if (lsAppntSSRS.GetText(1, 1) != null && !"".equals(lsAppntSSRS.GetText(1, 1)))
				lnpAppntSchema.setAppntName(lsAppntSSRS.GetText(1, 1));
			if (lsAppntSSRS.GetText(1, 2) != null && !"".equals(lsAppntSSRS.GetText(1, 2)))
				lnpAppntSchema.setAppntSex(lsAppntSSRS.GetText(1, 2));
			if (lsAppntSSRS.GetText(1, 3) != null && !"".equals(lsAppntSSRS.GetText(1, 3)))
				lnpAppntSchema.setAppntBirthday(lsAppntSSRS.GetText(1, 3).substring(0, 10));
			if (lsAppntSSRS.GetText(1, 4) != null && !"".equals(lsAppntSSRS.GetText(1, 4)))
				lnpAppntSchema.setOccupationType(lsAppntSSRS.GetText(1, 4));
			if (lsAppntSSRS.GetText(1, 5) != null && !"".equals(lsAppntSSRS.GetText(1, 5)))
				lnpAppntSchema.setOccupationCode(lsAppntSSRS.GetText(1, 5));
			if (lsAppntSSRS.GetText(1, 6) != null && !"".equals(lsAppntSSRS.GetText(1, 6)))
			{
				String naticePlace = getOutcode("countryareacode", "ls", lsAppntSSRS.GetText(1, 6));
				if (naticePlace != null && !"".equals(naticePlace))
					lnpAppntSchema.setNativePlace(naticePlace);
				else
					lnpAppntSchema.setNativePlace("0");
			} else
			{
				lnpAppntSchema.setNativePlace("0");
			}
			if (lsAppntSSRS.GetText(1, 7) != null && !"".equals(lsAppntSSRS.GetText(1, 7)))
			{
				String idType = getOutcode("idtype", "ls", lsAppntSSRS.GetText(1, 7));
				if (idType != null && !"".equals(idType))
					lnpAppntSchema.setIDType(idType);
			}
			if (lsAppntSSRS.GetText(1, 8) != null && !"".equals(lsAppntSSRS.GetText(1, 8)))
				lnpAppntSchema.setIDNo(lsAppntSSRS.GetText(1, 8));
			if (lsAppntSSRS.GetText(1, 9) != null && !"".equals(lsAppntSSRS.GetText(1, 9)))
			{
				String marr = getOutcode("wedlock", "ls", lsAppntSSRS.GetText(1, 9));
				if (marr != null && !"".equals(marr))
					lnpAppntSchema.setMarriage(marr);
			}
			if (lsAppntSSRS.GetText(1, 10) != null && !"".equals(lsAppntSSRS.GetText(1, 10)))
			{
				lnpAppntSchema.setAppntAge(lsAppntSSRS.GetText(1, 10));
				lnpAppntSchema.setAppntAgeType("Y");
			}
		}
		lnpAppPersonSchema.setAgentCode(lnpAppntSchema.getOperator());
		lnpAppPersonSchema.setCustomerId(lnpAppntSchema.getAppntId());
		lnpAppPersonSchema.setName(lnpAppntSchema.getAppntName() == null ? "" : lnpAppntSchema.getAppntName());
		lnpAppPersonSchema.setSex(lnpAppntSchema.getAppntSex() == null ? "" : lnpAppntSchema.getAppntSex());
		lnpAppPersonSchema.setBirthday(lnpAppntSchema.getAppntBirthday() == null ? "" : lnpAppntSchema.getAppntBirthday());
		lnpAppPersonSchema.setAgeType(lnpAppntSchema.getAppntAgeType() == null ? "" : lnpAppntSchema.getAppntAgeType());
		lnpAppPersonSchema.setAge(-1 >= lnpAppntSchema.getAppntAge() ? 0 : lnpAppntSchema.getAppntAge());
		lnpAppPersonSchema.setOccupationCode(lnpAppntSchema.getOccupationCode() == null ? "" : lnpAppntSchema.getOccupationCode());
		lnpAppPersonSchema.setOccupationType(lnpAppntSchema.getOccupationType() == null ? "" : lnpAppntSchema.getOccupationType());
		lnpAppPersonSchema.setIDType(lnpAppntSchema.getIDType() == null ? "" : lnpAppntSchema.getIDType());
		lnpAppPersonSchema.setIDNo(lnpAppntSchema.getIDNo() == null ? "" : lnpAppntSchema.getIDNo());
		lnpAppPersonSchema.setOperator(tempGI.Operator);
		lnpAppPersonSchema.setMakeDate(date);
		lnpAppPersonSchema.setMakeTime(time);
		lnpAppPersonSchema.setModifyDate(date);
		lnpAppPersonSchema.setModifyTime(time);
		lnpAppAddressSchema.setCustomerId(lnpAppntSchema.getAppntId());
		lnpAppAddressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
		lnpAppAddressSchema.setOperator(tempGI.Operator);
		lnpAppAddressSchema.setMakeDate(date);
		lnpAppAddressSchema.setMakeTime(time);
		lnpAppAddressSchema.setModifyDate(date);
		lnpAppAddressSchema.setModifyTime(time);
		String lsAppAddressSQL = "";
		if (sugAppntNo != null && !"".equals(sugAppntNo))
			lsAppAddressSQL = (new StringBuilder("select homecountyaddr,homezipcode,homephone,grpcountyaddr,grpzipcode,grpphone,email,addrchoise from lslatncycustm where customerno='")).append(sugAppntNo).append("' ").toString();
		SSRS lsAppAddressSSRS = tExeSQL.execSQL(lsAppAddressSQL);
		if (lsAppAddressSSRS != null && lsAppAddressSSRS.MaxRow > 0)
		{
			if (lsAppAddressSSRS.GetText(1, 1) != null && !"".equals(lsAppAddressSSRS.GetText(1, 1)))
				lnpAppAddressSchema.setHomeAddress(lsAppAddressSSRS.GetText(1, 1));
			if (lsAppAddressSSRS.GetText(1, 2) != null && !"".equals(lsAppAddressSSRS.GetText(1, 2)))
				lnpAppAddressSchema.setHomeZipCode(lsAppAddressSSRS.GetText(1, 2));
			if (lsAppAddressSSRS.GetText(1, 3) != null && !"".equals(lsAppAddressSSRS.GetText(1, 3)))
				lnpAppAddressSchema.setHomePhone(lsAppAddressSSRS.GetText(1, 3));
			if (lsAppAddressSSRS.GetText(1, 4) != null && !"".equals(lsAppAddressSSRS.GetText(1, 4)))
				lnpAppAddressSchema.setCompanyAddress(lsAppAddressSSRS.GetText(1, 4));
			if (lsAppAddressSSRS.GetText(1, 5) != null && !"".equals(lsAppAddressSSRS.GetText(1, 5)))
				lnpAppAddressSchema.setCompanyZipCode(lsAppAddressSSRS.GetText(1, 5));
			if (lsAppAddressSSRS.GetText(1, 6) != null && !"".equals(lsAppAddressSSRS.GetText(1, 6)))
				lnpAppAddressSchema.setCompanyPhone(lsAppAddressSSRS.GetText(1, 6));
			if (lsAppAddressSSRS.GetText(1, 7) != null && !"".equals(lsAppAddressSSRS.GetText(1, 7)))
				lnpAppAddressSchema.setCompanyMail(lsAppAddressSSRS.GetText(1, 7));
			if (lsAppAddressSSRS.GetText(1, 8) != null && !"".equals(lsAppAddressSSRS.GetText(1, 8)))
			{
				String addrChoise = lsAppAddressSSRS.GetText(1, 8);
				if ("0".equals(addrChoise))
				{
					lnpAppAddressSchema.setPostalAddress(lnpAppAddressSchema.getHomeAddress() == null ? "" : lnpAppAddressSchema.getHomeAddress());
					lnpAppAddressSchema.setZipCode(lnpAppAddressSchema.getHomeZipCode() == null ? "" : lnpAppAddressSchema.getHomeZipCode());
					lnpAppAddressSchema.setPhone(lnpAppAddressSchema.getHomePhone() == null ? "" : lnpAppAddressSchema.getHomePhone());
				}
				if ("1".equals(addrChoise))
				{
					lnpAppAddressSchema.setPostalAddress(lnpAppAddressSchema.getCompanyAddress() == null ? "" : lnpAppAddressSchema.getCompanyAddress());
					lnpAppAddressSchema.setZipCode(lnpAppAddressSchema.getCompanyZipCode() == null ? "" : lnpAppAddressSchema.getCompanyZipCode());
					lnpAppAddressSchema.setPhone(lnpAppAddressSchema.getCompanyPhone() == null ? "" : lnpAppAddressSchema.getCompanyPhone());
				}
			}
		}
		lnpAppntSchema.setAddressNo(lnpAppAddressSchema.getAddressNo());
		lnpAppntSchema.setRelationToInsured(lnpInsuredSchema.getRelationToAppnt() == null ? "" : lnpInsuredSchema.getRelationToAppnt());
		lnpContSchema.setInsuredId(lnpInsuredSchema.getInsuredId());
		lnpContSchema.setInsuredName(lnpInsuredSchema.getName() == null ? "" : lnpInsuredSchema.getName());
		lnpContSchema.setInsuredSex(lnpInsuredSchema.getSex() == null ? "" : lnpInsuredSchema.getSex());
		lnpContSchema.setInsuredBirthday(lnpInsuredSchema.getBirthday() == null ? "" : lnpInsuredSchema.getBirthday());
		lnpContSchema.setInsuredIDType(lnpInsuredSchema.getIDType() == null ? "" : lnpInsuredSchema.getIDType());
		lnpContSchema.setInsuredIDNo(lnpInsuredSchema.getIDNo() == null ? "" : lnpInsuredSchema.getIDNo());
		lnpContSchema.setAppntId(lnpAppntSchema.getAppntId());
		lnpContSchema.setAppntName(lnpAppntSchema.getAppntName() == null ? "" : lnpAppntSchema.getAppntName());
		lnpContSchema.setAppntSex(lnpAppntSchema.getAppntSex() == null ? "" : lnpAppntSchema.getAppntSex());
		lnpContSchema.setAppntBirthday(lnpAppntSchema.getAppntBirthday() == null ? "" : lnpAppntSchema.getAppntBirthday());
		lnpContSchema.setAppntIDType(lnpAppntSchema.getIDType() == null ? "" : lnpAppntSchema.getIDType());
		lnpContSchema.setAppntIDNo(lnpAppntSchema.getIDNo() == null ? "" : lnpAppntSchema.getIDNo());
		System.out.println("4.?§Û????????");
		String lsMainPolSQL = (new StringBuilder("select riskcode from lspol where  polno = mainpolno and contno='")).append(sugNo).append("' ").toString();
		if (sugInsuredNo != null && !"".equals(sugInsuredNo))
			lsMainPolSQL = (new StringBuilder(String.valueOf(lsMainPolSQL))).append(" and insuredno='").append(sugInsuredNo).append("' ").toString();
		SSRS lsMainPolSSRS = tExeSQL.execSQL(lsMainPolSQL);
		if (lsMainPolSSRS != null && lsMainPolSSRS.MaxRow == 1)
		{
			String masterPolNo = "";
			if (lsMainPolSSRS.GetText(1, 1) != null && !"".equals(lsMainPolSSRS.GetText(1, 1)))
			{
				String riskCode = lsMainPolSSRS.GetText(1, 1);
				masterPolNo = getmasterPolNo(riskCode);
			}
			String lsPolSql = (new StringBuilder("select RiskCode,KindCode,RiskVersion,ManageCom,AgentCom,AgentType,AgentCode,AgentGroup,AgentCode1,SaleChnl,Handler,GetYear,PayEndYearFlag,PayEndYear,InsuYearFlag,InsuYear,AcciYearFlag,AcciYear,GetStartType,SpecifyValiDate,PayMode,PayLocation,PayIntv,PayYears,Years,ManageFeeRate,FloatRate,PremRate,PremToAmnt,Mult,StandPrem,Prem,SumPrem,Amnt,RiskAmnt,subflag,standbyflag3 from lspol where contno='")).append(sugNo).append("' ").toString();
			if (sugInsuredNo != null && !"".equals(sugInsuredNo))
				lsPolSql = (new StringBuilder(String.valueOf(lsPolSql))).append(" and insuredno='").append(sugInsuredNo).append("' ").toString();
			SSRS lsPolSSRS = tExeSQL.execSQL(lsPolSql);
			if (lsPolSSRS != null && lsPolSSRS.MaxRow > 0)
			{
				for (int i = 1; i <= lsPolSSRS.MaxRow; i++)
				{
					LNPPolSchema lnpPolSchema = new LNPPolSchema();
					lnpPolSchema.setGrpPolNo(LNPPubFun.getSysInfo("grpcontno"));
					lnpPolSchema.setContNo(contNo);
					lnpPolSchema.setProposalContNo(contNo);
					lnpPolSchema.setGrpContNo(lnpContSchema.getGrpContNo());
					lnpPolSchema.setPrtNo(lnpContSchema.getPrtNo());
					lnpPolSchema.setContType(lnpContSchema.getContType());
					lnpPolSchema.setPolTypeFlag(lnpContSchema.getPolType());
					lnpPolSchema.setOperator(tempGI.Operator);
					lnpPolSchema.setMakeDate(date);
					lnpPolSchema.setMakeTime(time);
					lnpPolSchema.setModifyDate(date);
					lnpPolSchema.setModifyTime(time);
					lnpPolSchema.setMasterPolNo(masterPolNo);
					lnpPolSchema.setInsuredId(lnpInsuredSchema.getInsuredId());
					if (lsPolSSRS.GetText(i, 1) != null)
					{
						String lsRiskCode = lsPolSSRS.GetText(i, 1);
						lnpPolSchema.setRiskCode(lsRiskCode);
						lnpPolSchema.setPolNo(getmasterPolNo(lsRiskCode));
						lnpPolSchema.setProposalNo(getmasterPolNo(lsRiskCode));
					}
					if (lsPolSSRS.GetText(i, 2) != null)
						lnpPolSchema.setKindCode(lsPolSSRS.GetText(i, 2));
					if (lsPolSSRS.GetText(i, 3) != null)
						lnpPolSchema.setRiskVersion(lsPolSSRS.GetText(i, 3));
					if (lsPolSSRS.GetText(i, 4) != null)
						lnpPolSchema.setManageCom(lsPolSSRS.GetText(i, 4));
					if (lsPolSSRS.GetText(i, 5) != null)
						lnpPolSchema.setAgentCom(lsPolSSRS.GetText(i, 5));
					if (lsPolSSRS.GetText(i, 6) != null)
						lnpPolSchema.setAgentType(lsPolSSRS.GetText(i, 6));
					if (lsPolSSRS.GetText(i, 7) != null)
						lnpPolSchema.setAgentCode(lsPolSSRS.GetText(i, 7));
					if (lsPolSSRS.GetText(i, 8) != null)
						lnpPolSchema.setAgentGroup(lsPolSSRS.GetText(i, 8));
					if (lsPolSSRS.GetText(i, 9) != null)
						lnpPolSchema.setAgentCode1(lsPolSSRS.GetText(i, 9));
					if (lsPolSSRS.GetText(i, 10) != null)
						lnpPolSchema.setSaleChnl(lsPolSSRS.GetText(i, 10));
					if (lsPolSSRS.GetText(i, 11) != null)
						lnpPolSchema.setHandler(lsPolSSRS.GetText(i, 11));
					if (lsPolSSRS.GetText(i, 12) != null)
						lnpPolSchema.setGetYear(lsPolSSRS.GetText(i, 12));
					if (lsPolSSRS.GetText(i, 13) != null)
						lnpPolSchema.setPayEndYearFlag(lsPolSSRS.GetText(i, 13));
					if (lsPolSSRS.GetText(i, 14) != null)
						lnpPolSchema.setPayEndYear(lsPolSSRS.GetText(i, 14));
					if (lsPolSSRS.GetText(i, 15) != null)
						lnpPolSchema.setInsuYearFlag(lsPolSSRS.GetText(i, 15));
					if (lsPolSSRS.GetText(i, 16) != null)
						lnpPolSchema.setInsuYear(lsPolSSRS.GetText(i, 16));
					if (lsPolSSRS.GetText(i, 17) != null)
						lnpPolSchema.setAcciYearFlag(lsPolSSRS.GetText(i, 17));
					if (lsPolSSRS.GetText(i, 18) != null)
						lnpPolSchema.setAcciYear(lsPolSSRS.GetText(i, 18));
					if (lsPolSSRS.GetText(i, 19) != null)
						lnpPolSchema.setGetStartType(lsPolSSRS.GetText(i, 19));
					if (lsPolSSRS.GetText(i, 20) != null)
						lnpPolSchema.setSpecifyValiDate(lsPolSSRS.GetText(i, 20));
					if (lsPolSSRS.GetText(i, 21) != null)
						lnpPolSchema.setPayMode(lsPolSSRS.GetText(i, 21));
					if (lsPolSSRS.GetText(i, 22) != null)
						lnpPolSchema.setPayLocation(lsPolSSRS.GetText(i, 22));
					if (lsPolSSRS.GetText(i, 23) != null)
						lnpPolSchema.setPayIntv(lsPolSSRS.GetText(i, 23));
					if (lsPolSSRS.GetText(i, 24) != null)
						lnpPolSchema.setPayYears(lsPolSSRS.GetText(i, 24));
					if (lsPolSSRS.GetText(i, 25) != null)
						lnpPolSchema.setYears(lsPolSSRS.GetText(i, 25));
					if (lsPolSSRS.GetText(i, 26) != null)
						lnpPolSchema.setManageFeeRate(lsPolSSRS.GetText(i, 26));
					if (lsPolSSRS.GetText(i, 27) != null)
						lnpPolSchema.setFloatRate(lsPolSSRS.GetText(i, 27));
					if (lsPolSSRS.GetText(i, 28) != null)
						lnpPolSchema.setPremRate(lsPolSSRS.GetText(i, 28));
					if (lsPolSSRS.GetText(i, 29) != null)
						lnpPolSchema.setPremToAmnt(lsPolSSRS.GetText(i, 29));
					if (lsPolSSRS.GetText(i, 30) != null)
						lnpPolSchema.setMult(lsPolSSRS.GetText(i, 30));
					lsPolSSRS.GetText(i, 31);
					if (lsPolSSRS.GetText(i, 32) != null)
						lnpPolSchema.setPrem(0.0D);
					else
						lnpPolSchema.setPrem(0.0D);
					lsPolSSRS.GetText(i, 33);
					if (lsPolSSRS.GetText(i, 34) != null)
						lnpPolSchema.setAmnt(lsPolSSRS.GetText(i, 34));
					if (lsPolSSRS.GetText(i, 35) != null)
						lnpPolSchema.setRiskAmnt(lsPolSSRS.GetText(i, 35));
					if (lsPolSSRS.GetText(i, 36) != null)
						lnpPolSchema.setSubFlag(lsPolSSRS.GetText(i, 36));
					if (lsPolSSRS.GetText(i, 37) != null)
						lnpPolSchema.setStandbyFlag3(lsPolSSRS.GetText(i, 37));
					lnpPolSchema.setAppFlag("0");
					lnpPolSchema.setPolState("0");
					lnpPolSet.add(lnpPolSchema);
				}

			}
		}
		System.out.println("5.?????????????......");
		map.put(lnpContSchema, "INSERT");
		map.put(lnpInsuredSchema, "INSERT");
		map.put(lnpInsPersonSchema, "INSERT");
		map.put(lnpInsAddressSchema, "INSERT");
		map.put(lnpAppntSchema, "INSERT");
		map.put(lnpAppPersonSchema, "INSERT");
		map.put(lnpAppAddressSchema, "INSERT");
		map.put(lnpPolSet, "INSERT");
		vd.add(map);
		if (!ps.submitData(vd, ""))
		{
			System.out.println("---SuggestToInsurance---??????????");
			alertFlag = true;
			message = " ???????????÷g?????";
		}
		System.out.println("---doSuggestToInsurance End---");
	}

	private String getmasterPolNo(String riskCode)
	{
		String masterPolno = "";
		ExeSQL tExeSQL = new ExeSQL();
		String sqlDB = (new StringBuilder("select sysriskcode from LNPRiskCode where riskcode = '")).append(riskCode).append("'").toString();
		SSRS tSRS = tExeSQL.execSQL(sqlDB);
		if (tSRS != null && tSRS.MaxRow > 0 && tSRS.GetText(1, 1) != null && !"".equals(tSRS.GetText(1, 1)))
			masterPolno = (new StringBuilder(String.valueOf(contNo))).append(tSRS.GetText(1, 1)).toString();
		return masterPolno;
	}

	private boolean preDOValidateVar()
	{
		if (contNo == null || "" == contNo)
			return false;
		if (sugNo == null || "" == sugNo)
		{
			alertFlag = true;
			message = " ???????????÷g????????????????????????? ";
			return false;
		} else
		{
			return true;
		}
	}

	private String getSugInsuredNoFromDB(String no)
	{
		String ino = "";
		ExeSQL tempExeSQL = new ExeSQL();
		String tempSql = (new StringBuilder("select distinct insuredno from lsinsured where contno = '")).append(no).append("' ").toString();
		SSRS tSRS = new SSRS();
		tSRS = tempExeSQL.execSQL(tempSql);
		if (tSRS.MaxRow > 0 && tSRS.GetText(1, 1) != null)
			ino = tSRS.GetText(1, 1);
		return ino;
	}

	private String getSugAppntNoFromDB(String no)
	{
		String ano = "";
		ExeSQL tempExeSQL = new ExeSQL();
		String tempSql = (new StringBuilder("select distinct appntno from lsappnt where contno = '")).append(no).append("' ").toString();
		SSRS tSRS = new SSRS();
		tSRS = tempExeSQL.execSQL(tempSql);
		if (tSRS.MaxRow > 0 && tSRS.GetText(1, 1) != null)
			ano = tSRS.GetText(1, 1);
		return ano;
	}

	public String getOutcode(String changetype, String source, String incode)
	{
		String outcode = "";
		ExeSQL outcodeExeSQL = new ExeSQL();
		String outcodeExeSQLSql = (new StringBuilder("select outcode from lnpoutcodemap where changetype = '")).append(changetype).append("' and source='").append(source).append("' and incode='").append(incode).append("' ").toString();
		SSRS tSRS = new SSRS();
		tSRS = outcodeExeSQL.execSQL(outcodeExeSQLSql);
		if (tSRS.MaxRow > 0 && tSRS.GetText(1, 1) != null)
			outcode = tSRS.GetText(1, 1);
		return outcode;
	}

	private String getManageCom(String cno)
	{
		String com = "";
		ExeSQL tExeSql = new ExeSQL();
		String preSql = (new StringBuilder("select t.comcode,t.name,t.validcode from lnpcom t where t.validcode = '")).append(cno.toUpperCase().substring(0, 2)).append("'").toString();
		SSRS tSSRSfromCom = tExeSql.execSQL(preSql);
		if (tSSRSfromCom != null && tSSRSfromCom.MaxRow > 0)
			com = tSSRSfromCom.GetText(1, 1);
		return com;
	}

	private String countPValidate(String pSigndateString)
	{
		FDate fDate = new FDate();
		Date pValiDate = fDate.getDate(pSigndateString);
		long tempt = pValiDate.getTime() + 0x5265c00L;
		Date nDate = new Date(tempt);
		return fDate.getString(nDate);
	}

	public void checkContNo()
	{
		alertFlag = true;
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
		String sql = (new StringBuilder("select 1 where '")).append(checkedContNo.toUpperCase().substring(0, 2)).append("' in (select distinct validcode from lnpcom where comcode like '").append(tempGI.ManageCom).append("%' and comcode<>'86')").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0 && tSSRS.GetText(1, 1).equals("1"))
			alertFlag = false;
		if (!"86".equals(getSugManageCom()))
			if (getSugManageCom().equals(getManageCom(checkedContNo)))
				alertFlag = false;
			else
				alertFlag = true;
		if (alertFlag)
		{
			contNo = "";
			message = " ????§Õ????????????????";
			return;
		}
		if (!Pattern.matches("^[0-9]{10}", checkedContNo.substring(2)))
		{
			contNo = "";
			message = " ??????????\274??????????";
			alertFlag = true;
			return;
		}
		String newContNo = getCheckedContNo().toUpperCase();
		contNo = newContNo;
		alertFlag = false;
		if (!alertFlag)
			checkContNoExist();
	}

	public void checkContNoExist()
	{
		String tempContNo = getCheckedContNo();
		alertFlag = false;
		if (getContByContNo(tempContNo) != null || checkContNoExistInTB(tempContNo))
		{
			alertFlag = true;
			contNo = "";
			message = "?????????????????????";
		} else
		{
			alertFlag = false;
		}
	}

	public LNPContSchema getContByContNo(String contNo)
	{
		LNPContDB db = new LNPContDB();
		db.setContNo(contNo);
		if (db.getInfo())
			return db.getSchema();
		else
			return null;
	}

	public boolean checkContNoExistInTB(String checkcontno)
	{
		boolean flag = false;
		String sql = (new StringBuilder("select 1 from tb_application where cd_preprinted_application ='")).append(checkcontno).append("';").toString();
		ExeSQL tExESQL = new ExeSQL();
		SSRS tSSRS = tExESQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
			flag = true;
		return flag;
	}

	public List getComCodeListWithSql(String sql)
	{
		List list = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		String comSQL = sql;
		SSRS tSSRS = tExeSQL.execSQL(comSQL);
		for (int i = 1; i <= tSSRS.MaxRow; i++)
			list.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));

		return list;
	}

	public boolean isCheckRiskFlag()
	{
		return checkRiskFlag;
	}

	public void setCheckRiskFlag(boolean checkRiskFlag)
	{
		this.checkRiskFlag = checkRiskFlag;
	}

	public void checkRiskcodeFun()
	{
		checkRiskFlag = false;
		String tmpcheckRiskcode = checkRiskcode.replaceAll(",", "','");
		String sql = (new StringBuilder("select * from lnprisk a ,LNPRiskComCtrl b where a.riskcode =b.riskcode and  b.salechnl='")).append(tempGI.BranchType).append("' ").append("and a.riskcode in('").append(tmpcheckRiskcode).append("')").toString();
		ExeSQL tExESQL = new ExeSQL();
		SSRS tSSRS = tExESQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
			checkRiskFlag = true;
	}

	public List getComCodeList()
	{
		return comCodeList;
	}

	public void setComCodeList(List comCodeList)
	{
		this.comCodeList = comCodeList;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public LNPSuggestToInsuranceBean getStiBean()
	{
		return stiBean;
	}

	public void setStiBean(LNPSuggestToInsuranceBean stiBean)
	{
		this.stiBean = stiBean;
	}

	public List getStiBeanList()
	{
		return stiBeanList;
	}

	public void setStiBeanList(List stiBeanList)
	{
		this.stiBeanList = stiBeanList;
	}

	public String getStartDate()
	{
		return startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public IGlobalInput getTempGI()
	{
		return tempGI;
	}

	public void setTempGI(IGlobalInput tempGI)
	{
		this.tempGI = tempGI;
	}

	public boolean isAlertFlag()
	{
		return alertFlag;
	}

	public void setAlertFlag(boolean alertFlag)
	{
		this.alertFlag = alertFlag;
	}

	public boolean isShowErrorFlag()
	{
		return showErrorFlag;
	}

	public void setShowErrorFlag(boolean showErrorFlag)
	{
		this.showErrorFlag = showErrorFlag;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
	}

	public String getCheckedContNo()
	{
		return checkedContNo;
	}

	public void setCheckedContNo(String checkedContNo)
	{
		this.checkedContNo = checkedContNo;
	}

	public String getSugNo()
	{
		return sugNo;
	}

	public void setSugNo(String sugNo)
	{
		this.sugNo = sugNo;
	}

	public String getSugInsuredNo()
	{
		return sugInsuredNo;
	}

	public void setSugInsuredNo(String sugInsuredNo)
	{
		this.sugInsuredNo = sugInsuredNo;
	}

	public String getSugAppntNo()
	{
		return sugAppntNo;
	}

	public void setSugAppntNo(String sugAppntNo)
	{
		this.sugAppntNo = sugAppntNo;
	}

	public String getSugManageCom()
	{
		return sugManageCom;
	}

	public void setSugManageCom(String sugManageCom)
	{
		this.sugManageCom = sugManageCom;
	}
}
