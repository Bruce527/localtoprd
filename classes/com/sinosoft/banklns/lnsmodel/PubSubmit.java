// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PubSubmit.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.pubfun.MMap;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Set;

public class PubSubmit
{

	private VData mInputData;
	public CErrors mErrors;
	public Connection conn;
	private boolean commitFlag;

	public PubSubmit()
	{
		mErrors = new CErrors();
		conn = null;
		commitFlag = true;
	}

	public static void main(String args[])
	{
		PubSubmit pubSubmit1 = new PubSubmit();
	}

	public boolean submitData(VData cInputData, String cOperate)
	{
		mInputData = (VData)cInputData.clone();
		System.out.println("Start PubSubmit Submit...");
		if (!saveData())
		{
			return false;
		} else
		{
			System.out.println("End PubSubmit Submit...");
			mInputData = null;
			return true;
		}
	}

	private boolean saveData()
	{
		System.out.println("---Start Save---");
		String action;
		String className;
		Object o;
		Object DBObject;
		Method m;
		Class parameterC[];
		Object parameterO[];
		MMap map;
		action = "";
		className = "";
		o = null;
		DBObject = null;
		m = null;
		Constructor constructor = null;
		parameterC = new Class[1];
		parameterO = new Object[1];
		System.out.println((new StringBuilder("mInputData.size():")).append(mInputData.size()).toString());
		System.out.println((new StringBuilder("mInputData :")).append(mInputData).toString());
		map = (MMap)mInputData.getObjectByObjectName("MMap", 0);
		if (map == null || map.keySet().size() == 0) goto _L2; else goto _L1
_L1:
		Set set;
		int j;
		set = map.keySet();
		j = 0;
		  goto _L3
_L12:
		o = map.getOrder().get(String.valueOf(j + 1));
		action = (String)map.get(o);
		if (action == null)
			continue; /* Loop/switch isn't completed */
		System.out.println((new StringBuilder("\n")).append(o.getClass().getName()).append(" Operate DB: ").append(action).toString());
		className = o.getClass().getName();
		System.out.println((new StringBuilder("className :")).append(className).toString());
		System.out.println((new StringBuilder("action :")).append(action).toString());
		if (!className.endsWith("String")) goto _L5; else goto _L4
_L4:
		if (!action.equals("UPDATE")) goto _L7; else goto _L6
_L6:
		className = (new StringBuilder("com.sinosoft.banklns.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		String tSQL = (String)o;
		ExeSQL tExeSQL = new ExeSQL(conn);
		System.out.println((new StringBuilder("执行SQL语句:")).append(tSQL).toString());
		if (tExeSQL.execUpdateSQL(tSQL))
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, "执行更新语句失败");
		conn.rollback();
		conn.close();
		return false;
_L7:
		if (!action.equals("DELETE"))
			break MISSING_BLOCK_LABEL_519;
		className = (new StringBuilder("com.sinosoft.banklns.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		String tSQL = (String)o;
		ExeSQL tExeSQL = new ExeSQL(conn);
		System.out.println((new StringBuilder("执行SQL语句:")).append(tSQL).toString());
		if (tExeSQL.execUpdateSQL(tSQL))
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, "执行删除语句失败");
		conn.rollback();
		conn.close();
		return false;
		if (!action.equals("INSERT")) goto _L9; else goto _L8
_L8:
		className = (new StringBuilder("com.sinosoft.banklns.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		String tSQL = (String)o;
		ExeSQL tExeSQL = new ExeSQL(conn);
		System.out.println((new StringBuilder("执行SQL语句:")).append(tSQL).toString());
		if (tExeSQL.execUpdateSQL(tSQL))
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, (new StringBuilder("执行插入语句失败原因�?")).append(tExeSQL.mErrors.getError(0).errorMessage).toString());
		conn.rollback();
		conn.close();
		return false;
_L5:
		if (className.endsWith("Schema"))
			className = (new StringBuilder("com.sinosoft.banklns.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		else
		if (className.endsWith("BLSet"))
			className = (new StringBuilder("com.sinosoft.banklns.lis.vdb.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("B"))).append("DBSet").toString();
		else
		if (className.endsWith("Set"))
			className = (new StringBuilder("com.sinosoft.banklns.lis.vdb.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DBSet").toString();
_L9:
		Class DBClass = Class.forName(className);
		parameterC[0] = java/sql/Connection;
		Constructor constructor = DBClass.getConstructor(parameterC);
		parameterO[0] = conn;
		DBObject = constructor.newInstance(parameterO);
		parameterC[0] = o.getClass();
		if (o.getClass().getName().endsWith("Schema"))
			m = DBObject.getClass().getMethod("setSchema", parameterC);
		else
		if (o.getClass().getName().endsWith("Set"))
			m = DBObject.getClass().getMethod("set", parameterC);
		parameterO[0] = o;
		m.invoke(DBObject, parameterO);
		if (!action.equals("INSERT")) goto _L11; else goto _L10
_L10:
		m = DBObject.getClass().getMethod("insert", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, "执行插入语句失败");
		try
		{
			conn.rollback();
		}
		catch (Exception exception1) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
_L11:
		if (!action.equals("UPDATE"))
			break MISSING_BLOCK_LABEL_1179;
		m = DBObject.getClass().getMethod("update", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, "执行更新语句失败");
		try
		{
			conn.rollback();
		}
		catch (Exception exception2) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
		if (!action.equals("DELETE"))
			break MISSING_BLOCK_LABEL_1297;
		m = DBObject.getClass().getMethod("delete", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, "执行删除语句失败");
		try
		{
			conn.rollback();
		}
		catch (Exception exception3) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
		if (!action.equals("DELETE&INSERT"))
			continue; /* Loop/switch isn't completed */
		m = DBObject.getClass().getMethod("delete", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			break MISSING_BLOCK_LABEL_1417;
		CError.buildErr(this, "执行删除，插入语句失�?");
		try
		{
			conn.rollback();
		}
		catch (Exception exception4) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
		try
		{
			m = DBObject.getClass().getMethod("insert", null);
			Boolean b = (Boolean)m.invoke(DBObject, null);
			if (b.booleanValue())
				continue; /* Loop/switch isn't completed */
			CError.buildErr(this, "执行插入语句失败");
			try
			{
				conn.rollback();
			}
			catch (Exception exception5) { }
			conn.close();
			System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		}
		catch (Exception e)
		{
			CError.buildErr(this, e.toString());
			try
			{
				conn.rollback();
				conn.close();
			}
			catch (Exception exception) { }
			return false;
		}
		return false;
		j++;
_L3:
		if (j < set.size()) goto _L12; else goto _L2
_L2:
		if (commitFlag)
		{
			conn.rollback();
			conn.close();
			System.out.println("---End Committed---");
		} else
		{
			System.out.println("---End Datebase Operation, but not Commit in AutoBLS---");
		}
		return true;
	}
}
