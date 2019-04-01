// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HonorData.java

package com.sinosoft.map.lis.batch;

import com.sinosoft.map.lis.pubfun.*;
import com.sinosoft.map.lis.schema.MC2BMessageSchema;
import com.sinosoft.map.lis.vschema.MC2BMessageSet;
import com.sinosoft.map.utility.*;

public class HonorData
{

	private String tCalStatYM;
	private String tCalStartDate;

	public HonorData()
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
		return true;
	}

	public boolean doBatch()
	{
		String branchtype;
		ExeSQL exeSQL;
		branchtype = "1";
		exeSQL = new ExeSQL();
		MC2BMessageSet tMC2BMessageSet;
		SSRS ssrs1 = new SSRS();
		String lpsql = "select managecom,statyear,statbatch,case when datatype ='1' then 'LP' when datatype ='2' then 'SM' when datatype ='3' then 'AM' end from MHonorCheck where checkstate = '2' and datediff(dd,checkdate,getdate()) = 1";
		ssrs1 = exeSQL.execSQL(lpsql);
		tMC2BMessageSet = new MC2BMessageSet();
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
				tMC2BMessageSchema.setKeyData(ssrs1.GetText(i, 2));
				tMC2BMessageSchema.setKeyData2(ssrs1.GetText(i, 3));
				tMC2BMessageSchema.setKeyData3(ssrs1.GetText(i, 4));
				tMC2BMessageSchema.setMessageType("09");
				tMC2BMessageSchema.setType("2");
				tMC2BMessageSchema.setState("1");
				tMC2BMessageSchema.setMakeDate(PubFun.getCurrentDate());
				tMC2BMessageSchema.setMakeTime(PubFun.getCurrentTime());
				tMC2BMessageSet.add(tMC2BMessageSchema);
			}

			break MISSING_BLOCK_LABEL_209;
		}
		return false;
		try
		{
			MMap mmap = new MMap();
			mmap.put(tMC2BMessageSet, "INSERT");
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
