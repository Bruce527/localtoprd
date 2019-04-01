// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankRelationContNo.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			LNPRelBean, PolicyMainInfo, BankOperateDeal

public class BankRelationContNo
{

	private List relContList;
	private String relmessage;
	private boolean operateResult;
	private IGlobalInput tempGI;
	private int relSize;
	private boolean checkflag;
	private String relationvalue;
	private String relationitem;
	private boolean makecontNoflag;
	private boolean delflag;
	private boolean relflag;
	private int num;
	private LNPContSchema contSchema;
	private String contNo;
	private boolean copyFlag;

	public BankRelationContNo()
	{
		relContList = new ArrayList();
		operateResult = true;
		checkflag = true;
		makecontNoflag = false;
		delflag = false;
		relflag = true;
		contNo = "";
	}

	private void buildMsg(String msgErr)
	{
		System.out.println((new StringBuilder("buildError:--after-------------")).append(msgErr).toString());
	}

	private boolean getInfoFromSession(HttpSession session)
	{
		boolean flag = false;
		try
		{
			if (session == null)
				session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			tempGI = (IGlobalInput)session.getAttribute("NPGI");
			if ((String)session.getAttribute("ContNo") != null && !((String)session.getAttribute("ContNo")).equals(""))
			{
				contNo = (String)session.getAttribute("ContNo");
				flag = true;
			}
		}
		catch (Exception e)
		{
			flag = false;
			buildMsg(e.getMessage());
		}
		return flag;
	}

