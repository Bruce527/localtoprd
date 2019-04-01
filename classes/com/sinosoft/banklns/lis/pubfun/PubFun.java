// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PubFun.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

// Referenced classes of package com.sinosoft.banklns.lis.pubfun:
//			FDate

public class PubFun
{

	public static HashMap riskDataHashMap = null;
	public static HashMap riskFlagDataHashMap = null;

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
			interval = (eMonths - sMonths) + interval;
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
			interval = (eDaysOfYear - sDaysOfYear) + interval;
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
		}
		return interval;
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
			interval = (eMonths - sMonths) + interval;
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
			interval = (eDaysOfYear - sDaysOfYear) + interval;
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
			interval = (eMonths - sMonths) + interval;
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
			interval = (eDaysOfYear - sDaysOfYear) + interval;
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

	public static Date stringConverttoDetailDate(String cDate)
	{
		Calendar tCalendar = Calendar.getInstance();
		int _year = Integer.parseInt(cDate.substring(0, 4));
		int _month = Integer.parseInt(cDate.substring(5, 7)) - 1;
		int _day = Integer.parseInt(cDate.substring(8, 10));
		int _hour = Integer.parseInt(cDate.substring(11, 13));
		int _min = Integer.parseInt(cDate.substring(14, 16));
		int _sec = Integer.parseInt(cDate.substring(17));
		tCalendar.set(1, _year);
		tCalendar.set(2, _month);
		tCalendar.set(5, _day);
		if (_hour <= 12)
			tCalendar.set(10, _hour);
		else
			tCalendar.set(10, _hour - 12);
		if (_hour < 12)
			tCalendar.set(9, 0);
		else
			tCalendar.set(9, 1);
		tCalendar.set(12, _min);
		tCalendar.set(13, _sec);
		return tCalendar.getTime();
		Exception e;
		e;
		return null;
	}

	public static JdbcUrl getDefaultUrl()
	{
		JdbcUrl tUrl = new JdbcUrl();
		return tUrl;
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
			tReturn = (new StringBuilder(String.valueOf(cChar))).append(tReturn).toString();

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
		String tString = df.format(today);
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

	public static String getStr(String c_Str, int c_i, String c_Split)
	{
		String t_Str1 = "";
		String t_Str2 = "";
		String t_strOld = "";
		int i = 0;
		int i_Start = 0;
		int j_End = 0;
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
		if (s3.length() > 0 && s3.substring(s3.length() - 1, s3.length()).equals("0") && s4.length() > 0 && s4.substring(0, 1).equals("0"))
			s3 = s3.substring(0, s3.length() - 1);
		if (s4.length() > 0 && s4.substring(s4.length() - 1, s4.length()).equals("0"))
			s4 = s4.substring(0, s4.length() - 1);
		if (s3.equals("0"))
		{
			s3 = "";
			s4 = (new StringBuilder("0")).append(s4).toString();
		}
		ChnMoney = (new StringBuilder(String.valueOf(s0))).append(s1).append(s2).append(s3).append("元").append(s4).toString();
		if (ChnMoney.substring(0, 1).equals("0"))
			ChnMoney = ChnMoney.substring(1, ChnMoney.length());
		for (int i = 0; i < ChnMoney.length(); i++)
			if (ChnMoney.substring(i, i + 1).equals("0"))
				ChnMoney = (new StringBuilder(String.valueOf(ChnMoney.substring(0, i)))).append("零").append(ChnMoney.substring(i + 1, ChnMoney.length())).toString();

		if (sDot.substring(1, 2).equals("0"))
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
		int i = n % 4;
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

	public static boolean dateBefore(Date date1, Date date2)
	{
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		dateConverttoDetailString(date1);
		dateConverttoDetailString(date2);
		calendar1.setTime(date1);
		calendar2.setTime(date2);
		return calendar1.before(calendar2);
	}

	public static String dateConverttoDetailString(Date cdate)
	{
		Calendar tCalendar = Calendar.getInstance();
		tCalendar.setTime(cdate);
		StringBuffer sb = new StringBuffer();
		sb.append(tCalendar.get(1));
		sb.append("-");
		sb.append(format(tCalendar.get(2) + 1, 2));
		sb.append("-");
		sb.append(format(tCalendar.get(5), 2));
		sb.append(" ");
		sb.append(tCalendar.get(9) != 0 ? format(tCalendar.get(10) + 12, 2) : format(tCalendar.get(10), 2));
		sb.append(":");
		sb.append(format(tCalendar.get(12), 2));
		sb.append(":");
		sb.append(format(tCalendar.get(13), 2));
		return sb.toString();
	}

	public static String format(int num, int len)
	{
		String result = "";
		int i = 1;
		int s = 10;
		for (; i <= len; i++)
		{
			if (num < s)
			{
				for (int j = 0; j < len - i; j++)
					result = result.concat("0");

				result = (new StringBuilder(String.valueOf(result))).append(num).toString();
				return result;
			}
			s *= 10;
		}

		for (int j = 0; j < len - i; j++)
			result = result.concat("-");

		return result;
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

		if (!strMain.equals("") && strMain != null)
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

	public static void main(String args[])
	{
		String DSumMoney = "";
		double SumGetMoney = 0.20999999999999999D;
		System.out.println("==> test_1");
		System.out.println((new StringBuilder("==> test_1_1 : ")).append(SumGetMoney).toString());
		DSumMoney = getChnMoney(SumGetMoney);
		System.out.println((new StringBuilder("==> test_2")).append(DSumMoney).toString());
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
		int sMonths = sCalendar.get(2);
		int sDays = sCalendar.get(5);
		int sDaysOfYear = sCalendar.get(6);
		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(1);
		int eMonths = eCalendar.get(2);
		int eDays = eCalendar.get(5);
		int eDaysOfYear = eCalendar.get(6);
		interval = eYears - sYears;
		interval *= 365;
		interval = (eDaysOfYear - sDaysOfYear) + interval;
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
			return "1";
		Exception ex;
		if (iSex == 1)
			return "0";
		else
			return "";
		ex;
		return "";
	}

	public static String getRiskNameOrSubflag(String RiskCode, String type)
	{
		if ("getRiskName".equals(type))
			if (riskDataHashMap == null)
			{
				ExeSQL query = new ExeSQL();
				SSRS riskSSRS = null;
				String risksql = "SELECT riskcode,riskshortname FROM lmrisk WHERE 1 = 1";
				riskSSRS = query.execSQL(risksql);
				if (riskSSRS.MaxRow > 0)
				{
					riskDataHashMap = new HashMap();
					for (int i = 1; i <= riskSSRS.MaxRow; i++)
						riskDataHashMap.put(riskSSRS.GetText(i, 1), riskSSRS.GetText(i, 2));

				}
				return (String)riskDataHashMap.get(RiskCode);
			} else
			{
				return (String)riskDataHashMap.get(RiskCode);
			}
		if ("getRiskFlag".equals(type))
		{
			if (riskFlagDataHashMap == null)
			{
				ExeSQL query = new ExeSQL();
				SSRS riskSSRS = null;
				String risksql = "SELECT riskcode,SubriskFlag FROM lmriskapp WHERE 1 = 1";
				riskSSRS = query.execSQL(risksql);
				if (riskSSRS.MaxRow > 0)
				{
					riskFlagDataHashMap = new HashMap();
					for (int i = 1; i <= riskSSRS.MaxRow; i++)
					{
						String SubriskFlag = riskSSRS.GetText(i, 2);
						if ("M".equals(SubriskFlag))
							SubriskFlag = "主约";
						else
							SubriskFlag = "附约";
						riskFlagDataHashMap.put(riskSSRS.GetText(i, 1), SubriskFlag);
					}

				}
				return (String)riskFlagDataHashMap.get(RiskCode);
			} else
			{
				return (String)riskFlagDataHashMap.get(RiskCode);
			}
		} else
		{
			return "";
		}
	}

}
