// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskSaleGroupSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskSaleGroupDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskSaleGroupSchema
	implements Schema, Cloneable
{

	private String groupCode;
	private String groupName;
	private String groupDescribe;
	public static final int FIELDNUM = 3;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskSaleGroupSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "GroupCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskSaleGroupSchema cloned = (LNPRiskSaleGroupSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getGroupCode()
	{
		return groupCode;
	}

	public void setGroupCode(String aGroupCode)
	{
		groupCode = aGroupCode;
	}

	public String getGroupName()
	{
		return groupName;
	}

	public void setGroupName(String aGroupName)
	{
		groupName = aGroupName;
	}

	public String getGroupDescribe()
	{
		return groupDescribe;
	}

	public void setGroupDescribe(String aGroupDescribe)
	{
		groupDescribe = aGroupDescribe;
	}

	public void setSchema(LNPRiskSaleGroupSchema aLNPRiskSaleGroupSchema)
	{
		groupCode = aLNPRiskSaleGroupSchema.getGroupCode();
		groupName = aLNPRiskSaleGroupSchema.getGroupName();
		groupDescribe = aLNPRiskSaleGroupSchema.getGroupDescribe();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("GroupCode") == null)
				groupCode = null;
			else
				groupCode = rs.getString("GroupCode").trim();
			if (rs.getString("GroupName") == null)
				groupName = null;
			else
				groupName = rs.getString("GroupName").trim();
			if (rs.getString("GroupDescribe") == null)
				groupDescribe = null;
			else
				groupDescribe = rs.getString("GroupDescribe").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPRiskSaleGroup���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskSaleGroupSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskSaleGroupSchema getSchema()
	{
		LNPRiskSaleGroupSchema aLNPRiskSaleGroupSchema = new LNPRiskSaleGroupSchema();
		aLNPRiskSaleGroupSchema.setSchema(this);
		return aLNPRiskSaleGroupSchema;
	}

	public LNPRiskSaleGroupDB getDB()
	{
		LNPRiskSaleGroupDB aDBOper = new LNPRiskSaleGroupDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(groupCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(groupName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(groupDescribe));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			groupCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			groupName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			groupDescribe = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskSaleGroupSchema";
			tError.functionName = "decode";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public String getV(String FCode)
	{
		String strReturn = "";
		if (FCode.equalsIgnoreCase("groupCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(groupCode));
		if (FCode.equalsIgnoreCase("groupName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(groupName));
		if (FCode.equalsIgnoreCase("groupDescribe"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(groupDescribe));
		if (strReturn.equals(""))
			strReturn = "null";
		return strReturn;
	}

	public String getV(int nFieldIndex)
	{
		String strFieldValue = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldValue = StrTool.GBKToUnicode(groupCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(groupName);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(groupDescribe);
			break;

		default:
			strFieldValue = "";
			break;
		}
		if (strFieldValue.equals(""))
			strFieldValue = "null";
		return strFieldValue;
	}

	public boolean setV(String FCode, String FValue)
	{
		if (StrTool.cTrim(FCode).equals(""))
			return false;
		if (FCode.equalsIgnoreCase("groupCode"))
			if (FValue != null && !FValue.equals(""))
				groupCode = FValue.trim();
			else
				groupCode = null;
		if (FCode.equalsIgnoreCase("groupName"))
			if (FValue != null && !FValue.equals(""))
				groupName = FValue.trim();
			else
				groupName = null;
		if (FCode.equalsIgnoreCase("groupDescribe"))
			if (FValue != null && !FValue.equals(""))
				groupDescribe = FValue.trim();
			else
				groupDescribe = null;
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		if (this == otherObject)
			return true;
		if (getClass() != otherObject.getClass())
			return false;
		LNPRiskSaleGroupSchema other = (LNPRiskSaleGroupSchema)otherObject;
		if (groupCode == null && other.getGroupCode() != null)
			return false;
		if (groupCode != null && !groupCode.equals(other.getGroupCode()))
			return false;
		if (groupName == null && other.getGroupName() != null)
			return false;
		if (groupName != null && !groupName.equals(other.getGroupName()))
			return false;
		if (groupDescribe == null && other.getGroupDescribe() != null)
			return false;
		return groupDescribe == null || groupDescribe.equals(other.getGroupDescribe());
	}

	public int getFieldCount()
	{
		return 3;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("groupCode"))
			return 0;
		if (strFieldName.equals("groupName"))
			return 1;
		return !strFieldName.equals("groupDescribe") ? -1 : 2;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "groupCode";
			break;

		case 1: // '\001'
			strFieldName = "groupName";
			break;

		case 2: // '\002'
			strFieldName = "groupDescribe";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("groupCode"))
			return 0;
		if (strFieldName.equals("groupName"))
			return 0;
		return !strFieldName.equals("groupDescribe") ? -1 : 0;
	}

	public int getFieldType(int nFieldIndex)
	{
		int nFieldType = -1;
		switch (nFieldIndex)
		{
		case 0: // '\0'
			nFieldType = 0;
			break;

		case 1: // '\001'
			nFieldType = 0;
			break;

		case 2: // '\002'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
