// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DoForDBSet.java

package com.sinosoft.banklns.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoForDBSet
{

	private String absolutePath;

	public DoForDBSet()
	{
		absolutePath = "D:/Project/ACLife/src/com/sinosoft/lis/vdb";
	}

	private List getAllFile()
	{
		File file = new File(absolutePath);
		String filelist[] = file.list();
		List list = new ArrayList();
		for (int i = 0; i < filelist.length; i++)
		{
			File tempfile = new File((new StringBuilder(String.valueOf(absolutePath))).append("/").append(filelist[i]).toString());
			System.out.println((new StringBuilder("���ڴ����ļ�: ")).append(tempfile.getName()).append("  ...............").toString());
			if (tempfile.getName().indexOf(".java") > -1)
				list.add(tempfile);
			System.out.println("��ɴ���?..........");
		}

		return list;
	}

	public void execute()
	{
		List list = getAllFile();
		for (int i = 0; list != null && i < list.size(); i++)
		{
			File fl = (File)list.get(i);
			deal(fl);
		}

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
				if (temp.indexOf("con = db.getConnection();") < 0)
					bw.write((new StringBuilder(String.valueOf(temp))).append("\n").toString());

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
		deleteFile(file);
		File tempFile = new File((new StringBuilder(String.valueOf(absolutePath))).append("/").append(tempname).toString());
		renameForFile(tempFile, name);
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
		DoForDBSet reDoForDBSet = new DoForDBSet();
		reDoForDBSet.execute();
	}
}
