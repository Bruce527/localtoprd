// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPContDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.vschema.LNPContSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPContDBSet extends LNPContSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPContDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPCont");
		mflag = true;
	}

	public LNPContDBSet()
	{
		mflag = false;
		db = new DBOper("LNPCont");
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
			tError.moduleName = "LNPContDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "ÓÐÎó!";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCont WHERE  ContNo = ?");
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
			tError.moduleName = "LNPContDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPCont SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , MainPolNo = ? , ContType = ? , FamilyType = ? , FamilyID = ? , PolType = ? , SugNo = ? , CardFlag = ? , ManageCom = ? , ExecuteCom = ? , AgentCom = ? , AgentCode = ? , AgentGroup = ? , AgentCode1 = ? , AgentGroup1 = ? , AgentType = ? , SaleChnl = ? , Handler = ? , Password = ? , AppntNo = ? , AppntId = ? , AppntName = ? , AppntSex = ? , AppntBirthday = ? , AppntIDType = ? , AppntIDNo = ? , InsuredNo = ? , InsuredId = ? , InsuredName = ? , InsuredSex = ? , InsuredBirthday = ? , InsuredIDType = ? , InsuredIDNo = ? , PayIntv = ? , PayMode = ? , PayLocation = ? , DisputedFlag = ? , OutPayFlag = ? , GetPolMode = ? , SignCom = ? , SignDate = ? , SignTime = ? , ConsignNo = ? , BankCode = ? , BankAccNo = ? , AccName = ? , PrintCount = ? , LostTimes = ? , Lang = ? , Currency = ? , Remark = ? , Peoples = ? , Mult = ? , Prem = ? , Amnt = ? , SumPrem = ? , Dif = ? , PaytoDate = ? , FirstPayDate = ? , CValiDate = ? , PSignDate = ? , PValiDate = ? , InputOperator = ? , InputDate = ? , InputTime = ? , ApproveFlag = ? , ApproveCode = ? , ApproveDate = ? , ApproveTime = ? , UWFlag = ? , UWOperator = ? , UWDate = ? , UWTime = ? , AppFlag = ? , PolApplyDate = ? , GetPolDate = ? , GetPolTime = ? , CustomGetPolDate = ? , State = ? , SaleChnlDetail = ? , ProposalType = ? , Editstate = ? , CInValiDate = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
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
				if (get(i).getMainPolNo() == null || get(i).getMainPolNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMainPolNo());
				if (get(i).getContType() == null || get(i).getContType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getContType());
				if (get(i).getFamilyType() == null || get(i).getFamilyType().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getFamilyType());
				if (get(i).getFamilyID() == null || get(i).getFamilyID().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getFamilyID());
				if (get(i).getPolType() == null || get(i).getPolType().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getPolType());
				if (get(i).getSugNo() == null || get(i).getSugNo().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getSugNo());
				if (get(i).getCardFlag() == null || get(i).getCardFlag().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCardFlag());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getManageCom());
				if (get(i).getExecuteCom() == null || get(i).getExecuteCom().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getExecuteCom());
				if (get(i).getAgentCom() == null || get(i).getAgentCom().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getAgentCom());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getAgentCode());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAgentGroup());
				if (get(i).getAgentCode1() == null || get(i).getAgentCode1().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getAgentCode1());
				if (get(i).getAgentGroup1() == null || get(i).getAgentGroup1().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getAgentGroup1());
				if (get(i).getAgentType() == null || get(i).getAgentType().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getAgentType());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getSaleChnl());
				if (get(i).getHandler() == null || get(i).getHandler().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getHandler());
				if (get(i).getPassword() == null || get(i).getPassword().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getPassword());
				if (get(i).getAppntNo() == null || get(i).getAppntNo().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getAppntNo());
				if (get(i).getAppntId() == null || get(i).getAppntId().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getAppntId());
				if (get(i).getAppntName() == null || get(i).getAppntName().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getAppntName());
				if (get(i).getAppntSex() == null || get(i).getAppntSex().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getAppntSex());
				if (get(i).getAppntBirthday() == null || get(i).getAppntBirthday().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getAppntBirthday()));
				if (get(i).getAppntIDType() == null || get(i).getAppntIDType().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getAppntIDType());
				if (get(i).getAppntIDNo() == null || get(i).getAppntIDNo().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getAppntIDNo());
				if (get(i).getInsuredNo() == null || get(i).getInsuredNo().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getInsuredNo());
				if (get(i).getInsuredId() == null || get(i).getInsuredId().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getInsuredId());
				if (get(i).getInsuredName() == null || get(i).getInsuredName().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getInsuredName());
				if (get(i).getInsuredSex() == null || get(i).getInsuredSex().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getInsuredSex());
				if (get(i).getInsuredBirthday() == null || get(i).getInsuredBirthday().equals("null"))
					pstmt.setDate(34, null);
				else
					pstmt.setDate(34, Date.valueOf(get(i).getInsuredBirthday()));
				if (get(i).getInsuredIDType() == null || get(i).getInsuredIDType().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getInsuredIDType());
				if (get(i).getInsuredIDNo() == null || get(i).getInsuredIDNo().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getInsuredIDNo());
				pstmt.setInt(37, get(i).getPayIntv());
				if (get(i).getPayMode() == null || get(i).getPayMode().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getPayMode());
				if (get(i).getPayLocation() == null || get(i).getPayLocation().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getPayLocation());
				if (get(i).getDisputedFlag() == null || get(i).getDisputedFlag().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getDisputedFlag());
				if (get(i).getOutPayFlag() == null || get(i).getOutPayFlag().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getOutPayFlag());
				if (get(i).getGetPolMode() == null || get(i).getGetPolMode().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getGetPolMode());
				if (get(i).getSignCom() == null || get(i).getSignCom().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getSignCom());
				if (get(i).getSignDate() == null || get(i).getSignDate().equals("null"))
					pstmt.setDate(44, null);
				else
					pstmt.setDate(44, Date.valueOf(get(i).getSignDate()));
				if (get(i).getSignTime() == null || get(i).getSignTime().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getSignTime());
				if (get(i).getConsignNo() == null || get(i).getConsignNo().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getConsignNo());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getBankAccNo());
				if (get(i).getAccName() == null || get(i).getAccName().equals("null"))
					pstmt.setString(49, null);
				else
					pstmt.setString(49, get(i).getAccName());
				pstmt.setInt(50, get(i).getPrintCount());
				pstmt.setInt(51, get(i).getLostTimes());
				if (get(i).getLang() == null || get(i).getLang().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getLang());
				if (get(i).getCurrency() == null || get(i).getCurrency().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getCurrency());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getRemark());
				pstmt.setInt(55, get(i).getPeoples());
				pstmt.setDouble(56, get(i).getMult());
				pstmt.setDouble(57, get(i).getPrem());
				pstmt.setDouble(58, get(i).getAmnt());
				pstmt.setDouble(59, get(i).getSumPrem());
				pstmt.setDouble(60, get(i).getDif());
				if (get(i).getPaytoDate() == null || get(i).getPaytoDate().equals("null"))
					pstmt.setDate(61, null);
				else
					pstmt.setDate(61, Date.valueOf(get(i).getPaytoDate()));
				if (get(i).getFirstPayDate() == null || get(i).getFirstPayDate().equals("null"))
					pstmt.setDate(62, null);
				else
					pstmt.setDate(62, Date.valueOf(get(i).getFirstPayDate()));
				if (get(i).getCValiDate() == null || get(i).getCValiDate().equals("null"))
					pstmt.setDate(63, null);
				else
					pstmt.setDate(63, Date.valueOf(get(i).getCValiDate()));
				if (get(i).getPSignDate() == null || get(i).getPSignDate().equals("null"))
					pstmt.setDate(64, null);
				else
					pstmt.setDate(64, Date.valueOf(get(i).getPSignDate()));
				if (get(i).getPValiDate() == null || get(i).getPValiDate().equals("null"))
					pstmt.setDate(65, null);
				else
					pstmt.setDate(65, Date.valueOf(get(i).getPValiDate()));
				if (get(i).getInputOperator() == null || get(i).getInputOperator().equals("null"))
					pstmt.setString(66, null);
				else
					pstmt.setString(66, get(i).getInputOperator());
				if (get(i).getInputDate() == null || get(i).getInputDate().equals("null"))
					pstmt.setDate(67, null);
				else
					pstmt.setDate(67, Date.valueOf(get(i).getInputDate()));
				if (get(i).getInputTime() == null || get(i).getInputTime().equals("null"))
					pstmt.setString(68, null);
				else
					pstmt.setString(68, get(i).getInputTime());
				if (get(i).getApproveFlag() == null || get(i).getApproveFlag().equals("null"))
					pstmt.setString(69, null);
				else
					pstmt.setString(69, get(i).getApproveFlag());
				if (get(i).getApproveCode() == null || get(i).getApproveCode().equals("null"))
					pstmt.setString(70, null);
				else
					pstmt.setString(70, get(i).getApproveCode());
				if (get(i).getApproveDate() == null || get(i).getApproveDate().equals("null"))
					pstmt.setDate(71, null);
				else
					pstmt.setDate(71, Date.valueOf(get(i).getApproveDate()));
				if (get(i).getApproveTime() == null || get(i).getApproveTime().equals("null"))
					pstmt.setString(72, null);
				else
					pstmt.setString(72, get(i).getApproveTime());
				if (get(i).getUWFlag() == null || get(i).getUWFlag().equals("null"))
					pstmt.setString(73, null);
				else
					pstmt.setString(73, get(i).getUWFlag());
				if (get(i).getUWOperator() == null || get(i).getUWOperator().equals("null"))
					pstmt.setString(74, null);
				else
					pstmt.setString(74, get(i).getUWOperator());
				if (get(i).getUWDate() == null || get(i).getUWDate().equals("null"))
					pstmt.setDate(75, null);
				else
					pstmt.setDate(75, Date.valueOf(get(i).getUWDate()));
				if (get(i).getUWTime() == null || get(i).getUWTime().equals("null"))
					pstmt.setString(76, null);
				else
					pstmt.setString(76, get(i).getUWTime());
				if (get(i).getAppFlag() == null || get(i).getAppFlag().equals("null"))
					pstmt.setString(77, null);
				else
					pstmt.setString(77, get(i).getAppFlag());
				if (get(i).getPolApplyDate() == null || get(i).getPolApplyDate().equals("null"))
					pstmt.setDate(78, null);
				else
					pstmt.setDate(78, Date.valueOf(get(i).getPolApplyDate()));
				if (get(i).getGetPolDate() == null || get(i).getGetPolDate().equals("null"))
					pstmt.setDate(79, null);
				else
					pstmt.setDate(79, Date.valueOf(get(i).getGetPolDate()));
				if (get(i).getGetPolTime() == null || get(i).getGetPolTime().equals("null"))
					pstmt.setString(80, null);
				else
					pstmt.setString(80, get(i).getGetPolTime());
				if (get(i).getCustomGetPolDate() == null || get(i).getCustomGetPolDate().equals("null"))
					pstmt.setDate(81, null);
				else
					pstmt.setDate(81, Date.valueOf(get(i).getCustomGetPolDate()));
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(82, null);
				else
					pstmt.setString(82, get(i).getState());
				if (get(i).getSaleChnlDetail() == null || get(i).getSaleChnlDetail().equals("null"))
					pstmt.setString(83, null);
				else
					pstmt.setString(83, get(i).getSaleChnlDetail());
				if (get(i).getProposalType() == null || get(i).getProposalType().equals("null"))
					pstmt.setString(84, null);
				else
					pstmt.setString(84, get(i).getProposalType());
				if (get(i).getEditstate() == null || get(i).getEditstate().equals("null"))
					pstmt.setString(85, null);
				else
					pstmt.setString(85, get(i).getEditstate());
				if (get(i).getCInValiDate() == null || get(i).getCInValiDate().equals("null"))
					pstmt.setDate(86, null);
				else
					pstmt.setDate(86, Date.valueOf(get(i).getCInValiDate()));
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(87, null);
				else
					pstmt.setString(87, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(88, null);
				else
					pstmt.setDate(88, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(89, null);
				else
					pstmt.setString(89, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(90, null);
				else
					pstmt.setDate(90, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(91, null);
				else
					pstmt.setString(91, get(i).getModifyTime());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(92, null);
				else
					pstmt.setString(92, get(i).getContNo());
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
			tError.moduleName = "LNPContDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCont VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getMainPolNo() == null || get(i).getMainPolNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMainPolNo());
				if (get(i).getContType() == null || get(i).getContType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getContType());
				if (get(i).getFamilyType() == null || get(i).getFamilyType().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getFamilyType());
				if (get(i).getFamilyID() == null || get(i).getFamilyID().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getFamilyID());
				if (get(i).getPolType() == null || get(i).getPolType().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getPolType());
				if (get(i).getSugNo() == null || get(i).getSugNo().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getSugNo());
				if (get(i).getCardFlag() == null || get(i).getCardFlag().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCardFlag());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getManageCom());
				if (get(i).getExecuteCom() == null || get(i).getExecuteCom().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getExecuteCom());
				if (get(i).getAgentCom() == null || get(i).getAgentCom().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getAgentCom());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getAgentCode());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAgentGroup());
				if (get(i).getAgentCode1() == null || get(i).getAgentCode1().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getAgentCode1());
				if (get(i).getAgentGroup1() == null || get(i).getAgentGroup1().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getAgentGroup1());
				if (get(i).getAgentType() == null || get(i).getAgentType().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getAgentType());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getSaleChnl());
				if (get(i).getHandler() == null || get(i).getHandler().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getHandler());
				if (get(i).getPassword() == null || get(i).getPassword().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getPassword());
				if (get(i).getAppntNo() == null || get(i).getAppntNo().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getAppntNo());
				if (get(i).getAppntId() == null || get(i).getAppntId().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getAppntId());
				if (get(i).getAppntName() == null || get(i).getAppntName().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getAppntName());
				if (get(i).getAppntSex() == null || get(i).getAppntSex().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getAppntSex());
				if (get(i).getAppntBirthday() == null || get(i).getAppntBirthday().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getAppntBirthday()));
				if (get(i).getAppntIDType() == null || get(i).getAppntIDType().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getAppntIDType());
				if (get(i).getAppntIDNo() == null || get(i).getAppntIDNo().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getAppntIDNo());
				if (get(i).getInsuredNo() == null || get(i).getInsuredNo().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getInsuredNo());
				if (get(i).getInsuredId() == null || get(i).getInsuredId().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getInsuredId());
				if (get(i).getInsuredName() == null || get(i).getInsuredName().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getInsuredName());
				if (get(i).getInsuredSex() == null || get(i).getInsuredSex().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getInsuredSex());
				if (get(i).getInsuredBirthday() == null || get(i).getInsuredBirthday().equals("null"))
					pstmt.setDate(34, null);
				else
					pstmt.setDate(34, Date.valueOf(get(i).getInsuredBirthday()));
				if (get(i).getInsuredIDType() == null || get(i).getInsuredIDType().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getInsuredIDType());
				if (get(i).getInsuredIDNo() == null || get(i).getInsuredIDNo().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getInsuredIDNo());
				pstmt.setInt(37, get(i).getPayIntv());
				if (get(i).getPayMode() == null || get(i).getPayMode().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getPayMode());
				if (get(i).getPayLocation() == null || get(i).getPayLocation().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getPayLocation());
				if (get(i).getDisputedFlag() == null || get(i).getDisputedFlag().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getDisputedFlag());
				if (get(i).getOutPayFlag() == null || get(i).getOutPayFlag().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getOutPayFlag());
				if (get(i).getGetPolMode() == null || get(i).getGetPolMode().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getGetPolMode());
				if (get(i).getSignCom() == null || get(i).getSignCom().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getSignCom());
				if (get(i).getSignDate() == null || get(i).getSignDate().equals("null"))
					pstmt.setDate(44, null);
				else
					pstmt.setDate(44, Date.valueOf(get(i).getSignDate()));
				if (get(i).getSignTime() == null || get(i).getSignTime().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getSignTime());
				if (get(i).getConsignNo() == null || get(i).getConsignNo().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getConsignNo());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getBankAccNo());
				if (get(i).getAccName() == null || get(i).getAccName().equals("null"))
					pstmt.setString(49, null);
				else
					pstmt.setString(49, get(i).getAccName());
				pstmt.setInt(50, get(i).getPrintCount());
				pstmt.setInt(51, get(i).getLostTimes());
				if (get(i).getLang() == null || get(i).getLang().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getLang());
				if (get(i).getCurrency() == null || get(i).getCurrency().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getCurrency());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getRemark());
				pstmt.setInt(55, get(i).getPeoples());
				pstmt.setDouble(56, get(i).getMult());
				pstmt.setDouble(57, get(i).getPrem());
				pstmt.setDouble(58, get(i).getAmnt());
				pstmt.setDouble(59, get(i).getSumPrem());
				pstmt.setDouble(60, get(i).getDif());
				if (get(i).getPaytoDate() == null || get(i).getPaytoDate().equals("null"))
					pstmt.setDate(61, null);
				else
					pstmt.setDate(61, Date.valueOf(get(i).getPaytoDate()));
				if (get(i).getFirstPayDate() == null || get(i).getFirstPayDate().equals("null"))
					pstmt.setDate(62, null);
				else
					pstmt.setDate(62, Date.valueOf(get(i).getFirstPayDate()));
				if (get(i).getCValiDate() == null || get(i).getCValiDate().equals("null"))
					pstmt.setDate(63, null);
				else
					pstmt.setDate(63, Date.valueOf(get(i).getCValiDate()));
				if (get(i).getPSignDate() == null || get(i).getPSignDate().equals("null"))
					pstmt.setDate(64, null);
				else
					pstmt.setDate(64, Date.valueOf(get(i).getPSignDate()));
				if (get(i).getPValiDate() == null || get(i).getPValiDate().equals("null"))
					pstmt.setDate(65, null);
				else
					pstmt.setDate(65, Date.valueOf(get(i).getPValiDate()));
				if (get(i).getInputOperator() == null || get(i).getInputOperator().equals("null"))
					pstmt.setString(66, null);
				else
					pstmt.setString(66, get(i).getInputOperator());
				if (get(i).getInputDate() == null || get(i).getInputDate().equals("null"))
					pstmt.setDate(67, null);
				else
					pstmt.setDate(67, Date.valueOf(get(i).getInputDate()));
				if (get(i).getInputTime() == null || get(i).getInputTime().equals("null"))
					pstmt.setString(68, null);
				else
					pstmt.setString(68, get(i).getInputTime());
				if (get(i).getApproveFlag() == null || get(i).getApproveFlag().equals("null"))
					pstmt.setString(69, null);
				else
					pstmt.setString(69, get(i).getApproveFlag());
				if (get(i).getApproveCode() == null || get(i).getApproveCode().equals("null"))
					pstmt.setString(70, null);
				else
					pstmt.setString(70, get(i).getApproveCode());
				if (get(i).getApproveDate() == null || get(i).getApproveDate().equals("null"))
					pstmt.setDate(71, null);
				else
					pstmt.setDate(71, Date.valueOf(get(i).getApproveDate()));
				if (get(i).getApproveTime() == null || get(i).getApproveTime().equals("null"))
					pstmt.setString(72, null);
				else
					pstmt.setString(72, get(i).getApproveTime());
				if (get(i).getUWFlag() == null || get(i).getUWFlag().equals("null"))
					pstmt.setString(73, null);
				else
					pstmt.setString(73, get(i).getUWFlag());
				if (get(i).getUWOperator() == null || get(i).getUWOperator().equals("null"))
					pstmt.setString(74, null);
				else
					pstmt.setString(74, get(i).getUWOperator());
				if (get(i).getUWDate() == null || get(i).getUWDate().equals("null"))
					pstmt.setDate(75, null);
				else
					pstmt.setDate(75, Date.valueOf(get(i).getUWDate()));
				if (get(i).getUWTime() == null || get(i).getUWTime().equals("null"))
					pstmt.setString(76, null);
				else
					pstmt.setString(76, get(i).getUWTime());
				if (get(i).getAppFlag() == null || get(i).getAppFlag().equals("null"))
					pstmt.setString(77, null);
				else
					pstmt.setString(77, get(i).getAppFlag());
				if (get(i).getPolApplyDate() == null || get(i).getPolApplyDate().equals("null"))
					pstmt.setDate(78, null);
				else
					pstmt.setDate(78, Date.valueOf(get(i).getPolApplyDate()));
				if (get(i).getGetPolDate() == null || get(i).getGetPolDate().equals("null"))
					pstmt.setDate(79, null);
				else
					pstmt.setDate(79, Date.valueOf(get(i).getGetPolDate()));
				if (get(i).getGetPolTime() == null || get(i).getGetPolTime().equals("null"))
					pstmt.setString(80, null);
				else
					pstmt.setString(80, get(i).getGetPolTime());
				if (get(i).getCustomGetPolDate() == null || get(i).getCustomGetPolDate().equals("null"))
					pstmt.setDate(81, null);
				else
					pstmt.setDate(81, Date.valueOf(get(i).getCustomGetPolDate()));
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(82, null);
				else
					pstmt.setString(82, get(i).getState());
				if (get(i).getSaleChnlDetail() == null || get(i).getSaleChnlDetail().equals("null"))
					pstmt.setString(83, null);
				else
					pstmt.setString(83, get(i).getSaleChnlDetail());
				if (get(i).getProposalType() == null || get(i).getProposalType().equals("null"))
					pstmt.setString(84, null);
				else
					pstmt.setString(84, get(i).getProposalType());
				if (get(i).getEditstate() == null || get(i).getEditstate().equals("null"))
					pstmt.setString(85, null);
				else
					pstmt.setString(85, get(i).getEditstate());
				if (get(i).getCInValiDate() == null || get(i).getCInValiDate().equals("null"))
					pstmt.setDate(86, null);
				else
					pstmt.setDate(86, Date.valueOf(get(i).getCInValiDate()));
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(87, null);
				else
					pstmt.setString(87, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(88, null);
				else
					pstmt.setDate(88, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(89, null);
				else
					pstmt.setString(89, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(90, null);
				else
					pstmt.setDate(90, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(91, null);
				else
					pstmt.setString(91, get(i).getModifyTime());
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
			tError.moduleName = "LNPContDBSet";
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
