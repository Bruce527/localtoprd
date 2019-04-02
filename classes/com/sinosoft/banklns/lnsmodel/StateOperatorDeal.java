// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   StateOperatorDeal.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPPolDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.LNPPolSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			PolicyMainInfo, BenefitPersonInfo, AppntPersonInfo, InsuredPersonInfo, 
//			PersonFunction

public class StateOperatorDeal
{

	private boolean ageChangeToJuvenilesFlag;

	public StateOperatorDeal()
	{
		ageChangeToJuvenilesFlag = false;
	}

	public List infoOperate(String state, String editState, String operateType, String infoType)
	{
		if (operateType.equals("add"))
			return addInfoOperator(state, editState, infoType);
		if (operateType.equals("modify"))
			return modifyInfoOperator(state, editState, infoType);
		if (operateType.equals("delete"))
			return deleteInfoOperator(state, editState, infoType);
		else
			return null;
	}

	public List addInfoOperator(String state, String editState, String infoType)
	{
		List reList = new ArrayList();
		String editStateArray[] = new String[editState.length()];
		String reState = state;
		String reEditState = "";
		for (int i = 0; i < editState.length(); i++)
			editStateArray[i] = editState.substring(i, i + 1);

		int infoTypeNo;
		if (infoType.startsWith("0"))
			infoTypeNo = Integer.parseInt(infoType.substring(1));
		else
			infoTypeNo = Integer.parseInt(infoType);
		switch (infoTypeNo)
		{
		default:
			break;

		case 1: // '\001'
			editStateArray[0] = "1";
			break;

		case 2: // '\002'
			editStateArray[1] = "1";
			break;

		case 3: // '\003'
			editStateArray[2] = "1";
			break;

		case 4: // '\004'
			editStateArray[3] = "1";
			reState = "01";
			break;

		case 5: // '\005'
			editStateArray[4] = "1";
			break;

		case 6: // '\006'
			editStateArray[5] = "1";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;

		case 7: // '\007'
			editStateArray[6] = "1";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;

		case 8: // '\b'
			editStateArray[7] = "1";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;

		case 9: // '\t'
			editStateArray[8] = "1";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;
		}
		for (int i = 0; i < editState.length(); i++)
			reEditState = (new StringBuilder(String.valueOf(reEditState))).append(editStateArray[i]).toString();

		reList.add(reState);
		reList.add(reEditState);
		return reList;
	}

	public List modifyInfoOperator(String state, String editState, String infoType)
	{
		List reList = new ArrayList();
		String editStateArray[] = new String[editState.length()];
		String reState = state;
		String reEditState = "";
		for (int i = 0; i < editState.length(); i++)
			editStateArray[i] = editState.substring(i, i + 1);

		int infoTypeNo;
		if (infoType.startsWith("0"))
			infoTypeNo = Integer.parseInt(infoType.substring(1));
		else
			infoTypeNo = Integer.parseInt(infoType);
		switch (infoTypeNo)
		{
		default:
			break;

		case 1: // '\001'
			editStateArray[0] = "1";
			state = "01";
			break;

		case 2: // '\002'
			editStateArray[1] = "1";
			break;

		case 3: // '\003'
			editStateArray[2] = "1";
			break;

		case 4: // '\004'
			editStateArray[3] = "1";
			editStateArray[9] = "0";
			reState = "01";
			break;

		case 5: // '\005'
			editStateArray[4] = "1";
			break;

		case 6: // '\006'
			editStateArray[5] = "1";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;

		case 7: // '\007'
			editStateArray[6] = "1";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;

		case 8: // '\b'
			editStateArray[7] = "1";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;

		case 9: // '\t'
			editStateArray[8] = "1";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;
		}
		for (int i = 0; i < editState.length(); i++)
			reEditState = (new StringBuilder(String.valueOf(reEditState))).append(editStateArray[i]).toString();

		reList.add(reState);
		reList.add(reEditState);
		return reList;
	}

