// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OracleTOMySqlFilter.java

package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.db.LNPCalModeDB;
import com.sinosoft.banklns.lis.schema.LNPCalModeSchema;
import com.sinosoft.banklns.lis.vschema.LNPCalModeSet;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CErrors

public class OracleTOMySqlFilter
{

	private String oraTable[][] = {
		{
			"dual", "survrate"
		}, {
			"lcpol", "lspol"
		}, {
			"lcinsured", "lsinsured"
		}, {
			"lccustomerimpartparams", "lscustomerimpartparams"
		}, {
			"lcduty", "lsduty"
		}, {
			"lccustomerimpartparams", "lscustomerimpartparams"
		}, {
			"lccontstate", "lscontstate"
		}, {
			"lccont", "lscont"
		}, {
			"lcget", "lsget"
		}
	};
	private Pattern tablePattern;
	private Pattern interSPattern;
	private Pattern ptIS;
	private Pattern ptNull;
	private Pattern dealEPattern;
	private Pattern ptDE;
	private Pattern ptStr;

	public OracleTOMySqlFilter()
	{
		String regStr = "(^|\\W)(";
		for (int count = 0; count < oraTable.length; count++)
			if (count == oraTable.length - 1)
				regStr = (new StringBuilder(String.valueOf(regStr))).append(oraTable[count][0]).toString();
			else
				regStr = (new StringBuilder(String.valueOf(regStr))).append(oraTable[count][0]).append("|").toString();

		regStr = (new StringBuilder(String.valueOf(regStr))).append(")($|(\\W))").toString();
		tablePattern = Pattern.compile(regStr, 2);
		interSPattern = Pattern.compile("\\sintersect\\s", 2);
		ptIS = Pattern.compile("select.+?from.+?where.+?\\sintersect\\sselect.+?(?=\\bfrom)", 2);
		ptNull = Pattern.compile("\\s+?is\\s+?(not\\s+?)?null", 2);
		dealEPattern = Pattern.compile("exists(\\b)?\\((\\(.+?\\))+\\)", 2);
		ptDE = Pattern.compile("\\(|\\)", 2);
		try
		{
			jbInit();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public String filter(String sql)
	{
		sql = sql.toLowerCase();
		sql = (new StringBuilder("  ")).append(sql).append("  ").toString();
		sql = conversionTableSql(sql);
		sql = changeInterSect(sql);
		sql = dealExists(sql);
		sql = dealSpecial(sql);
		return sql.trim();
	}

	private String conversionTableSql(String sql)
	{
		Matcher matcherTable = tablePattern.matcher(sql);
		StringBuffer tempSql = new StringBuffer();
		int bakEnd;
		for (bakEnd = 0; matcherTable.find(); bakEnd = matcherTable.end())
		{
			String temp = matcherTable.group();
			String tempT = "";
			tempSql.append(sql.substring(bakEnd, matcherTable.start()));
			tempT = temp.substring(1, temp.length() - 1);
			tempSql.append(temp.replaceAll(tempT, replaceTable(tempT)));
		}

		tempSql.append(sql.substring(bakEnd));
		return tempSql.toString();
	}

	private String replaceTable(String name)
	{
		for (int count = 0; count < oraTable.length; count++)
			if (name.equals(oraTable[count][0]))
				return oraTable[count][1];

		return null;
	}

	private String changeInterSect(String sql)
	{
		sql = sql.trim();
		StringBuffer sbSql = new StringBuffer();
		int bakEnd = 0;
		Matcher mt = interSPattern.matcher(sql);
		if (!mt.find())
			return sql;
		Matcher mtIS = ptIS.matcher(sql);
		if (mtIS.find())
		{
			sbSql.append(sql.substring(bakEnd, mtIS.start()));
			String tempSql = mtIS.group().trim();
			String temp = tempSql.substring(tempSql.lastIndexOf(" ") + 1);
			String tempStart = tempSql.substring(0, mt.start());
			int SStart = 0;
			int SEnd = 0;
			String tempEnd = tempSql.substring(mt.end());
			for (Matcher mtS = Pattern.compile("select").matcher(tempStart); mtS.find();)
			{
				SStart = mtS.start();
				SEnd = mtS.end();
			}

			tempStart = (new StringBuilder(String.valueOf(tempStart.substring(0, SStart)))).append("select Distinct").append(tempStart.substring(SEnd)).toString();
			sbSql.append((new StringBuilder(String.valueOf(tempStart))).append(" And ").append(temp).append(" In( ").append(tempEnd).append(" ").toString());
			bakEnd = mtIS.end();
		}
		Matcher mtNull = ptNull.matcher(sql.substring(bakEnd));
		String sqlEnd = "";
		if (mtNull.find())
			sqlEnd = mtNull.replaceAll((new StringBuilder(") ")).append(mtNull.group()).toString());
		sbSql.append(sqlEnd);
		return sbSql.toString();
	}

	private String dealExists(String sql)
	{
		Matcher deMatcher = dealEPattern.matcher(sql);
		if (!deMatcher.find())
		{
			return sql;
		} else
		{
			StringBuffer sbDE = new StringBuffer();
			sbDE.append((new StringBuilder(String.valueOf(sql.substring(0, deMatcher.start())))).append(" exists(").toString());
			String tempSql = deMatcher.group().trim();
			tempSql = tempSql.substring(7, tempSql.length() - 1);
			Matcher mhDE = ptDE.matcher(tempSql);
			tempSql = mhDE.replaceAll("");
			sbDE.append((new StringBuilder(String.valueOf(tempSql))).append(")").append(sql.substring(deMatcher.end())).toString());
			return sbDE.toString();
		}
	}

	private String dealSpecial(String sql)
	{
		String regex = "polapplydate(\\s)*-(\\s)*insuredbirthday";
		Pattern ptSpecial = Pattern.compile(regex, 2);
		Matcher ptMatcher = ptSpecial.matcher(sql);
		if (ptMatcher.find())
			sql = ptMatcher.replaceFirst("to_days('?CValiDate?')-to_days('?insuredbirthday?') ");
		regex = "lspol\\s*where\\s*polno\\s*=\\s*'\\?polno\\?'";
		Pattern ptLSpol = Pattern.compile(regex);
		Matcher mhLSpol = ptLSpol.matcher(sql);
		regex = "lspol\\s*where";
		Pattern ptLSpoland = Pattern.compile(regex, 2);
		Matcher mhLSpoland = ptLSpoland.matcher(sql);
		if (!mhLSpol.find() && mhLSpoland.find())
			sql = mhLSpoland.replaceAll("lspol where contno='?contno?' and ");
		regex = "(([_0-9a-zA-Z]+?\\.)|\\s+?)state\\s*((=\\s*'.+?')|(is\\s+?(not\\s+?)?null))";
		Pattern ptState = Pattern.compile(regex, 2);
		Matcher mhState = ptState.matcher(sql);
		if (mhState.find())
			sql = mhState.replaceAll(" 1=1 ");
		Pattern ptLsinsured = Pattern.compile("\\s+?lsinsured\\s+?where\\s+?", 2);
		Matcher mhLsinsured = ptLsinsured.matcher(sql);
		if (mhLsinsured.find())
			sql = mhLsinsured.replaceAll(" lsinsured where contno='?contno?' and ");
		return sql;
	}

	public static void main(String args[])
	{
		OracleTOMySqlFilter otsf = new OracleTOMySqlFilter();
		LNPCalModeDB rLNPCalmodeDB = new LNPCalModeDB();
		LNPCalModeSet tLNPCalModeSet = rLNPCalmodeDB.executeQuery("select * from lmcalmode");
		if (tLNPCalModeSet != null && tLNPCalModeSet.size() > 0)
		{
			LNPCalModeSchema tLNPCalModeSchema = null;
			LNPCalModeDB tempLNPCalModeDB = new LNPCalModeDB();
			for (int i = 1; i <= tLNPCalModeSet.size(); i++)
			{
				System.out.println((new StringBuilder("������===")).append(i).toString());
				tLNPCalModeSchema = tLNPCalModeSet.get(i);
				tLNPCalModeSchema.setCalSQL(otsf.filter(tLNPCalModeSchema.getCalSQL()));
				tempLNPCalModeDB.setSchema(tLNPCalModeSchema);
				if (!tempLNPCalModeDB.update())
					System.out.println((new StringBuilder("����=======:")).append(tempLNPCalModeDB.mErrors.getFirstError()).toString());
			}

		}
	}

	private void jbInit()
		throws Exception
	{
	}
}
