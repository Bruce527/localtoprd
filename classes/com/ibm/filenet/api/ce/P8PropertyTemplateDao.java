// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   P8PropertyTemplateDao.java

package com.ibm.filenet.api.ce;

import com.filenet.api.admin.LocalizedString;
import com.filenet.api.admin.PropertyTemplate;
import com.filenet.api.collection.LocalizedStringList;
import com.filenet.api.collection.PropertyTemplateSet;
import com.filenet.api.constants.Cardinality;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.*;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.Id;
import com.ibm.filenet.api.util.EngineCollectionUtils;
import java.io.PrintStream;
import java.util.*;

// Referenced classes of package com.ibm.filenet.api.ce:
//			P8CustomObjectDao

public class P8PropertyTemplateDao
{

	public P8PropertyTemplateDao()
	{
	}

	public static PropertyTemplate createPropertyTemplate(ObjectStore os, int dataType, int cardinality, String symbolicName, Map displayNameMap)
	{
		return createPropertyTemplate(null, os, dataType, cardinality, symbolicName, displayNameMap);
	}

	public static PropertyTemplate createPropertyTemplate(UpdatingBatch ub, ObjectStore os, int dataType, int cardinality, String symbolicName, Map displayNameMap)
	{
		PropertyTemplate prop = null;
		switch (dataType)
		{
		case 1: // '\001'
			prop = com.filenet.api.core.Factory.PropertyTemplateBinary.createInstance(os);
			break;

		case 2: // '\002'
			prop = com.filenet.api.core.Factory.PropertyTemplateBoolean.createInstance(os);
			break;

		case 3: // '\003'
			prop = com.filenet.api.core.Factory.PropertyTemplateDateTime.createInstance(os);
			break;

		case 4: // '\004'
			prop = com.filenet.api.core.Factory.PropertyTemplateFloat64.createInstance(os);
			break;

		case 5: // '\005'
			prop = com.filenet.api.core.Factory.PropertyTemplateId.createInstance(os);
			break;

		case 6: // '\006'
			prop = com.filenet.api.core.Factory.PropertyTemplateInteger32.createInstance(os);
			break;

		case 7: // '\007'
			prop = com.filenet.api.core.Factory.PropertyTemplateObject.createInstance(os);
			break;

		case 8: // '\b'
			prop = com.filenet.api.core.Factory.PropertyTemplateString.createInstance(os);
			break;

		default:
			prop = com.filenet.api.core.Factory.PropertyTemplateObject.createInstance(os);
			break;
		}
		switch (cardinality)
		{
		case 0: // '\0'
			prop.set_Cardinality(Cardinality.SINGLE);
			break;

		case 2: // '\002'
			prop.set_Cardinality(Cardinality.LIST);
			break;

		case 1: // '\001'
			prop.set_Cardinality(Cardinality.ENUM);
			break;

		default:
			prop.set_Cardinality(Cardinality.SINGLE);
			break;
		}
		prop.set_SymbolicName(symbolicName);
		prop.set_DisplayNames(com.filenet.api.core.Factory.LocalizedString.createList());
		Set keySet = displayNameMap.keySet();
		LocalizedString displayName;
		for (Iterator iterator = keySet.iterator(); iterator.hasNext(); prop.get_DisplayNames().add(displayName))
		{
			String key = (String)iterator.next();
			displayName = com.filenet.api.core.Factory.LocalizedString.createInstance();
			displayName.set_LocaleName(key);
			displayName.set_LocalizedText((String)displayNameMap.get(key));
		}

		if (ub == null)
			prop.save(RefreshMode.REFRESH);
		else
			P8CustomObjectDao.addToUpdatingBatchUniquly(ub, prop);
		return prop;
	}

	public static void deletePropertyTemplate(ObjectStore os, Id propTemplateId)
	{
		PropertyTemplate prop = com.filenet.api.core.Factory.PropertyTemplate.fetchInstance(os, propTemplateId, null);
		prop.delete();
		prop.save(RefreshMode.REFRESH);
	}

