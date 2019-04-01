// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Search.java

package com.ibm.filenet.api.ce.search;

import com.filenet.api.collection.*;
import com.filenet.api.constants.*;
import com.filenet.api.core.*;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.exception.ExceptionCode;
import com.filenet.api.property.*;
import com.filenet.api.query.*;
import com.ibm.filenet.api.util.EngineCollectionUtils;
import com.ibm.filenet.login.CEConfigOptions;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

// Referenced classes of package com.ibm.filenet.api.ce.search:
//			Pagination

public class Search
{

	private Logger logger;
	private ObjectStore os;
	private SearchSQL sql;
	private SearchScope searchScope;
	private PropertyFilter filter;
	private int pageSize;
	private boolean continuable;
	private int desiredPageIndex;

	public Search()
	{
		logger = Logger.getLogger(getClass());
		pageSize = 100;
		continuable = true;
		desiredPageIndex = 0;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public Search setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
		return this;
	}

	public int getDesiredPageIndex()
	{
		return desiredPageIndex;
	}

	public Search setDesiredPageIndex(int desiredPageIndex)
	{
		this.desiredPageIndex = desiredPageIndex;
		return this;
	}

	public Search setRowSql(String className, boolean includeSubclasses, String searchExpr)
	{
		sql = new SearchSQL();
		sql.setSelectList("*");
		sql.setFromClauseInitialValue(className, null, includeSubclasses);
		if (!StringUtils.isEmpty(searchExpr))
			sql.setContainsRestriction(className, searchExpr);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("sql: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setRowSql(String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords, boolean isFullText)
	{
		sql = new SearchSQL();
		String alias = "d";
		sql.setSelectList((new StringBuilder(String.valueOf(alias))).append(".*, cs.Rank").toString());
		sql.setFromClauseInitialValue(className, alias, includeSubclasses);
		if (isFullText)
			sql.setFromClauseAdditionalJoin(JoinOperator.INNER, "ContentSearch", "cs", "d.This", JoinComparison.EQUAL, "cs.QueriedObject", includeSubclasses);
		if (!StringUtils.isEmpty(whereClause))
			sql.setWhereClause(whereClause);
		if (!StringUtils.isEmpty(orderByClause))
			sql.setOrderByClause(orderByClause);
		if (maxRecords != -1)
			sql.setMaxRecords(maxRecords);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("Search SQL: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setObjectSql(String className, boolean includeSubclasses, String whereClause, List selectList, String orderProperty)
	{
		return setObjectSql(className, includeSubclasses, whereClause, orderProperty, selectList, -1);
	}

	public Search setObjectSql(String className, boolean includeSubclasses, String whereClause, String orderByClause, List selectList, int maxRecords)
	{
		sql = new SearchSQL();
		String alias = "d";
		String selectStr = null;
		if (selectList == null || selectList.size() == 0)
		{
			selectStr = (new StringBuilder(String.valueOf(alias))).append(".*").toString();
		} else
		{
			for (Iterator iterator = selectList.iterator(); iterator.hasNext();)
			{
				String prop = (String)iterator.next();
				selectStr = selectStr != null ? (new StringBuilder(String.valueOf(selectStr))).append(",").append(alias).append(".").append(prop).toString() : (new StringBuilder(String.valueOf(alias))).append(".").append(prop).toString();
			}

		}
		sql.setSelectList(selectStr);
		sql.setFromClauseInitialValue(className, alias, includeSubclasses);
		if (!StringUtils.isEmpty(whereClause))
			sql.setWhereClause(whereClause);
		if (!StringUtils.isEmpty(orderByClause))
			sql.setOrderByClause(orderByClause);
		if (maxRecords > 0)
			sql.setMaxRecords(maxRecords);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("Search SQL: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setObjectSql(String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords)
	{
		sql = new SearchSQL();
		String alias = "d";
		sql.setSelectList((new StringBuilder(String.valueOf(alias))).append(".*").toString());
		sql.setFromClauseInitialValue(className, alias, includeSubclasses);
		if (!StringUtils.isEmpty(whereClause))
			sql.setWhereClause(whereClause);
		if (!StringUtils.isEmpty(orderByClause))
			sql.setOrderByClause(orderByClause);
		if (maxRecords != -1)
			sql.setMaxRecords(maxRecords);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("Search SQL: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setObjectSql(String selectClause, String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords)
	{
		sql = new SearchSQL();
		String alias = "d";
		if (StringUtils.isEmpty(selectClause))
			sql.setSelectList((new StringBuilder(String.valueOf(alias))).append(".*").toString());
		else
			sql.setSelectList(selectClause);
		sql.setFromClauseInitialValue(className, alias, includeSubclasses);
		if (!StringUtils.isEmpty(whereClause))
			sql.setWhereClause(whereClause);
		if (!StringUtils.isEmpty(orderByClause))
			sql.setOrderByClause(orderByClause);
		if (maxRecords != -1)
			sql.setMaxRecords(maxRecords);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("Search SQL: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setObjectSql(String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords, boolean isFullText)
	{
		sql = new SearchSQL();
		String alias = "d";
		sql.setSelectList((new StringBuilder(String.valueOf(alias))).append(".*").toString());
		sql.setFromClauseInitialValue(className, alias, includeSubclasses);
		if (isFullText)
		{
			sql.setFromClauseAdditionalJoin(JoinOperator.INNER, "ContentSearch", "cs", "d.This", JoinComparison.EQUAL, "cs.QueriedObject", includeSubclasses);
			sql.setWhereClause(" CONTAINS(d.*, 'com')");
		}
		if (!StringUtils.isEmpty(whereClause) || whereClause.length() > 0)
			sql.setWhereClause(whereClause);
		if (!StringUtils.isEmpty(orderByClause))
			sql.setOrderByClause(orderByClause);
		if (maxRecords != -1)
			sql.setMaxRecords(maxRecords);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("Search SQL: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setObjectSqlForFullTextSearch(String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords, String searchTile, List selectList)
	{
		sql = new SearchSQL();
		String alias = "d";
		String selectStr = null;
		if (selectList == null || selectList.size() == 0)
		{
			selectStr = (new StringBuilder(String.valueOf(alias))).append(".*").toString();
		} else
		{
			for (Iterator iterator = selectList.iterator(); iterator.hasNext();)
			{
				String prop = (String)iterator.next();
				selectStr = selectStr != null ? (new StringBuilder(String.valueOf(selectStr))).append(",").append(alias).append(".").append(prop).toString() : (new StringBuilder(String.valueOf(alias))).append(".").append(prop).toString();
			}

		}
		selectStr = (new StringBuilder(String.valueOf(selectStr))).append(" , d.Id, d.DateCreated, d.Creator , cs.ContentSummary ").toString();
		sql.setSelectList(selectStr);
		sql.setFromClauseInitialValue(className, alias, includeSubclasses);
		sql.setFromClauseAdditionalJoin(JoinOperator.INNER, "ContentSearch", "cs", "d.This", JoinComparison.EQUAL, "cs.QueriedObject", includeSubclasses);
		sql.setMaxRecords(maxRecords);
		String newWhereClause = (new StringBuilder("CONTAINS(*, '")).append(searchTile).append("')").toString();
		if (StringUtils.isNotEmpty(whereClause))
			whereClause = (new StringBuilder(String.valueOf(newWhereClause))).append(" AND (").append(whereClause).append(")").toString();
		sql.setWhereClause(newWhereClause);
		if (!StringUtils.isEmpty(orderByClause))
			sql.setOrderByClause(orderByClause);
		logger.debug((new StringBuilder("全文�?索的搜索语句 Search SQL: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setObjectSql(boolean distinct, String className, boolean includeSubclasses, String whereClause, String orderByClause)
	{
		sql = new SearchSQL();
		if (distinct)
			sql.setDistinct();
		String alias = "d";
		sql.setSelectList((new StringBuilder(String.valueOf(alias))).append(".*").toString());
		sql.setFromClauseInitialValue(className, alias, includeSubclasses);
		if (!StringUtils.isEmpty(whereClause))
			sql.setWhereClause(whereClause);
		if (!StringUtils.isEmpty(orderByClause))
			sql.setOrderByClause(orderByClause);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("Search SQL: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setObjectSql(boolean distinct, String selectClause, String className, boolean includeSubclasses, String whereClause, String orderByClause)
	{
		sql = new SearchSQL();
		if (distinct)
			sql.setDistinct();
		String alias = "d";
		if (StringUtils.isEmpty(selectClause))
			sql.setSelectList((new StringBuilder(String.valueOf(alias))).append(".*").toString());
		else
			sql.setSelectList(selectClause);
		sql.setFromClauseInitialValue(className, alias, includeSubclasses);
		if (!StringUtils.isEmpty(whereClause))
			sql.setWhereClause(whereClause);
		if (!StringUtils.isEmpty(orderByClause))
			sql.setOrderByClause(orderByClause);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("Search SQL: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setObjectSql(boolean distinct, String selectClause, String className, boolean includeSubclasses, String whereClause, String orderByClause, int maxRecords)
	{
		sql = new SearchSQL();
		if (distinct)
			sql.setDistinct();
		String alias = "d";
		if (StringUtils.isEmpty(selectClause))
			sql.setSelectList((new StringBuilder(String.valueOf(alias))).append(".*").toString());
		else
			sql.setSelectList(selectClause);
		sql.setFromClauseInitialValue(className, alias, includeSubclasses);
		if (!StringUtils.isEmpty(whereClause))
			sql.setWhereClause(whereClause);
		if (!StringUtils.isEmpty(orderByClause))
			sql.setOrderByClause(orderByClause);
		if (maxRecords != -1)
			sql.setMaxRecords(maxRecords);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("Search SQL: ")).append(sql.toString()).toString());
		return this;
	}

	public Search setScope(ObjectStore os)
	{
		this.os = os;
		searchScope = new SearchScope(os);
		return this;
	}

	public Search setScope(ObjectStore os[])
	{
		searchScope = new SearchScope(os, MergeMode.UNION);
		return this;
	}

	public Search setPropertyFilter()
	{
		PropertyFilter filter = new PropertyFilter();
		filter.setMaxRecursion(1);
		filter.addIncludeType(new FilterElement(null, null, null, FilteredPropertyType.ANY, null));
		return this;
	}

	public Search setPropertyFilter(PropertyFilter filter)
	{
		this.filter = filter;
		return this;
	}

	public IndependentObjectSet fetchIndependentObjectSet()
	{
		return searchScope.fetchObjects(sql, Integer.valueOf(pageSize), filter, Boolean.valueOf(continuable));
	}

	public List fetchObjects()
	{
		IndependentObjectSet objects = searchScope.fetchObjects(sql, Integer.valueOf(pageSize), filter, Boolean.valueOf(continuable));
		List independentObjects = new ArrayList();
		IndependentObject doc;
		for (Iterator iterator = EngineCollectionUtils.c(objects, com/filenet/api/core/IndependentObject).iterator(); iterator.hasNext(); independentObjects.add(doc))
			doc = (IndependentObject)iterator.next();

		return independentObjects;
	}

	public List fetchCustomObjects()
	{
		IndependentObjectSet objects = searchScope.fetchObjects(sql, Integer.valueOf(pageSize), filter, Boolean.valueOf(continuable));
		List customObjects = new ArrayList();
		CustomObject co;
		for (Iterator iterator = EngineCollectionUtils.c(objects, com/filenet/api/core/CustomObject).iterator(); iterator.hasNext(); customObjects.add(co))
			co = (CustomObject)iterator.next();

		return customObjects;
	}

	public List fetchDocuments()
	{
		IndependentObjectSet objects = searchScope.fetchObjects(sql, Integer.valueOf(pageSize), filter, Boolean.valueOf(continuable));
		List documents = new ArrayList();
		Document doc;
		for (Iterator iterator = EngineCollectionUtils.c(objects, com/filenet/api/core/Document).iterator(); iterator.hasNext(); documents.add(doc))
			doc = (Document)iterator.next();

		return documents;
	}

	public List fetchFolders()
	{
		IndependentObjectSet objects = searchScope.fetchObjects(sql, Integer.valueOf(pageSize), filter, Boolean.valueOf(continuable));
		List folders = new ArrayList();
		Folder folder;
		for (Iterator iterator = EngineCollectionUtils.c(objects, com/filenet/api/core/Folder).iterator(); iterator.hasNext(); folders.add(folder))
			folder = (Folder)iterator.next();

		return folders;
	}

	public List fetchLinks()
	{
		IndependentObjectSet objects = searchScope.fetchObjects(sql, Integer.valueOf(pageSize), filter, Boolean.valueOf(continuable));
		List links = new ArrayList();
		Link doc;
		for (Iterator iterator = EngineCollectionUtils.c(objects, com/filenet/api/core/Link).iterator(); iterator.hasNext(); links.add(doc))
			doc = (Link)iterator.next();

		return links;
	}

	public List fetchRows()
	{
		RepositoryRowSet rowSet = searchScope.fetchRows(sql, Integer.valueOf(pageSize), filter, Boolean.valueOf(continuable));
		List docList = new ArrayList();
		Document doc;
		for (Iterator iterator = EngineCollectionUtils.c(rowSet, com/filenet/api/query/RepositoryRow).iterator(); iterator.hasNext(); docList.add(doc))
		{
			RepositoryRow row = (RepositoryRow)iterator.next();
			com.filenet.api.util.Id docId = row.getProperties().get("Id").getIdValue();
			doc = com.filenet.api.core.Factory.Document.fetchInstance(os, docId, null);
		}

		return docList;
	}

	public List queryDBRowsBySql(String propertyName)
	{
		List propertyNames = new ArrayList();
		RepositoryRowSet rowSet = null;
		try
		{
			rowSet = searchScope.fetchRows(sql, Integer.valueOf(pageSize), filter, Boolean.valueOf(false));
			RepositoryRow row;
			for (Iterator it = rowSet.iterator(); it.hasNext(); propertyNames.add(row.getProperties().getStringValue(propertyName)))
				row = (RepositoryRow)it.next();

		}
		catch (Exception ex)
		{
			logger.error("Error occurred when executing search ", ex);
			throw new RuntimeException(ex);
		}
		return propertyNames;
	}

	public Pagination fetchDocumentsWithPagination()
	{
		if (desiredPageIndex <= 0)
			return null;
		long sTime1 = (new Date()).getTime();
		IndependentObjectSet objects = searchScope.fetchObjects(sql, Integer.valueOf(pageSize), filter, Boolean.valueOf(continuable));
		long sTime3 = (new Date()).getTime();
		logger.debug((new StringBuilder("查询Document耗时1:")).append(sTime3 - sTime1).append("ms").toString());
		PageIterator pageIter = objects.pageIterator();
		logger.debug((new StringBuilder("查询Document耗时2:")).append((new Date()).getTime() - sTime3).append("ms").toString());
		pageIter.setPageSize(pageSize);
		List docList = new ArrayList();
		int currentPageIndex = 1;
		int totalPages = 0;
		int totalNum = 0;
		do
		{
			long sTime2 = (new Date()).getTime();
			if (!pageIter.nextPage())
				break;
			if (currentPageIndex == desiredPageIndex)
			{
				Object docs[] = pageIter.getCurrentPage();
				Object aobj[];
				int j = (aobj = docs).length;
				for (int i = 0; i < j; i++)
				{
					Object d = aobj[i];
					Document document = (Document)d;
					docList.add(document);
				}

			}
			currentPageIndex++;
			totalPages++;
			totalNum += pageIter.getCurrentPage().length;
			logger.debug((new StringBuilder("获取�?")).append(currentPageIndex).append("页�?�时:").append((new Date()).getTime() - sTime2).append("ms").toString());
		} while (true);
		if (desiredPageIndex > totalPages)
			return null;
		else
			return new Pagination(docList, pageSize, desiredPageIndex, totalNum);
	}

	public Pagination fetchDocumentsWithPagination_modified()
	{
		if (desiredPageIndex <= 0)
			return null;
		int pageSizeOfCE = CEConfigOptions.getSearchMaxPageSize();
		int totalTopCount = 0;
		if (pageSize == 0x7fffffff)
		{
			totalTopCount = 0x7fffffff;
		} else
		{
			totalTopCount = ((desiredPageIndex * pageSize) / pageSizeOfCE) * pageSizeOfCE;
			if (totalTopCount == desiredPageIndex * pageSize)
				totalTopCount++;
			else
				totalTopCount += pageSizeOfCE + 1;
			sql.setMaxRecords(totalTopCount);
		}
		IndependentObjectSet objects;
		try
		{
			objects = searchScope.fetchObjects(sql, Integer.valueOf(totalTopCount), filter, Boolean.valueOf(true));
		}
		catch (EngineRuntimeException e)
		{
			if (e.getExceptionCode() == ExceptionCode.E_BAD_CLASSID)
				throw new RuntimeException("查询的分类不存在", e);
			else
				throw e;
		}
		PageIterator pageIter = objects.pageIterator();
		List docs = new ArrayList();
		while (pageIter.nextPage()) 
		{
			Object docsOfPage[] = pageIter.getCurrentPage();
			Object aobj[];
			int j = (aobj = docsOfPage).length;
			for (int i = 0; i < j; i++)
			{
				Object obj = aobj[i];
				docs.add(obj);
			}

		}
		int totalNum = docs.size();
		logger.debug((new StringBuilder("�?索出的条目数�?")).append(totalNum).toString());
		if (totalTopCount == totalNum)
			docs.remove(totalNum - 1);
		List docList = new ArrayList();
		Document document;
		for (Iterator iterator = docs.iterator(); iterator.hasNext(); docList.add(document))
		{
			Object object = iterator.next();
			document = (Document)object;
		}

		return new Pagination(docList, pageSize, desiredPageIndex, totalNum);
	}
}
