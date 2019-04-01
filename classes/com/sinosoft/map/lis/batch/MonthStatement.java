// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MonthStatement.java

package com.sinosoft.map.lis.batch;

import com.sinosoft.map.lis.pubfun.*;
import com.sinosoft.map.lis.schema.MC2BMessageSchema;
import com.sinosoft.map.lis.vschema.MC2BMessageSet;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;

public class MonthStatement
{

	private String tCalStatYM;
	private String tCalStartDate;

	public MonthStatement()
	{
		tCalStatYM = "";
		tCalStartDate = "";
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
		String ttsql = (new StringBuilder("select max(keydata) from MC2BMessage where branchtype ='")).append(branchtype).append("' and messagetype='01'").toString();
		ssrs1 = exeSQL.execSQL(ttsql);
		System.out.println(ssrs1.GetText(1, 1));
		String sql;
		if (ssrs1 != null && !ssrs1.GetText(1, 1).equals(""))
		{
			sql = " select distinct yearmonth,startdate from LASTATSEGMENT where 1=1 ";
			sql = (new StringBuilder(String.valueOf(sql))).append(" and stattype='6' ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" and yearmonth > (select max(keydata) from MC2BMessage where branchtype ='").append(branchtype).append("' and messagetype='01') ").toString();
			sql = (new StringBuilder(String.valueOf(sql))).append(" order by yearmonth ").toString();
			ssrs1 = exeSQL.execSQL(sql);
			if (ssrs1 != null && ssrs1.MaxRow > 0)
			{
				String statym = ssrs1.GetText(1, 1);
				String startdate = ssrs1.GetText(1, 2);
				String caldate = PubFun.getCurrentDate();
				if (startdate.equals(caldate))
				{
					tCalStatYM = statym;
					tCalStartDate = startdate;
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
		sql = (new StringBuilder("select distinct yearmonth,startdate from LASTATSEGMENT where 1=1 and stattype='6' and startdate <= '")).append(PubFun.getCurrentDate()).append("' and enddate >= '").append(PubFun.getCurrentDate()).append("' ").toString();
		ssrs1 = exeSQL.execSQL(sql);
		if (ssrs1 != null && ssrs1.MaxRow > 0)
		{
			String statym = ssrs1.GetText(1, 1);
			String startdate = ssrs1.GetText(1, 2);
			tCalStatYM = statym;
			tCalStartDate = startdate;
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
				String sql = (new StringBuilder(" select managecom,stattype,yearmonth,startdate,enddate,areatype from LASTATSEGMENT where stattype='6' and yearmonth='")).append(tCalStatYM).append("' ").toString();
				ssrs1 = exeSQL.execSQL(sql);
				SysMaxNoMap ttMPrivateDelNOMap = new SysMaxNoMap("MPrivateDelNO", 12, 1);
				String tDelID = ttMPrivateDelNOMap.next();
				MC2BMessageSet tMC2BMessageSet = new MC2BMessageSet();
				if (ssrs1 != null && ssrs1.MaxRow > 0)
				{
					for (int i = 1; i <= ssrs1.MaxRow; i++)
					{
						MC2BMessageSchema tMC2BMessageSchema = new MC2BMessageSchema();
						SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MC2BMessageNO", 12, 1);
						String tID = tSysMaxNoMap.next();
						tMC2BMessageSchema.setID(tID);
						tMC2BMessageSchema.setManageCom(ssrs1.GetText(i, 1));
						tMC2BMessageSchema.setBranchType(branchtype);
						tMC2BMessageSchema.setKeyData(ssrs1.GetText(i, 3));
						tMC2BMessageSchema.setMessageType("01");
						tMC2BMessageSchema.setType("1");
						tMC2BMessageSchema.setState("1");
						tMC2BMessageSchema.setKeyData2(ssrs1.GetText(i, 5));
						tMC2BMessageSchema.setMakeDate(PubFun.getCurrentDate());
						tMC2BMessageSchema.setMakeTime(PubFun.getCurrentTime());
						tMC2BMessageSchema.setOperator(tDelID);
						tMC2BMessageSet.add(tMC2BMessageSchema);
					}

				}
				MC2BMessageSet rMC2BMessageSet = new MC2BMessageSet();
				String querysql = (new StringBuilder(" select id from MC2BMessage where branchtype ='1' and messagetype='01' and operator <> '")).append(tDelID).append("'  ").toString();
				SSRS ssrs2 = new SSRS();
				ssrs2 = exeSQL.execSQL(querysql);
				if (ssrs2 != null && ssrs2.MaxRow > 0)
				{
					for (int i = 1; i <= ssrs2.MaxRow; i++)
					{
						MC2BMessageSchema rMC2BMessageSchema = new MC2BMessageSchema();
						rMC2BMessageSchema.setID(ssrs2.GetText(i, 1));
						rMC2BMessageSet.add(rMC2BMessageSchema);
					}

				}
				MMap mmap = new MMap();
				mmap.put(tMC2BMessageSet, "INSERT");
				mmap.put(rMC2BMessageSet, "DELETE");
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
