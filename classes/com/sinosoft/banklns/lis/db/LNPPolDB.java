// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPPolDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPPolSchema;
import com.sinosoft.banklns.lis.vschema.LNPPolSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPPolDB extends LNPPolSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPPolDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPPol");
		mflag = true;
	}

	public LNPPolDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPPol");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPPolSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPPolDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPPolSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPPolDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPPol WHERE  PolNo = ?");
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
			tError.moduleName = "LNPPolDB";
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
			pstmt = con.prepareStatement("UPDATE LNPPol SET  GrpContNo = ? , GrpPolNo = ? , ContNo = ? , ProposalContNo = ? , PolNo = ? , ProposalNo = ? , PrtNo = ? , ContType = ? , PolTypeFlag = ? , MainPolNo = ? , MasterPolNo = ? , KindCode = ? , RiskCode = ? , RiskVersion = ? , ManageCom = ? , AgentCom = ? , AgentType = ? , AgentCode = ? , AgentGroup = ? , AgentGroup1 = ? , AgentCode1 = ? , SaleChnl = ? , Handler = ? , InsuredNo = ? , InsuredId = ? , InsuredName = ? , InsuredSex = ? , InsuredBirthday = ? , InsuredAppAge = ? , InsuredPeoples = ? , OccupationType = ? , AppntNo = ? , AppntName = ? , CValiDate = ? , SignCom = ? , SignDate = ? , SignTime = ? , FirstPayDate = ? , PayEndDate = ? , PaytoDate = ? , GetStartDate = ? , EndDate = ? , AcciEndDate = ? , GetYearFlag = ? , GetYear = ? , PayEndYearFlag = ? , PayEndYear = ? , InsuYearFlag = ? , InsuYear = ? , AcciYearFlag = ? , AcciYear = ? , GetStartType = ? , SpecifyValiDate = ? , PayMode = ? , PayLocation = ? , PayIntv = ? , PayYears = ? , Years = ? , ManageFeeRate = ? , FloatRate = ? , PremRate = ? , PremToAmnt = ? , Mult = ? , StandPrem = ? , Prem = ? , SumPrem = ? , Amnt = ? , RiskAmnt = ? , LeavingMoney = ? , EndorseTimes = ? , ClaimTimes = ? , LiveTimes = ? , RenewCount = ? , LastGetDate = ? , LastLoanDate = ? , LastRegetDate = ? , LastEdorDate = ? , LastRevDate = ? , RnewFlag = ? , StopFlag = ? , ExpiryFlag = ? , AutoPayFlag = ? , InterestDifFlag = ? , SubFlag = ? , BnfFlag = ? , HealthCheckFlag = ? , ImpartFlag = ? , ReinsureFlag = ? , AgentPayFlag = ? , AgentGetFlag = ? , LiveGetMode = ? , DeadGetMode = ? , BonusGetMode = ? , DeadAmntType = ? , TopUpPrem = ? , BonusMan = ? , DeadFlag = ? , SmokeFlag = ? , Remark = ? , ApproveFlag = ? , ApproveCode = ? , ApproveDate = ? , ApproveTime = ? , UWFlag = ? , UWCode = ? , UWDate = ? , UWTime = ? , PolApplyDate = ? , AppFlag = ? , SaleChnlDetail = ? , PolState = ? , StandbyFlag1 = ? , StandbyFlag2 = ? , StandbyFlag3 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  PolNo = ?");
			if (getGrpContNo() == null || getGrpContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getGrpContNo());
			if (getGrpPolNo() == null || getGrpPolNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getGrpPolNo());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getContNo());
			if (getProposalContNo() == null || getProposalContNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getProposalContNo());
			if (getPolNo() == null || getPolNo().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getPolNo());
			if (getProposalNo() == null || getProposalNo().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getProposalNo());
			if (getPrtNo() == null || getPrtNo().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getPrtNo());
			if (getContType() == null || getContType().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getContType());
			if (getPolTypeFlag() == null || getPolTypeFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getPolTypeFlag());
			if (getMainPolNo() == null || getMainPolNo().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getMainPolNo());
			if (getMasterPolNo() == null || getMasterPolNo().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMasterPolNo());
			if (getKindCode() == null || getKindCode().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getKindCode());
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getRiskCode());
			if (getRiskVersion() == null || getRiskVersion().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getRiskVersion());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getManageCom());
			if (getAgentCom() == null || getAgentCom().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getAgentCom());
			if (getAgentType() == null || getAgentType().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getAgentType());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getAgentCode());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getAgentGroup());
			if (getAgentGroup1() == null || getAgentGroup1().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getAgentGroup1());
			if (getAgentCode1() == null || getAgentCode1().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getAgentCode1());
			if (getSaleChnl() == null || getSaleChnl().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getSaleChnl());
			if (getHandler() == null || getHandler().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getHandler());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getInsuredNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getInsuredId());
			if (getInsuredName() == null || getInsuredName().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getInsuredName());
			if (getInsuredSex() == null || getInsuredSex().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getInsuredSex());
			if (getInsuredBirthday() == null || getInsuredBirthday().equals("null"))
				pstmt.setNull(28, 91);
			else
				pstmt.setDate(28, Date.valueOf(getInsuredBirthday()));
			pstmt.setInt(29, getInsuredAppAge());
			pstmt.setInt(30, getInsuredPeoples());
			if (getOccupationType() == null || getOccupationType().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getOccupationType());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getAppntNo());
			if (getAppntName() == null || getAppntName().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getAppntName());
			if (getCValiDate() == null || getCValiDate().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getCValiDate()));
			if (getSignCom() == null || getSignCom().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getSignCom());
			if (getSignDate() == null || getSignDate().equals("null"))
				pstmt.setNull(36, 91);
			else
				pstmt.setDate(36, Date.valueOf(getSignDate()));
			if (getSignTime() == null || getSignTime().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getSignTime());
			if (getFirstPayDate() == null || getFirstPayDate().equals("null"))
				pstmt.setNull(38, 91);
			else
				pstmt.setDate(38, Date.valueOf(getFirstPayDate()));
			if (getPayEndDate() == null || getPayEndDate().equals("null"))
				pstmt.setNull(39, 91);
			else
				pstmt.setDate(39, Date.valueOf(getPayEndDate()));
			if (getPaytoDate() == null || getPaytoDate().equals("null"))
				pstmt.setNull(40, 91);
			else
				pstmt.setDate(40, Date.valueOf(getPaytoDate()));
			if (getGetStartDate() == null || getGetStartDate().equals("null"))
				pstmt.setNull(41, 91);
			else
				pstmt.setDate(41, Date.valueOf(getGetStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(42, 91);
			else
				pstmt.setDate(42, Date.valueOf(getEndDate()));
			if (getAcciEndDate() == null || getAcciEndDate().equals("null"))
				pstmt.setNull(43, 91);
			else
				pstmt.setDate(43, Date.valueOf(getAcciEndDate()));
			if (getGetYearFlag() == null || getGetYearFlag().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getGetYearFlag());
			pstmt.setInt(45, getGetYear());
			if (getPayEndYearFlag() == null || getPayEndYearFlag().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getPayEndYearFlag());
			pstmt.setInt(47, getPayEndYear());
			if (getInsuYearFlag() == null || getInsuYearFlag().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getInsuYearFlag());
			pstmt.setInt(49, getInsuYear());
			if (getAcciYearFlag() == null || getAcciYearFlag().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getAcciYearFlag());
			pstmt.setInt(51, getAcciYear());
			if (getGetStartType() == null || getGetStartType().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getGetStartType());
			if (getSpecifyValiDate() == null || getSpecifyValiDate().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getSpecifyValiDate());
			if (getPayMode() == null || getPayMode().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getPayMode());
			if (getPayLocation() == null || getPayLocation().equals("null"))
				pstmt.setNull(55, 12);
			else
				pstmt.setString(55, getPayLocation());
			pstmt.setInt(56, getPayIntv());
			pstmt.setInt(57, getPayYears());
			pstmt.setInt(58, getYears());
			pstmt.setDouble(59, getManageFeeRate());
			pstmt.setDouble(60, getFloatRate());
			pstmt.setDouble(61, getPremRate());
			if (getPremToAmnt() == null || getPremToAmnt().equals("null"))
				pstmt.setNull(62, 12);
			else
				pstmt.setString(62, getPremToAmnt());
			pstmt.setDouble(63, getMult());
			pstmt.setDouble(64, getStandPrem());
			pstmt.setDouble(65, getPrem());
			pstmt.setDouble(66, getSumPrem());
			pstmt.setDouble(67, getAmnt());
			pstmt.setDouble(68, getRiskAmnt());
			pstmt.setDouble(69, getLeavingMoney());
			pstmt.setInt(70, getEndorseTimes());
			pstmt.setInt(71, getClaimTimes());
			pstmt.setInt(72, getLiveTimes());
			pstmt.setInt(73, getRenewCount());
			if (getLastGetDate() == null || getLastGetDate().equals("null"))
				pstmt.setNull(74, 91);
			else
				pstmt.setDate(74, Date.valueOf(getLastGetDate()));
			if (getLastLoanDate() == null || getLastLoanDate().equals("null"))
				pstmt.setNull(75, 91);
			else
				pstmt.setDate(75, Date.valueOf(getLastLoanDate()));
			if (getLastRegetDate() == null || getLastRegetDate().equals("null"))
				pstmt.setNull(76, 91);
			else
				pstmt.setDate(76, Date.valueOf(getLastRegetDate()));
			if (getLastEdorDate() == null || getLastEdorDate().equals("null"))
				pstmt.setNull(77, 91);
			else
				pstmt.setDate(77, Date.valueOf(getLastEdorDate()));
			if (getLastRevDate() == null || getLastRevDate().equals("null"))
				pstmt.setNull(78, 91);
			else
				pstmt.setDate(78, Date.valueOf(getLastRevDate()));
			if (getRnewFlag() == null || getRnewFlag().equals("null"))
				pstmt.setNull(79, 12);
			else
				pstmt.setString(79, getRnewFlag());
			if (getStopFlag() == null || getStopFlag().equals("null"))
				pstmt.setNull(80, 12);
			else
				pstmt.setString(80, getStopFlag());
			if (getExpiryFlag() == null || getExpiryFlag().equals("null"))
				pstmt.setNull(81, 12);
			else
				pstmt.setString(81, getExpiryFlag());
			if (getAutoPayFlag() == null || getAutoPayFlag().equals("null"))
				pstmt.setNull(82, 12);
			else
				pstmt.setString(82, getAutoPayFlag());
			if (getInterestDifFlag() == null || getInterestDifFlag().equals("null"))
				pstmt.setNull(83, 12);
			else
				pstmt.setString(83, getInterestDifFlag());
			if (getSubFlag() == null || getSubFlag().equals("null"))
				pstmt.setNull(84, 12);
			else
				pstmt.setString(84, getSubFlag());
			if (getBnfFlag() == null || getBnfFlag().equals("null"))
				pstmt.setNull(85, 12);
			else
				pstmt.setString(85, getBnfFlag());
			if (getHealthCheckFlag() == null || getHealthCheckFlag().equals("null"))
				pstmt.setNull(86, 12);
			else
				pstmt.setString(86, getHealthCheckFlag());
			if (getImpartFlag() == null || getImpartFlag().equals("null"))
				pstmt.setNull(87, 12);
			else
				pstmt.setString(87, getImpartFlag());
			if (getReinsureFlag() == null || getReinsureFlag().equals("null"))
				pstmt.setNull(88, 12);
			else
				pstmt.setString(88, getReinsureFlag());
			if (getAgentPayFlag() == null || getAgentPayFlag().equals("null"))
				pstmt.setNull(89, 12);
			else
				pstmt.setString(89, getAgentPayFlag());
			if (getAgentGetFlag() == null || getAgentGetFlag().equals("null"))
				pstmt.setNull(90, 12);
			else
				pstmt.setString(90, getAgentGetFlag());
			if (getLiveGetMode() == null || getLiveGetMode().equals("null"))
				pstmt.setNull(91, 12);
			else
				pstmt.setString(91, getLiveGetMode());
			if (getDeadGetMode() == null || getDeadGetMode().equals("null"))
				pstmt.setNull(92, 12);
			else
				pstmt.setString(92, getDeadGetMode());
			if (getBonusGetMode() == null || getBonusGetMode().equals("null"))
				pstmt.setNull(93, 12);
			else
				pstmt.setString(93, getBonusGetMode());
			if (getDeadAmntType() == null || getDeadAmntType().equals("null"))
				pstmt.setNull(94, 12);
			else
				pstmt.setString(94, getDeadAmntType());
			pstmt.setDouble(95, getTopUpPrem());
			if (getBonusMan() == null || getBonusMan().equals("null"))
				pstmt.setNull(96, 12);
			else
				pstmt.setString(96, getBonusMan());
			if (getDeadFlag() == null || getDeadFlag().equals("null"))
				pstmt.setNull(97, 12);
			else
				pstmt.setString(97, getDeadFlag());
			if (getSmokeFlag() == null || getSmokeFlag().equals("null"))
				pstmt.setNull(98, 12);
			else
				pstmt.setString(98, getSmokeFlag());
			if (getRemark() == null || getRemark().equals("null"))
				pstmt.setNull(99, 12);
			else
				pstmt.setString(99, getRemark());
			if (getApproveFlag() == null || getApproveFlag().equals("null"))
				pstmt.setNull(100, 12);
			else
				pstmt.setString(100, getApproveFlag());
			if (getApproveCode() == null || getApproveCode().equals("null"))
				pstmt.setNull(101, 12);
			else
				pstmt.setString(101, getApproveCode());
			if (getApproveDate() == null || getApproveDate().equals("null"))
				pstmt.setNull(102, 91);
			else
				pstmt.setDate(102, Date.valueOf(getApproveDate()));
			if (getApproveTime() == null || getApproveTime().equals("null"))
				pstmt.setNull(103, 12);
			else
				pstmt.setString(103, getApproveTime());
			if (getUWFlag() == null || getUWFlag().equals("null"))
				pstmt.setNull(104, 12);
			else
				pstmt.setString(104, getUWFlag());
			if (getUWCode() == null || getUWCode().equals("null"))
				pstmt.setNull(105, 12);
			else
				pstmt.setString(105, getUWCode());
			if (getUWDate() == null || getUWDate().equals("null"))
				pstmt.setNull(106, 91);
			else
				pstmt.setDate(106, Date.valueOf(getUWDate()));
			if (getUWTime() == null || getUWTime().equals("null"))
				pstmt.setNull(107, 12);
			else
				pstmt.setString(107, getUWTime());
			if (getPolApplyDate() == null || getPolApplyDate().equals("null"))
				pstmt.setNull(108, 91);
			else
				pstmt.setDate(108, Date.valueOf(getPolApplyDate()));
			if (getAppFlag() == null || getAppFlag().equals("null"))
				pstmt.setNull(109, 12);
			else
				pstmt.setString(109, getAppFlag());
			if (getSaleChnlDetail() == null || getSaleChnlDetail().equals("null"))
				pstmt.setNull(110, 12);
			else
				pstmt.setString(110, getSaleChnlDetail());
			if (getPolState() == null || getPolState().equals("null"))
				pstmt.setNull(111, 12);
			else
				pstmt.setString(111, getPolState());
			if (getStandbyFlag1() == null || getStandbyFlag1().equals("null"))
				pstmt.setNull(112, 12);
			else
				pstmt.setString(112, getStandbyFlag1());
			if (getStandbyFlag2() == null || getStandbyFlag2().equals("null"))
				pstmt.setNull(113, 12);
			else
				pstmt.setString(113, getStandbyFlag2());
			if (getStandbyFlag3() == null || getStandbyFlag3().equals("null"))
				pstmt.setNull(114, 12);
			else
				pstmt.setString(114, getStandbyFlag3());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(115, 12);
			else
				pstmt.setString(115, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(116, 91);
			else
				pstmt.setDate(116, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(117, 12);
			else
				pstmt.setString(117, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(118, 91);
			else
				pstmt.setDate(118, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(119, 12);
			else
				pstmt.setString(119, getModifyTime());
			if (getPolNo() == null || getPolNo().equals("null"))
				pstmt.setNull(120, 12);
			else
				pstmt.setString(120, getPolNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPPolDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPPol VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getGrpContNo() == null || getGrpContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getGrpContNo());
			if (getGrpPolNo() == null || getGrpPolNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getGrpPolNo());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getContNo());
			if (getProposalContNo() == null || getProposalContNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getProposalContNo());
			if (getPolNo() == null || getPolNo().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getPolNo());
			if (getProposalNo() == null || getProposalNo().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getProposalNo());
			if (getPrtNo() == null || getPrtNo().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getPrtNo());
			if (getContType() == null || getContType().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getContType());
			if (getPolTypeFlag() == null || getPolTypeFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getPolTypeFlag());
			if (getMainPolNo() == null || getMainPolNo().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getMainPolNo());
			if (getMasterPolNo() == null || getMasterPolNo().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMasterPolNo());
			if (getKindCode() == null || getKindCode().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getKindCode());
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getRiskCode());
			if (getRiskVersion() == null || getRiskVersion().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getRiskVersion());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getManageCom());
			if (getAgentCom() == null || getAgentCom().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getAgentCom());
			if (getAgentType() == null || getAgentType().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getAgentType());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getAgentCode());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getAgentGroup());
			if (getAgentGroup1() == null || getAgentGroup1().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getAgentGroup1());
			if (getAgentCode1() == null || getAgentCode1().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getAgentCode1());
			if (getSaleChnl() == null || getSaleChnl().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getSaleChnl());
			if (getHandler() == null || getHandler().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getHandler());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getInsuredNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getInsuredId());
			if (getInsuredName() == null || getInsuredName().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getInsuredName());
			if (getInsuredSex() == null || getInsuredSex().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getInsuredSex());
			if (getInsuredBirthday() == null || getInsuredBirthday().equals("null"))
				pstmt.setNull(28, 91);
			else
				pstmt.setDate(28, Date.valueOf(getInsuredBirthday()));
			pstmt.setInt(29, getInsuredAppAge());
			pstmt.setInt(30, getInsuredPeoples());
			if (getOccupationType() == null || getOccupationType().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getOccupationType());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getAppntNo());
			if (getAppntName() == null || getAppntName().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getAppntName());
			if (getCValiDate() == null || getCValiDate().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getCValiDate()));
			if (getSignCom() == null || getSignCom().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getSignCom());
			if (getSignDate() == null || getSignDate().equals("null"))
				pstmt.setNull(36, 91);
			else
				pstmt.setDate(36, Date.valueOf(getSignDate()));
			if (getSignTime() == null || getSignTime().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getSignTime());
			if (getFirstPayDate() == null || getFirstPayDate().equals("null"))
				pstmt.setNull(38, 91);
			else
				pstmt.setDate(38, Date.valueOf(getFirstPayDate()));
			if (getPayEndDate() == null || getPayEndDate().equals("null"))
				pstmt.setNull(39, 91);
			else
				pstmt.setDate(39, Date.valueOf(getPayEndDate()));
			if (getPaytoDate() == null || getPaytoDate().equals("null"))
				pstmt.setNull(40, 91);
			else
				pstmt.setDate(40, Date.valueOf(getPaytoDate()));
			if (getGetStartDate() == null || getGetStartDate().equals("null"))
				pstmt.setNull(41, 91);
			else
				pstmt.setDate(41, Date.valueOf(getGetStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(42, 91);
			else
				pstmt.setDate(42, Date.valueOf(getEndDate()));
			if (getAcciEndDate() == null || getAcciEndDate().equals("null"))
				pstmt.setNull(43, 91);
			else
				pstmt.setDate(43, Date.valueOf(getAcciEndDate()));
			if (getGetYearFlag() == null || getGetYearFlag().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getGetYearFlag());
			pstmt.setInt(45, getGetYear());
			if (getPayEndYearFlag() == null || getPayEndYearFlag().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getPayEndYearFlag());
			pstmt.setInt(47, getPayEndYear());
			if (getInsuYearFlag() == null || getInsuYearFlag().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getInsuYearFlag());
			pstmt.setInt(49, getInsuYear());
			if (getAcciYearFlag() == null || getAcciYearFlag().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getAcciYearFlag());
			pstmt.setInt(51, getAcciYear());
			if (getGetStartType() == null || getGetStartType().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getGetStartType());
			if (getSpecifyValiDate() == null || getSpecifyValiDate().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getSpecifyValiDate());
			if (getPayMode() == null || getPayMode().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getPayMode());
			if (getPayLocation() == null || getPayLocation().equals("null"))
				pstmt.setNull(55, 12);
			else
				pstmt.setString(55, getPayLocation());
			pstmt.setInt(56, getPayIntv());
			pstmt.setInt(57, getPayYears());
			pstmt.setInt(58, getYears());
			pstmt.setDouble(59, getManageFeeRate());
			pstmt.setDouble(60, getFloatRate());
			pstmt.setDouble(61, getPremRate());
			if (getPremToAmnt() == null || getPremToAmnt().equals("null"))
				pstmt.setNull(62, 12);
			else
				pstmt.setString(62, getPremToAmnt());
			pstmt.setDouble(63, getMult());
			pstmt.setDouble(64, getStandPrem());
			pstmt.setDouble(65, getPrem());
			pstmt.setDouble(66, getSumPrem());
			pstmt.setDouble(67, getAmnt());
			pstmt.setDouble(68, getRiskAmnt());
			pstmt.setDouble(69, getLeavingMoney());
			pstmt.setInt(70, getEndorseTimes());
			pstmt.setInt(71, getClaimTimes());
			pstmt.setInt(72, getLiveTimes());
			pstmt.setInt(73, getRenewCount());
			if (getLastGetDate() == null || getLastGetDate().equals("null"))
				pstmt.setNull(74, 91);
			else
				pstmt.setDate(74, Date.valueOf(getLastGetDate()));
			if (getLastLoanDate() == null || getLastLoanDate().equals("null"))
				pstmt.setNull(75, 91);
			else
				pstmt.setDate(75, Date.valueOf(getLastLoanDate()));
			if (getLastRegetDate() == null || getLastRegetDate().equals("null"))
				pstmt.setNull(76, 91);
			else
				pstmt.setDate(76, Date.valueOf(getLastRegetDate()));
			if (getLastEdorDate() == null || getLastEdorDate().equals("null"))
				pstmt.setNull(77, 91);
			else
				pstmt.setDate(77, Date.valueOf(getLastEdorDate()));
			if (getLastRevDate() == null || getLastRevDate().equals("null"))
				pstmt.setNull(78, 91);
			else
				pstmt.setDate(78, Date.valueOf(getLastRevDate()));
			if (getRnewFlag() == null || getRnewFlag().equals("null"))
				pstmt.setNull(79, 12);
			else
				pstmt.setString(79, getRnewFlag());
			if (getStopFlag() == null || getStopFlag().equals("null"))
				pstmt.setNull(80, 12);
			else
				pstmt.setString(80, getStopFlag());
			if (getExpiryFlag() == null || getExpiryFlag().equals("null"))
				pstmt.setNull(81, 12);
			else
				pstmt.setString(81, getExpiryFlag());
			if (getAutoPayFlag() == null || getAutoPayFlag().equals("null"))
				pstmt.setNull(82, 12);
			else
				pstmt.setString(82, getAutoPayFlag());
			if (getInterestDifFlag() == null || getInterestDifFlag().equals("null"))
				pstmt.setNull(83, 12);
			else
				pstmt.setString(83, getInterestDifFlag());
			if (getSubFlag() == null || getSubFlag().equals("null"))
				pstmt.setNull(84, 12);
			else
				pstmt.setString(84, getSubFlag());
			if (getBnfFlag() == null || getBnfFlag().equals("null"))
				pstmt.setNull(85, 12);
			else
				pstmt.setString(85, getBnfFlag());
			if (getHealthCheckFlag() == null || getHealthCheckFlag().equals("null"))
				pstmt.setNull(86, 12);
			else
				pstmt.setString(86, getHealthCheckFlag());
			if (getImpartFlag() == null || getImpartFlag().equals("null"))
				pstmt.setNull(87, 12);
			else
				pstmt.setString(87, getImpartFlag());
			if (getReinsureFlag() == null || getReinsureFlag().equals("null"))
				pstmt.setNull(88, 12);
			else
				pstmt.setString(88, getReinsureFlag());
			if (getAgentPayFlag() == null || getAgentPayFlag().equals("null"))
				pstmt.setNull(89, 12);
			else
				pstmt.setString(89, getAgentPayFlag());
			if (getAgentGetFlag() == null || getAgentGetFlag().equals("null"))
				pstmt.setNull(90, 12);
			else
				pstmt.setString(90, getAgentGetFlag());
			if (getLiveGetMode() == null || getLiveGetMode().equals("null"))
				pstmt.setNull(91, 12);
			else
				pstmt.setString(91, getLiveGetMode());
			if (getDeadGetMode() == null || getDeadGetMode().equals("null"))
				pstmt.setNull(92, 12);
			else
				pstmt.setString(92, getDeadGetMode());
			if (getBonusGetMode() == null || getBonusGetMode().equals("null"))
				pstmt.setNull(93, 12);
			else
				pstmt.setString(93, getBonusGetMode());
			if (getDeadAmntType() == null || getDeadAmntType().equals("null"))
				pstmt.setNull(94, 12);
			else
				pstmt.setString(94, getDeadAmntType());
			pstmt.setDouble(95, getTopUpPrem());
			if (getBonusMan() == null || getBonusMan().equals("null"))
				pstmt.setNull(96, 12);
			else
				pstmt.setString(96, getBonusMan());
			if (getDeadFlag() == null || getDeadFlag().equals("null"))
				pstmt.setNull(97, 12);
			else
				pstmt.setString(97, getDeadFlag());
			if (getSmokeFlag() == null || getSmokeFlag().equals("null"))
				pstmt.setNull(98, 12);
			else
				pstmt.setString(98, getSmokeFlag());
			if (getRemark() == null || getRemark().equals("null"))
				pstmt.setNull(99, 12);
			else
				pstmt.setString(99, getRemark());
			if (getApproveFlag() == null || getApproveFlag().equals("null"))
				pstmt.setNull(100, 12);
			else
				pstmt.setString(100, getApproveFlag());
			if (getApproveCode() == null || getApproveCode().equals("null"))
				pstmt.setNull(101, 12);
			else
				pstmt.setString(101, getApproveCode());
			if (getApproveDate() == null || getApproveDate().equals("null"))
				pstmt.setNull(102, 91);
			else
				pstmt.setDate(102, Date.valueOf(getApproveDate()));
			if (getApproveTime() == null || getApproveTime().equals("null"))
				pstmt.setNull(103, 12);
			else
				pstmt.setString(103, getApproveTime());
			if (getUWFlag() == null || getUWFlag().equals("null"))
				pstmt.setNull(104, 12);
			else
				pstmt.setString(104, getUWFlag());
			if (getUWCode() == null || getUWCode().equals("null"))
				pstmt.setNull(105, 12);
			else
				pstmt.setString(105, getUWCode());
			if (getUWDate() == null || getUWDate().equals("null"))
				pstmt.setNull(106, 91);
			else
				pstmt.setDate(106, Date.valueOf(getUWDate()));
			if (getUWTime() == null || getUWTime().equals("null"))
				pstmt.setNull(107, 12);
			else
				pstmt.setString(107, getUWTime());
			if (getPolApplyDate() == null || getPolApplyDate().equals("null"))
				pstmt.setNull(108, 91);
			else
				pstmt.setDate(108, Date.valueOf(getPolApplyDate()));
			if (getAppFlag() == null || getAppFlag().equals("null"))
				pstmt.setNull(109, 12);
			else
				pstmt.setString(109, getAppFlag());
			if (getSaleChnlDetail() == null || getSaleChnlDetail().equals("null"))
				pstmt.setNull(110, 12);
			else
				pstmt.setString(110, getSaleChnlDetail());
			if (getPolState() == null || getPolState().equals("null"))
				pstmt.setNull(111, 12);
			else
				pstmt.setString(111, getPolState());
			if (getStandbyFlag1() == null || getStandbyFlag1().equals("null"))
				pstmt.setNull(112, 12);
			else
				pstmt.setString(112, getStandbyFlag1());
			if (getStandbyFlag2() == null || getStandbyFlag2().equals("null"))
				pstmt.setNull(113, 12);
			else
				pstmt.setString(113, getStandbyFlag2());
			if (getStandbyFlag3() == null || getStandbyFlag3().equals("null"))
				pstmt.setNull(114, 12);
			else
				pstmt.setString(114, getStandbyFlag3());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(115, 12);
			else
				pstmt.setString(115, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(116, 91);
			else
				pstmt.setDate(116, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(117, 12);
			else
				pstmt.setString(117, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(118, 91);
			else
				pstmt.setDate(118, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(119, 12);
			else
				pstmt.setString(119, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPPolDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPPol WHERE  PolNo = ?", 1003, 1007);
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
		tError.moduleName = "LNPPolDB";
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
				tError.moduleName = "LNPPolDB";
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

	public LNPPolSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPPolSet aLNPPolSet = new LNPPolSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPPol");
			LNPPolSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPPolSchema s1;
			for (; rs.next(); aLNPPolSet.add(s1))
			{
				i++;
				s1 = new LNPPolSchema();
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
			tError.moduleName = "LNPPolDB";
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
		return aLNPPolSet;
	}

	public LNPPolSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPPolSet aLNPPolSet = new LNPPolSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPPolSchema s1;
			for (; rs.next(); aLNPPolSet.add(s1))
			{
				i++;
				s1 = new LNPPolSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPPolDB";
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
			tError.moduleName = "LNPPolDB";
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
		return aLNPPolSet;
	}

	public LNPPolSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPPolSet aLNPPolSet = new LNPPolSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPPol");
			LNPPolSchema aSchema = getSchema();
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
				LNPPolSchema s1 = new LNPPolSchema();
				s1.setSchema(rs, i);
				aLNPPolSet.add(s1);
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
			tError.moduleName = "LNPPolDB";
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
		return aLNPPolSet;
	}

	public LNPPolSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPPolSet aLNPPolSet = new LNPPolSet();
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
				LNPPolSchema s1 = new LNPPolSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPPolDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPPolSet.add(s1);
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
			tError.moduleName = "LNPPolDB";
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
		return aLNPPolSet;
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
				SQLString sqlObj = new SQLString("LNPPol");
				LNPPolSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPPol ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPPolDB";
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
				tError.moduleName = "LNPPolDB";
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
			tError.moduleName = "LNPPolDB";
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
			tError.moduleName = "LNPPolDB";
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
			tError.moduleName = "LNPPolDB";
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
			tError.moduleName = "LNPPolDB";
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

	public LNPPolSet getData()
	{
		int tCount = 0;
		LNPPolSet tLNPPolSet = new LNPPolSet();
		LNPPolSchema tLNPPolSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPolDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPPolSchema = new LNPPolSchema();
			tLNPPolSchema.setSchema(mResultSet, 1);
			tLNPPolSet.add(tLNPPolSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPPolSchema = new LNPPolSchema();
					tLNPPolSchema.setSchema(mResultSet, 1);
					tLNPPolSet.add(tLNPPolSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPPolDB";
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
		return tLNPPolSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPPolDB";
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
			tError.moduleName = "LNPPolDB";
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
				tError.moduleName = "LNPPolDB";
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
			tError.moduleName = "LNPPolDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
