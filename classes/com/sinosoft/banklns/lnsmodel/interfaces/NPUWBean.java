// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   NPUWBean.java

package com.sinosoft.banklns.lnsmodel.interfaces;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.MMap;
import com.sinosoft.banklns.lis.pubfun.PubFun;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import org.jdom.Element;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.interfaces:
//			PublicInterfaces

public class NPUWBean extends PublicInterfaces
{

	private LNPContSchema tLNPContSchema;
	private LNPInsuredSchema tLNPInsuredSchema;
	private LNPAppntSchema tLNPAppntSchema;
	private LNPAddressSchema tAppntAddressSchema;
	private LNPAddressSchema tInsurAddressSchema;
	private LNPBnfSet tLNPBnfSet;
	private LNPPolSet tLNPPolSet;
	private LNPPolSet tLNPPolSet2;
	private LNPCUWMasterSchema tLNPCUWMasterSchema;
	private LNPUWMasterSet tLNPUWMasterSet;
	private LNPPaymentSchema tLNPPaymentSchema;
	private LNPBonusInfoSchema tLNPBonusInfoSchema;
	private LNPAgentInfoSet tLNPAgentInfoSet;
	private LNPInvestmentInfoSchema tLNPInvestmentInfoSchema;
	private LNPInvestmentAccountInfoSet tLNpInvestmentAccountInfoSet;
	private LNPRiskAmountSet tLnpRiskAmountSet;

	public NPUWBean()
	{
		tLNPContSchema = null;
		tLNPInsuredSchema = null;
		tLNPAppntSchema = null;
		tAppntAddressSchema = null;
		tInsurAddressSchema = null;
		tLNPBnfSet = null;
		tLNPPolSet = null;
		tLNPPolSet2 = null;
		tLNPCUWMasterSchema = null;
		tLNPUWMasterSet = null;
		tLNPPaymentSchema = null;
		tLNPBonusInfoSchema = null;
		tLNPAgentInfoSet = null;
		tLNPInvestmentInfoSchema = null;
	}

	protected void initObject()
	{
		interfacesFlag = false;
		modelFileName = "aura_in.xml";
		sendFileName = "aura_in";
		returnFileName = "aura_out";
		defaultErrorMessage = "???????§µ??????";
		super.initObject();
	}

	protected boolean dealReturn()
	{
label0:
		{
			Element auratx;
			Element allDecisionsN;
			List decisionNList;
			Element cDec;
			Iterator iterator;
			try
			{
				tLNPPolSet = (new LNPPolDB(con)).executeQuery((new StringBuilder("select * from lnppol where contno='")).append(tContNo).append("'").toString());
				LNPContSchema bakLNPContSchema = new LNPContSchema();
				bakLNPContSchema.setSchema(tLNPContSchema);
				auratx = getReturnBody();
				if (!"ACC".equals(getValueInXML(auratx, "ZNCNTUW")) && !"RUW".equals(getValueInXML(auratx, "ZNCNTUW")))
					break label0;
				String zncntuw = getValueInXML(auratx, "ZNCNTUW");
				if (tLNPCUWMasterSchema == null)
				{
					tLNPCUWMasterSchema = new LNPCUWMasterSchema();
					setSaveTime(tLNPCUWMasterSchema);
					tLNPCUWMasterSchema.setContNo(tLNPContSchema.getContNo());
					tLNPCUWMasterSchema.setAppDecision(zncntuw);
					bakMap.put(tLNPCUWMasterSchema, "DELETE");
					map.put(tLNPCUWMasterSchema, "INSERT");
				} else
				if (tLNPCUWMasterSchema != null)
				{
					LNPCUWMasterSchema bakLNPCUWMasterSchema = tLNPCUWMasterSchema.getSchema();
					bakMap.put(bakLNPCUWMasterSchema, "UPDATE");
					setModifyTime(tLNPCUWMasterSchema);
					tLNPCUWMasterSchema.setAppDecision(zncntuw);
					map.put(tLNPCUWMasterSchema, "UPDATE");
				}
				List OverallDecisions = auratx.getChild("Insureds").getChild("Insured").getChild("OverallDecisions").getChildren("Decision");
				LNPUWMasterSet tempSet = new LNPUWMasterSet();
				for (int i = 0; i < OverallDecisions.size(); i++)
				{
					Element tempEle = (Element)OverallDecisions.get(i);
					LNPUWMasterSchema tempSchema = new LNPUWMasterSchema();
					setSaveTime(tempSchema);
					tempSchema.setContNo(tLNPContSchema.getContNo());
					tempSchema.setGrpContNo(tLNPContSchema.getGrpContNo());
					tempSchema.setProposalContNo(tLNPContSchema.getProposalContNo());
					tempSchema.setOperator("OPERATOR");
					String ZNPRDCODE = getValueInXML(tempEle, "ZNPRDCODE");
					Element UnderwritingDecision = tempEle.getChild("UnderwritingDecision");
					String ZNCOVUW = getValueInXML(UnderwritingDecision, "ZNCOVUW");
					String FUPCODE = getValueInXML(UnderwritingDecision, "FUPCODE");
					String MESSAGE = getValueInXML(UnderwritingDecision, "MESSAGE");
					tempSchema.setRiderCode(ZNPRDCODE);
					tempSchema.setUWDid(ZNCOVUW);
					tempSchema.setDeclinedCode(FUPCODE);
					tempSchema.setDeclinedReason(MESSAGE);
					for (int j = 1; j <= tLNPPolSet.size(); j++)
					{
						LNPPolSchema lnpPol = tLNPPolSet.get(j);
						if (!lnpPol.getRiskCode().equals(ZNPRDCODE))
							continue;
						tempSchema.setPolNo(lnpPol.getPolNo());
						tempSchema.setProposalNo(lnpPol.getPolNo());
						tempSet.add(tempSchema);
						break;
					}

				}

				setModifyTime(tLNPContSchema);
				bakMap.put(tLNPUWMasterSet, "INSERT");
				map.put(tLNPUWMasterSet, "DELETE");
				bakMap.put(tempSet, "DELETE");
				map.put(tempSet, "INSERT");
				bakMap.put(bakLNPContSchema, "UPDATE");
				map.put(tLNPContSchema, "UPDATE");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return false;
			}
			return true;
		}
		message = getValueInXML(auratx, "PDESC");
		if (!"".equals(message) && message != null) goto _L2; else goto _L1
_L1:
		allDecisionsN = auratx.getChild("Insureds").getChild("Insured").getChild("OverallDecisions");
		decisionNList = allDecisionsN.getChildren();
		iterator = decisionNList.iterator();
		  goto _L3
_L4:
		cDec = (Element)iterator.next();
		this;
		message;
		JVM INSTR new #111 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" ????:";
		append();
		cDec.getChild("ZNPRDCODE").getText();
		append();
		",";
		append();
		cDec.getChild("UnderwritingDecision").getChild("MESSAGE").getText();
		append();
		";";
		append();
		toString();
		message;
_L3:
		if (iterator.hasNext()) goto _L4; else goto _L2
_L2:
		return false;
	}

