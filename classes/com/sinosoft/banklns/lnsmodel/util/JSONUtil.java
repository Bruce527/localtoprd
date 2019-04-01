// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   JSONUtil.java

package com.sinosoft.banklns.lnsmodel.util;

import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.jdom.*;

public class JSONUtil
{

	public JSONUtil()
	{
	}

	public static JSONObject xml2JSON(Document doc)
	{
		JSONObject obj = new JSONObject();
		Element root = doc.getRootElement();
		obj.put(root.getName(), iterateElement(root));
		return obj;
		Exception e;
		e;
		e.printStackTrace();
		return null;
	}

	private static Map iterateElement(Element root)
	{
		List jiedian = root.getChildren();
		Element et = null;
		Map map = new HashMap();
		List list = null;
		List attributes = root.getAttributes();
		for (int i = 0; i < attributes.size(); i++)
			map.put(((Attribute)attributes.get(i)).getName(), ((Attribute)attributes.get(i)).getValue());

		for (int i = 0; i < jiedian.size(); i++)
		{
			list = new LinkedList();
			et = (Element)jiedian.get(i);
			if (et.getTextTrim().equals(""))
			{
				if (et.getChildren().size() != 0)
				{
					if (map.containsKey(et.getName()))
						list.add(map.get(et.getName()));
					list.add(iterateElement(et));
					if (list.size() > 1)
						map.put(et.getName(), list);
					else
						map.put(et.getName(), list.get(0));
				}
			} else
			{
				List temp_att = et.getAttributes();
				if (temp_att.size() != 0)
				{
					Map childMap = new HashMap();
					for (int j = 0; j < temp_att.size(); j++)
						childMap.put(((Attribute)temp_att.get(j)).getName(), ((Attribute)temp_att.get(j)).getValue());

					childMap.put("content", et.getTextTrim());
					map.put(et.getName(), childMap);
				} else
				{
					if (map.containsKey(et.getName()))
						try
						{
							list = (List)map.get(et.getName());
						}
						catch (Exception e)
						{
							list.add(map.get(et.getName()));
						}
					list.add(et.getTextTrim());
					if (list.size() > 1)
						map.put(et.getName(), list);
					else
						map.put(et.getName(), list.get(0));
				}
			}
		}

		return map;
	}
}
