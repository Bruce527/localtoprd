// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskRoleDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskRoleSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskRoleSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskRoleDBSet extends LNPRiskRoleSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskRoleDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskRole");
		mflag = true;
	}

	public LNPRiskRoleDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskRole");
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
			tError.moduleName = "LNPRiskRoleDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskRole WHERE  RiskCode = ? AND RiskRole = ? AND RiskRoleSex = ? AND RiskRoleNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRiskRole() == null || get(i).getRiskRole().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskRole());
				if (get(i).getRiskRoleSex() == null || get(i).getRiskRoleSex().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRiskRoleSex());
				if (get(i).getRiskRoleNo() == null || get(i).getRiskRoleNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getRiskRoleNo());
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
			tError.moduleName = "LNPRiskRoleDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskRole SET  RiskCode = ? , RiskVer = ? , RiskRole = ? , RiskRoleSex = ? , RiskRoleNo = ? , MinAppAgeFlag = ? , MinAppAge = ? , MAXAppAgeFlag = ? , MAXAppAge = ? WHERE  RiskCode = ? AND RiskRole = ? AND RiskRoleSex = ? AND RiskRoleNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRiskVer() == null || get(i).getRiskVer().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskVer());
				if (get(i).getRiskRole() == null || get(i).getRiskRole().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRiskRole());
				if (get(i).getRiskRoleSex() == null || get(i).getRiskRoleSex().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getRiskRoleSex());
				if (get(i).getRiskRoleNo() == null || get(i).getRiskRoleNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRiskRoleNo());
				if (get(i).getMinAppAgeFlag() == null || get(i).getMinAppAgeFlag().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getMinAppAgeFlag());
				pstmt.setInt(7, get(i).getMinAppAge());
				if (get(i).getMAXAppAgeFlag() == null || get(i).getMAXAppAgeFlag().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMAXAppAgeFlag());
				pstmt.setInt(9, get(i).getMAXAppAge());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRiskCode());
				if (get(i).getRiskRole() == null || get(i).getRiskRole().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRiskRole());
				if (get(i).getRiskRoleSex() == null || get(i).getRiskRoleSex().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getRiskRoleSex());
				if (get(i).getRiskRoleNo() == null || get(i).getRiskRoleNo().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRiskRoleNo());
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
			tError.moduleName = "LNPRiskRoleDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskRole VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRiskVer() == null || get(i).getRiskVer().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskVer());
				if (get(i).getRiskRole() == null || get(i).getRiskRole().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRiskRole());
				if (get(i).getRiskRoleSex() == null || get(i).getRiskRoleSex().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getRiskRoleSex());
				if (get(i).getRiskRoleNo() == null || get(i).getRiskRoleNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRiskRoleNo());
				if (get(i).getMinAppAgeFlag() == null || get(i).getMinAppAgeFlag().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getMinAppAgeFlag());
				pstmt.setInt(7, get(i).getMinAppAge());
				if (get(i).getMAXAppAgeFlag() == null || get(i).getMAXAppAgeFlag().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMAXAppAgeFlag());
				pstmt.setInt(9, get(i).getMAXAppAge());
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
			tError.moduleName = "LNPRiskRoleDBSet";
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
