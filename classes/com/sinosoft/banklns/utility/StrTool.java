// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   StrTool.java

package com.sinosoft.banklns.utility;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Vector;

// Referenced classes of package com.sinosoft.banklns.utility:
//			ConfigInfo, SSRS

public class StrTool
{

	public static final String EQUAL = "=";
	public static final String GREATER = ">";
	public static final String GREATGE_EQUAL = ">=";
	public static final String LESS = "<";
	public static final String LESS_EQUAL = "<=";
	public static final String NOT_EQUAL = "!=";
	public static final String CONTAIN = "*";
	public static final String BETWEEN = ":";
	public static final String DATEDELIMITER = "/";
	public static final String VISADATEDELIMITER = "-";
	public static final String TIMEDELIMITER = ":";
	public static final String ADDRESSDELIMITER = "$$";
	public static final String DELIMITER = "^";
	public static final String PACKAGESPILTER = "|";
	public static final String OR = "~!";
	public static final int LENGTH_OR = 2;
	public static final String BETWEEN_AND = ":";
	public static final String BLANK = "?";
	public static final String DIRECTMODE = "Direct Mode!^^";

	public StrTool()
	{
	}

	public static String decodeStr(String strMain, String strDelimiters, int intSerialNo)
	{
		int intIndex = 0;
		int intCount = 0;
		String strReturn = "";
		if (strMain.length() < strDelimiters.length())
			return "";
		intIndex = strMain.indexOf(strDelimiters);
		if (intIndex == -1)
			return "";
		for (; intIndex != -1; intIndex = strMain.indexOf(strDelimiters))
		{
			strReturn = strMain.substring(0, intIndex);
			if (++intCount == intSerialNo)
				if (intIndex == 0)
					return "";
				else
					return strReturn.trim();
			strMain = strMain.substring(intIndex + 1);
		}

		return "";
	}

	public static int getPos(String strMain, String strSub, int intTimes)
	{
		int intCounter = 0;
		int intPosition = 0;
		int intLength = strSub.length();
		if (intTimes <= 0)
			return -1;
		while (intCounter < intTimes) 
		{
			intPosition = strMain.indexOf(strSub, intPosition);
			if (intPosition == -1)
				return -1;
			intCounter++;
			intPosition += intLength;
		}
		return intPosition - intLength;
	}

	public static int getPos(String strMain, String strSub, int intStartIndex, int intTimes)
	{
		if (strMain.length() - 1 < intStartIndex)
			return -1;
		int intPosition = getPos(strMain.substring(intStartIndex), strSub, intTimes);
		if (intPosition != -1)
			intPosition += intStartIndex;
		return intPosition;
	}

	public static String makeCondition(String strMessage)
	{
		String strSegment = "";
		String strField = "";
		String strOperator = "";
		String strValue = "";
		String strRemain = "";
		String strReturn = "1=1";
		int intPosition = 0;
		if (strMessage.indexOf("^") < 0)
			return strMessage;
		strRemain = strMessage;
		if (!strRemain.endsWith("Direct Mode!^^^"))
		{
			do
			{
				intPosition = getPos(strRemain, "^", 3);
				if (intPosition < 0)
					return strReturn;
				strSegment = strRemain.substring(0, intPosition + 1).trim();
				strRemain = strRemain.substring(intPosition + 1);
				if (strSegment.length() < 1)
					break;
				strField = decodeStr(strSegment, "^", 1);
				strOperator = decodeStr(strSegment, "^", 2);
				strValue = decodeStr(strSegment, "^", 3);
				if (strValue.equals("?"))
					strValue = " ";
				strReturn = (new StringBuilder(String.valueOf(strReturn))).append(" AND ").append("(").toString();
				if (strOperator.equals(":"))
				{
					intPosition = strValue.indexOf(":");
					strReturn = (new StringBuilder(String.valueOf(strReturn))).append(strField).append(" BETWEEN '").append(strValue.substring(0, intPosition).trim()).append("'").append(" AND  '").append(strValue.substring(intPosition + 1).trim()).append("' ").toString();
				} else
				if (strOperator.equals("*"))
				{
					strReturn = (new StringBuilder(String.valueOf(strReturn))).append(strField).append(" matches '").append(strValue).append("*' ").toString();
				} else
				{
					strSegment = "";
					do
					{
						intPosition = strValue.indexOf("~!");
						if (intPosition < 0)
						{
							if (strSegment.equals(""))
								strReturn = (new StringBuilder(String.valueOf(strReturn))).append(strField).append(" ").append(strOperator).append(" '").append(strValue).append("' ").toString();
							else
								strReturn = (new StringBuilder(String.valueOf(strReturn))).append(strSegment).append(" OR ").append(strField).append(" ").append(strOperator).append(" '").append(strValue.trim()).append("' ").toString();
							break;
						}
						if (!strSegment.equals(""))
							strSegment = (new StringBuilder(String.valueOf(strSegment))).append(" OR ").toString();
						strSegment = (new StringBuilder(String.valueOf(strSegment))).append(strField).append(" ").append(strOperator).append(" '").append(strValue.substring(0, intPosition).trim()).append("' ").toString();
						strValue = strValue.substring(intPosition + 2);
					} while (true);
				}
				strReturn = (new StringBuilder(String.valueOf(strReturn))).append(") ").toString();
			} while (true);
		} else
		{
			strRemain = strRemain.substring(0, strRemain.length() - "Direct Mode!^^".length() - "^".length());
			if (strRemain.trim().equals(""))
				strRemain = "1=1";
			strReturn = strRemain;
		}
		return strReturn;
	}

