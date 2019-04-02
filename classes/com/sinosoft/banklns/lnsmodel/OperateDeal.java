// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OperateDeal.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.lnsmodel.interfaces.CalPrem;
import com.sinosoft.banklns.lnsmodel.interfaces.FinalSubmissionBean;
import com.sinosoft.banklns.lnsmodel.interfaces.NPUWBean;
import com.sinosoft.banklns.lnsmodel.util.SugError;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			StateOperatorDeal, PolicyMainInfo, RiskCheckCenterImpl, InterFaceCheck

public class OperateDeal
{

	private String contNo;
	private String state;
	private String editState;
	private String lnpUserType;
	private boolean editFlag;
	private boolean contPayMentFlag;
	private boolean underWriteFlag;
	private boolean showUnderWriteAnswerFlag;
	private boolean submitFlag;
	private boolean repealFlag;
	private boolean alertFlag;
	private String message;
	private String addPremFlag;
	private boolean uwURLShowFlag;
	private boolean uwURLFlag;
	private String uwurl;
	private boolean calPremSuccFlag;
	private boolean calHtmlErrorShowFlag;
	private boolean underWriteSuccFlag;
	private boolean underWriteErrorShowFlag;
	private boolean submitSuccFlag;
	private boolean submitErrorShowFlag;
	private String contNoTemp;

	public OperateDeal()
	{
	}

	public String getUwurl()
	{
		return uwurl;
	}

	public void setUwurl(String uwurl)
	{
		this.uwurl = uwurl;
	}

	public String getAddPremFlag()
	{
		return addPremFlag;
	}

	public void setAddPremFlag(String addPremFlag)
	{
		this.addPremFlag = addPremFlag;
	}

	public void init()
	{
		StateOperatorDeal stateDeal = new StateOperatorDeal();
		editFlag = false;
		contPayMentFlag = false;
		underWriteFlag = false;
		showUnderWriteAnswerFlag = false;
		submitFlag = false;
		repealFlag = false;
		uwURLShowFlag = false;
		addPremFlag = "0";
		if (getInfoFromSession())
			if (lnpUserType != null && lnpUserType.equals("1"))
			{
				HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				LNPContSchema lnpSch = mainInfo.getContByContNo(contNo);
				if (!"0".equals(lnpSch.getLang()))
				{
					editFlag = false;
					showUnderWriteAnswerFlag = stateDeal.checkShowUnderWriteAnswerOperate(contNo);
					if ("05".equals(state) && "2".equals(lnpSch.getAppFlag()) && "2".equals(lnpSch.getLang()) || "03".equals(state) && "3".equals(lnpSch.getAppFlag()) && "1".equals(lnpSch.getLang()))
					{
						editFlag = stateDeal.checkEditOperate(state, lnpUserType, contNo);
						contPayMentFlag = stateDeal.checkContPayMentOperate(state, editState);
						underWriteFlag = stateDeal.checkUnderWriteOperate(state, editState);
						showUnderWriteAnswerFlag = stateDeal.checkShowUnderWriteAnswerOperate(contNo);
						submitFlag = stateDeal.checkSubmitFlagOperate(state, editState, lnpUserType, contNo);
						addPremFlag = stateDeal.checkShowAddPremOperate(contNo);
						uwurl = getUWURLByContno(contNo);
						if (uwurl != null && !"".equals(uwurl))
							uwURLShowFlag = true;
					}
				} else
				{
					editFlag = stateDeal.checkEditOperate(state, lnpUserType, contNo);
					contPayMentFlag = stateDeal.checkContPayMentOperate(state, editState);
					underWriteFlag = stateDeal.checkUnderWriteOperate(state, editState);
					showUnderWriteAnswerFlag = stateDeal.checkShowUnderWriteAnswerOperate(contNo);
					submitFlag = stateDeal.checkSubmitFlagOperate(state, editState, lnpUserType, contNo);
					addPremFlag = stateDeal.checkShowAddPremOperate(contNo);
					uwurl = getUWURLByContno(contNo);
					if (uwurl != null && !"".equals(uwurl))
						uwURLShowFlag = true;
				}
				session.setAttribute("editFlag", Boolean.valueOf(editFlag));
			} else
			if (lnpUserType != null && lnpUserType.equals("2"))
			{
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				LNPContSchema lnpSch = mainInfo.getContByContNo(contNo);
				editFlag = false;
				HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				showUnderWriteAnswerFlag = stateDeal.checkShowUnderWriteAnswerOperate(contNo);
				if (!"0".equals(lnpSch.getLang()))
				{
					editFlag = stateDeal.checkEditOperate(state, lnpUserType, contNo);
					contPayMentFlag = stateDeal.checkContPayMentOperate(state, editState);
					underWriteFlag = stateDeal.checkUnderWriteOperate(state, editState);
					submitFlag = stateDeal.checkSubmitFlagOperate(state, editState, lnpUserType, contNo);
					repealFlag = stateDeal.checkRepealOperate(state);
					addPremFlag = stateDeal.checkShowAddPremOperate(contNo);
					uwurl = getUWURLByContno(contNo);
					if (uwurl != null && !"".equals(uwurl))
						uwURLShowFlag = true;
				}
				session.setAttribute("editFlag", Boolean.valueOf(editFlag));
			}
	}

