// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   NBConversion.java

package com.sinosoft.banklns.lnsmodel.webservice;

import com.sinosoft.banklns.lnsmodel.interfaces.XMLSaveThread;
import java.io.PrintStream;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.json.JSONObject;
import org.json.XML;

public class NBConversion
{

	public NBConversion()
	{
	}

	public String ConversionXML(String type, Document doc)
	{
		Format format = Format.getPrettyFormat();
		format.setEncoding("gbk");
		String xmlStr = "";
		XMLOutputter xmlout = new XMLOutputter(format);
		xmlStr = xmlout.outputString(doc);
		if ("dupli_out".equals(type))
		{
			String dupli = convertXML2JSON(xmlStr);
			dupli = dupli.replace("\"CLTVALI_REC\": {", "");
			int finalCount = dupli.lastIndexOf("}");
			dupli = dupli.substring(0, finalCount);
			return dupli;
		}
		if ("aura_out".equals(type))
		{
			String aura = convertXML2JSON(xmlStr);
			return aura;
		}
		if ("issue_out".equals(type))
		{
			String issue = convertXML2JSON(xmlStr);
			return issue;
		} else
		{
			return "";
		}
	}

	public String ConversionJson(String type, String json)
	{
		if ("dupli_out".equals(type))
		{
			int startCount = json.indexOf("{");
			json = json.substring(startCount + 1, json.length());
			json = (new StringBuilder("{\"CLTVALO_REC\": {")).append(json).append("}").toString();
			System.out.println(json);
			String xml = convertJSON2XML(json);
			System.out.println((new StringBuilder("xml = ")).append(xml).toString());
			return xml;
		}
		if ("aura_out".equals(type))
		{
			String aura = convertJSON2XML(json);
			return aura;
		} else
		{
			return "";
		}
	}

	public static String convertXML2JSON(String tConvertXML)
	{
		JSONObject xmlJSONObj = XML.toJSONObject(tConvertXML, true);
		return xmlJSONObj.toString(4);
	}

	public static void saveCreatedXMLFile(Document doc2, String string, String tContNo2)
	{
		(new XMLSaveThread(doc2, string, tContNo2)).start();
	}

	public static String convertJSON2XML(String tConvertJSON)
	{
		return (new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")).append(XML.toString(new JSONObject(tConvertJSON))).toString();
	}
}
