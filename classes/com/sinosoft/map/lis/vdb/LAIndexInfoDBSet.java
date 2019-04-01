// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LAIndexInfoDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.LAIndexInfoSchema;
import com.sinosoft.map.lis.vschema.LAIndexInfoSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class LAIndexInfoDBSet extends LAIndexInfoSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LAIndexInfoDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LAIndexInfo");
		mflag = true;
	}

	public LAIndexInfoDBSet()
	{
		mflag = false;
		db = new DBOper("LAIndexInfo");
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
			tError.moduleName = "LAIndexInfoDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "²Ù×÷Ê§°Ü!";
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
			pstmt = con.prepareStatement("DELETE FROM LAIndexInfo WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getIndexCalNo() == null || get(i).getIndexCalNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getIndexCalNo());
				if (get(i).getIndexType() == null || get(i).getIndexType().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getIndexType());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAgentCode());
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
			tError.moduleName = "LAIndexInfoDBSet";
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
			pstmt = con.prepareStatement("UPDATE LAIndexInfo SET  IndexCalNo = ? , IndexType = ? , AgentCode = ? , AgentGroup = ? , ManageCom = ? , StartDate = ? , StartEnd = ? , QuaBgnMark = ? , ServerMonths = ? , PostMonths = ? , IndMonthFYC = ? , IndMonthSYC = ? , IndMonSignFYC = ? , IndMonSignAFYC = ? , IndMonSignNAFYC = ? , GrpMonSignNAFYC = ? , MonPolCnt = ? , MontCustCnt = ? , IndMonPCount = ? , SMmonPolContin = ? , SMmonProduct = ? , SMworkMon = ? , MonPCount = ? , WSMMonPCount = ? , LPMonForSMMP = ? , LPMonForAMMP = ? , LPpolContinute = ? , MonEligFLPCnt = ? , TSRmonAFYP = ? , TSRmonDedAFYP = ? , TSRmonCompAFYP = ? , TSRMonWorkDays = ? , MonManPower = ? , MonManCount = ? , MonSAFYPSum = ? , MonTLGrpSAFYPSum = ? , IndYearNAFYC = ? , B12IndEffectAFYC = ? , B12IndAllAFYC = ? , B24IndEffectAFYC = ? , B24IndAllAFYC = ? , IndQutFYC = ? , LPproductivity = ? , LPPPRate = ? , LPPPBonus = ? , LPFincSubsidy = ? , SubsidyRate = ? , B12TeamNAFYC = ? , SMOverride = ? , TeamMonAvgPCount = ? , SMBasicSalary = ? , SMproductivity = ? , SMpolContinute = ? , SMPPRate = ? , SMPPBonus = ? , B24TeamEffectAFYC = ? , B24TeamAllAFYC = ? , TeamQutPremSum = ? , SMRRBonus = ? , SMManPowerDBonus = ? , LPB12ForMPDBonus = ? , SMUsualALLCSum = ? , AMBasicSalary = ? , AMproductivity = ? , AMpolContinute = ? , AMPPRate = ? , AMPPBonus = ? , B12DepNAFYC = ? , AMOverride = ? , DepMonAvgPCount = ? , DepQutPremSum = ? , AMRRBonus = ? , AMManPowerDBonus = ? , ProductGrowth = ? , DepQuaFYCSum = ? , AMLiability = ? , ReviOpen = ? , T1 = ? , T2 = ? , T3 = ? , T4 = ? , T5 = ? , T6 = ? , T7 = ? , T8 = ? , T9 = ? , T10 = ? , T11 = ? , T12 = ? , T13 = ? , T14 = ? , T15 = ? , T16 = ? , T17 = ? , T18 = ? , T20 = ? , T19 = ? , MonthIndex = ? , TMonthIndex = ? , ASumIndex = ? , WSMMonthEligible = ? , LPQuaPCount = ? , LPQuaFYCSum = ? , B12LPPCount = ? , B12LPNAFYCSum = ? , WSMMonAFYC = ? , WSMTwoMonAFYC = ? , WSMB6AFYC = ? , WSMB6PCount = ? , NetLiveLPCount = ? , NetComLPCount = ? , WSMTwoMonPCount = ? , LPAllNAFYC = ? , LPAllPCount = ? , MonPerSAFYP = ? , TSRThrMonSAFYP = ? , TLThrMonPerSAFYP = ? , MonSubsistCnt = ? , ThrMonSubsistCnt = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , AssessMonth = ? , BranchAttr = ? , AgentGrade = ? , ClubPromBonus = ? , ClubGradeBonus = ? , ClubAssisBonus = ? , ClubSpecBonus = ? , AdddedMoney = ? , LastMoney = ? , ShouldMoney = ? , BusinessTax = ? , EduTax = ? , BuildTax = ? , BusiCharge = ? , IncomeTax = ? , SumMoney = ? , AfterTaxMoney = ? , OperInCome = ? , T21 = ? , T22 = ? , T23 = ? , T24 = ? , T25 = ? WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getIndexCalNo() == null || get(i).getIndexCalNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getIndexCalNo());
				if (get(i).getIndexType() == null || get(i).getIndexType().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getIndexType());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAgentCode());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAgentGroup());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getStartDate()));
				if (get(i).getStartEnd() == null || get(i).getStartEnd().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getStartEnd()));
				pstmt.setInt(8, get(i).getQuaBgnMark());
				pstmt.setInt(9, get(i).getServerMonths());
				pstmt.setInt(10, get(i).getPostMonths());
				pstmt.setDouble(11, get(i).getIndMonthFYC());
				pstmt.setDouble(12, get(i).getIndMonthSYC());
				pstmt.setDouble(13, get(i).getIndMonSignFYC());
				pstmt.setDouble(14, get(i).getIndMonSignAFYC());
				pstmt.setDouble(15, get(i).getIndMonSignNAFYC());
				pstmt.setDouble(16, get(i).getGrpMonSignNAFYC());
				pstmt.setDouble(17, get(i).getMonPolCnt());
				pstmt.setDouble(18, get(i).getMontCustCnt());
				pstmt.setDouble(19, get(i).getIndMonPCount());
				pstmt.setDouble(20, get(i).getSMmonPolContin());
				pstmt.setDouble(21, get(i).getSMmonProduct());
				pstmt.setDouble(22, get(i).getSMworkMon());
				pstmt.setDouble(23, get(i).getMonPCount());
				pstmt.setDouble(24, get(i).getWSMMonPCount());
				pstmt.setDouble(25, get(i).getLPMonForSMMP());
				pstmt.setDouble(26, get(i).getLPMonForAMMP());
				pstmt.setDouble(27, get(i).getLPpolContinute());
				pstmt.setDouble(28, get(i).getMonEligFLPCnt());
				pstmt.setDouble(29, get(i).getTSRmonAFYP());
				pstmt.setDouble(30, get(i).getTSRmonDedAFYP());
				pstmt.setDouble(31, get(i).getTSRmonCompAFYP());
				pstmt.setDouble(32, get(i).getTSRMonWorkDays());
				pstmt.setDouble(33, get(i).getMonManPower());
				pstmt.setDouble(34, get(i).getMonManCount());
				pstmt.setDouble(35, get(i).getMonSAFYPSum());
				pstmt.setDouble(36, get(i).getMonTLGrpSAFYPSum());
				pstmt.setDouble(37, get(i).getIndYearNAFYC());
				pstmt.setDouble(38, get(i).getB12IndEffectAFYC());
				pstmt.setDouble(39, get(i).getB12IndAllAFYC());
				pstmt.setDouble(40, get(i).getB24IndEffectAFYC());
				pstmt.setDouble(41, get(i).getB24IndAllAFYC());
				pstmt.setDouble(42, get(i).getIndQutFYC());
				pstmt.setDouble(43, get(i).getLPproductivity());
				pstmt.setDouble(44, get(i).getLPPPRate());
				pstmt.setDouble(45, get(i).getLPPPBonus());
				pstmt.setDouble(46, get(i).getLPFincSubsidy());
				pstmt.setDouble(47, get(i).getSubsidyRate());
				pstmt.setDouble(48, get(i).getB12TeamNAFYC());
				pstmt.setDouble(49, get(i).getSMOverride());
				pstmt.setDouble(50, get(i).getTeamMonAvgPCount());
				pstmt.setDouble(51, get(i).getSMBasicSalary());
				pstmt.setDouble(52, get(i).getSMproductivity());
				pstmt.setDouble(53, get(i).getSMpolContinute());
				pstmt.setDouble(54, get(i).getSMPPRate());
				pstmt.setDouble(55, get(i).getSMPPBonus());
				pstmt.setDouble(56, get(i).getB24TeamEffectAFYC());
				pstmt.setDouble(57, get(i).getB24TeamAllAFYC());
				pstmt.setDouble(58, get(i).getTeamQutPremSum());
				pstmt.setDouble(59, get(i).getSMRRBonus());
				pstmt.setDouble(60, get(i).getSMManPowerDBonus());
				pstmt.setDouble(61, get(i).getLPB12ForMPDBonus());
				pstmt.setDouble(62, get(i).getSMUsualALLCSum());
				pstmt.setDouble(63, get(i).getAMBasicSalary());
				pstmt.setDouble(64, get(i).getAMproductivity());
				pstmt.setDouble(65, get(i).getAMpolContinute());
				pstmt.setDouble(66, get(i).getAMPPRate());
				pstmt.setDouble(67, get(i).getAMPPBonus());
				pstmt.setDouble(68, get(i).getB12DepNAFYC());
				pstmt.setDouble(69, get(i).getAMOverride());
				pstmt.setDouble(70, get(i).getDepMonAvgPCount());
				pstmt.setDouble(71, get(i).getDepQutPremSum());
				pstmt.setDouble(72, get(i).getAMRRBonus());
				pstmt.setDouble(73, get(i).getAMManPowerDBonus());
				pstmt.setDouble(74, get(i).getProductGrowth());
				pstmt.setDouble(75, get(i).getDepQuaFYCSum());
				pstmt.setDouble(76, get(i).getAMLiability());
				pstmt.setDouble(77, get(i).getReviOpen());
				pstmt.setDouble(78, get(i).getT1());
				pstmt.setDouble(79, get(i).getT2());
				pstmt.setDouble(80, get(i).getT3());
				pstmt.setDouble(81, get(i).getT4());
				pstmt.setDouble(82, get(i).getT5());
				pstmt.setDouble(83, get(i).getT6());
				pstmt.setDouble(84, get(i).getT7());
				pstmt.setDouble(85, get(i).getT8());
				pstmt.setDouble(86, get(i).getT9());
				pstmt.setDouble(87, get(i).getT10());
				pstmt.setDouble(88, get(i).getT11());
				pstmt.setDouble(89, get(i).getT12());
				pstmt.setDouble(90, get(i).getT13());
				pstmt.setDouble(91, get(i).getT14());
				pstmt.setDouble(92, get(i).getT15());
				pstmt.setDouble(93, get(i).getT16());
				pstmt.setDouble(94, get(i).getT17());
				pstmt.setDouble(95, get(i).getT18());
				pstmt.setDouble(96, get(i).getT20());
				pstmt.setDouble(97, get(i).getT19());
				pstmt.setDouble(98, get(i).getMonthIndex());
				pstmt.setDouble(99, get(i).getTMonthIndex());
				pstmt.setDouble(100, get(i).getASumIndex());
				pstmt.setDouble(101, get(i).getWSMMonthEligible());
				pstmt.setDouble(102, get(i).getLPQuaPCount());
				pstmt.setDouble(103, get(i).getLPQuaFYCSum());
				pstmt.setDouble(104, get(i).getB12LPPCount());
				pstmt.setDouble(105, get(i).getB12LPNAFYCSum());
				pstmt.setDouble(106, get(i).getWSMMonAFYC());
				pstmt.setDouble(107, get(i).getWSMTwoMonAFYC());
				pstmt.setDouble(108, get(i).getWSMB6AFYC());
				pstmt.setDouble(109, get(i).getWSMB6PCount());
				pstmt.setDouble(110, get(i).getNetLiveLPCount());
				pstmt.setDouble(111, get(i).getNetComLPCount());
				pstmt.setDouble(112, get(i).getWSMTwoMonPCount());
				pstmt.setDouble(113, get(i).getLPAllNAFYC());
				pstmt.setDouble(114, get(i).getLPAllPCount());
				pstmt.setDouble(115, get(i).getMonPerSAFYP());
				pstmt.setDouble(116, get(i).getTSRThrMonSAFYP());
				pstmt.setDouble(117, get(i).getTLThrMonPerSAFYP());
				pstmt.setDouble(118, get(i).getMonSubsistCnt());
				pstmt.setDouble(119, get(i).getThrMonSubsistCnt());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(120, null);
				else
					pstmt.setString(120, get(i).getState());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(121, null);
				else
					pstmt.setString(121, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(122, null);
				else
					pstmt.setDate(122, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(123, null);
				else
					pstmt.setString(123, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(124, null);
				else
					pstmt.setDate(124, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(125, null);
				else
					pstmt.setString(125, get(i).getModifyTime());
				if (get(i).getAssessMonth() == null || get(i).getAssessMonth().equals("null"))
					pstmt.setString(126, null);
				else
					pstmt.setString(126, get(i).getAssessMonth());
				if (get(i).getBranchAttr() == null || get(i).getBranchAttr().equals("null"))
					pstmt.setString(127, null);
				else
					pstmt.setString(127, get(i).getBranchAttr());
				if (get(i).getAgentGrade() == null || get(i).getAgentGrade().equals("null"))
					pstmt.setString(128, null);
				else
					pstmt.setString(128, get(i).getAgentGrade());
				pstmt.setDouble(129, get(i).getClubPromBonus());
				pstmt.setDouble(130, get(i).getClubGradeBonus());
				pstmt.setDouble(131, get(i).getClubAssisBonus());
				pstmt.setDouble(132, get(i).getClubSpecBonus());
				pstmt.setDouble(133, get(i).getAdddedMoney());
				pstmt.setDouble(134, get(i).getLastMoney());
				pstmt.setDouble(135, get(i).getShouldMoney());
				pstmt.setDouble(136, get(i).getBusinessTax());
				pstmt.setDouble(137, get(i).getEduTax());
				pstmt.setDouble(138, get(i).getBuildTax());
				pstmt.setDouble(139, get(i).getBusiCharge());
				pstmt.setDouble(140, get(i).getIncomeTax());
				pstmt.setDouble(141, get(i).getSumMoney());
				pstmt.setDouble(142, get(i).getAfterTaxMoney());
				pstmt.setDouble(143, get(i).getOperInCome());
				pstmt.setDouble(144, get(i).getT21());
				pstmt.setDouble(145, get(i).getT22());
				pstmt.setDouble(146, get(i).getT23());
				pstmt.setDouble(147, get(i).getT24());
				pstmt.setDouble(148, get(i).getT25());
				if (get(i).getIndexCalNo() == null || get(i).getIndexCalNo().equals("null"))
					pstmt.setString(149, null);
				else
					pstmt.setString(149, get(i).getIndexCalNo());
				if (get(i).getIndexType() == null || get(i).getIndexType().equals("null"))
					pstmt.setString(150, null);
				else
					pstmt.setString(150, get(i).getIndexType());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(151, null);
				else
					pstmt.setString(151, get(i).getAgentCode());
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
			tError.moduleName = "LAIndexInfoDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LAIndexInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getIndexCalNo() == null || get(i).getIndexCalNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getIndexCalNo());
				if (get(i).getIndexType() == null || get(i).getIndexType().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getIndexType());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAgentCode());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAgentGroup());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getStartDate()));
				if (get(i).getStartEnd() == null || get(i).getStartEnd().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getStartEnd()));
				pstmt.setInt(8, get(i).getQuaBgnMark());
				pstmt.setInt(9, get(i).getServerMonths());
				pstmt.setInt(10, get(i).getPostMonths());
				pstmt.setDouble(11, get(i).getIndMonthFYC());
				pstmt.setDouble(12, get(i).getIndMonthSYC());
				pstmt.setDouble(13, get(i).getIndMonSignFYC());
				pstmt.setDouble(14, get(i).getIndMonSignAFYC());
				pstmt.setDouble(15, get(i).getIndMonSignNAFYC());
				pstmt.setDouble(16, get(i).getGrpMonSignNAFYC());
				pstmt.setDouble(17, get(i).getMonPolCnt());
				pstmt.setDouble(18, get(i).getMontCustCnt());
				pstmt.setDouble(19, get(i).getIndMonPCount());
				pstmt.setDouble(20, get(i).getSMmonPolContin());
				pstmt.setDouble(21, get(i).getSMmonProduct());
				pstmt.setDouble(22, get(i).getSMworkMon());
				pstmt.setDouble(23, get(i).getMonPCount());
				pstmt.setDouble(24, get(i).getWSMMonPCount());
				pstmt.setDouble(25, get(i).getLPMonForSMMP());
				pstmt.setDouble(26, get(i).getLPMonForAMMP());
				pstmt.setDouble(27, get(i).getLPpolContinute());
				pstmt.setDouble(28, get(i).getMonEligFLPCnt());
				pstmt.setDouble(29, get(i).getTSRmonAFYP());
				pstmt.setDouble(30, get(i).getTSRmonDedAFYP());
				pstmt.setDouble(31, get(i).getTSRmonCompAFYP());
				pstmt.setDouble(32, get(i).getTSRMonWorkDays());
				pstmt.setDouble(33, get(i).getMonManPower());
				pstmt.setDouble(34, get(i).getMonManCount());
				pstmt.setDouble(35, get(i).getMonSAFYPSum());
				pstmt.setDouble(36, get(i).getMonTLGrpSAFYPSum());
				pstmt.setDouble(37, get(i).getIndYearNAFYC());
				pstmt.setDouble(38, get(i).getB12IndEffectAFYC());
				pstmt.setDouble(39, get(i).getB12IndAllAFYC());
				pstmt.setDouble(40, get(i).getB24IndEffectAFYC());
				pstmt.setDouble(41, get(i).getB24IndAllAFYC());
				pstmt.setDouble(42, get(i).getIndQutFYC());
				pstmt.setDouble(43, get(i).getLPproductivity());
				pstmt.setDouble(44, get(i).getLPPPRate());
				pstmt.setDouble(45, get(i).getLPPPBonus());
				pstmt.setDouble(46, get(i).getLPFincSubsidy());
				pstmt.setDouble(47, get(i).getSubsidyRate());
				pstmt.setDouble(48, get(i).getB12TeamNAFYC());
				pstmt.setDouble(49, get(i).getSMOverride());
				pstmt.setDouble(50, get(i).getTeamMonAvgPCount());
				pstmt.setDouble(51, get(i).getSMBasicSalary());
				pstmt.setDouble(52, get(i).getSMproductivity());
				pstmt.setDouble(53, get(i).getSMpolContinute());
				pstmt.setDouble(54, get(i).getSMPPRate());
				pstmt.setDouble(55, get(i).getSMPPBonus());
				pstmt.setDouble(56, get(i).getB24TeamEffectAFYC());
				pstmt.setDouble(57, get(i).getB24TeamAllAFYC());
				pstmt.setDouble(58, get(i).getTeamQutPremSum());
				pstmt.setDouble(59, get(i).getSMRRBonus());
				pstmt.setDouble(60, get(i).getSMManPowerDBonus());
				pstmt.setDouble(61, get(i).getLPB12ForMPDBonus());
				pstmt.setDouble(62, get(i).getSMUsualALLCSum());
				pstmt.setDouble(63, get(i).getAMBasicSalary());
				pstmt.setDouble(64, get(i).getAMproductivity());
				pstmt.setDouble(65, get(i).getAMpolContinute());
				pstmt.setDouble(66, get(i).getAMPPRate());
				pstmt.setDouble(67, get(i).getAMPPBonus());
				pstmt.setDouble(68, get(i).getB12DepNAFYC());
				pstmt.setDouble(69, get(i).getAMOverride());
				pstmt.setDouble(70, get(i).getDepMonAvgPCount());
				pstmt.setDouble(71, get(i).getDepQutPremSum());
				pstmt.setDouble(72, get(i).getAMRRBonus());
				pstmt.setDouble(73, get(i).getAMManPowerDBonus());
				pstmt.setDouble(74, get(i).getProductGrowth());
				pstmt.setDouble(75, get(i).getDepQuaFYCSum());
				pstmt.setDouble(76, get(i).getAMLiability());
				pstmt.setDouble(77, get(i).getReviOpen());
				pstmt.setDouble(78, get(i).getT1());
				pstmt.setDouble(79, get(i).getT2());
				pstmt.setDouble(80, get(i).getT3());
				pstmt.setDouble(81, get(i).getT4());
				pstmt.setDouble(82, get(i).getT5());
				pstmt.setDouble(83, get(i).getT6());
				pstmt.setDouble(84, get(i).getT7());
				pstmt.setDouble(85, get(i).getT8());
				pstmt.setDouble(86, get(i).getT9());
				pstmt.setDouble(87, get(i).getT10());
				pstmt.setDouble(88, get(i).getT11());
				pstmt.setDouble(89, get(i).getT12());
				pstmt.setDouble(90, get(i).getT13());
				pstmt.setDouble(91, get(i).getT14());
				pstmt.setDouble(92, get(i).getT15());
				pstmt.setDouble(93, get(i).getT16());
				pstmt.setDouble(94, get(i).getT17());
				pstmt.setDouble(95, get(i).getT18());
				pstmt.setDouble(96, get(i).getT20());
				pstmt.setDouble(97, get(i).getT19());
				pstmt.setDouble(98, get(i).getMonthIndex());
				pstmt.setDouble(99, get(i).getTMonthIndex());
				pstmt.setDouble(100, get(i).getASumIndex());
				pstmt.setDouble(101, get(i).getWSMMonthEligible());
				pstmt.setDouble(102, get(i).getLPQuaPCount());
				pstmt.setDouble(103, get(i).getLPQuaFYCSum());
				pstmt.setDouble(104, get(i).getB12LPPCount());
				pstmt.setDouble(105, get(i).getB12LPNAFYCSum());
				pstmt.setDouble(106, get(i).getWSMMonAFYC());
				pstmt.setDouble(107, get(i).getWSMTwoMonAFYC());
				pstmt.setDouble(108, get(i).getWSMB6AFYC());
				pstmt.setDouble(109, get(i).getWSMB6PCount());
				pstmt.setDouble(110, get(i).getNetLiveLPCount());
				pstmt.setDouble(111, get(i).getNetComLPCount());
				pstmt.setDouble(112, get(i).getWSMTwoMonPCount());
				pstmt.setDouble(113, get(i).getLPAllNAFYC());
				pstmt.setDouble(114, get(i).getLPAllPCount());
				pstmt.setDouble(115, get(i).getMonPerSAFYP());
				pstmt.setDouble(116, get(i).getTSRThrMonSAFYP());
				pstmt.setDouble(117, get(i).getTLThrMonPerSAFYP());
				pstmt.setDouble(118, get(i).getMonSubsistCnt());
				pstmt.setDouble(119, get(i).getThrMonSubsistCnt());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(120, null);
				else
					pstmt.setString(120, get(i).getState());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(121, null);
				else
					pstmt.setString(121, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(122, null);
				else
					pstmt.setDate(122, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(123, null);
				else
					pstmt.setString(123, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(124, null);
				else
					pstmt.setDate(124, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(125, null);
				else
					pstmt.setString(125, get(i).getModifyTime());
				if (get(i).getAssessMonth() == null || get(i).getAssessMonth().equals("null"))
					pstmt.setString(126, null);
				else
					pstmt.setString(126, get(i).getAssessMonth());
				if (get(i).getBranchAttr() == null || get(i).getBranchAttr().equals("null"))
					pstmt.setString(127, null);
				else
					pstmt.setString(127, get(i).getBranchAttr());
				if (get(i).getAgentGrade() == null || get(i).getAgentGrade().equals("null"))
					pstmt.setString(128, null);
				else
					pstmt.setString(128, get(i).getAgentGrade());
				pstmt.setDouble(129, get(i).getClubPromBonus());
				pstmt.setDouble(130, get(i).getClubGradeBonus());
				pstmt.setDouble(131, get(i).getClubAssisBonus());
				pstmt.setDouble(132, get(i).getClubSpecBonus());
				pstmt.setDouble(133, get(i).getAdddedMoney());
				pstmt.setDouble(134, get(i).getLastMoney());
				pstmt.setDouble(135, get(i).getShouldMoney());
				pstmt.setDouble(136, get(i).getBusinessTax());
				pstmt.setDouble(137, get(i).getEduTax());
				pstmt.setDouble(138, get(i).getBuildTax());
				pstmt.setDouble(139, get(i).getBusiCharge());
				pstmt.setDouble(140, get(i).getIncomeTax());
				pstmt.setDouble(141, get(i).getSumMoney());
				pstmt.setDouble(142, get(i).getAfterTaxMoney());
				pstmt.setDouble(143, get(i).getOperInCome());
				pstmt.setDouble(144, get(i).getT21());
				pstmt.setDouble(145, get(i).getT22());
				pstmt.setDouble(146, get(i).getT23());
				pstmt.setDouble(147, get(i).getT24());
				pstmt.setDouble(148, get(i).getT25());
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
			tError.moduleName = "LAIndexInfoDBSet";
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
