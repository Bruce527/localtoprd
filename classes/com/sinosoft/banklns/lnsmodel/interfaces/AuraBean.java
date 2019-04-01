// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AuraBean.java

package com.sinosoft.banklns.lnsmodel.interfaces;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.PubFun;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import org.jdom.Element;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.interfaces:
//			PublicInterfaces

public class AuraBean extends PublicInterfaces
{

	private LNPContSchema tLNPContSchema;
	private LNPInsuredSchema tLNPInsuredSchema;
	private LNPAppntSchema tLNPAppntSchema;
	private LNPAddressSchema tAppntAddressSchema;
	private CRSInfoSchema tCRSInfoSchema;
	private LNPAddressSchema tInsurAddressSchema;
	private LNPBnfSet tLNPBnfSet;
	private LNPPolSet tLNPPolSet;
	private LNPPolSet tLNPPolSet2;
	private String saleChannel;
	private LNPCUWMasterSchema tLNPCUWMasterSchema;
	private LNPUWMasterSet tLNPUWMasterSet;
	private LNPPaymentSchema tLNPPaymentSchema;
	private LNPBonusInfoSchema tLNPBonusInfoSchema;
	private LNPAgentInfoSet tLNPAgentInfoSet;
	private LNPInvestmentInfoSchema tLNPInvestmentInfoSchema;
	private LNPInvestmentAccountInfoSet tLNpInvestmentAccountInfoSet;

	public AuraBean()
	{
		tLNPContSchema = null;
		tLNPInsuredSchema = null;
		tLNPAppntSchema = null;
		tAppntAddressSchema = null;
		tCRSInfoSchema = null;
		tInsurAddressSchema = null;
		tLNPBnfSet = null;
		tLNPPolSet = null;
		tLNPPolSet2 = null;
		saleChannel = "";
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
		sendFileName = "appnt_in";
		returnFileName = "appnt_out";
		defaultErrorMessage = "投保规则校验失败！";
		super.initObject();
	}

	protected boolean dealReturn()
	{
		Element auratx;
		auratx = getReturnBody();
		if ("ACC".equals(getValueInXML(auratx, "ZNCNTUW")))
			break MISSING_BLOCK_LABEL_175;
		message = getValueInXML(auratx, "PDESC");
		if (!"".equals(message) && message != null) goto _L2; else goto _L1
_L1:
		Iterator iterator;
		Element allDecisionsN = auratx.getChild("Insureds").getChild("Insured").getChild("OverallDecisions");
		List decisionNList = allDecisionsN.getChildren();
		iterator = decisionNList.iterator();
		  goto _L3
_L4:
		Element cDec = (Element)iterator.next();
		this;
		message;
		JVM INSTR new #160 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" 险种:";
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
		return true;
		Exception e;
		e;
		e.printStackTrace();
		return false;
	}

