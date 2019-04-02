// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankOperateDeal.java

package com.sinosoft.banklns.lnsmodel;

import com.mq.MqService;
import com.sinosoft.banklns.lis.BankBasicBL;
import com.sinosoft.banklns.lis.bean.BankLNPContBean;
import com.sinosoft.banklns.lis.db.LNPContDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.vschema.LNPContSet;
import com.sinosoft.banklns.lnsmodel.interfaces.AuraBean;
import com.sinosoft.banklns.lnsmodel.interfaces.CalPrem;
import com.sinosoft.banklns.lnsmodel.interfaces.CheckUser;
import com.sinosoft.banklns.lnsmodel.interfaces.FinalSubmissionBean;
import com.sinosoft.banklns.lnsmodel.interfaces.NPUWBean;
import com.sinosoft.banklns.lnsmodel.interfaces.XMLSaveThread;
import com.sinosoft.banklns.lnsmodel.webservice.NBConversion;
import com.sinosoft.banklns.utility.*;
import com.sinosoft.map.lis.db.MSysVarDB;
import com.sinosoft.map.lis.db.MUserDB;
import com.sinosoft.map.lis.schema.MSysVarSchema;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.jdom.Document;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			BankStateOperateDealNew, PolicyMainInfo, BankPolicyState, BankStateOperateDealIface, 
//			LNPContBean

public class BankOperateDeal extends BankBasicBL
{

	private String contNo;
	private String state;
	private String editState;
	private String lnpUserType;
	private boolean editFlag;
	private String sheetType;
	private boolean submitReviewFlag;
	private boolean calculateFlag;
	private boolean sendFlag;
	private boolean cancelFlag;
	private boolean resumeFlag;
	private boolean alertFlag;
	private String message;
	private String addPremFlag;
	private boolean uwURLShowFlag;
	private boolean uwURLFlag;
	private String uwurl;
	private boolean auraSuccFlag;
	private boolean auraErrorsShowFlag;
	private boolean calPremSuccFlag;
	private boolean calHtmlErrorShowFlag;
	private boolean checkUserSuccFlag;
	private boolean checkUserHtmlErrorShowFlag;
	private boolean underWriteSuccFlag;
	private boolean underWriteErrorShowFlag;
	private boolean submitSuccFlag;
	private boolean submitErrorShowFlag;
	private boolean insuDeclarationFlag;
	private boolean insuDeclarationFlag2;
	private ArrayList Errors;
	private static Map stateMap = new Hashtable();
	private BankLNPContBean contBean;
	private IGlobalInput GI;
	private BankStateOperateDealIface stateOperateDeal;
	private BankPolicyState policyState;

	public BankOperateDeal()
	{
		Errors = new ArrayList();
		contBean = new BankLNPContBean();
		GI = new IGlobalInput();
	}

	public static void main(String args[])
	{
		BankOperateDeal operateDeal = new BankOperateDeal();
		String rst = "";
		rst = (new StringBuilder(String.valueOf(rst))).append(operateDeal.detailErMsg("110100")).toString();
		operateDeal.send();
		System.out.println(rst);
	}

