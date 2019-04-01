// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PubFun.java

package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.sug.lis.pubfun.GlobalInput;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.*;
import java.util.*;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CErrors, StrTool, JdbcUrl, ExeSQL, 
//			SSRS, Reflections, SchemaSet, Schema

public class PubFun
{

	private static final int MAX_YEAR = 9999;
	private static final int MIN_YEAR = 1800;
	private static final int MAX_MONTH = 12;
	private static final int MIN_MONTH = 1;
	private static final int MAX_DAY = 31;
	private static final int MIN_DAY = 1;
	private static final String DATE_LIST = "0123456789-";

	public PubFun()
	{
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

	public static JdbcUrl getDefaultUrl()
	{
		JdbcUrl tUrl = new JdbcUrl();
		return tUrl;
	}

	public static String RCh(String sourString, String cChar, int cLen)
	{
		int tLen = sourString.length();
		StringBuffer tReturn = new StringBuffer();
		if (tLen >= cLen)
			return sourString;
		int iMax = cLen - tLen;
		tReturn.append(sourString.trim());
		for (int i = 0; i < iMax; i++)
			tReturn.append(cChar);

		return tReturn.toString();
	}

	public static String LCh(String sourString, String cChar, int cLen)
	{
		int tLen = sourString.length();
		StringBuffer tReturn = new StringBuffer();
		if (tLen >= cLen)
			return sourString;
		int iMax = cLen - tLen;
		for (int i = 0; i < iMax; i++)
			tReturn.append(cChar);

		tReturn.append(sourString.trim());
		return tReturn.toString();
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
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		df.setTimeZone(timeZone);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	public static String getCurrentTime()
	{
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
		String pattern = "HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		df.setTimeZone(timeZone);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	public static String getOldDate(int month)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
		now.add(2, -month);
		String newdate = formatter.format(now.getTime());
		return newdate;
	}

	public static String getOldYear(int year)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
		now.add(6, -(365 * year));
		String newdate = formatter.format(now.getTime());
		return newdate;
	}

	public static String getOldMonth(int year, int month, int day, int mark)
	{
		GregorianCalendar worldTour = new GregorianCalendar(year, month, day);
		worldTour.add(2, -(mark + 1));
		Date d = worldTour.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String s = df.format(d);
		return s;
	}

	public static boolean canIDo(GlobalInput cGlobalInput, String RunScript, String pagesign)
	{
		String Operator = cGlobalInput.Operator;
		String sqlStr = "select count(*) from LDMenu ";
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("where RunScript like '%").append(RunScript).append("%' ").toString();
		if (pagesign.equals("page"))
			sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("and parentnodecode in ( select distinct NodeCode from LDMenuGrpToMenu ").toString();
		if (pagesign.equals("menu"))
			sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("and NodeCode in ( select distinct NodeCode from LDMenuGrpToMenu ").toString();
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("where MenuGrpCode in ( select distinct MenuGrpCode from LDMenuGrp ").toString();
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("where MenuGrpCode in (select distinct MenuGrpCode from LDUserToMenuGrp where UserCode = '").toString();
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append(Operator).toString();
		sqlStr = (new StringBuilder(String.valueOf(sqlStr))).append("') ) ) ").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sqlStr);
		if (tSSRS != null)
		{
			String tt[] = tSSRS.getRowData(1);
			if (tt[0].equals("0"))
				return false;
		}
		return true;
	}

	public static String getNoLimit(String comCode)
	{
		comCode = comCode.trim();
		int tLen = comCode.length();
		if (tLen > 6)
			comCode = comCode.substring(0, 6);
		if (tLen < 6)
			comCode = RCh(comCode, "0", 6);
		StringBuffer tString = new StringBuffer();
		tString.append(comCode);
		tString.append(getCurrentDate().substring(0, 4));
		return tString.toString();
	}

