// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   InsuredPersonInfo.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
import com.sinosoft.banklns.lis.vschema.LNPUWQuestionSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			PolicyMainInfo, PersonFunction, StateOperatorDeal

public class InsuredPersonInfo
{

	private boolean editFlag;
	private boolean operateResult;
	private boolean hasPolTag;
	private IGlobalInput tempGI;
	private LNPContSchema contSch;
	private String message;
	private String infoSource;
	private String contNo;
	private LNPInsuredSchema insuredSchema;
	private LNPPersonSchema lnpPersonSchema;
	private LNPAddressSchema lnpAddressSchema;
	private String insuredId;
	private String name;
	private String birthday;
	private String IDNo;
	private String IDValidity;
	private String occupationName;
	private String occupationCode;
	private String partOccupationName;
	private String partOccupationCode;
	private String nameHidden;
	private String birthdayHidden;
	private String sexHidden;
	private String occupationCodeHidden;
	private String insuNativeHidden;
	private String postalAddress;
	private String phone;
	private String zipCode;
	private String grpName;
	private String companyMail;
	private String companyAddress;
	private String companyPhone;
	private String companyZipCode;
	private String homeAddress;
	private String homePhone;
	private String homeZipCode;
	private String age;
	private String insuCity;
	private String insuOtherCity;
	private String sex;
	private String marriage;
	private String insuNative;
	private String idType;
	private String signCityFirst;
	private String idPerpetual;
	private List signCityList;
	private String operType;
	private String manageCom;
	private String pvalidate;
	private String reAge;

	public InsuredPersonInfo()
	{
		operateResult = true;
		hasPolTag = false;
		insuredSchema = new LNPInsuredSchema();
		lnpPersonSchema = new LNPPersonSchema();
		lnpAddressSchema = new LNPAddressSchema();
		nameHidden = null;
		birthdayHidden = null;
		sexHidden = null;
		occupationCodeHidden = null;
		insuNativeHidden = null;
		age = "";
		insuCity = "";
		insuOtherCity = "";
		signCityList = new ArrayList();
	}

	public String getPvalidate()
	{
		if (contSch != null)
			return contSch.getPValiDate();
		else
			return pvalidate;
	}

	public void setPvalidate(String pvalidate)
	{
		this.pvalidate = pvalidate;
	}

	public void initData()
	{
		try
		{
			operateResult = true;
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			tempGI = (IGlobalInput)session.getValue("NPGI");
			insuredSchema = new LNPInsuredSchema();
			lnpPersonSchema = new LNPPersonSchema();
			lnpAddressSchema = new LNPAddressSchema();
			postalAddress = "";
			phone = "";
			zipCode = "";
			grpName = "";
			companyMail = "";
			companyAddress = "";
			companyPhone = "";
			companyZipCode = "";
			homeAddress = "";
			homePhone = "";
			homeZipCode = "";
			insuredId = "";
			name = "";
			birthday = "";
			IDNo = "";
			IDValidity = "";
			occupationName = "";
			occupationCode = "";
			partOccupationName = "";
			partOccupationCode = "";
			insuCity = "";
			sex = null;
			age = "";
			marriage = null;
			idType = "1";
			insuNative = "";
			signCityFirst = "";
			idPerpetual = "0";
			operType = tempGI.OperType;
			manageCom = tempGI.ManageCom;
			Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
			if ((String)session.getAttribute("ContNo") != null && !((String)session.getAttribute("ContNo")).equals(""))
			{
				contNo = (String)session.getAttribute("ContNo");
				signCityList = doSignCityListValue();
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				contSch = mainInfo.getContByContNo(contNo);
				if (contSch != null && contSch.getInsuredId() != null && !contSch.getInsuredId().equals(""))
				{
					String myInsuredId = contSch.getInsuredId();
					PersonFunction pf = new PersonFunction();
					insuredSchema = getOneInsuredPersonInfo(contNo, myInsuredId);
					lnpPersonSchema = pf.getLnpPersonByCustomerId(myInsuredId);
					lnpAddressSchema = pf.getLnpAddrByCustomerId(myInsuredId);
					insuredId = myInsuredId;
					name = insuredSchema.getName();
					birthday = insuredSchema.getBirthday();
					IDNo = insuredSchema.getIDNo();
					IDValidity = insuredSchema.getIDValidity();
					occupationName = getOccupName(insuredSchema.getOccupationCode());
					occupationCode = insuredSchema.getOccupationCode();
					partOccupationName = getOccupName(insuredSchema.getPartOccupationCode());
					partOccupationCode = insuredSchema.getPartOccupationCode();
					postalAddress = lnpAddressSchema.getPostalAddress();
					phone = lnpAddressSchema.getPhone();
					zipCode = lnpAddressSchema.getZipCode();
					grpName = lnpAddressSchema.getGrpName();
					companyMail = lnpAddressSchema.getCompanyMail();
					companyAddress = lnpAddressSchema.getCompanyAddress();
					companyPhone = lnpAddressSchema.getCompanyPhone();
					companyZipCode = lnpAddressSchema.getCompanyZipCode();
					homeAddress = lnpAddressSchema.getHomeAddress();
					homePhone = lnpAddressSchema.getHomePhone();
					homeZipCode = lnpAddressSchema.getHomeZipCode();
					sex = insuredSchema.getSex();
					marriage = insuredSchema.getMarriage();
					idType = insuredSchema.getIDType();
					insuNative = insuredSchema.getNativePlace();
					idPerpetual = insuredSchema.getIDPerpetual();
					signCityFirst = insuredSchema.getSignCity();
					if (insuredSchema.getBirthday() != null && !"".equals(insuredSchema.getBirthday()))
						age = LNPPubFun.getAgeByBirthdayNew(insuredSchema.getBirthday(), contSch.getPValiDate());
					insuCity = lnpAddressSchema.getDuchy();
					insuOtherCity = lnpAddressSchema.getOtherDuchy();
					nameHidden = name;
					sexHidden = sex;
					birthdayHidden = birthday;
					occupationCodeHidden = occupationCode;
					insuNativeHidden = insuNative;
					String editState_Pol = contSch.getEditstate().substring(3, 4);
					if ("1".equals(editState_Pol))
						hasPolTag = true;
					else
					if ("0".equals(editState_Pol))
						hasPolTag = false;
					infoSource = "modify";
				} else
				{
					infoSource = "add";
				}
			} else
			{
				getEditFlag = Boolean.valueOf(false);
			}
			if (getEditFlag != null && !getEditFlag.booleanValue())
			{
				infoSource = "undo";
				editFlag = false;
			} else
			{
				editFlag = true;
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			message = "??????????????";
			operateResult = false;
		}
	}

	private String getOccupName(String occcode)
	{
		String reName = "";
		if (occcode != null)
		{
			LNPOccupationDB occDB = new LNPOccupationDB();
			occDB.setOccupationCode(occcode);
			if (occDB.getInfo())
				reName = occDB.getOccupationName();
		}
		return reName;
	}

	public void saveOccupMenuNO()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("occupationName", "");
		session.setAttribute("occupationCode", "");
	}

