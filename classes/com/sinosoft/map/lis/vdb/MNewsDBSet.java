// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MNewsDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MNewsSchema;
import com.sinosoft.map.lis.vschema.MNewsSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MNewsDBSet extends MNewsSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MNewsDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MNews");
		mflag = true;
	}

	public MNewsDBSet()
	{
		mflag = false;
		db = new DBOper("MNews");
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
			tError.moduleName = "MNewsDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MNews WHERE  NewsID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNewsID() == null || get(i).getNewsID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNewsID());
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
			tError.moduleName = "MNewsDBSet";
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
			pstmt = con.prepareStatement("UPDATE MNews SET  NewsID = ? , ManageCom = ? , BranchType = ? , NewsType = ? , Title = ? , Subhead = ? , Brief = ? , Author = ? , StartDisplayDate = ? , EndDisplayDate = ? , StartDisplayTime = ? , EndDisplayTime = ? , StaticPageURL = ? , MinDisplayGrade = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , ClickRate = ? , FixedTop = ? WHERE  NewsID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNewsID() == null || get(i).getNewsID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNewsID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getBranchType());
				if (get(i).getNewsType() == null || get(i).getNewsType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getNewsType());
				if (get(i).getTitle() == null || get(i).getTitle().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getTitle());
				if (get(i).getSubhead() == null || get(i).getSubhead().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getSubhead());
				if (get(i).getBrief() == null || get(i).getBrief().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getBrief());
				if (get(i).getAuthor() == null || get(i).getAuthor().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAuthor());
				if (get(i).getStartDisplayDate() == null || get(i).getStartDisplayDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getStartDisplayDate()));
				if (get(i).getEndDisplayDate() == null || get(i).getEndDisplayDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getEndDisplayDate()));
				if (get(i).getStartDisplayTime() == null || get(i).getStartDisplayTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getStartDisplayTime());
				if (get(i).getEndDisplayTime() == null || get(i).getEndDisplayTime().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getEndDisplayTime());
				if (get(i).getStaticPageURL() == null || get(i).getStaticPageURL().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getStaticPageURL());
				if (get(i).getMinDisplayGrade() == null || get(i).getMinDisplayGrade().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getMinDisplayGrade());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getNF01());
				pstmt.setInt(22, get(i).getIF01());
				pstmt.setDouble(23, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(29, null);
				else
					pstmt.setDate(29, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getModifyTime());
				pstmt.setInt(31, get(i).getClickRate());
				pstmt.setInt(32, get(i).getFixedTop());
				if (get(i).getNewsID() == null || get(i).getNewsID().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getNewsID());
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
			tError.moduleName = "MNewsDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MNews VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNewsID() == null || get(i).getNewsID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNewsID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getBranchType());
				if (get(i).getNewsType() == null || get(i).getNewsType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getNewsType());
				if (get(i).getTitle() == null || get(i).getTitle().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getTitle());
				if (get(i).getSubhead() == null || get(i).getSubhead().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getSubhead());
				if (get(i).getBrief() == null || get(i).getBrief().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getBrief());
				if (get(i).getAuthor() == null || get(i).getAuthor().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAuthor());
				if (get(i).getStartDisplayDate() == null || get(i).getStartDisplayDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getStartDisplayDate()));
				if (get(i).getEndDisplayDate() == null || get(i).getEndDisplayDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getEndDisplayDate()));
				if (get(i).getStartDisplayTime() == null || get(i).getStartDisplayTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getStartDisplayTime());
				if (get(i).getEndDisplayTime() == null || get(i).getEndDisplayTime().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getEndDisplayTime());
				if (get(i).getStaticPageURL() == null || get(i).getStaticPageURL().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getStaticPageURL());
				if (get(i).getMinDisplayGrade() == null || get(i).getMinDisplayGrade().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getMinDisplayGrade());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getNF01());
				pstmt.setInt(22, get(i).getIF01());
				pstmt.setDouble(23, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(29, null);
				else
					pstmt.setDate(29, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getModifyTime());
				pstmt.setInt(31, get(i).getClickRate());
				pstmt.setInt(32, get(i).getFixedTop());
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
			tError.moduleName = "MNewsDBSet";
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
