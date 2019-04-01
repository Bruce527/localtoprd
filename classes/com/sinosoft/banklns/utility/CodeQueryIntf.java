// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CodeQueryIntf.java

package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
import java.util.List;

public interface CodeQueryIntf
{

	public abstract List getInfoByCodeType(String s);

	public abstract LNPCodeSchema getinfoById(String s, String s1);

	public abstract List getInfoByConditions(LNPCodeSchema lnpcodeschema);

	public abstract List getInfoBySql(String s)
		throws Exception;

	public abstract String getTextByCodeAndType(String s, String s1);
}
