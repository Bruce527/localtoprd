// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAccountDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPAccountSchema;
import com.sinosoft.banklns.lis.vschema.LNPAccountSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPAccountDBSet extends LNPAccountSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPAccountDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPAccount");
		mflag = true;
	}

	public LNPAccountDBSet()
	{
		mflag = false;
		db = new DBOper("LNPAccount");
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
			tError.moduleName = "LNPAccountDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPAccount WHERE  CustomerNo = ? AND BankCode = ? AND BankAccNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerNo());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getBankAccNo());
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
			tError.moduleName = "LNPAccountDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPAccount SET  CustomerId = ? , CustomerNo = ? , AccKind = ? , BankCode = ? , BankAccNo = ? , AccName = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CustomerNo = ? AND BankCode = ? AND BankAccNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerId());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerNo());
				if (get(i).getAccKind() == null || get(i).getAccKind().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAccKind());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBankAccNo());
				if (get(i).getAccName() == null || get(i).getAccName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAccName());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyTime());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCustomerNo());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getBankAccNo());
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
			tError.moduleName = "LNPAccountDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPAccount VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerId());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerNo());
				if (get(i).getAccKind() == null || get(i).getAccKind().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAccKind());
				if (get(i).getBankCode() == null || get(i).getBankCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getBankCode());
				if (get(i).getBankAccNo() == null || get(i).getBankAccNo().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getBankAccNo());
				if (get(i).getAccName() == null || get(i).getAccName().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAccName());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyTime());
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
			tError.moduleName = "LNPAccountDBSet";
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
