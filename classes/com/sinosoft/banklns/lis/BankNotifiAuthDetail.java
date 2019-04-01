// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankNotifiAuthDetail.java

package com.sinosoft.banklns.lis;

import com.sinosoft.banklns.lis.bean.BankLNPAgentInfoBean;
import com.sinosoft.banklns.lis.bean.BankLNPContBean;
import com.sinosoft.banklns.lis.bean.BankLNPCustImpQueBean;
import com.sinosoft.banklns.lis.bean.BankLNPCustImpResultBean;
import com.sinosoft.banklns.lis.bean.BankLNPPaymentBean;
import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
import com.sinosoft.banklns.lis.db.LNPCustImpQueDB;
import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
import com.sinosoft.banklns.lis.db.LNPPaymentDB;
import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
import com.sinosoft.banklns.lis.pubfun.MMap;
import com.sinosoft.banklns.lis.pubfun.PubSubmit;
import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.schema.LNPCustImpQueSchema;
import com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema;
import com.sinosoft.banklns.lis.schema.LNPPaymentSchema;
import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
import com.sinosoft.banklns.lis.vschema.LNPCustImpQueSet;
import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
import com.sinosoft.banklns.lis.vschema.LNPPaymentSet;
import com.sinosoft.banklns.lnsmodel.*;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lis:
//			BankBasicBL

public class BankNotifiAuthDetail extends BankBasicBL
{

	private boolean editFlag;
	private boolean alertFlag;
	private String message;
	private ArrayList Errors;
	private boolean quesHasFlag;
	private boolean agentInfHasFlag;
	private boolean paymentHasFlag;
	private boolean allComplete;
	private boolean quesComplete;
	private boolean agentInfComplete;
	private boolean paymentComplete;
	private IGlobalInput GI;
	private String ContNo;
	private BankLNPContBean contBean;
	private BankLNPPaymentBean paymentBean;
	private BankLNPAgentInfoBean agentInfoBean;
	private List Appntanswers;
	private List Insuranswers;
	private BankLNPContBean contBeanBackup;
	private BankLNPPaymentBean paymentBeanBackup;
	private BankLNPAgentInfoBean agentInfoBeanBackup;
	private List AppntanswersBackup;
	private List InsuranswersBackup;
	private String FirPayType;
	private String EscPayType;
	private String ACounter;
	private String AuthBank;
	private String AuthACount;
	private String SignDate;
	private String TargetDate;
	private String AgentTrantype;
	private String AgentBranchattr;
	private String AgentBranchattrNm;
	private String AgentCode;
	private String PolPrintType;
	private BankOperateDeal stateOperate;
	private BankPolicyState policyState;
	public static Map brchAttrNmMap = new Hashtable();
	private List bankCodeList;
	private String saleChannelCode;
	private String AppntIsAllSelc;
	private String InsurIsAllSelc;
	private String quesType;
	private String quesId;
	private String quesVal;
	private String quesText;
	private String limtType;
	private String tTargetDate;
	private String tSignDate;
	private String tAgentCode;
	public boolean isRiskBQ;
	public boolean isRiskBR;

	public String getPolPrintType()
	{
		return PolPrintType;
	}

	public void setPolPrintType(String polPrintType)
	{
		PolPrintType = polPrintType;
	}

	public static void main(String args[])
	{
		BankNotifiAuthDetail detal = new BankNotifiAuthDetail();
		detal.initQuestionList();
		System.out.println((new StringBuilder(String.valueOf(detal.Appntanswers.size()))).append("---").append(detal.Insuranswers.size()).toString());
	}

	public BankNotifiAuthDetail()
	{
		Errors = new ArrayList();
		quesHasFlag = false;
		agentInfHasFlag = false;
		paymentHasFlag = false;
		allComplete = false;
		quesComplete = false;
		agentInfComplete = false;
		paymentComplete = false;
		ContNo = "";
		Appntanswers = new ArrayList();
		Insuranswers = new ArrayList();
		AppntanswersBackup = new ArrayList();
		InsuranswersBackup = new ArrayList();
		bankCodeList = new ArrayList();
		isRiskBQ = false;
		isRiskBR = false;
		System.out.println("----------------->构造函数initDetail<-------------------------");
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ContNo = (String)session.getAttribute("ContNo");
		initQuestionList();
	}

	public void initDetail()
	{
		try
		{
			System.out.println("-------------------->initDetail<--------------------------");
			alertFlag = false;
			message = "";
			Errors = new ArrayList();
			quesHasFlag = false;
			agentInfHasFlag = false;
			paymentHasFlag = false;
			allComplete = false;
			editFlag = true;
			initQuestionList();
			initPaymentNotiMsg(new BankLNPContBean(), new BankLNPPaymentBean());
			initAgenNotiMsg(new BankLNPContBean(), new BankLNPAgentInfoBean());
			if (getInfoFromSession())
			{
				contBean = recOneContInfo(ContNo);
				if (!"".equals(contBean.getSchema().getContNo()))
				{
					String contNo = contBean.getSchema().getContNo();
					quesHasFlag = isExistQues(contNo);
					paymentHasFlag = isExistPayment(contNo);
					if (paymentHasFlag)
						initPaymentNotiMsg(contBean, paymentBean);
					else
						ACounter = contBean.getSchema().getAppntName();
					agentInfHasFlag = isExistAgentInf(contNo);
					if (agentInfHasFlag)
						initAgenNotiMsg(contBean, agentInfoBean);
					else
						SignDate = formatDate(turnNullToString(agentInfoBean.getSchema().getP4()), "YYYYMMDD");
					stateOperate = new BankOperateDeal();
					boolean tEditFlag = stateOperate.isEidtSheet(contBean.getSchema().getState(), "04", GI.LNPRole, contNo);
					HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
					Boolean tQueyEditFlag = (Boolean)session.getAttribute("Queryflag");
					if (tQueyEditFlag == null)
						tQueyEditFlag = Boolean.valueOf(true);
					editFlag = tEditFlag && tQueyEditFlag.booleanValue();
					System.out.println((new StringBuilder("---------------->初始Msg： quesHasFlag：")).append(quesHasFlag).append("|paymentHasFlag:").append(paymentHasFlag).append("|agentInfHasFlag:").append(agentInfHasFlag).toString());
					System.out.println((new StringBuilder("---------------->初始Msg：当前sheet页是否可编辑(tEditFlag:")).append(tEditFlag).append("&&tQueyEditFlag:").append(tQueyEditFlag).append(")：").append(editFlag).append("|因为~当前人员类型：").append(GI.LNPRole).append("|保单状态：").append(contBean.getSchema().getState()).append("|").toString());
				}
			} else
			{
				buildMsg("全局投保书信息缺失!");
			}
			break MISSING_BLOCK_LABEL_563;
		}
		catch (Exception e)
		{
			turnCurrPolicyLockFlag(null, ContNo, "unlock");
			e.printStackTrace();
			buildMsg((new StringBuilder("初始化信息失败.因为：")).append(e.getMessage()).toString());
		}
		reportMsg();
		break MISSING_BLOCK_LABEL_567;
		Exception exception;
		exception;
		reportMsg();
		throw exception;
		reportMsg();
	}

