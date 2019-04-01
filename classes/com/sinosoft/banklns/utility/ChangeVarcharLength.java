// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ChangeVarcharLength.java

package com.sinosoft.banklns.utility;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeVarcharLength
{

	private String absolutePath;

	public ChangeVarcharLength()
	{
		absolutePath = "D:";
	}

	public void executeVarchar()
	{
		File file = new File("aclcsug.ddl");
		deal(file);
	}

	private void deal(File file)
	{
		String name = file.getName();
		String tempname = (new StringBuilder(String.valueOf(name))).append("~").toString();
		File read = new File((new StringBuilder(String.valueOf(absolutePath))).append("/").append(name).toString());
		File write = new File((new StringBuilder(String.valueOf(absolutePath))).append("/").append(tempname).toString());
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(read));
			BufferedWriter bw = new BufferedWriter(new FileWriter(write));
			String temp = null;
			for (temp = br.readLine(); temp != null; temp = br.readLine())
			{
				temp = changeLength(temp);
				bw.write((new StringBuilder(String.valueOf(temp))).append("\n").toString());
			}

			bw.close();
			br.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		deleteFile(read);
		renameForFile(write, name);
	}

	private String changeLength(String varcharStr)
	{
		String str = varcharStr;
		String regEx = "VARCHAR\\([0-9]*\\)";
		Pattern p = Pattern.compile(regEx, 2);
		Matcher m = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		String reStr;
		for (; m.find(); m.appendReplacement(sb, reStr))
		{
			String temp = m.group();
			int start = temp.indexOf('(');
			int end = temp.indexOf(')');
			String numStr = temp.substring(start + 1, end);
			int num = Integer.parseInt(numStr);
			int result = (int)((double)num * 1.5D);
			if ((double)result < (double)num * 1.5D)
				result++;
			reStr = (new StringBuilder("VARCHAR(")).append(result).append(")").toString();
		}

		m.appendTail(sb);
		String result = sb.toString();
		return result;
	}

	private void renameForFile(File file, String newName)
	{
		file.renameTo(new File((new StringBuilder(String.valueOf(absolutePath))).append("/").append(newName).toString()));
	}

	private void deleteFile(File file)
	{
		file.delete();
	}

	public static void main(String args[])
	{
		ChangeVarcharLength reChangeVarcharLength = new ChangeVarcharLength();
		reChangeVarcharLength.executeVarchar();
	}
}
