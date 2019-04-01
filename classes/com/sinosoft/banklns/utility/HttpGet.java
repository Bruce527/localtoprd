// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HttpGet.java

package com.sinosoft.banklns.utility;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class HttpGet
{

	public static final boolean DEBUG = true;
	private static int BUFFER_SIZE = 8096;
	private Vector vDownLoad;
	private Vector vFileList;

	public HttpGet()
	{
		vDownLoad = new Vector();
		vFileList = new Vector();
	}

	public void resetList()
	{
		vDownLoad.clear();
		vFileList.clear();
	}

	public void addItem(String url, String filename)
	{
		vDownLoad.add(url);
		vFileList.add(filename);
	}

	public void downLoadByList()
	{
		String url = null;
		String filename = null;
		for (int i = 0; i < vDownLoad.size(); i++)
		{
			url = (String)vDownLoad.get(i);
			filename = (String)vFileList.get(i);
			try
			{
				saveToFile(url, filename);
			}
			catch (IOException err)
			{
				System.out.println((new StringBuilder("��Դ[")).append(url).append("]����ʧ��!!!").toString());
			}
		}

		System.out.println("�������?!!!");
	}

	public void saveToFile(String destUrl, String fileName)
		throws IOException
	{
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		byte buf[] = new byte[BUFFER_SIZE];
		int size = 0;
		url = new URL(destUrl);
		httpUrl = (HttpURLConnection)url.openConnection();
		httpUrl.connect();
		bis = new BufferedInputStream(httpUrl.getInputStream());
		fos = new FileOutputStream(fileName);
		System.out.println((new StringBuilder("���ڻ�ȡt��[")).append(destUrl).append("]������...\n���䱣��Ϊ�ļ�[").append(fileName).append("]").toString());
		while ((size = bis.read(buf)) != -1) 
			fos.write(buf, 0, size);
		fos.close();
		bis.close();
		httpUrl.disconnect();
	}

	public void setProxyServer(String proxy, String proxyPort)
	{
		System.getProperties().put("proxySet", "true");
		System.getProperties().put("proxyHost", proxy);
		System.getProperties().put("proxyPort", proxyPort);
	}

	public static void main(String argv[])
	{
		Date dat = new Date();
		HttpGet oInstance = new HttpGet();
		try
		{
			oInstance.addItem("http://www.ebook.com/java/������001.zip", "./������1.zip");
			oInstance.addItem("http://www.ebook.com/java/������002.zip", "./������2.zip");
			oInstance.addItem("http://www.ebook.com/java/������003.zip", "./������3.zip");
			oInstance.addItem("http://www.ebook.com/java/������004.zip", "./������4.zip");
			oInstance.addItem("http://www.ebook.com/java/������005.zip", "./������5.zip");
			oInstance.addItem("http://www.ebook.com/java/������006.zip", "./������6.zip");
			oInstance.addItem("http://www.ebook.com/java/������007.zip", "./������7.zip");
			oInstance.downLoadByList();
		}
		catch (Exception err)
		{
			System.out.println(err.getMessage());
		}
	}

}
