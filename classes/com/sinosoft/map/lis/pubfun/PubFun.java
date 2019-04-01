// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PubFun.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			FDate, GlobalInput

public class PubFun
{

	public static boolean iswait = false;

	public PubFun()
	{
	}

	public static Date calDate(Date baseDate, int interval, String unit, Date compareDate)
	{
		Date returnDate = null;
		GregorianCalendar mCalendar = new GregorianCalendar();
		mCalendar.setTime(baseDate);
		if (unit.equals("Y"))
			mCalendar.add(1, interval);
		if (unit.equals("M"))
			mCalendar.add(2, interval);
		if (unit.equals("D"))
			mCalendar.add(5, interval);
		if (compareDate != null)
		{
			GregorianCalendar cCalendar = new GregorianCalendar();
			cCalendar.setTime(compareDate);
			int mYears = mCalendar.get(1);
			int mMonths = mCalendar.get(2);
			int cMonths = cCalendar.get(2);
			int cDays = cCalendar.get(5);
			if (unit.equals("Y"))
			{
				cCalendar.set(mYears, cMonths, cDays);
				if (cCalendar.before(mCalendar))
				{
					mCalendar.set(mYears + 1, cMonths, cDays);
					returnDate = mCalendar.getTime();
				} else
				{
					returnDate = cCalendar.getTime();
				}
			}
			if (unit.equals("M"))
			{
				cCalendar.set(mYears, mMonths, cDays);
				if (cCalendar.before(mCalendar))
				{
					mCalendar.set(mYears, mMonths + 1, cDays);
					returnDate = mCalendar.getTime();
				} else
				{
					returnDate = cCalendar.getTime();
				}
			}
			if (unit.equals("D"))
				returnDate = mCalendar.getTime();
		} else
		{
			returnDate = mCalendar.getTime();
		}
		return returnDate;
	}

