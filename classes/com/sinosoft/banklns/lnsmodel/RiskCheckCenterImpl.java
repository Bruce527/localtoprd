// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RiskCheckCenterImpl.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.lnsmodel.util.InsuError;
import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
import com.sinosoft.banklns.lnsmodel.util.RiskError;
import com.sinosoft.banklns.lnsmodel.util.SugError;
import com.sinosoft.banklns.utility.*;
import java.util.*;
import org.apache.log4j.Logger;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			CalSpecialRulesElementsImpl, RiskPolImpl, SpecialRiskRulesImpl

public class RiskCheckCenterImpl
{

	private EvalJavaTool evalJavaTool;
	private CalSpecialRulesElementsImpl calSpecialRulesElementsImpl;
	private RiskPolImpl riskPolImpl;
	private Logger logger;

	public RiskCheckCenterImpl()
	{
		evalJavaTool = new EvalJavaTool();
		calSpecialRulesElementsImpl = new CalSpecialRulesElementsImpl();
		riskPolImpl = new RiskPolImpl();
		logger = Logger.getLogger(com/sinosoft/banklns/lnsmodel/RiskCheckCenterImpl);
	}

	public SugError checkForOneInsu(String contNo, String insuredId, IGlobalInput tGlobalInput, String flag)
	{
		String sql = (new StringBuilder("select * from lnppol where polno=masterpolno and contNo='")).append(contNo).append("' and insuredId='").append(insuredId).append("'").toString();
		LNPPolDB reLNPPolDB = new LNPPolDB();
		LNPPolSet reLNPPolSet = reLNPPolDB.executeQuery(sql);
		SugError reSugError = new SugError();
		for (int i = 1; reLNPPolSet != null && i <= reLNPPolSet.size(); i++)
		{
			LNPPolSchema tLNPPolSchema = reLNPPolSet.get(i);
			SugError tempSugError = checkForOnePol(tLNPPolSchema.getPolNo(), tGlobalInput, flag);
			if (tempSugError.hasError())
				if (reSugError.hasError())
				{
					InsuError insuError = (InsuError)reSugError.getInsuErrorList().get(0);
					List riskError = ((InsuError)tempSugError.getInsuErrorList().get(0)).getRiskErrorList();
					for (int j = 0; riskError != null && j < riskError.size(); j++)
						insuError.addRiskError((RiskError)riskError.get(j));

				} else
				{
					InsuError insuError = (InsuError)tempSugError.getInsuErrorList().get(0);
					reSugError.addInsuError(insuError);
				}
		}

		LNPContSchema reLNPContSchema = new LNPContSchema();
		reLNPContSchema.setContNo(contNo);
		reSugError.setSugInfo(reLNPContSchema);
		return reSugError;
	}

	public SugError checkForOnePol(String mainPolNo, IGlobalInput tGlobalInput, String flagStr)
	{
		List list = riskPolImpl.getPolList(mainPolNo, 1);
		List polList = (List)list.get(1);
		SugError reSugError = new SugError();
		InsuError reInsuError = new InsuError();
		String contNO = "";
		boolean flag = true;
		for (int i = 0; polList != null && i < polList.size(); i++)
		{
			LNPPolSchema remLNPPolSchema = (LNPPolSchema)polList.get(i);
			contNO = remLNPPolSchema.getContNo();
			PolElementSchema rePolElementSchema = initPolElementSchemaInfo(remLNPPolSchema.getPolNo(), tGlobalInput);
			rePolElementSchema = calSumRiskAmnt(rePolElementSchema);
			List reusltList = new ArrayList();
			List list_1 = checkSexAndAge(rePolElementSchema);
			List list_2 = checkOccupationAndPrem(rePolElementSchema);
			List list_3 = checkRiskSpecialRules(rePolElementSchema);
			List list_4 = checkCommonRules(rePolElementSchema);
			List list_5 = checkSpecialRules(rePolElementSchema);
			RiskError reRiskError = new RiskError();
			if (list_1 != null && list_1.size() > 0)
				reusltList.addAll(list_1);
			if (list_2 != null && list_2.size() > 0)
				reusltList.addAll(list_2);
			if (list_3 != null && list_3.size() > 0)
				reusltList.addAll(list_3);
			if (list_4 != null && list_4.size() > 0)
				reusltList.addAll(list_4);
			if (list_5 != null && list_5.size() > 0)
				reusltList.addAll(list_5);
			if ("FINAL".equals(flagStr))
			{
				List list_6 = finalCheckForALl(rePolElementSchema);
				if (list_6 != null && list_6.size() > 0)
					reusltList.addAll(list_6);
			}
			if ("SUBMIT".equals(flagStr))
			{
				List list_7 = submitAgentCheckForALl(rePolElementSchema);
				if (list_7 != null && list_7.size() > 0)
					reusltList.addAll(list_7);
			}
			if ("SUBMITOPER".equals(flagStr))
			{
				List list_7 = submitOperCheckForALl(rePolElementSchema);
				if (list_7 != null && list_7.size() > 0)
					reusltList.addAll(list_7);
			}
			if (reusltList != null && reusltList.size() > 0)
			{
				reRiskError.setRiskInfo(rePolElementSchema.getRiskCode());
				reRiskError.addError(reusltList);
				reInsuError.setInsuInfo(rePolElementSchema.getContNo(), rePolElementSchema.getInsuredId());
				reInsuError.addRiskError(reRiskError);
				flag = false;
			}
		}

		if (!flag)
		{
			LNPContSchema reLNPContSchema = new LNPContSchema();
			reLNPContSchema.setContNo(contNO);
			reSugError.setSugInfo(reLNPContSchema);
			reSugError.addInsuError(reInsuError);
		}
		return reSugError;
	}

	public SugError checkForOneRisk(String polNo, IGlobalInput tGlobalInput)
	{
		PolElementSchema rePolElementSchema = initPolElementSchemaInfo(polNo, tGlobalInput);
		rePolElementSchema = calSumRiskAmnt(rePolElementSchema);
		List reusltList = new ArrayList();
		List list_1 = checkSexAndAge(rePolElementSchema);
		List list_2 = checkOccupationAndPrem(rePolElementSchema);
		List list_3 = checkRiskSpecialRules(rePolElementSchema);
		List list_4 = checkCommonRules(rePolElementSchema);
		List list_5 = checkSpecialRules(rePolElementSchema);
		SugError reSugError = new SugError();
		InsuError reInsuError = new InsuError();
		RiskError reRiskError = new RiskError();
		if (list_1 != null && list_1.size() > 0)
			reusltList.addAll(list_1);
		if (list_2 != null && list_2.size() > 0)
			reusltList.addAll(list_2);
		if (list_3 != null && list_3.size() > 0)
			reusltList.addAll(list_3);
		if (list_4 != null && list_4.size() > 0)
			reusltList.addAll(list_4);
		if (list_5 != null && list_5.size() > 0)
			reusltList.addAll(list_5);
		if (reusltList != null && reusltList.size() > 0)
		{
			reRiskError.setRiskInfo(rePolElementSchema.getRiskCode());
			reRiskError.addError(reusltList);
			reInsuError.setInsuInfo(rePolElementSchema.getContNo(), rePolElementSchema.getInsuredId());
			reInsuError.addRiskError(reRiskError);
			LNPContSchema reLNPContSchema = new LNPContSchema();
			reLNPContSchema.setContNo(rePolElementSchema.getContNo());
			reSugError.setSugInfo(reLNPContSchema);
			reSugError.addInsuError(reInsuError);
		}
		return reSugError;
	}

