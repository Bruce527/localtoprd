// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPersonDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPPersonDBSet extends LNPPersonSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPPersonDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPPerson");
		mflag = true;
	}

	public LNPPersonDBSet()
	{
		mflag = false;
		db = new DBOper("LNPPerson");
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
			tError.moduleName = "LNPPersonDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPPerson WHERE  CustomerId = ? AND AgentCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerId());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
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
			tError.moduleName = "LNPPersonDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPPerson SET  CustomerId = ? , AgentCode = ? , CustomerNo = ? , Appellation = ? , Name = ? , Sex = ? , Birthday = ? , Age = ? , AgeType = ? , AppntType = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , Password = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , OthIDType = ? , OthIDNo = ? , ICNo = ? , GrpNo = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , PartOccupationType = ? , PartOccupationCode = ? , WorkType = ? , PluralityType = ? , DeathDate = ? , SmokeFlag = ? , BlacklistFlag = ? , Proterty = ? , Remark = ? , State = ? , VIPValue = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , GrpName = ? WHERE  CustomerId = ? AND AgentCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerId());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCustomerNo());
				if (get(i).getAppellation() == null || get(i).getAppellation().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAppellation());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getName());
				if (get(i).getSex() == null || get(i).getSex().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getSex());
				if (get(i).getBirthday() == null || get(i).getBirthday().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getBirthday()));
				pstmt.setInt(8, get(i).getAge());
				if (get(i).getAgeType() == null || get(i).getAgeType().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getAgeType());
				if (get(i).getAppntType() == null || get(i).getAppntType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getAppntType());
				if (get(i).getIDType() == null || get(i).getIDType().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getIDType());
				if (get(i).getIDNo() == null || get(i).getIDNo().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getIDNo());
				if (get(i).getIDValidity() == null || get(i).getIDValidity().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getIDValidity()));
				if (get(i).getIDPerpetual() == null || get(i).getIDPerpetual().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getIDPerpetual());
				if (get(i).getPassword() == null || get(i).getPassword().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getPassword());
				if (get(i).getNativePlace() == null || get(i).getNativePlace().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getNativePlace());
				if (get(i).getNationality() == null || get(i).getNationality().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getNationality());
				if (get(i).getRgtAddress() == null || get(i).getRgtAddress().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getRgtAddress());
				if (get(i).getMarriage() == null || get(i).getMarriage().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getMarriage());
				if (get(i).getMarriageDate() == null || get(i).getMarriageDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getMarriageDate()));
				if (get(i).getHealth() == null || get(i).getHealth().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getHealth());
				pstmt.setDouble(22, get(i).getStature());
				pstmt.setDouble(23, get(i).getAvoirdupois());
				if (get(i).getDegree() == null || get(i).getDegree().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getDegree());
				if (get(i).getCreditGrade() == null || get(i).getCreditGrade().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getCreditGrade());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getBankAccNo());
				if (get(i).getAccName() == null || get(i).getAccName().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getAccName());
				if (get(i).getOthIDType() == null || get(i).getOthIDType().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getOthIDType());
				if (get(i).getOthIDNo() == null || get(i).getOthIDNo().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getOthIDNo());
				if (get(i).getICNo() == null || get(i).getICNo().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getICNo());
				if (get(i).getGrpNo() == null || get(i).getGrpNo().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getGrpNo());
				if (get(i).getJoinCompanyDate() == null || get(i).getJoinCompanyDate().equals("null"))
					pstmt.setDate(33, null);
				else
					pstmt.setDate(33, Date.valueOf(get(i).getJoinCompanyDate()));
				if (get(i).getStartWorkDate() == null || get(i).getStartWorkDate().equals("null"))
					pstmt.setDate(34, null);
				else
					pstmt.setDate(34, Date.valueOf(get(i).getStartWorkDate()));
				if (get(i).getPosition() == null || get(i).getPosition().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getPosition());
				pstmt.setDouble(36, get(i).getSalary());
				if (get(i).getOccupationType() == null || get(i).getOccupationType().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getOccupationType());
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getOccupationCode());
				if (get(i).getPartOccupationType() == null || get(i).getPartOccupationType().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getPartOccupationType());
				if (get(i).getPartOccupationCode() == null || get(i).getPartOccupationCode().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getPartOccupationCode());
				if (get(i).getWorkType() == null || get(i).getWorkType().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getWorkType());
				if (get(i).getPluralityType() == null || get(i).getPluralityType().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getPluralityType());
				if (get(i).getDeathDate() == null || get(i).getDeathDate().equals("null"))
					pstmt.setDate(43, null);
				else
					pstmt.setDate(43, Date.valueOf(get(i).getDeathDate()));
				if (get(i).getSmokeFlag() == null || get(i).getSmokeFlag().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getSmokeFlag());
				if (get(i).getBlacklistFlag() == null || get(i).getBlacklistFlag().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getBlacklistFlag());
				if (get(i).getProterty() == null || get(i).getProterty().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getProterty());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getRemark());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getState());
				if (get(i).getVIPValue() == null || get(i).getVIPValue().equals("null"))
					pstmt.setString(49, null);
				else
					pstmt.setString(49, get(i).getVIPValue());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(50, null);
				else
					pstmt.setString(50, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(51, null);
				else
					pstmt.setString(51, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(52, null);
				else
					pstmt.setDate(52, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(54, null);
				else
					pstmt.setDate(54, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(55, null);
				else
					pstmt.setString(55, get(i).getModifyTime());
				if (get(i).getGrpName() == null || get(i).getGrpName().equals("null"))
					pstmt.setString(56, null);
				else
					pstmt.setString(56, get(i).getGrpName());
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(57, null);
				else
					pstmt.setString(57, get(i).getCustomerId());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(58, null);
				else
					pstmt.setString(58, get(i).getAgentCode());
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
			tError.moduleName = "LNPPersonDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPPerson VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerId());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCustomerNo());
				if (get(i).getAppellation() == null || get(i).getAppellation().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAppellation());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getName());
				if (get(i).getSex() == null || get(i).getSex().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getSex());
				if (get(i).getBirthday() == null || get(i).getBirthday().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getBirthday()));
				pstmt.setInt(8, get(i).getAge());
				if (get(i).getAgeType() == null || get(i).getAgeType().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getAgeType());
				if (get(i).getAppntType() == null || get(i).getAppntType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getAppntType());
				if (get(i).getIDType() == null || get(i).getIDType().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getIDType());
				if (get(i).getIDNo() == null || get(i).getIDNo().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getIDNo());
				if (get(i).getIDValidity() == null || get(i).getIDValidity().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getIDValidity()));
				if (get(i).getIDPerpetual() == null || get(i).getIDPerpetual().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getIDPerpetual());
				if (get(i).getPassword() == null || get(i).getPassword().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getPassword());
				if (get(i).getNativePlace() == null || get(i).getNativePlace().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getNativePlace());
				if (get(i).getNationality() == null || get(i).getNationality().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getNationality());
				if (get(i).getRgtAddress() == null || get(i).getRgtAddress().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getRgtAddress());
				if (get(i).getMarriage() == null || get(i).getMarriage().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getMarriage());
				if (get(i).getMarriageDate() == null || get(i).getMarriageDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getMarriageDate()));
				if (get(i).getHealth() == null || get(i).getHealth().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getHealth());
				pstmt.setDouble(22, get(i).getStature());
				pstmt.setDouble(23, get(i).getAvoirdupois());
				if (get(i).getDegree() == null || get(i).getDegree().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getDegree());
				if (get(i).getCreditGrade() == null || get(i).getCreditGrade().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getCreditGrade());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getBankAccNo());
				if (get(i).getAccName() == null || get(i).getAccName().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getAccName());
				if (get(i).getOthIDType() == null || get(i).getOthIDType().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getOthIDType());
				if (get(i).getOthIDNo() == null || get(i).getOthIDNo().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getOthIDNo());
				if (get(i).getICNo() == null || get(i).getICNo().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getICNo());
				if (get(i).getGrpNo() == null || get(i).getGrpNo().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getGrpNo());
				if (get(i).getJoinCompanyDate() == null || get(i).getJoinCompanyDate().equals("null"))
					pstmt.setDate(33, null);
				else
					pstmt.setDate(33, Date.valueOf(get(i).getJoinCompanyDate()));
				if (get(i).getStartWorkDate() == null || get(i).getStartWorkDate().equals("null"))
					pstmt.setDate(34, null);
				else
					pstmt.setDate(34, Date.valueOf(get(i).getStartWorkDate()));
				if (get(i).getPosition() == null || get(i).getPosition().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getPosition());
				pstmt.setDouble(36, get(i).getSalary());
				if (get(i).getOccupationType() == null || get(i).getOccupationType().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getOccupationType());
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getOccupationCode());
				if (get(i).getPartOccupationType() == null || get(i).getPartOccupationType().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getPartOccupationType());
				if (get(i).getPartOccupationCode() == null || get(i).getPartOccupationCode().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getPartOccupationCode());
				if (get(i).getWorkType() == null || get(i).getWorkType().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getWorkType());
				if (get(i).getPluralityType() == null || get(i).getPluralityType().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getPluralityType());
				if (get(i).getDeathDate() == null || get(i).getDeathDate().equals("null"))
					pstmt.setDate(43, null);
				else
					pstmt.setDate(43, Date.valueOf(get(i).getDeathDate()));
				if (get(i).getSmokeFlag() == null || get(i).getSmokeFlag().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getSmokeFlag());
				if (get(i).getBlacklistFlag() == null || get(i).getBlacklistFlag().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getBlacklistFlag());
				if (get(i).getProterty() == null || get(i).getProterty().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getProterty());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getRemark());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getState());
				if (get(i).getVIPValue() == null || get(i).getVIPValue().equals("null"))
					pstmt.setString(49, null);
				else
					pstmt.setString(49, get(i).getVIPValue());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(50, null);
				else
					pstmt.setString(50, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(51, null);
				else
					pstmt.setString(51, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(52, null);
				else
					pstmt.setDate(52, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(54, null);
				else
					pstmt.setDate(54, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(55, null);
				else
					pstmt.setString(55, get(i).getModifyTime());
				if (get(i).getGrpName() == null || get(i).getGrpName().equals("null"))
					pstmt.setString(56, null);
				else
					pstmt.setString(56, get(i).getGrpName());
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
			tError.moduleName = "LNPPersonDBSet";
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
