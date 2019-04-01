// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LdapHelper.java

package com.sinosoft.map.user;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LdapHelper
{

	private LdapContext ctx;

	public LdapHelper()
	{
	}

	public DirContext getCtx(String usercode, String password)
	{
		System.out.println((new StringBuilder("usercode-----")).append(usercode).toString());
		System.out.println((new StringBuilder("password-----")).append(password).toString());
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs1 = new SSRS();
		SSRS ssrs2 = new SSRS();
		String ldapurlSql = "select varvalue from msysvar where vartype = 'ldapurl'";
		String ldapprincipalSql = "select varvalue from msysvar where vartype = 'ldapprincipal'";
		ssrs1 = exeSQL.execSQL(ldapurlSql);
		ssrs2 = exeSQL.execSQL(ldapprincipalSql);
		String ldapurl = ssrs1.GetText(1, 1);
		String ldapprincipal = ssrs2.GetText(1, 1);
		System.out.println("=====================LDAP=============================");
		System.out.println(ldapurl);
		System.out.println(ldapprincipal);
		Hashtable env = new Hashtable(100);
		env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		env.put("java.naming.provider.url", ldapurl);
		env.put("java.naming.security.principal", (new StringBuilder(String.valueOf(usercode))).append(ldapprincipal).toString());
		env.put("java.naming.security.credentials", password);
		env.put("java.naming.referral", "throw");
		try
		{
			ctx = new InitialLdapContext(env, null);
			System.out.println("��֤�ɹ�-------1");
		}
		catch (AuthenticationException e)
		{
			System.out.println("��֤ʧ��-------2");
			e.printStackTrace();
			ctx = null;
		}
		catch (Exception e)
		{
			System.out.println("��֤��?--------3");
			e.printStackTrace();
			ctx = null;
		}
		return ctx;
	}

	public DirContext getCtxSSL(String usercode, String password)
	{
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs1 = new SSRS();
		SSRS ssrs2 = new SSRS();
		String ldapurlSql = "select varvalue from msysvar where vartype = 'ldapsslurl'";
		String ldapprincipalSql = "select varvalue from msysvar where vartype = 'ldapprincipal'";
		ssrs1 = exeSQL.execSQL(ldapurlSql);
		ssrs2 = exeSQL.execSQL(ldapprincipalSql);
		String ldapurl = ssrs1.GetText(1, 1);
		String ldapprincipal = ssrs2.GetText(1, 1);
		System.out.println("=====================LDAP-SSL=============================");
		System.out.println(ldapurl);
		System.out.println(ldapprincipal);
		String keystoreSql = "select varvalue from msysvar where vartype = 'keystore'";
		ssrs1 = exeSQL.execSQL(keystoreSql);
		String keystore = ssrs1.GetText(1, 1);
		File ff = new File(keystore);
		if (ff.exists())
			System.out.println("File OK1 ===========================");
		System.setProperty("javax.net.ssl.trustStore", keystore);
		Hashtable env = new Hashtable(100);
		env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		env.put("java.naming.provider.url", ldapurl);
		env.put("java.naming.security.authentication", "simple");
		env.put("java.naming.security.principal", (new StringBuilder(String.valueOf(usercode))).append(ldapprincipal).toString());
		env.put("java.naming.security.credentials", password);
		env.put("java.naming.referral", "throw");
		env.put("java.naming.security.protocol", "ssl");
		try
		{
			ctx = new InitialLdapContext(env, null);
			System.out.println("��֤�ɹ�-------1");
		}
		catch (AuthenticationException e)
		{
			System.out.println("��֤ʧ��-------2");
			e.printStackTrace();
			ctx = null;
		}
		catch (Exception e)
		{
			System.out.println("��֤��?--------3");
			e.printStackTrace();
			ctx = null;
		}
		return ctx;
	}

	public String updatePwdLdap(String usercode, String password, String newPassword)
	{
label0:
		{
			DirContext ctx = null;
			LdapHelper tLdapHelper = new LdapHelper();
			try
			{
				ctx = tLdapHelper.getCtxSSL(usercode, password);
				if (ctx == null)
					break label0;
				String newQuotedPassword = (new StringBuilder("\"")).append(newPassword).append("\"").toString();
				String oldQuotedPassword = (new StringBuilder("\"")).append(password).append("\"").toString();
				byte newUnicodePassword[] = newQuotedPassword.getBytes("UTF-16LE");
				byte oldUnicodePassword[] = oldQuotedPassword.getBytes("UTF-16LE");
				ExeSQL exeSQL = new ExeSQL();
				SSRS ssrs1 = new SSRS();
				String ldapnameSql = "select varvalue from msysvar where vartype = 'ldapname'";
				ssrs1 = exeSQL.execSQL(ldapnameSql);
				String ldapname = ssrs1.GetText(1, 1);
				String userName = (new StringBuilder("CN=")).append(usercode).append(",").append(ldapname).toString();
				ModificationItem mods[] = new ModificationItem[2];
				mods[0] = new ModificationItem(3, new BasicAttribute("unicodePwd", oldUnicodePassword));
				mods[1] = new ModificationItem(1, new BasicAttribute("unicodePwd", newUnicodePassword));
				ctx.modifyAttributes(userName, mods);
				ctx.close();
			}
			catch (Exception ex)
			{
label1:
				{
					ex.printStackTrace();
					try
					{
						if (ctx == null)
							break label1;
						ctx.close();
					}
					catch (NamingException namingException)
					{
						namingException.printStackTrace();
						return "3";
					}
					return "3";
				}
				return "3";
			}
			return "1";
		}
		return "2";
	}

	public static Calendar dateToCalendar(int date)
	{
		int day = date % 100;
		int month = (date / 100) % 100 - 1;
		int year = date / 10000;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal;
	}

	public static int calendarToDate(Calendar cal)
	{
		int day = cal.get(5);
		int month = cal.get(2) + 2;
		int year = cal.get(1);
		return year * 10000 + month * 100 + day;
	}

	public static String getCurrentDate()
	{
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String datenewformat = sdf.format(today);
		return datenewformat;
	}

	public static String getDate(Date today)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String datenewformat = sdf.format(today);
		return datenewformat;
	}

	public static void main(String args[])
	{
		long ll = Long.parseLong("128950056732968750");
		String qq = "128950056732968750";
		long DateInUserDefinedFormat = ll - 0xffffffffd53e8000L;
		DateInUserDefinedFormat /= 10000L;
		Date theDate = new Date(DateInUserDefinedFormat);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String forDate1 = formatter.format(theDate);
		int intFormatterValue = Integer.parseInt(forDate1);
		Calendar cal = dateToCalendar(intFormatterValue);
		cal.add(5, 60);
		int date2 = calendarToDate(cal);
		System.out.println(theDate);
		int iYearsFrom1601to1970 = 369;
		int iDaysFrom1601to1970 = iYearsFrom1601to1970 * 365;
		iDaysFrom1601to1970 += iYearsFrom1601to1970 / 4;
		long iSecondsFrom1601to1970 = (iDaysFrom1601to1970 -= 3) * 24 * 60 * 60;
		long iTotalSecondsSince1601 = 0x3c36c0ceL;
		long iTotalSecondsSince1970 = iTotalSecondsSince1601 - iSecondsFrom1601to1970;
		Date oDate = new Date(iTotalSecondsSince1970 * 1000L);
		System.out.println(oDate);
	}
}
