// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyPaySchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPDutyPayDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPDutyPaySchema
	implements Schema, Cloneable
{

	private String payPlanCode;
	private String payPlanName;
	private String type;
	private int payIntv;
	private String payEndYearFlag;
	private int payEndYear;
	private String payEndDateCalRef;
	private String payEndDateCalMode;
	private double defaultVal;
	private String calCode;
	private String cnterCalCode;
	private String othCalCode;
	private double rate;
	private double minPay;
	private double assuYield;
	private double feeRate;
	private String payToDateCalMode;
	private String urgePayFlag;
	private String payLackFlag;
	private String payOverFlag;
	private String payOverDeal;
	private String avoidPayFlag;
	private int gracePeriod;
	private String pubFlag;
	private String zeroFlag;
	private String needAcc;
	private String payAimClass;
	public static final int FIELDNUM = 27;
	private static String PK[];
	public CErrors mErrors;

	public LNPDutyPaySchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "PayPlanCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPDutyPaySchema cloned = (LNPDutyPaySchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getPayPlanCode()
	{
		return payPlanCode;
	}

	public void setPayPlanCode(String aPayPlanCode)
	{
		payPlanCode = aPayPlanCode;
	}

	public String getPayPlanName()
	{
		return payPlanName;
	}

	public void setPayPlanName(String aPayPlanName)
	{
		payPlanName = aPayPlanName;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
	}

	public int getPayIntv()
	{
		return payIntv;
	}

	public void setPayIntv(int aPayIntv)
	{
		payIntv = aPayIntv;
	}

	public void setPayIntv(String aPayIntv)
	{
		if (aPayIntv != null && !aPayIntv.equals(""))
		{
			Integer tInteger = new Integer(aPayIntv);
			int i = tInteger.intValue();
			payIntv = i;
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

	public double getDefaultVal()
	{
		return defaultVal;
	}

	public void setDefaultVal(double aDefaultVal)
	{
		defaultVal = aDefaultVal;
	}

	public void setDefaultVal(String aDefaultVal)
	{
		if (aDefaultVal != null && !aDefaultVal.equals(""))
		{
			Double tDouble = new Double(aDefaultVal);
			double d = tDouble.doubleValue();
			defaultVal = d;
		}
	}

	public String getCalCode()
	{
		return calCode;
	}

	public void setCalCode(String aCalCode)
	{
		calCode = aCalCode;
	}

	public String getCnterCalCode()
	{
		return cnterCalCode;
	}

	public void setCnterCalCode(String aCnterCalCode)
	{
		cnterCalCode = aCnterCalCode;
	}

	public String getOthCalCode()
	{
		return othCalCode;
	}

	public void setOthCalCode(String aOthCalCode)
	{
		othCalCode = aOthCalCode;
	}

	public double getRate()
	{
		return rate;
	}

	public void setRate(double aRate)
	{
		rate = aRate;
	}

	public void setRate(String aRate)
	{
		if (aRate != null && !aRate.equals(""))
		{
			Double tDouble = new Double(aRate);
			double d = tDouble.doubleValue();
			rate = d;
		}
	}

	public double getMinPay()
	{
		return minPay;
	}

	public void setMinPay(double aMinPay)
	{
		minPay = aMinPay;
	}

	public void setMinPay(String aMinPay)
	{
		if (aMinPay != null && !aMinPay.equals(""))
		{
			Double tDouble = new Double(aMinPay);
			double d = tDouble.doubleValue();
			minPay = d;
		}
	}

	public double getAssuYield()
	{
		return assuYield;
	}

	public void setAssuYield(double aAssuYield)
	{
		assuYield = aAssuYield;
	}

	public void setAssuYield(String aAssuYield)
	{
		if (aAssuYield != null && !aAssuYield.equals(""))
		{
			Double tDouble = new Double(aAssuYield);
			double d = tDouble.doubleValue();
			assuYield = d;
		}
	}

	public double getFeeRate()
	{
		return feeRate;
	}

	public void setFeeRate(double aFeeRate)
	{
		feeRate = aFeeRate;
	}

	public void setFeeRate(String aFeeRate)
	{
		if (aFeeRate != null && !aFeeRate.equals(""))
		{
			Double tDouble = new Double(aFeeRate);
			double d = tDouble.doubleValue();
			feeRate = d;
		}
	}

	public String getPayToDateCalMode()
	{
		return payToDateCalMode;
	}

	public void setPayToDateCalMode(String aPayToDateCalMode)
	{
		payToDateCalMode = aPayToDateCalMode;
	}

	public String getUrgePayFlag()
	{
		return urgePayFlag;
	}

	public void setUrgePayFlag(String aUrgePayFlag)
	{
		urgePayFlag = aUrgePayFlag;
	}

	public String getPayLackFlag()
	{
		return payLackFlag;
	}

	public void setPayLackFlag(String aPayLackFlag)
	{
		payLackFlag = aPayLackFlag;
	}

	public String getPayOverFlag()
	{
		return payOverFlag;
	}

	public void setPayOverFlag(String aPayOverFlag)
	{
		payOverFlag = aPayOverFlag;
	}

	public String getPayOverDeal()
	{
		return payOverDeal;
	}

	public void setPayOverDeal(String aPayOverDeal)
	{
		payOverDeal = aPayOverDeal;
	}

	public String getAvoidPayFlag()
	{
		return avoidPayFlag;
	}

	public void setAvoidPayFlag(String aAvoidPayFlag)
	{
		avoidPayFlag = aAvoidPayFlag;
	}

	public int getGracePeriod()
	{
		return gracePeriod;
	}

	public void setGracePeriod(int aGracePeriod)
	{
		gracePeriod = aGracePeriod;
	}

	public void setGracePeriod(String aGracePeriod)
	{
		if (aGracePeriod != null && !aGracePeriod.equals(""))
		{
			Integer tInteger = new Integer(aGracePeriod);
			int i = tInteger.intValue();
			gracePeriod = i;
		}
	}

	public String getPubFlag()
	{
		return pubFlag;
	}

	public void setPubFlag(String aPubFlag)
	{
		pubFlag = aPubFlag;
	}

	public String getZeroFlag()
	{
		return zeroFlag;
	}

	public void setZeroFlag(String aZeroFlag)
	{
		zeroFlag = aZeroFlag;
	}

	public String getNeedAcc()
	{
		return needAcc;
	}

	public void setNeedAcc(String aNeedAcc)
	{
		needAcc = aNeedAcc;
	}

	public String getPayAimClass()
	{
		return payAimClass;
	}

	public void setPayAimClass(String aPayAimClass)
	{
		payAimClass = aPayAimClass;
	}

	public void setSchema(LNPDutyPaySchema aLNPDutyPaySchema)
	{
		payPlanCode = aLNPDutyPaySchema.getPayPlanCode();
		payPlanName = aLNPDutyPaySchema.getPayPlanName();
		type = aLNPDutyPaySchema.getType();
		payIntv = aLNPDutyPaySchema.getPayIntv();
		payEndYearFlag = aLNPDutyPaySchema.getPayEndYearFlag();
		payEndYear = aLNPDutyPaySchema.getPayEndYear();
		payEndDateCalRef = aLNPDutyPaySchema.getPayEndDateCalRef();
		payEndDateCalMode = aLNPDutyPaySchema.getPayEndDateCalMode();
		defaultVal = aLNPDutyPaySchema.getDefaultVal();
		calCode = aLNPDutyPaySchema.getCalCode();
		cnterCalCode = aLNPDutyPaySchema.getCnterCalCode();
		othCalCode = aLNPDutyPaySchema.getOthCalCode();
		rate = aLNPDutyPaySchema.getRate();
		minPay = aLNPDutyPaySchema.getMinPay();
		assuYield = aLNPDutyPaySchema.getAssuYield();
		feeRate = aLNPDutyPaySchema.getFeeRate();
		payToDateCalMode = aLNPDutyPaySchema.getPayToDateCalMode();
		urgePayFlag = aLNPDutyPaySchema.getUrgePayFlag();
		payLackFlag = aLNPDutyPaySchema.getPayLackFlag();
		payOverFlag = aLNPDutyPaySchema.getPayOverFlag();
		payOverDeal = aLNPDutyPaySchema.getPayOverDeal();
		avoidPayFlag = aLNPDutyPaySchema.getAvoidPayFlag();
		gracePeriod = aLNPDutyPaySchema.getGracePeriod();
		pubFlag = aLNPDutyPaySchema.getPubFlag();
		zeroFlag = aLNPDutyPaySchema.getZeroFlag();
		needAcc = aLNPDutyPaySchema.getNeedAcc();
		payAimClass = aLNPDutyPaySchema.getPayAimClass();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("PayPlanCode") == null)
				payPlanCode = null;
			else
				payPlanCode = rs.getString("PayPlanCode").trim();
			if (rs.getString("PayPlanName") == null)
				payPlanName = null;
			else
				payPlanName = rs.getString("PayPlanName").trim();
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
			payIntv = rs.getInt("PayIntv");
			if (rs.getString("PayEndYearFlag") == null)
				payEndYearFlag = null;
			else
				payEndYearFlag = rs.getString("PayEndYearFlag").trim();
			payEndYear = rs.getInt("PayEndYear");
			if (rs.getString("PayEndDateCalRef") == null)
				payEndDateCalRef = null;
			else
				payEndDateCalRef = rs.getString("PayEndDateCalRef").trim();
			if (rs.getString("PayEndDateCalMode") == null)
				payEndDateCalMode = null;
			else
				payEndDateCalMode = rs.getString("PayEndDateCalMode").trim();
			defaultVal = rs.getDouble("DefaultVal");
			if (rs.getString("CalCode") == null)
				calCode = null;
			else
				calCode = rs.getString("CalCode").trim();
			if (rs.getString("CnterCalCode") == null)
				cnterCalCode = null;
			else
				cnterCalCode = rs.getString("CnterCalCode").trim();
			if (rs.getString("OthCalCode") == null)
				othCalCode = null;
			else
				othCalCode = rs.getString("OthCalCode").trim();
			rate = rs.getDouble("Rate");
			minPay = rs.getDouble("MinPay");
			assuYield = rs.getDouble("AssuYield");
			feeRate = rs.getDouble("FeeRate");
			if (rs.getString("PayToDateCalMode") == null)
				payToDateCalMode = null;
			else
				payToDateCalMode = rs.getString("PayToDateCalMode").trim();
			if (rs.getString("UrgePayFlag") == null)
				urgePayFlag = null;
			else
				urgePayFlag = rs.getString("UrgePayFlag").trim();
			if (rs.getString("PayLackFlag") == null)
				payLackFlag = null;
			else
				payLackFlag = rs.getString("PayLackFlag").trim();
			if (rs.getString("PayOverFlag") == null)
				payOverFlag = null;
			else
				payOverFlag = rs.getString("PayOverFlag").trim();
			if (rs.getString("PayOverDeal") == null)
				payOverDeal = null;
			else
				payOverDeal = rs.getString("PayOverDeal").trim();
			if (rs.getString("AvoidPayFlag") == null)
				avoidPayFlag = null;
			else
				avoidPayFlag = rs.getString("AvoidPayFlag").trim();
			gracePeriod = rs.getInt("GracePeriod");
			if (rs.getString("PubFlag") == null)
				pubFlag = null;
			else
				pubFlag = rs.getString("PubFlag").trim();
			if (rs.getString("ZeroFlag") == null)
				zeroFlag = null;
			else
				zeroFlag = rs.getString("ZeroFlag").trim();
			if (rs.getString("NeedAcc") == null)
				needAcc = null;
			else
				needAcc = rs.getString("NeedAcc").trim();
			if (rs.getString("PayAimClass") == null)
				payAimClass = null;
			else
				payAimClass = rs.getString("PayAimClass").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPDutyPay表字段个数和Schema中的字段个数不一致，或�?�执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPDutyPaySchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPDutyPaySchema getSchema()
	{
		LNPDutyPaySchema aLNPDutyPaySchema = new LNPDutyPaySchema();
		aLNPDutyPaySchema.setSchema(this);
		return aLNPDutyPaySchema;
	}

	public LNPDutyPayDB getDB()
	{
		LNPDutyPayDB aDBOper = new LNPDutyPayDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(payPlanCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payPlanName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(type));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(payIntv));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payEndYearFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(payEndYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payEndDateCalRef));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payEndDateCalMode));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(defaultVal));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(calCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(cnterCalCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(othCalCode));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(rate));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(minPay));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(assuYield));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(feeRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payToDateCalMode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(urgePayFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payLackFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payOverFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payOverDeal));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(avoidPayFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(gracePeriod));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(pubFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(zeroFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(needAcc));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(payAimClass));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			payPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			payPlanName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			payIntv = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|")))).intValue();
			payEndYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			payEndYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).intValue();
			payEndDateCalRef = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			payEndDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			defaultVal = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).doubleValue();
			calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			cnterCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			othCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			rate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|")))).doubleValue();
			minPay = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|")))).doubleValue();
			assuYield = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|")))).doubleValue();
			feeRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|")))).doubleValue();
			payToDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			urgePayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			payLackFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			payOverFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			payOverDeal = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			avoidPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			gracePeriod = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|")))).intValue();
			pubFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			zeroFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			needAcc = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			payAimClass = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPDutyPaySchema";
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
		if (FCode.equalsIgnoreCase("payPlanCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payPlanCode));
		if (FCode.equalsIgnoreCase("payPlanName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payPlanName));
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
		if (FCode.equalsIgnoreCase("payIntv"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payIntv));
		if (FCode.equalsIgnoreCase("payEndYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndYearFlag));
		if (FCode.equalsIgnoreCase("payEndYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndYear));
		if (FCode.equalsIgnoreCase("payEndDateCalRef"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndDateCalRef));
		if (FCode.equalsIgnoreCase("payEndDateCalMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payEndDateCalMode));
		if (FCode.equalsIgnoreCase("defaultVal"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(defaultVal));
		if (FCode.equalsIgnoreCase("calCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(calCode));
		if (FCode.equalsIgnoreCase("cnterCalCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(cnterCalCode));
		if (FCode.equalsIgnoreCase("othCalCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(othCalCode));
		if (FCode.equalsIgnoreCase("rate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rate));
		if (FCode.equalsIgnoreCase("minPay"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(minPay));
		if (FCode.equalsIgnoreCase("assuYield"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(assuYield));
		if (FCode.equalsIgnoreCase("feeRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(feeRate));
		if (FCode.equalsIgnoreCase("payToDateCalMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payToDateCalMode));
		if (FCode.equalsIgnoreCase("urgePayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(urgePayFlag));
		if (FCode.equalsIgnoreCase("payLackFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payLackFlag));
		if (FCode.equalsIgnoreCase("payOverFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payOverFlag));
		if (FCode.equalsIgnoreCase("payOverDeal"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payOverDeal));
		if (FCode.equalsIgnoreCase("avoidPayFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(avoidPayFlag));
		if (FCode.equalsIgnoreCase("gracePeriod"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(gracePeriod));
		if (FCode.equalsIgnoreCase("pubFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pubFlag));
		if (FCode.equalsIgnoreCase("zeroFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(zeroFlag));
		if (FCode.equalsIgnoreCase("needAcc"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(needAcc));
		if (FCode.equalsIgnoreCase("payAimClass"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(payAimClass));
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
			strFieldValue = StrTool.GBKToUnicode(payPlanCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(payPlanName);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 3: // '\003'
			strFieldValue = String.valueOf(payIntv);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(payEndYearFlag);
			break;

		case 5: // '\005'
			strFieldValue = String.valueOf(payEndYear);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(payEndDateCalRef);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(payEndDateCalMode);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(defaultVal);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(calCode);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(cnterCalCode);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(othCalCode);
			break;

		case 12: // '\f'
			strFieldValue = String.valueOf(rate);
			break;

		case 13: // '\r'
			strFieldValue = String.valueOf(minPay);
			break;

		case 14: // '\016'
			strFieldValue = String.valueOf(assuYield);
			break;

		case 15: // '\017'
			strFieldValue = String.valueOf(feeRate);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(payToDateCalMode);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(urgePayFlag);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(payLackFlag);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(payOverFlag);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(payOverDeal);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(avoidPayFlag);
			break;

		case 22: // '\026'
			strFieldValue = String.valueOf(gracePeriod);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(pubFlag);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(zeroFlag);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(needAcc);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(payAimClass);
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
		if (FCode.equalsIgnoreCase("payPlanCode"))
			if (FValue != null && !FValue.equals(""))
				payPlanCode = FValue.trim();
			else
				payPlanCode = null;
		if (FCode.equalsIgnoreCase("payPlanName"))
			if (FValue != null && !FValue.equals(""))
				payPlanName = FValue.trim();
			else
				payPlanName = null;
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
		if (FCode.equalsIgnoreCase("payIntv") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payIntv = i;
		}
		if (FCode.equalsIgnoreCase("payEndYearFlag"))
			if (FValue != null && !FValue.equals(""))
				payEndYearFlag = FValue.trim();
			else
				payEndYearFlag = null;
		if (FCode.equalsIgnoreCase("payEndYear") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			payEndYear = i;
		}
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
		if (FCode.equalsIgnoreCase("defaultVal") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			defaultVal = d;
		}
		if (FCode.equalsIgnoreCase("calCode"))
			if (FValue != null && !FValue.equals(""))
				calCode = FValue.trim();
			else
				calCode = null;
		if (FCode.equalsIgnoreCase("cnterCalCode"))
			if (FValue != null && !FValue.equals(""))
				cnterCalCode = FValue.trim();
			else
				cnterCalCode = null;
		if (FCode.equalsIgnoreCase("othCalCode"))
			if (FValue != null && !FValue.equals(""))
				othCalCode = FValue.trim();
			else
				othCalCode = null;
		if (FCode.equalsIgnoreCase("rate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			rate = d;
		}
		if (FCode.equalsIgnoreCase("minPay") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			minPay = d;
		}
		if (FCode.equalsIgnoreCase("assuYield") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			assuYield = d;
		}
		if (FCode.equalsIgnoreCase("feeRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			feeRate = d;
		}
		if (FCode.equalsIgnoreCase("payToDateCalMode"))
			if (FValue != null && !FValue.equals(""))
				payToDateCalMode = FValue.trim();
			else
				payToDateCalMode = null;
		if (FCode.equalsIgnoreCase("urgePayFlag"))
			if (FValue != null && !FValue.equals(""))
				urgePayFlag = FValue.trim();
			else
				urgePayFlag = null;
		if (FCode.equalsIgnoreCase("payLackFlag"))
			if (FValue != null && !FValue.equals(""))
				payLackFlag = FValue.trim();
			else
				payLackFlag = null;
		if (FCode.equalsIgnoreCase("payOverFlag"))
			if (FValue != null && !FValue.equals(""))
				payOverFlag = FValue.trim();
			else
				payOverFlag = null;
		if (FCode.equalsIgnoreCase("payOverDeal"))
			if (FValue != null && !FValue.equals(""))
				payOverDeal = FValue.trim();
			else
				payOverDeal = null;
		if (FCode.equalsIgnoreCase("avoidPayFlag"))
			if (FValue != null && !FValue.equals(""))
				avoidPayFlag = FValue.trim();
			else
				avoidPayFlag = null;
		if (FCode.equalsIgnoreCase("gracePeriod") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			gracePeriod = i;
		}
		if (FCode.equalsIgnoreCase("pubFlag"))
			if (FValue != null && !FValue.equals(""))
				pubFlag = FValue.trim();
			else
				pubFlag = null;
		if (FCode.equalsIgnoreCase("zeroFlag"))
			if (FValue != null && !FValue.equals(""))
				zeroFlag = FValue.trim();
			else
				zeroFlag = null;
		if (FCode.equalsIgnoreCase("needAcc"))
			if (FValue != null && !FValue.equals(""))
				needAcc = FValue.trim();
			else
				needAcc = null;
		if (FCode.equalsIgnoreCase("payAimClass"))
			if (FValue != null && !FValue.equals(""))
				payAimClass = FValue.trim();
			else
				payAimClass = null;
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
		LNPDutyPaySchema other = (LNPDutyPaySchema)otherObject;
		if (payPlanCode == null && other.getPayPlanCode() != null)
			return false;
		if (payPlanCode != null && !payPlanCode.equals(other.getPayPlanCode()))
			return false;
		if (payPlanName == null && other.getPayPlanName() != null)
			return false;
		if (payPlanName != null && !payPlanName.equals(other.getPayPlanName()))
			return false;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
			return false;
		if (payIntv != other.getPayIntv())
			return false;
		if (payEndYearFlag == null && other.getPayEndYearFlag() != null)
			return false;
		if (payEndYearFlag != null && !payEndYearFlag.equals(other.getPayEndYearFlag()))
			return false;
		if (payEndYear != other.getPayEndYear())
			return false;
		if (payEndDateCalRef == null && other.getPayEndDateCalRef() != null)
			return false;
		if (payEndDateCalRef != null && !payEndDateCalRef.equals(other.getPayEndDateCalRef()))
			return false;
		if (payEndDateCalMode == null && other.getPayEndDateCalMode() != null)
			return false;
		if (payEndDateCalMode != null && !payEndDateCalMode.equals(other.getPayEndDateCalMode()))
			return false;
		if (Double.doubleToLongBits(defaultVal) != Double.doubleToLongBits(other.getDefaultVal()))
			return false;
		if (calCode == null && other.getCalCode() != null)
			return false;
		if (calCode != null && !calCode.equals(other.getCalCode()))
			return false;
		if (cnterCalCode == null && other.getCnterCalCode() != null)
			return false;
		if (cnterCalCode != null && !cnterCalCode.equals(other.getCnterCalCode()))
			return false;
		if (othCalCode == null && other.getOthCalCode() != null)
			return false;
		if (othCalCode != null && !othCalCode.equals(other.getOthCalCode()))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.getRate()))
			return false;
		if (Double.doubleToLongBits(minPay) != Double.doubleToLongBits(other.getMinPay()))
			return false;
		if (Double.doubleToLongBits(assuYield) != Double.doubleToLongBits(other.getAssuYield()))
			return false;
		if (Double.doubleToLongBits(feeRate) != Double.doubleToLongBits(other.getFeeRate()))
			return false;
		if (payToDateCalMode == null && other.getPayToDateCalMode() != null)
			return false;
		if (payToDateCalMode != null && !payToDateCalMode.equals(other.getPayToDateCalMode()))
			return false;
		if (urgePayFlag == null && other.getUrgePayFlag() != null)
			return false;
		if (urgePayFlag != null && !urgePayFlag.equals(other.getUrgePayFlag()))
			return false;
		if (payLackFlag == null && other.getPayLackFlag() != null)
			return false;
		if (payLackFlag != null && !payLackFlag.equals(other.getPayLackFlag()))
			return false;
		if (payOverFlag == null && other.getPayOverFlag() != null)
			return false;
		if (payOverFlag != null && !payOverFlag.equals(other.getPayOverFlag()))
			return false;
		if (payOverDeal == null && other.getPayOverDeal() != null)
			return false;
		if (payOverDeal != null && !payOverDeal.equals(other.getPayOverDeal()))
			return false;
		if (avoidPayFlag == null && other.getAvoidPayFlag() != null)
			return false;
		if (avoidPayFlag != null && !avoidPayFlag.equals(other.getAvoidPayFlag()))
			return false;
		if (gracePeriod != other.getGracePeriod())
			return false;
		if (pubFlag == null && other.getPubFlag() != null)
			return false;
		if (pubFlag != null && !pubFlag.equals(other.getPubFlag()))
			return false;
		if (zeroFlag == null && other.getZeroFlag() != null)
			return false;
		if (zeroFlag != null && !zeroFlag.equals(other.getZeroFlag()))
			return false;
		if (needAcc == null && other.getNeedAcc() != null)
			return false;
		if (needAcc != null && !needAcc.equals(other.getNeedAcc()))
			return false;
		if (payAimClass == null && other.getPayAimClass() != null)
			return false;
		return payAimClass == null || payAimClass.equals(other.getPayAimClass());
	}

	public int getFieldCount()
	{
		return 27;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("payPlanCode"))
			return 0;
		if (strFieldName.equals("payPlanName"))
			return 1;
		if (strFieldName.equals("type"))
			return 2;
		if (strFieldName.equals("payIntv"))
			return 3;
		if (strFieldName.equals("payEndYearFlag"))
			return 4;
		if (strFieldName.equals("payEndYear"))
			return 5;
		if (strFieldName.equals("payEndDateCalRef"))
			return 6;
		if (strFieldName.equals("payEndDateCalMode"))
			return 7;
		if (strFieldName.equals("defaultVal"))
			return 8;
		if (strFieldName.equals("calCode"))
			return 9;
		if (strFieldName.equals("cnterCalCode"))
			return 10;
		if (strFieldName.equals("othCalCode"))
			return 11;
		if (strFieldName.equals("rate"))
			return 12;
		if (strFieldName.equals("minPay"))
			return 13;
		if (strFieldName.equals("assuYield"))
			return 14;
		if (strFieldName.equals("feeRate"))
			return 15;
		if (strFieldName.equals("payToDateCalMode"))
			return 16;
		if (strFieldName.equals("urgePayFlag"))
			return 17;
		if (strFieldName.equals("payLackFlag"))
			return 18;
		if (strFieldName.equals("payOverFlag"))
			return 19;
		if (strFieldName.equals("payOverDeal"))
			return 20;
		if (strFieldName.equals("avoidPayFlag"))
			return 21;
		if (strFieldName.equals("gracePeriod"))
			return 22;
		if (strFieldName.equals("pubFlag"))
			return 23;
		if (strFieldName.equals("zeroFlag"))
			return 24;
		if (strFieldName.equals("needAcc"))
			return 25;
		return !strFieldName.equals("payAimClass") ? -1 : 26;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "payPlanCode";
			break;

		case 1: // '\001'
			strFieldName = "payPlanName";
			break;

		case 2: // '\002'
			strFieldName = "type";
			break;

		case 3: // '\003'
			strFieldName = "payIntv";
			break;

		case 4: // '\004'
			strFieldName = "payEndYearFlag";
			break;

		case 5: // '\005'
			strFieldName = "payEndYear";
			break;

		case 6: // '\006'
			strFieldName = "payEndDateCalRef";
			break;

		case 7: // '\007'
			strFieldName = "payEndDateCalMode";
			break;

		case 8: // '\b'
			strFieldName = "defaultVal";
			break;

		case 9: // '\t'
			strFieldName = "calCode";
			break;

		case 10: // '\n'
			strFieldName = "cnterCalCode";
			break;

		case 11: // '\013'
			strFieldName = "othCalCode";
			break;

		case 12: // '\f'
			strFieldName = "rate";
			break;

		case 13: // '\r'
			strFieldName = "minPay";
			break;

		case 14: // '\016'
			strFieldName = "assuYield";
			break;

		case 15: // '\017'
			strFieldName = "feeRate";
			break;

		case 16: // '\020'
			strFieldName = "payToDateCalMode";
			break;

		case 17: // '\021'
			strFieldName = "urgePayFlag";
			break;

		case 18: // '\022'
			strFieldName = "payLackFlag";
			break;

		case 19: // '\023'
			strFieldName = "payOverFlag";
			break;

		case 20: // '\024'
			strFieldName = "payOverDeal";
			break;

		case 21: // '\025'
			strFieldName = "avoidPayFlag";
			break;

		case 22: // '\026'
			strFieldName = "gracePeriod";
			break;

		case 23: // '\027'
			strFieldName = "pubFlag";
			break;

		case 24: // '\030'
			strFieldName = "zeroFlag";
			break;

		case 25: // '\031'
			strFieldName = "needAcc";
			break;

		case 26: // '\032'
			strFieldName = "payAimClass";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("payPlanCode"))
			return 0;
		if (strFieldName.equals("payPlanName"))
			return 0;
		if (strFieldName.equals("type"))
			return 0;
		if (strFieldName.equals("payIntv"))
			return 3;
		if (strFieldName.equals("payEndYearFlag"))
			return 0;
		if (strFieldName.equals("payEndYear"))
			return 3;
		if (strFieldName.equals("payEndDateCalRef"))
			return 0;
		if (strFieldName.equals("payEndDateCalMode"))
			return 0;
		if (strFieldName.equals("defaultVal"))
			return 4;
		if (strFieldName.equals("calCode"))
			return 0;
		if (strFieldName.equals("cnterCalCode"))
			return 0;
		if (strFieldName.equals("othCalCode"))
			return 0;
		if (strFieldName.equals("rate"))
			return 4;
		if (strFieldName.equals("minPay"))
			return 4;
		if (strFieldName.equals("assuYield"))
			return 4;
		if (strFieldName.equals("feeRate"))
			return 4;
		if (strFieldName.equals("payToDateCalMode"))
			return 0;
		if (strFieldName.equals("urgePayFlag"))
			return 0;
		if (strFieldName.equals("payLackFlag"))
			return 0;
		if (strFieldName.equals("payOverFlag"))
			return 0;
		if (strFieldName.equals("payOverDeal"))
			return 0;
		if (strFieldName.equals("avoidPayFlag"))
			return 0;
		if (strFieldName.equals("gracePeriod"))
			return 3;
		if (strFieldName.equals("pubFlag"))
			return 0;
		if (strFieldName.equals("zeroFlag"))
			return 0;
		if (strFieldName.equals("needAcc"))
			return 0;
		return !strFieldName.equals("payAimClass") ? -1 : 0;
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
			nFieldType = 3;
			break;

		case 4: // '\004'
			nFieldType = 0;
			break;

		case 5: // '\005'
			nFieldType = 3;
			break;

		case 6: // '\006'
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 4;
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
			nFieldType = 4;
			break;

		case 13: // '\r'
			nFieldType = 4;
			break;

		case 14: // '\016'
			nFieldType = 4;
			break;

		case 15: // '\017'
			nFieldType = 4;
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
			nFieldType = 0;
			break;

		case 20: // '\024'
			nFieldType = 0;
			break;

		case 21: // '\025'
			nFieldType = 0;
			break;

		case 22: // '\026'
			nFieldType = 3;
			break;

		case 23: // '\027'
			nFieldType = 0;
			break;

		case 24: // '\030'
			nFieldType = 0;
			break;

		case 25: // '\031'
			nFieldType = 0;
			break;

		case 26: // '\032'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
