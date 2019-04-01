// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLibrarySchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MLibraryDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MLibrarySchema
	implements Schema, Cloneable
{

	private String fileID;
	private String name;
	private String displayName;
	private String fileDescription;
	private String manageCom;
	private String branchType;
	private String nodeID;
	private String fileType;
	private String filePath;
	private String documentType;
	private Date startDisplayDate;
	private Date endDisplayDate;
	private String minDisplayGrade;
	private String startDisplayTime;
	private String endDisplayTime;
	private String checkState;
	private String checkOperator;
	private String checkReason;
	private Date checkDate;
	private String checkTime;
	private String vF01;
	private String nF01;
	private int iF01;
	private double dF02;
	private Date date01;
	private String modifyOperator;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String state;
	public static final int FIELDNUM = 32;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MLibrarySchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "FileID";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MLibrarySchema cloned = (MLibrarySchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getFileID()
	{
		return fileID;
	}

	public void setFileID(String aFileID)
	{
		fileID = aFileID;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String aName)
	{
		name = aName;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String aDisplayName)
	{
		displayName = aDisplayName;
	}

	public String getFileDescription()
	{
		return fileDescription;
	}

	public void setFileDescription(String aFileDescription)
	{
		fileDescription = aFileDescription;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getBranchType()
	{
		return branchType;
	}

	public void setBranchType(String aBranchType)
	{
		branchType = aBranchType;
	}

	public String getNodeID()
	{
		return nodeID;
	}

	public void setNodeID(String aNodeID)
	{
		nodeID = aNodeID;
	}

	public String getFileType()
	{
		return fileType;
	}

	public void setFileType(String aFileType)
	{
		fileType = aFileType;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String aFilePath)
	{
		filePath = aFilePath;
	}

	public String getDocumentType()
	{
		return documentType;
	}

	public void setDocumentType(String aDocumentType)
	{
		documentType = aDocumentType;
	}

	public String getStartDisplayDate()
	{
		if (startDisplayDate != null)
			return fDate.getString(startDisplayDate);
		else
			return null;
	}

	public void setStartDisplayDate(Date aStartDisplayDate)
	{
		startDisplayDate = aStartDisplayDate;
	}

	public void setStartDisplayDate(String aStartDisplayDate)
	{
		if (aStartDisplayDate != null && !aStartDisplayDate.equals(""))
			startDisplayDate = fDate.getDate(aStartDisplayDate);
		else
			startDisplayDate = null;
	}

	public String getEndDisplayDate()
	{
		if (endDisplayDate != null)
			return fDate.getString(endDisplayDate);
		else
			return null;
	}

	public void setEndDisplayDate(Date aEndDisplayDate)
	{
		endDisplayDate = aEndDisplayDate;
	}

	public void setEndDisplayDate(String aEndDisplayDate)
	{
		if (aEndDisplayDate != null && !aEndDisplayDate.equals(""))
			endDisplayDate = fDate.getDate(aEndDisplayDate);
		else
			endDisplayDate = null;
	}

	public String getMinDisplayGrade()
	{
		return minDisplayGrade;
	}

	public void setMinDisplayGrade(String aMinDisplayGrade)
	{
		minDisplayGrade = aMinDisplayGrade;
	}

	public String getStartDisplayTime()
	{
		return startDisplayTime;
	}

	public void setStartDisplayTime(String aStartDisplayTime)
	{
		startDisplayTime = aStartDisplayTime;
	}

	public String getEndDisplayTime()
	{
		return endDisplayTime;
	}

	public void setEndDisplayTime(String aEndDisplayTime)
	{
		endDisplayTime = aEndDisplayTime;
	}

	public String getCheckState()
	{
		return checkState;
	}

	public void setCheckState(String aCheckState)
	{
		checkState = aCheckState;
	}

	public String getCheckOperator()
	{
		return checkOperator;
	}

	public void setCheckOperator(String aCheckOperator)
	{
		checkOperator = aCheckOperator;
	}

	public String getCheckReason()
	{
		return checkReason;
	}

	public void setCheckReason(String aCheckReason)
	{
		checkReason = aCheckReason;
	}

	public String getCheckDate()
	{
		if (checkDate != null)
			return fDate.getString(checkDate);
		else
			return null;
	}

	public void setCheckDate(Date aCheckDate)
	{
		checkDate = aCheckDate;
	}

	public void setCheckDate(String aCheckDate)
	{
		if (aCheckDate != null && !aCheckDate.equals(""))
			checkDate = fDate.getDate(aCheckDate);
		else
			checkDate = null;
	}

	public String getCheckTime()
	{
		return checkTime;
	}

	public void setCheckTime(String aCheckTime)
	{
		checkTime = aCheckTime;
	}

	public String getVF01()
	{
		return vF01;
	}

	public void setVF01(String aVF01)
	{
		vF01 = aVF01;
	}

	public String getNF01()
	{
		return nF01;
	}

	public void setNF01(String aNF01)
	{
		nF01 = aNF01;
	}

	public int getIF01()
	{
		return iF01;
	}

	public void setIF01(int aIF01)
	{
		iF01 = aIF01;
	}

	public void setIF01(String aIF01)
	{
		if (aIF01 != null && !aIF01.equals(""))
		{
			Integer tInteger = new Integer(aIF01);
			int i = tInteger.intValue();
			iF01 = i;
		}
	}

	public double getDF02()
	{
		return dF02;
	}

	public void setDF02(double aDF02)
	{
		dF02 = aDF02;
	}

	public void setDF02(String aDF02)
	{
		if (aDF02 != null && !aDF02.equals(""))
		{
			Double tDouble = new Double(aDF02);
			double d = tDouble.doubleValue();
			dF02 = d;
		}
	}

	public String getDate01()
	{
		if (date01 != null)
			return fDate.getString(date01);
		else
			return null;
	}

	public void setDate01(Date aDate01)
	{
		date01 = aDate01;
	}

	public void setDate01(String aDate01)
	{
		if (aDate01 != null && !aDate01.equals(""))
			date01 = fDate.getDate(aDate01);
		else
			date01 = null;
	}

	public String getModifyOperator()
	{
		return modifyOperator;
	}

	public void setModifyOperator(String aModifyOperator)
	{
		modifyOperator = aModifyOperator;
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

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public void setSchema(MLibrarySchema aMLibrarySchema)
	{
		fileID = aMLibrarySchema.getFileID();
		name = aMLibrarySchema.getName();
		displayName = aMLibrarySchema.getDisplayName();
		fileDescription = aMLibrarySchema.getFileDescription();
		manageCom = aMLibrarySchema.getManageCom();
		branchType = aMLibrarySchema.getBranchType();
		nodeID = aMLibrarySchema.getNodeID();
		fileType = aMLibrarySchema.getFileType();
		filePath = aMLibrarySchema.getFilePath();
		documentType = aMLibrarySchema.getDocumentType();
		startDisplayDate = fDate.getDate(aMLibrarySchema.getStartDisplayDate());
		endDisplayDate = fDate.getDate(aMLibrarySchema.getEndDisplayDate());
		minDisplayGrade = aMLibrarySchema.getMinDisplayGrade();
		startDisplayTime = aMLibrarySchema.getStartDisplayTime();
		endDisplayTime = aMLibrarySchema.getEndDisplayTime();
		checkState = aMLibrarySchema.getCheckState();
		checkOperator = aMLibrarySchema.getCheckOperator();
		checkReason = aMLibrarySchema.getCheckReason();
		checkDate = fDate.getDate(aMLibrarySchema.getCheckDate());
		checkTime = aMLibrarySchema.getCheckTime();
		vF01 = aMLibrarySchema.getVF01();
		nF01 = aMLibrarySchema.getNF01();
		iF01 = aMLibrarySchema.getIF01();
		dF02 = aMLibrarySchema.getDF02();
		date01 = fDate.getDate(aMLibrarySchema.getDate01());
		modifyOperator = aMLibrarySchema.getModifyOperator();
		operator = aMLibrarySchema.getOperator();
		makeDate = fDate.getDate(aMLibrarySchema.getMakeDate());
		makeTime = aMLibrarySchema.getMakeTime();
		modifyDate = fDate.getDate(aMLibrarySchema.getModifyDate());
		modifyTime = aMLibrarySchema.getModifyTime();
		state = aMLibrarySchema.getState();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("FileID") == null)
				fileID = null;
			else
				fileID = rs.getString("FileID").trim();
			if (rs.getString("Name") == null)
				name = null;
			else
				name = rs.getString("Name").trim();
			if (rs.getString("DisplayName") == null)
				displayName = null;
			else
				displayName = rs.getString("DisplayName").trim();
			if (rs.getString("FileDescription") == null)
				fileDescription = null;
			else
				fileDescription = rs.getString("FileDescription").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			if (rs.getString("NodeID") == null)
				nodeID = null;
			else
				nodeID = rs.getString("NodeID").trim();
			if (rs.getString("FileType") == null)
				fileType = null;
			else
				fileType = rs.getString("FileType").trim();
			if (rs.getString("FilePath") == null)
				filePath = null;
			else
				filePath = rs.getString("FilePath").trim();
			if (rs.getString("DocumentType") == null)
				documentType = null;
			else
				documentType = rs.getString("DocumentType").trim();
			startDisplayDate = rs.getDate("StartDisplayDate");
			endDisplayDate = rs.getDate("EndDisplayDate");
			if (rs.getString("MinDisplayGrade") == null)
				minDisplayGrade = null;
			else
				minDisplayGrade = rs.getString("MinDisplayGrade").trim();
			if (rs.getString("StartDisplayTime") == null)
				startDisplayTime = null;
			else
				startDisplayTime = rs.getString("StartDisplayTime").trim();
			if (rs.getString("EndDisplayTime") == null)
				endDisplayTime = null;
			else
				endDisplayTime = rs.getString("EndDisplayTime").trim();
			if (rs.getString("CheckState") == null)
				checkState = null;
			else
				checkState = rs.getString("CheckState").trim();
			if (rs.getString("CheckOperator") == null)
				checkOperator = null;
			else
				checkOperator = rs.getString("CheckOperator").trim();
			if (rs.getString("CheckReason") == null)
				checkReason = null;
			else
				checkReason = rs.getString("CheckReason").trim();
			checkDate = rs.getDate("CheckDate");
			if (rs.getString("CheckTime") == null)
				checkTime = null;
			else
				checkTime = rs.getString("CheckTime").trim();
			if (rs.getString("VF01") == null)
				vF01 = null;
			else
				vF01 = rs.getString("VF01").trim();
			if (rs.getString("NF01") == null)
				nF01 = null;
			else
				nF01 = rs.getString("NF01").trim();
			iF01 = rs.getInt("IF01");
			dF02 = rs.getDouble("DF02");
			date01 = rs.getDate("Date01");
			if (rs.getString("ModifyOperator") == null)
				modifyOperator = null;
			else
				modifyOperator = rs.getString("ModifyOperator").trim();
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
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MLibrary表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MLibrarySchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MLibrarySchema getSchema()
	{
		MLibrarySchema aMLibrarySchema = new MLibrarySchema();
		aMLibrarySchema.setSchema(this);
		return aMLibrarySchema;
	}

	public MLibraryDB getDB()
	{
		MLibraryDB aDBOper = new MLibraryDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(fileID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(name));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(displayName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fileDescription));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nodeID));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fileType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(filePath));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(documentType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDisplayDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(endDisplayDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(minDisplayGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(startDisplayTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(endDisplayTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkState));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkOperator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkReason));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(checkDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(checkTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vF01));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nF01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iF01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(dF02));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(date01)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyOperator));
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
		strReturn.append(StrTool.cTrim(state));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			fileID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			displayName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			fileDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			nodeID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			fileType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			filePath = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			documentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			startDisplayDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|"));
			endDisplayDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
			minDisplayGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			startDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			endDisplayTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			checkState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			checkOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			checkReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			checkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
			checkTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MLibrarySchema";
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
		if (FCode.equalsIgnoreCase("fileID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fileID));
		if (FCode.equalsIgnoreCase("name"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(name));
		if (FCode.equalsIgnoreCase("displayName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(displayName));
		if (FCode.equalsIgnoreCase("fileDescription"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fileDescription));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("nodeID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nodeID));
		if (FCode.equalsIgnoreCase("fileType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(fileType));
		if (FCode.equalsIgnoreCase("filePath"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(filePath));
		if (FCode.equalsIgnoreCase("documentType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(documentType));
		if (FCode.equalsIgnoreCase("startDisplayDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
		if (FCode.equalsIgnoreCase("endDisplayDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
		if (FCode.equalsIgnoreCase("minDisplayGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(minDisplayGrade));
		if (FCode.equalsIgnoreCase("startDisplayTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(startDisplayTime));
		if (FCode.equalsIgnoreCase("endDisplayTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(endDisplayTime));
		if (FCode.equalsIgnoreCase("checkState"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkState));
		if (FCode.equalsIgnoreCase("checkOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkOperator));
		if (FCode.equalsIgnoreCase("checkReason"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkReason));
		if (FCode.equalsIgnoreCase("checkDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
		if (FCode.equalsIgnoreCase("checkTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(checkTime));
		if (FCode.equalsIgnoreCase("vF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vF01));
		if (FCode.equalsIgnoreCase("nF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF01));
		if (FCode.equalsIgnoreCase("iF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iF01));
		if (FCode.equalsIgnoreCase("dF02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dF02));
		if (FCode.equalsIgnoreCase("date01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
		if (FCode.equalsIgnoreCase("modifyOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyOperator));
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
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
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
			strFieldValue = StrTool.GBKToUnicode(fileID);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(name);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(displayName);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(fileDescription);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(nodeID);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(fileType);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(filePath);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(documentType);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDisplayDate()));
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDisplayDate()));
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(minDisplayGrade);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(startDisplayTime);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(endDisplayTime);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(checkState);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(checkOperator);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(checkReason);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getCheckDate()));
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(checkTime);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(vF01);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(nF01);
			break;

		case 22: // '\026'
			strFieldValue = String.valueOf(iF01);
			break;

		case 23: // '\027'
			strFieldValue = String.valueOf(dF02);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(state);
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
		if (FCode.equalsIgnoreCase("fileID"))
			if (FValue != null && !FValue.equals(""))
				fileID = FValue.trim();
			else
				fileID = null;
		if (FCode.equalsIgnoreCase("name"))
			if (FValue != null && !FValue.equals(""))
				name = FValue.trim();
			else
				name = null;
		if (FCode.equalsIgnoreCase("displayName"))
			if (FValue != null && !FValue.equals(""))
				displayName = FValue.trim();
			else
				displayName = null;
		if (FCode.equalsIgnoreCase("fileDescription"))
			if (FValue != null && !FValue.equals(""))
				fileDescription = FValue.trim();
			else
				fileDescription = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("branchType"))
			if (FValue != null && !FValue.equals(""))
				branchType = FValue.trim();
			else
				branchType = null;
		if (FCode.equalsIgnoreCase("nodeID"))
			if (FValue != null && !FValue.equals(""))
				nodeID = FValue.trim();
			else
				nodeID = null;
		if (FCode.equalsIgnoreCase("fileType"))
			if (FValue != null && !FValue.equals(""))
				fileType = FValue.trim();
			else
				fileType = null;
		if (FCode.equalsIgnoreCase("filePath"))
			if (FValue != null && !FValue.equals(""))
				filePath = FValue.trim();
			else
				filePath = null;
		if (FCode.equalsIgnoreCase("documentType"))
			if (FValue != null && !FValue.equals(""))
				documentType = FValue.trim();
			else
				documentType = null;
		if (FCode.equalsIgnoreCase("startDisplayDate"))
			if (FValue != null && !FValue.equals(""))
				startDisplayDate = fDate.getDate(FValue);
			else
				startDisplayDate = null;
		if (FCode.equalsIgnoreCase("endDisplayDate"))
			if (FValue != null && !FValue.equals(""))
				endDisplayDate = fDate.getDate(FValue);
			else
				endDisplayDate = null;
		if (FCode.equalsIgnoreCase("minDisplayGrade"))
			if (FValue != null && !FValue.equals(""))
				minDisplayGrade = FValue.trim();
			else
				minDisplayGrade = null;
		if (FCode.equalsIgnoreCase("startDisplayTime"))
			if (FValue != null && !FValue.equals(""))
				startDisplayTime = FValue.trim();
			else
				startDisplayTime = null;
		if (FCode.equalsIgnoreCase("endDisplayTime"))
			if (FValue != null && !FValue.equals(""))
				endDisplayTime = FValue.trim();
			else
				endDisplayTime = null;
		if (FCode.equalsIgnoreCase("checkState"))
			if (FValue != null && !FValue.equals(""))
				checkState = FValue.trim();
			else
				checkState = null;
		if (FCode.equalsIgnoreCase("checkOperator"))
			if (FValue != null && !FValue.equals(""))
				checkOperator = FValue.trim();
			else
				checkOperator = null;
		if (FCode.equalsIgnoreCase("checkReason"))
			if (FValue != null && !FValue.equals(""))
				checkReason = FValue.trim();
			else
				checkReason = null;
		if (FCode.equalsIgnoreCase("checkDate"))
			if (FValue != null && !FValue.equals(""))
				checkDate = fDate.getDate(FValue);
			else
				checkDate = null;
		if (FCode.equalsIgnoreCase("checkTime"))
			if (FValue != null && !FValue.equals(""))
				checkTime = FValue.trim();
			else
				checkTime = null;
		if (FCode.equalsIgnoreCase("vF01"))
			if (FValue != null && !FValue.equals(""))
				vF01 = FValue.trim();
			else
				vF01 = null;
		if (FCode.equalsIgnoreCase("nF01"))
			if (FValue != null && !FValue.equals(""))
				nF01 = FValue.trim();
			else
				nF01 = null;
		if (FCode.equalsIgnoreCase("iF01") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iF01 = i;
		}
		if (FCode.equalsIgnoreCase("dF02") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			dF02 = d;
		}
		if (FCode.equalsIgnoreCase("date01"))
			if (FValue != null && !FValue.equals(""))
				date01 = fDate.getDate(FValue);
			else
				date01 = null;
		if (FCode.equalsIgnoreCase("modifyOperator"))
			if (FValue != null && !FValue.equals(""))
				modifyOperator = FValue.trim();
			else
				modifyOperator = null;
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
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
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
		MLibrarySchema other = (MLibrarySchema)otherObject;
		if (fileID == null && other.getFileID() != null)
			return false;
		if (fileID != null && !fileID.equals(other.getFileID()))
			return false;
		if (name == null && other.getName() != null)
			return false;
		if (name != null && !name.equals(other.getName()))
			return false;
		if (displayName == null && other.getDisplayName() != null)
			return false;
		if (displayName != null && !displayName.equals(other.getDisplayName()))
			return false;
		if (fileDescription == null && other.getFileDescription() != null)
			return false;
		if (fileDescription != null && !fileDescription.equals(other.getFileDescription()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (nodeID == null && other.getNodeID() != null)
			return false;
		if (nodeID != null && !nodeID.equals(other.getNodeID()))
			return false;
		if (fileType == null && other.getFileType() != null)
			return false;
		if (fileType != null && !fileType.equals(other.getFileType()))
			return false;
		if (filePath == null && other.getFilePath() != null)
			return false;
		if (filePath != null && !filePath.equals(other.getFilePath()))
			return false;
		if (documentType == null && other.getDocumentType() != null)
			return false;
		if (documentType != null && !documentType.equals(other.getDocumentType()))
			return false;
		if (startDisplayDate == null && other.getStartDisplayDate() != null)
			return false;
		if (startDisplayDate != null && !fDate.getString(startDisplayDate).equals(other.getStartDisplayDate()))
			return false;
		if (endDisplayDate == null && other.getEndDisplayDate() != null)
			return false;
		if (endDisplayDate != null && !fDate.getString(endDisplayDate).equals(other.getEndDisplayDate()))
			return false;
		if (minDisplayGrade == null && other.getMinDisplayGrade() != null)
			return false;
		if (minDisplayGrade != null && !minDisplayGrade.equals(other.getMinDisplayGrade()))
			return false;
		if (startDisplayTime == null && other.getStartDisplayTime() != null)
			return false;
		if (startDisplayTime != null && !startDisplayTime.equals(other.getStartDisplayTime()))
			return false;
		if (endDisplayTime == null && other.getEndDisplayTime() != null)
			return false;
		if (endDisplayTime != null && !endDisplayTime.equals(other.getEndDisplayTime()))
			return false;
		if (checkState == null && other.getCheckState() != null)
			return false;
		if (checkState != null && !checkState.equals(other.getCheckState()))
			return false;
		if (checkOperator == null && other.getCheckOperator() != null)
			return false;
		if (checkOperator != null && !checkOperator.equals(other.getCheckOperator()))
			return false;
		if (checkReason == null && other.getCheckReason() != null)
			return false;
		if (checkReason != null && !checkReason.equals(other.getCheckReason()))
			return false;
		if (checkDate == null && other.getCheckDate() != null)
			return false;
		if (checkDate != null && !fDate.getString(checkDate).equals(other.getCheckDate()))
			return false;
		if (checkTime == null && other.getCheckTime() != null)
			return false;
		if (checkTime != null && !checkTime.equals(other.getCheckTime()))
			return false;
		if (vF01 == null && other.getVF01() != null)
			return false;
		if (vF01 != null && !vF01.equals(other.getVF01()))
			return false;
		if (nF01 == null && other.getNF01() != null)
			return false;
		if (nF01 != null && !nF01.equals(other.getNF01()))
			return false;
		if (iF01 != other.getIF01())
			return false;
		if (Double.doubleToLongBits(dF02) != Double.doubleToLongBits(other.getDF02()))
			return false;
		if (date01 == null && other.getDate01() != null)
			return false;
		if (date01 != null && !fDate.getString(date01).equals(other.getDate01()))
			return false;
		if (modifyOperator == null && other.getModifyOperator() != null)
			return false;
		if (modifyOperator != null && !modifyOperator.equals(other.getModifyOperator()))
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
		if (state == null && other.getState() != null)
			return false;
		return state == null || state.equals(other.getState());
	}

	public int getFieldCount()
	{
		return 32;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("fileID"))
			return 0;
		if (strFieldName.equals("name"))
			return 1;
		if (strFieldName.equals("displayName"))
			return 2;
		if (strFieldName.equals("fileDescription"))
			return 3;
		if (strFieldName.equals("manageCom"))
			return 4;
		if (strFieldName.equals("branchType"))
			return 5;
		if (strFieldName.equals("nodeID"))
			return 6;
		if (strFieldName.equals("fileType"))
			return 7;
		if (strFieldName.equals("filePath"))
			return 8;
		if (strFieldName.equals("documentType"))
			return 9;
		if (strFieldName.equals("startDisplayDate"))
			return 10;
		if (strFieldName.equals("endDisplayDate"))
			return 11;
		if (strFieldName.equals("minDisplayGrade"))
			return 12;
		if (strFieldName.equals("startDisplayTime"))
			return 13;
		if (strFieldName.equals("endDisplayTime"))
			return 14;
		if (strFieldName.equals("checkState"))
			return 15;
		if (strFieldName.equals("checkOperator"))
			return 16;
		if (strFieldName.equals("checkReason"))
			return 17;
		if (strFieldName.equals("checkDate"))
			return 18;
		if (strFieldName.equals("checkTime"))
			return 19;
		if (strFieldName.equals("vF01"))
			return 20;
		if (strFieldName.equals("nF01"))
			return 21;
		if (strFieldName.equals("iF01"))
			return 22;
		if (strFieldName.equals("dF02"))
			return 23;
		if (strFieldName.equals("date01"))
			return 24;
		if (strFieldName.equals("modifyOperator"))
			return 25;
		if (strFieldName.equals("operator"))
			return 26;
		if (strFieldName.equals("makeDate"))
			return 27;
		if (strFieldName.equals("makeTime"))
			return 28;
		if (strFieldName.equals("modifyDate"))
			return 29;
		if (strFieldName.equals("modifyTime"))
			return 30;
		return !strFieldName.equals("state") ? -1 : 31;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "fileID";
			break;

		case 1: // '\001'
			strFieldName = "name";
			break;

		case 2: // '\002'
			strFieldName = "displayName";
			break;

		case 3: // '\003'
			strFieldName = "fileDescription";
			break;

		case 4: // '\004'
			strFieldName = "manageCom";
			break;

		case 5: // '\005'
			strFieldName = "branchType";
			break;

		case 6: // '\006'
			strFieldName = "nodeID";
			break;

		case 7: // '\007'
			strFieldName = "fileType";
			break;

		case 8: // '\b'
			strFieldName = "filePath";
			break;

		case 9: // '\t'
			strFieldName = "documentType";
			break;

		case 10: // '\n'
			strFieldName = "startDisplayDate";
			break;

		case 11: // '\013'
			strFieldName = "endDisplayDate";
			break;

		case 12: // '\f'
			strFieldName = "minDisplayGrade";
			break;

		case 13: // '\r'
			strFieldName = "startDisplayTime";
			break;

		case 14: // '\016'
			strFieldName = "endDisplayTime";
			break;

		case 15: // '\017'
			strFieldName = "checkState";
			break;

		case 16: // '\020'
			strFieldName = "checkOperator";
			break;

		case 17: // '\021'
			strFieldName = "checkReason";
			break;

		case 18: // '\022'
			strFieldName = "checkDate";
			break;

		case 19: // '\023'
			strFieldName = "checkTime";
			break;

		case 20: // '\024'
			strFieldName = "vF01";
			break;

		case 21: // '\025'
			strFieldName = "nF01";
			break;

		case 22: // '\026'
			strFieldName = "iF01";
			break;

		case 23: // '\027'
			strFieldName = "dF02";
			break;

		case 24: // '\030'
			strFieldName = "date01";
			break;

		case 25: // '\031'
			strFieldName = "modifyOperator";
			break;

		case 26: // '\032'
			strFieldName = "operator";
			break;

		case 27: // '\033'
			strFieldName = "makeDate";
			break;

		case 28: // '\034'
			strFieldName = "makeTime";
			break;

		case 29: // '\035'
			strFieldName = "modifyDate";
			break;

		case 30: // '\036'
			strFieldName = "modifyTime";
			break;

		case 31: // '\037'
			strFieldName = "state";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("fileID"))
			return 0;
		if (strFieldName.equals("name"))
			return 0;
		if (strFieldName.equals("displayName"))
			return 0;
		if (strFieldName.equals("fileDescription"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("nodeID"))
			return 0;
		if (strFieldName.equals("fileType"))
			return 0;
		if (strFieldName.equals("filePath"))
			return 0;
		if (strFieldName.equals("documentType"))
			return 0;
		if (strFieldName.equals("startDisplayDate"))
			return 1;
		if (strFieldName.equals("endDisplayDate"))
			return 1;
		if (strFieldName.equals("minDisplayGrade"))
			return 0;
		if (strFieldName.equals("startDisplayTime"))
			return 0;
		if (strFieldName.equals("endDisplayTime"))
			return 0;
		if (strFieldName.equals("checkState"))
			return 0;
		if (strFieldName.equals("checkOperator"))
			return 0;
		if (strFieldName.equals("checkReason"))
			return 0;
		if (strFieldName.equals("checkDate"))
			return 1;
		if (strFieldName.equals("checkTime"))
			return 0;
		if (strFieldName.equals("vF01"))
			return 0;
		if (strFieldName.equals("nF01"))
			return 0;
		if (strFieldName.equals("iF01"))
			return 3;
		if (strFieldName.equals("dF02"))
			return 4;
		if (strFieldName.equals("date01"))
			return 1;
		if (strFieldName.equals("modifyOperator"))
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
		return !strFieldName.equals("state") ? -1 : 0;
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
			nFieldType = 1;
			break;

		case 11: // '\013'
			nFieldType = 1;
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
			nFieldType = 1;
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
			nFieldType = 3;
			break;

		case 23: // '\027'
			nFieldType = 4;
			break;

		case 24: // '\030'
			nFieldType = 1;
			break;

		case 25: // '\031'
			nFieldType = 0;
			break;

		case 26: // '\032'
			nFieldType = 0;
			break;

		case 27: // '\033'
			nFieldType = 1;
			break;

		case 28: // '\034'
			nFieldType = 0;
			break;

		case 29: // '\035'
			nFieldType = 1;
			break;

		case 30: // '\036'
			nFieldType = 0;
			break;

		case 31: // '\037'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
