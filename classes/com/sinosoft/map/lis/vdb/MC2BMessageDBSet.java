// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MC2BMessageDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MC2BMessageSchema;
import com.sinosoft.map.lis.vschema.MC2BMessageSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MC2BMessageDBSet extends MC2BMessageSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MC2BMessageDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MC2BMessage");
		mflag = true;
	}

	public MC2BMessageDBSet()
	{
		mflag = false;
		db = new DBOper("MC2BMessage");
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
			tError.moduleName = "MC2BMessageDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MC2BMessage WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
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
			tError.moduleName = "MC2BMessageDBSet";
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
			pstmt = con.prepareStatement("UPDATE MC2BMessage SET  ID = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getBranchType());
				if (get(i).getMessage() == null || get(i).getMessage().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getMessage());
				if (get(i).getMessageType() == null || get(i).getMessageType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMessageType());
				if (get(i).getKeyData() == null || get(i).getKeyData().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getKeyData());
				if (get(i).getKeyData2() == null || get(i).getKeyData2().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getKeyData2());
				if (get(i).getKeyData3() == null || get(i).getKeyData3().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getKeyData3());
				if (get(i).getKeyData4() == null || get(i).getKeyData4().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getKeyData4());
				if (get(i).getURL() == null || get(i).getURL().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getURL());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getType());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getState());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getEndDate()));
				if (get(i).getStartTime() == null || get(i).getStartTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getStartTime());
				if (get(i).getEndTime() == null || get(i).getEndTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getEndTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getNF01());
				pstmt.setInt(19, get(i).getIF01());
				pstmt.setDouble(20, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(21, null);
				else
					pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(23, null);
				else
					pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getMakeTime());
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getID());
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
			tError.moduleName = "MC2BMessageDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MC2BMessage VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getBranchType());
				if (get(i).getMessage() == null || get(i).getMessage().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getMessage());
				if (get(i).getMessageType() == null || get(i).getMessageType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMessageType());
				if (get(i).getKeyData() == null || get(i).getKeyData().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getKeyData());
				if (get(i).getKeyData2() == null || get(i).getKeyData2().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getKeyData2());
				if (get(i).getKeyData3() == null || get(i).getKeyData3().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getKeyData3());
				if (get(i).getKeyData4() == null || get(i).getKeyData4().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getKeyData4());
				if (get(i).getURL() == null || get(i).getURL().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getURL());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getType());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getState());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getEndDate()));
				if (get(i).getStartTime() == null || get(i).getStartTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getStartTime());
				if (get(i).getEndTime() == null || get(i).getEndTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getEndTime());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getNF01());
				pstmt.setInt(19, get(i).getIF01());
				pstmt.setDouble(20, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(21, null);
				else
					pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(23, null);
				else
					pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getMakeTime());
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
			tError.moduleName = "MC2BMessageDBSet";
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
