// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInvestmentAccountInfoSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPInvestmentAccountInfoDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPInvestmentAccountInfoSchema
	implements Schema
{

	private String ContNo;
	private String RiskCode;
	private String InvestAccountCode;
	private double InvestAccountRate;
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
	public static final int FIELDNUM = 16;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPInvestmentAccountInfoSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[3];
		pk[0] = "ContNo";
		pk[1] = "RiskCode";
		pk[2] = "InvestAccountCode";
		PK = pk;
	}

	public String[] getPK()
	{
		return PK;
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

	public String getRiskCode()
	{
		if (RiskCode != null)
			RiskCode.equals("");
		return RiskCode;
	}

	public void setRiskCode(String aRiskCode)
	{
		RiskCode = aRiskCode;
	}

	public String getInvestAccountCode()
	{
		if (InvestAccountCode != null)
			InvestAccountCode.equals("");
		return InvestAccountCode;
	}

	public void setInvestAccountCode(String aInvestAccountCode)
	{
		InvestAccountCode = aInvestAccountCode;
	}

	public double getInvestAccountRate()
	{
		return InvestAccountRate;
	}

	public void setInvestAccountRate(double aInvestAccountRate)
	{
		InvestAccountRate = aInvestAccountRate;
	}

	public void setInvestAccountRate(String aInvestAccountRate)
	{
		if (aInvestAccountRate != null && !aInvestAccountRate.equals(""))
		{
			Double tDouble = new Double(aInvestAccountRate);
			double d = tDouble.doubleValue();
			InvestAccountRate = d;
		}
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

	public void setSchema(LNPInvestmentAccountInfoSchema aLNPInvestmentAccountInfoSchema)
	{
		ContNo = aLNPInvestmentAccountInfoSchema.getContNo();
		RiskCode = aLNPInvestmentAccountInfoSchema.getRiskCode();
		InvestAccountCode = aLNPInvestmentAccountInfoSchema.getInvestAccountCode();
		InvestAccountRate = aLNPInvestmentAccountInfoSchema.getInvestAccountRate();
		Operator = aLNPInvestmentAccountInfoSchema.getOperator();
		MakeDate = aLNPInvestmentAccountInfoSchema.getMakeDate();
		MakeTime = aLNPInvestmentAccountInfoSchema.getMakeTime();
		ModifyDate = aLNPInvestmentAccountInfoSchema.getModifyDate();
		ModifyTime = aLNPInvestmentAccountInfoSchema.getModifyTime();
		Remark = aLNPInvestmentAccountInfoSchema.getRemark();
		Varc1 = aLNPInvestmentAccountInfoSchema.getVarc1();
		Varc2 = aLNPInvestmentAccountInfoSchema.getVarc2();
		Varc3 = aLNPInvestmentAccountInfoSchema.getVarc3();
		Varc4 = aLNPInvestmentAccountInfoSchema.getVarc4();
		DateTime1 = fDate.getDate(aLNPInvestmentAccountInfoSchema.getDateTime1());
		DateTime2 = fDate.getDate(aLNPInvestmentAccountInfoSchema.getDateTime2());
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ContNo") == null)
				ContNo = null;
			else
				ContNo = rs.getString("ContNo").trim();
			if (rs.getString("RiskCode") == null)
				RiskCode = null;
			else
				RiskCode = rs.getString("RiskCode").trim();
			if (rs.getString("InvestAccountCode") == null)
				InvestAccountCode = null;
			else
				InvestAccountCode = rs.getString("InvestAccountCode").trim();
			InvestAccountRate = rs.getDouble("InvestAccountRate");
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
			tError.moduleName = "LNPInvestmentAccountInfoSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPInvestmentAccountInfoSchema getSchema()
	{
		LNPInvestmentAccountInfoSchema aLNPInvestmentAccountInfoSchema = new LNPInvestmentAccountInfoSchema();
		aLNPInvestmentAccountInfoSchema.setSchema(this);
		return aLNPInvestmentAccountInfoSchema;
	}

	public LNPInvestmentAccountInfoDB getDB()
	{
		LNPInvestmentAccountInfoDB aDBOper = new LNPInvestmentAccountInfoDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(ContNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(RiskCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(InvestAccountCode))).append("|").append(ChgData.chgData(InvestAccountRate)).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MakeDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MakeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ModifyDate))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ModifyTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Remark))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Varc4))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(DateTime1)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(DateTime2)))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			RiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			InvestAccountCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			InvestAccountRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|")))).doubleValue();
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			MakeDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			ModifyDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			Varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			Varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			Varc3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			Varc4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			DateTime1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			DateTime2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInvestmentAccountInfoSchema";
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
		if (FCode.equals("ContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ContNo));
		if (FCode.equals("RiskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskCode));
		if (FCode.equals("InvestAccountCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(InvestAccountCode));
		if (FCode.equals("InvestAccountRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(InvestAccountRate));
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
			strFieldValue = StrTool.GBKToUnicode(ContNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(RiskCode);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(InvestAccountCode);
			break;

		case 3: // '\003'
			strFieldValue = String.valueOf(InvestAccountRate);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(Operator);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(MakeDate);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(MakeTime);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(ModifyDate);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(ModifyTime);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(Remark);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(Varc1);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(Varc2);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(Varc3);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(Varc4);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDateTime1()));
			break;

		case 15: // '\017'
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
		if (FCode.equals("ContNo"))
			if (FValue != null && !FValue.equals(""))
				ContNo = FValue.trim();
			else
				ContNo = null;
		if (FCode.equals("RiskCode"))
			if (FValue != null && !FValue.equals(""))
				RiskCode = FValue.trim();
			else
				RiskCode = null;
		if (FCode.equals("InvestAccountCode"))
			if (FValue != null && !FValue.equals(""))
				InvestAccountCode = FValue.trim();
			else
				InvestAccountCode = null;
		if (FCode.equals("InvestAccountRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			InvestAccountRate = d;
		}
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
		LNPInvestmentAccountInfoSchema other = (LNPInvestmentAccountInfoSchema)otherObject;
		return ContNo.equals(other.getContNo()) && RiskCode.equals(other.getRiskCode()) && InvestAccountCode.equals(other.getInvestAccountCode()) && InvestAccountRate == other.getInvestAccountRate() && Operator.equals(other.getOperator()) && MakeDate.equals(other.getMakeDate()) && MakeTime.equals(other.getMakeTime()) && ModifyDate.equals(other.getModifyDate()) && ModifyTime.equals(other.getModifyTime()) && Remark.equals(other.getRemark()) && Varc1.equals(other.getVarc1()) && Varc2.equals(other.getVarc2()) && Varc3.equals(other.getVarc3()) && Varc4.equals(other.getVarc4()) && fDate.getString(DateTime1).equals(other.getDateTime1()) && fDate.getString(DateTime2).equals(other.getDateTime2());
	}

	public int getFieldCount()
	{
		return 16;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("RiskCode"))
			return 1;
		if (strFieldName.equals("InvestAccountCode"))
			return 2;
		if (strFieldName.equals("InvestAccountRate"))
			return 3;
		if (strFieldName.equals("Operator"))
			return 4;
		if (strFieldName.equals("MakeDate"))
			return 5;
		if (strFieldName.equals("MakeTime"))
			return 6;
		if (strFieldName.equals("ModifyDate"))
			return 7;
		if (strFieldName.equals("ModifyTime"))
			return 8;
		if (strFieldName.equals("Remark"))
			return 9;
		if (strFieldName.equals("Varc1"))
			return 10;
		if (strFieldName.equals("Varc2"))
			return 11;
		if (strFieldName.equals("Varc3"))
			return 12;
		if (strFieldName.equals("Varc4"))
			return 13;
		if (strFieldName.equals("DateTime1"))
			return 14;
		return !strFieldName.equals("DateTime2") ? -1 : 15;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "ContNo";
			break;

		case 1: // '\001'
			strFieldName = "RiskCode";
			break;

		case 2: // '\002'
			strFieldName = "InvestAccountCode";
			break;

		case 3: // '\003'
			strFieldName = "InvestAccountRate";
			break;

		case 4: // '\004'
			strFieldName = "Operator";
			break;

		case 5: // '\005'
			strFieldName = "MakeDate";
			break;

		case 6: // '\006'
			strFieldName = "MakeTime";
			break;

		case 7: // '\007'
			strFieldName = "ModifyDate";
			break;

		case 8: // '\b'
			strFieldName = "ModifyTime";
			break;

		case 9: // '\t'
			strFieldName = "Remark";
			break;

		case 10: // '\n'
			strFieldName = "Varc1";
			break;

		case 11: // '\013'
			strFieldName = "Varc2";
			break;

		case 12: // '\f'
			strFieldName = "Varc3";
			break;

		case 13: // '\r'
			strFieldName = "Varc4";
			break;

		case 14: // '\016'
			strFieldName = "DateTime1";
			break;

		case 15: // '\017'
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
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("RiskCode"))
			return 0;
		if (strFieldName.equals("InvestAccountCode"))
			return 0;
		if (strFieldName.equals("InvestAccountRate"))
			return 4;
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
			nFieldType = 4;
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
			nFieldType = 1;
			break;

		case 15: // '\017'
			nFieldType = 1;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