	public void initData()
	{
		try
		{
			System.out.println("相关联保单初始化");
			System.out.println((new StringBuilder("当前单选项的值=====")).append(relationitem).toString());
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			if (getInfoFromSession(session))
			{
				contSchema = getMyLNPContByContNo(contNo);
				boolean RelFlag = ((Boolean)session.getAttribute("RelFlag")).booleanValue();
				if (RelFlag)
					relflag = false;
				else
					relflag = true;
				checkflag = true;
				operateResult = true;
				makecontNoflag = false;
				relationitem = "";
				if (contSchema != null && !"".equals(contSchema.getAgentCode1()) && contSchema.getAgentCode1() != null)
				{
					System.out.println((new StringBuilder("当前contSchema.getAgentCode1()的值====")).append(contSchema.getAgentCode1()).toString());
					relationitem = "01";
					relContList = getRellist(contSchema.getAgentCode1(), contNo);
					relSize = relContList.size();
					System.out.println((new StringBuilder("长度=========================")).append(relContList.size()).toString());
				} else
				{
					relationitem = "";
					System.out.println("当前保单不存在关联组");
				}
			} else
			{
				buildMsg("全局投保书信息缺失!");
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			System.out.println("相关联保单界面初始化失败！");
			operateResult = false;
		}
	}

	public void makeRelCode()
	{
		try
		{
			System.out.println("----start-------进入生产相关联保单功能，此处生成关联组号，原则：已存在则继续使用，不存在则新生成----------------");
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			String contNo = (String)session.getAttribute("ContNo");
			String date = PubFun.getCurrentDate();
			String time = PubFun.getCurrentTime();
			contSchema = getMyLNPContByContNo(contNo);
			if (contSchema.getAgentCode1() != null && !contSchema.getAgentCode1().equals(""))
			{
				System.out.println((new StringBuilder("此时存在相关联保单组号“")).append(contSchema.getAgentCode1()).append("”，不必重新生成").toString());
			} else
			{
				SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
				contSchema.setAgentCode1(maxNoMap.CreateMaxNo("CustomerNo", "").substring(12));
				System.out.println((new StringBuilder("create new关联编号:")).append(contSchema.getAgentCode1()).toString());
				contSchema.setModifyDate(date);
				contSchema.setModifyTime(time);
				contSchema.setInputOperator(tempGI.Operator);
				PubSubmit ps = new PubSubmit();
				MMap map = new MMap();
				map.put(contSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					relmessage = "创建关联编号失败！";
					operateResult = false;
				} else
				{
					relmessage = "创建关联编号成功！";
					operateResult = true;
					addOneRel();
				}
			}
			System.out.println("---end--------进入生产相关联保单功能，此处生成关联组号，原则：已存在则继续使用，不存在则新生成----------------");
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			relmessage = "创建关联编号失败！";
			operateResult = false;
		}
	}

	private List getRellist(String RelationNo, String contNo)
	{
		System.out.println("进入数据库查询数据相关联投保书------------");
		List newRelList = new ArrayList();
		String sql = (new StringBuilder("select agentCode1,contno from lnpcont where agentcode1='")).append(RelationNo).append("' and contno<>rtrim('").append(contNo).append("')").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
		{
			LNPRelBean relbean = new LNPRelBean();
			relbean.setContno(tSRS.GetText(i, 2));
			if (i != tSRS.MaxRow)
				relbean.setDisplay("none");
			else
				relbean.setDisplay("inline");
			relbean.setReadflag(true);
			newRelList.add(relbean);
		}

		System.out.println((new StringBuilder("这个时候relContList的长度")).append(newRelList.size()).toString());
		return newRelList;
	}

	public void makeContNo()
	{
		try
		{
			System.out.println("开始创建关联保单");
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			VData vd = new VData();
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			String contNo = (String)session.getAttribute("ContNo");
			String date = PubFun.getCurrentDate();
			String time = PubFun.getCurrentTime();
			System.out.println((new StringBuilder("创建保单时relContList.size()======")).append(relContList.size()).append(" | 创建保单时num============").append(num).toString());
			String newcont = ((LNPRelBean)relContList.get(num)).getContno();
			LNPContSchema NewContNo = getMyLNPContByContNo(newcont);
			if (NewContNo == null)
			{
				System.out.println("没有录入编号的投保单，此时为增加");
				NewContNo = new LNPContSchema();
				LNPContSchema contNew = getMyLNPContByContNo(contNo);
				NewContNo.setState("01");
				NewContNo.setContNo(newcont);
				NewContNo.setEditstate("1000000000");
				NewContNo.setProposalContNo(newcont);
				NewContNo.setMakeDate(date);
				NewContNo.setMakeTime(time);
				NewContNo.setModifyDate(date);
				NewContNo.setModifyTime(time);
				NewContNo.setOperator(tempGI.Operator);
				NewContNo.setInputOperator(tempGI.Operator);
				NewContNo.setPValiDate(date);
				NewContNo.setPSignDate(date);
				NewContNo.setSignCom(contNew.getSignCom());
				NewContNo.setContType("1");
				NewContNo.setPolType("1");
				NewContNo.setCardFlag("0");
				NewContNo.setProposalType("1");
				NewContNo.setApproveFlag("0");
				NewContNo.setUWFlag("0");
				NewContNo.setUWTime("0");
				NewContNo.setInsuredId("");
				NewContNo.setAppntId("");
				NewContNo.setAppntName("");
				NewContNo.setGrpContNo(LNPPubFun.getSysInfo("grpcontno"));
				NewContNo.setPrtNo(LNPPubFun.getSysInfo("prtno"));
				NewContNo.setOperator(tempGI.Operator);
				NewContNo.setSaleChnlDetail(tempGI.chanlesign);
				NewContNo.setManageCom(contNew.getSignCom());
				NewContNo.setAgentCode1(contNew.getAgentCode1());
				contSchema.setModifyDate(date);
				contSchema.setModifyTime(time);
				contSchema.setInputOperator(tempGI.Operator);
				map.put(NewContNo, "INSERT");
				map.put(contSchema, "UPDATE");
			} else
			{
				System.out.println("有录入编号的投保单，此时为修改");
				NewContNo.setAgentCode1(contSchema.getAgentCode1());
				NewContNo.setModifyDate(date);
				NewContNo.setModifyTime(time);
				NewContNo.setInputOperator(tempGI.Operator);
				contSchema.setModifyDate(date);
				contSchema.setModifyTime(time);
				contSchema.setInputOperator(tempGI.Operator);
				map.put(NewContNo, "UPDATE");
				map.put(contSchema, "UPDATE");
			}
			if (!copyFlag)
			{
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					relmessage = "关联投保单失败";
					operateResult = false;
				} else
				{
					relmessage = "关联投保单成功";
					operateResult = true;
					makecontNoflag = true;
				}
			} else
			{
				saveData(map, NewContNo);
			}
		}
		catch (RuntimeException e)
		{
			relmessage = "关联投保单失败";
			operateResult = false;
		}
	}

