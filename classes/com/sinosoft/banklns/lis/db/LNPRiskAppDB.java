// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskAppDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPRiskAppSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskAppSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPRiskAppDB extends LNPRiskAppSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPRiskAppDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPRiskApp");
		mflag = true;
	}

	public LNPRiskAppDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPRiskApp");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPRiskAppSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAppDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPRiskAppSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAppDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskApp WHERE  RiskCode = ?");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAppDB";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskApp SET  RiskCode = ? , RiskVer = ? , RiskName = ? , KindCode = ? , RiskType = ? , RiskType1 = ? , RiskType2 = ? , RiskProp = ? , RiskPeriod = ? , RiskTypeDetail = ? , RiskFlag = ? , PolType = ? , InvestFlag = ? , BonusFlag = ? , BonusMode = ? , ListFlag = ? , SubRiskFlag = ? , CalDigital = ? , CalChoMode = ? , RiskAmntMult = ? , InsuPeriodFlag = ? , MaxEndPeriod = ? , AgeLmt = ? , SignDateCalMode = ? , ProtocolFlag = ? , GetChgFlag = ? , ProtocolPayFlag = ? , EnsuPlanFlag = ? , EnsuPlanAdjFlag = ? , StartDate = ? , EndDate = ? , MinAppntAge = ? , MaxAppntAge = ? , MaxInsuredAge = ? , MinInsuredAge = ? , AppInterest = ? , AppPremRate = ? , InsuredFlag = ? , ShareFlag = ? , BnfFlag = ? , TempPayFlag = ? , InpPayPlan = ? , ImpartFlag = ? , InsuExpeFlag = ? , LoanFalg = ? , MortagageFlag = ? , IDifReturnFlag = ? , CutAmntStopPay = ? , RinsRate = ? , SaleFlag = ? , FileAppFlag = ? , MngCom = ? , AutoPayFlag = ? , NeedPrintHospital = ? , NeedPrintGet = ? , RiskType3 = ? , RiskType4 = ? , RiskType5 = ? , NotPrintPol = ? , NeedGetPolDate = ? , NeedReReadBank = ? , SpecFlag = ? , InterestDifFlag = ? WHERE  RiskCode = ?");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			if (getRiskVer() == null || getRiskVer().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRiskVer());
			if (getRiskName() == null || getRiskName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getRiskName());
			if (getKindCode() == null || getKindCode().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getKindCode());
			if (getRiskType() == null || getRiskType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getRiskType());
			if (getRiskType1() == null || getRiskType1().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getRiskType1());
			if (getRiskType2() == null || getRiskType2().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getRiskType2());
			if (getRiskProp() == null || getRiskProp().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getRiskProp());
			if (getRiskPeriod() == null || getRiskPeriod().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getRiskPeriod());
			if (getRiskTypeDetail() == null || getRiskTypeDetail().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getRiskTypeDetail());
			if (getRiskFlag() == null || getRiskFlag().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getRiskFlag());
			if (getPolType() == null || getPolType().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getPolType());
			if (getInvestFlag() == null || getInvestFlag().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getInvestFlag());
			if (getBonusFlag() == null || getBonusFlag().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getBonusFlag());
			if (getBonusMode() == null || getBonusMode().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getBonusMode());
			if (getListFlag() == null || getListFlag().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getListFlag());
			if (getSubRiskFlag() == null || getSubRiskFlag().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getSubRiskFlag());
			pstmt.setInt(18, getCalDigital());
			if (getCalChoMode() == null || getCalChoMode().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getCalChoMode());
			pstmt.setInt(20, getRiskAmntMult());
			if (getInsuPeriodFlag() == null || getInsuPeriodFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getInsuPeriodFlag());
			pstmt.setInt(22, getMaxEndPeriod());
			pstmt.setInt(23, getAgeLmt());
			pstmt.setInt(24, getSignDateCalMode());
			if (getProtocolFlag() == null || getProtocolFlag().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getProtocolFlag());
			if (getGetChgFlag() == null || getGetChgFlag().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getGetChgFlag());
			if (getProtocolPayFlag() == null || getProtocolPayFlag().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getProtocolPayFlag());
			if (getEnsuPlanFlag() == null || getEnsuPlanFlag().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getEnsuPlanFlag());
			if (getEnsuPlanAdjFlag() == null || getEnsuPlanAdjFlag().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getEnsuPlanAdjFlag());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(30, 91);
			else
				pstmt.setDate(30, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(31, 91);
			else
				pstmt.setDate(31, Date.valueOf(getEndDate()));
			pstmt.setInt(32, getMinAppntAge());
			pstmt.setInt(33, getMaxAppntAge());
			pstmt.setInt(34, getMaxInsuredAge());
			pstmt.setInt(35, getMinInsuredAge());
			pstmt.setDouble(36, getAppInterest());
			pstmt.setDouble(37, getAppPremRate());
			if (getInsuredFlag() == null || getInsuredFlag().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getInsuredFlag());
			if (getShareFlag() == null || getShareFlag().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getShareFlag());
			if (getBnfFlag() == null || getBnfFlag().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getBnfFlag());
			if (getTempPayFlag() == null || getTempPayFlag().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getTempPayFlag());
			if (getInpPayPlan() == null || getInpPayPlan().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getInpPayPlan());
			if (getImpartFlag() == null || getImpartFlag().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getImpartFlag());
			if (getInsuExpeFlag() == null || getInsuExpeFlag().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getInsuExpeFlag());
			if (getLoanFalg() == null || getLoanFalg().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getLoanFalg());
			if (getMortagageFlag() == null || getMortagageFlag().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getMortagageFlag());
			if (getIDifReturnFlag() == null || getIDifReturnFlag().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getIDifReturnFlag());
			if (getCutAmntStopPay() == null || getCutAmntStopPay().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getCutAmntStopPay());
			pstmt.setDouble(49, getRinsRate());
			if (getSaleFlag() == null || getSaleFlag().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getSaleFlag());
			if (getFileAppFlag() == null || getFileAppFlag().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getFileAppFlag());
			if (getMngCom() == null || getMngCom().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getMngCom());
			if (getAutoPayFlag() == null || getAutoPayFlag().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getAutoPayFlag());
			if (getNeedPrintHospital() == null || getNeedPrintHospital().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getNeedPrintHospital());
			if (getNeedPrintGet() == null || getNeedPrintGet().equals("null"))
				pstmt.setNull(55, 12);
			else
				pstmt.setString(55, getNeedPrintGet());
			if (getRiskType3() == null || getRiskType3().equals("null"))
				pstmt.setNull(56, 12);
			else
				pstmt.setString(56, getRiskType3());
			if (getRiskType4() == null || getRiskType4().equals("null"))
				pstmt.setNull(57, 12);
			else
				pstmt.setString(57, getRiskType4());
			if (getRiskType5() == null || getRiskType5().equals("null"))
				pstmt.setNull(58, 12);
			else
				pstmt.setString(58, getRiskType5());
			if (getNotPrintPol() == null || getNotPrintPol().equals("null"))
				pstmt.setNull(59, 12);
			else
				pstmt.setString(59, getNotPrintPol());
			if (getNeedGetPolDate() == null || getNeedGetPolDate().equals("null"))
				pstmt.setNull(60, 12);
			else
				pstmt.setString(60, getNeedGetPolDate());
			if (getNeedReReadBank() == null || getNeedReReadBank().equals("null"))
				pstmt.setNull(61, 12);
			else
				pstmt.setString(61, getNeedReReadBank());
			if (getSpecFlag() == null || getSpecFlag().equals("null"))
				pstmt.setNull(62, 12);
			else
				pstmt.setString(62, getSpecFlag());
			if (getInterestDifFlag() == null || getInterestDifFlag().equals("null"))
				pstmt.setNull(63, 12);
			else
				pstmt.setString(63, getInterestDifFlag());
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(64, 12);
			else
				pstmt.setString(64, getRiskCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAppDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskApp VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			if (getRiskVer() == null || getRiskVer().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRiskVer());
			if (getRiskName() == null || getRiskName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getRiskName());
			if (getKindCode() == null || getKindCode().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getKindCode());
			if (getRiskType() == null || getRiskType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getRiskType());
			if (getRiskType1() == null || getRiskType1().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getRiskType1());
			if (getRiskType2() == null || getRiskType2().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getRiskType2());
			if (getRiskProp() == null || getRiskProp().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getRiskProp());
			if (getRiskPeriod() == null || getRiskPeriod().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getRiskPeriod());
			if (getRiskTypeDetail() == null || getRiskTypeDetail().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getRiskTypeDetail());
			if (getRiskFlag() == null || getRiskFlag().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getRiskFlag());
			if (getPolType() == null || getPolType().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getPolType());
			if (getInvestFlag() == null || getInvestFlag().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getInvestFlag());
			if (getBonusFlag() == null || getBonusFlag().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getBonusFlag());
			if (getBonusMode() == null || getBonusMode().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getBonusMode());
			if (getListFlag() == null || getListFlag().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getListFlag());
			if (getSubRiskFlag() == null || getSubRiskFlag().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getSubRiskFlag());
			pstmt.setInt(18, getCalDigital());
			if (getCalChoMode() == null || getCalChoMode().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getCalChoMode());
			pstmt.setInt(20, getRiskAmntMult());
			if (getInsuPeriodFlag() == null || getInsuPeriodFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getInsuPeriodFlag());
			pstmt.setInt(22, getMaxEndPeriod());
			pstmt.setInt(23, getAgeLmt());
			pstmt.setInt(24, getSignDateCalMode());
			if (getProtocolFlag() == null || getProtocolFlag().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getProtocolFlag());
			if (getGetChgFlag() == null || getGetChgFlag().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getGetChgFlag());
			if (getProtocolPayFlag() == null || getProtocolPayFlag().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getProtocolPayFlag());
			if (getEnsuPlanFlag() == null || getEnsuPlanFlag().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getEnsuPlanFlag());
			if (getEnsuPlanAdjFlag() == null || getEnsuPlanAdjFlag().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getEnsuPlanAdjFlag());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(30, 91);
			else
				pstmt.setDate(30, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(31, 91);
			else
				pstmt.setDate(31, Date.valueOf(getEndDate()));
			pstmt.setInt(32, getMinAppntAge());
			pstmt.setInt(33, getMaxAppntAge());
			pstmt.setInt(34, getMaxInsuredAge());
			pstmt.setInt(35, getMinInsuredAge());
			pstmt.setDouble(36, getAppInterest());
			pstmt.setDouble(37, getAppPremRate());
			if (getInsuredFlag() == null || getInsuredFlag().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getInsuredFlag());
			if (getShareFlag() == null || getShareFlag().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getShareFlag());
			if (getBnfFlag() == null || getBnfFlag().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getBnfFlag());
			if (getTempPayFlag() == null || getTempPayFlag().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getTempPayFlag());
			if (getInpPayPlan() == null || getInpPayPlan().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getInpPayPlan());
			if (getImpartFlag() == null || getImpartFlag().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getImpartFlag());
			if (getInsuExpeFlag() == null || getInsuExpeFlag().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getInsuExpeFlag());
			if (getLoanFalg() == null || getLoanFalg().equals("null"))
				pstmt.setNull(45, 12);
			else
				pstmt.setString(45, getLoanFalg());
			if (getMortagageFlag() == null || getMortagageFlag().equals("null"))
				pstmt.setNull(46, 12);
			else
				pstmt.setString(46, getMortagageFlag());
			if (getIDifReturnFlag() == null || getIDifReturnFlag().equals("null"))
				pstmt.setNull(47, 12);
			else
				pstmt.setString(47, getIDifReturnFlag());
			if (getCutAmntStopPay() == null || getCutAmntStopPay().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getCutAmntStopPay());
			pstmt.setDouble(49, getRinsRate());
			if (getSaleFlag() == null || getSaleFlag().equals("null"))
				pstmt.setNull(50, 12);
			else
				pstmt.setString(50, getSaleFlag());
			if (getFileAppFlag() == null || getFileAppFlag().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getFileAppFlag());
			if (getMngCom() == null || getMngCom().equals("null"))
				pstmt.setNull(52, 12);
			else
				pstmt.setString(52, getMngCom());
			if (getAutoPayFlag() == null || getAutoPayFlag().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getAutoPayFlag());
			if (getNeedPrintHospital() == null || getNeedPrintHospital().equals("null"))
				pstmt.setNull(54, 12);
			else
				pstmt.setString(54, getNeedPrintHospital());
			if (getNeedPrintGet() == null || getNeedPrintGet().equals("null"))
				pstmt.setNull(55, 12);
			else
				pstmt.setString(55, getNeedPrintGet());
			if (getRiskType3() == null || getRiskType3().equals("null"))
				pstmt.setNull(56, 12);
			else
				pstmt.setString(56, getRiskType3());
			if (getRiskType4() == null || getRiskType4().equals("null"))
				pstmt.setNull(57, 12);
			else
				pstmt.setString(57, getRiskType4());
			if (getRiskType5() == null || getRiskType5().equals("null"))
				pstmt.setNull(58, 12);
			else
				pstmt.setString(58, getRiskType5());
			if (getNotPrintPol() == null || getNotPrintPol().equals("null"))
				pstmt.setNull(59, 12);
			else
				pstmt.setString(59, getNotPrintPol());
			if (getNeedGetPolDate() == null || getNeedGetPolDate().equals("null"))
				pstmt.setNull(60, 12);
			else
				pstmt.setString(60, getNeedGetPolDate());
			if (getNeedReReadBank() == null || getNeedReReadBank().equals("null"))
				pstmt.setNull(61, 12);
			else
				pstmt.setString(61, getNeedReReadBank());
			if (getSpecFlag() == null || getSpecFlag().equals("null"))
				pstmt.setNull(62, 12);
			else
				pstmt.setString(62, getSpecFlag());
			if (getInterestDifFlag() == null || getInterestDifFlag().equals("null"))
				pstmt.setNull(63, 12);
			else
				pstmt.setString(63, getInterestDifFlag());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskAppDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPRiskApp WHERE  RiskCode = ?", 1003, 1007);
		if (getRiskCode() == null || getRiskCode().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getRiskCode());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "LNPRiskAppDB";
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
				tError.moduleName = "LNPRiskAppDB";
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

	public LNPRiskAppSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskAppSet aLNPRiskAppSet = new LNPRiskAppSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPRiskApp");
			LNPRiskAppSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPRiskAppSchema s1;
			for (; rs.next(); aLNPRiskAppSet.add(s1))
			{
				i++;
				s1 = new LNPRiskAppSchema();
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
			tError.moduleName = "LNPRiskAppDB";
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
		return aLNPRiskAppSet;
	}

	public LNPRiskAppSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskAppSet aLNPRiskAppSet = new LNPRiskAppSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPRiskAppSchema s1;
			for (; rs.next(); aLNPRiskAppSet.add(s1))
			{
				i++;
				s1 = new LNPRiskAppSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPRiskAppDB";
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
			tError.moduleName = "LNPRiskAppDB";
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
		return aLNPRiskAppSet;
	}

	public LNPRiskAppSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskAppSet aLNPRiskAppSet = new LNPRiskAppSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPRiskApp");
			LNPRiskAppSchema aSchema = getSchema();
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
				LNPRiskAppSchema s1 = new LNPRiskAppSchema();
				s1.setSchema(rs, i);
				aLNPRiskAppSet.add(s1);
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
			tError.moduleName = "LNPRiskAppDB";
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
		return aLNPRiskAppSet;
	}

	public LNPRiskAppSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskAppSet aLNPRiskAppSet = new LNPRiskAppSet();
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
				LNPRiskAppSchema s1 = new LNPRiskAppSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPRiskAppDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPRiskAppSet.add(s1);
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
			tError.moduleName = "LNPRiskAppDB";
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
		return aLNPRiskAppSet;
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
				SQLString sqlObj = new SQLString("LNPRiskApp");
				LNPRiskAppSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPRiskApp ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPRiskAppDB";
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
				tError.moduleName = "LNPRiskAppDB";
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
			tError.moduleName = "LNPRiskAppDB";
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
			tError.moduleName = "LNPRiskAppDB";
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
			tError.moduleName = "LNPRiskAppDB";
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
			tError.moduleName = "LNPRiskAppDB";
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

	public LNPRiskAppSet getData()
	{
		int tCount = 0;
		LNPRiskAppSet tLNPRiskAppSet = new LNPRiskAppSet();
		LNPRiskAppSchema tLNPRiskAppSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskAppDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPRiskAppSchema = new LNPRiskAppSchema();
			tLNPRiskAppSchema.setSchema(mResultSet, 1);
			tLNPRiskAppSet.add(tLNPRiskAppSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPRiskAppSchema = new LNPRiskAppSchema();
					tLNPRiskAppSchema.setSchema(mResultSet, 1);
					tLNPRiskAppSet.add(tLNPRiskAppSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskAppDB";
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
		return tLNPRiskAppSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPRiskAppDB";
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
			tError.moduleName = "LNPRiskAppDB";
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
				tError.moduleName = "LNPRiskAppDB";
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
			tError.moduleName = "LNPRiskAppDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
