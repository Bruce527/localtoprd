// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyGetDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPDutyGetSchema;
import com.sinosoft.banklns.lis.vschema.LNPDutyGetSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPDutyGetDBSet extends LNPDutyGetSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPDutyGetDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPDutyGet");
		mflag = true;
	}

	public LNPDutyGetDBSet()
	{
		mflag = false;
		db = new DBOper("LNPDutyGet");
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
			tError.moduleName = "LNPDutyGetDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPDutyGet WHERE  GetDutyCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGetDutyCode() == null || get(i).getGetDutyCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGetDutyCode());
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
			tError.moduleName = "LNPDutyGetDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPDutyGet SET  GetDutyCode = ? , GetDutyName = ? , Type = ? , GetIntv = ? , DefaultVal = ? , CalCode = ? , CnterCalCode = ? , OthCalCode = ? , GetYear = ? , GetYearFlag = ? , StartDateCalRef = ? , StartDateCalMode = ? , MinGetStartPeriod = ? , GetEndPeriod = ? , GetEndUnit = ? , EndDateCalRef = ? , EndDateCalMode = ? , MaxGetEndPeriod = ? , AddFlag = ? , SexRelaFlag = ? , UnitAppRelaFlag = ? , AddAmntFlag = ? , DiscntFlag = ? , InterestFlag = ? , ShareFlag = ? , InpFlag = ? , BnfFlag = ? , UrgeGetFlag = ? , DeadValiFlag = ? , GetInitFlag = ? , GetLimit = ? , MaxGet = ? , GetRate = ? , NeedAcc = ? , CanGet = ? , NeedCancelAcc = ? , GetType1 = ? , ZeroFlag = ? , GetType2 = ? WHERE  GetDutyCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGetDutyCode() == null || get(i).getGetDutyCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGetDutyCode());
				if (get(i).getGetDutyName() == null || get(i).getGetDutyName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getGetDutyName());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getType());
				pstmt.setInt(4, get(i).getGetIntv());
				pstmt.setDouble(5, get(i).getDefaultVal());
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getCalCode());
				if (get(i).getCnterCalCode() == null || get(i).getCnterCalCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getCnterCalCode());
				if (get(i).getOthCalCode() == null || get(i).getOthCalCode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getOthCalCode());
				pstmt.setInt(9, get(i).getGetYear());
				if (get(i).getGetYearFlag() == null || get(i).getGetYearFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getGetYearFlag());
				if (get(i).getStartDateCalRef() == null || get(i).getStartDateCalRef().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getStartDateCalRef());
				if (get(i).getStartDateCalMode() == null || get(i).getStartDateCalMode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getStartDateCalMode());
				pstmt.setInt(13, get(i).getMinGetStartPeriod());
				pstmt.setInt(14, get(i).getGetEndPeriod());
				if (get(i).getGetEndUnit() == null || get(i).getGetEndUnit().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getGetEndUnit());
				if (get(i).getEndDateCalRef() == null || get(i).getEndDateCalRef().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getEndDateCalRef());
				if (get(i).getEndDateCalMode() == null || get(i).getEndDateCalMode().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getEndDateCalMode());
				pstmt.setInt(18, get(i).getMaxGetEndPeriod());
				if (get(i).getAddFlag() == null || get(i).getAddFlag().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getAddFlag());
				if (get(i).getSexRelaFlag() == null || get(i).getSexRelaFlag().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getSexRelaFlag());
				if (get(i).getUnitAppRelaFlag() == null || get(i).getUnitAppRelaFlag().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getUnitAppRelaFlag());
				if (get(i).getAddAmntFlag() == null || get(i).getAddAmntFlag().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getAddAmntFlag());
				if (get(i).getDiscntFlag() == null || get(i).getDiscntFlag().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getDiscntFlag());
				if (get(i).getInterestFlag() == null || get(i).getInterestFlag().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getInterestFlag());
				if (get(i).getShareFlag() == null || get(i).getShareFlag().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getShareFlag());
				if (get(i).getInpFlag() == null || get(i).getInpFlag().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getInpFlag());
				if (get(i).getBnfFlag() == null || get(i).getBnfFlag().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getBnfFlag());
				if (get(i).getUrgeGetFlag() == null || get(i).getUrgeGetFlag().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getUrgeGetFlag());
				if (get(i).getDeadValiFlag() == null || get(i).getDeadValiFlag().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getDeadValiFlag());
				if (get(i).getGetInitFlag() == null || get(i).getGetInitFlag().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getGetInitFlag());
				pstmt.setDouble(31, get(i).getGetLimit());
				pstmt.setDouble(32, get(i).getMaxGet());
				pstmt.setDouble(33, get(i).getGetRate());
				if (get(i).getNeedAcc() == null || get(i).getNeedAcc().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getNeedAcc());
				if (get(i).getCanGet() == null || get(i).getCanGet().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getCanGet());
				if (get(i).getNeedCancelAcc() == null || get(i).getNeedCancelAcc().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getNeedCancelAcc());
				if (get(i).getGetType1() == null || get(i).getGetType1().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getGetType1());
				if (get(i).getZeroFlag() == null || get(i).getZeroFlag().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getZeroFlag());
				if (get(i).getGetType2() == null || get(i).getGetType2().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getGetType2());
				if (get(i).getGetDutyCode() == null || get(i).getGetDutyCode().equals("null"))
					pstmt.setString(40, null);
				else
					pstmt.setString(40, get(i).getGetDutyCode());
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
			tError.moduleName = "LNPDutyGetDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPDutyGet VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGetDutyCode() == null || get(i).getGetDutyCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGetDutyCode());
				if (get(i).getGetDutyName() == null || get(i).getGetDutyName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getGetDutyName());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getType());
				pstmt.setInt(4, get(i).getGetIntv());
				pstmt.setDouble(5, get(i).getDefaultVal());
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getCalCode());
				if (get(i).getCnterCalCode() == null || get(i).getCnterCalCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getCnterCalCode());
				if (get(i).getOthCalCode() == null || get(i).getOthCalCode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getOthCalCode());
				pstmt.setInt(9, get(i).getGetYear());
				if (get(i).getGetYearFlag() == null || get(i).getGetYearFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getGetYearFlag());
				if (get(i).getStartDateCalRef() == null || get(i).getStartDateCalRef().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getStartDateCalRef());
				if (get(i).getStartDateCalMode() == null || get(i).getStartDateCalMode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getStartDateCalMode());
				pstmt.setInt(13, get(i).getMinGetStartPeriod());
				pstmt.setInt(14, get(i).getGetEndPeriod());
				if (get(i).getGetEndUnit() == null || get(i).getGetEndUnit().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getGetEndUnit());
				if (get(i).getEndDateCalRef() == null || get(i).getEndDateCalRef().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getEndDateCalRef());
				if (get(i).getEndDateCalMode() == null || get(i).getEndDateCalMode().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getEndDateCalMode());
				pstmt.setInt(18, get(i).getMaxGetEndPeriod());
				if (get(i).getAddFlag() == null || get(i).getAddFlag().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getAddFlag());
				if (get(i).getSexRelaFlag() == null || get(i).getSexRelaFlag().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getSexRelaFlag());
				if (get(i).getUnitAppRelaFlag() == null || get(i).getUnitAppRelaFlag().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getUnitAppRelaFlag());
				if (get(i).getAddAmntFlag() == null || get(i).getAddAmntFlag().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getAddAmntFlag());
				if (get(i).getDiscntFlag() == null || get(i).getDiscntFlag().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getDiscntFlag());
				if (get(i).getInterestFlag() == null || get(i).getInterestFlag().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getInterestFlag());
				if (get(i).getShareFlag() == null || get(i).getShareFlag().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getShareFlag());
				if (get(i).getInpFlag() == null || get(i).getInpFlag().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getInpFlag());
				if (get(i).getBnfFlag() == null || get(i).getBnfFlag().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getBnfFlag());
				if (get(i).getUrgeGetFlag() == null || get(i).getUrgeGetFlag().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getUrgeGetFlag());
				if (get(i).getDeadValiFlag() == null || get(i).getDeadValiFlag().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getDeadValiFlag());
				if (get(i).getGetInitFlag() == null || get(i).getGetInitFlag().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getGetInitFlag());
				pstmt.setDouble(31, get(i).getGetLimit());
				pstmt.setDouble(32, get(i).getMaxGet());
				pstmt.setDouble(33, get(i).getGetRate());
				if (get(i).getNeedAcc() == null || get(i).getNeedAcc().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getNeedAcc());
				if (get(i).getCanGet() == null || get(i).getCanGet().equals("null"))
					pstmt.setString(35, null);
				else
					pstmt.setString(35, get(i).getCanGet());
				if (get(i).getNeedCancelAcc() == null || get(i).getNeedCancelAcc().equals("null"))
					pstmt.setString(36, null);
				else
					pstmt.setString(36, get(i).getNeedCancelAcc());
				if (get(i).getGetType1() == null || get(i).getGetType1().equals("null"))
					pstmt.setString(37, null);
				else
					pstmt.setString(37, get(i).getGetType1());
				if (get(i).getZeroFlag() == null || get(i).getZeroFlag().equals("null"))
					pstmt.setString(38, null);
				else
					pstmt.setString(38, get(i).getZeroFlag());
				if (get(i).getGetType2() == null || get(i).getGetType2().equals("null"))
					pstmt.setString(39, null);
				else
					pstmt.setString(39, get(i).getGetType2());
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
			tError.moduleName = "LNPDutyGetDBSet";
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