	public static String getPiccNoLimit(String comCode)
	{
		comCode = comCode.trim();
		int tLen = comCode.length();
		if (tLen == 8)
			comCode = comCode.substring(2, 6);
		if (tLen == 4)
			comCode = comCode.substring(2, 4);
		StringBuffer tString = new StringBuffer();
		tString.append(comCode);
		if (tLen == 4)
			tString.append("00");
		tString.append(getCurrentDate().substring(2, 4));
		tString.append(getCurrentDate().substring(5, 7));
		tString.append(getCurrentDate().substring(8, 10));
		return tString.toString();
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
			ChnMoney = "��Ԫ��";
			return ChnMoney;
		}
		if (money < 0.0D)
		{
			s0 = "��";
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
		String s1 = getChnM(sFormatStr.substring(0, 4), "��");
		String s2 = getChnM(sFormatStr.substring(4, 8), "��");
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
		ChnMoney = (new StringBuilder(String.valueOf(s0))).append(s1).append(s2).append(s3).append("Ԫ").append(s4).toString();
		if (ChnMoney.substring(0, 1).equals("0"))
			ChnMoney = ChnMoney.substring(1, ChnMoney.length());
		for (int i = 0; i < ChnMoney.length(); i++)
			if (ChnMoney.substring(i, i + 1).equals("0"))
				ChnMoney = (new StringBuilder(String.valueOf(ChnMoney.substring(0, i)))).append("��").append(ChnMoney.substring(i + 1, ChnMoney.length())).toString();

		if (sDot.substring(1, 2).equals("0"))
			ChnMoney = (new StringBuilder(String.valueOf(ChnMoney))).append("��").toString();
		return ChnMoney;
	}

