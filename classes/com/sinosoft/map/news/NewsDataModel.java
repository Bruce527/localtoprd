// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   NewsDataModel.java

package com.sinosoft.map.news;

import com.sinosoft.map.common.WebVisitor;
import com.sinosoft.map.common.config.BaseConfig;
import com.sinosoft.map.common.validators.ValidatorConfig;
import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.lis.db.MNewsDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.lis.pubfun.PubFun;
import com.sinosoft.map.lis.schema.MNewsSchema;
import com.sinosoft.map.lis.vschema.MNewsSet;
import com.sinosoft.map.user.UserModel;
import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.sinosoft.map.news:
//			NewsDataModelSchema

public class NewsDataModel extends BaseConfig
{

	private List newsList;
	private List newsNewList;
	private List newsHotList;
	private List newsCompanyList;
	private List newsBranchList;
	private List newsSearchList;
	private List newsHomeCompanyList;
	private List newsHomeBranchList;
	private int pagesize;
	private int pagecount;
	private int recordcount;
	String initList;
	String queryTitle;
	private String newsPageId;
	String pageURL;
	private String ListInfo;
	private String operateResult;
	private String controlType;
	private String moreType;
	private ValidatorConfig vc;
	private String init;
	private String currentUserCode;
	private FDate tFData;
	private SimpleDateFormat sdf;
	private String SQL;

	public NewsDataModel()
	{
		pagesize = 20;
		pagecount = 0;
		recordcount = 0;
		initList = "";
		queryTitle = "";
		newsPageId = "";
		pageURL = "";
		ListInfo = "";
		operateResult = "";
		controlType = "";
		moreType = "";
		vc = new ValidatorConfig();
		init = "";
		currentUserCode = "";
		tFData = new FDate();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		SQL = "";
	}

	public String getNewsPageId()
	{
		return newsPageId;
	}

	public void setNewsPageId(String newsPageId)
	{
		this.newsPageId = newsPageId;
		addNewsClick(newsPageId);
	}

	public void addNewsClick(String s)
	{
	}

	private String getSql(String type)
	{
		WebVisitor tWebVisitor = new WebVisitor();
		tWebVisitor = ECPubFun.getWebVisitor();
		UserModel user = tWebVisitor.getUser();
		String curDate = PubFun.getCurrentDate();
		String curTime = PubFun.getCurrentTime();
		StringBuffer strSQL = new StringBuffer();
		if (type.equals("search") || type.equals("moreNew") || type.equals("moreHot") || type.equals("moreCompany") || type.equals("moreBranch"))
			strSQL.append(" select top 400 * from MNews m ");
		else
			strSQL.append(" select top 10 * from MNews m ");
		strSQL.append(" where 1=1 ");
		if (type.equals("company") || type.equals("moreCompany"))
			strSQL.append(" and m.managecom in ('86') ");
		else
		if (type.equals("branch") || type.equals("moreBranch"))
		{
			if (user.getManageCom() != null && user.getManageCom().equals("86"))
				strSQL.append(" and m.managecom <> '86' ");
			else
				strSQL.append((new StringBuilder(" and m.managecom in ('")).append(user.getManageCom()).append("') and m.managecom <> '86' ").toString());
		} else
		{
			strSQL.append((new StringBuilder(" and m.managecom in ('86','")).append(user.getManageCom()).append("') ").toString());
		}
		strSQL.append((new StringBuilder(" and m.Branchtype = '")).append(user.getBranchType()).append("' ").toString());
		strSQL.append((new StringBuilder(" and (m.MinDisplayGrade <= '")).append(user.getAgentGrade()).append("' or m.mindisplaygrade is null) ").toString());
		strSQL.append(" and m.CheckState = '2' ");
		strSQL.append((new StringBuilder(" and ((m.StartDisplayDate < '")).append(curDate).append("' or m.StartDisplayDate is null) or (m.StartDisplayDate = '").append(curDate).append("' and m.StartDisplayTime <= '").append(curTime).append("' ))").toString());
		strSQL.append((new StringBuilder(" and ((m.EndDisplayDate > '")).append(curDate).append("' or m.EndDisplayDate is null) or (m.EndDisplayDate = '").append(curDate).append("' and m.EndDisplayTime >= '").append(curTime).append("' ))").toString());
		if (type.equals("search"))
			strSQL.append((new StringBuilder(" and m.title like '%")).append(queryTitle).append("%'").toString());
		if (type.equals("hot") || type.equals("moreHot"))
			strSQL.append(" order by m.FixedTop desc, m.ClickRate desc, m.makedate desc, m.maketime desc");
		else
			strSQL.append(" order by m.FixedTop desc, m.makedate desc, m.maketime desc ");
		return strSQL.toString();
	}