	public static String unicodeToGBK(String strOriginal)
	{
		if (strOriginal == null)
			break MISSING_BLOCK_LABEL_42;
		if (!isGBKString(strOriginal))
			return new String(strOriginal.getBytes("ISO8859_1"), "GBK");
		return strOriginal;
		Exception exception;
		exception;
		System.out.println(exception.getMessage());
		return strOriginal;
		return "";
	}

	public static String GBKToUnicode(String strOriginal)
	{
		return unicodeToGBK(strOriginal);
		Exception exception;
		exception;
		return strOriginal;
	}

	public static String GBKToUnicode(String strOriginal, boolean realConvert)
	{
		if (!realConvert)
			return unicodeToGBK(strOriginal);
		if (strOriginal == null)
			break MISSING_BLOCK_LABEL_41;
		if (isGBKString(strOriginal))
			return new String(strOriginal.getBytes("GBK"), "ISO8859_1");
		return strOriginal;
		Exception exception;
		exception;
		return strOriginal;
		return null;
	}

	public static boolean isGBKString(String tStr)
	{
		int tlength = tStr.length();
		Integer t = new Integer(0);
		int t1 = 0;
		for (int i = 0; i < tlength; i++)
		{
			t1 = Integer.parseInt(Integer.toOctalString(tStr.charAt(i)));
			if (t1 > 511)
				return true;
		}

		return false;
	}

	public static boolean isUnicodeString(String tStr)
	{
		int tlength = tStr.length();
		Integer t = new Integer(0);
		int t1 = 0;
		for (int i = 0; i < tlength; i++)
		{
			t1 = Integer.parseInt(Integer.toOctalString(tStr.charAt(i)));
			if (t1 > 511)
				return false;
		}

		return true;
	}

	public static Vector stringToVector(String strMessage, int intCount, Class cl)
		throws Exception
	{
		int intFieldNum = 0;
		Object object = null;
		Vector vec = new Vector();
		int intPosition = 0;
		Class parameters[] = {
			java/lang/String
		};
		Method method = null;
		Field field = null;
		String therecord[] = {
			new String()
		};
		try
		{
			object = cl.newInstance();
			method = cl.getMethod("decode", parameters);
			field = cl.getField("FIELDNUM");
			intFieldNum = field.getInt(object);
			for (int i = 0; i < intCount; i++)
			{
				object = cl.newInstance();
				intPosition = getPos(strMessage, "|", intFieldNum);
				if (intPosition == strMessage.length() - 1)
				{
					therecord[0] = strMessage;
					method.invoke(object, therecord);
					vec.addElement(object);
					break;
				}
				therecord[0] = strMessage.substring(0, intPosition + 1);
				method.invoke(object, therecord);
				vec.addElement(object);
				strMessage = strMessage.substring(intPosition + 1);
			}

		}
		catch (Exception exception)
		{
			throw exception;
		}
		return vec;
	}