	public void checkcontno()
	{
		try
		{
			relmessage = "->关联失败<-";
			String contno = ((LNPRelBean)relContList.get(relContList.size() - 1)).getContno();
			System.out.println((new StringBuilder("-------开始进行投保编号")).append(contno).append("校验------").toString());
			LNPContSchema contSel = getMyLNPContByContNo(contno);
			if (!Pattern.matches("^[0-9]{12}", contno))
			{
				relmessage = "请按照正确格式填写投保书号";
				checkflag = false;
			} else
			if (contSel != null && !contSchema.getSignCom().equals(contSel.getSignCom()))
			{
				relmessage = "录入的保单号不符合规则";
				checkflag = false;
			} else
			if (contSchema.getState().equals("01"))
			{
				if (contSel == null || contSel.getState().equals("01"))
				{
					if (contSel != null && contSel.getAgentCode1() != null && !contSel.getAgentCode1().equals(""))
					{
						relmessage = "当前录入保单号存在关联组,不能重复录入";
						checkflag = false;
					} else
					{
						relmessage = "创建成功";
						checkflag = true;
						System.out.println("--------------设置只读选项-------------------");
						((LNPRelBean)relContList.get(relContList.size() - 1)).setReadflag(true);
						System.out.println((new StringBuilder("01状态：当前关联投保书创建成功flag：")).append(checkflag).toString());
					}
				} else
				{
					relmessage = "录入保单的状态不符合要求";
					checkflag = false;
				}
			} else
			if (!"05".equals(contSchema.getState()) && !"06".equals(contSchema.getState()))
			{
				if (contSel != null)
				{
					if ("05".equals(contSel.getState()) || "06".equals(contSel.getState()))
					{
						relmessage = "录入保单的状态不符合要求";
						checkflag = false;
					} else
					if (contSel.getAgentCode1() != null && !contSel.getAgentCode1().equals(""))
					{
						relmessage = "当前录入保单号存在关联组,不能重复录入";
						checkflag = false;
					} else
					{
						relmessage = "创建成功";
						checkflag = true;
						System.out.println("--------------设置只读选项-------------------");
						((LNPRelBean)relContList.get(relContList.size() - 1)).setReadflag(true);
						System.out.println((new StringBuilder("大于02状态：当前关联投保书创建成功flag：")).append(checkflag).toString());
					}
				} else
				{
					relmessage = "创建成功";
					checkflag = true;
					System.out.println("--------------设置只读选项-------------------");
					((LNPRelBean)relContList.get(relContList.size() - 1)).setReadflag(true);
					System.out.println((new StringBuilder("大于02状态：当前关联投保书创建成功flag：")).append(checkflag).toString());
				}
			} else
			{
				relmessage = "创建失败,当前被关联投保书状态不符合要求";
				checkflag = false;
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			relmessage = "创建失败";
			checkflag = false;
		}
	}

	private LNPContSchema getMyLNPContByContNo(String contNo2)
	{
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contNo2);
		return aLNPContSchema;
	}

