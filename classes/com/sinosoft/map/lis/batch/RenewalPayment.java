// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RenewalPayment.java

package com.sinosoft.map.lis.batch;

import com.sinosoft.map.lis.pubfun.*;
import com.sinosoft.map.lis.schema.MPrivateMessageSchema;
import com.sinosoft.map.lis.vschema.MPrivateMessageSet;
import com.sinosoft.map.utility.*;

public class RenewalPayment
{

	private String tNowStatYM;
	private String tCalStatYM;
	private String tCalStartDate;
	private String tCalEndDate;
	private String tCalDate;
	private String tCalRange;

	public RenewalPayment()
	{
		tNowStatYM = "";
		tCalStatYM = "";
		tCalStartDate = "";
		tCalEndDate = "";
		tCalDate = "";
		tCalRange = "15";
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
			String sql = " select la.agentcode ,count(1) ";
			sql = (new StringBuilder(String.valueOf(sql))).append(" from tb_application tb_app ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" INNER JOIN TB_GROUP_NUMBER_Encrypt tb_g ON  tb_app.cd_administrator = tb_g.cd_administrator AND tb_app.cd_branch = tb_g.cd_branch  AND tb_app.cd_administrator_group_number = tb_g.cd_group_number and tb_app.src_cd = tb_g.src_cd ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" inner join tb_collection tb_c on tb_app.cd_administrator=tb_c.cd_administrator and tb_app.cd_branch=tb_c.cd_branch and tb_app.cd_line_business=tb_c.cd_line_business and tb_app.cd_policy=tb_c.cd_policy ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" inner join tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product and tb_app.cd_application=tb_a_b.cd_application ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" where 1=1 ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" AND tb_app.de_status ='Active' ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and la.branchtype ='1' ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and tb_c.dt_cancelling is null and tb_c.dt_payment is null and tb_c.vl_parcel>0  ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and ((tb_a_b.src_cd = 'ILIFE' and tb_a_b.rec_type='S') or (tb_a_b.src_cd = 'ESEG') ) ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and CONVERT(varchar(24), getdate()-70, 23) <= tb_c.dt_expiration ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and CONVERT(varchar(24), getdate()+15, 23) >= tb_c.dt_expiration ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" group by la.agentcode ").toString();
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
					tMPrivateMessageSchema.setMessageType("05");
					tMPrivateMessageSchema.setKeyData(ssrs1.GetText(i, 2));
					tMPrivateMessageSchema.setType("2");
					tMPrivateMessageSchema.setState("1");
					tMPrivateMessageSchema.setOperator(tDelID);
					tMPrivateMessageSchema.setMakeDate(PubFun.getCurrentDate());
					tMPrivateMessageSchema.setMakeTime(PubFun.getCurrentTime());
					tMPrivateMessageSet.add(tMPrivateMessageSchema);
				}

			}
			MPrivateMessageSet rMPrivateMessageSet = new MPrivateMessageSet();
			String querysql = (new StringBuilder(" select id from MPrivateMessage where branchtype ='1' and messagetype='05' and operator <> '")).append(tDelID).append("'  ").toString();
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
