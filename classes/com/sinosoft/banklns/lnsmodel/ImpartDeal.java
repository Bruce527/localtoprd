// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ImpartDeal.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema;
import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.*;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			StateOperatorDeal, PolicyMainInfo

public class ImpartDeal
{

	private String message;

	public ImpartDeal()
	{
	}

	public boolean dealImpResult(LNPCustImpResultSet relSet, String operateType, LNPContSchema contSch)
	{
		boolean flag = false;
		PubSubmit ps = new PubSubmit();
		MMap map = new MMap();
		if (relSet != null && operateType != null && contSch != null)
		{
			try
			{
				if (operateType.equals("modify"))
				{
					LNPCustImpResultSchema rSch = relSet.get(1);
					LNPCustImpResultDB db = new LNPCustImpResultDB();
					db.setContNo(rSch.getContNo());
					db.setCustomerId(rSch.getCustomerId());
					db.setImpartId(rSch.getImpartId());
					LNPCustImpResultSet delSet = db.query();
					map.put(delSet, "DELETE");
				}
				StateOperatorDeal operatorDeal = new StateOperatorDeal();
				List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "08");
				contSch.setState((String)stateList.get(0));
				contSch.setEditstate((String)stateList.get(1));
				if ("2".equals(contSch.getUWFlag()))
					contSch.setUWFlag("1");
				map.put(relSet, "INSERT");
				map.put(contSch, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					System.out.println("-ImpartDeal-�������?");
					message = "JAVA : ���֪��Ϣ�������";
				} else
				{
					message = "JAVA : ���֪��Ϣ����ɹ���";
					flag = true;
				}
			}
			catch (RuntimeException e)
			{
				e.printStackTrace();
			}
			System.out.println(message);
		}
		return flag;
	}

	public String getImpartType(HttpSession session)
	{
		String impartType = "";
		if (session == null)
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String contNo = (String)session.getAttribute("ContNo");
		ExeSQL tExeSql = new ExeSQL();
		if (contNo != null && !"".equals(contNo.trim()))
		{
			String sqlFromQue = (new StringBuilder("select top 1 impartid from LNPCustImpResult where contno = '")).append(contNo).append("'").toString();
			SSRS ssrsFromQue = tExeSql.execSQL(sqlFromQue);
			if (ssrsFromQue != null && ssrsFromQue.MaxRow > 0)
			{
				if (ssrsFromQue.GetText(1, 1) != null)
					impartType = ssrsFromQue.GetText(1, 1).trim();
			} else
			{
				String sqlFromT = (new StringBuilder("select top 1 imp.impartid from lnppol pol,lnpriskconfig cfg,lnpcustimpart imp where pol.masterpolno = pol.polno and cfg.riskcode = pol.riskcode and pol.contno='")).append(contNo).append("' ").append("and cfg.imparttype = imp.proposaltype order by imp.impartver desc ").toString();
				SSRS ssrsFromT = tExeSql.execSQL(sqlFromT);
				if (ssrsFromT != null && ssrsFromT.MaxRow > 0 && ssrsFromT.GetText(1, 1) != null)
					impartType = ssrsFromT.GetText(1, 1).trim();
			}
		}
		return impartType;
	}

	public void saveInsuDiscripImpart(HttpServletRequest request, HttpServletResponse response)
		throws Exception
	{
		HttpSession session = request.getSession(true);
		if (session != null)
		{
			String ses = (String)session.getAttribute("insuDiscripInformSubmit");
			if (ses == null)
				session.setAttribute("insuDiscripInformSubmit", "2");
			else
				return;
			String impartId = request.getParameter("impartId");
			String contNo = (String)session.getAttribute("ContNo");
			if (contNo != null)
			{
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				LNPContSchema contSch = mainInfo.getContByContNo(contNo);
				String InsuredId = contSch.getInsuredId();
				String operateType = request.getParameter("operateType");
				System.out.println((new StringBuilder("-- operateType --")).append(operateType).toString());
				IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
				boolean flag = false;
				String errorMsg = "";
				boolean isExistUselessCharTag = true;
				LNPCustImpResultSet relSet = new LNPCustImpResultSet();
				try
				{
					ExeSQL tExeSql1 = new ExeSQL();
					String sql = "";
					sql = (new StringBuilder("select distinct questionid  from LNPCustImpQue where impartid='")).append(impartId).append("' and questiontype in('1','2') ").toString();
					SSRS tSSRS1 = tExeSql1.execSQL(sql);
					SSRS tSSRS2 = new SSRS();
					if (tSSRS1.MaxRow > 0)
					{
						String date = PubFun.getCurrentDate();
						String time = PubFun.getCurrentTime();
						SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
						LNPCustImpResultSchema relSch = null;
						for (int i = 1; i <= tSSRS1.MaxRow; i++)
							if (request.getParameter((new StringBuilder("R")).append(tSSRS1.GetText(i, 1)).toString()) != null && !request.getParameter((new StringBuilder("R")).append(tSSRS1.GetText(i, 1)).toString()).equals(""))
							{
								relSch = new LNPCustImpResultSchema();
								sql = (new StringBuilder("select questionid,questiontype,queorder,innerorder,innerquenum,childquenum from LNPCustImpQue where impartid='")).append(impartId).append("' and questionid='").append(tSSRS1.GetText(i, 1)).append("' ;").toString();
								tSSRS2 = tExeSql1.execSQL(sql);
								if (tSSRS2.MaxRow > 0)
								{
									if (tSSRS2.GetText(1, 2).equals("1"))
									{
										String optionid = request.getParameter((new StringBuilder("R")).append(tSSRS2.GetText(1, 1)).toString());
										relSch.setOptionId(optionid);
									} else
									if (tSSRS2.GetText(1, 2).equals("2"))
										relSch.setAnswer(request.getParameter((new StringBuilder("R")).append(tSSRS2.GetText(1, 1)).toString()));
									relSch.setResultId(maxNoMap.CreateMaxNo("ImpReslutId", ""));
									relSch.setImpartId(impartId);
									relSch.setQuestionId(tSSRS2.GetText(1, 1));
									relSch.setContNo(contNo);
									relSch.setProposalContNo(contNo);
									relSch.setCustomerId(InsuredId);
									relSch.setQuestionType(tSSRS2.GetText(1, 2));
									relSch.setOperator(tempGI.Operator);
									relSch.setManageCom(tempGI.ComCode);
									relSch.setMakeDate(date);
									relSch.setMakeTime(time);
									relSch.setModifyDate(date);
									relSch.setModifyTime(time);
									contSch.setModifyDate(date);
									contSch.setModifyTime(time);
									relSet.add(relSch);
								} else
								{
									errorMsg = "��ѯ��֪�����??";
								}
								if (!ValidateTools.isExistUselessChar(request.getParameter((new StringBuilder("R")).append(tSSRS1.GetText(i, 1)).toString())))
									isExistUselessCharTag = false;
							}

					} else
					{
						errorMsg = "��ѯ��֪�����??";
					}
					System.out.println((new StringBuilder("-- relset.size --")).append(relSet.size()).toString());
					if (relSet.size() > 0)
					{
						if (isExistUselessCharTag)
						{
							ImpartDeal impartDeal = new ImpartDeal();
							flag = impartDeal.dealImpResult(relSet, operateType, contSch);
							if (flag)
								errorMsg = "��֪����ɹ���?";
							else
								errorMsg = "��֪����ʧ��!";
						} else
						{
							errorMsg = " �����˸�֪�洢��SQL�а�Ƿ��ַ�? ��";
						}
					} else
					{
						errorMsg = "����д��֪���ݣ�";
					}
					System.out.println(errorMsg);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				session.removeAttribute("insuDiscripInformSubmit");
				session.setAttribute("insuDiscripFalshFlag", "1");
				request.setAttribute("DisFlag", Boolean.valueOf(flag));
				request.setAttribute("DisMessage", errorMsg);
				String type = "";
				ImpartDeal iDeal = new ImpartDeal();
				type = iDeal.getImpartType(session);
				response.sendRedirect((new StringBuilder("insuDiscrip")).append(type).append(".jsf").toString());
			} else
			{
				session.invalidate();
				response.sendRedirect("insuDiscripSessionNULL.jsp");
			}
		}
	}

	public String getShowFlag(HttpServletRequest req)
	{
		String flag = "";
		HttpSession session = req.getSession(true);
		if (session != null)
		{
			String showFlag = new String();
			showFlag = (String)session.getAttribute("insuDiscripFalshFlag");
			if (showFlag != null && "1".equals(showFlag))
			{
				flag = showFlag;
				session.removeAttribute("insuDiscripFalshFlag");
			}
		}
		return flag;
	}
}
