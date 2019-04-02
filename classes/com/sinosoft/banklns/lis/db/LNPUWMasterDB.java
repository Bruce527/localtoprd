// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPUWMasterDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPUWMasterSchema;
import com.sinosoft.banklns.lis.vschema.LNPUWMasterSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPUWMasterDB extends LNPUWMasterSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPUWMasterDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPUWMaster");
		mflag = true;
	}

	public LNPUWMasterDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPUWMaster");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPUWMasterSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPUWMasterDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPUWMasterSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPUWMasterDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPUWMaster WHERE  PolNo = ?");
			if (getPolNo() == null || getPolNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getPolNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPUWMasterDB";
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
			pstmt = con.prepareStatement("UPDATE LNPUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PolNo = ? , ProposalNo = ? , UWNo = ? , InsuredNo = ? , InsuredName = ? , AppntNo = ? , AppntName = ? , PlanCode = ? , PlanName = ? , RiderName = ? , RiderCode = ? , UWDid = ? , FaceAmount = ? , Term = ? , HealthDeb = ? , HealthFe = ? , HealthFed = ? , OccupationFactor = ? , OccupationFe = ? , OccupationFed = ? , Exclusions = ? , DeclinedCode = ? , DeclinedReason = ? , PassFlag = ? , UWIdea = ? , UWGrade = ? , AppGrade = ? , PostponeDay = ? , PostponeDate = ? , AutoUWFlag = ? , State = ? , ManageCom = ? , UpReportContent = ? , Operator = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , ReportFlag = ? , PrintFlag = ? , PrintFlag2 = ? , ChangePolFlag = ? , ChangePolReason = ? , SpecReason = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , SugPassFlag = ? , SugUWIdea = ? WHERE  PolNo = ?");
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
			if (getPolNo() == null || getPolNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPolNo());
			if (getProposalNo() == null || getProposalNo().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getProposalNo());
			pstmt.setInt(6, getUWNo());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getInsuredNo());
			if (getInsuredName() == null || getInsuredName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getInsuredName());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getAppntNo());
			if (getAppntName() == null || getAppntName().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getAppntName());
			if (getPlanCode() == null || getPlanCode().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getPlanCode());
			if (getPlanName() == null || getPlanName().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getPlanName());
			if (getRiderName() == null || getRiderName().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getRiderName());
			if (getRiderCode() == null || getRiderCode().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getRiderCode());
			if (getUWDid() == null || getUWDid().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getUWDid());
			if (getFaceAmount() == null || getFaceAmount().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getFaceAmount());
			if (getTerm() == null || getTerm().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getTerm());
			if (getHealthDeb() == null || getHealthDeb().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getHealthDeb());
			if (getHealthFe() == null || getHealthFe().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getHealthFe());
			if (getHealthFed() == null || getHealthFed().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getHealthFed());
			if (getOccupationFactor() == null || getOccupationFactor().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getOccupationFactor());
			if (getOccupationFe() == null || getOccupationFe().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getOccupationFe());
			if (getOccupationFed() == null || getOccupationFed().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getOccupationFed());
			if (getExclusions() == null || getExclusions().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getExclusions());
			if (getDeclinedCode() == null || getDeclinedCode().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getDeclinedCode());
			if (getDeclinedReason() == null || getDeclinedReason().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getDeclinedReason());
			if (getPassFlag() == null || getPassFlag().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getPassFlag());
			if (getUWIdea() == null || getUWIdea().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getUWIdea());
			if (getUWGrade() == null || getUWGrade().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getUWGrade());
			if (getAppGrade() == null || getAppGrade().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getAppGrade());
			if (getPostponeDay() == null || getPostponeDay().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getPostponeDay());
			if (getPostponeDate() == null || getPostponeDate().equals("null"))
				pstmt.setNull(32, 91);
			else
				pstmt.setDate(32, Date.valueOf(getPostponeDate()));
			if (getAutoUWFlag() == null || getAutoUWFlag().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getAutoUWFlag());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getState());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getManageCom());
			if (getUpReportContent() == null || getUpReportContent().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getUpReportContent());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getOperator());
			if (getHealthFlag() == null || getHealthFlag().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getHealthFlag());
			if (getQuesFlag() == null || getQuesFlag().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getQuesFlag());
			if (getSpecFlag() == null || getSpecFlag().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getSpecFlag());
			if (getAddPremFlag() == null || getAddPremFlag().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getAddPremFlag());
			if (getAddPremReason() == null || getAddPremReason().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getAddPremReason());
			if (getReportFlag() == null || getReportFlag().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getReportFlag());
			if (getPrintFlag() == null || getPrintFlag().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getPrintFlag());
			if (getPrintFlag2() == null || getPrintFlag2().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getPrintFlag2());
			if (getChangePolFlag() == null || getChangePolFlag().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getChangePolFlag());
			if (getChangePolReason() == null || getChangePolReason().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getChangePolReason());
			if (getSpecReason() == null || getSpecReason().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getSpecReason());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(49, 91);
			else
				pstmt.setDate(49, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(51, 91);
			else
				pstmt.setDate(51, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getModifyTime());
			if (getSugPassFlag() == null || getSugPassFlag().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getSugPassFlag());
			if (getSugUWIdea() == null || getSugUWIdea().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getSugUWIdea());
			if (getPolNo() == null || getPolNo().equals("null"))
				pstmt.setNull(55, 12);
			else
				pstmt.setString(55, getPolNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPUWMasterDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			if (getPolNo() == null || getPolNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPolNo());
			if (getProposalNo() == null || getProposalNo().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getProposalNo());
			pstmt.setInt(6, getUWNo());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getInsuredNo());
			if (getInsuredName() == null || getInsuredName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getInsuredName());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getAppntNo());
			if (getAppntName() == null || getAppntName().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getAppntName());
			if (getPlanCode() == null || getPlanCode().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getPlanCode());
			if (getPlanName() == null || getPlanName().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getPlanName());
			if (getRiderName() == null || getRiderName().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getRiderName());
			if (getRiderCode() == null || getRiderCode().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getRiderCode());
			if (getUWDid() == null || getUWDid().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getUWDid());
			if (getFaceAmount() == null || getFaceAmount().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getFaceAmount());
			if (getTerm() == null || getTerm().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getTerm());
			if (getHealthDeb() == null || getHealthDeb().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getHealthDeb());
			if (getHealthFe() == null || getHealthFe().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getHealthFe());
			if (getHealthFed() == null || getHealthFed().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getHealthFed());
			if (getOccupationFactor() == null || getOccupationFactor().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getOccupationFactor());
			if (getOccupationFe() == null || getOccupationFe().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getOccupationFe());
			if (getOccupationFed() == null || getOccupationFed().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getOccupationFed());
			if (getExclusions() == null || getExclusions().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getExclusions());
			if (getDeclinedCode() == null || getDeclinedCode().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getDeclinedCode());
			if (getDeclinedReason() == null || getDeclinedReason().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getDeclinedReason());
			if (getPassFlag() == null || getPassFlag().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getPassFlag());
			if (getUWIdea() == null || getUWIdea().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getUWIdea());
			if (getUWGrade() == null || getUWGrade().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getUWGrade());
			if (getAppGrade() == null || getAppGrade().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getAppGrade());
			if (getPostponeDay() == null || getPostponeDay().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getPostponeDay());
			if (getPostponeDate() == null || getPostponeDate().equals("null"))
				pstmt.setNull(32, 91);
			else
				pstmt.setDate(32, Date.valueOf(getPostponeDate()));
			if (getAutoUWFlag() == null || getAutoUWFlag().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getAutoUWFlag());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getState());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getManageCom());
			if (getUpReportContent() == null || getUpReportContent().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getUpReportContent());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getOperator());
			if (getHealthFlag() == null || getHealthFlag().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getHealthFlag());
			if (getQuesFlag() == null || getQuesFlag().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getQuesFlag());
			if (getSpecFlag() == null || getSpecFlag().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getSpecFlag());
			if (getAddPremFlag() == null || getAddPremFlag().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getAddPremFlag());
			if (getAddPremReason() == null || getAddPremReason().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getAddPremReason());
			if (getReportFlag() == null || getReportFlag().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getReportFlag());
			if (getPrintFlag() == null || getPrintFlag().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getPrintFlag());
			if (getPrintFlag2() == null || getPrintFlag2().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getPrintFlag2());
			if (getChangePolFlag() == null || getChangePolFlag().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getChangePolFlag());
			if (getChangePolReason() == null || getChangePolReason().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getChangePolReason());
			if (getSpecReason() == null || getSpecReason().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getSpecReason());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(49, 91);
			else
				pstmt.setDate(49, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(51, 91);
			else
				pstmt.setDate(51, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getModifyTime());
			if (getSugPassFlag() == null || getSugPassFlag().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getSugPassFlag());
			if (getSugUWIdea() == null || getSugUWIdea().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getSugUWIdea());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPUWMasterDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPUWMaster WHERE  PolNo = ?", 1003, 1007);
		if (getPolNo() == null || getPolNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getPolNo());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "LNPUWMasterDB";
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
				tError.moduleName = "LNPUWMasterDB";
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

	public LNPUWMasterSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPUWMasterSet aLNPUWMasterSet = new LNPUWMasterSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPUWMaster");
			LNPUWMasterSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPUWMasterSchema s1;
			for (; rs.next(); aLNPUWMasterSet.add(s1))
			{
				i++;
				s1 = new LNPUWMasterSchema();
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
			tError.moduleName = "LNPUWMasterDB";
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
		return aLNPUWMasterSet;
	}

	public LNPUWMasterSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPUWMasterSet aLNPUWMasterSet = new LNPUWMasterSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPUWMasterSchema s1;
			for (; rs.next(); aLNPUWMasterSet.add(s1))
			{
				i++;
				s1 = new LNPUWMasterSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPUWMasterDB";
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
			tError.moduleName = "LNPUWMasterDB";
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
		return aLNPUWMasterSet;
	}

	public LNPUWMasterSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPUWMasterSet aLNPUWMasterSet = new LNPUWMasterSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPUWMaster");
			LNPUWMasterSchema aSchema = getSchema();
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
				LNPUWMasterSchema s1 = new LNPUWMasterSchema();
				s1.setSchema(rs, i);
				aLNPUWMasterSet.add(s1);
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
			tError.moduleName = "LNPUWMasterDB";
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
		return aLNPUWMasterSet;
	}

	public LNPUWMasterSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPUWMasterSet aLNPUWMasterSet = new LNPUWMasterSet();
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
				LNPUWMasterSchema s1 = new LNPUWMasterSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPUWMasterDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPUWMasterSet.add(s1);
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
			tError.moduleName = "LNPUWMasterDB";
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
		return aLNPUWMasterSet;
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
				SQLString sqlObj = new SQLString("LNPUWMaster");
				LNPUWMasterSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPUWMaster ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPUWMasterDB";
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
				tError.moduleName = "LNPUWMasterDB";
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
			tError.moduleName = "LNPUWMasterDB";
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
			tError.moduleName = "LNPUWMasterDB";
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
			tError.moduleName = "LNPUWMasterDB";
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
			tError.moduleName = "LNPUWMasterDB";
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

	public LNPUWMasterSet getData()
	{
		int tCount = 0;
		LNPUWMasterSet tLNPUWMasterSet = new LNPUWMasterSet();
		LNPUWMasterSchema tLNPUWMasterSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPUWMasterDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPUWMasterSchema = new LNPUWMasterSchema();
			tLNPUWMasterSchema.setSchema(mResultSet, 1);
			tLNPUWMasterSet.add(tLNPUWMasterSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPUWMasterSchema = new LNPUWMasterSchema();
					tLNPUWMasterSchema.setSchema(mResultSet, 1);
					tLNPUWMasterSet.add(tLNPUWMasterSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPUWMasterDB";
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
		return tLNPUWMasterSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPUWMasterDB";
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
			tError.moduleName = "LNPUWMasterDB";
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
				tError.moduleName = "LNPUWMasterDB";
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
			tError.moduleName = "LNPUWMasterDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
