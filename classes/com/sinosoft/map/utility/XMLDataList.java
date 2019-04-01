// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLDataList.java

package com.sinosoft.map.utility;

import java.lang.reflect.Field;
import java.util.*;
import org.jdom.Element;

// Referenced classes of package com.sinosoft.map.utility:
//			XMLDataObject, SchemaSet, Schema

public class XMLDataList extends XMLDataObject
{

	private Vector _VCols;
	private Hashtable _HCols;
	private Vector _VData;
	private boolean _bAutoCol;

	public XMLDataList()
	{
		_VCols = new Vector();
		_HCols = new Hashtable();
		_VData = new Vector();
		_bAutoCol = true;
		_VData.clear();
		setDataObjectID("");
	}

	public XMLDataList(String strDataObjectID)
	{
		this();
		setDataObjectID(strDataObjectID);
	}

	public boolean addColHead(String strColHead)
	{
		if (_VData.size() != 0)
		{
			_VData.clear();
			_HCols.clear();
			_VCols.clear();
		}
		if (_HCols.containsKey(strColHead))
		{
			return false;
		} else
		{
			_HCols.put(strColHead, "");
			_VCols.add(strColHead);
			return true;
		}
	}

	public boolean buildColHead()
	{
		_VData.clear();
		return true;
	}

	public boolean setColValue(String strColName, String strValue)
	{
		if (!_HCols.containsKey(strColName))
			return false;
		if (strValue == null || strValue.equals(""))
			_HCols.put(strColName, "");
		else
			_HCols.put(strColName, strValue);
		return true;
	}

	public boolean setColValue(String strColName, int nValue)
	{
		if (!_HCols.containsKey(strColName))
		{
			return false;
		} else
		{
			_HCols.put(strColName, String.valueOf(nValue));
			return true;
		}
	}

	public boolean setColValue(String strColName, float fValue)
	{
		if (!_HCols.containsKey(strColName))
		{
			return false;
		} else
		{
			_HCols.put(strColName, String.valueOf(fValue));
			return true;
		}
	}

	public boolean setColValue(String strColName, double dValue)
	{
		if (!_HCols.containsKey(strColName))
		{
			return false;
		} else
		{
			_HCols.put(strColName, String.valueOf(dValue));
			return true;
		}
	}

	public boolean insertRow(int nFlag)
	{
		_VData.add(_HCols.clone());
		for (Enumeration e = _HCols.keys(); e.hasMoreElements(); _HCols.put(e.nextElement(), ""));
		return true;
	}

	public boolean setAutoCol(boolean bAutoCol)
	{
		_bAutoCol = bAutoCol;
		return _bAutoCol;
	}

	public int getDataObjectType()
	{
		return 1;
	}

	public boolean addDataTo(Element element)
	{
		Enumeration tEnumeration = null;
		String str = "";
		String strColName = "";
		int nColNum = 0;
		Element eleID = new Element(_ID);
		element.addContent(eleID);
		Element eleHead = new Element("HEAD");
		eleID.addContent(eleHead);
		nColNum = 0;
		for (tEnumeration = _VCols.elements(); tEnumeration.hasMoreElements(); eleHead.addContent((new Element(strColName)).addContent(str)))
		{
			str = (String)tEnumeration.nextElement();
			strColName = _bAutoCol ? (new StringBuilder("COL0")).append(String.valueOf(nColNum++)).toString() : str;
		}

		Hashtable hash = null;
		for (int nIndex = 0; nIndex < _VData.size(); nIndex++)
		{
			Element eleRow = new Element("ROW");
			eleID.addContent(eleRow);
			hash = (Hashtable)_VData.get(nIndex);
			nColNum = 0;
			for (tEnumeration = _VCols.elements(); tEnumeration.hasMoreElements(); eleRow.addContent((new Element(strColName)).addContent((String)hash.get(str))))
			{
				str = (String)tEnumeration.nextElement();
				strColName = _bAutoCol ? (new StringBuilder("COL0")).append(String.valueOf(nColNum++)).toString() : str;
			}

		}

		return true;
	}

	public static XMLDataList fromSchemaSet(SchemaSet schemaSet)
	{
		XMLDataList xmlDataList = new XMLDataList();
		if (schemaSet == null)
			return null;
		if (schemaSet.getClass().getSuperclass().getName().equals("com.sinosoft.map.lis.SchemaSet"))
			return null;
		String strClassName = schemaSet.getClass().getName();
		strClassName = strClassName.substring(strClassName.lastIndexOf(".") + 1);
		strClassName = strClassName.substring(0, strClassName.indexOf("Set"));
		xmlDataList.setDataObjectID(strClassName);
		strClassName = (new StringBuilder("com.sinosoft.map.lis.schema.")).append(strClassName).append("Schema").toString();
		Field fields[] = null;
		Vector vFields = new Vector();
		try
		{
			fields = Class.forName(strClassName).getDeclaredFields();
		}
		catch (ClassNotFoundException ex)
		{
			return null;
		}
		for (int nIndex = 0; nIndex < fields.length; nIndex++)
		{
			String strFieldName = fields[nIndex].getName();
			if (!strFieldName.equals("FIELDNUM") && !strFieldName.equals("PK") && !strFieldName.equals("mErrors") && !strFieldName.equals("fDate"))
			{
				xmlDataList.addColHead(strFieldName);
				vFields.add(fields[nIndex]);
			}
		}

		for (int nIndex = 0; nIndex < schemaSet.size(); nIndex++)
		{
			Schema schema = (Schema)schemaSet.getObj(nIndex + 1);
			for (int nCols = 0; nCols < vFields.size(); nCols++)
			{
				String strFieldName = ((Field)vFields.get(nCols)).getName();
				String strFieldType = ((Field)vFields.get(nCols)).getType().getName();
				String strFieldValue = schema.getV(strFieldName);
				if (strFieldType.equals("float") && !strFieldValue.equals("-100.0"))
					xmlDataList.setColValue(strFieldName, strFieldValue);
				else
				if (strFieldType.equals("int") && !strFieldValue.equals("-100"))
					xmlDataList.setColValue(strFieldName, strFieldValue);
				else
				if (strFieldType.equals("java.lang.String") && !strFieldValue.equals("null"))
					xmlDataList.setColValue(strFieldName, strFieldValue);
				else
				if (strFieldType.equals("java.util.Date") && !strFieldValue.equals("null"))
				{
					if (strFieldValue.indexOf('-') != -1)
						strFieldValue = (new StringBuilder(String.valueOf(strFieldValue.substring(0, 4)))).append("Äê").append(strFieldValue.substring(5, 7)).append("ÔÂ").append(strFieldValue.substring(8, 10)).append("ÈÕ").toString();
					xmlDataList.setColValue(strFieldName, strFieldValue);
				} else
				{
					xmlDataList.setColValue(strFieldName, "");
				}
			}

			xmlDataList.insertRow(0);
		}

		return xmlDataList;
	}
}
