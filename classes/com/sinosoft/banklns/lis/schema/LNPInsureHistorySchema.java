// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsureHistorySchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPInsureHistoryDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPInsureHistorySchema
	implements Schema, Cloneable
{

	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private String prtNo;
	private String polOrder;
	private String comName;
	private double sumInsuredDeath;
	private double sumInsuredDisease;
	private String policyState;
	private String state;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String p2;
	private double p4;
	private double p3;
	private String p1;
	public static final int FIELDNUM = 19;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPInsureHistorySchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "ContNo";
		pk[1] = "PolOrder";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPInsureHistorySchema cloned = (LNPInsureHistorySchema)super.clone();
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

	public String getPolOrder()
	{
		return polOrder;
	}

	public void setPolOrder(String aPolOrder)
	{
		polOrder = aPolOrder;
	}

	public String getComName()
	{
		return comName;
	}

	public void setComName(String aComName)
	{
		comName = aComName;
	}

	public double getSumInsuredDeath()
	{
		return sumInsuredDeath;
	}

	public void setSumInsuredDeath(double aSumInsuredDeath)
	{
		sumInsuredDeath = aSumInsuredDeath;
	}

	public void setSumInsuredDeath(String aSumInsuredDeath)
	{
		if (aSumInsuredDeath != null && !aSumInsuredDeath.equals(""))
		{
			Double tDouble = new Double(aSumInsuredDeath);
			double d = tDouble.doubleValue();
			sumInsuredDeath = d;
		}
	}

	public double getSumInsuredDisease()
	{
		return sumInsuredDisease;
	}

	public void setSumInsuredDisease(double aSumInsuredDisease)
	{
		sumInsuredDisease = aSumInsuredDisease;
	}

	public void setSumInsuredDisease(String aSumInsuredDisease)
	{
		if (aSumInsuredDisease != null && !aSumInsuredDisease.equals(""))
		{
			Double tDouble = new Double(aSumInsuredDisease);
			double d = tDouble.doubleValue();
			sumInsuredDisease = d;
		}
	}

	public String getPolicyState()
	{
		return policyState;
	}

	public void setPolicyState(String aPolicyState)
	{
		policyState = aPolicyState;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
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

	public double getP4()
	{
		return p4;
	}

	public void setP4(double aP4)
	{
		p4 = aP4;
	}

	public void setP4(String aP4)
	{
		if (aP4 != null && !aP4.equals(""))
		{
			Double tDouble = new Double(aP4);
			double d = tDouble.doubleValue();
			p4 = d;
		}
	}

	public double getP3()
	{
		return p3;
	}

	public void setP3(double aP3)
	{
		p3 = aP3;
	}

	public void setP3(String aP3)
	{
		if (aP3 != null && !aP3.equals(""))
		{
			Double tDouble = new Double(aP3);
			double d = tDouble.doubleValue();
			p3 = d;
		}
	}

	public String getP1()
	{
		return p1;
	}

	public void setP1(String aP1)
	{
		p1 = aP1;
	}

	public void setSchema(LNPInsureHistorySchema aLNPInsureHistorySchema)
	{
		grpContNo = aLNPInsureHistorySchema.getGrpContNo();
		contNo = aLNPInsureHistorySchema.getContNo();
		proposalContNo = aLNPInsureHistorySchema.getProposalContNo();
		prtNo = aLNPInsureHistorySchema.getPrtNo();
		polOrder = aLNPInsureHistorySchema.getPolOrder();
		comName = aLNPInsureHistorySchema.getComName();
		sumInsuredDeath = aLNPInsureHistorySchema.getSumInsuredDeath();
		sumInsuredDisease = aLNPInsureHistorySchema.getSumInsuredDisease();
		policyState = aLNPInsureHistorySchema.getPolicyState();
		state = aLNPInsureHistorySchema.getState();
		operator = aLNPInsureHistorySchema.getOperator();
		makeDate = fDate.getDate(aLNPInsureHistorySchema.getMakeDate());
		makeTime = aLNPInsureHistorySchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPInsureHistorySchema.getModifyDate());
		modifyTime = aLNPInsureHistorySchema.getModifyTime();
		p2 = aLNPInsureHistorySchema.getP2();
		p4 = aLNPInsureHistorySchema.getP4();
		p3 = aLNPInsureHistorySchema.getP3();
		p1 = aLNPInsureHistorySchema.getP1();
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
			if (rs.getString("PolOrder") == null)
				polOrder = null;
			else
				polOrder = rs.getString("PolOrder").trim();
			if (rs.getString("ComName") == null)
				comName = null;
			else
				comName = rs.getString("ComName").trim();
			sumInsuredDeath = rs.getDouble("SumInsuredDeath");
			sumInsuredDisease = rs.getDouble("SumInsuredDisease");
			if (rs.getString("PolicyState") == null)
				policyState = null;
			else
				policyState = rs.getString("PolicyState").trim();
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
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
			p4 = rs.getDouble("p4");
			p3 = rs.getDouble("p3");
			if (rs.getString("p1") == null)
				p1 = null;
			else
				p1 = rs.getString("p1").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPInsureHistory????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPInsureHistorySchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPInsureHistorySchema getSchema()
	{
		LNPInsureHistorySchema aLNPInsureHistorySchema = new LNPInsureHistorySchema();
		aLNPInsureHistorySchema.setSchema(this);
		return aLNPInsureHistorySchema;
	}

	public LNPInsureHistoryDB getDB()
	{
		LNPInsureHistoryDB aDBOper = new LNPInsureHistoryDB();
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
		strReturn.append(StrTool.cTrim(polOrder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(comName));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sumInsuredDeath));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sumInsuredDisease));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(policyState));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
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
		strReturn.append(ChgData.chgData(p4));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(p3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(p1));
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
			polOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			comName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			sumInsuredDeath = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).doubleValue();
			sumInsuredDisease = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).doubleValue();
			policyState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			p4 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 17, "|")))).doubleValue();
			p3 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|")))).doubleValue();
			p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsureHistorySchema";
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
		if (FCode.equalsIgnoreCase("polOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(polOrder));
		if (FCode.equalsIgnoreCase("comName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(comName));
		if (FCode.equalsIgnoreCase("sumInsuredDeath"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sumInsuredDeath));
		if (FCode.equalsIgnoreCase("sumInsuredDisease"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sumInsuredDisease));
		if (FCode.equalsIgnoreCase("policyState"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(policyState));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
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
			strFieldValue = StrTool.GBKToUnicode(polOrder);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(comName);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(sumInsuredDeath);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(sumInsuredDisease);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(policyState);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(p2);
			break;

		case 16: // '\020'
			strFieldValue = String.valueOf(p4);
			break;

		case 17: // '\021'
			strFieldValue = String.valueOf(p3);
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
		if (FCode.equalsIgnoreCase("polOrder"))
			if (FValue != null && !FValue.equals(""))
				polOrder = FValue.trim();
			else
				polOrder = null;
		if (FCode.equalsIgnoreCase("comName"))
			if (FValue != null && !FValue.equals(""))
				comName = FValue.trim();
			else
				comName = null;
		if (FCode.equalsIgnoreCase("sumInsuredDeath") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sumInsuredDeath = d;
		}
		if (FCode.equalsIgnoreCase("sumInsuredDisease") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sumInsuredDisease = d;
		}
		if (FCode.equalsIgnoreCase("policyState"))
			if (FValue != null && !FValue.equals(""))
				policyState = FValue.trim();
			else
				policyState = null;
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
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
		if (FCode.equalsIgnoreCase("p4") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			p4 = d;
		}
		if (FCode.equalsIgnoreCase("p3") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			p3 = d;
		}
		if (FCode.equalsIgnoreCase("p1"))
			if (FValue != null && !FValue.equals(""))
				p1 = FValue.trim();
			else
				p1 = null;
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
		LNPInsureHistorySchema other = (LNPInsureHistorySchema)otherObject;
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
		if (polOrder == null && other.getPolOrder() != null)
			return false;
		if (polOrder != null && !polOrder.equals(other.getPolOrder()))
			return false;
		if (comName == null && other.getComName() != null)
			return false;
		if (comName != null && !comName.equals(other.getComName()))
			return false;
		if (Double.doubleToLongBits(sumInsuredDeath) != Double.doubleToLongBits(other.getSumInsuredDeath()))
			return false;
		if (Double.doubleToLongBits(sumInsuredDisease) != Double.doubleToLongBits(other.getSumInsuredDisease()))
			return false;
		if (policyState == null && other.getPolicyState() != null)
			return false;
		if (policyState != null && !policyState.equals(other.getPolicyState()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
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
		if (Double.doubleToLongBits(p4) != Double.doubleToLongBits(other.getP4()))
			return false;
		if (Double.doubleToLongBits(p3) != Double.doubleToLongBits(other.getP3()))
			return false;
		if (p1 == null && other.getP1() != null)
			return false;
		return p1 == null || p1.equals(other.getP1());
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
		if (strFieldName.equals("polOrder"))
			return 4;
		if (strFieldName.equals("comName"))
			return 5;
		if (strFieldName.equals("sumInsuredDeath"))
			return 6;
		if (strFieldName.equals("sumInsuredDisease"))
			return 7;
		if (strFieldName.equals("policyState"))
			return 8;
		if (strFieldName.equals("state"))
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
			strFieldName = "polOrder";
			break;

		case 5: // '\005'
			strFieldName = "comName";
			break;

		case 6: // '\006'
			strFieldName = "sumInsuredDeath";
			break;

		case 7: // '\007'
			strFieldName = "sumInsuredDisease";
			break;

		case 8: // '\b'
			strFieldName = "policyState";
			break;

		case 9: // '\t'
			strFieldName = "state";
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
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("proposalContNo"))
			return 0;
		if (strFieldName.equals("prtNo"))
			return 0;
		if (strFieldName.equals("polOrder"))
			return 0;
		if (strFieldName.equals("comName"))
			return 0;
		if (strFieldName.equals("sumInsuredDeath"))
			return 4;
		if (strFieldName.equals("sumInsuredDisease"))
			return 4;
		if (strFieldName.equals("policyState"))
			return 0;
		if (strFieldName.equals("state"))
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
			return 4;
		if (strFieldName.equals("p3"))
			return 4;
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
			nFieldType = 4;
			break;

		case 7: // '\007'
			nFieldType = 4;
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
			nFieldType = 4;
			break;

		case 17: // '\021'
			nFieldType = 4;
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
