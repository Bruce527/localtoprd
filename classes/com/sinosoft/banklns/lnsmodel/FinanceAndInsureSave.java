// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FinanceAndInsureSave.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.*;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			PolicyMainInfo, StateOperatorDeal

public class FinanceAndInsureSave
{

	public FinanceAndInsureSave()
	{
	}

	public boolean saveImpResultWithMMap(MMap map)
		throws Exception
	{
		String message = "";
		boolean flag = true;
		PubSubmit ps = new PubSubmit();
		VData vd = new VData();
		vd.add(map);
		if (ps.submitData(vd, ""))
		{
			message = " ���񼰱��վ����֪����ɹ���";
			flag = true;
		} else
		{
			message = " ���񼰱��վ����֪����ʧ�ܣ�?";
			flag = false;
		}
		System.out.println((new StringBuilder("message:")).append(message).toString());
		return flag;
	}

	public void saveImpResult(HttpSession session, HttpServletRequest request, HttpServletResponse response)
		throws Exception
	{
		if (session == null)
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if (request == null)
			request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if (response == null)
			response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
		String contNo = (String)session.getAttribute("ContNo");
		String operateType = (String)session.getAttribute("initFAndIImpResultOperatType");
		String fAndIImpResultResultId = (String)session.getAttribute("fAndIImpResultResultId");
		String impartId = request.getParameter("impartId");
		IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		String resultID = maxNoMap.CreateMaxNo("FAndIImpReId", "");
		boolean flag = false;
		boolean isExistUselessCharTag = true;
		String message = "";
		MMap map = new MMap();
		try
		{
			ExeSQL tExeSql = new ExeSQL();
			String sqlfromQue = "";
			if (impartId != null)
				sqlfromQue = (new StringBuilder("select distinct questionid,questiontype  from LnpFAndIImpQue where impartid='")).append(impartId).append("' order by questionid ").toString();
			SSRS tSSRSfromDB = tExeSql.execSQL(sqlfromQue);
			int groupOrderTag = tSSRSfromDB.MaxRow;
			if (groupOrderTag > 0)
			{
				Integer groupOrdercount = new Integer(1);
				if (groupOrderTag / 16 > 0 && groupOrderTag % 16 > 0)
				{
					String str = (new StringBuilder(String.valueOf(String.valueOf(groupOrderTag / 16)))).append(String.valueOf(groupOrderTag % 16)).toString();
					String strTemp = str.length() <= 2 ? str : str.substring(0, 2);
					groupOrdercount = Integer.valueOf(groupOrdercount.intValue() + (new Integer(strTemp)).intValue() / 10);
				}
				for (int i = 1; i <= groupOrdercount.intValue(); i++)
				{
					String sql = "";
					int forNum = 0;
					if (1 == i)
						forNum = 16;
					else
						forNum = groupOrderTag - (i - 1) * 16;
					String sqlKeyPre = "ResultId,GrpContNo,ContNo,ProposalContNo,ImpartId,Grouporder,";
					String sqlValuePre = "";
					if (operateType != null && "modify".equals(operateType.trim()) && fAndIImpResultResultId != null)
						sqlValuePre = (new StringBuilder(String.valueOf(sqlValuePre))).append("'").append(fAndIImpResultResultId).append("',").toString();
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
							if (tSSRSfromDB.GetText(j, 1) != null)
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
						if (tSSRSfromDB.GetText(j, 1) != null)
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

					sql = (new StringBuilder("insert into lnpfandiimpresult (")).append(sqlKeyPre).append(sqlKey).append(sqlKeyAft).append(")").append(" values (").append(sqlValuePre).append(sqlValue).append(sqlValueAft).append(")").toString();
					if (operateType != null && contNo != null)
					{
						LNPContSchema contSch = mainInfo.getContByContNo(contNo);
						StateOperatorDeal operatorDeal = new StateOperatorDeal();
						if ("modify".equals(operateType) && fAndIImpResultResultId != null)
						{
							String strDel = (new StringBuilder("delete from lnpfandiimpresult where  resultid = '")).append(fAndIImpResultResultId).append("'").append(" and grouporder = '").append(String.valueOf(i)).append("'").toString();
							map.put(strDel, "DELETE");
							List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "07");
							contSch.setState((String)stateList.get(0));
							contSch.setEditstate((String)stateList.get(1));
						}
						if ("add".equals(operateType))
						{
							List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "add", "07");
							contSch.setState((String)stateList.get(0));
							contSch.setEditstate((String)stateList.get(1));
						}
						map.put(contSch, "UPDATE");
					}
					map.put(sql, "INSERT");
				}

				if (isExistUselessCharTag)
					flag = saveImpResultWithMMap(map);
				else
					message = " ���񼰱��վ����֪�洢��SQL�а�Ƿ��ַ�? ��";
			} else
			{
				message = " ��ѯ���񼰱��վ����֪�����?";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println((new StringBuilder("message:")).append(message).toString());
		request.setAttribute("DisFlag", Boolean.valueOf(flag));
		request.setAttribute("DisMessage", message);
		response.sendRedirect("financeAndInsure.jsf");
	}

	public String getShowFlag(HttpSession session)
	{
		String flag = "";
		if (session == null)
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if (session != null)
		{
			String showFlag = (String)session.getAttribute("financeInformShowMsg");
			if (showFlag != null && "1".equals(showFlag))
			{
				flag = showFlag;
				session.removeAttribute("financeInformShowMsg");
			}
		}
		return flag;
	}
}
