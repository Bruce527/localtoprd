// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DomainProvider.java

package com.ibm.filenet.login;

import com.filenet.api.collection.ObjectStoreSet;
import com.filenet.api.core.*;
import com.filenet.api.property.PropertyFilter;
import java.util.*;

public class DomainProvider
{

	private static DomainProvider instance;

	private DomainProvider()
	{
	}

	public static synchronized DomainProvider getInstance()
	{
		if (instance == null)
			instance = new DomainProvider();
		return instance;
	}

	public Domain fetchDomain(Connection connection, String domainName)
	{
		return fetchDomain(connection, domainName, null);
	}

	public Domain fetchDomain(Connection connection, String domainName, PropertyFilter domainPropFilter)
	{
		return com.filenet.api.core.Factory.Domain.fetchInstance(connection, domainName, domainPropFilter);
	}

	public ObjectStore fetchObjectStore(Connection connection, String domainName, String objectStoreName)
	{
		return fetchObjectStore(fetchDomain(connection, domainName), objectStoreName, ((PropertyFilter) (null)));
	}

	public ObjectStore getObjectStore(Connection connection, String domainName, String objectStoreName)
	{
		return getObjectStore(fetchDomain(connection, domainName), objectStoreName, ((PropertyFilter) (null)));
	}

	public ObjectStore fetchObjectStore(Connection connection, String domainName, String objectStoreName, PropertyFilter osPropFilter)
	{
		return fetchObjectStore(fetchDomain(connection, domainName), objectStoreName, osPropFilter);
	}

	public ObjectStore fetchObjectStore(Domain domain, String objectStoreName, PropertyFilter osPropFilter)
	{
		return com.filenet.api.core.Factory.ObjectStore.fetchInstance(domain, objectStoreName, osPropFilter);
	}

	public ObjectStore getObjectStore(Domain domain, String objectStoreName, PropertyFilter osPropFilter)
	{
		return com.filenet.api.core.Factory.ObjectStore.getInstance(domain, objectStoreName);
	}

	public List listObjectStores(Domain domain)
	{
		List osList = new ArrayList();
		ObjectStoreSet osSet = domain.get_ObjectStores();
		ObjectStore os;
		for (Iterator iterator = osSet.iterator(); iterator.hasNext(); osList.add(os))
			os = (ObjectStore)iterator.next();

		return osList;
	}

	public List listObjectStoreNames(Domain domain)
	{
		List osNames = new ArrayList();
		ObjectStoreSet osSet = domain.get_ObjectStores();
		ObjectStore os;
		for (Iterator iterator = osSet.iterator(); iterator.hasNext(); osNames.add(os.get_DisplayName()))
			os = (ObjectStore)iterator.next();

		return osNames;
	}
}