	protected boolean dealSend()
	{
		try
		{
			Element auratx = getSendBody();
			String company = mappingCode(tLNPContSchema.getManageCom(), "BankSigned");
			Element auraControl = auratx.getChild("AuraControl");
			updateText(auraControl, "UniqueID", (new StringBuilder(String.valueOf(tLNPContSchema.getContNo().trim()))).append("_U").toString());
			updateText(auraControl, "UniqueID", (new StringBuilder(String.valueOf(fomartDate(PubFun.getCurrentDate())))).append(PubFun.getCurrentTime().replace(":", "")).append("_U").toString());
			updateText(auraControl, "Company", "mlc");
			updateText(auraControl, "SetCode", "16");
			updateText(auraControl, "SubSet", "2");
			updateText(auraControl, "PostBackTo", "review.jsp");
			updateText(auraControl, "PostErrorsTo", "review.jsp");
			updateText(auraControl, "SaveExitPage", "review.jsp");
			Element policy = auratx.getChild("POLICY");
			updateText(policy, "ZNUWCAT", "NB");
			updateText(policy, "ZNEXTSYS", "4");
			updateText(policy, "PRT1OPT", "Y");
			updateText(policy, "PRT2OPT", "Y");
			updateText(policy, "ZNGPCNO", "");
			updateText(policy, "STATCODE", "PS");
			updateText(policy, "CNTBRANCH", company);
			updateText(policy, "TTMPRCNO", tLNPContSchema.getContNo());
			updateText(policy, "Chdrnum", "");
			updateText(policy, "OCCDATE", fomartDate(tLNPContSchema.getPValiDate()));
			updateText(policy, "HPROPDTE", fomartDate(tLNPContSchema.getPSignDate()));
			updateText(policy, "HPRRCVDT", fomartDate(tLNPAgentInfoSet.get(1).getP1()));
			updateText(policy, "ZDDTEDIF", turnNullToString(Integer.valueOf(PubFun.calInterval(turnNullToString(tLNPAgentInfoSet.get(1).getP1()), turnNullToString(tLNPContSchema.getPSignDate()), "D"))));
			Element policyOwner = policy.getChild("PolicyOwner");
			updateText(policyOwner, "OWNERSEL", "".equals(turnNullToString(tLNPAppntSchema.getAppntNo())) ? "01" : tLNPAppntSchema.getAppntNo());
			updateText(policyOwner, "OWNERSEL", "01");
			updateText(policyOwner, "SALUTL", "MR / MRS");
			updateText(policyOwner, "LSURNAME", tLNPAppntSchema.getAppntName());
			updateText(policyOwner, "DOB", fomartDate(tLNPAppntSchema.getAppntBirthday()));
			updateText(policyOwner, "Age", turnNullToString(Integer.valueOf(tLNPAppntSchema.getAppntAge())));
			updateText(policyOwner, "ZDDAYS", "");
			updateText(policyOwner, "CLTSEX", mappingCode(tLNPAppntSchema.getAppntSex(), "BankPolicySex"));
			updateText(policyOwner, "MARRYD", "");
			updateText(policyOwner, "ZACLTADDR", combAddress(tAppntAddressSchema.getCompanyFax(), tAppntAddressSchema.getBP2(), tAppntAddressSchema.getCompanyAddress()));
			updateText(policyOwner, "CLTPCODE", tAppntAddressSchema.getCompanyZipCode());
			updateText(policyOwner, "ADDRTYPE", "1");
			updateText(policyOwner, "ZNBUSUT", tAppntAddressSchema.getGrpName());
			updateText(policyOwner, "CTRYCODE", tLNPAppntSchema.getNativePlace());
			updateText(policyOwner, "NATLTY", tLNPAppntSchema.getNativePlace());
			updateText(policyOwner, "CLRSKIND", "1");
			updateText(policyOwner, "RSKFLG", "1");
			updateText(policyOwner, "IDNPRF", mappingCode(tLNPAppntSchema.getIDType(), "BankCertType"));
			updateText(policyOwner, "SECUITYNO", tLNPAppntSchema.getIDNo());
			updateText(policyOwner, "EXPDTE", "1".equals(tLNPAppntSchema.getIDPerpetual()) ? fomartDate(tLNPAppntSchema.getIDValidity()) : fomartDate(mappingCode(tLNPAppntSchema.getIDPerpetual(), "BankCertificatesType")));
			updateText(policyOwner, "INCPRF", "");
			updateText(policyOwner, "INCDESC", "");
			updateText(policyOwner, "DECGRSAL", turnNullToString(Double.valueOf(tLNPAppntSchema.getSalary())));
			updateText(policyOwner, "RMBLPHONE", tAppntAddressSchema.getPhone());
			updateText(policyOwner, "CLTPHONE", combPhone(tAppntAddressSchema.getMobileChs2(), tAppntAddressSchema.getCompanyPhone()));
			updateText(policyOwner, "RINTERNET", tAppntAddressSchema.getCompanyMail());
			updateText(policyOwner, "OCCPCODE", tLNPAppntSchema.getOccupationCode());
			updateText(policyOwner, "ZNPIDCPYID", mappingCode(tLNPAppntSchema.getHealth(), "BankIsOrNo"));
			if (tLnpRiskAmountSet.size() > 0)
			{
				Element owriskList = policy.getChild("OWNRISKSILIST");
				policy.removeContent(owriskList);
				for (int i = 1; i <= tLnpRiskAmountSet.size(); i++)
				{
					Element tempElement = (Element)owriskList.clone();
					updateText(tempElement, "ZNRSKCD", tLnpRiskAmountSet.get(i).getftype());
					updateText(tempElement, "SUMINS", turnNullToString(Double.valueOf(tLnpRiskAmountSet.get(i).getfamnt())));
					policy.addContent(tempElement);
				}

			}
			updateText(policy, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(tLNPContSchema.getPayIntv())), "BankFrequency"));
			updateText(policy, "ZNFPMOP", mappingCode(tLNPPaymentSchema.getPayMent1(), "BankRenewal"));
			updateText(policy, "MOP", mappingCode(tLNPPaymentSchema.getPayMent2(), "BankRenewal"));
			updateText(policy, "ZDIVOPT", tLNPBonusInfoSchema.getBonusWay());
			updateText(policy, "ZNFOPT", tLNPBonusInfoSchema.getP2());
			updateText(policy, "CNTCURR", "CNY");
			updateText(policy, "BILLCURR", "CNY");
			updateText(policy, "REGISTER", "PRC");
			updateText(policy, "SRCEBUS", "2");
			updateText(policy, "DLVRMODE", "01,02,03".indexOf(turnNullToString(tLNPAgentInfoSet.get(1).getP3())) != -1 ? mappingCode(tLNPAgentInfoSet.get(1).getP3(), "BankDeliveryType") : "04");
			updateText(policy, "ZAPSTADD", combAddress(tAppntAddressSchema.getHomeFax(), tAppntAddressSchema.getBP(), tAppntAddressSchema.getHomeAddress()));
			updateText(policy, "CLTPCODE03", tAppntAddressSchema.getHomeZipCode());
			updateText(policy, "ZNAGNTSEL", tLNPAgentInfoSet.get(1).getP2());
			updateText(policy, "AGCOMRT", turnNullToString(Integer.valueOf(100 / tLNPAgentInfoSet.size())));
			if (tLNPAgentInfoSet.size() == 2)
			{
				Element subAgent = policy.getChild("SubAgentList");
				updateText(subAgent, "ZNAGNTSEL01", tLNPAgentInfoSet.get(2).getAgentCode());
				updateText(subAgent, "SPLITC", turnNullToString(Integer.valueOf(100 / tLNPAgentInfoSet.size())));
			}
			updateText(policy, "ZNCSMNAME", "");
			if (tLNPPolSet2.get(1).getRnewFlag().equals("2") && (tLNPPolSet2.get(1).getUWTime().equals("AGY") || tLNPPolSet2.get(1).getUWTime().equals("TM")))
				updateText(policy, "ZNCSMNAME", tLNPContSchema.getInputOperator());
			Element insured = policy.getChild("INSLST").getChild("Insured");
			updateText(insured, "Life", "01");
			Element inrisk = insured.getChild("INSRISKSILIST");
			updateText(inrisk, "ZNRSKCD02", "");
			updateText(inrisk, "SUMINS02", "");
			Element insuredInfo = insured.getChild("InsuredInfo");
			updateText(insuredInfo, "LIFCNUM", "".equals(turnNullToString(tLNPInsuredSchema.getInsuredNo())) ? "01" : tLNPInsuredSchema.getInsuredNo());
			updateText(insuredInfo, "SALUTL02", "MR / MRS");
			updateText(insuredInfo, "LSURNAME02", tLNPInsuredSchema.getName());
			updateText(insuredInfo, "DOB02", fomartDate(tLNPInsuredSchema.getBirthday()));
			updateText(insuredInfo, "Age02", turnNullToString(Integer.valueOf(tLNPInsuredSchema.getAppAge())));
			updateText(insuredInfo, "ZDDays02", "");
			updateText(insuredInfo, "CLTSEX02", mappingCode(tLNPInsuredSchema.getSex(), "BankPolicySex"));
			updateText(insuredInfo, "MARRYD02", "");
			updateText(insuredInfo, "ZACLTADDR02", combAddress(tInsurAddressSchema.getCompanyFax(), tInsurAddressSchema.getBP2(), tInsurAddressSchema.getCompanyAddress()));
			updateText(insuredInfo, "CLTPCODE02", tInsurAddressSchema.getCompanyZipCode());
			updateText(insuredInfo, "ADDRTYPE02", "1");
			updateText(insuredInfo, "ZNBUSUT02", tInsurAddressSchema.getGrpName());
			updateText(insuredInfo, "CTRYCODE02", tLNPInsuredSchema.getNativePlace());
			updateText(insuredInfo, "NATLTY02", tLNPInsuredSchema.getNativePlace());
			updateText(insuredInfo, "CLRSKIND02", "1");
			updateText(insuredInfo, "RSKFLG02", "1");
			updateText(insuredInfo, "IDNPRF02", mappingCode(tLNPInsuredSchema.getIDType(), "BankCertType"));
			updateText(insuredInfo, "SECUITYNO02", tLNPInsuredSchema.getIDNo());
			updateText(insuredInfo, "EXPDTE02", "1".equals(tLNPInsuredSchema.getIDPerpetual()) ? fomartDate(tLNPInsuredSchema.getIDValidity()) : fomartDate(mappingCode(tLNPInsuredSchema.getIDPerpetual(), "BankCertificatesType")));
			updateText(insuredInfo, "INCPRF02", "");
			updateText(insuredInfo, "INCDESC02", "");
			updateText(insuredInfo, "DECGRSAL02", turnNullToString(Double.valueOf(tLNPInsuredSchema.getSalary())));
			updateText(insuredInfo, "RMBLPHONE02", tInsurAddressSchema.getPhone());
			updateText(insuredInfo, "CLTPHONE02", combPhone(tInsurAddressSchema.getMobileChs2(), tInsurAddressSchema.getCompanyPhone()));
			updateText(insuredInfo, "RINTERNET02", tInsurAddressSchema.getCompanyMail());
			updateText(insuredInfo, "OCCPCODE02", tLNPInsuredSchema.getOccupationCode());
			updateText(insuredInfo, "ZNPIDCPYID02", mappingCode(tLNPInsuredSchema.getHealth(), "BankIsOrNo"));
			updateText(insured, "RELATION", mappingCode(tLNPAppntSchema.getRelationToInsured(), "BankRelationship"));
			updateText(insured, "SELECTION", "");
			updateText(insured, "HEIGHT", "");
			updateText(insured, "WEIGHT", "");
			updateText(insured, "SMOKING", "");
			updateText(insured, "OCCUP", tLNPInsuredSchema.getOccupationCode());
			Element questionArea = insured.getChild("Questionare");
			updateText(questionArea, "QUESTSET", "MTQBA");
			LNPCodeSet codeSet = new LNPCodeSet();
			LNPCodeDB db = new LNPCodeDB(con);
			db.setCodeType("BanktoLAQuesveiw");
			codeSet = db.query();
			Element questionList = questionArea.getChild("QuestionList");
			Element question = questionList.getChild("Question");
			questionList.removeContent();
			for (int i = 1; i <= codeSet.size(); i++)
			{
				Element tempElement = (Element)question.clone();
				updateText(tempElement, "QUESTIDF", codeSet.get(i).getCode());
				updateText(tempElement, "ANSWER", mappingQues(codeSet.get(i).getCode(), codeSet.get(i).getOtherSign(), tLNPContSchema.getContNo()));
				questionList.addContent(tempElement);
			}

