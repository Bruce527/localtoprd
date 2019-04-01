// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MNewClientDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MNewClientSchema;
import com.sinosoft.map.lis.vschema.MNewClientSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MNewClientDB extends MNewClientSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MNewClientDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MNewClient");
		mflag = true;
	}

	public MNewClientDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MNewClient");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MNewClientSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewClientDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MNewClientSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewClientDB";
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
			pstmt = con.prepareStatement("DELETE FROM MNewClient WHERE  CustomerNo = ?");
			if (getCustomerNo() == null || getCustomerNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getCustomerNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewClientDB";
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
			pstmt = con.prepareStatement("UPDATE MNewClient SET  CustomerNo = ? , CustomerNo2 = ? , ClientName = ? , Gender = ? , Birthday = ? , EMail = ? , GrpZipCode = ? , GrpAddress = ? , GrpNo = ? , BP = ? , GrpAddressCode = ? , Phone2 = ? , GrpName = ? , GrpPhone = ? , Phone = ? , Mobile = ? , OccupationCode = ? , Position = ? , WorkType = ? , OccupationType = ? , HomeAddress = ? , HomeAddressCode = ? , RgtAddress = ? , PostalAddress = ? , ZipCode = ? , HomeZipCode = ? , SequenceNo = ? , Stature = ? , Avoirdupois = ? , SmokeFlag = ? , DeathDate = ? , Marriage = ? , CredentType = ? , CredentNO = ? , OthIDNo = ? , OthIDType = ? , ICNo = ? , Salary = ? , YearSalary = ? , NativePlace = ? , Nationality = ? , MarriageDate = ? , Degree = ? , PolNo = ? , RelationToInsured = ? , PluralityType = ? , StartWorkDate = ? , Health = ? , Password = ? , JoinCompanyDate = ? , AppntGrade = ? , CreditGrade = ? , ClientType = ? , State = ? , Agentcode = ? , SignDate = ? , AddrChoise = ? , CustomeProperty = ? , BirthdayFlag = ? , Appellation = ? , IDDNo = ? , ValidityDate = ? , CountryOrArea = ? , SpecialDate = ? , DeleteFlag = ? , Interest = ? , CustomeType = ? , Introducer = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CustomerNo = ?");
			if (getCustomerNo() == null || getCustomerNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getCustomerNo());
			if (getCustomerNo2() == null || getCustomerNo2().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getCustomerNo2());
			if (getClientName() == null || getClientName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getClientName());
			if (getGender() == null || getGender().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getGender());
			if (getEMail() == null || getEMail().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getEMail());
			if (getGrpZipCode() == null || getGrpZipCode().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getGrpZipCode());
			if (getGrpAddress() == null || getGrpAddress().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getGrpAddress());
			if (getGrpNo() == null || getGrpNo().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getGrpNo());
			if (getBP() == null || getBP().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getBP());
			if (getGrpAddressCode() == null || getGrpAddressCode().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getGrpAddressCode());
			if (getPhone2() == null || getPhone2().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getPhone2());
			if (getGrpName() == null || getGrpName().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getGrpName());
			if (getGrpPhone() == null || getGrpPhone().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getGrpPhone());
			if (getPhone() == null || getPhone().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getPhone());
			if (getMobile() == null || getMobile().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getMobile());
			if (getOccupationCode() == null || getOccupationCode().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getOccupationCode());
			if (getPosition() == null || getPosition().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getPosition());
			if (getWorkType() == null || getWorkType().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getWorkType());
			if (getOccupationType() == null || getOccupationType().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getOccupationType());
			if (getHomeAddress() == null || getHomeAddress().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getHomeAddress());
			if (getHomeAddressCode() == null || getHomeAddressCode().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getHomeAddressCode());
			if (getRgtAddress() == null || getRgtAddress().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getRgtAddress());
			if (getPostalAddress() == null || getPostalAddress().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getPostalAddress());
			if (getZipCode() == null || getZipCode().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getZipCode());
			if (getHomeZipCode() == null || getHomeZipCode().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getHomeZipCode());
			if (getSequenceNo() == null || getSequenceNo().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getSequenceNo());
			pstmt.setDouble(28, getStature());
			pstmt.setDouble(29, getAvoirdupois());
			if (getSmokeFlag() == null || getSmokeFlag().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getSmokeFlag());
			if (getMarriage() == null || getMarriage().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getMarriage());
			if (getCredentType() == null || getCredentType().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getCredentType());
			if (getCredentNO() == null || getCredentNO().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getCredentNO());
			if (getOthIDNo() == null || getOthIDNo().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getOthIDNo());
			if (getOthIDType() == null || getOthIDType().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getOthIDType());
			if (getICNo() == null || getICNo().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getICNo());
			if (getNativePlace() == null || getNativePlace().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getNativePlace());
			if (getNationality() == null || getNationality().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getNationality());
			if (getDegree() == null || getDegree().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getDegree());
			if (getPolNo() == null || getPolNo().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getPolNo());
			if (getRelationToInsured() == null || getRelationToInsured().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getRelationToInsured());
			if (getPluralityType() == null || getPluralityType().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getPluralityType());
			if (getHealth() == null || getHealth().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getHealth());
			if (getPassword() == null || getPassword().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getPassword());
			if (getAppntGrade() == null || getAppntGrade().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getAppntGrade());
			if (getCreditGrade() == null || getCreditGrade().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getCreditGrade());
			if (getClientType() == null || getClientType().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getClientType());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getState());
			if (getAgentcode() == null || getAgentcode().equals("null"))
				pstmt.setNull(55, 12);
			else
				pstmt.setString(55, getAgentcode());
			if (getAddrChoise() == null || getAddrChoise().equals("null"))
				pstmt.setNull(57, 12);
			else
				pstmt.setString(57, getAddrChoise());
			if (getCustomeProperty() == null || getCustomeProperty().equals("null"))
				pstmt.setNull(58, 12);
			else
				pstmt.setString(58, getCustomeProperty());
			if (getBirthdayFlag() == null || getBirthdayFlag().equals("null"))
				pstmt.setNull(59, 12);
			else
				pstmt.setString(59, getBirthdayFlag());
			if (getAppellation() == null || getAppellation().equals("null"))
				pstmt.setNull(60, 12);
			else
				pstmt.setString(60, getAppellation());
			if (getIDDNo() == null || getIDDNo().equals("null"))
				pstmt.setNull(61, 12);
			else
				pstmt.setString(61, getIDDNo());
			if (getCountryOrArea() == null || getCountryOrArea().equals("null"))
				pstmt.setNull(63, 12);
			else
				pstmt.setString(63, getCountryOrArea());
			if (getDeleteFlag() == null || getDeleteFlag().equals("null"))
				pstmt.setNull(65, 12);
			else
				pstmt.setString(65, getDeleteFlag());
			if (getInterest() == null || getInterest().equals("null"))
				pstmt.setNull(66, 12);
			else
				pstmt.setString(66, getInterest());
			if (getCustomeType() == null || getCustomeType().equals("null"))
				pstmt.setNull(67, 12);
			else
				pstmt.setString(67, getCustomeType());
			if (getIntroducer() == null || getIntroducer().equals("null"))
				pstmt.setNull(68, 12);
			else
				pstmt.setString(68, getIntroducer());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(69, 12);
			else
				pstmt.setString(69, getOperator());
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(71, 12);
			else
				pstmt.setString(71, getMakeTime());
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(73, 12);
			else
				pstmt.setString(73, getModifyTime());
			if (getCustomerNo() == null || getCustomerNo().equals("null"))
				pstmt.setNull(74, 12);
			else
				pstmt.setString(74, getCustomerNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewClientDB";
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
			pstmt = con.prepareStatement("INSERT INTO MNewClient VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getCustomerNo() == null || getCustomerNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getCustomerNo());
			if (getCustomerNo2() == null || getCustomerNo2().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getCustomerNo2());
			if (getClientName() == null || getClientName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getClientName());
			if (getGender() == null || getGender().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getGender());
			if (getEMail() == null || getEMail().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getEMail());
			if (getGrpZipCode() == null || getGrpZipCode().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getGrpZipCode());
			if (getGrpAddress() == null || getGrpAddress().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getGrpAddress());
			if (getGrpNo() == null || getGrpNo().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getGrpNo());
			if (getBP() == null || getBP().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getBP());
			if (getGrpAddressCode() == null || getGrpAddressCode().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getGrpAddressCode());
			if (getPhone2() == null || getPhone2().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getPhone2());
			if (getGrpName() == null || getGrpName().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getGrpName());
			if (getGrpPhone() == null || getGrpPhone().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getGrpPhone());
			if (getPhone() == null || getPhone().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getPhone());
			if (getMobile() == null || getMobile().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getMobile());
			if (getOccupationCode() == null || getOccupationCode().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getOccupationCode());
			if (getPosition() == null || getPosition().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getPosition());
			if (getWorkType() == null || getWorkType().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getWorkType());
			if (getOccupationType() == null || getOccupationType().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getOccupationType());
			if (getHomeAddress() == null || getHomeAddress().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getHomeAddress());
			if (getHomeAddressCode() == null || getHomeAddressCode().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getHomeAddressCode());
			if (getRgtAddress() == null || getRgtAddress().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getRgtAddress());
			if (getPostalAddress() == null || getPostalAddress().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getPostalAddress());
			if (getZipCode() == null || getZipCode().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getZipCode());
			if (getHomeZipCode() == null || getHomeZipCode().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getHomeZipCode());
			if (getSequenceNo() == null || getSequenceNo().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getSequenceNo());
			pstmt.setDouble(28, getStature());
			pstmt.setDouble(29, getAvoirdupois());
			if (getSmokeFlag() == null || getSmokeFlag().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getSmokeFlag());
			if (getMarriage() == null || getMarriage().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getMarriage());
			if (getCredentType() == null || getCredentType().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getCredentType());
			if (getCredentNO() == null || getCredentNO().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getCredentNO());
			if (getOthIDNo() == null || getOthIDNo().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getOthIDNo());
			if (getOthIDType() == null || getOthIDType().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getOthIDType());
			if (getICNo() == null || getICNo().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getICNo());
			if (getNativePlace() == null || getNativePlace().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getNativePlace());
			if (getNationality() == null || getNationality().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getNationality());
			if (getDegree() == null || getDegree().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getDegree());
			if (getPolNo() == null || getPolNo().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getPolNo());
			if (getRelationToInsured() == null || getRelationToInsured().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getRelationToInsured());
			if (getPluralityType() == null || getPluralityType().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getPluralityType());
			if (getHealth() == null || getHealth().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getHealth());
			if (getPassword() == null || getPassword().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getPassword());
			if (getAppntGrade() == null || getAppntGrade().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getAppntGrade());
			if (getCreditGrade() == null || getCreditGrade().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getCreditGrade());
			if (getClientType() == null || getClientType().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getClientType());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getState());
			if (getAgentcode() == null || getAgentcode().equals("null"))
				pstmt.setNull(55, 12);
			else
				pstmt.setString(55, getAgentcode());
			if (getAddrChoise() == null || getAddrChoise().equals("null"))
				pstmt.setNull(57, 12);
			else
				pstmt.setString(57, getAddrChoise());
			if (getCustomeProperty() == null || getCustomeProperty().equals("null"))
				pstmt.setNull(58, 12);
			else
				pstmt.setString(58, getCustomeProperty());
			if (getBirthdayFlag() == null || getBirthdayFlag().equals("null"))
				pstmt.setNull(59, 12);
			else
				pstmt.setString(59, getBirthdayFlag());
			if (getAppellation() == null || getAppellation().equals("null"))
				pstmt.setNull(60, 12);
			else
				pstmt.setString(60, getAppellation());
			if (getIDDNo() == null || getIDDNo().equals("null"))
				pstmt.setNull(61, 12);
			else
				pstmt.setString(61, getIDDNo());
			if (getCountryOrArea() == null || getCountryOrArea().equals("null"))
				pstmt.setNull(63, 12);
			else
				pstmt.setString(63, getCountryOrArea());
			if (getDeleteFlag() == null || getDeleteFlag().equals("null"))
				pstmt.setNull(65, 12);
			else
				pstmt.setString(65, getDeleteFlag());
			if (getInterest() == null || getInterest().equals("null"))
				pstmt.setNull(66, 12);
			else
				pstmt.setString(66, getInterest());
			if (getCustomeType() == null || getCustomeType().equals("null"))
				pstmt.setNull(67, 12);
			else
				pstmt.setString(67, getCustomeType());
			if (getIntroducer() == null || getIntroducer().equals("null"))
				pstmt.setNull(68, 12);
			else
				pstmt.setString(68, getIntroducer());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(69, 12);
			else
				pstmt.setString(69, getOperator());
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(71, 12);
			else
				pstmt.setString(71, getMakeTime());
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(73, 12);
			else
				pstmt.setString(73, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewClientDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MNewClient WHERE  CustomerNo = ?", 1003, 1007);
		if (getCustomerNo() == null || getCustomerNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getCustomerNo());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "MNewClientDB";
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
				tError.moduleName = "MNewClientDB";
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

	public MNewClientSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MNewClientSet aMNewClientSet = new MNewClientSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MNewClient");
			MNewClientSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MNewClientSchema s1;
			for (; rs.next(); aMNewClientSet.add(s1))
			{
				i++;
				s1 = new MNewClientSchema();
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
			tError.moduleName = "MNewClientDB";
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
		return aMNewClientSet;
	}

	public MNewClientSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MNewClientSet aMNewClientSet = new MNewClientSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MNewClientSchema s1;
			for (; rs.next(); aMNewClientSet.add(s1))
			{
				i++;
				s1 = new MNewClientSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MNewClientDB";
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
			tError.moduleName = "MNewClientDB";
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
		return aMNewClientSet;
	}

	public MNewClientSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MNewClientSet aMNewClientSet = new MNewClientSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MNewClient");
			MNewClientSchema aSchema = getSchema();
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
				MNewClientSchema s1 = new MNewClientSchema();
				s1.setSchema(rs, i);
				aMNewClientSet.add(s1);
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
			tError.moduleName = "MNewClientDB";
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
		return aMNewClientSet;
	}

	public MNewClientSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MNewClientSet aMNewClientSet = new MNewClientSet();
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
				MNewClientSchema s1 = new MNewClientSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MNewClientDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMNewClientSet.add(s1);
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
			tError.moduleName = "MNewClientDB";
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
		return aMNewClientSet;
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
				SQLString sqlObj = new SQLString("MNewClient");
				MNewClientSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MNewClient ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MNewClientDB";
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
				tError.moduleName = "MNewClientDB";
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
			tError.moduleName = "MNewClientDB";
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
			tError.moduleName = "MNewClientDB";
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
			tError.moduleName = "MNewClientDB";
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
			tError.moduleName = "MNewClientDB";
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

	public MNewClientSet getData()
	{
		int tCount = 0;
		MNewClientSet tMNewClientSet = new MNewClientSet();
		MNewClientSchema tMNewClientSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MNewClientDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMNewClientSchema = new MNewClientSchema();
			tMNewClientSchema.setSchema(mResultSet, 1);
			tMNewClientSet.add(tMNewClientSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMNewClientSchema = new MNewClientSchema();
					tMNewClientSchema.setSchema(mResultSet, 1);
					tMNewClientSet.add(tMNewClientSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MNewClientDB";
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
		return tMNewClientSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MNewClientDB";
				tError.functionName = "closeData";
				tError.errorMessage = "数据集已经关闭了！";
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
			tError.moduleName = "MNewClientDB";
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
				tError.moduleName = "MNewClientDB";
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
			tError.moduleName = "MNewClientDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
