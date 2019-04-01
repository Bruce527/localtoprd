// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PDFTest.java

package com.sinosoft.map.utility;

import com.sinosoft.banklns.lis.pubfun.XMLByJDOM;
import java.io.PrintStream;
import org.jdom.JDOMException;
import org.jdom.xpath.XPath;
import org.w3c.dom.Element;

public class PDFTest
{

	public PDFTest()
	{
	}

	public static void main(String args[])
	{
		XMLByJDOM tXMLByJDOM = new XMLByJDOM();
		org.jdom.Document returnDoc = tXMLByJDOM.loadXMLFileByJDOM("D:\\temp\\634160189696156422923.xml");
		try
		{
			Element tProductCodeElement = (Element)XPath.selectSingleNode(returnDoc, "//Report/Body/Table/TableRows/TableRow/TableCells/TableCell/Value");
			tProductCodeElement = (Element)XPath.selectSingleNode(returnDoc, "//Report/ReportProperties/Print/PageSettings/PaperSize/Name");
			System.out.println((new StringBuilder("���ձ���")).append(tProductCodeElement.getTextContent()).toString());
		}
		catch (JDOMException e)
		{
			e.printStackTrace();
		}
	}
}
