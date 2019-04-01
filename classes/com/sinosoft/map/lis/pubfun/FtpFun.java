// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FtpFun.java

package com.sinosoft.map.lis.pubfun;

import java.io.*;
import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.*;

public class FtpFun
{

	private FtpClient mFtpClient;

	public FtpFun()
	{
		mFtpClient = null;
	}

	public FtpClient connectFtpServer(String hostname, int port, String username, String password)
	{
		try
		{
			mFtpClient = new FtpClient(hostname, port);
			mFtpClient.login(username, password);
		}
		catch (FtpLoginException e1)
		{
			System.out.print("...... �û����������? ......");
			e1.printStackTrace();
			return null;
		}
		catch (IOException e2)
		{
			System.out.println("...... δ֪���� ......");
			e2.printStackTrace();
			return null;
		}
		catch (SecurityException e3)
		{
			System.out.print("...... Ȩ�޲��� ......");
			e3.printStackTrace();
			return null;
		}
		return mFtpClient;
	}

	public void downloadFile(String path, String filename)
	{
		try
		{
			if (path.length() != 0)
				mFtpClient.cd(path);
			mFtpClient.binary();
			TelnetInputStream tis = mFtpClient.get(filename);
			File outFile = new File((new StringBuilder("d:\\")).append(filename).toString());
			FileOutputStream fos = new FileOutputStream(outFile);
			byte bytes[] = new byte[2048];
			int c;
			while ((c = tis.read(bytes)) != -1) 
				fos.write(bytes, 0, c);
			tis.close();
			fos.close();
			mFtpClient.closeServer();
		}
		catch (IOException ex)
		{
			System.out.println("...... �����ļ�ʧ�� ......");
			ex.printStackTrace();
		}
	}

	public boolean uploadFile(String inPath, String inFilename, String outPath, String outFilename)
	{
		try
		{
			if (outPath.length() != 0)
				mFtpClient.cd(outPath);
			mFtpClient.binary();
			TelnetOutputStream tos = mFtpClient.put(outFilename);
			File inFile = new File((new StringBuilder(String.valueOf(inPath))).append(inFilename).toString());
			System.out.println((new StringBuilder("...... �����ļ���С:")).append(inFile.length() / 1024L).append("K ......").toString());
			FileInputStream fis = new FileInputStream(inFile);
			byte bytes[] = new byte[2048];
			int c;
			while ((c = fis.read(bytes)) != -1) 
				tos.write(bytes, 0, c);
			fis.close();
			tos.close();
			mFtpClient.closeServer();
		}
		catch (FtpProtocolException ex1)
		{
			System.out.println("...... �����ڸ�Ŀ¼�´����ļ� ......");
			ex1.printStackTrace();
			return false;
		}
		catch (IOException ex2)
		{
			System.out.println("...... δ֪���� ......");
			ex2.printStackTrace();
			return false;
		}
		return true;
	}

	public String getSystemInfo()
	{
		String systemInfo = null;
		try
		{
			systemInfo = mFtpClient.system();
		}
		catch (IOException ex)
		{
			System.out.println("......�õ�ϵͳ��Ϣ���?......");
			ex.printStackTrace();
		}
		return systemInfo;
	}

	public static void main(String args[])
	{
		FtpFun tFtpFun = new FtpFun();
		FtpClient tFtpClient = tFtpFun.connectFtpServer("172.19.1.43", 21, "oracle", "oracle");
		if (tFtpClient != null)
		{
			System.out.println((new StringBuilder("�Ѿ�l����ftp server")).append(tFtpFun.getSystemInfo()).toString());
			tFtpFun.downloadFile("/app/uploadfile/lisfile/", "DE2007-01-03_Mov.txt");
		}
	}
}
