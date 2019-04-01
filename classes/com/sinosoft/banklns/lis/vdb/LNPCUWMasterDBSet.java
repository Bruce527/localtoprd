// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCUWMasterDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPCUWMasterSchema;
import com.sinosoft.banklns.lis.vschema.LNPCUWMasterSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPCUWMasterDBSet extends LNPCUWMasterSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPCUWMasterDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPCUWMaster");
		mflag = true;
	}

	public LNPCUWMasterDBSet()
	{
		mflag = false;
		db = new DBOper("LNPCUWMaster");
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
			tError.moduleName = "LNPCUWMasterDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCUWMaster WHERE  ContNo = ?");
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
			tError.moduleName = "LNPCUWMasterDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPCUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , UWDate = ? , UWTime = ? , UWerName = ? , CheckStatus = ? , AppIsCompleted = ? , AppIsSubmitted = ? , AppDecision = ? , AutoUWFlag = ? , UWMessages = ? , UWGrade = ? , AppGrade = ? , State = ? , UpReportContent = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , SpecReason = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
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
				pstmt.setInt(4, get(i).getUWNo());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getUWDate() == null || get(i).getUWDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getUWDate()));
				if (get(i).getUWTime() == null || get(i).getUWTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getUWTime());
				if (get(i).getUWerName() == null || get(i).getUWerName().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getUWerName());
				if (get(i).getCheckStatus() == null || get(i).getCheckStatus().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCheckStatus());
				if (get(i).getAppIsCompleted() == null || get(i).getAppIsCompleted().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getAppIsCompleted());
				if (get(i).getAppIsSubmitted() == null || get(i).getAppIsSubmitted().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getAppIsSubmitted());
				if (get(i).getAppDecision() == null || get(i).getAppDecision().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getAppDecision());
				if (get(i).getAutoUWFlag() == null || get(i).getAutoUWFlag().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getAutoUWFlag());
				if (get(i).getUWMessages() == null || get(i).getUWMessages().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getUWMessages());
				if (get(i).getUWGrade() == null || get(i).getUWGrade().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getUWGrade());
				if (get(i).getAppGrade() == null || get(i).getAppGrade().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAppGrade());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getState());
				if (get(i).getUpReportContent() == null || get(i).getUpReportContent().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getUpReportContent());
				if (get(i).getHealthFlag() == null || get(i).getHealthFlag().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getHealthFlag());
				if (get(i).getQuesFlag() == null || get(i).getQuesFlag().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getQuesFlag());
				if (get(i).getSpecFlag() == null || get(i).getSpecFlag().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getSpecFlag());
				if (get(i).getAddPremFlag() == null || get(i).getAddPremFlag().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getAddPremFlag());
				if (get(i).getAddPremReason() == null || get(i).getAddPremReason().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getAddPremReason());
				if (get(i).getSpecReason() == null || get(i).getSpecReason().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getSpecReason());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(26, null);
				else
					pstmt.setDate(26, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(28, null);
				else
					pstmt.setDate(28, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getModifyTime());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getContNo());
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
			tError.moduleName = "LNPCUWMasterDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				pstmt.setInt(4, get(i).getUWNo());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getUWDate() == null || get(i).getUWDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getUWDate()));
				if (get(i).getUWTime() == null || get(i).getUWTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getUWTime());
				if (get(i).getUWerName() == null || get(i).getUWerName().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getUWerName());
				if (get(i).getCheckStatus() == null || get(i).getCheckStatus().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCheckStatus());
				if (get(i).getAppIsCompleted() == null || get(i).getAppIsCompleted().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getAppIsCompleted());
				if (get(i).getAppIsSubmitted() == null || get(i).getAppIsSubmitted().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getAppIsSubmitted());
				if (get(i).getAppDecision() == null || get(i).getAppDecision().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getAppDecision());
				if (get(i).getAutoUWFlag() == null || get(i).getAutoUWFlag().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getAutoUWFlag());
				if (get(i).getUWMessages() == null || get(i).getUWMessages().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getUWMessages());
				if (get(i).getUWGrade() == null || get(i).getUWGrade().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getUWGrade());
				if (get(i).getAppGrade() == null || get(i).getAppGrade().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAppGrade());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getState());
				if (get(i).getUpReportContent() == null || get(i).getUpReportContent().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getUpReportContent());
				if (get(i).getHealthFlag() == null || get(i).getHealthFlag().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getHealthFlag());
				if (get(i).getQuesFlag() == null || get(i).getQuesFlag().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getQuesFlag());
				if (get(i).getSpecFlag() == null || get(i).getSpecFlag().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getSpecFlag());
				if (get(i).getAddPremFlag() == null || get(i).getAddPremFlag().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getAddPremFlag());
				if (get(i).getAddPremReason() == null || get(i).getAddPremReason().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getAddPremReason());
				if (get(i).getSpecReason() == null || get(i).getSpecReason().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getSpecReason());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(26, null);
				else
					pstmt.setDate(26, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(28, null);
				else
					pstmt.setDate(28, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getModifyTime());
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
			tError.moduleName = "LNPCUWMasterDBSet";
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
