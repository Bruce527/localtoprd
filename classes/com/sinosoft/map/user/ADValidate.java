// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ADValidate.java

package com.sinosoft.map.user;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;

// Referenced classes of package com.sinosoft.map.user:
//			ADUser, LdapHelper

public class ADValidate
{

	private static DirContext ctx;

	public ADValidate()
	{
	}

	public ADUser CheckUser(ADUser aduser)
	{
		ADUser resultADUser;
		DirContext ctx;
		resultADUser = new ADUser();
		ctx = null;
		Attributes attrs;
		LdapHelper tLdapHelper = new LdapHelper();
		ctx = tLdapHelper.getCtx(aduser.getUserCode(), aduser.getPassWord());
		if (ctx == null)
			break MISSING_BLOCK_LABEL_434;
		System.out.println("认证成功-----1");
		SearchControls constraints = new SearchControls();
		constraints.setSearchScope(2);
		String cnStr = (new StringBuilder("cn=")).append(aduser.getUserCode()).toString();
		System.out.println((new StringBuilder("cnStr-----")).append(cnStr).toString());
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs1 = new SSRS();
		String ldapsearchSql = "select varvalue from msysvar where vartype = 'ldapsearch'";
		ssrs1 = exeSQL.execSQL(ldapsearchSql);
		NamingEnumeration en = ctx.search(ssrs1.GetText(1, 1), cnStr, constraints);
		System.out.println((new StringBuilder(String.valueOf(en.hasMoreElements()))).append("---------").toString());
		if (en == null || !en.hasMoreElements())
			break MISSING_BLOCK_LABEL_425;
		Object obj = en.nextElement();
		if (!(obj instanceof SearchResult))
			break MISSING_BLOCK_LABEL_423;
		SearchResult si = (SearchResult)obj;
		attrs = si.getAttributes();
		if (attrs != null)
			break MISSING_BLOCK_LABEL_246;
		System.out.println("No   attributes");
		return null;
		resultADUser.setUserCode(aduser.getUserCode());
		Attribute attr = attrs.get("pwdLastSet");
		Object o = attr.get();
		System.out.println(o);
		String pwd = (String)o;
		long lpwd = Long.parseLong(pwd);
		int iYearsFrom1601to1970 = 369;
		int iDaysFrom1601to1970 = iYearsFrom1601to1970 * 365;
		iDaysFrom1601to1970 += iYearsFrom1601to1970 / 4;
		long iSecondsFrom1601to1970 = (iDaysFrom1601to1970 -= 3) * 24 * 60 * 60;
		long iTotalSecondsSince1601 = (int)(lpwd / 0x989680L);
		long iTotalSecondsSince1970 = iTotalSecondsSince1601 - iSecondsFrom1601to1970;
		Date oDate = new Date(iTotalSecondsSince1970 * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String rdate = sdf.format(oDate);
		System.out.println((new StringBuilder("setPwdLastSetDate--------------------------")).append(rdate).toString());
		resultADUser.setPwdLastSetDate(rdate);
		resultADUser.setLogin(true);
		return resultADUser;
		return null;
		try
		{
			ctx.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		break MISSING_BLOCK_LABEL_445;
		return null;
		return null;
	}

	public String ChangePassWord(ADUser adUser)
	{
		LdapHelper tLdapHelper = new LdapHelper();
		String result = tLdapHelper.updatePwdLdap(adUser.getUserCode(), adUser.getPassWord(), adUser.getNewPassWord());
		if (result != null)
			return result;
		else
			return "3";
	}

	public static void main(String args1[])
	{
	}
}
