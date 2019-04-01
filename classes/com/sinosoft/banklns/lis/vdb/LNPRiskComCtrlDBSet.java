// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskComCtrlDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskComCtrlSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskComCtrlSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPRiskComCtrlDBSet extends LNPRiskComCtrlSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskComCtrlDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskComCtrl");
		mflag = true;
	}

	public LNPRiskComCtrlDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskComCtrl");
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
			tError.moduleName = "LNPRiskComCtrlDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskComCtrl WHERE  RiskCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getManageComGrp() == null || get(i).getManageComGrp().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageComGrp());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getSaleChnl());
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
			tError.moduleName = "LNPRiskComCtrlDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskComCtrl SET  RiskCode = ? , ManageComGrp = ? , SaleChnl = ? , StartDate = ? , EndDate = ? , MAXAmnt = ? , MAXMult = ? , MAXPrem = ? , MINAmnt = ? , MINMult = ? , MINPrem = ? WHERE  RiskCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getManageComGrp() == null || get(i).getManageComGrp().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageComGrp());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getSaleChnl());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(4, null);
				else
					pstmt.setDate(4, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(5, null);
				else
					pstmt.setDate(5, Date.valueOf(get(i).getEndDate()));
				pstmt.setDouble(6, get(i).getMAXAmnt());
				pstmt.setDouble(7, get(i).getMAXMult());
				pstmt.setDouble(8, get(i).getMAXPrem());
				pstmt.setDouble(9, get(i).getMINAmnt());
				pstmt.setDouble(10, get(i).getMINMult());
				pstmt.setDouble(11, get(i).getMINPrem());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getRiskCode());
				if (get(i).getManageComGrp() == null || get(i).getManageComGrp().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getManageComGrp());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getSaleChnl());
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
			tError.moduleName = "LNPRiskComCtrlDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskComCtrl VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getManageComGrp() == null || get(i).getManageComGrp().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageComGrp());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getSaleChnl());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(4, null);
				else
					pstmt.setDate(4, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(5, null);
				else
					pstmt.setDate(5, Date.valueOf(get(i).getEndDate()));
				pstmt.setDouble(6, get(i).getMAXAmnt());
				pstmt.setDouble(7, get(i).getMAXMult());
				pstmt.setDouble(8, get(i).getMAXPrem());
				pstmt.setDouble(9, get(i).getMINAmnt());
				pstmt.setDouble(10, get(i).getMINMult());
				pstmt.setDouble(11, get(i).getMINPrem());
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
			tError.moduleName = "LNPRiskComCtrlDBSet";
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