	public void init()
	{
		System.out.println("------------------->按钮控制面板 start<-------------------");
		try
		{
			alertFlag = false;
			message = "";
			submitReviewFlag = false;
			calculateFlag = false;
			sendFlag = false;
			cancelFlag = false;
			resumeFlag = false;
			insuDeclarationFlag = false;
			insuDeclarationFlag2 = false;
			if (getInfoFromSession())
			{
				HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				stateOperateDeal = new BankStateOperateDealNew();
				if ("0".equals(lnpUserType) || "2".equals(lnpUserType))
					submitReviewFlag = isDisplay(state, editState, 1, lnpUserType, null);
				if ("1".equals(lnpUserType) || "2".equals(lnpUserType))
				{
					calculateFlag = isDisplay(state, editState, 2, lnpUserType, null);
					sendFlag = isDisplay(state, editState, 3, lnpUserType, null);
					cancelFlag = isDisplay(state, editState, 4, lnpUserType, null);
					resumeFlag = isDisplay(state, editState, 5, lnpUserType, null);
				}
				System.out.println((new StringBuilder("人员类型：“")).append(lnpUserType).append("”当前按钮操纵状态：").append(submitReviewFlag).append("|").append(calculateFlag).append("|").append(sendFlag).append("|").append(cancelFlag).append("|").append(resumeFlag).append("|state=").append(state).append("|editsate=").append(editState).toString());
			} else
			{
				buildMsg("投保书录入前台信息缺失了！");
				return;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg((new StringBuilder("投保书保按钮操作事件初始化失败，原因：")).append(e.getMessage()).toString());
		}
		reportMsg();
		System.out.println("------------------->按钮控制面板 end<-------------------");
	}

	public boolean getInfoFromSession()
	{
		boolean flag;
		System.out.println("----- getInfoFromSession-------------");
		flag = false;
		HttpSession session;
		session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		GI = (IGlobalInput)session.getAttribute("NPGI");
		if (GI != null)
		{
			lnpUserType = GI.LNPRole;
			break MISSING_BLOCK_LABEL_62;
		}
		return flag;
		try
		{
			contNo = (String)session.getAttribute("ContNo");
			if (contNo != null && !"".equals(contNo))
			{
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				LNPContSchema tSchema = mainInfo.getContByContNo(contNo);
				contBean.setSchema(tSchema);
				if (!"".equals(contBean.getSchema().getContNo()))
				{
					editState = contBean.getSchema().getEditstate();
					state = contBean.getSchema().getState();
				}
			}
			flag = true;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		return flag;
	}

	public boolean submitReview()
	{
		VData vData;
		MMap mMap;
		boolean flag;
		List tList;
		System.out.println("---------------------->提交审核 start<-----------------------");
		vData = new VData();
		mMap = new MMap();
		flag = false;
		tList = new ArrayList();
		boolean flag1;
		init();
		if (submitReviewFlag)
			break MISSING_BLOCK_LABEL_123;
		buildMsg((new StringBuilder("投保书当前")).append(detailErMsg(editState)).append("状态为：").append((String)stateMap.get(state)).append(" ,不能进行<提交审核>操作。").toString());
		flag1 = flag;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		return flag1;
		stateOperateDeal = new BankStateOperateDealNew();
		policyState = new BankPolicyState();
		Exception e;
		try
		{
			tList = stateOperateDeal.infoOprate(state, editState, "modify", "71");
			policyState.savePolicyState(contNo, (String)tList.get(0), "1", PubFun.getCurrentDate(), PubFun.getCurrentTime());
			flag = true;
		}
		// Misplaced declaration of an exception variable
		catch (Exception e)
		{
			tList = stateOperateDeal.infoOprate(state, editState, "modify", "70");
			throw new RuntimeException("后台报错信息：提交审核失败!");
		}
		break MISSING_BLOCK_LABEL_359;
		Exception exception;
		exception;
		contBean.getSchema().setState((String)tList.get(0));
		contBean.getSchema().setEditstate((String)tList.get(1));
		contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
		contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
		contBean.getSchema().setInputOperator(GI.Operator);
		mMap.put(contBean.getSchema(), "UPDATE");
		vData.add(mMap);
		saveAllMsg(vData);
		throw exception;
		contBean.getSchema().setState((String)tList.get(0));
		contBean.getSchema().setEditstate((String)tList.get(1));
		contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
		contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
		contBean.getSchema().setInputOperator(GI.Operator);
		mMap.put(contBean.getSchema(), "UPDATE");
		vData.add(mMap);
		saveAllMsg(vData);
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL((new StringBuilder("select appntbirthday from lnpappnt where contno='")).append(contNo).append("'").toString());
		if (tSSRS != null && tSSRS.getMaxRow() > 0)
		{
			int payYears = calPayYears();
			int appAge = calAppAge(tSSRS.GetText(1, 1));
			if (payYears + appAge >= 60)
				insuDeclarationFlag2 = true;
			else
				insuDeclarationFlag2 = false;
		}
		break MISSING_BLOCK_LABEL_642;
		tExeSQL;
		tExeSQL.printStackTrace();
		tList = stateOperateDeal.infoOprate(state, editState, "modify", "70");
		buildMsg(tExeSQL.getMessage());
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		break MISSING_BLOCK_LABEL_654;
		Exception exception1;
		exception1;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		throw exception1;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		System.out.println("---------------------->提交审核 end<-----------------------");
		return flag;
	}

	public boolean calculate()
	{
label0:
		{
			System.out.println("---------------------->计算保单 start<-----------------------");
			VData vData = new VData();
			MMap mMap = new MMap();
			boolean flag = true;
			boolean valiPassFlag = false;
			alertFlag = false;
			auraSuccFlag = true;
			calPremSuccFlag = true;
			checkUserSuccFlag = true;
			AuraBean tAuraBean = new AuraBean();
			CalPrem tCalPremBean = new CalPrem();
			CheckUser cu = new CheckUser();
			List tList = new ArrayList();
			RuntimeException e;
			Exception exception;
			boolean flag1;
			PolicyMainInfo mainInfo;
			LNPContBean contBean;
			ExeSQL tExeSQL;
			SSRS tSSRS;
			SSRS tSSRS2;
			String salary;
			String sPrem;
			double sumPrem;
			double appSalary;
			try
			{
				init();
				if (calculateFlag)
					break label0;
				buildMsg((new StringBuilder("投保书当前状态为：")).append((String)stateMap.get(state)).append(" ,不能进行<保费计算>操作。").toString());
			}
			// Misplaced declaration of an exception variable
			catch (RuntimeException e)
			{
				e.printStackTrace();
				tList = stateOperateDeal.infoOprate(state, editState, "modify", "80");
				buildMsg(e.getMessage());
				System.out.println("---------------------->计算保单 end<-----------------------");
				return flag;
			}
			return false;
		}
		stateOperateDeal = new BankStateOperateDealNew();
		policyState = new BankPolicyState();
		try
		{
			if (!tAuraBean.calInterfaces(contNo))
			{
				message = tAuraBean.getMessage();
				if (message == null || "".equals(message))
					message = "投保规则校验失败！";
				buildMsg(message);
				auraSuccFlag = flag = false;
			} else
			if (!tCalPremBean.calInterfaces(contNo))
			{
				message = tCalPremBean.getMessage();
				if (message == null || "".equals(message))
					message = "保费计算失败！";
				tCalPremBean.rollbakData();
				buildMsg(message);
				calPremSuccFlag = flag = false;
			} else
			if (!cu.calInterfaces(contNo))
			{
				message = cu.getMessage();
				if (message == null || "".equals(message))
					message = "客户相似度校验失败！";
				cu.rollbakData();
				buildMsg(message);
				checkUserSuccFlag = flag = false;
			}
			valiPassFlag = tCalPremBean.isValiPassFlag() && cu.isValiPassFlag() && tAuraBean.isValiPassFlag();
			System.out.println((new StringBuilder("-->校验成功标志:")).append(valiPassFlag).append("计算成功标志").append(flag).toString());
			if (flag)
				tList = stateOperateDeal.infoOprate(state, editState, "modify", "81");
			else
			if (valiPassFlag)
			{
				tList = stateOperateDeal.infoOprate(state, editState, "modify", "80");
			} else
			{
				tList.add(state);
				tList.add(editState);
			}
			if (valiPassFlag)
				policyState.savePolicyState(contNo, (String)tList.get(0), "1", PubFun.getCurrentDate(), PubFun.getCurrentTime(), message);
			flag1 = flag;
		}
		// Misplaced declaration of an exception variable
		catch (RuntimeException e)
		{
			tList = stateOperateDeal.infoOprate(state, editState, "modify", "80");
			throw new RuntimeException("后台报错信息：保单计算接口程序失败！");
		}
		finally
		{
			mainInfo = new PolicyMainInfo();
		}
		mainInfo = new PolicyMainInfo();
		contBean = new LNPContBean();
		contBean.setSchema(mainInfo.getContByContNo(contNo));
		contBean.getSchema().setState((String)tList.get(0));
		contBean.getSchema().setEditstate((String)tList.get(1));
		contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
		contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
		contBean.getSchema().setInputOperator(GI.Operator);
		mMap.put(contBean.getSchema(), "UPDATE");
		vData = new VData();
		vData.add(mMap);
		saveAllMsg(vData);
		tExeSQL = new ExeSQL();
		tSSRS = tExeSQL.execSQL((new StringBuilder("select salary from lnpappnt where contno='")).append(contNo).append("'").toString());
		tSSRS2 = tExeSQL.execSQL((new StringBuilder("select sum(prem) from lnppol where contno='")).append(contNo).append("' and payintv='5'").toString());
		if (tSSRS != null && tSSRS.getMaxRow() > 0 && tSSRS2 != null && tSSRS2.getMaxRow() > 0)
		{
			salary = tSSRS.GetText(1, 1);
			sPrem = tSSRS2.GetText(1, 1);
			if (salary != null && !"".equals(salary) && !"null".equals(salary) && sPrem != null && !"".equals(sPrem) && !"null".equals(sPrem))
			{
				sumPrem = Double.parseDouble(sPrem);
				appSalary = Double.parseDouble(salary);
				if (sumPrem > appSalary * 4D * 10000D)
					insuDeclarationFlag = true;
				else
					insuDeclarationFlag = false;
			}
		}
		return flag1;
		contBean = new LNPContBean();
		contBean.setSchema(mainInfo.getContByContNo(contNo));
		contBean.getSchema().setState((String)tList.get(0));
		contBean.getSchema().setEditstate((String)tList.get(1));
		contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
		contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
		contBean.getSchema().setInputOperator(GI.Operator);
		mMap.put(contBean.getSchema(), "UPDATE");
		vData = new VData();
		vData.add(mMap);
		saveAllMsg(vData);
		tExeSQL = new ExeSQL();
		tSSRS = tExeSQL.execSQL((new StringBuilder("select salary from lnpappnt where contno='")).append(contNo).append("'").toString());
		tSSRS2 = tExeSQL.execSQL((new StringBuilder("select sum(prem) from lnppol where contno='")).append(contNo).append("' and payintv='5'").toString());
		if (tSSRS != null && tSSRS.getMaxRow() > 0 && tSSRS2 != null && tSSRS2.getMaxRow() > 0)
		{
			salary = tSSRS.GetText(1, 1);
			sPrem = tSSRS2.GetText(1, 1);
			if (salary != null && !"".equals(salary) && !"null".equals(salary) && sPrem != null && !"".equals(sPrem) && !"null".equals(sPrem))
			{
				sumPrem = Double.parseDouble(sPrem);
				appSalary = Double.parseDouble(salary);
				if (sumPrem > appSalary * 4D * 10000D)
					insuDeclarationFlag = true;
				else
					insuDeclarationFlag = false;
			}
		}
		throw exception;
	}

	public boolean send()
	{
label0:
		{
			System.out.println("----------------------> 发送保单 start<-----------------------");
			VData vData = new VData();
			MMap mMap = new MMap();
			boolean flag = true;
			boolean valiPassFlag = false;
			alertFlag = false;
			underWriteSuccFlag = true;
			submitSuccFlag = true;
			List tList = new ArrayList();
			NPUWBean tNPUWBean = new NPUWBean();
			FinalSubmissionBean submitBean = new FinalSubmissionBean();
			boolean mqPreFlag;
			RuntimeException e;
			FinalSubmissionBean fb;
			boolean mqFlag;
			String msg;
			String conversionXML;
			MqService m;
			Exception exception;
			boolean flag1;
			PolicyMainInfo mainInfo;
			LNPContBean contBean;
			try
			{
				init();
				if (sendFlag)
					break label0;
				buildMsg((new StringBuilder("投保书当前状态为：")).append((String)stateMap.get(state)).append(" ,不能进行<保单发送>操作。").toString());
			}
			// Misplaced declaration of an exception variable
			catch (RuntimeException e)
			{
				e.printStackTrace();
				tList = stateOperateDeal.infoOprate(state, editState, "modify", "90");
				buildMsg(e.getMessage());
				System.out.println("---------------------->发送保单 end<-----------------------");
				return flag;
			}
			return false;
		}
		stateOperateDeal = new BankStateOperateDealNew();
		policyState = new BankPolicyState();
		try
		{
			mqPreFlag = false;
			if (NBFlag() && agentFlag())
			{
				fb = new FinalSubmissionBean();
				fb.initObject();
				mqPreFlag = fb.getInputData(contNo);
				mqPreFlag = mqPreFlag && fb.dealSend();
				mqFlag = false;
				msg = "";
				if (mqPreFlag)
				{
					saveXML(contNo, fb.doc, "issue_in");
					conversionXML = (new NBConversion()).ConversionXML("issue_out", fb.doc);
					System.out.println(conversionXML);
					m = new MqService();
					mqFlag = m.sendMsg(conversionXML);
					System.out.println(mqFlag);
				}
				if (!mqFlag)
				{
					message = msg;
					if (message == null || "".equals(message))
						message = "发送保单失败！";
					buildMsg(message);
					submitSuccFlag = flag = false;
				}
				valiPassFlag = mqFlag;
			} else
			{
				if (!submitBean.calInterfaces(contNo))
				{
					message = submitBean.getMessage();
					if (message == null || "".equals(message))
						message = "发送保单失败！";
					submitBean.rollbakData();
					buildMsg(message);
					submitSuccFlag = flag = false;
				}
				valiPassFlag = submitBean.isValiPassFlag();
			}
			System.out.println((new StringBuilder("-->校验成功标志:")).append(valiPassFlag).append("计算成功标志").append(flag).toString());
			if (flag)
				tList = stateOperateDeal.infoOprate(state, editState, "modify", "91");
			else
			if (valiPassFlag)
			{
				tList = stateOperateDeal.infoOprate(state, editState, "modify", "90");
			} else
			{
				tList.add(state);
				tList.add(editState);
			}
			if (valiPassFlag)
				policyState.savePolicyState(contNo, (String)tList.get(0), "1", PubFun.getCurrentDate(), PubFun.getCurrentTime(), message);
			flag1 = flag;
		}
		// Misplaced declaration of an exception variable
		catch (RuntimeException e)
		{
			tList = stateOperateDeal.infoOprate(state, editState, "modify", "90");
			throw new RuntimeException("后台报错信息：保单发送接口程序失败!");
		}
		finally
		{
			mainInfo = new PolicyMainInfo();
		}
		mainInfo = new PolicyMainInfo();
		contBean = new LNPContBean();
		contBean.setSchema(mainInfo.getContByContNo(contNo));
		contBean.getSchema().setState((String)tList.get(0));
		contBean.getSchema().setEditstate((String)tList.get(1));
		contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
		contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
		contBean.getSchema().setInputOperator(GI.Operator);
		mMap.put(contBean.getSchema(), "UPDATE");
		vData = new VData();
		vData.add(mMap);
		saveAllMsg(vData);
		return flag1;
		contBean = new LNPContBean();
		contBean.setSchema(mainInfo.getContByContNo(contNo));
		contBean.getSchema().setState((String)tList.get(0));
		contBean.getSchema().setEditstate((String)tList.get(1));
		contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
		contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
		contBean.getSchema().setInputOperator(GI.Operator);
		mMap.put(contBean.getSchema(), "UPDATE");
		vData = new VData();
		vData.add(mMap);
		saveAllMsg(vData);
		throw exception;
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

	public boolean cancel()
	{
		VData vData;
		MMap mMap;
		boolean flag;
		System.out.println("----------------------> 撤销保单 start<-----------------------");
		vData = new VData();
		mMap = new MMap();
		flag = false;
		init();
		if (cancelFlag)
			break MISSING_BLOCK_LABEL_81;
		buildMsg((new StringBuilder("投保书当前状态为：")).append((String)stateMap.get(state)).append(" ,不能进行<撤销保单>操作。").toString());
		return flag;
		try
		{
			stateOperateDeal = new BankStateOperateDealNew();
			policyState = new BankPolicyState();
			List tList = new ArrayList();
			try
			{
				stateOperateDeal = new BankStateOperateDealNew();
				tList = stateOperateDeal.infoOprate(state, editState, "delete", "A11");
				contBean.getSchema().setState((String)tList.get(0));
				contBean.getSchema().setEditstate((String)tList.get(1));
				contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
				contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
				contBean.getSchema().setInputOperator(GI.Operator);
				mMap.put(contBean.getSchema(), "UPDATE");
				vData.add(mMap);
				saveAllMsg(vData);
				policyState.savePolicyState(contNo, (String)tList.get(0), "1", PubFun.getCurrentDate(), PubFun.getCurrentTime());
				flag = true;
			}
			catch (RuntimeException e)
			{
				throw new RuntimeException("后台报错信息：撤销保单失败!");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		System.out.println("---------------------->撤销保单 end<-----------------------");
		return flag;
	}

	public boolean resume()
	{
		VData vData;
		MMap mMap;
		boolean flag;
		System.out.println("---------------------->恢复撤销保单 start<-----------------------");
		vData = new VData();
		mMap = new MMap();
		flag = false;
		init();
		if (resumeFlag)
			break MISSING_BLOCK_LABEL_81;
		buildMsg((new StringBuilder("投保书当前状态为：")).append((String)stateMap.get(state)).append(" ,不能进行<恢复撤销>操作。").toString());
		return flag;
		try
		{
			stateOperateDeal = new BankStateOperateDealNew();
			policyState = new BankPolicyState();
			List tList = new ArrayList();
			try
			{
				stateOperateDeal = new BankStateOperateDealNew();
				tList = stateOperateDeal.infoOprate(state, editState, "delete", "A10");
				contBean.getSchema().setState((String)tList.get(0));
				contBean.getSchema().setEditstate((String)tList.get(1));
				contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
				contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
				contBean.getSchema().setInputOperator(GI.Operator);
				mMap.put(contBean.getSchema(), "UPDATE");
				vData.add(mMap);
				saveAllMsg(vData);
				HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				Boolean tQueyEditFlag = (Boolean)session.getAttribute("Queryflag");
				session.setAttribute("Queryflag", Boolean.valueOf(true));
				policyState.savePolicyState(contNo, (String)tList.get(0), "1", PubFun.getCurrentDate(), PubFun.getCurrentTime());
				flag = true;
			}
			catch (Exception e)
			{
				throw new RuntimeException("后台报错信息：恢复撤销保单失败!");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		System.out.println("---------------------->恢复撤销保单 end<-----------------------");
		return flag;
	}

	private void saveAllMsg(VData cInputData)
		throws Exception
	{
		try
		{
			PubSubmit pubSubmit = new PubSubmit();
			pubSubmit.submitData(cInputData, "");
		}
		catch (Exception e)
		{
			throw e;
		}
		break MISSING_BLOCK_LABEL_46;
		Exception exception;
		exception;
		System.out.println("-----------OperDeal button is unlocked--------------");
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		throw exception;
		System.out.println("-----------OperDeal button is unlocked--------------");
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		return;
	}

	public List infoOprate(String state, String editState, String operateType, String infoType)
	{
		alertFlag = false;
		message = "";
		List list = new ArrayList();
		list.add(state);
		list.add(editState);
		try
		{
			stateOperateDeal = new BankStateOperateDealNew();
			list = stateOperateDeal.infoOprate(state, editState, operateType, infoType);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		return list;
	}

	public boolean isDisplay(String state, String editState, int buttonType, String userType, String contNo)
	{
		alertFlag = false;
		message = "";
		boolean flag = false;
		try
		{
			stateOperateDeal = new BankStateOperateDealNew();
			flag = stateOperateDeal.checkButtonOperate(state, editState, buttonType, userType, contNo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
			flag = false;
		}
		return flag;
	}

	public boolean isEidtSheet(String state, String sheetType, String userType, String contNo)
	{
		alertFlag = false;
		message = "";
		boolean flag = false;
		try
		{
			stateOperateDeal = new BankStateOperateDealNew();
			flag = stateOperateDeal.checkEditOperate(state, sheetType, userType, contNo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
			flag = false;
		}
		return flag;
	}

	public List changeMsgToModify(String state, String editState, String userType)
	{
		alertFlag = false;
		message = "";
		List list = new ArrayList();
		try
		{
			System.out.println((new StringBuilder("是否会回滚保单状态判断-->当前保单状态state :")).append(state).append("|代理人权限类型userType:").append(userType).toString());
			if (!"01".equals(state) && !"02".equals(state) && !"05".equals(state) && !"06".equals(state))
				list = modifyInfoOperate(state, editState, userType);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildMsg(e.getMessage());
		}
		return list;
	}

	private List modifyInfoOperate(String state, String editState, String userType)
	{
		String tState = state;
		String tEditState = "";
		List arrays = new ArrayList();
		String editStateArray[] = new String[editState.length()];
		for (int i = 0; i < editState.length(); i++)
			editStateArray[i] = editState.substring(i, i + 1);

		if ("1".equals(userType) || "2".equals(userType))
		{
			tState = editState.matches("^[1]{4}\\d{6}$") ? "02" : state;
			editStateArray[7] = "0";
			editStateArray[8] = "0";
			editStateArray[9] = "0";
		}
		for (int i = 0; i < editStateArray.length; i++)
			tEditState = (new StringBuilder(String.valueOf(tEditState))).append(editStateArray[i]).toString();

		arrays.add(tState);
		arrays.add(tEditState);
		return arrays;
	}

	public String updateEditStateDone(String editState, int idx)
	{
		if (idx > 4)
		{
			System.out.println("BXS只能指定修改前4项内容基础信息--告知及授权");
			return editState;
		} else
		{
			stateOperateDeal = new BankStateOperateDealNew();
			return stateOperateDeal.updateEditStateDone(editState, idx);
		}
	}

	public String updateEditStateUNDone(String editState, int idx)
	{
		if (idx > 4)
		{
			System.out.println("BXS只能指定修改前4项内容基础信息--告知及授权");
			return editState;
		} else
		{
			stateOperateDeal = new BankStateOperateDealNew();
			return stateOperateDeal.updateEditStateUNDone(editState, idx);
		}
	}

	private String detailErMsg(String editState)
	{
		String rst = "";
		if (editState != null && !editState.trim().equals(""))
		{
			String editStateArray[] = new String[editState.length()];
			for (int i = 0; i < editState.length(); i++)
				editStateArray[i] = editState.substring(i, i + 1);

			boolean flag = false;
			if (!"1".equals(editStateArray[0]))
			{
				rst = (new StringBuilder(String.valueOf(rst))).append("基础信息、").toString();
				flag = true;
			}
			if (!"1".equals(editStateArray[1]))
			{
				rst = (new StringBuilder(String.valueOf(rst))).append("投保事项、").toString();
				flag = true;
			}
			if (!"1".equals(editStateArray[2]))
			{
				rst = (new StringBuilder(String.valueOf(rst))).append("客户信息、").toString();
				flag = true;
			}
			if (!"1".equals(editStateArray[3]))
			{
				rst = (new StringBuilder(String.valueOf(rst))).append("告知及授权、").toString();
				flag = true;
			}
			if (flag)
				rst = rst.substring(0, rst.length() - 1);
			rst = (new StringBuilder(String.valueOf(rst))).append("必录项信息尚未全部录入完毕,").toString();
		}
		return rst;
	}

	public List relInfoOperate(LNPContSchema contSchema, LNPContSchema newContSchema)
	{
		List list = new ArrayList();
		String newEditState = "";
		String editState = contSchema.getEditstate();
		String neweditState = newContSchema.getEditstate();
		String editStateArray[] = new String[editState.length()];
		String neweditStateArray[] = new String[neweditState.length()];
		for (int i = 0; i < editState.length(); i++)
		{
			editStateArray[i] = editState.substring(i, i + 1);
			neweditStateArray[i] = neweditState.substring(i, i + 1);
		}

		neweditStateArray[2] = editStateArray[2];
		neweditStateArray[3] = editStateArray[3];
		neweditStateArray[7] = "0";
		neweditStateArray[8] = "0";
		neweditStateArray[9] = "0";
		if (!"05".equals(contSchema.getState()) && !"06".equals(contSchema.getState()))
			if ("01".equals(contSchema.getState()))
			{
				neweditStateArray[6] = "0";
				list.add("01");
			} else
			if (!"01".equals(newContSchema.getState()))
			{
				neweditStateArray[1] = "1";
				neweditStateArray[6] = "1";
				list.add("02");
			} else
			{
				neweditStateArray[6] = "0";
				list.add("01");
			}
		for (int j = 0; j < neweditState.length(); j++)
			newEditState = (new StringBuilder(String.valueOf(newEditState))).append(neweditStateArray[j]).toString();

		newContSchema.setEditstate(newEditState);
		list.add(newEditState);
		return list;
	}

	public void turnEditPolicy(HttpSession session, String contNo, boolean originFlag)
		throws Exception
	{
		if (session == null)
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if (contNo == null || "".equals(contNo))
			contNo = (String)session.getAttribute("ContNo");
		if ("LOCKED".equals(session.getAttribute("CONTLOCK")))
			try
			{
				System.out.println("######################################current policy edit is fixed after waitPolicyCommited######################################");
				if (originFlag)
					super.waitPolicyCommited(session, contNo);
				PubSubmit ps = new PubSubmit();
				LNPContSet tLNPContSet = new LNPContSet();
				LNPContSet dLNPContSet = new LNPContSet();
				LNPContDB tLNPContDB = new LNPContDB();
				tLNPContSet = tLNPContDB.executeQuery((new StringBuilder("select * from lnpcont where contno='")).append(contNo).append("'").toString());
				for (int i = 1; i <= tLNPContSet.size(); i++)
				{
					LNPContSchema tSchema = tLNPContSet.get(i).getSchema();
					tSchema.setAgentCode(null);
					System.out.println((new StringBuilder("##########current policy :")).append(tSchema.getContNo()).append("is prepare unlock! agentcode=").append(tSchema.getAgentCode()).toString());
					dLNPContSet.add(tSchema);
				}

				MMap mMap = new MMap();
				mMap.put(dLNPContSet, "UPDATE");
				VData cInputData = new VData();
				cInputData.add(mMap);
				if (ps.submitData(cInputData, ""))
				{
					System.out.println("##########解锁成功~");
					session.setAttribute("CONTLOCK", "UNLOCKED");
					super.turnCurrPolicyLockFlag(session, contNo, "unlock");
					System.out.println("######################################current policy is editdone######################################");
				}
			}
			catch (RuntimeException e)
			{
				throw new RuntimeException("policy edit fixed erro!! class：BankoperateDeal");
			}
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
			System.out.println((new StringBuilder("index_")).append(i).append(":").append(Errors.get(i)).toString());

	}

	private static void intiStateMap()
	{
		stateMap.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='lnpLangState' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			stateMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	private int calPayYears()
	{
		int payyears = 0;
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL((new StringBuilder("select payendyearflag,payendyear from lnppol where contno='")).append(contNo).append("'").toString());
		SSRS tSSRS2 = tExeSQL.execSQL((new StringBuilder("select appntage,appntagetype from lnpappnt where contno='")).append(contNo).append("'").toString());
		if (tSSRS != null && tSSRS.getMaxRow() > 0 && tSSRS2 != null && tSSRS2.getMaxRow() > 0)
		{
			int index = 0;
			for (int i = 1; i <= tSSRS.getMaxRow(); i++)
			{
				String payEndYearFlag = tSSRS.GetText(1, 1);
				if (tSSRS.GetText(1, 2) != null && !"".equals(tSSRS.GetText(1, 2)) && !"null".equals(tSSRS.GetText(1, 2)) && tSSRS2.GetText(1, 1) != null && !"".equals(tSSRS2.GetText(1, 1)) && !"null".equals(tSSRS2.GetText(1, 1)))
				{
					int payEndYear = Integer.parseInt(tSSRS.GetText(i, 2));
					int appAge = Integer.parseInt(tSSRS2.GetText(1, 1));
					String appAgeType = tSSRS2.GetText(1, 2);
					if (payEndYear == 1000)
						payEndYear = 0;
					if ("Y".equals(payEndYearFlag))
						index = payEndYear;
					else
					if ("A".equals(payEndYearFlag))
						if ("Y".equals(appAgeType))
							index = payEndYear - appAge;
						else
						if ("D".equals(appAgeType))
							index = payEndYear - 0;
				}
				if (index > payyears)
					payyears = index;
			}

		}
		return payyears;
	}

	private int calAppAge(String birthday)
	{
		int appage = 0;
		if (birthday == null || "".equals(birthday) || "null".equals(birthday))
			return appage;
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = fm.format(new Date());
		String iBirthday = birthday.substring(0, 10);
		String appAgeStr = LNPPubFun.getAgeByBirthdayNew(iBirthday, currentDate);
		if (appAgeStr.endsWith("（周岁）"))
		{
			int index = appAgeStr.indexOf("（周岁）");
			appage = Integer.parseInt(appAgeStr.substring(0, index));
		} else
		if (appAgeStr.endsWith("（天）"))
			appage = 0;
		else
			appage = 0;
		return appage;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getEditState()
	{
		return editState;
	}

	public void setEditState(String editState)
	{
		this.editState = editState;
	}

	public String getLnpUserType()
	{
		return lnpUserType;
	}

	public void setLnpUserType(String lnpUserType)
	{
		this.lnpUserType = lnpUserType;
	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public boolean isSubmitReviewFlag()
	{
		return submitReviewFlag;
	}

	public void setSubmitReviewFlag(boolean submitReviewFlag)
	{
		this.submitReviewFlag = submitReviewFlag;
	}

	public boolean isCalculateFlag()
	{
		return calculateFlag;
	}

	public void setCalculateFlag(boolean calculateFlag)
	{
		this.calculateFlag = calculateFlag;
	}

	public boolean isSendFlag()
	{
		return sendFlag;
	}

	public void setSendFlag(boolean sendFlag)
	{
		this.sendFlag = sendFlag;
	}

	public boolean isCancelFlag()
	{
		return cancelFlag;
	}

	public void setCancelFlag(boolean cancelFlag)
	{
		this.cancelFlag = cancelFlag;
	}

	public boolean isResumeFlag()
	{
		return resumeFlag;
	}

	public void setResumeFlag(boolean resumeFlag)
	{
		this.resumeFlag = resumeFlag;
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

	public String getAddPremFlag()
	{
		return addPremFlag;
	}

	public void setAddPremFlag(String addPremFlag)
	{
		this.addPremFlag = addPremFlag;
	}

	public boolean isUwURLShowFlag()
	{
		return uwURLShowFlag;
	}

	public void setUwURLShowFlag(boolean uwURLShowFlag)
	{
		this.uwURLShowFlag = uwURLShowFlag;
	}

	public boolean isUwURLFlag()
	{
		return uwURLFlag;
	}

	public void setUwURLFlag(boolean uwURLFlag)
	{
		this.uwURLFlag = uwURLFlag;
	}

	public String getUwurl()
	{
		return uwurl;
	}

	public void setUwurl(String uwurl)
	{
		this.uwurl = uwurl;
	}

	public boolean isAuraSuccFlag()
	{
		return auraSuccFlag;
	}

	public void setAuraSuccFlag(boolean auraSuccFlag)
	{
		this.auraSuccFlag = auraSuccFlag;
	}

	public boolean isAuraErrorsShowFlag()
	{
		return auraErrorsShowFlag;
	}

	public void setAuraErrorsShowFlag(boolean auraErrorsShowFlag)
	{
		this.auraErrorsShowFlag = auraErrorsShowFlag;
	}

	public boolean isCheckUserHtmlErrorShowFlag()
	{
		return checkUserHtmlErrorShowFlag;
	}

	public void setCheckUserHtmlErrorShowFlag(boolean checkUserHtmlErrorShowFlag)
	{
		this.checkUserHtmlErrorShowFlag = checkUserHtmlErrorShowFlag;
	}

	public boolean isCalPremSuccFlag()
	{
		return calPremSuccFlag;
	}

	public void setCalPremSuccFlag(boolean calPremSuccFlag)
	{
		this.calPremSuccFlag = calPremSuccFlag;
	}

	public boolean isCalHtmlErrorShowFlag()
	{
		return calHtmlErrorShowFlag;
	}

	public void setCalHtmlErrorShowFlag(boolean calHtmlErrorShowFlag)
	{
		this.calHtmlErrorShowFlag = calHtmlErrorShowFlag;
	}

	public boolean isUnderWriteSuccFlag()
	{
		return underWriteSuccFlag;
	}

	public void setUnderWriteSuccFlag(boolean underWriteSuccFlag)
	{
		this.underWriteSuccFlag = underWriteSuccFlag;
	}

	public boolean isUnderWriteErrorShowFlag()
	{
		return underWriteErrorShowFlag;
	}

	public void setUnderWriteErrorShowFlag(boolean underWriteErrorShowFlag)
	{
		this.underWriteErrorShowFlag = underWriteErrorShowFlag;
	}

	public boolean isSubmitSuccFlag()
	{
		return submitSuccFlag;
	}

	public void setSubmitSuccFlag(boolean submitSuccFlag)
	{
		this.submitSuccFlag = submitSuccFlag;
	}

	public boolean isSubmitErrorShowFlag()
	{
		return submitErrorShowFlag;
	}

	public void setSubmitErrorShowFlag(boolean submitErrorShowFlag)
	{
		this.submitErrorShowFlag = submitErrorShowFlag;
	}

	public String getSheetType()
	{
		return sheetType;
	}

	public void setSheetType(String sheetType)
	{
		this.sheetType = sheetType;
	}

	public boolean isInsuDeclarationFlag()
	{
		return insuDeclarationFlag;
	}

	public void setInsuDeclarationFlag(boolean insuDeclarationFlag)
	{
		this.insuDeclarationFlag = insuDeclarationFlag;
	}

	public boolean isInsuDeclarationFlag2()
	{
		return insuDeclarationFlag2;
	}

	public void setInsuDeclarationFlag2(boolean insuDeclarationFlag2)
	{
		this.insuDeclarationFlag2 = insuDeclarationFlag2;
	}

	private boolean saveXML(String contNo, Document returnDoc, String fileName)
	{
		try
		{
			saveCreatedXMLFile(returnDoc, fileName, contNo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void saveCreatedXMLFile(Document doc2, String string, String tContNo2)
	{
		(new XMLSaveThread(doc2, string, tContNo2)).start();
	}

	static 
	{
		intiStateMap();
	}
}