	public void saveNotiMsg()
	{
		alertFlag = false;
		VData cInputData;
		MMap map;
		String curDate;
		String curTime;
		System.out.println((new StringBuilder("------------------>saveNotiMsg: 是否可编辑：")).append(editFlag).append("，不可编辑则不能保存").toString());
		if (!editFlag)
			break MISSING_BLOCK_LABEL_908;
		cInputData = new VData();
		map = new MMap();
		curDate = PubFun.getCurrentDate();
		curTime = PubFun.getCurrentTime();
		if (saveQuesMsg(map, quesHasFlag, contBean, Appntanswers, Insuranswers, curDate, curTime) && savePaymentMsg(map, paymentHasFlag, contBean, paymentBean, curDate, curTime) && saveAgentInfMsg(map, agentInfHasFlag, contBean, agentInfoBean, curDate, curTime))
			break MISSING_BLOCK_LABEL_198;
		if (alertFlag)
		{
			System.out.println();
			System.out.println((new StringBuilder("存在错误：------------------")).append(message).toString());
		}
		turnCurrPolicyLockFlag(null, ContNo, "unlock");
		reportMsg();
		return;
		try
		{
			allComplete = quesComplete && paymentComplete && agentInfComplete;
			System.out.println((new StringBuilder("本次必录项状态：quesComplete-")).append(quesComplete).append(" |paymentComplete-").append(paymentComplete).append("|agentInfComplete+").append(agentInfComplete).append("| 修改之前：state--》").append(contBean.getSchema().getState()).append("editstate---》").append(contBean.getSchema().getEditstate()).toString());
			stateOperate = new BankOperateDeal();
			boolean isChangeToCustomerMsg = false;
			List stateList;
			if (allComplete)
			{
				stateList = stateOperate.infoOprate(contBean.getSchema().getState(), contBean.getSchema().getEditstate(), "modify", "04");
				contBean.getSchema().setState((String)stateList.get(0));
				contBean.getSchema().setEditstate((String)stateList.get(1));
			} else
			if ("01".equals(contBean.getSchema().getState()))
			{
				String editState = stateOperate.updateEditStateUNDone(contBean.getSchema().getEditstate(), 4);
				contBean.getSchema().setEditstate(editState);
			}
			boolean isModifyfFlag = paymentHasFlag && agentInfHasFlag && allComplete;
			stateList = dealRefcOtherMsgBySuc(isModifyfFlag, contBean, paymentBean, agentInfoBean);
			if (stateList.size() > 0)
			{
				System.out.println("-------因为有保单信息被修改,将回滚保单状态值02待审核状态---------");
				isChangeToCustomerMsg = true;
				contBean.getSchema().setState((String)stateList.get(0));
				contBean.getSchema().setEditstate((String)stateList.get(1));
			}
			System.out.println((new StringBuilder("修改之后：state--》")).append(contBean.getSchema().getState()).append("editstate---》").append(contBean.getSchema().getEditstate()).toString());
			contBean.getSchema().setModifyDate(curDate);
			contBean.getSchema().setModifyTime(curTime);
			contBean.getSchema().setInputOperator(GI.Operator);
			map.put(contBean.getSchema(), "UPDATE");
			if (AuthACount != null && !"".equals(AuthACount))
			{
				String sql = (new StringBuilder("OPEN SYMMETRIC KEY key_encryption DECRYPTION BY CERTIFICATE cert_keyProtection;  update lnppayment set account=EncryptByKey(Key_GUID('key_encryption'),account) where contno='")).append(contBean.getSchema().getContNo()).append("'; ").append(" CLOSE SYMMETRIC KEY key_encryption;").toString();
				map.put(sql, "UPDATE");
			}
			cInputData.add(map);
			PubSubmit pubSubmit = new PubSubmit();
			if (!pubSubmit.submitData(cInputData, ""))
				buildMsg("客户信息保存失败!");
			else
				try
				{
					policyState = new BankPolicyState();
					if (isChangeToCustomerMsg)
						policyState.savePolicyState(ContNo, contBean.getSchema().getState(), "3", curDate, curTime);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					buildMsg("~~~~~~~~~~~~~~~~~~~~~保单状态记录接口报错!");
				}
			break MISSING_BLOCK_LABEL_908;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		turnCurrPolicyLockFlag(null, ContNo, "unlock");
		reportMsg();
		break MISSING_BLOCK_LABEL_924;
		Exception exception;
		exception;
		turnCurrPolicyLockFlag(null, ContNo, "unlock");
		reportMsg();
		throw exception;
		turnCurrPolicyLockFlag(null, ContNo, "unlock");
		reportMsg();
	}

	private List dealRefcOtherMsgBySuc(boolean isModify, BankLNPContBean contBean, BankLNPPaymentBean paymentBean, BankLNPAgentInfoBean agentInfoBean)
	{
		List list = new ArrayList();
		try
		{
			contBeanBackup = recOneContInfo(ContNo);
			if (isModify)
			{
				paymentBeanBackup = recPaymentInfo(ContNo);
				boolean isChangeToCustomerMsg = false;
				if (!turnNullToString(paymentBean.getSchema().getPayMent1()).equals(turnNullToString(paymentBeanBackup.getSchema().getPayMent1())) || !turnNullToString(paymentBean.getSchema().getPayMent2()).equals(turnNullToString(paymentBeanBackup.getSchema().getPayMent2())) || !turnNullToString(contBean.getSchema().getAppntName()).equals(turnNullToString(contBeanBackup.getSchema().getAppntName())) || !turnNullToString(paymentBean.getSchema().getBankCode()).equals(turnNullToString(paymentBeanBackup.getSchema().getBankCode())) || !turnNullToString(paymentBean.getSchema().getAccount()).equals(turnNullToString(getDecryptAccount(ContNo))))
				{
					isChangeToCustomerMsg = true;
					System.out.println("-------------------收付费信息有过改动---------------------");
				}
				agentInfoBeanBackup = recAgentInfo(ContNo);
				if (!turnNullToString(contBean.getSchema().getPSignDate()).equals(turnNullToString(contBeanBackup.getSchema().getPSignDate())) || !turnNullToString(agentInfoBean.getSchema().getP1()).equals(turnNullToString(agentInfoBeanBackup.getSchema().getP1())) || !turnNullToString(agentInfoBean.getSchema().getP3()).equals(turnNullToString(agentInfoBeanBackup.getSchema().getP3())) || !turnNullToString(agentInfoBean.getSchema().getP2()).equals(turnNullToString(agentInfoBeanBackup.getSchema().getP2())) || !turnNullToString(agentInfoBean.getSchema().getP4()).equals(turnNullToString(agentInfoBeanBackup.getSchema().getP4())) || !turnNullToString(agentInfoBean.getSchema().getAgentCode()).equals(turnNullToString(agentInfoBeanBackup.getSchema().getAgentCode())))
				{
					isChangeToCustomerMsg = true;
					System.out.println("-------------------代理人告知信息有过改动---------------------");
				}
				if (recAllQuesAnswer(ContNo))
				{
					boolean tFlag = false;
					for (int i = 0; i < AppntanswersBackup.size(); i++)
					{
						if (tFlag)
							break;
						BankLNPCustImpResultBean custRstBean = (BankLNPCustImpResultBean)AppntanswersBackup.get(i);
						for (int j = 0; j < Appntanswers.size(); j++)
						{
							BankLNPCustImpQueBean custQuesBean = (BankLNPCustImpQueBean)Appntanswers.get(j);
							System.out.println((new StringBuilder("appnt_quesID---")).append(custQuesBean.getAppntQues().getSchema().getQuestionid()).append("=?").append(custRstBean.getSchema().getQuestionId()).toString());
							if (!turnNullToString(custQuesBean.getAppntQues().getSchema().getQuestionid()).equals(custRstBean.getSchema().getQuestionId()))
								continue;
							if ("2".equals(custRstBean.getSchema().getQuestionType()) && !turnNullToString(custRstBean.getSchema().getAnswer()).equals(turnNullToString(custQuesBean.getAppntanswer())))
							{
								tFlag = isChangeToCustomerMsg = true;
								System.out.println("-------------------投保人基本告知信息有过改动2---------------------");
							} else
							if ("1".equals(custRstBean.getSchema().getQuestionType()) && !turnNullToString(custRstBean.getSchema().getOptionId()).equals(turnNullToString(custQuesBean.getAppntanswer())))
							{
								tFlag = isChangeToCustomerMsg = true;
								System.out.println("-------------------投保人基本告知信息有过改动1---------------------");
							}
							break;
						}

					}

					for (int i = 0; i < InsuranswersBackup.size(); i++)
					{
						if (tFlag)
							break;
						BankLNPCustImpResultBean custRstBean = (BankLNPCustImpResultBean)InsuranswersBackup.get(i);
						for (int j = 0; j < Insuranswers.size(); j++)
						{
							BankLNPCustImpQueBean custQuesBean = (BankLNPCustImpQueBean)Insuranswers.get(j);
							System.out.println((new StringBuilder("insur_quesID---")).append(custQuesBean.getInsurQues().getSchema().getQuestionid()).append("=?").append(custRstBean.getSchema().getQuestionId()).toString());
							if (!turnNullToString(custQuesBean.getInsurQues().getSchema().getQuestionid()).equals(custRstBean.getSchema().getQuestionId()))
								continue;
							if ("2".equals(custRstBean.getSchema().getQuestionType()) && !turnNullToString(custRstBean.getSchema().getAnswer()).equals(custQuesBean.getInsuranswer()))
							{
								tFlag = isChangeToCustomerMsg = true;
								System.out.println("-------------------被保人基本告知信息有过改动2---------------------");
							} else
							if ("1".equals(custRstBean.getSchema().getQuestionType()) && !turnNullToString(custRstBean.getSchema().getOptionId()).equals(custQuesBean.getInsuranswer()))
							{
								tFlag = isChangeToCustomerMsg = true;
								System.out.println("-------------------被保人基本告知信息有过改动1---------------------");
							}
							break;
						}

					}

				}
				System.out.println((new StringBuilder("是否符合修改+信息有变动，需要保单状态回滚到02：")).append(isChangeToCustomerMsg).append(" | 当前保单状态：state：").append(contBean.getSchema().getState()).append("|editstate:").append(contBean.getSchema().getEditstate()).append("|角色:").append(GI.LNPRole).toString());
				if (isChangeToCustomerMsg)
					list = stateOperate.changeMsgToModify(contBean.getSchema().getState(), contBean.getSchema().getEditstate(), GI.LNPRole);
			}
			copyMsg(contBeanBackup, paymentBeanBackup, agentInfoBeanBackup);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	private void copyMsg(BankLNPContBean oriContBean, BankLNPPaymentBean oriAppntBean, BankLNPAgentInfoBean oriAgentinfoBean)
	{
		contBean.getSchema().setConsignNo(oriContBean.getSchema().getConsignNo());
	}

	private String turnNullToString(Object object)
	{
		String rst = "";
		try
		{
			rst = object != null ? (new StringBuilder()).append(object).toString() : "";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		return rst.trim();
	}

	public void changeSelcRadio()
	{
		System.out.println((new StringBuilder("-------------->changeSelcRadio<----------------AppntIsAllSelc:")).append(AppntIsAllSelc).append("|InsurIsAllSelc:").append(InsurIsAllSelc).append("|quesType:").append(quesType).append("|quesId:").append(quesId).append("|quesVal:").append(quesVal).toString());
		System.out.println((new StringBuilder("-------------->changeSelcRadio<----------------quesText:")).append(quesText).toString());
		if (quesType.indexOf("all") >= 0)
		{
			if (quesType.indexOf("appnt") >= 0)
			{
				for (int i = 0; i < Appntanswers.size(); i++)
				{
					String queType = ((BankLNPCustImpQueBean)Appntanswers.get(i)).getAppntQues().getQuestionType();
					if ("1".equals(queType))
					{
						((BankLNPCustImpQueBean)Appntanswers.get(i)).setAppntanswer(AppntIsAllSelc);
						((BankLNPCustImpQueBean)Appntanswers.get(i)).setIsAppntAllSelected(AppntIsAllSelc);
					}
				}

				dealQuesText(quesText);
			} else
			{
				for (int i = 0; i < Insuranswers.size(); i++)
				{
					String queType = ((BankLNPCustImpQueBean)Insuranswers.get(i)).getInsurQues().getQuestionType();
					if ("1".equals(queType))
					{
						((BankLNPCustImpQueBean)Insuranswers.get(i)).setInsuranswer(InsurIsAllSelc);
						((BankLNPCustImpQueBean)Insuranswers.get(i)).setIsInsurAllSelected(InsurIsAllSelc);
					}
				}

				dealQuesText(quesText);
			}
		} else
		if (quesType.indexOf("appnt") >= 0)
		{
			for (int i = 0; i < Appntanswers.size(); i++)
			{
				if (!((BankLNPCustImpQueBean)Appntanswers.get(i)).getAppntQues().getQuestionid().equals(quesId))
					continue;
				((BankLNPCustImpQueBean)Appntanswers.get(i)).setAppntanswer(quesVal);
				break;
			}

			boolean isSelcAll = true;
			for (int i = 0; i < Appntanswers.size(); i++)
			{
				BankLNPCustImpQueBean tQueBean = (BankLNPCustImpQueBean)Appntanswers.get(i);
				if (!"1".equals(tQueBean.getAppntQues().getQuestionType()) || tQueBean.getAppntanswer().equals(quesVal))
					continue;
				isSelcAll = false;
				break;
			}

			if (!isSelcAll)
			{
				for (int i = 0; i < Appntanswers.size(); i++)
					((BankLNPCustImpQueBean)Appntanswers.get(i)).setIsAppntAllSelected("");

			} else
			{
				for (int i = 0; i < Appntanswers.size(); i++)
					((BankLNPCustImpQueBean)Appntanswers.get(i)).setIsAppntAllSelected(quesVal);

			}
			for (int i = 0; i < Appntanswers.size(); i++)
			{
				BankLNPCustImpQueBean bean = (BankLNPCustImpQueBean)Appntanswers.get(i);
				System.out.println((new StringBuilder(String.valueOf(bean.getAppntQues().getQuestionid()))).append("<--->").append(bean.getAppntanswer()).append("-->idx:").append(i).toString());
			}

			dealQuesText(quesText);
		} else
		{
			for (int i = 0; i < Insuranswers.size(); i++)
			{
				if (!((BankLNPCustImpQueBean)Insuranswers.get(i)).getInsurQues().getQuestionid().equals(quesId))
					continue;
				((BankLNPCustImpQueBean)Insuranswers.get(i)).setInsuranswer(quesVal);
				System.out.println((new StringBuilder("ok")).append(((BankLNPCustImpQueBean)Insuranswers.get(i)).getAppntanswer()).toString());
				break;
			}

			boolean isSelcAll = true;
			for (int i = 0; i < Insuranswers.size(); i++)
			{
				BankLNPCustImpQueBean tQueBean = (BankLNPCustImpQueBean)Insuranswers.get(i);
				if (!"1".equals(tQueBean.getInsurQues().getQuestionType()) || tQueBean.getInsuranswer().equals(quesVal))
					continue;
				isSelcAll = false;
				break;
			}

			if (!isSelcAll)
			{
				for (int i = 0; i < Insuranswers.size(); i++)
					((BankLNPCustImpQueBean)Insuranswers.get(i)).setIsInsurAllSelected("");

			} else
			{
				for (int i = 0; i < Insuranswers.size(); i++)
					((BankLNPCustImpQueBean)Insuranswers.get(i)).setIsInsurAllSelected(quesVal);

			}
			dealQuesText(quesText);
		}
		for (int i = 0; i < Insuranswers.size(); i++)
		{
			if (!"0101170017".equals(((BankLNPCustImpQueBean)Insuranswers.get(i)).getInsurQues().getQuestionid()) || !"2".equals(((BankLNPCustImpQueBean)Insuranswers.get(i)).getInsuranswer()))
				continue;
			((BankLNPCustImpQueBean)Insuranswers.get(i + 1)).setInsuranswer("");
			System.out.println("被保人孕周选否，所以被清空");
			break;
		}

		for (int i = 0; i < Appntanswers.size(); i++)
		{
			if (!"0101170017".equals(((BankLNPCustImpQueBean)Appntanswers.get(i)).getAppntQues().getQuestionid()) || !"2".equals(((BankLNPCustImpQueBean)Appntanswers.get(i)).getAppntanswer()))
				continue;
			((BankLNPCustImpQueBean)Appntanswers.get(i + 1)).setAppntanswer("");
			System.out.println("投保人孕周选否，所以被清空");
			break;
		}

	}

	private void dealQuesText(String quesText)
	{
		if ("".equals(quesText))
			return;
		String ques[] = quesText.split("\\|");
		for (int i = 0; i < ques.length; i++)
		{
			String targs[] = ques[i].split("\\^");
			String quesType = targs[0];
			String quesId = targs[1];
			String quesTxt = "";
			String quesParentId = (new StringBuilder(String.valueOf(quesId.substring(0, quesId.length() - 1)))).append("1").toString();
			String quesParentVal = "";
			System.out.println((new StringBuilder("父问题编码")).append(quesParentId).toString());
			if (targs.length > 2)
				quesTxt = targs[2];
			if (quesType.indexOf("appnt") >= 0)
			{
				for (int j = 0; j < Appntanswers.size(); j++)
				{
					if (((BankLNPCustImpQueBean)Appntanswers.get(j)).getAppntQues().getQuestionid().equals(quesParentId))
						quesParentVal = ((BankLNPCustImpQueBean)Appntanswers.get(j)).getAppntanswer();
					if (((BankLNPCustImpQueBean)Appntanswers.get(j)).getAppntQues().getQuestionid().equals(quesId))
						if ("2".equals(quesParentVal))
							((BankLNPCustImpQueBean)Appntanswers.get(j)).setAppntanswer("");
						else
							((BankLNPCustImpQueBean)Appntanswers.get(j)).setAppntanswer(quesTxt);
				}

			} else
			{
				for (int j = 0; j < Insuranswers.size(); j++)
				{
					if (((BankLNPCustImpQueBean)Insuranswers.get(j)).getInsurQues().getQuestionid().equals(quesParentId))
						quesParentVal = ((BankLNPCustImpQueBean)Insuranswers.get(j)).getInsuranswer();
					if (((BankLNPCustImpQueBean)Insuranswers.get(j)).getInsurQues().getQuestionid().equals(quesId))
						if ("2".equals(quesParentVal))
							((BankLNPCustImpQueBean)Insuranswers.get(j)).setInsuranswer("");
						else
							((BankLNPCustImpQueBean)Insuranswers.get(j)).setInsuranswer(quesTxt);
				}

			}
		}

	}

	public void listPre()
	{
		if ("appnt".equals(limtType))
		{
			for (int i = 0; i < Appntanswers.size(); i++)
			{
				if (!"0101180117".equals(((BankLNPCustImpQueBean)Appntanswers.get(i)).getAppntQues().getQuestionid()))
					continue;
				((BankLNPCustImpQueBean)Appntanswers.get(i)).setAppntanswer("");
				System.out.println((new StringBuilder("questionID:")).append(((BankLNPCustImpQueBean)Appntanswers.get(i)).getAppntQues().getQuestionid()).append("answer:").append(((BankLNPCustImpQueBean)Appntanswers.get(i)).getAppntanswer()).toString());
				break;
			}

		} else
		{
			for (int i = 0; i < Insuranswers.size(); i++)
			{
				if (!"0101180117".equals(((BankLNPCustImpQueBean)Insuranswers.get(i)).getInsurQues().getQuestionid()))
					continue;
				((BankLNPCustImpQueBean)Insuranswers.get(i)).setInsuranswer("");
				break;
			}

		}
	}

	public boolean checkComCode()
	{
		boolean flag = false;
		alertFlag = false;
		try
		{
			ExeSQL execSQL = new ExeSQL();
			String sql = (new StringBuilder("select c.agentcom,c.name from LACom c where exists (select 1 from LNPCont b where b.signcom=c.managecom and b.contno='")).append(ContNo).append("') and c.agentcom=upper('").append(AgentBranchattr).append("')").toString();
			System.out.println((new StringBuilder("sql-->")).append(sql).toString());
			SSRS rs = execSQL.execSQL(sql);
			if (rs.MaxRow > 0)
			{
				AgentBranchattr = rs.GetText(1, 1);
				AgentBranchattrNm = rs.GetText(1, 2);
				flag = true;
			} else
			{
				buildMsg("对应当前投保签署地所选择的代理网点不存在，请重新录入!");
				AgentBranchattr = "";
				AgentBranchattrNm = "";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public void checkTarDate()
	{
		alertFlag = false;
		String pTargetDate = agentInfoBean.getSchema().getP1();
		if (tTargetDate == null || "".equals(tTargetDate.trim()))
			break MISSING_BLOCK_LABEL_125;
		String curDate = PubFun.getCurrentDate().replaceAll("-", "");
		if (Integer.parseInt(tTargetDate.trim()) > Integer.parseInt(curDate.trim()) || tTargetDate.length() != 8)
		{
			TargetDate = pTargetDate;
			buildMsg("投保书卡钟日不能晚于系统当前日期");
			return;
		}
		try
		{
			TargetDate = tTargetDate;
			agentInfoBean.getSchema().setP1(tTargetDate);
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
	}

	public String gettTargetDate()
	{
		return tTargetDate;
	}

	public void settTargetDate(String tTargetDate)
	{
		this.tTargetDate = tTargetDate;
	}

	public void checkSignDate()
	{
		alertFlag = false;
		String tPvaliDate;
		tPvaliDate = turnNullToString(contBean.getSchema().getPValiDate()).replaceAll("-", "");
		if (tSignDate == null || "".equals(tSignDate.trim()))
			break MISSING_BLOCK_LABEL_401;
		String curDate = PubFun.getCurrentDate().replaceAll("-", "");
		if (Integer.parseInt(tSignDate.trim()) > Integer.parseInt(curDate.trim()) || tSignDate.length() != 8)
		{
			SignDate = tPvaliDate;
			buildMsg("投保书签署日不能晚于系统当前日期");
			return;
		}
		String insurBirth;
		if (tSignDate.equals(tPvaliDate) && tSignDate.equals(SignDate))
			break MISSING_BLOCK_LABEL_417;
		String appntBirth = contBean.getSchema().getAppntBirthday();
		insurBirth = contBean.getSchema().getInsuredBirthday();
		System.out.println((new StringBuilder("投保书签署日与生效日变动: tsignDate-")).append(tSignDate).append("PValiDate-").append(tPvaliDate).append("appntBirth-").append(appntBirth).append("insurBirth-").append(insurBirth).toString());
		if (appntBirth != null && !"".equals(appntBirth.trim()))
		{
			appntBirth = appntBirth.replaceAll("-", "");
			if (Integer.parseInt(tSignDate.trim()) < Integer.parseInt(appntBirth.trim()))
			{
				SignDate = tPvaliDate;
				buildMsg((new StringBuilder("投保人出生日期为“")).append(appntBirth).append("”，投保书签署日期不可早于投保人出生日期").toString());
				return;
			}
		}
		if (insurBirth != null && !"".equals(insurBirth.trim()))
		{
			insurBirth = insurBirth.replaceAll("-", "");
			if (Integer.parseInt(tSignDate.trim()) < Integer.parseInt(insurBirth.trim()))
			{
				SignDate = tPvaliDate;
				buildMsg((new StringBuilder("被保人出生日期为“")).append(insurBirth).append("”，投保书签署日期不可早于被保人出生日期").toString());
				return;
			}
		}
		SignDate = tSignDate;
		contBean.getSchema().setPValiDate(tSignDate);
		break MISSING_BLOCK_LABEL_417;
		SignDate = tSignDate;
		break MISSING_BLOCK_LABEL_417;
		RuntimeException e;
		e;
		e.printStackTrace();
	}

	public void checkAgentCode()
	{
		alertFlag = false;
		if (tAgentCode == null || "".equals(tAgentCode))
			break MISSING_BLOCK_LABEL_180;
		ExeSQL execSQL = new ExeSQL();
		String sql = (new StringBuilder("select agentcode,agentstate from laagent a where exists(select 1 from lnpcont b where a.managecom=b.signcom and b.contno='")).append(ContNo).append("') and a.agentcode='").append(tAgentCode).append("'").toString();
		System.out.println((new StringBuilder("sql-->")).append(sql).toString());
		SSRS ssrs = execSQL.execSQL(sql);
		if (ssrs.getMaxRow() > 0)
		{
			AgentCode = ssrs.GetText(1, 1);
			return;
		}
		try
		{
			AgentCode = "";
			buildMsg((new StringBuilder("保单签署地所在“")).append(contBean.getSchema().getSignCom()).append("”分公司，“").append(tAgentCode).append("”代理人不存在，请确定后录入。").toString());
			return;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
	}

	private boolean saveQuesMsg(MMap map, boolean hasFlag, BankLNPContBean contBean, List appntAnswers, List insurAnswers, String curDate, String curTime)
	{
		boolean flag = true;
		if (!validate("ques"))
			return false;
		try
		{
			SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
			String resultId = maxNoMap.CreateMaxNo("ImpReslutId", "");
			LNPCustImpResultSet rstSet = new LNPCustImpResultSet();
			BankLNPCustImpQueBean rstBean = new BankLNPCustImpQueBean();
			for (int i = 0; i < appntAnswers.size(); i++)
			{
				LNPCustImpResultSchema rstSchema = new LNPCustImpResultSchema();
				rstBean = (BankLNPCustImpQueBean)appntAnswers.get(i);
				rstSchema.setImpartId(rstBean.getAppntQues().getImpartId());
				rstSchema.setResultId(resultId);
				rstSchema.setContNo(contBean.getSchema().getContNo());
				rstSchema.setQuestionId(rstBean.getAppntQues().getQuestionid());
				rstSchema.setCustomerNo("appnt");
				rstSchema.setCustomerId(contBean.getSchema().getAppntId());
				rstSchema.setQuestionType(rstBean.getAppntQues().getQuestionType());
				if ("2".equals(rstSchema.getQuestionType()))
					rstSchema.setAnswer(rstBean.getAppntanswer());
				else
					rstSchema.setOptionId(rstBean.getAppntanswer());
				rstSchema.setOperator(GI.Operator);
				rstSchema.setManageCom(GI.ManageCom);
				rstSchema.setMakeDate(curDate);
				rstSchema.setMakeTime(curTime);
				rstSchema.setModifyDate(curDate);
				rstSchema.setModifyTime(curTime);
				rstSet.add(rstSchema);
			}

			resultId = maxNoMap.CreateMaxNo("ImpReslutId", "");
			for (int i = 0; i < insurAnswers.size(); i++)
			{
				LNPCustImpResultSchema rstSchema = new LNPCustImpResultSchema();
				rstBean = (BankLNPCustImpQueBean)insurAnswers.get(i);
				rstSchema.setImpartId(rstBean.getInsurQues().getImpartId());
				rstSchema.setResultId(resultId);
				rstSchema.setContNo(contBean.getSchema().getContNo());
				rstSchema.setQuestionId(rstBean.getInsurQues().getQuestionid());
				rstSchema.setCustomerNo("insur");
				rstSchema.setCustomerId(contBean.getSchema().getInsuredId());
				rstSchema.setQuestionType(rstBean.getInsurQues().getQuestionType());
				if ("2".equals(rstSchema.getQuestionType()))
					rstSchema.setAnswer(rstBean.getInsuranswer());
				else
					rstSchema.setOptionId(rstBean.getInsuranswer());
				rstSchema.setOperator(GI.Operator);
				rstSchema.setManageCom(GI.ManageCom);
				rstSchema.setMakeDate(curDate);
				rstSchema.setMakeTime(curTime);
				rstSchema.setModifyDate(curDate);
				rstSchema.setModifyTime(curTime);
				rstSet.add(rstSchema);
			}

			LNPCustImpResultDB db = new LNPCustImpResultDB();
			String sql = (new StringBuilder("select * from LNPCustImpResult where contno='")).append(contBean.getSchema().getContNo()).append("'").toString();
			LNPCustImpResultSet bSet = db.executeQuery(sql);
			System.out.println((new StringBuilder(String.valueOf(bSet.size()))).append("-------size==44? ok:no").toString());
			map.put(bSet, "DELETE");
			map.put(rstSet, "INSERT");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		return flag;
	}

	private boolean savePaymentMsg(MMap map, boolean hasFlag, BankLNPContBean contBean, BankLNPPaymentBean paymentBean, String curDate, String curTime)
	{
		boolean flag = true;
		if (!validate("pay"))
			return false;
		try
		{
			paymentBean.getSchema().setContNo(contBean.getSchema().getContNo());
			paymentBean.getSchema().setAppntID(contBean.getSchema().getAppntId());
			paymentBean.getSchema().setInusredID(contBean.getSchema().getInsuredId());
			paymentBean.getSchema().setPayMent1(FirPayType);
			paymentBean.getSchema().setPayMent2(EscPayType);
			paymentBean.getSchema().setBankCode(AuthBank);
			paymentBean.getSchema().setAccount(AuthACount);
			contBean.getSchema().setBankCode(paymentBean.getSchema().getBankCode());
			paymentBean.getSchema().setOperator(GI.Operator);
			if (hasFlag)
			{
				paymentBean.getSchema().setModifyDate(curDate);
				paymentBean.getSchema().setModifyTime(curTime);
				map.put(paymentBean.getSchema(), "UPDATE");
			} else
			{
				paymentBean.getSchema().setMakeDate(curDate);
				paymentBean.getSchema().setMakeTime(curTime);
				paymentBean.getSchema().setModifyDate(curDate);
				paymentBean.getSchema().setModifyTime(curTime);
				map.put(paymentBean.getSchema(), "INSERT");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		return flag;
	}

	private boolean saveAgentInfMsg(MMap map, boolean hasFlag, BankLNPContBean contBean, BankLNPAgentInfoBean agentInfBean, String curDate, String curTime)
	{
		boolean flag = true;
		if (!validate("agent"))
			return false;
		try
		{
			agentInfBean.getSchema().setContNo(contBean.getSchema().getContNo());
			agentInfBean.getSchema().setProposalContNo(contBean.getSchema().getContNo());
			agentInfBean.getSchema().setAgentOrder("1");
			if (SignDate != null && !"".equals(SignDate.trim()))
			{
				contBean.getSchema().setPSignDate(SignDate);
				if (!turnNullToString(contBean.getSchema().getPValiDate()).equals(contBean.getSchema().getPSignDate()))
				{
					System.out.println("签署日变动，同步生效日，以及投、被保人年龄信息");
					contBean.getSchema().setPValiDate(SignDate);
				}
				System.out.println((new StringBuilder(String.valueOf(SignDate))).append("===save=====").append(contBean.getSchema().getPSignDate()).toString());
			}
			agentInfBean.getSchema().setP4(SignDate);
			agentInfBean.getSchema().setP1(TargetDate);
			agentInfBean.getSchema().setP3(AgentTrantype);
			agentInfBean.getSchema().setP2(AgentBranchattr);
			agentInfBean.getSchema().setPolPrintType(PolPrintType);
			agentInfBean.getSchema().setAgentCode(AgentCode);
			agentInfBean.getSchema().setBranchAttr(getBranchAttrByAgentCode(AgentCode));
			agentInfBean.getSchema().setOperator(GI.Operator);
			if (hasFlag)
			{
				agentInfBean.getSchema().setModifyDate(curDate);
				agentInfBean.getSchema().setModifyTime(curTime);
				map.put(agentInfBean.getSchema(), "UPDATE");
			} else
			{
				agentInfBean.getSchema().setMakeDate(curDate);
				agentInfBean.getSchema().setMakeTime(curTime);
				agentInfBean.getSchema().setModifyDate(curDate);
				agentInfBean.getSchema().setModifyTime(curTime);
				map.put(agentInfBean.getSchema(), "INSERT");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		return flag;
	}

	private boolean getInfoFromSession()
	{
		boolean flag = false;
		HttpSession session = null;
		try
		{
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			GI = (IGlobalInput)session.getAttribute("NPGI");
			if ((String)session.getAttribute("ContNo") != null && !((String)session.getAttribute("ContNo")).equals(""))
			{
				ContNo = (String)session.getAttribute("ContNo");
				waitPolicyCommited(session, ContNo);
				turnCurrPolicyLockFlag(session, ContNo, "lock");
				flag = true;
			}
		}
		catch (Exception e)
		{
			turnCurrPolicyLockFlag(session, ContNo, "unlock");
			flag = false;
			buildMsg(e.getMessage());
		}
		return flag;
	}

	private void initPaymentNotiMsg(BankLNPContBean contBean, BankLNPPaymentBean paymentBean)
	{
		FirPayType = paymentBean.getSchema().getPayMent1();
		EscPayType = paymentBean.getSchema().getPayMent2();
		ACounter = contBean.getSchema().getAppntName();
		AuthBank = paymentBean.getSchema().getBankCode();
		AuthACount = getDecryptAccount(contBean.getSchema().getContNo());
	}

	private void initAgenNotiMsg(BankLNPContBean contBean, BankLNPAgentInfoBean agentInfoBean)
	{
		SignDate = formatDate(turnNullToString(agentInfoBean.getSchema().getP4()), "YYYYMMDD");
		System.out.println((new StringBuilder(String.valueOf(SignDate))).append("===init=====").append(agentInfoBean.getSchema().getP4()).toString());
		TargetDate = agentInfoBean.getSchema().getP1();
		AgentTrantype = agentInfoBean.getSchema().getP3();
		AgentBranchattr = agentInfoBean.getSchema().getP2();
		AgentBranchattrNm = AgentBranchattr == null ? "" : getAgentCom(AgentBranchattr);
		System.out.println((new StringBuilder(String.valueOf(AgentBranchattr))).append("<_-init--- >").append(AgentBranchattrNm).toString());
		AgentCode = agentInfoBean.getSchema().getAgentCode();
		PolPrintType = agentInfoBean.getSchema().getPolPrintType();
	}

	private void initQuestionList()
	{
		try
		{
			LNPCustImpQueDB db = new LNPCustImpQueDB();
			Appntanswers.clear();
			Insuranswers.clear();
			String appntSql = "";
			String insurSql = "";
			getSaleChannelCode(ContNo);
			if ("AGY".equals(saleChannelCode))
			{
				appntSql = "select * from LNPCustImpQue where impartid='0201' and (content1 like 'C%' or content1 like 'D%') order by impartid,queorder";
				insurSql = "select * from LNPCustImpQue where impartid='0201' and content1 not like 'C%' and content1 not like 'D%' order by impartid,queorder";
			} else
			if ("TM".equals(saleChannelCode))
				insurSql = "select * from LNPCustImpQue where impartid='0301' order by impartid,queorder";
			if (saleChannelCode == null || "".equals(saleChannelCode) || "null".equals(saleChannelCode) || "BXS".equals(saleChannelCode))
			{
				appntSql = "select * from LNPCustImpQue where impartid='0101' and questionid not in('0101240023','0101250024','0101260025') order by impartid,queorder";
				insurSql = "select * from LNPCustImpQue where impartid='0101' order by impartid,queorder";
			}
			LNPCustImpQueSet set = db.executeQuery(appntSql);
			for (int i = 1; i <= set.size(); i++)
			{
				BankLNPCustImpQueBean custImpQueBean = new BankLNPCustImpQueBean();
				LNPCustImpQueSchema tSchema = set.get(i);
				custImpQueBean.setAppntQues(tSchema);
				Appntanswers.add(custImpQueBean);
			}

			set = db.executeQuery(insurSql);
			for (int i = 1; i <= set.size(); i++)
			{
				BankLNPCustImpQueBean custImpQueBean = new BankLNPCustImpQueBean();
				LNPCustImpQueSchema tSchema = set.get(i);
				custImpQueBean.setInsurQues(tSchema);
				Insuranswers.add(custImpQueBean);
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private String getBranchAttrByAgentCode(String AgentCode)
	{
		String branchAttr = "";
		ExeSQL exeSQL = new ExeSQL();
		String sql = (new StringBuilder("select branchattr from labranchgroup a where exists(select 1 from latree b where a.agentgroup=b.agentgroup and b.agentcode='")).append(AgentCode).append("')").toString();
		branchAttr = exeSQL.getOneValue(sql);
		return branchAttr;
	}

	private boolean validate(String vflag)
	{
		boolean flag = true;
		if ("ques".equals(vflag))
			quesComplete = true;
		else
		if ("agent".equals(vflag))
		{
			agentInfComplete = true;
			if (FirPayType == null || "".equals(FirPayType.trim()))
				agentInfComplete = false;
		} else
		if ("pay".equals(vflag))
		{
			paymentComplete = true;
			if (saleChannelCode.equals("BXS") && (AgentCode == null || "".equals(AgentCode.trim())))
				paymentComplete = false;
		}
		return flag;
	}

	private BankLNPContBean recOneContInfo(String contNo)
	{
		BankLNPContBean bean = new BankLNPContBean();
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema tSchema = mainInfo.getContByContNo(contNo);
		if (tSchema != null)
			bean.setSchema(tSchema);
		return bean;
	}

	private boolean isExistQues(String contNo)
	{
		boolean flag = false;
		try
		{
			LNPCustImpResultDB db = new LNPCustImpResultDB();
			db.setContNo(contNo);
			LNPCustImpResultSet set = db.query();
			if (set.size() > 0)
			{
				for (int i = 1; i <= set.size(); i++)
				{
					LNPCustImpResultSchema rstSchema = set.get(i);
					boolean isFind = false;
					for (int j = 0; j < Appntanswers.size(); j++)
					{
						LNPCustImpQueSchema queSchema = ((BankLNPCustImpQueBean)Appntanswers.get(j)).getAppntQues();
						if (queSchema.getQuestionid().indexOf(rstSchema.getQuestionId()) < 0 || !"appnt".equals(rstSchema.getCustomerNo()))
							continue;
						if (queSchema.getQuestionType().equals("2"))
							((BankLNPCustImpQueBean)Appntanswers.get(j)).setAppntanswer(rstSchema.getAnswer());
						else
							((BankLNPCustImpQueBean)Appntanswers.get(j)).setAppntanswer(rstSchema.getOptionId());
						isFind = true;
						break;
					}

					if (!isFind)
					{
						for (int k = 0; k < Insuranswers.size(); k++)
						{
							LNPCustImpQueSchema queSchema = ((BankLNPCustImpQueBean)Insuranswers.get(k)).getInsurQues();
							if (queSchema.getQuestionid().indexOf(rstSchema.getQuestionId()) < 0 || !"insur".equals(rstSchema.getCustomerNo()))
								continue;
							if (queSchema.getQuestionType().equals("2"))
								((BankLNPCustImpQueBean)Insuranswers.get(k)).setInsuranswer(rstSchema.getAnswer());
							else
								((BankLNPCustImpQueBean)Insuranswers.get(k)).setInsuranswer(rstSchema.getOptionId());
							break;
						}

					}
				}

				flag = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		return flag;
	}

	private boolean recAllQuesAnswer(String contNo)
	{
		boolean flag = false;
		try
		{
			AppntanswersBackup.clear();
			InsuranswersBackup.clear();
			LNPCustImpResultDB db = new LNPCustImpResultDB();
			String sql = (new StringBuilder("select * from LNPCustImpResult where impartid='0101' and CustomerNo='appnt' and contno='")).append(contNo).append("'").toString();
			LNPCustImpResultSet set = db.executeQuery(sql);
			for (int i = 1; i <= set.size(); i++)
			{
				BankLNPCustImpResultBean custImpRstBean = new BankLNPCustImpResultBean();
				LNPCustImpResultSchema tSchema = set.get(i);
				custImpRstBean.setSchema(tSchema);
				AppntanswersBackup.add(custImpRstBean);
			}

			sql = (new StringBuilder("select * from LNPCustImpResult where impartid='0101' and CustomerNo='insur' and contno='")).append(contNo).append("'").toString();
			set = db.executeQuery(sql);
			for (int i = 1; i <= set.size(); i++)
			{
				BankLNPCustImpResultBean custImpRstBean = new BankLNPCustImpResultBean();
				LNPCustImpResultSchema tSchema = set.get(i);
				custImpRstBean.setSchema(tSchema);
				InsuranswersBackup.add(custImpRstBean);
			}

			flag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		return flag;
	}

	private boolean isExistAgentInf(String contNo)
	{
		boolean flag = false;
		agentInfoBean = new BankLNPAgentInfoBean();
		LNPAgentInfoDB db = new LNPAgentInfoDB();
		db.setContNo(contNo);
		LNPAgentInfoSet set = db.query();
		if (set.size() > 0)
		{
			agentInfoBean.setSchema(set.get(1));
			flag = true;
		}
		return flag;
	}

	private BankLNPAgentInfoBean recAgentInfo(String contNo)
	{
		BankLNPAgentInfoBean bean = new BankLNPAgentInfoBean();
		LNPAgentInfoDB db = new LNPAgentInfoDB();
		db.setContNo(contNo);
		LNPAgentInfoSet set = db.query();
		if (set.size() > 0)
			bean.setSchema(set.get(1));
		return bean;
	}

	private boolean isExistPayment(String contNo)
	{
		boolean flag = false;
		paymentBean = new BankLNPPaymentBean();
		LNPPaymentDB db = new LNPPaymentDB();
		db.setContNo(contNo);
		LNPPaymentSet set = db.query();
		if (set.size() > 0)
		{
			paymentBean.setSchema(set.get(1));
			flag = true;
		}
		return flag;
	}

	private BankLNPPaymentBean recPaymentInfo(String contNo)
	{
		BankLNPPaymentBean bean = new BankLNPPaymentBean();
		LNPPaymentDB db = new LNPPaymentDB();
		db.setContNo(contNo);
		LNPPaymentSet set = db.query();
		if (set.size() > 0)
			bean.setSchema(set.get(1));
		return bean;
	}

	private void buildMsg(String msg)
	{
		alertFlag = true;
		message = msg;
		String Path = java/lang/Class.getClass().getName();
		String Result = (new StringBuilder("--->path: ")).append(Path).append(";").append(message).toString();
		if (Errors.size() > 20)
			Errors = new ArrayList();
		Errors.add(Result);
	}

	private void reportMsg()
	{
		for (int i = 0; i < Errors.size(); i++)
			System.out.println((new StringBuilder("index_")).append(i).append(":").append((String)Errors.get(i)).toString());

		Errors.clear();
	}

	private static void initBrchAttrNmMap()
	{
		brchAttrNmMap.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select agentcom,name from lacom";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			brchAttrNmMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	private String getAgentCom(String code)
	{
		System.out.println((new StringBuilder("----")).append(code).toString());
		if (!turnNullToString(code).equals("") && !brchAttrNmMap.containsKey(code))
		{
			System.out.println("~~~~~~~~~~~~~~~~~~~because agentcom is not exists,so init");
			initBrchAttrNmMap();
		}
		return (String)brchAttrNmMap.get(code);
		Exception exception;
		exception;
		return "";
	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public BankLNPContBean getContBean()
	{
		return contBean;
	}

	public void setContBean(BankLNPContBean contBean)
	{
		this.contBean = contBean;
	}

	public boolean isAlertFlag()
	{
		return alertFlag;
	}

	public void setAlertFlag(boolean alertFlag)
	{
		this.alertFlag = alertFlag;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public List getAppntanswers()
	{
		return Appntanswers;
	}

	public void setAppntanswers(List appntanswers)
	{
		initQuestionList();
		Appntanswers = appntanswers;
	}

	public List getInsuranswers()
	{
		return Insuranswers;
	}

	public void setInsuranswers(List insuranswers)
	{
		Insuranswers = insuranswers;
	}

	public ArrayList getErrors()
	{
		return Errors;
	}

	public void setErrors(ArrayList errors)
	{
		Errors = errors;
	}

	public String getFirPayType()
	{
		return FirPayType;
	}

	public void setFirPayType(String firPayType)
	{
		FirPayType = firPayType;
	}

	public String getEscPayType()
	{
		return EscPayType;
	}

	public void setEscPayType(String escPayType)
	{
		EscPayType = escPayType;
	}

	public String getACounter()
	{
		return ACounter;
	}

	public void setACounter(String aCounter)
	{
		ACounter = aCounter;
	}

	public String getAuthBank()
	{
		return AuthBank;
	}

	public void setAuthBank(String authBank)
	{
		AuthBank = authBank;
	}

	public String getAuthACount()
	{
		return AuthACount;
	}

	public void setAuthACount(String authACount)
	{
		AuthACount = authACount;
	}

	public String getSignDate()
	{
		return SignDate;
	}

	public void setSignDate(String signDate)
	{
		SignDate = signDate;
	}

	public String getTargetDate()
	{
		return TargetDate;
	}

	public void setTargetDate(String targetDate)
	{
		TargetDate = targetDate;
	}

	public String getAgentTrantype()
	{
		return AgentTrantype;
	}

	public void setAgentTrantype(String agentTrantype)
	{
		AgentTrantype = agentTrantype;
	}

	public String getAgentBranchattr()
	{
		return AgentBranchattr;
	}

	public void setAgentBranchattr(String agentBranchattr)
	{
		AgentBranchattr = agentBranchattr;
	}

	public String getAgentBranchattrNm()
	{
		return AgentBranchattrNm;
	}

	public void setAgentBranchattrNm(String agentBranchattrNm)
	{
		AgentBranchattrNm = agentBranchattrNm;
	}

	public String getAgentCode()
	{
		return AgentCode;
	}

	public void setAgentCode(String agentCode)
	{
		AgentCode = agentCode;
	}

	public boolean isQuesHasFlag()
	{
		return quesHasFlag;
	}

	public void setQuesHasFlag(boolean quesHasFlag)
	{
		this.quesHasFlag = quesHasFlag;
	}

	public boolean isAgentInfHasFlag()
	{
		return agentInfHasFlag;
	}

	public void setAgentInfHasFlag(boolean agentInfHasFlag)
	{
		this.agentInfHasFlag = agentInfHasFlag;
	}

	public boolean isPaymentHasFlag()
	{
		return paymentHasFlag;
	}

	public void setPaymentHasFlag(boolean paymentHasFlag)
	{
		this.paymentHasFlag = paymentHasFlag;
	}

	public boolean isAllComplete()
	{
		return allComplete;
	}

	public void setAllComplete(boolean allComplete)
	{
		this.allComplete = allComplete;
	}

	public boolean isQuesComplete()
	{
		return quesComplete;
	}

	public void setQuesComplete(boolean quesComplete)
	{
		this.quesComplete = quesComplete;
	}

	public boolean isAgentInfComplete()
	{
		return agentInfComplete;
	}

	public void setAgentInfComplete(boolean agentInfComplete)
	{
		this.agentInfComplete = agentInfComplete;
	}

	public boolean isPaymentComplete()
	{
		return paymentComplete;
	}

	public void setPaymentComplete(boolean paymentComplete)
	{
		this.paymentComplete = paymentComplete;
	}

	public BankLNPPaymentBean getPaymentBean()
	{
		return paymentBean;
	}

	public void setPaymentBean(BankLNPPaymentBean paymentBean)
	{
		this.paymentBean = paymentBean;
	}

	public BankLNPAgentInfoBean getAgentInfoBean()
	{
		return agentInfoBean;
	}

	public void setAgentInfoBean(BankLNPAgentInfoBean agentInfoBean)
	{
		this.agentInfoBean = agentInfoBean;
	}

	public String getAppntIsAllSelc()
	{
		return AppntIsAllSelc;
	}

	public void setAppntIsAllSelc(String appntIsAllSelc)
	{
		AppntIsAllSelc = appntIsAllSelc;
	}

	public String getInsurIsAllSelc()
	{
		return InsurIsAllSelc;
	}

	public void setInsurIsAllSelc(String insurIsAllSelc)
	{
		InsurIsAllSelc = insurIsAllSelc;
	}

	public String getQuesType()
	{
		return quesType;
	}

	public void setQuesType(String quesType)
	{
		this.quesType = quesType;
	}

	public String getQuesVal()
	{
		return quesVal;
	}

	public void setQuesVal(String quesVal)
	{
		this.quesVal = quesVal;
	}

	public String getQuesId()
	{
		return quesId;
	}

	public void setQuesId(String quesId)
	{
		this.quesId = quesId;
	}

	public String getQuesText()
	{
		return quesText;
	}

	public void setQuesText(String quesText)
	{
		this.quesText = quesText;
	}

	public List getBankCodeList()
	{
		try
		{
			if (bankCodeList != null)
				bankCodeList.clear();
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			String ContNo = (String)session.getAttribute("ContNo");
			bankCodeList = getBankList(ContNo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bankCodeList;
	}

	private List getBankList(String contNo)
	{
		List reList = new ArrayList();
		try
		{
			ExeSQL tExeSQL = new ExeSQL();
			String sql = (new StringBuilder("select bankcode,bankname from mbank a where managecom <>'86' and exists(select 1 from lnpcont b where a.managecom=b.signcom and b.contno='")).append(contNo).append("') and branchtype='3' order by bankcode").toString();
			System.out.println((new StringBuilder("sql-->")).append(sql).toString());
			SSRS tSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSRS.MaxRow; i++)
				reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return reList;
	}

	public void setBankCodeList(List bankCodeList)
	{
		this.bankCodeList = bankCodeList;
	}

	public String getLimtType()
	{
		return limtType;
	}

	public void setLimtType(String limtType)
	{
		this.limtType = limtType;
	}

	private String formatDate(String srcDate, String formate)
	{
		String tDate = srcDate;
		if (srcDate != null && !"".equals(srcDate.trim()))
			if (formate.indexOf("-") > 0)
				tDate = (new StringBuilder(String.valueOf(srcDate.substring(0, 4)))).append("-").append(srcDate.substring(4, 6)).append("-").append(srcDate.substring(6, 8)).toString();
			else
				tDate = srcDate.replaceAll("-", "");
		return tDate;
	}

	public String gettSignDate()
	{
		return tSignDate;
	}

	public void settSignDate(String tSignDate)
	{
		this.tSignDate = tSignDate;
	}

	public String gettAgentCode()
	{
		return tAgentCode;
	}

	public void settAgentCode(String tAgentCode)
	{
		this.tAgentCode = tAgentCode;
	}

	public String getDecryptAccount(String contno)
	{
		String rStr = "";
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("OPEN SYMMETRIC KEY key_encryption DECRYPTION BY CERTIFICATE cert_keyProtection;  SELECT convert(nvarchar(500),DecryptByKey(account)) from lnppayment where contno='")).append(contno).append("' ").append(" CLOSE SYMMETRIC KEY key_encryption").toString();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
			rStr = tSSRS.GetText(1, 1);
		return rStr;
	}

	public String getSaleChannelCode()
	{
		return saleChannelCode;
	}

	public String getSaleChannelCode(String contno)
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String notiNum = (String)session.getAttribute("saleChannel");
		if (notiNum == null || "".equals(notiNum) || "-1".equals(notiNum))
		{
			notiNum = "";
			String mSql = (new StringBuilder("select uwtime from lnppol where contno='")).append(ContNo).append("'").toString();
			SSRS tSSRS = (new ExeSQL()).execSQL(mSql);
			if (tSSRS != null && tSSRS.getMaxRow() > 0)
				notiNum = tSSRS.GetText(1, 1);
		}
		saleChannelCode = notiNum;
		return notiNum;
	}

	public void setSaleChannelCode(String saleChannelCode)
	{
		this.saleChannelCode = saleChannelCode;
	}

	public boolean getIsRiskBQ()
	{
		String sql = (new StringBuilder("select 1 from lnppol where contno='")).append(ContNo).append("' and riskcode='MR12BQ' ").toString();
		SSRS tSSRS = (new ExeSQL()).execSQL(sql);
		if (tSSRS != null && tSSRS.getMaxRow() > 0)
			isRiskBQ = true;
		return isRiskBQ;
	}

	public void setIsRiskBQ(boolean isRiskBQ)
	{
		this.isRiskBQ = isRiskBQ;
	}

	public boolean getIsRiskBR()
	{
		String sql = (new StringBuilder("select 1 from lnppol where contno='")).append(ContNo).append("' and riskcode='MR12BR' ").toString();
		SSRS tSSRS = (new ExeSQL()).execSQL(sql);
		if (tSSRS != null && tSSRS.getMaxRow() > 0)
			isRiskBR = true;
		return isRiskBR;
	}

	public void setIsRiskBR(boolean isRiskBR)
	{
		this.isRiskBR = isRiskBR;
	}

	static 
	{
		initBrchAttrNmMap();
	}
}
