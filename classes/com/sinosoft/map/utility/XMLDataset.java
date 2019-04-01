// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLDataset.java

package com.sinosoft.map.utility;

import java.lang.reflect.Field;
import java.util.Vector;
import org.jdom.Element;

// Referenced classes of package com.sinosoft.map.utility:
//			CErrors, XMLDataObject, Schema, SchemaSet, 
//			CError

public class XMLDataset
{

	private Element _Element;
	private CErrors mErrors;

	protected XMLDataset()
	{
		mErrors = new CErrors();
		_Element = new Element("DATASET");
		if (!createControlInfo())
			_Element = null;
	}

	protected XMLDataset(Element element)
	{
		mErrors = new CErrors();
		_Element = element;
		if (!createControlInfo())
			_Element = null;
	}

	private boolean createControlInfo()
	{
		if (_Element == null)
		{
			return false;
		} else
		{
			Element elementControl = new Element("CONTROL");
			_Element.addContent(elementControl);
			elementControl.addContent((new Element("CONTTYPE")).addContent(""));
			elementControl.addContent((new Element("TEMPLATE")).addContent(""));
			elementControl.addContent((new Element("PRINTER")).addContent(""));
			elementControl.addContent((new Element("DISPLAY")).addContent(""));
			return true;
		}
	}

	public Element getElement()
	{
		if (_Element == null)
			return null;
		else
			return (Element)_Element.clone();
	}

	public XMLDataset addDisplayControl(String strName)
	{
		if (_Element == null)
		{
			return null;
		} else
		{
			Element elementControl = _Element.getChild("CONTROL").getChild("DISPLAY");
			elementControl.addContent((new Element(strName)).addContent("1"));
			return this;
		}
	}

	public XMLDataset setTemplate(String strTemplate)
	{
		if (_Element == null)
		{
			return null;
		} else
		{
			_Element.getChild("CONTROL").getChild("TEMPLATE").setText(strTemplate);
			return this;
		}
	}

	public XMLDataset setPrinter(String strPrinter)
	{
		if (_Element == null)
		{
			return null;
		} else
		{
			_Element.getChild("CONTROL").getChild("PRINTER").setText(strPrinter);
			return this;
		}
	}

	public XMLDataset setContType(String strContType)
	{
		if (_Element == null)
		{
			return null;
		} else
		{
			_Element.getChild("CONTROL").getChild("CONTTYPE").setText(strContType);
			return this;
		}
	}

	public boolean addDataObject(XMLDataObject xmlDataObject)
	{
		if (xmlDataObject.getDataObjectID().equals(""))
			xmlDataObject.setDataObjectID("");
		return xmlDataObject.addDataTo(_Element);
	}

	public boolean addSchema(Schema schema)
	{
		mErrors.clearErrors();
		if (schema == null)
		{
			buildError("addSchema", "参数为空");
			return false;
		}
		if (schema.getClass().getSuperclass().getName().equals("com.sinosoft.map.lis.Schema"))
		{
			buildError("addSchema", "参数不是Schema的直接子类");
			return false;
		}
		String strClassName = schema.getClass().getName();
		strClassName = strClassName.substring(strClassName.lastIndexOf(".") + 1);
		strClassName = strClassName.substring(0, strClassName.indexOf("Schema"));
		Field fields[] = schema.getClass().getDeclaredFields();
		for (int nIndex = 0; nIndex < fields.length; nIndex++)
		{
			String strFieldName = fields[nIndex].getName();
			if (!strFieldName.equals("FIELDNUM") && !strFieldName.equals("PK") && !strFieldName.equals("mErrors") && !strFieldName.equals("fDate"))
			{
				String strFieldType = fields[nIndex].getType().getName();
				String strFieldValue = schema.getV(strFieldName);
				if (strFieldType.equals("float") && !strFieldValue.equals("-100.0"))
					_Element.addContent((new Element((new StringBuilder(String.valueOf(strClassName))).append(".").append(strFieldName).toString())).addContent(strFieldValue));
				else
				if (strFieldType.equals("int") && !strFieldValue.equals("-100"))
					_Element.addContent((new Element((new StringBuilder(String.valueOf(strClassName))).append(".").append(strFieldName).toString())).addContent(strFieldValue));
				else
				if (strFieldType.equals("double") && !strFieldValue.equals("-100"))
					_Element.addContent((new Element((new StringBuilder(String.valueOf(strClassName))).append(".").append(strFieldName).toString())).addContent(strFieldValue));
				else
				if (strFieldType.equals("java.lang.String") && !strFieldValue.equals("null"))
					_Element.addContent((new Element((new StringBuilder(String.valueOf(strClassName))).append(".").append(strFieldName).toString())).addContent(strFieldValue));
				else
				if (strFieldType.equals("java.util.Date") && !strFieldValue.equals("null"))
				{
					if (strFieldValue.indexOf('-') != -1)
						strFieldValue = (new StringBuilder(String.valueOf(strFieldValue.substring(0, 4)))).append("年").append(strFieldValue.substring(5, 7)).append("月").append(strFieldValue.substring(8, 10)).append("日").toString();
					_Element.addContent((new Element((new StringBuilder(String.valueOf(strClassName))).append(".").append(strFieldName).toString())).addContent(strFieldValue));
				} else
				{
					_Element.addContent((new Element((new StringBuilder(String.valueOf(strClassName))).append(".").append(strFieldName).toString())).addContent(""));
				}
			}
		}

		return true;
	}

