// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   InterFaceCheck.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			StateOperatorDeal, PolicyMainInfo

public class InterFaceCheck
{

	private String message;

	public InterFaceCheck()
	{
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public boolean checkUnderWritingPass(String contno)
	{
		boolean flag;
		System.out.println("�˱�ǰ��Ϣ���?--Start");
		message = null;
		flag = false;
		LNPContSchema lnpcont;
		StateOperatorDeal stateOperator = new StateOperatorDeal();
		PolicyMainInfo maininfo = new PolicyMainInfo();
		lnpcont = maininfo.getContByContNo(contno);
		flag = stateOperator.checkUnderWriteOperate(lnpcont.getState(), lnpcont.getEditstate());
		if (flag)
			break MISSING_BLOCK_LABEL_75;
		message = "��ǰ������ܽ��к˱���������Ͷ������Ϣ��?";
		System.out.println("��ǰ������ܽ��к˱���������Ͷ������Ϣ��?");
		return false;
		boolean underWriteFlag;
		ExeSQL tExeSql1 = new ExeSQL();
		underWriteFlag = false;
		if ("04".equals(lnpcont.getState()))
			underWriteFlag = true;
		if (underWriteFlag)
			break MISSING_BLOCK_LABEL_128;
		String errorMsg1 = checkCustImpartDone(contno);
		if (errorMsg1 == null)
			break MISSING_BLOCK_LABEL_161;
		message = errorMsg1;
		return false;
		if (!underWriteFlag)
			break MISSING_BLOCK_LABEL_153;
		String errorMsg1 = checkCustImpartReDone(contno);
		if (errorMsg1 == null)
			break MISSING_BLOCK_LABEL_161;
		message = errorMsg1;
		return false;
		message = "�˱����ʧ�ܣ�?";
		return false;
		flag = checkAgentExist(contno);
		if (flag)
			break MISSING_BLOCK_LABEL_179;
		message = "����������һ������ˣ�?";
		return false;
		String errorMsg2 = checkSpelDone(contno);
		if (errorMsg2 == null)
			break MISSING_BLOCK_LABEL_204;
		message = errorMsg2;
		return false;
		RuntimeException e;
		e;
		e.printStackTrace();
		return flag;
	}

	private boolean checkOccupation(String contNo)
	{
		String sql = (new StringBuilder("select * from lnppol a ,lnpinsured b where  a.riskcode in ('PJU','MWL101','MWL102','AHI101','AHI102') and a.contno='")).append(contNo).append("' and a.contno = b.contno ").append("and '7' = (select parate from lnpoccupation where occupationcode= b.occupationcode )").append("union ").append("select * from lnppol a ,lnpinsured b where ").append(" a.riskcode in ('AHI101') ").append("and a.contno='").append(contNo).append("' and a.contno = b.contno ").append("and ('5' = (select parate from lnpoccupation where occupationcode= b.occupationcode ) ").append("or '6'=(select parate from lnpoccupation where occupationcode= b.occupationcode ))").toString();
		ExeSQL reExeSQL = new ExeSQL();
		SSRS tSSRS = reExeSQL.execSQL(sql);
		return tSSRS == null || tSSRS.getMaxRow() <= 0;
	}

	private String checkCustImpartDone(String contno)
	{
		String errorMsg = "";
		String reError = null;
		PolicyMainInfo tPolicyMainInfo = new PolicyMainInfo();
		LNPContSchema contSch = tPolicyMainInfo.getContByContNo(contno);
		String checksqlexist = (new StringBuilder("select distinct impartid from lnpcustimpresult where contno='")).append(contno).append("'").toString();
		String checksqlnotexsit = (new StringBuilder("select top 1 imp.impartid from lnppol pol,lnpriskconfig cfg,lnpcustimpart imp where pol.masterpolno = pol.polno and cfg.riskcode = pol.riskcode and pol.contno='")).append(contno).append("' ").append("and cfg.imparttype = imp.proposaltype order by imp.impartver desc ").toString();
		ExeSQL reExeSQL = new ExeSQL();
		SSRS tSSRSexist = reExeSQL.execSQL(checksqlexist);
		SSRS tSSRSnotexsit = reExeSQL.execSQL(checksqlnotexsit);
		String impartId = "";
		if (tSSRSexist != null && tSSRSexist.GetText(1, 1) != null)
			impartId = tSSRSexist.GetText(1, 1);
		else
		if (tSSRSnotexsit != null && tSSRSnotexsit.GetText(1, 1) != null)
			impartId = tSSRSnotexsit.GetText(1, 1);
		if (impartId != null && !"".equals(impartId.trim()))
		{
			String queSQL = (new StringBuilder("select distinct substring(questionid,5,2) from lnpcustimpque where impartid='")).append(impartId).append("' and ").append("checkflag='0' ").append("and  (p1<>'1' or p1 is null or p1='') ").append("and questiontype<>'0' ").append("and questionid not in(select questionid from lnpcustimpresult where contno='").append(contno).append("')").append("union ").append("select distinct substring(questionid,5,2) from  ").append("(select questionid,errormsg from lnpcustimpque where (p1<>'1' or p1 is null or p1='') and outqueid in ").append("(select questionid from lnpcustimpresult").append(" where contno='").append(contno).append("' and ").append("optionid ='1' and ").append("questionid in ").append("(select distinct outqueid from lnpcustimpque where impartid='").append(impartId).append("' and checkflag='1' ").append("and checkvalue='1' ").append("and p1<>'1'").append("and questiontype<>'0'))) c where   questionid not in").append("(select questionid from lnpcustimpresult where contno='").append(contno).append("')").append(";").toString();
			System.out.println((new StringBuilder("��鹫������sql--")).append(queSQL).toString());
			SSRS tSSRS2 = reExeSQL.execSQL(queSQL);
			SSRS tSSRS3;
			if (tSSRS2 != null && tSSRS2.MaxRow > 0)
				if (("0101".equals(impartId) || "0102".equals(impartId) || "0301".equals(impartId)) && tSSRS2.MaxRow == 1 && "05".equals(tSSRS2.GetText(1, 1)))
				{
					queSQL = (new StringBuilder("select * from lnpcustimpresult where impartid='")).append(impartId).append("' and contno='").append(contno).append("' and questionid='").append(impartId).append("050000' and optionid in ('1','2')").toString();
					SSRS tSSRS3 = reExeSQL.execSQL(queSQL);
					if (tSSRS3 == null || tSSRS3.MaxRow == 0)
						errorMsg = "����5";
				} else
				{
					for (int i = 1; i <= tSSRS2.MaxRow; i++)
						if ("05".equals(tSSRS2.GetText(i, 1)) && ("0101".equals(impartId) || "0102".equals(impartId) || "0301".equals(impartId)))
						{
							queSQL = (new StringBuilder("select * from lnpcustimpresult where impartid='")).append(impartId).append("' and contno='").append(contno).append("' and questionid='").append(impartId).append("050000' and optionid in ('1','2')").toString();
							tSSRS3 = reExeSQL.execSQL(queSQL);
							if (tSSRS3 == null || tSSRS3.MaxRow == 0)
								errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(",����5").toString();
						} else
						if ("0301".equals(impartId) && ("13".equals(tSSRS2.GetText(i, 1)) || "14".equals(tSSRS2.GetText(i, 1))))
						{
							if ("13".equals(tSSRS2.GetText(i, 1)))
								errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(",Ͷ������Ϣ����1").toString();
							else
							if ("14".equals(tSSRS2.GetText(i, 1)))
								errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(",Ͷ������Ϣ����2").toString();
						} else
						{
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(",����").append(Integer.parseInt(tSSRS2.GetText(i, 1))).toString();
						}

					errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(",").toString();
				}
			if ("0101".equals(impartId))
			{
				String sql1 = (new StringBuilder("select * from lnpcustimpresult where impartid = '0101' and questionid='0101050000' and optionid='1' and contno = '")).append(contno).append("';").toString();
				SSRS tSSRS1 = reExeSQL.execSQL(sql1);
				if (tSSRS1 != null && tSSRS1.MaxRow > 0)
				{
					String sql2 = (new StringBuilder("select questionid,optionid from lnpcustimpresult where questionid in ('0101050101','0101050102','0101050210','0101050220','0101050230') and impartid = '0101'  and contno = '")).append(contno).append("';").toString();
					SSRS trSSRS2 = reExeSQL.execSQL(sql2);
					boolean flag = true;
					if (trSSRS2 != null && trSSRS2.MaxRow > 0)
					{
						String sql31 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0101050210' and ((select count(*) from lnpcustimpresult where questionid in ('0101050211','0101050212') and contno = '")).append(contno).append("')=0 and optionid='1') ").append("and impartid = '0101'  and contno = '").append(contno).append("';").toString();
						SSRS trSSRS31 = reExeSQL.execSQL(sql31);
						if (trSSRS31 != null && trSSRS31.MaxRow > 0)
							flag = false;
						if (flag)
						{
							String sql32 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0101050220' and (select count(*) from lnpcustimpresult where questionid in ('0101050221','0101050222') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0101'  and contno = '").append(contno).append("';").toString();
							SSRS trSSRS32 = reExeSQL.execSQL(sql32);
							if (trSSRS32 != null && trSSRS32.MaxRow > 0)
								flag = false;
						}
						String sql33 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0101050230' and (select count(*) from lnpcustimpresult where questionid in ('0101050231','0101050232') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0101'  and contno = '").append(contno).append("';").toString();
						SSRS trSSRS33 = reExeSQL.execSQL(sql33);
						if (trSSRS33 != null && trSSRS33.MaxRow > 0)
							flag = false;
						if (!flag)
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�������?,").toString();
					} else
					{
						errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�����������?,").toString();
					}
				}
			}
			if ("0102".equals(impartId))
			{
				String sql1 = (new StringBuilder("select * from lnpcustimpresult where impartid = '0102' and questionid='0102050000' and optionid='1' and contno = '")).append(contno).append("';").toString();
				SSRS tSSRS1 = reExeSQL.execSQL(sql1);
				if (tSSRS1 != null && tSSRS1.MaxRow > 0)
				{
					String sql2 = (new StringBuilder("select questionid,optionid from lnpcustimpresult where questionid in ('0102050101','0102050102','0102050210','0102050220','0102050230') and impartid = '0102'  and contno = '")).append(contno).append("';").toString();
					SSRS trSSRS2 = reExeSQL.execSQL(sql2);
					boolean flag = true;
					if (trSSRS2 != null && trSSRS2.MaxRow > 0)
					{
						String sql31 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0102050210' and ((select count(*) from lnpcustimpresult where questionid in ('0102050211','0102050212') and contno = '")).append(contno).append("')=0 and optionid='1') ").append("and impartid = '0102'  and contno = '").append(contno).append("';").toString();
						SSRS trSSRS31 = reExeSQL.execSQL(sql31);
						if (trSSRS31 != null && trSSRS31.MaxRow > 0)
							flag = false;
						if (flag)
						{
							String sql32 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0102050220' and (select count(*) from lnpcustimpresult where questionid in ('0102050221','0102050222') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0102'  and contno = '").append(contno).append("';").toString();
							SSRS trSSRS32 = reExeSQL.execSQL(sql32);
							if (trSSRS32 != null && trSSRS32.MaxRow > 0)
								flag = false;
						}
						String sql33 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0102050230' and (select count(*) from lnpcustimpresult where questionid in ('0102050231','0102050232') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0102'  and contno = '").append(contno).append("';").toString();
						SSRS trSSRS33 = reExeSQL.execSQL(sql33);
						if (trSSRS33 != null && trSSRS33.MaxRow > 0)
							flag = false;
						if (!flag)
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�������?,").toString();
					} else
					{
						errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�����������?,").toString();
					}
				}
			}
			if ("0301".equals(impartId))
			{
				String sql0301 = (new StringBuilder("select * from lnpcustimpresult where impartid = '0301' and questionid='0301050000' and optionid='1' and contno = '")).append(contno).append("';").toString();
				SSRS tSSRS0301 = reExeSQL.execSQL(sql0301);
				if (tSSRS0301 != null && tSSRS0301.MaxRow > 0)
				{
					String sql03012 = (new StringBuilder("select * from lnpcustimpresult where questionid in ('0301050101','0301050102','0301050210','0301050220','0301050230') and impartid = '0301'  and contno = '")).append(contno).append("';").toString();
					SSRS trSSRS03012 = reExeSQL.execSQL(sql03012);
					boolean flag = true;
					if (trSSRS03012 != null && trSSRS03012.MaxRow > 0)
					{
						String sql31 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0301050210' and (select count(*) from lnpcustimpresult where questionid in ('0301050211','0301050212') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0301'  and contno = '").append(contno).append("';").toString();
						SSRS trSSRS31 = reExeSQL.execSQL(sql31);
						if (trSSRS31 != null && trSSRS31.MaxRow > 0)
							flag = false;
						if (flag)
						{
							String sql32 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0301050220' and (select count(*) from lnpcustimpresult where questionid in ('0301050221','0301050222') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0301'  and contno = '").append(contno).append("';").toString();
							SSRS trSSRS32 = reExeSQL.execSQL(sql32);
							if (trSSRS32 != null && trSSRS32.MaxRow > 0)
								flag = false;
						}
						if (flag)
						{
							String sql33 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0301050230' and (select count(*) from lnpcustimpresult where questionid in ('0301050231','0301050232') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0301'  and contno = '").append(contno).append("';").toString();
							SSRS trSSRS33 = reExeSQL.execSQL(sql33);
							if (trSSRS33 != null && trSSRS33.MaxRow > 0)
								flag = false;
						}
						if (!flag)
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�������?,").toString();
					} else
					{
						errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�����������?,").toString();
					}
				}
			}
			String squeSQL = (new StringBuilder("select distinct substring(questionid,5,2),checkvalue,errormsg from lnpcustimpque where impartid='")).append(impartId).append("' and checkflag='1' and checkvalue<>'1'  and questiontype not in('0')").append(" and ((outqueid is null or (outqueid is not null and '1'=(select optionid from lnpcustimpresult ").append("where questionid=outqueid and contno='").append(contno).append("')))").append(" and questionid not in(select questionid from lnpcustimpresult where contno='").append(contno).append("'));").toString();
			System.out.println((new StringBuilder("�����������sql--")).append(squeSQL).toString());
			tSSRS0301 = reExeSQL.execSQL(squeSQL);
			if (tSSRS0301 != null && tSSRS0301.MaxRow > 0)
			{
				String spelImpartType = "";
				String age = LNPPubFun.getAgeByBirthdayNew(contSch.getInsuredBirthday(), contSch.getPValiDate());
				int ageInt;
				if (age.indexOf("��") != -1)
					ageInt = 0;
				else
					ageInt = Integer.parseInt(age.substring(0, age.indexOf("��")));
				if (!"0101".equals(impartId))
				{
					if (contSch.getInsuredSex().equals("1") && ageInt >= 18)
					{
						spelImpartType = "female";
						for (int i = 1; i <= tSSRS0301.MaxRow; i++)
						{
							if (!tSSRS0301.GetText(i, 2).equals(spelImpartType))
								continue;
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(tSSRS0301.GetText(i, 3)).append(",").toString();
							break;
						}

					}
					if (contSch.getInsuredSex().equals("0"))
					{
						spelImpartType = "male";
						for (int i = 1; i <= tSSRS0301.MaxRow; i++)
						{
							if (!tSSRS0301.GetText(i, 2).equals(spelImpartType))
								continue;
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(tSSRS0301.GetText(i, 3)).append(",").toString();
							break;
						}

					}
					if (ageInt <= 2)
					{
						spelImpartType = "child";
						for (int i = 1; i <= tSSRS0301.MaxRow; i++)
						{
							if (!tSSRS0301.GetText(i, 2).equals(spelImpartType))
								continue;
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(tSSRS0301.GetText(i, 3)).append(",").toString();
							break;
						}

					}
				} else
				{
					if (ageInt > 2)
					{
						if (contSch.getInsuredSex().equals("1") && ageInt >= 18)
							spelImpartType = "female";
						if (contSch.getInsuredSex().equals("0"))
							spelImpartType = "male";
					} else
					{
						spelImpartType = "child";
					}
					for (int i = 1; i <= tSSRS0301.MaxRow; i++)
						if (tSSRS0301.GetText(i, 2).equals(spelImpartType))
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(tSSRS0301.GetText(i, 3)).append(",").toString();

				}
			}
		}
		if (!errorMsg.equals(""))
		{
			reError = (new StringBuilder("����?:")).append(errorMsg).append("δ��д����,����д").toString();
			reError = reError.replaceAll(":,", ":");
			reError = reError.replaceAll(",,", ",");
		}
		System.out.println((new StringBuilder("��һ�κ˱�У�飺")).append(reError).toString());
		return reError;
	}

	private String checkCustImpartReDone(String contno)
	{
		String errorMsg = "";
		String reError = null;
		PolicyMainInfo tPolicyMainInfo = new PolicyMainInfo();
		LNPContSchema contSch = tPolicyMainInfo.getContByContNo(contno);
		String checksql = (new StringBuilder("select impartid,max(impartver) from lnpcustimpart where impartid like (select imparttype from lnpriskconfig  where riskcode =(select riskcode from lnppol where contno='")).append(contno).append("' and  polno = masterpolno))+'%' ").append("group by impartid;").toString();
		ExeSQL reExeSQL = new ExeSQL();
		SSRS tSSRS = reExeSQL.execSQL(checksql);
		if (tSSRS != null && tSSRS.GetText(1, 1) != null)
		{
			String impartId = tSSRS.GetText(1, 1);
			String queSQL = (new StringBuilder("select distinct substring(questionid,5,2) from lnpcustimpque where questiontype='2' and impartid='")).append(impartId).append("' and ").append("checkflag='0' ").append("and  (p1<>'1' or p1 is null or p1='') ").append("and questiontype<>'0' ").append("and questionid not in(select questionid from lnpcustimpresult where contno='").append(contno).append("')").append("union ").append("select distinct substring(questionid,5,2) from  ").append("(select questionid,errormsg from lnpcustimpque where questiontype='2' and (p1<>'1' or p1 is null or p1='') and outqueid in ").append("(select questionid from lnpcustimpresult").append(" where contno='").append(contno).append("' and ").append("optionid ='1' and ").append("questionid in ").append("(select distinct outqueid from lnpcustimpque where impartid='").append(impartId).append("' and checkflag='1' ").append("and checkvalue='1' ").append("and p1<>'1'").append("and questiontype<>'0'))) c where   questionid not in").append("(select questionid from lnpcustimpresult where contno='").append(contno).append("')").append(";").toString();
			System.out.println((new StringBuilder("��鹫������sql--")).append(queSQL).toString());
			SSRS tSSRS2 = reExeSQL.execSQL(queSQL);
			if (tSSRS2 != null && tSSRS2.MaxRow > 0 && (!"0101".equals(impartId) && !"0301".equals(impartId) || tSSRS2.MaxRow != 1 || !"05".equals(tSSRS2.GetText(1, 1))))
			{
				for (int i = 1; i <= tSSRS2.MaxRow; i++)
					if (!"05".equals(tSSRS2.GetText(i, 1)) || !"0101".equals(impartId) && !"0301".equals(impartId))
						if ("0301".equals(impartId) && ("13".equals(tSSRS2.GetText(i, 1)) || "14".equals(tSSRS2.GetText(i, 1))))
						{
							if ("13".equals(tSSRS2.GetText(i, 1)))
								errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(",Ͷ������Ϣ����1").toString();
							else
							if ("14".equals(tSSRS2.GetText(i, 1)))
								errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(",Ͷ������Ϣ����2").toString();
						} else
						{
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(",����").append(Integer.parseInt(tSSRS2.GetText(i, 1))).toString();
						}

				errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(",").toString();
			}
			if ("0101".equals(impartId))
			{
				String sql1 = (new StringBuilder("select * from lnpcustimpresult where impartid = '0101' and questionid='0101050000' and optionid='1' and contno = '")).append(contno).append("';").toString();
				SSRS tSSRS1 = reExeSQL.execSQL(sql1);
				if (tSSRS1 != null && tSSRS1.MaxRow > 0)
				{
					String sql2 = (new StringBuilder("select questionid,optionid from lnpcustimpresult where  questionid in ('0101050101','0101050102','0101050210','0101050220','0101050230') and impartid = '0101'  and contno = '")).append(contno).append("';").toString();
					SSRS trSSRS2 = reExeSQL.execSQL(sql2);
					boolean flag = true;
					if (trSSRS2 != null && trSSRS2.MaxRow > 0)
					{
						String sql31 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0101050210' and ((select count(*) from lnpcustimpresult where questionid in ('0101050211','0101050212') and contno = '")).append(contno).append("')=0 and optionid='1') ").append("and impartid = '0101'  and contno = '").append(contno).append("';").toString();
						SSRS trSSRS31 = reExeSQL.execSQL(sql31);
						if (trSSRS31 != null && trSSRS31.MaxRow > 0)
							flag = false;
						if (flag)
						{
							String sql32 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0101050220' and (select count(*) from lnpcustimpresult where questionid in ('0101050221','0101050222') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0101'  and contno = '").append(contno).append("';").toString();
							SSRS trSSRS32 = reExeSQL.execSQL(sql32);
							if (trSSRS32 != null && trSSRS32.MaxRow > 0)
								flag = false;
						}
						String sql33 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0101050230' and (select count(*) from lnpcustimpresult where questionid in ('0101050231','0101050232') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0101'  and contno = '").append(contno).append("';").toString();
						SSRS trSSRS33 = reExeSQL.execSQL(sql33);
						if (trSSRS33 != null && trSSRS33.MaxRow > 0)
							flag = false;
						if (!flag)
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�������?,").toString();
					} else
					{
						errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�����������?,").toString();
					}
				}
			}
			if ("0301".equals(impartId))
			{
				String sql0301 = (new StringBuilder("select * from lnpcustimpresult where impartid = '0301' and questionid='0301050000' and optionid='1' and contno = '")).append(contno).append("';").toString();
				SSRS tSSRS0301 = reExeSQL.execSQL(sql0301);
				if (tSSRS0301 != null && tSSRS0301.MaxRow > 0)
				{
					String sql03012 = (new StringBuilder("select * from lnpcustimpresult where questionid in ('0301050101','0301050102','0301050210','0301050220','0301050230') and impartid = '0301'  and contno = '")).append(contno).append("';").toString();
					SSRS trSSRS03012 = reExeSQL.execSQL(sql03012);
					boolean flag = true;
					if (trSSRS03012 != null && trSSRS03012.MaxRow > 0)
					{
						String sql31 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0301050210' and (select count(*) from lnpcustimpresult where questionid in ('0301050211','0301050212') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0301'  and contno = '").append(contno).append("';").toString();
						SSRS trSSRS31 = reExeSQL.execSQL(sql31);
						if (trSSRS31 != null && trSSRS31.MaxRow > 0)
							flag = false;
						if (flag)
						{
							String sql32 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0301050220' and (select count(*) from lnpcustimpresult where questionid in ('0301050221','0301050222') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0301'  and contno = '").append(contno).append("';").toString();
							SSRS trSSRS32 = reExeSQL.execSQL(sql32);
							if (trSSRS32 != null && trSSRS32.MaxRow > 0)
								flag = false;
						}
						if (flag)
						{
							String sql33 = (new StringBuilder("select * from lnpcustimpresult where questionid = '0301050230' and (select count(*) from lnpcustimpresult where questionid in ('0301050231','0301050232') and contno = '")).append(contno).append("')=0 and optionid='1'").append("and impartid = '0301'  and contno = '").append(contno).append("';").toString();
							SSRS trSSRS33 = reExeSQL.execSQL(sql33);
							if (trSSRS33 != null && trSSRS33.MaxRow > 0)
								flag = false;
						}
						if (!flag)
							errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�������?,").toString();
					} else
					{
						errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append("�����������?,").toString();
					}
				}
			}
			String squeSQL = (new StringBuilder("select distinct substring(questionid,5,2),checkvalue,errormsg from lnpcustimpque where questiontype='2' and impartid='")).append(impartId).append("' and checkflag='1' and checkvalue<>'1'  and questiontype not in('1','0')").append(" and (outqueid is null or (outqueid is not null and '1'=(select optionid from lnpcustimpresult ").append("where questionid=outqueid and contno='").append(contno).append("')))").append(" and questionid not in(select questionid from lnpcustimpresult where contno='").append(contno).append("');").toString();
			System.out.println((new StringBuilder("�����������sql--")).append(squeSQL).toString());
			SSRS tSSRS3 = reExeSQL.execSQL(squeSQL);
			if (tSSRS3 != null && tSSRS3.MaxRow > 0)
			{
				String spelImpartType = "";
				String age = LNPPubFun.getAgeByBirthdayNew(contSch.getInsuredBirthday(), contSch.getPValiDate());
				int ageInt;
				if (age.indexOf("��") != -1)
					ageInt = 0;
				else
					ageInt = Integer.parseInt(age.substring(0, age.indexOf("��")));
				if (ageInt > 2)
				{
					if (contSch.getInsuredSex().equals("1") && ageInt >= 18)
						spelImpartType = "female";
					if (contSch.getInsuredSex().equals("0"))
						spelImpartType = "male";
				} else
				{
					spelImpartType = "child";
				}
				for (int i = 1; i <= tSSRS3.MaxRow; i++)
					if (tSSRS3.GetText(i, 2).equals(spelImpartType))
						errorMsg = (new StringBuilder(String.valueOf(errorMsg))).append(tSSRS3.GetText(i, 3)).append(",").toString();

			}
		}
		if (!errorMsg.equals(""))
		{
			reError = (new StringBuilder("����?:")).append(errorMsg).append("δ��д����,����д").toString();
			reError = reError.replaceAll(":,", ":");
			reError = reError.replaceAll(",,", ",");
		}
		System.out.println((new StringBuilder("�ڶ��κ˱�У�飺")).append(reError).toString());
		return reError;
	}

	private boolean checkAgentExist(String contno)
	{
		boolean flag = false;
		String queSQL = (new StringBuilder("select count(1) from lnpagentinfo where contno='")).append(contno).append("'").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(queSQL);
		if (tSSRS != null && Integer.parseInt(tSSRS.GetText(1, 1)) > 0)
			flag = true;
		return flag;
	}

	private String checkSpelDone(String contno)
	{
		System.out.println("-- У���������� --");
		String reErrorMsg = "";
		String sql = "select impartid,questionid,checkflag,checkvalue,errormsg,p1,p2,p3 from LNPSpelCheckConfig;";
		ExeSQL tExeSQL = new ExeSQL();
		System.out.println((new StringBuilder("sql --")).append(sql).toString());
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
		{
			SSRS tSSRS2 = new SSRS();
			for (int i = 1; i <= tSSRS.MaxRow; i++)
			{
				String tempsql = (new StringBuilder("select 1 from ")).append(tSSRS.GetText(i, 6)).append("Result ").append(" where ").append(tSSRS.GetText(i, 7)).append("='").append(tSSRS.GetText(i, 2)).append("' and ").append(tSSRS.GetText(i, 8)).append("='").append(tSSRS.GetText(i, 4)).append("' and impartid='").append(tSSRS.GetText(i, 1)).append("'  and contno='").append(contno).append("';").toString();
				System.out.println((new StringBuilder("tempsql --")).append(tempsql).toString());
				tSSRS2 = tExeSQL.execSQL(tempsql);
				if (tSSRS2.MaxRow != 1)
					reErrorMsg = (new StringBuilder(String.valueOf(tSSRS.GetText(i, 5)))).append("!").toString();
			}

		}
		if (reErrorMsg.equals(""))
			reErrorMsg = null;
		System.out.println((new StringBuilder("-- У���������� end--")).append(reErrorMsg).toString());
		return reErrorMsg;
	}
}
