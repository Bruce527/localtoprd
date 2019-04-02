// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AppntPersonInfo.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
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

public class AppntPersonInfo
{

	private boolean editFlag;
	private boolean operateResult;
	private boolean hasUnderWrite;
	private IGlobalInput tempGI;
	private LNPContSchema contSch;
	private String message;
	private String infoSource;
	private String contNo;
	private String appntId;
	private String insuredId;
	private String relationToInsured;
	private String connectionWithInsuranceHidden;
	private String nameHidden;
	private String birthdayHidden;
	private String occupationCodeHidden;
	private boolean renderFlag;
	private LNPAppntSchema appntSchema;
	private LNPPersonSchema lnpPersonSchema;
	private LNPAddressSchema lnpAddressSchema;
	private String age;
	private String sex;
	private String marriage;
	private String appntNative;
	private String idType;
	private String idPerpetual;
	private List appntRelationtoinsuredList;
	private String occupationCode;
	private String occupationName;
	private String insuCity;
	private String insuOtherCity;
	private String connectionWithInsurance;
	private boolean showMessageFlag;
	private String reAge;

	public AppntPersonInfo()
	{
		operateResult = true;
		hasUnderWrite = false;
		connectionWithInsuranceHidden = null;
		nameHidden = null;
		birthdayHidden = null;
		occupationCodeHidden = null;
		age = "";
		appntRelationtoinsuredList = new ArrayList();
		insuCity = "";
		insuOtherCity = "";
	}