	public static String replace(String strMain, String strFind, String strReplaceWith)
	{
		StringBuffer sb = new StringBuffer("");
		int startIndex = 0;
		int endIndex = 0;
		if (strMain == null || strMain.equals(""))
			return "";
		while ((endIndex = strMain.indexOf(strFind, startIndex)) > -1) 
		{
			sb.append(strMain.substring(startIndex, endIndex));
			sb.append(strReplaceWith);
			startIndex = endIndex + strFind.length();
		}
		sb.append(strMain.substring(startIndex, strMain.length()));
		return sb.toString();
	}

	public static String getDate(String strYear, String strMonth, String strDay)
	{
		String strReturn = "";
		int intYear = 0;
		int intMonth = 0;
		int intDay = 0;
		if (strYear != null && strMonth != null && strDay != null && strYear.trim().length() > 0 && strMonth.trim().length() > 0 && strDay.trim().length() > 0)
		{
			try
			{
				intYear = (new Integer(strYear)).intValue();
				intMonth = (new Integer(strMonth)).intValue();
				intDay = (new Integer(strDay)).intValue();
			}
			catch (Exception exception)
			{
				return strReturn;
			}
			if (intYear <= 0 || intMonth <= 0 || intMonth > 12 || intDay <= 0 || intDay > 31)
			{
				strReturn = "";
			} else
			{
				strReturn = (new StringBuilder()).append(intYear).toString();
				if (intMonth < 10)
					strReturn = (new StringBuilder(String.valueOf(strReturn))).append("/0").append(intMonth).toString();
				else
					strReturn = (new StringBuilder(String.valueOf(strReturn))).append("/").append(intMonth).toString();
				if (intDay < 10)
					strReturn = (new StringBuilder(String.valueOf(strReturn))).append("/0").append(intDay).toString();
				else
					strReturn = (new StringBuilder(String.valueOf(strReturn))).append("/").append(intDay).toString();
			}
		}
		return strReturn;
	}

	public static String getDate()
	{
		String strReturn = "";
		int intYear = Calendar.getInstance().get(1);
		int intMonth = Calendar.getInstance().get(2) + 1;
		int intDate = Calendar.getInstance().get(5);
		strReturn = (new StringBuilder()).append(intYear).toString();
		if (intMonth < 10)
			strReturn = (new StringBuilder(String.valueOf(strReturn))).append("/0").append(intMonth).toString();
		else
			strReturn = (new StringBuilder(String.valueOf(strReturn))).append("/").append(intMonth).toString();
		if (intDate < 10)
			strReturn = (new StringBuilder(String.valueOf(strReturn))).append("/0").append(intDate).toString();
		else
			strReturn = (new StringBuilder(String.valueOf(strReturn))).append("/").append(intDate).toString();
		return strReturn;
	}

	public static String getDate(String strYear, String strMonth)
	{
		String strReturn = "";
		int intYear = 0;
		int intMonth = 0;
		if (strYear != null && strMonth != null && strYear.trim().length() > 0 && strMonth.trim().length() > 0)
		{
			intYear = (new Integer(strYear)).intValue();
			intMonth = (new Integer(strMonth)).intValue();
			if (intYear <= 0 || intMonth <= 0 || intMonth > 12)
				strReturn = "";
			else
				strReturn = (new StringBuilder()).append(intYear).append("/").append(intMonth).toString();
		}
		return strReturn;
	}

	public static String getYear(String strDate)
	{
		int intPosition = 0;
		String strReturn = "";
		int intYear = 0;
		if (strDate != null && strDate.trim().length() > 0)
		{
			intPosition = getPos(strDate, "/", 1);
			if (intPosition > 0)
			{
				strReturn = strDate.substring(0, intPosition);
				intYear = (new Integer(strReturn)).intValue();
				if (intYear <= 0)
					strReturn = "";
				else
					strReturn = (new StringBuilder()).append(intYear).toString();
				if (intYear < 10 && !strReturn.equals(""))
					strReturn = (new StringBuilder("0")).append(strReturn).toString();
			}
		}
		return strReturn;
	}

	public static String getYear()
	{
		String strReturn = "";
		int intYear = Calendar.getInstance().get(1);
		strReturn = (new StringBuilder()).append(intYear).toString();
		return strReturn;
	}

