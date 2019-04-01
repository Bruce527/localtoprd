// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ConfigInfo.java

package com.sinosoft.map.utility;

import java.io.*;
import java.util.Vector;

// Referenced classes of package com.sinosoft.map.utility:
//			StrTool, UserLog, ChgData, SSRS

public class ConfigInfo
{

	private static String ErrorString = "";
	private static String ConfigFilePath = "AppConfig.properties";

	public ConfigInfo()
	{
	}

	public ConfigInfo(String XmlFilePath)
	{
		ConfigFilePath = XmlFilePath;
	}

	public static String GetConfigPath()
	{
		return ConfigFilePath;
	}

	public static void SetConfigPath(String newpath)
	{
		ConfigFilePath = newpath;
	}

	public static String GetErrorString()
	{
		return ErrorString;
	}

	public static String GetValuebyName(String inpfieldname)
	{
		String ConfigValue = "";
		try
		{
			FileInputStream readconfig = new FileInputStream(ConfigFilePath);
			byte tb[] = new byte[256];
			int len = 0;
			int i = 0;
			String fieldname = "";
			String fieldvalue = "";
			while ((len = readconfig.read()) != -1) 
			{
				String tempStr = null;
				if (len == 10)
				{
					tempStr = new String(tb);
					tempStr = tempStr.trim();
					fieldname = StrTool.decodeStr(tempStr, "=", 1);
					if (fieldname.equals(inpfieldname))
					{
						fieldvalue = tempStr.substring(fieldname.length() + 1);
						break;
					}
					i = 0;
					tb = new byte[256];
				} else
				{
					Integer reallen = new Integer(len);
					tb[i] = reallen.byteValue();
					i++;
				}
			}
			readconfig.close();
			ConfigValue = fieldvalue.trim();
		}
		catch (Exception exception)
		{
			ErrorString = (new StringBuilder("<Conf.class> Parsing config file error:")).append(exception.toString()).toString();
			UserLog.printException(ErrorString);
		}
		return ConfigValue;
	}

	public static String GetValuebyArea(String inpfieldname)
	{
		String ConfigValue = "";
		try
		{
			File tFile = new File(ConfigFilePath);
			System.out.println((new StringBuilder("AppConfig.propertiesµÄ¾ø¶ÔÂ·¾¶")).append(tFile.getAbsolutePath()).toString());
			FileInputStream readconfig = new FileInputStream(ConfigFilePath);
			byte tb[] = new byte[256];
			int len = 0;
			int i = 0;
			String fieldname = "";
			String fieldvalue = "";
			while ((len = readconfig.read()) != -1) 
			{
				String tempStr = null;
				if (len == 10)
				{
					tempStr = new String(tb);
					tempStr = tempStr.trim();
					fieldname = StrTool.decodeStr(tempStr, "=", 1);
					if (tempStr.length() == 0 && fieldname.length() == 0)
					{
						i = 0;
						tb = new byte[256];
						continue;
					}
					if (cmpFieldValue(fieldname, inpfieldname))
					{
						fieldvalue = tempStr.substring(fieldname.length() + 1);
						break;
					}
					i = 0;
					tb = new byte[256];
				} else
				{
					Integer reallen = new Integer(len);
					tb[i] = reallen.byteValue();
					i++;
				}
			}
			readconfig.close();
			ConfigValue = fieldvalue.trim();
		}
		catch (Exception exception)
		{
			ErrorString = (new StringBuilder("<Conf.class> Parsing config file error:")).append(exception.toString()).toString();
			UserLog.printException(ErrorString);
		}
		return ConfigValue;
	}

	public static boolean cmpFieldValue(String srcFieldName, String tagFieldName)
	{
		String tmpStr[];
		String tmpValue[];
		int i;
		tmpStr = new String[5];
		tmpValue = new String[5];
		int strPos = 0;
		i = 0;
		if (tagFieldName.length() == 0 || srcFieldName.indexOf(".") == -1)
			return false;
		srcFieldName = (new StringBuilder(String.valueOf(srcFieldName.trim()))).append(".").toString();
		tagFieldName = (new StringBuilder(String.valueOf(tagFieldName.trim()))).append(".").toString();
		tmpStr[0] = StrTool.decodeStr(srcFieldName, ".", 1);
		tmpStr[1] = StrTool.decodeStr(srcFieldName, ".", 2);
		tmpStr[2] = StrTool.decodeStr(srcFieldName, ".", 3);
		tmpStr[3] = StrTool.decodeStr(srcFieldName, ".", 4);
		tmpStr[4] = StrTool.decodeStr(srcFieldName, ".", 5);
		tmpValue[0] = StrTool.decodeStr(tagFieldName, ".", 1);
		tmpValue[1] = StrTool.decodeStr(tagFieldName, ".", 2);
		tmpValue[2] = StrTool.decodeStr(tagFieldName, ".", 3);
		tmpValue[3] = StrTool.decodeStr(tagFieldName, ".", 4);
		tmpValue[4] = StrTool.decodeStr(tagFieldName, ".", 5);
		i = 0;
		  goto _L1
_L3:
		if (!cmp2Value(tmpStr[i], tmpValue[i]))
			return false;
		i++;
_L1:
		if (i < tmpStr.length) goto _L3; else goto _L2
_L2:
		return true;
		Exception exception;
		exception;
		return false;
	}

