// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SinosoftLifecycleFactoryImpl.java

package com.sinosoft.map.common.config;

import org.apache.myfaces.lifecycle.LifecycleFactoryImpl;

// Referenced classes of package com.sinosoft.map.common.config:
//			SinosoftLifecycleImpl

public class SinosoftLifecycleFactoryImpl extends LifecycleFactoryImpl
{

	public static final String CUSTOM_LIFECYCLE = "SinosoftLifecycleFactoryImpl";

	public SinosoftLifecycleFactoryImpl()
	{
		addLifecycle("SinosoftLifecycleFactoryImpl", new SinosoftLifecycleImpl());
	}
}
