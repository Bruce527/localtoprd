// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PolicyYearCheck.java

package com.sinosoft.map.lis.batch;

import com.sinosoft.map.lis.pubfun.*;
import com.sinosoft.map.lis.schema.MPrivateMessageSchema;
import com.sinosoft.map.lis.vschema.MPrivateMessageSet;
import com.sinosoft.map.utility.*;

public class PolicyYearCheck
{

	private String tNowStatYM;
	private String tCalStatYM;
	private String tCalStartDate;
	private String tCalEndDate;
	private String tCalDate;

	public PolicyYearCheck()
	{
		tNowStatYM = "";
		tCalStatYM = "";
		tCalStartDate = "";
		tCalEndDate = "";
		tCalDate = "20";
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
		String ttsql = (new StringBuilder("select max(keydata) from MPrivateMessage where 1=1 and messagetype='04' and branchtype='")).append(branchtype).append("'").toString();
		ssrs1 = exeSQL.execSQL(ttsql);
		if (ssrs1 != null && !ssrs1.GetText(1, 1).equals(""))
		{
			String caldate = PubFun.getCurrentDate();
			if (caldate.substring(8, 10).equals(tCalDate))
			{
				tNowStatYM = (new StringBuilder(String.valueOf(caldate.substring(0, 4)))).append(caldate.substring(5, 7)).toString();
				String sql = " select distinct yearmonth,startdate,enddate from LASTATSEGMENT where 1=1 ";
				sql = (new StringBuilder(String.valueOf(sql))).append(" and stattype='1' ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" and yearmonth > (select max(keydata) from MPrivateMessage where branchtype ='").append(branchtype).append("' and messagetype='04') ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" order by yearmonth ").toString();
				ssrs1 = exeSQL.execSQL(sql);
				if (ssrs1 != null && ssrs1.MaxRow > 0)
				{
					tCalStatYM = ssrs1.GetText(1, 1);
					tCalStartDate = ssrs1.GetText(1, 2);
					tCalEndDate = ssrs1.GetText(1, 3);
					return true;
				} else
				{
					return false;
				}
			} else
			{
				return false;
			}
		}
		String sql = "select distinct yearmonth,startdate,enddate from LASTATSEGMENT where 1=1 and stattype='1' and startdate <= CONVERT(varchar(24), getdate(), 23) and enddate >= CONVERT(varchar(24), getdate(), 23) ";
		ssrs1 = exeSQL.execSQL(sql);
		String caldate = PubFun.getCurrentDate();
		if (ssrs1 != null && ssrs1.MaxRow > 0)
		{
			tNowStatYM = (new StringBuilder(String.valueOf(caldate.substring(0, 4)))).append(caldate.substring(5, 7)).toString();
			tCalStatYM = ssrs1.GetText(1, 1);
			tCalStartDate = ssrs1.GetText(1, 2);
			tCalEndDate = ssrs1.GetText(1, 3);
			return true;
		} else
		{
			return false;
		}
	}

	public boolean doBatch()
	{
label0:
		{
			String branchtype = "1";
			ExeSQL exeSQL = new ExeSQL();
			SSRS ssrs1 = new SSRS();
			try
			{
				if (tCalStatYM == null || "".equals(tCalStatYM))
					break label0;
				String sql = " select la.agentcode,count(1) ";
				sql = (new StringBuilder(String.valueOf(sql))).append(" from tb_application tb_app ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" inner join tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator  and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product  and tb_app.cd_application=tb_a_b.cd_application  ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" and ((tb_a_b.src_cd = 'ILIFE' and tb_a_b.rec_type='S') or (tb_a_b.src_cd = 'ESEG') )  ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" where 1=1 ").toString();
				if (tCalStartDate.length() > 0 && tCalEndDate.length() > 0)
					sql = (new StringBuilder(String.valueOf(sql))).append(" and substring(CONVERT(varchar(24), tb_app.dt_policy_activation, 23),6,10) >='").append(tCalStartDate.substring(5, 10)).append("' and substring(CONVERT(varchar(24), tb_app.dt_policy_activation, 23),6,10) <='").append(tCalEndDate.substring(5, 10)).append("' and year(tb_app.dt_policy_activation) < year(getdate()) ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" and la.branchtype='").append(branchtype).append("' ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" and la.agentstate in ('01','02','06') ").toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(" and (tb_app.de_status in ('Active','Insolv. Canceled')) ").toString();
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
						tMPrivateMessageSchema.setMessageType("04");
						tMPrivateMessageSchema.setKeyData(tCalStatYM);
						tMPrivateMessageSchema.setKeyData2(ssrs1.GetText(i, 2));
						tMPrivateMessageSchema.setType("1");
						tMPrivateMessageSchema.setState("1");
						tMPrivateMessageSchema.setOperator(tDelID);
						tMPrivateMessageSchema.setMakeDate(PubFun.getCurrentDate());
						tMPrivateMessageSchema.setMakeTime(PubFun.getCurrentTime());
						tMPrivateMessageSet.add(tMPrivateMessageSchema);
					}

				}
				MPrivateMessageSet rMPrivateMessageSet = new MPrivateMessageSet();
				String querysql = (new StringBuilder(" select id from MPrivateMessage where branchtype ='1' and messagetype='04' and (KeyData <> '")).append(tCalStatYM).append("' or KeyData <> '").append(tNowStatYM).append("') ").toString();
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
		return false;
	}
}