	protected boolean dealSend()
	{
		try
		{
			Element auratx = getSendBody();
			String company = mappingCode(tLNPContSchema.getManageCom(), "BankSigned");
			Element auraControl = auratx.getChild("AuraControl");
			updateText(auraControl, "UniqueID", (new StringBuilder(String.valueOf(tLNPContSchema.getContNo()))).append(fomartDate(PubFun.getCurrentDate())).append(PubFun.getCurrentTime().replace(":", "")).toString());
			updateText(auraControl, "Company", "mlc");
			updateText(auraControl, "SetCode", "16");
			updateText(auraControl, "SubSet", "1");
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
			updateText(policy, "Chdrnum", tLNPContSchema.getMainPolNo());
			updateText(policy, "OCCDATE", fomartDate(tLNPContSchema.getPValiDate()));
			updateText(policy, "HPROPDTE", fomartDate(tLNPContSchema.getPSignDate()));
			updateText(policy, "HPRRCVDT", fomartDate(tLNPAgentInfoSet.get(1).getP1()));
			updateText(policy, "ZDDTEDIF", turnNullToString(Integer.valueOf(PubFun.calInterval(turnNullToString(tLNPContSchema.getPSignDate()), turnNullToString(tLNPAgentInfoSet.get(1).getP1()), "D"))));
			Element policyOwner = policy.getChild("PolicyOwner");
			updateText(policyOwner, "OWNERSEL", "".equals(turnNullToString(tLNPAppntSchema.getAppntNo())) ? "01" : tLNPAppntSchema.getAppntNo());
			updateText(policyOwner, "SALUTL", "MR / MRS");
			updateText(policyOwner, "LSURNAME", tLNPAppntSchema.getAppntName());
			updateText(policyOwner, "DOB", fomartDate(tLNPAppntSchema.getAppntBirthday()));
			if (turnNullToString(tLNPAppntSchema.getAppntAgeType()).equals("Y"))
				updateText(policyOwner, "Age", turnNullToString(Integer.valueOf(tLNPAppntSchema.getAppntAge())));
			else
				updateText(policyOwner, "ZDDAYS", turnNullToString(Integer.valueOf(tLNPAppntSchema.getAppntAge())));
			updateText(policyOwner, "CLTSEX", mappingCode(tLNPAppntSchema.getAppntSex(), "BankPolicySex"));
			updateText(policyOwner, "MARRYD", "");
			updateText(policyOwner, "ZACLTADDR", combAddress(tAppntAddressSchema, "2"));
			updateText(policyOwner, "CLTPCODE", tAppntAddressSchema.getCompanyZipCode());
			updateText(policyOwner, "ADDRTYPE", "1");
			updateText(policyOwner, "ZNBUSUT", tAppntAddressSchema.getGrpName());
			updateText(policyOwner, "CTRYCODE", tLNPAppntSchema.getNativePlace());
			if (tLNPAppntSchema.getNativePlace() == null || tLNPAppntSchema.getNativePlace() == "")
				updateText(policyOwner, "NATLTY", tLNPAppntSchema.getNativePlace());
			else
			if (tLNPAppntSchema.getNativePlace().equals("01") || tLNPAppntSchema.getNativePlace().equals("02"))
				updateText(policyOwner, "NATLTY", tLNPAppntSchema.getNativePlace());
			else
			if (tLNPAppntSchema.getNativePlace().equals("IR") || tLNPAppntSchema.getNativePlace().equals("SY") || tLNPAppntSchema.getNativePlace().equals("SD") || tLNPAppntSchema.getNativePlace().equals("CU") || tLNPAppntSchema.getNativePlace().equals("KP"))
				updateText(policyOwner, "NATLTY", "05");
			else
				updateText(policyOwner, "NATLTY", "03");
			updateText(policyOwner, "CLRSKIND", "1");
			updateText(policyOwner, "RSKFLG", "1");
			updateText(policyOwner, "IDNPRF", getAuraIdtype(mappingCode(tLNPAppntSchema.getIDType(), "BankCertType")));
			updateText(policyOwner, "SECUITYNO", tLNPAppntSchema.getIDNo());
			updateText(policyOwner, "EXPDTE", "1".equals(tLNPAppntSchema.getIDPerpetual()) ? fomartDate(tLNPAppntSchema.getIDValidity()) : fomartDate(mappingCode(tLNPAppntSchema.getIDPerpetual(), "BankCertificatesType")));
			updateText(policyOwner, "INCPRF", "");
			updateText(policyOwner, "INCDESC", "");
			updateText(policyOwner, "DECGRSAL", turnNullToString(fomartNum(Arith.mul(tLNPAppntSchema.getSalary(), 10000D))));
			updateText(policyOwner, "RMBLPHONE", tAppntAddressSchema.getPhone());
			updateText(policyOwner, "CLTPHONE", combPhone(tAppntAddressSchema.getMobileChs2(), tAppntAddressSchema.getCompanyPhone()));
			updateText(policyOwner, "RINTERNET", tAppntAddressSchema.getCompanyMail());
			updateText(policyOwner, "OCCPCODE", tLNPAppntSchema.getOccupationCode());
			updateText(policyOwner, "ZNPIDCPYID", mappingCode(tLNPAppntSchema.getHealth(), "BankIsOrNo"));
			Element owrisk = policy.getChild("OWNRISKSILIST");
			updateText(owrisk, "ZNRSKCD", "");
			updateText(owrisk, "SUMINS", "");
			updateText(policy, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(tLNPContSchema.getPayIntv())), "BankFrequency"));
			updateText(policy, "ZNFPMOP", mappingCode(tLNPPaymentSchema.getPayMent1(), "BankRenewal"));
			updateText(policy, "MOP", mappingCode(tLNPPaymentSchema.getPayMent2(), "BankRenewal"));
			updateText(policy, "ZDIVOPT", mappingCode(tLNPBonusInfoSchema.getBonusWay(), "BankBonusPayMent"));
			updateText(policy, "ZNFOPT", mappingCode(tLNPBonusInfoSchema.getP2(), "BankOverDue"));
			updateText(policy, "CNTCURR", "CNY");
			updateText(policy, "BILLCURR", "CNY");
			updateText(policy, "REGISTER", "PRC");
			updateText(policy, "SRCEBUS", "3");
			if (tLNPPolSet2.size() > 0 && "2".equals(tLNPPolSet2.get(1).getRnewFlag()))
				updateText(policy, "SRCEBUS", saleChannel);
			updateText(policy, "DLVRMODE", "01,02,03".indexOf(turnNullToString(tLNPAgentInfoSet.get(1).getP3())) != -1 ? mappingCode(tLNPAgentInfoSet.get(1).getP3(), "BankDeliveryType") : "04");
			updateText(policy, "ZAPSTADD", combAddress(tAppntAddressSchema, "1"));
			updateText(policy, "CLTPCODE03", tAppntAddressSchema.getHomeZipCode());
			updateText(policy, "ZNAGNTSEL", tLNPAgentInfoSet.get(1).getP2());
			updateText(policy, "AGCOMRT", turnNullToString(Integer.valueOf(100 / tLNPAgentInfoSet.size())));
			if (tLNPAgentInfoSet.size() == 2)
			{
				Element subAgent = policy.getChild("SubAgentList");
				updateText(subAgent, "ZNAGNTSEL01", tLNPAgentInfoSet.get(2).getAgentCode());
				updateText(subAgent, "SPLITC", turnNullToString(Integer.valueOf(100 / tLNPAgentInfoSet.size())));
			}
			updateText(policy, "ZNCSMNAME", tLNPAgentInfoSet.get(1).getAgentCode());
			if (tLNPPolSet2.size() > 0 && "2".equals(tLNPPolSet2.get(1).getRnewFlag()) && (saleChannel.equals("1") || saleChannel.equals("2")))
				updateText(policy, "ZNCSMNAME", "");
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
			if (turnNullToString(tLNPInsuredSchema.getAppAgeType()).equals("Y"))
				updateText(insuredInfo, "Age02", turnNullToString(Integer.valueOf(tLNPInsuredSchema.getAppAge())));
			else
				updateText(insuredInfo, "ZDDays02", turnNullToString(Integer.valueOf(tLNPInsuredSchema.getAppAge())));
			updateText(insuredInfo, "CLTSEX02", mappingCode(tLNPInsuredSchema.getSex(), "BankPolicySex"));
			updateText(insuredInfo, "MARRYD02", "");
			updateText(insuredInfo, "ZACLTADDR02", combAddress(tInsurAddressSchema, "2"));
			updateText(insuredInfo, "CLTPCODE02", tInsurAddressSchema.getCompanyZipCode());
			updateText(insuredInfo, "ADDRTYPE02", "1");
			updateText(insuredInfo, "ZNBUSUT02", tInsurAddressSchema.getGrpName());
			updateText(insuredInfo, "CTRYCODE02", tLNPInsuredSchema.getNativePlace());
			if (tLNPInsuredSchema.getNativePlace() == null || tLNPInsuredSchema.getNativePlace() == "")
				updateText(insuredInfo, "NATLTY02", tLNPInsuredSchema.getNativePlace());
			else
			if (tLNPInsuredSchema.getNativePlace().equals("01") || tLNPInsuredSchema.getNativePlace().equals("02"))
				updateText(insuredInfo, "NATLTY02", tLNPInsuredSchema.getNativePlace());
			else
				updateText(insuredInfo, "NATLTY02", "03");
			updateText(insuredInfo, "CLRSKIND02", "1");
			updateText(insuredInfo, "RSKFLG02", "1");
			updateText(insuredInfo, "IDNPRF02", getAuraIdtype(mappingCode(tLNPInsuredSchema.getIDType(), "BankCertType")));
			updateText(insuredInfo, "SECUITYNO02", tLNPInsuredSchema.getIDNo());
			updateText(insuredInfo, "EXPDTE02", "1".equals(tLNPInsuredSchema.getIDPerpetual()) ? fomartDate(tLNPInsuredSchema.getIDValidity()) : fomartDate(mappingCode(tLNPInsuredSchema.getIDPerpetual(), "BankCertificatesType")));
			updateText(insuredInfo, "INCPRF02", "");
			updateText(insuredInfo, "INCDESC02", "");
			updateText(insuredInfo, "DECGRSAL02", turnNullToString(fomartNum(Arith.mul(tLNPInsuredSchema.getSalary(), 10000D))));
			updateText(insuredInfo, "RMBLPHONE02", tInsurAddressSchema.getPhone());
			updateText(insuredInfo, "CLTPHONE02", combPhone(tInsurAddressSchema.getMobileChs2(), tInsurAddressSchema.getCompanyPhone()));
			updateText(insuredInfo, "RINTERNET02", tInsurAddressSchema.getCompanyMail());
			updateText(insuredInfo, "OCCPCODE02", tLNPInsuredSchema.getOccupationCode());
			updateText(insuredInfo, "ZNPIDCPYID02", mappingCode(tLNPInsuredSchema.getHealth(), "BankIsOrNo"));
			updateText(insured, "RELATION", mappingCode(tLNPAppntSchema.getRelationToInsured(), "BankRelationship"));
			updateText(insured, "SELECTION", "");
			updateText(insured, "HEIGHT", mappingQues("A05", "insur", tLNPContSchema.getContNo(), saleChannel));
			updateText(insured, "WEIGHT", mappingQues("A06", "insur", tLNPContSchema.getContNo(), saleChannel));
			updateText(insured, "SMOKING", "");
			updateText(insured, "OCCUP", tLNPInsuredSchema.getOccupationCode());
			Element questionArea = insured.getChild("Questionare");
			if ("2".equals(saleChannel))
				updateText(questionArea, "QUESTSET", "MTQTM");
			else
				updateText(questionArea, "QUESTSET", "MTQBA");
			LNPCodeSet codeSet = new LNPCodeSet();
			LNPCodeDB db = new LNPCodeDB(con);
			db.setCodeType("QueCodeMapping");
			db.setComCode(saleChannel);
			codeSet = db.query();
			Element questionList = questionArea.getChild("QuestionList");
			Element question = questionList.getChild("Question");
			questionList.removeContent();
			for (int i = 1; i <= codeSet.size(); i++)
			{
				Element tempElement = (Element)question.clone();
				updateText(tempElement, "QUESTIDF", codeSet.get(i).getCodeName());
				updateText(tempElement, "ANSWER", mappingQues(codeSet.get(i).getCodeName(), codeSet.get(i).getOtherSign(), tLNPContSchema.getContNo(), saleChannel));
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
				updateText(tempCoverage, "ZNPRDCODE", tempPol.getRiskCode());
				updateText(tempCoverage, "SUMIN", turnNullToString(fomartNum(tempPol.getAmnt())));
				if ("A".equals(tempPol.getInsuYearFlag()))
				{
					updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
					updateText(tempCoverage, "RCESSTRM", "0");
				} else
				{
					updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
					updateText(tempCoverage, "RCESSAGE", "0");
				}
				if ("A".equals(tempPol.getPayEndYearFlag()))
				{
					updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
					updateText(tempCoverage, "PCESSTRM", "0");
				} else
				{
					updateText(tempCoverage, "PCESSTRM", "1000".equals(turnNullToString(Integer.valueOf(tempPol.getPayEndYear()))) ? "1" : turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
					updateText(tempCoverage, "PCESSAGE", "0");
				}
				if ("A".equals(tempPol.getGetYearFlag()))
				{
					if (tempPol.getRiskCode().equals("LA11BA") && turnNullToString(Integer.valueOf(tempPol.getInsuYear())).equals("20"))
						updateText(tempCoverage, "BCESSTRM", "11");
					else
					if (tempPol.getRiskCode().equals("LA11BA") && turnNullToString(Integer.valueOf(tempPol.getInsuYear())).equals("25"))
					{
						updateText(tempCoverage, "BCESSTRM", "16");
					} else
					{
						updateText(tempCoverage, "BCESSAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
						updateText(tempCoverage, "BCESSTRM", "0");
					}
				} else
				{
					updateText(tempCoverage, "BCESSTRM", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
					updateText(tempCoverage, "BCESSAGE", "0");
				}
				updateText(tempCoverage, "MORTCLS", "2");
				updateText(tempCoverage, "INSTPRM", turnNullToString(fomartNum(tempPol.getPrem())));
				updateText(tempCoverage, "ZPRFLG", "N");
				if (tLNPInvestmentInfoSchema != null && !turnNullToString(tLNPInvestmentInfoSchema.getTermInvestment()).equals("") && tLNPInvestmentInfoSchema.getMonthPlusPrem() > 0.0D && Double.parseDouble(tLNPInvestmentInfoSchema.getTermInvestment()) > 0.0D)
				{
					updateText(tempCoverage, "LMPCNT", tLNPInvestmentInfoSchema.getPayExtraPremFlag());
					updateText(tempCoverage, "ZPRFLG", "Y");
					updateText(tempCoverage, "ZNINVAMT", turnNullToString(fomartNum(tLNPInvestmentInfoSchema.getMonthPlusPrem())));
					updateText(tempCoverage, "ZNTRM", tLNPInvestmentInfoSchema.getTermInvestment());
				}
				updateText(tempCoverage, "ZUNIT", "1");
				updateText(tempCoverage, "LIVESNO", "1");
				updateText(tempCoverage, "PAYCLT", tLNPAppntSchema.getAppntNo());
				Element payBankInfor = tempCoverage.getChild("PayBankInfor");
				if ("02".equals(tLNPPaymentSchema.getPayMent1()))
				{
					updateText(payBankInfor, "BANKCODE", "");
					updateText(payBankInfor, "BANKKEY", tLNPPaymentSchema.getBankCode());
					updateText(payBankInfor, "BANKACCKEY", tLNPPaymentSchema.getAccount());
					updateText(payBankInfor, "BANKDESC", tLNPAppntSchema.getAppntName());
					updateText(payBankInfor, "BNKACTYP", "");
					updateText(payBankInfor, "CURRCODE", "CNY");
					updateText(payBankInfor, "DATEFROM", fomartDate(tLNPContSchema.getPValiDate()));
					updateText(payBankInfor, "TIMESUSE", "");
				}
				updateText(tempCoverage, "FREQANN", "-1".equals(tempPol.getStandbyFlag3()) ? "" : mappingCode(tempPol.getStandbyFlag3(), "BankAnnuityReceive"));
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
				updateText(payment, "REGPAYFREQ", "-1".equals(tempPol.getStandbyFlag3()) ? "" : mappingCode(tempPol.getStandbyFlag3(), "BankAnnuityReceive"));
				updateText(payment, "PRCNT", "");
				updateText(payment, "CLAIMCUR", "CNY");
				if (tLNPInvestmentInfoSchema != null)
					updateText(tempCoverage, "RSUNIN", mappingCode(tLNPInvestmentInfoSchema.getHesInvestment(), "BankInvestment"));
				updateText(tempCoverage, "PRCAMTIND", "");
				Element PRMFundList = tempCoverage.getChild("PRMFLST");
				Element RGUFundList = tempCoverage.getChild("RGUFLST");
				for (int x = 1; x <= 10; x++)
					if (x < 10)
					{
						updateText(PRMFundList, (new StringBuilder("VRTFND0")).append(x).toString(), "0");
						updateText(PRMFundList, (new StringBuilder("UALPRC0")).append(x).toString(), "0");
						updateText(RGUFundList, (new StringBuilder("ZAVRTFND0")).append(x).toString(), "0");
						updateText(RGUFundList, (new StringBuilder("ZNSPLAMT0")).append(x).toString(), "0");
					} else
					{
						updateText(PRMFundList, (new StringBuilder("VRTFND")).append(x).toString(), "0");
						updateText(PRMFundList, (new StringBuilder("UALPRC")).append(x).toString(), "0");
						updateText(RGUFundList, (new StringBuilder("ZAVRTFND")).append(x).toString(), "0");
						updateText(RGUFundList, (new StringBuilder("ZNSPLAMT")).append(x).toString(), "0");
					}

				for (int x = 1; x <= tLNpInvestmentAccountInfoSet.size() && x <= 10; x++)
					if (x < 10)
					{
						updateText(PRMFundList, (new StringBuilder("VRTFND0")).append(x).toString(), tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
						updateText(PRMFundList, (new StringBuilder("UALPRC0")).append(x).toString(), turnNullToString(Double.valueOf(Arith.mul(tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100D))));
					} else
					{
						updateText(PRMFundList, (new StringBuilder("VRTFND")).append(x).toString(), tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
						updateText(PRMFundList, (new StringBuilder("UALPRC")).append(x).toString(), turnNullToString(Double.valueOf(Arith.mul(tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100D))));
					}

				for (int x = 1; x <= tLNpInvestmentAccountInfoSet.size() && x <= 10; x++)
					if (x < 10)
					{
						updateText(RGUFundList, (new StringBuilder("ZAVRTFND0")).append(x).toString(), tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
						updateText(RGUFundList, (new StringBuilder("ZNSPLAMT0")).append(x).toString(), turnNullToString(Double.valueOf(Arith.mul(tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100D))));
					} else
					{
						updateText(RGUFundList, (new StringBuilder("ZAVRTFND")).append(x).toString(), tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
						updateText(RGUFundList, (new StringBuilder("ZNSPLAMT")).append(x).toString(), turnNullToString(Double.valueOf(Arith.mul(tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100D))));
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
					updateText(tempBnf, "IDNPRF04", getAuraIdtype(mappingCode(tempSchema.getIDType(), "BankCertType")));
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
				updateText(FRTRecBank, "BANKDESC02", tLNPAppntSchema.getAppntName());
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
				updateText(SEQRecBank, "BANKDESC03", tLNPAppntSchema.getAppntName());
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
			updateText(policy, "ZNOVRPAYOP", mappingCode(tLNPBonusInfoSchema.getP1(), "BankIsOrNo"));
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
			updateText(policy, "ZNVIPIND", mappingCode(tLNPAppntSchema.getAppntGrade(), "BankIsOrNo"));
			updateText(policy, "ZAPOLFLD1", "");
			updateText(policy, "ZAPOLFLD2", "");
			updateText(policy, "ZAPOLFLD3", "");
			updateText(policy, "ZAPOLFLD4", "");
			updateText(policy, "ZAPOLFLD5", "");
			Element hisIn = auratx.getChild("HisIn");
			Element polhis = hisIn.getChild("POLHIS");
			Element inPolicyOwner = polhis.getChild("PolicyOwner");
			updateText(inPolicyOwner, "OWNERSEL05", "".equals(turnNullToString(tLNPAppntSchema.getAppntNo())) ? "01" : tLNPAppntSchema.getAppntNo());
			updateText(inPolicyOwner, "LSURNAME05", tLNPAppntSchema.getAppntName());
			updateText(inPolicyOwner, "DOB05", "");
			updateText(inPolicyOwner, "CLTSEX05", "");
			updateText(inPolicyOwner, "SECUITYNO05", "");
			updateText(inPolicyOwner, "RMBLPHONE05", "");
			updateText(inPolicyOwner, "CLTPHONE05", "");
			Element inInsured = polhis.getChild("InsuredList").getChild("Insured");
			updateText(inInsured, "LIFCNUM06", "".equals(turnNullToString(tLNPInsuredSchema.getInsuredNo())) ? "01" : tLNPInsuredSchema.getInsuredNo());
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
			if (tLNPPolSet2.size() > 0 && "2".equals(tLNPPolSet2.get(1).getRnewFlag()) && (saleChannel.equals("1") || saleChannel.equals("2")))
				updateText(policiInfo, "ZNAGNTSEL02", "");
			updateText(policiInfo, "CHDRTYPE", "");
			updateText(policiInfo, "ZNCSMNAME02", "");
			updateText(policiInfo, "HPROPDTE02", fomartDate(tLNPContSchema.getPSignDate()));
			updateText(policiInfo, "LIFE02", "01");
			Element covlist = policiInfo.getChild("COVLIST");
			policiInfo.removeContent(covlist);
			int i = 1;
			int j = 1;
			for (; i <= tLNPPolSet.size(); i++)
			{
				Element tempCovlist = (Element)covlist.clone();
				LNPPolSchema tempPol = tLNPPolSet.get(i);
				updateText(tempCovlist, "COVERAGE02", "01");
				if (!"M".equalsIgnoreCase(tempPol.getSubFlag()))
					updateText(tempCovlist, "RIDER02", (new StringBuilder("0")).append(j++).toString());
				else
					updateText(tempCovlist, "RIDER02", "00");
				updateText(tempCovlist, "ZNPRDCODE02", tempPol.getRiskCode());
				if ("A".equals(tempPol.getInsuYearFlag()))
				{
					updateText(tempCovlist, "RCESSAGE02", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
					updateText(tempCovlist, "RCESSTRM02", "0");
				} else
				{
					updateText(tempCovlist, "RCESSAGE02", "0");
					updateText(tempCovlist, "RCESSTRM02", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
				}
				policiInfo.addContent(tempCovlist);
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
		valiPassFlag = true;
		if (tContNo == null || tContNo.equals(""))
			return valiPassFlag = false;
		LNPContDB tLNPContDB;
		tLNPContDB = new LNPContDB(con);
		tLNPContDB.setContNo(tContNo);
		if (tLNPContDB.getInfo())
			break MISSING_BLOCK_LABEL_63;
		message = "获取投保书信息失败！";
		return valiPassFlag = false;
		String msg;
		tLNPContSchema = tLNPContDB.getSchema();
		msg = "请完善“基础信息”部分的信息项！";
		if (!turnNullToString(tLNPContSchema.getManageCom()).equals("") && !turnNullToString(tLNPContSchema.getPValiDate()).equals("") && !turnNullToString(tLNPContSchema.getPSignDate()).equals(""))
			break MISSING_BLOCK_LABEL_144;
		message = msg;
		return valiPassFlag = false;
		tLNPPolSet = (new LNPPolDB(con)).executeQuery((new StringBuilder("select * from LNPPol where contno='")).append(tContNo).append("'").toString());
		if (tLNPPolSet.size() > 0)
			break MISSING_BLOCK_LABEL_209;
		message = "请先填写险种信息！";
		return valiPassFlag = false;
		int i;
		tLNPPolSet2 = tLNPPolSet;
		saleChannel = turnToCode(tLNPPolSet2.get(1).getUWTime());
		tLNPPolSet = (new LNPPolDB(con)).executeQuery((new StringBuilder("select * from lnppol where contno='")).append(tContNo).append("' and (RiskVersion is null or RiskVersion='')").toString());
		msg = "请完善“投保事项”中“险种信息”部分的信息项！";
		i = 1;
		  goto _L1
_L5:
		LNPPolSchema tSchema = tLNPPolSet.get(i);
		if (!turnNullToString(tSchema.getRiskVersion()).equals("") || !turnNullToString(Integer.valueOf(tSchema.getPayIntv())).equals("") && !turnNullToString(tSchema.getRiskCode()).equals("") && (!turnNullToString(Double.valueOf(tSchema.getAmnt())).equals("") || !turnNullToString(Double.valueOf(tSchema.getPrem())).equals("")) && tSchema.getAmnt() >= 0.0D && tSchema.getPrem() >= 0.0D && tSchema.getInsuYear() >= 0) goto _L3; else goto _L2
_L2:
		message = msg;
		return valiPassFlag = false;
_L3:
		if (!"02".equals(tSchema.getKindCode()))
			continue; /* Loop/switch isn't completed */
		LNPInvestmentAccountInfoSet investSet = new LNPInvestmentAccountInfoSet();
		investSet = (new LNPInvestmentAccountInfoDB(con)).executeQuery((new StringBuilder("select * from LNPInvestmentAccountInfo where contno='")).append(tContNo).append("'").toString());
		double sumRate = 0.0D;
		for (int j = 1; j <= investSet.size(); j++)
			sumRate = Arith.add(sumRate, investSet.get(j).getInvestAccountRate());

		System.out.println((new StringBuilder("投连险(VUL/VA),基本保费投资百分比--->")).append(sumRate).toString());
		if (sumRate == 1.0D)
			continue; /* Loop/switch isn't completed */
		message = "投连险(VUL/VA),基本保费投资百分比总和需等于100% ！";
		return valiPassFlag = false;
		i++;
_L1:
		if (i <= tLNPPolSet.size()) goto _L5; else goto _L4
_L4:
		LNPCUWMasterDB cuw = new LNPCUWMasterDB(con);
		cuw.setContNo(tContNo);
		if (cuw.getInfo())
			tLNPCUWMasterSchema = cuw.getSchema();
		tLNPUWMasterSet = (new LNPUWMasterDB(con)).executeQuery((new StringBuilder("select * from LNPUWMaster where ContNo='")).append(tContNo).append("'").toString());
		tLNPAppntSchema = (new LNPAppntDB(con)).executeQuery((new StringBuilder("select * from lnpappnt where contno='")).append(tContNo).append("'").toString()).get(1);
		tAppntAddressSchema = (new LNPAddressDB(con)).executeQuery((new StringBuilder("select * from lnpaddress a where  exists(select 1 from lnpappnt b where a.customerid=b.appntid  and b.contno='")).append(tContNo).append("')").toString()).get(1);
		if (tLNPAppntSchema != null && tAppntAddressSchema != null)
			break MISSING_BLOCK_LABEL_784;
		message = "缺失投保人信息！";
		return valiPassFlag = false;
		String msg;
		msg = "请完善“客户信息”中“投保人信息”部分的信息项！";
		tSchema = tLNPAppntSchema;
		if (!turnNullToString(tSchema.getAppntName()).equals("") && !turnNullToString(Integer.valueOf(tSchema.getAppntAge())).equals("") && !turnNullToString(tSchema.getAppntSex()).equals("") && !turnNullToString(tSchema.getAppntBirthday()).equals("") && !turnNullToString(tAppntAddressSchema.getCompanyAddress()).equals("") && !turnNullToString(tAppntAddressSchema.getCompanyZipCode()).equals("") && !turnNullToString(tSchema.getNativePlace()).equals("") && !turnNullToString(tSchema.getIDType()).equals("") && !turnNullToString(tSchema.getIDNo()).equals("") && !turnNullToString(tSchema.getRelationToInsured()).equals(""))
			break MISSING_BLOCK_LABEL_985;
		message = msg;
		return valiPassFlag = false;
		tCRSInfoSchema = (new CRSInfoDB(con)).executeQuery((new StringBuilder("select * from crsinfo where contno='")).append(tContNo).append("'").toString()).get(1);
		if (tCRSInfoSchema != null)
			break MISSING_BLOCK_LABEL_1051;
		message = "缺失CRS信息！";
		return valiPassFlag = false;
		CRSInfoSchema cSchema = tCRSInfoSchema;
		String crsmsg = "请完善“客户信息”中“个人税收居民身份声明文件”部分的信息项！";
		boolean crsflag = validateCRS(cSchema, tSchema);
		if (crsflag)
			break MISSING_BLOCK_LABEL_1090;
		message = crsmsg;
		return valiPassFlag = false;
		tLNPInsuredSchema = (new LNPInsuredDB(con)).executeQuery((new StringBuilder("select * from LNPInsured where contno='")).append(tContNo).append("'").toString()).get(1);
		tInsurAddressSchema = (new LNPAddressDB(con)).executeQuery((new StringBuilder("select * from lnpaddress a where  exists(select 1 from lnpinsured b where a.customerid=b.insuredid  and b.contno='")).append(tContNo).append("')").toString()).get(1);
		if (tLNPInsuredSchema != null && tInsurAddressSchema != null)
			break MISSING_BLOCK_LABEL_1208;
		message = "缺失被保人信息！";
		return valiPassFlag = false;
		msg = "请完善“客户信息”中“被保人信息”部分的信息项！";
		tSchema = tLNPInsuredSchema;
		if (!turnNullToString(tSchema.getName()).equals("") && !turnNullToString(Integer.valueOf(tSchema.getAppAge())).equals("") && !turnNullToString(tSchema.getSex()).equals("") && !turnNullToString(tSchema.getBirthday()).equals("") && !turnNullToString(tInsurAddressSchema.getCompanyAddress()).equals("") && !turnNullToString(tInsurAddressSchema.getCompanyZipCode()).equals("") && !turnNullToString(tSchema.getNativePlace()).equals("") && !turnNullToString(tSchema.getIDType()).equals("") && !turnNullToString(tSchema.getIDNo()).equals(""))
			break MISSING_BLOCK_LABEL_1392;
		message = msg;
		return valiPassFlag = false;
		int i;
		tLNPBnfSet = (new LNPBnfDB(con)).executeQuery((new StringBuilder("select * from lnpbnf where contno='")).append(tContNo).append("' and (health is null or health<>'delete') order by bnforder").toString());
		if (tLNPInsuredSchema.getInsuredPeoples() <= 0)
			break MISSING_BLOCK_LABEL_1671;
		msg = "请完善“客户信息”中“受益人信息”部分的信息项！";
		if (tLNPBnfSet.size() <= 0)
			break MISSING_BLOCK_LABEL_1658;
		i = 1;
		  goto _L6
_L8:
		LNPBnfSchema tSchema = tLNPBnfSet.get(i);
		if (!turnNullToString(Double.valueOf(tSchema.getBenefitRate())).equals("") && !turnNullToString(tSchema.getBenefitOrder()).equals("") && !turnNullToString(tSchema.getBnfName()).equals("") && !turnNullToString(tSchema.getRelationToInsured()).equals("") && !turnNullToString(tLNPInsuredSchema.getCreditGrade()).equals(""))
			continue; /* Loop/switch isn't completed */
		message = msg;
		return valiPassFlag = false;
		i++;
_L6:
		if (i <= tLNPBnfSet.size()) goto _L8; else goto _L7
_L7:
		ExeSQL execSQL = new ExeSQL(con);
		SSRS ssrs = execSQL.execSQL((new StringBuilder("select sum(benefitrate),benefitorder from lnpbnf where contno='")).append(tContNo).append("' and (health<>'delete' or health is null) group by BenefitOrder having sum(benefitrate)<>100").toString());
		if (ssrs.MaxRow <= 0)
			break MISSING_BLOCK_LABEL_1695;
		message = "相同“受益顺序”的身故受益人“受益比例”总和需等于100% ！";
		return valiPassFlag = false;
		message = msg;
		return valiPassFlag = false;
		if (tLNPInsuredSchema.getInsuredPeoples() >= 0)
			break MISSING_BLOCK_LABEL_1695;
		message = "请完善“客户信息”中“受益人信息”部分的信息项！";
		return valiPassFlag = false;
		LNPPaymentDB tLNPPaymentDB = new LNPPaymentDB(con);
		tLNPPaymentDB.setContNo(tContNo);
		if (!tLNPPaymentDB.getInfo())
			break MISSING_BLOCK_LABEL_1805;
		tLNPPaymentSchema = tLNPPaymentDB.getSchema();
		String account = getDecryptAccount(tContNo);
		tLNPPaymentSchema.setAccount(account);
		String msg = "请完善“告知及授权”中“收付费信息”部分的信息项！";
		LNPPaymentSchema tSchema = tLNPPaymentSchema;
		if (!turnNullToString(tSchema.getPayMent1()).equals("") && !turnNullToString(tSchema.getPayMent2()).equals(""))
			break MISSING_BLOCK_LABEL_1819;
		message = msg;
		return valiPassFlag = false;
		message = "请先填写收付费信息！";
		return valiPassFlag = false;
		LNPBonusInfoDB tLNPBonusInfoDB = new LNPBonusInfoDB(con);
		tLNPBonusInfoDB.setContNo(tContNo);
		if (tLNPBonusInfoDB.getInfo())
		{
			tLNPBonusInfoSchema = tLNPBonusInfoDB.getSchema();
			break MISSING_BLOCK_LABEL_1872;
		}
		message = "请先填写红利信息！";
		return valiPassFlag = false;
		tLNPAgentInfoSet = (new LNPAgentInfoDB(con)).executeQuery((new StringBuilder("select * from lnpagentinfo where contno='")).append(tContNo).append("'").toString());
		if (tLNPAgentInfoSet.size() > 0)
			break MISSING_BLOCK_LABEL_1937;
		message = "请先设置代理人信息！";
		return valiPassFlag = false;
		String msg = "请完善“告知及授权”中“代理人告知”部分的信息项！";
		LNPAgentInfoSchema tSchema = tLNPAgentInfoSet.get(1);
		if (!turnNullToString(tSchema.getP4()).equals(""))
			break MISSING_BLOCK_LABEL_1982;
		message = msg;
		return valiPassFlag = false;
		tLNPInvestmentInfoSchema = (new LNPInvestmentInfoDB(con)).executeQuery((new StringBuilder("select * from LNPInvestmentInfo where contno='")).append(tContNo).append("'").toString()).get(1);
		if (tLNPInvestmentInfoSchema == null || !turnNullToString(tLNPInvestmentInfoSchema.getTermInvestment()).equals("") && tLNPInvestmentInfoSchema.getMonthPlusPrem() > 0.0D || turnNullToString(tLNPInvestmentInfoSchema.getTermInvestment()).equals("") && tLNPInvestmentInfoSchema.getMonthPlusPrem() <= 0.0D)
			break MISSING_BLOCK_LABEL_2110;
		message = "月月加保费与定投年限为绑定录入项,请同时录入！";
		return valiPassFlag = false;
		try
		{
			tLNpInvestmentAccountInfoSet = (new LNPInvestmentAccountInfoDB(con)).executeQuery((new StringBuilder("select * from LNPInvestmentAccountInfo where contno='")).append(tContNo).append("'").toString());
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return valiPassFlag = false;
		}
		return true;
	}

	private boolean validateCRS(CRSInfoSchema cSchema, LNPAppntSchema lSchema)
	{
		if ("01".equals(lSchema.getIDType().trim()) || "02".equals(lSchema.getIDType().trim()) || "04".equals(lSchema.getIDType().trim()) || "05".equals(lSchema.getIDType().trim()))
		{
			System.out.println("校验必录项非军人证");
			if (cSchema.getTaxResidentType() == null || "".equals(cSchema.getTaxResidentType().trim()))
				valiPassFlag = false;
			else
			if (!"1".equals(cSchema.getTaxResidentType().trim()))
			{
				System.out.println("校验必录项类型2、3");
				if (cSchema.getFirstName() == null || "".equals(cSchema.getFirstName().trim()))
					valiPassFlag = false;
				if (cSchema.getLastName() == null || "".equals(cSchema.getLastName().trim()))
					valiPassFlag = false;
				if (cSchema.getCurrentAddress_Country_en() == null || "".equals(cSchema.getCurrentAddress_Country_en().trim()))
					valiPassFlag = false;
				if ("ZhongGuo".equals(cSchema.getCurrentAddress_Country_en().trim()))
				{
					if (cSchema.getCurrentAddress_Province_en() == null || "".equals(cSchema.getCurrentAddress_Province_en().trim()))
						valiPassFlag = false;
					if (cSchema.getCurrentAddress_City_en() == null || "".equals(cSchema.getCurrentAddress_City_en().trim()))
						valiPassFlag = false;
				}
				if (cSchema.getCurrentAddress_Detail_en() == null || "".equals(cSchema.getCurrentAddress_Detail_en().trim()))
					valiPassFlag = false;
				if (cSchema.getBirthAddress_Country_en() == null || "".equals(cSchema.getBirthAddress_Country_en().trim()))
					valiPassFlag = false;
				if ("ZhongGuo".equals(cSchema.getBirthAddress_Country_en().trim()))
				{
					if (cSchema.getBirthAddress_Province_en() == null || "".equals(cSchema.getBirthAddress_Province_en().trim()))
						valiPassFlag = false;
					if (cSchema.getBirthAddress_City_en() == null || "".equals(cSchema.getBirthAddress_City_en().trim()))
						valiPassFlag = false;
				}
				if (cSchema.getBirthAddress_Detail() != null && !"".equals(cSchema.getBirthAddress_Detail().trim()) && (cSchema.getBirthAddress_Detail_en() == null || "".equals(cSchema.getBirthAddress_Detail_en().trim())))
					valiPassFlag = false;
				if ((cSchema.getTaxpayerCode1() == null || "".equals(cSchema.getTaxpayerCode1().trim())) && (cSchema.getTaxpayerCode2() == null || "".equals(cSchema.getTaxpayerCode2().trim())) && (cSchema.getTaxpayerCode3() == null || "".equals(cSchema.getTaxpayerCode3().trim())))
				{
					System.out.println("校验必录项未填写识别号，则原因必填");
					if (cSchema.getNoTaxpayercodeReason() == null || "".equals(cSchema.getNoTaxpayercodeReason().trim()) || "2".equals(cSchema.getNoTaxpayercodeReason().trim()))
						valiPassFlag = false;
				}
				if ("2".equals(cSchema.getNoTaxpayercodeReason().trim()) && (cSchema.getTaxpayerCode1() == null || "".equals(cSchema.getTaxpayerCode1().trim())) && (cSchema.getTaxpayerCode2() == null || "".equals(cSchema.getTaxpayerCode2().trim())) && (cSchema.getTaxpayerCode3() == null || "".equals(cSchema.getTaxpayerCode3().trim())))
					valiPassFlag = false;
				if ((cSchema.getTaxResidentCountry1() == null || "".equals(cSchema.getTaxResidentCountry1().trim())) && (cSchema.getTaxResidentCountry2() == null || "".equals(cSchema.getTaxResidentCountry2().trim())) && (cSchema.getTaxResidentCountry3() == null || "".equals(cSchema.getTaxResidentCountry3().trim())))
					valiPassFlag = false;
				if ("1".equals(cSchema.getNoTaxpayercodeReason().trim()))
				{
					System.out.println("校验必录项填写了原因为1,校验原因描述");
					if (cSchema.getReasonDescription() == null || "".equals(cSchema.getReasonDescription().trim()))
						valiPassFlag = false;
				} else
				{
					System.out.println("校验必录项填写了原因为0或2,不校验");
				}
			} else
			{
				System.out.println("校验必录项taxType=1，不校验居民信息");
				valiPassFlag = true;
			}
		} else
		if ("03".equals(lSchema.getIDType().trim()))
		{
			System.out.println("校验必录项ID为军人证，不校验CRS信息");
			valiPassFlag = true;
		}
		return valiPassFlag;
	}

	public String getAuraIdtype(String idtype)
	{
		if ("09".equals(idtype) || "10".equals(idtype))
			idtype = "03";
		return idtype;
	}

	public static void main(String args[])
	{
		AuraBean cal = new AuraBean();
		String tContNo = "123213213123";
		tContNo = "098765432111";
		tContNo = "038979387593";
		tContNo = "201707120001";
		cal.calInterfaces(tContNo);
	}
}