	public SugError checkForOneSug(String contNo, IGlobalInput tGlobalInput)
	{
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(contNo);
		LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
		SugError reSugError = new SugError();
		for (int i = 1; reLNPInsuredSet != null && i <= reLNPInsuredSet.size(); i++)
		{
			LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
			SugError tempSugError = checkForOneInsu(contNo, reLNPInsuredSchema.getInsuredId(), tGlobalInput, "FINAL");
			if (tempSugError.hasError())
				reSugError.addInsuError((InsuError)tempSugError.getInsuErrorList().get(0));
		}

		LNPContSchema reLNPContSchema = new LNPContSchema();
		reLNPContSchema.setContNo(contNo);
		reSugError.setSugInfo(reLNPContSchema);
		return reSugError;
	}

	public SugError checkOnePolAfterCal(String contNo, IGlobalInput tGlobalInput)
	{
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(contNo);
		LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
		SugError reSugError = new SugError();
		for (int i = 1; reLNPInsuredSet != null && i <= reLNPInsuredSet.size(); i++)
		{
			LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
			SugError tempSugError = checkForOneInsu(contNo, reLNPInsuredSchema.getInsuredId(), tGlobalInput, "FINAL");
			if (tempSugError.hasError())
				reSugError.addInsuError((InsuError)tempSugError.getInsuErrorList().get(0));
		}

		LNPContSchema reLNPContSchema = new LNPContSchema();
		reLNPContSchema.setContNo(contNo);
		reSugError.setSugInfo(reLNPContSchema);
		return reSugError;
	}

	public SugError checkOnePolBeforeSubmitAgent(String contNo, IGlobalInput tGlobalInput)
	{
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(contNo);
		LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
		SugError reSugError = new SugError();
		for (int i = 1; reLNPInsuredSet != null && i <= reLNPInsuredSet.size(); i++)
		{
			LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
			SugError tempSugError = checkForOneInsu(contNo, reLNPInsuredSchema.getInsuredId(), tGlobalInput, "SUBMIT");
			if (tempSugError.hasError())
				reSugError.addInsuError((InsuError)tempSugError.getInsuErrorList().get(0));
		}

		LNPContSchema reLNPContSchema = new LNPContSchema();
		reLNPContSchema.setContNo(contNo);
		reSugError.setSugInfo(reLNPContSchema);
		return reSugError;
	}

	public SugError checkOnePolBeforeSubmitOperator(String contNo, IGlobalInput tGlobalInput)
	{
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(contNo);
		LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
		SugError reSugError = new SugError();
		for (int i = 1; reLNPInsuredSet != null && i <= reLNPInsuredSet.size(); i++)
		{
			LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
			SugError tempSugError = checkForOneInsu(contNo, reLNPInsuredSchema.getInsuredId(), tGlobalInput, "SUBMITOPER");
			if (tempSugError.hasError())
				reSugError.addInsuError((InsuError)tempSugError.getInsuErrorList().get(0));
		}

		LNPContSchema reLNPContSchema = new LNPContSchema();
		reLNPContSchema.setContNo(contNo);
		reSugError.setSugInfo(reLNPContSchema);
		return reSugError;
	}

	private List checkSexAndAge(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		LNPRiskRoleDB eeLNPRiskRoleDB = new LNPRiskRoleDB();
		eeLNPRiskRoleDB.setRiskCode(inPolElementSchema.getRiskCode());
		eeLNPRiskRoleDB.setRiskRole("00");
		LNPRiskRoleSet reLNPRiskRoleSet = eeLNPRiskRoleDB.query();
		if (reLNPRiskRoleSet != null && reLNPRiskRoleSet.size() > 0)
		{
			LNPRiskRoleSchema tempLNPRiskRoleSchema = reLNPRiskRoleSet.get(1);
			LNPAppntDB reLNPAppntDB = new LNPAppntDB();
			reLNPAppntDB.setContNo(inPolElementSchema.getContNo());
			reLNPAppntDB.getInfo();
			String birthday = reLNPAppntDB.getAppntBirthday();
			String agetype = reLNPAppntDB.getAppntAgeType();
			int age = reLNPAppntDB.getAppntAge();
			String sex = reLNPAppntDB.getAppntSex();
			String reSex = tempLNPRiskRoleSchema.getRiskRoleSex();
			if (!reSex.equals("2") && !reSex.equals(sex))
				errorList.add("Ͷ���˵��Ա������ֵ��ض���Ҫ��");
			String MinAppAgeFlag = tempLNPRiskRoleSchema.getMinAppAgeFlag();
			int minappAge = tempLNPRiskRoleSchema.getMinAppAge();
			if (MinAppAgeFlag != null && MinAppAgeFlag.equals("Y"))
			{
				if ("Y".equals(agetype))
				{
					if (minappAge > age)
						errorList.add((new StringBuilder("Ͷ���˵�����[")).append(age).append("��]С������Ҫ�����С����[").append(minappAge).append("��]��").toString());
				} else
				if ("D".equals(agetype))
					errorList.add((new StringBuilder("Ͷ���˵�����[")).append(age).append("��]С������Ҫ�����С����[").append(minappAge).append("��]��").toString());
			} else
			if (MinAppAgeFlag != null && birthday != null && birthday.length() > 0 && !"Y".equals(agetype) && "D".equals(agetype))
			{
				String flag = tempLNPRiskRoleSchema.getMinAppAgeFlag();
				if (flag.equals("D") && minappAge > age)
					errorList.add((new StringBuilder("Ͷ���˵�����[")).append(age).append("��").append("]С������Ҫ�����С����[").append(minappAge).append("��").append("]��").toString());
			}
			String MAXAppAgeFlag = tempLNPRiskRoleSchema.getMAXAppAgeFlag();
			int MAXAppAge = tempLNPRiskRoleSchema.getMAXAppAge();
			if (MAXAppAgeFlag != null && MAXAppAgeFlag.equals("Y"))
			{
				if ("Y".equals(agetype))
				{
					if (MAXAppAge < age)
						errorList.add((new StringBuilder("Ͷ���˵�����[")).append(age).append("��]��������Ҫ����������[").append(MAXAppAge).append("��]��").toString());
				} else
				{
					"D".equals(agetype);
				}
			} else
			if (MAXAppAgeFlag != null && birthday != null && birthday.length() > 0)
				if ("Y".equals(agetype))
					errorList.add((new StringBuilder("Ͷ���˵�����[")).append(age).append("��]��������Ҫ����������[").append(MAXAppAge).append("��]��").toString());
				else
				if ("D".equals(agetype))
				{
					String flag = tempLNPRiskRoleSchema.getMAXAppAgeFlag();
					if (flag.equals("D") && MAXAppAge < age)
						errorList.add((new StringBuilder("Ͷ���˵�����[")).append(age).append("��").append("]��������Ҫ����������[").append(minappAge).append("��").append("]��").toString());
				}
		}
		eeLNPRiskRoleDB = new LNPRiskRoleDB();
		eeLNPRiskRoleDB.setRiskCode(inPolElementSchema.getRiskCode());
		eeLNPRiskRoleDB.setRiskRole("01");
		reLNPRiskRoleSet = eeLNPRiskRoleDB.query();
		if (reLNPRiskRoleSet != null && reLNPRiskRoleSet.size() > 0)
		{
			LNPRiskRoleSchema tempLNPRiskRoleSchema = reLNPRiskRoleSet.get(1);
			LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
			reLNPInsuredDB.setContNo(inPolElementSchema.getContNo());
			reLNPInsuredDB.setInsuredId(inPolElementSchema.getInsuredId());
			reLNPInsuredDB.getInfo();
			String birthday = reLNPInsuredDB.getBirthday();
			String agetype = reLNPInsuredDB.getAppAgeType();
			int age = reLNPInsuredDB.getAppAge();
			String sex = reLNPInsuredDB.getSex();
			String reSex = tempLNPRiskRoleSchema.getRiskRoleSex();
			if (!reSex.equals("2") && !reSex.equals(sex))
				errorList.add("�����˵��Ա������ֵ��ض���Ҫ��");
			String MinAppAgeFlag = tempLNPRiskRoleSchema.getMinAppAgeFlag();
			int minappAge = tempLNPRiskRoleSchema.getMinAppAge();
			if (MinAppAgeFlag != null && MinAppAgeFlag.equals("Y"))
			{
				if ("Y".equals(agetype))
				{
					if (minappAge > age)
						errorList.add((new StringBuilder("�����˵�����[")).append(age).append("��]С������Ҫ�����С����[").append(minappAge).append("��]��").toString());
				} else
				if ("D".equals(agetype))
					errorList.add((new StringBuilder("�����˵�����[")).append(age).append("��]С������Ҫ�����С����[").append(minappAge).append("��]��").toString());
			} else
			if (MinAppAgeFlag != null && birthday != null && birthday.length() > 0 && !"Y".equals(agetype) && "D".equals(agetype))
			{
				String flag = tempLNPRiskRoleSchema.getMinAppAgeFlag();
				if (flag.equals("D") && minappAge > age)
					errorList.add((new StringBuilder("�����˵�����[")).append(age).append("��").append("]С������Ҫ�����С����[").append(minappAge).append("��").append("]��").toString());
			}
			String MAXAppAgeFlag = tempLNPRiskRoleSchema.getMAXAppAgeFlag();
			int MAXAppAge = tempLNPRiskRoleSchema.getMAXAppAge();
			if (MAXAppAgeFlag != null && MAXAppAgeFlag.equals("Y"))
			{
				if ("Y".equals(agetype))
				{
					if (MAXAppAge < age)
						errorList.add((new StringBuilder("�����˵�����[")).append(age).append("��]��������Ҫ����������[").append(MAXAppAge).append("��]��").toString());
				} else
				{
					"D".equals(agetype);
				}
			} else
			if (MAXAppAgeFlag != null && birthday != null && birthday.length() > 0)
				if ("Y".equals(agetype))
					errorList.add((new StringBuilder("�����˵�����[")).append(age).append("��]��������Ҫ����������[").append(MAXAppAge).append("��]��").toString());
				else
				if ("D".equals(agetype))
				{
					String flag = tempLNPRiskRoleSchema.getMAXAppAgeFlag();
					if (flag.equals("D") && MAXAppAge < age)
						errorList.add((new StringBuilder("�����˵�����[")).append(age).append("��").append("]��������Ҫ����������[").append(minappAge).append("��").append("]��").toString());
				}
		}
		return errorList;
	}