	public static String calDate(String baseDate, int interval, String unit, String compareDate)
	{
		FDate tFDate;
		Date bDate;
		Date cDate;
		tFDate = new FDate();
		bDate = tFDate.getDate(baseDate);
		cDate = tFDate.getDate(compareDate);
		return tFDate.getString(calDate(bDate, interval, unit, cDate));
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public static int calInterval(Date startDate, Date endDate, String unit)
	{
		int interval = 0;
		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(1);
		int sMonths = sCalendar.get(2);
		int sDays = sCalendar.get(5);
		int sDaysOfYear = sCalendar.get(6);
		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(1);
		int eMonths = eCalendar.get(2);
		int eDays = eCalendar.get(5);
		int eDaysOfYear = eCalendar.get(6);
		if (unit.equals("Y"))
		{
			interval = eYears - sYears;
			if (eMonths < sMonths)
				interval--;
			else
			if (eMonths == sMonths && eDays < sDays)
			{
				interval--;
				if (eMonths == 1 && sYears % 4 == 0 && eYears % 4 != 0 && eDays == 28)
					interval++;
			}
		}
		if (unit.equals("M"))
		{
			interval = eYears - sYears;
			interval *= 12;
			interval += eMonths - sMonths;
			if (eDays < sDays)
			{
				interval--;
				int maxDate = eCalendar.getActualMaximum(5);
				if (eDays == maxDate)
					interval++;
			}
		}
		if (unit.equals("D"))
		{
			interval = eYears - sYears;
			interval *= 365;
			interval += eDaysOfYear - sDaysOfYear;
			int n = 0;
			if (--eYears > sYears)
			{
				int i = sYears % 4;
				if (i == 0)
					n++;
			}
			for (int eYears1 = eYears; eYears1 > sYears; eYears1--)
			{
				int j = eYears1 % 4;
				if (j == 0)
					n++;
			}

			if (eYears == sYears)
			{
				int i = sYears % 4;
				if (i == 0)
					n++;
			}
			interval += n;
		}
		return interval;
	}

	public static String formatSql(String sIn)
	{
		int n = sIn.length();
		int j = 0;
		String Str1 = null;
		String Str2 = null;
		String sOut = null;
		int i = 0;
		do
		{
			if (i >= n)
				break;
			j = sIn.indexOf("%25", i);
			if (j == -1)
				break;
			Str1 = sIn.substring(0, j + 1);
			Str2 = sIn.substring(j + 3);
			sIn = (new StringBuilder(String.valueOf(String.valueOf(Str1)))).append(String.valueOf(Str2)).toString();
			i = j;
		} while (true);
		sOut = sIn;
		System.out.println(sOut);
		return sOut;
	}

	public static int calInterval(String cstartDate, String cendDate, String unit)
	{
		FDate fDate = new FDate();
		Date startDate = fDate.getDate(cstartDate);
		Date endDate = fDate.getDate(cendDate);
		if (fDate.mErrors.needDealError())
			return 0;
		int interval = 0;
		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(1);
		int sMonths = sCalendar.get(2);
		int sDays = sCalendar.get(5);
		int sDaysOfYear = sCalendar.get(6);
		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(1);
		int eMonths = eCalendar.get(2);
		int eDays = eCalendar.get(5);
		int eDaysOfYear = eCalendar.get(6);
		if (StrTool.cTrim(unit).equals("Y"))
		{
			interval = eYears - sYears;
			if (eMonths < sMonths)
				interval--;
			else
			if (eMonths == sMonths && eDays < sDays)
			{
				interval--;
				if (eMonths == 1 && sYears % 4 == 0 && eYears % 4 != 0 && eDays == 28)
					interval++;
			}
		}
		if (StrTool.cTrim(unit).equals("M"))
		{
			interval = eYears - sYears;
			interval *= 12;
			interval += eMonths - sMonths;
			if (eDays < sDays)
			{
				interval--;
				int maxDate = eCalendar.getActualMaximum(5);
				if (eDays == maxDate)
					interval++;
			}
		}
		if (StrTool.cTrim(unit).equals("D"))
		{
			interval = eYears - sYears;
			interval *= 365;
			interval += eDaysOfYear - sDaysOfYear;
			int n = 0;
			if (--eYears > sYears)
			{
				int i = sYears % 4;
				if (i == 0)
					n++;
			}
			for (int eYears1 = eYears; eYears1 > sYears; eYears1--)
			{
				int j = eYears1 % 4;
				if (j == 0)
					n++;
			}

			if (eYears == sYears)
			{
				int i = sYears % 4;
				if (i == 0)
					n++;
			}
			interval += n;
		}
		return interval;
	}

	public static int calInterval2(String cstartDate, String cendDate, String unit)
	{
		FDate fDate = new FDate();
		Date startDate = fDate.getDate(cstartDate);
		Date endDate = fDate.getDate(cendDate);
		if (fDate.mErrors.needDealError())
			return 0;
		int interval = 0;
		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(1);
		int sMonths = sCalendar.get(2);
		int sDays = sCalendar.get(5);
		int sDaysOfYear = sCalendar.get(6);
		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(1);
		int eMonths = eCalendar.get(2);
		int eDays = eCalendar.get(5);
		int eDaysOfYear = eCalendar.get(6);
		if (StrTool.cTrim(unit).equals("Y"))
		{
			interval = eYears - sYears;
			if (eMonths > sMonths)
				interval++;
			else
			if (eMonths == sMonths && eDays > sDays)
			{
				interval++;
				if (eMonths == 1 && sYears % 4 == 0 && eYears % 4 != 0 && eDays == 28)
					interval--;
			}
		}
		if (StrTool.cTrim(unit).equals("M"))
		{
			interval = eYears - sYears;
			interval *= 12;
			interval += eMonths - sMonths;
			if (eDays > sDays)
			{
				interval++;
				int maxDate = eCalendar.getActualMaximum(5);
				if (eDays == maxDate)
					interval--;
			}
		}
		if (StrTool.cTrim(unit).equals("D"))
		{
			interval = eYears - sYears;
			interval *= 365;
			interval += eDaysOfYear - sDaysOfYear;
			int n = 0;
			if (--eYears > sYears)
			{
				int i = sYears % 4;
				if (i == 0)
					n++;
			}
			for (int eYears1 = eYears; eYears1 > sYears; eYears1--)
			{
				int j = eYears1 % 4;
				if (j == 0)
					n++;
			}

			if (eYears == sYears)
			{
				int i = sYears % 4;
				if (i == 0)
					n++;
			}
			interval += n;
		}
		return interval;
	}

	public static int calInterval3(String cstartDate, String cendDate, String unit)
	{
		FDate fDate = new FDate();
		Date startDate = fDate.getDate(cstartDate);
		Date endDate = fDate.getDate(cendDate);
		if (fDate.mErrors.needDealError())
			return 0;
		int interval = 0;
		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(1);
		int sMonths = sCalendar.get(2);
		int sDays = sCalendar.get(5);
		int sDaysOfYear = sCalendar.get(6);
		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(1);
		int eMonths = eCalendar.get(2);
		int eDays = eCalendar.get(5);
		int eDaysOfYear = eCalendar.get(6);
		if (StrTool.cTrim(unit).equals("Y"))
		{
			interval = eYears - sYears;
			if (eMonths > sMonths)
				interval++;
			else
			if (eMonths == sMonths && eDays > sDays)
			{
				interval++;
				if (eMonths == 1 && sYears % 4 == 0 && eYears % 4 != 0 && eDays == 28)
					interval--;
			}
		}
		if (StrTool.cTrim(unit).equals("M"))
		{
			interval = eYears - sYears;
			interval *= 12;
			interval += eMonths - sMonths;
			if (eDays > sDays)
			{
				interval++;
				int maxsDate = sCalendar.getActualMaximum(5);
				int maxeDate = eCalendar.getActualMaximum(5);
				if (sDays == maxsDate && eDays == maxeDate)
					interval--;
			}
		}
		if (StrTool.cTrim(unit).equals("D"))
		{
			interval = eYears - sYears;
			interval *= 365;
			interval += eDaysOfYear - sDaysOfYear;
			int n = 0;
			if (--eYears > sYears)
			{
				int i = sYears % 4;
				if (i == 0)
					n++;
			}
			for (int eYears1 = eYears; eYears1 > sYears; eYears1--)
			{
				int j = eYears1 % 4;
				if (j == 0)
					n++;
			}

			if (eYears == sYears)
			{
				int i = sYears % 4;
				if (i == 0)
					n++;
			}
			interval += n;
		}
		return interval;
	}

	public static String[] calFLDate(String tDate)
	{
		String MonDate[] = new String[2];
		FDate fDate = new FDate();
		Date CurDate = fDate.getDate(tDate);
		GregorianCalendar mCalendar = new GregorianCalendar();
		mCalendar.setTime(CurDate);
		int Years = mCalendar.get(1);
		int Months = mCalendar.get(2);
		int FirstDay = mCalendar.getActualMinimum(5);
		int LastDay = mCalendar.getActualMaximum(5);
		mCalendar.set(Years, Months, FirstDay);
		MonDate[0] = fDate.getString(mCalendar.getTime());
		mCalendar.set(Years, Months, LastDay);
		MonDate[1] = fDate.getString(mCalendar.getTime());
		return MonDate;
	}

	public static JdbcUrl getDefaultUrl()
	{
		JdbcUrl tUrl = new JdbcUrl();
		return tUrl;
	}

	public static String SecurNum(String tStr)
	{
		String tmp = "";
		String s1 = "";
		for (int i = 0; i < tStr.length(); i++)
		{
			s1 = tStr.substring(i, i + 1);
			if (s1.equals("0") || s1.equals("1") || s1.equals("2") || s1.equals("3") || s1.equals("4") || s1.equals("5") || s1.equals("6") || s1.equals("7") || s1.equals("8") || s1.equals("9"))
				tmp = (new StringBuilder(String.valueOf(tmp))).append(s1).toString();
			else
				tmp = (new StringBuilder(String.valueOf(tmp))).append("0").toString();
		}

		int t = Integer.parseInt(tmp);
		int iResult = ((((t % 0xf4240) * 17 + 1) % 0xf4240) * 41) % 0xf4240;
		String sResult = Integer.toString(iResult);
		sResult = LCh(sResult, "0", 6);
		return sResult;
	}

	public static String TransID(String tStrID)
	{
		String tStrIDtmp = "";
		String tStrIDnew = "";
		String tChkLetter = "10X98765432";
		int r1 = 0;
		int w1 = 1;
		tStrIDtmp = (new StringBuilder(String.valueOf(tStrID.substring(0, 6)))).append("19").append(tStrID.substring(6, 15)).toString();
		for (int i = 17; i >= 1; i--)
		{
			int a = Integer.parseInt(tStrIDtmp.substring(i - 1, i));
			w1 *= 2;
			int w = w1 % 11;
			r1 += w * a;
		}

		int j = r1 % 11;
		if (j >= 0 && j <= 10)
		{
			j++;
			tStrIDnew = (new StringBuilder(String.valueOf(tStrIDtmp))).append(tChkLetter.substring(j - 1, j)).toString();
		} else
		{
			tStrIDnew = (new StringBuilder(String.valueOf(tStrIDtmp))).append("E").toString();
		}
		return tStrIDnew;
	}

	public static String TrimSpace(String tStr)
	{
		String tStrnew = "";
		String tStr1 = "";
		int j = 0;
		tStr = tStr.trim();
		j = tStr.length();
		for (int i = 0; i < j; i++)
		{
			tStr1 = tStr.substring(i, i + 1);
			if (!tStr1.equals(" "))
				tStrnew = (new StringBuilder(String.valueOf(tStrnew))).append(tStr1).toString();
		}

		return tStrnew;
	}

	public static int getASCII(char tchar)
	{
		int k = 0;
		for (int i = -128; i <= 256; i++)
		{
			char tchar1 = (char)i;
			if (tchar1 != tchar)
				continue;
			k = i;
			break;
		}

		return k;
	}

	public static String filterCH(String tStr)
	{
		String tStr1 = "";
		String tStrtmp = "";
		int j = 0;
		int k = 1;
		int tSwitch = 0;
		for (int i = 1; i <= tStr.length(); i++)
		{
			j = getASCII(tStr.charAt(i - 1));
			System.out.println(j);
			if (j < 0)
			{
				if (tSwitch == 1)
				{
					tSwitch = 0;
					tStr1 = (new StringBuilder(String.valueOf(tStr1))).append(tStr.substring(i - 2, i)).toString();
				} else
				{
					tSwitch = 1;
				}
			} else
			if (tSwitch == 1)
			{
				tSwitch = 0;
				tStr1 = (new StringBuilder(String.valueOf(tStr1))).append(tStr.substring(i - 1, i)).toString();
			} else
			{
				tStr1 = (new StringBuilder(String.valueOf(tStr1))).append(tStr.substring(i - 1, i)).toString();
			}
		}

		return tStr1;
	}

	public static String RCh(String sourString, String cChar, int cLen)
	{
		int tLen = sourString.length();
		String tReturn = "";
		if (tLen >= cLen)
			return sourString;
		int iMax = cLen - tLen;
		for (int i = 0; i < iMax; i++)
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append(cChar).toString();

		tReturn = (new StringBuilder(String.valueOf(sourString.trim()))).append(tReturn.trim()).toString();
		return tReturn;
	}

	public static String LCh(String sourString, String cChar, int cLen)
	{
		int tLen = sourString.length();
		String tReturn = "";
		if (tLen >= cLen)
			return sourString;
		int iMax = cLen - tLen;
		for (int i = 0; i < iMax; i++)
			tReturn = (new StringBuilder(String.valueOf(tReturn))).append(cChar).toString();

		tReturn = (new StringBuilder(String.valueOf(tReturn.trim()))).append(sourString.trim()).toString();
		return tReturn;
	}

	public static String getLaterDate(String date1, String date2)
	{
		date1 = StrTool.cTrim(date1);
		date2 = StrTool.cTrim(date2);
		if (date1.equals(""))
			return date2;
		if (date2.equals(""))
			return date1;
		Date d1;
		Date d2;
		FDate fd = new FDate();
		d1 = fd.getDate(date1);
		d2 = fd.getDate(date2);
		if (d1.after(d2))
			return date1;
		return date2;
		Exception e;
		e;
		e.printStackTrace();
		return "";
	}

	public static String getBeforeDate(String date1, String date2)
	{
		date1 = StrTool.cTrim(date1);
		date2 = StrTool.cTrim(date2);
		if (date1.equals(""))
			return date2;
		if (date2.equals(""))
			return date1;
		Date d1;
		Date d2;
		FDate fd = new FDate();
		d1 = fd.getDate(date1);
		d2 = fd.getDate(date2);
		if (d1.before(d2))
			return date1;
		return date2;
		Exception e;
		e;
		e.printStackTrace();
		return "";
	}

	public static String getCurrentDate()
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = "";
		tString = df.format(today);
		return tString;
	}