	public static PropertyTemplate fetchPropertyTemplate(ObjectStore os, String id)
	{
		PropertyTemplate propertyTemplate = com.filenet.api.core.Factory.PropertyTemplate.fetchInstance(os, new Id(id), null);
		return propertyTemplate;
	}

	public static List fetchPropertyTemplates(ObjectStore os, String symbolicName)
	{
		return fetchPropertyTemplates(os, symbolicName, new String[0]);
	}

	public static List fetchPropertyTemplates(ObjectStore os, String symbolicName, String selectList[])
	{
		String selectListOfSys[] = {
			"This", "Id", "SymbolicName", "DataType", "Cardinality", "DisplayName"
		};
		List list = new ArrayList();
		list.addAll(Arrays.asList(selectListOfSys));
		String as[];
		int k = (as = selectList).length;
		for (int j = 0; j < k; j++)
		{
			String p = as[j];
			if (!list.contains(p))
				list.add(p);
		}

		SearchScope searchScope = new SearchScope(os);
		String sql = (new StringBuilder("SELECT p.")).append((String)list.get(0)).toString();
		for (int i = 1; i < list.size(); i++)
			sql = (new StringBuilder(String.valueOf(sql))).append(",p.").append((String)list.get(i)).toString();

		sql = (new StringBuilder(String.valueOf(sql))).append(" FROM PropertyTemplate p WHERE p.SymbolicName='").append(symbolicName).append("'").toString();
		SearchSQL searchSQL = new SearchSQL(sql);
		com.filenet.api.collection.IndependentObjectSet objects = searchScope.fetchObjects(searchSQL, null, null, Boolean.valueOf(true));
		List propTemplates = new ArrayList();
		PropertyTemplate propTemplate;
		for (Iterator iterator = EngineCollectionUtils.c(objects, com/filenet/api/admin/PropertyTemplate).iterator(); iterator.hasNext(); propTemplates.add(propTemplate))
			propTemplate = (PropertyTemplate)iterator.next();

		System.out.println((new StringBuilder("Search SQL:")).append(sql).toString());
		return propTemplates;
	}

	public static List fetchPropertyTemplates(ObjectStore os, String symbolicNames[], String selectList[])
	{
		List propTemplates = new ArrayList();
		if (symbolicNames.length == 0)
			return propTemplates;
		String selectListOfSys[] = {
			"This", "Id", "SymbolicName", "DataType", "Cardinality", "DisplayName"
		};
		List list = new ArrayList();
		list.addAll(Arrays.asList(selectListOfSys));
		String as[];
		int k = (as = selectList).length;
		for (int j = 0; j < k; j++)
		{
			String p = as[j];
			if (!list.contains(p))
				list.add(p);
		}

		SearchScope searchScope = new SearchScope(os);
		String sql = (new StringBuilder("SELECT p.")).append((String)list.get(0)).toString();
		for (int i = 1; i < list.size(); i++)
			sql = (new StringBuilder(String.valueOf(sql))).append(",p.").append((String)list.get(i)).toString();

		String props = (new StringBuilder("'")).append(symbolicNames[0]).append("'").toString();
		for (int i = 0; i < symbolicNames.length; i++)
			props = (new StringBuilder(String.valueOf(props))).append(",'").append(symbolicNames[i]).append("'").toString();

		sql = (new StringBuilder(String.valueOf(sql))).append(" FROM PropertyTemplate p WHERE p.SymbolicName in (").append(props).append(")").toString();
		SearchSQL searchSQL = new SearchSQL(sql);
		com.filenet.api.collection.IndependentObjectSet objects = searchScope.fetchObjects(searchSQL, null, null, Boolean.valueOf(true));
		PropertyTemplate propTemplate;
		for (Iterator iterator = EngineCollectionUtils.c(objects, com/filenet/api/admin/PropertyTemplate).iterator(); iterator.hasNext(); propTemplates.add(propTemplate))
			propTemplate = (PropertyTemplate)iterator.next();

		System.out.println((new StringBuilder("Search SQL:")).append(sql).toString());
		return propTemplates;
	}

	public static PropertyTemplateSet getPropertyTemplates(ObjectStore os)
	{
		return os.get_PropertyTemplates();
	}
}
