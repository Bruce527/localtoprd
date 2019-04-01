// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPersonDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPPersonDB extends LNPPersonSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPPersonDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPPerson");
		mflag = true;
	}

	public LNPPersonDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPPerson");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPPersonSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPPersonDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPPersonSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPPersonDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPPerson WHERE  CustomerId = ? AND AgentCode = ?");
			if (getCustomerId() == null || getCustomerId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getCustomerId());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getAgentCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPPersonDB";
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
			pstmt = con.prepareStatement("UPDATE LNPPerson SET  CustomerId = ? , AgentCode = ? , CustomerNo = ? , Appellation = ? , Name = ? , Sex = ? , Birthday = ? , Age = ? , AgeType = ? , AppntType = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , Password = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , OthIDType = ? , OthIDNo = ? , ICNo = ? , GrpNo = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , PartOccupationType = ? , PartOccupationCode = ? , WorkType = ? , PluralityType = ? , DeathDate = ? , SmokeFlag = ? , BlacklistFlag = ? , Proterty = ? , Remark = ? , State = ? , VIPValue = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , GrpName = ? WHERE  CustomerId = ? AND AgentCode = ?");
			if (getCustomerId() == null || getCustomerId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getCustomerId());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getAgentCode());
			if (getCustomerNo() == null || getCustomerNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getCustomerNo());
			if (getAppellation() == null || getAppellation().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getAppellation());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getName());
			if (getSex() == null || getSex().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getSex());
			if (getBirthday() == null || getBirthday().equals("null"))
				pstmt.setNull(7, 91);
			else
				pstmt.setDate(7, Date.valueOf(getBirthday()));
			pstmt.setInt(8, getAge());
			if (getAgeType() == null || getAgeType().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getAgeType());
			if (getAppntType() == null || getAppntType().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getAppntType());
			if (getIDType() == null || getIDType().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getIDType());
			if (getIDNo() == null || getIDNo().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getIDNo());
			if (getIDValidity() == null || getIDValidity().equals("null"))
				pstmt.setNull(13, 91);
			else
				pstmt.setDate(13, Date.valueOf(getIDValidity()));
			if (getIDPerpetual() == null || getIDPerpetual().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getIDPerpetual());
			if (getPassword() == null || getPassword().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getPassword());
			if (getNativePlace() == null || getNativePlace().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getNativePlace());
			if (getNationality() == null || getNationality().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getNationality());
			if (getRgtAddress() == null || getRgtAddress().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getRgtAddress());
			if (getMarriage() == null || getMarriage().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getMarriage());
			if (getMarriageDate() == null || getMarriageDate().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getMarriageDate()));
			if (getHealth() == null || getHealth().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getHealth());
			pstmt.setDouble(22, getStature());
			pstmt.setDouble(23, getAvoirdupois());
			if (getDegree() == null || getDegree().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getDegree());
			if (getCreditGrade() == null || getCreditGrade().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getCreditGrade());
			if (getBankCode() == null || getBankCode().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getBankCode());
			if (getBankAccNo() == null || getBankAccNo().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getBankAccNo());
			if (getAccName() == null || getAccName().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getAccName());
			if (getOthIDType() == null || getOthIDType().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getOthIDType());
			if (getOthIDNo() == null || getOthIDNo().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getOthIDNo());
			if (getICNo() == null || getICNo().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getICNo());
			if (getGrpNo() == null || getGrpNo().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getGrpNo());
			if (getJoinCompanyDate() == null || getJoinCompanyDate().equals("null"))
				pstmt.setNull(33, 91);
			else
				pstmt.setDate(33, Date.valueOf(getJoinCompanyDate()));
			if (getStartWorkDate() == null || getStartWorkDate().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getStartWorkDate()));
			if (getPosition() == null || getPosition().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getPosition());
			pstmt.setDouble(36, getSalary());
			if (getOccupationType() == null || getOccupationType().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getOccupationType());
			if (getOccupationCode() == null || getOccupationCode().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getOccupationCode());
			if (getPartOccupationType() == null || getPartOccupationType().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getPartOccupationType());
			if (getPartOccupationCode() == null || getPartOccupationCode().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getPartOccupationCode());
			if (getWorkType() == null || getWorkType().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getWorkType());
			if (getPluralityType() == null || getPluralityType().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getPluralityType());
			if (getDeathDate() == null || getDeathDate().equals("null"))
				pstmt.setNull(43, 91);
			else
				pstmt.setDate(43, Date.valueOf(getDeathDate()));
			if (getSmokeFlag() == null || getSmokeFlag().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getSmokeFlag());
			if (getBlacklistFlag() == null || getBlacklistFlag().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getBlacklistFlag());
			if (getProterty() == null || getProterty().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getProterty());
			if (getRemark() == null || getRemark().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getRemark());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getState());
			if (getVIPValue() == null || getVIPValue().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getVIPValue());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(52, 91);
			else
				pstmt.setDate(52, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(54, 91);
			else
				pstmt.setDate(54, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(55, 12);
			else
				pstmt.setString(55, getModifyTime());
			if (getGrpName() == null || getGrpName().equals("null"))
				pstmt.setNull(56, 12);
			else
				pstmt.setString(56, getGrpName());
			if (getCustomerId() == null || getCustomerId().equals("null"))
				pstmt.setNull(57, 12);
			else
				pstmt.setString(57, getCustomerId());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(58, 12);
			else
				pstmt.setString(58, getAgentCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPPersonDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPPerson VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getCustomerId() == null || getCustomerId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getCustomerId());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getAgentCode());
			if (getCustomerNo() == null || getCustomerNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getCustomerNo());
			if (getAppellation() == null || getAppellation().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getAppellation());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getName());
			if (getSex() == null || getSex().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getSex());
			if (getBirthday() == null || getBirthday().equals("null"))
				pstmt.setNull(7, 91);
			else
				pstmt.setDate(7, Date.valueOf(getBirthday()));
			pstmt.setInt(8, getAge());
			if (getAgeType() == null || getAgeType().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getAgeType());
			if (getAppntType() == null || getAppntType().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getAppntType());
			if (getIDType() == null || getIDType().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getIDType());
			if (getIDNo() == null || getIDNo().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getIDNo());
			if (getIDValidity() == null || getIDValidity().equals("null"))
				pstmt.setNull(13, 91);
			else
				pstmt.setDate(13, Date.valueOf(getIDValidity()));
			if (getIDPerpetual() == null || getIDPerpetual().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getIDPerpetual());
			if (getPassword() == null || getPassword().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getPassword());
			if (getNativePlace() == null || getNativePlace().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getNativePlace());
			if (getNationality() == null || getNationality().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getNationality());
			if (getRgtAddress() == null || getRgtAddress().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getRgtAddress());
			if (getMarriage() == null || getMarriage().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getMarriage());
			if (getMarriageDate() == null || getMarriageDate().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getMarriageDate()));
			if (getHealth() == null || getHealth().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getHealth());
			pstmt.setDouble(22, getStature());
			pstmt.setDouble(23, getAvoirdupois());
			if (getDegree() == null || getDegree().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getDegree());
			if (getCreditGrade() == null || getCreditGrade().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getCreditGrade());
			if (getBankCode() == null || getBankCode().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getBankCode());
			if (getBankAccNo() == null || getBankAccNo().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getBankAccNo());
			if (getAccName() == null || getAccName().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getAccName());
			if (getOthIDType() == null || getOthIDType().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getOthIDType());
			if (getOthIDNo() == null || getOthIDNo().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getOthIDNo());
			if (getICNo() == null || getICNo().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getICNo());
			if (getGrpNo() == null || getGrpNo().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getGrpNo());
			if (getJoinCompanyDate() == null || getJoinCompanyDate().equals("null"))
				pstmt.setNull(33, 91);
			else
				pstmt.setDate(33, Date.valueOf(getJoinCompanyDate()));
			if (getStartWorkDate() == null || getStartWorkDate().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getStartWorkDate()));
			if (getPosition() == null || getPosition().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getPosition());
			pstmt.setDouble(36, getSalary());
			if (getOccupationType() == null || getOccupationType().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getOccupationType());
			if (getOccupationCode() == null || getOccupationCode().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getOccupationCode());
			if (getPartOccupationType() == null || getPartOccupationType().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getPartOccupationType());
			if (getPartOccupationCode() == null || getPartOccupationCode().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getPartOccupationCode());
			if (getWorkType() == null || getWorkType().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getWorkType());
			if (getPluralityType() == null || getPluralityType().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getPluralityType());
			if (getDeathDate() == null || getDeathDate().equals("null"))
				pstmt.setNull(43, 91);
			else
				pstmt.setDate(43, Date.valueOf(getDeathDate()));
			if (getSmokeFlag() == null || getSmokeFlag().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getSmokeFlag());
			if (getBlacklistFlag() == null || getBlacklistFlag().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getBlacklistFlag());
			if (getProterty() == null || getProterty().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getProterty());
			if (getRemark() == null || getRemark().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getRemark());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getState());
			if (getVIPValue() == null || getVIPValue().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getVIPValue());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(52, 91);
			else
				pstmt.setDate(52, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(54, 91);
			else
				pstmt.setDate(54, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(55, 12);
			else
				pstmt.setString(55, getModifyTime());
			if (getGrpName() == null || getGrpName().equals("null"))
				pstmt.setNull(56, 12);
			else
				pstmt.setString(56, getGrpName());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPPersonDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPPerson WHERE  CustomerId = ? AND AgentCode = ?", 1003, 1007);
		if (getCustomerId() == null || getCustomerId().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getCustomerId());
		if (getAgentCode() == null || getAgentCode().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getAgentCode());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_237;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_237;
		CError tError = new CError();
		tError.moduleName = "LNPPersonDB";
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
				tError.moduleName = "LNPPersonDB";
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

	public LNPPersonSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPPersonSet aLNPPersonSet = new LNPPersonSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPPerson");
			LNPPersonSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPPersonSchema s1;
			for (; rs.next(); aLNPPersonSet.add(s1))
			{
				i++;
				s1 = new LNPPersonSchema();
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
			tError.moduleName = "LNPPersonDB";
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
		return aLNPPersonSet;
	}

	public LNPPersonSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPPersonSet aLNPPersonSet = new LNPPersonSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPPersonSchema s1;
			for (; rs.next(); aLNPPersonSet.add(s1))
			{
				i++;
				s1 = new LNPPersonSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPPersonDB";
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
			tError.moduleName = "LNPPersonDB";
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
		return aLNPPersonSet;
	}

	public LNPPersonSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPPersonSet aLNPPersonSet = new LNPPersonSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPPerson");
			LNPPersonSchema aSchema = getSchema();
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
				LNPPersonSchema s1 = new LNPPersonSchema();
				s1.setSchema(rs, i);
				aLNPPersonSet.add(s1);
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
			tError.moduleName = "LNPPersonDB";
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
		return aLNPPersonSet;
	}

	public LNPPersonSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPPersonSet aLNPPersonSet = new LNPPersonSet();
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
				LNPPersonSchema s1 = new LNPPersonSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPPersonDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPPersonSet.add(s1);
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
			tError.moduleName = "LNPPersonDB";
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
		return aLNPPersonSet;
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
				SQLString sqlObj = new SQLString("LNPPerson");
				LNPPersonSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPPerson ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPPersonDB";
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
				tError.moduleName = "LNPPersonDB";
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
			tError.moduleName = "LNPPersonDB";
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
			tError.moduleName = "LNPPersonDB";
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
			tError.moduleName = "LNPPersonDB";
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
			tError.moduleName = "LNPPersonDB";
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

	public LNPPersonSet getData()
	{
		int tCount = 0;
		LNPPersonSet tLNPPersonSet = new LNPPersonSet();
		LNPPersonSchema tLNPPersonSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPersonDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPPersonSchema = new LNPPersonSchema();
			tLNPPersonSchema.setSchema(mResultSet, 1);
			tLNPPersonSet.add(tLNPPersonSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPPersonSchema = new LNPPersonSchema();
					tLNPPersonSchema.setSchema(mResultSet, 1);
					tLNPPersonSet.add(tLNPPersonSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPersonDB";
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
		return tLNPPersonSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPPersonDB";
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
			tError.moduleName = "LNPPersonDB";
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
				tError.moduleName = "LNPPersonDB";
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
			tError.moduleName = "LNPPersonDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
