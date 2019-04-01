// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskCodeDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskCodeSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskCodeSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskCodeDBSet extends LNPRiskCodeSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskCodeDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskCode");
		mflag = true;
	}

	public LNPRiskCodeDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskCode");
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
			tError.moduleName = "LNPRiskCodeDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskCode WHERE  RiskCode = ?");
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
			tError.moduleName = "LNPRiskCodeDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskCode SET  RiskCode = ? , RiskVer = ? , RiskName = ? , KindCode = ? , RiskType = ? , SysRiskCode = ? , MappingRiskCode = ? , RiskCodeBy1 = ? , RiskCodeBy2 = ? , RiskCodeBy3 = ? , RiskCodeBy4 = ? , RiskCodeBy5 = ? WHERE  RiskCode = ?");
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
				if (get(i).getKindCode() == null || get(i).getKindCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getKindCode());
				if (get(i).getRiskType() == null || get(i).getRiskType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRiskType());
				if (get(i).getSysRiskCode() == null || get(i).getSysRiskCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getSysRiskCode());
				if (get(i).getMappingRiskCode() == null || get(i).getMappingRiskCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getMappingRiskCode());
				if (get(i).getRiskCodeBy1() == null || get(i).getRiskCodeBy1().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getRiskCodeBy1());
				if (get(i).getRiskCodeBy2() == null || get(i).getRiskCodeBy2().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getRiskCodeBy2());
				if (get(i).getRiskCodeBy3() == null || get(i).getRiskCodeBy3().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRiskCodeBy3());
				if (get(i).getRiskCodeBy4() == null || get(i).getRiskCodeBy4().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRiskCodeBy4());
				if (get(i).getRiskCodeBy5() == null || get(i).getRiskCodeBy5().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getRiskCodeBy5());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRiskCode());
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
			tError.moduleName = "LNPRiskCodeDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskCode VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getKindCode() == null || get(i).getKindCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getKindCode());
				if (get(i).getRiskType() == null || get(i).getRiskType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRiskType());
				if (get(i).getSysRiskCode() == null || get(i).getSysRiskCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getSysRiskCode());
				if (get(i).getMappingRiskCode() == null || get(i).getMappingRiskCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getMappingRiskCode());
				if (get(i).getRiskCodeBy1() == null || get(i).getRiskCodeBy1().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getRiskCodeBy1());
				if (get(i).getRiskCodeBy2() == null || get(i).getRiskCodeBy2().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getRiskCodeBy2());
				if (get(i).getRiskCodeBy3() == null || get(i).getRiskCodeBy3().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRiskCodeBy3());
				if (get(i).getRiskCodeBy4() == null || get(i).getRiskCodeBy4().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRiskCodeBy4());
				if (get(i).getRiskCodeBy5() == null || get(i).getRiskCodeBy5().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getRiskCodeBy5());
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
			tError.moduleName = "LNPRiskCodeDBSet";
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
