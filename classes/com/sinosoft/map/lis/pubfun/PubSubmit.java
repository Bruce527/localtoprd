// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PubSubmit.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Set;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			MMap

public class PubSubmit
{

	private VData mInputData;
	public CErrors mErrors;
	private Connection conn;
	private final boolean commitFlag = true;
	private String checkType;

	public PubSubmit()
	{
		mErrors = new CErrors();
		conn = null;
		checkType = "";
	}

	public boolean submitData(VData cInputData, String cOperate)
	{
		mInputData = (VData)cInputData.clone();
		Exception ex;
		if (!saveData())
		{
			return false;
		} else
		{
			mInputData = null;
			return true;
		}
		ex;
		CError.buildErr(this, "业务数据保存失败！");
		return false;
	}

	private boolean saveData()
		throws Exception
	{
		if (conn == null || conn.isClosed())
			conn = DBConnPool.getConnection();
		if (conn == null)
		{
			CError.buildErr(this, "数据库连接失败");
			return false;
		}
		String action;
		String className;
		Object o;
		Object DBObject;
		Method m;
		Class parameterC[];
		Object parameterO[];
		MMap map;
		conn.setAutoCommit(false);
		action = "";
		className = "";
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
_L12:
		o = map.getOrder().get(String.valueOf(j + 1));
		action = (String)map.get(o);
		if (action == null)
			continue; /* Loop/switch isn't completed */
		className = o.getClass().getName();
		if (!className.endsWith("String")) goto _L5; else goto _L4
_L4:
		if (!action.equals("UPDATE")) goto _L7; else goto _L6
_L6:
		className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		String tSQL = (String)o;
		ExeSQL tExeSQL = new ExeSQL(conn);
		if (tExeSQL.execUpdateSQL(tSQL))
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, (new StringBuilder("执行更新语句失败原因:")).append(tExeSQL.mErrors.getError(0).errorMessage).toString());
		conn.rollback();
		conn.close();
		return false;
_L7:
		if (!action.equals("DELETE"))
			break MISSING_BLOCK_LABEL_432;
		className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		String tSQL = (String)o;
		ExeSQL tExeSQL = new ExeSQL(conn);
		if (tExeSQL.execUpdateSQL(tSQL))
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, (new StringBuilder("执行删除语句失败原因:")).append(tExeSQL.mErrors.getError(0).errorMessage).toString());
		conn.rollback();
		conn.close();
		return false;
		if (!action.equals("INSERT"))
			break MISSING_BLOCK_LABEL_560;
		className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		String tSQL = (String)o;
		ExeSQL tExeSQL = new ExeSQL(conn);
		if (tExeSQL.execUpdateSQL(tSQL))
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, (new StringBuilder("执行插入语句失败原因：")).append(tExeSQL.mErrors.getError(0).errorMessage).toString());
		conn.rollback();
		conn.close();
		return false;
		if (!action.equals("SELECT")) goto _L9; else goto _L8
_L8:
		className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		String tSQL = (String)o;
		ExeSQL tExeSQL = new ExeSQL(conn);
		SSRS tSSRS = new SSRS();
		System.out.println((new StringBuilder("执行SQL语句:")).append(tSQL).toString());
		tSSRS = tExeSQL.execSQL(tSQL);
		if (tSSRS.getMaxRow() <= 0)
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, "该操作已经执行，请检查数据！");
		conn.rollback();
		conn.close();
		return false;
