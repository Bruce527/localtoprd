// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPUWMasterDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPUWMasterSchema;
import com.sinosoft.banklns.lis.vschema.LNPUWMasterSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPUWMasterDBSet extends LNPUWMasterSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPUWMasterDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPUWMaster");
		mflag = true;
	}

	public LNPUWMasterDBSet()
	{
		mflag = false;
		db = new DBOper("LNPUWMaster");
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
			tError.moduleName = "LNPUWMasterDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPUWMaster WHERE  PolNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getPolNo());
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
			tError.moduleName = "LNPUWMasterDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PolNo = ? , ProposalNo = ? , UWNo = ? , InsuredNo = ? , InsuredName = ? , AppntNo = ? , AppntName = ? , PlanCode = ? , PlanName = ? , RiderName = ? , RiderCode = ? , UWDid = ? , FaceAmount = ? , Term = ? , HealthDeb = ? , HealthFe = ? , HealthFed = ? , OccupationFactor = ? , OccupationFe = ? , OccupationFed = ? , Exclusions = ? , DeclinedCode = ? , DeclinedReason = ? , PassFlag = ? , UWIdea = ? , UWGrade = ? , AppGrade = ? , PostponeDay = ? , PostponeDate = ? , AutoUWFlag = ? , State = ? , ManageCom = ? , UpReportContent = ? , Operator = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , ReportFlag = ? , PrintFlag = ? , PrintFlag2 = ? , ChangePolFlag = ? , ChangePolReason = ? , SpecReason = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , SugPassFlag = ? , SugUWIdea = ? WHERE  PolNo = ?");
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
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPolNo());
				if (get(i).getProposalNo() == null || get(i).getProposalNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getProposalNo());
				pstmt.setInt(6, get(i).getUWNo());
				if (get(i).getInsuredNo() == null || get(i).getInsuredNo().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getInsuredNo());
				if (get(i).getInsuredName() == null || get(i).getInsuredName().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getInsuredName());
				if (get(i).getAppntNo() == null || get(i).getAppntNo().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getAppntNo());
				if (get(i).getAppntName() == null || get(i).getAppntName().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getAppntName());
				if (get(i).getPlanCode() == null || get(i).getPlanCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getPlanCode());
				if (get(i).getPlanName() == null || get(i).getPlanName().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getPlanName());
				if (get(i).getRiderName() == null || get(i).getRiderName().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRiderName());
				if (get(i).getRiderCode() == null || get(i).getRiderCode().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getRiderCode());
				if (get(i).getUWDid() == null || get(i).getUWDid().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getUWDid());
				if (get(i).getFaceAmount() == null || get(i).getFaceAmount().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getFaceAmount());
				if (get(i).getTerm() == null || get(i).getTerm().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getTerm());
				if (get(i).getHealthDeb() == null || get(i).getHealthDeb().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getHealthDeb());
				if (get(i).getHealthFe() == null || get(i).getHealthFe().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getHealthFe());
				if (get(i).getHealthFed() == null || get(i).getHealthFed().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getHealthFed());
				if (get(i).getOccupationFactor() == null || get(i).getOccupationFactor().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getOccupationFactor());
				if (get(i).getOccupationFe() == null || get(i).getOccupationFe().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getOccupationFe());
				if (get(i).getOccupationFed() == null || get(i).getOccupationFed().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getOccupationFed());
				if (get(i).getExclusions() == null || get(i).getExclusions().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getExclusions());
				if (get(i).getDeclinedCode() == null || get(i).getDeclinedCode().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getDeclinedCode());
				if (get(i).getDeclinedReason() == null || get(i).getDeclinedReason().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getDeclinedReason());
				if (get(i).getPassFlag() == null || get(i).getPassFlag().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getPassFlag());
				if (get(i).getUWIdea() == null || get(i).getUWIdea().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getUWIdea());
				if (get(i).getUWGrade() == null || get(i).getUWGrade().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getUWGrade());
				if (get(i).getAppGrade() == null || get(i).getAppGrade().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getAppGrade());
				if (get(i).getPostponeDay() == null || get(i).getPostponeDay().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getPostponeDay());
				if (get(i).getPostponeDate() == null || get(i).getPostponeDate().equals("null"))
					pstmt.setDate(32, null);
				else
					pstmt.setDate(32, Date.valueOf(get(i).getPostponeDate()));
				if (get(i).getAutoUWFlag() == null || get(i).getAutoUWFlag().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getAutoUWFlag());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getState());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getManageCom());
				if (get(i).getUpReportContent() == null || get(i).getUpReportContent().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getUpReportContent());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getOperator());
				if (get(i).getHealthFlag() == null || get(i).getHealthFlag().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getHealthFlag());
				if (get(i).getQuesFlag() == null || get(i).getQuesFlag().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getQuesFlag());
				if (get(i).getSpecFlag() == null || get(i).getSpecFlag().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getSpecFlag());
				if (get(i).getAddPremFlag() == null || get(i).getAddPremFlag().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getAddPremFlag());
				if (get(i).getAddPremReason() == null || get(i).getAddPremReason().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getAddPremReason());
				if (get(i).getReportFlag() == null || get(i).getReportFlag().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getReportFlag());
				if (get(i).getPrintFlag() == null || get(i).getPrintFlag().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getPrintFlag());
				if (get(i).getPrintFlag2() == null || get(i).getPrintFlag2().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getPrintFlag2());
				if (get(i).getChangePolFlag() == null || get(i).getChangePolFlag().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getChangePolFlag());
				if (get(i).getChangePolReason() == null || get(i).getChangePolReason().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getChangePolReason());
				if (get(i).getSpecReason() == null || get(i).getSpecReason().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getSpecReason());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(49, null);
				else
					pstmt.setDate(49, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(50, null);
				else
					pstmt.setString(50, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(51, null);
				else
					pstmt.setDate(51, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getModifyTime());
				if (get(i).getSugPassFlag() == null || get(i).getSugPassFlag().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getSugPassFlag());
				if (get(i).getSugUWIdea() == null || get(i).getSugUWIdea().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getSugUWIdea());
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(55, null);
				else
					pstmt.setString(55, get(i).getPolNo());
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
			tError.moduleName = "LNPUWMasterDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPolNo());
				if (get(i).getProposalNo() == null || get(i).getProposalNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getProposalNo());
				pstmt.setInt(6, get(i).getUWNo());
				if (get(i).getInsuredNo() == null || get(i).getInsuredNo().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getInsuredNo());
				if (get(i).getInsuredName() == null || get(i).getInsuredName().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getInsuredName());
				if (get(i).getAppntNo() == null || get(i).getAppntNo().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getAppntNo());
				if (get(i).getAppntName() == null || get(i).getAppntName().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getAppntName());
				if (get(i).getPlanCode() == null || get(i).getPlanCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getPlanCode());
				if (get(i).getPlanName() == null || get(i).getPlanName().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getPlanName());
				if (get(i).getRiderName() == null || get(i).getRiderName().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRiderName());
				if (get(i).getRiderCode() == null || get(i).getRiderCode().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getRiderCode());
				if (get(i).getUWDid() == null || get(i).getUWDid().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getUWDid());
				if (get(i).getFaceAmount() == null || get(i).getFaceAmount().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getFaceAmount());
				if (get(i).getTerm() == null || get(i).getTerm().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getTerm());
				if (get(i).getHealthDeb() == null || get(i).getHealthDeb().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getHealthDeb());
				if (get(i).getHealthFe() == null || get(i).getHealthFe().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getHealthFe());
				if (get(i).getHealthFed() == null || get(i).getHealthFed().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getHealthFed());
				if (get(i).getOccupationFactor() == null || get(i).getOccupationFactor().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getOccupationFactor());
				if (get(i).getOccupationFe() == null || get(i).getOccupationFe().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getOccupationFe());
				if (get(i).getOccupationFed() == null || get(i).getOccupationFed().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getOccupationFed());
				if (get(i).getExclusions() == null || get(i).getExclusions().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getExclusions());
				if (get(i).getDeclinedCode() == null || get(i).getDeclinedCode().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getDeclinedCode());
				if (get(i).getDeclinedReason() == null || get(i).getDeclinedReason().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getDeclinedReason());
				if (get(i).getPassFlag() == null || get(i).getPassFlag().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getPassFlag());
				if (get(i).getUWIdea() == null || get(i).getUWIdea().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getUWIdea());
				if (get(i).getUWGrade() == null || get(i).getUWGrade().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getUWGrade());
				if (get(i).getAppGrade() == null || get(i).getAppGrade().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getAppGrade());
				if (get(i).getPostponeDay() == null || get(i).getPostponeDay().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getPostponeDay());
				if (get(i).getPostponeDate() == null || get(i).getPostponeDate().equals("null"))
					pstmt.setDate(32, null);
				else
					pstmt.setDate(32, Date.valueOf(get(i).getPostponeDate()));
				if (get(i).getAutoUWFlag() == null || get(i).getAutoUWFlag().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getAutoUWFlag());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getState());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getManageCom());
				if (get(i).getUpReportContent() == null || get(i).getUpReportContent().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getUpReportContent());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getOperator());
				if (get(i).getHealthFlag() == null || get(i).getHealthFlag().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getHealthFlag());
				if (get(i).getQuesFlag() == null || get(i).getQuesFlag().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getQuesFlag());
				if (get(i).getSpecFlag() == null || get(i).getSpecFlag().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getSpecFlag());
				if (get(i).getAddPremFlag() == null || get(i).getAddPremFlag().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getAddPremFlag());
				if (get(i).getAddPremReason() == null || get(i).getAddPremReason().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getAddPremReason());
				if (get(i).getReportFlag() == null || get(i).getReportFlag().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getReportFlag());
				if (get(i).getPrintFlag() == null || get(i).getPrintFlag().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getPrintFlag());
				if (get(i).getPrintFlag2() == null || get(i).getPrintFlag2().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getPrintFlag2());
				if (get(i).getChangePolFlag() == null || get(i).getChangePolFlag().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getChangePolFlag());
				if (get(i).getChangePolReason() == null || get(i).getChangePolReason().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getChangePolReason());
				if (get(i).getSpecReason() == null || get(i).getSpecReason().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getSpecReason());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(49, null);
				else
					pstmt.setDate(49, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(50, null);
				else
					pstmt.setString(50, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(51, null);
				else
					pstmt.setDate(51, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getModifyTime());
				if (get(i).getSugPassFlag() == null || get(i).getSugPassFlag().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getSugPassFlag());
				if (get(i).getSugUWIdea() == null || get(i).getSugUWIdea().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getSugUWIdea());
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
			tError.moduleName = "LNPUWMasterDBSet";
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
