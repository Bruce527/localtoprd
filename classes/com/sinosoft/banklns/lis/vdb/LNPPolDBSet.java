// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPolDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPPolSchema;
import com.sinosoft.banklns.lis.vschema.LNPPolSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPPolDBSet extends LNPPolSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPPolDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPPol");
		mflag = true;
	}

	public LNPPolDBSet()
	{
		mflag = false;
		db = new DBOper("LNPPol");
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
			tError.moduleName = "LNPPolDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPPol WHERE  PolNo = ?");
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
			tError.moduleName = "LNPPolDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPPol SET  GrpContNo = ? , GrpPolNo = ? , ContNo = ? , ProposalContNo = ? , PolNo = ? , ProposalNo = ? , PrtNo = ? , ContType = ? , PolTypeFlag = ? , MainPolNo = ? , MasterPolNo = ? , KindCode = ? , RiskCode = ? , RiskVersion = ? , ManageCom = ? , AgentCom = ? , AgentType = ? , AgentCode = ? , AgentGroup = ? , AgentGroup1 = ? , AgentCode1 = ? , SaleChnl = ? , Handler = ? , InsuredNo = ? , InsuredId = ? , InsuredName = ? , InsuredSex = ? , InsuredBirthday = ? , InsuredAppAge = ? , InsuredPeoples = ? , OccupationType = ? , AppntNo = ? , AppntName = ? , CValiDate = ? , SignCom = ? , SignDate = ? , SignTime = ? , FirstPayDate = ? , PayEndDate = ? , PaytoDate = ? , GetStartDate = ? , EndDate = ? , AcciEndDate = ? , GetYearFlag = ? , GetYear = ? , PayEndYearFlag = ? , PayEndYear = ? , InsuYearFlag = ? , InsuYear = ? , AcciYearFlag = ? , AcciYear = ? , GetStartType = ? , SpecifyValiDate = ? , PayMode = ? , PayLocation = ? , PayIntv = ? , PayYears = ? , Years = ? , ManageFeeRate = ? , FloatRate = ? , PremRate = ? , PremToAmnt = ? , Mult = ? , StandPrem = ? , Prem = ? , SumPrem = ? , Amnt = ? , RiskAmnt = ? , LeavingMoney = ? , EndorseTimes = ? , ClaimTimes = ? , LiveTimes = ? , RenewCount = ? , LastGetDate = ? , LastLoanDate = ? , LastRegetDate = ? , LastEdorDate = ? , LastRevDate = ? , RnewFlag = ? , StopFlag = ? , ExpiryFlag = ? , AutoPayFlag = ? , InterestDifFlag = ? , SubFlag = ? , BnfFlag = ? , HealthCheckFlag = ? , ImpartFlag = ? , ReinsureFlag = ? , AgentPayFlag = ? , AgentGetFlag = ? , LiveGetMode = ? , DeadGetMode = ? , BonusGetMode = ? , DeadAmntType = ? , TopUpPrem = ? , BonusMan = ? , DeadFlag = ? , SmokeFlag = ? , Remark = ? , ApproveFlag = ? , ApproveCode = ? , ApproveDate = ? , ApproveTime = ? , UWFlag = ? , UWCode = ? , UWDate = ? , UWTime = ? , PolApplyDate = ? , AppFlag = ? , SaleChnlDetail = ? , PolState = ? , StandbyFlag1 = ? , StandbyFlag2 = ? , StandbyFlag3 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  PolNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGrpContNo());
				if (get(i).getGrpPolNo() == null || get(i).getGrpPolNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getGrpPolNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getProposalContNo());
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPolNo());
				if (get(i).getProposalNo() == null || get(i).getProposalNo().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getProposalNo());
				if (get(i).getPrtNo() == null || get(i).getPrtNo().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getPrtNo());
				if (get(i).getContType() == null || get(i).getContType().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getContType());
				if (get(i).getPolTypeFlag() == null || get(i).getPolTypeFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getPolTypeFlag());
				if (get(i).getMainPolNo() == null || get(i).getMainPolNo().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getMainPolNo());
				if (get(i).getMasterPolNo() == null || get(i).getMasterPolNo().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getMasterPolNo());
				if (get(i).getKindCode() == null || get(i).getKindCode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getKindCode());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRiskCode());
				if (get(i).getRiskVersion() == null || get(i).getRiskVersion().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getRiskVersion());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getManageCom());
				if (get(i).getAgentCom() == null || get(i).getAgentCom().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAgentCom());
				if (get(i).getAgentType() == null || get(i).getAgentType().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getAgentType());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getAgentCode());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getAgentGroup());
				if (get(i).getAgentGroup1() == null || get(i).getAgentGroup1().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getAgentGroup1());
				if (get(i).getAgentCode1() == null || get(i).getAgentCode1().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getAgentCode1());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getSaleChnl());
				if (get(i).getHandler() == null || get(i).getHandler().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getHandler());
				if (get(i).getInsuredNo() == null || get(i).getInsuredNo().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getInsuredNo());
				if (get(i).getInsuredId() == null || get(i).getInsuredId().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getInsuredId());
				if (get(i).getInsuredName() == null || get(i).getInsuredName().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getInsuredName());
				if (get(i).getInsuredSex() == null || get(i).getInsuredSex().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getInsuredSex());
				if (get(i).getInsuredBirthday() == null || get(i).getInsuredBirthday().equals("null"))
					pstmt.setDate(28, null);
				else
					pstmt.setDate(28, Date.valueOf(get(i).getInsuredBirthday()));
				pstmt.setInt(29, get(i).getInsuredAppAge());
				pstmt.setInt(30, get(i).getInsuredPeoples());
				if (get(i).getOccupationType() == null || get(i).getOccupationType().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getOccupationType());
				if (get(i).getAppntNo() == null || get(i).getAppntNo().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getAppntNo());
				if (get(i).getAppntName() == null || get(i).getAppntName().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getAppntName());
				if (get(i).getCValiDate() == null || get(i).getCValiDate().equals("null"))
					pstmt.setDate(34, null);
				else
					pstmt.setDate(34, Date.valueOf(get(i).getCValiDate()));
				if (get(i).getSignCom() == null || get(i).getSignCom().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getSignCom());
				if (get(i).getSignDate() == null || get(i).getSignDate().equals("null"))
					pstmt.setDate(36, null);
				else
					pstmt.setDate(36, Date.valueOf(get(i).getSignDate()));
				if (get(i).getSignTime() == null || get(i).getSignTime().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getSignTime());
				if (get(i).getFirstPayDate() == null || get(i).getFirstPayDate().equals("null"))
					pstmt.setDate(38, null);
				else
					pstmt.setDate(38, Date.valueOf(get(i).getFirstPayDate()));
				if (get(i).getPayEndDate() == null || get(i).getPayEndDate().equals("null"))
					pstmt.setDate(39, null);
				else
					pstmt.setDate(39, Date.valueOf(get(i).getPayEndDate()));
				if (get(i).getPaytoDate() == null || get(i).getPaytoDate().equals("null"))
					pstmt.setDate(40, null);
				else
					pstmt.setDate(40, Date.valueOf(get(i).getPaytoDate()));
				if (get(i).getGetStartDate() == null || get(i).getGetStartDate().equals("null"))
					pstmt.setDate(41, null);
				else
					pstmt.setDate(41, Date.valueOf(get(i).getGetStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(42, null);
				else
					pstmt.setDate(42, Date.valueOf(get(i).getEndDate()));
				if (get(i).getAcciEndDate() == null || get(i).getAcciEndDate().equals("null"))
					pstmt.setDate(43, null);
				else
					pstmt.setDate(43, Date.valueOf(get(i).getAcciEndDate()));
				if (get(i).getGetYearFlag() == null || get(i).getGetYearFlag().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getGetYearFlag());
				pstmt.setInt(45, get(i).getGetYear());
				if (get(i).getPayEndYearFlag() == null || get(i).getPayEndYearFlag().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getPayEndYearFlag());
				pstmt.setInt(47, get(i).getPayEndYear());
				if (get(i).getInsuYearFlag() == null || get(i).getInsuYearFlag().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getInsuYearFlag());
				pstmt.setInt(49, get(i).getInsuYear());
				if (get(i).getAcciYearFlag() == null || get(i).getAcciYearFlag().equals("null"))
					pstmt.setString(50, null);
				else
					pstmt.setString(50, get(i).getAcciYearFlag());
				pstmt.setInt(51, get(i).getAcciYear());
				if (get(i).getGetStartType() == null || get(i).getGetStartType().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getGetStartType());
				if (get(i).getSpecifyValiDate() == null || get(i).getSpecifyValiDate().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getSpecifyValiDate());
				if (get(i).getPayMode() == null || get(i).getPayMode().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getPayMode());
				if (get(i).getPayLocation() == null || get(i).getPayLocation().equals("null"))
					pstmt.setString(55, null);
				else
					pstmt.setString(55, get(i).getPayLocation());
				pstmt.setInt(56, get(i).getPayIntv());
				pstmt.setInt(57, get(i).getPayYears());
				pstmt.setInt(58, get(i).getYears());
				pstmt.setDouble(59, get(i).getManageFeeRate());
				pstmt.setDouble(60, get(i).getFloatRate());
				pstmt.setDouble(61, get(i).getPremRate());
				if (get(i).getPremToAmnt() == null || get(i).getPremToAmnt().equals("null"))
					pstmt.setString(62, null);
				else
					pstmt.setString(62, get(i).getPremToAmnt());
				pstmt.setDouble(63, get(i).getMult());
				pstmt.setDouble(64, get(i).getStandPrem());
				pstmt.setDouble(65, get(i).getPrem());
				pstmt.setDouble(66, get(i).getSumPrem());
				pstmt.setDouble(67, get(i).getAmnt());
				pstmt.setDouble(68, get(i).getRiskAmnt());
				pstmt.setDouble(69, get(i).getLeavingMoney());
				pstmt.setInt(70, get(i).getEndorseTimes());
				pstmt.setInt(71, get(i).getClaimTimes());
				pstmt.setInt(72, get(i).getLiveTimes());
				pstmt.setInt(73, get(i).getRenewCount());
				if (get(i).getLastGetDate() == null || get(i).getLastGetDate().equals("null"))
					pstmt.setDate(74, null);
				else
					pstmt.setDate(74, Date.valueOf(get(i).getLastGetDate()));
				if (get(i).getLastLoanDate() == null || get(i).getLastLoanDate().equals("null"))
					pstmt.setDate(75, null);
				else
					pstmt.setDate(75, Date.valueOf(get(i).getLastLoanDate()));
				if (get(i).getLastRegetDate() == null || get(i).getLastRegetDate().equals("null"))
					pstmt.setDate(76, null);
				else
					pstmt.setDate(76, Date.valueOf(get(i).getLastRegetDate()));
				if (get(i).getLastEdorDate() == null || get(i).getLastEdorDate().equals("null"))
					pstmt.setDate(77, null);
				else
					pstmt.setDate(77, Date.valueOf(get(i).getLastEdorDate()));
				if (get(i).getLastRevDate() == null || get(i).getLastRevDate().equals("null"))
					pstmt.setDate(78, null);
				else
					pstmt.setDate(78, Date.valueOf(get(i).getLastRevDate()));
				if (get(i).getRnewFlag() == null || get(i).getRnewFlag().equals("null"))
					pstmt.setString(79, null);
				else
					pstmt.setString(79, get(i).getRnewFlag());
				if (get(i).getStopFlag() == null || get(i).getStopFlag().equals("null"))
					pstmt.setString(80, null);
				else
					pstmt.setString(80, get(i).getStopFlag());
				if (get(i).getExpiryFlag() == null || get(i).getExpiryFlag().equals("null"))
					pstmt.setString(81, null);
				else
					pstmt.setString(81, get(i).getExpiryFlag());
				if (get(i).getAutoPayFlag() == null || get(i).getAutoPayFlag().equals("null"))
					pstmt.setString(82, null);
				else
					pstmt.setString(82, get(i).getAutoPayFlag());
				if (get(i).getInterestDifFlag() == null || get(i).getInterestDifFlag().equals("null"))
					pstmt.setString(83, null);
				else
					pstmt.setString(83, get(i).getInterestDifFlag());
				if (get(i).getSubFlag() == null || get(i).getSubFlag().equals("null"))
					pstmt.setString(84, null);
				else
					pstmt.setString(84, get(i).getSubFlag());
				if (get(i).getBnfFlag() == null || get(i).getBnfFlag().equals("null"))
					pstmt.setString(85, null);
				else
					pstmt.setString(85, get(i).getBnfFlag());
				if (get(i).getHealthCheckFlag() == null || get(i).getHealthCheckFlag().equals("null"))
					pstmt.setString(86, null);
				else
					pstmt.setString(86, get(i).getHealthCheckFlag());
				if (get(i).getImpartFlag() == null || get(i).getImpartFlag().equals("null"))
					pstmt.setString(87, null);
				else
					pstmt.setString(87, get(i).getImpartFlag());
				if (get(i).getReinsureFlag() == null || get(i).getReinsureFlag().equals("null"))
					pstmt.setString(88, null);
				else
					pstmt.setString(88, get(i).getReinsureFlag());
				if (get(i).getAgentPayFlag() == null || get(i).getAgentPayFlag().equals("null"))
					pstmt.setString(89, null);
				else
					pstmt.setString(89, get(i).getAgentPayFlag());
				if (get(i).getAgentGetFlag() == null || get(i).getAgentGetFlag().equals("null"))
					pstmt.setString(90, null);
				else
					pstmt.setString(90, get(i).getAgentGetFlag());
				if (get(i).getLiveGetMode() == null || get(i).getLiveGetMode().equals("null"))
					pstmt.setString(91, null);
				else
					pstmt.setString(91, get(i).getLiveGetMode());
				if (get(i).getDeadGetMode() == null || get(i).getDeadGetMode().equals("null"))
					pstmt.setString(92, null);
				else
					pstmt.setString(92, get(i).getDeadGetMode());
				if (get(i).getBonusGetMode() == null || get(i).getBonusGetMode().equals("null"))
					pstmt.setString(93, null);
				else
					pstmt.setString(93, get(i).getBonusGetMode());
				if (get(i).getDeadAmntType() == null || get(i).getDeadAmntType().equals("null"))
					pstmt.setString(94, null);
				else
					pstmt.setString(94, get(i).getDeadAmntType());
				pstmt.setDouble(95, get(i).getTopUpPrem());
				if (get(i).getBonusMan() == null || get(i).getBonusMan().equals("null"))
					pstmt.setString(96, null);
				else
					pstmt.setString(96, get(i).getBonusMan());
				if (get(i).getDeadFlag() == null || get(i).getDeadFlag().equals("null"))
					pstmt.setString(97, null);
				else
					pstmt.setString(97, get(i).getDeadFlag());
				if (get(i).getSmokeFlag() == null || get(i).getSmokeFlag().equals("null"))
					pstmt.setString(98, null);
				else
					pstmt.setString(98, get(i).getSmokeFlag());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(99, null);
				else
					pstmt.setString(99, get(i).getRemark());
				if (get(i).getApproveFlag() == null || get(i).getApproveFlag().equals("null"))
					pstmt.setString(100, null);
				else
					pstmt.setString(100, get(i).getApproveFlag());
				if (get(i).getApproveCode() == null || get(i).getApproveCode().equals("null"))
					pstmt.setString(101, null);
				else
					pstmt.setString(101, get(i).getApproveCode());
				if (get(i).getApproveDate() == null || get(i).getApproveDate().equals("null"))
					pstmt.setDate(102, null);
				else
					pstmt.setDate(102, Date.valueOf(get(i).getApproveDate()));
				if (get(i).getApproveTime() == null || get(i).getApproveTime().equals("null"))
					pstmt.setString(103, null);
				else
					pstmt.setString(103, get(i).getApproveTime());
				if (get(i).getUWFlag() == null || get(i).getUWFlag().equals("null"))
					pstmt.setString(104, null);
				else
					pstmt.setString(104, get(i).getUWFlag());
				if (get(i).getUWCode() == null || get(i).getUWCode().equals("null"))
					pstmt.setString(105, null);
				else
					pstmt.setString(105, get(i).getUWCode());
				if (get(i).getUWDate() == null || get(i).getUWDate().equals("null"))
					pstmt.setDate(106, null);
				else
					pstmt.setDate(106, Date.valueOf(get(i).getUWDate()));
				if (get(i).getUWTime() == null || get(i).getUWTime().equals("null"))
					pstmt.setString(107, null);
				else
					pstmt.setString(107, get(i).getUWTime());
				if (get(i).getPolApplyDate() == null || get(i).getPolApplyDate().equals("null"))
					pstmt.setDate(108, null);
				else
					pstmt.setDate(108, Date.valueOf(get(i).getPolApplyDate()));
				if (get(i).getAppFlag() == null || get(i).getAppFlag().equals("null"))
					pstmt.setString(109, null);
				else
					pstmt.setString(109, get(i).getAppFlag());
				if (get(i).getSaleChnlDetail() == null || get(i).getSaleChnlDetail().equals("null"))
					pstmt.setString(110, null);
				else
					pstmt.setString(110, get(i).getSaleChnlDetail());
				if (get(i).getPolState() == null || get(i).getPolState().equals("null"))
					pstmt.setString(111, null);
				else
					pstmt.setString(111, get(i).getPolState());
				if (get(i).getStandbyFlag1() == null || get(i).getStandbyFlag1().equals("null"))
					pstmt.setString(112, null);
				else
					pstmt.setString(112, get(i).getStandbyFlag1());
				if (get(i).getStandbyFlag2() == null || get(i).getStandbyFlag2().equals("null"))
					pstmt.setString(113, null);
				else
					pstmt.setString(113, get(i).getStandbyFlag2());
				if (get(i).getStandbyFlag3() == null || get(i).getStandbyFlag3().equals("null"))
					pstmt.setString(114, null);
				else
					pstmt.setString(114, get(i).getStandbyFlag3());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(115, null);
				else
					pstmt.setString(115, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(116, null);
				else
					pstmt.setDate(116, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(117, null);
				else
					pstmt.setString(117, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(118, null);
				else
					pstmt.setDate(118, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(119, null);
				else
					pstmt.setString(119, get(i).getModifyTime());
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(120, null);
				else
					pstmt.setString(120, get(i).getPolNo());
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
			tError.moduleName = "LNPPolDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPPol VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGrpContNo());
				if (get(i).getGrpPolNo() == null || get(i).getGrpPolNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getGrpPolNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getProposalContNo());
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPolNo());
				if (get(i).getProposalNo() == null || get(i).getProposalNo().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getProposalNo());
				if (get(i).getPrtNo() == null || get(i).getPrtNo().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getPrtNo());
				if (get(i).getContType() == null || get(i).getContType().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getContType());
				if (get(i).getPolTypeFlag() == null || get(i).getPolTypeFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getPolTypeFlag());
				if (get(i).getMainPolNo() == null || get(i).getMainPolNo().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getMainPolNo());
				if (get(i).getMasterPolNo() == null || get(i).getMasterPolNo().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getMasterPolNo());
				if (get(i).getKindCode() == null || get(i).getKindCode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getKindCode());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRiskCode());
				if (get(i).getRiskVersion() == null || get(i).getRiskVersion().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getRiskVersion());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getManageCom());
				if (get(i).getAgentCom() == null || get(i).getAgentCom().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAgentCom());
				if (get(i).getAgentType() == null || get(i).getAgentType().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getAgentType());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getAgentCode());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getAgentGroup());
				if (get(i).getAgentGroup1() == null || get(i).getAgentGroup1().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getAgentGroup1());
				if (get(i).getAgentCode1() == null || get(i).getAgentCode1().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getAgentCode1());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getSaleChnl());
				if (get(i).getHandler() == null || get(i).getHandler().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getHandler());
				if (get(i).getInsuredNo() == null || get(i).getInsuredNo().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getInsuredNo());
				if (get(i).getInsuredId() == null || get(i).getInsuredId().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getInsuredId());
				if (get(i).getInsuredName() == null || get(i).getInsuredName().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getInsuredName());
				if (get(i).getInsuredSex() == null || get(i).getInsuredSex().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getInsuredSex());
				if (get(i).getInsuredBirthday() == null || get(i).getInsuredBirthday().equals("null"))
					pstmt.setDate(28, null);
				else
					pstmt.setDate(28, Date.valueOf(get(i).getInsuredBirthday()));
				pstmt.setInt(29, get(i).getInsuredAppAge());
				pstmt.setInt(30, get(i).getInsuredPeoples());
				if (get(i).getOccupationType() == null || get(i).getOccupationType().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getOccupationType());
				if (get(i).getAppntNo() == null || get(i).getAppntNo().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getAppntNo());
				if (get(i).getAppntName() == null || get(i).getAppntName().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getAppntName());
				if (get(i).getCValiDate() == null || get(i).getCValiDate().equals("null"))
					pstmt.setDate(34, null);
				else
					pstmt.setDate(34, Date.valueOf(get(i).getCValiDate()));
				if (get(i).getSignCom() == null || get(i).getSignCom().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getSignCom());
				if (get(i).getSignDate() == null || get(i).getSignDate().equals("null"))
					pstmt.setDate(36, null);
				else
					pstmt.setDate(36, Date.valueOf(get(i).getSignDate()));
				if (get(i).getSignTime() == null || get(i).getSignTime().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getSignTime());
				if (get(i).getFirstPayDate() == null || get(i).getFirstPayDate().equals("null"))
					pstmt.setDate(38, null);
				else
					pstmt.setDate(38, Date.valueOf(get(i).getFirstPayDate()));
				if (get(i).getPayEndDate() == null || get(i).getPayEndDate().equals("null"))
					pstmt.setDate(39, null);
				else
					pstmt.setDate(39, Date.valueOf(get(i).getPayEndDate()));
				if (get(i).getPaytoDate() == null || get(i).getPaytoDate().equals("null"))
					pstmt.setDate(40, null);
				else
					pstmt.setDate(40, Date.valueOf(get(i).getPaytoDate()));
				if (get(i).getGetStartDate() == null || get(i).getGetStartDate().equals("null"))
					pstmt.setDate(41, null);
				else
					pstmt.setDate(41, Date.valueOf(get(i).getGetStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(42, null);
				else
					pstmt.setDate(42, Date.valueOf(get(i).getEndDate()));
				if (get(i).getAcciEndDate() == null || get(i).getAcciEndDate().equals("null"))
					pstmt.setDate(43, null);
				else
					pstmt.setDate(43, Date.valueOf(get(i).getAcciEndDate()));
				if (get(i).getGetYearFlag() == null || get(i).getGetYearFlag().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getGetYearFlag());
				pstmt.setInt(45, get(i).getGetYear());
				if (get(i).getPayEndYearFlag() == null || get(i).getPayEndYearFlag().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getPayEndYearFlag());
				pstmt.setInt(47, get(i).getPayEndYear());
				if (get(i).getInsuYearFlag() == null || get(i).getInsuYearFlag().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getInsuYearFlag());
				pstmt.setInt(49, get(i).getInsuYear());
				if (get(i).getAcciYearFlag() == null || get(i).getAcciYearFlag().equals("null"))
					pstmt.setString(50, null);
				else
					pstmt.setString(50, get(i).getAcciYearFlag());
				pstmt.setInt(51, get(i).getAcciYear());
				if (get(i).getGetStartType() == null || get(i).getGetStartType().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getGetStartType());
				if (get(i).getSpecifyValiDate() == null || get(i).getSpecifyValiDate().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getSpecifyValiDate());
				if (get(i).getPayMode() == null || get(i).getPayMode().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getPayMode());
				if (get(i).getPayLocation() == null || get(i).getPayLocation().equals("null"))
					pstmt.setString(55, null);
				else
					pstmt.setString(55, get(i).getPayLocation());
				pstmt.setInt(56, get(i).getPayIntv());
				pstmt.setInt(57, get(i).getPayYears());
				pstmt.setInt(58, get(i).getYears());
				pstmt.setDouble(59, get(i).getManageFeeRate());
				pstmt.setDouble(60, get(i).getFloatRate());
				pstmt.setDouble(61, get(i).getPremRate());
				if (get(i).getPremToAmnt() == null || get(i).getPremToAmnt().equals("null"))
					pstmt.setString(62, null);
				else
					pstmt.setString(62, get(i).getPremToAmnt());
				pstmt.setDouble(63, get(i).getMult());
				pstmt.setDouble(64, get(i).getStandPrem());
				pstmt.setDouble(65, get(i).getPrem());
				pstmt.setDouble(66, get(i).getSumPrem());
				pstmt.setDouble(67, get(i).getAmnt());
				pstmt.setDouble(68, get(i).getRiskAmnt());
				pstmt.setDouble(69, get(i).getLeavingMoney());
				pstmt.setInt(70, get(i).getEndorseTimes());
				pstmt.setInt(71, get(i).getClaimTimes());
				pstmt.setInt(72, get(i).getLiveTimes());
				pstmt.setInt(73, get(i).getRenewCount());
				if (get(i).getLastGetDate() == null || get(i).getLastGetDate().equals("null"))
					pstmt.setDate(74, null);
				else
					pstmt.setDate(74, Date.valueOf(get(i).getLastGetDate()));
				if (get(i).getLastLoanDate() == null || get(i).getLastLoanDate().equals("null"))
					pstmt.setDate(75, null);
				else
					pstmt.setDate(75, Date.valueOf(get(i).getLastLoanDate()));
				if (get(i).getLastRegetDate() == null || get(i).getLastRegetDate().equals("null"))
					pstmt.setDate(76, null);
				else
					pstmt.setDate(76, Date.valueOf(get(i).getLastRegetDate()));
				if (get(i).getLastEdorDate() == null || get(i).getLastEdorDate().equals("null"))
					pstmt.setDate(77, null);
				else
					pstmt.setDate(77, Date.valueOf(get(i).getLastEdorDate()));
				if (get(i).getLastRevDate() == null || get(i).getLastRevDate().equals("null"))
					pstmt.setDate(78, null);
				else
					pstmt.setDate(78, Date.valueOf(get(i).getLastRevDate()));
				if (get(i).getRnewFlag() == null || get(i).getRnewFlag().equals("null"))
					pstmt.setString(79, null);
				else
					pstmt.setString(79, get(i).getRnewFlag());
				if (get(i).getStopFlag() == null || get(i).getStopFlag().equals("null"))
					pstmt.setString(80, null);
				else
					pstmt.setString(80, get(i).getStopFlag());
				if (get(i).getExpiryFlag() == null || get(i).getExpiryFlag().equals("null"))
					pstmt.setString(81, null);
				else
					pstmt.setString(81, get(i).getExpiryFlag());
				if (get(i).getAutoPayFlag() == null || get(i).getAutoPayFlag().equals("null"))
					pstmt.setString(82, null);
				else
					pstmt.setString(82, get(i).getAutoPayFlag());
				if (get(i).getInterestDifFlag() == null || get(i).getInterestDifFlag().equals("null"))
					pstmt.setString(83, null);
				else
					pstmt.setString(83, get(i).getInterestDifFlag());
				if (get(i).getSubFlag() == null || get(i).getSubFlag().equals("null"))
					pstmt.setString(84, null);
				else
					pstmt.setString(84, get(i).getSubFlag());
				if (get(i).getBnfFlag() == null || get(i).getBnfFlag().equals("null"))
					pstmt.setString(85, null);
				else
					pstmt.setString(85, get(i).getBnfFlag());
				if (get(i).getHealthCheckFlag() == null || get(i).getHealthCheckFlag().equals("null"))
					pstmt.setString(86, null);
				else
					pstmt.setString(86, get(i).getHealthCheckFlag());
				if (get(i).getImpartFlag() == null || get(i).getImpartFlag().equals("null"))
					pstmt.setString(87, null);
				else
					pstmt.setString(87, get(i).getImpartFlag());
				if (get(i).getReinsureFlag() == null || get(i).getReinsureFlag().equals("null"))
					pstmt.setString(88, null);
				else
					pstmt.setString(88, get(i).getReinsureFlag());
				if (get(i).getAgentPayFlag() == null || get(i).getAgentPayFlag().equals("null"))
					pstmt.setString(89, null);
				else
					pstmt.setString(89, get(i).getAgentPayFlag());
				if (get(i).getAgentGetFlag() == null || get(i).getAgentGetFlag().equals("null"))
					pstmt.setString(90, null);
				else
					pstmt.setString(90, get(i).getAgentGetFlag());
				if (get(i).getLiveGetMode() == null || get(i).getLiveGetMode().equals("null"))
					pstmt.setString(91, null);
				else
					pstmt.setString(91, get(i).getLiveGetMode());
				if (get(i).getDeadGetMode() == null || get(i).getDeadGetMode().equals("null"))
					pstmt.setString(92, null);
				else
					pstmt.setString(92, get(i).getDeadGetMode());
				if (get(i).getBonusGetMode() == null || get(i).getBonusGetMode().equals("null"))
					pstmt.setString(93, null);
				else
					pstmt.setString(93, get(i).getBonusGetMode());
				if (get(i).getDeadAmntType() == null || get(i).getDeadAmntType().equals("null"))
					pstmt.setString(94, null);
				else
					pstmt.setString(94, get(i).getDeadAmntType());
				pstmt.setDouble(95, get(i).getTopUpPrem());
				if (get(i).getBonusMan() == null || get(i).getBonusMan().equals("null"))
					pstmt.setString(96, null);
				else
					pstmt.setString(96, get(i).getBonusMan());
				if (get(i).getDeadFlag() == null || get(i).getDeadFlag().equals("null"))
					pstmt.setString(97, null);
				else
					pstmt.setString(97, get(i).getDeadFlag());
				if (get(i).getSmokeFlag() == null || get(i).getSmokeFlag().equals("null"))
					pstmt.setString(98, null);
				else
					pstmt.setString(98, get(i).getSmokeFlag());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(99, null);
				else
					pstmt.setString(99, get(i).getRemark());
				if (get(i).getApproveFlag() == null || get(i).getApproveFlag().equals("null"))
					pstmt.setString(100, null);
				else
					pstmt.setString(100, get(i).getApproveFlag());
				if (get(i).getApproveCode() == null || get(i).getApproveCode().equals("null"))
					pstmt.setString(101, null);
				else
					pstmt.setString(101, get(i).getApproveCode());
				if (get(i).getApproveDate() == null || get(i).getApproveDate().equals("null"))
					pstmt.setDate(102, null);
				else
					pstmt.setDate(102, Date.valueOf(get(i).getApproveDate()));
				if (get(i).getApproveTime() == null || get(i).getApproveTime().equals("null"))
					pstmt.setString(103, null);
				else
					pstmt.setString(103, get(i).getApproveTime());
				if (get(i).getUWFlag() == null || get(i).getUWFlag().equals("null"))
					pstmt.setString(104, null);
				else
					pstmt.setString(104, get(i).getUWFlag());
				if (get(i).getUWCode() == null || get(i).getUWCode().equals("null"))
					pstmt.setString(105, null);
				else
					pstmt.setString(105, get(i).getUWCode());
				if (get(i).getUWDate() == null || get(i).getUWDate().equals("null"))
					pstmt.setDate(106, null);
				else
					pstmt.setDate(106, Date.valueOf(get(i).getUWDate()));
				if (get(i).getUWTime() == null || get(i).getUWTime().equals("null"))
					pstmt.setString(107, null);
				else
					pstmt.setString(107, get(i).getUWTime());
				if (get(i).getPolApplyDate() == null || get(i).getPolApplyDate().equals("null"))
					pstmt.setDate(108, null);
				else
					pstmt.setDate(108, Date.valueOf(get(i).getPolApplyDate()));
				if (get(i).getAppFlag() == null || get(i).getAppFlag().equals("null"))
					pstmt.setString(109, null);
				else
					pstmt.setString(109, get(i).getAppFlag());
				if (get(i).getSaleChnlDetail() == null || get(i).getSaleChnlDetail().equals("null"))
					pstmt.setString(110, null);
				else
					pstmt.setString(110, get(i).getSaleChnlDetail());
				if (get(i).getPolState() == null || get(i).getPolState().equals("null"))
					pstmt.setString(111, null);
				else
					pstmt.setString(111, get(i).getPolState());
				if (get(i).getStandbyFlag1() == null || get(i).getStandbyFlag1().equals("null"))
					pstmt.setString(112, null);
				else
					pstmt.setString(112, get(i).getStandbyFlag1());
				if (get(i).getStandbyFlag2() == null || get(i).getStandbyFlag2().equals("null"))
					pstmt.setString(113, null);
				else
					pstmt.setString(113, get(i).getStandbyFlag2());
				if (get(i).getStandbyFlag3() == null || get(i).getStandbyFlag3().equals("null"))
					pstmt.setString(114, null);
				else
					pstmt.setString(114, get(i).getStandbyFlag3());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(115, null);
				else
					pstmt.setString(115, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(116, null);
				else
					pstmt.setDate(116, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(117, null);
				else
					pstmt.setString(117, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(118, null);
				else
					pstmt.setDate(118, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(119, null);
				else
					pstmt.setString(119, get(i).getModifyTime());
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
			tError.moduleName = "LNPPolDBSet";
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
