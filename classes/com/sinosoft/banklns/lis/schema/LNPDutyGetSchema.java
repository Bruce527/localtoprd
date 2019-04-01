// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyGetSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPDutyGetDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPDutyGetSchema
	implements Schema, Cloneable
{

	private String getDutyCode;
	private String getDutyName;
	private String type;
	private int getIntv;
	private double defaultVal;
	private String calCode;
	private String cnterCalCode;
	private String othCalCode;
	private int getYear;
	private String getYearFlag;
	private String startDateCalRef;
	private String startDateCalMode;
	private int minGetStartPeriod;
	private int getEndPeriod;
	private String getEndUnit;
	private String endDateCalRef;
	private String endDateCalMode;
	private int maxGetEndPeriod;
	private String addFlag;
	private String sexRelaFlag;
	private String unitAppRelaFlag;
	private String addAmntFlag;
	private String discntFlag;
	private String interestFlag;
	private String shareFlag;
	private String inpFlag;
	private String bnfFlag;
	private String urgeGetFlag;
	private String deadValiFlag;
	private String getInitFlag;
	private double getLimit;
	private double maxGet;
	private double getRate;
	private String needAcc;
	private String canGet;
	private String needCancelAcc;
	private String getType1;
	private String zeroFlag;
	private String getType2;
	public static final int FIELDNUM = 39;
	private static String PK[];
	public CErrors mErrors;

	public LNPDutyGetSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "GetDutyCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPDutyGetSchema cloned = (LNPDutyGetSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getGetDutyCode()
	{
		return getDutyCode;
	}

	public void setGetDutyCode(String aGetDutyCode)
	{
		getDutyCode = aGetDutyCode;
	}

	public String getGetDutyName()
	{
		return getDutyName;
	}

	public void setGetDutyName(String aGetDutyName)
	{
		getDutyName = aGetDutyName;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
	}

	public int getGetIntv()
	{
		return getIntv;
	}

	public void setGetIntv(int aGetIntv)
	{
		getIntv = aGetIntv;
	}

	public void setGetIntv(String aGetIntv)
	{
		if (aGetIntv != null && !aGetIntv.equals(""))
		{
			Integer tInteger = new Integer(aGetIntv);
			int i = tInteger.intValue();
			getIntv = i;
		}
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

	public String getStartDateCalRef()
	{
		return startDateCalRef;
	}

	public void setStartDateCalRef(String aStartDateCalRef)
	{
		startDateCalRef = aStartDateCalRef;
	}

	public String getStartDateCalMode()
	{
		return startDateCalMode;
	}

	public void setStartDateCalMode(String aStartDateCalMode)
	{
		startDateCalMode = aStartDateCalMode;
	}

	public int getMinGetStartPeriod()
	{
		return minGetStartPeriod;
	}

	public void setMinGetStartPeriod(int aMinGetStartPeriod)
	{
		minGetStartPeriod = aMinGetStartPeriod;
	}

	public void setMinGetStartPeriod(String aMinGetStartPeriod)
	{
		if (aMinGetStartPeriod != null && !aMinGetStartPeriod.equals(""))
		{
			Integer tInteger = new Integer(aMinGetStartPeriod);
			int i = tInteger.intValue();
			minGetStartPeriod = i;
		}
	}

	public int getGetEndPeriod()
	{
		return getEndPeriod;
	}

	public void setGetEndPeriod(int aGetEndPeriod)
	{
		getEndPeriod = aGetEndPeriod;
	}

	public void setGetEndPeriod(String aGetEndPeriod)
	{
		if (aGetEndPeriod != null && !aGetEndPeriod.equals(""))
		{
			Integer tInteger = new Integer(aGetEndPeriod);
			int i = tInteger.intValue();
			getEndPeriod = i;
		}
	}

	public String getGetEndUnit()
	{
		return getEndUnit;
	}

	public void setGetEndUnit(String aGetEndUnit)
	{
		getEndUnit = aGetEndUnit;
	}

	public String getEndDateCalRef()
	{
		return endDateCalRef;
	}

	public void setEndDateCalRef(String aEndDateCalRef)
	{
		endDateCalRef = aEndDateCalRef;
	}

	public String getEndDateCalMode()
	{
		return endDateCalMode;
	}

	public void setEndDateCalMode(String aEndDateCalMode)
	{
		endDateCalMode = aEndDateCalMode;
	}

	public int getMaxGetEndPeriod()
	{
		return maxGetEndPeriod;
	}

	public void setMaxGetEndPeriod(int aMaxGetEndPeriod)
	{
		maxGetEndPeriod = aMaxGetEndPeriod;
	}

	public void setMaxGetEndPeriod(String aMaxGetEndPeriod)
	{
		if (aMaxGetEndPeriod != null && !aMaxGetEndPeriod.equals(""))
		{
			Integer tInteger = new Integer(aMaxGetEndPeriod);
			int i = tInteger.intValue();
			maxGetEndPeriod = i;
		}
	}

	public String getAddFlag()
	{
		return addFlag;
	}

	public void setAddFlag(String aAddFlag)
	{
		addFlag = aAddFlag;
	}

	public String getSexRelaFlag()
	{
		return sexRelaFlag;
	}

	public void setSexRelaFlag(String aSexRelaFlag)
	{
		sexRelaFlag = aSexRelaFlag;
	}

	public String getUnitAppRelaFlag()
	{
		return unitAppRelaFlag;
	}

	public void setUnitAppRelaFlag(String aUnitAppRelaFlag)
	{
		unitAppRelaFlag = aUnitAppRelaFlag;
	}

	public String getAddAmntFlag()
	{
		return addAmntFlag;
	}

	public void setAddAmntFlag(String aAddAmntFlag)
	{
		addAmntFlag = aAddAmntFlag;
	}

	public String getDiscntFlag()
	{
		return discntFlag;
	}

	public void setDiscntFlag(String aDiscntFlag)
	{
		discntFlag = aDiscntFlag;
	}

	public String getInterestFlag()
	{
		return interestFlag;
	}

	public void setInterestFlag(String aInterestFlag)
	{
		interestFlag = aInterestFlag;
	}

	public String getShareFlag()
	{
		return shareFlag;
	}

	public void setShareFlag(String aShareFlag)
	{
		shareFlag = aShareFlag;
	}

	public String getInpFlag()
	{
		return inpFlag;
	}

	public void setInpFlag(String aInpFlag)
	{
		inpFlag = aInpFlag;
	}

	public String getBnfFlag()
	{
		return bnfFlag;
	}

	public void setBnfFlag(String aBnfFlag)
	{
		bnfFlag = aBnfFlag;
	}

	public String getUrgeGetFlag()
	{
		return urgeGetFlag;
	}

	public void setUrgeGetFlag(String aUrgeGetFlag)
	{
		urgeGetFlag = aUrgeGetFlag;
	}

	public String getDeadValiFlag()
	{
		return deadValiFlag;
	}

	public void setDeadValiFlag(String aDeadValiFlag)
	{
		deadValiFlag = aDeadValiFlag;
	}

	public String getGetInitFlag()
	{
		return getInitFlag;
	}

	public void setGetInitFlag(String aGetInitFlag)
	{
		getInitFlag = aGetInitFlag;
	}

	public double getGetLimit()
	{
		return getLimit;
	}

	public void setGetLimit(double aGetLimit)
	{
		getLimit = aGetLimit;
	}

	public void setGetLimit(String aGetLimit)
	{
		if (aGetLimit != null && !aGetLimit.equals(""))
		{
			Double tDouble = new Double(aGetLimit);
			double d = tDouble.doubleValue();
			getLimit = d;
		}
	}

	public double getMaxGet()
	{
		return maxGet;
	}

	public void setMaxGet(double aMaxGet)
	{
		maxGet = aMaxGet;
	}

	public void setMaxGet(String aMaxGet)
	{
		if (aMaxGet != null && !aMaxGet.equals(""))
		{
			Double tDouble = new Double(aMaxGet);
			double d = tDouble.doubleValue();
			maxGet = d;
		}
	}

	public double getGetRate()
	{
		return getRate;
	}

	public void setGetRate(double aGetRate)
	{
		getRate = aGetRate;
	}

	public void setGetRate(String aGetRate)
	{
		if (aGetRate != null && !aGetRate.equals(""))
		{
			Double tDouble = new Double(aGetRate);
			double d = tDouble.doubleValue();
			getRate = d;
		}
	}

	public String getNeedAcc()
	{
		return needAcc;
	}

	public void setNeedAcc(String aNeedAcc)
	{
		needAcc = aNeedAcc;
	}

	public String getCanGet()
	{
		return canGet;
	}

	public void setCanGet(String aCanGet)
	{
		canGet = aCanGet;
	}

	public String getNeedCancelAcc()
	{
		return needCancelAcc;
	}

	public void setNeedCancelAcc(String aNeedCancelAcc)
	{
		needCancelAcc = aNeedCancelAcc;
	}

	public String getGetType1()
	{
		return getType1;
	}

	public void setGetType1(String aGetType1)
	{
		getType1 = aGetType1;
	}

	public String getZeroFlag()
	{
		return zeroFlag;
	}

	public void setZeroFlag(String aZeroFlag)
	{
		zeroFlag = aZeroFlag;
	}

	public String getGetType2()
	{
		return getType2;
	}

	public void setGetType2(String aGetType2)
	{
		getType2 = aGetType2;
	}

	public void setSchema(LNPDutyGetSchema aLNPDutyGetSchema)
	{
		getDutyCode = aLNPDutyGetSchema.getGetDutyCode();
		getDutyName = aLNPDutyGetSchema.getGetDutyName();
		type = aLNPDutyGetSchema.getType();
		getIntv = aLNPDutyGetSchema.getGetIntv();
		defaultVal = aLNPDutyGetSchema.getDefaultVal();
		calCode = aLNPDutyGetSchema.getCalCode();
		cnterCalCode = aLNPDutyGetSchema.getCnterCalCode();
		othCalCode = aLNPDutyGetSchema.getOthCalCode();
		getYear = aLNPDutyGetSchema.getGetYear();
		getYearFlag = aLNPDutyGetSchema.getGetYearFlag();
		startDateCalRef = aLNPDutyGetSchema.getStartDateCalRef();
		startDateCalMode = aLNPDutyGetSchema.getStartDateCalMode();
		minGetStartPeriod = aLNPDutyGetSchema.getMinGetStartPeriod();
		getEndPeriod = aLNPDutyGetSchema.getGetEndPeriod();
		getEndUnit = aLNPDutyGetSchema.getGetEndUnit();
		endDateCalRef = aLNPDutyGetSchema.getEndDateCalRef();
		endDateCalMode = aLNPDutyGetSchema.getEndDateCalMode();
		maxGetEndPeriod = aLNPDutyGetSchema.getMaxGetEndPeriod();
		addFlag = aLNPDutyGetSchema.getAddFlag();
		sexRelaFlag = aLNPDutyGetSchema.getSexRelaFlag();
		unitAppRelaFlag = aLNPDutyGetSchema.getUnitAppRelaFlag();
		addAmntFlag = aLNPDutyGetSchema.getAddAmntFlag();
		discntFlag = aLNPDutyGetSchema.getDiscntFlag();
		interestFlag = aLNPDutyGetSchema.getInterestFlag();
		shareFlag = aLNPDutyGetSchema.getShareFlag();
		inpFlag = aLNPDutyGetSchema.getInpFlag();
		bnfFlag = aLNPDutyGetSchema.getBnfFlag();
		urgeGetFlag = aLNPDutyGetSchema.getUrgeGetFlag();
		deadValiFlag = aLNPDutyGetSchema.getDeadValiFlag();
		getInitFlag = aLNPDutyGetSchema.getGetInitFlag();
		getLimit = aLNPDutyGetSchema.getGetLimit();
		maxGet = aLNPDutyGetSchema.getMaxGet();
		getRate = aLNPDutyGetSchema.getGetRate();
		needAcc = aLNPDutyGetSchema.getNeedAcc();
		canGet = aLNPDutyGetSchema.getCanGet();
		needCancelAcc = aLNPDutyGetSchema.getNeedCancelAcc();
		getType1 = aLNPDutyGetSchema.getGetType1();
		zeroFlag = aLNPDutyGetSchema.getZeroFlag();
		getType2 = aLNPDutyGetSchema.getGetType2();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("GetDutyCode") == null)
				getDutyCode = null;
			else
				getDutyCode = rs.getString("GetDutyCode").trim();
			if (rs.getString("GetDutyName") == null)
				getDutyName = null;
			else
				getDutyName = rs.getString("GetDutyName").trim();
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
			getIntv = rs.getInt("GetIntv");
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
			getYear = rs.getInt("GetYear");
			if (rs.getString("GetYearFlag") == null)
				getYearFlag = null;
			else
				getYearFlag = rs.getString("GetYearFlag").trim();
			if (rs.getString("StartDateCalRef") == null)
				startDateCalRef = null;
			else
				startDateCalRef = rs.getString("StartDateCalRef").trim();
			if (rs.getString("StartDateCalMode") == null)
				startDateCalMode = null;
			else
				startDateCalMode = rs.getString("StartDateCalMode").trim();
			minGetStartPeriod = rs.getInt("MinGetStartPeriod");
			getEndPeriod = rs.getInt("GetEndPeriod");
			if (rs.getString("GetEndUnit") == null)
				getEndUnit = null;
			else
				getEndUnit = rs.getString("GetEndUnit").trim();
			if (rs.getString("EndDateCalRef") == null)
				endDateCalRef = null;
			else
				endDateCalRef = rs.getString("EndDateCalRef").trim();
			if (rs.getString("EndDateCalMode") == null)
				endDateCalMode = null;
			else
				endDateCalMode = rs.getString("EndDateCalMode").trim();
			maxGetEndPeriod = rs.getInt("MaxGetEndPeriod");
			if (rs.getString("AddFlag") == null)
				addFlag = null;
			else
				addFlag = rs.getString("AddFlag").trim();
			if (rs.getString("SexRelaFlag") == null)
				sexRelaFlag = null;
			else
				sexRelaFlag = rs.getString("SexRelaFlag").trim();
			if (rs.getString("UnitAppRelaFlag") == null)
				unitAppRelaFlag = null;
			else
				unitAppRelaFlag = rs.getString("UnitAppRelaFlag").trim();
			if (rs.getString("AddAmntFlag") == null)
				addAmntFlag = null;
			else
				addAmntFlag = rs.getString("AddAmntFlag").trim();
			if (rs.getString("DiscntFlag") == null)
				discntFlag = null;
			else
				discntFlag = rs.getString("DiscntFlag").trim();
			if (rs.getString("InterestFlag") == null)
				interestFlag = null;
			else
				interestFlag = rs.getString("InterestFlag").trim();
			if (rs.getString("ShareFlag") == null)
				shareFlag = null;
			else
				shareFlag = rs.getString("ShareFlag").trim();
			if (rs.getString("InpFlag") == null)
				inpFlag = null;
			else
				inpFlag = rs.getString("InpFlag").trim();
			if (rs.getString("BnfFlag") == null)
				bnfFlag = null;
			else
				bnfFlag = rs.getString("BnfFlag").trim();
			if (rs.getString("UrgeGetFlag") == null)
				urgeGetFlag = null;
			else
				urgeGetFlag = rs.getString("UrgeGetFlag").trim();
			if (rs.getString("DeadValiFlag") == null)
				deadValiFlag = null;
			else
				deadValiFlag = rs.getString("DeadValiFlag").trim();
			if (rs.getString("GetInitFlag") == null)
				getInitFlag = null;
			else
				getInitFlag = rs.getString("GetInitFlag").trim();
			getLimit = rs.getDouble("GetLimit");
			maxGet = rs.getDouble("MaxGet");
			getRate = rs.getDouble("GetRate");
			if (rs.getString("NeedAcc") == null)
				needAcc = null;
			else
				needAcc = rs.getString("NeedAcc").trim();
			if (rs.getString("CanGet") == null)
				canGet = null;
			else
				canGet = rs.getString("CanGet").trim();
			if (rs.getString("NeedCancelAcc") == null)
				needCancelAcc = null;
			else
				needCancelAcc = rs.getString("NeedCancelAcc").trim();
			if (rs.getString("GetType1") == null)
				getType1 = null;
			else
				getType1 = rs.getString("GetType1").trim();
			if (rs.getString("ZeroFlag") == null)
				zeroFlag = null;
			else
				zeroFlag = rs.getString("ZeroFlag").trim();
			if (rs.getString("GetType2") == null)
				getType2 = null;
			else
				getType2 = rs.getString("GetType2").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPDutyGet表字段个数和Schema中的字段个数不一致，或�?�执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPDutyGetSchema getSchema()
	{
		LNPDutyGetSchema aLNPDutyGetSchema = new LNPDutyGetSchema();
		aLNPDutyGetSchema.setSchema(this);
		return aLNPDutyGetSchema;
	}

	public LNPDutyGetDB getDB()
	{
		LNPDutyGetDB aDBOper = new LNPDutyGetDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(getDutyCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getDutyName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(type));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(getIntv));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(defaultVal));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(calCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(cnterCalCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(othCalCode));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(getYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getYearFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(startDateCalRef));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(startDateCalMode));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(minGetStartPeriod));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(getEndPeriod));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getEndUnit));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(endDateCalRef));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(endDateCalMode));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(maxGetEndPeriod));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(addFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sexRelaFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(unitAppRelaFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(addAmntFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(discntFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(interestFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(shareFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(inpFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bnfFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(urgeGetFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(deadValiFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getInitFlag));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(getLimit));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(maxGet));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(getRate));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(needAcc));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(canGet));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(needCancelAcc));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getType1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(zeroFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(getType2));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			getDutyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			getDutyName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			getIntv = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|")))).intValue();
			defaultVal = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|")))).doubleValue();
			calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			cnterCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			othCalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			getYear = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).intValue();
			getYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			startDateCalRef = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			startDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			minGetStartPeriod = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|")))).intValue();
			getEndPeriod = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|")))).intValue();
			getEndUnit = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			endDateCalRef = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			endDateCalMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			maxGetEndPeriod = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|")))).intValue();
			addFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			sexRelaFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			unitAppRelaFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			addAmntFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			discntFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			interestFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			shareFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			inpFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			bnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			urgeGetFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			deadValiFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			getInitFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			getLimit = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|")))).doubleValue();
			maxGet = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|")))).doubleValue();
			getRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|")))).doubleValue();
			needAcc = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			canGet = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			needCancelAcc = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
			getType1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			zeroFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			getType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetSchema";
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
		if (FCode.equalsIgnoreCase("getDutyCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDutyCode));
		if (FCode.equalsIgnoreCase("getDutyName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDutyName));
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
		if (FCode.equalsIgnoreCase("getIntv"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getIntv));
		if (FCode.equalsIgnoreCase("defaultVal"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(defaultVal));
		if (FCode.equalsIgnoreCase("calCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(calCode));
		if (FCode.equalsIgnoreCase("cnterCalCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(cnterCalCode));
		if (FCode.equalsIgnoreCase("othCalCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(othCalCode));
		if (FCode.equalsIgnoreCase("getYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getYear));
		if (FCode.equalsIgnoreCase("getYearFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getYearFlag));
		if (FCode.equalsIgnoreCase("startDateCalRef"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(startDateCalRef));
		if (FCode.equalsIgnoreCase("startDateCalMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(startDateCalMode));
		if (FCode.equalsIgnoreCase("minGetStartPeriod"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(minGetStartPeriod));
		if (FCode.equalsIgnoreCase("getEndPeriod"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndPeriod));
		if (FCode.equalsIgnoreCase("getEndUnit"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndUnit));
		if (FCode.equalsIgnoreCase("endDateCalRef"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(endDateCalRef));
		if (FCode.equalsIgnoreCase("endDateCalMode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(endDateCalMode));
		if (FCode.equalsIgnoreCase("maxGetEndPeriod"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(maxGetEndPeriod));
		if (FCode.equalsIgnoreCase("addFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addFlag));
		if (FCode.equalsIgnoreCase("sexRelaFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sexRelaFlag));
		if (FCode.equalsIgnoreCase("unitAppRelaFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(unitAppRelaFlag));
		if (FCode.equalsIgnoreCase("addAmntFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(addAmntFlag));
		if (FCode.equalsIgnoreCase("discntFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(discntFlag));
		if (FCode.equalsIgnoreCase("interestFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(interestFlag));
		if (FCode.equalsIgnoreCase("shareFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(shareFlag));
		if (FCode.equalsIgnoreCase("inpFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(inpFlag));
		if (FCode.equalsIgnoreCase("bnfFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bnfFlag));
		if (FCode.equalsIgnoreCase("urgeGetFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(urgeGetFlag));
		if (FCode.equalsIgnoreCase("deadValiFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(deadValiFlag));
		if (FCode.equalsIgnoreCase("getInitFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getInitFlag));
		if (FCode.equalsIgnoreCase("getLimit"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getLimit));
		if (FCode.equalsIgnoreCase("maxGet"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(maxGet));
		if (FCode.equalsIgnoreCase("getRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getRate));
		if (FCode.equalsIgnoreCase("needAcc"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(needAcc));
		if (FCode.equalsIgnoreCase("canGet"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(canGet));
		if (FCode.equalsIgnoreCase("needCancelAcc"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(needCancelAcc));
		if (FCode.equalsIgnoreCase("getType1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getType1));
		if (FCode.equalsIgnoreCase("zeroFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(zeroFlag));
		if (FCode.equalsIgnoreCase("getType2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getType2));
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
			strFieldValue = StrTool.GBKToUnicode(getDutyCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(getDutyName);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 3: // '\003'
			strFieldValue = String.valueOf(getIntv);
			break;

		case 4: // '\004'
			strFieldValue = String.valueOf(defaultVal);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(calCode);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(cnterCalCode);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(othCalCode);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(getYear);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(getYearFlag);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(startDateCalRef);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(startDateCalMode);
			break;

		case 12: // '\f'
			strFieldValue = String.valueOf(minGetStartPeriod);
			break;

		case 13: // '\r'
			strFieldValue = String.valueOf(getEndPeriod);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(getEndUnit);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(endDateCalRef);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(endDateCalMode);
			break;

		case 17: // '\021'
			strFieldValue = String.valueOf(maxGetEndPeriod);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(addFlag);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(sexRelaFlag);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(unitAppRelaFlag);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(addAmntFlag);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(discntFlag);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(interestFlag);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(shareFlag);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(inpFlag);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(bnfFlag);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(urgeGetFlag);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(deadValiFlag);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(getInitFlag);
			break;

		case 30: // '\036'
			strFieldValue = String.valueOf(getLimit);
			break;

		case 31: // '\037'
			strFieldValue = String.valueOf(maxGet);
			break;

		case 32: // ' '
			strFieldValue = String.valueOf(getRate);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(needAcc);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(canGet);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(needCancelAcc);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(getType1);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(zeroFlag);
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(getType2);
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
		if (FCode.equalsIgnoreCase("getDutyCode"))
			if (FValue != null && !FValue.equals(""))
				getDutyCode = FValue.trim();
			else
				getDutyCode = null;
		if (FCode.equalsIgnoreCase("getDutyName"))
			if (FValue != null && !FValue.equals(""))
				getDutyName = FValue.trim();
			else
				getDutyName = null;
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
		if (FCode.equalsIgnoreCase("getIntv") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			getIntv = i;
		}
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
		if (FCode.equalsIgnoreCase("startDateCalRef"))
			if (FValue != null && !FValue.equals(""))
				startDateCalRef = FValue.trim();
			else
				startDateCalRef = null;
		if (FCode.equalsIgnoreCase("startDateCalMode"))
			if (FValue != null && !FValue.equals(""))
				startDateCalMode = FValue.trim();
			else
				startDateCalMode = null;
		if (FCode.equalsIgnoreCase("minGetStartPeriod") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			minGetStartPeriod = i;
		}
		if (FCode.equalsIgnoreCase("getEndPeriod") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			getEndPeriod = i;
		}
		if (FCode.equalsIgnoreCase("getEndUnit"))
			if (FValue != null && !FValue.equals(""))
				getEndUnit = FValue.trim();
			else
				getEndUnit = null;
		if (FCode.equalsIgnoreCase("endDateCalRef"))
			if (FValue != null && !FValue.equals(""))
				endDateCalRef = FValue.trim();
			else
				endDateCalRef = null;
		if (FCode.equalsIgnoreCase("endDateCalMode"))
			if (FValue != null && !FValue.equals(""))
				endDateCalMode = FValue.trim();
			else
				endDateCalMode = null;
		if (FCode.equalsIgnoreCase("maxGetEndPeriod") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			maxGetEndPeriod = i;
		}
		if (FCode.equalsIgnoreCase("addFlag"))
			if (FValue != null && !FValue.equals(""))
				addFlag = FValue.trim();
			else
				addFlag = null;
		if (FCode.equalsIgnoreCase("sexRelaFlag"))
			if (FValue != null && !FValue.equals(""))
				sexRelaFlag = FValue.trim();
			else
				sexRelaFlag = null;
		if (FCode.equalsIgnoreCase("unitAppRelaFlag"))
			if (FValue != null && !FValue.equals(""))
				unitAppRelaFlag = FValue.trim();
			else
				unitAppRelaFlag = null;
		if (FCode.equalsIgnoreCase("addAmntFlag"))
			if (FValue != null && !FValue.equals(""))
				addAmntFlag = FValue.trim();
			else
				addAmntFlag = null;
		if (FCode.equalsIgnoreCase("discntFlag"))
			if (FValue != null && !FValue.equals(""))
				discntFlag = FValue.trim();
			else
				discntFlag = null;
		if (FCode.equalsIgnoreCase("interestFlag"))
			if (FValue != null && !FValue.equals(""))
				interestFlag = FValue.trim();
			else
				interestFlag = null;
		if (FCode.equalsIgnoreCase("shareFlag"))
			if (FValue != null && !FValue.equals(""))
				shareFlag = FValue.trim();
			else
				shareFlag = null;
		if (FCode.equalsIgnoreCase("inpFlag"))
			if (FValue != null && !FValue.equals(""))
				inpFlag = FValue.trim();
			else
				inpFlag = null;
		if (FCode.equalsIgnoreCase("bnfFlag"))
			if (FValue != null && !FValue.equals(""))
				bnfFlag = FValue.trim();
			else
				bnfFlag = null;
		if (FCode.equalsIgnoreCase("urgeGetFlag"))
			if (FValue != null && !FValue.equals(""))
				urgeGetFlag = FValue.trim();
			else
				urgeGetFlag = null;
		if (FCode.equalsIgnoreCase("deadValiFlag"))
			if (FValue != null && !FValue.equals(""))
				deadValiFlag = FValue.trim();
			else
				deadValiFlag = null;
		if (FCode.equalsIgnoreCase("getInitFlag"))
			if (FValue != null && !FValue.equals(""))
				getInitFlag = FValue.trim();
			else
				getInitFlag = null;
		if (FCode.equalsIgnoreCase("getLimit") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			getLimit = d;
		}
		if (FCode.equalsIgnoreCase("maxGet") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			maxGet = d;
		}
		if (FCode.equalsIgnoreCase("getRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			getRate = d;
		}
		if (FCode.equalsIgnoreCase("needAcc"))
			if (FValue != null && !FValue.equals(""))
				needAcc = FValue.trim();
			else
				needAcc = null;
		if (FCode.equalsIgnoreCase("canGet"))
			if (FValue != null && !FValue.equals(""))
				canGet = FValue.trim();
			else
				canGet = null;
		if (FCode.equalsIgnoreCase("needCancelAcc"))
			if (FValue != null && !FValue.equals(""))
				needCancelAcc = FValue.trim();
			else
				needCancelAcc = null;
		if (FCode.equalsIgnoreCase("getType1"))
			if (FValue != null && !FValue.equals(""))
				getType1 = FValue.trim();
			else
				getType1 = null;
		if (FCode.equalsIgnoreCase("zeroFlag"))
			if (FValue != null && !FValue.equals(""))
				zeroFlag = FValue.trim();
			else
				zeroFlag = null;
		if (FCode.equalsIgnoreCase("getType2"))
			if (FValue != null && !FValue.equals(""))
				getType2 = FValue.trim();
			else
				getType2 = null;
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
		LNPDutyGetSchema other = (LNPDutyGetSchema)otherObject;
		if (getDutyCode == null && other.getGetDutyCode() != null)
			return false;
		if (getDutyCode != null && !getDutyCode.equals(other.getGetDutyCode()))
			return false;
		if (getDutyName == null && other.getGetDutyName() != null)
			return false;
		if (getDutyName != null && !getDutyName.equals(other.getGetDutyName()))
			return false;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
			return false;
		if (getIntv != other.getGetIntv())
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
		if (getYear != other.getGetYear())
			return false;
		if (getYearFlag == null && other.getGetYearFlag() != null)
			return false;
		if (getYearFlag != null && !getYearFlag.equals(other.getGetYearFlag()))
			return false;
		if (startDateCalRef == null && other.getStartDateCalRef() != null)
			return false;
		if (startDateCalRef != null && !startDateCalRef.equals(other.getStartDateCalRef()))
			return false;
		if (startDateCalMode == null && other.getStartDateCalMode() != null)
			return false;
		if (startDateCalMode != null && !startDateCalMode.equals(other.getStartDateCalMode()))
			return false;
		if (minGetStartPeriod != other.getMinGetStartPeriod())
			return false;
		if (getEndPeriod != other.getGetEndPeriod())
			return false;
		if (getEndUnit == null && other.getGetEndUnit() != null)
			return false;
		if (getEndUnit != null && !getEndUnit.equals(other.getGetEndUnit()))
			return false;
		if (endDateCalRef == null && other.getEndDateCalRef() != null)
			return false;
		if (endDateCalRef != null && !endDateCalRef.equals(other.getEndDateCalRef()))
			return false;
		if (endDateCalMode == null && other.getEndDateCalMode() != null)
			return false;
		if (endDateCalMode != null && !endDateCalMode.equals(other.getEndDateCalMode()))
			return false;
		if (maxGetEndPeriod != other.getMaxGetEndPeriod())
			return false;
		if (addFlag == null && other.getAddFlag() != null)
			return false;
		if (addFlag != null && !addFlag.equals(other.getAddFlag()))
			return false;
		if (sexRelaFlag == null && other.getSexRelaFlag() != null)
			return false;
		if (sexRelaFlag != null && !sexRelaFlag.equals(other.getSexRelaFlag()))
			return false;
		if (unitAppRelaFlag == null && other.getUnitAppRelaFlag() != null)
			return false;
		if (unitAppRelaFlag != null && !unitAppRelaFlag.equals(other.getUnitAppRelaFlag()))
			return false;
		if (addAmntFlag == null && other.getAddAmntFlag() != null)
			return false;
		if (addAmntFlag != null && !addAmntFlag.equals(other.getAddAmntFlag()))
			return false;
		if (discntFlag == null && other.getDiscntFlag() != null)
			return false;
		if (discntFlag != null && !discntFlag.equals(other.getDiscntFlag()))
			return false;
		if (interestFlag == null && other.getInterestFlag() != null)
			return false;
		if (interestFlag != null && !interestFlag.equals(other.getInterestFlag()))
			return false;
		if (shareFlag == null && other.getShareFlag() != null)
			return false;
		if (shareFlag != null && !shareFlag.equals(other.getShareFlag()))
			return false;
		if (inpFlag == null && other.getInpFlag() != null)
			return false;
		if (inpFlag != null && !inpFlag.equals(other.getInpFlag()))
			return false;
		if (bnfFlag == null && other.getBnfFlag() != null)
			return false;
		if (bnfFlag != null && !bnfFlag.equals(other.getBnfFlag()))
			return false;
		if (urgeGetFlag == null && other.getUrgeGetFlag() != null)
			return false;
		if (urgeGetFlag != null && !urgeGetFlag.equals(other.getUrgeGetFlag()))
			return false;
		if (deadValiFlag == null && other.getDeadValiFlag() != null)
			return false;
		if (deadValiFlag != null && !deadValiFlag.equals(other.getDeadValiFlag()))
			return false;
		if (getInitFlag == null && other.getGetInitFlag() != null)
			return false;
		if (getInitFlag != null && !getInitFlag.equals(other.getGetInitFlag()))
			return false;
		if (Double.doubleToLongBits(getLimit) != Double.doubleToLongBits(other.getGetLimit()))
			return false;
		if (Double.doubleToLongBits(maxGet) != Double.doubleToLongBits(other.getMaxGet()))
			return false;
		if (Double.doubleToLongBits(getRate) != Double.doubleToLongBits(other.getGetRate()))
			return false;
		if (needAcc == null && other.getNeedAcc() != null)
			return false;
		if (needAcc != null && !needAcc.equals(other.getNeedAcc()))
			return false;
		if (canGet == null && other.getCanGet() != null)
			return false;
		if (canGet != null && !canGet.equals(other.getCanGet()))
			return false;
		if (needCancelAcc == null && other.getNeedCancelAcc() != null)
			return false;
		if (needCancelAcc != null && !needCancelAcc.equals(other.getNeedCancelAcc()))
			return false;
		if (getType1 == null && other.getGetType1() != null)
			return false;
		if (getType1 != null && !getType1.equals(other.getGetType1()))
			return false;
		if (zeroFlag == null && other.getZeroFlag() != null)
			return false;
		if (zeroFlag != null && !zeroFlag.equals(other.getZeroFlag()))
			return false;
		if (getType2 == null && other.getGetType2() != null)
			return false;
		return getType2 == null || getType2.equals(other.getGetType2());
	}

	public int getFieldCount()
	{
		return 39;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("getDutyCode"))
			return 0;
		if (strFieldName.equals("getDutyName"))
			return 1;
		if (strFieldName.equals("type"))
			return 2;
		if (strFieldName.equals("getIntv"))
			return 3;
		if (strFieldName.equals("defaultVal"))
			return 4;
		if (strFieldName.equals("calCode"))
			return 5;
		if (strFieldName.equals("cnterCalCode"))
			return 6;
		if (strFieldName.equals("othCalCode"))
			return 7;
		if (strFieldName.equals("getYear"))
			return 8;
		if (strFieldName.equals("getYearFlag"))
			return 9;
		if (strFieldName.equals("startDateCalRef"))
			return 10;
		if (strFieldName.equals("startDateCalMode"))
			return 11;
		if (strFieldName.equals("minGetStartPeriod"))
			return 12;
		if (strFieldName.equals("getEndPeriod"))
			return 13;
		if (strFieldName.equals("getEndUnit"))
			return 14;
		if (strFieldName.equals("endDateCalRef"))
			return 15;
		if (strFieldName.equals("endDateCalMode"))
			return 16;
		if (strFieldName.equals("maxGetEndPeriod"))
			return 17;
		if (strFieldName.equals("addFlag"))
			return 18;
		if (strFieldName.equals("sexRelaFlag"))
			return 19;
		if (strFieldName.equals("unitAppRelaFlag"))
			return 20;
		if (strFieldName.equals("addAmntFlag"))
			return 21;
		if (strFieldName.equals("discntFlag"))
			return 22;
		if (strFieldName.equals("interestFlag"))
			return 23;
		if (strFieldName.equals("shareFlag"))
			return 24;
		if (strFieldName.equals("inpFlag"))
			return 25;
		if (strFieldName.equals("bnfFlag"))
			return 26;
		if (strFieldName.equals("urgeGetFlag"))
			return 27;
		if (strFieldName.equals("deadValiFlag"))
			return 28;
		if (strFieldName.equals("getInitFlag"))
			return 29;
		if (strFieldName.equals("getLimit"))
			return 30;
		if (strFieldName.equals("maxGet"))
			return 31;
		if (strFieldName.equals("getRate"))
			return 32;
		if (strFieldName.equals("needAcc"))
			return 33;
		if (strFieldName.equals("canGet"))
			return 34;
		if (strFieldName.equals("needCancelAcc"))
			return 35;
		if (strFieldName.equals("getType1"))
			return 36;
		if (strFieldName.equals("zeroFlag"))
			return 37;
		return !strFieldName.equals("getType2") ? -1 : 38;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "getDutyCode";
			break;

		case 1: // '\001'
			strFieldName = "getDutyName";
			break;

		case 2: // '\002'
			strFieldName = "type";
			break;

		case 3: // '\003'
			strFieldName = "getIntv";
			break;

		case 4: // '\004'
			strFieldName = "defaultVal";
			break;

		case 5: // '\005'
			strFieldName = "calCode";
			break;

		case 6: // '\006'
			strFieldName = "cnterCalCode";
			break;

		case 7: // '\007'
			strFieldName = "othCalCode";
			break;

		case 8: // '\b'
			strFieldName = "getYear";
			break;

		case 9: // '\t'
			strFieldName = "getYearFlag";
			break;

		case 10: // '\n'
			strFieldName = "startDateCalRef";
			break;

		case 11: // '\013'
			strFieldName = "startDateCalMode";
			break;

		case 12: // '\f'
			strFieldName = "minGetStartPeriod";
			break;

		case 13: // '\r'
			strFieldName = "getEndPeriod";
			break;

		case 14: // '\016'
			strFieldName = "getEndUnit";
			break;

		case 15: // '\017'
			strFieldName = "endDateCalRef";
			break;

		case 16: // '\020'
			strFieldName = "endDateCalMode";
			break;

		case 17: // '\021'
			strFieldName = "maxGetEndPeriod";
			break;

		case 18: // '\022'
			strFieldName = "addFlag";
			break;

		case 19: // '\023'
			strFieldName = "sexRelaFlag";
			break;

		case 20: // '\024'
			strFieldName = "unitAppRelaFlag";
			break;

		case 21: // '\025'
			strFieldName = "addAmntFlag";
			break;

		case 22: // '\026'
			strFieldName = "discntFlag";
			break;

		case 23: // '\027'
			strFieldName = "interestFlag";
			break;

		case 24: // '\030'
			strFieldName = "shareFlag";
			break;

		case 25: // '\031'
			strFieldName = "inpFlag";
			break;

		case 26: // '\032'
			strFieldName = "bnfFlag";
			break;

		case 27: // '\033'
			strFieldName = "urgeGetFlag";
			break;

		case 28: // '\034'
			strFieldName = "deadValiFlag";
			break;

		case 29: // '\035'
			strFieldName = "getInitFlag";
			break;

		case 30: // '\036'
			strFieldName = "getLimit";
			break;

		case 31: // '\037'
			strFieldName = "maxGet";
			break;

		case 32: // ' '
			strFieldName = "getRate";
			break;

		case 33: // '!'
			strFieldName = "needAcc";
			break;

		case 34: // '"'
			strFieldName = "canGet";
			break;

		case 35: // '#'
			strFieldName = "needCancelAcc";
			break;

		case 36: // '$'
			strFieldName = "getType1";
			break;

		case 37: // '%'
			strFieldName = "zeroFlag";
			break;

		case 38: // '&'
			strFieldName = "getType2";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("getDutyCode"))
			return 0;
		if (strFieldName.equals("getDutyName"))
			return 0;
		if (strFieldName.equals("type"))
			return 0;
		if (strFieldName.equals("getIntv"))
			return 3;
		if (strFieldName.equals("defaultVal"))
			return 4;
		if (strFieldName.equals("calCode"))
			return 0;
		if (strFieldName.equals("cnterCalCode"))
			return 0;
		if (strFieldName.equals("othCalCode"))
			return 0;
		if (strFieldName.equals("getYear"))
			return 3;
		if (strFieldName.equals("getYearFlag"))
			return 0;
		if (strFieldName.equals("startDateCalRef"))
			return 0;
		if (strFieldName.equals("startDateCalMode"))
			return 0;
		if (strFieldName.equals("minGetStartPeriod"))
			return 3;
		if (strFieldName.equals("getEndPeriod"))
			return 3;
		if (strFieldName.equals("getEndUnit"))
			return 0;
		if (strFieldName.equals("endDateCalRef"))
			return 0;
		if (strFieldName.equals("endDateCalMode"))
			return 0;
		if (strFieldName.equals("maxGetEndPeriod"))
			return 3;
		if (strFieldName.equals("addFlag"))
			return 0;
		if (strFieldName.equals("sexRelaFlag"))
			return 0;
		if (strFieldName.equals("unitAppRelaFlag"))
			return 0;
		if (strFieldName.equals("addAmntFlag"))
			return 0;
		if (strFieldName.equals("discntFlag"))
			return 0;
		if (strFieldName.equals("interestFlag"))
			return 0;
		if (strFieldName.equals("shareFlag"))
			return 0;
		if (strFieldName.equals("inpFlag"))
			return 0;
		if (strFieldName.equals("bnfFlag"))
			return 0;
		if (strFieldName.equals("urgeGetFlag"))
			return 0;
		if (strFieldName.equals("deadValiFlag"))
			return 0;
		if (strFieldName.equals("getInitFlag"))
			return 0;
		if (strFieldName.equals("getLimit"))
			return 4;
		if (strFieldName.equals("maxGet"))
			return 4;
		if (strFieldName.equals("getRate"))
			return 4;
		if (strFieldName.equals("needAcc"))
			return 0;
		if (strFieldName.equals("canGet"))
			return 0;
		if (strFieldName.equals("needCancelAcc"))
			return 0;
		if (strFieldName.equals("getType1"))
			return 0;
		if (strFieldName.equals("zeroFlag"))
			return 0;
		return !strFieldName.equals("getType2") ? -1 : 0;
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
			nFieldType = 4;
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
			nFieldType = 3;
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
			nFieldType = 3;
			break;

		case 13: // '\r'
			nFieldType = 3;
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
			nFieldType = 3;
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
			nFieldType = 0;
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

		case 27: // '\033'
			nFieldType = 0;
			break;

		case 28: // '\034'
			nFieldType = 0;
			break;

		case 29: // '\035'
			nFieldType = 0;
			break;

		case 30: // '\036'
			nFieldType = 4;
			break;

		case 31: // '\037'
			nFieldType = 4;
			break;

		case 32: // ' '
			nFieldType = 4;
			break;

		case 33: // '!'
			nFieldType = 0;
			break;

		case 34: // '"'
			nFieldType = 0;
			break;

		case 35: // '#'
			nFieldType = 0;
			break;

		case 36: // '$'
			nFieldType = 0;
			break;

		case 37: // '%'
			nFieldType = 0;
			break;

		case 38: // '&'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