	public static String getMonth(String strDate)
	{
		int intPosition1 = 0;
		int intPosition2 = 0;
		String strReturn = "";
		int intMonth = 0;
		if (strDate != null && strDate.trim().length() > 0)
		{
			intPosition1 = getPos(strDate, "/", 1);
			intPosition2 = getPos(strDate, "/", 2);
			if (intPosition1 > 0 && intPosition2 > intPosition1)
			{
				strReturn = strDate.substring(intPosition1 + 1, intPosition2);
				intMonth = (new Integer(strReturn)).intValue();
				if (intMonth <= 0 || intMonth > 12)
					strReturn = "";
				else
					strReturn = (new StringBuilder()).append(intMonth).toString();
				if (intMonth < 10 && !strReturn.equals(""))
					strReturn = (new StringBuilder("0")).append(strReturn).toString();
			}
		}
		return strReturn;
	}

	public static String getMonth()
	{
		String strReturn = "";
		int intMonth = Calendar.getInstance().get(2) + 1;
		if (intMonth < 10)
			strReturn = (new StringBuilder("0")).append(intMonth).toString();
		else
			strReturn = (new StringBuilder()).append(intMonth).toString();
		return strReturn;
	}

	public static String getDay(String strDate)
	{
		int intPosition = 0;
		String strReturn = "";
		int intDay = 0;
		if (strDate != null && strDate.trim().length() > 0)
		{
			intPosition = getPos(strDate, "/", 2);
			if (intPosition > 0)
			{
				strReturn = strDate.substring(intPosition + 1);
				intDay = (new Integer(strReturn)).intValue();
				if (intDay <= 0 || intDay > 31)
					strReturn = "";
				else
					strReturn = (new StringBuilder()).append(intDay).toString();
				if (intDay < 10 && !strReturn.equals(""))
					strReturn = (new StringBuilder("0")).append(strReturn).toString();
			}
		}
		return strReturn;
	}

	public static String getDay()
	{
		String strReturn = "";
		int intDate = Calendar.getInstance().get(5);
		if (intDate < 10)
			strReturn = (new StringBuilder("0")).append(intDate).toString();
		else
			strReturn = (new StringBuilder()).append(intDate).toString();
		return strReturn;
	}

	public static String getTime()
	{
		return (new StringBuilder(String.valueOf(getHour()))).append(":").append(getMinute()).append(":").append(getSecond()).toString();
	}

	public static String getHour()
	{
		String strReturn = "";
		int intHour = Calendar.getInstance().get(10) + 12 * Calendar.getInstance().get(9);
		if (intHour < 10)
			strReturn = (new StringBuilder("0")).append(intHour).toString();
		else
			strReturn = (new StringBuilder()).append(intHour).toString();
		return strReturn;
	}

	public static String getMinute()
	{
		String strReturn = "";
		int intMinute = Calendar.getInstance().get(12);
		if (intMinute < 10)
			strReturn = (new StringBuilder("0")).append(intMinute).toString();
		else
			strReturn = (new StringBuilder()).append(intMinute).toString();
		return strReturn;
	}

	public static String getSecond()
	{
		String strReturn = "";
		int intSecond = Calendar.getInstance().get(13);
		if (intSecond < 10)
			strReturn = (new StringBuilder("0")).append(intSecond).toString();
		else
			strReturn = (new StringBuilder()).append(intSecond).toString();
		return strReturn;
	}

	public static String getVisaYear(String strDate)
	{
		int intPosition = 0;
		String strReturn = "";
		int intYear = 0;
		if (strDate != null && strDate.trim().length() > 0)
		{
			intPosition = getPos(strDate, "-", 1);
			if (intPosition > 0)
			{
				strReturn = strDate.substring(0, intPosition);
				intYear = (new Integer(strReturn)).intValue();
				if (intYear <= 0)
					strReturn = "";
				else
					strReturn = (new StringBuilder()).append(intYear).toString();
				if (intYear < 10 && !strReturn.equals(""))
					strReturn = (new StringBuilder("0")).append(strReturn).toString();
			}
		}
		return strReturn;
	}

