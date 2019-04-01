// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CodeQueryImpl.java

package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.db.LNPCodeDB;
import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CodeQueryIntf

public class CodeQueryImpl
	implements CodeQueryIntf
{

	public CodeQueryImpl()
	{
	}

	public List getInfoByCodeType(String type)
	{
		LNPCodeDB reLNPCodeDB = new LNPCodeDB();
		if (type == null || type.length() == 0)
			return null;
		reLNPCodeDB.setCodeType(type);
		LNPCodeSet reLNPCodeSet = reLNPCodeDB.query();
		List list = new ArrayList();
		for (int i = 1; reLNPCodeSet != null && i <= reLNPCodeSet.size(); i++)
		{
			LNPCodeSchema tempLNPCodeSchema = reLNPCodeSet.get(i);
			list.add(tempLNPCodeSchema);
		}

		return list;
	}

	public List getInfoByConditions(LNPCodeSchema tempLNPCodeSchema)
	{
		LNPCodeDB reLNPCodeDB = new LNPCodeDB();
		reLNPCodeDB.setSchema(tempLNPCodeSchema);
		LNPCodeSet reLNPCodeSet = reLNPCodeDB.query();
		List list = new ArrayList();
		for (int i = 1; reLNPCodeSet != null && i <= reLNPCodeSet.size(); i++)
		{
			LNPCodeSchema quLNPCodeSchema = reLNPCodeSet.get(i);
			list.add(quLNPCodeSchema);
		}

		return list;
	}

	public List getInfoBySql(String sql)
		throws Exception
	{
		LNPCodeDB reLNPCodeDB = new LNPCodeDB();
		if (sql == null || sql.length() == 0)
			return null;
		LNPCodeSet reLNPCodeSet = null;
		try
		{
			reLNPCodeSet = reLNPCodeDB.executeQuery(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception((new StringBuilder("��ѯʧ��.SQLΪ��")).append(sql).toString());
		}
		List list = new ArrayList();
		for (int i = 1; reLNPCodeSet != null && i <= reLNPCodeSet.size(); i++)
		{
			LNPCodeSchema tempLNPCodeSchema = reLNPCodeSet.get(i);
			list.add(tempLNPCodeSchema);
		}

		return list;
	}

	public LNPCodeSchema getinfoById(String code, String type)
	{
		LNPCodeDB reLNPCodeDB = new LNPCodeDB();
		reLNPCodeDB.setCode(code);
		reLNPCodeDB.setCodeType(type);
		if (reLNPCodeDB.getInfo())
			return reLNPCodeDB;
		else
			return null;
	}

	public String getTextByCodeAndType(String type, String code)
	{
		LNPCodeDB reLNPCodeDB = new LNPCodeDB();
		reLNPCodeDB.setCode(code);
		reLNPCodeDB.setCodeType(type);
		if (reLNPCodeDB.getInfo())
			return reLNPCodeDB.getCodeName();
		else
			return null;
	}
}
