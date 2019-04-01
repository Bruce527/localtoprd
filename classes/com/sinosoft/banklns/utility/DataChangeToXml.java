// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DataChangeToXml.java

package com.sinosoft.banklns.utility;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class DataChangeToXml
{

	private String flag;
	private String tipmsg;
	private Set options;
	private Set initValues;
	private Set showOrHide;
	private Set changeObjectInnerHtml;
	private Set changeObjectInnerText;
	private Set changeObjectClassName;
	private Set tableData;
	private Set autoCompleteData;

	public DataChangeToXml()
	{
		flag = "";
		tipmsg = "";
		options = new HashSet();
		initValues = new HashSet();
		showOrHide = new HashSet();
		changeObjectInnerHtml = new HashSet();
		changeObjectInnerText = new HashSet();
		changeObjectClassName = new HashSet();
		tableData = new HashSet();
		autoCompleteData = new HashSet();
	}

	public void addOptions(String controlId, String value)
	{
		String keyvalue[] = new String[2];
		keyvalue[0] = controlId;
		keyvalue[1] = value;
		options.add(keyvalue);
	}

	public void addOptions(String keyAndOptionsvalue[][])
	{
		for (int i = 0; keyAndOptionsvalue != null && keyAndOptionsvalue.length > 0 && i < keyAndOptionsvalue.length; i++)
			options.add(keyAndOptionsvalue[i]);

	}

	public void addInitValues(String controlId, String value)
	{
		String keyvalue[] = new String[2];
		keyvalue[0] = controlId;
		keyvalue[1] = value;
		initValues.add(keyvalue);
	}

	public void addInitValues(String keyValue[][])
	{
		for (int i = 0; keyValue != null && keyValue.length > 0 && i < keyValue.length; i++)
			initValues.add(keyValue[i]);

	}

	public void addShowOrHide(String controlId, String value)
	{
		String keyvalue[] = new String[2];
		keyvalue[0] = controlId;
		keyvalue[1] = value;
		showOrHide.add(keyvalue);
	}

	public void addShowOrHide(String keyValue[][])
	{
		for (int i = 0; keyValue != null && keyValue.length > 0 && i < keyValue.length; i++)
			showOrHide.add(keyValue[i]);

	}

	public void addChangeObjectInnerHtml(String controlId, String value)
	{
		String keyvalue[] = new String[2];
		keyvalue[0] = controlId;
		keyvalue[1] = value;
		changeObjectInnerHtml.add(keyvalue);
	}

	public void addChangeObjectInnerHtml(String keyValue[][])
	{
		for (int i = 0; keyValue != null && keyValue.length > 0 && i < keyValue.length; i++)
			changeObjectInnerHtml.add(keyValue[i]);

	}

	public void addChangeObjectInnerText(String controlId, String value)
	{
		String keyvalue[] = new String[2];
		keyvalue[0] = controlId;
		keyvalue[1] = value;
		changeObjectInnerText.add(keyvalue);
	}

	public void addChangeObjectInnerText(String keyValue[][])
	{
		for (int i = 0; keyValue != null && keyValue.length > 0 && i < keyValue.length; i++)
			changeObjectInnerText.add(keyValue[i]);

	}

	public void addChangeObjectClassName(String controlId, String value)
	{
		String keyvalue[] = new String[2];
		keyvalue[0] = controlId;
		keyvalue[1] = value;
		changeObjectClassName.add(keyvalue);
	}

	public void addChangeObjectClassName(String keyValue[][])
	{
		for (int i = 0; keyValue != null && keyValue.length > 0 && i < keyValue.length; i++)
			changeObjectClassName.add(keyValue[i]);

	}

	public void addTableData(String data[][], String tableId, int totalRecords, int totalPages, int currentPage, int recordsOfPage)
	{
		List list = new ArrayList();
		list.add(tableId);
		list.add(data);
		list.add(Integer.valueOf(totalRecords));
		list.add(Integer.valueOf(totalPages));
		list.add(Integer.valueOf(currentPage));
		list.add(Integer.valueOf(recordsOfPage));
		tableData.add(list);
	}

	public void addCompleteData(String autoId, String targetId, String textRelaControlId, String contentContentId, String itemData[][])
	{
		List list = new ArrayList();
		list.add(autoId);
		list.add(targetId);
		list.add(textRelaControlId);
		list.add(contentContentId);
		list.add(itemData);
		autoCompleteData.add(list);
	}

	public void getResult(HttpServletResponse response)
	{
		Document doc = new Document();
		Element root = new Element("data");
		root.setAttribute("flag", flag);
		root.setAttribute("tipmsg", tipmsg);
		doc.setRootElement(root);
		if (options.size() > 0)
		{
			Element initOptionsElement = new Element("initOptions");
			Element optionElement;
			for (Iterator iterator = options.iterator(); iterator.hasNext(); initOptionsElement.addContent(optionElement))
			{
				String option[] = (String[])iterator.next();
				optionElement = new Element("Control");
				optionElement.setAttribute("id", option[0]);
				optionElement.setText(option[1]);
			}

			root.addContent(initOptionsElement);
		}
		if (initValues.size() > 0)
		{
			Element initValuesElement = new Element("initValues");
			Element controlElement;
			for (Iterator iterator = initValues.iterator(); iterator.hasNext(); initValuesElement.addContent(controlElement))
			{
				String option[] = (String[])iterator.next();
				controlElement = new Element("Control");
				controlElement.setAttribute("id", option[0]);
				controlElement.setText(option[1]);
			}

			root.addContent(initValuesElement);
		}
		if (showOrHide.size() > 0)
		{
			Element showOrHideElement = new Element("showOrHides");
			Element objectElement;
			for (Iterator iterator = showOrHide.iterator(); iterator.hasNext(); showOrHideElement.addContent(objectElement))
			{
				String option[] = (String[])iterator.next();
				objectElement = new Element("Object");
				objectElement.setAttribute("id", option[0]);
				objectElement.setText(option[1]);
			}

			root.addContent(showOrHideElement);
		}
		if (changeObjectInnerHtml.size() > 0)
		{
			Element changeObjectInnerHtmlElement = new Element("changeObjectInnerHtmls");
			Element objectElement;
			for (Iterator iterator = changeObjectInnerHtml.iterator(); iterator.hasNext(); changeObjectInnerHtmlElement.addContent(objectElement))
			{
				String option[] = (String[])iterator.next();
				objectElement = new Element("Object");
				objectElement.setAttribute("id", option[0]);
				objectElement.setText(option[1]);
			}

			root.addContent(changeObjectInnerHtmlElement);
		}
		if (changeObjectInnerText.size() > 0)
		{
			Element changeObjectInnerTextElement = new Element("changeObjectInnerTexts");
			Element objectElement;
			for (Iterator iterator = changeObjectInnerText.iterator(); iterator.hasNext(); changeObjectInnerTextElement.addContent(objectElement))
			{
				String option[] = (String[])iterator.next();
				objectElement = new Element("Object");
				objectElement.setAttribute("id", option[0]);
				objectElement.setText(option[1]);
			}

			root.addContent(changeObjectInnerTextElement);
		}
		if (changeObjectClassName.size() > 0)
		{
			Element changeObjectClassNameElement = new Element("changeObjectClassNames");
			Element objectElement;
			for (Iterator iterator = changeObjectClassName.iterator(); iterator.hasNext(); changeObjectClassNameElement.addContent(objectElement))
			{
				String option[] = (String[])iterator.next();
				objectElement = new Element("Object");
				objectElement.setAttribute("id", option[0]);
				objectElement.setText(option[1]);
			}

			root.addContent(changeObjectClassNameElement);
		}
		if (this.tableData.size() > 0)
		{
			Element changeTableDataElement = new Element("changeTableData");
			Element objectElement;
			for (Iterator iterator = this.tableData.iterator(); iterator.hasNext(); changeTableDataElement.addContent(objectElement))
			{
				List tableList = (List)iterator.next();
				String id = (String)tableList.get(0);
				int totalRecords = ((Integer)tableList.get(2)).intValue();
				int totalPages = ((Integer)tableList.get(3)).intValue();
				int currentPage = ((Integer)tableList.get(4)).intValue();
				int recordsOfPage = ((Integer)tableList.get(5)).intValue();
				objectElement = new Element("table");
				objectElement.setAttribute("id", id);
				objectElement.setAttribute("totalRecords", (new StringBuilder(String.valueOf(totalRecords))).toString());
				objectElement.setAttribute("totalPages", (new StringBuilder(String.valueOf(totalPages))).toString());
				objectElement.setAttribute("currentPage", (new StringBuilder(String.valueOf(currentPage))).toString());
				objectElement.setAttribute("recordsOfPage", (new StringBuilder(String.valueOf(recordsOfPage))).toString());
				String tableData[][] = (String[][])tableList.get(1);
				for (int j = 0; tableData != null && tableData.length > j; j++)
				{
					Element eltTr = new Element("tr");
					String tdArray[] = tableData[j];
					for (int k = 0; tdArray != null && tdArray.length > k; k++)
					{
						Element eltTd = new Element("td");
						eltTd.setText(tdArray[k]);
						eltTr.addContent(eltTd);
					}

					objectElement.addContent(eltTr);
				}

			}

			root.addContent(changeTableDataElement);
		}
		if (autoCompleteData.size() > 0)
		{
			Element autoCompleteObjsElement = new Element("autoCompleteObjs");
			Element objectElement;
			for (Iterator iterator = autoCompleteData.iterator(); iterator.hasNext(); autoCompleteObjsElement.addContent(objectElement))
			{
				List tableList = (List)iterator.next();
				String autoId = (String)tableList.get(0);
				String targetId = (String)tableList.get(1);
				String textRelaControlId = (String)tableList.get(2);
				String contentContentId = (String)tableList.get(3);
				String itemData[][] = (String[][])tableList.get(4);
				if (textRelaControlId == null)
					textRelaControlId = "";
				if (contentContentId == null)
					contentContentId = "";
				objectElement = new Element("Obejct");
				objectElement.setAttribute("autoId", autoId);
				objectElement.setAttribute("targetId", targetId);
				objectElement.setAttribute("textRelaControlId", textRelaControlId);
				objectElement.setAttribute("contentContentId", contentContentId);
				for (int j = 0; itemData != null && itemData.length > j; j++)
				{
					Element eltItem = new Element("Item");
					String itemArray[] = itemData[j];
					eltItem.setAttribute("text", itemArray[0]);
					eltItem.setAttribute("content", itemArray[1]);
					objectElement.addContent(eltItem);
				}

			}

			root.addContent(autoCompleteObjsElement);
		}
		XMLOutputter xmlOut = new XMLOutputter();
		Format fmt = Format.getPrettyFormat();
		fmt.setIndent("    ");
		fmt.setEncoding("UTF-8");
		xmlOut.setFormat(fmt);
		try
		{
			response.resetBuffer();
			response.setContentType("text/xml");
			response.setCharacterEncoding("UTF-8");
			xmlOut.output(doc, response.getWriter());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String agrs[])
	{
		long start = (new Date()).getTime();
		DataChangeToXml trDataChangeToXml = new DataChangeToXml();
		trDataChangeToXml.addInitValues("Age", "26");
		trDataChangeToXml.addOptions("Kai", "osd=ii&idas=asdak");
		String data[][] = new String[3][4];
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 4; j++)
				data[i][j] = (new StringBuilder(String.valueOf(i))).append(".").append(j).toString();

		}

		trDataChangeToXml.addTableData(data, "CustomTable", 12, 3, 1, 10);
		long end = (new Date()).getTime();
		System.out.println((new StringBuilder("����ʱ�䣺")).append(end - start).append("ms").toString());
	}

	public void setErrormsg(String tipmsg)
	{
		this.tipmsg = tipmsg;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}
}
