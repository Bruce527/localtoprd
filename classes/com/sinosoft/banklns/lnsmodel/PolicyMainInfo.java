// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PolicyMainInfo.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.BankBasicBL;
import com.sinosoft.banklns.lis.db.LNPContDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			BankGetIconDSource, BankOperateDeal, BankPolicyState

public class PolicyMainInfo extends BankBasicBL
{

	private IGlobalInput tempGI;
	private String checkPsignDate;
	private boolean operateFlag;
	private boolean alertFlag;
	private boolean validateCheckPassFlag;
	private String infoSource;
	private String message;
	private boolean editFlag;
	private String checkedContNo;
	private boolean isExistsIconFlag;
	private String iconMsg;
	private String signCityFirst;
	private String inputOperator;
	private String modifyDate;
	private String consignNo;
	private String pvaliDate;
	private String psignDate;
	private String state;
	private String relationcode;
	private Map stateMap;
	private LNPContSchema lnpcontschema;
	private LNPContSchema tempLnpContSch;
	private List signCityList;
	private String operType;
	private String manageCom;
	private BankPolicyState policyState;
	private BankOperateDeal operateDeal;

	public PolicyMainInfo()
	{
		tempGI = null;
		alertFlag = false;
		validateCheckPassFlag = false;
		stateMap = new HashMap();
		lnpcontschema = new LNPContSchema();
		signCityList = new ArrayList();
	}

	public static void main(String args[])
	{
		PolicyMainInfo p = new PolicyMainInfo();
		p.setState("01");
		LNPContSchema schema = new LNPContSchema();
		schema.setContNo("987000000055");
		p.setLnpcontschema(schema);
		p.isExistsIcon();
	}

