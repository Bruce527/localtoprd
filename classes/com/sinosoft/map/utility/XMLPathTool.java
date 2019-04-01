// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLPathTool.java

package com.sinosoft.map.utility;

import java.io.*;
import javax.xml.parsers.*;
import org.apache.xpath.XPathAPI;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLPathTool
{

	private Document sourceDom;
	private String fileName;

	public XMLPathTool(String fileName)
	{
		this.fileName = fileName;
		try
		{
			if (sourceDom == null)
				sourceDom = getDocument(fileName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public XMLPathTool(InputStream in)
	{
		fileName = "";
		try
		{
			DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
			dfactory.setNamespaceAware(true);
			sourceDom = dfactory.newDocumentBuilder().parse(new InputSource(in));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private static Document getDocument(String fileName)
		throws ParserConfigurationException, SAXException, IOException
	{
		InputSource in = new InputSource(new FileInputStream(fileName));
		DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
		dfactory.setNamespaceAware(true);
		Document doc = dfactory.newDocumentBuilder().parse(in);
		return doc;
	}

	public Node parseX(String xpathString)
	{
		if (sourceDom == null)
			sourceDom = getDocument(fileName);
		return XPathAPI.selectSingleNode(sourceDom.getDocumentElement(), xpathString);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public NodeList parseN(String xpathString)
	{
		if (sourceDom == null)
			sourceDom = getDocument(fileName);
		return XPathAPI.selectNodeList(sourceDom.getDocumentElement(), xpathString);
		Exception ex;
		ex;
		ex.printStackTrace();
		return null;
	}

	public static void main(String args[])
	{
		XMLPathTool xmlPathTool = new XMLPathTool("2.xml");
		Node node = xmlPathTool.parseX("/DATASET/CONTROL/TEMPLATE");
		System.out.println(node.getFirstChild().getNodeValue());
		NodeList nodeList = xmlPathTool.parseN("/DATASET/TABLE1/ROW/COL1");
		String nVal[] = null;
		if (nodeList == null)
			nVal = new String[0];
		else
			nVal = new String[nodeList.getLength()];
		for (int i = 0; i < nVal.length; i++)
			nVal[i] = nodeList.item(i).getFirstChild().getNodeValue();

		for (int i = 0; i < nVal.length; i++)
			System.out.println(nVal[i]);

	}
}