	public void initData()
	{
		System.out.println(" -- appntpersoninfo initData start-- ");
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		try
		{
			tempGI = (IGlobalInput)session.getValue("NPGI");
			if ((String)session.getAttribute("ContNo") != null && !((String)session.getAttribute("ContNo")).equals(""))
			{
				contNo = (String)session.getAttribute("ContNo");
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				contSch = mainInfo.getContByContNo(contNo);
				appntSchema = new LNPAppntSchema();
				occupationName = getOccupName(appntSchema.getOccupationCode());
				lnpPersonSchema = new LNPPersonSchema();
				lnpAddressSchema = new LNPAddressSchema();
				String myAppntId = contSch.getAppntId();
				insuredId = contSch.getInsuredId();
				appntId = contSch.getAppntId();
				sex = appntSchema.getAppntSex();
				marriage = appntSchema.getMarriage();
				idType = "1";
				age = "";
				appntNative = "";
				if (myAppntId != null && !myAppntId.equals(""))
				{
					initAppntExist();
					infoSource = "modify";
				} else
				{
					infoSource = "add";
					System.out.println("����Ͷ����");
				}
			} else
			{
				infoSource = "undo";
				operateResult = false;
				message = "保单号�?�投保人ID信息丢失";
			}
			Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
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
			infoSource = "undo";
			operateResult = false;
			message = "保单号�?�投保人ID信息丢失";
		}
		System.out.println(" -- appntpersoninfo initData end-- ");
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

	public void setconnectionWithInsuranceSelf()
	{
		if (getConnectionWithInsurance().equals("0"))
		{
			if (insuredId != null && !insuredId.equals(""))
			{
				initAppntByInsuredId(insuredId);
				System.out.println((new StringBuilder("--")).append(appntSchema.getAppntName()).toString());
			} else
			{
				initAppnt();
			}
		} else
		if (connectionWithInsurance.equals(relationToInsured))
			initAppntExist();
		else
			initAppnt();
	}

	public void validateConnection()
	{
		showMessageFlag = false;
		if (!checkConn(connectionWithInsurance))
		{
			showMessageFlag = true;
			message = "�?提供书面说明";
		}
	}

	public boolean isShowMessageFlag()
	{
		return showMessageFlag;
	}

	public void setShowMessageFlag(boolean showMessageFlag)
	{
		this.showMessageFlag = showMessageFlag;
	}

	private boolean checkConn(String connectionWithInsurance)
	{
		boolean reflag = false;
		String sql = (new StringBuilder("select * from lnpcode where codetype='appntrelationtoinsured' and othersign='1'and code ='")).append(connectionWithInsurance).append("';").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = null;
		tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
			reflag = true;
		return reflag;
	}

	private void initAppntExist()
	{
		System.out.println("-- initAppntExist --");
		PersonFunction pf = new PersonFunction();
		appntSchema = getOneAppntPersonInfo(contSch.getContNo(), contSch.getAppntId());
		occupationName = getOccupName(appntSchema.getOccupationCode());
		lnpPersonSchema = pf.getLnpPersonByCustomerId(contSch.getAppntId());
		lnpAddressSchema = pf.getLnpAddrByCustomerId(contSch.getAppntId());
		relationToInsured = appntSchema.getRelationToInsured();
		connectionWithInsurance = appntSchema.getRelationToInsured();
		sex = appntSchema.getAppntSex();
		marriage = appntSchema.getMarriage();
		appntNative = appntSchema.getNativePlace();
		idType = appntSchema.getIDType();
		idPerpetual = appntSchema.getIDPerpetual();
		insuCity = lnpAddressSchema.getDuchy();
		insuOtherCity = lnpAddressSchema.getOtherDuchy();
		connectionWithInsuranceHidden = appntSchema.getRelationToInsured();
		nameHidden = appntSchema.getAppntName();
		birthdayHidden = appntSchema.getAppntBirthday();
		occupationCodeHidden = appntSchema.getOccupationCode();
		if ("2".equals(contSch.getUWFlag()))
			hasUnderWrite = true;
		else
			hasUnderWrite = false;
		if (appntSchema.getAppntBirthday() != null && !"".equals(appntSchema.getAppntBirthday()))
			age = LNPPubFun.getAgeByBirthdayNew(appntSchema.getAppntBirthday(), contSch.getPValiDate());
		System.out.println("-- initAppntExist end--");
	}

	private void initAppnt()
	{
		String tempid = appntSchema.getAppntId();
		System.out.println((new StringBuilder("-- initAppnt tempid--")).append(tempid).toString());
		appntSchema = new LNPAppntSchema();
		appntSchema.setAppntId(tempid);
		occupationName = "";
		System.out.println((new StringBuilder("-- initAppnt tempid--")).append(appntSchema.getAppntId()).toString());
		lnpPersonSchema = new LNPPersonSchema();
		lnpAddressSchema = new LNPAddressSchema();
		sex = null;
		marriage = null;
		appntNative = "";
		idType = null;
		age = "";
		idPerpetual = "0";
		insuCity = "";
		insuOtherCity = "";
	}

	private void initAppntByInsuredId(String insuredId)
	{
		System.out.println(" -- initAppntByInsuredId --");
		PersonFunction pf = new PersonFunction();
		LNPPersonSchema lnpPersonTemp = pf.getLnpPersonByCustomerId(insuredId);
		appntSchema.setAppntName(lnpPersonTemp.getName());
		appntSchema.setAppntSex(lnpPersonTemp.getSex());
		appntSchema.setAppntBirthday(lnpPersonTemp.getBirthday());
		appntSchema.setIDType(lnpPersonTemp.getIDType());
		appntSchema.setIDNo(lnpPersonTemp.getIDNo());
		appntSchema.setNativePlace(lnpPersonTemp.getNativePlace());
		appntSchema.setMarriage(lnpPersonTemp.getMarriage());
		appntSchema.setOccupationCode(lnpPersonTemp.getOccupationCode());
		appntSchema.setAppntAge(lnpPersonTemp.getAge());
		appntSchema.setIDPerpetual(lnpPersonTemp.getIDPerpetual());
		appntSchema.setIDValidity(lnpPersonTemp.getIDValidity());
		lnpPersonSchema = new LNPPersonSchema();
		lnpAddressSchema = pf.getLnpAddrByCustomerId(insuredId);
		occupationName = getOccupName(appntSchema.getOccupationCode());
		sex = appntSchema.getAppntSex();
		marriage = appntSchema.getMarriage();
		appntNative = appntSchema.getNativePlace();
		idType = appntSchema.getIDType();
		insuCity = lnpAddressSchema.getDuchy();
		insuOtherCity = lnpAddressSchema.getOtherDuchy();
		if (appntSchema.getAppntBirthday() != null && !"".equals(appntSchema.getAppntBirthday()))
			age = LNPPubFun.getAgeByBirthdayNew(appntSchema.getAppntBirthday(), contSch.getPValiDate());
		idPerpetual = appntSchema.getIDPerpetual();
		System.out.println(" -- initAppntByInsuredId end--");
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
			appntSchema.setOccupationCode(occupationCode);
		else
			appntSchema.setOccupationCode("");
		session.removeAttribute("occupationName");
		session.removeAttribute("occupationCode");
	}

	public void reWriteOccupation()
	{
		appntSchema.setOccupationCode("");
		occupationName = "";
		String sql = (new StringBuilder("select occupationcode,occupationname from lnpoccupation where occupationcode='")).append(occupationCode).append("';").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		System.out.println((new StringBuilder("sql--")).append(sql).toString());
		if (tSSRS.MaxRow > 0)
		{
			operateResult = false;
			appntSchema.setOccupationCode(tSSRS.GetText(1, 1));
			occupationName = tSSRS.GetText(1, 2);
		} else
		{
			operateResult = true;
			message = "该职业代码不存在�?";
		}
	}

	public void saveappntPeople()
	{
		message = null;
		operateResult = true;
		if (connectionWithInsurance == null || connectionWithInsurance.equals("-1"))
		{
			message = "与被保人关系不能为空�?";
			operateResult = false;
			return;
		}
		if (infoSource.equals("undo"))
		{
			message = "投保书信息丢失！";
			operateResult = false;
			return;
		}
		System.out.println("----  saveappntPeople start ------");
		appntSchema.setNativePlace(getAppntNative());
		appntSchema.setAppntSex(getSex());
		appntSchema.setMarriage(getMarriage());
		appntSchema.setIDType(getIdType());
		appntSchema.setIDPerpetual(getIdPerpetual());
		appntSchema.setRelationToInsured(getConnectionWithInsurance());
		if ("0".equals(appntSchema.getIDPerpetual()) && appntSchema.getIDValidity() != null)
			appntSchema.setIDValidity(appntSchema.getIDValidity());
		else
		if ("1".equals(appntSchema.getIDPerpetual()))
			appntSchema.setIDValidity("");
		String agePer = "";
		String ageType = "";
		agePer = LNPPubFun.getAgeByBirthdayNew(appntSchema.getAppntBirthday(), contSch.getPValiDate());
		age = agePer;
		if (agePer.indexOf("�?") > -1)
		{
			ageType = "D";
			agePer = agePer.substring(0, agePer.indexOf("�?"));
		} else
		{
			ageType = "Y";
			agePer = agePer.substring(0, agePer.indexOf("�?"));
		}
		appntSchema.setAppntAge(agePer);
		appntSchema.setAppntAgeType(ageType);
		if (!validate())
		{
			operateResult = false;
		} else
		{
			System.out.println((new StringBuilder("��ǰ����---")).append(infoSource).toString());
			if (infoSource.equals("add"))
			{
				if (addAppntOfNewCustomer())
				{
					message = "投保人信息保存成功！";
					operateResult = true;
				}
			} else
			if (infoSource.equals("modify") && modifyappntPeople())
			{
				message = "投保人信息保存成功！";
				operateResult = true;
			}
		}
		System.out.println((new StringBuilder("----  saveappntPeople end ------")).append(message).toString());
	}

	private LNPContSchema getMyLNPContByContNo(String contno)
	{
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contno);
		return aLNPContSchema;
	}

