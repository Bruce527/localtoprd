// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAgentImpResultSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPAgentImpResultDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPAgentImpResultSchema
	implements Schema, Cloneable
{

	private String resultId;
	private String grpContNo;
	private String contNo;
	private String proposalContNo;
	private String impartId;
	private String grouporder;
	private String qID01;
	private String a01;
	private String qID02;
	private String a02;
	private String qID03;
	private String a03;
	private String qID04;
	private String a04;
	private String qID05;
	private String a05;
	private String qID06;
	private String a06;
	private String operator;
	private String manageCom;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 24;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPAgentImpResultSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "ResultId";
		pk[1] = "Grouporder";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPAgentImpResultSchema cloned = (LNPAgentImpResultSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getResultId()
	{
		return resultId;
	}

	public void setResultId(String aResultId)
	{
		resultId = aResultId;
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

	public String getImpartId()
	{
		return impartId;
	}

	public void setImpartId(String aImpartId)
	{
		impartId = aImpartId;
	}

	public String getGrouporder()
	{
		return grouporder;
	}

	public void setGrouporder(String aGrouporder)
	{
		grouporder = aGrouporder;
	}

	public String getQID01()
	{
		return qID01;
	}

	public void setQID01(String aQID01)
	{
		qID01 = aQID01;
	}

	public String getA01()
	{
		return a01;
	}

	public void setA01(String aA01)
	{
		a01 = aA01;
	}

	public String getQID02()
	{
		return qID02;
	}

	public void setQID02(String aQID02)
	{
		qID02 = aQID02;
	}

	public String getA02()
	{
		return a02;
	}

	public void setA02(String aA02)
	{
		a02 = aA02;
	}

	public String getQID03()
	{
		return qID03;
	}

	public void setQID03(String aQID03)
	{
		qID03 = aQID03;
	}

	public String getA03()
	{
		return a03;
	}

	public void setA03(String aA03)
	{
		a03 = aA03;
	}

	public String getQID04()
	{
		return qID04;
	}

	public void setQID04(String aQID04)
	{
		qID04 = aQID04;
	}

	public String getA04()
	{
		return a04;
	}

	public void setA04(String aA04)
	{
		a04 = aA04;
	}

	public String getQID05()
	{
		return qID05;
	}

	public void setQID05(String aQID05)
	{
		qID05 = aQID05;
	}

	public String getA05()
	{
		return a05;
	}

	public void setA05(String aA05)
	{
		a05 = aA05;
	}

	public String getQID06()
	{
		return qID06;
	}

	public void setQID06(String aQID06)
	{
		qID06 = aQID06;
	}

	public String getA06()
	{
		return a06;
	}

	public void setA06(String aA06)
	{
		a06 = aA06;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
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

	public void setSchema(LNPAgentImpResultSchema aLNPAgentImpResultSchema)
	{
		resultId = aLNPAgentImpResultSchema.getResultId();
		grpContNo = aLNPAgentImpResultSchema.getGrpContNo();
		contNo = aLNPAgentImpResultSchema.getContNo();
		proposalContNo = aLNPAgentImpResultSchema.getProposalContNo();
		impartId = aLNPAgentImpResultSchema.getImpartId();
		grouporder = aLNPAgentImpResultSchema.getGrouporder();
		qID01 = aLNPAgentImpResultSchema.getQID01();
		a01 = aLNPAgentImpResultSchema.getA01();
		qID02 = aLNPAgentImpResultSchema.getQID02();
		a02 = aLNPAgentImpResultSchema.getA02();
		qID03 = aLNPAgentImpResultSchema.getQID03();
		a03 = aLNPAgentImpResultSchema.getA03();
		qID04 = aLNPAgentImpResultSchema.getQID04();
		a04 = aLNPAgentImpResultSchema.getA04();
		qID05 = aLNPAgentImpResultSchema.getQID05();
		a05 = aLNPAgentImpResultSchema.getA05();
		qID06 = aLNPAgentImpResultSchema.getQID06();
		a06 = aLNPAgentImpResultSchema.getA06();
		operator = aLNPAgentImpResultSchema.getOperator();
		manageCom = aLNPAgentImpResultSchema.getManageCom();
		makeDate = fDate.getDate(aLNPAgentImpResultSchema.getMakeDate());
		makeTime = aLNPAgentImpResultSchema.getMakeTime();
		modifyDate = fDate.getDate(aLNPAgentImpResultSchema.getModifyDate());
		modifyTime = aLNPAgentImpResultSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ResultId") == null)
				resultId = null;
			else
				resultId = rs.getString("ResultId").trim();
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
			if (rs.getString("ImpartId") == null)
				impartId = null;
			else
				impartId = rs.getString("ImpartId").trim();
			if (rs.getString("Grouporder") == null)
				grouporder = null;
			else
				grouporder = rs.getString("Grouporder").trim();
			if (rs.getString("QID01") == null)
				qID01 = null;
			else
				qID01 = rs.getString("QID01").trim();
			if (rs.getString("A01") == null)
				a01 = null;
			else
				a01 = rs.getString("A01").trim();
			if (rs.getString("QID02") == null)
				qID02 = null;
			else
				qID02 = rs.getString("QID02").trim();
			if (rs.getString("A02") == null)
				a02 = null;
			else
				a02 = rs.getString("A02").trim();
			if (rs.getString("QID03") == null)
				qID03 = null;
			else
				qID03 = rs.getString("QID03").trim();
			if (rs.getString("A03") == null)
				a03 = null;
			else
				a03 = rs.getString("A03").trim();
			if (rs.getString("QID04") == null)
				qID04 = null;
			else
				qID04 = rs.getString("QID04").trim();
			if (rs.getString("A04") == null)
				a04 = null;
			else
				a04 = rs.getString("A04").trim();
			if (rs.getString("QID05") == null)
				qID05 = null;
			else
				qID05 = rs.getString("QID05").trim();
			if (rs.getString("A05") == null)
				a05 = null;
			else
				a05 = rs.getString("A05").trim();
			if (rs.getString("QID06") == null)
				qID06 = null;
			else
				qID06 = rs.getString("QID06").trim();
			if (rs.getString("A06") == null)
				a06 = null;
			else
				a06 = rs.getString("A06").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
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
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPAgentImpResult表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPAgentImpResultSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPAgentImpResultSchema getSchema()
	{
		LNPAgentImpResultSchema aLNPAgentImpResultSchema = new LNPAgentImpResultSchema();
		aLNPAgentImpResultSchema.setSchema(this);
		return aLNPAgentImpResultSchema;
	}

	public LNPAgentImpResultDB getDB()
	{
		LNPAgentImpResultDB aDBOper = new LNPAgentImpResultDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(resultId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grpContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(contNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(proposalContNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(impartId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(grouporder));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(qID01));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(a01));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(qID02));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(a02));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(qID03));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(a03));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(qID04));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(a04));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(qID05));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(a05));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(qID06));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(a06));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyTime));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			resultId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			grpContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			proposalContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			grouporder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			qID01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			a01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			qID02 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			a02 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			qID03 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			a03 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			qID04 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			a04 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			qID05 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			a05 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			qID06 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			a06 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAgentImpResultSchema";
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
		if (FCode.equalsIgnoreCase("resultId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(resultId));
		if (FCode.equalsIgnoreCase("grpContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpContNo));
		if (FCode.equalsIgnoreCase("contNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(contNo));
		if (FCode.equalsIgnoreCase("proposalContNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(proposalContNo));
		if (FCode.equalsIgnoreCase("impartId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartId));
		if (FCode.equalsIgnoreCase("grouporder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grouporder));
		if (FCode.equalsIgnoreCase("qID01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(qID01));
		if (FCode.equalsIgnoreCase("a01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(a01));
		if (FCode.equalsIgnoreCase("qID02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(qID02));
		if (FCode.equalsIgnoreCase("a02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(a02));
		if (FCode.equalsIgnoreCase("qID03"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(qID03));
		if (FCode.equalsIgnoreCase("a03"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(a03));
		if (FCode.equalsIgnoreCase("qID04"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(qID04));
		if (FCode.equalsIgnoreCase("a04"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(a04));
		if (FCode.equalsIgnoreCase("qID05"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(qID05));
		if (FCode.equalsIgnoreCase("a05"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(a05));
		if (FCode.equalsIgnoreCase("qID06"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(qID06));
		if (FCode.equalsIgnoreCase("a06"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(a06));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
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
			strFieldValue = StrTool.GBKToUnicode(resultId);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(grpContNo);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(contNo);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(proposalContNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(impartId);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(grouporder);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(qID01);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(a01);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(qID02);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(a02);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(qID03);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(a03);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(qID04);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(a04);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(qID05);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(a05);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(qID06);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(a06);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
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
		if (FCode.equalsIgnoreCase("resultId"))
			if (FValue != null && !FValue.equals(""))
				resultId = FValue.trim();
			else
				resultId = null;
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
		if (FCode.equalsIgnoreCase("impartId"))
			if (FValue != null && !FValue.equals(""))
				impartId = FValue.trim();
			else
				impartId = null;
		if (FCode.equalsIgnoreCase("grouporder"))
			if (FValue != null && !FValue.equals(""))
				grouporder = FValue.trim();
			else
				grouporder = null;
		if (FCode.equalsIgnoreCase("qID01"))
			if (FValue != null && !FValue.equals(""))
				qID01 = FValue.trim();
			else
				qID01 = null;
		if (FCode.equalsIgnoreCase("a01"))
			if (FValue != null && !FValue.equals(""))
				a01 = FValue.trim();
			else
				a01 = null;
		if (FCode.equalsIgnoreCase("qID02"))
			if (FValue != null && !FValue.equals(""))
				qID02 = FValue.trim();
			else
				qID02 = null;
		if (FCode.equalsIgnoreCase("a02"))
			if (FValue != null && !FValue.equals(""))
				a02 = FValue.trim();
			else
				a02 = null;
		if (FCode.equalsIgnoreCase("qID03"))
			if (FValue != null && !FValue.equals(""))
				qID03 = FValue.trim();
			else
				qID03 = null;
		if (FCode.equalsIgnoreCase("a03"))
			if (FValue != null && !FValue.equals(""))
				a03 = FValue.trim();
			else
				a03 = null;
		if (FCode.equalsIgnoreCase("qID04"))
			if (FValue != null && !FValue.equals(""))
				qID04 = FValue.trim();
			else
				qID04 = null;
		if (FCode.equalsIgnoreCase("a04"))
			if (FValue != null && !FValue.equals(""))
				a04 = FValue.trim();
			else
				a04 = null;
		if (FCode.equalsIgnoreCase("qID05"))
			if (FValue != null && !FValue.equals(""))
				qID05 = FValue.trim();
			else
				qID05 = null;
		if (FCode.equalsIgnoreCase("a05"))
			if (FValue != null && !FValue.equals(""))
				a05 = FValue.trim();
			else
				a05 = null;
		if (FCode.equalsIgnoreCase("qID06"))
			if (FValue != null && !FValue.equals(""))
				qID06 = FValue.trim();
			else
				qID06 = null;
		if (FCode.equalsIgnoreCase("a06"))
			if (FValue != null && !FValue.equals(""))
				a06 = FValue.trim();
			else
				a06 = null;
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
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
		LNPAgentImpResultSchema other = (LNPAgentImpResultSchema)otherObject;
		if (resultId == null && other.getResultId() != null)
			return false;
		if (resultId != null && !resultId.equals(other.getResultId()))
			return false;
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
		if (impartId == null && other.getImpartId() != null)
			return false;
		if (impartId != null && !impartId.equals(other.getImpartId()))
			return false;
		if (grouporder == null && other.getGrouporder() != null)
			return false;
		if (grouporder != null && !grouporder.equals(other.getGrouporder()))
			return false;
		if (qID01 == null && other.getQID01() != null)
			return false;
		if (qID01 != null && !qID01.equals(other.getQID01()))
			return false;
		if (a01 == null && other.getA01() != null)
			return false;
		if (a01 != null && !a01.equals(other.getA01()))
			return false;
		if (qID02 == null && other.getQID02() != null)
			return false;
		if (qID02 != null && !qID02.equals(other.getQID02()))
			return false;
		if (a02 == null && other.getA02() != null)
			return false;
		if (a02 != null && !a02.equals(other.getA02()))
			return false;
		if (qID03 == null && other.getQID03() != null)
			return false;
		if (qID03 != null && !qID03.equals(other.getQID03()))
			return false;
		if (a03 == null && other.getA03() != null)
			return false;
		if (a03 != null && !a03.equals(other.getA03()))
			return false;
		if (qID04 == null && other.getQID04() != null)
			return false;
		if (qID04 != null && !qID04.equals(other.getQID04()))
			return false;
		if (a04 == null && other.getA04() != null)
			return false;
		if (a04 != null && !a04.equals(other.getA04()))
			return false;
		if (qID05 == null && other.getQID05() != null)
			return false;
		if (qID05 != null && !qID05.equals(other.getQID05()))
			return false;
		if (a05 == null && other.getA05() != null)
			return false;
		if (a05 != null && !a05.equals(other.getA05()))
			return false;
		if (qID06 == null && other.getQID06() != null)
			return false;
		if (qID06 != null && !qID06.equals(other.getQID06()))
			return false;
		if (a06 == null && other.getA06() != null)
			return false;
		if (a06 != null && !a06.equals(other.getA06()))
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
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
		return modifyTime == null || modifyTime.equals(other.getModifyTime());
	}

	public int getFieldCount()
	{
		return 24;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("resultId"))
			return 0;
		if (strFieldName.equals("grpContNo"))
			return 1;
		if (strFieldName.equals("contNo"))
			return 2;
		if (strFieldName.equals("proposalContNo"))
			return 3;
		if (strFieldName.equals("impartId"))
			return 4;
		if (strFieldName.equals("grouporder"))
			return 5;
		if (strFieldName.equals("qID01"))
			return 6;
		if (strFieldName.equals("a01"))
			return 7;
		if (strFieldName.equals("qID02"))
			return 8;
		if (strFieldName.equals("a02"))
			return 9;
		if (strFieldName.equals("qID03"))
			return 10;
		if (strFieldName.equals("a03"))
			return 11;
		if (strFieldName.equals("qID04"))
			return 12;
		if (strFieldName.equals("a04"))
			return 13;
		if (strFieldName.equals("qID05"))
			return 14;
		if (strFieldName.equals("a05"))
			return 15;
		if (strFieldName.equals("qID06"))
			return 16;
		if (strFieldName.equals("a06"))
			return 17;
		if (strFieldName.equals("operator"))
			return 18;
		if (strFieldName.equals("manageCom"))
			return 19;
		if (strFieldName.equals("makeDate"))
			return 20;
		if (strFieldName.equals("makeTime"))
			return 21;
		if (strFieldName.equals("modifyDate"))
			return 22;
		return !strFieldName.equals("modifyTime") ? -1 : 23;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "resultId";
			break;

		case 1: // '\001'
			strFieldName = "grpContNo";
			break;

		case 2: // '\002'
			strFieldName = "contNo";
			break;

		case 3: // '\003'
			strFieldName = "proposalContNo";
			break;

		case 4: // '\004'
			strFieldName = "impartId";
			break;

		case 5: // '\005'
			strFieldName = "grouporder";
			break;

		case 6: // '\006'
			strFieldName = "qID01";
			break;

		case 7: // '\007'
			strFieldName = "a01";
			break;

		case 8: // '\b'
			strFieldName = "qID02";
			break;

		case 9: // '\t'
			strFieldName = "a02";
			break;

		case 10: // '\n'
			strFieldName = "qID03";
			break;

		case 11: // '\013'
			strFieldName = "a03";
			break;

		case 12: // '\f'
			strFieldName = "qID04";
			break;

		case 13: // '\r'
			strFieldName = "a04";
			break;

		case 14: // '\016'
			strFieldName = "qID05";
			break;

		case 15: // '\017'
			strFieldName = "a05";
			break;

		case 16: // '\020'
			strFieldName = "qID06";
			break;

		case 17: // '\021'
			strFieldName = "a06";
			break;

		case 18: // '\022'
			strFieldName = "operator";
			break;

		case 19: // '\023'
			strFieldName = "manageCom";
			break;

		case 20: // '\024'
			strFieldName = "makeDate";
			break;

		case 21: // '\025'
			strFieldName = "makeTime";
			break;

		case 22: // '\026'
			strFieldName = "modifyDate";
			break;

		case 23: // '\027'
			strFieldName = "modifyTime";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("resultId"))
			return 0;
		if (strFieldName.equals("grpContNo"))
			return 0;
		if (strFieldName.equals("contNo"))
			return 0;
		if (strFieldName.equals("proposalContNo"))
			return 0;
		if (strFieldName.equals("impartId"))
			return 0;
		if (strFieldName.equals("grouporder"))
			return 0;
		if (strFieldName.equals("qID01"))
			return 0;
		if (strFieldName.equals("a01"))
			return 0;
		if (strFieldName.equals("qID02"))
			return 0;
		if (strFieldName.equals("a02"))
			return 0;
		if (strFieldName.equals("qID03"))
			return 0;
		if (strFieldName.equals("a03"))
			return 0;
		if (strFieldName.equals("qID04"))
			return 0;
		if (strFieldName.equals("a04"))
			return 0;
		if (strFieldName.equals("qID05"))
			return 0;
		if (strFieldName.equals("a05"))
			return 0;
		if (strFieldName.equals("qID06"))
			return 0;
		if (strFieldName.equals("a06"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		return !strFieldName.equals("modifyTime") ? -1 : 0;
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
			nFieldType = 1;
			break;

		case 21: // '\025'
			nFieldType = 0;
			break;

		case 22: // '\026'
			nFieldType = 1;
			break;

		case 23: // '\027'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
