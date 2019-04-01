// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   P8CustomObjectDao.java

package com.ibm.filenet.api.ce;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.*;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.exception.ExceptionCode;
import com.filenet.api.property.Properties;
import com.filenet.api.property.PropertyFilter;
import com.filenet.api.util.Id;
import com.ibm.filenet.api.ce.search.Search;
import com.ibm.filenet.api.util.ObjectStoreUtil;
import java.util.*;
import org.apache.log4j.Logger;

// Referenced classes of package com.ibm.filenet.api.ce:
//			P8DocumentDao

public class P8CustomObjectDao
{

	private static final Logger logger = Logger.getLogger(com/ibm/filenet/api/ce/P8CustomObjectDao);

	public P8CustomObjectDao()
	{
	}

	public static CustomObject createCustomObject(ObjectStore os, String symbolicName, Map propMap, boolean save)
	{
		CustomObject co = com.filenet.api.core.Factory.CustomObject.createInstance(os, symbolicName);
		if (propMap == null || propMap.isEmpty())
			throw new RuntimeException("Property map is null or empty.");
		Set propKeySet = propMap.keySet();
		Properties props = co.getProperties();
		for (Iterator iterator = propKeySet.iterator(); iterator.hasNext();)
		{
			String propName = (String)iterator.next();
			Object obj = propMap.get(propName);
			if (obj != null)
				props.putObjectValue(propName, propMap.get(propName));
		}

		if (save)
			co.save(RefreshMode.REFRESH);
		return co;
	}

	public static void deleteCustomObject(CustomObject customObject, boolean save)
	{
		customObject.delete();
		if (save)
			customObject.save(RefreshMode.NO_REFRESH);
	}

	public static void deleteCustomObject(CustomObject customObject)
	{
		deleteCustomObject(customObject, true);
	}

	public static void deleteCustomObjectById(ObjectStore os, String coId, boolean save)
	{
		CustomObject co = fetchCustomObjectById(os, coId);
		deleteCustomObject(co, save);
	}

	public static void deleteCustomObjectByPath(ObjectStore os, String coPath, boolean save)
	{
		CustomObject co = fetchCustomObjectByPath(os, coPath);
		deleteCustomObject(co, save);
	}

	public static CustomObject fetchCustomObjectById(ObjectStore os, String customObjectId)
	{
		return fetchCustomObjectById(os, customObjectId, null);
	}

	public static CustomObject fetchCustomObjectById(ObjectStore os, String customObjectId, PropertyFilter customObjectPropFilter)
	{
		return com.filenet.api.core.Factory.CustomObject.fetchInstance(os, new Id(customObjectId), customObjectPropFilter);
		EngineRuntimeException ex;
		ex;
		if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND)
		{
			logger.error((new StringBuilder("Custom object cannot be found by id '")).append(customObjectId).append("'.").toString(), ex);
			return null;
		} else
		{
			throw ex;
		}
	}

	public static CustomObject fetchCustomObjectByPath(ObjectStore os, String customObjectPath)
	{
		return fetchCustomObjectByPath(os, customObjectPath, null);
	}

	public static CustomObject fetchCustomObjectByPath(ObjectStore os, String customObjectPath, PropertyFilter customObjectPropFilter)
	{
		return com.filenet.api.core.Factory.CustomObject.fetchInstance(os, customObjectPath, customObjectPropFilter);
		EngineRuntimeException ex;
		ex;
		if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND)
		{
			logger.error((new StringBuilder("Custom object cannot be found by path '")).append(customObjectPath).append("'.").toString(), ex);
			return null;
		} else
		{
			throw ex;
		}
	}

	public static Map iterateCustomObjectAttributes(ObjectStore os, CustomObject co)
	{
		return ObjectStoreUtil.iterateAttributes(os, co);
	}

	public static List listCustomObjects(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String orderByClause)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicClassName, includeSubclasses, null, orderByClause, -1).setScope(os).setPropertyFilter().fetchCustomObjects();
	}

	public static List searchForCustomObjects(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, null, "").setScope(os).setPropertyFilter().fetchCustomObjects();
	}

	public static List searchForCustomObjects(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, List selectList)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, selectList, "").setScope(os).setPropertyFilter().fetchCustomObjects();
	}

	public static List searchForCustomObjects(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause, boolean isFullText)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, orderByClause, -1, isFullText).setScope(os).setPropertyFilter().fetchCustomObjects();
	}

	public static List searchForCustomObjects(ObjectStore os, String symbolicClassName, String whereClause)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicClassName, false, whereClause, null, "").setScope(os).setPropertyFilter().fetchCustomObjects();
	}

	public static List searchForDistinctCustomObjectFields(ObjectStore os, String selectClause, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause)
	{
		List result = new ArrayList();
		boolean distinct = true;
		Search search = new Search();
		List customObjectList = search.setObjectSql(distinct, selectClause, symbolicClassName, includeSubclasses, whereClause, orderByClause).setScope(os).setPropertyFilter().fetchCustomObjects();
		Object value;
		for (Iterator iterator = customObjectList.iterator(); iterator.hasNext(); result.add(value))
		{
			CustomObject co = (CustomObject)iterator.next();
			value = co.getProperties().getObjectValue(selectClause);
		}

		return result;
	}

	public static List searchForDistinctCustomObjects(ObjectStore os, String selectClause, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause)
	{
		boolean distinct = true;
		Search search = new Search();
		return search.setObjectSql(distinct, selectClause, symbolicClassName, includeSubclasses, whereClause, orderByClause).setScope(os).setPropertyFilter().fetchCustomObjects();
	}

	public static void updateCustomObjectAttributes(ObjectStore os, CustomObject co, Map updatedAttrs)
	{
		updateAttributes(os, co, updatedAttrs);
	}

	public static void updateCustomObjectAttributes(ObjectStore os, String customObjectId, Map updatedAttrs)
	{
		updateAttributes(os, fetchCustomObjectById(os, customObjectId), updatedAttrs);
	}

	public static boolean updateAttributes(ObjectStore os, IndependentlyPersistableObject ipo, Map updatedAttrs)
	{
		boolean flag = false;
		if (updatedAttrs == null || updatedAttrs.isEmpty())
			return true;
		Iterator it = updatedAttrs.keySet().iterator();
		Properties props = ipo.getProperties();
		while (it.hasNext()) 
		{
			String name = (String)it.next();
			Object updatedAttr = updatedAttrs.get(name);
			if (props.isPropertyPresent(name) && updatedAttr != null)
				if (!name.equals("techProcDocId"))
					props.putObjectValue(name, updatedAttr);
				else
					props.putObjectValue(name, new Id(updatedAttr.toString()));
		}
		ipo.save(RefreshMode.REFRESH);
		flag = true;
		return flag;
	}

	public static CustomObject createCustomObject(ObjectStore os, String symbolicName, Map propMap)
	{
		CustomObject co = com.filenet.api.core.Factory.CustomObject.createInstance(os, symbolicName);
		if (propMap == null || propMap.isEmpty())
		{
			throw new RuntimeException("Property map is null or empty.");
		} else
		{
			Properties props = co.getProperties();
			P8DocumentDao.updateAttributes(props, propMap);
			co.save(RefreshMode.REFRESH);
			return co;
		}
	}

	public static void addToUpdatingBatchUniquly(UpdatingBatch ub, IndependentlyPersistableObject co)
	{
		if (ub.getBatchItemHandles(co).size() == 0)
			ub.add(co, null);
	}

}