	public void saveData(MMap map1, LNPContSchema newContSchema)
	{
		System.out.println("进入数据同步功能");
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String contNo = (String)session.getAttribute("ContNo");
		String newcontno = ((LNPRelBean)relContList.get(num)).getContno();
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		LNPAppntSchema appntSchema = getAppntByContNo(contNo);
		LNPAppntSchema newappntSchema = getAppntByContNo(newcontno);
		LNPInsuredSchema suredSchema = getSuredByContNo(contNo);
		LNPInsuredSchema newsuredSchema = getSuredByContNo(newcontno);
		LNPBnfSet bnfSet = getBnfByContNo(contNo);
		LNPBnfSet newbnfSet = getBnfByContNo(newcontno);
		System.out.println("受益人信息");
		LNPPaymentSchema paySchema = getPayByContNo(contNo);
		LNPPaymentSchema newpaySchema = getPayByContNo(newcontno);
		System.out.println("收付费信息");
		LNPAgentInfoSchema agentSchema = getAgentByContNo(contNo);
		LNPAgentInfoSchema newagentSchema = getAgentByContNo(newcontno);
		System.out.println("代理人信息");
		LNPCustImpResultSet custImpSet = getCustImpByContNo(contNo);
		LNPCustImpResultSet newcustImpSet = getCustImpByContNo(newcontno);
		System.out.println("答案信息");
		if (appntSchema != null && !appntSchema.equals(""))
		{
			System.out.println("开始同步投保人信息");
			LNPAddressSchema addressSchema = getAddressByID(appntSchema.getAppntId());
			LNPPersonSchema personSchema = getPersonByID(appntSchema.getAppntId());
			appntSchema.setContNo(newcontno);
			appntSchema.setProposalContNo(newcontno);
			appntSchema.setModifyDate(date);
			appntSchema.setModifyTime(time);
			appntSchema.setMakeDate(date);
			appntSchema.setMakeTime(time);
			appntSchema.setOperator(tempGI.Operator);
			SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
			addressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
			appntSchema.setAppntId(maxNoMap.CreateMaxNo("CustomerNo", ""));
			appntSchema.setAddressNo(addressSchema.getAddressNo());
			addressSchema.setCustomerId(appntSchema.getAppntId());
			personSchema.setCustomerId(appntSchema.getAppntId());
			personSchema.setAgentCode(appntSchema.getOperator());
			map1.put(newappntSchema, "DELETE");
			map1.put(appntSchema, "INSERT");
			map1.put(addressSchema, "INSERT");
			map1.put(personSchema, "INSERT");
		} else
		if (newappntSchema != null)
		{
			LNPAddressSchema addressSchema = getAddressByID(newappntSchema.getAppntId());
			LNPPersonSchema personSchema = getPersonByID(newappntSchema.getAppntId());
			map1.put(personSchema, "DELETE");
			map1.put(addressSchema, "DELETE");
			map1.put(newappntSchema, "DELETE");
		}
		if (suredSchema != null && !suredSchema.equals(""))
		{
			System.out.println("开始同步被保人信息");
			LNPAddressSchema addressSchema = getAddressByID(suredSchema.getInsuredId());
			LNPPersonSchema personSchema = getPersonByID(suredSchema.getInsuredId());
			suredSchema.setContNo(newcontno);
			suredSchema.setProposalContNo(newcontno);
			suredSchema.setMakeDate(date);
			suredSchema.setMakeTime(time);
			suredSchema.setModifyDate(date);
			suredSchema.setModifyTime(time);
			suredSchema.setOperator(tempGI.Operator);
			SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
			addressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
			suredSchema.setInsuredId(maxNoMap.CreateMaxNo("CustomerNo", ""));
			suredSchema.setAppntId(appntSchema.getAppntId());
			suredSchema.setAddressNo(addressSchema.getAddressNo());
			addressSchema.setCustomerId(suredSchema.getInsuredId());
			personSchema.setCustomerId(suredSchema.getInsuredId());
			personSchema.setAgentCode(suredSchema.getOperator());
			map1.put(newsuredSchema, "DELETE");
			map1.put(suredSchema, "INSERT");
			map1.put(personSchema, "INSERT");
			map1.put(addressSchema, "INSERT");
		} else
		if (newsuredSchema != null)
		{
			LNPAddressSchema addressSchema = getAddressByID(newsuredSchema.getAppntId());
			LNPPersonSchema personSchema = getPersonByID(newsuredSchema.getAppntId());
			map1.put(addressSchema, "DELETE");
			map1.put(personSchema, "DELETE");
			map1.put(newsuredSchema, "DELETE");
		}
		if (bnfSet != null && bnfSet.size() > 0)
		{
			System.out.println("开始同步受益人信息");
			SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
			for (int i = 1; i <= bnfSet.size(); i++)
			{
				bnfSet.get(i).setContNo(newcontno);
				if (suredSchema != null && !suredSchema.equals(""))
					bnfSet.get(i).setInsuredId(suredSchema.getInsuredId());
				else
					bnfSet.get(i).setInsuredId("");
				bnfSet.get(i).setBnfId(maxNoMap.CreateMaxNo("CustomerNo", ""));
				bnfSet.get(i).setMakeDate(date);
				bnfSet.get(i).setMakeTime(time);
				bnfSet.get(i).setModifyDate(date);
				bnfSet.get(i).setModifyTime(time);
				bnfSet.get(i).setOperator(tempGI.Operator);
			}

			map1.put(newbnfSet, "DELETE");
			map1.put(bnfSet, "INSERT");
		} else
		{
			map1.put(newbnfSet, "DELETE");
		}
		if (paySchema != null && !paySchema.equals(""))
		{
			System.out.println("开始同步收付费信息");
			paySchema.setContNo(newcontno);
			paySchema.setMakeDate(date);
			paySchema.setMakeTime(time);
			paySchema.setModifyDate(date);
			paySchema.setModifyTime(time);
			paySchema.setOperator(tempGI.Operator);
			if (appntSchema != null && !appntSchema.equals(""))
				paySchema.setAppntID(appntSchema.getAppntId());
			else
				paySchema.setAppntID("");
			if (suredSchema != null && !suredSchema.equals(""))
				paySchema.setInusredID(suredSchema.getInsuredId());
			else
				paySchema.setInusredID("");
			map1.put(newpaySchema, "DELETE");
			map1.put(paySchema, "INSERT");
		} else
		{
			map1.put(newpaySchema, "DELETE");
		}
		if (agentSchema != null && !agentSchema.equals(""))
		{
			System.out.println("开始同步代理人信息");
			agentSchema.setContNo(newcontno);
			agentSchema.setProposalContNo(newcontno);
			agentSchema.setMakeDate(date);
			agentSchema.setMakeTime(time);
			agentSchema.setModifyDate(date);
			agentSchema.setModifyTime(time);
			agentSchema.setOperator(tempGI.Operator);
			map1.put(newagentSchema, "DELETE");
			map1.put(agentSchema, "INSERT");
		} else
		{
			map1.put(newagentSchema, "DELETE");
		}
		if (custImpSet != null && custImpSet.size() > 0)
		{
			System.out.println("开始同步答案信息");
			SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
			String appresultid = maxNoMap.CreateMaxNo("CustomerNo", "");
			String insresultid = maxNoMap.CreateMaxNo("CustomerNo", "");
			for (int i = 1; i <= custImpSet.size(); i++)
			{
				custImpSet.get(i).setContNo(newcontno);
				if (custImpSet.get(i).getCustomerNo().equals("appnt"))
					custImpSet.get(i).setResultId(appresultid);
				else
					custImpSet.get(i).setResultId(insresultid);
				custImpSet.get(i).setMakeDate(date);
				custImpSet.get(i).setMakeTime(time);
				custImpSet.get(i).setModifyDate(date);
				custImpSet.get(i).setModifyTime(time);
				custImpSet.get(i).setOperator(tempGI.Operator);
			}

			map1.put(newcustImpSet, "DELETE");
			map1.put(custImpSet, "INSERT");
		} else
		{
			map1.put(newcustImpSet, "DELETE");
		}
		System.out.println("同步数据成功后，进行修改保单状态");
		if (newContSchema != null)
		{
			BankOperateDeal stateOperate = new BankOperateDeal();
			List list = stateOperate.relInfoOperate(contSchema, newContSchema);
			newContSchema.setState((String)list.get(0));
			newContSchema.setEditstate((String)list.get(1));
			System.out.println((new StringBuilder("###############current policy：")).append(contSchema.getContNo()).append(" 被关联投保书 信息: state:").append(contSchema.getState()).append(" | editstate:").append(contSchema.getEditstate()).toString());
			System.out.println((new StringBuilder("###############current policy：")).append(newContSchema.getContNo()).append(" 关联投保书 信息: state:").append(newContSchema.getState()).append(" | editstate:").append(newContSchema.getEditstate()).toString());
			if (appntSchema != null)
			{
				newContSchema.setAppntId(appntSchema.getAppntId());
				newContSchema.setAppntName(appntSchema.getAppntName());
				newContSchema.setAppntNo(appntSchema.getAppntNo());
				newContSchema.setAppntBirthday(appntSchema.getAppntBirthday());
				newContSchema.setAppntIDType(appntSchema.getIDType());
				newContSchema.setAppntIDNo(appntSchema.getIDNo());
				newContSchema.setAppntSex(appntSchema.getAppntSex());
			} else
			{
				System.out.println("此时无投保人信息");
			}
			if (suredSchema != null)
			{
				newContSchema.setInsuredId(suredSchema.getInsuredId());
				newContSchema.setInsuredNo(suredSchema.getInsuredNo());
				newContSchema.setInsuredName(suredSchema.getName());
				newContSchema.setInsuredBirthday(suredSchema.getBirthday());
				newContSchema.setInsuredIDType(suredSchema.getIDType());
				newContSchema.setInsuredIDNo(suredSchema.getIDNo());
				newContSchema.setInsuredSex(suredSchema.getSex());
			} else
			{
				System.out.println("此时无被保人信息");
			}
			if (agentSchema != null)
			{
				newContSchema.setAgentCom(agentSchema.getBranchAttr());
				newContSchema.setPSignDate(contSchema.getPSignDate());
				newContSchema.setPValiDate(contSchema.getPValiDate());
			} else
			{
				System.out.println("此时无代理人告知信息");
			}
			PubSubmit ps = new PubSubmit();
			VData vd1 = new VData();
			LNPContSet newLNPContSet = new LNPContSet();
			newLNPContSet.add(newContSchema);
			map1.put(newLNPContSet, "UPDATE");
			vd1.add(map1);
			if (!ps.submitData(vd1, ""))
			{
				relmessage = "关联保单失败";
				operateResult = false;
			} else
			{
				relmessage = "关联保单成功";
				operateResult = true;
			}
		} else
		{
			relmessage = "关联保单失败";
			operateResult = false;
			System.out.println("LNPcont state， editstate关联失败~~~~~~~~~~~~~~~~\267\267");
		}
	}

