// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskAppDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskAppSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskAppSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPRiskAppDBSet extends LNPRiskAppSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskAppDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskApp");
		mflag = true;
	}

	public LNPRiskAppDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskApp");
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
			tError.moduleName = "LNPRiskAppDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskApp WHERE  RiskCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
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
			tError.moduleName = "LNPRiskAppDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskApp SET  RiskCode = ? , RiskVer = ? , RiskName = ? , KindCode = ? , RiskType = ? , RiskType1 = ? , RiskType2 = ? , RiskProp = ? , RiskPeriod = ? , RiskTypeDetail = ? , RiskFlag = ? , PolType = ? , InvestFlag = ? , BonusFlag = ? , BonusMode = ? , ListFlag = ? , SubRiskFlag = ? , CalDigital = ? , CalChoMode = ? , RiskAmntMult = ? , InsuPeriodFlag = ? , MaxEndPeriod = ? , AgeLmt = ? , SignDateCalMode = ? , ProtocolFlag = ? , GetChgFlag = ? , ProtocolPayFlag = ? , EnsuPlanFlag = ? , EnsuPlanAdjFlag = ? , StartDate = ? , EndDate = ? , MinAppntAge = ? , MaxAppntAge = ? , MaxInsuredAge = ? , MinInsuredAge = ? , AppInterest = ? , AppPremRate = ? , InsuredFlag = ? , ShareFlag = ? , BnfFlag = ? , TempPayFlag = ? , InpPayPlan = ? , ImpartFlag = ? , InsuExpeFlag = ? , LoanFalg = ? , MortagageFlag = ? , IDifReturnFlag = ? , CutAmntStopPay = ? , RinsRate = ? , SaleFlag = ? , FileAppFlag = ? , MngCom = ? , AutoPayFlag = ? , NeedPrintHospital = ? , NeedPrintGet = ? , RiskType3 = ? , RiskType4 = ? , RiskType5 = ? , NotPrintPol = ? , NeedGetPolDate = ? , NeedReReadBank = ? , SpecFlag = ? , InterestDifFlag = ? WHERE  RiskCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRiskVer() == null || get(i).getRiskVer().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskVer());
				if (get(i).getRiskName() == null || get(i).getRiskName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRiskName());
				if (get(i).getKindCode() == null || get(i).getKindCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getKindCode());
				if (get(i).getRiskType() == null || get(i).getRiskType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRiskType());
				if (get(i).getRiskType1() == null || get(i).getRiskType1().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getRiskType1());
				if (get(i).getRiskType2() == null || get(i).getRiskType2().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRiskType2());
				if (get(i).getRiskProp() == null || get(i).getRiskProp().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getRiskProp());
				if (get(i).getRiskPeriod() == null || get(i).getRiskPeriod().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getRiskPeriod());
				if (get(i).getRiskTypeDetail() == null || get(i).getRiskTypeDetail().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRiskTypeDetail());
				if (get(i).getRiskFlag() == null || get(i).getRiskFlag().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRiskFlag());
				if (get(i).getPolType() == null || get(i).getPolType().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getPolType());
				if (get(i).getInvestFlag() == null || get(i).getInvestFlag().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getInvestFlag());
				if (get(i).getBonusFlag() == null || get(i).getBonusFlag().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getBonusFlag());
				if (get(i).getBonusMode() == null || get(i).getBonusMode().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getBonusMode());
				if (get(i).getListFlag() == null || get(i).getListFlag().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getListFlag());
				if (get(i).getSubRiskFlag() == null || get(i).getSubRiskFlag().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getSubRiskFlag());
				pstmt.setInt(18, get(i).getCalDigital());
				if (get(i).getCalChoMode() == null || get(i).getCalChoMode().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getCalChoMode());
				pstmt.setInt(20, get(i).getRiskAmntMult());
				if (get(i).getInsuPeriodFlag() == null || get(i).getInsuPeriodFlag().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getInsuPeriodFlag());
				pstmt.setInt(22, get(i).getMaxEndPeriod());
				pstmt.setInt(23, get(i).getAgeLmt());
				pstmt.setInt(24, get(i).getSignDateCalMode());
				if (get(i).getProtocolFlag() == null || get(i).getProtocolFlag().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getProtocolFlag());
				if (get(i).getGetChgFlag() == null || get(i).getGetChgFlag().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getGetChgFlag());
				if (get(i).getProtocolPayFlag() == null || get(i).getProtocolPayFlag().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getProtocolPayFlag());
				if (get(i).getEnsuPlanFlag() == null || get(i).getEnsuPlanFlag().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getEnsuPlanFlag());
				if (get(i).getEnsuPlanAdjFlag() == null || get(i).getEnsuPlanAdjFlag().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getEnsuPlanAdjFlag());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(30, null);
				else
					pstmt.setDate(30, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(31, null);
				else
					pstmt.setDate(31, Date.valueOf(get(i).getEndDate()));
				pstmt.setInt(32, get(i).getMinAppntAge());
				pstmt.setInt(33, get(i).getMaxAppntAge());
				pstmt.setInt(34, get(i).getMaxInsuredAge());
				pstmt.setInt(35, get(i).getMinInsuredAge());
				pstmt.setDouble(36, get(i).getAppInterest());
				pstmt.setDouble(37, get(i).getAppPremRate());
				if (get(i).getInsuredFlag() == null || get(i).getInsuredFlag().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getInsuredFlag());
				if (get(i).getShareFlag() == null || get(i).getShareFlag().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getShareFlag());
				if (get(i).getBnfFlag() == null || get(i).getBnfFlag().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getBnfFlag());
				if (get(i).getTempPayFlag() == null || get(i).getTempPayFlag().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getTempPayFlag());
				if (get(i).getInpPayPlan() == null || get(i).getInpPayPlan().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getInpPayPlan());
				if (get(i).getImpartFlag() == null || get(i).getImpartFlag().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getImpartFlag());
				if (get(i).getInsuExpeFlag() == null || get(i).getInsuExpeFlag().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getInsuExpeFlag());
				if (get(i).getLoanFalg() == null || get(i).getLoanFalg().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getLoanFalg());
				if (get(i).getMortagageFlag() == null || get(i).getMortagageFlag().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getMortagageFlag());
				if (get(i).getIDifReturnFlag() == null || get(i).getIDifReturnFlag().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getIDifReturnFlag());
				if (get(i).getCutAmntStopPay() == null || get(i).getCutAmntStopPay().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getCutAmntStopPay());
				pstmt.setDouble(49, get(i).getRinsRate());
				if (get(i).getSaleFlag() == null || get(i).getSaleFlag().equals("null"))
					pstmt.setString(50, null);
				else
					pstmt.setString(50, get(i).getSaleFlag());
				if (get(i).getFileAppFlag() == null || get(i).getFileAppFlag().equals("null"))
					pstmt.setString(51, null);
				else
					pstmt.setString(51, get(i).getFileAppFlag());
				if (get(i).getMngCom() == null || get(i).getMngCom().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getMngCom());
				if (get(i).getAutoPayFlag() == null || get(i).getAutoPayFlag().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getAutoPayFlag());
				if (get(i).getNeedPrintHospital() == null || get(i).getNeedPrintHospital().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getNeedPrintHospital());
				if (get(i).getNeedPrintGet() == null || get(i).getNeedPrintGet().equals("null"))
					pstmt.setString(55, null);
				else
					pstmt.setString(55, get(i).getNeedPrintGet());
				if (get(i).getRiskType3() == null || get(i).getRiskType3().equals("null"))
					pstmt.setString(56, null);
				else
					pstmt.setString(56, get(i).getRiskType3());
				if (get(i).getRiskType4() == null || get(i).getRiskType4().equals("null"))
					pstmt.setString(57, null);
				else
					pstmt.setString(57, get(i).getRiskType4());
				if (get(i).getRiskType5() == null || get(i).getRiskType5().equals("null"))
					pstmt.setString(58, null);
				else
					pstmt.setString(58, get(i).getRiskType5());
				if (get(i).getNotPrintPol() == null || get(i).getNotPrintPol().equals("null"))
					pstmt.setString(59, null);
				else
					pstmt.setString(59, get(i).getNotPrintPol());
				if (get(i).getNeedGetPolDate() == null || get(i).getNeedGetPolDate().equals("null"))
					pstmt.setString(60, null);
				else
					pstmt.setString(60, get(i).getNeedGetPolDate());
				if (get(i).getNeedReReadBank() == null || get(i).getNeedReReadBank().equals("null"))
					pstmt.setString(61, null);
				else
					pstmt.setString(61, get(i).getNeedReReadBank());
				if (get(i).getSpecFlag() == null || get(i).getSpecFlag().equals("null"))
					pstmt.setString(62, null);
				else
					pstmt.setString(62, get(i).getSpecFlag());
				if (get(i).getInterestDifFlag() == null || get(i).getInterestDifFlag().equals("null"))
					pstmt.setString(63, null);
				else
					pstmt.setString(63, get(i).getInterestDifFlag());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(64, null);
				else
					pstmt.setString(64, get(i).getRiskCode());
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
			tError.moduleName = "LNPRiskAppDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskApp VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRiskVer() == null || get(i).getRiskVer().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskVer());
				if (get(i).getRiskName() == null || get(i).getRiskName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRiskName());
				if (get(i).getKindCode() == null || get(i).getKindCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getKindCode());
				if (get(i).getRiskType() == null || get(i).getRiskType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRiskType());
				if (get(i).getRiskType1() == null || get(i).getRiskType1().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getRiskType1());
				if (get(i).getRiskType2() == null || get(i).getRiskType2().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRiskType2());
				if (get(i).getRiskProp() == null || get(i).getRiskProp().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getRiskProp());
				if (get(i).getRiskPeriod() == null || get(i).getRiskPeriod().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getRiskPeriod());
				if (get(i).getRiskTypeDetail() == null || get(i).getRiskTypeDetail().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRiskTypeDetail());
				if (get(i).getRiskFlag() == null || get(i).getRiskFlag().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRiskFlag());
				if (get(i).getPolType() == null || get(i).getPolType().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getPolType());
				if (get(i).getInvestFlag() == null || get(i).getInvestFlag().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getInvestFlag());
				if (get(i).getBonusFlag() == null || get(i).getBonusFlag().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getBonusFlag());
				if (get(i).getBonusMode() == null || get(i).getBonusMode().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getBonusMode());
				if (get(i).getListFlag() == null || get(i).getListFlag().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getListFlag());
				if (get(i).getSubRiskFlag() == null || get(i).getSubRiskFlag().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getSubRiskFlag());
				pstmt.setInt(18, get(i).getCalDigital());
				if (get(i).getCalChoMode() == null || get(i).getCalChoMode().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getCalChoMode());
				pstmt.setInt(20, get(i).getRiskAmntMult());
				if (get(i).getInsuPeriodFlag() == null || get(i).getInsuPeriodFlag().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getInsuPeriodFlag());
				pstmt.setInt(22, get(i).getMaxEndPeriod());
				pstmt.setInt(23, get(i).getAgeLmt());
				pstmt.setInt(24, get(i).getSignDateCalMode());
				if (get(i).getProtocolFlag() == null || get(i).getProtocolFlag().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getProtocolFlag());
				if (get(i).getGetChgFlag() == null || get(i).getGetChgFlag().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getGetChgFlag());
				if (get(i).getProtocolPayFlag() == null || get(i).getProtocolPayFlag().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getProtocolPayFlag());
				if (get(i).getEnsuPlanFlag() == null || get(i).getEnsuPlanFlag().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getEnsuPlanFlag());
				if (get(i).getEnsuPlanAdjFlag() == null || get(i).getEnsuPlanAdjFlag().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getEnsuPlanAdjFlag());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(30, null);
				else
					pstmt.setDate(30, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(31, null);
				else
					pstmt.setDate(31, Date.valueOf(get(i).getEndDate()));
				pstmt.setInt(32, get(i).getMinAppntAge());
				pstmt.setInt(33, get(i).getMaxAppntAge());
				pstmt.setInt(34, get(i).getMaxInsuredAge());
				pstmt.setInt(35, get(i).getMinInsuredAge());
				pstmt.setDouble(36, get(i).getAppInterest());
				pstmt.setDouble(37, get(i).getAppPremRate());
				if (get(i).getInsuredFlag() == null || get(i).getInsuredFlag().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getInsuredFlag());
				if (get(i).getShareFlag() == null || get(i).getShareFlag().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getShareFlag());
				if (get(i).getBnfFlag() == null || get(i).getBnfFlag().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getBnfFlag());
				if (get(i).getTempPayFlag() == null || get(i).getTempPayFlag().equals("null"))
					pstmt.setString(41, null);
				else
					pstmt.setString(41, get(i).getTempPayFlag());
				if (get(i).getInpPayPlan() == null || get(i).getInpPayPlan().equals("null"))
					pstmt.setString(42, null);
				else
					pstmt.setString(42, get(i).getInpPayPlan());
				if (get(i).getImpartFlag() == null || get(i).getImpartFlag().equals("null"))
					pstmt.setString(43, null);
				else
					pstmt.setString(43, get(i).getImpartFlag());
				if (get(i).getInsuExpeFlag() == null || get(i).getInsuExpeFlag().equals("null"))
					pstmt.setString(44, null);
				else
					pstmt.setString(44, get(i).getInsuExpeFlag());
				if (get(i).getLoanFalg() == null || get(i).getLoanFalg().equals("null"))
					pstmt.setString(45, null);
				else
					pstmt.setString(45, get(i).getLoanFalg());
				if (get(i).getMortagageFlag() == null || get(i).getMortagageFlag().equals("null"))
					pstmt.setString(46, null);
				else
					pstmt.setString(46, get(i).getMortagageFlag());
				if (get(i).getIDifReturnFlag() == null || get(i).getIDifReturnFlag().equals("null"))
					pstmt.setString(47, null);
				else
					pstmt.setString(47, get(i).getIDifReturnFlag());
				if (get(i).getCutAmntStopPay() == null || get(i).getCutAmntStopPay().equals("null"))
					pstmt.setString(48, null);
				else
					pstmt.setString(48, get(i).getCutAmntStopPay());
				pstmt.setDouble(49, get(i).getRinsRate());
				if (get(i).getSaleFlag() == null || get(i).getSaleFlag().equals("null"))
					pstmt.setString(50, null);
				else
					pstmt.setString(50, get(i).getSaleFlag());
				if (get(i).getFileAppFlag() == null || get(i).getFileAppFlag().equals("null"))
					pstmt.setString(51, null);
				else
					pstmt.setString(51, get(i).getFileAppFlag());
				if (get(i).getMngCom() == null || get(i).getMngCom().equals("null"))
					pstmt.setString(52, null);
				else
					pstmt.setString(52, get(i).getMngCom());
				if (get(i).getAutoPayFlag() == null || get(i).getAutoPayFlag().equals("null"))
					pstmt.setString(53, null);
				else
					pstmt.setString(53, get(i).getAutoPayFlag());
				if (get(i).getNeedPrintHospital() == null || get(i).getNeedPrintHospital().equals("null"))
					pstmt.setString(54, null);
				else
					pstmt.setString(54, get(i).getNeedPrintHospital());
				if (get(i).getNeedPrintGet() == null || get(i).getNeedPrintGet().equals("null"))
					pstmt.setString(55, null);
				else
					pstmt.setString(55, get(i).getNeedPrintGet());
				if (get(i).getRiskType3() == null || get(i).getRiskType3().equals("null"))
					pstmt.setString(56, null);
				else
					pstmt.setString(56, get(i).getRiskType3());
				if (get(i).getRiskType4() == null || get(i).getRiskType4().equals("null"))
					pstmt.setString(57, null);
				else
					pstmt.setString(57, get(i).getRiskType4());
				if (get(i).getRiskType5() == null || get(i).getRiskType5().equals("null"))
					pstmt.setString(58, null);
				else
					pstmt.setString(58, get(i).getRiskType5());
				if (get(i).getNotPrintPol() == null || get(i).getNotPrintPol().equals("null"))
					pstmt.setString(59, null);
				else
					pstmt.setString(59, get(i).getNotPrintPol());
				if (get(i).getNeedGetPolDate() == null || get(i).getNeedGetPolDate().equals("null"))
					pstmt.setString(60, null);
				else
					pstmt.setString(60, get(i).getNeedGetPolDate());
				if (get(i).getNeedReReadBank() == null || get(i).getNeedReReadBank().equals("null"))
					pstmt.setString(61, null);
				else
					pstmt.setString(61, get(i).getNeedReReadBank());
				if (get(i).getSpecFlag() == null || get(i).getSpecFlag().equals("null"))
					pstmt.setString(62, null);
				else
					pstmt.setString(62, get(i).getSpecFlag());
				if (get(i).getInterestDifFlag() == null || get(i).getInterestDifFlag().equals("null"))
					pstmt.setString(63, null);
				else
					pstmt.setString(63, get(i).getInterestDifFlag());
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
			tError.moduleName = "LNPRiskAppDBSet";
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