	private boolean getInfoFromSession()
	{
		boolean flag = false;
		try
		{
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			IGlobalInput npGI = (IGlobalInput)session.getAttribute("NPGI");
			lnpUserType = npGI.OperType;
			contNo = (String)session.getAttribute("ContNo");
			if (contNo != null && !contNo.equals(""))
			{
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				LNPContSchema lnpSch = mainInfo.getContByContNo(contNo);
				if (lnpSch != null)
				{
					flag = true;
					state = lnpSch.getState();
					editState = lnpSch.getEditstate();
				}
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public SugError contPayMent(String contnoin, IGlobalInput tIGlobalInput)
	{
		SugError listSugError = null;
		calPremSuccFlag = false;
		calHtmlErrorShowFlag = false;
		alertFlag = false;
		message = null;
		contNo = contnoin;
		String contno = contNo;
		RiskCheckCenterImpl tRiskCheckCenterImpl = new RiskCheckCenterImpl();
		listSugError = tRiskCheckCenterImpl.checkOnePolBeforeCal(contno, tIGlobalInput);
		if (listSugError == null || !listSugError.hasError())
			break MISSING_BLOCK_LABEL_76;
		calHtmlErrorShowFlag = true;
		return listSugError;
		RuntimeException e;
		e;
		e.printStackTrace();
		return listSugError;
	}

	public void docontPayMent()
	{
		SugError listSugError = null;
		calPremSuccFlag = false;
		calHtmlErrorShowFlag = false;
		alertFlag = false;
		message = null;
		String contno = contNo;
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema tLNPContSchema = mainInfo.getContByContNo(contno);
		PubSubmit ps = new PubSubmit();
		MMap mmap = new MMap();
		StateOperatorDeal operatorDeal = new StateOperatorDeal();
		boolean resetflag = riskBounsExist(contno);
		if (!resetflag)
		{
			tLNPContSchema.setEditstate(operatorDeal.updateEditStateDone(tLNPContSchema.getEditstate(), 5));
			VData vd = new VData();
			mmap.put(tLNPContSchema, "UPDATE");
			vd.add(mmap);
			System.out.println("----- ���Ѽ�����ɹ�� ��������־ ----");
			ps.submitData(vd, "");
		}
		String flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag'";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(flagSql);
		String flag = "";
		if (tSSRS != null && tSSRS.MaxRow > 0)
			flag = tSSRS.GetText(1, 1);
		else
			return;
		if (flag != null && !"".equals(flag) && "interface".equals(flag))
		{
			CalPrem tCalPremBean = new CalPrem();
			if (!tCalPremBean.calPremByContNo(contno))
			{
				alertFlag = true;
				message = tCalPremBean.getMessage();
				if (message == null || "".equals(message))
					message = "���Ѽ���ʧ�ܣ�";
				return;
			}
			calPremSuccFlag = true;
			aftercalPrem(contno);
			if (checkSumPrem(contno))
			{
				alertFlag = true;
				message = "��������ʶ��";
			}
			if (checkFirstPrem(contno))
			{
				alertFlag = true;
				message = "��������˵��";
			}
			return;
		}
		if (flag != null && !"".equals(flag) && "test".equals(flag))
		{
			String sql = (new StringBuilder("update lnppol set prem='10000' where contno='")).append(contno).append("' and masterpolno = polno").toString();
			String sql1 = (new StringBuilder("update lnppol set prem='5000' where contno='")).append(contno).append("' and masterpolno <> polno").toString();
			String sql2 = (new StringBuilder("update lnpcont set state='02',prem='15000' where contno='")).append(contno).append("'").toString();
			tExeSQL.execUpdateSQL(sql);
			tExeSQL.execUpdateSQL(sql1);
			tExeSQL.execUpdateSQL(sql2);
			calPremSuccFlag = true;
			aftercalPrem(contno);
			if (checkSumPrem(contno))
			{
				alertFlag = true;
				message = "��������ʶ��";
			}
			if (checkFirstPrem(contno))
			{
				alertFlag = true;
				message = "��������˵��";
			}
			return;
		} else
		{
			return;
		}
	}

	private boolean checkFirstPrem(String contno)
	{
		boolean reflag = false;
		String sql = (new StringBuilder("select * from lnppol where contno='")).append(contno).append("' ").toString();
		LNPPolDB db = new LNPPolDB();
		LNPPolSet polset = db.executeQuery(sql);
		double firstprem = 0.0D;
		if (polset != null && polset.size() > 0)
		{
			for (int i = 1; i <= polset.size(); i++)
			{
				double tmpprem = 0.0D;
				LNPPolSchema tmpSch = polset.get(i);
				if ("12".equals(Integer.valueOf(tmpSch.getPayIntv())))
					tmpprem = tmpSch.getSumPrem() * 2D;
				else
					tmpprem = tmpSch.getSumPrem();
				firstprem += tmpprem;
			}

		}
		if (firstprem >= 500000D)
			reflag = true;
		return reflag;
	}

	private boolean checkSumPrem(String contno)
	{
		boolean reflag = false;
		String sql = (new StringBuilder("select * from lnppol where contno='")).append(contno).append("'").toString();
		LNPPolDB db = new LNPPolDB();
		LNPPolSet polset = db.executeQuery(sql);
		double sumprem = 0.0D;
		if (polset != null && polset.size() > 0)
		{
			for (int i = 1; i <= polset.size(); i++)
			{
				LNPPolSchema tmpSch = polset.get(i);
				double payyearcount = 0.0D;
				double tmpprem = 0.0D;
				if (checkOneYearProduct(tmpSch.getRiskCode()))
				{
					tmpprem = tmpSch.getSumPrem();
				} else
				{
					if ("Y".equals(tmpSch.getPayEndYearFlag()))
						payyearcount = tmpSch.getPayEndYear();
					else
					if ("A".equals(tmpSch.getPayEndYearFlag()))
					{
						sql = (new StringBuilder("select * from lnpinsured where contno='")).append(contno).append("'").toString();
						LNPInsuredDB insuredDB = new LNPInsuredDB();
						LNPInsuredSchema insuredSch = insuredDB.executeQuery(sql).get(1);
						if (insuredSch != null)
							if ("D".equals(insuredSch.getAppAgeType()))
							{
								if (tmpSch.getPayEndYear() == 105)
									payyearcount = 75D;
								else
									payyearcount = tmpSch.getPayEndYear();
							} else
							if ("Y".equals(insuredSch.getAppAgeType()))
								if (tmpSch.getPayEndYear() == 105)
									payyearcount = 75 - insuredSch.getAppAge();
								else
									payyearcount = tmpSch.getPayEndYear() - insuredSch.getAppAge();
					}
					if (tmpSch.getPayIntv() != 0)
						tmpprem = (double)(12 / tmpSch.getPayIntv()) * payyearcount * tmpSch.getSumPrem();
					else
						tmpprem = tmpSch.getSumPrem();
				}
				sumprem += tmpprem;
			}

			if (sumprem >= 200000D)
				reflag = true;
		}
		return reflag;
	}

	private boolean checkOneYearProduct(String riskCode)
	{
		String sql = (new StringBuilder("select * from lnpriskapp where risktype5='1' and riskcode='")).append(riskCode).append("'").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		return tSSRS != null && tSSRS.getMaxRow() > 0;
	}

	private boolean riskBounsExist(String contNo)
	{
		String sql = (new StringBuilder("select bonustype from lnpriskconfig  where riskcode = (select riskcode from lnppol where contno='")).append(contNo).append("' and masterpolno =polno);").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		return tSSRS != null && tSSRS.MaxRow != 0 && tSSRS.GetText(1, 1) != null && !tSSRS.GetText(1, 1).trim().equals("");
	}

	private boolean aftercalPrem(String contno)
	{
		System.out.println("----- ���Ѽ�����ɹ�� ɾ��˱�����? ----");
		boolean flag = false;
		try
		{
			PubSubmit ps = new PubSubmit();
			MMap mmap = new MMap();
			LNPUWQuestionDB queDB = new LNPUWQuestionDB();
			String sql = (new StringBuilder("select * from LNPUWQuestion where contno='")).append(contno).append("'").toString();
			LNPUWQuestionSet queSet = queDB.executeQuery(sql);
			if (queSet != null && queSet.size() > 0)
				mmap.put(queSet, "DELETE");
			boolean uwExist = false;
			sql = (new StringBuilder("select * from LNPCUWMaster where contno = '")).append(contno).append("'").toString();
			LNPCUWMasterDB lnpCUWMasterDB = new LNPCUWMasterDB();
			LNPCUWMasterSet tLNPCUWMasterSet = lnpCUWMasterDB.executeQuery(sql);
			if (tLNPCUWMasterSet != null && tLNPCUWMasterSet.size() > 0)
			{
				uwExist = true;
				mmap.put(tLNPCUWMasterSet, "DELETE");
			}
			if (uwExist)
			{
				LNPIndUWMasterDB tLNPIndUWMasterDB = new LNPIndUWMasterDB();
				sql = (new StringBuilder("select * from LNPIndUWMaster where contno = '")).append(contno).append("'").toString();
				com.sinosoft.banklns.lis.vschema.LNPIndUWMasterSet tempLNPIndUWMasterSet = tLNPIndUWMasterDB.executeQuery(sql);
				if (tempLNPIndUWMasterSet != null)
					mmap.put(tempLNPIndUWMasterSet, "DELETE");
			}
			if (uwExist)
			{
				LNPIndUWPEMasterDB tLNPIndUWPEMasterDB = new LNPIndUWPEMasterDB();
				sql = (new StringBuilder("select * from LNPIndUWPEMaster where contno = '")).append(contno).append("'").toString();
				com.sinosoft.banklns.lis.vschema.LNPIndUWPEMasterSet tempLNPIndUWPEMasterSet = tLNPIndUWPEMasterDB.executeQuery(sql);
				if (tempLNPIndUWPEMasterSet != null)
					mmap.put(tempLNPIndUWPEMasterSet, "DELETE");
			}
			if (uwExist)
			{
				LNPUWMasterDB tLNPUWMasterDB = new LNPUWMasterDB();
				sql = (new StringBuilder("select * from LNPUWMaster where contno = '")).append(contno).append("'").toString();
				com.sinosoft.banklns.lis.vschema.LNPUWMasterSet tempLNPUWMasterSet = tLNPUWMasterDB.executeQuery(sql);
				if (tempLNPUWMasterSet != null)
					mmap.put(tempLNPUWMasterSet, "DELETE");
			}
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema tLNPContSchema = mainInfo.getContByContNo(contno);
			if ("2".equals(tLNPContSchema.getUWFlag()))
				tLNPContSchema.setUWFlag("1");
			tLNPContSchema.setApproveFlag("0");
			mmap.put(tLNPContSchema, "UPDATE");
			VData vd = new VData();
			vd.add(mmap);
			System.out.println("----- ���Ѽ�����ɹ�� ɾ��˱�����? ----");
			if (!ps.submitData(vd, ""))
				flag = false;
			else
				flag = true;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public SugError underWrite(String contnoin, IGlobalInput tIGlobalInput)
	{
		SugError listSugError;
		listSugError = null;
		underWriteSuccFlag = false;
		underWriteErrorShowFlag = false;
		deleteUWResult(contnoin);
		uwURLFlag = false;
		uwurl = null;
		alertFlag = false;
		message = null;
		String contno = contnoin;
		RiskCheckCenterImpl tRiskCheckCenterImpl = new RiskCheckCenterImpl();
		listSugError = tRiskCheckCenterImpl.checkOnePolAfterCal(contno, tIGlobalInput);
		if (listSugError == null || !listSugError.hasError())
			break MISSING_BLOCK_LABEL_86;
		underWriteErrorShowFlag = true;
		return listSugError;
		RuntimeException e;
		e;
		e.printStackTrace();
		return listSugError;
		return listSugError;
	}

	private boolean deleteUWResult(String contno)
	{
		boolean flag = false;
		PubSubmit ps;
		MMap mmap;
		boolean uwExist;
		ps = new PubSubmit();
		mmap = new MMap();
		LNPUWQuestionDB queDB = new LNPUWQuestionDB();
		String sql = (new StringBuilder("select * from LNPUWQuestion where contno='")).append(contno).append("'").toString();
		LNPUWQuestionSet queSet = queDB.executeQuery(sql);
		if (queSet != null && queSet.size() > 0)
			mmap.put(queSet, "DELETE");
		uwExist = false;
		sql = (new StringBuilder("select * from LNPCUWMaster where contno = '")).append(contno).append("'").toString();
		LNPCUWMasterDB lnpCUWMasterDB = new LNPCUWMasterDB();
		LNPCUWMasterSet tLNPCUWMasterSet = lnpCUWMasterDB.executeQuery(sql);
		LNPCUWMasterSchema tLNPCUWMasterSchema = new LNPCUWMasterSchema();
		if (tLNPCUWMasterSet != null && tLNPCUWMasterSet.size() > 0)
		{
			uwExist = true;
			mmap.put(tLNPCUWMasterSet.get(1), "DELETE");
			break MISSING_BLOCK_LABEL_175;
		}
		return true;
		try
		{
			if (uwExist)
			{
				LNPIndUWMasterDB tLNPIndUWMasterDB = new LNPIndUWMasterDB();
				String sql = (new StringBuilder("select * from LNPIndUWMaster where contno = '")).append(contno).append("'").toString();
				com.sinosoft.banklns.lis.vschema.LNPIndUWMasterSet tempLNPIndUWMasterSet = tLNPIndUWMasterDB.executeQuery(sql);
				if (tempLNPIndUWMasterSet != null)
					mmap.put(tempLNPIndUWMasterSet, "DELETE");
			}
			if (uwExist)
			{
				LNPIndUWPEMasterDB tLNPIndUWPEMasterDB = new LNPIndUWPEMasterDB();
				String sql = (new StringBuilder("select * from LNPIndUWPEMaster where contno = '")).append(contno).append("'").toString();
				com.sinosoft.banklns.lis.vschema.LNPIndUWPEMasterSet tempLNPIndUWPEMasterSet = tLNPIndUWPEMasterDB.executeQuery(sql);
				if (tempLNPIndUWPEMasterSet != null)
					mmap.put(tempLNPIndUWPEMasterSet, "DELETE");
			}
			if (uwExist)
			{
				LNPUWMasterDB tLNPUWMasterDB = new LNPUWMasterDB();
				String sql = (new StringBuilder("select * from LNPUWMaster where contno = '")).append(contno).append("'").toString();
				com.sinosoft.banklns.lis.vschema.LNPUWMasterSet tempLNPUWMasterSet = tLNPUWMasterDB.executeQuery(sql);
				if (tempLNPUWMasterSet != null)
					mmap.put(tempLNPUWMasterSet, "DELETE");
			}
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema tLNPContSchema = mainInfo.getContByContNo(contno);
			if (tLNPContSchema.getUWTime() == null || "".equals(tLNPContSchema.getUWTime()))
				tLNPContSchema.setUWTime("0");
			String times = Integer.toString(Integer.parseInt(tLNPContSchema.getUWTime()) + 1);
			tLNPContSchema.setUWTime(times);
			tLNPContSchema.setApproveFlag("0");
			mmap.put(tLNPContSchema, "UPDATE");
			VData vd = new VData();
			vd.add(mmap);
			if (!ps.submitData(vd, ""))
				flag = false;
			else
				flag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public void dounderWrite()
	{
		String contno;
		System.out.println("------------ dounderWrite start ----------------");
		SugError listSugError = null;
		contno = contNo;
		underWriteSuccFlag = false;
		underWriteErrorShowFlag = false;
		uwURLFlag = false;
		uwurl = null;
		alertFlag = false;
		message = null;
		InterFaceCheck interfaceCheck = new InterFaceCheck();
		if (!interfaceCheck.checkUnderWritingPass(contno))
		{
			alertFlag = true;
			System.out.println((new StringBuilder("�˱����ؽ��?---")).append(interfaceCheck.getMessage()).toString());
			message = interfaceCheck.getMessage();
			if (message == null || "".equals(message))
				message = "�˱����ʧ�ܣ�?";
			return;
		}
		ExeSQL tExeSQL;
		String flag;
		String flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag'";
		tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(flagSql);
		flag = "";
		if (tSSRS != null && tSSRS.MaxRow > 0)
		{
			flag = tSSRS.GetText(1, 1);
		} else
		{
			alertFlag = true;
			message = "�˱����ʧ�ܣ�?";
			return;
		}
		NPUWBean tNPUWBean;
		if (flag == null || "".equals(flag) || !"interface".equals(flag))
			break MISSING_BLOCK_LABEL_323;
		tNPUWBean = new NPUWBean();
		if (!tNPUWBean.underwritingByContNo(contno))
		{
			alertFlag = true;
			message = "�˱����ʧ�ܣ�?";
			return;
		}
		if ("TRAN05d".equals(tNPUWBean.getReFile()))
		{
			uwurl = getUWURLByContno(contno);
			if (uwurl != null && !"".equals(uwurl))
			{
				uwURLFlag = true;
				underWriteSuccFlag = true;
				return;
			}
			break MISSING_BLOCK_LABEL_519;
		}
		if ("TRAN05e".equals(tNPUWBean.getReFile()))
		{
			underWriteSuccFlag = true;
			return;
		}
		break MISSING_BLOCK_LABEL_519;
		try
		{
			String sql = (new StringBuilder("update lnpcont set state='03' where contno='")).append(contno).append("';").toString();
			PolicyMainInfo maininfo = new PolicyMainInfo();
			String updatesql = (new StringBuilder("update lnpcont set state ='03',uwflag='2',approveflag='0',getpoldate='2010-07-14' where contno='")).append(contno).append("'").toString();
			String deletesql = (new StringBuilder("delete from LNPCUWMaster where contno='")).append(contno).append("';").toString();
			String insertSql = (new StringBuilder("insert into LNPCUWMaster(ContNo,UWMessages,State) values('")).append(contno).append("','�˱�ͨ��','1');").toString();
			String deleteimp = (new StringBuilder("delete from   lnpcustimpresult where contno='")).append(contno).append("' and ").append(" questiontype='1' and optionid='2'").append("and questionid not").append(" in('0101050210','0101050220','0101050230','0301050210','0301050220','0301050230')").toString();
			tExeSQL.execUpdateSQL(deletesql);
			tExeSQL.execUpdateSQL(updatesql);
			tExeSQL.execUpdateSQL(insertSql);
			tExeSQL.execUpdateSQL(deleteimp);
			underWriteSuccFlag = true;
			return;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return;
	}

	private String getUWURLByContno(String contno)
	{
		String reURL = null;
		String sql = (new StringBuilder("select url from LNPUWQuestion where contno = '")).append(contno).append("'").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
			reURL = tSSRS.GetText(1, 1);
		return reURL;
	}

	public void showUnderWriteAnswer()
	{
		String contno;
		contno = contNo;
		alertFlag = false;
		message = null;
		StateOperatorDeal stateOperator = new StateOperatorDeal();
		boolean flag = stateOperator.checkShowUnderWriteAnswerOperate(contno);
		if (!flag)
		{
			message = "��ǰ������ܽ��к˱�����չʾ��������Ͷ������ϣH���?";
			alertFlag = true;
			return;
		}
		try
		{
			String queSQL = (new StringBuilder("select UWMessages from  LNPCUWMaster where contno='")).append(contno).append("' ;").toString();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSSRS = tExeSQL.execSQL(queSQL);
			if (tSSRS != null && tSSRS.MaxRow > 0)
			{
				message = tSSRS.GetText(1, 1);
				alertFlag = true;
				return;
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return;
	}

	public SugError submit(String contnoin, IGlobalInput tIGlobalInput)
	{
		SugError listSugError;
		listSugError = null;
		submitSuccFlag = false;
		submitErrorShowFlag = false;
		alertFlag = false;
		message = null;
		String contno = contnoin;
		RiskCheckCenterImpl tRiskCheckCenterImpl = new RiskCheckCenterImpl();
		if ("1".equals(tIGlobalInput.OperType))
			listSugError = tRiskCheckCenterImpl.checkOnePolBeforeSubmitAgent(contno, tIGlobalInput);
		else
		if ("2".equals(tIGlobalInput.OperType))
			listSugError = tRiskCheckCenterImpl.checkOnePolBeforeSubmitOperator(contno, tIGlobalInput);
		if (listSugError == null || !listSugError.hasError())
			break MISSING_BLOCK_LABEL_106;
		submitErrorShowFlag = true;
		return listSugError;
		RuntimeException e;
		e;
		e.printStackTrace();
		return listSugError;
		return listSugError;
	}

	public boolean isSubmitSuccFlag()
	{
		return submitSuccFlag;
	}

	public void setSubmitSuccFlag(boolean submitSuccFlag)
	{
		this.submitSuccFlag = submitSuccFlag;
	}

	public boolean isSubmitErrorShowFlag()
	{
		return submitErrorShowFlag;
	}

	public void setSubmitErrorShowFlag(boolean submitErrorShowFlag)
	{
		this.submitErrorShowFlag = submitErrorShowFlag;
	}

	public void dosubmit()
	{
		submitSuccFlag = false;
		alertFlag = false;
		message = null;
		String contno;
		LNPContSchema lnpcont;
		System.out.println("--- ���ͱ�������ϵͳ ---");
		contno = contNo;
		StateOperatorDeal stateOperator = new StateOperatorDeal();
		PolicyMainInfo maininfo = new PolicyMainInfo();
		lnpcont = maininfo.getContByContNo(contno);
		boolean flag = stateOperator.checkSubmitFlagOperate(lnpcont.getState(), lnpcont.getEditstate(), lnpUserType, contNo);
		if (!flag)
		{
			message = "��ǰ������ܽ��з��ͱ�������ϵͳ��������Ͷ������ϣH���?";
			alertFlag = true;
			return;
		}
		if (lnpcont.getApproveFlag() != null && "1".equals(lnpcont.getApproveFlag()))
		{
			message = "��ȷ�ϼӷѺ��ٽ��з��ͱ�������ϵͳ����";
			alertFlag = true;
			return;
		}
		ExeSQL tExeSQL;
		String interfaceflag;
		tExeSQL = new ExeSQL();
		String flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag'";
		ExeSQL tExeSQL2 = new ExeSQL();
		SSRS tSSRS = tExeSQL2.execSQL(flagSql);
		interfaceflag = "";
		if (tSSRS != null && tSSRS.MaxRow > 0)
		{
			interfaceflag = tSSRS.GetText(1, 1);
		} else
		{
			alertFlag = true;
			message = "���ͱ�������ϵͳʧ�ܣ�";
			return;
		}
		String langtemp;
		FinalSubmissionBean submitBean;
		PubSubmit ps;
		langtemp = lnpcont.getLang();
		if (interfaceflag == null || "".equals(interfaceflag) || !"interface".equals(interfaceflag))
			break MISSING_BLOCK_LABEL_469;
		submitBean = new FinalSubmissionBean();
		if ("1".equals(lnpUserType))
			lnpcont.setLang("1");
		else
			"2".equals(lnpUserType);
		ps = new PubSubmit();
		MMap map = new MMap();
		map.put(lnpcont, "UPDATE");
		VData vd = new VData();
		vd.add(map);
		if (!ps.submitData(vd, ""))
		{
			alertFlag = true;
			message = "���ͱ�������ϵͳʧ�ܣ�";
			return;
		}
		if (!submitBean.finalSubmintByContNo(contno))
		{
			alertFlag = true;
			message = submitBean.getMessage();
			if (message == null || "".equals(message))
				message = "���ͱ�������ϵͳʧ�ܣ�";
			MMap map = new MMap();
			lnpcont.setLang(langtemp);
			map.put(lnpcont, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			ps.submitData(vd, "");
			return;
		}
		alertFlag = true;
		submitSuccFlag = true;
		message = "���ͱ�������ϵͳ�ɹ���";
		break MISSING_BLOCK_LABEL_541;
		if (interfaceflag != null && !"".equals(interfaceflag) && "test".equals(interfaceflag))
		{
			String sql = (new StringBuilder("update lnpcont set state='05' where contno='")).append(contno).append("'").toString();
			tExeSQL.execUpdateSQL(sql);
			submitSuccFlag = true;
		}
		break MISSING_BLOCK_LABEL_541;
		RuntimeException e;
		e;
		e.printStackTrace();
	}

	public void repeal()
	{
		alertFlag = false;
		message = null;
		String contno;
		System.out.println("--- ���ͱ�������ϵͳ ---");
		contno = contNo;
		StateOperatorDeal stateOperator = new StateOperatorDeal();
		PolicyMainInfo maininfo = new PolicyMainInfo();
		LNPContSchema lnpcont = maininfo.getContByContNo(contno);
		boolean flag = stateOperator.checkRepealOperate(lnpcont.getState());
		if (!flag)
		{
			message = "��ǰ������ܽ��г����������Ͷ������Ϣ��";
			alertFlag = true;
			return;
		}
		String interfaceflag;
		String flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag'";
		ExeSQL tExeSQL2 = new ExeSQL();
		SSRS tSSRS = tExeSQL2.execSQL(flagSql);
		interfaceflag = "";
		if (tSSRS != null && tSSRS.MaxRow > 0)
		{
			interfaceflag = tSSRS.GetText(1, 1);
		} else
		{
			alertFlag = true;
			message = "����ʧ�ܣ�";
			return;
		}
		if (interfaceflag == null || "".equals(interfaceflag) || !"interface".equals(interfaceflag))
			break MISSING_BLOCK_LABEL_241;
		FinalSubmissionBean submitBean = new FinalSubmissionBean();
		if (!submitBean.RepealByContNo(contno))
		{
			alertFlag = true;
			message = submitBean.getMessage();
			if (message == null || "".equals(message))
				message = "����ʧ�ܣ�";
			return;
		}
		alertFlag = true;
		message = "����ɹ���?";
		break MISSING_BLOCK_LABEL_317;
		if (interfaceflag != null && !"".equals(interfaceflag) && "test".equals(interfaceflag))
		{
			ExeSQL tExeSQL = new ExeSQL();
			String sql = (new StringBuilder("update lnpcont set state='04' where contno='")).append(contno).append("'").toString();
			tExeSQL.execUpdateSQL(sql);
		}
		break MISSING_BLOCK_LABEL_317;
		RuntimeException e;
		e;
		e.printStackTrace();
	}

	public void addPremConfirm()
	{
		String contno = contNo;
		message = null;
		alertFlag = false;
		if (contno != null)
		{
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema lnpContSch = mainInfo.getContByContNo(contno);
			lnpContSch.setApproveFlag("2");
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(lnpContSch, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "ȷ�ϼӷѲ���ʧ�ܣ�";
				alertFlag = true;
			}
		} else
		{
			message = "ȷ�ϼӷѲ���ʧ�ܣ�";
			alertFlag = true;
		}
	}

	public void undoPremConfirm()
	{
		String contno = contNo;
		message = null;
		alertFlag = false;
		if (contno != null)
		{
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema lnpContSch = mainInfo.getContByContNo(contno);
			lnpContSch.setApproveFlag("1");
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(lnpContSch, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "ȡ��ȷ�ϼӷѲ���ʧ�ܣ�";
				alertFlag = true;
			}
		} else
		{
			message = "ȡ��ȷ�ϼӷѲ���ʧ�ܣ�";
			alertFlag = true;
		}
	}

	public void setSessionTemp()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("Contno", contNoTemp);
		System.out.println((new StringBuilder("operator --- Contno---")).append(session.getAttribute("Contno")).toString());
	}

	public String getContNoTemp()
	{
		return contNoTemp;
	}

	public void setContNoTemp(String contNoTemp)
	{
		this.contNoTemp = contNoTemp;
	}

	public boolean isContPayMentFlag()
	{
		return contPayMentFlag;
	}

	public void setContPayMentFlag(boolean contPayMentFlag)
	{
		this.contPayMentFlag = contPayMentFlag;
	}

	public boolean isShowUnderWriteAnswerFlag()
	{
		return showUnderWriteAnswerFlag;
	}

	public void setShowUnderWriteAnswerFlag(boolean showUnderWriteAnswerFlag)
	{
		this.showUnderWriteAnswerFlag = showUnderWriteAnswerFlag;
	}

	public boolean isSubmitFlag()
	{
		return submitFlag;
	}

	public void setSubmitFlag(boolean submitFlag)
	{
		this.submitFlag = submitFlag;
	}

	public boolean isUnderWriteFlag()
	{
		return underWriteFlag;
	}

	public void setUnderWriteFlag(boolean underWriteFlag)
	{
		this.underWriteFlag = underWriteFlag;
	}

	public boolean isRepealFlag()
	{
		return repealFlag;
	}

	public void setRepealFlag(boolean repealFlag)
	{
		this.repealFlag = repealFlag;
	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public boolean isAlertFlag()
	{
		return alertFlag;
	}

	public void setAlertFlag(boolean alertFlag)
	{
		this.alertFlag = alertFlag;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public boolean isUwURLFlag()
	{
		return uwURLFlag;
	}

	public void setUwURLFlag(boolean uwURLFlag)
	{
		this.uwURLFlag = uwURLFlag;
	}

	public boolean isUwURLShowFlag()
	{
		return uwURLShowFlag;
	}

	public void setUwURLShowFlag(boolean uwURLShowFlag)
	{
		this.uwURLShowFlag = uwURLShowFlag;
	}

	public String getLnpUserType()
	{
		return lnpUserType;
	}

	public void setLnpUserType(String lnpUserType)
	{
		this.lnpUserType = lnpUserType;
	}

	public boolean isCalPremSuccFlag()
	{
		return calPremSuccFlag;
	}

	public void setCalPremSuccFlag(boolean calPremSuccFlag)
	{
		this.calPremSuccFlag = calPremSuccFlag;
	}

	public boolean isCalHtmlErrorShowFlag()
	{
		return calHtmlErrorShowFlag;
	}

	public void setCalHtmlErrorShowFlag(boolean calHtmlErrorShowFlag)
	{
		this.calHtmlErrorShowFlag = calHtmlErrorShowFlag;
	}

	public boolean isUnderWriteSuccFlag()
	{
		return underWriteSuccFlag;
	}

	public void setUnderWriteSuccFlag(boolean underWriteSuccFlag)
	{
		this.underWriteSuccFlag = underWriteSuccFlag;
	}

	public boolean isUnderWriteErrorShowFlag()
	{
		return underWriteErrorShowFlag;
	}

	public void setUnderWriteErrorShowFlag(boolean underWriteErrorShowFlag)
	{
		this.underWriteErrorShowFlag = underWriteErrorShowFlag;
	}
}
