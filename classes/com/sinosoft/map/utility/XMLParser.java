// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLParser.java

package com.sinosoft.map.utility;

import com.lowagie.text.xml.XmlParser;
import com.sinosoft.map.style.pdf.OnlyTableBodyStyle;
import com.sinosoft.map.style.pdf.TableHeadStyle;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.*;
import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

// Referenced classes of package com.sinosoft.map.utility:
//			TransferData, Header, XmlTable, CommonArray, 
//			SSRS

public class XMLParser
{

	private static final Logger logger = Logger.getLogger(com/sinosoft/map/utility/XMLParser);

	public XMLParser()
	{
	}

	public static TransferData getHeader(String filePath)
	{
		TransferData rTransferData = new TransferData();
		List headers = new LinkedList();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(filePath));
			Element config = document.getDocumentElement();
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder("getHeader(String) - the root element is ")).append(config.getTagName()).toString());
			NodeList headerList = config.getElementsByTagName("header");
			Header head = null;
			for (int i = 0; i < headerList.getLength(); i++)
				headers.add(null);

			for (int i = 0; i < headerList.getLength(); i++)
			{
				Element header = (Element)headerList.item(i);
				String name = getTagContent(header, "name", "没有表头名字");
				String row = getTagContent(header, "row", "");
				String col = getTagContent(header, "col", "0");
				String order = getTagContent(header, "order", "0");
				String excit = getTagContent(header, "excit", "0");
				String parentIndex = getTagContent(header, "parentIndex", "-1");
				String codeName = getTagContent(header, "codeName", "null");
				head = new Header();
				head.setName(name);
				head.setCol(Integer.parseInt(col));
				head.setRow(Integer.parseInt(row));
				head.setOrder(Integer.parseInt(order));
				head.setExcit(Integer.parseInt(excit));
				head.setParentIndex(Integer.parseInt(parentIndex));
				head.setCodeName(codeName);
				int orderflag = Integer.parseInt(order) - 1;
				if (logger.isDebugEnabled())
					logger.debug((new StringBuilder("getHeader(String) - enter xml parse value----")).append(name).append("t").append(row).append("t").append(col).append("t").append(order).toString());
				if (orderflag > headers.size())
				{
					if (logger.isDebugEnabled())
						logger.debug((new StringBuilder("getHeader(String) - 解析XML出错：设置的顺序号应该小于整体header的个数。出错文件为：")).append(filePath).toString());
				} else
				{
					headers.set(orderflag, head);
				}
			}

			if (logger.isDebugEnabled())
				logger.debug("getHeader(String) - after sort---------");
			String colNum = getTagContent(config, "colnum", "0");
			String width = getTagContent(config, "width", "0");
			String widths[] = getTagContent(config, "widths", "2f,2f").split(",");
			String borderwidth = getTagContent(config, "borderwidth", "0");
			String fontname = getTagContent(config, "fontname", "0");
			String fontcolor[] = null;
			if (getTagContent(config, "fontcolor", null) != null)
				fontcolor = getTagContent(config, "fontcolor", null).split(",");
			String tablealign = getTagContent(config, "tablealign", "0");
			rTransferData.setNameAndValue("Header", headers);
			rTransferData.setNameAndValue("ColMaxNumber", colNum);
			rTransferData.setNameAndValue("TableWidth", width);
			rTransferData.setNameAndValue("TableWidths", widths);
			rTransferData.setNameAndValue("BorderWidth", borderwidth);
			rTransferData.setNameAndValue("TableAlign", tablealign);
			rTransferData.setNameAndValue("FontName", fontname);
			rTransferData.setNameAndValue("FontColor", fontcolor);
		}
		catch (ParserConfigurationException e)
		{
			logger.error("getHeader(String)", e);
		}
		catch (IOException e)
		{
			logger.error("getHeader(String)", e);
		}
		catch (SAXException saxexception) { }
		return rTransferData;
	}

	public XmlTable getHeaderMap(String filePath)
	{
		XmlTable xmlTable = new XmlTable();
		TableHeadStyle tableHeadStyle = new TableHeadStyle();
		List headers = new LinkedList();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(filePath));
			Element config = document.getDocumentElement();
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder("getHeader(String) - the root element is ")).append(config.getTagName()).toString());
			NodeList headerList = config.getElementsByTagName("header");
			Header head = null;
			for (int i = 0; i < headerList.getLength(); i++)
				headers.add(null);

			for (int i = 0; i < headerList.getLength(); i++)
			{
				Element header = (Element)headerList.item(i);
				String name = getTagContent(header, "name", "没有表头名字");
				String row = getTagContent(header, "row", "");
				String col = getTagContent(header, "col", "0");
				String order = getTagContent(header, "order", "0");
				String wsorder = getTagContent(header, "wsorder", "-1");
				String excit = getTagContent(header, "excit", "0");
				String parentIndex = getTagContent(header, "parentindex", "-1");
				String codeName = getTagContent(header, "codename", "null");
				head = new Header();
				head.setName(name);
				head.setCol(Integer.parseInt(col));
				head.setRow(Integer.parseInt(row));
				head.setOrder(Integer.parseInt(order));
				head.setWsorder(Integer.parseInt(wsorder));
				head.setExcit(Integer.parseInt(excit));
				head.setParentIndex(Integer.parseInt(parentIndex));
				head.setCodeName(codeName);
				int orderflag = Integer.parseInt(order);
				if (logger.isDebugEnabled())
					logger.debug((new StringBuilder("getHeader(String) - enter xml parse value----")).append(name).append("t").append(row).append("t").append(col).append("t").append(order).toString());
				if (orderflag > headers.size())
				{
					if (logger.isDebugEnabled())
						logger.debug((new StringBuilder("getHeader(String) - 解析XML出错：设置的顺序号应该小于整体header的个数。出错文件为：")).append(filePath).toString());
				} else
				{
					headers.set(orderflag, head);
				}
			}

			if (logger.isDebugEnabled())
				logger.debug("getHeader(String) - after sort---------");
			String colNum = getTagContent(config, "colnum", "0");
			String width = getTagContent(config, "width", "0");
			String widths[] = getTagContent(config, "widths", "2f,2f").split(",");
			String borderwidth = getTagContent(config, "borderwidth", "0");
			String fontname = getTagContent(config, "fontname", "0");
			String fontColor[] = getTagContent(config, "fontcolor", "0,0,0").split(",");
			String BackColor[] = getTagContent(config, "fontcolor", "217,217,217").split(",");
			String tablealign = getTagContent(config, "tablealign", "0");
			xmlTable.setHeaders(headers);
			tableHeadStyle.setCol(Integer.parseInt(colNum));
			tableHeadStyle.setWidth(Float.parseFloat(width));
			tableHeadStyle.setWidths(CommonArray.stringToFloat(widths));
			tableHeadStyle.setBorder(Integer.parseInt(borderwidth));
			tableHeadStyle.setTableAlign(Integer.parseInt(tablealign));
			tableHeadStyle.setFontName(Integer.parseInt(fontname));
			int intfontcolor[] = CommonArray.stringToInt(fontColor);
			tableHeadStyle.setColor(intfontcolor[0], intfontcolor[1], intfontcolor[2]);
			int intBackcolor[] = CommonArray.stringToInt(BackColor);
			tableHeadStyle.setR(intBackcolor[0]);
			tableHeadStyle.setG(intBackcolor[0]);
			tableHeadStyle.setB(intBackcolor[0]);
			xmlTable.setTableHeadStyle(tableHeadStyle);
		}
		catch (ParserConfigurationException e)
		{
			logger.error("getHeader(String)", e);
		}
		catch (IOException e)
		{
			logger.error("getHeader(String)", e);
		}
		catch (Exception ex)
		{
			logger.error("getHeader(String)", ex);
		}
		return xmlTable;
	}

	public OnlyTableBodyStyle getbody(String filePath)
	{
		XmlParser xmlParser = new XmlParser();
		OnlyTableBodyStyle onlyTableBodyStyle = new OnlyTableBodyStyle();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(filePath));
			Element config = document.getDocumentElement();
			logger.debug((new StringBuilder("getbody(String) - the root element is ")).append(config.getTagName()).toString());
			logger.debug("getbody(String) - after sort---------");
			int colNum = Integer.parseInt(getTagContent(config, "colnum", "0"));
			onlyTableBodyStyle.setCol(colNum);
			int width = Integer.parseInt(getTagContent(config, "width", "100"));
			onlyTableBodyStyle.setWidth(width);
			if (getTagContent(config, "widths", null).split(",") != null)
			{
				String strAryWidths[] = getTagContent(config, "widths", null).split(",");
				float fltAryWidths[] = new float[strAryWidths.length];
				for (int i = 0; i < strAryWidths.length; i++)
					fltAryWidths[i] = Float.parseFloat(strAryWidths[i]);

			}
			int borderwidth = Integer.parseInt(getTagContent(config, "borderwidth", "0"));
			onlyTableBodyStyle.setBorder(borderwidth);
			int Spadding = Integer.parseInt(getTagContent(config, "Spadding", "0"));
			onlyTableBodyStyle.setSpacing(Spadding);
			int fontname = Integer.parseInt(getTagContent(config, "fontname", "0"));
			onlyTableBodyStyle.setFontName(fontname);
			if (getTagContent(config, "fontcolor", null) != null)
			{
				String fontcolor[] = getTagContent(config, "fontcolor", null).split(",");
				int intAryFontcolor[] = new int[3];
				for (int i = 0; i < fontcolor.length; i++)
					intAryFontcolor[i] = Integer.parseInt(fontcolor[i]);

				onlyTableBodyStyle.setColor(intAryFontcolor[0], intAryFontcolor[1], intAryFontcolor[2]);
			}
			if (getTagContent(config, "tablealign", null) != null)
			{
				int tablealign = Integer.parseInt(getTagContent(config, "tablealign", null));
				onlyTableBodyStyle.setAlign(tablealign);
			}
		}
		catch (ParserConfigurationException e)
		{
			logger.error((new StringBuilder("getbody(String)-读取")).append(filePath).append("失败cinfig").toString(), e);
		}
		catch (IOException e)
		{
			logger.error((new StringBuilder("getbody(String)-读取")).append(filePath).append("失败io").toString(), e);
		}
		catch (Exception ex)
		{
			logger.error("getHeader(String)", ex);
		}
		return onlyTableBodyStyle;
	}

	private int changeIntReadTag(String tagContent)
	{
		int reTagContect = -1;
		if (tagContent != null)
			reTagContect = Integer.parseInt(tagContent);
		return reTagContect;
	}

	public static String read(String filePath)
	{
		TransferData rTransferData = new TransferData();
		List headers = new LinkedList();
		String content = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(filePath));
			Element config = document.getDocumentElement();
			String name = getTagContentOne(config, "name");
			content = getTagContentOne(config, "content");
			if (content.trim().equals(""))
				content = null;
		}
		catch (ParserConfigurationException e)
		{
			logger.error("read(String)", e);
		}
		catch (IOException e)
		{
			logger.error("read(String)", e);
		}
		catch (SAXException saxexception) { }
		return content;
	}

	public static SSRS getHeaderContent(String filePath)
	{
		SSRS headers = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(filePath));
			Element config = document.getDocumentElement();
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder("getHeaderContent(String) - the root element is ")).append(config.getTagName()).toString());
			NodeList headerList = config.getElementsByTagName("header");
			String colNum = getTagContent(config, "colnum", Integer.toString(headerList.getLength()));
			headers = new SSRS(Integer.parseInt(colNum));
			for (int i = 0; i < headerList.getLength(); i++)
			{
				Element header = (Element)headerList.item(i);
				String name = getTagContent(header, "name", "没设置表头名字");
				String order = getTagContent(header, "order", Integer.toString(i));
				int orderflag = Integer.parseInt(order) - 1;
				if (orderflag > headers.getMaxNumber())
				{
					if (logger.isDebugEnabled())
						logger.debug((new StringBuilder("getHeaderContent(String) - 解析XML出错：设置的顺序号应该小于整体header的个数。出错文件为：")).append(filePath).toString());
				} else
				{
					headers.SetText(name);
				}
			}

			if (logger.isDebugEnabled())
				logger.debug("getHeaderContent(String) - after sort---------");
		}
		catch (ParserConfigurationException e1)
		{
			logger.error("getHeaderContent(String)", e1);
		}
		catch (SAXException e)
		{
			logger.error("getHeaderContent(String)", e);
		}
		catch (IOException e)
		{
			logger.error("getHeaderContent(String)", e);
		}
		return headers;
	}

	public static String getTagContent(Element element, String tagName, String reInData)
	{
		NodeList list = element.getElementsByTagName(tagName);
		Node nameNode = list.item(0);
		if (nameNode == null)
		{
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder("getTagContent(Element, String) - 解析XML时，")).append(tagName).append("的值为null！").toString());
			return reInData;
		}
		NodeList nodeList = nameNode.getChildNodes();
		Node node = nodeList.item(0);
		if (node == null || node.getNodeValue() == null)
			return reInData;
		else
			return node.getNodeValue();
	}

	public static String getTagContentOne(Element element, String tagName)
	{
		NodeList list = element.getElementsByTagName(tagName);
		Node nameNode = list.item(0);
		if (nameNode == null)
		{
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder("getTagContentOne(Element, String) - 解析XML时，")).append(tagName).append("的值为null！").toString());
			return null;
		}
		NodeList nodeList = nameNode.getChildNodes();
		Node node = nodeList.item(0);
		String nodeValue = null;
		if (node.getNodeValue() == null)
			return null;
		if (node.getNodeValue().trim() != "")
			nodeValue = node.getNodeValue();
		return nodeValue;
	}

	public static Element getElement(String filePath)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		Element config = null;
		try
		{
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File(filePath));
			config = document.getDocumentElement();
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return config;
	}

	public static Element createElement(String root, String groupTagName, List content)
	{
		String tags[] = {
			"content", "size", "font", "style", "align", "isStart", "isEnd", "space"
		};
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		Element config = null;
		try
		{
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
			config = document.createElement(root);
			Element element = null;
			TransferData prop = null;
			for (int i = 0; i < content.size(); i++)
			{
				element = document.createElement(groupTagName);
				config.appendChild(element);
				prop = (TransferData)content.get(i);
				for (int j = 0; j < tags.length; j++)
					appendElement(prop, tags[j], element, document);

			}

		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		return config;
	}

	public static void appendElement(TransferData prop, String tagName, Element fatherElement, Document doc)
	{
		String content = (String)prop.getValueByName(tagName);
		Element element = doc.createElement(tagName);
		fatherElement.appendChild(element);
		org.w3c.dom.Text text = doc.createTextNode(content);
		element.appendChild(text);
	}

}
