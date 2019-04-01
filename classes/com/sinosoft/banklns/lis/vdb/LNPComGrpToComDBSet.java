// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPComGrpToComDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPComGrpToComSchema;
import com.sinosoft.banklns.lis.vschema.LNPComGrpToComSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPComGrpToComDBSet extends LNPComGrpToComSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPComGrpToComDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPComGrpToCom");
		mflag = true;
	}

	public LNPComGrpToComDBSet()
	{
		mflag = false;
		db = new DBOper("LNPComGrpToCom");
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
			tError.moduleName = "LNPComGrpToComDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPComGrpToCom WHERE  ComGrpCode = ? AND ComCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getComGrpCode() == null || get(i).getComGrpCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getComGrpCode());
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getComCode());
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
			tError.moduleName = "LNPComGrpToComDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPComGrpToCom SET  ComGrpCode = ? , ComCode = ? , ComCodeType = ? WHERE  ComGrpCode = ? AND ComCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getComGrpCode() == null || get(i).getComGrpCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getComGrpCode());
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getComCode());
				if (get(i).getComCodeType() == null || get(i).getComCodeType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getComCodeType());
				if (get(i).getComGrpCode() == null || get(i).getComGrpCode().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getComGrpCode());
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getComCode());
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
			tError.moduleName = "LNPComGrpToComDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPComGrpToCom VALUES( ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getComGrpCode() == null || get(i).getComGrpCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getComGrpCode());
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getComCode());
				if (get(i).getComCodeType() == null || get(i).getComCodeType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getComCodeType());
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
			tError.moduleName = "LNPComGrpToComDBSet";
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
