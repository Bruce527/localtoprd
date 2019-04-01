// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMenuBSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MMenuBDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MMenuBSchema
	implements Schema, Cloneable
{

	private String nodeCode;
	private String parentID;
	private String nodeLevel;
	private String nodeName;
	private String childFlag;
	private String nodeKey;
	private String runScript;
	private String nodeDesc;
	private String nodeSign;
	private int nodeOrder;
	private int int1;
	private int int2;
	private String varc1;
	private String varc2;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String edorNo;
	private String edorType;
	private String edorCase;
	private String operator2;
	private Date makeDate2;
	private String makeTime2;
	public static final int FIELDNUM = 25;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MMenuBSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "EdorNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MMenuBSchema cloned = (MMenuBSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getNodeCode()
	{
		return nodeCode;
	}

	public void setNodeCode(String aNodeCode)
	{
		nodeCode = aNodeCode;
	}

	public String getParentID()
	{
		return parentID;
	}

	public void setParentID(String aParentID)
	{
		parentID = aParentID;
	}

	public String getNodeLevel()
	{
		return nodeLevel;
	}

	public void setNodeLevel(String aNodeLevel)
	{
		nodeLevel = aNodeLevel;
	}

	public String getNodeName()
	{
		return nodeName;
	}

	public void setNodeName(String aNodeName)
	{
		nodeName = aNodeName;
	}

	public String getChildFlag()
	{
		return childFlag;
	}

	public void setChildFlag(String aChildFlag)
	{
		childFlag = aChildFlag;
	}

	public String getNodeKey()
	{
		return nodeKey;
	}

	public void setNodeKey(String aNodeKey)
	{
		nodeKey = aNodeKey;
	}

	public String getRunScript()
	{
		return runScript;
	}

	public void setRunScript(String aRunScript)
	{
		runScript = aRunScript;
	}

	public String getNodeDesc()
	{
		return nodeDesc;
	}

	public void setNodeDesc(String aNodeDesc)
	{
		nodeDesc = aNodeDesc;
	}

	public String getNodeSign()
	{
		return nodeSign;
	}

	public void setNodeSign(String aNodeSign)
	{
		nodeSign = aNodeSign;
	}

	public int getNodeOrder()
	{
		return nodeOrder;
	}

	public void setNodeOrder(int aNodeOrder)
	{
		nodeOrder = aNodeOrder;
	}

	public void setNodeOrder(String aNodeOrder)
	{
		if (aNodeOrder != null && !aNodeOrder.equals(""))
		{
			Integer tInteger = new Integer(aNodeOrder);
			int i = tInteger.intValue();
			nodeOrder = i;
		}
	}

	public int getInt1()
	{
		return int1;
	}

	public void setInt1(int aInt1)
	{
		int1 = aInt1;
	}

	public void setInt1(String aInt1)
	{
		if (aInt1 != null && !aInt1.equals(""))
		{
			Integer tInteger = new Integer(aInt1);
			int i = tInteger.intValue();
			int1 = i;
		}
	}

	public int getInt2()
	{
		return int2;
	}

	public void setInt2(int aInt2)
	{
		int2 = aInt2;
	}

	public void setInt2(String aInt2)
	{
		if (aInt2 != null && !aInt2.equals(""))
		{
			Integer tInteger = new Integer(aInt2);
			int i = tInteger.intValue();
			int2 = i;
		}
	}

	public String getVarc1()
	{
		return varc1;
	}

	public void setVarc1(String aVarc1)
	{
		varc1 = aVarc1;
	}

	public String getVarc2()
	{
		return varc2;
	}

	public void setVarc2(String aVarc2)
	{
		varc2 = aVarc2;
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

	public String getEdorNo()
	{
		return edorNo;
	}

	public void setEdorNo(String aEdorNo)
	{
		edorNo = aEdorNo;
	}

	public String getEdorType()
	{
		return edorType;
	}

	public void setEdorType(String aEdorType)
	{
		edorType = aEdorType;
	}

	public String getEdorCase()
	{
		return edorCase;
	}

	public void setEdorCase(String aEdorCase)
	{
		edorCase = aEdorCase;
	}

	public String getOperator2()
	{
		return operator2;
	}

	public void setOperator2(String aOperator2)
	{
		operator2 = aOperator2;
	}

	public String getMakeDate2()
	{
		if (makeDate2 != null)
			return fDate.getString(makeDate2);
		else
			return null;
	}

	public void setMakeDate2(Date aMakeDate2)
	{
		makeDate2 = aMakeDate2;
	}

	public void setMakeDate2(String aMakeDate2)
	{
		if (aMakeDate2 != null && !aMakeDate2.equals(""))
			makeDate2 = fDate.getDate(aMakeDate2);
		else
			makeDate2 = null;
	}

	public String getMakeTime2()
	{
		return makeTime2;
	}

	public void setMakeTime2(String aMakeTime2)
	{
		makeTime2 = aMakeTime2;
	}

	public void setSchema(MMenuBSchema aMMenuBSchema)
	{
		nodeCode = aMMenuBSchema.getNodeCode();
		parentID = aMMenuBSchema.getParentID();
		nodeLevel = aMMenuBSchema.getNodeLevel();
		nodeName = aMMenuBSchema.getNodeName();
		childFlag = aMMenuBSchema.getChildFlag();
		nodeKey = aMMenuBSchema.getNodeKey();
		runScript = aMMenuBSchema.getRunScript();
		nodeDesc = aMMenuBSchema.getNodeDesc();
		nodeSign = aMMenuBSchema.getNodeSign();
		nodeOrder = aMMenuBSchema.getNodeOrder();
		int1 = aMMenuBSchema.getInt1();
		int2 = aMMenuBSchema.getInt2();
		varc1 = aMMenuBSchema.getVarc1();
		varc2 = aMMenuBSchema.getVarc2();
		operator = aMMenuBSchema.getOperator();
		makeDate = fDate.getDate(aMMenuBSchema.getMakeDate());
		makeTime = aMMenuBSchema.getMakeTime();
		modifyDate = fDate.getDate(aMMenuBSchema.getModifyDate());
		modifyTime = aMMenuBSchema.getModifyTime();
		edorNo = aMMenuBSchema.getEdorNo();
		edorType = aMMenuBSchema.getEdorType();
		edorCase = aMMenuBSchema.getEdorCase();
		operator2 = aMMenuBSchema.getOperator2();
		makeDate2 = fDate.getDate(aMMenuBSchema.getMakeDate2());
		makeTime2 = aMMenuBSchema.getMakeTime2();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("NodeCode") == null)
				nodeCode = null;
			else
				nodeCode = rs.getString("NodeCode").trim();
			if (rs.getString("ParentID") == null)
				parentID = null;
			else
				parentID = rs.getString("ParentID").trim();
			if (rs.getString("NodeLevel") == null)
				nodeLevel = null;
			else
				nodeLevel = rs.getString("NodeLevel").trim();
			if (rs.getString("NodeName") == null)
				nodeName = null;
			else
				nodeName = rs.getString("NodeName").trim();
			if (rs.getString("ChildFlag") == null)
				childFlag = null;
			else
				childFlag = rs.getString("ChildFlag").trim();
			if (rs.getString("NodeKey") == null)
				nodeKey = null;
			else
				nodeKey = rs.getString("NodeKey").trim();
			if (rs.getString("RunScript") == null)
				runScript = null;
			else
				runScript = rs.getString("RunScript").trim();
			if (rs.getString("NodeDesc") == null)
				nodeDesc = null;
			else
				nodeDesc = rs.getString("NodeDesc").trim();
			if (rs.getString("NodeSign") == null)
				nodeSign = null;
			else
				nodeSign = rs.getString("NodeSign").trim();
			nodeOrder = rs.getInt("NodeOrder");
			int1 = rs.getInt("Int1");
			int2 = rs.getInt("Int2");
			if (rs.getString("Varc1") == null)
				varc1 = null;
			else
				varc1 = rs.getString("Varc1").trim();
			if (rs.getString("Varc2") == null)
				varc2 = null;
			else
				varc2 = rs.getString("Varc2").trim();
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
			if (rs.getString("EdorNo") == null)
				edorNo = null;
			else
				edorNo = rs.getString("EdorNo").trim();
			if (rs.getString("EdorType") == null)
				edorType = null;
			else
				edorType = rs.getString("EdorType").trim();
			if (rs.getString("EdorCase") == null)
				edorCase = null;
			else
				edorCase = rs.getString("EdorCase").trim();
			if (rs.getString("Operator2") == null)
				operator2 = null;
			else
				operator2 = rs.getString("Operator2").trim();
			makeDate2 = rs.getDate("MakeDate2");
			if (rs.getString("MakeTime2") == null)
				makeTime2 = null;
			else
				makeTime2 = rs.getString("MakeTime2").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MMenuB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MMenuBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MMenuBSchema getSchema()
	{
		MMenuBSchema aMMenuBSchema = new MMenuBSchema();
		aMMenuBSchema.setSchema(this);
		return aMMenuBSchema;
	}

	public MMenuBDB getDB()
	{
		MMenuBDB aDBOper = new MMenuBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(nodeCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(parentID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nodeLevel));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nodeName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(childFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nodeKey));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(runScript));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nodeDesc));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nodeSign));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nodeOrder));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(int1));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(int2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc2));
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
		strReturn.append(StrTool.cTrim(edorNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(edorType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(edorCase));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate2)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime2));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			nodeCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			parentID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			nodeLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			nodeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			childFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			nodeKey = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			runScript = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			nodeDesc = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			nodeSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			nodeOrder = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).intValue();
			int1 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).intValue();
			int2 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|")))).intValue();
			varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			makeDate2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
			makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MMenuBSchema";
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
		if (FCode.equalsIgnoreCase("nodeCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeCode));
		if (FCode.equalsIgnoreCase("parentID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(parentID));
		if (FCode.equalsIgnoreCase("nodeLevel"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeLevel));
		if (FCode.equalsIgnoreCase("nodeName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeName));
		if (FCode.equalsIgnoreCase("childFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(childFlag));
		if (FCode.equalsIgnoreCase("nodeKey"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeKey));
		if (FCode.equalsIgnoreCase("runScript"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(runScript));
		if (FCode.equalsIgnoreCase("nodeDesc"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeDesc));
		if (FCode.equalsIgnoreCase("nodeSign"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeSign));
		if (FCode.equalsIgnoreCase("nodeOrder"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeOrder));
		if (FCode.equalsIgnoreCase("int1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(int1));
		if (FCode.equalsIgnoreCase("int2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(int2));
		if (FCode.equalsIgnoreCase("varc1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc1));
		if (FCode.equalsIgnoreCase("varc2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc2));
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
		if (FCode.equalsIgnoreCase("edorNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorNo));
		if (FCode.equalsIgnoreCase("edorType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorType));
		if (FCode.equalsIgnoreCase("edorCase"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(edorCase));
		if (FCode.equalsIgnoreCase("operator2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator2));
		if (FCode.equalsIgnoreCase("makeDate2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
		if (FCode.equalsIgnoreCase("makeTime2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime2));
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
			strFieldValue = StrTool.GBKToUnicode(nodeCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(parentID);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(nodeLevel);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(nodeName);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(childFlag);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(nodeKey);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(runScript);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(nodeDesc);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(nodeSign);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(nodeOrder);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(int1);
			break;

		case 11: // '\013'
			strFieldValue = String.valueOf(int2);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(varc1);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(varc2);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(edorNo);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(edorType);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(edorCase);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(operator2);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(makeTime2);
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
		if (FCode.equalsIgnoreCase("nodeCode"))
			if (FValue != null && !FValue.equals(""))
				nodeCode = FValue.trim();
			else
				nodeCode = null;
		if (FCode.equalsIgnoreCase("parentID"))
			if (FValue != null && !FValue.equals(""))
				parentID = FValue.trim();
			else
				parentID = null;
		if (FCode.equalsIgnoreCase("nodeLevel"))
			if (FValue != null && !FValue.equals(""))
				nodeLevel = FValue.trim();
			else
				nodeLevel = null;
		if (FCode.equalsIgnoreCase("nodeName"))
			if (FValue != null && !FValue.equals(""))
				nodeName = FValue.trim();
			else
				nodeName = null;
		if (FCode.equalsIgnoreCase("childFlag"))
			if (FValue != null && !FValue.equals(""))
				childFlag = FValue.trim();
			else
				childFlag = null;
		if (FCode.equalsIgnoreCase("nodeKey"))
			if (FValue != null && !FValue.equals(""))
				nodeKey = FValue.trim();
			else
				nodeKey = null;
		if (FCode.equalsIgnoreCase("runScript"))
			if (FValue != null && !FValue.equals(""))
				runScript = FValue.trim();
			else
				runScript = null;
		if (FCode.equalsIgnoreCase("nodeDesc"))
			if (FValue != null && !FValue.equals(""))
				nodeDesc = FValue.trim();
			else
				nodeDesc = null;
		if (FCode.equalsIgnoreCase("nodeSign"))
			if (FValue != null && !FValue.equals(""))
				nodeSign = FValue.trim();
			else
				nodeSign = null;
		if (FCode.equalsIgnoreCase("nodeOrder") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			nodeOrder = i;
		}
		if (FCode.equalsIgnoreCase("int1") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			int1 = i;
		}
		if (FCode.equalsIgnoreCase("int2") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			int2 = i;
		}
		if (FCode.equalsIgnoreCase("varc1"))
			if (FValue != null && !FValue.equals(""))
				varc1 = FValue.trim();
			else
				varc1 = null;
		if (FCode.equalsIgnoreCase("varc2"))
			if (FValue != null && !FValue.equals(""))
				varc2 = FValue.trim();
			else
				varc2 = null;
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
		if (FCode.equalsIgnoreCase("edorNo"))
			if (FValue != null && !FValue.equals(""))
				edorNo = FValue.trim();
			else
				edorNo = null;
		if (FCode.equalsIgnoreCase("edorType"))
			if (FValue != null && !FValue.equals(""))
				edorType = FValue.trim();
			else
				edorType = null;
		if (FCode.equalsIgnoreCase("edorCase"))
			if (FValue != null && !FValue.equals(""))
				edorCase = FValue.trim();
			else
				edorCase = null;
		if (FCode.equalsIgnoreCase("operator2"))
			if (FValue != null && !FValue.equals(""))
				operator2 = FValue.trim();
			else
				operator2 = null;
		if (FCode.equalsIgnoreCase("makeDate2"))
			if (FValue != null && !FValue.equals(""))
				makeDate2 = fDate.getDate(FValue);
			else
				makeDate2 = null;
		if (FCode.equalsIgnoreCase("makeTime2"))
			if (FValue != null && !FValue.equals(""))
				makeTime2 = FValue.trim();
			else
				makeTime2 = null;
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
		MMenuBSchema other = (MMenuBSchema)otherObject;
		if (nodeCode == null && other.getNodeCode() != null)
			return false;
		if (nodeCode != null && !nodeCode.equals(other.getNodeCode()))
			return false;
		if (parentID == null && other.getParentID() != null)
			return false;
		if (parentID != null && !parentID.equals(other.getParentID()))
			return false;
		if (nodeLevel == null && other.getNodeLevel() != null)
			return false;
		if (nodeLevel != null && !nodeLevel.equals(other.getNodeLevel()))
			return false;
		if (nodeName == null && other.getNodeName() != null)
			return false;
		if (nodeName != null && !nodeName.equals(other.getNodeName()))
			return false;
		if (childFlag == null && other.getChildFlag() != null)
			return false;
		if (childFlag != null && !childFlag.equals(other.getChildFlag()))
			return false;
		if (nodeKey == null && other.getNodeKey() != null)
			return false;
		if (nodeKey != null && !nodeKey.equals(other.getNodeKey()))
			return false;
		if (runScript == null && other.getRunScript() != null)
			return false;
		if (runScript != null && !runScript.equals(other.getRunScript()))
			return false;
		if (nodeDesc == null && other.getNodeDesc() != null)
			return false;
		if (nodeDesc != null && !nodeDesc.equals(other.getNodeDesc()))
			return false;
		if (nodeSign == null && other.getNodeSign() != null)
			return false;
		if (nodeSign != null && !nodeSign.equals(other.getNodeSign()))
			return false;
		if (nodeOrder != other.getNodeOrder())
			return false;
		if (int1 != other.getInt1())
			return false;
		if (int2 != other.getInt2())
			return false;
		if (varc1 == null && other.getVarc1() != null)
			return false;
		if (varc1 != null && !varc1.equals(other.getVarc1()))
			return false;
		if (varc2 == null && other.getVarc2() != null)
			return false;
		if (varc2 != null && !varc2.equals(other.getVarc2()))
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
		if (edorNo == null && other.getEdorNo() != null)
			return false;
		if (edorNo != null && !edorNo.equals(other.getEdorNo()))
			return false;
		if (edorType == null && other.getEdorType() != null)
			return false;
		if (edorType != null && !edorType.equals(other.getEdorType()))
			return false;
		if (edorCase == null && other.getEdorCase() != null)
			return false;
		if (edorCase != null && !edorCase.equals(other.getEdorCase()))
			return false;
		if (operator2 == null && other.getOperator2() != null)
			return false;
		if (operator2 != null && !operator2.equals(other.getOperator2()))
			return false;
		if (makeDate2 == null && other.getMakeDate2() != null)
			return false;
		if (makeDate2 != null && !fDate.getString(makeDate2).equals(other.getMakeDate2()))
			return false;
		if (makeTime2 == null && other.getMakeTime2() != null)
			return false;
		return makeTime2 == null || makeTime2.equals(other.getMakeTime2());
	}

	public int getFieldCount()
	{
		return 25;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("nodeCode"))
			return 0;
		if (strFieldName.equals("parentID"))
			return 1;
		if (strFieldName.equals("nodeLevel"))
			return 2;
		if (strFieldName.equals("nodeName"))
			return 3;
		if (strFieldName.equals("childFlag"))
			return 4;
		if (strFieldName.equals("nodeKey"))
			return 5;
		if (strFieldName.equals("runScript"))
			return 6;
		if (strFieldName.equals("nodeDesc"))
			return 7;
		if (strFieldName.equals("nodeSign"))
			return 8;
		if (strFieldName.equals("nodeOrder"))
			return 9;
		if (strFieldName.equals("int1"))
			return 10;
		if (strFieldName.equals("int2"))
			return 11;
		if (strFieldName.equals("varc1"))
			return 12;
		if (strFieldName.equals("varc2"))
			return 13;
		if (strFieldName.equals("operator"))
			return 14;
		if (strFieldName.equals("makeDate"))
			return 15;
		if (strFieldName.equals("makeTime"))
			return 16;
		if (strFieldName.equals("modifyDate"))
			return 17;
		if (strFieldName.equals("modifyTime"))
			return 18;
		if (strFieldName.equals("edorNo"))
			return 19;
		if (strFieldName.equals("edorType"))
			return 20;
		if (strFieldName.equals("edorCase"))
			return 21;
		if (strFieldName.equals("operator2"))
			return 22;
		if (strFieldName.equals("makeDate2"))
			return 23;
		return !strFieldName.equals("makeTime2") ? -1 : 24;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "nodeCode";
			break;

		case 1: // '\001'
			strFieldName = "parentID";
			break;

		case 2: // '\002'
			strFieldName = "nodeLevel";
			break;

		case 3: // '\003'
			strFieldName = "nodeName";
			break;

		case 4: // '\004'
			strFieldName = "childFlag";
			break;

		case 5: // '\005'
			strFieldName = "nodeKey";
			break;

		case 6: // '\006'
			strFieldName = "runScript";
			break;

		case 7: // '\007'
			strFieldName = "nodeDesc";
			break;

		case 8: // '\b'
			strFieldName = "nodeSign";
			break;

		case 9: // '\t'
			strFieldName = "nodeOrder";
			break;

		case 10: // '\n'
			strFieldName = "int1";
			break;

		case 11: // '\013'
			strFieldName = "int2";
			break;

		case 12: // '\f'
			strFieldName = "varc1";
			break;

		case 13: // '\r'
			strFieldName = "varc2";
			break;

		case 14: // '\016'
			strFieldName = "operator";
			break;

		case 15: // '\017'
			strFieldName = "makeDate";
			break;

		case 16: // '\020'
			strFieldName = "makeTime";
			break;

		case 17: // '\021'
			strFieldName = "modifyDate";
			break;

		case 18: // '\022'
			strFieldName = "modifyTime";
			break;

		case 19: // '\023'
			strFieldName = "edorNo";
			break;

		case 20: // '\024'
			strFieldName = "edorType";
			break;

		case 21: // '\025'
			strFieldName = "edorCase";
			break;

		case 22: // '\026'
			strFieldName = "operator2";
			break;

		case 23: // '\027'
			strFieldName = "makeDate2";
			break;

		case 24: // '\030'
			strFieldName = "makeTime2";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("nodeCode"))
			return 0;
		if (strFieldName.equals("parentID"))
			return 0;
		if (strFieldName.equals("nodeLevel"))
			return 0;
		if (strFieldName.equals("nodeName"))
			return 0;
		if (strFieldName.equals("childFlag"))
			return 0;
		if (strFieldName.equals("nodeKey"))
			return 0;
		if (strFieldName.equals("runScript"))
			return 0;
		if (strFieldName.equals("nodeDesc"))
			return 0;
		if (strFieldName.equals("nodeSign"))
			return 0;
		if (strFieldName.equals("nodeOrder"))
			return 3;
		if (strFieldName.equals("int1"))
			return 3;
		if (strFieldName.equals("int2"))
			return 3;
		if (strFieldName.equals("varc1"))
			return 0;
		if (strFieldName.equals("varc2"))
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
		if (strFieldName.equals("edorNo"))
			return 0;
		if (strFieldName.equals("edorType"))
			return 0;
		if (strFieldName.equals("edorCase"))
			return 0;
		if (strFieldName.equals("operator2"))
			return 0;
		if (strFieldName.equals("makeDate2"))
			return 1;
		return !strFieldName.equals("makeTime2") ? -1 : 0;
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
			nFieldType = 3;
			break;

		case 10: // '\n'
			nFieldType = 3;
			break;

		case 11: // '\013'
			nFieldType = 3;
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
			nFieldType = 1;
			break;

		case 16: // '\020'
			nFieldType = 0;
			break;

		case 17: // '\021'
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
