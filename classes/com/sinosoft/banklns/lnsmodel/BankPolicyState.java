// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankPolicyState.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.BankBasicBL;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.schema.LNPOperationRecordSchema;
import com.sinosoft.banklns.utility.*;
import com.sinosoft.map.ec.utility.ECPubFun;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class BankPolicyState extends BankBasicBL
{

	private String contNo;
	private List policyStateList;
	private String message;
	private IGlobalInput tempGI;
	private LNPContSchema contSch;
	private LNPOperationRecordSchema lnpPolicyStateSchema;

	public BankPolicyState()
	{
		contNo = "";
		policyStateList = new ArrayList();
		message = "";
		contSch = new LNPContSchema();
		lnpPolicyStateSchema = new LNPOperationRecordSchema();
	}

	private void buildError(String msgErr)
	{
		message = msgErr;
		System.out.println((new StringBuilder("buildError:--after-------------")).append(message).toString());
	}

	private boolean getInfoFromSession(HttpSession session)
	{
		boolean flag = false;
		try
		{
			if (session == null)
				session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			if ((String)session.getAttribute("ContNo") != null && !((String)session.getAttribute("ContNo")).equals(""))
			{
				contNo = (String)session.getAttribute("ContNo");
				waitPolicyCommited(session, contNo);
				turnCurrPolicyLockFlag(session, contNo, "lock");
				flag = true;
			}
		}
		catch (Exception e)
		{
			turnCurrPolicyLockFlag(session, contNo, "unlock");
			flag = false;
			buildError(e.getMessage());
		}
		return flag;
	}

	public String queryPolicyState()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		try
		{
			if (getInfoFromSession(session))
			{
				policyStateList.clear();
				System.out.println("--- queryPolicyState Start ---");
				String sql = "select distinct top 200";
				sql = (new StringBuilder(String.valueOf(sql))).append(" lc.codename as '保单状�??',lnp.OperatorCode as '处理人员编码',lnp.OperatorName as '处理人员',convert(varchar(10),lnp.OperationDate,120) as date ,lnp.OperationTime as time  from LNPOperationRecord lnp inner join lnpcode lc on lnp.Varc2 = lc.code where lnp.contno='").append(contNo).append("' and lc.codetype='lnpLangState' ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" order by date desc,time desc").toString();
				System.out.println((new StringBuilder("queryPolicyState SQL_c : ")).append(sql).toString());
				SSRS tSSRS = new SSRS();
				ExeSQL exeSQL = new ExeSQL();
				tSSRS = exeSQL.execSQL(sql);
				System.out.println("循环显示结果列表�?�?-------------");
				if (tSSRS == null || tSSRS.getMaxRow() < 1)
				{
					message = "查询无返回结�?!";
					ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "查询无返回结�?!");
					System.out.println(message);
				} else
				{
					if (tSSRS.MaxRow == 200)
					{
						message = "查询记录多于200条，仅显示前200条！";
						ECPubFun.addErrorMessage("com.sinosoft.map.international.resource.programresource", "查询记录多于200条，仅显示前200条！");
						System.out.println(message);
					}
					for (int i = 1; i <= tSSRS.MaxRow; i++)
					{
						String resultInfo[] = new String[tSSRS.MaxCol - 2];
						resultInfo[0] = tSSRS.GetText(i, 1);
						resultInfo[1] = (new StringBuilder(String.valueOf(tSSRS.GetText(i, 2)))).append("-").append(tSSRS.GetText(i, 3)).toString();
						resultInfo[2] = (new StringBuilder(String.valueOf(tSSRS.GetText(i, 4)))).append(" ").append(tSSRS.GetText(i, 5)).toString();
						policyStateList.add(resultInfo);
					}

					System.out.println("循环显示结果列表结束-------------");
				}
			} else
			{
				buildError("全局投保书信息缺�?!");
			}
			break MISSING_BLOCK_LABEL_404;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		break MISSING_BLOCK_LABEL_415;
		Exception exception;
		exception;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		throw exception;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		System.out.println("--- queryPolicyState End ---");
		return "success";
	}

	public boolean savePolicyState(String contNo, String state, String recordFlag, String date, String time, String rstMsg)
	{
		LNPOperationRecordSchema operRecordSchema;
		IGlobalInput tempGI;
		System.out.println("saveOperRecord---start");
		operRecordSchema = new LNPOperationRecordSchema();
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
		if (tempGI == null || date == null || date.equals("") || time == null || time.equals("") || recordFlag == null || recordFlag.equals(""))
			break MISSING_BLOCK_LABEL_403;
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		operRecordSchema.setID(maxNoMap.CreateMaxNo("CustomerNo", ""));
		operRecordSchema.setContNo(contNo);
		operRecordSchema.setOperatorCode(tempGI.Operator);
		operRecordSchema.setOperatorName(getOperatorName(tempGI.Operator));
		operRecordSchema.setOperatorType("2");
		operRecordSchema.setOperationDate(date);
		operRecordSchema.setOperationTime(time);
		operRecordSchema.setOperation(recordFlag);
		operRecordSchema.setVarc1((new StringBuilder(String.valueOf(date))).append(' ').append(time).toString());
		operRecordSchema.setVarc3("03".equals(state) ? "保费计算成功" : "04".equals(state) ? "保费计算失败" : "06".equals(state) ? "发�?�成�?" : "07".equals(state) ? "发�?�失�?" : "--!");
		System.out.println((new StringBuilder(String.valueOf(state))).append("<--->").append(operRecordSchema.getVarc3()).toString());
		operRecordSchema.setVarc4(rstMsg);
		operRecordSchema.setVarc2(state);
		MMap map = new MMap();
		VData vd = new VData();
		PubSubmit ps = new PubSubmit();
		map.put(operRecordSchema, "INSERT");
		vd.add(map);
		if (ps.submitData(vd, ""))
			break MISSING_BLOCK_LABEL_392;
		System.out.println("saveOperRecord error");
		return false;
		try
		{
			System.out.println("saveOperRecord success");
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		return false;
	}

	public boolean savePolicyState(String contNo, String state, String recordFlag, String date, String time)
	{
		LNPOperationRecordSchema operRecordSchema;
		IGlobalInput tempGI;
		System.out.println("saveOperRecord---start");
		operRecordSchema = new LNPOperationRecordSchema();
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		tempGI = (IGlobalInput)session.getValue("NPGI");
		if (tempGI == null || date == null || date.equals("") || time == null || time.equals("") || recordFlag == null || recordFlag.equals(""))
			break MISSING_BLOCK_LABEL_260;
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		operRecordSchema.setID(maxNoMap.CreateMaxNo("CustomerNo", ""));
		operRecordSchema.setContNo(contNo);
		operRecordSchema.setOperatorCode(tempGI.Operator);
		operRecordSchema.setOperatorName(getOperatorName(tempGI.Operator));
		operRecordSchema.setOperatorType("2");
		operRecordSchema.setOperationDate(date);
		operRecordSchema.setOperationTime(time);
		operRecordSchema.setOperation(recordFlag);
		operRecordSchema.setVarc2(state);
		MMap map = new MMap();
		VData vd = new VData();
		PubSubmit ps = new PubSubmit();
		map.put(operRecordSchema, "INSERT");
		vd.add(map);
		if (ps.submitData(vd, ""))
			break MISSING_BLOCK_LABEL_249;
		System.out.println("saveOperRecord error");
		return false;
		try
		{
			System.out.println("saveOperRecord success");
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		return false;
	}

	private String getOperatorName(String operator)
	{
		if (operator != null)
		{
			ExeSQL exeSQL = new ExeSQL();
			String sqlStr = "";
			sqlStr = (new StringBuilder("select username from MUser where UserCode = '")).append(operator).append("'").toString();
			SSRS tSSRS = exeSQL.execSQL(sqlStr);
			if (tSSRS != null && tSSRS.getMaxRow() > 0)
				return tSSRS.GetText(1, 1);
		}
		return null;
	}

	private String getComCode(String cno)
	{
		String com = "";
		ExeSQL tExeSql = new ExeSQL();
		String preSql = (new StringBuilder("select t.comcode,t.name,t.validcode from lnpcom t where t.validcode = '")).append(cno.substring(0, 2)).append("'").toString();
		SSRS tSSRSfromCom = tExeSql.execSQL(preSql);
		if (tSSRSfromCom != null && tSSRSfromCom.MaxRow > 0)
			com = tSSRSfromCom.GetText(1, 1);
		return com;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
	}

	public List getPolicyStateList()
	{
		return policyStateList;
	}

	public void setPolicyStateList(List policyStateList)
	{
		this.policyStateList = policyStateList;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
