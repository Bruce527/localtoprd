// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FinanceAndInsure.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPFAndIImpResultDB;
import com.sinosoft.banklns.lis.db.LNPInsureHistoryDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.schema.LNPInsureHistorySchema;
import com.sinosoft.banklns.lis.vschema.LNPFAndIImpResultSet;
import com.sinosoft.banklns.lis.vschema.LNPInsureHistorySet;
import com.sinosoft.banklns.lnsmodel.entity.LNPFinanceAndInsureBean;
import com.sinosoft.banklns.utility.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			PolicyMainInfo, StateOperatorDeal

public class FinanceAndInsure
{

	private LNPInsureHistorySchema lnpInsureHistorySchema;
	private LNPFinanceAndInsureBean lnpInsureHistoryBean;
	private List insureHistoryList;
	private boolean modifyTag;
	private boolean operateResult;
	private String message;
	private String contNo;
	private boolean pageEditTag;
	private boolean editFlag;
	private boolean showMesFlag;
	Map stateMap;

	public FinanceAndInsure()
	{
		lnpInsureHistorySchema = new LNPInsureHistorySchema();
		lnpInsureHistoryBean = new LNPFinanceAndInsureBean();
		insureHistoryList = null;
		modifyTag = false;
		operateResult = true;
		message = "";
		contNo = "";
		pageEditTag = true;
		editFlag = true;
		showMesFlag = false;
		stateMap = new HashMap();
	}