	public void addOneRel()
	{
		System.out.println("能够进入addonerel()中！");
		System.out.println(relContList.size());
		operateResult = true;
		boolean check = false;
		if (relContList.size() >= 1)
		{
			String conNumber = ((LNPRelBean)relContList.get(relContList.size() - 1)).getContno();
			if (conNumber == null || conNumber.equals("") || !checkflag)
				check = false;
			else
				check = true;
			if (!check)
			{
				operateResult = false;
				relmessage = "本行信息录入后才可以添加下一行";
				return;
			}
			System.out.println("进行下列添加程序代码1");
		} else
		{
			System.out.println("进行下列添加程序代码2");
		}
		if (relContList.size() < 50)
		{
			for (int i = 0; i < relContList.size(); i++)
			{
				if (!((LNPRelBean)relContList.get(i)).getContno().equals("") && ((LNPRelBean)relContList.get(i)).getContno() != null && !relContList.equals(""))
					((LNPRelBean)relContList.get(i)).setReadflag(true);
				else
					((LNPRelBean)relContList.get(i)).setReadflag(false);
				if (i != relContList.size())
					((LNPRelBean)relContList.get(i)).setDisplay("none");
				else
					((LNPRelBean)relContList.get(i)).setDisplay("inline");
			}

			LNPRelBean newRel = new LNPRelBean();
			relContList.add(newRel);
			relSize = relContList.size();
			System.out.println(relContList.size());
		} else
		{
			System.out.println("已达上限，不能再进行添加操作");
		}
	}

