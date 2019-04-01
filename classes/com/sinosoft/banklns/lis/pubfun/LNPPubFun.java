// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPubFun.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.banklns.lis.pubfun:
//			PubFun

public class LNPPubFun
{

	public LNPPubFun()
	{
	}

	public static String getSysInfo(String string)
	{
		ExeSQL exeSQL = new ExeSQL();
		String sql = (new StringBuilder("select sysvarvalue from lnpsysvar where sysvar = '")).append(string).append("'").toString();
		SSRS ssrs = exeSQL.execSQL(sql);
		if (ssrs.MaxRow > 0)
		{
			String reString = ssrs.GetText(1, 1);
			return reString;
		} else
		{
			return null;
		}
	}

	public static void main(String args[])
	{
		LNPPubFun q = new LNPPubFun();
		System.out.println(Integer.parseInt("20120102  ".trim()) > Integer.parseInt("20120101".trim()));
	}

	public static String getAgeByBirthdayNew(String strBirthday, String strApplyDay)
	{
		String returnAge = "-1";
		String arrBirthday[] = strBirthday.split("-");
		String arrApplyday[] = strApplyDay.split("-");
		int age = Integer.parseInt(arrApplyday[0]) - Integer.parseInt(arrBirthday[0]) - 1;
		if (Integer.parseInt(arrApplyday[1]) > Integer.parseInt(arrBirthday[1]))
			age++;
		else
		if (Integer.parseInt(arrApplyday[1]) >= Integer.parseInt(arrBirthday[1]) && Integer.parseInt(arrApplyday[2]) >= Integer.parseInt(arrBirthday[2]))
			age++;
		if (age >= 0)
			if (age == 0)
				returnAge = (new StringBuilder(String.valueOf(PubFun.calInterval(strBirthday, strApplyDay, "D")))).append("£¨Ìì£©").toString();
			else
				returnAge = (new StringBuilder(String.valueOf(age))).append("£¨ÖÜËê£©").toString();
		return returnAge;
	}

	public static String[] getAppAge(String strBirthday, String strApplyDay)
	{
		String str[] = new String[2];
		int returnAge = 0;
		returnAge = PubFun.calInterval(strBirthday, strApplyDay, "Y");
		if (returnAge > 0)
		{
			str[0] = "Y";
			str[1] = String.valueOf(returnAge);
			return str;
		}
		if (returnAge == 0)
		{
			returnAge = PubFun.calInterval(strBirthday, strApplyDay, "D");
			if (returnAge < 0)
			{
				return null;
			} else
			{
				str[0] = "D";
				str[1] = String.valueOf(returnAge);
				return str;
			}
		} else
		{
			return null;
		}
	}
}
