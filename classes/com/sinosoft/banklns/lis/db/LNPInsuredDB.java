// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsuredDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPInsuredDB extends LNPInsuredSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPInsuredDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPInsured");
		mflag = true;
	}

	public LNPInsuredDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPInsured");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPInsuredSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPInsuredSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "getCount";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return -1;
		} else
		{
			return tCount;
		}
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("DELETE FROM LNPInsured WHERE  ContNo = ? AND InsuredId = ?");
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getContNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getInsuredId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("UPDATE LNPInsured SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , InsuredNo = ? , InsuredId = ? , PrtNo = ? , AppntNo = ? , AppntId = ? , ManageCom = ? , SignCity = ? , ExecuteCom = ? , FamilyID = ? , RelationToMainInsured = ? , RelationToAppnt = ? , AddressNo = ? , SequenceNo = ? , Name = ? , Appellation = ? , Sex = ? , Birthday = ? , AppAge = ? , AppAgeType = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , PartOccupationType = ? , PartOccupationCode = ? , WorkType = ? , PluralityType = ? , SmokeFlag = ? , ContPlanCode = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , InsuredPeoples = ? WHERE  ContNo = ? AND InsuredId = ?");
			if (getGrpContNo() == null || getGrpContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getGrpContNo());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getContNo());
			if (getProposalContNo() == null || getProposalContNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getProposalContNo());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getInsuredNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getInsuredId());
			if (getPrtNo() == null || getPrtNo().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getPrtNo());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getAppntNo());
			if (getAppntId() == null || getAppntId().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAppntId());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getManageCom());
			if (getSignCity() == null || getSignCity().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getSignCity());
			if (getExecuteCom() == null || getExecuteCom().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getExecuteCom());
			if (getFamilyID() == null || getFamilyID().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getFamilyID());
			if (getRelationToMainInsured() == null || getRelationToMainInsured().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getRelationToMainInsured());
			if (getRelationToAppnt() == null || getRelationToAppnt().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getRelationToAppnt());
			if (getAddressNo() == null || getAddressNo().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getAddressNo());
			if (getSequenceNo() == null || getSequenceNo().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getSequenceNo());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getName());
			if (getAppellation() == null || getAppellation().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getAppellation());
			if (getSex() == null || getSex().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getSex());
			if (getBirthday() == null || getBirthday().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getBirthday()));
			pstmt.setInt(21, getAppAge());
			if (getAppAgeType() == null || getAppAgeType().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getAppAgeType());
			if (getIDType() == null || getIDType().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getIDType());
			if (getIDNo() == null || getIDNo().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getIDNo());
			if (getIDValidity() == null || getIDValidity().equals("null"))
				pstmt.setNull(25, 91);
			else
				pstmt.setDate(25, Date.valueOf(getIDValidity()));
			if (getIDPerpetual() == null || getIDPerpetual().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getIDPerpetual());
			if (getNativePlace() == null || getNativePlace().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getNativePlace());
			if (getNationality() == null || getNationality().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getNationality());
			if (getRgtAddress() == null || getRgtAddress().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getRgtAddress());
			if (getMarriage() == null || getMarriage().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getMarriage());
			if (getMarriageDate() == null || getMarriageDate().equals("null"))
				pstmt.setNull(31, 91);
			else
				pstmt.setDate(31, Date.valueOf(getMarriageDate()));
			if (getHealth() == null || getHealth().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getHealth());
			pstmt.setDouble(33, getStature());
			pstmt.setDouble(34, getAvoirdupois());
			if (getDegree() == null || getDegree().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getDegree());
			if (getCreditGrade() == null || getCreditGrade().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getCreditGrade());
			if (getBankCode() == null || getBankCode().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getBankCode());
			if (getBankAccNo() == null || getBankAccNo().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getBankAccNo());
			if (getAccName() == null || getAccName().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getAccName());
			if (getJoinCompanyDate() == null || getJoinCompanyDate().equals("null"))
				pstmt.setNull(40, 91);
			else
				pstmt.setDate(40, Date.valueOf(getJoinCompanyDate()));
			if (getStartWorkDate() == null || getStartWorkDate().equals("null"))
				pstmt.setNull(41, 91);
			else
				pstmt.setDate(41, Date.valueOf(getStartWorkDate()));
			if (getPosition() == null || getPosition().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getPosition());
			pstmt.setDouble(43, getSalary());
			if (getOccupationType() == null || getOccupationType().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getOccupationType());
			if (getOccupationCode() == null || getOccupationCode().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getOccupationCode());
			if (getPartOccupationType() == null || getPartOccupationType().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getPartOccupationType());
			if (getPartOccupationCode() == null || getPartOccupationCode().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getPartOccupationCode());
			if (getWorkType() == null || getWorkType().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getWorkType());
			if (getPluralityType() == null || getPluralityType().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getPluralityType());
			if (getSmokeFlag() == null || getSmokeFlag().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getSmokeFlag());
			if (getContPlanCode() == null || getContPlanCode().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getContPlanCode());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(53, 91);
			else
				pstmt.setDate(53, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(55, 91);
			else
				pstmt.setDate(55, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(56, 12);
			else
				pstmt.setString(56, getModifyTime());
			pstmt.setInt(57, getInsuredPeoples());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(58, 12);
			else
				pstmt.setString(58, getContNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(59, 12);
			else
				pstmt.setString(59, getInsuredId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("INSERT INTO LNPInsured VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getGrpContNo() == null || getGrpContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getGrpContNo());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getContNo());
			if (getProposalContNo() == null || getProposalContNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getProposalContNo());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getInsuredNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getInsuredId());
			if (getPrtNo() == null || getPrtNo().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getPrtNo());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getAppntNo());
			if (getAppntId() == null || getAppntId().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAppntId());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getManageCom());
			if (getSignCity() == null || getSignCity().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getSignCity());
			if (getExecuteCom() == null || getExecuteCom().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getExecuteCom());
			if (getFamilyID() == null || getFamilyID().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getFamilyID());
			if (getRelationToMainInsured() == null || getRelationToMainInsured().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getRelationToMainInsured());
			if (getRelationToAppnt() == null || getRelationToAppnt().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getRelationToAppnt());
			if (getAddressNo() == null || getAddressNo().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getAddressNo());
			if (getSequenceNo() == null || getSequenceNo().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getSequenceNo());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getName());
			if (getAppellation() == null || getAppellation().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getAppellation());
			if (getSex() == null || getSex().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getSex());
			if (getBirthday() == null || getBirthday().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getBirthday()));
			pstmt.setInt(21, getAppAge());
			if (getAppAgeType() == null || getAppAgeType().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getAppAgeType());
			if (getIDType() == null || getIDType().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getIDType());
			if (getIDNo() == null || getIDNo().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getIDNo());
			if (getIDValidity() == null || getIDValidity().equals("null"))
				pstmt.setNull(25, 91);
			else
				pstmt.setDate(25, Date.valueOf(getIDValidity()));
			if (getIDPerpetual() == null || getIDPerpetual().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getIDPerpetual());
			if (getNativePlace() == null || getNativePlace().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getNativePlace());
			if (getNationality() == null || getNationality().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getNationality());
			if (getRgtAddress() == null || getRgtAddress().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getRgtAddress());
			if (getMarriage() == null || getMarriage().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getMarriage());
			if (getMarriageDate() == null || getMarriageDate().equals("null"))
				pstmt.setNull(31, 91);
			else
				pstmt.setDate(31, Date.valueOf(getMarriageDate()));
			if (getHealth() == null || getHealth().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getHealth());
			pstmt.setDouble(33, getStature());
			pstmt.setDouble(34, getAvoirdupois());
			if (getDegree() == null || getDegree().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getDegree());
			if (getCreditGrade() == null || getCreditGrade().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getCreditGrade());
			if (getBankCode() == null || getBankCode().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getBankCode());
			if (getBankAccNo() == null || getBankAccNo().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getBankAccNo());
			if (getAccName() == null || getAccName().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getAccName());
			if (getJoinCompanyDate() == null || getJoinCompanyDate().equals("null"))
				pstmt.setNull(40, 91);
			else
				pstmt.setDate(40, Date.valueOf(getJoinCompanyDate()));
			if (getStartWorkDate() == null || getStartWorkDate().equals("null"))
				pstmt.setNull(41, 91);
			else
				pstmt.setDate(41, Date.valueOf(getStartWorkDate()));
			if (getPosition() == null || getPosition().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getPosition());
			pstmt.setDouble(43, getSalary());
			if (getOccupationType() == null || getOccupationType().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getOccupationType());
			if (getOccupationCode() == null || getOccupationCode().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getOccupationCode());
			if (getPartOccupationType() == null || getPartOccupationType().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getPartOccupationType());
			if (getPartOccupationCode() == null || getPartOccupationCode().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getPartOccupationCode());
			if (getWorkType() == null || getWorkType().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getWorkType());
			if (getPluralityType() == null || getPluralityType().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getPluralityType());
			if (getSmokeFlag() == null || getSmokeFlag().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getSmokeFlag());
			if (getContPlanCode() == null || getContPlanCode().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getContPlanCode());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(53, 91);
			else
				pstmt.setDate(53, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(55, 91);
			else
				pstmt.setDate(55, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(56, 12);
			else
				pstmt.setString(56, getModifyTime());
			pstmt.setInt(57, getInsuredPeoples());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean getInfo()
	{
		PreparedStatement pstmt;
		ResultSet rs;
		pstmt = null;
		rs = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		int i;
		pstmt = con.prepareStatement("SELECT * FROM LNPInsured WHERE  ContNo = ? AND InsuredId = ?", 1003, 1007);
		if (getContNo() == null || getContNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getContNo());
		if (getInsuredId() == null || getInsuredId().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getInsuredId());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_237;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_237;
		CError tError = new CError();
		tError.moduleName = "LNPInsuredDB";
		tError.functionName = "getInfo";
		tError.errorMessage = "取数失败!";
		mErrors.addOneError(tError);
		try
		{
			rs.close();
		}
		catch (Exception exception4) { }
		try
		{
			pstmt.close();
		}
		catch (Exception exception5) { }
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception6) { }
		return false;
label0:
		{
			try
			{
				try
				{
					rs.close();
				}
				catch (Exception exception1) { }
				try
				{
					pstmt.close();
				}
				catch (Exception exception2) { }
				if (i != 0)
					break label0;
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception3) { }
			}
			catch (Exception e)
			{
				CError tError = new CError();
				tError.moduleName = "LNPInsuredDB";
				tError.functionName = "getInfo";
				tError.errorMessage = e.toString();
				mErrors.addOneError(tError);
				try
				{
					rs.close();
				}
				catch (Exception exception7) { }
				try
				{
					pstmt.close();
				}
				catch (Exception exception8) { }
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception9) { }
				return false;
			}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public LNPInsuredSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPInsuredSet aLNPInsuredSet = new LNPInsuredSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPInsured");
			LNPInsuredSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPInsuredSchema s1;
			for (; rs.next(); aLNPInsuredSet.add(s1))
			{
				i++;
				s1 = new LNPInsuredSchema();
				s1.setSchema(rs, i);
			}

			try
			{
				rs.close();
			}
			catch (Exception exception4) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception5) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception3) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aLNPInsuredSet;
	}

	public LNPInsuredSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPInsuredSet aLNPInsuredSet = new LNPInsuredSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPInsuredSchema s1;
			for (; rs.next(); aLNPInsuredSet.add(s1))
			{
				i++;
				s1 = new LNPInsuredSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPInsuredDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
			}

			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception3) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception4) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception5) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aLNPInsuredSet;
	}

	public LNPInsuredSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPInsuredSet aLNPInsuredSet = new LNPInsuredSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPInsured");
			LNPInsuredSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) 
			{
				if (++i < nStart)
					continue;
				if (i >= nStart + nCount)
					break;
				LNPInsuredSchema s1 = new LNPInsuredSchema();
				s1.setSchema(rs, i);
				aLNPInsuredSet.add(s1);
			}
			try
			{
				rs.close();
			}
			catch (Exception exception4) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception5) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception3) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aLNPInsuredSet;
	}

	public LNPInsuredSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPInsuredSet aLNPInsuredSet = new LNPInsuredSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			while (rs.next()) 
			{
				if (++i < nStart)
					continue;
				if (i >= nStart + nCount)
					break;
				LNPInsuredSchema s1 = new LNPInsuredSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPInsuredDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPInsuredSet.add(s1);
			}
			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception3) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception4) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception5) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aLNPInsuredSet;
	}

	public boolean update(String strWherePart)
	{
label0:
		{
			Statement stmt = null;
			if (!mflag)
				con = DBConnPool.getConnection();
			try
			{
				stmt = con.createStatement(1003, 1007);
				SQLString sqlObj = new SQLString("LNPInsured");
				LNPInsuredSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPInsured ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPInsuredDB";
				tError.functionName = "update";
				tError.errorMessage = "更新数据失败!";
				mErrors.addOneError(tError);
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception3) { }
			}
			catch (Exception e)
			{
				CError tError = new CError();
				tError.moduleName = "LNPInsuredDB";
				tError.functionName = "update";
				tError.errorMessage = e.toString();
				mErrors.addOneError(tError);
				try
				{
					stmt.close();
				}
				catch (Exception exception1) { }
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception2) { }
				return false;
			}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean prepareData(String strSQL)
	{
		if (mResultSet != null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "prepareData";
			tError.errorMessage = "数据集非空，程序在准备数据集之后，没有关闭！";
			mErrors.addOneError(tError);
			return false;
		}
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			mStatement = con.createStatement(1003, 1007);
			mResultSet = mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "prepareData";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				mResultSet.close();
			}
			catch (Exception exception1) { }
			try
			{
				mStatement.close();
			}
			catch (Exception exception2) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception3) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean hasMoreData()
	{
		boolean flag = true;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return false;
		}
		try
		{
			flag = mResultSet.next();
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				mResultSet.close();
				mResultSet = null;
			}
			catch (Exception exception) { }
			try
			{
				mStatement.close();
				mStatement = null;
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		return flag;
	}

	public LNPInsuredSet getData()
	{
		int tCount = 0;
		LNPInsuredSet tLNPInsuredSet = new LNPInsuredSet();
		LNPInsuredSchema tLNPInsuredSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPInsuredSchema = new LNPInsuredSchema();
			tLNPInsuredSchema.setSchema(mResultSet, 1);
			tLNPInsuredSet.add(tLNPInsuredSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPInsuredSchema = new LNPInsuredSchema();
					tLNPInsuredSchema.setSchema(mResultSet, 1);
					tLNPInsuredSet.add(tLNPInsuredSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "getData";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				mResultSet.close();
				mResultSet = null;
			}
			catch (Exception exception) { }
			try
			{
				mStatement.close();
				mStatement = null;
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return null;
		}
		return tLNPInsuredSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPInsuredDB";
				tError.functionName = "closeData";
				tError.errorMessage = "数据集已经关闭了�?";
				mErrors.addOneError(tError);
				flag = false;
			} else
			{
				mResultSet.close();
				mResultSet = null;
			}
		}
		catch (Exception ex2)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex2.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		try
		{
			if (mStatement == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPInsuredDB";
				tError.functionName = "closeData";
				tError.errorMessage = "语句已经关闭了！";
				mErrors.addOneError(tError);
				flag = false;
			} else
			{
				mStatement.close();
				mStatement = null;
			}
		}
		catch (Exception ex3)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsuredDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
