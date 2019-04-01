// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PubBLInterface.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.VData;

public interface PubBLInterface
{

	public abstract VData getResult();

	public abstract CErrors getErrors();

	public abstract boolean dealData();

	public abstract boolean checkData();

	public abstract boolean getInputData(VData vdata);

	public abstract boolean submitData(VData vdata, String s);
}