	public void search()
	{
		System.out.println("search======================================");
		try
		{
			moreType = "新闻搜索结果:";
			newsSearchList = getNewsList("search");
			if (newsSearchList != null && newsSearchList.size() != 0)
			{
				operateResult = "News_Control_SearchSucc";
				operateResult = (new StringBuilder("Succ|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
			} else
			{
				operateResult = "Succ|resultisnull";
			}
		}
		catch (Exception ex)
		{
			moreType = "新闻搜索结果:";
			operateResult = "News_Control_SearchFail";
			operateResult = (new StringBuilder("Fail|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
		}
	}

	public void searchMoreNew()
	{
		System.out.println("searchMoreNew======================================");
		try
		{
			moreType = "�?新新�?:";
			newsSearchList = getNewsList("moreNew");
			if (newsSearchList != null && newsSearchList.size() != 0)
			{
				operateResult = "News_Control_SearchSucc";
				operateResult = (new StringBuilder("Succ|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
			} else
			{
				operateResult = "Succ|resultisnull";
			}
		}
		catch (Exception ex)
		{
			moreType = "�?新新�?:";
			operateResult = "News_Control_SearchFail";
			operateResult = (new StringBuilder("Fail|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
		}
	}

	public void searchMoreHot()
	{
		System.out.println("searchMoreHot======================================");
		try
		{
			moreType = "热门排行:";
			newsSearchList = getNewsList("moreHot");
			if (newsSearchList != null && newsSearchList.size() != 0)
			{
				operateResult = "News_Control_SearchSucc";
				operateResult = (new StringBuilder("Succ|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
			} else
			{
				operateResult = "Succ|resultisnull";
			}
		}
		catch (Exception ex)
		{
			moreType = "热门排行:";
			operateResult = "News_Control_SearchFail";
			operateResult = (new StringBuilder("Fail|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
		}
	}

	public void searchMoreCompany()
	{
		System.out.println("searchMoreCompany======================================");
		try
		{
			moreType = "总公司新�?:";
			newsSearchList = getNewsList("moreCompany");
			if (newsSearchList != null && newsSearchList.size() != 0)
			{
				operateResult = "News_Control_SearchSucc";
				operateResult = (new StringBuilder("Succ|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
			} else
			{
				operateResult = "Succ|resultisnull";
			}
		}
		catch (Exception ex)
		{
			moreType = "总公司新�?:";
			operateResult = "News_Control_SearchFail";
			operateResult = (new StringBuilder("Fail|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
		}
	}

	public void searchMoreBranch()
	{
		System.out.println("searchMoreBranch======================================");
		try
		{
			moreType = "分公司新�?:";
			newsSearchList = getNewsList("moreBranch");
			if (newsSearchList != null && newsSearchList.size() != 0)
			{
				operateResult = "News_Control_SearchSucc";
				operateResult = (new StringBuilder("Succ|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
			} else
			{
				operateResult = "Succ|resultisnull";
			}
		}
		catch (Exception ex)
		{
			moreType = "分公司新�?:";
			operateResult = "News_Control_SearchFail";
			operateResult = (new StringBuilder("Fail|")).append(ECPubFun.getDisplayString(vc.getBundle(), operateResult, null)).toString();
		}
	}

	private void refreshFields()
	{
		controlType = "";
		operateResult = "";
		currentUserCode = "";
	}

	public List getNewsNewList()
	{
		return newsNewList;
	}

	public int getPagesize()
	{
		return pagesize;
	}

	public void setPagesize(int pagesize)
	{
		this.pagesize = pagesize;
	}

	public int getPagecount()
	{
		return pagecount;
	}

	public void setPagecount(int pagecount)
	{
		this.pagecount = pagecount;
	}

	public String getOperateResult()
	{
		return operateResult;
	}

	public String getControlType()
	{
		return controlType;
	}

	public void setControlType(String controlType)
	{
		this.controlType = controlType;
	}

	private void transFields(NewsDataModelSchema a, MNewsSchema t)
	{
		a.setNewsID(t.getNewsID());
		a.setTitle(t.getTitle());
		a.setAuthor(t.getAuthor());
		a.setMakeDate(t.getMakeDate());
		a.setNewsType(t.getNewsType());
		a.setStaticPageURL(t.getStaticPageURL());
		a.setClickRate(t.getClickRate());
		a.setFixedTop(t.getFixedTop());
	}

	public String getInit()
	{
		return init;
	}

	public void setInit(String init)
	{
		this.init = init;
	}

	public List getNewsHotList()
	{
		return newsHotList;
	}

	public void setNewsHotList(List newsHotList)
	{
		this.newsHotList = newsHotList;
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

	public List getNewsSearchList()
	{
		return newsSearchList;
	}

	public void setNewsSearchList(List newsSearchList)
	{
		this.newsSearchList = newsSearchList;
	}

	public List getNewsHomeCompanyList()
	{
		return newsHomeCompanyList;
	}

	public void setNewsHomeCompanyList(List newsHomeCompanyList)
	{
		this.newsHomeCompanyList = newsHomeCompanyList;
	}

	public List getNewsHomeBranchList()
	{
		return newsHomeBranchList;
	}

	public void setNewsHomeBranchList(List newsHomeBranchList)
	{
		this.newsHomeBranchList = newsHomeBranchList;
	}

	public String getQueryTitle()
	{
		return queryTitle;
	}

	public void setQueryTitle(String queryTitle)
	{
		this.queryTitle = queryTitle;
	}

	public List getNewsList(String type)
	{
		newsList = new ArrayList();
		String curDate = PubFun.getCurrentDate();
		MNewsDB dao = new MNewsDB();
		String sql = "";
		String sqlSysDateNum = "select varvalue from msysvar where vartype='newsnewday'";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sqlSysDateNum);
		int sysDateNum = Integer.parseInt(tSSRS.GetText(1, 1));
		String sqlHotNum = "select varvalue from msysvar where vartype='newshotnum'";
		tSSRS = tExeSQL.execSQL(sqlHotNum);
		int newsHotNum = Integer.parseInt(tSSRS.GetText(1, 1));
		sql = getSql(type);
		System.out.println(sql);
		MNewsSet tMNewsSet = dao.executeQuery(sql);
		if (tMNewsSet != null && tMNewsSet.size() > 0)
		{
			for (int iLoop = 1; iLoop <= tMNewsSet.size(); iLoop++)
			{
				int titleSize = 32;
				MNewsSchema t = tMNewsSet.get(iLoop);
				NewsDataModelSchema a = new NewsDataModelSchema();
				transFields(a, t);
				if (a.getNewsType() != null && a.getNewsType().equals("02"))
				{
					a.setNewsTypeSign("(�?)");
					titleSize -= 4;
				}
				if (a.getFixedTop() == 1)
				{
					a.setNewsTopSign("(重要)");
					titleSize -= 6;
				}
				int dateNum = PubFun.calInterval2(a.getMakeDate(), curDate, "D");
				if (dateNum < sysDateNum)
				{
					a.setNewPic("../images/main/new.gif");
					titleSize -= 4;
				} else
				{
					a.setNewPic("../images/main/space.gif");
				}
				if (a.getClickRate() != 0 && iLoop <= newsHotNum)
				{
					a.setHotPic("../images/main/hot.gif");
					titleSize -= 4;
				} else
				{
					a.setHotPic("../images/main/space.gif");
				}
				if (type.equals("search") || type.equals("moreNew") || type.equals("moreHot") || type.equals("moreCompany") || type.equals("moreBranch"))
				{
					if (a.getTitle() != null && a.getTitle().length() > 30)
						a.setNewsShortTitle((new StringBuilder(String.valueOf(a.getTitle().substring(0, 30)))).append("...").toString());
					else
						a.setNewsShortTitle(a.getTitle());
				} else
				if (a.getTitle() != null && a.getTitle().length() > titleSize / 2)
					a.setNewsShortTitle((new StringBuilder(String.valueOf(a.getTitle().substring(0, titleSize / 2)))).append("...").toString());
				else
					a.setNewsShortTitle(a.getTitle());
				newsList.add(a);
			}

			recordcount = newsList.size();
		}
		return newsList;
	}

	public void setNewsList(List newsList)
	{
		this.newsList = newsList;
	}

	public String getMoreType()
	{
		return moreType;
	}

	public void setMoreType(String moreType)
	{
		this.moreType = moreType;
	}

	public String getInitList()
	{
		return initList;
	}

	public void setInitList(String initList)
	{
		newsNewList = getNewsList("new");
		newsHotList = getNewsList("hot");
		newsCompanyList = getNewsList("company");
		newsBranchList = getNewsList("branch");
		this.initList = initList;
	}
}
