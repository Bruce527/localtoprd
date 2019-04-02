// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPolicyStateSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPPolicyStateDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPPolicyStateSchema
	implements Schema
{

	private String ContNo;
	private String State;
	private String Operator;
	private String ManageCom;
	private Date ModifyDate;
	private String ModifyTime;
	private String AppntId;
	private String InsuredId;
	private String BenefitId;
	private Date MakeDate;
	private String MakeTime;
	private String BakString1;
	private String BakString2;
	private Date BakDate1;
	private String BakTime1;
	private Date BakDate2;
	private String BakTime2;
	private int BakInt1;
	private int BakInt2;
	public static final int FIELDNUM = 19;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPPolicyStateSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[5];
		pk[0] = "ContNo";
		pk[1] = "State";
		pk[2] = "Operator";
		pk[3] = "ModifyDate";
		pk[4] = "ModifyTime";
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

	public String getState()
	{
		if (State != null)
			State.equals("");
		return State;
	}

	public void setState(String aState)
	{
		State = aState;
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

	public String getManageCom()
	{
		if (ManageCom != null)
			ManageCom.equals("");
		return ManageCom;
	}

	public void setManageCom(String aManageCom)
	{
		ManageCom = aManageCom;
	}

	public String getModifyDate()
	{
		if (ModifyDate != null)
			return fDate.getString(ModifyDate);
		else
			return null;
	}

	public void setModifyDate(Date aModifyDate)
	{
		ModifyDate = aModifyDate;
	}

	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals(""))
			ModifyDate = fDate.getDate(aModifyDate);
		else
			ModifyDate = null;
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

	public String getAppntId()
	{
		if (AppntId != null)
			AppntId.equals("");
		return AppntId;
	}

	public void setAppntId(String aAppntId)
	{
		AppntId = aAppntId;
	}

	public String getInsuredId()
	{
		if (InsuredId != null)
			InsuredId.equals("");
		return InsuredId;
	}

	public void setInsuredId(String aInsuredId)
	{
		InsuredId = aInsuredId;
	}

	public String getBenefitId()
	{
		if (BenefitId != null)
			BenefitId.equals("");
		return BenefitId;
	}

	public void setBenefitId(String aBenefitId)
	{
		BenefitId = aBenefitId;
	}

	public String getMakeDate()
	{
		if (MakeDate != null)
			return fDate.getString(MakeDate);
		else
			return null;
	}

	public void setMakeDate(Date aMakeDate)
	{
		MakeDate = aMakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals(""))
			MakeDate = fDate.getDate(aMakeDate);
		else
			MakeDate = null;
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

	public String getBakString1()
	{
		if (BakString1 != null)
			BakString1.equals("");
		return BakString1;
	}

	public void setBakString1(String aBakString1)
	{
		BakString1 = aBakString1;
	}

	public String getBakString2()
	{
		if (BakString2 != null)
			BakString2.equals("");
		return BakString2;
	}

	public void setBakString2(String aBakString2)
	{
		BakString2 = aBakString2;
	}

	public String getBakDate1()
	{
		if (BakDate1 != null)
			return fDate.getString(BakDate1);
		else
			return null;
	}

	public void setBakDate1(Date aBakDate1)
	{
		BakDate1 = aBakDate1;
	}

	public void setBakDate1(String aBakDate1)
	{
		if (aBakDate1 != null && !aBakDate1.equals(""))
			BakDate1 = fDate.getDate(aBakDate1);
		else
			BakDate1 = null;
	}

	public String getBakTime1()
	{
		if (BakTime1 != null)
			BakTime1.equals("");
		return BakTime1;
	}

	public void setBakTime1(String aBakTime1)
	{
		BakTime1 = aBakTime1;
	}

	public String getBakDate2()
	{
		if (BakDate2 != null)
			return fDate.getString(BakDate2);
		else
			return null;
	}

	public void setBakDate2(Date aBakDate2)
	{
		BakDate2 = aBakDate2;
	}

	public void setBakDate2(String aBakDate2)
	{
		if (aBakDate2 != null && !aBakDate2.equals(""))
			BakDate2 = fDate.getDate(aBakDate2);
		else
			BakDate2 = null;
	}

	public String getBakTime2()
	{
		if (BakTime2 != null)
			BakTime2.equals("");
		return BakTime2;
	}

	public void setBakTime2(String aBakTime2)
	{
		BakTime2 = aBakTime2;
	}

	public int getBakInt1()
	{
		return BakInt1;
	}

	public void setBakInt1(int aBakInt1)
	{
		BakInt1 = aBakInt1;
	}

	public void setBakInt1(String aBakInt1)
	{
		if (aBakInt1 != null && !aBakInt1.equals(""))
		{
			Integer tInteger = new Integer(aBakInt1);
			int i = tInteger.intValue();
			BakInt1 = i;
		}
	}

	public int getBakInt2()
	{
		return BakInt2;
	}

	public void setBakInt2(int aBakInt2)
	{
		BakInt2 = aBakInt2;
	}

	public void setBakInt2(String aBakInt2)
	{
		if (aBakInt2 != null && !aBakInt2.equals(""))
		{
			Integer tInteger = new Integer(aBakInt2);
			int i = tInteger.intValue();
			BakInt2 = i;
		}
	}

	public void setSchema(LNPPolicyStateSchema aLNPPolicyStateSchema)
	{
		ContNo = aLNPPolicyStateSchema.getContNo();
		State = aLNPPolicyStateSchema.getState();
		Operator = aLNPPolicyStateSchema.getOperator();
		ManageCom = aLNPPolicyStateSchema.getManageCom();
		ModifyDate = fDate.getDate(aLNPPolicyStateSchema.getModifyDate());
		ModifyTime = aLNPPolicyStateSchema.getModifyTime();
		AppntId = aLNPPolicyStateSchema.getAppntId();
		InsuredId = aLNPPolicyStateSchema.getInsuredId();
		BenefitId = aLNPPolicyStateSchema.getBenefitId();
		MakeDate = fDate.getDate(aLNPPolicyStateSchema.getMakeDate());
		MakeTime = aLNPPolicyStateSchema.getMakeTime();
		BakString1 = aLNPPolicyStateSchema.getBakString1();
		BakString2 = aLNPPolicyStateSchema.getBakString2();
		BakDate1 = fDate.getDate(aLNPPolicyStateSchema.getBakDate1());
		BakTime1 = aLNPPolicyStateSchema.getBakTime1();
		BakDate2 = fDate.getDate(aLNPPolicyStateSchema.getBakDate2());
		BakTime2 = aLNPPolicyStateSchema.getBakTime2();
		BakInt1 = aLNPPolicyStateSchema.getBakInt1();
		BakInt2 = aLNPPolicyStateSchema.getBakInt2();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ContNo") == null)
				ContNo = null;
			else
				ContNo = rs.getString("ContNo").trim();
			if (rs.getString("State") == null)
				State = null;
			else
				State = rs.getString("State").trim();
			if (rs.getString("Operator") == null)
				Operator = null;
			else
				Operator = rs.getString("Operator").trim();
			if (rs.getString("ManageCom") == null)
				ManageCom = null;
			else
				ManageCom = rs.getString("ManageCom").trim();
			ModifyDate = rs.getDate("ModifyDate");
			if (rs.getString("ModifyTime") == null)
				ModifyTime = null;
			else
				ModifyTime = rs.getString("ModifyTime").trim();
			if (rs.getString("AppntId") == null)
				AppntId = null;
			else
				AppntId = rs.getString("AppntId").trim();
			if (rs.getString("InsuredId") == null)
				InsuredId = null;
			else
				InsuredId = rs.getString("InsuredId").trim();
			if (rs.getString("BenefitId") == null)
				BenefitId = null;
			else
				BenefitId = rs.getString("BenefitId").trim();
			MakeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				MakeTime = null;
			else
				MakeTime = rs.getString("MakeTime").trim();
			if (rs.getString("BakString1") == null)
				BakString1 = null;
			else
				BakString1 = rs.getString("BakString1").trim();
			if (rs.getString("BakString2") == null)
				BakString2 = null;
			else
				BakString2 = rs.getString("BakString2").trim();
			BakDate1 = rs.getDate("BakDate1");
			if (rs.getString("BakTime1") == null)
				BakTime1 = null;
			else
				BakTime1 = rs.getString("BakTime1").trim();
			BakDate2 = rs.getDate("BakDate2");
			if (rs.getString("BakTime2") == null)
				BakTime2 = null;
			else
				BakTime2 = rs.getString("BakTime2").trim();
			BakInt1 = rs.getInt("BakInt1");
			BakInt2 = rs.getInt("BakInt2");
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPolicyStateSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPPolicyStateSchema getSchema()
	{
		LNPPolicyStateSchema aLNPPolicyStateSchema = new LNPPolicyStateSchema();
		aLNPPolicyStateSchema.setSchema(this);
		return aLNPPolicyStateSchema;
	}

	public LNPPolicyStateDB getDB()
	{
		LNPPolicyStateDB aDBOper = new LNPPolicyStateDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(ContNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(State))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(Operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ManageCom))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(ModifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ModifyTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(AppntId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(InsuredId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BenefitId))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(MakeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MakeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BakString1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BakString2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(BakDate1)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BakTime1))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(BakDate2)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BakTime2))).append("|").append(ChgData.chgData(BakInt1)).append("|").append(ChgData.chgData(BakInt2)).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			State = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			AppntId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			InsuredId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			BenefitId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			BakString1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			BakString2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			BakDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
			BakTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			BakDate2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
			BakTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			BakInt1 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|")))).intValue();
			BakInt2 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|")))).intValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPolicyStateSchema";
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
		if (FCode.equals("State"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(State));
		if (FCode.equals("Operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		if (FCode.equals("ManageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		if (FCode.equals("ModifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equals("ModifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime));
		if (FCode.equals("AppntId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(AppntId));
		if (FCode.equals("InsuredId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuredId));
		if (FCode.equals("BenefitId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BenefitId));
		if (FCode.equals("MakeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equals("MakeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		if (FCode.equals("BakString1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BakString1));
		if (FCode.equals("BakString2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BakString2));
		if (FCode.equals("BakDate1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getBakDate1()));
		if (FCode.equals("BakTime1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BakTime1));
		if (FCode.equals("BakDate2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getBakDate2()));
		if (FCode.equals("BakTime2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BakTime2));
		if (FCode.equals("BakInt1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BakInt1));
		if (FCode.equals("BakInt2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BakInt2));
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
			strFieldValue = StrTool.GBKToUnicode(State);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(Operator);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(ManageCom);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(ModifyTime);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(AppntId);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(InsuredId);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(BenefitId);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(MakeTime);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(BakString1);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(BakString2);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBakDate1()));
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(BakTime1);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getBakDate2()));
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(BakTime2);
			break;

		case 17: // '\021'
			strFieldValue = String.valueOf(BakInt1);
			break;

		case 18: // '\022'
			strFieldValue = String.valueOf(BakInt2);
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
		if (FCode.equals("State"))
			if (FValue != null && !FValue.equals(""))
				State = FValue.trim();
			else
				State = null;
		if (FCode.equals("Operator"))
			if (FValue != null && !FValue.equals(""))
				Operator = FValue.trim();
			else
				Operator = null;
		if (FCode.equals("ManageCom"))
			if (FValue != null && !FValue.equals(""))
				ManageCom = FValue.trim();
			else
				ManageCom = null;
		if (FCode.equals("ModifyDate"))
			if (FValue != null && !FValue.equals(""))
				ModifyDate = fDate.getDate(FValue);
			else
				ModifyDate = null;
		if (FCode.equals("ModifyTime"))
			if (FValue != null && !FValue.equals(""))
				ModifyTime = FValue.trim();
			else
				ModifyTime = null;
		if (FCode.equals("AppntId"))
			if (FValue != null && !FValue.equals(""))
				AppntId = FValue.trim();
			else
				AppntId = null;
		if (FCode.equals("InsuredId"))
			if (FValue != null && !FValue.equals(""))
				InsuredId = FValue.trim();
			else
				InsuredId = null;
		if (FCode.equals("BenefitId"))
			if (FValue != null && !FValue.equals(""))
				BenefitId = FValue.trim();
			else
				BenefitId = null;
		if (FCode.equals("MakeDate"))
			if (FValue != null && !FValue.equals(""))
				MakeDate = fDate.getDate(FValue);
			else
				MakeDate = null;
		if (FCode.equals("MakeTime"))
			if (FValue != null && !FValue.equals(""))
				MakeTime = FValue.trim();
			else
				MakeTime = null;
		if (FCode.equals("BakString1"))
			if (FValue != null && !FValue.equals(""))
				BakString1 = FValue.trim();
			else
				BakString1 = null;
		if (FCode.equals("BakString2"))
			if (FValue != null && !FValue.equals(""))
				BakString2 = FValue.trim();
			else
				BakString2 = null;
		if (FCode.equals("BakDate1"))
			if (FValue != null && !FValue.equals(""))
				BakDate1 = fDate.getDate(FValue);
			else
				BakDate1 = null;
		if (FCode.equals("BakTime1"))
			if (FValue != null && !FValue.equals(""))
				BakTime1 = FValue.trim();
			else
				BakTime1 = null;
		if (FCode.equals("BakDate2"))
			if (FValue != null && !FValue.equals(""))
				BakDate2 = fDate.getDate(FValue);
			else
				BakDate2 = null;
		if (FCode.equals("BakTime2"))
			if (FValue != null && !FValue.equals(""))
				BakTime2 = FValue.trim();
			else
				BakTime2 = null;
		if (FCode.equals("BakInt1") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			BakInt1 = i;
		}
		if (FCode.equals("BakInt2") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			BakInt2 = i;
		}
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
		LNPPolicyStateSchema other = (LNPPolicyStateSchema)otherObject;
		return ContNo.equals(other.getContNo()) && State.equals(other.getState()) && Operator.equals(other.getOperator()) && ManageCom.equals(other.getManageCom()) && fDate.getString(ModifyDate).equals(other.getModifyDate()) && ModifyTime.equals(other.getModifyTime()) && AppntId.equals(other.getAppntId()) && InsuredId.equals(other.getInsuredId()) && BenefitId.equals(other.getBenefitId()) && fDate.getString(MakeDate).equals(other.getMakeDate()) && MakeTime.equals(other.getMakeTime()) && BakString1.equals(other.getBakString1()) && BakString2.equals(other.getBakString2()) && fDate.getString(BakDate1).equals(other.getBakDate1()) && BakTime1.equals(other.getBakTime1()) && fDate.getString(BakDate2).equals(other.getBakDate2()) && BakTime2.equals(other.getBakTime2()) && BakInt1 == other.getBakInt1() && BakInt2 == other.getBakInt2();
	}

	public int getFieldCount()
	{
		return 19;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("ContNo"))
			return 0;
		if (strFieldName.equals("State"))
			return 1;
		if (strFieldName.equals("Operator"))
			return 2;
		if (strFieldName.equals("ManageCom"))
			return 3;
		if (strFieldName.equals("ModifyDate"))
			return 4;
		if (strFieldName.equals("ModifyTime"))
			return 5;
		if (strFieldName.equals("AppntId"))
			return 6;
		if (strFieldName.equals("InsuredId"))
			return 7;
		if (strFieldName.equals("BenefitId"))
			return 8;
		if (strFieldName.equals("MakeDate"))
			return 9;
		if (strFieldName.equals("MakeTime"))
			return 10;
		if (strFieldName.equals("BakString1"))
			return 11;
		if (strFieldName.equals("BakString2"))
			return 12;
		if (strFieldName.equals("BakDate1"))
			return 13;
		if (strFieldName.equals("BakTime1"))
			return 14;
		if (strFieldName.equals("BakDate2"))
			return 15;
		if (strFieldName.equals("BakTime2"))
			return 16;
		if (strFieldName.equals("BakInt1"))
			return 17;
		return !strFieldName.equals("BakInt2") ? -1 : 18;
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
			strFieldName = "State";
			break;

		case 2: // '\002'
			strFieldName = "Operator";
			break;

		case 3: // '\003'
			strFieldName = "ManageCom";
			break;

		case 4: // '\004'
			strFieldName = "ModifyDate";
			break;

		case 5: // '\005'
			strFieldName = "ModifyTime";
			break;

		case 6: // '\006'
			strFieldName = "AppntId";
			break;

		case 7: // '\007'
			strFieldName = "InsuredId";
			break;

		case 8: // '\b'
			strFieldName = "BenefitId";
			break;

		case 9: // '\t'
			strFieldName = "MakeDate";
			break;

		case 10: // '\n'
			strFieldName = "MakeTime";
			break;

		case 11: // '\013'
			strFieldName = "BakString1";
			break;

		case 12: // '\f'
			strFieldName = "BakString2";
			break;

		case 13: // '\r'
			strFieldName = "BakDate1";
			break;

		case 14: // '\016'
			strFieldName = "BakTime1";
			break;

		case 15: // '\017'
			strFieldName = "BakDate2";
			break;

		case 16: // '\020'
			strFieldName = "BakTime2";
			break;

		case 17: // '\021'
			strFieldName = "BakInt1";
			break;

		case 18: // '\022'
			strFieldName = "BakInt2";
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
		if (strFieldName.equals("State"))
			return 0;
		if (strFieldName.equals("Operator"))
			return 0;
		if (strFieldName.equals("ManageCom"))
			return 0;
		if (strFieldName.equals("ModifyDate"))
			return 1;
		if (strFieldName.equals("ModifyTime"))
			return 0;
		if (strFieldName.equals("AppntId"))
			return 0;
		if (strFieldName.equals("InsuredId"))
			return 0;
		if (strFieldName.equals("BenefitId"))
			return 0;
		if (strFieldName.equals("MakeDate"))
			return 1;
		if (strFieldName.equals("MakeTime"))
			return 0;
		if (strFieldName.equals("BakString1"))
			return 0;
		if (strFieldName.equals("BakString2"))
			return 0;
		if (strFieldName.equals("BakDate1"))
			return 1;
		if (strFieldName.equals("BakTime1"))
			return 0;
		if (strFieldName.equals("BakDate2"))
			return 1;
		if (strFieldName.equals("BakTime2"))
			return 0;
		if (strFieldName.equals("BakInt1"))
			return 3;
		return !strFieldName.equals("BakInt2") ? -1 : 3;
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
			nFieldType = 1;
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
			nFieldType = 1;
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
			nFieldType = 1;
			break;

		case 14: // '\016'
			nFieldType = 0;
			break;

		case 15: // '\017'
			nFieldType = 1;
			break;

		case 16: // '\020'
			nFieldType = 0;
			break;

		case 17: // '\021'
			nFieldType = 3;
			break;

		case 18: // '\022'
			nFieldType = 3;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
