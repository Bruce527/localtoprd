// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   P8ClassDefinitionDao.java

package com.ibm.filenet.api.ce;

import com.filenet.api.admin.*;
import com.filenet.api.collection.*;
import com.filenet.api.constants.*;
import com.filenet.api.core.*;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.exception.ExceptionCode;
import com.filenet.api.meta.ClassDescription;
import com.filenet.api.property.Properties;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.Id;
import java.io.PrintStream;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

// Referenced classes of package com.ibm.filenet.api.ce:
//			P8PropertyTemplateDao, P8CustomObjectDao

public class P8ClassDefinitionDao
{

	public static Logger logger = Logger.getLogger(com/ibm/filenet/api/ce/P8ClassDefinitionDao);

	public P8ClassDefinitionDao()
	{
	}

	public static void addPropertyDefinitionsToClassDefinition(ObjectStore os, ClassDefinition classDefinition, List propTemplateIdList)
	{
		PropertyDefinitionList propDefList = classDefinition.get_PropertyDefinitions();
		PropertyDefinition newPropDef;
		for (Iterator iterator = propTemplateIdList.iterator(); iterator.hasNext(); propDefList.add(newPropDef))
		{
			PropertyTemplate propTemplate = (PropertyTemplate)iterator.next();
			newPropDef = propTemplate.createClassProperty();
			newPropDef.set_Settability(PropertySettability.READ_WRITE);
		}

		classDefinition.save(RefreshMode.REFRESH);
	}

	public static void addPropertyDefinitionsToClassDefinitionBySymbolicName(ObjectStore os, ClassDefinition classDefinition, List propTemplateSymbolicNameList)
	{
		PropertyDefinitionList propDefList = classDefinition.get_PropertyDefinitions();
		List propSymblicNameList = new ArrayList();
		Iterator it = propDefList.iterator();
		PropertyDefinition pdf = null;
		for (; it.hasNext(); System.out.println((new StringBuilder("SymbolicName�?")).append(pdf.get_SymbolicName()).toString()))
		{
			pdf = (PropertyDefinition)it.next();
			propSymblicNameList.add(pdf.get_SymbolicName());
		}

		PropertyTemplate propTemplate = null;
		List propTemplateList = null;
		PropertyDefinition newPropDef = null;
		for (Iterator iterator = propTemplateSymbolicNameList.iterator(); iterator.hasNext();)
		{
			String symbolicName = (String)iterator.next();
			propTemplateList = P8PropertyTemplateDao.fetchPropertyTemplates(os, symbolicName);
			if (propTemplateList == null || propTemplateList.size() > 0)
			{
				propTemplate = (PropertyTemplate)propTemplateList.get(0);
				newPropDef = propTemplate.createClassProperty();
				newPropDef.set_Settability(PropertySettability.READ_WRITE);
				if (!isClassHasThisProperty(propSymblicNameList, newPropDef))
					propDefList.add(newPropDef);
			}
		}

		classDefinition.save(RefreshMode.REFRESH);
	}

	private static boolean isClassHasThisProperty(List propDefList, PropertyDefinition newPropDef)
	{
		boolean bHas = false;
		String propDef = null;
		if (propDefList != null && propDefList.size() > 0)
		{
			for (Iterator it = propDefList.iterator(); it.hasNext();)
			{
				propDef = (String)it.next();
				if (propDef.equals(newPropDef.get_PropertyTemplate().get_SymbolicName()))
				{
					bHas = true;
					break;
				}
			}

		}
		return bHas;
	}

	public static ClassDefinition createClassDefinition(ObjectStore os, String parentSymbolicName, String symbolicName, Map displayNameMap)
	{
		ClassDefinition parent = com.filenet.api.core.Factory.ClassDefinition.fetchInstance(os, parentSymbolicName, null);
		return createClassDefinition(parent, symbolicName, displayNameMap);
	}

	public static ClassDefinition createClassDefinition(ClassDefinition parent, String symbolicName, Map displayNameMap)
	{
		return createClassDefinition(((UpdatingBatch) (null)), parent, symbolicName, displayNameMap);
	}

	public static ClassDefinition createClassDefinition(UpdatingBatch ub, ClassDefinition parent, String symbolicName, Map displayNameMap)
	{
		ClassDefinition def = parent.createSubclass();
		def.set_SymbolicName(symbolicName);
		def.set_DisplayNames(com.filenet.api.core.Factory.LocalizedString.createList());
		Set keySet = displayNameMap.keySet();
		LocalizedString displayName;
		for (Iterator iterator = keySet.iterator(); iterator.hasNext(); def.get_DisplayNames().add(displayName))
		{
			String key = (String)iterator.next();
			displayName = com.filenet.api.core.Factory.LocalizedString.createInstance();
			displayName.set_LocaleName(key);
			displayName.set_LocalizedText((String)displayNameMap.get(key));
		}

		if (ub == null)
			def.save(RefreshMode.REFRESH);
		else
			P8CustomObjectDao.addToUpdatingBatchUniquly(ub, def);
		return def;
	}

