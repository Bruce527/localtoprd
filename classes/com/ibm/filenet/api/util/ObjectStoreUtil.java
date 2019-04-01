// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ObjectStoreUtil.java

package com.ibm.filenet.api.util;

import com.filenet.api.core.IndependentlyPersistableObject;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.Properties;
import com.filenet.api.property.Property;
import java.util.*;

public class ObjectStoreUtil
{

	public ObjectStoreUtil()
	{
	}

	public static Map iterateAttributes(ObjectStore os, IndependentlyPersistableObject ipo)
	{
		Map map = new HashMap();
		Properties props = ipo.getProperties();
		Property prop;
		for (Iterator it = props.iterator(); it.hasNext(); map.put(prop.getPropertyName(), prop.getObjectValue()))
			prop = (Property)it.next();

		return map;
	}
}
