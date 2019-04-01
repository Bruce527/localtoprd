// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonalityDataModel.java

package com.sinosoft.map.communal;

import com.sinosoft.map.common.WebVisitor;
import com.sinosoft.map.common.config.BaseConfig;
import com.sinosoft.map.common.logs.LogInfo;
import com.sinosoft.map.common.logs.VisitorLog;
import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.news.NewsDataModel;
import com.sinosoft.map.user.*;
import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class CommonalityDataModel extends BaseConfig
{

	private String operate;
	private List newsCompanyList;
	private List newsBranchList;
	private String initNewsCompanyList;
	private String initNewsBranchList;
	private String loginToNowDate;
	private boolean flag;
	private String pwdCountDown;
	private String oldPwd;
	private String newPwd;
	private String confirmPwd;
	private String isSuccess;
	private String finished;
	private List queList;

	public CommonalityDataModel()
	{
		operate = "";
		flag = false;
		pwdCountDown = "";
		oldPwd = "";
		newPwd = "";
		confirmPwd = "";
		isSuccess = "";
		finished = "";
		queList = new ArrayList();
	}

	public void queCheckAgent()
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
		String topicid = (String)ctx.getExternalContext().getRequestParameterMap().get("topicid");
		WebVisitor tWebVisitor = new WebVisitor();
		tWebVisitor = ECPubFun.getWebVisitor();
		UserModel user = tWebVisitor.getUser();
		String agentcode = user.getUserCode();
		String strSQL2 = "";
		strSQL2 = (new StringBuilder("select * from minvresult where topicid='")).append(topicid).append("' and agentcode='").append(agentcode).append("'").toString();
		SSRS tSSRS2 = new SSRS();
		ExeSQL tExeSql2 = new ExeSQL();
		tSSRS2 = tExeSql2.execSQL(strSQL2);
		if (tSSRS2 != null && tSSRS2.getMaxRow() > 0)
			finished = "false";
		else
			finished = topicid;
	}

	public void changePassword()
	{
		ADUser aduser = new ADUser();
		WebVisitor tWebVisitor = new WebVisitor();
		tWebVisitor = ECPubFun.getWebVisitor();
		UserModel user = tWebVisitor.getUser();
		aduser.setUserCode(user.getUserCode());
		aduser.setPassWord(oldPwd);
		aduser.setNewPassWord(newPwd);
		ADValidate tADValidate = new ADValidate();
		isSuccess = tADValidate.ChangePassWord(aduser);
	}

	public String getIsSuccess()
	{
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess)
	{
		this.isSuccess = isSuccess;
	}

	public boolean isFlag()
	{
		ExeSQL exeSQL = new ExeSQL();
		String passinvalidaremindnum = null;
		String passvaliddatenum = null;
		UserModel user = ECPubFun.getWebVisitor().getUser();
		String tDate = user.getPwdLastSetDate();
		System.out.println((new StringBuilder(String.valueOf(tDate))).append("~~~~~~~~~~~~~~~~~~~~~").toString());
		String pwdsql1 = "select varvalue from msysvar where vartype='passinvalidaremindnum' ";
		SSRS ssrs = exeSQL.execSQL(pwdsql1);
		if (ssrs.MaxRow > 0)
			passinvalidaremindnum = ssrs.GetText(1, 1);
		String pwdsql2 = "select varvalue from msysvar where vartype='passvaliddatenum' ";
		ssrs = exeSQL.execSQL(pwdsql2);
		if (ssrs.MaxRow > 0)
			passvaliddatenum = ssrs.GetText(1, 1);
		Date date1 = null;
		try
		{
			date1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(tDate);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		System.out.println(date1);
		Calendar pwdcalendar = Calendar.getInstance();
		pwdcalendar.setTime(date1);
		int adddays = Integer.parseInt(passvaliddatenum);
		pwdcalendar.add(5, adddays);
		System.out.println(pwdcalendar.getTime());
		Date date2 = pwdcalendar.getTime();
		Date today = new Date();
		long countdown = (date2.getTime() - today.getTime()) / 0x5265c00L;
		System.out.println(countdown);
		tDate = Long.toString(countdown);
		pwdCountDown = tDate;
		if (Integer.parseInt(tDate) < Integer.parseInt(passinvalidaremindnum) && ECPubFun.getWebVisitor().getUser().isPopupFlag())
			flag = true;
		else
			flag = false;
		return flag;
	}

	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}

	public String getPwdCountDown()
	{
		return pwdCountDown;
	}

	public void setPwdCountDown(String pwdCountDown)
	{
		this.pwdCountDown = pwdCountDown;
	}

	public String getLoginToNowDate()
	{
		WebVisitor tWebVisitor = new WebVisitor();
		tWebVisitor = ECPubFun.getWebVisitor();
		UserModel user = tWebVisitor.getUser();
		String loginTime = user.getLoginTime();
		loginTime = (new StringBuilder(String.valueOf(user.getLoginDate()))).append(" ").append(loginTime).toString();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowtime = d.format(new Date());
		long resultDay = 0L;
		long resultMin = 0L;
		long resultSecond = 0L;
		String resultDayStr = "";
		String resultMinStr = "";
		String resultSecondStr = "";
		try
		{
			resultDay = (d.parse(nowtime).getTime() - d.parse(loginTime).getTime()) / 0x36ee80L;
			resultMin = (d.parse(nowtime).getTime() - d.parse(loginTime).getTime()) / 60000L;
			resultSecond = (d.parse(nowtime).getTime() - d.parse(loginTime).getTime()) / 1000L;
			resultSecond %= 60L;
			resultDay %= 60L;
			resultMin %= 60L;
			resultDayStr = String.valueOf(resultDay);
			if (resultDayStr.length() == 1)
				resultDayStr = (new StringBuilder("0")).append(resultDayStr).toString();
			resultMinStr = String.valueOf(resultMin);
			if (resultMinStr.length() == 1)
				resultMinStr = (new StringBuilder("0")).append(resultMinStr).toString();
			resultSecondStr = String.valueOf(resultSecond);
			if (resultSecondStr.length() == 1)
				resultSecondStr = (new StringBuilder("0")).append(resultSecondStr).toString();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		loginToNowDate = String.valueOf((new StringBuilder(String.valueOf(resultDayStr))).append(":").append(resultMinStr).append(":").append(resultSecondStr).toString());
		return loginToNowDate;
	}

	public void setLoginToNowDate(String loginToNowDate)
	{
		this.loginToNowDate = loginToNowDate;
	}

	public String getInitNewsCompanyList()
	{
		return initNewsCompanyList;
	}

	public void setInitNewsCompanyList(String initNewsCompanyList)
	{
		this.initNewsCompanyList = initNewsCompanyList;
		NewsDataModel model = new NewsDataModel();
		newsCompanyList = model.getNewsList("company");
	}

	public String getInitNewsBranchList()
	{
		return initNewsBranchList;
	}

	public void setInitNewsBranchList(String initNewsBranchList)
	{
		this.initNewsBranchList = initNewsBranchList;
		NewsDataModel model = new NewsDataModel();
		newsBranchList = model.getNewsList("branch");
	}

	public void setInitNewsList1(String s)
	{
	}

	public List getNewsCompanyList()
	{
		return newsCompanyList;
	}

	public void setNewsCompanyList(List newsCompanyList)
	{
		this.newsCompanyList = newsCompanyList;
	}

	public List getNewsBranchList()
	{
		return newsBranchList;
	}

	public void setNewsBranchList(List newsBranchList)
	{
		this.newsBranchList = newsBranchList;
	}

	public String getOperate()
	{
		return operate;
	}

	public void setOperate(String operate)
	{
		LogInfo tLogInfo = new LogInfo();
		WebVisitor visitor = ECPubFun.getWebVisitor();
		tLogInfo.setUsercode(visitor.getUser().getUserCode());
		tLogInfo.setOperateStr(operate);
		tLogInfo.setOperateDate(ECPubFun.getCurrentDate());
		tLogInfo.setOperateTime(ECPubFun.getCurrentTime());
		VisitorLog.webOperateInfoList.add(tLogInfo);
		System.out.println((new StringBuilder(String.valueOf(VisitorLog.webOperateInfoList.size()))).append("===================").toString());
	}

	public String getOldPwd()
	{
		return oldPwd;
	}

	public void setOldPwd(String oldPwd)
	{
		this.oldPwd = oldPwd;
	}

	public String getNewPwd()
	{
		return newPwd;
	}

	public void setNewPwd(String newPwd)
	{
		this.newPwd = newPwd;
	}

	public String getConfirmPwd()
	{
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd)
	{
		this.confirmPwd = confirmPwd;
	}

	public String getFinished()
	{
		return finished;
	}

	public void setFinished(String finished)
	{
		this.finished = finished;
	}

	public List getQueList()
	{
		queList.clear();
		String strSQL = "";
		strSQL = (new StringBuilder("select  topic,managecom,author,population,topicid  from minvtopic where checkstate='2' and branchtype='")).append(ECPubFun.getWebVisitor().getUser().getBranchType()).append("'").append(" and state='1' and invstate='2' and managecom in ('86','").append(ECPubFun.getWebVisitor().getUser().getManageCom()).append("') order by checkdate desc ").toString();
		SSRS tSSRS1 = new SSRS();
		ExeSQL tExeSql = new ExeSQL();
		tSSRS1 = tExeSql.execSQL(strSQL);
		if (tSSRS1 == null || tSSRS1.getMaxRow() < 1)
			return queList;
		for (int i = 1; i <= tSSRS1.MaxRow; i++)
		{
			String resultInfo[] = new String[tSSRS1.MaxCol];
			for (int j = 1; j <= tSSRS1.MaxCol; j++)
				resultInfo[j - 1] = tSSRS1.GetText(i, j);

			queList.add(resultInfo);
		}

		return queList;
	}

	public void setQueList(List queList)
	{
		this.queList = queList;
	}

	public void checkUserType()
	{
		isSuccess = "0";
		WebVisitor visitor = ECPubFun.getWebVisitor();
		String type = visitor.getUser().getUserType();
		if (type != null && !"".equals(type) && type.equals("LP"))
			isSuccess = "1";
	}
}
