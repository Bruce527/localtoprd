// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentInfoSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPAgentInfoSchema
	implements Schema, Cloneable
{

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
	private String polPrintType;
	public static final int FIELDNUM = 19;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPAgentInfoSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "ContNo";
		pk[1] = "AgentOrder";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPAgentInfoSchema cloned = (LNPAgentInfoSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getGrpContNo()
	{
		return grpContNo;
	}

	public void setGrpContNo(String aGrpContNo)
	{
		grpContNo = aGrpContNo;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String aContNo)
	{
		contNo = aContNo;
	}

	public String getProposalContNo()
	{
		return proposalContNo;
	}

	public void setProposalContNo(String aProposalContNo)
	{
		proposalContNo = aProposalContNo;
	}

	public String getPrtNo()
	{
		return prtNo;
	}

	public void setPrtNo(String aPrtNo)
	{
		prtNo = aPrtNo;
	}

	public String getAgentOrder()
	{
		return agentOrder;
	}

	public void setAgentOrder(String aAgentOrder)
	{
		agentOrder = aAgentOrder;
	}

	public String getAgentName()
	{
		return agentName;
	}

	public void setAgentName(String aAgentName)
	{
		agentName = aAgentName;
	}

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
	}

	public String getBranchName()
	{
		return branchName;
	}

	public void setBranchName(String aBranchName)
	{
		branchName = aBranchName;
	}

	public String getBranchAttr()
	{
		return branchAttr;
	}

	public void setBranchAttr(String aBranchAttr)
	{
		branchAttr = aBranchAttr;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public String getMakeDate()
	{
		if (makeDate != null)
			return fDate.getString(makeDate);
		else
			return null;
	}

	public void setMakeDate(Date aMakeDate)
	{
		makeDate = aMakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals(""))
			makeDate = fDate.getDate(aMakeDate);
		else
			makeDate = null;
	}

	public String getMakeTime()
	{
		return makeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		makeTime = aMakeTime;
	}

	public String getModifyDate()
	{
		if (modifyDate != null)
			return fDate.getString(modifyDate);
		else
			return null;
	}

	public void setModifyDate(Date aModifyDate)
	{
		modifyDate = aModifyDate;
	}

	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals(""))
			modifyDate = fDate.getDate(aModifyDate);
		else
			modifyDate = null;
	}

	public String getModifyTime()
	{
		return modifyTime;
	}

	public void setModifyTime(String aModifyTime)
	{
		modifyTime = aModifyTime;
	}

	public String getP2()
	{
		return p2;
	}

	public void setP2(String aP2)
	{
		p2 = aP2;
	}

	public String getP4()
	{
		return p4;
	}

	public void setP4(String aP4)
	{
		p4 = aP4;
	}

	public String getP3()
	{
		return p3;
	}

	public void setP3(String aP3)
	{
		p3 = aP3;
	}

	public String getP1()
	{
		return p1;
	}

	public void setP1(String aP1)
	{
		p1 = aP1;
	}

	public String getPolPrintType()
	{
		return polPrintType;
	}

	public void setPolPrintType(String polPrintType)
	{
		this.polPrintType = polPrintType;
	}

	public void setSchema(LNPAgentInfoSchema aLNPAgentInfoSchema)
	{
		grpContNo = aLNPAgentInfoSchema.getGrpContNo();
		contNo = aLNPAgentInfoSchema.getContNo();
		proposalContNo = aLNPAgentInfoSchema.getProposalContNo();
		prtNo = aLNPAgentInfoSchema.getPrtNo();
		agentOrder = aLNPAgentInfoSchema.getAgentOrder();
		agentName = aLNPAgentInfoSchema.getAgentName();
		agentCode = aLNPAgentInfoSchema.getAgentCode();
		branchName = aLNPAgentInfoSchema.getBranchName();
		branchAttr = aLNPAgentInfoSchema.getBranchAttr();
		operator = aLNPAgentInfoSchema.getOperator();
		makeDate = fDate.getDate(aLNPAgentInfoSchema.getMakeDate());
		makeTime = aLNPAgentInfoSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPAgentInfoSchema.getModifyDate());
		modifyTime = aLNPAgentInfoSchema.getModifyTime();
		p2 = aLNPAgentInfoSchema.getP2();
		p4 = aLNPAgentInfoSchema.getP4();
		p3 = aLNPAgentInfoSchema.getP3();
		p1 = aLNPAgentInfoSchema.getP1();
		polPrintType = aLNPAgentInfoSchema.getPolPrintType();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("GrpContNo") == null)
				grpContNo = null;
			else
				grpContNo = rs.getString("GrpContNo").trim();
			if (rs.getString("ContNo") == null)
				contNo = null;
			else
				contNo = rs.getString("ContNo").trim();
			if (rs.getString("ProposalContNo") == null)
				proposalContNo = null;
			else
				proposalContNo = rs.getString("ProposalContNo").trim();
			if (rs.getString("PrtNo") == null)
				prtNo = null;
			else
				prtNo = rs.getString("PrtNo").trim();
			if (rs.getString("AgentOrder") == null)
				agentOrder = null;
			else
				agentOrder = rs.getString("AgentOrder").trim();
			if (rs.getString("AgentName") == null)
				agentName = null;
			else
				agentName = rs.getString("AgentName").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("BranchName") == null)
				branchName = null;
			else
				branchName = rs.getString("BranchName").trim();
			if (rs.getString("BranchAttr") == null)
				branchAttr = null;
			else
				branchAttr = rs.getString("BranchAttr").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			makeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("MakeTime").trim();
			modifyDate = rs.getDate("ModifyDate");
			if (rs.getString("ModifyTime") == null)
				modifyTime = null;
			else
				modifyTime = rs.getString("ModifyTime").trim();
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
			if (rs.getString("polPrintType") == null)
				polPrintType = null;
			else
				polPrintType = rs.getString("polPrintType").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("??????§Ö?LNPAgentInfo????¦È?????Schema?§Ö???¦È???????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPAgentInfoSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPAgentInfoSchema getSchema()
	{
		LNPAgentInfoSchema aLNPAgentInfoSchema = new LNPAgentInfoSchema();
		aLNPAgentInfoSchema.setSchema(this);
		return aLNPAgentInfoSchema;
	}

	public LNPAgentInfoDB getDB()
	{
		LNPAgentInfoDB aDBOper = new LNPAgentInfoDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(grpContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proposalContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(prtNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentOrder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchAttr));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(p2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(p4));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(p3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(p1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(polPrintType));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			prtNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			agentOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			agentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			branchName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			polPrintType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentInfoSchema";
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
		if (FCode.equalsIgnoreCase("grpContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpContNo));
		if (FCode.equalsIgnoreCase("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equalsIgnoreCase("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equalsIgnoreCase("prtNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prtNo));
		if (FCode.equalsIgnoreCase("agentOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentOrder));
		if (FCode.equalsIgnoreCase("agentName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentName));
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("branchName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchName));
		if (FCode.equalsIgnoreCase("branchAttr"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchAttr));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
		if (FCode.equalsIgnoreCase("p2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p2));
		if (FCode.equalsIgnoreCase("p4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p4));
		if (FCode.equalsIgnoreCase("p3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p3));
		if (FCode.equalsIgnoreCase("p1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p1));
		if (FCode.equalsIgnoreCase("polPrintType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polPrintType));
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
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(prtNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(agentOrder);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(agentName);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(branchName);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(branchAttr);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(p2);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(p4);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(p3);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(p1);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(polPrintType);
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
		if (FCode.equalsIgnoreCase("grpContNo"))
			if (FValue != null && !FValue.equals(""))
				grpContNo = FValue.trim();
			else
				grpContNo = null;
		if (FCode.equalsIgnoreCase("contNo"))
			if (FValue != null && !FValue.equals(""))
				contNo = FValue.trim();
			else
				contNo = null;
		if (FCode.equalsIgnoreCase("proposalContNo"))
			if (FValue != null && !FValue.equals(""))
				proposalContNo = FValue.trim();
			else
				proposalContNo = null;
		if (FCode.equalsIgnoreCase("prtNo"))
			if (FValue != null && !FValue.equals(""))
				prtNo = FValue.trim();
			else
				prtNo = null;
		if (FCode.equalsIgnoreCase("agentOrder"))
			if (FValue != null && !FValue.equals(""))
				agentOrder = FValue.trim();
			else
				agentOrder = null;
		if (FCode.equalsIgnoreCase("agentName"))
			if (FValue != null && !FValue.equals(""))
				agentName = FValue.trim();
			else
				agentName = null;
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equalsIgnoreCase("branchName"))
			if (FValue != null && !FValue.equals(""))
				branchName = FValue.trim();
			else
				branchName = null;
		if (FCode.equalsIgnoreCase("branchAttr"))
			if (FValue != null && !FValue.equals(""))
				branchAttr = FValue.trim();
			else
				branchAttr = null;
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equalsIgnoreCase("makeDate"))
			if (FValue != null && !FValue.equals(""))
				makeDate = fDate.getDate(FValue);
			else
				makeDate = null;
		if (FCode.equalsIgnoreCase("makeTime"))
			if (FValue != null && !FValue.equals(""))
				makeTime = FValue.trim();
			else
				makeTime = null;
		if (FCode.equalsIgnoreCase("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equalsIgnoreCase("modifyTime"))
			if (FValue != null && !FValue.equals(""))
				modifyTime = FValue.trim();
			else
				modifyTime = null;
		if (FCode.equalsIgnoreCase("p2"))
			if (FValue != null && !FValue.equals(""))
				p2 = FValue.trim();
			else
				p2 = null;
		if (FCode.equalsIgnoreCase("p4"))
			if (FValue != null && !FValue.equals(""))
				p4 = FValue.trim();
			else
				p4 = null;
		if (FCode.equalsIgnoreCase("p3"))
			if (FValue != null && !FValue.equals(""))
				p3 = FValue.trim();
			else
				p3 = null;
		if (FCode.equalsIgnoreCase("p1"))
			if (FValue != null && !FValue.equals(""))
				p1 = FValue.trim();
			else
				p1 = null;
		if (FCode.equalsIgnoreCase("polPrintType"))
			if (FValue != null && !FValue.equals(""))
				polPrintType = FValue.trim();
			else
				polPrintType = null;
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
		LNPAgentInfoSchema other = (LNPAgentInfoSchema)otherObject;
		if (grpContNo == null && other.getGrpContNo() != null)
			return false;
		if (grpContNo != null && !grpContNo.equals(other.getGrpContNo()))
			return false;
		if (contNo == null && other.getContNo() != null)
			return false;
		if (contNo != null && !contNo.equals(other.getContNo()))
			return false;
		if (proposalContNo == null && other.getProposalContNo() != null)
			return false;
		if (proposalContNo != null && !proposalContNo.equals(other.getProposalContNo()))
			return false;
		if (prtNo == null && other.getPrtNo() != null)
			return false;
		if (prtNo != null && !prtNo.equals(other.getPrtNo()))
			return false;
		if (agentOrder == null && other.getAgentOrder() != null)
			return false;
		if (agentOrder != null && !agentOrder.equals(other.getAgentOrder()))
			return false;
		if (agentName == null && other.getAgentName() != null)
			return false;
		if (agentName != null && !agentName.equals(other.getAgentName()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (branchName == null && other.getBranchName() != null)
			return false;
		if (branchName != null && !branchName.equals(other.getBranchName()))
			return false;
		if (branchAttr == null && other.getBranchAttr() != null)
			return false;
		if (branchAttr != null && !branchAttr.equals(other.getBranchAttr()))
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (makeDate == null && other.getMakeDate() != null)
			return false;
		if (makeDate != null && !fDate.getString(makeDate).equals(other.getMakeDate()))
			return false;
		if (makeTime == null && other.getMakeTime() != null)
			return false;
		if (makeTime != null && !makeTime.equals(other.getMakeTime()))
			return false;
		if (modifyDate == null && other.getModifyDate() != null)
			return false;
		if (modifyDate != null && !fDate.getString(modifyDate).equals(other.getModifyDate()))
			return false;
		if (modifyTime == null && other.getModifyTime() != null)
			return false;
		if (modifyTime != null && !modifyTime.equals(other.getModifyTime()))
			return false;
		if (p2 == null && other.getP2() != null)
			return false;
		if (p2 != null && !p2.equals(other.getP2()))
			return false;
		if (p4 == null && other.getP4() != null)
			return false;
		if (p4 != null && !p4.equals(other.getP4()))
			return false;
		if (p3 == null && other.getP3() != null)
			return false;
		if (p3 != null && !p3.equals(other.getP3()))
			return false;
		if (p1 == null && other.getP1() != null)
			return false;
		if (p1 != null && !p1.equals(other.getP1()))
			return false;
		return polPrintType == null || polPrintType.equals(other.getPolPrintType());
	}

	public int getFieldCount()
	{
		return 19;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 1;
		if (strFieldName.equals("proposalContNo"))
			return 2;
		if (strFieldName.equals("prtNo"))
			return 3;
		if (strFieldName.equals("agentOrder"))
			return 4;
		if (strFieldName.equals("agentName"))
			return 5;
		if (strFieldName.equals("agentCode"))
			return 6;
		if (strFieldName.equals("branchName"))
			return 7;
		if (strFieldName.equals("branchAttr"))
			return 8;
		if (strFieldName.equals("operator"))
			return 9;
		if (strFieldName.equals("makeDate"))
			return 10;
		if (strFieldName.equals("makeTime"))
			return 11;
		if (strFieldName.equals("modifyDate"))
			return 12;
		if (strFieldName.equals("modifyTime"))
			return 13;
		if (strFieldName.equals("p2"))
			return 14;
		if (strFieldName.equals("p4"))
			return 15;
		if (strFieldName.equals("p3"))
			return 16;
		if (strFieldName.equals("p1"))
			return 17;
		return !strFieldName.equals("polPrintType") ? -1 : 18;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "grpContNo";
			break;

		case 1: // '\001'
			strFieldName = "contNo";
			break;

		case 2: // '\002'
			strFieldName = "proposalContNo";
			break;

		case 3: // '\003'
			strFieldName = "prtNo";
			break;

		case 4: // '\004'
			strFieldName = "agentOrder";
			break;

		case 5: // '\005'
			strFieldName = "agentName";
			break;

		case 6: // '\006'
			strFieldName = "agentCode";
			break;

		case 7: // '\007'
			strFieldName = "branchName";
			break;

		case 8: // '\b'
			strFieldName = "branchAttr";
			break;

		case 9: // '\t'
			strFieldName = "operator";
			break;

		case 10: // '\n'
			strFieldName = "makeDate";
			break;

		case 11: // '\013'
			strFieldName = "makeTime";
			break;

		case 12: // '\f'
			strFieldName = "modifyDate";
			break;

		case 13: // '\r'
			strFieldName = "modifyTime";
			break;

		case 14: // '\016'
			strFieldName = "p2";
			break;

		case 15: // '\017'
			strFieldName = "p4";
			break;

		case 16: // '\020'
			strFieldName = "p3";
			break;

		case 17: // '\021'
			strFieldName = "p1";
			break;

		case 18: // '\022'
			strFieldName = "polPrintType";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
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
		if (strFieldName.equals("p1"))
			return 0;
		return !strFieldName.equals("polPrintType") ? -1 : 0;
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
			nFieldType = 1;
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
