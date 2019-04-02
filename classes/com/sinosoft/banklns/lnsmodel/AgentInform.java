// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AgentInform.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.vschema.LNPAgentImpResultSet;
import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			PolicyMainInfo, StateOperatorDeal

public class AgentInform
{

	private LNPAgentInfoSchema lnpAgentInfoSchema;
	private List lnpAgentInfoList;
	private String message;
	private boolean modifyTag;
	private String contNo;
	private boolean pageEditTag;
	private boolean doClearTag;
	private boolean editFlag;
	private boolean showMesFlag;

	public AgentInform()
	{
		lnpAgentInfoSchema = new LNPAgentInfoSchema();
		lnpAgentInfoList = null;
		message = "";
		modifyTag = false;
		contNo = "";
		pageEditTag = true;
		doClearTag = false;
		editFlag = true;
		showMesFlag = false;
	}

	public void initData()
	{
		try
		{
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
			if (getEditFlag != null)
				if (getEditFlag.booleanValue())
					editFlag = true;
				else
					editFlag = false;
			contNo = (String)session.getAttribute("ContNo");
			if (lnpAgentInfoList != null)
				lnpAgentInfoList.clear();
			if (contNo != null)
			{
				getLNPAgentInfoSchemaList(contNo);
				setpageEditTagWithSet();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void saveAgentInform()
	{
		if (validate() && contNo != null && !"".equals(contNo))
		{
			MMap map = new MMap();
			LNPAgentInfoSchema tempSchema = getSchemaByContNo(contNo);
			if (tempSchema != null)
			{
				Integer agentOrderNum = new Integer(tempSchema.getAgentOrder());
				agentOrderNum = Integer.valueOf(agentOrderNum.intValue() + 1);
				lnpAgentInfoSchema.setAgentOrder(agentOrderNum.toString());
			} else
			{
				lnpAgentInfoSchema.setAgentOrder("1");
			}
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema contSch = mainInfo.getContByContNo(contNo);
			if (contSch != null)
			{
				lnpAgentInfoSchema.setGrpContNo(contSch.getGrpContNo());
				lnpAgentInfoSchema.setContNo(contNo);
				lnpAgentInfoSchema.setProposalContNo(contNo);
				lnpAgentInfoSchema.setPrtNo(contSch.getPrtNo());
				lnpAgentInfoSchema.setAgentName(lnpAgentInfoSchema.getAgentName());
				lnpAgentInfoSchema.setAgentCode(lnpAgentInfoSchema.getAgentCode());
				lnpAgentInfoSchema.setBranchName(lnpAgentInfoSchema.getBranchName());
				lnpAgentInfoSchema.setBranchAttr(lnpAgentInfoSchema.getBranchAttr());
				HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				IGlobalInput tempGI = (IGlobalInput)session.getAttribute("NPGI");
				if (tempGI != null)
					lnpAgentInfoSchema.setOperator(tempGI.Operator);
				String date = PubFun.getCurrentDate();
				String time = PubFun.getCurrentTime();
				lnpAgentInfoSchema.setMakeDate(date);
				lnpAgentInfoSchema.setMakeTime(time);
				lnpAgentInfoSchema.setModifyDate(date);
				lnpAgentInfoSchema.setModifyTime(time);
				StateOperatorDeal operatorDeal = new StateOperatorDeal();
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
			}
			try
			{
				LNPContSchema lnpContSchema = updateLNPCont(lnpAgentInfoSchema, "INSERT");
				PubSubmit ps = new PubSubmit();
				map.put(lnpAgentInfoSchema, "INSERT");
				map.put(lnpContSchema, "UPDATE");
				map.put(contSch, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (ps.submitData(vd, ""))
				{
					message = "代理人信息保存成�?";
					getLNPAgentInfoSchemaList(lnpAgentInfoSchema.getContNo());
					showMesFlag = false;
				} else
				{
					message = "代理人信息保存失�?";
					showMesFlag = true;
				}
				setpageEditTagWithSet();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			lnpAgentInfoSchema = new LNPAgentInfoSchema();
		}
	}

	public void modifyAgentInform()
	{
		try
		{
			Map resultMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String agentOrder = (String)resultMap.get("agentOrder");
			if (agentOrder != null)
			{
				lnpAgentInfoSchema = getSchemaByAgentOrder(agentOrder);
				if (lnpAgentInfoSchema == null)
					lnpAgentInfoSchema = new LNPAgentInfoSchema();
				modifyTag = true;
				pageEditTag = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void removeAgentInform()
	{
		try
		{
			Map resultMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String agentOrder = (String)resultMap.get("agentOrder");
			if (agentOrder != null)
			{
				lnpAgentInfoSchema = getSchemaByAgentOrder(agentOrder);
				if (lnpAgentInfoSchema != null)
				{
					LNPContSchema lnpContSchema = updateLNPCont(lnpAgentInfoSchema, "DELETE");
					PubSubmit ps = new PubSubmit();
					MMap map = new MMap();
					PolicyMainInfo mainInfo = new PolicyMainInfo();
					LNPContSchema contSch = mainInfo.getContByContNo(contNo);
					StateOperatorDeal operatorDeal = new StateOperatorDeal();
					if (checkDataNum(contNo) || checkApprizDataNum(contNo))
					{
						List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "09");
						contSch.setState((String)stateList.get(0));
						contSch.setEditstate((String)stateList.get(1));
					} else
					{
						List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "delete", "09");
						contSch.setState((String)stateList.get(0));
						contSch.setEditstate((String)stateList.get(1));
					}
					if ("2".equals(contSch.getUWFlag()))
						contSch.setUWFlag("1");
					map.put(lnpAgentInfoSchema, "DELETE");
					map.put(lnpContSchema, "UPDATE");
					map.put(contSch, "UPDATE");
					VData vd = new VData();
					vd.add(map);
					if (ps.submitData(vd, ""))
					{
						message = "代理人信息删除成�?";
						getLNPAgentInfoSchemaList(lnpAgentInfoSchema.getContNo());
						showMesFlag = false;
					} else
					{
						message = "代理人信息删除失�?";
						showMesFlag = true;
					}
					setpageEditTagWithSet();
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		lnpAgentInfoSchema = new LNPAgentInfoSchema();
		initData();
	}

	private void getLNPAgentInfoSchemaList(String contNoStr)
	{
		LNPAgentInfoDB db = new LNPAgentInfoDB();
		String sql = (new StringBuilder("select * from lnpagentinfo where  contno = '")).append(contNoStr).append("'").toString();
		LNPAgentInfoSet iSet = db.executeQuery(sql);
		if (iSet != null && iSet.size() > 0)
		{
			lnpAgentInfoList = new ArrayList();
			for (int i = 1; i <= iSet.size(); i++)
			{
				LNPAgentInfoSchema temp = iSet.get(i);
				if (editFlag)
					temp.setP1("inline-block");
				else
					temp.setP1("none");
				lnpAgentInfoList.add(temp);
			}

		}
	}

	private LNPAgentInfoSchema getSchemaByContNo(String contNoStr)
	{
		LNPAgentInfoDB db = new LNPAgentInfoDB();
		String sql = (new StringBuilder("select top 1 * from lnpagentinfo where  contno = '")).append(contNoStr).append("' order by AgentOrder desc").toString();
		LNPAgentInfoSet iSet = db.executeQuery(sql);
		if (iSet != null && iSet.size() > 0)
			return iSet.get(1);
		else
			return null;
	}

	private LNPAgentInfoSchema getSchemaByAgentOrder(String agentOrder)
	{
		LNPAgentInfoDB db = new LNPAgentInfoDB();
		db.setContNo(contNo);
		db.setAgentOrder(agentOrder);
		if (db.getInfo())
			return db.getSchema();
		else
			return null;
	}

	private LNPContSchema updateLNPCont(LNPAgentInfoSchema lnpAgentInfoSchema, String type)
	{
		LNPContSchema lnpContSchema = new LNPContSchema();
		LNPContDB contDB = new LNPContDB();
		lnpContSchema.setContNo(lnpAgentInfoSchema.getContNo());
		contDB.setContNo(lnpAgentInfoSchema.getContNo());
		if (contDB.getInfo())
			lnpContSchema = contDB.getSchema();
		if ("INSERT".equals(type))
			if (lnpContSchema.getAgentCode() == null || "".equals(lnpContSchema.getAgentCode().trim()))
			{
				lnpContSchema.setAgentCode(lnpAgentInfoSchema.getAgentCode());
				lnpContSchema.setAgentGroup(lnpAgentInfoSchema.getBranchAttr());
			} else
			{
				lnpContSchema.setAgentCode1(lnpAgentInfoSchema.getAgentCode());
				lnpContSchema.setAgentGroup1(lnpAgentInfoSchema.getBranchAttr());
			}
		if ("DELETE".equals(type))
			if (lnpAgentInfoSchema.getAgentCode().equals(lnpContSchema.getAgentCode()))
			{
				lnpContSchema.setAgentCode("");
				lnpContSchema.setAgentGroup("");
			} else
			{
				lnpContSchema.setAgentCode1("");
				lnpContSchema.setAgentGroup1("");
			}
		return lnpContSchema;
	}

	public boolean checkDataNum(String contNoStr)
	{
		LNPAgentInfoDB db = new LNPAgentInfoDB();
		String sql = (new StringBuilder("select * from lnpagentinfo where  contno = '")).append(contNoStr).append("'").toString();
		LNPAgentInfoSet iSet = db.executeQuery(sql);
		return iSet != null && iSet.size() > 0;
	}

	public boolean checkApprizDataNum(String contNoStr)
	{
		LNPAgentImpResultDB db = new LNPAgentImpResultDB();
		String sql = (new StringBuilder("select * from LNPAgentImpResult where  ContNo = '")).append(contNoStr).append("'").toString();
		LNPAgentImpResultSet ihSet = db.executeQuery(sql);
		return ihSet != null && ihSet.size() > 0;
	}

	private LNPAgentInfoSet getLNPAgentInfoSetDatas(String contNoStr)
	{
		LNPAgentInfoDB db = new LNPAgentInfoDB();
		String sql = (new StringBuilder("select * from lnpagentinfo where  contno = '")).append(contNoStr).append("'").toString();
		LNPAgentInfoSet iSet = db.executeQuery(sql);
		return iSet;
	}

	private void setpageEditTagWithSet()
	{
		LNPAgentInfoSet iSet = getLNPAgentInfoSetDatas(contNo);
		if (iSet != null && iSet.size() >= 2)
			pageEditTag = false;
		else
			pageEditTag = true;
	}

	public void getAgentInfo()
	{
		ExeSQL tExeSql = new ExeSQL();
		String branchType = "";
		String agentCode = lnpAgentInfoSchema.getAgentCode();
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		IGlobalInput tempGI = (IGlobalInput)session.getAttribute("NPGI");
		if (tempGI != null)
			branchType = tempGI.chanlesign;
		if (agentCode != null)
			try
			{
				String com = "";
				String preSql = (new StringBuilder("select t.comcode,t.name,t.validcode from lnpcom t where t.validcode = '")).append(contNo.substring(0, 2)).append("'").toString();
				SSRS tSSRSfromCom = tExeSql.execSQL(preSql);
				if (tSSRSfromCom != null && tSSRSfromCom.MaxRow > 0)
					com = tSSRSfromCom.GetText(1, 1);
				String vSql = (new StringBuilder("select v.name as agentname,v.agentcode,t.name as branchname,v.branchattr from laagentv v,labranchgroup t  where  t.agentgroup = v.agentgroup and v.managecom like '86%' and v.branchtype = '")).append(branchType).append("' and v.agentcode ='").append(agentCode).append("' and v.agentcode like '").append(com).append("%'").toString();
				System.out.println((new StringBuilder("AgentInform vSQL : ")).append(vSql).toString());
				SSRS tSSRSfromDB = tExeSql.execSQL(vSql);
				if (hasExistSameAgentCode(agentCode))
				{
					doClearTag = true;
					message = " 不允许录入相同的代理人信�? �? ";
				} else
				if (tSSRSfromDB.MaxRow > 0)
				{
					lnpAgentInfoSchema.setAgentName(tSSRSfromDB.GetText(1, 1));
					lnpAgentInfoSchema.setAgentCode(agentCode);
					lnpAgentInfoSchema.setBranchName(tSSRSfromDB.GetText(1, 3));
					lnpAgentInfoSchema.setBranchAttr(tSSRSfromDB.GetText(1, 4));
					doClearTag = false;
				} else
				{
					doClearTag = true;
					message = " 此代理人的相关信息不允许录入 �? ";
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}

	private boolean hasExistSameAgentCode(String agentCode)
	{
		String sql = (new StringBuilder("select * from LNPAgentInfo where contno='")).append(contNo).append("' and agentcode='").append(agentCode).append("' ").toString();
		ExeSQL tExeSql = new ExeSQL();
		SSRS tSSRSfromDB = tExeSql.execSQL(sql);
		return tSSRSfromDB != null && tSSRSfromDB.MaxRow > 0;
	}

	private boolean validate()
	{
		message = "";
		if (lnpAgentInfoSchema.getAgentCode() == null || "".equals(lnpAgentInfoSchema.getAgentCode().trim()))
		{
			message = " 请填写代理人信息后再进行设置�?";
			return false;
		}
		if (!ValidateTools.isExistUselessChar(lnpAgentInfoSchema.getAgentCode()))
		{
			message = " 代理人编码只能是数字，请更正后再进行设置�?";
			return false;
		} else
		{
			return true;
		}
	}

	public LNPAgentInfoSchema getLnpAgentInfoSchema()
	{
		return lnpAgentInfoSchema;
	}

	public void setLnpAgentInfoSchema(LNPAgentInfoSchema lnpAgentInfoSchema)
	{
		this.lnpAgentInfoSchema = lnpAgentInfoSchema;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public List getLnpAgentInfoList()
	{
		return lnpAgentInfoList;
	}

	public void setLnpAgentInfoList(List lnpAgentInfoList)
	{
		this.lnpAgentInfoList = lnpAgentInfoList;
	}

	public boolean isModifyTag()
	{
		return modifyTag;
	}

	public void setModifyTag(boolean modifyTag)
	{
		this.modifyTag = modifyTag;
	}

	public boolean isPageEditTag()
	{
		return pageEditTag;
	}

	public void setPageEditTag(boolean pageEditTag)
	{
		this.pageEditTag = pageEditTag;
	}

	public boolean isDoClearTag()
	{
		return doClearTag;
	}

	public void setDoClearTag(boolean doClearTag)
	{
		this.doClearTag = doClearTag;
	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public boolean isShowMesFlag()
	{
		return showMesFlag;
	}

	public void setShowMesFlag(boolean showMesFlag)
	{
		this.showMesFlag = showMesFlag;
	}
}
