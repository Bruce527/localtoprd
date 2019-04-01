// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMenuSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MMenuDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MMenuSchema
	implements Schema, Cloneable
{

	private String nodeCode;
	private String nodeName;
	private String parentNodeCode;
	private String nodeLevel;
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
	public static final int FIELDNUM = 19;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MMenuSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "NodeCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MMenuSchema cloned = (MMenuSchema)super.clone();
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

	public String getNodeName()
	{
		return nodeName;
	}

	public void setNodeName(String aNodeName)
	{
		nodeName = aNodeName;
	}

	public String getParentNodeCode()
	{
		return parentNodeCode;
	}

	public void setParentNodeCode(String aParentNodeCode)
	{
		parentNodeCode = aParentNodeCode;
	}

	public String getNodeLevel()
	{
		return nodeLevel;
	}

	public void setNodeLevel(String aNodeLevel)
	{
		nodeLevel = aNodeLevel;
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

	public void setSchema(MMenuSchema aMMenuSchema)
	{
		nodeCode = aMMenuSchema.getNodeCode();
		nodeName = aMMenuSchema.getNodeName();
		parentNodeCode = aMMenuSchema.getParentNodeCode();
		nodeLevel = aMMenuSchema.getNodeLevel();
		childFlag = aMMenuSchema.getChildFlag();
		nodeKey = aMMenuSchema.getNodeKey();
		runScript = aMMenuSchema.getRunScript();
		nodeDesc = aMMenuSchema.getNodeDesc();
		nodeSign = aMMenuSchema.getNodeSign();
		nodeOrder = aMMenuSchema.getNodeOrder();
		int1 = aMMenuSchema.getInt1();
		int2 = aMMenuSchema.getInt2();
		varc1 = aMMenuSchema.getVarc1();
		varc2 = aMMenuSchema.getVarc2();
		operator = aMMenuSchema.getOperator();
		makeDate = fDate.getDate(aMMenuSchema.getMakeDate());
		makeTime = aMMenuSchema.getMakeTime();
		modifyDate = fDate.getDate(aMMenuSchema.getModifyDate());
		modifyTime = aMMenuSchema.getModifyTime();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("NodeCode") == null)
				nodeCode = null;
			else
				nodeCode = rs.getString("NodeCode").trim();
			if (rs.getString("NodeName") == null)
				nodeName = null;
			else
				nodeName = rs.getString("NodeName").trim();
			if (rs.getString("ParentNodeCode") == null)
				parentNodeCode = null;
			else
				parentNodeCode = rs.getString("ParentNodeCode").trim();
			if (rs.getString("NodeLevel") == null)
				nodeLevel = null;
			else
				nodeLevel = rs.getString("NodeLevel").trim();
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
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MMenu表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MMenuSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MMenuSchema getSchema()
	{
		MMenuSchema aMMenuSchema = new MMenuSchema();
		aMMenuSchema.setSchema(this);
		return aMMenuSchema;
	}

	public MMenuDB getDB()
	{
		MMenuDB aDBOper = new MMenuDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(nodeCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nodeName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(parentNodeCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nodeLevel));
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
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			nodeCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			nodeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			parentNodeCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			nodeLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
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
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MMenuSchema";
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
		if (FCode.equalsIgnoreCase("nodeName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeName));
		if (FCode.equalsIgnoreCase("parentNodeCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(parentNodeCode));
		if (FCode.equalsIgnoreCase("nodeLevel"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeLevel));
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
			strFieldValue = StrTool.GBKToUnicode(nodeName);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(parentNodeCode);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(nodeLevel);
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
		if (FCode.equalsIgnoreCase("nodeName"))
			if (FValue != null && !FValue.equals(""))
				nodeName = FValue.trim();
			else
				nodeName = null;
		if (FCode.equalsIgnoreCase("parentNodeCode"))
			if (FValue != null && !FValue.equals(""))
				parentNodeCode = FValue.trim();
			else
				parentNodeCode = null;
		if (FCode.equalsIgnoreCase("nodeLevel"))
			if (FValue != null && !FValue.equals(""))
				nodeLevel = FValue.trim();
			else
				nodeLevel = null;
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
		MMenuSchema other = (MMenuSchema)otherObject;
		if (nodeCode == null && other.getNodeCode() != null)
			return false;
		if (nodeCode != null && !nodeCode.equals(other.getNodeCode()))
			return false;
		if (nodeName == null && other.getNodeName() != null)
			return false;
		if (nodeName != null && !nodeName.equals(other.getNodeName()))
			return false;
		if (parentNodeCode == null && other.getParentNodeCode() != null)
			return false;
		if (parentNodeCode != null && !parentNodeCode.equals(other.getParentNodeCode()))
			return false;
		if (nodeLevel == null && other.getNodeLevel() != null)
			return false;
		if (nodeLevel != null && !nodeLevel.equals(other.getNodeLevel()))
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
		return modifyTime == null || modifyTime.equals(other.getModifyTime());
	}

	public int getFieldCount()
	{
		return 19;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("nodeCode"))
			return 0;
		if (strFieldName.equals("nodeName"))
			return 1;
		if (strFieldName.equals("parentNodeCode"))
			return 2;
		if (strFieldName.equals("nodeLevel"))
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
		return !strFieldName.equals("modifyTime") ? -1 : 18;
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
			strFieldName = "nodeName";
			break;

		case 2: // '\002'
			strFieldName = "parentNodeCode";
			break;

		case 3: // '\003'
			strFieldName = "nodeLevel";
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
		if (strFieldName.equals("nodeName"))
			return 0;
		if (strFieldName.equals("parentNodeCode"))
			return 0;
		if (strFieldName.equals("nodeLevel"))
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
