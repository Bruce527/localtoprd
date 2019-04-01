// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Preserve.java

package com.sinosoft.map.lis.batch;

import com.sinosoft.map.lis.pubfun.*;
import com.sinosoft.map.lis.schema.MPrivateMessageSchema;
import com.sinosoft.map.lis.vschema.MPrivateMessageSet;
import com.sinosoft.map.utility.*;

public class Preserve
{

	public Preserve()
	{
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
			String sql = (new StringBuilder(" select a.agentcode,count(*) from (  select la.agentcode,rcvc.R_KEY  from R_CV_CASE rcvc inner join  R_APP_MODIFY ram   on ram.ram_cv_case=rcvc.r_key  inner join  tb_application tb_app on  rcvc.r_policy_num=tb_app.cd_policy_complement  inner join tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator  and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product  and tb_app.cd_application=tb_a_b.cd_application  inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode  inner join R_CASE_FILE rcf  on rcf.RCF_CASE_KEY=rcvc.R_KEY  inner join R_CASE_STATUS rcs on rcs.rcs_id=rcvc.r_case_status  where 1=1  and ram.ram_status='0'  and rcs.rcs_id not in (3,13,16,22,30)  and la.branchtype='")).append(branchtype).append("' ").append(" group by la.agentcode,rcvc.R_KEY ").append(" ) as a group by a.agentcode ").toString();
			ssrs1 = exeSQL.execSQL(sql);
			SysMaxNoMap ttMPrivateDelNOMap = new SysMaxNoMap("MPrivateDelNO", 12, 1);
			String tDelID = ttMPrivateDelNOMap.next();
			MPrivateMessageSet tMPrivateMessageSet = new MPrivateMessageSet();
			if (ssrs1 != null && ssrs1.MaxRow > 0)
			{
				for (int i = 1; i < ssrs1.MaxRow; i++)
				{
					MPrivateMessageSchema tMPrivateMessageSchema = new MPrivateMessageSchema();
					SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MPrivateMegNO", 12, 1);
					String tID = tSysMaxNoMap.next();
					tMPrivateMessageSchema.setID(tID);
					tMPrivateMessageSchema.setAgentCode(ssrs1.GetText(i, 1));
					tMPrivateMessageSchema.setManageCom(ssrs1.GetText(i, 1).substring(0, 4));
					tMPrivateMessageSchema.setBranchType(branchtype);
					tMPrivateMessageSchema.setMessageType("13");
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
			String querysql = (new StringBuilder(" select id from MPrivateMessage where branchtype ='1' and messagetype='13' and operator <> '")).append(tDelID).append("'  ").toString();
			SSRS ssrs2 = new SSRS();
			ssrs2 = exeSQL.execSQL(querysql);
			if (ssrs2 != null && ssrs2.MaxRow > 0)
			{
				for (int i = 1; i < ssrs2.MaxRow; i++)
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
