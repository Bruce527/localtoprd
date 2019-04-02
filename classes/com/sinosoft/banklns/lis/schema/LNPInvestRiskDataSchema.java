// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInvestRiskDataSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LNPInvestRiskDataDB;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LNPInvestRiskDataSchema
	implements Schema, Cloneable
{

	private String dataid;
	private String signno;
	private String type;
	private int serialno;
	private int age;
	private int degree;
	private double value;
	private int protagonist;
	private int exponent;
	private int banlance;
	private int solidity;
	private int prevent;
	private String remark1;
	private String remark2;
	private String remark3;
	private String remark4;
	public static final int FIELDNUM = 16;
	private static String PK[];
	public CErrors mErrors;

	public LNPInvestRiskDataSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "Dataid";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LNPInvestRiskDataSchema cloned = (LNPInvestRiskDataSchema)super.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getDataid()
	{
		return dataid;
	}

	public void setDataid(String aDataid)
	{
		dataid = aDataid;
	}

	public String getSignno()
	{
		return signno;
	}

	public void setSignno(String aSignno)
	{
		signno = aSignno;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String aType)
	{
		type = aType;
	}

	public int getSerialno()
	{
		return serialno;
	}

	public void setSerialno(int aSerialno)
	{
		serialno = aSerialno;
	}

	public void setSerialno(String aSerialno)
	{
		if (aSerialno != null && !aSerialno.equals(""))
		{
			Integer tInteger = new Integer(aSerialno);
			int i = tInteger.intValue();
			serialno = i;
		}
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int aAge)
	{
		age = aAge;
	}

	public void setAge(String aAge)
	{
		if (aAge != null && !aAge.equals(""))
		{
			Integer tInteger = new Integer(aAge);
			int i = tInteger.intValue();
			age = i;
		}
	}

	public int getDegree()
	{
		return degree;
	}

	public void setDegree(int aDegree)
	{
		degree = aDegree;
	}

	public void setDegree(String aDegree)
	{
		if (aDegree != null && !aDegree.equals(""))
		{
			Integer tInteger = new Integer(aDegree);
			int i = tInteger.intValue();
			degree = i;
		}
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double aValue)
	{
		value = aValue;
	}

	public void setValue(String aValue)
	{
		if (aValue != null && !aValue.equals(""))
		{
			Double tDouble = new Double(aValue);
			double d = tDouble.doubleValue();
			value = d;
		}
	}

	public int getProtagonist()
	{
		return protagonist;
	}

	public void setProtagonist(int aProtagonist)
	{
		protagonist = aProtagonist;
	}

	public void setProtagonist(String aProtagonist)
	{
		if (aProtagonist != null && !aProtagonist.equals(""))
		{
			Integer tInteger = new Integer(aProtagonist);
			int i = tInteger.intValue();
			protagonist = i;
		}
	}

	public int getExponent()
	{
		return exponent;
	}

	public void setExponent(int aExponent)
	{
		exponent = aExponent;
	}

	public void setExponent(String aExponent)
	{
		if (aExponent != null && !aExponent.equals(""))
		{
			Integer tInteger = new Integer(aExponent);
			int i = tInteger.intValue();
			exponent = i;
		}
	}

	public int getBanlance()
	{
		return banlance;
	}

	public void setBanlance(int aBanlance)
	{
		banlance = aBanlance;
	}

	public void setBanlance(String aBanlance)
	{
		if (aBanlance != null && !aBanlance.equals(""))
		{
			Integer tInteger = new Integer(aBanlance);
			int i = tInteger.intValue();
			banlance = i;
		}
	}

	public int getSolidity()
	{
		return solidity;
	}

	public void setSolidity(int aSolidity)
	{
		solidity = aSolidity;
	}

	public void setSolidity(String aSolidity)
	{
		if (aSolidity != null && !aSolidity.equals(""))
		{
			Integer tInteger = new Integer(aSolidity);
			int i = tInteger.intValue();
			solidity = i;
		}
	}

	public int getPrevent()
	{
		return prevent;
	}

	public void setPrevent(int aPrevent)
	{
		prevent = aPrevent;
	}

	public void setPrevent(String aPrevent)
	{
		if (aPrevent != null && !aPrevent.equals(""))
		{
			Integer tInteger = new Integer(aPrevent);
			int i = tInteger.intValue();
			prevent = i;
		}
	}

	public String getRemark1()
	{
		return remark1;
	}

	public void setRemark1(String aRemark1)
	{
		remark1 = aRemark1;
	}

	public String getRemark2()
	{
		return remark2;
	}

	public void setRemark2(String aRemark2)
	{
		remark2 = aRemark2;
	}

	public String getRemark3()
	{
		return remark3;
	}

	public void setRemark3(String aRemark3)
	{
		remark3 = aRemark3;
	}

	public String getRemark4()
	{
		return remark4;
	}

	public void setRemark4(String aRemark4)
	{
		remark4 = aRemark4;
	}

	public void setSchema(LNPInvestRiskDataSchema aLNPInvestRiskDataSchema)
	{
		dataid = aLNPInvestRiskDataSchema.getDataid();
		signno = aLNPInvestRiskDataSchema.getSignno();
		type = aLNPInvestRiskDataSchema.getType();
		serialno = aLNPInvestRiskDataSchema.getSerialno();
		age = aLNPInvestRiskDataSchema.getAge();
		degree = aLNPInvestRiskDataSchema.getDegree();
		value = aLNPInvestRiskDataSchema.getValue();
		protagonist = aLNPInvestRiskDataSchema.getProtagonist();
		exponent = aLNPInvestRiskDataSchema.getExponent();
		banlance = aLNPInvestRiskDataSchema.getBanlance();
		solidity = aLNPInvestRiskDataSchema.getSolidity();
		prevent = aLNPInvestRiskDataSchema.getPrevent();
		remark1 = aLNPInvestRiskDataSchema.getRemark1();
		remark2 = aLNPInvestRiskDataSchema.getRemark2();
		remark3 = aLNPInvestRiskDataSchema.getRemark3();
		remark4 = aLNPInvestRiskDataSchema.getRemark4();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("Dataid") == null)
				dataid = null;
			else
				dataid = rs.getString("Dataid").trim();
			if (rs.getString("Signno") == null)
				signno = null;
			else
				signno = rs.getString("Signno").trim();
			if (rs.getString("Type") == null)
				type = null;
			else
				type = rs.getString("Type").trim();
			serialno = rs.getInt("Serialno");
			age = rs.getInt("Age");
			degree = rs.getInt("Degree");
			value = rs.getDouble("Value");
			protagonist = rs.getInt("Protagonist");
			exponent = rs.getInt("exponent");
			banlance = rs.getInt("banlance");
			solidity = rs.getInt("solidity");
			prevent = rs.getInt("prevent");
			if (rs.getString("remark1") == null)
				remark1 = null;
			else
				remark1 = rs.getString("remark1").trim();
			if (rs.getString("remark2") == null)
				remark2 = null;
			else
				remark2 = rs.getString("remark2").trim();
			if (rs.getString("remark3") == null)
				remark3 = null;
			else
				remark3 = rs.getString("remark3").trim();
			if (rs.getString("remark4") == null)
				remark4 = null;
			else
				remark4 = rs.getString("remark4").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("?????§Ö?LNPInvestRiskData????¦È????Schema?§Ö???¦È?????\243????????db.executeQuery????\373?????select * from tables");
			CError tError = new CError();
			tError.moduleName = "LNPInvestRiskDataSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LNPInvestRiskDataSchema getSchema()
	{
		LNPInvestRiskDataSchema aLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
		aLNPInvestRiskDataSchema.setSchema(this);
		return aLNPInvestRiskDataSchema;
	}

	public LNPInvestRiskDataDB getDB()
	{
		LNPInvestRiskDataDB aDBOper = new LNPInvestRiskDataDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(dataid));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(signno));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(type));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(serialno));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(age));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(degree));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(value));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(protagonist));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(exponent));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(banlance));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(solidity));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(prevent));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remark1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remark2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remark3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(remark4));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			dataid = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			signno = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			serialno = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 4, "|")))).intValue();
			age = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|")))).intValue();
			degree = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|")))).intValue();
			value = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|")))).doubleValue();
			protagonist = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).intValue();
			exponent = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).intValue();
			banlance = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).intValue();
			solidity = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).intValue();
			prevent = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|")))).intValue();
			remark1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			remark2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			remark3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			remark4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInvestRiskDataSchema";
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
		if (FCode.equalsIgnoreCase("dataid"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dataid));
		if (FCode.equalsIgnoreCase("signno"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(signno));
		if (FCode.equalsIgnoreCase("type"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(type));
		if (FCode.equalsIgnoreCase("serialno"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(serialno));
		if (FCode.equalsIgnoreCase("age"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(age));
		if (FCode.equalsIgnoreCase("degree"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(degree));
		if (FCode.equalsIgnoreCase("value"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(value));
		if (FCode.equalsIgnoreCase("protagonist"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(protagonist));
		if (FCode.equalsIgnoreCase("exponent"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(exponent));
		if (FCode.equalsIgnoreCase("banlance"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(banlance));
		if (FCode.equalsIgnoreCase("solidity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(solidity));
		if (FCode.equalsIgnoreCase("prevent"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(prevent));
		if (FCode.equalsIgnoreCase("remark1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark1));
		if (FCode.equalsIgnoreCase("remark2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark2));
		if (FCode.equalsIgnoreCase("remark3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark3));
		if (FCode.equalsIgnoreCase("remark4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(remark4));
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
			strFieldValue = StrTool.GBKToUnicode(dataid);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(signno);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(type);
			break;

		case 3: // '\003'
			strFieldValue = String.valueOf(serialno);
			break;

		case 4: // '\004'
			strFieldValue = String.valueOf(age);
			break;

		case 5: // '\005'
			strFieldValue = String.valueOf(degree);
			break;

		case 6: // '\006'
			strFieldValue = String.valueOf(value);
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(protagonist);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(exponent);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(banlance);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(solidity);
			break;

		case 11: // '\013'
			strFieldValue = String.valueOf(prevent);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(remark1);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(remark2);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(remark3);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(remark4);
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
		if (FCode.equalsIgnoreCase("dataid"))
			if (FValue != null && !FValue.equals(""))
				dataid = FValue.trim();
			else
				dataid = null;
		if (FCode.equalsIgnoreCase("signno"))
			if (FValue != null && !FValue.equals(""))
				signno = FValue.trim();
			else
				signno = null;
		if (FCode.equalsIgnoreCase("type"))
			if (FValue != null && !FValue.equals(""))
				type = FValue.trim();
			else
				type = null;
		if (FCode.equalsIgnoreCase("serialno") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			serialno = i;
		}
		if (FCode.equalsIgnoreCase("age") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			age = i;
		}
		if (FCode.equalsIgnoreCase("degree") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			degree = i;
		}
		if (FCode.equalsIgnoreCase("value") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			value = d;
		}
		if (FCode.equalsIgnoreCase("protagonist") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			protagonist = i;
		}
		if (FCode.equalsIgnoreCase("exponent") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			exponent = i;
		}
		if (FCode.equalsIgnoreCase("banlance") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			banlance = i;
		}
		if (FCode.equalsIgnoreCase("solidity") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			solidity = i;
		}
		if (FCode.equalsIgnoreCase("prevent") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			prevent = i;
		}
		if (FCode.equalsIgnoreCase("remark1"))
			if (FValue != null && !FValue.equals(""))
				remark1 = FValue.trim();
			else
				remark1 = null;
		if (FCode.equalsIgnoreCase("remark2"))
			if (FValue != null && !FValue.equals(""))
				remark2 = FValue.trim();
			else
				remark2 = null;
		if (FCode.equalsIgnoreCase("remark3"))
			if (FValue != null && !FValue.equals(""))
				remark3 = FValue.trim();
			else
				remark3 = null;
		if (FCode.equalsIgnoreCase("remark4"))
			if (FValue != null && !FValue.equals(""))
				remark4 = FValue.trim();
			else
				remark4 = null;
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
		LNPInvestRiskDataSchema other = (LNPInvestRiskDataSchema)otherObject;
		if (dataid == null && other.getDataid() != null)
			return false;
		if (dataid != null && !dataid.equals(other.getDataid()))
			return false;
		if (signno == null && other.getSignno() != null)
			return false;
		if (signno != null && !signno.equals(other.getSignno()))
			return false;
		if (type == null && other.getType() != null)
			return false;
		if (type != null && !type.equals(other.getType()))
			return false;
		if (serialno != other.getSerialno())
			return false;
		if (age != other.getAge())
			return false;
		if (degree != other.getDegree())
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.getValue()))
			return false;
		if (protagonist != other.getProtagonist())
			return false;
		if (exponent != other.getExponent())
			return false;
		if (banlance != other.getBanlance())
			return false;
		if (solidity != other.getSolidity())
			return false;
		if (prevent != other.getPrevent())
			return false;
		if (remark1 == null && other.getRemark1() != null)
			return false;
		if (remark1 != null && !remark1.equals(other.getRemark1()))
			return false;
		if (remark2 == null && other.getRemark2() != null)
			return false;
		if (remark2 != null && !remark2.equals(other.getRemark2()))
			return false;
		if (remark3 == null && other.getRemark3() != null)
			return false;
		if (remark3 != null && !remark3.equals(other.getRemark3()))
			return false;
		if (remark4 == null && other.getRemark4() != null)
			return false;
		return remark4 == null || remark4.equals(other.getRemark4());
	}

	public int getFieldCount()
	{
		return 16;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("dataid"))
			return 0;
		if (strFieldName.equals("signno"))
			return 1;
		if (strFieldName.equals("type"))
			return 2;
		if (strFieldName.equals("serialno"))
			return 3;
		if (strFieldName.equals("age"))
			return 4;
		if (strFieldName.equals("degree"))
			return 5;
		if (strFieldName.equals("value"))
			return 6;
		if (strFieldName.equals("protagonist"))
			return 7;
		if (strFieldName.equals("exponent"))
			return 8;
		if (strFieldName.equals("banlance"))
			return 9;
		if (strFieldName.equals("solidity"))
			return 10;
		if (strFieldName.equals("prevent"))
			return 11;
		if (strFieldName.equals("remark1"))
			return 12;
		if (strFieldName.equals("remark2"))
			return 13;
		if (strFieldName.equals("remark3"))
			return 14;
		return !strFieldName.equals("remark4") ? -1 : 15;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "dataid";
			break;

		case 1: // '\001'
			strFieldName = "signno";
			break;

		case 2: // '\002'
			strFieldName = "type";
			break;

		case 3: // '\003'
			strFieldName = "serialno";
			break;

		case 4: // '\004'
			strFieldName = "age";
			break;

		case 5: // '\005'
			strFieldName = "degree";
			break;

		case 6: // '\006'
			strFieldName = "value";
			break;

		case 7: // '\007'
			strFieldName = "protagonist";
			break;

		case 8: // '\b'
			strFieldName = "exponent";
			break;

		case 9: // '\t'
			strFieldName = "banlance";
			break;

		case 10: // '\n'
			strFieldName = "solidity";
			break;

		case 11: // '\013'
			strFieldName = "prevent";
			break;

		case 12: // '\f'
			strFieldName = "remark1";
			break;

		case 13: // '\r'
			strFieldName = "remark2";
			break;

		case 14: // '\016'
			strFieldName = "remark3";
			break;

		case 15: // '\017'
			strFieldName = "remark4";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("dataid"))
			return 0;
		if (strFieldName.equals("signno"))
			return 0;
		if (strFieldName.equals("type"))
			return 0;
		if (strFieldName.equals("serialno"))
			return 3;
		if (strFieldName.equals("age"))
			return 3;
		if (strFieldName.equals("degree"))
			return 3;
		if (strFieldName.equals("value"))
			return 4;
		if (strFieldName.equals("protagonist"))
			return 3;
		if (strFieldName.equals("exponent"))
			return 3;
		if (strFieldName.equals("banlance"))
			return 3;
		if (strFieldName.equals("solidity"))
			return 3;
		if (strFieldName.equals("prevent"))
			return 3;
		if (strFieldName.equals("remark1"))
			return 0;
		if (strFieldName.equals("remark2"))
			return 0;
		if (strFieldName.equals("remark3"))
			return 0;
		return !strFieldName.equals("remark4") ? -1 : 0;
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
			nFieldType = 3;
			break;

		case 4: // '\004'
			nFieldType = 3;
			break;

		case 5: // '\005'
			nFieldType = 3;
			break;

		case 6: // '\006'
			nFieldType = 4;
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
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