	public void delOneRel()
	{
		System.out.println((new StringBuilder("开始删除时relContList的size====")).append(relContList.size()).toString());
		delflag = false;
		operateResult = true;
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String contNo = (String)session.getAttribute("ContNo");
		System.out.println((new StringBuilder("取得点击的删除按钮所在的位置==")).append(num).toString());
		String contnorel = ((LNPRelBean)relContList.get(num)).getContno();
		if (!contnorel.equals("") && contnorel != null)
		{
			delRelCode(contnorel);
		} else
		{
			delflag = true;
			System.out.println("当前行没有保单号");
		}
		if (delflag)
		{
			if (relContList.size() > 1)
			{
				relContList.remove(num);
				relSize = relContList.size();
			} else
			{
				relContList.remove(num);
				delRelCode(contNo);
				relationitem = "";
				System.out.println("关联保单号，不能再进行删除操作");
			}
			System.out.println((new StringBuilder("删除结束时relContList的size====")).append(relContList.size()).toString());
			for (int i = 0; i < relContList.size(); i++)
			{
				if (!((LNPRelBean)relContList.get(i)).getContno().equals("") && ((LNPRelBean)relContList.get(i)).getContno() != null && !relContList.equals(""))
					((LNPRelBean)relContList.get(i)).setReadflag(true);
				else
					((LNPRelBean)relContList.get(i)).setReadflag(false);
				if (i == relContList.size() - 1)
					((LNPRelBean)relContList.get(i)).setDisplay("inline");
			}

		}
	}