	private List checkOccupationAndPrem(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		String occupationcode = inPolElementSchema.getOccupationCode();
		String riskcode = inPolElementSchema.getRiskCode();
		LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
		reLNPRiskAppDB.setRiskCode(riskcode);
		reLNPRiskAppDB.getInfo();
		String risktype = reLNPRiskAppDB.getRiskType();
		String occupationType = null;
		LNPOccupationDB reLNPOccupationDB = new LNPOccupationDB();
		String riskprop = reLNPRiskAppDB.getRiskProp();
		if ("R".equals(riskprop))
			reLNPOccupationDB.setOccupationCode(inPolElementSchema.getAppntOccupationCode());
		else
			reLNPOccupationDB.setOccupationCode(occupationcode);
		reLNPOccupationDB.getInfo();
		if (risktype.equals("L"))
			occupationType = reLNPOccupationDB.getLifeRate();
		else
		if (risktype.equals("W"))
			occupationType = reLNPOccupationDB.getWpRate();
		else
		if (risktype.equals("H"))
			occupationType = reLNPOccupationDB.getHiRate();
		else
		if (risktype.equals("A"))
			occupationType = reLNPOccupationDB.getPaRate();
		else
			occupationType = reLNPOccupationDB.getPaRate();
		if ("�ܱ�".equals(occupationType))
			errorList.add((new StringBuilder("ϵͳ�ܱ���ǰְҵ[")).append(reLNPOccupationDB.getOccupationName()).append("]").toString());
		String sql = (new StringBuilder("select * from lnpdutypay where PayPlanCode in (select payplancode from LnpDutyPayRela where dutycode in (select dutycode from lnpriskduty where  riskcode='")).append(inPolElementSchema.getRiskCode()).append("'))").toString();
		LNPDutyPayDB reLNPDutyPayDB = new LNPDutyPayDB();
		LNPDutyPaySet teLNPDutyPaySet = reLNPDutyPayDB.executeQuery(sql);
		if (teLNPDutyPaySet != null && teLNPDutyPaySet.size() > 0)
		{
			reLNPDutyPayDB = teLNPDutyPaySet.get(1).getDB();
			String flag = reLNPDutyPayDB.getZeroFlag();
			if ("N".equalsIgnoreCase(flag) && inPolElementSchema.getPrem() == 0.0D)
				errorList.add("�����?4�ı��Ѳ���Ϊ0,����ɷ����뱻�����������Ƿ�ƥ��򱻱�����ְҵ�ȼ��Ƿ񳬹����ơ�");
		}
		sql = (new StringBuilder("select * from lnpdutyget where getdutycode in (select getdutycode from LnpDutygetRela where dutycode in (select dutycode from lnpriskduty where  riskcode='")).append(inPolElementSchema.getRiskCode()).append("'))").toString();
		LNPDutyGetDB reLNPDutyGetDB = new LNPDutyGetDB();
		LNPDutyGetSet reLNPDutyGetSet = reLNPDutyGetDB.executeQuery(sql);
		if (reLNPDutyGetSet != null && reLNPDutyGetSet.size() > 0)
		{
			reLNPDutyGetDB = reLNPDutyGetSet.get(1).getDB();
			String flag = reLNPDutyGetDB.getZeroFlag();
			if ("N".equalsIgnoreCase(flag) && inPolElementSchema.getAmnt() == 0.0D)
				errorList.add("�����?4�ı����Ϊ0");
		}
		return errorList;
	}

	private List checkRiskSpecialRules(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
		ExeSQL tempExeSQL = new ExeSQL();
		LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
		String sql = (new StringBuilder("select * from lnpcheckField where riskcode='")).append(inPolElementSchema.getRiskCode()).append("' and fieldname='TBINSERT' order by SerialNo").toString();
		LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
		if (tLNPCheckFieldSet.size() > 0)
		{
			tempLNPCheckFieldSchema = null;
			for (int i = 1; i <= tLNPCheckFieldSet.size(); i++)
			{
				tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
				LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
				tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
				if (tLNPCalModeDB.getInfo())
				{
					String tempsql = tLNPCalModeDB.getCalSQL();
					tempsql = transportExpression(tempsql, inPolElementSchema);
					if (!check(tempsql, tempExeSQL))
						errorList.add(tempLNPCheckFieldSchema.getMsg());
				}
			}

		}
		return errorList;
	}

