// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLByJDOM.java

package com.sinosoft.banklns.lis.pubfun;

import java.io.*;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

public class XMLByJDOM
{

	public XMLByJDOM()
	{
	}

	public Document loadXMLFileByJDOM(String tFileName)
	{
		Document document = null;
		try
		{
			SAXBuilder builder = new SAXBuilder();
			document = builder.build(new File(tFileName));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return document;
	}

	public String transformXMLToString(Document document)
	{
		String xmlStr;
		XMLOutputter xmlout = new XMLOutputter();
		Format tFormat = Format.getPrettyFormat();
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		xmlout.output(document, bo);
		xmlStr = bo.toString();
		return xmlStr;
		Exception e;
		e;
		e.printStackTrace();
		return null;
	}

	public Document stringToXML(String xmlStr)
	{
		Document doc;
		StringReader sr = new StringReader(xmlStr);
		InputSource is = new InputSource(sr);
		doc = (new SAXBuilder()).build(is);
		return doc;
		Exception e;
		e;
		e.printStackTrace();
		return null;
	}
}
