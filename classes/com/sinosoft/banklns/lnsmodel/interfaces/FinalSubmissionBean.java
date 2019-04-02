// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FinalSubmissionBean.java

package com.sinosoft.banklns.lnsmodel.interfaces;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.MMap;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.utility.*;
import com.sinosoft.map.lis.db.MSysVarDB;
import com.sinosoft.map.lis.db.MUserDB;
import com.sinosoft.map.lis.schema.MSysVarSchema;
import java.io.PrintStream;
import java.util.List;
import org.jdom.Element;
import org.jdom.Namespace;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.interfaces:
//			PublicInterfaces

public class FinalSubmissionBean extends PublicInterfaces
{

	private LNPContSchema tLNPContSchema;
	private LNPAppntSchema tLNPAppntSchema;
	private CRSInfoSchema tCRSInfoSchema;
	private LNPInsuredSchema tLNPInsuredSchema;
	private LNPAddressSchema tAppntAddressSchema;
	private LNPAddressSchema tInsurAddressSchema;
	private LNPPaymentSchema tLNPPaymentSchema;
	private LNPBonusInfoSchema tLNPBonusInfoSchema;
	private LNPPolSet tLNPPolSet;
	private String saleChannel;
	private LNPBnfSet tLNPBnfSet;
	private LNPAgentInfoSchema tLNPAgentInfoSchema;
	private LNPInvestmentInfoSchema tLNPInvestmentInfoSchema;
	private LNPInvestmentAccountInfoSet tLNpInvestmentAccountInfoSet;
	private LNPCUWMasterSchema tLNPCUWMasterSchema;
	private String userName;
	private String password;
	boolean flag;

	public FinalSubmissionBean()
	{
		tAppntAddressSchema = null;
		tInsurAddressSchema = null;
		tLNPPaymentSchema = null;
		tLNPBonusInfoSchema = null;
		saleChannel = "";
		tLNPInvestmentInfoSchema = null;
	}

	public void initObject()
	{
		modelFileName = "issue_in.xml";
		sendFileName = "issue_in";
		returnFileName = "issue_out";
		defaultErrorMessage = "发送保单失败！";
		super.initObject();
		tLNPContSchema = null;
		tLNPAppntSchema = null;
		tCRSInfoSchema = null;
		tLNPInsuredSchema = null;
		tLNPPolSet = null;
		tLNPBnfSet = null;
	}

