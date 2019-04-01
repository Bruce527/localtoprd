// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   dealXML.java

package com.sinosoft.banklns.utility;

import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

// Referenced classes of package com.sinosoft.banklns.utility:
//			ExeSQL, StrTool, SSRS

public class dealXML
{

	private String mData[][];
	private String mTable;
	private int flag;

	public dealXML()
	{
		mData = null;
		mTable = null;
		flag = 0;
	}

	public boolean parseXML(InputStream aIS, Connection conn)
	{
		int count;
		List list_row;
		count = 0;
		SAXBuilder builder = new SAXBuilder();
		Document read_doc = builder.build(aIS);
		Element stu = read_doc.getRootElement();
		mTable = stu.getAttributeValue("name");
		list_row = stu.getChildren("row");
		if (!delData(conn, mTable))
			return false;
		int i = 0;
		  goto _L1
_L5:
		Element e = (Element)list_row.get(i);
		List list_col = e.getChildren("col");
		for (int j = 0; j < list_col.size(); j++)
		{
			if (i == 0 && j == 0 && list_row.size() <= 1000)
				mData = new String[list_row.size()][list_col.size()];
			else
			if (j == 0 && list_row.size() > 1000)
				if (count % 1000 == 0 && j == 0 && list_row.size() - count <= 1000)
					mData = new String[list_row.size() - count][list_col.size()];
				else
				if (count % 1000 == 0 && j == 0 && list_row.size() - count > 1000)
					mData = new String[1000][list_col.size()];
			Element f = (Element)list_col.get(j);
			String value = f.getText();
			if (i < 1000)
				mData[i][j] = value;
			else
				mData[i % 1000][j] = value;
		}

		if (++count != list_row.size()) goto _L3; else goto _L2
_L2:
		if (count <= 1000)
		{
			if (!insertData(conn, list_row.size(), mData))
				return false;
			continue; /* Loop/switch isn't completed */
		}
		if (count > 1000 && !insertData(conn, count % 1000, mData))
			return false;
		continue; /* Loop/switch isn't completed */
_L3:
		if (count % 1000 == 0 && !insertData(conn, 1000, mData))
			return false;
		i++;
_L1:
		if (i < list_row.size()) goto _L5; else goto _L4
_L4:
		break MISSING_BLOCK_LABEL_455;
		Exception ex;
		ex;
		ex.printStackTrace();
		return false;
		return true;
	}

	private boolean delData(Connection con, String tablename)
	{
		String sql = (new StringBuilder("delete from ")).append(mTable).toString();
		if (con == null)
			return false;
		ExeSQL tExeSQL = new ExeSQL(con);
		Exception e;
		return tExeSQL.execUpdateSQL(StrTool.GBKToUnicode(sql));
		e;
		System.out.println(e);
		return false;
	}

	private boolean insertData(Connection con, int count, String data[][])
	{
		String tSQL[];
		ExeSQL tExeSQL;
		String tInsSQL = null;
		tSQL = new String[count];
		tExeSQL = new ExeSQL(con);
		for (int i = 0; i < data.length; i++)
		{
			tInsSQL = (new StringBuilder("insert into ")).append(mTable).append(" values(").toString();
			for (int j = 0; j < data[i].length; j++)
			{
				String tValue = data[i][j];
				tValue = StrTool.replace(tValue, "&amp;", "&");
				tValue = StrTool.replace(tValue, "&lt;", "<");
				tValue = StrTool.replace(tValue, "&gt;", ">");
				tValue = StrTool.replace(tValue, "&quot;", "\"");
				tValue = StrTool.replace(tValue, "\\", "\\\\");
				tValue = StrTool.replace(tValue, "'", "\\'");
				tValue = StrTool.replace(tValue, "\"", "\\\"");
				if (j == 0)
					tInsSQL = (new StringBuilder(String.valueOf(tInsSQL))).append("'").append(tValue).append("'").toString();
				else
					tInsSQL = (new StringBuilder(String.valueOf(tInsSQL))).append(",'").append(tValue).append("'").toString();
			}

			tSQL[i] = (new StringBuilder(String.valueOf(tInsSQL))).append(")").toString();
		}

		int a = 0;
		  goto _L1
_L3:
		if (!tExeSQL.execUpdateSQL(StrTool.GBKToUnicode(tSQL[a])))
			return false;
		a++;
_L1:
		if (a < tSQL.length) goto _L3; else goto _L2
_L2:
		break MISSING_BLOCK_LABEL_310;
		Exception e;
		e;
		e.printStackTrace();
		return false;
		return true;
	}

	public static void main(String args[])
	{
		dealXML dealXML1 = new dealXML();
	}

	public void setFlag(int i)
	{
		flag = i;
	}

	public int getFlag()
	{
		return flag;
	}

	public boolean createTable(InputStream aIS, Connection conn)
	{
		try
		{
			String sql = "";
			ExeSQL tExeSQL = new ExeSQL(conn);
			SAXBuilder builder = new SAXBuilder();
			Document read_doc = builder.build(aIS);
			Element stu = read_doc.getRootElement();
			mTable = stu.getAttributeValue("name");
			List list_row = stu.getChildren("row");
			int count = list_row.size();
			for (int i = 0; i < list_row.size(); i++)
			{
				Element e = (Element)list_row.get(i);
				List list_col = e.getChildren("col");
				for (int j = 0; j < list_col.size(); j++)
				{
					if (i == 0 && j == 0)
						mData = new String[list_row.size()][list_col.size()];
					Element f = (Element)list_col.get(j);
					String tValue = f.getText();
					if (tValue.length() > 0)
					{
						tValue = StrTool.replace(tValue, "&amp;", "&");
						tValue = StrTool.replace(tValue, "&lt;", "<");
						tValue = StrTool.replace(tValue, "&gt;", ">");
						tValue = StrTool.replace(tValue, "&quot;", "\"");
						tValue = StrTool.replace(tValue, "\\", "\\\\");
						tValue = StrTool.replace(tValue, "'", "\\'");
						tValue = StrTool.replace(tValue, "\"", "\\\"");
					}
					mData[i][j] = tValue;
				}

				sql = (new StringBuilder("select * from information_schema.tables where table_name='")).append(mData[i][0]).append("'").toString();
				SSRS rs = tExeSQL.execSQL(sql);
				if (rs.getMaxRow() > 0)
					tExeSQL.execUpdateSQL((new StringBuilder("drop table ")).append(mData[i][0]).toString());
				tExeSQL.execUpdateSQL(mData[i][1]);
			}

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		return true;
	}
}