	public List deleteInfoOperator(String state, String editState, String infoType)
	{
		List reList = new ArrayList();
		String editStateArray[] = new String[editState.length()];
		String reState = state;
		String reEditState = "";
		for (int i = 0; i < editState.length(); i++)
			editStateArray[i] = editState.substring(i, i + 1);

		int infoTypeNo;
		if (infoType.startsWith("0"))
			infoTypeNo = Integer.parseInt(infoType.substring(1));
		else
			infoTypeNo = Integer.parseInt(infoType);
		switch (infoTypeNo)
		{
		case 5: // '\005'
		case 8: // '\b'
		default:
			break;

		case 4: // '\004'
			editStateArray[3] = "0";
			reState = "01";
			break;

		case 6: // '\006'
			editStateArray[5] = "0";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;

		case 7: // '\007'
			editStateArray[6] = "0";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;

		case 9: // '\t'
			editStateArray[8] = "0";
			if (reState.equals("03") || reState.equals("05"))
				reState = "02";
			break;
		}
		for (int i = 0; i < editState.length(); i++)
			reEditState = (new StringBuilder(String.valueOf(reEditState))).append(editStateArray[i]).toString();

		reList.add(reState);
		reList.add(reEditState);
		return reList;
	}

	public boolean checkEditOperate(String state, String operatorType, String contno)
	{
		boolean flag = false;
		if (operatorType.equals("1"))
		{
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema lnpSch = mainInfo.getContByContNo(contno);
			if (Pattern.matches("^[0][1|2|3]{1}", state) && ("0".equals(lnpSch.getLang()) || "2".equals(lnpSch.getLang())))
				flag = true;
			if ("05".equals(state) && "2".equals(lnpSch.getAppFlag()) && "2".equals(lnpSch.getLang()))
				flag = true;
			if ("03".equals(state) && "3".equals(lnpSch.getAppFlag()) && "1".equals(lnpSch.getLang()))
				flag = true;
		} else
		if (operatorType.equals("2"))
		{
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema lnpSch = mainInfo.getContByContNo(contno);
			if (!"0".equals(lnpSch.getLang()) && !"04".equals(state))
				flag = true;
		}
		return flag;
	}

	public boolean checkContPayMentOperate(String state, String editState)
	{
		boolean flag = false;
		if (state.equals("01") && Pattern.matches("^([1]{4})[0|1]{6}[0|1]*", editState))
			flag = true;
		return flag;
	}

	public boolean checkUnderWriteOperate(String state, String editState)
	{
		boolean flag = false;
		if (state.equals("02") && Pattern.matches("^([1]{4})[0|1]{1}[1]{1}[0|1]{1}[1]{2}[0|1|2]{1}[0|1]*", editState))
			flag = true;
		return flag;
	}

	public boolean checkShowUnderWriteAnswerOperate(String contno)
	{
		boolean flag = false;
		if (contno != null && !contno.equals(""))
		{
			String queSQL = (new StringBuilder("select UWMessages from  LNPCUWMaster where contno='")).append(contno).append("' ;").toString();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = tExeSQL.execSQL(queSQL);
			if (tSSRS.MaxRow > 0)
				flag = true;
		}
		return flag;
	}

	public boolean checkSubmitFlagOperate(String state, String editState, String lnpUserType, String contno)
	{
		boolean flag = false;
		if (state.equals("03") && Pattern.matches("^([1]{6})[0|1]{1}[1]{2}[0|1]{1}[0|1]*", editState))
			flag = true;
		if ("2".equals(lnpUserType) && "05".equals(state))
			flag = true;
		if ("1".equals(lnpUserType))
		{
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema lnpSch = mainInfo.getContByContNo(contno);
			if ("05".equals(state) && "2".equals(lnpSch.getAppFlag()))
				flag = true;
		}
		return flag;
	}

	public boolean checkRepealOperate(String state)
	{
		boolean flag = false;
		if (state.equals("02") || state.equals("03") || state.equals("05"))
			flag = true;
		System.out.println((new StringBuilder("checkRepealOperate==")).append(flag).toString());
		return flag;
	}

