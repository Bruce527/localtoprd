// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskSaleGroupDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskSaleGroupSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskSaleGroupSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskSaleGroupDBSet extends LNPRiskSaleGroupSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskSaleGroupDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskSaleGroup");
		mflag = true;
	}

	public LNPRiskSaleGroupDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskSaleGroup");
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
			tError.moduleName = "LNPRiskSaleGroupDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskSaleGroup WHERE  GroupCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGroupCode() == null || get(i).getGroupCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGroupCode());
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
			tError.moduleName = "LNPRiskSaleGroupDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskSaleGroup SET  GroupCode = ? , GroupName = ? , GroupDescribe = ? WHERE  GroupCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGroupCode() == null || get(i).getGroupCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGroupCode());
				if (get(i).getGroupName() == null || get(i).getGroupName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getGroupName());
				if (get(i).getGroupDescribe() == null || get(i).getGroupDescribe().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getGroupDescribe());
				if (get(i).getGroupCode() == null || get(i).getGroupCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getGroupCode());
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
			tError.moduleName = "LNPRiskSaleGroupDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskSaleGroup VALUES( ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGroupCode() == null || get(i).getGroupCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGroupCode());
				if (get(i).getGroupName() == null || get(i).getGroupName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getGroupName());
				if (get(i).getGroupDescribe() == null || get(i).getGroupDescribe().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getGroupDescribe());
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
			tError.moduleName = "LNPRiskSaleGroupDBSet";
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
