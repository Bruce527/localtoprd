// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   P8DocumentDao.java

package com.ibm.filenet.api.ce;

import com.filenet.api.admin.ClassDefinition;
import com.filenet.api.admin.PropertyDefinition;
import com.filenet.api.collection.*;
import com.filenet.api.constants.*;
import com.filenet.api.core.*;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.exception.ExceptionCode;
import com.filenet.api.property.*;
import com.filenet.api.util.Id;
import com.ibm.filenet.api.ce.search.Search;
import com.ibm.filenet.api.util.ObjectStoreUtil;
import java.io.InputStream;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

// Referenced classes of package com.ibm.filenet.api.ce:
//			P8CustomObjectDao, P8FolderDao

public class P8DocumentDao
{

	private static final Logger logger = Logger.getLogger(com/ibm/filenet/api/ce/P8DocumentDao);
	public static final String DOCUMENT_TITLE = "DocumentTitle";

	public P8DocumentDao()
	{
	}

	public static boolean cancelCheckOutDocument(ObjectStore os, String docId)
	{
		Document doc = fetchDocumentById(os, docId);
		return cancelCheckOutDocument(os, doc);
	}

	public static boolean cancelCheckOutDocument(ObjectStore os, Document doc)
	{
		boolean flag = false;
		Document reservation = (Document)doc.get_Reservation();
		doc.cancelCheckout();
		reservation.save(RefreshMode.REFRESH);
		flag = true;
		return flag;
	}

	public static void changeDocumentClass(ObjectStore os, String docId, String className)
	{
		Document doc = fetchDocumentById(os, docId);
		changeDocumentClass(doc, className);
	}

	public static void changeDocumentClass(Document doc, String className)
	{
		doc.changeClass(className);
		doc.save(RefreshMode.REFRESH);
	}

	private static boolean checkInDocument(ObjectStore os, Document doc, Map propMap, ContentElementList contentElementList, CheckinType checkinType)
	{
		boolean flag = false;
		try
		{
			checkInDocument(null, os, doc, propMap, contentElementList, checkinType);
			flag = true;
		}
		catch (EngineRuntimeException ex)
		{
			logger.error((new StringBuilder("Error occurred when checking in the document '")).append(doc.get_Id()).append("'.").toString());
			throw ex;
		}
		return flag;
	}

	public static boolean checkInDocumentAsMajor(ObjectStore os, Document doc, Map propMap, ContentElementList contentElementList)
	{
		return checkInDocument(os, doc, propMap, contentElementList, CheckinType.MAJOR_VERSION);
	}

