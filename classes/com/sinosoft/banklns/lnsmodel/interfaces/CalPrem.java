// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CalPrem.java

package com.sinosoft.banklns.lnsmodel.interfaces;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.MMap;
import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import org.jdom.Element;
import org.jdom.Namespace;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.interfaces:
//			PublicInterfaces

public class CalPrem extends PublicInterfaces
{

	private LNPContSchema tLNPContSchema;
	private LNPPolSet tLNPPolSet;
	private LNPAppntSet tLNPAppntSet;
	private LNPAddressSet tLnpAddressSet;
	private LNPInsuredSet tLNPInsuredSet;
	private boolean flag;
	private String rnewflag;
	private String userName;
	private String password;

	public CalPrem()
	{
		tLNPContSchema = null;
		tLNPPolSet = null;
		tLNPAppntSet = null;
		tLnpAddressSet = null;
		tLNPInsuredSet = null;
		flag = false;
		rnewflag = "";
	}

	protected void initObject()
	{
		modelFileName = "prem_in.xml";
		sendFileName = "prem_in";
		returnFileName = "prem_out";
		defaultErrorMessage = "保费计算失败！";
		super.initObject();
	}

	protected boolean dealReturn()
	{
		LNPPolSet bakLnpPolSet;
		LNPContSchema bakSchema;
		Element returnN;
		String valiReason;
		bakLnpPolSet = new LNPPolSet();
		bakLnpPolSet.set(tLNPPolSet);
		bakSchema = new LNPContSchema();
		bakSchema.setSchema(tLNPContSchema);
		returnN = getReturnBody();
		Namespace err = Namespace.getNamespace("http://www.csc.smart/bo/schemas/Error");
		Element errorN = returnN.getChild("ERROR", err);
		if (errorN == null)
			break MISSING_BLOCK_LABEL_158;
		System.out.println("EAI调用LA成功，但返回了错误！");
		Element statusN = errorN.getChild("STATUS", err);
		Element reason = errorN.getChild("REASON", err);
		valiReason = reason.getChild("ERROR_DESC", err).getText();
		this;
		message;
		JVM INSTR new #132 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		valiReason;
		append();
		toString();
		message;
		System.out.println((new StringBuilder("ERROR_DESC==")).append(message).toString());
		return false;
		Element premiumN;
		premiumN = returnN.getChild("PREMIUM");
		if (premiumN != null)
			break MISSING_BLOCK_LABEL_181;
		System.out.println("*************************SOAP ERROR************MSP接口PRMService调用出错！");
		return false;
		System.out.println((new StringBuilder("--PREMIUM --")).append(premiumN.getName()).toString());
		if (!"0".equals(getValueInXML(premiumN, "ERRCODE")))
			break MISSING_BLOCK_LABEL_1778;
		setModifyTime(tLNPContSchema);
		tLNPContSchema.setPrem(0.0D);
		tLNPContSchema.setSumPrem(0.0D);
		String premstring = getValueInXML(premiumN, "TOTAL");
		if (premstring != null && !"".equals(premstring))
		{
			tLNPContSchema.setPrem(premstring);
			tLNPContSchema.setSumPrem(premstring);
		}
		LNPPolSet mLNPPolSet = (new LNPPolDB(con)).executeQuery((new StringBuilder("select * from lnppol where contno='")).append(tContNo).append("' and RiskVersion is not null and RiskVersion<>''").toString());
		LNPPolSchema tPolSchema = new LNPPolSchema();
		LNPPolSet zLNPPolSet = new LNPPolSet();
		Element insuredList = premiumN.getChild("INSUREDLIST");
		Element insured = insuredList.getChild("INSURED");
		List insrskamntItemN = insured.getChildren("INSRSKAMNT");
		System.out.println(insrskamntItemN);
		LNPRiskAmountSet riskAmountSet = new LNPRiskAmountSet();
		LNPRiskAmountSet bakRiskAmountSet = (new LNPRiskAmountDB(con)).executeQuery((new StringBuilder("select * from LNPRiskAmount where contno='")).append(tLNPContSchema.getContNo()).append("'").toString());
		for (Iterator iterator = insrskamntItemN.iterator(); iterator.hasNext();)
		{
			Element e = (Element)iterator.next();
			LNPRiskAmountSchema tSchema = new LNPRiskAmountSchema();
			String ZNRSKCD02 = getValueInXML(e, "ZNRSKCD02");
			if (!"".equals(ZNRSKCD02))
			{
				tSchema.setcontno(tLNPContSchema.getContNo());
				tSchema.setftype(getValueInXML(e, "ZNRSKCD02"));
				tSchema.setfamnt(getValueInXML(e, "SUMINS02"));
				setSaveTime(tSchema);
				riskAmountSet.add(tSchema);
			}
		}

		List coverages = insured.getChild("COVERAGELIST").getChildren();
		System.out.println((new StringBuilder("----------------coverage.size=")).append(coverages.size()).toString());
		System.out.println(coverages);
		if (flag)
		{
			SysMaxNoMAPNP MaxNoMap = new SysMaxNoMAPNP();
			for (int j = 0; j < coverages.size(); j++)
			{
				Element tmpb = (Element)coverages.get(j);
				LNPPolSchema tSchema = new LNPPolSchema();
				if (j == 0 && ("1".equals(mLNPPolSet.get(j + 1).getRnewFlag()) || "2".equals(mLNPPolSet.get(j + 1).getRnewFlag())))
					tPolSchema = mLNPPolSet.get(j + 1);
				else
				if ("1".equals(mLNPPolSet.get(j).getRnewFlag()) || "2".equals(mLNPPolSet.get(j).getRnewFlag()))
					tPolSchema = mLNPPolSet.get(j);
				tSchema.setSchema(tPolSchema);
				setSaveTime(tSchema);
				if ("00".equals(getValueInXML(tmpb, "RIDER")))
				{
					tSchema.setRnewFlag(rnewflag);
					tSchema.setSubFlag("M");
				} else
				{
					tSchema.setRnewFlag("");
					tSchema.setSubFlag("S");
				}
				tSchema.setPolNo(MaxNoMap.CreateMaxNo("CustomerNo", ""));
				tSchema.setRiskCode(getValueInXML(tmpb, "ZNPRDCODE"));
				tSchema.setAmnt(getValueInXML(tmpb, "SUMIN"));
				tSchema.setSumPrem(tLNPContSchema.getSumPrem());
				tSchema.setPrem(getValueInXML(tmpb, "INSTPRM"));
				tSchema.setManageFeeRate(getValueInXML(tmpb, "INSTPRM"));
				if (turnNullToString(tSchema.getPayMode()).equals("") || Integer.parseInt(tSchema.getPayMode()) <= 0 || turnNullToString(tSchema.getPayMode()).equals("1000") && !"1".equals(turnNullToString(getValueInXML(tmpb, "PCESSTRM"))) && !"0".equals(turnNullToString(getValueInXML(tmpb, "PCESSTRM"))))
					if (!turnNullToString(getValueInXML(tmpb, "PCESSAGE")).equals(""))
					{
						tSchema.setPayMode(turnNullToString(getValueInXML(tmpb, "PCESSAGE")));
						tSchema.setAcciYearFlag("A");
					} else
					{
						tSchema.setPayMode(turnNullToString(getValueInXML(tmpb, "PCESSTRM")));
						tSchema.setAcciYearFlag("Y");
					}
				if (!turnNullToString(getValueInXML(tmpb, "RCESSAGE")).equals(""))
				{
					tSchema.setPayLocation(turnNullToString(getValueInXML(tmpb, "RCESSAGE")));
					tSchema.setPremToAmnt("A");
				} else
				if (!turnNullToString(getValueInXML(tmpb, "RCESSTRM")).equals(""))
				{
					tSchema.setPayLocation(turnNullToString(getValueInXML(tmpb, "RCESSTRM")));
					tSchema.setPremToAmnt("Y");
				}
				zLNPPolSet.add(tSchema);
			}

		} else
		{
			for (int j = 0; j < coverages.size(); j++)
			{
				Element tmpb = (Element)coverages.get(j);
				LNPPolSchema pol = null;
				for (int h = 0; h < tLNPPolSet.size(); h++)
				{
					if (!tLNPPolSet.get(h + 1).getRiskCode().equals(getValueInXML(tmpb, "ZNPRDCODE")) || !tLNPPolSet.get(h + 1).getHandler().equals(getValueInXML(tmpb, "RIDER")))
						continue;
					pol = tLNPPolSet.get(h + 1);
					break;
				}

				if (pol != null)
				{
					setSaveTime(pol);
					pol.setAmnt(getValueInXML(tmpb, "SUMIN"));
					pol.setSumPrem(fomartNum(tLNPContSchema.getSumPrem()));
					pol.setPrem(getValueInXML(tmpb, "INSTPRM"));
					pol.setManageFeeRate(getValueInXML(tmpb, "INSTPRM"));
					if (pol.getPayEndYear() <= 0 || pol.getPayEndYear() == 1000 && !"1".equals(turnNullToString(getValueInXML(tmpb, "PCESSTRM"))) && !"0".equals(turnNullToString(getValueInXML(tmpb, "PCESSTRM"))))
						if (!turnNullToString(getValueInXML(tmpb, "PCESSAGE")).equals(""))
						{
							pol.setPayEndYear(turnNullToString(getValueInXML(tmpb, "PCESSAGE")));
							pol.setPayEndYearFlag("A");
						} else
						{
							pol.setPayEndYear(turnNullToString(getValueInXML(tmpb, "PCESSTRM")));
							pol.setPayEndYearFlag("Y");
						}
					if (pol.getInsuYear() <= 0)
						if (!turnNullToString(getValueInXML(tmpb, "RCESSAGE")).equals(""))
						{
							pol.setInsuYear(turnNullToString(getValueInXML(tmpb, "RCESSAGE")));
							pol.setInsuYearFlag("A");
						} else
						{
							pol.setInsuYear(turnNullToString(getValueInXML(tmpb, "RCESSTRM")));
							pol.setInsuYearFlag("Y");
						}
				}
			}

		}
		if (flag)
		{
			bakMap.put(mLNPPolSet, "DELETE");
			bakMap.put(zLNPPolSet, "DELETE");
			bakMap.put(tPolSchema, "DELETE&INSERT");
			map.put(mLNPPolSet, "DELETE");
			map.put(zLNPPolSet, "INSERT");
		} else
		{
			bakMap.put(bakLnpPolSet, "UPDATE");
			map.put(tLNPPolSet, "UPDATE");
		}
		bakMap.put(riskAmountSet, "DELETE");
		bakMap.put(bakRiskAmountSet, "DELETE&INSERT");
		map.put(riskAmountSet, "DELETE&INSERT");
		bakMap.put(bakSchema, "UPDATE");
		map.put(tLNPContSchema, "UPDATE");
		return true;
		try
		{
			message = getValueInXML(premiumN, "PDESC");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	}

	protected boolean dealSend()
	{
		try
		{
			Element msgBody = getSendBody();
			String company = mappingCode(tLNPContSchema.getManageCom(), "BankSigned");
			Namespace msp = Namespace.getNamespace("http://www.csc.smart/msp/schemas/MSPContext");
			List msgList = msgBody.getChildren();
			Element mspContent = (Element)msgList.get(0);
			Element userId = mspContent.getChild("UserId", msp);
			userId.setText(userName);
			Element uerPassword = mspContent.getChild("UserPassword", msp);
			uerPassword.setText(password);
			Element reqps = mspContent.getChild("RequestParameters", msp);
			Element requestParameter = reqps.getChild("RequestParameter", msp);
			requestParameter.setAttribute("name", "BRANCH").setAttribute("value", company);
			Element premium = msgBody.getChild("PREMIUM");
			updateText(premium, "ZNBAKFLD", "");
			updateText(premium, "CNTBRANCH", company);
			updateText(premium, "TTMPRCNO", tLNPContSchema.getContNo());
			updateText(premium, "CHDRTYPE", "");
			updateText(premium, "OCCDATE", fomartDate(tLNPContSchema.getPValiDate()));
			Element policyOwner = premium.getChild("POLICYOWNER");
			updateText(policyOwner, "OWNERSEL", tLNPContSchema.getAppntNo());
			updateText(policyOwner, "DOB", fomartDate(tLNPAppntSet.get(1).getAppntBirthday()));
			updateText(policyOwner, "AGE", turnNullToString(Integer.valueOf(tLNPAppntSet.get(1).getAppntAge())));
			updateText(policyOwner, "CLTSEX", mappingCode(tLNPAppntSet.get(1).getAppntSex(), "BankPolicySex"));
			updateText(policyOwner, "OCCUP", tLNPAppntSet.get(1).getOccupationCode());
			LNPPolSet tset = (new LNPPolDB()).executeQuery((new StringBuilder("select * from lnppol where contno='")).append(tContNo).append("' and RiskVersion is not null and RiskVersion<>'' and RnewFlag in('1','2')").toString());
			if (tset.size() > 0)
			{
				flag = true;
				rnewflag = tset.get(1).getRnewFlag();
				updateText(premium, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(tset.get(1).getPayIntv())), "BankFrequency"));
			} else
			{
				updateText(premium, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(tLNPPolSet.get(1).getPayIntv())), "BankFrequency"));
			}
			updateText(premium, "SRCEBUS", "3");
			if (tset.size() > 0 && "2".equals(tset.get(1).getRnewFlag()))
				updateText(premium, "SRCEBUS", turnToCode(tset.get(1).getUWTime()));
			updateText(premium, "CNTCURR", "CNY");
			updateText(premium, "BILLCURR", "CNY");
			Element insured = premium.getChild("INSUREDLIST").getChild("INSURED");
			updateText(insured, "Life", "01");
			updateText(insured, "LIFCNUM", tLNPContSchema.getInsuredNo());
			updateText(insured, "CLTDOB", fomartDate(tLNPInsuredSet.get(1).getBirthday()));
			updateText(insured, "INSAGE", turnNullToString(Integer.valueOf(tLNPInsuredSet.get(1).getAppAge())));
			updateText(insured, "SEX", mappingCode(tLNPInsuredSet.get(1).getSex(), "BankPolicySex"));
			updateText(insured, "OCCUPD", tLNPInsuredSet.get(1).getOccupationCode());
			if (flag)
			{
				Element packageInfo = insured.getChild("PACKAGEINFO");
				updateText(packageInfo, "ZNPKGCODE", turnNullToString(tset.get(1).getRiskVersion()));
				updateText(packageInfo, "TOTPRE", turnNullToString(tset.get(1).getRemark()));
				updateText(packageInfo, "ZTOTSI", "0");
				Element coverage = insured.getChild("COVERAGELIST");
				Element acoverage = coverage.getChild("COVERAGEINFO");
				if (tset.size() > 1)
				{
					coverage.removeContent();
					int i;
					for (i = 0; i < 2; i++)
					{
						Element tempCoverage = (Element)acoverage.clone();
						updateText(tempCoverage, "COVERAGE", "");
						updateText(tempCoverage, "CCDATE", "0");
						updateText(tempCoverage, "RIDER", "");
						updateText(tempCoverage, "ZNPRDCODE", "");
						updateText(tempCoverage, "SUMIN", "0");
						updateText(tempCoverage, "ZNDISPER", "0");
						updateText(tempCoverage, "ZNRFAGE", "0");
						updateText(tempCoverage, "RCESSAGE", "0");
						updateText(tempCoverage, "RCESSTRM", "0");
						updateText(tempCoverage, "INSTPRM", "0");
						updateText(tempCoverage, "JLSEX", "");
						updateText(tempCoverage, "ZNJLAGE", "0");
						updateText(tempCoverage, "BENPLN", "");
						updateText(tempCoverage, "LIVESNO", "");
						coverage.addContent(tempCoverage);
					}

					i = 2;
					int j = 2;
					for (; i <= tset.size(); i++)
					{
						Element tempCoverage = (Element)acoverage.clone();
						LNPPolSchema tempPol = tset.get(i);
						updateText(tempCoverage, "COVERAGE", "01");
						updateText(tempCoverage, "CCDATE", fomartDate(tLNPContSchema.getPValiDate()));
						String tRiskIdx = null;
						if ("M".equalsIgnoreCase(tempPol.getSubFlag()))
						{
							tRiskIdx = (new StringBuilder("0")).append(j++).toString();
							updateText(tempCoverage, "RIDER", tRiskIdx);
						}
						tempPol.setHandler(tRiskIdx);
						updateText(tempCoverage, "ZNPRDCODE", tempPol.getRiskVersion());
						updateText(tempCoverage, "SUMIN", turnNullToString(Integer.valueOf((int)tempPol.getAmnt())));
						updateText(tempCoverage, "ZNDISPER", "1");
						updateText(tempCoverage, "ZNRFAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
						if ("A".equals(tempPol.getInsuYearFlag()))
							updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
						else
							updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
						if ("A".equals(tempPol.getPayEndYearFlag()))
							updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
						else
							updateText(tempCoverage, "PCESSTRM", "1000".equals(turnNullToString(Integer.valueOf(tempPol.getPayEndYear()))) ? "1" : turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
						updateText(tempCoverage, "INSTPRM", turnNullToString(fomartNum(tempPol.getPrem())));
						updateText(tempCoverage, "JLSEX", "");
						updateText(tempCoverage, "ZNJLAGE", "0");
						updateText(tempCoverage, "BENPLN", "");
						updateText(tempCoverage, "LIVESNO", "");
						coverage.addContent(tempCoverage);
					}

				}
			} else
			{
				Element coverage = insured.getChild("COVERAGELIST");
				Element acoverage = coverage.getChild("COVERAGEINFO");
				if (tLNPPolSet.size() > 0)
					coverage.removeContent();
				int i = 1;
				int j = 1;
				for (; i <= tLNPPolSet.size(); i++)
				{
					Element tempCoverage = (Element)acoverage.clone();
					LNPPolSchema tempPol = tLNPPolSet.get(i);
					updateText(tempCoverage, "COVERAGE", "01");
					updateText(tempCoverage, "CCDATE", fomartDate(tLNPContSchema.getPValiDate()));
					String tRiskIdx;
					if (!"M".equalsIgnoreCase(tempPol.getSubFlag()))
					{
						tRiskIdx = (new StringBuilder("0")).append(j++).toString();
						updateText(tempCoverage, "RIDER", tRiskIdx);
					} else
					{
						tRiskIdx = "00";
						updateText(tempCoverage, "RIDER", tRiskIdx);
					}
					tempPol.setHandler(tRiskIdx);
					updateText(tempCoverage, "ZNPRDCODE", tempPol.getRiskCode());
					updateText(tempCoverage, "SUMIN", turnNullToString(Integer.valueOf((int)tempPol.getAmnt())));
					updateText(tempCoverage, "ZNDISPER", "1");
					updateText(tempCoverage, "ZNRFAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
					if ("A".equals(tempPol.getInsuYearFlag()))
						updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
					else
						updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
					if ("A".equals(tempPol.getPayEndYearFlag()))
						updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
					else
						updateText(tempCoverage, "PCESSTRM", "1000".equals(turnNullToString(Integer.valueOf(tempPol.getPayEndYear()))) ? "1" : turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
					updateText(tempCoverage, "INSTPRM", turnNullToString(fomartNum(tempPol.getPrem())));
					updateText(tempCoverage, "JLSEX", "");
					updateText(tempCoverage, "ZNJLAGE", "0");
					updateText(tempCoverage, "BENPLN", "");
					updateText(tempCoverage, "LIVESNO", "");
					coverage.addContent(tempCoverage);
				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected boolean getInputData(String tContNo)
	{
		flag = false;
		super.valiPassFlag = true;
		if (tContNo == null || tContNo.equals(""))
			break MISSING_BLOCK_LABEL_1055;
		ExeSQL exeSQL = new ExeSQL(con);
		SSRS ssrs = exeSQL.execSQL("select sysvartype,sysvarvalue from lnpsysvar where SysVar='issue_user_password'");
		if (ssrs.MaxRow > 0)
		{
			userName = ssrs.GetText(1, 1);
			password = ssrs.GetText(1, 2);
			break MISSING_BLOCK_LABEL_87;
		}
		message = "缺失权限,请获取权限后继续操作!";
		return valiPassFlag = false;
		LNPContDB tLNPContDB = new LNPContDB(con);
		tLNPContDB.setContNo(tContNo);
		if (!tLNPContDB.getInfo())
			break MISSING_BLOCK_LABEL_179;
		tLNPContSchema = tLNPContDB.getSchema();
		String msg = "请完善“基础信息”部分的信息项！";
		if (!turnNullToString(tLNPContSchema.getManageCom()).equals("") && !turnNullToString(tLNPContSchema.getPValiDate()).equals(""))
			break MISSING_BLOCK_LABEL_193;
		message = msg;
		return valiPassFlag = false;
		message = "获取投保书信息失败！";
		return valiPassFlag = false;
		LNPPolDB lnpDb;
		lnpDb = new LNPPolDB(con);
		tLNPPolSet = lnpDb.executeQuery((new StringBuilder("select 1 from lnppol where contno='")).append(tContNo).append("'").toString());
		if (tLNPPolSet.size() > 0)
			break MISSING_BLOCK_LABEL_261;
		message = "险种信息未填写！";
		return valiPassFlag = false;
		String msg;
		int i;
		tLNPPolSet = lnpDb.executeQuery((new StringBuilder("select * from lnppol where contno='")).append(tContNo).append("'").toString());
		msg = "请完善“投保事项”中“险种信息”部分的信息项！";
		i = 1;
		  goto _L1
_L5:
		LNPPolSchema tSchema = tLNPPolSet.get(i);
		if (!turnNullToString(tSchema.getRiskVersion()).equals("") || !turnNullToString(Integer.valueOf(tSchema.getPayIntv())).equals("") && !turnNullToString(tSchema.getRiskCode()).equals("") && (!turnNullToString(Double.valueOf(tSchema.getAmnt())).equals("") || !turnNullToString(Double.valueOf(tSchema.getPrem())).equals(""))) goto _L3; else goto _L2
_L2:
		message = msg;
		return valiPassFlag = false;
_L3:
		if (i != 1 || !"03".equals(tSchema.getKindCode()) || !turnNullToString(Integer.valueOf(tSchema.getPayIntv())).equals("") && (!turnNullToString(Double.valueOf(tSchema.getAmnt())).equals("") || !turnNullToString(Double.valueOf(tSchema.getPrem())).equals("") || !turnNullToString(tSchema.getRemark()).equals("")) && (tSchema.getAmnt() > 0.0D || tSchema.getPrem() > 0.0D || !turnNullToString(tSchema.getRemark()).equals("")) && !turnNullToString(tSchema.getPayMode()).equals("") && !turnNullToString(tSchema.getPayLocation()).equals(""))
			continue; /* Loop/switch isn't completed */
		message = msg;
		return valiPassFlag = false;
		i++;
_L1:
		if (i <= tLNPPolSet.size()) goto _L5; else goto _L4
_L4:
		LNPAppntDB tLNPAppntDB = new LNPAppntDB(con);
		tLNPAppntDB.setContNo(tContNo);
		tLNPAppntSet = tLNPAppntDB.query();
		if (tLNPAppntSet.size() > 0)
			break MISSING_BLOCK_LABEL_668;
		message = "请先设置投保人！";
		return valiPassFlag = false;
		String msg;
		msg = "请完善“客户信息”中“投保人信息”部分的信息项！";
		tSchema = tLNPAppntSet.get(1);
		LNPAddressDB tAddressBDB = new LNPAddressDB();
		tAddressBDB.setCustomerId(tSchema.getAppntId());
		tAddressBDB.setAddressNo(tSchema.getAddressNo());
		tLnpAddressSet = tAddressBDB.query();
		if (tLnpAddressSet.size() > 0)
			break MISSING_BLOCK_LABEL_745;
		message = "请完整录入投保人的信息！";
		return valiPassFlag = false;
		LNPAddressSchema tAddressSchema = tLnpAddressSet.get(1);
		if (!turnNullToString(tAddressSchema.getEMail()).equals(""))
			break MISSING_BLOCK_LABEL_786;
		message = "投保人地址录入不完整";
		return valiPassFlag = false;
		if (!turnNullToString(tSchema.getAppntName()).equals("") && !turnNullToString(tSchema.getIDNo()).equals("") && !turnNullToString(tSchema.getAppntSex()).equals("") && !turnNullToString(tSchema.getAppntBirthday()).equals("") && !turnNullToString(Integer.valueOf(tSchema.getAppntAge())).equals(""))
			break MISSING_BLOCK_LABEL_887;
		message = msg;
		return valiPassFlag = false;
		LNPInsuredDB tLNPInsuredDB = new LNPInsuredDB(con);
		tLNPInsuredDB.setContNo(tContNo);
		tLNPInsuredSet = tLNPInsuredDB.query();
		if (tLNPInsuredSet.size() > 0)
			break MISSING_BLOCK_LABEL_939;
		message = "请先设置被保人！";
		return valiPassFlag = false;
		String msg = "请完善“客户信息”中“被保人信息”部分的信息项！";
		LNPInsuredSchema tSchema = tLNPInsuredSet.get(1);
		if (!turnNullToString(tSchema.getName()).equals("") && !turnNullToString(tSchema.getIDNo()).equals("") && !turnNullToString(tSchema.getSex()).equals("") && !turnNullToString(tSchema.getBirthday()).equals("") && !turnNullToString(Integer.valueOf(tSchema.getAppAge())).equals(""))
			break MISSING_BLOCK_LABEL_1081;
		message = msg;
		return valiPassFlag = false;
		message = "缺失投保书号！";
		return valiPassFlag = false;
		Exception ex;
		ex;
		ex.printStackTrace();
		return valiPassFlag = false;
		return true;
	}

	private boolean isExistDoubleRisk(LNPPolSet tLnpPolSet)
	{
		boolean flag = false;
		for (int i = 1; i <= tLnpPolSet.size(); i++)
		{
			if (flag)
				break;
			LNPPolSchema tSchema = tLnpPolSet.get(i);
			for (int j = 1; j <= tLnpPolSet.size(); j++)
			{
				if (!tSchema.getRiskCode().equals(tLnpPolSet.get(j).getRiskCode()))
					continue;
				flag = true;
				break;
			}

		}

		return flag;
	}

	public static void main(String args[])
	{
		CalPrem cal = new CalPrem();
		String tContNo = "123213213123";
		tContNo = "098765431111";
		tContNo = "201804261007";
		tContNo = "201812271556";
		cal.calInterfaces(tContNo);
	}
}
