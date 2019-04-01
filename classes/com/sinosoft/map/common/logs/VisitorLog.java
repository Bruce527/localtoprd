// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   VisitorLog.java

package com.sinosoft.map.common.logs;

import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.ec.utility.XmlParser;
import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.File;
import java.io.Serializable;
import java.util.*;
import org.w3c.dom.*;

// Referenced classes of package com.sinosoft.map.common.logs:
//			LogInfo, ErrorsLog

public class VisitorLog
	implements Serializable
{

	public static List webOperateInfoList = new ArrayList();

	public VisitorLog()
	{
	}

	public static synchronized void logClick(LogInfo tLogInfo)
	{
		try
		{
			int j = 0;
			j = createUserVisitor(tLogInfo);
			File visitorLogFile = getLogFile(ECPubFun.getCurrentDate());
			Document doc = XmlParser.getDocument(visitorLogFile);
			Element root = doc.getDocumentElement();
			NodeList ips = root.getElementsByTagName("visitor");
			Element visitorNode = (Element)ips.item(j);
			Element uri = doc.createElement("uri");
			org.w3c.dom.Text eIP_text = doc.createTextNode(tLogInfo.getOperateStr());
			uri.appendChild(eIP_text);
			uri.setAttribute("time", (new StringBuilder(String.valueOf(tLogInfo.getOperateDate()))).append(" ").append(tLogInfo.getOperateTime()).toString());
			visitorNode.appendChild(uri);
			String filename = (new StringBuilder("webvisitorlog")).append(ECPubFun.getCurrentDate()).append(".xml").toString();
			String vlog = (new StringBuilder(String.valueOf(getVlogPath()))).append("/").append(filename).toString();
			XmlParser.saveDocument(doc, vlog);
		}
		catch (Exception saxe)
		{
			saxe.printStackTrace();
			ErrorsLog.log((new StringBuilder("Exception:VisitorLog:log:")).append(saxe.getMessage()).toString());
		}
	}

	public static synchronized void logClick(List tLogInfos)
	{
		if (tLogInfos == null || tLogInfos.isEmpty())
			return;
		try
		{
			File visitorLogFile = getLogFile(ECPubFun.getCurrentDate());
			Document doc = XmlParser.getDocument(visitorLogFile);
			Element xRoot = doc.getDocumentElement();
			NodeList visitors = xRoot.getElementsByTagName("visitor");
			int len = visitors.getLength();
			for (Iterator iterator = tLogInfos.iterator(); iterator.hasNext();)
			{
				LogInfo tLogInfo1 = (LogInfo)iterator.next();
				String flag = "0";
				for (int i = 0; i < len; i++)
				{
					Element xVisitor = (Element)visitors.item(i);
					String userCode = xVisitor.getElementsByTagName("user").item(0).getTextContent().trim();
					if (tLogInfo1.getUsercode().equals(userCode))
						flag = "1";
				}

				if (flag.equals("0"))
				{
					Element xVisitor = doc.createElement("visitor");
					Element xUser = doc.createElement("user");
					org.w3c.dom.Text Operate_text = null;
					Operate_text = doc.createTextNode(tLogInfo1.getUsercode());
					xRoot.appendChild(xVisitor);
					xVisitor.appendChild(xUser);
					xUser.appendChild(Operate_text);
					XmlParser.saveDocument(doc, visitorLogFile);
					len++;
				}
			}

			visitorLogFile = getLogFile(ECPubFun.getCurrentDate());
			doc = XmlParser.getDocument(visitorLogFile);
			xRoot = doc.getDocumentElement();
			visitors = xRoot.getElementsByTagName("visitor");
			len = visitors.getLength();
			for (Iterator iterator1 = tLogInfos.iterator(); iterator1.hasNext();)
			{
				LogInfo tLogInfo2 = (LogInfo)iterator1.next();
				for (int i = 0; i < len; i++)
				{
					Element xVisitor = (Element)visitors.item(i);
					String userCode = xVisitor.getElementsByTagName("user").item(0).getTextContent();
					if (tLogInfo2.getUsercode().equals(userCode))
					{
						Element uri = doc.createElement("uri");
						org.w3c.dom.Text Operate_text = doc.createTextNode(tLogInfo2.getOperateStr());
						uri.appendChild(Operate_text);
						uri.setAttribute("time", (new StringBuilder(String.valueOf(tLogInfo2.getOperateDate()))).append(" ").append(tLogInfo2.getOperateTime()).toString());
						xVisitor.appendChild(uri);
					}
				}

			}

			XmlParser.saveDocument(doc, visitorLogFile);
		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:VisitorLog:logClick(manay):")).append(e.getMessage()).toString());
		}
	}

	public static synchronized int createUserVisitor(LogInfo tLogInfo)
	{
		int reindex = -1;
		try
		{
			int flag = -1;
			File visitorLogFile = getLogFile(ECPubFun.getCurrentDate());
			Document doc = XmlParser.getDocument(visitorLogFile);
			LogInfo rLogInfo = tLogInfo;
			Element xRoot = doc.getDocumentElement();
			NodeList ips = xRoot.getElementsByTagName("visitor");
			for (int i = 0; i < ips.getLength(); i++)
			{
				Element temp = (Element)ips.item(i);
				NodeList tUser = temp.getElementsByTagName("user");
				Element userCode = (Element)tUser.item(0);
				if (userCode.getTextContent().trim().equals(rLogInfo.getUsercode()))
					flag = i;
			}

			if (flag != -1)
			{
				reindex = flag;
			} else
			{
				Element xVisitor = doc.createElement("visitor");
				Element xUser = doc.createElement("user");
				org.w3c.dom.Text xUser_text = null;
				xUser_text = doc.createTextNode(rLogInfo.getUsercode());
				xRoot.appendChild(xVisitor);
				xVisitor.appendChild(xUser);
				xUser.appendChild(xUser_text);
				XmlParser.saveDocument(doc, visitorLogFile);
				int ttflag = -1;
				for (int i = 0; i < ips.getLength(); i++)
				{
					Element temp = (Element)ips.item(i);
					NodeList tUser = temp.getElementsByTagName("user");
					Element userCode = (Element)tUser.item(0);
					if (userCode.getTextContent().trim().equals(rLogInfo.getUsercode()))
						ttflag = i;
				}

				reindex = ttflag;
			}
		}
		catch (Exception saxe)
		{
			saxe.printStackTrace();
			ErrorsLog.log((new StringBuilder("Exception:VisitorLog:log:")).append(saxe.getMessage()).toString());
		}
		return reindex;
	}

	private static File getLogFile(String date)
	{
		String filename = (new StringBuilder("webvisitorlog")).append(date).append(".xml").toString();
		String vlog = (new StringBuilder(String.valueOf(getVlogPath()))).append(File.separator).append(filename).toString();
		File file = new File(vlog);
		if (!file.exists())
			newXML(vlog);
		return file;
	}

	private static void newXML(String path)
	{
		try
		{
			Document doc = XmlParser.newDocument();
			Element root = doc.createElement("root");
			doc.appendChild(root);
			XmlParser.saveDocument(doc, path);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ErrorsLog.log((new StringBuilder("Exception:VisitorLog:newXML:")).append(e.getMessage()).toString());
		}
	}

	private static String getVlogPath()
	{
		String sql = "select varvalue from msysvar where vartype='logsPath' ";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		String path = tSSRS.GetText(1, 1);
		path = (new StringBuilder(String.valueOf(path))).append(File.separator).append("web").append(File.separator).append("webvisitorlog").toString();
		return path;
	}

}
