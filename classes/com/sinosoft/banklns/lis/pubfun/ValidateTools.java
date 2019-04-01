// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ValidateTools.java

package com.sinosoft.banklns.lis.pubfun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTools
{

	public static String validString1ErrorMessage = "输入错误，可以包含中英文，数字及“-”“_”“#”等字符";
	public static String validZipCodeErrorMessage = "输入应该为6位数字";
	public static String validTelCode2ErrorMessage = "长度为6-19位数字";

	public ValidateTools()
	{
	}

	public static int calcAge(String aBirthday)
	{
		if (aBirthday == null)
			return -1;
		if (!isDate(aBirthday))
			return -1;
		int iAge = 0;
		Calendar today = new GregorianCalendar();
		int iThisYear = today.get(1);
		int iThisMonth = today.get(2);
		int iThisDate = today.get(5);
		Calendar birthday = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate = null;
		try
		{
			inputDate = df.parse(aBirthday);
		}
		catch (ParseException ex)
		{
			ex.printStackTrace();
			return -1;
		}
		birthday.setTime(inputDate);
		int iBirthYear = birthday.get(1);
		int iBirthMonth = birthday.get(2);
		int iBirthDate = birthday.get(5);
		iAge = iThisYear - iBirthYear;
		if (iAge >= 0)
			if (iThisMonth != iBirthMonth)
			{
				if (iThisMonth < iBirthMonth)
					iAge--;
			} else
			if (iThisDate < iBirthDate)
				iAge--;
		return iAge;
	}

	public static boolean isDate(String aValue)
	{
		SimpleDateFormat df;
		if (aValue == null)
			return false;
		if (aValue.equals(""))
			break MISSING_BLOCK_LABEL_203;
		df = new SimpleDateFormat("yyyy-MM-dd");
		String sTemp;
		String temp[];
		Date tempDate = df.parse(aValue);
		sTemp = df.format(tempDate);
		if (aValue.length() >= 10)
			break MISSING_BLOCK_LABEL_184;
		temp = aValue.split("-");
		if (temp.length != 3)
			break MISSING_BLOCK_LABEL_184;
		if (temp[0].length() < 4)
			return false;
		if (temp[1].length() < 2)
			temp[1] = (new StringBuilder("0")).append(temp[1]).toString();
		if (temp[2].length() < 4)
			temp[2] = (new StringBuilder("0")).append(temp[2]).toString();
		aValue = (new StringBuilder(String.valueOf(temp[0]))).append("-").append(temp[1]).append("-").append(temp[2]).toString();
		return sTemp.equals(aValue);
		ParseException ex;
		ex;
		ex.printStackTrace();
		return false;
		return true;
	}

	public static boolean isNumeric(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("[0-9]*\\.{0,1}[0-9]{1,2}");
			Matcher isNum = pattern.matcher(aValue);
			return isNum.matches();
		} else
		{
			return true;
		}
	}

	public static boolean isValidPwd(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("([0-9]+[a-zA-Z]+)*|([a-zA-Z]+[0-9]+)*");
			Matcher isPwd = pattern.matcher(aValue);
			if (!isPwd.matches())
				return false;
			return aValue.length() == 6;
		} else
		{
			return true;
		}
	}

	public static boolean isValidEMail(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
			Matcher isEMail = pattern.matcher(aValue);
			return isEMail.matches();
		} else
		{
			return true;
		}
	}

	public static boolean isValidTelePhone(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("(\\d{3}-\\d{8}|\\d{4}-\\d{7,8}|\\d{7,11})+([/]{0,1}\\d)*([-]{0,1}\\d)*");
			Matcher isTelePhone = pattern.matcher(aValue);
			return isTelePhone.matches();
		} else
		{
			return true;
		}
	}

	public static boolean isValidString1(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("^(\\w|[\\u4E00-\\u9FA5]|[0-9]|[- _#.])*$");
			Matcher isName = pattern.matcher(aValue);
			return isName.matches();
		} else
		{
			return true;
		}
	}

	public static boolean isValidString3(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("^(\\w|[\\u4E00-\\u9FA5]|[0-9]|[- _#（）().])*$");
			Matcher isName = pattern.matcher(aValue);
			return isName.matches();
		} else
		{
			return true;
		}
	}

	public static boolean isValidString4(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("^(\\w|[\\u4E00-\\u9FA5]|[0-9]|[- _#????().@])*$");
			Matcher isName = pattern.matcher(aValue);
			return isName.matches();
		} else
		{
			return true;
		}
	}

	public static boolean isValidString2(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("^[A-Za-z0-9]+");
			Matcher isName = pattern.matcher(aValue);
			return isName.matches();
		} else
		{
			return true;
		}
	}

	public static boolean isValidZipCode(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("\\d{6}");
			Matcher isZipCode = pattern.matcher(aValue);
			return isZipCode.matches();
		} else
		{
			return true;
		}
	}

	public static boolean isValidDate(String aValue)
	{
		Calendar today;
		SimpleDateFormat df;
		if (aValue == null)
			return false;
		if ("".equals(aValue))
			break MISSING_BLOCK_LABEL_69;
		today = new GregorianCalendar();
		df = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate = df.parse(aValue);
		if (df.format(inputDate).equals(aValue))
			return today.getTime().after(inputDate);
		else
			return false;
		ParseException e;
		e;
		e.printStackTrace();
		return false;
		return true;
	}

	public static boolean isValidDate(String aValue1, String aValue2)
	{
		SimpleDateFormat df;
		if (aValue1 == null && aValue2 == null)
			return false;
		if (!isDate(aValue1) || !isDate(aValue2))
			return false;
		if ("".equals(aValue1) || "".equals(aValue2))
			break MISSING_BLOCK_LABEL_91;
		if (aValue1.equals(aValue2))
			return true;
		df = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate1;
		Date inputDate2;
		inputDate1 = df.parse(aValue1);
		inputDate2 = df.parse(aValue2);
		return inputDate2.after(inputDate1);
		ParseException e;
		e;
		e.printStackTrace();
		return false;
		return true;
	}

	public static boolean isValidTelCode2(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("[0-9]\\d{6,19}");
			Matcher isZipCode = pattern.matcher(aValue);
			return isZipCode.matches();
		} else
		{
			return true;
		}
	}

	public static String isValidIDNo(String aIDNo, String aBirthday, String aSex)
	{
		if (aIDNo == null || aBirthday == null || aSex == null)
			return "非法参数，身份证号或生日日期或性别为null";
		String tmpStr = "";
		int tmpInt = 0;
		String sReturn = "";
		aIDNo = aIDNo.trim();
		aBirthday = aBirthday.trim();
		aSex = aSex.trim();
		if (aIDNo.length() != 15 && aIDNo.length() != 18)
		{
			sReturn = "输入的身份证号位数错误";
			return sReturn;
		}
		if (aIDNo.length() == 15)
		{
			Pattern pattern = Pattern.compile("[0-9]{15}");
			Matcher isNum = pattern.matcher(aIDNo);
			if (!isNum.matches())
			{
				sReturn = "身份证格式错误";
				return sReturn;
			}
		}
		if (aIDNo.length() == 18)
		{
			Pattern pattern = Pattern.compile("[0-9]{17}[a-zA-Z0-9]{1}");
			Matcher isNum = pattern.matcher(aIDNo);
			if (!isNum.matches())
			{
				sReturn = "身份证格式错误";
				return sReturn;
			}
		}
		if (!"".equals(aBirthday) && !isDate(aBirthday))
			return "生日输入错误";
		if (!"0".equals(aSex) && !"1".equals(aSex))
		{
			sReturn = "输入的性别不明确";
			return sReturn;
		}
		if (aIDNo.length() == 15)
		{
			tmpStr = aIDNo.substring(6, 12);
			tmpStr = (new StringBuilder("19")).append(tmpStr).toString();
			tmpStr = (new StringBuilder(String.valueOf(tmpStr.substring(0, 4)))).append("-").append(tmpStr.substring(4, 6)).append("-").append(tmpStr.substring(6)).toString();
			if (isDate(tmpStr))
			{
				if (aBirthday.equals(tmpStr) || "".equals(aBirthday))
				{
					if (aSex.equals("0"))
					{
						tmpInt = Integer.parseInt(aIDNo.substring(14));
						tmpInt %= 2;
						if (tmpInt == 0)
						{
							sReturn = "输入的性别与身份证号的信息不一致";
							return sReturn;
						}
					} else
					{
						tmpInt = Integer.parseInt(aIDNo.substring(14));
						tmpInt %= 2;
						if (tmpInt != 0)
						{
							sReturn = "输入的性别与身份证号的信息不一致";
							return sReturn;
						}
					}
				} else
				{
					sReturn = "输入的生日与身份证号的信息不一致";
					return sReturn;
				}
			} else
			{
				sReturn = "输入身份证号中的生日日期信息不正确";
				return sReturn;
			}
		} else
		if (aIDNo.length() == 18)
		{
			tmpStr = aIDNo.substring(6, 14);
			tmpStr = (new StringBuilder(String.valueOf(tmpStr.substring(0, 4)))).append("-").append(tmpStr.substring(4, 6)).append("-").append(tmpStr.substring(6)).toString();
			if (isDate(tmpStr))
			{
				if (aBirthday.equals(tmpStr) || "".equals(aBirthday))
				{
					if (aSex.equals("0"))
					{
						tmpInt = Integer.parseInt(aIDNo.substring(16, 17));
						tmpInt %= 2;
						if (tmpInt == 0)
						{
							sReturn = "输入的性别与身份证号的信息不一致";
							return sReturn;
						}
					} else
					{
						tmpInt = Integer.parseInt(aIDNo.substring(16, 17));
						tmpInt %= 2;
						if (tmpInt != 0)
						{
							sReturn = "输入的性别与身份证号的信息不一致";
							return sReturn;
						}
					}
				} else
				{
					sReturn = "输入的生日与身份证号的信息不一致";
					return sReturn;
				}
			} else
			{
				sReturn = "输入身份证号中的生日日期信息不正确";
				return sReturn;
			}
			return sReturn;
		} else
		{
			sReturn = "输入的身份证号的位数不对";
			return sReturn;
		}
		return sReturn;
	}

	public static boolean isExistUselessChar(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
			return aValue.indexOf("'") == -1;
		else
			return true;
	}

}
