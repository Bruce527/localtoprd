// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LAIndexInfoNewDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.LAIndexInfoNewSchema;
import com.sinosoft.map.lis.vschema.LAIndexInfoNewSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class LAIndexInfoNewDB extends LAIndexInfoNewSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LAIndexInfoNewDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LAIndexInfoNew");
		mflag = true;
	}

	public LAIndexInfoNewDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LAIndexInfoNew");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LAIndexInfoNewSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoNewDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LAIndexInfoNewSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoNewDB";
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
			pstmt = con.prepareStatement("DELETE FROM LAIndexInfoNew WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
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
			tError.moduleName = "LAIndexInfoNewDB";
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
			pstmt = con.prepareStatement("UPDATE LAIndexInfoNew SET  IndexCalNo = ? , IndexType = ? , ManageCom = ? , AgentGroup = ? , BranchAttr = ? , AgentCode = ? , AgentGrade = ? , AgentTitle = ? , QuaBgnMark = ? , PostMonths = ? , AssessMonth = ? , AgentGrade1 = ? , AgentTitle1 = ? , AgentGrade2 = ? , AgentTitle2 = ? , AgentGrade3 = ? , AgentTitle3 = ? , StartDate = ? , StartEnd = ? , StartDate1 = ? , StartEnd1 = ? , StartDate2 = ? , StartEnd2 = ? , StartDate3 = ? , StartEnd3 = ? , StartEnd4 = ? , StartDate4 = ? , ServerMonths = ? , NT01 = ? , NT02 = ? , NT03 = ? , NT04 = ? , NT05 = ? , NT06 = ? , NT07 = ? , NT08 = ? , NT09 = ? , NT10 = ? , NT11 = ? , NT12 = ? , NT13 = ? , NT14 = ? , NT15 = ? , NT16 = ? , NT17 = ? , NT18 = ? , NT19 = ? , NT20 = ? , NT21 = ? , NT22 = ? , NT23 = ? , NT24 = ? , NT25 = ? , NT26 = ? , NT27 = ? , NT28 = ? , NT29 = ? , NT30 = ? , NT31 = ? , NT32 = ? , NT33 = ? , NT34 = ? , NT35 = ? , NT36 = ? , NT37 = ? , NT38 = ? , NT39 = ? , NT40 = ? , NT41 = ? , NT42 = ? , NT43 = ? , NT44 = ? , NT45 = ? , NT46 = ? , NT47 = ? , NT48 = ? , NT49 = ? , NT50 = ? , NT51 = ? , NT52 = ? , NT53 = ? , NT54 = ? , NT55 = ? , NT56 = ? , NT57 = ? , NT58 = ? , NT59 = ? , NT60 = ? , NT61 = ? , NT62 = ? , NT63 = ? , NT64 = ? , NT65 = ? , NT66 = ? , NT67 = ? , NT68 = ? , NT69 = ? , NT70 = ? , NT71 = ? , NT72 = ? , NT73 = ? , NT74 = ? , NT75 = ? , NT76 = ? , NT77 = ? , NT78 = ? , NT79 = ? , NT80 = ? , NF01 = ? , NF02 = ? , NF03 = ? , NF04 = ? , NF05 = ? , NF06 = ? , NF07 = ? , NF08 = ? , NF09 = ? , NF10 = ? , NS01 = ? , NS02 = ? , NS03 = ? , NS04 = ? , NS05 = ? , NS06 = ? , NS07 = ? , NS08 = ? , NS09 = ? , NS10 = ? , INT01 = ? , INT02 = ? , INT03 = ? , INT04 = ? , INT05 = ? , INT06 = ? , INT07 = ? , INT08 = ? , INT09 = ? , INT10 = ? , INT11 = ? , INT12 = ? , INT13 = ? , INT14 = ? , INT15 = ? , INT16 = ? , INT17 = ? , INT18 = ? , INT19 = ? , INT20 = ? , INT21 = ? , INT22 = ? , INT23 = ? , INT24 = ? , INT25 = ? , V1 = ? , V2 = ? , V3 = ? , V4 = ? , V5 = ? , V6 = ? , V7 = ? , V8 = ? , V9 = ? , V10 = ? , V11 = ? , V12 = ? , V13 = ? , V14 = ? , V15 = ? , V16 = ? , V17 = ? , V18 = ? , V19 = ? , V20 = ? , VT1 = ? , VT2 = ? , VT3 = ? , VT4 = ? , VT5 = ? , VT6 = ? , VT7 = ? , VT8 = ? , VE1 = ? , VE2 = ? , VE3 = ? , VE4 = ? , VE5 = ? , VE6 = ? , VE7 = ? , VE8 = ? , VE9 = ? , VE10 = ? , D1 = ? , D2 = ? , D3 = ? , D4 = ? , D5 = ? , D6 = ? , D7 = ? , D8 = ? , D9 = ? , D10 = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
			if (getIndexCalNo() == null || getIndexCalNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getIndexCalNo());
			if (getIndexType() == null || getIndexType().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getIndexType());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getManageCom());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getAgentGroup());
			if (getBranchAttr() == null || getBranchAttr().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getBranchAttr());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getAgentCode());
			if (getAgentGrade() == null || getAgentGrade().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getAgentGrade());
			if (getAgentTitle() == null || getAgentTitle().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAgentTitle());
			pstmt.setInt(9, getQuaBgnMark());
			pstmt.setInt(10, getPostMonths());
			if (getAssessMonth() == null || getAssessMonth().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getAssessMonth());
			if (getAgentGrade1() == null || getAgentGrade1().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getAgentGrade1());
			if (getAgentTitle1() == null || getAgentTitle1().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAgentTitle1());
			if (getAgentGrade2() == null || getAgentGrade2().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getAgentGrade2());
			if (getAgentTitle2() == null || getAgentTitle2().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getAgentTitle2());
			if (getAgentGrade3() == null || getAgentGrade3().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getAgentGrade3());
			if (getAgentTitle3() == null || getAgentTitle3().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getAgentTitle3());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getStartDate()));
			if (getStartEnd() == null || getStartEnd().equals("null"))
				pstmt.setNull(19, 91);
			else
				pstmt.setDate(19, Date.valueOf(getStartEnd()));
			if (getStartDate1() == null || getStartDate1().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getStartDate1()));
			if (getStartEnd1() == null || getStartEnd1().equals("null"))
				pstmt.setNull(21, 91);
			else
				pstmt.setDate(21, Date.valueOf(getStartEnd1()));
			if (getStartDate2() == null || getStartDate2().equals("null"))
				pstmt.setNull(22, 91);
			else
				pstmt.setDate(22, Date.valueOf(getStartDate2()));
			if (getStartEnd2() == null || getStartEnd2().equals("null"))
				pstmt.setNull(23, 91);
			else
				pstmt.setDate(23, Date.valueOf(getStartEnd2()));
			if (getStartDate3() == null || getStartDate3().equals("null"))
				pstmt.setNull(24, 91);
			else
				pstmt.setDate(24, Date.valueOf(getStartDate3()));
			if (getStartEnd3() == null || getStartEnd3().equals("null"))
				pstmt.setNull(25, 91);
			else
				pstmt.setDate(25, Date.valueOf(getStartEnd3()));
			if (getStartEnd4() == null || getStartEnd4().equals("null"))
				pstmt.setNull(26, 91);
			else
				pstmt.setDate(26, Date.valueOf(getStartEnd4()));
			if (getStartDate4() == null || getStartDate4().equals("null"))
				pstmt.setNull(27, 91);
			else
				pstmt.setDate(27, Date.valueOf(getStartDate4()));
			pstmt.setInt(28, getServerMonths());
			pstmt.setDouble(29, getNT01());
			pstmt.setDouble(30, getNT02());
			pstmt.setDouble(31, getNT03());
			pstmt.setDouble(32, getNT04());
			pstmt.setDouble(33, getNT05());
			pstmt.setDouble(34, getNT06());
			pstmt.setDouble(35, getNT07());
			pstmt.setDouble(36, getNT08());
			pstmt.setDouble(37, getNT09());
			pstmt.setDouble(38, getNT10());
			pstmt.setDouble(39, getNT11());
			pstmt.setDouble(40, getNT12());
			pstmt.setDouble(41, getNT13());
			pstmt.setDouble(42, getNT14());
			pstmt.setDouble(43, getNT15());
			pstmt.setDouble(44, getNT16());
			pstmt.setDouble(45, getNT17());
			pstmt.setDouble(46, getNT18());
			pstmt.setDouble(47, getNT19());
			pstmt.setDouble(48, getNT20());
			pstmt.setDouble(49, getNT21());
			pstmt.setDouble(50, getNT22());
			pstmt.setDouble(51, getNT23());
			pstmt.setDouble(52, getNT24());
			pstmt.setDouble(53, getNT25());
			pstmt.setDouble(54, getNT26());
			pstmt.setDouble(55, getNT27());
			pstmt.setDouble(56, getNT28());
			pstmt.setDouble(57, getNT29());
			pstmt.setDouble(58, getNT30());
			pstmt.setDouble(59, getNT31());
			pstmt.setDouble(60, getNT32());
			pstmt.setDouble(61, getNT33());
			pstmt.setDouble(62, getNT34());
			pstmt.setDouble(63, getNT35());
			pstmt.setDouble(64, getNT36());
			pstmt.setDouble(65, getNT37());
			pstmt.setDouble(66, getNT38());
			pstmt.setDouble(67, getNT39());
			pstmt.setDouble(68, getNT40());
			pstmt.setDouble(69, getNT41());
			pstmt.setDouble(70, getNT42());
			pstmt.setDouble(71, getNT43());
			pstmt.setDouble(72, getNT44());
			pstmt.setDouble(73, getNT45());
			pstmt.setDouble(74, getNT46());
			pstmt.setDouble(75, getNT47());
			pstmt.setDouble(76, getNT48());
			pstmt.setDouble(77, getNT49());
			pstmt.setDouble(78, getNT50());
			pstmt.setDouble(79, getNT51());
			pstmt.setDouble(80, getNT52());
			pstmt.setDouble(81, getNT53());
			pstmt.setDouble(82, getNT54());
			pstmt.setDouble(83, getNT55());
			pstmt.setDouble(84, getNT56());
			pstmt.setDouble(85, getNT57());
			pstmt.setDouble(86, getNT58());
			pstmt.setDouble(87, getNT59());
			pstmt.setDouble(88, getNT60());
			pstmt.setDouble(89, getNT61());
			pstmt.setDouble(90, getNT62());
			pstmt.setDouble(91, getNT63());
			pstmt.setDouble(92, getNT64());
			pstmt.setDouble(93, getNT65());
			pstmt.setDouble(94, getNT66());
			pstmt.setDouble(95, getNT67());
			pstmt.setDouble(96, getNT68());
			pstmt.setDouble(97, getNT69());
			pstmt.setDouble(98, getNT70());
			pstmt.setDouble(99, getNT71());
			pstmt.setDouble(100, getNT72());
			pstmt.setDouble(101, getNT73());
			pstmt.setDouble(102, getNT74());
			pstmt.setDouble(103, getNT75());
			pstmt.setDouble(104, getNT76());
			pstmt.setDouble(105, getNT77());
			pstmt.setDouble(106, getNT78());
			pstmt.setDouble(107, getNT79());
			pstmt.setDouble(108, getNT80());
			pstmt.setDouble(109, getNF01());
			pstmt.setDouble(110, getNF02());
			pstmt.setDouble(111, getNF03());
			pstmt.setDouble(112, getNF04());
			pstmt.setDouble(113, getNF05());
			pstmt.setDouble(114, getNF06());
			pstmt.setDouble(115, getNF07());
			pstmt.setDouble(116, getNF08());
			pstmt.setDouble(117, getNF09());
			pstmt.setDouble(118, getNF10());
			pstmt.setDouble(119, getNS01());
			pstmt.setDouble(120, getNS02());
			pstmt.setDouble(121, getNS03());
			pstmt.setDouble(122, getNS04());
			pstmt.setDouble(123, getNS05());
			pstmt.setDouble(124, getNS06());
			pstmt.setDouble(125, getNS07());
			pstmt.setDouble(126, getNS08());
			pstmt.setDouble(127, getNS09());
			pstmt.setDouble(128, getNS10());
			pstmt.setInt(129, getINT01());
			pstmt.setInt(130, getINT02());
			pstmt.setInt(131, getINT03());
			pstmt.setInt(132, getINT04());
			pstmt.setInt(133, getINT05());
			pstmt.setInt(134, getINT06());
			pstmt.setInt(135, getINT07());
			pstmt.setInt(136, getINT08());
			pstmt.setInt(137, getINT09());
			pstmt.setInt(138, getINT10());
			pstmt.setInt(139, getINT11());
			pstmt.setInt(140, getINT12());
			pstmt.setInt(141, getINT13());
			pstmt.setInt(142, getINT14());
			pstmt.setInt(143, getINT15());
			pstmt.setInt(144, getINT16());
			pstmt.setInt(145, getINT17());
			pstmt.setInt(146, getINT18());
			pstmt.setInt(147, getINT19());
			pstmt.setInt(148, getINT20());
			pstmt.setInt(149, getINT21());
			pstmt.setInt(150, getINT22());
			pstmt.setInt(151, getINT23());
			pstmt.setInt(152, getINT24());
			pstmt.setInt(153, getINT25());
			if (getV1() == null || getV1().equals("null"))
				pstmt.setNull(154, 12);
			else
				pstmt.setString(154, getV1());
			if (getV2() == null || getV2().equals("null"))
				pstmt.setNull(155, 12);
			else
				pstmt.setString(155, getV2());
			if (getV3() == null || getV3().equals("null"))
				pstmt.setNull(156, 12);
			else
				pstmt.setString(156, getV3());
			if (getV4() == null || getV4().equals("null"))
				pstmt.setNull(157, 12);
			else
				pstmt.setString(157, getV4());
			if (getV5() == null || getV5().equals("null"))
				pstmt.setNull(158, 12);
			else
				pstmt.setString(158, getV5());
			if (getV6() == null || getV6().equals("null"))
				pstmt.setNull(159, 12);
			else
				pstmt.setString(159, getV6());
			if (getV7() == null || getV7().equals("null"))
				pstmt.setNull(160, 12);
			else
				pstmt.setString(160, getV7());
			if (getV8() == null || getV8().equals("null"))
				pstmt.setNull(161, 12);
			else
				pstmt.setString(161, getV8());
			if (getV9() == null || getV9().equals("null"))
				pstmt.setNull(162, 12);
			else
				pstmt.setString(162, getV9());
			if (getV10() == null || getV10().equals("null"))
				pstmt.setNull(163, 12);
			else
				pstmt.setString(163, getV10());
			if (getV11() == null || getV11().equals("null"))
				pstmt.setNull(164, 12);
			else
				pstmt.setString(164, getV11());
			if (getV12() == null || getV12().equals("null"))
				pstmt.setNull(165, 12);
			else
				pstmt.setString(165, getV12());
			if (getV13() == null || getV13().equals("null"))
				pstmt.setNull(166, 12);
			else
				pstmt.setString(166, getV13());
			if (getV14() == null || getV14().equals("null"))
				pstmt.setNull(167, 12);
			else
				pstmt.setString(167, getV14());
			if (getV15() == null || getV15().equals("null"))
				pstmt.setNull(168, 12);
			else
				pstmt.setString(168, getV15());
			if (getV16() == null || getV16().equals("null"))
				pstmt.setNull(169, 12);
			else
				pstmt.setString(169, getV16());
			if (getV17() == null || getV17().equals("null"))
				pstmt.setNull(170, 12);
			else
				pstmt.setString(170, getV17());
			if (getV18() == null || getV18().equals("null"))
				pstmt.setNull(171, 12);
			else
				pstmt.setString(171, getV18());
			if (getV19() == null || getV19().equals("null"))
				pstmt.setNull(172, 12);
			else
				pstmt.setString(172, getV19());
			if (getV20() == null || getV20().equals("null"))
				pstmt.setNull(173, 12);
			else
				pstmt.setString(173, getV20());
			if (getVT1() == null || getVT1().equals("null"))
				pstmt.setNull(174, 12);
			else
				pstmt.setString(174, getVT1());
			if (getVT2() == null || getVT2().equals("null"))
				pstmt.setNull(175, 12);
			else
				pstmt.setString(175, getVT2());
			if (getVT3() == null || getVT3().equals("null"))
				pstmt.setNull(176, 12);
			else
				pstmt.setString(176, getVT3());
			if (getVT4() == null || getVT4().equals("null"))
				pstmt.setNull(177, 12);
			else
				pstmt.setString(177, getVT4());
			if (getVT5() == null || getVT5().equals("null"))
				pstmt.setNull(178, 12);
			else
				pstmt.setString(178, getVT5());
			if (getVT6() == null || getVT6().equals("null"))
				pstmt.setNull(179, 12);
			else
				pstmt.setString(179, getVT6());
			if (getVT7() == null || getVT7().equals("null"))
				pstmt.setNull(180, 12);
			else
				pstmt.setString(180, getVT7());
			if (getVT8() == null || getVT8().equals("null"))
				pstmt.setNull(181, 12);
			else
				pstmt.setString(181, getVT8());
			if (getVE1() == null || getVE1().equals("null"))
				pstmt.setNull(182, 12);
			else
				pstmt.setString(182, getVE1());
			if (getVE2() == null || getVE2().equals("null"))
				pstmt.setNull(183, 12);
			else
				pstmt.setString(183, getVE2());
			if (getVE3() == null || getVE3().equals("null"))
				pstmt.setNull(184, 12);
			else
				pstmt.setString(184, getVE3());
			if (getVE4() == null || getVE4().equals("null"))
				pstmt.setNull(185, 12);
			else
				pstmt.setString(185, getVE4());
			if (getVE5() == null || getVE5().equals("null"))
				pstmt.setNull(186, 12);
			else
				pstmt.setString(186, getVE5());
			if (getVE6() == null || getVE6().equals("null"))
				pstmt.setNull(187, 12);
			else
				pstmt.setString(187, getVE6());
			if (getVE7() == null || getVE7().equals("null"))
				pstmt.setNull(188, 12);
			else
				pstmt.setString(188, getVE7());
			if (getVE8() == null || getVE8().equals("null"))
				pstmt.setNull(189, 12);
			else
				pstmt.setString(189, getVE8());
			if (getVE9() == null || getVE9().equals("null"))
				pstmt.setNull(190, 12);
			else
				pstmt.setString(190, getVE9());
			if (getVE10() == null || getVE10().equals("null"))
				pstmt.setNull(191, 12);
			else
				pstmt.setString(191, getVE10());
			if (getD1() == null || getD1().equals("null"))
				pstmt.setNull(192, 91);
			else
				pstmt.setDate(192, Date.valueOf(getD1()));
			if (getD2() == null || getD2().equals("null"))
				pstmt.setNull(193, 91);
			else
				pstmt.setDate(193, Date.valueOf(getD2()));
			if (getD3() == null || getD3().equals("null"))
				pstmt.setNull(194, 91);
			else
				pstmt.setDate(194, Date.valueOf(getD3()));
			if (getD4() == null || getD4().equals("null"))
				pstmt.setNull(195, 91);
			else
				pstmt.setDate(195, Date.valueOf(getD4()));
			if (getD5() == null || getD5().equals("null"))
				pstmt.setNull(196, 91);
			else
				pstmt.setDate(196, Date.valueOf(getD5()));
			if (getD6() == null || getD6().equals("null"))
				pstmt.setNull(197, 91);
			else
				pstmt.setDate(197, Date.valueOf(getD6()));
			if (getD7() == null || getD7().equals("null"))
				pstmt.setNull(198, 91);
			else
				pstmt.setDate(198, Date.valueOf(getD7()));
			if (getD8() == null || getD8().equals("null"))
				pstmt.setNull(199, 91);
			else
				pstmt.setDate(199, Date.valueOf(getD8()));
			if (getD9() == null || getD9().equals("null"))
				pstmt.setNull(200, 91);
			else
				pstmt.setDate(200, Date.valueOf(getD9()));
			if (getD10() == null || getD10().equals("null"))
				pstmt.setNull(201, 91);
			else
				pstmt.setDate(201, Date.valueOf(getD10()));
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(202, 12);
			else
				pstmt.setString(202, getState());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(203, 12);
			else
				pstmt.setString(203, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(204, 91);
			else
				pstmt.setDate(204, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(205, 12);
			else
				pstmt.setString(205, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(206, 91);
			else
				pstmt.setDate(206, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(207, 12);
			else
				pstmt.setString(207, getModifyTime());
			if (getIndexCalNo() == null || getIndexCalNo().equals("null"))
				pstmt.setNull(208, 12);
			else
				pstmt.setString(208, getIndexCalNo());
			if (getIndexType() == null || getIndexType().equals("null"))
				pstmt.setNull(209, 12);
			else
				pstmt.setString(209, getIndexType());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(210, 12);
			else
				pstmt.setString(210, getAgentCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoNewDB";
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
			pstmt = con.prepareStatement("INSERT INTO LAIndexInfoNew VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getIndexCalNo() == null || getIndexCalNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getIndexCalNo());
			if (getIndexType() == null || getIndexType().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getIndexType());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getManageCom());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getAgentGroup());
			if (getBranchAttr() == null || getBranchAttr().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getBranchAttr());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getAgentCode());
			if (getAgentGrade() == null || getAgentGrade().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getAgentGrade());
			if (getAgentTitle() == null || getAgentTitle().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAgentTitle());
			pstmt.setInt(9, getQuaBgnMark());
			pstmt.setInt(10, getPostMonths());
			if (getAssessMonth() == null || getAssessMonth().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getAssessMonth());
			if (getAgentGrade1() == null || getAgentGrade1().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getAgentGrade1());
			if (getAgentTitle1() == null || getAgentTitle1().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAgentTitle1());
			if (getAgentGrade2() == null || getAgentGrade2().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getAgentGrade2());
			if (getAgentTitle2() == null || getAgentTitle2().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getAgentTitle2());
			if (getAgentGrade3() == null || getAgentGrade3().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getAgentGrade3());
			if (getAgentTitle3() == null || getAgentTitle3().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getAgentTitle3());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getStartDate()));
			if (getStartEnd() == null || getStartEnd().equals("null"))
				pstmt.setNull(19, 91);
			else
				pstmt.setDate(19, Date.valueOf(getStartEnd()));
			if (getStartDate1() == null || getStartDate1().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getStartDate1()));
			if (getStartEnd1() == null || getStartEnd1().equals("null"))
				pstmt.setNull(21, 91);
			else
				pstmt.setDate(21, Date.valueOf(getStartEnd1()));
			if (getStartDate2() == null || getStartDate2().equals("null"))
				pstmt.setNull(22, 91);
			else
				pstmt.setDate(22, Date.valueOf(getStartDate2()));
			if (getStartEnd2() == null || getStartEnd2().equals("null"))
				pstmt.setNull(23, 91);
			else
				pstmt.setDate(23, Date.valueOf(getStartEnd2()));
			if (getStartDate3() == null || getStartDate3().equals("null"))
				pstmt.setNull(24, 91);
			else
				pstmt.setDate(24, Date.valueOf(getStartDate3()));
			if (getStartEnd3() == null || getStartEnd3().equals("null"))
				pstmt.setNull(25, 91);
			else
				pstmt.setDate(25, Date.valueOf(getStartEnd3()));
			if (getStartEnd4() == null || getStartEnd4().equals("null"))
				pstmt.setNull(26, 91);
			else
				pstmt.setDate(26, Date.valueOf(getStartEnd4()));
			if (getStartDate4() == null || getStartDate4().equals("null"))
				pstmt.setNull(27, 91);
			else
				pstmt.setDate(27, Date.valueOf(getStartDate4()));
			pstmt.setInt(28, getServerMonths());
			pstmt.setDouble(29, getNT01());
			pstmt.setDouble(30, getNT02());
			pstmt.setDouble(31, getNT03());
			pstmt.setDouble(32, getNT04());
			pstmt.setDouble(33, getNT05());
			pstmt.setDouble(34, getNT06());
			pstmt.setDouble(35, getNT07());
			pstmt.setDouble(36, getNT08());
			pstmt.setDouble(37, getNT09());
			pstmt.setDouble(38, getNT10());
			pstmt.setDouble(39, getNT11());
			pstmt.setDouble(40, getNT12());
			pstmt.setDouble(41, getNT13());
			pstmt.setDouble(42, getNT14());
			pstmt.setDouble(43, getNT15());
			pstmt.setDouble(44, getNT16());
			pstmt.setDouble(45, getNT17());
			pstmt.setDouble(46, getNT18());
			pstmt.setDouble(47, getNT19());
			pstmt.setDouble(48, getNT20());
			pstmt.setDouble(49, getNT21());
			pstmt.setDouble(50, getNT22());
			pstmt.setDouble(51, getNT23());
			pstmt.setDouble(52, getNT24());
			pstmt.setDouble(53, getNT25());
			pstmt.setDouble(54, getNT26());
			pstmt.setDouble(55, getNT27());
			pstmt.setDouble(56, getNT28());
			pstmt.setDouble(57, getNT29());
			pstmt.setDouble(58, getNT30());
			pstmt.setDouble(59, getNT31());
			pstmt.setDouble(60, getNT32());
			pstmt.setDouble(61, getNT33());
			pstmt.setDouble(62, getNT34());
			pstmt.setDouble(63, getNT35());
			pstmt.setDouble(64, getNT36());
			pstmt.setDouble(65, getNT37());
			pstmt.setDouble(66, getNT38());
			pstmt.setDouble(67, getNT39());
			pstmt.setDouble(68, getNT40());
			pstmt.setDouble(69, getNT41());
			pstmt.setDouble(70, getNT42());
			pstmt.setDouble(71, getNT43());
			pstmt.setDouble(72, getNT44());
			pstmt.setDouble(73, getNT45());
			pstmt.setDouble(74, getNT46());
			pstmt.setDouble(75, getNT47());
			pstmt.setDouble(76, getNT48());
			pstmt.setDouble(77, getNT49());
			pstmt.setDouble(78, getNT50());
			pstmt.setDouble(79, getNT51());
			pstmt.setDouble(80, getNT52());
			pstmt.setDouble(81, getNT53());
			pstmt.setDouble(82, getNT54());
			pstmt.setDouble(83, getNT55());
			pstmt.setDouble(84, getNT56());
			pstmt.setDouble(85, getNT57());
			pstmt.setDouble(86, getNT58());
			pstmt.setDouble(87, getNT59());
			pstmt.setDouble(88, getNT60());
			pstmt.setDouble(89, getNT61());
			pstmt.setDouble(90, getNT62());
			pstmt.setDouble(91, getNT63());
			pstmt.setDouble(92, getNT64());
			pstmt.setDouble(93, getNT65());
			pstmt.setDouble(94, getNT66());
			pstmt.setDouble(95, getNT67());
			pstmt.setDouble(96, getNT68());
			pstmt.setDouble(97, getNT69());
			pstmt.setDouble(98, getNT70());
			pstmt.setDouble(99, getNT71());
			pstmt.setDouble(100, getNT72());
			pstmt.setDouble(101, getNT73());
			pstmt.setDouble(102, getNT74());
			pstmt.setDouble(103, getNT75());
			pstmt.setDouble(104, getNT76());
			pstmt.setDouble(105, getNT77());
			pstmt.setDouble(106, getNT78());
			pstmt.setDouble(107, getNT79());
			pstmt.setDouble(108, getNT80());
			pstmt.setDouble(109, getNF01());
			pstmt.setDouble(110, getNF02());
			pstmt.setDouble(111, getNF03());
			pstmt.setDouble(112, getNF04());
			pstmt.setDouble(113, getNF05());
			pstmt.setDouble(114, getNF06());
			pstmt.setDouble(115, getNF07());
			pstmt.setDouble(116, getNF08());
			pstmt.setDouble(117, getNF09());
			pstmt.setDouble(118, getNF10());
			pstmt.setDouble(119, getNS01());
			pstmt.setDouble(120, getNS02());
			pstmt.setDouble(121, getNS03());
			pstmt.setDouble(122, getNS04());
			pstmt.setDouble(123, getNS05());
			pstmt.setDouble(124, getNS06());
			pstmt.setDouble(125, getNS07());
			pstmt.setDouble(126, getNS08());
			pstmt.setDouble(127, getNS09());
			pstmt.setDouble(128, getNS10());
			pstmt.setInt(129, getINT01());
			pstmt.setInt(130, getINT02());
			pstmt.setInt(131, getINT03());
			pstmt.setInt(132, getINT04());
			pstmt.setInt(133, getINT05());
			pstmt.setInt(134, getINT06());
			pstmt.setInt(135, getINT07());
			pstmt.setInt(136, getINT08());
			pstmt.setInt(137, getINT09());
			pstmt.setInt(138, getINT10());
			pstmt.setInt(139, getINT11());
			pstmt.setInt(140, getINT12());
			pstmt.setInt(141, getINT13());
			pstmt.setInt(142, getINT14());
			pstmt.setInt(143, getINT15());
			pstmt.setInt(144, getINT16());
			pstmt.setInt(145, getINT17());
			pstmt.setInt(146, getINT18());
			pstmt.setInt(147, getINT19());
			pstmt.setInt(148, getINT20());
			pstmt.setInt(149, getINT21());
			pstmt.setInt(150, getINT22());
			pstmt.setInt(151, getINT23());
			pstmt.setInt(152, getINT24());
			pstmt.setInt(153, getINT25());
			if (getV1() == null || getV1().equals("null"))
				pstmt.setNull(154, 12);
			else
				pstmt.setString(154, getV1());
			if (getV2() == null || getV2().equals("null"))
				pstmt.setNull(155, 12);
			else
				pstmt.setString(155, getV2());
			if (getV3() == null || getV3().equals("null"))
				pstmt.setNull(156, 12);
			else
				pstmt.setString(156, getV3());
			if (getV4() == null || getV4().equals("null"))
				pstmt.setNull(157, 12);
			else
				pstmt.setString(157, getV4());
			if (getV5() == null || getV5().equals("null"))
				pstmt.setNull(158, 12);
			else
				pstmt.setString(158, getV5());
			if (getV6() == null || getV6().equals("null"))
				pstmt.setNull(159, 12);
			else
				pstmt.setString(159, getV6());
			if (getV7() == null || getV7().equals("null"))
				pstmt.setNull(160, 12);
			else
				pstmt.setString(160, getV7());
			if (getV8() == null || getV8().equals("null"))
				pstmt.setNull(161, 12);
			else
				pstmt.setString(161, getV8());
			if (getV9() == null || getV9().equals("null"))
				pstmt.setNull(162, 12);
			else
				pstmt.setString(162, getV9());
			if (getV10() == null || getV10().equals("null"))
				pstmt.setNull(163, 12);
			else
				pstmt.setString(163, getV10());
			if (getV11() == null || getV11().equals("null"))
				pstmt.setNull(164, 12);
			else
				pstmt.setString(164, getV11());
			if (getV12() == null || getV12().equals("null"))
				pstmt.setNull(165, 12);
			else
				pstmt.setString(165, getV12());
			if (getV13() == null || getV13().equals("null"))
				pstmt.setNull(166, 12);
			else
				pstmt.setString(166, getV13());
			if (getV14() == null || getV14().equals("null"))
				pstmt.setNull(167, 12);
			else
				pstmt.setString(167, getV14());
			if (getV15() == null || getV15().equals("null"))
				pstmt.setNull(168, 12);
			else
				pstmt.setString(168, getV15());
			if (getV16() == null || getV16().equals("null"))
				pstmt.setNull(169, 12);
			else
				pstmt.setString(169, getV16());
			if (getV17() == null || getV17().equals("null"))
				pstmt.setNull(170, 12);
			else
				pstmt.setString(170, getV17());
			if (getV18() == null || getV18().equals("null"))
				pstmt.setNull(171, 12);
			else
				pstmt.setString(171, getV18());
			if (getV19() == null || getV19().equals("null"))
				pstmt.setNull(172, 12);
			else
				pstmt.setString(172, getV19());
			if (getV20() == null || getV20().equals("null"))
				pstmt.setNull(173, 12);
			else
				pstmt.setString(173, getV20());
			if (getVT1() == null || getVT1().equals("null"))
				pstmt.setNull(174, 12);
			else
				pstmt.setString(174, getVT1());
			if (getVT2() == null || getVT2().equals("null"))
				pstmt.setNull(175, 12);
			else
				pstmt.setString(175, getVT2());
			if (getVT3() == null || getVT3().equals("null"))
				pstmt.setNull(176, 12);
			else
				pstmt.setString(176, getVT3());
			if (getVT4() == null || getVT4().equals("null"))
				pstmt.setNull(177, 12);
			else
				pstmt.setString(177, getVT4());
			if (getVT5() == null || getVT5().equals("null"))
				pstmt.setNull(178, 12);
			else
				pstmt.setString(178, getVT5());
			if (getVT6() == null || getVT6().equals("null"))
				pstmt.setNull(179, 12);
			else
				pstmt.setString(179, getVT6());
			if (getVT7() == null || getVT7().equals("null"))
				pstmt.setNull(180, 12);
			else
				pstmt.setString(180, getVT7());
			if (getVT8() == null || getVT8().equals("null"))
				pstmt.setNull(181, 12);
			else
				pstmt.setString(181, getVT8());
			if (getVE1() == null || getVE1().equals("null"))
				pstmt.setNull(182, 12);
			else
				pstmt.setString(182, getVE1());
			if (getVE2() == null || getVE2().equals("null"))
				pstmt.setNull(183, 12);
			else
				pstmt.setString(183, getVE2());
			if (getVE3() == null || getVE3().equals("null"))
				pstmt.setNull(184, 12);
			else
				pstmt.setString(184, getVE3());
			if (getVE4() == null || getVE4().equals("null"))
				pstmt.setNull(185, 12);
			else
				pstmt.setString(185, getVE4());
			if (getVE5() == null || getVE5().equals("null"))
				pstmt.setNull(186, 12);
			else
				pstmt.setString(186, getVE5());
			if (getVE6() == null || getVE6().equals("null"))
				pstmt.setNull(187, 12);
			else
				pstmt.setString(187, getVE6());
			if (getVE7() == null || getVE7().equals("null"))
				pstmt.setNull(188, 12);
			else
				pstmt.setString(188, getVE7());
			if (getVE8() == null || getVE8().equals("null"))
				pstmt.setNull(189, 12);
			else
				pstmt.setString(189, getVE8());
			if (getVE9() == null || getVE9().equals("null"))
				pstmt.setNull(190, 12);
			else
				pstmt.setString(190, getVE9());
			if (getVE10() == null || getVE10().equals("null"))
				pstmt.setNull(191, 12);
			else
				pstmt.setString(191, getVE10());
			if (getD1() == null || getD1().equals("null"))
				pstmt.setNull(192, 91);
			else
				pstmt.setDate(192, Date.valueOf(getD1()));
			if (getD2() == null || getD2().equals("null"))
				pstmt.setNull(193, 91);
			else
				pstmt.setDate(193, Date.valueOf(getD2()));
			if (getD3() == null || getD3().equals("null"))
				pstmt.setNull(194, 91);
			else
				pstmt.setDate(194, Date.valueOf(getD3()));
			if (getD4() == null || getD4().equals("null"))
				pstmt.setNull(195, 91);
			else
				pstmt.setDate(195, Date.valueOf(getD4()));
			if (getD5() == null || getD5().equals("null"))
				pstmt.setNull(196, 91);
			else
				pstmt.setDate(196, Date.valueOf(getD5()));
			if (getD6() == null || getD6().equals("null"))
				pstmt.setNull(197, 91);
			else
				pstmt.setDate(197, Date.valueOf(getD6()));
			if (getD7() == null || getD7().equals("null"))
				pstmt.setNull(198, 91);
			else
				pstmt.setDate(198, Date.valueOf(getD7()));
			if (getD8() == null || getD8().equals("null"))
				pstmt.setNull(199, 91);
			else
				pstmt.setDate(199, Date.valueOf(getD8()));
			if (getD9() == null || getD9().equals("null"))
				pstmt.setNull(200, 91);
			else
				pstmt.setDate(200, Date.valueOf(getD9()));
			if (getD10() == null || getD10().equals("null"))
				pstmt.setNull(201, 91);
			else
				pstmt.setDate(201, Date.valueOf(getD10()));
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(202, 12);
			else
				pstmt.setString(202, getState());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(203, 12);
			else
				pstmt.setString(203, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(204, 91);
			else
				pstmt.setDate(204, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(205, 12);
			else
				pstmt.setString(205, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(206, 91);
			else
				pstmt.setDate(206, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(207, 12);
			else
				pstmt.setString(207, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoNewDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LAIndexInfoNew WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?", 1003, 1007);
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
		tError.moduleName = "LAIndexInfoNewDB";
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
				tError.moduleName = "LAIndexInfoNewDB";
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

	public LAIndexInfoNewSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LAIndexInfoNewSet aLAIndexInfoNewSet = new LAIndexInfoNewSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LAIndexInfoNew");
			LAIndexInfoNewSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LAIndexInfoNewSchema s1;
			for (; rs.next(); aLAIndexInfoNewSet.add(s1))
			{
				i++;
				s1 = new LAIndexInfoNewSchema();
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
			tError.moduleName = "LAIndexInfoNewDB";
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
		return aLAIndexInfoNewSet;
	}

	public LAIndexInfoNewSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LAIndexInfoNewSet aLAIndexInfoNewSet = new LAIndexInfoNewSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LAIndexInfoNewSchema s1;
			for (; rs.next(); aLAIndexInfoNewSet.add(s1))
			{
				i++;
				s1 = new LAIndexInfoNewSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LAIndexInfoNewDB";
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
			tError.moduleName = "LAIndexInfoNewDB";
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
		return aLAIndexInfoNewSet;
	}

	public LAIndexInfoNewSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LAIndexInfoNewSet aLAIndexInfoNewSet = new LAIndexInfoNewSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LAIndexInfoNew");
			LAIndexInfoNewSchema aSchema = getSchema();
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
				LAIndexInfoNewSchema s1 = new LAIndexInfoNewSchema();
				s1.setSchema(rs, i);
				aLAIndexInfoNewSet.add(s1);
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
			tError.moduleName = "LAIndexInfoNewDB";
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
		return aLAIndexInfoNewSet;
	}

	public LAIndexInfoNewSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LAIndexInfoNewSet aLAIndexInfoNewSet = new LAIndexInfoNewSet();
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
				LAIndexInfoNewSchema s1 = new LAIndexInfoNewSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LAIndexInfoNewDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLAIndexInfoNewSet.add(s1);
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
			tError.moduleName = "LAIndexInfoNewDB";
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
		return aLAIndexInfoNewSet;
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
				SQLString sqlObj = new SQLString("LAIndexInfoNew");
				LAIndexInfoNewSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LAIndexInfoNew ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LAIndexInfoNewDB";
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
				tError.moduleName = "LAIndexInfoNewDB";
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
			tError.moduleName = "LAIndexInfoNewDB";
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
			tError.moduleName = "LAIndexInfoNewDB";
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
			tError.moduleName = "LAIndexInfoNewDB";
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
			tError.moduleName = "LAIndexInfoNewDB";
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

	public LAIndexInfoNewSet getData()
	{
		int tCount = 0;
		LAIndexInfoNewSet tLAIndexInfoNewSet = new LAIndexInfoNewSet();
		LAIndexInfoNewSchema tLAIndexInfoNewSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoNewDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLAIndexInfoNewSchema = new LAIndexInfoNewSchema();
			tLAIndexInfoNewSchema.setSchema(mResultSet, 1);
			tLAIndexInfoNewSet.add(tLAIndexInfoNewSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLAIndexInfoNewSchema = new LAIndexInfoNewSchema();
					tLAIndexInfoNewSchema.setSchema(mResultSet, 1);
					tLAIndexInfoNewSet.add(tLAIndexInfoNewSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoNewDB";
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
		return tLAIndexInfoNewSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LAIndexInfoNewDB";
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
			tError.moduleName = "LAIndexInfoNewDB";
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
				tError.moduleName = "LAIndexInfoNewDB";
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
			tError.moduleName = "LAIndexInfoNewDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
