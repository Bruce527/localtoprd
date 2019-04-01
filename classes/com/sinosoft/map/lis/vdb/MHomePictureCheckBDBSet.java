// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MHomePictureCheckBDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MHomePictureCheckBSchema;
import com.sinosoft.map.lis.vschema.MHomePictureCheckBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MHomePictureCheckBDBSet extends MHomePictureCheckBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MHomePictureCheckBDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MHomePictureCheckB");
		mflag = true;
	}

	public MHomePictureCheckBDBSet()
	{
		mflag = false;
		db = new DBOper("MHomePictureCheckB");
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
			tError.moduleName = "MHomePictureCheckBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MHomePictureCheckB WHERE  EdorNo = ?");
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
			tError.moduleName = "MHomePictureCheckBDBSet";
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
			pstmt = con.prepareStatement("UPDATE MHomePictureCheckB SET  ID = ? , URL = ? , RefURL = ? , Name = ? , Alt = ? , PicOrder = ? , DisplayFlag = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getURL() == null || get(i).getURL().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getURL());
				if (get(i).getRefURL() == null || get(i).getRefURL().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRefURL());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getName());
				if (get(i).getAlt() == null || get(i).getAlt().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAlt());
				pstmt.setInt(6, get(i).getPicOrder());
				if (get(i).getDisplayFlag() == null || get(i).getDisplayFlag().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getDisplayFlag());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(11, null);
				else
					pstmt.setDate(11, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getNF01());
				pstmt.setInt(15, get(i).getIF01());
				pstmt.setDouble(16, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getModifyTime());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(28, null);
				else
					pstmt.setDate(28, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getMakeTime2());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getEdorNo());
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
			tError.moduleName = "MHomePictureCheckBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MHomePictureCheckB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getURL() == null || get(i).getURL().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getURL());
				if (get(i).getRefURL() == null || get(i).getRefURL().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRefURL());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getName());
				if (get(i).getAlt() == null || get(i).getAlt().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAlt());
				pstmt.setInt(6, get(i).getPicOrder());
				if (get(i).getDisplayFlag() == null || get(i).getDisplayFlag().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getDisplayFlag());
				if (get(i).getCheckState() == null || get(i).getCheckState().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCheckState());
				if (get(i).getCheckOperator() == null || get(i).getCheckOperator().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCheckOperator());
				if (get(i).getCheckReason() == null || get(i).getCheckReason().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getCheckReason());
				if (get(i).getCheckDate() == null || get(i).getCheckDate().equals("null"))
					pstmt.setDate(11, null);
				else
					pstmt.setDate(11, Date.valueOf(get(i).getCheckDate()));
				if (get(i).getCheckTime() == null || get(i).getCheckTime().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCheckTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getNF01());
				pstmt.setInt(15, get(i).getIF01());
				pstmt.setDouble(16, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getModifyTime());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(28, null);
				else
					pstmt.setDate(28, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getMakeTime2());
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
			tError.moduleName = "MHomePictureCheckBDBSet";
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
