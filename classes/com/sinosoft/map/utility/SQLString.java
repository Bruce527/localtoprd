// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SQLString.java

package com.sinosoft.map.utility;

import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.utility:
//			Schema

public class SQLString
{

	private String TableName;
	private StringBuffer WherePart;
	private StringBuffer PKWherePart;
	private StringBuffer UpdPart;
	private StringBuffer InsPart;
	private StringBuffer mSql;
	private static final String mark = "'";

	public SQLString(String t)
	{
		WherePart = new StringBuffer(256);
		PKWherePart = new StringBuffer(256);
		UpdPart = new StringBuffer(256);
		InsPart = new StringBuffer(256);
		mSql = new StringBuffer(256);
		TableName = t;
	}

	public void setSQL(int flag, Schema s)
	{
		switch (flag)
		{
		default:
			break;

		case 1: // '\001'
			setInsPart(s);
			if (InsPart.equals(""))
			{
				mSql.setLength(0);
			} else
			{
				mSql.append("insert into ");
				mSql.append(TableName);
				mSql.append(" ");
				mSql.append(InsPart);
			}
			break;

		case 2: // '\002'
			setUpdPart(s);
			setPKWherePart(s);
			if (UpdPart.equals(""))
			{
				mSql.setLength(0);
			} else
			{
				mSql.append("update ");
				mSql.append(TableName);
				mSql.append(" ");
				mSql.append(UpdPart);
				mSql.append(" ");
				mSql.append(PKWherePart);
			}
			break;

		case 3: // '\003'
			setWherePart(s);
			mSql.append("delete from ");
			mSql.append(TableName);
			mSql.append(" ");
			mSql.append(WherePart);
			break;

		case 4: // '\004'
			setPKWherePart(s);
			mSql.append("delete from ");
			mSql.append(TableName);
			mSql.append(" ");
			mSql.append(PKWherePart);
			break;

		case 5: // '\005'
			setWherePart(s);
			mSql.append("select * from ");
			mSql.append(TableName);
			mSql.append(" ");
			mSql.append(WherePart);
			break;

		case 6: // '\006'
			setPKWherePart(s);
			mSql.append("select * from ");
			mSql.append(TableName);
			mSql.append(" ");
			mSql.append(PKWherePart);
			break;

		case 7: // '\007'
			setWherePart(s);
			mSql.append("select count(1) from ");
			mSql.append(TableName);
			mSql.append(" ");
			mSql.append(WherePart);
			break;
		}
	}

	public String getSQL()
	{
		System.out.println((new StringBuilder("mSql: ")).append(mSql.toString()).toString());
		return mSql.toString();
	}

	public String getSQL(int sqlFlag, Schema s)
	{
		if (sqlFlag == 5 || sqlFlag == 6)
			setSQL(sqlFlag, s);
		else
			mSql.setLength(0);
		System.out.println((new StringBuilder("mSql: ")).append(mSql.toString()).toString());
		return mSql.toString();
	}

	public void setPKWherePart(Schema s)
	{
		System.out.println("进入更新后的setPKWherePart");
		PKWherePart.append("where");
		String pk[] = s.getPK();
		int n = pk.length;
		String strFieldName = "";
		StringBuffer strFieldValue = null;
		for (int i = 0; i < n; i++)
		{
			strFieldName = pk[i];
			strFieldValue = new StringBuffer(100);
			int nFieldType = s.getFieldType(strFieldName);
			switch (nFieldType)
			{
			case 0: // '\0'
			case 1: // '\001'
				strFieldValue.append("'");
				strFieldValue.append(s.getV(strFieldName));
				strFieldValue.append("'");
				break;

			case 2: // '\002'
			case 3: // '\003'
			case 4: // '\004'
				strFieldValue.append(s.getV(strFieldName));
				break;

			default:
				System.out.println("出现异常数据类型");
				break;
			}
			if (i != 0)
				PKWherePart.append(" and");
			PKWherePart.append(" ");
			PKWherePart.append(strFieldName);
			PKWherePart.append("=");
			PKWherePart.append(strFieldValue);
		}

	}

	public String getPKWherePart()
	{
		return PKWherePart.toString();
	}

