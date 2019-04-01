// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   InsuranceQuery.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.utility.*;
import com.sinosoft.map.common.MainListener;
import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.lis.excel.*;
import com.sinosoft.map.lis.pubfun.PubFun;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			LNPContBean, BankPolicyState, PolicyMainInfo

public class InsuranceQuery
{

	private IGlobalInput tempGI;
	private LNPContSchema queryContSch;
	private String state;
	private String startDate;
	private String endDate;
	private String auditUser;
	private String auditUserID;
	private String kindcode;
	private String riskcode;
	private String entryUserID;
	private List lnpManageComList;
	private List lnpStateList;
	private List kindcodeList;
	private String manageCom;
	private String remark;
	private String excelPath;
	private String filename;
	private String data[][];
	private static int totalSize = 200;
	private String auditDate;
	private String prem;
	private String contNo;
	private String message;
	private boolean alertFlag;
	private boolean cancelAbilityFlag;
	private BankPolicyState policyState;
	private boolean showErrorFlag;
	private List lnpList;
	private static Map ContStateMap = new HashMap();
	private Map ContRiskMap;
	private Map ContAgentComMap;
	public String sql;
	private boolean lock;
	private String rmvPolicy;
	private String rmvState;

	public InsuranceQuery()
	{
		tempGI = null;
		queryContSch = new LNPContSchema();
		lnpManageComList = new ArrayList();
		lnpStateList = new ArrayList();
		kindcodeList = new ArrayList();
		showErrorFlag = false;
		lnpList = new ArrayList();
		ContRiskMap = new HashMap();
		ContAgentComMap = new HashMap();
		sql = null;
		lock = true;
	}

	public String getExcelPath()
	{
		return excelPath;
	}

	public void setExcelPath(String excelPath)
	{
		this.excelPath = excelPath;
	}

	public void report()
	{
		System.out.println("======== get report ===");
		DBConn con = DBConnPool.getConnection();
		excelPath = "";
		excelPath = printReportList(con);
	}

