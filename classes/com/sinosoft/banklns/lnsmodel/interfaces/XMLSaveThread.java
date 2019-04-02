// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLSaveThread.java

package com.sinosoft.banklns.lnsmodel.interfaces;

import com.sinosoft.banklns.lis.pubfun.PubFun;
import com.sinosoft.banklns.lnsmodel.util.EAIPropertiesFromDB;
import java.io.*;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XMLSaveThread extends Thread
{

	private Document createdDoc;
	private String foldName;
	private String string;

	public XMLSaveThread(Document createdDoc, String foldName, String string)
	{
		this.createdDoc = null;
		this.foldName = null;
		this.string = null;
		this.createdDoc = createdDoc;
		this.foldName = foldName;
		this.string = string;
	}

	public void run()
	{
		try
		{
			System.out.println("~~~~~~~~~~~~~~~~~~thread start mdes~~");
			String fileName = (new StringBuilder(String.valueOf(foldName))).append(string).append(PubFun.getCurrentDate().replace("-", "")).append(PubFun.getCurrentTime().replace(":", "")).append(".xml").toString();
			System.out.println((new StringBuilder("fileName1:")).append(fileName).toString());
			System.out.println((new StringBuilder("PubFun.getCurrentDate().replace(,):")).append(PubFun.getCurrentDate().replace("-", "")).toString());
			System.out.println((new StringBuilder("foldName:")).append(foldName).toString());
			System.out.println((new StringBuilder("EAIPropertiesFromDB.XMLSavePath:")).append(EAIPropertiesFromDB.XMLSavePath).toString());
			String savePath = (new StringBuilder(String.valueOf(EAIPropertiesFromDB.XMLSavePath))).append(File.separator).append(foldName).append(File.separator).append(PubFun.getCurrentDate().replace("-", "")).append(File.separator).toString();
			System.out.println((new StringBuilder("savePath:")).append(savePath).toString());
			String saveFilePath = (new StringBuilder(String.valueOf(savePath))).append(fileName).toString();
			System.out.println((new StringBuilder("保存接口的XML文件路径为--------------------")).append(saveFilePath).toString());
			File dirFile = new File(savePath);
			if (!dirFile.exists())
				dirFile.mkdir();
			XMLOutputter outputter = new XMLOutputter();
			outputter.setFormat(Format.getPrettyFormat().setEncoding("GBK"));
			outputter.output(createdDoc, new FileWriter(saveFilePath));
			System.out.println((new StringBuilder("保存接口的XML文件成功，保存路径为：")).append(saveFilePath).toString());
		}
		catch (Exception ex)
		{
			System.out.println((new StringBuilder("保存接口的XML文件发生异常！")).append(ex.getLocalizedMessage()).toString());
			ex.printStackTrace();
		}
		System.out.println("thread end");
	}
}
