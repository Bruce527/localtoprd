// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WeddingDate.java

package com.sinosoft.map.lis.batch;

import com.sinosoft.map.lis.pubfun.*;
import com.sinosoft.map.lis.schema.MPrivateMessageSchema;
import com.sinosoft.map.lis.vschema.MPrivateMessageSet;
import com.sinosoft.map.utility.*;

public class WeddingDate
{

	private String tNowStatYM;
	private String tCalStatYM;
	private String tCalStartDate;
	private String tCalEndDate;
	private String tCalDate;
	private String tCalRange;

	public WeddingDate()
	{
		tNowStatYM = "";
		tCalStatYM = "";
		tCalStartDate = "";
		tCalEndDate = "";
		tCalDate = "";
		tCalRange = "30";
	}

	public void batch()
	{
		if (IsBatch())
			doBatch();
	}

	public boolean IsBatch()
	{
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs1 = new SSRS();
		String branchtype = "1";
		return true;
	}

	public boolean doBatch()
	{
		String branchtype = "1";
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs1 = new SSRS();
		try
		{
			String sql = " select a.agentcode,count(1) from ( ";
			sql = (new StringBuilder(String.valueOf(sql))).append(" select  la.agentcode as agentcode ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" from tb_application tb_app ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" INNER JOIN TB_GROUP_NUMBER_Encrypt tb_g ON  tb_app.cd_administrator = tb_g.cd_administrator AND tb_app.cd_branch = tb_g.cd_branch  AND tb_app.cd_administrator_group_number = tb_g.cd_group_number and tb_app.src_cd = tb_g.src_cd ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" inner join tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator  and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product  and tb_app.cd_application=tb_a_b.cd_application ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" inner join mclientrelation m_cr on tb_g.cd_group_number=m_cr.customerno inner join lslatncycustm c on m_cr.prospectsno=c.CustomerNo ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" where  1=1 ").toString();
			String caldate1 = PubFun.getCurrentDate();
			String strmonth = caldate1.substring(5, 7);
			String strday = caldate1.substring(8, 10);
			if (strmonth.compareTo("12") == 0 && strday.compareTo("03") >= 0)
				sql = (new StringBuilder(String.valueOf(sql))).append(" and (( substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <='12-31') or ( substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >='01-01') )").toString();
			else
				sql = (new StringBuilder(String.valueOf(sql))).append(" and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" union all ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" select la.agentcode as agentcode ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" from lslatncycustm c inner join laagent la ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" on c.operator=la.agentcode ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and la.branchtype='1' ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" where 1=1 ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and  c.CustomerNo not in ( select prospectsno from  mclientrelation )  ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and  not exists ( select 1 from  mclientrelation where prospectsno = c.CustomerNo ) ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and la.branchtype='1' ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and c.SpecialDate is not null ").toString();
			if (strmonth.compareTo("12") == 0 && strday.compareTo("03") >= 0)
				sql = (new StringBuilder(String.valueOf(sql))).append(" and (( substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <='12-31') or ( substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >='01-01') )").toString();
			else
				sql = (new StringBuilder(String.valueOf(sql))).append(" and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" ) a ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" group by a.agentcode ").toString();
			ssrs1 = exeSQL.execSQL(sql);
			SysMaxNoMap ttMPrivateDelNOMap = new SysMaxNoMap("MPrivateDelNO", 12, 1);
			String tDelID = ttMPrivateDelNOMap.next();
			MPrivateMessageSet tMPrivateMessageSet = new MPrivateMessageSet();
			if (ssrs1 != null && ssrs1.MaxRow > 0)
			{
				for (int i = 1; i <= ssrs1.MaxRow; i++)
				{
					MPrivateMessageSchema tMPrivateMessageSchema = new MPrivateMessageSchema();
					SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MPrivateMegNO", 12, 1);
					String tID = tSysMaxNoMap.next();
					tMPrivateMessageSchema.setID(tID);
					tMPrivateMessageSchema.setAgentCode(ssrs1.GetText(i, 1));
					tMPrivateMessageSchema.setManageCom(ssrs1.GetText(i, 1).substring(0, 4));
					tMPrivateMessageSchema.setBranchType(branchtype);
					tMPrivateMessageSchema.setMessageType("07");
					tMPrivateMessageSchema.setKeyData(ssrs1.GetText(i, 2));
					tMPrivateMessageSchema.setType("1");
					tMPrivateMessageSchema.setState("1");
					tMPrivateMessageSchema.setOperator(tDelID);
					tMPrivateMessageSchema.setMakeDate(PubFun.getCurrentDate());
					tMPrivateMessageSchema.setMakeTime(PubFun.getCurrentTime());
					tMPrivateMessageSet.add(tMPrivateMessageSchema);
				}

			}
			MPrivateMessageSet rMPrivateMessageSet = new MPrivateMessageSet();
			String querysql = (new StringBuilder(" select id from MPrivateMessage where branchtype ='1' and messagetype='07' and operator <> '")).append(tDelID).append("' ").toString();
			SSRS ssrs2 = new SSRS();
			ssrs2 = exeSQL.execSQL(querysql);
			if (ssrs2 != null && ssrs2.MaxRow > 0)
			{
				for (int i = 1; i <= ssrs2.MaxRow; i++)
				{
					MPrivateMessageSchema rMPrivateMessageSchema = new MPrivateMessageSchema();
					rMPrivateMessageSchema.setID(ssrs2.GetText(i, 1));
					rMPrivateMessageSet.add(rMPrivateMessageSchema);
				}

			}
			MMap mmap = new MMap();
			mmap.put(tMPrivateMessageSet, "INSERT");
			mmap.put(rMPrivateMessageSet, "DELETE");
			VData tVData = new VData();
			tVData.add(mmap);
			PubSubmit tPubSubmit = new PubSubmit();
			tPubSubmit.submitData(tVData, "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
