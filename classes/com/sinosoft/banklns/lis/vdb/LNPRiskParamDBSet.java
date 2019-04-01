// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskParamDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskParamSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskParamSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskParamDBSet extends LNPRiskParamSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskParamDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskParam");
		mflag = true;
	}

	public LNPRiskParamDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskParam");
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
			tError.moduleName = "LNPRiskParamDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskParam WHERE  Type = ? AND RiskCode = ? AND Param = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getType());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
				if (get(i).getParam() == null || get(i).getParam().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getParam());
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
			tError.moduleName = "LNPRiskParamDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskParam SET  Type = ? , RiskCode = ? , Param = ? , Expression = ? , Remark = ? WHERE  Type = ? AND RiskCode = ? AND Param = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getType());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
				if (get(i).getParam() == null || get(i).getParam().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getParam());
				if (get(i).getExpression() == null || get(i).getExpression().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getExpression());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRemark());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getType());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRiskCode());
				if (get(i).getParam() == null || get(i).getParam().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getParam());
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
			tError.moduleName = "LNPRiskParamDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskParam VALUES( ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getType());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
				if (get(i).getParam() == null || get(i).getParam().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getParam());
				if (get(i).getExpression() == null || get(i).getExpression().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getExpression());
				if (get(i).getRemark() == null || get(i).getRemark().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRemark());
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
			tError.moduleName = "LNPRiskParamDBSet";
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
