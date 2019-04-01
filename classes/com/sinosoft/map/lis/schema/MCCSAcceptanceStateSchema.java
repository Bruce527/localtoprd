// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MCCSAcceptanceStateSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MCCSAcceptanceStateDB;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MCCSAcceptanceStateSchema
	implements Schema, Cloneable
{

	private String serviceNo;
	private String agentCode;
	private String status;
	private String bY1;
	private String bY2;
	private String bY3;
	public static final int FIELDNUM = 6;
	private static String PK[];
	public CErrors mErrors;

	public MCCSAcceptanceStateSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "ServiceNo";
		pk[1] = "AgentCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MCCSAcceptanceStateSchema cloned = (MCCSAcceptanceStateSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getServiceNo()
	{
		return serviceNo;
	}

	public void setServiceNo(String aServiceNo)
	{
		serviceNo = aServiceNo;
	}

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String aStatus)
	{
		status = aStatus;
	}

	public String getBY1()
	{
		return bY1;
	}

	public void setBY1(String aBY1)
	{
		bY1 = aBY1;
	}

	public String getBY2()
	{
		return bY2;
	}

	public void setBY2(String aBY2)
	{
		bY2 = aBY2;
	}

	public String getBY3()
	{
		return bY3;
	}

	public void setBY3(String aBY3)
	{
		bY3 = aBY3;
	}

	public void setSchema(MCCSAcceptanceStateSchema aMCCSAcceptanceStateSchema)
	{
		serviceNo = aMCCSAcceptanceStateSchema.getServiceNo();
		agentCode = aMCCSAcceptanceStateSchema.getAgentCode();
		status = aMCCSAcceptanceStateSchema.getStatus();
		bY1 = aMCCSAcceptanceStateSchema.getBY1();
		bY2 = aMCCSAcceptanceStateSchema.getBY2();
		bY3 = aMCCSAcceptanceStateSchema.getBY3();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ServiceNo") == null)
				serviceNo = null;
			else
				serviceNo = rs.getString("ServiceNo").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("Status") == null)
				status = null;
			else
				status = rs.getString("Status").trim();
			if (rs.getString("BY1") == null)
				bY1 = null;
			else
				bY1 = rs.getString("BY1").trim();
			if (rs.getString("BY2") == null)
				bY2 = null;
			else
				bY2 = rs.getString("BY2").trim();
			if (rs.getString("BY3") == null)
				bY3 = null;
			else
				bY3 = rs.getString("BY3").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MCCSAcceptanceState表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MCCSAcceptanceStateSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MCCSAcceptanceStateSchema getSchema()
	{
		MCCSAcceptanceStateSchema aMCCSAcceptanceStateSchema = new MCCSAcceptanceStateSchema();
		aMCCSAcceptanceStateSchema.setSchema(this);
		return aMCCSAcceptanceStateSchema;
	}

	public MCCSAcceptanceStateDB getDB()
	{
		MCCSAcceptanceStateDB aDBOper = new MCCSAcceptanceStateDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(serviceNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(status));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bY1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bY2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bY3));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			serviceNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			status = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			bY1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			bY2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			bY3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MCCSAcceptanceStateSchema";
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
		if (FCode.equalsIgnoreCase("serviceNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(serviceNo));
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("status"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(status));
		if (FCode.equalsIgnoreCase("bY1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bY1));
		if (FCode.equalsIgnoreCase("bY2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bY2));
		if (FCode.equalsIgnoreCase("bY3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bY3));
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
			strFieldValue = StrTool.GBKToUnicode(serviceNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(status);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(bY1);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(bY2);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(bY3);
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
		if (FCode.equalsIgnoreCase("serviceNo"))
			if (FValue != null && !FValue.equals(""))
				serviceNo = FValue.trim();
			else
				serviceNo = null;
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equalsIgnoreCase("status"))
			if (FValue != null && !FValue.equals(""))
				status = FValue.trim();
			else
				status = null;
		if (FCode.equalsIgnoreCase("bY1"))
			if (FValue != null && !FValue.equals(""))
				bY1 = FValue.trim();
			else
				bY1 = null;
		if (FCode.equalsIgnoreCase("bY2"))
			if (FValue != null && !FValue.equals(""))
				bY2 = FValue.trim();
			else
				bY2 = null;
		if (FCode.equalsIgnoreCase("bY3"))
			if (FValue != null && !FValue.equals(""))
				bY3 = FValue.trim();
			else
				bY3 = null;
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
		MCCSAcceptanceStateSchema other = (MCCSAcceptanceStateSchema)otherObject;
		if (serviceNo == null && other.getServiceNo() != null)
			return false;
		if (serviceNo != null && !serviceNo.equals(other.getServiceNo()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (status == null && other.getStatus() != null)
			return false;
		if (status != null && !status.equals(other.getStatus()))
			return false;
		if (bY1 == null && other.getBY1() != null)
			return false;
		if (bY1 != null && !bY1.equals(other.getBY1()))
			return false;
		if (bY2 == null && other.getBY2() != null)
			return false;
		if (bY2 != null && !bY2.equals(other.getBY2()))
			return false;
		if (bY3 == null && other.getBY3() != null)
			return false;
		return bY3 == null || bY3.equals(other.getBY3());
	}

	public int getFieldCount()
	{
		return 6;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("serviceNo"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 1;
		if (strFieldName.equals("status"))
			return 2;
		if (strFieldName.equals("bY1"))
			return 3;
		if (strFieldName.equals("bY2"))
			return 4;
		return !strFieldName.equals("bY3") ? -1 : 5;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "serviceNo";
			break;

		case 1: // '\001'
			strFieldName = "agentCode";
			break;

		case 2: // '\002'
			strFieldName = "status";
			break;

		case 3: // '\003'
			strFieldName = "bY1";
			break;

		case 4: // '\004'
			strFieldName = "bY2";
			break;

		case 5: // '\005'
			strFieldName = "bY3";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("serviceNo"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("status"))
			return 0;
		if (strFieldName.equals("bY1"))
			return 0;
		if (strFieldName.equals("bY2"))
			return 0;
		return !strFieldName.equals("bY3") ? -1 : 0;
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

		case 3: // '\003'
			nFieldType = 0;
			break;

		case 4: // '\004'
			nFieldType = 0;
			break;

		case 5: // '\005'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