	private List checkCommonRules(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
		ExeSQL tempExeSQL = new ExeSQL();
		LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
		String sql = (new StringBuilder("select * from lnpcheckField where riskcode='000000' and fieldname='TBINSERT' and (location='")).append(inPolElementSchema.getRiskChannel()).append("' or location is null) order by SerialNo").toString();
		LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
		if (tLNPCheckFieldSet.size() > 0)
		{
			tempLNPCheckFieldSchema = null;
			for (int i = 1; i <= tLNPCheckFieldSet.size(); i++)
			{
				tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
				LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
				tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
				if (tLNPCalModeDB.getInfo())
				{
					String tempsql = tLNPCalModeDB.getCalSQL();
					tempsql = transportExpression(tempsql, inPolElementSchema);
					if (!check(tempsql, tempExeSQL))
						errorList.add(tempLNPCheckFieldSchema.getMsg());
				}
			}

		}
		return errorList;
	}

	private List finalCheckForOneRisk(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
		ExeSQL tempExeSQL = new ExeSQL();
		LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
		String sql = (new StringBuilder("select * from lmcheckField where riskcode='")).append(inPolElementSchema.getRiskCode()).append("' and fieldname='FINAL' and (location='").append(inPolElementSchema.getRiskChannel()).append("' or location is null) order by SerialNo").toString();
		LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
		if (tLNPCheckFieldSet.size() > 0)
		{
			tempLNPCheckFieldSchema = null;
			for (int i = 1; i <= tLNPCheckFieldSet.size(); i++)
			{
				tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
				LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
				tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
				if (tLNPCalModeDB.getInfo())
				{
					String tempsql = tLNPCalModeDB.getCalSQL();
					tempsql = transportExpression(tempsql, inPolElementSchema);
					if (!check(tempsql, tempExeSQL))
						errorList.add(tempLNPCheckFieldSchema.getMsg());
				}
			}

		}
		return errorList;
	}

	private List finalCheckForALl(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
		ExeSQL tempExeSQL = new ExeSQL();
		LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
		String sql = (new StringBuilder("select * from lNPcheckField where riskcode='000000' and fieldname='FINAL' and (location='")).append(inPolElementSchema.getRiskChannel()).append("' or location is null) order by SerialNo").toString();
		LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
		if (tLNPCheckFieldSet.size() > 0)
		{
			tempLNPCheckFieldSchema = null;
			for (int i = 1; i <= tLNPCheckFieldSet.size(); i++)
			{
				tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
				LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
				tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
				if (tLNPCalModeDB.getInfo())
				{
					String tempsql = tLNPCalModeDB.getCalSQL();
					tempsql = transportExpression(tempsql, inPolElementSchema);
					if (!check(tempsql, tempExeSQL))
						errorList.add(tempLNPCheckFieldSchema.getMsg());
				}
			}

		}
		return errorList;
	}

	private List submitAgentCheckForALl(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
		ExeSQL tempExeSQL = new ExeSQL();
		LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
		String sql = (new StringBuilder("select * from lNPcheckField where riskcode='000000' and fieldname like 'SUBMIT%' and (location='")).append(inPolElementSchema.getRiskChannel()).append("' or location is null) order by SerialNo").toString();
		LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
		if (tLNPCheckFieldSet.size() > 0)
		{
			tempLNPCheckFieldSchema = null;
			for (int i = 1; i <= tLNPCheckFieldSet.size(); i++)
			{
				tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
				LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
				tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
				if (tLNPCalModeDB.getInfo())
				{
					String tempsql = tLNPCalModeDB.getCalSQL();
					tempsql = transportExpression(tempsql, inPolElementSchema);
					if (!check(tempsql, tempExeSQL))
						errorList.add(tempLNPCheckFieldSchema.getMsg());
				}
			}

		}
		return errorList;
	}

	private List submitOperCheckForALl(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
		ExeSQL tempExeSQL = new ExeSQL();
		LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
		String sql = (new StringBuilder("select * from lNPcheckField where riskcode='000000' and fieldname like 'SUBMITOPER' and (location='")).append(inPolElementSchema.getRiskChannel()).append("' or location is null) order by SerialNo").toString();
		LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
		if (tLNPCheckFieldSet.size() > 0)
		{
			tempLNPCheckFieldSchema = null;
			for (int i = 1; i <= tLNPCheckFieldSet.size(); i++)
			{
				tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
				LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
				tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
				if (tLNPCalModeDB.getInfo())
				{
					String tempsql = tLNPCalModeDB.getCalSQL();
					tempsql = transportExpression(tempsql, inPolElementSchema);
					if (!check(tempsql, tempExeSQL))
						errorList.add(tempLNPCheckFieldSchema.getMsg());
				}
			}

		}
		return errorList;
	}

	private List checkSpecialRules(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		LNPRiskParamDB tLNPRiskParamDB = new LNPRiskParamDB();
		tLNPRiskParamDB.setType("SpecialRules");
		tLNPRiskParamDB.setRiskCode(inPolElementSchema.getRiskCode());
		LNPRiskParamSet tLNPRiskParamSet = tLNPRiskParamDB.query();
		for (int i = 1; tLNPRiskParamSet != null && i <= tLNPRiskParamSet.size(); i++)
		{
			LNPRiskParamSchema tempLNPRiskParamSchema = tLNPRiskParamSet.get(i);
			String beanName = tempLNPRiskParamSchema.getExpression();
			SpecialRiskRulesImpl insSpecialRiskRulesImpl = new SpecialRiskRulesImpl();
			List list = insSpecialRiskRulesImpl.checkRules(inPolElementSchema);
			errorList.addAll(list);
		}

		return errorList;
	}

