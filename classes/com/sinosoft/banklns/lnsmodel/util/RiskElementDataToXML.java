// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RiskElementDataToXML.java

package com.sinosoft.banklns.lnsmodel.util;

import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class RiskElementDataToXML
{

	private List initControlSet;
	private String riskCode;
	private String riskName;
	private String riskArticleURL;
	private String riskRateUrl;
	private String riskRules;
	private List showOrHideList;
	private List relaControlCodeAndValueList;
	private Set initValues;

	public RiskElementDataToXML()
	{
		initControlSet = new ArrayList();
		riskCode = "";
		riskName = "";
		riskArticleURL = "";
		riskRateUrl = "";
		riskRules = "";
		showOrHideList = new ArrayList();
		relaControlCodeAndValueList = new ArrayList();
		initValues = new HashSet();
	}

	public void addShowOrHideControl(String controlCode, String dispaly)
	{
		if (controlCode != null && controlCode.length() > 0)
		{
			String temp[] = new String[2];
			temp[0] = controlCode;
			temp[1] = dispaly;
			showOrHideList.add(temp);
		}
	}

	public void addShowOrHideControls(String showOrHideArray[][])
	{
		for (int i = 0; showOrHideArray != null && showOrHideArray.length > 0; i++)
		{
			String temp[] = showOrHideArray[i];
			showOrHideList.add(temp);
		}

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

	public void addRelaControlCodeAndValueList(String code, String type, String value, String readonly)
	{
		if (code != null && code.length() > 0)
		{
			String temp[] = new String[4];
			temp[0] = code;
			temp[1] = type;
			temp[2] = value;
			temp[3] = readonly;
			relaControlCodeAndValueList.add(temp);
		}
	}

	public void addRelaControlCodeAndValueLists(String showOrHideArray[][])
	{
		for (int i = 0; showOrHideArray != null && showOrHideArray.length > 0; i++)
		{
			String temp[] = showOrHideArray[i];
			relaControlCodeAndValueList.add(temp);
		}

	}

	public void addInitControlObject(String controlCode, String controlName, String controlType, String initValue, String prepareValue, String editable)
	{
		if (controlCode == null || controlCode.length() == 0)
			return;
		if (controlName == null || controlName.length() == 0)
			controlName = "";
		if (controlType == null || controlType.length() == 0)
			controlType = "";
		if (initValue == null || initValue.length() == 0)
			initValue = "";
		if (prepareValue == null || prepareValue.length() == 0)
			prepareValue = "";
		if (editable == null || editable.length() == 0)
			editable = "";
		String controlObj[] = new String[6];
		controlObj[0] = controlCode;
		controlObj[1] = controlName;
		controlObj[2] = controlType;
		controlObj[3] = initValue;
		controlObj[4] = prepareValue;
		controlObj[5] = editable;
		initControlSet.add(controlObj);
	}

	public void addInitControlObjects(String controlArray[][])
	{
		for (int i = 0; controlArray != null && controlArray.length > i; i++)
		{
			String temp[] = controlArray[i];
			initControlSet.add(temp);
		}

	}

	public String getRiskArticleURL()
	{
		return riskArticleURL;
	}

	public void setRiskArticleURL(String riskArticleURL)
	{
		this.riskArticleURL = riskArticleURL;
	}

	public String getRiskcode()
	{
		return riskCode;
	}

	public void setRiskcode(String riskcode)
	{
		riskCode = riskcode;
	}

	public String getRiskName()
	{
		return riskName;
	}

	public void setRiskName(String riskName)
	{
		this.riskName = riskName;
	}

	public String getRiskRateUrl()
	{
		return riskRateUrl;
	}

	public void setRiskRateUrl(String riskRateUrl)
	{
		this.riskRateUrl = riskRateUrl;
	}

	public String getRiskRules()
	{
		return riskRules;
	}

	public void setRiskRules(String riskRules)
	{
		this.riskRules = riskRules;
	}

	public void getResult(HttpServletResponse response)
	{
		Document doc = new Document();
		Element root = new Element("risk");
		root.setAttribute("riskCode", riskCode);
		root.setAttribute("riskName", riskName);
		root.setAttribute("riskRules", riskRules);
		root.setAttribute("riskRateUrl", riskRateUrl);
		root.setAttribute("riskArticleURL", riskArticleURL);
		doc.setRootElement(root);
		if (initControlSet.size() > 0)
		{
			Element RiskElementData = new Element("ControlObjects");
			Element objectElement;
			for (Iterator iterator = initControlSet.iterator(); iterator.hasNext(); RiskElementData.addContent(objectElement))
			{
				String controlObj[] = (String[])iterator.next();
				objectElement = new Element("Control");
				for (int i = 0; i < controlObj.length; i++)
				{
					String value = controlObj[i];
					String name = "";
					switch (i)
					{
					case 0: // '\0'
						name = "controlCode";
						break;

					case 1: // '\001'
						name = "controlName";
						break;

					case 2: // '\002'
						name = "controlType";
						break;

					case 3: // '\003'
						name = "initValue";
						break;

					case 4: // '\004'
						name = "prepareValue";
						break;

					case 5: // '\005'
						name = "editable";
						break;
					}
					objectElement.setAttribute(name, value);
				}

			}

			root.addContent(RiskElementData);
		}
		if (showOrHideList.size() > 0)
		{
			Element RiskElementData = new Element("HideOrShowObjects");
			Element objectElement;
			for (Iterator iterator = showOrHideList.iterator(); iterator.hasNext(); RiskElementData.addContent(objectElement))
			{
				String controlObj[] = (String[])iterator.next();
				objectElement = new Element("Control");
				for (int i = 0; i < controlObj.length; i++)
				{
					String value = controlObj[i];
					String name = "";
					switch (i)
					{
					case 0: // '\0'
						name = "controlCode";
						break;

					case 1: // '\001'
						name = "controlValue";
						break;
					}
					objectElement.setAttribute(name, value);
				}

			}

			root.addContent(RiskElementData);
		}
		if (relaControlCodeAndValueList.size() > 0)
		{
			Element RiskElementData = new Element("RelaValidateObjects");
			Element objectElement;
			for (Iterator iterator = relaControlCodeAndValueList.iterator(); iterator.hasNext(); RiskElementData.addContent(objectElement))
			{
				String controlObj[] = (String[])iterator.next();
				objectElement = new Element("Control");
				for (int i = 0; i < controlObj.length; i++)
				{
					String value = controlObj[i];
					String name = "";
					switch (i)
					{
					case 0: // '\0'
						name = "controlCode";
						break;

					case 1: // '\001'
						name = "controlType";
						break;

					case 2: // '\002'
						name = "controlValue";
						break;

					case 3: // '\003'
						name = "readOnly";
						break;
					}
					objectElement.setAttribute(name, value);
				}

			}

			root.addContent(RiskElementData);
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
}
