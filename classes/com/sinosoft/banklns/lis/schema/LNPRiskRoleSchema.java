// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskRoleSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskRoleDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskRoleSchema
	implements Schema, Cloneable
{

	private String riskCode;
	private String riskVer;
	private String riskRole;
	private String riskRoleSex;
	private String riskRoleNo;
	private String minAppAgeFlag;
	private int minAppAge;
	private String mAXAppAgeFlag;
	private int mAXAppAge;
	public static final int FIELDNUM = 9;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskRoleSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[4];
		pk[0] = "RiskCode";
		pk[1] = "RiskRole";
		pk[2] = "RiskRoleSex";
		pk[3] = "RiskRoleNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskRoleSchema cloned = (LNPRiskRoleSchema)super.clone();
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

	public String getRiskRole()
	{
		return riskRole;
	}

	public void setRiskRole(String aRiskRole)
	{
		riskRole = aRiskRole;
	}

	public String getRiskRoleSex()
	{
		return riskRoleSex;
	}

	public void setRiskRoleSex(String aRiskRoleSex)
	{
		riskRoleSex = aRiskRoleSex;
	}

	public String getRiskRoleNo()
	{
		return riskRoleNo;
	}

	public void setRiskRoleNo(String aRiskRoleNo)
	{
		riskRoleNo = aRiskRoleNo;
	}

	public String getMinAppAgeFlag()
	{
		return minAppAgeFlag;
	}

	public void setMinAppAgeFlag(String aMinAppAgeFlag)
	{
		minAppAgeFlag = aMinAppAgeFlag;
	}

	public int getMinAppAge()
	{
		return minAppAge;
	}

	public void setMinAppAge(int aMinAppAge)
	{
		minAppAge = aMinAppAge;
	}

	public void setMinAppAge(String aMinAppAge)
	{
		if (aMinAppAge != null && !aMinAppAge.equals(""))
		{
			Integer tInteger = new Integer(aMinAppAge);
			int i = tInteger.intValue();
			minAppAge = i;
		}
	}

	public String getMAXAppAgeFlag()
	{
		return mAXAppAgeFlag;
	}

	public void setMAXAppAgeFlag(String aMAXAppAgeFlag)
	{
		mAXAppAgeFlag = aMAXAppAgeFlag;
	}

	public int getMAXAppAge()
	{
		return mAXAppAge;
	}

	public void setMAXAppAge(int aMAXAppAge)
	{
		mAXAppAge = aMAXAppAge;
	}

	public void setMAXAppAge(String aMAXAppAge)
	{
		if (aMAXAppAge != null && !aMAXAppAge.equals(""))
		{
			Integer tInteger = new Integer(aMAXAppAge);
			int i = tInteger.intValue();
			mAXAppAge = i;
		}
	}

	public void setSchema(LNPRiskRoleSchema aLNPRiskRoleSchema)
	{
		riskCode = aLNPRiskRoleSchema.getRiskCode();
		riskVer = aLNPRiskRoleSchema.getRiskVer();
		riskRole = aLNPRiskRoleSchema.getRiskRole();
		riskRoleSex = aLNPRiskRoleSchema.getRiskRoleSex();
		riskRoleNo = aLNPRiskRoleSchema.getRiskRoleNo();
		minAppAgeFlag = aLNPRiskRoleSchema.getMinAppAgeFlag();
		minAppAge = aLNPRiskRoleSchema.getMinAppAge();
		mAXAppAgeFlag = aLNPRiskRoleSchema.getMAXAppAgeFlag();
		mAXAppAge = aLNPRiskRoleSchema.getMAXAppAge();
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
			if (rs.getString("RiskRole") == null)
				riskRole = null;
			else
				riskRole = rs.getString("RiskRole").trim();
			if (rs.getString("RiskRoleSex") == null)
				riskRoleSex = null;
			else
				riskRoleSex = rs.getString("RiskRoleSex").trim();
			if (rs.getString("RiskRoleNo") == null)
				riskRoleNo = null;
			else
				riskRoleNo = rs.getString("RiskRoleNo").trim();
			if (rs.getString("MinAppAgeFlag") == null)
				minAppAgeFlag = null;
			else
				minAppAgeFlag = rs.getString("MinAppAgeFlag").trim();
			minAppAge = rs.getInt("MinAppAge");
			if (rs.getString("MAXAppAgeFlag") == null)
				mAXAppAgeFlag = null;
			else
				mAXAppAgeFlag = rs.getString("MAXAppAgeFlag").trim();
			mAXAppAge = rs.getInt("MAXAppAge");
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPRiskRole????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskRoleSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskRoleSchema getSchema()
	{
		LNPRiskRoleSchema aLNPRiskRoleSchema = new LNPRiskRoleSchema();
		aLNPRiskRoleSchema.setSchema(this);
		return aLNPRiskRoleSchema;
	}

	public LNPRiskRoleDB getDB()
	{
		LNPRiskRoleDB aDBOper = new LNPRiskRoleDB();
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
		strReturn.append(StrTool.cTrim(riskRole));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskRoleSex));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskRoleNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(minAppAgeFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(minAppAge));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(mAXAppAgeFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(mAXAppAge));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			riskRole = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			riskRoleSex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			riskRoleNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			minAppAgeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			minAppAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).intValue();
			mAXAppAgeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			mAXAppAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).intValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskRoleSchema";
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
		if (FCode.equalsIgnoreCase("riskRole"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskRole));
		if (FCode.equalsIgnoreCase("riskRoleSex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskRoleSex));
		if (FCode.equalsIgnoreCase("riskRoleNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskRoleNo));
		if (FCode.equalsIgnoreCase("minAppAgeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(minAppAgeFlag));
		if (FCode.equalsIgnoreCase("minAppAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(minAppAge));
		if (FCode.equalsIgnoreCase("mAXAppAgeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mAXAppAgeFlag));
		if (FCode.equalsIgnoreCase("mAXAppAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mAXAppAge));
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
			strFieldValue = StrTool.GBKToUnicode(riskRole);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(riskRoleSex);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(riskRoleNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(minAppAgeFlag);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(minAppAge);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(mAXAppAgeFlag);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(mAXAppAge);
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
		if (FCode.equalsIgnoreCase("riskRole"))
			if (FValue != null && !FValue.equals(""))
				riskRole = FValue.trim();
			else
				riskRole = null;
		if (FCode.equalsIgnoreCase("riskRoleSex"))
			if (FValue != null && !FValue.equals(""))
				riskRoleSex = FValue.trim();
			else
				riskRoleSex = null;
		if (FCode.equalsIgnoreCase("riskRoleNo"))
			if (FValue != null && !FValue.equals(""))
				riskRoleNo = FValue.trim();
			else
				riskRoleNo = null;
		if (FCode.equalsIgnoreCase("minAppAgeFlag"))
			if (FValue != null && !FValue.equals(""))
				minAppAgeFlag = FValue.trim();
			else
				minAppAgeFlag = null;
		if (FCode.equalsIgnoreCase("minAppAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			minAppAge = i;
		}
		if (FCode.equalsIgnoreCase("mAXAppAgeFlag"))
			if (FValue != null && !FValue.equals(""))
				mAXAppAgeFlag = FValue.trim();
			else
				mAXAppAgeFlag = null;
		if (FCode.equalsIgnoreCase("mAXAppAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			mAXAppAge = i;
		}
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
		LNPRiskRoleSchema other = (LNPRiskRoleSchema)otherObject;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (riskVer == null && other.getRiskVer() != null)
			return false;
		if (riskVer != null && !riskVer.equals(other.getRiskVer()))
			return false;
		if (riskRole == null && other.getRiskRole() != null)
			return false;
		if (riskRole != null && !riskRole.equals(other.getRiskRole()))
			return false;
		if (riskRoleSex == null && other.getRiskRoleSex() != null)
			return false;
		if (riskRoleSex != null && !riskRoleSex.equals(other.getRiskRoleSex()))
			return false;
		if (riskRoleNo == null && other.getRiskRoleNo() != null)
			return false;
		if (riskRoleNo != null && !riskRoleNo.equals(other.getRiskRoleNo()))
			return false;
		if (minAppAgeFlag == null && other.getMinAppAgeFlag() != null)
			return false;
		if (minAppAgeFlag != null && !minAppAgeFlag.equals(other.getMinAppAgeFlag()))
			return false;
		if (minAppAge != other.getMinAppAge())
			return false;
		if (mAXAppAgeFlag == null && other.getMAXAppAgeFlag() != null)
			return false;
		if (mAXAppAgeFlag != null && !mAXAppAgeFlag.equals(other.getMAXAppAgeFlag()))
			return false;
		return mAXAppAge == other.getMAXAppAge();
	}

	public int getFieldCount()
	{
		return 9;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVer"))
			return 1;
		if (strFieldName.equals("riskRole"))
			return 2;
		if (strFieldName.equals("riskRoleSex"))
			return 3;
		if (strFieldName.equals("riskRoleNo"))
			return 4;
		if (strFieldName.equals("minAppAgeFlag"))
			return 5;
		if (strFieldName.equals("minAppAge"))
			return 6;
		if (strFieldName.equals("mAXAppAgeFlag"))
			return 7;
		return !strFieldName.equals("mAXAppAge") ? -1 : 8;
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
			strFieldName = "riskRole";
			break;

		case 3: // '\003'
			strFieldName = "riskRoleSex";
			break;

		case 4: // '\004'
			strFieldName = "riskRoleNo";
			break;

		case 5: // '\005'
			strFieldName = "minAppAgeFlag";
			break;

		case 6: // '\006'
			strFieldName = "minAppAge";
			break;

		case 7: // '\007'
			strFieldName = "mAXAppAgeFlag";
			break;

		case 8: // '\b'
			strFieldName = "mAXAppAge";
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
		if (strFieldName.equals("riskRole"))
			return 0;
		if (strFieldName.equals("riskRoleSex"))
			return 0;
		if (strFieldName.equals("riskRoleNo"))
			return 0;
		if (strFieldName.equals("minAppAgeFlag"))
			return 0;
		if (strFieldName.equals("minAppAge"))
			return 3;
		if (strFieldName.equals("mAXAppAgeFlag"))
			return 0;
		return !strFieldName.equals("mAXAppAge") ? -1 : 3;
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
			nFieldType = 3;
			break;

		case 7: // '\007'
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 3;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