	public static void deleteClassDefinition(ObjectStore os, String symbolicName)
	{
		ClassDefinition clzDef = com.filenet.api.core.Factory.ClassDefinition.fetchInstance(os, symbolicName, null);
		deleteClassDefinition(os, clzDef);
	}

	public static void deleteClassDefinition(ObjectStore os, ClassDefinition classDefinition)
	{
		classDefinition.delete();
		classDefinition.save(RefreshMode.REFRESH);
	}

	public static ClassDefinition fetchClassDefinition(ObjectStore os, String symbolicName)
	{
		if (os == null)
			throw new NullPointerException((new StringBuilder("ObjectStore is null when get ClassDefinition of ")).append(symbolicName).toString());
		return com.filenet.api.core.Factory.ClassDefinition.fetchInstance(os, symbolicName, null);
		EngineRuntimeException e;
		e;
		if (e.getExceptionCode() == ExceptionCode.E_BAD_CLASSID)
		{
			logger.warn((new StringBuilder(String.valueOf(os.get_Name()))).append(" : ").append(e.getMessage()).toString());
			return null;
		} else
		{
			throw e;
		}
	}

	public static ClassDefinitionSet getImmediateSubclassDefinitions(ObjectStore os, String symbolicName)
	{
		ClassDefinition def = com.filenet.api.core.Factory.ClassDefinition.fetchInstance(os, symbolicName, null);
		return def.get_ImmediateSubclassDefinitions();
	}

	public static PropertyDefinitionList getPropertyDefinitionList(ObjectStore os, String symbolicName)
	{
		ClassDefinition clzDef = com.filenet.api.core.Factory.ClassDefinition.fetchInstance(os, symbolicName, null);
		return clzDef.get_PropertyDefinitions();
	}

	public static boolean hasPropertyDefinition(ObjectStore os, String clzSymbolicName, String propSymbolicName)
	{
		boolean flag = false;
		ClassDefinition clzDef = com.filenet.api.core.Factory.ClassDefinition.fetchInstance(os, clzSymbolicName, null);
		PropertyDefinitionList propDefList = clzDef.get_PropertyDefinitions();
		for (int i = 0; i < propDefList.size(); i++)
		{
			PropertyDefinition propDef = (PropertyDefinition)propDefList.get(i);
			if (StringUtils.equals(propDef.get_SymbolicName(), propSymbolicName))
				flag = true;
		}

		return flag;
	}

	public static List listAllClassDefinitionNames(ObjectStore os)
	{
		List clzDefNames = new ArrayList();
		ClassDescriptionSet cds = os.get_ClassDescriptions();
		ClassDescription clzDesc;
		for (Iterator it = cds.iterator(); it.hasNext(); clzDefNames.add(clzDesc.get_SymbolicName()))
			clzDesc = (ClassDescription)it.next();

		return clzDefNames;
	}

	public static List listDocumentClasses(ObjectStore os)
	{
		List defList = new ArrayList();
		String queryString = "SELECT * FROM DocumentClassDefinition WHERE [IsHidden] = FALSE AND [AllowsInstances] = TRUE";
		SearchSQL searchSQL = new SearchSQL(queryString);
		SearchScope searchScope = new SearchScope(os);
		IndependentObjectSet set = searchScope.fetchObjects(searchSQL, null, null, Boolean.valueOf(false));
		for (Iterator iter = set.iterator(); iter.hasNext(); defList.add((ClassDefinition)iter.next()));
		return defList;
	}

	public static void removePropTempFromClassDef(ObjectStore os, String propTemplateName, String symbolicClassName)
	{
		ClassDefinition classDef = com.filenet.api.core.Factory.ClassDefinition.fetchInstance(os, symbolicClassName, null);
		PropertyDefinitionList propDefs = classDef.get_PropertyDefinitions();
		for (Iterator iterator = propDefs.iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			PropertyDefinition propDef = (PropertyDefinition)object;
			if (propDef.get_SymbolicName().equalsIgnoreCase(propTemplateName))
			{
				propDefs.remove(object);
				break;
			}
		}

	}

