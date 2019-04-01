// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   P8LinkDao.java

package com.ibm.filenet.api.ce;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.*;
import com.ibm.filenet.api.ce.search.Search;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ibm.filenet.api.ce:
//			P8DocumentDao

public class P8LinkDao
{

	public P8LinkDao()
	{
	}

	public static Link createLink(ObjectStore os, String className, IndependentObject head, IndependentObject tail)
	{
		return createLink(os, className, head, tail, null);
	}

	public static Link createLink(ObjectStore os, String className, IndependentObject head, IndependentObject tail, Map propMap)
	{
		Link link = com.filenet.api.core.Factory.Link.createInstance(os, className);
		P8DocumentDao.updateAttributes(link.getProperties(), propMap);
		link.set_Head(head);
		link.set_Tail(tail);
		link.save(RefreshMode.REFRESH);
		return link;
	}

	public static List fetchAllLinks(ObjectStore os, String className, String docId)
	{
		Search search = new Search();
		String whereClause = (new StringBuilder("(Head = Object('")).append(docId).append("')) or (Tail = Object('").append(docId).append("'))").toString();
		return search.setObjectSql(className, true, whereClause, null, "").setScope(os).setPropertyFilter().fetchLinks();
	}

	public static List fetchLinksByTail(ObjectStore os, String className, String tailId)
	{
		Search search = new Search();
		String whereClause = (new StringBuilder("(Tail = Object('")).append(tailId).append("'))").toString();
		return search.setObjectSql(className, true, whereClause, null, "").setScope(os).setPropertyFilter().fetchLinks();
	}

	public static List fetchLinksByHead(ObjectStore os, String className, String headId)
	{
		Search search = new Search();
		String whereClause = (new StringBuilder("(Head = Object('")).append(headId).append("'))").toString();
		return search.setObjectSql(className, true, whereClause, null, "").setScope(os).setPropertyFilter().fetchLinks();
	}
}