	public boolean dealReturn()
	{
		LNPContSchema bakLNPContSchema;
		Element returnN;
		String valiReason;
		bakLNPContSchema = new LNPContSchema();
		bakLNPContSchema.setSchema(tLNPContSchema);
		returnN = getReturnBody();
		System.out.println((new StringBuilder("--returnN--")).append(returnN.getName()).toString());
		Namespace err = Namespace.getNamespace("http://www.csc.smart/bo/schemas/Error");
		Element errorN = returnN.getChild("ERROR", err);
		if (errorN == null)
			break MISSING_BLOCK_LABEL_161;
		System.out.println("EAI调用LA成功，但返回了错误！");
		Element statusN = errorN.getChild("STATUS", err);
		Element reason = errorN.getChild("REASON", err);
		valiReason = reason.getChild("ERROR_DESC", err).getText();
		this;
		message;
		JVM INSTR new #115 <Class StringBuilder>;
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
		Element policylistN;
		policylistN = returnN.getChild("POLICYLIST");
		if (policylistN != null)
			break MISSING_BLOCK_LABEL_184;
		System.out.println("******************SOAP ERROR*******************MSP接口NBUPLService调用出错！");
		return false;
		Element policyN;
		System.out.println((new StringBuilder("--policylistN--")).append(policylistN.getName()).toString());
		policyN = policylistN.getChild("POLICY");
		System.out.println(policyN.getName());
		System.out.println(policyN.getText());
		if (!"0".equals(getValueInXML(policyN, "ERRCODE")))
			break MISSING_BLOCK_LABEL_343;
		tLNPContSchema.setLang("2");
		setModifyTime(tLNPContSchema);
		tLNPContSchema.setUWOperator(getValueInXML(policyN, "PDESC"));
		tLNPContSchema.setUWDate(tLNPContSchema.getModifyDate());
		tLNPContSchema.setMainPolNo(getValueInXML(policyN, "CHDRNUM"));
		bakMap.put(bakLNPContSchema, "UPDATE");
		map.put(tLNPContSchema, "UPDATE");
		return true;
		try
		{
			tLNPContSchema.setLang("2");
			message = getValueInXML(policyN, "PDESC");
			tLNPContSchema.setUWDate(tLNPContSchema.getModifyDate());
			bakMap.put(bakLNPContSchema, "UPDATE");
			map.put(tLNPContSchema, "UPDATE");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean dealSend()
	{
		try
		{
			Element msgBody = getSendBody();
			String company = mappingCode(tLNPContSchema.getManageCom(), "BankSigned");
			Namespace msp = Namespace.getNamespace("http://www.csc.smart/msp/schemas/MSPContext");
			if (NBFlag() && agentFlag())
			{
				msgBody = getSendBody();
				List msgList = msgBody.getChildren();
				Element mspContent = (Element)msgList.get(0);
				Element userId = mspContent.getChild("UserId", msp);
				userId.setText(userName);
				Element uerPassword = mspContent.getChild("UserPassword", msp);
				uerPassword.setText(password);
				Element reqps = mspContent.getChild("RequestParameters", msp);
				Element requestParameter = reqps.getChild("RequestParameter", msp);
				requestParameter.setAttribute("name", "BRANCH").setAttribute("value", company);
			}
			Element policy = null;
			if (NBFlag() && agentFlag())
				policy = msgBody.getChild("POLICY");
			else
				policy = msgBody.getChild("POLST").getChild("POLICY");
			updateText(policy, "ZNEXTSYS", "4");
			updateText(policy, "PRT1OPT", "Y");
			updateText(policy, "PRT2OPT", "Y");
			updateText(policy, "ZNGPCNO", tLNPContSchema.getAgentCode1());
			updateText(policy, "STATCODE", "PS");
			updateText(policy, "CNTBRANCH", company);
			updateText(policy, "TTMPRCNO", tLNPContSchema.getContNo());
			if (NBFlag() && agentFlag())
				updateTextForNB(policy, "Chdrnum", "");
			else
				updateText(policy, "CHDRNUM", "");
			updateText(policy, "OCCDATE", fomartDate(tLNPContSchema.getPValiDate()));
			updateText(policy, "HPROPDTE", fomartDate(tLNPContSchema.getPSignDate()));
			updateText(policy, "HPRRCVDT", fomartDate(tLNPAgentInfoSchema.getP1()));
			Element policyOwner = null;
			if (NBFlag() && agentFlag())
				policyOwner = policy.getChild("PolicyOwner");
			else
				policyOwner = policy.getChild("POLICYOWNER");
			updateText(policyOwner, "OWNERSEL", tLNPAppntSchema.getAppntNo());
			updateText(policyOwner, "SALUTL", "MR / MRS");
			updateText(policyOwner, "LSURNAME", tLNPAppntSchema.getAppntName());
			updateText(policyOwner, "DOB", fomartDate(tLNPAppntSchema.getAppntBirthday()));
			updateText(policyOwner, "CLTSEX", mappingCode(tLNPAppntSchema.getAppntSex(), "BankPolicySex"));
			updateText(policyOwner, "MARRYD", "");
			updateText(policyOwner, "ZACLTADDR", combAddress(tAppntAddressSchema, "2"));
			updateText(policyOwner, "CLTPCODE", tAppntAddressSchema.getCompanyZipCode());
			updateText(policyOwner, "ADDRTYPE", "1");
			updateText(policyOwner, "ZNBUSUT", tAppntAddressSchema.getGrpName());
			updateText(policyOwner, "CTRYCODE", tLNPAppntSchema.getNativePlace());
			updateText(policyOwner, "NATLTY", tLNPAppntSchema.getNativePlace());
			updateText(policyOwner, "CLRSKIND", "1");
			updateText(policyOwner, "RSKFLG", "1");
			updateText(policyOwner, "IDNPRF", mappingCode(tLNPAppntSchema.getIDType(), "BankCertType"));
			updateText(policyOwner, "SECUITYNO", tLNPAppntSchema.getIDNo());
			updateText(policyOwner, "EXPDTE", turnNullToString(tLNPAppntSchema.getIDValidity()).trim().equals("") ? "99999999" : "1".equals(tLNPAppntSchema.getIDPerpetual()) ? fomartDate(tLNPAppntSchema.getIDValidity()) : fomartDate(mappingCode(tLNPAppntSchema.getIDPerpetual(), "BankCertificatesType")));
			updateText(policyOwner, "INCPRF", "");
			updateText(policyOwner, "INCDESC", "");
			updateText(policyOwner, "DECGRSAL", turnNullToString(Integer.valueOf((int)Arith.mul(tLNPAppntSchema.getSalary(), 10000D))));
			updateText(policyOwner, "RMBLPHONE", tAppntAddressSchema.getPhone());
			updateText(policyOwner, "CLTPHONE", combPhone(tAppntAddressSchema.getMobileChs2(), tAppntAddressSchema.getCompanyPhone()));
			updateText(policyOwner, "RINTERNET", tAppntAddressSchema.getCompanyMail());
			updateText(policyOwner, "OCCPCODE", tLNPAppntSchema.getOccupationCode());
			updateText(policyOwner, "ZNPIDCPYID", mappingCode(tLNPAppntSchema.getHealth(), "BankIsOrNo"));
			updateText(policyOwner, "PRSKINDOWN", "");
			updateText(policyOwner, "ANNPRMTEND", "0");
			updateText(policyOwner, "FMLINCOME", "0");
			updateText(policyOwner, "RSDTKIND", "");
			updateText(policy, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(tLNPContSchema.getPayIntv())), "BankFrequency"));
			updateText(policy, "ZNFPMOP", mappingCode(tLNPPaymentSchema.getPayMent1(), "BankRenewal"));
			updateText(policy, "MOP", "5".equals(turnNullToString(Integer.valueOf(tLNPContSchema.getPayIntv()))) ? "N" : mappingCode(tLNPPaymentSchema.getPayMent2(), "BankRenewal"));
			updateText(policy, "ZDIVOPT", mappingCode(tLNPBonusInfoSchema.getBonusWay(), "BankBonusPayMent"));
			updateText(policy, "ZNFOPT", mappingCode(tLNPBonusInfoSchema.getP2(), "BankOverDue"));
			updateText(policy, "CNTCURR", "CNY");
			updateText(policy, "BILLCURR", "CNY");
			updateText(policy, "REGISTER", "01");
			updateText(policy, "SRCEBUS", "3");
			if (tLNPPolSet.size() > 0 && "2".equals(tLNPPolSet.get(1).getRnewFlag()))
				updateText(policy, "SRCEBUS", turnToCode(tLNPPolSet.get(1).getUWTime()));
			updateText(policy, "DLVRMODE", "01,02,03".indexOf(turnNullToString(tLNPAgentInfoSchema.getP3())) != -1 ? mappingCode(tLNPAgentInfoSchema.getP3(), "BankDeliveryType") : "04");
			updateText(policy, "ZNPSTADD", combAddress(tAppntAddressSchema, "1"));
			updateText(policy, "CLTPCODE03", tAppntAddressSchema.getHomeZipCode());
			updateText(policy, "ZNAGNTSEL", tLNPAgentInfoSchema.getP2());
			updateText(policy, "AGCOMRT", "100");
			Element subAgent = null;
			if (NBFlag() && agentFlag())
				subAgent = policy.getChild("SubAgnetList");
			else
				subAgent = policy.getChild("SUBAGENTLIST");
			updateText(subAgent, "ZNAGNTSEL01", "");
			updateText(subAgent, "SPLITC", "0");
			updateText(policy, "ZNCSMNAME", tLNPAgentInfoSchema.getAgentCode());
			if ("2".equals(tLNPPolSet.get(1).getRnewFlag()) && ("AGY".equals(tLNPPolSet.get(1).getUWTime()) || "TM".equals(tLNPPolSet.get(1).getUWTime())))
				updateText(policy, "ZNCSMNAME", "");
			Element insured = null;
			if (NBFlag() && agentFlag())
				insured = policy.getChild("INSLST").getChild("Insured");
			else
				insured = policy.getChild("INSLST").getChild("INSURED");
			updateText(insured, "Life", "01");
			Element insuredInfo = null;
			if (NBFlag() && agentFlag())
				insuredInfo = insured.getChild("InsuredInfo");
			else
				insuredInfo = insured.getChild("INSUREDINFO");
			updateText(insuredInfo, "LIFCNUM", tLNPInsuredSchema.getInsuredNo());
			updateText(insuredInfo, "SALUTL02", "MR / MRS");
			updateText(insuredInfo, "LSURNAME02", tLNPInsuredSchema.getName());
			updateText(insuredInfo, "DOB02", fomartDate(tLNPInsuredSchema.getBirthday()));
			updateText(insuredInfo, "CLTSEX02", mappingCode(tLNPInsuredSchema.getSex(), "BankPolicySex"));
			updateText(insuredInfo, "MARRYD02", "");
			updateText(insuredInfo, "ZACLTADDR02", combAddress(tInsurAddressSchema, "2"));
			updateText(insuredInfo, "CLTPCODE02", tInsurAddressSchema.getCompanyZipCode());
			updateText(insuredInfo, "ADDRTYPE02", "1");
			updateText(insuredInfo, "ZNBUSUT02", tInsurAddressSchema.getGrpName());
			updateText(insuredInfo, "CTRYCODE02", tLNPInsuredSchema.getNativePlace());
			updateText(insuredInfo, "NATLTY02", tLNPInsuredSchema.getNativePlace());
			updateText(insuredInfo, "CLRSKIND02", "1");
			updateText(insuredInfo, "RSKFLG02", "1");
			updateText(insuredInfo, "IDNPRF02", mappingCode(tLNPInsuredSchema.getIDType(), "BankCertType"));
			updateText(insuredInfo, "SECUITYNO02", tLNPInsuredSchema.getIDNo());
			updateText(insuredInfo, "EXPDTE02", turnNullToString(tLNPInsuredSchema.getIDValidity()).trim().equals("") ? "99999999" : "1".equals(tLNPInsuredSchema.getIDPerpetual()) ? fomartDate(tLNPInsuredSchema.getIDValidity()) : fomartDate(mappingCode(tLNPInsuredSchema.getIDPerpetual(), "BankCertificatesType")));
			updateText(insuredInfo, "INCPRF02", "");
			updateText(insuredInfo, "INCDESC02", "");
			updateText(insuredInfo, "DECGRSAL02", turnNullToString(Integer.valueOf((int)Arith.mul(tLNPInsuredSchema.getSalary(), 10000D))));
			updateText(insuredInfo, "RMBLPHONE02", tInsurAddressSchema.getPhone());
			updateText(insuredInfo, "CLTPHONE02", combPhone(tInsurAddressSchema.getMobileChs2(), tInsurAddressSchema.getCompanyPhone()));
			updateText(insuredInfo, "RINTERNET02", tInsurAddressSchema.getCompanyMail());
			updateText(insuredInfo, "OCCPCODE02", tLNPInsuredSchema.getOccupationCode());
			updateText(insuredInfo, "ZNPIDCPYID02", mappingCode(tLNPInsuredSchema.getHealth(), "BankIsOrNo"));
			updateText(insuredInfo, "PRSKINDINS", "");
			updateText(insured, "RELATION", mappingCode(tLNPAppntSchema.getRelationToInsured(), "BankRelationship"));
			updateText(insured, "SELECTION", "");
			updateText(insured, "HEIGHT", mappingQues("A05", "insur", tLNPContSchema.getContNo(), saleChannel));
			updateText(insured, "WEIGHT", mappingQues("A06", "insur", tLNPContSchema.getContNo(), saleChannel));
			updateText(insured, "SMOKING", "");
			updateText(insured, "OCCUP", tLNPInsuredSchema.getOccupationCode());
			Element questionArea = null;
			if (NBFlag() && agentFlag())
				questionArea = insured.getChild("Questionare");
			else
				questionArea = insured.getChild("QUESTIONARE");
			if ("2".equals(saleChannel))
				updateText(questionArea, "QUESTSET", "MTQTM");
			else
				updateText(questionArea, "QUESTSET", "MTQBA");
			boolean isDoHiuTianShi = false;
			for (int i = 1; i <= tLNPPolSet.size(); i++)
			{
				LNPPolSchema tempPol1 = tLNPPolSet.get(i);
				if ("MR12BQ".equals(tempPol1.getRiskCode()) || "MR12BR".equals(tempPol1.getRiskCode()))
					isDoHiuTianShi = true;
			}

			if (isDoHiuTianShi)
				updateText(questionArea, "QUESTSET", "MTQB1");
			LNPCodeSet codeSet = new LNPCodeSet();
			LNPCodeDB db = new LNPCodeDB(con);
			db.setCodeType("QueCodeMapping");
			db.setComCode(saleChannel);
			codeSet = db.query();
			Element questionList = questionArea.getChild("QUESTIONLIST");
			Element question = questionList.getChild("QUESTION");
			if (codeSet.size() > 0)
				questionList.removeContent();
			for (int i = 1; i <= codeSet.size(); i++)
			{
				Element tempElement = (Element)question.clone();
				updateText(tempElement, "QUESTIDF", codeSet.get(i).getCodeName());
				updateText(tempElement, "ANSWER", mappingQues(codeSet.get(i).getCodeName(), codeSet.get(i).getOtherSign(), tLNPContSchema.getContNo(), saleChannel));
				String qid = codeSet.get(i).getCodeName();
				if (!isDoHiuTianShi && "B04".equals(qid))
				{
					updateText(tempElement, "QUESTIDF", "B03");
					updateText(tempElement, "ANSWER", "");
				}
				questionList.addContent(tempElement);
			}

			updateText(insured, "HUWDCDTE", "99999999");
			Element coverageList = insured.getChild("COVLST");
			Element coverageInfo = coverageList.getChild("COVINFO");
			if (tLNPPolSet.size() > 0)
				coverageList.removeContent();
			int i = 1;
			int j = 1;
			for (; i <= tLNPPolSet.size(); i++)
			{
				Element tempCoverage = (Element)coverageInfo.clone();
				LNPPolSchema tempPol = tLNPPolSet.get(i);
				if (NBFlag() && agentFlag())
					updateTextForNB(tempCoverage, "Coverage", "01");
				else
					updateText(tempCoverage, "Coverage", "01");
				if (!"M".equalsIgnoreCase(tempPol.getSubFlag()))
					updateText(tempCoverage, "RIDER", (new StringBuilder("0")).append(j++).toString());
				else
					updateText(tempCoverage, "RIDER", "00");
				updateText(tempCoverage, "ZNPRDCODE", tempPol.getRiskCode());
				updateText(tempCoverage, "SUMIN", turnNullToString(Integer.valueOf((int)tempPol.getAmnt())));
				if (flag)
				{
					if ("A".equals(tempPol.getPremToAmnt()))
						updateText(tempCoverage, "RCESSAGE", turnNullToString(tempPol.getPayLocation()));
					else
						updateText(tempCoverage, "RCESSTRM", turnNullToString(tempPol.getPayLocation()));
					if ("A".equals(tempPol.getAcciYearFlag()))
						updateText(tempCoverage, "PCESSAGE", turnNullToString(tempPol.getPayMode()));
					else
						updateText(tempCoverage, "PCESSTRM", "1000".equals(turnNullToString(tempPol.getPayMode())) ? "1" : turnNullToString(tempPol.getPayMode()));
					if ("A".equals(tempPol.getGetYearFlag()))
						updateText(tempCoverage, "BCESSAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
					else
						updateText(tempCoverage, "BCESSTRM", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
				} else
				{
					if ("A".equals(tempPol.getInsuYearFlag()))
						updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
					else
						updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
					if ("A".equals(tempPol.getPayEndYearFlag()))
						updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
					else
						updateText(tempCoverage, "PCESSTRM", "1000".equals(turnNullToString(Integer.valueOf(tempPol.getPayEndYear()))) ? "1" : turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
					if ("A".equals(tempPol.getGetYearFlag()))
					{
						if (tempPol.getRiskCode().equals("LA11BA") && turnNullToString(Integer.valueOf(tempPol.getInsuYear())).equals("20"))
							updateText(tempCoverage, "BCESSTRM", "11");
						else
						if (tempPol.getRiskCode().equals("LA11BA") && turnNullToString(Integer.valueOf(tempPol.getInsuYear())).equals("25"))
							updateText(tempCoverage, "BCESSTRM", "16");
						else
							updateText(tempCoverage, "BCESSAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
					} else
					{
						updateText(tempCoverage, "BCESSTRM", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
					}
				}
				updateText(tempCoverage, "MORTCLS", "2");
				updateText(tempCoverage, "INSTPRM", turnNullToString(fomartNum(tempPol.getPrem())));
				updateText(tempCoverage, "ZPRFLG", "N");
				if (tLNPInvestmentInfoSchema != null && !turnNullToString(tLNPInvestmentInfoSchema.getTermInvestment()).equals("") && tLNPInvestmentInfoSchema.getMonthPlusPrem() > 0.0D && Double.parseDouble(tLNPInvestmentInfoSchema.getTermInvestment()) > 0.0D)
				{
					updateText(tempCoverage, "LMPCNT", tLNPInvestmentInfoSchema.getPayExtraPremFlag());
					updateText(tempCoverage, "ZPRFLG", "Y");
					updateText(tempCoverage, "ZNINVAMT", turnNullToString(Integer.valueOf((int)tLNPInvestmentInfoSchema.getMonthPlusPrem())));
					updateText(tempCoverage, "ZNTRM", tLNPInvestmentInfoSchema.getTermInvestment());
				}
				updateText(tempCoverage, "ZUNIT", "1");
				updateText(tempCoverage, "LIVESNO", "1");
				updateText(tempCoverage, "PAYCLT", tLNPAppntSchema.getAppntNo());
				Element payBankInfor = null;
				if (NBFlag() && agentFlag())
					payBankInfor = tempCoverage.getChild("PayBankInfor");
				else
					payBankInfor = tempCoverage.getChild("PAYBANKINFOR");
				if ("02".equals(tLNPPaymentSchema.getPayMent1()))
				{
					updateText(payBankInfor, "BANKCODE", "");
					updateText(payBankInfor, "BANKKEY", tLNPPaymentSchema.getBankCode());
					updateText(payBankInfor, "BANKACCKEY", tLNPPaymentSchema.getAccount());
					updateText(payBankInfor, "BANKDESC", tLNPAppntSchema.getAppntName());
					updateText(payBankInfor, "BNKACTYP", "");
					updateText(payBankInfor, "CURRCODE", "CNY");
					updateText(payBankInfor, "DATEFROM", fomartDate(tLNPContSchema.getPValiDate()));
					updateText(payBankInfor, "TIMESUSE", "0");
				}
				updateText(tempCoverage, "FREQANN", "-1".equals(tempPol.getStandbyFlag3()) ? "" : mappingCode(tempPol.getStandbyFlag3(), "BankAnnuityReceive"));
				String ANNSendtext = "";
				String CPNSendtext = "";
				ExeSQL tExeSQL = new ExeSQL();
				String sql = (new StringBuilder("select L_BankBonusMode,L_BankAnnMode,L_BankAnnFreq,L_BankCpnMode from [LNPRiskConfig] where L_RiskCode='")).append(tempPol.getRiskCode()).append("'").toString();
				SSRS tSRS = tExeSQL.execSQL(sql);
				if (tSRS.MaxRow > 0)
				{
					String L_BankAnnMode = tSRS.GetText(1, 2);
					String L_BankCpnMode = tSRS.GetText(1, 4);
					if (!"-1".equals(L_BankAnnMode))
						ANNSendtext = "-1".equals(tempPol.getDeadGetMode()) ? "" : mappingCode(tempPol.getDeadGetMode(), "BankAnnuity");
					if (!"-1".equals(L_BankCpnMode))
						CPNSendtext = "-1".equals(tempPol.getDeadGetMode()) ? "" : mappingCode(tempPol.getDeadGetMode(), "BankAnnuity");
					System.out.println((new StringBuilder("+_+_+_+_+_ANN=")).append(ANNSendtext).append("|||||CPN=").append(CPNSendtext).toString());
				}
				updateText(tempCoverage, "PMTANN", ANNSendtext);
				updateText(tempCoverage, "FREQCPN", "");
				updateText(tempCoverage, "PMTCPN", CPNSendtext);
				updateText(tempCoverage, "COMMSFLAG", "");
				updateText(tempCoverage, "CLMPMTFRQ", "");
				updateText(tempCoverage, "ADVANCE", "");
				updateText(tempCoverage, "ARREARS", "");
				updateText(tempCoverage, "GUARPERD", "0");
				updateText(tempCoverage, "WITHPROP", "");
				updateText(tempCoverage, "WITHOPROP", "");
				updateText(tempCoverage, "NOMLIFE", "");
				updateText(tempCoverage, "DTHPERCN", "0");
				updateText(tempCoverage, "DTHPERCO", "0");
				Element payment = null;
				if (NBFlag() && agentFlag())
					payment = tempCoverage.getChild("Payment");
				else
					payment = tempCoverage.getChild("PAYMENT");
				updateText(payment, "PAYCLT02", "");
				updateText(payment, "CLTYPE", "");
				updateText(payment, "RGPYMOP", "");
				updateText(payment, "REGPAYFREQ", "-1".equals(tempPol.getStandbyFlag3()) ? "" : mappingCode(tempPol.getStandbyFlag3(), "BankAnnuityReceive"));
				updateText(payment, "PRCNT", "0");
				updateText(payment, "CLAIMCUR", "CNY");
				if (tLNPInvestmentInfoSchema != null)
					updateText(tempCoverage, "RSUNIN", mappingCode(tLNPInvestmentInfoSchema.getHesInvestment(), "BankInvestment"));
				updateText(tempCoverage, "PRCAMTIND", "");
				Element PRMFundList = tempCoverage.getChild("PRMFLST");
				Element RGUFundList = tempCoverage.getChild("RGUFLST");
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

				if (NBFlag() && agentFlag())
				{
					updateTextForNB(tempCoverage, "CovField1", "");
					updateTextForNB(tempCoverage, "CovField2", "");
					updateTextForNB(tempCoverage, "CovField3", "");
					updateTextForNB(tempCoverage, "CovField4", "");
					updateTextForNB(tempCoverage, "CovField5", "");
				} else
				{
					updateText(tempCoverage, "ZACOVBAK01", "");
					updateText(tempCoverage, "ZACOVBAK02", "");
					updateText(tempCoverage, "ZACOVBAK03", "");
					updateText(tempCoverage, "ZACOVBAK04", "");
					updateText(tempCoverage, "ZACOVBAK05", "");
				}
				coverageList.addContent(tempCoverage);
			}

			Element bnfList = null;
			Element bnf = null;
			if (NBFlag() && agentFlag())
			{
				bnfList = policy.getChild("BeneficiaryList");
				bnf = bnfList.getChild("Beneficiary");
			} else
			{
				bnfList = policy.getChild("BENEFICIARYLIST");
				bnf = bnfList.getChild("BENEFICIARY");
			}
			if (tLNPInsuredSchema.getInsuredPeoples() > 0)
			{
				bnfList.removeContent();
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
					updateText(tempBnf, "EXPDTE04", turnNullToString(tempSchema.getIDValidity()).trim().equals("") ? "99999999" : "1".equals(tempSchema.getIDPerpetual()) ? fomartDate(tempSchema.getIDValidity()) : fomartDate(mappingCode(tempSchema.getIDPerpetual(), "BankCertificatesType")));
					updateText(tempBnf, "ZNPIDCPYID04", "");
					updateText(tempBnf, "CLTRELN02", mappingCode(tempSchema.getRelationToInsured(), "BankBenefitAndInsured"));
					updateText(tempBnf, "BNYPC", turnNullToString(Double.valueOf(tempSchema.getBenefitRate())));
					updateText(tempBnf, "ZBNYTLVL", Integer.parseInt(tempSchema.getBenefitOrder()) >= 10 ? tempSchema.getBenefitOrder() : (new StringBuilder("0")).append(tempSchema.getBenefitOrder()).toString());
					updateText(tempBnf, "EFFDATE", "0");
					updateText(tempBnf, "ZDCLMPLN", mappingCode(tLNPInsuredSchema.getCreditGrade(), "BankIsOrNo"));
					updateText(tempBnf, "BENSEQ", "");
					updateText(tempBnf, "BENREF", "");
					updateText(tempBnf, "CPKIND", "");
					updateText(tempBnf, "PRSKINDBEN", "");
					bnfList.addContent(tempBnf);
				}

			}
			if ("02".equals(tLNPPaymentSchema.getPayMent1()))
			{
				Element FRTRecBank = null;
				if (NBFlag() && agentFlag())
					FRTRecBank = policy.getChild("FRTRecBank");
				else
					FRTRecBank = policy.getChild("FRTRECBANK");
				updateText(FRTRecBank, "BANKKEY02", tLNPPaymentSchema.getBankCode());
				updateText(FRTRecBank, "BANKACCKEY02", tLNPPaymentSchema.getAccount());
				updateText(FRTRecBank, "BANKDESC02", tLNPAppntSchema.getAppntName());
				updateText(FRTRecBank, "BNKACTYP02", "");
				updateText(FRTRecBank, "CURRCODE02", "CNY");
				updateText(FRTRecBank, "DATEFROM01", fomartDate(tLNPContSchema.getPValiDate()));
				updateText(FRTRecBank, "DATETO", "0");
			}
			if ("02".equals(tLNPPaymentSchema.getPayMent2()))
			{
				Element SEQRecBank = null;
				if (NBFlag() && agentFlag())
					SEQRecBank = policy.getChild("SEQRecBank");
				else
					SEQRecBank = policy.getChild("SEQRECBANK");
				updateText(SEQRecBank, "BANKKEY03", tLNPPaymentSchema.getBankCode());
				updateText(SEQRecBank, "BANKACCKEY03", tLNPPaymentSchema.getAccount());
				updateText(SEQRecBank, "BANKDESC03", tLNPAppntSchema.getAppntName());
				updateText(SEQRecBank, "BNKACTYP03", "");
				updateText(SEQRecBank, "CURRCODE03", "CNY");
				updateText(SEQRecBank, "DATEFROM02", fomartDate(tLNPContSchema.getPValiDate()));
				updateText(SEQRecBank, "DATETO02", "0");
			}
			updateText(policy, "TRANDATEX", "0");
			updateText(policy, "TCHQDATE", "0");
			updateText(policy, "BANKDESC01R", "1");
			updateText(policy, "BANKDESC03R", "");
			updateText(policy, "RFCODE", "CN");
			updateText(policy, "RFNUM", "");
			updateText(policy, "PAYTYPE", "");
			updateText(policy, "DOCORIGAMT", "0");
			updateText(policy, "ZNOVRPAYOP", mappingCode(tLNPBonusInfoSchema.getP1(), "BankIsOrNo"));
			LNPPolSet tset = (new LNPPolDB(con)).executeQuery((new StringBuilder("select * from lnppol where contno='")).append(tContNo).append("' and RiskVersion is not null and RiskVersion<>'' and RnewFlag in ('1','2')").toString());
			if (tset.size() > 0)
			{
				Element packageInfo = null;
				if (NBFlag() && agentFlag())
				{
					packageInfo = policy.getChild("PackageInfo");
					updateTextForNB(packageInfo, "PackageCode", tset.get(1).getRiskVersion());
					updateTextForNB(packageInfo, "PackagePrem", turnNullToString(tset.get(1).getRemark()));
					updateTextForNB(packageInfo, "PackageSI", "0");
				} else
				{
					packageInfo = policy.getChild("PACKAGEINFO");
					updateText(packageInfo, "ZNPKGCODE", tset.get(1).getRiskVersion());
					updateText(packageInfo, "TOTPRE", turnNullToString(tset.get(1).getRemark()));
					updateText(packageInfo, "ZTOTSI", "0");
				}
			}
			Element remark = null;
			if (NBFlag() && agentFlag())
				remark = policy.getChild("GeneralRemark");
			else
				remark = policy.getChild("GENERALREMARK");
			String remark01 = "";
			String remark02 = "";
			if (!turnNullToString(tLNPContSchema.getConsignNo()).trim().equals(""))
			{
				remark01 = tLNPContSchema.getConsignNo().substring(0, tLNPContSchema.getConsignNo().length() / 2);
				remark02 = tLNPContSchema.getConsignNo().substring(tLNPContSchema.getConsignNo().length() / 2);
				System.out.println((new StringBuilder(String.valueOf(remark01))).append("---").append(remark02).toString());
			}
			if (NBFlag() && agentFlag())
			{
				updateTextForNB(remark, "ALINE01", remark01);
				updateTextForNB(remark, "ALINE02", remark02);
			} else
			{
				updateText(remark, "LINE01", remark01);
				updateText(remark, "LINE02", remark02);
			}
			updateText(policy, "SACSCODE", "");
			updateText(policy, "CAMPAIGN", "");
			updateText(policy, "ZNPRJTCD", "");
			updateText(policy, "ZNEPOLFLG", "");
			updateText(policy, "ZNDISPER", "0");
			updateText(policy, "ZNSPCTYP", "");
			updateText(policy, "ZNBILLNO", "");
			updateText(policy, "ZNINVBNK", "");
			updateText(policy, "VIP", mappingCode(tLNPAppntSchema.getAppntGrade(), "BankIsOrNo"));
			updateText(policy, "BUYERID", "");
			updateText(policy, "ZAPOLFLD1", "");
			updateText(policy, "ZAPOLFLD2", "");
			updateText(policy, "ZAPOLFLD3", "");
			updateText(policy, "ZAPOLFLD4", "");
			System.out.println("开始生成CRS报文字段信息");
			if (tCRSInfoSchema == null)
			{
				System.out.println("开始生成CRS报文字段信息null");
				System.out.println("CRS为null");
				updateText(policy, "ZAPOLFLD5", "");
			} else
			if (tCRSInfoSchema.getTaxResidentType() == null || "".equals(tCRSInfoSchema.getTaxResidentType()))
			{
				System.out.println("开始生成CRS报文字段信息type=nul");
				updateText(policy, "ZAPOLFLD5", "");
			} else
			{
				System.out.println("开始生成CRS报文字段信息1--2--3");
				updateText(policy, "ZAPOLFLD5", tCRSInfoSchema.getTaxResidentType());
				System.out.println("CRS发送LA报文已生成");
			}
			updateText(policy, "ZAPOLFLD6", "");
			updateText(policy, "ZAPOLFLD7", "");
			updateText(policy, "ZAPOLFLD8", "");
			updateText(policy, "ZAPOLFLD9", "");
			updateText(policy, "ZAPOLFLD10", "");
			updateText(policy, "ZAPOLFLD11", "");
			updateText(policy, "ZAPOLFLD12", "");
			updateText(policy, "ZAPOLFLD13", "");
			updateText(policy, "ZAPOLFLD14", "");
			updateText(policy, "ZAPOLFLD15", "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean agentFlag()
	{
		ExeSQL exeSql = new ExeSQL();
		String sql_lnpCode = "SELECT code FROM lnpcode where codetype = 'agentCode'";
		SSRS ssr1 = exeSql.execSQL(sql_lnpCode);
		if (ssr1.getMaxRow() > 0)
		{
			MUserDB mUser = new MUserDB();
			mUser.setUserCode(ssr1.GetText(1, 1));
			boolean mUserFlag = mUser.getInfo();
			String sql_laagent = (new StringBuilder("SELECT 'X' FROM LAAGENT WHERE AGENTCODE = '")).append(ssr1.GetText(1, 1)).append("'").toString();
			SSRS ssr2 = exeSql.execSQL(sql_laagent);
			if (mUserFlag || ssr2.getMaxRow() > 0)
				return true;
		}
		return false;
	}

	private boolean NBFlag()
	{
		MSysVarDB msy = new MSysVarDB();
		msy.setVarType("NBSwitch");
		return msy.getInfo() && "Y".equalsIgnoreCase(msy.getSchema().getVarValue());
	}

	public boolean getInputData(String tContNo)
	{
		flag = false;
		valiPassFlag = true;
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
		LNPContDB tLNPContDB;
		tLNPContDB = new LNPContDB(con);
		tLNPContDB.setContNo(tContNo);
		if (tLNPContDB.getInfo())
			break MISSING_BLOCK_LABEL_128;
		message = "获取投保书信息失败！";
		return valiPassFlag = false;
		tLNPContSchema = tLNPContDB.getSchema();
		LNPAppntDB tLNPAppntDB = new LNPAppntDB(con);
		tLNPAppntDB.setContNo(tContNo);
		if (tLNPAppntDB.getInfo())
		{
			tLNPAppntSchema = tLNPAppntDB.getSchema();
			break MISSING_BLOCK_LABEL_190;
		}
		message = "缺失投保人信息！";
		return valiPassFlag = false;
		tAppntAddressSchema = (new LNPAddressDB(con)).executeQuery((new StringBuilder("select * from lnpaddress a where  exists(select 1 from lnpappnt b where a.customerid=b.appntid  and b.contno='")).append(tContNo).append("')").toString()).get(1);
		CRSInfoDB tCRSInfoDB = new CRSInfoDB(con);
		tCRSInfoDB.setContNo(tContNo);
		if (tCRSInfoDB.getInfo())
			tCRSInfoSchema = tCRSInfoDB.getSchema();
		else
			System.out.println("该保单在数据库中无信息!");
		tLNPInsuredSchema = (new LNPInsuredDB(con)).executeQuery((new StringBuilder("select * from LNPInsured where contno='")).append(tContNo).append("'").toString()).get(1);
		if (tLNPInsuredSchema != null)
			break MISSING_BLOCK_LABEL_349;
		message = "缺失被保人信息！";
		return valiPassFlag = false;
		tInsurAddressSchema = (new LNPAddressDB(con)).executeQuery((new StringBuilder("select * from lnpaddress a where  exists(select 1 from lnpinsured b where a.customerid=b.insuredid  and b.contno='")).append(tContNo).append("')").toString()).get(1);
		tLNPBnfSet = (new LNPBnfDB(con)).executeQuery((new StringBuilder("select * from lnpbnf where contno='")).append(tContNo).append("' and (health is null or health<>'delete') order by bnforder").toString());
		if (tLNPInsuredSchema.getInsuredPeoples() <= 0 || tLNPBnfSet.size() <= 0) goto _L2; else goto _L1
_L1:
		String msg;
		int i;
		msg = "请完善“客户信息”中“受益人信息”部分的信息项！";
		i = 1;
		  goto _L3
_L4:
		LNPBnfSchema tSchema = tLNPBnfSet.get(i);
		if (!turnNullToString(Double.valueOf(tSchema.getBenefitRate())).equals("") && !turnNullToString(tSchema.getBenefitOrder()).equals("") && !turnNullToString(tLNPInsuredSchema.getCreditGrade()).equals(""))
			continue; /* Loop/switch isn't completed */
		message = msg;
		return valiPassFlag = false;
		i++;
_L3:
		if (i <= tLNPBnfSet.size()) goto _L4; else goto _L2
_L2:
		tLNPAgentInfoSchema = (new LNPAgentInfoDB(con)).executeQuery((new StringBuilder("select * from LNPAgentInfo where contno='")).append(tContNo).append("'").toString()).get(1);
		if (tLNPAgentInfoSchema != null)
			break MISSING_BLOCK_LABEL_627;
		message = "缺失代理人信息！";
		return valiPassFlag = false;
		LNPPaymentDB tLNPPaymentDB = new LNPPaymentDB(con);
		tLNPPaymentDB.setContNo(tContNo);
		if (tLNPPaymentDB.getInfo())
		{
			tLNPPaymentSchema = tLNPPaymentDB.getSchema();
			String account = getDecryptAccount(tContNo);
			tLNPPaymentSchema.setAccount(account);
			break MISSING_BLOCK_LABEL_696;
		}
		message = "请先填写收付费信息！";
		return valiPassFlag = false;
		LNPBonusInfoDB tLNPBonusInfoDB = new LNPBonusInfoDB(con);
		tLNPBonusInfoDB.setContNo(tContNo);
		if (tLNPBonusInfoDB.getInfo())
		{
			tLNPBonusInfoSchema = tLNPBonusInfoDB.getSchema();
			break MISSING_BLOCK_LABEL_749;
		}
		message = "请先填写红利信息！";
		return valiPassFlag = false;
		try
		{
			tLNPPolSet = (new LNPPolDB(con)).executeQuery((new StringBuilder("select * from lnppol where contno='")).append(tContNo).append("'").toString());
			for (int i = 1; i <= tLNPPolSet.size(); i++)
			{
				if ("".equals(turnNullToString(tLNPPolSet.get(i).getRiskVersion()).trim()))
					continue;
				System.out.println("issue_service~~~~~~~~~~~current policy risk type is package~~~~~~~~~~");
				flag = true;
				break;
			}

			saleChannel = turnToCode(tLNPPolSet.get(1).getUWTime());
			tLNPInvestmentInfoSchema = (new LNPInvestmentInfoDB(con)).executeQuery((new StringBuilder("select * from LNPInvestmentInfo where contno='")).append(tContNo).append("'").toString()).get(1);
			tLNpInvestmentAccountInfoSet = (new LNPInvestmentAccountInfoDB(con)).executeQuery((new StringBuilder("select * from LNPInvestmentAccountInfo where contno='")).append(tContNo).append("' and InvestAccountRate>0").toString());
			LNPCUWMasterSet set = (new LNPCUWMasterDB(con)).executeQuery((new StringBuilder("select * from LNPCUWMaster where contno='")).append(tContNo).append("'").toString());
			if (set.size() > 0)
			{
				tLNPCUWMasterSchema = set.get(1);
			} else
			{
				System.out.println("丢失核保结论~~~~~~~~");
				tLNPCUWMasterSchema = new LNPCUWMasterSchema();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return valiPassFlag = false;
		}
		return true;
	}

	public static void main(String args[])
	{
		FinalSubmissionBean cal = new FinalSubmissionBean();
		String tContNo = "987654128888";
		tContNo = "098765432111";
		tContNo = "201603241559";
		tContNo = "201703206002";
		tContNo = "201505271129";
		cal.calInterfaces(tContNo);
	}
}
