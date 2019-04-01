// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCodeDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPCodeDBSet extends LNPCodeSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPCodeDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPCode");
		mflag = true;
	}

	public LNPCodeDBSet()
	{
		mflag = false;
		db = new DBOper("LNPCode");
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
			tError.moduleName = "LNPCodeDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCode WHERE  CodeType = ? AND Code = ?");
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
			tError.moduleName = "LNPCodeDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPCode SET  CodeType = ? , Code = ? , CodeName = ? , CodeAlias = ? , ComCode = ? , OtherSign = ? WHERE  CodeType = ? AND Code = ?");
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
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getComCode());
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
			tError.moduleName = "LNPCodeDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCode VALUES( ? , ? , ? , ? , ? , ?)");
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
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getComCode());
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
			tError.moduleName = "LNPCodeDBSet";
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