	public String checkShowAddPremOperate(String contNo)
	{
		String flag = "0";
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema mainSch = mainInfo.getContByContNo(contNo);
		if (mainSch.getApproveFlag() == null || mainSch.getApproveFlag().trim().equals("") || mainSch.getApproveFlag().equals("0"))
			flag = "0";
		else
		if (mainSch.getApproveFlag().equals("1"))
			flag = "1";
		else
		if (mainSch.getApproveFlag().equals("2"))
			flag = "2";
		return flag;
	}

	public String updateEditStateDone(String editstate, int index)
	{
		String reEditState = (new StringBuilder(String.valueOf(editstate.substring(0, index - 1)))).append("1").append(editstate.substring(index)).toString();
		return reEditState;
	}

	public String updateEditStateUNDone(String editstate, int index)
	{
		String reEditState = (new StringBuilder(String.valueOf(editstate.substring(0, index - 1)))).append("0").append(editstate.substring(index)).toString();
		return reEditState;
	}

	public boolean afterAddInsurance(String contno)
	{
		return setBnfSc(contno);
		RuntimeException e;
		e;
		e.printStackTrace();
		return false;
	}

	public boolean afterModifyInsurance(String contno, boolean spelInfoChangeFlag, boolean ageChangeToJuvenilesFlag)
	{
		System.out.println((new StringBuilder("-- afterModifyInsurance --")).append(contno).append("--").append(spelInfoChangeFlag).append("--").append(ageChangeToJuvenilesFlag).toString());
		boolean flag;
		flag = false;
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema tempContSch = mainInfo.getContByContNo(contno);
		PubSubmit ps = new PubSubmit();
		MMap mmap = new MMap();
		BenefitPersonInfo bnfInfo = new BenefitPersonInfo();
		if (!bnfInfo.checkScBnfExist(contno))
			setBnfSc(contno);
		if (tempContSch.getAppntId() != null && !tempContSch.getAppntId().equals(""))
		{
			AppntPersonInfo appntDeal = new AppntPersonInfo();
			LNPAppntSchema checkAppntPeopleSchema = appntDeal.getAppntPeopleByContNo(contno, "");
			if (ageChangeToJuvenilesFlag)
			{
				mmap = deleteAppntByInsured(mmap, tempContSch);
				tempContSch.setAppntId("");
				tempContSch.setAppntNo("");
				tempContSch.setAppntName("");
				tempContSch.setAppntBirthday("");
				tempContSch.setAppntIDType("");
				tempContSch.setAppntIDNo("");
				tempContSch.setEditstate(updateEditStateUNDone(tempContSch.getEditstate(), 3));
			}
			if (checkAppntPeopleSchema.getRelationToInsured().equals("0"))
			{
				mmap = updateAppntByInsured(mmap, tempContSch);
				InsuredPersonInfo insuredDeal = new InsuredPersonInfo();
				LNPInsuredSchema insuredSch = insuredDeal.getInsuPeopleByContNo(tempContSch.getContNo(), tempContSch.getInsuredId());
				tempContSch.setAppntName(insuredSch.getName());
				tempContSch.setAppntBirthday(insuredSch.getBirthday());
				tempContSch.setAppntIDType(insuredSch.getIDType());
				tempContSch.setAppntIDNo(insuredSch.getIDNo());
				List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "modify", "03");
				tempContSch.setState((String)stateList.get(0));
				tempContSch.setEditstate((String)stateList.get(1));
			}
		}
		BenefitPersonInfo bnfDeal = new BenefitPersonInfo();
		if (bnfDeal.checkScBnfExist(contno))
		{
			mmap = modifyBnfSc(mmap, tempContSch.getContNo());
			List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "add", "06");
			tempContSch.setState((String)stateList.get(0));
			tempContSch.setEditstate((String)stateList.get(1));
		}
		if (spelInfoChangeFlag)
		{
			LNPPolDB db = new LNPPolDB();
			db.setContNo(contno);
			LNPPolSet polSet = db.query();
			if (polSet != null)
			{
				mmap.put(polSet, "DELETE");
				tempContSch.setPrem(0.0D);
				tempContSch.setMult(0.0D);
				tempContSch.setSumPrem(0.0D);
				tempContSch.setAmnt(0.0D);
				List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "delete", "04");
				tempContSch.setState((String)stateList.get(0));
				tempContSch.setEditstate((String)stateList.get(1));
			}
		}
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		tempContSch.setModifyDate(date);
		tempContSch.setModifyTime(time);
		mmap.put(tempContSch, "UPDATE");
		VData vd = new VData();
		vd = new VData();
		vd.add(mmap);
		if (ps.submitData(vd, ""))
			flag = true;
		System.out.println((new StringBuilder("-- afterModifyInsurance endflag--")).append(flag).toString());
		return flag;
		RuntimeException e;
		e;
		return false;
	}

	private MMap deleteAppntByInsured(MMap mmap, LNPContSchema lnpContSch)
	{
		String deleteContNo = lnpContSch.getContNo();
		AppntPersonInfo appntDeal = new AppntPersonInfo();
		LNPAppntSchema deleteAppntPeopleSchema = appntDeal.getAppntPeopleByContNo(deleteContNo, "");
		if (deleteAppntPeopleSchema == null || deleteAppntPeopleSchema == null)
			break MISSING_BLOCK_LABEL_48;
		mmap.put(deleteAppntPeopleSchema, "DELETE");
		return mmap;
		RuntimeException e;
		e;
		return mmap;
		return mmap;
	}

	private MMap deleteRiskInfo(MMap mmap, String contno)
	{
		LNPPolDB db = new LNPPolDB();
		db.setContNo(contno);
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema tempContSch = mainInfo.getContByContNo(contno);
		tempContSch.setPrem(0.0D);
		tempContSch.setMult(0.0D);
		tempContSch.setSumPrem(0.0D);
		tempContSch.setAmnt(0.0D);
		List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "delete", "04");
		tempContSch.setState((String)stateList.get(0));
		tempContSch.setEditstate((String)stateList.get(1));
		LNPPolSet polSet = db.query();
		if (polSet != null)
		{
			mmap.put(polSet, "DELETE");
			mmap.put(tempContSch, "UPDATE");
		}
		return mmap;
	}

	public boolean setBnfSc(String contno)
	{
		boolean flag = false;
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		IGlobalInput tempGInew = (IGlobalInput)session.getValue("NPGI");
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema tempContSch = mainInfo.getContByContNo(contno);
		try
		{
			if (tempContSch != null && tempContSch.getInsuredId() != null && !tempContSch.getInsuredId().equals(""))
			{
				PersonFunction pf = new PersonFunction();
				LNPPersonSchema personSch = pf.getLnpPersonByCustomerId(tempContSch.getInsuredId());
				if (personSch != null)
				{
					LNPBnfSchema bnfSch = new LNPBnfSchema();
					bnfSch.setContNo(contno);
					bnfSch.setInsuredId(personSch.getCustomerId());
					bnfSch.setBenefitType("1");
					bnfSch.setBenefitRate("100");
					bnfSch.setBenefitOrder("1");
					bnfSch.setBnfId(personSch.getCustomerId());
					bnfSch.setBnfName(personSch.getName());
					bnfSch.setBnfSex(personSch.getSex());
					bnfSch.setBnfBirthday(personSch.getBirthday());
					bnfSch.setBnfAge(personSch.getAge());
					bnfSch.setRelationToInsured("0");
					bnfSch.setIDType(personSch.getIDType());
					bnfSch.setIDNo(personSch.getIDNo());
					bnfSch.setNativePlace(personSch.getNativePlace());
					bnfSch.setMarriage(personSch.getMarriage());
					bnfSch.setOccupationCode(personSch.getOccupationCode());
					bnfSch.setOperator(tempGInew.Operator);
					bnfSch.setManageCom(tempGInew.ComCode);
					bnfSch.setMakeDate(date);
					bnfSch.setMakeTime(time);
					bnfSch.setModifyDate(date);
					bnfSch.setModifyTime(time);
					List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "add", "06");
					tempContSch.setState((String)stateList.get(0));
					tempContSch.setEditstate((String)stateList.get(1));
					tempContSch.setModifyDate(date);
					tempContSch.setModifyTime(time);
					PubSubmit ps = new PubSubmit();
					MMap map = new MMap();
					map.put(bnfSch, "INSERT");
					map.put(tempContSch, "UPDATE");
					VData vd = new VData();
					vd.add(map);
					if (!ps.submitData(vd, ""))
						System.out.println("-BenefitPersonInfo-ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿?");
					else
						flag = true;
				}
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public MMap updateAppntByInsured(MMap mmap, LNPContSchema lnpContSch)
	{
		String date;
		String time;
		LNPInsuredSchema insuredSch;
		LNPAddressSchema insuredAddSch;
		LNPAppntSchema modifyAppntPeopleSchema;
		LNPAddressSchema modifylnpAddressSchema;
		LNPPersonSchema modifylnpPersonSchema;
		date = PubFun.getCurrentDate();
		time = PubFun.getCurrentTime();
		PersonFunction pf = new PersonFunction();
		String midifyContNo = lnpContSch.getContNo();
		String midifyAppntId = lnpContSch.getAppntId();
		InsuredPersonInfo insuredDeal = new InsuredPersonInfo();
		insuredSch = insuredDeal.getInsuPeopleByContNo(lnpContSch.getContNo(), lnpContSch.getInsuredId());
		insuredAddSch = pf.getLnpAddrByCustomerId(lnpContSch.getInsuredId());
		AppntPersonInfo appntDeal = new AppntPersonInfo();
		modifyAppntPeopleSchema = appntDeal.getAppntPeopleByContNo(midifyContNo, "");
		modifylnpAddressSchema = pf.getLnpAddrByCustomerId(midifyAppntId);
		modifylnpPersonSchema = pf.getLnpPersonByCustomerId(midifyAppntId);
		if (insuredSch == null || insuredSch.getAppAgeType() == null || !"Y".equals(insuredSch.getAppAgeType()) || 16 < insuredSch.getAppAge())
			break MISSING_BLOCK_LABEL_229;
		lnpContSch.setAppntId("");
		lnpContSch.setAppntNo("");
		lnpContSch.setAppntName("");
		lnpContSch.setAppntBirthday("");
		lnpContSch.setAppntIDType("");
		lnpContSch.setAppntIDNo("");
		lnpContSch.setEditstate(updateEditStateUNDone(lnpContSch.getEditstate(), 3));
		lnpContSch.setModifyDate(date);
		lnpContSch.setModifyTime(time);
		mmap.put(modifyAppntPeopleSchema, "DELETE");
		mmap.put(modifylnpAddressSchema, "DELETE");
		mmap.put(modifylnpPersonSchema, "DELETE");
		return mmap;
		try
		{
			if (modifyAppntPeopleSchema != null && modifylnpAddressSchema != null && modifylnpPersonSchema != null)
			{
				modifyAppntPeopleSchema.setAppntName(insuredSch.getName());
				modifyAppntPeopleSchema.setAppntSex(insuredSch.getSex());
				modifyAppntPeopleSchema.setAppntBirthday(insuredSch.getBirthday());
				modifyAppntPeopleSchema.setAppntAge(insuredSch.getAppAge());
				modifyAppntPeopleSchema.setAppntAgeType(insuredSch.getAppAgeType());
				modifyAppntPeopleSchema.setIDPerpetual(insuredSch.getIDPerpetual());
				modifyAppntPeopleSchema.setIDValidity(insuredSch.getIDValidity());
				modifyAppntPeopleSchema.setIDType(insuredSch.getIDType());
				modifyAppntPeopleSchema.setIDNo(insuredSch.getIDNo());
				modifyAppntPeopleSchema.setNativePlace(insuredSch.getNativePlace());
				modifyAppntPeopleSchema.setMarriage(insuredSch.getMarriage());
				modifyAppntPeopleSchema.setOccupationCode(insuredSch.getOccupationCode());
				modifyAppntPeopleSchema.setModifyDate(date);
				modifyAppntPeopleSchema.setModifyTime(time);
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
				modifylnpAddressSchema.setPostalAddress(insuredAddSch.getPostalAddress());
				modifylnpAddressSchema.setZipCode(insuredAddSch.getZipCode());
				modifylnpAddressSchema.setPhone(insuredAddSch.getPhone());
				modifylnpAddressSchema.setHomeAddress(insuredAddSch.getHomeAddress());
				modifylnpAddressSchema.setHomeZipCode(insuredAddSch.getHomeZipCode());
				modifylnpAddressSchema.setHomePhone(insuredAddSch.getHomePhone());
				modifylnpAddressSchema.setCompanyAddress(insuredAddSch.getCompanyAddress());
				modifylnpAddressSchema.setCompanyPhone(insuredAddSch.getCompanyPhone());
				modifylnpAddressSchema.setCompanyMail(insuredAddSch.getCompanyMail());
				modifylnpAddressSchema.setGrpName(insuredAddSch.getGrpName());
				modifylnpAddressSchema.setCompanyZipCode(insuredAddSch.getCompanyZipCode());
				modifylnpAddressSchema.setDuchy(insuredAddSch.getDuchy());
				modifylnpAddressSchema.setOtherDuchy(insuredAddSch.getOtherDuchy() == null ? "" : insuredAddSch.getOtherDuchy());
				modifylnpAddressSchema.setModifyDate(date);
				modifylnpAddressSchema.setModifyTime(time);
				lnpContSch.setAppntName(insuredSch.getName());
				lnpContSch.setAppntBirthday(insuredSch.getBirthday());
				lnpContSch.setAppntIDType(insuredSch.getIDType());
				lnpContSch.setAppntIDNo(insuredSch.getIDNo());
				StateOperatorDeal operatorDeal = new StateOperatorDeal();
				List stateList = operatorDeal.infoOperate(lnpContSch.getState(), lnpContSch.getEditstate(), "modify", "03");
				lnpContSch.setState((String)stateList.get(0));
				lnpContSch.setEditstate((String)stateList.get(1));
				lnpContSch.setModifyDate(date);
				lnpContSch.setModifyTime(time);
				mmap.put(modifyAppntPeopleSchema, "UPDATE");
				mmap.put(modifylnpPersonSchema, "UPDATE");
				mmap.put(modifylnpAddressSchema, "UPDATE");
			}
		}
		catch (RuntimeException e)
		{
			return mmap;
		}
		return mmap;
	}

	public MMap modifyBnfSc(MMap mmap, String contno)
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		IGlobalInput tempGInew = (IGlobalInput)session.getValue("NPGI");
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema tempContSch = mainInfo.getContByContNo(contno);
		BenefitPersonInfo bnfDeal = new BenefitPersonInfo();
		LNPBnfSchema modifySch = bnfDeal.getBnfSgSchByBnfId(contno, "", "1");
		try
		{
			if (tempContSch != null && tempContSch.getInsuredId() != null && !tempContSch.getInsuredId().equals(""))
			{
				PersonFunction pf = new PersonFunction();
				LNPPersonSchema personSch = pf.getLnpPersonByCustomerId(tempContSch.getInsuredId());
				if (personSch != null)
				{
					modifySch.setBnfId(personSch.getCustomerId());
					modifySch.setBnfName(personSch.getName());
					modifySch.setBnfSex(personSch.getSex());
					modifySch.setBnfBirthday(personSch.getBirthday());
					modifySch.setBnfAge(personSch.getAge());
					modifySch.setIDType(personSch.getIDType());
					modifySch.setIDNo(personSch.getIDNo());
					modifySch.setNativePlace(personSch.getNativePlace());
					modifySch.setMarriage(personSch.getMarriage());
					modifySch.setOccupationCode(personSch.getOccupationCode());
					modifySch.setOperator(tempGInew.Operator);
					modifySch.setManageCom(tempGInew.ComCode);
					modifySch.setModifyDate(date);
					modifySch.setModifyTime(time);
					StateOperatorDeal operatorDeal = new StateOperatorDeal();
					List stateList = operatorDeal.infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "add", "06");
					tempContSch.setState((String)stateList.get(0));
					tempContSch.setEditstate((String)stateList.get(1));
					tempContSch.setModifyDate(date);
					tempContSch.setModifyTime(time);
					mmap.put(modifySch, "UPDATE");
				}
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return mmap;
	}

	public boolean afterModifyAppnt(String contNo, boolean b)
	{
		boolean flag = false;
		try
		{
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema tempContSch = mainInfo.getContByContNo(contNo);
			if (b && (tempContSch.getState().equals("03") || tempContSch.getState().equals("05")))
				tempContSch.setState("02");
			if (hasExistRiskWithContNo(contNo))
				tempContSch.setEditstate(updateEditStateDone(tempContSch.getEditstate(), 4));
			if (riskBounsExist(tempContSch.getContNo()))
				tempContSch.setEditstate(updateEditStateDone(tempContSch.getEditstate(), 5));
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(tempContSch, "UPDATE");
			VData vd = new VData();
			vd = new VData();
			vd.add(map);
			if (ps.submitData(vd, ""))
				flag = true;
			System.out.println((new StringBuilder("-- afterModifyAppnt endflag--")).append(flag).toString());
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	private boolean riskBounsExist(String contNo)
	{
		String sql = (new StringBuilder("select bonustype from lnpriskconfig  where riskcode = (select riskcode from lnppol where contno='")).append(contNo).append("' and masterpolno =polno);").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		return tSSRS != null && tSSRS.MaxRow != 0 && tSSRS.GetText(1, 1) != null && !tSSRS.GetText(1, 1).trim().equals("");
	}

	public boolean afterModifyMainInfo(String contNo)
	{
		boolean flag = false;
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		PubSubmit ps = new PubSubmit();
		MMap map = new MMap();
		try
		{
			PolicyMainInfo maininfo = new PolicyMainInfo();
			LNPContSchema lnpcont = maininfo.getContByContNo(contNo);
			if (lnpcont != null && lnpcont.getInsuredId() != null && !lnpcont.getInsuredId().equals(""))
				map = updateInsuredAge(map, lnpcont);
			if (lnpcont != null && lnpcont.getAppntId() != null && !lnpcont.getAppntId().equals(""))
				map = updateAppntAge(map, lnpcont);
			LNPPolDB db = new LNPPolDB();
			db.setContNo(lnpcont.getContNo());
			LNPPolSet polSet = db.query();
			if (polSet != null && polSet.size() > 0)
			{
				for (int i = 1; i <= polSet.size(); i++)
				{
					LNPPolSchema polsch = polSet.get(i);
					polsch.setPrem(0.0D);
					map.put(polsch, "UPDATE");
				}

				lnpcont.setPrem(0.0D);
				lnpcont.setMult(0.0D);
				lnpcont.setSumPrem(0.0D);
				lnpcont.setAmnt(0.0D);
				List stateList = infoOperate(lnpcont.getState(), lnpcont.getEditstate(), "modify", "04");
				lnpcont.setState((String)stateList.get(0));
				lnpcont.setEditstate((String)stateList.get(1));
				map.put(lnpcont, "UPDATE");
			}
			VData vd = new VData();
			vd = new VData();
			vd.add(map);
			if (ps.submitData(vd, ""))
				flag = true;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	private MMap updateAppntAge(MMap map, LNPContSchema lnpcont)
	{
		AppntPersonInfo appnt = new AppntPersonInfo();
		LNPAppntSchema appntSch = appnt.getAppntPeopleByContNo(lnpcont.getContNo(), lnpcont.getAppntId());
		if (appntSch != null)
		{
			String agePer = LNPPubFun.getAgeByBirthdayNew(appntSch.getAppntBirthday(), lnpcont.getPValiDate());
			if (!agePer.equals("-1"))
			{
				String ageType;
				if (agePer.indexOf("ï¿½ï¿½") > -1)
				{
					ageType = "D";
					agePer = agePer.substring(0, agePer.indexOf("ï¿½ï¿½"));
					appntSch.setAppntAge(agePer);
					appntSch.setAppntAgeType(ageType);
				} else
				{
					ageType = "Y";
					agePer = agePer.substring(0, agePer.indexOf("ï¿½ï¿½"));
					appntSch.setAppntAge(agePer);
					appntSch.setAppntAgeType(ageType);
				}
				PersonFunction pf = new PersonFunction();
				LNPPersonSchema lnpPersonSchema = pf.getLnpPersonByCustomerId(lnpcont.getAppntId());
				if (lnpPersonSchema != null)
				{
					lnpPersonSchema.setAge(agePer);
					lnpPersonSchema.setAgeType(ageType);
					map.put(lnpPersonSchema, "UPDATE");
				}
			}
			map.put(appntSch, "UPDATE");
		}
		return map;
	}

	private MMap updateInsuredAge(MMap map, LNPContSchema lnpcont)
	{
		InsuredPersonInfo insured = new InsuredPersonInfo();
		LNPInsuredSchema insuredSch = insured.getInsuPeopleByContNo(lnpcont.getContNo(), lnpcont.getInsuredId());
		LNPInsuredSchema tmpinsuredSch = insuredSch;
		if (insuredSch != null)
		{
			String agePer = LNPPubFun.getAgeByBirthdayNew(insuredSch.getBirthday(), lnpcont.getPValiDate());
			if (!agePer.equals("-1"))
			{
				String ageType;
				if (agePer.indexOf("ï¿½ï¿½") > -1)
				{
					ageType = "D";
					agePer = agePer.substring(0, agePer.indexOf("ï¿½ï¿½"));
					insuredSch.setAppAge(agePer);
					insuredSch.setAppAgeType(ageType);
				} else
				{
					ageType = "Y";
					agePer = agePer.substring(0, agePer.indexOf("ï¿½ï¿½"));
					insuredSch.setAppAge(agePer);
					insuredSch.setAppAgeType(ageType);
				}
				PersonFunction pf = new PersonFunction();
				LNPPersonSchema lnpPersonSchema = pf.getLnpPersonByCustomerId(lnpcont.getInsuredId());
				if (lnpPersonSchema != null)
				{
					lnpPersonSchema.setAge(agePer);
					lnpPersonSchema.setAgeType(ageType);
					map.put(lnpPersonSchema, "UPDATE");
				}
			}
			map.put(insuredSch, "UPDATE");
			ageChangeToJuvenilesFlag = checkAgeChangeToJuveniles(tmpinsuredSch, insuredSch.getAppAge(), insuredSch.getAppAgeType());
		}
		return map;
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
		if ("Y".equals(tempmodifyInsuPeopleSchema.getAppAgeType()))
			if (tempmodifyInsuPeopleSchema.getAppAge() >= 16)
			{
				if (("D".equals(appAgeType) || "Y".equals(appAgeType) && appAge < 16) && "0".equals(relationToInsured))
					flag = true;
				else
				if (("D".equals(appAgeType) || "Y".equals(appAgeType) && appAge < 10) && !"5".equals(relationToInsured) && !"6".equals(relationToInsured))
					flag = true;
			} else
			if ((tempmodifyInsuPeopleSchema.getAppAge() < 16 || tempmodifyInsuPeopleSchema.getAppAge() >= 10) && !"5".equals(relationToInsured) && !"6".equals(relationToInsured) && ("D".equals(appAgeType) || "Y".equals(appAgeType) && appAge < 10))
				flag = true;
		return flag;
	}

	private boolean hasExistRiskWithContNo(String cno)
	{
		boolean flag = false;
		String sql = (new StringBuilder("select * from lnppol where contno = '")).append(cno).append("' ").toString();
		ExeSQL tExESQL = new ExeSQL();
		SSRS tSSRS = tExESQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
			flag = true;
		return flag;
	}
}
