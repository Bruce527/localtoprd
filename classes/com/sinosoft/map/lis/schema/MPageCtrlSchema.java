// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MPageCtrlSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MPageCtrlDB;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MPageCtrlSchema
	implements Schema, Cloneable
{

	private String iD;
	private String roleID;
	private String menuID;
	private String buttonType;
	private String buttonID;
	private String buttonName;
	private int buttonSwitch;
	private String controlFlag;
	private String buttonDescription;
	public static final int FIELDNUM = 9;
	private static String PK[];
	public CErrors mErrors;

	public MPageCtrlSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MPageCtrlSchema cloned = (MPageCtrlSchema)super.clone();
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

	public String getButtonType()
	{
		return buttonType;
	}

	public void setButtonType(String aButtonType)
	{
		buttonType = aButtonType;
	}

	public String getButtonID()
	{
		return buttonID;
	}

	public void setButtonID(String aButtonID)
	{
		buttonID = aButtonID;
	}

	public String getButtonName()
	{
		return buttonName;
	}

	public void setButtonName(String aButtonName)
	{
		buttonName = aButtonName;
	}

	public int getButtonSwitch()
	{
		return buttonSwitch;
	}

	public void setButtonSwitch(int aButtonSwitch)
	{
		buttonSwitch = aButtonSwitch;
	}

	public void setButtonSwitch(String aButtonSwitch)
	{
		if (aButtonSwitch != null && !aButtonSwitch.equals(""))
		{
			Integer tInteger = new Integer(aButtonSwitch);
			int i = tInteger.intValue();
			buttonSwitch = i;
		}
	}

	public String getControlFlag()
	{
		return controlFlag;
	}

	public void setControlFlag(String aControlFlag)
	{
		controlFlag = aControlFlag;
	}

	public String getButtonDescription()
	{
		return buttonDescription;
	}

	public void setButtonDescription(String aButtonDescription)
	{
		buttonDescription = aButtonDescription;
	}

	public void setSchema(MPageCtrlSchema aMPageCtrlSchema)
	{
		iD = aMPageCtrlSchema.getID();
		roleID = aMPageCtrlSchema.getRoleID();
		menuID = aMPageCtrlSchema.getMenuID();
		buttonType = aMPageCtrlSchema.getButtonType();
		buttonID = aMPageCtrlSchema.getButtonID();
		buttonName = aMPageCtrlSchema.getButtonName();
		buttonSwitch = aMPageCtrlSchema.getButtonSwitch();
		controlFlag = aMPageCtrlSchema.getControlFlag();
		buttonDescription = aMPageCtrlSchema.getButtonDescription();
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
			if (rs.getString("ButtonType") == null)
				buttonType = null;
			else
				buttonType = rs.getString("ButtonType").trim();
			if (rs.getString("ButtonID") == null)
				buttonID = null;
			else
				buttonID = rs.getString("ButtonID").trim();
			if (rs.getString("ButtonName") == null)
				buttonName = null;
			else
				buttonName = rs.getString("ButtonName").trim();
			buttonSwitch = rs.getInt("ButtonSwitch");
			if (rs.getString("ControlFlag") == null)
				controlFlag = null;
			else
				controlFlag = rs.getString("ControlFlag").trim();
			if (rs.getString("ButtonDescription") == null)
				buttonDescription = null;
			else
				buttonDescription = rs.getString("ButtonDescription").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MPageCtrl表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MPageCtrlSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MPageCtrlSchema getSchema()
	{
		MPageCtrlSchema aMPageCtrlSchema = new MPageCtrlSchema();
		aMPageCtrlSchema.setSchema(this);
		return aMPageCtrlSchema;
	}

	public MPageCtrlDB getDB()
	{
		MPageCtrlDB aDBOper = new MPageCtrlDB();
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
		strReturn.append(StrTool.cTrim(buttonType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(buttonID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(buttonName));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(buttonSwitch));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(controlFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(buttonDescription));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			roleID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			menuID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			buttonType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			buttonID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			buttonName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			buttonSwitch = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).intValue();
			controlFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			buttonDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MPageCtrlSchema";
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
		if (FCode.equalsIgnoreCase("buttonType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(buttonType));
		if (FCode.equalsIgnoreCase("buttonID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(buttonID));
		if (FCode.equalsIgnoreCase("buttonName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(buttonName));
		if (FCode.equalsIgnoreCase("buttonSwitch"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(buttonSwitch));
		if (FCode.equalsIgnoreCase("controlFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(controlFlag));
		if (FCode.equalsIgnoreCase("buttonDescription"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(buttonDescription));
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
			strFieldValue = StrTool.GBKToUnicode(buttonType);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(buttonID);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(buttonName);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(buttonSwitch);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(controlFlag);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(buttonDescription);
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
		if (FCode.equalsIgnoreCase("buttonType"))
			if (FValue != null && !FValue.equals(""))
				buttonType = FValue.trim();
			else
				buttonType = null;
		if (FCode.equalsIgnoreCase("buttonID"))
			if (FValue != null && !FValue.equals(""))
				buttonID = FValue.trim();
			else
				buttonID = null;
		if (FCode.equalsIgnoreCase("buttonName"))
			if (FValue != null && !FValue.equals(""))
				buttonName = FValue.trim();
			else
				buttonName = null;
		if (FCode.equalsIgnoreCase("buttonSwitch") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			buttonSwitch = i;
		}
		if (FCode.equalsIgnoreCase("controlFlag"))
			if (FValue != null && !FValue.equals(""))
				controlFlag = FValue.trim();
			else
				controlFlag = null;
		if (FCode.equalsIgnoreCase("buttonDescription"))
			if (FValue != null && !FValue.equals(""))
				buttonDescription = FValue.trim();
			else
				buttonDescription = null;
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
		MPageCtrlSchema other = (MPageCtrlSchema)otherObject;
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
		if (buttonType == null && other.getButtonType() != null)
			return false;
		if (buttonType != null && !buttonType.equals(other.getButtonType()))
			return false;
		if (buttonID == null && other.getButtonID() != null)
			return false;
		if (buttonID != null && !buttonID.equals(other.getButtonID()))
			return false;
		if (buttonName == null && other.getButtonName() != null)
			return false;
		if (buttonName != null && !buttonName.equals(other.getButtonName()))
			return false;
		if (buttonSwitch != other.getButtonSwitch())
			return false;
		if (controlFlag == null && other.getControlFlag() != null)
			return false;
		if (controlFlag != null && !controlFlag.equals(other.getControlFlag()))
			return false;
		if (buttonDescription == null && other.getButtonDescription() != null)
			return false;
		return buttonDescription == null || buttonDescription.equals(other.getButtonDescription());
	}

	public int getFieldCount()
	{
		return 9;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("roleID"))
			return 1;
		if (strFieldName.equals("menuID"))
			return 2;
		if (strFieldName.equals("buttonType"))
			return 3;
		if (strFieldName.equals("buttonID"))
			return 4;
		if (strFieldName.equals("buttonName"))
			return 5;
		if (strFieldName.equals("buttonSwitch"))
			return 6;
		if (strFieldName.equals("controlFlag"))
			return 7;
		return !strFieldName.equals("buttonDescription") ? -1 : 8;
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
			strFieldName = "buttonType";
			break;

		case 4: // '\004'
			strFieldName = "buttonID";
			break;

		case 5: // '\005'
			strFieldName = "buttonName";
			break;

		case 6: // '\006'
			strFieldName = "buttonSwitch";
			break;

		case 7: // '\007'
			strFieldName = "controlFlag";
			break;

		case 8: // '\b'
			strFieldName = "buttonDescription";
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
		if (strFieldName.equals("buttonType"))
			return 0;
		if (strFieldName.equals("buttonID"))
			return 0;
		if (strFieldName.equals("buttonName"))
			return 0;
		if (strFieldName.equals("buttonSwitch"))
			return 3;
		if (strFieldName.equals("controlFlag"))
			return 0;
		return !strFieldName.equals("buttonDescription") ? -1 : 0;
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
			nFieldType = 3;
			break;

		case 7: // '\007'
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
