// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentInfoBSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPAgentInfoBDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPAgentInfoBSchema
	implements Schema
{

	private String EdorNo;
	private String serialNo;
	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private String prtNo;
	private String agentOrder;
	private String agentName;
	private String agentCode;
	private String branchName;
	private String branchAttr;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String p2;
	private String p4;
	private String p3;
	private String p1;
	public static final int FIELDNUM = 20;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPAgentInfoBSchema()
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

	public String getagentOrder()
	{
		if (agentOrder != null)
			agentOrder.equals("");
		return agentOrder;
	}

	public void setagentOrder(String aagentOrder)
	{
		agentOrder = aagentOrder;
	}

	public String getagentName()
	{
		if (agentName != null)
			agentName.equals("");
		return agentName;
	}

	public void setagentName(String aagentName)
	{
		agentName = aagentName;
	}

	public String getagentCode()
	{
		if (agentCode != null)
			agentCode.equals("");
		return agentCode;
	}

	public void setagentCode(String aagentCode)
	{
		agentCode = aagentCode;
	}

	public String getbranchName()
	{
		if (branchName != null)
			branchName.equals("");
		return branchName;
	}

	public void setbranchName(String abranchName)
	{
		branchName = abranchName;
	}

	public String getbranchAttr()
	{
		if (branchAttr != null)
			branchAttr.equals("");
		return branchAttr;
	}

	public void setbranchAttr(String abranchAttr)
	{
		branchAttr = abranchAttr;
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

	public void setSchema(LNPAgentInfoBSchema aLNPAgentInfoBSchema)
	{
		EdorNo = aLNPAgentInfoBSchema.getEdorNo();
		serialNo = aLNPAgentInfoBSchema.getserialNo();
		grpContNo = aLNPAgentInfoBSchema.getgrpContNo();
		contNo = aLNPAgentInfoBSchema.getcontNo();
		proposalContNo = aLNPAgentInfoBSchema.getproposalContNo();
		prtNo = aLNPAgentInfoBSchema.getprtNo();
		agentOrder = aLNPAgentInfoBSchema.getagentOrder();
		agentName = aLNPAgentInfoBSchema.getagentName();
		agentCode = aLNPAgentInfoBSchema.getagentCode();
		branchName = aLNPAgentInfoBSchema.getbranchName();
		branchAttr = aLNPAgentInfoBSchema.getbranchAttr();
		operator = aLNPAgentInfoBSchema.getoperator();
		makeDate = fDate.getDate(aLNPAgentInfoBSchema.getmakeDate());
		makeTime = aLNPAgentInfoBSchema.getmakeTime();
		modifyDate = fDate.getDate(aLNPAgentInfoBSchema.getmodifyDate());
		modifyTime = aLNPAgentInfoBSchema.getmodifyTime();
		p2 = aLNPAgentInfoBSchema.getp2();
		p4 = aLNPAgentInfoBSchema.getp4();
		p3 = aLNPAgentInfoBSchema.getp3();
		p1 = aLNPAgentInfoBSchema.getp1();
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
			if (rs.getString("agentOrder") == null)
				agentOrder = null;
			else
				agentOrder = rs.getString("agentOrder").trim();
			if (rs.getString("agentName") == null)
				agentName = null;
			else
				agentName = rs.getString("agentName").trim();
			if (rs.getString("agentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("agentCode").trim();
			if (rs.getString("branchName") == null)
				branchName = null;
			else
				branchName = rs.getString("branchName").trim();
			if (rs.getString("branchAttr") == null)
				branchAttr = null;
			else
				branchAttr = rs.getString("branchAttr").trim();
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
			tError.moduleName = "LNPAgentInfoBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPAgentInfoBSchema getSchema()
	{
		LNPAgentInfoBSchema aLNPAgentInfoBSchema = new LNPAgentInfoBSchema();
		aLNPAgentInfoBSchema.setSchema(this);
		return aLNPAgentInfoBSchema;
	}

	public LNPAgentInfoBDB getDB()
	{
		LNPAgentInfoBDB aDBOper = new LNPAgentInfoBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(EdorNo))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(serialNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(grpContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(contNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(proposalContNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(prtNo))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentOrder))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(agentCode))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(branchName))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(branchAttr))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(operator))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(makeDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(makeTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(fDate.getString(modifyDate)))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(modifyTime))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p2))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p4))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p3))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(p1))).toString();
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
			agentOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			agentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			branchName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentInfoBSchema";
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
		if (FCode.equals("agentOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentOrder));
		if (FCode.equals("agentName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentName));
		if (FCode.equals("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equals("branchName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchName));
		if (FCode.equals("branchAttr"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchAttr));
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
			strFieldValue = StrTool.GBKToUnicode(agentOrder);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(agentName);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(branchName);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(branchAttr);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(p2);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(p4);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(p3);
			break;

		case 19: // '\023'
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
		if (FCode.equals("agentOrder"))
			if (FValue != null && !FValue.equals(""))
				agentOrder = FValue.trim();
			else
				agentOrder = null;
		if (FCode.equals("agentName"))
			if (FValue != null && !FValue.equals(""))
				agentName = FValue.trim();
			else
				agentName = null;
		if (FCode.equals("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equals("branchName"))
			if (FValue != null && !FValue.equals(""))
				branchName = FValue.trim();
			else
				branchName = null;
		if (FCode.equals("branchAttr"))
			if (FValue != null && !FValue.equals(""))
				branchAttr = FValue.trim();
			else
				branchAttr = null;
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
		LNPAgentInfoBSchema other = (LNPAgentInfoBSchema)otherObject;
		return EdorNo.equals(other.getEdorNo()) && serialNo.equals(other.getserialNo()) && grpContNo.equals(other.getgrpContNo()) && contNo.equals(other.getcontNo()) && proposalContNo.equals(other.getproposalContNo()) && prtNo.equals(other.getprtNo()) && agentOrder.equals(other.getagentOrder()) && agentName.equals(other.getagentName()) && agentCode.equals(other.getagentCode()) && branchName.equals(other.getbranchName()) && branchAttr.equals(other.getbranchAttr()) && operator.equals(other.getoperator()) && fDate.getString(makeDate).equals(other.getmakeDate()) && makeTime.equals(other.getmakeTime()) && fDate.getString(modifyDate).equals(other.getmodifyDate()) && modifyTime.equals(other.getmodifyTime()) && p2.equals(other.getp2()) && p4.equals(other.getp4()) && p3.equals(other.getp3()) && p1.equals(other.getp1());
	}

	public int getFieldCount()
	{
		return 20;
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
		if (strFieldName.equals("agentOrder"))
			return 6;
		if (strFieldName.equals("agentName"))
			return 7;
		if (strFieldName.equals("agentCode"))
			return 8;
		if (strFieldName.equals("branchName"))
			return 9;
		if (strFieldName.equals("branchAttr"))
			return 10;
		if (strFieldName.equals("operator"))
			return 11;
		if (strFieldName.equals("makeDate"))
			return 12;
		if (strFieldName.equals("makeTime"))
			return 13;
		if (strFieldName.equals("modifyDate"))
			return 14;
		if (strFieldName.equals("modifyTime"))
			return 15;
		if (strFieldName.equals("p2"))
			return 16;
		if (strFieldName.equals("p4"))
			return 17;
		if (strFieldName.equals("p3"))
			return 18;
		return !strFieldName.equals("p1") ? -1 : 19;
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
			strFieldName = "agentOrder";
			break;

		case 7: // '\007'
			strFieldName = "agentName";
			break;

		case 8: // '\b'
			strFieldName = "agentCode";
			break;

		case 9: // '\t'
			strFieldName = "branchName";
			break;

		case 10: // '\n'
			strFieldName = "branchAttr";
			break;

		case 11: // '\013'
			strFieldName = "operator";
			break;

		case 12: // '\f'
			strFieldName = "makeDate";
			break;

		case 13: // '\r'
			strFieldName = "makeTime";
			break;

		case 14: // '\016'
			strFieldName = "modifyDate";
			break;

		case 15: // '\017'
			strFieldName = "modifyTime";
			break;

		case 16: // '\020'
			strFieldName = "p2";
			break;

		case 17: // '\021'
			strFieldName = "p4";
			break;

		case 18: // '\022'
			strFieldName = "p3";
			break;

		case 19: // '\023'
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
		if (strFieldName.equals("agentOrder"))
			return 0;
		if (strFieldName.equals("agentName"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("branchName"))
			return 0;
		if (strFieldName.equals("branchAttr"))
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
			nFieldType = 0;
			break;

		case 12: // '\f'
			nFieldType = 1;
			break;

		case 13: // '\r'
			nFieldType = 0;
			break;

		case 14: // '\016'
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
