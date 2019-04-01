// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskScreenValidateDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskScreenValidateSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskScreenValidateSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskScreenValidateDBSet extends LNPRiskScreenValidateSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskScreenValidateDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskScreenValidate");
		mflag = true;
	}

	public LNPRiskScreenValidateDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskScreenValidate");
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
			tError.moduleName = "LNPRiskScreenValidateDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskScreenValidate WHERE  ControlId = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getControlId() == null || get(i).getControlId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getControlId());
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
			tError.moduleName = "LNPRiskScreenValidateDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskScreenValidate SET  ControlId = ? , RiskCode = ? , ControlCode = ? , ControlValue = ? , FunctionType = ? , RelaDivCode = ? , RelaDivShow = ? , RelaControlCode = ? , RelaControlType = ? , RelaValueSql = ? , CalCode = ? , Noti = ? WHERE  ControlId = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getControlId() == null || get(i).getControlId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getControlId());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
				if (get(i).getControlCode() == null || get(i).getControlCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getControlCode());
				if (get(i).getControlValue() == null || get(i).getControlValue().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getControlValue());
				if (get(i).getFunctionType() == null || get(i).getFunctionType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getFunctionType());
				if (get(i).getRelaDivCode() == null || get(i).getRelaDivCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getRelaDivCode());
				if (get(i).getRelaDivShow() == null || get(i).getRelaDivShow().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRelaDivShow());
				if (get(i).getRelaControlCode() == null || get(i).getRelaControlCode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getRelaControlCode());
				if (get(i).getRelaControlType() == null || get(i).getRelaControlType().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getRelaControlType());
				if (get(i).getRelaValueSql() == null || get(i).getRelaValueSql().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRelaValueSql());
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCalCode());
				if (get(i).getNoti() == null || get(i).getNoti().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getNoti());
				if (get(i).getControlId() == null || get(i).getControlId().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getControlId());
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
			tError.moduleName = "LNPRiskScreenValidateDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskScreenValidate VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getControlId() == null || get(i).getControlId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getControlId());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskCode());
				if (get(i).getControlCode() == null || get(i).getControlCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getControlCode());
				if (get(i).getControlValue() == null || get(i).getControlValue().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getControlValue());
				if (get(i).getFunctionType() == null || get(i).getFunctionType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getFunctionType());
				if (get(i).getRelaDivCode() == null || get(i).getRelaDivCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getRelaDivCode());
				if (get(i).getRelaDivShow() == null || get(i).getRelaDivShow().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRelaDivShow());
				if (get(i).getRelaControlCode() == null || get(i).getRelaControlCode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getRelaControlCode());
				if (get(i).getRelaControlType() == null || get(i).getRelaControlType().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getRelaControlType());
				if (get(i).getRelaValueSql() == null || get(i).getRelaValueSql().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRelaValueSql());
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCalCode());
				if (get(i).getNoti() == null || get(i).getNoti().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getNoti());
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
			tError.moduleName = "LNPRiskScreenValidateDBSet";
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
