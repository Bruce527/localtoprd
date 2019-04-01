// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInvestmentInfoBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPInvestmentInfoBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPInvestmentInfoBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
	private String ID;
	private String ContNo;
	private double StockInvestAccount;
	private double MixedStockInvestAccount;
	private double MixedBondInvestAccount;
	private double BondInvestAccount;
	private double CurrencyInvestAccount;
	private String PayExtraPremFlag;
	private double MonthPlusPrem;
	private String TermInvestment;
	private String HesInvestment;
	private String Operator;
	private String MakeDate;
	private String MakeTime;
	private String ModifyDate;
	private String ModifyTime;
	private String Remark;
	private String Varc1;
	private String Varc2;
	private String Varc3;
	private String Varc4;
	private Date DateTime1;
	private Date DateTime2;
	public static final int FIELDNUM = 25;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPInvestmentInfoBSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "EdorNo";
		pk[1] = "serialNo";
		PK = pk;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getEdorNo()
	{
		if (EdorNo != null)
			EdorNo.equals("");
		return EdorNo;
	}

	public void setEdorNo(String aEdorNo)
	{
		EdorNo = aEdorNo;
	}

	public String getserialNo()
	{
		if (serialNo != null)
			serialNo.equals("");
		return serialNo;
	}

	public void setserialNo(String aserialNo)
	{
		serialNo = aserialNo;
	}

	public String getID()
	{
		if (ID != null)
			ID.equals("");
		return ID;
	}

	public void setID(String aID)
	{
		ID = aID;
	}

	public String getContNo()
	{
		if (ContNo != null)
			ContNo.equals("");
		return ContNo;
	}

	public void setContNo(String aContNo)
	{
		ContNo = aContNo;
	}

	public double getStockInvestAccount()
	{
		return StockInvestAccount;
	}

	public void setStockInvestAccount(double aStockInvestAccount)
	{
		StockInvestAccount = aStockInvestAccount;
	}

	public void setStockInvestAccount(String aStockInvestAccount)
	{
		if (aStockInvestAccount != null && !aStockInvestAccount.equals(""))
		{
			Double tDouble = new Double(aStockInvestAccount);
			double d = tDouble.doubleValue();
			StockInvestAccount = d;
		}
	}

	public double getMixedStockInvestAccount()
	{
		return MixedStockInvestAccount;
	}

	public void setMixedStockInvestAccount(double aMixedStockInvestAccount)
	{
		MixedStockInvestAccount = aMixedStockInvestAccount;
	}

	public void setMixedStockInvestAccount(String aMixedStockInvestAccount)
	{
		if (aMixedStockInvestAccount != null && !aMixedStockInvestAccount.equals(""))
		{
			Double tDouble = new Double(aMixedStockInvestAccount);
			double d = tDouble.doubleValue();
			MixedStockInvestAccount = d;
		}
	}

	public double getMixedBondInvestAccount()
	{
		return MixedBondInvestAccount;
	}

	public void setMixedBondInvestAccount(double aMixedBondInvestAccount)
	{
		MixedBondInvestAccount = aMixedBondInvestAccount;
	}

	public void setMixedBondInvestAccount(String aMixedBondInvestAccount)
	{
		if (aMixedBondInvestAccount != null && !aMixedBondInvestAccount.equals(""))
		{
			Double tDouble = new Double(aMixedBondInvestAccount);
			double d = tDouble.doubleValue();
			MixedBondInvestAccount = d;
		}
	}

	public double getBondInvestAccount()
	{
		return BondInvestAccount;
	}

	public void setBondInvestAccount(double aBondInvestAccount)
	{
		BondInvestAccount = aBondInvestAccount;
	}

	public void setBondInvestAccount(String aBondInvestAccount)
	{
		if (aBondInvestAccount != null && !aBondInvestAccount.equals(""))
		{
			Double tDouble = new Double(aBondInvestAccount);
			double d = tDouble.doubleValue();
			BondInvestAccount = d;
		}
	}

	public double getCurrencyInvestAccount()
	{
		return CurrencyInvestAccount;
	}

	public void setCurrencyInvestAccount(double aCurrencyInvestAccount)
	{
		CurrencyInvestAccount = aCurrencyInvestAccount;
	}

	public void setCurrencyInvestAccount(String aCurrencyInvestAccount)
	{
		if (aCurrencyInvestAccount != null && !aCurrencyInvestAccount.equals(""))
		{
			Double tDouble = new Double(aCurrencyInvestAccount);
			double d = tDouble.doubleValue();
			CurrencyInvestAccount = d;
		}
	}

	public String getPayExtraPremFlag()
	{
		if (PayExtraPremFlag != null)
			PayExtraPremFlag.equals("");
		return PayExtraPremFlag;
	}

	public void setPayExtraPremFlag(String aPayExtraPremFlag)
	{
		PayExtraPremFlag = aPayExtraPremFlag;
	}

	public double getMonthPlusPrem()
	{
		return MonthPlusPrem;
	}

	public void setMonthPlusPrem(double aMonthPlusPrem)
	{
		MonthPlusPrem = aMonthPlusPrem;
	}

	public void setMonthPlusPrem(String aMonthPlusPrem)
	{
		if (aMonthPlusPrem != null && !aMonthPlusPrem.equals(""))
		{
			Double tDouble = new Double(aMonthPlusPrem);
			double d = tDouble.doubleValue();
			MonthPlusPrem = d;
		}
	}

	public String getTermInvestment()
	{
		if (TermInvestment != null)
			TermInvestment.equals("");
		return TermInvestment;
	}

	public void setTermInvestment(String aTermInvestment)
	{
		TermInvestment = aTermInvestment;
	}

	public String getHesInvestment()
	{
		if (HesInvestment != null)
			HesInvestment.equals("");
		return HesInvestment;
	}

	public void setHesInvestment(String aHesInvestment)
	{
		HesInvestment = aHesInvestment;
	}

	public String getOperator()
	{
		if (Operator != null)
			Operator.equals("");
		return Operator;
	}

	public void setOperator(String aOperator)
	{
		Operator = aOperator;
	}

	public String getMakeDate()
	{
		if (MakeDate != null)
			MakeDate.equals("");
		return MakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		MakeDate = aMakeDate;
	}

	public String getMakeTime()
	{
		if (MakeTime != null)
			MakeTime.equals("");
		return MakeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		MakeTime = aMakeTime;
	}

	public String getModifyDate()
	{
		if (ModifyDate != null)
			ModifyDate.equals("");
		return ModifyDate;
	}

	public void setModifyDate(String aModifyDate)
	{
		ModifyDate = aModifyDate;
	}

	public String getModifyTime()
	{
		if (ModifyTime != null)
			ModifyTime.equals("");
		return ModifyTime;
	}

	public void setModifyTime(String aModifyTime)
	{
		ModifyTime = aModifyTime;
	}

	public String getRemark()
	{
		if (Remark != null)
			Remark.equals("");
		return Remark;
	}

	public void setRemark(String aRemark)
	{
		Remark = aRemark;
	}

	public String getVarc1()
	{
		if (Varc1 != null)
			Varc1.equals("");
		return Varc1;
	}

	public void setVarc1(String aVarc1)
	{
		Varc1 = aVarc1;
	}

	public String getVarc2()
	{
		if (Varc2 != null)
			Varc2.equals("");
		return Varc2;
	}

	public void setVarc2(String aVarc2)
	{
		Varc2 = aVarc2;
	}

	public String getVarc3()
	{
		if (Varc3 != null)
			Varc3.equals("");
		return Varc3;
	}

	public void setVarc3(String aVarc3)
	{
		Varc3 = aVarc3;
	}

	public String getVarc4()
	{
		if (Varc4 != null)
			Varc4.equals("");
		return Varc4;
	}

	public void setVarc4(String aVarc4)
	{
		Varc4 = aVarc4;
	}

	public String getDateTime1()
	{
		if (DateTime1 != null)
			return fDate.getString(DateTime1);
		else
			return null;
	}

	public void setDateTime1(Date aDateTime1)
	{
		DateTime1 = aDateTime1;
	}

	public void setDateTime1(String aDateTime1)
	{
		if (aDateTime1 != null && !aDateTime1.equals(""))
			DateTime1 = fDate.getDate(aDateTime1);
		else
			DateTime1 = null;
	}

	public String getDateTime2()
	{
		if (DateTime2 != null)
			return fDate.getString(DateTime2);
		else
			return null;
	}

	public void setDateTime2(Date aDateTime2)
	{
		DateTime2 = aDateTime2;
	}

	public void setDateTime2(String aDateTime2)
	{
		if (aDateTime2 != null && !aDateTime2.equals(""))
			DateTime2 = fDate.getDate(aDateTime2);
		else
			DateTime2 = null;
	}

	public void setSchema(LNPInvestmentInfoBSchema aLNPInvestmentInfoBSchema)
	{
		EdorNo = aLNPInvestmentInfoBSchema.getEdorNo();
		serialNo = aLNPInvestmentInfoBSchema.getserialNo();
		ID = aLNPInvestmentInfoBSchema.getID();
		ContNo = aLNPInvestmentInfoBSchema.getContNo();
		StockInvestAccount = aLNPInvestmentInfoBSchema.getStockInvestAccount();
		MixedStockInvestAccount = aLNPInvestmentInfoBSchema.getMixedStockInvestAccount();
		MixedBondInvestAccount = aLNPInvestmentInfoBSchema.getMixedBondInvestAccount();
		BondInvestAccount = aLNPInvestmentInfoBSchema.getBondInvestAccount();
		CurrencyInvestAccount = aLNPInvestmentInfoBSchema.getCurrencyInvestAccount();
		PayExtraPremFlag = aLNPInvestmentInfoBSchema.getPayExtraPremFlag();
		MonthPlusPrem = aLNPInvestmentInfoBSchema.getMonthPlusPrem();
		TermInvestment = aLNPInvestmentInfoBSchema.getTermInvestment();
		HesInvestment = aLNPInvestmentInfoBSchema.getHesInvestment();
		Operator = aLNPInvestmentInfoBSchema.getOperator();
		MakeDate = aLNPInvestmentInfoBSchema.getMakeDate();
		MakeTime = aLNPInvestmentInfoBSchema.getMakeTime();
		ModifyDate = aLNPInvestmentInfoBSchema.getModifyDate();
		ModifyTime = aLNPInvestmentInfoBSchema.getModifyTime();
		Remark = aLNPInvestmentInfoBSchema.getRemark();
		Varc1 = aLNPInvestmentInfoBSchema.getVarc1();
		Varc2 = aLNPInvestmentInfoBSchema.getVarc2();
		Varc3 = aLNPInvestmentInfoBSchema.getVarc3();
		Varc4 = aLNPInvestmentInfoBSchema.getVarc4();
		DateTime1 = fDate.getDate(aLNPInvestmentInfoBSchema.getDateTime1());
		DateTime2 = fDate.getDate(aLNPInvestmentInfoBSchema.getDateTime2());
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("EdorNo") == null)
				EdorNo = null;
			else
				EdorNo = rs.getString("EdorNo").trim();
			if (rs.getString("serialNo") == null)
				serialNo = null;
			else
				serialNo = rs.getString("serialNo").trim();
			if (rs.getString("ID") == null)
				ID = null;
			else
				ID = rs.getString("ID").trim();
			if (rs.getString("ContNo") == null)
				ContNo = null;
			else
				ContNo = rs.getString("ContNo").trim();
			StockInvestAccount = rs.getDouble("StockInvestAccount");
			MixedStockInvestAccount = rs.getDouble("MixedStockInvestAccount");
			MixedBondInvestAccount = rs.getDouble("MixedBondInvestAccount");
			BondInvestAccount = rs.getDouble("BondInvestAccount");
			CurrencyInvestAccount = rs.getDouble("CurrencyInvestAccount");
			if (rs.getString("PayExtraPremFlag") == null)
				PayExtraPremFlag = null;
			else
				PayExtraPremFlag = rs.getString("PayExtraPremFlag").trim();
			MonthPlusPrem = rs.getDouble("MonthPlusPrem");
			if (rs.getString("TermInvestment") == null)
				TermInvestment = null;
			else
				TermInvestment = rs.getString("TermInvestment").trim();
			if (rs.getString("HesInvestment") == null)
				HesInvestment = null;
			else
				HesInvestment = rs.getString("HesInvestment").trim();
			if (rs.getString("Operator") == null)
				Operator = null;
			else
				Operator = rs.getString("Operator").trim();
			if (rs.getString("MakeDate") == null)
				MakeDate = null;
			else
				MakeDate = rs.getString("MakeDate").trim();
			if (rs.getString("MakeTime") == null)
				MakeTime = null;
			else
				MakeTime = rs.getString("MakeTime").trim();
			if (rs.getString("ModifyDate") == null)
				ModifyDate = null;
			else
				ModifyDate = rs.getString("ModifyDate").trim();
			if (rs.getString("ModifyTime") == null)
				ModifyTime = null;
			else
				ModifyTime = rs.getString("ModifyTime").trim();
			if (rs.getString("Remark") == null)
				Remark = null;
			else
				Remark = rs.getString("Remark").trim();
			if (rs.getString("Varc1") == null)
				Varc1 = null;
			else
				Varc1 = rs.getString("Varc1").trim();
			if (rs.getString("Varc2") == null)
				Varc2 = null;
			else
				Varc2 = rs.getString("Varc2").trim();
			if (rs.getString("Varc3") == null)
				Varc3 = null;
			else
				Varc3 = rs.getString("Varc3").trim();
			if (rs.getString("Varc4") == null)
				Varc4 = null;
			else
				Varc4 = rs.getString("Varc4").trim();
			DateTime1 = rs.getDate("DateTime1");
			DateTime2 = rs.getDate("DateTime2");
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInvestmentInfoBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPInvestmentInfoBSchema getSchema()
	{
		LNPInvestmentInfoBSchema aLNPInvestmentInfoBSchema = new LNPInvestmentInfoBSchema();
		aLNPInvestmentInfoBSchema.setSchema(this);
		return aLNPInvestmentInfoBSchema;
	}

	public LNPInvestmentInfoBDB getDB()
	{
		LNPInvestmentInfoBDB aDBOper = new LNPInvestmentInfoBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ID))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ContNo))).append("|").append(ChgData.chgData(StockInvestAccount)).append("|").append(ChgData.chgData(MixedStockInvestAccount)).append("|").append(ChgData.chgData(MixedBondInvestAccount)).append("|").append(ChgData.chgData(BondInvestAccount)).append("|").append(ChgData.chgData(CurrencyInvestAccount)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(PayExtraPremFlag))).append("|").append(ChgData.chgData(MonthPlusPrem)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(TermInvestment))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(HesInvestment))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MakeDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MakeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ModifyDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ModifyTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Remark))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc4))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(DateTime1)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(DateTime2)))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			StockInvestAccount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|")))).doubleValue();
			MixedStockInvestAccount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).doubleValue();
			MixedBondInvestAccount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).doubleValue();
			BondInvestAccount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).doubleValue();
			CurrencyInvestAccount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).doubleValue();
			PayExtraPremFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			MonthPlusPrem = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).doubleValue();
			TermInvestment = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			HesInvestment = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			MakeDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			ModifyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			DateTime1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
			DateTime2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInvestmentInfoBSchema";
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
		if (FCode.equals("EdorNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(EdorNo));
		if (FCode.equals("serialNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(serialNo));
		if (FCode.equals("ID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ID));
		if (FCode.equals("ContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ContNo));
		if (FCode.equals("StockInvestAccount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(StockInvestAccount));
		if (FCode.equals("MixedStockInvestAccount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MixedStockInvestAccount));
		if (FCode.equals("MixedBondInvestAccount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MixedBondInvestAccount));
		if (FCode.equals("BondInvestAccount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BondInvestAccount));
		if (FCode.equals("CurrencyInvestAccount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(CurrencyInvestAccount));
		if (FCode.equals("PayExtraPremFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(PayExtraPremFlag));
		if (FCode.equals("MonthPlusPrem"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MonthPlusPrem));
		if (FCode.equals("TermInvestment"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(TermInvestment));
		if (FCode.equals("HesInvestment"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(HesInvestment));
		if (FCode.equals("Operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		if (FCode.equals("MakeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeDate));
		if (FCode.equals("MakeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		if (FCode.equals("ModifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyDate));
		if (FCode.equals("ModifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime));
		if (FCode.equals("Remark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remark));
		if (FCode.equals("Varc1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc1));
		if (FCode.equals("Varc2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc2));
		if (FCode.equals("Varc3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc3));
		if (FCode.equals("Varc4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Varc4));
		if (FCode.equals("DateTime1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
		if (FCode.equals("DateTime2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
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
			strFieldValue = StrTool.GBKToUnicode(EdorNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(serialNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(ID);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(ContNo);
			break;

		case 4: // '\004'
			strFieldValue = String.valueOf(StockInvestAccount);
			break;

		case 5: // '\005'
			strFieldValue = String.valueOf(MixedStockInvestAccount);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(MixedBondInvestAccount);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(BondInvestAccount);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(CurrencyInvestAccount);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(PayExtraPremFlag);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(MonthPlusPrem);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(TermInvestment);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(HesInvestment);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(Operator);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(MakeDate);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(MakeTime);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(ModifyDate);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(ModifyTime);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(Remark);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(Varc1);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(Varc2);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(Varc3);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(Varc4);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime2()));
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
		if (FCode.equals("EdorNo"))
			if (FValue != null && !FValue.equals(""))
				EdorNo = FValue.trim();
			else
				EdorNo = null;
		if (FCode.equals("serialNo"))
			if (FValue != null && !FValue.equals(""))
				serialNo = FValue.trim();
			else
				serialNo = null;
		if (FCode.equals("ID"))
			if (FValue != null && !FValue.equals(""))
				ID = FValue.trim();
			else
				ID = null;
		if (FCode.equals("ContNo"))
			if (FValue != null && !FValue.equals(""))
				ContNo = FValue.trim();
			else
				ContNo = null;
		if (FCode.equals("StockInvestAccount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			StockInvestAccount = d;
		}
		if (FCode.equals("MixedStockInvestAccount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			MixedStockInvestAccount = d;
		}
		if (FCode.equals("MixedBondInvestAccount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			MixedBondInvestAccount = d;
		}
		if (FCode.equals("BondInvestAccount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			BondInvestAccount = d;
		}
		if (FCode.equals("CurrencyInvestAccount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			CurrencyInvestAccount = d;
		}
		if (FCode.equals("PayExtraPremFlag"))
			if (FValue != null && !FValue.equals(""))
				PayExtraPremFlag = FValue.trim();
			else
				PayExtraPremFlag = null;
		if (FCode.equals("MonthPlusPrem") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			MonthPlusPrem = d;
		}
		if (FCode.equals("TermInvestment"))
			if (FValue != null && !FValue.equals(""))
				TermInvestment = FValue.trim();
			else
				TermInvestment = null;
		if (FCode.equals("HesInvestment"))
			if (FValue != null && !FValue.equals(""))
				HesInvestment = FValue.trim();
			else
				HesInvestment = null;
		if (FCode.equals("Operator"))
			if (FValue != null && !FValue.equals(""))
				Operator = FValue.trim();
			else
				Operator = null;
		if (FCode.equals("MakeDate"))
			if (FValue != null && !FValue.equals(""))
				MakeDate = FValue.trim();
			else
				MakeDate = null;
		if (FCode.equals("MakeTime"))
			if (FValue != null && !FValue.equals(""))
				MakeTime = FValue.trim();
			else
				MakeTime = null;
		if (FCode.equals("ModifyDate"))
			if (FValue != null && !FValue.equals(""))
				ModifyDate = FValue.trim();
			else
				ModifyDate = null;
		if (FCode.equals("ModifyTime"))
			if (FValue != null && !FValue.equals(""))
				ModifyTime = FValue.trim();
			else
				ModifyTime = null;
		if (FCode.equals("Remark"))
			if (FValue != null && !FValue.equals(""))
				Remark = FValue.trim();
			else
				Remark = null;
		if (FCode.equals("Varc1"))
			if (FValue != null && !FValue.equals(""))
				Varc1 = FValue.trim();
			else
				Varc1 = null;
		if (FCode.equals("Varc2"))
			if (FValue != null && !FValue.equals(""))
				Varc2 = FValue.trim();
			else
				Varc2 = null;
		if (FCode.equals("Varc3"))
			if (FValue != null && !FValue.equals(""))
				Varc3 = FValue.trim();
			else
				Varc3 = null;
		if (FCode.equals("Varc4"))
			if (FValue != null && !FValue.equals(""))
				Varc4 = FValue.trim();
			else
				Varc4 = null;
		if (FCode.equals("DateTime1"))
			if (FValue != null && !FValue.equals(""))
				DateTime1 = fDate.getDate(FValue);
			else
				DateTime1 = null;
		if (FCode.equals("DateTime2"))
			if (FValue != null && !FValue.equals(""))
				DateTime2 = fDate.getDate(FValue);
			else
				DateTime2 = null;
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		LNPInvestmentInfoBSchema other = (LNPInvestmentInfoBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && ID.equals(other.getID()) && ContNo.equals(other.getContNo()) && StockInvestAccount == other.getStockInvestAccount() && MixedStockInvestAccount == other.getMixedStockInvestAccount() && MixedBondInvestAccount == other.getMixedBondInvestAccount() && BondInvestAccount == other.getBondInvestAccount() && CurrencyInvestAccount == other.getCurrencyInvestAccount() && PayExtraPremFlag.equals(other.getPayExtraPremFlag()) && MonthPlusPrem == other.getMonthPlusPrem() && TermInvestment.equals(other.getTermInvestment()) && HesInvestment.equals(other.getHesInvestment()) && Operator.equals(other.getOperator()) && MakeDate.equals(other.getMakeDate()) && MakeTime.equals(other.getMakeTime()) && ModifyDate.equals(other.getModifyDate()) && ModifyTime.equals(other.getModifyTime()) && Remark.equals(other.getRemark()) && Varc1.equals(other.getVarc1()) && Varc2.equals(other.getVarc2()) && Varc3.equals(other.getVarc3()) && Varc4.equals(other.getVarc4()) && fDate.getString(DateTime1).equals(other.getDateTime1()) && fDate.getString(DateTime2).equals(other.getDateTime2());
	}

	public int getFieldCount()
	{
		return 25;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("ID"))
			return 2;
		if (strFieldName.equals("ContNo"))
			return 3;
		if (strFieldName.equals("StockInvestAccount"))
			return 4;
		if (strFieldName.equals("MixedStockInvestAccount"))
			return 5;
		if (strFieldName.equals("MixedBondInvestAccount"))
			return 6;
		if (strFieldName.equals("BondInvestAccount"))
			return 7;
		if (strFieldName.equals("CurrencyInvestAccount"))
			return 8;
		if (strFieldName.equals("PayExtraPremFlag"))
			return 9;
		if (strFieldName.equals("MonthPlusPrem"))
			return 10;
		if (strFieldName.equals("TermInvestment"))
			return 11;
		if (strFieldName.equals("HesInvestment"))
			return 12;
		if (strFieldName.equals("Operator"))
			return 13;
		if (strFieldName.equals("MakeDate"))
			return 14;
		if (strFieldName.equals("MakeTime"))
			return 15;
		if (strFieldName.equals("ModifyDate"))
			return 16;
		if (strFieldName.equals("ModifyTime"))
			return 17;
		if (strFieldName.equals("Remark"))
			return 18;
		if (strFieldName.equals("Varc1"))
			return 19;
		if (strFieldName.equals("Varc2"))
			return 20;
		if (strFieldName.equals("Varc3"))
			return 21;
		if (strFieldName.equals("Varc4"))
			return 22;
		if (strFieldName.equals("DateTime1"))
			return 23;
		return !strFieldName.equals("DateTime2") ? -1 : 24;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "EdorNo";
			break;

		case 1: // '\001'
			strFieldName = "serialNo";
			break;

		case 2: // '\002'
			strFieldName = "ID";
			break;

		case 3: // '\003'
			strFieldName = "ContNo";
			break;

		case 4: // '\004'
			strFieldName = "StockInvestAccount";
			break;

		case 5: // '\005'
			strFieldName = "MixedStockInvestAccount";
			break;

		case 6: // '\006'
			strFieldName = "MixedBondInvestAccount";
			break;

		case 7: // '\007'
			strFieldName = "BondInvestAccount";
			break;

		case 8: // '\b'
			strFieldName = "CurrencyInvestAccount";
			break;

		case 9: // '\t'
			strFieldName = "PayExtraPremFlag";
			break;

		case 10: // '\n'
			strFieldName = "MonthPlusPrem";
			break;

		case 11: // '\013'
			strFieldName = "TermInvestment";
			break;

		case 12: // '\f'
			strFieldName = "HesInvestment";
			break;

		case 13: // '\r'
			strFieldName = "Operator";
			break;

		case 14: // '\016'
			strFieldName = "MakeDate";
			break;

		case 15: // '\017'
			strFieldName = "MakeTime";
			break;

		case 16: // '\020'
			strFieldName = "ModifyDate";
			break;

		case 17: // '\021'
			strFieldName = "ModifyTime";
			break;

		case 18: // '\022'
			strFieldName = "Remark";
			break;

		case 19: // '\023'
			strFieldName = "Varc1";
			break;

		case 20: // '\024'
			strFieldName = "Varc2";
			break;

		case 21: // '\025'
			strFieldName = "Varc3";
			break;

		case 22: // '\026'
			strFieldName = "Varc4";
			break;

		case 23: // '\027'
			strFieldName = "DateTime1";
			break;

		case 24: // '\030'
			strFieldName = "DateTime2";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 0;
		if (strFieldName.equals("ID"))
			return 0;
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("StockInvestAccount"))
			return 4;
		if (strFieldName.equals("MixedStockInvestAccount"))
			return 4;
		if (strFieldName.equals("MixedBondInvestAccount"))
			return 4;
		if (strFieldName.equals("BondInvestAccount"))
			return 4;
		if (strFieldName.equals("CurrencyInvestAccount"))
			return 4;
		if (strFieldName.equals("PayExtraPremFlag"))
			return 0;
		if (strFieldName.equals("MonthPlusPrem"))
			return 4;
		if (strFieldName.equals("TermInvestment"))
			return 0;
		if (strFieldName.equals("HesInvestment"))
			return 0;
		if (strFieldName.equals("Operator"))
			return 0;
		if (strFieldName.equals("MakeDate"))
			return 0;
		if (strFieldName.equals("MakeTime"))
			return 0;
		if (strFieldName.equals("ModifyDate"))
			return 0;
		if (strFieldName.equals("ModifyTime"))
			return 0;
		if (strFieldName.equals("Remark"))
			return 0;
		if (strFieldName.equals("Varc1"))
			return 0;
		if (strFieldName.equals("Varc2"))
			return 0;
		if (strFieldName.equals("Varc3"))
			return 0;
		if (strFieldName.equals("Varc4"))
			return 0;
		if (strFieldName.equals("DateTime1"))
			return 1;
		return !strFieldName.equals("DateTime2") ? -1 : 1;
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
			nFieldType = 4;
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
			nFieldType = 0;
			break;

		case 10: // '\n'
			nFieldType = 4;
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
			nFieldType = 1;
			break;

		case 24: // '\030'
			nFieldType = 1;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