	private static void checkInDocument(UpdatingBatch ub, ObjectStore os, Document doc, Map propMap, ContentElementList contentElementList, CheckinType checkinType)
	{
		try
		{
			Document released;
			try
			{
				released = (Document)doc.get_Reservation();
			}
			catch (Exception e)
			{
				released = doc;
			}
			Properties props = released.getProperties();
			updateAttributes(props, propMap);
			setContentElementList(released, contentElementList);
			released.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, checkinType);
			if (ub == null)
				released.save(RefreshMode.REFRESH);
			else
				P8CustomObjectDao.addToUpdatingBatchUniquly(ub, released);
		}
		catch (EngineRuntimeException ex)
		{
			logger.error((new StringBuilder("Error occurred when checking in the document '")).append(doc.get_Id()).append("'.").toString());
			throw ex;
		}
	}

	public static void checkInDocumentAsMajor(UpdatingBatch ub, ObjectStore os, Document doc, Map propMap, ContentElementList contentElementList)
	{
		checkInDocument(ub, os, doc, propMap, contentElementList, CheckinType.MAJOR_VERSION);
	}

	private static boolean checkInDocument(ObjectStore os, String docId, Map propMap, ContentElementList contentElementList, CheckinType checkinType)
	{
		boolean flag = false;
		try
		{
			Document doc = fetchDocumentById(os, docId);
			flag = checkInDocument(os, doc, propMap, contentElementList, checkinType);
		}
		catch (EngineRuntimeException ex)
		{
			logger.error((new StringBuilder("Error occurred when checking in the document '")).append(docId).append("'.").toString());
			throw ex;
		}
		return flag;
	}

	public static boolean checkInDocumentAsMajor(ObjectStore os, String docId, Map propMap, ContentElementList contentElementList)
	{
		return checkInDocument(os, docId, propMap, contentElementList, CheckinType.MAJOR_VERSION);
	}

	public static void checkOutDocument(ObjectStore os, Document doc)
	{
		doc.checkout(ReservationType.OBJECT_STORE_DEFAULT, null, null, null);
		doc.save(RefreshMode.REFRESH);
	}

	public static void checkOutDocument(ObjectStore os, String docId)
	{
		Document doc = fetchDocumentById(os, docId);
		checkOutDocument(os, doc);
	}

	public static void checkInDocument(ObjectStore os, Document doc, Map propMap, Map content)
	{
		try
		{
			Document released;
			try
			{
				released = (Document)doc.get_Reservation();
			}
			catch (Exception e)
			{
				released = doc;
			}
			if (propMap != null)
				updateAttributes(released.getProperties(), propMap);
			if (content != null && !content.isEmpty())
			{
				ContentElementList contentElementList = com.filenet.api.core.Factory.ContentElement.createList();
				ContentTransfer transfer;
				for (Iterator it = content.keySet().iterator(); it.hasNext(); contentElementList.add(transfer))
				{
					String name = (String)it.next();
					InputStream ins = (InputStream)content.get(name);
					transfer = com.filenet.api.core.Factory.ContentTransfer.createInstance();
					transfer.setCaptureSource(ins);
					transfer.set_RetrievalName(name);
				}

				released.set_ContentElements(contentElementList);
			}
			released.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
			released.save(RefreshMode.REFRESH);
		}
		catch (EngineRuntimeException ex)
		{
			logger.error((new StringBuilder("Error occurred when checking in the document '")).append(doc.get_Id()).append("'.").toString());
			throw ex;
		}
	}

	public static ComponentRelationship createComponentRelationship(ObjectStore os, Document parentDoc, Document childDoc)
	{
		if (parentDoc.get_CompoundDocumentState().getValue() != 1)
		{
			throw new RuntimeException((new StringBuilder()).append(parentDoc.get_Id()).append("不是复合文档").toString());
		} else
		{
			ComponentRelationship cr = com.filenet.api.core.Factory.ComponentRelationship.createInstance(os, null);
			cr.set_ParentComponent(parentDoc);
			cr.set_ChildComponent(childDoc);
			cr.set_ComponentCascadeDelete(ComponentCascadeDeleteAction.CASCADE_DELETE);
			return cr;
		}
	}

	public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map propMap)
	{
		return createDocument(os, symbolicName, documentTitle, propMap, false);
	}

	public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map propMap, boolean isCompoundDocument)
	{
		Document doc = com.filenet.api.core.Factory.Document.createInstance(os, symbolicName);
		Properties props = doc.getProperties();
		if (propMap != null)
		{
			String techProcDocId = "techProcDocId";
			String dcoTitle = "DocumentTitle";
			props.putValue(dcoTitle, documentTitle);
			if (propMap.get(techProcDocId) != null)
			{
				props.putObjectValue(techProcDocId, new Id(propMap.get(techProcDocId).toString()));
				propMap.remove(techProcDocId);
			}
			if (propMap.get(dcoTitle) != null)
				propMap.remove(dcoTitle);
			updateAttributes(props, propMap);
		}
		if (isCompoundDocument)
			doc.set_CompoundDocumentState(CompoundDocumentState.COMPOUND_DOCUMENT);
		doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
		doc.save(RefreshMode.REFRESH);
		return doc;
	}

	public static void updateAttributes(Properties props, Map propMap)
	{
		if (propMap != null && !propMap.isEmpty())
		{
			for (Iterator it = propMap.keySet().iterator(); it.hasNext();)
			{
				String key = (String)it.next();
				Object value = propMap.get(key);
				if (props.isPropertyPresent(key) || value != null)
				{
					if (value != null && (value instanceof List) && !(value instanceof StringList))
					{
						StringList list = com.filenet.api.core.Factory.StringList.createList();
						Object obj;
						for (Iterator iterator = ((List)value).iterator(); iterator.hasNext(); list.add(obj))
							obj = iterator.next();

						value = list;
					}
					try
					{
						if (props.isPropertyPresent(key))
							props.get(key).setObjectValue(value);
						else
							props.putObjectValue(key, value);
					}
					catch (EngineRuntimeException e)
					{
						throw new RuntimeException((new StringBuilder("error when set property value. propName: ")).append(key).append(", value: ").append(value).toString(), e);
					}
				}
			}

		}
	}

	public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map propMap, ContentElementList contentElementList)
	{
		return createDocument(os, symbolicName, documentTitle, propMap, false, contentElementList);
	}

	public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map propMap, boolean isCompoundDocument, ContentElementList contentElementList)
	{
		Document doc = com.filenet.api.core.Factory.Document.createInstance(os, symbolicName);
		if (propMap != null)
		{
			Properties props = doc.getProperties();
			String docTitle = "documentTitle";
			props.putValue(docTitle, documentTitle);
			if (propMap.get(docTitle) != null)
				propMap.remove(docTitle);
			updateAttributes(props, propMap);
		}
		if (contentElementList != null)
			setContentElementList(doc, contentElementList);
		if (isCompoundDocument)
			doc.set_CompoundDocumentState(CompoundDocumentState.COMPOUND_DOCUMENT);
		doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
		doc.save(RefreshMode.REFRESH);
		return doc;
	}

	public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map propMap, Folder folder)
	{
		Document doc = createDocument(os, symbolicName, documentTitle, propMap);
		ReferentialContainmentRelationship rcr = folder.file(doc, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
		rcr.save(RefreshMode.NO_REFRESH);
		return doc;
	}

	public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map propMap, InputStream ins)
	{
		Document doc = com.filenet.api.core.Factory.Document.createInstance(os, symbolicName);
		if (propMap != null)
		{
			Properties props = doc.getProperties();
			String docTitle = "DocumentTitle";
			props.putValue(docTitle, documentTitle);
			if (propMap.get(docTitle) != null)
				propMap.remove(docTitle);
			updateAttributes(props, propMap);
		}
		doc.save(RefreshMode.NO_REFRESH);
		if (ins != null)
		{
			ContentElementList contentElementList = com.filenet.api.core.Factory.ContentElement.createList();
			ContentTransfer transfer = com.filenet.api.core.Factory.ContentTransfer.createInstance();
			transfer.setCaptureSource(ins);
			transfer.set_RetrievalName(documentTitle);
			contentElementList.add(transfer);
			setContentElementList(doc, contentElementList);
			doc.save(RefreshMode.NO_REFRESH);
		}
		doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
		doc.save(RefreshMode.REFRESH);
		return doc;
	}

	public static Document createDocument(ObjectStore os, String symbolicName, String documentTitle, Map propMap, Map content)
	{
		Document doc = com.filenet.api.core.Factory.Document.createInstance(os, symbolicName);
		if (propMap != null)
		{
			Properties props = doc.getProperties();
			String docTitle = "DocumentTitle";
			props.putValue(docTitle, documentTitle);
			if (propMap.get(docTitle) != null)
				propMap.remove(docTitle);
			updateAttributes(props, propMap);
		}
		doc.save(RefreshMode.NO_REFRESH);
		if (content != null && !content.isEmpty())
		{
			ContentElementList contentElementList = com.filenet.api.core.Factory.ContentElement.createList();
			ContentTransfer transfer;
			for (Iterator it = content.keySet().iterator(); it.hasNext(); contentElementList.add(transfer))
			{
				String name = (String)it.next();
				InputStream ins = (InputStream)content.get(name);
				transfer = com.filenet.api.core.Factory.ContentTransfer.createInstance();
				transfer.setCaptureSource(ins);
				transfer.set_RetrievalName(name);
			}

			setContentElementList(doc, contentElementList);
			doc.save(RefreshMode.NO_REFRESH);
		}
		doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
		doc.save(RefreshMode.REFRESH);
		return doc;
	}

	public static void deleteDocument(Document document)
	{
		document.delete();
		document.save(RefreshMode.NO_REFRESH);
	}

	public static void deleteDocumentById(ObjectStore os, String docId)
	{
		Document doc = fetchDocumentById(os, docId);
		deleteDocument(doc);
	}

	public static void deleteDocumentByPath(ObjectStore os, String docPath)
	{
		Document doc = fetchDocumentByPath(os, docPath);
		deleteDocument(doc);
	}

	public static void deleteDocumentWithAllVersions(ObjectStore os, String docId)
	{
		Document doc = fetchDocumentById(os, docId);
		deleteDocumentWithAllVersions(doc);
	}

	public static void deleteDocumentWithAllVersions(Document doc)
	{
		VersionSeries verSeries = doc.get_VersionSeries();
		verSeries.delete();
		verSeries.save(RefreshMode.REFRESH);
	}

	public static Document fetchCurrentVersionDocument(ObjectStore os, String docId)
	{
		com.filenet.api.core.Versionable versionable = fetchDocumentById(os, docId).get_CurrentVersion();
		return versionable != null ? (Document)versionable : null;
	}

	public static Document fetchDocumentById(ObjectStore os, String docId)
	{
		return fetchDocumentById(os, docId, null);
	}

	public static Document fetchDocumentById(ObjectStore os, String docId, PropertyFilter docPropFilter)
	{
		return com.filenet.api.core.Factory.Document.fetchInstance(os, new Id(docId), docPropFilter);
		EngineRuntimeException ex;
		ex;
		if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND)
		{
			logger.error(ex.getMessage());
			return null;
		} else
		{
			throw ex;
		}
	}

	public static Document fetchDocumentByPath(ObjectStore os, String docPath)
	{
		return fetchDocumentByPath(os, docPath, null);
	}

	public static Document fetchDocumentByPath(ObjectStore os, String docPath, PropertyFilter docPropFilter)
	{
		return com.filenet.api.core.Factory.Document.fetchInstance(os, docPath, docPropFilter);
		EngineRuntimeException ex;
		ex;
		if (ex.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND)
		{
			logger.warn((new StringBuilder("Document cannot be found by path '")).append(docPath).append("'.").toString());
			return null;
		} else
		{
			throw ex;
		}
	}

	public static Document fetchReservedDocument(ObjectStore os, String docId)
	{
		com.filenet.api.core.IndependentObject ido = fetchDocumentById(os, docId).get_Reservation();
		return ido != null ? (Document)ido : null;
	}

	public static void file(Document doc, Folder folder)
	{
		file(((UpdatingBatch) (null)), doc, folder);
	}

	public static void file(UpdatingBatch ub, Document doc, Folder folder)
	{
		for (Iterator it = doc.get_FoldersFiledIn().iterator(); it.hasNext();)
			if (((Folder)it.next()).get_Id().equals(folder.get_Id()))
			{
				logger.warn((new StringBuilder("重复File: DocumentID:")).append(doc.get_Id()).append(",FolderId:").append(folder.get_Id()).toString());
				return;
			}

		ReferentialContainmentRelationship rcr = folder.file(doc, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
		if (ub == null)
			rcr.save(RefreshMode.NO_REFRESH);
		else
		if (ub.hasPendingExecute())
			P8CustomObjectDao.addToUpdatingBatchUniquly(ub, rcr);
	}

	public static void file(IndependentlyPersistableObject independentlyPersistableObject, Folder folder, String containmentName)
	{
		ReferentialContainmentRelationship rcr = folder.file(independentlyPersistableObject, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
		if (containmentName != null && !containmentName.equals(""))
			rcr.set_ContainmentName(containmentName);
		rcr.save(RefreshMode.NO_REFRESH);
	}

	public static void file(ObjectStore os, String docId, String folderId)
	{
		Folder folder = P8FolderDao.fetchFolderById(os, folderId);
		Document doc = fetchDocumentById(os, docId);
		file(doc, folder);
	}

	public static List getAllVersionDocuments(ObjectStore os, String docId)
	{
		List items = new ArrayList();
		Document doc = fetchDocumentById(os, docId);
		VersionableSet versions = doc.get_Versions();
		Document subDoc;
		for (Iterator it = versions.iterator(); it.hasNext(); items.add(subDoc))
			subDoc = (Document)it.next();

		return items;
	}

	public static Map getCEObjectProperties(ObjectStore os, String docId)
	{
		Map map = new HashMap();
		Document doc = fetchDocumentById(os, docId);
		Properties ps = doc.getProperties();
		String className = doc.getClassName();
		ClassDefinition objClzDef = com.filenet.api.core.Factory.ClassDefinition.fetchInstance(os, className, null);
		PropertyDefinitionList pdd = objClzDef.get_PropertyDefinitions();
		for (Iterator itp = pdd.iterator(); itp.hasNext();)
		{
			PropertyDefinition pd = (PropertyDefinition)itp.next();
			if (!pd.get_IsSystemOwned().booleanValue())
			{
				String propName = pd.get_SymbolicName();
				Object obj = ps.getObjectValue(propName);
				propName = StringUtils.uncapitalize(propName);
				map.put(propName, obj);
			}
		}

		map.put("id", docId);
		return map;
	}

	public static InputStream getContentElement(ObjectStore os, String docId, int index)
	{
		Document doc = fetchDocumentById(os, docId);
		ContentElementList contentList = doc.get_ContentElements();
		ContentTransfer transfer = (ContentTransfer)contentList.get(index);
		return transfer.accessContentStream();
	}

	public static boolean isCheckedOut(ObjectStore os, String docId)
	{
		return fetchReservedDocument(os, docId) != null;
	}

	public static Map iterateDocumentAttributes(ObjectStore os, Document doc)
	{
		return ObjectStoreUtil.iterateAttributes(os, doc);
	}

	public static Map iterateDocumentAttributesById(ObjectStore os, String docId)
	{
		Document doc = fetchDocumentById(os, docId);
		return iterateDocumentAttributes(os, doc);
	}

	public static Map iterateDocumentAttributesByPath(ObjectStore os, String docPath)
	{
		Document doc = fetchDocumentByPath(os, docPath);
		return iterateDocumentAttributes(os, doc);
	}

	public static List listContainedDocuments(Folder parent)
	{
		List docList = new ArrayList();
		DocumentSet docSet = parent.get_ContainedDocuments();
		Document doc;
		for (Iterator iterator = docSet.iterator(); iterator.hasNext(); docList.add(doc))
			doc = (Document)iterator.next();

		return docList;
	}

	public static List listContainedDocumentsById(ObjectStore os, String parentId)
	{
		Folder parent = P8FolderDao.fetchFolderById(os, parentId);
		return listContainedDocuments(parent);
	}

	public static List listContainedDocumentsByPath(ObjectStore os, String parentPath)
	{
		Folder parent = P8FolderDao.fetchFolderByPath(os, parentPath);
		return listContainedDocuments(parent);
	}

	public static List listCustomObjects(ObjectStore os, String symbolicName)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicName, false, null, null, "").setScope(os).setPropertyFilter().fetchCustomObjects();
	}

	public static List listDocuments(ObjectStore os, String symbolicName, boolean includeSubclasses)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicName, includeSubclasses, null, null, "").setScope(os).setPropertyFilter().fetchDocuments();
	}

	public static List searchForDocuments(ObjectStore os, String symbolicClassName, String whereClause)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicClassName, false, whereClause, null, "").setScope(os).setPropertyFilter().fetchDocuments();
	}

	public static List searchForDocuments(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause)
	{
		return searchForDocuments(os, symbolicClassName, includeSubclasses, whereClause, null);
	}

	public static List searchForDocuments(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, List selectList)
	{
		return searchForDocuments(os, symbolicClassName, includeSubclasses, whereClause, selectList, -1);
	}

	public static List searchForDocuments(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, List selectList, int maxRecords)
	{
		Search search = new Search();
		return search.setObjectSql(symbolicClassName, includeSubclasses, whereClause, null, selectList, maxRecords).setScope(os).setPropertyFilter().fetchDocuments();
	}

	public static List searchForDocumentsCount(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause)
	{
		Search search = new Search();
		return search.setObjectSql("d.Id", symbolicClassName, includeSubclasses, whereClause, null, -1).setScope(os).setPropertyFilter().fetchDocuments();
	}

	public static List searchForDocuments(ObjectStore os, String selectClause, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause)
	{
		boolean distinct = true;
		Search search = new Search();
		return search.setObjectSql(distinct, selectClause, symbolicClassName, includeSubclasses, whereClause, orderByClause).setScope(os).setPropertyFilter().fetchDocuments();
	}

	public static List searchForDocumentsForFullTextSearch(ObjectStore os, String symbolicClassName, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords, String searchTitle, List selectList)
	{
		Search search = new Search();
		return search.setObjectSqlForFullTextSearch(symbolicClassName, includeSubclasses, whereClause, orderByClause, maxRecords, searchTitle, selectList).setScope(os).setPropertyFilter().fetchRows();
	}

	public static void unfile(Document doc, Folder folder)
	{
		unfile(((UpdatingBatch) (null)), doc, folder);
	}

	public static void unfile(UpdatingBatch ub, Document doc, Folder folder)
	{
		ReferentialContainmentRelationship rcr = folder.unfile(doc);
		if (ub == null)
			rcr.save(RefreshMode.NO_REFRESH);
		else
		if (ub.hasPendingExecute())
			P8CustomObjectDao.addToUpdatingBatchUniquly(ub, rcr);
	}

	public static void unfile(ObjectStore os, String docId, String folderId)
	{
		Folder folder = P8FolderDao.fetchFolderById(os, folderId);
		Document doc = fetchDocumentById(os, docId);
		FolderSet folders = doc.get_FoldersFiledIn();
		for (Iterator iter = folders.iterator(); iter.hasNext();)
		{
			Folder eachFolder = (Folder)iter.next();
			if (eachFolder.get_Id().toString().equalsIgnoreCase(folderId))
				unfile(doc, folder);
		}

	}

	public static boolean updateAttributes(ObjectStore os, IndependentlyPersistableObject ipo, Map updatedAttrs)
	{
		return updateAttributes(os, ipo, updatedAttrs, null);
	}

	public static boolean updateAttributes(ObjectStore os, IndependentlyPersistableObject ipo, Map updatedAttrs, UpdatingBatch ub)
	{
		boolean flag = false;
		if (updatedAttrs == null || updatedAttrs.isEmpty())
			return true;
		Properties props = ipo.getProperties();
		String techProcDocId = "techProcDocId";
		if (updatedAttrs.get(techProcDocId) != null)
		{
			props.putObjectValue(techProcDocId, new Id(updatedAttrs.get(techProcDocId).toString()));
			updatedAttrs.remove(techProcDocId);
		}
		updateAttributes(props, updatedAttrs);
		if (ub == null)
			ipo.save(RefreshMode.REFRESH);
		else
			P8CustomObjectDao.addToUpdatingBatchUniquly(ub, ipo);
		flag = true;
		return flag;
	}

	public static void updateDocumentAttribute(ObjectStore os, Document doc, String propertyName, Object propertyValue)
	{
		updateDocumentAttribute(os, doc, propertyName, propertyValue, null);
	}

	public static void updateDocumentAttribute(ObjectStore os, Document doc, String propertyName, Object propertyValue, UpdatingBatch ub)
	{
		Map updatedAttrs = new HashMap();
		updatedAttrs.put(propertyName, propertyValue);
		updateAttributes(os, doc, updatedAttrs, ub);
	}

	public static void updateDocumentAttributes(ObjectStore os, Document doc, Map updatedAttrs)
	{
		updateAttributes(os, doc, updatedAttrs);
	}

	public static void updateDocumentAttributes(ObjectStore os, String docId, String symbolicClassName, Map updatedAttrs)
	{
		updateAttributes(os, fetchDocumentById(os, docId), updatedAttrs);
	}

	public static FolderSet getFiledFolders(ObjectStore os, String docId)
	{
		Document document = fetchDocumentById(os, docId);
		FolderSet result = document.get_FoldersFiledIn();
		return result;
	}

	public static void move(ObjectStore os, Document doc, Folder destFolder, Folder origFolder)
	{
		UpdatingBatch ub = UpdatingBatch.createUpdatingBatchInstance(os.get_Domain(), RefreshMode.REFRESH);
		ReferentialContainmentRelationship rcr1 = origFolder.unfile(doc);
		P8CustomObjectDao.addToUpdatingBatchUniquly(ub, rcr1);
		ReferentialContainmentRelationship rcr = destFolder.file(doc, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
		rcr.set_ContainmentName(doc.getProperties().getStringValue("DocumentTitle"));
		P8CustomObjectDao.addToUpdatingBatchUniquly(ub, rcr);
		ub.updateBatch();
	}

	public static void setContentElementList(Document reservation, ContentElementList contentElementList)
	{
		reservation.set_ContentElements(contentElementList);
	}

	public static ContentElementList copyContentElementList(ContentElementList contentElementList)
	{
		ContentElementList newEleList = null;
		if (contentElementList != null && contentElementList.size() > 0)
		{
			newEleList = com.filenet.api.core.Factory.ContentElement.createList();
			ContentTransfer newElement;
			for (Iterator it = contentElementList.iterator(); it.hasNext(); newEleList.add(newElement))
			{
				ContentTransfer originalElement = (ContentTransfer)it.next();
				newElement = com.filenet.api.core.Factory.ContentTransfer.createInstance();
				newElement.setCaptureSource(originalElement.accessContentStream());
				newElement.set_RetrievalName(originalElement.get_RetrievalName());
				newElement.set_ContentType(originalElement.get_ContentType());
			}

		}
		return newEleList;
	}

	public static Document copyDocument(ObjectStore os, Document destDoc, Document origDoc, boolean isDelOrigDoc, boolean isCopyPermission, List ignoreProps)
	{
		Document tempDestDoc = destDoc;
		boolean isCreate = tempDestDoc == null;
		if (!isCreate)
		{
			if (!tempDestDoc.get_IsCurrentVersion().booleanValue())
				tempDestDoc = (Document)tempDestDoc.get_CurrentVersion();
			if (!tempDestDoc.get_IsReserved().booleanValue())
				checkOutDocument(os, tempDestDoc);
		}
		Properties orig = origDoc.getProperties();
		if (ignoreProps == null)
			ignoreProps = new ArrayList();
		Map propMap = new HashMap();
		for (Iterator it1 = orig.iterator(); it1.hasNext();)
		{
			Property pro_orig = (Property)it1.next();
			if (!ignoreProps.contains(pro_orig.getPropertyName()) && !(pro_orig instanceof PropertyIndependentObjectSet) && !(pro_orig instanceof PropertyEngineObject) && !(pro_orig instanceof PropertyDependentObjectList) && !(pro_orig instanceof PropertyContent))
			{
				boolean isSettable = false;
				if (isCreate)
					isSettable = pro_orig.isSettable();
				else
				if (tempDestDoc.getProperties().isPropertyPresent(pro_orig.getPropertyName()))
					isSettable = tempDestDoc.getProperties().get(pro_orig.getPropertyName()).isSettable();
				if (isSettable)
					if (isCreate)
					{
						propMap.put(pro_orig.getPropertyName(), orig.getObjectValue(pro_orig.getPropertyName()));
					} else
					{
						Properties dest = tempDestDoc.getProperties();
						if (dest.isPropertyPresent(pro_orig.getPropertyName()))
						{
							Property pro_dest = dest.get(pro_orig.getPropertyName());
							if (pro_dest.isSettable() && pro_orig.getClass().equals(pro_dest.getClass()))
								propMap.put(pro_dest.getPropertyName(), orig.getObjectValue(pro_dest.getPropertyName()));
						}
					}
			}
		}

		ContentElementList newEleList = copyContentElementList(origDoc.get_ContentElements());
		if (isCreate)
		{
			String documentTitle = propMap.get("DocumentTitle") != null ? propMap.get("DocumentTitle").toString() : null;
			tempDestDoc = createDocument(os, origDoc.getClassName(), documentTitle, propMap, newEleList);
		} else
		{
			checkInDocumentAsMajor(null, os, tempDestDoc, propMap, newEleList);
		}
		if (isCopyPermission)
		{
			tempDestDoc.refresh();
			tempDestDoc = (Document)tempDestDoc.get_ReleasedVersion();
			tempDestDoc.set_Permissions(origDoc.get_Permissions());
		}
		if (isDelOrigDoc)
		{
			origDoc.delete();
			origDoc.save(RefreshMode.REFRESH);
		}
		return (Document)tempDestDoc.get_CurrentVersion();
	}

}
