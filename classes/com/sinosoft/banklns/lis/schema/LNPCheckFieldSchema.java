// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCheckFieldSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPCheckFieldDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPCheckFieldSchema
	implements Schema, Cloneable
{

	private String riskCode;
	private String riskVer;
	private String fieldName;
	private String serialNo;
	private String calCode;
	private String pageLocation;
	private String location;
	private String msg;
	private String msgFlag;
	private String updFlag;
	private String valiFlag;
	private String returnValiFlag;
	public static final int FIELDNUM = 12;
	private static String PK[];
	public CErrors mErrors;

	public LNPCheckFieldSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[4];
		pk[0] = "RiskCode";
		pk[1] = "RiskVer";
		pk[2] = "FieldName";
		pk[3] = "SerialNo";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPCheckFieldSchema cloned = (LNPCheckFieldSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getRiskCode()
	{
		return riskCode;
	}

	public void setRiskCode(String aRiskCode)
	{
		riskCode = aRiskCode;
	}

	public String getRiskVer()
	{
		return riskVer;
	}

	public void setRiskVer(String aRiskVer)
	{
		riskVer = aRiskVer;
	}

	public String getFieldName()
	{
		return fieldName;
	}

	public void setFieldName(String aFieldName)
	{
		fieldName = aFieldName;
	}

	public String getSerialNo()
	{
		return serialNo;
	}

	public void setSerialNo(String aSerialNo)
	{
		serialNo = aSerialNo;
	}

	public String getCalCode()
	{
		return calCode;
	}

	public void setCalCode(String aCalCode)
	{
		calCode = aCalCode;
	}

	public String getPageLocation()
	{
		return pageLocation;
	}

	public void setPageLocation(String aPageLocation)
	{
		pageLocation = aPageLocation;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String aLocation)
	{
		location = aLocation;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String aMsg)
	{
		msg = aMsg;
	}

	public String getMsgFlag()
	{
		return msgFlag;
	}

	public void setMsgFlag(String aMsgFlag)
	{
		msgFlag = aMsgFlag;
	}

	public String getUpdFlag()
	{
		return updFlag;
	}

	public void setUpdFlag(String aUpdFlag)
	{
		updFlag = aUpdFlag;
	}

	public String getValiFlag()
	{
		return valiFlag;
	}

	public void setValiFlag(String aValiFlag)
	{
		valiFlag = aValiFlag;
	}

	public String getReturnValiFlag()
	{
		return returnValiFlag;
	}

	public void setReturnValiFlag(String aReturnValiFlag)
	{
		returnValiFlag = aReturnValiFlag;
	}

	public void setSchema(LNPCheckFieldSchema aLNPCheckFieldSchema)
	{
		riskCode = aLNPCheckFieldSchema.getRiskCode();
		riskVer = aLNPCheckFieldSchema.getRiskVer();
		fieldName = aLNPCheckFieldSchema.getFieldName();
		serialNo = aLNPCheckFieldSchema.getSerialNo();
		calCode = aLNPCheckFieldSchema.getCalCode();
		pageLocation = aLNPCheckFieldSchema.getPageLocation();
		location = aLNPCheckFieldSchema.getLocation();
		msg = aLNPCheckFieldSchema.getMsg();
		msgFlag = aLNPCheckFieldSchema.getMsgFlag();
		updFlag = aLNPCheckFieldSchema.getUpdFlag();
		valiFlag = aLNPCheckFieldSchema.getValiFlag();
		returnValiFlag = aLNPCheckFieldSchema.getReturnValiFlag();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			if (rs.getString("RiskVer") == null)
				riskVer = null;
			else
				riskVer = rs.getString("RiskVer").trim();
			if (rs.getString("FieldName") == null)
				fieldName = null;
			else
				fieldName = rs.getString("FieldName").trim();
			if (rs.getString("SerialNo") == null)
				serialNo = null;
			else
				serialNo = rs.getString("SerialNo").trim();
			if (rs.getString("CalCode") == null)
				calCode = null;
			else
				calCode = rs.getString("CalCode").trim();
			if (rs.getString("PageLocation") == null)
				pageLocation = null;
			else
				pageLocation = rs.getString("PageLocation").trim();
			if (rs.getString("Location") == null)
				location = null;
			else
				location = rs.getString("Location").trim();
			if (rs.getString("Msg") == null)
				msg = null;
			else
				msg = rs.getString("Msg").trim();
			if (rs.getString("MsgFlag") == null)
				msgFlag = null;
			else
				msgFlag = rs.getString("MsgFlag").trim();
			if (rs.getString("UpdFlag") == null)
				updFlag = null;
			else
				updFlag = rs.getString("UpdFlag").trim();
			if (rs.getString("ValiFlag") == null)
				valiFlag = null;
			else
				valiFlag = rs.getString("ValiFlag").trim();
			if (rs.getString("ReturnValiFlag") == null)
				returnValiFlag = null;
			else
				returnValiFlag = rs.getString("ReturnValiFlag").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LNPCheckField表字段个数和Schema中的字段个数不一致，或�?�执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPCheckFieldSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPCheckFieldSchema getSchema()
	{
		LNPCheckFieldSchema aLNPCheckFieldSchema = new LNPCheckFieldSchema();
		aLNPCheckFieldSchema.setSchema(this);
		return aLNPCheckFieldSchema;
	}

	public LNPCheckFieldDB getDB()
	{
		LNPCheckFieldDB aDBOper = new LNPCheckFieldDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(riskVer));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fieldName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(serialNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(calCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(pageLocation));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(location));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(msg));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(msgFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(updFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(valiFlag));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(returnValiFlag));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			riskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			fieldName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			calCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			pageLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			location = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			msg = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			msgFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			updFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			valiFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			returnValiFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCheckFieldSchema";
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
		if (FCode.equalsIgnoreCase("riskCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskCode));
		if (FCode.equalsIgnoreCase("riskVer"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(riskVer));
		if (FCode.equalsIgnoreCase("fieldName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fieldName));
		if (FCode.equalsIgnoreCase("serialNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(serialNo));
		if (FCode.equalsIgnoreCase("calCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(calCode));
		if (FCode.equalsIgnoreCase("pageLocation"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(pageLocation));
		if (FCode.equalsIgnoreCase("location"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(location));
		if (FCode.equalsIgnoreCase("msg"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(msg));
		if (FCode.equalsIgnoreCase("msgFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(msgFlag));
		if (FCode.equalsIgnoreCase("updFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(updFlag));
		if (FCode.equalsIgnoreCase("valiFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(valiFlag));
		if (FCode.equalsIgnoreCase("returnValiFlag"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(returnValiFlag));
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
			strFieldValue = StrTool.GBKToUnicode(riskCode);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(riskVer);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(fieldName);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(serialNo);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(calCode);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(pageLocation);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(location);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(msg);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(msgFlag);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(updFlag);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(valiFlag);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(returnValiFlag);
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
		if (FCode.equalsIgnoreCase("riskCode"))
			if (FValue != null && !FValue.equals(""))
				riskCode = FValue.trim();
			else
				riskCode = null;
		if (FCode.equalsIgnoreCase("riskVer"))
			if (FValue != null && !FValue.equals(""))
				riskVer = FValue.trim();
			else
				riskVer = null;
		if (FCode.equalsIgnoreCase("fieldName"))
			if (FValue != null && !FValue.equals(""))
				fieldName = FValue.trim();
			else
				fieldName = null;
		if (FCode.equalsIgnoreCase("serialNo"))
			if (FValue != null && !FValue.equals(""))
				serialNo = FValue.trim();
			else
				serialNo = null;
		if (FCode.equalsIgnoreCase("calCode"))
			if (FValue != null && !FValue.equals(""))
				calCode = FValue.trim();
			else
				calCode = null;
		if (FCode.equalsIgnoreCase("pageLocation"))
			if (FValue != null && !FValue.equals(""))
				pageLocation = FValue.trim();
			else
				pageLocation = null;
		if (FCode.equalsIgnoreCase("location"))
			if (FValue != null && !FValue.equals(""))
				location = FValue.trim();
			else
				location = null;
		if (FCode.equalsIgnoreCase("msg"))
			if (FValue != null && !FValue.equals(""))
				msg = FValue.trim();
			else
				msg = null;
		if (FCode.equalsIgnoreCase("msgFlag"))
			if (FValue != null && !FValue.equals(""))
				msgFlag = FValue.trim();
			else
				msgFlag = null;
		if (FCode.equalsIgnoreCase("updFlag"))
			if (FValue != null && !FValue.equals(""))
				updFlag = FValue.trim();
			else
				updFlag = null;
		if (FCode.equalsIgnoreCase("valiFlag"))
			if (FValue != null && !FValue.equals(""))
				valiFlag = FValue.trim();
			else
				valiFlag = null;
		if (FCode.equalsIgnoreCase("returnValiFlag"))
			if (FValue != null && !FValue.equals(""))
				returnValiFlag = FValue.trim();
			else
				returnValiFlag = null;
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
		LNPCheckFieldSchema other = (LNPCheckFieldSchema)otherObject;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (riskVer == null && other.getRiskVer() != null)
			return false;
		if (riskVer != null && !riskVer.equals(other.getRiskVer()))
			return false;
		if (fieldName == null && other.getFieldName() != null)
			return false;
		if (fieldName != null && !fieldName.equals(other.getFieldName()))
			return false;
		if (serialNo == null && other.getSerialNo() != null)
			return false;
		if (serialNo != null && !serialNo.equals(other.getSerialNo()))
			return false;
		if (calCode == null && other.getCalCode() != null)
			return false;
		if (calCode != null && !calCode.equals(other.getCalCode()))
			return false;
		if (pageLocation == null && other.getPageLocation() != null)
			return false;
		if (pageLocation != null && !pageLocation.equals(other.getPageLocation()))
			return false;
		if (location == null && other.getLocation() != null)
			return false;
		if (location != null && !location.equals(other.getLocation()))
			return false;
		if (msg == null && other.getMsg() != null)
			return false;
		if (msg != null && !msg.equals(other.getMsg()))
			return false;
		if (msgFlag == null && other.getMsgFlag() != null)
			return false;
		if (msgFlag != null && !msgFlag.equals(other.getMsgFlag()))
			return false;
		if (updFlag == null && other.getUpdFlag() != null)
			return false;
		if (updFlag != null && !updFlag.equals(other.getUpdFlag()))
			return false;
		if (valiFlag == null && other.getValiFlag() != null)
			return false;
		if (valiFlag != null && !valiFlag.equals(other.getValiFlag()))
			return false;
		if (returnValiFlag == null && other.getReturnValiFlag() != null)
			return false;
		return returnValiFlag == null || returnValiFlag.equals(other.getReturnValiFlag());
	}

	public int getFieldCount()
	{
		return 12;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVer"))
			return 1;
		if (strFieldName.equals("fieldName"))
			return 2;
		if (strFieldName.equals("serialNo"))
			return 3;
		if (strFieldName.equals("calCode"))
			return 4;
		if (strFieldName.equals("pageLocation"))
			return 5;
		if (strFieldName.equals("location"))
			return 6;
		if (strFieldName.equals("msg"))
			return 7;
		if (strFieldName.equals("msgFlag"))
			return 8;
		if (strFieldName.equals("updFlag"))
			return 9;
		if (strFieldName.equals("valiFlag"))
			return 10;
		return !strFieldName.equals("returnValiFlag") ? -1 : 11;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "riskCode";
			break;

		case 1: // '\001'
			strFieldName = "riskVer";
			break;

		case 2: // '\002'
			strFieldName = "fieldName";
			break;

		case 3: // '\003'
			strFieldName = "serialNo";
			break;

		case 4: // '\004'
			strFieldName = "calCode";
			break;

		case 5: // '\005'
			strFieldName = "pageLocation";
			break;

		case 6: // '\006'
			strFieldName = "location";
			break;

		case 7: // '\007'
			strFieldName = "msg";
			break;

		case 8: // '\b'
			strFieldName = "msgFlag";
			break;

		case 9: // '\t'
			strFieldName = "updFlag";
			break;

		case 10: // '\n'
			strFieldName = "valiFlag";
			break;

		case 11: // '\013'
			strFieldName = "returnValiFlag";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("riskVer"))
			return 0;
		if (strFieldName.equals("fieldName"))
			return 0;
		if (strFieldName.equals("serialNo"))
			return 0;
		if (strFieldName.equals("calCode"))
			return 0;
		if (strFieldName.equals("pageLocation"))
			return 0;
		if (strFieldName.equals("location"))
			return 0;
		if (strFieldName.equals("msg"))
			return 0;
		if (strFieldName.equals("msgFlag"))
			return 0;
		if (strFieldName.equals("updFlag"))
			return 0;
		if (strFieldName.equals("valiFlag"))
			return 0;
		return !strFieldName.equals("returnValiFlag") ? -1 : 0;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
