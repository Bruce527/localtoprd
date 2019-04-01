// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAppntDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPAppntDBSet extends LNPAppntSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPAppntDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPAppnt");
		mflag = true;
	}

	public LNPAppntDBSet()
	{
		mflag = false;
		db = new DBOper("LNPAppnt");
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
			tError.moduleName = "LNPAppntDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
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
			pstmt = con.prepareStatement("DELETE FROM LNPAppnt WHERE  ContNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContNo());
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
			tError.moduleName = "LNPAppntDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPAppnt SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , AppntNo = ? , AppntId = ? , RelationToInsured = ? , AppntGrade = ? , Appellation = ? , AppntName = ? , AppntSex = ? , AppntBirthday = ? , AppntAge = ? , AppntAgeType = ? , AppntType = ? , AddressNo = ? , SequenceNo = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , WorkType = ? , PluralityType = ? , SmokeFlag = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getProposalContNo());
				if (get(i).getPrtNo() == null || get(i).getPrtNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPrtNo());
				if (get(i).getAppntNo() == null || get(i).getAppntNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAppntNo());
				if (get(i).getAppntId() == null || get(i).getAppntId().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAppntId());
				if (get(i).getRelationToInsured() == null || get(i).getRelationToInsured().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRelationToInsured());
				if (get(i).getAppntGrade() == null || get(i).getAppntGrade().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAppntGrade());
				if (get(i).getAppellation() == null || get(i).getAppellation().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getAppellation());
				if (get(i).getAppntName() == null || get(i).getAppntName().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getAppntName());
				if (get(i).getAppntSex() == null || get(i).getAppntSex().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getAppntSex());
				if (get(i).getAppntBirthday() == null || get(i).getAppntBirthday().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getAppntBirthday()));
				pstmt.setInt(13, get(i).getAppntAge());
				if (get(i).getAppntAgeType() == null || get(i).getAppntAgeType().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getAppntAgeType());
				if (get(i).getAppntType() == null || get(i).getAppntType().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getAppntType());
				if (get(i).getAddressNo() == null || get(i).getAddressNo().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAddressNo());
				if (get(i).getSequenceNo() == null || get(i).getSequenceNo().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getSequenceNo());
				if (get(i).getIDType() == null || get(i).getIDType().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getIDType());
				if (get(i).getIDNo() == null || get(i).getIDNo().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getIDNo());
				if (get(i).getIDValidity() == null || get(i).getIDValidity().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getIDValidity()));
				if (get(i).getIDPerpetual() == null || get(i).getIDPerpetual().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getIDPerpetual());
				if (get(i).getNativePlace() == null || get(i).getNativePlace().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getNativePlace());
				if (get(i).getNationality() == null || get(i).getNationality().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getNationality());
				if (get(i).getRgtAddress() == null || get(i).getRgtAddress().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getRgtAddress());
				if (get(i).getMarriage() == null || get(i).getMarriage().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getMarriage());
				if (get(i).getMarriageDate() == null || get(i).getMarriageDate().equals("null"))
					pstmt.setDate(26, null);
				else
					pstmt.setDate(26, Date.valueOf(get(i).getMarriageDate()));
				if (get(i).getHealth() == null || get(i).getHealth().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getHealth());
				pstmt.setDouble(28, get(i).getStature());
				pstmt.setDouble(29, get(i).getAvoirdupois());
				if (get(i).getDegree() == null || get(i).getDegree().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getDegree());
				if (get(i).getCreditGrade() == null || get(i).getCreditGrade().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getCreditGrade());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getBankAccNo());
				if (get(i).getAccName() == null || get(i).getAccName().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getAccName());
				if (get(i).getJoinCompanyDate() == null || get(i).getJoinCompanyDate().equals("null"))
					pstmt.setDate(35, null);
				else
					pstmt.setDate(35, Date.valueOf(get(i).getJoinCompanyDate()));
				if (get(i).getStartWorkDate() == null || get(i).getStartWorkDate().equals("null"))
					pstmt.setDate(36, null);
				else
					pstmt.setDate(36, Date.valueOf(get(i).getStartWorkDate()));
				if (get(i).getPosition() == null || get(i).getPosition().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getPosition());
				pstmt.setDouble(38, get(i).getSalary());
				if (get(i).getOccupationType() == null || get(i).getOccupationType().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getOccupationType());
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getOccupationCode());
				if (get(i).getWorkType() == null || get(i).getWorkType().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getWorkType());
				if (get(i).getPluralityType() == null || get(i).getPluralityType().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getPluralityType());
				if (get(i).getSmokeFlag() == null || get(i).getSmokeFlag().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getSmokeFlag());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(46, null);
				else
					pstmt.setDate(46, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(48, null);
				else
					pstmt.setDate(48, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(49, null);
				else
					pstmt.setString(49, get(i).getModifyTime());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(50, null);
				else
					pstmt.setString(50, get(i).getContNo());
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
			tError.moduleName = "LNPAppntDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPAppnt VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getProposalContNo());
				if (get(i).getPrtNo() == null || get(i).getPrtNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPrtNo());
				if (get(i).getAppntNo() == null || get(i).getAppntNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAppntNo());
				if (get(i).getAppntId() == null || get(i).getAppntId().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAppntId());
				if (get(i).getRelationToInsured() == null || get(i).getRelationToInsured().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRelationToInsured());
				if (get(i).getAppntGrade() == null || get(i).getAppntGrade().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAppntGrade());
				if (get(i).getAppellation() == null || get(i).getAppellation().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getAppellation());
				if (get(i).getAppntName() == null || get(i).getAppntName().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getAppntName());
				if (get(i).getAppntSex() == null || get(i).getAppntSex().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getAppntSex());
				if (get(i).getAppntBirthday() == null || get(i).getAppntBirthday().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getAppntBirthday()));
				pstmt.setInt(13, get(i).getAppntAge());
				if (get(i).getAppntAgeType() == null || get(i).getAppntAgeType().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getAppntAgeType());
				if (get(i).getAppntType() == null || get(i).getAppntType().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getAppntType());
				if (get(i).getAddressNo() == null || get(i).getAddressNo().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAddressNo());
				if (get(i).getSequenceNo() == null || get(i).getSequenceNo().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getSequenceNo());
				if (get(i).getIDType() == null || get(i).getIDType().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getIDType());
				if (get(i).getIDNo() == null || get(i).getIDNo().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getIDNo());
				if (get(i).getIDValidity() == null || get(i).getIDValidity().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getIDValidity()));
				if (get(i).getIDPerpetual() == null || get(i).getIDPerpetual().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getIDPerpetual());
				if (get(i).getNativePlace() == null || get(i).getNativePlace().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getNativePlace());
				if (get(i).getNationality() == null || get(i).getNationality().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getNationality());
				if (get(i).getRgtAddress() == null || get(i).getRgtAddress().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getRgtAddress());
				if (get(i).getMarriage() == null || get(i).getMarriage().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getMarriage());
				if (get(i).getMarriageDate() == null || get(i).getMarriageDate().equals("null"))
					pstmt.setDate(26, null);
				else
					pstmt.setDate(26, Date.valueOf(get(i).getMarriageDate()));
				if (get(i).getHealth() == null || get(i).getHealth().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getHealth());
				pstmt.setDouble(28, get(i).getStature());
				pstmt.setDouble(29, get(i).getAvoirdupois());
				if (get(i).getDegree() == null || get(i).getDegree().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getDegree());
				if (get(i).getCreditGrade() == null || get(i).getCreditGrade().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getCreditGrade());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getBankAccNo());
				if (get(i).getAccName() == null || get(i).getAccName().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getAccName());
				if (get(i).getJoinCompanyDate() == null || get(i).getJoinCompanyDate().equals("null"))
					pstmt.setDate(35, null);
				else
					pstmt.setDate(35, Date.valueOf(get(i).getJoinCompanyDate()));
				if (get(i).getStartWorkDate() == null || get(i).getStartWorkDate().equals("null"))
					pstmt.setDate(36, null);
				else
					pstmt.setDate(36, Date.valueOf(get(i).getStartWorkDate()));
				if (get(i).getPosition() == null || get(i).getPosition().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getPosition());
				pstmt.setDouble(38, get(i).getSalary());
				if (get(i).getOccupationType() == null || get(i).getOccupationType().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getOccupationType());
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getOccupationCode());
				if (get(i).getWorkType() == null || get(i).getWorkType().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getWorkType());
				if (get(i).getPluralityType() == null || get(i).getPluralityType().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getPluralityType());
				if (get(i).getSmokeFlag() == null || get(i).getSmokeFlag().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getSmokeFlag());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(46, null);
				else
					pstmt.setDate(46, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(48, null);
				else
					pstmt.setDate(48, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(49, null);
				else
					pstmt.setString(49, get(i).getModifyTime());
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
			tError.moduleName = "LNPAppntDBSet";
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