	public void isExistsIcon()
	{
		Connection conn = null;
		try
		{
			isExistsIconFlag = false;
			iconMsg = "";
			if (state != null)
			{
				String mySQLString = (new StringBuilder("select OutPayFlag from lnpcont where contno='")).append(lnpcontschema.getContNo()).append("' and OutPayFlag='Y'").toString();
				ExeSQL execSQL = new ExeSQL();
				SSRS ssrs = execSQL.execSQL(mySQLString);
				if (ssrs.MaxRow > 0)
					isExistsIconFlag = true;
				iconMsg = isExistsIconFlag ? "����" : "������";
			}
			break MISSING_BLOCK_LABEL_193;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println((new StringBuilder("////////////////////////////////////////////////~~~~~~~`")).append(e.getLocalizedMessage()).toString());
		}
		try
		{
			if (conn != null && !conn.isClosed())
				conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		break MISSING_BLOCK_LABEL_222;
		Exception exception;
		exception;
		try
		{
			if (conn != null && !conn.isClosed())
				conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		throw exception;
		try
		{
			if (conn != null && !conn.isClosed())
				conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	private Connection getConn()
	{
		Connection conn = null;
		ExeSQL execSQL = new ExeSQL();
		Map keyList = new HashMap();
		SSRS ssrs = execSQL.execSQL("select SysVar, SysVarType from LNPSysVar a where exists (select 1  from LNPSysVar b where b.SysVar='icon_ds_type' and a.SysVarType=b.SysVarValue) and a.SysVar like 'icon_%'");
		for (int i = 1; i <= ssrs.MaxRow; i++)
		{
			String dbtypekey = "dbtype";
			if (ssrs.GetText(i, 1).indexOf(dbtypekey) > 0)
				keyList.put(dbtypekey, (new StringBuilder(String.valueOf(ssrs.GetText(i, 1)))).append(ssrs.GetText(i, 2)).toString());
			String dbnamekey = "dbname";
			if (ssrs.GetText(i, 1).indexOf(dbnamekey) > 0)
				keyList.put(dbnamekey, (new StringBuilder(String.valueOf(ssrs.GetText(i, 1)))).append(ssrs.GetText(i, 2)).toString());
			String dbportkey = "dbport";
			if (ssrs.GetText(i, 1).indexOf(dbportkey) > 0)
				keyList.put(dbportkey, (new StringBuilder(String.valueOf(ssrs.GetText(i, 1)))).append(ssrs.GetText(i, 2)).toString());
			String dbuserkey = "dbuser";
			if (ssrs.GetText(i, 1).indexOf(dbuserkey) > 0)
				keyList.put(dbuserkey, (new StringBuilder(String.valueOf(ssrs.GetText(i, 1)))).append(ssrs.GetText(i, 2)).toString());
			String dbpwdkey = "dbpwd";
			if (ssrs.GetText(i, 1).indexOf(dbpwdkey) > 0)
				keyList.put(dbpwdkey, (new StringBuilder(String.valueOf(ssrs.GetText(i, 1)))).append(ssrs.GetText(i, 2)).toString());
			String dbipkey = "dbip";
			if (ssrs.GetText(i, 1).indexOf(dbipkey) > 0)
				keyList.put(dbipkey, (new StringBuilder(String.valueOf(ssrs.GetText(i, 1)))).append(ssrs.GetText(i, 2)).toString());
			String dbdriverkey = "dbdriver";
			if (ssrs.GetText(i, 1).indexOf(dbdriverkey) > 0)
				keyList.put(dbdriverkey, (new StringBuilder(String.valueOf(ssrs.GetText(i, 1)))).append(ssrs.GetText(i, 2)).toString());
		}

		java.util.Map.Entry m;
		for (Iterator iterator = keyList.entrySet().iterator(); iterator.hasNext(); System.out.println((new StringBuilder("key:")).append((String)m.getKey()).append("value:").append((String)m.getValue()).toString()))
			m = (java.util.Map.Entry)iterator.next();

		conn = BankGetIconDSource.getConn(keyList);
		return conn;
	}

	private String getUnionPolicyNo(String unionCode, String contNo, ExeSQL execSQL)
	{
		String tmpStrList = "";
		try
		{
			if (execSQL == null)
				execSQL = new ExeSQL();
			if (unionCode != null && !"".equals(unionCode.trim()))
			{
				String sql = (new StringBuilder("select contno,agentcode1 from lnpcont where agentcode1='")).append(unionCode).append("' and contno<>'").append(contNo).append("'").toString();
				SSRS ssrs = execSQL.execSQL(sql);
				System.out.println((new StringBuilder("sql-->:")).append(sql).toString());
				if (ssrs.MaxRow > 0)
				{
					for (int i = 1; i <= ssrs.MaxRow; i++)
						tmpStrList = (new StringBuilder(String.valueOf(tmpStrList))).append(ssrs.GetText(i, 1)).append(i == ssrs.MaxRow ? "" : " | ").toString();

				}
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return tmpStrList;
	}

	public void initMainData()
	{
		HttpSession session;
		String contNo;
		String userType;
		session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		contNo = (String)session.getAttribute("ContNo");
		userType = null;
		tempGI = (IGlobalInput)session.getValue("NPGI");
		System.out.println((new StringBuilder("获取当前的tempGI.LNPRole===============")).append(tempGI.LNPRole).toString());
		if (tempGI != null && tempGI.LNPRole != null && !tempGI.LNPRole.equals(""))
		{
			System.out.println("进入�?1�?-------");
			userType = tempGI.LNPRole;
		} else
		{
			System.out.println("进入�?2�?-------");
			alertFlag = true;
			message = "该登录人员没有投保书录入权限�?";
			return;
		}
		try
		{
			System.out.println((new StringBuilder("当前userType的�?�为======")).append(userType).toString());
			initStateMap();
			if (contNo != null && !contNo.equals(""))
			{
				System.out.println("录入后刷新界�?");
				LNPContSchema tempSchema = getContByContNo(contNo);
				if (tempSchema != null)
				{
					lnpcontschema = tempSchema;
					tempLnpContSch = lnpcontschema;
					modifyDate = lnpcontschema.getModifyDate();
					signCityFirst = lnpcontschema.getSignCom();
					consignNo = lnpcontschema.getConsignNo();
					relationcode = getUnionPolicyNo(lnpcontschema.getAgentCode1(), contNo, null);
					pvaliDate = lnpcontschema.getPValiDate();
					psignDate = lnpcontschema.getPSignDate();
					inputOperator = getinputname(lnpcontschema.getInputOperator());
					state = getStateFromMap(stateMap, lnpcontschema);
					Boolean getEditFlag = (Boolean)session.getAttribute("Queryflag");
					BankOperateDeal stateDeal = new BankOperateDeal();
					Boolean operateFlag = Boolean.valueOf(stateDeal.isEidtSheet(tempSchema.getState(), "01", tempGI.LNPRole, contNo));
					if (getEditFlag == null)
					{
						if (operateFlag.booleanValue())
							editFlag = true;
					} else
					if (getEditFlag.booleanValue() && operateFlag.booleanValue())
						editFlag = true;
					else
						editFlag = false;
				} else
				{
					alertFlag = true;
					message = "数据库中不存在该投保书！";
				}
				infoSource = "modify";
			} else
			{
				System.out.println("第一次初始化�?�?");
				System.out.println("进入�?3�?-------");
				editFlag = true;
				lnpcontschema = new LNPContSchema();
				lnpcontschema.setOperator(tempGI.Operator);
				lnpcontschema.setInputOperator(tempGI.Operator);
				lnpcontschema.setState("01");
				relationcode = "";
				signCityFirst = "";
				inputOperator = "";
				modifyDate = "";
				consignNo = "";
				psignDate = PubFun.getCurrentDate();
				pvaliDate = psignDate;
				state = null;
				infoSource = "add";
			}
			System.out.println((new StringBuilder("当前editFlag的�??====")).append(editFlag).toString());
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			message = "该投保书基础信息有误�?";
		}
		return;
	}

	public void exit()
	{
		try
		{
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("Queryflag", null);
			System.out.println("######################################离开编辑页面######################################");
			operateDeal = new BankOperateDeal();
			System.out.println("######################################�?始调用解�?######################################");
			operateDeal.turnEditPolicy(session, null, true);
			System.out.println("######################################解锁结束调用######################################");
		}
		catch (Exception exception) { }
	}

	private String getinputname(String inputOperator2)
	{
		if (inputOperator2 == null || inputOperator2.equals(""))
			break MISSING_BLOCK_LABEL_73;
		SSRS tSSRS;
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select username from muser where usercode='")).append(inputOperator2).append("'").toString();
		tSSRS = tExeSQL.execSQL(sql);
		return tSSRS.GetText(1, 1);
		Exception e;
		e;
		System.out.println("错了错了");
		return "";
		return "";
	}

	private String getStateFromMap(Map stateMap2, LNPContSchema lnpcontschema2)
	{
		return (String)stateMap.get(lnpcontschema2.getState());
	}

	private void initStateMap()
	{
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='lnpLangState' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			stateMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	public void checkContNo()
	{
		alertFlag = true;
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
		if (!Pattern.matches("^[a-zA-Z0-9]{12}$", checkedContNo.substring(0)) && !Pattern.matches("^([M|m]{1})+([a-zA-Z0-9]{7})$", checkedContNo.substring(0)))
		{
			lnpcontschema.setContNo("");
			message = "请按照正确格式录入投保书编号�?";
			alertFlag = true;
			return;
		}
		System.out.println((new StringBuilder("通过投保书号校验")).append(lnpcontschema.getContNo()).toString());
		String newContno = lnpcontschema.getContNo().toUpperCase();
		lnpcontschema.setContNo(newContno);
		alertFlag = false;
		if (!alertFlag)
			checkContNoExist();
	}

	public boolean velidatyInfo()
	{
		System.out.println("页面校验规则�?�?");
		if (lnpcontschema.getContNo() == null || lnpcontschema.getContNo().trim().equals(""))
		{
			alertFlag = true;
			message = "投保书编号不能为空！";
			System.out.println(message);
			return false;
		}
		if (infoSource.equals("add") && getContByContNo(lnpcontschema.getContNo()) != null)
		{
			System.out.println("infoSource=add------------------------");
			alertFlag = true;
			message = "该投保书编号在系统中已存在！";
			return false;
		} else
		{
			return true;
		}
	}

	public boolean addInfo()
	{
		boolean flag = false;
		LNPContSchema addContSch;
		IGlobalInput tempGI;
		addContSch = new LNPContSchema();
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
		if (tempGI == null)
			return false;
		Reflections reflect = new Reflections();
		reflect.transFields(addContSch, lnpcontschema);
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		addContSch.setProposalContNo(addContSch.getContNo());
		addContSch.setPValiDate(pvaliDate);
		addContSch.setPSignDate(psignDate);
		addContSch.setSignCom(signCityFirst);
		addContSch.setConsignNo(consignNo);
		addContSch.setContType("1");
		addContSch.setPolType("1");
		addContSch.setCardFlag("0");
		addContSch.setState("01");
		addContSch.setEditstate("1000000000");
		addContSch.setProposalType("1");
		addContSch.setApproveFlag("0");
		addContSch.setUWFlag("0");
		addContSch.setUWTime("0");
		addContSch.setInsuredId("");
		addContSch.setAppntId("");
		addContSch.setAppntName("");
		addContSch.setGrpContNo(LNPPubFun.getSysInfo("grpcontno"));
		addContSch.setPrtNo(LNPPubFun.getSysInfo("prtno"));
		addContSch.setAgentCode(tempGI.Operator);
		addContSch.setOperator(tempGI.Operator);
		addContSch.setSaleChnlDetail(tempGI.chanlesign);
		addContSch.setManageCom(signCityFirst);
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		addContSch.setModifyDate(date);
		addContSch.setModifyTime(time);
		addContSch.setMakeDate(date);
		addContSch.setMakeTime(time);
		PubSubmit ps = new PubSubmit();
		MMap map = new MMap();
		map.put(addContSch, "INSERT");
		VData vd = new VData();
		vd.add(map);
		if (ps.submitData(vd, ""))
			break MISSING_BLOCK_LABEL_348;
		message = "投保书基�?信息保存失败�?";
		return false;
label0:
		{
			try
			{
				String sql = (new StringBuilder("select * from lnpcont where contno='")).append(addContSch.getContNo()).append("'").toString();
				ExeSQL tExesql = new ExeSQL();
				SSRS tSSRS = tExesql.execSQL(sql);
				if (tSSRS != null && tSSRS.getMaxRow() > 0)
				{
					flag = true;
					break label0;
				}
				System.out.println("投保单基本信息保存语句执行失败！");
			}
			catch (RuntimeException e)
			{
				e.printStackTrace();
				return false;
			}
			return false;
		}
		return flag;
	}

	public boolean modifyInfo(LNPContSchema tempSchema)
	{
		boolean flag = true;
		PubSubmit ps = new PubSubmit();
		MMap map = new MMap();
		try
		{
			tempSchema.setConsignNo(consignNo);
			String date = PubFun.getCurrentDate();
			String time = PubFun.getCurrentTime();
			tempSchema.setModifyDate(date);
			tempSchema.setModifyTime(time);
			tempSchema.setInputOperator(tempGI.Operator);
			System.out.println((new StringBuilder("current signCom is:")).append(tempSchema.getSignCom()).append(",new signCom is:").append(signCityFirst).append(" change?").toString());
			map.put(tempSchema, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "投保书基�?信息保存失败�?";
				flag = false;
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			message = "投保书基�?信息保存失败�?";
			flag = false;
		}
		return flag;
	}

	public boolean saveMainInfo()
	{
		String date;
		String time;
		boolean flag;
		HttpSession session;
		date = PubFun.getCurrentDate();
		time = PubFun.getCurrentTime();
		message = "";
		operateFlag = false;
		System.out.println("保存�?�?----------------");
		flag = false;
		session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		turnCurrPolicyLockFlag(session, lnpcontschema.getContNo(), "lock");
		if (!velidatyInfo())
		{
			turnCurrPolicyLockFlag(session, lnpcontschema.getContNo(), "unlock");
			return false;
		}
		if (infoSource.equals("modify"))
		{
			System.out.println("运行了modify-------");
			LNPContSchema tempSchema = getContByContNo(lnpcontschema.getContNo());
			if (tempSchema == null)
				infoSource = "add";
			else
				flag = modifyInfo(tempSchema);
		}
		if (infoSource.equals("add"))
		{
			System.out.println("运行了add-------");
			flag = addInfo();
			policyState = new BankPolicyState();
			policyState.savePolicyState(lnpcontschema.getContNo(), lnpcontschema.getState(), "1", date, time);
		}
		if (flag)
		{
			session.setAttribute("ContNo", lnpcontschema.getContNo());
			session.setAttribute("CONTLOCK", "LOCKED");
			System.out.println((new StringBuilder("---投保书基�?信息保存成功 session.getAttribute--contno ---")).append(session.getAttribute("ContNo")).toString());
			state = (String)stateMap.get(lnpcontschema.getState());
			message = "投保书基�?信息保存成功�?";
			operateFlag = true;
		} else
		{
			System.out.println((new StringBuilder("---投保书基�?信息保存失败  ")).append(lnpcontschema.getContNo()).toString());
			message = "投保书基�?信息保存失败�?";
		}
		turnCurrPolicyLockFlag(session, lnpcontschema.getContNo(), "unlock");
		return true;
		RuntimeException e;
		e;
		e.printStackTrace();
		message = "投保书基�?信息保存失败�?";
		turnCurrPolicyLockFlag(session, lnpcontschema.getContNo(), "unlock");
		return false;
		Exception exception;
		exception;
		turnCurrPolicyLockFlag(session, lnpcontschema.getContNo(), "unlock");
		throw exception;
	}

	public LNPContSchema getContByContNo(String contNo)
	{
		LNPContDB db = new LNPContDB();
		db.setContNo(contNo);
		if (db.getInfo())
			return db.getSchema();
		else
			return null;
	}

	public void checkContNoExist()
	{
		String tempContNo = lnpcontschema.getContNo();
		System.out.println("�?始检查投保书号是否存�?");
		alertFlag = false;
		if (getContByContNo(tempContNo) != null)
		{
			alertFlag = true;
			lnpcontschema.setContNo("");
			message = "该投保书编号在系统中已存在！";
		} else
		{
			alertFlag = false;
		}
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

	public LNPContSchema getLnpcontschema()
	{
		return lnpcontschema;
	}

	public void setLnpcontschema(LNPContSchema lnpcontschema)
	{
		this.lnpcontschema = lnpcontschema;
	}

	public String getInfoSource()
	{
		return infoSource;
	}

	public void setInfoSource(String infoSource)
	{
		this.infoSource = infoSource;
	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public boolean isOperateFlag()
	{
		return operateFlag;
	}

	public void setOperateFlag(boolean operateFlag)
	{
		this.operateFlag = operateFlag;
	}

	public String getCheckPsignDate()
	{
		return checkPsignDate;
	}

	public void setCheckPsignDate(String checkPsignDate)
	{
		this.checkPsignDate = checkPsignDate;
	}

	public String getPvaliDate()
	{
		return pvaliDate;
	}

	public void setPvaliDate(String pvaliDate)
	{
		this.pvaliDate = pvaliDate;
	}

	public boolean isValidateCheckPassFlag()
	{
		return validateCheckPassFlag;
	}

	public void setValidateCheckPassFlag(boolean validateCheckPassFlag)
	{
		this.validateCheckPassFlag = validateCheckPassFlag;
	}

	public String getPsignDate()
	{
		return psignDate;
	}

	public void setPsignDate(String psignDate)
	{
		this.psignDate = psignDate;
	}

	public String getSignCityFirst()
	{
		return signCityFirst;
	}

	public void setSignCityFirst(String signCityFirst)
	{
		this.signCityFirst = signCityFirst;
	}

	public String getInputOperator()
	{
		return inputOperator;
	}

	public void setInputOperator(String inputOperator)
	{
		this.inputOperator = inputOperator;
	}

	public Map getStateMap()
	{
		return stateMap;
	}

	public void setStateMap(Map stateMap)
	{
		this.stateMap = stateMap;
	}

	public LNPContSchema getTempLnpContSch()
	{
		return tempLnpContSch;
	}

	public void setTempLnpContSch(LNPContSchema tempLnpContSch)
	{
		this.tempLnpContSch = tempLnpContSch;
	}

	public List getSignCityList()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
		if (tempGI == null)
		{
			message = "登录人员信息丢失，请重新登陆�?";
			alertFlag = true;
			return null;
		}
		if (signCityList != null)
			signCityList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select code,codename from lnpcode where codetype='BankSigned' and code like '")).append(tempGI.ManageCom).append("%' order by othersign").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			signCityList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return signCityList;
	}

	public void setSignCityList(List signCityList)
	{
		this.signCityList = signCityList;
	}

	public String getCheckedContNo()
	{
		return checkedContNo;
	}

	public void setCheckedContNo(String checkedContNo)
	{
		this.checkedContNo = checkedContNo;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getOperType()
	{
		return operType;
	}

	public String getModifyDate()
	{
		return formatDate(modifyDate, "YYYYMMDD");
	}

	public void setModifyDate(String modifyDate)
	{
		this.modifyDate = modifyDate;
	}

	public String getConsignNo()
	{
		return consignNo;
	}

	public void setConsignNo(String consignNo)
	{
		this.consignNo = consignNo;
	}

	public void setOperType(String operType)
	{
		this.operType = operType;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String manageCom)
	{
		this.manageCom = manageCom;
	}

	public String getRelationcode()
	{
		return relationcode;
	}

	public void setRelationcode(String relationcode)
	{
		this.relationcode = relationcode;
	}

	public BankPolicyState getPolicyState()
	{
		return policyState;
	}

	public void setPolicyState(BankPolicyState policyState)
	{
		this.policyState = policyState;
	}

	public boolean isExistsIconFlag()
	{
		return isExistsIconFlag;
	}

	public String getIconMsg()
	{
		return iconMsg;
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
}
