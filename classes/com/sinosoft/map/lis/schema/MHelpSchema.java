// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MHelpSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MHelpDB;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MHelpSchema
	implements Schema, Cloneable
{

	private String iD;
	private String manageCom;
	private String application;
	private String person;
	private String email;
	private String tel;
	private String vF1;
	private String vF2;
	private String vF3;
	public static final int FIELDNUM = 9;
	private static String PK[];
	public CErrors mErrors;

	public MHelpSchema()
	{
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "ID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MHelpSchema cloned = (MHelpSchema)super.clone();
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

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getApplication()
	{
		return application;
	}

	public void setApplication(String aApplication)
	{
		application = aApplication;
	}

	public String getPerson()
	{
		return person;
	}

	public void setPerson(String aPerson)
	{
		person = aPerson;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String aEmail)
	{
		email = aEmail;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String aTel)
	{
		tel = aTel;
	}

	public String getVF1()
	{
		return vF1;
	}

	public void setVF1(String aVF1)
	{
		vF1 = aVF1;
	}

	public String getVF2()
	{
		return vF2;
	}

	public void setVF2(String aVF2)
	{
		vF2 = aVF2;
	}

	public String getVF3()
	{
		return vF3;
	}

	public void setVF3(String aVF3)
	{
		vF3 = aVF3;
	}

	public void setSchema(MHelpSchema aMHelpSchema)
	{
		iD = aMHelpSchema.getID();
		manageCom = aMHelpSchema.getManageCom();
		application = aMHelpSchema.getApplication();
		person = aMHelpSchema.getPerson();
		email = aMHelpSchema.getEmail();
		tel = aMHelpSchema.getTel();
		vF1 = aMHelpSchema.getVF1();
		vF2 = aMHelpSchema.getVF2();
		vF3 = aMHelpSchema.getVF3();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("ID") == null)
				iD = null;
			else
				iD = rs.getString("ID").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("Application") == null)
				application = null;
			else
				application = rs.getString("Application").trim();
			if (rs.getString("Person") == null)
				person = null;
			else
				person = rs.getString("Person").trim();
			if (rs.getString("Email") == null)
				email = null;
			else
				email = rs.getString("Email").trim();
			if (rs.getString("Tel") == null)
				tel = null;
			else
				tel = rs.getString("Tel").trim();
			if (rs.getString("VF1") == null)
				vF1 = null;
			else
				vF1 = rs.getString("VF1").trim();
			if (rs.getString("VF2") == null)
				vF2 = null;
			else
				vF2 = rs.getString("VF2").trim();
			if (rs.getString("VF3") == null)
				vF3 = null;
			else
				vF3 = rs.getString("VF3").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MHelp表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MHelpSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MHelpSchema getSchema()
	{
		MHelpSchema aMHelpSchema = new MHelpSchema();
		aMHelpSchema.setSchema(this);
		return aMHelpSchema;
	}

	public MHelpDB getDB()
	{
		MHelpDB aDBOper = new MHelpDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(iD));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(application));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(person));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(email));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(tel));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vF1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vF2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vF3));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			application = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			person = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			email = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			tel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			vF1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			vF2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			vF3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MHelpSchema";
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
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("application"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(application));
		if (FCode.equalsIgnoreCase("person"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(person));
		if (FCode.equalsIgnoreCase("email"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(email));
		if (FCode.equalsIgnoreCase("tel"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(tel));
		if (FCode.equalsIgnoreCase("vF1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vF1));
		if (FCode.equalsIgnoreCase("vF2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vF2));
		if (FCode.equalsIgnoreCase("vF3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vF3));
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
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(application);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(person);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(email);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(tel);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(vF1);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(vF2);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(vF3);
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
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("application"))
			if (FValue != null && !FValue.equals(""))
				application = FValue.trim();
			else
				application = null;
		if (FCode.equalsIgnoreCase("person"))
			if (FValue != null && !FValue.equals(""))
				person = FValue.trim();
			else
				person = null;
		if (FCode.equalsIgnoreCase("email"))
			if (FValue != null && !FValue.equals(""))
				email = FValue.trim();
			else
				email = null;
		if (FCode.equalsIgnoreCase("tel"))
			if (FValue != null && !FValue.equals(""))
				tel = FValue.trim();
			else
				tel = null;
		if (FCode.equalsIgnoreCase("vF1"))
			if (FValue != null && !FValue.equals(""))
				vF1 = FValue.trim();
			else
				vF1 = null;
		if (FCode.equalsIgnoreCase("vF2"))
			if (FValue != null && !FValue.equals(""))
				vF2 = FValue.trim();
			else
				vF2 = null;
		if (FCode.equalsIgnoreCase("vF3"))
			if (FValue != null && !FValue.equals(""))
				vF3 = FValue.trim();
			else
				vF3 = null;
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
		MHelpSchema other = (MHelpSchema)otherObject;
		if (iD == null && other.getID() != null)
			return false;
		if (iD != null && !iD.equals(other.getID()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (application == null && other.getApplication() != null)
			return false;
		if (application != null && !application.equals(other.getApplication()))
			return false;
		if (person == null && other.getPerson() != null)
			return false;
		if (person != null && !person.equals(other.getPerson()))
			return false;
		if (email == null && other.getEmail() != null)
			return false;
		if (email != null && !email.equals(other.getEmail()))
			return false;
		if (tel == null && other.getTel() != null)
			return false;
		if (tel != null && !tel.equals(other.getTel()))
			return false;
		if (vF1 == null && other.getVF1() != null)
			return false;
		if (vF1 != null && !vF1.equals(other.getVF1()))
			return false;
		if (vF2 == null && other.getVF2() != null)
			return false;
		if (vF2 != null && !vF2.equals(other.getVF2()))
			return false;
		if (vF3 == null && other.getVF3() != null)
			return false;
		return vF3 == null || vF3.equals(other.getVF3());
	}

	public int getFieldCount()
	{
		return 9;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("iD"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 1;
		if (strFieldName.equals("application"))
			return 2;
		if (strFieldName.equals("person"))
			return 3;
		if (strFieldName.equals("email"))
			return 4;
		if (strFieldName.equals("tel"))
			return 5;
		if (strFieldName.equals("vF1"))
			return 6;
		if (strFieldName.equals("vF2"))
			return 7;
		return !strFieldName.equals("vF3") ? -1 : 8;
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
			strFieldName = "manageCom";
			break;

		case 2: // '\002'
			strFieldName = "application";
			break;

		case 3: // '\003'
			strFieldName = "person";
			break;

		case 4: // '\004'
			strFieldName = "email";
			break;

		case 5: // '\005'
			strFieldName = "tel";
			break;

		case 6: // '\006'
			strFieldName = "vF1";
			break;

		case 7: // '\007'
			strFieldName = "vF2";
			break;

		case 8: // '\b'
			strFieldName = "vF3";
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
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("application"))
			return 0;
		if (strFieldName.equals("person"))
			return 0;
		if (strFieldName.equals("email"))
			return 0;
		if (strFieldName.equals("tel"))
			return 0;
		if (strFieldName.equals("vF1"))
			return 0;
		if (strFieldName.equals("vF2"))
			return 0;
		return !strFieldName.equals("vF3") ? -1 : 0;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
