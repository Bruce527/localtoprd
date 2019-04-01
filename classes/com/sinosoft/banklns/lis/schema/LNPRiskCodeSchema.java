// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskCodeSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskCodeDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskCodeSchema
	implements Schema, Cloneable
{

	private String riskCode;
	private String riskVer;
	private String riskName;
	private String kindCode;
	private String riskType;
	private String sysRiskCode;
	private String mappingRiskCode;
	private String riskCodeBy1;
	private String riskCodeBy2;
	private String riskCodeBy3;
	private String riskCodeBy4;
	private String riskCodeBy5;
	public static final int FIELDNUM = 12;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskCodeSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "RiskCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskCodeSchema cloned = (LNPRiskCodeSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String aRiskCode)
	{
		riskCode = aRiskCode;
	}

	public String getRiskVer()
	{
		return riskVer;
	}

	public void setRiskVer(String aRiskVer)
	{
		riskVer = aRiskVer;
	}

	public String getRiskName()
	{
		return riskName;
	}

	public void setRiskName(String aRiskName)
	{
		riskName = aRiskName;
	}

	public String getKindCode()
	{
		return kindCode;
	}

	public void setKindCode(String aKindCode)
	{
		kindCode = aKindCode;
	}

	public String getRiskType()
	{
		return riskType;
	}

	public void setRiskType(String aRiskType)
	{
		riskType = aRiskType;
	}

	public String getSysRiskCode()
	{
		return sysRiskCode;
	}

	public void setSysRiskCode(String aSysRiskCode)
	{
		sysRiskCode = aSysRiskCode;
	}

	public String getMappingRiskCode()
	{
		return mappingRiskCode;
	}

	public void setMappingRiskCode(String aMappingRiskCode)
	{
		mappingRiskCode = aMappingRiskCode;
	}

	public String getRiskCodeBy1()
	{
		return riskCodeBy1;
	}

	public void setRiskCodeBy1(String aRiskCodeBy1)
	{
		riskCodeBy1 = aRiskCodeBy1;
	}

	public String getRiskCodeBy2()
	{
		return riskCodeBy2;
	}

	public void setRiskCodeBy2(String aRiskCodeBy2)
	{
		riskCodeBy2 = aRiskCodeBy2;
	}

	public String getRiskCodeBy3()
	{
		return riskCodeBy3;
	}

	public void setRiskCodeBy3(String aRiskCodeBy3)
	{
		riskCodeBy3 = aRiskCodeBy3;
	}

	public String getRiskCodeBy4()
	{
		return riskCodeBy4;
	}

	public void setRiskCodeBy4(String aRiskCodeBy4)
	{
		riskCodeBy4 = aRiskCodeBy4;
	}

	public String getRiskCodeBy5()
	{
		return riskCodeBy5;
	}

	public void setRiskCodeBy5(String aRiskCodeBy5)
	{
		riskCodeBy5 = aRiskCodeBy5;
	}

	public void setSchema(LNPRiskCodeSchema aLNPRiskCodeSchema)
	{
		riskCode = aLNPRiskCodeSchema.getRiskCode();
		riskVer = aLNPRiskCodeSchema.getRiskVer();
		riskName = aLNPRiskCodeSchema.getRiskName();
		kindCode = aLNPRiskCodeSchema.getKindCode();
		riskType = aLNPRiskCodeSchema.getRiskType();
		sysRiskCode = aLNPRiskCodeSchema.getSysRiskCode();
		mappingRiskCode = aLNPRiskCodeSchema.getMappingRiskCode();
		riskCodeBy1 = aLNPRiskCodeSchema.getRiskCodeBy1();
		riskCodeBy2 = aLNPRiskCodeSchema.getRiskCodeBy2();
		riskCodeBy3 = aLNPRiskCodeSchema.getRiskCodeBy3();
		riskCodeBy4 = aLNPRiskCodeSchema.getRiskCodeBy4();
		riskCodeBy5 = aLNPRiskCodeSchema.getRiskCodeBy5();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			if (rs.getString("RiskVer") == null)
				riskVer = null;
			else
				riskVer = rs.getString("RiskVer").trim();
			if (rs.getString("RiskName") == null)
				riskName = null;
			else
				riskName = rs.getString("RiskName").trim();
			if (rs.getString("KindCode") == null)
				kindCode = null;
			else
				kindCode = rs.getString("KindCode").trim();
			if (rs.getString("RiskType") == null)
				riskType = null;
			else
				riskType = rs.getString("RiskType").trim();
			if (rs.getString("SysRiskCode") == null)
				sysRiskCode = null;
			else
				sysRiskCode = rs.getString("SysRiskCode").trim();
			if (rs.getString("MappingRiskCode") == null)
				mappingRiskCode = null;
			else
				mappingRiskCode = rs.getString("MappingRiskCode").trim();
			if (rs.getString("RiskCodeBy1") == null)
				riskCodeBy1 = null;
			else
				riskCodeBy1 = rs.getString("RiskCodeBy1").trim();
			if (rs.getString("RiskCodeBy2") == null)
				riskCodeBy2 = null;
			else
				riskCodeBy2 = rs.getString("RiskCodeBy2").trim();
			if (rs.getString("RiskCodeBy3") == null)
				riskCodeBy3 = null;
			else
				riskCodeBy3 = rs.getString("RiskCodeBy3").trim();
			if (rs.getString("RiskCodeBy4") == null)
				riskCodeBy4 = null;
			else
				riskCodeBy4 = rs.getString("RiskCodeBy4").trim();
			if (rs.getString("RiskCodeBy5") == null)
				riskCodeBy5 = null;
			else
				riskCodeBy5 = rs.getString("RiskCodeBy5").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPRiskCode���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskCodeSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskCodeSchema getSchema()
	{
		LNPRiskCodeSchema aLNPRiskCodeSchema = new LNPRiskCodeSchema();
		aLNPRiskCodeSchema.setSchema(this);
		return aLNPRiskCodeSchema;
	}

	public LNPRiskCodeDB getDB()
	{
		LNPRiskCodeDB aDBOper = new LNPRiskCodeDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskVer));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(kindCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sysRiskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mappingRiskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCodeBy1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCodeBy2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCodeBy3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCodeBy4));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCodeBy5));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			riskName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			kindCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			riskType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			sysRiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			mappingRiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			riskCodeBy1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			riskCodeBy2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			riskCodeBy3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			riskCodeBy4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			riskCodeBy5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskCodeSchema";
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
		if (FCode.equalsIgnoreCase("riskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCode));
		if (FCode.equalsIgnoreCase("riskVer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskVer));
		if (FCode.equalsIgnoreCase("riskName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskName));
		if (FCode.equalsIgnoreCase("kindCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(kindCode));
		if (FCode.equalsIgnoreCase("riskType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskType));
		if (FCode.equalsIgnoreCase("sysRiskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sysRiskCode));
		if (FCode.equalsIgnoreCase("mappingRiskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mappingRiskCode));
		if (FCode.equalsIgnoreCase("riskCodeBy1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCodeBy1));
		if (FCode.equalsIgnoreCase("riskCodeBy2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCodeBy2));
		if (FCode.equalsIgnoreCase("riskCodeBy3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCodeBy3));
		if (FCode.equalsIgnoreCase("riskCodeBy4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCodeBy4));
		if (FCode.equalsIgnoreCase("riskCodeBy5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCodeBy5));
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
			strFieldValue = StrTool.GBKToUnicode(riskCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(riskVer);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(riskName);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(kindCode);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(riskType);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(sysRiskCode);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(mappingRiskCode);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(riskCodeBy1);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(riskCodeBy2);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(riskCodeBy3);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(riskCodeBy4);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(riskCodeBy5);
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
		if (FCode.equalsIgnoreCase("riskCode"))
			if (FValue != null && !FValue.equals(""))
				riskCode = FValue.trim();
			else
				riskCode = null;
		if (FCode.equalsIgnoreCase("riskVer"))
			if (FValue != null && !FValue.equals(""))
				riskVer = FValue.trim();
			else
				riskVer = null;
		if (FCode.equalsIgnoreCase("riskName"))
			if (FValue != null && !FValue.equals(""))
				riskName = FValue.trim();
			else
				riskName = null;
		if (FCode.equalsIgnoreCase("kindCode"))
			if (FValue != null && !FValue.equals(""))
				kindCode = FValue.trim();
			else
				kindCode = null;
		if (FCode.equalsIgnoreCase("riskType"))
			if (FValue != null && !FValue.equals(""))
				riskType = FValue.trim();
			else
				riskType = null;
		if (FCode.equalsIgnoreCase("sysRiskCode"))
			if (FValue != null && !FValue.equals(""))
				sysRiskCode = FValue.trim();
			else
				sysRiskCode = null;
		if (FCode.equalsIgnoreCase("mappingRiskCode"))
			if (FValue != null && !FValue.equals(""))
				mappingRiskCode = FValue.trim();
			else
				mappingRiskCode = null;
		if (FCode.equalsIgnoreCase("riskCodeBy1"))
			if (FValue != null && !FValue.equals(""))
				riskCodeBy1 = FValue.trim();
			else
				riskCodeBy1 = null;
		if (FCode.equalsIgnoreCase("riskCodeBy2"))
			if (FValue != null && !FValue.equals(""))
				riskCodeBy2 = FValue.trim();
			else
				riskCodeBy2 = null;
		if (FCode.equalsIgnoreCase("riskCodeBy3"))
			if (FValue != null && !FValue.equals(""))
				riskCodeBy3 = FValue.trim();
			else
				riskCodeBy3 = null;
		if (FCode.equalsIgnoreCase("riskCodeBy4"))
			if (FValue != null && !FValue.equals(""))
				riskCodeBy4 = FValue.trim();
			else
				riskCodeBy4 = null;
		if (FCode.equalsIgnoreCase("riskCodeBy5"))
			if (FValue != null && !FValue.equals(""))
				riskCodeBy5 = FValue.trim();
			else
				riskCodeBy5 = null;
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
		LNPRiskCodeSchema other = (LNPRiskCodeSchema)otherObject;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (riskVer == null && other.getRiskVer() != null)
			return false;
		if (riskVer != null && !riskVer.equals(other.getRiskVer()))
			return false;
		if (riskName == null && other.getRiskName() != null)
			return false;
		if (riskName != null && !riskName.equals(other.getRiskName()))
			return false;
		if (kindCode == null && other.getKindCode() != null)
			return false;
		if (kindCode != null && !kindCode.equals(other.getKindCode()))
			return false;
		if (riskType == null && other.getRiskType() != null)
			return false;
		if (riskType != null && !riskType.equals(other.getRiskType()))
			return false;
		if (sysRiskCode == null && other.getSysRiskCode() != null)
			return false;
		if (sysRiskCode != null && !sysRiskCode.equals(other.getSysRiskCode()))
			return false;
		if (mappingRiskCode == null && other.getMappingRiskCode() != null)
			return false;
		if (mappingRiskCode != null && !mappingRiskCode.equals(other.getMappingRiskCode()))
			return false;
		if (riskCodeBy1 == null && other.getRiskCodeBy1() != null)
			return false;
		if (riskCodeBy1 != null && !riskCodeBy1.equals(other.getRiskCodeBy1()))
			return false;
		if (riskCodeBy2 == null && other.getRiskCodeBy2() != null)
			return false;
		if (riskCodeBy2 != null && !riskCodeBy2.equals(other.getRiskCodeBy2()))
			return false;
		if (riskCodeBy3 == null && other.getRiskCodeBy3() != null)
			return false;
		if (riskCodeBy3 != null && !riskCodeBy3.equals(other.getRiskCodeBy3()))
			return false;
		if (riskCodeBy4 == null && other.getRiskCodeBy4() != null)
			return false;
		if (riskCodeBy4 != null && !riskCodeBy4.equals(other.getRiskCodeBy4()))
			return false;
		if (riskCodeBy5 == null && other.getRiskCodeBy5() != null)
			return false;
		return riskCodeBy5 == null || riskCodeBy5.equals(other.getRiskCodeBy5());
	}

	public int getFieldCount()
	{
		return 12;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVer"))
			return 1;
		if (strFieldName.equals("riskName"))
			return 2;
		if (strFieldName.equals("kindCode"))
			return 3;
		if (strFieldName.equals("riskType"))
			return 4;
		if (strFieldName.equals("sysRiskCode"))
			return 5;
		if (strFieldName.equals("mappingRiskCode"))
			return 6;
		if (strFieldName.equals("riskCodeBy1"))
			return 7;
		if (strFieldName.equals("riskCodeBy2"))
			return 8;
		if (strFieldName.equals("riskCodeBy3"))
			return 9;
		if (strFieldName.equals("riskCodeBy4"))
			return 10;
		return !strFieldName.equals("riskCodeBy5") ? -1 : 11;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "riskCode";
			break;

		case 1: // '\001'
			strFieldName = "riskVer";
			break;

		case 2: // '\002'
			strFieldName = "riskName";
			break;

		case 3: // '\003'
			strFieldName = "kindCode";
			break;

		case 4: // '\004'
			strFieldName = "riskType";
			break;

		case 5: // '\005'
			strFieldName = "sysRiskCode";
			break;

		case 6: // '\006'
			strFieldName = "mappingRiskCode";
			break;

		case 7: // '\007'
			strFieldName = "riskCodeBy1";
			break;

		case 8: // '\b'
			strFieldName = "riskCodeBy2";
			break;

		case 9: // '\t'
			strFieldName = "riskCodeBy3";
			break;

		case 10: // '\n'
			strFieldName = "riskCodeBy4";
			break;

		case 11: // '\013'
			strFieldName = "riskCodeBy5";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVer"))
			return 0;
		if (strFieldName.equals("riskName"))
			return 0;
		if (strFieldName.equals("kindCode"))
			return 0;
		if (strFieldName.equals("riskType"))
			return 0;
		if (strFieldName.equals("sysRiskCode"))
			return 0;
		if (strFieldName.equals("mappingRiskCode"))
			return 0;
		if (strFieldName.equals("riskCodeBy1"))
			return 0;
		if (strFieldName.equals("riskCodeBy2"))
			return 0;
		if (strFieldName.equals("riskCodeBy3"))
			return 0;
		if (strFieldName.equals("riskCodeBy4"))
			return 0;
		return !strFieldName.equals("riskCodeBy5") ? -1 : 0;
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

		case 6: // '\006'
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 0;
			break;

		case 9: // '\t'
			nFieldType = 0;
			break;

		case 10: // '\n'
			nFieldType = 0;
			break;

		case 11: // '\013'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