	public String printReportList(DBConn con)
	{
		boolean flag = true;
		String currentDate = PubFun.getCurrentDate();
		String templetFileName = "InsuranceQuery.xls";
		String reportFileName = (new StringBuilder(String.valueOf(manageCom != null && !"".equals(manageCom) ? ((Object) (manageCom)) : ((Object) (tempGI.Operator))))).append("_").append("InsuranceQuery_").append(tempGI.Operator).append("_").append(currentDate).append(".xls").toString();
		filename = reportFileName;
		long usefullLifeSec = 0L;
		String rvFNStartWith = (new StringBuilder(String.valueOf(manageCom != null && !"".equals(manageCom) ? ((Object) (manageCom)) : ((Object) (tempGI.Operator))))).append("_").append("InsuranceQuery").toString();
		long invalidationSec = usefullLifeSec * 2L;
		ReportHelper helper = new ReportHelper(templetFileName, reportFileName, usefullLifeSec, rvFNStartWith, invalidationSec);
		ExcelInfo info = helper.getInfo();
		if (!info.exists())
			flag = getPrintData(con, helper);
		if (flag)
		{
			ExcelInfo info2 = helper.getInfo();
			String Excelpath = info2.getReportPath();
			return Excelpath;
		} else
		{
			ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "无法打印报表，没有查询到符合条件的数据！");
			return "";
		}
	}

	private boolean getPrintData(DBConn con, ReportHelper helper)
	{
		SimpleWorkbook workbook;
		if ("".equals(sql) || sql == null)
			return false;
		querySql(con, (new StringBuilder("select * from ")).append(sql).toString(), true);
		if (data == null || data.length == 0)
			return false;
		workbook = helper.createWorkbook();
		try
		{
			if (data == null)
				ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "记录为空");
			workbook.set("currentDate", PubFun.getCurrentDate());
			workbook.add(data);
			workbook = null;
		}
		catch (Exception e)
		{
			if (workbook != null)
				try
				{
					workbook.close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			return false;
		}
		break MISSING_BLOCK_LABEL_149;
		Exception exception;
		exception;
		if (workbook != null)
			try
			{
				workbook.close();
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		throw exception;
		if (workbook != null)
			try
			{
				workbook.close();
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		return true;
	}

	public void download()
	{
		FacesContext context;
		HttpServletResponse response;
		context = FacesContext.getCurrentInstance();
		response = (HttpServletResponse)context.getExternalContext().getResponse();
		response.reset();
		response.setContentType("application/OCTET-STREAM");
		response.setHeader("Content-disposition", (new StringBuilder("attachment;filename=")).append(new String(filename.getBytes(), "iso-8859-1")).toString());
		ReportHelper.download(response.getOutputStream(), excelPath);
		break MISSING_BLOCK_LABEL_121;
		UnsupportedEncodingException e;
		e;
		e.printStackTrace();
		context.responseComplete();
		break MISSING_BLOCK_LABEL_125;
		e;
		e.printStackTrace();
		context.responseComplete();
		break MISSING_BLOCK_LABEL_125;
		Exception exception;
		exception;
		context.responseComplete();
		throw exception;
		context.responseComplete();
	}

	public List getLnpManageComList()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
		if (tempGI == null)
		{
			message = "登录人员信息丢失，请重新登陆！";
			alertFlag = true;
			return null;
		}
		if (lnpManageComList != null)
			lnpManageComList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select code,codename from lnpcode where codetype='lnpManageCom' and code like '")).append(tempGI.ManageCom).append("%' order by code").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			lnpManageComList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return lnpManageComList;
	}

	public List getKindcodeList()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
		if (tempGI == null)
		{
			message = "登录人员信息丢失，请重新登陆！";
			alertFlag = true;
			return null;
		}
		if (kindcodeList != null)
			kindcodeList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='lnpRiskType' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			kindcodeList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return kindcodeList;
	}

	public void setKindcodeList(List kindcodeList)
	{
		this.kindcodeList = kindcodeList;
	}

	public void setLnpManageComList(List lnpManageComList)
	{
		this.lnpManageComList = lnpManageComList;
	}

	public String getAuditUserID()
	{
		return auditUserID;
	}

	public void setAuditUserID(String auditUserID)
	{
		this.auditUserID = auditUserID;
	}

	public String getKindcode()
	{
		return kindcode;
	}

	public void setKindcode(String kindcode)
	{
		this.kindcode = kindcode;
	}

	public String getRiskcode()
	{
		return riskcode;
	}

	public void setRiskcode(String riskcode)
	{
		this.riskcode = riskcode;
	}

	public String getEntryUserID()
	{
		return entryUserID;
	}

	public void setEntryUserID(String entryUserID)
	{
		this.entryUserID = entryUserID;
	}

	public List getLnpStateList()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
		if (tempGI == null)
		{
			message = "登录人员信息丢失，请重新登陆！";
			alertFlag = true;
			return null;
		}
		if (lnpStateList != null)
			lnpStateList.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='lnpLangState'  order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			lnpStateList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return lnpStateList;
	}

	public void setLnpStateList(List lnpStateList)
	{
		this.lnpStateList = lnpStateList;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String manageCom)
	{
		this.manageCom = manageCom;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getAuditUser()
	{
		return auditUser;
	}

	public void setAuditUser(String auditUser)
	{
		this.auditUser = auditUser;
	}

	public String getAuditDate()
	{
		return auditDate;
	}

	public void setAuditDate(String auditDate)
	{
		this.auditDate = auditDate;
	}

	public void init()
	{
		System.out.println("--  InsuranceQuery init --");
		queryContSch = new LNPContSchema();
		lnpList = new ArrayList();
		state = null;
		auditUserID = null;
		entryUserID = null;
		kindcode = null;
		riskcode = null;
		startDate = null;
		endDate = null;
		auditUser = null;
		manageCom = null;
		remark = null;
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
		if (tempGI == null)
		{
			message = "登录人员信息丢失，请重新登陆！";
			alertFlag = true;
			return;
		} else
		{
			cancelAbilityFlag = tempGI.LNPCancel;
			return;
		}
	}

	public void query()
	{
		DBConn con;
		con = DBConnPool.getConnection();
		sql = "";
		System.out.println("-- query state--");
		alertFlag = false;
		showErrorFlag = false;
		if (lnpList != null)
			lnpList.clear();
		if (tempGI == null)
		{
			message = "该登录人员没有投保书查询权限！";
			alertFlag = true;
			return;
		}
		this;
		sql;
		JVM INSTR new #139 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" lnpcont c where  c.signcom  like '";
		append();
		tempGI.ManageCom;
		append();
		"%' ";
		append();
		" and c.SaleChnlDetail='3' ";
		append();
		toString();
		sql;
		this;
		sql;
		JVM INSTR new #139 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		editSql();
		append();
		toString();
		sql;
		this;
		sql;
		JVM INSTR new #139 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" order by c.makedate desc,c.maketime desc";
		append();
		toString();
		sql;
		querySql(con, (new StringBuilder("select * from ")).append(sql).toString(), false);
		break MISSING_BLOCK_LABEL_205;
		RuntimeException e;
		e;
		e.printStackTrace();
		System.out.println("-- query end--");
		return;
	}

	private void querySql(DBConn con, String sql, boolean isExcelExport)
	{
		System.out.println((new StringBuilder("--->execSQL:")).append(sql).toString());
		LNPContDB db = new LNPContDB(con);
		LNPContSet reSet = db.executeQuery(sql);
		if (reSet.size() > 0)
		{
			if (reSet.size() >= totalSize)
			{
				ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", (new StringBuilder("查询结果共【")).append(reSet.size()).append("】条，只显示前【").append(totalSize).append("】条！").toString());
				showErrorFlag = true;
			} else
			{
				System.out.println((new StringBuilder("此时一共有")).append(reSet.size()).append("条记录！").toString());
			}
			getRiskString(reSet, con);
			getNetcode(reSet, con);
			int lastTalSize = reSet.size() <= totalSize ? reSet.size() : totalSize;
			if (isExcelExport)
			{
				lastTalSize = reSet.size();
				data = new String[lastTalSize][14];
			}
			LNPContBean temp = new LNPContBean();
			for (int i = 1; i <= lastTalSize; i++)
			{
				temp = new LNPContBean();
				LNPContSchema schema = reSet.get(i);
				temp.setSchema(schema);
				System.out.println((new StringBuilder("idx:")).append(i).append("----contno:").append(temp.getSchema().getContNo()).toString());
				temp.setRiskList((String)ContRiskMap.get(temp.getSchema().getContNo()));
				temp.setShowState((String)ContStateMap.get(temp.getSchema().getState()));
				temp.setNetcode((String)ContAgentComMap.get(temp.getSchema().getContNo()));
				temp.setDisplay(!cancelAbilityFlag || "06".equals(temp.getSchema().getState()) ? "none" : "");
				if (isExcelExport)
				{
					data[i - 1][0] = (new StringBuilder(String.valueOf(i))).toString();
					data[i - 1][1] = temp.getSignCom();
					data[i - 1][2] = schema.getMakeDate();
					data[i - 1][3] = schema.getContNo();
					data[i - 1][4] = temp.getRiskList();
					data[i - 1][5] = schema.getAppntName();
					data[i - 1][6] = schema.getAppntIDNo();
					data[i - 1][7] = schema.getInsuredName();
					data[i - 1][8] = schema.getInsuredIDNo();
					data[i - 1][9] = temp.getPrem();
					data[i - 1][10] = temp.getNetcode();
					data[i - 1][11] = temp.getShowState();
					data[i - 1][12] = schema.getInputOperator();
					data[i - 1][13] = schema.getModifyDate();
				} else
				{
					lnpList.add(temp);
				}
			}

		} else
		if (!isExcelExport)
		{
			ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "没有符合条件的结果！");
			alertFlag = true;
		}
	}

	private String getStateFromMap(LNPContSchema lnpcontschema)
	{
		String sql = (new StringBuilder("select codename from lnpcode where (codetype='lnpLangState' and code='")).append(lnpcontschema.getState()).append("') order by codetype").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		return tSSRS.GetText(1, 1);
	}

	private void getNetcode(LNPContSet contSet, DBConn con)
	{
		ContAgentComMap.clear();
		if (contSet != null && contSet.size() > 0)
		{
			StringBuffer contnolist = new StringBuffer();
			for (int i = 1; i <= contSet.size(); i++)
				if (i != contSet.size())
					contnolist.append((new StringBuilder("'")).append(contSet.get(i).getContNo()).append("',").toString());
				else
					contnolist.append((new StringBuilder("'")).append(contSet.get(i).getContNo()).append("'").toString());

			String sql = (new StringBuilder("select contno,p2 from lnpagentinfo  where contno in (")).append(contnolist.toString()).append(")").toString();
			System.out.println((new StringBuilder("-->query contnoUNIONrisk sql:")).append(sql).toString());
			ExeSQL tExeSQL = new ExeSQL(con);
			SSRS tSSRS = tExeSQL.execSQL(sql);
			for (int i = 1; i <= tSSRS.MaxRow; i++)
				ContAgentComMap.put(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2));

		}
		System.out.println("-----------------------------------------------------");
		Set set = ContAgentComMap.entrySet();
		java.util.Map.Entry entry;
		for (Iterator it = set.iterator(); it.hasNext(); System.out.println((new StringBuilder("代理网点映射:")).append((String)entry.getKey()).append("--:--").append((String)entry.getValue()).toString()))
			entry = (java.util.Map.Entry)it.next();

	}

	private void getRiskString(LNPContSet contSet, DBConn con)
	{
		ContRiskMap.clear();
		if (contSet != null && contSet.size() > 0)
		{
			StringBuffer contnolist = new StringBuffer();
			for (int i = 1; i <= contSet.size(); i++)
				if (i != contSet.size())
					contnolist.append((new StringBuilder("'")).append(contSet.get(i).getContNo()).append("',").toString());
				else
					contnolist.append((new StringBuilder("'")).append(contSet.get(i).getContNo()).append("'").toString());

			ExeSQL tExeSQL = new ExeSQL(con);
			String riskSQL1 = (new StringBuilder("select riskcode,subflag,contno from lnppol a where contno in (")).append(contnolist.toString()).append(")").toString();
			System.out.println((new StringBuilder("-->query contnoUNIONrisk sql:")).append(riskSQL1).toString());
			SSRS tSSRS1 = tExeSQL.execSQL(riskSQL1);
			for (int i = 1; i <= tSSRS1.MaxRow; i++)
				if (ContRiskMap.containsKey(tSSRS1.GetText(i, 3)))
				{
					String tRiskCode = (String)ContRiskMap.get(tSSRS1.GetText(i, 3));
					tRiskCode = "M".equals(tSSRS1.GetText(i, 2)) ? (new StringBuilder(String.valueOf(tSSRS1.GetText(i, 1)))).append(",").append(tRiskCode).toString() : (new StringBuilder(String.valueOf(tRiskCode))).append(",").append(tSSRS1.GetText(i, 1)).toString();
					ContRiskMap.put(tSSRS1.GetText(i, 3), tRiskCode);
				} else
				{
					ContRiskMap.put(tSSRS1.GetText(i, 3), tSSRS1.GetText(i, 1));
				}

		}
		System.out.println("-----------------------------------------------------");
		Set set = ContRiskMap.entrySet();
		java.util.Map.Entry entry;
		for (Iterator it = set.iterator(); it.hasNext(); System.out.println((new StringBuilder("保单险种映射:")).append((String)entry.getKey()).append("--:--").append((String)entry.getValue()).toString()))
			entry = (java.util.Map.Entry)it.next();

	}

	private String editSql()
	{
		String sql = "";
		if (queryContSch.getContNo() != null && !queryContSch.getContNo().equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.contno like '%").append(queryContSch.getContNo().toUpperCase()).append("%' ").toString();
		if (state != null && !state.equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.state = '").append(state).append("' ").toString();
		if (queryContSch.getInsuredName() != null && !queryContSch.getInsuredName().equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.insuredname like '%").append(queryContSch.getInsuredName()).append("%' ").toString();
		if (queryContSch.getInsuredIDNo() != null && !queryContSch.getInsuredIDNo().equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.insuredidno like '%").append(queryContSch.getInsuredIDNo()).append("%' ").toString();
		if (startDate != null && !startDate.equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.makedate >= '").append(startDate).append("' ").toString();
		if (endDate != null && !endDate.equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.makedate <= '").append(endDate).append("' ").toString();
		if (manageCom != null && !"".equals(manageCom))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.managecom = '").append(manageCom.toUpperCase()).append("'").toString();
		if (entryUserID != null && !entryUserID.equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.contno in (select d.contno from lnpcont d where d.inputoperator = '").append(entryUserID).append("' and d.state='01' ").append("union ").append("select e.contno from LNPOperationRecord e ").append("where e.Operatorcode='").append(entryUserID).append("'").append("and  e.id=(select min(f.id) from LNPOperationRecord f where f.Varc2='02' and f.contno = e.contno ))").toString();
		if (auditUserID != null && !auditUserID.equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.contno in (select contno from lnpcont  where inputoperator = '").append(auditUserID).append("'  and state <>'01')").toString();
		if (kindcode != null && !kindcode.equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.contno in (select contno from lnppol where KindCode = '").append(kindcode).append("')").toString();
		if (riskcode != null && !riskcode.equals(""))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.contno in (select contno from lnppol where riskcode like '%").append(riskcode).append("%' and subflag='M')").toString();
		return sql;
	}

	public boolean isLock()
	{
		return lock;
	}

	public void setLock(boolean lock)
	{
		this.lock = lock;
	}

	public void goToEdit()
	{
		Boolean queryflag = Boolean.valueOf(true);
		System.out.println("++++++进入gotoedit");
		try
		{
			Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			contNo = (String)requestMap.get("chooseContNo");
			LNPContSchema lnpContSch = getMyLNPContByContNo(contNo);
			String date = PubFun.getCurrentDate();
			String time = PubFun.getCurrentTime();
			System.out.println((new StringBuilder("----页面跳转contNo")).append(contNo).append("----").toString());
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
			session.setAttribute("ContNo", contNo);
			if (tempGI.LNPRole == "0" || tempGI.LNPRole.equals("0"))
				if (lnpContSch.getState().equals("01"))
					queryflag = Boolean.valueOf(true);
				else
					queryflag = Boolean.valueOf(false);
			if (tempGI.LNPRole == "1" || tempGI.LNPRole.equals("1"))
				if (lnpContSch.getState().equals("01") || lnpContSch.getState().equals("05") || lnpContSch.getState().equals("06"))
					queryflag = Boolean.valueOf(false);
				else
					queryflag = Boolean.valueOf(true);
			if (tempGI.LNPRole == "2" || tempGI.LNPRole.equals("2"))
				if (lnpContSch.getState().equals("05") || lnpContSch.getState().equals("06"))
					queryflag = Boolean.valueOf(false);
				else
					queryflag = Boolean.valueOf(true);
			session.setAttribute("Queryflag", queryflag);
			System.out.println((new StringBuilder("显示当前是否可编辑的状态")).append(queryflag).toString());
			if (queryflag.booleanValue())
			{
				System.out.println((new StringBuilder("contno的值为----------")).append(contNo).toString());
				String sqlTemp = (new StringBuilder("select AgentCode from lnpcont where contno='")).append(contNo).append("'").toString();
				ExeSQL tempExe = new ExeSQL();
				SSRS tempSSRS = tempExe.execSQL(sqlTemp);
				if (tempSSRS.GetText(1, 1) != null && !tempSSRS.GetText(1, 1).equals(""))
				{
					if (tempGI.Operator.equals(tempSSRS.GetText(1, 1)))
					{
						lock = false;
						sqlTemp = (new StringBuilder("select top 20 sessionid from MWebLoginLog where usercode='")).append(tempGI.Operator).append("' order by id desc").toString();
						SSRS tempSSRS2 = tempExe.execSQL(sqlTemp);
						for (int i = 2; i < tempSSRS2.MaxRow; i++)
						{
							if (!MainListener.sessionMap.containsKey(tempSSRS2.GetText(i, 1)))
								break;
							((HttpSession)MainListener.sessionMap.get(tempSSRS2.GetText(i, 1))).setAttribute("CONTLOCK", "UNLOCKED");
						}

						policyState = new BankPolicyState();
						policyState.savePolicyState(contNo, lnpContSch.getState(), "2", date, time);
					} else
					{
						lock = true;
						ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", (new StringBuilder("当前单被")).append(tempSSRS.GetText(1, 1)).append("用户使用！").toString());
					}
				} else
				{
					System.out.println("此时保单未被加锁");
					policyState = new BankPolicyState();
					policyState.savePolicyState(contNo, lnpContSch.getState(), "2", date, time);
					lock = false;
				}
				System.out.println((new StringBuilder("当前lock的值=======")).append(lock).toString());
				if (!lock)
				{
					lnpContSch.setAgentCode(tempGI.Operator);
					PubSubmit ps = new PubSubmit();
					MMap map = new MMap();
					map.put(lnpContSch, "UPDATE");
					VData vd = new VData();
					vd.add(map);
					if (!ps.submitData(vd, ""))
					{
						System.out.println("编辑人员保存失败");
						ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "编辑人员保存失败！");
					} else
					{
						System.out.println("编辑人员保存成功");
					}
					session.setAttribute("CONTLOCK", "LOCKED");
				}
				MainListener.sessionMap.put(session.getId(), session);
			} else
			{
				lock = false;
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
	}

	private LNPContSchema getMyLNPContByContNo(String contNo2)
	{
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contNo2);
		return aLNPContSchema;
	}

	public void RemovePolicy()
	{
		String curDate;
		String curTime;
		VData cInputData;
		MMap mMap;
		PubSubmit pubSubmit;
		Connection conn;
		System.out.println((new StringBuilder("will remove policy:")).append(rmvPolicy).append("|state:").append(rmvState).toString());
		if ("06".equals(rmvState))
			break MISSING_BLOCK_LABEL_2854;
		curDate = PubFun.getCurrentDate();
		curTime = PubFun.getCurrentTime();
		cInputData = new VData();
		mMap = new MMap();
		pubSubmit = new PubSubmit();
		conn = null;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch (ClassNotFoundException e1)
		{
			e1.printStackTrace();
			return;
		}
		if (conn == null)
			try
			{
				conn = DriverManager.getConnection("jdbc:sqlserver://mdes-D.metlifechina.local\\SQLEXPRESS:1433;databasename=MDES", "mdesadmin", "password1");
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
				CError.buildErr(this, "数据库连接失败");
				return;
			}
		SysMaxNoMAPNP maxNoMap;
		String serialNumber;
		conn.setAutoCommit(false);
		maxNoMap = new SysMaxNoMAPNP();
		serialNumber = maxNoMap.CreateMaxNo1(conn, "OPERTRACENO", "");
		if (serialNumber == null)
		{
			conn.rollback();
			conn.close();
			return;
		}
		try
		{
			LNPContDB tLnpContDB = new LNPContDB(conn);
			String sql = (new StringBuilder("select * from LNPCont where ContNo='")).append(rmvPolicy).append("'").toString();
			LNPContSet tLnpContSet = tLnpContDB.executeQuery(sql);
			LNPContBSet tLnpContBSet = new LNPContBSet();
			LNPContBSchema tLnpContBSchema = new LNPContBSchema();
			tLnpContBSet.add(tLnpContBSchema);
			Reflections reflections = new Reflections();
			reflections.transFields(tLnpContBSet, tLnpContSet);
			for (int i = 1; i <= tLnpContBSet.size(); i++)
			{
				tLnpContBSet.get(i).setEdorNo(serialNumber);
				tLnpContBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			tLnpContBSchema.setEdorNo(serialNumber);
			mMap.put(tLnpContSet, "DELETE");
			mMap.put(tLnpContBSet, "INSERT");
			LNPPolDB tLNPPolDB = new LNPPolDB(conn);
			sql = (new StringBuilder("select * from LNPPol where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPPolSet tLnpPolSet = tLNPPolDB.executeQuery(sql);
			LNPPolBSet tLnpPolBSet = new LNPPolBSet();
			LNPPolBSchema tLnpPolBSchema = new LNPPolBSchema();
			tLnpPolBSet.add(tLnpPolBSchema);
			reflections.transFields(tLnpPolBSet, tLnpPolSet);
			for (int i = 1; i <= tLnpPolBSet.size(); i++)
			{
				tLnpPolBSet.get(i).setEdorNo(serialNumber);
				tLnpPolBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tLnpPolSet, "DELETE");
			mMap.put(tLnpPolBSet, "INSERT");
			LNPBonusInfoDB tLnpBonusInfoDB = new LNPBonusInfoDB(conn);
			sql = (new StringBuilder("select * from LNPBonusInfo where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPBonusInfoSet tBonusInfoSet = tLnpBonusInfoDB.executeQuery(sql);
			LNPBonusInfoBSet tBonusInfoBSet = new LNPBonusInfoBSet();
			LNPBonusInfoBSchema tLnpBonusInfoBSchema = new LNPBonusInfoBSchema();
			tBonusInfoBSet.add(tLnpBonusInfoBSchema);
			reflections.transFields(tBonusInfoBSet, tBonusInfoSet);
			for (int i = 1; i <= tBonusInfoBSet.size(); i++)
			{
				tBonusInfoBSet.get(i).setEdorNo(serialNumber);
				tBonusInfoBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tBonusInfoSet, "DELETE");
			mMap.put(tBonusInfoBSet, "INSERT");
			LNPRiskAmountDB tLnpRiskAmountDB = new LNPRiskAmountDB(conn);
			sql = (new StringBuilder("select * from LNPRiskAmount where contno='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPRiskAmountSet tLnpRiskAmountSet = tLnpRiskAmountDB.executeQuery(sql);
			LNPRiskAmountBSet tLnpRiskAmountBSet = new LNPRiskAmountBSet();
			LNPRiskAmountBSchema tlnpRiskAmountBSchema = new LNPRiskAmountBSchema();
			tLnpRiskAmountBSet.add(tlnpRiskAmountBSchema);
			reflections.transFields(tLnpRiskAmountBSet, tLnpRiskAmountSet);
			for (int i = 1; i <= tLnpRiskAmountBSet.size(); i++)
			{
				tLnpRiskAmountBSet.get(i).setEdorNo(serialNumber);
				tLnpRiskAmountBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tLnpRiskAmountSet, "DELETE");
			mMap.put(tLnpRiskAmountBSet, "INSERT");
			LNPInvestmentInfoDB tInvestmentInfoDB = new LNPInvestmentInfoDB(conn);
			sql = (new StringBuilder("select * from LNPInvestmentInfo where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPInvestmentInfoSet tlnpLnpInvestmentInfoSet = tInvestmentInfoDB.executeQuery(sql);
			LNPInvestmentInfoBSet tlnpInvestmentInfoBSet = new LNPInvestmentInfoBSet();
			LNPInvestmentInfoBSchema tlnpLnpInvestmentInfoBSchema = new LNPInvestmentInfoBSchema();
			tlnpInvestmentInfoBSet.add(tlnpLnpInvestmentInfoBSchema);
			reflections.transFields(tlnpInvestmentInfoBSet, tlnpLnpInvestmentInfoSet);
			for (int i = 1; i <= tlnpInvestmentInfoBSet.size(); i++)
			{
				tlnpInvestmentInfoBSet.get(i).setEdorNo(serialNumber);
				tlnpInvestmentInfoBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tlnpLnpInvestmentInfoSet, "DELETE");
			mMap.put(tlnpInvestmentInfoBSet, "INSERT");
			LNPInvestmentAccountInfoDB tlnpInvestmentAccountInfoDB = new LNPInvestmentAccountInfoDB(conn);
			sql = (new StringBuilder("select * from LNPInvestmentAccountInfo where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPInvestmentAccountInfoSet tlnpiLnpInvestmentAccountInfoSet = tlnpInvestmentAccountInfoDB.executeQuery(sql);
			LNPInvestmentAccountInfoBSet tLnpInvestmentAccountInfoBSet = new LNPInvestmentAccountInfoBSet();
			LNPInvestmentAccountInfoBSchema tlnLnpInvestmentAccountInfoBSchema = new LNPInvestmentAccountInfoBSchema();
			tLnpInvestmentAccountInfoBSet.add(tlnLnpInvestmentAccountInfoBSchema);
			reflections.transFields(tLnpInvestmentAccountInfoBSet, tlnpiLnpInvestmentAccountInfoSet);
			for (int i = 1; i <= tLnpInvestmentAccountInfoBSet.size(); i++)
			{
				tLnpInvestmentAccountInfoBSet.get(i).setEdorNo(serialNumber);
				tLnpInvestmentAccountInfoBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tlnpiLnpInvestmentAccountInfoSet, "DELETE");
			mMap.put(tLnpInvestmentAccountInfoBSet, "INSERT");
			LNPAppntDB tLnpAppntDB = new LNPAppntDB(conn);
			sql = (new StringBuilder("select * from LNPAppnt where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPAppntSet tLnpAppntSet = tLnpAppntDB.executeQuery(sql);
			LNPAppntBSet tlnpAppntBSet = new LNPAppntBSet();
			LNPAppntBSchema tlnAppntBSchema = new LNPAppntBSchema();
			tlnpAppntBSet.add(tlnAppntBSchema);
			reflections.transFields(tlnpAppntBSet, tLnpAppntSet);
			for (int i = 1; i <= tlnpAppntBSet.size(); i++)
			{
				tlnpAppntBSet.get(i).setEdorNo(serialNumber);
				tlnpAppntBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tLnpAppntSet, "DELETE");
			mMap.put(tlnpAppntBSet, "INSERT");
			LNPInsuredDB tLnpInsuredDB = new LNPInsuredDB(conn);
			sql = (new StringBuilder("select * from LNPInsured where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPInsuredSet tlnInsuredSet = tLnpInsuredDB.executeQuery(sql);
			LNPInsuredBSet tlnpInsuredBSet = new LNPInsuredBSet();
			LNPInsuredBSchema tlnLnpInsuredBSchema = new LNPInsuredBSchema();
			tlnpInsuredBSet.add(tlnLnpInsuredBSchema);
			reflections.transFields(tlnpInsuredBSet, tlnInsuredSet);
			for (int i = 1; i <= tlnpInsuredBSet.size(); i++)
			{
				tlnpInsuredBSet.get(i).setEdorNo(serialNumber);
				tlnpInsuredBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tlnInsuredSet, "DELETE");
			mMap.put(tlnpInsuredBSet, "INSERT");
			LNPBnfDB tlnpbBnfDB = new LNPBnfDB(conn);
			sql = (new StringBuilder("select * from LNPBnf where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPBnfSet tlnpbBnfSet = tlnpbBnfDB.executeQuery(sql);
			LNPBnfBSet tLnpBnfBSet = new LNPBnfBSet();
			LNPBnfBSchema tlnBnfBSchema = new LNPBnfBSchema();
			tLnpBnfBSet.add(tlnBnfBSchema);
			reflections.transFields(tLnpBnfBSet, tlnpbBnfSet);
			for (int i = 1; i <= tLnpBnfBSet.size(); i++)
			{
				tLnpBnfBSet.get(i).setEdorNo(serialNumber);
				tLnpBnfBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tlnpbBnfSet, "DELETE");
			LNPPersonDB tlnLnpPersonDB = new LNPPersonDB(conn);
			sql = (new StringBuilder("select * from LNPPerson b where exists (select 1 from LNPAppnt a where a.AppntId=b.CustomerId and a.ContNo='")).append(rmvPolicy).append("')").append("union all select * from LNPPerson b where exists (select 1 from LNPInsured a where a.InsuredId=b.CustomerId and a.ContNo='").append(rmvPolicy).append("')").toString();
			com.sinosoft.banklns.lis.vschema.LNPPersonSet tlnLnpPersonSet = tlnLnpPersonDB.executeQuery(sql);
			LNPPersonBSet tlnLnpPersonBSet = new LNPPersonBSet();
			LNPPersonBSchema tlnLnpPersonBSchema = new LNPPersonBSchema();
			tlnLnpPersonBSet.add(tlnLnpPersonBSchema);
			reflections.transFields(tlnLnpPersonBSet, tlnLnpPersonSet);
			for (int i = 1; i <= tlnLnpPersonBSet.size(); i++)
			{
				tlnLnpPersonBSet.get(i).setEdorNo(serialNumber);
				tlnLnpPersonBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tlnLnpPersonSet, "DELETE");
			mMap.put(tlnLnpPersonBSet, "INSERT");
			LNPAddressDB tLnpAddressDB = new LNPAddressDB(conn);
			sql = (new StringBuilder("select * from LNPAddress b where exists(select 1 from LNPAppnt a where a.AppntId=b.CustomerId and a.ContNo='")).append(rmvPolicy).append("')").append("union all select * from LNPAddress b where exists(select 1 from LNPInsured a where a.InsuredId=b.CustomerId and a.ContNo='").append(rmvPolicy).append("')").toString();
			com.sinosoft.banklns.lis.vschema.LNPAddressSet tLnpAddressSet = tLnpAddressDB.executeQuery(sql);
			LNPAddressBSet tLnpAddressBSet = new LNPAddressBSet();
			LNPAddressBSchema tLnpAddressBSchema = new LNPAddressBSchema();
			tLnpAddressBSet.add(tLnpAddressBSchema);
			reflections.transFields(tLnpAddressBSet, tLnpAddressSet);
			for (int i = 1; i <= tLnpAddressBSet.size(); i++)
			{
				tLnpAddressBSet.get(i).setEdorNo(serialNumber);
				tLnpAddressBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tLnpAddressSet, "DELETE");
			mMap.put(tLnpAddressBSet, "INSERT");
			LNPCustImpResultDB tLnpCustImpResultDB = new LNPCustImpResultDB(conn);
			sql = (new StringBuilder("select * from LNPCustImpResult where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet tCustImpResultSet = tLnpCustImpResultDB.executeQuery(sql);
			LNPCustImpResultBSet tLnpCustImpResultBSet = new LNPCustImpResultBSet();
			LNPCustImpResultBSchema tCustImpResultBSchema = new LNPCustImpResultBSchema();
			tLnpCustImpResultBSet.add(tCustImpResultBSchema);
			reflections.transFields(tLnpCustImpResultBSet, tCustImpResultSet);
			for (int i = 1; i <= tLnpCustImpResultBSet.size(); i++)
			{
				tLnpCustImpResultBSet.get(i).setEdorNo(serialNumber);
				tLnpCustImpResultBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tCustImpResultSet, "DELETE");
			mMap.put(tLnpCustImpResultBSet, "INSERT");
			LNPPaymentDB tLnpPaymentDB = new LNPPaymentDB(conn);
			sql = (new StringBuilder("select * from LNPPayment where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPPaymentSet tLnpPaymentSet = tLnpPaymentDB.executeQuery(sql);
			LNPPaymentBSet tLnpPaymentBSet = new LNPPaymentBSet();
			LNPPaymentBSchema tLnpPaymentBSchema = new LNPPaymentBSchema();
			tLnpPaymentBSet.add(tLnpPaymentBSchema);
			reflections.transFields(tLnpPaymentBSet, tLnpPaymentSet);
			for (int i = 1; i <= tLnpPaymentBSet.size(); i++)
			{
				tLnpPaymentBSet.get(i).setEdorNo(serialNumber);
				tLnpPaymentBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tLnpPaymentSet, "DELETE");
			LNPAgentInfoDB tLnpAgentInfoDB = new LNPAgentInfoDB(conn);
			sql = (new StringBuilder("select * from LNPAgentInfo where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet tLnpAgentInfoSet = tLnpAgentInfoDB.executeQuery(sql);
			LNPAgentInfoBSet tLnpAgentInfoBSet = new LNPAgentInfoBSet();
			LNPAgentInfoBSchema tLnpAgentInfoBSchema = new LNPAgentInfoBSchema();
			tLnpAgentInfoBSet.add(tLnpAgentInfoBSchema);
			reflections.transFields(tLnpAgentInfoBSet, tLnpAgentInfoSet);
			for (int i = 1; i <= tLnpAgentInfoBSet.size(); i++)
			{
				tLnpAgentInfoBSet.get(i).setEdorNo(serialNumber);
				tLnpAgentInfoBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tLnpAgentInfoSet, "DELETE");
			mMap.put(tLnpAgentInfoBSet, "INSERT");
			LNPOperationRecordDB tLnpOperationRecordDB = new LNPOperationRecordDB(conn);
			sql = (new StringBuilder("select * from LNPOperationRecord where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPOperationRecordSet tLnpOperationRecordSet = tLnpOperationRecordDB.executeQuery(sql);
			LNPOperationRecordBSet tOperationRecordBSet = new LNPOperationRecordBSet();
			LNPOperationRecordBSchema tLnpOperationRecordBSchema = new LNPOperationRecordBSchema();
			tOperationRecordBSet.add(tLnpOperationRecordBSchema);
			reflections.transFields(tOperationRecordBSet, tLnpOperationRecordSet);
			for (int i = 1; i <= tOperationRecordBSet.size(); i++)
			{
				tOperationRecordBSet.get(i).setEdorNo(serialNumber);
				tOperationRecordBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tLnpOperationRecordSet, "DELETE");
			mMap.put(tOperationRecordBSet, "INSERT");
			LNPCUWMasterDB tLnpcuwMasterDB = new LNPCUWMasterDB(conn);
			sql = (new StringBuilder("select * from LNPCUWMaster where ContNo='")).append(rmvPolicy).append("'").toString();
			com.sinosoft.banklns.lis.vschema.LNPCUWMasterSet tLnpcuwMasterSet = tLnpcuwMasterDB.executeQuery(sql);
			LNPCUWMasterBSet tLnpcuwMasterBSet = new LNPCUWMasterBSet();
			LNPCUWMasterBSchema tLnpcuwMasterBSchema = new LNPCUWMasterBSchema();
			tLnpcuwMasterBSet.add(tLnpcuwMasterBSchema);
			reflections.transFields(tLnpcuwMasterBSet, tLnpcuwMasterSet);
			for (int i = 1; i <= tLnpcuwMasterBSet.size(); i++)
			{
				tLnpcuwMasterBSet.get(i).setEdorNo(serialNumber);
				tLnpcuwMasterBSet.get(i).setserialNo(maxNoMap.CreateMaxNo("FANDIIMPREID", ""));
			}

			mMap.put(tLnpcuwMasterSet, "DELETE");
			mMap.put(tLnpcuwMasterBSet, "INSERT");
			LNPTransRcorsSchema tLnpTransRcorsSchema = new LNPTransRcorsSchema();
			tLnpTransRcorsSchema.setEdorNo(serialNumber);
			tLnpTransRcorsSchema.setserialNo(serialNumber);
			tLnpTransRcorsSchema.setContNo(rmvPolicy);
			tLnpTransRcorsSchema.setOperator(tempGI.Operator);
			tLnpTransRcorsSchema.setMakeDate(curDate);
			tLnpTransRcorsSchema.setMakeTime(curTime);
			mMap.put(tLnpTransRcorsSchema, "INSERT");
			cInputData.add(mMap);
			pubSubmit.conn = conn;
			if (!pubSubmit.submitData(cInputData, ""))
			{
				System.out.println("删除投保书出错~");
				throw new Exception("删除投保书出错~");
			}
			System.out.println((new StringBuilder("have removed policy:")).append(rmvPolicy).toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void view()
	{
	}

	public void repeatLnp()
	{
	}

	public void repairLnp()
	{
	}

	public void suggestToInsurance()
	{
	}

	public List getLnpList()
	{
		return lnpList;
	}

	public void setLnpList(List lnpList)
	{
		this.lnpList = lnpList;
	}

	public LNPContSchema getQueryContSch()
	{
		return queryContSch;
	}

	public void setQueryContSch(LNPContSchema queryContSch)
	{
		this.queryContSch = queryContSch;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getEndDate()
	{
		return formatDate(endDate, "YYYYMMDD");
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public String getStartDate()
	{
		return formatDate(startDate, "YYYYMMDD");
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
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

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
	}

	public String getPrem()
	{
		return prem;
	}

	public void setPrem(String prem)
	{
		this.prem = prem;
	}

	public boolean isShowErrorFlag()
	{
		return showErrorFlag;
	}

	public void setShowErrorFlag(boolean showErrorFlag)
	{
		this.showErrorFlag = showErrorFlag;
	}

	public String getRmvPolicy()
	{
		return rmvPolicy;
	}

	public void setRmvPolicy(String rmvPolicy)
	{
		this.rmvPolicy = rmvPolicy;
	}

	public String getRmvState()
	{
		return rmvState;
	}

	public void setRmvState(String rmvState)
	{
		this.rmvState = rmvState;
	}

	public boolean isCancelAbilityFlag()
	{
		return cancelAbilityFlag;
	}

	public void setCancelAbilityFlag(boolean cancelAbilityFlag)
	{
		this.cancelAbilityFlag = cancelAbilityFlag;
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

	private static void initContStateMap()
	{
		ContStateMap.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='lnpLangState'";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			ContStateMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	public static void main(String args[])
	{
		InsuranceQuery i = new InsuranceQuery();
		i.setRmvPolicy("200141231231");
		i.setRmvState("03");
		IGlobalInput gi = new IGlobalInput();
		gi.Operator = "Dadmin";
		i.tempGI = gi;
		i.RemovePolicy();
	}

}