	public static String claimApplyDate(String clmDate)
	{
		String pattern = "yyyy年MM月dd日";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		FDate tFDate = new FDate();
		Date tDate = tFDate.getDate(clmDate);
		String tString = df.format(tDate);
		return tString;
	}

	public static String claimConfirmDate(String clmConDate)
	{
		String pattern = "yyyy年MM月dd日";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		FDate tFDate = new FDate();
		Date tDate = tFDate.getDate(clmConDate);
		String tString = df.format(tDate);
		return tString;
	}

	public static String getCurrentTime()
	{
		String pattern = "HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	public static String getNoLimit(String comCode)
	{
		comCode = comCode.trim();
		int tLen = comCode.length();
		if (tLen > 6)
			comCode = comCode.substring(0, 6);
		if (tLen < 6)
			comCode = RCh(comCode, "0", 6);
		String tString = "";
		tString = (new StringBuilder(String.valueOf(comCode))).append(getCurrentDate().substring(0, 4)).toString();
		return tString;
	}

	public static String getPiccNoLimit(String comCode)
	{
		comCode = comCode.trim();
		System.out.println((new StringBuilder("comCode :")).append(comCode).toString());
		int tLen = comCode.length();
		if (tLen == 8)
			comCode = comCode.substring(2, 6);
		if (tLen == 4)
			comCode = (new StringBuilder(String.valueOf(comCode.substring(2, 4)))).append("00").toString();
		System.out.println((new StringBuilder("SubComCode :")).append(comCode).toString());
		String tString = "";
		tString = (new StringBuilder(String.valueOf(comCode))).append(getCurrentDate().substring(2, 4)).append(getCurrentDate().substring(5, 7)).append(getCurrentDate().substring(8, 10)).toString();
		System.out.println((new StringBuilder("PubFun getPiccNoLimit : ")).append(tString).toString());
		return tString;
	}

	public static String getTenLengNo(String tNo)
	{
		String tRetrunValue = "";
		int tLength = tNo.length();
		if (tLength < 12)
		{
			int t = 12 - tLength;
			String tempAdd = "";
			for (int i = 1; i <= t; i++)
				tempAdd = (new StringBuilder(String.valueOf(tempAdd))).append("0").toString();

			tRetrunValue = (new StringBuilder(String.valueOf(tempAdd))).append(tNo).toString();
		}
		return tRetrunValue;
	}

	public static String getStr(String c_Str, int c_i, String c_Split)
	{
		String t_Str1 = "";
		String t_Str2 = "";
		String t_strOld = "";
		int i = 0;
		int i_Start = 0;
		t_Str1 = c_Str;
		t_Str2 = c_Split;
		i = 0;
		try
		{
			while (i < c_i) 
			{
				i_Start = t_Str1.indexOf(t_Str2, 0);
				if (i_Start >= 0)
				{
					i++;
					t_strOld = t_Str1;
					t_Str1 = t_Str1.substring(i_Start + t_Str2.length(), t_Str1.length());
					continue;
				}
				if (i != c_i - 1)
					t_Str1 = "";
				break;
			}
			if (i_Start >= 0)
				t_Str1 = t_strOld.substring(0, i_Start);
		}
		catch (Exception ex)
		{
			t_Str1 = "";
		}
		return t_Str1;
	}

	public static String getChnMoney(double money)
	{
		String ChnMoney = "";
		String s0 = "";
		if (money == 0.0D)
		{
			ChnMoney = "零元整";
			return ChnMoney;
		}
		if (money < 0.0D)
		{
			s0 = "负";
			money *= -1D;
		}
		String sMoney = (new DecimalFormat("0")).format(money * 100D);
		int nLen = sMoney.length();
		String sInteger;
		String sDot;
		if (nLen < 2)
		{
			sInteger = "";
			if (nLen == 1)
				sDot = (new StringBuilder("0")).append(sMoney.substring(nLen - 1, nLen)).toString();
			else
				sDot = "0";
		} else
		{
			sInteger = sMoney.substring(0, nLen - 2);
			sDot = sMoney.substring(nLen - 2, nLen);
		}
		String sFormatStr = formatStr(sInteger);
		String s1 = getChnM(sFormatStr.substring(0, 4), "亿");
		String s2 = getChnM(sFormatStr.substring(4, 8), "万");
		String s3 = getChnM(sFormatStr.substring(8, 12), "");
		String s4 = getDotM(sDot);
		if (s1.length() > 0 && s1.substring(0, 1).equals("0"))
			s1 = s1.substring(1, s1.length());
		if (s1.length() > 0 && s1.substring(s1.length() - 1, s1.length()).equals("0") && s2.length() > 0 && s2.substring(0, 1).equals("0"))
			s1 = s1.substring(0, s1.length() - 1);
		if (s2.length() > 0 && s2.substring(s2.length() - 1, s2.length()).equals("0") && s3.length() > 0 && s3.substring(0, 1).equals("0"))
			s2 = s2.substring(0, s2.length() - 1);
		if (s4.equals("00"))
		{
			s4 = "";
			if (s3.length() > 0 && s3.substring(s3.length() - 1, s3.length()).equals("0"))
				s3 = s3.substring(0, s3.length() - 1);
		}
		if (s3.length() > 0 && s3.substring(s3.length() - 1, s3.length()).equals("0") && s4.length() > 0)
			s3 = s3.substring(0, s3.length() - 1);
		if (s4.length() > 0 && s4.substring(s4.length() - 1, s4.length()).equals("0"))
			s4 = s4.substring(0, s4.length() - 1);
		if (s3.equals("0"))
		{
			s3 = "";
			s4 = (new StringBuilder("0")).append(s4).toString();
		}
		String tmpMoney = (new StringBuilder(String.valueOf(s0))).append(s1).append(s2).append(s3).toString();
		if ("".equals(tmpMoney.trim()))
			ChnMoney = s4;
		else
			ChnMoney = (new StringBuilder(String.valueOf(s0))).append(s1).append(s2).append(s3).append("元").append(s4).toString();
		if (ChnMoney.substring(0, 1).equals("0"))
			ChnMoney = ChnMoney.substring(1, ChnMoney.length());
		for (int i = 0; i < ChnMoney.length(); i++)
			if (ChnMoney.substring(i, i + 1).equals("0"))
				ChnMoney = (new StringBuilder(String.valueOf(ChnMoney.substring(0, i)))).append("零").append(ChnMoney.substring(i + 1, ChnMoney.length())).toString();

		if (sDot.substring(1, 2).equals("0") && sDot.substring(0, 1).equals("0"))
			ChnMoney = (new StringBuilder(String.valueOf(ChnMoney))).append("整").toString();
		return ChnMoney;
	}

	private static String getDotM(String sIn)
	{
		String sMoney = "";
		if (!sIn.substring(0, 1).equals("0"))
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(sIn.substring(0, 1))).append("角").toString();
		else
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
		if (!sIn.substring(1, 2).equals("0"))
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(sIn.substring(1, 2))).append("分").toString();
		else
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
		return sMoney;
	}

	private static String getChnM(String strUnit, String digit)
	{
		String sMoney = "";
		boolean flag = false;
		if (strUnit.equals("0000"))
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
			return sMoney;
		}
		if (!strUnit.substring(0, 1).equals("0"))
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(strUnit.substring(0, 1))).append("仟").toString();
		} else
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
			flag = true;
		}
		if (!strUnit.substring(1, 2).equals("0"))
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(strUnit.substring(1, 2))).append("佰").toString();
			flag = false;
		} else
		if (!flag)
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
			flag = true;
		}
		if (!strUnit.substring(2, 3).equals("0"))
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(strUnit.substring(2, 3))).append("拾").toString();
			flag = false;
		} else
		if (!flag)
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
			flag = true;
		}
		if (!strUnit.substring(3, 4).equals("0"))
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(strUnit.substring(3, 4))).toString();
		else
		if (!flag)
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
			flag = true;
		}
		if (sMoney.substring(sMoney.length() - 1, sMoney.length()).equals("0"))
			sMoney = (new StringBuilder(String.valueOf(sMoney.substring(0, sMoney.length() - 1)))).append(digit.trim()).append("0").toString();
		else
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(digit.trim()).toString();
		return sMoney;
	}

	private static String formatStr(String sIn)
	{
		int n = sIn.length();
		String sOut = sIn;
		for (int k = 1; k <= 12 - n; k++)
			sOut = (new StringBuilder("0")).append(sOut).toString();

		return sOut;
	}

	private static String getNum(String value)
	{
		String sNum = "";
		Integer I = new Integer(value);
		int iValue = I.intValue();
		switch (iValue)
		{
		case 0: // '\0'
			sNum = "零";
			break;

		case 1: // '\001'
			sNum = "壹";
			break;

		case 2: // '\002'
			sNum = "贰";
			break;

		case 3: // '\003'
			sNum = "叁";
			break;

		case 4: // '\004'
			sNum = "肆";
			break;

		case 5: // '\005'
			sNum = "伍";
			break;

		case 6: // '\006'
			sNum = "陆";
			break;

		case 7: // '\007'
			sNum = "柒";
			break;

		case 8: // '\b'
			sNum = "捌";
			break;

		case 9: // '\t'
			sNum = "玖";
			break;
		}
		return sNum;
	}

	public static String getInt(String Value)
	{
		if (Value == null)
			return null;
		String result = "";
		boolean mflag = true;
		int m = 0;
		m = Value.lastIndexOf(".");
		if (m == -1)
		{
			result = Value;
		} else
		{
			for (int i = m + 1; i <= Value.length() - 1; i++)
			{
				if (Value.charAt(i) == '0')
					continue;
				result = Value;
				mflag = false;
				break;
			}

			if (mflag)
				result = Value.substring(0, m);
		}
		return result;
	}

	public static double getApproximation(double aValue)
	{
		if (Math.abs(aValue) <= 0.01D)
			aValue = 0.0D;
		return aValue;
	}

	public static String[] split(String strMain, String strDelimiters)
	{
		int intIndex = 0;
		Vector vResult = new Vector();
		String strSub = "";
		strMain = strMain.trim();
		if (strMain.length() <= strDelimiters.length())
		{
			System.out.println("分隔符串长度大于等于主字符串长度，不能进行拆分！");
			return null;
		}
		intIndex = strMain.indexOf(strDelimiters);
		String arrResult[];
		if (intIndex == -1)
		{
			arrResult = (new String[] {
				strMain
			});
			return arrResult;
		}
		for (; intIndex != -1; intIndex = strMain.indexOf(strDelimiters))
		{
			strSub = strMain.substring(0, intIndex);
			if (intIndex != 0)
				vResult.add(strSub);
			else
				vResult.add("");
			strMain = strMain.substring(intIndex + strDelimiters.length()).trim();
		}

		if (!strMain.equals(""))
			vResult.add(strMain);
		arrResult = new String[vResult.size()];
		for (int i = 0; i < vResult.size(); i++)
			arrResult[i] = (String)vResult.get(i);

		return arrResult;
	}

	public static double setPrecision(float value, String precision)
	{
		return (double)Float.parseFloat((new DecimalFormat(precision)).format(value));
	}

	public static double setPrecision(double value, String precision)
	{
		return Double.parseDouble((new DecimalFormat(precision)).format(value));
	}

	public static SchemaSet copySchemaSet(SchemaSet srcSet)
	{
		Reflections reflect = new Reflections();
		if (srcSet == null || srcSet.size() <= 0)
			break MISSING_BLOCK_LABEL_81;
		if (srcSet.getObj(1) == null)
			return null;
		SchemaSet obj;
		Class cls = srcSet.getClass();
		Schema schema = (Schema)srcSet.getObj(1).getClass().newInstance();
		obj = (SchemaSet)cls.newInstance();
		obj.add(schema);
		reflect.transFields(obj, srcSet);
		return obj;
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public static boolean exchangeSchema(Schema source, Schema object)
	{
		try
		{
			Reflections tReflections = new Reflections();
			tReflections.transFields(object, source);
			Method m = object.getClass().getMethod("getDB", null);
			Schema schemaDB = (Schema)m.invoke(object, null);
			m = schemaDB.getClass().getMethod("getInfo", null);
			m.invoke(schemaDB, null);
			m = schemaDB.getClass().getMethod("getSchema", null);
			object = (Schema)m.invoke(schemaDB, null);
			m = object.getClass().getMethod("getSchema", null);
			Schema tSchema = (Schema)m.invoke(object, null);
			tReflections.transFields(object, source);
			tReflections.transFields(source, tSchema);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public static Vector formUpdateSql(String tables[], String condition, String wherepart)
	{
		Vector sqlVec = new Vector();
		for (int i = 0; i < tables.length; i++)
			sqlVec.add((new StringBuilder("update ")).append(tables[i]).append(" set ").append(condition).append(" where ").append(wherepart).toString());

		return sqlVec;
	}

	public static String DeleteZero(String sIn)
	{
		int n = sIn.length();
		String sOut = sIn;
		int k = 0;
		for (; sOut.substring(0, 1).equals("0") && n > 1; System.out.println(sOut))
		{
			sOut = sOut.substring(1, n);
			n = sOut.length();
		}

		if (sOut.equals("0"))
			return "";
		else
			return sOut;
	}

	public static String CreateSeq(String seq)
	{
		String tt = null;
		ExeSQL tExeSQL = new ExeSQL();
		try
		{
			tt = tExeSQL.getOneValue((new StringBuilder("select ")).append(seq).append(".nextval from dual").toString());
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
		return tt;
	}

	public static String CreateSeq(String seq, int len)
	{
		String tt = CreateSeq(seq);
		tt = LCh(tt, "0", len);
		return tt;
	}

	public static String changForJavaScript(String s)
	{
		char arr[] = s.toCharArray();
		s = "";
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == '"' || arr[i] == '\'' || arr[i] == '\n')
				s = (new StringBuilder(String.valueOf(s))).append("\\").toString();
			s = (new StringBuilder(String.valueOf(s))).append(arr[i]).toString();
		}

		return s;
	}

	public static String changForHTML(String s)
	{
		char arr[] = s.toCharArray();
		s = "";
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == '"' || arr[i] == '\'')
				s = (new StringBuilder(String.valueOf(s))).append("\\").toString();
			if (arr[i] == '\n')
				s = (new StringBuilder(String.valueOf(s))).append("<br>").toString();
			else
				s = (new StringBuilder(String.valueOf(s))).append(arr[i]).toString();
		}

		return s;
	}

	public static String getClassFileName(Object o)
	{
		String fileName = o.getClass().getName();
		fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
		return fileName;
	}

	public static void out(Object o, String s)
	{
		System.out.println((new StringBuilder(String.valueOf(getClassFileName(o)))).append(" : ").append(s).toString());
	}

	public static int calPolYear(String cstartDate, String cendDate)
	{
		FDate fDate = new FDate();
		Date startDate = fDate.getDate(cstartDate);
		Date endDate = fDate.getDate(cendDate);
		if (fDate.mErrors.needDealError())
			return 0;
		int interval = 0;
		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(1);
		int sDaysOfYear = sCalendar.get(6);
		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(1);
		int eDaysOfYear = eCalendar.get(6);
		interval = eYears - sYears;
		interval *= 365;
		interval += eDaysOfYear - sDaysOfYear;
		int n = 0;
		if (--eYears > sYears)
		{
			int i = sYears % 4;
			if (i == 0)
			{
				sYears++;
				n++;
			}
			int j = eYears % 4;
			if (j == 0)
			{
				eYears--;
				n++;
			}
			n += (eYears - sYears) / 4;
		}
		if (eYears == sYears)
		{
			int i = sYears % 4;
			if (i == 0)
				n++;
		}
		interval += n;
		int x = 365;
		int PolYear;
		for (PolYear = 1; x < interval; PolYear++)
			x += 365;

		return PolYear;
	}

	public static String getBirthdayFromId(String IdNo)
	{
		String tIdNo = StrTool.cTrim(IdNo);
		String birthday = "";
		if (tIdNo.length() != 15 && tIdNo.length() != 18)
			return "";
		if (tIdNo.length() == 18)
		{
			birthday = tIdNo.substring(6, 14);
			birthday = (new StringBuilder(String.valueOf(birthday.substring(0, 4)))).append("-").append(birthday.substring(4, 6)).append("-").append(birthday.substring(6)).toString();
		}
		if (tIdNo.length() == 15)
		{
			birthday = tIdNo.substring(6, 12);
			birthday = (new StringBuilder(String.valueOf(birthday.substring(0, 2)))).append("-").append(birthday.substring(2, 4)).append("-").append(birthday.substring(4)).toString();
			birthday = (new StringBuilder("19")).append(birthday).toString();
		}
		return birthday;
	}

	public static String getSexFromId(String IdNo)
	{
		String sex;
		String tIdNo = StrTool.cTrim(IdNo);
		if (tIdNo.length() != 15 && tIdNo.length() != 18)
			return "";
		sex = "";
		if (tIdNo.length() == 15)
			sex = tIdNo.substring(14, 15);
		else
			sex = tIdNo.substring(16, 17);
		int iSex;
		iSex = Integer.parseInt(sex);
		iSex %= 2;
		if (iSex == 0)
			return "F";
		Exception ex;
		if (iSex == 1)
			return "M";
		else
			return "";
		ex;
		return "";
	}

	public static boolean canIDo(GlobalInput cGlobalInput, String RunScript)
	{
		String Operator = cGlobalInput.Operator;
		String sqlStr = "select * from LDMenu";
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("where NodeSign = 2 and RunScript = '").append(RunScript).append("' ").toString();
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("and NodeCode in ( select NodeCode from LDMenuGrpToMenu ").toString();
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("where MenuGrpCode in ( select MenuGrpCode from LDMenuGrp ").toString();
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("where MenuGrpCode in (select MenuGrpCode from LDUserToMenuGrp where UserCode = '").toString();
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append(Operator).toString();
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("') ) ) order by nodeorder").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sqlStr);
		return tSSRS != null && !tSSRS.equals("");
	}

	public static String moneyFormat(double value, int precision)
	{
		double inData = round(value, precision);
		int dealData = (int)inData;
		String a = (new StringBuilder(String.valueOf(round(inData - (double)dealData, precision)))).toString();
		String outData = "";
		while (dealData > 1000) 
		{
			int data = dealData % 1000;
			dealData /= 1000;
			String temp = (new StringBuilder()).append(data).toString();
			System.out.println((new StringBuilder("temp=")).append(temp).toString());
			if (temp.length() != 3)
			{
				for (int m = 0; m <= 3 - temp.length(); m++)
					temp = (new StringBuilder("0")).append(temp).toString();

			}
			outData = (new StringBuilder(",")).append(temp).append(outData).toString();
			System.out.println((new StringBuilder("outData=")).append(outData).toString());
		}
		outData = (new StringBuilder(String.valueOf(dealData))).append(outData).toString();
		if (precision != 0)
			if (a.length() >= precision + 2)
			{
				outData = (new StringBuilder(String.valueOf(outData))).append(a.substring(1, precision + 2)).toString();
			} else
			{
				outData = (new StringBuilder(String.valueOf(outData))).append(a.substring(1, a.length())).toString();
				for (int m = 0; m < (precision + 2) - a.length(); m++)
					outData = (new StringBuilder(String.valueOf(outData))).append("0").toString();

			}
		return outData;
	}

	public static String getChineseYear(String date)
	{
		if (date != null && !date.equals(""))
		{
			String t = "";
			String t1 = date.substring(0, 4);
			String t2;
			if (date.substring(5, 6).equals("0"))
				t2 = date.substring(6, 7);
			else
				t2 = date.substring(5, 7);
			String t3;
			if (date.substring(8, 9).equals("0"))
				t3 = date.substring(9, 10);
			else
				t3 = date.substring(8, 10);
			t = (new StringBuilder(String.valueOf(t1))).append("年").append(t2).append("月").append(t3).append("日").toString();
			return t;
		} else
		{
			return "";
		}
	}

	public static double round(double value, int precision)
	{
		if (precision < 0)
		{
			throw new IllegalArgumentException("The precision must be a positive integer or zero");
		} else
		{
			BigDecimal calNum = new BigDecimal(Double.toString(value));
			BigDecimal strType = new BigDecimal("1");
			return calNum.divide(strType, precision, 4).doubleValue();
		}
	}

	public static String calDateIntev(String strDate, int interval, String unit)
	{
		String date = "";
		try
		{
			GregorianCalendar mCalendar = new GregorianCalendar();
			FDate tFDate = new FDate();
			Date bDate = tFDate.getDate(strDate);
			mCalendar.setTime(bDate);
			if (unit.equals("Y"))
				mCalendar.add(1, interval);
			if (unit.equals("M"))
				mCalendar.add(2, interval);
			if (unit.equals("D"))
				mCalendar.add(5, interval);
			String Year = (new StringBuilder(String.valueOf(mCalendar.get(1)))).toString();
			String Month = (new StringBuilder(String.valueOf(mCalendar.get(2) + 1))).toString();
			String Days = (new StringBuilder(String.valueOf(mCalendar.get(5)))).toString();
			date = (new StringBuilder(String.valueOf(Year))).append("-").append(Month).append("-").append(Days).toString();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return date;
	}

	public static String getRealPath()
	{
		return getFullPathRelateClass("../../../../../..", com/sinosoft/map/lis/pubfun/PubFun);
		IOException ex;
		ex;
		return "Error!getFilePath Fail!";
	}

	public static String getFullPathRelateClass(String relatedPath, Class cls)
		throws IOException
	{
		String path = null;
		if (relatedPath == null)
		{
			throw new NullPointerException();
		} else
		{
			String clsPath = getPathFromClass(cls);
			File clsFile = new File(clsPath);
			String tempPath = (new StringBuilder(String.valueOf(clsFile.getParent()))).append(File.separator).append(relatedPath).toString();
			File file = new File(tempPath);
			path = file.getCanonicalPath();
			return path;
		}
	}

	public static String getPathFromClass(Class cls)
		throws IOException
	{
		String path = null;
		if (cls == null)
			throw new NullPointerException();
		URL url = getClassLocationURL(cls);
		if (url != null)
		{
			path = url.getPath();
			if ("jar".equalsIgnoreCase(url.getProtocol()))
			{
				try
				{
					path = (new URL(path)).getPath();
				}
				catch (MalformedURLException malformedurlexception) { }
				int location = path.indexOf("!/");
				if (location != -1)
					path = path.substring(0, location);
			}
			File file = new File(path);
			path = file.getCanonicalPath();
		}
		return path;
	}

	private static URL getClassLocationURL(Class cls)
	{
		if (cls == null)
			throw new IllegalArgumentException("null input: cls");
		URL result = null;
		String clsAsResource = cls.getName().replace('.', '/').concat(".class");
		ProtectionDomain pd = cls.getProtectionDomain();
		if (pd != null)
		{
			CodeSource cs = pd.getCodeSource();
			if (cs != null)
				result = cs.getLocation();
			if (result != null && "file".equals(result.getProtocol()))
				try
				{
					if (result.toExternalForm().endsWith(".jar") || result.toExternalForm().endsWith(".zip"))
						result = new URL("jar:".concat(result.toExternalForm()).concat("!/").concat(clsAsResource));
					else
					if ((new File(result.getFile())).isDirectory())
						result = new URL(result, clsAsResource);
				}
				catch (MalformedURLException malformedurlexception) { }
		}
		if (result == null)
		{
			ClassLoader clsLoader = cls.getClassLoader();
			result = clsLoader == null ? ClassLoader.getSystemResource(clsAsResource) : clsLoader.getResource(clsAsResource);
		}
		return result;
	}

	public static Object getClassForName(String sPackageClass)
	{
		Object obj;
		try
		{
			obj = Class.forName(sPackageClass).newInstance();
		}
		catch (Exception ex)
		{
			obj = null;
			ex.printStackTrace();
		}
		return obj;
	}

	public static Object getClassForName(String sPackage, String sClass)
	{
		Object obj;
		try
		{
			obj = Class.forName((new StringBuilder(String.valueOf(sPackage))).append(".").append(sClass).toString()).newInstance();
		}
		catch (Exception ex)
		{
			obj = null;
			ex.printStackTrace();
		}
		return obj;
	}

	public static String DealContNoMappingState(String PrtNo, String oriState, String newState)
	{
		String sql = (new StringBuilder("update lccontnomapping set state='")).append(newState).append("', modifydate='").append(getCurrentDate()).append("', modifytime='").append(getCurrentTime()).append("'  where prtno='").append(PrtNo).append("' and state='").append(oriState).append("'").toString();
		return sql;
	}

	public static String DealContNoMappingState(String PrtNo, String oriState, String newState, String accno)
	{
		String sql = (new StringBuilder("update lccontnomapping set state='")).append(newState).append("', modifydate='").append(getCurrentDate()).append("', modifytime='").append(getCurrentTime()).append("' ,standbyflag2 ='").append(accno).append("'  where prtno='").append(PrtNo).append("' and state='").append(oriState).append("'").toString();
		return sql;
	}

	public static boolean checkGrpAccMoney(String tCustomerNo, double tMoney, String tOtherNo, String tBussType)
	{
		String tCount;
		StringBuffer tSql = new StringBuffer(16);
		tSql.append((new StringBuilder("select count(1) from ljgrpacctrace where customerno = '")).append(tCustomerNo).append("' and otherno = '").append(tOtherNo).append("' and moneytype = '").append(tBussType).append("' and money = -").append(tMoney).toString());
		ExeSQL tExeSql = new ExeSQL();
		tCount = tExeSql.getOneValue(tSql.toString());
		if (tCount != null && !"0".equals(tCount))
			return true;
		double tAccMoney;
		StringBuffer tSql = new StringBuffer(16);
		tSql.append((new StringBuilder("select nvl(sum(money),0) from ljgrpacctrace where customerno = '")).append(tCustomerNo).append("'").toString());
		ExeSQL tExeSql = new ExeSQL();
		tAccMoney = Double.parseDouble(tExeSql.getOneValue(tSql.toString()));
		return tAccMoney >= tMoney;
		Exception e;
		e;
		e.printStackTrace();
		return false;
	}

	public static String DeleteTailZero(String tNum)
	{
		String tmpNum = tNum;
		int pos = tmpNum.length();
		boolean flag = false;
		do
		{
			pos = tmpNum.length();
			flag = false;
			int t1 = tmpNum.lastIndexOf(".");
			int t2 = tmpNum.lastIndexOf("0");
			if (t1 > 0 && t2 > t1 + 1 && pos == t2 + 1)
			{
				tmpNum = tmpNum.substring(0, t2);
				flag = true;
			}
			if (t1 > 0 && t2 == t1 + 1 && pos == t2 + 1)
			{
				tmpNum = tmpNum.substring(0, t1);
				flag = true;
			}
		} while (flag);
		return tmpNum;
	}

	public static boolean CheckChargeRate(String tGrpContNo)
	{
		String tSql = (new StringBuilder("select agentcom from lcgrpcont where grpcontno = '")).append(tGrpContNo).append("' ").toString();
		ExeSQL exeSql = new ExeSQL();
		String tResult = exeSql.getOneValue(tSql);
		return tResult != null && !tResult.equals("");
	}

	public static String[][] decodeEasyQueryResult(String strResult)
	{
		String Result[][];
		String RECORDDELIMITER;
		String FIELDDELIMITER;
		Result = new String[1024][];
		RECORDDELIMITER = "\\^";
		FIELDDELIMITER = "\\|";
		String arrResult[];
		int RowLen;
		int ColumnLen;
		int X;
		strResult = strResult.substring(strResult.indexOf("^") + 1);
		RowLen = strResult.split(RECORDDELIMITER).length;
		arrResult = new String[RowLen];
		arrResult = strResult.split(RECORDDELIMITER);
		String numOneLine = arrResult[0];
		ColumnLen = arrResult[0].split(FIELDDELIMITER).length;
		if (numOneLine.endsWith("|"))
			ColumnLen++;
		Result = new String[RowLen][ColumnLen];
		X = 0;
		  goto _L1
_L5:
		int cellLen;
		cellLen = arrResult[X].split(FIELDDELIMITER).length;
		String arrField[] = new String[ColumnLen];
		if (cellLen >= ColumnLen) goto _L3; else goto _L2
_L2:
		arrResult;
		X;
		JVM INSTR dup2 ;
		JVM INSTR aaload ;
		JVM INSTR new #140 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		toString();
		JVM INSTR aastore ;
_L3:
		String arrField[] = arrResult[X].split(FIELDDELIMITER);
		for (int Y = 0; Y < cellLen; Y++)
		{
			String str = arrField[Y];
			if (str == null)
				Result[X][Y] = "";
			else
				Result[X][Y] = arrField[Y];
		}

		X++;
_L1:
		if (X < RowLen) goto _L5; else goto _L4
_L4:
		break MISSING_BLOCK_LABEL_249;
		Exception ex;
		ex;
		System.out.println((new StringBuilder("PubFun.decodeEasyQueryResult Error::")).append(ex.toString()).toString());
		return Result;
	}

	public static String getPageCtrl(String nodecode, String userCode, String buttonType)
	{
		String roleSQL = (new StringBuilder(" select b.nodecode,a.menugrpcode from ledusertomenugrp a,ledmenugrptomenu b where a.usercode='")).append(userCode).append("'  and a.menugrpcode=b.menugrpcode and b.nodecode='").append(nodecode).append("'").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(roleSQL);
		if (tSSRS == null && tSSRS.MaxRow < 1)
			return "";
		String menuGrpCode = tSSRS.GetText(1, 2);
		String pageCtrl = (new StringBuilder("   select p.buttonid from ledpagectrl p where p.menugrpcode='")).append(menuGrpCode).append("' and p.nodecode='").append(nodecode).append("' and p.buttontype='").append(buttonType).append("' and p.buttonswitch=1").toString();
		SSRS ctrlSSRS = tExeSQL.execSQL(pageCtrl);
		if (ctrlSSRS == null && ctrlSSRS.MaxRow < 1)
			return "";
		String treturn = "";
		for (int i = 1; i <= ctrlSSRS.MaxRow; i++)
			treturn = (new StringBuilder(String.valueOf(treturn))).append(ctrlSSRS.GetText(i, 1)).append("|").toString();

		return treturn;
	}

	public static String getLastAccDate(String tPolNo)
	{
		ExeSQL tExeSQL = new ExeSQL();
		String tSQL = (new StringBuilder("select to_char(enddate, 'YYYY-MM-DD') from lcpol where polno='")).append(tPolNo).append("'").toString();
		String tEndDate = tExeSQL.getOneValue(tSQL);
		String tCurrentDate = getCurrentDate();
		String tLastAccDate = getBeforeDate(tEndDate, tCurrentDate);
		return tLastAccDate;
	}

	public static String isPolClaim(String contno, String edortype)
	{
		String treturn = "";
		ExeSQL tExeSQL = new ExeSQL();
		String SQL = (new StringBuilder(" select count(1) from llcase a, llclaim b, lcpol c  where b.clmno(+) = a.caseno and c.contno='")).append(contno).append("' ").append(" and a.contno=c.contno and (b.clmstate not in ('60', '70', '80') or b.clmstate is null) ").toString();
		String tResuit = tExeSQL.getOneValue(SQL);
		System.out.println((new StringBuilder("tianxh---")).append(SQL).toString());
		System.out.println((new StringBuilder("tianxh---")).append(tResuit).toString());
		if (Integer.parseInt(tResuit) > 0)
			treturn = "该保单发生理赔还未结案，请理赔结案后再申请保全！";
		return treturn;
	}

	public static String filterSQLParam(String content)
	{
		String flt = "'|drop|and|exec|insert|select|delete|update|count|*|chr|mid|master|truncate|char|declare|;|or|-|+|,";
		String filter[] = flt.split("|");
		for (int i = 0; i < filter.length; i++)
			content = content.replace(filter[i], "");

		return content;
	}

	public static void main(String args[])
	{
		String tContPlanCode = "ContPlanCode=0000000005";
		System.out.println((new StringBuilder("resss======")).append(filterSQLParam(tContPlanCode)).toString());
	}

}
