// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MNewsBDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MNewsBSchema;
import com.sinosoft.map.lis.vschema.MNewsBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MNewsBDBSet extends MNewsBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MNewsBDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MNewsB");
		mflag = true;
	}

	public MNewsBDBSet()
	{
		mflag = false;
		db = new DBOper("MNewsB");
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
			tError.moduleName = "MNewsBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MNewsB WHERE  EdorNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getEdorNo());
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
			tError.moduleName = "MNewsBDBSet";
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
			pstmt = con.prepareStatement("UPDATE MNewsB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , NewsID = ? , ManageCom = ? , BranchType = ? , NewsType = ? , Title = ? , Subhead = ? , Brief = ? , Author = ? , StartDisplayDate = ? , EndDisplayDate = ? , StartDisplayTime = ? , EndDisplayTime = ? , StaticPageURL = ? , MinDisplayGrade = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , ClickRate = ? , FixedTop = ? WHERE  EdorNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(5, null);
				else
					pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getMakeTime2());
				if (get(i).getNewsID() == null || get(i).getNewsID().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getNewsID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getBranchType());
				if (get(i).getNewsType() == null || get(i).getNewsType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getNewsType());
				if (get(i).getTitle() == null || get(i).getTitle().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getTitle());
				if (get(i).getSubhead() == null || get(i).getSubhead().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getSubhead());
				if (get(i).getBrief() == null || get(i).getBrief().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getBrief());
				if (get(i).getAuthor() == null || get(i).getAuthor().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getAuthor());
				if (get(i).getStartDisplayDate() == null || get(i).getStartDisplayDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getStartDisplayDate()));
				if (get(i).getEndDisplayDate() == null || get(i).getEndDisplayDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getEndDisplayDate()));
				if (get(i).getStartDisplayTime() == null || get(i).getStartDisplayTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getStartDisplayTime());
				if (get(i).getEndDisplayTime() == null || get(i).getEndDisplayTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getEndDisplayTime());
				if (get(i).getStaticPageURL() == null || get(i).getStaticPageURL().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getStaticPageURL());
				if (get(i).getMinDisplayGrade() == null || get(i).getMinDisplayGrade().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getMinDisplayGrade());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getNF01());
				pstmt.setInt(28, get(i).getIF01());
				pstmt.setDouble(29, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(30, null);
				else
					pstmt.setDate(30, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(33, null);
				else
					pstmt.setDate(33, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(35, null);
				else
					pstmt.setDate(35, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getModifyTime());
				pstmt.setInt(37, get(i).getClickRate());
				pstmt.setInt(38, get(i).getFixedTop());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getEdorNo());
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
			tError.moduleName = "MNewsBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MNewsB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(5, null);
				else
					pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getMakeTime2());
				if (get(i).getNewsID() == null || get(i).getNewsID().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getNewsID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getBranchType());
				if (get(i).getNewsType() == null || get(i).getNewsType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getNewsType());
				if (get(i).getTitle() == null || get(i).getTitle().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getTitle());
				if (get(i).getSubhead() == null || get(i).getSubhead().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getSubhead());
				if (get(i).getBrief() == null || get(i).getBrief().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getBrief());
				if (get(i).getAuthor() == null || get(i).getAuthor().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getAuthor());
				if (get(i).getStartDisplayDate() == null || get(i).getStartDisplayDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getStartDisplayDate()));
				if (get(i).getEndDisplayDate() == null || get(i).getEndDisplayDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getEndDisplayDate()));
				if (get(i).getStartDisplayTime() == null || get(i).getStartDisplayTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getStartDisplayTime());
				if (get(i).getEndDisplayTime() == null || get(i).getEndDisplayTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getEndDisplayTime());
				if (get(i).getStaticPageURL() == null || get(i).getStaticPageURL().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getStaticPageURL());
				if (get(i).getMinDisplayGrade() == null || get(i).getMinDisplayGrade().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getMinDisplayGrade());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getNF01());
				pstmt.setInt(28, get(i).getIF01());
				pstmt.setDouble(29, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(30, null);
				else
					pstmt.setDate(30, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(33, null);
				else
					pstmt.setDate(33, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(35, null);
				else
					pstmt.setDate(35, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getModifyTime());
				pstmt.setInt(37, get(i).getClickRate());
				pstmt.setInt(38, get(i).getFixedTop());
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
			tError.moduleName = "MNewsBDBSet";
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