	private PolElementSchema initPolElementSchemaInfo(String polNo, IGlobalInput tGlobalInput)
	{
		if (tGlobalInput == null)
			return null;
		PolElementSchema inPolElementSchema = new PolElementSchema();
		String polManageCom = polNo.substring(0, 2);
		LNPComDB tLNPComDB = new LNPComDB();
		tLNPComDB.setValidCode(polManageCom);
		LNPComSet tLNPComSet = tLNPComDB.query();
		if (tLNPComSet.get(1) != null)
			polManageCom = tLNPComSet.get(1).getComCode();
		else
			polManageCom = tGlobalInput.ComCode;
		inPolElementSchema.setManageCom(polManageCom);
		inPolElementSchema.setRiskChannel(tGlobalInput.chanlesign);
		inPolElementSchema.setAgentCode(tGlobalInput.Operator);
		inPolElementSchema.setBranchType(tGlobalInput.BranchType);
		LNPPolDB reLNPPolDB = new LNPPolDB();
		reLNPPolDB.setPolNo(polNo);
		reLNPPolDB.getInfo();
		inPolElementSchema.setContNo(reLNPPolDB.getContNo());
		inPolElementSchema.setProposalContNo(reLNPPolDB.getProposalContNo());
		inPolElementSchema.setPolNo(reLNPPolDB.getPolNo());
		inPolElementSchema.setProposalNo(reLNPPolDB.getPolNo());
		inPolElementSchema.setMasterPolNo(reLNPPolDB.getMasterPolNo());
		LNPAppntDB reLNPAppntDB = new LNPAppntDB();
		reLNPAppntDB.setContNo(reLNPPolDB.getContNo());
		if (reLNPAppntDB.getInfo())
		{
			inPolElementSchema.setAppntAge(reLNPAppntDB.getAppntAge());
			inPolElementSchema.setAppntAgeType(reLNPAppntDB.getAppntAgeType());
			inPolElementSchema.setAppntNo(reLNPAppntDB.getAppntNo());
			inPolElementSchema.setAppntId(reLNPAppntDB.getAppntId());
			inPolElementSchema.setAppntSex(reLNPAppntDB.getAppntSex());
			inPolElementSchema.setAppntOccupationCode(reLNPAppntDB.getOccupationCode());
			inPolElementSchema.setAppntNativePlace(reLNPAppntDB.getNativePlace());
		}
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(reLNPPolDB.getContNo());
		reLNPInsuredDB.setInsuredId(reLNPPolDB.getInsuredId());
		if (reLNPInsuredDB.getInfo())
		{
			inPolElementSchema.setInsuredNo(reLNPInsuredDB.getInsuredNo());
			inPolElementSchema.setInsuredId(reLNPInsuredDB.getInsuredId());
			inPolElementSchema.setName(reLNPInsuredDB.getName());
			inPolElementSchema.setAppAge(reLNPInsuredDB.getAppAge());
			inPolElementSchema.setAppAgeType(reLNPInsuredDB.getAppAgeType());
			inPolElementSchema.setSex(reLNPInsuredDB.getSex());
			inPolElementSchema.setBirthday(reLNPInsuredDB.getBirthday());
			inPolElementSchema.setOccupationCode(reLNPInsuredDB.getOccupationCode());
			inPolElementSchema.setInsuredNativePlace(reLNPInsuredDB.getNationality());
			inPolElementSchema.setRelationToAppnt(reLNPInsuredDB.getRelationToAppnt());
		}
		inPolElementSchema.setRiskCode(reLNPPolDB.getRiskCode());
		inPolElementSchema.setAmnt(reLNPPolDB.getAmnt());
		inPolElementSchema.setDeadAmntType(reLNPPolDB.getDeadAmntType());
		inPolElementSchema.setTopUpPrem(reLNPPolDB.getTopUpPrem());
		inPolElementSchema.setPrem(reLNPPolDB.getPrem());
		inPolElementSchema.setMult(reLNPPolDB.getMult());
		inPolElementSchema.setBonusGetMode(reLNPPolDB.getBonusGetMode());
		inPolElementSchema.setGet(reLNPPolDB.getAmnt());
		inPolElementSchema.setLiveGetMode(reLNPPolDB.getLiveGetMode());
		inPolElementSchema.setGetYear(reLNPPolDB.getGetYear());
		inPolElementSchema.setGetYearFlag(reLNPPolDB.getGetYearFlag());
		inPolElementSchema.setInsuYear(reLNPPolDB.getInsuYear());
		inPolElementSchema.setInsuYearFlag(reLNPPolDB.getInsuYearFlag());
		inPolElementSchema.setPayEndYear(reLNPPolDB.getPayEndYear());
		inPolElementSchema.setPayEndYearFlag(reLNPPolDB.getPayEndYearFlag());
		inPolElementSchema.setPayIntv(reLNPPolDB.getPayIntv());
		inPolElementSchema.setStandbyFlag1(reLNPPolDB.getStandbyFlag1());
		inPolElementSchema.setStandbyFlag2(reLNPPolDB.getStandbyFlag2());
		inPolElementSchema.setStandbyFlag3(reLNPPolDB.getStandbyFlag3());
		inPolElementSchema.setSubRiskFlag(reLNPPolDB.getSubFlag());
		inPolElementSchema.setPolNo(reLNPPolDB.getPolNo());
		inPolElementSchema.setMainPolNo(reLNPPolDB.getMainPolNo());
		inPolElementSchema.setYears(reLNPPolDB.getYears());
		inPolElementSchema.setPayYears(reLNPPolDB.getPayYears());
		inPolElementSchema.setStandardPrem(reLNPPolDB.getStandPrem());
		inPolElementSchema = calSumRiskAmnt(inPolElementSchema);
		return inPolElementSchema;
	}

	private boolean check(String sql, ExeSQL exeSQL)
	{
		boolean flag = true;
		String result = exeSQL.getOneValue(sql);
		if (result != null && !result.equals("0") && !result.equals("null") && !result.equals(""))
			flag = false;
		return flag;
	}

