// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutySchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPDutyDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPDutySchema
	implements Schema, Cloneable
{

	private String dutyCode;
	private String dutyName;
	private int payEndYear;
	private String payEndYearFlag;
	private String payEndDateCalRef;
	private String payEndDateCalMode;
	private int getYear;
	private String getYearFlag;
	private int insuYear;
	private String insuYearFlag;
	private int acciYear;
	private String acciYearFlag;
	private String calMode;
	private String payEndYearRela;
	private String getYearRela;
	private String insuYearRela;
	private String basicCalCode;
	private String riskCalCode;
	private String amntFlag;
	private double vPU;
	private String addFeeFlag;
	private String endDateCalMode;
	public static final int FIELDNUM = 22;
	private static String PK[];
	public CErrors mErrors;

	public LNPDutySchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "DutyCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPDutySchema cloned = (LNPDutySchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getDutyCode()
	{
		return dutyCode;
	}

	public void setDutyCode(String aDutyCode)
	{
		dutyCode = aDutyCode;
	}

	public String getDutyName()
	{
		return dutyName;
	}

	public void setDutyName(String aDutyName)
	{
		dutyName = aDutyName;
	}

	public int getPayEndYear()
	{
		return payEndYear;
	}

	public void setPayEndYear(int aPayEndYear)
	{
		payEndYear = aPayEndYear;
	}

	public void setPayEndYear(String aPayEndYear)
	{
		if (aPayEndYear != null && !aPayEndYear.equals(""))
		{
			Integer tInteger = new Integer(aPayEndYear);
			int i = tInteger.intValue();
			payEndYear = i;
		}
	}

	public String getPayEndYearFlag()
	{
		return payEndYearFlag;
	}

	public void setPayEndYearFlag(String aPayEndYearFlag)
	{
		payEndYearFlag = aPayEndYearFlag;
	}

	public String getPayEndDateCalRef()
	{
		return payEndDateCalRef;
	}

	public void setPayEndDateCalRef(String aPayEndDateCalRef)
	{
		payEndDateCalRef = aPayEndDateCalRef;
	}

	public String getPayEndDateCalMode()
	{
		return payEndDateCalMode;
	}

	public void setPayEndDateCalMode(String aPayEndDateCalMode)
	{
		payEndDateCalMode = aPayEndDateCalMode;
	}

	public int getGetYear()
	{
		return getYear;
	}

	public void setGetYear(int aGetYear)
	{
		getYear = aGetYear;
	}

	public void setGetYear(String aGetYear)
	{
		if (aGetYear != null && !aGetYear.equals(""))
		{
			Integer tInteger = new Integer(aGetYear);
			int i = tInteger.intValue();
			getYear = i;
		}
	}

	public String getGetYearFlag()
	{
		return getYearFlag;
	}

	public void setGetYearFlag(String aGetYearFlag)
	{
		getYearFlag = aGetYearFlag;
	}

	public int getInsuYear()
	{
		return insuYear;
	}

	public void setInsuYear(int aInsuYear)
	{
		insuYear = aInsuYear;
	}

	public void setInsuYear(String aInsuYear)
	{
		if (aInsuYear != null && !aInsuYear.equals(""))
		{
			Integer tInteger = new Integer(aInsuYear);
			int i = tInteger.intValue();
			insuYear = i;
		}
	}

	public String getInsuYearFlag()
	{
		return insuYearFlag;
	}

	public void setInsuYearFlag(String aInsuYearFlag)
	{
		insuYearFlag = aInsuYearFlag;
	}

	public int getAcciYear()
	{
		return acciYear;
	}

	public void setAcciYear(int aAcciYear)
	{
		acciYear = aAcciYear;
	}

	public void setAcciYear(String aAcciYear)
	{
		if (aAcciYear != null && !aAcciYear.equals(""))
		{
			Integer tInteger = new Integer(aAcciYear);
			int i = tInteger.intValue();
			acciYear = i;
		}
	}

	public String getAcciYearFlag()
	{
		return acciYearFlag;
	}

	public void setAcciYearFlag(String aAcciYearFlag)
	{
		acciYearFlag = aAcciYearFlag;
	}

	public String getCalMode()
	{
		return calMode;
	}

	public void setCalMode(String aCalMode)
	{
		calMode = aCalMode;
	}

	public String getPayEndYearRela()
	{
		return payEndYearRela;
	}

	public void setPayEndYearRela(String aPayEndYearRela)
	{
		payEndYearRela = aPayEndYearRela;
	}

	public String getGetYearRela()
	{
		return getYearRela;
	}

	public void setGetYearRela(String aGetYearRela)
	{
		getYearRela = aGetYearRela;
	}

	public String getInsuYearRela()
	{
		return insuYearRela;
	}

	public void setInsuYearRela(String aInsuYearRela)
	{
		insuYearRela = aInsuYearRela;
	}

	public String getBasicCalCode()
	{
		return basicCalCode;
	}

	public void setBasicCalCode(String aBasicCalCode)
	{
		basicCalCode = aBasicCalCode;
	}

	public String getRiskCalCode()
	{
		return riskCalCode;
	}

	public void setRiskCalCode(String aRiskCalCode)
	{
		riskCalCode = aRiskCalCode;
	}

	public String getAmntFlag()
	{
		return amntFlag;
	}

	public void setAmntFlag(String aAmntFlag)
	{
		amntFlag = aAmntFlag;
	}

	public double getVPU()
	{
		return vPU;
	}

	public void setVPU(double aVPU)
	{
		vPU = aVPU;
	}

	public void setVPU(String aVPU)
	{
		if (aVPU != null && !aVPU.equals(""))
		{
			Double tDouble = new Double(aVPU);
			double d = tDouble.doubleValue();
			vPU = d;
		}
	}

	public String getAddFeeFlag()
	{
		return addFeeFlag;
	}

	public void setAddFeeFlag(String aAddFeeFlag)
	{
		addFeeFlag = aAddFeeFlag;
	}

	public String getEndDateCalMode()
	{
		return endDateCalMode;
	}

	public void setEndDateCalMode(String aEndDateCalMode)
	{
		endDateCalMode = aEndDateCalMode;
	}

	public void setSchema(LNPDutySchema aLNPDutySchema)
	{
		dutyCode = aLNPDutySchema.getDutyCode();
		dutyName = aLNPDutySchema.getDutyName();
		payEndYear = aLNPDutySchema.getPayEndYear();
		payEndYearFlag = aLNPDutySchema.getPayEndYearFlag();
		payEndDateCalRef = aLNPDutySchema.getPayEndDateCalRef();
		payEndDateCalMode = aLNPDutySchema.getPayEndDateCalMode();
		getYear = aLNPDutySchema.getGetYear();
		getYearFlag = aLNPDutySchema.getGetYearFlag();
		insuYear = aLNPDutySchema.getInsuYear();
		insuYearFlag = aLNPDutySchema.getInsuYearFlag();
		acciYear = aLNPDutySchema.getAcciYear();
		acciYearFlag = aLNPDutySchema.getAcciYearFlag();
		calMode = aLNPDutySchema.getCalMode();
		payEndYearRela = aLNPDutySchema.getPayEndYearRela();
		getYearRela = aLNPDutySchema.getGetYearRela();
		insuYearRela = aLNPDutySchema.getInsuYearRela();
		basicCalCode = aLNPDutySchema.getBasicCalCode();
		riskCalCode = aLNPDutySchema.getRiskCalCode();
		amntFlag = aLNPDutySchema.getAmntFlag();
		vPU = aLNPDutySchema.getVPU();
		addFeeFlag = aLNPDutySchema.getAddFeeFlag();
		endDateCalMode = aLNPDutySchema.getEndDateCalMode();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("DutyCode") == null)
				dutyCode = null;
			else
				dutyCode = rs.getString("DutyCode").trim();
			if (rs.getString("DutyName") == null)
				dutyName = null;
			else
				dutyName = rs.getString("DutyName").trim();
			payEndYear = rs.getInt("PayEndYear");
			if (rs.getString("PayEndYearFlag") == null)
				payEndYearFlag = null;
			else
				payEndYearFlag = rs.getString("PayEndYearFlag").trim();
			if (rs.getString("PayEndDateCalRef") == null)
				payEndDateCalRef = null;
			else
				payEndDateCalRef = rs.getString("PayEndDateCalRef").trim();
			if (rs.getString("PayEndDateCalMode") == null)
				payEndDateCalMode = null;
			else
				payEndDateCalMode = rs.getString("PayEndDateCalMode").trim();
			getYear = rs.getInt("GetYear");
			if (rs.getString("GetYearFlag") == null)
				getYearFlag = null;
			else
				getYearFlag = rs.getString("GetYearFlag").trim();
			insuYear = rs.getInt("InsuYear");
			if (rs.getString("InsuYearFlag") == null)
				insuYearFlag = null;
			else
				insuYearFlag = rs.getString("InsuYearFlag").trim();
			acciYear = rs.getInt("AcciYear");
			if (rs.getString("AcciYearFlag") == null)
				acciYearFlag = null;
			else
				acciYearFlag = rs.getString("AcciYearFlag").trim();
			if (rs.getString("CalMode") == null)
				calMode = null;
			else
				calMode = rs.getString("CalMode").trim();
			if (rs.getString("PayEndYearRela") == null)
				payEndYearRela = null;
			else
				payEndYearRela = rs.getString("PayEndYearRela").trim();
			if (rs.getString("GetYearRela") == null)
				getYearRela = null;
			else
				getYearRela = rs.getString("GetYearRela").trim();
			if (rs.getString("InsuYearRela") == null)
				insuYearRela = null;
			else
				insuYearRela = rs.getString("InsuYearRela").trim();
			if (rs.getString("BasicCalCode") == null)
				basicCalCode = null;
			else
				basicCalCode = rs.getString("BasicCalCode").trim();
			if (rs.getString("RiskCalCode") == null)
				riskCalCode = null;
			else
				riskCalCode = rs.getString("RiskCalCode").trim();
			if (rs.getString("AmntFlag") == null)
				amntFlag = null;
			else
				amntFlag = rs.getString("AmntFlag").trim();
			vPU = rs.getDouble("VPU");
			if (rs.getString("AddFeeFlag") == null)
				addFeeFlag = null;
			else
				addFeeFlag = rs.getString("AddFeeFlag").trim();
			if (rs.getString("EndDateCalMode") == null)
				endDateCalMode = null;
			else
				endDateCalMode = rs.getString("EndDateCalMode").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPDuty���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPDutySchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPDutySchema getSchema()
	{
		LNPDutySchema aLNPDutySchema = new LNPDutySchema();
		aLNPDutySchema.setSchema(this);
		return aLNPDutySchema;
	}

	public LNPDutyDB getDB()
	{
		LNPDutyDB aDBOper = new LNPDutyDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(dutyCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(dutyName));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(payEndYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payEndYearFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payEndDateCalRef));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payEndDateCalMode));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(getYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getYearFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(insuYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuYearFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(acciYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(acciYearFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(calMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payEndYearRela));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getYearRela));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(insuYearRela));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(basicCalCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskCalCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(amntFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(vPU));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(addFeeFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(endDateCalMode));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			dutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			dutyName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			payEndYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 3, "|")))).intValue();
			payEndYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			payEndDateCalRef = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			payEndDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			getYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).intValue();
			getYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			insuYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).intValue();
			insuYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			acciYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).intValue();
			acciYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			calMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			payEndYearRela = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			getYearRela = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			insuYearRela = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			basicCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			riskCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			amntFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			vPU = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|")))).doubleValue();
			addFeeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			endDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPDutySchema";
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
		if (FCode.equalsIgnoreCase("dutyCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dutyCode));
		if (FCode.equalsIgnoreCase("dutyName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dutyName));
		if (FCode.equalsIgnoreCase("payEndYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndYear));
		if (FCode.equalsIgnoreCase("payEndYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndYearFlag));
		if (FCode.equalsIgnoreCase("payEndDateCalRef"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndDateCalRef));
		if (FCode.equalsIgnoreCase("payEndDateCalMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndDateCalMode));
		if (FCode.equalsIgnoreCase("getYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getYear));
		if (FCode.equalsIgnoreCase("getYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getYearFlag));
		if (FCode.equalsIgnoreCase("insuYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuYear));
		if (FCode.equalsIgnoreCase("insuYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuYearFlag));
		if (FCode.equalsIgnoreCase("acciYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(acciYear));
		if (FCode.equalsIgnoreCase("acciYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(acciYearFlag));
		if (FCode.equalsIgnoreCase("calMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(calMode));
		if (FCode.equalsIgnoreCase("payEndYearRela"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndYearRela));
		if (FCode.equalsIgnoreCase("getYearRela"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getYearRela));
		if (FCode.equalsIgnoreCase("insuYearRela"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(insuYearRela));
		if (FCode.equalsIgnoreCase("basicCalCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(basicCalCode));
		if (FCode.equalsIgnoreCase("riskCalCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCalCode));
		if (FCode.equalsIgnoreCase("amntFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(amntFlag));
		if (FCode.equalsIgnoreCase("vPU"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vPU));
		if (FCode.equalsIgnoreCase("addFeeFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addFeeFlag));
		if (FCode.equalsIgnoreCase("endDateCalMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(endDateCalMode));
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
			strFieldValue = StrTool.GBKToUnicode(dutyCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(dutyName);
			break;

		case 2: // '\002'
			strFieldValue = String.valueOf(payEndYear);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(payEndYearFlag);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(payEndDateCalRef);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(payEndDateCalMode);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(getYear);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(getYearFlag);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(insuYear);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(insuYearFlag);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(acciYear);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(acciYearFlag);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(calMode);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(payEndYearRela);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(getYearRela);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(insuYearRela);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(basicCalCode);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(riskCalCode);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(amntFlag);
			break;

		case 19: // '\023'
			strFieldValue = String.valueOf(vPU);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(addFeeFlag);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(endDateCalMode);
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
		if (FCode.equalsIgnoreCase("dutyCode"))
			if (FValue != null && !FValue.equals(""))
				dutyCode = FValue.trim();
			else
				dutyCode = null;
		if (FCode.equalsIgnoreCase("dutyName"))
			if (FValue != null && !FValue.equals(""))
				dutyName = FValue.trim();
			else
				dutyName = null;
		if (FCode.equalsIgnoreCase("payEndYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payEndYear = i;
		}
		if (FCode.equalsIgnoreCase("payEndYearFlag"))
			if (FValue != null && !FValue.equals(""))
				payEndYearFlag = FValue.trim();
			else
				payEndYearFlag = null;
		if (FCode.equalsIgnoreCase("payEndDateCalRef"))
			if (FValue != null && !FValue.equals(""))
				payEndDateCalRef = FValue.trim();
			else
				payEndDateCalRef = null;
		if (FCode.equalsIgnoreCase("payEndDateCalMode"))
			if (FValue != null && !FValue.equals(""))
				payEndDateCalMode = FValue.trim();
			else
				payEndDateCalMode = null;
		if (FCode.equalsIgnoreCase("getYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			getYear = i;
		}
		if (FCode.equalsIgnoreCase("getYearFlag"))
			if (FValue != null && !FValue.equals(""))
				getYearFlag = FValue.trim();
			else
				getYearFlag = null;
		if (FCode.equalsIgnoreCase("insuYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			insuYear = i;
		}
		if (FCode.equalsIgnoreCase("insuYearFlag"))
			if (FValue != null && !FValue.equals(""))
				insuYearFlag = FValue.trim();
			else
				insuYearFlag = null;
		if (FCode.equalsIgnoreCase("acciYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			acciYear = i;
		}
		if (FCode.equalsIgnoreCase("acciYearFlag"))
			if (FValue != null && !FValue.equals(""))
				acciYearFlag = FValue.trim();
			else
				acciYearFlag = null;
		if (FCode.equalsIgnoreCase("calMode"))
			if (FValue != null && !FValue.equals(""))
				calMode = FValue.trim();
			else
				calMode = null;
		if (FCode.equalsIgnoreCase("payEndYearRela"))
			if (FValue != null && !FValue.equals(""))
				payEndYearRela = FValue.trim();
			else
				payEndYearRela = null;
		if (FCode.equalsIgnoreCase("getYearRela"))
			if (FValue != null && !FValue.equals(""))
				getYearRela = FValue.trim();
			else
				getYearRela = null;
		if (FCode.equalsIgnoreCase("insuYearRela"))
			if (FValue != null && !FValue.equals(""))
				insuYearRela = FValue.trim();
			else
				insuYearRela = null;
		if (FCode.equalsIgnoreCase("basicCalCode"))
			if (FValue != null && !FValue.equals(""))
				basicCalCode = FValue.trim();
			else
				basicCalCode = null;
		if (FCode.equalsIgnoreCase("riskCalCode"))
			if (FValue != null && !FValue.equals(""))
				riskCalCode = FValue.trim();
			else
				riskCalCode = null;
		if (FCode.equalsIgnoreCase("amntFlag"))
			if (FValue != null && !FValue.equals(""))
				amntFlag = FValue.trim();
			else
				amntFlag = null;
		if (FCode.equalsIgnoreCase("vPU") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			vPU = d;
		}
		if (FCode.equalsIgnoreCase("addFeeFlag"))
			if (FValue != null && !FValue.equals(""))
				addFeeFlag = FValue.trim();
			else
				addFeeFlag = null;
		if (FCode.equalsIgnoreCase("endDateCalMode"))
			if (FValue != null && !FValue.equals(""))
				endDateCalMode = FValue.trim();
			else
				endDateCalMode = null;
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
		LNPDutySchema other = (LNPDutySchema)otherObject;
		if (dutyCode == null && other.getDutyCode() != null)
			return false;
		if (dutyCode != null && !dutyCode.equals(other.getDutyCode()))
			return false;
		if (dutyName == null && other.getDutyName() != null)
			return false;
		if (dutyName != null && !dutyName.equals(other.getDutyName()))
			return false;
		if (payEndYear != other.getPayEndYear())
			return false;
		if (payEndYearFlag == null && other.getPayEndYearFlag() != null)
			return false;
		if (payEndYearFlag != null && !payEndYearFlag.equals(other.getPayEndYearFlag()))
			return false;
		if (payEndDateCalRef == null && other.getPayEndDateCalRef() != null)
			return false;
		if (payEndDateCalRef != null && !payEndDateCalRef.equals(other.getPayEndDateCalRef()))
			return false;
		if (payEndDateCalMode == null && other.getPayEndDateCalMode() != null)
			return false;
		if (payEndDateCalMode != null && !payEndDateCalMode.equals(other.getPayEndDateCalMode()))
			return false;
		if (getYear != other.getGetYear())
			return false;
		if (getYearFlag == null && other.getGetYearFlag() != null)
			return false;
		if (getYearFlag != null && !getYearFlag.equals(other.getGetYearFlag()))
			return false;
		if (insuYear != other.getInsuYear())
			return false;
		if (insuYearFlag == null && other.getInsuYearFlag() != null)
			return false;
		if (insuYearFlag != null && !insuYearFlag.equals(other.getInsuYearFlag()))
			return false;
		if (acciYear != other.getAcciYear())
			return false;
		if (acciYearFlag == null && other.getAcciYearFlag() != null)
			return false;
		if (acciYearFlag != null && !acciYearFlag.equals(other.getAcciYearFlag()))
			return false;
		if (calMode == null && other.getCalMode() != null)
			return false;
		if (calMode != null && !calMode.equals(other.getCalMode()))
			return false;
		if (payEndYearRela == null && other.getPayEndYearRela() != null)
			return false;
		if (payEndYearRela != null && !payEndYearRela.equals(other.getPayEndYearRela()))
			return false;
		if (getYearRela == null && other.getGetYearRela() != null)
			return false;
		if (getYearRela != null && !getYearRela.equals(other.getGetYearRela()))
			return false;
		if (insuYearRela == null && other.getInsuYearRela() != null)
			return false;
		if (insuYearRela != null && !insuYearRela.equals(other.getInsuYearRela()))
			return false;
		if (basicCalCode == null && other.getBasicCalCode() != null)
			return false;
		if (basicCalCode != null && !basicCalCode.equals(other.getBasicCalCode()))
			return false;
		if (riskCalCode == null && other.getRiskCalCode() != null)
			return false;
		if (riskCalCode != null && !riskCalCode.equals(other.getRiskCalCode()))
			return false;
		if (amntFlag == null && other.getAmntFlag() != null)
			return false;
		if (amntFlag != null && !amntFlag.equals(other.getAmntFlag()))
			return false;
		if (Double.doubleToLongBits(vPU) != Double.doubleToLongBits(other.getVPU()))
			return false;
		if (addFeeFlag == null && other.getAddFeeFlag() != null)
			return false;
		if (addFeeFlag != null && !addFeeFlag.equals(other.getAddFeeFlag()))
			return false;
		if (endDateCalMode == null && other.getEndDateCalMode() != null)
			return false;
		return endDateCalMode == null || endDateCalMode.equals(other.getEndDateCalMode());
	}

	public int getFieldCount()
	{
		return 22;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("dutyCode"))
			return 0;
		if (strFieldName.equals("dutyName"))
			return 1;
		if (strFieldName.equals("payEndYear"))
			return 2;
		if (strFieldName.equals("payEndYearFlag"))
			return 3;
		if (strFieldName.equals("payEndDateCalRef"))
			return 4;
		if (strFieldName.equals("payEndDateCalMode"))
			return 5;
		if (strFieldName.equals("getYear"))
			return 6;
		if (strFieldName.equals("getYearFlag"))
			return 7;
		if (strFieldName.equals("insuYear"))
			return 8;
		if (strFieldName.equals("insuYearFlag"))
			return 9;
		if (strFieldName.equals("acciYear"))
			return 10;
		if (strFieldName.equals("acciYearFlag"))
			return 11;
		if (strFieldName.equals("calMode"))
			return 12;
		if (strFieldName.equals("payEndYearRela"))
			return 13;
		if (strFieldName.equals("getYearRela"))
			return 14;
		if (strFieldName.equals("insuYearRela"))
			return 15;
		if (strFieldName.equals("basicCalCode"))
			return 16;
		if (strFieldName.equals("riskCalCode"))
			return 17;
		if (strFieldName.equals("amntFlag"))
			return 18;
		if (strFieldName.equals("vPU"))
			return 19;
		if (strFieldName.equals("addFeeFlag"))
			return 20;
		return !strFieldName.equals("endDateCalMode") ? -1 : 21;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "dutyCode";
			break;

		case 1: // '\001'
			strFieldName = "dutyName";
			break;

		case 2: // '\002'
			strFieldName = "payEndYear";
			break;

		case 3: // '\003'
			strFieldName = "payEndYearFlag";
			break;

		case 4: // '\004'
			strFieldName = "payEndDateCalRef";
			break;

		case 5: // '\005'
			strFieldName = "payEndDateCalMode";
			break;

		case 6: // '\006'
			strFieldName = "getYear";
			break;

		case 7: // '\007'
			strFieldName = "getYearFlag";
			break;

		case 8: // '\b'
			strFieldName = "insuYear";
			break;

		case 9: // '\t'
			strFieldName = "insuYearFlag";
			break;

		case 10: // '\n'
			strFieldName = "acciYear";
			break;

		case 11: // '\013'
			strFieldName = "acciYearFlag";
			break;

		case 12: // '\f'
			strFieldName = "calMode";
			break;

		case 13: // '\r'
			strFieldName = "payEndYearRela";
			break;

		case 14: // '\016'
			strFieldName = "getYearRela";
			break;

		case 15: // '\017'
			strFieldName = "insuYearRela";
			break;

		case 16: // '\020'
			strFieldName = "basicCalCode";
			break;

		case 17: // '\021'
			strFieldName = "riskCalCode";
			break;

		case 18: // '\022'
			strFieldName = "amntFlag";
			break;

		case 19: // '\023'
			strFieldName = "vPU";
			break;

		case 20: // '\024'
			strFieldName = "addFeeFlag";
			break;

		case 21: // '\025'
			strFieldName = "endDateCalMode";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("dutyCode"))
			return 0;
		if (strFieldName.equals("dutyName"))
			return 0;
		if (strFieldName.equals("payEndYear"))
			return 3;
		if (strFieldName.equals("payEndYearFlag"))
			return 0;
		if (strFieldName.equals("payEndDateCalRef"))
			return 0;
		if (strFieldName.equals("payEndDateCalMode"))
			return 0;
		if (strFieldName.equals("getYear"))
			return 3;
		if (strFieldName.equals("getYearFlag"))
			return 0;
		if (strFieldName.equals("insuYear"))
			return 3;
		if (strFieldName.equals("insuYearFlag"))
			return 0;
		if (strFieldName.equals("acciYear"))
			return 3;
		if (strFieldName.equals("acciYearFlag"))
			return 0;
		if (strFieldName.equals("calMode"))
			return 0;
		if (strFieldName.equals("payEndYearRela"))
			return 0;
		if (strFieldName.equals("getYearRela"))
			return 0;
		if (strFieldName.equals("insuYearRela"))
			return 0;
		if (strFieldName.equals("basicCalCode"))
			return 0;
		if (strFieldName.equals("riskCalCode"))
			return 0;
		if (strFieldName.equals("amntFlag"))
			return 0;
		if (strFieldName.equals("vPU"))
			return 4;
		if (strFieldName.equals("addFeeFlag"))
			return 0;
		return !strFieldName.equals("endDateCalMode") ? -1 : 0;
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
			nFieldType = 3;
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

		case 9: // '\t'
			nFieldType = 0;
			break;

		case 10: // '\n'
			nFieldType = 3;
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
			nFieldType = 0;
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

		case 18: // '\022'
			nFieldType = 0;
			break;

		case 19: // '\023'
			nFieldType = 4;
			break;

		case 20: // '\024'
			nFieldType = 0;
			break;

		case 21: // '\025'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
