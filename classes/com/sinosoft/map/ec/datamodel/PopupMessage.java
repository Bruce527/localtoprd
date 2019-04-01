// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PopupMessage.java

package com.sinosoft.map.ec.datamodel;

import com.sinosoft.map.common.WebVisitor;
import com.sinosoft.map.common.config.BaseConfig;
import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.user.UserModel;
import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.util.ArrayList;
import java.util.List;

public class PopupMessage extends BaseConfig
{

	private String init;
	private String agentCode;
	private String manageCom;
	private String branchType;
	private List messageList;
	private List topmessageList;
	private String messageNum;
	private boolean popmessageNum;
	private boolean mainFlag;

	public PopupMessage()
	{
		init = "";
		agentCode = "";
		manageCom = "";
		branchType = "";
		messageList = new ArrayList();
		topmessageList = new ArrayList();
		messageNum = "";
		popmessageNum = false;
		mainFlag = true;
	}

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String agentCode)
	{
		this.agentCode = agentCode;
	}

	public void setInit(String init)
	{
		this.init = init;
		agentCode = ECPubFun.getWebVisitor().getUser().getUserCode();
		manageCom = ECPubFun.getWebVisitor().getUser().getManageCom();
		branchType = ECPubFun.getWebVisitor().getUser().getBranchType();
		initilise();
	}

	public String initilise()
	{
		messageList.clear();
		String strSQL = (new StringBuilder(" select b.messagename,\tMessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4,MessageContent5, b.script from MprivateMessage a inner join MmessageConfig b on a.messagetype=b.messagetype   where agentcode='")).append(agentCode).append("'and a.branchtype='").append(branchType).append("' and b.displaytype='01' and   state='1'   ").append(" union all ").append(" select b.messagename,").append(" MessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4, MessageContent5,b.script").append(" from MC2BMessage a inner join MmessageConfig b on a.messagetype=b.messagetype  ").append(" where a.managecom='").append(manageCom).append("' and a.branchtype='").append(branchType).append("' and b.displaytype='01' and   state='1' ").append(" union all ").append(" select mc.messagename,pm.message,'','','','','','','','',mc.script ").append(" from MPublicMessage pm, Mmessageconfig mc  ").append(" where 1=1 and mc.messagetype = pm.Type ").append(" and pm.receiveBranch in ('86','").append(manageCom).append("') ").append(" and pm.branchtype='").append(branchType).append("' ").append(" and mc.displaytype='01' ").append(" and pm.checkstate='2' ").append(" and pm.state='1' ").append(" and pm.startdate<= CONVERT(varchar(24), getdate(), 23) ").append(" and CONVERT(varchar(24), getdate(), 23) <=pm.enddate ").toString();
		SSRS tSSRS1 = new SSRS();
		ExeSQL tExeSql1 = new ExeSQL();
		tSSRS1 = tExeSql1.execSQL(strSQL);
		if (tSSRS1 == null || tSSRS1.getMaxRow() < 1)
		{
			ECPubFun.addInfoMessage(getBundle(), "无结果或查询失败！");
			return "failure";
		}
		messageNum = (new StringBuilder(String.valueOf(tSSRS1.MaxRow))).toString();
		for (int i = 1; i <= tSSRS1.MaxRow; i++)
		{
			String resultInfo[] = new String[tSSRS1.MaxCol];
			for (int j = 1; j <= tSSRS1.MaxCol; j++)
				resultInfo[j - 1] = tSSRS1.GetText(i, j);

			messageList.add(resultInfo);
		}

		return "success";
	}

	public String getInit()
	{
		return init;
	}

	public List getMessageList()
	{
		return messageList;
	}

	public void setMessageList(List messageList)
	{
		this.messageList = messageList;
	}

	public String getMessageNum()
	{
		return messageNum;
	}

	public void setMessageNum(String messageNum)
	{
		this.messageNum = messageNum;
	}

	public List getTopmessageList()
	{
		agentCode = ECPubFun.getWebVisitor().getUser().getUserCode();
		manageCom = ECPubFun.getWebVisitor().getUser().getManageCom();
		branchType = ECPubFun.getWebVisitor().getUser().getBranchType();
		topmessageList.clear();
		String strSQL = (new StringBuilder(" select top 5 * from ( select b.messagename,\tMessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4,MessageContent5, b.script from MprivateMessage a inner join MmessageConfig b on a.messagetype=b.messagetype   where agentcode='")).append(agentCode).append("'and a.branchtype='").append(branchType).append("' and b.displaytype='01' and   state='1'   ").append(" union all ").append(" select b.messagename,").append(" MessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4, MessageContent5,b.script").append(" from MC2BMessage a inner join MmessageConfig b on a.messagetype=b.messagetype  ").append(" where 1=1 and a.managecom='").append(manageCom).append("' and a.branchtype='").append(branchType).append("' and b.displaytype='01' and   state='1'  ").append(" union all ").append(" select mc.messagename,pm.message,'','','','','','','','',mc.script ").append(" from MPublicMessage pm, Mmessageconfig mc  ").append(" where 1=1 and mc.messagetype = pm.Type ").append(" and pm.receiveBranch in ('86','").append(manageCom).append("') ").append(" and pm.branchtype='").append(branchType).append("' ").append(" and mc.displaytype='01' ").append(" and pm.checkstate='2' ").append(" and pm.state='1' ").append(" and  pm.startdate<= CONVERT(varchar(24), getdate(), 23) ").append(" and  CONVERT(varchar(24), getdate(), 23) <=pm.enddate ) as tb").toString();
		SSRS tSSRS1 = new SSRS();
		ExeSQL tExeSql1 = new ExeSQL();
		tSSRS1 = tExeSql1.execSQL(strSQL);
		if (tSSRS1 == null || tSSRS1.getMaxRow() < 1)
			return topmessageList;
		mainFlag = true;
		messageNum = (new StringBuilder(String.valueOf(tSSRS1.MaxRow))).toString();
		for (int i = 1; i <= tSSRS1.MaxRow; i++)
		{
			String resultInfo[] = new String[tSSRS1.MaxCol];
			for (int j = 1; j <= tSSRS1.MaxCol; j++)
				resultInfo[j - 1] = tSSRS1.GetText(i, j);

			topmessageList.add(resultInfo);
		}

		return topmessageList;
	}

	public void setTopmessageList(List topmessageList)
	{
		this.topmessageList = topmessageList;
	}

	public boolean isMainFlag()
	{
		return mainFlag;
	}

	public void setMainFlag(boolean mainFlag)
	{
		this.mainFlag = mainFlag;
	}

	public void changeFlag()
	{
		ECPubFun.getWebVisitor().getUser().setPopupFlag(false);
		mainFlag = false;
	}

	public boolean isPopmessageNum()
	{
		agentCode = ECPubFun.getWebVisitor().getUser().getUserCode();
		manageCom = ECPubFun.getWebVisitor().getUser().getManageCom();
		branchType = ECPubFun.getWebVisitor().getUser().getBranchType();
		String strSQL = (new StringBuilder(" select top 5 * from ( select b.messagename,\tMessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4,MessageContent5, b.script from MprivateMessage a inner join MmessageConfig b on a.messagetype=b.messagetype   where agentcode='")).append(agentCode).append("'and a.branchtype='").append(branchType).append("' and b.displaytype='01' and   state='1'    ").append(" union all ").append(" select b.messagename,").append(" MessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4, MessageContent5,b.script").append(" from MC2BMessage a inner join MmessageConfig b on a.messagetype=b.messagetype  ").append(" where a.managecom='").append(manageCom).append("' and a.branchtype='1' and b.displaytype='01' and   state='1' ").append(" union all ").append(" select mc.messagename,pm.message,'','','','','','','','',mc.script ").append(" from MPublicMessage pm, Mmessageconfig mc  ").append(" where 1=1 and mc.messagetype = pm.Type ").append(" and pm.receiveBranch in ('86','").append(manageCom).append("') ").append(" and pm.branchtype='1' ").append(" and mc.displaytype='01' ").append(" and pm.checkstate='2' ").append(" and pm.state='1' ").append(" and  pm.startdate<= CONVERT(varchar(24), getdate(), 23) ").append(" and  CONVERT(varchar(24), getdate(), 23) <=pm.enddate ) as tb").toString();
		SSRS tSSRS1 = new SSRS();
		ExeSQL tExeSql1 = new ExeSQL();
		tSSRS1 = tExeSql1.execSQL(strSQL);
		return tSSRS1 != null && tSSRS1.getMaxRow() > 0;
	}

	public void setPopmessageNum(boolean popmessageNum)
	{
		this.popmessageNum = popmessageNum;
	}
}