			updateText(insured, "HUWDCDTE", "99999999");
			Element coverageList = insured.getChild("COVLST");
			Element coverageInfo = coverageList.getChild("COVINF");
			coverageList.removeContent();
			int i = 1;
			int j = 1;
			for (; i <= tLNPPolSet.size(); i++)
			{
				Element tempCoverage = (Element)coverageInfo.clone();
				LNPPolSchema tempPol = tLNPPolSet.get(i);
				updateText(tempCoverage, "Coverage", "01");
				if (!"M".equalsIgnoreCase(tempPol.getSubFlag()))
					updateText(tempCoverage, "RIDER", (new StringBuilder("0")).append(j++).toString());
				else
					updateText(tempCoverage, "RIDER", "00");
				updateText(tempCoverage, "ZNPRDCODE", (new StringBuilder(String.valueOf(tempPol.getRiskCode()))).append("999").toString());
				updateText(tempCoverage, "SUMIN", turnNullToString(Double.valueOf(tempPol.getAmnt())));
				if ("A".equals(tempPol.getInsuYearFlag()))
					updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
				else
					updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
				if ("A".equals(tempPol.getPayEndYearFlag()))
					updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
				else
					updateText(tempCoverage, "PCESSTRM", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
				if ("A".equals(tempPol.getGetYearFlag()))
					updateText(tempCoverage, "BCESSAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
				else
					updateText(tempCoverage, "BCESSTRM", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
				updateText(tempCoverage, "MORTCLS", "2");
				updateText(tempCoverage, "INSTPRM", turnNullToString(Double.valueOf(tempPol.getPrem())));
				updateText(tempCoverage, "ZPRFLG", "N");
				if (tLNPInvestmentInfoSchema != null)
				{
					updateText(tempCoverage, "LMPCNT", tLNPInvestmentInfoSchema.getPayExtraPremFlag());
					updateText(tempCoverage, "ZPRFLG", "Y");
					updateText(tempCoverage, "ZNINVAMT", turnNullToString(Double.valueOf(tLNPInvestmentInfoSchema.getMonthPlusPrem())));
					updateText(tempCoverage, "ZNTRM", tLNPInvestmentInfoSchema.getTermInvestment());
				}
				updateText(tempCoverage, "ZUNIT", "1");
				updateText(tempCoverage, "LIVESNO", "1");
				updateText(tempCoverage, "PAYCLT", tLNPInsuredSchema.getInsuredNo());
				Element payBankInfor = tempCoverage.getChild("PayBankInfor");
				if ("02".equals(tLNPPaymentSchema.getPayMent1()))
				{
					updateText(payBankInfor, "BANKCODE", "");
					updateText(payBankInfor, "BANKKEY", tLNPPaymentSchema.getBankCode());
					updateText(payBankInfor, "BANKACCKEY", tLNPPaymentSchema.getAccount());
					updateText(payBankInfor, "BANKDESC", tLNPPaymentSchema.getBankCode());
					updateText(payBankInfor, "BNKACTYP", "");
					updateText(payBankInfor, "CURRCODE", "CNY");
					updateText(payBankInfor, "DATEFROM", fomartDate(tLNPContSchema.getPValiDate()));
					updateText(payBankInfor, "TIMESUSE", "");
				}
				updateText(tempCoverage, "FREQANN", "");
				updateText(tempCoverage, "ADVANCE", "");
				updateText(tempCoverage, "ARREARS", "");
				updateText(tempCoverage, "GUARPERD", "");
				updateText(tempCoverage, "WITHPROP", "");
				updateText(tempCoverage, "WITHOPROP", "");
				updateText(tempCoverage, "NOMLIFE", "");
				updateText(tempCoverage, "DTHPERCN", "");
				updateText(tempCoverage, "DTHPERCO", "");
				Element payment = tempCoverage.getChild("Payment");
				updateText(payment, "PAYCLT02", "");
				updateText(payment, "CLTYPE", "");
				updateText(payment, "RGPYMOP", "");
				updateText(payment, "REGPAYFREQ", "");
				updateText(payment, "PRCNT", "");
				updateText(payment, "CLAIMCUR", "CNY");
				updateText(tempCoverage, "RSUNIN", "");
				updateText(tempCoverage, "PRCAMTIND", "");
				Element PRMFundList = tempCoverage.getChild("PRMFLST");
				for (int x = 1; x <= tLNpInvestmentAccountInfoSet.size() && x <= 10; x++)
					if (x < 10)
					{
						updateText(PRMFundList, (new StringBuilder("VRTFND0")).append(x).toString(), tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
						updateText(PRMFundList, (new StringBuilder("UALPRC0")).append(x).toString(), turnNullToString(Double.valueOf(tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate())));
					} else
					{
						updateText(PRMFundList, (new StringBuilder("VRTFND")).append(x).toString(), tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
						updateText(PRMFundList, (new StringBuilder("UALPRC")).append(x).toString(), turnNullToString(Double.valueOf(tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate())));
					}

				Element RGUFundList = tempCoverage.getChild("RGUFLST");
				for (int x = 1; x <= tLNpInvestmentAccountInfoSet.size() && x <= 10; x++)
					if (x < 10)
					{
						updateText(RGUFundList, (new StringBuilder("ZAVRTFND0")).append(x).toString(), tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
						updateText(RGUFundList, (new StringBuilder("ZNSPLAMT0")).append(x).toString(), turnNullToString(Double.valueOf(tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate())));
					} else
					{
						updateText(RGUFundList, (new StringBuilder("ZNSPLAMT")).append(x).toString(), tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
						updateText(RGUFundList, (new StringBuilder("ZNSPLAMT")).append(x).toString(), turnNullToString(Double.valueOf(tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate())));
					}

				updateText(tempCoverage, "ZACOVBAK01", "");
				updateText(tempCoverage, "ZACOVBAK02", "");
				updateText(tempCoverage, "ZACOVBAK03", "");
				updateText(tempCoverage, "ZACOVBAK04", "");
				updateText(tempCoverage, "ZACOVBAK05", "");
				coverageList.addContent(tempCoverage);
			}

			Element bnfList = policy.getChild("BeneficiaryList");
			Element bnf = bnfList.getChild("Beneficiary");
			bnfList.removeContent();
			if (tLNPInsuredSchema.getInsuredPeoples() > 0)
			{
				for (int x = 1; x <= tLNPBnfSet.size(); x++)
				{
					LNPBnfSchema tempSchema = tLNPBnfSet.get(x);
					Element tempBnf = (Element)bnf.clone();
					updateText(tempBnf, "BNYTYPE", (new StringBuilder("0")).append(tempSchema.getBenefitType()).toString());
					updateText(tempBnf, "BNYSEL", tempSchema.getBnfNo());
					updateText(tempBnf, "SALUTL04", "MR / MRS");
					updateText(tempBnf, "LSURNAME04", tempSchema.getBnfName());
					updateText(tempBnf, "DOB04", fomartDate(tempSchema.getBnfBirthday()));
					updateText(tempBnf, "CLTSEX04", mappingCode(tempSchema.getBnfSex(), "BankPolicySex"));
					updateText(tempBnf, "MARRYD04", "");
					updateText(tempBnf, "ZACLTADDR04", "");
					updateText(tempBnf, "ADDRTYPE04", "");
					updateText(tempBnf, "ZNBUSUT04", "");
					updateText(tempBnf, "CTRYCODE04", "");
					updateText(tempBnf, "NATLTY04", "");
					updateText(tempBnf, "IDNPRF04", mappingCode(tempSchema.getIDType(), "BankCertType"));
					updateText(tempBnf, "SECUITYNO04", tempSchema.getIDNo());
					updateText(tempBnf, "EXPDTE04", "1".equals(tempSchema.getIDPerpetual()) ? fomartDate(tempSchema.getIDValidity()) : fomartDate(mappingCode(tempSchema.getIDPerpetual(), "BankCertificatesType")));
					updateText(tempBnf, "ZNPIDCPYID04", "");
					updateText(tempBnf, "CLTRELN02", mappingCode(tempSchema.getRelationToInsured(), "BankBenefitAndInsured"));
					updateText(tempBnf, "BNYPC", turnNullToString(Double.valueOf(tempSchema.getBenefitRate())));
					updateText(tempBnf, "ZBNYTLVL", Integer.parseInt(tempSchema.getBenefitOrder()) >= 10 ? tempSchema.getBenefitOrder() : (new StringBuilder("0")).append(tempSchema.getBenefitOrder()).toString());
					updateText(tempBnf, "EFFDATE", "");
					updateText(tempBnf, "ZDCLMPLN", mappingCode(tLNPInsuredSchema.getCreditGrade(), "BankIsOrNo"));
					bnfList.addContent(tempBnf);
				}

			}
			if ("02".equals(tLNPPaymentSchema.getPayMent1()))
			{
				Element FRTRecBank = policy.getChild("FRTRecBank");
				updateText(FRTRecBank, "BANKKEY02", tLNPPaymentSchema.getBankCode());
				updateText(FRTRecBank, "BANKACCKEY02", tLNPPaymentSchema.getAccount());
				updateText(FRTRecBank, "BANKDESC02", tLNPPaymentSchema.getBankCode());
				updateText(FRTRecBank, "BNKACTYP02", "");
				updateText(FRTRecBank, "CURRCODE02", "");
				updateText(FRTRecBank, "DATEFROM01", tLNPContSchema.getPValiDate());
				updateText(FRTRecBank, "DATETO", "");
			}
			if ("02".equals(tLNPPaymentSchema.getPayMent2()))
			{
				Element SEQRecBank = policy.getChild("SEQRecBank");
				updateText(SEQRecBank, "BANKKEY03", tLNPPaymentSchema.getBankCode());
				updateText(SEQRecBank, "BANKACCKEY03", tLNPPaymentSchema.getAccount());
				updateText(SEQRecBank, "BANKDESC03", tLNPPaymentSchema.getBankCode());
				updateText(SEQRecBank, "BNKACTYP03", "");
				updateText(SEQRecBank, "CURRCODE03", "CNY");
				updateText(SEQRecBank, "DATEFROM02", tLNPContSchema.getPValiDate());
				updateText(SEQRecBank, "DATETO02", "");
			}
			updateText(policy, "TRANDATEX", "");
			updateText(policy, "BANKCODER", "");
			updateText(policy, "TCHQDATE", "");
			updateText(policy, "BANKDESC01R", "1");
			updateText(policy, "BANKDESC03R", "");
			updateText(policy, "RFCODE", "CN");
			updateText(policy, "RFNUM", "");
			updateText(policy, "PAYTYPE", "");
			updateText(policy, "DOCORIGAMT", "");
			updateText(policy, "ZNOVRPAYOP", "");
			LNPPolSet tset = (new LNPPolDB(con)).executeQuery((new StringBuilder("select * from lnppol where contno='")).append(tContNo).append("' and RiskVersion is not null and RiskVersion<>'' and RnewFlag='1'").toString());
			if (tset.size() > 0)
			{
				Element packageInfo = policy.getChild("PackageInfo");
				System.out.println(tset.get(1).getRiskVersion());
				updateText(packageInfo, "ZNPKGCODE", tset.get(1).getRiskVersion());
				updateText(packageInfo, "TOTPRE", turnNullToString(tset.get(1).getRemark()));
				updateText(packageInfo, "ZTOTSI", "");
			}
			Element remark = policy.getChild("GeneralRemark");
			updateText(remark, "ALINE01", "");
			updateText(remark, "ALINE02", "");
			updateText(policy, "SACSCODE", "");
			updateText(policy, "SACSTYPE", "");
			updateText(policy, "CAMPAIGN", "");
			updateText(policy, "ZNPRJTCD", "");
			updateText(policy, "ZNEPOLFLG", "");
			updateText(policy, "ZNBNKODR", "");
			updateText(policy, "ZNDISPER", "");
			updateText(policy, "ZNSPCTYP", "");
			updateText(policy, "ZNBILLNO", "");
			updateText(policy, "ZNINVBNK", "");
			updateText(policy, "ZNVIPIND", "");
			updateText(policy, "ZAPOLFLD1", "");
			updateText(policy, "ZAPOLFLD2", "");
			updateText(policy, "ZAPOLFLD3", "");
			updateText(policy, "ZAPOLFLD4", "");
			updateText(policy, "ZAPOLFLD5", "");
			Element hisIn = auratx.getChild("HisIn");
			Element polhis = hisIn.getChild("POLHIS");
			Element inPolicyOwner = polhis.getChild("PolicyOwner");
			updateText(inPolicyOwner, "OWNERSEL05", tLNPAppntSchema.getAppntNo());
			updateText(inPolicyOwner, "LSURNAME05", tLNPAppntSchema.getAppntName());
			updateText(inPolicyOwner, "DOB05", "");
			updateText(inPolicyOwner, "CLTSEX05", "");
			updateText(inPolicyOwner, "SECUITYNO05", "");
			updateText(inPolicyOwner, "RMBLPHONE05", "");
			updateText(inPolicyOwner, "CLTPHONE05", "");
			Element inInsured = polhis.getChild("InsuredList").getChild("Insured");
			updateText(inInsured, "LIFCNUM06", tLNPInsuredSchema.getInsuredNo());
			updateText(inInsured, "LSURNAME06", tLNPInsuredSchema.getName());
			updateText(inInsured, "DOB06", "");
			updateText(inInsured, "CLTSEX06", "");
			updateText(inInsured, "SECUITYNO06", "");
			updateText(inInsured, "RMBLPHONE06", "");
			updateText(inInsured, "CLTPHONE06", "");
			List benefList = polhis.getChildren("BeneficiaryList");
			Element benLst = (Element)benefList.get(benefList.size() - 1);
			Element beneficiary = benLst.getChild("Beneficiary");
			benLst.removeContent();
			for (int x = 1; x <= tLNPBnfSet.size(); x++)
			{
				LNPBnfSchema tempSchema = tLNPBnfSet.get(x);
				Element benef = (Element)beneficiary.clone();
				updateText(benef, "LSURNAME07", tempSchema.getBnfName());
				updateText(benef, "BNYSEL07", "");
				updateText(benef, "DOB07", "");
				updateText(benef, "CLTSEX07", "");
				updateText(benef, "SECUITYNO07", "");
			}

			Element policiInfo = polhis.getChild("PolicyInfo");
			updateText(policiInfo, "CNTBRANCH02", company);
			updateText(policiInfo, "TTMPRCNO02", tContNo);
			updateText(policiInfo, "CHDRNUM02", tLNPContSchema.getMainPolNo());
			updateText(policiInfo, "ZNAGNTSEL02", tLNPAgentInfoSet.get(1).getAgentCode());
			updateText(policiInfo, "CHDRTYPE", "");
			updateText(policiInfo, "ZNCSMNAME02", "");
			updateText(policiInfo, "HPROPDTE02", fomartDate(tLNPContSchema.getPSignDate()));
			updateText(policiInfo, "LIFE02", "01");
			Element covlist = policiInfo.getChild("COVLIST");
			updateText(covlist, "COVERAGE02", "");
			updateText(covlist, "RIDER02", "");
			updateText(covlist, "ZNPRDCODE02", "");
			covlist.removeContent();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String mappingQues(String code, String otherSign, String contNo)
	{
		return null;
	}

	private String combAddress(String companyFax, String bp2, String companyAddress)
	{
		return null;
	}

	protected boolean getInputData(String tContNo)
	{
		valiPassFlag = true;
		if (tContNo == null || tContNo.equals(""))
			return valiPassFlag = false;
		LNPContDB tLNPContDB;
		tLNPContDB = new LNPContDB(con);
		tLNPContDB.setContNo(tContNo);
		if (tLNPContDB.getInfo())
			break MISSING_BLOCK_LABEL_64;
		message = "???????????????";
		return valiPassFlag = false;
		String msg;
		tLNPContSchema = tLNPContDB.getSchema();
		msg = "??????????????????????????";
		if (!turnNullToString(tLNPContSchema.getManageCom()).equals("") && !turnNullToString(tLNPContSchema.getPValiDate()).equals("") && !turnNullToString(tLNPContSchema.getPSignDate()).equals(""))
			break MISSING_BLOCK_LABEL_148;
		message = msg;
		return valiPassFlag = false;
		tLNPPolSet = (new LNPPolDB(con)).executeQuery((new StringBuilder("select * from LNPPol where contno='")).append(tContNo).append("'").toString());
		if (tLNPPolSet.size() > 0)
			break MISSING_BLOCK_LABEL_212;
		message = "??????§Õ?????????";
		return valiPassFlag = false;
		int i;
		tLNPPolSet2 = tLNPPolSet;
		tLNPPolSet = (new LNPPolDB(con)).executeQuery((new StringBuilder("select * from lnppol where contno='")).append(tContNo).append("' and (RiskVersion is null or RiskVersion='')").toString());
		msg = "???????????????§³????????????????????";
		i = 1;
		  goto _L1
_L3:
		LNPPolSchema tSchema = tLNPPolSet.get(i);
		if (!turnNullToString(tSchema.getRiskVersion()).equals("") || !turnNullToString(Integer.valueOf(tSchema.getPayIntv())).equals("") && !turnNullToString(tSchema.getRiskCode()).equals("") && (!turnNullToString(Double.valueOf(tSchema.getAmnt())).equals("") || !turnNullToString(Double.valueOf(tSchema.getPrem())).equals("")))
			continue; /* Loop/switch isn't completed */
		message = msg;
		return valiPassFlag = false;
		i++;
_L1:
		if (i <= tLNPPolSet.size()) goto _L3; else goto _L2
_L2:
		LNPCUWMasterDB cuw = new LNPCUWMasterDB(con);
		cuw.setContNo(tContNo);
		if (cuw.getInfo())
			tLNPCUWMasterSchema = cuw.getSchema();
		tLNPUWMasterSet = (new LNPUWMasterDB(con)).executeQuery((new StringBuilder("select * from LNPUWMaster where ContNo='")).append(tContNo).append("'").toString());
		tLNPAppntSchema = (new LNPAppntDB(con)).executeQuery((new StringBuilder("select * from lnpappnt where contno='")).append(tContNo).append("'").toString()).get(1);
		tAppntAddressSchema = (new LNPAddressDB(con)).executeQuery((new StringBuilder("select * from lnpaddress a where  exists(select 1 from lnpappnt b where a.customerid=b.appntid  and b.contno='")).append(tContNo).append("')").toString()).get(1);
		if (tLNPAppntSchema != null && tAppntAddressSchema != null)
			break MISSING_BLOCK_LABEL_596;
		message = "????????????";
		return valiPassFlag = false;
		String msg;
		msg = "????????????????§³?????????????????????";
		LNPAppntSchema tSchema = tLNPAppntSchema;
		if (!turnNullToString(tSchema.getAppntName()).equals("") && !turnNullToString(Integer.valueOf(tSchema.getAppntAge())).equals("") && !turnNullToString(tSchema.getAppntSex()).equals("") && !turnNullToString(tSchema.getAppntBirthday()).equals("") && !turnNullToString(tAppntAddressSchema.getCompanyAddress()).equals("") && !turnNullToString(tAppntAddressSchema.getCompanyZipCode()).equals("") && !turnNullToString(tSchema.getNativePlace()).equals("") && !turnNullToString(tSchema.getIDType()).equals("") && !turnNullToString(tSchema.getIDNo()).equals("") && !turnNullToString(tSchema.getIDValidity()).equals("") && !turnNullToString(tSchema.getRelationToInsured()).equals(""))
			break MISSING_BLOCK_LABEL_825;
		message = msg;
		return valiPassFlag = false;
		tLNPInsuredSchema = (new LNPInsuredDB(con)).executeQuery((new StringBuilder("select * from LNPInsured where contno='")).append(tContNo).append("'").toString()).get(1);
		tInsurAddressSchema = (new LNPAddressDB(con)).executeQuery((new StringBuilder("select * from lnpaddress a where  exists(select 1 from lnpinsured b where a.customerid=b.insuredid  and b.contno='")).append(tContNo).append("')").toString()).get(1);
		if (tLNPInsuredSchema != null && tInsurAddressSchema != null)
			break MISSING_BLOCK_LABEL_942;
		message = "?????????????";
		return valiPassFlag = false;
		msg = "????????????????§³??????????????????????";
		LNPInsuredSchema tSchema = tLNPInsuredSchema;
		if (!turnNullToString(tSchema.getName()).equals("") && !turnNullToString(Integer.valueOf(tSchema.getAppAge())).equals("") && !turnNullToString(tSchema.getSex()).equals("") && !turnNullToString(tSchema.getBirthday()).equals("") && !turnNullToString(tInsurAddressSchema.getCompanyAddress()).equals("") && !turnNullToString(tInsurAddressSchema.getCompanyZipCode()).equals("") && !turnNullToString(tSchema.getNativePlace()).equals("") && !turnNullToString(tSchema.getIDType()).equals("") && !turnNullToString(tSchema.getIDNo()).equals("") && !turnNullToString(tSchema.getIDValidity()).equals(""))
			break MISSING_BLOCK_LABEL_1153;
		message = msg;
		return valiPassFlag = false;
		tLNPBnfSet = (new LNPBnfDB(con)).executeQuery((new StringBuilder("select * from lnpbnf where contno='")).append(tContNo).append("' and (health is null or health<>'delete') order by bnforder").toString());
		if (tLNPInsuredSchema.getInsuredPeoples() <= 0 || tLNPBnfSet.size() <= 0) goto _L5; else goto _L4
_L4:
		int i;
		msg = "????????????????§³??????????????????????";
		i = 1;
		  goto _L6
_L7:
		LNPBnfSchema tSchema = tLNPBnfSet.get(i);
		if (!turnNullToString(Double.valueOf(tSchema.getBenefitRate())).equals("") && !turnNullToString(tSchema.getBenefitOrder()).equals("") && !turnNullToString(tLNPInsuredSchema.getCreditGrade()).equals(""))
			continue; /* Loop/switch isn't completed */
		message = msg;
		return valiPassFlag = false;
		i++;
_L6:
		if (i <= tLNPBnfSet.size()) goto _L7; else goto _L5
_L5:
		LNPPaymentDB tLNPPaymentDB = new LNPPaymentDB(con);
		tLNPPaymentDB.setContNo(tContNo);
		if (!tLNPPaymentDB.getInfo())
			break MISSING_BLOCK_LABEL_1419;
		tLNPPaymentSchema = tLNPPaymentDB.getSchema();
		String msg = "??????????????????§³?????????????????????";
		LNPPaymentSchema tSchema = tLNPPaymentSchema;
		if (!turnNullToString(tSchema.getPayMent1()).equals("") && !turnNullToString(tSchema.getPayMent2()).equals(""))
			break MISSING_BLOCK_LABEL_1433;
		message = msg;
		return valiPassFlag = false;
		message = "??????§Õ??????????";
		return valiPassFlag = false;
		LNPBonusInfoDB tLNPBonusInfoDB = new LNPBonusInfoDB(con);
		tLNPBonusInfoDB.setContNo(tContNo);
		if (!tLNPBonusInfoDB.getInfo())
			break MISSING_BLOCK_LABEL_1529;
		tLNPBonusInfoSchema = tLNPBonusInfoDB.getSchema();
		String msg = "???????????????§³???????????????????";
		LNPBonusInfoSchema tSchema = tLNPBonusInfoSchema;
		if (!turnNullToString(tSchema.getBonusWay()).equals("") && !turnNullToString(tSchema.getP2()).equals(""))
			break MISSING_BLOCK_LABEL_1543;
		message = msg;
		return valiPassFlag = false;
		message = "??????§Õ?????????";
		return valiPassFlag = false;
		tLNPAgentInfoSet = (new LNPAgentInfoDB(con)).executeQuery((new StringBuilder("select * from lnpagentinfo where contno='")).append(tContNo).append("'").toString());
		if (tLNPAgentInfoSet.size() > 0)
			break MISSING_BLOCK_LABEL_1607;
		message = "???????\364??????";
		return valiPassFlag = false;
		try
		{
			String msg = "??????????????????§³?????????????????????";
			LNPAgentInfoSchema lnpagentinfoschema = tLNPAgentInfoSet.get(1);
			tLNPInvestmentInfoSchema = (new LNPInvestmentInfoDB(con)).executeQuery((new StringBuilder("select * from LNPInvestmentInfo where contno='")).append(tContNo).append("'").toString()).get(1);
			tLNpInvestmentAccountInfoSet = (new LNPInvestmentAccountInfoDB(con)).executeQuery((new StringBuilder("select * from LNPInvestmentAccountInfo where contno='")).append(tContNo).append("'").toString());
			tLnpRiskAmountSet = (new LNPRiskAmountDB(con)).executeQuery((new StringBuilder("select * from LNPRiskAmount where contno='")).append(tContNo).append("'").toString());
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return valiPassFlag = false;
		}
		return true;
	}

	public static void main(String args[])
	{
		NPUWBean cal = new NPUWBean();
		String tContNo = "123213213123";
		tContNo = "098765432111";
		tContNo = "098765432115";
		tContNo = "098765431111";
		cal.calInterfaces(tContNo);
	}
}
