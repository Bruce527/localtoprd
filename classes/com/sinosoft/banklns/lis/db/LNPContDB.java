// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPContDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.vschema.LNPContSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPContDB extends LNPContSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPContDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPCont");
		mflag = true;
	}

	public LNPContDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPCont");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPContSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPContDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPContSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPContDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCont WHERE  ContNo = ?");
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getContNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPContDB";
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
			pstmt = con.prepareStatement("UPDATE LNPCont SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , MainPolNo = ? , ContType = ? , FamilyType = ? , FamilyID = ? , PolType = ? , SugNo = ? , CardFlag = ? , ManageCom = ? , ExecuteCom = ? , AgentCom = ? , AgentCode = ? , AgentGroup = ? , AgentCode1 = ? , AgentGroup1 = ? , AgentType = ? , SaleChnl = ? , Handler = ? , Password = ? , AppntNo = ? , AppntId = ? , AppntName = ? , AppntSex = ? , AppntBirthday = ? , AppntIDType = ? , AppntIDNo = ? , InsuredNo = ? , InsuredId = ? , InsuredName = ? , InsuredSex = ? , InsuredBirthday = ? , InsuredIDType = ? , InsuredIDNo = ? , PayIntv = ? , PayMode = ? , PayLocation = ? , DisputedFlag = ? , OutPayFlag = ? , GetPolMode = ? , SignCom = ? , SignDate = ? , SignTime = ? , ConsignNo = ? , BankCode = ? , BankAccNo = ? , AccName = ? , PrintCount = ? , LostTimes = ? , Lang = ? , Currency = ? , Remark = ? , Peoples = ? , Mult = ? , Prem = ? , Amnt = ? , SumPrem = ? , Dif = ? , PaytoDate = ? , FirstPayDate = ? , CValiDate = ? , PSignDate = ? , PValiDate = ? , InputOperator = ? , InputDate = ? , InputTime = ? , ApproveFlag = ? , ApproveCode = ? , ApproveDate = ? , ApproveTime = ? , UWFlag = ? , UWOperator = ? , UWDate = ? , UWTime = ? , AppFlag = ? , PolApplyDate = ? , GetPolDate = ? , GetPolTime = ? , CustomGetPolDate = ? , State = ? , SaleChnlDetail = ? , ProposalType = ? , Editstate = ? , CInValiDate = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
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
			if (getPrtNo() == null || getPrtNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPrtNo());
			if (getMainPolNo() == null || getMainPolNo().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getMainPolNo());
			if (getContType() == null || getContType().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getContType());
			if (getFamilyType() == null || getFamilyType().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getFamilyType());
			if (getFamilyID() == null || getFamilyID().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getFamilyID());
			if (getPolType() == null || getPolType().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getPolType());
			if (getSugNo() == null || getSugNo().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getSugNo());
			if (getCardFlag() == null || getCardFlag().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getCardFlag());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getManageCom());
			if (getExecuteCom() == null || getExecuteCom().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getExecuteCom());
			if (getAgentCom() == null || getAgentCom().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getAgentCom());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getAgentCode());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getAgentGroup());
			if (getAgentCode1() == null || getAgentCode1().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getAgentCode1());
			if (getAgentGroup1() == null || getAgentGroup1().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getAgentGroup1());
			if (getAgentType() == null || getAgentType().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getAgentType());
			if (getSaleChnl() == null || getSaleChnl().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getSaleChnl());
			if (getHandler() == null || getHandler().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getHandler());
			if (getPassword() == null || getPassword().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getPassword());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getAppntNo());
			if (getAppntId() == null || getAppntId().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getAppntId());
			if (getAppntName() == null || getAppntName().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getAppntName());
			if (getAppntSex() == null || getAppntSex().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getAppntSex());
			if (getAppntBirthday() == null || getAppntBirthday().equals("null"))
				pstmt.setNull(27, 91);
			else
				pstmt.setDate(27, Date.valueOf(getAppntBirthday()));
			if (getAppntIDType() == null || getAppntIDType().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getAppntIDType());
			if (getAppntIDNo() == null || getAppntIDNo().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getAppntIDNo());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getInsuredNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getInsuredId());
			if (getInsuredName() == null || getInsuredName().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getInsuredName());
			if (getInsuredSex() == null || getInsuredSex().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getInsuredSex());
			if (getInsuredBirthday() == null || getInsuredBirthday().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getInsuredBirthday()));
			if (getInsuredIDType() == null || getInsuredIDType().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getInsuredIDType());
			if (getInsuredIDNo() == null || getInsuredIDNo().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getInsuredIDNo());
			pstmt.setInt(37, getPayIntv());
			if (getPayMode() == null || getPayMode().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getPayMode());
			if (getPayLocation() == null || getPayLocation().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getPayLocation());
			if (getDisputedFlag() == null || getDisputedFlag().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getDisputedFlag());
			if (getOutPayFlag() == null || getOutPayFlag().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getOutPayFlag());
			if (getGetPolMode() == null || getGetPolMode().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getGetPolMode());
			if (getSignCom() == null || getSignCom().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getSignCom());
			if (getSignDate() == null || getSignDate().equals("null"))
				pstmt.setNull(44, 91);
			else
				pstmt.setDate(44, Date.valueOf(getSignDate()));
			if (getSignTime() == null || getSignTime().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getSignTime());
			if (getConsignNo() == null || getConsignNo().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getConsignNo());
			if (getBankCode() == null || getBankCode().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getBankCode());
			if (getBankAccNo() == null || getBankAccNo().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getBankAccNo());
			if (getAccName() == null || getAccName().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getAccName());
			pstmt.setInt(50, getPrintCount());
			pstmt.setInt(51, getLostTimes());
			if (getLang() == null || getLang().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getLang());
			if (getCurrency() == null || getCurrency().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getCurrency());
			if (getRemark() == null || getRemark().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getRemark());
			pstmt.setInt(55, getPeoples());
			pstmt.setDouble(56, getMult());
			pstmt.setDouble(57, getPrem());
			pstmt.setDouble(58, getAmnt());
			pstmt.setDouble(59, getSumPrem());
			pstmt.setDouble(60, getDif());
			if (getPaytoDate() == null || getPaytoDate().equals("null"))
				pstmt.setNull(61, 91);
			else
				pstmt.setDate(61, Date.valueOf(getPaytoDate()));
			if (getFirstPayDate() == null || getFirstPayDate().equals("null"))
				pstmt.setNull(62, 91);
			else
				pstmt.setDate(62, Date.valueOf(getFirstPayDate()));
			if (getCValiDate() == null || getCValiDate().equals("null"))
				pstmt.setNull(63, 91);
			else
				pstmt.setDate(63, Date.valueOf(getCValiDate()));
			if (getPSignDate() == null || getPSignDate().equals("null"))
				pstmt.setNull(64, 91);
			else
				pstmt.setDate(64, Date.valueOf(getPSignDate()));
			if (getPValiDate() == null || getPValiDate().equals("null"))
				pstmt.setNull(65, 91);
			else
				pstmt.setDate(65, Date.valueOf(getPValiDate()));
			if (getInputOperator() == null || getInputOperator().equals("null"))
				pstmt.setNull(66, 12);
			else
				pstmt.setString(66, getInputOperator());
			if (getInputDate() == null || getInputDate().equals("null"))
				pstmt.setNull(67, 91);
			else
				pstmt.setDate(67, Date.valueOf(getInputDate()));
			if (getInputTime() == null || getInputTime().equals("null"))
				pstmt.setNull(68, 12);
			else
				pstmt.setString(68, getInputTime());
			if (getApproveFlag() == null || getApproveFlag().equals("null"))
				pstmt.setNull(69, 12);
			else
				pstmt.setString(69, getApproveFlag());
			if (getApproveCode() == null || getApproveCode().equals("null"))
				pstmt.setNull(70, 12);
			else
				pstmt.setString(70, getApproveCode());
			if (getApproveDate() == null || getApproveDate().equals("null"))
				pstmt.setNull(71, 91);
			else
				pstmt.setDate(71, Date.valueOf(getApproveDate()));
			if (getApproveTime() == null || getApproveTime().equals("null"))
				pstmt.setNull(72, 12);
			else
				pstmt.setString(72, getApproveTime());
			if (getUWFlag() == null || getUWFlag().equals("null"))
				pstmt.setNull(73, 12);
			else
				pstmt.setString(73, getUWFlag());
			if (getUWOperator() == null || getUWOperator().equals("null"))
				pstmt.setNull(74, 12);
			else
				pstmt.setString(74, getUWOperator());
			if (getUWDate() == null || getUWDate().equals("null"))
				pstmt.setNull(75, 91);
			else
				pstmt.setDate(75, Date.valueOf(getUWDate()));
			if (getUWTime() == null || getUWTime().equals("null"))
				pstmt.setNull(76, 12);
			else
				pstmt.setString(76, getUWTime());
			if (getAppFlag() == null || getAppFlag().equals("null"))
				pstmt.setNull(77, 12);
			else
				pstmt.setString(77, getAppFlag());
			if (getPolApplyDate() == null || getPolApplyDate().equals("null"))
				pstmt.setNull(78, 91);
			else
				pstmt.setDate(78, Date.valueOf(getPolApplyDate()));
			if (getGetPolDate() == null || getGetPolDate().equals("null"))
				pstmt.setNull(79, 91);
			else
				pstmt.setDate(79, Date.valueOf(getGetPolDate()));
			if (getGetPolTime() == null || getGetPolTime().equals("null"))
				pstmt.setNull(80, 12);
			else
				pstmt.setString(80, getGetPolTime());
			if (getCustomGetPolDate() == null || getCustomGetPolDate().equals("null"))
				pstmt.setNull(81, 91);
			else
				pstmt.setDate(81, Date.valueOf(getCustomGetPolDate()));
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(82, 12);
			else
				pstmt.setString(82, getState());
			if (getSaleChnlDetail() == null || getSaleChnlDetail().equals("null"))
				pstmt.setNull(83, 12);
			else
				pstmt.setString(83, getSaleChnlDetail());
			if (getProposalType() == null || getProposalType().equals("null"))
				pstmt.setNull(84, 12);
			else
				pstmt.setString(84, getProposalType());
			if (getEditstate() == null || getEditstate().equals("null"))
				pstmt.setNull(85, 12);
			else
				pstmt.setString(85, getEditstate());
			if (getCInValiDate() == null || getCInValiDate().equals("null"))
				pstmt.setNull(86, 91);
			else
				pstmt.setDate(86, Date.valueOf(getCInValiDate()));
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(87, 12);
			else
				pstmt.setString(87, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(88, 91);
			else
				pstmt.setDate(88, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(89, 12);
			else
				pstmt.setString(89, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(90, 91);
			else
				pstmt.setDate(90, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(91, 12);
			else
				pstmt.setString(91, getModifyTime());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(92, 12);
			else
				pstmt.setString(92, getContNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPContDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCont VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			if (getPrtNo() == null || getPrtNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPrtNo());
			if (getMainPolNo() == null || getMainPolNo().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getMainPolNo());
			if (getContType() == null || getContType().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getContType());
			if (getFamilyType() == null || getFamilyType().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getFamilyType());
			if (getFamilyID() == null || getFamilyID().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getFamilyID());
			if (getPolType() == null || getPolType().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getPolType());
			if (getSugNo() == null || getSugNo().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getSugNo());
			if (getCardFlag() == null || getCardFlag().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getCardFlag());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getManageCom());
			if (getExecuteCom() == null || getExecuteCom().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getExecuteCom());
			if (getAgentCom() == null || getAgentCom().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getAgentCom());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getAgentCode());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getAgentGroup());
			if (getAgentCode1() == null || getAgentCode1().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getAgentCode1());
			if (getAgentGroup1() == null || getAgentGroup1().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getAgentGroup1());
			if (getAgentType() == null || getAgentType().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getAgentType());
			if (getSaleChnl() == null || getSaleChnl().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getSaleChnl());
			if (getHandler() == null || getHandler().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getHandler());
			if (getPassword() == null || getPassword().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getPassword());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getAppntNo());
			if (getAppntId() == null || getAppntId().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getAppntId());
			if (getAppntName() == null || getAppntName().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getAppntName());
			if (getAppntSex() == null || getAppntSex().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getAppntSex());
			if (getAppntBirthday() == null || getAppntBirthday().equals("null"))
				pstmt.setNull(27, 91);
			else
				pstmt.setDate(27, Date.valueOf(getAppntBirthday()));
			if (getAppntIDType() == null || getAppntIDType().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getAppntIDType());
			if (getAppntIDNo() == null || getAppntIDNo().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getAppntIDNo());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getInsuredNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getInsuredId());
			if (getInsuredName() == null || getInsuredName().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getInsuredName());
			if (getInsuredSex() == null || getInsuredSex().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getInsuredSex());
			if (getInsuredBirthday() == null || getInsuredBirthday().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getInsuredBirthday()));
			if (getInsuredIDType() == null || getInsuredIDType().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getInsuredIDType());
			if (getInsuredIDNo() == null || getInsuredIDNo().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getInsuredIDNo());
			pstmt.setInt(37, getPayIntv());
			if (getPayMode() == null || getPayMode().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getPayMode());
			if (getPayLocation() == null || getPayLocation().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getPayLocation());
			if (getDisputedFlag() == null || getDisputedFlag().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getDisputedFlag());
			if (getOutPayFlag() == null || getOutPayFlag().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getOutPayFlag());
			if (getGetPolMode() == null || getGetPolMode().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getGetPolMode());
			if (getSignCom() == null || getSignCom().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getSignCom());
			if (getSignDate() == null || getSignDate().equals("null"))
				pstmt.setNull(44, 91);
			else
				pstmt.setDate(44, Date.valueOf(getSignDate()));
			if (getSignTime() == null || getSignTime().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getSignTime());
			if (getConsignNo() == null || getConsignNo().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getConsignNo());
			if (getBankCode() == null || getBankCode().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getBankCode());
			if (getBankAccNo() == null || getBankAccNo().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getBankAccNo());
			if (getAccName() == null || getAccName().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getAccName());
			pstmt.setInt(50, getPrintCount());
			pstmt.setInt(51, getLostTimes());
			if (getLang() == null || getLang().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getLang());
			if (getCurrency() == null || getCurrency().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getCurrency());
			if (getRemark() == null || getRemark().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getRemark());
			pstmt.setInt(55, getPeoples());
			pstmt.setDouble(56, getMult());
			pstmt.setDouble(57, getPrem());
			pstmt.setDouble(58, getAmnt());
			pstmt.setDouble(59, getSumPrem());
			pstmt.setDouble(60, getDif());
			if (getPaytoDate() == null || getPaytoDate().equals("null"))
				pstmt.setNull(61, 91);
			else
				pstmt.setDate(61, Date.valueOf(getPaytoDate()));
			if (getFirstPayDate() == null || getFirstPayDate().equals("null"))
				pstmt.setNull(62, 91);
			else
				pstmt.setDate(62, Date.valueOf(getFirstPayDate()));
			if (getCValiDate() == null || getCValiDate().equals("null"))
				pstmt.setNull(63, 91);
			else
				pstmt.setDate(63, Date.valueOf(getCValiDate()));
			if (getPSignDate() == null || getPSignDate().equals("null"))
				pstmt.setNull(64, 91);
			else
				pstmt.setDate(64, Date.valueOf(getPSignDate()));
			if (getPValiDate() == null || getPValiDate().equals("null"))
				pstmt.setNull(65, 91);
			else
				pstmt.setDate(65, Date.valueOf(getPValiDate()));
			if (getInputOperator() == null || getInputOperator().equals("null"))
				pstmt.setNull(66, 12);
			else
				pstmt.setString(66, getInputOperator());
			if (getInputDate() == null || getInputDate().equals("null"))
				pstmt.setNull(67, 91);
			else
				pstmt.setDate(67, Date.valueOf(getInputDate()));
			if (getInputTime() == null || getInputTime().equals("null"))
				pstmt.setNull(68, 12);
			else
				pstmt.setString(68, getInputTime());
			if (getApproveFlag() == null || getApproveFlag().equals("null"))
				pstmt.setNull(69, 12);
			else
				pstmt.setString(69, getApproveFlag());
			if (getApproveCode() == null || getApproveCode().equals("null"))
				pstmt.setNull(70, 12);
			else
				pstmt.setString(70, getApproveCode());
			if (getApproveDate() == null || getApproveDate().equals("null"))
				pstmt.setNull(71, 91);
			else
				pstmt.setDate(71, Date.valueOf(getApproveDate()));
			if (getApproveTime() == null || getApproveTime().equals("null"))
				pstmt.setNull(72, 12);
			else
				pstmt.setString(72, getApproveTime());
			if (getUWFlag() == null || getUWFlag().equals("null"))
				pstmt.setNull(73, 12);
			else
				pstmt.setString(73, getUWFlag());
			if (getUWOperator() == null || getUWOperator().equals("null"))
				pstmt.setNull(74, 12);
			else
				pstmt.setString(74, getUWOperator());
			if (getUWDate() == null || getUWDate().equals("null"))
				pstmt.setNull(75, 91);
			else
				pstmt.setDate(75, Date.valueOf(getUWDate()));
			if (getUWTime() == null || getUWTime().equals("null"))
				pstmt.setNull(76, 12);
			else
				pstmt.setString(76, getUWTime());
			if (getAppFlag() == null || getAppFlag().equals("null"))
				pstmt.setNull(77, 12);
			else
				pstmt.setString(77, getAppFlag());
			if (getPolApplyDate() == null || getPolApplyDate().equals("null"))
				pstmt.setNull(78, 91);
			else
				pstmt.setDate(78, Date.valueOf(getPolApplyDate()));
			if (getGetPolDate() == null || getGetPolDate().equals("null"))
				pstmt.setNull(79, 91);
			else
				pstmt.setDate(79, Date.valueOf(getGetPolDate()));
			if (getGetPolTime() == null || getGetPolTime().equals("null"))
				pstmt.setNull(80, 12);
			else
				pstmt.setString(80, getGetPolTime());
			if (getCustomGetPolDate() == null || getCustomGetPolDate().equals("null"))
				pstmt.setNull(81, 91);
			else
				pstmt.setDate(81, Date.valueOf(getCustomGetPolDate()));
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(82, 12);
			else
				pstmt.setString(82, getState());
			if (getSaleChnlDetail() == null || getSaleChnlDetail().equals("null"))
				pstmt.setNull(83, 12);
			else
				pstmt.setString(83, getSaleChnlDetail());
			if (getProposalType() == null || getProposalType().equals("null"))
				pstmt.setNull(84, 12);
			else
				pstmt.setString(84, getProposalType());
			if (getEditstate() == null || getEditstate().equals("null"))
				pstmt.setNull(85, 12);
			else
				pstmt.setString(85, getEditstate());
			if (getCInValiDate() == null || getCInValiDate().equals("null"))
				pstmt.setNull(86, 91);
			else
				pstmt.setDate(86, Date.valueOf(getCInValiDate()));
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(87, 12);
			else
				pstmt.setString(87, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(88, 91);
			else
				pstmt.setDate(88, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(89, 12);
			else
				pstmt.setString(89, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(90, 91);
			else
				pstmt.setDate(90, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(91, 12);
			else
				pstmt.setString(91, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPContDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPCont WHERE  ContNo = ?", 1003, 1007);
		if (getContNo() == null || getContNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getContNo());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "LNPContDB";
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
				tError.moduleName = "LNPContDB";
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

	public LNPContSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPContSet aLNPContSet = new LNPContSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPCont");
			LNPContSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPContSchema s1;
			for (; rs.next(); aLNPContSet.add(s1))
			{
				i++;
				s1 = new LNPContSchema();
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
			tError.moduleName = "LNPContDB";
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
		return aLNPContSet;
	}

	public LNPContSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPContSet aLNPContSet = new LNPContSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPContSchema s1;
			for (; rs.next(); aLNPContSet.add(s1))
			{
				i++;
				s1 = new LNPContSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPContDB";
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
			tError.moduleName = "LNPContDB";
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
		return aLNPContSet;
	}

	public LNPContSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPContSet aLNPContSet = new LNPContSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPCont");
			LNPContSchema aSchema = getSchema();
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
				LNPContSchema s1 = new LNPContSchema();
				s1.setSchema(rs, i);
				aLNPContSet.add(s1);
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
			tError.moduleName = "LNPContDB";
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
		return aLNPContSet;
	}

	public LNPContSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPContSet aLNPContSet = new LNPContSet();
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
				LNPContSchema s1 = new LNPContSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPContDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPContSet.add(s1);
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
			tError.moduleName = "LNPContDB";
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
		return aLNPContSet;
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
				SQLString sqlObj = new SQLString("LNPCont");
				LNPContSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPCont ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPContDB";
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
				tError.moduleName = "LNPContDB";
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
			tError.moduleName = "LNPContDB";
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
			tError.moduleName = "LNPContDB";
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
			tError.moduleName = "LNPContDB";
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
			tError.moduleName = "LNPContDB";
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

	public LNPContSet getData()
	{
		int tCount = 0;
		LNPContSet tLNPContSet = new LNPContSet();
		LNPContSchema tLNPContSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPContDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPContSchema = new LNPContSchema();
			tLNPContSchema.setSchema(mResultSet, 1);
			tLNPContSet.add(tLNPContSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPContSchema = new LNPContSchema();
					tLNPContSchema.setSchema(mResultSet, 1);
					tLNPContSet.add(tLNPContSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPContDB";
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
		return tLNPContSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPContDB";
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
			tError.moduleName = "LNPContDB";
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
				tError.moduleName = "LNPContDB";
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
			tError.moduleName = "LNPContDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
