// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskRelaDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskRelaSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskRelaSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskRelaDBSet extends LNPRiskRelaSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskRelaDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskRela");
		mflag = true;
	}

	public LNPRiskRelaDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskRela");
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
			tError.moduleName = "LNPRiskRelaDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskRela WHERE  RiskCode = ? AND RelaRiskCode = ? AND RelaCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRelaRiskCode() == null || get(i).getRelaRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRelaRiskCode());
				if (get(i).getRelaCode() == null || get(i).getRelaCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRelaCode());
				if (get(i).getManageComGrp() == null || get(i).getManageComGrp().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getManageComGrp());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getSaleChnl());
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
			tError.moduleName = "LNPRiskRelaDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskRela SET  RiskCode = ? , RelaRiskCode = ? , RelaCode = ? , ManageComGrp = ? , SaleChnl = ? , MinAppntAge = ? , MaxAppntAge = ? , MaxInsuredAge = ? , MinInsuredAge = ? WHERE  RiskCode = ? AND RelaRiskCode = ? AND RelaCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRelaRiskCode() == null || get(i).getRelaRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRelaRiskCode());
				if (get(i).getRelaCode() == null || get(i).getRelaCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRelaCode());
				if (get(i).getManageComGrp() == null || get(i).getManageComGrp().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getManageComGrp());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getSaleChnl());
				pstmt.setInt(6, get(i).getMinAppntAge());
				pstmt.setInt(7, get(i).getMaxAppntAge());
				pstmt.setInt(8, get(i).getMaxInsuredAge());
				pstmt.setInt(9, get(i).getMinInsuredAge());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRiskCode());
				if (get(i).getRelaRiskCode() == null || get(i).getRelaRiskCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRelaRiskCode());
				if (get(i).getRelaCode() == null || get(i).getRelaCode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getRelaCode());
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
			tError.moduleName = "LNPRiskRelaDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskRela VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRelaRiskCode() == null || get(i).getRelaRiskCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRelaRiskCode());
				if (get(i).getRelaCode() == null || get(i).getRelaCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getRelaCode());
				if (get(i).getManageComGrp() == null || get(i).getManageComGrp().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getManageComGrp());
				if (get(i).getSaleChnl() == null || get(i).getSaleChnl().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getSaleChnl());
				pstmt.setInt(6, get(i).getMinAppntAge());
				pstmt.setInt(7, get(i).getMaxAppntAge());
				pstmt.setInt(8, get(i).getMaxInsuredAge());
				pstmt.setInt(9, get(i).getMinInsuredAge());
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
			tError.moduleName = "LNPRiskRelaDBSet";
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
