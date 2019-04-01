// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   NewPubSubmit.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Set;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			MMap, PubSubmit

public class NewPubSubmit
{

	private VData mInputData;
	public CErrors mErrors;
	private Connection conn;
	private final boolean commitFlag = true;

	public NewPubSubmit()
	{
		mErrors = new CErrors();
		conn = null;
	}

	public boolean submitData(VData cInputData, String cOperate)
	{
		mInputData = (VData)cInputData.clone();
		if (!saveData())
		{
			return false;
		} else
		{
			mInputData = null;
			return true;
		}
	}

	private boolean saveData()
	{
		if (conn == null)
			conn = DBConnPool.getConnection();
		if (conn == null)
		{
			CError.buildErr(this, "数据库连接失败");
			return false;
		}
		String action;
		Object o;
		Object DBObject;
		Method m;
		Class parameterC[];
		Object parameterO[];
		MMap map;
		conn.setAutoCommit(false);
		action = "";
		String className = "";
		o = null;
		DBObject = null;
		m = null;
		Constructor constructor = null;
		parameterC = new Class[1];
		parameterO = new Object[1];
		map = (MMap)mInputData.getObjectByObjectName("MMap", 0);
		if (map == null || map.keySet().size() == 0) goto _L2; else goto _L1
_L1:
		Set set;
		int j;
		set = map.keySet();
		j = 0;
		  goto _L3
_L6:
		o = map.getOrder().get(String.valueOf(j + 1));
		action = (String)map.get(o);
		if (action == null)
			continue; /* Loop/switch isn't completed */
		String className = o.getClass().getName();
		if (className.endsWith("String"))
		{
			if (action.equals("UPDATE"))
			{
				className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
				String tSQL = (String)o;
				ExeSQL tExeSQL = new ExeSQL(conn);
				tExeSQL.execUpdateSQL(tSQL);
				continue; /* Loop/switch isn't completed */
			}
			if (action.equals("DELETE"))
			{
				className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
				String tSQL = (String)o;
				ExeSQL tExeSQL = new ExeSQL(conn);
				tExeSQL.execUpdateSQL(tSQL);
				continue; /* Loop/switch isn't completed */
			}
			if (action.equals("INSERT"))
			{
				className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
				String tSQL = (String)o;
				ExeSQL tExeSQL = new ExeSQL(conn);
				if (!tExeSQL.execUpdateSQL(tSQL))
				{
					System.out.println((new StringBuilder("第")).append(j).append("行数据保存失败！").toString());
					CError.buildErr(this, (new StringBuilder("第")).append(j).append(1).append("行数据保存失败！").toString());
				}
				continue; /* Loop/switch isn't completed */
			}
			if (action.equals("SELECT"))
			{
				className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
				String tSQL = (String)o;
				ExeSQL tExeSQL = new ExeSQL(conn);
				SSRS tSSRS = new SSRS();
				System.out.println((new StringBuilder("执行SQL语句:")).append(tSQL).toString());
				tSSRS = tExeSQL.execSQL(tSQL);
				tSSRS.getMaxRow();
				continue; /* Loop/switch isn't completed */
			}
		} else
		if (className.endsWith("Schema"))
			className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		else
		if (className.endsWith("BLSet"))
			className = (new StringBuilder("com.sinosoft.map.lis.vdb.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("B"))).append("DBSet").toString();
		else
		if (className.endsWith("Set"))
			className = (new StringBuilder("com.sinosoft.map.lis.vdb.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DBSet").toString();
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
		if (!action.equals("INSERT")) goto _L5; else goto _L4
_L4:
		m = DBObject.getClass().getMethod("insert", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			continue; /* Loop/switch isn't completed */
		try
		{
			conn.rollback();
		}
		catch (Exception exception1) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
_L5:
		if (!action.equals("UPDATE"))
			break MISSING_BLOCK_LABEL_1070;
		m = DBObject.getClass().getMethod("update", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			continue; /* Loop/switch isn't completed */
		try
		{
			conn.rollback();
		}
		catch (Exception exception2) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
		if (!action.equals("DELETE"))
			break MISSING_BLOCK_LABEL_1182;
		m = DBObject.getClass().getMethod("delete", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			continue; /* Loop/switch isn't completed */
		try
		{
			conn.rollback();
		}
		catch (Exception exception3) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
		if (!action.equals("DELETE&INSERT"))
			break MISSING_BLOCK_LABEL_1397;
		m = DBObject.getClass().getMethod("delete", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			break MISSING_BLOCK_LABEL_1295;
		try
		{
			conn.rollback();
		}
		catch (Exception exception4) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
		Boolean b;
		String tSQL;
		String pWhereSQL;
		String pTabName;
		String pUpdateField;
		String parmStrArr[];
		String aClassName;
		Schema s;
		InputStream ins;
		try
		{
			m = DBObject.getClass().getMethod("insert", null);
			b = (Boolean)m.invoke(DBObject, null);
			if (b.booleanValue())
				continue; /* Loop/switch isn't completed */
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
			}
			catch (Exception exception) { }
			return false;
		}
		return false;
		if (action.equals("BLOBINSERT"))
		{
			tSQL = "";
			pWhereSQL = " and ";
			pTabName = "";
			pUpdateField = "";
			parmStrArr = getBlobInsertStr(o, tSQL, pWhereSQL, pTabName, pUpdateField);
			aClassName = o.getClass().getName();
			s = (Schema)o;
			m = o.getClass().getMethod((new StringBuilder("get")).append(parmStrArr[2]).toString(), null);
			ins = (InputStream)m.invoke(o, null);
			CBlob.BlobInsert(ins, parmStrArr, conn);
			ins.close();
		} else
		if (action.equals("BLOBUPDATE"))
		{
			tSQL = "";
			pWhereSQL = " and ";
			pTabName = "";
			pUpdateField = "";
			parmStrArr = getBlobInsertStr(o, tSQL, pWhereSQL, pTabName, pUpdateField);
			aClassName = o.getClass().getName();
			s = (Schema)o;
			m = o.getClass().getMethod((new StringBuilder("get")).append(parmStrArr[2]).toString(), null);
			ins = (InputStream)m.invoke(o, null);
			CBlob.BlobUpdate(ins, parmStrArr, conn);
			ins.close();
		} else
		if (action.equals("BLOBDELETE"))
		{
			m = DBObject.getClass().getMethod("delete", null);
			tSQL = (Boolean)m.invoke(DBObject, null);
			tSQL.booleanValue();
		}
		j++;
_L3:
		if (j < set.size()) goto _L6; else goto _L2
_L2:
		conn.commit();
		conn.close();
		return true;
	}

	private static String[] getBlobInsertStr(Object o, String tSQL, String pTabName, String pUpdateField, String pWhereSQL)
	{
		String aClassName = o.getClass().getName();
		if (aClassName.endsWith("Schema"))
		{
			Schema s = (Schema)o;
			String pk[] = s.getPK();
			pTabName = aClassName.substring(aClassName.lastIndexOf(".") + 1, aClassName.lastIndexOf("S"));
			String ValPart = "values(";
			String mark = "'";
			int nFieldCount = s.getFieldCount();
			int jj = 0;
			for (int i = 0; i < nFieldCount - 1; i++)
			{
				String strFieldName = s.getFieldName(i);
				String strFieldValue = s.getV(i);
				for (int ii = 0; ii < pk.length; ii++)
					if (strFieldName.equals(pk[ii]))
						pWhereSQL = (new StringBuilder(String.valueOf(pWhereSQL))).append(strFieldName).append(" = '").append(strFieldValue).append("' and ").toString();

				int nFieldType = s.getFieldType(i);
				boolean bFlag = false;
				switch (nFieldType)
				{
				case 0: // '\0'
				case 1: // '\001'
					if (!strFieldValue.equals("null"))
					{
						strFieldValue = (new StringBuilder(String.valueOf(mark))).append(strFieldValue).append(mark).toString();
						bFlag = true;
					}
					break;

				case 2: // '\002'
				case 3: // '\003'
				case 4: // '\004'
					bFlag = true;
					break;

				default:
					bFlag = false;
					break;
				}
				if (bFlag)
				{
					if (++jj != 1)
						ValPart = (new StringBuilder(String.valueOf(ValPart))).append(",").toString();
					ValPart = (new StringBuilder(String.valueOf(ValPart))).append(strFieldValue).toString();
				}
			}

			ValPart = (new StringBuilder(String.valueOf(ValPart))).append(",").toString();
			ValPart = (new StringBuilder(String.valueOf(ValPart))).append("empty_blob()").toString();
			ValPart = (new StringBuilder(String.valueOf(ValPart))).append(")").toString();
			tSQL = (new StringBuilder("insert into ")).append(pTabName).append(" ").append(ValPart).toString();
			if (jj == 0)
				tSQL = "";
			pUpdateField = s.getFieldName(nFieldCount - 1);
			if (pWhereSQL.lastIndexOf("and") != -1)
				pWhereSQL = (new StringBuilder("and ")).append(pWhereSQL.substring(0, pWhereSQL.lastIndexOf("and"))).toString();
		} else
		{
			return null;
		}
		String returnStr[] = new String[4];
		returnStr[0] = tSQL;
		returnStr[1] = pTabName;
		returnStr[2] = pUpdateField;
		returnStr[3] = pWhereSQL;
		return returnStr;
	}

	public static void main(String args[])
	{
		PubSubmit pubSubmit1 = new PubSubmit();
		VData mResult = new VData();
		MMap map = new MMap();
		map.put("select 1 from dual WHERE 1=1", "SELECT");
		mResult.addElement(map);
		pubSubmit1.submitData(mResult, "");
	}
}
