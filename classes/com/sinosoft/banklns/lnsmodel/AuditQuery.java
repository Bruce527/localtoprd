// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AuditQuery.java

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

public class AuditQuery
{
	public class AuditQueryTableBean
	{

		private String manageCom;
		private String auditDate;
		private String auditStartDate;
		private String auditEndDate;
		private String auditUser;
		private String contNo;
		private String mainPolNo;
		private String inputDate;
		private String inputStartDate;
		private String inputEndDate;
		final AuditQuery this$0;

		public String getInputDate()
		{
			return inputDate;
		}

		public void setInputDate(String inputDate)
		{
			this.inputDate = inputDate;
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

		public String getContNo()
		{
			return contNo;
		}

		public void setContNo(String contNo)
		{
			this.contNo = contNo;
		}

		public String getManageCom()
		{
			return manageCom;
		}

		public void setManageCom(String manageCom)
		{
			this.manageCom = manageCom;
		}

		public String getAuditDate()
		{
			return auditDate;
		}

		public void setAuditDate(String auditDate)
		{
			this.auditDate = auditDate;
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

		public String getAuditUser()
		{
			return auditUser;
		}

		public void setAuditUser(String auditUser)
		{
			this.auditUser = auditUser;
		}

		public String getMainPolNo()
		{
			return mainPolNo;
		}

		public void setMainPolNo(String mainPolNo)
		{
			this.mainPolNo = mainPolNo;
		}











		public AuditQueryTableBean()
		{
			this$0 = AuditQuery.this;
			super();
		}
	}


	private String auditStartDate;
	private String auditEndDate;
	private String inputStartDate;
	private String inputEndDate;
	private String excelPath;
	private ArrayList lnpList;
	private boolean dataNullFlag;
	private String filename;
	private String data[][];
	private ExeSQL exsql;
	private IGlobalInput tempGI;
	private String sql;
	private boolean showErrorFlag;

	public AuditQuery()
	{
		lnpList = new ArrayList();
		dataNullFlag = false;
		exsql = new ExeSQL();
		showErrorFlag = false;
	}

	public boolean isDataNullFlag()
	{
		return dataNullFlag;
	}

	public void setDataNullFlag(boolean dataNullFlag)
	{
		this.dataNullFlag = dataNullFlag;
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
		sql = (new StringBuilder(" ROW_NUMBER() OVER (ORDER BY a.contno) AS [AUTOID], g.codename,op_1.OperationDate,op_2.OperationDate,op_5.OperationDate,op_1.operatorcode,a.contno,c.riskcode,op_3.OperationDate,op_4.OperationDate from lnpcont a left join (select e.OperationDate,e.contno,e.operatorcode from (select max(operationdate) as operationdate,max(id) as id from LNPOperationRecord f where f.Varc2 in('06','07')  and f.operation<>'2' group by f.contno) d,LNPOperationRecord e where d.operationdate=e.operationdate and d.id=e.id) op_1 on op_1.contno=a.contno left join (select min(g.OperationDate+' '+g.OperationTime) as OperationDate,g.contno from LNPOperationRecord g where g.Varc2 in ('03','04')  group by g.contno) op_2 on op_2.contno=a.contno left join (select max(p.OperationDate+' '+p.OperationTime) as OperationDate,p.contno from LNPOperationRecord p where p.Varc2='06' and p.operation<>'2' group by p.contno) op_5 on op_5.contno=a.contno left join (select min(r.OperationDate+' '+r.OperationTime) as OperationDate,r.contno from LNPOperationRecord r where r.Varc2='01'  group by r.contno) op_3 on op_3.contno=a.contno left join (select min(t.OperationDate+' '+t.OperationTime) as OperationDate,t.contno from LNPOperationRecord t where t.Varc2='02' and t.operation<>'2' group by t.contno) op_4 on op_4.contno=a.contno left join lnppol c on c.contno=a.contno and c.SubFlag='M' left join lnpcode g on g.code=a.managecom and g.codetype='lnpManageCom' where a.managecom like '")).append(tempGI.ManageCom).append("%'").toString();
		if (auditStartDate == null || "".equals(auditStartDate)) goto _L2; else goto _L1
_L1:
		this;
		sql;
		JVM INSTR new #121 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" and op_1.OperationDate>='";
		append();
		auditStartDate;
		append();
		"' ";
		append();
		toString();
		sql;
_L2:
		if (auditEndDate == null || "".equals(auditEndDate)) goto _L4; else goto _L3
_L3:
		this;
		sql;
		JVM INSTR new #121 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" and op_1.OperationDate<='";
		append();
		auditEndDate;
		append();
		"' ";
		append();
		toString();
		sql;
_L4:
		if (inputStartDate == null || "".equals(inputStartDate)) goto _L6; else goto _L5
_L5:
		this;
		sql;
		JVM INSTR new #121 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" and substring(op_3.OperationDate,0,11)>='";
		append();
		inputStartDate;
		append();
		"' ";
		append();
		toString();
		sql;
_L6:
		if (inputEndDate == null || "".equals(inputEndDate)) goto _L8; else goto _L7
_L7:
		this;
		sql;
		JVM INSTR new #121 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" and substring(op_3.OperationDate,0,11)<='";
		append();
		inputEndDate;
		append();
		"' ";
		append();
		toString();
		sql;
_L8:
		lnpList.clear();
		querySql((new StringBuilder("select distinct top 200")).append(sql).toString(), false);
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
		String templetFileName = "AuditQuery.xls";
		String reportFileName = (new StringBuilder(String.valueOf(tempGI.ManageCom))).append("_").append("AuditQuery_").append(tempGI.Operator).append("_").append(currentDate).append(".xls").toString();
		filename = reportFileName;
		long usefullLifeSec = 0L;
		String rvFNStartWith = (new StringBuilder(String.valueOf(tempGI.ManageCom))).append("_").append("AuditQuery").toString();
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
		querySql((new StringBuilder("select distinct ")).append(sql).toString(), true);
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
		break MISSING_BLOCK_LABEL_152;
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

	public boolean isShowErrorFlag()
	{
		return showErrorFlag;
	}

	public void setShowErrorFlag(boolean showErrorFlag)
	{
		this.showErrorFlag = showErrorFlag;
	}

	private void querySql(String sql, boolean isExcelExport)
	{
		SSRS ssrs = exsql.execSQL(sql);
		System.out.println(sql);
		if (ssrs.MaxRow >= 200 && !isExcelExport)
		{
			System.out.println("查询记录多于200条，请您细化查询条件！");
			ECPubFun.addErrorMessage("com.sinosoft.map.international.resource.programresource", "查询记录多于200条，请您细化查询条件！");
			showErrorFlag = true;
		} else
		{
			showErrorFlag = false;
		}
		if (ssrs.MaxRow <= 0 && !isExcelExport)
		{
			dataNullFlag = true;
			System.out.println("查询无返回结果,请录入其他查询条件重新查询!");
			ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "查询无返回结果,请录入其他查询条件重新查询!");
		} else
		{
			dataNullFlag = false;
		}
		for (int i = 0; i < ssrs.MaxRow; i++)
			try
			{
				if (!isExcelExport)
				{
					AuditQueryTableBean bean = new AuditQueryTableBean();
					bean.manageCom = ssrs.GetText(i + 1, 2);
					bean.auditDate = ssrs.GetText(i + 1, 3);
					bean.auditStartDate = ssrs.GetText(i + 1, 4);
					bean.auditEndDate = ssrs.GetText(i + 1, 5);
					bean.auditUser = ssrs.GetText(i + 1, 6);
					bean.contNo = ssrs.GetText(i + 1, 7);
					bean.mainPolNo = ssrs.GetText(i + 1, 8);
					bean.inputDate = ssrs.GetText(i + 1, 9).length() > 10 ? ssrs.GetText(i + 1, 9).substring(0, 10) : ssrs.GetText(i + 1, 9);
					bean.inputStartDate = ssrs.GetText(i + 1, 9);
					bean.inputEndDate = ssrs.GetText(i + 1, 10);
					lnpList.add(bean);
				} else
				{
					if (i == 0)
						data = new String[ssrs.MaxRow][11];
					data[i][0] = ssrs.GetText(i + 1, 1);
					data[i][1] = ssrs.GetText(i + 1, 2);
					data[i][2] = ssrs.GetText(i + 1, 3);
					data[i][3] = ssrs.GetText(i + 1, 4);
					data[i][4] = ssrs.GetText(i + 1, 5);
					data[i][5] = ssrs.GetText(i + 1, 6);
					data[i][6] = ssrs.GetText(i + 1, 7);
					data[i][7] = ssrs.GetText(i + 1, 8);
					data[i][8] = ssrs.GetText(i + 1, 9).length() > 10 ? ssrs.GetText(i + 1, 9).substring(0, 10) : ssrs.GetText(i + 1, 9);
					data[i][9] = ssrs.GetText(i + 1, 9);
					data[i][10] = ssrs.GetText(i + 1, 10);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
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