	public void cancleOccupSession()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String occupationName = (String)session.getAttribute("occupationName");
		String occupationCode = (String)session.getAttribute("occupationCode");
		if (occupationName != null && !occupationName.equals(""))
			this.occupationName = occupationName;
		else
			this.occupationName = "";
		if (occupationCode != null && !occupationCode.equals(""))
			this.occupationCode = occupationCode;
		else
			this.occupationCode = "";
		session.removeAttribute("occupationName");
		session.removeAttribute("occupationCode");
	}

	public void reWriteOccupation()
	{
		String sql = (new StringBuilder("select occupationcode,occupationname from lnpoccupation where occupationcode='")).append(occupationCode).append("';").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS.MaxRow > 0)
		{
			operateResult = false;
			occupationCode = tSSRS.GetText(1, 1);
			occupationName = tSSRS.GetText(1, 2);
		} else
		{
			operateResult = true;
			occupationCode = "";
			occupationName = "";
			message = "?????????????";
		}
	}

	public void reWriteOccupationPart()
	{
		String sql = (new StringBuilder("select occupationcode,occupationname from lnpoccupation where occupationcode='")).append(partOccupationCode).append("';").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS.MaxRow > 0)
		{
			operateResult = false;
			partOccupationCode = tSSRS.GetText(1, 1);
			partOccupationName = tSSRS.GetText(1, 2);
		} else
		{
			operateResult = true;
			partOccupationCode = "";
			partOccupationName = "";
			message = "?\374?????????????";
		}
	}

	public void canclePartOccupSession()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String occupationName = (String)session.getAttribute("occupationName");
		String occupationCode = (String)session.getAttribute("occupationCode");
		if (occupationName != null && !occupationName.equals(""))
			partOccupationName = occupationName;
		else
			partOccupationName = "";
		if (occupationCode != null && !occupationCode.equals(""))
			partOccupationCode = occupationCode;
		else
			partOccupationCode = "";
		session.removeAttribute("occupationName");
		session.removeAttribute("occupationCode");
	}

	public void saveInusPeople()
	{
		message = null;
		operateResult = true;
		if (infoSource.equals("undo") || contSch == null)
		{
			message = "?????????????";
			operateResult = true;
			return;
		}
		lnpAddressSchema.setPostalAddress(postalAddress);
		lnpAddressSchema.setPhone(phone);
		lnpAddressSchema.setZipCode(zipCode);
		lnpAddressSchema.setGrpName(grpName);
		lnpAddressSchema.setCompanyMail(companyMail);
		lnpAddressSchema.setCompanyAddress(companyAddress);
		lnpAddressSchema.setCompanyPhone(companyPhone);
		lnpAddressSchema.setCompanyZipCode(companyZipCode);
		lnpAddressSchema.setHomeAddress(homeAddress);
		lnpAddressSchema.setHomePhone(homePhone);
		lnpAddressSchema.setHomeZipCode(homeZipCode);
		insuredSchema.setName(name);
		insuredSchema.setBirthday(birthday);
		insuredSchema.setIDNo(IDNo);
		insuredSchema.setIDValidity(IDValidity);
		insuredSchema.setOccupationCode(occupationCode);
		insuredSchema.setPartOccupationCode(partOccupationCode);
		insuredSchema.setNativePlace(getInsuNative());
		insuredSchema.setSex(getSex());
		insuredSchema.setMarriage(getMarriage());
		insuredSchema.setIDType(getIdType());
		insuredSchema.setIDPerpetual(getIdPerpetual());
		if (insuredSchema.getIDValidity() != null)
			insuredSchema.setIDValidity(insuredSchema.getIDValidity());
		else
			insuredSchema.setIDValidity("");
		String agePer = "";
		String ageType = "";
		agePer = LNPPubFun.getAgeByBirthdayNew(insuredSchema.getBirthday(), contSch.getPValiDate());
		age = agePer;
		if (agePer.indexOf("??") > -1)
		{
			ageType = "D";
			agePer = agePer.substring(0, agePer.indexOf("??"));
		} else
		{
			ageType = "Y";
			agePer = agePer.substring(0, agePer.indexOf("??"));
		}
		insuredSchema.setAppAge(agePer);
		insuredSchema.setAppAgeType(ageType);
		insuredSchema.setSignCity(signCityFirst);
		if (!validate())
		{
			operateResult = false;
			return;
		}
		try
		{
			if (infoSource.equals("add"))
			{
				if (checkInsuredExist(contSch.getContNo()))
				{
					if (modifyInusPeople())
					{
						message = "?????????????????";
						operateResult = true;
					}
				} else
				if (addInusByNewCustomer())
				{
					message = "?????????????????";
					operateResult = true;
				}
			} else
			if (infoSource.equals("modify") && modifyInusPeople())
			{
				message = "?????????????????";
				operateResult = true;
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			message = "?????????????????";
			operateResult = false;
		}
		return;
	}

	public LNPInsuredSchema getInsuPeopleByContNo(String contNo, String aInsuredId)
	{
		LNPInsuredDB lnpInsuredDB = new LNPInsuredDB();
		lnpInsuredDB.setContNo(contNo);
		lnpInsuredDB.setInsuredId(aInsuredId);
		if (lnpInsuredDB.getInfo())
			return lnpInsuredDB.getSchema();
		else
			return null;
	}

	public List getInsuPeopleListByContNo(String aContNo)
	{
		LNPInsuredDB lnpInsuredDB = new LNPInsuredDB();
		lnpInsuredDB.setContNo(aContNo);
		LNPInsuredSet lnpInsuredSet = lnpInsuredDB.query();
		List list = new ArrayList();
		if (lnpInsuredSet.size() > 0)
		{
			list = new ArrayList();
			for (int i = 1; i <= lnpInsuredSet.size(); i++)
			{
				LNPInsuredSchema temp = lnpInsuredSet.get(i);
				list.add(temp);
			}

		}
		return list;
	}

	public LNPInsuredSchema getOneInsuredPersonInfo(String contNo, String insuredId)
	{
		LNPInsuredDB saveLSInsuredDB = new LNPInsuredDB();
		saveLSInsuredDB.setContNo(contNo);
		saveLSInsuredDB.setInsuredId(insuredId);
		if (saveLSInsuredDB.getInfo())
			return saveLSInsuredDB.getSchema();
		else
			return null;
	}

	private boolean addInusByNewCustomer()
	{
		boolean flag = false;
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		insuredSchema.setInsuredId(maxNoMap.CreateMaxNo("CustomerNo", ""));
		LNPContSchema lnpContSch = getMyLNPContByContNo(contNo);
		insuredSchema.setGrpContNo(lnpContSch.getGrpContNo());
		insuredSchema.setPrtNo(lnpContSch.getPrtNo());
		insuredSchema.setContNo(lnpContSch.getContNo());
		insuredSchema.setProposalContNo(lnpContSch.getProposalContNo());
		insuredSchema.setOperator(tempGI.Operator);
		insuredSchema.setMakeDate(date);
		insuredSchema.setMakeTime(time);
		insuredSchema.setModifyDate(date);
		insuredSchema.setModifyTime(time);
		lnpPersonSchema.setAgentCode(insuredSchema.getOperator());
		lnpPersonSchema.setCustomerId(insuredSchema.getInsuredId());
		lnpPersonSchema.setName(insuredSchema.getName());
		lnpPersonSchema.setSex(insuredSchema.getSex());
		lnpPersonSchema.setBirthday(insuredSchema.getBirthday());
		lnpPersonSchema.setIDType(insuredSchema.getIDType());
		lnpPersonSchema.setIDNo(insuredSchema.getIDNo());
		lnpPersonSchema.setNativePlace(insuredSchema.getNativePlace());
		lnpPersonSchema.setMarriage(insuredSchema.getMarriage());
		lnpPersonSchema.setOccupationCode(insuredSchema.getOccupationCode());
		lnpPersonSchema.setPartOccupationCode(insuredSchema.getPartOccupationCode());
		lnpPersonSchema.setAge(insuredSchema.getAppAge());
		lnpPersonSchema.setIDPerpetual(insuredSchema.getIDPerpetual());
		lnpPersonSchema.setIDValidity(insuredSchema.getIDValidity());
		lnpPersonSchema.setOperator(tempGI.Operator);
		lnpPersonSchema.setMakeDate(date);
		lnpPersonSchema.setMakeTime(time);
		lnpPersonSchema.setModifyDate(date);
		lnpPersonSchema.setModifyTime(time);
		lnpAddressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
		lnpAddressSchema.setDuchy(getInsuCity());
		lnpAddressSchema.setOtherDuchy(getInsuOtherCity() == null ? "" : getInsuOtherCity());
		lnpAddressSchema.setCustomerId(insuredSchema.getInsuredId());
		lnpAddressSchema.setOperator(tempGI.Operator);
		lnpAddressSchema.setMakeDate(date);
		lnpAddressSchema.setMakeTime(time);
		lnpAddressSchema.setModifyDate(date);
		lnpAddressSchema.setModifyTime(time);
		insuredSchema.setAddressNo(lnpAddressSchema.getAddressNo());
		lnpContSch.setInsuredId(insuredSchema.getInsuredId());
		lnpContSch.setInsuredNo(insuredSchema.getInsuredNo());
		lnpContSch.setInsuredName(insuredSchema.getName());
		lnpContSch.setInsuredBirthday(insuredSchema.getBirthday());
		lnpContSch.setInsuredIDType(insuredSchema.getIDType());
		lnpContSch.setInsuredIDNo(insuredSchema.getIDNo());
		lnpContSch.setInsuredSex(insuredSchema.getSex());
		StateOperatorDeal operatorDeal = new StateOperatorDeal();
		List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), infoSource, "02");
		lnpContSch.setState((String)stateList.get(0));
		lnpContSch.setEditstate((String)stateList.get(1));
		if ("2".equals(lnpContSch.getUWFlag()))
			lnpContSch.setUWFlag("1");
		lnpContSch.setModifyDate(date);
		lnpContSch.setModifyTime(time);
		PubSubmit ps = new PubSubmit();
		MMap map = new MMap();
		map.put(insuredSchema, "INSERT");
		map.put(lnpPersonSchema, "INSERT");
		map.put(lnpAddressSchema, "INSERT");
		map.put(lnpContSch, "UPDATE");
		VData vd = new VData();
		vd.add(map);
		if (!ps.submitData(vd, ""))
		{
			message = "????????????????";
			flag = false;
		} else
		{
			flag = true;
			operatorDeal.afterAddInsurance(contSch.getContNo());
		}
		return flag;
	}

	private boolean checkInsuredExist(String contno)
	{
		LNPInsuredDB saveLSInsuredDB = new LNPInsuredDB();
		String searchsql = (new StringBuilder("select * from lnpinsured where contno ='")).append(contno).append("'").toString();
		LNPInsuredSet reSet = saveLSInsuredDB.executeQuery(searchsql);
		return reSet != null && reSet.size() > 0;
	}

	private LNPContSchema getMyLNPContByContNo(String contNo2)
	{
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contNo2);
		return aLNPContSchema;
	}

	private boolean modifyInusPeople()
	{
		boolean flag;
		try
		{
			flag = false;
			String date = PubFun.getCurrentDate();
			String time = PubFun.getCurrentTime();
			String midifyContNo = insuredSchema.getContNo();
			String midifyInsuredId = insuredSchema.getInsuredId();
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			PersonFunction pf = new PersonFunction();
			LNPInsuredSchema modifyInsuPeopleSchema = getInsuPeopleByContNo(midifyContNo, midifyInsuredId);
			LNPInsuredSchema tempmodifyInsuPeopleSchema = getInsuPeopleByContNo(midifyContNo, midifyInsuredId);
			LNPAddressSchema modifylnpAddressSchema = pf.getLnpAddrByCustomerId(midifyInsuredId);
			LNPPersonSchema modifylnpPersonSchema = pf.getLnpPersonByCustomerId(midifyInsuredId);
			LNPContSchema lnpContSch = getMyLNPContByContNo(midifyContNo);
			if (modifyInsuPeopleSchema != null && modifylnpAddressSchema != null && modifylnpPersonSchema != null)
			{
				System.out.println((new StringBuilder("-- modifylnpAddressSchema--")).append(modifylnpAddressSchema.getAddressNo()).toString());
				modifyInsuPeopleSchema.setSignCity(insuredSchema.getSignCity());
				modifyInsuPeopleSchema.setName(insuredSchema.getName());
				modifyInsuPeopleSchema.setSex(insuredSchema.getSex());
				modifyInsuPeopleSchema.setBirthday(insuredSchema.getBirthday());
				modifyInsuPeopleSchema.setAppAge(insuredSchema.getAppAge());
				modifyInsuPeopleSchema.setAppAgeType(insuredSchema.getAppAgeType());
				modifyInsuPeopleSchema.setIDValidity(insuredSchema.getIDValidity());
				modifyInsuPeopleSchema.setIDPerpetual(insuredSchema.getIDPerpetual());
				modifyInsuPeopleSchema.setIDType(insuredSchema.getIDType());
				modifyInsuPeopleSchema.setIDNo(insuredSchema.getIDNo());
				modifyInsuPeopleSchema.setNativePlace(insuredSchema.getNativePlace());
				modifyInsuPeopleSchema.setMarriage(insuredSchema.getMarriage());
				modifyInsuPeopleSchema.setOccupationCode(insuredSchema.getOccupationCode());
				modifyInsuPeopleSchema.setPartOccupationCode(insuredSchema.getPartOccupationCode());
				modifyInsuPeopleSchema.setModifyDate(date);
				modifyInsuPeopleSchema.setModifyTime(time);
				modifylnpPersonSchema.setName(modifyInsuPeopleSchema.getName());
				modifylnpPersonSchema.setSex(modifyInsuPeopleSchema.getSex());
				modifylnpPersonSchema.setBirthday(modifyInsuPeopleSchema.getBirthday());
				modifylnpPersonSchema.setIDType(modifyInsuPeopleSchema.getIDType());
				modifylnpPersonSchema.setIDNo(modifyInsuPeopleSchema.getIDNo());
				modifylnpPersonSchema.setNativePlace(modifyInsuPeopleSchema.getNativePlace());
				modifylnpPersonSchema.setMarriage(modifyInsuPeopleSchema.getMarriage());
				modifylnpPersonSchema.setOccupationCode(modifyInsuPeopleSchema.getOccupationCode());
				modifylnpPersonSchema.setAge(modifyInsuPeopleSchema.getAppAge());
				modifylnpPersonSchema.setPartOccupationCode(modifyInsuPeopleSchema.getPartOccupationCode());
				modifylnpPersonSchema.setAgeType(modifyInsuPeopleSchema.getAppAgeType());
				modifylnpPersonSchema.setIDPerpetual(modifyInsuPeopleSchema.getIDPerpetual());
				modifylnpPersonSchema.setIDValidity(modifyInsuPeopleSchema.getIDValidity());
				modifylnpPersonSchema.setModifyDate(date);
				modifylnpPersonSchema.setModifyTime(time);
				modifylnpAddressSchema.setGrpName(lnpAddressSchema.getGrpName());
				modifylnpAddressSchema.setPostalAddress(lnpAddressSchema.getPostalAddress());
				modifylnpAddressSchema.setZipCode(lnpAddressSchema.getZipCode());
				modifylnpAddressSchema.setPhone(lnpAddressSchema.getPhone());
				modifylnpAddressSchema.setHomeAddress(lnpAddressSchema.getHomeAddress());
				modifylnpAddressSchema.setHomeZipCode(lnpAddressSchema.getHomeZipCode());
				modifylnpAddressSchema.setHomePhone(lnpAddressSchema.getHomePhone());
				modifylnpAddressSchema.setCompanyAddress(lnpAddressSchema.getCompanyAddress());
				modifylnpAddressSchema.setCompanyPhone(lnpAddressSchema.getCompanyPhone());
				modifylnpAddressSchema.setCompanyMail(lnpAddressSchema.getCompanyMail());
				modifylnpAddressSchema.setCompanyZipCode(lnpAddressSchema.getCompanyZipCode());
				modifylnpAddressSchema.setDuchy(getInsuCity());
				modifylnpAddressSchema.setOtherDuchy(getInsuOtherCity() == null ? "" : getInsuOtherCity());
				modifylnpAddressSchema.setModifyDate(date);
				modifylnpAddressSchema.setModifyTime(time);
				lnpContSch.setInsuredId(insuredSchema.getInsuredId());
				lnpContSch.setInsuredNo(insuredSchema.getInsuredNo());
				lnpContSch.setInsuredName(insuredSchema.getName());
				lnpContSch.setInsuredBirthday(insuredSchema.getBirthday());
				lnpContSch.setInsuredIDType(insuredSchema.getIDType());
				lnpContSch.setInsuredIDNo(insuredSchema.getIDNo());
				lnpContSch.setInsuredSex(insuredSchema.getSex());
				StateOperatorDeal operatorDeal = new StateOperatorDeal();
				List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), infoSource, "02");
				lnpContSch.setState((String)stateList.get(0));
				lnpContSch.setEditstate((String)stateList.get(1));
				if ("2".equals(lnpContSch.getUWFlag()))
					lnpContSch.setUWFlag("1");
				lnpContSch.setModifyDate(date);
				lnpContSch.setModifyTime(time);
				map.put(modifyInsuPeopleSchema, "UPDATE");
				map.put(modifylnpPersonSchema, "UPDATE");
				map.put(modifylnpAddressSchema, "UPDATE");
				map.put(lnpContSch, "UPDATE");
			} else
			{
				message = "??????¦Ä????????????????";
			}
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "????????????????";
				flag = false;
			} else
			{
				flag = true;
				boolean mflag = afterupdateInsured(contNo);
				StateOperatorDeal operatorDeal = new StateOperatorDeal();
				boolean checkSpelFlag = checkSpelKeyChange(tempmodifyInsuPeopleSchema, insuredSchema.getName(), insuredSchema.getSex(), insuredSchema.getBirthday(), insuredSchema.getOccupationCode(), insuredSchema.getAppAge(), insuredSchema.getAppAgeType(), insuredSchema.getNativePlace());
				boolean ageChangeToJuvenilesFlag = checkAgeChangeToJuveniles(tempmodifyInsuPeopleSchema, insuredSchema.getAppAge(), insuredSchema.getAppAgeType());
				boolean flag1 = operatorDeal.afterModifyInsurance(lnpContSch.getContNo(), checkSpelFlag, ageChangeToJuvenilesFlag);
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			message = "????????????????";
			flag = false;
		}
		return flag;
	}

	private boolean afterupdateInsured(String contno)
	{
		System.out.println("-----?§Ò??? ?????????? ???????????????? ----");
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

	private boolean checkAgeChangeToJuveniles(LNPInsuredSchema tempmodifyInsuPeopleSchema, int appAge, String appAgeType)
	{
		boolean flag = false;
		String relationToInsured = "";
		String sql = (new StringBuilder("select relationtoinsured from lnpappnt where contno='")).append(tempmodifyInsuPeopleSchema.getContNo()).append("'").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.getMaxRow() > 0)
			relationToInsured = tSSRS.GetText(1, 1);
		else
			return flag;
		if ("D".equals(tempmodifyInsuPeopleSchema.getAppAgeType()))
			flag = false;
		if ("Y".equals(tempmodifyInsuPeopleSchema.getAppAgeType()) && tempmodifyInsuPeopleSchema.getAppAge() >= 16 && ("D".equals(appAgeType) || "Y".equals(appAgeType) && appAge < 16) && "0".equals(relationToInsured))
			flag = true;
		return flag;
	}

	private boolean checkSpelKeyChange(LNPInsuredSchema modifyInsuPeopleSchema, String name, String sex2, String birthday, String occupationCode2, int age, String ageType, 
			String navition)
	{
		boolean ageflag = checkAgeChange(age, ageType, modifyInsuPeopleSchema.getAppAge(), modifyInsuPeopleSchema.getAppAgeType());
		boolean nameflag = name.equals(modifyInsuPeopleSchema.getName() == null ? "" : ((Object) (modifyInsuPeopleSchema.getName())));
		boolean birthdayflag = birthday.equals(modifyInsuPeopleSchema.getBirthday() == null ? "" : ((Object) (modifyInsuPeopleSchema.getBirthday())));
		boolean occflag = occupationCode2.equals(modifyInsuPeopleSchema.getOccupationCode() == null ? "" : ((Object) (modifyInsuPeopleSchema.getOccupationCode())));
		boolean sexflag = sex2.equals(modifyInsuPeopleSchema.getSex() == null ? "" : ((Object) (modifyInsuPeopleSchema.getSex())));
		boolean navation = navition.equals(modifyInsuPeopleSchema.getNativePlace() == null ? "" : ((Object) (modifyInsuPeopleSchema.getNativePlace())));
		return !nameflag || !sexflag || !birthdayflag || !occflag || !ageflag || !navation;
	}

	private List doSignCityListValue()
	{
		List list = new ArrayList();
		try
		{
			if (operType != null && contNo != null)
			{
				ExeSQL tExeSQL = new ExeSQL();
				String sql = "";
				SSRS tSRS = new SSRS();
				if (operType.equals("1"))
				{
					sql = (new StringBuilder("select code,codename from lnpcode  where codetype='signcity'  and codealias ='")).append(contNo.substring(0, 2)).append("' ").append(" order by othersign ").toString();
					tSRS = tExeSQL.execSQL(sql);
				} else
				{
					sql = (new StringBuilder("select code,codename from lnpcode  where codetype='signcity'  and codealias ='")).append(contNo.substring(0, 2)).append("' ").append(" order by othersign ").toString();
					tSRS = tExeSQL.execSQL(sql);
				}
				if (tSRS != null && tSRS.MaxRow > 0)
				{
					for (int i = 1; i <= tSRS.MaxRow; i++)
						list.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

				}
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	private boolean checkAgeChange(int age2, String ageType, int appAge, String appAgeType)
	{
		if (ageType.equals("Y"))
			return appAge == age2;
		if (ageType.equals("D"))
			return appAge == 0 && appAgeType.equals("Y");
		else
			return false;
	}

	public void getAgeByBirthday()
	{
		reAge = "-1";
		try
		{
			reAge = LNPPubFun.getAgeByBirthdayNew(birthday, contSch.getPValiDate());
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
	}

	public String getReAge()
	{
		return reAge;
	}

	public void setReAge(String reAge)
	{
		this.reAge = reAge;
	}

	private boolean validate()
	{
		if (insuredSchema.getName() == null || insuredSchema.getName().equals(""))
		{
			message = "????????????????";
			return false;
		}
		if (!ValidateTools.isValidString1(insuredSchema.getName()))
		{
			message = "??????????\274??????????";
			insuredSchema.setName("");
			return false;
		}
		if (insuredSchema.getSex() == null || insuredSchema.getSex().equals("-1") || insuredSchema.getSex().equals(""))
		{
			message = "???????????????";
			return false;
		}
		if (insuredSchema.getBirthday() == null || insuredSchema.getBirthday().equals(""))
		{
			message = "???????????????";
			return false;
		}
		if (insuredSchema.getBirthday() == null || insuredSchema.getBirthday().equals(""))
		{
			message = "????????????????";
			return false;
		}
		if (insuredSchema.getMarriage() == null || insuredSchema.getMarriage().equals("-1") || insuredSchema.getMarriage().equals(""))
		{
			message = "?????????????";
			return false;
		}
		if (insuredSchema.getNativePlace() == null || insuredSchema.getNativePlace().equals("-1") || insuredSchema.getNativePlace().equals(""))
		{
			message = "????????";
			return false;
		}
		if (insuredSchema.getIDType() == null || insuredSchema.getIDType().equals("-1") || insuredSchema.getIDType().equals(""))
		{
			message = "??????????????";
			return false;
		}
		if (insuredSchema.getIDNo() == null || insuredSchema.getIDNo().equals(""))
		{
			message = "?????????????";
			return false;
		}
		if (insuredSchema.getIDType().equals("1"))
		{
			String returnString = ValidateTools.isValidIDNo(insuredSchema.getIDNo(), insuredSchema.getBirthday(), insuredSchema.getSex());
			if (!returnString.equals(""))
			{
				message = returnString;
				insuredSchema.setIDNo("");
				return false;
			}
		}
		if (insuredSchema.getIDPerpetual().equals("0") && (insuredSchema.getIDValidity() == null || insuredSchema.getIDValidity().equals("")))
		{
			message = "?????§¹???????????";
			return false;
		}
		if (insuredSchema.getOccupationCode() == null || insuredSchema.getOccupationCode().equals(""))
		{
			message = "????????????";
			return false;
		}
		if (insuredSchema.getSignCity() == null || insuredSchema.getSignCity().equals("-1") || insuredSchema.getSignCity().equals(""))
		{
			message = "???????????";
			return false;
		}
		System.out.println((new StringBuilder("---- §µ????? lnpAddressSchema  --")).append(lnpAddressSchema).toString());
		System.out.println((new StringBuilder("---- §µ????? lnpAddressSchema getPostalAddress --")).append(lnpAddressSchema.getPostalAddress()).toString());
		if (lnpAddressSchema.getPostalAddress() == null || lnpAddressSchema.getPostalAddress().equals(""))
		{
			message = "?????????????";
			return false;
		}
		if (lnpAddressSchema.getPhone() == null || lnpAddressSchema.getPhone().equals(""))
		{
			message = "???´Â????????";
			return false;
		}
		if (lnpAddressSchema.getZipCode() == null || lnpAddressSchema.getZipCode().equals(""))
		{
			message = "????????????";
			return false;
		}
		if (lnpAddressSchema.getGrpName() != null && !lnpAddressSchema.getGrpName().equals("") && !ValidateTools.isValidString3(lnpAddressSchema.getGrpName()))
		{
			message = "??????????\274????¦Ë??";
			lnpAddressSchema.setGrpName("");
			return false;
		}
		if (lnpAddressSchema.getCompanyZipCode() != null && !lnpAddressSchema.getCompanyZipCode().equals("") && !ValidateTools.isValidZipCode(lnpAddressSchema.getCompanyZipCode()))
		{
			message = "??????????\274??¦Ë???";
			lnpAddressSchema.setCompanyZipCode("");
			return false;
		}
		if (lnpAddressSchema.getCompanyAddress() != null && !lnpAddressSchema.getCompanyAddress().equals("") && !ValidateTools.isValidString3(lnpAddressSchema.getCompanyAddress()))
		{
			message = "??????????\274??¦Ë?????";
			lnpAddressSchema.setCompanyAddress("");
			return false;
		}
		if (lnpAddressSchema.getCompanyMail() != null && !lnpAddressSchema.getCompanyMail().equals("") && !ValidateTools.isValidString4(lnpAddressSchema.getCompanyMail()))
		{
			message = "??????????\274??¦Ë?????";
			lnpAddressSchema.setCompanyMail("");
			return false;
		}
		if (lnpAddressSchema.getHomeAddress() != null && !lnpAddressSchema.getHomeAddress().equals("") && !ValidateTools.isValidString3(lnpAddressSchema.getHomeAddress()))
		{
			message = "??????????\274??????";
			lnpAddressSchema.setHomeAddress("");
			return false;
		}
		if (lnpAddressSchema.getHomeZipCode() != null && !lnpAddressSchema.getHomeZipCode().equals("") && !ValidateTools.isValidZipCode(lnpAddressSchema.getHomeZipCode()))
		{
			message = "??????????\274?????";
			lnpAddressSchema.setHomeZipCode("");
			return false;
		}
		if (lnpAddressSchema.getPostalAddress() != null && !lnpAddressSchema.getPostalAddress().equals("") && !ValidateTools.isValidString3(lnpAddressSchema.getPostalAddress()))
		{
			message = "??????????\274?????????";
			lnpAddressSchema.setPostalAddress("");
			return false;
		}
		if (lnpAddressSchema.getZipCode() != null && !lnpAddressSchema.getZipCode().equals("") && !ValidateTools.isValidZipCode(lnpAddressSchema.getZipCode()))
		{
			message = "??????????\274????????";
			lnpAddressSchema.setZipCode("");
			return false;
		} else
		{
			return true;
		}
	}

	public LNPAddressSchema getLnpAddressSchema()
	{
		return lnpAddressSchema;
	}

	public void setLnpAddressSchema(LNPAddressSchema lnpAddressSchema)
	{
		this.lnpAddressSchema = lnpAddressSchema;
	}

	public LNPPersonSchema getLnpPersonSchema()
	{
		return lnpPersonSchema;
	}

	public void setLnpPersonSchema(LNPPersonSchema lnpPersonSchema)
	{
		this.lnpPersonSchema = lnpPersonSchema;
	}

	public LNPInsuredSchema getInsuredSchema()
	{
		return insuredSchema;
	}

	public void setInsuredSchema(LNPInsuredSchema insuredSchema)
	{
		this.insuredSchema = insuredSchema;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getIdType()
	{
		return idType;
	}

	public void setIdType(String idType)
	{
		this.idType = idType;
	}

	public String getInsuNative()
	{
		return insuNative;
	}

	public void setInsuNative(String insuNative)
	{
		this.insuNative = insuNative;
	}

	public String getInsuCity()
	{
		return insuCity;
	}

	public void setInsuCity(String insuCity)
	{
		this.insuCity = insuCity;
	}

	public String getMarriage()
	{
		return marriage;
	}

	public void setMarriage(String marriage)
	{
		this.marriage = marriage;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getSignCityFirst()
	{
		return signCityFirst;
	}

	public void setSignCityFirst(String signCityFirst)
	{
		this.signCityFirst = signCityFirst;
	}

	public boolean isOperateResult()
	{
		return operateResult;
	}

	public void setOperateResult(boolean operateResult)
	{
		this.operateResult = operateResult;
	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
	}

	public String getIdPerpetual()
	{
		return idPerpetual;
	}

	public void setIdPerpetual(String idPerpetual)
	{
		this.idPerpetual = idPerpetual;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public List getSignCityList()
	{
		if (signCityList != null)
			signCityList.clear();
		signCityList = doSignCityListValue();
		return signCityList;
	}

	public void setSignCityList(List signCityList)
	{
		this.signCityList = signCityList;
	}

	public String getCompanyAddress()
	{
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress)
	{
		this.companyAddress = companyAddress;
	}

	public String getCompanyMail()
	{
		return companyMail;
	}

	public void setCompanyMail(String companyMail)
	{
		this.companyMail = companyMail;
	}

	public String getCompanyPhone()
	{
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone)
	{
		this.companyPhone = companyPhone;
	}

	public String getCompanyZipCode()
	{
		return companyZipCode;
	}

	public void setCompanyZipCode(String companyZipCode)
	{
		this.companyZipCode = companyZipCode;
	}

	public String getGrpName()
	{
		return grpName;
	}

	public void setGrpName(String grpName)
	{
		this.grpName = grpName;
	}

	public String getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress)
	{
		this.homeAddress = homeAddress;
	}

	public String getHomePhone()
	{
		return homePhone;
	}

	public void setHomePhone(String homePhone)
	{
		this.homePhone = homePhone;
	}

	public String getHomeZipCode()
	{
		return homeZipCode;
	}

	public void setHomeZipCode(String homeZipCode)
	{
		this.homeZipCode = homeZipCode;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getPostalAddress()
	{
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress)
	{
		System.out.println((new StringBuilder("--  set setPostalAddress---")).append(postalAddress).toString());
		this.postalAddress = postalAddress;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getIDNo()
	{
		return IDNo;
	}

	public void setIDNo(String no)
	{
		IDNo = no;
	}

	public String getIDValidity()
	{
		return IDValidity;
	}

	public void setIDValidity(String validity)
	{
		IDValidity = validity;
	}

	public String getInsuredId()
	{
		return insuredId;
	}

	public void setInsuredId(String insuredId)
	{
		this.insuredId = insuredId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOccupationCode()
	{
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode)
	{
		this.occupationCode = occupationCode;
	}

	public String getPartOccupationCode()
	{
		return partOccupationCode;
	}

	public void setPartOccupationCode(String partOccupationCode)
	{
		this.partOccupationCode = partOccupationCode;
	}

	public String getOccupationName()
	{
		return occupationName;
	}

	public void setOccupationName(String occupationName)
	{
		this.occupationName = occupationName;
	}

	public String getPartOccupationName()
	{
		return partOccupationName;
	}

	public void setPartOccupationName(String partOccupationName)
	{
		this.partOccupationName = partOccupationName;
	}

	public String getInsuOtherCity()
	{
		return insuOtherCity;
	}

	public void setInsuOtherCity(String insuOtherCity)
	{
		this.insuOtherCity = insuOtherCity;
	}

	public String getNameHidden()
	{
		return nameHidden;
	}

	public void setNameHidden(String nameHidden)
	{
		this.nameHidden = nameHidden;
	}

	public String getBirthdayHidden()
	{
		return birthdayHidden;
	}

	public void setBirthdayHidden(String birthdayHidden)
	{
		this.birthdayHidden = birthdayHidden;
	}

	public String getSexHidden()
	{
		return sexHidden;
	}

	public void setSexHidden(String sexHidden)
	{
		this.sexHidden = sexHidden;
	}

	public String getOccupationCodeHidden()
	{
		return occupationCodeHidden;
	}

	public void setOccupationCodeHidden(String occupationCodeHidden)
	{
		this.occupationCodeHidden = occupationCodeHidden;
	}

	public boolean isHasPolTag()
	{
		return hasPolTag;
	}

	public void setHasPolTag(boolean hasPolTag)
	{
		this.hasPolTag = hasPolTag;
	}

	public String getInsuNativeHidden()
	{
		return insuNativeHidden;
	}

	public void setInsuNativeHidden(String insuNativeHidden)
	{
		this.insuNativeHidden = insuNativeHidden;
	}
}
