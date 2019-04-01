// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankSysInfo.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.BankBasicBL;
import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import com.sinosoft.map.ec.utility.ECPubFun;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class BankSysInfo extends BankBasicBL
{

	private String contNo;
	private List sysInfoList;
	private String message;
	private IGlobalInput tempGI;
	private LNPContSchema contSch;

	public BankSysInfo()
	{
		contNo = "";
		sysInfoList = new ArrayList();
		message = "";
		tempGI = null;
	}

	public void searchSysInfo()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if (!getInfoFromSession(session))
			break MISSING_BLOCK_LABEL_355;
		sysInfoList.clear();
		System.out.println("--- querySysInfo Start ---");
		String sql = "select top 200 * from";
		sql = (new StringBuilder(String.valueOf(sql))).append("(select distinct convert(varchar(10),lnp.Date1,120) as modifydate,lnp.Varc1,lnp.Varc3,lnp.Varc4 from LNPOperationRecord lnp  where lnp.contno='").append(contNo).append("' ").append(" and lnp.Varc2 in('03','04','06','07') ").append(" and lnp.operation<>'2'").toString();
		sql = (new StringBuilder(String.valueOf(sql))).append(" ) a ").toString();
		sql = (new StringBuilder(String.valueOf(sql))).append(" order by a.modifydate desc").toString();
		System.out.println((new StringBuilder("querySysInfo SQL_c : ")).append(sql).toString());
		SSRS tSSRS = new SSRS();
		ExeSQL exeSQL = new ExeSQL();
		tSSRS = exeSQL.execSQL(sql);
		if (tSSRS == null || tSSRS.getMaxRow() < 1)
		{
			message = "??????????!";
			ECPubFun.addInfoMessage("com.sinosoft.map.international.resource.programresource", "??????????!");
			System.out.println(message);
			break MISSING_BLOCK_LABEL_399;
		}
		if (tSSRS.MaxRow == 200)
		{
			message = "?????\274????200??????????200????";
			ECPubFun.addErrorMessage("com.sinosoft.map.international.resource.programresource", "?????\274????200??????????200????");
			System.out.println(message);
		}
		for (int i = 1; i <= tSSRS.MaxRow; i++)
		{
			String resultInfo[] = new String[tSSRS.MaxCol - 1];
			resultInfo[0] = (new StringBuilder(String.valueOf(tSSRS.GetText(i, 1)))).append(" ").append(tSSRS.GetText(i, 2)).toString();
			resultInfo[1] = tSSRS.GetText(i, 3);
			resultInfo[2] = tSSRS.GetText(i, 4);
			sysInfoList.add(resultInfo);
		}

		turnCurrPolicyLockFlag(null, contNo, "unlock");
		return;
		try
		{
			buildError("?????????????!");
			break MISSING_BLOCK_LABEL_399;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		break MISSING_BLOCK_LABEL_410;
		Exception exception;
		exception;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		throw exception;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		System.out.println("--- querySysInfo End ---");
		return;
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

	private void buildError(String msgErr)
	{
		message = msgErr;
		System.out.println((new StringBuilder("buildError:--after-------------")).append(message).toString());
	}

	public String getContNo()
	{
		return contNo;
	}

	public List getSysInfoList()
	{
		return sysInfoList;
	}

	public void setSysInfoList(List sysInfoList)
	{
		this.sysInfoList = sysInfoList;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
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