	public LNPAppntSchema getAppntPeopleByContNo(String contNo, String aAppntId)
	{
		LNPAppntDB lnpAppntredDB = new LNPAppntDB();
		LNPAppntSchema aLNPAppntSchema = new LNPAppntSchema();
		aLNPAppntSchema.setContNo(contNo);
		if (!aAppntId.equals(""))
			aLNPAppntSchema.setAppntId(aAppntId);
		lnpAppntredDB.setSchema(aLNPAppntSchema);
		LNPAppntSet lnpAppntredSet = lnpAppntredDB.query();
		if (lnpAppntredSet.size() > 0)
			aLNPAppntSchema = lnpAppntredSet.get(1);
		else
			aLNPAppntSchema = null;
		return aLNPAppntSchema;
	}

	public List getAppntPeopleListByContNo(String aContNo)
	{
		LNPAppntDB lnpAppntredDB = new LNPAppntDB();
		lnpAppntredDB.setContNo(aContNo);
		LNPAppntSet lnpAppntredSet = lnpAppntredDB.query();
		List list = new ArrayList();
		if (lnpAppntredSet.size() > 0)
		{
			list = new ArrayList();
			for (int i = 1; i < lnpAppntredSet.size(); i++)
			{
				LNPAppntSchema temp = lnpAppntredSet.get(i);
				list.add(temp);
			}

		}
		return list;
	}

	public LNPAppntSchema getOneAppntPersonInfo(String contNo, String appntId)
	{
		LNPAppntDB saveLSAppntredDB = new LNPAppntDB();
		saveLSAppntredDB.setContNo(contNo);
		saveLSAppntredDB.setAppntId(appntId);
		LNPAppntSet set = saveLSAppntredDB.query();
		if (set.size() > 0)
			return set.get(1);
		else
			return null;
	}

