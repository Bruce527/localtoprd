// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CEConectionIIOP.java

package com.sinosoft.banklns.utility;

import com.filenet.api.admin.ClassDefinition;
import com.filenet.api.admin.PropertyDefinition;
import com.filenet.api.collection.ObjectStoreSet;
import com.filenet.api.collection.PropertyDefinitionList;
import com.filenet.api.core.*;
import com.filenet.api.util.UserContext;
import filenet.vw.api.VWException;
import filenet.vw.api.VWSession;
import java.io.PrintStream;
import java.util.Iterator;

public class CEConectionIIOP
{
	private static class CEConfiguration
	{

		private static String FILENET_URI = "iiop://iws.metlife.cn:8091/FileNet/Engine";
		private static String CE_DOMAIN = "P8Domain";
		private static String FILENET_USERNAME = "P8services";
		private static String FILENET_PASSWORD = "Hello01";
		private static String CE_OBJECTSTORE = "IWS";
		private static String PE_CONNECTION_POINT = "";








		private CEConfiguration()
		{
		}
	}


	private static Connection conn;
	private static Domain domain;
	private static ObjectStore os;
	private ObjectStoreSet OStoreSet;

	public CEConectionIIOP()
	{
	}

	public static void testIIOP()
		throws VWException
	{
		System.setProperty("wasp.location", ".\\config\\pe");
		System.setProperty("java.security.auth.login.config", "./config/pe/jaas.conf.WSI");
		System.setProperty("filenet.pe.bootstrap.ceuri", "iiop://iws.metlife.cn:8091/FileNet/Engine");
		System.out.println("stp1:~~~~~~~~~~~``CEConfiguration.FILENET_URI");
		Connection ceConnection = com.filenet.api.core.Factory.Connection.getConnection(CEConfiguration.FILENET_URI);
		System.out.println((new StringBuilder("stp2:~~~~~~~~~~~``")).append(CEConfiguration.FILENET_USERNAME).toString());
		javax.security.auth.Subject ceSubject = UserContext.createSubject(ceConnection, CEConfiguration.FILENET_USERNAME, CEConfiguration.FILENET_PASSWORD, null);
		System.out.println("stp3:~~~~~~~~~~~``pushSubject(ceSubject)");
		UserContext.get().pushSubject(ceSubject);
		System.out.println("stp4:~~~~~~~~~~~``Factory.Domain.fetchInstance");
		Domain ceDomain = com.filenet.api.core.Factory.Domain.fetchInstance(ceConnection, CEConfiguration.CE_DOMAIN, null);
		System.out.println("stp5:~~~~~~~~~~~``Factory.ObjectStore.fetchInstance");
		ObjectStore ceObjectStore = com.filenet.api.core.Factory.ObjectStore.fetchInstance(ceDomain, CEConfiguration.CE_OBJECTSTORE, null);
		System.out.println("stp6:~~~~~~~~~~~``Factory.ClassDefinition.fetchInstance");
		ClassDefinition classDef = com.filenet.api.core.Factory.ClassDefinition.fetchInstance(ceObjectStore, "Document", null);
		PropertyDefinitionList properties = classDef.get_PropertyDefinitions();
		PropertyDefinition property;
		for (Iterator propertyIter = properties.iterator(); propertyIter.hasNext(); System.out.println((new StringBuilder("Property: ")).append(property.get_DisplayName()).toString()))
			property = (PropertyDefinition)propertyIter.next();

		UserContext.get().popSubject();
		VWSession peSession = new VWSession();
		peSession.setBootstrapCEURI(CEConfiguration.FILENET_URI);
		peSession.logon(CEConfiguration.FILENET_USERNAME, CEConfiguration.FILENET_PASSWORD, CEConfiguration.PE_CONNECTION_POINT);
		String queueNames[] = peSession.fetchQueueNames(1);
		String as[];
		int j = (as = queueNames).length;
		for (int i = 0; i < j; i++)
		{
			String queue = as[i];
			System.out.println((new StringBuilder("Queue: ")).append(queue).toString());
		}

	}

	public static void main(String args[])
	{
		try
		{
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~main init~~~~~~~~~~~~~~~~~~~~~~~~~``");
			new CEConectionIIOP();
			testIIOP();
		}
		catch (VWException e)
		{
			e.printStackTrace();
			System.out.println((new StringBuilder("~~~~~~~`")).append(e.getLocalizedMessage()).toString());
		}
	}
}