	public static void updatePropertyDefinitionsOfClassDefinition(ObjectStore os, ClassDefinition classDefinition, List propTemplateIdList)
	{
		PropertyDefinitionList propertyDefinitionList = classDefinition.get_PropertyDefinitions();
		for (int i = propertyDefinitionList.size() - 1; i >= classDefinition.get_ProtectedPropertyCount().intValue(); i--)
		{
			Object obj = propertyDefinitionList.get(i);
			boolean exist = false;
			PropertyDefinition propertyDefinition = (PropertyDefinition)obj;
			String id = propertyDefinition.get_Id().toString();
			for (Iterator iterator1 = propTemplateIdList.iterator(); iterator1.hasNext();)
			{
				String propId = (String)iterator1.next();
				if (propId.equals(id))
				{
					propTemplateIdList.remove(propId);
					exist = true;
					break;
				}
			}

			if (!exist)
				propertyDefinitionList.remove(obj);
		}

		PropertyDefinition newPropDef;
		for (Iterator iterator = propTemplateIdList.iterator(); iterator.hasNext(); propertyDefinitionList.add(newPropDef))
		{
			String propId = (String)iterator.next();
			PropertyTemplate propTemplate = P8PropertyTemplateDao.fetchPropertyTemplate(os, propId);
			newPropDef = propTemplate.createClassProperty();
			newPropDef.set_Settability(PropertySettability.READ_WRITE);
		}

		classDefinition.save(RefreshMode.NO_REFRESH);
	}

	public static void updatePropertyListofClassDefinition(ObjectStore os, ClassDefinition classDefinition, List deletePropertyList, List createPropertyList)
	{
		if ((deletePropertyList == null || deletePropertyList.size() == 0) && (createPropertyList == null || createPropertyList.size() == 0))
			return;
		PropertyDefinitionList propertyDefList = classDefinition.get_PropertyDefinitions();
		if (deletePropertyList != null && deletePropertyList.size() > 0)
		{
			for (int i = deletePropertyList.size() - 1; i >= 0; i--)
			{
				String symbolicName = (String)deletePropertyList.get(i);
				for (int j = propertyDefList.size() - 1; j >= 0; j--)
				{
					if (!((PropertyDefinition)propertyDefList.get(j)).get_SymbolicName().equals(symbolicName))
						continue;
					propertyDefList.remove(j);
					break;
				}

			}

		}
		if (createPropertyList != null && createPropertyList.size() > 0)
		{
			for (int i = createPropertyList.size() - 1; i >= 0; i--)
			{
				String symbolic = (String)createPropertyList.get(i);
				List propertyTemplates = P8PropertyTemplateDao.fetchPropertyTemplates(os, symbolic);
				if (propertyTemplates.size() > 0)
				{
					PropertyTemplate propTemplate = (PropertyTemplate)propertyTemplates.get(0);
					PropertyDefinition newPropDef = propTemplate.createClassProperty();
					propertyDefList.add(newPropDef);
				} else
				{
					throw new RuntimeException((new StringBuilder("要创建实例的属�?�模�?")).append(symbolic).append("不存�?").toString());
				}
			}

		}
		try
		{
			classDefinition.save(RefreshMode.REFRESH);
		}
		catch (EngineRuntimeException e)
		{
			if (e.getExceptionCode() == ExceptionCode.E_NOT_UNIQUE)
				throw new RuntimeException("属�?�已存在于当前分类或其子类中", e);
			else
				throw e;
		}
	}

	private void putObjectValue(ObjectStore os, String symbolicClassName, Properties props, String name, Object updatedAttr)
	{
		if (StringUtils.isEmpty(symbolicClassName))
			symbolicClassName = "Document";
		ClassDefinition objClassDef = com.filenet.api.core.Factory.ClassDefinition.fetchInstance(os, symbolicClassName, null);
		PropertyDefinitionList objPropDefs = objClassDef.get_PropertyDefinitions();
		for (Iterator it = objPropDefs.iterator(); it.hasNext();)
		{
			PropertyDefinition objPropDef = (PropertyDefinition)it.next();
			String objPropDefSymbolicName = objPropDef.get_SymbolicName();
			if (objPropDefSymbolicName.equals(name))
			{
				if (objPropDef.get_Cardinality() == Cardinality.LIST)
				{
					TypeID type = objPropDef.get_DataType();
					if (type == TypeID.STRING)
					{
						StringList list = com.filenet.api.core.Factory.StringList.createList();
						List strList = (List)updatedAttr;
						String str;
						for (Iterator iterator = strList.iterator(); iterator.hasNext(); list.add(str))
							str = (String)iterator.next();

						props.putObjectValue(name, list);
					} else
					if (type == TypeID.DATE)
					{
						DateTimeList list = com.filenet.api.core.Factory.DateTimeList.createList();
						List dateList = (List)updatedAttr;
						Date date;
						for (Iterator iterator1 = dateList.iterator(); iterator1.hasNext(); list.add(date))
							date = (Date)iterator1.next();

						props.putObjectValue(name, list);
					}
				} else
				{
					props.putObjectValue(name, updatedAttr);
				}
				break;
			}
		}

	}

}
