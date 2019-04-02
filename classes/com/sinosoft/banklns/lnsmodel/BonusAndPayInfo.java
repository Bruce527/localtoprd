// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BonusAndPayInfo.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPBonusInfoDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			StateOperatorDeal, PolicyMainInfo

public class BonusAndPayInfo
{

	private LNPBonusInfoSchema lnpBonusInfoSchema;
	private List bonusAndPayTypeList;
	private List frontalClearedTypeList;
	private String message;
	private String contNo;
	private boolean isHasExist;
	private boolean editFlag;
	private boolean hasBonusAndPaytag;

	public BonusAndPayInfo()
	{
		lnpBonusInfoSchema = new LNPBonusInfoSchema();
		bonusAndPayTypeList = new ArrayList();
		frontalClearedTypeList = new ArrayList();
		message = "";
		contNo = "";
		isHasExist = false;
		editFlag = true;
		hasBonusAndPaytag = true;
	}

	public void initData()
	{
		try
		{
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			contNo = (String)session.getAttribute("ContNo");
			if (contNo != null)
				lnpBonusInfoSchema = getLnpBonusInfoSchemaFromDB(contNo);
			Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
			if (getEditFlag != null)
				if (getEditFlag.booleanValue())
					editFlag = true;
				else
					editFlag = false;
			List list = getBonusAndPayTypeList();
			if (list.size() > 0)
			{
				hasBonusAndPaytag = true;
			} else
			{
				hasBonusAndPaytag = false;
				message = " ��ǰ��Ʒ�޺�����Ϣ�� ";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void saveBonusAndPayInfo()
	{
		PubSubmit ps = new PubSubmit();
		MMap map = new MMap();
		StateOperatorDeal operatorDeal = new StateOperatorDeal();
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema contSch = mainInfo.getContByContNo(contNo);
		if (validate() && contNo != null && !"".equals(contNo.trim()) && contSch != null)
		{
			if (isHasExist)
			{
				LNPBonusInfoSchema delSchema = getLnpBonusInfoSchemaFromDB(contNo);
				map.put(delSchema, "DELETE");
				List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "05");
				contSch.setState((String)stateList.get(0));
				contSch.setEditstate((String)stateList.get(1));
			} else
			{
				List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "add", "05");
				contSch.setState((String)stateList.get(0));
				contSch.setEditstate((String)stateList.get(1));
			}
			map.put(contSch, "UPDATE");
			LNPBonusInfoSchema tempSchema = new LNPBonusInfoSchema();
			tempSchema.setGrpContNo(contSch.getGrpContNo());
			tempSchema.setContNo(contNo);
			tempSchema.setProposalContNo(contNo);
			tempSchema.setPrtNo(contSch.getPrtNo());
			String bonusType = "";
			ExeSQL tExeSql = new ExeSQL();
			String sql = (new StringBuilder("select top 1 cfg.bonustype from lnppol pol,lnpriskconfig cfg where pol.contno = '")).append(contNo).append("' ").append("and pol.masterpolno = pol.polno and pol.riskcode=cfg.riskcode").toString();
			SSRS ssrs = tExeSql.execSQL(sql);
			if (ssrs != null && ssrs.MaxRow > 0 && ssrs.GetText(1, 1) != null)
				bonusType = ssrs.GetText(1, 1).trim();
			tempSchema.setBonusType(bonusType);
			tempSchema.setBonusWay(lnpBonusInfoSchema.getBonusWay());
			tempSchema.setAutoRepaid(lnpBonusInfoSchema.getAutoRepaid());
			tempSchema.setCutPayAll(lnpBonusInfoSchema.getCutPayAll());
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			IGlobalInput tempGI = (IGlobalInput)session.getAttribute("NPGI");
			if (tempGI != null)
				tempSchema.setOperator(tempGI.Operator);
			String date = PubFun.getCurrentDate();
			String time = PubFun.getCurrentTime();
			tempSchema.setMakeDate(date);
			tempSchema.setMakeTime(time);
			tempSchema.setModifyDate(date);
			tempSchema.setModifyTime(time);
			try
			{
				map.put(tempSchema, "INSERT");
				VData vd = new VData();
				vd.add(map);
				if (ps.submitData(vd, ""))
					message = " ������Ϣ����ɹ�?! ";
				else
					message = " ������Ϣ����ʧ�� ! ";
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			System.out.println((new StringBuilder("message : ")).append(message).toString());
		}
	}

	private LNPBonusInfoSchema getLnpBonusInfoSchemaFromDB(String str)
	{
		LNPBonusInfoDB db = new LNPBonusInfoDB();
		db.setContNo(str);
		if (db.getInfo())
		{
			isHasExist = true;
			return db.getSchema();
		} else
		{
			isHasExist = false;
			return new LNPBonusInfoSchema();
		}
	}

	private List getBonusAndPayTypeListList(String typename, String contNo)
	{
		List reList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select d.code,d.codename from lnpcode d,lnpbonusconfig c,lnpriskconfig b,lnppol a where  d.code = c.bonusway and c.bonustype = b.bonustype and b.riskcode = a.riskcode and a.masterpolno = a.polno and a.contno = '")).append(contNo).append("' and d.codetype='").append(typename).append("' order by d.code").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS != null)
		{
			for (int i = 1; i <= tSRS.MaxRow; i++)
				reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		}
		return reList;
	}

	private List getFrontalClearedTypeListList(String typename, String contNo)
	{
		List reList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select code,codename from lnpcode where codetype = '")).append(typename).append("' ").append("and codealias =(").append("select p1 from LNPRiskConfig a,lnppol b where a.riskcode =b.riskcode and b.contno='").append(contNo).append("') ").append("union ").append("select code,codename from lnpcode where codetype = '").append(typename).append("' ").append("and comcode =(").append("select p1 from LNPRiskConfig a,lnppol b where a.riskcode =b.riskcode and b.contno='").append(contNo).append("')").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS != null)
		{
			for (int i = 1; i <= tSRS.MaxRow; i++)
				reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		}
		return reList;
	}

	private boolean validate()
	{
		message = "";
		if (lnpBonusInfoSchema.getBonusWay() == null || "".equals(lnpBonusInfoSchema.getBonusWay().trim()) || "-1".equals(lnpBonusInfoSchema.getBonusWay().trim()))
		{
			message = " ��ѡ��������÷�ʽ���ٱ���?";
			return false;
		}
		if (lnpBonusInfoSchema.getAutoRepaid() == null || "".equals(lnpBonusInfoSchema.getAutoRepaid().trim()) || "-1".equals(lnpBonusInfoSchema.getAutoRepaid().trim()))
		{
			message = " ��ѡ�񱣷��Զ��潻�����ٱ��棡";
			return false;
		}
		if (lnpBonusInfoSchema.getCutPayAll() == null || "".equals(lnpBonusInfoSchema.getCutPayAll().trim()) || "-1".equals(lnpBonusInfoSchema.getCutPayAll().trim()))
		{
			message = " ��ѡ����屣�������ٱ��棡";
			return false;
		} else
		{
			return true;
		}
	}

	public LNPBonusInfoSchema getLnpBonusInfoSchema()
	{
		return lnpBonusInfoSchema;
	}

	public void setLnpBonusInfoSchema(LNPBonusInfoSchema lnpBonusInfoSchema)
	{
		this.lnpBonusInfoSchema = lnpBonusInfoSchema;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public List getBonusAndPayTypeList()
	{
		if (bonusAndPayTypeList != null)
			bonusAndPayTypeList.clear();
		bonusAndPayTypeList = getBonusAndPayTypeListList("bonusAndPayType", contNo);
		return bonusAndPayTypeList;
	}

	public void setBonusAndPayTypeList(List bonusAndPayTypeList)
	{
		this.bonusAndPayTypeList = bonusAndPayTypeList;
	}

	public boolean isHasBonusAndPaytag()
	{
		return hasBonusAndPaytag;
	}

	public void setHasBonusAndPaytag(boolean hasBonusAndPaytag)
	{
		this.hasBonusAndPaytag = hasBonusAndPaytag;
	}

	public void setFrontalClearedTypeList(List frontalClearedTypeList)
	{
		this.frontalClearedTypeList = frontalClearedTypeList;
	}

	public List getFrontalClearedTypeList()
	{
		if (frontalClearedTypeList != null)
			frontalClearedTypeList.clear();
		frontalClearedTypeList = getFrontalClearedTypeListList("frontalClearedType", contNo);
		return frontalClearedTypeList;
	}
}
