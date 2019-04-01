// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PolState.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			PubFun

public class PolState
{

	public CErrors mErrors;

	public PolState()
	{
		mErrors = new CErrors();
	}

	public boolean SetPolEnd()
	{
		String sql = (new StringBuilder("UPDATE lcpol SET polstate = '0303' || SUBSTR (polstate, 0, 4) WHERE polno IN ( SELECT polno FROM lcpol WHERE grppolno = '00000000000000000000'  AND SUBSTR (polstate, 0, 2) NOT IN ('03', '04')  AND (   (    EXISTS (SELECT riskcode FROM lmriskrnew                         WHERE riskcode = lcpol.riskcode)           AND to_date('")).append(PubFun.getCurrentDate()).append("','yyyy-mm-dd') > enddate + DECODE (rnewflag, '-1', 67, 0))").append("        OR (    NOT EXISTS (SELECT riskcode FROM lmriskrnew").append("                             WHERE riskcode = lcpol.riskcode)").append("            AND to_date('").append(PubFun.getCurrentDate()).append("','yyyy-mm-dd') > enddate)").append("        OR (    polstate LIKE '02%'").append("            AND to_date('").append(PubFun.getCurrentDate()).append("','yyyy-mm-dd') > ADD_MONTHS (PayToDate, 24))").append("       ))").toString();
		System.out.println(sql);
		ExeSQL tExeSQL = new ExeSQL();
		if (!tExeSQL.execUpdateSQL(sql))
		{
			CError.buildErr(this, tExeSQL.mErrors.getFirstError(), mErrors);
			return false;
		} else
		{
			return true;
		}
	}

	public static void main(String args1[])
	{
	}
}
