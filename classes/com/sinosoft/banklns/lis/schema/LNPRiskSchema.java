// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskSchema
	implements Schema, Cloneable
{

	private String riskCode;
	private String riskVer;
	private String riskName;
	private String riskShortName;
	private String riskEnName;
	private String riskEnShortName;
	private String choDutyFlag;
	private String cPayFlag;
	private String getFlag;
	private String edorFlag;
	private String rnewFlag;
	private String uWFlag;
	private String rinsFlag;
	private String insuAccFlag;
	private double destRate;
	private String origRiskCode;
	private String subRiskVer;
	private String riskStatName;
	public static final int FIELDNUM = 18;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "RiskCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskSchema cloned = (LNPRiskSchema)super.clone();
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

	public String getRiskShortName()
	{
		return riskShortName;
	}

	public void setRiskShortName(String aRiskShortName)
	{
		riskShortName = aRiskShortName;
	}

	public String getRiskEnName()
	{
		return riskEnName;
	}

	public void setRiskEnName(String aRiskEnName)
	{
		riskEnName = aRiskEnName;
	}

	public String getRiskEnShortName()
	{
		return riskEnShortName;
	}

	public void setRiskEnShortName(String aRiskEnShortName)
	{
		riskEnShortName = aRiskEnShortName;
	}

	public String getChoDutyFlag()
	{
		return choDutyFlag;
	}

	public void setChoDutyFlag(String aChoDutyFlag)
	{
		choDutyFlag = aChoDutyFlag;
	}

	public String getCPayFlag()
	{
		return cPayFlag;
	}

	public void setCPayFlag(String aCPayFlag)
	{
		cPayFlag = aCPayFlag;
	}

	public String getGetFlag()
	{
		return getFlag;
	}

	public void setGetFlag(String aGetFlag)
	{
		getFlag = aGetFlag;
	}

	public String getEdorFlag()
	{
		return edorFlag;
	}

	public void setEdorFlag(String aEdorFlag)
	{
		edorFlag = aEdorFlag;
	}

	public String getRnewFlag()
	{
		return rnewFlag;
	}

	public void setRnewFlag(String aRnewFlag)
	{
		rnewFlag = aRnewFlag;
	}

	public String getUWFlag()
	{
		return uWFlag;
	}

	public void setUWFlag(String aUWFlag)
	{
		uWFlag = aUWFlag;
	}

	public String getRinsFlag()
	{
		return rinsFlag;
	}

	public void setRinsFlag(String aRinsFlag)
	{
		rinsFlag = aRinsFlag;
	}

	public String getInsuAccFlag()
	{
		return insuAccFlag;
	}

	public void setInsuAccFlag(String aInsuAccFlag)
	{
		insuAccFlag = aInsuAccFlag;
	}

	public double getDestRate()
	{
		return destRate;
	}

	public void setDestRate(double aDestRate)
	{
		destRate = aDestRate;
	}

	public void setDestRate(String aDestRate)
	{
		if (aDestRate != null && !aDestRate.equals(""))
		{
			Double tDouble = new Double(aDestRate);
			double d = tDouble.doubleValue();
			destRate = d;
		}
	}

	public String getOrigRiskCode()
	{
		return origRiskCode;
	}

	public void setOrigRiskCode(String aOrigRiskCode)
	{
		origRiskCode = aOrigRiskCode;
	}

	public String getSubRiskVer()
	{
		return subRiskVer;
	}

	public void setSubRiskVer(String aSubRiskVer)
	{
		subRiskVer = aSubRiskVer;
	}

	public String getRiskStatName()
	{
		return riskStatName;
	}

	public void setRiskStatName(String aRiskStatName)
	{
		riskStatName = aRiskStatName;
	}

	public void setSchema(LNPRiskSchema aLNPRiskSchema)
	{
		riskCode = aLNPRiskSchema.getRiskCode();
		riskVer = aLNPRiskSchema.getRiskVer();
		riskName = aLNPRiskSchema.getRiskName();
		riskShortName = aLNPRiskSchema.getRiskShortName();
		riskEnName = aLNPRiskSchema.getRiskEnName();
		riskEnShortName = aLNPRiskSchema.getRiskEnShortName();
		choDutyFlag = aLNPRiskSchema.getChoDutyFlag();
		cPayFlag = aLNPRiskSchema.getCPayFlag();
		getFlag = aLNPRiskSchema.getGetFlag();
		edorFlag = aLNPRiskSchema.getEdorFlag();
		rnewFlag = aLNPRiskSchema.getRnewFlag();
		uWFlag = aLNPRiskSchema.getUWFlag();
		rinsFlag = aLNPRiskSchema.getRinsFlag();
		insuAccFlag = aLNPRiskSchema.getInsuAccFlag();
		destRate = aLNPRiskSchema.getDestRate();
		origRiskCode = aLNPRiskSchema.getOrigRiskCode();
		subRiskVer = aLNPRiskSchema.getSubRiskVer();
		riskStatName = aLNPRiskSchema.getRiskStatName();
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
			if (rs.getString("RiskShortName") == null)
				riskShortName = null;
			else
				riskShortName = rs.getString("RiskShortName").trim();
			if (rs.getString("RiskEnName") == null)
				riskEnName = null;
			else
				riskEnName = rs.getString("RiskEnName").trim();
			if (rs.getString("RiskEnShortName") == null)
				riskEnShortName = null;
			else
				riskEnShortName = rs.getString("RiskEnShortName").trim();
			if (rs.getString("ChoDutyFlag") == null)
				choDutyFlag = null;
			else
				choDutyFlag = rs.getString("ChoDutyFlag").trim();
			if (rs.getString("CPayFlag") == null)
				cPayFlag = null;
			else
				cPayFlag = rs.getString("CPayFlag").trim();
			if (rs.getString("GetFlag") == null)
				getFlag = null;
			else
				getFlag = rs.getString("GetFlag").trim();
			if (rs.getString("EdorFlag") == null)
				edorFlag = null;
			else
				edorFlag = rs.getString("EdorFlag").trim();
			if (rs.getString("RnewFlag") == null)
				rnewFlag = null;
			else
				rnewFlag = rs.getString("RnewFlag").trim();
			if (rs.getString("UWFlag") == null)
				uWFlag = null;
			else
				uWFlag = rs.getString("UWFlag").trim();
			if (rs.getString("RinsFlag") == null)
				rinsFlag = null;
			else
				rinsFlag = rs.getString("RinsFlag").trim();
			if (rs.getString("InsuAccFlag") == null)
				insuAccFlag = null;
			else
				insuAccFlag = rs.getString("InsuAccFlag").trim();
			destRate = rs.getDouble("DestRate");
			if (rs.getString("OrigRiskCode") == null)
				origRiskCode = null;
			else
				origRiskCode = rs.getString("OrigRiskCode").trim();
			if (rs.getString("SubRiskVer") == null)
				subRiskVer = null;
			else
				subRiskVer = rs.getString("SubRiskVer").trim();
			if (rs.getString("RiskStatName") == null)
				riskStatName = null;
			else
				riskStatName = rs.getString("RiskStatName").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPRisk????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskSchema getSchema()
	{
		LNPRiskSchema aLNPRiskSchema = new LNPRiskSchema();
		aLNPRiskSchema.setSchema(this);
		return aLNPRiskSchema;
	}

	public LNPRiskDB getDB()
	{
		LNPRiskDB aDBOper = new LNPRiskDB();
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
		strReturn.append(StrTool.cTrim(riskShortName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskEnName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskEnShortName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(choDutyFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(cPayFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(edorFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rnewFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(uWFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rinsFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuAccFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(destRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(origRiskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(subRiskVer));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskStatName));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			riskName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			riskShortName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			riskEnName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			riskEnShortName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			choDutyFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			cPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			getFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			edorFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			rnewFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			uWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			rinsFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			insuAccFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			destRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|")))).doubleValue();
			origRiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			subRiskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			riskStatName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskSchema";
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
		if (FCode.equalsIgnoreCase("riskShortName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskShortName));
		if (FCode.equalsIgnoreCase("riskEnName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskEnName));
		if (FCode.equalsIgnoreCase("riskEnShortName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskEnShortName));
		if (FCode.equalsIgnoreCase("choDutyFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(choDutyFlag));
		if (FCode.equalsIgnoreCase("cPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(cPayFlag));
		if (FCode.equalsIgnoreCase("getFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getFlag));
		if (FCode.equalsIgnoreCase("edorFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorFlag));
		if (FCode.equalsIgnoreCase("rnewFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rnewFlag));
		if (FCode.equalsIgnoreCase("uWFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(uWFlag));
		if (FCode.equalsIgnoreCase("rinsFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rinsFlag));
		if (FCode.equalsIgnoreCase("insuAccFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuAccFlag));
		if (FCode.equalsIgnoreCase("destRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(destRate));
		if (FCode.equalsIgnoreCase("origRiskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(origRiskCode));
		if (FCode.equalsIgnoreCase("subRiskVer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(subRiskVer));
		if (FCode.equalsIgnoreCase("riskStatName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskStatName));
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
			strFieldValue = StrTool.GBKToUnicode(riskShortName);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(riskEnName);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(riskEnShortName);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(choDutyFlag);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(cPayFlag);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(getFlag);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(edorFlag);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(rnewFlag);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(uWFlag);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(rinsFlag);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(insuAccFlag);
			break;

		case 14: // '\016'
			strFieldValue = String.valueOf(destRate);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(origRiskCode);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(subRiskVer);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(riskStatName);
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
		if (FCode.equalsIgnoreCase("riskShortName"))
			if (FValue != null && !FValue.equals(""))
				riskShortName = FValue.trim();
			else
				riskShortName = null;
		if (FCode.equalsIgnoreCase("riskEnName"))
			if (FValue != null && !FValue.equals(""))
				riskEnName = FValue.trim();
			else
				riskEnName = null;
		if (FCode.equalsIgnoreCase("riskEnShortName"))
			if (FValue != null && !FValue.equals(""))
				riskEnShortName = FValue.trim();
			else
				riskEnShortName = null;
		if (FCode.equalsIgnoreCase("choDutyFlag"))
			if (FValue != null && !FValue.equals(""))
				choDutyFlag = FValue.trim();
			else
				choDutyFlag = null;
		if (FCode.equalsIgnoreCase("cPayFlag"))
			if (FValue != null && !FValue.equals(""))
				cPayFlag = FValue.trim();
			else
				cPayFlag = null;
		if (FCode.equalsIgnoreCase("getFlag"))
			if (FValue != null && !FValue.equals(""))
				getFlag = FValue.trim();
			else
				getFlag = null;
		if (FCode.equalsIgnoreCase("edorFlag"))
			if (FValue != null && !FValue.equals(""))
				edorFlag = FValue.trim();
			else
				edorFlag = null;
		if (FCode.equalsIgnoreCase("rnewFlag"))
			if (FValue != null && !FValue.equals(""))
				rnewFlag = FValue.trim();
			else
				rnewFlag = null;
		if (FCode.equalsIgnoreCase("uWFlag"))
			if (FValue != null && !FValue.equals(""))
				uWFlag = FValue.trim();
			else
				uWFlag = null;
		if (FCode.equalsIgnoreCase("rinsFlag"))
			if (FValue != null && !FValue.equals(""))
				rinsFlag = FValue.trim();
			else
				rinsFlag = null;
		if (FCode.equalsIgnoreCase("insuAccFlag"))
			if (FValue != null && !FValue.equals(""))
				insuAccFlag = FValue.trim();
			else
				insuAccFlag = null;
		if (FCode.equalsIgnoreCase("destRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			destRate = d;
		}
		if (FCode.equalsIgnoreCase("origRiskCode"))
			if (FValue != null && !FValue.equals(""))
				origRiskCode = FValue.trim();
			else
				origRiskCode = null;
		if (FCode.equalsIgnoreCase("subRiskVer"))
			if (FValue != null && !FValue.equals(""))
				subRiskVer = FValue.trim();
			else
				subRiskVer = null;
		if (FCode.equalsIgnoreCase("riskStatName"))
			if (FValue != null && !FValue.equals(""))
				riskStatName = FValue.trim();
			else
				riskStatName = null;
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
		LNPRiskSchema other = (LNPRiskSchema)otherObject;
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
		if (riskShortName == null && other.getRiskShortName() != null)
			return false;
		if (riskShortName != null && !riskShortName.equals(other.getRiskShortName()))
			return false;
		if (riskEnName == null && other.getRiskEnName() != null)
			return false;
		if (riskEnName != null && !riskEnName.equals(other.getRiskEnName()))
			return false;
		if (riskEnShortName == null && other.getRiskEnShortName() != null)
			return false;
		if (riskEnShortName != null && !riskEnShortName.equals(other.getRiskEnShortName()))
			return false;
		if (choDutyFlag == null && other.getChoDutyFlag() != null)
			return false;
		if (choDutyFlag != null && !choDutyFlag.equals(other.getChoDutyFlag()))
			return false;
		if (cPayFlag == null && other.getCPayFlag() != null)
			return false;
		if (cPayFlag != null && !cPayFlag.equals(other.getCPayFlag()))
			return false;
		if (getFlag == null && other.getGetFlag() != null)
			return false;
		if (getFlag != null && !getFlag.equals(other.getGetFlag()))
			return false;
		if (edorFlag == null && other.getEdorFlag() != null)
			return false;
		if (edorFlag != null && !edorFlag.equals(other.getEdorFlag()))
			return false;
		if (rnewFlag == null && other.getRnewFlag() != null)
			return false;
		if (rnewFlag != null && !rnewFlag.equals(other.getRnewFlag()))
			return false;
		if (uWFlag == null && other.getUWFlag() != null)
			return false;
		if (uWFlag != null && !uWFlag.equals(other.getUWFlag()))
			return false;
		if (rinsFlag == null && other.getRinsFlag() != null)
			return false;
		if (rinsFlag != null && !rinsFlag.equals(other.getRinsFlag()))
			return false;
		if (insuAccFlag == null && other.getInsuAccFlag() != null)
			return false;
		if (insuAccFlag != null && !insuAccFlag.equals(other.getInsuAccFlag()))
			return false;
		if (Double.doubleToLongBits(destRate) != Double.doubleToLongBits(other.getDestRate()))
			return false;
		if (origRiskCode == null && other.getOrigRiskCode() != null)
			return false;
		if (origRiskCode != null && !origRiskCode.equals(other.getOrigRiskCode()))
			return false;
		if (subRiskVer == null && other.getSubRiskVer() != null)
			return false;
		if (subRiskVer != null && !subRiskVer.equals(other.getSubRiskVer()))
			return false;
		if (riskStatName == null && other.getRiskStatName() != null)
			return false;
		return riskStatName == null || riskStatName.equals(other.getRiskStatName());
	}

	public int getFieldCount()
	{
		return 18;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVer"))
			return 1;
		if (strFieldName.equals("riskName"))
			return 2;
		if (strFieldName.equals("riskShortName"))
			return 3;
		if (strFieldName.equals("riskEnName"))
			return 4;
		if (strFieldName.equals("riskEnShortName"))
			return 5;
		if (strFieldName.equals("choDutyFlag"))
			return 6;
		if (strFieldName.equals("cPayFlag"))
			return 7;
		if (strFieldName.equals("getFlag"))
			return 8;
		if (strFieldName.equals("edorFlag"))
			return 9;
		if (strFieldName.equals("rnewFlag"))
			return 10;
		if (strFieldName.equals("uWFlag"))
			return 11;
		if (strFieldName.equals("rinsFlag"))
			return 12;
		if (strFieldName.equals("insuAccFlag"))
			return 13;
		if (strFieldName.equals("destRate"))
			return 14;
		if (strFieldName.equals("origRiskCode"))
			return 15;
		if (strFieldName.equals("subRiskVer"))
			return 16;
		return !strFieldName.equals("riskStatName") ? -1 : 17;
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
			strFieldName = "riskShortName";
			break;

		case 4: // '\004'
			strFieldName = "riskEnName";
			break;

		case 5: // '\005'
			strFieldName = "riskEnShortName";
			break;

		case 6: // '\006'
			strFieldName = "choDutyFlag";
			break;

		case 7: // '\007'
			strFieldName = "cPayFlag";
			break;

		case 8: // '\b'
			strFieldName = "getFlag";
			break;

		case 9: // '\t'
			strFieldName = "edorFlag";
			break;

		case 10: // '\n'
			strFieldName = "rnewFlag";
			break;

		case 11: // '\013'
			strFieldName = "uWFlag";
			break;

		case 12: // '\f'
			strFieldName = "rinsFlag";
			break;

		case 13: // '\r'
			strFieldName = "insuAccFlag";
			break;

		case 14: // '\016'
			strFieldName = "destRate";
			break;

		case 15: // '\017'
			strFieldName = "origRiskCode";
			break;

		case 16: // '\020'
			strFieldName = "subRiskVer";
			break;

		case 17: // '\021'
			strFieldName = "riskStatName";
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
		if (strFieldName.equals("riskShortName"))
			return 0;
		if (strFieldName.equals("riskEnName"))
			return 0;
		if (strFieldName.equals("riskEnShortName"))
			return 0;
		if (strFieldName.equals("choDutyFlag"))
			return 0;
		if (strFieldName.equals("cPayFlag"))
			return 0;
		if (strFieldName.equals("getFlag"))
			return 0;
		if (strFieldName.equals("edorFlag"))
			return 0;
		if (strFieldName.equals("rnewFlag"))
			return 0;
		if (strFieldName.equals("uWFlag"))
			return 0;
		if (strFieldName.equals("rinsFlag"))
			return 0;
		if (strFieldName.equals("insuAccFlag"))
			return 0;
		if (strFieldName.equals("destRate"))
			return 4;
		if (strFieldName.equals("origRiskCode"))
			return 0;
		if (strFieldName.equals("subRiskVer"))
			return 0;
		return !strFieldName.equals("riskStatName") ? -1 : 0;
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

		case 12: // '\f'
			nFieldType = 0;
			break;

		case 13: // '\r'
			nFieldType = 0;
			break;

		case 14: // '\016'
			nFieldType = 4;
			break;

		case 15: // '\017'
			nFieldType = 0;
			break;

		case 16: // '\020'
			nFieldType = 0;
			break;

		case 17: // '\021'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
