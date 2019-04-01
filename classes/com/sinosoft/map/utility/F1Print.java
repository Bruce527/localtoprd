// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   F1Print.java

package com.sinosoft.map.utility;

import java.io.InputStream;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.sinosoft.map.utility:
//			XMLPathTool

public class F1Print
{

	private String strXMLFileName;
	private XMLPathTool aTest;
	private Node m_nodeMultiRow;
	private boolean m_bBOF;

	public F1Print()
	{
		m_nodeMultiRow = null;
		m_bBOF = false;
	}

	public F1Print(String argXMLFile)
	{
		m_nodeMultiRow = null;
		m_bBOF = false;
		setFileName(argXMLFile);
	}

	public F1Print(InputStream in)
	{
		m_nodeMultiRow = null;
		m_bBOF = false;
		strXMLFileName = "";
		aTest = new XMLPathTool(in);
	}

	public void setFileName(String argFileName)
	{
		strXMLFileName = argFileName;
		aTest = new XMLPathTool(strXMLFileName);
	}

	public String getTemplate()
	{
		Node node = aTest.parseX("/DATASET/CONTROL/TEMPLATE");
		return getNodeValue(node);
	}

	public String getNodeValue(String argXPath)
	{
		Node node = aTest.parseX(argXPath);
		return getNodeValue(node);
	}

	public String getDisplayControl(String strName)
	{
		Node node = aTest.parseX((new StringBuilder("/DATASET/CONTROL/DISPLAY")).append(strName).toString());
		return getNodeValue(node);
	}

	public String[] getNodeListValue(String argXPath, String argChildPath)
	{
		NodeList nodeList = aTest.parseN((new StringBuilder(String.valueOf(argXPath))).append("/").append(argChildPath).toString());
		String nVal[] = null;
		if (nodeList == null)
		{
			nVal = new String[0];
		} else
		{
			nVal = new String[nodeList.getLength()];
			for (int i = 0; i < nodeList.getLength(); i++)
				if (nodeList.item(i).getFirstChild().equals("null"))
					nVal[i] = "";
				else
					nVal[i] = nodeList.item(i).getFirstChild().getNodeValue();

		}
		return nVal;
	}

	public void query(String argXPath)
	{
		m_nodeMultiRow = aTest.parseX(argXPath);
		m_bBOF = true;
	}

	public boolean next()
	{
		boolean bReturn = true;
		if (m_nodeMultiRow == null)
			bReturn = false;
		else
		if (m_bBOF)
		{
			bReturn = true;
			m_bBOF = false;
		} else
		{
			bReturn = false;
			for (m_nodeMultiRow = m_nodeMultiRow.getNextSibling(); m_nodeMultiRow != null; m_nodeMultiRow = m_nodeMultiRow.getNextSibling())
			{
				if (m_nodeMultiRow.getNodeType() != 1)
					continue;
				bReturn = true;
				break;
			}

		}
		return bReturn;
	}

	public String getString(String strChildPath)
	{
		String strReturn = "";
		if (m_nodeMultiRow == null)
			return "";
		Node node = null;
		NodeList nodeList = m_nodeMultiRow.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			node = nodeList.item(i);
			if (!node.getNodeName().equals(strChildPath))
				continue;
			node = node.getFirstChild();
			if (node != null)
				strReturn = node.getNodeValue();
			else
				strReturn = "";
			break;
		}

		return strReturn;
	}

	public String getString(int nIndex)
	{
		String strReturn = "";
		if (nIndex < 0 || m_nodeMultiRow == null)
			return "";
		Node node = m_nodeMultiRow.getChildNodes().item(nIndex);
		NodeList nodeList = m_nodeMultiRow.getChildNodes();
		int nItem = 0;
		for (int nCount = 0; nCount < nodeList.getLength(); nCount++)
		{
			node = nodeList.item(nCount);
			if (node.getNodeType() != 1)
				continue;
			if (nItem == nIndex)
				break;
			nItem++;
		}

		node = node.getFirstChild();
		if (node != null)
			strReturn = node.getNodeValue();
		else
			strReturn = "";
		return strReturn;
	}

	public int getColCount()
	{
		if (m_nodeMultiRow == null)
			return -1;
		Node node = null;
		NodeList nodeList = m_nodeMultiRow.getChildNodes();
		if (nodeList == null)
			return -1;
		int nCount = 0;
		for (int nIndex = 0; nIndex < nodeList.getLength(); nIndex++)
			if (nodeList.item(nIndex).getNodeType() == 1)
				nCount++;

		return nCount;
	}

	public int getColIndex(String strChildPath)
	{
		if (m_nodeMultiRow == null)
			return -1;
		Node node = null;
		NodeList nodeList = m_nodeMultiRow.getChildNodes();
		boolean bFound = false;
		int nIndex = -1;
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			node = nodeList.item(i);
			if (node.getNodeType() != 1)
				continue;
			nIndex++;
			if (!node.getNodeName().equals(strChildPath))
				continue;
			bFound = true;
			break;
		}

		if (!bFound)
			nIndex = -1;
		return nIndex;
	}

	public String getNodeValue(Node node)
	{
		if (node == null)
			return "";
		if (node.getFirstChild() == null)
			return "";
		else
			return node.getFirstChild().getNodeValue();
	}

	public static void main(String args1[])
	{
	}
}
