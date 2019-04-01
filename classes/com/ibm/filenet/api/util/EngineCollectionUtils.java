// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EngineCollectionUtils.java

package com.ibm.filenet.api.util;

import com.filenet.api.collection.EngineCollection;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.collections.CollectionUtils;

public class EngineCollectionUtils
{

	public EngineCollectionUtils()
	{
	}

	public static Collection c(EngineCollection ec, Class cls)
	{
		java.util.Iterator it = ec.iterator();
		Collection c = new ArrayList();
		CollectionUtils.addAll(c, it);
		return c;
	}
}