	public static String getVisaMonth(String strDate)
	{
		int intPosition1 = 0;
		int intPosition2 = 0;
		String strReturn = "";
		int intMonth = 0;
		if (strDate != null && strDate.trim().length() > 0)
		{
			intPosition1 = getPos(strDate, "-", 1);
			intPosition2 = getPos(strDate, "-", 2);
			if (intPosition1 > 0 && intPosition2 > intPosition1)
			{
				strReturn = strDate.substring(intPosition1 + 1, intPosition2);
				intMonth = (new Integer(strReturn)).intValue();
				if (intMonth <= 0 || intMonth > 12)
					strReturn = "";
				else
					strReturn = (new StringBuilder()).append(intMonth).toString();
				if (intMonth < 10 && !strReturn.equals(""))
					strReturn = (new StringBuilder("0")).append(strReturn).toString();
			}
		}
		return strReturn;
	}

	public static String getVisaDay(String strDate)
	{
		int intPosition = 0;
		String strReturn = "";
		int intDay = 0;
		if (strDate != null && strDate.trim().length() > 0)
		{
			intPosition = getPos(strDate, "-", 2);
			if (intPosition > 0)
			{
				strReturn = strDate.substring(intPosition + 1);
				intDay = (new Integer(strReturn)).intValue();
				if (intDay <= 0 || intDay > 31)
					strReturn = "";
				else
					strReturn = (new StringBuilder()).append(intDay).toString();
				if (intDay < 10 && !strReturn.equals(""))
					strReturn = (new StringBuilder("0")).append(strReturn).toString();
			}
		}
		return strReturn;
	}

	public static String toHTMLFormat(String strInValue)
	{
		String strOutValue = "";
		for (int i = 0; i < strInValue.length(); i++)
		{
			char c = strInValue.charAt(i);
			switch (c)
			{
			case 10: // '\n'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("<BR>").toString();
				break;

			case 11: // '\013'
			case 12: // '\f'
			default:
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append(c).toString();
				break;

			case 13: // '\r'
				break;
			}
		}

		return strOutValue;
	}

	public static String encode(String strInValue)
	{
		String strOutValue = "";
		for (int i = 0; i < strInValue.length(); i++)
		{
			char c = strInValue.charAt(i);
			switch (c)
			{
			case 58: // ':'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("��").toString();
				break;

			case 124: // '|'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("��").toString();
				break;

			case 10: // '\n'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\n").toString();
				break;

			case 13: // '\r'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\r").toString();
				break;

			case 34: // '"'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\\"").toString();
				break;

			case 39: // '\''
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\'").toString();
				break;

			case 8: // '\b'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\b").toString();
				break;

			case 9: // '\t'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\t").toString();
				break;

			case 12: // '\f'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\f").toString();
				break;

			case 92: // '\\'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\\\").toString();
				break;

			case 60: // '<'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\<").toString();
				break;

			case 62: // '>'
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append("\\>").toString();
				break;

			default:
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append(c).toString();
				break;
			}
		}

		return strOutValue;
	}

	public static String encode(String arr[][])
	{
		System.out.println("ʹ��StrTool�µ�encode�������?");
		String strReturn = "";
		int rowcount = arr.length;
		int colcount = arr[0].length;
		int eleCount = rowcount * colcount;
		if (eleCount != 0)
		{
			strReturn = (new StringBuilder("0|")).append(String.valueOf(rowcount)).append("^").toString();
			for (int i = 0; i < rowcount; i++)
			{
				for (int j = 0; j < colcount; j++)
					if (j != colcount - 1)
						strReturn = (new StringBuilder(String.valueOf(strReturn))).append(arr[i][j]).append("|").toString();

				if (i != rowcount - 1)
					strReturn = (new StringBuilder(String.valueOf(strReturn))).append("^").toString();
			}

		}
		return strReturn;
	}

	public static String space(int intLength)
	{
		StringBuffer strReturn = new StringBuffer();
		for (int i = 0; i < intLength; i++)
			strReturn.append(" ");

		return new String(strReturn);
	}

	public static String space(String strValue, int intLength)
	{
		int strLen = strValue.length();
		StringBuffer strReturn = new StringBuffer();
		if (strLen > intLength)
		{
			strReturn.append(strValue.substring(0, intLength));
		} else
		{
			if (strLen == 0)
				strReturn.append(" ");
			else
				strReturn.append(strValue);
			for (int i = strLen; i < intLength; i++)
				strReturn.append(" ");

		}
		return new String(strReturn);
	}

	public static int getLength(String strSource)
	{
		return strSource.getBytes().length;
	}

