// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DownloadUtil.java

package com.sinosoft.map.lis.excel;

import java.io.*;

class DownloadUtil
{

	DownloadUtil()
	{
	}

	private static void writeTo(OutputStream out, InputStream in)
	{
		try
		{
			out.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		int aRead = 0;
		try
		{
			while ((aRead = in.read()) != -1 && in != null) 
				out.write(aRead);
		}
		catch (IOException e)
		{
			System.out.println((new StringBuilder("�ļ������쳣---")).append(e.getMessage()).toString());
			System.out.println("��������Ϊ���ر�ȡ��");
		}
		try
		{
			out.flush();
		}
		catch (IOException e)
		{
			System.out.println((new StringBuilder("�ļ������쳣---")).append(e.getMessage()).toString());
			System.out.println("��������Ϊ���ر�ȡ��");
		}
	}

	public static void writeTo(OutputStream out, String filePath)
	{
		InputStream in = null;
		try
		{
			in = new FileInputStream(filePath);
			if (in != null)
				writeTo(out, in);
			break MISSING_BLOCK_LABEL_159;
		}
		catch (FileNotFoundException e)
		{
			System.out.println((new StringBuilder("�ļ������쳣---")).append(e.getMessage()).toString());
			System.out.println("��������Ϊ���ر�ȡ��");
		}
		if (in != null)
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				System.out.println((new StringBuilder("�ļ������쳣---")).append(e.getMessage()).toString());
				System.out.println("��������Ϊ���ر�ȡ��");
			}
		break MISSING_BLOCK_LABEL_206;
		Exception exception;
		exception;
		if (in != null)
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				System.out.println((new StringBuilder("�ļ������쳣---")).append(e.getMessage()).toString());
				System.out.println("��������Ϊ���ر�ȡ��");
			}
		throw exception;
		if (in != null)
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				System.out.println((new StringBuilder("�ļ������쳣---")).append(e.getMessage()).toString());
				System.out.println("��������Ϊ���ر�ȡ��");
			}
	}
}
