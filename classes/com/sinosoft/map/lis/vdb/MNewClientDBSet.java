// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MNewClientDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MNewClientSchema;
import com.sinosoft.map.lis.vschema.MNewClientSet;
import com.sinosoft.map.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MNewClientDBSet extends MNewClientSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MNewClientDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MNewClient");
		mflag = true;
	}

	public MNewClientDBSet()
	{
		mflag = false;
		db = new DBOper("MNewClient");
		con = db.getConnection();
	}

	public boolean deleteSQL()
	{
		if (db.deleteSQL(this))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewClientDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "²Ù×÷Ê§°Ü!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("DELETE FROM MNewClient WHERE  CustomerNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerNo());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewClientDBSet";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("UPDATE MNewClient SET  CustomerNo = ? , CustomerNo2 = ? , ClientName = ? , Gender = ? , Birthday = ? , EMail = ? , GrpZipCode = ? , GrpAddress = ? , GrpNo = ? , BP = ? , GrpAddressCode = ? , Phone2 = ? , GrpName = ? , GrpPhone = ? , Phone = ? , Mobile = ? , OccupationCode = ? , Position = ? , WorkType = ? , OccupationType = ? , HomeAddress = ? , HomeAddressCode = ? , RgtAddress = ? , PostalAddress = ? , ZipCode = ? , HomeZipCode = ? , SequenceNo = ? , Stature = ? , Avoirdupois = ? , SmokeFlag = ? , DeathDate = ? , Marriage = ? , CredentType = ? , CredentNO = ? , OthIDNo = ? , OthIDType = ? , ICNo = ? , Salary = ? , YearSalary = ? , NativePlace = ? , Nationality = ? , MarriageDate = ? , Degree = ? , PolNo = ? , RelationToInsured = ? , PluralityType = ? , StartWorkDate = ? , Health = ? , Password = ? , JoinCompanyDate = ? , AppntGrade = ? , CreditGrade = ? , ClientType = ? , State = ? , Agentcode = ? , SignDate = ? , AddrChoise = ? , CustomeProperty = ? , BirthdayFlag = ? , Appellation = ? , IDDNo = ? , ValidityDate = ? , CountryOrArea = ? , SpecialDate = ? , DeleteFlag = ? , Interest = ? , CustomeType = ? , Introducer = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CustomerNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerNo());
				if (get(i).getCustomerNo2() == null || get(i).getCustomerNo2().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerNo2());
				if (get(i).getClientName() == null || get(i).getClientName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getClientName());
				if (get(i).getGender() == null || get(i).getGender().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getGender());
				if (get(i).getEMail() == null || get(i).getEMail().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getEMail());
				if (get(i).getGrpZipCode() == null || get(i).getGrpZipCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getGrpZipCode());
				if (get(i).getGrpAddress() == null || get(i).getGrpAddress().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getGrpAddress());
				if (get(i).getGrpNo() == null || get(i).getGrpNo().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getGrpNo());
				if (get(i).getBP() == null || get(i).getBP().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getBP());
				if (get(i).getGrpAddressCode() == null || get(i).getGrpAddressCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getGrpAddressCode());
				if (get(i).getPhone2() == null || get(i).getPhone2().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getPhone2());
				if (get(i).getGrpName() == null || get(i).getGrpName().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getGrpName());
				if (get(i).getGrpPhone() == null || get(i).getGrpPhone().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getGrpPhone());
				if (get(i).getPhone() == null || get(i).getPhone().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getPhone());
				if (get(i).getMobile() == null || get(i).getMobile().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getMobile());
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getOccupationCode());
				if (get(i).getPosition() == null || get(i).getPosition().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getPosition());
				if (get(i).getWorkType() == null || get(i).getWorkType().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getWorkType());
				if (get(i).getOccupationType() == null || get(i).getOccupationType().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getOccupationType());
				if (get(i).getHomeAddress() == null || get(i).getHomeAddress().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getHomeAddress());
				if (get(i).getHomeAddressCode() == null || get(i).getHomeAddressCode().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getHomeAddressCode());
				if (get(i).getRgtAddress() == null || get(i).getRgtAddress().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getRgtAddress());
				if (get(i).getPostalAddress() == null || get(i).getPostalAddress().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getPostalAddress());
				if (get(i).getZipCode() == null || get(i).getZipCode().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getZipCode());
				if (get(i).getHomeZipCode() == null || get(i).getHomeZipCode().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getHomeZipCode());
				if (get(i).getSequenceNo() == null || get(i).getSequenceNo().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getSequenceNo());
				pstmt.setDouble(28, get(i).getStature());
				pstmt.setDouble(29, get(i).getAvoirdupois());
				if (get(i).getSmokeFlag() == null || get(i).getSmokeFlag().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getSmokeFlag());
				if (get(i).getMarriage() == null || get(i).getMarriage().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getMarriage());
				if (get(i).getCredentType() == null || get(i).getCredentType().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getCredentType());
				if (get(i).getCredentNO() == null || get(i).getCredentNO().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getCredentNO());
				if (get(i).getOthIDNo() == null || get(i).getOthIDNo().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getOthIDNo());
				if (get(i).getOthIDType() == null || get(i).getOthIDType().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getOthIDType());
				if (get(i).getICNo() == null || get(i).getICNo().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getICNo());
				if (get(i).getNativePlace() == null || get(i).getNativePlace().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getNativePlace());
				if (get(i).getNationality() == null || get(i).getNationality().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getNationality());
				if (get(i).getDegree() == null || get(i).getDegree().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getDegree());
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getPolNo());
				if (get(i).getRelationToInsured() == null || get(i).getRelationToInsured().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getRelationToInsured());
				if (get(i).getPluralityType() == null || get(i).getPluralityType().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getPluralityType());
				if (get(i).getHealth() == null || get(i).getHealth().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getHealth());
				if (get(i).getPassword() == null || get(i).getPassword().equals("null"))
					pstmt.setString(49, null);
				else
					pstmt.setString(49, get(i).getPassword());
				if (get(i).getAppntGrade() == null || get(i).getAppntGrade().equals("null"))
					pstmt.setString(51, null);
				else
					pstmt.setString(51, get(i).getAppntGrade());
				if (get(i).getCreditGrade() == null || get(i).getCreditGrade().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getCreditGrade());
				if (get(i).getClientType() == null || get(i).getClientType().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getClientType());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getState());
				if (get(i).getAgentcode() == null || get(i).getAgentcode().equals("null"))
					pstmt.setString(55, null);
				else
					pstmt.setString(55, get(i).getAgentcode());
				if (get(i).getAddrChoise() == null || get(i).getAddrChoise().equals("null"))
					pstmt.setString(57, null);
				else
					pstmt.setString(57, get(i).getAddrChoise());
				if (get(i).getCustomeProperty() == null || get(i).getCustomeProperty().equals("null"))
					pstmt.setString(58, null);
				else
					pstmt.setString(58, get(i).getCustomeProperty());
				if (get(i).getBirthdayFlag() == null || get(i).getBirthdayFlag().equals("null"))
					pstmt.setString(59, null);
				else
					pstmt.setString(59, get(i).getBirthdayFlag());
				if (get(i).getAppellation() == null || get(i).getAppellation().equals("null"))
					pstmt.setString(60, null);
				else
					pstmt.setString(60, get(i).getAppellation());
				if (get(i).getIDDNo() == null || get(i).getIDDNo().equals("null"))
					pstmt.setString(61, null);
				else
					pstmt.setString(61, get(i).getIDDNo());
				if (get(i).getCountryOrArea() == null || get(i).getCountryOrArea().equals("null"))
					pstmt.setString(63, null);
				else
					pstmt.setString(63, get(i).getCountryOrArea());
				if (get(i).getDeleteFlag() == null || get(i).getDeleteFlag().equals("null"))
					pstmt.setString(65, null);
				else
					pstmt.setString(65, get(i).getDeleteFlag());
				if (get(i).getInterest() == null || get(i).getInterest().equals("null"))
					pstmt.setString(66, null);
				else
					pstmt.setString(66, get(i).getInterest());
				if (get(i).getCustomeType() == null || get(i).getCustomeType().equals("null"))
					pstmt.setString(67, null);
				else
					pstmt.setString(67, get(i).getCustomeType());
				if (get(i).getIntroducer() == null || get(i).getIntroducer().equals("null"))
					pstmt.setString(68, null);
				else
					pstmt.setString(68, get(i).getIntroducer());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(69, null);
				else
					pstmt.setString(69, get(i).getOperator());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(71, null);
				else
					pstmt.setString(71, get(i).getMakeTime());
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(73, null);
				else
					pstmt.setString(73, get(i).getModifyTime());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(74, null);
				else
					pstmt.setString(74, get(i).getCustomerNo());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewClientDBSet";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("INSERT INTO MNewClient VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerNo());
				if (get(i).getCustomerNo2() == null || get(i).getCustomerNo2().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerNo2());
				if (get(i).getClientName() == null || get(i).getClientName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getClientName());
				if (get(i).getGender() == null || get(i).getGender().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getGender());
				if (get(i).getEMail() == null || get(i).getEMail().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getEMail());
				if (get(i).getGrpZipCode() == null || get(i).getGrpZipCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getGrpZipCode());
				if (get(i).getGrpAddress() == null || get(i).getGrpAddress().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getGrpAddress());
				if (get(i).getGrpNo() == null || get(i).getGrpNo().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getGrpNo());
				if (get(i).getBP() == null || get(i).getBP().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getBP());
				if (get(i).getGrpAddressCode() == null || get(i).getGrpAddressCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getGrpAddressCode());
				if (get(i).getPhone2() == null || get(i).getPhone2().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getPhone2());
				if (get(i).getGrpName() == null || get(i).getGrpName().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getGrpName());
				if (get(i).getGrpPhone() == null || get(i).getGrpPhone().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getGrpPhone());
				if (get(i).getPhone() == null || get(i).getPhone().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getPhone());
				if (get(i).getMobile() == null || get(i).getMobile().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getMobile());
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getOccupationCode());
				if (get(i).getPosition() == null || get(i).getPosition().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getPosition());
				if (get(i).getWorkType() == null || get(i).getWorkType().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getWorkType());
				if (get(i).getOccupationType() == null || get(i).getOccupationType().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getOccupationType());
				if (get(i).getHomeAddress() == null || get(i).getHomeAddress().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getHomeAddress());
				if (get(i).getHomeAddressCode() == null || get(i).getHomeAddressCode().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getHomeAddressCode());
				if (get(i).getRgtAddress() == null || get(i).getRgtAddress().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getRgtAddress());
				if (get(i).getPostalAddress() == null || get(i).getPostalAddress().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getPostalAddress());
				if (get(i).getZipCode() == null || get(i).getZipCode().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getZipCode());
				if (get(i).getHomeZipCode() == null || get(i).getHomeZipCode().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getHomeZipCode());
				if (get(i).getSequenceNo() == null || get(i).getSequenceNo().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getSequenceNo());
				pstmt.setDouble(28, get(i).getStature());
				pstmt.setDouble(29, get(i).getAvoirdupois());
				if (get(i).getSmokeFlag() == null || get(i).getSmokeFlag().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getSmokeFlag());
				if (get(i).getMarriage() == null || get(i).getMarriage().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getMarriage());
				if (get(i).getCredentType() == null || get(i).getCredentType().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getCredentType());
				if (get(i).getCredentNO() == null || get(i).getCredentNO().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getCredentNO());
				if (get(i).getOthIDNo() == null || get(i).getOthIDNo().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getOthIDNo());
				if (get(i).getOthIDType() == null || get(i).getOthIDType().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getOthIDType());
				if (get(i).getICNo() == null || get(i).getICNo().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getICNo());
				if (get(i).getNativePlace() == null || get(i).getNativePlace().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getNativePlace());
				if (get(i).getNationality() == null || get(i).getNationality().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getNationality());
				if (get(i).getDegree() == null || get(i).getDegree().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getDegree());
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getPolNo());
				if (get(i).getRelationToInsured() == null || get(i).getRelationToInsured().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getRelationToInsured());
				if (get(i).getPluralityType() == null || get(i).getPluralityType().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getPluralityType());
				if (get(i).getHealth() == null || get(i).getHealth().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getHealth());
				if (get(i).getPassword() == null || get(i).getPassword().equals("null"))
					pstmt.setString(49, null);
				else
					pstmt.setString(49, get(i).getPassword());
				if (get(i).getAppntGrade() == null || get(i).getAppntGrade().equals("null"))
					pstmt.setString(51, null);
				else
					pstmt.setString(51, get(i).getAppntGrade());
				if (get(i).getCreditGrade() == null || get(i).getCreditGrade().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getCreditGrade());
				if (get(i).getClientType() == null || get(i).getClientType().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getClientType());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getState());
				if (get(i).getAgentcode() == null || get(i).getAgentcode().equals("null"))
					pstmt.setString(55, null);
				else
					pstmt.setString(55, get(i).getAgentcode());
				if (get(i).getAddrChoise() == null || get(i).getAddrChoise().equals("null"))
					pstmt.setString(57, null);
				else
					pstmt.setString(57, get(i).getAddrChoise());
				if (get(i).getCustomeProperty() == null || get(i).getCustomeProperty().equals("null"))
					pstmt.setString(58, null);
				else
					pstmt.setString(58, get(i).getCustomeProperty());
				if (get(i).getBirthdayFlag() == null || get(i).getBirthdayFlag().equals("null"))
					pstmt.setString(59, null);
				else
					pstmt.setString(59, get(i).getBirthdayFlag());
				if (get(i).getAppellation() == null || get(i).getAppellation().equals("null"))
					pstmt.setString(60, null);
				else
					pstmt.setString(60, get(i).getAppellation());
				if (get(i).getIDDNo() == null || get(i).getIDDNo().equals("null"))
					pstmt.setString(61, null);
				else
					pstmt.setString(61, get(i).getIDDNo());
				if (get(i).getCountryOrArea() == null || get(i).getCountryOrArea().equals("null"))
					pstmt.setString(63, null);
				else
					pstmt.setString(63, get(i).getCountryOrArea());
				if (get(i).getDeleteFlag() == null || get(i).getDeleteFlag().equals("null"))
					pstmt.setString(65, null);
				else
					pstmt.setString(65, get(i).getDeleteFlag());
				if (get(i).getInterest() == null || get(i).getInterest().equals("null"))
					pstmt.setString(66, null);
				else
					pstmt.setString(66, get(i).getInterest());
				if (get(i).getCustomeType() == null || get(i).getCustomeType().equals("null"))
					pstmt.setString(67, null);
				else
					pstmt.setString(67, get(i).getCustomeType());
				if (get(i).getIntroducer() == null || get(i).getIntroducer().equals("null"))
					pstmt.setString(68, null);
				else
					pstmt.setString(68, get(i).getIntroducer());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(69, null);
				else
					pstmt.setString(69, get(i).getOperator());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(71, null);
				else
					pstmt.setString(71, get(i).getMakeTime());
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(73, null);
				else
					pstmt.setString(73, get(i).getModifyTime());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewClientDBSet";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}
}
