// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskComCtrlSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskComCtrlDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPRiskComCtrlSchema
	implements Schema, Cloneable
{

	private String riskCode;
	private String manageComGrp;
	private String saleChnl;
	private Date startDate;
	private Date endDate;
	private double mAXAmnt;
	private double mAXMult;
	private double mAXPrem;
	private double mINAmnt;
	private double mINMult;
	private double mINPrem;
	public static final int FIELDNUM = 11;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPRiskComCtrlSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[3];
		pk[0] = "RiskCode";
		pk[1] = "ManageComGrp";
		pk[2] = "SaleChnl";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskComCtrlSchema cloned = (LNPRiskComCtrlSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
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

	public String getStartDate()
	{
		if (startDate != null)
			return fDate.getString(startDate);
		else
			return null;
	}

	public void setStartDate(Date aStartDate)
	{
		startDate = aStartDate;
	}

	public void setStartDate(String aStartDate)
	{
		if (aStartDate != null && !aStartDate.equals(""))
			startDate = fDate.getDate(aStartDate);
		else
			startDate = null;
	}

	public String getEndDate()
	{
		if (endDate != null)
			return fDate.getString(endDate);
		else
			return null;
	}

	public void setEndDate(Date aEndDate)
	{
		endDate = aEndDate;
	}

	public void setEndDate(String aEndDate)
	{
		if (aEndDate != null && !aEndDate.equals(""))
			endDate = fDate.getDate(aEndDate);
		else
			endDate = null;
	}

	public double getMAXAmnt()
	{
		return mAXAmnt;
	}

	public void setMAXAmnt(double aMAXAmnt)
	{
		mAXAmnt = aMAXAmnt;
	}

	public void setMAXAmnt(String aMAXAmnt)
	{
		if (aMAXAmnt != null && !aMAXAmnt.equals(""))
		{
			Double tDouble = new Double(aMAXAmnt);
			double d = tDouble.doubleValue();
			mAXAmnt = d;
		}
	}

	public double getMAXMult()
	{
		return mAXMult;
	}

	public void setMAXMult(double aMAXMult)
	{
		mAXMult = aMAXMult;
	}

	public void setMAXMult(String aMAXMult)
	{
		if (aMAXMult != null && !aMAXMult.equals(""))
		{
			Double tDouble = new Double(aMAXMult);
			double d = tDouble.doubleValue();
			mAXMult = d;
		}
	}

	public double getMAXPrem()
	{
		return mAXPrem;
	}

	public void setMAXPrem(double aMAXPrem)
	{
		mAXPrem = aMAXPrem;
	}

	public void setMAXPrem(String aMAXPrem)
	{
		if (aMAXPrem != null && !aMAXPrem.equals(""))
		{
			Double tDouble = new Double(aMAXPrem);
			double d = tDouble.doubleValue();
			mAXPrem = d;
		}
	}

	public double getMINAmnt()
	{
		return mINAmnt;
	}

	public void setMINAmnt(double aMINAmnt)
	{
		mINAmnt = aMINAmnt;
	}

	public void setMINAmnt(String aMINAmnt)
	{
		if (aMINAmnt != null && !aMINAmnt.equals(""))
		{
			Double tDouble = new Double(aMINAmnt);
			double d = tDouble.doubleValue();
			mINAmnt = d;
		}
	}

	public double getMINMult()
	{
		return mINMult;
	}

	public void setMINMult(double aMINMult)
	{
		mINMult = aMINMult;
	}

	public void setMINMult(String aMINMult)
	{
		if (aMINMult != null && !aMINMult.equals(""))
		{
			Double tDouble = new Double(aMINMult);
			double d = tDouble.doubleValue();
			mINMult = d;
		}
	}

	public double getMINPrem()
	{
		return mINPrem;
	}

	public void setMINPrem(double aMINPrem)
	{
		mINPrem = aMINPrem;
	}

	public void setMINPrem(String aMINPrem)
	{
		if (aMINPrem != null && !aMINPrem.equals(""))
		{
			Double tDouble = new Double(aMINPrem);
			double d = tDouble.doubleValue();
			mINPrem = d;
		}
	}

	public void setSchema(LNPRiskComCtrlSchema aLNPRiskComCtrlSchema)
	{
		riskCode = aLNPRiskComCtrlSchema.getRiskCode();
		manageComGrp = aLNPRiskComCtrlSchema.getManageComGrp();
		saleChnl = aLNPRiskComCtrlSchema.getSaleChnl();
		startDate = fDate.getDate(aLNPRiskComCtrlSchema.getStartDate());
		endDate = fDate.getDate(aLNPRiskComCtrlSchema.getEndDate());
		mAXAmnt = aLNPRiskComCtrlSchema.getMAXAmnt();
		mAXMult = aLNPRiskComCtrlSchema.getMAXMult();
		mAXPrem = aLNPRiskComCtrlSchema.getMAXPrem();
		mINAmnt = aLNPRiskComCtrlSchema.getMINAmnt();
		mINMult = aLNPRiskComCtrlSchema.getMINMult();
		mINPrem = aLNPRiskComCtrlSchema.getMINPrem();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			if (rs.getString("ManageComGrp") == null)
				manageComGrp = null;
			else
				manageComGrp = rs.getString("ManageComGrp").trim();
			if (rs.getString("SaleChnl") == null)
				saleChnl = null;
			else
				saleChnl = rs.getString("SaleChnl").trim();
			startDate = rs.getDate("StartDate");
			endDate = rs.getDate("EndDate");
			mAXAmnt = rs.getDouble("MAXAmnt");
			mAXMult = rs.getDouble("MAXMult");
			mAXPrem = rs.getDouble("MAXPrem");
			mINAmnt = rs.getDouble("MINAmnt");
			mINMult = rs.getDouble("MINMult");
			mINPrem = rs.getDouble("MINPrem");
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPRiskComCtrl????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskComCtrlSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskComCtrlSchema getSchema()
	{
		LNPRiskComCtrlSchema aLNPRiskComCtrlSchema = new LNPRiskComCtrlSchema();
		aLNPRiskComCtrlSchema.setSchema(this);
		return aLNPRiskComCtrlSchema;
	}

	public LNPRiskComCtrlDB getDB()
	{
		LNPRiskComCtrlDB aDBOper = new LNPRiskComCtrlDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageComGrp));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(saleChnl));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(endDate)));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(mAXAmnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(mAXMult));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(mAXPrem));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(mINAmnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(mINMult));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(mINPrem));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			manageComGrp = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
			mAXAmnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).doubleValue();
			mAXMult = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).doubleValue();
			mAXPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).doubleValue();
			mINAmnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).doubleValue();
			mINMult = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).doubleValue();
			mINPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).doubleValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskComCtrlSchema";
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
		if (FCode.equalsIgnoreCase("manageComGrp"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageComGrp));
		if (FCode.equalsIgnoreCase("saleChnl"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(saleChnl));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("endDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
		if (FCode.equalsIgnoreCase("mAXAmnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mAXAmnt));
		if (FCode.equalsIgnoreCase("mAXMult"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mAXMult));
		if (FCode.equalsIgnoreCase("mAXPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mAXPrem));
		if (FCode.equalsIgnoreCase("mINAmnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mINAmnt));
		if (FCode.equalsIgnoreCase("mINMult"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mINMult));
		if (FCode.equalsIgnoreCase("mINPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(mINPrem));
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
			strFieldValue = StrTool.GBKToUnicode(manageComGrp);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(saleChnl);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
			break;

		case 5: // '\005'
			strFieldValue = String.valueOf(mAXAmnt);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(mAXMult);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(mAXPrem);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(mINAmnt);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(mINMult);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(mINPrem);
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
		if (FCode.equalsIgnoreCase("startDate"))
			if (FValue != null && !FValue.equals(""))
				startDate = fDate.getDate(FValue);
			else
				startDate = null;
		if (FCode.equalsIgnoreCase("endDate"))
			if (FValue != null && !FValue.equals(""))
				endDate = fDate.getDate(FValue);
			else
				endDate = null;
		if (FCode.equalsIgnoreCase("mAXAmnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mAXAmnt = d;
		}
		if (FCode.equalsIgnoreCase("mAXMult") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mAXMult = d;
		}
		if (FCode.equalsIgnoreCase("mAXPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mAXPrem = d;
		}
		if (FCode.equalsIgnoreCase("mINAmnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mINAmnt = d;
		}
		if (FCode.equalsIgnoreCase("mINMult") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mINMult = d;
		}
		if (FCode.equalsIgnoreCase("mINPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			mINPrem = d;
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
		LNPRiskComCtrlSchema other = (LNPRiskComCtrlSchema)otherObject;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (manageComGrp == null && other.getManageComGrp() != null)
			return false;
		if (manageComGrp != null && !manageComGrp.equals(other.getManageComGrp()))
			return false;
		if (saleChnl == null && other.getSaleChnl() != null)
			return false;
		if (saleChnl != null && !saleChnl.equals(other.getSaleChnl()))
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (endDate == null && other.getEndDate() != null)
			return false;
		if (endDate != null && !fDate.getString(endDate).equals(other.getEndDate()))
			return false;
		if (Double.doubleToLongBits(mAXAmnt) != Double.doubleToLongBits(other.getMAXAmnt()))
			return false;
		if (Double.doubleToLongBits(mAXMult) != Double.doubleToLongBits(other.getMAXMult()))
			return false;
		if (Double.doubleToLongBits(mAXPrem) != Double.doubleToLongBits(other.getMAXPrem()))
			return false;
		if (Double.doubleToLongBits(mINAmnt) != Double.doubleToLongBits(other.getMINAmnt()))
			return false;
		if (Double.doubleToLongBits(mINMult) != Double.doubleToLongBits(other.getMINMult()))
			return false;
		return Double.doubleToLongBits(mINPrem) == Double.doubleToLongBits(other.getMINPrem());
	}

	public int getFieldCount()
	{
		return 11;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("manageComGrp"))
			return 1;
		if (strFieldName.equals("saleChnl"))
			return 2;
		if (strFieldName.equals("startDate"))
			return 3;
		if (strFieldName.equals("endDate"))
			return 4;
		if (strFieldName.equals("mAXAmnt"))
			return 5;
		if (strFieldName.equals("mAXMult"))
			return 6;
		if (strFieldName.equals("mAXPrem"))
			return 7;
		if (strFieldName.equals("mINAmnt"))
			return 8;
		if (strFieldName.equals("mINMult"))
			return 9;
		return !strFieldName.equals("mINPrem") ? -1 : 10;
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
			strFieldName = "manageComGrp";
			break;

		case 2: // '\002'
			strFieldName = "saleChnl";
			break;

		case 3: // '\003'
			strFieldName = "startDate";
			break;

		case 4: // '\004'
			strFieldName = "endDate";
			break;

		case 5: // '\005'
			strFieldName = "mAXAmnt";
			break;

		case 6: // '\006'
			strFieldName = "mAXMult";
			break;

		case 7: // '\007'
			strFieldName = "mAXPrem";
			break;

		case 8: // '\b'
			strFieldName = "mINAmnt";
			break;

		case 9: // '\t'
			strFieldName = "mINMult";
			break;

		case 10: // '\n'
			strFieldName = "mINPrem";
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
		if (strFieldName.equals("manageComGrp"))
			return 0;
		if (strFieldName.equals("saleChnl"))
			return 0;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("endDate"))
			return 1;
		if (strFieldName.equals("mAXAmnt"))
			return 4;
		if (strFieldName.equals("mAXMult"))
			return 4;
		if (strFieldName.equals("mAXPrem"))
			return 4;
		if (strFieldName.equals("mINAmnt"))
			return 4;
		if (strFieldName.equals("mINMult"))
			return 4;
		return !strFieldName.equals("mINPrem") ? -1 : 4;
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
			nFieldType = 1;
			break;

		case 4: // '\004'
			nFieldType = 1;
			break;

		case 5: // '\005'
			nFieldType = 4;
			break;

		case 6: // '\006'
			nFieldType = 4;
			break;

		case 7: // '\007'
			nFieldType = 4;
			break;

		case 8: // '\b'
			nFieldType = 4;
			break;

		case 9: // '\t'
			nFieldType = 4;
			break;

		case 10: // '\n'
			nFieldType = 4;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
