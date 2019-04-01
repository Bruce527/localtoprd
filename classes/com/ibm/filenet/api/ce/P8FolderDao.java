// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   P8FolderDao.java

package com.ibm.filenet.api.ce;

import com.filenet.api.collection.FolderSet;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.*;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.exception.ExceptionCode;
import com.filenet.api.property.Properties;
import com.filenet.api.property.PropertyFilter;
import com.filenet.api.util.Id;
import com.ibm.filenet.api.ce.search.Search;
import java.util.*;
import org.apache.log4j.Logger;

public class P8FolderDao
{

	private static final Logger logger = Logger.getLogger(com/ibm/filenet/api/ce/P8FolderDao);

	public P8FolderDao()
	{
	}

	public static Folder createFolder(ObjectStore os, Folder parent, String folderName)
	{
		Folder folder = com.filenet.api.core.Factory.Folder.createInstance(os, null);
		folder.set_Parent(parent);
		folder.set_FolderName(folderName);
		folder.save(RefreshMode.REFRESH);
		return folder;
	}

	public static Folder createFolder(ObjectStore os, String symbolicName, Folder parent, String folderName)
	{
		Folder folder = com.filenet.api.core.Factory.Folder.createInstance(os, symbolicName);
		folder.set_Parent(parent);
		folder.set_FolderName(folderName);
		folder.save(RefreshMode.REFRESH);
		return folder;
	}

	public static Folder createFolder(ObjectStore os, String symbolicName, Folder parent, String folderName, Map propMap)
	{
		if (propMap == null || propMap.isEmpty())
			throw new RuntimeException("Property map is null or empty.");
		Folder folder = com.filenet.api.core.Factory.Folder.createInstance(os, symbolicName);
		folder.set_Parent(parent);
		folder.set_FolderName(folderName);
		Set propKeySet = propMap.keySet();
		Properties props = folder.getProperties();
		for (Iterator iterator = propKeySet.iterator(); iterator.hasNext();)
		{
			String propName = (String)iterator.next();
			Object obj = propMap.get(propName);
			if (obj != null)
				props.putObjectValue(propName, propMap.get(propName));
		}

		folder.save(RefreshMode.REFRESH);
		return folder;
	}

	public static Folder createFolderById(ObjectStore os, String parentId, String folderName)
	{
		Folder parent = fetchFolderById(os, parentId, null);
		return createFolder(os, parent, folderName);
	}

	public static Folder createFolderById(ObjectStore os, String symbolicName, String parentId, String folderName)
	{
		Folder parent = fetchFolderById(os, parentId, null);
		return createFolder(os, symbolicName, parent, folderName);
	}

	public static Folder createFolderByPath(ObjectStore os, String parentPath, String folderName)
	{
		Folder parent = fetchFolderByPath(os, parentPath, null);
		return createFolder(os, parent, folderName);
	}

	public static Folder createFolderByPath(ObjectStore os, String symbolicName, String parentPath, String folderName)
	{
		Folder parent = fetchFolderByPath(os, parentPath, null);
		return createFolder(os, symbolicName, parent, folderName);
	}

	public static void deleteFolder(Folder folder)
	{
		folder.delete();
		folder.save(RefreshMode.NO_REFRESH);
	}

	public static void deleteFolderById(ObjectStore os, String folderId)
	{
		Folder folder = fetchFolderById(os, folderId);
		deleteFolder(folder);
	}

	public static Folder fetchFolderById(ObjectStore os, String folderId)
	{
		return fetchFolderById(os, folderId, null);
	}

	public static Folder fetchFolderById(ObjectStore os, String folderId, PropertyFilter folderPropFilter)
	{
		return com.filenet.api.core.Factory.Folder.fetchInstance(os, new Id(folderId), folderPropFilter);
		EngineRuntimeException ex;
		ex;
		if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND)
		{
			logger.warn((new StringBuilder("Folder cannot be found by id '")).append(folderId).append("'.").toString());
			return null;
		} else
		{
			throw ex;
		}
	}

	public static Folder fetchFolderByPath(ObjectStore os, String folderPath)
	{
		return fetchFolderByPath(os, folderPath, null);
	}

	public static Folder fetchFolderByPath(ObjectStore os, String folderPath, PropertyFilter folderPropFilter)
	{
		return com.filenet.api.core.Factory.Folder.fetchInstance(os, folderPath, folderPropFilter);
		EngineRuntimeException ex;
		ex;
		if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND)
		{
			logger.warn((new StringBuilder("Folder cannot be found by path '")).append(folderPath).append("'.").toString());
			return null;
		} else
		{
			throw ex;
		}
	}

	public static Folder getRootFolder(ObjectStore os)
	{
		return os.get_RootFolder();
	}

	public static boolean hasSubfolders(Folder folder)
	{
		FolderSet folderSet = folder.get_SubFolders();
		return folderSet != null && !folderSet.isEmpty();
	}

	public static boolean hasSubfoldersById(ObjectStore os, String parentId)
	{
		Folder parent = fetchFolderById(os, parentId);
		return hasSubfolders(parent);
	}

	public static boolean hasSubfoldersByPath(ObjectStore os, String parentPath)
	{
		Folder parent = fetchFolderByPath(os, parentPath);
		return hasSubfolders(parent);
	}

	public static List listSubfolders(Folder parent)
	{
		List folderList = new ArrayList();
		FolderSet folderSet = parent.get_SubFolders();
		for (Iterator it = folderSet.iterator(); it.hasNext(); folderList.add((Folder)it.next()));
		return folderList;
	}

	public static List listSubfolders(ObjectStore os)
	{
		return listSubfolders(getRootFolder(os));
	}

	public static List listSubfoldersById(ObjectStore os, String parentId)
	{
		Folder parent = fetchFolderById(os, parentId);
		return listSubfolders(parent);
	}

	public static List listSubfoldersByPath(ObjectStore os, String parentPath)
	{
		Folder parent = fetchFolderByPath(os, parentPath);
		return listSubfolders(parent);
	}

	public static List searchForFolders(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, null, "").setScope(os).setPropertyFilter().fetchFolders();
	}

	public static List searchForFolders(ObjectStore os, String symbolicClassName, String whereClause)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicClassName, false, whereClause, null, "").setScope(os).setPropertyFilter().fetchFolders();
	}

}