	private void delRelCode(String contno)
	{
		System.out.println("进入删除相关联编号方法");
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contno);
		if (aLNPContSchema != null)
		{
			if ("06".equals(aLNPContSchema.getState()))
			{
				relmessage = (new StringBuilder("关联投保单号“")).append(aLNPContSchema.getContNo()).append("”当前状态为 <已审核-发送成功>,不可再删除关联关系").toString();
				delflag = false;
			} else
			if (aLNPContSchema.getAgentCode1().equals(contSchema.getAgentCode1()))
			{
				aLNPContSchema.setAgentCode1("");
				PubSubmit ps = new PubSubmit();
				MMap map = new MMap();
				map.put(aLNPContSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					delflag = false;
					relmessage = "删除关联保单失败";
					System.out.println("删除相关联编号失败");
				} else
				{
					delflag = true;
					relmessage = "删除关联保单成功";
					System.out.println("删除相关联编号成功");
				}
			}
		} else
		{
			System.out.println("此时lnpcont表中无此保单号信息");
		}
	}

	public LNPAppntSchema getAppntByContNo(String contNo)
	{
		LNPAppntDB db = new LNPAppntDB();
		db.setContNo(contNo);
		if (db.getInfo())
			return db.getSchema();
		else
			return null;
	}

	public LNPInsuredSchema getSuredByContNo(String contNo)
	{
		LNPInsuredDB db = new LNPInsuredDB();
		db.setContNo(contNo);
		LNPInsuredSet insuredSet = db.query();
		if (insuredSet.size() > 0)
			return insuredSet.get(1).getSchema();
		else
			return null;
	}

	public LNPBnfSet getBnfByContNo(String contNo)
	{
		System.out.println("获取受益人信息");
		LNPBnfDB db = new LNPBnfDB();
		db.setContNo(contNo);
		LNPBnfSet bnfSet = db.query();
		if (bnfSet.size() > 0)
			return bnfSet;
		else
			return bnfSet;
	}

	public LNPPaymentSchema getPayByContNo(String contNo)
	{
		LNPPaymentDB db = new LNPPaymentDB();
		db.setContNo(contNo);
		if (db.getInfo())
			return db.getSchema();
		else
			return null;
	}

	public LNPAgentInfoSchema getAgentByContNo(String contNo)
	{
		LNPAgentInfoDB db = new LNPAgentInfoDB();
		db.setContNo(contNo);
		LNPAgentInfoSet insuredSet = db.query();
		if (insuredSet.size() > 0)
			return insuredSet.get(1).getSchema();
		else
			return null;
	}

	public LNPCustImpResultSet getCustImpByContNo(String contNo)
	{
		LNPCustImpResultDB db = new LNPCustImpResultDB();
		db.setContNo(contNo);
		LNPCustImpResultSet custImpSet = db.query();
		if (custImpSet.size() > 0)
			return custImpSet;
		else
			return custImpSet;
	}

	public LNPAddressSchema getAddressByID(String id)
	{
		LNPAddressDB db = new LNPAddressDB();
		db.setCustomerId(id);
		LNPAddressSet addSet = db.query();
		if (addSet.size() > 0)
			return addSet.get(1).getSchema();
		else
			return null;
	}

	public LNPPersonSchema getPersonByID(String id)
	{
		LNPPersonDB db = new LNPPersonDB();
		db.setCustomerId(id);
		LNPPersonSet perSet = db.query();
		if (perSet.size() > 0)
			return perSet.get(1).getSchema();
		else
			return null;
	}

	public List getRelContList()
	{
		return relContList;
	}

	public String getRelmessage()
	{
		return relmessage;
	}

	public void setRelmessage(String relmessage)
	{
		this.relmessage = relmessage;
	}

	public void setRelContList(List relContList)
	{
		this.relContList = relContList;
	}

	public boolean isOperateResult()
	{
		return operateResult;
	}

	public void setOperateResult(boolean operateResult)
	{
		this.operateResult = operateResult;
	}

	public int getRelSize()
	{
		return relSize;
	}

	public void setRelSize(int relSize)
	{
		this.relSize = relSize;
	}

	public boolean isCheckflag()
	{
		return checkflag;
	}

	public void setCheckflag(boolean checkflag)
	{
		this.checkflag = checkflag;
	}

	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public String getRelationvalue()
	{
		return relationvalue;
	}

	public void setRelationvalue(String relationvalue)
	{
		this.relationvalue = relationvalue;
	}

	public String getRelationitem()
	{
		return relationitem;
	}

	public void setRelationitem(String relationitem)
	{
		this.relationitem = relationitem;
	}

	public boolean isMakecontNoflag()
	{
		return makecontNoflag;
	}

	public void setMakecontNoflag(boolean makecontNoflag)
	{
		this.makecontNoflag = makecontNoflag;
	}

	public boolean isDelflag()
	{
		return delflag;
	}

	public void setDelflag(boolean delflag)
	{
		this.delflag = delflag;
	}

	public boolean isRelflag()
	{
		return relflag;
	}

	public void setRelflag(boolean relflag)
	{
		this.relflag = relflag;
	}

	public boolean isCopyFlag()
	{
		return copyFlag;
	}

	public void setCopyFlag(boolean copyFlag)
	{
		this.copyFlag = copyFlag;
	}
}
