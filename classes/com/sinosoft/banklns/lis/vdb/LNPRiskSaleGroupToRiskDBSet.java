// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskSaleGroupToRiskDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskSaleGroupToRiskSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskSaleGroupToRiskSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskSaleGroupToRiskDBSet extends LNPRiskSaleGroupToRiskSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskSaleGroupToRiskDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskSaleGroupToRisk");
		mflag = true;
	}

	public LNPRiskSaleGroupToRiskDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskSaleGroupToRisk");
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
			tError.moduleName = "LNPRiskSaleGroupToRiskDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskSaleGroupToRisk WHERE  GroupCode = ? AND RiskCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGroupCode() == null || get(i).getGroupCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGroupCode());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
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
			tError.moduleName = "LNPRiskSaleGroupToRiskDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskSaleGroupToRisk SET  GroupCode = ? , RiskCode = ? WHERE  GroupCode = ? AND RiskCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGroupCode() == null || get(i).getGroupCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGroupCode());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
				if (get(i).getGroupCode() == null || get(i).getGroupCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getGroupCode());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getRiskCode());
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
			tError.moduleName = "LNPRiskSaleGroupToRiskDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskSaleGroupToRisk VALUES( ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGroupCode() == null || get(i).getGroupCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGroupCode());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
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
			tError.moduleName = "LNPRiskSaleGroupToRiskDBSet";
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