_L5:
		if (className.endsWith("Schema"))
			className = (new StringBuilder("com.sinosoft.map.lis.db.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DB").toString();
		else
		if (className.endsWith("BLSet"))
			className = (new StringBuilder("com.sinosoft.map.lis.vdb.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("B"))).append("DBSet").toString();
		else
		if (className.endsWith("Set"))
			className = (new StringBuilder("com.sinosoft.map.lis.vdb.")).append(className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("S"))).append("DBSet").toString();
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
		CError.buildErr(this, (new StringBuilder("执行插入语句失败")).append(getDBErrorsMessage(DBObject)).toString());
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
			break MISSING_BLOCK_LABEL_1251;
		m = DBObject.getClass().getMethod("update", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, (new StringBuilder("执行更新语句失败")).append(getDBErrorsMessage(DBObject)).toString());
		try
		{
			conn.rollback();
		}
		catch (Exception exception2) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
		if (!action.equals("DELETE"))
			break MISSING_BLOCK_LABEL_1389;
		m = DBObject.getClass().getMethod("delete", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, (new StringBuilder("执行删除语句失败")).append(getDBErrorsMessage(DBObject)).toString());
		try
		{
			conn.rollback();
		}
		catch (Exception exception3) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
		if (!action.equals("DELETE&INSERT"))
			break MISSING_BLOCK_LABEL_1657;
		m = DBObject.getClass().getMethod("delete", null);
		Boolean b = (Boolean)m.invoke(DBObject, null);
		if (b.booleanValue())
			break MISSING_BLOCK_LABEL_1528;
		CError.buildErr(this, (new StringBuilder("执行删除，插入语句失败")).append(getDBErrorsMessage(DBObject)).toString());
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
		Exception exception6;
		String pTabName;
		String pUpdateField;
		String parmStrArr[];
		String aClassName;
		Schema s;
		InputStream ins;
		Exception exception7;
		try
		{
			m = DBObject.getClass().getMethod("insert", null);
			b = (Boolean)m.invoke(DBObject, null);
			if (b.booleanValue())
				continue; /* Loop/switch isn't completed */
			CError.buildErr(this, (new StringBuilder("执行插入语句失败")).append(getDBErrorsMessage(DBObject)).toString());
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
		if (!action.equals("BLOBINSERT"))
			break MISSING_BLOCK_LABEL_1843;
		tSQL = "";
		pWhereSQL = " and ";
		pTabName = "";
		pUpdateField = "";
		parmStrArr = getBlobInsertStr(o, tSQL, pWhereSQL, pTabName, pUpdateField);
		aClassName = o.getClass().getName();
		s = (Schema)o;
		m = o.getClass().getMethod((new StringBuilder("get")).append(parmStrArr[2]).toString(), null);
		ins = (InputStream)m.invoke(o, null);
		if (CBlob.BlobInsert(ins, parmStrArr, conn))
			break MISSING_BLOCK_LABEL_1835;
		CError.buildErr(this, "执行更新blob语句失败");
		try
		{
			conn.rollback();
		}
		// Misplaced declaration of an exception variable
		catch (Exception exception7) { }
		conn.close();
		ins.close();
		System.out.println((new StringBuilder("tCBlob.BlobInsert ")).append(action).append(" Failed").toString());
		return false;
		ins.close();
		continue; /* Loop/switch isn't completed */
		if (!action.equals("BLOBUPDATE"))
			break MISSING_BLOCK_LABEL_2029;
		tSQL = "";
		pWhereSQL = " and ";
		pTabName = "";
		pUpdateField = "";
		parmStrArr = getBlobInsertStr(o, tSQL, pWhereSQL, pTabName, pUpdateField);
		aClassName = o.getClass().getName();
		s = (Schema)o;
		m = o.getClass().getMethod((new StringBuilder("get")).append(parmStrArr[2]).toString(), null);
		ins = (InputStream)m.invoke(o, null);
		if (CBlob.BlobUpdate(ins, parmStrArr, conn))
			break MISSING_BLOCK_LABEL_2021;
		CError.buildErr(this, "执行更新blob语句失败");
		try
		{
			conn.rollback();
		}
		// Misplaced declaration of an exception variable
		catch (Exception exception7) { }
		conn.close();
		ins.close();
		System.out.println((new StringBuilder("tCBlob.BlobUpdate ")).append(action).append(" Failed").toString());
		return false;
		ins.close();
		continue; /* Loop/switch isn't completed */
		if (!action.equals("BLOBDELETE"))
			continue; /* Loop/switch isn't completed */
		m = DBObject.getClass().getMethod("delete", null);
		tSQL = (Boolean)m.invoke(DBObject, null);
		if (tSQL.booleanValue())
			continue; /* Loop/switch isn't completed */
		CError.buildErr(this, "执行删除语句失败");
		try
		{
			conn.rollback();
		}
		// Misplaced declaration of an exception variable
		catch (Exception exception6) { }
		conn.close();
		System.out.println((new StringBuilder(String.valueOf(DBObject.getClass().getName()))).append(" ").append(action).append(" Failed").toString());
		return false;
		j++;
_L3:
		if (j < set.size()) goto _L12; else goto _L2
_L2:
		conn.commit();
		conn.close();
		conn = null;
		return true;
	}

	public void setCheckType(String checkType)
	{
		this.checkType = checkType;
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

	public String getDBErrorsMessage(Object obj)
	{
		CErrors tCErrors;
		Field f = obj.getClass().getField("mErrors");
		tCErrors = (CErrors)f.get(obj);
		if (tCErrors != null)
			return tCErrors.getError(0).errorMessage;
		break MISSING_BLOCK_LABEL_43;
		Exception ex;
		ex;
		System.out.println("DB类没有产生错误信息!");
		return "";
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