	private String transportExpression(String oriStr, PolElementSchema inPolElementSchema)
	{
		if (oriStr == null || oriStr.length() == 0)
		{
			return "";
		} else
		{
			oriStr = StrTool.replace(oriStr, "?InsuredNo?", inPolElementSchema.getInsuredNo());
			oriStr = StrTool.replace(oriStr, "?InsuredId?", inPolElementSchema.getInsuredId());
			oriStr = StrTool.replace(oriStr, "?Name?", inPolElementSchema.getName());
			oriStr = StrTool.replace(oriStr, "?Sex?", inPolElementSchema.getSex());
			oriStr = StrTool.replace(oriStr, "?Birthday?", inPolElementSchema.getBirthday());
			oriStr = StrTool.replace(oriStr, "?OccupationCode?", inPolElementSchema.getOccupationCode());
			oriStr = StrTool.replace(oriStr, "?AppAge?", (new StringBuilder(String.valueOf(inPolElementSchema.getAppAge()))).toString());
			oriStr = StrTool.replace(oriStr, "?AppAgeType?", (new StringBuilder(String.valueOf(inPolElementSchema.getAppAgeType()))).toString());
			oriStr = StrTool.replace(oriStr, "?RelationToAppnt?", inPolElementSchema.getRelationToAppnt());
			oriStr = StrTool.replace(oriStr, "?InsuredNativePlace?", inPolElementSchema.getInsuredNativePlace());
			oriStr = StrTool.replace(oriStr, "?InsuredNo2?", inPolElementSchema.getInsuredNo2());
			oriStr = StrTool.replace(oriStr, "?AppAge2Type?", inPolElementSchema.getAppAge2Type());
			oriStr = StrTool.replace(oriStr, "?AppAge2?", inPolElementSchema.getAppAge2());
			oriStr = StrTool.replace(oriStr, "?AppntNo?", inPolElementSchema.getAppntNo());
			oriStr = StrTool.replace(oriStr, "?AppntId?", inPolElementSchema.getAppntId());
			oriStr = StrTool.replace(oriStr, "?AppntNativePlace?", inPolElementSchema.getAppntNativePlace());
			oriStr = StrTool.replace(oriStr, "?AppntOccupationCode?", inPolElementSchema.getAppntOccupationCode());
			oriStr = StrTool.replace(oriStr, "?AppntAge?", (new StringBuilder(String.valueOf(inPolElementSchema.getAppntAge()))).toString());
			oriStr = StrTool.replace(oriStr, "?AppntAgeType?", (new StringBuilder(String.valueOf(inPolElementSchema.getAppntAgeType()))).toString());
			oriStr = StrTool.replace(oriStr, "?AppntSex?", inPolElementSchema.getAppntSex());
			oriStr = StrTool.replace(oriStr, "?RiskChannel?", inPolElementSchema.getRiskChannel());
			oriStr = StrTool.replace(oriStr, "?ManageCom?", inPolElementSchema.getManageCom());
			oriStr = StrTool.replace(oriStr, "?MainPolNo?", inPolElementSchema.getMainPolNo());
			oriStr = StrTool.replace(oriStr, "?MasterPolNo?", inPolElementSchema.getMasterPolNo());
			oriStr = StrTool.replace(oriStr, "?MainPolAmnt?", inPolElementSchema.getMainPolAmnt());
			oriStr = StrTool.replace(oriStr, "?ContNo?", inPolElementSchema.getContNo());
			oriStr = StrTool.replace(oriStr, "?DutyCode?", inPolElementSchema.getDutyCode());
			oriStr = StrTool.replace(oriStr, "?RiskCode?", inPolElementSchema.getRiskCode());
			oriStr = StrTool.replace(oriStr, "?PolNo?", inPolElementSchema.getPolNo());
			oriStr = StrTool.replace(oriStr, "?Amnt?", (new StringBuilder(String.valueOf(inPolElementSchema.getAmnt()))).toString());
			oriStr = StrTool.replace(oriStr, "?DeadAmntType?", (new StringBuilder(String.valueOf(inPolElementSchema.getDeadAmntType()))).toString());
			oriStr = StrTool.replace(oriStr, "?TopUpPrem?", (new StringBuilder(String.valueOf(inPolElementSchema.getTopUpPrem()))).toString());
			oriStr = StrTool.replace(oriStr, "?Get?", (new StringBuilder(String.valueOf(inPolElementSchema.getGet()))).toString());
			oriStr = StrTool.replace(oriStr, "?Mult?", (new StringBuilder(String.valueOf(inPolElementSchema.getMult()))).toString());
			oriStr = StrTool.replace(oriStr, "?Prem?", (new StringBuilder(String.valueOf(inPolElementSchema.getPrem()))).toString());
			oriStr = StrTool.replace(oriStr, "?StandardPrem?", (new StringBuilder(String.valueOf(inPolElementSchema.getStandardPrem()))).toString());
			oriStr = StrTool.replace(oriStr, "?Vpu?", inPolElementSchema.getVPU());
			oriStr = StrTool.replace(oriStr, "?PayEndYear?", (new StringBuilder(String.valueOf(inPolElementSchema.getPayEndYear()))).toString());
			oriStr = StrTool.replace(oriStr, "?PayEndYearFlag?", inPolElementSchema.getPayEndYearFlag());
			oriStr = StrTool.replace(oriStr, "?GetYear?", (new StringBuilder(String.valueOf(inPolElementSchema.getGetYear()))).toString());
			oriStr = StrTool.replace(oriStr, "?GetYearFlag?", inPolElementSchema.getGetYearFlag());
			oriStr = StrTool.replace(oriStr, "?InsuYear?", (new StringBuilder(String.valueOf(inPolElementSchema.getInsuYear()))).toString());
			oriStr = StrTool.replace(oriStr, "?InsuYearFlag?", inPolElementSchema.getInsuYearFlag());
			oriStr = StrTool.replace(oriStr, "?PayIntv?", (new StringBuilder(String.valueOf(inPolElementSchema.getPayIntv()))).toString());
			oriStr = StrTool.replace(oriStr, "?GetIntv?", (new StringBuilder(String.valueOf(inPolElementSchema.getGetIntv()))).toString());
			oriStr = StrTool.replace(oriStr, "?Years?", (new StringBuilder(String.valueOf(inPolElementSchema.getYears()))).toString());
			oriStr = StrTool.replace(oriStr, "?PayYears?", (new StringBuilder(String.valueOf(inPolElementSchema.getPayYears()))).toString());
			oriStr = StrTool.replace(oriStr, "?LiveGetMode?", inPolElementSchema.getLiveGetMode());
			oriStr = StrTool.replace(oriStr, "?SubRiskFlag?", inPolElementSchema.getSubRiskFlag());
			oriStr = StrTool.replace(oriStr, "?BonusGetMode?", inPolElementSchema.getBonusGetMode());
			oriStr = StrTool.replace(oriStr, "?StandByFlag1?", inPolElementSchema.getStandbyFlag1());
			oriStr = StrTool.replace(oriStr, "?StandByFlag2?", inPolElementSchema.getStandbyFlag2());
			oriStr = StrTool.replace(oriStr, "?StandByFlag3?", inPolElementSchema.getStandbyFlag3());
			oriStr = StrTool.replace(oriStr, "?RiskAmnt?", (new StringBuilder(String.valueOf(inPolElementSchema.getRiskAmnt()))).toString());
			oriStr = StrTool.replace(oriStr, "?SumLifeRiskAmnt?", (new StringBuilder(String.valueOf(inPolElementSchema.getSumLifeRiskAmnt()))).toString());
			oriStr = StrTool.replace(oriStr, "?SumAccRiskAmnt?", (new StringBuilder(String.valueOf(inPolElementSchema.getSumAccRiskAmnt()))).toString());
			oriStr = StrTool.replace(oriStr, "?SumDeaRiskAmnt?", (new StringBuilder(String.valueOf(inPolElementSchema.getSumDeaRiskAmnt()))).toString());
			oriStr = StrTool.replace(oriStr, "?SumDeaDutyRiskAmnt?", (new StringBuilder(String.valueOf(inPolElementSchema.getSumDeaDutyRiskAmnt()))).toString());
			oriStr = StrTool.replace(oriStr, "?SumBodRiskAmnt?", (new StringBuilder(String.valueOf(inPolElementSchema.getSumBodRiskAmnt()))).toString());
			return oriStr;
		}
	}

	private LNPRiskParamSchema getRelaRiskParamSchema(String riskcode, String type, List list)
	{
		LNPRiskParamSchema reLNPRiskParamSchema = null;
		if (list != null && list.size() > 0)
		{
			for (Iterator iterator = list.iterator(); iterator.hasNext();)
			{
				LNPRiskParamSchema tempLNPRiskParamSchema = (LNPRiskParamSchema)iterator.next();
				if (type.equals(tempLNPRiskParamSchema.getParam()) && riskcode.equals(tempLNPRiskParamSchema.getRiskCode()))
				{
					reLNPRiskParamSchema = tempLNPRiskParamSchema;
					break;
				}
			}

		}
		return reLNPRiskParamSchema;
	}

