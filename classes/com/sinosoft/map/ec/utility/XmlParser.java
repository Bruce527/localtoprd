// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XmlParser.java

package com.sinosoft.map.ec.utility;

import com.sinosoft.map.common.logs.ErrorsLog;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlParser
{

	public XmlParser()
	{
	}

	public static Document newDocument()
		throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.newDocument();
	}

	public static Document getDocument(String xmlPath)
		throws SAXException, IOException, ParserConfigurationException
	{
		return getDocument(new File(xmlPath));
	}

	public static Document getDocument(File file)
		throws SAXException, IOException, ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(file);
	}

	public static synchronized void saveDocument(Document doc, String xmlPath)
		throws TransformerConfigurationException, TransformerException
	{
		saveDocument(doc, new File(xmlPath));
	}

	public static synchronized void saveDocument(Document doc, File file)
		throws TransformerConfigurationException, TransformerException
	{
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult();
		try
		{
			result.setOutputStream(new FileOutputStream(file.getPath()));
		}
		catch (Exception ex)
		{
			ErrorsLog.log((new StringBuilder("XmlParser:saveDocument:")).append(ex.getMessage()).toString());
		}
		transformer.transform(source, result);
	}

	public static synchronized void write(Document doc, Writer writer)
		throws TransformerConfigurationException, TransformerException
	{
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(writer);
		transformer.transform(source, result);
	}
}
