// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPStaticMsgUrlDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPStaticMsgUrlSchema;
import com.sinosoft.banklns.lis.vschema.LNPStaticMsgUrlSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPStaticMsgUrlDBSet extends LNPStaticMsgUrlSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPStaticMsgUrlDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPStaticMsgUrl");
		mflag = true;
	}

	public LNPStaticMsgUrlDBSet()
	{
		mflag = false;
		db = new DBOper("LNPStaticMsgUrl");
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
			tError.moduleName = "LNPStaticMsgUrlDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
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
			pstmt = con.prepareStatement("DELETE FROM LNPStaticMsgUrl WHERE  StaMsgID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				pstmt.setInt(1, get(i).getStaMsgID());
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
			tError.moduleName = "LNPStaticMsgUrlDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPStaticMsgUrl SET  StaMsgID = ? , AssuranceCode = ? , MsgUrl = ? , flag = ? , Remarks = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  StaMsgID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				pstmt.setInt(1, get(i).getStaMsgID());
				if (get(i).getAssuranceCode() == null || get(i).getAssuranceCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAssuranceCode());
				if (get(i).getMsgUrl() == null || get(i).getMsgUrl().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getMsgUrl());
				if (get(i).getFlag() == null || get(i).getFlag().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getFlag());
				if (get(i).getRemarks() == null || get(i).getRemarks().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRemarks());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getMakeTime()));
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyTime()));
				pstmt.setInt(11, get(i).getStaMsgID());
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
			tError.moduleName = "LNPStaticMsgUrlDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPStaticMsgUrl VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				pstmt.setInt(1, get(i).getStaMsgID());
				if (get(i).getAssuranceCode() == null || get(i).getAssuranceCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAssuranceCode());
				if (get(i).getMsgUrl() == null || get(i).getMsgUrl().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getMsgUrl());
				if (get(i).getFlag() == null || get(i).getFlag().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getFlag());
				if (get(i).getRemarks() == null || get(i).getRemarks().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRemarks());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getMakeTime()));
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyTime()));
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
			tError.moduleName = "LNPStaticMsgUrlDBSet";
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
