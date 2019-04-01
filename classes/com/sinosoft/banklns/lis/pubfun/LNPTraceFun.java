// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPTraceFun.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.lis.schema.LNPAgentTraceSchema;
import com.sinosoft.banklns.lis.schema.LNPOperatorTraceSchema;
import com.sinosoft.banklns.utility.VData;
import com.sinosoft.map.lis.pubfun.PubFun;

// Referenced classes of package com.sinosoft.banklns.lis.pubfun:
//			MMap, PubSubmit, SysMaxNoMAPNP

public class LNPTraceFun
{

	public LNPTraceFun()
	{
	}

	public static void doLNPAgentTrace(String contno, String operator, String operatorType)
	{
		MMap map = new MMap();
		VData vd = new VData();
		PubSubmit ps = new PubSubmit();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		LNPAgentTraceSchema aSchema = new LNPAgentTraceSchema();
		aSchema.setID(maxNoMap.CreateMaxNo("AgentTraceNo", ""));
		aSchema.setOperatorDate(date);
		aSchema.setOperatorTime(time);
		aSchema.setContno(contno);
		aSchema.setOperator(operator);
		aSchema.setOperatorType(operatorType);
		map.put(aSchema, "INSERT");
		vd.add(map);
		ps.submitData(vd, "INSERT");
	}

	public static void doLNPOperatorTrace(String contno, String operator, String operatorType)
	{
		MMap map = new MMap();
		VData vd = new VData();
		PubSubmit ps = new PubSubmit();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		LNPOperatorTraceSchema oSchema = new LNPOperatorTraceSchema();
		oSchema.setID(maxNoMap.CreateMaxNo("OperTraceNo", ""));
		oSchema.setOperatorDate(date);
		oSchema.setOperatorTime(time);
		oSchema.setContno(contno);
		oSchema.setOperator(operator);
		oSchema.setOperatorType(operatorType);
		map.put(oSchema, "INSERT");
		vd.add(map);
		ps.submitData(vd, "INSERT");
	}
}
