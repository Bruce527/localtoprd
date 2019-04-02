// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankPending.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.lis.excel.*;
import com.sinosoft.map.lis.pubfun.PubFun;
import java.io.*;
import java.util.ArrayList;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BankPending
{
	/* member class not found */
	class AuditPendingQueryTableBean {}


	private String state;
	private String auditStartDate;
	private String auditEndDate;
	private String inputStartDate;
	private String inputEndDate;
	private String excelPath;
	private ArrayList lnpList;
	private boolean dataNullFlag;
	private boolean showErrorFlag;
	private String filename;
	private String data[][];
	private ExeSQL exsql;
	private IGlobalInput tempGI;
	private String sql;

	public BankPending()
	{
		lnpList = new ArrayList();
		dataNullFlag = false;
		showErrorFlag = false;
		exsql = new ExeSQL();
	}

	public boolean isDataNullFlag()
	{
		return dataNullFlag;
	}

	public void setDataNullFlag(boolean dataNullFlag)
	{
		this.dataNullFlag = dataNullFlag;
	}

	public boolean isShowErrorFlag()
	{
		return showErrorFlag;
	}

	public void setShowErrorFlag(boolean showErrorFlag)
	{
		this.showErrorFlag = showErrorFlag;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public void init()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
	}

	public ArrayList getLnpList()
	{
		return lnpList;
	}

	public void setLnpList(ArrayList resultList)
	{
		lnpList = resultList;
	}

	public String getAuditStartDate()
	{
		return auditStartDate;
	}

	public void setAuditStartDate(String auditStartDate)
	{
		this.auditStartDate = auditStartDate;
	}

	public String getAuditEndDate()
	{
		return auditEndDate;
	}

	public void setAuditEndDate(String auditEndDate)
	{
		this.auditEndDate = auditEndDate;
	}

	public String getInputStartDate()
	{
		return inputStartDate;
	}

	public void setInputStartDate(String inputStartDate)
	{
		this.inputStartDate = inputStartDate;
	}

	public String getInputEndDate()
	{
		return inputEndDate;
	}

	public void setInputEndDate(String inputEndDate)
	{
		this.inputEndDate = inputEndDate;
	}

	public String getExcelPath()
	{
		return excelPath;
	}

	public void setExcelPath(String excelPath)
	{
		this.excelPath = excelPath;
	}

	public void query()
	{
		if (!lnpList.isEmpty())
			lnpList.clear();
		sql = (new StringBuilder(" b.codename,a.contno,c.operationdate,d.operationdate,e.branchattr,e.agentcode,j.codename,f.payment1,h.riskcode,c.OperatorCode from lnpcont a left join lnpcode b on b.code=a.managecom and b.codetype='lnpManageCom' left join (select min(r.OperationDate) as OperationDate,r.contno,r.OperatorCode as OperatorCode from LNPOperationRecord r where r.Varc2='01' and r.OperatorType='2' group by r.contno,r.OperatorCode) c on c.contno=a.contno left join (select min(p.OperationDate) as OperationDate,p.contno from LNPOperationRecord p where p.Varc2='02' and  p.OperatorType='2' group by p.contno) d on d.contno=a.contno left join lnpAgentInfo e on e.contno=a.contno left join LNPPayment f on f.contno=a.contno left join lnppol h on h.contno=a.contno and h.polno=h.masterpolno left join lnpcode j on j.code=a.state and j.codetype='lnpLangState' where a.managecom like '")).append(tempGI.ManageCom).append("%' ").toString();
		if (state == "-1" || state.equals("-1")) goto _L2; else goto _L1
_L1:
		if (!"0".equals(state) && state != "0") goto _L4; else goto _L3
_L3:
		this;
		sql;
		JVM INSTR new #128 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" and a.state='01'";
		append();
		toString();
		sql;
_L4:
		if (!"1".equals(state) && state != "1") goto _L6; else goto _L5
_L5:
		this;
		sql;
		JVM INSTR new #128 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" and a.state in('02','03','04','05')";
		append();
		toString();
		sql;
_L6:
		if (!"2".equals(state) && state != "2") goto _L8; else goto _L7
_L7:
		this;
		sql;
		JVM INSTR new #128 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" and a.state='07'";
		append();
		toString();
		sql;
		  goto _L8
_L2:
		this;
		sql;
		JVM INSTR new #128 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" and a.state <> '06'";
		append();
		toString();
		sql;
_L8:
		if (auditStartDate == null || "".equals(auditStartDate)) goto _L10; else goto _L9
_L9:
		this;
		sql;
		JVM INSTR new #128 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		"and d.operationdate>='";
		append();
		auditStartDate;
		append();
		"' ";
		append();
		toString();
		sql;
_L10:
		if (auditEndDate == null || "".equals(auditEndDate)) goto _L12; else goto _L11
_L11:
		this;
		sql;
		JVM INSTR new #128 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		"and d.operationdate<='";
		append();
		auditEndDate;
		append();
		"' ";
		append();
		toString();
		sql;
_L12:
		if (inputStartDate == null || "".equals(inputStartDate)) goto _L14; else goto _L13
_L13:
		this;
		sql;
		JVM INSTR new #128 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		"and c.operationdate>='";
		append();
		inputStartDate;
		append();
		"' ";
		append();
		toString();
		sql;
_L14:
		if (inputEndDate == null || "".equals(inputEndDate)) goto _L16; else goto _L15
_L15:
		this;
		sql;
		JVM INSTR new #128 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		"and c.operationdate<='";
		append();
		inputEndDate;
		append();
		"' ";
		append();
		toString();
		sql;
_L16:
		this;
		sql;
		JVM INSTR new #128 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		"order by a.contno";
		append();
		toString();
		sql;
		lnpList.clear();
		querySql((new StringBuilder("select top 200")).append(sql).toString(), false);
		return;
	}

	public void report()
	{
		excelPath = printReportList();
	}

	public String printReportList()
	{
		boolean flag = true;
		String currentDate = PubFun.getCurrentDate();
		String templetFileName = "AuditPendingQuery.xls";
		String reportFileName = (new StringBuilder(String.valueOf(tempGI.ManageCom))).append("_").append("auditPendingQuery_").append(tempGI.Operator).append("_").append(currentDate).append(".xls").toString();
		filename = reportFileName;
		long usefullLifeSec = 0L;
		String rvFNStartWith = (new StringBuilder(String.valueOf(tempGI.ManageCom))).append("_").append("auditPendingQuery").toString();
		long invalidationSec = usefullLifeSec * 2L;
		ReportHelper helper = new ReportHelper(templetFileName, reportFileName, usefullLifeSec, rvFNStartWith, invalidationSec);
		ExcelInfo info = helper.getInfo();
		if (!info.exists())
			flag = getPrintData(helper);
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

	private boolean getPrintData(ReportHelper helper)
	{
		SimpleWorkbook workbook;
		if ("".equals(sql) || sql == null)
			return false;
		data = null;
		querySql((new StringBuilder("select ")).append(sql).toString(), true);
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
		catch (Exception exception)
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
		break MISSING_BLOCK_LABEL_155;
		Exception exception1;
		exception1;
		if (workbook != null)
			try
			{
				workbook.close();
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		throw exception1;
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

	private void querySql(String sql, boolean isExcelExport)
	{
		SSRS ssrs = exsql.execSQL(sql);
		System.out.println(sql);
		if (ssrs.MaxRow <= 0)
			dataNullFlag = true;
		else
			dataNullFlag = false;
		if (!isExcelExport)
		{
			for (int i = 0; i < ssrs.MaxRow; i++)
			{
				AuditPendingQueryTableBean bean = new AuditPendingQueryTableBean();
				AuditPendingQueryTableBean.access.0(bean, ssrs.GetText(i + 1, 1));
				AuditPendingQueryTableBean.access.1(bean, ssrs.GetText(i + 1, 2));
				AuditPendingQueryTableBean.access.2(bean, ssrs.GetText(i + 1, 3));
				AuditPendingQueryTableBean.access.3(bean, ssrs.GetText(i + 1, 4));
				AuditPendingQueryTableBean.access.4(bean, ssrs.GetText(i + 1, 5));
				AuditPendingQueryTableBean.access.5(bean, ssrs.GetText(i + 1, 6));
				AuditPendingQueryTableBean.access.6(bean, ssrs.GetText(i + 1, 7));
				AuditPendingQueryTableBean.access.7(bean, ssrs.GetText(i + 1, 8));
				AuditPendingQueryTableBean.access.8(bean, ssrs.GetText(i + 1, 9));
				AuditPendingQueryTableBean.access.9(bean, ssrs.GetText(i + 1, 10));
				if (i < ssrs.MaxRow - 1 && ssrs.GetText(i + 1, 2).equals(ssrs.GetText(i + 2, 2)))
				{
					if (!ssrs.GetText(i + 1, 6).equals(ssrs.GetText(i + 2, 6)))
						AuditPendingQueryTableBean.access.5(bean, (new StringBuilder(String.valueOf(AuditPendingQueryTableBean.access.10(bean)))).append(",").append(ssrs.GetText(i + 2, 6)).toString());
					if (!ssrs.GetText(i + 1, 5).equals(ssrs.GetText(i + 2, 5)))
						AuditPendingQueryTableBean.access.4(bean, (new StringBuilder(String.valueOf(AuditPendingQueryTableBean.access.11(bean)))).append(",").append(ssrs.GetText(i + 2, 5)).toString());
					i++;
				}
				lnpList.add(bean);
				showErrorFlag = false;
				if (lnpList.size() < 200)
					continue;
				showErrorFlag = true;
				break;
			}

		} else
		{
			data = new String[ssrs.MaxRow][10];
			int i = 0;
			for (int j = 0; i < ssrs.MaxRow; j++)
			{
				data[j][0] = ssrs.GetText(i + 1, 1);
				data[j][1] = ssrs.GetText(i + 1, 2);
				data[j][2] = ssrs.GetText(i + 1, 3);
				data[j][3] = ssrs.GetText(i + 1, 4);
				data[j][4] = ssrs.GetText(i + 1, 5);
				data[j][5] = ssrs.GetText(i + 1, 6);
				data[j][6] = ssrs.GetText(i + 1, 7);
				data[j][7] = ssrs.GetText(i + 1, 8);
				data[j][8] = ssrs.GetText(i + 1, 9);
				data[j][9] = ssrs.GetText(i + 1, 10);
				if (i < ssrs.MaxRow - 1 && ssrs.GetText(i + 1, 2).equals(ssrs.GetText(i + 2, 2)))
				{
					if (!ssrs.GetText(i + 1, 6).equals(ssrs.GetText(i + 2, 6)))
						data[j][5] = (new StringBuilder(String.valueOf(data[j][5]))).append(",").append(ssrs.GetText(i + 2, 6)).toString();
					if (!ssrs.GetText(i + 1, 5).equals(ssrs.GetText(i + 2, 5)))
						data[j][4] = (new StringBuilder(String.valueOf(data[j][4]))).append(",").append(ssrs.GetText(i + 2, 5)).toString();
					i++;
				}
				i++;
			}

		}
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
}
