// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskScreenSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPRiskScreenDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPRiskScreenSchema
	implements Schema, Cloneable
{

	private String riskCode;
	private int ctrlIndex;
	private String ctrlType;
	private String ctrlCode;
	private String ctrlName;
	private String ctrlLevel;
	private String ctrlProperty;
	private int ctrlAlignX;
	private int ctrlAlignY;
	private int ctrlHorizontal;
	private int ctrlVertical;
	private String ctrlBackground;
	private int labelAlignX;
	private int labelAlignY;
	private int labelHorizontal;
	private int labelVertical;
	private String labelBackground;
	private String defaultValue;
	private String defaultSql;
	private String ctrlProperty1;
	private String ctrlProperty2;
	private String noti;
	public static final int FIELDNUM = 22;
	private static String PK[];
	public CErrors mErrors;

	public LNPRiskScreenSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[2];
		pk[0] = "RiskCode";
		pk[1] = "CtrlIndex";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPRiskScreenSchema cloned = (LNPRiskScreenSchema)super.clone();
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

	public int getCtrlIndex()
	{
		return ctrlIndex;
	}

	public void setCtrlIndex(int aCtrlIndex)
	{
		ctrlIndex = aCtrlIndex;
	}

	public void setCtrlIndex(String aCtrlIndex)
	{
		if (aCtrlIndex != null && !aCtrlIndex.equals(""))
		{
			Integer tInteger = new Integer(aCtrlIndex);
			int i = tInteger.intValue();
			ctrlIndex = i;
		}
	}

	public String getCtrlType()
	{
		return ctrlType;
	}

	public void setCtrlType(String aCtrlType)
	{
		ctrlType = aCtrlType;
	}

	public String getCtrlCode()
	{
		return ctrlCode;
	}

	public void setCtrlCode(String aCtrlCode)
	{
		ctrlCode = aCtrlCode;
	}

	public String getCtrlName()
	{
		return ctrlName;
	}

	public void setCtrlName(String aCtrlName)
	{
		ctrlName = aCtrlName;
	}

	public String getCtrlLevel()
	{
		return ctrlLevel;
	}

	public void setCtrlLevel(String aCtrlLevel)
	{
		ctrlLevel = aCtrlLevel;
	}

	public String getCtrlProperty()
	{
		return ctrlProperty;
	}

	public void setCtrlProperty(String aCtrlProperty)
	{
		ctrlProperty = aCtrlProperty;
	}

	public int getCtrlAlignX()
	{
		return ctrlAlignX;
	}

	public void setCtrlAlignX(int aCtrlAlignX)
	{
		ctrlAlignX = aCtrlAlignX;
	}

	public void setCtrlAlignX(String aCtrlAlignX)
	{
		if (aCtrlAlignX != null && !aCtrlAlignX.equals(""))
		{
			Integer tInteger = new Integer(aCtrlAlignX);
			int i = tInteger.intValue();
			ctrlAlignX = i;
		}
	}

	public int getCtrlAlignY()
	{
		return ctrlAlignY;
	}

	public void setCtrlAlignY(int aCtrlAlignY)
	{
		ctrlAlignY = aCtrlAlignY;
	}

	public void setCtrlAlignY(String aCtrlAlignY)
	{
		if (aCtrlAlignY != null && !aCtrlAlignY.equals(""))
		{
			Integer tInteger = new Integer(aCtrlAlignY);
			int i = tInteger.intValue();
			ctrlAlignY = i;
		}
	}

	public int getCtrlHorizontal()
	{
		return ctrlHorizontal;
	}

	public void setCtrlHorizontal(int aCtrlHorizontal)
	{
		ctrlHorizontal = aCtrlHorizontal;
	}

	public void setCtrlHorizontal(String aCtrlHorizontal)
	{
		if (aCtrlHorizontal != null && !aCtrlHorizontal.equals(""))
		{
			Integer tInteger = new Integer(aCtrlHorizontal);
			int i = tInteger.intValue();
			ctrlHorizontal = i;
		}
	}

	public int getCtrlVertical()
	{
		return ctrlVertical;
	}

	public void setCtrlVertical(int aCtrlVertical)
	{
		ctrlVertical = aCtrlVertical;
	}

	public void setCtrlVertical(String aCtrlVertical)
	{
		if (aCtrlVertical != null && !aCtrlVertical.equals(""))
		{
			Integer tInteger = new Integer(aCtrlVertical);
			int i = tInteger.intValue();
			ctrlVertical = i;
		}
	}

	public String getCtrlBackground()
	{
		return ctrlBackground;
	}

	public void setCtrlBackground(String aCtrlBackground)
	{
		ctrlBackground = aCtrlBackground;
	}

	public int getLabelAlignX()
	{
		return labelAlignX;
	}

	public void setLabelAlignX(int aLabelAlignX)
	{
		labelAlignX = aLabelAlignX;
	}

	public void setLabelAlignX(String aLabelAlignX)
	{
		if (aLabelAlignX != null && !aLabelAlignX.equals(""))
		{
			Integer tInteger = new Integer(aLabelAlignX);
			int i = tInteger.intValue();
			labelAlignX = i;
		}
	}

	public int getLabelAlignY()
	{
		return labelAlignY;
	}

	public void setLabelAlignY(int aLabelAlignY)
	{
		labelAlignY = aLabelAlignY;
	}

	public void setLabelAlignY(String aLabelAlignY)
	{
		if (aLabelAlignY != null && !aLabelAlignY.equals(""))
		{
			Integer tInteger = new Integer(aLabelAlignY);
			int i = tInteger.intValue();
			labelAlignY = i;
		}
	}

	public int getLabelHorizontal()
	{
		return labelHorizontal;
	}

	public void setLabelHorizontal(int aLabelHorizontal)
	{
		labelHorizontal = aLabelHorizontal;
	}

	public void setLabelHorizontal(String aLabelHorizontal)
	{
		if (aLabelHorizontal != null && !aLabelHorizontal.equals(""))
		{
			Integer tInteger = new Integer(aLabelHorizontal);
			int i = tInteger.intValue();
			labelHorizontal = i;
		}
	}

	public int getLabelVertical()
	{
		return labelVertical;
	}

	public void setLabelVertical(int aLabelVertical)
	{
		labelVertical = aLabelVertical;
	}

	public void setLabelVertical(String aLabelVertical)
	{
		if (aLabelVertical != null && !aLabelVertical.equals(""))
		{
			Integer tInteger = new Integer(aLabelVertical);
			int i = tInteger.intValue();
			labelVertical = i;
		}
	}

	public String getLabelBackground()
	{
		return labelBackground;
	}

	public void setLabelBackground(String aLabelBackground)
	{
		labelBackground = aLabelBackground;
	}

	public String getDefaultValue()
	{
		return defaultValue;
	}

	public void setDefaultValue(String aDefaultValue)
	{
		defaultValue = aDefaultValue;
	}

	public String getDefaultSql()
	{
		return defaultSql;
	}

	public void setDefaultSql(String aDefaultSql)
	{
		defaultSql = aDefaultSql;
	}

	public String getCtrlProperty1()
	{
		return ctrlProperty1;
	}

	public void setCtrlProperty1(String aCtrlProperty1)
	{
		ctrlProperty1 = aCtrlProperty1;
	}

	public String getCtrlProperty2()
	{
		return ctrlProperty2;
	}

	public void setCtrlProperty2(String aCtrlProperty2)
	{
		ctrlProperty2 = aCtrlProperty2;
	}

	public String getNoti()
	{
		return noti;
	}

	public void setNoti(String aNoti)
	{
		noti = aNoti;
	}

	public void setSchema(LNPRiskScreenSchema aLNPRiskScreenSchema)
	{
		riskCode = aLNPRiskScreenSchema.getRiskCode();
		ctrlIndex = aLNPRiskScreenSchema.getCtrlIndex();
		ctrlType = aLNPRiskScreenSchema.getCtrlType();
		ctrlCode = aLNPRiskScreenSchema.getCtrlCode();
		ctrlName = aLNPRiskScreenSchema.getCtrlName();
		ctrlLevel = aLNPRiskScreenSchema.getCtrlLevel();
		ctrlProperty = aLNPRiskScreenSchema.getCtrlProperty();
		ctrlAlignX = aLNPRiskScreenSchema.getCtrlAlignX();
		ctrlAlignY = aLNPRiskScreenSchema.getCtrlAlignY();
		ctrlHorizontal = aLNPRiskScreenSchema.getCtrlHorizontal();
		ctrlVertical = aLNPRiskScreenSchema.getCtrlVertical();
		ctrlBackground = aLNPRiskScreenSchema.getCtrlBackground();
		labelAlignX = aLNPRiskScreenSchema.getLabelAlignX();
		labelAlignY = aLNPRiskScreenSchema.getLabelAlignY();
		labelHorizontal = aLNPRiskScreenSchema.getLabelHorizontal();
		labelVertical = aLNPRiskScreenSchema.getLabelVertical();
		labelBackground = aLNPRiskScreenSchema.getLabelBackground();
		defaultValue = aLNPRiskScreenSchema.getDefaultValue();
		defaultSql = aLNPRiskScreenSchema.getDefaultSql();
		ctrlProperty1 = aLNPRiskScreenSchema.getCtrlProperty1();
		ctrlProperty2 = aLNPRiskScreenSchema.getCtrlProperty2();
		noti = aLNPRiskScreenSchema.getNoti();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("RiskCode") == null)
				riskCode = null;
			else
				riskCode = rs.getString("RiskCode").trim();
			ctrlIndex = rs.getInt("CtrlIndex");
			if (rs.getString("CtrlType") == null)
				ctrlType = null;
			else
				ctrlType = rs.getString("CtrlType").trim();
			if (rs.getString("CtrlCode") == null)
				ctrlCode = null;
			else
				ctrlCode = rs.getString("CtrlCode").trim();
			if (rs.getString("CtrlName") == null)
				ctrlName = null;
			else
				ctrlName = rs.getString("CtrlName").trim();
			if (rs.getString("CtrlLevel") == null)
				ctrlLevel = null;
			else
				ctrlLevel = rs.getString("CtrlLevel").trim();
			if (rs.getString("CtrlProperty") == null)
				ctrlProperty = null;
			else
				ctrlProperty = rs.getString("CtrlProperty").trim();
			ctrlAlignX = rs.getInt("CtrlAlignX");
			ctrlAlignY = rs.getInt("CtrlAlignY");
			ctrlHorizontal = rs.getInt("CtrlHorizontal");
			ctrlVertical = rs.getInt("CtrlVertical");
			if (rs.getString("CtrlBackground") == null)
				ctrlBackground = null;
			else
				ctrlBackground = rs.getString("CtrlBackground").trim();
			labelAlignX = rs.getInt("LabelAlignX");
			labelAlignY = rs.getInt("LabelAlignY");
			labelHorizontal = rs.getInt("LabelHorizontal");
			labelVertical = rs.getInt("LabelVertical");
			if (rs.getString("LabelBackground") == null)
				labelBackground = null;
			else
				labelBackground = rs.getString("LabelBackground").trim();
			if (rs.getString("DefaultValue") == null)
				defaultValue = null;
			else
				defaultValue = rs.getString("DefaultValue").trim();
			if (rs.getString("DefaultSql") == null)
				defaultSql = null;
			else
				defaultSql = rs.getString("DefaultSql").trim();
			if (rs.getString("CtrlProperty1") == null)
				ctrlProperty1 = null;
			else
				ctrlProperty1 = rs.getString("CtrlProperty1").trim();
			if (rs.getString("CtrlProperty2") == null)
				ctrlProperty2 = null;
			else
				ctrlProperty2 = rs.getString("CtrlProperty2").trim();
			if (rs.getString("Noti") == null)
				noti = null;
			else
				noti = rs.getString("Noti").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("��ݿ��е�LNPRiskScreen���ֶθ����Schema�е��ֶθ���һ�£�����ִ��db.executeQuery��ѯʱû��ʹ��select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPRiskScreenSchema getSchema()
	{
		LNPRiskScreenSchema aLNPRiskScreenSchema = new LNPRiskScreenSchema();
		aLNPRiskScreenSchema.setSchema(this);
		return aLNPRiskScreenSchema;
	}

	public LNPRiskScreenDB getDB()
	{
		LNPRiskScreenDB aDBOper = new LNPRiskScreenDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(riskCode));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(ctrlIndex));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ctrlType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ctrlCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ctrlName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ctrlLevel));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ctrlProperty));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(ctrlAlignX));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(ctrlAlignY));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(ctrlHorizontal));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(ctrlVertical));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ctrlBackground));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(labelAlignX));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(labelAlignY));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(labelHorizontal));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(labelVertical));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(labelBackground));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(defaultValue));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(defaultSql));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ctrlProperty1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(ctrlProperty2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(noti));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			ctrlIndex = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 2, "|")))).intValue();
			ctrlType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			ctrlCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			ctrlName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			ctrlLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			ctrlProperty = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			ctrlAlignX = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).intValue();
			ctrlAlignY = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).intValue();
			ctrlHorizontal = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).intValue();
			ctrlVertical = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).intValue();
			ctrlBackground = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			labelAlignX = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|")))).intValue();
			labelAlignY = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|")))).intValue();
			labelHorizontal = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|")))).intValue();
			labelVertical = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|")))).intValue();
			labelBackground = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			defaultValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			defaultSql = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			ctrlProperty1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			ctrlProperty2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			noti = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenSchema";
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
		if (FCode.equalsIgnoreCase("ctrlIndex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlIndex));
		if (FCode.equalsIgnoreCase("ctrlType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlType));
		if (FCode.equalsIgnoreCase("ctrlCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlCode));
		if (FCode.equalsIgnoreCase("ctrlName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlName));
		if (FCode.equalsIgnoreCase("ctrlLevel"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlLevel));
		if (FCode.equalsIgnoreCase("ctrlProperty"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlProperty));
		if (FCode.equalsIgnoreCase("ctrlAlignX"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlAlignX));
		if (FCode.equalsIgnoreCase("ctrlAlignY"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlAlignY));
		if (FCode.equalsIgnoreCase("ctrlHorizontal"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlHorizontal));
		if (FCode.equalsIgnoreCase("ctrlVertical"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlVertical));
		if (FCode.equalsIgnoreCase("ctrlBackground"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlBackground));
		if (FCode.equalsIgnoreCase("labelAlignX"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(labelAlignX));
		if (FCode.equalsIgnoreCase("labelAlignY"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(labelAlignY));
		if (FCode.equalsIgnoreCase("labelHorizontal"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(labelHorizontal));
		if (FCode.equalsIgnoreCase("labelVertical"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(labelVertical));
		if (FCode.equalsIgnoreCase("labelBackground"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(labelBackground));
		if (FCode.equalsIgnoreCase("defaultValue"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(defaultValue));
		if (FCode.equalsIgnoreCase("defaultSql"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(defaultSql));
		if (FCode.equalsIgnoreCase("ctrlProperty1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlProperty1));
		if (FCode.equalsIgnoreCase("ctrlProperty2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ctrlProperty2));
		if (FCode.equalsIgnoreCase("noti"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(noti));
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
			strFieldValue = String.valueOf(ctrlIndex);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(ctrlType);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(ctrlCode);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(ctrlName);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(ctrlLevel);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(ctrlProperty);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(ctrlAlignX);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(ctrlAlignY);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(ctrlHorizontal);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(ctrlVertical);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(ctrlBackground);
			break;

		case 12: // '\f'
			strFieldValue = String.valueOf(labelAlignX);
			break;

		case 13: // '\r'
			strFieldValue = String.valueOf(labelAlignY);
			break;

		case 14: // '\016'
			strFieldValue = String.valueOf(labelHorizontal);
			break;

		case 15: // '\017'
			strFieldValue = String.valueOf(labelVertical);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(labelBackground);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(defaultValue);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(defaultSql);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(ctrlProperty1);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(ctrlProperty2);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(noti);
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
		if (FCode.equalsIgnoreCase("ctrlIndex") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			ctrlIndex = i;
		}
		if (FCode.equalsIgnoreCase("ctrlType"))
			if (FValue != null && !FValue.equals(""))
				ctrlType = FValue.trim();
			else
				ctrlType = null;
		if (FCode.equalsIgnoreCase("ctrlCode"))
			if (FValue != null && !FValue.equals(""))
				ctrlCode = FValue.trim();
			else
				ctrlCode = null;
		if (FCode.equalsIgnoreCase("ctrlName"))
			if (FValue != null && !FValue.equals(""))
				ctrlName = FValue.trim();
			else
				ctrlName = null;
		if (FCode.equalsIgnoreCase("ctrlLevel"))
			if (FValue != null && !FValue.equals(""))
				ctrlLevel = FValue.trim();
			else
				ctrlLevel = null;
		if (FCode.equalsIgnoreCase("ctrlProperty"))
			if (FValue != null && !FValue.equals(""))
				ctrlProperty = FValue.trim();
			else
				ctrlProperty = null;
		if (FCode.equalsIgnoreCase("ctrlAlignX") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			ctrlAlignX = i;
		}
		if (FCode.equalsIgnoreCase("ctrlAlignY") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			ctrlAlignY = i;
		}
		if (FCode.equalsIgnoreCase("ctrlHorizontal") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			ctrlHorizontal = i;
		}
		if (FCode.equalsIgnoreCase("ctrlVertical") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			ctrlVertical = i;
		}
		if (FCode.equalsIgnoreCase("ctrlBackground"))
			if (FValue != null && !FValue.equals(""))
				ctrlBackground = FValue.trim();
			else
				ctrlBackground = null;
		if (FCode.equalsIgnoreCase("labelAlignX") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			labelAlignX = i;
		}
		if (FCode.equalsIgnoreCase("labelAlignY") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			labelAlignY = i;
		}
		if (FCode.equalsIgnoreCase("labelHorizontal") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			labelHorizontal = i;
		}
		if (FCode.equalsIgnoreCase("labelVertical") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			labelVertical = i;
		}
		if (FCode.equalsIgnoreCase("labelBackground"))
			if (FValue != null && !FValue.equals(""))
				labelBackground = FValue.trim();
			else
				labelBackground = null;
		if (FCode.equalsIgnoreCase("defaultValue"))
			if (FValue != null && !FValue.equals(""))
				defaultValue = FValue.trim();
			else
				defaultValue = null;
		if (FCode.equalsIgnoreCase("defaultSql"))
			if (FValue != null && !FValue.equals(""))
				defaultSql = FValue.trim();
			else
				defaultSql = null;
		if (FCode.equalsIgnoreCase("ctrlProperty1"))
			if (FValue != null && !FValue.equals(""))
				ctrlProperty1 = FValue.trim();
			else
				ctrlProperty1 = null;
		if (FCode.equalsIgnoreCase("ctrlProperty2"))
			if (FValue != null && !FValue.equals(""))
				ctrlProperty2 = FValue.trim();
			else
				ctrlProperty2 = null;
		if (FCode.equalsIgnoreCase("noti"))
			if (FValue != null && !FValue.equals(""))
				noti = FValue.trim();
			else
				noti = null;
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
		LNPRiskScreenSchema other = (LNPRiskScreenSchema)otherObject;
		if (riskCode == null && other.getRiskCode() != null)
			return false;
		if (riskCode != null && !riskCode.equals(other.getRiskCode()))
			return false;
		if (ctrlIndex != other.getCtrlIndex())
			return false;
		if (ctrlType == null && other.getCtrlType() != null)
			return false;
		if (ctrlType != null && !ctrlType.equals(other.getCtrlType()))
			return false;
		if (ctrlCode == null && other.getCtrlCode() != null)
			return false;
		if (ctrlCode != null && !ctrlCode.equals(other.getCtrlCode()))
			return false;
		if (ctrlName == null && other.getCtrlName() != null)
			return false;
		if (ctrlName != null && !ctrlName.equals(other.getCtrlName()))
			return false;
		if (ctrlLevel == null && other.getCtrlLevel() != null)
			return false;
		if (ctrlLevel != null && !ctrlLevel.equals(other.getCtrlLevel()))
			return false;
		if (ctrlProperty == null && other.getCtrlProperty() != null)
			return false;
		if (ctrlProperty != null && !ctrlProperty.equals(other.getCtrlProperty()))
			return false;
		if (ctrlAlignX != other.getCtrlAlignX())
			return false;
		if (ctrlAlignY != other.getCtrlAlignY())
			return false;
		if (ctrlHorizontal != other.getCtrlHorizontal())
			return false;
		if (ctrlVertical != other.getCtrlVertical())
			return false;
		if (ctrlBackground == null && other.getCtrlBackground() != null)
			return false;
		if (ctrlBackground != null && !ctrlBackground.equals(other.getCtrlBackground()))
			return false;
		if (labelAlignX != other.getLabelAlignX())
			return false;
		if (labelAlignY != other.getLabelAlignY())
			return false;
		if (labelHorizontal != other.getLabelHorizontal())
			return false;
		if (labelVertical != other.getLabelVertical())
			return false;
		if (labelBackground == null && other.getLabelBackground() != null)
			return false;
		if (labelBackground != null && !labelBackground.equals(other.getLabelBackground()))
			return false;
		if (defaultValue == null && other.getDefaultValue() != null)
			return false;
		if (defaultValue != null && !defaultValue.equals(other.getDefaultValue()))
			return false;
		if (defaultSql == null && other.getDefaultSql() != null)
			return false;
		if (defaultSql != null && !defaultSql.equals(other.getDefaultSql()))
			return false;
		if (ctrlProperty1 == null && other.getCtrlProperty1() != null)
			return false;
		if (ctrlProperty1 != null && !ctrlProperty1.equals(other.getCtrlProperty1()))
			return false;
		if (ctrlProperty2 == null && other.getCtrlProperty2() != null)
			return false;
		if (ctrlProperty2 != null && !ctrlProperty2.equals(other.getCtrlProperty2()))
			return false;
		if (noti == null && other.getNoti() != null)
			return false;
		return noti == null || noti.equals(other.getNoti());
	}

	public int getFieldCount()
	{
		return 22;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("riskCode"))
			return 0;
		if (strFieldName.equals("ctrlIndex"))
			return 1;
		if (strFieldName.equals("ctrlType"))
			return 2;
		if (strFieldName.equals("ctrlCode"))
			return 3;
		if (strFieldName.equals("ctrlName"))
			return 4;
		if (strFieldName.equals("ctrlLevel"))
			return 5;
		if (strFieldName.equals("ctrlProperty"))
			return 6;
		if (strFieldName.equals("ctrlAlignX"))
			return 7;
		if (strFieldName.equals("ctrlAlignY"))
			return 8;
		if (strFieldName.equals("ctrlHorizontal"))
			return 9;
		if (strFieldName.equals("ctrlVertical"))
			return 10;
		if (strFieldName.equals("ctrlBackground"))
			return 11;
		if (strFieldName.equals("labelAlignX"))
			return 12;
		if (strFieldName.equals("labelAlignY"))
			return 13;
		if (strFieldName.equals("labelHorizontal"))
			return 14;
		if (strFieldName.equals("labelVertical"))
			return 15;
		if (strFieldName.equals("labelBackground"))
			return 16;
		if (strFieldName.equals("defaultValue"))
			return 17;
		if (strFieldName.equals("defaultSql"))
			return 18;
		if (strFieldName.equals("ctrlProperty1"))
			return 19;
		if (strFieldName.equals("ctrlProperty2"))
			return 20;
		return !strFieldName.equals("noti") ? -1 : 21;
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
			strFieldName = "ctrlIndex";
			break;

		case 2: // '\002'
			strFieldName = "ctrlType";
			break;

		case 3: // '\003'
			strFieldName = "ctrlCode";
			break;

		case 4: // '\004'
			strFieldName = "ctrlName";
			break;

		case 5: // '\005'
			strFieldName = "ctrlLevel";
			break;

		case 6: // '\006'
			strFieldName = "ctrlProperty";
			break;

		case 7: // '\007'
			strFieldName = "ctrlAlignX";
			break;

		case 8: // '\b'
			strFieldName = "ctrlAlignY";
			break;

		case 9: // '\t'
			strFieldName = "ctrlHorizontal";
			break;

		case 10: // '\n'
			strFieldName = "ctrlVertical";
			break;

		case 11: // '\013'
			strFieldName = "ctrlBackground";
			break;

		case 12: // '\f'
			strFieldName = "labelAlignX";
			break;

		case 13: // '\r'
			strFieldName = "labelAlignY";
			break;

		case 14: // '\016'
			strFieldName = "labelHorizontal";
			break;

		case 15: // '\017'
			strFieldName = "labelVertical";
			break;

		case 16: // '\020'
			strFieldName = "labelBackground";
			break;

		case 17: // '\021'
			strFieldName = "defaultValue";
			break;

		case 18: // '\022'
			strFieldName = "defaultSql";
			break;

		case 19: // '\023'
			strFieldName = "ctrlProperty1";
			break;

		case 20: // '\024'
			strFieldName = "ctrlProperty2";
			break;

		case 21: // '\025'
			strFieldName = "noti";
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
		if (strFieldName.equals("ctrlIndex"))
			return 3;
		if (strFieldName.equals("ctrlType"))
			return 0;
		if (strFieldName.equals("ctrlCode"))
			return 0;
		if (strFieldName.equals("ctrlName"))
			return 0;
		if (strFieldName.equals("ctrlLevel"))
			return 0;
		if (strFieldName.equals("ctrlProperty"))
			return 0;
		if (strFieldName.equals("ctrlAlignX"))
			return 3;
		if (strFieldName.equals("ctrlAlignY"))
			return 3;
		if (strFieldName.equals("ctrlHorizontal"))
			return 3;
		if (strFieldName.equals("ctrlVertical"))
			return 3;
		if (strFieldName.equals("ctrlBackground"))
			return 0;
		if (strFieldName.equals("labelAlignX"))
			return 3;
		if (strFieldName.equals("labelAlignY"))
			return 3;
		if (strFieldName.equals("labelHorizontal"))
			return 3;
		if (strFieldName.equals("labelVertical"))
			return 3;
		if (strFieldName.equals("labelBackground"))
			return 0;
		if (strFieldName.equals("defaultValue"))
			return 0;
		if (strFieldName.equals("defaultSql"))
			return 0;
		if (strFieldName.equals("ctrlProperty1"))
			return 0;
		if (strFieldName.equals("ctrlProperty2"))
			return 0;
		return !strFieldName.equals("noti") ? -1 : 0;
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
			nFieldType = 3;
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
			nFieldType = 3;
			break;

		case 8: // '\b'
			nFieldType = 3;
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
			nFieldType = 3;
			break;

		case 13: // '\r'
			nFieldType = 3;
			break;

		case 14: // '\016'
			nFieldType = 3;
			break;

		case 15: // '\017'
			nFieldType = 3;
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
			nFieldType = 0;
			break;

		case 21: // '\025'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