	public static void copyFile(String fromFile, String toFile)
		throws FileNotFoundException, IOException, Exception
	{
		FileInputStream in = new FileInputStream(fromFile);
		FileOutputStream out = new FileOutputStream(toFile);
		byte b[] = new byte[1024];
		int len;
		while ((len = in.read(b)) != -1) 
			out.write(b, 0, len);
		out.close();
		in.close();
	}

	public static String toUpper(int intValue)
	{
		String strOutValue = "";
		String strTemp[] = {
			"��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��"
		};
		try
		{
			strOutValue = strTemp[intValue];
		}
		catch (Exception exception)
		{
			strOutValue = "";
		}
		return strOutValue;
	}

	public static String getUnit(int intValue)
	{
		String strOutValue = "";
		String strTemp[] = {
			"Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", 
			"ʰ", "", "", ""
		};
		try
		{
			strOutValue = strTemp[intValue];
		}
		catch (Exception exception)
		{
			strOutValue = "";
		}
		return strOutValue;
	}

	public static String toChinese(double dblInValue)
	{
		String strOutValue = "";
		String strValue = (new DecimalFormat("0")).format(dblInValue * 100D);
		String strTemp = "                 ";
		String strThat = "";
		int i = 0;
		int j = 0;
		int k = 0;
		k = strValue.length();
		if (k > 14)
			return "";
		strValue = (new StringBuilder(String.valueOf(strTemp.substring(0, 14 - k)))).append(strValue).toString();
		for (i = 14 - k; i < 14; i++)
		{
			j = (new Integer(strValue.substring(i, i + 1))).intValue();
			if (j > 0)
			{
				strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append(strThat).append(toUpper(j)).append(getUnit(i)).toString();
				strThat = "";
			} else
			{
				if (i == 11)
					strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append(getUnit(i)).toString();
				if (i == 7 && !strValue.substring(4, 8).equals("0000"))
					strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append(getUnit(i)).toString();
				if (i == 3 && !strValue.substring(0, 4).equals("0000"))
					strOutValue = (new StringBuilder(String.valueOf(strOutValue))).append(getUnit(i)).toString();
				if (i < 11)
					strThat = toUpper(0);
				if (i == 12)
					strThat = toUpper(0);
			}
		}

		return strOutValue;
	}

	public static String toChinese(int intInValue)
	{
		return toChinese(intInValue);
	}

	public static String toChinese(long longInValue)
	{
		return toChinese(longInValue);
	}

	public static String cTrim(String tStr)
	{
		String ttStr = "";
		if (tStr == null)
			ttStr = "";
		else
			ttStr = tStr.trim();
		return ttStr;
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

	public static String RCh(String sourString, String cChar, int cLen)
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

	public static String Conversion(String strIn, String pathname)
	{
		String strOut = "";
		try
		{
			ConfigInfo.SetConfigPath(pathname);
			SSRS tSSRS = ConfigInfo.GetValuebyCon();
			for (int i = 0; i < tSSRS.MaxRow; i++)
			{
				strOut = replace(strIn, tSSRS.GetText(i + 1, 1), tSSRS.GetText(i + 1, 2));
				if (i != tSSRS.MaxRow - 1)
					strIn = strOut;
			}

		}
		catch (Exception ex)
		{
			strOut = "";
		}
		return strOut;
	}

	public static String replaceEx(String strMain, String strFind, String strReplaceWith)
	{
		String strReturn = "";
		String tStrMain = strMain.toLowerCase();
		String tStrFind = strFind.toLowerCase();
		int intStartIndex = 0;
		int intEndIndex = 0;
		if (strMain == null || strMain.equals(""))
			return "";
		while ((intEndIndex = tStrMain.indexOf(tStrFind, intStartIndex)) > -1) 
		{
			strReturn = (new StringBuilder(String.valueOf(strReturn))).append(strMain.substring(intStartIndex, intEndIndex)).append(strReplaceWith).toString();
			intStartIndex = intEndIndex + strFind.length();
		}
		strReturn = (new StringBuilder(String.valueOf(strReturn))).append(strMain.substring(intStartIndex, strMain.length())).toString();
		return strReturn;
	}

	public static boolean compareString(String a, String b)
	{
		return unicodeToGBK(cTrim(a)).equals(unicodeToGBK(cTrim(b)));
	}

	public static void main(String args1[])
	{
	}
}
