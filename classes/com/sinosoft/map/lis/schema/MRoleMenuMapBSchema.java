// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MRoleMenuMapBSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MRoleMenuMapBDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MRoleMenuMapBSchema
	implements Schema, Cloneable
{

	private String iD;
	private String roleID;
	private String menuID;
	private String type;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private int int1;
	private int int2;
	private String varc1;
	private String varc2;
	private String edorNo;
	private String edorType;
	private String edorCase;
	private String operator2;
	private Date makeDate2;
	private String makeTime2;
	public static final int FIELDNUM = 19;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MRoleMenuMapBSchema()
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
		MRoleMenuMapBSchema cloned = (MRoleMenuMapBSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getID()
	{
		return iD;
	}

	public void setID(String aID)
	{
		iD = aID;
	}

	public String getRoleID()
	{
		return roleID;
	}

	public void setRoleID(String aRoleID)
	{
		roleID = aRoleID;
	}

	public String getMenuID()
	{
		return menuID;
	}

	public void setMenuID(String aMenuID)
	{
		menuID = aMenuID;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
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

	public void setSchema(MRoleMenuMapBSchema aMRoleMenuMapBSchema)
	{
		iD = aMRoleMenuMapBSchema.getID();
		roleID = aMRoleMenuMapBSchema.getRoleID();
		menuID = aMRoleMenuMapBSchema.getMenuID();
		type = aMRoleMenuMapBSchema.getType();
		operator = aMRoleMenuMapBSchema.getOperator();
		makeDate = fDate.getDate(aMRoleMenuMapBSchema.getMakeDate());
		makeTime = aMRoleMenuMapBSchema.getMakeTime();
		modifyDate = fDate.getDate(aMRoleMenuMapBSchema.getModifyDate());
		modifyTime = aMRoleMenuMapBSchema.getModifyTime();
		int1 = aMRoleMenuMapBSchema.getInt1();
		int2 = aMRoleMenuMapBSchema.getInt2();
		varc1 = aMRoleMenuMapBSchema.getVarc1();
		varc2 = aMRoleMenuMapBSchema.getVarc2();
		edorNo = aMRoleMenuMapBSchema.getEdorNo();
		edorType = aMRoleMenuMapBSchema.getEdorType();
		edorCase = aMRoleMenuMapBSchema.getEdorCase();
		operator2 = aMRoleMenuMapBSchema.getOperator2();
		makeDate2 = fDate.getDate(aMRoleMenuMapBSchema.getMakeDate2());
		makeTime2 = aMRoleMenuMapBSchema.getMakeTime2();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ID") == null)
				iD = null;
			else
				iD = rs.getString("ID").trim();
			if (rs.getString("RoleID") == null)
				roleID = null;
			else
				roleID = rs.getString("RoleID").trim();
			if (rs.getString("MenuID") == null)
				menuID = null;
			else
				menuID = rs.getString("MenuID").trim();
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
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
			System.out.println("数据库中的MRoleMenuMapB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MRoleMenuMapBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MRoleMenuMapBSchema getSchema()
	{
		MRoleMenuMapBSchema aMRoleMenuMapBSchema = new MRoleMenuMapBSchema();
		aMRoleMenuMapBSchema.setSchema(this);
		return aMRoleMenuMapBSchema;
	}

	public MRoleMenuMapBDB getDB()
	{
		MRoleMenuMapBDB aDBOper = new MRoleMenuMapBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(iD));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(roleID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(menuID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(type));
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
		strReturn.append(ChgData.chgData(int1));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(int2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(varc2));
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
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			roleID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			menuID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			int1 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).intValue();
			int2 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).intValue();
			varc1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			varc2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			edorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			edorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			edorCase = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			makeDate2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
			makeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MRoleMenuMapBSchema";
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
		if (FCode.equalsIgnoreCase("iD"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iD));
		if (FCode.equalsIgnoreCase("roleID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(roleID));
		if (FCode.equalsIgnoreCase("menuID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(menuID));
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
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
		if (FCode.equalsIgnoreCase("int1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(int1));
		if (FCode.equalsIgnoreCase("int2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(int2));
		if (FCode.equalsIgnoreCase("varc1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc1));
		if (FCode.equalsIgnoreCase("varc2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(varc2));
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
			strFieldValue = StrTool.GBKToUnicode(iD);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(roleID);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(menuID);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(int1);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(int2);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(varc1);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(varc2);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(edorNo);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(edorType);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(edorCase);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(operator2);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate2()));
			break;

		case 18: // '\022'
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
		if (FCode.equalsIgnoreCase("iD"))
			if (FValue != null && !FValue.equals(""))
				iD = FValue.trim();
			else
				iD = null;
		if (FCode.equalsIgnoreCase("roleID"))
			if (FValue != null && !FValue.equals(""))
				roleID = FValue.trim();
			else
				roleID = null;
		if (FCode.equalsIgnoreCase("menuID"))
			if (FValue != null && !FValue.equals(""))
				menuID = FValue.trim();
			else
				menuID = null;
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
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
		MRoleMenuMapBSchema other = (MRoleMenuMapBSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (roleID == null && other.getRoleID() != null)
			return false;
		if (roleID != null && !roleID.equals(other.getRoleID()))
			return false;
		if (menuID == null && other.getMenuID() != null)
			return false;
		if (menuID != null && !menuID.equals(other.getMenuID()))
			return false;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
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
		return 19;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("roleID"))
			return 1;
		if (strFieldName.equals("menuID"))
			return 2;
		if (strFieldName.equals("type"))
			return 3;
		if (strFieldName.equals("operator"))
			return 4;
		if (strFieldName.equals("makeDate"))
			return 5;
		if (strFieldName.equals("makeTime"))
			return 6;
		if (strFieldName.equals("modifyDate"))
			return 7;
		if (strFieldName.equals("modifyTime"))
			return 8;
		if (strFieldName.equals("int1"))
			return 9;
		if (strFieldName.equals("int2"))
			return 10;
		if (strFieldName.equals("varc1"))
			return 11;
		if (strFieldName.equals("varc2"))
			return 12;
		if (strFieldName.equals("edorNo"))
			return 13;
		if (strFieldName.equals("edorType"))
			return 14;
		if (strFieldName.equals("edorCase"))
			return 15;
		if (strFieldName.equals("operator2"))
			return 16;
		if (strFieldName.equals("makeDate2"))
			return 17;
		return !strFieldName.equals("makeTime2") ? -1 : 18;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "iD";
			break;

		case 1: // '\001'
			strFieldName = "roleID";
			break;

		case 2: // '\002'
			strFieldName = "menuID";
			break;

		case 3: // '\003'
			strFieldName = "type";
			break;

		case 4: // '\004'
			strFieldName = "operator";
			break;

		case 5: // '\005'
			strFieldName = "makeDate";
			break;

		case 6: // '\006'
			strFieldName = "makeTime";
			break;

		case 7: // '\007'
			strFieldName = "modifyDate";
			break;

		case 8: // '\b'
			strFieldName = "modifyTime";
			break;

		case 9: // '\t'
			strFieldName = "int1";
			break;

		case 10: // '\n'
			strFieldName = "int2";
			break;

		case 11: // '\013'
			strFieldName = "varc1";
			break;

		case 12: // '\f'
			strFieldName = "varc2";
			break;

		case 13: // '\r'
			strFieldName = "edorNo";
			break;

		case 14: // '\016'
			strFieldName = "edorType";
			break;

		case 15: // '\017'
			strFieldName = "edorCase";
			break;

		case 16: // '\020'
			strFieldName = "operator2";
			break;

		case 17: // '\021'
			strFieldName = "makeDate2";
			break;

		case 18: // '\022'
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
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("roleID"))
			return 0;
		if (strFieldName.equals("menuID"))
			return 0;
		if (strFieldName.equals("type"))
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
		if (strFieldName.equals("int1"))
			return 3;
		if (strFieldName.equals("int2"))
			return 3;
		if (strFieldName.equals("varc1"))
			return 0;
		if (strFieldName.equals("varc2"))
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
			nFieldType = 1;
			break;

		case 6: // '\006'
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 1;
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
