// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskRelaSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskRelaDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskRelaSchema
	implements Schema, Cloneable
{

	private String riskCode;
	private String relaRiskCode;
	private String relaCode;
	private String manageComGrp;
	private String saleChnl;
	private int minAppntAge;
	private int maxAppntAge;
	private int maxInsuredAge;
	private int minInsuredAge;
	public static final int FIELDNUM = 9;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskRelaSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[5];
		pk[0] = "RiskCode";
		pk[1] = "RelaRiskCode";
		pk[2] = "RelaCode";
		pk[3] = "ManageComGrp";
		pk[4] = "SaleChnl";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskRelaSchema cloned = (LNPRiskRelaSchema)super.clone();
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

	public String getRelaRiskCode()
	{
		return relaRiskCode;
	}

	public void setRelaRiskCode(String aRelaRiskCode)
	{
		relaRiskCode = aRelaRiskCode;
	}

	public String getRelaCode()
	{
		return relaCode;
	}

	public void setRelaCode(String aRelaCode)
	{
		relaCode = aRelaCode;
	}

	public String getManageComGrp()
	{
		return manageComGrp;
	}

	public void setManageComGrp(String aManageComGrp)
	{
		manageComGrp = aManageComGrp;
	}

	public String getSaleChnl()
	{
		return saleChnl;
	}

	public void setSaleChnl(String aSaleChnl)
	{
		saleChnl = aSaleChnl;
	}

	public int getMinAppntAge()
	{
		return minAppntAge;
	}

	public void setMinAppntAge(int aMinAppntAge)
	{
		minAppntAge = aMinAppntAge;
	}

	public void setMinAppntAge(String aMinAppntAge)
	{
		if (aMinAppntAge != null && !aMinAppntAge.equals(""))
		{
			Integer tInteger = new Integer(aMinAppntAge);
			int i = tInteger.intValue();
			minAppntAge = i;
		}
	}

	public int getMaxAppntAge()
	{
		return maxAppntAge;
	}

	public void setMaxAppntAge(int aMaxAppntAge)
	{
		maxAppntAge = aMaxAppntAge;
	}

	public void setMaxAppntAge(String aMaxAppntAge)
	{
		if (aMaxAppntAge != null && !aMaxAppntAge.equals(""))
		{
			Integer tInteger = new Integer(aMaxAppntAge);
			int i = tInteger.intValue();
			maxAppntAge = i;
		}
	}

	public int getMaxInsuredAge()
	{
		return maxInsuredAge;
	}

	public void setMaxInsuredAge(int aMaxInsuredAge)
	{
		maxInsuredAge = aMaxInsuredAge;
	}

	public void setMaxInsuredAge(String aMaxInsuredAge)
	{
		if (aMaxInsuredAge != null && !aMaxInsuredAge.equals(""))
		{
			Integer tInteger = new Integer(aMaxInsuredAge);
			int i = tInteger.intValue();
			maxInsuredAge = i;
		}
	}

	public int getMinInsuredAge()
	{
		return minInsuredAge;
	}

	public void setMinInsuredAge(int aMinInsuredAge)
	{
		minInsuredAge = aMinInsuredAge;
	}

	public void setMinInsuredAge(String aMinInsuredAge)
	{
		if (aMinInsuredAge != null && !aMinInsuredAge.equals(""))
		{
			Integer tInteger = new Integer(aMinInsuredAge);
			int i = tInteger.intValue();
			minInsuredAge = i;
		}
	}

	public void setSchema(LNPRiskRelaSchema aLNPRiskRelaSchema)
	{
		riskCode = aLNPRiskRelaSchema.getRiskCode();
		relaRiskCode = aLNPRiskRelaSchema.getRelaRiskCode();
		relaCode = aLNPRiskRelaSchema.getRelaCode();
		manageComGrp = aLNPRiskRelaSchema.getManageComGrp();
		saleChnl = aLNPRiskRelaSchema.getSaleChnl();
		minAppntAge = aLNPRiskRelaSchema.getMinAppntAge();
		maxAppntAge = aLNPRiskRelaSchema.getMaxAppntAge();
		maxInsuredAge = aLNPRiskRelaSchema.getMaxInsuredAge();
		minInsuredAge = aLNPRiskRelaSchema.getMinInsuredAge();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			if (rs.getString("RelaRiskCode") == null)
				relaRiskCode = null;
			else
				relaRiskCode = rs.getString("RelaRiskCode").trim();
			if (rs.getString("RelaCode") == null)
				relaCode = null;
			else
				relaCode = rs.getString("RelaCode").trim();
			if (rs.getString("ManageComGrp") == null)
				manageComGrp = null;
			else
				manageComGrp = rs.getString("ManageComGrp").trim();
			if (rs.getString("SaleChnl") == null)
				saleChnl = null;
			else
				saleChnl = rs.getString("SaleChnl").trim();
			minAppntAge = rs.getInt("MinAppntAge");
			maxAppntAge = rs.getInt("MaxAppntAge");
			maxInsuredAge = rs.getInt("MaxInsuredAge");
			minInsuredAge = rs.getInt("MinInsuredAge");
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPRiskRela????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskRelaSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskRelaSchema getSchema()
	{
		LNPRiskRelaSchema aLNPRiskRelaSchema = new LNPRiskRelaSchema();
		aLNPRiskRelaSchema.setSchema(this);
		return aLNPRiskRelaSchema;
	}

	public LNPRiskRelaDB getDB()
	{
		LNPRiskRelaDB aDBOper = new LNPRiskRelaDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relaRiskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(relaCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageComGrp));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(saleChnl));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(minAppntAge));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(maxAppntAge));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(maxInsuredAge));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(minInsuredAge));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			relaRiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			relaCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			manageComGrp = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			minAppntAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).intValue();
			maxAppntAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).intValue();
			maxInsuredAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).intValue();
			minInsuredAge = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).intValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskRelaSchema";
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
		if (FCode.equalsIgnoreCase("relaRiskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relaRiskCode));
		if (FCode.equalsIgnoreCase("relaCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(relaCode));
		if (FCode.equalsIgnoreCase("manageComGrp"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageComGrp));
		if (FCode.equalsIgnoreCase("saleChnl"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnl));
		if (FCode.equalsIgnoreCase("minAppntAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(minAppntAge));
		if (FCode.equalsIgnoreCase("maxAppntAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(maxAppntAge));
		if (FCode.equalsIgnoreCase("maxInsuredAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(maxInsuredAge));
		if (FCode.equalsIgnoreCase("minInsuredAge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(minInsuredAge));
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
			strFieldValue = StrTool.GBKToUnicode(relaRiskCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(relaCode);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(manageComGrp);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(saleChnl);
			break;

		case 5: // '\005'
			strFieldValue = String.valueOf(minAppntAge);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(maxAppntAge);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(maxInsuredAge);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(minInsuredAge);
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
		if (FCode.equalsIgnoreCase("relaRiskCode"))
			if (FValue != null && !FValue.equals(""))
				relaRiskCode = FValue.trim();
			else
				relaRiskCode = null;
		if (FCode.equalsIgnoreCase("relaCode"))
			if (FValue != null && !FValue.equals(""))
				relaCode = FValue.trim();
			else
				relaCode = null;
		if (FCode.equalsIgnoreCase("manageComGrp"))
			if (FValue != null && !FValue.equals(""))
				manageComGrp = FValue.trim();
			else
				manageComGrp = null;
		if (FCode.equalsIgnoreCase("saleChnl"))
			if (FValue != null && !FValue.equals(""))
				saleChnl = FValue.trim();
			else
				saleChnl = null;
		if (FCode.equalsIgnoreCase("minAppntAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			minAppntAge = i;
		}
		if (FCode.equalsIgnoreCase("maxAppntAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			maxAppntAge = i;
		}
		if (FCode.equalsIgnoreCase("maxInsuredAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			maxInsuredAge = i;
		}
		if (FCode.equalsIgnoreCase("minInsuredAge") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			minInsuredAge = i;
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
		LNPRiskRelaSchema other = (LNPRiskRelaSchema)otherObject;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (relaRiskCode == null && other.getRelaRiskCode() != null)
			return false;
		if (relaRiskCode != null && !relaRiskCode.equals(other.getRelaRiskCode()))
			return false;
		if (relaCode == null && other.getRelaCode() != null)
			return false;
		if (relaCode != null && !relaCode.equals(other.getRelaCode()))
			return false;
		if (manageComGrp == null && other.getManageComGrp() != null)
			return false;
		if (manageComGrp != null && !manageComGrp.equals(other.getManageComGrp()))
			return false;
		if (saleChnl == null && other.getSaleChnl() != null)
			return false;
		if (saleChnl != null && !saleChnl.equals(other.getSaleChnl()))
			return false;
		if (minAppntAge != other.getMinAppntAge())
			return false;
		if (maxAppntAge != other.getMaxAppntAge())
			return false;
		if (maxInsuredAge != other.getMaxInsuredAge())
			return false;
		return minInsuredAge == other.getMinInsuredAge();
	}

	public int getFieldCount()
	{
		return 9;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("relaRiskCode"))
			return 1;
		if (strFieldName.equals("relaCode"))
			return 2;
		if (strFieldName.equals("manageComGrp"))
			return 3;
		if (strFieldName.equals("saleChnl"))
			return 4;
		if (strFieldName.equals("minAppntAge"))
			return 5;
		if (strFieldName.equals("maxAppntAge"))
			return 6;
		if (strFieldName.equals("maxInsuredAge"))
			return 7;
		return !strFieldName.equals("minInsuredAge") ? -1 : 8;
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
			strFieldName = "relaRiskCode";
			break;

		case 2: // '\002'
			strFieldName = "relaCode";
			break;

		case 3: // '\003'
			strFieldName = "manageComGrp";
			break;

		case 4: // '\004'
			strFieldName = "saleChnl";
			break;

		case 5: // '\005'
			strFieldName = "minAppntAge";
			break;

		case 6: // '\006'
			strFieldName = "maxAppntAge";
			break;

		case 7: // '\007'
			strFieldName = "maxInsuredAge";
			break;

		case 8: // '\b'
			strFieldName = "minInsuredAge";
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
		if (strFieldName.equals("relaRiskCode"))
			return 0;
		if (strFieldName.equals("relaCode"))
			return 0;
		if (strFieldName.equals("manageComGrp"))
			return 0;
		if (strFieldName.equals("saleChnl"))
			return 0;
		if (strFieldName.equals("minAppntAge"))
			return 3;
		if (strFieldName.equals("maxAppntAge"))
			return 3;
		if (strFieldName.equals("maxInsuredAge"))
			return 3;
		return !strFieldName.equals("minInsuredAge") ? -1 : 3;
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
			nFieldType = 3;
			break;

		case 6: // '\006'
			nFieldType = 3;
			break;

		case 7: // '\007'
			nFieldType = 3;
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
