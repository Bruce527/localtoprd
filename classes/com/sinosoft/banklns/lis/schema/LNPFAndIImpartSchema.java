// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPFAndIImpartSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPFAndIImpartDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LNPFAndIImpartSchema
	implements Schema, Cloneable
{

	private String impartId;
	private String impartName;
	private String impartVer;
	private String impartContent;
	private int questionSum;
	private String operator;
	private String manageCom;
	private String makeTime;
	private Date makeDate;
	private Date modifyDate;
	private String modifyTime;
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	public static final int FIELDNUM = 15;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LNPFAndIImpartSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ImpartId";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPFAndIImpartSchema cloned = (LNPFAndIImpartSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getImpartId()
	{
		return impartId;
	}

	public void setImpartId(String aImpartId)
	{
		impartId = aImpartId;
	}

	public String getImpartName()
	{
		return impartName;
	}

	public void setImpartName(String aImpartName)
	{
		impartName = aImpartName;
	}

	public String getImpartVer()
	{
		return impartVer;
	}

	public void setImpartVer(String aImpartVer)
	{
		impartVer = aImpartVer;
	}

	public String getImpartContent()
	{
		return impartContent;
	}

	public void setImpartContent(String aImpartContent)
	{
		impartContent = aImpartContent;
	}

	public int getQuestionSum()
	{
		return questionSum;
	}

	public void setQuestionSum(int aQuestionSum)
	{
		questionSum = aQuestionSum;
	}

	public void setQuestionSum(String aQuestionSum)
	{
		if (aQuestionSum != null && !aQuestionSum.equals(""))
		{
			Integer tInteger = new Integer(aQuestionSum);
			int i = tInteger.intValue();
			questionSum = i;
		}
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

	public String getMakeTime()
	{
		return makeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		makeTime = aMakeTime;
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

	public String getP1()
	{
		return p1;
	}

	public void setP1(String aP1)
	{
		p1 = aP1;
	}

	public String getP2()
	{
		return p2;
	}

	public void setP2(String aP2)
	{
		p2 = aP2;
	}

	public String getP3()
	{
		return p3;
	}

	public void setP3(String aP3)
	{
		p3 = aP3;
	}

	public String getP4()
	{
		return p4;
	}

	public void setP4(String aP4)
	{
		p4 = aP4;
	}

	public void setSchema(LNPFAndIImpartSchema aLNPFAndIImpartSchema)
	{
		impartId = aLNPFAndIImpartSchema.getImpartId();
		impartName = aLNPFAndIImpartSchema.getImpartName();
		impartVer = aLNPFAndIImpartSchema.getImpartVer();
		impartContent = aLNPFAndIImpartSchema.getImpartContent();
		questionSum = aLNPFAndIImpartSchema.getQuestionSum();
		operator = aLNPFAndIImpartSchema.getOperator();
		manageCom = aLNPFAndIImpartSchema.getManageCom();
		makeTime = aLNPFAndIImpartSchema.getMakeTime();
		makeDate = fDate.getDate(aLNPFAndIImpartSchema.getMakeDate());
		modifyDate = fDate.getDate(aLNPFAndIImpartSchema.getModifyDate());
		modifyTime = aLNPFAndIImpartSchema.getModifyTime();
		p1 = aLNPFAndIImpartSchema.getP1();
		p2 = aLNPFAndIImpartSchema.getP2();
		p3 = aLNPFAndIImpartSchema.getP3();
		p4 = aLNPFAndIImpartSchema.getP4();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ImpartId") == null)
				impartId = null;
			else
				impartId = rs.getString("ImpartId").trim();
			if (rs.getString("ImpartName") == null)
				impartName = null;
			else
				impartName = rs.getString("ImpartName").trim();
			if (rs.getString("ImpartVer") == null)
				impartVer = null;
			else
				impartVer = rs.getString("ImpartVer").trim();
			if (rs.getString("ImpartContent") == null)
				impartContent = null;
			else
				impartContent = rs.getString("ImpartContent").trim();
			questionSum = rs.getInt("QuestionSum");
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("MakeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("MakeTime").trim();
			makeDate = rs.getDate("MakeDate");
			modifyDate = rs.getDate("ModifyDate");
			if (rs.getString("ModifyTime") == null)
				modifyTime = null;
			else
				modifyTime = rs.getString("ModifyTime").trim();
			if (rs.getString("p1") == null)
				p1 = null;
			else
				p1 = rs.getString("p1").trim();
			if (rs.getString("p2") == null)
				p2 = null;
			else
				p2 = rs.getString("p2").trim();
			if (rs.getString("p3") == null)
				p3 = null;
			else
				p3 = rs.getString("p3").trim();
			if (rs.getString("p4") == null)
				p4 = null;
			else
				p4 = rs.getString("p4").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPFAndIImpart���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpartSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPFAndIImpartSchema getSchema()
	{
		LNPFAndIImpartSchema aLNPFAndIImpartSchema = new LNPFAndIImpartSchema();
		aLNPFAndIImpartSchema.setSchema(this);
		return aLNPFAndIImpartSchema;
	}

	public LNPFAndIImpartDB getDB()
	{
		LNPFAndIImpartDB aDBOper = new LNPFAndIImpartDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(impartId));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(impartName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(impartVer));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(impartContent));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(questionSum));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(p1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(p2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(p3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(p4));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			impartName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			impartVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			impartContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			questionSum = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|")))).intValue();
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpartSchema";
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
		if (FCode.equalsIgnoreCase("impartId"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartId));
		if (FCode.equalsIgnoreCase("impartName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartName));
		if (FCode.equalsIgnoreCase("impartVer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartVer));
		if (FCode.equalsIgnoreCase("impartContent"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(impartContent));
		if (FCode.equalsIgnoreCase("questionSum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(questionSum));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
		if (FCode.equalsIgnoreCase("p1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p1));
		if (FCode.equalsIgnoreCase("p2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p2));
		if (FCode.equalsIgnoreCase("p3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p3));
		if (FCode.equalsIgnoreCase("p4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(p4));
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
			strFieldValue = StrTool.GBKToUnicode(impartId);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(impartName);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(impartVer);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(impartContent);
			break;

		case 4: // '\004'
			strFieldValue = String.valueOf(questionSum);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(p1);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(p2);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(p3);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(p4);
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
		if (FCode.equalsIgnoreCase("impartId"))
			if (FValue != null && !FValue.equals(""))
				impartId = FValue.trim();
			else
				impartId = null;
		if (FCode.equalsIgnoreCase("impartName"))
			if (FValue != null && !FValue.equals(""))
				impartName = FValue.trim();
			else
				impartName = null;
		if (FCode.equalsIgnoreCase("impartVer"))
			if (FValue != null && !FValue.equals(""))
				impartVer = FValue.trim();
			else
				impartVer = null;
		if (FCode.equalsIgnoreCase("impartContent"))
			if (FValue != null && !FValue.equals(""))
				impartContent = FValue.trim();
			else
				impartContent = null;
		if (FCode.equalsIgnoreCase("questionSum") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			questionSum = i;
		}
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
		if (FCode.equalsIgnoreCase("makeTime"))
			if (FValue != null && !FValue.equals(""))
				makeTime = FValue.trim();
			else
				makeTime = null;
		if (FCode.equalsIgnoreCase("makeDate"))
			if (FValue != null && !FValue.equals(""))
				makeDate = fDate.getDate(FValue);
			else
				makeDate = null;
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
		if (FCode.equalsIgnoreCase("p1"))
			if (FValue != null && !FValue.equals(""))
				p1 = FValue.trim();
			else
				p1 = null;
		if (FCode.equalsIgnoreCase("p2"))
			if (FValue != null && !FValue.equals(""))
				p2 = FValue.trim();
			else
				p2 = null;
		if (FCode.equalsIgnoreCase("p3"))
			if (FValue != null && !FValue.equals(""))
				p3 = FValue.trim();
			else
				p3 = null;
		if (FCode.equalsIgnoreCase("p4"))
			if (FValue != null && !FValue.equals(""))
				p4 = FValue.trim();
			else
				p4 = null;
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
		LNPFAndIImpartSchema other = (LNPFAndIImpartSchema)otherObject;
		if (impartId == null && other.getImpartId() != null)
			return false;
		if (impartId != null && !impartId.equals(other.getImpartId()))
			return false;
		if (impartName == null && other.getImpartName() != null)
			return false;
		if (impartName != null && !impartName.equals(other.getImpartName()))
			return false;
		if (impartVer == null && other.getImpartVer() != null)
			return false;
		if (impartVer != null && !impartVer.equals(other.getImpartVer()))
			return false;
		if (impartContent == null && other.getImpartContent() != null)
			return false;
		if (impartContent != null && !impartContent.equals(other.getImpartContent()))
			return false;
		if (questionSum != other.getQuestionSum())
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (makeTime == null && other.getMakeTime() != null)
			return false;
		if (makeTime != null && !makeTime.equals(other.getMakeTime()))
			return false;
		if (makeDate == null && other.getMakeDate() != null)
			return false;
		if (makeDate != null && !fDate.getString(makeDate).equals(other.getMakeDate()))
			return false;
		if (modifyDate == null && other.getModifyDate() != null)
			return false;
		if (modifyDate != null && !fDate.getString(modifyDate).equals(other.getModifyDate()))
			return false;
		if (modifyTime == null && other.getModifyTime() != null)
			return false;
		if (modifyTime != null && !modifyTime.equals(other.getModifyTime()))
			return false;
		if (p1 == null && other.getP1() != null)
			return false;
		if (p1 != null && !p1.equals(other.getP1()))
			return false;
		if (p2 == null && other.getP2() != null)
			return false;
		if (p2 != null && !p2.equals(other.getP2()))
			return false;
		if (p3 == null && other.getP3() != null)
			return false;
		if (p3 != null && !p3.equals(other.getP3()))
			return false;
		if (p4 == null && other.getP4() != null)
			return false;
		return p4 == null || p4.equals(other.getP4());
	}

	public int getFieldCount()
	{
		return 15;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("impartId"))
			return 0;
		if (strFieldName.equals("impartName"))
			return 1;
		if (strFieldName.equals("impartVer"))
			return 2;
		if (strFieldName.equals("impartContent"))
			return 3;
		if (strFieldName.equals("questionSum"))
			return 4;
		if (strFieldName.equals("operator"))
			return 5;
		if (strFieldName.equals("manageCom"))
			return 6;
		if (strFieldName.equals("makeTime"))
			return 7;
		if (strFieldName.equals("makeDate"))
			return 8;
		if (strFieldName.equals("modifyDate"))
			return 9;
		if (strFieldName.equals("modifyTime"))
			return 10;
		if (strFieldName.equals("p1"))
			return 11;
		if (strFieldName.equals("p2"))
			return 12;
		if (strFieldName.equals("p3"))
			return 13;
		return !strFieldName.equals("p4") ? -1 : 14;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "impartId";
			break;

		case 1: // '\001'
			strFieldName = "impartName";
			break;

		case 2: // '\002'
			strFieldName = "impartVer";
			break;

		case 3: // '\003'
			strFieldName = "impartContent";
			break;

		case 4: // '\004'
			strFieldName = "questionSum";
			break;

		case 5: // '\005'
			strFieldName = "operator";
			break;

		case 6: // '\006'
			strFieldName = "manageCom";
			break;

		case 7: // '\007'
			strFieldName = "makeTime";
			break;

		case 8: // '\b'
			strFieldName = "makeDate";
			break;

		case 9: // '\t'
			strFieldName = "modifyDate";
			break;

		case 10: // '\n'
			strFieldName = "modifyTime";
			break;

		case 11: // '\013'
			strFieldName = "p1";
			break;

		case 12: // '\f'
			strFieldName = "p2";
			break;

		case 13: // '\r'
			strFieldName = "p3";
			break;

		case 14: // '\016'
			strFieldName = "p4";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("impartId"))
			return 0;
		if (strFieldName.equals("impartName"))
			return 0;
		if (strFieldName.equals("impartVer"))
			return 0;
		if (strFieldName.equals("impartContent"))
			return 0;
		if (strFieldName.equals("questionSum"))
			return 3;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("modifyDate"))
			return 1;
		if (strFieldName.equals("modifyTime"))
			return 0;
		if (strFieldName.equals("p1"))
			return 0;
		if (strFieldName.equals("p2"))
			return 0;
		if (strFieldName.equals("p3"))
			return 0;
		return !strFieldName.equals("p4") ? -1 : 0;
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
			nFieldType = 3;
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
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 14: // '\016'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
