// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPDutySchema;
import com.sinosoft.banklns.lis.vschema.LNPDutySet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPDutyDBSet extends LNPDutySet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPDutyDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPDuty");
		mflag = true;
	}

	public LNPDutyDBSet()
	{
		mflag = false;
		db = new DBOper("LNPDuty");
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
			tError.moduleName = "LNPDutyDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPDuty WHERE  DutyCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getDutyCode() == null || get(i).getDutyCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getDutyCode());
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
			tError.moduleName = "LNPDutyDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPDuty SET  DutyCode = ? , DutyName = ? , PayEndYear = ? , PayEndYearFlag = ? , PayEndDateCalRef = ? , PayEndDateCalMode = ? , GetYear = ? , GetYearFlag = ? , InsuYear = ? , InsuYearFlag = ? , AcciYear = ? , AcciYearFlag = ? , CalMode = ? , PayEndYearRela = ? , GetYearRela = ? , InsuYearRela = ? , BasicCalCode = ? , RiskCalCode = ? , AmntFlag = ? , VPU = ? , AddFeeFlag = ? , EndDateCalMode = ? WHERE  DutyCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getDutyCode() == null || get(i).getDutyCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getDutyCode());
				if (get(i).getDutyName() == null || get(i).getDutyName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getDutyName());
				pstmt.setInt(3, get(i).getPayEndYear());
				if (get(i).getPayEndYearFlag() == null || get(i).getPayEndYearFlag().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPayEndYearFlag());
				if (get(i).getPayEndDateCalRef() == null || get(i).getPayEndDateCalRef().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPayEndDateCalRef());
				if (get(i).getPayEndDateCalMode() == null || get(i).getPayEndDateCalMode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getPayEndDateCalMode());
				pstmt.setInt(7, get(i).getGetYear());
				if (get(i).getGetYearFlag() == null || get(i).getGetYearFlag().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getGetYearFlag());
				pstmt.setInt(9, get(i).getInsuYear());
				if (get(i).getInsuYearFlag() == null || get(i).getInsuYearFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getInsuYearFlag());
				pstmt.setInt(11, get(i).getAcciYear());
				if (get(i).getAcciYearFlag() == null || get(i).getAcciYearFlag().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getAcciYearFlag());
				if (get(i).getCalMode() == null || get(i).getCalMode().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCalMode());
				if (get(i).getPayEndYearRela() == null || get(i).getPayEndYearRela().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getPayEndYearRela());
				if (get(i).getGetYearRela() == null || get(i).getGetYearRela().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getGetYearRela());
				if (get(i).getInsuYearRela() == null || get(i).getInsuYearRela().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getInsuYearRela());
				if (get(i).getBasicCalCode() == null || get(i).getBasicCalCode().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getBasicCalCode());
				if (get(i).getRiskCalCode() == null || get(i).getRiskCalCode().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getRiskCalCode());
				if (get(i).getAmntFlag() == null || get(i).getAmntFlag().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getAmntFlag());
				pstmt.setDouble(20, get(i).getVPU());
				if (get(i).getAddFeeFlag() == null || get(i).getAddFeeFlag().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getAddFeeFlag());
				if (get(i).getEndDateCalMode() == null || get(i).getEndDateCalMode().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getEndDateCalMode());
				if (get(i).getDutyCode() == null || get(i).getDutyCode().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getDutyCode());
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
			tError.moduleName = "LNPDutyDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPDuty VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getDutyCode() == null || get(i).getDutyCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getDutyCode());
				if (get(i).getDutyName() == null || get(i).getDutyName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getDutyName());
				pstmt.setInt(3, get(i).getPayEndYear());
				if (get(i).getPayEndYearFlag() == null || get(i).getPayEndYearFlag().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPayEndYearFlag());
				if (get(i).getPayEndDateCalRef() == null || get(i).getPayEndDateCalRef().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPayEndDateCalRef());
				if (get(i).getPayEndDateCalMode() == null || get(i).getPayEndDateCalMode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getPayEndDateCalMode());
				pstmt.setInt(7, get(i).getGetYear());
				if (get(i).getGetYearFlag() == null || get(i).getGetYearFlag().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getGetYearFlag());
				pstmt.setInt(9, get(i).getInsuYear());
				if (get(i).getInsuYearFlag() == null || get(i).getInsuYearFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getInsuYearFlag());
				pstmt.setInt(11, get(i).getAcciYear());
				if (get(i).getAcciYearFlag() == null || get(i).getAcciYearFlag().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getAcciYearFlag());
				if (get(i).getCalMode() == null || get(i).getCalMode().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCalMode());
				if (get(i).getPayEndYearRela() == null || get(i).getPayEndYearRela().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getPayEndYearRela());
				if (get(i).getGetYearRela() == null || get(i).getGetYearRela().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getGetYearRela());
				if (get(i).getInsuYearRela() == null || get(i).getInsuYearRela().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getInsuYearRela());
				if (get(i).getBasicCalCode() == null || get(i).getBasicCalCode().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getBasicCalCode());
				if (get(i).getRiskCalCode() == null || get(i).getRiskCalCode().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getRiskCalCode());
				if (get(i).getAmntFlag() == null || get(i).getAmntFlag().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getAmntFlag());
				pstmt.setDouble(20, get(i).getVPU());
				if (get(i).getAddFeeFlag() == null || get(i).getAddFeeFlag().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getAddFeeFlag());
				if (get(i).getEndDateCalMode() == null || get(i).getEndDateCalMode().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getEndDateCalMode());
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
			tError.moduleName = "LNPDutyDBSet";
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
