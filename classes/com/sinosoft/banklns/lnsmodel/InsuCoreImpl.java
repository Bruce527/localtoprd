// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   InsuCoreImpl.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.lnsmodel.util.ForSpcCalImpl;
import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
import com.sinosoft.banklns.utility.*;
import java.util.Hashtable;

public class InsuCoreImpl
{

	public InsuCoreImpl()
	{
	}

	public double calAmnt(PolElementSchema inPolElementSchema, String dutyCode)
		throws Exception
	{
		LNPDutyDB reLNPDutyDB = new LNPDutyDB();
		reLNPDutyDB.setDutyCode(dutyCode);
		reLNPDutyDB.getInfo();
		String calFlag = reLNPDutyDB.getCalMode();
		String sql = (new StringBuilder("select * from lnpdutyget where getdutycode = (select  getdutycode from LnpDutyGetRela where dutycode='")).append(inPolElementSchema.getDutyCode()).append("')").toString();
		LNPDutyGetDB ewLNPDutyGetDB = new LNPDutyGetDB();
		LNPDutyGetSet ewLNPDutyGetSet = ewLNPDutyGetDB.executeQuery(sql);
		ewLNPDutyGetDB = ewLNPDutyGetSet.get(1).getDB();
		String calCode = null;
		if ("P".equals(calFlag))
			calCode = ewLNPDutyGetDB.getCalCode();
		else
		if ("G".equals(calFlag) || "I".equals(calFlag))
			calCode = ewLNPDutyGetDB.getCnterCalCode();
		else
		if ("O".equals(calFlag))
			calCode = ewLNPDutyGetDB.getOthCalCode();
		LNPCalModeDB reLNPCalModeDB = new LNPCalModeDB();
		reLNPCalModeDB.setCalCode(calCode);
		reLNPCalModeDB.getInfo();
		String calsql = reLNPCalModeDB.getCalSQL();
		calsql = transportExpression(calsql, inPolElementSchema);
		ExeSQL stExeSQL = new ExeSQL();
		String resultstr = stExeSQL.getOneValue(calsql);
		double result = 0.0D;
		if (resultstr == null || resultstr.equals("") || resultstr.equals("null"))
			result = 0.0D;
		else
			result = Double.parseDouble(resultstr);
		if (ewLNPDutyGetDB.getZeroFlag().equals("N") && result == 0.0D)
			throw new Exception("�����?4�ı����Ϊ0.");
		else
			return result;
	}

	public double calPrem(PolElementSchema inPolElementSchema, String dutyCode)
		throws Exception
	{
		String sql = (new StringBuilder("select * from lnpdutypay where payplancode = (select  payplancode from LNPDutyPayRela where dutycode='")).append(inPolElementSchema.getDutyCode()).append("')").toString();
		LNPDutyPayDB erLNPDutyPayDB = new LNPDutyPayDB();
		LNPDutyPaySet erLMDutyPaySet = erLNPDutyPayDB.executeQuery(sql);
		erLNPDutyPayDB = erLMDutyPaySet.get(1).getDB();
		int payintInt = erLNPDutyPayDB.getPayIntv();
		if (payintInt != -1)
			inPolElementSchema.setPayIntv(payintInt);
		if (inPolElementSchema.getPayIntv() == 0)
		{
			inPolElementSchema.setPayEndYear(1000);
			inPolElementSchema.setPayYears(1);
			inPolElementSchema.setPayEndYearFlag("Y");
		}
		double result = 0.0D;
		return result;
	}

	public double calExtFee(PolElementSchema inPolElementSchema)
		throws Exception
	{
		double result = 0.0D;
		return result;
	}

	public String calcuteAmntAndPrem(PolElementSchema inPolElementSchema, String flag)
	{
		String resultStr = "";
		return resultStr;
	}

