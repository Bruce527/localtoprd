// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OccupTreeBean.java

package com.sinosoft.banklns.lis.tree;

import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.io.IOException;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

// Referenced classes of package com.sinosoft.banklns.lis.tree:
//			TreeNode1, OccupBean

public class OccupTreeBean
{

	TreeNode1 root;
	String sql;
	String eSql;
	String tempOrderSql;
	int level;
	ArrayList currentList;
	ArrayList resultList;
	private TreeNode rootNode;
	private List selectedNodeChildren;
	private int index;
	private OccupBean OccupBean;
	private String occName;
	private boolean checkBox;
	private String message;
	private boolean flag;
	private boolean searchFlag;
	private String str;

	public OccupTreeBean()
	{
		sql = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation";
		eSql = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation";
		tempOrderSql = " order by OCCUPATIONCODE asc";
		level = 1;
		rootNode = null;
		selectedNodeChildren = new ArrayList();
		index = 0;
		flag = false;
		searchFlag = false;
	}

	public TreeNode1 getTreeData()
	{
		ExeSQL exeSql;
		root = new TreeNode1();
		currentList = new ArrayList();
		TreeNode1 currentParent = new TreeNode1();
		currentParent = root;
		exeSql = new ExeSQL();
		this;
		eSql;
		JVM INSTR new #78  <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" where RELACODE is null or RELACODE = ''";
		append();
		toString();
		eSql;
		SSRS ssrs = exeSql.execSQL((new StringBuilder(String.valueOf(eSql))).append(tempOrderSql).toString());
		if (ssrs == null || ssrs.getMaxRow() == 0)
			return null;
		for (int i = 1; i <= ssrs.getMaxRow(); i++)
		{
			OccupBean occupBean = new OccupBean();
			TreeNode1 tempNode = new TreeNode1();
			occupBean.setCode(ssrs.GetText(i, 1));
			occupBean.setName(ssrs.GetText(i, 2));
			occupBean.setType(ssrs.GetText(i, 3));
			tempNode.setBean(occupBean);
			root.addNode(tempNode);
		}

		tempOrderSql = " order by OCCUPATIONCODE,RELACODE asc";
		currentList.add(root);
		level++;
		eSql = (new StringBuilder(String.valueOf(sql))).append(" where RELACODE in (").append(eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "")).append(")").toString();
		for (ssrs = exeSql.execSQL((new StringBuilder(String.valueOf(eSql))).append(tempOrderSql).toString()); ssrs != null && ssrs.getMaxRow() != 0;)
		{
			HashMap hm = getNodeList();
			for (int i = 1; i <= ssrs.getMaxRow(); i++)
			{
				OccupBean occupBean = new OccupBean();
				TreeNode1 tempNode = new TreeNode1();
				occupBean.setCode(ssrs.GetText(i, 1));
				occupBean.setName(ssrs.GetText(i, 2));
				occupBean.setType(ssrs.GetText(i, 3));
				occupBean.setHiRate(ssrs.GetText(i, 4));
				occupBean.setPaRate(ssrs.GetText(i, 5));
				occupBean.setWpRate(ssrs.GetText(i, 6));
				tempNode.setBean(occupBean);
				((TreeNode1)hm.get(ssrs.GetText(i, 7))).addNode(tempNode);
			}

			eSql = (new StringBuilder(String.valueOf(sql))).append(" where RELACODE in (").append(eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "")).append(")").toString();
			ssrs = exeSql.execSQL((new StringBuilder(String.valueOf(eSql))).append(tempOrderSql).toString());
			level++;
		}

		return root;
	}

	public TreeNode1 getTreeData2(String str)
	{
		ExeSQL exeSql;
		String sql22;
		root = new TreeNode1();
		currentList = new ArrayList();
		TreeNode1 currentParent = new TreeNode1();
		currentParent = root;
		exeSql = new ExeSQL();
		sql22 = (new StringBuilder("select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation where OCCUPATIONCODE in(select distinct relacode from lnpoccupation where OCCUPATIONNAME like '%")).append(str).append("%') and").append(" RELACODE is null or RELACODE = ''").toString();
		if (checkBox)
			sql22 = (new StringBuilder("select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation where OCCUPATIONCODE in(select distinct relacode from lnpoccupation where OCCUPATIONNAME = '")).append(str).append("') and").append(" RELACODE is null or RELACODE = ''").toString();
		this;
		eSql;
		JVM INSTR new #78  <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		" where RELACODE is null or RELACODE = ''";
		append();
		toString();
		eSql;
		SSRS ssrs = exeSql.execSQL(sql22);
		if (ssrs == null || ssrs.getMaxRow() == 0)
			return null;
		for (int i = 1; i <= ssrs.getMaxRow(); i++)
		{
			OccupBean occupBean = new OccupBean();
			TreeNode1 tempNode = new TreeNode1();
			occupBean.setCode(ssrs.GetText(i, 1));
			occupBean.setName(ssrs.GetText(i, 2));
			occupBean.setType(ssrs.GetText(i, 3));
			tempNode.setBean(occupBean);
			root.addNode(tempNode);
		}

		tempOrderSql = " order by OCCUPATIONCODE,RELACODE asc";
		currentList.add(root);
		level++;
		if (checkBox)
			eSql = (new StringBuilder(String.valueOf(sql))).append(" where RELACODE in (").append(eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "")).append(") and OCCUPATIONNAME = '").append(str).append("'").toString();
		else
			eSql = (new StringBuilder(String.valueOf(sql))).append(" where RELACODE in (").append(eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "")).append(") and OCCUPATIONNAME like '%").append(str).append("%'").toString();
		for (ssrs = exeSql.execSQL((new StringBuilder(String.valueOf(eSql))).append(tempOrderSql).toString()); ssrs != null && ssrs.getMaxRow() != 0;)
		{
			HashMap hm = getNodeList();
			for (int i = 1; i <= ssrs.getMaxRow(); i++)
			{
				OccupBean occupBean = new OccupBean();
				TreeNode1 tempNode = new TreeNode1();
				occupBean.setCode(ssrs.GetText(i, 1));
				occupBean.setName(ssrs.GetText(i, 2));
				occupBean.setType(ssrs.GetText(i, 3));
				occupBean.setHiRate(ssrs.GetText(i, 4));
				occupBean.setPaRate(ssrs.GetText(i, 5));
				occupBean.setWpRate(ssrs.GetText(i, 6));
				tempNode.setBean(occupBean);
				((TreeNode1)hm.get(ssrs.GetText(i, 7))).addNode(tempNode);
			}

			eSql = (new StringBuilder(String.valueOf(sql))).append(" where RELACODE in (").append(eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "")).append(")").toString();
			ssrs = exeSql.execSQL((new StringBuilder(String.valueOf(eSql))).append(tempOrderSql).toString());
			level++;
		}

		return root;
	}

	public TreeNode1 getTreeData3(String str)
	{
		root = new TreeNode1();
		currentList = new ArrayList();
		TreeNode1 currentParent = new TreeNode1();
		currentParent = root;
		ExeSQL exeSql = new ExeSQL();
		String sql22 = (new StringBuilder("select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation where OCCUPATIONCODE in(select distinct occupationcode from lnpoccupation where OCCUPATIONNAME like '%")).append(str).append("%' ").append("and RELACODE is null or RELACODE = '')").toString();
		if (checkBox)
			sql22 = (new StringBuilder("select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation where OCCUPATIONCODE in(select distinct occupationcode from lnpoccupation where OCCUPATIONNAME = '")).append(str).append("' ").append("and RELACODE is null or RELACODE = '')").toString();
		SSRS ssrs = exeSql.execSQL(sql22);
		if (ssrs == null || ssrs.getMaxRow() == 0)
			return null;
		for (int i = 1; i <= ssrs.getMaxRow(); i++)
		{
			OccupBean occupBean = new OccupBean();
			TreeNode1 tempNode = new TreeNode1();
			occupBean.setCode(ssrs.GetText(i, 1));
			occupBean.setName(ssrs.GetText(i, 2));
			occupBean.setType(ssrs.GetText(i, 3));
			tempNode.setBean(occupBean);
			root.addNode(tempNode);
		}

		tempOrderSql = " order by OCCUPATIONCODE,RELACODE asc";
		currentList.add(root);
		level++;
		if (checkBox)
			eSql = (new StringBuilder(String.valueOf(sql))).append(" where RELACODE in (").append(eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "")).append(" ").append("where OCCUPATIONNAME = '").append(str).append("' and (RELACODE is null or RELACODE = '') )").toString();
		else
			eSql = (new StringBuilder(String.valueOf(sql))).append(" where RELACODE in (").append(eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "")).append(" ").append("where OCCUPATIONNAME like '%").append(str).append("%' and (RELACODE is null or RELACODE = '') )").toString();
		for (ssrs = exeSql.execSQL((new StringBuilder(String.valueOf(eSql))).append(tempOrderSql).toString()); ssrs != null && ssrs.getMaxRow() != 0;)
		{
			HashMap hm = getNodeList();
			for (int i = 1; i <= ssrs.getMaxRow(); i++)
			{
				OccupBean occupBean = new OccupBean();
				TreeNode1 tempNode = new TreeNode1();
				occupBean.setCode(ssrs.GetText(i, 1));
				occupBean.setName(ssrs.GetText(i, 2));
				occupBean.setType(ssrs.GetText(i, 3));
				occupBean.setHiRate(ssrs.GetText(i, 4));
				occupBean.setPaRate(ssrs.GetText(i, 5));
				occupBean.setWpRate(ssrs.GetText(i, 6));
				tempNode.setBean(occupBean);
				((TreeNode1)hm.get(ssrs.GetText(i, 7))).addNode(tempNode);
			}

			eSql = (new StringBuilder(String.valueOf(sql))).append(" where RELACODE in (").append(eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "")).append(")").toString();
			ssrs = exeSql.execSQL((new StringBuilder(String.valueOf(eSql))).append(tempOrderSql).toString());
			level++;
		}

		return root;
	}

	public HashMap getNodeList()
	{
		HashMap hm = new HashMap();
		ArrayList al = new ArrayList();
		for (int i = 0; i < currentList.size(); i++)
		{
			ArrayList temp = ((TreeNode1)currentList.get(i)).getChildList();
			for (int j = 0; j < temp.size(); j++)
				al.add(temp.get(j));

		}

		currentList = al;
		for (int i = 0; i < al.size(); i++)
			hm.put(((TreeNode1)al.get(i)).getBean().getCode(), al.get(i));

		return hm;
	}

	public void addNodes(TreeNode1 treeNode, TreeNode nodeImpl)
	{
		ArrayList list = treeNode.getChildList();
		for (int i = 0; i < list.size(); i++)
		{
			TreeNodeImpl treeNodeImpl = new TreeNodeImpl();
			TreeNode1 node1 = (TreeNode1)list.get(i);
			treeNodeImpl.setData(node1.getBean());
			nodeImpl.addChild(node1.getBean().getCode(), treeNodeImpl);
			addNodes(node1, ((TreeNode) (treeNodeImpl)));
		}

	}

	private void loadTree()
	{
		rootNode = new TreeNodeImpl();
		if (searchFlag)
			getTreeData3(str);
		else
			getTreeData();
		addNodes(root, rootNode);
	}

	public void processSelection(NodeSelectedEvent event)
	{
		HtmlTree tree = (HtmlTree)event.getComponent();
		OccupBean ob = (OccupBean)tree.getRowData();
		if (!ob.code.equals("") && !ob.name.equals("") && !ob.paRate.equals(""))
			OccupBean = ob;
		selectedNodeChildren.clear();
		TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
		if (currentNode.isLeaf())
			selectedNodeChildren.add((OccupBean)currentNode.getData());
		else
			try
			{
				if (tree.isExpanded())
					tree.queueCollapseAll();
				else
					tree.queueExpandAll();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		tree.clearTreeNodeState();
	}

	public String search()
	{
		searchFlag = true;
		str = occName;
		occName = "";
		rootNode = null;
		eSql = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation";
		getTreeNode();
		return "";
	}

	public ArrayList asList()
	{
		if (root == null)
		{
			getTreeData();
			OccupBean ob = new OccupBean();
			ob.setCode("-1");
			root.setBean(ob);
			resultList = new ArrayList();
			recursive(root, -1, null);
		} else
		{
			resultList = new ArrayList();
			recursive(root, -1, null);
		}
		return resultList;
	}

	public void recursive(TreeNode1 tn, int level, TreeNode1 parentNode)
	{
		level++;
		tn.setLevel(level);
		if (tn.hasChildNode())
		{
			if (!tn.equals(root))
			{
				tn.setParentNode(parentNode);
				resultList.add(tn);
			}
			ArrayList temp = tn.getChildList();
			for (int i = 0; i < temp.size(); i++)
				recursive((TreeNode1)temp.get(i), level, tn);

		} else
		{
			tn.setParentNode(parentNode);
			resultList.add(tn);
		}
	}

	public TreeNode getTreeNode()
	{
		if (rootNode == null)
			loadTree();
		return rootNode;
	}

	public void saveOccup()
	{
		String name = OccupBean.name;
		String code = OccupBean.code;
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("occupationName", name);
		session.setAttribute("occupationCode", code);
	}

	public void changeFlag()
	{
		flag = false;
	}

	public String getOccName()
	{
		return occName;
	}

	public void setOccName(String occName)
	{
		this.occName = occName;
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public void setOccupBean(OccupBean occBean)
	{
		OccupBean = occBean;
	}

	public OccupBean getOccupBean()
	{
		return OccupBean;
	}

	public boolean getCheckBox()
	{
		return checkBox;
	}

	public void setCheckBox(boolean checkbox)
	{
		checkBox = checkbox;
	}

	public void setMessage(String msg)
	{
		message = msg;
	}

	public String getMessage()
	{
		return message;
	}

	public void setFlag(boolean boo)
	{
		flag = boo;
	}

	public boolean getFlag()
	{
		return flag;
	}

	public boolean isSearchFlag()
	{
		return searchFlag;
	}

	public void setSearchFlag(boolean searchFlag)
	{
		this.searchFlag = searchFlag;
	}
}