	private double getValueOfRiskAmntForOnePol(LNPRiskParamSchema inreLNPRiskParamSchema, String type, LNPPolSchema inLNPPolSchema)
	{
		double result = 0.0D;
		if (inreLNPRiskParamSchema != null)
		{
			String expression = inreLNPRiskParamSchema.getExpression();
			try
			{
				if (inreLNPRiskParamSchema.getRemark() != null && !inreLNPRiskParamSchema.getRemark().trim().equals(""))
				{
					LNPInsuredSchema tLNPInsuredSchema = new LNPInsuredSchema();
					LNPInsuredDB LNPInsuredDB = new LNPInsuredDB();
					LNPInsuredDB.setContNo(inLNPPolSchema.getContNo());
					LNPInsuredDB.setInsuredId(inLNPPolSchema.getInsuredId());
					tLNPInsuredSchema = LNPInsuredDB.query().get(1);
					String Remark = inreLNPRiskParamSchema.getRemark();
					Remark = StrTool.replace(Remark, "?AppAge?", (new StringBuilder()).append(tLNPInsuredSchema.getAppAge()).toString());
					Remark = StrTool.replace(Remark, "?AppAgeType?", (new StringBuilder()).append(tLNPInsuredSchema.getAppAgeType()).toString());
					Remark = StrTool.replace(Remark, "?InsuYear?", (new StringBuilder("'")).append(inLNPPolSchema.getInsuYear()).append("/").append(inLNPPolSchema.getInsuYearFlag()).append("'").toString());
					Remark = StrTool.replace(Remark, "?Sex?", (new StringBuilder("'")).append(tLNPInsuredSchema.getSex()).append("'").toString());
					ExeSQL tExeSQL = new ExeSQL();
					String bei = tExeSQL.getOneValue(Remark);
					if (bei != null)
						expression = (new StringBuilder(String.valueOf(expression))).append("*").append(bei).toString();
				}
				String resultStr = calRiskAmntByExpress(expression, inLNPPolSchema);
				if (resultStr != null && !resultStr.equals(""))
					result = Double.parseDouble(resultStr);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private PolElementSchema calSumRiskAmnt(PolElementSchema inPolElementSchema)
	{
		LNPRiskParamDB reLNPRiskParasDB = new LNPRiskParamDB();
		reLNPRiskParasDB.setType("RiskAmnt");
		LNPRiskParamSet reLNPRiskParamSet = reLNPRiskParasDB.query();
		String sql = (new StringBuilder("select * from Lnppol where contNo='")).append(inPolElementSchema.getContNo()).append("' and insuredId='").append(inPolElementSchema.getInsuredId()).append("' and MasterPolNo='").append(inPolElementSchema.getMasterPolNo()).append("'").toString();
		LNPPolDB reLNPPolDB = new LNPPolDB();
		LNPPolSet reLNPPolSet = reLNPPolDB.executeQuery(sql);
		List lifeRiskAmntList = new ArrayList();
		List accRiskAmntList = new ArrayList();
		List deaRiskAmntList = new ArrayList();
		List deaDutyRiskAmntList = new ArrayList();
		for (int i = 1; reLNPRiskParamSet != null && i < reLNPRiskParamSet.size(); i++)
		{
			LNPRiskParamSchema tempLNPRiskParamSchema = reLNPRiskParamSet.get(i);
			String param = tempLNPRiskParamSchema.getParam();
			if ("Life".equals(param))
				lifeRiskAmntList.add(tempLNPRiskParamSchema);
			else
			if ("Acc".equals(param))
				accRiskAmntList.add(tempLNPRiskParamSchema);
			else
			if ("Dea".equals(param))
				deaRiskAmntList.add(tempLNPRiskParamSchema);
			else
			if ("DeaDuty".equals(param))
				deaDutyRiskAmntList.add(tempLNPRiskParamSchema);
		}

		double lifeRiskAmnt = 0.0D;
		double accRiskAmnt = 0.0D;
		double deaRiskAmnt = 0.0D;
		double deaDutyRiskAmnt = 0.0D;
		for (int i = 1; reLNPPolSet != null && i <= reLNPPolSet.size(); i++)
		{
			LNPPolSchema teLNPPolSchema = reLNPPolSet.get(i);
			String type = "Life";
			LNPRiskParamSchema tempLNPRiskParamSchema = getRelaRiskParamSchema(teLNPPolSchema.getRiskCode(), type, lifeRiskAmntList);
			if (tempLNPRiskParamSchema != null)
				lifeRiskAmnt += getValueOfRiskAmntForOnePol(tempLNPRiskParamSchema, type, teLNPPolSchema);
			type = "Acc";
			tempLNPRiskParamSchema = getRelaRiskParamSchema(teLNPPolSchema.getRiskCode(), type, accRiskAmntList);
			if (tempLNPRiskParamSchema != null)
				accRiskAmnt += getValueOfRiskAmntForOnePol(tempLNPRiskParamSchema, type, teLNPPolSchema);
			type = "Dea";
			tempLNPRiskParamSchema = getRelaRiskParamSchema(teLNPPolSchema.getRiskCode(), type, deaRiskAmntList);
			if (tempLNPRiskParamSchema != null)
				deaRiskAmnt += getValueOfRiskAmntForOnePol(tempLNPRiskParamSchema, type, teLNPPolSchema);
			type = "DeaDuty";
			tempLNPRiskParamSchema = getRelaRiskParamSchema(teLNPPolSchema.getRiskCode(), type, deaDutyRiskAmntList);
			if (tempLNPRiskParamSchema != null)
				deaDutyRiskAmnt += getValueOfRiskAmntForOnePol(tempLNPRiskParamSchema, type, teLNPPolSchema);
		}

		inPolElementSchema.setSumLifeRiskAmnt(lifeRiskAmnt);
		inPolElementSchema.setSumAccRiskAmnt(accRiskAmnt);
		inPolElementSchema.setSumDeaRiskAmnt(deaRiskAmnt);
		inPolElementSchema.setSumDeaDutyRiskAmnt(deaDutyRiskAmnt);
		logger.info((new StringBuilder("Life:")).append(lifeRiskAmnt).toString());
		logger.info((new StringBuilder("Acc:")).append(accRiskAmnt).toString());
		logger.info((new StringBuilder("Dea:")).append(deaRiskAmnt).toString());
		logger.info((new StringBuilder("DeaDuty:")).append(deaDutyRiskAmnt).toString());
		return inPolElementSchema;
	}

	private String calRiskAmntByExpress(String expression, LNPPolSchema reLNPPolShcema)
	{
		Hashtable reHashtable = new Hashtable();
		reHashtable.put("ContNo", (new StringBuilder(String.valueOf(reLNPPolShcema.getContNo()))).toString());
		reHashtable.put("InsuredNo", (new StringBuilder(String.valueOf(reLNPPolShcema.getInsuredNo()))).toString());
		reHashtable.put("InsuredId", (new StringBuilder(String.valueOf(reLNPPolShcema.getInsuredId()))).toString());
		reHashtable.put("PolNo", (new StringBuilder(String.valueOf(reLNPPolShcema.getPolNo()))).toString());
		reHashtable.put("Amnt", Double.valueOf(reLNPPolShcema.getAmnt()));
		reHashtable.put("Get", Double.valueOf(reLNPPolShcema.getAmnt()));
		reHashtable.put("Prem", Double.valueOf(reLNPPolShcema.getPrem()));
		reHashtable.put("DeadAmntType", (new StringBuilder(String.valueOf(reLNPPolShcema.getDeadAmntType()))).toString());
		reHashtable.put("TopUpPrem", Double.valueOf(reLNPPolShcema.getTopUpPrem()));
		reHashtable.put("Mult", Double.valueOf(reLNPPolShcema.getMult()));
		reHashtable.put("PayIntv", (new StringBuilder(String.valueOf(reLNPPolShcema.getPayIntv()))).toString());
		reHashtable.put("InsuYear", (new StringBuilder(String.valueOf(reLNPPolShcema.getInsuYear()))).toString());
		reHashtable.put("PayYears", (new StringBuilder(String.valueOf(reLNPPolShcema.getYears()))).toString());
		reHashtable.put("InsuYearFlag", (new StringBuilder(String.valueOf(reLNPPolShcema.getInsuYearFlag()))).toString());
		reHashtable.put("PayEndYear", (new StringBuilder(String.valueOf(reLNPPolShcema.getPayEndYear()))).toString());
		reHashtable.put("PayEndYearFlag", (new StringBuilder(String.valueOf(reLNPPolShcema.getPayEndYearFlag()))).toString());
		reHashtable.put("LiveGetMode", (new StringBuilder(String.valueOf(reLNPPolShcema.getLiveGetMode()))).toString());
		reHashtable.put("StandbyFlag1", (new StringBuilder(String.valueOf(reLNPPolShcema.getStandbyFlag1()))).toString());
		reHashtable.put("StandbyFlag2", (new StringBuilder(String.valueOf(reLNPPolShcema.getStandbyFlag2()))).toString());
		reHashtable.put("StandbyFlag3", (new StringBuilder(String.valueOf(reLNPPolShcema.getStandbyFlag3()))).toString());
		reHashtable.put("SPCRiskRulesApi", calSpecialRulesElementsImpl);
		String result = evalJavaTool.executeByExpress(expression, reHashtable);
		return result;
	}

	public CalSpecialRulesElementsImpl getCalSpecialRulesElementsImpl()
	{
		return calSpecialRulesElementsImpl;
	}

	public void setCalSpecialRulesElementsImpl(CalSpecialRulesElementsImpl calSpecialRulesElementsImpl)
	{
		this.calSpecialRulesElementsImpl = calSpecialRulesElementsImpl;
	}

	public RiskPolImpl getRiskPolImpl()
	{
		return riskPolImpl;
	}

	public void setRiskPolImpl(RiskPolImpl riskPolImpl)
	{
		this.riskPolImpl = riskPolImpl;
	}

	public EvalJavaTool getEvalJavaTool()
	{
		return evalJavaTool;
	}

	public void setEvalJavaTool(EvalJavaTool evalJavaTool)
	{
		this.evalJavaTool = evalJavaTool;
	}

	public SugError checkOnePolBeforeCal(String contNo, IGlobalInput tGlobalInput)
	{
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(contNo);
		LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
		SugError reSugError = new SugError();
		for (int i = 1; reLNPInsuredSet != null && i <= reLNPInsuredSet.size(); i++)
		{
			LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
			SugError tempSugError = checkForOneInsuBeforeCal(contNo, reLNPInsuredSchema.getInsuredId(), tGlobalInput, "BeforeCal");
			if (tempSugError.hasError())
				reSugError.addInsuError((InsuError)tempSugError.getInsuErrorList().get(0));
		}

		LNPContSchema reLNPContSchema = new LNPContSchema();
		reLNPContSchema.setContNo(contNo);
		reSugError.setSugInfo(reLNPContSchema);
		return reSugError;
	}

	public SugError checkForOneInsuBeforeCal(String contNo, String insuredId, IGlobalInput tGlobalInput, String flag)
	{
		String sql = (new StringBuilder("select * from lnppol where polno=masterpolno and contNo='")).append(contNo).append("' and insuredId='").append(insuredId).append("'").toString();
		LNPPolDB reLNPPolDB = new LNPPolDB();
		LNPPolSet reLNPPolSet = reLNPPolDB.executeQuery(sql);
		SugError reSugError = new SugError();
		for (int i = 1; reLNPPolSet != null && i <= reLNPPolSet.size(); i++)
		{
			LNPPolSchema tLNPPolSchema = reLNPPolSet.get(i);
			SugError tempSugError = checkForOnePolBeforeCal(tLNPPolSchema.getPolNo(), tGlobalInput, flag);
			if (tempSugError.hasError())
				if (reSugError.hasError())
				{
					InsuError insuError = (InsuError)reSugError.getInsuErrorList().get(0);
					List riskError = ((InsuError)tempSugError.getInsuErrorList().get(0)).getRiskErrorList();
					for (int j = 0; riskError != null && j < riskError.size(); j++)
						insuError.addRiskError((RiskError)riskError.get(j));

				} else
				{
					InsuError insuError = (InsuError)tempSugError.getInsuErrorList().get(0);
					reSugError.addInsuError(insuError);
				}
		}

		LNPContSchema reLNPContSchema = new LNPContSchema();
		reLNPContSchema.setContNo(contNo);
		reSugError.setSugInfo(reLNPContSchema);
		return reSugError;
	}

	public SugError checkForOnePolBeforeCal(String mainPolNo, IGlobalInput tGlobalInput, String flagStr)
	{
		List list = riskPolImpl.getPolList(mainPolNo, 1);
		List polList = (List)list.get(1);
		SugError reSugError = new SugError();
		InsuError reInsuError = new InsuError();
		String contNO = "";
		boolean flag = true;
		for (int i = 0; polList != null && i < polList.size(); i++)
		{
			LNPPolSchema remLNPPolSchema = (LNPPolSchema)polList.get(i);
			contNO = remLNPPolSchema.getContNo();
			PolElementSchema rePolElementSchema = initPolElementSchemaInfo(remLNPPolSchema.getPolNo(), tGlobalInput);
			rePolElementSchema = calSumRiskAmnt(rePolElementSchema);
			List reusltList = new ArrayList();
			List list_1 = checkSexAndAge(rePolElementSchema);
			RiskError reRiskError = new RiskError();
			if (list_1 != null && list_1.size() > 0)
				reusltList.addAll(list_1);
			if ("BeforeCal".equals(flagStr))
			{
				List list_6 = finalCheckForALlBeforeCal(rePolElementSchema);
				if (list_6 != null && list_6.size() > 0)
					reusltList.addAll(list_6);
			}
			if (reusltList != null && reusltList.size() > 0)
			{
				reRiskError.setRiskInfo(rePolElementSchema.getRiskCode());
				reRiskError.addError(reusltList);
				reInsuError.setInsuInfo(rePolElementSchema.getContNo(), rePolElementSchema.getInsuredId());
				reInsuError.addRiskError(reRiskError);
				flag = false;
			}
		}

		if (!flag)
		{
			LNPContSchema reLNPContSchema = new LNPContSchema();
			reLNPContSchema.setContNo(contNO);
			reSugError.setSugInfo(reLNPContSchema);
			reSugError.addInsuError(reInsuError);
		}
		return reSugError;
	}

	private List finalCheckForALlBeforeCal(PolElementSchema inPolElementSchema)
	{
		List errorList = new ArrayList();
		LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
		ExeSQL tempExeSQL = new ExeSQL();
		LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
		String sql = (new StringBuilder("select * from lNPcheckField where riskcode='000000' and fieldname='BeforeCal' and (location='")).append(inPolElementSchema.getRiskChannel()).append("' or location is null) order by SerialNo").toString();
		LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
		if (tLNPCheckFieldSet.size() > 0)
		{
			tempLNPCheckFieldSchema = null;
			for (int i = 1; i <= tLNPCheckFieldSet.size(); i++)
			{
				tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
				LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
				tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
				if (tLNPCalModeDB.getInfo())
				{
					String tempsql = tLNPCalModeDB.getCalSQL();
					tempsql = transportExpression(tempsql, inPolElementSchema);
					if (!check(tempsql, tempExeSQL))
						errorList.add(tempLNPCheckFieldSchema.getMsg());
				}
			}

		}
		return errorList;
	}
}