	private static String getDotM(String sIn)
	{
		String sMoney = "";
		if (!sIn.substring(0, 1).equals("0"))
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(sIn.substring(0, 1))).append("��").toString();
		else
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
		if (!sIn.substring(1, 2).equals("0"))
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(sIn.substring(1, 2))).append("��").toString();
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
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(strUnit.substring(0, 1))).append("Ǫ").toString();
		} else
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
			flag = true;
		}
		if (!strUnit.substring(1, 2).equals("0"))
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(strUnit.substring(1, 2))).append("��").toString();
			flag = false;
		} else
		if (!flag)
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append("0").toString();
			flag = true;
		}
		if (!strUnit.substring(2, 3).equals("0"))
		{
			sMoney = (new StringBuilder(String.valueOf(sMoney))).append(getNum(strUnit.substring(2, 3))).append("ʰ").toString();
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
		StringBuffer sOut = new StringBuffer();
		for (int k = 1; k <= 12 - n; k++)
			sOut.append("0");

		sOut.append(sIn);
		return sOut.toString();
	}

	private static String getNum(String value)
	{
		String sNum = "";
		Integer I = new Integer(value);
		int iValue = I.intValue();
		switch (iValue)
		{
		case 0: // '\0'
			sNum = "��";
			break;

		case 1: // '\001'
			sNum = "Ҽ";
			break;

		case 2: // '\002'
			sNum = "��";
			break;

		case 3: // '\003'
			sNum = "��";
			break;

		case 4: // '\004'
			sNum = "��";
			break;

		case 5: // '\005'
			sNum = "��";
			break;

		case 6: // '\006'
			sNum = "½";
			break;

		case 7: // '\007'
			sNum = "��";
			break;

		case 8: // '\b'
			sNum = "��";
			break;

		case 9: // '\t'
			sNum = "��";
			break;
		}
		return sNum;
	}

	public static String getInt(String Value)
	{
		if (Value == null)
			return null;
		if (Value.equals("null"))
			return "";
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
			System.out.println("�ָ���ȴ��ڵ������ַ��ȣ����ܽ��в�֣�");
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

	public static String chgPrecision(double value, String precision)
	{
		String str2 = (new DecimalFormat(precision)).format(Double.valueOf(String.valueOf(value)));
		return str2;
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
		StringBuffer tSBql = null;
		for (int i = 0; i < tables.length; i++)
		{
			tSBql = new StringBuffer(128);
			tSBql.append("update ");
			tSBql.append(tables[i]);
			tSBql.append(" set ");
			tSBql.append(condition);
			tSBql.append(" where ");
			tSBql.append(wherepart);
			sqlVec.add(tSBql.toString());
		}

		return sqlVec;
	}

	public static String DeleteZero(String sIn)
	{
		int n = sIn.length();
		String sOut;
		for (sOut = sIn; sOut.substring(0, 1).equals("0") && n > 1; n = sOut.length())
			sOut = sOut.substring(1, n);

		if (sOut.equals("0"))
			return "";
		else
			return sOut;
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
		StringBuffer tReturn = new StringBuffer();
		if (tIdNo.length() != 15 && tIdNo.length() != 18)
			return "";
		if (tIdNo.length() == 18)
		{
			birthday = tIdNo.substring(6, 14);
			tReturn.append(birthday.substring(0, 4));
			tReturn.append("-");
			tReturn.append(birthday.substring(4, 6));
			tReturn.append("-");
			tReturn.append(birthday.substring(6));
		}
		if (tIdNo.length() == 15)
		{
			birthday = tIdNo.substring(6, 12);
			tReturn.append("19");
			tReturn.append(birthday.substring(0, 2));
			tReturn.append("-");
			tReturn.append(birthday.substring(2, 4));
			tReturn.append("-");
			tReturn.append(birthday.substring(4));
		}
		return tReturn.toString();
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

	public static String getTomorrow()
	{
		String tFormatDate = "yyyy-MM-dd";
		SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
		Calendar tCalendar = Calendar.getInstance();
		int tDay = tCalendar.get(5);
		tDay++;
		tCalendar.set(5, tDay);
		return tSimpleDateFormat.format(tCalendar.getTime());
	}

	public static String getLastDate(String cDate, int cInterval, String cUnit)
	{
		String tFormatDate = "yyyy-MM-dd";
		SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
		FDate tFDate = new FDate();
		Date CurDate = tFDate.getDate(cDate);
		GregorianCalendar tCalendar = new GregorianCalendar();
		tCalendar.setTime(CurDate);
		if (cUnit.equals("D"))
		{
			int tDay = tCalendar.get(5);
			tCalendar.set(5, tDay + cInterval);
			return tSimpleDateFormat.format(tCalendar.getTime());
		}
		if (cUnit.equals("M"))
		{
			int tMonth = tCalendar.get(2);
			tCalendar.set(2, tMonth + cInterval);
			return tSimpleDateFormat.format(tCalendar.getTime());
		}
		if (cUnit.equals("Y"))
		{
			int tYear = tCalendar.get(1);
			tCalendar.set(1, tYear + cInterval);
			return tSimpleDateFormat.format(tCalendar.getTime());
		} else
		{
			return "";
		}
	}

	public static String[] getPrevMonth(String cDate)
	{
		String tFormatDate = "yyyy-MM-dd";
		SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
		FDate tFDate = new FDate();
		Date CurDate = tFDate.getDate(cDate);
		GregorianCalendar tCalendar = new GregorianCalendar();
		tCalendar.setTime(CurDate);
		int tMonth = tCalendar.get(2);
		tCalendar.set(2, tMonth - 1);
		return calFLDate(tSimpleDateFormat.format(tCalendar.getTime()));
	}

	public static String getYesterday()
	{
		String tFormatDate = "yyyy-MM-dd";
		SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
		Calendar tCalendar = Calendar.getInstance();
		int tDay = tCalendar.get(5);
		tDay--;
		tCalendar.set(5, tDay);
		return tSimpleDateFormat.format(tCalendar.getTime());
	}

	public static boolean validateNumber(String str)
	{
		String tmp = null;
		for (int i = 0; i < str.length(); i++)
		{
			tmp = str.substring(i, i + 1);
			if ("0123456789-".indexOf(tmp) == -1)
				return false;
		}

		return true;
	}

	public static boolean validateDate(String strDate)
	{
		int yyyy = 0;
		int mm = 0;
		int dd = 0;
		if (!validateNumber(strDate))
			return false;
		if (strDate.indexOf("-") >= 0)
		{
			StringTokenizer token = new StringTokenizer(strDate, "-");
			for (int i = 0; token.hasMoreElements(); i++)
			{
				if (i == 0)
					yyyy = Integer.parseInt(token.nextToken());
				if (i == 1)
					mm = Integer.parseInt(token.nextToken());
				if (i == 2)
					dd = Integer.parseInt(token.nextToken());
			}

		} else
		{
			if (strDate.length() != 8)
				return false;
			yyyy = Integer.parseInt(strDate.substring(0, 4));
			mm = Integer.parseInt(strDate.substring(4, 6));
			dd = Integer.parseInt(strDate.substring(6, 8));
		}
		if (yyyy > 9999 || yyyy < 1800)
			return false;
		if (mm > 12 || mm < 1)
			return false;
		if (dd > 31 || dd < 1)
			return false;
		if ((mm == 4 || mm == 6 || mm == 9 || mm == 11) && dd == 31)
			return false;
		if (mm == 2)
		{
			boolean leap = yyyy % 4 == 0 && (yyyy % 100 != 0 || yyyy % 400 == 0);
			if (dd > 29 || dd == 29 && !leap)
				return false;
		}
		FDate myFDate = new FDate();
		Date validateDate = myFDate.getDate(strDate);
		Date now = new Date();
		return calInterval(validateDate, now, "D") >= 0;
	}

	public static final String getNewId(String id, String type)
	{
		String newid = "";
		if (type.equals("0"))
		{
			int W[] = {
				7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 
				7, 9, 10, 5, 8, 4, 2, 1
			};
			String A[] = {
				"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", 
				"2"
			};
			int s = 0;
			newid = id;
			newid = (new StringBuilder(String.valueOf(newid.substring(0, 6)))).append("19").append(newid.substring(6, id.length())).toString();
			for (int i = 0; i < newid.length(); i++)
			{
				int j = Integer.parseInt(newid.substring(i, i + 1)) * W[i];
				s += j;
			}

			s %= 11;
			newid = (new StringBuilder(String.valueOf(newid))).append(A[s]).toString();
		}
		if (type.equals("1"))
			newid = (new StringBuilder(String.valueOf(id.substring(0, 6)))).append(id.substring(8, 17)).toString();
		return newid;
	}

	public static boolean CompareId(String id1, String id2)
	{
		if (id1.length() == id2.length())
		{
			if (id1.equals(id2))
				return true;
		} else
		if (id1.length() == 15 && id2.length() == 18)
		{
			if (getNewId(id1, "0").equals(id2))
				return true;
		} else
		if (id1.length() == 18 && id2.length() == 15 && getNewId(id1, "1").equals(id2))
			return true;
		return false;
	}

	public static String format(double dValue)
	{
		return (new DecimalFormat("0.00")).format(dValue);
	}

	public static String FormatDate(String cDate)
	{
		if (cDate == null || "".equals(cDate))
		{
			return "";
		} else
		{
			cDate = cDate.replaceFirst("-", "��");
			cDate = cDate.replaceFirst("-", "��");
			StringBuffer tSBql = new StringBuffer();
			tSBql.append(cDate);
			tSBql.append("��");
			return tSBql.toString();
		}
	}

	public static String formatDateEx(String cDate)
	{
		if (cDate == null || "".equals(cDate))
			return "";
		String year = cDate.substring(0, cDate.indexOf("-"));
		String month = cDate.substring(cDate.indexOf("-") + 1, cDate.lastIndexOf("-"));
		String day = cDate.substring(cDate.lastIndexOf("-") + 1);
		if (month.startsWith("0"))
			month = month.substring(1);
		if (day.startsWith("0"))
			day = day.substring(1);
		cDate = (new StringBuilder(String.valueOf(year))).append("��").append(month).append("��").append(day).append("��").toString();
		return cDate;
	}

	public static String calOFDate(String baseDate, int interval, String unit, String compareDate)
	{
		FDate tFDate;
		Date bDate;
		Date cDate;
		tFDate = new FDate();
		bDate = tFDate.getDate(baseDate);
		cDate = tFDate.getDate(compareDate);
		return tFDate.getString(calOFDate(bDate, interval, unit, cDate));
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public static Date calOFDate(Date baseDate, int interval, String unit, Date compareDate)
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
				if (mMonths < cCalendar.get(2))
					cCalendar.set(mYears, mMonths + 1, 0);
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
				if (mMonths < cCalendar.get(2))
					cCalendar.set(mYears, mMonths + 1, 0);
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

	public static String GetDateTime(String cDate, String cTime)
	{
		String tDate[] = cDate.split("-");
		String tTime[] = cTime.split(":");
		StringBuffer tSBql = new StringBuffer();
		tSBql.append(tDate[0]);
		tSBql.append(tDate[1]);
		tSBql.append(tDate[2]);
		tSBql.append(tTime[0]);
		tSBql.append(tTime[1]);
		tSBql.append(tTime[2]);
		return tSBql.toString();
	}

	public static SSRS Add_SSRS(SSRS firstSSRS, int firstIndex, SSRS secondSSRS, int secondIndex)
	{
		SSRS rSSRS = new SSRS(1);
		int length = Math.min(firstSSRS.getMaxRow(), secondSSRS.getMaxRow());
		try
		{
			for (int r = 1; r <= length; r++)
			{
				double d1;
				if (firstSSRS.GetText(r, firstIndex).equals(""))
					d1 = 0.0D;
				else
					d1 = Double.parseDouble(firstSSRS.GetText(r, firstIndex));
				double d2;
				if (secondSSRS.GetText(r, secondIndex).equals(""))
					d2 = 0.0D;
				else
					d2 = Double.parseDouble(secondSSRS.GetText(r, secondIndex));
				double temp = d1 + d2;
				rSSRS.SetText(String.valueOf(temp));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rSSRS;
	}

	public static SSRS Subtract_SSRS(SSRS firstSSRS, int firstIndex, SSRS secondSSRS, int secondIndex)
	{
		SSRS rSSRS = new SSRS(1);
		int length = Math.min(firstSSRS.getMaxRow(), secondSSRS.getMaxRow());
		try
		{
			for (int r = 1; r <= length; r++)
			{
				double d1;
				if (firstSSRS.GetText(r, firstIndex).equals(""))
					d1 = 0.0D;
				else
					d1 = Double.parseDouble(firstSSRS.GetText(r, firstIndex));
				double d2;
				if (secondSSRS.GetText(r, secondIndex).equals(""))
					d2 = 0.0D;
				else
					d2 = Double.parseDouble(secondSSRS.GetText(r, secondIndex));
				double temp = d1 - d2;
				rSSRS.SetText(String.valueOf(temp));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rSSRS;
	}

	public static SSRS Mul_SSRS(SSRS firstSSRS, int firstIndex, SSRS secondSSRS, int secondIndex)
	{
		SSRS rSSRS = new SSRS(1);
		int length = Math.min(firstSSRS.getMaxRow(), secondSSRS.getMaxRow());
		try
		{
			for (int r = 1; r <= length; r++)
			{
				double d1;
				if (firstSSRS.GetText(r, firstIndex).equals(""))
					d1 = 0.0D;
				else
					d1 = Double.parseDouble(firstSSRS.GetText(r, firstIndex));
				double d2;
				if (secondSSRS.GetText(r, secondIndex).equals(""))
					d2 = 0.0D;
				else
					d2 = Double.parseDouble(secondSSRS.GetText(r, secondIndex));
				double temp = d1 * d2;
				rSSRS.SetText(String.valueOf(temp));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rSSRS;
	}

	public static SSRS Div_SSRS(SSRS firstSSRS, int firstIndex, SSRS secondSSRS, int secondIndex)
	{
		SSRS rSSRS = new SSRS(1);
		int length = Math.min(firstSSRS.getMaxRow(), secondSSRS.getMaxRow());
		try
		{
			for (int r = 1; r <= length; r++)
			{
				double d1;
				if (firstSSRS.GetText(r, firstIndex).equals(""))
					d1 = 0.0D;
				else
					d1 = Double.parseDouble(firstSSRS.GetText(r, firstIndex));
				double d2;
				if (secondSSRS.GetText(r, secondIndex).equals("") || secondSSRS.GetText(r, secondIndex).equals("1"))
					d2 = 1.0D;
				else
					d2 = Double.parseDouble(secondSSRS.GetText(r, secondIndex));
				double temp = d1 / d2;
				rSSRS.SetText(String.valueOf(temp));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rSSRS;
	}

	public static SSRS changValue_SSRS(SSRS source, int row, int col, String value)
	{
		if (source == null || row > source.getMaxRow() || col > source.getMaxCol())
			return null;
		SSRS rSSRS = new SSRS();
		rSSRS.setMaxCol(source.getMaxCol());
		rSSRS.setMaxRow(source.getMaxRow());
		for (int r = 1; r <= source.getMaxRow(); r++)
		{
			for (int c = 1; c <= source.getMaxCol(); c++)
				if (r == row && c == col)
					rSSRS.SetText(value);
				else
					rSSRS.SetText(source.GetText(r, c));

		}

		return rSSRS;
	}

	public static int getDays(String strdate)
	{
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		try
		{
			date = sdf.parse(strdate);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		calendar.setTime(date);
		int day = calendar.getActualMaximum(5);
		return day;
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

	public HashMap getLaagent(String AgentCode)
	{
		ExeSQL query = new ExeSQL();
		String agentsql = (new StringBuilder("select Name,Mobile,ManageCom from LAAgent where agentcode = '")).append(AgentCode).append("'").toString();
		SSRS agentSSRS = query.execSQL(agentsql);
		HashMap agentHashMap = new HashMap();
		if (agentSSRS.MaxRow > 0)
		{
			String AgentName = agentSSRS.GetText(1, 1);
			String AgentMobile = agentSSRS.GetText(1, 2);
			String ManageCom = agentSSRS.GetText(1, 3);
			agentHashMap.put("AgentName", AgentName);
			agentHashMap.put("AgentMobile", AgentMobile);
			agentHashMap.put("ManageCom", ManageCom);
			String Addresssql = (new StringBuilder("select address,Phone from MCom where Comcode=")).append(ManageCom).toString();
			SSRS AddressSSRS = query.execSQL(Addresssql);
			String ComAddress = "";
			String AgentPhone = "";
			if (AddressSSRS.MaxRow > 0)
			{
				ComAddress = AddressSSRS.GetText(1, 1);
				AgentPhone = AddressSSRS.GetText(1, 2);
			}
			if (ComAddress.length() > 15)
				ComAddress = (new StringBuilder(String.valueOf(ComAddress.substring(0, 15)))).append("<br>            ").append(ComAddress.substring(15, ComAddress.length())).toString();
			agentHashMap.put("AgentComAddress", ComAddress);
			agentHashMap.put("AgentPhone", AgentPhone);
		}
		return agentHashMap;
	}

	public static void cleanUpdatePackage(String rootdir[])
	{
		SimpleDateFormat df;
		int j;
		StringBuffer sb = new StringBuffer();
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		j = 0;
		  goto _L1
_L3:
		File root;
		root = new File(rootdir[j]);
		if (!root.exists())
			return;
		boolean isdir = root.isDirectory();
		if (!isdir)
			return;
		try
		{
			String allfiles[] = root.list();
			if (allfiles != null && allfiles.length >= 0)
			{
				for (int i = 0; i < allfiles.length; i++)
				{
					File file = new File((new StringBuilder(String.valueOf(rootdir[j]))).append("/").append(allfiles[i]).toString());
					String modifyTime = df.format(new Date(file.lastModified()));
					String nowTime = df.format(new Date());
					if (getQuot(nowTime, modifyTime) >= 24L)
						file.delete();
				}

			}
			root = null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		j++;
_L1:
		if (j < rootdir.length) goto _L3; else goto _L2
_L2:
	}

	public static long getQuot(String time1, String time2)
	{
		long quot = 0L;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000L / 60L / 60L;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return quot;
	}

	public static void main(String args1[])
	{
	}
}