	public void setWherePart(Schema s)
	{
		System.out.println("进入更新后的setWherePart");
		WherePart.append("where");
		int nFieldCount = s.getFieldCount();
		int j = 0;
		String strFieldName = "";
		StringBuffer strFieldValue = null;
		for (int i = 0; i < nFieldCount; i++)
		{
			strFieldName = s.getFieldName(i);
			strFieldValue = new StringBuffer(100);
			int nFieldType = s.getFieldType(i);
			boolean bFlag = false;
			switch (nFieldType)
			{
			case 0: // '\0'
			case 1: // '\001'
				if (s.getV(i).equals("null"))
				{
					strFieldValue.append(s.getV(i));
				} else
				{
					strFieldValue.append("'");
					strFieldValue.append(s.getV(i));
					strFieldValue.append("'");
					bFlag = true;
				}
				break;

			case 4: // '\004'
				if (!s.getV(i).equals("0.0"))
				{
					strFieldValue.append(s.getV(i));
					bFlag = true;
				}
				break;

			case 2: // '\002'
				if (!s.getV(i).equals("0.0"))
				{
					strFieldValue.append(s.getV(i));
					bFlag = true;
				}
				break;

			case 3: // '\003'
				if (!s.getV(i).equals("0"))
				{
					strFieldValue.append(s.getV(i));
					bFlag = true;
				}
				break;

			default:
				System.out.println("出现异常数据类型");
				bFlag = false;
				break;
			}
			if (bFlag)
			{
				if (++j != 1)
					WherePart.append(" and");
				WherePart.append(" ");
				WherePart.append(strFieldName);
				WherePart.append("=");
				WherePart.append(strFieldValue);
			}
		}

		if (j == 0)
			WherePart.setLength(0);
	}

	public String getWherePart()
	{
		return WherePart.toString();
	}

	public void setUpdPart(Schema s)
	{
		System.out.println("进入更新后的UpdPart");
		UpdPart.append("set ");
		int nFieldCount = s.getFieldCount();
		String strFieldName = "";
		StringBuffer strFieldValue = null;
		for (int i = 0; i < nFieldCount; i++)
		{
			strFieldName = s.getFieldName(i);
			strFieldValue = new StringBuffer(100);
			int nFieldType = s.getFieldType(i);
			switch (nFieldType)
			{
			case 0: // '\0'
			case 1: // '\001'
				if (s.getV(i).equals("null"))
				{
					strFieldValue.append(s.getV(i));
				} else
				{
					strFieldValue.append("'");
					strFieldValue.append(s.getV(i));
					strFieldValue.append("'");
				}
				break;

			case 2: // '\002'
			case 3: // '\003'
			case 4: // '\004'
				strFieldValue.append(s.getV(i));
				break;

			default:
				System.out.println("出现异常数据类型");
				break;
			}
			if (i != 0)
				UpdPart.append(",");
			UpdPart.append(strFieldName);
			UpdPart.append("=");
			UpdPart.append(strFieldValue);
		}

	}

	public String getUpdPart()
	{
		return UpdPart.toString();
	}

	public void setInsPart(Schema s)
	{
		System.out.println("进入更新后的InsPart");
		StringBuffer ColPart = new StringBuffer(256);
		ColPart.append("( ");
		StringBuffer ValPart = new StringBuffer(256);
		ValPart.append("values ( ");
		int nFieldCount = s.getFieldCount();
		int j = 0;
		String strFieldName = "";
		StringBuffer strFieldValue = null;
		for (int i = 0; i < nFieldCount; i++)
		{
			strFieldName = s.getFieldName(i);
			strFieldValue = new StringBuffer(100);
			int nFieldType = s.getFieldType(i);
			boolean bFlag = false;
			switch (nFieldType)
			{
			case 0: // '\0'
			case 1: // '\001'
				if (s.getV(i).equals("null"))
				{
					strFieldValue.append(s.getV(i));
				} else
				{
					strFieldValue.append("'");
					strFieldValue.append(s.getV(i));
					strFieldValue.append("'");
					bFlag = true;
				}
				break;

			case 2: // '\002'
			case 3: // '\003'
			case 4: // '\004'
				strFieldValue.append(s.getV(i));
				bFlag = true;
				break;

			default:
				bFlag = false;
				break;
			}
			if (bFlag)
			{
				if (++j != 1)
				{
					ColPart.append(",");
					ValPart.append(",");
				}
				ColPart.append(strFieldName);
				ValPart.append(strFieldValue);
			}
		}

		ColPart.append(" )");
		ValPart.append(" )");
		InsPart.append(ColPart);
		InsPart.append(" ");
		InsPart.append(ValPart);
		if (j == 0)
			InsPart.setLength(0);
	}

	public String getInsPart()
	{
		return InsPart.toString();
	}
}