	public PolElementSchema calcutePol(PolElementSchema inPolElementSchema)
	{
		inPolElementSchema = preparePolInitData(inPolElementSchema);
		inPolElementSchema = dealPolData(inPolElementSchema, inPolElementSchema.getDutyCode());
		double get = 0.0D;
		try
		{
			get = calAmnt(inPolElementSchema, inPolElementSchema.getDutyCode());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			get = 0.0D;
		}
		inPolElementSchema.setGet(get);
		inPolElementSchema.setAmnt(get);
		double prem = 0.0D;
		try
		{
			prem = calPrem(inPolElementSchema, inPolElementSchema.getDutyCode());
			prem = 0.0D;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			prem = 0.0D;
		}
		inPolElementSchema.setPrem(prem);
		try
		{
			savePolData(inPolElementSchema);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return inPolElementSchema;
	}

	private String transportExpression(String oriStr, PolElementSchema inPolElementSchema)
	{
		if (oriStr == null || oriStr.length() == 0)
		{
			return "";
		} else
		{
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
			oriStr = StrTool.replace(oriStr, "?AppAge2?", inPolElementSchema.getAppAge2());
			oriStr = StrTool.replace(oriStr, "?AppAge2Type?", inPolElementSchema.getAppAge2Type());
			oriStr = StrTool.replace(oriStr, "?AppntId?", inPolElementSchema.getAppntId());
			oriStr = StrTool.replace(oriStr, "?AppntNativePlace?", inPolElementSchema.getAppntNativePlace());
			oriStr = StrTool.replace(oriStr, "?AppntOccupationCode?", inPolElementSchema.getAppntOccupationCode());
			oriStr = StrTool.replace(oriStr, "?AppntAge?", (new StringBuilder(String.valueOf(inPolElementSchema.getAppntAge()))).toString());
			oriStr = StrTool.replace(oriStr, "?AppntAgeType?", (new StringBuilder(String.valueOf(inPolElementSchema.getAppntAgeType()))).toString());
			oriStr = StrTool.replace(oriStr, "?AppntSex?", inPolElementSchema.getAppntSex());
			oriStr = StrTool.replace(oriStr, "?RiskChannel?", inPolElementSchema.getRiskChannel());
			oriStr = StrTool.replace(oriStr, "?ManageCom?", inPolElementSchema.getManageCom());
			oriStr = StrTool.replace(oriStr, "?MainPolNo?", inPolElementSchema.getMainPolNo());
			oriStr = StrTool.replace(oriStr, "?MainPolAmnt?", inPolElementSchema.getMainPolAmnt());
			oriStr = StrTool.replace(oriStr, "?ContNo?", inPolElementSchema.getContNo());
			oriStr = StrTool.replace(oriStr, "?DutyCode?", inPolElementSchema.getDutyCode());
			oriStr = StrTool.replace(oriStr, "?RiskCode?", inPolElementSchema.getRiskCode());
			oriStr = StrTool.replace(oriStr, "?PolNo?", inPolElementSchema.getPolNo());
			oriStr = StrTool.replace(oriStr, "?Amnt?", (new StringBuilder(String.valueOf(inPolElementSchema.getAmnt()))).toString());
			oriStr = StrTool.replace(oriStr, "?TopUpPrem?", (new StringBuilder(String.valueOf(inPolElementSchema.getTopUpPrem()))).toString());
			oriStr = StrTool.replace(oriStr, "?DeadAmntType?", (new StringBuilder(String.valueOf(inPolElementSchema.getDeadAmntType()))).toString());
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
			oriStr = StrTool.replace(oriStr, "?SumBodRiskAmnt?", (new StringBuilder(String.valueOf(inPolElementSchema.getSumBodRiskAmnt()))).toString());
			return oriStr;
		}
	}

	private PolElementSchema preparePolInitData(PolElementSchema inPolElementSchema)
	{
		LNPSysVarDB tLNPSysVarDB = new LNPSysVarDB();
		tLNPSysVarDB.setSysVar("GrpContNo");
		tLNPSysVarDB.getInfo();
		inPolElementSchema.setGrpContNo(tLNPSysVarDB.getSysVarValue());
		inPolElementSchema.setGrpPolNo(tLNPSysVarDB.getSysVarValue());
		tLNPSysVarDB.setSysVar("PrtNo");
		tLNPSysVarDB.getInfo();
		inPolElementSchema.setPrtNo(tLNPSysVarDB.getSysVarValue());
		inPolElementSchema.setProposalContNo(inPolElementSchema.getContNo());
		if (inPolElementSchema.getPolNo() == null || inPolElementSchema.getPolNo().length() == 0)
		{
			LNPRiskCodeDB tLNPRiskCodeDB = new LNPRiskCodeDB();
			tLNPRiskCodeDB.setRiskCode(inPolElementSchema.getRiskCode());
			String sysRiskCode = "9999";
			if (tLNPRiskCodeDB.getInfo())
				sysRiskCode = tLNPRiskCodeDB.getSysRiskCode();
			inPolElementSchema.setPolNo((new StringBuilder(String.valueOf(inPolElementSchema.getContNo()))).append(sysRiskCode).toString());
		}
		inPolElementSchema.setProposalNo(inPolElementSchema.getPolNo());
		LNPRiskAppDB tLNPRiskAppDB = new LNPRiskAppDB();
		tLNPRiskAppDB.setRiskCode(inPolElementSchema.getRiskCode());
		tLNPRiskAppDB.getInfo();
		if ("M".endsWith(tLNPRiskAppDB.getSubRiskFlag()))
			inPolElementSchema.setMasterPolNo(inPolElementSchema.getPolNo());
		else
			"S".endsWith(tLNPRiskAppDB.getSubRiskFlag());
		inPolElementSchema.setGet(inPolElementSchema.getAmnt());
		LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
		reLNPRiskAppDB.setRiskCode(inPolElementSchema.getRiskCode());
		reLNPRiskAppDB.getInfo();
		inPolElementSchema.setSubRiskFlag(reLNPRiskAppDB.getSubRiskFlag());
		if ("S".equals(inPolElementSchema.getSubRiskFlag()))
		{
			int oldpayintv = inPolElementSchema.getPayIntv();
			LNPRiskParamDB tLNPRiskParamDB = new LNPRiskParamDB();
			tLNPRiskParamDB.setType("RelaToMainRisk");
			tLNPRiskParamDB.setRiskCode(inPolElementSchema.getRiskCode());
			LNPRiskParamSet tLNPRiskParamSet = tLNPRiskParamDB.query();
			LNPPolDB mainLNPPolDB = new LNPPolDB();
			mainLNPPolDB.setPolNo(inPolElementSchema.getMasterPolNo());
			if (mainLNPPolDB.getInfo() && tLNPRiskParamSet != null && tLNPRiskParamSet.size() > 0)
			{
				for (int i = 1; i <= tLNPRiskParamSet.size(); i++)
				{
					LNPRiskParamSchema tempLNPRiskParamSchema = tLNPRiskParamSet.get(i);
					String result = getDataFromMainPol(tempLNPRiskParamSchema, mainLNPPolDB);
					if (result != null && !result.equals("null") && !result.equals(""))
					{
						String param = tempLNPRiskParamSchema.getParam();
						if (param.equals("Amnt"))
						{
							inPolElementSchema.setAmnt(Double.parseDouble(result));
							inPolElementSchema.setGet(Double.parseDouble(result));
						} else
						if (param.equals("Get"))
						{
							inPolElementSchema.setAmnt(Double.parseDouble(result));
							inPolElementSchema.setGet(Double.parseDouble(result));
						} else
						if (param.equals("Prem"))
							inPolElementSchema.setPrem(Double.parseDouble(result));
						else
						if (param.equals("Mult"))
							inPolElementSchema.setMult(Double.parseDouble(result));
						else
						if (param.equals("PayIntv"))
						{
							oldpayintv = inPolElementSchema.getPayIntv();
							inPolElementSchema.setPayIntv(Integer.parseInt(result));
							int newpayintv = inPolElementSchema.getPayIntv();
							String riskcode = inPolElementSchema.getRiskCode();
							if (inPolElementSchema.getPayEndYear() == 1000 && newpayintv != 0 && "ADR".equals(riskcode) && "PWA".equals(mainLNPPolDB.getRiskCode()))
							{
								inPolElementSchema.setPayEndYear(5);
								inPolElementSchema.setPayEndYearFlag("Y");
							}
						} else
						if (param.equals("InsuYear"))
							inPolElementSchema.setInsuYear(Integer.parseInt(result));
						else
						if (param.equals("InsuYearFlag"))
							inPolElementSchema.setInsuYearFlag(result);
						else
						if (param.equals("PayEndYear"))
							inPolElementSchema.setPayEndYear(Integer.parseInt(result));
						else
						if (param.equals("PayEndYearFlag"))
							inPolElementSchema.setPayEndYearFlag(result);
						else
						if (param.equals("LiveGetMode"))
							inPolElementSchema.setLiveGetMode(result);
						else
						if (param.equals("StandbyFlag1"))
							inPolElementSchema.setStandbyFlag1(result);
						else
						if (param.equals("StandbyFlag2"))
							inPolElementSchema.setStandbyFlag2(result);
						else
						if (param.equals("StandbyFlag3"))
							inPolElementSchema.setStandbyFlag3(result);
					}
				}

			}
			if (oldpayintv != 0 || mainLNPPolDB.getPayIntv() == 0)
				inPolElementSchema.setPayIntv(mainLNPPolDB.getPayIntv());
		} else
		{
			inPolElementSchema.setSubRiskFlag("M");
		}
		String sql = (new StringBuilder("SELECT * FROM lnpduty where dutycode in (select dutycode from lnpriskduty where riskcode='")).append(inPolElementSchema.getRiskCode()).append("')").toString();
		LNPDutyDB reLNPDutyDB = new LNPDutyDB();
		LNPDutySet reLNPDutySet = reLNPDutyDB.executeQuery(sql);
		reLNPDutyDB = reLNPDutySet.get(1).getDB();
		inPolElementSchema.setDutyCode(reLNPDutyDB.getDutyCode());
		inPolElementSchema.setVPU((new StringBuilder(String.valueOf(reLNPDutyDB.getVPU()))).toString());
		String flag = reLNPDutyDB.getInsuYearRela();
		if (flag.equals("4"))
		{
			inPolElementSchema.setInsuYear(reLNPDutyDB.getInsuYear());
			inPolElementSchema.setInsuYearFlag(reLNPDutyDB.getInsuYearFlag());
		}
		flag = reLNPDutyDB.getPayEndYearRela();
		if (flag.equals("4"))
		{
			inPolElementSchema.setPayEndYear(reLNPDutyDB.getPayEndYear());
			inPolElementSchema.setPayEndYearFlag(reLNPDutyDB.getPayEndYearFlag());
		}
		flag = reLNPDutyDB.getGetYearRela();
		if (flag.equals("4"))
		{
			inPolElementSchema.setGetYear(reLNPDutyDB.getGetYear());
			inPolElementSchema.setGetYearFlag(reLNPDutyDB.getGetYearFlag());
		}
		return inPolElementSchema;
	}

	private String getDataFromMainPol(LNPRiskParamSchema inLNPRiskParamSchema, LNPPolSchema mainLNPPolShcema)
	{
		String expression = inLNPRiskParamSchema.getExpression();
		Hashtable reHashtable = new Hashtable();
		reHashtable.put("Amnt", Double.valueOf(mainLNPPolShcema.getAmnt()));
		reHashtable.put("TopUpPrem", Double.valueOf(mainLNPPolShcema.getTopUpPrem()));
		reHashtable.put("DeadAmntType", (new StringBuilder(String.valueOf(mainLNPPolShcema.getDeadAmntType()))).toString());
		reHashtable.put("Get", Double.valueOf(mainLNPPolShcema.getAmnt()));
		reHashtable.put("Prem", Double.valueOf(mainLNPPolShcema.getPrem()));
		reHashtable.put("Mult", Double.valueOf(mainLNPPolShcema.getMult()));
		reHashtable.put("PayIntv", Integer.valueOf(mainLNPPolShcema.getPayIntv()));
		reHashtable.put("InsuYear", Integer.valueOf(mainLNPPolShcema.getInsuYear()));
		reHashtable.put("InsuYearFlag", (new StringBuilder(String.valueOf(mainLNPPolShcema.getInsuYearFlag()))).toString());
		reHashtable.put("PayEndYear", Integer.valueOf(mainLNPPolShcema.getPayEndYear()));
		reHashtable.put("PayEndYearFlag", (new StringBuilder(String.valueOf(mainLNPPolShcema.getPayEndYearFlag()))).toString());
		reHashtable.put("LiveGetMode", (new StringBuilder(String.valueOf(mainLNPPolShcema.getLiveGetMode()))).toString());
		reHashtable.put("StandbyFlag1", (new StringBuilder(String.valueOf(mainLNPPolShcema.getStandbyFlag1()))).toString());
		reHashtable.put("StandbyFlag2", (new StringBuilder(String.valueOf(mainLNPPolShcema.getStandbyFlag2()))).toString());
		reHashtable.put("StandbyFlag3", (new StringBuilder(String.valueOf(mainLNPPolShcema.getStandbyFlag3()))).toString());
		reHashtable.put("MainRiskCode", (new StringBuilder(String.valueOf(mainLNPPolShcema.getRiskCode()))).toString());
		EvalJavaTool evalJavaTool = new EvalJavaTool();
		ForSpcCalImpl forSpcCalImpl = new ForSpcCalImpl();
		reHashtable.put("SpcCalInst", forSpcCalImpl);
		String result = evalJavaTool.executeByExpress(expression, reHashtable);
		return result;
	}

	private PolElementSchema dealPolData(PolElementSchema inPolElementSchema, String dutyCode)
	{
		LNPDutyDB reLNPDutyDB = new LNPDutyDB();
		reLNPDutyDB.setDutyCode(dutyCode);
		if (reLNPDutyDB.getInfo())
		{
			String flag = reLNPDutyDB.getInsuYearRela();
			if (flag.equals("2"))
			{
				inPolElementSchema.setInsuYear(inPolElementSchema.getGetYear());
				inPolElementSchema.setInsuYearFlag(inPolElementSchema.getGetYearFlag());
			} else
			if (flag.equals("1"))
			{
				inPolElementSchema.setInsuYear(inPolElementSchema.getPayEndYear());
				inPolElementSchema.setInsuYearFlag(inPolElementSchema.getPayEndYearFlag());
			}
			flag = reLNPDutyDB.getPayEndYearRela();
			if ("2".equals(flag))
			{
				inPolElementSchema.setPayEndYear(inPolElementSchema.getGetYear());
				inPolElementSchema.setPayEndYearFlag(inPolElementSchema.getGetYearFlag());
			} else
			if ("3".equals(flag))
			{
				inPolElementSchema.setPayEndYear(inPolElementSchema.getInsuYear());
				inPolElementSchema.setPayEndYearFlag(inPolElementSchema.getInsuYearFlag());
			}
			flag = reLNPDutyDB.getGetYearRela();
			if ("1".equals(flag))
			{
				inPolElementSchema.setGetYear(inPolElementSchema.getPayEndYear());
				inPolElementSchema.setGetYearFlag(inPolElementSchema.getPayEndYearFlag());
			} else
			if ("3".equals(flag))
			{
				inPolElementSchema.setGetYear(inPolElementSchema.getInsuYear());
				inPolElementSchema.setGetYearFlag(inPolElementSchema.getInsuYearFlag());
			}
			int years = 0;
			if ("Y".equals(inPolElementSchema.getInsuYearFlag()))
				years = inPolElementSchema.getInsuYear();
			else
			if ("A".equals(inPolElementSchema.getInsuYearFlag()))
				if ("Y".equals(inPolElementSchema.getAppAgeType()))
					years = inPolElementSchema.getInsuYear() - inPolElementSchema.getAppAge();
				else
				if ("D".equals(inPolElementSchema.getAppAgeType()))
					years = inPolElementSchema.getInsuYear() - 0;
			inPolElementSchema.setYears(years);
			int payyears = 0;
			if ("Y".equals(inPolElementSchema.getPayEndYearFlag()))
				payyears = inPolElementSchema.getPayEndYear();
			else
			if ("A".equals(inPolElementSchema.getPayEndYearFlag()))
				if ("Y".equals(inPolElementSchema.getAppAgeType()))
					payyears = inPolElementSchema.getPayEndYear() - inPolElementSchema.getAppAge();
				else
				if ("D".equals(inPolElementSchema.getAppAgeType()))
					payyears = inPolElementSchema.getPayEndYear() - 0;
			inPolElementSchema.setPayYears(payyears);
		}
		return inPolElementSchema;
	}

	private void savePolData(PolElementSchema inPolElementSchema)
		throws Exception
	{
		LNPPolDB weLNPPolDB = new LNPPolDB();
		weLNPPolDB.setGrpContNo(inPolElementSchema.getGrpContNo());
		weLNPPolDB.setGrpPolNo(inPolElementSchema.getGrpPolNo());
		weLNPPolDB.setPrtNo(inPolElementSchema.getPrtNo());
		weLNPPolDB.setProposalContNo(inPolElementSchema.getProposalContNo());
		weLNPPolDB.setProposalNo(inPolElementSchema.getProposalNo());
		weLNPPolDB.setContNo(inPolElementSchema.getContNo());
		weLNPPolDB.setPolNo(inPolElementSchema.getPolNo());
		weLNPPolDB.setMainPolNo(inPolElementSchema.getMainPolNo());
		weLNPPolDB.setMasterPolNo(inPolElementSchema.getMasterPolNo());
		weLNPPolDB.setRiskCode(inPolElementSchema.getRiskCode());
		weLNPPolDB.setManageCom(inPolElementSchema.getManageCom());
		weLNPPolDB.setSaleChnl(inPolElementSchema.getRiskChannel());
		weLNPPolDB.setInsuredId(inPolElementSchema.getInsuredId());
		weLNPPolDB.setInsuredNo(inPolElementSchema.getInsuredNo());
		weLNPPolDB.setGetYear(inPolElementSchema.getGetYear());
		weLNPPolDB.setGetYearFlag(inPolElementSchema.getGetYearFlag());
		weLNPPolDB.setPayEndYear(inPolElementSchema.getPayEndYear());
		weLNPPolDB.setPayEndYearFlag(inPolElementSchema.getPayEndYearFlag());
		weLNPPolDB.setInsuYear(inPolElementSchema.getInsuYear());
		weLNPPolDB.setInsuYearFlag(inPolElementSchema.getInsuYearFlag());
		weLNPPolDB.setPayIntv(inPolElementSchema.getPayIntv());
		weLNPPolDB.setPayYears(inPolElementSchema.getPayYears());
		weLNPPolDB.setYears(inPolElementSchema.getYears());
		weLNPPolDB.setAmnt(inPolElementSchema.getAmnt());
		weLNPPolDB.setPrem(inPolElementSchema.getPrem());
		weLNPPolDB.setTopUpPrem(inPolElementSchema.getTopUpPrem());
		weLNPPolDB.setDeadAmntType(inPolElementSchema.getDeadAmntType());
		weLNPPolDB.setStandPrem(inPolElementSchema.getStandardPrem());
		weLNPPolDB.setMult(inPolElementSchema.getMult());
		weLNPPolDB.setLiveGetMode(inPolElementSchema.getLiveGetMode());
		weLNPPolDB.setBonusGetMode(inPolElementSchema.getBonusGetMode());
		weLNPPolDB.setSubFlag(inPolElementSchema.getSubRiskFlag());
		weLNPPolDB.setOperator(inPolElementSchema.getAgentCode());
		weLNPPolDB.setStandbyFlag1(inPolElementSchema.getStandbyFlag1());
		weLNPPolDB.setStandbyFlag2(inPolElementSchema.getStandbyFlag2());
		weLNPPolDB.setStandbyFlag3(inPolElementSchema.getStandbyFlag3());
		weLNPPolDB.setAppFlag("0");
		weLNPPolDB.setContType("1");
		weLNPPolDB.setPolTypeFlag("0");
		weLNPPolDB.setPolState("1");
		weLNPPolDB.setSaleChnlDetail(inPolElementSchema.getBranchType());
		weLNPPolDB.setMakeDate(inPolElementSchema.getMakeDate());
		weLNPPolDB.setMakeTime(inPolElementSchema.getMakeTime());
		String modifydate = PubFun.getCurrentDate();
		String modifytime = PubFun.getCurrentTime();
		weLNPPolDB.setModifyDate(modifydate);
		weLNPPolDB.setModifyTime(modifytime);
		try
		{
			weLNPPolDB.insert();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("���汣�����ʧ��?.");
		}
	}
}