	private boolean addAppntOfNewCustomer()
	{
		boolean flag = true;
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		LNPAppntSchema addAppntSch = new LNPAppntSchema();
		Reflections reflect = new Reflections();
		reflect.transFields(addAppntSch, appntSchema);
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		String appntid = maxNoMap.CreateMaxNo("CustomerNo", "");
		addAppntSch.setAppntId(appntid);
		System.out.println((new StringBuilder("--- appntId --")).append(contNo).append("--").append(addAppntSch.getAppntId()).toString());
		LNPContSchema lnpContSch = getMyLNPContByContNo(contNo);
		addAppntSch.setGrpContNo(lnpContSch.getGrpContNo());
		addAppntSch.setPrtNo(lnpContSch.getPrtNo());
		addAppntSch.setContNo(lnpContSch.getContNo());
		addAppntSch.setProposalContNo(lnpContSch.getProposalContNo());
		addAppntSch.setOperator(tempGI.Operator);
		addAppntSch.setMakeDate(date);
		addAppntSch.setMakeTime(time);
		addAppntSch.setModifyDate(date);
		addAppntSch.setModifyTime(time);
		lnpPersonSchema.setAgentCode(addAppntSch.getOperator());
		lnpPersonSchema.setCustomerId(appntid);
		lnpPersonSchema.setName(addAppntSch.getAppntName());
		lnpPersonSchema.setSex(addAppntSch.getAppntSex());
		lnpPersonSchema.setBirthday(addAppntSch.getAppntBirthday());
		lnpPersonSchema.setIDType(addAppntSch.getIDType());
		lnpPersonSchema.setIDNo(addAppntSch.getIDNo());
		lnpPersonSchema.setNativePlace(addAppntSch.getNativePlace());
		lnpPersonSchema.setMarriage(addAppntSch.getMarriage());
		lnpPersonSchema.setOccupationCode(addAppntSch.getOccupationCode());
		lnpPersonSchema.setAge(addAppntSch.getAppntAge());
		lnpPersonSchema.setAgeType(addAppntSch.getAppntAgeType());
		lnpPersonSchema.setIDPerpetual(addAppntSch.getIDPerpetual());
		lnpPersonSchema.setIDValidity(addAppntSch.getIDValidity());
		lnpPersonSchema.setOperator(tempGI.Operator);
		lnpPersonSchema.setMakeDate(date);
		lnpPersonSchema.setMakeTime(time);
		lnpPersonSchema.setModifyDate(date);
		lnpPersonSchema.setModifyTime(time);
		lnpAddressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
		lnpAddressSchema.setCustomerId(appntid);
		lnpAddressSchema.setOperator(tempGI.Operator);
		lnpAddressSchema.setDuchy(getInsuCity());
		lnpAddressSchema.setOtherDuchy(getInsuOtherCity() == null ? "" : getInsuOtherCity());
		lnpAddressSchema.setMakeDate(date);
		lnpAddressSchema.setMakeTime(time);
		lnpAddressSchema.setModifyDate(date);
		lnpAddressSchema.setModifyTime(time);
		addAppntSch.setAddressNo(lnpAddressSchema.getAddressNo());
		lnpContSch.setAppntId(appntid);
		lnpContSch.setAppntNo(addAppntSch.getAppntNo());
		lnpContSch.setAppntName(addAppntSch.getAppntName());
		lnpContSch.setAppntBirthday(addAppntSch.getAppntBirthday());
		lnpContSch.setAppntIDType(addAppntSch.getIDType());
		lnpContSch.setAppntIDNo(addAppntSch.getIDNo());
		if (appntid == null || "".equals(appntid))
		{
			message = "投保人信息保存错误！";
			flag = false;
			return false;
		}
		StateOperatorDeal operatorDeal = new StateOperatorDeal();
		List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), infoSource, "03");
		lnpContSch.setState((String)stateList.get(0));
		lnpContSch.setEditstate((String)stateList.get(1));
		if ("2".equals(lnpContSch.getUWFlag()))
			lnpContSch.setUWFlag("1");
		lnpContSch.setModifyDate(date);
		lnpContSch.setModifyTime(time);
		PubSubmit ps = new PubSubmit();
		MMap map = new MMap();
		map.put(addAppntSch, "INSERT");
		map.put(lnpPersonSchema, "INSERT");
		map.put(lnpAddressSchema, "INSERT");
		map.put(lnpContSch, "UPDATE");
		VData vd = new VData();
		vd.add(map);
		if (!ps.submitData(vd, ""))
		{
			System.out.println("-AppntPeopleInfo-插入错误");
			message = "投保人信息保存错误！";
			flag = false;
		} else
		{
			String sql = (new StringBuilder("select * from lnpappnt where contno='")).append(addAppntSch.getContNo()).append("'").toString();
			LNPAppntDB adddb = new LNPAppntDB();
			LNPAppntSet addSet = adddb.executeQuery(sql);
			if (addSet != null && addSet.size() != 1)
			{
				flag = true;
			} else
			{
				LNPAppntSchema tmp = addSet.get(1);
				if (tmp.getAppntId() == null || "".equals(tmp.getAppntId().trim()))
				{
					ExeSQL tExeSQL = new ExeSQL();
					String upSQL = (new StringBuilder("update lnppol set appntid='")).append(lnpContSch.getAppntId()).append("' where contno='").append(addAppntSch.getContNo()).append("'").toString();
					System.out.println(upSQL);
					boolean updateflag = tExeSQL.execUpdateSQL(upSQL);
					if (!updateflag)
					{
						System.out.println("-AppntPeopleInfo-插入错误2");
						message = "投保人信息保存错误！";
					}
				}
			}
			reflect.transFields(appntSchema, addAppntSch);
			flag = true;
		}
		return flag;
	}

	private boolean modifyappntPeople()
	{
		System.out.println("-- modifyappntPeople start --");
		boolean flag;
		try
		{
			flag = false;
			String date = PubFun.getCurrentDate();
			String time = PubFun.getCurrentTime();
			String midifyAppntId = appntSchema.getAppntId();
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			PersonFunction pf = new PersonFunction();
			StateOperatorDeal operatorDeal = new StateOperatorDeal();
			LNPAppntSchema modifyAppntPeopleSchema = getAppntPeopleByContNo(contNo, "");
			LNPAppntSchema modifyAppntPeopleSchemaTemp = getAppntPeopleByContNo(contNo, "");
			LNPAddressSchema modifylnpAddressSchema = pf.getLnpAddrByCustomerId(midifyAppntId);
			LNPPersonSchema modifylnpPersonSchema = pf.getLnpPersonByCustomerId(midifyAppntId);
			LNPContSchema lnpContSch = getMyLNPContByContNo(contNo);
			if (modifyAppntPeopleSchema != null && modifylnpAddressSchema != null && modifylnpPersonSchema != null)
			{
				modifyAppntPeopleSchema.setAppntName(appntSchema.getAppntName());
				modifyAppntPeopleSchema.setAppntSex(appntSchema.getAppntSex());
				modifyAppntPeopleSchema.setAppntBirthday(appntSchema.getAppntBirthday());
				modifyAppntPeopleSchema.setAppntAge(appntSchema.getAppntAge());
				modifyAppntPeopleSchema.setAppntAgeType(appntSchema.getAppntAgeType());
				modifyAppntPeopleSchema.setIDPerpetual(appntSchema.getIDPerpetual());
				modifyAppntPeopleSchema.setIDValidity(appntSchema.getIDValidity());
				modifyAppntPeopleSchema.setIDType(appntSchema.getIDType());
				modifyAppntPeopleSchema.setIDNo(appntSchema.getIDNo());
				modifyAppntPeopleSchema.setNativePlace(appntSchema.getNativePlace());
				modifyAppntPeopleSchema.setMarriage(appntSchema.getMarriage());
				modifyAppntPeopleSchema.setOccupationCode(appntSchema.getOccupationCode());
				modifyAppntPeopleSchema.setModifyDate(date);
				modifyAppntPeopleSchema.setModifyTime(time);
				modifyAppntPeopleSchema.setAppntAge(appntSchema.getAppntAge());
				modifyAppntPeopleSchema.setRelationToInsured(connectionWithInsurance);
				modifylnpPersonSchema.setName(modifyAppntPeopleSchema.getAppntName());
				modifylnpPersonSchema.setSex(modifyAppntPeopleSchema.getAppntSex());
				modifylnpPersonSchema.setBirthday(modifyAppntPeopleSchema.getAppntBirthday());
				modifylnpPersonSchema.setIDType(modifyAppntPeopleSchema.getIDType());
				modifylnpPersonSchema.setIDNo(modifyAppntPeopleSchema.getIDNo());
				modifylnpPersonSchema.setNativePlace(modifyAppntPeopleSchema.getNativePlace());
				modifylnpPersonSchema.setMarriage(modifyAppntPeopleSchema.getMarriage());
				modifylnpPersonSchema.setOccupationCode(modifyAppntPeopleSchema.getOccupationCode());
				modifylnpPersonSchema.setAge(modifyAppntPeopleSchema.getAppntAge());
				modifylnpPersonSchema.setAgeType(modifyAppntPeopleSchema.getAppntAgeType());
				modifylnpPersonSchema.setIDPerpetual(modifyAppntPeopleSchema.getIDPerpetual());
				modifylnpPersonSchema.setIDValidity(modifyAppntPeopleSchema.getIDValidity());
				modifylnpPersonSchema.setModifyDate(date);
				modifylnpPersonSchema.setModifyTime(time);
				System.out.println((new StringBuilder("�޸ĵĿͻ���ַid--")).append(modifylnpAddressSchema.getAddressNo()).toString());
				modifylnpAddressSchema.setPostalAddress(lnpAddressSchema.getPostalAddress());
				modifylnpAddressSchema.setZipCode(lnpAddressSchema.getZipCode());
				modifylnpAddressSchema.setPhone(lnpAddressSchema.getPhone());
				modifylnpAddressSchema.setHomeAddress(lnpAddressSchema.getHomeAddress());
				modifylnpAddressSchema.setHomeZipCode(lnpAddressSchema.getHomeZipCode());
				modifylnpAddressSchema.setHomePhone(lnpAddressSchema.getHomePhone());
				modifylnpAddressSchema.setCompanyAddress(lnpAddressSchema.getCompanyAddress());
				modifylnpAddressSchema.setCompanyPhone(lnpAddressSchema.getCompanyPhone());
				modifylnpAddressSchema.setCompanyMail(lnpAddressSchema.getCompanyMail());
				modifylnpAddressSchema.setGrpName(lnpAddressSchema.getGrpName());
				modifylnpAddressSchema.setCompanyZipCode(lnpAddressSchema.getCompanyZipCode());
				modifylnpAddressSchema.setDuchy(getInsuCity());
				modifylnpAddressSchema.setOtherDuchy(getInsuOtherCity() == null ? "" : getInsuOtherCity());
				modifylnpAddressSchema.setModifyDate(date);
				modifylnpAddressSchema.setModifyTime(time);
				lnpContSch.setAppntId(modifyAppntPeopleSchema.getAppntId());
				lnpContSch.setAppntNo(modifyAppntPeopleSchema.getAppntNo());
				lnpContSch.setAppntName(modifyAppntPeopleSchema.getAppntName());
				lnpContSch.setAppntBirthday(modifyAppntPeopleSchema.getAppntBirthday());
				lnpContSch.setAppntIDType(modifyAppntPeopleSchema.getIDType());
				lnpContSch.setAppntIDNo(modifyAppntPeopleSchema.getIDNo());
				List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), infoSource, "03");
				lnpContSch.setState((String)stateList.get(0));
				lnpContSch.setEditstate((String)stateList.get(1));
				if ("2".equals(lnpContSch.getUWFlag()))
					lnpContSch.setUWFlag("1");
				lnpContSch.setModifyDate(date);
				lnpContSch.setModifyTime(time);
				map.put(modifyAppntPeopleSchema, "UPDATE");
				map.put(modifylnpPersonSchema, "UPDATE");
				map.put(modifylnpAddressSchema, "UPDATE");
				map.put(lnpContSch, "UPDATE");
			} else
			{
				message = "数据库中未查询到投保人信息！";
			}
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				System.out.println("-AppntredPersonInfo-�޸Ĵ���");
				message = "Ͷ������Ϣ�������?";
				flag = false;
			} else
			{
				flag = true;
				afterupdateAppnt(contNo);
				boolean checkSpelFlag = checkSpelKeyChange(modifyAppntPeopleSchemaTemp, appntSchema.getAppntName(), appntSchema.getAppntBirthday(), appntSchema.getOccupationCode(), appntSchema.getRelationToInsured(), appntSchema.getAppntAge(), appntSchema.getAppntAgeType());
				boolean flag1 = operatorDeal.afterModifyAppnt(contSch.getContNo(), checkSpelFlag);
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			message = "Ͷ������Ϣ�������?";
			flag = false;
		}
		System.out.println("-- modifyappntPeople end --");
		return flag;
	}

	private boolean afterupdateAppnt(String contno)
	{
		System.out.println("-----��??�� �޸ı����˹��? ɾ��˱����۶�������? ----");
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

	private List getPageAppntRelationtoinsuredList(String typename, String iid, String cno)
	{
		List reList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "";
		LNPInsuredDB saveLSInsuredDB = new LNPInsuredDB();
		LNPInsuredSchema insuredSchema = new LNPInsuredSchema();
		saveLSInsuredDB.setContNo(cno);
		saveLSInsuredDB.setInsuredId(iid);
		if (saveLSInsuredDB.getInfo())
			insuredSchema = saveLSInsuredDB.getSchema();
		if ("Y".equals(insuredSchema.getAppAgeType()) && insuredSchema.getAppAge() <= 16 || "D".equals(insuredSchema.getAppAgeType()))
			sql = (new StringBuilder("select code,codename from lnpcode where codetype='")).append(typename).append("' and code != '0' order by code").toString();
		else
			sql = (new StringBuilder("select code,codename from lnpcode where codetype='")).append(typename).append("' order by code").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS != null)
		{
			for (int i = 1; i <= tSRS.MaxRow; i++)
				reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		}
		return reList;
	}

	private boolean checkSpelKeyChange(LNPAppntSchema modifyAppntSchema, String name, String birthday, String occupationCode2, String relationToInsured, int age, String ageType)
	{
		boolean ageflag = checkAgeChange(age, ageType, modifyAppntSchema.getAppntAge(), modifyAppntSchema.getAppntAgeType());
		boolean nameflag = name.equals(modifyAppntSchema.getAppntName() == null ? "" : ((Object) (modifyAppntSchema.getAppntName())));
		boolean birthdayflag = birthday.equals(modifyAppntSchema.getAppntBirthday() == null ? "" : ((Object) (modifyAppntSchema.getAppntBirthday())));
		boolean occflag = occupationCode2.equals(modifyAppntSchema.getOccupationCode() == null ? "" : ((Object) (modifyAppntSchema.getOccupationCode())));
		boolean insuredflag = relationToInsured.equals(modifyAppntSchema.getRelationToInsured() == null ? "" : ((Object) (modifyAppntSchema.getRelationToInsured())));
		return !nameflag || !birthdayflag || !occflag || !insuredflag || !ageflag;
	}

	private boolean checkAgeChange(int age2, String ageType, int appAge, String appAgeType)
	{
		boolean flag = false;
		if (ageType.equals(appAgeType) && ageType.equals("Y"))
		{
			if (appAge == age2)
				flag = true;
		} else
		if (ageType.equals("D"))
			if (appAge == 0 && appAgeType.equals("Y"))
				flag = true;
			else
			if (appAgeType.equals(ageType) && appAge == age2)
				flag = true;
		System.out.println((new StringBuilder("checkAgeChange:")).append(flag).toString());
		return flag;
	}

	public void getAgeByBirthday()
	{
		reAge = "-1";
		try
		{
			reAge = LNPPubFun.getAgeByBirthdayNew(appntSchema.getAppntBirthday(), contSch.getPValiDate());
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
		if (appntSchema.getAppntName() == null || appntSchema.getAppntName().equals(""))
		{
			message = "Ͷ����������Ϊ�գ�";
			return false;
		}
		if (!ValidateTools.isValidString1(appntSchema.getAppntName()))
		{
			message = "�밴����ȷ��ʽ¼��Ͷ��������";
			return false;
		}
		if (appntSchema.getAppntSex() == null || appntSchema.getAppntSex().equals("-1") || appntSchema.getAppntSex().equals(""))
		{
			message = "Ͷ�����Ա���Ϊ�գ�";
			return false;
		}
		if (appntSchema.getAppntBirthday() == null || appntSchema.getAppntBirthday().equals(""))
		{
			message = "�������ڲ���Ϊ�գ�";
			return false;
		}
		if (appntSchema.getAppntAge() == 0)
		{
			message = "Ͷ�������䲻��Ϊ�գ�";
			return false;
		}
		if (appntSchema.getMarriage() == null || appntSchema.getMarriage().equals("-1") || appntSchema.getMarriage().equals(""))
		{
			message = "����״����Ϊ�գ�";
			return false;
		}
		if (appntSchema.getNativePlace() == null || appntSchema.getNativePlace().equals("-1") || appntSchema.getNativePlace().equals(""))
		{
			message = "����Ϊ�գ�";
			return false;
		}
		if (appntSchema.getIDType() == null || appntSchema.getIDType().equals("-1") || appntSchema.getIDType().equals(""))
		{
			message = "֤�����Ͳ���Ϊ�գ�";
			return false;
		}
		if (appntSchema.getIDNo() == null || appntSchema.getIDNo().equals(""))
		{
			message = "֤�����벻��Ϊ�գ�";
			return false;
		}
		if (appntSchema.getIDType().equals("1"))
		{
			String returnString = ValidateTools.isValidIDNo(appntSchema.getIDNo(), appntSchema.getAppntBirthday(), appntSchema.getAppntSex());
			if (!returnString.equals(""))
			{
				message = returnString;
				return false;
			}
		}
		if (appntSchema.getOccupationCode() == null || appntSchema.getOccupationCode().equals(""))
		{
			message = "ְҵ���벻��Ϊ�գ�";
			return false;
		}
		if (lnpAddressSchema.getPostalAddress() == null || lnpAddressSchema.getPostalAddress().equals(""))
		{
			message = "�շѵ�ַ����Ϊ�գ�";
			return false;
		}
		if (lnpAddressSchema.getPhone() == null || lnpAddressSchema.getPhone().equals(""))
		{
			message = "�շѵ绰����Ϊ�գ�";
			return false;
		}
		if (lnpAddressSchema.getZipCode() == null || lnpAddressSchema.getZipCode().equals(""))
		{
			message = "�շ��ʱ಻��Ϊ�գ�";
			return false;
		}
		if (lnpAddressSchema.getGrpName() != null && !lnpAddressSchema.getGrpName().equals("") && !ValidateTools.isValidString3(lnpAddressSchema.getGrpName()))
		{
			message = "�밴����ȷ��ʽ¼�빤��λ��";
			return false;
		}
		if (lnpAddressSchema.getCompanyZipCode() != null && !lnpAddressSchema.getCompanyZipCode().equals("") && !ValidateTools.isValidZipCode(lnpAddressSchema.getCompanyZipCode()))
		{
			message = "�밴����ȷ��ʽ¼�뵥λ�ʱ࣡";
			return false;
		}
		if (lnpAddressSchema.getCompanyAddress() != null && !lnpAddressSchema.getCompanyAddress().equals("") && !ValidateTools.isValidString3(lnpAddressSchema.getCompanyAddress()))
		{
			message = "�밴����ȷ��ʽ¼�뵥λ��ַ��";
			return false;
		}
		if (lnpAddressSchema.getCompanyMail() != null && !lnpAddressSchema.getCompanyMail().equals("") && !ValidateTools.isValidString4(lnpAddressSchema.getCompanyMail()))
		{
			message = "�밴����ȷ��ʽ¼�뵥λ���ʣ�";
			lnpAddressSchema.setCompanyMail("");
			return false;
		}
		if (lnpAddressSchema.getHomeAddress() != null && !lnpAddressSchema.getHomeAddress().equals("") && !ValidateTools.isValidString3(lnpAddressSchema.getHomeAddress()))
		{
			message = "�밴����ȷ��ʽ¼��סַ��";
			return false;
		}
		if (lnpAddressSchema.getHomeZipCode() != null && !lnpAddressSchema.getHomeZipCode().equals("") && !ValidateTools.isValidZipCode(lnpAddressSchema.getHomeZipCode()))
		{
			message = "�밴����ȷ��ʽ¼���ʱ࣡";
			return false;
		}
		if (lnpAddressSchema.getPostalAddress() != null && !lnpAddressSchema.getPostalAddress().equals("") && !ValidateTools.isValidString3(lnpAddressSchema.getPostalAddress()))
		{
			message = "�밴����ȷ��ʽ¼���շѵ�ַ��";
			return false;
		}
		if (lnpAddressSchema.getZipCode() != null && !lnpAddressSchema.getZipCode().equals("") && !ValidateTools.isValidZipCode(lnpAddressSchema.getZipCode()))
		{
			message = "�밴����ȷ��ʽ¼���շ��ʱ࣡";
			return false;
		} else
		{
			return true;
		}
	}

	public String getAppntNative()
	{
		return appntNative;
	}

	public void setAppntNative(String appntNative)
	{
		this.appntNative = appntNative;
	}

	public LNPAppntSchema getAppntSchema()
	{
		return appntSchema;
	}

	public void setAppntSchema(LNPAppntSchema appntSchema)
	{
		this.appntSchema = appntSchema;
	}

	public String getIdType()
	{
		return idType;
	}

	public void setIdType(String idType)
	{
		this.idType = idType;
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

	public String getMarriage()
	{
		return marriage;
	}

	public void setMarriage(String marriage)
	{
		this.marriage = marriage;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getConnectionWithInsurance()
	{
		return connectionWithInsurance;
	}

	public void setConnectionWithInsurance(String connectionWithInsurance)
	{
		this.connectionWithInsurance = connectionWithInsurance;
	}

	public String getIdPerpetual()
	{
		return idPerpetual;
	}

	public void setIdPerpetual(String idPerpetual)
	{
		this.idPerpetual = idPerpetual;
	}

	public boolean isRenderFlag()
	{
		return renderFlag;
	}

	public void setRenderFlag(boolean renderFlag)
	{
		this.renderFlag = renderFlag;
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

	public String getOccupationCode()
	{
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode)
	{
		this.occupationCode = occupationCode;
	}

	public List getAppntRelationtoinsuredList()
	{
		if (appntRelationtoinsuredList != null)
			appntRelationtoinsuredList.clear();
		appntRelationtoinsuredList = getPageAppntRelationtoinsuredList("appntrelationtoinsured", insuredId, contNo);
		return appntRelationtoinsuredList;
	}

	public void setAppntRelationtoinsuredList(List appntRelationtoinsuredList)
	{
		this.appntRelationtoinsuredList = appntRelationtoinsuredList;
	}

	public String getOccupationName()
	{
		return occupationName;
	}

	public void setOccupationName(String occupationName)
	{
		this.occupationName = occupationName;
	}

	public String getInsuCity()
	{
		return insuCity;
	}

	public void setInsuCity(String insuCity)
	{
		this.insuCity = insuCity;
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

	public String getConnectionWithInsuranceHidden()
	{
		return connectionWithInsuranceHidden;
	}

	public void setConnectionWithInsuranceHidden(String connectionWithInsuranceHidden)
	{
		this.connectionWithInsuranceHidden = connectionWithInsuranceHidden;
	}

	public String getOccupationCodeHidden()
	{
		return occupationCodeHidden;
	}

	public void setOccupationCodeHidden(String occupationCodeHidden)
	{
		this.occupationCodeHidden = occupationCodeHidden;
	}

	public boolean isHasUnderWrite()
	{
		return hasUnderWrite;
	}

	public void setHasUnderWrite(boolean hasUnderWrite)
	{
		this.hasUnderWrite = hasUnderWrite;
	}
}
