// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AgentInformSave.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPAgentImpResultDB;
import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.vschema.LNPAgentImpResultSet;
import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.*;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			PolicyMainInfo, StateOperatorDeal

public class AgentInformSave
{

	public AgentInformSave()
	{
	}

	public void saveImpResult(HttpSession session, HttpServletRequest request, HttpServletResponse response, int queNum)
		throws Exception
	{
		if (session == null)
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if (request == null)
			request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if (response == null)
			response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
		String contNo = (String)session.getAttribute("ContNo");
		String operateType = (String)session.getAttribute("initAgentInformResultOperatType");
		String agentInformResultId = (String)session.getAttribute("agentInformResultId");
		String impartId = request.getParameter("impartId");
		IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		String resultID = maxNoMap.CreateMaxNo("AgentImpReId", "");
		boolean flag = false;
		boolean isExistUselessCharTag = true;
		String message = "";
		MMap map = new MMap();
		try
		{
			ExeSQL tExeSql = new ExeSQL();
			String sqlfromQue = "";
			if (impartId != null)
				sqlfromQue = (new StringBuilder("select distinct questionid,questiontype  from LnpAgentImpQue where impartid='")).append(impartId).append("' order by questionid ").toString();
			SSRS tSSRSfromDB = tExeSql.execSQL(sqlfromQue);
			int groupOrderTag = tSSRSfromDB.MaxRow;
			if (groupOrderTag > 0 && queNum > 0)
			{
				Integer groupOrdercount = new Integer(1);
				if (groupOrderTag / queNum > 0 && groupOrderTag % queNum > 0)
				{
					String str = (new StringBuilder(String.valueOf(String.valueOf(groupOrderTag / queNum)))).append(String.valueOf(groupOrderTag % queNum)).toString();
					String strTemp = str.length() <= 2 ? str : str.substring(0, 2);
					groupOrdercount = Integer.valueOf(groupOrdercount.intValue() + (new Integer(strTemp)).intValue() / 10);
				}
				for (int i = 1; i <= groupOrdercount.intValue(); i++)
				{
					String sql = "";
					int forNum = 0;
					if (1 == i)
						forNum = queNum;
					else
						forNum = groupOrderTag - (i - 1) * queNum;
					String sqlKeyPre = "ResultId,GrpContNo,ContNo,ProposalContNo,ImpartId,Grouporder,";
					String sqlValuePre = "";
					if (operateType != null && "modify".equals(operateType.trim()) && agentInformResultId != null)
						sqlValuePre = (new StringBuilder(String.valueOf(sqlValuePre))).append("'").append(agentInformResultId).append("',").toString();
					else
						sqlValuePre = (new StringBuilder(String.valueOf(sqlValuePre))).append("'").append(resultID).append("',").toString();
					if (contNo != null)
					{
						LNPContSchema contSch = mainInfo.getContByContNo(contNo);
						sqlValuePre = (new StringBuilder(String.valueOf(sqlValuePre))).append("'").append(contSch.getGrpContNo()).append("',").append("'").append(contNo).append("',").append("'").append(contNo).append("',").toString();
					}
					if (impartId != null)
						sqlValuePre = (new StringBuilder(String.valueOf(sqlValuePre))).append("'").append(impartId).append("',").toString();
					sqlValuePre = (new StringBuilder(String.valueOf(sqlValuePre))).append("'").append(String.valueOf(i)).append("',").toString();
					String sqlKeyAft = "Operator,ManageCom,MakeDate,MakeTime,ModifyDate,ModifyTime";
					String sqlValueAft = "";
					if (tempGI != null)
						sqlValueAft = (new StringBuilder(String.valueOf(sqlValueAft))).append("'").append(tempGI.Operator).append("',").append("'").append(tempGI.ComCode).append("',").toString();
					else
						sqlValueAft = (new StringBuilder(String.valueOf(sqlValueAft))).append("'','',").toString();
					String date = PubFun.getCurrentDate();
					String time = PubFun.getCurrentTime();
					sqlValueAft = (new StringBuilder(String.valueOf(sqlValueAft))).append("'").append(date).append("',").append("'").append(time).append("',").append("'").append(date).append("',").append("'").append(time).append("'").toString();
					String sqlKey = "";
					String sqlValue = "";
					for (int j = 1; j <= forNum; j++)
					{
						String tempId = "";
						if (j < 10)
						{
							if (tSSRSfromDB.GetText(j, 1) != null || "".equals(tSSRSfromDB.GetText(j, 1)))
							{
								tempId = (new StringBuilder(String.valueOf(tSSRSfromDB.GetText(j, 1).substring(1, 9).substring(0, 7)))).append(j).toString();
								sqlKey = (new StringBuilder(String.valueOf(sqlKey))).append("QID0").append(j).append(",").append("A0").append(j).append(",").toString();
								if (!"3".equals(tSSRSfromDB.GetText(j, 2)))
								{
									sqlValue = (new StringBuilder(String.valueOf(sqlValue))).append("'").append(i).append(tempId).append("',").append("'").append(request.getParameter((new StringBuilder("R")).append(i).append(tempId).toString())).append("',").toString();
								} else
								{
									String str = "";
									String ss[] = request.getParameterValues((new StringBuilder("R")).append(i).append(tempId).toString());
									if (ss != null)
									{
										for (int k = 0; k < ss.length; k++)
											str = (new StringBuilder(String.valueOf(str))).append(ss[k]).toString();

										sqlValue = (new StringBuilder(String.valueOf(sqlValue))).append("'").append(i).append(tempId).append("',").append("'").append(str).append("',").toString();
									} else
									{
										sqlValue = (new StringBuilder(String.valueOf(sqlValue))).append("'").append(i).append(tempId).append("',").append("'").append("',").toString();
									}
								}
							}
						} else
						if (tSSRSfromDB.GetText(j, 1) != null || "".equals(tSSRSfromDB.GetText(j, 1)))
						{
							tempId = (new StringBuilder(String.valueOf(tSSRSfromDB.GetText(j, 1).substring(1, 9).substring(0, 6)))).append(j).toString();
							sqlKey = (new StringBuilder(String.valueOf(sqlKey))).append("QID").append(j).append(",").append("A").append(j).append(",").toString();
							if (!"3".equals(tSSRSfromDB.GetText(j, 2)))
							{
								sqlValue = (new StringBuilder(String.valueOf(sqlValue))).append("'").append(i).append(tempId).append("',").append("'").append(request.getParameter((new StringBuilder("R")).append(i).append(tempId).toString())).append("',").toString();
							} else
							{
								String str = "";
								String ss[] = request.getParameterValues((new StringBuilder("R")).append(i).append(tempId).toString());
								if (ss != null)
								{
									for (int k = 0; k < ss.length; k++)
										str = (new StringBuilder(String.valueOf(str))).append(ss[k]).toString();

									sqlValue = (new StringBuilder(String.valueOf(sqlValue))).append("'").append(i).append(tempId).append("',").append("'").append(str).append("',").toString();
								} else
								{
									sqlValue = (new StringBuilder(String.valueOf(sqlValue))).append("'").append(i).append(tempId).append("',").append("'").append("',").toString();
								}
							}
						}
						if (request.getParameter((new StringBuilder("R")).append(i).append(tempId).toString()) != null && !ValidateTools.isExistUselessChar(request.getParameter((new StringBuilder("R")).append(i).append(tempId).toString())))
							isExistUselessCharTag = false;
					}

					sql = (new StringBuilder("insert into LnpAgentImpResult (")).append(sqlKeyPre).append(sqlKey).append(sqlKeyAft).append(")").append(" values (").append(sqlValuePre).append(sqlValue).append(sqlValueAft).append(")").toString();
					if (operateType != null && contNo != null)
					{
						LNPContSchema contSch = mainInfo.getContByContNo(contNo);
						StateOperatorDeal operatorDeal = new StateOperatorDeal();
						if ("modify".equals(operateType) && agentInformResultId != null)
						{
							String strDel = (new StringBuilder("delete from LnpAgentImpResult where  resultid = '")).append(agentInformResultId).append("'").append(" and grouporder = '").append(String.valueOf(i)).append("'").toString();
							map.put(strDel, "DELETE");
							List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "09");
							contSch.setState((String)stateList.get(0));
							contSch.setEditstate((String)stateList.get(1));
						}
						if ("add".equals(operateType))
							if (checkDataNum(contNo) || checkApprizDataNum(contNo))
							{
								List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "09");
								contSch.setState((String)stateList.get(0));
								contSch.setEditstate((String)stateList.get(1));
							} else
							{
								List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "add", "09");
								contSch.setState((String)stateList.get(0));
								contSch.setEditstate((String)stateList.get(1));
							}
						if ("2".equals(contSch.getUWFlag()))
							contSch.setUWFlag("1");
						map.put(contSch, "UPDATE");
					}
					map.put(sql, "INSERT");
				}

