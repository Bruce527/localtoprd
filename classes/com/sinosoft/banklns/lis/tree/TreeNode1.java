// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TreeNode1.java

package com.sinosoft.banklns.lis.tree;

import java.util.ArrayList;

// Referenced classes of package com.sinosoft.banklns.lis.tree:
//			OccupBean

public class TreeNode1
{

	ArrayList childList;
	OccupBean occupBean;
	int level;
	TreeNode1 parentNode;

	public TreeNode1()
	{
		childList = new ArrayList();
	}

	public void addNode(TreeNode1 treeNode)
	{
		childList.add(treeNode);
	}

	public ArrayList getChildList()
	{
		return childList;
	}

	public void setBean(OccupBean occupBean)
	{
		this.occupBean = occupBean;
	}

	public OccupBean getBean()
	{
		return occupBean;
	}

	public boolean hasChildNode()
	{
		return childList.size() != 0;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getLevel()
	{
		return level;
	}

	public void setParentNode(TreeNode1 parentNode)
	{
		this.parentNode = parentNode;
	}

	public TreeNode1 getParentNode()
	{
		return parentNode;
	}
}
