// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MUserLogDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MUserLogSchema;
import com.sinosoft.map.lis.vschema.MUserLogSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MUserLogDBSet extends MUserLogSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MUserLogDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MUserLog");
		mflag = true;
	}

	public MUserLogDBSet()
	{
		mflag = false;
		db = new DBOper("MUserLog");
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
			tError.moduleName = "MUserLogDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MUserLog WHERE  ID = ?");
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
			tError.moduleName = "MUserLogDBSet";
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
			pstmt = con.prepareStatement("UPDATE MUserLog SET  ID = ? , UserCode = ? , UserType = ? , TraceType = ? , MenuID = ? , MenuName = ? , Operation = ? , Discription = ? , CientIP = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getUserCode() == null || get(i).getUserCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getUserCode());
				if (get(i).getUserType() == null || get(i).getUserType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getUserType());
				if (get(i).getTraceType() == null || get(i).getTraceType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getTraceType());
				if (get(i).getMenuID() == null || get(i).getMenuID().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMenuID());
				if (get(i).getMenuName() == null || get(i).getMenuName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getMenuName());
				if (get(i).getOperation() == null || get(i).getOperation().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getOperation());
				if (get(i).getDiscription() == null || get(i).getDiscription().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getDiscription());
				if (get(i).getCientIP() == null || get(i).getCientIP().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCientIP());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getMakeTime());
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getID());
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
			tError.moduleName = "MUserLogDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MUserLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getUserCode() == null || get(i).getUserCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getUserCode());
				if (get(i).getUserType() == null || get(i).getUserType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getUserType());
				if (get(i).getTraceType() == null || get(i).getTraceType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getTraceType());
				if (get(i).getMenuID() == null || get(i).getMenuID().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMenuID());
				if (get(i).getMenuName() == null || get(i).getMenuName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getMenuName());
				if (get(i).getOperation() == null || get(i).getOperation().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getOperation());
				if (get(i).getDiscription() == null || get(i).getDiscription().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getDiscription());
				if (get(i).getCientIP() == null || get(i).getCientIP().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCientIP());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getMakeTime());
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
			tError.moduleName = "MUserLogDBSet";
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
