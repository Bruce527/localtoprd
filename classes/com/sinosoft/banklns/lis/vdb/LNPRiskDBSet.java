// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskDBSet extends LNPRiskSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRisk");
		mflag = true;
	}

	public LNPRiskDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRisk");
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
			tError.moduleName = "LNPRiskDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRisk WHERE  RiskCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
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
			tError.moduleName = "LNPRiskDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRisk SET  RiskCode = ? , RiskVer = ? , RiskName = ? , RiskShortName = ? , RiskEnName = ? , RiskEnShortName = ? , ChoDutyFlag = ? , CPayFlag = ? , GetFlag = ? , EdorFlag = ? , RnewFlag = ? , UWFlag = ? , RinsFlag = ? , InsuAccFlag = ? , DestRate = ? , OrigRiskCode = ? , SubRiskVer = ? , RiskStatName = ? WHERE  RiskCode = ?");
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
				if (get(i).getRiskName() == null || get(i).getRiskName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRiskName());
				if (get(i).getRiskShortName() == null || get(i).getRiskShortName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getRiskShortName());
				if (get(i).getRiskEnName() == null || get(i).getRiskEnName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRiskEnName());
				if (get(i).getRiskEnShortName() == null || get(i).getRiskEnShortName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getRiskEnShortName());
				if (get(i).getChoDutyFlag() == null || get(i).getChoDutyFlag().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getChoDutyFlag());
				if (get(i).getCPayFlag() == null || get(i).getCPayFlag().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCPayFlag());
				if (get(i).getGetFlag() == null || get(i).getGetFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getGetFlag());
				if (get(i).getEdorFlag() == null || get(i).getEdorFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getEdorFlag());
				if (get(i).getRnewFlag() == null || get(i).getRnewFlag().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRnewFlag());
				if (get(i).getUWFlag() == null || get(i).getUWFlag().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getUWFlag());
				if (get(i).getRinsFlag() == null || get(i).getRinsFlag().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRinsFlag());
				if (get(i).getInsuAccFlag() == null || get(i).getInsuAccFlag().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getInsuAccFlag());
				pstmt.setDouble(15, get(i).getDestRate());
				if (get(i).getOrigRiskCode() == null || get(i).getOrigRiskCode().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOrigRiskCode());
				if (get(i).getSubRiskVer() == null || get(i).getSubRiskVer().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getSubRiskVer());
				if (get(i).getRiskStatName() == null || get(i).getRiskStatName().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getRiskStatName());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getRiskCode());
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
			tError.moduleName = "LNPRiskDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRisk VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getRiskName() == null || get(i).getRiskName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRiskName());
				if (get(i).getRiskShortName() == null || get(i).getRiskShortName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getRiskShortName());
				if (get(i).getRiskEnName() == null || get(i).getRiskEnName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRiskEnName());
				if (get(i).getRiskEnShortName() == null || get(i).getRiskEnShortName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getRiskEnShortName());
				if (get(i).getChoDutyFlag() == null || get(i).getChoDutyFlag().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getChoDutyFlag());
				if (get(i).getCPayFlag() == null || get(i).getCPayFlag().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCPayFlag());
				if (get(i).getGetFlag() == null || get(i).getGetFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getGetFlag());
				if (get(i).getEdorFlag() == null || get(i).getEdorFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getEdorFlag());
				if (get(i).getRnewFlag() == null || get(i).getRnewFlag().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRnewFlag());
				if (get(i).getUWFlag() == null || get(i).getUWFlag().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getUWFlag());
				if (get(i).getRinsFlag() == null || get(i).getRinsFlag().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRinsFlag());
				if (get(i).getInsuAccFlag() == null || get(i).getInsuAccFlag().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getInsuAccFlag());
				pstmt.setDouble(15, get(i).getDestRate());
				if (get(i).getOrigRiskCode() == null || get(i).getOrigRiskCode().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOrigRiskCode());
				if (get(i).getSubRiskVer() == null || get(i).getSubRiskVer().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getSubRiskVer());
				if (get(i).getRiskStatName() == null || get(i).getRiskStatName().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getRiskStatName());
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
			tError.moduleName = "LNPRiskDBSet";
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
