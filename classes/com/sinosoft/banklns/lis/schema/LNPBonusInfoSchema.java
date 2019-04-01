// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPBonusInfoSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPBonusInfoDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPBonusInfoSchema
	implements Schema, Cloneable
{

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
	public static final int FIELDNUM = 17;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPBonusInfoSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ContNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPBonusInfoSchema cloned = (LNPBonusInfoSchema)super.clone();
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

	public String getBonusType()
	{
		return bonusType;
	}

	public void setBonusType(String aBonusType)
	{
		bonusType = aBonusType;
	}

	public String getBonusWay()
	{
		return bonusWay;
	}

	public void setBonusWay(String aBonusWay)
	{
		bonusWay = aBonusWay;
	}

	public String getAutoRepaid()
	{
		return autoRepaid;
	}

	public void setAutoRepaid(String aAutoRepaid)
	{
		autoRepaid = aAutoRepaid;
	}

	public String getCutPayAll()
	{
		return cutPayAll;
	}

	public void setCutPayAll(String aCutPayAll)
	{
		cutPayAll = aCutPayAll;
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

	public void setSchema(LNPBonusInfoSchema aLNPBonusInfoSchema)
	{
		grpContNo = aLNPBonusInfoSchema.getGrpContNo();
		contNo = aLNPBonusInfoSchema.getContNo();
		proposalContNo = aLNPBonusInfoSchema.getProposalContNo();
		prtNo = aLNPBonusInfoSchema.getPrtNo();
		bonusType = aLNPBonusInfoSchema.getBonusType();
		bonusWay = aLNPBonusInfoSchema.getBonusWay();
		autoRepaid = aLNPBonusInfoSchema.getAutoRepaid();
		cutPayAll = aLNPBonusInfoSchema.getCutPayAll();
		operator = aLNPBonusInfoSchema.getOperator();
		makeDate = fDate.getDate(aLNPBonusInfoSchema.getMakeDate());
		makeTime = aLNPBonusInfoSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPBonusInfoSchema.getModifyDate());
		modifyTime = aLNPBonusInfoSchema.getModifyTime();
		p2 = aLNPBonusInfoSchema.getP2();
		p4 = aLNPBonusInfoSchema.getP4();
		p3 = aLNPBonusInfoSchema.getP3();
		p1 = aLNPBonusInfoSchema.getP1();
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
			if (rs.getString("BonusType") == null)
				bonusType = null;
			else
				bonusType = rs.getString("BonusType").trim();
			if (rs.getString("BonusWay") == null)
				bonusWay = null;
			else
				bonusWay = rs.getString("BonusWay").trim();
			if (rs.getString("AutoRepaid") == null)
				autoRepaid = null;
			else
				autoRepaid = rs.getString("AutoRepaid").trim();
			if (rs.getString("cutPayAll") == null)
				cutPayAll = null;
			else
				cutPayAll = rs.getString("cutPayAll").trim();
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
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPBonusInfo表字段个数和Schema中的字段个数不一致，或�?�执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPBonusInfoSchema getSchema()
	{
		LNPBonusInfoSchema aLNPBonusInfoSchema = new LNPBonusInfoSchema();
		aLNPBonusInfoSchema.setSchema(this);
		return aLNPBonusInfoSchema;
	}

	public LNPBonusInfoDB getDB()
	{
		LNPBonusInfoDB aDBOper = new LNPBonusInfoDB();
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
		strReturn.append(StrTool.cTrim(bonusType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(bonusWay));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(autoRepaid));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(cutPayAll));
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
			bonusType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			bonusWay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			autoRepaid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			cutPayAll = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoSchema";
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
		if (FCode.equalsIgnoreCase("bonusType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusType));
		if (FCode.equalsIgnoreCase("bonusWay"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(bonusWay));
		if (FCode.equalsIgnoreCase("autoRepaid"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(autoRepaid));
		if (FCode.equalsIgnoreCase("cutPayAll"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(cutPayAll));
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
			strFieldValue = StrTool.GBKToUnicode(bonusType);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(bonusWay);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(autoRepaid);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(cutPayAll);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(p2);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(p4);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(p3);
			break;

		case 16: // '\020'
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
		if (FCode.equalsIgnoreCase("bonusType"))
			if (FValue != null && !FValue.equals(""))
				bonusType = FValue.trim();
			else
				bonusType = null;
		if (FCode.equalsIgnoreCase("bonusWay"))
			if (FValue != null && !FValue.equals(""))
				bonusWay = FValue.trim();
			else
				bonusWay = null;
		if (FCode.equalsIgnoreCase("autoRepaid"))
			if (FValue != null && !FValue.equals(""))
				autoRepaid = FValue.trim();
			else
				autoRepaid = null;
		if (FCode.equalsIgnoreCase("cutPayAll"))
			if (FValue != null && !FValue.equals(""))
				cutPayAll = FValue.trim();
			else
				cutPayAll = null;
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
		LNPBonusInfoSchema other = (LNPBonusInfoSchema)otherObject;
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
		if (bonusType == null && other.getBonusType() != null)
			return false;
		if (bonusType != null && !bonusType.equals(other.getBonusType()))
			return false;
		if (bonusWay == null && other.getBonusWay() != null)
			return false;
		if (bonusWay != null && !bonusWay.equals(other.getBonusWay()))
			return false;
		if (autoRepaid == null && other.getAutoRepaid() != null)
			return false;
		if (autoRepaid != null && !autoRepaid.equals(other.getAutoRepaid()))
			return false;
		if (cutPayAll == null && other.getCutPayAll() != null)
			return false;
		if (cutPayAll != null && !cutPayAll.equals(other.getCutPayAll()))
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
		return p1 == null || p1.equals(other.getP1());
	}

	public int getFieldCount()
	{
		return 17;
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
		if (strFieldName.equals("bonusType"))
			return 4;
		if (strFieldName.equals("bonusWay"))
			return 5;
		if (strFieldName.equals("autoRepaid"))
			return 6;
		if (strFieldName.equals("cutPayAll"))
			return 7;
		if (strFieldName.equals("operator"))
			return 8;
		if (strFieldName.equals("makeDate"))
			return 9;
		if (strFieldName.equals("makeTime"))
			return 10;
		if (strFieldName.equals("modifyDate"))
			return 11;
		if (strFieldName.equals("modifyTime"))
			return 12;
		if (strFieldName.equals("p2"))
			return 13;
		if (strFieldName.equals("p4"))
			return 14;
		if (strFieldName.equals("p3"))
			return 15;
		return !strFieldName.equals("p1") ? -1 : 16;
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
			strFieldName = "bonusType";
			break;

		case 5: // '\005'
			strFieldName = "bonusWay";
			break;

		case 6: // '\006'
			strFieldName = "autoRepaid";
			break;

		case 7: // '\007'
			strFieldName = "cutPayAll";
			break;

		case 8: // '\b'
			strFieldName = "operator";
			break;

		case 9: // '\t'
			strFieldName = "makeDate";
			break;

		case 10: // '\n'
			strFieldName = "makeTime";
			break;

		case 11: // '\013'
			strFieldName = "modifyDate";
			break;

		case 12: // '\f'
			strFieldName = "modifyTime";
			break;

		case 13: // '\r'
			strFieldName = "p2";
			break;

		case 14: // '\016'
			strFieldName = "p4";
			break;

		case 15: // '\017'
			strFieldName = "p3";
			break;

		case 16: // '\020'
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
			nFieldType = 1;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
