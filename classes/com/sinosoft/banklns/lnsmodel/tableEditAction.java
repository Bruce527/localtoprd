// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   tableEditAction.java

package com.sinosoft.banklns.lnsmodel;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			EntImport

public class tableEditAction
{

	private List ents;

	public tableEditAction()
	{
		ents = new ArrayList();
		EntImport ent = new EntImport();
		ent.setDouble1("double12321312");
		ent.setLong1("long12321312");
		ents.add(ent);
		ent = new EntImport();
		ent.setDouble1("double22321312");
		ent.setLong1("long22321312");
		ents.add(ent);
	}

	public void addOne()
	{
		System.out.println("add-----");
		EntImport ent = new EntImport();
		ent.setDouble1("double12321312");
		ent.setLong1("long12321312");
		ents.add(ent);
	}

	public void addSave()
	{
		System.out.println((new StringBuilder("save-----")).append(ents.size()).toString());
		ents.clear();
	}

	public List getEnts()
	{
		return ents;
	}

	public void setEnts(List ents)
	{
		this.ents = ents;
	}
}