				if (isExistUselessCharTag)
				{
					PubSubmit ps = new PubSubmit();
					VData vd = new VData();
					vd.add(map);
					if (ps.submitData(vd, ""))
					{
						message = " 代理人告知保存成功！";
						flag = true;
					} else
					{
						message = " 代理人告知保存失败！";
						flag = false;
					}
				} else
				{
					message = " 代理人告知存储的SQL中包含非法字符 ！";
				}
			} else
			{
				message = " 查询代理人告知问题出错！";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println((new StringBuilder("message:")).append(message).toString());
		request.setAttribute("DisFlag", Boolean.valueOf(flag));
		request.setAttribute("DisMessage", message);
		response.sendRedirect("agentInform.jsf");
	}

	private boolean checkDataNum(String contNoStr)
	{
		LNPAgentInfoDB db = new LNPAgentInfoDB();
		String sql = (new StringBuilder("select * from lnpagentinfo where  contno = '")).append(contNoStr).append("'").toString();
		LNPAgentInfoSet iSet = db.executeQuery(sql);
		return iSet != null && iSet.size() > 0;
	}

	private boolean checkApprizDataNum(String contNoStr)
	{
		LNPAgentImpResultDB db = new LNPAgentImpResultDB();
		String sql = (new StringBuilder("select * from LNPAgentImpResult where  ContNo = '")).append(contNoStr).append("'").toString();
		LNPAgentImpResultSet ihSet = db.executeQuery(sql);
		return ihSet != null && ihSet.size() > 0;
	}

	public String getShowFlag(HttpSession session)
	{
		String flag = "";
		if (session == null)
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if (session != null)
		{
			String showFlag = (String)session.getAttribute("agentInformShowMsg");
			if (showFlag != null && "1".equals(showFlag))
			{
				flag = showFlag;
				session.removeAttribute("agentInformShowMsg");
			}
		}
		return flag;
	}
}
