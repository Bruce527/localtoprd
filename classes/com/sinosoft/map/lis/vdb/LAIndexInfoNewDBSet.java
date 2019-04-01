// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LAIndexInfoNewDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.LAIndexInfoNewSchema;
import com.sinosoft.map.lis.vschema.LAIndexInfoNewSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class LAIndexInfoNewDBSet extends LAIndexInfoNewSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LAIndexInfoNewDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LAIndexInfoNew");
		mflag = true;
	}

	public LAIndexInfoNewDBSet()
	{
		mflag = false;
		db = new DBOper("LAIndexInfoNew");
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
			tError.moduleName = "LAIndexInfoNewDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LAIndexInfoNew WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
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
			tError.moduleName = "LAIndexInfoNewDBSet";
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
			pstmt = con.prepareStatement("UPDATE LAIndexInfoNew SET  IndexCalNo = ? , IndexType = ? , ManageCom = ? , AgentGroup = ? , BranchAttr = ? , AgentCode = ? , AgentGrade = ? , AgentTitle = ? , QuaBgnMark = ? , PostMonths = ? , AssessMonth = ? , AgentGrade1 = ? , AgentTitle1 = ? , AgentGrade2 = ? , AgentTitle2 = ? , AgentGrade3 = ? , AgentTitle3 = ? , StartDate = ? , StartEnd = ? , StartDate1 = ? , StartEnd1 = ? , StartDate2 = ? , StartEnd2 = ? , StartDate3 = ? , StartEnd3 = ? , StartEnd4 = ? , StartDate4 = ? , ServerMonths = ? , NT01 = ? , NT02 = ? , NT03 = ? , NT04 = ? , NT05 = ? , NT06 = ? , NT07 = ? , NT08 = ? , NT09 = ? , NT10 = ? , NT11 = ? , NT12 = ? , NT13 = ? , NT14 = ? , NT15 = ? , NT16 = ? , NT17 = ? , NT18 = ? , NT19 = ? , NT20 = ? , NT21 = ? , NT22 = ? , NT23 = ? , NT24 = ? , NT25 = ? , NT26 = ? , NT27 = ? , NT28 = ? , NT29 = ? , NT30 = ? , NT31 = ? , NT32 = ? , NT33 = ? , NT34 = ? , NT35 = ? , NT36 = ? , NT37 = ? , NT38 = ? , NT39 = ? , NT40 = ? , NT41 = ? , NT42 = ? , NT43 = ? , NT44 = ? , NT45 = ? , NT46 = ? , NT47 = ? , NT48 = ? , NT49 = ? , NT50 = ? , NT51 = ? , NT52 = ? , NT53 = ? , NT54 = ? , NT55 = ? , NT56 = ? , NT57 = ? , NT58 = ? , NT59 = ? , NT60 = ? , NT61 = ? , NT62 = ? , NT63 = ? , NT64 = ? , NT65 = ? , NT66 = ? , NT67 = ? , NT68 = ? , NT69 = ? , NT70 = ? , NT71 = ? , NT72 = ? , NT73 = ? , NT74 = ? , NT75 = ? , NT76 = ? , NT77 = ? , NT78 = ? , NT79 = ? , NT80 = ? , NF01 = ? , NF02 = ? , NF03 = ? , NF04 = ? , NF05 = ? , NF06 = ? , NF07 = ? , NF08 = ? , NF09 = ? , NF10 = ? , NS01 = ? , NS02 = ? , NS03 = ? , NS04 = ? , NS05 = ? , NS06 = ? , NS07 = ? , NS08 = ? , NS09 = ? , NS10 = ? , INT01 = ? , INT02 = ? , INT03 = ? , INT04 = ? , INT05 = ? , INT06 = ? , INT07 = ? , INT08 = ? , INT09 = ? , INT10 = ? , INT11 = ? , INT12 = ? , INT13 = ? , INT14 = ? , INT15 = ? , INT16 = ? , INT17 = ? , INT18 = ? , INT19 = ? , INT20 = ? , INT21 = ? , INT22 = ? , INT23 = ? , INT24 = ? , INT25 = ? , V1 = ? , V2 = ? , V3 = ? , V4 = ? , V5 = ? , V6 = ? , V7 = ? , V8 = ? , V9 = ? , V10 = ? , V11 = ? , V12 = ? , V13 = ? , V14 = ? , V15 = ? , V16 = ? , V17 = ? , V18 = ? , V19 = ? , V20 = ? , VT1 = ? , VT2 = ? , VT3 = ? , VT4 = ? , VT5 = ? , VT6 = ? , VT7 = ? , VT8 = ? , VE1 = ? , VE2 = ? , VE3 = ? , VE4 = ? , VE5 = ? , VE6 = ? , VE7 = ? , VE8 = ? , VE9 = ? , VE10 = ? , D1 = ? , D2 = ? , D3 = ? , D4 = ? , D5 = ? , D6 = ? , D7 = ? , D8 = ? , D9 = ? , D10 = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  IndexCalNo = ? AND IndexType = ? AND AgentCode = ?");
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
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getManageCom());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAgentGroup());
				if (get(i).getBranchAttr() == null || get(i).getBranchAttr().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBranchAttr());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAgentCode());
				if (get(i).getAgentGrade() == null || get(i).getAgentGrade().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getAgentGrade());
				if (get(i).getAgentTitle() == null || get(i).getAgentTitle().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAgentTitle());
				pstmt.setInt(9, get(i).getQuaBgnMark());
				pstmt.setInt(10, get(i).getPostMonths());
				if (get(i).getAssessMonth() == null || get(i).getAssessMonth().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getAssessMonth());
				if (get(i).getAgentGrade1() == null || get(i).getAgentGrade1().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getAgentGrade1());
				if (get(i).getAgentTitle1() == null || get(i).getAgentTitle1().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getAgentTitle1());
				if (get(i).getAgentGrade2() == null || get(i).getAgentGrade2().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getAgentGrade2());
				if (get(i).getAgentTitle2() == null || get(i).getAgentTitle2().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getAgentTitle2());
				if (get(i).getAgentGrade3() == null || get(i).getAgentGrade3().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAgentGrade3());
				if (get(i).getAgentTitle3() == null || get(i).getAgentTitle3().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getAgentTitle3());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getStartDate()));
				if (get(i).getStartEnd() == null || get(i).getStartEnd().equals("null"))
					pstmt.setDate(19, null);
				else
					pstmt.setDate(19, Date.valueOf(get(i).getStartEnd()));
				if (get(i).getStartDate1() == null || get(i).getStartDate1().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getStartDate1()));
				if (get(i).getStartEnd1() == null || get(i).getStartEnd1().equals("null"))
					pstmt.setDate(21, null);
				else
					pstmt.setDate(21, Date.valueOf(get(i).getStartEnd1()));
				if (get(i).getStartDate2() == null || get(i).getStartDate2().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getStartDate2()));
				if (get(i).getStartEnd2() == null || get(i).getStartEnd2().equals("null"))
					pstmt.setDate(23, null);
				else
					pstmt.setDate(23, Date.valueOf(get(i).getStartEnd2()));
				if (get(i).getStartDate3() == null || get(i).getStartDate3().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getStartDate3()));
				if (get(i).getStartEnd3() == null || get(i).getStartEnd3().equals("null"))
					pstmt.setDate(25, null);
				else
					pstmt.setDate(25, Date.valueOf(get(i).getStartEnd3()));
				if (get(i).getStartEnd4() == null || get(i).getStartEnd4().equals("null"))
					pstmt.setDate(26, null);
				else
					pstmt.setDate(26, Date.valueOf(get(i).getStartEnd4()));
				if (get(i).getStartDate4() == null || get(i).getStartDate4().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getStartDate4()));
				pstmt.setInt(28, get(i).getServerMonths());
				pstmt.setDouble(29, get(i).getNT01());
				pstmt.setDouble(30, get(i).getNT02());
				pstmt.setDouble(31, get(i).getNT03());
				pstmt.setDouble(32, get(i).getNT04());
				pstmt.setDouble(33, get(i).getNT05());
				pstmt.setDouble(34, get(i).getNT06());
				pstmt.setDouble(35, get(i).getNT07());
				pstmt.setDouble(36, get(i).getNT08());
				pstmt.setDouble(37, get(i).getNT09());
				pstmt.setDouble(38, get(i).getNT10());
				pstmt.setDouble(39, get(i).getNT11());
				pstmt.setDouble(40, get(i).getNT12());
				pstmt.setDouble(41, get(i).getNT13());
				pstmt.setDouble(42, get(i).getNT14());
				pstmt.setDouble(43, get(i).getNT15());
				pstmt.setDouble(44, get(i).getNT16());
				pstmt.setDouble(45, get(i).getNT17());
				pstmt.setDouble(46, get(i).getNT18());
				pstmt.setDouble(47, get(i).getNT19());
				pstmt.setDouble(48, get(i).getNT20());
				pstmt.setDouble(49, get(i).getNT21());
				pstmt.setDouble(50, get(i).getNT22());
				pstmt.setDouble(51, get(i).getNT23());
				pstmt.setDouble(52, get(i).getNT24());
				pstmt.setDouble(53, get(i).getNT25());
				pstmt.setDouble(54, get(i).getNT26());
				pstmt.setDouble(55, get(i).getNT27());
				pstmt.setDouble(56, get(i).getNT28());
				pstmt.setDouble(57, get(i).getNT29());
				pstmt.setDouble(58, get(i).getNT30());
				pstmt.setDouble(59, get(i).getNT31());
				pstmt.setDouble(60, get(i).getNT32());
				pstmt.setDouble(61, get(i).getNT33());
				pstmt.setDouble(62, get(i).getNT34());
				pstmt.setDouble(63, get(i).getNT35());
				pstmt.setDouble(64, get(i).getNT36());
				pstmt.setDouble(65, get(i).getNT37());
				pstmt.setDouble(66, get(i).getNT38());
				pstmt.setDouble(67, get(i).getNT39());
				pstmt.setDouble(68, get(i).getNT40());
				pstmt.setDouble(69, get(i).getNT41());
				pstmt.setDouble(70, get(i).getNT42());
				pstmt.setDouble(71, get(i).getNT43());
				pstmt.setDouble(72, get(i).getNT44());
				pstmt.setDouble(73, get(i).getNT45());
				pstmt.setDouble(74, get(i).getNT46());
				pstmt.setDouble(75, get(i).getNT47());
				pstmt.setDouble(76, get(i).getNT48());
				pstmt.setDouble(77, get(i).getNT49());
				pstmt.setDouble(78, get(i).getNT50());
				pstmt.setDouble(79, get(i).getNT51());
				pstmt.setDouble(80, get(i).getNT52());
				pstmt.setDouble(81, get(i).getNT53());
				pstmt.setDouble(82, get(i).getNT54());
				pstmt.setDouble(83, get(i).getNT55());
				pstmt.setDouble(84, get(i).getNT56());
				pstmt.setDouble(85, get(i).getNT57());
				pstmt.setDouble(86, get(i).getNT58());
				pstmt.setDouble(87, get(i).getNT59());
				pstmt.setDouble(88, get(i).getNT60());
				pstmt.setDouble(89, get(i).getNT61());
				pstmt.setDouble(90, get(i).getNT62());
				pstmt.setDouble(91, get(i).getNT63());
				pstmt.setDouble(92, get(i).getNT64());
				pstmt.setDouble(93, get(i).getNT65());
				pstmt.setDouble(94, get(i).getNT66());
				pstmt.setDouble(95, get(i).getNT67());
				pstmt.setDouble(96, get(i).getNT68());
				pstmt.setDouble(97, get(i).getNT69());
				pstmt.setDouble(98, get(i).getNT70());
				pstmt.setDouble(99, get(i).getNT71());
				pstmt.setDouble(100, get(i).getNT72());
				pstmt.setDouble(101, get(i).getNT73());
				pstmt.setDouble(102, get(i).getNT74());
				pstmt.setDouble(103, get(i).getNT75());
				pstmt.setDouble(104, get(i).getNT76());
				pstmt.setDouble(105, get(i).getNT77());
				pstmt.setDouble(106, get(i).getNT78());
				pstmt.setDouble(107, get(i).getNT79());
				pstmt.setDouble(108, get(i).getNT80());
				pstmt.setDouble(109, get(i).getNF01());
				pstmt.setDouble(110, get(i).getNF02());
				pstmt.setDouble(111, get(i).getNF03());
				pstmt.setDouble(112, get(i).getNF04());
				pstmt.setDouble(113, get(i).getNF05());
				pstmt.setDouble(114, get(i).getNF06());
				pstmt.setDouble(115, get(i).getNF07());
				pstmt.setDouble(116, get(i).getNF08());
				pstmt.setDouble(117, get(i).getNF09());
				pstmt.setDouble(118, get(i).getNF10());
				pstmt.setDouble(119, get(i).getNS01());
				pstmt.setDouble(120, get(i).getNS02());
				pstmt.setDouble(121, get(i).getNS03());
				pstmt.setDouble(122, get(i).getNS04());
				pstmt.setDouble(123, get(i).getNS05());
				pstmt.setDouble(124, get(i).getNS06());
				pstmt.setDouble(125, get(i).getNS07());
				pstmt.setDouble(126, get(i).getNS08());
				pstmt.setDouble(127, get(i).getNS09());
				pstmt.setDouble(128, get(i).getNS10());
				pstmt.setInt(129, get(i).getINT01());
				pstmt.setInt(130, get(i).getINT02());
				pstmt.setInt(131, get(i).getINT03());
				pstmt.setInt(132, get(i).getINT04());
				pstmt.setInt(133, get(i).getINT05());
				pstmt.setInt(134, get(i).getINT06());
				pstmt.setInt(135, get(i).getINT07());
				pstmt.setInt(136, get(i).getINT08());
				pstmt.setInt(137, get(i).getINT09());
				pstmt.setInt(138, get(i).getINT10());
				pstmt.setInt(139, get(i).getINT11());
				pstmt.setInt(140, get(i).getINT12());
				pstmt.setInt(141, get(i).getINT13());
				pstmt.setInt(142, get(i).getINT14());
				pstmt.setInt(143, get(i).getINT15());
				pstmt.setInt(144, get(i).getINT16());
				pstmt.setInt(145, get(i).getINT17());
				pstmt.setInt(146, get(i).getINT18());
				pstmt.setInt(147, get(i).getINT19());
				pstmt.setInt(148, get(i).getINT20());
				pstmt.setInt(149, get(i).getINT21());
				pstmt.setInt(150, get(i).getINT22());
				pstmt.setInt(151, get(i).getINT23());
				pstmt.setInt(152, get(i).getINT24());
				pstmt.setInt(153, get(i).getINT25());
				if (get(i).getV1() == null || get(i).getV1().equals("null"))
					pstmt.setString(154, null);
				else
					pstmt.setString(154, get(i).getV1());
				if (get(i).getV2() == null || get(i).getV2().equals("null"))
					pstmt.setString(155, null);
				else
					pstmt.setString(155, get(i).getV2());
				if (get(i).getV3() == null || get(i).getV3().equals("null"))
					pstmt.setString(156, null);
				else
					pstmt.setString(156, get(i).getV3());
				if (get(i).getV4() == null || get(i).getV4().equals("null"))
					pstmt.setString(157, null);
				else
					pstmt.setString(157, get(i).getV4());
				if (get(i).getV5() == null || get(i).getV5().equals("null"))
					pstmt.setString(158, null);
				else
					pstmt.setString(158, get(i).getV5());
				if (get(i).getV6() == null || get(i).getV6().equals("null"))
					pstmt.setString(159, null);
				else
					pstmt.setString(159, get(i).getV6());
				if (get(i).getV7() == null || get(i).getV7().equals("null"))
					pstmt.setString(160, null);
				else
					pstmt.setString(160, get(i).getV7());
				if (get(i).getV8() == null || get(i).getV8().equals("null"))
					pstmt.setString(161, null);
				else
					pstmt.setString(161, get(i).getV8());
				if (get(i).getV9() == null || get(i).getV9().equals("null"))
					pstmt.setString(162, null);
				else
					pstmt.setString(162, get(i).getV9());
				if (get(i).getV10() == null || get(i).getV10().equals("null"))
					pstmt.setString(163, null);
				else
					pstmt.setString(163, get(i).getV10());
				if (get(i).getV11() == null || get(i).getV11().equals("null"))
					pstmt.setString(164, null);
				else
					pstmt.setString(164, get(i).getV11());
				if (get(i).getV12() == null || get(i).getV12().equals("null"))
					pstmt.setString(165, null);
				else
					pstmt.setString(165, get(i).getV12());
				if (get(i).getV13() == null || get(i).getV13().equals("null"))
					pstmt.setString(166, null);
				else
					pstmt.setString(166, get(i).getV13());
				if (get(i).getV14() == null || get(i).getV14().equals("null"))
					pstmt.setString(167, null);
				else
					pstmt.setString(167, get(i).getV14());
				if (get(i).getV15() == null || get(i).getV15().equals("null"))
					pstmt.setString(168, null);
				else
					pstmt.setString(168, get(i).getV15());
				if (get(i).getV16() == null || get(i).getV16().equals("null"))
					pstmt.setString(169, null);
				else
					pstmt.setString(169, get(i).getV16());
				if (get(i).getV17() == null || get(i).getV17().equals("null"))
					pstmt.setString(170, null);
				else
					pstmt.setString(170, get(i).getV17());
				if (get(i).getV18() == null || get(i).getV18().equals("null"))
					pstmt.setString(171, null);
				else
					pstmt.setString(171, get(i).getV18());
				if (get(i).getV19() == null || get(i).getV19().equals("null"))
					pstmt.setString(172, null);
				else
					pstmt.setString(172, get(i).getV19());
				if (get(i).getV20() == null || get(i).getV20().equals("null"))
					pstmt.setString(173, null);
				else
					pstmt.setString(173, get(i).getV20());
				if (get(i).getVT1() == null || get(i).getVT1().equals("null"))
					pstmt.setString(174, null);
				else
					pstmt.setString(174, get(i).getVT1());
				if (get(i).getVT2() == null || get(i).getVT2().equals("null"))
					pstmt.setString(175, null);
				else
					pstmt.setString(175, get(i).getVT2());
				if (get(i).getVT3() == null || get(i).getVT3().equals("null"))
					pstmt.setString(176, null);
				else
					pstmt.setString(176, get(i).getVT3());
				if (get(i).getVT4() == null || get(i).getVT4().equals("null"))
					pstmt.setString(177, null);
				else
					pstmt.setString(177, get(i).getVT4());
				if (get(i).getVT5() == null || get(i).getVT5().equals("null"))
					pstmt.setString(178, null);
				else
					pstmt.setString(178, get(i).getVT5());
				if (get(i).getVT6() == null || get(i).getVT6().equals("null"))
					pstmt.setString(179, null);
				else
					pstmt.setString(179, get(i).getVT6());
				if (get(i).getVT7() == null || get(i).getVT7().equals("null"))
					pstmt.setString(180, null);
				else
					pstmt.setString(180, get(i).getVT7());
				if (get(i).getVT8() == null || get(i).getVT8().equals("null"))
					pstmt.setString(181, null);
				else
					pstmt.setString(181, get(i).getVT8());
				if (get(i).getVE1() == null || get(i).getVE1().equals("null"))
					pstmt.setString(182, null);
				else
					pstmt.setString(182, get(i).getVE1());
				if (get(i).getVE2() == null || get(i).getVE2().equals("null"))
					pstmt.setString(183, null);
				else
					pstmt.setString(183, get(i).getVE2());
				if (get(i).getVE3() == null || get(i).getVE3().equals("null"))
					pstmt.setString(184, null);
				else
					pstmt.setString(184, get(i).getVE3());
				if (get(i).getVE4() == null || get(i).getVE4().equals("null"))
					pstmt.setString(185, null);
				else
					pstmt.setString(185, get(i).getVE4());
				if (get(i).getVE5() == null || get(i).getVE5().equals("null"))
					pstmt.setString(186, null);
				else
					pstmt.setString(186, get(i).getVE5());
				if (get(i).getVE6() == null || get(i).getVE6().equals("null"))
					pstmt.setString(187, null);
				else
					pstmt.setString(187, get(i).getVE6());
				if (get(i).getVE7() == null || get(i).getVE7().equals("null"))
					pstmt.setString(188, null);
				else
					pstmt.setString(188, get(i).getVE7());
				if (get(i).getVE8() == null || get(i).getVE8().equals("null"))
					pstmt.setString(189, null);
				else
					pstmt.setString(189, get(i).getVE8());
				if (get(i).getVE9() == null || get(i).getVE9().equals("null"))
					pstmt.setString(190, null);
				else
					pstmt.setString(190, get(i).getVE9());
				if (get(i).getVE10() == null || get(i).getVE10().equals("null"))
					pstmt.setString(191, null);
				else
					pstmt.setString(191, get(i).getVE10());
				if (get(i).getD1() == null || get(i).getD1().equals("null"))
					pstmt.setDate(192, null);
				else
					pstmt.setDate(192, Date.valueOf(get(i).getD1()));
				if (get(i).getD2() == null || get(i).getD2().equals("null"))
					pstmt.setDate(193, null);
				else
					pstmt.setDate(193, Date.valueOf(get(i).getD2()));
				if (get(i).getD3() == null || get(i).getD3().equals("null"))
					pstmt.setDate(194, null);
				else
					pstmt.setDate(194, Date.valueOf(get(i).getD3()));
				if (get(i).getD4() == null || get(i).getD4().equals("null"))
					pstmt.setDate(195, null);
				else
					pstmt.setDate(195, Date.valueOf(get(i).getD4()));
				if (get(i).getD5() == null || get(i).getD5().equals("null"))
					pstmt.setDate(196, null);
				else
					pstmt.setDate(196, Date.valueOf(get(i).getD5()));
				if (get(i).getD6() == null || get(i).getD6().equals("null"))
					pstmt.setDate(197, null);
				else
					pstmt.setDate(197, Date.valueOf(get(i).getD6()));
				if (get(i).getD7() == null || get(i).getD7().equals("null"))
					pstmt.setDate(198, null);
				else
					pstmt.setDate(198, Date.valueOf(get(i).getD7()));
				if (get(i).getD8() == null || get(i).getD8().equals("null"))
					pstmt.setDate(199, null);
				else
					pstmt.setDate(199, Date.valueOf(get(i).getD8()));
				if (get(i).getD9() == null || get(i).getD9().equals("null"))
					pstmt.setDate(200, null);
				else
					pstmt.setDate(200, Date.valueOf(get(i).getD9()));
				if (get(i).getD10() == null || get(i).getD10().equals("null"))
					pstmt.setDate(201, null);
				else
					pstmt.setDate(201, Date.valueOf(get(i).getD10()));
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(202, null);
				else
					pstmt.setString(202, get(i).getState());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(203, null);
				else
					pstmt.setString(203, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(204, null);
				else
					pstmt.setDate(204, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(205, null);
				else
					pstmt.setString(205, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(206, null);
				else
					pstmt.setDate(206, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(207, null);
				else
					pstmt.setString(207, get(i).getModifyTime());
				if (get(i).getIndexCalNo() == null || get(i).getIndexCalNo().equals("null"))
					pstmt.setString(208, null);
				else
					pstmt.setString(208, get(i).getIndexCalNo());
				if (get(i).getIndexType() == null || get(i).getIndexType().equals("null"))
					pstmt.setString(209, null);
				else
					pstmt.setString(209, get(i).getIndexType());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(210, null);
				else
					pstmt.setString(210, get(i).getAgentCode());
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
			tError.moduleName = "LAIndexInfoNewDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LAIndexInfoNew VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getManageCom());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAgentGroup());
				if (get(i).getBranchAttr() == null || get(i).getBranchAttr().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBranchAttr());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAgentCode());
				if (get(i).getAgentGrade() == null || get(i).getAgentGrade().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getAgentGrade());
				if (get(i).getAgentTitle() == null || get(i).getAgentTitle().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAgentTitle());
				pstmt.setInt(9, get(i).getQuaBgnMark());
				pstmt.setInt(10, get(i).getPostMonths());
				if (get(i).getAssessMonth() == null || get(i).getAssessMonth().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getAssessMonth());
				if (get(i).getAgentGrade1() == null || get(i).getAgentGrade1().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getAgentGrade1());
				if (get(i).getAgentTitle1() == null || get(i).getAgentTitle1().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getAgentTitle1());
				if (get(i).getAgentGrade2() == null || get(i).getAgentGrade2().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getAgentGrade2());
				if (get(i).getAgentTitle2() == null || get(i).getAgentTitle2().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getAgentTitle2());
				if (get(i).getAgentGrade3() == null || get(i).getAgentGrade3().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getAgentGrade3());
				if (get(i).getAgentTitle3() == null || get(i).getAgentTitle3().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getAgentTitle3());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getStartDate()));
				if (get(i).getStartEnd() == null || get(i).getStartEnd().equals("null"))
					pstmt.setDate(19, null);
				else
					pstmt.setDate(19, Date.valueOf(get(i).getStartEnd()));
				if (get(i).getStartDate1() == null || get(i).getStartDate1().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getStartDate1()));
				if (get(i).getStartEnd1() == null || get(i).getStartEnd1().equals("null"))
					pstmt.setDate(21, null);
				else
					pstmt.setDate(21, Date.valueOf(get(i).getStartEnd1()));
				if (get(i).getStartDate2() == null || get(i).getStartDate2().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getStartDate2()));
				if (get(i).getStartEnd2() == null || get(i).getStartEnd2().equals("null"))
					pstmt.setDate(23, null);
				else
					pstmt.setDate(23, Date.valueOf(get(i).getStartEnd2()));
				if (get(i).getStartDate3() == null || get(i).getStartDate3().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getStartDate3()));
				if (get(i).getStartEnd3() == null || get(i).getStartEnd3().equals("null"))
					pstmt.setDate(25, null);
				else
					pstmt.setDate(25, Date.valueOf(get(i).getStartEnd3()));
				if (get(i).getStartEnd4() == null || get(i).getStartEnd4().equals("null"))
					pstmt.setDate(26, null);
				else
					pstmt.setDate(26, Date.valueOf(get(i).getStartEnd4()));
				if (get(i).getStartDate4() == null || get(i).getStartDate4().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getStartDate4()));
				pstmt.setInt(28, get(i).getServerMonths());
				pstmt.setDouble(29, get(i).getNT01());
				pstmt.setDouble(30, get(i).getNT02());
				pstmt.setDouble(31, get(i).getNT03());
				pstmt.setDouble(32, get(i).getNT04());
				pstmt.setDouble(33, get(i).getNT05());
				pstmt.setDouble(34, get(i).getNT06());
				pstmt.setDouble(35, get(i).getNT07());
				pstmt.setDouble(36, get(i).getNT08());
				pstmt.setDouble(37, get(i).getNT09());
				pstmt.setDouble(38, get(i).getNT10());
				pstmt.setDouble(39, get(i).getNT11());
				pstmt.setDouble(40, get(i).getNT12());
				pstmt.setDouble(41, get(i).getNT13());
				pstmt.setDouble(42, get(i).getNT14());
				pstmt.setDouble(43, get(i).getNT15());
				pstmt.setDouble(44, get(i).getNT16());
				pstmt.setDouble(45, get(i).getNT17());
				pstmt.setDouble(46, get(i).getNT18());
				pstmt.setDouble(47, get(i).getNT19());
				pstmt.setDouble(48, get(i).getNT20());
				pstmt.setDouble(49, get(i).getNT21());
				pstmt.setDouble(50, get(i).getNT22());
				pstmt.setDouble(51, get(i).getNT23());
				pstmt.setDouble(52, get(i).getNT24());
				pstmt.setDouble(53, get(i).getNT25());
				pstmt.setDouble(54, get(i).getNT26());
				pstmt.setDouble(55, get(i).getNT27());
				pstmt.setDouble(56, get(i).getNT28());
				pstmt.setDouble(57, get(i).getNT29());
				pstmt.setDouble(58, get(i).getNT30());
				pstmt.setDouble(59, get(i).getNT31());
				pstmt.setDouble(60, get(i).getNT32());
				pstmt.setDouble(61, get(i).getNT33());
				pstmt.setDouble(62, get(i).getNT34());
				pstmt.setDouble(63, get(i).getNT35());
				pstmt.setDouble(64, get(i).getNT36());
				pstmt.setDouble(65, get(i).getNT37());
				pstmt.setDouble(66, get(i).getNT38());
				pstmt.setDouble(67, get(i).getNT39());
				pstmt.setDouble(68, get(i).getNT40());
				pstmt.setDouble(69, get(i).getNT41());
				pstmt.setDouble(70, get(i).getNT42());
				pstmt.setDouble(71, get(i).getNT43());
				pstmt.setDouble(72, get(i).getNT44());
				pstmt.setDouble(73, get(i).getNT45());
				pstmt.setDouble(74, get(i).getNT46());
				pstmt.setDouble(75, get(i).getNT47());
				pstmt.setDouble(76, get(i).getNT48());
				pstmt.setDouble(77, get(i).getNT49());
				pstmt.setDouble(78, get(i).getNT50());
				pstmt.setDouble(79, get(i).getNT51());
				pstmt.setDouble(80, get(i).getNT52());
				pstmt.setDouble(81, get(i).getNT53());
				pstmt.setDouble(82, get(i).getNT54());
				pstmt.setDouble(83, get(i).getNT55());
				pstmt.setDouble(84, get(i).getNT56());
				pstmt.setDouble(85, get(i).getNT57());
				pstmt.setDouble(86, get(i).getNT58());
				pstmt.setDouble(87, get(i).getNT59());
				pstmt.setDouble(88, get(i).getNT60());
				pstmt.setDouble(89, get(i).getNT61());
				pstmt.setDouble(90, get(i).getNT62());
				pstmt.setDouble(91, get(i).getNT63());
				pstmt.setDouble(92, get(i).getNT64());
				pstmt.setDouble(93, get(i).getNT65());
				pstmt.setDouble(94, get(i).getNT66());
				pstmt.setDouble(95, get(i).getNT67());
				pstmt.setDouble(96, get(i).getNT68());
				pstmt.setDouble(97, get(i).getNT69());
				pstmt.setDouble(98, get(i).getNT70());
				pstmt.setDouble(99, get(i).getNT71());
				pstmt.setDouble(100, get(i).getNT72());
				pstmt.setDouble(101, get(i).getNT73());
				pstmt.setDouble(102, get(i).getNT74());
				pstmt.setDouble(103, get(i).getNT75());
				pstmt.setDouble(104, get(i).getNT76());
				pstmt.setDouble(105, get(i).getNT77());
				pstmt.setDouble(106, get(i).getNT78());
				pstmt.setDouble(107, get(i).getNT79());
				pstmt.setDouble(108, get(i).getNT80());
				pstmt.setDouble(109, get(i).getNF01());
				pstmt.setDouble(110, get(i).getNF02());
				pstmt.setDouble(111, get(i).getNF03());
				pstmt.setDouble(112, get(i).getNF04());
				pstmt.setDouble(113, get(i).getNF05());
				pstmt.setDouble(114, get(i).getNF06());
				pstmt.setDouble(115, get(i).getNF07());
				pstmt.setDouble(116, get(i).getNF08());
				pstmt.setDouble(117, get(i).getNF09());
				pstmt.setDouble(118, get(i).getNF10());
				pstmt.setDouble(119, get(i).getNS01());
				pstmt.setDouble(120, get(i).getNS02());
				pstmt.setDouble(121, get(i).getNS03());
				pstmt.setDouble(122, get(i).getNS04());
				pstmt.setDouble(123, get(i).getNS05());
				pstmt.setDouble(124, get(i).getNS06());
				pstmt.setDouble(125, get(i).getNS07());
				pstmt.setDouble(126, get(i).getNS08());
				pstmt.setDouble(127, get(i).getNS09());
				pstmt.setDouble(128, get(i).getNS10());
				pstmt.setInt(129, get(i).getINT01());
				pstmt.setInt(130, get(i).getINT02());
				pstmt.setInt(131, get(i).getINT03());
				pstmt.setInt(132, get(i).getINT04());
				pstmt.setInt(133, get(i).getINT05());
				pstmt.setInt(134, get(i).getINT06());
				pstmt.setInt(135, get(i).getINT07());
				pstmt.setInt(136, get(i).getINT08());
				pstmt.setInt(137, get(i).getINT09());
				pstmt.setInt(138, get(i).getINT10());
				pstmt.setInt(139, get(i).getINT11());
				pstmt.setInt(140, get(i).getINT12());
				pstmt.setInt(141, get(i).getINT13());
				pstmt.setInt(142, get(i).getINT14());
				pstmt.setInt(143, get(i).getINT15());
				pstmt.setInt(144, get(i).getINT16());
				pstmt.setInt(145, get(i).getINT17());
				pstmt.setInt(146, get(i).getINT18());
				pstmt.setInt(147, get(i).getINT19());
				pstmt.setInt(148, get(i).getINT20());
				pstmt.setInt(149, get(i).getINT21());
				pstmt.setInt(150, get(i).getINT22());
				pstmt.setInt(151, get(i).getINT23());
				pstmt.setInt(152, get(i).getINT24());
				pstmt.setInt(153, get(i).getINT25());
				if (get(i).getV1() == null || get(i).getV1().equals("null"))
					pstmt.setString(154, null);
				else
					pstmt.setString(154, get(i).getV1());
				if (get(i).getV2() == null || get(i).getV2().equals("null"))
					pstmt.setString(155, null);
				else
					pstmt.setString(155, get(i).getV2());
				if (get(i).getV3() == null || get(i).getV3().equals("null"))
					pstmt.setString(156, null);
				else
					pstmt.setString(156, get(i).getV3());
				if (get(i).getV4() == null || get(i).getV4().equals("null"))
					pstmt.setString(157, null);
				else
					pstmt.setString(157, get(i).getV4());
				if (get(i).getV5() == null || get(i).getV5().equals("null"))
					pstmt.setString(158, null);
				else
					pstmt.setString(158, get(i).getV5());
				if (get(i).getV6() == null || get(i).getV6().equals("null"))
					pstmt.setString(159, null);
				else
					pstmt.setString(159, get(i).getV6());
				if (get(i).getV7() == null || get(i).getV7().equals("null"))
					pstmt.setString(160, null);
				else
					pstmt.setString(160, get(i).getV7());
				if (get(i).getV8() == null || get(i).getV8().equals("null"))
					pstmt.setString(161, null);
				else
					pstmt.setString(161, get(i).getV8());
				if (get(i).getV9() == null || get(i).getV9().equals("null"))
					pstmt.setString(162, null);
				else
					pstmt.setString(162, get(i).getV9());
				if (get(i).getV10() == null || get(i).getV10().equals("null"))
					pstmt.setString(163, null);
				else
					pstmt.setString(163, get(i).getV10());
				if (get(i).getV11() == null || get(i).getV11().equals("null"))
					pstmt.setString(164, null);
				else
					pstmt.setString(164, get(i).getV11());
				if (get(i).getV12() == null || get(i).getV12().equals("null"))
					pstmt.setString(165, null);
				else
					pstmt.setString(165, get(i).getV12());
				if (get(i).getV13() == null || get(i).getV13().equals("null"))
					pstmt.setString(166, null);
				else
					pstmt.setString(166, get(i).getV13());
				if (get(i).getV14() == null || get(i).getV14().equals("null"))
					pstmt.setString(167, null);
				else
					pstmt.setString(167, get(i).getV14());
				if (get(i).getV15() == null || get(i).getV15().equals("null"))
					pstmt.setString(168, null);
				else
					pstmt.setString(168, get(i).getV15());
				if (get(i).getV16() == null || get(i).getV16().equals("null"))
					pstmt.setString(169, null);
				else
					pstmt.setString(169, get(i).getV16());
				if (get(i).getV17() == null || get(i).getV17().equals("null"))
					pstmt.setString(170, null);
				else
					pstmt.setString(170, get(i).getV17());
				if (get(i).getV18() == null || get(i).getV18().equals("null"))
					pstmt.setString(171, null);
				else
					pstmt.setString(171, get(i).getV18());
				if (get(i).getV19() == null || get(i).getV19().equals("null"))
					pstmt.setString(172, null);
				else
					pstmt.setString(172, get(i).getV19());
				if (get(i).getV20() == null || get(i).getV20().equals("null"))
					pstmt.setString(173, null);
				else
					pstmt.setString(173, get(i).getV20());
				if (get(i).getVT1() == null || get(i).getVT1().equals("null"))
					pstmt.setString(174, null);
				else
					pstmt.setString(174, get(i).getVT1());
				if (get(i).getVT2() == null || get(i).getVT2().equals("null"))
					pstmt.setString(175, null);
				else
					pstmt.setString(175, get(i).getVT2());
				if (get(i).getVT3() == null || get(i).getVT3().equals("null"))
					pstmt.setString(176, null);
				else
					pstmt.setString(176, get(i).getVT3());
				if (get(i).getVT4() == null || get(i).getVT4().equals("null"))
					pstmt.setString(177, null);
				else
					pstmt.setString(177, get(i).getVT4());
				if (get(i).getVT5() == null || get(i).getVT5().equals("null"))
					pstmt.setString(178, null);
				else
					pstmt.setString(178, get(i).getVT5());
				if (get(i).getVT6() == null || get(i).getVT6().equals("null"))
					pstmt.setString(179, null);
				else
					pstmt.setString(179, get(i).getVT6());
				if (get(i).getVT7() == null || get(i).getVT7().equals("null"))
					pstmt.setString(180, null);
				else
					pstmt.setString(180, get(i).getVT7());
				if (get(i).getVT8() == null || get(i).getVT8().equals("null"))
					pstmt.setString(181, null);
				else
					pstmt.setString(181, get(i).getVT8());
				if (get(i).getVE1() == null || get(i).getVE1().equals("null"))
					pstmt.setString(182, null);
				else
					pstmt.setString(182, get(i).getVE1());
				if (get(i).getVE2() == null || get(i).getVE2().equals("null"))
					pstmt.setString(183, null);
				else
					pstmt.setString(183, get(i).getVE2());
				if (get(i).getVE3() == null || get(i).getVE3().equals("null"))
					pstmt.setString(184, null);
				else
					pstmt.setString(184, get(i).getVE3());
				if (get(i).getVE4() == null || get(i).getVE4().equals("null"))
					pstmt.setString(185, null);
				else
					pstmt.setString(185, get(i).getVE4());
				if (get(i).getVE5() == null || get(i).getVE5().equals("null"))
					pstmt.setString(186, null);
				else
					pstmt.setString(186, get(i).getVE5());
				if (get(i).getVE6() == null || get(i).getVE6().equals("null"))
					pstmt.setString(187, null);
				else
					pstmt.setString(187, get(i).getVE6());
				if (get(i).getVE7() == null || get(i).getVE7().equals("null"))
					pstmt.setString(188, null);
				else
					pstmt.setString(188, get(i).getVE7());
				if (get(i).getVE8() == null || get(i).getVE8().equals("null"))
					pstmt.setString(189, null);
				else
					pstmt.setString(189, get(i).getVE8());
				if (get(i).getVE9() == null || get(i).getVE9().equals("null"))
					pstmt.setString(190, null);
				else
					pstmt.setString(190, get(i).getVE9());
				if (get(i).getVE10() == null || get(i).getVE10().equals("null"))
					pstmt.setString(191, null);
				else
					pstmt.setString(191, get(i).getVE10());
				if (get(i).getD1() == null || get(i).getD1().equals("null"))
					pstmt.setDate(192, null);
				else
					pstmt.setDate(192, Date.valueOf(get(i).getD1()));
				if (get(i).getD2() == null || get(i).getD2().equals("null"))
					pstmt.setDate(193, null);
				else
					pstmt.setDate(193, Date.valueOf(get(i).getD2()));
				if (get(i).getD3() == null || get(i).getD3().equals("null"))
					pstmt.setDate(194, null);
				else
					pstmt.setDate(194, Date.valueOf(get(i).getD3()));
				if (get(i).getD4() == null || get(i).getD4().equals("null"))
					pstmt.setDate(195, null);
				else
					pstmt.setDate(195, Date.valueOf(get(i).getD4()));
				if (get(i).getD5() == null || get(i).getD5().equals("null"))
					pstmt.setDate(196, null);
				else
					pstmt.setDate(196, Date.valueOf(get(i).getD5()));
				if (get(i).getD6() == null || get(i).getD6().equals("null"))
					pstmt.setDate(197, null);
				else
					pstmt.setDate(197, Date.valueOf(get(i).getD6()));
				if (get(i).getD7() == null || get(i).getD7().equals("null"))
					pstmt.setDate(198, null);
				else
					pstmt.setDate(198, Date.valueOf(get(i).getD7()));
				if (get(i).getD8() == null || get(i).getD8().equals("null"))
					pstmt.setDate(199, null);
				else
					pstmt.setDate(199, Date.valueOf(get(i).getD8()));
				if (get(i).getD9() == null || get(i).getD9().equals("null"))
					pstmt.setDate(200, null);
				else
					pstmt.setDate(200, Date.valueOf(get(i).getD9()));
				if (get(i).getD10() == null || get(i).getD10().equals("null"))
					pstmt.setDate(201, null);
				else
					pstmt.setDate(201, Date.valueOf(get(i).getD10()));
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(202, null);
				else
					pstmt.setString(202, get(i).getState());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(203, null);
				else
					pstmt.setString(203, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(204, null);
				else
					pstmt.setDate(204, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(205, null);
				else
					pstmt.setString(205, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(206, null);
				else
					pstmt.setDate(206, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(207, null);
				else
					pstmt.setString(207, get(i).getModifyTime());
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
			tError.moduleName = "LAIndexInfoNewDBSet";
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