	public void initData()
	{
		try
		{
			initStateMap();
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
			if (getEditFlag != null)
				if (getEditFlag.booleanValue())
					editFlag = true;
				else
					editFlag = false;
			contNo = (String)session.getAttribute("ContNo");
			if (insureHistoryList != null)
				insureHistoryList.clear();
			if (contNo != null)
			{
				getLnpInsureHistorySchemaList(contNo);
				setpageEditTagWithSet();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void saveFinanceAndInsure()
	{
		if (validate() && contNo != null && !"".equals(contNo))
		{
			if (!modifyTag)
			{
				LNPInsureHistorySchema tempSchema = getContByNo(contNo);
				if (tempSchema != null)
				{
					Integer polOrderNum = new Integer(tempSchema.getPolOrder());
					polOrderNum = Integer.valueOf(polOrderNum.intValue() + 1);
					tempSchema.setPolOrder(polOrderNum.toString());
					lnpInsureHistorySchema.setPolOrder(tempSchema.getPolOrder());
				} else
				{
					lnpInsureHistorySchema.setPolOrder("1");
				}
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				LNPContSchema contSch = mainInfo.getContByContNo(contNo);
				lnpInsureHistorySchema.setSumInsuredDeath((new Double(lnpInsureHistoryBean.getSumInsuredDeath())).doubleValue() * 10000D);
				lnpInsureHistorySchema.setSumInsuredDisease((new Double(lnpInsureHistoryBean.getSumInsuredDisease())).doubleValue() * 10000D);
				lnpInsureHistorySchema.setGrpContNo(contSch.getGrpContNo());
				lnpInsureHistorySchema.setContNo(contNo);
				lnpInsureHistorySchema.setProposalContNo(contNo);
				lnpInsureHistorySchema.setPrtNo(contSch.getPrtNo());
				lnpInsureHistorySchema.setComName(lnpInsureHistorySchema.getComName());
				lnpInsureHistorySchema.setSumInsuredDeath(lnpInsureHistorySchema.getSumInsuredDeath());
				lnpInsureHistorySchema.setSumInsuredDisease(lnpInsureHistorySchema.getSumInsuredDisease());
				lnpInsureHistorySchema.setPolicyState(lnpInsureHistorySchema.getPolicyState());
				HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				IGlobalInput tempGI = (IGlobalInput)session.getAttribute("NPGI");
				if (tempGI == null)
				{
					message = "���񼰱��վ�������";
					operateResult = false;
				}
				lnpInsureHistorySchema.setOperator(tempGI.Operator);
				String date = PubFun.getCurrentDate();
				String time = PubFun.getCurrentTime();
				lnpInsureHistorySchema.setMakeDate(date);
				lnpInsureHistorySchema.setMakeTime(time);
				lnpInsureHistorySchema.setModifyDate(date);
				lnpInsureHistorySchema.setModifyTime(time);
				try
				{
					PubSubmit ps = new PubSubmit();
					MMap map = new MMap();
					StateOperatorDeal operatorDeal = new StateOperatorDeal();
					List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "add", "07");
					contSch.setState((String)stateList.get(0));
					contSch.setEditstate((String)stateList.get(1));
					if ("2".equals(contSch.getUWFlag()))
						contSch.setUWFlag("1");
					map.put(contSch, "UPDATE");
					map.put(lnpInsureHistorySchema, "INSERT");
					VData vd = new VData();
					vd.add(map);
					if (!ps.submitData(vd, ""))
					{
						message = "���񼰱��վ�������";
						operateResult = false;
						showMesFlag = true;
					} else
					{
						message = "���񼰱��վ����ɹ�";
						operateResult = true;
						showMesFlag = false;
						getLnpInsureHistorySchemaList(lnpInsureHistorySchema.getContNo());
					}
					setpageEditTagWithSet();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			} else
			{
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				LNPContSchema contSch = mainInfo.getContByContNo(contNo);
				lnpInsureHistorySchema.setComName(lnpInsureHistorySchema.getComName());
				lnpInsureHistorySchema.setSumInsuredDeath((new Double(lnpInsureHistoryBean.getSumInsuredDeath())).doubleValue() * 10000D);
				lnpInsureHistorySchema.setSumInsuredDisease((new Double(lnpInsureHistoryBean.getSumInsuredDisease())).doubleValue() * 10000D);
				lnpInsureHistorySchema.setPolicyState(lnpInsureHistorySchema.getPolicyState());
				try
				{
					PubSubmit ps = new PubSubmit();
					MMap map = new MMap();
					StateOperatorDeal operatorDeal = new StateOperatorDeal();
					List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "07");
					contSch.setState((String)stateList.get(0));
					contSch.setEditstate((String)stateList.get(1));
					if ("2".equals(contSch.getUWFlag()))
						contSch.setUWFlag("1");
					map.put(contSch, "UPDATE");
					map.put(lnpInsureHistorySchema, "UPDATE");
					VData vd = new VData();
					vd.add(map);
					if (!ps.submitData(vd, ""))
					{
						message = "���񼰱��վ�����´���?";
						operateResult = false;
						showMesFlag = true;
					} else
					{
						message = "���񼰱��վ�����³ɹ�?";
						operateResult = true;
						showMesFlag = true;
						getLnpInsureHistorySchemaList(lnpInsureHistorySchema.getContNo());
					}
					setpageEditTagWithSet();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			lnpInsureHistorySchema = new LNPInsureHistorySchema();
		}
	}

	public void modifyFinanceAndInsure()
	{
		try
		{
			Map resultMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String polOrder = (String)resultMap.get("polOrder");
			lnpInsureHistorySchema = getContByPolOrder(polOrder);
			lnpInsureHistoryBean.setSumInsuredDeath(getFormatString(lnpInsureHistorySchema.getSumInsuredDeath() / 10000D));
			lnpInsureHistoryBean.setSumInsuredDisease(getFormatString(lnpInsureHistorySchema.getSumInsuredDisease() / 10000D));
			modifyTag = true;
			pageEditTag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void removeFinanceAndInsure()
	{
		try
		{
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema contSch = mainInfo.getContByContNo(contNo);
			StateOperatorDeal operatorDeal = new StateOperatorDeal();
			if (checkDataNum(contNo) || checkApprizDataNum(contNo))
			{
				List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "07");
				contSch.setState((String)stateList.get(0));
				contSch.setEditstate((String)stateList.get(1));
			} else
			{
				List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "delete", "07");
				contSch.setState((String)stateList.get(0));
				contSch.setEditstate((String)stateList.get(1));
			}
			if ("2".equals(contSch.getUWFlag()))
				contSch.setUWFlag("1");
			map.put(contSch, "UPDATE");
			Map resultMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String polOrder = (String)resultMap.get("polOrder");
			lnpInsureHistorySchema = getContByPolOrder(polOrder);
			map.put(lnpInsureHistorySchema, "DELETE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "���񼰱��վ���ɾ��ʧ��";
				operateResult = false;
				showMesFlag = true;
			} else
			{
				message = "���񼰱��վ���ɾ��ɹ�?";
				operateResult = true;
				showMesFlag = false;
				pageEditTag = true;
				getLnpInsureHistorySchemaList(lnpInsureHistorySchema.getContNo());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		lnpInsureHistorySchema = new LNPInsureHistorySchema();
		initData();
	}

	public boolean checkDataNum(String contNoStr)
	{
		LNPInsureHistoryDB db = new LNPInsureHistoryDB();
		String sql = (new StringBuilder("select * from LNPInsureHistory where  ContNo = '")).append(contNoStr).append("'").toString();
		LNPInsureHistorySet ihSet = db.executeQuery(sql);
		return ihSet != null && ihSet.size() > 0;
	}

	public boolean checkApprizDataNum(String contNoStr)
	{
		LNPFAndIImpResultDB db = new LNPFAndIImpResultDB();
		String sql = (new StringBuilder("select * from lnpfandiimpresult where  ContNo = '")).append(contNoStr).append("'").toString();
		LNPFAndIImpResultSet ihSet = db.executeQuery(sql);
		return ihSet != null && ihSet.size() > 0;
	}

	private LNPInsureHistorySet getLNPInsureHistorySetDatas(String contNoStr)
	{
		LNPInsureHistoryDB db = new LNPInsureHistoryDB();
		String sql = (new StringBuilder("select * from LNPInsureHistory where  ContNo = '")).append(contNoStr).append("'").toString();
		LNPInsureHistorySet ihSet = db.executeQuery(sql);
		return ihSet;
	}

	private void setpageEditTagWithSet()
	{
		LNPInsureHistorySet iSet = getLNPInsureHistorySetDatas(contNo);
		if (iSet != null && iSet.size() >= 2)
			pageEditTag = false;
		else
			pageEditTag = true;
	}

	private void getLnpInsureHistorySchemaList(String contNoStr)
	{
		LNPInsureHistoryDB db = new LNPInsureHistoryDB();
		String sql = (new StringBuilder("select * from LNPInsureHistory where  ContNo = '")).append(contNoStr).append("'").toString();
		LNPInsureHistorySet ihSet = db.executeQuery(sql);
		if (ihSet != null && ihSet.size() > 0)
		{
			insureHistoryList = new ArrayList();
			for (int i = 1; i <= ihSet.size(); i++)
			{
				LNPInsureHistorySchema temp = ihSet.get(i);
				LNPFinanceAndInsureBean tempbean = new LNPFinanceAndInsureBean();
				tempbean.setSchema(temp);
				String sumInsuredDeath = getFormatString(temp.getSumInsuredDeath() / 10000D);
				String sumInsuredDisease = getFormatString(temp.getSumInsuredDisease() / 10000D);
				tempbean.setSumInsuredDeath(sumInsuredDeath);
				tempbean.setSumInsuredDisease(sumInsuredDisease);
				tempbean.setPolicyState((String)stateMap.get(temp.getPolicyState()));
				if (editFlag)
					tempbean.setListShowTag("inline-block");
				else
					tempbean.setListShowTag("none");
				insureHistoryList.add(tempbean);
			}

		}
	}

	private LNPInsureHistorySchema getContByNo(String contNoStr)
	{
		LNPInsureHistoryDB db = new LNPInsureHistoryDB();
		String sql = (new StringBuilder("SELECT top 1 * FROM LNPInsureHistory WHERE  ContNo = '")).append(contNoStr).append("' order by PolOrder desc").toString();
		LNPInsureHistorySet set = db.executeQuery(sql);
		if (set != null && set.size() > 0)
			return set.get(1);
		else
			return null;
	}

	private LNPInsureHistorySchema getContByPolOrder(String polOrder)
	{
		LNPInsureHistoryDB db = new LNPInsureHistoryDB();
		db.setContNo(contNo);
		db.setPolOrder(polOrder);
		if (db.getInfo())
			return db.getSchema();
		else
			return null;
	}

	private void initStateMap()
	{
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='contStatus' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS != null && tSRS.MaxRow > 0)
		{
			for (int i = 1; i <= tSRS.MaxRow; i++)
				stateMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

		}
	}

	private String getDoubleStr(String value)
	{
		if (value == null)
			return null;
		String result = "";
		int ch = 0;
		ch = value.lastIndexOf(".");
		if (-1 == ch)
		{
			result = value;
		} else
		{
			String dotper = value.substring(0, ch);
			String dotAft = value.substring(ch, value.length());
			dotAft = dotAft.length() <= 5 ? dotAft : dotAft.substring(0, 5);
			result = (new StringBuilder(String.valueOf(dotper))).append(dotAft).toString();
		}
		return result;
	}

	private String getFormatString(double inputStr)
	{
		DecimalFormat myformat = new DecimalFormat("#0.0000");
		DecimalFormat myformatcheck = new DecimalFormat("#0");
		String reuslt = "";
		if ((double)(int)inputStr != inputStr)
			reuslt = myformat.format(inputStr);
		else
			reuslt = myformatcheck.format(inputStr);
		return reuslt;
	}

	private boolean validate()
	{
		message = "";
		if (lnpInsureHistorySchema.getComName() == null || "".equals(lnpInsureHistorySchema.getComName().trim()))
		{
			message = " ��¼�뱣�չ�˾��ƺ��ٱ���?";
			return false;
		}
		if (!ValidateTools.isExistUselessChar(lnpInsureHistorySchema.getComName()))
		{
			message = " ���չ�˾���ֻ�������ġ���ĸ�����ּ��ַ�? ��_���������?";
			return false;
		}
		if (0.0D > lnpInsureHistorySchema.getSumInsuredDeath())
		{
			message = "��¼��������ܱ�����ٱ��棡";
			return false;
		}
		if (0.0D > lnpInsureHistorySchema.getSumInsuredDisease())
		{
			message = "��¼���ش󼲲��ܱ�����ٱ���?";
			return false;
		}
		if (!ValidateTools.isExistUselessChar(String.valueOf(lnpInsureHistorySchema.getSumInsuredDeath())))
		{
			message = " ������ܱ���ֻ�������֣��������ٱ���?";
			return false;
		}
		if (!ValidateTools.isExistUselessChar(String.valueOf(lnpInsureHistorySchema.getSumInsuredDisease())))
		{
			message = " �ش󼲲��ܱ���ֻ�������֣��������ٱ��棡";
			return false;
		}
		if (lnpInsureHistorySchema.getPolicyState() == null || "".equals(lnpInsureHistorySchema.getPolicyState().trim()) || "-1".equals(lnpInsureHistorySchema.getPolicyState().trim()))
		{
			message = " ��¼�뱣��״̬���ٱ��棡";
			return false;
		} else
		{
			return true;
		}
	}

	public LNPInsureHistorySchema getLnpInsureHistorySchema()
	{
		return lnpInsureHistorySchema;
	}

	public void setLnpInsureHistorySchema(LNPInsureHistorySchema lnpInsureHistorySchema)
	{
		this.lnpInsureHistorySchema = lnpInsureHistorySchema;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public List getInsureHistoryList()
	{
		return insureHistoryList;
	}

	public void setInsureHistoryList(List insureHistoryList)
	{
		this.insureHistoryList = insureHistoryList;
	}

	public boolean isOperateResult()
	{
		return operateResult;
	}

	public void setOperateResult(boolean operateResult)
	{
		this.operateResult = operateResult;
	}

	public boolean isPageEditTag()
	{
		return pageEditTag;
	}

	public void setPageEditTag(boolean pageEditTag)
	{
		this.pageEditTag = pageEditTag;
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

	public LNPFinanceAndInsureBean getLnpInsureHistoryBean()
	{
		return lnpInsureHistoryBean;
	}

	public void setLnpInsureHistoryBean(LNPFinanceAndInsureBean lnpInsureHistoryBean)
	{
		this.lnpInsureHistoryBean = lnpInsureHistoryBean;
	}
}
