// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskScreenDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskScreenSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskScreenSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskScreenDBSet extends LNPRiskScreenSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskScreenDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskScreen");
		mflag = true;
	}

	public LNPRiskScreenDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskScreen");
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
			tError.moduleName = "LNPRiskScreenDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskScreen WHERE  RiskCode = ? AND CtrlIndex = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				pstmt.setInt(2, get(i).getCtrlIndex());
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
			tError.moduleName = "LNPRiskScreenDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskScreen SET  RiskCode = ? , CtrlIndex = ? , CtrlType = ? , CtrlCode = ? , CtrlName = ? , CtrlLevel = ? , CtrlProperty = ? , CtrlAlignX = ? , CtrlAlignY = ? , CtrlHorizontal = ? , CtrlVertical = ? , CtrlBackground = ? , LabelAlignX = ? , LabelAlignY = ? , LabelHorizontal = ? , LabelVertical = ? , LabelBackground = ? , DefaultValue = ? , DefaultSql = ? , CtrlProperty1 = ? , CtrlProperty2 = ? , Noti = ? WHERE  RiskCode = ? AND CtrlIndex = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				pstmt.setInt(2, get(i).getCtrlIndex());
				if (get(i).getCtrlType() == null || get(i).getCtrlType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCtrlType());
				if (get(i).getCtrlCode() == null || get(i).getCtrlCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getCtrlCode());
				if (get(i).getCtrlName() == null || get(i).getCtrlName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getCtrlName());
				if (get(i).getCtrlLevel() == null || get(i).getCtrlLevel().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getCtrlLevel());
				if (get(i).getCtrlProperty() == null || get(i).getCtrlProperty().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getCtrlProperty());
				pstmt.setInt(8, get(i).getCtrlAlignX());
				pstmt.setInt(9, get(i).getCtrlAlignY());
				pstmt.setInt(10, get(i).getCtrlHorizontal());
				pstmt.setInt(11, get(i).getCtrlVertical());
				if (get(i).getCtrlBackground() == null || get(i).getCtrlBackground().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCtrlBackground());
				pstmt.setInt(13, get(i).getLabelAlignX());
				pstmt.setInt(14, get(i).getLabelAlignY());
				pstmt.setInt(15, get(i).getLabelHorizontal());
				pstmt.setInt(16, get(i).getLabelVertical());
				if (get(i).getLabelBackground() == null || get(i).getLabelBackground().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getLabelBackground());
				if (get(i).getDefaultValue() == null || get(i).getDefaultValue().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getDefaultValue());
				if (get(i).getDefaultSql() == null || get(i).getDefaultSql().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getDefaultSql());
				if (get(i).getCtrlProperty1() == null || get(i).getCtrlProperty1().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getCtrlProperty1());
				if (get(i).getCtrlProperty2() == null || get(i).getCtrlProperty2().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getCtrlProperty2());
				if (get(i).getNoti() == null || get(i).getNoti().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getNoti());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getRiskCode());
				pstmt.setInt(24, get(i).getCtrlIndex());
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
			tError.moduleName = "LNPRiskScreenDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskScreen VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				pstmt.setInt(2, get(i).getCtrlIndex());
				if (get(i).getCtrlType() == null || get(i).getCtrlType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCtrlType());
				if (get(i).getCtrlCode() == null || get(i).getCtrlCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getCtrlCode());
				if (get(i).getCtrlName() == null || get(i).getCtrlName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getCtrlName());
				if (get(i).getCtrlLevel() == null || get(i).getCtrlLevel().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getCtrlLevel());
				if (get(i).getCtrlProperty() == null || get(i).getCtrlProperty().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getCtrlProperty());
				pstmt.setInt(8, get(i).getCtrlAlignX());
				pstmt.setInt(9, get(i).getCtrlAlignY());
				pstmt.setInt(10, get(i).getCtrlHorizontal());
				pstmt.setInt(11, get(i).getCtrlVertical());
				if (get(i).getCtrlBackground() == null || get(i).getCtrlBackground().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCtrlBackground());
				pstmt.setInt(13, get(i).getLabelAlignX());
				pstmt.setInt(14, get(i).getLabelAlignY());
				pstmt.setInt(15, get(i).getLabelHorizontal());
				pstmt.setInt(16, get(i).getLabelVertical());
				if (get(i).getLabelBackground() == null || get(i).getLabelBackground().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getLabelBackground());
				if (get(i).getDefaultValue() == null || get(i).getDefaultValue().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getDefaultValue());
				if (get(i).getDefaultSql() == null || get(i).getDefaultSql().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getDefaultSql());
				if (get(i).getCtrlProperty1() == null || get(i).getCtrlProperty1().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getCtrlProperty1());
				if (get(i).getCtrlProperty2() == null || get(i).getCtrlProperty2().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getCtrlProperty2());
				if (get(i).getNoti() == null || get(i).getNoti().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getNoti());
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
			tError.moduleName = "LNPRiskScreenDBSet";
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
