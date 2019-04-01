// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LAIndexInfoDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.LAIndexInfoSchema;
import com.sinosoft.map.lis.vschema.LAIndexInfoSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class LAIndexInfoDB extends LAIndexInfoSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LAIndexInfoDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LAIndexInfo");
		mflag = true;
	}

	public LAIndexInfoDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LAIndexInfo");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LAIndexInfoSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LAIndexInfoSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoDB";
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
			pstmt = con.prepareStatement("DELETE FROM LAIndexInfo WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
			if (getIndexCalNo() == null || getIndexCalNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getIndexCalNo());
			if (getIndexType() == null || getIndexType().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getIndexType());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAgentCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoDB";
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
			pstmt = con.prepareStatement("UPDATE LAIndexInfo SET  IndexCalNo = ? , IndexType = ? , AgentCode = ? , AgentGroup = ? , ManageCom = ? , StartDate = ? , StartEnd = ? , QuaBgnMark = ? , ServerMonths = ? , PostMonths = ? , IndMonthFYC = ? , IndMonthSYC = ? , IndMonSignFYC = ? , IndMonSignAFYC = ? , IndMonSignNAFYC = ? , GrpMonSignNAFYC = ? , MonPolCnt = ? , MontCustCnt = ? , IndMonPCount = ? , SMmonPolContin = ? , SMmonProduct = ? , SMworkMon = ? , MonPCount = ? , WSMMonPCount = ? , LPMonForSMMP = ? , LPMonForAMMP = ? , LPpolContinute = ? , MonEligFLPCnt = ? , TSRmonAFYP = ? , TSRmonDedAFYP = ? , TSRmonCompAFYP = ? , TSRMonWorkDays = ? , MonManPower = ? , MonManCount = ? , MonSAFYPSum = ? , MonTLGrpSAFYPSum = ? , IndYearNAFYC = ? , B12IndEffectAFYC = ? , B12IndAllAFYC = ? , B24IndEffectAFYC = ? , B24IndAllAFYC = ? , IndQutFYC = ? , LPproductivity = ? , LPPPRate = ? , LPPPBonus = ? , LPFincSubsidy = ? , SubsidyRate = ? , B12TeamNAFYC = ? , SMOverride = ? , TeamMonAvgPCount = ? , SMBasicSalary = ? , SMproductivity = ? , SMpolContinute = ? , SMPPRate = ? , SMPPBonus = ? , B24TeamEffectAFYC = ? , B24TeamAllAFYC = ? , TeamQutPremSum = ? , SMRRBonus = ? , SMManPowerDBonus = ? , LPB12ForMPDBonus = ? , SMUsualALLCSum = ? , AMBasicSalary = ? , AMproductivity = ? , AMpolContinute = ? , AMPPRate = ? , AMPPBonus = ? , B12DepNAFYC = ? , AMOverride = ? , DepMonAvgPCount = ? , DepQutPremSum = ? , AMRRBonus = ? , AMManPowerDBonus = ? , ProductGrowth = ? , DepQuaFYCSum = ? , AMLiability = ? , ReviOpen = ? , T1 = ? , T2 = ? , T3 = ? , T4 = ? , T5 = ? , T6 = ? , T7 = ? , T8 = ? , T9 = ? , T10 = ? , T11 = ? , T12 = ? , T13 = ? , T14 = ? , T15 = ? , T16 = ? , T17 = ? , T18 = ? , T20 = ? , T19 = ? , MonthIndex = ? , TMonthIndex = ? , ASumIndex = ? , WSMMonthEligible = ? , LPQuaPCount = ? , LPQuaFYCSum = ? , B12LPPCount = ? , B12LPNAFYCSum = ? , WSMMonAFYC = ? , WSMTwoMonAFYC = ? , WSMB6AFYC = ? , WSMB6PCount = ? , NetLiveLPCount = ? , NetComLPCount = ? , WSMTwoMonPCount = ? , LPAllNAFYC = ? , LPAllPCount = ? , MonPerSAFYP = ? , TSRThrMonSAFYP = ? , TLThrMonPerSAFYP = ? , MonSubsistCnt = ? , ThrMonSubsistCnt = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , AssessMonth = ? , BranchAttr = ? , AgentGrade = ? , ClubPromBonus = ? , ClubGradeBonus = ? , ClubAssisBonus = ? , ClubSpecBonus = ? , AdddedMoney = ? , LastMoney = ? , ShouldMoney = ? , BusinessTax = ? , EduTax = ? , BuildTax = ? , BusiCharge = ? , IncomeTax = ? , SumMoney = ? , AfterTaxMoney = ? , OperInCome = ? , T21 = ? , T22 = ? , T23 = ? , T24 = ? , T25 = ? WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
			if (getIndexCalNo() == null || getIndexCalNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getIndexCalNo());
			if (getIndexType() == null || getIndexType().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getIndexType());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAgentCode());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getAgentGroup());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getManageCom());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getStartDate()));
			if (getStartEnd() == null || getStartEnd().equals("null"))
				pstmt.setNull(7, 91);
			else
				pstmt.setDate(7, Date.valueOf(getStartEnd()));
			pstmt.setInt(8, getQuaBgnMark());
			pstmt.setInt(9, getServerMonths());
			pstmt.setInt(10, getPostMonths());
			pstmt.setDouble(11, getIndMonthFYC());
			pstmt.setDouble(12, getIndMonthSYC());
			pstmt.setDouble(13, getIndMonSignFYC());
			pstmt.setDouble(14, getIndMonSignAFYC());
			pstmt.setDouble(15, getIndMonSignNAFYC());
			pstmt.setDouble(16, getGrpMonSignNAFYC());
			pstmt.setDouble(17, getMonPolCnt());
			pstmt.setDouble(18, getMontCustCnt());
			pstmt.setDouble(19, getIndMonPCount());
			pstmt.setDouble(20, getSMmonPolContin());
			pstmt.setDouble(21, getSMmonProduct());
			pstmt.setDouble(22, getSMworkMon());
			pstmt.setDouble(23, getMonPCount());
			pstmt.setDouble(24, getWSMMonPCount());
			pstmt.setDouble(25, getLPMonForSMMP());
			pstmt.setDouble(26, getLPMonForAMMP());
			pstmt.setDouble(27, getLPpolContinute());
			pstmt.setDouble(28, getMonEligFLPCnt());
			pstmt.setDouble(29, getTSRmonAFYP());
			pstmt.setDouble(30, getTSRmonDedAFYP());
			pstmt.setDouble(31, getTSRmonCompAFYP());
			pstmt.setDouble(32, getTSRMonWorkDays());
			pstmt.setDouble(33, getMonManPower());
			pstmt.setDouble(34, getMonManCount());
			pstmt.setDouble(35, getMonSAFYPSum());
			pstmt.setDouble(36, getMonTLGrpSAFYPSum());
			pstmt.setDouble(37, getIndYearNAFYC());
			pstmt.setDouble(38, getB12IndEffectAFYC());
			pstmt.setDouble(39, getB12IndAllAFYC());
			pstmt.setDouble(40, getB24IndEffectAFYC());
			pstmt.setDouble(41, getB24IndAllAFYC());
			pstmt.setDouble(42, getIndQutFYC());
			pstmt.setDouble(43, getLPproductivity());
			pstmt.setDouble(44, getLPPPRate());
			pstmt.setDouble(45, getLPPPBonus());
			pstmt.setDouble(46, getLPFincSubsidy());
			pstmt.setDouble(47, getSubsidyRate());
			pstmt.setDouble(48, getB12TeamNAFYC());
			pstmt.setDouble(49, getSMOverride());
			pstmt.setDouble(50, getTeamMonAvgPCount());
			pstmt.setDouble(51, getSMBasicSalary());
			pstmt.setDouble(52, getSMproductivity());
			pstmt.setDouble(53, getSMpolContinute());
			pstmt.setDouble(54, getSMPPRate());
			pstmt.setDouble(55, getSMPPBonus());
			pstmt.setDouble(56, getB24TeamEffectAFYC());
			pstmt.setDouble(57, getB24TeamAllAFYC());
			pstmt.setDouble(58, getTeamQutPremSum());
			pstmt.setDouble(59, getSMRRBonus());
			pstmt.setDouble(60, getSMManPowerDBonus());
			pstmt.setDouble(61, getLPB12ForMPDBonus());
			pstmt.setDouble(62, getSMUsualALLCSum());
			pstmt.setDouble(63, getAMBasicSalary());
			pstmt.setDouble(64, getAMproductivity());
			pstmt.setDouble(65, getAMpolContinute());
			pstmt.setDouble(66, getAMPPRate());
			pstmt.setDouble(67, getAMPPBonus());
			pstmt.setDouble(68, getB12DepNAFYC());
			pstmt.setDouble(69, getAMOverride());
			pstmt.setDouble(70, getDepMonAvgPCount());
			pstmt.setDouble(71, getDepQutPremSum());
			pstmt.setDouble(72, getAMRRBonus());
			pstmt.setDouble(73, getAMManPowerDBonus());
			pstmt.setDouble(74, getProductGrowth());
			pstmt.setDouble(75, getDepQuaFYCSum());
			pstmt.setDouble(76, getAMLiability());
			pstmt.setDouble(77, getReviOpen());
			pstmt.setDouble(78, getT1());
			pstmt.setDouble(79, getT2());
			pstmt.setDouble(80, getT3());
			pstmt.setDouble(81, getT4());
			pstmt.setDouble(82, getT5());
			pstmt.setDouble(83, getT6());
			pstmt.setDouble(84, getT7());
			pstmt.setDouble(85, getT8());
			pstmt.setDouble(86, getT9());
			pstmt.setDouble(87, getT10());
			pstmt.setDouble(88, getT11());
			pstmt.setDouble(89, getT12());
			pstmt.setDouble(90, getT13());
			pstmt.setDouble(91, getT14());
			pstmt.setDouble(92, getT15());
			pstmt.setDouble(93, getT16());
			pstmt.setDouble(94, getT17());
			pstmt.setDouble(95, getT18());
			pstmt.setDouble(96, getT20());
			pstmt.setDouble(97, getT19());
			pstmt.setDouble(98, getMonthIndex());
			pstmt.setDouble(99, getTMonthIndex());
			pstmt.setDouble(100, getASumIndex());
			pstmt.setDouble(101, getWSMMonthEligible());
			pstmt.setDouble(102, getLPQuaPCount());
			pstmt.setDouble(103, getLPQuaFYCSum());
			pstmt.setDouble(104, getB12LPPCount());
			pstmt.setDouble(105, getB12LPNAFYCSum());
			pstmt.setDouble(106, getWSMMonAFYC());
			pstmt.setDouble(107, getWSMTwoMonAFYC());
			pstmt.setDouble(108, getWSMB6AFYC());
			pstmt.setDouble(109, getWSMB6PCount());
			pstmt.setDouble(110, getNetLiveLPCount());
			pstmt.setDouble(111, getNetComLPCount());
			pstmt.setDouble(112, getWSMTwoMonPCount());
			pstmt.setDouble(113, getLPAllNAFYC());
			pstmt.setDouble(114, getLPAllPCount());
			pstmt.setDouble(115, getMonPerSAFYP());
			pstmt.setDouble(116, getTSRThrMonSAFYP());
			pstmt.setDouble(117, getTLThrMonPerSAFYP());
			pstmt.setDouble(118, getMonSubsistCnt());
			pstmt.setDouble(119, getThrMonSubsistCnt());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(120, 12);
			else
				pstmt.setString(120, getState());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(121, 12);
			else
				pstmt.setString(121, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(122, 91);
			else
				pstmt.setDate(122, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(123, 12);
			else
				pstmt.setString(123, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(124, 91);
			else
				pstmt.setDate(124, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(125, 12);
			else
				pstmt.setString(125, getModifyTime());
			if (getAssessMonth() == null || getAssessMonth().equals("null"))
				pstmt.setNull(126, 12);
			else
				pstmt.setString(126, getAssessMonth());
			if (getBranchAttr() == null || getBranchAttr().equals("null"))
				pstmt.setNull(127, 12);
			else
				pstmt.setString(127, getBranchAttr());
			if (getAgentGrade() == null || getAgentGrade().equals("null"))
				pstmt.setNull(128, 12);
			else
				pstmt.setString(128, getAgentGrade());
			pstmt.setDouble(129, getClubPromBonus());
			pstmt.setDouble(130, getClubGradeBonus());
			pstmt.setDouble(131, getClubAssisBonus());
			pstmt.setDouble(132, getClubSpecBonus());
			pstmt.setDouble(133, getAdddedMoney());
			pstmt.setDouble(134, getLastMoney());
			pstmt.setDouble(135, getShouldMoney());
			pstmt.setDouble(136, getBusinessTax());
			pstmt.setDouble(137, getEduTax());
			pstmt.setDouble(138, getBuildTax());
			pstmt.setDouble(139, getBusiCharge());
			pstmt.setDouble(140, getIncomeTax());
			pstmt.setDouble(141, getSumMoney());
			pstmt.setDouble(142, getAfterTaxMoney());
			pstmt.setDouble(143, getOperInCome());
			pstmt.setDouble(144, getT21());
			pstmt.setDouble(145, getT22());
			pstmt.setDouble(146, getT23());
			pstmt.setDouble(147, getT24());
			pstmt.setDouble(148, getT25());
			if (getIndexCalNo() == null || getIndexCalNo().equals("null"))
				pstmt.setNull(149, 12);
			else
				pstmt.setString(149, getIndexCalNo());
			if (getIndexType() == null || getIndexType().equals("null"))
				pstmt.setNull(150, 12);
			else
				pstmt.setString(150, getIndexType());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(151, 12);
			else
				pstmt.setString(151, getAgentCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoDB";
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
			pstmt = con.prepareStatement("INSERT INTO LAIndexInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getIndexCalNo() == null || getIndexCalNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getIndexCalNo());
			if (getIndexType() == null || getIndexType().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getIndexType());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAgentCode());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getAgentGroup());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getManageCom());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getStartDate()));
			if (getStartEnd() == null || getStartEnd().equals("null"))
				pstmt.setNull(7, 91);
			else
				pstmt.setDate(7, Date.valueOf(getStartEnd()));
			pstmt.setInt(8, getQuaBgnMark());
			pstmt.setInt(9, getServerMonths());
			pstmt.setInt(10, getPostMonths());
			pstmt.setDouble(11, getIndMonthFYC());
			pstmt.setDouble(12, getIndMonthSYC());
			pstmt.setDouble(13, getIndMonSignFYC());
			pstmt.setDouble(14, getIndMonSignAFYC());
			pstmt.setDouble(15, getIndMonSignNAFYC());
			pstmt.setDouble(16, getGrpMonSignNAFYC());
			pstmt.setDouble(17, getMonPolCnt());
			pstmt.setDouble(18, getMontCustCnt());
			pstmt.setDouble(19, getIndMonPCount());
			pstmt.setDouble(20, getSMmonPolContin());
			pstmt.setDouble(21, getSMmonProduct());
			pstmt.setDouble(22, getSMworkMon());
			pstmt.setDouble(23, getMonPCount());
			pstmt.setDouble(24, getWSMMonPCount());
			pstmt.setDouble(25, getLPMonForSMMP());
			pstmt.setDouble(26, getLPMonForAMMP());
			pstmt.setDouble(27, getLPpolContinute());
			pstmt.setDouble(28, getMonEligFLPCnt());
			pstmt.setDouble(29, getTSRmonAFYP());
			pstmt.setDouble(30, getTSRmonDedAFYP());
			pstmt.setDouble(31, getTSRmonCompAFYP());
			pstmt.setDouble(32, getTSRMonWorkDays());
			pstmt.setDouble(33, getMonManPower());
			pstmt.setDouble(34, getMonManCount());
			pstmt.setDouble(35, getMonSAFYPSum());
			pstmt.setDouble(36, getMonTLGrpSAFYPSum());
			pstmt.setDouble(37, getIndYearNAFYC());
			pstmt.setDouble(38, getB12IndEffectAFYC());
			pstmt.setDouble(39, getB12IndAllAFYC());
			pstmt.setDouble(40, getB24IndEffectAFYC());
			pstmt.setDouble(41, getB24IndAllAFYC());
			pstmt.setDouble(42, getIndQutFYC());
			pstmt.setDouble(43, getLPproductivity());
			pstmt.setDouble(44, getLPPPRate());
			pstmt.setDouble(45, getLPPPBonus());
			pstmt.setDouble(46, getLPFincSubsidy());
			pstmt.setDouble(47, getSubsidyRate());
			pstmt.setDouble(48, getB12TeamNAFYC());
			pstmt.setDouble(49, getSMOverride());
			pstmt.setDouble(50, getTeamMonAvgPCount());
			pstmt.setDouble(51, getSMBasicSalary());
			pstmt.setDouble(52, getSMproductivity());
			pstmt.setDouble(53, getSMpolContinute());
			pstmt.setDouble(54, getSMPPRate());
			pstmt.setDouble(55, getSMPPBonus());
			pstmt.setDouble(56, getB24TeamEffectAFYC());
			pstmt.setDouble(57, getB24TeamAllAFYC());
			pstmt.setDouble(58, getTeamQutPremSum());
			pstmt.setDouble(59, getSMRRBonus());
			pstmt.setDouble(60, getSMManPowerDBonus());
			pstmt.setDouble(61, getLPB12ForMPDBonus());
			pstmt.setDouble(62, getSMUsualALLCSum());
			pstmt.setDouble(63, getAMBasicSalary());
			pstmt.setDouble(64, getAMproductivity());
			pstmt.setDouble(65, getAMpolContinute());
			pstmt.setDouble(66, getAMPPRate());
			pstmt.setDouble(67, getAMPPBonus());
			pstmt.setDouble(68, getB12DepNAFYC());
			pstmt.setDouble(69, getAMOverride());
			pstmt.setDouble(70, getDepMonAvgPCount());
			pstmt.setDouble(71, getDepQutPremSum());
			pstmt.setDouble(72, getAMRRBonus());
			pstmt.setDouble(73, getAMManPowerDBonus());
			pstmt.setDouble(74, getProductGrowth());
			pstmt.setDouble(75, getDepQuaFYCSum());
			pstmt.setDouble(76, getAMLiability());
			pstmt.setDouble(77, getReviOpen());
			pstmt.setDouble(78, getT1());
			pstmt.setDouble(79, getT2());
			pstmt.setDouble(80, getT3());
			pstmt.setDouble(81, getT4());
			pstmt.setDouble(82, getT5());
			pstmt.setDouble(83, getT6());
			pstmt.setDouble(84, getT7());
			pstmt.setDouble(85, getT8());
			pstmt.setDouble(86, getT9());
			pstmt.setDouble(87, getT10());
			pstmt.setDouble(88, getT11());
			pstmt.setDouble(89, getT12());
			pstmt.setDouble(90, getT13());
			pstmt.setDouble(91, getT14());
			pstmt.setDouble(92, getT15());
			pstmt.setDouble(93, getT16());
			pstmt.setDouble(94, getT17());
			pstmt.setDouble(95, getT18());
			pstmt.setDouble(96, getT20());
			pstmt.setDouble(97, getT19());
			pstmt.setDouble(98, getMonthIndex());
			pstmt.setDouble(99, getTMonthIndex());
			pstmt.setDouble(100, getASumIndex());
			pstmt.setDouble(101, getWSMMonthEligible());
			pstmt.setDouble(102, getLPQuaPCount());
			pstmt.setDouble(103, getLPQuaFYCSum());
			pstmt.setDouble(104, getB12LPPCount());
			pstmt.setDouble(105, getB12LPNAFYCSum());
			pstmt.setDouble(106, getWSMMonAFYC());
			pstmt.setDouble(107, getWSMTwoMonAFYC());
			pstmt.setDouble(108, getWSMB6AFYC());
			pstmt.setDouble(109, getWSMB6PCount());
			pstmt.setDouble(110, getNetLiveLPCount());
			pstmt.setDouble(111, getNetComLPCount());
			pstmt.setDouble(112, getWSMTwoMonPCount());
			pstmt.setDouble(113, getLPAllNAFYC());
			pstmt.setDouble(114, getLPAllPCount());
			pstmt.setDouble(115, getMonPerSAFYP());
			pstmt.setDouble(116, getTSRThrMonSAFYP());
			pstmt.setDouble(117, getTLThrMonPerSAFYP());
			pstmt.setDouble(118, getMonSubsistCnt());
			pstmt.setDouble(119, getThrMonSubsistCnt());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(120, 12);
			else
				pstmt.setString(120, getState());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(121, 12);
			else
				pstmt.setString(121, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(122, 91);
			else
				pstmt.setDate(122, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(123, 12);
			else
				pstmt.setString(123, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(124, 91);
			else
				pstmt.setDate(124, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(125, 12);
			else
				pstmt.setString(125, getModifyTime());
			if (getAssessMonth() == null || getAssessMonth().equals("null"))
				pstmt.setNull(126, 12);
			else
				pstmt.setString(126, getAssessMonth());
			if (getBranchAttr() == null || getBranchAttr().equals("null"))
				pstmt.setNull(127, 12);
			else
				pstmt.setString(127, getBranchAttr());
			if (getAgentGrade() == null || getAgentGrade().equals("null"))
				pstmt.setNull(128, 12);
			else
				pstmt.setString(128, getAgentGrade());
			pstmt.setDouble(129, getClubPromBonus());
			pstmt.setDouble(130, getClubGradeBonus());
			pstmt.setDouble(131, getClubAssisBonus());
			pstmt.setDouble(132, getClubSpecBonus());
			pstmt.setDouble(133, getAdddedMoney());
			pstmt.setDouble(134, getLastMoney());
			pstmt.setDouble(135, getShouldMoney());
			pstmt.setDouble(136, getBusinessTax());
			pstmt.setDouble(137, getEduTax());
			pstmt.setDouble(138, getBuildTax());
			pstmt.setDouble(139, getBusiCharge());
			pstmt.setDouble(140, getIncomeTax());
			pstmt.setDouble(141, getSumMoney());
			pstmt.setDouble(142, getAfterTaxMoney());
			pstmt.setDouble(143, getOperInCome());
			pstmt.setDouble(144, getT21());
			pstmt.setDouble(145, getT22());
			pstmt.setDouble(146, getT23());
			pstmt.setDouble(147, getT24());
			pstmt.setDouble(148, getT25());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LAIndexInfo WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?", 1003, 1007);
		if (getIndexCalNo() == null || getIndexCalNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getIndexCalNo());
		if (getIndexType() == null || getIndexType().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getIndexType());
		if (getAgentCode() == null || getAgentCode().equals("null"))
			pstmt.setNull(3, 12);
		else
			pstmt.setString(3, getAgentCode());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_279;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_279;
		CError tError = new CError();
		tError.moduleName = "LAIndexInfoDB";
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
				tError.moduleName = "LAIndexInfoDB";
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

	public LAIndexInfoSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LAIndexInfoSet aLAIndexInfoSet = new LAIndexInfoSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LAIndexInfo");
			LAIndexInfoSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LAIndexInfoSchema s1;
			for (; rs.next(); aLAIndexInfoSet.add(s1))
			{
				i++;
				s1 = new LAIndexInfoSchema();
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
			tError.moduleName = "LAIndexInfoDB";
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
		return aLAIndexInfoSet;
	}

	public LAIndexInfoSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LAIndexInfoSet aLAIndexInfoSet = new LAIndexInfoSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LAIndexInfoSchema s1;
			for (; rs.next(); aLAIndexInfoSet.add(s1))
			{
				i++;
				s1 = new LAIndexInfoSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LAIndexInfoDB";
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
			tError.moduleName = "LAIndexInfoDB";
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
		return aLAIndexInfoSet;
	}

	public LAIndexInfoSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LAIndexInfoSet aLAIndexInfoSet = new LAIndexInfoSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LAIndexInfo");
			LAIndexInfoSchema aSchema = getSchema();
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
				LAIndexInfoSchema s1 = new LAIndexInfoSchema();
				s1.setSchema(rs, i);
				aLAIndexInfoSet.add(s1);
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
			tError.moduleName = "LAIndexInfoDB";
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
		return aLAIndexInfoSet;
	}

	public LAIndexInfoSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LAIndexInfoSet aLAIndexInfoSet = new LAIndexInfoSet();
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
				LAIndexInfoSchema s1 = new LAIndexInfoSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LAIndexInfoDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLAIndexInfoSet.add(s1);
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
			tError.moduleName = "LAIndexInfoDB";
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
		return aLAIndexInfoSet;
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
				SQLString sqlObj = new SQLString("LAIndexInfo");
				LAIndexInfoSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LAIndexInfo ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LAIndexInfoDB";
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
				tError.moduleName = "LAIndexInfoDB";
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
			tError.moduleName = "LAIndexInfoDB";
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
			tError.moduleName = "LAIndexInfoDB";
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
			tError.moduleName = "LAIndexInfoDB";
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
			tError.moduleName = "LAIndexInfoDB";
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

	public LAIndexInfoSet getData()
	{
		int tCount = 0;
		LAIndexInfoSet tLAIndexInfoSet = new LAIndexInfoSet();
		LAIndexInfoSchema tLAIndexInfoSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLAIndexInfoSchema = new LAIndexInfoSchema();
			tLAIndexInfoSchema.setSchema(mResultSet, 1);
			tLAIndexInfoSet.add(tLAIndexInfoSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLAIndexInfoSchema = new LAIndexInfoSchema();
					tLAIndexInfoSchema.setSchema(mResultSet, 1);
					tLAIndexInfoSet.add(tLAIndexInfoSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoDB";
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
		return tLAIndexInfoSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LAIndexInfoDB";
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
			tError.moduleName = "LAIndexInfoDB";
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
				tError.moduleName = "LAIndexInfoDB";
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
			tError.moduleName = "LAIndexInfoDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