	public boolean addSchemaSet(SchemaSet schemaSet, String strID)
	{
		mErrors.clearErrors();
		if (schemaSet == null || strID == null)
		{
			buildError("addSchemaSet", "参数有错");
			return false;
		}
		if (schemaSet.getClass().getSuperclass().getName().equals("com.sinosoft.map.lis.SchemaSet"))
		{
			buildError("addSchemaSet", "参数不是SchemaSet的直接子类");
			return false;
		}
		String strClassName = schemaSet.getClass().getName();
		strClassName = strClassName.substring(strClassName.lastIndexOf(".") + 1);
		strClassName = strClassName.substring(0, strClassName.indexOf("Set"));
		Element eleList = null;
		if (strID.equals(""))
			eleList = new Element(strClassName);
		else
			eleList = new Element(strID);
		_Element.addContent(eleList);
		strClassName = (new StringBuilder("com.sinosoft.map.lis.schema.")).append(strClassName).append("Schema").toString();
		Field fields[] = null;
		Vector vFields = new Vector();
		try
		{
			fields = Class.forName(strClassName).getDeclaredFields();
		}
		catch (ClassNotFoundException ex)
		{
			buildError("addSchemaSet", "找不到对应的Schema类");
			return false;
		}
		Element eleHead = new Element("HEAD");
		eleList.addContent(eleHead);
		String strColName = "";
		int nColNum = 0;
		for (int nIndex = 0; nIndex < fields.length; nIndex++)
		{
			String strFieldName = fields[nIndex].getName();
			if (!strFieldName.equals("FIELDNUM") && !strFieldName.equals("PK") && !strFieldName.equals("mErrors") && !strFieldName.equals("fDate"))
			{
				strColName = (new StringBuilder("COL")).append(String.valueOf(nColNum++)).toString();
				eleHead.addContent((new Element(strColName)).addContent(strFieldName));
				vFields.add(fields[nIndex]);
			}
		}

		for (int nIndex = 0; nIndex < schemaSet.size(); nIndex++)
		{
			Element eleRow = new Element("ROW");
			eleList.addContent(eleRow);
			Schema schema = (Schema)schemaSet.getObj(nIndex + 1);
			nColNum = 0;
			for (int nCols = 0; nCols < vFields.size(); nCols++)
			{
				String strFieldName = ((Field)vFields.get(nCols)).getName();
				String strFieldType = ((Field)vFields.get(nCols)).getType().getName();
				String strFieldValue = schema.getV(strFieldName);
				strColName = (new StringBuilder("COL")).append(String.valueOf(nColNum++)).toString();
				if (strFieldType.equals("float") && !strFieldValue.equals("-100.0"))
					eleRow.addContent((new Element(strColName)).addContent(strFieldValue));
				else
				if (strFieldType.equals("double") && !strFieldValue.equals("-100.0"))
					eleRow.addContent((new Element(strColName)).addContent(strFieldValue));
				else
				if (strFieldType.equals("int") && !strFieldValue.equals("-100"))
					eleRow.addContent((new Element(strColName)).addContent(strFieldValue));
				else
				if (strFieldType.equals("java.lang.String") && !strFieldValue.equals("null"))
					eleRow.addContent((new Element(strColName)).addContent(strFieldValue));
				else
				if (strFieldType.equals("java.util.Date") && !strFieldValue.equals("null"))
				{
					if (strFieldValue.indexOf('-') != -1)
						strFieldValue = (new StringBuilder(String.valueOf(strFieldValue.substring(0, 4)))).append("年").append(strFieldValue.substring(5, 7)).append("月").append(strFieldValue.substring(8, 10)).append("日").toString();
					eleRow.addContent((new Element(strColName)).addContent(strFieldValue));
				} else
				{
					eleRow.addContent((new Element(strColName)).addContent(""));
				}
			}

		}

		return true;
	}

	public Object clone()
	{
		if (_Element == null)
			return null;
		else
			return new XMLDataset(getElement());
	}

	private void buildError(String szFunc, String szErrMsg)
	{
		CError cError = new CError();
		cError.moduleName = "XmlExportHelper";
		cError.functionName = szFunc;
		cError.errorMessage = szErrMsg;
		mErrors.addOneError(cError);
	}
}
