// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskToInterfaceDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPRiskToInterfaceSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskToInterfaceSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPRiskToInterfaceDBSet extends LNPRiskToInterfaceSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPRiskToInterfaceDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPRiskToInterface");
		mflag = true;
	}

	public LNPRiskToInterfaceDBSet()
	{
		mflag = false;
		db = new DBOper("LNPRiskToInterface");
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
			tError.moduleName = "LNPRiskToInterfaceDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskToInterface WHERE  CodeType = ? AND Code = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCodeType() == null || get(i).getCodeType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCodeType());
				if (get(i).getCode() == null || get(i).getCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCode());
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
			tError.moduleName = "LNPRiskToInterfaceDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskToInterface SET  CodeType = ? , Code = ? , CodeName = ? , CodeAlias = ? , CodeBak = ? , OtherSign = ? WHERE  CodeType = ? AND Code = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCodeType() == null || get(i).getCodeType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCodeType());
				if (get(i).getCode() == null || get(i).getCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCode());
				if (get(i).getCodeName() == null || get(i).getCodeName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCodeName());
				if (get(i).getCodeAlias() == null || get(i).getCodeAlias().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getCodeAlias());
				if (get(i).getCodeBak() == null || get(i).getCodeBak().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getCodeBak());
				if (get(i).getOtherSign() == null || get(i).getOtherSign().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOtherSign());
				if (get(i).getCodeType() == null || get(i).getCodeType().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getCodeType());
				if (get(i).getCode() == null || get(i).getCode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCode());
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
			tError.moduleName = "LNPRiskToInterfaceDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskToInterface VALUES( ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCodeType() == null || get(i).getCodeType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCodeType());
				if (get(i).getCode() == null || get(i).getCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCode());
				if (get(i).getCodeName() == null || get(i).getCodeName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCodeName());
				if (get(i).getCodeAlias() == null || get(i).getCodeAlias().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getCodeAlias());
				if (get(i).getCodeBak() == null || get(i).getCodeBak().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getCodeBak());
				if (get(i).getOtherSign() == null || get(i).getOtherSign().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOtherSign());
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
			tError.moduleName = "LNPRiskToInterfaceDBSet";
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
