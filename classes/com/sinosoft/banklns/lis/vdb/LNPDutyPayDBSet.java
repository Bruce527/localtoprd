// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyPayDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPDutyPaySchema;
import com.sinosoft.banklns.lis.vschema.LNPDutyPaySet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPDutyPayDBSet extends LNPDutyPaySet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPDutyPayDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPDutyPay");
		mflag = true;
	}

	public LNPDutyPayDBSet()
	{
		mflag = false;
		db = new DBOper("LNPDutyPay");
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
			tError.moduleName = "LNPDutyPayDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPDutyPay WHERE  PayPlanCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getPayPlanCode() == null || get(i).getPayPlanCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getPayPlanCode());
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
			tError.moduleName = "LNPDutyPayDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPDutyPay SET  PayPlanCode = ? , PayPlanName = ? , Type = ? , PayIntv = ? , PayEndYearFlag = ? , PayEndYear = ? , PayEndDateCalRef = ? , PayEndDateCalMode = ? , DefaultVal = ? , CalCode = ? , CnterCalCode = ? , OthCalCode = ? , Rate = ? , MinPay = ? , AssuYield = ? , FeeRate = ? , PayToDateCalMode = ? , UrgePayFlag = ? , PayLackFlag = ? , PayOverFlag = ? , PayOverDeal = ? , AvoidPayFlag = ? , GracePeriod = ? , PubFlag = ? , ZeroFlag = ? , NeedAcc = ? , PayAimClass = ? WHERE  PayPlanCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getPayPlanCode() == null || get(i).getPayPlanCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getPayPlanCode());
				if (get(i).getPayPlanName() == null || get(i).getPayPlanName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getPayPlanName());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getType());
				pstmt.setInt(4, get(i).getPayIntv());
				if (get(i).getPayEndYearFlag() == null || get(i).getPayEndYearFlag().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPayEndYearFlag());
				pstmt.setInt(6, get(i).getPayEndYear());
				if (get(i).getPayEndDateCalRef() == null || get(i).getPayEndDateCalRef().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getPayEndDateCalRef());
				if (get(i).getPayEndDateCalMode() == null || get(i).getPayEndDateCalMode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getPayEndDateCalMode());
				pstmt.setDouble(9, get(i).getDefaultVal());
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getCalCode());
				if (get(i).getCnterCalCode() == null || get(i).getCnterCalCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCnterCalCode());
				if (get(i).getOthCalCode() == null || get(i).getOthCalCode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOthCalCode());
				pstmt.setDouble(13, get(i).getRate());
				pstmt.setDouble(14, get(i).getMinPay());
				pstmt.setDouble(15, get(i).getAssuYield());
				pstmt.setDouble(16, get(i).getFeeRate());
				if (get(i).getPayToDateCalMode() == null || get(i).getPayToDateCalMode().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getPayToDateCalMode());
				if (get(i).getUrgePayFlag() == null || get(i).getUrgePayFlag().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getUrgePayFlag());
				if (get(i).getPayLackFlag() == null || get(i).getPayLackFlag().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getPayLackFlag());
				if (get(i).getPayOverFlag() == null || get(i).getPayOverFlag().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getPayOverFlag());
				if (get(i).getPayOverDeal() == null || get(i).getPayOverDeal().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getPayOverDeal());
				if (get(i).getAvoidPayFlag() == null || get(i).getAvoidPayFlag().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getAvoidPayFlag());
				pstmt.setInt(23, get(i).getGracePeriod());
				if (get(i).getPubFlag() == null || get(i).getPubFlag().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getPubFlag());
				if (get(i).getZeroFlag() == null || get(i).getZeroFlag().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getZeroFlag());
				if (get(i).getNeedAcc() == null || get(i).getNeedAcc().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getNeedAcc());
				if (get(i).getPayAimClass() == null || get(i).getPayAimClass().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getPayAimClass());
				if (get(i).getPayPlanCode() == null || get(i).getPayPlanCode().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getPayPlanCode());
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
			tError.moduleName = "LNPDutyPayDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPDutyPay VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getPayPlanCode() == null || get(i).getPayPlanCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getPayPlanCode());
				if (get(i).getPayPlanName() == null || get(i).getPayPlanName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getPayPlanName());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getType());
				pstmt.setInt(4, get(i).getPayIntv());
				if (get(i).getPayEndYearFlag() == null || get(i).getPayEndYearFlag().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getPayEndYearFlag());
				pstmt.setInt(6, get(i).getPayEndYear());
				if (get(i).getPayEndDateCalRef() == null || get(i).getPayEndDateCalRef().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getPayEndDateCalRef());
				if (get(i).getPayEndDateCalMode() == null || get(i).getPayEndDateCalMode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getPayEndDateCalMode());
				pstmt.setDouble(9, get(i).getDefaultVal());
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getCalCode());
				if (get(i).getCnterCalCode() == null || get(i).getCnterCalCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCnterCalCode());
				if (get(i).getOthCalCode() == null || get(i).getOthCalCode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOthCalCode());
				pstmt.setDouble(13, get(i).getRate());
				pstmt.setDouble(14, get(i).getMinPay());
				pstmt.setDouble(15, get(i).getAssuYield());
				pstmt.setDouble(16, get(i).getFeeRate());
				if (get(i).getPayToDateCalMode() == null || get(i).getPayToDateCalMode().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getPayToDateCalMode());
				if (get(i).getUrgePayFlag() == null || get(i).getUrgePayFlag().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getUrgePayFlag());
				if (get(i).getPayLackFlag() == null || get(i).getPayLackFlag().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getPayLackFlag());
				if (get(i).getPayOverFlag() == null || get(i).getPayOverFlag().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getPayOverFlag());
				if (get(i).getPayOverDeal() == null || get(i).getPayOverDeal().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getPayOverDeal());
				if (get(i).getAvoidPayFlag() == null || get(i).getAvoidPayFlag().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getAvoidPayFlag());
				pstmt.setInt(23, get(i).getGracePeriod());
				if (get(i).getPubFlag() == null || get(i).getPubFlag().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getPubFlag());
				if (get(i).getZeroFlag() == null || get(i).getZeroFlag().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getZeroFlag());
				if (get(i).getNeedAcc() == null || get(i).getNeedAcc().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getNeedAcc());
				if (get(i).getPayAimClass() == null || get(i).getPayAimClass().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getPayAimClass());
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
			tError.moduleName = "LNPDutyPayDBSet";
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