	public static boolean cmp2Value(String strSource, String strTarget)
	{
		String tmpStrValue = "";
		String tmpStrArray[] = new String[2];
		int strPos = strSource.indexOf("-");
		if (strPos == -1)
			return strTarget.equals(strSource.substring(1, strSource.length() - 1)) || strSource.substring(1, strSource.length() - 1).equals("*");
		tmpStrValue = (new StringBuilder(String.valueOf(strSource.substring(1, strSource.length() - 1)))).append("-").toString();
		tmpStrArray[0] = StrTool.decodeStr(tmpStrValue, "-", 1);
		tmpStrArray[1] = StrTool.decodeStr(tmpStrValue, "-", 2);
		int intCmp = (new Integer(ChgData.chgNumericStr(strTarget))).intValue();
		int intAreaS = (new Integer(ChgData.chgNumericStr(tmpStrArray[0]))).intValue();
		int intAreaE = (new Integer(ChgData.chgNumericStr(tmpStrArray[1]))).intValue();
		return intCmp >= intAreaS && intCmp <= intAreaE;
	}

	public static Vector GetIniByIp(String inpip)
	{
		String fieldvalue = "";
		Vector Strvector = new Vector();
		try
		{
			FileInputStream readconfig = new FileInputStream(ConfigFilePath);
			byte tb[] = new byte[256];
			int len = 0;
			int i = 0;
			int intIndex = 0;
			String fieldname = "";
			String inpfieldname = (new StringBuilder("(")).append(StrTool.decodeStr(inpip, ".", 1)).append(")").append(".").append("(").append(StrTool.decodeStr(inpip, ".", 2)).append(")").toString();
			while ((len = readconfig.read()) != -1) 
			{
				String tempStr = null;
				if (len == 10)
				{
					tempStr = new String(tb);
					tempStr = tempStr.trim();
					fieldname = (new StringBuilder(String.valueOf(StrTool.decodeStr(tempStr, ".", 1)))).append(".").append(StrTool.decodeStr(tempStr, ".", 2)).toString();
					if (fieldname.equals(inpfieldname))
					{
						fieldvalue = tempStr;
						Strvector.addElement(fieldvalue);
						i = 0;
						tb = new byte[256];
					} else
					{
						i = 0;
						tb = new byte[256];
					}
				} else
				{
					Integer reallen = new Integer(len);
					tb[i] = reallen.byteValue();
					i++;
				}
			}
			readconfig.close();
		}
		catch (Exception exception)
		{
			String ErrorString = (new StringBuilder("<Conf.class> Parsing config file error:")).append(exception.toString()).toString();
			UserLog.printException(ErrorString);
		}
		for (int i = 0; i < Strvector.size(); i++)
			System.out.println((String)Strvector.get(i));

		return Strvector;
	}

	public static boolean DeleteByStr(String inputStr)
	{
		try
		{
			File output = new File("AppConfig.properties.tmp");
			output.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(output.getPath(), true));
			File input = new File(ConfigFilePath);
			FileInputStream readconfig = new FileInputStream(input);
			byte tb[] = new byte[256];
			int len = 0;
			int i = 0;
			int intIndex = 0;
			while ((len = readconfig.read()) != -1) 
			{
				String tempStr = null;
				if (len == 10)
				{
					tempStr = new String(tb);
					if (!tempStr.substring(0, inputStr.length()).equals(inputStr))
					{
						tempStr = tempStr.trim();
						System.out.println(tempStr);
						out.write(tempStr);
						out.write(10);
					}
					i = 0;
					tb = new byte[256];
				} else
				if (len != 10)
				{
					Integer reallen = new Integer(len);
					tb[i] = reallen.byteValue();
					i++;
				}
			}
			readconfig.close();
			input.delete();
			out.close();
			File tempfile = new File(ConfigFilePath);
			output.renameTo(tempfile);
		}
		catch (Exception exception)
		{
			String ErrorString = (new StringBuilder("<Conf.class> Parsing config file error:")).append(exception.toString()).toString();
			UserLog.printException(ErrorString);
			return false;
		}
		return true;
	}

	public static SSRS GetValuebyCon()
	{
		SSRS tSSRS = new SSRS(2);
		try
		{
			FileInputStream readconfig = new FileInputStream(ConfigFilePath);
			byte tb[] = new byte[256];
			int len = 0;
			int i = 0;
			String tempStr = null;
			while ((len = readconfig.read()) != -1) 
				if (len == 33)
				{
					tempStr = new String(tb);
					int position = tempStr.indexOf('|');
					tSSRS.SetText(tempStr.substring(0, position));
					if (tempStr.substring(0, position).equals("\r\n"))
					{
						tempStr = tempStr.trim();
						tSSRS.SetText(tempStr.substring(position - 1, tempStr.length()));
					} else
					{
						tempStr = tempStr.trim();
						tSSRS.SetText(tempStr.substring(position + 1, tempStr.length()));
					}
					i = 0;
					tb = new byte[256];
				} else
				{
					Integer reallen = new Integer(len);
					tb[i] = reallen.byteValue();
					i++;
				}
			readconfig.close();
		}
		catch (Exception exception)
		{
			ErrorString = (new StringBuilder("<Conf.class> Parsing config file error:")).append(exception.toString()).toString();
			UserLog.printException(ErrorString);
		}
		return tSSRS;
	}

	public static void main(String args1[])
	{
	}

}
