// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPBonusInfoBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPBonusInfoBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPBonusInfoBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private String prtNo;
	private String bonusType;
	private String bonusWay;
	private String autoRepaid;
	private String cutPayAll;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String p2;
	private String p4;
	private String p3;
	private String p1;
	public static final int FIELDNUM = 19;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPBonusInfoBSchema()
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

	public String getgrpContNo()
	{
		if (grpContNo != null)
			grpContNo.equals("");
		return grpContNo;
	}

	public void setgrpContNo(String agrpContNo)
	{
		grpContNo = agrpContNo;
	}

	public String getcontNo()
	{
		if (contNo != null)
			contNo.equals("");
		return contNo;
	}

	public void setcontNo(String acontNo)
	{
		contNo = acontNo;
	}

	public String getproposalContNo()
	{
		if (proposalContNo != null)
			proposalContNo.equals("");
		return proposalContNo;
	}

	public void setproposalContNo(String aproposalContNo)
	{
		proposalContNo = aproposalContNo;
	}

	public String getprtNo()
	{
		if (prtNo != null)
			prtNo.equals("");
		return prtNo;
	}

	public void setprtNo(String aprtNo)
	{
		prtNo = aprtNo;
	}

	public String getbonusType()
	{
		if (bonusType != null)
			bonusType.equals("");
		return bonusType;
	}

	public void setbonusType(String abonusType)
	{
		bonusType = abonusType;
	}

	public String getbonusWay()
	{
		if (bonusWay != null)
			bonusWay.equals("");
		return bonusWay;
	}

	public void setbonusWay(String abonusWay)
	{
		bonusWay = abonusWay;
	}

	public String getautoRepaid()
	{
		if (autoRepaid != null)
			autoRepaid.equals("");
		return autoRepaid;
	}

	public void setautoRepaid(String aautoRepaid)
	{
		autoRepaid = aautoRepaid;
	}

	public String getcutPayAll()
	{
		if (cutPayAll != null)
			cutPayAll.equals("");
		return cutPayAll;
	}

	public void setcutPayAll(String acutPayAll)
	{
		cutPayAll = acutPayAll;
	}

	public String getoperator()
	{
		if (operator != null)
			operator.equals("");
		return operator;
	}

	public void setoperator(String aoperator)
	{
		operator = aoperator;
	}

	public String getmakeDate()
	{
		if (makeDate != null)
			return fDate.getString(makeDate);
		else
			return null;
	}

	public void setmakeDate(Date amakeDate)
	{
		makeDate = amakeDate;
	}

	public void setmakeDate(String amakeDate)
	{
		if (amakeDate != null && !amakeDate.equals(""))
			makeDate = fDate.getDate(amakeDate);
		else
			makeDate = null;
	}

	public String getmakeTime()
	{
		if (makeTime != null)
			makeTime.equals("");
		return makeTime;
	}

	public void setmakeTime(String amakeTime)
	{
		makeTime = amakeTime;
	}

	public String getmodifyDate()
	{
		if (modifyDate != null)
			return fDate.getString(modifyDate);
		else
			return null;
	}

	public void setmodifyDate(Date amodifyDate)
	{
		modifyDate = amodifyDate;
	}

	public void setmodifyDate(String amodifyDate)
	{
		if (amodifyDate != null && !amodifyDate.equals(""))
			modifyDate = fDate.getDate(amodifyDate);
		else
			modifyDate = null;
	}

	public String getmodifyTime()
	{
		if (modifyTime != null)
			modifyTime.equals("");
		return modifyTime;
	}

	public void setmodifyTime(String amodifyTime)
	{
		modifyTime = amodifyTime;
	}

	public String getp2()
	{
		if (p2 != null)
			p2.equals("");
		return p2;
	}

	public void setp2(String ap2)
	{
		p2 = ap2;
	}

	public String getp4()
	{
		if (p4 != null)
			p4.equals("");
		return p4;
	}

	public void setp4(String ap4)
	{
		p4 = ap4;
	}

	public String getp3()
	{
		if (p3 != null)
			p3.equals("");
		return p3;
	}

	public void setp3(String ap3)
	{
		p3 = ap3;
	}

	public String getp1()
	{
		if (p1 != null)
			p1.equals("");
		return p1;
	}

	public void setp1(String ap1)
	{
		p1 = ap1;
	}

	public void setSchema(LNPBonusInfoBSchema aLNPBonusInfoBSchema)
	{
		EdorNo = aLNPBonusInfoBSchema.getEdorNo();
		serialNo = aLNPBonusInfoBSchema.getserialNo();
		grpContNo = aLNPBonusInfoBSchema.getgrpContNo();
		contNo = aLNPBonusInfoBSchema.getcontNo();
		proposalContNo = aLNPBonusInfoBSchema.getproposalContNo();
		prtNo = aLNPBonusInfoBSchema.getprtNo();
		bonusType = aLNPBonusInfoBSchema.getbonusType();
		bonusWay = aLNPBonusInfoBSchema.getbonusWay();
		autoRepaid = aLNPBonusInfoBSchema.getautoRepaid();
		cutPayAll = aLNPBonusInfoBSchema.getcutPayAll();
		operator = aLNPBonusInfoBSchema.getoperator();
		makeDate = fDate.getDate(aLNPBonusInfoBSchema.getmakeDate());
		makeTime = aLNPBonusInfoBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPBonusInfoBSchema.getmodifyDate());
		modifyTime = aLNPBonusInfoBSchema.getmodifyTime();
		p2 = aLNPBonusInfoBSchema.getp2();
		p4 = aLNPBonusInfoBSchema.getp4();
		p3 = aLNPBonusInfoBSchema.getp3();
		p1 = aLNPBonusInfoBSchema.getp1();
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
			if (rs.getString("grpContNo") == null)
				grpContNo = null;
			else
				grpContNo = rs.getString("grpContNo").trim();
			if (rs.getString("contNo") == null)
				contNo = null;
			else
				contNo = rs.getString("contNo").trim();
			if (rs.getString("proposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("proposalContNo").trim();
			if (rs.getString("prtNo") == null)
				prtNo = null;
			else
				prtNo = rs.getString("prtNo").trim();
			if (rs.getString("bonusType") == null)
				bonusType = null;
			else
				bonusType = rs.getString("bonusType").trim();
			if (rs.getString("bonusWay") == null)
				bonusWay = null;
			else
				bonusWay = rs.getString("bonusWay").trim();
			if (rs.getString("autoRepaid") == null)
				autoRepaid = null;
			else
				autoRepaid = rs.getString("autoRepaid").trim();
			if (rs.getString("cutPayAll") == null)
				cutPayAll = null;
			else
				cutPayAll = rs.getString("cutPayAll").trim();
			if (rs.getString("operator") == null)
				operator = null;
			else
				operator = rs.getString("operator").trim();
			makeDate = rs.getDate("makeDate");
			if (rs.getString("makeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("makeTime").trim();
			modifyDate = rs.getDate("modifyDate");
			if (rs.getString("modifyTime") == null)
				modifyTime = null;
			else
				modifyTime = rs.getString("modifyTime").trim();
			if (rs.getString("p2") == null)
				p2 = null;
			else
				p2 = rs.getString("p2").trim();
			if (rs.getString("p4") == null)
				p4 = null;
			else
				p4 = rs.getString("p4").trim();
			if (rs.getString("p3") == null)
				p3 = null;
			else
				p3 = rs.getString("p3").trim();
			if (rs.getString("p1") == null)
				p1 = null;
			else
				p1 = rs.getString("p1").trim();
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPBonusInfoBSchema getSchema()
	{
		LNPBonusInfoBSchema aLNPBonusInfoBSchema = new LNPBonusInfoBSchema();
		aLNPBonusInfoBSchema.setSchema(this);
		return aLNPBonusInfoBSchema;
	}

	public LNPBonusInfoBDB getDB()
	{
		LNPBonusInfoBDB aDBOper = new LNPBonusInfoBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proposalContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(prtNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bonusType))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(bonusWay))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(autoRepaid))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(cutPayAll))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p4))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p1))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			bonusType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			bonusWay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			autoRepaid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			cutPayAll = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoBSchema";
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
		if (FCode.equals("grpContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpContNo));
		if (FCode.equals("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equals("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equals("prtNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prtNo));
		if (FCode.equals("bonusType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusType));
		if (FCode.equals("bonusWay"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusWay));
		if (FCode.equals("autoRepaid"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(autoRepaid));
		if (FCode.equals("cutPayAll"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(cutPayAll));
		if (FCode.equals("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equals("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
		if (FCode.equals("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equals("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
		if (FCode.equals("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
		if (FCode.equals("p2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p2));
		if (FCode.equals("p4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p4));
		if (FCode.equals("p3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p3));
		if (FCode.equals("p1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p1));
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
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(prtNo);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(bonusType);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(bonusWay);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(autoRepaid);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(cutPayAll);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(p2);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(p4);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(p3);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(p1);
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
		if (FCode.equals("grpContNo"))
			if (FValue != null && !FValue.equals(""))
				grpContNo = FValue.trim();
			else
				grpContNo = null;
		if (FCode.equals("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equals("proposalContNo"))
			if (FValue != null && !FValue.equals(""))
				proposalContNo = FValue.trim();
			else
				proposalContNo = null;
		if (FCode.equals("prtNo"))
			if (FValue != null && !FValue.equals(""))
				prtNo = FValue.trim();
			else
				prtNo = null;
		if (FCode.equals("bonusType"))
			if (FValue != null && !FValue.equals(""))
				bonusType = FValue.trim();
			else
				bonusType = null;
		if (FCode.equals("bonusWay"))
			if (FValue != null && !FValue.equals(""))
				bonusWay = FValue.trim();
			else
				bonusWay = null;
		if (FCode.equals("autoRepaid"))
			if (FValue != null && !FValue.equals(""))
				autoRepaid = FValue.trim();
			else
				autoRepaid = null;
		if (FCode.equals("cutPayAll"))
			if (FValue != null && !FValue.equals(""))
				cutPayAll = FValue.trim();
			else
				cutPayAll = null;
		if (FCode.equals("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equals("makeDate"))
			if (FValue != null && !FValue.equals(""))
				makeDate = fDate.getDate(FValue);
			else
				makeDate = null;
		if (FCode.equals("makeTime"))
			if (FValue != null && !FValue.equals(""))
				makeTime = FValue.trim();
			else
				makeTime = null;
		if (FCode.equals("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equals("modifyTime"))
			if (FValue != null && !FValue.equals(""))
				modifyTime = FValue.trim();
			else
				modifyTime = null;
		if (FCode.equals("p2"))
			if (FValue != null && !FValue.equals(""))
				p2 = FValue.trim();
			else
				p2 = null;
		if (FCode.equals("p4"))
			if (FValue != null && !FValue.equals(""))
				p4 = FValue.trim();
			else
				p4 = null;
		if (FCode.equals("p3"))
			if (FValue != null && !FValue.equals(""))
				p3 = FValue.trim();
			else
				p3 = null;
		if (FCode.equals("p1"))
			if (FValue != null && !FValue.equals(""))
				p1 = FValue.trim();
			else
				p1 = null;
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
		LNPBonusInfoBSchema other = (LNPBonusInfoBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && grpContNo.equals(other.getgrpContNo()) && contNo.equals(other.getcontNo()) && proposalContNo.equals(other.getproposalContNo()) && prtNo.equals(other.getprtNo()) && bonusType.equals(other.getbonusType()) && bonusWay.equals(other.getbonusWay()) && autoRepaid.equals(other.getautoRepaid()) && cutPayAll.equals(other.getcutPayAll()) && operator.equals(other.getoperator()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime()) && p2.equals(other.getp2()) && p4.equals(other.getp4()) && p3.equals(other.getp3()) && p1.equals(other.getp1());
	}

	public int getFieldCount()
	{
		return 19;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("EdorNo"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 1;
		if (strFieldName.equals("grpContNo"))
			return 2;
		if (strFieldName.equals("contNo"))
			return 3;
		if (strFieldName.equals("proposalContNo"))
			return 4;
		if (strFieldName.equals("prtNo"))
			return 5;
		if (strFieldName.equals("bonusType"))
			return 6;
		if (strFieldName.equals("bonusWay"))
			return 7;
		if (strFieldName.equals("autoRepaid"))
			return 8;
		if (strFieldName.equals("cutPayAll"))
			return 9;
		if (strFieldName.equals("operator"))
			return 10;
		if (strFieldName.equals("makeDate"))
			return 11;
		if (strFieldName.equals("makeTime"))
			return 12;
		if (strFieldName.equals("modifyDate"))
			return 13;
		if (strFieldName.equals("modifyTime"))
			return 14;
		if (strFieldName.equals("p2"))
			return 15;
		if (strFieldName.equals("p4"))
			return 16;
		if (strFieldName.equals("p3"))
			return 17;
		return !strFieldName.equals("p1") ? -1 : 18;
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
			strFieldName = "grpContNo";
			break;

		case 3: // '\003'
			strFieldName = "contNo";
			break;

		case 4: // '\004'
			strFieldName = "proposalContNo";
			break;

		case 5: // '\005'
			strFieldName = "prtNo";
			break;

		case 6: // '\006'
			strFieldName = "bonusType";
			break;

		case 7: // '\007'
			strFieldName = "bonusWay";
			break;

		case 8: // '\b'
			strFieldName = "autoRepaid";
			break;

		case 9: // '\t'
			strFieldName = "cutPayAll";
			break;

		case 10: // '\n'
			strFieldName = "operator";
			break;

		case 11: // '\013'
			strFieldName = "makeDate";
			break;

		case 12: // '\f'
			strFieldName = "makeTime";
			break;

		case 13: // '\r'
			strFieldName = "modifyDate";
			break;

		case 14: // '\016'
			strFieldName = "modifyTime";
			break;

		case 15: // '\017'
			strFieldName = "p2";
			break;

		case 16: // '\020'
			strFieldName = "p4";
			break;

		case 17: // '\021'
			strFieldName = "p3";
			break;

		case 18: // '\022'
			strFieldName = "p1";
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
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("proposalContNo"))
			return 0;
		if (strFieldName.equals("prtNo"))
			return 0;
		if (strFieldName.equals("bonusType"))
			return 0;
		if (strFieldName.equals("bonusWay"))
			return 0;
		if (strFieldName.equals("autoRepaid"))
			return 0;
		if (strFieldName.equals("cutPayAll"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		if (strFieldName.equals("modifyTime"))
			return 0;
		if (strFieldName.equals("p2"))
			return 0;
		if (strFieldName.equals("p4"))
			return 0;
		if (strFieldName.equals("p3"))
			return 0;
		return !strFieldName.equals("p1") ? -1 : 0;
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
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
